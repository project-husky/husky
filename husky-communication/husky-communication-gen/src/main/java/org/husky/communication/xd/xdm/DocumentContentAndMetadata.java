/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.communication.xd.xdm;

import org.husky.common.communication.DocumentMetadata;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;

/**
 * The Class DocumentAndMetadata represents a Document together with the
 * Document Metadata
 */
public class DocumentContentAndMetadata {

	/** The xds document. */
	private Document xdsDocument;

	/** The doc entry. */
	private DocumentEntry docEntry;

	/**
	 * Instantiates a new document and metadata.
	 *
	 * @param xdsDocument
	 *            the xds document
	 * @param docEntry
	 *            the doc entry
	 */
	public DocumentContentAndMetadata(Document xdsDocument, DocumentEntry docEntry) {
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
	public DocumentEntry getDocEntryAsOhtDocumentEntryType() {
		return docEntry;
	}

	/**
	 * Gets the xds document.
	 *
	 * @return the xds document
	 */
	public Document getXdsDocument() {
		return xdsDocument;
	}

	/**
	 * Sets the Document Metadata.
	 *
	 * @param docEntry
	 *            the new doc entry
	 */
	public void setDocEntry(DocumentEntry docEntry) {
		this.docEntry = docEntry;
	}

	/**
	 * Sets the xds document.
	 *
	 * @param xdsDocument
	 *            the new xds document
	 */
	public void setXdsDocument(Document xdsDocument) {
		this.xdsDocument = xdsDocument;
	}
}
