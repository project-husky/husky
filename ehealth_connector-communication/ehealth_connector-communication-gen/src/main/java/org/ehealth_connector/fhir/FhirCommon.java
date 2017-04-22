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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.AuthoringDevice;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.enums.AddressUse;
import org.ehealth_connector.common.enums.AdministrativeGender;
import org.ehealth_connector.common.enums.CodeSystems;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.mdht.uml.hl7.vocab.PostalAddressUse;

import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.DocumentReference;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Person;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.dstu2.valueset.AddressUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.AdministrativeGenderEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointUseEnum;
import ca.uhn.fhir.model.primitive.BoundCodeDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.model.primitive.XhtmlDt;

/**
 * <div class="en">Common material for Fhir package</div> <div class="de"></div>
 * <div class="fr"></div>.
 */
public class FhirCommon {

	/** The Constant AHDIS_COMMUNITY_OID. */
	public static final String AHDIS_COMMUNITY_OID = "2.16.756.5.37";

	/** The Constant AHDIS_SOURCE_OID_PREFIX. */
	public static final String AHDIS_SOURCE_OID_PREFIX = "1.3.6.1.4.1.21367";

	/** The Constant NIST_COMMUNITY_OID. */
	public static final String NIST_COMMUNITY_OID = "1.3.6.1.4.1.21367.2005.13.20.3000";

