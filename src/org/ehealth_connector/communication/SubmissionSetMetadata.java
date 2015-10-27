package org.ehealth_connector.communication;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.XdsUtil;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
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
		 * <table summary="Submission set attributes generation" width="100%">
		 * <thead>
		 * <tr>
		 * <th width="20%">Submission set attribute</th>
		 * <th width="80%">Generated from</th>
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
		return XdsUtil.convertOhtAuthorType(s.getAuthor());
	}

	/**
	 * Gets the Availability Status of the Document
	 *
	 * @return status the AvailabilityStatus
	 */
	public AvailabilityStatus getAvailabilityStatus() {
		return AvailabilityStatus.getByOhtAvailabilityStatusType(s.getAvailabilityStatus());
	}

	/**
	 * Gets comments for this submission
	 *
	 * @return comments the comments
	 */
	public String getComments() {
		return XdsUtil.convertInternationalStringType(s.getComments());
	}

	/**
	 * Gets the contentTypeCode, which defines the type of the submission set
	 * content
	 *
	 * @return code the contentTypeCode
	 */
	public Code getContentTypeCode() {
		return XdsUtil.convertOhtCodedMetadataType(s.getContentTypeCode());
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
		return XdsUtil.convertOhtCx(s.getPatientId());
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
		return XdsUtil.convertInternationalStringType(s.getTitle());
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
		if (author.getAuthorMdht().getAssignedAuthor().getTelecoms() == null
				|| author.getAuthorMdht().getAssignedAuthor().getTelecoms().isEmpty()) {
			TEL tel = DatatypesFactory.eINSTANCE.createTEL();
			author.getAuthorMdht().getAssignedAuthor().getTelecoms().add(tel);
		}

		cda.getAuthors().clear();
		cda.getAuthors().add(author.copyMdhtAuthor());
		CDAR2Extractor extractor = new CDAR2Extractor(cda);
		AuthorType xAuthor = extractor.extractAuthors().get(0);

		// Set the extracted author person object
		s.setAuthor(xAuthor);
	}

	/**
	 * Sets the Availability Status of the Document
	 *
	 * @param status
	 *            the AvailabilityStatus
	 */
	public void setAvailabilityStatus(AvailabilityStatus status) {
		s.setAvailabilityStatus(status.getAsOhtAvailabilityStatusType());
	}

	/**
	 * Sets comments for this submission
	 *
	 * @param comments
	 *            the comments
	 */
	public void setComments(String comments) {
		s.setComments(XdsUtil.createInternationalString(comments));
	}

	/**
	 * Sets the contentTypeCode, which defines the type of the submission set
	 * content
	 *
	 * @param code
	 *            the contentTypeCode
	 */
	public void setContentTypeCode(Code code) {
		s.setContentTypeCode(XdsUtil.convertCode(code));
	}

	/**
	 * Sets the ID for the patient
	 *
	 * @param id
	 *            the patientId
	 */
	public void setPatientId(Identificator id) {
		s.setPatientId(XdsUtil.convertEhcIdentificator(id));
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
		s.setTitle(XdsUtil.createInternationalString(title));
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
		return ohtSubmissionSetType;
	}
}
