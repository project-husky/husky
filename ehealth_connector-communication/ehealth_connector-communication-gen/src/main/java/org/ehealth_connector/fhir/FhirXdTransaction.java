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

package org.ehealth_connector.fhir;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.communication.AffinityDomain;
import org.ehealth_connector.communication.DocumentMetadata;
import org.ehealth_connector.communication.SubmissionSetMetadata;
import org.hl7.fhir.dstu3.model.DocumentManifest;
import org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent;
import org.hl7.fhir.dstu3.model.DocumentReference;
import org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus;
import org.hl7.fhir.dstu3.model.MessageHeader;
import org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent;
import org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.exceptions.FHIRException;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.parser.IParser;

/**
 * FhirXdTransaction supports the creation of destination and submission-set
 * including documents from a HL7 FHIR Resource. The content of these resources
 * is not currently documented. They are derived resources from FHIR. These
 * resources may be created by the class
 * org.ehealth_connector.demo.fhir.XDResources. This is currently the one any
 * only way to create valid FHIR document resources for XD Transactions. You may
 * edit these FHIR resources in a text editor in order to change the payload of
 * the resulting transaction on your own risk.
 *
 * @see "https://www.hl7.org/fhir/"
 */
public class FhirXdTransaction {

	/**
	 * The class Transaction is a derived FHIR resource containing all
	 * information about destination and submission-set including documents for
	 * a transaction (e.g. IHE XDS submission or IHE XDM portable media
	 * creation)
	 */
	@ResourceDef(name = "DocumentManifest")
	public static class Transaction extends DocumentManifest {

		/** The Constant urnUseAsAffinityDomain. */
		public static final String urnUseAsAffinityDomain = "http://ehealth-connector.org/FhirExtension/useAsAffinityDomain";

		/** The Constant urnUseAsSubmissionSets. */
		public static final String urnUseAsSubmissionSet = "http://ehealth-connector.org/FhirExtension/useAsSubmissionSet";

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = -928980987511039196L;

		/** The affinity domain setting. */
		@Child(name = "affinityDomain", max = 1)
		@Extension(url = urnUseAsAffinityDomain, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "affinityDomain")
		private Reference affinityDomain;

		/** The submission-sets. */
		@Child(name = "submissionSet", max = Child.MAX_UNLIMITED)
		@Extension(url = urnUseAsSubmissionSet, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "submissionSet")
		private Reference submissionSet;

	};

	private final FhirContext fhirCtx = new FhirContext(FhirVersionEnum.DSTU3);

	/**
	 * <div class="en">Empty constructor (default)</div><div class="de"></div>
	 * <div class="fr"></div>.
	 */
	public FhirXdTransaction() {
	}

