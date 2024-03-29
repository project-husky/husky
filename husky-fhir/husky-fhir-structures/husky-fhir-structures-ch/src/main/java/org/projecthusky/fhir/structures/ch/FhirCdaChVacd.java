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
package org.projecthusky.fhir.structures.ch;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.util.ElementUtil;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.fhir.structures.gen.FhirCommon;

import java.util.ArrayList;
import java.util.List;

/**
 * FhirCdaChVacd supports the creation of a CDA-CH-CH document from HL7 FHIR
 * resources. The content of these resources is not currently documented.
 * These resources may be created by the class
 * org.projecthusky.demo.cda.VACDResources. This is currently the one any
 * only way to create valid FHIR resources for CDA-CH-VACD. You may edit
 * these FHIR resources in a text editor in order to change the payload of the
 * resulting CdaChVacd object on your own risk.
 *
 * @see "https://www.hl7.org/fhir/"
 */
/**
 * <div class="en"></div><div class="de"></div><div class="fr"></div>
 */
/* derived from external library */
@SuppressWarnings("java:S110")
public class FhirCdaChVacd /* extends AbstractFhirCdaCh */ {

	/**
	 * <div class="en">Type of the FHIR resource to define whether the resulting
	 * CDA document contains full or masked patient demographics</div>
	 * <div class="de"></div><div class="fr"></div>
	 */
	public enum DocTypeCode {
		/**
		 * <div class="en">the resulting CDA document contains full patient
		 * demographics</div><div class="de"></div><div class="fr"></div>
		 */
		PATIENT,
		/**
		 * <div class="en">the resulting CDA document contains masked patient
		 * demographics</div><div class="de"></div> <div class="fr"></div>
		 */
		PSEUDONYMIZED
	}

	/**
	 * <div class="en">MyMedicationStatement extends from the FHIR HAPI
	 * MedicationStatement Resource and provides extension attributes in order
	 * to fulfill the needs for HL7 CDA-CH-VACD creation
	 *
	 * <!-- @formatter:off -->
	 * @see "http://jamesagnew.github.io/hapi-fhir/index.html"
	 * <!-- @formatter:on --></div><div class="de"></div><div class="fr"></div>
	 */
	/**
	 * <div class="en"></div><div class="de"></div><div class="fr"></div>
	 */
	@ResourceDef(name = "MedicationStatement")
	public static class MyMedicationStatement extends MedicationStatement {

		private static final long serialVersionUID = -2062272744006946538L;

		/**
		 * <div class="en">Person who documented the medication statement</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "author")
		@Extension(url = FhirCommon.URN_USE_AS_AUTHOR, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Person who documented the medication statement")
		private Reference author;

		/**
		 * <div class="en">Code of the medication administration</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "code")
		@Extension(url = FhirCommon.URN_USE_AS_CODE, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Code of the medication administration")
		private Coding codeReference;

		/**
		 * <div class="en">Remark for this medication statement</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "comment")
		@Extension(url = FhirCommon.URN_USE_AS_COMMENT, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Remark for this medication statement")
		private StringType comment;

		/**
		 * <div class="en">List of reasons for this medication statement</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "externalDocument")
		@Extension(url = FhirCommon.URN_USE_AS_EXTERNAL_DOCUMENT, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "reference to the guidline for theimmunization recommendation")
		private Reference externalDocument;

		/**
		 * <div class="en">LotNumber for this medication statement</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "lot")
		@Extension(url = FhirCommon.URN_USE_AS_LOT_NUMBERTEXT, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "LotNumber for this medication statement")
		private StringType lot;

		/**
		 * <div class="en">Person who performed the medication
		 * administration</div> <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "performer")
		@Extension(url = FhirCommon.URN_USE_AS_PERFORMER, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Person who performed the medicationadministration")
		private Reference performer;

		/**
		 * <div class="en">List of reasons for this medication statement</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "reasons")
		@Extension(url = FhirCommon.URN_USE_AS_REASON, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "List of reasons for this medicationstatement")
		private Reference reasons;

		/**
		 * <div class="en">Empty constructor (default)</div>
		 * <div class="de"></div> <div class="fr"></div>
		 */
		public MyMedicationStatement() {
			super();
			setStatus(MedicationStatementStatus.UNKNOWN);
		}

		/**
		 * @return <div class="en">author of this MedicationStatement</div>
		 *         <div class="de">Autor dieses MedicationStatements</div>
		 *         <div class="fr">auteur de ce MedicationStatement</div>
		 */
		public Reference getAuthor() {
			if (this.author == null) {
				this.author = new Reference();
			}
			return author;
		}

		/**
		 * @return <div class="en">code of this MedicationStatement</div>
		 *         <div class="de">Code für dieses MedicationStatement</div>
		 *         <div class="fr">code de ce MedicationStatement</div>
		 */
		public Coding getCode() {
			return codeReference;
		}

