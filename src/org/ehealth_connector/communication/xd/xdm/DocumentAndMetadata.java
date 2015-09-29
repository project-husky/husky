package org.ehealth_connector.communication.xd.xdm;

import org.ehealth_connector.communication.DocumentMetadata;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;

public class DocumentAndMetadata {

	XDSDocument xdsDocument;
	DocumentEntryType docEntry;

	public DocumentAndMetadata(XDSDocument xdsDocument, DocumentEntryType docEntry) {
		this.xdsDocument = xdsDocument;
		this.docEntry = docEntry;
	}

	public DocumentMetadata getDocEntry() {
		return new DocumentMetadata(docEntry);
	}

	public DocumentEntryType getDocEntryAsOhtDocumentEntryType() {
		return docEntry;
	}

	public XDSDocument getXdsDocument() {
		return xdsDocument;
	}

	public void setDocEntry(DocumentEntryType docEntry) {
		this.docEntry = docEntry;
	}

	public void setXdsDocument(XDSDocument xdsDocument) {
		this.xdsDocument = xdsDocument;
	}
}
