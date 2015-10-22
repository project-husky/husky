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
import org.ehealth_connector.util.VendorInformation;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

/**
 * The Class IndexHtm represents the INDEX.HTM file, which is part of the
 * contents of an XDM volume. The file contains information about the contents
 * of the volume.
 */
public class IndexHtm {

	/** The log service. */
	private static Logger logService = Logger.getLogger(IndexHtm.class.getName());

	/** The inputStream. */
	private InputStream is = null;

	/** The HTML Header (including headline) */
	public static final String HTML_HEADER = 
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n"
			+ "<head>\n"
			+ "<title>eHealthConnector XDM Cross-Enterprise Document Media Interchange</title>\n"
			+ "</head>\n"
			+ "<body bgcolor=\"#F1FFFE\">\n"
			+ "<div align=\"center\">\n"
			+ "<h1>eHealthConnector - XDM Cross-Enterprise Document Media Interchange</h1>\n"
			+ "</div>\n";
	/** The HTML Footer */
	public static final String HTML_FOOTER = "</body>\n" + "</html>";
	/** The HTML Separator for different languages inside this file */
	public static final String HTML_SEPARATOR = "<hr />";
	
	/** The Constant TEMPLATE_EN. */
	public static final String TEMPLATE_EN = 
			"<h2>Institution</h2>\n"
			+ "<p>Information about this XDM volume in english.<br/>\n"
			+ "This XDM volume was created by {0}. </p>\n"
			+ "<p><a target=\"_blank\" href=\"http://sourceforge.net/p/ehealthconnector/wiki/Team\">{1}</a></p>\n"
			+ "<h2>Contents</h2>\n{2}"
			+ "<p>This volume contains {3} Documents in 1 Submission Set.</p>\n"
			+ "<h3>README File</h3>\n"
			+ "<p>For technical details about this volume and vendor information, see: <a target=\"_blank\" href=\"README.TXT\">README.TXT</a>.</p>\n";	
			/** The Constant TEMPLATE_DE. */
	public static final String TEMPLATE_DE = 
			"<h2>Verwaltende Organisation</h2>\n"
			+ "<p>Informationen zu diesem XDM Paket in Deutsch.<br/>\n"
			+ "Dieses XDM Paket wurde erstellt von: {0}. </p>\n"
			+ "<p><a target=\"_blank\" href=\"http://sourceforge.net/p/ehealthconnector/wiki/Team\">{1}</a></p>\n"
			+ "<h2>Inhalt</h2>\n{2}"
			+ "<p>Dieses Paket enthält {3} Dokumente in 1 Submission Set.</p>\n"
			+ "<h3>README Datei</h3>\n"
			+ "<p>Technische Details zu diesem XDM Paket und dessen Hersteller befinden sich hier: <a target=\"_blank\" href=\"README.TXT\">README.TXT</a>.</p>\n";
	/** The Constant TEMPLATE_FR. */
	public static final String TEMPLATE_FR = 
			"<h2>Organisme de gestion</h2>\n"
			+ "<p>Informations sur ce volume XDM en français.<br/>\n"
			+ "Ce volume XDM a été créée par {0}. </p>\n"
			+ "<p><a target=\"_blank\" href=\"http://sourceforge.net/p/ehealthconnector/wiki/Team\">{1}</a></p>\n"
			+ "<h2>Contenu</h2>\n{2}"
			+ "<p>Ce volume contient {3} Dokumente en 1 Submission Set.</p>\n"
			+ "<h3>Fichier README</h3>\n"
			+ "<p>Pour plus de informations techniques au sujet de ce volume et le fournisseur, voir: <a target=\"_blank\" href=\"README.TXT\">README.TXT</a>.</p>\n";


	/**
	 * Instantiates a new indexHtm.
	 *
	 * @param indexHtmStream
	 *            the INDEX.HTM file as InputStream object. The file contains
	 *            information about the contents of the volume.
	 */
	public IndexHtm(InputStream indexHtmStream) {
		this.is = indexHtmStream;
	}

	/**
	 * Creates a new INDEX.HTM based on the given txnData.
	 *
	 * @param txnData
	 *            the SubmitTransactionData data
	 */
	public IndexHtm(SubmitTransactionData txnData) {
		this(txnData, new VendorInformation());
	}

	/**
	 * Creates a new INDEX.HTM based on the given txnData and vendorInfo.
	 *
	 * @param txnData
	 *            the SubmitTransactionData data
	 * @param vendorInfo
	 *            the vendor info
	 */
	public IndexHtm(SubmitTransactionData txnData, VendorInformation vendorInfo) {

		logService.debug("Creating the Index.htm file");
		Object[] values;
		String str;
		
		//Add html header
		str = HTML_HEADER;
		
		//Add html body with dynamic content
		values = new Object[] { vendorInfo.getVendorName(),
				vendorInfo.getContactInformation(), createContents(txnData),txnData.getDocList().size()};
		str = str + MessageFormat.format(TEMPLATE_EN, values);
		str = str + HTML_SEPARATOR;
		str = str + MessageFormat.format(TEMPLATE_DE, values);
		str = str + HTML_SEPARATOR;
		str = str + MessageFormat.format(TEMPLATE_FR, values);
		
		str = str + HTML_FOOTER;
		
		is = new ByteArrayInputStream(str.getBytes());
	}

	/**
	 * Returns the content of the INDEX.HTM as InputStream object
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
		String contentsStr = "<h3>Submission-Set 1</h3>\n"
				+ "<p>Patient ID: " + txnData.getSubmissionSet().getPatientId().getIdNumber()
				+ "</p>\n" + "<ul>\n";

		int i = 0;
		for (XDSDocument xdsDoc : txnData.getDocList()) {
			i++;
			DocumentEntryType docMetadata = txnData.getDocumentEntry(xdsDoc.getDocumentEntryUUID());
			String title = XdsUtil.convertInternationalStringType(docMetadata.getTitle());
			if (title == null || title.equals("")) {
				title = XdsUtil.createXdmDocName(xdsDoc, i);
			}
			contentsStr = contentsStr + "<li>\n";
			contentsStr = contentsStr.concat("Document " + i + ": "
					+ "<a target=\"_blank\" href=\"" + XdsUtil.createXdmDocPathAndName(xdsDoc, i)
					+ "\">" + title + "</a>\n");
			contentsStr = contentsStr + "</li>\n";
		}
		contentsStr = contentsStr + "</ul>\n";
		return contentsStr;
	}
}