		/**
		 * @return <div class="en">comment for this medication</div>
		 *         <div class="de">Kommentar zu diesem Medikament</div>
		 *         <div class="fr">commentaire tu médicament</div>
		 */
		public StringType getComment() {
			if (this.comment == null) {
				this.comment = new StringType();
			}
			return comment;
		}

		/**
		 * Gets the external document.
		 *
		 * @return the external document
		 */
		public Reference getExternalDocument() {
			if (this.externalDocument == null) {
				this.externalDocument = new Reference();
			}
			return externalDocument;
		}

		/**
		 * @return <div class="en">lot number of this medication</div>
		 *         <div class="de">Lotnummer des Medikaments</div>
		 *         <div class="fr">numero lot du médicament</div>
		 */
		public StringType getLot() {
			if (this.lot == null) {
				this.lot = new StringType();
			}
			return lot;
		}

		/**
		 * @return <div class="en">performer of the medication
		 *         administration</div> <div class="de">Person, welche das
		 *         Medikament verabreicht hat</div><div class="fr">personne qui
		 *         a effectué l'administration du médicament</div>
		 */
		public Reference getPerformer() {
			if (this.performer == null) {
				this.performer = new Reference();
			}
			return performer;
		}

		/**
		 * @return <div class="en">reason for this medication</div>
		 *         <div class="de">Begründung für dieses Medikament</div>
		 *         <div class="fr">Justification de ce médicament</div>
		 */
		public Reference getReasons() {
			if (this.reasons == null) {
				this.reasons = new Reference();
			}
			return reasons;
		}

		/**
		 * It is important to override the isEmpty() method, adding a check for
		 * any newly added fields.
		 *
		 * @see "ca.uhn.fhir.model.dstu2.resource.MedicationStatement#isEmpty()"
		 */
		@Override
		public boolean isEmpty() {
			return super.isEmpty() && ElementUtil.isEmpty(codeReference, performer, author, comment);
		}

		/**
		 * @param author
		 *            <div class="en">author of this MedicationStatement</div>
		 *            <div class="de">Autor dieses MedicationStatements</div>
		 *            <div class="fr">auteur de ce MedicationStatement</div>
		 */
		public void setAuthor(Reference author) {
			this.author = author;
		}

		/**
		 * @param code
		 *            <div class="en">code of this MedicationStatement</div>
		 *            <div class="de">Code für dieses MedicationStatement</div>
		 *            <div class="fr">code de ce MedicationStatement</div>
		 */
		public void setCode(Coding code) {
			this.codeReference = code;
		}

		/**
		 * @param comment
		 *            <div class="en">comment for this medication</div>
		 *            <div class="de">Kommentar zu diesem Medikament</div>
		 *            <div class="fr">commentaire tu médicament</div>
		 */
		public void setComment(StringType comment) {
			this.comment = comment;
		}

		/**
		 * Sets the external document.
		 *
		 * @param externalDocument
		 *            the new external document
		 */
		public void setExternalDocument(Reference externalDocument) {
			this.externalDocument = externalDocument;
		}

		/**
		 * @param lot
		 *            <div class="en">lot number of this medication</div>
		 *            <div class="de">Lotnummer des Medikaments</div>
		 *            <div class="fr">numero lot du médicament</div>
		 */
		public void setLot(StringType lot) {
			this.lot = lot;
		}

		/**
		 * @param performer
		 *            <div class="en">performer of the medication
		 *            administration</div> <div class="de">Person, welche das
		 *            Medikament verabreicht hat</div><div class="fr">personne
		 *            qui a effectué l'administration du médicament</div>
		 */
		public void setPerformer(Reference performer) {
			this.performer = performer;
		}

		/**
		 * @param reasons
		 *            <div class="en">reason for this medication</div>
		 *            <div class="de">Begründung für dieses Medikament</div>
		 *            <div class="fr">Justification de ce médicament</div>
		 */
		public void setReasons(Reference reasons) {
			this.reasons = reasons;
		}

	}

	/**
	 * The class VacdDocument is a derived FHIR resource containing all
	 * information of an immunization document corresponding to the CDA-CH-VACD
	 * specification
	 */
	@ResourceDef(name = "DocumentManifest")
	public static class VacdDocument extends CdaFhirDocument {

		private static final long serialVersionUID = -1316775746486313864L;

		/** The active problem concern entries. */
		@Child(name = "activeProblemConcernEntries", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.URN_USE_AS_ACTIVE_PROBLEM_CONCERN_ENTRIES, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "activeProblemConcernEntries")
		private List<Reference> activeProblemConcernEntries; // Condition

