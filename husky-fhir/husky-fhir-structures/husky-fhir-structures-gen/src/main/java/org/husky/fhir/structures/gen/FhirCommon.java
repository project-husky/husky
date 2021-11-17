/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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

package org.husky.fhir.structures.gen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import org.hl7.fhir.r4.model.Basic;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.DocumentManifest;
import org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Enumeration;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;
import org.hl7.fhir.r4.model.Organization.OrganizationContactComponent;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.husky.common.basetypes.AddressBaseType;
import org.husky.common.basetypes.CodeBaseType;
import org.husky.common.basetypes.NameBaseType;
import org.husky.common.basetypes.OrganizationBaseType;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.ConfidentialityCode;
import org.husky.common.enums.Isco08;
import org.husky.common.hl7cdar2.POCDMT000040AssignedEntity;
import org.husky.common.hl7cdar2.POCDMT000040Performer2;
import org.husky.common.model.Address;
import org.husky.common.model.Author;
import org.husky.common.model.AuthoringDevice;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.model.Name;
import org.husky.common.model.Person;
import org.husky.common.model.Telecom;
import org.husky.fhir.structures.utils.FhirUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;

/**
 * <div class="en">Common material for Fhir package</div> <div class="de"></div>
 * <div class="fr"></div>.
 */
public class FhirCommon {

	public enum SaveMode {
		FILE, LOG, NONE
	}

	/** The SLF4J logger instance. */
	private static Logger log = LoggerFactory.getLogger(FhirCommon.class);

	/** The Constant DEMO_COMMUNITY_OID. */
	public static final String DEMO_COMMUNITY_OID = "2.16.756.5.37";

	/** The Constant DEMO_SOURCE_OID_PREFIX. */
	public static final String DEMO_SOURCE_OID_PREFIX = "1.3.6.1.4.1.21367";

	/** The Constant NIST_COMMUNITY_OID. */
	public static final String NIST_COMMUNITY_OID = "1.3.6.1.4.1.21367.13.20.1000";

	/** The Constant NIST_SOURCE_OID_PREFIX. */
	public static final String NIST_SOURCE_OID_PREFIX = "1.3.6.1.4.1.21367";

	/** The urn prefix for OIDs. */
	public static final String OID_URN = "urn:oid:";

	/** The urn prefix for UUIDs. */
	public static final String UUID_URN = "urn:uuid:";

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String OID_LANGUAGE = OID_URN + CodeSystems.LanguageCode.getCodeSystemId();

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_ACTIVE_PROBLEM_CONCERN = "urn:ehealth_connector:FhirExtension:useAsActiveProblemConcern";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_ACTIVE_PROBLEM_CONCERN_ENTRIES = "urn:ehealth_connector:FhirExtension:uAsActiveProblemConcernEntries";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_ACUITY_ASSESSMENT = "urn:ehealth_connector:FhirExtension:useAsAcuityAssessment";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_ADVANCE_DIRECTIVES = "urn:ehealth_connector:FhirExtension:useAsAdvanceDirectives";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_ALLERGY_PROBLEM_CONCERN = "urn:ehealth_connector:FhirExtension:useAsAllergyProblemConcern";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_ALLERGY_PROBLEM_CONCERN_ENTRIES = "urn:ehealth_connector:FhirExtension:useAsAllergyProblemConcernEntries";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_ASSESSMENT_AND_PLAN = "urn:ehealth_connector:FhirExtension:useAsAssessmentAndPlan";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_AUTHOR = "urn:ehealth_connector:FhirExtension:useAsAuthor";
	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_AUTHOR_LRQC = "urn:ehealth_connector:FhirExtension:useAsAuthorLrqc";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_BLOOD_GROUP = "urn:ehealth_connector:FhirExtension:useAsBloodGroup";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_CHIEF_COMPLAINT = "urn:ehealth_connector:FhirExtension:useAsChiefComplaint";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_CODE = "urn:ehealth_connector:FhirExtension:urnUseAsCode";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_CODED_PHYSICAL_EXAM = "urn:ehealth_connector:FhirExtension:useAsCodedPhysicalExam";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_CODED_RESULT_OBSERVATIONS = "urn:ehealth_connector:FhirExtension:useAsCodedResultObservations";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_CODED_VITAL_SIGN_LIST = "urn:ehealth_connector:FhirExtension:urnUseAsCodedVitalSignList";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_CODED_VITAL_SIGN_OBSERVATION = "urn:ehealth_connector:FhirExtension:useAsCodedVitalSignObservation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_CODED_VITAL_SIGNS = "urn:ehealth_connector:FhirExtension:useAsCodedVitalSigns";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_COMMENT = "urn:ehealth_connector:FhirExtension:useAsComment";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_CONFIDENTIALITY = "urn:ehealth_connector:FhirExtension:useAsConfidentiality";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_CRITERION = "urn:ehealth_connector:FhirExtension:useAsCriterion";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_CURRENT_MEDICATIONS = "urn:ehealth_connector:FhirExtension:useAsCurrentMedications";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_CUSTODIAN = "urn:ehealth_connector:FhirExtension:useAsCustodian";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_DOC_TYPE = "urn:ehealth_connector:FhirExtension:useAsDocType";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_DOCUMENTATION_OF = "urn:ehealth_connector:FhirExtension:useAsDocumentationOf";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_DOCUMENT_DESCRIPTOR = "urn:ehealth_connector:FhirExtension:useAsDocumentDescriptor";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_DOC_VERSION = "urn:ehealth_connector:FhirExtension:urnUseAsDocVersion";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_ED_CONSULTATIONS = "urn:ehealth_connector:FhirExtension:useAsEdConsultations";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_ED_DIAGNOSIS = "urn:ehealth_connector:FhirExtension:useAsEdDiagnosis";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_ED_DISPOSITION = "urn:ehealth_connector:FhirExtension:useAsEdDisposition";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_EXTERNAL_DOCUMENT = "urn:ehealth_connector:FhirExtension:useAsExternalDocument";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_FORMAT_CODE = "urn:ehealth_connector:FhirExtension:useAsFormatCode";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_FUNCTION_CODE = "urn:ehealth_connector:FhirExtension:urnUseAsFunctionCode";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_FAMILY_MEDICAL_HISTORY = "urn:ehealth_connector:FhirExtension:useAsFamilyMedicalHistory";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_HISTORY_OF_IMMUNIZATION = "urn:ehealth_connector:FhirExtension:useAsHistoryOfImmunization";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_HISTORY_OF_PRESENT_ILLNESS = "urn:ehealth_connector:FhirExtension:useAsHistoryOfPresentIllness";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_IDENTIFIER = "urn:ehealth_connector:FhirExtension:useAsIdentifier";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_IMMUNIZATION = "urn:ehealth_connector:FhirExtension:useAsImmunization";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_IMMUNIZATION_RECOMMENDATION = "urn:ehealth_connector:FhirExtension:useAsImmunizationRecommendation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_INFORMATION_RECIPIENT = "urn:ehealth_connector:FhirExtension:useAsInformationRecipient";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_CLAIMER = "urn:ehealth_connector:FhirExtension:useAsClaimer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_IN_FULFILLMENT_OF = "urn:ehealth_connector:FhirExtension:urnUseAsInFulfillmentOf";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_LABORATORY_BATTERY_ORGANIZER = "urn:ehealth_connector:FhirExtension:useAsLaboratoryBatteryOrganizer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_LABORATORY_ISOLATE_ORGANIZER = "urn:ehealth_connector:FhirExtension:useAsLaboratoryIsolateOrganizer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String UNR_USE_AS_LABORATORY_OBSERVATION = "urn:ehealth_connector:FhirExtension:useAsLaboratoryObservation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_LABORATORY_OBSERVATIONS = "urn:ehealth_connector:FhirExtension:useAsLaboratoryObservations";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_LABORATORY_REPORT_DATA_PROCESSING_ENTRY = "urn:ehealth_connector:FhirExtension:useAsLaboratoryReportDataProcessingEntry";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_LABORATORY_SPECIALTY_SECTION = "urn:ehealth_connector:FhirExtension:useAsLaboratorySpecialtySection";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_LANGUAGE = "urn:ehealth_connector:FhirExtension:useAsLanguage";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_LEGAL_AUTHENTICATOR = "urn:ehealth_connector:FhirExtension:useAsLegalAuthenticator";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_LIST_OF_SURGERIES = "urn:ehealth_connector:FhirExtension:useAsListOfSurgeries";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_LOT_NUMBERTEXT = "urn:ehealth_connector:FhirExtension:urnUseAsLotNumbertext";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_MEDICATION_TARGET = "urn:ehealth_connector:FhirExtension:useAsMedicationTarget";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_METADATA_LANGUAGE = "urn:ehealth_connector:FhirExtension:useAsMetadataLanguage";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_MIME_TYPE = "urn:ehealth_connector:FhirExtension:useAsMimeType";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_MODEL_OF_ARRIVAL = "urn:ehealth_connector:FhirExtension:useAsModeOfArrival";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_NON_LIVING_SUBJECT = "urn:ehealth_connector:FhirExtension:useAsNonLivingSubject";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_NOTIFICATION_ORGANIZER = "urn:ehealth_connector:FhirExtension:useAsNotificationOrganizer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_OBSERVATION_MEDIA = "urn:ehealth_connector:FhirExtension:useAsObservationMedia";

