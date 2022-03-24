/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.communication.at;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.husky.common.at.AuthorAt;
import org.husky.common.at.enums.ClassCode;
import org.husky.common.at.enums.ConfidentialityCode;
import org.husky.common.at.enums.FormatCode;
import org.husky.common.at.enums.HealthcareFacilityTypeCode;
import org.husky.common.at.enums.MimeType;
import org.husky.common.at.enums.PracticeSettingCode;
import org.husky.common.at.enums.TypeCode;
import org.husky.common.enums.LanguageCode;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.common.model.Identificator;
import org.husky.common.utils.XdsMetadataUtil;
import org.husky.common.utils.time.DateTimes;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssociationType;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Author;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Hl7v2Based;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.ReferenceId;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocumentMetadataAt extends org.husky.common.communication.DocumentMetadata {
	private static Logger log = LoggerFactory.getLogger(DocumentMetadataAt.class);

	private List<Identificator> patientIds;
	private Identificator parentDocumentId;
	private AssociationType parentDocumentType;

	/**
	 * Instantiates a new document metadata.
	 */
	public DocumentMetadataAt() {
		super("de-AT");
	}

	/**
	 * Instantiates a new document metadata.
	 *
	 * @param documentEntryType the document entry type
	 */
	public DocumentMetadataAt(DocumentEntry documentEntryType, POCDMT000040ClinicalDocument cda,
			List<Identificator> patientIds) {
		super(cda, documentEntryType, "de-AT");
		this.patientIds = patientIds;
	}

	public DocumentMetadataAt(POCDMT000040ClinicalDocument cda, boolean urnOidNeeded, boolean orgUrnOidNeeded) {
		super(cda, "de-AT");

		CDAR2ExtractorAt extractor = new CDAR2ExtractorAt(cda);
		setAvailabilityStatus(extractor.extractAvailabilityStatus());

		List<Author> authors = extractor.extractAuthors();

		if (authors != null) {
			for (Author author : authors) {
				getDocumentEntry().getAuthors().add(author);
			}
		}
		
		getDocumentEntry().setLegalAuthenticator(extractor.extractLegalAuthenticator());

		Code classCode = extractor.extractClassCode();
		Code typeCode = extractor.extractTypeCode();
		Code typeCodeFromTranslation = extractor.extractTypeCodeOfTranslation();

		if (typeCodeFromTranslation == null && typeCode != null
				&& !TypeCode.isImmunizationHistory(typeCode.getCode())) {
			setClassCode(classCode, urnOidNeeded);
			getDocumentEntry().setTypeCode(typeCode);
		} else if (typeCodeFromTranslation != null && TypeCode.getEnum(typeCodeFromTranslation.getCode()) != null) {
			setClassCode(typeCode, urnOidNeeded);
			getDocumentEntry().setTypeCode(typeCodeFromTranslation);
		}

		setCodedLanguage(extractor.extractLanguageCode());

		LocalizedString comments = extractor.extractComments();
		if (comments != null) {
			setComments(extractor.extractComments().toString());
		}

		List<Code> confidCodes = extractor.extractConfidentialityCodes();
		if (confidCodes != null) {
			for (Code confCode : confidCodes) {
				getDocumentEntry().getConfidentialityCodes().add(confCode);
			}
		}

		Timestamp creationTime = extractor.extractCreationTime();
		if (creationTime != null) {
			setCreationTime(creationTime.getDateTime());
		}
		
		getDocumentEntry().setFormatCode(extractor.extractFormatCode());
		getDocumentEntry().setHealthcareFacilityTypeCode(extractor.extractHealthCareFacilityTypeCode());
		
		setMetadataLanguage(extractor.extractLanguageCode());
		setMimeType(extractor.extractMimeType());

		Identifiable parentDoc = extractor.extractParentDocument();
		if (parentDoc != null) {
			setParentDocument(parentDoc, extractor.extractParentDocumentType());
		}

		getDocumentEntry().setSourcePatientInfo(extractor.extractSourcePatientInfo());

		Code eventCode = extractor.extractEventCode();
		getDocumentEntry().getEventCodeList().add(eventCode);

		Instant serviceEventStart = extractor.extractEventStartTime();

		if (serviceEventStart != null) {
			setServiceEventStartTime(DateTimes.getZonedDateTime(serviceEventStart));
		}

		Instant serviceEventStop = extractor.extractEventStopTime();

		if (serviceEventStop != null) {
			setServiceEventStopTime(DateTimes.getZonedDateTime(serviceEventStop));
		}

		patientIds = new ArrayList<>();
		List<Identifiable> cxPatientIds = extractor.extractPatientIds();
		for (Identifiable cx : cxPatientIds) {
			if (cx != null) {
				patientIds.add(XdsMetadataUtil.convertIpfIdentifiableToEhc(cx));
			}
		}

		getDocumentEntry().setTitle(extractor.extractTitle());
		getDocumentEntry().getTitle().setLang(getMetadataLanguage());

		setUniqueId(extractor.extractUniqueId());

		setUri(extractor.extractURI());

	}

	/**
	 * Adds an (optional) author element. All information relevant for the XDS
	 * Document Metadata will be extracted from the Convenience API Author.
	 *
	 * @param author the author
	 */
	public void addAuthor(AuthorAt author, boolean urnOidNeeded, boolean orgUrnOidNeeded) {
		log.debug("organization id: {}", author.getOrganization().getIdentificatorList());
		super.addAuthor(author);
		
		if(orgUrnOidNeeded) {
			for(Author authorDocEntry: getDocumentEntry().getAuthors()) {
				if(authorDocEntry != null && authorDocEntry.getAuthorInstitution() != null) {
					for(Organization orgDocEntry: authorDocEntry.getAuthorInstitution()) {
						if(orgDocEntry != null && orgDocEntry.getAssigningAuthority() != null
								&& orgDocEntry.getAssigningAuthority().getUniversalId() != null) {
							orgDocEntry.getAssigningAuthority().setUniversalId(
									String.format("urn:oid:%s", orgDocEntry.getAssigningAuthority().getUniversalId()));
						}
					}
				}	
			}
		}
	}

	public void addServiceEventCode(Code code) {
		if (code != null) {
			getDocumentEntry().getEventCodeList().add(code);
		}
	}

	/**
	 * Gets the classCode
	 *
	 * @return Code element with classCode as Enum
	 */
	public ClassCode getClassCodeEnum() {
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
			for (int i = 0; i < getDocumentEntry().getConfidentialityCodes().size(); i++) {
				final Code cmt = getDocumentEntry().getConfidentialityCodes().get(i);
				ccl.add(ConfidentialityCode.getEnum(cmt.getCode()));
			}
		}

		return ccl;
	}

	/**
	 * Gets the formatCode
	 *
	 * @return formatCode as Enum
	 */
	public org.husky.common.at.enums.FormatCode getFormatCodeEnum() {
		return FormatCode.getEnum(getDocumentEntry().getFormatCode().getCode());
	}

	/**
	 * Gets the healthcareFacilityTypeCode
	 *
	 * @return healthcareFacilityTypeCode as Enum
	 */
	public org.husky.common.at.enums.HealthcareFacilityTypeCode getHealthcareFacilityTypeCodeEnum() {
		return HealthcareFacilityTypeCode.getEnum(getDocumentEntry().getHealthcareFacilityTypeCode().getCode());
	}

	/**
	 * Gets the languageCode
	 *
	 * @return codedLanguage as Enum
	 */
	public LanguageCode getLanguageCodeEnum() {
		return LanguageCode.getEnum(getDocumentEntry().getLanguageCode());
	}

	public org.husky.common.model.Person getLegalAuthenticator() {
		return new org.husky.common.model.Person(getDocumentEntry().getLegalAuthenticator());
	}

	/**
	 * Method to get mimetype
	 *
	 * @return the mimetype of the document
	 */
	public MimeType getMimeTypeCodeEnum() {
		return MimeType.getEnum(getDocumentEntry().getMimeType());
	}

	/**
	 * Method to get the practice settings code
	 *
	 * @return the pactice settings code
	 */
	public org.husky.common.at.enums.PracticeSettingCode getPracticeSettingCodeEnum() {
		return PracticeSettingCode.getEnum(getDocumentEntry().getPracticeSettingCode().getCode());
	}

	public ReferenceId getRefrencedIdList() {
		if (getDocumentEntry().getReferenceIdList() != null) {
			List<ReferenceId> values = getDocumentEntry().getReferenceIdList();

			if (values != null && !values.isEmpty()) {
				return values.get(0);
			}
		}

		return null;
	}

	public org.husky.common.model.Code getServiceEventCode() {
		if (getDocumentEntry().getEventCodeList() != null && !getDocumentEntry().getEventCodeList().isEmpty()
				&& getDocumentEntry().getEventCodeList().get(0) != null) {
			return XdsMetadataUtil.convertOhtCodedMetadataType(getDocumentEntry().getEventCodeList().get(0));
		}

		return null;
	}

	public ZonedDateTime getServiceEventStartTime() {
		if (getDocumentEntry().getServiceStartTime() != null) {
			return getDocumentEntry().getServiceStartTime().getDateTime();
		}

		return null;
	}

	public ZonedDateTime getServiceEventStopTime() {
		if (getDocumentEntry().getServiceStopTime() != null) {
			return getDocumentEntry().getServiceStopTime().getDateTime();
		}

		return null;
	}

	public Identificator getSetId() {
		return new Identificator(getCda().getSetId());
	}

	/**
	 * Gets the practice setting code. This is the medical speciality of the
	 * practice where the document was produced
	 *
	 * @return the practiceSettingCode as Enum
	 */
	public TypeCode getTypeCodeEnum() {
		return TypeCode.getEnum(getDocumentEntry().getTypeCode().getCode());
	}

	/**
	 * Sets the (required, but in principle computable) class code, which defines
	 * the class of the document (e.g. 'DCT01' for "Notes on Consultations")
	 *
	 * @param code the new class code
	 */
	public void setClassCode(Code code, boolean urnOidNeeded) {
		if (code != null) {
			if (code.getSchemeName() != null && urnOidNeeded && !code.getSchemeName().contains("urn:oid:")) {
				code.setSchemeName(String.format("urn:oid:%s", code.getSchemeName()));
			}

			getDocumentEntry().setClassCode(code);
		}
	}

	/**
	 * Sets the (required) coded language (e.g. "de-CH"). This code can be extracted
	 * from CDA Document automatically.
	 *
	 * @param codedLanguage the new language code
	 */
	public void setCodedLanguage(LanguageCode codedLanguage) {
		super.setCodedLanguage(codedLanguage.getCodeValue());
	}

	/**
	 * Sets the comments for the CDA document
	 *
	 * @param comments comments to add for the document
	 */
	public void setComments(String comments) {
		getDocumentEntry().setComments(XdsMetadataUtil.createInternationalString(comments));
	}

	/**
	 * Sets the (required) mime type (e.g. "text/xml")
	 *
	 * @param mimeType the new mime type
	 */
	public void setMimeType(MimeType mimeType) {
		super.setMimeType(mimeType.getCodeValue());
	}

	/**
	 * Sets the parent document. All information relevant for the parent document
	 * have to be set here.
	 *
	 * @param id            reference to an other document
	 * @param relationship  type of the relationship of the referenced document
	 * @param parentDocCode code for the relationship of the referenced document
	 *
	 */
	public void setParentDocument(Identifiable id, AssociationType relationship) {
		if (id != null && relationship != null) {
			parentDocumentId = XdsMetadataUtil.convertIpfIdentifiableToEhc(id);
			parentDocumentType = relationship;
		}
	}

	public void removePatientIdsFromPatient() {
		if (getDocumentEntry().getSourcePatientInfo() != null
				&& getDocumentEntry().getSourcePatientInfo().getIds() != null) {
			while (getDocumentEntry().getSourcePatientInfo().getIds().hasNext()) {
				getDocumentEntry().getSourcePatientInfo().getIds().next();
				getDocumentEntry().getSourcePatientInfo().getIds().remove();
			}
		}
	}

	public void setRefrencedIdList(Identificator id, String homeCommunityId) {
		ReferenceId referenceId = Hl7v2Based.parse(
				createCxi(id, "urn:elga:iti:xds:2014:ownDocument_setId", homeCommunityId),
				ReferenceId.class);

		getDocumentEntry().getReferenceIdList().add(referenceId);

	}

	public String createCxi(Identificator id, String identifierTypeCode, String homeCommunityId) {
		StringBuilder sb = new StringBuilder();
		if (id != null && id.getExtension() != null) {
			sb.append(id.getExtension());
		}
		sb.append("^^^");
		if (id != null && id.getRoot() != null) {
			sb.append("&");
			sb.append(id.getRoot());
			sb.append("&ISO");
		}
		sb.append("^");
		sb.append(identifierTypeCode);
		sb.append("^");

		if (homeCommunityId != null) {
			sb.append("&");
			sb.append(homeCommunityId);
			sb.append("&ISO");
		}

		return sb.toString();
	}

	public void setServiceEventStartTime(ZonedDateTime startDate) {
		if (startDate != null) {
			getDocumentEntry().setServiceStartTime(new Timestamp(startDate, null));
		}
	}

	public void setServiceEventStopTime(ZonedDateTime stopDate) {
		if (stopDate != null) {
			getDocumentEntry().setServiceStopTime(new Timestamp(stopDate, null));
		}
	}

	public void setServiceEventCode(List<org.husky.common.model.Code> codes) {
		if (codes != null && !codes.isEmpty()) {
			for (org.husky.common.model.Code eventCode : codes) {
				if (eventCode != null) {
					getDocumentEntry().getEventCodeList().add(XdsMetadataUtil.convertEhcCodeToCode(eventCode));
				}
			}
		}
	}

	public void setServiceEventCode(org.husky.common.model.Code eventCode) {
		if (eventCode != null) {
			getDocumentEntry().getEventCodeList().add(XdsMetadataUtil.convertEhcCodeToCode(eventCode));
		}
	}

	/**
	 * Adds the confidentialityCode code (e.g. 'N' for 'normal')
	 *
	 * @param code confidentiality code
	 */
	public void addConfidentialityCodeHl7Cdar2(ConfidentialityCode code) {
		if (code != null) {
			super.addConfidentialityCode(code.getCode());
		}
	}

	/**
	 * Gets the parent document. All information relevant for the parent document
	 * have to be set here.
	 *
	 * @return parent document.
	 *
	 */
	public Identificator getParentDocumentId() {
		return this.parentDocumentId;
	}

	/**
	 * Gets the parent document type. All information relevant for the parent
	 * document have to be set here.
	 *
	 * @return parent document type.
	 *
	 */
	public AssociationType getParentDocumentType() {
		return this.parentDocumentType;
	}

	/**
	 * Gets all patient ids.
	 *
	 * @return patientId as Identificator
	 */
	public List<Identificator> getPatientIdsHl7Cdar2() {
		return patientIds;
	}

	public void setLegalAuthenticator(org.husky.common.model.Person legalAuthenticator) {
		if (legalAuthenticator != null) {
			getDocumentEntry().setLegalAuthenticator(legalAuthenticator.getIpfPerson());
		}
	}

	public void setMetadata(DocumentMetadataAt metaData) {
		super.setMetadata(metaData);

		setLegalAuthenticator(metaData.getLegalAuthenticator());
		setServiceEventCode(metaData.getServiceEventCode());
		setServiceEventStartTime(metaData.getServiceEventStartTime());
		setServiceEventStopTime(metaData.getServiceEventStopTime());
	}

}
