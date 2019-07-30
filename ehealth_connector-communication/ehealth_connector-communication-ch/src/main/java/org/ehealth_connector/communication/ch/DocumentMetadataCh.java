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
package org.ehealth_connector.communication.ch;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.ch.enums.ConfidentialityCode;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.communication.DocumentMetadata;
import org.ehealth_connector.communication.ch.enums.ClassCode;
import org.ehealth_connector.communication.ch.enums.FormatCode;
import org.ehealth_connector.communication.ch.enums.HealthcareFacilityTypeCode;
import org.ehealth_connector.communication.ch.enums.MimeType;
import org.ehealth_connector.communication.ch.enums.PracticeSettingCode;
import org.ehealth_connector.communication.ch.enums.TypeCode;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;

public class DocumentMetadataCh extends org.ehealth_connector.communication.DocumentMetadata {

	/**
	 * Instantiates a new document meta data.
	 */
	public DocumentMetadataCh() {
		super("de-CH");
	}

	/**
	 * Instantiates a new swiss (ch) specific document meta data object.
	 *
	 * @param documentEntryType
	 *            the document entry type
	 */
	public DocumentMetadataCh(DocumentEntryType documentEntryType) {
		super(documentEntryType);
	}

	/**
	 * Instantiates a new swiss (ch) specific document meta data object.
	 *
	 * @param dm
	 *            the DocumentMetadata object
	 */
	public DocumentMetadataCh(DocumentMetadata dm) {
		super(dm.getMdhtDocumentEntryType());
	}

	/**
	 * Adds the (optional) confidentialityCode code (e.g. '30001' for
	 * 'administrative data')
	 *
	 * @param code
	 *            the code
	 */
	@SuppressWarnings("unchecked")
	public void addConfidentialityCode(ConfidentialityCode code) {
		getMdhtDocumentEntryType().getConfidentialityCode().add(code.getCodedMetadataType());
	}

	/**
	 * Gets the classCode
	 *
	 * @return Code element with classCode as Enum
	 */
	public org.ehealth_connector.communication.ch.enums.ClassCode getClassCodeEnum() {
		return ClassCode.getEnum(getMdhtDocumentEntryType().getClassCode().getCode());
	}

	/**
	 * Gets the confidentialityCode list
	 *
	 * @return the ArrayList with ConfidentialityCodes as Enums
	 */
	public List<ConfidentialityCode> getConfidentialityCodesEnum() {
		final List<ConfidentialityCode> ccl = new ArrayList<ConfidentialityCode>();
		if (!getMdhtDocumentEntryType().getConfidentialityCode().isEmpty()) {
			for (int i = 0; i < getMdhtDocumentEntryType().getConfidentialityCode().size(); i++) {
				final CodedMetadataType cmt = (CodedMetadataType) getMdhtDocumentEntryType()
						.getConfidentialityCode().get(i);
				ccl.add(ConfidentialityCode.getEnum(cmt.getCode()));
			}
		} else
			return null;
		return ccl;
	}

	/**
	 * Gets the formatCode
	 *
	 * @return formatCode as Enum
	 */
	public org.ehealth_connector.communication.ch.enums.FormatCode getFormatCodeEnum() {
		return FormatCode.getEnum(getMdhtDocumentEntryType().getFormatCode().getCode());
	}

	/**
	 * Gets the healthcareFacilityTypeCode
	 *
	 * @return healthcareFacilityTypeCode as Enum
	 */
	public org.ehealth_connector.communication.ch.enums.HealthcareFacilityTypeCode getHealthcareFacilityTypeCodeEnum() {
		return HealthcareFacilityTypeCode
				.getEnum(getMdhtDocumentEntryType().getHealthCareFacilityTypeCode().getCode());
	}

	/**
	 * Gets the languageCode
	 *
	 * @return codedLanguage as Enum
	 */
	public LanguageCode getLanguageCodeEnum() {
		return LanguageCode.getEnum(getMdhtDocumentEntryType().getLanguageCode());
	}

	/**
	 * Method to get mimetype
	 *
	 * @return the mimetype of the document
	 */
	public org.ehealth_connector.communication.ch.enums.MimeType getMimeTypeCodeEnum() {
		return MimeType.getEnum(getMdhtDocumentEntryType().getMimeType());
	}

	/**
	 * Method to get the practice settings code
	 *
	 * @return the pactice settings code
	 */
	public org.ehealth_connector.communication.ch.enums.PracticeSettingCode getPracticeSettingCodeEnum() {
		return PracticeSettingCode
				.getEnum(getMdhtDocumentEntryType().getPracticeSettingCode().getCode());
	}

	/**
	 * Gets the practice setting code. This is the medical speciality of the
	 * practice where the document was produced
	 *
	 * @return the practiceSettingCode as Enum
	 */
	public org.ehealth_connector.communication.ch.enums.TypeCode getTypeCodeEnum() {
		return TypeCode.getEnum(getMdhtDocumentEntryType().getTypeCode().getCode());
	}

	/**
	 * Sets the (required, but in principle computable) class code, which
	 * defines the class of the document (e.g. 'DCT01' for "Notes on
	 * Consultations")
	 *
	 * @param code
	 *            the new class code
	 */
	public void setClassCode(org.ehealth_connector.communication.ch.enums.ClassCode code) {
		getMdhtDocumentEntryType().setClassCode(code.getCodedMetadataType());
	}

	/**
	 * Sets the (required) coded language (e.g. "de-CH"). This code can be
	 * extracted from CDA Document automatically.
	 *
	 * @param codedLanguage
	 *            the new language code
	 */
	public void setCodedLanguage(LanguageCode codedLanguage) {
		getMdhtDocumentEntryType().setLanguageCode(codedLanguage.getCodeValue());
	}

	/**
	 * Sets the (required) format code (e.g. 'urn:epd:2015:EPD_Basic_Document'
	 * for an 'EDP Document')
	 *
	 * @param code
	 *            the new format code
	 */
	public void setFormatCode(FormatCode code) {
		getMdhtDocumentEntryType().setFormatCode(code.getCodedMetadataType());
	}

	/**
	 * Sets the (required) healthcare facility type code (e.g. '20001' for
	 * 'Institut für medizinische Diagnostik')
	 *
	 * @param code
	 *            the new healthcare facility type code
	 */
	public void setHealthcareFacilityTypeCode(HealthcareFacilityTypeCode code) {
		getMdhtDocumentEntryType().setHealthCareFacilityTypeCode(code.getCodedMetadataType());
	}

	/**
	 * Sets the (required) mime type (e.g. "text/xml")
	 *
	 * @param mimeType
	 *            the new mime type
	 */
	public void setMimeType(MimeType mimeType) {
		getMdhtDocumentEntryType().setMimeType(mimeType.getCodedMetadataType().getCode());
	}

	/**
	 * Sets the (required) practice setting code. This is the medical speciality
	 * of the practice where the document was produced (e.g. '10001' for
	 * 'Allergologie')
	 *
	 * @param code
	 *            the new practice setting code
	 */
	public void setPracticeSettingCode(PracticeSettingCode code) {
		getMdhtDocumentEntryType().setPracticeSettingCode(code.getCodedMetadataType());
	}

	/**
	 * Sets the (required) type code. Specifies the type of the document (like
	 * the class code, but more specific) (e.g. Code for
	 * 'Patienteneinwilligung')
	 *
	 * @param code
	 *            the new type code
	 */
	public void setTypeCode(TypeCode code) {
		getMdhtDocumentEntryType().setTypeCode(code.getCodedMetadataType());
	}
}
