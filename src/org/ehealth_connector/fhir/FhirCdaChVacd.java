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
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.ActiveProblemConcern;
import org.ehealth_connector.cda.AllergyConcern;
import org.ehealth_connector.cda.CdaChVacd;
import org.ehealth_connector.cda.CodedResults;
import org.ehealth_connector.cda.GestationalAge;
import org.ehealth_connector.cda.Immunization;
import org.ehealth_connector.cda.ImmunizationRecommendation;
import org.ehealth_connector.cda.LaboratoryObservation;
import org.ehealth_connector.cda.PastProblemConcern;
import org.ehealth_connector.cda.PregnancyHistory;
import org.ehealth_connector.cda.Reason;
import org.ehealth_connector.cda.ch.enums.AllergiesAndIntolerances;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.ehealth_connector.cda.ch.enums.MedicationsSpecialConditions;
import org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode;
import org.ehealth_connector.cda.ch.enums.ProblemType;
import org.ehealth_connector.cda.enums.AddressUse;
import org.ehealth_connector.cda.enums.AdministrativeGender;
import org.ehealth_connector.cda.enums.Confidentiality;
import org.ehealth_connector.cda.enums.Ucum;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.CodeSystems;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
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
import ca.uhn.fhir.model.dstu2.resource.Observation.Related;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Person;
import ca.uhn.fhir.model.dstu2.valueset.AddressUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.AdministrativeGenderEnum;
import ca.uhn.fhir.model.dstu2.valueset.ConditionClinicalStatusCodesEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointUseEnum;
import ca.uhn.fhir.model.primitive.DateTimeDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.util.ElementUtil;

/**
 * FhirCdaChVacd supports the creation of a CDA-CH-CH document from a HL7 FHIR
 * Resource. The content of these resources is not currently documented and they
 * are derived resources from FHIR. These resources may be created by the class
 * org.ehealth_connector.demo.fhir.VACDResources. This is currently the one any
 * only way to create valid FHIR document resources for CDA-CH-VACD. You may
 * edit these FHIR resources in a text editor in order to change the payload of
 * the resulting CdaChVacd object on your own risk.
 * 
 * @see "https://www.hl7.org/fhir/"
 */
public class FhirCdaChVacd {

	/**
	 * <div class="en">Type of the bundle to define wheter the resulting CDA
	 * document contains full or masked patient demographics</div> <div
	 * class="de"></div><div class="fr"></div>.
	 */
	public static enum DocTypeCode {

		/**
		 * <div class="en">the resulting CDA document contains full patient
		 * demographics</div><div class="de"></div><div class="fr"></div>.
		 */
		PATIENT, /**
		 * <div class="en">the resulting CDA document contains masked
		 * patient demographics</div><div class="de"></div> <div
		 * class="fr"></div>.
		 */
		PSEUDONYMIZED
	}

	/**
	 * <div class="en">MyMedicationStatement extends from the FHIR HAPI
	 * MedicationStatement Resource and provides extension attributes in order
	 * to fulfill the needs for HL7 CDA-CH-CDA creation.
	 * 
	 * @see "http://jamesagnew.github.io/hapi-fhir/index.html"
	 * @formatter:off
	 * @formatter:on</div><div class="de"></div><div class="fr"></div>
	 */
	/**
	 * <div class="en"></div><div class="de"></div><div class="fr"></div>
	 */
	@ResourceDef(name = "MedicationStatement")
	public static class MyMedicationStatement extends MedicationStatement {

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = -2062272744006946538L;

