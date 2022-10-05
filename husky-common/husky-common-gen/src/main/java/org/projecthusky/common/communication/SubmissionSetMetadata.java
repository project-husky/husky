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
package org.projecthusky.common.communication;

import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

import org.projecthusky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.projecthusky.common.hl7cdar2.TEL;
import org.projecthusky.common.model.Author;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.utils.XdsMetadataUtil;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.SubmissionSet;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp.Precision;

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
		 * <table>
		 * <caption>Submission set attributes generation</caption>
		 * <thead>
		 * <tr>
		 * <th>Submission set attribute</th>
		 * <th>Generated from</th>
		 * </tr>
		 * </thead><tbody>
		 * <tr>
		 * <td>uniqueId</td>
		 * <td>the husky OID as base and a random part</td>
		 * </tr>
		 * <tr>
		 * <td>sourceId</td>
		 * <td>DocumentEntry/Patient/AssigningAuthorityUniversalId or (if empty)
		 * from the husky OID as base and a random part</td>
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
	private final POCDMT000040ClinicalDocument cda;
	private SubmissionSet s;

	/**
	 * Standard Constructor.
	 */
	public SubmissionSetMetadata() {
		s = new SubmissionSet();
		cda = new POCDMT000040ClinicalDocument();
	}

	/**
	 * Constructor with IPF SubmissionSet object.
	 *
	 * @param submissionSet the IPF submission set object
	 */
	public SubmissionSetMetadata(SubmissionSet submissionSet) {
		this.s = submissionSet;
		cda = new POCDMT000040ClinicalDocument();
	}

	/**
	 * Gets the Author of this Submission
	 *
	 * @return the Author as Convenience API Object
	 */
	public List<Author> getAuthor() {
		List<Author> authors = new LinkedList<>();
		
		for (org.openehealth.ipf.commons.ihe.xds.core.metadata.Author author : s.getAuthors()) {
			if(author != null) {
				authors.add(XdsMetadataUtil.convertIpfAuthor(author));
			}
		}
		return authors;
	}

	/**
	 * Gets the mdht author type .
	 *
	 * @return the mdht author type.
	 */
	public List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Author> getAuthorTypeMdht() {
		return s.getAuthors();
	}

	/**
	 * Gets the Availability Status of the Document
	 *
	 * @return status the AvailabilityStatus
	 */
	public AvailabilityStatus getAvailabilityStatus() {
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
		return s.getEntryUuid();
	}

	/**
	 * Gets the IPF SubmissionSet Object, which is wrapped by this class.
	 *
	 * @return the IPF SubmissionSet Object
	 */
	public SubmissionSet getIpfSubmissionSet() {
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
	 * Sets the Author of this submission.
	 *
	 * This method is deprecated, since the author role is not encoded as II serialization and only sets the
	 * name of the role. E.g. "Heathcare professional" instead of "HCP^^^&amp;2.16.756.5.30.1.127.3.10.6&amp;ISO",
	 * which is required for the Swiss EPR.
	 *
	 * @param author the Author
	 */
	@Deprecated
	public void setAuthor(Author author) {
		// Workaround for a Bug in the CDAR2Extractor, which causes a
		// NullpointerException, if no Telecom value is inserted and
		// logger.Debug is set to true
		if (author.getAuthorMdht().getAssignedAuthor().getTelecom().isEmpty()) {
			final var tel = new TEL();
			author.getAuthorMdht().getAssignedAuthor().getTelecom().add(tel);
		}

		cda.getAuthor().clear();
		cda.getAuthor().add(author.getAuthorMdht());
		final var extractor = new CDAR2Extractor(cda);
		final org.openehealth.ipf.commons.ihe.xds.core.metadata.Author xAuthor = extractor.extractAuthors().get(0);

		// Set the extracted author person object
		s.setAuthor(xAuthor);
	}

	/**
	 * add an author object to the SubmissionSetMetadata object. In constrast to the method above, it uses
	 * the same metadata extractor used in the DocumentMetadata
	 *
	 * @param author
	 */
	public void addAuthor(Author author){
		s.setAuthor(XdsMetadataUtil.converteHCAuthor(author));
	}

	/**
	 * Sets the Availability Status of the Document
	 *
	 * @param status
	 *            the AvailabilityStatus
	 */
	public void setAvailabilityStatus(AvailabilityStatus status) {
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
		s.setContentTypeCode(XdsMetadataUtil.convertEhcCodeToCode(code));
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
		s.setEntryUuid(entryUuid);
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
	 * Fills a given IPF SubmissionSetType object with the data of this submission
	 * set class
	 *
	 * @param ohtSubmissionSetType the SubmissionSetType
	 * @return the filled ohtSubmissionSetType
	 */
	public SubmissionSet toOhtSubmissionSetType(SubmissionSet ohtSubmissionSetType) {
		if (s.getAuthors() != null && !s.getAuthors().isEmpty()) {
			ohtSubmissionSetType.getAuthors().addAll(s.getAuthors());
		}

		if (s.getAvailabilityStatus() != null) {
			ohtSubmissionSetType.setAvailabilityStatus(s.getAvailabilityStatus());
		}

		if (s.getComments() != null) {
			ohtSubmissionSetType.setComments(s.getComments());
		}

		if (s.getContentTypeCode() != null) {
			ohtSubmissionSetType.setContentTypeCode(s.getContentTypeCode());
		}

		if (s.getPatientId() != null) {
			ohtSubmissionSetType.setPatientId(s.getPatientId());
		}

		if (s.getSourceId() != null) {
			ohtSubmissionSetType.setSourceId(s.getSourceId());
		}

		if (s.getTitle() != null) {
			ohtSubmissionSetType.setTitle(s.getTitle());
		}

		if (s.getUniqueId() != null) {
			ohtSubmissionSetType.setUniqueId(s.getUniqueId());
		}

		if (s.getIntendedRecipients() != null && !s.getIntendedRecipients().isEmpty()) {
			ohtSubmissionSetType.getIntendedRecipients().clear();
			ohtSubmissionSetType.getIntendedRecipients().addAll(s.getIntendedRecipients());
		}

		if (ohtSubmissionSetType.getSubmissionTime() == null) {
			ohtSubmissionSetType.setSubmissionTime(new Timestamp(ZonedDateTime.now(), Precision.SECOND));
		}

		if (ohtSubmissionSetType.getUniqueId() == null) {
			ohtSubmissionSetType.assignUniqueId();
		}

		if (ohtSubmissionSetType.getEntryUuid() == null) {
			ohtSubmissionSetType.assignEntryUuid();
		}

		return ohtSubmissionSetType;
	}
}
