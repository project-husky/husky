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

package org.ehealth_connector.fhir.ch;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.ch.ActiveProblemConcern;
import org.ehealth_connector.cda.ch.AllergyConcern;
import org.ehealth_connector.cda.ch.CodedResults;
import org.ehealth_connector.cda.ch.PastProblemConcern;
import org.ehealth_connector.cda.ch.PregnancyHistory;
import org.ehealth_connector.cda.ch.vacd.CdaChVacd;
import org.ehealth_connector.cda.ch.vacd.CriterionEntry;
import org.ehealth_connector.cda.ch.vacd.GestationalAge;
import org.ehealth_connector.cda.ch.vacd.Immunization;
import org.ehealth_connector.cda.ch.vacd.ImmunizationRecommendation;
import org.ehealth_connector.cda.ch.vacd.LaboratoryObservation;
import org.ehealth_connector.cda.ch.vacd.MedicationTargetEntry;
import org.ehealth_connector.cda.enums.AllergiesAndIntolerances;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.enums.MedicationsSpecialConditions;
import org.ehealth_connector.cda.enums.ProblemConcernStatusCode;
import org.ehealth_connector.cda.enums.ProblemType;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.Confidentiality;
import org.ehealth_connector.common.enums.Ucum;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.fhir.FhirCommon;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.composite.QuantityDt;
import ca.uhn.fhir.model.dstu2.composite.RatioDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Basic;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.Condition;
import ca.uhn.fhir.model.dstu2.resource.ListResource;
import ca.uhn.fhir.model.dstu2.resource.Medication;
import ca.uhn.fhir.model.dstu2.resource.MedicationStatement;
import ca.uhn.fhir.model.dstu2.resource.MedicationStatement.Dosage;
import ca.uhn.fhir.model.dstu2.resource.Observation;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Person;
import ca.uhn.fhir.model.dstu2.valueset.ConditionClinicalStatusCodesEnum;
import ca.uhn.fhir.model.primitive.DateTimeDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.util.ElementUtil;

/**
 * FhirCdaChVacd supports the creation of a CDA-CH-CH document from HL7 FHIR
 * bundle resources. The content of these resources is not currently documented.
 * These resources may be created by the class
 * org.ehealth_connector.demo.cda.VACDResources. This is currently the one any
 * only way to create valid FHIR bundle resources for CDA-CH-VACD. You may edit
 * these FHIR resources in a text editor in order to change the payload of the
 * resulting CdaChVacd object on your own risk.
 *
 * @see "https://www.hl7.org/fhir/"
 */
/**
 * <div class="en"></div><div class="de"></div><div class="fr"></div>
 */
public class FhirCdaChVacd {

