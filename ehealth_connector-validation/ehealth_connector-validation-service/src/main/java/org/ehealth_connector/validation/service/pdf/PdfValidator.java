package org.ehealth_connector.validation.service.pdf;

import java.io.File;
import java.io.FileInputStream;
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

	public final static String ERR_NOT_INSTALLED = "PdfValidatorAPI not installed";
	public final static String ERR_NOT_INITIALIZED = "PdfValidatorAPI initialization failed";
	public final static String ERR_INVALID_LICENSE = "Invalid PdfValidatorAPI license";

	private final Configuration config;
	private String pdfLevel;
	private PdfValidationResult pdfValidationResult;

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	public PdfValidator(Configuration config) {
		this.config = config;
		this.pdfLevel = config.getPdfLevel();
	}

	public String getPdfLevel() {
		return pdfLevel;
	}

	public PdfValidationResult getPdfValidationResults() {
		return pdfValidationResult;
	}

	public void setPdfValidationResults(PdfValidationResult pdfValidationResults) {
		this.pdfValidationResult = pdfValidationResults;
	}

	public void validateCdaFile(File cdaFile)
			throws ConfigurationException, SaxonApiException, IOException {

		pdfValidationResult = new PdfValidationResult();
		final Processor proc = new Processor(false);

		final DocumentBuilder builder = proc.newDocumentBuilder();
		builder.setLineNumbering(true);
		XdmNode hl7Doc;

		hl7Doc = builder.build(new StreamSource(new FileInputStream(cdaFile)));

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

	private PdfValidationResult validatePdf(String pdfStrB64, String lineNumber)
			throws IOException, ConfigurationException {

		pdfValidationResult.resetIsDone();
		PdfValidatorAPI pdfValidator = null;
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
			pdfValidator.setNoTempFiles(true);
			final String licenseKey = config.getLicenseKey();
			if (!PdfValidatorAPI.setLicenseKey(licenseKey)) {
				String errorMsg = ERR_INVALID_LICENSE + " (" + licenseKey + ")";
				log.error(errorMsg);
				PdfValidationResultEntry failure = new PdfValidationResultEntry();
				failure.setErrMsg(errorMsg, SEVERITY.Error);
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

			int comlianceLevel = COMPLIANCE.ePDFUnk;
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
			pdfValidator.open(DatatypeConverter.parseBase64Binary(pdfStrB64), "", comlianceLevel);

			pdfValidator.validate();
			pdfValidationResult.setIsDone();
			PdfError err = pdfValidator.getFirstError();
			if (err != null) {
				while (err != null) {
					final String sErrorMsg = err.getMessage();
					final int errorCode = err.getErrorCode();
					// log.info("PDF Validation Message: " + errorCode + " "
					// + sErrorMsg);
					if (errorCode != -2092890606) {
						final BitSet tempBS = BitSet
								.valueOf(ByteBuffer.allocate(4).putInt(errorCode).array());
						SEVERITY severity = SEVERITY.Information;

						// ErrorCode --> Bit 7 = Error, Bit 23 = Warnung, sonst
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
			}
			pdfValidator.close();
			pdfValidator.destroyObject();
		}
		return pdfValidationResult;
	}

}
