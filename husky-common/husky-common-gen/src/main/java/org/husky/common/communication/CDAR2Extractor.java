/*
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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */
package org.husky.common.communication;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.xml.bind.JAXBElement;

import org.husky.common.enums.AdministrativeGender;
import org.husky.common.hl7cdar2.AD;
import org.husky.common.hl7cdar2.AdxpAdditionalLocator;
import org.husky.common.hl7cdar2.AdxpCity;
import org.husky.common.hl7cdar2.AdxpCountry;
import org.husky.common.hl7cdar2.AdxpHouseNumber;
import org.husky.common.hl7cdar2.AdxpPostalCode;
import org.husky.common.hl7cdar2.AdxpState;
import org.husky.common.hl7cdar2.AdxpStreetAddressLine;
import org.husky.common.hl7cdar2.AdxpStreetName;
import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.EnFamily;
import org.husky.common.hl7cdar2.EnGiven;
import org.husky.common.hl7cdar2.EnPrefix;
import org.husky.common.hl7cdar2.EnSuffix;
import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.IVXBTS;
import org.husky.common.hl7cdar2.ON;
import org.husky.common.hl7cdar2.PN;
import org.husky.common.hl7cdar2.POCDMT000040AssignedAuthor;
import org.husky.common.hl7cdar2.POCDMT000040AssignedEntity;
import org.husky.common.hl7cdar2.POCDMT000040Author;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.common.hl7cdar2.POCDMT000040DocumentationOf;
import org.husky.common.hl7cdar2.POCDMT000040Organization;
import org.husky.common.hl7cdar2.POCDMT000040Patient;
import org.husky.common.hl7cdar2.POCDMT000040PatientRole;
import org.husky.common.hl7cdar2.POCDMT000040RecordTarget;
import org.husky.common.hl7cdar2.POCDMT000040ServiceEvent;
import org.husky.common.hl7cdar2.QTY;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.hl7cdar2.TS;
import org.husky.common.utils.DateUtil;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Address;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssigningAuthority;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Author;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.PatientInfo;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Person;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Telecom;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.XcnName;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.XpnName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Extracts XDS Document Entry Metadata from generic CDA R2 document
 * 
 * @author <a href="mailto:seknoop@us.ibm.com">Sarah Knoop</a>
 *
 */
public class CDAR2Extractor {

	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(CDAR2Extractor.class);

	/**
	 * Map between CDA R2 Administrative Gender codes and HL7v2.5 Table
	 * 001(Administrative Sex). Keys are CDAR2 AdministrativeGender object literal
	 * string representations and values are corresponding HL7v2.5 gender code
	 * values as strings.
	 */
	private static final Map<String, String> ADMIN_GENDER_TABLE_001;
	static {
		ADMIN_GENDER_TABLE_001 = new HashMap<>();
		ADMIN_GENDER_TABLE_001.put(AdministrativeGender.MALE_CODE, "M");
		ADMIN_GENDER_TABLE_001.put(AdministrativeGender.FEMALE_CODE, "F");
		ADMIN_GENDER_TABLE_001.put(AdministrativeGender.UNDIFFERENTIATED_CODE, "O");
	}

	/** CDA R2 document object */
	protected POCDMT000040ClinicalDocument cda;

	/**
	 * Loads CDA Document
	 * 
	 * @param cda the CDA R2 document to extract metadata from for the document
	 *            entry metadata. Cannot be null.
	 */
	public CDAR2Extractor(POCDMT000040ClinicalDocument cda) {
		this.cda = cda;
	}

	/**
	 * Entry point to invoke extraction process. <br>
	 * NOTES:
	 * <li>1. Only the first ClinicalDocument/documentationOf instance will be
	 * considered for it's ServiceEvent time to fill values for serviceStartTime and
	 * serviceStopTime</li>
	 * <li>2. Only the first ClinicalDocument/recordTarget instance will be
	 * considered for sourcePatientId (for which only the first patientRole/id on
	 * it's list will be taken) and sourcePatientInfo .</li>
	 * <li>3. XDS metadata does not accept CX types that have more or fewer
	 * components than CX.1, CX.4.2,CX.4.3. Other corresponding componets will not
	 * be extracted.</li>
	 * <li>4. XDS metadata validation for 2007 Connectathon will not accept DTM
	 * types beyond precision of YYYYMMDDHHMMSS. Precision has been truncated on
	 * values that include fractional seconds or time zone corrections</li>
	 * <li>5. XDS metadata validation for 2007 Connectathon will not accept
	 * SourcePatientInfo beyond local patient ids, patient name, address, birthdate
	 * and gender. Other patient info in the CDA that corresponds to source patient
	 * info will not be extracted.</li>
	 */
	public DocumentEntry extract() throws MetadataExtractionException {
		logger.info("BEGIN CDAR2Extractor.extract()");

		if (cda == null) {
			logger.error("CDA is null, cannot execute extraction.");
			throw new MetadataExtractionException("CDA is null, cannot execute extraction.");
		}

		// ***************** create target object *******************
		var docEntry = new DocumentEntry();

		// ** extract authorInstitution, authorPerson,authorRole, authorSpeciality **
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.author(s)");
		}
		List<Author> authors = extractAuthors();
		if (authors != null) {
			docEntry.getAuthors().addAll(authors);
		}

		// ******************** extract classCode *********************
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.classCode");
		}
		var classCode = extractClassCode();
		if (classCode != null) {
			docEntry.setClassCode(classCode);
		}

		// ******************** extract confidentialityCode **************
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.confidentialityCode");
		}
		List<Code> confidentialityCodes = extractConfidentialityCodes();
		if (confidentialityCodes != null) {
			docEntry.getConfidentialityCodes().addAll(confidentialityCodes);
		}

		// ********************** extract creation time ************************
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.creationTime");
		}
		Timestamp creationTime = extractCreationTime();
		if (creationTime != null) {
			docEntry.setCreationTime(creationTime);
		}

		// ******** extract healthCareFacilityType and practiceSetting code ************
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.healthcareFacilityCode");
		}
		var hcfc = extractHealthCareFacilityTypeCode();
		if (hcfc != null) {
			docEntry.setHealthcareFacilityTypeCode(hcfc);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.practiceSettingCode");
		}
		var psc = extractPracticeSettingCode();
		if (psc != null) {
			docEntry.setPracticeSettingCode(psc);
		}

		// ******************** extract languageCode ********************
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.languageCode");
		}
		String langCode = extractLanguageCode();
		if (langCode != null) {
			docEntry.setLanguageCode(langCode);
		}

		// ******************** extract legalAuthenticator ********************
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.legalAuthenticator");
		}
		Person legalAuth = extractLegalAuthenticator();
		if (legalAuth != null) {
			docEntry.setLegalAuthenticator(legalAuth);
		}

		// ************* extract serviceStartTime and serviceStopTime ******
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.serviceStartTime");
		}
		Timestamp startTime = extractServiceStartTime();
		if (startTime != null) {
			docEntry.setServiceStartTime(startTime);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.serviceStopTime");
		}
		Timestamp stopTime = extractServiceStopTime();
		if (stopTime != null) {
			docEntry.setServiceStopTime(stopTime);
		}

		// ******** extract sourcePatientId and sourcePatientInfo *********
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.sourcePatientId");
		}
		Identifiable sourcePatientId = extractSourcePatientId();
		if (sourcePatientId != null) {
			docEntry.setSourcePatientId(sourcePatientId);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.sourcePatientInfo");
		}
		var patientInfo = extractSourcePatientInfo();
		if (patientInfo != null) {
			docEntry.setSourcePatientInfo(patientInfo);
		}

		// ******************** extract title ********************
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.title");
		}
		LocalizedString title = extractTitle();
		if (title != null) {
			docEntry.setTitle(title);
		}

		// ******************** extract typeCode ********************
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.typeCode");
		}
		var typeCode = extractTypeCode();
		if (typeCode != null) {
			docEntry.setTypeCode(typeCode);
		}

		// ******************** extract uniqueId ********************
		if (logger.isDebugEnabled()) {
			logger.debug("Extracting DocumentEntry.uniqueId");
		}
		String uniqueId = extractUniqueId();
		if (uniqueId != null) {
			docEntry.setUniqueId(uniqueId);
		}

		logger.info("DONE");
		return docEntry;
	}

