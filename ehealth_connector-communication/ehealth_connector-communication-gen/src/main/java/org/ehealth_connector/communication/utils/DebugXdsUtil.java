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
package org.ehealth_connector.communication.utils;

import java.util.List;

import org.ehealth_connector.common.utils.DebugUtil;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Author;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.SubmissionSet;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
/**
 * Debug xds util class
 *
 */
public class DebugXdsUtil extends DebugUtil {
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
		final StringBuilder retVal = new StringBuilder();
		Integer i = 0;
		for (final ProvideAndRegisterDocumentSet txnData : txnDatas) {
			i++;

			retVal.append("\nSubmission-Set " + i + "\n");
			// txnData.getDocList();
			// ProvideAndRegisterDocumentSetType metadata =
			// txnData.getMetadata();
			final SubmissionSet ss = txnData.getSubmissionSet();
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
				for (final Object item2 : txnData.getDocuments()) {
					retVal.append("\n    " + (String) item2);
				}
			}
			retVal.append("\n");
		}
		return retVal.toString();
	}

}
