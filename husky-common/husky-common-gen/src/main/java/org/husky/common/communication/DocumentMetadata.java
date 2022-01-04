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
package org.husky.common.communication;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.husky.common.enums.ConfidentialityCode;
import org.husky.common.enums.DocumentDescriptor;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.common.model.Author;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.model.Patient;
import org.husky.common.utils.XdsMetadataUtil;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;


/**
 * Provides metadata attributes as specified in [IHE ITI TF-3], Table 4.1-5:
 * Document Metadata
 */
public class DocumentMetadata {

	/**
	 * The Class MetadataExtractionMode
	 *
	 */
	public enum DocumentMetadataExtractionMode {
		/**
		 * <div class="en">Minimal (secure) metadata will be extracted if set to
		 * default, metadata for the document entries will be extracted as far
		 * as this is possible. if set to false the user of this API has to set
		 * all data by himself. Extraction from CDA Documents to Document
		 * Entries uses the following mapping (for more details see
		 * CDAR2Extractor.pdf in
		 * org.openhealthtools.ihe.xds.metadata.extract.cdar2):
		 * <table>
		 * <caption>CDA Metadata to XDS Metadata mapping</caption>
		 * <thead>
		 * <tr>
		 * <th>XDS Metadata Attribute</th>
		 * <th>XDS Element</th>
		 * </tr>
		 * </thead> <tbody>
		 * <tr>
		 * <td>creationTime</td>
		 * <td>ClinicalDocument/effectiveTime</td>
		 * </tr>
		 * <tr>
		 * <td>languageCode</td>
		 * <td>ClinicalDocument/languageCode/@code</td>
		 * </tr>
		 * <tr>
		 * <td>legalAuthenticator</td>
		 * <td>ClinicalDocument/legalAuthenticator/assignedEntity/id and
		 * ClinicalDocument
		 * /legalAuthenticator/assignedEntity/assignedPerson/name</td>
		 * </tr>
		 * <tr>
		 * <td>serviceStartTime</td>
		 * <td>ClinicalDocument/documentationOf/serviceEvent/effectiveTime This
		 * time is to be in UTC, but without the timezone offset or fractional
		 * seconds: [[[[[YYYY]MM]DD]HH]mm]ss].</td>
		 * </tr>
		 * <tr>
		 * <td>serviceStopTime</td>
		 * <td>ClinicalDocument/documentationOf/serviceEvent/effectiveTime This
		 * time is to be in UTC, but without the timezone offset or fractional
		 * seconds: [[[[[YYYY]MM]DD]HH]mm]ss]</td>
		 * </tr>
		 * <tr>
		 * <td>sourcePatientId</td>
		 * <td>ClinicalDocument/recordTarget/patientRole/id</td>
		 * </tr>
		 * <tr>
		 * <td>sourcePatientInfo</td>
		 * <td>ClinicalDocument/recordTarget/patientRole</td>
		 * </tr>
		 * <tr>
		 * <td>title</td>
		 * <td>ClinicalDocument/title</td>
		 * </tr>
		 * <tr>
		 * <td>uniqueId</td>
		 * <td>ClinicalDocument/id@extension and ClinicalDocument/id@root</td>
		 * </tr>
		 * </tbody>
		 * </table>
		 *
		 * <br>
		 * The following attributes will be generated as described, if they are
		 * not present in the document entries:
		 *
		 * <table>
		 * <caption>Empty document entries attributes generation</caption>
		 * <thead>
		 * <tr>
		 * <th>XDS Metadata Attribute</th>
		 * <th>Generated from</th>
		 * </tr>
		 * </thead> <tbody>
		 * <tr>
		 * <td>mimeType</td>
		 * <td>the DocumentDescriptor, which has been provided by adding the
		 * document</td>
		 * </tr>
		 * <tr>
		 * <td>creationTime</td>
		 * <td>current time</td>
		 * </tr>
		 * <tr>
		 * <td>uniqueId</td>
		 * <td>the docSourceActorOrgId attribute from the DocumentMetadata</td>
		 * </tr>
		 * </tbody>
		 * </table>
		 * <br>
		 * </div>
		 */
		DEFAULT_EXTRACTION,