	/** The Constant NIST_SOURCE_OID_PREFIX. */
	public static final String NIST_SOURCE_OID_PREFIX = "1.3.6.1.4.1.21367";

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String oidLanguage = "urn:oid:"
			+ CodeSystems.LanguageCode.getCodeSystemId();

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsActiveProblemConcern = "http://www.ehealth-connector.org/fhir-extensions/useAsActiveProblemConcern";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsActiveProblemConcernEntries = "http://www.ehealth-connector.org/fhir-extensions/uAsActiveProblemConcernEntries";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsAcuityAssessment = "http://www.ehealth-connector.org/fhir-extensions/useAsAcuityAssessment";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsAdvanceDirectives = "http://www.ehealth-connector.org/fhir-extensions/useAsAdvanceDirectives";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsAllergyProblemConcern = "http://www.ehealth-connector.org/fhir-extensions/useAsAllergyProblemConcern";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsAllergyProblemConcernEntries = "http://www.ehealth-connector.org/fhir-extensions/useAsAllergyProblemConcernEntries";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsAssessmentAndPlan = "http://www.ehealth-connector.org/fhir-extensions/useAsAssessmentAndPlan";
	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsAuthor = "http://www.ehealth-connector.org/fhir-extensions/useAsAuthor";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static String urnUseAsAuthorLrqc = "http://www.ehealth-connector.org/fhir-extensions/useAsAuthorLrqc";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsBloodGroup = "http://www.ehealth-connector.org/fhir-extensions/useAsBloodGroup";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsChiefComplaint = "http://www.ehealth-connector.org/fhir-extensions/useAsChiefComplaint";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCode = "http://www.ehealth-connector.org/fhir-extensions/urnUseAsCode";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCodedPhysicalExam = "http://www.ehealth-connector.org/fhir-extensions/useAsCodedPhysicalExam";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCodedResultObservations = "http://www.ehealth-connector.org/fhir-extensions/useAsCodedResultObservations";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCodedVitalSignList = "http://www.ehealth-connector.org/fhir-extensions/urnUseAsCodedVitalSignList";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCodedVitalSignObservation = "http://www.ehealth-connector.org/fhir-extensions/useAsCodedVitalSignObservation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCodedVitalSigns = "http://www.ehealth-connector.org/fhir-extensions/useAsCodedVitalSigns";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsComment = "http://www.ehealth-connector.org/fhir-extensions/useAsComment";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsConfidentiality = "http://www.ehealth-connector.org/fhir-extensions/useAsConfidentiality";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCriterion = "http://www.ehealth-connector.org/fhir-extensions/useAsCriterion";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCurrentMedications = "http://www.ehealth-connector.org/fhir-extensions/useAsCurrentMedications";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCustodian = "http://www.ehealth-connector.org/fhir-extensions/useAsCustodian";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsDocType = "http://www.ehealth-connector.org/fhir-extensions/useAsDocType";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsDocumentationOf = "http://www.ehealth-connector.org/fhir-extensions/useAsDocumentationOf";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsDocumentDescriptor = "http://www.ehealth-connector.org/fhir-extensions/useAsDocumentDescriptor";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsDocVersion = "http://www.ehealth-connector.org/fhir-extensions/urnUseAsDocVersion";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsEdConsultations = "http://www.ehealth-connector.org/fhir-extensions/useAsEdConsultations";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsEdDiagnosis = "http://www.ehealth-connector.org/fhir-extensions/useAsEdDiagnosis";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsEdDisposition = "http://www.ehealth-connector.org/fhir-extensions/useAsEdDisposition";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsExternalDocument = "http://www.ehealth-connector.org/fhir-extensions/useAsExternalDocument";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsFamilyMedicalHistory = "http://www.ehealth-connector.org/fhir-extensions/useAsFamilyMedicalHistory";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsFormatCode = "http://www.ehealth-connector.org/fhir-extensions/useAsFormatCode";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsHistoryOfImmunization = "http://www.ehealth-connector.org/fhir-extensions/useAsHistoryOfImmunization";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsHistoryOfPresentIllness = "http://www.ehealth-connector.org/fhir-extensions/useAsHistoryOfPresentIllness";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsIdentifier = "http://www.ehealth-connector.org/fhir-extensions/useAsIdentifier";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsImmunization = "http://www.ehealth-connector.org/fhir-extensions/useAsImmunization";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsImmunizationRecommendation = "http://www.ehealth-connector.org/fhir-extensions/useAsImmunizationRecommendation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsInformationRecipient = "http://www.ehealth-connector.org/fhir-extensions/useAsInformationRecipient";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsInFulfillmentOf = "http://www.ehealth-connector.org/fhir-extensions/urnUseAsInFulfillmentOf";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLaboratoryBatteryOrganizer = "http://www.ehealth-connector.org/fhir-extensions/useAsLaboratoryBatteryOrganizer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLaboratoryIsolateOrganizer = "http://www.ehealth-connector.org/fhir-extensions/useAsLaboratoryIsolateOrganizer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLaboratoryObservation = "http://www.ehealth-connector.org/fhir-extensions/useAsLaboratoryObservation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLaboratoryObservations = "http://www.ehealth-connector.org/fhir-extensions/useAsLaboratoryObservations";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLaboratoryReportDataProcessingEntry = "http://www.ehealth-connector.org/fhir-extensions/useAsLaboratoryReportDataProcessingEntry";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLaboratorySpecialtySection = "http://www.ehealth-connector.org/fhir-extensions/useAsLaboratorySpecialtySection";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLanguage = "http://www.ehealth-connector.org/fhir-extensions/useAsLanguage";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLegalAuthenticator = "http://www.ehealth-connector.org/fhir-extensions/useAsLegalAuthenticator";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsListOfSurgeries = "http://www.ehealth-connector.org/fhir-extensions/useAsListOfSurgeries";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsLotNumbertext = "http://www.ehealth-connector.org/fhir-extensions/urnUseAsLotNumbertext";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsMedicationTarget = "http://www.ehealth-connector.org/fhir-extensions/useAsMedicationTarget";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsMetadataLanguage = "http://www.ehealth-connector.org/fhir-extensions/useAsMetadataLanguage";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsMimeType = "http://www.ehealth-connector.org/fhir-extensions/useAsMimeType";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsModeOfArrival = "http://www.ehealth-connector.org/fhir-extensions/useAsModeOfArrival";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsNonLivingSubject = "http://www.ehealth-connector.org/fhir-extensions/useAsNonLivingSubject";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsNotificationOrganizer = "http://www.ehealth-connector.org/fhir-extensions/useAsNotificationOrganizer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsObservationMedia = "http://www.ehealth-connector.org/fhir-extensions/useAsObservationMedia";

