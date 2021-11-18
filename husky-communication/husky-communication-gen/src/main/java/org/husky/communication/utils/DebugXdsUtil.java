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
package org.husky.communication.utils;

import java.util.List;

import org.husky.common.utils.DebugUtil;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Author;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
/**
 * Debug xds util class
 *
 */
public class DebugXdsUtil extends DebugUtil {

	private DebugXdsUtil() {
		throw new IllegalStateException("This is a utility class!");
	}

	/**
	 * Creates a string with the submission-set metadata (for debugging purposes
	 * only)
	 *
	 * @param txnDatas
	 *            <div class="en">the submit transaction data</div>
	 * @return <div class="en">string with the submission-set metadata (for
	 *         debugging purposes only)</div>
	 */
	public static String debugSubmissionSetMetaData(List<ProvideAndRegisterDocumentSet> txnDatas) {
		final var retVal = new StringBuilder();
		Integer i = 0;
		for (final ProvideAndRegisterDocumentSet txnData : txnDatas) {
			i++;

			retVal.append("\nSubmission-Set " + i + "\n");
			final var ss = txnData.getSubmissionSet();
			retVal.append("  EntryUUID:            " + ss.getEntryUuid() + "\n");
			retVal.append("  SourceId:             " + ss.getSourceId() + "\n");
			retVal.append("  SubmissionTime:       " + ss.getSubmissionTime() + "\n");
			retVal.append("  UniqueId:             " + ss.getUniqueId() + "\n");
			retVal.append("  Title:                " + ss.getTitle() + "\n");
			retVal.append("  PatientId:            " + ss.getPatientId() + "\n");
			retVal.append(
					"  ContentTypeCode:      " + debugCodeString(ss.getContentTypeCode()) + "\n");
			for (Author author : ss.getAuthors()) {
				if (author != null) {
					retVal.append("  Author:               " + debugAuthorString(author) + "\n");
				}
			}

			retVal.append("  AvailabilityStatus:   " + ss.getAvailabilityStatus() + "\n");
			retVal.append(
					"  Comments:             " + debugLocalizedString(ss.getComments()) + "\n");
			retVal.append("  IntendedRecipient:    ");
			if (ss.getIntendedRecipients().isEmpty()) {
				retVal.append("null");
			} else {
				for (final Object item2 : ss.getIntendedRecipients()) {
					retVal.append("\n    TODO IntendedRecipient " + item2.getClass().getName());
				}
			}
			retVal.append("\n");

			retVal.append("  AssociatedFolders:    ");
			if (txnData.getFolders().isEmpty()) {
				retVal.append("null");
			} else {
				for (final Object item2 : txnData.getFolders()) {
					retVal.append("\n    TODO AssociatedFolders " + item2.getClass().getName());
				}
			}
			retVal.append("\n");

			retVal.append("  AssociatedDocuments:  ");
			if (txnData.getDocuments().isEmpty()) {
				retVal.append("null");
			} else {
				for (final Document item2 : txnData.getDocuments()) {
					retVal.append("\n    " + item2);
				}
			}
			retVal.append("\n");
		}
		return retVal.toString();
	}

}
