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

package org.ehealth_connector.fhir;

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
import java.util.List;

import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.AuthoringDevice;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.Confidentiality;
import org.ehealth_connector.common.enums.Isco08;
import org.ehealth_connector.common.utils.FileUtil;
import org.hl7.fhir.dstu3.model.Basic;
import org.hl7.fhir.dstu3.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.ContactPoint;
import org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.dstu3.model.DocumentManifest;
import org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent;
import org.hl7.fhir.dstu3.model.DocumentReference;
import org.hl7.fhir.dstu3.model.DomainResource;
import org.hl7.fhir.dstu3.model.Enumeration;
import org.hl7.fhir.dstu3.model.Extension;
import org.hl7.fhir.dstu3.model.HumanName;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Observation.ObservationStatus;
import org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent;
import org.hl7.fhir.dstu3.model.Practitioner;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.Resource;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.mdht.uml.hl7.vocab.PostalAddressUse;
import org.slf4j.Logger;

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

	/** The Constant AHDIS_COMMUNITY_OID. */
	public static final String AHDIS_COMMUNITY_OID = "2.16.756.5.37";

	/** The Constant AHDIS_SOURCE_OID_PREFIX. */
	public static final String AHDIS_SOURCE_OID_PREFIX = "1.3.6.1.4.1.21367";

	/** The Constant NIST_COMMUNITY_OID. */
	public static final String NIST_COMMUNITY_OID = "1.3.6.1.4.1.21367.2005.13.20.3000";

	/** The Constant NIST_SOURCE_OID_PREFIX. */
	public static final String NIST_SOURCE_OID_PREFIX = "1.3.6.1.4.1.21367";

	/** The urn prefix for OIDs. */
	public static final String oidUrn = "urn:oid:";

	/** The urn prefix for UUIDs. */
	public static final String uuidUrn = "urn:uuid:";

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String oidLanguage = oidUrn + CodeSystems.LanguageCode.getCodeSystemId();

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsActiveProblemConcern = "urn:ehealth_connector:FhirExtension:useAsActiveProblemConcern";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsActiveProblemConcernEntries = "urn:ehealth_connector:FhirExtension:uAsActiveProblemConcernEntries";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsAcuityAssessment = "urn:ehealth_connector:FhirExtension:useAsAcuityAssessment";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsAdvanceDirectives = "urn:ehealth_connector:FhirExtension:useAsAdvanceDirectives";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsAllergyProblemConcern = "urn:ehealth_connector:FhirExtension:useAsAllergyProblemConcern";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsAllergyProblemConcernEntries = "urn:ehealth_connector:FhirExtension:useAsAllergyProblemConcernEntries";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsAssessmentAndPlan = "urn:ehealth_connector:FhirExtension:useAsAssessmentAndPlan";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsAuthor = "urn:ehealth_connector:FhirExtension:useAsAuthor";
	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static String urnUseAsAuthorLrqc = "urn:ehealth_connector:FhirExtension:useAsAuthorLrqc";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsBloodGroup = "urn:ehealth_connector:FhirExtension:useAsBloodGroup";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsChiefComplaint = "urn:ehealth_connector:FhirExtension:useAsChiefComplaint";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCode = "urn:ehealth_connector:FhirExtension:urnUseAsCode";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCodedPhysicalExam = "urn:ehealth_connector:FhirExtension:useAsCodedPhysicalExam";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCodedResultObservations = "urn:ehealth_connector:FhirExtension:useAsCodedResultObservations";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCodedVitalSignList = "urn:ehealth_connector:FhirExtension:urnUseAsCodedVitalSignList";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCodedVitalSignObservation = "urn:ehealth_connector:FhirExtension:useAsCodedVitalSignObservation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCodedVitalSigns = "urn:ehealth_connector:FhirExtension:useAsCodedVitalSigns";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsComment = "urn:ehealth_connector:FhirExtension:useAsComment";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsConfidentiality = "urn:ehealth_connector:FhirExtension:useAsConfidentiality";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCriterion = "urn:ehealth_connector:FhirExtension:useAsCriterion";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCurrentMedications = "urn:ehealth_connector:FhirExtension:useAsCurrentMedications";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCustodian = "urn:ehealth_connector:FhirExtension:useAsCustodian";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsDocType = "urn:ehealth_connector:FhirExtension:useAsDocType";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsDocumentationOf = "urn:ehealth_connector:FhirExtension:useAsDocumentationOf";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsDocumentDescriptor = "urn:ehealth_connector:FhirExtension:useAsDocumentDescriptor";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsDocVersion = "urn:ehealth_connector:FhirExtension:urnUseAsDocVersion";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsEdConsultations = "urn:ehealth_connector:FhirExtension:useAsEdConsultations";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsEdDiagnosis = "urn:ehealth_connector:FhirExtension:useAsEdDiagnosis";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsEdDisposition = "urn:ehealth_connector:FhirExtension:useAsEdDisposition";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsExternalDocument = "urn:ehealth_connector:FhirExtension:useAsExternalDocument";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsFunctionCode = "urn:ehealth_connector:FhirExtension:urnUseAsFunctionCode";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsFamilyMedicalHistory = "urn:ehealth_connector:FhirExtension:useAsFamilyMedicalHistory";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsHistoryOfImmunization = "urn:ehealth_connector:FhirExtension:useAsHistoryOfImmunization";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsHistoryOfPresentIllness = "urn:ehealth_connector:FhirExtension:useAsHistoryOfPresentIllness";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsIdentifier = "urn:ehealth_connector:FhirExtension:useAsIdentifier";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsImmunization = "urn:ehealth_connector:FhirExtension:useAsImmunization";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsImmunizationRecommendation = "urn:ehealth_connector:FhirExtension:useAsImmunizationRecommendation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsInformationRecipient = "urn:ehealth_connector:FhirExtension:useAsInformationRecipient";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsClaimer = "urn:ehealth_connector:FhirExtension:useAsClaimer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsInFulfillmentOf = "urn:ehealth_connector:FhirExtension:urnUseAsInFulfillmentOf";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLaboratoryBatteryOrganizer = "urn:ehealth_connector:FhirExtension:useAsLaboratoryBatteryOrganizer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLaboratoryIsolateOrganizer = "urn:ehealth_connector:FhirExtension:useAsLaboratoryIsolateOrganizer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLaboratoryObservation = "urn:ehealth_connector:FhirExtension:useAsLaboratoryObservation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLaboratoryObservations = "urn:ehealth_connector:FhirExtension:useAsLaboratoryObservations";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLaboratoryReportDataProcessingEntry = "urn:ehealth_connector:FhirExtension:useAsLaboratoryReportDataProcessingEntry";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLaboratorySpecialtySection = "urn:ehealth_connector:FhirExtension:useAsLaboratorySpecialtySection";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLanguage = "urn:ehealth_connector:FhirExtension:useAsLanguage";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLegalAuthenticator = "urn:ehealth_connector:FhirExtension:useAsLegalAuthenticator";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsListOfSurgeries = "urn:ehealth_connector:FhirExtension:useAsListOfSurgeries";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLotNumbertext = "urn:ehealth_connector:FhirExtension:urnUseAsLotNumbertext";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsMedicationTarget = "urn:ehealth_connector:FhirExtension:useAsMedicationTarget";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsMetadataLanguage = "urn:ehealth_connector:FhirExtension:useAsMetadataLanguage";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsMimeType = "urn:ehealth_connector:FhirExtension:useAsMimeType";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsModeOfArrival = "urn:ehealth_connector:FhirExtension:useAsModeOfArrival";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsNonLivingSubject = "urn:ehealth_connector:FhirExtension:useAsNonLivingSubject";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsNotificationOrganizer = "urn:ehealth_connector:FhirExtension:useAsNotificationOrganizer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsObservationMedia = "urn:ehealth_connector:FhirExtension:useAsObservationMedia";

	public static final String urnUseAsOrganizer = "urn:ehealth_connector:FhirExtension:useAsOrganizer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsOutbreakIdentification = "urn:ehealth_connector:FhirExtension:useAsOutbreakIdentification";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsParticipant = "urn:ehealth_connector:FhirExtension:useAsParticipant";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsPastProblemConcern = "urn:ehealth_connector:FhirExtension:useAsPastProblemConcern";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsPastProblemConcernEntries = "urn:ehealth_connector:FhirExtension:useAsPastProblemConcernEntries";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsPatient = "urn:ehealth_connector:FhirExtension:useAsPatient";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsPerformer = "urn:ehealth_connector:FhirExtension:useAsPerformer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsPracticeSettingCode = "urn:ehealth_connector:FhirExtension:useAsPracticeSettingCode";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsPregnancyObservation = "urn:ehealth_connector:FhirExtension:urnUseAsPregnancyObservation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsProcedures = "urn:ehealth_connector:FhirExtension:useAsProcedures";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsProgressNote = "urn:ehealth_connector:FhirExtension:useAsProgressNote";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsReason = "urn:ehealth_connector:FhirExtension:useAsReason";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsReasonForVisit = "urn:ehealth_connector:FhirExtension:useAsReasonForVisit";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsReferenceRange = "urn:ehealth_connector:FhirExtension:useAsReferenceRange";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsReferralOrderingPhysician = "urn:ehealth_connector:FhirExtension:useAsReferralOrderingPhysician";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsReferralSource = "urn:ehealth_connector:FhirExtension:useAsReferralSource";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsRegistryDestination = "urn:ehealth_connector:FhirExtension:useAsRegistryDestination";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsRelatedDocument = "urn:ehealth_connector:FhirExtension:useAsRelatedDocument";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsRepositoryDestination = "urn:ehealth_connector:FhirExtension:useAsRepositoryDestination";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsResults = "urn:ehealth_connector:FhirExtension:useAsResults";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsSocialHistory = "urn:ehealth_connector:FhirExtension:useAsSocialHistory";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsSpecimenCollection = "urn:ehealth_connector:FhirExtension:useAsSpecimenCollection";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsSpecimenReceived = "urn:ehealth_connector:FhirExtension:useAsSpecimenReceived";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsStudiesSummary = "urn:ehealth_connector:FhirExtension:useAsStudiesSummary";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsVitalSignsObservation = "urn:ehealth_connector:FhirExtension:useAsVitalSignsObservation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsVitalSignsOrganizer = "urn:ehealth_connector:FhirExtension:useAsVitalSignsOrganizer";

	/**
	 * Adds a FHIR resource to the document
	 *
	 * @param documentManifest
	 *            the FHIR document
	 * @param resource
	 *            the FHIR resource to be added to the document
	 * @return the content
	 */
	public static DocumentManifestContentComponent addDocManifestContent(
			DocumentManifest documentManifest, Resource resource) {
		DocumentManifestContentComponent content = new DocumentManifestContentComponent();
		Reference ref = new Reference();
		ref.setResource(resource);
		content.setP(ref);
		documentManifest.addContent(content);
		return content;
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
		if (!retVal.startsWith(oidUrn))
			retVal = oidUrn + oid;
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
		if (!retVal.startsWith(uuidUrn))
			retVal = uuidUrn + uuid;
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
		CodeableConcept retVal = new CodeableConcept();
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
		Coding retVal = new Coding();
		retVal.setSystem(FhirCommon.addUrnOid(systemOid));
		retVal.setCode(value);
		retVal.setDisplay(displayName);
		return retVal;

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
		final Observation retVal = new Observation();
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
		CodeableConcept cc = new CodeableConcept();
		Coding fCode;

		fCode = new Coding();
		fCode.setSystem(addUrnOid(code.getCodeSystem()));
		fCode.setCode(code.getCode());
		fCode.setDisplay(code.getDisplayName());
		cc.addCoding(fCode);

		for (Code translation : code.getTranslations()) {
			Coding cdt = new Coding();
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
	public static Address fhirAddressToEhcAddress(org.hl7.fhir.dstu3.model.Address fAddr) {
		final Address addr = new Address();
		for (StringType line : fAddr.getLine()) {
			addr.getMdhtAdress().addStreetAddressLine(line.asStringValue());
		}
		if (fAddr.getPostalCode() != null) {
			addr.setZip(fAddr.getPostalCode());
		}
		if (fAddr.getCity() != null) {
			addr.setCity(fAddr.getCity());
		}
		if (fAddr.getCountry() != null) {
			addr.setCountry(fAddr.getCountry());
		}
		if (fAddr.getState() != null) {
			addr.getMdhtAdress().addState(fAddr.getState());
		}
		final Enumeration<org.hl7.fhir.dstu3.model.Address.AddressUse> useElement = fAddr
				.getUseElement();
		if (useElement.getValue() == org.hl7.fhir.dstu3.model.Address.AddressUse.HOME) {
			addr.getMdhtAdress().getUses().add(PostalAddressUse.HP);
		}
		if (useElement.getValue() == org.hl7.fhir.dstu3.model.Address.AddressUse.OLD) {
			addr.getMdhtAdress().getUses().add(PostalAddressUse.BAD);
		}
		// We use TMP for PUB, because it is required in LRQC but not
		// available in FHIR ;)
		if (useElement.getValue() == org.hl7.fhir.dstu3.model.Address.AddressUse.TEMP) {
			addr.getMdhtAdress().getUses().add(PostalAddressUse.PUB);
		}
		if (useElement.getValue() == org.hl7.fhir.dstu3.model.Address.AddressUse.WORK) {
			addr.getMdhtAdress().getUses().add(PostalAddressUse.WP);
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
			for (int i = 1; i < codableConcept.getCoding().size(); i++) {
				final Coding fhirCode = codableConcept.getCoding().get(i);
				code.addTranslation(new Code(removeUrnOidPrefix(fhirCode.getSystem()),
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
		Name name = null;
		if (!fName.getGivenAsSingleString().isEmpty() && !fName.getFamily().isEmpty()) {
			name = new Name(fName.getGivenAsSingleString(), fName.getFamily());
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
		String retVal = xhtmlNode.getValueAsString();
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
	public static org.ehealth_connector.common.Author getAuthor(IBaseResource res) {
		org.ehealth_connector.common.Author retVal = null;
		if (res instanceof org.hl7.fhir.dstu3.model.Person) {
			retVal = FhirCommon.getAuthor((org.hl7.fhir.dstu3.model.Person) res);
		}
		if (res instanceof Practitioner) {
			retVal = FhirCommon.getAuthor((Practitioner) res);
		}
		if (res instanceof org.hl7.fhir.dstu3.model.Organization) {
			retVal = FhirCommon.getAuthor((org.hl7.fhir.dstu3.model.Organization) res);
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
	public static org.ehealth_connector.common.Author getAuthor(
			org.hl7.fhir.dstu3.model.Organization fhirObject) {
		org.ehealth_connector.common.Author retVal = null;
		final String authoringDeviceName = fhirObject.getName();

		// Create the author
		final AuthoringDevice ad = new AuthoringDevice(authoringDeviceName);
		retVal = new org.ehealth_connector.common.Author(ad);
		retVal.setFunctionCode(Author.FUNCTION_CODE_AUTHORDEVICE);

		// Set Function Code
		setAuthorFuntionCode(retVal, fhirObject);

		// Add Identifiers
		for (final Identifier id : fhirObject.getIdentifier()) {
			final String codeSystem = FhirCommon.removeUrnOidPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (final org.hl7.fhir.dstu3.model.Address addr : fhirObject.getAddress()) {
			org.ehealth_connector.common.enums.AddressUse usage = org.ehealth_connector.common.enums.AddressUse.BUSINESS;
			if (addr.getUseElement()
					.getValue() == org.hl7.fhir.dstu3.model.Address.AddressUse.HOME) {
				usage = org.ehealth_connector.common.enums.AddressUse.PRIVATE;
			}
			if (addr.getUseElement()
					.getValue() == org.hl7.fhir.dstu3.model.Address.AddressUse.TEMP) {
				usage = org.ehealth_connector.common.enums.AddressUse.PUBLIC;
			}
			final Address eHCAddr = new Address(addr.getLine().get(0).toString(),
					addr.getPostalCode(), addr.getCity(), usage);
			if (addr.getCountry() != null) {
				eHCAddr.setCountry(addr.getCountry());
			}
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(getTelecoms(fhirObject.getTelecom()));

		// Add OrganizationName
		OrganizationContactComponent contact = fhirObject.getContactFirstRep();
		if (contact != null) {
			String name = contact.getName().getFamily();
			if (name != null)
				if (!"".equals(name))
					retVal.setOrganization(new org.ehealth_connector.common.Organization(name));
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
	public static org.ehealth_connector.common.Author getAuthor(
			org.hl7.fhir.dstu3.model.Person fhirObject) {
		org.ehealth_connector.common.Author retVal = null;
		final Name personName = new Name(fhirObject.getNameFirstRep().getGivenAsSingleString(),
				fhirObject.getNameFirstRep().getFamily());

		// Create the author
		retVal = new org.ehealth_connector.common.Author(personName);

		// Set Function Code
		setAuthorFuntionCode(retVal, fhirObject);

		// Add Identifiers
		for (final Identifier id : fhirObject.getIdentifier()) {
			final String codeSystem = FhirCommon.removeUrnOidPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (final org.hl7.fhir.dstu3.model.Address addr : fhirObject.getAddress()) {
			org.ehealth_connector.common.enums.AddressUse usage = org.ehealth_connector.common.enums.AddressUse.BUSINESS;
			if (addr.getUseElement()
					.getValue() == org.hl7.fhir.dstu3.model.Address.AddressUse.HOME) {
				usage = org.ehealth_connector.common.enums.AddressUse.PRIVATE;
			}
			if (addr.getUseElement()
					.getValue() == org.hl7.fhir.dstu3.model.Address.AddressUse.TEMP) {
				usage = org.ehealth_connector.common.enums.AddressUse.PUBLIC;
			}
			final Address eHCAddr = new Address(addr.getLine().get(0).toString(),
					addr.getPostalCode(), addr.getCity(), usage);
			eHCAddr.setCountry(addr.getCountry());
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(getTelecoms(fhirObject.getTelecom()));

		// Add organization
		if (fhirObject.getManagingOrganization().getResource() != null
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
	public static org.ehealth_connector.common.Author getAuthor(
			org.hl7.fhir.dstu3.model.Reference ref) {
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
	public static org.ehealth_connector.common.Author getAuthor(Practitioner fhirObject) {
		org.ehealth_connector.common.Author retVal = null;
		final Name personName = new Name(fhirObject.getName().get(0).getGivenAsSingleString(),
				fhirObject.getName().get(0).getFamily());

		// Create the author
		retVal = new org.ehealth_connector.common.Author(personName);

		// Set Function Code
		setAuthorFuntionCode(retVal, fhirObject);

		// Add Identifiers
		for (final Identifier id : fhirObject.getIdentifier()) {
			final String codeSystem = FhirCommon.removeUrnOidPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (final org.hl7.fhir.dstu3.model.Address addr : fhirObject.getAddress()) {
			org.ehealth_connector.common.enums.AddressUse usage = org.ehealth_connector.common.enums.AddressUse.BUSINESS;
			if (addr.getUseElement()
					.getValue() == org.hl7.fhir.dstu3.model.Address.AddressUse.HOME) {
				usage = org.ehealth_connector.common.enums.AddressUse.PRIVATE;
			}
			final Address eHCAddr = new Address(addr.getLine().get(0).toString(),
					addr.getPostalCode(), addr.getCity(), usage);
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
	public static Identificator getCommunityPatientId(org.ehealth_connector.common.Patient patient,
			String communityOid) {
		Identificator retVal = null;
		for (final Identificator item : patient.getIds()) {

			if (item.getRoot().replace("urn:oid:", "")
					.equals(communityOid.replace("urn:oid:", ""))) {
				retVal = new Identificator(item.getRoot(), item.getExtension());
				break;
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
		Basic docRestrictedConfidentiality = new Basic();
		Confidentiality conf = Confidentiality.NORMAL;
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
		Basic docRestrictedConfidentiality = new Basic();
		Confidentiality conf = Confidentiality.RESTRICTED;
		docRestrictedConfidentiality.setCode(FhirCommon.createCodeableConcept(
				conf.getCodeSystemOid(), conf.getCodeValue(), conf.getDisplayName()));
		return docRestrictedConfidentiality;

	}

	/**
	 * <div class="en">Gets an OHT DocumentDescriptor object from the given FHIR
	 * object.
	 *
	 * @param fhirObject
	 *            the FHIR object
	 * @return OHT DocumentDescriptor object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static DocumentDescriptor getDocumentDescriptor(DocumentReference fhirObject) {
		String mimeType = "";
		fhirObject.getContentFirstRep().getFormat();
		Coding item = fhirObject.getContentFirstRep().getFormat();
		final List<Extension> extensions = item
				.getExtensionsByUrl(FhirCommon.urnUseAsDocumentDescriptor);
		if (!extensions.isEmpty()) {
			mimeType = item.getCode();
		}
		return DocumentDescriptor.getDocumentDescriptorForMimeType(mimeType);
	}

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
		return new Coding("urn:oid:2.999", "dummy", "dummy code to make FHIR resource valid");
	}

	/**
	 * Gets a dummmy code in order to make the FHIR resource valid
	 *
	 * @return the dummy code
	 */
	public static CodeableConcept getDummyCodeableConcept() {
		CodeableConcept retVal = new CodeableConcept();
		retVal.addCoding(getDummyCode());
		return retVal;
	}

	/**
	 * Gets a dummmy reference in order to make the FHIR resource valid
	 *
	 * @return the dummy reference
	 */
	public static Reference getDummyReference() {
		Reference dummyRef = new Reference();
		dummyRef.setDisplay("dummy");
		return dummyRef;

	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension ActiveProblemConcern
	 */
	public static Extension getExtensionActiveProblemConcern() {
		return new Extension(FhirCommon.urnUseAsActiveProblemConcern, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension AdvanceDirectives
	 */
	public static Extension getExtensionAdvanceDirectives() {
		return new Extension(FhirCommon.urnUseAsAdvanceDirectives, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension AllergyProblemConcern
	 */
	public static Extension getExtensionAllergyProblemConcern() {
		return new Extension(FhirCommon.urnUseAsAllergyProblemConcern, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension author
	 */
	public static Extension getExtensionAuthor() {
		return new Extension(FhirCommon.urnUseAsAuthor, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension ChiefComplaint
	 */
	public static Extension getExtensionChiefComplaint() {
		return new Extension(FhirCommon.urnUseAsChiefComplaint, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension custodian
	 */
	public static Extension getExtensionClaimer() {
		return new Extension(FhirCommon.urnUseAsClaimer, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension CodedVitalSignObservation
	 */
	public static Extension getExtensionCodedVitalSignObservation() {
		return new Extension(FhirCommon.urnUseAsCodedVitalSignObservation, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension comment
	 */
	public static Extension getExtensionComment() {
		return new Extension(FhirCommon.urnUseAsComment, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension criterion
	 */
	public static Extension getExtensionCriterion() {
		return new Extension(FhirCommon.urnUseAsCriterion, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension custodian
	 */
	public static Extension getExtensionCustodian() {
		return new Extension(FhirCommon.urnUseAsCustodian, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension criterion
	 */
	public static Extension getExtensionDocType() {
		return new Extension(FhirCommon.urnUseAsDocType, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension document descriptor
	 */
	public static Extension getExtensionDocumentDescriptor() {
		return new Extension(FhirCommon.urnUseAsDocumentDescriptor, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension external document
	 */
	public static Extension getExtensionExternalDocument() {
		return new Extension(FhirCommon.urnUseAsExternalDocument, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension FunctionCodeDoctor
	 */
	public static Extension getExtensionFunctionCodeDoctor() {
		Isco08 functionCode = Isco08.MEDICAL_DOCTORS;
		Coding code = new Coding(functionCode.getCodeSystemName(), functionCode.getCodeValue(),
				functionCode.getDisplayName());
		return new Extension(FhirCommon.urnUseAsFunctionCode, code);
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension FunctionCodeDoctor
	 */
	public static Extension getExtensionFunctionCodeLabTechnician() {
		Isco08 functionCode = Isco08.MEDICAL_AND_PATHOLOGY_LABORATORY_TECHNICIANS;
		Coding code = new Coding();
		code.setSystem(FhirCommon.addUrnOid(functionCode.getCodeSystemOid()));
		code.setCode(functionCode.getCodeValue());
		code.setDisplay(functionCode.getDisplayName());
		code.setVersion(functionCode.getCodeSystemName());
		return new Extension(FhirCommon.urnUseAsFunctionCode, code);
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension InformationRecipient
	 */
	public static Extension getExtensionInformationRecipient() {
		return new Extension(FhirCommon.urnUseAsInformationRecipient, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 */
	public static Extension getExtensionLaboratoryBatteryOrganizer() {
		return new Extension(FhirCommon.urnUseAsLaboratoryBatteryOrganizer,
				new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 */
	public static Extension getExtensionLaboratoryObservations() {
		return new Extension(FhirCommon.urnUseAsLaboratoryObservations, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension medication target
	 */
	public static Extension getExtensionMedicationTarget() {
		return new Extension(FhirCommon.urnUseAsMedicationTarget, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension metadata language
	 */
	public static Extension getExtensionMetadataLanguage() {
		return new Extension(FhirCommon.urnUseAsMetadataLanguage, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension mime type
	 */
	public static Extension getExtensionMimeType() {
		return new Extension(FhirCommon.urnUseAsMimeType, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension author
	 */
	public static Extension getExtensionNonLivingSubject() {
		return new Extension(FhirCommon.urnUseAsNonLivingSubject, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension author
	 */
	public static Extension getExtensionParticipant() {
		return new Extension(FhirCommon.urnUseAsParticipant, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension performer
	 */
	public static Extension getExtensionPerformer() {
		return new Extension(FhirCommon.urnUseAsPerformer, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension practice setting code
	 */
	public static Extension getExtensionPracticeSettingCode() {
		return new Extension(FhirCommon.urnUseAsPracticeSettingCode, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension reason
	 */
	public static Extension getExtensionReason() {
		return new Extension(FhirCommon.urnUseAsReason, new StringType("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension repository destination
	 */
	public static Extension getExtensionRepositoryDestination() {
		return new Extension(FhirCommon.urnUseAsRepositoryDestination, new StringType("dummy"));
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
		return new Code(fhirObject.getContentFirstRep().getFormat());
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the information recipient
	 */
	public static Extension getInformationRecipient() {
		return new Extension(FhirCommon.urnUseAsInformationRecipient, new StringType("dummy"));
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
		String retVal = "";
		final List<Extension> extensions = fhirObject
				.getExtensionsByUrl(FhirCommon.urnUseAsMetadataLanguage);
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
		String retVal = "";
		final Coding item = fhirObject.getContentFirstRep().getFormat();
		final List<Extension> extensions = item.getExtensionsByUrl(FhirCommon.urnUseAsMimeType);
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
	public static org.ehealth_connector.common.Organization getOrganization(IBaseResource res) {
		org.ehealth_connector.common.Organization retVal = null;
		if (res instanceof org.hl7.fhir.dstu3.model.Organization) {
			retVal = FhirCommon.getOrganization((org.hl7.fhir.dstu3.model.Organization) res);
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
	public static org.ehealth_connector.common.Organization getOrganization(
			org.hl7.fhir.dstu3.model.Organization fhirOrganization) {
		org.ehealth_connector.common.Organization retVal = null;
		// Create the organization
		if (fhirOrganization.getName() != null) {
			retVal = new org.ehealth_connector.common.Organization(fhirOrganization.getName());

			// Add Identifiers
			for (final Identifier id : fhirOrganization.getIdentifier()) {
				final String codeSystem = FhirCommon.removeUrnOidPrefix(id.getSystem());
				retVal.addId(new Identificator(codeSystem, id.getValue()));
			}

			// Add Addresses
			for (final org.hl7.fhir.dstu3.model.Address addr : fhirOrganization.getAddress()) {
				org.ehealth_connector.common.enums.AddressUse usage = org.ehealth_connector.common.enums.AddressUse.BUSINESS;
				if (addr.getUseElement()
						.getValue() == org.hl7.fhir.dstu3.model.Address.AddressUse.HOME) {
					usage = org.ehealth_connector.common.enums.AddressUse.PRIVATE;
				}
				if (addr.getUseElement()
						.getValue() == org.hl7.fhir.dstu3.model.Address.AddressUse.TEMP) {
					usage = org.ehealth_connector.common.enums.AddressUse.PUBLIC;
				}
				final Address eHCAddr = new Address();
				eHCAddr.setAddressline1(addr.getLine().get(0).toString());
				if (addr.getLine().size() > 1) {
					eHCAddr.setAddressline2(addr.getLine().get(1).getValueAsString());
				}
				eHCAddr.setZip(addr.getPostalCode());
				eHCAddr.setCity(addr.getCity());
				eHCAddr.setCountry(addr.getCountry());
				eHCAddr.setUsage(usage);
				retVal.addAddress(eHCAddr);
			}

			// Add Telecoms
			retVal.setTelecoms(FhirCommon.getTelecoms(fhirOrganization.getTelecom()));

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
	public static org.ehealth_connector.common.Organization getOrganization(
			org.hl7.fhir.dstu3.model.Reference orgRef) {
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
	public static org.ehealth_connector.common.Patient getPatient(IBaseResource res) {
		org.ehealth_connector.common.Patient retVal = null;
		if (res instanceof org.hl7.fhir.dstu3.model.Patient) {
			retVal = FhirCommon.getPatient((org.hl7.fhir.dstu3.model.Patient) res);
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
	public static org.ehealth_connector.common.Patient getPatient(
			org.hl7.fhir.dstu3.model.Bundle bundle) {
		org.hl7.fhir.dstu3.model.Patient fhirPatient = null;
		for (final BundleEntryComponent entry : bundle.getEntry()) {
			if (entry.getResource() instanceof org.hl7.fhir.dstu3.model.Patient)
				fhirPatient = (org.hl7.fhir.dstu3.model.Patient) entry.getResource();
		}
		return getPatient(fhirPatient);
	}

	/**
	 * <div class="en"> Gets an eHC Patient object from the given FHIR resource.
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return eHC Patient object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static org.ehealth_connector.common.Patient getPatient(
			org.hl7.fhir.dstu3.model.DocumentManifest docManifest) {
		org.hl7.fhir.dstu3.model.Patient fhirPatient = null;
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			Reference ref = null;
			try {
				if (entry.hasPReference())
					ref = entry.getPReference();
			} catch (FHIRException e) {
			}
			if (ref != null) {
				if (ref.getResource() instanceof org.hl7.fhir.dstu3.model.Patient)
					fhirPatient = (org.hl7.fhir.dstu3.model.Patient) ref.getResource();
			}
		}
		return getPatient(fhirPatient);
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
	public static org.ehealth_connector.common.Patient getPatient(
			org.hl7.fhir.dstu3.model.Patient fhirPatient) {
		org.ehealth_connector.common.Patient retVal = null;
		final List<Extension> extensions = fhirPatient
				.getExtensionsByUrl(FhirCommon.urnUseAsNonLivingSubject);
		if (!extensions.isEmpty()) {
			// Create eHC Patient
			retVal = new org.ehealth_connector.common.Patient();
			retVal.setIsNonHumenSubject();
		} else {
			final Name patientName = new Name(
					fhirPatient.getNameFirstRep().getGivenAsSingleString(),
					fhirPatient.getNameFirstRep().getFamily());
			org.ehealth_connector.common.enums.AdministrativeGender gender = org.ehealth_connector.common.enums.AdministrativeGender.UNDIFFERENTIATED;
			if (fhirPatient.getGenderElement()
					.getValue() == org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.FEMALE) {
				gender = org.ehealth_connector.common.enums.AdministrativeGender.FEMALE;
			} else if (fhirPatient.getGenderElement()
					.getValue() == org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.MALE) {
				gender = org.ehealth_connector.common.enums.AdministrativeGender.MALE;
			}

			// Create eHC Patient
			retVal = new org.ehealth_connector.common.Patient(patientName, gender,
					fhirPatient.getBirthDate());

			// Add Addresses
			for (final org.hl7.fhir.dstu3.model.Address addr : fhirPatient.getAddress()) {
				org.ehealth_connector.common.enums.AddressUse usage = org.ehealth_connector.common.enums.AddressUse.BUSINESS;
				if (addr.getUseElement()
						.getValue() == org.hl7.fhir.dstu3.model.Address.AddressUse.HOME) {
					usage = org.ehealth_connector.common.enums.AddressUse.PRIVATE;
				}
				String addrLine = null;
				if (addr.getLine().size() > 0)
					addrLine = addr.getLine().get(0).toString();
				final Address eHCAddr = new Address(addrLine, addr.getPostalCode(), addr.getCity(),
						usage);
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
	public static org.ehealth_connector.common.Patient getPatient(
			org.hl7.fhir.dstu3.model.Reference orgRef) {
		return getPatient(orgRef.getResource());
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
				.getExtensionsByUrl(FhirCommon.urnUseAsPracticeSettingCode);
		if (!extensions.isEmpty())
			retVal = new Code((Coding) extensions.get(0).getValue());
		return retVal;
	}

	/**
	 * <div class="en">Gets the eHC Telecoms from the given FHIR object.
	 *
	 * @param fhirContactPoints
	 *            a list of FHIR ContactPoint resources
	 * @return eHC Telecoms</div> <div class="de"></div> <div class="fr"></div>
	 */
	public static Telecoms getTelecoms(List<ContactPoint> fhirContactPoints) {
		final Telecoms eHCTelecoms = new Telecoms();
		for (final ContactPoint telco : fhirContactPoints) {
			org.ehealth_connector.common.enums.AddressUse usage = org.ehealth_connector.common.enums.AddressUse.BUSINESS;
			if (telco.getUseElement().getValue() == ContactPointUse.HOME) {
				usage = org.ehealth_connector.common.enums.AddressUse.PRIVATE;
			}
			if (telco.getUseElement().getValue() == ContactPointUse.TEMP) {
				usage = org.ehealth_connector.common.enums.AddressUse.PUBLIC;
			}
			final String value = telco.getValue();
			if (value.toLowerCase().startsWith("tel:")) {
				eHCTelecoms.addPhone(value.substring(4, value.length()), usage);
			} else if (value.toLowerCase().startsWith("fax:")) {
				eHCTelecoms.addFax(value.substring(4, value.length()), usage);
			} else if (value.toLowerCase().startsWith("mailto:")) {
				eHCTelecoms.addEMail(value.substring(7, value.length()), usage);
			} else if (value.toLowerCase().startsWith("http:")) {
				eHCTelecoms.addWebsite(value, usage);
			}
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
	 */
	public static String getXmlResource(String fileName) {
		final StringBuffer sb = new StringBuffer();
		try {
			final BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(fileName), "UTF8"));
			String line;
			try {
				while ((line = bufferedReader.readLine()) != null) {
					sb.append(line);
				}
				bufferedReader.close();
			} catch (final IOException e) {
				e.printStackTrace();
			}
		} catch (final FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (final UnsupportedEncodingException e1) {
			e1.printStackTrace();
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
		String retVal = "";
		if (value.toLowerCase().startsWith("urn:oid:"))
			retVal = value.replace("urn:oid:", "");
		else {
			retVal = value;
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
		boolean retVal = true;
		String separator = FileUtil.getPlatformSpecificPathSeparator();
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
			final FhirContext fhirCtx = new FhirContext(FhirVersionEnum.DSTU3);
			fhirCtx.newXmlParser().setPrettyPrint(true).encodeResourceToWriter(fhirResource,
					writer);

			if (log != null) {
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
	private static void setAuthorFuntionCode(org.ehealth_connector.common.Author author,
			DomainResource fhirResource) {
		final List<Extension> extensions = fhirResource
				.getExtensionsByUrl(FhirCommon.urnUseAsFunctionCode);
		if (!extensions.isEmpty()) {
			Coding coding = (Coding) extensions.get(0).getValue();
			Code code = new Code(coding);
			code.setCodeSystemName(coding.getVersion());
			author.setFunctionCode(code);
		}

	}
}
