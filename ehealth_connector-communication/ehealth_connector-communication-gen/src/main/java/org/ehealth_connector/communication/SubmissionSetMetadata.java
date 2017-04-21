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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.EHealthConnectorVersions;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.openhealthtools.ihe.utils.OID;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;
import org.openhealthtools.ihe.xds.metadata.SubmissionSetType;
import org.openhealthtools.ihe.xds.metadata.extract.cdar2.CDAR2Extractor;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;

/**
 * Represents the metadata for a submission set (which can hold one or more
 * documents)
 */
public class SubmissionSetMetadata {

	/**
	 * The Class MetadataExtractionMode
	 */
	public enum SubmissionSetMetadataExtractionMode {
		/**
		 * <div class="en">Minimal (secure) metadata will be extracted *
		 * Extraction from the first Document Entry to the Submission Set uses
		 * the following mapping:
		 *
		 * <table summary="Submission set attributes generation">
		 * <thead>
		 * <tr>
		 * <th>Submission set attribute</th>
		 * <th>Generated from</th>
		 * </tr>
		 * </thead><tbody>
		 * <tr>
		 * <td>uniqueId</td>
		 * <td>the eHealthConnector OID as base and a random part</td>
		 * </tr>
		 * <tr>
		 * <td>sourceId</td>
		 * <td>DocumentEntry/Patient/AssigningAuthorityUniversalId or (if empty)
		 * from the eHealthConnector OID as base and a random part</td>
		 * </tr>
		 * <tr>
		 * <td>submissionTime</td>
		 * <td>current time</td>
		 * </tr>
		 * <tr>
		 * <td>patientId</td>
		 * <td>DocumentEntry/PatientId</td>
		 * </tr>
		 * <tr>
		 * <td>contentTypeCode</td>
		 * <td>DocumentEntry/TypeCode</td>
		 * </tr>
		 * </tbody>
		 * </table>
		 * </div>
		 */
		DEFAULT_EXTRACTION,

		/**
		 * <div class="en">No metadata will be extracted, automatically</div>
		 */
		NO_METADATA_EXTRACTION
	}

	/** The cda. */
	private final ClinicalDocument cda;
	private SubmissionSetType s;

	/**
	 * Standard Constructor.
	 */
	public SubmissionSetMetadata() {
		s = MetadataFactory.eINSTANCE.createSubmissionSetType();
		cda = CDAFactory.eINSTANCE.createClinicalDocument();
	}

	/**
	 * Constructor with OHT SubmissionSet object.
	 *
	 * @param ohtSubmissionSet
	 *            the OHT submission set object
	 */
	public SubmissionSetMetadata(SubmissionSetType ohtSubmissionSet) {
		this.s = ohtSubmissionSet;
		cda = CDAFactory.eINSTANCE.createClinicalDocument();
	}

	/**
	 * Gets the Author of this Submission
	 *
	 * @return the Author as Convenience API Object
	 */
	public Author getAuthor() {
		return XdsMetadataUtil.convertOhtAuthorType(s.getAuthor());
	}

	/**
	 * Gets the Availability Status of the Document
	 *
	 * @return status the AvailabilityStatus
	 */
	public AvailabilityStatusType getAvailabilityStatus() {
		return s.getAvailabilityStatus();
	}

	/**
	 * Gets comments for this submission
	 *
	 * @return comments the comments
	 */
	public String getComments() {
		return XdsMetadataUtil.convertInternationalStringType(s.getComments());
	}

	/**
	 * Gets the contentTypeCode, which defines the type of the submission set
	 * content
	 *
	 * @return code the contentTypeCode
	 */
	public Code getContentTypeCode() {
		return XdsMetadataUtil.convertOhtCodedMetadataType(s.getContentTypeCode());
	}

	/**
	 * Gets the EntryUUID
	 *
	 * @return the EntryUUID
	 */
	public String getEntryUUID() {
		return s.getEntryUUID();
	}

	/**
	 * Gets the OHT SubmissionSet Object, which is wrapped by this class.
	 *
	 * @return the OHT SubmissionSet Object
	 */
	public SubmissionSetType getOhtSubmissionSetType() {
		return s;
	}

	/**
	 * Gets the ID of the patient
	 *
	 * @return id the patientId
	 */
	public Identificator getPatientId() {
		return XdsMetadataUtil.convertOhtCx(s.getPatientId());
	}

	/**
	 * Gets the ID of the sending facility (e.g. a hospital id)
	 *
	 * @return id the SourceId
	 */
	public String getSourceId() {
		return s.getSourceId();
	}

	/**
	 * Gets the title of the submission set
	 *
	 * @return the title
	 */
	public String getTitle() {
		return XdsMetadataUtil.convertInternationalStringType(s.getTitle());
	}

	/**
	 *
	 * Gets the uniqueid of the submission set
	 *
	 * @return hte unique id
	 */
	public String getUniqueId() {
		return s.getUniqueId();
	}

