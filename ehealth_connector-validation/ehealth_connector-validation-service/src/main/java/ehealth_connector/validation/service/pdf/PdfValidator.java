package ehealth_connector.validation.service.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.BitSet;

import javax.xml.bind.DatatypeConverter;
import javax.xml.transform.stream.StreamSource;

import com.pdftools.NativeLibrary.COMPLIANCE;
import com.pdftools.pdfvalidator.PdfError;
import com.pdftools.pdfvalidator.PdfValidatorAPI;

import ehealth_connector.validation.service.config.Configuration;
import ehealth_connector.validation.service.config.ConfigurationException;
import ehealth_connector.validation.service.pdf.PdfValidationResult.SEVERITY;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XPathCompiler;
import net.sf.saxon.s9api.XPathSelector;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;

public class PdfValidator {

	private Configuration config;
	private String pdfLevel;
	private ArrayList<PdfValidationResult>pdfValidationResults;
	
	public PdfValidator(Configuration config) {
		this.config = config;
		this.pdfLevel = config.getPdfLevel();
		
	}

	private PdfValidationResult validatePdf(String pdfStrB64)
			throws IOException, ConfigurationException {

		PdfValidatorAPI pdfValidator = new PdfValidatorAPI();
		pdfValidator.setNoTempFiles(true);
		String licenseKey = config.getLicenseKey();
		if (!PdfValidatorAPI.setLicenseKey(licenseKey))
			throw new ConfigurationException("PDF-Validator: Ungültige Lizenz");
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
		pdfValidator.open(DatatypeConverter.parseBase64Binary(pdfStrB64), "",
				comlianceLevel);

		pdfValidator.validate();
		PdfValidationResult pdfVResult = null;
		PdfError err = pdfValidator.getFirstError();
		if (err != null) {
			pdfVResult = new PdfValidationResult();
			while (err != null) {
				String sErrorMsg = err.getMessage();
				int errorCode = err.getErrorCode();
				//log.info("PDF Validation Message: " + errorCode + " "
					//	+ sErrorMsg);
				if (errorCode != -2092890606) {
					BitSet tempBS = BitSet.valueOf(ByteBuffer.allocate(4)
							.putInt(errorCode).array());
					SEVERITY severity = SEVERITY.Information;

					// ErrorCode --> Bit 7 = Error, Bit 23 = Warnung, sonst Info
					if (tempBS.get(7))
						severity = SEVERITY.Error;
					if (tempBS.get(23))
						severity = SEVERITY.Warning;
					if ("The XMP property 'pdfaid:conformance' has the invalid value 'B'. Required is 'A'."
							.equals(sErrorMsg)) {
						severity = SEVERITY.CustomWarning;
					}
					pdfVResult.setErrMsg(sErrorMsg, severity);
				}
				err = pdfValidator.getNextError();
			}
		}
		pdfValidator.close();
		pdfValidator.destroyObject();
		return pdfVResult;
	}

	public void validatePdfFile(File cdaFile) throws ConfigurationException, SaxonApiException, IOException {
		
		Processor proc = new Processor(false);

		DocumentBuilder builder = proc.newDocumentBuilder();
		builder.setLineNumbering(true);
		XdmNode hl7Doc;
		
			hl7Doc = builder.build(new StreamSource(new FileInputStream(cdaFile)));

			XPathCompiler xpath = proc.newXPathCompiler();
			xpath.declareNamespace("", "urn:hl7-org:v3");

			XPathSelector selector = xpath
					.compile(
							"//*[@mediaType='application/pdf' and @representation='B64']")// "//nonXMLBody/*[@mediaType='application/pdf'] | //nonXMLBody/*[@representation='B64']")
					.load();
			selector.setContextItem(hl7Doc);
			XdmValue children = selector.evaluate();
			if (children.size() > 0) {
				pdfValidationResults = new ArrayList<PdfValidationResult>();
				for (XdmItem item : children) {
					XdmNode nonXMLBodyNode = (XdmNode) item;
					String pdf = item.getStringValue().trim();// .replaceFirst("\n",
																// "");
					PdfValidationResult result = validatePdf(pdf);
					if (result != null) {
						result.setLineNumber(String.valueOf(nonXMLBodyNode
								.getLineNumber()));
						pdfValidationResults.add(result);
					}
				}
			}
				
	}

	public ArrayList<PdfValidationResult> getPdfValidationResults() {
		return pdfValidationResults;
	}

	public void setPdfValidationResults(ArrayList<PdfValidationResult> pdfValidationResults) {
		this.pdfValidationResults = pdfValidationResults;
	}
}