/////////////////////////////////////////////////////////////////////////////
// Implementations for DocumentEntryElementExtractor interface
/////////////////////////////////////////////////////////////////////////////

	/**
	 * Extracts the relevant authorInstitution, authorPerson, authorRole and
	 * authorSpeciality information from the author list in the CDA: <br>
	 * ClinicalDocument/author/assignedAuthor/id and <br>
	 * ClinicalDocument/author/assignedAuthor/assignedPerson/name <br>
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractAuthors()
	 */
	public List<Author> extractAuthors() {
		if (!atLeastOne(cda.getAuthor())) {
			return new ArrayList<>();
		} else {
			Iterator<POCDMT000040Author> i = cda.getAuthor().iterator();
			// SEK - extractor is back to supporting multiple authors as of 10/20/2011
			List<Author> authorList = new ArrayList<>();
			while (i.hasNext()) {
				POCDMT000040Author author = i.next();
				POCDMT000040AssignedAuthor aAuth = author.getAssignedAuthor();
				if (aAuth != null && aAuth.getAssignedAuthoringDevice() == null) {
					// make sure that we have an author person and not authoring device
					authorList.add(extractAuthor(author));
				}
			} // end iterator
			return authorList;
		} // end else
	}

	private Author extractAuthor(POCDMT000040Author author) {
		var aut = new Author();

		if (author == null) {
			return aut;
		}

		POCDMT000040AssignedAuthor aAuth = author.getAssignedAuthor();

		// check for author components and add
		var person = extractAuthorPerson(aAuth);
		if (person != null) {
			logger.debug("found author person");
			aut.setAuthorPerson(person);
		}
		Organization inst = extractAuthorInstitution(aAuth.getRepresentedOrganization());
		if (inst != null) {
			logger.debug("found author institution");
			aut.getAuthorInstitution().add(inst);
		}
		Identifiable role = extractAuthorRole(author.getFunctionCode());
		if (role != null) {
			logger.debug("found author role");
			aut.getAuthorRole().add(role);
		}
		Identifiable speciality = extractAuthorSpeciality(aAuth.getCode());
		if (speciality != null) {
			logger.debug("found author specialty");
			aut.getAuthorSpecialty().add(speciality);
		}
		logger.debug("looking for telcom in:" + aAuth.getTelecom().toString());
		if (!aAuth.getTelecom().isEmpty()) {
			logger.debug("telcom not empty");
			Iterator<TEL> j = aAuth.getTelecom().iterator();
			while (j.hasNext()) {

				var telcom = extractAuthorTelecommunication(j.next());
				if (telcom != null) {
					logger.debug("found author telcom");
					aut.getAuthorTelecom().add(telcom);
				}
			}

		}

		return aut;

	}

	/**
	 * CDA R2 document header does not contain information corresponding to
	 * availablity status metadata.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractAvailabilityStatus()
	 */
	public AvailabilityStatus extractAvailabilityStatus() {
		logger.info("CDA R2 document header does "
				+ "not contain information corresponding to availablity status metadata.");
		return null;
	}

	/**
	 * Extracts the relevant classCode information from the CDA:
	 * ClinicalDocument/code. Implementation consistent with PCC TF-2 Medical
	 * Document Binding to XDS, XDM and XDR. <br>
	 * Note: typeCode and classCode data sources are the same in the CDA
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractClassCode()
	 */
	public Code extractClassCode() {
		if (cda.getCode() == null) {
			return null;
		}

		return map(cda.getCode());
	}

	/**
	 * CDA R2 document header does not contain information corresponding to comments
	 * metadata.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractComments()
	 */
	public LocalizedString extractComments() {
		logger.info("CDA R2 document header does " + "not contain information corresponding to comments metadata.");
		return null;
	}

	/**
	 * Extracts the relevant confidentialityCodes information from the CDA:
	 * ClinicalDocument/confidentialityCode. Implementation consistent with PCC TF-2
	 * Medical Document Binding to XDS, XDM and XDR.
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractConfidentialityCode()
	 */
	public List<Code> extractConfidentialityCodes() {
		logger.info("DocumentEntry.confidentialityCode should be set explicitly");
		return new LinkedList<>();
	}

	/**
	 * Extracts the relevant creationTime information from the CDA:
	 * ClinicalDocument/effectiveTime. This time is to be in UTC, but without the
	 * timezone offset or fractional seconds: [[[[[YYYY]MM]DD]HH]mm]ss]. Thus, this
	 * time is assumed to be in GMT. So, if the timestamp in the corresponding CDA
	 * element contains the timezone offset, this method will convert the timestamp
	 * to GMT. If the timezone offset is ommitted, then the timestamp is assumed to
	 * be in GMT. Implementation consistent with PCC TF-2 Medical Document Binding
	 * to XDS, XDM and XDR.
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractCreationTime()
	 */
	public Timestamp extractCreationTime() {
		if (cda.getEffectiveTime() == null) {
			return null;
		}

		if (cda.getEffectiveTime().getValue() == null) {
			return null;
		} else {
			return map(cda.getEffectiveTime());
		}
	}

	/**
	 * DocumentEntry.entryUUID is an XDS specific attribute and outside the scope of
	 * any CDA R2 document. Thus, it cannot be extracted.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractEntryUUID()
	 */
	public String extractEntryUUID() {
		logger.info("DocumentEntry.entryUUID "
				+ "is an XDS specific attribute and outside the scope of any CDA R2 document. \nThus, it cannot be"
				+ " extracted.");
		return "";
	}

	/**
	 * This extraction routine, at this point, does not attempt to extract event
	 * code metadata from a generic CDA R2 document.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractEventCodes()
	 */
	public List<Code> extractEventCodes() {
		logger.info("This extraction routine, at this point,"
				+ "does not attempt to extract event code metadata from a generic CDA R2 document.");
		return new LinkedList<>();
	}

	/**
	 * This extraction routine, at this point, does not attempt to extract extension
	 * metadata from a generic CDA R2 document.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractExtensionss()
	 */
	public Map<String, List<String>> extractExtensions() {
		logger.info("This extraction routine, at this point,"
				+ "does not attempt to extract extension metadata from a generic CDA R2 document.");
		return null;
	}

	/**
	 * DocumentEntry.formatCode is an XDS specific attribute and outside the scope
	 * of any CDA R2 document. Thus, it cannot be extracted.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractFormatCode()
	 */
	public Code extractFormatCode() {
		logger.info("DocumentEntry.formatCode "
				+ "is an XDS specific attribute and outside the scope of any CDA R2 document. \nThus, it cannot be"
				+ " extracted.");
		return null;
	}

	/**
	 * DocumentEntry.hash is a comptuted value and outside the scope of any CDA R2
	 * document. Thus, it cannot be extracted.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractHash()
	 */
	public String extractHash() {
		logger.info("DocumentEntry.hash "
				+ "is a comptuted value and outside the scope of any CDA R2 document. \nThus, it cannot be"
				+ " extracted.");
		return "";
	}

	/**
	 * Extracts the relevant healthcareFacilityTypeCode information from the CDA:
	 * ClinicalDocument/componentOf/encompassingEncounter/location/code. Per the CDA
	 * specification this code, when present shall be consistent with
	 * ClinicalDocument/code. Thus, implementation consistent with PCC TF-2 Medical
	 * Document Binding to XDS, XDM and XDR. <br>
	 * Note: healthcareFacilityTypeCode and practiceSettingCode data sources are the
	 * same in the CDA
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractHealthCareFacilityTypeCode()
	 */