	/**
	 * <div class="en">Type of the bundle to define whether the resulting CDA
	 * document contains full or masked patient demographics</div>
	 * <div class="de"></div><div class="fr"></div>
	 */
	public static enum DocTypeCode {
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
	 * @formatter:off
	 * @see "http://jamesagnew.github.io/hapi-fhir/index.html"
	 * @formatter:on</div><div class="de"></div><div class="fr"></div>
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
		@Extension(url = FhirCommon.urnUseAsAuthor, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Person who documented the medication statement")
		private ResourceReferenceDt author;

		/**
		 * <div class="en">Code of the medication administration</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "code")
		@Extension(url = FhirCommon.urnUseAsCode, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Code of the medication administration")
		private CodingDt code;

		/**
		 * <div class="en">Remark for this medication statement</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "comment")
		@Extension(url = FhirCommon.urnUseAsComment, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Remark for this medication statement")
		private StringDt comment;

		/**
		 * <div class="en">List of reasons for this medication statement</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "externalDocument")
		@Extension(url = FhirCommon.urnUseAsExternalDocument, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "reference to the guidline for the immunization recommendation")
		private ResourceReferenceDt externalDocument;

		/**
		 * <div class="en">LotNumber for this medication statement</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "lot")
		@Extension(url = FhirCommon.urnUseAsLotNumbertext, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "LotNumber for this medication statement")
		private StringDt lot;

		/**
		 * <div class="en">Person who performed the medication
		 * administration</div> <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "performer")
		@Extension(url = FhirCommon.urnUseAsPerformer, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Person who performed the medication administration")
		private ResourceReferenceDt performer;

		/**
		 * <div class="en">List of reasons for this medication statement</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "reasons")
		@Extension(url = FhirCommon.urnUseAsReason, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "List of reasons for this medication statement")
		private ResourceReferenceDt reasons;

		/**
		 * <div class="en">Empty constructor (default)</div>
		 * <div class="de"></div> <div class="fr"></div>
		 */
		public MyMedicationStatement() {
			super();
		}

		/**
		 * @return <div class="en">author of this MedicationStatement</div>
		 *         <div class="de">Autor dieses MedicationStatements</div>
		 *         <div class="fr">auteur de ce MedicationStatement</div>
		 */
		public ResourceReferenceDt getAuthor() {
			if (this.author == null) {
				this.author = new ResourceReferenceDt();
			}
			return author;
		}

		/**
		 * @return <div class="en">code of this MedicationStatement</div>
		 *         <div class="de">Code für dieses MedicationStatement</div>
		 *         <div class="fr">code de ce MedicationStatement</div>
		 */
		public CodingDt getCode() {
			return code;
		}

		/**
		 * @return <div class="en">comment for this medication</div>
		 *         <div class="de">Kommentar zu diesem Medikament</div>
		 *         <div class="fr">commentaire tu médicament</div>
		 */
		public StringDt getComment() {
			if (this.comment == null) {
				this.comment = new StringDt();
			}
			return comment;
		}

		/**
		 * Gets the external document.
		 *
		 * @return the external document
		 */
		public ResourceReferenceDt getExternalDocument() {
			if (this.externalDocument == null) {
				this.externalDocument = new ResourceReferenceDt();
			}
			return externalDocument;
		}

		/**
		 * @return <div class="en">lot number of this medication</div>
		 *         <div class="de">Lotnummer des Medikaments</div>
		 *         <div class="fr">numero lot du médicament</div>
		 */
		public StringDt getLot() {
			if (this.lot == null) {
				this.lot = new StringDt();
			}
			return lot;
		}

		/**
		 * @return <div class="en">performer of the medication
		 *         administration</div> <div class="de">Person, welche das
		 *         Medikament verabreicht hat</div><div class="fr">personne qui
		 *         a effectué l'administration du médicament</div>
		 */
		public ResourceReferenceDt getPerformer() {
			if (this.performer == null) {
				this.performer = new ResourceReferenceDt();
			}
			return performer;
		}

		/**
		 * @return <div class="en">reason for this medication</div>
		 *         <div class="de">Begründung für dieses Medikament</div>
		 *         <div class="fr">Justification de ce médicament</div>
		 */
		public ResourceReferenceDt getReasons() {
			if (this.reasons == null) {
				this.reasons = new ResourceReferenceDt();
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
			return super.isEmpty() && ElementUtil.isEmpty(code, performer, author, comment);
		}

		/**
		 * @param author
		 *            <div class="en">author of this MedicationStatement</div>
		 *            <div class="de">Autor dieses MedicationStatements</div>
		 *            <div class="fr">auteur de ce MedicationStatement</div>
		 */
		public void setAuthor(ResourceReferenceDt author) {
			this.author = author;
		}

		/**
		 * @param code
		 *            <div class="en">code of this MedicationStatement</div>
		 *            <div class="de">Code für dieses MedicationStatement</div>
		 *            <div class="fr">code de ce MedicationStatement</div>
		 */
		public void setCode(CodingDt code) {
			this.code = code;
		}

		/**
		 * @param comment
		 *            <div class="en">comment for this medication</div>
		 *            <div class="de">Kommentar zu diesem Medikament</div>
		 *            <div class="fr">commentaire tu médicament</div>
		 */
		public void setComment(StringDt comment) {
			this.comment = comment;
		}

		/**
		 * Sets the external document.
		 *
		 * @param externalDocument
		 *            the new external document
		 */
		public void setExternalDocument(ResourceReferenceDt externalDocument) {
			this.externalDocument = externalDocument;
		}

		/**
		 * @param lot
		 *            <div class="en">lot number of this medication</div>
		 *            <div class="de">Lotnummer des Medikaments</div>
		 *            <div class="fr">numero lot du médicament</div>
		 */
		public void setLot(StringDt lot) {
			this.lot = lot;
		}

		/**
		 * @param performer
		 *            <div class="en">performer of the medication
		 *            administration</div> <div class="de">Person, welche das
		 *            Medikament verabreicht hat</div><div class="fr">personne
		 *            qui a effectué l'administration du médicament</div>
		 */
		public void setPerformer(ResourceReferenceDt performer) {
			this.performer = performer;
		}

		/**
		 * @param reasons
		 *            <div class="en">reason for this medication</div>
		 *            <div class="de">Begründung für dieses Medikament</div>
		 *            <div class="fr">Justification de ce médicament</div>
		 */
		public void setReasons(ResourceReferenceDt reasons) {
			this.reasons = reasons;
		}

	}

	/**
	 * The class VacdDocument is a derived FHIR Bundle containing all
	 * information of an immunization document corresponding to the CDA-CH-VACD
	 * specification
	 */
	@ResourceDef(name = "Bundle")
	public static class VacdDocument extends Bundle {

		private static final long serialVersionUID = -1316775746486313864L;

		/** The active problem concern entries. */
		@Child(name = "activeProblemConcernEntries", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsActiveProblemConcernEntries, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "activeProblemConcernEntries")
		private List<ResourceReferenceDt> activeProblemConcernEntries; // Condition

		/** The allergy problem concern entries. */
		@Child(name = "allergyProblemConcernEntries", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsAllergyProblemConcernEntries, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "allergyProblemConcernEntries")
		private List<ResourceReferenceDt> allergyProblemConcernEntries; // Condition

		/** The coded result observations. */
		@Child(name = "codedResultObservations", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsCodedResultObservations, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "codedResultObservations")
		private List<ResourceReferenceDt> codedResultObservations; // codedResults

		/** The comment. */
		@Child(name = "comment")
		@Extension(url = FhirCommon.urnUseAsComment, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "comment")
		private ResourceReferenceDt comment;

		/** The confidentiality. */
		@Child(name = "confidentiality")
		@Extension(url = FhirCommon.urnUseAsConfidentiality, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "confidentiality")
		private ResourceReferenceDt confidentiality;

		/** The custodian. */
		@Child(name = "custodian")
		@Extension(url = FhirCommon.urnUseAsCustodian, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "custodian")
		private ResourceReferenceDt custodian;

		/** The doc author. */
		@Child(name = "docAuthor")
		@Extension(url = FhirCommon.urnUseAsAuthor, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "author")
		private ResourceReferenceDt docAuthor;

		/** The doc language. */
		@Child(name = "docLanguage")
		@Extension(url = FhirCommon.urnUseAsLanguage, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "docLanguage")
		private ResourceReferenceDt docLanguage;

		/** The doc type. */
		@Child(name = "docType")
		@Extension(url = FhirCommon.urnUseAsDocType, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "docType")
		private ResourceReferenceDt docType;

		/** The immunization recommendations. */
		@Child(name = "immunizationRecommendations", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsImmunizationRecommendation, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "immunizationRecommendations")
		private List<ResourceReferenceDt> immunizationRecommendations;

		/** The immunizations. */
		@Child(name = "immunizations", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsImmunization, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "immunizations")
		private List<ResourceReferenceDt> immunizations;

		/** The laboratory observations. */
		@Child(name = "laboratoryObservations", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsLaboratoryObservations, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "laboratoryObservations")
		private List<ResourceReferenceDt> laboratoryObservations; // Observations

		/** The legal authenticator. */
		@Child(name = "legalAuthenticator")
		@Extension(url = FhirCommon.urnUseAsLegalAuthenticator, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "legalAuthenticator")
		private ResourceReferenceDt legalAuthenticator;

		/** The past problem concern entries. */
		@Child(name = "pastProblemConcernEntries", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsPastProblemConcernEntries, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "pastProblemConcernEntries")
		private List<ResourceReferenceDt> pastProblemConcernEntries; // Condition

		/** The patient. */
		@Child(name = "patient")
		@Extension(url = FhirCommon.urnUseAsPatient, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "patient")
		private ResourceReferenceDt patient;

		/** The pregnancy observation. */
		@Child(name = "pregnancyObservation,", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsPregnancyObservation, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "pregnancyObservation")
		private ResourceReferenceDt pregnancyObservation; // Observation

		/**
		 * Adds the active problem concern entry.
		 *
		 * @param activeProbemlConcernEntry
		 *            the active probeml concern entry
		 */
		public void addActiveProblemConcernEntry(Condition activeProbemlConcernEntry) {
			if (activeProblemConcernEntries == null) {
				activeProblemConcernEntries = new ArrayList<ResourceReferenceDt>();
			}
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
				allergyProblemConcernEntries = new ArrayList<ResourceReferenceDt>();
			}
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
				codedResultObservations = new ArrayList<ResourceReferenceDt>();
			}
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
				immunizations = new ArrayList<ResourceReferenceDt>();
			}
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
				immunizationRecommendations = new ArrayList<ResourceReferenceDt>();
			}
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
				laboratoryObservations = new ArrayList<ResourceReferenceDt>();
			}
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
				pastProblemConcernEntries = new ArrayList<ResourceReferenceDt>();
			}
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
			resourceRef.setResource(pastProblemConcernEntry);
			this.pastProblemConcernEntries.add(resourceRef);
		}

		/**
		 * Gets the active problem concern entries.
		 *
		 * @return the active problem concern entries
		 */
		public List<Condition> getActiveProblemConcernEntries() {
			final List<Condition> list = new ArrayList<Condition>();
			if (this.activeProblemConcernEntries != null) {
				for (final ResourceReferenceDt resource : this.activeProblemConcernEntries) {
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
			final List<Condition> list = new ArrayList<Condition>();
			if (this.allergyProblemConcernEntries != null) {
				for (final ResourceReferenceDt resource : allergyProblemConcernEntries) {
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
			final List<Observation> list = new ArrayList<Observation>();
			if (this.codedResultObservations != null) {
				for (final ResourceReferenceDt resource : codedResultObservations) {
					list.add((Observation) resource.getResource());
				}
			}
			return list;
		}

		/**
		 * Gets the comment.
		 *
		 * @return the comment
		 */
		public Observation getComment() {
			if (this.comment != null) {
				return (Observation) this.comment.getResource();
			}
			return null;
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
		 * Gets the custodian.
		 *
		 * @return the custodian
		 */
		public Organization getCustodian() {
			if (this.custodian != null) {
				return (Organization) this.custodian.getResource();
			}
			return null;
		}

		/**
		 * Gets the doc author.
		 *
		 * @return the doc author
		 */
		public Person getDocAuthor() {
			if (this.docAuthor != null) {
				return (Person) this.docAuthor.getResource();
			}
			return null;
		}

		/**
		 * Gets the doc language.
		 *
		 * @return the doc language
		 */
		public Basic getDocLanguage() {
			if (this.docLanguage != null) {
				return (Basic) this.docLanguage.getResource();
			}
			return null;
		}

		/**
		 * Gets the doc type.
		 *
		 * @return the doc type
		 */
		public Basic getDocType() {
			if (this.docType != null) {
				return (Basic) this.docType.getResource();
			}
			return null;
		}

		/**
		 * Gets the immunization recommendations.
		 *
		 * @return the immunization recommendations
		 */
		public List<MedicationStatement> getImmunizationRecommendations() {
			final List<MedicationStatement> list = new ArrayList<MedicationStatement>();
			if (this.immunizationRecommendations != null) {
				for (final ResourceReferenceDt resource : immunizationRecommendations) {
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
			final List<MedicationStatement> list = new ArrayList<MedicationStatement>();
			if (this.immunizations != null) {
				for (final ResourceReferenceDt resource : immunizations) {
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
			final List<Observation> list = new ArrayList<Observation>();
			if (this.laboratoryObservations != null) {
				for (final ResourceReferenceDt resource : laboratoryObservations) {
					list.add((Observation) resource.getResource());
				}
			}
			return list;
		}

		/**
		 * Gets the legal authenticator.
		 *
		 * @return the legal authenticator
		 */
		public Person getLegalAuthenticator() {
			if (this.legalAuthenticator != null) {
				return (Person) this.legalAuthenticator.getResource();
			}
			return null;
		}

		/**
		 * Gets the past problem concern entries.
		 *
		 * @return the past problem concern entries
		 */
		public List<Condition> getPastProblemConcernEntries() {
			final List<Condition> list = new ArrayList<Condition>();
			if (this.pastProblemConcernEntries != null) {
				for (final ResourceReferenceDt resource : pastProblemConcernEntries) {
					list.add((Condition) resource.getResource());
				}
			}
			return list;
		}

		/**
		 * Gets the patient.
		 *
		 * @return the patient
		 */
		public Patient getPatient() {
			if (this.patient != null) {
				return (Patient) this.patient.getResource();
			}
			return null;
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
		 * Sets the comment.
		 *
		 * @param comment
		 *            the new comment
		 */
		public void setComment(Observation comment) {
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
			resourceRef.setResource(comment);
			this.comment = resourceRef;
		}

		/**
		 * Sets the confidentiality code.
		 *
		 * @param confidentiality
		 *            the new confidentiality code
		 */
		public void setConfidentiality(Basic confidentiality) {
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
			resourceRef.setResource(confidentiality);
			this.confidentiality = resourceRef;
		}

		/**
		 * Sets the custodian.
		 *
		 * @param custodian
		 *            the new custodian
		 */
		public void setCustodian(Organization custodian) {
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
			resourceRef.setResource(custodian);
			this.custodian = resourceRef;
		}

		/**
		 * Sets the doc author.
		 *
		 * @param author
		 *            the new doc author
		 */
		public void setDocAuthor(Person author) {
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
			resourceRef.setResource(author);
			this.docAuthor = resourceRef;
		}

		/**
		 * Sets the doc language.
		 *
		 * @param language
		 *            the new doc language
		 */
		public void setDocLanguage(Basic language) {
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
			resourceRef.setResource(language);
			this.docLanguage = resourceRef;
		}

		/**
		 * Sets the doc type.
		 *
		 * @param typePseudonymized
		 *            the new doc type
		 */
		public void setDocType(Basic typePseudonymized) {
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
			resourceRef.setResource(typePseudonymized);
			this.docType = resourceRef;
		}

		/**
		 * Sets the legal authenticator.
		 *
		 * @param legalAuthenticator
		 *            the new legal authenticator
		 */
		public void setLegalAuthenticator(Person legalAuthenticator) {
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
			resourceRef.setResource(legalAuthenticator);
			this.legalAuthenticator = resourceRef;
		}

		/**
		 * Sets the patient.
		 *
		 * @param patient
		 *            the new patient
		 */
		public void setPatient(Patient patient) {
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
			resourceRef.setResource(patient);
			this.patient = resourceRef;
		}

		/**
		 * Sets the pregnancy observation.
		 *
		 * @param pregnancyObservation
		 *            the new pregnancy observation
		 */
		public void setPregnancyObservation(Observation pregnancyObservation) {
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
			resourceRef.setResource(pregnancyObservation);
			this.pregnancyObservation = resourceRef;
		}

	};

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div>
	 * <div class="de"></div><div class="fr"></div>
	 */
	public static final String OID_CONFIDENTIALITY_CODE = "urn:oid:"
			+ CodeSystems.ConfidentialityCode.getCodeSystemId();;

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div>
	 * <div class="de"></div><div class="fr"></div>
	 */
	public static final String OID_VACD = "urn:oid:" + CdaChVacd.OID_MAIN;

	private final FhirContext fhirCtx = new FhirContext();

	/**
	 * <div class="en">Empty constructor (default)</div><div class="de"></div>
	 * <div class="fr"></div>
	 */
	public FhirCdaChVacd() {
	}

	/**
	 * <div class="en">Creates an eHC CdaChVacd instance from a valid FHIR
	 * Bundle resource</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param xsl
	 *            <div class="en">desired stylesheet for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param css
	 *            <div class="en">desired CSS for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC CdaChVacd instance containing payload of the
	 *         given FHIR Bundle resource</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChVacd createCdaChVacdFromFHIRBundle(Bundle bundle, String xsl, String css) {

		// Header
		final CdaChVacd doc = new CdaChVacd(getDocLanguage(bundle), xsl, css);
		final DocTypeCode docType = getDocType(bundle);
		doc.setConfidentialityCode(getConfidentialityCode(bundle));
		doc.setPatient(FhirCommon.getPatient(bundle));
		if (docType == DocTypeCode.PSEUDONYMIZED)
			doc.pseudonymization();

		for (final Author author : getAuthors(bundle)) {
			author.setTime(DateUtil.date("15.12.2014"));
			doc.addAuthor(author);
		}
		doc.setCustodian(getCustodian(bundle));
		doc.setLegalAuthenticator(getLegalAuthenticator(bundle));

		// Body
		// Immunizations / Impfungen
		for (final Immunization immunization : getImmunizations(bundle)) {
			doc.addImmunization(immunization);
		}

		// Active Problems / Problemliste
		for (final ActiveProblemConcern activeProblemConcernEntry : getActiveProblemConcernEntries(
				bundle)) {
			doc.addActiveProblemConcern(activeProblemConcernEntry);
		}

		// History of Past Illness / Bisherige Krankheiten/Anamnese
		for (final PastProblemConcern pastProblemConcern : getPastProblemConcernEntries(bundle)) {
			doc.addPastProblemConcern(pastProblemConcern);
		}

		// Allergies and Basic Adverse Reactions / Allergien und
		// Unverträglichkeiten
		for (final AllergyConcern allergyProblemConcern : getAllergyProblemConcernEntries(bundle)) {
			doc.addAllergyConcern(allergyProblemConcern);
		}

		// Coded Results for gestational age / Codierte Resultate für
		// Gestationsalter
		final CodedResults cr = getGestationalAge(bundle);
		if (cr != null) {
			doc.addCodedResults(cr);
		}

		// Laboratory Specialty Section / Relevante Laborbefunde
		for (final LaboratoryObservation laboratoryObservation : getLaboratoryObservations(
				bundle)) {
			doc.addLaboratoryObservation(laboratoryObservation);
		}

		// Schwangerschaftsanamnese
		// Coded Results for gestational age / Codierte Resultate für
		// Gestationsalter
		final PregnancyHistory ph = getPregnancyHistory(bundle);
		if (ph != null) {
			doc.addPregnancyHistory(ph);
		}

		for (final ImmunizationRecommendation immunizationRecommendation : getImmunizationRecommendations(
				bundle)) {
			doc.addImmunizationRecommendation(immunizationRecommendation);
		}

		doc.addComment(getComment(bundle));

		return doc;
	}

	/**
	 * <div class="en">Gets a list of eHC ActiveProblemConcerns from the given
	 * FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return list of eHC ActiveProblemConcerns </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.cda.ch.ActiveProblemConcern> getActiveProblemConcernEntries(
			Bundle bundle) {
		final List<org.ehealth_connector.cda.ch.ActiveProblemConcern> retVal = new ArrayList<org.ehealth_connector.cda.ch.ActiveProblemConcern>();
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsActiveProblemConcern)
					.isEmpty() && (entry.getResource() instanceof Condition)) {
				retVal.add(getActiveProblemConcern((Condition) entry.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC AllergyConcerns from the given FHIR
	 * bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return list of eHC AllergyConcerns </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.cda.ch.AllergyConcern> getAllergyProblemConcernEntries(
			Bundle bundle) {
		final List<org.ehealth_connector.cda.ch.AllergyConcern> retVal = new ArrayList<org.ehealth_connector.cda.ch.AllergyConcern>();
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsAllergyProblemConcern)
					.isEmpty() && (entry.getResource() instanceof Condition)) {
				retVal.add(getAllergyProblemConcern((Condition) entry.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets an eHC Author object from the given FHIR
	 * MedicationStatement object
	 *
	 * @param fhirMedicationStatement
	 *            the FHIR MedicationStatement object
	 * @return eHC Author object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public org.ehealth_connector.common.Author getAuthor(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.common.Author retVal = null;
		// fhirMedicationStatement.getSupportingInformation();
		for (final ResourceReferenceDt ref : fhirMedicationStatement.getSupportingInformation()) {
			if (!ref.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsAuthor).isEmpty()) {
				retVal = FhirCommon.getAuthor((Person) ref.getResource());
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC Authors from the given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return list of eHC Authors </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.common.Author> getAuthors(Bundle bundle) {
		final List<org.ehealth_connector.common.Author> retVal = new ArrayList<org.ehealth_connector.common.Author>();
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsAuthor).isEmpty()
					&& (entry.getResource() instanceof Person)) {
				retVal.add(FhirCommon.getAuthor((Person) entry.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the comment from the given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC Author object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public String getComment(Bundle bundle) {
		String retVal = "";
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsComment).isEmpty()
					&& (entry.getResource() instanceof Observation)) {
				retVal = ((Observation) entry.getResource()).getComments();
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets the eHC confidentiality code from the given FHIR
	 * bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC confidentiality code </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public Confidentiality getConfidentialityCode(Bundle bundle) {
		Confidentiality retVal = Confidentiality.NORMAL; // default
		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Basic) {
				final Basic fhirBasic = (Basic) entry.getResource();
				final CodingDt langCode = fhirBasic.getCode().getCodingFirstRep();
				if (langCode.getSystem().equals(OID_CONFIDENTIALITY_CODE)) {
					if ("veryrestricted".equals(langCode.getCode().toLowerCase())) {
						retVal = Confidentiality.VERY_RESTRICTED;
						break;
					} else if ("restricted".equals(langCode.getCode().toLowerCase())) {
						retVal = Confidentiality.RESTRICED;
						break;
					} else if ("normal".equals(langCode.getCode().toLowerCase())) {
						retVal = Confidentiality.NORMAL;
						break;
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets a FHIR ListResource object containing the
	 * criterions in the given FHIR MedicationStatement object
	 *
	 * @param fhirMedicationStatement
	 *            the FHIR MedicationStatement object
	 * @return FHIR ListResource object containing the criterions </div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public ListResource getCriterions(MedicationStatement fhirMedicationStatement) {
		ListResource retVal = new ListResource();
		// fhirMedicationStatement.getSupportingInformation();
		for (final ResourceReferenceDt ref : fhirMedicationStatement.getSupportingInformation()) {
			if (!ref.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsCriterion).isEmpty()) {
				retVal = (ListResource) ref.getResource();
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the eHC Custodian from the given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC Custodian</div> <div class="de"></div> <div class="fr"></div>
	 */
	public org.ehealth_connector.common.Organization getCustodian(Bundle bundle) {
		org.ehealth_connector.common.Organization retVal = null;
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsCustodian).isEmpty()
					&& (entry.getResource() instanceof Organization)) {
				retVal = FhirCommon.getOrganization((Organization) entry.getResource());
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets the eHC document language code from the given FHIR
	 * bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC document language </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public LanguageCode getDocLanguage(Bundle bundle) {
		LanguageCode retVal = LanguageCode.GERMAN; // default
		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Basic) {
				final Basic fhirBasic = (Basic) entry.getResource();
				final CodingDt langCode = fhirBasic.getCode().getCodingFirstRep();
				if (langCode.getSystem().equals(FhirCommon.oidLanguage)) {
					if (langCode.getCode().toLowerCase().startsWith("de")) {
						retVal = LanguageCode.GERMAN;
						break;
					} else if (langCode.getCode().toLowerCase().startsWith("fr")) {
						retVal = LanguageCode.FRENCH;
						break;
					} else if (langCode.getCode().toLowerCase().startsWith("it")) {
						retVal = LanguageCode.ITALIAN;
						break;
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets the eHC Vacd document type code (full or masked
	 * patient demographics) from the given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC Vacd document type code (full or masked patient
	 *         demographics)</div> <div class="de"></div> <div class="fr"></div>
	 */
	public DocTypeCode getDocType(Bundle bundle) {
		DocTypeCode retVal = DocTypeCode.PATIENT; // default
		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Basic) {
				final Basic fhirBasic = (Basic) entry.getResource();
				final CodingDt langCode = fhirBasic.getCode().getCodingFirstRep();
				if (OID_VACD.equals(langCode.getSystem())) {
					if ("patient".equals(langCode.getCode().toLowerCase())) {
						retVal = DocTypeCode.PATIENT;
						break;
					} else if ("pseudonymized".equals(langCode.getCode().toLowerCase())) {
						retVal = DocTypeCode.PSEUDONYMIZED;
						break;
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets the eHC CodedResults object from the given FHIR
	 * bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC CodedResults object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public org.ehealth_connector.cda.ch.CodedResults getGestationalAge(Bundle bundle) {
		CodedResults retVal = null;
		BigInteger gWeek = BigInteger.valueOf(-1);
		BigInteger gDay = BigInteger.valueOf(-1);
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsPregnancyObservation)
					.isEmpty() && (entry.getResource() instanceof Observation)) {
				final Observation fhirObs = (Observation) entry.getResource();
				final CodingDt fhirCode = fhirObs.getCode().getCodingFirstRep();
				if ("49051-6".equals(fhirCode.getCode())) {
					gWeek = ((QuantityDt) fhirObs.getValue()).getValue().toBigInteger();
				}
				if ("49052-4".equals(fhirCode.getCode())) {
					gDay = ((QuantityDt) fhirObs.getValue()).getValue().toBigInteger();
				}
			}
		}

		if ((gDay.intValue() > -1) && (gWeek.intValue() > -1)) {
			retVal = new GestationalAge(gWeek.intValue(), gDay.intValue());
			// not yet implemented:
			// retVal.setPerformer(perfomer);
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC ImmunizationRecommendations from the
	 * given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return list of eHC ImmunizationRecommendations </div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public List<org.ehealth_connector.cda.ch.vacd.ImmunizationRecommendation> getImmunizationRecommendations(
			Bundle bundle) {
		final List<org.ehealth_connector.cda.ch.vacd.ImmunizationRecommendation> retVal = new ArrayList<org.ehealth_connector.cda.ch.vacd.ImmunizationRecommendation>();
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsImmunizationRecommendation)
					.isEmpty() && (entry.getResource() instanceof MedicationStatement)) {
				retVal.add(
						getImmunizationRecommendation((MedicationStatement) entry.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC Immunizations from the given FHIR
	 * bundle
	 *
	 * @param bundle
	 *            FHIR bundle
	 * @return list of eHC Immunizations </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.cda.ch.vacd.Immunization> getImmunizations(Bundle bundle) {
		final List<org.ehealth_connector.cda.ch.vacd.Immunization> retVal = new ArrayList<org.ehealth_connector.cda.ch.vacd.Immunization>();
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsImmunization).isEmpty()
					&& (entry.getResource() instanceof MedicationStatement)) {
				retVal.add(getImmunization((MedicationStatement) entry.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC LaboratoryObservations from the given
	 * FHIR bundle
	 *
	 * @param bundle
	 *            FHIR bundle
	 * @return list of eHC LaboratoryObservations </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.cda.ch.vacd.LaboratoryObservation> getLaboratoryObservations(
			Bundle bundle) {
		final List<org.ehealth_connector.cda.ch.vacd.LaboratoryObservation> retVal = new ArrayList<org.ehealth_connector.cda.ch.vacd.LaboratoryObservation>();
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsLaboratoryObservation)
					.isEmpty() && (entry.getResource() instanceof Observation)) {
				retVal.add(getLaboratoryObservation((Observation) entry.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * Gets an eHC Author object containing the legal authenticator from the
	 * given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC Author object containing the legal authenticator
	 */
	public org.ehealth_connector.common.Author getLegalAuthenticator(Bundle bundle) {
		org.ehealth_connector.common.Author retVal = null;
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsLegalAuthenticator).isEmpty()
					&& (entry.getResource() instanceof Person)) {
				retVal = FhirCommon.getAuthor((Person) entry.getResource());
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets a FHIR ListResource object containing the
	 * medication targes in the given FHIR MedicationStatement object
	 *
	 * @param fhirMedicationStatement
	 *            the FHIR MedicationStatement object
	 * @return FHIR ListResource object containing the medication targets </div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public ListResource getMedicationTargets(MedicationStatement fhirMedicationStatement) {
		ListResource retVal = new ListResource();
		// fhirMedicationStatement.getSupportingInformation();
		for (final ResourceReferenceDt ref : fhirMedicationStatement.getSupportingInformation()) {
			if (!ref.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsMedicationTarget).isEmpty()) {
				retVal = (ListResource) ref.getResource();
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC PastProblemConcerns from the given
	 * FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return list of eHC PastProblemConcerns </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.cda.ch.PastProblemConcern> getPastProblemConcernEntries(
			Bundle bundle) {
		final List<org.ehealth_connector.cda.ch.PastProblemConcern> retVal = new ArrayList<org.ehealth_connector.cda.ch.PastProblemConcern>();
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsPastProblemConcern).isEmpty()
					&& (entry.getResource() instanceof Condition)) {
				retVal.add(getPastProblemConcern((Condition) entry.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * Gets an eHC Author object containing the performer from the given FHIR
	 * MedicationStatement object
	 *
	 * @param fhirMedicationStatement
	 *            the FHIR bundle
	 * @return eHC Author object containing the performer
	 */
	public org.ehealth_connector.common.Author getPerformer(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.common.Author retVal = null;
		// fhirMedicationStatement.getSupportingInformation();
		for (final ResourceReferenceDt ref : fhirMedicationStatement.getSupportingInformation()) {
			if (!ref.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsPerformer).isEmpty()) {
				retVal = FhirCommon.getAuthor((Person) ref.getResource());
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the eHC PregnancyHistory object from the given FHIR
	 * bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC PregnancyHistory object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public org.ehealth_connector.cda.ch.PregnancyHistory getPregnancyHistory(Bundle bundle) {
		PregnancyHistory retVal = null;
		Date deliveryDate = null;
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsPregnancyObservation)
					.isEmpty() && (entry.getResource() instanceof Observation)) {
				final Observation fhirObs = (Observation) entry.getResource();
				final CodingDt fhirCode = fhirObs.getCode().getCodingFirstRep();
				if ("11778-8".equals(fhirCode.getCode())) {
					deliveryDate = ((DateTimeDt) fhirObs.getValue()).getValue();
				}
			}
		}

		if (deliveryDate != null) {
			retVal = new PregnancyHistory(deliveryDate);
			// not yet implemented:
			// retVal.setPerformer(perfomer);
		}
		return retVal;
	}

	/**
	 * Read the VacdDocument object from the FHIR bundle file
	 *
	 * @param fileName
	 *            the file name
	 * @return the vacd document
	 */
	public VacdDocument readVacDocumentFromFile(String fileName) {
		final String resourceString = FhirCommon.getXmlResource(fileName);
		final IParser parser = fhirCtx.newXmlParser();
		return parser.parseResource(VacdDocument.class, resourceString);
	}

	private org.ehealth_connector.cda.ch.ActiveProblemConcern getActiveProblemConcern(
			Condition fhirCondition) {

		final String concern = fhirCondition.getNotes();
		final Date date = fhirCondition.getDateRecorded();

		final org.ehealth_connector.cda.Problem problemEntry = getProblemEntry(fhirCondition);
		final org.ehealth_connector.cda.enums.ProblemConcernStatusCode problemStatusCode = getProblemConcernStatusCode(
				fhirCondition);

		// Create the ActiveProblemConcern
		final org.ehealth_connector.cda.ch.ActiveProblemConcern retVal = new org.ehealth_connector.cda.ch.ActiveProblemConcern(
				concern, date, problemEntry, problemStatusCode);

		return retVal;

	}

	private org.ehealth_connector.cda.ch.AllergyConcern getAllergyProblemConcern(
			Condition fhirCondition) {

		final String concern = fhirCondition.getNotes();
		final org.ehealth_connector.cda.ch.AllergyProblem problemEntry = getAllergyProblemEntry(
				fhirCondition);

		final org.ehealth_connector.cda.enums.ProblemConcernStatusCode problemStatusCode = getProblemConcernStatusCode(
				fhirCondition);
		// // Create the AllergyProblemConcern
		// retVal = new org.ehealth_connector.cda.AllergyConcern(concern,
		// problemEntry, problemStatusCode);
		//
		// // Date
		// retVal.setStartDate(fhirCondition.getDateAsserted());

		final org.ehealth_connector.cda.ch.AllergyConcern retVal = new org.ehealth_connector.cda.ch.AllergyConcern(
				concern, fhirCondition.getDateRecorded(), null, problemEntry, problemStatusCode);

		return retVal;

	}

	private org.ehealth_connector.cda.ch.AllergyProblem getAllergyProblemEntry(
			Condition fhirCondition) {

		final org.ehealth_connector.cda.ch.AllergyProblem retVal = new org.ehealth_connector.cda.ch.AllergyProblem();
		final CodingDt fhirCode = fhirCondition.getCode().getCodingFirstRep();

		// Add Problem Entry Identifiers
		for (final IdentifierDt id : fhirCondition.getIdentifier()) {
			final String codeSystem = FhirCommon.removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// currently only Drug intolerances supported
		retVal.setCode(AllergiesAndIntolerances.DRUG_INTOLERANCE);

		// Date
		retVal.setStartDate(fhirCondition.getDateRecorded());

		// Value
		retVal.addValue(new Code(FhirCommon.removeURIPrefix(fhirCode.getSystem()),
				fhirCode.getCode(), fhirCode.getDisplay()));

		return retVal;
	}

	private Code getCode(MedicationStatement fhirMedicationStatement) {
		Code retVal = null;
		if (!fhirMedicationStatement.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsCode)
				.isEmpty()) {
			final CodingDt fhirCode = (CodingDt) fhirMedicationStatement
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsCode).get(0).getValue();
			retVal = new Code(FhirCommon.removeURIPrefix(fhirCode.getSystem()), fhirCode.getCode(),
					fhirCode.getDisplay());
		}
		return retVal;
	}

	private String getComment(MedicationStatement fhirMedicationStatement) {
		String retVal = "";
		if (!fhirMedicationStatement.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsComment)
				.isEmpty()) {
			final StringDt comment = (StringDt) fhirMedicationStatement
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsComment).get(0).getValue();
			retVal = comment.toString();
		}
		return retVal;
	}

	private org.ehealth_connector.cda.Consumable getConsumable(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.cda.Consumable retVal = null;

		if (fhirMedicationStatement.getMedication() instanceof ResourceReferenceDt) {
			final ResourceReferenceDt ref = (ResourceReferenceDt) fhirMedicationStatement
					.getMedication();
			final Medication fhirMedi = (Medication) ref.getResource();
			// Create the consumable
			retVal = new org.ehealth_connector.cda.Consumable(fhirMedi.getCode().getText());

			// Set id
			if (!fhirMedi.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsIdentifier).isEmpty()) {
				final IdentifierDt id = (IdentifierDt) fhirMedi
						.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsIdentifier).get(0)
						.getValue();
				retVal.setManufacturedProductId(new org.ehealth_connector.common.Identificator(
						FhirCommon.removeURIPrefix(id.getSystem()), id.getValue()));
			}

			// Set code
			final CodingDt fhirCode = fhirMedi.getCode().getCodingFirstRep();
			final Code code = new Code(FhirCommon.removeURIPrefix(fhirCode.getSystem()),
					fhirCode.getCode(), fhirCode.getDisplay());
			retVal.setWhoAtcCode(code);

			// Set manufacturer
			final ResourceReferenceDt refManufacturer = fhirMedi.getManufacturer();
			retVal.setManufacturer(FhirCommon.getOrganization(refManufacturer.getResource()));

			// LotNumber
			retVal.setLotNr(getLot(fhirMedicationStatement));
		} else {
			// Create the consumable
			retVal = new org.ehealth_connector.cda.Consumable(false);
		}

		return retVal;
	}

	private org.ehealth_connector.cda.ch.vacd.Immunization getImmunization(
			MedicationStatement fhirMedicationStatement) {

		final Code code = getCode(fhirMedicationStatement);

		// Create the immunization
		final org.ehealth_connector.cda.ch.vacd.Immunization retVal = new org.ehealth_connector.cda.ch.vacd.Immunization();

		// Add Identifiers
		for (final IdentifierDt id : fhirMedicationStatement.getIdentifier()) {
			final String codeSystem = FhirCommon.removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// author
		retVal.setAuthor(getAuthor(fhirMedicationStatement));

		if (!"IMMUNIZ".equals(code.getCode())) {
			// code
			retVal.setCode(MedicationsSpecialConditions.getEnum(code.getCode()));
		} else {
			// code
			if (fhirMedicationStatement.getMedication() instanceof CodeableConceptDt) {
				final CodeableConceptDt cc = (CodeableConceptDt) fhirMedicationStatement
						.getMedication();

				retVal.setCode(
						MedicationsSpecialConditions.getEnum(cc.getCodingFirstRep().getCode()));
			}

			// effectiveTime
			retVal.setApplyDate(fhirMedicationStatement.getDateAsserted());

			// doseQuantity
			Double doseQuantity = null;
			for (final Dosage dosage : fhirMedicationStatement.getDosage()) {
				doseQuantity = ((QuantityDt) dosage.getQuantity()).getValue().doubleValue();
				retVal.setDosage(doseQuantity);
				break; // currently only support for one doseQuantity
			}

			// consumable
			final Consumable consumable = getConsumable(fhirMedicationStatement);
			if (consumable != null)
				retVal.setConsumable(consumable);

			// perfomer
			final Author author = getPerformer(fhirMedicationStatement);
			if (author != null)
				retVal.setPerformer(author);

			// medication targets
			final ListResource medicationTargets = getMedicationTargets(fhirMedicationStatement);
			for (final ResourceReferenceDt refObs : medicationTargets
					.getAllPopulatedChildElementsOfType(ResourceReferenceDt.class)) {
				final Observation fhirObs = (Observation) refObs.getResource();
				final CodingDt fhirCode = fhirObs.getCode().getCodingFirstRep();
				final MedicationTargetEntry entry = new MedicationTargetEntry();
				entry.setImmunizationTargetCode(
						new Code(FhirCommon.removeURIPrefix(fhirCode.getSystem()),
								fhirCode.getCode(), fhirCode.getDisplay()));
				retVal.addMedicationTargetEntry(entry);
			}

			// criterion
			final ListResource criterions = getCriterions(fhirMedicationStatement);
			for (final ResourceReferenceDt refObs : criterions
					.getAllPopulatedChildElementsOfType(ResourceReferenceDt.class)) {
				final Observation fhirObs = (Observation) refObs.getResource();
				final CodingDt fhirCode = fhirObs.getCode().getCodingFirstRep();
				final CriterionEntry entry = new CriterionEntry();
				entry.setRecCategoryCode(new Code(FhirCommon.removeURIPrefix(fhirCode.getSystem()),
						fhirCode.getCode(), fhirCode.getDisplay()));
				retVal.setCriterionEntry(entry);
			}

			// comment
			retVal.setCommentText(getComment(fhirMedicationStatement));

		}

		return retVal;

	}

	private org.ehealth_connector.cda.ch.vacd.ImmunizationRecommendation getImmunizationRecommendation(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.cda.ch.vacd.ImmunizationRecommendation retVal = null;

		// Create the immunization
		retVal = new org.ehealth_connector.cda.ch.vacd.ImmunizationRecommendation();

		// Add Identifiers
		for (final IdentifierDt id : fhirMedicationStatement.getIdentifier()) {
			final String codeSystem = FhirCommon.removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));

		}

		// code
		final Code code = getCode(fhirMedicationStatement);
		final MedicationsSpecialConditions specialConditions = MedicationsSpecialConditions
				.getEnum(code.getCode());
		if (specialConditions != null) {
			retVal.setCode(specialConditions);
		} else {
			// code
			if (fhirMedicationStatement.getMedication() instanceof CodeableConceptDt) {
				final CodeableConceptDt cc = (CodeableConceptDt) fhirMedicationStatement
						.getMedication();

				retVal.setCode(
						MedicationsSpecialConditions.getEnum(cc.getCodingFirstRep().getCode()));
			} else {
				retVal.setShallNotBeAdministerd(fhirMedicationStatement.getWasNotTaken());

				// effectiveTime
				// not yet implemented: effectiveTime highValue
				retVal.setPossibleAppliance(fhirMedicationStatement.getDateAsserted(), null);

				// doseQuantity
				Double doseQuantity = null;
				for (final Dosage dosage : fhirMedicationStatement.getDosage()) {
					doseQuantity = ((QuantityDt) dosage.getQuantity()).getValue().doubleValue();
					retVal.setDosage(doseQuantity);
					break; // currently only support for one doseQuantity
				}

				// consumable
				retVal.setConsumable(getConsumable(fhirMedicationStatement));
			}
		}
		// author
		retVal.setAuthor(getAuthor(fhirMedicationStatement));

		// medication targets
		final ListResource medicationTargets = getMedicationTargets(fhirMedicationStatement);
		for (final ResourceReferenceDt refObs : medicationTargets
				.getAllPopulatedChildElementsOfType(ResourceReferenceDt.class)) {
			final Observation fhirObs = (Observation) refObs.getResource();
			final CodingDt fhirCode = fhirObs.getCode().getCodingFirstRep();
			final MedicationTargetEntry entry = new MedicationTargetEntry();
			entry.setImmunizationTargetCode(
					new Code(FhirCommon.removeURIPrefix(fhirCode.getSystem()), fhirCode.getCode(),
							fhirCode.getDisplay()));
			retVal.addMedicationTargetEntry(entry);
		}

		// criterion
		final ListResource criterions = getCriterions(fhirMedicationStatement);
		for (final ResourceReferenceDt refObs : criterions
				.getAllPopulatedChildElementsOfType(ResourceReferenceDt.class)) {
			final Observation fhirObs = (Observation) refObs.getResource();
			final CodingDt fhirCode = fhirObs.getCode().getCodingFirstRep();
			final CriterionEntry entry = new CriterionEntry();
			entry.setRecCategoryCode(new Code(FhirCommon.removeURIPrefix(fhirCode.getSystem()),
					fhirCode.getCode(), fhirCode.getDisplay()));
			retVal.setCriterionEntry(entry);
		}

		// comment
		retVal.setCommentText(getComment(fhirMedicationStatement));

		return retVal;

	}

	private org.ehealth_connector.cda.ch.vacd.LaboratoryObservation getLaboratoryObservation(
			Observation fhirObservation) {
		final org.ehealth_connector.cda.ch.vacd.LaboratoryObservation retVal = new LaboratoryObservation();

		final CodingDt fhirCode = fhirObservation.getCode().getCodingFirstRep();
		retVal.setCode(new Code(FhirCommon.removeURIPrefix(fhirCode.getSystem()),
				fhirCode.getCode(), fhirCode.getDisplay()));
		retVal.setEffectiveTime(fhirObservation.getIssued());
		if (!fhirObservation.getPerformer().isEmpty()) {
			final ResourceReferenceDt refPerf = fhirObservation.getPerformer().get(0);
			retVal.setLaboratory(FhirCommon.getOrganization((Organization) refPerf.getResource()),
					fhirObservation.getIssued());
		}

		if (fhirObservation.getValue() instanceof QuantityDt) {
			// type PQ
			final QuantityDt fhirQuantity = (QuantityDt) fhirObservation.getValue();
			retVal.addValue(new Value(fhirQuantity.getValue().toString(),
					Ucum.getEnum(fhirQuantity.getUnit())));
		} else if (fhirObservation.getValue() instanceof CodeableConceptDt) {
			// type CD
			final CodingDt fhirValueCode = ((CodeableConceptDt) fhirObservation.getValue())
					.getCodingFirstRep();
			retVal.addValue(new Code(new Code(FhirCommon.removeURIPrefix(fhirValueCode.getSystem()),
					fhirValueCode.getCode(), fhirValueCode.getDisplay())));
		} else if (fhirObservation.getValue() instanceof RatioDt) {
			// type RTO not yet implemented
		}

		if (fhirObservation.getReferenceRangeFirstRep() != null) {
			// ReferenceRange not yet implemented
		}

		final CodingDt fhirInterpretationCode = fhirObservation.getInterpretation()
				.getCodingFirstRep();
		if (fhirInterpretationCode != null) {
			if (fhirInterpretationCode.getSystem() != null) {
				retVal.setInterpretationCode(new Code(
						FhirCommon.removeURIPrefix(fhirInterpretationCode.getSystem()),
						fhirInterpretationCode.getCode(), fhirInterpretationCode.getDisplay()));
			}
		}

		retVal.setCommentText(fhirObservation.getComments());

		return retVal;

	}

	private String getLot(MedicationStatement fhirMedicationStatement) {
		String retVal = "";
		if (!fhirMedicationStatement.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsLotNumbertext)
				.isEmpty()) {
			final StringDt lot = (StringDt) fhirMedicationStatement
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsLotNumbertext).get(0)
					.getValue();
			retVal = lot.toString();
		}
		return retVal;
	}

	private org.ehealth_connector.cda.ch.PastProblemConcern getPastProblemConcern(
			Condition fhirCondition) {
		org.ehealth_connector.cda.ch.PastProblemConcern retVal = null;

		final String concern = fhirCondition.getNotes();
		// org.ehealth_connector.cda.Problem problemEntry = new
		// org.ehealth_connector.cda.Problem();
		// CodingDt fhirCode = fhirCondition.getCode().getCodingFirstRep();
		// problemEntry.setCode(new
		// Code(FhirCommon.removeURIPrefix(fhirCode.getSystem()),
		// fhirCode.getCode(), fhirCode.getDisplay()));

		final org.ehealth_connector.cda.Problem problemEntry = getProblemEntry(fhirCondition);

		final org.ehealth_connector.cda.enums.ProblemConcernStatusCode problemStatusCode = getProblemConcernStatusCode(
				fhirCondition);

		// Create the PastProblemConcern
		retVal = new PastProblemConcern(concern, problemEntry, problemStatusCode);

		// // Add Identifiers
		// for (IdentifierDt id : fhirCondition.getIdentifier()) {
		// String codeSystem = FhirCommon.removeURIPrefix(id.getSystem());
		// retVal.addId(new Identificator(codeSystem, id.getValue()));
		// }
		//
		return retVal;

	}

	private org.ehealth_connector.cda.enums.ProblemConcernStatusCode getProblemConcernStatusCode(
			Condition condition)

	{
		org.ehealth_connector.cda.enums.ProblemConcernStatusCode retVal = ProblemConcernStatusCode.COMPLETED;
		final ConditionClinicalStatusCodesEnum status = condition.getClinicalStatusElement()
				.getValueAsEnum();
		if (status == ConditionClinicalStatusCodesEnum.RESOLVED) {
			retVal = ProblemConcernStatusCode.COMPLETED;
		} else if (status == ConditionClinicalStatusCodesEnum.ACTIVE) {
			retVal = ProblemConcernStatusCode.ACTIVE;
		}
		return retVal;
	}

	private org.ehealth_connector.cda.Problem getProblemEntry(Condition fhirCondition) {

		final org.ehealth_connector.cda.Problem retVal = new org.ehealth_connector.cda.Problem();
		final CodingDt fhirCode = fhirCondition.getCode().getCodingFirstRep();

		// Add Problem Entry Identifiers
		for (final IdentifierDt id : fhirCondition.getIdentifier()) {
			final String codeSystem = FhirCommon.removeURIPrefix(id.getSystem());
			retVal.setId(new Identificator(codeSystem, id.getValue()));
		}

		// currently only Problems supported
		retVal.setCode(ProblemType.PROBLEM);

		// Date
		retVal.setStartDate(fhirCondition.getDateRecorded());

		// Value
		retVal.addValue(new Code(FhirCommon.removeURIPrefix(fhirCode.getSystem()),
				fhirCode.getCode(), fhirCode.getDisplay()));

		return retVal;
	}

}
