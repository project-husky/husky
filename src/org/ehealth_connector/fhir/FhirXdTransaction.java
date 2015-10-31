/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.fhir;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.ohf.utilities.UUID;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.communication.AffinityDomain;
import org.ehealth_connector.communication.DocumentMetadata;
import org.ehealth_connector.communication.SubmissionSetMetadata;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.DocumentManifest;
import ca.uhn.fhir.model.dstu2.resource.DocumentReference;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader.Destination;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader.Source;
import ca.uhn.fhir.model.dstu2.valueset.BundleTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.DocumentReferenceStatusEnum;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.parser.IParser;

/**
 * FhirXdTransaction supports the creation of destination and submission-set
 * from a HL7 FHIR Resource. The content of these resources is not currently
 * documented. They are derived resources from FHIR. These resources may be
 * created by the class org.ehealth_connector.demo.fhir.XDResources. This is
 * currently the one any only way to create valid FHIR document resources for XD
 * Transactions. You may edit these FHIR resources in a text editor in order to
 * change the payload of the resulting objects on your own risk.
 * 
 * @see "https://www.hl7.org/fhir/"
 */
public class FhirXdTransaction {

	/**
	 * The Class Transaction.
	 */
	@ResourceDef(name = "Bundle")
	public static class Transaction extends Bundle {

		/** The Constant urnUseAsAffinityDomain. */
		public static final String urnUseAsAffinityDomain = "urn:ehealth_connector:FhirExtension:useAsAffinityDomain";

		/** The Constant urnUseAsSubmissionSets. */
		public static final String urnUseAsSubmissionSet = "urn:ehealth_connector:FhirExtension:useAsSubmissionSet";

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = -928980987511039196L;

		/** The affinity domain setting. */
		@Child(name = "affinityDomain", max = 1)
		@Extension(url = urnUseAsAffinityDomain, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "affinityDomain")
		private ResourceReferenceDt affinityDomain;

		/** The submission-sets. */
		@Child(name = "submissionSet", max = Child.MAX_UNLIMITED)
		@Extension(url = urnUseAsSubmissionSet, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "submissionSet")
		private ResourceReferenceDt submissionSet;

		public Transaction() {
			setType(BundleTypeEnum.COLLECTION);
		}

		/**
		 * Adds a destination.
		 * 
		 * @param destination
		 *            - add the destination (FHIR MessageHeader)
		 */
		public void addDestination(MessageHeader destination) {
			Entry entry = this.addEntry();
			entry.setResource(destination);
			entry.setFullUrl(UUID.generateURN());
		}

		/**
		 * Adds a document
		 * 
		 * @param document
		 *            - add the document (FHIR DocumentReference)
		 */
		public void addDocument(DocumentReference document) {
			Entry entry = this.addEntry();
			entry.setResource(document);
			entry.setFullUrl(UUID.generateURN());
		}

		/**
		 * Adds a submission-set.
		 * 
		 * @param submission
		 *            - add the submission-set (FHIR DocumentManifest)
		 */
		public void addSubmissionSet(DocumentManifest submissionSet) {
			Entry entry = this.addEntry();
			entry.setResource(submissionSet);
			entry.setFullUrl(UUID.generateURN());
		}

	};

	/** The m fhir ctx. */
	private final FhirContext mFhirCtx = new FhirContext();

	/**
	 * <div class="en">Empty constructor (default)</div><div class="de"></div>
	 * <div class="fr"></div>.
	 */
	public FhirXdTransaction() {
	}

	public AffinityDomain getAffinityDomain(Transaction transaction) {
		AffinityDomain afinityDomain = new AffinityDomain();
		// set the registry
		afinityDomain.setRegistryDestination(getRegistry(transaction));

		// set the repositories
		List<org.ehealth_connector.communication.Destination> repos = getRepositories(transaction);
		// TODO support of multiple repos as soon as this will be asked
		if (!repos.isEmpty())
			afinityDomain.setRepositoryDestination(repos.get(0));

		return afinityDomain;
	}

	public org.ehealth_connector.common.Author getAuthor(DocumentManifest fhirObject) {
		if (!fhirObject.getAuthor().isEmpty())
			return FhirCommon.getAuthor(fhirObject.getAuthor().get(0));
		else
			return null;
	}

	public org.ehealth_connector.common.Author getAuthor(DocumentReference fhirObject) {
		if (!fhirObject.getAuthor().isEmpty())
			return FhirCommon.getAuthor(fhirObject.getAuthor().get(0));
		else
			return null;
	}