		/** The allergy problem concern entries. */
		@Child(name = "allergyProblemConcernEntries", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.URN_USE_AS_ALLERGY_PROBLEM_CONCERN_ENTRIES, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "allergyProblemConcernEntries")
		private List<Reference> allergyProblemConcernEntries; // Condition

		/** The coded result observations. */
		@Child(name = "codedResultObservations", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.URN_USE_AS_CODED_RESULT_OBSERVATIONS, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "codedResultObservations")
		private List<Reference> codedResultObservations; // codedResults

		/** The confidentiality. */
		@Child(name = "confidentiality")
		@Extension(url = FhirCommon.URN_USE_AS_CONFIDENTIALITY, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "confidentiality")
		private Reference confidentiality;

		/** The immunization recommendations. */
		@Child(name = "immunizationRecommendations", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.URN_USE_AS_IMMUNIZATION_RECOMMENDATION, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "immunizationRecommendations")
		private List<Reference> immunizationRecommendations;

		/** The immunizations. */
		@Child(name = "immunizations", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.URN_USE_AS_IMMUNIZATION, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "immunizations")
		private List<Reference> immunizations;

		/** The laboratory observations. */
		@Child(name = "laboratoryObservations", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.URN_USE_AS_LABORATORY_OBSERVATIONS, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "laboratoryObservations")
		private List<Reference> laboratoryObservations; // Observations

		/** The past problem concern entries. */
		@Child(name = "pastProblemConcernEntries", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.URN_USE_AS_PAST_PROBLEM_CONCERN_ENTRIES, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "pastProblemConcernEntries")
		private List<Reference> pastProblemConcernEntries; // Condition

		/** The pregnancy observation. */
		@Child(name = "pregnancyObservation,", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.URN_USE_AS_PREGNANCY_OBSERVATION, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "pregnancyObservation")
		private Reference pregnancyObservation; // Observation

		/**
		 * Adds the active problem concern entry.
		 *
		 * @param activeProbemlConcernEntry
		 *            the active probeml concern entry
		 */
		public void addActiveProblemConcernEntry(Condition activeProbemlConcernEntry) {
			if (activeProblemConcernEntries == null) {
				activeProblemConcernEntries = new ArrayList<>();
			}
			final Reference resourceRef = new Reference();
			resourceRef.setResource(activeProbemlConcernEntry);
			this.activeProblemConcernEntries.add(resourceRef);
		}

		/**
		 * Adds the allergy problem concern entry.
		 *
		 * @param allergyProblemConcernEntry
		 *            the allergy problem concern entry
		 */
		public void addAllergyProblemConcernEntry(Condition allergyProblemConcernEntry) {
			if (allergyProblemConcernEntries == null) {
				allergyProblemConcernEntries = new ArrayList<>();
			}
			final Reference resourceRef = new Reference();
			resourceRef.setResource(allergyProblemConcernEntry);
			this.allergyProblemConcernEntries.add(resourceRef);
		}

		/**
		 * Adds the coded result observation.
		 *
		 * @param laboratoryObservation
		 *            the laboratory observation
		 */
		public void addCodedResultObservation(Observation laboratoryObservation) {
			if (codedResultObservations == null) {
				codedResultObservations = new ArrayList<>();
			}
			final Reference resourceRef = new Reference();
			resourceRef.setResource(laboratoryObservation);
			this.codedResultObservations.add(resourceRef);
		}

		/**
		 * Adds the immunization.
		 *
		 * @param immunization
		 *            the immunization
		 */
		public void addImmunization(MyMedicationStatement immunization) {
			if (immunizations == null) {
				immunizations = new ArrayList<>();
			}
			final Reference resourceRef = new Reference();
			resourceRef.setResource(immunization);
			this.immunizations.add(resourceRef);
		}

		/**
		 * Adds the immunization recommendation.
		 *
		 * @param immunizationRecommendation
		 *            the immunization recommendation
		 */
		public void addImmunizationRecommendation(MedicationStatement immunizationRecommendation) {
			if (immunizationRecommendations == null) {
				immunizationRecommendations = new ArrayList<>();
			}
			final Reference resourceRef = new Reference();
			resourceRef.setResource(immunizationRecommendation);
			this.immunizationRecommendations.add(resourceRef);
		}

		/**
		 * Adds the laboratory observation.
		 *
		 * @param laboratoryObservation
		 *            the laboratory observation
		 */
		public void addLaboratoryObservation(Observation laboratoryObservation) {
			if (laboratoryObservations == null) {
				laboratoryObservations = new ArrayList<>();
			}
			final Reference resourceRef = new Reference();
			resourceRef.setResource(laboratoryObservation);
			this.laboratoryObservations.add(resourceRef);
		}

