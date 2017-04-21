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
package org.ehealth_connector.communication.xd.xdm;

import org.ehealth_connector.communication.DocumentMetadata;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;

/**
 * The Class DocumentAndMetadata represents a Document together with the
 * Document Metadata
 */
public class DocumentContentAndMetadata {

	/** The xds document. */
	private XDSDocument xdsDocument;

	/** The doc entry. */
	private DocumentEntryType docEntry;

	/**
	 * Instantiates a new document and metadata.
	 *
	 * @param xdsDocument
	 *            the xds document
	 * @param docEntry
	 *            the doc entry
	 */
	public DocumentContentAndMetadata(XDSDocument xdsDocument, DocumentEntryType docEntry) {
		this.xdsDocument = xdsDocument;
		this.docEntry = docEntry;
	}

	/**
	 * Gets the Document Metadata as convenience object.
	 *
	 * @return the doc entry
	 */
	public DocumentMetadata getDocEntry() {
		return new DocumentMetadata(docEntry);
	}

	/**
	 * Gets the doc entry as OHT document entry type.
	 *
	 * @return the doc entry as OHT document entry type
	 */
	public DocumentEntryType getDocEntryAsOhtDocumentEntryType() {
		return docEntry;
	}

	/**
	 * Gets the xds document.
	 *
	 * @return the xds document
	 */
	public XDSDocument getXdsDocument() {
		return xdsDocument;
	}

	/**
	 * Sets the Document Metadata.
	 *
	 * @param docEntry
	 *            the new doc entry
	 */
	public void setDocEntry(DocumentEntryType docEntry) {
		this.docEntry = docEntry;
	}

	/**
	 * Sets the xds document.
	 *
	 * @param xdsDocument
	 *            the new xds document
	 */
	public void setXdsDocument(XDSDocument xdsDocument) {
		this.xdsDocument = xdsDocument;
	}
}
