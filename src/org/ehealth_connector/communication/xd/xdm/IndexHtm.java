/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.communication.xd.xdm;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.MessageFormat;

import org.apache.log4j.Logger;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

/**
 * The Class IndexHtm represents the INDEX.HTM file, which is part of the
 * contents of an XDM volume. The File contains information about the contents
 * of the volume and the vendor, who build the system that created the XDM
 * volume.
 */
public class IndexHtm {

	/** The log service. */
	private static Logger logService = Logger.getLogger(IndexHtm.class.getName());

	/** The inputStream. */
	private InputStream is = null;

	/** The Constant TEMPLATE_EN. */
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

	/**
	 * Instantiates a new indexHtm.
	 *
	 * @param indexHtmStream
	 *            the indexHtm stream
	 */
	public IndexHtm(InputStream indexHtmStream) {
		this.is = indexHtmStream;
	}

	/**
	 * Instantiates a new index htm.
	 *
	 * @param txnData
	 *            the SubmitTransactionData data
	 */
	public IndexHtm(SubmitTransactionData txnData) {
		this(txnData, new VendorInformation());
	}

	/**
	 * Creates a new INDEX.HTM Object
	 *
	 * @param txnData
	 *            the SubmitTransactionData data
	 * @param vendorInfo
	 *            the vendor info
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
	 *
	 * @return the input stream
	 */
	public InputStream getInputStream() {
		return is;
	}

	/**
	 * Creates the contents.
	 *
	 * @param SubmitTransactionData
	 *            the txn data
	 * @return the IndexHtm contents as string
	 */
	private String createContents(SubmitTransactionData txnData) {
		// Number of Items
		String contentsStr = "<p>This volume contains " + +txnData.getDocList().size()
				+ " Documents in 1 Submission Sets:</p>\n<br/><br/>\n";

		int i = 0;
		for (XDSDocument xdsDoc : txnData.getDocList()) {
			i++;
			contentsStr = contentsStr.concat("Document " + i + "<br/>" + "<a href=\""
					+ XdsUtil.createXdmDocPathAndName(xdsDoc, i) + "\">"
					+ XdsUtil.createXdmDocPathAndName(xdsDoc, i) + "</a>\n"
					+ "DocumentEntryId: \n<code>" + xdsDoc.getDocumentEntryUUID() + "</code>\n"
					+ "\n");
		}
		return contentsStr;
	}
}
