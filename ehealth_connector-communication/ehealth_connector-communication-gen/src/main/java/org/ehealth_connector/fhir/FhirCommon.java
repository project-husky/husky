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

package org.ehealth_connector.fhir;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.enums.AddressUse;
import org.ehealth_connector.common.enums.AdministrativeGender;
import org.ehealth_connector.common.enums.CodeSystems;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;

import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
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
import ca.uhn.fhir.model.primitive.StringDt;

// TODO: Auto-generated Javadoc
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

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsConfidentiality = "urn:ehealth_connector:FhirExtension:useAsConfidentiality";

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
	public static final String urnUseAsDocumentDescriptor = "urn:ehealth_connector:FhirExtension:useAsDocumentDescriptor";

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
	public static final String urnUseAsFamilyMedicalHistory = "urn:ehealth_connector:FhirExtension:useAsFamilyMedicalHistory";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsFormatCode = "urn:ehealth_connector:FhirExtension:useAsFormatCode";

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
	public static final String urnUseAsLaboratorySpecialitySection = "urn:ehealth_connector:FhirExtension:useAsLaboratorySpecialitySection";

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
	public static final String urnUseAsNotificationOrganizer = "urn:ehealth_connector:FhirExtension:useAsNotificationOrganizer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsObservationMedia = "urn:ehealth_connector:FhirExtension:useAsObservationMedia";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsOutbreakIdentification = "urn:ehealth_connector:FhirExtension:useAsOutbreakIdentification";

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
			final Address eHCAddr = new Address(addr.getLineFirstRep().toString(),
					addr.getPostalCode(), addr.getCity(), usage);
			eHCAddr.setCountry(addr.getCountry());
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(getTelecoms(fhirObject.getTelecom()));

		// Add organization
		retVal.setOrganization(
				getOrganization((Organization) fhirObject.getManagingOrganization().getResource()));

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
		retVal = new org.ehealth_connector.common.Organization(fhirOrganization.getName());

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
			final Address eHCAddr = new Address(addr.getLineFirstRep().toString(),
					addr.getPostalCode(), addr.getCity(), usage);
			eHCAddr.setCountry(addr.getCountry());
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
		org.ehealth_connector.common.Patient retVal = null;
		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Patient)
				fhirPatient = (Patient) entry.getResource();
		}
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
		return retVal;
	}
}