	public static final String urnUseAsOrganizer = "http://www.ehealth-connector.org/fhir-extensions/useAsOrganizer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsOutbreakIdentification = "http://www.ehealth-connector.org/fhir-extensions/useAsOutbreakIdentification";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsParticipant = "http://www.ehealth-connector.org/fhir-extensions/useAsParticipant";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsPastProblemConcern = "http://www.ehealth-connector.org/fhir-extensions/useAsPastProblemConcern";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsPastProblemConcernEntries = "http://www.ehealth-connector.org/fhir-extensions/useAsPastProblemConcernEntries";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsPatient = "http://www.ehealth-connector.org/fhir-extensions/useAsPatient";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsPerformer = "http://www.ehealth-connector.org/fhir-extensions/useAsPerformer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsPracticeSettingCode = "http://www.ehealth-connector.org/fhir-extensions/useAsPracticeSettingCode";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsPregnancyObservation = "http://www.ehealth-connector.org/fhir-extensions/urnUseAsPregnancyObservation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsProcedures = "http://www.ehealth-connector.org/fhir-extensions/useAsProcedures";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsProgressNote = "http://www.ehealth-connector.org/fhir-extensions/useAsProgressNote";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsReason = "http://www.ehealth-connector.org/fhir-extensions/useAsReason";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsReasonForVisit = "http://www.ehealth-connector.org/fhir-extensions/useAsReasonForVisit";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsReferenceRange = "http://www.ehealth-connector.org/fhir-extensions/useAsReferenceRange";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsReferralOrderingPhysician = "http://www.ehealth-connector.org/fhir-extensions/useAsReferralOrderingPhysician";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsReferralSource = "http://www.ehealth-connector.org/fhir-extensions/useAsReferralSource";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsRegistryDestination = "http://www.ehealth-connector.org/fhir-extensions/useAsRegistryDestination";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsRelatedDocument = "http://www.ehealth-connector.org/fhir-extensions/useAsRelatedDocument";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsRepositoryDestination = "http://www.ehealth-connector.org/fhir-extensions/useAsRepositoryDestination";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsResults = "http://www.ehealth-connector.org/fhir-extensions/useAsResults";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsSocialHistory = "http://www.ehealth-connector.org/fhir-extensions/useAsSocialHistory";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsSpecimenCollection = "http://www.ehealth-connector.org/fhir-extensions/useAsSpecimenCollection";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsSpecimenReceived = "http://www.ehealth-connector.org/fhir-extensions/useAsSpecimenReceived";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsStudiesSummary = "http://www.ehealth-connector.org/fhir-extensions/useAsStudiesSummary";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsVitalSignsObservation = "http://www.ehealth-connector.org/fhir-extensions/useAsVitalSignsObservation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsVitalSignsOrganizer = "http://www.ehealth-connector.org/fhir-extensions/useAsVitalSignsOrganizer";

	private static String addUriPrefix(String codeSystem) {
		return "urn:oid:" + codeSystem;
	}

	public static CodeableConceptDt ehcCodeToFhirCode(Code code) {
		CodeableConceptDt cc = new CodeableConceptDt();
		CodingDt fCode;

		fCode = new CodingDt();
		fCode.setSystem(addUriPrefix(code.getCodeSystem()));
		fCode.setCode(code.getCode());
		fCode.setDisplay(code.getDisplayName());
		cc.addCoding(fCode);

		for (Code translation : code.getTranslations()) {
			CodingDt cdt = new CodingDt();
			cdt.setSystem(addUriPrefix(translation.getCodeSystem()));
			cdt.setCode(translation.getCode());
			cdt.setDisplay(translation.getDisplayName());
			cc.addCoding(cdt);
		}

		return cc;
	}

