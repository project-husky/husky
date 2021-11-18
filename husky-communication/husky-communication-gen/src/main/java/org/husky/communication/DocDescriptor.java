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
package org.husky.communication;

import org.husky.common.enums.DocumentDescriptor;

public class DocDescriptor {

	private DocDescriptor() {
		throw new IllegalStateException("This is a utility class!");
	}

	public static String getFileExtension(DocumentDescriptor documentDescriptor) {
		if (documentDescriptor.equals(DocumentDescriptor.CCR)
				|| documentDescriptor.equals(DocumentDescriptor.CDA_R1)
				|| documentDescriptor.equals(DocumentDescriptor.CDA_R2)
				|| documentDescriptor.equals(DocumentDescriptor.XDS_LAB)
				|| documentDescriptor.equals(DocumentDescriptor.XDS_MS)
				|| documentDescriptor.equals(DocumentDescriptor.XML)) {
			return "XML";
		}
		if (documentDescriptor.equals(DocumentDescriptor.PDF)) {
			return "PDF";
		}
		// fix for https://sourceforge.net/p/ehealthconnector/tickets/36/
		if (documentDescriptor.toString().contains("!")) {
			return documentDescriptor.toString().split("!")[0];
		}
		return null;
	}
}