	/**
	 * <div class="en"> Gets the eHC affinity domain object from the FHIR
	 * resource
	 *
	 * @param transaction
	 *            the FHIR resource
	 * @return the eHC affinity domain object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public AffinityDomain getAffinityDomain(Transaction transaction) {
		final AffinityDomain afinityDomain = new AffinityDomain();
		// set the registry
		afinityDomain.setRegistryDestination(getRegistry(transaction));

		// set the repositories
		final List<org.ehealth_connector.communication.Destination> repos = getRepositories(
				transaction);
		// TODO support of multiple repos as soon as this will be asked
		if (!repos.isEmpty())
			afinityDomain.setRepositoryDestination(repos.get(0));

		return afinityDomain;
	}

	/**
	 * <div class="en">Gets an eHC author object from the FHIR DocumentManifest
	 * object
	 *
	 * @param fhirObject
	 *            the FHIR object
	 * @return eHC author object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public org.ehealth_connector.common.Author getAuthor(DocumentManifest fhirObject) {
		if (!fhirObject.getAuthor().isEmpty())
			return FhirCommon.getAuthor(fhirObject.getAuthor().get(0));
		else
			return null;
	}

	/**
	 * <div class="en">Gets an eHC author object from the FHIR DocumentReference
	 * object
	 *
	 * @param fhirObject
	 *            the FHIR object
	 * @return eHC author object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public org.ehealth_connector.common.Author getAuthor(DocumentReference fhirObject) {
		if (!fhirObject.getAuthor().isEmpty())
			return FhirCommon.getAuthor(fhirObject.getAuthor().get(0));
		else
			return null;
	}

	/**
	 * <div class="en"> Gets an eHC Destination object from the given FHIR
	 * MessageHeader object
	 *
	 * @param fhirObject
	 *            the FHIR object
	 * @return the eHC Destination </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	private org.ehealth_connector.communication.Destination getDestination(
			MessageHeader fhirObject) {
		org.ehealth_connector.communication.Destination retVal = null;

		final String senderOrganizationalOid = fhirObject.getSource().getSoftware();
		String receiverFacilityOid = null;
		String sourceFacilityOid = null;
		URI uri = null;

		// Create the Destination
		try {
			final MessageSourceComponent source = fhirObject.getSource();
			sourceFacilityOid = source.getName();

			final MessageDestinationComponent destination = fhirObject.getDestinationFirstRep();
			receiverFacilityOid = destination.getName();
			uri = new URI(destination.getEndpoint());
		} catch (final URISyntaxException e) {
			// do nothing
		}
		retVal = new org.ehealth_connector.communication.Destination(senderOrganizationalOid, uri);
		if (receiverFacilityOid != null)
			retVal.setReceiverFacilityOid(receiverFacilityOid);
		if (sourceFacilityOid != null)
			retVal.setSenderFacilityOid(sourceFacilityOid);

		return retVal;

	}

	/**
	 * <div class="en">Gets a list containing all document metadatas from the
	 * FHIR resource
	 *
	 * @param transaction
	 *            the FHIR resource
	 * @param receiverFacilityOid
	 *            the receiverFacilityOid will be used to determine which of the
	 *            patient ids is the destination patient id
	 * @param senderFacilityOid
	 *            the senderFacilityOid will be used to determine which of the
	 *            patient ids is the source patient id
	 * @return list containing all document metadatas </div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public List<DocumentMetadata> GetDocumentMetadatas(Transaction transaction,
			String receiverFacilityOid, String senderFacilityOid) {
		final List<DocumentMetadata> retVal = new ArrayList<DocumentMetadata>();

		for (final Resource entry : getResources(transaction)) {
			if (entry instanceof DocumentReference) {
				final DocumentReference fhirObject = (DocumentReference) entry;

				final DocumentMetadata metaData = new DocumentMetadata(
						FhirCommon.getMetadataLanguage(fhirObject));
				metaData.addAuthor(getAuthor(fhirObject));
				metaData.addConfidentialityCode(new Code(fhirObject.getSecurityLabelFirstRep()));

				metaData.setClassCode(new Code(fhirObject.getClass_()));
				metaData.setCodedLanguage(fhirObject.getContentFirstRep().getAttachment()
						.getLanguageElement().getValueAsString());
				metaData.setCreationTime(fhirObject.getCreated());
				metaData.setDocumentDescriptor(FhirCommon.getDocumentDescriptor(fhirObject));
				metaData.setFormatCode(FhirCommon.getFormatCode(fhirObject));
				metaData.setHealthcareFacilityTypeCode(
						new Code(fhirObject.getContext().getFacilityType()));
				metaData.setMimeType(FhirCommon.getMimeType(fhirObject));
				final Patient pat = FhirCommon
						.getPatient(fhirObject.getContext().getSourcePatientInfo());
				metaData.setPatient(pat);
				metaData.setDestinationPatientId(
						FhirCommon.getCommunityPatientId(pat, receiverFacilityOid));
				metaData.setPracticeSettingCode(FhirCommon.getPracticeSettingCode(fhirObject));
				metaData.setSourcePatientId(
						FhirCommon.getCommunityPatientId(pat, senderFacilityOid));
				metaData.setTitle(fhirObject.getDescription());
				metaData.setTypeCode(new Code(fhirObject.getType()));
				metaData.setUniqueId(fhirObject.getMasterIdentifier().getValue());
				metaData.setUri(FhirCommon.getDocumentFilepath(fhirObject));

				retVal.add(metaData);
			}
		}

		return retVal;
	}

	/**
	 * <div class="en"> Gets the registry as eHC Destination object from the
	 * FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the registry as eHC Destination object </div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public org.ehealth_connector.communication.Destination getRegistry(
			DocumentManifest docManifest) {
		org.ehealth_connector.communication.Destination retVal = null;

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			Reference ref = null;
			try {
				ref = entry.getPReference();
			} catch (FHIRException e) {
			}
			if (ref != null) {
				if (ref.getResource() instanceof MessageHeader) {
					final MessageHeader fhirObject = (MessageHeader) ref.getResource();
					if (!fhirObject.getExtensionsByUrl(FhirCommon.urnUseAsRegistryDestination)
							.isEmpty())
						retVal = getDestination((MessageHeader) ref.getResource());
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets a list of repositories as eHC Destination objects
	 * from the FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return list of repositories</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.communication.Destination> getRepositories(
			DocumentManifest docManifest) {
		final List<org.ehealth_connector.communication.Destination> retVal = new ArrayList<org.ehealth_connector.communication.Destination>();

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			Reference ref = null;
			try {
				ref = entry.getPReference();
			} catch (FHIRException e) {
			}
			if (ref != null) {
				if (ref.getResource() instanceof MessageHeader) {
					final MessageHeader fhirObject = (MessageHeader) ref.getResource();
					if (!fhirObject.getExtensionsByUrl(FhirCommon.urnUseAsRepositoryDestination)
							.isEmpty())
						retVal.add(getDestination((MessageHeader) ref.getResource()));
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets a list of Resources
	 *
	 * @param docManifest
	 *            the FHIR document
	 * @return the list of Resources
	 */
	public List<Resource> getResources(DocumentManifest docManifest) {
		List<Resource> retVal = new ArrayList<Resource>();
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			Reference ref = null;
			try {
				ref = entry.getPReference();
			} catch (FHIRException e) {
			}
			if (ref != null) {
				retVal.add((Resource) ref.getResource());
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets the eHC submission-set metadata from the FHIR
	 * resource
	 *
	 * @param transaction
	 *            the FHIR resource
	 * @param receiverFacilityOid
	 *            the receiverFacilityOid will be used to determine which of the
	 *            patient ids is the destination patient id
	 * @return </div> <div class="de"></div> <div class="fr"></div>
	 */
	public SubmissionSetMetadata getSubmissionSetMetadata(Transaction transaction,
			String receiverFacilityOid) {
		final SubmissionSetMetadata retVal = new SubmissionSetMetadata();

		for (final Resource entry : getResources(transaction)) {
			if (entry instanceof DocumentManifest) {
				final DocumentManifest fhirObject = (DocumentManifest) entry;

				retVal.setAuthor(getAuthor(fhirObject));

				AvailabilityStatusType availabilityStatus = AvailabilityStatusType.APPROVED_LITERAL;
				if (fhirObject.getStatusElement().getValue() != DocumentReferenceStatus.CURRENT) {
					availabilityStatus = AvailabilityStatusType.DEPRECATED_LITERAL;
				}
				retVal.setAvailabilityStatus(availabilityStatus);

				final List<org.hl7.fhir.dstu3.model.Extension> extensions = fhirObject
						.getExtensionsByUrl(FhirCommon.urnUseAsComment);
				if (!extensions.isEmpty())
					retVal.setComments(
							((StringType) extensions.get(0).getValue()).getValueAsString());

				retVal.setContentTypeCode(new Code(fhirObject.getType()));

				final Patient pat = FhirCommon.getPatient(fhirObject.getSubject());
				if (!pat.getIds().isEmpty())
					retVal.setDestinationPatientId(
							FhirCommon.getCommunityPatientId(pat, receiverFacilityOid));

				retVal.setSourceId(FhirCommon.removeUrnOidPrefix(fhirObject.getSource()));

				retVal.setTitle(fhirObject.getDescription());
			}
		}

		return retVal;
	}

	/**
	 * Read the transaction object from the FHIR resource file
	 *
	 * @param fileName
	 *            the file name
	 * @return the transaction
	 */
	public Transaction readTransactionFromFile(String fileName) {
		final String resourceString = FhirCommon.getXmlResource(fileName);
		final IParser parser = fhirCtx.newXmlParser();
		return parser.parseResource(Transaction.class, resourceString);
	}

}