	public static Address fhirAddressToEhcAddress(AddressDt fAddr) {
		final Address addr = new Address();
		if (fAddr.getCity() != null) {
			addr.setCity(fAddr.getCity());
		}
		if (fAddr.getCountry() != null) {
			addr.setCountry(fAddr.getCountry());
		}
		for (final StringDt fLine : fAddr.getLine()) {
			addr.getMdhtAdress().addStreetAddressLine(fLine.getValue());
		}
		if (fAddr.getPostalCode() != null) {
			addr.setZip(fAddr.getPostalCode());
		}
		if (fAddr.getState() != null) {
			addr.getMdhtAdress().addState(fAddr.getState());
		}
		if (fAddr.getUse() != null) {
			final BoundCodeDt<AddressUseEnum> useElement = fAddr.getUseElement();
			if (useElement.getValue().equals(AddressUseEnum.HOME.getCode())) {
				addr.getMdhtAdress().getUses().add(PostalAddressUse.HP);
			}
			if (useElement.getValue().equals(AddressUseEnum.OLD___INCORRECT.getCode())) {
				addr.getMdhtAdress().getUses().add(PostalAddressUse.BAD);
			}
			// We use TMP for PUB, because it is required in LRQC but not
			// available in FHIR ;)
			if (useElement.getValue().equals(AddressUseEnum.TEMPORARY.getCode())) {
				addr.getMdhtAdress().getUses().add(PostalAddressUse.PUB);
			}
			if (useElement.getValue().equals(AddressUseEnum.WORK.getCode())) {
				addr.getMdhtAdress().getUses().add(PostalAddressUse.WP);
			}
		}
		return addr;
	}

	public static Code fhirCodeToEhcCode(CodeableConceptDt codableConcept) {
		Code code;
		code = new Code(removeURIPrefix(codableConcept.getCodingFirstRep().getSystem()),
				codableConcept.getCodingFirstRep().getCode(),
				codableConcept.getCodingFirstRep().getDisplay());
		if (codableConcept.getCoding().size() > 1) {
			for (int i = 1; i < codableConcept.getCoding().size(); i++) {
				final CodingDt fhirCode = codableConcept.getCoding().get(i);
				code.addTranslation(new Code(removeURIPrefix(fhirCode.getSystem()),
						fhirCode.getCode(), fhirCode.getDisplay()));
			}

		}
		return code;
	}

	public static Identificator fhirIdentifierToEhcIdentificator(IdentifierDt id) {
		if ((id != null) && !id.isEmpty()) {
			return new Identificator(FhirCommon.removeURIPrefix(id.getSystem()), id.getValue());
		} else {
			return null;
		}
	}

