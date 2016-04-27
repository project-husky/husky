package org.ehealth_connector.validation.service.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

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

	private boolean checkPdfLevel() {
		boolean retVal = false;

		if (pdfLevel == null)
			pdfLevel = "not set";

		// 1a: PDF/A 1a, ISO 19005-1, Level A compliance
		if (!retVal)
			retVal = (pdfLevel.equals("1a"));

		// 1b: PDF/A 1b, ISO 19005-1, Level B compliance
		if (!retVal)
			retVal = (pdfLevel.equals("1b"));

		// 2a: PDF/A 2a, ISO 19005-2, Level A compliance
		if (!retVal)
			retVal = (pdfLevel.equals("2a"));

		// 2b: PDF/A 2b, ISO 19005-2, Level B compliance
		if (!retVal)
			retVal = (pdfLevel.equals("2b"));

		// 2u: PDF/A 2u, ISO 19005-2, Level U compliance
		if (!retVal)
			retVal = (pdfLevel.equals("2u"));

		// 3a: PDF/A 3a, ISO 19005-3, Level A compliance
		if (!retVal)
			retVal = (pdfLevel.equals("3a"));

		// 3b: PDF/A 3b, ISO 19005-3, Level B compliance
		if (!retVal)
			retVal = (pdfLevel.equals("3b"));

		// 3u: PDF/A 3u, ISO 19005-3, Level U compliance
		if (!retVal)
			retVal = (pdfLevel.equals("3u"));

		if (!retVal) {
			String errorMsg = "Invalid pdf-level specified: " + pdfLevel;
			log.error(errorMsg);
			PdfValidationResultEntry failure = new PdfValidationResultEntry();
			failure.setErrMsg(errorMsg, SEVERITY.Error);
			pdfValidationResult.add(failure);
		}

		return retVal;
	}

	private boolean checkReportingLevel() {
		boolean retVal = false;
		String reportingLevel = config.getPdfReportingLevel();
		if (!retVal)
			retVal = (reportingLevel.equals("0"));
		if (!retVal)
			retVal = (reportingLevel.equals("1"));
		if (!retVal)
			retVal = (reportingLevel.equals("2"));
		if (!retVal)
			retVal = (reportingLevel.equals("3"));

		if (!retVal) {
			String errorMsg = "Invalid pdf-reporting-level specified: " + reportingLevel;
			log.error(errorMsg);
			PdfValidationResultEntry failure = new PdfValidationResultEntry();
			failure.setErrMsg(errorMsg, SEVERITY.Error);
			pdfValidationResult.add(failure);
		}

		return retVal;
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
		if (checkPdfLevel() && checkReportingLevel()) {
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
					final PdfValidationResult results = validatePdf(pdf);
					List<PdfValidationResultEntry> newList = new ArrayList<PdfValidationResultEntry>();
					for (PdfValidationResultEntry entry : results.getEntries()) {
						PdfValidationResultEntry newEntry = PdfValidationResultEntry.copy(entry);
						newEntry.setLineNumber(String.valueOf(nonXMLBodyNode.getLineNumber()));
						// this is to avoid
						// java.util.ConcurrentModificationException
						newList.add(newEntry);
					}
					for (PdfValidationResultEntry entry : newList) {
						pdfValidationResult.add(entry);
					}
				}
			}
		}
	}

	private PdfValidationResult validatePdf(String pdfStrB64)
			throws IOException, ConfigurationException {

		PdfValidatorAPI pdfValidator = null;
		try {
			pdfValidator = new PdfValidatorAPI();
		} catch (UnsatisfiedLinkError ue) {
			String errorMsg = ERR_NOT_INSTALLED + " (" + ue.getMessage() + ")";
			log.error(errorMsg);
			PdfValidationResultEntry failure = new PdfValidationResultEntry();
			failure.setErrMsg(errorMsg, SEVERITY.Error);
			pdfValidationResult.add(failure);
		} catch (NoClassDefFoundError e) {
			String errorMsg = ERR_NOT_INITIALIZED + " (" + e.getMessage() + ")";
			log.error(errorMsg);
			PdfValidationResultEntry failure = new PdfValidationResultEntry();
			failure.setErrMsg(errorMsg, SEVERITY.Error);
			pdfValidationResult.add(failure);
		} catch (Exception e) {
			String errorMsg = ERR_NOT_INITIALIZED + " (" + e.getMessage() + ")";
			log.error(errorMsg);
			PdfValidationResultEntry failure = new PdfValidationResultEntry();
			failure.setErrMsg(errorMsg, SEVERITY.Error);
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
				pdfValidationResult.add(failure);
			}
		}
		if (pdfValidator != null) {
			switch (config.getPdfReportingLevel()) {
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