		/**
		 * <div class="en">Person who documented the medication statement</div>
		 * <div class="de"></div><div class="fr"></div>.
		 */
		@Child(name = "author")
		@Extension(url = urnUseAsAuthor, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Person who documented the medication statement")
		private ResourceReferenceDt author;

		/**
		 * <div class="en">Code of the medication administration</div> <div
		 * class="de"></div><div class="fr"></div>.
		 */
		@Child(name = "code")
		@Extension(url = urnUseAsCode, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Code of the medication administration")
		private CodingDt code;

		/**
		 * <div class="en">Remark for this medication statement</div> <div
		 * class="de"></div><div class="fr"></div>.
		 */
		@Child(name = "comment")
		@Extension(url = urnUseAsComment, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Remark for this medication statement")
		private StringDt comment;

		/**
		 * <div class="en">LotNumber for this medication statement</div> <div
		 * class="de"></div><div class="fr"></div>.
		 */
		@Child(name = "lot")
		@Extension(url = urnUseAsLotNumbertext, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "LotNumber for this medication statement")
		private StringDt lot;

		/**
		 * <div class="en">Person who performed the medication
		 * administration</div><div class="de"></div><div class="fr"></div>.
		 */
		@Child(name = "performer")
		@Extension(url = urnUseAsPerformer, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Person who performed the medication administration")
		private ResourceReferenceDt performer;

		/**
		 * <div class="en">List of reasons for this medication statement</div>
		 * <div class="de"></div><div class="fr"></div>.
		 */
		@Child(name = "reasons")
		@Extension(url = urnUseAsReason, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "List of reasons for this medication statement")
		private ResourceReferenceDt reasons;

		/**
		 * <div class="en">Empty constructor (default)</div> <div
		 * class="de"></div><div class="fr"></div>.
		 */
		public MyMedicationStatement() {
			super();
		}

		/**
		 * Gets the author.
		 * 
		 * @return <div class="en">author of this MedicationStatement</div> <div
		 *         class="de">Autor dieses MedicationStatements</div> <div
		 *         class="fr">auteur de ce MedicationStatement</div>
		 */
		public ResourceReferenceDt getAuthor() {
			if (this.author == null) {
				this.author = new ResourceReferenceDt();
			}
			return author;
		}

		/**
		 * Gets the code.
		 * 
		 * @return <div class="en">code of this MedicationStatement</div> <div
		 *         class="de">Code für dieses MedicationStatement</div> <div
		 *         class="fr">code de ce MedicationStatement</div>
		 */
		public CodingDt getCode() {
			return code;
		}

		/**
		 * Gets the comment.
		 * 
		 * @return <div class="en">comment for this medication</div> <div
		 *         class="de">Kommentar zu diesem Medikament</div> <div
		 *         class="fr">commentaire tu médicament</div>
		 */
		public StringDt getComment() {
			if (this.comment == null) {
				this.comment = new StringDt();
			}
			return comment;
		}

		/**
		 * Gets the lot.
		 * 
		 * @return <div class="en">lot number of this medication</div> <div
		 *         class="de">Lotnummer des Medikaments</div> <div
		 *         class="fr">numero lot du médicament</div>
		 */
		public StringDt getLot() {
			if (this.lot == null) {
				this.lot = new StringDt();
			}
			return lot;
		}

		/**
		 * Gets the performer.
		 * 
		 * @return <div class="en">performer of the medication
		 *         administration</div><div class="de">Person, welche das
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
		 * Gets the reasons.
		 * 
		 * @return <div class="en">reason for this medication</div> <div
		 *         class="de">Begründung für dieses Medikament</div> <div
		 *         class="fr">Justification de ce médicament</div>
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
		 * @return true, if is empty
		 * @see "ca.uhn.fhir.model.dstu2.resource.MedicationStatement#isEmpty()"
		 */
		@Override
		public boolean isEmpty() {
			return super.isEmpty()
					&& ElementUtil.isEmpty(code, performer, author, reasons, comment);
		}

		/**
		 * Sets the author.
		 * 
		 * @param author
		 *            <div class="en">author of this MedicationStatement</div>
		 *            <div class="de">Autor dieses MedicationStatements</div>
		 *            <div class="fr">auteur de ce MedicationStatement</div>
		 */
		public void setAuthor(ResourceReferenceDt author) {
			this.author = author;
		}

		/**
		 * Sets the code.
		 * 
		 * @param code
		 *            <div class="en">code of this MedicationStatement</div>
		 *            <div class="de">Code für dieses MedicationStatement</div>
		 *            <div class="fr">code de ce MedicationStatement</div>
		 */
		public void setCode(CodingDt code) {
			this.code = code;
		}

		/**
		 * Sets the comment.
		 * 
		 * @param comment
		 *            <div class="en">comment for this medication</div> <div
		 *            class="de">Kommentar zu diesem Medikament</div> <div
		 *            class="fr">commentaire tu médicament</div>
		 */
		public void setComment(StringDt comment) {
			this.comment = comment;
		}

		/**
		 * Sets the lot.
		 * 
		 * @param lot
		 *            <div class="en">lot number of this medication</div> <div
		 *            class="de">Lotnummer des Medikaments</div> <div
		 *            class="fr">numero lot du médicament</div>
		 */
		public void setLot(StringDt lot) {
			this.lot = lot;
		}

		/**
		 * Sets the performer.
		 * 
		 * @param performer
		 *            <div class="en">performer of the medication
		 *            administration</div><div class="de">Person, welche das
		 *            Medikament verabreicht hat</div><div class="fr">personne
		 *            qui a effectué l'administration du médicament</div>
		 */
		public void setPerformer(ResourceReferenceDt performer) {
			this.performer = performer;
		}

		/**
		 * Sets the reasons.
		 * 
		 * @param reasons
		 *            <div class="en">reason for this medication</div> <div
		 *            class="de">Begründung für dieses Medikament</div> <div
		 *            class="fr">Justification de ce médicament</div>
		 */
		public void setReasons(ResourceReferenceDt reasons) {
			this.reasons = reasons;
		}

	}

	/**
	 * The Class VacdDocument.
	 */
	@ResourceDef(name = "VacdDocument")
	public static class VacdDocument extends Basic {

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = -1316775746486313864L;

		/** The active problem concern entries. */
		@Child(name = "activeProblemConcernEntries", max = Child.MAX_UNLIMITED)
		@Extension(url = urnUseAsActiveProblemConcernEntries, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "activeProblemConcernEntries")
		private List<ResourceReferenceDt> activeProblemConcernEntries; // Condition

		/** The allergy problem concern entries. */
		@Child(name = "allergyProblemConcernEntries", max = Child.MAX_UNLIMITED)
		@Extension(url = urnUseAsAllergyProblemConcernEntries, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "allergyProblemConcernEntries")
		private List<ResourceReferenceDt> allergyProblemConcernEntries; // Condition

		/** The coded result observations. */
		@Child(name = "codedResultObservations", max = Child.MAX_UNLIMITED)
		@Extension(url = urnUseAsCodedResultObservations, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "codedResultObservations")
		private List<ResourceReferenceDt> codedResultObservations; // codedResults

		/** The comment. */
		@Child(name = "comment")
		@Extension(url = urnUseAsComment, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "comment")
		private ResourceReferenceDt comment;

		/** The confidentiality. */
		@Child(name = "confidentiality")
		@Extension(url = urnUseAsConfidentiality, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "confidentiality")
		private ResourceReferenceDt confidentiality;

		/** The custodian. */
		@Child(name = "custodian")
		@Extension(url = urnUseAsCustodian, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "custodian")
		private ResourceReferenceDt custodian;

		/** The doc author. */
		@Child(name = "docAuthor")
		@Extension(url = urnUseAsAuthor, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "author")
		private ResourceReferenceDt docAuthor;

		/** The doc language. */
		@Child(name = "docLanguage")
		@Extension(url = urnUseAsLanguage, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "docLanguage")
		private ResourceReferenceDt docLanguage;

		/** The doc type. */
		@Child(name = "docType")
		@Extension(url = urnUseAsDocType, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "docType")
		private ResourceReferenceDt docType;

		/** The immunization recommendations. */
		@Child(name = "immunizationRecommendations", max = Child.MAX_UNLIMITED)
		@Extension(url = urnUseAsImmunizationRecommendation, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "immunizationRecommendations")
		private List<ResourceReferenceDt> immunizationRecommendations;

		/** The immunizations. */
		@Child(name = "immunizations", max = Child.MAX_UNLIMITED)
		@Extension(url = urnUseAsImmunization, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "immunizations")
		private List<ResourceReferenceDt> immunizations;

		/** The laboratory observations. */
		@Child(name = "laboratoryObservations", max = Child.MAX_UNLIMITED)
		@Extension(url = urnUseAsLaboratoryObservations, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "laboratoryObservations")
		private List<ResourceReferenceDt> laboratoryObservations; // Observations

		/** The legal authenticator. */
		@Child(name = "legalAuthenticator")
		@Extension(url = urnUseAsLegalAuthenticator, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "legalAuthenticator")
		private ResourceReferenceDt legalAuthenticator;

		/** The past problem concern entries. */
		@Child(name = "pastProblemConcernEntries", max = Child.MAX_UNLIMITED)
		@Extension(url = urnUseAsPastProblemConcernEntries, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "pastProblemConcernEntries")
		private List<ResourceReferenceDt> pastProblemConcernEntries; // Condition

		/** The patient. */
		@Child(name = "patient")
		@Extension(url = urnUseAsPatient, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "patient")
		private ResourceReferenceDt patient;

		/** The pregnancy observation. */
		@Child(name = "pregnancyObservation,", max = Child.MAX_UNLIMITED)
		@Extension(url = urnUseAsPregnancyObservation, definedLocally = false, isModifier = true)
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
			resourceRef.setResource(pastProblemConcernEntry);
			this.pastProblemConcernEntries.add(resourceRef);
		}

		/**
		 * Gets the active problem concern entries.
		 * 
		 * @return the active problem concern entries
		 */
		public List<Condition> getActiveProblemConcernEntries() {
			ArrayList<Condition> list = new ArrayList<Condition>();
			if (this.activeProblemConcernEntries != null) {
				for (ResourceReferenceDt resource : this.activeProblemConcernEntries) {
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
			ArrayList<Condition> list = new ArrayList<Condition>();
			if (this.allergyProblemConcernEntries != null) {
				for (ResourceReferenceDt resource : allergyProblemConcernEntries) {
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
			ArrayList<Observation> list = new ArrayList<Observation>();
			if (this.codedResultObservations != null) {
				for (ResourceReferenceDt resource : codedResultObservations) {
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
		 * Gets the confidentiality.
		 * 
		 * @return the confidentiality
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
			ArrayList<MedicationStatement> list = new ArrayList<MedicationStatement>();
			if (this.immunizationRecommendations != null) {
				for (ResourceReferenceDt resource : immunizationRecommendations) {
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
			ArrayList<MedicationStatement> list = new ArrayList<MedicationStatement>();
			if (this.immunizations != null) {
				for (ResourceReferenceDt resource : immunizations) {
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
			ArrayList<Observation> list = new ArrayList<Observation>();
			if (this.laboratoryObservations != null) {
				for (ResourceReferenceDt resource : laboratoryObservations) {
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
			ArrayList<Condition> list = new ArrayList<Condition>();
			if (this.pastProblemConcernEntries != null) {
				for (ResourceReferenceDt resource : pastProblemConcernEntries) {
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
			resourceRef.setResource(comment);
			this.comment = resourceRef;
		}

		/**
		 * Sets the confidentiality.
		 * 
		 * @param confidentiality
		 *            the new confidentiality
		 */
		public void setConfidentiality(Basic confidentiality) {
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
			resourceRef.setResource(pregnancyObservation);
			this.pregnancyObservation = resourceRef;
		}

	};

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div> <div
	 * class="de"></div><div class="fr"></div>.
	 */
	public static final String oidConfidentialityCode = "urn:oid:"
			+ CodeSystems.ConfidentialityCode.getCodeSystemId();

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div> <div
	 * class="de"></div><div class="fr"></div>.
	 */
	public static final String oidLanguage = "urn:oid:"
			+ CodeSystems.LanguageCode.getCodeSystemId();

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div> <div
	 * class="de"></div><div class="fr"></div>.
	 */
	public static final String oidVACD = "urn:oid:" + CdaChVacd.OID_MAIN;

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsActiveProblemConcern = "urn:ehealth_connector:FhirExtension:useAsActiveProblemConcern";

	/** The Constant urnUseAsActiveProblemConcernEntries. */
	public static final String urnUseAsActiveProblemConcernEntries = "urn:ehealth_connector:FhirExtension:uAsActiveProblemConcernEntries";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsAllergyProblemConcern = "urn:ehealth_connector:FhirExtension:useAsAllergyProblemConcern";

	/** The Constant urnUseAsAllergyProblemConcernEntries. */
	public static final String urnUseAsAllergyProblemConcernEntries = "urn:ehealth_connector:FhirExtension:useAsAllergyProblemConcernEntries";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsAuthor = "urn:ehealth_connector:FhirExtension:useAsAuthor";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCode = "urn:ehealth_connector:FhirExtension:urnUseAsCode";

	/** The Constant urnUseAsCodedResultObservations. */
	public static final String urnUseAsCodedResultObservations = "urn:ehealth_connector:FhirExtension:useAsCodedResultObservations";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsComment = "urn:ehealth_connector:FhirExtension:useAsComment";

	/** The Constant urnUseAsConfidentiality. */
	public static final String urnUseAsConfidentiality = "urn:ehealth_connector:FhirExtension:useAsConfidentiality";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsCustodian = "urn:ehealth_connector:FhirExtension:useAsCustodian";

	/** The Constant urnUseAsDocType. */
	public static final String urnUseAsDocType = "urn:ehealth_connector:FhirExtension:useAsDocType";

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
	public static final String urnUseAsLaboratoryObservation = "urn:ehealth_connector:FhirExtension:useAsLaboratoryObservation";

	/** The Constant urnUseAsLaboratoryObservations. */
	public static final String urnUseAsLaboratoryObservations = "urn:ehealth_connector:FhirExtension:useAsLaboratoryObservations";

	/** The Constant urnUseAsLanguage. */
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
	public static final String urnUseAsLotNumbertext = "urn:ehealth_connector:FhirExtension:urnUseAsLotNumbertext";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsPastProblemConcern = "urn:ehealth_connector:FhirExtension:useAsPastProblemConcern";

	/** The Constant urnUseAsPastProblemConcernEntries. */
	public static final String urnUseAsPastProblemConcernEntries = "urn:ehealth_connector:FhirExtension:useAsPastProblemConcernEntries";

	/** The Constant urnUseAsPatient. */
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
	public static final String urnUseAsPregnancyObservation = "urn:ehealth_connector:FhirExtension:urnUseAsPregnancyObservation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR extension</div>
	 * <div class="de"></div><div class="fr"></div>.
	 */
	public static final String urnUseAsReason = "urn:ehealth_connector:FhirExtension:useAsReason";

	/** The m fhir ctx. */
	private final FhirContext mFhirCtx = new FhirContext();

	/**
	 * <div class="en">Empty constructor (default)</div><div class="de"></div>
	 * <div class="fr"></div>.
	 */
	public FhirCdaChVacd() {
	}

	/**
	 * Creates the cda ch vacd from fhir bundle.
	 * 
	 * @param fhirDoc
	 *            the fhir doc
	 * @param xsl
	 *            the xsl
	 * @param css
	 *            the css
	 * @return the org.ehealth_connector.cda. cda ch vacd
	 */
	public org.ehealth_connector.cda.CdaChVacd createCdaChVacdFromFHIRBundle(VacdDocument fhirDoc,
			String xsl, String css) {

		// Heade
		CdaChVacd doc = new CdaChVacd(getDocLanguage(fhirDoc.getDocLanguage()), xsl, css);

		DocTypeCode docType = getDocType(fhirDoc.getDocType());
		doc.setConfidentialityCode(getConfidentialityCode(fhirDoc.getDocType()));
		doc.setPatient(getPatient(fhirDoc.getPatient()));
		if (docType == DocTypeCode.PSEUDONYMIZED)
			doc.pseudonymization();

		Author author = this.getAuthor(fhirDoc.getDocAuthor());
		author.setTime(DateUtil.date("15.12.2014"));
		doc.addAuthor(author);

		doc.setCustodian(getOrganization(fhirDoc.getCustodian()));
		doc.setLegalAuthenticator(getAuthor(fhirDoc.getLegalAuthenticator()));

		// Body
		// Immunizations / Impfungen
		for (Immunization immunization : getImmunizations(fhirDoc.getImmunizations())) {
			doc.addImmunization(immunization);
		}

		for (ActiveProblemConcern activeProblemConcernEntry : getActiveProblemConcernEntries(fhirDoc
				.getActiveProblemConcernEntries())) {
			doc.addActiveProblemConcern(activeProblemConcernEntry);
		}

		// History of Past Illness / Bisherige Krankheiten/Anamnese
		for (PastProblemConcern pastProblemConcern : getPastProblemConcernEntries(fhirDoc
				.getPastProblemConcernEntries())) {
			doc.addPastProblemConcern(pastProblemConcern);
		}

		// Allergies and Basic Adverse Reactions / Allergien und
		// Unverträglichkeiten
		for (AllergyConcern allergyProblemConcern : getAllergyProblemConcernEntries(fhirDoc
				.getAllergyProblemConcernEntries())) {
			doc.addAllergyConcern(allergyProblemConcern);
		}

		// Coded Results for gestational age / Codierte Resultate für
		// Gestationsalter
		CodedResults cr = getGestationalAge(fhirDoc.getCodedResultObservations());
		if (cr != null) {
			doc.addCodedResults(cr);
		}

		// Laboratory Specialty Section / Relevante Laborbefunde
		for (LaboratoryObservation laboratoryObservation : getLaboratoryObservations(fhirDoc
				.getLaboratoryObservations())) {
			doc.addLaboratoryObservation(laboratoryObservation);
		}

		// Schwangerschaftsanamnese
		// Coded Results for gestational age / Codierte Resultate für
		// Gestationsalter
		PregnancyHistory ph = getPregnancyHistory(fhirDoc.getPregnancyObeservation());
		if (ph != null) {
			doc.addPregnancyHistory(ph);
		}

		for (ImmunizationRecommendation immunizationRecommendation : getImmunizationRecommendations(fhirDoc
				.getImmunizationRecommendations())) {
			doc.addImmunizationRecommendation(immunizationRecommendation, true);
		}

		doc.addComment(getComment(fhirDoc.getComment()));

		return doc;
	}

	/**
	 * Gets the active problem concern entries.
	 * 
	 * @param activeProblemConcerns
	 *            the active problem concerns
	 * @return the active problem concern entries
	 */
	public ArrayList<org.ehealth_connector.cda.ActiveProblemConcern> getActiveProblemConcernEntries(
			List<Condition> activeProblemConcerns) {
		ArrayList<org.ehealth_connector.cda.ActiveProblemConcern> retVal = new ArrayList<org.ehealth_connector.cda.ActiveProblemConcern>();

		if (activeProblemConcerns != null) {
			for (Condition entry : activeProblemConcerns) {
				retVal.add(getActiveProblemConcern(entry));
			}
		}
		return retVal;
	}

	/**
	 * Gets the allergy problem concern entries.
	 * 
	 * @param allergyProblemConcerns
	 *            the allergy problem concerns
	 * @return the allergy problem concern entries
	 */
	public ArrayList<org.ehealth_connector.cda.AllergyConcern> getAllergyProblemConcernEntries(
			List<Condition> allergyProblemConcerns) {
		ArrayList<org.ehealth_connector.cda.AllergyConcern> retVal = new ArrayList<org.ehealth_connector.cda.AllergyConcern>();
		if (allergyProblemConcerns != null) {
			for (Condition entry : allergyProblemConcerns) {
				retVal.add(getAllergyProblemConcern(entry));
			}
		}
		return retVal;
	}

	/**
	 * Gets the author.
	 * 
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Author</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	public org.ehealth_connector.common.Author getAuthor(MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.common.Author retVal = null;
		if (!fhirMedicationStatement.getUndeclaredExtensionsByUrl(urnUseAsAuthor).isEmpty()) {
			ResourceReferenceDt refAuthor = (ResourceReferenceDt) fhirMedicationStatement
					.getUndeclaredExtensionsByUrl(urnUseAsAuthor).get(0).getValue();
			retVal = getAuthor((Person) refAuthor.getResource());
		}
		return retVal;
	}

	/**
	 * Gets the comment.
	 * 
	 * @param comment
	 *            the comment
	 * @return the comment
	 */
	public String getComment(Observation comment) {
		if (comment != null) {
			return comment.getComments();
		}
		return "";
	}

	/**
	 * Gets the confidentiality code.
	 * 
	 * @param fhirBasic
	 *            the fhir basic
	 * @return the confidentiality code
	 */
	public Confidentiality getConfidentialityCode(Basic fhirBasic) {
		Confidentiality retVal = Confidentiality.NORMAL; // default
		if (fhirBasic != null) {
			CodingDt langCode = fhirBasic.getCode().getCodingFirstRep();
			if (langCode.getSystem().equals(oidConfidentialityCode)) {
				if (langCode.getCode().toLowerCase().equals("veryrestricted")) {
					retVal = Confidentiality.VERY_RESTRICTED;
				} else if (langCode.getCode().toLowerCase().equals("restricted")) {
					retVal = Confidentiality.RESTRICED;
				} else if (langCode.getCode().toLowerCase().equals("normal")) {
					retVal = Confidentiality.NORMAL;
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets the custodian.
	 * 
	 * @param bundle
	 *            the bundle
	 * @return the custodian
	 */
	public org.ehealth_connector.common.Organization getCustodian(Bundle bundle) {
		org.ehealth_connector.common.Organization retVal = null;
		for (Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(urnUseAsCustodian).isEmpty()
					&& (entry.getResource() instanceof Organization)) {
				retVal = getOrganization((Organization) entry.getResource());
			}
		}
		return retVal;
	}

	/**
	 * Gets the doc language.
	 * 
	 * @param fhirBasic
	 *            the fhir basic
	 * @return <div class="en">eHC LanguageCode</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public LanguageCode getDocLanguage(Basic fhirBasic) {
		LanguageCode retVal = LanguageCode.GERMAN; // default
		if (fhirBasic != null) {
			CodingDt langCode = fhirBasic.getCode().getCodingFirstRep();
			if (langCode.getSystem().equals(oidLanguage)) {
				if (langCode.getCode().toLowerCase().startsWith("de")) {
					retVal = LanguageCode.GERMAN;
				} else if (langCode.getCode().toLowerCase().startsWith("fr")) {
					retVal = LanguageCode.FRENCH;
				} else if (langCode.getCode().toLowerCase().startsWith("it")) {
					retVal = LanguageCode.ITALIAN;
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets the doc type.
	 * 
	 * @param fhirBasic
	 *            the fhir basic
	 * @return <div class="en">DocTypeCode (full or masked patient
	 *         demographics)</div> <div class="de"></div> <div class="fr"></div>
	 */
	public DocTypeCode getDocType(Basic fhirBasic) {
		DocTypeCode retVal = DocTypeCode.PATIENT; // default
		if (fhirBasic != null) {
			CodingDt langCode = fhirBasic.getCode().getCodingFirstRep();
			if (langCode.getSystem().equals(oidVACD)) {
				if (langCode.getCode().toLowerCase().equals("patient")) {
					retVal = DocTypeCode.PATIENT;
				} else if (langCode.getCode().toLowerCase().equals("pseudonymized")) {
					retVal = DocTypeCode.PSEUDONYMIZED;
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets the gestational age.
	 * 
	 * @param observations
	 *            the observations
	 * @return <div class="en">eHC CodedResults</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public org.ehealth_connector.cda.CodedResults getGestationalAge(List<Observation> observations) {
		CodedResults retVal = null;
		BigInteger gWeek = BigInteger.valueOf(-1);
		BigInteger gDay = BigInteger.valueOf(-1);
		for (Observation entry : observations) {
			if (entry.getCode() != null) {
				CodingDt fhirCode = entry.getCode().getCodingFirstRep();
				if (fhirCode.getCode().equals("49051-6")) {
					gWeek = ((QuantityDt) entry.getValue()).getValue().toBigInteger();
				}
				if (fhirCode.getCode().equals("49052-4")) {
					gDay = ((QuantityDt) entry.getValue()).getValue().toBigInteger();
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
	 * Gets the immunization recommendations.
	 * 
	 * @param list
	 *            the list
	 * @return <div class="en">list of eHC ImmunizationRecommendations</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public ArrayList<org.ehealth_connector.cda.ImmunizationRecommendation> getImmunizationRecommendations(
			List<MedicationStatement> list) {
		ArrayList<org.ehealth_connector.cda.ImmunizationRecommendation> retVal = new ArrayList<org.ehealth_connector.cda.ImmunizationRecommendation>();
		for (MedicationStatement entry : list) {
			retVal.add(getImmunizationRecommendation(entry));
		}
		return retVal;
	}

	/**
	 * Gets the immunizations.
	 * 
	 * @param list
	 *            the list
	 * @return <div class="en">list of eHC Immunizations</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	public ArrayList<org.ehealth_connector.cda.Immunization> getImmunizations(
			List<MedicationStatement> list) {
		ArrayList<org.ehealth_connector.cda.Immunization> retVal = new ArrayList<org.ehealth_connector.cda.Immunization>();
		for (MedicationStatement entry : list) {
			retVal.add(getImmunization(entry));
		}
		return retVal;
	}

	/**
	 * Gets the laboratory observations.
	 * 
	 * @param labObservations
	 *            the lab observations
	 * @return <div class="en">list of eHC LaboratoryObservations</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	public ArrayList<org.ehealth_connector.cda.LaboratoryObservation> getLaboratoryObservations(
			List<Observation> labObservations) {
		ArrayList<org.ehealth_connector.cda.LaboratoryObservation> retVal = new ArrayList<org.ehealth_connector.cda.LaboratoryObservation>();
		if (labObservations != null) {
			for (Observation entry : labObservations) {
				retVal.add(getLaboratoryObservation(entry));
			}
		}
		return retVal;
	}

	/**
	 * Gets the legal authenticator.
	 * 
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Author</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	public org.ehealth_connector.common.Author getLegalAuthenticator(Bundle bundle) {
		org.ehealth_connector.common.Author retVal = null;
		for (Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(urnUseAsLegalAuthenticator).isEmpty()
					&& (entry.getResource() instanceof Person)) {
				retVal = getAuthor((Person) entry.getResource());
			}
		}
		return retVal;
	}

	/**
	 * Gets the organization.
	 * 
	 * @param fhirOrganization
	 *            <div class="en">FHIR Organization resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Organization</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public org.ehealth_connector.common.Organization getOrganization(Organization fhirOrganization) {
		org.ehealth_connector.common.Organization retVal = null;
		// Create the organization
		retVal = new org.ehealth_connector.common.Organization(fhirOrganization.getName());

		// Add Identifiers
		for (IdentifierDt id : fhirOrganization.getIdentifier()) {
			String codeSystem = removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (AddressDt addr : fhirOrganization.getAddress()) {
			AddressUse usage = AddressUse.BUSINESS;
			if (addr.getUseElement().getValueAsEnum() == AddressUseEnum.HOME) {
				usage = AddressUse.PRIVATE;
			}
			Address eHCAddr = new Address(addr.getLineFirstRep().toString(), addr.getPostalCode(),
					addr.getCity(), usage);
			eHCAddr.setCountry(addr.getCountry());
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(getTelecoms(fhirOrganization.getTelecom()));

		return retVal;
	}

	/**
	 * Gets the organization.
	 * 
	 * @param orgRef
	 *            <div class="en">FHIR ResourceReferenceDt resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Organization</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public org.ehealth_connector.common.Organization getOrganization(ResourceReferenceDt orgRef) {
		org.ehealth_connector.common.Organization retVal = null;
		if (orgRef.getResource() instanceof Organization) {
			retVal = getOrganization((Organization) orgRef.getResource());
		}
		return retVal;
	}

	/**
	 * Gets the past problem concern entries.
	 * 
	 * @param problemConcernEntries
	 *            the problem concern entries
	 * @return <div class="en">list of eHC PastProblemConcerns</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	public ArrayList<org.ehealth_connector.cda.PastProblemConcern> getPastProblemConcernEntries(
			List<Condition> problemConcernEntries) {
		ArrayList<org.ehealth_connector.cda.PastProblemConcern> retVal = new ArrayList<org.ehealth_connector.cda.PastProblemConcern>();
		if (problemConcernEntries != null) {
			for (Condition entry : problemConcernEntries) {
				retVal.add(getPastProblemConcern(entry));
			}
		}
		return retVal;
	}

	/**
	 * Gets the patient.
	 * 
	 * @param fhirPatient
	 *            the fhir patient
	 * @return <div class="en">eHC Patient</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 * 
	 *         FIXME refactor, should be already in common.
	 */
	public org.ehealth_connector.common.Patient getPatient(Patient fhirPatient) {
		org.ehealth_connector.common.Patient retVal = null;
		Name patientName = new Name(fhirPatient.getNameFirstRep().getGivenAsSingleString(),
				fhirPatient.getNameFirstRep().getFamilyAsSingleString());
		AdministrativeGender gender = AdministrativeGender.UNDIFFERENTIATED;
		if (fhirPatient.getGenderElement().getValueAsEnum() == AdministrativeGenderEnum.FEMALE) {
			gender = AdministrativeGender.FEMALE;
		} else if (fhirPatient.getGenderElement().getValueAsEnum() == AdministrativeGenderEnum.MALE) {
			gender = AdministrativeGender.MALE;
		}

		// Create eHC Patient
		retVal = new org.ehealth_connector.common.Patient(patientName, gender,
				fhirPatient.getBirthDate());

		// Add Identifiers
		for (IdentifierDt id : fhirPatient.getIdentifier()) {
			String codeSystem = removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (AddressDt addr : fhirPatient.getAddress()) {
			AddressUse usage = AddressUse.BUSINESS;
			if (addr.getUseElement().getValueAsEnum() == AddressUseEnum.HOME) {
				usage = AddressUse.PRIVATE;
			}
			Address eHCAddr = new Address(addr.getLineFirstRep().toString(), addr.getPostalCode(),
					addr.getCity(), usage);
			eHCAddr.setCountry(addr.getCountry());
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(getTelecoms(fhirPatient.getTelecom()));
		return retVal;
	}

	/**
	 * Gets the performer.
	 * 
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Author</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	public org.ehealth_connector.common.Author getPerformer(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.common.Author retVal = null;
		if (!fhirMedicationStatement.getUndeclaredExtensionsByUrl(urnUseAsPerformer).isEmpty()) {
			ResourceReferenceDt refAuthor = (ResourceReferenceDt) fhirMedicationStatement
					.getUndeclaredExtensionsByUrl(urnUseAsPerformer).get(0).getValue();
			retVal = getAuthor((Person) refAuthor.getResource());
		}
		return retVal;
	}

	/**
	 * Gets the pregnancy history.
	 * 
	 * @param pregnancyObservation
	 *            the pregnancy observation
	 * @return <div class="en">eHC CodedResults</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public org.ehealth_connector.cda.PregnancyHistory getPregnancyHistory(
			Observation pregnancyObservation) {
		PregnancyHistory retVal = null;
		Date deliveryDate = null;
		if (pregnancyObservation != null && pregnancyObservation.getCode() != null) {
			CodingDt fhirCode = pregnancyObservation.getCode().getCodingFirstRep();
			if (fhirCode != null && fhirCode.getCode() != null
					&& fhirCode.getCode().equals("11778-8")) {
				deliveryDate = ((DateTimeDt) pregnancyObservation.getValue()).getValue();
			}

			if (deliveryDate != null) {
				retVal = new PregnancyHistory(deliveryDate);
				// not yet implemented:
				// retVal.setPerformer(perfomer);
			}
		}
		return retVal;
	}

	/**
	 * Gets the reasons.
	 * 
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">list of FHIR ListResource resources</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	public ListResource getReasons(MedicationStatement fhirMedicationStatement) {
		ListResource retVal = null;
		for (ExtensionDt ext : fhirMedicationStatement.getUndeclaredExtensionsByUrl(urnUseAsReason)) {
			retVal = (ListResource) ((ResourceReferenceDt) ext.getValue()).getResource();
		}
		if (retVal == null)
			retVal = new ListResource();
		return retVal;
	}

	/**
	 * <div class="en">reads the given XML file into a FHIR bundle
	 * resource</div> <div class="de"></div> <div class="fr"></div>.
	 * 
	 * @param fileName
	 *            <div class="en">file to read</div> <div class="de"></div> <div
	 *            class="fr"></div>
	 * @return <div class="en">FHIR Bundle resource containing the XML file
	 *         content</div> <div class="de"></div> <div class="fr"></div>
	 */
	public Bundle readBundleFromFile(String fileName) {
		String resourceString = getXmlResource(fileName);
		IParser parser = mFhirCtx.newXmlParser();
		Bundle fhirBundle = parser.parseResource(Bundle.class, resourceString);
		return fhirBundle;
	}

	/**
	 * Read vac document from file.
	 * 
	 * @param fileName
	 *            the file name
	 * @return the vacd document
	 */
	public VacdDocument readVacDocumentFromFile(String fileName) {
		String resourceString = getXmlResource(fileName);
		IParser parser = mFhirCtx.newXmlParser();
		return parser.parseResource(VacdDocument.class, resourceString);
	}

	/**
	 * Gets the active problem concern.
	 * 
	 * @param fhirCondition
	 *            <div class="en">FHIR Condition resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC ActiveProblemConcern</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	private org.ehealth_connector.cda.ActiveProblemConcern getActiveProblemConcern(
			Condition fhirCondition) {
		org.ehealth_connector.cda.ActiveProblemConcern retVal = null;

		String concern = fhirCondition.getNotes();
		Date date = fhirCondition.getDateRecorded();

		org.ehealth_connector.cda.Problem problemEntry = getProblemEntry(fhirCondition);
		org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode problemStatusCode = getProblemConcernStatusCode(fhirCondition);

		// Create the ActiveProblemConcern
		retVal = new org.ehealth_connector.cda.ActiveProblemConcern(concern, date, problemEntry,
				problemStatusCode);

		return retVal;

	}

	/**
	 * Gets the allergy problem concern.
	 * 
	 * @param fhirCondition
	 *            <div class="en">FHIR Condition resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC AllergyConcern</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	private org.ehealth_connector.cda.AllergyConcern getAllergyProblemConcern(
			Condition fhirCondition) {
		org.ehealth_connector.cda.AllergyConcern retVal = null;

		String concern = fhirCondition.getNotes();
		org.ehealth_connector.cda.AllergyProblem problemEntry = getAllergyProblemEntry(fhirCondition);

		org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode problemStatusCode = getProblemConcernStatusCode(fhirCondition);
		// // Create the AllergyProblemConcern
		// retVal = new org.ehealth_connector.cda.AllergyConcern(concern,
		// problemEntry, problemStatusCode);
		//
		// // Date
		// retVal.setStartDate(fhirCondition.getDateAsserted());

		retVal = new org.ehealth_connector.cda.AllergyConcern(concern,
				fhirCondition.getDateRecorded(), null, problemEntry, problemStatusCode);

		return retVal;

	}

	/**
	 * Gets the allergy problem entry.
	 * 
	 * @param fhirCondition
	 *            the fhir condition
	 * @return the allergy problem entry
	 */
	private org.ehealth_connector.cda.AllergyProblem getAllergyProblemEntry(Condition fhirCondition) {

		org.ehealth_connector.cda.AllergyProblem retVal = new org.ehealth_connector.cda.AllergyProblem();
		CodingDt fhirCode = fhirCondition.getCode().getCodingFirstRep();

		// Add Problem Entry Identifiers
		for (IdentifierDt id : fhirCondition.getIdentifier()) {
			String codeSystem = removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// currently only Drug intolerances supported
		retVal.setCode(AllergiesAndIntolerances.DRUG_INTOLERANCE);

		// Date
		retVal.setStartDate(fhirCondition.getDateRecorded());

		// Value
		retVal.addValue(new Code(removeURIPrefix(fhirCode.getSystem()), fhirCode.getCode(),
				fhirCode.getDisplay()));

		return retVal;
	}

	/**
	 * Gets the author.
	 * 
	 * @param fhirPerson
	 *            <div class="en">FHIR Person resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Author</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	private org.ehealth_connector.common.Author getAuthor(Person fhirPerson) {
		org.ehealth_connector.common.Author retVal = null;
		Name personName = new Name(fhirPerson.getNameFirstRep().getGivenAsSingleString(),
				fhirPerson.getNameFirstRep().getFamilyAsSingleString());

		// Create the author
		retVal = new org.ehealth_connector.common.Author(personName);

		// Add Identifiers
		for (IdentifierDt id : fhirPerson.getIdentifier()) {
			String codeSystem = removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Add Addresses
		for (AddressDt addr : fhirPerson.getAddress()) {
			AddressUse usage = AddressUse.BUSINESS;
			if (addr.getUseElement().getValueAsEnum() == AddressUseEnum.HOME) {
				usage = AddressUse.PRIVATE;
			}
			Address eHCAddr = new Address(addr.getLineFirstRep().toString(), addr.getPostalCode(),
					addr.getCity(), usage);
			eHCAddr.setCountry(addr.getCountry());
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(getTelecoms(fhirPerson.getTelecom()));

		// Add organization
		retVal.setOrganization(getOrganization(fhirPerson.getManagingOrganization()));

		return retVal;

	}

	/**
	 * Gets the code.
	 * 
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Code</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	private Code getCode(MedicationStatement fhirMedicationStatement) {
		Code retVal = null;
		if (!fhirMedicationStatement.getUndeclaredExtensionsByUrl(urnUseAsCode).isEmpty()) {
			CodingDt fhirCode = (CodingDt) fhirMedicationStatement
					.getUndeclaredExtensionsByUrl(urnUseAsCode).get(0).getValue();
			retVal = new Code(removeURIPrefix(fhirCode.getSystem()), fhirCode.getCode(),
					fhirCode.getDisplay());
		}
		return retVal;
	}

	/**
	 * Gets the comment.
	 * 
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">the comment as string</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	private String getComment(MedicationStatement fhirMedicationStatement) {
		String retVal = "";
		if (!fhirMedicationStatement.getUndeclaredExtensionsByUrl(urnUseAsComment).isEmpty()) {
			StringDt comment = (StringDt) fhirMedicationStatement
					.getUndeclaredExtensionsByUrl(urnUseAsComment).get(0).getValue();
			retVal = comment.toString();
		}
		return retVal;
	}

	/**
	 * Gets the consumable.
	 * 
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Consumable</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	private org.ehealth_connector.cda.Consumable getConsumable(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.cda.Consumable retVal = null;

		Medication fhirMedi = (Medication) ((ResourceReferenceDt) fhirMedicationStatement
				.getMedication()).getResource();
		// Create the consumable
		retVal = new org.ehealth_connector.cda.Consumable(fhirMedi.getCode().getText());

		// Set id
		if (!fhirMedi.getUndeclaredExtensionsByUrl(urnUseAsIdentifier).isEmpty()) {
			IdentifierDt id = (IdentifierDt) fhirMedi
					.getUndeclaredExtensionsByUrl(urnUseAsIdentifier).get(0).getValue();
			retVal.setManufacturedProductId(new org.ehealth_connector.common.Identificator(
					removeURIPrefix(id.getSystem()), id.getValue()));
		}

		// Set code
		CodingDt fhirCode = fhirMedi.getCode().getCodingFirstRep();
		Code code = new Code(removeURIPrefix(fhirCode.getSystem()), fhirCode.getCode(),
				fhirCode.getDisplay());
		retVal.setWhoAtcCode(code);

		// Set manufacturer
		ResourceReferenceDt refManufacturer = fhirMedi.getManufacturer();
		retVal.setManufacturer(getOrganization((Organization) refManufacturer.getResource()));

		// LotNumber
		retVal.setLotNr(getLot(fhirMedicationStatement));

		return retVal;
	}

	/**
	 * Gets the immunization.
	 * 
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Immunization</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	private org.ehealth_connector.cda.Immunization getImmunization(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.cda.Immunization retVal = null;

		Code code = getCode(fhirMedicationStatement);

		// Create the immunization
		retVal = new org.ehealth_connector.cda.Immunization();

		// Add Identifiers
		for (IdentifierDt id : fhirMedicationStatement.getIdentifier()) {
			String codeSystem = removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// author
		retVal.setAuthor(getAuthor(fhirMedicationStatement));

		if (!code.getCode().equals("IMMUNIZ")) {
			// code
			retVal.setCode(MedicationsSpecialConditions.getEnum(code.getCode()));
		} else {
			// effectiveTime
			retVal.setApplyDate(fhirMedicationStatement.getDateAsserted());

			// doseQuantity
			Double doseQuantity = null;
			for (Dosage dosage : fhirMedicationStatement.getDosage()) {
				doseQuantity = ((QuantityDt) dosage.getQuantity()).getValue().doubleValue();
				retVal.setDosage(doseQuantity);
				break; // currently only support for one doseQuantity
			}

			// consumable
			retVal.setConsumable(getConsumable(fhirMedicationStatement));

			// perfomer
			retVal.setPerformer(getPerformer(fhirMedicationStatement));

			// reasons
			ListResource reasons = getReasons(fhirMedicationStatement);
			for (ResourceReferenceDt refObs : reasons
					.getAllPopulatedChildElementsOfType(ResourceReferenceDt.class)) {
				Observation fhirObs = (Observation) refObs.getResource();
				CodingDt fhirCode = fhirObs.getCode().getCodingFirstRep();
				Reason reason = new Reason(new Code(removeURIPrefix(fhirCode.getSystem()),
						fhirCode.getCode(), fhirCode.getDisplay()));
				// set Text not yet implemented
				// retVal.setText(fhirObs.getComments());
				retVal.addReason(reason);
			}

			// comment
			retVal.setCommentText(getComment(fhirMedicationStatement));

		}

		return retVal;

	}

	/**
	 * Gets the immunization recommendation.
	 * 
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC ImmunizationRecommendation</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	private org.ehealth_connector.cda.ImmunizationRecommendation getImmunizationRecommendation(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.cda.ImmunizationRecommendation retVal = null;

		// Create the immunization
		retVal = new org.ehealth_connector.cda.ImmunizationRecommendation();

		// Add Identifiers
		for (IdentifierDt id : fhirMedicationStatement.getIdentifier()) {
			String codeSystem = removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));

		}

		// code
		Code code = getCode(fhirMedicationStatement);
		MedicationsSpecialConditions specialConditions = MedicationsSpecialConditions.getEnum(code
				.getCode());
		if (specialConditions != null) {
			retVal.setCode(specialConditions);
		} else {
			retVal.setShallNotBeAdministerd(fhirMedicationStatement.getWasNotTaken());

			// effectiveTime
			// not yet implemented: effectiveTime highValue
			retVal.setPossibleAppliance(fhirMedicationStatement.getDateAsserted(), null);

			// doseQuantity
			Double doseQuantity = null;
			for (Dosage dosage : fhirMedicationStatement.getDosage()) {
				doseQuantity = ((QuantityDt) dosage.getQuantity()).getValue().doubleValue();
				retVal.setDosage(doseQuantity);
				break; // currently only support for one doseQuantity
			}

			// consumable
			retVal.setConsumable(getConsumable(fhirMedicationStatement));
		}
		// author
		retVal.setAuthor(getAuthor(fhirMedicationStatement));

		// reasons
		ListResource reasons = getReasons(fhirMedicationStatement);
		for (ResourceReferenceDt refReasonObs : reasons
				.getAllPopulatedChildElementsOfType(ResourceReferenceDt.class)) {
			Observation fhirReasonObs = (Observation) refReasonObs.getResource();
			CodingDt fhirCode = fhirReasonObs.getCode().getCodingFirstRep();
			Reason reason = new Reason();
			reason.setCode(new Code(removeURIPrefix(fhirCode.getSystem()), fhirCode.getCode(),
					fhirCode.getDisplay()));

			// guidelines
			for (Related fhirRelated : fhirReasonObs.getRelated()) {
				Observation fhirGuidelineObs = (Observation) fhirRelated.getTarget().getResource();
				try {
					reason.setReference(new URL(fhirGuidelineObs.getComments()));

				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
			retVal.addReason(reason);
		}

		// comment
		retVal.setCommentText(getComment(fhirMedicationStatement));

		return retVal;

	}

	/**
	 * Gets the laboratory observation.
	 * 
	 * @param fhirObservation
	 *            <div class="en">FHIR Observation resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC LaboratoryObservation</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	private org.ehealth_connector.cda.LaboratoryObservation getLaboratoryObservation(
			Observation fhirObservation) {
		org.ehealth_connector.cda.LaboratoryObservation retVal = new LaboratoryObservation();

		CodingDt fhirCode = fhirObservation.getCode().getCodingFirstRep();
		retVal.setCode(new Code(removeURIPrefix(fhirCode.getSystem()), fhirCode.getCode(), fhirCode
				.getDisplay()));
		retVal.setEffectiveTime(fhirObservation.getIssued());
		if (!fhirObservation.getPerformer().isEmpty()) {
			ResourceReferenceDt refPerf = fhirObservation.getPerformer().get(0);
			retVal.setLaboratory(getOrganization((Organization) refPerf.getResource()),
					fhirObservation.getIssued());
		}

		if (fhirObservation.getValue() instanceof QuantityDt) {
			// type PQ
			QuantityDt fhirQuantity = (QuantityDt) fhirObservation.getValue();
			retVal.addValue(new Value(fhirQuantity.getValue().toString(), Ucum.getEnum(fhirQuantity
					.getUnit())));
		} else if (fhirObservation.getValue() instanceof CodeableConceptDt) {
			// type CD
			CodingDt fhirValueCode = ((CodeableConceptDt) fhirObservation.getValue())
					.getCodingFirstRep();
			retVal.addValue(new Code(new Code(removeURIPrefix(fhirValueCode.getSystem()),
					fhirValueCode.getCode(), fhirValueCode.getDisplay())));
		} else if (fhirObservation.getValue() instanceof RatioDt) {
			// type RTO not yet implemented
		}

		if (fhirObservation.getReferenceRangeFirstRep() != null) {
			// ReferenceRange not yet implemented
		}

		CodingDt fhirInterpretationCode = fhirObservation.getInterpretation().getCodingFirstRep();
		if (fhirInterpretationCode != null) {
			if (fhirInterpretationCode.getSystem() != null) {
				retVal.setInterpretationCode(new Code(removeURIPrefix(fhirInterpretationCode
						.getSystem()), fhirInterpretationCode.getCode(), fhirInterpretationCode
						.getDisplay()));
			}
		}

		retVal.setCommentText(fhirObservation.getComments());

		return retVal;

	}

	/**
	 * Gets the lot.
	 * 
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">lotnumber text</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	private String getLot(MedicationStatement fhirMedicationStatement) {
		String retVal = "";
		if (!fhirMedicationStatement.getUndeclaredExtensionsByUrl(urnUseAsLotNumbertext).isEmpty()) {
			StringDt lot = (StringDt) fhirMedicationStatement
					.getUndeclaredExtensionsByUrl(urnUseAsLotNumbertext).get(0).getValue();
			retVal = lot.toString();
		}
		return retVal;
	}

	/**
	 * Gets the past problem concern.
	 * 
	 * @param fhirCondition
	 *            <div class="en">FHIR Condition resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC PastProblemConcern</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	private org.ehealth_connector.cda.PastProblemConcern getPastProblemConcern(
			Condition fhirCondition) {
		org.ehealth_connector.cda.PastProblemConcern retVal = null;

		String concern = fhirCondition.getNotes();
		// org.ehealth_connector.cda.Problem problemEntry = new
		// org.ehealth_connector.cda.Problem();
		// CodingDt fhirCode = fhirCondition.getCode().getCodingFirstRep();
		// problemEntry.setCode(new Code(removeURIPrefix(fhirCode.getSystem()),
		// fhirCode.getCode(), fhirCode.getDisplay()));

		org.ehealth_connector.cda.Problem problemEntry = getProblemEntry(fhirCondition);

		org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode problemStatusCode = getProblemConcernStatusCode(fhirCondition);

		// Create the PastProblemConcern
		retVal = new org.ehealth_connector.cda.PastProblemConcern(concern, problemEntry,
				problemStatusCode);

		// // Add Identifiers
		// for (IdentifierDt id : fhirCondition.getIdentifier()) {
		// String codeSystem = removeURIPrefix(id.getSystem());
		// retVal.addId(new Identificator(codeSystem, id.getValue()));
		// }
		//
		return retVal;

	}

	/**
	 * <div class="en">Maps the FHIR status code to an eHC
	 * ProblemConcernStatusCode</div> <div class="de"></div> <div
	 * class="fr"></div>.
	 * 
	 * @param condition
	 *            the condition
	 * @return <div class="en">eHC ProblemConcernStatusCode</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	private org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode getProblemConcernStatusCode(
			Condition condition)

	{
		org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode retVal = ProblemConcernStatusCode.COMPLETED;
		ConditionClinicalStatusCodesEnum status = condition.getClinicalStatusElement()
				.getValueAsEnum();
		if (status == ConditionClinicalStatusCodesEnum.RESOLVED) {
			retVal = ProblemConcernStatusCode.COMPLETED;
		} else if (status == ConditionClinicalStatusCodesEnum.ACTIVE) {
			retVal = ProblemConcernStatusCode.ACTIVE;
		}
		return retVal;
	}

	/**
	 * Gets the problem entry.
	 * 
	 * @param fhirCondition
	 *            the fhir condition
	 * @return the problem entry
	 */
	private org.ehealth_connector.cda.Problem getProblemEntry(Condition fhirCondition) {

		org.ehealth_connector.cda.Problem retVal = new org.ehealth_connector.cda.Problem();
		CodingDt fhirCode = fhirCondition.getCode().getCodingFirstRep();

		// Add Problem Entry Identifiers
		for (IdentifierDt id : fhirCondition.getIdentifier()) {
			String codeSystem = removeURIPrefix(id.getSystem());
			retVal.setId(new Identificator(codeSystem, id.getValue()));
		}

		// currently only Problems supported
		retVal.setCode(ProblemType.PROBLEM);

		// Date
		retVal.setStartDate(fhirCondition.getDateRecorded());

		// Value
		retVal.addValue(new Code(removeURIPrefix(fhirCode.getSystem()), fhirCode.getCode(),
				fhirCode.getDisplay()));

		return retVal;
	}

	/**
	 * Gets the telecoms.
	 * 
	 * @param fhirContactPoints
	 *            <div class="en">list of FHIR ContactPointDt resources</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Telecoms</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	private Telecoms getTelecoms(List<ContactPointDt> fhirContactPoints) {
		Telecoms eHCTelecoms = new Telecoms();
		for (ContactPointDt telco : fhirContactPoints) {
			AddressUse usage = AddressUse.BUSINESS;
			if (telco.getUseElement().getValueAsEnum() == ContactPointUseEnum.HOME) {
				usage = AddressUse.PRIVATE;
			}
			String value = telco.getValue();
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
	 * <div class="en">reads the given XML file (UTF-8) into a string</div> <div
	 * class="de"></div> <div class="fr"></div>.
	 * 
	 * @param fileName
	 *            <div class="en">file to read</div> <div class="de"></div> <div
	 *            class="fr"></div>
	 * @return <div class="en">string containing the XML file content</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	private String getXmlResource(String fileName) {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName), "UTF8"));
			String line;
			try {
				while ((line = bufferedReader.readLine()) != null) {
					sb.append(line);
				}
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * <div class="en">removes urn:oid: prefix of the given string</div> <div
	 * class="de"></div> <div class="fr"></div>.
	 * 
	 * @param value
	 *            the value
	 * @return <div class="en">string without the prefix</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	private String removeURIPrefix(String value) {
		String retVal = "";
		if (value.toLowerCase().startsWith("urn:oid:"))
			retVal = value.substring(8, value.length());
		return retVal;
	}
}
