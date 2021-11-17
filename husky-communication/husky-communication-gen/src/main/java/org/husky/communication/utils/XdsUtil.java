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
package org.husky.communication.utils;

import org.husky.common.enums.DocumentDescriptor;
import org.husky.communication.DocDescriptor;
import org.husky.communication.xd.storedquery.DateTimeRange;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.TimeRange;

/**
 *
 * xds util class
 *
 */
public class XdsUtil {

	/**
	 * Converts a list of eHC DateTimeRange to a list of OHT DateTimeRange.
	 *
	 * @param dtr
	 *            the OHT DateTimeRange
	 * @return the DateTimeRange Array
	 */
	public static TimeRange[] convertEhcDateTimeRange(
			DateTimeRange[] dtr) {
		if (dtr == null)
			return new TimeRange[0];
		else {
			final var dtrArray = new TimeRange[dtr.length];

			var i = 0;
			for (final DateTimeRange dt : dtr) {
				dtrArray[i] = dt.getOhtDateTimeRange();
				i++;
			}

			return dtrArray;
		}
	}

	/**
	 * Creates a document name in conformance with the XDM document naming
	 * scheme
	 *
	 * @param xdsDoc
	 *            the OHT XDSDocument
	 * @param docNr
	 *            the number of the document
	 * @return the name of the document
	 */
	public static String createXdmDocName(Document xdsDoc, int docNr) {
		// compile the path and filename for the zip file
		var fileName = "DOC";

		// Fix DocumentDescriptor problem...
		var dd = DocumentDescriptor
				.getDocumentDescriptorForMimeType(xdsDoc.getDocumentEntry().getMimeType());
		if (dd.toString().startsWith("UNKNOWN!")) {
			String mimeType = dd.toString().replace("UNKNOWN!", "");
			mimeType = mimeType.substring(mimeType.indexOf("!") + 1, mimeType.length());
			dd = DocumentDescriptor.getDocumentDescriptorForMimeType(mimeType);
		}

		final String fileNameExtension = DocDescriptor.getFileExtension(dd);
		fileName = fileName.concat(String.format("%5s", docNr).replace(' ', '0'));
		fileName = fileName.concat("." + fileNameExtension.toUpperCase());
		return fileName;
	}

	/**
	 * Creates a document path and name in conformance with the XDM document
	 * naming scheme
	 *
	 * @param xdsDoc
	 *            the OHT XDSDocument
	 * @param docNr
	 *            the number of the document
	 * @return the path and name of the document
	 */
	public static String createXdmDocPathAndName(Document xdsDoc, int docNr) {
		return "IHE_XDM/SUBSET01/" + createXdmDocName(xdsDoc, docNr);
	}

	/**
	 * Default constructor to instanciate the object
	 */
	private XdsUtil() {

	}
}