	/**
	 * Sets the Author of this submission
	 *
	 * @param author
	 *            the Author
	 */
	public void setAuthor(Author author) {
		// Workaround for a Bug in the CDAR2Extractor, which causes a
		// NullpointerException, if no Telecom value is inserted and
		// logger.Debug is set to true
		if ((author.getAuthorMdht().getAssignedAuthor().getTelecoms() == null)
				|| author.getAuthorMdht().getAssignedAuthor().getTelecoms().isEmpty()) {
			final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
			author.getAuthorMdht().getAssignedAuthor().getTelecoms().add(tel);
		}

		cda.getAuthors().clear();
		cda.getAuthors().add(author.copyMdhtAuthor());
		final CDAR2Extractor extractor = new CDAR2Extractor(cda);
		final AuthorType xAuthor = extractor.extractAuthors().get(0);

		// Set the extracted author person object
		s.setAuthor(xAuthor);
	}

	/**
	 * Sets the Availability Status of the Document
	 *
	 * @param status
	 *            the AvailabilityStatus
	 */
	public void setAvailabilityStatus(AvailabilityStatusType status) {
		s.setAvailabilityStatus(status);
	}

	/**
	 * Sets comments for this submission
	 *
	 * @param comments
	 *            the comments
	 */
	public void setComments(String comments) {
		s.setComments(XdsMetadataUtil.createInternationalString(comments));
	}

	/**
	 * Sets the contentTypeCode, which defines the type of the submission set
	 * content
	 *
	 * @param code
	 *            the contentTypeCode
	 */
	public void setContentTypeCode(Code code) {
		s.setContentTypeCode(XdsMetadataUtil.convertEhcCodeToCodedMetadataType(code));
	}

	/**
	 * Sets the ID for the patient in the destination
	 *
	 * @param id
	 *            the patientId
	 */
	public void setDestinationPatientId(Identificator id) {
		s.setPatientId(XdsMetadataUtil.convertEhcIdentificator(id));
	}

	/**
	 * Sets the entry uuid.
	 *
	 * @param entryUuid
	 *            the uuid to be set
	 */
	public void setEntryUUID(String entryUuid) {
		s.setEntryUUID(entryUuid);
	}

	/**
	 * Sets the ID of the sending facility (e.g. a hospital id)
	 *
	 * @param id
	 *            the SourceId
	 */
	public void setSourceId(String id) {
		s.setSourceId(id);
	}

	/**
	 * Sets the title of the submission set
	 *
	 * @param title
	 *            the title
	 */
	public void setTitle(String title) {
		s.setTitle(XdsMetadataUtil.createInternationalString(title));
	}

	/**
	 * Sets the unique id.
	 *
	 * @param uniqueyId
	 *            the unique id to be set
	 */
	public void setUniqueId(String uniqueyId) {
		s.setUniqueId(uniqueyId);
	}

	/**
	 * Fills a given OHT SubmissionSetType object with the data of this
	 * submission set class
	 *
	 * @param ohtSubmissionSetType
	 *            the SubmissionSetType
	 * @return the filled ohtSubmissionSetType
	 */
	@SuppressWarnings("unchecked")
	public SubmissionSetType toOhtSubmissionSetType(SubmissionSetType ohtSubmissionSetType) {
		ohtSubmissionSetType.setAuthor(EcoreUtil.copy(s.getAuthor()));
		ohtSubmissionSetType.setAvailabilityStatus(s.getAvailabilityStatus());
		ohtSubmissionSetType.setComments(EcoreUtil.copy(s.getComments()));
		ohtSubmissionSetType.setContentTypeCode(EcoreUtil.copy(s.getContentTypeCode()));
		ohtSubmissionSetType.setPatientId(s.getPatientId());
		ohtSubmissionSetType.setSourceId(s.getSourceId());
		ohtSubmissionSetType.setTitle(EcoreUtil.copy(s.getTitle()));
		ohtSubmissionSetType.setUniqueId(s.getUniqueId());
		ohtSubmissionSetType.getIntendedRecipient().clear();
		ohtSubmissionSetType.getIntendedRecipient().addAll(s.getIntendedRecipient());
		if (ohtSubmissionSetType.getSubmissionTime() == null) {
			ohtSubmissionSetType.setSubmissionTime(DateUtil.nowAsTS().getValue());
		}
		if ((ohtSubmissionSetType.getUniqueId() == null)
				|| (ohtSubmissionSetType.getSourceId() == null)) {

			// This is the eHealth Connector Root OID
			// default value just in case...
			final String organizationalId = EHealthConnectorVersions.getCurrentVersion().getOid();

			if (ohtSubmissionSetType.getUniqueId() == null) {
				ohtSubmissionSetType.setUniqueId(OID.createOIDGivenRoot(organizationalId, 64));
			}
		}
		return ohtSubmissionSetType;
	}
}
