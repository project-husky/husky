/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.communication.xd.xdm;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

import org.ehealth_connector.common.mdht.VendorInformation;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.ehealth_connector.communication.utils.XdsUtil;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class IndexHtm represents the INDEX.HTM file, which is part of the
 * contents of an XDM volume. The file contains information about the contents
 * of the volume.
 */
public class IndexHtm {

	/** The HTML Footer */
	public static final String HTML_FOOTER = "</body>\n" + "</html>";

	/** The HTML Header (including headline) */
	public static final String HTML_HEADER = """
			<?xml version="1.0" encoding="UTF-8"?>
			<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
			<html xmlns="http://www.w3.org/1999/xhtml">
			  <head>
			   <title>eHealthConnector XDM Cross-Enterprise Document Media Interchange</title>
			  </head>
			  <body bgcolor="#F1FFFE">
			    <div align="center">
			      <h1>eHealthConnector - XDM Cross-Enterprise Document Media Interchange</h1>
			    </div>
			""";
	/** The HTML Separator for different languages inside this file */
	public static final String HTML_SEPARATOR = "<hr />";
	/** The Constant TEMPLATE_DE. */
	public static final String TEMPLATE_DE = """
			<h2>Verwaltende Organisation</h2>
			<p>Informationen zu diesem XDM Paket in Deutsch.<br/>
			Dieses XDM Paket wurde erstellt von: {0}. </p>
			<p>Siehe <a target="_blank" href="http://sourceforge.net/p/ehealthconnector/wiki/Team">{1}</a></p>
			<h2>Inhalt</h2>
			{2}<p>Dieses Paket enthält {3} Dokumente in 1 Submission Set.</p>
			<h3>README Datei</h3>
			<p>Technische Details zu diesem XDM Paket und dessen Hersteller befinden sich hier: <a target="_blank" href="README.TXT">README.TXT</a>.</p>
			""";
	/** The Constant TEMPLATE_EN. */
	public static final String TEMPLATE_EN = """
			<h2>Institution</h2>
			<p>Information about this XDM volume in english.<br/>
			This XDM volume was created by {0}. </p>
			<p>See <a target="_blank" href="http://sourceforge.net/p/ehealthconnector/wiki/Team">{1}</a></p>
			<h2>Contents</h2>
			{2}<p>This volume contains {3} Documents in 1 Submission Set.</p>
			h3>README File</h3>
			<p>For technical details about this volume and vendor information, see: <a target="_blank" href="README.TXT">README.TXT</a>.</p>
			""";
	/** The Constant TEMPLATE_FR. */
	public static final String TEMPLATE_FR = """
			<h2>Organisme de gestion</h2>
			<p>Informations sur ce volume XDM en français.<br/>
			Ce volume XDM a été créée par {0}. </p>
			<p>Voir <a target="_blank" href="http://sourceforge.net/p/ehealthconnector/wiki/Team">{1}</a></p>
			<h2>Contenu</h2>
			{2}<p>Ce volume contient {3} Dokumente en 1 Submission Set.</p>
			<h3>Fichier README</h3>
			<p>Pour plus de informations techniques au sujet de ce volume et le fournisseur, voir: <a target="_blank" href="README.TXT">README.TXT</a>.</p>
			""";
	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());
	/** The inputStream. */
	private InputStream inputStream = null;

	/**
	 * Instantiates a new indexHtm.
	 *
	 * @param indexHtmStream the INDEX.HTM file as InputStream object. The file
	 *                       contains information about the contents of the volume.
	 */
	public IndexHtm(InputStream indexHtmStream) {
		this.inputStream = indexHtmStream;
	}

	/**
	 * Creates a new INDEX.HTM based on the given txnData.
	 *
	 * @param txnData the SubmitTransactionData data
	 */
	public IndexHtm(ProvideAndRegisterDocumentSet txnData) {
		this(txnData, new VendorInformation());
	}

	/**
	 * Creates a new INDEX.HTM based on the given txnData and vendorInfo.
	 *
	 * @param txnData    the SubmitTransactionData data
	 * @param vendorInfo the vendor info
	 */
	public IndexHtm(ProvideAndRegisterDocumentSet txnData, VendorInformation vendorInfo) {

		log.debug("Creating the Index.htm file");
		Object[] values;
		String str;

		// Add html header
		str = HTML_HEADER;

		// Add html body with dynamic content
		values = new Object[] { vendorInfo.getVendorName(), vendorInfo.getContactInformation(), createContents(txnData),
				txnData.getDocuments().size() };
		str = str + MessageFormat.format(TEMPLATE_EN, values);
		str = str + HTML_SEPARATOR;
		str = str + MessageFormat.format(TEMPLATE_DE, values);
		str = str + HTML_SEPARATOR;
		str = str + MessageFormat.format(TEMPLATE_FR, values);

		str = str + HTML_FOOTER;

		inputStream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * Creates the contents.
	 *
	 * @param SubmitTransactionData the txn data
	 * @return the IndexHtm contents as string
	 */
	private String createContents(ProvideAndRegisterDocumentSet txnData) {
		// Number of Items
		var contentsStr = new StringBuilder("<h3>Submission-Set 1</h3>\n" + "<p>Patient ID: "
				+ txnData.getSubmissionSet().getPatientId().getId() + "</p>\n" + "<ul>\n");

		var i = 0;
		for (final Document xdsDoc : txnData.getDocuments()) {
			i++;

			if (xdsDoc != null && xdsDoc.getDocumentEntry() != null) {
				final var docMetadata = xdsDoc.getDocumentEntry();
				var title = XdsMetadataUtil.convertInternationalStringType(docMetadata.getTitle());
				if ((title == null) || "".equals(title)) {
					title = XdsUtil.createXdmDocName(xdsDoc, i);
				}
				contentsStr.append("<li>\n");
				contentsStr.append("Document " + i + ": " + "<a target=\"_blank\" href=\""
						+ XdsUtil.createXdmDocPathAndName(xdsDoc, i) + "\">" + title + "</a>\n");
				contentsStr.append("</li>\n");
			}
		}
		contentsStr.append("</ul>\n");
		return contentsStr.toString();
	}

	/**
	 * Returns the content of the INDEX.HTM as InputStream object
	 *
	 * @return the input stream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}
}
