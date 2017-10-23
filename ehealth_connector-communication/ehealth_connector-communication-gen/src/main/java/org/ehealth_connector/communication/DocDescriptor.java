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
package org.ehealth_connector.communication;

import org.openhealthtools.ihe.xds.document.DocumentDescriptor;

public class DocDescriptor {

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
