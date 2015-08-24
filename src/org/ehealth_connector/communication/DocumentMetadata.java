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
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.ehealth_connector.cda.enums.Confidentiality;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.XdsUtil;
import org.ehealth_connector.communication.ch.DocumentMetadataCh;
import org.openhealthtools.ihe.common.hl7v2.SourcePatientInfoType;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;
import org.openhealthtools.ihe.xds.metadata.extract.cdar2.CDAR2Extractor;
import org.openhealthtools.ihe.xds.utils.XDSUtils;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;

/**
 * Provides metadata attributes as specified in [IHE ITI TF-3], Table 4.1-5:
 * Document Metadata
 * */
public class DocumentMetadata {

	/** The x doc. */
	protected DocumentEntryType xDoc;

	/** The cda. */
	private final ClinicalDocument cda;

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
	 *          the document entry type
	 */
	public DocumentMetadata(DocumentEntryType documentEntryType) {
		this();
		xDoc = documentEntryType;
	}

	/**
	 * Adds an (optional) author element. All information relevant for the XDS
	 * Document Metadata will be extracted from the Convencience API Author.
	 * 
	 * @param author
	 *          the author
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

		cda.getAuthors().add(author.copyMdhtAuthor());

		CDAR2Extractor extractor = new CDAR2Extractor(cda);
		AuthorType xAuthor = extractor.extractAuthors().get(0);
		xDoc.getAuthors().add(xAuthor);
	}
	
	public ArrayList<Author> getAuthors() {
		ArrayList<Author> authorList = new ArrayList<Author>();
		AuthorType at = null;
		
		for (int i=0;i<xDoc.getAuthors().size();i++) {
			at = (AuthorType) xDoc.getAuthors().get(i);
			authorList.add(XdsUtil.convertOhtAuthorType(at));
		}
		return authorList;
	}

	/**
	 * Adds the (optional) confidentialityCode code (e.g. 'N' for 'normal')
	 * 
	 * @param code
	 *          the code
	 */
	@SuppressWarnings("unchecked")
	public void addConfidentialityCode(Confidentiality code) {
		xDoc.getConfidentialityCode().add(
				XdsUtil.createCodedMetadata(code.getCodeSystemOid(), code.getCodeValue(),
						code.getDisplayName(), null));
	}
	
	public ArrayList<Code> getConfidentialityCodes() {
		ArrayList<Code> confCodes = new ArrayList<Code>();
		CodedMetadataType cmt = null;
		
		if (!xDoc.getConfidentialityCode().isEmpty()) {
			for (int i=0;i<xDoc.getConfidentialityCode().size();i++) {
				cmt = (CodedMetadataType) xDoc.getConfidentialityCode().get(i);
				confCodes.add(XdsUtil.convertOhtCodedMetadataType(cmt));
			}
		}
		else return null;
		return confCodes;
	}

