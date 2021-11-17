/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
