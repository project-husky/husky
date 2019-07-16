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

package org.ehealth_connector.fhir.structures.ch;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.mdht.enums.CodeSystems;
import org.ehealth_connector.fhir.structures.gen.FhirCommon;
import org.hl7.fhir.dstu3.model.Basic;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Condition;
import org.hl7.fhir.dstu3.model.DocumentManifest;
import org.hl7.fhir.dstu3.model.MedicationStatement;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Organization;
import org.hl7.fhir.dstu3.model.Patient;
import org.hl7.fhir.dstu3.model.Person;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.StringType;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.util.ElementUtil;

/**
 * FhirCdaChVacd supports the creation of a CDA-CH-CH document from HL7 FHIR
 * resources. The content of these resources is not currently documented.
 * These resources may be created by the class
 * org.ehealth_connector.demo.cda.VACDResources. This is currently the one any
 * only way to create valid FHIR resources for CDA-CH-VACD. You may edit
 * these FHIR resources in a text editor in order to change the payload of the
 * resulting CdaChVacd object on your own risk.
 *
 * @see "https://www.hl7.org/fhir/"
 */
/**
 * <div class="en"></div><div class="de"></div><div class="fr"></div>
 */
public class FhirCdaChVacd /* extends AbstractFhirCdaCh */ {

	/**
	 * <div class="en">Type of the FHIR resource to define whether the resulting
	 * CDA document contains full or masked patient demographics</div>
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
		@Extension(url = FhirCommon.urnUseAsAuthor, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Person who documented the medication statement")
		private Reference author;

		/**
		 * <div class="en">Code of the medication administration</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "code")
		@Extension(url = FhirCommon.urnUseAsCode, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Code of the medication administration")
		private Coding code;

		/**
		 * <div class="en">Remark for this medication statement</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "comment")
		@Extension(url = FhirCommon.urnUseAsComment, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Remark for this medication statement")
		private StringType comment;

		/**
		 * <div class="en">List of reasons for this medication statement</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "externalDocument")
		@Extension(url = FhirCommon.urnUseAsExternalDocument, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "reference to the guidline for theimmunization recommendation")
		private Reference externalDocument;

		/**
		 * <div class="en">LotNumber for this medication statement</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "lot")
		@Extension(url = FhirCommon.urnUseAsLotNumbertext, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "LotNumber for this medication statement")
		private StringType lot;

		/**
		 * <div class="en">Person who performed the medication
		 * administration</div> <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "performer")
		@Extension(url = FhirCommon.urnUseAsPerformer, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Person who performed the medicationadministration")
		private Reference performer;

		/**
		 * <div class="en">List of reasons for this medication statement</div>
		 * <div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "reasons")
		@Extension(url = FhirCommon.urnUseAsReason, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "List of reasons for this medicationstatement")
		private Reference reasons;

		/**
		 * <div class="en">Empty constructor (default)</div>
		 * <div class="de"></div> <div class="fr"></div>
		 */
		public MyMedicationStatement() {
			super();
			setTaken(MedicationStatementTaken.UNK);
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
			return code;
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
			return super.isEmpty() && ElementUtil.isEmpty(code, performer, author, comment);
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
			this.code = code;
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
	public static class VacdDocument extends DocumentManifest {

		private static final long serialVersionUID = -1316775746486313864L;

		/** The active problem concern entries. */
		@Child(name = "activeProblemConcernEntries", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsActiveProblemConcernEntries, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "activeProblemConcernEntries")
		private List<Reference> activeProblemConcernEntries; // Condition

		/** The allergy problem concern entries. */
		@Child(name = "allergyProblemConcernEntries", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsAllergyProblemConcernEntries, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "allergyProblemConcernEntries")
		private List<Reference> allergyProblemConcernEntries; // Condition

		/** The coded result observations. */
		@Child(name = "codedResultObservations", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsCodedResultObservations, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "codedResultObservations")
		private List<Reference> codedResultObservations; // codedResults

		/** The comment. */
		@Child(name = "comment")
		@Extension(url = FhirCommon.urnUseAsComment, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "comment")
		private Reference comment;

		/** The confidentiality. */
		@Child(name = "confidentiality")
		@Extension(url = FhirCommon.urnUseAsConfidentiality, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "confidentiality")
		private Reference confidentiality;

		/** The custodian. */
		@Child(name = "custodian")
		@Extension(url = FhirCommon.urnUseAsCustodian, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "custodian")
		private Reference custodian;

		/** The doc author. */
		@Child(name = "docAuthor")
		@Extension(url = FhirCommon.urnUseAsAuthor, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "author")
		private Reference docAuthor;

		/** The doc language. */
		@Child(name = "docLanguage")
		@Extension(url = FhirCommon.urnUseAsLanguage, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "docLanguage")
		private Reference docLanguage;

		/** The doc type. */
		@Child(name = "docType")
		@Extension(url = FhirCommon.urnUseAsDocType, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "docType")
		private Reference docType;

		/** The immunization recommendations. */
		@Child(name = "immunizationRecommendations", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsImmunizationRecommendation, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "immunizationRecommendations")
		private List<Reference> immunizationRecommendations;

		/** The immunizations. */
		@Child(name = "immunizations", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsImmunization, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "immunizations")
		private List<Reference> immunizations;

		/** The laboratory observations. */
		@Child(name = "laboratoryObservations", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsLaboratoryObservations, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "laboratoryObservations")
		private List<Reference> laboratoryObservations; // Observations

		/** The legal authenticator. */
		@Child(name = "legalAuthenticator")
		@Extension(url = FhirCommon.urnUseAsLegalAuthenticator, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "legalAuthenticator")
		private Reference legalAuthenticator;

		/** The past problem concern entries. */
		@Child(name = "pastProblemConcernEntries", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsPastProblemConcernEntries, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "pastProblemConcernEntries")
		private List<Reference> pastProblemConcernEntries; // Condition

		/** The patient. */
		@Child(name = "patient")
		@Extension(url = FhirCommon.urnUseAsPatient, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "patient")
		private Reference patient;

		/** The pregnancy observation. */
		@Child(name = "pregnancyObservation,", max = Child.MAX_UNLIMITED)
		@Extension(url = FhirCommon.urnUseAsPregnancyObservation, definedLocally = false, isModifier = true)
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
			final List<Condition> list = new ArrayList<>();
			if (this.pastProblemConcernEntries != null) {
				for (final Reference resource : pastProblemConcernEntries) {
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
			final Reference resourceRef = new Reference();
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
			final Reference resourceRef = new Reference();
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
			final Reference resourceRef = new Reference();
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
			final Reference resourceRef = new Reference();
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
			final Reference resourceRef = new Reference();
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
			final Reference resourceRef = new Reference();
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
			final Reference resourceRef = new Reference();
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
			final Reference resourceRef = new Reference();
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
			final Reference resourceRef = new Reference();
			resourceRef.setResource(pregnancyObservation);
			this.pregnancyObservation = resourceRef;
		}

	};

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div>
	 * <div class="de"></div><div class="fr"></div>
	 */
	public static final String OID_CONFIDENTIALITY_CODE = FhirCommon
			.addUrnOid(CodeSystems.ConfidentialityCode.getCodeSystemId());

	/**
	 * <div class="en">Empty constructor (default)</div><div class="de"></div>
	 * <div class="fr"></div>
	 */
	public FhirCdaChVacd() {
	}

}