		/**
		 * <div class="en">No metadata will be extracted, automatically</div>
		 */
		NO_METADATA_EXTRACTION
	}

	/** The x doc. */
	private DocumentEntry xDoc;

	/** The CDA document. */
	private final POCDMT000040ClinicalDocument cda;

	/**
	 * <div class="en">The document descriptor</div>
	 */
	private DocumentDescriptor documentDescriptor;

	/**
	 * <div class="en">The document source actors organization id</div>
	 */
	private String docSourceActorOrgId;

	/** The language of the meta data. */
	private String language;

	/**
	 * Instantiates a new document metadata.
	 */
	public DocumentMetadata() {
		xDoc = new DocumentEntry();
		cda = new POCDMT000040ClinicalDocument();
	}

	/**
	 * Instantiates a new document metadata.
	 *
	 * @param documentEntryType
	 *            the document entry type
	 */
	public DocumentMetadata(DocumentEntry documentEntryType) {
		this();
		xDoc = documentEntryType;
	}

	/**
	 * Instantiates a new document meta data.
	 *
	 * @param language
	 *            language of the meta data
	 */
	public DocumentMetadata(String language) {
		this();
		this.language = language;
	}

	/**
	 * Adds an (optional) author element. All information relevant for the XDS
	 * Document Metadata will be extracted from the Convenience API Author.
	 *
	 */
	public void addAuthor() {
		final var extractor = new CDAR2Extractor(cda);
		final var xAuthor = extractor.extractAuthors().get(0);
		xDoc.getAuthors().add(xAuthor);
	}

	/**
	 * Adds an (optional) author element. All information relevant for the XDS
	 * Document Metadata will be extracted from the Convenience API Author.
	 *
	 */
	public void addAuthor(Author author) {
		xDoc.getAuthors().add(XdsMetadataUtil.converteHCAuthor(author));
	}

	/**
	 * Adds the (optional) confidentialityCode code (e.g. 'N' for 'normal')
	 *
	 * @param code
	 *            the code
	 */
	public void addConfidentialityCode(Code code) {
		xDoc.getConfidentialityCodes().add(XdsMetadataUtil.convertEhcCodeToCode(code));
	}

	/**
	 * Adds the (optional) confidentialityCode code (e.g. 'N' for 'normal')
	 *
	 * @param code
	 *            the code
	 */
	public void addConfidentialityCode(ConfidentialityCode code) {
		xDoc.getConfidentialityCodes().add(XdsMetadataUtil
				.createCodedMetadata(
						code.getCodeSystemId(), code.getCodeValue(), code.getDisplayName(), null));
	}

	/**
	 * Clears all the metadata attributes and lists (except the
	 * documentEntyUuid)
	 */
	public void clear() {
		xDoc.setAvailabilityStatus(null);
		xDoc.setClassCode(null);
		xDoc.setComments(null);
		xDoc.setCreationTime("");
		xDoc.setFormatCode(null);
		xDoc.setHash(null);
		xDoc.setLanguageCode(null);
		xDoc.setLegalAuthenticator(null);
		xDoc.setMimeType(null);

		xDoc.setPatientId(null);
		xDoc.setPracticeSettingCode(null);
		xDoc.setRepositoryUniqueId(null);
		xDoc.setServiceStartTime("");
		xDoc.setServiceStopTime("");
		xDoc.setSize(null);
		xDoc.setSourcePatientId(null);
		xDoc.setSourcePatientInfo(null);

		xDoc.setTypeCode(null);
		xDoc.setHealthcareFacilityTypeCode(null);
		xDoc.setTitle(null);
		xDoc.setUniqueId(null);

		xDoc.getAuthors().clear();
		xDoc.getConfidentialityCodes().clear();
		xDoc.getEventCodeList().clear();
		xDoc.getExtraMetadata().clear();
	}

