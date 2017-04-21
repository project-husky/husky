/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.validation.service.pdf;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.BitSet;

import javax.xml.bind.DatatypeConverter;
import javax.xml.transform.stream.StreamSource;

import org.ehealth_connector.validation.service.config.Configuration;
import org.ehealth_connector.validation.service.config.ConfigurationException;
import org.ehealth_connector.validation.service.pdf.PdfValidationResultEntry.SEVERITY;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pdftools.NativeLibrary.COMPLIANCE;
import com.pdftools.pdfvalidator.PdfError;
import com.pdftools.pdfvalidator.PdfValidatorAPI;

import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XPathCompiler;
import net.sf.saxon.s9api.XPathSelector;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;

public class PdfValidator {

	/** Not installed error message */
	public final static String ERR_NOT_INSTALLED = "PdfValidatorAPI not installed";

	/** Not initialized error message */
	public final static String ERR_NOT_INITIALIZED = "PdfValidatorAPI initialization failed";

	/** Invalid license error message */
	public final static String ERR_INVALID_LICENSE = "Invalid PdfValidatorAPI license";

	/** Current configuration */
	private final Configuration config;

	/** PDF compliance level as string */
	private String pdfLevel;

	/** PDF compliance level as enum/int */
	private int comlianceLevel = COMPLIANCE.ePDFUnk;

	/** Current PDF validation results */
	private PdfValidationResult pdfValidationResult = null;

	/** PDF validator API */
	private PdfValidatorAPI pdfValidator = null;

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	/** Error Message in case the License is invalid */
	private String licenseErrorMsg = null;

	/**
	 * Default constructor
	 *
	 * @param config
	 *            Current configuration
	 */
	public PdfValidator(Configuration config) {
		this.config = config;
		this.pdfLevel = config.getPdfLevel();
	}

	/**
	 * Gets the PDF compliance level
	 *
	 * @return the PDF compliance level
	 */
	public String getPdfLevel() {
		return pdfLevel;
	}

	/**
	 * Gets the current PDF validation results
	 *
	 * @return the current PDF validation results
	 */
	public PdfValidationResult getPdfValidationResults() {
		return pdfValidationResult;
	}

	/**
	 * Gets the API version of the PDF validator
	 *
	 * @return the API version of the PDF validator
	 */
	public String getPdfValidatorVersion() {
		String retVal = "none";
		if (pdfValidator == null) {
			initialize("none");
		}
		if (pdfValidator != null)
			// TODO ersetzen mit
			// com.pdftools.pdfvalidator.PdfValidatorAPI.getVersion(),
			// sobald 4.8.0 von PDF Tools freigegeben ist.
			retVal = com.pdftools.pdfvalidator.PdfValidatorAPI.VERSION;
		return retVal;
	}

	/**
	 * Initializes the PDF validator
	 *
	 * @param lineNumber
	 *            the line number where the PDF starts within the CDA document
	 */
	private void initialize(String lineNumber) {
		if (pdfValidator == null) {
			log.info("Trying to initialize PdfValidatorAPI...");
			pdfValidationResult = new PdfValidationResult();
			try {
				pdfValidator = new PdfValidatorAPI();
			} catch (UnsatisfiedLinkError ue) {
				String errorMsg = ERR_NOT_INSTALLED + " (" + ue.getMessage() + ")";
				log.error(errorMsg);
				PdfValidationResultEntry failure = new PdfValidationResultEntry();
				failure.setErrMsg(errorMsg, SEVERITY.Error);
				failure.setLineNumber(lineNumber);
				pdfValidationResult.add(failure);
			} catch (NoClassDefFoundError e) {
				String errorMsg = ERR_NOT_INITIALIZED + " (" + e.getMessage() + ")";
				log.error(errorMsg);
				PdfValidationResultEntry failure = new PdfValidationResultEntry();
				failure.setErrMsg(errorMsg, SEVERITY.Error);
				failure.setLineNumber(lineNumber);
				pdfValidationResult.add(failure);
			} catch (ExceptionInInitializerError e) {
				String errorMsg = ERR_NOT_INITIALIZED + " (" + e.getMessage() + ")";
				log.error(errorMsg);
				PdfValidationResultEntry failure = new PdfValidationResultEntry();
				failure.setErrMsg(errorMsg, SEVERITY.Error);
				failure.setLineNumber(lineNumber);
				pdfValidationResult.add(failure);
			}
			if (pdfValidator != null) {
				log.info("PdfValidatorAPI initialized (Version "
						+ com.pdftools.pdfvalidator.PdfValidatorAPI.VERSION + ")");
				pdfValidator.setNoTempFiles(true);
				final String licenseKey = config.getLicenseKey();
				if (!PdfValidatorAPI.setLicenseKey(licenseKey)) {
					licenseErrorMsg = ERR_INVALID_LICENSE + " (" + licenseKey + ")";
					log.error(licenseErrorMsg);
					PdfValidationResultEntry failure = new PdfValidationResultEntry();
					failure.setErrMsg(licenseErrorMsg, SEVERITY.Error);
					failure.setLineNumber(lineNumber);
					pdfValidationResult.add(failure);
				}
			}

			if (pdfValidator != null) {
				String reportingLevel = config.getPdfReportingLevel();
				if (reportingLevel == null)
					reportingLevel = "";
				switch (reportingLevel) {
				case "1":
					pdfValidator.setReportingLevel(1);
					break;
				case "2":
					pdfValidator.setReportingLevel(2);
					break;
				case "3":
					pdfValidator.setReportingLevel(3);
					break;
				default:
					pdfValidator.setReportingLevel(1);
				}

				if (pdfLevel == null)
					pdfLevel = "";
				switch (pdfLevel) {
				case "1a":
					comlianceLevel = COMPLIANCE.ePDFA1a;
					break;
				case "1b":
					comlianceLevel = COMPLIANCE.ePDFA1b;
					break;
				case "2a":
					comlianceLevel = COMPLIANCE.ePDFA2a;
					break;
				case "2b":
					comlianceLevel = COMPLIANCE.ePDFA2b;
					break;
				case "2u":
					comlianceLevel = COMPLIANCE.ePDFA2u;
					break;
				case "3a":
					comlianceLevel = COMPLIANCE.ePDFA3a;
					break;
				case "3b":
					comlianceLevel = COMPLIANCE.ePDFA3b;
					break;
				case "3u":
					comlianceLevel = COMPLIANCE.ePDFA3u;
					break;
				default:
					comlianceLevel = COMPLIANCE.ePDFUnk;
				}
			}
		} else
			log.info("PdfValidatorAPI already initialized...");
	}

