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
package org.husky.communication.ch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.husky.common.ch.ChEpr;
import org.husky.common.ch.enums.ConfidentialityCode;
import org.husky.common.communication.DocumentMetadata;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;
import org.husky.communication.ch.enums.ClassCode;
import org.husky.communication.ch.enums.FormatCode;
import org.husky.communication.ch.enums.HealthcareFacilityTypeCode;
import org.husky.communication.ch.enums.MimeType;
import org.husky.communication.ch.enums.OriginalProviderRole;
import org.husky.communication.ch.enums.PracticeSettingCode;
import org.husky.communication.ch.enums.TypeCode;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;

public class DocumentMetadataCh extends org.husky.common.communication.DocumentMetadata {

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
	public DocumentMetadataCh(DocumentEntry documentEntryType) {
		super(documentEntryType);
	}

	/**
	 * Instantiates a new swiss (ch) specific document meta data object.
	 *
	 * @param dm
	 *            the DocumentMetadata object
	 */
	public DocumentMetadataCh(DocumentMetadata dm) {
		super(dm.getDocumentEntry());
	}

	/**
	 * Adds the (optional) confidentialityCode code (e.g. '30001' for
	 * 'administrative data')
	 *
	 * @param code
	 *            the code
	 */
	public void addConfidentialityCode(ValueSetEnumInterface code) {
		getDocumentEntry().getConfidentialityCodes().add(code.getIpfCode());
	}

	/**
	 * Gets the classCode
	 *
	 * @return Code element with classCode as Enum
	 */
	public org.husky.communication.ch.enums.ClassCode getClassCodeEnum() {
		return ClassCode.getEnum(getDocumentEntry().getClassCode().getCode());
	}

	/**
	 * Gets the confidentialityCode list
	 *
	 * @return the ArrayList with ConfidentialityCodes as Enums
	 */
	public List<ConfidentialityCode> getConfidentialityCodesEnum() {
		final List<ConfidentialityCode> ccl = new ArrayList<>();
		if (!getDocumentEntry().getConfidentialityCodes().isEmpty()) {
			for (var i = 0; i < getDocumentEntry().getConfidentialityCodes().size(); i++) {
				final Code cmt = getDocumentEntry().getConfidentialityCodes().get(i);
				ccl.add(ConfidentialityCode.getEnum(cmt.getCode()));
			}
		} else
			return new LinkedList<>();
		return ccl;
	}

	/**
	 * Gets the formatCode
	 *
	 * @return formatCode as Enum
	 */
	public org.husky.communication.ch.enums.FormatCode getFormatCodeEnum() {
		return FormatCode.getEnum(getDocumentEntry().getFormatCode().getCode());
	}

	/**
	 * Gets the healthcareFacilityTypeCode
	 *
	 * @return healthcareFacilityTypeCode as Enum
	 */
	public org.husky.communication.ch.enums.HealthcareFacilityTypeCode getHealthcareFacilityTypeCodeEnum() {
		return HealthcareFacilityTypeCode
				.getEnum(getDocumentEntry().getHealthcareFacilityTypeCode().getCode());
	}

	/**
	 * Gets the languageCode
	 *
	 * @return codedLanguage as Enum
	 */
	public LanguageCode getLanguageCodeEnum() {
		return LanguageCode.getEnum(getDocumentEntry().getLanguageCode());
	}

	/**
	 * Method to get mimetype
	 *
	 * @return the mimetype of the document
	 */
	public org.husky.communication.ch.enums.MimeType getMimeTypeCodeEnum() {
		return MimeType.getEnum(getDocumentEntry().getMimeType());
	}

	/**
	 * Method to get the practice settings code
	 *
	 * @return the pactice settings code
	 */
	public org.husky.communication.ch.enums.PracticeSettingCode getPracticeSettingCodeEnum() {
		return PracticeSettingCode
				.getEnum(getDocumentEntry().getPracticeSettingCode().getCode());
	}

	/**
	 * Gets the practice setting code. This is the medical speciality of the
	 * practice where the document was produced
	 *
	 * @return the practiceSettingCode as Enum
	 */
	public org.husky.communication.ch.enums.TypeCode getTypeCodeEnum() {
		return TypeCode.getEnum(getDocumentEntry().getTypeCode().getCode());
	}

	/**
	 * Sets the (required, but in principle computable) class code, which
	 * defines the class of the document (e.g. 'DCT01' for "Notes on
	 * Consultations")
	 *
	 * @param code
	 *            the new class code
	 */
	public void setClassCode(org.husky.communication.ch.enums.ClassCode code) {
		getDocumentEntry().setClassCode(code.getIpfCode());
	}

	/**
	 * Sets the (required) coded language (e.g. "de-CH"). This code can be
	 * extracted from CDA Document automatically.
	 *
	 * @param codedLanguage
	 *            the new language code
	 */
	public void setCodedLanguage(LanguageCode codedLanguage) {
		getDocumentEntry().setLanguageCode(codedLanguage.getCodeValue());
	}

	/**
	 * Sets the (required) format code (e.g. 'urn:epd:2015:EPD_Basic_Document'
	 * for an 'EDP Document')
	 *
	 * @param code
	 *            the new format code
	 */
	public void setFormatCode(FormatCode code) {
		getDocumentEntry().setFormatCode(code.getIpfCode());
	}

	/**
	 * Sets the (required) healthcare facility type code (e.g. '20001' for
	 * 'Institut für medizinische Diagnostik')
	 *
	 * @param code
	 *            the new healthcare facility type code
	 */
	public void setHealthcareFacilityTypeCode(HealthcareFacilityTypeCode code) {
		getDocumentEntry().setHealthcareFacilityTypeCode(code.getIpfCode());
	}

	/**
	 * Sets the (required) mime type (e.g. "text/xml")
	 *
	 * @param mimeType
	 *            the new mime type
	 */
	public void setMimeType(MimeType mimeType) {
		getDocumentEntry().setMimeType(mimeType.getIpfCode().getCode());
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
		getDocumentEntry().setPracticeSettingCode(code.getIpfCode());
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
		getDocumentEntry().setTypeCode(code.getIpfCode());
	}

	/**
	 * Sets the (required) original provider code. Specifies the role of the
	 * provider of the document.
	 * 
	 * @param code the new original provider role code
	 */
	public void setOriginalProviderRole(OriginalProviderRole code) {
		if (getDocumentEntry().getExtraMetadata() == null) {
			getDocumentEntry().setExtraMetadata(new HashMap<>());
		}

		getDocumentEntry().getExtraMetadata().put(ChEpr.ORIGINAL_PROVIDER_ROLE_URN,
				List.of(code.getCodedString()));
	}

}