		/**
		 * Adds the past problem concern entry.
		 *
		 * @param pastProblemConcernEntry
		 *            the past problem concern entry
		 */
		public void addPastProblemConcernEntry(Condition pastProblemConcernEntry) {
			if (pastProblemConcernEntries == null) {
				pastProblemConcernEntries = new ArrayList<>();
			}
			final Reference resourceRef = new Reference();
			resourceRef.setResource(pastProblemConcernEntry);
			this.pastProblemConcernEntries.add(resourceRef);
		}

		/**
		 * Gets the active problem concern entries.
		 *
		 * @return the active problem concern entries
		 */
		public List<Condition> getActiveProblemConcernEntries() {
			final List<Condition> list = new ArrayList<>();
			if (this.activeProblemConcernEntries != null) {
				for (final Reference resource : this.activeProblemConcernEntries) {
					list.add((Condition) resource.getResource());
				}
			}
			return list;
		}

		/**
		 * Gets the allergy problem concern entries.
		 *
		 * @return the allergy problem concern entries
		 */
		public List<Condition> getAllergyProblemConcernEntries() {
			final List<Condition> list = new ArrayList<>();
			if (this.allergyProblemConcernEntries != null) {
				for (final Reference resource : allergyProblemConcernEntries) {
					list.add((Condition) resource.getResource());
				}
			}
			return list;
		}

		/**
		 * Gets the coded result observations.
		 *
		 * @return the coded result observations
		 */
		public List<Observation> getCodedResultObservations() {
			final List<Observation> list = new ArrayList<>();
			if (this.codedResultObservations != null) {
				for (final Reference resource : codedResultObservations) {
					list.add((Observation) resource.getResource());
				}
			}
			return list;
		}

		/**
		 * Gets the confidentiality code.
		 *
		 * @return the confidentiality code
		 */
		public Basic getConfidentiality() {
			if (this.confidentiality != null) {
				return (Basic) this.confidentiality.getResource();
			}
			return null;
		}

		/**
		 * Gets the immunization recommendations.
		 *
		 * @return the immunization recommendations
		 */
		public List<MedicationStatement> getImmunizationRecommendations() {
			final List<MedicationStatement> list = new ArrayList<>();
			if (this.immunizationRecommendations != null) {
				for (final Reference resource : immunizationRecommendations) {
					list.add((MedicationStatement) resource.getResource());
				}
			}
			return list;
		}

		/**
		 * Gets the immunizations.
		 *
		 * @return the immunizations
		 */
		public List<MedicationStatement> getImmunizations() {
			final List<MedicationStatement> list = new ArrayList<>();
			if (this.immunizations != null) {
				for (final Reference resource : immunizations) {
					list.add((MedicationStatement) resource.getResource());
				}
			}
			return list;
		}

		/**
		 * Gets the laboratory observations.
		 *
		 * @return the laboratory observations
		 */
		public List<Observation> getLaboratoryObservations() {
			final List<Observation> list = new ArrayList<>();
			if (this.laboratoryObservations != null) {
				for (final Reference resource : laboratoryObservations) {
					list.add((Observation) resource.getResource());
				}
			}
			return list;
		}

		/**
		 * Gets the past problem concern entries.
		 *
		 * @return the past problem concern entries
		 */
		public List<Condition> getPastProblemConcernEntries() {
			final List<Condition> list = new ArrayList<>();
			if (this.pastProblemConcernEntries != null) {
				for (final Reference resource : pastProblemConcernEntries) {
					list.add((Condition) resource.getResource());
				}
			}
			return list;
		}


		/**
		 * Gets the pregnancy obeservation.
		 *
		 * @return the pregnancy obeservation
		 */
		public Observation getPregnancyObeservation() {
			if (this.pregnancyObservation != null) {
				return (Observation) this.pregnancyObservation.getResource();
			}
			return null;
		}

		/**
		 * Sets the confidentiality code.
		 *
		 * @param confidentiality
		 *            the new confidentiality code
		 */
		public void setConfidentiality(Basic confidentiality) {
			final Reference resourceRef = new Reference();
			resourceRef.setResource(confidentiality);
			this.confidentiality = resourceRef;
		}

		/**
		 * Sets the pregnancy observation.
		 *
		 * @param pregnancyObservation
		 *            the new pregnancy observation
		 */
		public void setPregnancyObservation(Observation pregnancyObservation) {
			final Reference resourceRef = new Reference();
			resourceRef.setResource(pregnancyObservation);
			this.pregnancyObservation = resourceRef;
		}

	}

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div>
	 * <div class="de"></div><div class="fr"></div>
	 */
	public static final String OID_CONFIDENTIALITY_CODE = FhirCommon
			.addUrnOid(CodeSystems.CONFIDENTIALITY_CODE.getCodeSystemId());

}
