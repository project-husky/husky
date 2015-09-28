package org.ehealth_connector.communication.xd.xdm;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.MessageFormat;

import org.apache.log4j.Logger;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

public class IndexHtm {

	private static Logger logService = Logger.getLogger(IndexHtm.class.getName());
	private InputStream is = null;
	public static final String TEMPLATE_EN = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
			+ "<head>\n"
			+ "<title>eHealthConnector XDM Cross-Enterprise Document Media Interchange</title>\n"
			+ "</head>\n"
			+ "<body bgcolor=\"#F1FFFE\">\n"
			+ "<div align=\"center\">\n"
			+ "<h2>eHealthConnector - XDM Cross-Enterprise Document Media Interchange</h2>\n"
			+ "</div>\n"
			+ "<h3>Institution</h3>\n"
			+ "<p>This XDM volume was created by {0}"
			+ " for the patient with ID: {1}</p>\n"
			+ "<p>\n {2}</p>\n"
			+ "<h3>Contents</h3>\n {3} "
			+ "<h3>README File</h3>\n"
			+ "<p>For technical details about this volume and vendor information, see: <a href=\"README.TXT\">README.TXT</a>.</p>\n"
			+ "</body>\n" + "</html>";

	public IndexHtm(InputStream indexHtmStream) {
		this.is = indexHtmStream;
	}

	public IndexHtm(SubmitTransactionData txnData) {
		this(txnData, new VendorInformation());
	}

	/**
	 * Creates a new INDEX.HTM Object
	 * 
	 * @param patientID
	 *            Contains the PatientID as a String
	 * @param documentID
	 *            Contains the DocumentID as a String
	 * @param documentName
	 *            Contains the DocuementName as a String
	 */
	public IndexHtm(SubmitTransactionData txnData, VendorInformation vendorInfo) {

		logService.debug("Creating the Index.htm file");

		Object[] values = new Object[] { vendorInfo.getName(),
				txnData.getSubmissionSet().getPatientId().getIdNumber(),
				vendorInfo.getContactInformation(), createContents(txnData) };
		String str = MessageFormat.format(TEMPLATE_EN, values);
		is = new ByteArrayInputStream(str.getBytes());
	}

	/**
	 * Writes the index.htm contents to an InputStream
	 */
	public InputStream getInputStream() {
		return is;
	}

	private String createContents(SubmitTransactionData txnData) {
		// Number of Items
		String contentsStr = "<p>This volume contains " + +txnData.getDocList().size()
				+ " Documents in 1 Submission Sets:</p>\n<br/><br/>\n";

		int i = 0;
		for (XDSDocument xdsDoc : txnData.getDocList()) {
			i++;
			contentsStr = contentsStr.concat("Document " + i + "<br/>" + "<a href=\""
					+ XdsUtil.createXdmDocPathAndName(xdsDoc, i) + "\">"
					+ XdsUtil.createXdmDocPathAndName(xdsDoc, i) + "</a>\n" + "DocumentEntryId: \n<code>"
					+ xdsDoc.getDocumentEntryUUID() + "</code>\n" + "</p>\n");
		}
		return contentsStr;
	}
}