	public static final String URN_USE_AS_ORGANIZER = "urn:ehealth_connector:FhirExtension:useAsOrganizer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_OUTBREAK_IDENTIFICATION = "urn:ehealth_connector:FhirExtension:useAsOutbreakIdentification";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_PARTICIPANT = "urn:ehealth_connector:FhirExtension:useAsParticipant";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_PAST_PROBLEM_CONCERN = "urn:ehealth_connector:FhirExtension:useAsPastProblemConcern";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_PAST_PROBLEM_CONCERN_ENTRIES = "urn:ehealth_connector:FhirExtension:useAsPastProblemConcernEntries";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_PATIENT = "urn:ehealth_connector:FhirExtension:useAsPatient";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_PERFORMER = "urn:ehealth_connector:FhirExtension:useAsPerformer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_PRACTICE_SETTING_CODE = "urn:ehealth_connector:FhirExtension:useAsPracticeSettingCode";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_PREGNANCY_OBSERVATION = "urn:ehealth_connector:FhirExtension:urnUseAsPregnancyObservation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_PROCEDURES = "urn:ehealth_connector:FhirExtension:useAsProcedures";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_PROGRESS_NOTE = "urn:ehealth_connector:FhirExtension:useAsProgressNote";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_REASON = "urn:ehealth_connector:FhirExtension:useAsReason";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_REASON_FOR_VISIT = "urn:ehealth_connector:FhirExtension:useAsReasonForVisit";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_REFERENCE_RANGE = "urn:ehealth_connector:FhirExtension:useAsReferenceRange";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_REFERRAL_ORDERING_PHYSICIAN = "urn:ehealth_connector:FhirExtension:useAsReferralOrderingPhysician";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_REFERRAL_SOURCE = "urn:ehealth_connector:FhirExtension:useAsReferralSource";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_REGISTRY_DESTINATION = "urn:ehealth_connector:FhirExtension:useAsRegistryDestination";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_RELATED_DOCUMENT = "urn:ehealth_connector:FhirExtension:useAsRelatedDocument";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_REPOSITORY_DESTINATION = "urn:ehealth_connector:FhirExtension:useAsRepositoryDestination";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_RESULTS = "urn:ehealth_connector:FhirExtension:useAsResults";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_SOCIAL_HISTORY = "urn:ehealth_connector:FhirExtension:useAsSocialHistory";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_SPECIMEN_COLLECTION = "urn:ehealth_connector:FhirExtension:useAsSpecimenCollection";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_SPECIMEN_RECEIVED = "urn:ehealth_connector:FhirExtension:useAsSpecimenReceived";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_STUDIES_SUMMARY = "urn:ehealth_connector:FhirExtension:useAsStudiesSummary";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_VITAL_SIGNS_OBSERVATION = "urn:ehealth_connector:FhirExtension:useAsVitalSignsObservation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String URN_USE_AS_VITAL_SIGNS_ORGANIZER = "urn:ehealth_connector:FhirExtension:useAsVitalSignsOrganizer";

	public static final String DUMMY_CODE = "dummy";

	/**
	 * Adds a FHIR resource to the document
	 *
	 * @param documentManifest
	 *            the FHIR document
	 * @param resource
	 *            the FHIR resource to be added to the document
	 * @return the content
	 */
	public static Reference addDocManifestContent(
			DocumentManifest documentManifest, Resource resource) {
		final var ref = new Reference();
		ref.setResource(resource);
		documentManifest.addContent(ref);
		return ref;
	}

	/**
	 * Adds the urn:oid: Namespace to the OID
	 *
	 * @param oid
	 *            the oid
	 * @return the oid containing the urn:oid: prefix
	 */
	public static String addUrnOid(String oid) {
		String retVal = oid;
		if (!retVal.startsWith(OID_URN))
			retVal = OID_URN + oid;
		return retVal;
	}

	/**
	 * Adds the urn:oid: Namespace to the UUID
	 *
	 * @param uuid
	 *            the uuid
	 * @return the uuid containing the urn:uuid: prefix
	 */
	public static String addUrnUuid(String uuid) {
		String retVal = uuid;
		if (!retVal.startsWith(UUID_URN))
			retVal = UUID_URN + uuid;
		return retVal;
	}

	/**
	 * Creates a new CodeableConcept containing the OID URN for the system
	 * component
	 *
	 * @param systemOid
	 *            the systems oid
	 * @param value
	 *            the code
	 * @return the generated CodeableConcept
	 */
	public static CodeableConcept createCodeableConcept(String systemOid, String value) {
		return createCodeableConcept(systemOid, value, null);

	}

	/**
	 * Creates a new CodeableConcept containing the OID URN for the system
	 * component
	 *
	 * @param systemOid
	 *            the systems oid
	 * @param value
	 *            the code
	 * @param displayName
	 *            the display name of the code
	 * @return the generated CodeableConcept
	 */
	public static CodeableConcept createCodeableConcept(String systemOid, String value,
			String displayName) {
		final var retVal = new CodeableConcept();
		retVal.addCoding(createCoding(systemOid, value, displayName));
		return retVal;

	}

	/**
	 * Creates a new Coding containing the OID URN for the system component
	 *
	 * @param systemOid
	 *            the systems oid
	 * @param value
	 *            the code
	 * @return the generated code
	 */
	public static Coding createCoding(String systemOid, String value) {
		return createCoding(systemOid, value, null);

	}