// FIXME Implementation ALMOST consistent with PCC TF-2 Medical Document Binding
// * to XDS, XDM and XDR.
	public Code extractHealthCareFacilityTypeCode() {
		if (cda.getComponentOf() != null && cda.getComponentOf().getEncompassingEncounter() != null
				&& cda.getComponentOf().getEncompassingEncounter().getLocation() != null
				&& cda.getComponentOf().getEncompassingEncounter().getLocation().getHealthCareFacility() != null
				&& cda.getComponentOf().getEncompassingEncounter().getLocation().getHealthCareFacility()
						.getCode() != null) {
			CE facility = cda.getComponentOf().getEncompassingEncounter().getLocation().getHealthCareFacility()
					.getCode();

			return map(facility);
		}
		return null;
	}

	/**
	 * Extracts the relevant languageCode information from the CDA:
	 * ClinicalDocument/languageCode
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractLanguageCode()
	 */
	public String extractLanguageCode() {
		return cda.getLanguageCode().getCode();
	}

	/**
	 * Extracts the relevant legalAuthenticator information from the CDA:
	 * ClinicalDocument/legalAuthenticator/assignedEntity/id and
	 * ClinicalDocument/legalAuthenticator/assignedEntity/assignedPerson/name <br>
	 * NOTES:
	 * <li>1. Only the first ClinicalDocument/legalAuthenticator/assignedEntity/id
	 * instance and first
	 * ClinicalDocument/legalAuthenticator/assignedEntity/assignedPerson/name
	 * instance will be considered for values for the legal authenticator XCN</li>
	 * <li>2. Implementation consistent with PCC TF-2 Medical Document Binding to
	 * XDS, XDM and XDR.</li>
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractLanguageCode()
	 */
	public Person extractLegalAuthenticator() {
		if (cda.getLegalAuthenticator() != null && cda.getLegalAuthenticator().getAssignedEntity() != null) {
			POCDMT000040AssignedEntity auth = cda.getLegalAuthenticator().getAssignedEntity();
			var idNull = false;

			// XCN.1, XCN.9.1, XCN.9.2
			if (!atLeastOne(auth.getId())) {
				idNull = true;
			} else {
				if (auth.getId().get(0).getExtension() == null && auth.getId().get(0).getRoot() != null) {
					auth.getId().get(0).setExtension(auth.getId().get(0).getRoot());
					auth.getId().get(0).setRoot(null);
				}
			}

			// XCN.2 through XCN.6
			if (auth.getAssignedPerson() == null || !atLeastOne(auth.getAssignedPerson().getName())) {
				if (idNull) {
					return null;
				}

				return map(auth.getId().get(0), null);
			} else {
				if (idNull) {
					return map(null, auth.getAssignedPerson().getName().get(0));
				}
				return map(auth.getId().get(0), auth.getAssignedPerson().getName().get(0));
			}
		}

		return null;

	}

	/**
	 * DocumentEntry.mimeType is an XDS specific attribute and outside the scope of
	 * any CDA R2 document. Thus, it cannot be extracted.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractMimeType()
	 */
	public String extractMimeType() {
		logger.info("DocumentEntry.mimeType"
				+ "is an XDS specific attribute and outside the scope of any CDA R2 document. \nThus, it cannot be"
				+ " extracted.");
		return null;
	}

	/**
	 * DocumentEntry.parentDocument expresses the id and relationship of a parent
	 * document to this CDA document in the XDS Regisry. This is not necessairly the
	 * same parent document that is documented within the CDA. Thus, this
	 * information is not extracted.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractParentDocument()
	 */
	public Identifiable extractParentDocument() {
		logger.info("DocumentEntry.parentDocument expresses the id and relationship of a parent document to this CDA"
				+ " document in the XDS Regisry.\nThis is not necessairly the same parent document that is"
				+ " documented within the CDA. \nThus, this information is not" + " extracted.");
		return null;
	}

	/**
	 * DocumentEntry.patientId expresses the Affinity Domain level patient id used
	 * in the XDS Regisry. In all cases, this is not necessairly the same patientId
	 * that is documented within the CDA. Thus, this information is not extracted.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractPatientId()
	 */
	public Identifiable extractPatientId() {
		logger.info("DocumentEntry.patientId expresses the Affinity Domain level patient id used"
				+ " in the XDS Regisry.\nIn all cases, this is not necessairly the same patientId that is"
				+ " documented within the CDA. \nThus, this information is not" + " extracted.");
		return null;
	}

	/**
	 * DocumentEntry.practiceSettingCode is recommended to be supplied by the
	 * document source from an established vocabulary approved by the affinity
	 * domain, such as that described by the Subject Matter Domain in LOINC. Thus
	 * this information is not extracted. <br>
	 * Note: Implementation consistent with PCC TF-2 Medical Document Binding to
	 * XDS, XDM and XDR.
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractPracticeSettingCode()
	 */
	public Code extractPracticeSettingCode() {
		logger.info("DocumentEntry.practiceSettingCode is recommended to be supplied by the document source"
				+ " from an established vocabulary approved by the affinity domain, \n such as that described by the Subject Matter Domain in LOINC."
				+ " \nThus, this information is not extracted.");
		return null;
	}

	/**
	 * DocumentEntry.repositoryUniqueId is an XDS specific attribute and outside the
	 * scope of any CDA R2 document. Thus, it cannot be extracted.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractRepositoryUniqueId()
	 */
	public String extractRepositoryUniqueId() {
		logger.info("DocumentEntry.repositoryUniqueId"
				+ "is an XDS specific attribute and outside the scope of any CDA R2 document. \nThus, it cannot be"
				+ " extracted.");
		return null;
	}

	/**
	 * Extracts the relevant serviceStartTime information from the CDA:
	 * ClinicalDocument/documentationOf/serviceEvent/effectiveTime This time is to
	 * be in UTC, but without the timezone offset or fractional seconds:
	 * [[[[[YYYY]MM]DD]HH]mm]ss]. Thus, this time is assumed to be in GMT. So, if
	 * the timestamp in the corresponding CDA element contains the timezone offset,
	 * this method will convert the timestamp to GMT. If the timezone offset is
	 * ommitted, then the timestamp is assumed to be in GMT. NOTES:
	 * <li>1. Finds the minimum low time among
	 * ClinicalDocument/documentationOf/serviceEvent/effectiveTime instance will be
	 * for serviceStartTime.</li>
	 * <li>2. XDS metadata validation for 2007 Connectathon will not accept DTM
	 * types beyond precision of YYYYMMDDHHMMSS. Precision has been truncated on
	 * values that include fractional seconds or time zone corrections. Time is in
	 * UTC.</li>
	 * <li>3. Implementation consistent with PCC TF-2 Medical Document Binding to
	 * XDS, XDM and XDR.</li>
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractServiceStartTime()
	 */
	public Timestamp extractServiceStartTime() {
		if (!atLeastOne(cda.getDocumentationOf())) {
			return null;
		} else {
			Iterator<POCDMT000040DocumentationOf> i = this.cda.getDocumentationOf().iterator();
			Timestamp minLowTime = null;
			while (i.hasNext()) {
				POCDMT000040DocumentationOf docOf = i.next();
				POCDMT000040ServiceEvent sEvent = docOf.getServiceEvent();
				if (sEvent != null && sEvent.getEffectiveTime() != null) {
					minLowTime = extractMinLowTime(sEvent.getEffectiveTime(), minLowTime);
				} // end else
			} // end loop
			return minLowTime;
		}

	}

	private Timestamp extractMinLowTime(IVLTS range, Timestamp minLowTime) {
		if (range == null || range.getRest() == null) {
			return minLowTime;
		}

		Timestamp lowTime = null;
		for (JAXBElement<? extends QTY> qty : range.getRest()) {
			if (qty != null && qty.getName() != null && qty.getName().getLocalPart().equalsIgnoreCase("low")
					&& qty.getValue() instanceof IVXBTS) {
				// determine if lowTime found is minimum
				lowTime = map(((IVXBTS) qty.getValue()));
			}
		}

		if (lowTime != null && (minLowTime == null || lowTime.getDateTime().isBefore(minLowTime.getDateTime()))) {
			minLowTime = lowTime;
		}

		return minLowTime;
	}


	/**
	 * Extracts the relevant serviceStopTime information from the CDA:
	 * ClinicalDocument/documentationOf/serviceEvent/effectiveTime This time is to
	 * be in UTC, but without the timezone offset or fractional seconds:
	 * [[[[[YYYY]MM]DD]HH]mm]ss]. Thus, this time is assumed to be in GMT. So, if
	 * the timestamp in the corresponding CDA element contains the timezone offset,
	 * this method will convert the timestamp to GMT. If the timezone offset is
	 * ommitted, then the timestamp is assumed to be in GMT. <br>
	 * NOTES:
	 * <li>1. Finds the maximum high time among
	 * ClinicalDocument/documentationOf/serviceEvent/effectiveTime instance will be
	 * for serviceStartTime.</li>
	 * <li>2. XDS metadata validation for 2007 Connectathon will not accept DTM
	 * types beyond precision of YYYYMMDDHHMMSS. Precision has been truncated on
	 * values that include fractional seconds or time zone corrections. Time is in
	 * UTC.</li>
	 * <li>3.Implementation consistent with PCC TF-2 Medical Document Binding to
	 * XDS, XDM and XDR.</li>
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractServiceStopTime()
	 */
	public Timestamp extractServiceStopTime() {
		if (!atLeastOne(cda.getDocumentationOf())) {
			return null;
		} else {
			Iterator<POCDMT000040DocumentationOf> i = this.cda.getDocumentationOf().iterator();
			Timestamp maxHighTime = null;
			while (i.hasNext()) {
				POCDMT000040DocumentationOf docOf = i.next();
				POCDMT000040ServiceEvent sEvent = docOf.getServiceEvent();
				if (sEvent != null && sEvent.getEffectiveTime() != null) {
					maxHighTime = extractMaxHighTime(sEvent.getEffectiveTime(), maxHighTime);
				}
			}
			return maxHighTime;
		}

	}

	private Timestamp extractMaxHighTime(IVLTS range, Timestamp maxHighTime) {
		if (range == null || range.getRest() == null) {
			return maxHighTime;
		}

		Timestamp highTime = null;
		for (JAXBElement<? extends QTY> qty : range.getRest()) {
			if (qty != null && qty.getName() != null && qty.getName().getLocalPart().equalsIgnoreCase("high")
					&& qty.getValue() instanceof IVXBTS) {
				highTime = map(((IVXBTS) qty.getValue()));
			}
		}

		// determine if highTime found is maximum
		if (highTime != null && (maxHighTime == null || highTime.getDateTime().isAfter(maxHighTime.getDateTime()))) {
			maxHighTime = highTime;
		}

		return maxHighTime;
	}


	/**
	 * DocumentEntry.size is a comptuted value and outside the scope of any CDA R2
	 * document. Thus, it cannot be extracted.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractSize()
	 */
	public Long extractSize() {
		logger.info("DocumentEntry.size "
				+ "is a comptuted value and outside the scope of any CDA R2 document. \nThus, it cannot be"
				+ " extracted.");
		return null;
	}

	/**
	 * Extracts the relevant sourcePatientId information from the CDA:
	 * ClinicalDocument/recordTarget/patientRole/id <br>
	 * NOTES:
	 * <li>1. Only the first ClinicalDocument/recordTarget instance will be
	 * considered for sourcePatientId (for which only the first patientRole/id on
	 * it's list will be taken) and sourcePatientInfo .</li>
	 * <li>2. XDS metadata does not accept CX types that have more or fewer
	 * components than CX.1, CX.4.2,CX.4.3. Other corresponding componets will not
	 * be extracted.</li>
	 * <li>3. Implementation consistent with PCC TF-2 Medical Document Binding to
	 * XDS, XDM and XDR.</li>
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractSourcePatientId()
	 */
	public Identifiable extractSourcePatientId() {
		if (!atLeastOne(cda.getRecordTarget())) {
			return null;
		} else {
			POCDMT000040RecordTarget target = cda.getRecordTarget().get(0);
			if (target.getPatientRole() == null) {
				return null;
			} else {
				POCDMT000040PatientRole patient = target.getPatientRole();
				if (!atLeastOne(patient.getId())) {
					return null;
				} else {
					II pId = patient.getId().get(0);
					return map(pId);
				}
			}
		}
	}

	/**
	 * Extracts the relevant sourcePatientInfo information from the CDA:
	 * ClinicalDocument/recordTarget/patientRole <br>
	 * NOTES:
	 * <li>1. Only the first ClinicalDocument/recordTarget instance will be
	 * considered for sourcePatientId (for which only the first patientRole/id on
	 * it's list will be taken) and sourcePatientInfo .</li>
	 * <li>2. Extracts all id of the list of ids for PatientRole to PID-3 and the
	 * PatientRole/Patient/id</li>
	 * <li>3. XDS metadata does not accept CX types that have more or fewer
	 * components than CX.1, CX.4.2,CX.4.3. Other corresponding componets will not
	 * be extracted.</li>
	 * <li>4. XDS metadata validation for 2007 Connectathon will not accept
	 * SourcePatientInfo beyond local patient ids, patient name, address, birthdate
	 * and gender. Other patient info in the CDA that corresponds to source patient
	 * info will not be extracted.</li>
	 * <li>5.Only the first address will be considered for extraction, only the
	 * first subelements of the AD type will be considered for extraction.</li>
	 * <li>6. Implementation consistent with PCC TF-2 Medical Document Binding to
	 * XDS, XDM and XDR.</li>
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractSourcePatientInfo()
	 */
	public PatientInfo extractSourcePatientInfo() {
		if (!atLeastOne(cda.getRecordTarget())) {
			return null;
		}

		POCDMT000040RecordTarget target = cda.getRecordTarget().get(0);
		if (target.getPatientRole() == null) {
			return null;
		}

		POCDMT000040PatientRole patient = target.getPatientRole();
		var sourceInfo = new PatientInfo();

		// PID-3: patientIdentifier list (from PatientRole/id)
		if (atLeastOne(patient.getId())) {
			List<Identifiable> ids = extractPid3(patient.getId());
			for(Identifiable id: ids) {
				sourceInfo.getIds().add(id);
			}
		}

		// PID-11: patient Address
		if (atLeastOne(patient.getAddr())) {
			// call pid11 method
			Address xad = extractPid11(patient.getAddr().get(0));

			if (xad != null && xad.getStreetAddress() != null && xad.getCity() != null
					&& xad.getStateOrProvince() != null && xad.getZipOrPostalCode() != null
					&& xad.getCountry() != null) {
				sourceInfo.getAddresses().add(xad);
			}
		} else {
			var xad = new Address();
			xad.setStreetAddress("");
			sourceInfo.getAddresses().add(xad);
		}

		// Rest of PID 3, PID 5, PID 7 and PID 8
		if (patient.getPatient() != null) {
			POCDMT000040Patient p = patient.getPatient();
			// PID-3: patientIdentifier list (from PatientRole/Patient/id)
			if (p.getId() != null) {
				List<Identifiable> ids = extractPid3(List.of(p.getId()));
				if(ids != null && !ids.isEmpty()) {
					sourceInfo.getIds().add(ids.get(0));
				}
			}

			// PID-5: patientName list
			if (atLeastOne(p.getName())) {
				List<XpnName> names = extractPid5(p.getName());
				for (XpnName name : names) {
					sourceInfo.getNames().add(name);
				}
			} else {
				var xpn = new XpnName();
				xpn.setFamilyName("");
				sourceInfo.getNames().add(xpn);
			}

			// PID-7: patientDateOfBirth
			sourceInfo.setDateOfBirth(extractPid7(p.getBirthTime()));
			// PID-8: patientSex
			sourceInfo.setGender(extractPid8(p.getAdministrativeGenderCode()));
		} else {
			// Add empty PID-5: patientName list
			var xpn = new XpnName();
			xpn.setFamilyName("");
			sourceInfo.getNames().add(xpn);
			// Add empty PID-7: patientDateOfBirth
			sourceInfo.setDateOfBirth("");
			// Add empty PID-8: patientSex
			sourceInfo.setGender("");
		}

		return sourceInfo;

	}

	/**
	 * Extracts the relevant title, Implementation consistent with PCC TF-2 Medical
	 * Document Binding to XDS, XDM and XDR. information from the CDA:
	 * ClinicalDocument/title
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractTitle()
	 */
	public LocalizedString extractTitle() {
		if (cda.getTitle() == null) {
			return null;
		}

		var dName = new LocalizedString();
		dName.setValue(cda.getTitle().xmlContent);
		return dName;
	}

	/**
	 * Extracts the relevant typeCode. Implementation consistent with PCC TF-2
	 * Medical Document Binding to XDS, XDM and XDR. information from the CDA:
	 * ClinicalDocument/code <br>
	 * Note: typeCode and classCode data sources are the same in the CDA
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractTypeCode()
	 */
	public Code extractTypeCode() {
		return extractClassCode();
	}

	/**
	 * Extracts the relevant uniqueId. Implementation consistent with PCC TF-2
	 * Medical Document Binding to XDS, XDM and XDR. information from the CDA:
	 * ClinicalDocument/id (format is id@root^id@extension)
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractUniqueId()
	 */
	public String extractUniqueId() {
		if (cda.getId() == null) {
			return null;
		}

		if (cda.getId().getRoot() == null) {
			// no root
			return null;
		} else if (cda.getId().getExtension() == null) {
			// no extension, but there is a root
			return cda.getId().getRoot();
		}

		// return root^extension
		return cda.getId().getRoot() + "^" + cda.getId().getExtension();
	}

	/**
	 * DocumentEntry.URI is a comptuted value and outside the scope of any CDA R2
	 * document. Thus, it cannot be extracted.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractURI()
	 */
	public String extractURI() {
		logger.info("DocumentEntry.URI "
				+ "is a comptuted value and outside the scope of any CDA R2 document. \nThus, it cannot be"
				+ " extracted.");
		return null;
	}