	/**
	 * Sets the given PDF validation results
	 *
	 * @param pdfValidationResults
	 *            the desired PDF validation results
	 */
	public void setPdfValidationResults(PdfValidationResult pdfValidationResults) {
		this.pdfValidationResult = pdfValidationResults;
	}

	/**
	 * Validates all PDF within the given CDA document
	 *
	 * @param cdaFile
	 *            the desired CDA document to be validated
	 * @throws ConfigurationException
	 * @throws SaxonApiException
	 * @throws IOException
	 */
	public void validateCda(File cdaFile)
			throws ConfigurationException, SaxonApiException, IOException {
		validateCda(new StreamSource(cdaFile));
	}

	/**
	 * Validates all PDF within the given CDA document
	 *
	 * @param cdaStream
	 *            the desired CDA document to be validated
	 * @throws ConfigurationException
	 * @throws SaxonApiException
	 * @throws IOException
	 */
	public void validateCda(StreamSource cdaStream)
			throws ConfigurationException, SaxonApiException, IOException {

		pdfValidationResult = new PdfValidationResult();

		final Processor proc = new Processor(false);

		final DocumentBuilder builder = proc.newDocumentBuilder();
		builder.setLineNumbering(true);
		XdmNode hl7Doc;

		hl7Doc = builder.build(cdaStream);

		final XPathCompiler xpath = proc.newXPathCompiler();
		xpath.declareNamespace("", "urn:hl7-org:v3");

		final XPathSelector selector = xpath
				.compile("//*[@mediaType='application/pdf' and @representation='B64']").load();
		selector.setContextItem(hl7Doc);
		final XdmValue children = selector.evaluate();
		if (children.size() > 0) {
			for (final XdmItem item : children) {
				final XdmNode nonXMLBodyNode = (XdmNode) item;
				final String pdf = item.getStringValue().trim();
				validatePdf(pdf, String.valueOf(nonXMLBodyNode.getLineNumber()));
			}
		}
	}

	/**
	 * Validates the given PDF
	 *
	 * @param pdfStrB64
	 *            the desired PDF as Base64 string taken from the CDA document
	 * @param lineNumber
	 *            the line number where the PDF starts within the CDA document
	 * @throws IOException
	 * @throws ConfigurationException
	 */
	private void validatePdf(String pdfStrB64, String lineNumber)
			throws IOException, ConfigurationException {

		initialize(lineNumber);
		if (pdfValidator != null) {
			if (licenseErrorMsg == null) {
				pdfValidationResult.resetIsDone();

				pdfValidator.open(DatatypeConverter.parseBase64Binary(pdfStrB64), "",
						comlianceLevel);

				pdfValidator.validate();
				pdfValidationResult.setIsDone();
				PdfError err = pdfValidator.getFirstError();
				if (err != null) {
					while (err != null) {
						final String sErrorMsg = err.getMessage();
						final int errorCode = err.getErrorCode();
						if (errorCode != -2092890606) {
							final BitSet tempBS = BitSet
									.valueOf(ByteBuffer.allocate(4).putInt(errorCode).array());
							SEVERITY severity = SEVERITY.Information;

							// ErrorCode --> Bit 7 = Error, Bit 23 = Warnung,
							// sonst
							// Info
							if (tempBS.get(7))
								severity = SEVERITY.Error;
							if (tempBS.get(23))
								severity = SEVERITY.Warning;
							if ("The XMP property 'pdfaid:conformance' has the invalid value 'B'. Required is 'A'."
									.equals(sErrorMsg)) {
								severity = SEVERITY.CustomWarning;
							}
							PdfValidationResultEntry pdfVResult = new PdfValidationResultEntry();
							pdfVResult.setErrMsg(sErrorMsg, severity);
							pdfVResult.setLineNumber(lineNumber);
							pdfValidationResult.add(pdfVResult);
						}
						err = pdfValidator.getNextError();
					}
				} else {
					PdfValidationResultEntry pdfVResult = new PdfValidationResultEntry();
					pdfVResult.setLineNumber(lineNumber);
					pdfValidationResult.add(pdfVResult);
				}
				pdfValidator.close();
				pdfValidator.destroyObject();
			} else {
				PdfValidationResultEntry pdfVResult = new PdfValidationResultEntry();
				pdfVResult.setErrMsg(licenseErrorMsg, SEVERITY.Error);
				pdfVResult.setLineNumber(lineNumber);
				pdfValidationResult.add(pdfVResult);
				pdfValidationResult.setIsDone();
			}
		}
	}
}
