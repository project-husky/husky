package org.ehealth_connector.communication;

import org.openhealthtools.ihe.xds.document.DocumentDescriptor;

public class DocDescriptor {

	public static String getFileExtension(DocumentDescriptor documentDescriptor) {
		if (documentDescriptor.equals(DocumentDescriptor.CCR) ||
			documentDescriptor.equals(DocumentDescriptor.CDA_R1) ||
			documentDescriptor.equals(DocumentDescriptor.CDA_R2) ||
			documentDescriptor.equals(DocumentDescriptor.XDS_LAB) ||
			documentDescriptor.equals(DocumentDescriptor.XDS_MS) ||
			documentDescriptor.equals(DocumentDescriptor.XML)) {
				return "XML";
		}
		if (documentDescriptor.equals(DocumentDescriptor.PDF)) {
				return "PDF";
		}
		return null;
	}
}