/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
// Support functions for extractAuthors() function
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////

	/**
	 * Extracts authorInstitution from CDAR2
	 * <li>NOTES:</li>
	 * <li>1. only the first organization name of the list is extracted and
	 * processed as XON.1</li>
	 * <li>2. only the first id of the list of ids is extracted for XON.3 and
	 * XON.6.1, XON.6.2 (pending resolution to IT CP 316)</li>
	 * <li>3. Implementation consistent with PCC TF-2 Medical Document Binding to
	 * XDS, XDM and XDR, pending resolution to ITI CP 316.</li>
	 * 
	 * @param o ClinicalDocument/author/assignedAuthor/representedOrganization of
	 *          type Organization expected.
	 * @return Returns null if institution cannot be extracted
	 * @see com.ibm.ihii.transformation.xds.metadata.MetadataExtractor#extractAuthorInstitution(java.lang.Object)
	 */
	private Organization extractAuthorInstitution(
			POCDMT000040Organization org) {
		if (org == null) {
			return null;
		}

		Organization retVal = null;
		var idNull = false;
		var nameNull = false;

		// XON.3 and XON.6
		if (!atLeastOne(org.getId())) {
			idNull = true;
		}

		// XON.1
		if (!atLeastOne(org.getName())) {
			nameNull = true;
		}

		if (idNull) {
			retVal = map(org.getName().get(0), null);
		} else if (nameNull) {
			retVal = map(null, org.getId().get(0));
		} else {
			retVal = map(org.getName().get(0), org.getId().get(0));
		}

		return retVal;

	}

	/**
	 * Extracts authorPerson from CDAR2 of type AssignedAuthor expected.
	 * <li>NOTES:</li>
	 * <li>1. only the first id of the list of ids is extracted for XCN.1, XCN.9.1,
	 * XCN.9.2</li>
	 * <li>2. only the first person name of the assignedAuthor/assignedPerson name
	 * list (and first entries in the sub lists) are extracted and processed for
	 * XCN.2 to XCN.6</li>
	 * <li>3. Implementation consistent with PCC TF-2 Medical Document Binding to
	 * XDS, XDM and XDR</li>
	 * 
	 * @param aAuth ClinicalDocument/author/assignedAuthor/ object
	 * @return Returns null if author cannot be extracted
	 * @see com.ibm.ihii.transformation.xds.metadata.MetadataExtractor#extractAuthorPerson(java.lang.Object)
	 */
	private Person extractAuthorPerson(POCDMT000040AssignedAuthor aAuth) {
		if (aAuth == null) {
			return null;
		}
		var idNull = false;

		// XCN.1, XCN.9.1, XCN.9.2
		if (!atLeastOne(aAuth.getId())) {
			idNull = true;
		} else {
			if (aAuth.getId().get(0).getExtension() == null && aAuth.getId().get(0).getRoot() != null) {
				aAuth.getId().get(0).setExtension(aAuth.getId().get(0).getRoot());
				aAuth.getId().get(0).setRoot(null);
			}
		}
		// XCN.2 through XCN.6
		if (aAuth.getAssignedPerson() == null || !atLeastOne(aAuth.getAssignedPerson().getName())) {
			if (idNull) {
				return null;
			}
			return map(aAuth.getId().get(0), null);
		} else {
			if (idNull) {
				return map(null, aAuth.getAssignedPerson().getName().get(0));
			}
			return map(aAuth.getId().get(0), aAuth.getAssignedPerson().getName().get(0));
		}

	}

	/**
	 * Extracts authorRole from CDAR2. Implementation consistent with PCC TF-2
	 * Medical Document Binding to XDS, XDM and XDR.
	 * 
	 * @param role ClinicalDocument/author/functionCode of type CE expected
	 * @return Returns null if code cannot be extracted
	 * @see com.ibm.ihii.transformation.xds.metadata.MetadataExtractor#extractAuthorRole(java.lang.Object)
	 */
	private Identifiable extractAuthorRole(CE role) {
		if (role == null)
			return null;

		var identifiable = new Identifiable();
		if (role.getCode() == null) {
			return null;
		}

		identifiable.setId(role.getCode());

		return identifiable;
	}

	/**
	 * Extracts authorSpeciality from CDAR2. Implementation consistent with PCC TF-2
	 * Medical Document Binding to XDS, XDM and XDR.
	 * 
	 * @param o ClinicalDocument/author/assignedAuthor/code of type CE expected
	 * @return Returns null if code cannot be extracted
	 * @see com.ibm.ihii.transformation.xds.metadata.MetadataExtractor#extractAuthorSpeciality(java.lang.Object)
	 */
	private Identifiable extractAuthorSpeciality(CE spec) {
		if (spec == null)
			return null;

		var identifiable = new Identifiable();
		if (spec.getCode() == null) {
			return null;
		}

		identifiable.setId(spec.getCode());
		return identifiable;
	}

	/**
	 * Extracts authorTelecommunication from CDAR2
	 * <li>NOTES:</li>
	 * <li>1. only the first telcom is extracted
	 * 
	 * @param o ClinicalDocument/author/assignedAuthor/representedOrganization of
	 *          type Organization expected.
	 * @return Returns null if telcom cannot be extracted
	 */
	private Telecom extractAuthorTelecommunication(TEL tel) {
		if (tel == null) {
			return null;
		}
		return map(tel);
	}

	/**
	 * Extracts Pid-11 (patient address)
	 * 
	 * @param o ClinicalDocument / recordTarget / patient / addr of type AD expected
	 * @return
	 */
	private Address extractPid11(AD addr) {
		return map(addr);
	}

