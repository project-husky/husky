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
package org.ehealth_connector.communication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.enums.Confidentiality;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.communication.ch.DocumentMetadataCh;
import org.ehealth_connector.util.XdsUtil;
import org.openhealthtools.ihe.common.hl7v2.SourcePatientInfoType;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;
import org.openhealthtools.ihe.xds.metadata.extract.cdar2.CDAR2Extractor;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;

/**
 * Provides metadata attributes as specified in [IHE ITI TF-3], Table 4.1-5:
 * Document Metadata
 * */
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
		 * <table summary="CDA Metadata to XDS Metadata mapping" width="100%">
		 * <thead>
		 * <tr>
		 * <th width="20%">XDS Metadata Attribute</th>
		 * <th width="80%">XDS Element</th>
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
		 * <td>
		 * ClinicalDocument/documentationOf/serviceEvent/effectiveTime This time
		 * is to be in UTC, but without the timezone offset or fractional
		 * seconds: [[[[[YYYY]MM]DD]HH]mm]ss].</td>
		 * </tr>
		 * <tr>
		 * <td>serviceStopTime</td>
		 * <td>
		 * ClinicalDocument/documentationOf/serviceEvent/effectiveTime This time
		 * is to be in UTC, but without the timezone offset or fractional
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
		 * <table summary="Empty document entries attributes generation" width="100%">
		 * <thead>
		 * <tr>
		 * <th width="20%">XDS Metadata Attribute</th>
		 * <th width="80%">Generated from</th>
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
	private DocumentEntryType xDoc;

	/** The CDA document. */
	private final ClinicalDocument cda;

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
		xDoc = MetadataFactory.eINSTANCE.createDocumentEntryType();
		cda = CDAFactory.eINSTANCE.createClinicalDocument();
	}

	/**
	 * Instantiates a new document metadata.
	 * 
	 * @param documentEntryType
	 *            the document entry type
	 */
	public DocumentMetadata(DocumentEntryType documentEntryType) {
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
	 * @param author
	 *            the author
	 */
	@SuppressWarnings("unchecked")
	public void addAuthor(Author author) {
		// Workaround for a Bug in the CDAR2Extractor, which causes a
		// NullpointerException, if no Telecom value is interted and
		// logger.Debug is set to true
		if (author.getAuthorMdht().getAssignedAuthor().getTelecoms() == null
				|| author.getAuthorMdht().getAssignedAuthor().getTelecoms().isEmpty()) {
			TEL tel = DatatypesFactory.eINSTANCE.createTEL();
			author.getAuthorMdht().getAssignedAuthor().getTelecoms().add(tel);
		}
		// There is another bug in the extractAuthorPerson Member. When the
		// author has no id, the authorPerson object is not extracted. No
		// workaround yet.

		cda.getAuthors().add(author.copyMdhtAuthor());

		CDAR2Extractor extractor = new CDAR2Extractor(cda);
		AuthorType xAuthor = extractor.extractAuthors().get(0);
		xDoc.getAuthors().add(xAuthor);
	}

	/**
	 * Adds the (optional) confidentialityCode code (e.g. 'N' for 'normal')
	 * 
	 * @param code
	 *            the code
	 */
	@SuppressWarnings("unchecked")
	public void addConfidentialityCode(Code code) {
		xDoc.getConfidentialityCode().add(
				XdsUtil.createCodedMetadata(code.getCodeSystem(), code.getCode(),
						code.getDisplayName(), null, language));
	}

	/**
	 * Adds the (optional) confidentialityCode code (e.g. 'N' for 'normal')
	 * 
	 * @param code
	 *            the code
	 */
	@SuppressWarnings("unchecked")
	public void addConfidentialityCode(Confidentiality code) {
		xDoc.getConfidentialityCode().add(
				XdsUtil.createCodedMetadata(code.getCodeSystemOid(), code.getCodeValue(),
						code.getDisplayName(), null));
	}

	/**
	 * Clears all the metadata attributes and lists (except the
	 * documentEntyUuid)
	 */
	public void clear() {
		xDoc.setAvailabilityStatus(null);
		xDoc.setClassCode(null);
		xDoc.setComments(null);
		xDoc.setCreationTime(null);
		xDoc.setFormatCode(null);
		xDoc.setHash(null);
		xDoc.setLanguageCode(null);
		xDoc.setLegalAuthenticator(null);
		xDoc.setMimeType(null);
		xDoc.setParentDocument(null);
		xDoc.setPatientId(null);
		xDoc.setPracticeSettingCode(null);
		xDoc.setRepositoryUniqueId(null);
		xDoc.setServiceStartTime(null);
		xDoc.setServiceStopTime(null);
		xDoc.setSize(null);
		xDoc.setSourcePatientId(null);
		xDoc.setSourcePatientInfo(null);

		xDoc.setTypeCode(null);
		xDoc.setHealthCareFacilityTypeCode(null);
		xDoc.setTitle(null);
		xDoc.setUniqueId(null);

		xDoc.getAuthors().clear();
		xDoc.getConfidentialityCode().clear();
		xDoc.getEventCode().clear();
		xDoc.getExtension().clear();
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
		xDoc.setParentDocument(null);
		xDoc.setPatientId(null);
		xDoc.setPracticeSettingCode(null);
		xDoc.setRepositoryUniqueId(null);

		xDoc.getAuthors().clear();
		xDoc.getConfidentialityCode().clear();
	}

	/**
	 * Copy mdht document entry type.
	 * 
	 * @return the document entry type
	 */
	public DocumentEntryType copyMdhtDocumentEntryType() {
		return EcoreUtil.copy(xDoc);
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
		final DocumentMetadata other = (DocumentMetadata) obj;
		if (this.xDoc == other.xDoc && this.cda == other.cda && this.language == other.language) {
			return true;
		}
		if (this.getAuthors() == null) {
			if (other.getAuthors() != null)
				return false;
		} else if (!(this.getAuthors().size() == other.getAuthors().size()))
			return false;

		if (this.getPatientId() == null) {
			if (other.getPatientId() != null)
				return false;
		} else if (!this.getPatientId().equals(other.getPatientId()))
			return false;

		if (this.getSourcePatientId() == null) {
			if (other.getSourcePatientId() != null)
				return false;
		} else if (!this.getSourcePatientId().equals(other.getSourcePatientId()))
			return false;

		if (this.getClassCode() == null) {
			if (other.getClassCode() != null)
				return false;
		} else if (!this.getClassCode().equals(other.getClassCode()))
			return false;

		if (this.getConfidentialityCodes() == null) {
			if (other.getConfidentialityCodes() != null)
				return false;
		} else if (!this.getConfidentialityCodes().equals(other.getConfidentialityCodes()))
			return false;

		if (this.getCodedLanguage() == null) {
			if (other.getCodedLanguage() != null)
				return false;
		} else if (!this.getCodedLanguage().equals(other.getCodedLanguage()))
			return false;

		if (this.getCreationTime() == null) {
			if (other.getCreationTime() != null)
				return false;
		} else if (!this.getCreationTime().equals(other.getCreationTime()))
			return false;

		if (this.getFormatCode() == null) {
			if (other.getFormatCode() != null)
				return false;
		} else if (!this.getFormatCode().equals(other.getFormatCode()))
			return false;

		if (this.getDocSourceActorOrganizationId() == null) {
			if (other.getDocSourceActorOrganizationId() != null)
				return false;
		} else if (!this.getDocSourceActorOrganizationId().equals(
				other.getDocSourceActorOrganizationId()))
			return false;

		if (this.getHealthcareFacilityTypeCode() == null) {
			if (other.getHealthcareFacilityTypeCode() != null)
				return false;
		} else if (!this.getHealthcareFacilityTypeCode().equals(
				other.getHealthcareFacilityTypeCode()))
			return false;

		if (this.getMimeType() == null) {
			if (other.getMimeType() != null)
				return false;
		} else if (!this.getMimeType().equals(other.getMimeType()))
			return false;

		if (this.getPracticeSettingCode() == null) {
			if (other.getPracticeSettingCode() != null)
				return false;
		} else if (!this.getPracticeSettingCode().equals(other.getPracticeSettingCode()))
			return false;

		if (this.getTitle() == null) {
			if (other.getTitle() != null)
				return false;
		} else if (!this.getTitle().equals(other.getTitle()))
			return false;

		if (this.getTypeCode() == null) {
			if (other.getTypeCode() != null)
				return false;
		} else if (!this.getTypeCode().equals(other.getTypeCode()))
			return false;

		if (this.getUniqueId() == null) {
			if (other.getUniqueId() != null)
				return false;
		} else if (!this.getUniqueId().equals(other.getUniqueId()))
			return false;
		return true;
	}

	/**
	 * Returns an (optional) author element. All information contained in the
	 * XDS Document Metadata will be extracted to the Convenience API Author.
	 * 
	 * @return ArrayList with Author objects
	 */
	public List<Author> getAuthors() {
		final List<Author> authorList = new ArrayList<Author>();

		for (int i = 0; i < xDoc.getAuthors().size(); i++) {
			final AuthorType at = (AuthorType) xDoc.getAuthors().get(i);
			authorList.add(XdsUtil.convertOhtAuthorType(at));
		}
		return authorList;
	}

	/**
	 * Gets the classCode
	 * 
	 * @return Code element with classCode
	 */
	public Code getClassCode() {
		return XdsUtil.convertOhtCodedMetadataType(xDoc.getClassCode());
	}

	/**
	 * Gets the codedLanguage
	 * 
	 * @return codedLanguage as String
	 */
	public String getCodedLanguage() {
		return xDoc.getLanguageCode();
	}

	/**
	 * Gets the confidentialityCode list
	 * 
	 * @return the ArrayList with ConfidentialityCodes
	 */
	public List<Code> getConfidentialityCodes() {
		final List<Code> confCodes = new ArrayList<Code>();

		if (!xDoc.getConfidentialityCode().isEmpty()) {
			for (int i = 0; i < xDoc.getConfidentialityCode().size(); i++) {
				final CodedMetadataType cmt = (CodedMetadataType) xDoc.getConfidentialityCode().get(i);
				confCodes.add(XdsUtil.convertOhtCodedMetadataType(cmt));
			}
		} else {
			return null;
		}
		return confCodes;
	}

	/**
	 * Gets the creationTime
	 * 
	 * @return creationTime as Date
	 */
	public Date getCreationTime() {
		return DateUtil.parseDates(xDoc.getCreationTime());
	}

	/**
	 * <div class="en">Gets the document source actors organization id
	 * 
	 * @return the document source actors organization id </div>
	 */
	public String getDocSourceActorOrganizationId() {
		return docSourceActorOrgId;
	}

	/**
	 * <div class="en">Gets the document descriptor of the document
	 * 
	 * @return the document descriptor of the document</div>
	 */
	public DocumentDescriptor getDocumentDescriptor() {
		return documentDescriptor;
	}

	/**
	 * Gets the formatCode
	 * 
	 * @return formatCode as Code
	 */
	public Code getFormatCode() {
		return XdsUtil.convertOhtCodedMetadataType(xDoc.getFormatCode());
	}

	/**
	 * Gets the healthcareFacilityTypeCode
	 * 
	 * @return healthcareFacilityTypeCode as Code
	 */
	public Code getHealthcareFacilityTypeCode() {
		return XdsUtil.convertOhtCodedMetadataType(xDoc.getHealthCareFacilityTypeCode());
	}

	/**
	 * Gets the mdht document entry type.
	 * 
	 * @return the mdht document entry type
	 */
	public DocumentEntryType getMdhtDocumentEntryType() {
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
		return XdsUtil.convertOhtSourcePatientInfoType(xDoc.getSourcePatientInfo());
	}

	/**
	 * Gets the patient id.
	 * 
	 * @return patientId as Identificator
	 */
	public Identificator getPatientId() {
		return XdsUtil.convertOhtCx(xDoc.getPatientId());
	}

	/**
	 * Gets the practice setting code. This is the medical speciality of the
	 * practice where the document was produced (e.g. Code for
	 * "General Medicine")
	 * 
	 * @return the practiceSettingCode as Code
	 */
	public Code getPracticeSettingCode() {
		return XdsUtil.convertOhtCodedMetadataType(xDoc.getPracticeSettingCode());
	}

	/**
	 * Gets the source patient id. This is the local patient id, e.g. inside a
	 * hospital.
	 * 
	 * @return the sourcePatientId as Identificator
	 */
	public Identificator getSourcePatientId() {
		if (xDoc.getSourcePatientId() != null) {
			return XdsUtil.convertOhtCx(xDoc.getSourcePatientId());
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
		return XdsUtil.convertInternationalStringType(xDoc.getTitle());
	}

	/**
	 * Gets the typeCode. Specifies the type of the document (like the class
	 * code, but more specific) (e.g. Code for "Summarization of Episode Note")
	 * 
	 * @return the typeCode as Code
	 */
	public Code getTypeCode() {
		return XdsUtil.convertOhtCodedMetadataType(xDoc.getTypeCode());
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
		final int prime = 31;
		int result = 1;
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
	 * Sets the (required, but in principle computable) class code, which
	 * defines the class of the document (e.g. Code for "Consultation")
	 * 
	 * @param code
	 *            the new class code
	 */
	public void setClassCode(Code code) {
		xDoc.setClassCode(XdsUtil.convertEhcCodeToCodedMetadataType(code, language));
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
	public void setCreationTime(Date dateAndTime) {
		final DateFormat cdaDateFormatter = new SimpleDateFormat("yyyyMMddHHmm");
		xDoc.setCreationTime(cdaDateFormatter.format(dateAndTime));
	}

	/**
	 * Sets the (required) destination patient id, which is used in the affinity
	 * domain (typically retrieved from a Master Patient Index (MPI))
	 * 
	 * @param id
	 *            the new patient id
	 */
	public void setDestinationPatientId(Identificator id) {
		xDoc.setPatientId(XdsUtil.convertEhcIdentificator(id));
	}

	/**
	 * <div class="en">Sets the document source actors organization id
	 * 
	 * @param docSourceActorOrgId
	 *            the document source actors organization id </div>
	 */
	public void setDocSourceActorOrganizationId(String docSourceActorOrgId) {
		this.docSourceActorOrgId = docSourceActorOrgId;
	}

	/**
	 * <div class="en">Sets the document descriptor of the document
	 * 
	 * @param documentDescriptor
	 *            the document descriptor of the document</div>
	 */
	public void setDocumentDescriptor(DocumentDescriptor documentDescriptor) {
		this.documentDescriptor = documentDescriptor;
	}

	/**
	 * Sets the (required) format code. If not set, the system will try to
	 * derive it from the Document MimeType.
	 * 
	 * @param code
	 *            the new format code
	 */
	public void setFormatCode(Code code) {
		xDoc.setFormatCode(XdsUtil.convertEhcCodeToCodedMetadataType(code, language));
	}

	/**
	 * Sets the (required) healthcare facility type code (e.g. Code for
	 * "Hospital")
	 * 
	 * @param code
	 *            the new healthcare facility type code
	 */
	public void setHealthcareFacilityTypeCode(Code code) {
		xDoc.setHealthCareFacilityTypeCode(XdsUtil
				.convertEhcCodeToCodedMetadataType(code, language));
	}

	public void setMetadata(DocumentMetadata metaData) {
		clear();
		for (Author item : metaData.getAuthors()) {
			addAuthor(item);
		}

		for (Code item : metaData.getConfidentialityCodes()) {
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
		cda.getRecordTargets().add(patient.getMdhtRecordTarget());

		// Source Patient Info (Adress etc.)
		final CDAR2Extractor extractor = new CDAR2Extractor(cda);
		final SourcePatientInfoType spi = extractor.extractSourcePatientInfo();
		xDoc.setSourcePatientInfo(spi);

		// PatientID
		if (patient.getIds() != null && patient.getIds().size() > 0) {
			setDestinationPatientId(patient.getIds().get(0));
		}
	}

	/**
	 * Sets the (required) practice setting code. This is the medical speciality
	 * of the practice where the document was produced (e.g. Code for
	 * "General Medicine")
	 * 
	 * @param code
	 *            the new practice setting code
	 */
	public void setPracticeSettingCode(Code code) {
		xDoc.setPracticeSettingCode(XdsUtil.convertEhcCodeToCodedMetadataType(code, language));
	}

	/**
	 * Sets the (required) source patient id. This is the local patient id, e.g.
	 * inside a hospital.
	 * 
	 * @param id
	 *            the new source patient id
	 */
	public void setSourcePatientId(Identificator id) {
		xDoc.setSourcePatientId(XdsUtil.convertEhcIdentificator(id));
	}

	/**
	 * Sets the (optional) title.
	 * 
	 * @param title
	 *            the title object to set
	 */
	public void setTitle(String title) {
		xDoc.setTitle(XdsUtil.createInternationalString(title, language));
	}

	/**
	 * Sets the (required) type code. Specifies the type of the document (like
	 * the class code, but more specific) (e.g. Code for
	 * "Summarization of Episode Note")
	 * 
	 * @param code
	 *            the new type code
	 */
	public void setTypeCode(Code code) {
		xDoc.setTypeCode(XdsUtil.convertEhcCodeToCodedMetadataType(code, language));
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

	/**
	 * Converts this (more general) DocumentMetadata object to a more specific
	 * swiss DocumentMetadataCh object.
	 * 
	 * @return the uniqueId
	 */
	public DocumentMetadata toDocumentMetadataCh() {
		return new DocumentMetadataCh(this);
	}
}