	/**
	 * Creates a new Coding containing the OID URN for the system component
	 *
	 * @param systemOid
	 *            the systems oid
	 * @param value
	 *            the code
	 * @param displayName
	 *            the display name of the code
	 * @return the generated code
	 */
	public static Coding createCoding(String systemOid, String value, String displayName) {
		final var retVal = new Coding();
		retVal.setSystem(FhirCommon.addUrnOid(systemOid));
		retVal.setCode(value);
		retVal.setDisplay(displayName);
		return retVal;

	}

	/**
	 * Creates a new Identifier containing the OID URN for the system component.
	 *
	 * @param srcId
	 *            the src id
	 * @return the generated identifier
	 */
	public static Identifier createIdentifier(Identificator srcId) {
		Identifier id = null;
		id = new Identifier();
		id.setSystem(OID_URN + srcId.getRoot());
		id.setValue(srcId.getExtension());
		return id;

	}

	/**
	 * Creates a new Identifier containing the OID URN for the system component
	 *
	 * @param systemOid
	 *            the systems oid
	 * @param value
	 *            the id
	 * @return the generated identifier
	 */
	public static Identifier createIdentifier(String systemOid, String value) {
		Identifier id = null;
		id = new Identifier();
		id.setSystem(FhirCommon.addUrnOid(systemOid));
		id.setValue(value);
		return id;

	}

	/**
	 * Creates a Observation containing the required members in order to make
	 * the FHIR resource valid
	 *
	 * @return the FHIR observation
	 */
	public static Observation createObservation() {
		return createObservation(null);
	}

	/**
	 * Creates a Observation containing the required members in order to make
	 * the FHIR resource valid
	 *
	 * @param ccd
	 *            the code for this observation
	 * @return the FHIR observation
	 */
	public static Observation createObservation(CodeableConcept ccd) {
		final var retVal = new Observation();
		retVal.setStatus(ObservationStatus.UNKNOWN);
		if (ccd != null)
			retVal.setCode(ccd);
		else
			retVal.setCode(FhirCommon.getDummyCodeableConcept());
		return retVal;
	}

	/**
	 * Cnverts a eHC code to a FHIR code
	 *
	 * @param code
	 *            the eHC code
	 * @return the FHIR code
	 */
	public static CodeableConcept ehcCodeToFhirCode(Code code) {
		final var cc = new CodeableConcept();
		Coding fCode;

		fCode = new Coding();
		fCode.setSystem(addUrnOid(code.getCodeSystem()));
		fCode.setCode(code.getCode());
		fCode.setDisplay(code.getDisplayName());
		cc.addCoding(fCode);

		for (final CodeBaseType translation : code.getCodeTranslationList()) {
			final var cdt = new Coding();
			cdt.setSystem(addUrnOid(translation.getCodeSystem()));
			cdt.setCode(translation.getCode());
			cdt.setDisplay(translation.getDisplayName());
			cc.addCoding(cdt);
		}

		return cc;
	}

	/**
	 * Converts a FHIR address to a eHC address
	 *
	 * @param fAddr
	 *            the FHIR address
	 * @return the eHC address
	 */
	public static Address fhirAddressToEhcAddress(org.hl7.fhir.r4.model.Address fAddr) {
		final var addr = new Address(new AddressBaseType());
		for (final StringType line : fAddr.getLine()) {
			addr.setStreetAddressLine1(line.asStringValue());
		}
		if (fAddr.getPostalCode() != null) {
			addr.setPostalCode(fAddr.getPostalCode());
		}
		if (fAddr.getCity() != null) {
			addr.setCity(fAddr.getCity());
		}
		if (fAddr.getCountry() != null) {
			addr.setCountry(fAddr.getCountry());
		}
		if (fAddr.getState() != null) {
			addr.setState(fAddr.getState());
		}
		final Enumeration<org.hl7.fhir.r4.model.Address.AddressUse> useElement = fAddr
				.getUseElement();
		if (useElement.getValue() == org.hl7.fhir.r4.model.Address.AddressUse.HOME) {
			addr.setUsage(org.husky.common.enums.PostalAddressUse.HOME_ADDRESS);
		}
		if (useElement.getValue() == org.hl7.fhir.r4.model.Address.AddressUse.OLD) {
			addr.setUsage(org.husky.common.enums.PostalAddressUse.BAD_ADDRESS);
		}
		// We use TMP for PUB, because it is required in LRQC but not
		// available in FHIR ;)
		if (useElement.getValue() == org.hl7.fhir.r4.model.Address.AddressUse.TEMP) {
			addr.setUsage(org.husky.common.enums.PostalAddressUse.TEMPORARY);
		}
		if (useElement.getValue() == org.hl7.fhir.r4.model.Address.AddressUse.WORK) {
			addr.setUsage(org.husky.common.enums.PostalAddressUse.WORK_PLACE);
		}
		return addr;
	}

	/**
	 * Converts a FHIR code to a eHC code
	 *
	 * @param codableConcept
	 *            the FHIR code
	 * @return the eHC code
	 */
	public static Code fhirCodeToEhcCode(CodeableConcept codableConcept) {
		Code code;
		code = new Code(removeUrnOidPrefix(codableConcept.getCodingFirstRep().getSystem()),
				codableConcept.getCodingFirstRep().getCode(),
				codableConcept.getCodingFirstRep().getDisplay());
		if (codableConcept.getCoding().size() > 1) {
			for (var i = 1; i < codableConcept.getCoding().size(); i++) {
				final Coding fhirCode = codableConcept.getCoding().get(i);
				code.addCodeTranslation(
						new Code(removeUrnOidPrefix(fhirCode.getSystem()),
						fhirCode.getCode(), fhirCode.getDisplay()));
			}

		}
		return code;
	}

	/**
	 * Converts a FHIR id to a eHC id
	 *
	 * @param id
	 *            the FHIR id
	 * @return the eHC id
	 */
	public static Identificator fhirIdentifierToEhcIdentificator(Identifier id) {
		if ((id != null) && !id.isEmpty()) {
			return new Identificator(FhirCommon.removeUrnOidPrefix(id.getSystem()), id.getValue());
		} else {
			return null;
		}
	}

	/**
	 * Converts a FHIR name to a eHC name
	 *
	 * @param fName
	 *            the FHIR name
	 * @return the eHC name
	 */
	public static Name fhirNameToEhcName(HumanName fName) {
		var name = new Name();
		if (!fName.getGivenAsSingleString().isEmpty() && !fName.getFamily().isEmpty()) {
			name.setGiven(fName.getGivenAsSingleString());
			name.setFamily(fName.getFamily());
		} else {
			if (!fName.getText().isEmpty()) {
				name = new Name(fName.getText());
			}
		}

		if (fName.getPrefixAsSingleString() != null) {
			name.setPrefix(fName.getPrefixAsSingleString());
		}
		if (fName.getSuffixAsSingleString() != null) {
			name.setSuffix(fName.getSuffixAsSingleString());
		}
		return name;
	}

	/**
	 * Gets the DIV content from the given XHTML node
	 *
	 * @param xhtmlNode
	 *            the XHTML node
	 * @return the DIV content
	 */
	public static String formatDiv(XhtmlNode xhtmlNode) {
		var retVal = xhtmlNode.getValueAsString();
		retVal = retVal.replace("</div>", "");
		retVal = retVal.substring(retVal.indexOf(">") + 1, retVal.length());
		return retVal;
	}