////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
// Support methods for extractSourcePatientInfo() - the PID segment
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
	/**
	 * Extracts Pid-3 (patient id)
	 * 
	 * @param idList ClinicalDocument/recordTarget/patient/id(s) list of type II
	 *               expected
	 * @return List of CX type ids for XDS metadata
	 */
	private List<Identifiable> extractPid3(List<II> idList) {
		Iterator<II> i = idList.iterator();
		List<Identifiable> ids = new ArrayList<>();
		while (i.hasNext()) {
			II pId = i.next();
			Identifiable cx = map(pId);
			if (cx != null) {
				ids.add(cx);
			}
		}

		return ids;
	}

	/**
	 * Extracts Pid-5 (patient name)
	 * 
	 * @param nameList ClinicalDocument / recordTarget / patient / patientPatient /
	 *                 name(s) list of type PN expected.
	 * @return list of XPN types for patient names in XDS metadata
	 */
	private List<XpnName> extractPid5(List<PN> nameList) {
		Iterator<PN> i = nameList.iterator();
		List<XpnName> names = new ArrayList<>();
		while (i.hasNext()) {
			PN name = i.next();
			XpnName xpn = map(name);
			names.add(xpn);
		}
		return names;
	}

	/**
	 * Extracts Pid-7 (patient birth day/time)
	 * 
	 * @param o ClinicalDocument / recordTarget / patient / patientPatient /
	 *          birthTime of type TS1 expected
	 * @return
	 */
	private Timestamp extractPid7(TS time) {
		if (time == null) {
			return new Timestamp();
		}

		return map(time);

	}

	/**
	 * Extracts Pid-8 (administrative sex)
	 * 
	 * @param o ClinicalDocument / recordTarget / patient / patientPatient /
	 *          administrativeGenderCode of type CE expected
	 * @return
	 */
	private String extractPid8(CE docCode) {
		if (docCode == null) {
			return "";
		}

		String gender = docCode.getCode();

		return ADMIN_GENDER_TABLE_001.get(gender);
	}

	/**
	 * Checks to see if the list has at least one element.
	 * 
	 * @param l
	 * @return false if l is null, if l.size() < 1 or if l.get(0) is null.
	 *         Otherwise, return true.
	 */
	protected boolean atLeastOne(List<?> l) {
		return l != null && !l.isEmpty() && l.get(0) != null;
	}

	/**
	 * Maps CDA R2 AD datatype to the OHT model version of the HL7 v2.5 XAD data
	 * type
	 * <li>NOTES:</li>
	 * <li>1. only the first entries in the sub lists for address parts are
	 * extracted and processed for XAD.1.1, XAD.2 through XAD.6</li>
	 * <li>2. XAD.9 is not extracted at this point due to IHE restrictions on
	 * metadata, could be enabled in the future.</li>
	 * 
	 * @param addr
	 * @return
	 */
	protected Address map(AD addr) {
		if (addr == null) {
			return null;
		}

		var xad = new Address();

		if (atLeastOne(addr.getContent())) {
			for (Serializable obj : addr.getContent()) {
				JAXBElement<?> element = (JAXBElement<?>) obj;

				// XAD.1.1
				if (element.getValue() instanceof AdxpStreetAddressLine) {
					AdxpStreetAddressLine stl = (AdxpStreetAddressLine) element.getValue();
					String txt = stl.xmlContent;
					if (txt.length() > 0) {
						xad.setStreetAddress(txt);
					}
				} else if (element.getValue() instanceof AdxpStreetName) {
					AdxpStreetName stl = (AdxpStreetName) element.getValue();
					String txt = stl.xmlContent;
					if (txt.length() > 0) {
						if (xad.getStreetAddress() != null && !xad.getStreetAddress().isEmpty()) {
							xad.setStreetAddress(txt + " " + xad.getStreetAddress());
						} else {
							xad.setStreetAddress(txt);
						}
					}
				}

				if (element.getValue() instanceof AdxpHouseNumber) {
					AdxpHouseNumber stl = (AdxpHouseNumber) element.getValue();
					String txt = stl.xmlContent;
					if (txt.length() > 0) {
						if (xad.getStreetAddress() != null && !xad.getStreetAddress().isEmpty()) {
							xad.setStreetAddress(xad.getStreetAddress() + " " + txt);
						} else {
							xad.setStreetAddress(txt);
						}
					}
				}

				// XAD.2
				if (element.getValue() instanceof AdxpAdditionalLocator) {
					AdxpAdditionalLocator stl = (AdxpAdditionalLocator) element.getValue();
					String txt = stl.xmlContent;
					if (txt.length() > 0) {
						xad.setOtherDesignation(txt);
					}
				}

				// XAD.3
				if (element.getValue() instanceof AdxpCity) {
					AdxpCity stl = (AdxpCity) element.getValue();
					String txt = stl.xmlContent;
					if (txt.length() > 0) {
						xad.setCity(txt);
					}
				}

				// XAD.4
				if (element.getValue() instanceof AdxpState) {
					AdxpState stl = (AdxpState) element.getValue();
					String txt = stl.xmlContent;
					if (txt.length() > 0) {
						xad.setStateOrProvince(txt);
					}
				}

				// XAD.5
				if (element.getValue() instanceof AdxpPostalCode) {
					AdxpPostalCode stl = (AdxpPostalCode) element.getValue();
					String txt = stl.xmlContent;
					if (txt.length() > 0) {
						xad.setZipOrPostalCode(txt);
					}
				}

				// XAD.6
				if (element.getValue() instanceof AdxpCountry) {
					AdxpCountry stl = (AdxpCountry) element.getValue();
					String txt = stl.xmlContent;
					if (txt.length() > 0) {
						xad.setCountry(txt);
					}
				}

			}
		}

		return xad;

	}

	/**
	 * Maps from document code CD (or children CE, CS1) to a CodedMetadataType
	 * 
	 * @param docCode
	 * @return
	 */
	protected Code map(CD docCode) {
		if (docCode == null) {
			return null;
		}
		// set code
		var code = new Code();
		code.setCode(docCode.getCode());

		// set display name
		if (docCode.getDisplayName() != null) {
			code.setDisplayName(new LocalizedString(docCode.getDisplayName()));
		}

		if (docCode.getCodeSystemName() != null) {
			code.setSchemeName(docCode.getCodeSystemName());
		} else {
			code.setSchemeName(docCode.getCodeSystem());
		}

		return code;
	}

	/**
	 * Maps CDA R2 II data type to components to the OHT model version of a HL7 v2.5
	 * CX data type
	 * <li>NOTES:</li>
	 * <li>1. Always sets CX.4.3 to "ISO"</li>
	 * <li>2. XDS metadata does not accept CX types that have more or fewer
	 * components than CX.1, CX.4.2,CX.4.3. Other corresponding componets will not
	 * be extracted. (ie. will not extract assigningAuthorityName attribute from II
	 * type)</li>
	 * 
	 * @param id
	 * @return
	 */
	protected Identifiable map(II id) {
		if (id == null) {
			return null;
		}

		var cx = new Identifiable();
		var assigningAuthority = new AssigningAuthority();

		// CX.1 - id number
		cx.setId(id.getExtension());
		// CX.4.2 - assigning authority universal id
		assigningAuthority.setUniversalId(id.getRoot());
		// CX.4.3 - assigning authority universal id type
		assigningAuthority.setUniversalIdType("ISO");

		cx.setAssigningAuthority(assigningAuthority);

		return cx;
	}

	/**
	 * Maps CDA R2 II and PN datatypes to the OHT model version of the HL7 v2.5 XCN
	 * data type. Implementation consistent with PCC TF-2 Medical Document Binding
	 * to XDS, XDM and XDR.
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	protected Person map(II id, PN name) {
		var xcn = new Person();

		var idNull = true;
		if (id != null) {
			var identifiable = new Identifiable();
			var assigningAutority = new AssigningAuthority();
			// XCN.1 - id number
			identifiable.setId(id.getExtension());
			// XCN.9.2 - assigning authority universal id
			assigningAutority.setUniversalId(id.getRoot());
			// XCN.9.3 - assigning authority universal id type
			assigningAutority.setUniversalIdType("ISO");

			identifiable.setAssigningAuthority(assigningAutority);
			xcn.setId(identifiable);
			idNull = false;
		}
		if (name != null) {
			xcn.setName(mapXcn(name));
		}
		if (idNull && name == null) {
			return null;
		} else {
			return xcn;
		}
	}

	/**
	 * Maps CDA R2 II and ON datatypes to the OHT model version of the HL7 v2.5 XON
	 * data type. Implementation consistent with PCC TF-2 Medical Document Binding
	 * to XDS, XDM and XDR, pending resolution to ITI CP 316.
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	protected Organization map(ON name, II id) {
		var xon = new Organization();
		var assigningAuthority = new AssigningAuthority();

		if (id != null) {
			// XON.3 - id number
			xon.setIdNumber(id.getExtension());
			// XON.6.2 - assigning authority universal id
			assigningAuthority.setUniversalId(id.getRoot());
			// XON.6.3 - assigning authority universal id type
			assigningAuthority.setUniversalIdType("ISO");
			xon.setAssigningAuthority(assigningAuthority);
		}
		if (name != null) {
			// XON 1
			String txt = name.xmlContent;
			if (txt.length() > 0) {
				xon.setOrganizationName(txt);
			}

		}
		return xon;
	}

	/**
	 * Maps CDA R2 PN datatype to the OHT model version of the HL7 v2.5 XPN data
	 * type.
	 * <li>NOTES:</li>
	 * <li>1. only the first entries in the sub lists for name parts are extracted
	 * and processed for XPN.1 to XPN.5</li>
	 * 
	 * @param name
	 * @return
	 */
	protected XpnName map(PN name) {
		if (name == null) {
			return null;
		}

		var xpn = new XpnName();

		for (Serializable obj : name.getContent()) {
			JAXBElement<?> element = (JAXBElement<?>) obj;

			// XPN.1.1 - family_name.surname
			if (element.getValue() instanceof EnFamily) {
				EnFamily family = (EnFamily) element.getValue();
				String txt = family.xmlContent;
				if (txt.length() > 0) {
					xpn.setFamilyName(txt);
				}
			}

			// XPN.2 and XPN.3 (given name and middle name)
			if (element.getValue() instanceof EnGiven) {
				EnGiven family = (EnGiven) element.getValue();
				String txt = family.xmlContent;
				if (txt.length() > 0) {
					xpn.setGivenName(txt);
				}
			}

			// XPN.4 - suffix
			if (element.getValue() instanceof EnSuffix) {
				EnSuffix suffix = (EnSuffix) element.getValue();
				String txt = suffix.xmlContent;
				if (txt.length() > 0) {
					xpn.setSuffix(txt);
				}
			}

			// XPN.5 - prefix
			if (element.getValue() instanceof EnPrefix) {
				EnPrefix prefix = (EnPrefix) element.getValue();
				String txt = prefix.xmlContent;
				if (txt.length() > 0) {
					xpn.setPrefix(txt);
				}
			}
		}

		return xpn;

	}

	protected XcnName mapXcn(PN name) {
		if (name == null) {
			return null;
		}

		var xcn = new XcnName();

		for (Serializable obj : name.getContent()) {
			JAXBElement<?> element = (JAXBElement<?>) obj;

			// XCN 2.1
			if (element.getValue() instanceof EnFamily) {
				EnFamily family = (EnFamily) element.getValue();
				String txt = family.xmlContent;
				if (txt.length() > 0) {
					xcn.setFamilyName(txt);
				}
			}

			// XCN.3 and XCN.4 (given name and middle name)
			if (element.getValue() instanceof EnGiven) {
				EnGiven family = (EnGiven) element.getValue();
				String txt = family.xmlContent;
				if (txt.length() > 0) {
					xcn.setGivenName(txt);
				}
			}

			// XCN.5 - suffix
			if (element.getValue() instanceof EnSuffix) {
				EnSuffix suffix = (EnSuffix) element.getValue();
				String txt = suffix.xmlContent;
				if (txt.length() > 0) {
					xcn.setSuffix(txt);
				}
			}

			// XCN.6 - prefix
			if (element.getValue() instanceof EnPrefix) {
				EnPrefix prefix = (EnPrefix) element.getValue();
				String txt = prefix.xmlContent;
				if (txt.length() > 0) {
					xcn.setPrefix(txt);
				}
			}
		}

		return xcn;

	}

	/**
	 * Maps CDA R2 TEL type to the OHT model version of the Hl7 v2.5 XTN data type.
	 * 
	 * @param tel
	 * @return
	 */
	protected Telecom map(TEL tel) {
		if (tel == null || tel.getValue() == null || tel.getValue().isEmpty()) {
			return null;
		}

		var xtn = new Telecom();

		// Updated CP 524, 627 and 628 for IHE ITI TF v9 (2012-2013)
		// XTN.3
		// FIXME 12/19/12 SEK - not sure if this is required, no matching concept for
		// this in CDA
		xtn.setType("");
		// XTN.4
		xtn.setEmail(tel.getValue());

		// XTN.12 - unformatted telephone number
		// xtn.setUnformattedTelephoneNumber(tel.getValue());

		return xtn;
	}

	/**
	 * Maps CDA R2 TS1 data type to the OHT model version of the Hl7 v2.5 TS data
	 * type. The XDS Metadata timestamp is to be in UTC, but without the timezone
	 * offset or fractional seconds: [[[[[YYYY]MM]DD]HH]mm]ss]. Thus, this time is
	 * assumed to be in GMT. So, if the timestamp in the corresponding CDA element
	 * contains the timezone offset, this method will convert the timestamp to GMT.
	 * If the timezone offset is ommitted, then the timestamp is assumed to be in
	 * GMT. <br>
	 * 
	 * @param time
	 * @return
	 */
	protected Timestamp map(TS time) {
		if (time == null) {
			return null;
		}
		if (time.getValue() == null) {
			return null;
		}
		
		var timestamp = new Timestamp();

		String tm = time.getValue();
		// Check for time zone
		var offset = "";
		if (tm.length() > "-ZZZZ".length()) {
			// check for minus GMT
			if (tm.charAt(tm.length() - "-ZZZZ".length()) == '-') {
				// found timezone offset
				offset = tm.substring(tm.length() - "-ZZZZ".length());
			}
			// check for plus GMT
			else if (tm.charAt(tm.length() - "-ZZZZ".length()) == '+') {
				// found timezone offset
				offset = tm.substring(tm.length() - "+ZZZZ".length());
			}
		}
		// trim length (get rid of time zone and fractional seconds)
		if (tm.length() > "YYYYMMDDHHMMSS".length()) {
			tm = tm.substring(0, "YYYYMMDDHHMMSS".length());
		}

		// factor in timezone offset, if applicable
		if (tm.length() > "YYYYMMDDHH".length() && offset.length() > 0) {

			var sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			// first, set up time in current time zone
			sdf.setTimeZone(TimeZone.getTimeZone("GMT" + offset));
			Date specifiedTime;
			// System.out.println("Specified time is: " + tm);
			// System.out.println("time zone is:GMT" + offset);
			try {
				// switch timezone
				specifiedTime = sdf.parse(tm);
				sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
				tm = sdf.format(specifiedTime);
				// System.out.println("Specified time post conversion: "+ tm);
				// System.exit(0);
			} catch (ParseException e) {
				// FIXME just skip the conversion, bad time stamp, hence bad
				// CDA!
				// Maybe this should be more robust?? An Exception?
			}
		}

		timestamp.setDateTime(DateUtil.parseZonedDate(DateUtil.parseHl7Timestamp(tm)));

		return timestamp;
	}

}
