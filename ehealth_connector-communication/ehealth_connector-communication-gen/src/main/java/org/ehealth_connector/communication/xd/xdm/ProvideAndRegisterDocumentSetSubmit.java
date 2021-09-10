package org.ehealth_connector.communication.xd.xdm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.bind.JAXBElement;

import org.ehealth_connector.common.utils.Hl7Util;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Association;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssociationType;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Author;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Folder;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.PatientInfo;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Recipient;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.SubmissionSet;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.lcm.SubmitObjectsRequest;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.AssociationType1;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.ClassificationType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.ExtrinsicObjectType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.IdentifiableType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.InternationalStringType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.LocalizedStringType;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.RegistryPackageType;
import org.openhealthtools.ihe.common.ebxml._3._0.rim.ExternalIdentifierType;
import org.openhealthtools.ihe.common.ebxml._3._0.rim.SlotType1;
import org.openhealthtools.ihe.xds.metadata.ParentDocumentRelationshipType;
import org.openhealthtools.ihe.xds.metadata.constants.DocumentEntryConstants;
import org.openhealthtools.ihe.xds.metadata.constants.FolderConstants;
import org.openhealthtools.ihe.xds.metadata.constants.SubmissionSetConstants;
import org.openhealthtools.ihe.xds.metadata.constants.UUIDs;
import org.openhealthtools.ihe.xds.metadata.extract.EbXML_3_0ExtractorConstants;
import org.openhealthtools.ihe.xds.metadata.extract.MetadataExtractionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProvideAndRegisterDocumentSetSubmit {

	/** Descriptor for Extractor */
	public static final String DESCRIPTOR = "EBXML_3_0_PRDS_EXTR";

	/** The SLF4J logger instance. */
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/** EbXML structure for submission transaction metadata */
	private SubmitObjectsRequest transactionData;

	// data members to assist in building the submission data
	/** list of registry pacakges found in the SubmitObjectsRequest */
	private List<RegistryPackageType> registryPackages = new ArrayList<>();

	/** list of extrinsic objects found in the SubmitObjectsRequest */
	private List<ExtrinsicObjectType> extrinsicObjects = new ArrayList<>();

	/** list of classifications found in the SubmitObjectsRequest */
	private List<ClassificationType> classifications = new ArrayList<>();

	/** list of associations found in the SubmitObjectsRequest */
	private List<AssociationType1> associations = new ArrayList<>();

	/**
	 * Loads the ebXML structures containing entire Submission Transaction metadata. UUIDs for classificationSchemes, identificationSchemes,
	 * objectTypes and associationTypes are expected to conform to those fixed by XDS documentataion. Minimally must include: <1>One
	 * RegistryPackage for the SubmissionSet metadata and one Classification that identifies this RegistryPackage as SubmissionSet metadata.This
	 * REgistryPacakge must have a populated id attribute.</l> Including other components is subject to the following: <1>Each ExtrinsicObject
	 * for DocumentEntry metadata must have a populated id attribute.</l> <1>Each RegistryPackage for the Folder metadata must have a
	 * corresponding Classification that identifies this RegistryPackage as Folder metadata. This RegistryPacakge must have a populated id
	 * attribute.</l> <l> For each DocumentEntry that is contained in a particular folder, an Association must be present to indicate so. </l>
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.constants.UUIDs
	 * @param transactionData
	 *            SubmitObjectsRequest containing entire metadata (all document entries, all folders the submission set) and additional
	 *            classifications and associations for a submission transaction.
	 */
	public ProvideAndRegisterDocumentSetSubmit(SubmitObjectsRequest transactionData) {
		this.transactionData = transactionData;
	}

	/**
	 * Builds an ProvideAndRegisterDocumentSetTypeType containing: <1>One
	 * DocumentEntry for each ExtrinsicObject, assumed to be document entries </l>
	 * <l>One Folder for each RegistryPackage identified to be a folder</l> <l>One
	 * SubmissionSet for the (single) RegistryPackage identified to be a submission
	 * set</l> Construction assumes that standard HL7 V2.5 message delimiters are
	 * used. See
	 * {@link org.openhealthtools.ihe.common.hl7v2.format.MessageDelimiters}. Length
	 * restrictions are not implemented, presently. <br>
	 * IMPORTANT NOTE: IHE 2007-2008 CP 237 to XDS negates the following previous
	 * note <br>
	 * [NOTE: We note that documents and folders with corresponding
	 * ExtrinsicObjects/RegistryPackages (respectively) in the current
	 * SubmitObjectRequest will appear on the appropriate associated document and
	 * folder lists for the submission set. EbXML Associations that represent the
	 * linking of existing documents and existing folders to the current submission
	 * set will all appear on it's list of associated documents. This is because
	 * there is no way (currently) in the ebXML to distinguish an existing folder
	 * from an existing document entry in this context.]
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.ProvideAndRegisterDocumentSetExtractor#extract()
	 */
	public ProvideAndRegisterDocumentSet extract() throws MetadataExtractionException {
		if (this.transactionData.getRegistryObjectList() == null) {
			logger.error("RegistryObjectList is null, cannot execute extraction.");
			throw new MetadataExtractionException("RegistryObjectList is null, cannot execute extraction.");
		}
		if (this.transactionData.getRegistryObjectList().getIdentifiable() == null) {
			logger.error("RegistryObjectList has no Identifiable sub-elements, cannot execute extraction.");
			throw new MetadataExtractionException(
					"RegistryObjectList has no Identifiable sub-elements, cannot execute extraction.");
		}
		// sort out the registry object list content into registry packages,
		// extrinsic objects, classifications and associations
		this.sortContent(this.transactionData.getRegistryObjectList().getIdentifiable());

		if (this.registryPackages == null) {
			logger.error("List of RegistryPackage is null, cannot execute extraction.");
			throw new MetadataExtractionException("List of RegistryPackage is null, cannot execute extraction.");
		}
		if (this.registryPackages.isEmpty()) {
			logger.error("List of RegistryPackage is empty, cannot execute extraction.");
			throw new MetadataExtractionException("List of RegistryPackage is empty, cannot execute extraction.");
		}
		if (this.classifications == null) {
			logger.error("List of Classification is null, cannot execute extraction.");
			throw new MetadataExtractionException("List of Classification is null, cannot execute extraction.");
		}
		if (this.classifications.isEmpty()) {
			logger.error("List of Classification is empty, cannot execute extraction.");
			throw new MetadataExtractionException("List of Classification is empty, cannot execute extraction.");
		}
		// the return object
		ProvideAndRegisterDocumentSet docSet = new ProvideAndRegisterDocumentSet();

		// extract the submission set
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting the Submission Set.");
		}
		extractSubmissionSet(docSet);

		// extract document entries
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting the Document Entries.");
		}
		extractDocumentEntries(docSet);

		// extract folders
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting any Folders.");
		}
		extractFolders(docSet);

		return docSet;
	}

	/** extracts document entry metadata */
	private void extractDocumentEntries(ProvideAndRegisterDocumentSet docSet) throws MetadataExtractionException {
		// see if there are any documents
		if (this.extrinsicObjects == null) {
			logger.info("Metadata contains no ExtrinsicObjects");
		} else if (this.extrinsicObjects.isEmpty()) {
			logger.info("Metadata contains no ExtrinsicObjects");
		} else {
			Iterator<ExtrinsicObjectType> i = this.extrinsicObjects.iterator();
			while (i.hasNext()) {
				ExtrinsicObjectType docData = i.next();
				if (docData.getId() == null) {
					logger.error(
							"ExtrinsicObject found without the id attribute set. This data will not be included in the extraction.");
					continue;
				}
				// see if this doc has a parent
				AssociationType1 parentData = findParent(docData.getId());
				// extract
				extractDocumentEntry(docSet, docData, parentData);
			}
		}
	}

	/** extracts folder metadata */
	private void extractFolders(ProvideAndRegisterDocumentSet docSet) throws MetadataExtractionException {
		// see if there, potentially, are any folders
		if (this.registryPackages.size() <= 1) {
			logger.info("Metadata contains no Folders");
			return;
		}
		// find the folders
		RegistryPackageType[] folders = findFolders();
		if (folders == null) {
			logger.info("Could not find folder metadata in the SubmitObjectsRequest.");
			return;
		}
		// find documents in each folder and extract folder metadata
		for (var i = 0; i < folders.length; i++) {
			if (folders[i].getId() == null) {
				logger.error(
						"Folder RegistryPackage found without the id attribute set. This data will not be included in the extraction.");
				continue;
			}

			docSet.getFolders().add(extractFolder(folders[i]));
		}
	}

	/** extract the submission set */
	private void extractSubmissionSet(ProvideAndRegisterDocumentSet docSet) throws MetadataExtractionException {
		// find the submission set
		RegistryPackageType setData = findSubmissionSet();
		if (setData == null) {
			logger.error(
					"Could not find SubmissionSet metadata in the SubmitObjectsRequest. Cannot procede with extraction.");
			throw new MetadataExtractionException(
					"Could not find SubmissionSet metadata in the SubmitObjectsRequest. Cannot procede with extraction.");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Begin finding present submission set associated documents and present associated folders.");
		}
		// FIXME CP 237 places the target as the subSet
		// and the source as the association ID - making this check possible and
		// backwards
		/// CP278 fixes this, thus this check will filter out *all*
		// links to current documents, links to current folders and links to
		// associations
		// between existing documents and existing folders with the submission set.
		AssociationType1[] presentAssociations = this.findHasMemberAssociationsWithSource(setData.getId());

		/*
		 * if(presentAssociations.length == 0){
		 * logger.info("No submission set associated documents or folders found.");
		 * EbXML_3_0SubmissionSetExtractor ssExtractor = new
		 * EbXML_3_0SubmissionSetExtractor(setData, null, null);
		 * docSet.setSubmissionSet(ssExtractor.extract()); return; }
		 */

		// find uuids of current (present) folders
		Iterator<ClassificationType> i = this.classifications.iterator();
		List<String> folUUIDs = new ArrayList<>();
		while (i.hasNext()) {
			ClassificationType c = i.next();
			if (c.getClassificationNode().equals(UUIDs.FOLDER_OBJECT)) {
				folUUIDs.add(c.getClassifiedObject());
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Number current folders found: {}", folUUIDs.size());
		}

		// find uuids of current (present) documents
		Iterator<ExtrinsicObjectType> it = this.extrinsicObjects.iterator();
		List<String> docEntryUUIDs = new ArrayList<>();
		while (it.hasNext()) {
			docEntryUUIDs.add((it.next()).getId());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Number current documents found: {}", docEntryUUIDs.size());
		}

		// partition presentAssociations into present associated documents and present
		// associated folders
		// and associations of existing documents to existing folders
		// using the Folder classification and extrinsic object ids
		List<AssociationType1> docs = new ArrayList<>();
		List<AssociationType1> folders = new ArrayList<>();

		// CP-278 IS FIXED:
		List<String> folderDocumentAssociationIds = new ArrayList<>();

		for (var j = 0; j < presentAssociations.length; j++) {
			var foundTarget = false;
			Iterator<String> itStr = folUUIDs.iterator();
			while (itStr.hasNext()) {
				// present (current) folder = target of the association with subSet Id as source
				if (((String) itStr.next()).equalsIgnoreCase(presentAssociations[j].getTargetObject())) {
					folders.add(presentAssociations[j]);
					foundTarget = true;
					break;
				}
			}
			if (foundTarget) {
				continue;
			}
			Iterator<String> itDocEntry = docEntryUUIDs.iterator();
			while (itDocEntry.hasNext()) {
				// present (current) document
				if (((String) itDocEntry.next()).equalsIgnoreCase(presentAssociations[j].getTargetObject())) {
					docs.add(presentAssociations[j]);
					foundTarget = true;
					break;
				}
			}
			if (foundTarget) {
				continue;
			} else {
				// FIXME CP 237 is corrected by CP 278 in having the submission set
				// id as source and the association id linking document and folder as false.
				////////////////////////////////////////////////////////////////////////////
				// we have the ID of an association between a document and a folder
				folderDocumentAssociationIds.add(presentAssociations[j].getTargetObject());
			}

		}
		if (logger.isDebugEnabled()) {
			logger.debug(
					"Present (current) associations partitioned into {} associated documents and {} associated folders.",
					docs.size(), folders.size());
		}

		// now identify the existing documents and folders and set appropriate
		// constructs
		ArrayList<AssociationType1> existingDocs = new ArrayList<>();
		ArrayList<AssociationType1> existingFolders = new ArrayList<>();

		// FIXME - may have to adjust logic - CP 237 places the target as the subSet
		// and the source as the association ID - making this check possible.
		// COMMENT OUT WHEN CP 237 IS FIXED:
		/*
		 * AssociationType1[] list =
		 * findHasMemberAssociationsWithTarget(setData.getId()); ArrayList
		 * folderDocumentAssociationIds = new ArrayList(); for(int j = 0; j <
		 * list.length; j++){
		 * folderDocumentAssociationIds.add(list[j].getSourceObject()); }
		 */
		///////////////////////////////////////////////////////////////////////////////

		// search
		Iterator<AssociationType1> itAss = this.associations.iterator();
		while (itAss.hasNext()) {
			AssociationType1 assoc = itAss.next();
			if (folderDocumentAssociationIds.contains(assoc.getId())) {
				// found folder to document association

				// check if document doesn't exists in this submission
				if (!docEntryUUIDs.contains(assoc.getTargetObject())) {
					// add existing document entry to the set
					var doc = new Document();
					var de = new DocumentEntry();
					de.setEntryUuid(assoc.getTargetObject());
					de.setAvailabilityStatus(AvailabilityStatus.APPROVED);
					doc.setDocumentEntry(de);
					docSet.getDocuments().add(doc);

					// create a temp association to feed into the ssExtractor
					var tempAssoc = new AssociationType1();
					tempAssoc.setAssociationType(AssociationType.HAS_MEMBER.getOpcode30());
					tempAssoc.setSourceObject(setData.getId());
					tempAssoc.setTargetObject(assoc.getTargetObject());
					existingDocs.add(tempAssoc);
				}

				// check if folder doesn't exists in this submission
				// this check covers the case when the folder exists and
				// the document is either new or existing. The extractFodlers()
				// method covers the case when the folder exists and the
				// document is either new or existing.
				if (!folUUIDs.contains(assoc.getSourceObject())) {
					// add existing document entry to the set
					var folder = new Folder();
					folder.setEntryUuid(assoc.getSourceObject());
					folder.setAvailabilityStatus(AvailabilityStatus.APPROVED);
					folder.setLogicalUuid(assoc.getTargetObject());
					docSet.getFolders().add(folder);

					// create a temp association to feed into the ssExtractor
					var tempAssoc = new AssociationType1();
					tempAssoc.setAssociationType(AssociationType.HAS_MEMBER.getOpcode30());
					tempAssoc.setSourceObject(setData.getId());
					tempAssoc.setTargetObject(assoc.getTargetObject());
					existingFolders.add(tempAssoc);
				}
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Found {} existing documents and {} existing folders.", existingDocs.size(),
					existingFolders.size());
		}

		// add all current and existing documents
		var associatedDocs = new AssociationType1[(docs.size() + existingDocs.size())];
		Iterator<AssociationType1> itAssoc = docs.iterator();
		var count = 0;
		while (itAssoc.hasNext()) {
			associatedDocs[count] = itAssoc.next();
			count++;
		}
		Iterator<AssociationType1> itExit = existingDocs.iterator();
		while (itExit.hasNext()) {
			associatedDocs[count] = itExit.next();
			count++;
		}

		// add all current and existing folders
		var associatedFols = new AssociationType1[(folders.size() + existingFolders.size())];
		Iterator<AssociationType1> itFolder = folders.iterator();
		count = 0;
		while (itFolder.hasNext()) {
			associatedFols[count] = itFolder.next();
			count++;
		}
		Iterator<AssociationType1> itExistFolder = existingFolders.iterator();
		while (itExistFolder.hasNext()) {
			associatedFols[count] = itExistFolder.next();
			count++;
		}

		docSet.setSubmissionSet(extractSubmissionSet(setData, associatedDocs, associatedFols));
	}

	/**
	 * private utility that searches for the RegistryPackage representative of the
	 * folders returns null if the folders cannot be found
	 */
	private RegistryPackageType[] findFolders() throws MetadataExtractionException {
		// first search for external classifications
		Iterator<ClassificationType> i = this.classifications.iterator();
		List<String> folEntryUUIDs = new ArrayList<>();
		while (i.hasNext()) {
			ClassificationType c = i.next();
			if (c.getClassificationNode().equals(UUIDs.FOLDER_OBJECT)) {
				folEntryUUIDs.add(c.getClassifiedObject());
			}
		}
		Iterator<RegistryPackageType> it = this.registryPackages.iterator();
		List<RegistryPackageType> regs = new ArrayList<>();
		while (i.hasNext()) {
			RegistryPackageType reg = it.next();
			// try to match external classification with this registry package
			Iterator<String> j = folEntryUUIDs.iterator();
			var found = false;
			while (j.hasNext() && !found) {
				if (reg.getId().equals(j.next())) {
					regs.add(reg);
					found = true;
				}
			}
			if (!found) {
				// search the registry package internal classifications for Folder
				// classifications
				// per 2008-2009 IHE ITI CP 330
				Iterator<ClassificationType> jt = reg.getClassification().iterator();
				while (jt.hasNext()) {
					ClassificationType c = jt.next();
					if (UUIDs.FOLDER_OBJECT.equals(c.getClassificationNode())) {
						regs.add(reg);
						break;
					}
				}
			}
		}
		if (regs.isEmpty()) {
			return null;
		}
		var retVal = new RegistryPackageType[regs.size()];
		Iterator<RegistryPackageType> iR = regs.iterator();
		var count = 0;
		while (iR.hasNext()) {
			retVal[count] = iR.next();
			count++;
		}
		return retVal;
	}

	/**
	 * finds all HAS MEMBER associations with the given source object entry UUID,
	 * return null if none found
	 */
	private AssociationType1[] findHasMemberAssociationsWithSource(String sourceObjectID) {
		Iterator<AssociationType1> i = this.associations.iterator();
		List<AssociationType1> assocs = new ArrayList<>();
		while (i.hasNext()) {
			AssociationType1 assoc = i.next();
			if (assoc.getSourceObject().equals(sourceObjectID)
					&& assoc.getAssociationType().equals(EbXML_3_0ExtractorConstants.HAS_MEMBER)) {
				assocs.add(assoc);
			}
		}
		if (assocs.isEmpty()) {
			return null;
		}
		var retVal = new AssociationType1[assocs.size()];
		i = assocs.iterator();
		var count = 0;
		while (i.hasNext()) {
			retVal[count] = i.next();
			count++;
		}
		return retVal;
	}

	/**
	 * finds all HAS MEMBER associations with the given target object entry UUID,
	 * return null if none found
	 */
	private AssociationType1[] findHasMemberAssociationsWithTarget(String targetObjectID) {
		Iterator<AssociationType1> i = this.associations.iterator();
		List<AssociationType1> assocs = new ArrayList<>();
		while (i.hasNext()) {
			AssociationType1 assoc = i.next();
			if (assoc.getSourceObject().equals(targetObjectID)
					&& assoc.getAssociationType().equals(EbXML_3_0ExtractorConstants.HAS_MEMBER)) {
				assocs.add(assoc);
			}
		}
		if (assocs.isEmpty()) {
			return null;
		}
		var retVal = new AssociationType1[assocs.size()];
		i = assocs.iterator();
		var count = 0;
		while (i.hasNext()) {
			retVal[count] = i.next();
			count++;
		}
		return retVal;
	}

	/**
	 * checks to see if this document entry has a parent association, return null if
	 * none found
	 */
	private AssociationType1 findParent(String documentEntryUUID) {
		Iterator<AssociationType1> i = this.associations.iterator();
		while (i.hasNext()) {
			AssociationType1 assoc = (AssociationType1) i.next();
			if (assoc.getSourceObject().equals(documentEntryUUID)) {
				String rel = assoc.getAssociationType();
				if (rel.equals(EbXML_3_0ExtractorConstants.IHE_ASSOCIATION_TYPE_PREFIX
						+ ParentDocumentRelationshipType.APND_LITERAL.getName())
						|| rel.equals(EbXML_3_0ExtractorConstants.IHE_ASSOCIATION_TYPE_PREFIX
								+ ParentDocumentRelationshipType.RPLC_LITERAL.getName())
						|| rel.equals(EbXML_3_0ExtractorConstants.IHE_ASSOCIATION_TYPE_PREFIX
								+ ParentDocumentRelationshipType.XFRM_LITERAL.getName())
						|| rel.equals(EbXML_3_0ExtractorConstants.IHE_ASSOCIATION_TYPE_PREFIX
								+ ParentDocumentRelationshipType.XFRMRPLC_LITERAL.getName()))
					return assoc;
			}
		}
		return null;
	}

	/**
	 * private utility that searches for the RegistryPackage representative of the
	 * submissions set returns null if the submission set cannot be found
	 */
	private RegistryPackageType findSubmissionSet() {

		// first search for external classifications
		Iterator<ClassificationType> i = this.classifications.iterator();
		String ssEntryUUID = null;
		while (i.hasNext()) {
			ClassificationType c = i.next();
			if (c.getClassificationNode().equals(UUIDs.SUBMISSON_SET_OBJECT)) {
				ssEntryUUID = c.getClassifiedObject();
				break;
			}
		}

		Iterator<RegistryPackageType> it = this.registryPackages.iterator();
		while (i.hasNext()) {
			RegistryPackageType reg = it.next();
			if (reg.getId().equals(ssEntryUUID)) {
				return reg;
			} else {
				// search the registry package internal classifications for Submission Set
				// classification
				// per 2008-2009 IHE ITI CP 330
				Iterator<ClassificationType> ci = reg.getClassification().iterator();
				while (ci.hasNext()) {
					ClassificationType c = ci.next();
					if (c.getClassificationNode().equals(UUIDs.SUBMISSON_SET_OBJECT)) {
						return reg;
					}
				}
			}
		}
		return null;
	}

	/**
	 * method to assist in binning the content of the registry object list into:
	 * extrinsic objects, registry packages, classifications and associations
	 */
	private void sortContent(List<JAXBElement<? extends IdentifiableType>> list) {

		Iterator<JAXBElement<? extends IdentifiableType>> i = list.iterator();
		while (i.hasNext()) {
			JAXBElement<? extends IdentifiableType> ident = i.next();

			if (ident.getValue() instanceof RegistryPackageType) {
				if (registryPackages == null) {
					registryPackages = new ArrayList<>();
				}
				registryPackages.add((RegistryPackageType) ident.getValue());
			} else if (ident.getValue() instanceof ExtrinsicObjectType) {
				if (extrinsicObjects == null) {
					extrinsicObjects = new ArrayList<>();
				}
				extrinsicObjects.add((ExtrinsicObjectType) ident.getValue());
			} else if (ident.getValue() instanceof AssociationType1) {
				if (associations == null) {
					associations = new ArrayList<>();
				}
				associations.add((AssociationType1) ident.getValue());
			} else if (ident.getValue() instanceof ClassificationType) {
				if (classifications == null) {
					classifications = new ArrayList<>();
				}
				classifications.add((ClassificationType) ident.getValue());
			} else {
				logger.warn("SubmitObjectRequest contains unexpected element of type {}.", ident.getClass());
			}
		}
	}

	public SubmissionSet extractSubmissionSet(RegistryPackageType setData, AssociationType1[] documentsInSubmissionSet, AssociationType1[] foldersInSubmissionSet) throws MetadataExtractionException {
		var subSet = new SubmissionSet();
		// extract Registry Package attributes into metadata data members
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting attributes from the Registry Package.");
		}
		extractRegistryPackageAttributes(subSet, setData);

		// extract the RegistryPackage/Name as title
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting Name from the Registry Package.");
		}
		subSet.setTitle(convertInternationalStringType(setData.getName()));

		// extract Description
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting description from the Registry Package.");
		}
		subSet.setComments(convertInternationalStringType(setData.getDescription()));

		// extract Slots
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting Slot data from  the Registry Package.");
		}
		extractRegistryPackageSlots(subSet, setData);

		// extract ExternalIdentifiers
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting ExternalIdentifier data from the Registry Package.");
		}
		extractRegistryPackageExternalIdentifiers(subSet, setData);

		// extract Classification
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting Classification data from the Registry Package.");
		}
		extractRegistryPackageClassification(subSet, setData);

		// extract Document Associations
		extractAssociatedDocuments(subSet, documentsInSubmissionSet);

		// extract Folder Associations
		extractAssociatedFolders(subSet, foldersInSubmissionSet);

		return subSet;
	}

	private LocalizedString convertInternationalStringType(InternationalStringType intStringType) {
		LocalizedString retVal = null;
		for (LocalizedStringType locStringType : intStringType.getLocalizedString()) {
			if (locStringType != null) {
				retVal = new LocalizedString(locStringType.getValue(), locStringType.getLang(),
						locStringType.getCharset());
			}
		}

		return retVal;
	}

	/** Extracts the associated documents, if any */
	private List<Association> extractAssociatedDocuments(SubmissionSet subSet,
			AssociationType1[] documentsInSubmissionSet) {
		List<Association> associations = new LinkedList<>();
		if (documentsInSubmissionSet != null && documentsInSubmissionSet.length > 0) {
				if (logger.isDebugEnabled()) {
					logger.debug("Extracting Submission Set Associated Documents.");
				}
				for (var i = 0; i < documentsInSubmissionSet.length; i++) {
					// verify the association is for this Submission set
					if (documentsInSubmissionSet[i].getSourceObject()
							.equals(subSet.getEntryUuid())) {
						var assoc = new Association();
						assoc.setTargetUuid(documentsInSubmissionSet[i].getTargetObject());
						assoc.setSourceUuid(subSet.getEntryUuid());
						associations.add(assoc);
					} else {
						logger.error("Souce Object on {}"
								+ "the Document Association does not match the entryUUID for this Submission Set. "
								+ "This Association will not be included in the extraction.", i);
					}
				}

		}
		if (logger.isDebugEnabled()) {
			logger.debug("No Submission Set Associated Documents.");
		}

		return associations;
	}

	/** Extracts the associated folders, if any */
	private List<Association> extractAssociatedFolders(SubmissionSet subSet,
			AssociationType1[] foldersInSubmissionSet) {
		List<Association> associations = new LinkedList<>();
		if (foldersInSubmissionSet != null && foldersInSubmissionSet.length > 0) {
				if (logger.isDebugEnabled()) {
					logger.debug("Extracting Submission Set Associated Folders.");
				}
				for (var i = 0; i < foldersInSubmissionSet.length; i++) {
					// verify the association is for this Submission set
					if (foldersInSubmissionSet[i].getSourceObject().equals(subSet.getEntryUuid())) {
						var assoc = new Association();
						assoc.setTargetUuid(foldersInSubmissionSet[i].getTargetObject());
						assoc.setSourceUuid(subSet.getEntryUuid());
						associations.add(assoc);
					} else {
						logger.error(
								"Souce Object on {} th Folder Association does not match the entryUUID for this Submission Set. "
										+ "This Association will not be included in the extraction.",
								(i + 1));
					}
				}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("No Submission Set Associated Folders.");
		}

		return associations;
	}

	/**
	 * Extracts the attributes that correspond to XDSSubmissionSet metadata
	 * attributes from the RegistryPackage. Will extract the RegistryPackage/@id for
	 * the entryUUID metadata, however, this information should not be changed by
	 * any actor except the registry.
	 */
	private void extractRegistryPackageAttributes(SubmissionSet subSet, RegistryPackageType setData) {
		// Extract RegistryPackage/@id for entryUUID
		subSet.setEntryUuid(setData.getId());

		if (setData.getStatus() != null) {
			if (setData.getStatus().equals(EbXML_3_0ExtractorConstants.APPROVED_STATUS)) {
				subSet.setAvailabilityStatus(AvailabilityStatus.APPROVED);
			} else if (setData.getStatus().equals(EbXML_3_0ExtractorConstants.DEPRECATED_STATUS)) {
				subSet.setAvailabilityStatus(AvailabilityStatus.DEPRECATED);
			} else if (setData.getStatus().equals(EbXML_3_0ExtractorConstants.SUBMITTED_STATUS)) {
				subSet.setAvailabilityStatus(AvailabilityStatus.SUBMITTED);
			} else {
				logger.error("Unknown Status. Status will not be included in extracted content.");
			}
		}
	}

	/**
	 * Extracts metadata values from the Classifications of the RegistryPackage.
	 * Should be only one Classification (contentTypeCode). The first
	 * contentTypeCode identified will be extracted, the rest will be ignored.
	 */
	private void extractRegistryPackageClassification(SubmissionSet subSet, RegistryPackageType setData) {
		List<ClassificationType> classificationsSet = setData.getClassification();
		if (classificationsSet == null) {
			return;
		}

		// begin set list of classifications
		for (var i = 0; i < classificationsSet.size(); i++) {
			ClassificationType classification = classificationsSet.get(i);
			// null check
			if (classification == null) {
				continue;
			}
			if (classification.getClassificationScheme().equals(UUIDs.SUBMISSON_SET_AUTHOR)) {
				// add an author
				var author = new Author();

				for (var j = 0; j < classification.getSlot().size(); j++) {
					SlotType1 slot = (SlotType1) classification.getSlot().get(j);

					// null checks
					if (slot == null) {
						continue;
					}
					if (slot.getName() == null) {
						continue;
					}
					if (slot.getValueList() == null) {
						continue;
					}
					if (slot.getValueList().getValue() == null) {
						continue;
					}
					if (slot.getValueList().getValue().isEmpty()) {
						continue;
					} else if (slot.getValueList().getValue().get(0) == null) {
						continue;
					}

					String slotName = slot.getName();
					if (slotName.equals(SubmissionSetConstants.AUTHOR_INSTITUTION)) {
						// get the XON string
						String s = (String) slot.getValueList().getValue().get(0);
						author.getAuthorInstitution().add(Hl7Util.extractHl7Xon(s));
					} else if (slotName.equals(SubmissionSetConstants.AUTHOR_PERSON)) {
						if (author.getAuthorPerson() != null) {
							logger.error(
									"Duplicate Author.authorPerson. Will only use first full name in the extracted content.");
							continue;
						}
						// get the XCN string
						String s = (String) slot.getValueList().getValue().get(0);
						author.setAuthorPerson(Hl7Util.extractHl7Xcn(s));
					} else if (slotName.equals(SubmissionSetConstants.AUTHOR_ROLE)) {
						author.getAuthorRole().add(new Identifiable((String) slot.getValueList().getValue().get(0)));
					} else if (slotName.equals(SubmissionSetConstants.AUTHOR_SPECIALITY)) {
						author.getAuthorSpecialty()
								.add(new Identifiable((String) slot.getValueList().getValue().get(0)));
					}
					// Added by CP 524, 627 and 628 for IHE ITI TF v9 (2012-2013)
					else if (slotName.equals(DocumentEntryConstants.AUTHOR_TELECOMMUNICATION)) {
						// get the XTN string
						String s = (String) slot.getValueList().getValue().get(0);
						// convert
						author.getAuthorTelecom().add(Hl7Util.extractHl7Xtn(s));
					}
				}
				subSet.setAuthor(author);
			} else if (classification.getClassificationScheme().equals(UUIDs.SUBMISSION_SET_CONTENT_TYPE_CODE)) {
				if (subSet.getContentTypeCode() != null) {
					logger.error(
							"Duplicate SubmissionSet.contentTypeCode. Will only use first code in the extracted content.");
					continue;
				}
				// build code
				var code = new Code();
				code.setCode(classification.getNodeRepresentation());
				code.setDisplayName(convertInternationalStringType(classification.getName()));

				// null checks on slot, if all good .. set code scheme name
				if (classification.getSlot() != null && !classification.getSlot().isEmpty()
						&& classification.getSlot().get(0) != null) {

							org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.SlotType1 cSlot = classification
									.getSlot().get(0);
						if (cSlot.getValueList() != null && cSlot.getValueList().getValue() != null
								&& !cSlot.getValueList().getValue().isEmpty()) {

										code.setSchemeName(cSlot.getValueList().getValue().get(0));

							}
				}
				subSet.setContentTypeCode(code);

			}
			// cannot continue with invalid files.
			else if (classification.getClassificationScheme() == null) {
				logger.error("Required Classification/@classificationScheme attribute missing. "
						+ "Code or Author will not be included in extracted content.");
			} else {
				logger.error(
						"Unidentified Classification/@classificationScheme: {}. Code or Author will not be included in extracted content.",
						classification.getClassificationScheme());
			}
		}
	}

	/**
	 * Extracts metadata values from the ExternalIdentifiers of the RegisryPackage
	 */
	private void extractRegistryPackageExternalIdentifiers(SubmissionSet subSet, RegistryPackageType setData) {
		List<org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.ExternalIdentifierType> externalIdentifiers = setData
				.getExternalIdentifier();
		for (var i = 0; i < externalIdentifiers.size(); i++) {
			ExternalIdentifierType exID = (ExternalIdentifierType) externalIdentifiers.get(i);
			// null check
			if (exID == null) {
				continue;
			}

			// extract metadata
			String exUUID = exID.getIdentificationScheme();
			// cannot continue with invalid files.
			if (exUUID == null) {
				logger.error(
						"Required ExternalIdentifier/@identificationScheme attribute missing for following id: {}. ID will not be included in extracted content.",
						exID.getValue());
				return;
			}

			if (exUUID.equals(UUIDs.SUBMISSION_SET_PATIENT_IDENTIFICATION_SCHEME)) {
				subSet.setPatientId(Hl7Util.extractHl7Cx(exID.getValue()));
			} else if (exUUID.equals(UUIDs.SUBMISSION_SET_SOURCE_IDENTIFICATION_SCHEME)) {
				subSet.setSourceId(exID.getValue());
			} else if (exUUID.equals(UUIDs.SUBMISSION_SET_UNIQUE_IDENTIFICATION_SCHEME)) {
				subSet.setUniqueId(exID.getValue());
			} else {
				logger.error(
						"Unidentified ExternalIdentifier/@identificationScheme: {}. {} will not be included in extracted content.",
						exUUID, exID.getValue());
			}
		}
	}

	/**
	 * Extracts metadata values from the slots of the RegistryPackage
	 */
	private void extractRegistryPackageSlots(SubmissionSet subSet, RegistryPackageType setData) {
		List<org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.SlotType1> slots = setData.getSlot();
		for (var i = 0; i < slots.size(); i++) {
			org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.SlotType1 slot = slots.get(i);

			// null checks
			if (slot == null) {
				continue;
			}
			if (slot.getName() == null) {
				continue;
			}
			if (slot.getValueList() == null) {
				continue;
			}
			if (slot.getValueList().getValue() == null) {
				continue;
			}
			if (slot.getValueList().getValue().isEmpty()) {
				continue;
			} else if (slot.getValueList().getValue().get(0) == null) {
				continue;
			}

			String slotName = slot.getName();
			if (slotName.equals(SubmissionSetConstants.SUBMISSION_TIME)) {
				subSet.setSubmissionTime(slot.getValueList().getValue().get(0));
			} else if (slotName.equals(SubmissionSetConstants.INTENDED_RECIPIENT)) {
				Iterator<String> j = slot.getValueList().getValue().iterator();
				while (j.hasNext()) {
					String slotValue = j.next();
					var recipient = new Recipient();
					var tokenizer = new StringTokenizer(slotValue, "|");
					if (tokenizer.hasMoreTokens()) {
						String token = tokenizer.nextToken();
						// organization
						if (token != null) {
							if (token.length() > 0) {
								recipient.setOrganization(Hl7Util.extractHl7Xon(token));
							} else {
								logger.info("Slot: {} organzation is empty", slotName);
							}
						}
						// person
						if (tokenizer.hasMoreTokens()) {
							token = tokenizer.nextToken();
							if (token != null) {
								if (token.length() > 0) {
									recipient.setPerson(Hl7Util.extractHl7Xcn(token));
								} else {
									logger.info("Slot: {} person is empty", slotName);
								}
							}
							// telcom
							// Added by CP 524, 627 and 628 for IHE ITI TF v9 (2012-2013)
							if (tokenizer.hasMoreTokens()) {
								token = tokenizer.nextToken();
								if (token != null) {
									if (token.length() > 0) {
										recipient.setTelecom(Hl7Util.extractHl7Xtn(token));
									} else {
										logger.info("Slot: {} person telcom is empty", slotName);
									}
								}
							}
							if (recipient.getOrganization() != null || recipient.getPerson() != null
									|| recipient.getTelecom() != null)
								subSet.getIntendedRecipients().add(recipient);
							else
								logger.error(
										"Slot: {} has all empty tokens. No intended recipient added.", slotName);
						}
					} else {
						logger.error("Slot: {} has no tokens.", slotName);
					}
				}
			} else {
				logger.error(
						"Unidentified Slot: {}. Slot content will not be included in extracted content.", slotName);
			}
		}
	}

	public Folder extractFolder(RegistryPackageType folderData) throws MetadataExtractionException {
		if (folderData == null) {
			logger.error("RegistryPackage is null, cannot execute extraction.");
			throw new MetadataExtractionException("RegistryPackage is null, cannot execute extraction.");
		}
		Folder folder = new Folder();

		// extract Registry Package attributes into metadata data members
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting attributes from the Registry Package.");
		}
		extractRegistryPackageAttributesFolder(folder, folderData);

		// extract the RegistryPackage/Name as title
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting Name from the Registry Package.");
		}
		folder.setTitle(convertInternationalStringType(folderData.getName()));

		// extract Description
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting description from the Registry Package.");
		}
		folder.setComments(convertInternationalStringType(folderData.getDescription()));

		// extract Slots (should be only one slot: lastUpdateTime)
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting Slot data from  the Registry Package.");
		}
		extractRegistryPackageSlots(folder, folderData);

		// extract ExternalIdentifiers
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting ExternalIdentifier data from the Registry Package.");
		}
		extractRegistryPackageExternalIdentifiers(folder, folderData);

		// extract Classifications
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting Classification data from the Registry Package.");
		}
		extractRegistryPackageClassifications(folder, folderData);

		return folder;
	}

	/**
	 * Extracts the attributes that correspond to XDSSubmissionSet metadata
	 * attributes from the RegistryPackage. Will extract the RegistryPackage/@id for
	 * the entryUUID metadata, however, this information should not be changed by
	 * any actor except the registry.
	 */
	private void extractRegistryPackageAttributesFolder(Folder folder, RegistryPackageType folderData) {
		// Extract RegistryPackage/@id for entryUUID
		folder.setEntryUuid(folderData.getId());

		if (folderData.getStatus() != null) {
			if (folderData.getStatus().equals(EbXML_3_0ExtractorConstants.APPROVED_STATUS)) {
				folder.setAvailabilityStatus(AvailabilityStatus.APPROVED);
			} else if (folderData.getStatus().equals(EbXML_3_0ExtractorConstants.DEPRECATED_STATUS)) {
				folder.setAvailabilityStatus(AvailabilityStatus.DEPRECATED);
			} else if (folderData.getStatus().equals(EbXML_3_0ExtractorConstants.SUBMITTED_STATUS)) {
				folder.setAvailabilityStatus(AvailabilityStatus.SUBMITTED);
			} else {
				logger.error("Unknown Status. Status will not be included in extracted content.");
			}
		}
	}

	/**
	 * Extract the codeList codes from the EList of ClassificationType objects
	 * 
	 * @param codeList list of codes, assumed to contain ONLY ClassificationType
	 *                 objects
	 * @param folder   folder to add codes to
	 */
	private void extractRegistryPackageClassifications(Folder folder, RegistryPackageType folderData) {
		List<ClassificationType> codeList = folderData.getClassification();
		for (var i = 0; i < codeList.size(); i++) {

			if (!(codeList.get(i) instanceof ClassificationType)) {
				continue;
			}
			ClassificationType c = codeList.get(i);
			// null check
			if (c == null) {
				continue;
			}

			// extract Classification
			var code = new Code();
			code.setCode(c.getNodeRepresentation());
			code.setDisplayName(convertInternationalStringType(c.getName()));
			// null checks on slot, if all good .. set code scheme name
			if (c.getSlot() != null) {
				if (!c.getSlot().isEmpty()) {
					if (c.getSlot().get(0) != null) {
						org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.SlotType1 cSlot = c.getSlot().get(0);
						if (cSlot.getValueList() != null) {
							if (cSlot.getValueList().getValue() != null) {
								if (!cSlot.getValueList().getValue().isEmpty()) {
									code.setSchemeName((String) cSlot.getValueList().getValue().get(0));
								}
							}
						}
					}
				}
			}
			String codeUUID = c.getClassificationScheme();
			// cannot continue with invalid files.
			if (codeUUID == null) {
				logger.error(
						"Required Classification/@classificationScheme attribute missing for following code: {}. {}. Code will not be included in extracted content.",
						code.getCode(), code.getSchemeName());
			}
			// add code to folder
			else if (codeUUID.equals(UUIDs.FOLDER_CODE)) {
				folder.getCodeList().add(code);
			} else {
				logger.error(
						"Unidentified Classification/@classificationScheme: {} {}, {} will not be included in extracted content.",
						codeUUID, code.getCode(), code.getSchemeName());
			}

		}
	}

	/**
	 * Extracts metadata values from the ExternalIdentifiers of the RegisryPackage
	 */
	private void extractRegistryPackageExternalIdentifiers(Folder folder, RegistryPackageType folderData) {

		List<org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.ExternalIdentifierType> externalIdentifiers = folderData
				.getExternalIdentifier();
		for (var i = 0; i < externalIdentifiers.size(); i++) {
			ExternalIdentifierType exID = (ExternalIdentifierType) externalIdentifiers.get(i);
			String idScheme = exID.getIdentificationScheme();

			// cannot continue with invalid files.
			if (idScheme == null) {
				logger.error(
						"Required ExternalIdentifier/@identificationScheme attribute missing for following id: {}. ID will not be included in extracted content.",
						exID.getValue());
				return;
			}
			if (idScheme.equals(UUIDs.FOLDER_PATIENT_IDENTIFICATION_SCHEME)) {
				String s = exID.getValue();
				folder.setPatientId(Hl7Util.extractHl7Cx(s));
			} else if (idScheme.equals(UUIDs.FOLDER_UNIQUE_IDENTIFICATION_SCHEME)) {
				folder.setUniqueId(exID.getValue());
			} else {
				logger.error(
						"Unidentified ExternalIdentifier/@identificationScheme: {}. {} will not be included in extracted content.",
						idScheme, exID.getValue());
			}
		} // end loop
	}

	/**
	 * Extracts metadata values from the slots of the RegistryPackage (should be
	 * only one slot: lastUpdateTime) returns first instance of it, incase there
	 * happen to be multiple ... which would be invalid
	 */
	private void extractRegistryPackageSlots(Folder folder, RegistryPackageType folderData) {
		List<org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.SlotType1> slots = folderData.getSlot();
		for (var i = 0; i < slots.size(); i++) {
			SlotType1 slot = (SlotType1) slots.get(i);

			// null checks
			if (slot == null) {
				continue;
			}
			if (slot.getName() == null) {
				continue;
			}
			if (slot.getValueList() == null) {
				continue;
			}
			if (slot.getValueList().getValue() == null) {
				continue;
			}
			if (!slot.getValueList().getValue().isEmpty()) {
				continue;
			} else if (slot.getValueList().getValue().get(0) == null) {
				continue;
			}

			String slotName = slot.getName();
			if (slotName.equals(FolderConstants.LAST_UPDATE_TIME)) {
				// get the XON string
				String s = (String) slot.getValueList().getValue().get(0);
				folder.setLastUpdateTime(s);
				return;
			}
		}
	}

	public void extractDocumentEntry(ProvideAndRegisterDocumentSet docSet, ExtrinsicObjectType docData,
			AssociationType1 parentData)
			throws MetadataExtractionException {
		// check for null extrinsic object
		if (docData == null) {
			logger.error("ExtrinsicObject is null, cannot execute extraction.");
			throw new MetadataExtractionException("ExtrinsicObject is null, cannot execute extraction.");
		}

		// create document entry
		DocumentEntry docEntry = new DocumentEntry();

		// check for parent data
		if (parentData != null) {
			// relationship
			String rel = parentData.getAssociationType();
			Association parentDoc = new Association();
			if (rel.equals(EbXML_3_0ExtractorConstants.XFRM)) {
				parentDoc.setAssociationType(AssociationType.TRANSFORM);
			} else if (rel.equals(EbXML_3_0ExtractorConstants.APND)) {
				parentDoc.setAssociationType(AssociationType.APPEND);
			} else if (rel.equals(EbXML_3_0ExtractorConstants.RPLC)) {
				parentDoc.setAssociationType(AssociationType.REPLACE);
			} else if (rel.equals(EbXML_3_0ExtractorConstants.XFRM_RPLC)) {
				parentDoc.setAssociationType(AssociationType.TRANSFORM_AND_REPLACE);
			} else {
				// error
				logger.error("AssociationType for parent document is not among the following: {}"
						,ParentDocumentRelationshipType.VALUES.toString());
			}

			// id
			if (logger.isDebugEnabled()) {
				logger.debug("Extracting parent document id from the Association.");
			}
			if (parentData.getTargetObject() != null) {
				parentDoc.setTargetUuid(parentData.getTargetObject());
			} else {
				logger.error("Id for parent document is null");
			}

			// code
			if (parentData.getClassification() != null) {
				if (!parentData.getClassification().isEmpty()) {
					if (logger.isDebugEnabled()) {
						logger.debug("Extracting parent document relationship code from the Association.");
					}
					ClassificationType classification = parentData.getClassification().get(0);
					Code code = new Code();
					code.setCode(classification.getNodeRepresentation());
					code.setDisplayName(convertInternationalStringType(classification.getName()));
					// null checks on slot, if all good .. set code scheme name
					if (classification.getSlot() != null) {
						if (!classification.getSlot().isEmpty()) {
							if (classification.getSlot().get(0) != null) {
								SlotType1 cSlot = (SlotType1) classification.getSlot().get(0);
								if (cSlot.getValueList() != null) {
									if (cSlot.getValueList().getValue() != null) {
										if (!cSlot.getValueList().getValue().isEmpty()) {
											code.setSchemeName((String) cSlot.getValueList().getValue().get(0));
										}
									}
								}
							}
						}
					}
					String codeUUID = classification.getClassificationScheme();
					// cannot continue with invalid files.
					if (codeUUID == null) {
						logger.error(
								"Required Classification/@classificationScheme attribute missing for following code: {}. {}. Code will not be included in extracted content."
										, code.getCode() , code.getSchemeName());
					} else if (codeUUID.equalsIgnoreCase(UUIDs.DOC_ENTRY_PARENT_DOCUMENT_RELATIONSHIP_CODE) ) {
						parentDoc.setDocCode(code);
					} else {
						logger.error(
								"Required Classification/@classificationScheme attribute missing for following code: {}. {}. Code will not be included in extracted content."
										, code.getCode() , code.getSchemeName());
					}
				}
			}

			docSet.getAssociations().add(parentDoc);
		}

		// extract Extrinsic object attributes into metadata data members
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting attributes from the Extrinsic Object.");
		}
		extractExtrinsicObjectAttributes(docEntry, docData);

		// extract the ExtrinsicObject/Name as title
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting Name from the Extrinsic Object.");
		}
		docEntry.setTitle(convertInternationalStringType(docData.getName()));

		// extract Description
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting description from the Extrinsic Object.");
		}
		docEntry.setComments(convertInternationalStringType(docData.getDescription()));

		// process ExtrinsicObject slots
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting Slot data from the Extrinsic Object.");
		}
		extractExtrinsicObjectSlots(docEntry, docData);

		// process ExtrinsicObject classifications
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting Classification data from the Extrinsic Object.");
		}
		extractExtrinsicObjectClassifications(docEntry, docData);

		// process ExtrinsicObject external identifiers
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting ExternalIdentifier data from the Extrinsic Object.");
		}
		extractExtringsicObjectExternalIdentifiers(docEntry, docData);

		docSet.getDocuments().add(new Document(docEntry, null));
	}

	/**
	 * Extracts metadata values from the ExternalIdentifiers of the ExtrinsicObject
	 */
	private void extractExtringsicObjectExternalIdentifiers(DocumentEntry docEntry, ExtrinsicObjectType docData) {
		List<org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.ExternalIdentifierType> externalIdentifiers = docData
				.getExternalIdentifier();
		for (int i = 0; i < externalIdentifiers.size(); i++) {
			ExternalIdentifierType exID = (ExternalIdentifierType) externalIdentifiers.get(i);
			// null check
			if (exID == null) {
				continue;
			}

			// extract metadata
			String exUUID = exID.getIdentificationScheme();
			// cannot continue with invalid files.
			if (exUUID == null) {
				logger.error("Required ExternalIdentifier/@identificationScheme attribute missing for following id: {}"
						+ ". ID will not be included in extracted content.", exID.getValue());
				return;
			}

			if (exUUID.equals(UUIDs.DOC_ENTRY_PATIENT_IDENTIFICATION_SCHEME)) {
				String s = exID.getValue();
				docEntry.setPatientId(Hl7Util.extractHl7Cx(s));
			} else if (exUUID.equals(UUIDs.DOC_ENTRY_UNIQUE_IDENTIFICATION_SCHEME)) {
				docEntry.setUniqueId(exID.getValue());
			} else {
				logger.error("Unidentified ExternalIdentifier/@identificationScheme: {}. {}"
						+ " will not be included in extracted content.", exUUID, exID.getValue());
			}

		} // end loop
	}

	/**
	 * Extracts the attributes that correspond to XDSDocumentEntry metadata
	 * attributes from the ExtrinsicObject. Will extract the ExtrinsicObject/@id for
	 * the entryUUID metadata, however, this information should not be changed by
	 * any actor except the registry.
	 */
	private void extractExtrinsicObjectAttributes(DocumentEntry docEntry, ExtrinsicObjectType docData) {
		// Extract ExtrinsicObject/@id for entryUUID
		docEntry.setEntryUuid(docData.getId());

		if (docData.getStatus() != null) {
			if (docData.getStatus().equals(EbXML_3_0ExtractorConstants.APPROVED_STATUS)) {
				docEntry.setAvailabilityStatus(AvailabilityStatus.APPROVED);
			} else if (docData.getStatus().equals(EbXML_3_0ExtractorConstants.DEPRECATED_STATUS)) {
				docEntry.setAvailabilityStatus(AvailabilityStatus.DEPRECATED);
			} else if (docData.getStatus().equals(EbXML_3_0ExtractorConstants.SUBMITTED_STATUS)) {
				docEntry.setAvailabilityStatus(AvailabilityStatus.SUBMITTED);
			} else {
				logger.error("Unknown Status. Status will not be included in extracted content.");
			}
		}
		docEntry.setMimeType(docData.getMimeType());
	}

	/**
	 * Extracts metadata values from the Classifications of the ExtrinsicObject
	 */
	private void extractExtrinsicObjectClassifications(DocumentEntry docEntry, ExtrinsicObjectType docData) {
		List<Code> eventCodes = docEntry.getEventCodeList();
		List<ClassificationType> classifications = docData.getClassification();
		if (classifications == null) {
			return;
		}

		// begin set list of classifications
		for (var i = 0; i < classifications.size(); i++) {
			ClassificationType classification = classifications.get(i);
			// null check
			if (classification == null) {
				continue;
			}
			if (classification.getClassificationScheme().equals(UUIDs.DOC_ENTRY_AUTHOR)) {
				// add an author
				Author author = new Author();

				for (var j = 0; j < classification.getSlot().size(); j++) {
					SlotType1 slot = (SlotType1) classification.getSlot().get(j);

					// null checks
					if (slot == null) {
						continue;
					}
					if (slot.getName() == null) {
						continue;
					}
					if (slot.getValueList() == null) {
						continue;
					}
					if (slot.getValueList().getValue() == null) {
						continue;
					}
					if (slot.getValueList().getValue().isEmpty()) {
						continue;
					} else if (slot.getValueList().getValue().get(0) == null) {
						continue;
					}

					String slotName = slot.getName();
					if (slotName.equals(DocumentEntryConstants.AUTHOR_INSTITUTION)) {
						// get the XON string
						String s = (String) slot.getValueList().getValue().get(0);
						author.getAuthorInstitution().add(Hl7Util.extractHl7Xon(s));
					} else if (slotName.equals(DocumentEntryConstants.AUTHOR_PERSON)) {
						if (author.getAuthorPerson() != null) {
							logger.error(
									"Duplicate Author.authorPerson. Will only use first full name in the extracted content.");
							continue;
						}
						// get the XCN string
						String s = (String) slot.getValueList().getValue().get(0);
						author.setAuthorPerson(Hl7Util.extractHl7Xcn(s));
					} else if (slotName.equals(DocumentEntryConstants.AUTHOR_ROLE)) {
						author.getAuthorRole()
								.add(new Identifiable((String) slot.getValueList().getValue().get(0)));
					} else if (slotName.equals(DocumentEntryConstants.AUTHOR_SPECIALITY)) {
						author.getAuthorSpecialty()
								.add(new Identifiable((String) slot.getValueList().getValue().get(0)));
					}
					// Added by CP 524, 627 and 628 for IHE ITI TF v9 (2012-2013)
					else if (slotName.equals(DocumentEntryConstants.AUTHOR_TELECOMMUNICATION)) {
						// get the XTN string
						String s = (String) slot.getValueList().getValue().get(0);
						// convert
						author.getAuthorTelecom().add(Hl7Util.extractHl7Xtn(s));
					}
				} // end slot loop
				docEntry.getAuthors().add(author);
			} else {// build code
				Code code = new Code();
				code.setCode(classification.getNodeRepresentation());
				code.setDisplayName(convertInternationalStringType(classification.getName()));
				// null checks on slot, if all good .. set code scheme name
				if (classification.getSlot() != null) {
					if (!classification.getSlot().isEmpty()) {
						if (classification.getSlot().get(0) != null) {
							SlotType1 cSlot = (SlotType1) classification.getSlot().get(0);
							if (cSlot.getValueList() != null) {
								if (cSlot.getValueList().getValue() != null) {
									if (!cSlot.getValueList().getValue().isEmpty()) {
										code.setSchemeName((String) cSlot.getValueList().getValue().get(0));
									}
								}
							}
						}
					}
				}
				String codeUUID = classification.getClassificationScheme();
				// cannot continue with invalid files.
				if (codeUUID == null) {
					logger.error(
							"Required Classification/@classificationScheme attribute missing for following code: {}, {}"
									+ ". Code will not be included in extracted content.",
							code.getCode(), code.getSchemeName());
				}

				if (codeUUID.equals(UUIDs.DOC_ENTRY_CLASS_CODE)) {
					if (docEntry.getClassCode() != null) {
						logger.error(
								"Duplicate DocumentEntry.classCode. Will only use first code found in the extracted content.");
						continue;
					}
					docEntry.setClassCode(code);
				} else if (codeUUID.equals(UUIDs.DOC_ENTRY_CONFIDENTIALITY_CODE)) {
					docEntry.getConfidentialityCodes().add(code);
				} else if (codeUUID.equals(UUIDs.DOC_ENTRY_EVENT_CODE)) {
					eventCodes.add(code);
				} else if (codeUUID.equals(UUIDs.DOC_ENTRY_FORMAT_CODE)) {
					if (docEntry.getFormatCode() != null) {
						logger.error(
								"Duplicate DocumentEntry.formatCode. Will only use first code found in the extracted content.");
						continue;
					}
					docEntry.setFormatCode(code);
				} else if (codeUUID.equals(UUIDs.DOC_ENTRY_HEALTH_CARE_FACILITY_CODE)) {
					if (docEntry.getHealthcareFacilityTypeCode() != null) {
						logger.error(
								"Duplicate DocumentEntry.healthcareFacilityCode. Will only use first code found in the extracted content.");
						continue;
					}
					docEntry.setHealthcareFacilityTypeCode(code);

				} else if (codeUUID.equals(UUIDs.DOC_ENTRY_PRACTICE_SETTING_CODE)) {
					if (docEntry.getPracticeSettingCode() != null) {
						logger.error(
								"Duplicate DocumentEntry.practiceSettingCode. Will only use first code found in the extracted content.");
						continue;
					}
					docEntry.setPracticeSettingCode(code);
				} else if (codeUUID.equals(UUIDs.DOC_ENTRY_TYPE_CODE)) {
					if (docEntry.getTypeCode() != null) {
						logger.error(
								"Duplicate DocumentEntry.typeCode. Will only use first code found in the extracted content.");
						continue;
					}
					docEntry.setTypeCode(code);
				} else {
					logger.error(
							"Unidentified Classification/@classificationScheme: {}. {}. {} will not be included in extracted content.",
							codeUUID, code.getCode(), code.getSchemeName());
				}
			}
		}
	}

	/**
	 * Extracts metadata values from the slots of the ExtrinsicObject
	 */
	private void extractExtrinsicObjectSlots(DocumentEntry docEntry, ExtrinsicObjectType docData) {
		List<org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.SlotType1> slots = docData.getSlot();
		for (var i = 0; i < slots.size(); i++) {
			org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.rim.SlotType1 slot = slots.get(i);

			// null checks
			if (slot == null) {
				continue;
			}
			if (slot.getName() == null) {
				continue;
			}
			if (slot.getValueList() == null) {
				continue;
			}
			if (slot.getValueList().getValue() == null) {
				continue;
			}
			if (!slot.getValueList().getValue().isEmpty()) {
				continue;
			} else if (slot.getValueList().getValue().get(0) == null) {
				continue;
			}

			// all ok ... extract info from the slot
			String slotName = slot.getName();

			if (slotName.equals(DocumentEntryConstants.CREATION_TIME)) {
				docEntry.setCreationTime(slot.getValueList().getValue().get(0));
			} else if (slotName.equals(DocumentEntryConstants.HASH)) {
				docEntry.setHash(slot.getValueList().getValue().get(0));
			} else if (slotName.equals(DocumentEntryConstants.LANGUAGE_CODE)) {
				docEntry.setLanguageCode(slot.getValueList().getValue().get(0));
			} else if (slotName.equals(DocumentEntryConstants.LEGAL_AUTHENTICATOR)) {
				String s = slot.getValueList().getValue().get(0);
				docEntry.setLegalAuthenticator(Hl7Util.extractHl7Xcn(s));
			} else if (slotName.equals(DocumentEntryConstants.REPOSITORY_UNIQUE_ID)) {
				docEntry.setRepositoryUniqueId(slot.getValueList().getValue().get(0));
			} else if (slotName.equals(DocumentEntryConstants.SERVICE_START_TIME)) {
				docEntry.setServiceStartTime(slot.getValueList().getValue().get(0));
			} else if (slotName.equals(DocumentEntryConstants.SERVICE_STOP_TIME)) {
				docEntry.setServiceStopTime(slot.getValueList().getValue().get(0));
			} else if (slotName.equals(DocumentEntryConstants.SIZE)) {
				docEntry.setSize(Long.valueOf(slot.getValueList().getValue().get(0)));
			} else if (slotName.equals(DocumentEntryConstants.SOURCE_PATIENT_ID)) {
				// get the FieldType string
				String s = slot.getValueList().getValue().get(0);
				docEntry.setSourcePatientId(Hl7Util.extractHl7Cx(s));
			} else if (slotName.equals(DocumentEntryConstants.SOURCE_PATIENT_INFO)) {
				// get the PID segment
				int n = slot.getValueList().getValue().size();
				var sourcePatientInfo = new PatientInfo();
				for (var j = 0; j < n; j++) {
					// get the PID field
					String s = slot.getValueList().getValue().get(j);

					// determine the PID field ItenNo set.
					String itemNo = null;
					if (s.startsWith(DocumentEntryConstants.PID10_ID)) {
						itemNo = DocumentEntryConstants.PID10_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID11_ID)) {
						itemNo = DocumentEntryConstants.PID11_ID;
						if (s.length() > (itemNo.length() + 1)) {
							sourcePatientInfo.getAddresses()
									.add(Hl7Util.extractHl7Xad(s.substring(itemNo.length() + 1)));
						}
					} else if (s.startsWith(DocumentEntryConstants.PID12_ID)) {
						itemNo = DocumentEntryConstants.PID12_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID13_ID)) {
						itemNo = DocumentEntryConstants.PID13_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID14_ID)) {
						itemNo = DocumentEntryConstants.PID14_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID15_ID)) {
						itemNo = DocumentEntryConstants.PID15_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID16_ID)) {
						itemNo = DocumentEntryConstants.PID16_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID17_ID)) {
						itemNo = DocumentEntryConstants.PID17_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID18_ID)) {
						itemNo = DocumentEntryConstants.PID18_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID19_ID)) {
						itemNo = DocumentEntryConstants.PID19_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID1_ID)) {
						itemNo = DocumentEntryConstants.PID1_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID20_ID)) {
						itemNo = DocumentEntryConstants.PID20_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID21_ID)) {
						itemNo = DocumentEntryConstants.PID21_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID22_ID)) {
						itemNo = DocumentEntryConstants.PID22_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID23_ID)) {
						itemNo = DocumentEntryConstants.PID23_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID24_ID)) {
						itemNo = DocumentEntryConstants.PID24_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID25_ID)) {
						itemNo = DocumentEntryConstants.PID25_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID26_ID)) {
						itemNo = DocumentEntryConstants.PID26_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID27_ID)) {
						itemNo = DocumentEntryConstants.PID27_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID28_ID)) {
						itemNo = DocumentEntryConstants.PID28_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID29_ID)) {
						itemNo = DocumentEntryConstants.PID29_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID2_ID)) {
						itemNo = DocumentEntryConstants.PID2_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID30_ID)) {
						itemNo = DocumentEntryConstants.PID30_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID31_ID)) {
						itemNo = DocumentEntryConstants.PID31_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID32_ID)) {
						itemNo = DocumentEntryConstants.PID32_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID33_ID)) {
						itemNo = DocumentEntryConstants.PID33_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID34_ID)) {
						itemNo = DocumentEntryConstants.PID34_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID35_ID)) {
						itemNo = DocumentEntryConstants.PID35_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID36_ID)) {
						itemNo = DocumentEntryConstants.PID36_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID37_ID)) {
						itemNo = DocumentEntryConstants.PID37_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID38_ID)) {
						itemNo = DocumentEntryConstants.PID38_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID39_ID)) {
						itemNo = DocumentEntryConstants.PID39_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID3_ID)) {
						itemNo = DocumentEntryConstants.PID3_ID;
						sourcePatientInfo.getIds().add(Hl7Util.extractHl7Cx(s.substring(itemNo.length() + 1)));
					} else if (s.startsWith(DocumentEntryConstants.PID4_ID)) {
						itemNo = DocumentEntryConstants.PID4_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID5_ID)) {
						itemNo = DocumentEntryConstants.PID5_ID;
						sourcePatientInfo.getNames().add(Hl7Util.extractHl7Xpn(s.substring(itemNo.length() + 1)));
					} else if (s.startsWith(DocumentEntryConstants.PID6_ID)) {
						itemNo = DocumentEntryConstants.PID6_ID;
					} else if (s.startsWith(DocumentEntryConstants.PID7_ID)) {
						itemNo = DocumentEntryConstants.PID7_ID;
						sourcePatientInfo.setDateOfBirth(s.substring(itemNo.length() + 1));
					} else if (s.startsWith(DocumentEntryConstants.PID8_ID)) {
						itemNo = DocumentEntryConstants.PID8_ID;
						sourcePatientInfo.setGender(s.substring(itemNo.length() + 1));
					} else if (s.startsWith(DocumentEntryConstants.PID9_ID)) {
						itemNo = DocumentEntryConstants.PID9_ID;
					}

				}

				docEntry.setSourcePatientInfo(sourcePatientInfo);
			} // end else if
			else if (slotName.equals(DocumentEntryConstants.URI)) {
				// load uri pieces into map
				Iterator<String> iter = slot.getValueList().getValue().iterator();
				Map<Integer, String> m = new HashMap<>();
				while (iter.hasNext()) {
					// TODO have separate constant for long uri delimiter
					String uriPiece = iter.next();
					var st = new StringTokenizer(uriPiece, "|");
					if (st.countTokens() > 1) {
						try {
							var k = Integer.parseInt(st.nextToken().trim());
							m.put(Integer.valueOf(k), st.nextToken());
						} catch (Exception e) {
							logger.error("Mal-formatted URI. Slot content will not be included in extracted content.",
									e);
						}
					} else if (st.countTokens() == 1) {
						m.put(Integer.valueOf(1), st.nextToken());
						break;
					} else { // ZERO TOKENS
						logger.info("No URI found.");
					}
				}
				// reform uri
				var longURI = new StringBuilder();
				for (var c = 0; c < m.size(); c++) {
					longURI.append(m.get(Integer.valueOf((c + 1))));
				}
				docEntry.setUri(longURI.toString());
			}

			else {
				logger.warn(
						"Unidentified Slot: {}. Slot content is interpreted as 'extension metadata'.", slotName);

				Map<String, List<String>> extension = new HashMap<>();

				// set extension value(s)
				List<String> values = new LinkedList<>();
				var iter = slot.getValueList().getValue().iterator();
				while (iter.hasNext()) {
					values.add(iter.next());
				}

				// set extension name
				extension.put(slotName, values);

				docEntry.setExtraMetadata(extension);
			}
		}
	}

}
