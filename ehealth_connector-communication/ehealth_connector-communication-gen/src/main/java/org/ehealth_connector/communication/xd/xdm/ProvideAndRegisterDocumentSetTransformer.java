package org.ehealth_connector.communication.xd.xdm;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Random;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Hl7Util;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Association;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Author;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Folder;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Name;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Recipient;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.SubmissionSet;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Telecom;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.lcm.SubmitObjectsRequest;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.AssociationType1;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.ClassificationType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.ExternalIdentifierType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.ExtrinsicObjectType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.InternationalStringType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.LocalizedStringType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.ObjectRefType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.RegistryObjectListType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.RegistryPackageType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.SlotType1;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.ValueListType;
import org.openhealthtools.ihe.common.hl7v2.format.MessageDelimiters;
import org.openhealthtools.ihe.xds.metadata.constants.DocumentEntryConstants;
import org.openhealthtools.ihe.xds.metadata.constants.FolderConstants;
import org.openhealthtools.ihe.xds.metadata.constants.SubmissionSetConstants;
import org.openhealthtools.ihe.xds.metadata.constants.UUIDs;
import org.openhealthtools.ihe.xds.metadata.transform.EbXML_3_0TransformerConstants;
import org.openhealthtools.ihe.xds.metadata.transform.MetadataTransformationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProvideAndRegisterDocumentSetTransformer {

	/** Descriptor for Transformer */
	public static final String DESCRIPTOR = "EBXML_3_0_PRDS_XFRMR";

	private static final String RIM_NAMESPACE = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0";

	private static final int MAX_SLOT_LENGTH = 256;

	/** Logger */
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/** submitReq for all of metadata */
	private SubmitObjectsRequest submitReq;

	/**
	 * Creates the transformer.
	 */
	public ProvideAndRegisterDocumentSetTransformer() {
		this.submitReq = null;
	}

	/**
	 * Returns the SubmitObjectsRequestType containing the all metadata values.
	 * Returns null if the transformation has not been executed, or had failed.
	 * 
	 * @return the submitReq
	 */
	public SubmitObjectsRequest getSubmitReq() {
		return submitReq;
	}

	/**
	 * Renders a SubmitObjectsRequestType containing the metadata values of the
	 * parameter, formatted in ebXML
	 * 
	 * @throws MetadataTransformationException
	 * @see org.openhealthtools.ihe.xds.metadata.transform.ProvideAndRegisterDocumentSetTransformer#transform(org.openhealthtools.ihe.xds.metadata.ProvideAndRegisterDocumentSetType)
	 */
	public void transform(ProvideAndRegisterDocumentSet docSet) throws MetadataTransformationException {
		if (docSet.getSubmissionSet() == null) {
			logger.error("SubmissionSet metadata is null.Cannot proceed with transformation.");
			throw new MetadataTransformationException(
					"SubmissionSet metadata is null.Cannot proceed with transformation.");
		} else if (docSet.getSubmissionSet().getEntryUuid() == null) {
			logger.error("SubmissionSet entryUUID is null. Cannot proceed with transformation.");
			throw new MetadataTransformationException(
					"SubmissionSet entryUUID is null. Cannot proceed with transformation.");
		}

		// Create the ebXML from the data we have
		// connect to the Repository and send the transaction.
		this.submitReq = new SubmitObjectsRequest();
		this.submitReq.setRegistryObjectList(new RegistryObjectListType());

		// stick in the rim:ObjectRef entries
		setObjectRefs(docSet, this.submitReq);

		// ----------------------------------
		// Submission Set metadata of the submission
		setSubmissionSet(docSet);

		// set the classification of this thing to declare it is a
		// submission set
		var classification = new ClassificationType();
		// set id (required in ebXML 3.0 (and not in 2.1)
		classification.setId(getRandomId("cl", 0));
		classification.setClassifiedObject(docSet.getSubmissionSet().getEntryUuid());
		classification.setClassificationNode(UUIDs.SUBMISSON_SET_OBJECT);
		// set nodeRepresentation -- required for external classifications
		classification.setNodeRepresentation("");// intentionally left blank, per IHE (see discussion on Issue 15)
		var qNameClassification = new QName(RIM_NAMESPACE, "Classification");

		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameClassification, ClassificationType.class, classification));

		// ----------------------------------
		// Document Section of the submission
		// Add each of the document entries to the extrinsic object under the root
		// leafRegistry Object
		if (docSet.getDocuments().isEmpty()) {
			logger.info("Submission set contains no documents.");
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("Adding document metadata to submission set.  There are {} documents to add.",
						docSet.getDocuments().size());
			}
			setDocumentEntries(docSet);
		}

		// ----------------------------------
		// Folders section of the submission
		if (docSet.getFolders().isEmpty()) {
			logger.info("Submission set contains no folders.");
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("Adding folder metadata to submission set.  There are {} folders to add.",
						docSet.getFolders().size());
			}
			setFolders(docSet);
		}

		// --------------------------------------------------------------
		// Figure out if we are referencing any additional existing document entries
		// or existing folders among the lists of associated documents and
		// associated folders listed with the submission set that we have not captured
		// thus far.
		if (logger.isDebugEnabled()) {
			logger.debug("Verifying Submission Set associated documents and associated folders.");
		}
		transformAssociations(docSet);

	}

	/** support method to generate all the document entry metadata */
	private void setDocumentEntries(ProvideAndRegisterDocumentSet docSet) throws MetadataTransformationException {

		Iterator<Document> i = docSet.getDocuments().iterator();
		while (i.hasNext()) {
			Document de = i.next();

			// check for null document entry uuid
			if (de.getDocumentEntry() == null || de.getDocumentEntry().getEntryUuid() == null) {
				logger.error(
						"DocumentEntry.entryUUID is null. This DocumentEntry will not be included in the transformation.");
				continue;
			}

			// check if this document entry is existing
			if (de.getDocumentEntry() != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("Found an existing Document Entry: {}", de.getDocumentEntry().getEntryUuid());
				}
				var docRef = new ObjectRefType();
				docRef.setId(de.getDocumentEntry().getEntryUuid());
				var qNameObjectRef = new QName(RIM_NAMESPACE, "ObjectRef");
				this.submitReq.getRegistryObjectList().getIdentifiable()
						.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, docRef));
			}
			// else this is a "new" document
			else {
				var extrinsicObjectType = transformDocumentEntry(de.getDocumentEntry());

				// set document entry metadata
				if (extrinsicObjectType == null) {
					logger.error(
							"Null Extrinsic Object produced for {}. This DocumentEntry will not be included in the transformation.",
							de.getDocumentEntry().getEntryUuid());
					continue;
				}

				var qNameExtrinsicObject = new QName(RIM_NAMESPACE, "ExtrinsicObject");

				submitReq.getRegistryObjectList().getIdentifiable()
						.add(new JAXBElement<>(qNameExtrinsicObject, ExtrinsicObjectType.class, extrinsicObjectType));

			}
		}

		if (logger.isDebugEnabled())
			logger.debug("All document metadata added to submission set.");
	}

	/** support method to generate all the folder metadata */
	private void setFolders(ProvideAndRegisterDocumentSet docSet) throws MetadataTransformationException {

		Iterator<Folder> i = docSet.getFolders().iterator();
		while (i.hasNext()) {
			Folder fol = i.next();

			// check for null folder entryUUID
			if (fol.getEntryUuid() == null) {
				logger.error("Folder.entryUUID is null. This Folder will not be included in the transformation.");
				continue;
			}
			// transform folder
			RegistryPackageType folderData = transformFolder(fol);

			// check if this document entry is existing
			if (fol.getEntryUuid() != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("Found an existing Folder: {}", fol.getEntryUuid());
				}
				var folRef = new ObjectRefType();
				folRef.setId(fol.getEntryUuid());
				var qNameObjectRef = new QName(RIM_NAMESPACE, "ObjectRef");
				this.submitReq.getRegistryObjectList().getIdentifiable()
						.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, folRef));
			}
			// else this is a "new" folder
			else {
				// set folder metadata
				if (folderData == null) {
					logger.error(
							"Null RegistryPackage produced for {}. This Folder will not be included in the transformation.",
							fol.getEntryUuid());
					continue;
				}
				var qNameObjectRef = new QName(RIM_NAMESPACE, "RegistryPackage");
				this.submitReq.getRegistryObjectList().getIdentifiable()
						.add(new JAXBElement<>(qNameObjectRef, RegistryPackageType.class, folderData));

				// set the classification type for the folder (ie. declare - this is
				// a folder)
				var classification = new ClassificationType();
				// set id (required in ebXML 3.0 (and not in 2.1)
				classification.setId(getRandomId("cf", 0));
				classification.setClassifiedObject(fol.getEntryUuid());
				classification.setClassificationNode(UUIDs.FOLDER_OBJECT);
				// set nodeRepresentation -- required for external classifications
				classification.setNodeRepresentation("");// intentionally left blank, per IHE (see discussion on Issue
															// 15)
				var qNameClassification = new QName(RIM_NAMESPACE, "Classification");
				this.submitReq.getRegistryObjectList().getIdentifiable()
						.add(new JAXBElement<>(qNameClassification, ClassificationType.class, classification));
			}

		} // end folders loop

		if (logger.isDebugEnabled())
			logger.debug("All folder metadata added to submission set.");
	}

	/**
	 * support function that sets the necessary ObjectReferences for the ebXML
	 * metadata structure
	 */
	/**
	 * support function that sets the necessary ObjectReferences for the ebXML
	 * metadata structure
	 */
	private void setObjectRefs(ProvideAndRegisterDocumentSet docSet, SubmitObjectsRequest submitReq) {
		var qNameObjectRef = new QName(RIM_NAMESPACE, "ObjectRef");

		var oRef = new ObjectRefType();
		oRef.setId(UUIDs.DOC_ENTRY_OBJECT);

		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.DOC_ENTRY_AUTHOR);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.DOC_ENTRY_CLASS_CODE);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.DOC_ENTRY_CONFIDENTIALITY_CODE);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.DOC_ENTRY_EVENT_CODE);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.DOC_ENTRY_FORMAT_CODE);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.DOC_ENTRY_HEALTH_CARE_FACILITY_CODE);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.DOC_ENTRY_PRACTICE_SETTING_CODE);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.DOC_ENTRY_TYPE_CODE);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.DOC_ENTRY_UNIQUE_IDENTIFICATION_SCHEME);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.DOC_ENTRY_PATIENT_IDENTIFICATION_SCHEME);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.SUBMISSON_SET_AUTHOR);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.SUBMISSION_SET_CONTENT_TYPE_CODE);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.SUBMISSION_SET_SOURCE_IDENTIFICATION_SCHEME);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.SUBMISSION_SET_UNIQUE_IDENTIFICATION_SCHEME);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.SUBMISSION_SET_PATIENT_IDENTIFICATION_SCHEME);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		//
		if (!docSet.getFolders().isEmpty()) {
			// fix for issue tracker : artf3485 - only add object refs when there are
			// folders
			oRef = new ObjectRefType();
			oRef.setId(UUIDs.FOLDER_CODE);
			submitReq.getRegistryObjectList().getIdentifiable()
					.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
			//
			oRef = new ObjectRefType();
			oRef.setId(UUIDs.FOLDER_UNIQUE_IDENTIFICATION_SCHEME);
			submitReq.getRegistryObjectList().getIdentifiable()
					.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
			//
			oRef = new ObjectRefType();
			oRef.setId(UUIDs.FOLDER_PATIENT_IDENTIFICATION_SCHEME);
			submitReq.getRegistryObjectList().getIdentifiable()
					.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
			//
			oRef = new ObjectRefType();
			oRef.setId(UUIDs.FOLDER_OBJECT);
			submitReq.getRegistryObjectList().getIdentifiable()
					.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
		}
		//
		oRef = new ObjectRefType();
		oRef.setId(UUIDs.SUBMISSON_SET_OBJECT);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));

		oRef = new ObjectRefType();
		oRef.setId(UUIDs.HAS_MEMBER_UUID);
		submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, oRef));
	}

	/** support method to generate all the submission set metadata */
	private void setSubmissionSet(ProvideAndRegisterDocumentSet docSet) throws MetadataTransformationException {
		RegistryPackageType registryPackage = transformSubmissionSet(docSet.getSubmissionSet());
		var qNameRegistryPackage = new QName(RIM_NAMESPACE, "RegistryPackage");

		// set submission set metadata
		if (registryPackage == null) {
			logger.error("Null RegistryPackage produced for submission set metadata.");
			throw new MetadataTransformationException("Null RegistryPackage produced for submission set metadata.");
		}
		this.submitReq.getRegistryObjectList().getIdentifiable()
				.add(new JAXBElement<>(qNameRegistryPackage, RegistryPackageType.class, registryPackage));

		// NOTE: we need to wait until the rest of the transforms have taken place
		// before we
		// examine the list of submission set associated docuemtns and folders and
		// verify that
		// everything made it across the transformation
		if (logger.isDebugEnabled())
			logger.debug("All submission set metadata added.");
	}

	/**
	 * support method that goes through the lists of associated documents and
	 * associated folders on the SubmissionSet object of this
	 * ProvideAndRegisterDocumentSet and checks to see if any existing documents and
	 * folders have been "forgotten". DocumentEntries and Folders have the potential
	 * to be "forgotten" if there does not exist a DocumentEntry (where
	 * existing=true) or Folder (where existing=true) object representing this
	 * information in the ProvideAndRegisterDocumentSet. NOTE: documents and folders
	 * of this "forgotten" nature are ASSUMED to be existing not newly created.
	 * 
	 * @param docSet
	 */
	private void transformAssociations(ProvideAndRegisterDocumentSet docSet) {
		if (logger.isDebugEnabled()) {
			logger.debug("Verifying associated documents");
		}
		Iterator<Association> i = docSet.getAssociations().iterator();

		while (i.hasNext()) {
			var association1 = i.next();
			String docUUID = association1.getTargetUuid();

			// add obj ref
			var qNameObjectRef = new QName(RIM_NAMESPACE, "ObjectRef");
			var objectRef = new ObjectRefType();
			objectRef.setId(docUUID);
			this.submitReq.getRegistryObjectList().getIdentifiable()
					.add(new JAXBElement<>(qNameObjectRef, ObjectRefType.class, objectRef));

			// association
			var association = new AssociationType1();
			// set id (required in ebXML 3.0 (and not in 2.1)
			association.setId(getRandomId("a", 0));
			association.setAssociationType(association1.getAssociationType().getOpcode30());
			association.setSourceObject(association1.getSourceUuid());
			association.setTargetObject(association1.getTargetUuid());

			// Create a slot, and a value list, and a value to set the SubmissionSetStatus
			// element
			var submissionSetStatusSlot = new SlotType1();
			submissionSetStatusSlot.setName("SubmissionSetStatus");
			submissionSetStatusSlot.setValueList(new ValueListType());
			ValueListType submissionSetStatusSlotValueList = submissionSetStatusSlot.getValueList();
			submissionSetStatusSlotValueList.getValue().add("Reference");
			association.getSlot().add(submissionSetStatusSlot);

			// add the assocation
			var qNameAssociation = new QName(RIM_NAMESPACE, "Association");
			this.submitReq.getRegistryObjectList().getIdentifiable()
					.add(new JAXBElement<>(qNameAssociation, AssociationType1.class, association));

		}
	}

	/** sets the attributes on the Registry package **/
	private void setRegistryPackageAttributes(SubmissionSet subSet, RegistryPackageType setData) {
		// set RegistryPackage/@id
		setData.setId(subSet.getEntryUuid());

		// set RegistryPackage/@status
		if (subSet.getAvailabilityStatus() != null) {
			if (subSet.getAvailabilityStatus().equals(AvailabilityStatus.APPROVED)) {
				setData.setStatus(EbXML_3_0TransformerConstants.APPROVED_STATUS);
			} else if (subSet.getAvailabilityStatus().equals(AvailabilityStatus.DEPRECATED)) {
				setData.setStatus(EbXML_3_0TransformerConstants.DEPRECATED_STATUS);
			} else if (subSet.getAvailabilityStatus().equals(AvailabilityStatus.SUBMITTED)) {
				setData.setStatus(EbXML_3_0TransformerConstants.SUBMITTED_STATUS);
			}
		}
	}

	private static final Random rngr = new Random();

	public static final String getRandomId(String prefix, int iteration) {
		var sb = new StringBuilder();
		sb.append(prefix);
		sb.append(System.currentTimeMillis());
		sb.append(rngr.nextLong());
		sb.append(iteration);
		return sb.toString();
	}

	private InternationalStringType convertLocalizedString(LocalizedString localizedString) {
		var intStringType = new InternationalStringType();
		var localizedSTringType = new LocalizedStringType();
		localizedSTringType.setValue(localizedString.getValue());
		localizedSTringType.setLang(localizedString.getLang());
		localizedSTringType.setCharset(localizedString.getCharset());
		intStringType.getLocalizedString().add(localizedSTringType);

		return intStringType;
	}

	/**
	 * Sets the metadata values in the Classifications of the RegistryPackage
	 */
	private void setRegistryPackageClassifications(SubmissionSet subSet, RegistryPackageType setData) {

		// contentTypeCode
		// ////////////////////////////////////////////////////////////
		if (subSet.getContentTypeCode() != null) {
			final var c = new ClassificationType();
			// set contentTypeCode internal uuid
			c.setClassificationScheme(UUIDs.SUBMISSION_SET_CONTENT_TYPE_CODE);
			// set classifiedObject
			c.setClassifiedObject(subSet.getEntryUuid());
			// set id (required in ebXML 3.0 (and not in 2.1)
			c.setId(getRandomId("cs", 1));

			// set contentTypeCode code value
			c.setNodeRepresentation(subSet.getContentTypeCode().getCode());
			// set contentTypeCode diaplay name
			c.setName(convertLocalizedString(subSet.getContentTypeCode().getDisplayName()));

			// set coding scheme name in slot
			if (subSet.getContentTypeCode().getSchemeName() != null) {
				final List<SlotType1> slots = c.getSlot();
				final var slot = new SlotType1();
				final var list = new ValueListType();
				slot.setValueList(list);
				slot.setName(SubmissionSetConstants.CODING_SCHEME);
				slot.getValueList().getValue().add(subSet.getContentTypeCode().getSchemeName());
				slots.add(slot);
			}
			setData.getClassification().add(c);
		}

		// author
		// //////////////////////////////////////////////////////////////////////////
		if (subSet.getAuthors() != null && !subSet.getAuthors().isEmpty() && subSet.getAuthors().get(0) != null) {
			// create classification for this author
			final var c = new ClassificationType();
			// set contentTypeCode internal uuid
			c.setClassificationScheme(UUIDs.SUBMISSON_SET_AUTHOR);
			// set classifiedObject
			c.setClassifiedObject(subSet.getEntryUuid());
			// set id (required in ebXML 3.0 (and not in 2.1)
			c.setId(getRandomId("cs", 2));
			// set nodeRepresentation -- required for external classifications
			c.setNodeRepresentation("");// intentionally left blank, per IHE
										// (see discussion on Issue 15)

			// begin to set author data
			final List<SlotType1> slots = c.getSlot();
			var slot = new SlotType1();
			var list = new ValueListType();

			// author institution
			if (subSet.getAuthors().get(0).getAuthorInstitution() != null
					&& !subSet.getAuthors().get(0).getAuthorInstitution().isEmpty()) {

				slot.setValueList(list);
				slot.setName(SubmissionSetConstants.AUTHOR_INSTITUTION);
				final Iterator<Organization> j = subSet.getAuthors().get(0).getAuthorInstitution().iterator();
				while (j.hasNext()) {
					slot.getValueList().getValue().add(
							Hl7Util.generateXon(j.next(), MessageDelimiters.COMPONENT, MessageDelimiters.SUBCOMPONENT));
				}
				slots.add(slot);

			}

			// authorPerson
			if (subSet.getAuthors().get(0).getAuthorPerson() != null) {
				slot = new SlotType1();
				list = new ValueListType();
				slot.setValueList(list);
				slot.setName(SubmissionSetConstants.AUTHOR_PERSON);
				slot.getValueList().getValue().add(Hl7Util.generateFromCx(subSet.getAuthors().get(0).getAuthorPerson(),
						MessageDelimiters.COMPONENT, MessageDelimiters.SUBCOMPONENT));
				slots.add(slot);
			}

			// authorRole
			if (subSet.getAuthors().get(0).getAuthorRole() != null
					&& !subSet.getAuthors().get(0).getAuthorRole().isEmpty()) {

				slot = new SlotType1();
				list = new ValueListType();
				slot.setValueList(list);
				slot.setName(SubmissionSetConstants.AUTHOR_ROLE);
				final Iterator<Identifiable> j = subSet.getAuthors().get(0).getAuthorRole().iterator();
				while (j.hasNext()) {
					slot.getValueList().getValue().add(j.next().getId());
				}
				slots.add(slot);

			}

			// authorSpecialty
			if (subSet.getAuthors().get(0).getAuthorSpecialty() != null
					&& !subSet.getAuthors().get(0).getAuthorSpecialty().isEmpty()) {

				slot = new SlotType1();
				list = new ValueListType();
				slot.setValueList(list);
				slot.setName(SubmissionSetConstants.AUTHOR_SPECIALITY);
				final Iterator<Identifiable> j = subSet.getAuthors().get(0).getAuthorSpecialty().iterator();
				while (j.hasNext()) {
					slot.getValueList().getValue().add(j.next().getId());
				}
				slots.add(slot);

			}
			// Added by CP 524, 627 and 628 for IHE ITI TF v9 (2012-2013)
			// authorTelecommunication
			if (subSet.getAuthors().get(0).getAuthorTelecom() != null
					&& !subSet.getAuthors().get(0).getAuthorTelecom().isEmpty()) {

				slot = new SlotType1();
				list = new ValueListType();
				slot.setValueList(list);
				slot.setName(DocumentEntryConstants.AUTHOR_TELECOMMUNICATION);
				final Iterator<Telecom> j = subSet.getAuthors().get(0).getAuthorTelecom().iterator();
				while (j.hasNext()) {
					slot.getValueList().getValue().add(Hl7Util.generateXtn(j.next(), MessageDelimiters.COMPONENT));
				}
				slots.add(slot);

			}
			setData.getClassification().add(c);
		}
	}

	/**
	 * Sets the metadata values in the ExternalIdentifiers of the RegistryPackage
	 */
	private void setRegistryPackageExternalIdentifiers(SubmissionSet subSet, RegistryPackageType setData) {
		final List<org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.ExternalIdentifierType> externalIdentifiers = setData
				.getExternalIdentifier();
		var idName = new LocalizedStringType();

		var exIDName = new InternationalStringType();

		// patientId /////////////////////////////////////////////////////
		var exID = new ExternalIdentifierType();
		if (subSet.getPatientId() != null) {
			// set id and registryObject (required in ebXML 3.0 (and not in 2.1)
			exID.setId(getRandomId("i", 1));
			exID.setRegistryObject(subSet.getEntryUuid());
			// set patient id
			exID.setValue(Hl7Util.generateFromCx(subSet.getPatientId(), MessageDelimiters.COMPONENT,
					MessageDelimiters.SUBCOMPONENT));
			// set "XDSSubmissionSet.patientId" to be the name of this
			// ExternalIdentifier
			idName.setValue(SubmissionSetConstants.PATIENT_ID);
			exIDName.getLocalizedString().add(idName);
			exID.setName(exIDName);
			// set identificaitonScheme
			exID.setIdentificationScheme(UUIDs.SUBMISSION_SET_PATIENT_IDENTIFICATION_SCHEME);
			// add to ExtrinsicObject/ExternalIdentifier
			externalIdentifiers.add(exID);
		}

		// sourceId /////////////////////////////////////////////////////
		exID = new ExternalIdentifierType();
		idName = new LocalizedStringType();
		exIDName = new InternationalStringType();
		// set id in ExternalIdentifier
		if (subSet.getSourceId() != null) {
			// set id and registryObject (required in ebXML 3.0 (and not in 2.1)
			exID.setId(getRandomId("i", 2));
			exID.setRegistryObject(subSet.getEntryUuid());
			// set unique id
			exID.setValue(subSet.getSourceId());
			// set "XDSSubmissionSet.sourceID" to be the name of this
			// ExternalIdentifier
			idName = new LocalizedStringType();
			idName.setValue(SubmissionSetConstants.SOURCE_ID);
			exIDName = new InternationalStringType();
			exIDName.getLocalizedString().add(idName);
			exID.setName(exIDName);
			// set identificaitonScheme
			exID.setIdentificationScheme(UUIDs.SUBMISSION_SET_SOURCE_IDENTIFICATION_SCHEME);
			// add to REgistryPackage/ExternalIdentifier
			externalIdentifiers.add(exID);
		}

		// uniqueId /////////////////////////////////////////////////////
		exID = new ExternalIdentifierType();
		if (subSet.getUniqueId() != null) {
			// set id and RegistryObject (required in ebXML 3.0 (and not in 2.1)
			exID.setId(getRandomId("i", 3));
			exID.setRegistryObject(subSet.getEntryUuid());
			exID.setValue(subSet.getUniqueId());
			// set "XDSSubmissionSet.uniqueID" to be the name of this
			// ExternalIdentifier
			idName = new LocalizedStringType();
			idName.setValue(SubmissionSetConstants.UNIQUE_ID);
			exIDName = new InternationalStringType();
			exIDName.getLocalizedString().add(idName);
			exID.setName(exIDName);
			// set identificaitonScheme
			exID.setIdentificationScheme(UUIDs.SUBMISSION_SET_UNIQUE_IDENTIFICATION_SCHEME);
			// add to ExtrinsicObject/ExternalIdentifier
			externalIdentifiers.add(exID);
		}
	}

	/**
	 * Sets the metadata values in the slots of the ExtrinsicObject
	 */
	private void setRegistryPackageSlots(SubmissionSet subSet, RegistryPackageType setData) {

		final List<SlotType1> slots = setData.getSlot();

		var slot = new SlotType1();
		var list = new ValueListType();

		// submissionTime
		if (subSet.getSubmissionTime() != null) {
			slot = new SlotType1();
			list = new ValueListType();
			slot.setValueList(list);
			slot.setName(SubmissionSetConstants.SUBMISSION_TIME);
			slot.getValueList().getValue().add(DateUtil.formatDateTime(subSet.getSubmissionTime().getDateTime()));
			slots.add(slot);
		}
		// intendedRecipient
		if (!subSet.getIntendedRecipients().isEmpty()) {
			slot = new SlotType1();
			list = new ValueListType();
			slot.setValueList(list);
			slot.setName(SubmissionSetConstants.INTENDED_RECIPIENT);

			final Iterator<Recipient> i = subSet.getIntendedRecipients().iterator();
			while (i.hasNext()) {
				final var recipient = i.next();
				var slotValue = new StringBuilder();
				// get organization, if present
				if (recipient.getOrganization() != null) {
					slotValue.append(Hl7Util.generateXon(recipient.getOrganization(), MessageDelimiters.COMPONENT,
							MessageDelimiters.SUBCOMPONENT));
				}
				// get person, if present
				if (recipient.getPerson() != null) {
					slotValue.append(MessageDelimiters.FIELD);
					slotValue.append(Hl7Util.generateFromCx(recipient.getPerson(), MessageDelimiters.COMPONENT,
							MessageDelimiters.SUBCOMPONENT));

				}
				// Added by CP 524, 627 and 628 for IHE ITI TF v9 (2012-2013)
				// get telecommunication, if present
				if (recipient.getTelecom() != null) {
					slotValue.append(MessageDelimiters.FIELD);
					slotValue.append(Hl7Util.generateXtn(recipient.getTelecom(), MessageDelimiters.COMPONENT));
				}
				// add to the slot if value is present
				if (slotValue.length() > 0) {
					slot.getValueList().getValue().add(slotValue.toString());
				}
			}
			slots.add(slot);
		}
	}

	/**
	 * Renders an RegistryPackageType containing the submission set metadata values
	 * of the parameter, formatted in ebXML
	 *
	 * @throws MetadataTransformationException
	 * @see org.openhealthtools.ihe.xds.metadata.transform.SubmissionSetTransformer#transform(org.openhealthtools.ihe.xds.metadata.SubmissionSetType)
	 */
	public RegistryPackageType transformSubmissionSet(SubmissionSet subSet) throws MetadataTransformationException {
		if (subSet == null) {
			logger.error("SubmissionSet is null, cannot execute transformation.");
			throw new MetadataTransformationException("SubmissionSet is null, cannot execute transformation.");
		}

		var setData = new RegistryPackageType();

		// set RegistryPackage/@id
		if (logger.isDebugEnabled()) {
			logger.debug("Setting attributes on the Registry Package.");
		}
		setRegistryPackageAttributes(subSet, setData);

		// set RegistryPackage.Description
		if (logger.isDebugEnabled()) {
			logger.debug("Setting Description on the Registry Package.");
		}
		setData.setDescription(convertLocalizedString(subSet.getComments()));

		// set RegistryPackage.Name
		if (logger.isDebugEnabled()) {
			logger.debug("Setting Name on the Registry Package.");
		}
		setData.setName(convertLocalizedString(subSet.getTitle()));

		// set RegistryPackage slots
		if (logger.isDebugEnabled()) {
			logger.debug("Setting Slots on the Registry Package.");
		}
		setRegistryPackageSlots(subSet, setData);

		// setRegistryPackage classifications
		if (logger.isDebugEnabled()) {
			logger.debug("Setting Classifications on the Registry Package.");
		}
		setRegistryPackageClassifications(subSet, setData);

		// set RegistryPackage external Identifiers
		if (logger.isDebugEnabled()) {
			logger.debug("Setting External Identifiers on the Registry Package.");
		}
		setRegistryPackageExternalIdentifiers(subSet, setData);

		return setData;

	}

	public AssociationType1 transformAssociation(Association association) throws MetadataTransformationException {
		var parentData = new AssociationType1();
		// set ebXML id (required in ebXML 3.0 (and not in 2.1)
		parentData.setId(getRandomId("a", 0));

		// parent id
		if (association.getTargetUuid() != null) {
			parentData.setTargetObject(association.getTargetUuid());
		}
		// parent relationship
		if (association.getAssociationType() != null) {
			parentData.setAssociationType(EbXML_3_0TransformerConstants.IHE_ASSOCIATION_TYPE_PREFIX
					+ association.getAssociationType().getOpcode30());
		}
		// parent relationship code
		if (association.getDocCode() != null) {
			// get list of classifications
			List<ClassificationType> classifications = parentData.getClassification();
			var c = new ClassificationType();
			List<SlotType1> slots = c.getSlot();
			var slot = new SlotType1();
			var list = new ValueListType();

			if (association.getEntryUuid() == null) {
				association.assignEntryUuid();
			}
			parentData.setId(association.getEntryUuid());

			// set internal uuid
			c.setClassificationScheme(UUIDs.DOC_ENTRY_PARENT_DOCUMENT_RELATIONSHIP_CODE);
			// set classifiedObject (this association)
			c.setClassifiedObject(association.getEntryUuid());

			// set classCode code value
			c.setNodeRepresentation(association.getDocCode().getCode());
			// set classCode diaplay name
			c.setName(convertLocalizedString(association.getDocCode().getDisplayName()));
			// set coding scheme name in slot
			if (association.getDocCode().getSchemeName() != null) {
				slot.setValueList(list);
				slot.setName(DocumentEntryConstants.CODING_SCHEME);
				slot.getValueList().getValue().add(association.getDocCode().getSchemeName());
				slots.add(slot);
			}

			classifications.add(c);
		}

		parentData.setSourceObject(association.getSourceUuid());

		return parentData;
	}

	/**
	 * Renders an ExtrinsicObjectType and, if applicable, an AssociationType1
	 * containing the document entry metadata values of the parameter, formatted in
	 * ebXML
	 * 
	 * @throws MetadataTransformationException
	 * @see org.openhealthtools.ihe.xds.metadata.transform.DocumentEntryTransformer#transform(org.openhealthtools.ihe.xds.metadata.DocumentEntryType)
	 */
	public ExtrinsicObjectType transformDocumentEntry(DocumentEntry docEntry) throws MetadataTransformationException {
		if (docEntry == null) {
			logger.error("DocumentEntry is null, cannot execute transformation.");
			throw new MetadataTransformationException("DocumentEntry is null, cannot execute transformation.");
		}
		var docData = new ExtrinsicObjectType();

		// set Extrinsic object attributes from metadata data members
		if (logger.isDebugEnabled()) {
			logger.debug("Setting attributes on the Extrinsic Object.");
		}
		setExtrinsicObjectAttributes(docEntry, docData);

		// set the ExtrinsicObject/Name from title
		if (logger.isDebugEnabled()) {
			logger.debug("Setting Name on the Extrinsic Object.");
		}
		docData.setName(convertLocalizedString(docEntry.getTitle()));

		// set the ExtrinsicObject/Description from title
		if (logger.isDebugEnabled()) {
			logger.debug("Setting Description on the Extrinsic Object.");
		}
		docData.setDescription(convertLocalizedString(docEntry.getComments()));

		// process ExtrinsicObject slots
		if (logger.isDebugEnabled()) {
			logger.debug("Setting Slots on the Extrinsic Object.");
		}
		setExtrinsicObjectSlots(docEntry, docData);

		// set ExtrinsicObject classifications from metadata codes
		if (logger.isDebugEnabled()) {
			logger.debug("Setting Classifications on the Extrinsic Object.");
		}
		setExtrinsicObjectClassifications(docEntry, docData);

		// set ExtrinsicObject external identifiers from metadata
		if (logger.isDebugEnabled()) {
			logger.debug("Setting ExternalIdentifiers on the Extrinsic Object.");
		}
		setExtringsicObjectExternalIdentifiers(docEntry, docData);

		return docData;
	}

	/**
	 * Sets the metadata values in the ExternalIdentifiers of the ExtrinsicObject
	 */
	private void setExtringsicObjectExternalIdentifiers(DocumentEntry docEntry, ExtrinsicObjectType docData) {
		List<ExternalIdentifierType> externalIdentifiers = docData.getExternalIdentifier();
		var idName = new LocalizedStringType();
		var exIDName = new InternationalStringType();

		// patientId /////////////////////////////////////////////////////
		var exID = new ExternalIdentifierType();
		if (docEntry.getPatientId() != null) {
			// set id and registryObject (required in ebXML 3.0 (and not in 2.1)
			exID.setId(getRandomId("i", 1));
			exID.setRegistryObject(docEntry.getEntryUuid());
			// set patient id
			exID.setValue(Hl7Util.generateFromCx(docEntry.getPatientId(), MessageDelimiters.COMPONENT,
					MessageDelimiters.SUBCOMPONENT));
			// set "XDSDocumentEntry.patientId" to be the name of this ExternalIdentifier
			idName.setValue(DocumentEntryConstants.PATIENT_ID);
			exIDName.getLocalizedString().add(idName);
			exID.setName(exIDName);
			// set identificaitonScheme
			exID.setIdentificationScheme(UUIDs.DOC_ENTRY_PATIENT_IDENTIFICATION_SCHEME);
			// add to ExtrinsicObject/ExternalIdentifier
			externalIdentifiers.add(exID);
		}

		// uniqueId /////////////////////////////////////////////////////
		if (docEntry.getUniqueId() != null) {
			exID = new ExternalIdentifierType();
			idName = new LocalizedStringType();
			exIDName = new InternationalStringType();

			// set id and registryObject (required in ebXML 3.0 (and not in 2.1)
			exID.setId(getRandomId("i", 2));
			exID.setRegistryObject(docEntry.getEntryUuid());
			// set unique id in ExternalIdentifier
			exID.setValue(docEntry.getUniqueId());
			// set "XDSDocumentEntry.uniqueId" to be the name of this ExternalIdentifier
			idName = new LocalizedStringType();
			idName.setValue(DocumentEntryConstants.UNIQUE_ID);
			exIDName = new InternationalStringType();
			exIDName.getLocalizedString().add(idName);
			exID.setName(exIDName);
			// set identificaitonScheme
			exID.setIdentificationScheme(UUIDs.DOC_ENTRY_UNIQUE_IDENTIFICATION_SCHEME);
			// add to ExtrinsicObject/ExternalIdentifier
			externalIdentifiers.add(exID);
		}
	}

	/**
	 * Sets the ExtrinsicObject attributes that correspond to XDSDocumentEntry
	 * metadata. Will set the ExtrinsicObject/@id and
	 * Classification/@classifiedObject from the entryUUID metadata. This could
	 * cause issues if this entryUUID did not come come from the Registry. Also sets
	 * ExtrinsicObject/@objectType to
	 * "urn:uuid:7edca82f-054d-47f2-a032-9b2a5b5186c1", indicating that this
	 * ExtrinsicObject represents an XDSDocumentEntry.
	 */
	private void setExtrinsicObjectAttributes(DocumentEntry docEntry, ExtrinsicObjectType docData) {
		// Set the entryUUID ... should make sure still registry issued.
		docData.setId(docEntry.getEntryUuid());

		// set objectType
		docData.setObjectType(UUIDs.DOC_ENTRY_OBJECT);

		// set availiablityStatus
		if (docEntry.getAvailabilityStatus() != null) {
			if (docEntry.getAvailabilityStatus().equals(AvailabilityStatus.APPROVED)) {
				docData.setStatus(EbXML_3_0TransformerConstants.APPROVED_STATUS);
			} else if (docEntry.getAvailabilityStatus().equals(AvailabilityStatus.DEPRECATED)) {
				docData.setStatus(EbXML_3_0TransformerConstants.DEPRECATED_STATUS);
			} else if (docEntry.getAvailabilityStatus().equals(AvailabilityStatus.SUBMITTED)) {
				docData.setStatus(EbXML_3_0TransformerConstants.SUBMITTED_STATUS);
			}
		}
		// set mimeType
		docData.setMimeType(docEntry.getMimeType());
	}

	/**
	 * Sets the metadata values in the Classifications of the ExtrinsicObject
	 */
	private void setExtrinsicObjectClassifications(DocumentEntry docEntry, ExtrinsicObjectType docData) {
		// get list of classifications
		List<ClassificationType> classifications = docData.getClassification();
		var c = new ClassificationType();
		List<SlotType1> slots = c.getSlot();
		var slot = new SlotType1();
		var list = new ValueListType();
		var count = 1;

		// classCode ////////////////////////////////////////////////////////////
		if (docEntry.getClassCode() != null) {
			// set classCode internal uuid
			c.setClassificationScheme(UUIDs.DOC_ENTRY_CLASS_CODE);
			// set classifiedObject
			c.setClassifiedObject(docEntry.getEntryUuid());

			// set id (required in ebXML 3.0 (and not in 2.1)
			c.setId(getRandomId("c", count));
			count++;

			// set classCode code value
			c.setNodeRepresentation(docEntry.getClassCode().getCode());
			// set classCode diaplay name
			c.setName(convertLocalizedString(docEntry.getClassCode().getDisplayName()));

			// set coding scheme name in slot
			if (docEntry.getClassCode().getSchemeName() != null) {
				slot.setValueList(list);
				slot.setName(DocumentEntryConstants.CODING_SCHEME);
				slot.getValueList().getValue().add(docEntry.getClassCode().getSchemeName());
				slots.add(slot);
			}
			classifications.add(c);
		}

		// confidentialityCode
		// ////////////////////////////////////////////////////////////
		Iterator<Code> i = docEntry.getConfidentialityCodes().iterator();
		while (i.hasNext()) {
			c = new ClassificationType();
			// set id (required in ebXML 3.0 (and not in 2.1)
			c.setId(getRandomId("c", count));
			count++;

			// set confidentialityCode internal uuid
			c.setClassificationScheme(UUIDs.DOC_ENTRY_CONFIDENTIALITY_CODE);
			// set classifiedObject
			c.setClassifiedObject(docEntry.getEntryUuid());

			Code conf = i.next();
			// set confidentialityCode code value
			c.setNodeRepresentation(conf.getCode());
			// set classCode diaplay name
			c.setName(convertLocalizedString(conf.getDisplayName()));

			// set coding scheme name in slot
			if (conf.getSchemeName() != null) {
				slots = c.getSlot();
				slot = new SlotType1();
				list = new ValueListType();
				slot.setValueList(list);
				slot.setName(DocumentEntryConstants.CODING_SCHEME);
				slot.getValueList().getValue().add(conf.getSchemeName());
				slots.add(slot);
			}
			classifications.add(c);
		}

		// eventCodeList ////////////////////////////////////////////////////////////
		i = docEntry.getEventCodeList().iterator();
		while (i.hasNext()) {
			c = new ClassificationType();
			// set id (required in ebXML 3.0 (and not in 2.1)
			c.setId(getRandomId("c", count));
			count++;

			// set eventCode internal uuid
			c.setClassificationScheme(UUIDs.DOC_ENTRY_EVENT_CODE);
			// set classifiedObject
			c.setClassifiedObject(docEntry.getEntryUuid());

			Code event = i.next();
			if (event != null) {
				// set eventCode code value
				c.setNodeRepresentation(event.getCode());
				// set classCode diaplay name
				c.setName(convertLocalizedString(event.getDisplayName()));

				// set coding scheme name in slot
				if (event.getSchemeName() != null) {
					slots = c.getSlot();
					slot = new SlotType1();
					list = new ValueListType();
					slot.setValueList(list);
					slot.setName(DocumentEntryConstants.CODING_SCHEME);
					slot.getValueList().getValue().add(event.getSchemeName());
					slots.add(slot);
				}
			}
			classifications.add(c);
		}

		// formatCode ////////////////////////////////////////////////////////////
		if (docEntry.getFormatCode() != null) {
			c = new ClassificationType();
			// set formatCode internal uuid
			c.setClassificationScheme(UUIDs.DOC_ENTRY_FORMAT_CODE);
			// set classifiedObject
			c.setClassifiedObject(docEntry.getEntryUuid());

			// set id (required in ebXML 3.0 (and not in 2.1)
			c.setId(getRandomId("c", count));
			count++;

			// set formatCode code value
			c.setNodeRepresentation(docEntry.getFormatCode().getCode());
			// set classCode diaplay name
			c.setName(convertLocalizedString(docEntry.getFormatCode().getDisplayName()));

			// set coding scheme name in slot
			if (docEntry.getFormatCode().getSchemeName() != null) {
				slots = c.getSlot();
				slot = new SlotType1();
				list = new ValueListType();
				slot.setValueList(list);
				slot.setName(DocumentEntryConstants.CODING_SCHEME);
				slot.getValueList().getValue().add(docEntry.getFormatCode().getSchemeName());
				slots.add(slot);
			}
			classifications.add(c);
		}

		// healthCareFacilityTypeCode
		// ////////////////////////////////////////////////////////////
		if (docEntry.getHealthcareFacilityTypeCode() != null) {
			c = new ClassificationType();
			// set healthCareFacilityTypeCode internal uuid
			c.setClassificationScheme(UUIDs.DOC_ENTRY_HEALTH_CARE_FACILITY_CODE);
			// set classifiedObject
			c.setClassifiedObject(docEntry.getEntryUuid());

			// set id (required in ebXML 3.0 (and not in 2.1)
			c.setId(getRandomId("c", count));
			count++;

			// set healthCareFacilityTypeCode code value
			c.setNodeRepresentation(docEntry.getHealthcareFacilityTypeCode().getCode());
			// set classCode diaplay name
			c.setName(convertLocalizedString(docEntry.getHealthcareFacilityTypeCode().getDisplayName()));

			// set coding scheme name in slot
			if (docEntry.getHealthcareFacilityTypeCode().getSchemeName() != null) {
				slots = c.getSlot();
				slot = new SlotType1();
				list = new ValueListType();
				slot.setValueList(list);
				slot.setName(DocumentEntryConstants.CODING_SCHEME);
				slot.getValueList().getValue().add(docEntry.getHealthcareFacilityTypeCode().getSchemeName());
				slots.add(slot);
			}
			classifications.add(c);
		}

		// practiceSettingCode
		// ////////////////////////////////////////////////////////////
		if (docEntry.getPracticeSettingCode() != null) {
			c = new ClassificationType();
			// set practiceSettingCode internal uuid
			c.setClassificationScheme(UUIDs.DOC_ENTRY_PRACTICE_SETTING_CODE);
			// set classifiedObject
			c.setClassifiedObject(docEntry.getEntryUuid());

			// set id (required in ebXML 3.0 (and not in 2.1)
			c.setId(getRandomId("c", count));
			count++;

			// set practiceSettingCode code value
			c.setNodeRepresentation(docEntry.getPracticeSettingCode().getCode());
			// set classCode diaplay name
			c.setName(convertLocalizedString(docEntry.getPracticeSettingCode().getDisplayName()));

			// set coding scheme name in slot
			if (docEntry.getPracticeSettingCode().getSchemeName() != null) {
				slots = c.getSlot();
				slot = new SlotType1();
				list = new ValueListType();
				slot.setValueList(list);
				slot.setName(DocumentEntryConstants.CODING_SCHEME);
				slot.getValueList().getValue().add(docEntry.getPracticeSettingCode().getSchemeName());
				slots.add(slot);
			}
			classifications.add(c);
		}

		// typeCode ////////////////////////////////////////////////////////////
		if (docEntry.getTypeCode() != null) {
			c = new ClassificationType();
			// set typeCode internal uuid
			c.setClassificationScheme(UUIDs.DOC_ENTRY_TYPE_CODE);
			// set classifiedObject
			c.setClassifiedObject(docEntry.getEntryUuid());

			// set id (required in ebXML 3.0 (and not in 2.1)
			c.setId(getRandomId("c", count));
			count++;

			// set typeCode code value
			c.setNodeRepresentation(docEntry.getTypeCode().getCode());
			// set classCode diaplay name
			c.setName(convertLocalizedString(docEntry.getTypeCode().getDisplayName()));

			// set coding scheme name in slot
			if (docEntry.getTypeCode().getSchemeName() != null) {
				slots = c.getSlot();
				slot = new SlotType1();
				list = new ValueListType();
				slot.setValueList(list);
				slot.setName(DocumentEntryConstants.CODING_SCHEME);
				slot.getValueList().getValue().add(docEntry.getTypeCode().getSchemeName());
				slots.add(slot);
			}
			classifications.add(c);
		}

		// author
		// //////////////////////////////////////////////////////////////////////////
		Author author = null;
		if (docEntry.getAuthors() != null) {
			Iterator<Author> itAuth = docEntry.getAuthors().iterator();
			while (itAuth.hasNext()) {

				// create classification for this author
				c = new ClassificationType();
				// set contentTypeCode internal uuid
				c.setClassificationScheme(UUIDs.DOC_ENTRY_AUTHOR);
				// set classifiedObject
				c.setClassifiedObject(docEntry.getEntryUuid());
				// set nodeRepresentation -- required for external
				// classifications
				c.setNodeRepresentation("");// intentionally left blank, per IHE
											// (see discussion on Issue 15)

				// set id (required in ebXML 3.0 (and not in 2.1)
				c.setId(getRandomId("c", count));
				count++;

				// begin to set author data
				slots = c.getSlot();
				slot = new SlotType1();
				list = new ValueListType();
				author = itAuth.next();

				// author institution
				if (author.getAuthorInstitution() != null && !author.getAuthorInstitution().isEmpty()) {

					slot.setValueList(list);
					slot.setName(DocumentEntryConstants.AUTHOR_INSTITUTION);
					Iterator<Organization> j = author.getAuthorInstitution().iterator();
					while (j.hasNext()) {
						slot.getValueList().getValue().add(Hl7Util.generateXon(j.next(), MessageDelimiters.COMPONENT,
								MessageDelimiters.SUBCOMPONENT));
					}
					slots.add(slot);

				}

				// authorPerson
				if (author.getAuthorPerson() != null) {
					slot = new SlotType1();
					list = new ValueListType();
					slot.setValueList(list);
					slot.setName(DocumentEntryConstants.AUTHOR_PERSON);
					slot.getValueList().getValue().add(Hl7Util.generateFromCx(author.getAuthorPerson(),
							MessageDelimiters.COMPONENT, MessageDelimiters.SUBCOMPONENT));
					slots.add(slot);
				}

				// authorRole
				if (author.getAuthorRole() != null && !author.getAuthorRole().isEmpty()) {
					slot = new SlotType1();
					list = new ValueListType();
					slot.setValueList(list);
					slot.setName(DocumentEntryConstants.AUTHOR_ROLE);
					Iterator<Identifiable> j = author.getAuthorRole().iterator();
					while (j.hasNext()) {
						slot.getValueList().getValue().add(j.next().getId());
					}
					slots.add(slot);
				}

				// authorSpecialty
				if (author.getAuthorSpecialty() != null && !author.getAuthorSpecialty().isEmpty()) {
					slot = new SlotType1();
					list = new ValueListType();
					slot.setValueList(list);
					slot.setName(DocumentEntryConstants.AUTHOR_SPECIALITY);
					Iterator<Identifiable> j = author.getAuthorSpecialty().iterator();
					while (j.hasNext()) {
						slot.getValueList().getValue().add(j.next().getId());
					}
					slots.add(slot);
				}
				// Added by CP 524, 627 and 628 for IHE ITI TF v9 (2012-2013)
				// authorTelecommunication
				if (author.getAuthorTelecom() != null && !author.getAuthorTelecom().isEmpty()) {

					slot = new SlotType1();
					list = new ValueListType();
					slot.setValueList(list);
					slot.setName(DocumentEntryConstants.AUTHOR_TELECOMMUNICATION);
					Iterator<Telecom> j = author.getAuthorTelecom().iterator();
					while (j.hasNext()) {
						slot.getValueList().getValue().add(Hl7Util.generateXtn(j.next(), MessageDelimiters.COMPONENT));
					}
					slots.add(slot);

				}
				classifications.add(c);
			} // end author iterator
		} // end if
	}

	/**
	 * Sets the metadata values in the slots of the ExtrinsicObject
	 */
	private void setExtrinsicObjectSlots(DocumentEntry docEntry, ExtrinsicObjectType docData) {
		List<SlotType1> slots = docData.getSlot();
		var slot = new SlotType1();
		var list = new ValueListType();

		// creationTime
		if (docEntry.getCreationTime() != null) {
			slot = new SlotType1();
			list = new ValueListType();
			slot.setValueList(list);
			slot.setName(DocumentEntryConstants.CREATION_TIME);
			slot.getValueList().getValue().add(DateUtil.formatDateTime(docEntry.getCreationTime().getDateTime()));
			slots.add(slot);
		}

		// hash
		if (docEntry.getHash() != null) {
			slot = new SlotType1();
			list = new ValueListType();
			slot.setValueList(list);
			slot.setName(DocumentEntryConstants.HASH);
			slot.getValueList().getValue().add(docEntry.getHash());
			slots.add(slot);
		}

		// metadata extensions (if any)
		if (docEntry.getExtraMetadata() != null && !docEntry.getExtraMetadata().isEmpty()) {

			Iterator<Entry<String, List<String>>> i = docEntry.getExtraMetadata().entrySet().iterator();
			while (i.hasNext()) {
				Entry<String, List<String>> extension = i.next();
				if (extension.getKey() != null && extension.getValue() != null && !extension.getValue().isEmpty()) {

					slot = new SlotType1();
					list = new ValueListType();
					slot.setValueList(list);
					slot.setName(extension.getKey());
					Iterator<String> j = extension.getValue().iterator();
					while (j.hasNext()) {
						slot.getValueList().getValue().add(j.next());
					}
					slots.add(slot);

				}

			}
		}

		// languageCode
		if (docEntry.getLanguageCode() != null) {
			slot = new SlotType1();
			list = new ValueListType();
			slot.setValueList(list);
			slot.setName(DocumentEntryConstants.LANGUAGE_CODE);
			slot.getValueList().getValue().add(docEntry.getLanguageCode());
			slots.add(slot);
		}

		// legal Authenticators
		if (docEntry.getLegalAuthenticator() != null) {
			slot = new SlotType1();
			list = new ValueListType();
			slot.setValueList(list);
			slot.setName(DocumentEntryConstants.LEGAL_AUTHENTICATOR);
			slot.getValueList().getValue().add(Hl7Util.generateFromCx(docEntry.getLegalAuthenticator(),
					MessageDelimiters.COMPONENT, MessageDelimiters.SUBCOMPONENT));
			slots.add(slot);
		}

		// repositoryUniqueId
		if (docEntry.getRepositoryUniqueId() != null) {
			slot = new SlotType1();
			list = new ValueListType();
			slot.setValueList(list);
			slot.setName(DocumentEntryConstants.REPOSITORY_UNIQUE_ID);
			slot.getValueList().getValue().add(docEntry.getRepositoryUniqueId());
			slots.add(slot);
		}

		// serviceStartTime
		if (docEntry.getServiceStartTime() != null) {
			slot = new SlotType1();
			list = new ValueListType();
			slot.setValueList(list);
			slot.setName(DocumentEntryConstants.SERVICE_START_TIME);
			slot.getValueList().getValue().add(DateUtil.formatDateTime(docEntry.getServiceStartTime().getDateTime()));
			slots.add(slot);
		}
		// serviceStopTime
		if (docEntry.getServiceStopTime() != null) {
			slot = new SlotType1();
			list = new ValueListType();
			slot.setValueList(list);
			slot.setName(DocumentEntryConstants.SERVICE_STOP_TIME);
			slot.getValueList().getValue().add(DateUtil.formatDateTime(docEntry.getServiceStopTime().getDateTime()));
			slots.add(slot);
		}
		// size
		if (docEntry.getSize() != null) {
			slot = new SlotType1();
			list = new ValueListType();
			slot.setValueList(list);
			slot.setName(DocumentEntryConstants.SIZE);
			slot.getValueList().getValue().add(String.valueOf(docEntry.getSize()));
			slots.add(slot);
		}

		// URI / LONG-URI (should be in XDS.a, EbXML 2.1 only)
		if (docEntry.getUri() != null) {
			slot = new SlotType1();
			list = new ValueListType();
			slot.setValueList(list);
			slot.setName(DocumentEntryConstants.URI);

			// when length is < 128 chars
			if (docEntry.getUri().length() <= MAX_SLOT_LENGTH) {
				slot.getValueList().getValue().add(docEntry.getUri());
			} else {
				// break uri into chunks, add as slot values
				var piece = 1;
				var start = 0;
				while (start < docEntry.getUri().length()) {
					// compute next chunk not to exceed MAX chars in length,
					// including separator notation
					int end = start + MAX_SLOT_LENGTH - ((piece + "|").length());
					if (end > docEntry.getUri().length()) {
						end = docEntry.getUri().length();
					}
					// FIXME have constant for the delimiter
					slot.getValueList().getValue().add(piece + "|" + docEntry.getUri().substring(start, end));
					start = end;
					piece++;
				}
			}
			// add either the URI or the LONG-URI slot
			slots.add(slot);
		}

		// sourcePatientId
		if (docEntry.getSourcePatientId() != null) {
			slot = new SlotType1();
			list = new ValueListType();
			slot.setValueList(list);
			slot.setName(DocumentEntryConstants.SOURCE_PATIENT_ID);
			slot.getValueList().getValue().add(Hl7Util.generateFromCx(docEntry.getSourcePatientId(),
					MessageDelimiters.COMPONENT, MessageDelimiters.SUBCOMPONENT));
			slots.add(slot);
		}

		// sourcePatientInfo
		slot = new SlotType1();
		list = new ValueListType();
		slot.setValueList(list);
		slot.setName(DocumentEntryConstants.SOURCE_PATIENT_INFO);
		var pid = docEntry.getSourcePatientInfo();
		if (pid == null) {
			// done adding slots
			return;
		}

		ListIterator<Identifiable> i = pid.getIds();
		while (i.hasNext()) {
			var s = Hl7Util.generateFromCx(i.next(), MessageDelimiters.COMPONENT,
					MessageDelimiters.SUBCOMPONENT);
			if (s.length() > 0) {
				slot.getValueList().getValue().add(DocumentEntryConstants.PID3_ID + MessageDelimiters.FIELD + s);
			}
		}
		ListIterator<Name> it = pid.getNames();
		while (it.hasNext()) {
			var s = Hl7Util.generateXpn(it.next(), MessageDelimiters.COMPONENT);
			if (s.length() > 0) {
				slot.getValueList().getValue().add(DocumentEntryConstants.PID5_ID + MessageDelimiters.FIELD + s);
			}
		}

		String s = DateUtil.formatDateOnly(pid.getDateOfBirth().getDateTime());
		if (s != null && !s.isEmpty()) {

				slot.getValueList().getValue().add(DocumentEntryConstants.PID7_ID + MessageDelimiters.FIELD + s);

		}

		s = pid.getGender();
		if (s != null && !s.isEmpty()) {

				slot.getValueList().getValue().add(DocumentEntryConstants.PID8_ID + MessageDelimiters.FIELD + s);

		}

		s = Hl7Util.generateXad(pid.getAddresses().next(), MessageDelimiters.COMPONENT);
		if (s.length() > 0) {
			slot.getValueList().getValue().add(DocumentEntryConstants.PID11_ID + MessageDelimiters.FIELD + s);
		}

		// finally add the PID slot, if any values set
		if (!slot.getValueList().getValue().isEmpty()) {
			slots.add(slot);
		}
	}

	public RegistryPackageType transformFolder(Folder folder) throws MetadataTransformationException {
		if (folder == null) {
			logger.error("Folder is null, cannot execute transformation.");
			throw new MetadataTransformationException("Folder is null, cannot execute transformation.");
		}

		var folderData = new RegistryPackageType();

		// set attributes
		if (logger.isDebugEnabled()) {
			logger.debug("Setting attributes on the Registry Package.");
		}
		setRegistryPackageAttributes(folder, folderData);

		// set RegistryPackage.Name
		if (logger.isDebugEnabled()) {
			logger.debug("Setting Name on the Registry Package.");
		}
		folderData.setName(convertLocalizedString(folder.getTitle()));

		// set RegistryPackage.Description
		if (logger.isDebugEnabled()) {
			logger.debug("Setting Description on the Registry Package.");
		}
		folderData.setDescription(convertLocalizedString(folder.getComments()));

		// set RegistryPackage slot (only one, lastUpdateTime)
		if (logger.isDebugEnabled()) {
			logger.debug("Setting Slots on the Registry Package.");
		}
		setRegistryPackageSlots(folder, folderData);

		// set RegistryPacage classifications
		if (logger.isDebugEnabled()) {
			logger.debug("Setting Classifications on the Registry Package.");
		}
		setRegistryPackageClassifications(folder, folderData);

		// set RegistryPackage external Identifiers
		if (logger.isDebugEnabled()) {
			logger.debug("Setting External Identifiers on the Registry Package.");
		}
		setRegistryPackageExternalIdentifiers(folderData, folder);

		return folderData;
	}

	/** sets the attributes on the Registry package **/
	private void setRegistryPackageAttributes(Folder folder, RegistryPackageType folderData) {
		// set RegistryPackage/@id
		folderData.setId(folder.getEntryUuid());

		// set RegistryPackage/@status
		if (folder.getAvailabilityStatus() != null) {
			if (folder.getAvailabilityStatus().equals(AvailabilityStatus.APPROVED)) {
				folderData.setStatus(EbXML_3_0TransformerConstants.APPROVED_STATUS);
			} else if (folder.getAvailabilityStatus().equals(AvailabilityStatus.DEPRECATED)) {
				folderData.setStatus(EbXML_3_0TransformerConstants.DEPRECATED_STATUS);
			} else if (folder.getAvailabilityStatus().equals(AvailabilityStatus.SUBMITTED)) {
				folderData.setStatus(EbXML_3_0TransformerConstants.SUBMITTED_STATUS);
			}
		}
	}

	/** sets classifications */
	private void setRegistryPackageClassifications(Folder folder, RegistryPackageType folderData) {
		List<Code> folderCodes = folder.getCodeList();
		if (folderCodes == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("Folder Code list contains no codes.");
			}
			return;
		}

		var count = 1;
		for (var i = 0; i < folderCodes.size(); i++) {
			// code List ////////////////////////////////////////////////////////////
			var c = new ClassificationType();
			var cm = folderCodes.get(i);
			// set code internal uuid
			c.setClassificationScheme(UUIDs.FOLDER_CODE);

			// set id (required in ebXML 3.0 (and not in 2.1)
			c.setId(getRandomId("cf", count));
			count++;
			// set code code value
			c.setNodeRepresentation(cm.getCode());
			// set classifiedObject (made available from parameter)
			c.setClassifiedObject(folder.getEntryUuid());
			// set code diaplay name
			c.setName(convertLocalizedString(cm.getDisplayName()));

			// set coding scheme name in slot
			if (cm.getSchemeName() != null) {
				List<SlotType1> slots = c.getSlot();
				var slot = new SlotType1();
				var list = new ValueListType();
				slot.setValueList(list);
				slot.setName(FolderConstants.CODING_SCHEME);
				slot.getValueList().getValue().add(cm.getSchemeName());
				slots.add(slot);
			}
			folderData.getClassification().add(c);
		}
	}

	/**
	 * Sets the metadata values in the ExternalIdentifiers of the RegistryPackage
	 */
	private void setRegistryPackageExternalIdentifiers(RegistryPackageType folderData, Folder folder) {
		List<ExternalIdentifierType> externalIdentifiers = folderData.getExternalIdentifier();
		var idName = new LocalizedStringType();
		var exIDName = new InternationalStringType();

		// patientId /////////////////////////////////////////////////////
		var exID = new ExternalIdentifierType();
		if (folder.getPatientId() != null) {
			// set id and registryObject (required in ebXML 3.0 (and not in 2.1)
			exID.setId(getRandomId("i", 1));
			exID.setRegistryObject(folder.getEntryUuid());
			// set patient id
			exID.setValue(Hl7Util.generateFromCx(folder.getPatientId(), MessageDelimiters.COMPONENT,
					MessageDelimiters.SUBCOMPONENT));
			// set "XDSFolder.patientId" to be the name of this ExternalIdentifier
			idName.setValue(FolderConstants.PATIENT_ID);
			exIDName.getLocalizedString().add(idName);
			exID.setName(exIDName);
			// set identificaitonScheme
			exID.setIdentificationScheme(UUIDs.FOLDER_PATIENT_IDENTIFICATION_SCHEME);
			// add to RegistryPackage/ExternalIdentifier
			externalIdentifiers.add(exID);
		}

		// uniqueId /////////////////////////////////////////////////////
		if (folder.getUniqueId() != null) {
			exID = new ExternalIdentifierType();
			idName = new LocalizedStringType();
			exIDName = new InternationalStringType();
			// set id and registryObject (required in ebXML 3.0 (and not in 2.1)
			exID.setId(getRandomId("i", 2));
			exID.setRegistryObject(folder.getEntryUuid());
			// set unique id in ExternalIdentifier
			exID.setValue(folder.getUniqueId());
			// set "XDSFolder.uniqueId" to be the name of this ExternalIdentifier
			idName.setValue(FolderConstants.UNIQUE_ID);
			exIDName.getLocalizedString().add(idName);
			exID.setName(exIDName);
			// set identificaitonScheme
			exID.setIdentificationScheme(UUIDs.FOLDER_UNIQUE_IDENTIFICATION_SCHEME);
			// add to RegistryPackage/ExternalIdentifier
			externalIdentifiers.add(exID);
		}
	}

	/** sets the slots on the Registry package */
	private void setRegistryPackageSlots(Folder folder, RegistryPackageType folderData) {
		List<SlotType1> slots = folderData.getSlot();

		// lastUpdateTime
		if (folder.getLastUpdateTime() != null) {
			var slot = new SlotType1();
			var list = new ValueListType();
			slot.setValueList(list);
			slot.setName(FolderConstants.LAST_UPDATE_TIME);
			slot.getValueList().getValue().add(DateUtil.formatDateTime(folder.getLastUpdateTime().getDateTime()));
			slots.add(slot);
		}
	}

}
