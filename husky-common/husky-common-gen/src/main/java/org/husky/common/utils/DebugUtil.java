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
package org.husky.common.utils;

import java.util.List;

import org.openehealth.ipf.commons.ihe.xds.core.metadata.Author;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization;

/**
 * <div class="en">Contains some helper methods for debugging purposes
 * only!</div><div class="de"></div><div class="fr"></div>
 */
public class DebugUtil {

	/**
	 * Creates a debug string for the given Author (for debugging purposes
	 * only!)
	 *
	 * @param data
	 *            the author
	 * @return the debug string <div class="en"></div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static String debugAuthorString(Author data) {
		final StringBuilder retVal = new StringBuilder();
		if (data != null) {
			retVal.append("    " + data.getAuthorPerson().getName().getFamilyName() + " "
					+ data.getAuthorPerson().getName().getGivenName() + " " + data.getAuthorPerson().getId().getId()
					+ " " + data.getAuthorPerson().getId().getAssigningAuthority().getUniversalId() + "\n");

			if (data.getAuthorRole().isEmpty()) {
				retVal.append("    AuthorRole: " + null + "\n");
			} else {
				retVal.append("    AuthorRole: ");
				for (final Identifiable item2 : data.getAuthorRole()) {
					if (item2 != null) {
						retVal.append(item2.getId() + "; ");
					}
				}
				retVal.append("\n");
			}

			if (data.getAuthorSpecialty().isEmpty()) {
				retVal.append("    AuthorSpeciality: " + null + "\n");
			} else {
				retVal.append("    AuthorSpeciality: ");
				for (final Object item2 : data.getAuthorSpecialty()) {
					retVal.append("    TODO AuthorSpeciality " + item2.getClass().getName() + "\n");
				}
				retVal.append("\n");
			}

			if (data.getAuthorTelecom().isEmpty()) {
				retVal.append("    AuthorTelecommunication: " + null + "\n");
			} else {
				retVal.append("    AuthorTelecommunication: ");
				for (final Object item2 : data.getAuthorTelecom()) {
					retVal.append("    TODO AuthorTelecommunication " + item2.getClass().getName()
							+ "\n");
				}
				retVal.append("\n");
			}

			if (data.getAuthorInstitution().isEmpty()) {
				retVal.append("    AuthorInstitution: " + null + "\n");
			} else {
				retVal.append("    AuthorInstitution: ");
				for (final Organization item2 : data.getAuthorInstitution()) {
					retVal.append(item2.getOrganizationName() + " " + item2.getIdNumber() + " "
							+ item2.getAssigningAuthority().getUniversalId());
				}
				retVal.append("\n");
			}
			return retVal.toString();
		} else
			return "null";
	}

	/**
	 * Creates a debug string for the given list of codes (for debugging
	 * purposes only!)
	 *
	 * @param data
	 *            the list of codes
	 * @return the debug string <div class="en"></div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static String debugCodesString(List<Code> data) {
		final StringBuilder retVal = new StringBuilder();
		if ((data != null) && (!data.isEmpty())) {
			for (final Code item : data) {
				retVal.append(debugCodeString(item) + "\n");
			}
			return retVal.toString();
		}
		return "null";
	}

	/**
	 * Creates a debug string for the given code (for debugging purposes only!)
	 *
	 * @param data
	 *            the code
	 * @return the debug string <div class="en"></div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static String debugCodeString(Code data) {
		final StringBuilder retVal = new StringBuilder();
		if (data != null) {
			retVal.append(data.getCode() + " / " + data.getSchemeName() + " / ");
			retVal.append(data.getDisplayName().getValue() + " (" + data.getDisplayName().getLang() + ") ");
			return retVal.toString();
		} else
			return "null";
	}

	/**
	 * Creates a string with the document metadata (for debugging purposes only)
	 *
	 * @param docEntry
	 *            <div class="en">the document metadata</div>
	 * @return <div class="en">string with the document metadata (for debugging
	 *         purposes only)</div>
	 */
	public static String debugDocumentMetaData(DocumentEntry docEntry) {
		final StringBuilder retVal = new StringBuilder();
		retVal.append("  CreationTime:               " + docEntry.getCreationTime() + "\n");
		retVal.append("  EntryUUID:                  " + docEntry.getEntryUuid() + "\n");
		retVal.append("  Hash:                       " + docEntry.getHash() + "\n");
		retVal.append("  LanguageCode:               " + docEntry.getLanguageCode() + "\n");
		retVal.append("  MimeType:                   " + docEntry.getMimeType() + "\n");
		retVal.append("  RepositoryUniqueId:         " + docEntry.getRepositoryUniqueId() + "\n");
		retVal.append("  ServiceStartTime:           " + docEntry.getServiceStartTime() + "\n");
		retVal.append("  ServiceStopTime:            " + docEntry.getServiceStopTime() + "\n");
		retVal.append("  Size:                       " + docEntry.getSize() + "\n");
		retVal.append("  UniqueId:                   " + docEntry.getUniqueId() + "\n");
		retVal.append("  Uri:                        " + docEntry.getUri() + "\n");
		if (docEntry.getAuthors().isEmpty()) {
			retVal.append("  Authors:                    " + null + "\n");
		} else {
			retVal.append("  Authors:\n");
			for (final Author item : docEntry.getAuthors()) {
				retVal.append(debugAuthorString(item));
			}
		}

		retVal.append("  AvailabilityStatus:         " + docEntry.getAvailabilityStatus() + "\n");
		retVal.append("  Comments:                   "
				+ debugLocalizedString(docEntry.getComments()) + "\n");

		if (docEntry.getConfidentialityCodes().isEmpty()) {
			retVal.append("  ConfidentialityCode:        " + null + "\n");
		} else {
			retVal.append("  ConfidentialityCode:        ");
			for (final Code item : docEntry.getConfidentialityCodes()) {
				retVal.append(debugCodeString(item));
				retVal.append("\n");
			}
		}

		retVal.append("  EventCode:                  " + debugCodesString(docEntry.getEventCodeList())
				+ "\n");
		retVal.append("  Extension:                  " + docEntry.getExtraMetadata() + "\n");
		retVal.append("  FormatCode:                 " + debugCodeString(docEntry.getFormatCode())
				+ "\n");

		retVal.append("  HealthCareFacilityTypeCode: "
				+ debugCodeString(docEntry.getHealthcareFacilityTypeCode()) + "\n");

		retVal.append("  LegalAuthenticator:         " + docEntry.getLegalAuthenticator() + "\n");
		retVal.append("  PatientId:                  " + docEntry.getPatientId().getId() + " / "
				+ docEntry.getPatientId().getAssigningAuthority().getUniversalId() + "\n");
		retVal.append("  PracticeSettingCode:        "
				+ debugCodeString(docEntry.getPracticeSettingCode()) + "\n");

		retVal.append("  SourcePatientId:            " + docEntry.getSourcePatientId().getId() + " / "
				+ docEntry.getSourcePatientId().getAssigningAuthority().getUniversalId() + "\n");
		retVal.append("  SourcePatientInfo:          " + docEntry.getSourcePatientInfo() + "\n");
		retVal.append("  Title:                      "
				+ debugLocalizedString(docEntry.getTitle()) + "\n");
		retVal.append(
				"  TypeCode:                   " + debugCodeString(docEntry.getTypeCode()) + "\n");
		retVal.append(
				"  ClassCode:                  " + debugCodeString(docEntry.getClassCode()) + "\n");
		return retVal.toString();
	}

	/**
	 * Creates a debug string for the given list of localized strings (for
	 * debugging purposes only!)
	 *
	 * @param data
	 *            the list of localized strings
	 * @return the debug string <div class="en"></div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static String debugLocalizedString(LocalizedString str) {
		if ((str != null)) {
			final StringBuilder retVal = new StringBuilder();
			retVal.append(str.getValue() + " (" + str.getLang() + ") ");
			return retVal.toString();
		}
		return "null";
	}

}