	/**
	 * <div class="en">Gets an eHC Author from FHIR base resource.
	 *
	 * @param res
	 *            the FHIR object
	 * @return the eHC Author </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static org.husky.common.model.Author getAuthor(IBaseResource res) {
		org.husky.common.model.Author retVal = null;
		if (res instanceof org.hl7.fhir.r4.model.Person) {
			retVal = FhirCommon.getAuthor((org.hl7.fhir.r4.model.Person) res);
		}
		if (res instanceof Practitioner) {
			retVal = FhirCommon.getAuthor((Practitioner) res);
		}
		if (res instanceof org.hl7.fhir.r4.model.Organization) {
			retVal = FhirCommon.getAuthor((org.hl7.fhir.r4.model.Organization) res);
		}
		return retVal;
	}

	/**
	 * Gets an eHC Author from FHIR Organization.
	 *
	 * @param fhirObject
	 *            <div class="en">FHIR Organization resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">the eHC Author</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static org.husky.common.model.Author getAuthor(
			org.hl7.fhir.r4.model.Organization fhirObject) {
		org.husky.common.model.Author retVal = null;
		final String authoringDeviceName = fhirObject.getName();

		// Create the author
		final var ad = new AuthoringDevice(authoringDeviceName);
		retVal = new org.husky.common.model.Author(ad);
		retVal.setFunctionCode(Author.FUNCTION_CODE_AUTHORDEVICE);

		// Set Function Code
		setAuthorFuntionCode(retVal, fhirObject);

		// Add Identifiers
		for (final Identifier id : fhirObject.getIdentifier()) {
			final String codeSystem = FhirCommon.removeUrnOidPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (final org.hl7.fhir.r4.model.Address addr : fhirObject.getAddress()) {
			org.husky.common.enums.PostalAddressUse usage = org.husky.common.enums.PostalAddressUse.WORK_PLACE;
			if (addr.getUseElement()
					.getValue() == org.hl7.fhir.r4.model.Address.AddressUse.HOME) {
				usage = org.husky.common.enums.PostalAddressUse.HOME_ADDRESS;
			}
			if (addr.getUseElement()
					.getValue() == org.hl7.fhir.r4.model.Address.AddressUse.TEMP) {
				usage = org.husky.common.enums.PostalAddressUse.PUBLIC;
			}
			final var eHCAddr = new Address(new AddressBaseType());
			eHCAddr.setStreetAddressLine1(addr.getLine().get(0).toString());
			eHCAddr.setPostalCode(addr.getPostalCode());
			eHCAddr.setCity(addr.getCity());
			eHCAddr.setUsage(usage);
			if (addr.getCountry() != null) {
				eHCAddr.setCountry(addr.getCountry());
			}
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(getTelecoms(fhirObject.getTelecom()));

		// Add OrganizationName
		final OrganizationContactComponent contact = fhirObject.getContactFirstRep();
		if (contact != null) {
			final String name = contact.getName().getFamily();
			if (name != null && !name.isEmpty()) {
				retVal.setOrganization(new org.husky.common.model.Organization(new OrganizationBaseType()));
				var orgName = new NameBaseType();
				orgName.setName(name);
				retVal.getOrganization().addName(orgName);
			}
		}

		return retVal;
	}

	/**
	 * Gets an eHC Author from FHIR Person.
	 *
	 * @param fhirObject
	 *            <div class="en">FHIR Person resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">the eHC Author</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static org.husky.common.model.Author getAuthor(
			org.hl7.fhir.r4.model.Person fhirObject) {
		org.husky.common.model.Author retVal = null;
		final var personName = new Name();
		personName.setGiven(fhirObject.getNameFirstRep().getGivenAsSingleString());
		personName.setFamily(fhirObject.getNameFirstRep().getFamily());


		// Create the author
		retVal = new org.husky.common.model.Author(personName);

		// Set Function Code
		setAuthorFuntionCode(retVal, fhirObject);

		// Add Identifiers
		for (final Identifier id : fhirObject.getIdentifier()) {
			final String codeSystem = FhirCommon.removeUrnOidPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (final org.hl7.fhir.r4.model.Address addr : fhirObject.getAddress()) {
			org.husky.common.enums.PostalAddressUse usage = org.husky.common.enums.PostalAddressUse.WORK_PLACE;
			if (addr.getUseElement()
					.getValue() == org.hl7.fhir.r4.model.Address.AddressUse.HOME) {
				usage = org.husky.common.enums.PostalAddressUse.HOME_ADDRESS;
			}
			if (addr.getUseElement()
					.getValue() == org.hl7.fhir.r4.model.Address.AddressUse.TEMP) {
				usage = org.husky.common.enums.PostalAddressUse.PUBLIC;
			}
			final var eHCAddr = new Address(new AddressBaseType());
			eHCAddr.setStreetAddressLine1(addr.getLine().get(0).toString());
			eHCAddr.setPostalCode(addr.getPostalCode());
			eHCAddr.setCity(addr.getCity());
			eHCAddr.setUsage(usage);
			eHCAddr.setCountry(addr.getCountry());
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(getTelecoms(fhirObject.getTelecom()));

		// Add organization
		if ((fhirObject.getManagingOrganization().getResource() != null)
				&& !fhirObject.getManagingOrganization().getResource().isEmpty()) {
			retVal.setOrganization(
					getOrganization(fhirObject.getManagingOrganization().getResource()));
		}

		return retVal;

	}

	/**
	 * <div class="en">Gets an eHC Author from FHIR resource reference.
	 *
	 * @param ref
	 *            the FHIR object
	 * @return the eHC Author </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static org.husky.common.model.Author getAuthor(
			org.hl7.fhir.r4.model.Reference ref) {
		return getAuthor(ref.getResource());
	}

	/**
	 * Gets an eHC Author from FHIR Practitioner.
	 *
	 * @param fhirObject
	 *            <div class="en">FHIR Person resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">the eHC Author</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static org.husky.common.model.Author getAuthor(Practitioner fhirObject) {
		org.husky.common.model.Author retVal = null;
		final var personName = new Name();
		personName.setGiven(fhirObject.getName().get(0).getGivenAsSingleString());
		personName.setFamily(fhirObject.getName().get(0).getFamily());

		// Create the author
		retVal = new org.husky.common.model.Author(personName);

		// Set Function Code
		setAuthorFuntionCode(retVal, fhirObject);

		// Add Identifiers
		for (final Identifier id : fhirObject.getIdentifier()) {
			final String codeSystem = FhirCommon.removeUrnOidPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (final org.hl7.fhir.r4.model.Address addr : fhirObject.getAddress()) {
			org.husky.common.enums.PostalAddressUse usage = org.husky.common.enums.PostalAddressUse.WORK_PLACE;
			if (addr.getUseElement()
					.getValue() == org.hl7.fhir.r4.model.Address.AddressUse.HOME) {
				usage = org.husky.common.enums.PostalAddressUse.HOME_ADDRESS;
			}
			final var eHCAddr = new Address(new AddressBaseType());
			eHCAddr.setStreetAddressLine1(addr.getLine().get(0).toString());
			eHCAddr.setPostalCode(addr.getPostalCode());
			eHCAddr.setCity(addr.getCity());
			eHCAddr.setUsage(usage);
			eHCAddr.setCountry(addr.getCountry());
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(getTelecoms(fhirObject.getTelecom()));

		// Add organization
		// not supported by FHIR Practitioner

		return retVal;

	}

	/**
	 * Gets the community patient id.
	 *
	 * @param patient
	 *            the patient
	 * @param communityOid
	 *            the community oid
	 * @return the community patient id
	 */
	public static Identificator getCommunityPatientId(
			org.husky.common.model.Patient patient, String communityOid) {
		Identificator retVal = null;
		if (communityOid != null) {
			for (final Identificator item : patient.getIds()) {

				if (item.getRoot().replace(OID_URN, "").equals(communityOid.replace(OID_URN, ""))) {
					retVal = new Identificator(item.getRoot(), item.getExtension());
					break;
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets the FHIR element for a normal confidentiality code
	 *
	 * @return the FHIR element for a normal confidentiality code
	 */
	public static Basic getConfidentialityNormal() {
		final var docRestrictedConfidentiality = new Basic();
		final ConfidentialityCode conf = ConfidentialityCode.NORMAL;
		docRestrictedConfidentiality.setCode(FhirCommon.createCodeableConcept(
				conf.getCodeSystemOid(), conf.getCodeValue(), conf.getDisplayName()));
		return docRestrictedConfidentiality;

	}

	/**
	 * Gets the FHIR element for a restricted confidentiality code
	 *
	 * @return the FHIR element for a restricted confidentiality code
	 */
	public static Basic getConfidentialityRestricted() {
		final var docRestrictedConfidentiality = new Basic();
		final ConfidentialityCode conf = ConfidentialityCode.RESTRICTED;
		docRestrictedConfidentiality.setCode(FhirCommon.createCodeableConcept(
				conf.getCodeSystemOid(), conf.getCodeValue(), conf.getDisplayName()));
		return docRestrictedConfidentiality;

	}

	// /**
	// * <div class="en">Gets an OHT DocumentDescriptor object from the given
	// FHIR
	// * object.
	// *
	// * @param fhirObject
	// * the FHIR object
	// * @return OHT DocumentDescriptor object </div> <div class="de"></div>
	// * <div class="fr"></div>
	// */
	// public static DocumentDescriptor getDocumentDescriptor(DocumentReference
	// fhirObject) {
	// String mimeType = "";
	// fhirObject.getContentFirstRep().getFormat();
	// Coding item = fhirObject.getContentFirstRep().getFormat();
	// final List<Extension> extensions =
	// item.getExtensionsByUrl(FhirCommon.urnUseAsMimeType);
	// if (!extensions.isEmpty()) {
	// mimeType = item.getCode();
	// }
	// return DocumentDescriptor.getDocumentDescriptorForMimeType(mimeType);
	// }

	/**
	 * <div class="en">Gets the file path to a document from the given FHIR
	 * object.
	 *
	 * @param fhirObject
	 *            the FHIR object
	 * @return file path to a document </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static String getDocumentFilepath(DocumentReference fhirObject) {
		return fhirObject.getContentFirstRep().getAttachment().getUrl();
	}

	/**
	 * Gets a dummmy code in order to make the FHIR resource valid
	 *
	 * @return the dummy code
	 */
	public static Coding getDummyCode() {
		return new Coding("urn:oid:2.999", DUMMY_CODE, "dummy code to make FHIR resource valid");
	}

	/**
	 * Gets a dummmy code in order to make the FHIR resource valid
	 *
	 * @return the dummy code
	 */
	public static CodeableConcept getDummyCodeableConcept() {
		final var retVal = new CodeableConcept();
		retVal.addCoding(getDummyCode());
		return retVal;
	}

	/**
	 * Gets a dummmy reference in order to make the FHIR resource valid
	 *
	 * @return the dummy reference
	 */
	public static Reference getDummyReference() {
		final var dummyRef = new Reference();
		dummyRef.setDisplay(DUMMY_CODE);
		return dummyRef;

	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension ActiveProblemConcern
	 */
	public static Extension getExtensionActiveProblemConcern() {
		return new Extension(FhirCommon.URN_USE_AS_ACTIVE_PROBLEM_CONCERN, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension AdvanceDirectives
	 */
	public static Extension getExtensionAdvanceDirectives() {
		return new Extension(FhirCommon.URN_USE_AS_ADVANCE_DIRECTIVES, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension AllergyProblemConcern
	 */
	public static Extension getExtensionAllergyProblemConcern() {
		return new Extension(FhirCommon.URN_USE_AS_ALLERGY_PROBLEM_CONCERN, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension author
	 */
	public static Extension getExtensionAuthor() {
		return new Extension(FhirCommon.URN_USE_AS_AUTHOR, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension ChiefComplaint
	 */
	public static Extension getExtensionChiefComplaint() {
		return new Extension(FhirCommon.URN_USE_AS_CHIEF_COMPLAINT, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension custodian
	 */
	public static Extension getExtensionClaimer() {
		return new Extension(FhirCommon.URN_USE_AS_CLAIMER, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension CodedVitalSignObservation
	 */
	public static Extension getExtensionCodedVitalSignObservation() {
		return new Extension(FhirCommon.URN_USE_AS_CODED_VITAL_SIGN_OBSERVATION, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension comment
	 */
	public static Extension getExtensionComment() {
		return new Extension(FhirCommon.URN_USE_AS_COMMENT, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension criterion
	 */
	public static Extension getExtensionCriterion() {
		return new Extension(FhirCommon.URN_USE_AS_CRITERION, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension custodian
	 */
	public static Extension getExtensionCustodian() {
		return new Extension(FhirCommon.URN_USE_AS_CUSTODIAN, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension criterion
	 */
	public static Extension getExtensionDocType() {
		return new Extension(FhirCommon.URN_USE_AS_DOC_TYPE, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension document descriptor
	 */
	public static Extension getExtensionDocumentDescriptor() {
		return new Extension(FhirCommon.URN_USE_AS_DOCUMENT_DESCRIPTOR, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension external document
	 */
	public static Extension getExtensionExternalDocument() {
		return new Extension(FhirCommon.URN_USE_AS_EXTERNAL_DOCUMENT, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension format code
	 */
	public static Extension getExtensionFormatCode() {
		return new Extension(FhirCommon.URN_USE_AS_FORMAT_CODE, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension FunctionCodeDoctor
	 */
	public static Extension getExtensionFunctionCodeDoctor() {
		final Isco08 functionCode = Isco08.MEDICAL_DOCTORS;
		final var code = new Coding(functionCode.getCodeSystemName(),
				functionCode.getCodeValue(), functionCode.getDisplayName());
		return new Extension(FhirCommon.URN_USE_AS_FUNCTION_CODE, code);
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension FunctionCodeDoctor
	 */
	public static Extension getExtensionFunctionCodeLabTechnician() {
		final Isco08 functionCode = Isco08.MEDICAL_AND_PATHOLOGY_LABORATORY_TECHNICIANS;
		final var code = new Coding();
		code.setSystem(FhirCommon.addUrnOid(functionCode.getCodeSystemOid()));
		code.setCode(functionCode.getCodeValue());
		code.setDisplay(functionCode.getDisplayName());
		code.setVersion(functionCode.getCodeSystemName());
		return new Extension(FhirCommon.URN_USE_AS_FUNCTION_CODE, code);
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension InformationRecipient
	 */
	public static Extension getExtensionInformationRecipient() {
		return new Extension(FhirCommon.URN_USE_AS_INFORMATION_RECIPIENT, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 */
	public static Extension getExtensionLaboratoryBatteryOrganizer() {
		return new Extension(FhirCommon.URN_USE_AS_LABORATORY_BATTERY_ORGANIZER,
				new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 */
	public static Extension getExtensionLaboratoryObservations() {
		return new Extension(FhirCommon.URN_USE_AS_LABORATORY_OBSERVATIONS, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension medication target
	 */
	public static Extension getExtensionMedicationTarget() {
		return new Extension(FhirCommon.URN_USE_AS_MEDICATION_TARGET, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension metadata language
	 */
	public static Extension getExtensionMetadataLanguage() {
		return new Extension(FhirCommon.URN_USE_AS_METADATA_LANGUAGE, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension mime type
	 */
	public static Extension getExtensionMimeType() {
		return new Extension(FhirCommon.URN_USE_AS_MIME_TYPE, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension author
	 */
	public static Extension getExtensionNonLivingSubject() {
		return new Extension(FhirCommon.URN_USE_AS_NON_LIVING_SUBJECT, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension author
	 */
	public static Extension getExtensionParticipant() {
		return new Extension(FhirCommon.URN_USE_AS_PARTICIPANT, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension performer
	 */
	public static Extension getExtensionPerformer() {
		return new Extension(FhirCommon.URN_USE_AS_PERFORMER, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension practice setting code
	 */
	public static Extension getExtensionPracticeSettingCode() {
		return new Extension(FhirCommon.URN_USE_AS_PRACTICE_SETTING_CODE, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension reason
	 */
	public static Extension getExtensionReason() {
		return new Extension(FhirCommon.URN_USE_AS_REASON, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension repository destination
	 */
	public static Extension getExtensionRepositoryDestination() {
		return new Extension(FhirCommon.URN_USE_AS_REPOSITORY_DESTINATION, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en">Gets a eHC Code to be used as format code from the FHIR
	 * DocumentReference object.
	 *
	 * @param fhirObject
	 *            the FHIR object
	 * @return eHC Code to be used as format code </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static Code getFormatCode(DocumentReference fhirObject) {
		Code retVal = null;
		final List<Extension> extensions = fhirObject
				.getExtensionsByUrl(FhirCommon.URN_USE_AS_FORMAT_CODE);
		if (!extensions.isEmpty())
			retVal = FhirUtilities.toCode((Coding) extensions.get(0).getValue());
		return retVal;
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the information recipient
	 */
	public static Extension getInformationRecipient() {
		return new Extension(FhirCommon.URN_USE_AS_INFORMATION_RECIPIENT, new StringType(DUMMY_CODE));
	}

	/**
	 * <div class="en"> Gets a string describing the language of the meta data
	 * from the FHIR DocumentReference object.
	 *
	 * @param fhirObject
	 *            the FHIR object
	 * @return string describing the language of the meta data</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public static String getMetadataLanguage(DocumentReference fhirObject) {
		var retVal = "";
		final List<Extension> extensions = fhirObject
				.getExtensionsByUrl(FhirCommon.URN_USE_AS_METADATA_LANGUAGE);
		if (!extensions.isEmpty())
			retVal = ((StringType) extensions.get(0).getValue()).getValueAsString();
		return retVal;
	}

	/**
	 * <div class="en"> Gets a string describing the mime type from the FHIR
	 * DocumentReference object.
	 *
	 * @param fhirObject
	 *            the FHIR object
	 * @return string describing the mime type</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static String getMimeType(DocumentReference fhirObject) {
		var retVal = "";
		final Coding item = fhirObject.getContentFirstRep().getFormat();
		final List<Extension> extensions = item.getExtensionsByUrl(FhirCommon.URN_USE_AS_MIME_TYPE);
		if (!extensions.isEmpty()) {
			retVal = item.getCode();
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets an eHC Organization object from the given FHIR base
	 * resource object.
	 *
	 * @param res
	 *            the FHIR base resource object
	 * @return the eHC Organization </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static org.husky.common.model.Organization getOrganization(
			IBaseResource res) {
		org.husky.common.model.Organization retVal = null;
		if (res instanceof org.hl7.fhir.r4.model.Organization) {
			retVal = FhirCommon.getOrganization((org.hl7.fhir.r4.model.Organization) res);
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets an eHC Organization object from the given FHIR
	 * Organization object.
	 *
	 * @param fhirOrganization
	 *            <div class="en">FHIR Organization resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return eHC Organization object eHC Organization</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public static org.husky.common.model.Organization getOrganization(
			org.hl7.fhir.r4.model.Organization fhirOrganization) {
		org.husky.common.model.Organization retVal = null;
		// Create the organization
		if (fhirOrganization.getName() != null) {
			retVal = new org.husky.common.model.Organization(new OrganizationBaseType());
			var name = new NameBaseType();
			name.setName(fhirOrganization.getName());
			retVal.addName(name);

			// Add Identifiers
			for (final Identifier id : fhirOrganization.getIdentifier()) {
				final String codeSystem = FhirCommon.removeUrnOidPrefix(id.getSystem());
				retVal.addIdentificator(new Identificator(codeSystem, id.getValue()));
			}

			// Add Addresses
			for (final org.hl7.fhir.r4.model.Address addr : fhirOrganization.getAddress()) {
				org.husky.common.enums.PostalAddressUse usage = org.husky.common.enums.PostalAddressUse.WORK_PLACE;
				if (addr.getUseElement()
						.getValue() == org.hl7.fhir.r4.model.Address.AddressUse.HOME) {
					usage = org.husky.common.enums.PostalAddressUse.HOME_ADDRESS;
				}
				if (addr.getUseElement()
						.getValue() == org.hl7.fhir.r4.model.Address.AddressUse.TEMP) {
					usage = org.husky.common.enums.PostalAddressUse.PUBLIC;
				}
				final var eHCAddr = new Address(new AddressBaseType());
				eHCAddr.setStreetAddressLine1(addr.getLine().get(0).toString());
				if (addr.getLine().size() > 1) {
					eHCAddr.setStreetAddressLine2(addr.getLine().get(1).getValueAsString());
				}
				eHCAddr.setPostalCode(addr.getPostalCode());
				eHCAddr.setCity(addr.getCity());
				eHCAddr.setCountry(addr.getCountry());
				eHCAddr.setUsage(usage);
				retVal.addAddress(eHCAddr);
			}

			// Add Telecoms
			List<Telecom> telecoms = FhirCommon.getTelecoms(fhirOrganization.getTelecom());
			for (Telecom tel : telecoms) {
				retVal.addTelecom(tel);
			}
		}
		return retVal;
	}

	/**
	 * Gets an eHC Organization object from the given FHIR reference object.
	 *
	 * @param orgRef
	 *            the FHIR reference object
	 * @return the eHC Organization
	 */
	public static org.husky.common.model.Organization getOrganization(
			org.hl7.fhir.r4.model.Reference orgRef) {
		return getOrganization(orgRef.getResource());
	}

	/**
	 * <div class="en"> Gets an eHC Patient object from the given FHIR base
	 * resource object.
	 *
	 * @param res
	 *            the FHIR base resource object
	 * @return the eHC Patient object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static org.husky.common.model.Patient getPatient(IBaseResource res) {
		org.husky.common.model.Patient retVal = null;
		if (res instanceof org.hl7.fhir.r4.model.Patient) {
			retVal = FhirCommon.getPatient((org.hl7.fhir.r4.model.Patient) res);
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets an eHC Patient object from the given FHIR resource.
	 *
	 * @param bundle
	 *            the FHIR resource
	 * @return eHC Patient object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static org.husky.common.model.Patient getPatient(
			org.hl7.fhir.r4.model.Bundle bundle) {
		for (final BundleEntryComponent entry : bundle.getEntry()) {
			if (entry.getResource() instanceof org.hl7.fhir.r4.model.Patient)
				return getPatient((org.hl7.fhir.r4.model.Patient) entry.getResource());
		}
		return null;
	}

	/**
	 * <div class="en"> Gets an eHC Patient object from the given FHIR resource.
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return eHC Patient object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static org.husky.common.model.Patient getPatient(
			org.hl7.fhir.r4.model.DocumentManifest docManifest) {
		for (final Reference ref : docManifest.getContent()) {
			if (ref != null && ref.getResource() instanceof org.hl7.fhir.r4.model.Patient) {
					return getPatient((org.hl7.fhir.r4.model.Patient) ref.getResource());
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets an eHC Patient object from the given FHIR Patient
	 * object.
	 *
	 * @param fhirPatient
	 *            the FHIR Patient object
	 * @return the eHC Patient object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static org.husky.common.model.Patient getPatient(
			org.hl7.fhir.r4.model.Patient fhirPatient) {
		org.husky.common.model.Patient retVal = null;
		final List<Extension> extensions = fhirPatient
				.getExtensionsByUrl(FhirCommon.URN_USE_AS_NON_LIVING_SUBJECT);
		if (!extensions.isEmpty()) {
			// Create eHC Patient
			retVal = new org.husky.common.model.Patient();
			retVal.setIsNonHumenSubject();
		} else {
			final var patientName = new Name();
			patientName.setGiven(fhirPatient.getNameFirstRep().getGivenAsSingleString());
			patientName.setFamily(fhirPatient.getNameFirstRep().getFamily());
			org.husky.common.enums.AdministrativeGender gender = org.husky.common.enums.AdministrativeGender.UNDIFFERENTIATED;
			if (fhirPatient.getGenderElement()
					.getValue() == org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.FEMALE) {
				gender = org.husky.common.enums.AdministrativeGender.FEMALE;
			} else if (fhirPatient.getGenderElement()
					.getValue() == org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.MALE) {
				gender = org.husky.common.enums.AdministrativeGender.MALE;
			}

			// Create eHC Patient
			retVal = new org.husky.common.model.Patient(patientName, gender,
					fhirPatient.getBirthDate());

			// Add Addresses
			for (final org.hl7.fhir.r4.model.Address addr : fhirPatient.getAddress()) {
				org.husky.common.enums.PostalAddressUse usage = org.husky.common.enums.PostalAddressUse.WORK_PLACE;
				if (addr.getUseElement()
						.getValue() == org.hl7.fhir.r4.model.Address.AddressUse.HOME) {
					usage = org.husky.common.enums.PostalAddressUse.HOME_ADDRESS;
				}
				String addrLine = null;
				if (!addr.getLine().isEmpty())
					addrLine = addr.getLine().get(0).toString();
				final var eHCAddr = new Address(new AddressBaseType());
				eHCAddr.setStreetAddressLine1(addrLine);
				eHCAddr.setPostalCode(addr.getPostalCode());
				eHCAddr.setCity(addr.getCity());
				eHCAddr.setUsage(usage);
				eHCAddr.setCountry(addr.getCountry());
				retVal.addAddress(eHCAddr);
			}

			// Add Telecoms
			retVal.setTelecoms(FhirCommon.getTelecoms(fhirPatient.getTelecom()));
		}
		// Add Identifiers
		for (final Identifier id : fhirPatient.getIdentifier()) {
			final String codeSystem = FhirCommon.removeUrnOidPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		return retVal;
	}

	/**
	 * <div class="en">Gets an eHC Patient object from the given FHIR reference
	 * object.
	 *
	 * @param orgRef
	 *            the FHIR reference object
	 * @return the eHC Patient object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static org.husky.common.model.Patient getPatient(
			org.hl7.fhir.r4.model.Reference orgRef) {
		return getPatient(orgRef.getResource());
	}

	/**
	 * Gets an eHC Author from FHIR Person.
	 *
	 * @param fhirObject <div class="en">FHIR Person resource</div>
	 *                   <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">the eHC Author</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static POCDMT000040Performer2 getPerformer(org.hl7.fhir.r4.model.Person fhirObject) {
		POCDMT000040Performer2 retVal = null;
		final var personName = new Name();
		personName.setGiven(fhirObject.getNameFirstRep().getGivenAsSingleString());
		personName.setFamily(fhirObject.getNameFirstRep().getFamily());

		// Create the author
		retVal = new POCDMT000040Performer2();
		var entity = new POCDMT000040AssignedEntity();
		entity.setAssignedPerson(new Person(personName).getHl7CdaPerson());
		retVal.setAssignedEntity(entity);

		// Set Function Code
		setPerformerFuntionCode(retVal, fhirObject);

		// Add Identifiers
		for (final Identifier id : fhirObject.getIdentifier()) {
			final String codeSystem = FhirCommon.removeUrnOidPrefix(id.getSystem());
			retVal.getAssignedEntity().getId().add(new Identificator(codeSystem, id.getValue()).getHl7CdaR2Ii());
		}

		// Add Addresses
		for (final org.hl7.fhir.r4.model.Address addr : fhirObject.getAddress()) {
			org.husky.common.enums.PostalAddressUse usage = org.husky.common.enums.PostalAddressUse.WORK_PLACE;
			if (addr.getUseElement().getValue() == org.hl7.fhir.r4.model.Address.AddressUse.HOME) {
				usage = org.husky.common.enums.PostalAddressUse.HOME_ADDRESS;
			}
			if (addr.getUseElement().getValue() == org.hl7.fhir.r4.model.Address.AddressUse.TEMP) {
				usage = org.husky.common.enums.PostalAddressUse.PUBLIC;
			}
			final var eHCAddr = new Address(new AddressBaseType());
			eHCAddr.setStreetAddressLine1(addr.getLine().get(0).toString());
			eHCAddr.setPostalCode(addr.getPostalCode());
			eHCAddr.setCity(addr.getCity());
			eHCAddr.setUsage(usage);
			eHCAddr.setCountry(addr.getCountry());
			retVal.getAssignedEntity().getAddr().add(eHCAddr.getHl7CdaR2Ad());
		}

		// Add Telecoms
		List<Telecom> telecoms = getTelecoms(fhirObject.getTelecom());
		for (Telecom telecom : telecoms) {
			if (telecom != null) {
				retVal.getAssignedEntity().getTelecom().add(telecom.getHl7CdaR2Tel());
			}
		}

		// Add organization
		if ((fhirObject.getManagingOrganization().getResource() != null)
				&& !fhirObject.getManagingOrganization().getResource().isEmpty()) {
			var org = getOrganization(fhirObject.getManagingOrganization().getResource());
			if (org != null) {
				retVal.getAssignedEntity().setRepresentedOrganization(org.getHl7CdaR2Pocdmt000040Organization());
			}
		}

		return retVal;

	}

	/**
	 * <div class="en">Gets a eHC Code to be used as practice setting code from
	 * the FHIR DocumentReference object.
	 *
	 * @param fhirObject
	 *            the FHIR object
	 * @return eHC Code to be used as format code </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static Code getPracticeSettingCode(DocumentReference fhirObject) {
		Code retVal = null;
		final List<Extension> extensions = fhirObject
				.getExtensionsByUrl(FhirCommon.URN_USE_AS_PRACTICE_SETTING_CODE);
		if (!extensions.isEmpty())
			retVal = FhirUtilities.toCode((Coding) extensions.get(0).getValue());
		return retVal;
	}

	/**
	 * <div class="en">Gets the eHC Telecoms from the given FHIR object.
	 *
	 * @param fhirContactPoints
	 *            a list of FHIR ContactPoint resources
	 * @return eHC Telecoms</div> <div class="de"></div> <div class="fr"></div>
	 */
	public static List<Telecom> getTelecoms(List<ContactPoint> fhirContactPoints) {
		final List<Telecom> eHCTelecoms = new LinkedList<>();
		for (final ContactPoint telco : fhirContactPoints) {
			org.husky.common.enums.TelecomAddressUse usage = org.husky.common.enums.TelecomAddressUse.BUSINESS;
			if (telco.getUseElement().getValue() == ContactPointUse.HOME) {
				usage = org.husky.common.enums.TelecomAddressUse.PRIVATE;
			}
			if (telco.getUseElement().getValue() == ContactPointUse.TEMP) {
				usage = org.husky.common.enums.TelecomAddressUse.PUBLIC;
			}
			final String value = telco.getValue();
			final var eHCTelecom = new Telecom();
			if (value.toLowerCase().startsWith("tel:")) {
				eHCTelecom.setPhone(value.substring(4, value.length()));
			} else if (value.toLowerCase().startsWith("fax:")) {
				eHCTelecom.setFax(value.substring(4, value.length()));
			} else if (value.toLowerCase().startsWith("mailto:")) {
				eHCTelecom.setMail(value.substring(7, value.length()));
			} else if (value.toLowerCase().startsWith("http:")) {
				eHCTelecom.setValue(value);
			}

			eHCTelecom.setUsage(usage);
			eHCTelecoms.add(eHCTelecom);
		}
		return eHCTelecoms;
	}

	/**
	 * <div class="en">reads the given XML file (UTF-8) into a string</div>
	 * <div class="de"></div> <div class="fr"></div>.
	 *
	 * @param fileName
	 *            <div class="en">file to read</div> <div class="de"></div>
	 *            <div class="fr"></div>
	 * @return the given XML file (UTF-8)<div class="en">string containing the
	 *         XML file content</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 * @throws IOException 
	 */
	public static String getXmlResource(String fileName){
		final var sb = new StringBuilder();
		try (final var bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))){
			String line;
			try {
				while ((line = bufferedReader.readLine()) != null) {
					sb.append(line);
				}
			} catch (final IOException e) {
				log.error(e.getMessage(), e);
			}
		} catch (final FileNotFoundException | UnsupportedEncodingException e1) {
			log.error(e1.getMessage(), e1);
		} catch (IOException e2) {
			log.error(e2.getMessage(), e2);
		}
		return sb.toString();
	}

	/**
	 * <div class="en">removes urn:oid: prefix of the given string</div>
	 * <div class="de"></div> <div class="fr"></div>.
	 *
	 * @param value
	 *            <div class="en">value string beginning with the
	 *            urn:oid:prefix</div> <div class="de"></div>
	 *            <div class="fr"></div>
	 * @return <div class="en">string without the prefix</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public static String removeUrnOidPrefix(String value) {
		var retVal = "";
		if (value != null) {
			if (value.toLowerCase().startsWith(OID_URN))
				retVal = value.replace(OID_URN, "");
			else {
				retVal = value;
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Stores the given FHIR resource to disk</div>
	 *
	 * @param log
	 *            the logger
	 * @param fhirResource
	 *            FHIR resource to save
	 * @param path
	 *            Directory where to save the file
	 * @param fileName
	 *            filename of the file to be created
	 * @param saveMode
	 *            how to save the resource (NONE: does nothing; LOG: writed the
	 *            resource as debug entry to the log; FILE creates an XML File
	 *            on your disk using the given fileName)
	 * @return true when save was successful; false otherwise
	 */
	public static boolean saveResource(Logger log, String path, IBaseResource fhirResource,
			String fileName, SaveMode saveMode) {
		var retVal = true;
		final String separator = "/";
		String fullFn = path;
		if (!path.endsWith(separator))
			fullFn = fullFn + separator;
		fullFn = fullFn + fileName;
		if ((saveMode == null) || (saveMode == SaveMode.NONE)) {
			return true;
		}
		Writer writer;
		try {
			if (saveMode == SaveMode.LOG) {
				writer = new StringWriter();
				writer.write(fullFn + "\n");
				writer.write("----------------------------------------\n");
			} else {
				writer = new BufferedWriter(new FileWriter(fullFn));
			}
			final var fhirCtx = new FhirContext(FhirVersionEnum.R4);
			fhirCtx.newXmlParser().setPrettyPrint(true).encodeResourceToWriter(fhirResource,
					writer);

			if (log != null && log.isDebugEnabled()) {
				if (saveMode == SaveMode.LOG) {
					log.debug(writer.toString());
				} else {
					log.debug(fullFn);
				}
			}
		} catch (final IOException e) {
			if (log != null)
				log.error(e.getMessage());
			retVal = false;
		}
		return retVal;
	}

	/**
	 * Sets the functionCode Element of the author
	 *
	 * @param author
	 *            the author
	 * @param fhirResource
	 *            any FHIR DomainResource containing the extension
	 *            urnUseAsFunctionCode
	 */
	private static void setAuthorFuntionCode(org.husky.common.model.Author author,
			DomainResource fhirResource) {
		final List<Extension> extensions = fhirResource
				.getExtensionsByUrl(FhirCommon.URN_USE_AS_FUNCTION_CODE);
		if (!extensions.isEmpty()) {
			final var coding = (Coding) extensions.get(0).getValue();
			final var code = FhirUtilities.toCode(coding);
			code.setCodeSystemName(coding.getVersion());
			author.setFunctionCode(code);
		}

	}

	/**
	 * Sets the functionCode Element of the author
	 *
	 * @param performer    the author
	 * @param fhirResource any FHIR DomainResource containing the extension
	 *                     urnUseAsFunctionCode
	 */
	private static void setPerformerFuntionCode(POCDMT000040Performer2 performer, DomainResource fhirResource) {
		final List<Extension> extensions = fhirResource.getExtensionsByUrl(FhirCommon.URN_USE_AS_FUNCTION_CODE);
		if (!extensions.isEmpty()) {
			final var coding = (Coding) extensions.get(0).getValue();
			final var code = FhirUtilities.toCode(coding);
			code.setCodeSystemName(coding.getVersion());
			performer.getAssignedEntity().setCode(code.getHl7CdaR2Ce());
		}

	}
}