	/**
	 * Copy mdht document entry type.
	 * 
	 * @return the document entry type
	 */
	public DocumentEntryType copyMdhtDocumentEntryType() {
		return EcoreUtil.copy(xDoc);
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
	 * Sets the (required, but in principle computable) class code, which defines
	 * the class of the document (e.g. Code for "Consultation")
	 * 
	 * @param code
	 *          the new class code
	 */
	public void setClassCode(Code code) {
		xDoc.setClassCode(XdsUtil.convertCode(code));
	}
	
	public Code getClassCode() {
		return XdsUtil.convertOhtCodedMetadataType(xDoc.getClassCode());
	}

	/**
	 * Sets the (required) coded language (e.g. "de-CH"). This code can be
	 * extracted from CDA Documents, automatically.
	 * 
	 * @param codedLanguage
	 *          the new language code
	 */
	public void setCodedLanguage(String codedLanguage) {
		xDoc.setLanguageCode(codedLanguage);
	}
	
	public String getLanguageCode() {
		return xDoc.getLanguageCode();
	}

	/**
	 * Sets the (required) creation time of the document. If not set, the current
	 * time will be used.
	 * 
	 * @param dateAndTime
	 *          the new creation time
	 */
	public void setCreationTime(Date dateAndTime) {
		final DateFormat cdaDateFormatter = new SimpleDateFormat("yyyyMMddHHmm");
		xDoc.setCreationTime(cdaDateFormatter.format(dateAndTime));
	}
	
	public Date getCreationTime() {
		return DateUtil.parseDateyyyyMMddHHmm(xDoc.getCreationTime());
	}

	/**
	 * Sets the (required) format code. If not set, the system will try to derive
	 * it from the Document MimeType.
	 * 
	 * @param code
	 *          the new format code
	 */
	public void setFormatCode(Code code) {
		xDoc.setFormatCode(XdsUtil.convertCode(code));
	}
	
	public Code getFormatCode() {
		return XdsUtil.convertOhtCodedMetadataType(xDoc.getFormatCode());
	}

	/**
	 * Sets the (required) healthcare facility type code (e.g. Code for
	 * "Hospital")
	 * 
	 * @param code
	 *          the new healthcare facility type code
	 */
	public void setHealthcareFacilityTypeCode(Code code) {
		xDoc.setHealthCareFacilityTypeCode(XdsUtil.convertCode(code));
	}
	
	public Code getHealthcareFacilityTypeCode() {
		return XdsUtil.convertOhtCodedMetadataType(xDoc.getHealthCareFacilityTypeCode());
	}

	/**
	 * Sets the (required) mime type (e.g. "text/xml")
	 * 
	 * @param mimeType
	 *          the new mime type
	 */
	public void setMimeType(String mimeType) {
		xDoc.setMimeType(mimeType);
	}
	
	public String getMimeType() {
		return xDoc.getMimeType();
	}

	/**
	 * Sets the (required) patient. All information relevant for the XDS Document
	 * Metadata will be extracted from the Convencience API Patient.
	 * 
	 * @param patient
	 *          the new patient
	 */
	public void setPatient(Patient patient) {
		cda.getRecordTargets().add(patient.getMdhtRecordTarget());

		// Source Patient Info (Adress etc.)
		CDAR2Extractor extractor = new CDAR2Extractor(cda);
		SourcePatientInfoType spi = extractor.extractSourcePatientInfo();
		xDoc.setSourcePatientInfo(spi);

		// PatientID

		if (patient.getIds() != null) {
			setPatientId(patient.getIds().get(0));
		}
	}
	
	public Patient getPatient() {
		return XdsUtil.convertOhtSourcePatientInfoType(xDoc.getSourcePatientInfo());
	}

	/**
	 * Sets the (required) patient id, which is used in the affinity domain
	 * (typically retrieved from a Master Patient Index (MPI))
	 * 
	 * @param id
	 *          the new patient id
	 */
	public void setPatientId(Identificator id) {
		xDoc.setPatientId(XdsUtil.convertEhcIdentificator(id));
	}
	
	public Identificator getId() {
		return XdsUtil.convertOhtCx(xDoc.getPatientId());
	}

	/**
	 * Sets the (required) practice setting code. This is the medical speciality
	 * of the practice where the document was produced (e.g. Code for
	 * "General Medicine")
	 * 
	 * @param code
	 *          the new practice setting code
	 */
	public void setPracticeSettingCode(Code code) {
		xDoc.setPracticeSettingCode(XdsUtil.convertCode(code));
	}
	
	public Code getPracticeSettingCode() {
		return XdsUtil.convertOhtCodedMetadataType(xDoc.getPracticeSettingCode());
	}

	/**
	 * Sets the (required) source patient id. This is the local patient id, e.g.
	 * inside a hospital.
	 * 
	 * @param id
	 *          the new source patient id
	 */
	public void setSourcePatientId(Identificator id) {
		xDoc.setSourcePatientId(XdsUtil.convertEhcIdentificator(id));
	}
	
	public Identificator getSourcePatientId() {
		return XdsUtil.convertOhtCx(xDoc.getPatientId());
	}

	/**
	 * Sets the (optional) title.
	 * 
	 * @param title
	 *          the title object to set
	 */
	public void setTitle(String title) {
		xDoc.setTitle(XdsUtil.createInternationalString(title));
	}
	
	public String getTitle() {
		return XdsUtil.convertInternationalStringType(xDoc.getTitle());
	}

	/**
	 * Sets the (required) type code. Specifies the type of the document (like the
	 * class code, but more specific) (e.g. Code for
	 * "Summarization of Episode Note")
	 * 
	 * @param code
	 *          the new type code
	 */
	public void setTypeCode(Code code) {
		xDoc.setTypeCode(XdsUtil.convertCode(code));
	}
	
	public Code getTypeCode() {
		return XdsUtil.convertOhtCodedMetadataType(xDoc.getTypeCode());
	}

	/**
	 * Sets the unique id. The UUID of the document. Will be generated, when the
	 * instance of class is retrieved from ConvenienceCommunication.addDocument()
	 * 
	 * @param id
	 *          the new unique id
	 */
	public void setUniqueId(String id) {
		xDoc.setUniqueId(id);
	}
	
	public String getUniqueId() {
		return xDoc.getUniqueId();
	}
	
	public DocumentMetadata toDocumentMetadataCh() {
		return new DocumentMetadataCh(this);
	}
}
