package org.ehealth_connector.communication.ch;

import java.util.ArrayList;

import org.ehealth_connector.communication.DocumentMetadata;
import org.ehealth_connector.communication.ch.enums.ClassCode;
import org.ehealth_connector.communication.ch.enums.ConfidentialityCode;
import org.ehealth_connector.communication.ch.enums.FormatCode;
import org.ehealth_connector.communication.ch.enums.HealthcareFacilityTypeCode;
import org.ehealth_connector.communication.ch.enums.LanguageCode;
import org.ehealth_connector.communication.ch.enums.MimeType;
import org.ehealth_connector.communication.ch.enums.PracticeSettingCode;
import org.ehealth_connector.communication.ch.enums.TypeCode;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;

public class DocumentMetadataCh extends org.ehealth_connector.communication.DocumentMetadata {

	public DocumentMetadataCh() {
		super();
	}
	
	public DocumentMetadataCh(DocumentMetadata dm) {
		super.xDoc = dm.getMdhtDocumentEntryType();
	}

	/**
	 * Instantiates a new swiss (ch) specific document metadata object.
	 * 
	 * @param documentEntryType
	 *          the document entry type
	 */
	public DocumentMetadataCh(DocumentEntryType documentEntryType) {
		super(documentEntryType);
	}

	/**
	 * Adds the (optional) confidentialityCode code (e.g. '30001' for 'administrative data')
	 * 
	 * @param code
	 *          the code
	 */
	@SuppressWarnings("unchecked")
	public void addConfidentialityCode(ConfidentialityCode code) {
		xDoc.getConfidentialityCode().add(code.getCodedMetadataType());
	}

	/**
	 * Gets the confidentialityCode list
	 * 
	 * @return the ArrayList with ConfidentialityCodes as Enums
	 */
	public ArrayList<ConfidentialityCode> getConfidentialityCodesEnum() {
		ArrayList<ConfidentialityCode> ccl = new ArrayList<ConfidentialityCode>();
		if (!xDoc.getConfidentialityCode().isEmpty()) {
			for(int i=0;i<xDoc.getConfidentialityCode().size();i++) {
				CodedMetadataType cmt = (CodedMetadataType) xDoc.getConfidentialityCode().get(i);
				ccl.add(ConfidentialityCode.getEnum(cmt.getCode()));
			}
		}
		else return null;
		return ccl;
	}

	/**
	 * Sets the (required, but in principle computable) class code, which defines
	 * the class of the document (e.g. 'DCT01' for "Notes on Consultations")
	 * 
	 * @param code
	 *          the new class code
	 */
	public void setClassCode(org.ehealth_connector.communication.ch.enums.ClassCode code) {
		xDoc.setClassCode(code.getCodedMetadataType());
	}

	/**
	 * Gets the classCode 
	 * 
	 * @return Code element with classCode as Enum
	 */
	public org.ehealth_connector.communication.ch.enums.ClassCode getClassCodeEnum() {
		return ClassCode.getEnum(xDoc.getClassCode().getCode());
	}

	/**
	 * Sets the (required) coded language (e.g. "de-CH"). This code can be
	 * extracted from CDA Document automatically.
	 * 
	 * @param codedLanguage
	 *          the new language code
	 */
	public void setCodedLanguage(LanguageCode codedLanguage) {
		xDoc.setLanguageCode(codedLanguage.getCodeValue());
	}

	/**
	 * Gets the languageCode
	 * 
	 * @return codedLanguage as Enum
	 */
	public LanguageCode getLanguageCodeEnum() {
		return LanguageCode.getEnum(xDoc.getLanguageCode());
	}

	/**
	 * Sets the (required) format code (e.g. 'urn:epd:2015:EPD_Basic_Document' for an 'EDP Document')
	 * 
	 * @param code
	 *          the new format code
	 */
	public void setFormatCode(FormatCode code) {
		xDoc.setFormatCode(code.getCodedMetadataType());
	}

	/**
	 * Gets the formatCode
	 * 
	 * @return formatCode as Enum
	 */
	public org.ehealth_connector.communication.ch.enums.FormatCode getFormatCodeEnum() {
		return FormatCode.getEnum(xDoc.getFormatCode().getCode());
	}

	/**
	 * Sets the (required) healthcare facility type code (e.g. '20001' for
	 * 'Institut für medizinische Diagnostik')
	 * 
	 * @param code
	 *          the new healthcare facility type code
	 */
	public void setHealthcareFacilityTypeCode(HealthcareFacilityTypeCode code) {
		xDoc.setHealthCareFacilityTypeCode(code.getCodedMetadataType());
	}

	/**
	 * Gets the healthcareFacilityTypeCode
	 * 
	 * @return healthcareFacilityTypeCode as Enum
	 */
	public org.ehealth_connector.communication.ch.enums.HealthcareFacilityTypeCode getHealthcareFacilityTypeCodeEnum() {
		return HealthcareFacilityTypeCode.getEnum(xDoc.getHealthCareFacilityTypeCode().getCode());
	}

	/**
	 * Sets the (required) mime type (e.g. "text/xml")
	 * 
	 * @param mimeType
	 *          the new mime type
	 */
	public void setMimeType(MimeType mimeType) {
		xDoc.setMimeType(mimeType.getCodedMetadataType().getCode());
	}

	public org.ehealth_connector.communication.ch.enums.MimeType getMimeTypeCodeEnum() {
		return MimeType.getEnum(xDoc.getMimeType());
	}

	/**
	 * Sets the (required) practice setting code. This is the medical speciality
	 * of the practice where the document was produced (e.g. '10001' for
	 * 'Allergologie')
	 * 
	 * @param code
	 *          the new practice setting code
	 */
	public void setPracticeSettingCode(PracticeSettingCode code) {
		xDoc.setPracticeSettingCode(code.getCodedMetadataType());
	}

	public org.ehealth_connector.communication.ch.enums.PracticeSettingCode getPracticeSettingCodeEnum() {
		return PracticeSettingCode.getEnum(xDoc.getPracticeSettingCode().getCode());
	}

	/**
	 * Sets the (required) type code. Specifies the type of the document (like the
	 * class code, but more specific) (e.g. Code for
	 * 'Patienteneinwilligung')
	 * 
	 * @param code
	 *          the new type code
	 */
	public void setTypeCode(TypeCode code) {
		xDoc.setTypeCode(code.getCodedMetadataType());
	}

	/**
	 * Gets the practice setting code. This is the medical speciality
	 * of the practice where the document was produced
	 * 
	 * @return the practiceSettingCode as Enum
	 */
	public org.ehealth_connector.communication.ch.enums.TypeCode getTypeCodeEnum() {
		return TypeCode.getEnum(xDoc.getTypeCode().getCode());
	}
}