	/**
	 * Clears all (unsafe) automatically extracted metadata attributes and lists
	 */
	public void clearExtracted() {
		xDoc.setAvailabilityStatus(null);
		xDoc.setClassCode(null);
		xDoc.setComments(null);
		xDoc.setFormatCode(null);
		xDoc.setHash(null);
		xDoc.setMimeType(null);
		xDoc.setPatientId(null);
		xDoc.setPracticeSettingCode(null);
		xDoc.setRepositoryUniqueId(null);

		xDoc.getAuthors().clear();
		xDoc.getConfidentialityCodes().clear();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DocumentMetadata)) {
			return false; // different class
		}

		return equals((DocumentMetadata) obj);
	}
    

	public boolean equals(DocumentMetadata other) {
		var retVal = true;

		retVal = compareAuthors(other.getAuthors());

		if (retVal) {
			retVal = compareLanguange(other.language);
		}

		if (retVal) {
			retVal = comparePatientId(other.getPatientId());
		}

		if (retVal) {
			retVal = compareSourcePatientId(other.getSourcePatientId());
		}

		if (retVal) {
			retVal = compareClassCode(other.getClassCode());
		}

		if (retVal) {
			retVal = compareConfidentialityCode(other.getConfidentialityCodes());
		}

		if (retVal) {
			retVal = compareCodedLanguage(other.getCodedLanguage());
		}

		if (retVal) {
			retVal = compareCreationTime(other.getCreationTime());
		}

		if (retVal) {
			retVal = compareFormatCode(other.getFormatCode());
		}

		if (retVal) {
			retVal = compareDocSourceActorOrganizationId(other.getDocSourceActorOrganizationId());
		}

		if (retVal) {
			retVal = compareHealthcareFacilityTypeCode(other.getHealthcareFacilityTypeCode());
		}

		if (retVal) {
			retVal = compareMimeType(other.getMimeType());
		}

		if (retVal) {
			retVal = comparePracticeSettingCode(other.getPracticeSettingCode());
		}

		if (retVal) {
			retVal = compareTitle(other.getTitle());
		}

		if (retVal) {
			retVal = compareTypeCode(other.getTypeCode());
		}

		if (retVal) {
			retVal = compareUniqueId(other.getUniqueId());
		}

		return retVal;
	}

	private boolean compareLanguange(String other) {
		if (this.language == null) {
			if (other != null)
				return false;
		} else if (!this.language.equals(other)) {
			return false;
		}

		return true;
	}

	private boolean compareUniqueId(String other) {
		if (this.getUniqueId() == null) {
			if (other != null)
				return false;
		} else if (!this.getUniqueId().equals(other)) {
			return false;
		}

		return true;
	}

	private boolean compareTypeCode(Code other) {
		if (this.getTypeCode() == null) {
			if (other != null)
				return false;
		} else if (!this.getTypeCode().equals(other)) {
			return false;
		}

		return true;
	}

	private boolean compareTitle(String other) {
		if (this.getTitle() == null) {
			if (other != null)
				return false;
		} else if (!this.getTitle().equals(other)) {
			return false;
		}

		return true;
	}

	private boolean comparePracticeSettingCode(Code other) {
		if (this.getPracticeSettingCode() == null) {
			if (other != null)
				return false;
		} else if (!this.getPracticeSettingCode().equals(other)) {
			return false;
		}

		return true;
	}

	private boolean compareMimeType(String other) {
		if (this.getMimeType() == null) {
			if (other != null)
				return false;
		} else if (!this.getMimeType().equals(other)) {
			return false;
		}

		return true;
	}

	private boolean compareHealthcareFacilityTypeCode(Code other) {
		if (this.getHealthcareFacilityTypeCode() == null) {
			if (other != null)
				return false;
		} else if (!this.getHealthcareFacilityTypeCode().equals(other)) {
			return false;
		}

		return true;
	}

	private boolean compareDocSourceActorOrganizationId(String other) {
		if (this.getDocSourceActorOrganizationId() == null) {
			if (other != null)
				return false;
		} else if (!this.getDocSourceActorOrganizationId().equals(other)) {
			return false;
		}

		return true;
	}

	private boolean compareFormatCode(Code other) {
		if (this.getFormatCode() == null) {
			if (other != null)
				return false;
		} else if (!this.getFormatCode().equals(other)) {
			return false;
		}

		return true;
	}

	private boolean compareCreationTime(ZonedDateTime other) {
		if (this.getCreationTime() == null) {
			if (other != null)
				return false;
		} else if (!this.getCreationTime().equals(other)) {
			return false;
		}

		return true;
	}

	private boolean compareCodedLanguage(String other) {
		if (this.getCodedLanguage() == null) {
			if (other != null)
				return false;
		} else if (!this.getCodedLanguage().equals(other)) {
			return false;
		}

		return true;
	}

	private boolean compareConfidentialityCode(List<Code> other) {
		if (this.getConfidentialityCodes() == null) {
			if (other != null)
				return false;
		} else if (!this.getConfidentialityCodes().equals(other)) {
			return false;
		}

		return true;
	}

	private boolean compareClassCode(Code other) {
		if (this.getClassCode() == null) {
			if (other != null)
				return false;
		} else if (!this.getClassCode().equals(other)) {
			return false;
		}

		return true;
	}

	private boolean compareSourcePatientId(Identificator other) {
		if (this.getSourcePatientId() == null) {
			if (other != null)
				return false;
		} else if (!this.getSourcePatientId().equals(other)) {
			return false;
		}

		return true;
	}

	private boolean comparePatientId(Identificator other) {
		if (this.getPatientId() == null) {
			if (other != null)
				return false;
		} else if (!this.getPatientId().equals(other)) {
			return false;
		}

		return true;
	}

	private boolean compareAuthors(List<Author> authors) {
		if (this.getAuthors() == null) {
			if (authors != null)
				return false;
		} else if (this.getAuthors().size() != authors.size()) {
			return false;
		}

		return true;
	}

	/**
	 * Returns an (optional) author element. All information contained in the
	 * XDS Document Metadata will be extracted to the Convenience API Author.
	 *
	 * @return ArrayList with Author objects
	 */
	public List<Author> getAuthors() {
		final List<Author> authorList = new ArrayList<>();

		for (org.openehealth.ipf.commons.ihe.xds.core.metadata.Author at : xDoc.getAuthors()) {
			authorList.add(XdsMetadataUtil.convertIpfAuthor(at));
		}
		return authorList;
	}

	/**
	 *
	 * Method to get the AvailabilityStatus
	 *
	 * @return the Availabilitystatus of the document
	 */
	public AvailabilityStatus getAvailabilityStatus() {
		return xDoc.getAvailabilityStatus();
	}

	/**
	 * Gets the classCode
	 *
	 * @return Code element with classCode
	 */
	public Code getClassCode() {
		return XdsMetadataUtil.convertOhtCodedMetadataType(xDoc.getClassCode());
	}

	/**
	 * Gets the codedLanguage
	 *
	 * @return codedLanguage as String
	 */
	public String getCodedLanguage() {
		return xDoc.getLanguageCode();
	}

	public String getComments() {
		return XdsMetadataUtil.convertInternationalStringType(xDoc.getComments());
	}

	/**
	 * Gets the confidentialityCode list
	 *
	 * @return the ArrayList with ConfidentialityCodes
	 */
	public List<Code> getConfidentialityCodes() {
		final List<Code> confCodes = new ArrayList<>();

		if (!xDoc.getConfidentialityCodes().isEmpty()) {
			for (org.openehealth.ipf.commons.ihe.xds.core.metadata.Code code : xDoc.getConfidentialityCodes()) {
				confCodes.add(XdsMetadataUtil.convertOhtCodedMetadataType(code));
			}
		} else {
			return new LinkedList<>();
		}
		return confCodes;
	}

	/**
	 * Gets the creationTime
	 *
	 * @return creationTime as Date
	 */
	public ZonedDateTime getCreationTime() {
		return xDoc.getCreationTime().getDateTime();
	}

	/**
	 * Gets the document source actors organization id
	 *
	 * @return the document source actors organization id
	 */
	public String getDocSourceActorOrganizationId() {
		return docSourceActorOrgId;
	}

	/**
	 * Gets the document descriptor of the document
	 *
	 * @return the document descriptor of the document
	 */
	public DocumentDescriptor getDocumentDescriptor() {
		return documentDescriptor;
	}

	/**
	 * Gets the EntryUUID
	 *
	 * @return the EntryUUID
	 */
	public String getEntryUUID() {
		return xDoc.getEntryUuid();
	}

	/**
	 * Gets the formatCode
	 *
	 * @return formatCode as Code
	 */
	public Code getFormatCode() {
		return XdsMetadataUtil.convertOhtCodedMetadataType(xDoc.getFormatCode());
	}

	/**
	 * Gets the healthcareFacilityTypeCode
	 *
	 * @return healthcareFacilityTypeCode as Code
	 */
	public Code getHealthcareFacilityTypeCode() {
		return XdsMetadataUtil.convertOhtCodedMetadataType(xDoc.getHealthcareFacilityTypeCode());
	}

	/**
	 * Gets the mdht document entry type.
	 *
	 * @return the mdht document entry type
	 */
	public DocumentEntry getDocumentEntry() {
		return xDoc;
	}

	/**
	 * Gets the meta data language
	 *
	 * @return the meta data language
	 */
	public String getMetadataLanguage() {
		return language;
	}

	/**
	 * Gets the mimeType
	 *
	 * @return mimeType as String
	 */
	public String getMimeType() {
		return xDoc.getMimeType();
	}

	/**
	 * Gets the patient. All information from the XDS Document Metadata will be
	 * extracted to the Convenience API Patient object.
	 *
	 * @return patient
	 */
	public Patient getPatient() {
		return XdsMetadataUtil.convertOhtSourcePatientInfoType(xDoc.getSourcePatientInfo());
	}

	/**
	 * Gets the patient id.
	 *
	 * @return patientId as Identificator
	 */
	public Identificator getPatientId() {
		return XdsMetadataUtil.convertOhtCx(xDoc.getPatientId());
	}

	/**
	 * Gets the practice setting code. This is the medical speciality of the
	 * practice where the document was produced (e.g. Code for "General
	 * Medicine")
	 *
	 * @return the practiceSettingCode as Code
	 */
	public Code getPracticeSettingCode() {
		return XdsMetadataUtil.convertOhtCodedMetadataType(xDoc.getPracticeSettingCode());
	}

	/**
	 * Gets the source patient id. This is the local patient id, e.g. inside a
	 * hospital.
	 *
	 * @return the sourcePatientId as Identificator
	 */
	public Identificator getSourcePatientId() {
		if (xDoc.getSourcePatientId() != null) {
			return XdsMetadataUtil.convertOhtCx(xDoc.getSourcePatientId());
		} else {
			return null;
		}
	}

	/**
	 * Gets the title.
	 *
	 * @return the title as String
	 */
	public String getTitle() {
		return XdsMetadataUtil.convertInternationalStringType(xDoc.getTitle());
	}

	/**
	 * Gets the typeCode. Specifies the type of the document (like the class
	 * code, but more specific) (e.g. Code for "Summarization of Episode Note")
	 *
	 * @return the typeCode as Code
	 */
	public Code getTypeCode() {
		return XdsMetadataUtil.convertOhtCodedMetadataType(xDoc.getTypeCode());
	}

	/**
	 * Gets the unique id. The UUID of the document.
	 *
	 * @return the uniqueId
	 */
	public String getUniqueId() {
		return xDoc.getUniqueId();
	}

	/**
	 * Gets the uri of the document.
	 *
	 * @return the uri
	 */
	public String getUri() {
		return xDoc.getUri();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final var prime = 31;
		var result = 1;
		if (this.xDoc == null)
			return prime;
		result = result + getAuthors().hashCode();
		result = result + getPatientId().hashCode();
		result = result + getSourcePatientId().hashCode();
		result = result + getClassCode().hashCode();
		result = result + getConfidentialityCodes().hashCode();
		result = result + getCodedLanguage().hashCode();
		result = result + getCreationTime().hashCode();
		result = result + getFormatCode().hashCode();
		result = result + getDocSourceActorOrganizationId().hashCode();
		result = result + getHealthcareFacilityTypeCode().hashCode();
		result = result + getMimeType().hashCode();
		result = result + getPracticeSettingCode().hashCode();
		result = result + getTitle().hashCode();
		result = result + getTypeCode().hashCode();
		result = result + getUniqueId().hashCode();
		result = result * prime;
		return result;
	}

	/**
	 *
	 * Method to set the AvailabilityStatusType;
	 *
	 * @param availabilityStatus
	 *            the availability status to set
	 */
	public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
		xDoc.setAvailabilityStatus(availabilityStatus);
	}

	/**
	 * Sets the (required, but in principle computable) class code, which
	 * defines the class of the document (e.g. Code for "Consultation")
	 *
	 * @param code
	 *            the new class code
	 */
	public void setClassCode(Code code) {
		xDoc.setClassCode(XdsMetadataUtil.convertEhcCodeToIpfCode(code, language));
	}

	/**
	 * Sets the (required) coded language (e.g. "de-CH"). This code can be
	 * extracted from CDA Documents, automatically.
	 *
	 * @param codedLanguage
	 *            the new language code
	 */
	public void setCodedLanguage(String codedLanguage) {
		xDoc.setLanguageCode(codedLanguage);
	}

	/**
	 * Sets the (required) creation time of the document. If not set, the
	 * current time will be used.
	 *
	 * @param dateAndTime
	 *            the new creation time
	 */
	public void setCreationTime(ZonedDateTime dateAndTime) {
		xDoc.setCreationTime(
				dateAndTime.format(
						DateTimeFormatter.ofPattern("yyyyMMddHHmmssZ").withZone(ZoneId.systemDefault())));
	}

	/**
	 * Sets the (required) destination patient id, which is used in the affinity
	 * domain (typically retrieved from a Master Patient Index (MPI))
	 *
	 * @param id
	 *            the new patient id
	 */
	public void setDestinationPatientId(Identificator id) {
		xDoc.setPatientId(XdsMetadataUtil.convertEhcIdentificator(id));
	}

	/**
	 * Sets the document source actors organization id
	 *
	 * @param docSourceActorOrgId
	 *            the document source actors organization id
	 */
	public void setDocSourceActorOrganizationId(String docSourceActorOrgId) {
		this.docSourceActorOrgId = docSourceActorOrgId;
	}

	/**
	 * Sets the document descriptor of the document
	 *
	 * @param documentDescriptor
	 *            the document descriptor of the document
	 */
	public void setDocumentDescriptor(DocumentDescriptor documentDescriptor) {
		this.documentDescriptor = documentDescriptor;
	}

	/**
	 * Sets the entry uuid.
	 *
	 * @param entryUuid
	 *            the uuid to be set
	 */
	public void setEntryUUID(String entryUuid) {
		xDoc.setEntryUuid(entryUuid);
	}

	/**
	 * Sets the (required) format code. If not set, the system will try to
	 * derive it from the Document MimeType.
	 *
	 * @param code
	 *            the new format code
	 */
	public void setFormatCode(Code code) {
		xDoc.setFormatCode(XdsMetadataUtil.convertEhcCodeToIpfCode(code, language));
	}

	/**
	 * Sets the (required) healthcare facility type code (e.g. Code for
	 * "Hospital")
	 *
	 * @param code
	 *            the new healthcare facility type code
	 */
	public void setHealthcareFacilityTypeCode(Code code) {
		xDoc.setHealthcareFacilityTypeCode(
				XdsMetadataUtil.convertEhcCodeToIpfCode(code, language));
	}

	public void setMetadata(DocumentMetadata metaData) {
		clear();
		for (final org.husky.common.model.Author item : metaData.getAuthors()) {
			addAuthor(item);
		}

		for (final Code item : metaData.getConfidentialityCodes()) {
			addConfidentialityCode(item);
		}

		setClassCode(metaData.getClassCode());
		setCodedLanguage(metaData.getCodedLanguage());
		setCreationTime(metaData.getCreationTime());
		setDocumentDescriptor(metaData.getDocumentDescriptor());
		setDocSourceActorOrganizationId(metaData.getDocSourceActorOrganizationId());
		setFormatCode(metaData.getFormatCode());
		setHealthcareFacilityTypeCode(metaData.getHealthcareFacilityTypeCode());
		setMetadataLanguage(metaData.getMetadataLanguage());
		setMimeType(metaData.getMimeType());
		setPatient(metaData.getPatient());
		setPracticeSettingCode(metaData.getPracticeSettingCode());
		setTitle(metaData.getTitle());
		setTypeCode(metaData.getTypeCode());
		setUniqueId(metaData.getUniqueId());
		setUri(metaData.getUri());

		// Overwrite defaults done by setPatient:
		setSourcePatientId(metaData.getSourcePatientId());
		setDestinationPatientId(metaData.getPatientId());

	}

	/**
	 * Sets the language of the document meta data
	 *
	 * @param language
	 *            the language
	 */
	public void setMetadataLanguage(String language) {
		this.language = language;
	}

	/**
	 * Sets the (required) mime type (e.g. "text/xml")
	 *
	 * @param mimeType
	 *            the new mime type
	 */
	public void setMimeType(String mimeType) {
		xDoc.setMimeType(mimeType);
	}

	/**
	 * Sets the (required) patient. All information relevant for the XDS
	 * Document Metadata will be extracted from the Convencience API Patient.
	 *
	 * @param patient
	 *            the new patient
	 */
	public void setPatient(Patient patient) {
		cda.getRecordTarget().add(patient.getMdhtRecordTarget());

		// Source Patient Info (Adress etc.)
		final var extractor = new CDAR2Extractor(cda);
		final var spi = extractor.extractSourcePatientInfo();
		xDoc.setSourcePatientInfo(spi);

		// PatientID
		if (patient.getIds() != null && !patient.getIds().isEmpty()) {
			setDestinationPatientId(patient.getIds().get(0));
		}
	}

	/**
	 * Sets the (required) practice setting code. This is the medical speciality
	 * of the practice where the document was produced (e.g. Code for "General
	 * Medicine")
	 *
	 * @param code
	 *            the new practice setting code
	 */
	public void setPracticeSettingCode(Code code) {
		xDoc.setPracticeSettingCode(
				XdsMetadataUtil.convertEhcCodeToIpfCode(code, language));
	}

	/**
	 * Sets the (required) source patient id. This is the local patient id, e.g.
	 * inside a hospital.
	 *
	 * @param id
	 *            the new source patient id
	 */
	public void setSourcePatientId(Identificator id) {
		xDoc.setSourcePatientId(XdsMetadataUtil.convertEhcIdentificator(id));
	}

	/**
	 * Sets the (optional) title.
	 *
	 * @param title
	 *            the title object to set
	 */
	public void setTitle(String title) {
		xDoc.setTitle(XdsMetadataUtil.createInternationalString(title, language));
	}

	/**
	 * Sets the (required) type code. Specifies the type of the document (like
	 * the class code, but more specific) (e.g. Code for "Summarization of
	 * Episode Note")
	 *
	 * @param code
	 *            the new type code
	 */
	public void setTypeCode(Code code) {
		xDoc.setTypeCode(XdsMetadataUtil.convertEhcCodeToIpfCode(code, language));
	}

	/**
	 * Sets the unique id. The UUID of the document. Will be generated, when the
	 * instance of class is retrieved from
	 * ConvenienceCommunication.addDocument()
	 *
	 * @param id
	 *            the new unique id
	 */
	public void setUniqueId(String id) {
		xDoc.setUniqueId(id);
	}

	/**
	 * Sets the uri of the document.
	 *
	 * @param uri
	 *            the new unique id
	 */
	public void setUri(String uri) {
		xDoc.setUri(uri);
	}

}