	public static Name fhirNameToEhcName(HumanNameDt fName) {
		Name name = null;
		if (!fName.getGivenAsSingleString().isEmpty()
				&& !fName.getFamilyAsSingleString().isEmpty()) {
			name = new Name(fName.getGivenAsSingleString(), fName.getFamilyAsSingleString());
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

	public static String formatDiv(XhtmlDt text) {
		String retVal = text.getValueAsString();
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
		if (res instanceof Person) {
			retVal = FhirCommon.getAuthor((Person) res);
		}
		if (res instanceof Practitioner) {
			retVal = FhirCommon.getAuthor((Practitioner) res);
		}
		if (res instanceof Organization) {
			retVal = FhirCommon.getAuthor((Organization) res);
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
	public static org.ehealth_connector.common.Author getAuthor(Organization fhirObject) {
		org.ehealth_connector.common.Author retVal = null;
		final String authoringDeviceName = fhirObject.getName();

		// Create the author
		final AuthoringDevice ad = new AuthoringDevice(authoringDeviceName);
		retVal = new org.ehealth_connector.common.Author(ad);
		retVal.setFunctionCode(Author.FUNCTION_CODE_AUTHORDEVICE);

		// Add Identifiers
		for (final IdentifierDt id : fhirObject.getIdentifier()) {
			final String codeSystem = FhirCommon.removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (final AddressDt addr : fhirObject.getAddress()) {
			AddressUse usage = AddressUse.BUSINESS;
			if (addr.getUseElement().getValueAsEnum() == AddressUseEnum.HOME) {
				usage = AddressUse.PRIVATE;
			}
			if (addr.getUseElement().getValueAsEnum() == AddressUseEnum.TEMPORARY) {
				usage = AddressUse.PUBLIC;
			}
			final Address eHCAddr = new Address(addr.getLineFirstRep().toString(),
					addr.getPostalCode(), addr.getCity(), usage);
			if (addr.getCountry() != null) {
				eHCAddr.setCountry(addr.getCountry());
			}
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(getTelecoms(fhirObject.getTelecom()));

		// Add OrganizationName
		if (fhirObject.getText() != null && fhirObject.getText().getDiv() != null
				&& !fhirObject.getText().isEmpty() && !fhirObject.getText().getDiv().isEmpty()) {
			retVal.setOrganization(new org.ehealth_connector.common.Organization(
					formatDiv(fhirObject.getText().getDiv())));
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
	public static org.ehealth_connector.common.Author getAuthor(Person fhirObject) {
		org.ehealth_connector.common.Author retVal = null;
		final Name personName = new Name(fhirObject.getNameFirstRep().getGivenAsSingleString(),
				fhirObject.getNameFirstRep().getFamilyAsSingleString());

		// Create the author
		retVal = new org.ehealth_connector.common.Author(personName);

		// Add Identifiers
		for (final IdentifierDt id : fhirObject.getIdentifier()) {
			final String codeSystem = FhirCommon.removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (final AddressDt addr : fhirObject.getAddress()) {
			AddressUse usage = AddressUse.BUSINESS;
			if (addr.getUseElement().getValueAsEnum() == AddressUseEnum.HOME) {
				usage = AddressUse.PRIVATE;
			}
			if (addr.getUseElement().getValueAsEnum() == AddressUseEnum.TEMPORARY) {
				usage = AddressUse.PUBLIC;
			}
			final Address eHCAddr = new Address(addr.getLineFirstRep().toString(),
					addr.getPostalCode(), addr.getCity(), usage);
			eHCAddr.setCountry(addr.getCountry());
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(getTelecoms(fhirObject.getTelecom()));

		// Add organization
		if (fhirObject.getManagingOrganization().getResource() != null
				&& !fhirObject.getManagingOrganization().getResource().isEmpty()) {
			retVal.setOrganization(getOrganization(
					(Organization) fhirObject.getManagingOrganization().getResource()));
		}

		return retVal;

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
		final Name personName = new Name(fhirObject.getName().getGivenAsSingleString(),
				fhirObject.getName().getFamilyAsSingleString());

		// Create the author
		retVal = new org.ehealth_connector.common.Author(personName);

		// Add Identifiers
		for (final IdentifierDt id : fhirObject.getIdentifier()) {
			final String codeSystem = FhirCommon.removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (final AddressDt addr : fhirObject.getAddress()) {
			AddressUse usage = AddressUse.BUSINESS;
			if (addr.getUseElement().getValueAsEnum() == AddressUseEnum.HOME) {
				usage = AddressUse.PRIVATE;
			}
			final Address eHCAddr = new Address(addr.getLineFirstRep().toString(),
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
	 * <div class="en">Gets an eHC Author from FHIR resource reference.
	 *
	 * @param ref
	 *            the FHIR object
	 * @return the eHC Author </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static org.ehealth_connector.common.Author getAuthor(ResourceReferenceDt ref) {
		return getAuthor(ref.getResource());
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
		for (final CodingDt item : fhirObject.getContentFirstRep().getFormat()) {
			final List<ExtensionDt> extensions = item
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsDocumentDescriptor);
			if (!extensions.isEmpty()) {
				mimeType = item.getCode();
				break;
			}
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
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension author
	 */
	public static ExtensionDt getExtensionAuthor() {
		return new ExtensionDt(false, FhirCommon.urnUseAsAuthor, new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension comment
	 */
	public static ExtensionDt getExtensionComment() {
		return new ExtensionDt(false, FhirCommon.urnUseAsComment, new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension criterion
	 */
	public static ExtensionDt getExtensionCriterion() {
		return new ExtensionDt(false, FhirCommon.urnUseAsCriterion, new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension custodian
	 */
	public static ExtensionDt getExtensionCustodian() {
		return new ExtensionDt(false, FhirCommon.urnUseAsCustodian, new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension document descriptor
	 */
	public static ExtensionDt getExtensionDocumentDescriptor() {
		return new ExtensionDt(false, FhirCommon.urnUseAsDocumentDescriptor, new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension external document
	 */
	public static ExtensionDt getExtensionExternalDocument() {
		return new ExtensionDt(false, FhirCommon.urnUseAsExternalDocument, new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension format code
	 */
	public static ExtensionDt getExtensionFormatCode() {
		return new ExtensionDt(false, FhirCommon.urnUseAsFormatCode, new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 */
	public static ExtensionDt getExtensionLaboratoryBatteryOrganizer() {
		return new ExtensionDt(false, FhirCommon.urnUseAsLaboratoryBatteryOrganizer,
				new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 */
	public static ExtensionDt getExtensionLaboratoryObservations() {
		return new ExtensionDt(false, FhirCommon.urnUseAsLaboratoryObservations,
				new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension medication target
	 */
	public static ExtensionDt getExtensionMedicationTarget() {
		return new ExtensionDt(false, FhirCommon.urnUseAsMedicationTarget, new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension metadata language
	 */
	public static ExtensionDt getExtensionMetadataLanguage() {
		return new ExtensionDt(false, FhirCommon.urnUseAsMetadataLanguage, new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension mime type
	 */
	public static ExtensionDt getExtensionMimeType() {
		return new ExtensionDt(false, FhirCommon.urnUseAsMimeType, new StringDt("dummy"));
	}

	public static ExtensionDt getExtensionNonLivingSubject() {
		return new ExtensionDt(false, FhirCommon.urnUseAsNonLivingSubject, new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension author
	 */
	public static ExtensionDt getExtensionParticipant() {
		return new ExtensionDt(false, FhirCommon.urnUseAsParticipant, new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension performer
	 */
	public static ExtensionDt getExtensionPerformer() {
		return new ExtensionDt(false, FhirCommon.urnUseAsPerformer, new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension practice setting code
	 */
	public static ExtensionDt getExtensionPracticeSettingCode() {
		return new ExtensionDt(false, FhirCommon.urnUseAsPracticeSettingCode, new CodingDt());
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension reason
	 */
	public static ExtensionDt getExtensionReason() {
		return new ExtensionDt(false, FhirCommon.urnUseAsReason, new StringDt("dummy"));
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the extension repository destination
	 */
	public static ExtensionDt getExtensionRepositoryDestination() {
		return new ExtensionDt(false, FhirCommon.urnUseAsRepositoryDestination,
				new StringDt("dummy"));
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
		for (final CodingDt item : fhirObject.getContentFirstRep().getFormat()) {
			final List<ExtensionDt> extensions = item
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsFormatCode);
			if (!extensions.isEmpty()) {
				retVal = new Code(item);
				break;
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets this FHIR extension</div> <div class="de"></div>
	 * <div class="fr"></div>.
	 *
	 * @return the information recipient
	 */
	public static ExtensionDt getInformationRecipient() {
		return new ExtensionDt(false, FhirCommon.urnUseAsInformationRecipient,
				new StringDt("dummy"));
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
		final List<ExtensionDt> extensions = fhirObject
				.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsMetadataLanguage);
		if (!extensions.isEmpty())
			retVal = ((StringDt) extensions.get(0).getValue()).getValueAsString();
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
		for (final CodingDt item : fhirObject.getContentFirstRep().getFormat()) {
			final List<ExtensionDt> extensions = item
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsMimeType);
			if (!extensions.isEmpty()) {
				retVal = item.getCode();
				break;
			}
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
		if (res instanceof Organization) {
			retVal = FhirCommon.getOrganization((Organization) res);
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
			Organization fhirOrganization) {
		org.ehealth_connector.common.Organization retVal = null;
		// Create the organization
		if (fhirOrganization.getName() != null) {
			retVal = new org.ehealth_connector.common.Organization(fhirOrganization.getName());
		}
		// Add Identifiers
		for (final IdentifierDt id : fhirOrganization.getIdentifier()) {
			final String codeSystem = FhirCommon.removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (final AddressDt addr : fhirOrganization.getAddress()) {
			AddressUse usage = AddressUse.BUSINESS;
			if (addr.getUseElement().getValueAsEnum() == AddressUseEnum.HOME) {
				usage = AddressUse.PRIVATE;
			}
			if (addr.getUseElement().getValueAsEnum() == AddressUseEnum.TEMPORARY) {
				usage = AddressUse.PUBLIC;
			}
			final Address eHCAddr = new Address();
			eHCAddr.setAddressline1(addr.getLineFirstRep().toString());
			if (addr.getLine().size() > 1) {
				eHCAddr.setAddressline2(addr.getLine().get(1).getValueAsString());
			}
			eHCAddr.setCity(addr.getCity());
			eHCAddr.setZip(addr.getPostalCode());
			eHCAddr.setCountry(addr.getCountry());
			eHCAddr.setUsage(usage);
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(FhirCommon.getTelecoms(fhirOrganization.getTelecom()));

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
			ResourceReferenceDt orgRef) {
		return getOrganization(orgRef.getResource());
	}

	/**
	 * <div class="en"> Gets an eHC Patient object from the given FHIR bundle.
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC Patient object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static org.ehealth_connector.common.Patient getPatient(Bundle bundle) {
		Patient fhirPatient = null;
		org.ehealth_connector.common.Patient retVal = new org.ehealth_connector.common.Patient();
		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Patient)
				fhirPatient = (Patient) entry.getResource();
		}
		// Name
		if (!fhirPatient.getName().isEmpty()) {
			final Name patientName = new Name(
					fhirPatient.getNameFirstRep().getGivenAsSingleString(),
					fhirPatient.getNameFirstRep().getFamilyAsSingleString());
			retVal.addName(patientName);
		}
		// Gender
		AdministrativeGender gender = AdministrativeGender.UNDIFFERENTIATED;
		if (fhirPatient.getGender() != null && !fhirPatient.getGender().isEmpty()) {
			if (fhirPatient.getGenderElement()
					.getValueAsEnum() == AdministrativeGenderEnum.FEMALE) {
				gender = AdministrativeGender.FEMALE;
			} else if (fhirPatient.getGenderElement()
					.getValueAsEnum() == AdministrativeGenderEnum.MALE) {
				gender = AdministrativeGender.MALE;
			}
		}
		retVal.setAdministrativeGender(gender);
		// Birthdate
		if (fhirPatient.getBirthDate() != null) {
			retVal.setBirthday(fhirPatient.getBirthDate());
		}

		// Create eHC Patient
		// retVal = new org.ehealth_connector.common.Patient(patientName,
		// gender,
		// fhirPatient.getBirthDate());

		// Add Identifiers
		for (final IdentifierDt id : fhirPatient.getIdentifier()) {
			final String codeSystem = FhirCommon.removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (final AddressDt addr : fhirPatient.getAddress()) {
			AddressUse usage = AddressUse.BUSINESS;
			if (addr.getUseElement().getValueAsEnum() == AddressUseEnum.HOME) {
				usage = AddressUse.PRIVATE;
			}
			final Address eHCAddr = new Address();
			if (!addr.getLineFirstRep().isEmpty()) {
				eHCAddr.setAddressline1(addr.getLineFirstRep().toString());
			}
			if (!addr.getPostalCode().isEmpty()) {
				eHCAddr.setZip(addr.getPostalCode());
			}
			if (!addr.getCity().isEmpty()) {
				eHCAddr.setCity(addr.getCity());
			}
			if (usage != null) {
				eHCAddr.setUsage(usage);
			}
			if (addr.getCountry() != null) {
				eHCAddr.setCountry(addr.getCountry());
			}
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(FhirCommon.getTelecoms(fhirPatient.getTelecom()));
		return retVal;
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
		if (res instanceof Patient) {
			retVal = FhirCommon.getPatient((Patient) res);
		}
		return retVal;
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
	public static org.ehealth_connector.common.Patient getPatient(Patient fhirPatient) {
		org.ehealth_connector.common.Patient retVal = null;
		final Name patientName = new Name(fhirPatient.getNameFirstRep().getGivenAsSingleString(),
				fhirPatient.getNameFirstRep().getFamilyAsSingleString());
		AdministrativeGender gender = AdministrativeGender.UNDIFFERENTIATED;
		if (fhirPatient.getGenderElement().getValueAsEnum() == AdministrativeGenderEnum.FEMALE) {
			gender = AdministrativeGender.FEMALE;
		} else if (fhirPatient.getGenderElement()
				.getValueAsEnum() == AdministrativeGenderEnum.MALE) {
			gender = AdministrativeGender.MALE;
		}

		// Create eHC Patient
		retVal = new org.ehealth_connector.common.Patient(patientName, gender,
				fhirPatient.getBirthDate());

		// Add Identifiers
		for (final IdentifierDt id : fhirPatient.getIdentifier()) {
			final String codeSystem = FhirCommon.removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (final AddressDt addr : fhirPatient.getAddress()) {
			AddressUse usage = AddressUse.BUSINESS;
			if (addr.getUseElement().getValueAsEnum() == AddressUseEnum.HOME) {
				usage = AddressUse.PRIVATE;
			}
			final Address eHCAddr = new Address(addr.getLineFirstRep().toString(),
					addr.getPostalCode(), addr.getCity(), usage);
			eHCAddr.setCountry(addr.getCountry());
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(FhirCommon.getTelecoms(fhirPatient.getTelecom()));
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
	public static org.ehealth_connector.common.Patient getPatient(ResourceReferenceDt orgRef) {
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
		final List<ExtensionDt> extensions = fhirObject
				.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsPracticeSettingCode);
		if (!extensions.isEmpty())
			retVal = new Code((CodingDt) extensions.get(0).getValue());
		return retVal;
	}

	/**
	 * <div class="en">Gets the eHC Telecoms from the given FHIR object.
	 *
	 * @param fhirContactPoints
	 *            a list of FHIR ContactPointDt resources
	 * @return eHC Telecoms</div> <div class="de"></div> <div class="fr"></div>
	 */
	public static Telecoms getTelecoms(List<ContactPointDt> fhirContactPoints) {
		final Telecoms eHCTelecoms = new Telecoms();
		for (final ContactPointDt telco : fhirContactPoints) {
			AddressUse usage = AddressUse.BUSINESS;
			if (telco.getUseElement().getValueAsEnum() == ContactPointUseEnum.HOME) {
				usage = AddressUse.PRIVATE;
			}
			if (telco.getUseElement().getValueAsEnum() == ContactPointUseEnum.TEMP) {
				usage = AddressUse.PUBLIC;
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
	public static String removeURIPrefix(String value) {
		String retVal = "";
		if (value.toLowerCase().startsWith("urn:oid:"))
			retVal = value.substring(8, value.length());
		else {
			retVal = value;
		}
		return retVal;
	}
}