	public List<DocumentMetadata> GetDocumentMetadatas(Transaction transaction,
			String receiverFacilityOid, String senderFacilityOid) {
		List<DocumentMetadata> retVal = new ArrayList<DocumentMetadata>();

		for (Entry entry : transaction.getEntry()) {
			if (entry.getResource() instanceof DocumentReference) {
				DocumentReference fhirObject = (DocumentReference) entry.getResource();

				DocumentMetadata metaData = new DocumentMetadata(
						FhirCommon.getMetadataLanguage(fhirObject));
				metaData.addAuthor(getAuthor(fhirObject));
				metaData.addConfidentialityCode(new Code(fhirObject.getSecurityLabelFirstRep()));

				metaData.setClassCode(new Code(fhirObject.getClassElement()));
				metaData.setCodedLanguage(fhirObject.getContentFirstRep().getAttachment()
						.getLanguageElement().getValueAsString());
				metaData.setCreationTime(fhirObject.getCreated());
				metaData.setDocumentDescriptor(FhirCommon.getDocumentDescriptor(fhirObject));
				metaData.setFormatCode(FhirCommon.getFormatCode(fhirObject));
				metaData.setHealthcareFacilityTypeCode(new Code(fhirObject.getContext()
						.getFacilityType()));
				metaData.setMimeType(FhirCommon.getMimeType(fhirObject));
				Patient pat = FhirCommon.getPatient(fhirObject.getContext().getSourcePatientInfo());
				metaData.setPatient(pat);
				metaData.setDestinationPatientId(FhirCommon.getCommunityPatientId(pat,
						receiverFacilityOid));
				metaData.setPracticeSettingCode(FhirCommon.getPracticeSettingCode(fhirObject));
				metaData.setSourcePatientId(FhirCommon
						.getCommunityPatientId(pat, senderFacilityOid));
				metaData.setTitle(fhirObject.getDescription());
				metaData.setTypeCode(new Code(fhirObject.getType()));
				metaData.setUniqueId(fhirObject.getMasterIdentifier().getValue());
				metaData.setUri(FhirCommon.getDocumentFilepath(fhirObject));

				retVal.add(metaData);
			}
		}

		return retVal;
	}

	public org.ehealth_connector.communication.Destination getRegistry(Bundle bundle) {
		org.ehealth_connector.communication.Destination retVal = null;

		for (Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof MessageHeader) {
				MessageHeader fhirObject = (MessageHeader) entry.getResource();
				if (!fhirObject
						.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsRegistryDestination)
						.isEmpty())
					retVal = getDestination((MessageHeader) entry.getResource());
			}
		}

		return retVal;
	}

	public List<org.ehealth_connector.communication.Destination> getRepositories(Bundle bundle) {
		List<org.ehealth_connector.communication.Destination> retVal = new ArrayList<org.ehealth_connector.communication.Destination>();

		for (Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof MessageHeader) {
				MessageHeader fhirObject = (MessageHeader) entry.getResource();
				if (!fhirObject.getUndeclaredExtensionsByUrl(
						FhirCommon.urnUseAsRepositoryDestination).isEmpty())
					retVal.add(getDestination((MessageHeader) entry.getResource()));
			}
		}

		return retVal;
	}

	public SubmissionSetMetadata getSubmissionSetMetadata(Transaction transaction,
			String receiverFacilityOid) {
		SubmissionSetMetadata retVal = new SubmissionSetMetadata();

		for (Entry entry : transaction.getEntry()) {
			if (entry.getResource() instanceof DocumentManifest) {
				DocumentManifest fhirObject = (DocumentManifest) entry.getResource();

				retVal.setAuthor(getAuthor(fhirObject));

				AvailabilityStatus availabilityStatus = AvailabilityStatus.APPROVED;
				if (fhirObject.getStatusElement().getValueAsEnum() != DocumentReferenceStatusEnum.CURRENT)
					availabilityStatus = AvailabilityStatus.DEPRECATED;
				retVal.setAvailabilityStatus(availabilityStatus);

				List<ExtensionDt> extensions = fhirObject
						.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsComment);
				if (!extensions.isEmpty())
					retVal.setComments(((StringDt) extensions.get(0).getValue()).getValueAsString());

				retVal.setContentTypeCode(new Code(fhirObject.getType()));

				Patient pat = FhirCommon.getPatient(fhirObject.getSubject());
				if (!pat.getIds().isEmpty())
					retVal.setDestinationPatientId(FhirCommon.getCommunityPatientId(pat,
							receiverFacilityOid));

				retVal.setSourceId(fhirObject.getSource().replace("urn:oid:", ""));

				retVal.setTitle(fhirObject.getDescription());
			}
		}

		return retVal;
	}

	/**
	 * Read transaction from file.
	 * 
	 * @param fileName
	 *            the file name
	 * @return the transaction
	 */
	public Transaction readTransactionFromFile(String fileName) {
		String resourceString = FhirCommon.getXmlResource(fileName);
		IParser parser = mFhirCtx.newXmlParser();
		return parser.parseResource(Transaction.class, resourceString);
	}

	private org.ehealth_connector.communication.Destination getDestination(MessageHeader fhirObject) {
		org.ehealth_connector.communication.Destination retVal = null;

		String senderOrganizationalOid = fhirObject.getSource().getSoftware();
		String receiverFacilityOid = null;
		String sourceFacilityOid = null;
		URI uri = null;

		// Create the Destination
		try {
			Source source = fhirObject.getSource();
			sourceFacilityOid = source.getName();

			Destination destination = fhirObject.getDestinationFirstRep();
			receiverFacilityOid = destination.getName();
			uri = new URI(destination.getEndpoint());
		} catch (URISyntaxException e) {
			// do nothing
		}
		retVal = new org.ehealth_connector.communication.Destination(senderOrganizationalOid, uri);
		if (receiverFacilityOid != null)
			retVal.setReceiverFacilityOid(receiverFacilityOid);
		if (sourceFacilityOid != null)
			retVal.setSenderFacilityOid(sourceFacilityOid);

		return retVal;

	}

}
