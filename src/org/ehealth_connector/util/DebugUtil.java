package org.ehealth_connector.util;

import org.eclipse.emf.common.util.EList;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.InternationalStringType;
import org.openhealthtools.ihe.xds.metadata.LocalizedStringType;
import org.openhealthtools.ihe.xds.metadata.SubmissionSetType;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

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
	public static String debugAuthorString(AuthorType data) {
		StringBuffer retVal = new StringBuffer();
		if (data != null) {
			retVal.append("    " + data.getAuthorPerson().getFamilyName() + " "
					+ data.getAuthorPerson().getGivenName() + " "
					+ data.getAuthorPerson().getIdNumber() + " "
					+ data.getAuthorPerson().getAssigningAuthorityName() + "\n");

			if (data.getAuthorRole().isEmpty()) {
				retVal.append("    AuthorRole: " + null + "\n");
			} else {
				retVal.append("    AuthorRole: ");
				for (Object item2 : data.getAuthorRole()) {
					retVal.append(((String) item2) + "; ");
				}
				retVal.append("\n");
			}

			if (data.getAuthorSpeciality().isEmpty()) {
				retVal.append("    AuthorSpeciality: " + null + "\n");
			} else {
				retVal.append("    AuthorSpeciality: ");
				for (Object item2 : data.getAuthorSpeciality()) {
					retVal.append("    TODO AuthorSpeciality " + item2.getClass().getName() + "\n");
				}
				retVal.append("\n");
			}

			if (data.getAuthorTelecommunication().isEmpty()) {
				retVal.append("    AuthorTelecommunication: " + null + "\n");
			} else {
				retVal.append("    AuthorTelecommunication: ");
				for (Object item2 : data.getAuthorTelecommunication()) {
					retVal.append("    TODO AuthorTelecommunication " + item2.getClass().getName()
							+ "\n");
				}
				retVal.append("\n");
			}

			if (data.getAuthorInstitution().isEmpty()) {
				retVal.append("    AuthorInstitution: " + null + "\n");
			} else {
				retVal.append("    AuthorInstitution: ");
				for (Object item2 : data.getAuthorInstitution()) {
					org.openhealthtools.ihe.common.hl7v2.impl.XONImpl data2 = (org.openhealthtools.ihe.common.hl7v2.impl.XONImpl) item2;
					retVal.append(data2.getOrganizationName() + " " + data2.getIdNumber() + " "
							+ data2.getAssigningAuthorityName());
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
	public static String debugCodesString(EList<Object> data) {
		StringBuffer retVal = new StringBuffer();
		if (data != null) {
			if (data.isEmpty()) {
				return "null";
			} else {
				for (Object item : data) {
					retVal.append(debugCodeString((CodedMetadataType) item) + "\n");
				}
				return retVal.toString();
			}
		} else
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
	public static String debugCodeString(CodedMetadataType data) {
		StringBuffer retVal = new StringBuffer();
		if (data != null) {
			retVal.append(data.getCode() + " / " + data.getSchemeName() + " / ");
			for (Object item2 : data.getDisplayName().getLocalizedString()) {
				org.openhealthtools.ihe.xds.metadata.impl.LocalizedStringTypeImpl data2 = (org.openhealthtools.ihe.xds.metadata.impl.LocalizedStringTypeImpl) item2;
				retVal.append(data2.getValue() + " (" + data2.getLang() + ") ");
			}
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
	public static String debugDocumentMetaData(DocumentEntryType docEntry) {
		StringBuffer retVal = new StringBuffer();
		retVal.append("  CreationTime:               " + docEntry.getCreationTime() + "\n");
		retVal.append("  EntryUUID:                  " + docEntry.getEntryUUID() + "\n");
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
			for (Object item : docEntry.getAuthors()) {
				retVal.append(debugAuthorString((AuthorType) item));
			}
		}

		retVal.append("  AvailabilityStatus:         " + docEntry.getAvailabilityStatus() + "\n");
		retVal.append("  Comments:                   "
				+ debugLocalizedString(docEntry.getComments().getLocalizedString()) + "\n");

		if (docEntry.getConfidentialityCode().isEmpty()) {
			retVal.append("  ConfidentialityCode:        " + null + "\n");
		} else {
			retVal.append("  ConfidentialityCode:        ");
			for (Object item : docEntry.getConfidentialityCode()) {
				retVal.append(debugCodeString((org.openhealthtools.ihe.xds.metadata.impl.CodedMetadataTypeImpl) item));
				retVal.append("\n");
			}
		}

		retVal.append("  EventCode:                  " + debugCodesString(docEntry.getEventCode())
				+ "\n");
		retVal.append("  Extension:                  " + docEntry.getExtension() + "\n");
		retVal.append("  FormatCode:                 " + debugCodeString(docEntry.getFormatCode())
				+ "\n");

		retVal.append("  HealthCareFacilityTypeCode: "
				+ debugCodeString(docEntry.getHealthCareFacilityTypeCode()) + "\n");

		retVal.append("  LegalAuthenticator:         " + docEntry.getLegalAuthenticator() + "\n");
		retVal.append("  ParentDocument:             " + docEntry.getParentDocument() + "\n");
		retVal.append("  PatientId:                  " + docEntry.getPatientId().getIdNumber()
				+ " / " + docEntry.getPatientId().getAssigningAuthorityUniversalId() + "\n");
		retVal.append("  PracticeSettingCode:        "
				+ debugCodeString(docEntry.getPracticeSettingCode()) + "\n");

		retVal.append("  SourcePatientId:            "
				+ docEntry.getSourcePatientId().getIdNumber() + " / "
				+ docEntry.getSourcePatientId().getAssigningAuthorityUniversalId() + "\n");
		retVal.append("  SourcePatientInfo:          " + docEntry.getSourcePatientInfo() + "\n");
		retVal.append("  Title:                      "
				+ debugLocalizedString(docEntry.getTitle().getLocalizedString()) + "\n");
		retVal.append("  TypeCode:                   " + debugCodeString(docEntry.getTypeCode())
				+ "\n");
		retVal.append("  ClassCode:                  " + debugCodeString(docEntry.getClassCode())
				+ "\n");
		return retVal.toString();
	}

	/**
	 * Creates a debug string for the given InternationalStringType (for
	 * debugging purposes only!)
	 * 
	 * @param data
	 *            the InternationalStringType
	 * @return the debug string <div class="en"></div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static String debugInternationalString(InternationalStringType data) {
		return debugLocalizedString(data.getLocalizedString());
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
	public static String debugLocalizedString(EList<Object> data) {
		StringBuffer retVal = new StringBuffer();
		if (data != null) {
			if (data.isEmpty()) {
				return "null";
			} else {
				for (Object item : data) {
					LocalizedStringType str = (LocalizedStringType) item;
					retVal.append(str.getValue() + " (" + str.getLang() + ") ");
				}
				return retVal.toString();
			}
		} else
			return "null";
	}

	/**
	 * Creates a string with the submission-set metadata (for debugging purposes
	 * only)
	 * 
	 * @param txnData
	 *            <div class="en">the submit transaction data</div>
	 * @return <div class="en">string with the submission-set metadata (for
	 *         debugging purposes only)</div>
	 */
	public static String debugSubmissionSetMetaData(SubmitTransactionData[] txnDatas) {
		StringBuffer retVal = new StringBuffer();
		Integer i = 0;
		for (SubmitTransactionData txnData : txnDatas) {
			i++;

			retVal.append("\nSubmission-Set " + i + "\n");
			// txnData.getDocList();
			// ProvideAndRegisterDocumentSetType metadata =
			// txnData.getMetadata();
			SubmissionSetType ss = txnData.getSubmissionSet();
			retVal.append("  EntryUUID:            " + ss.getEntryUUID() + "\n");
			retVal.append("  SourceId:             " + ss.getSourceId() + "\n");
			retVal.append("  SubmissionTime:       " + ss.getSubmissionTime() + "\n");
			retVal.append("  UniqueId:             " + ss.getUniqueId() + "\n");
			retVal.append("  Title:                " + ss.getTitle() + "\n");
			retVal.append("  PatientId:            " + ss.getPatientId() + "\n");
			retVal.append("  ContentTypeCode:      " + debugCodeString(ss.getContentTypeCode())
					+ "\n");
			retVal.append("  Author:               " + debugAuthorString(ss.getAuthor()) + "\n");
			retVal.append("  AvailabilityStatus:   " + ss.getAvailabilityStatus() + "\n");
			retVal.append("  Comments:             " + debugInternationalString(ss.getComments())
					+ "\n");
			retVal.append("  IntendedRecipient:    ");
			if (ss.getIntendedRecipient().isEmpty()) {
				retVal.append("null");
			} else {
				for (Object item2 : ss.getIntendedRecipient()) {
					retVal.append("\n    TODO IntendedRecipient " + item2.getClass().getName());
				}
			}
			retVal.append("\n");

			retVal.append("  AssociatedFolders:    ");
			if (ss.getAssociatedFolders().isEmpty()) {
				retVal.append("null");
			} else {
				for (Object item2 : ss.getAssociatedFolders()) {
					retVal.append("\n    TODO AssociatedFolders " + item2.getClass().getName());
				}
			}
			retVal.append("\n");

			retVal.append("  AssociatedDocuments:  ");
			if (ss.getAssociatedDocuments().isEmpty()) {
				retVal.append("null");
			} else {
				for (Object item2 : ss.getAssociatedDocuments()) {
					retVal.append("\n    " + (String) item2);
				}
			}
			retVal.append("\n");
		}
		return retVal.toString();
	}

}
