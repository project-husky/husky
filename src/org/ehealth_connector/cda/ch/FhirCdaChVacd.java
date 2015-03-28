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

package org.ehealth_connector.cda.ch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.ActiveProblemConcern;
import org.ehealth_connector.cda.AllergyConcern;
import org.ehealth_connector.cda.Immunization;
import org.ehealth_connector.cda.ImmunizationRecommendation;
import org.ehealth_connector.cda.LaboratoryObservation;
import org.ehealth_connector.cda.PastProblemConcern;
import org.ehealth_connector.cda.Reason;
import org.ehealth_connector.cda.ch.enums.AllergiesAndIntolerances;
import org.ehealth_connector.cda.ch.enums.CodeSystems;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.ehealth_connector.cda.ch.enums.MedicationsSpecialConditions;
import org.ehealth_connector.cda.ch.enums.ObservationInterpretationForImmunization;
import org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode;
import org.ehealth_connector.cda.ch.enums.SerologieForVACD;
import org.ehealth_connector.cda.enums.AddressUse;
import org.ehealth_connector.cda.enums.AdministrativeGender;
import org.ehealth_connector.cda.enums.Confidentiality;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.Value;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
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
import ca.uhn.fhir.model.dstu2.resource.Other;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Person;
import ca.uhn.fhir.model.dstu2.valueset.AddressUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.AdministrativeGenderEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointUseEnum;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.util.ElementUtil;

/**
 * <div class="en">FhirCdaChVacd supports the creation of a CDA-CH-CH document
 * from HL7 FHIR bundle resources. The content of these resources is not
 * currently documented. These resources may be created by the class
 * org.ehealth_connector.demo.cda.VACDResources. This is currently the one any
 * only way to create valid FHIR bundle resources for CDA-CH-VACD. You may edit
 * these FHIR resources in a text editor in order to change the payload of the
 * resulting CdaChVacd object on your own risk.
 * 
 * @formatter:off
 * @see http://hl7.org/implement/standards/FHIR-Develop/resourcelist.html
 * @formatter:on</div><div class="de"></div><div class="fr"></div>
 */
/**
 * <div class="en"></div><div class="de"></div><div class="fr"></div>
 */
/**
 * <div class="en"></div><div class="de"></div><div class="fr"></div>
 */
/**
 * <div class="en"></div><div class="de"></div><div class="fr"></div>
 */
/**
 * <div class="en"></div><div class="de"></div><div class="fr"></div>
 */
public class FhirCdaChVacd {

	/**
	 * <div class="en">Type of the bundle to define wheter the resulting CDA
	 * document contains full or masked patient demographics</div><div
	 * class="de"></div><div class="fr"></div>
	 */
	public static enum DocTypeCode {
		/**
		 * <div class="en">the resulting CDA document contains full patient
		 * demographics</div><div class="de"></div><div class="fr"></div>
		 */
		PATIENT, /**
		 * <div class="en">the resulting CDA document contains masked
		 * patient demographics</div><div class="de"></div><div
		 * class="fr"></div>
		 */
		PSEUDONYMIZED
	}

	/**
	 * <div class="en">MyMedicationStatement extends from the FHIR HAPI
	 * MedicationStatement Resource and provides extension attributes in order
	 * to fulfill the needs for HL7 CDA-CH-CDA creation
	 * 
	 * @formatter:off
	 * @see http://jamesagnew.github.io/hapi-fhir/index.html
	 * @formatter:on</div><div class="de"></div><div class="fr"></div>
	 */
	/**
	 * <div class="en"></div><div class="de"></div><div class="fr"></div>
	 */
	@ResourceDef(name = "MedicationStatement")
	public static class MyMedicationStatement extends MedicationStatement {

		/**
		 * <div class="en">Person who documented the medication
		 * statement</div><div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "author")
		@Extension(url = urnUseAsAuthor, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Person who documented the medication statement")
		private ResourceReferenceDt author;

		/**
		 * <div class="en">Code of the medication administration</div><div
		 * class="de"></div><div class="fr"></div>
		 */
		@Child(name = "code")
		@Extension(url = urnUseAsCode, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Code of the medication administration")
		private CodingDt code;

		/**
		 * <div class="en">Remark for this medication statement</div><div
		 * class="de"></div><div class="fr"></div>
		 */
		@Child(name = "comment")
		@Extension(url = urnUseAsComment, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Remark for this medication statement")
		private StringDt comment;

		/**
		 * <div class="en">LotNumber for this medication statement</div><div
		 * class="de"></div><div class="fr"></div>
		 */
		@Child(name = "lot")
		@Extension(url = urnUseAsLotNumbertext, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "LotNumber for this medication statement")
		private StringDt lot;

		/**
		 * <div class="en">Person who performed the medication
		 * administration</div><div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "performer")
		@Extension(url = urnUseAsPerformer, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "Person who performed the medication administration")
		private ResourceReferenceDt performer;

		/**
		 * <div class="en">List of reasons for this medication
		 * statement</div><div class="de"></div><div class="fr"></div>
		 */
		@Child(name = "reasons")
		@Extension(url = urnUseAsReason, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "List of reasons for this medication statement")
		private ResourceReferenceDt reasons;

		/**
		 * <div class="en">Empty constructor (default)</div><div
		 * class="de"></div><div class="fr"></div>
		 */
		public MyMedicationStatement() {
			super();
		}

		/**
		 * @return <div class="en">author of this MedicationStatement</div><div
		 *         class="de">Autor dieses MedicationStatements</div><div
		 *         class="fr">auteur de ce MedicationStatement</div>
		 */
		public ResourceReferenceDt getAuthor() {
			if (this.author == null) {
				this.author = new ResourceReferenceDt();
			}
			return author;
		}

		/**
		 * @return <div class="en">code of this MedicationStatement</div><div
		 *         class="de">Code für dieses MedicationStatement</div><div
		 *         class="fr">code de ce MedicationStatement</div>
		 */
		public CodingDt getCode() {
			return code;
		}

		/**
		 * @return <div class="en">comment for this medication</div><div
		 *         class="de">Kommentar zu diesem Medikament</div><div
		 *         class="fr">commentaire tu médicament</div>
		 */
		public StringDt getComment() {
			if (this.comment == null) {
				this.comment = new StringDt();
			}
			return comment;
		}

		/**
		 * @return <div class="en">lot number of this medication</div><div
		 *         class="de">Lotnummer des Medikaments</div><div
		 *         class="fr">numero lot du médicament</div>
		 */
		public StringDt getLot() {
			if (this.lot == null) {
				this.lot = new StringDt();
			}
			return lot;
		}

		/**
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
		 * @return <div class="en">reason for this medication</div> <div
		 *         class="de">Begründung für dieses Medikament</div><div
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
		 * @see ca.uhn.fhir.model.dstu2.resource.MedicationStatement#isEmpty()
		 */
		@Override
		public boolean isEmpty() {
			return super.isEmpty()
					&& ElementUtil.isEmpty(code, performer, author, reasons,
							comment);
		}

		/**
		 * @param author
		 *            <div class="en">author of this
		 *            MedicationStatement</div><div class="de">Autor dieses
		 *            MedicationStatements</div><div class="fr">auteur de ce
		 *            MedicationStatement</div>
		 */
		public void setAuthor(ResourceReferenceDt author) {
			this.author = author;
		}

		/**
		 * @param code
		 *            <div class="en">code of this MedicationStatement</div><div
		 *            class="de">Code für dieses MedicationStatement</div><div
		 *            class="fr">code de ce MedicationStatement</div>
		 */
		public void setCode(CodingDt code) {
			this.code = code;
		}

		/**
		 * @param comment
		 *            <div class="en">comment for this medication</div><div
		 *            class="de">Kommentar zu diesem Medikament</div><div
		 *            class="fr">commentaire tu médicament</div>
		 */
		public void setComment(StringDt comment) {
			this.comment = comment;
		}

		/**
		 * @param lot
		 *            <div class="en">lot number of this medication</div><div
		 *            class="de">Lotnummer des Medikaments</div><div
		 *            class="fr">numero lot du médicament</div>
		 */
		public void setLot(StringDt lot) {
			this.lot = lot;
		}

		/**
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
		 * @param reasons
		 *            <div class="en">reason for this medication</div> <div
		 *            class="de">Begründung für dieses Medikament</div><div
		 *            class="fr">Justification de ce médicament</div>
		 */
		public void setReasons(ResourceReferenceDt reasons) {
			this.reasons = reasons;
		}

	};

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div><div
	 * class="de"></div><div class="fr"></div>
	 */
	public static final String oidConfidentialityCode = "urn:oid:"
			+ CodeSystems.ConfidentialityCode.getCodeSystemId();

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div><div
	 * class="de"></div><div class="fr"></div>
	 */
	public static final String oidLanguage = "urn:oid:"
			+ CodeSystems.LanguageCode.getCodeSystemId();

	// TODO Tony: aus KnownOIds holen
	/**
	 * <div class="en">uniform resource name (urn) of this OID</div><div
	 * class="de"></div><div class="fr"></div>
	 */
	public static final String oidVACD = "urn:oid:2.16.756.5.30.1.1.1.1.3.5";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsActiveProblemConcern = "urn:ehealth_connector:Demo:FhirExtension:useAsActiveProblemConcern";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsAllergyProblemConcern = "urn:ehealth_connector:Demo:FhirExtension:useAsAllergyProblemConcern";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsAuthor = "urn:ehealth_connector:Demo:FhirExtension:useAsAuthor";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsCode = "urn:ehealth_connector:Demo:FhirExtension:urnUseAsCode";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsComment = "urn:ehealth_connector:Demo:FhirExtension:useAsComment";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsCustodian = "urn:ehealth_connector:Demo:FhirExtension:useAsCustodian";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsIdentifier = "urn:ehealth_connector:Demo:FhirExtension:useAsIdentifier";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsImmunization = "urn:ehealth_connector:Demo:FhirExtension:useAsImmunization";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsImmunizationRecommendation = "urn:ehealth_connector:Demo:FhirExtension:useAsImmunizationRecommendation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsLaboratoryObservation = "urn:ehealth_connector:Demo:FhirExtension:useAsLaboratoryObservation";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsLegalAuthenticator = "urn:ehealth_connector:Demo:FhirExtension:useAsLegalAuthenticator";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsLotNumbertext = "urn:ehealth_connector:Demo:FhirExtension:urnUseAsLotNumbertext";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsPastProblemConcern = "urn:ehealth_connector:Demo:FhirExtension:useAsPastProblemConcern";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsPerformer = "urn:ehealth_connector:Demo:FhirExtension:useAsPerformer";

	/**
	 * <div class="en">uniform resource name (urn) of this FHIR
	 * extension</div><div class="de"></div><div class="fr"></div>
	 */
	public static final String urnUseAsReason = "urn:ehealth_connector:Demo:FhirExtension:useAsReason";

	private final FhirContext mFhirCtx = new FhirContext();

	/**
	 * <div class="en">Empty constructor (default)</div><div
	 * class="de"></div><div class="fr"></div>
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
	 *            <div class="en">desired CSS for the CDA document</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC CdaChVacd instance containing payload of the
	 *         given FHIR Bundle resource</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	public org.ehealth_connector.cda.ch.CdaChVacd createCdaChVacdFromFHIRBundle(
			Bundle bundle, String xsl, String css) {

		// Header
		CdaChVacd doc = new CdaChVacd(getDocLanguage(bundle), xsl, css);
		DocTypeCode docType = getDocType(bundle);
		doc.setConfidentialityCode(getConfidentialityCode(bundle));
		doc.setPatient(getPatient(bundle));
		if (docType == DocTypeCode.PSEUDONYMIZED)
			doc.pseudonymization();

		for (Author author : getAuthors(bundle)) {
			author.setTime(DateUtil.date("15.12.2014"));
			doc.addAuthor(author);
		}
		doc.setCustodian(getCustodian(bundle));
		doc.setLegalAuthenticator(getLegalAuthenticator(bundle));

		// Body
		// Immunizations / Impfungen
		for (Immunization immunization : getImmunizations(bundle)) {
			doc.addImmunization(immunization);
		}

		// Active Problems / Problemliste
		for (ActiveProblemConcern activeProblemConcernEntry : getActiveProblemConcernEntries(bundle)) {
			doc.addActiveProblemConcern(activeProblemConcernEntry);
		}

		// History of Past Illness / Bisherige Krankheiten/Anamnese
		for (PastProblemConcern pastProblemConcern : getPastProblemConcernEntries(bundle)) {
			doc.addPastProblemConcern(pastProblemConcern);
		}

		// Allergies and Other Adverse Reactions / Allergien und
		// Unverträglichkeiten
		for (AllergyConcern allergyProblemConcern : getAllergyProblemConcernEntries(bundle)) {
			doc.addAllergyProblemConcern(allergyProblemConcern);
		}

		// TODO Coded Results / Codierte Resultate
		// for (AllergyConcern allergyProblemConcern :
		// getAllergyProblemConcernEntries(bundle)) {
		// doc.add(allergyProblemConcern);
		// }

		// Laboratory Specialty Section / Relevante Laborbefunde
		for (LaboratoryObservation laboratoryObservation : getLaboratoryObservations(bundle)) {
			doc.addLaboratoryObservation(laboratoryObservation);
		}

		// TODO tony: Schwangerschaften

		for (ImmunizationRecommendation immunizationRecommendation : getImmunizationRecommendations(bundle)) {
			doc.addImmunizationRecommendation(immunizationRecommendation);
		}

		doc.addComment(getComment(bundle));

		return doc;
	}

	/**
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">list of eHC ActiveProblemConcerns</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	public ArrayList<org.ehealth_connector.cda.ActiveProblemConcern> getActiveProblemConcernEntries(
			Bundle bundle) {
		ArrayList<org.ehealth_connector.cda.ActiveProblemConcern> retVal = new ArrayList<org.ehealth_connector.cda.ActiveProblemConcern>();
		for (Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(
					urnUseAsActiveProblemConcern).isEmpty()
					&& (entry.getResource() instanceof Condition)) {
				retVal.add(getActiveProblemConcern((Condition) entry
						.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC AllergyConcern</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public ArrayList<org.ehealth_connector.cda.AllergyConcern> getAllergyProblemConcernEntries(
			Bundle bundle) {
		ArrayList<org.ehealth_connector.cda.AllergyConcern> retVal = new ArrayList<org.ehealth_connector.cda.AllergyConcern>();
		for (Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(
					urnUseAsAllergyProblemConcern).isEmpty()
					&& (entry.getResource() instanceof Condition)) {
				retVal.add(getAllergyProblemConcern((Condition) entry
						.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Author</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	public org.ehealth_connector.common.Author getAuthor(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.common.Author retVal = null;
		if (!fhirMedicationStatement.getUndeclaredExtensionsByUrl(
				urnUseAsAuthor).isEmpty()) {
			ResourceReferenceDt refAuthor = (ResourceReferenceDt) fhirMedicationStatement
					.getUndeclaredExtensionsByUrl(urnUseAsAuthor).get(0)
					.getValue();
			retVal = getAuthor((Person) refAuthor.getResource());
		}
		return retVal;
	}

	/**
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">list of eHC Authors</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public ArrayList<org.ehealth_connector.common.Author> getAuthors(
			Bundle bundle) {
		ArrayList<org.ehealth_connector.common.Author> retVal = new ArrayList<org.ehealth_connector.common.Author>();
		for (Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(urnUseAsAuthor).isEmpty()
					&& (entry.getResource() instanceof Person)) {
				retVal.add(getAuthor((Person) entry.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">the comment as string</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	public String getComment(Bundle bundle) {
		String retVal = "";
		for (Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(urnUseAsComment).isEmpty()
					&& (entry.getResource() instanceof Observation)) {
				retVal = ((Observation) entry.getResource()).getComments();
			}
		}
		return retVal;
	}

	/**
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Confidentiality</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public Confidentiality getConfidentialityCode(Bundle bundle) {
		Confidentiality retVal = Confidentiality.NORMAL; // default
		for (Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Other) {
				Other fhirOther = (Other) entry.getResource();
				CodingDt langCode = fhirOther.getCode().getCodingFirstRep();
				if (langCode.getSystem().equals(oidConfidentialityCode)) {
					if (langCode.getCode().toLowerCase()
							.equals("veryrestricted")) {
						retVal = Confidentiality.VERY_RESTRICTED;
						break;
					} else if (langCode.getCode().toLowerCase()
							.equals("restricted")) {
						retVal = Confidentiality.RESTRICED;
						break;
					} else if (langCode.getCode().toLowerCase()
							.equals("normal")) {
						retVal = Confidentiality.NORMAL;
						break;
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Organization</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public org.ehealth_connector.common.Organization getCustodian(Bundle bundle) {
		org.ehealth_connector.common.Organization retVal = null;
		for (Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(urnUseAsCustodian)
					.isEmpty() && (entry.getResource() instanceof Organization)) {
				retVal = getOrganization((Organization) entry.getResource());
			}
		}
		return retVal;
	}

	/**
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC LanguageCode</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public LanguageCode getDocLanguage(Bundle bundle) {
		LanguageCode retVal = LanguageCode.GERMAN; // default
		for (Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Other) {
				Other fhirOther = (Other) entry.getResource();
				CodingDt langCode = fhirOther.getCode().getCodingFirstRep();
				if (langCode.getSystem().equals(oidLanguage)) {
					if (langCode.getCode().toLowerCase().startsWith("de")) {
						retVal = LanguageCode.GERMAN;
						break;
					} else if (langCode.getCode().toLowerCase()
							.startsWith("fr")) {
						retVal = LanguageCode.FRENCH;
						break;
					} else if (langCode.getCode().toLowerCase()
							.startsWith("it")) {
						retVal = LanguageCode.ITALIAN;
						break;
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">DocTypeCode (full or masked patient
	 *         demographics)</div> <div class="de"></div> <div class="fr"></div>
	 */
	public DocTypeCode getDocType(Bundle bundle) {
		DocTypeCode retVal = DocTypeCode.PATIENT; // default
		for (Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Other) {
				Other fhirOther = (Other) entry.getResource();
				CodingDt langCode = fhirOther.getCode().getCodingFirstRep();
				if (langCode.getSystem().equals(oidVACD)) {
					if (langCode.getCode().toLowerCase().equals("patient")) {
						retVal = DocTypeCode.PATIENT;
						break;
					} else if (langCode.getCode().toLowerCase()
							.equals("pseudonymized")) {
						retVal = DocTypeCode.PSEUDONYMIZED;
						break;
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">list of eHC ImmunizationRecommendations</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public ArrayList<org.ehealth_connector.cda.ImmunizationRecommendation> getImmunizationRecommendations(
			Bundle bundle) {
		ArrayList<org.ehealth_connector.cda.ImmunizationRecommendation> retVal = new ArrayList<org.ehealth_connector.cda.ImmunizationRecommendation>();
		for (Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(
					urnUseAsImmunizationRecommendation).isEmpty()
					&& (entry.getResource() instanceof MedicationStatement)) {
				retVal.add(getImmunizationRecommendation((MedicationStatement) entry
						.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">list of eHC Immunizations</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	public ArrayList<org.ehealth_connector.cda.Immunization> getImmunizations(
			Bundle bundle) {
		ArrayList<org.ehealth_connector.cda.Immunization> retVal = new ArrayList<org.ehealth_connector.cda.Immunization>();
		for (Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(urnUseAsImmunization)
					.isEmpty()
					&& (entry.getResource() instanceof MedicationStatement)) {
				retVal.add(getImmunization((MedicationStatement) entry
						.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">list of eHC LaboratoryObservations</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	public ArrayList<org.ehealth_connector.cda.LaboratoryObservation> getLaboratoryObservations(
			Bundle bundle) {
		ArrayList<org.ehealth_connector.cda.LaboratoryObservation> retVal = new ArrayList<org.ehealth_connector.cda.LaboratoryObservation>();
		for (Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(
					urnUseAsLaboratoryObservation).isEmpty()
					&& (entry.getResource() instanceof Observation)) {
				retVal.add(getLaboratoryObservation((Observation) entry
						.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Author</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	public org.ehealth_connector.common.Author getLegalAuthenticator(
			Bundle bundle) {
		org.ehealth_connector.common.Author retVal = null;
		for (Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(urnUseAsLegalAuthenticator)
					.isEmpty() && (entry.getResource() instanceof Person)) {
				retVal = getAuthor((Person) entry.getResource());
			}
		}
		return retVal;
	}

	/**
	 * @param fhirOrganization
	 *            <div class="en">FHIR Organization resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Organization</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public org.ehealth_connector.common.Organization getOrganization(
			Organization fhirOrganization) {
		org.ehealth_connector.common.Organization retVal = null;
		// Create the organization
		retVal = new org.ehealth_connector.common.Organization(
				fhirOrganization.getName());

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
			Address eHCAddr = new Address(addr.getLineFirstRep().toString(),
					addr.getPostalCode(), addr.getCity(), usage);
			eHCAddr.setCountry(addr.getCountry());
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(getTelecoms(fhirOrganization.getTelecom()));

		return retVal;
	}

	/**
	 * @param orgRef
	 *            <div class="en">FHIR ResourceReferenceDt resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Organization</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public org.ehealth_connector.common.Organization getOrganization(
			ResourceReferenceDt orgRef) {
		org.ehealth_connector.common.Organization retVal = null;
		if (orgRef.getResource() instanceof Organization) {
			retVal = getOrganization((Organization) orgRef.getResource());
		}
		return retVal;
	}

	/**
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">list of eHC PastProblemConcerns</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	public ArrayList<org.ehealth_connector.cda.PastProblemConcern> getPastProblemConcernEntries(
			Bundle bundle) {
		ArrayList<org.ehealth_connector.cda.PastProblemConcern> retVal = new ArrayList<org.ehealth_connector.cda.PastProblemConcern>();
		for (Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(urnUseAsPastProblemConcern)
					.isEmpty() && (entry.getResource() instanceof Condition)) {
				retVal.add(getPastProblemConcern((Condition) entry
						.getResource()));
			}
		}
		return retVal;
	}

	/**
	 * @param bundle
	 *            <div class="en">valid CdaChVacd FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Patient</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	public org.ehealth_connector.common.Patient getPatient(Bundle bundle) {
		Patient fhirPatient = null;
		org.ehealth_connector.common.Patient retVal = null;
		for (Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Patient)
				fhirPatient = (Patient) entry.getResource();
		}
		Name patientName = new Name(fhirPatient.getNameFirstRep()
				.getGivenAsSingleString(), fhirPatient.getNameFirstRep()
				.getFamilyAsSingleString());
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
			Address eHCAddr = new Address(addr.getLineFirstRep().toString(),
					addr.getPostalCode(), addr.getCity(), usage);
			eHCAddr.setCountry(addr.getCountry());
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(getTelecoms(fhirPatient.getTelecom()));
		return retVal;
	}

	/**
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Author</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	public org.ehealth_connector.common.Author getPerformer(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.common.Author retVal = null;
		if (!fhirMedicationStatement.getUndeclaredExtensionsByUrl(
				urnUseAsPerformer).isEmpty()) {
			ResourceReferenceDt refAuthor = (ResourceReferenceDt) fhirMedicationStatement
					.getUndeclaredExtensionsByUrl(urnUseAsPerformer).get(0)
					.getValue();
			retVal = getAuthor((Person) refAuthor.getResource());
		}
		return retVal;
	}

	/**
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">list of FHIR ListResource resources</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	public ListResource getReasons(MedicationStatement fhirMedicationStatement) {
		ListResource retVal = null;
		for (ExtensionDt ext : fhirMedicationStatement
				.getUndeclaredExtensionsByUrl(urnUseAsReason)) {
			retVal = (ListResource) ((ResourceReferenceDt) ext.getValue())
					.getResource();
		}
		if (retVal == null)
			retVal = new ListResource();
		return retVal;
	}

	/**
	 * <div class="en">reads the given XML file into a FHIR bundle
	 * resource</div> <div class="de"></div> <div class="fr"></div>
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
		Date date = fhirCondition.getDateAsserted();
		org.ehealth_connector.cda.Problem problemEntry = new org.ehealth_connector.cda.Problem();
		CodingDt fhirCode = fhirCondition.getCode().getCodingFirstRep();
		problemEntry.setCode(new Code(removeURIPrefix(fhirCode.getSystem()),
				fhirCode.getCode(), fhirCode.getDisplay()));
		org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode problemStatusCode = ProblemConcernStatusCode.COMPLETED;
		if (fhirCondition.getStatus().equals("confirmed")) {
			problemStatusCode = ProblemConcernStatusCode.COMPLETED;
		} else {
			// TODO Tony: Mapping: active, suspended, aborted,
			// completed=CONFIRMED
			problemStatusCode = ProblemConcernStatusCode.ACTIVE;
		}

		// Create the ActiveProblemConcern
		retVal = new org.ehealth_connector.cda.ActiveProblemConcern(concern,
				date, problemEntry, problemStatusCode);

		// Add Identifiers
		for (IdentifierDt id : fhirCondition.getIdentifier()) {
			String codeSystem = removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		return retVal;

	}

	/**
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
		org.ehealth_connector.cda.AllergyProblem problemEntry = new org.ehealth_connector.cda.AllergyProblem();
		problemEntry.setCode(AllergiesAndIntolerances.DRUG_INTOLERANCE);
		CodingDt fhirCode = fhirCondition.getCode().getCodingFirstRep();
		problemEntry.addValue(new Code(removeURIPrefix(fhirCode.getSystem()),
				fhirCode.getCode(), fhirCode.getDisplay()));
		org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode problemStatusCode = ProblemConcernStatusCode.COMPLETED;
		if (fhirCondition.getStatus().equals("confirmed")) {
			problemStatusCode = ProblemConcernStatusCode.COMPLETED;
		} else {
			// TODO Tony: Mapping: active, suspended, aborted,
			// completed=CONFIRMED
			problemStatusCode = ProblemConcernStatusCode.ACTIVE;
		}

		// Create the AllergyProblemConcern
		retVal = new org.ehealth_connector.cda.AllergyConcern(concern,
				problemEntry, problemStatusCode);

		// Add Identifiers
		for (IdentifierDt id : fhirCondition.getIdentifier()) {
			String codeSystem = removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		return retVal;

	}

	/**
	 * @param fhirPerson
	 *            <div class="en">FHIR Person resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Author</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	private org.ehealth_connector.common.Author getAuthor(Person fhirPerson) {
		org.ehealth_connector.common.Author retVal = null;
		Name personName = new Name(fhirPerson.getNameFirstRep()
				.getGivenAsSingleString(), fhirPerson.getNameFirstRep()
				.getFamilyAsSingleString());

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
			Address eHCAddr = new Address(addr.getLineFirstRep().toString(),
					addr.getPostalCode(), addr.getCity(), usage);
			eHCAddr.setCountry(addr.getCountry());
			retVal.addAddress(eHCAddr);
		}

		// Add Telecoms
		retVal.setTelecoms(getTelecoms(fhirPerson.getTelecom()));

		// Add organization
		retVal.setOrganization(getOrganization(fhirPerson
				.getManagingOrganization()));

		return retVal;

	}

	/**
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Code</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	private Code getCode(MedicationStatement fhirMedicationStatement) {
		Code retVal = null;
		if (!fhirMedicationStatement.getUndeclaredExtensionsByUrl(urnUseAsCode)
				.isEmpty()) {
			CodingDt fhirCode = (CodingDt) fhirMedicationStatement
					.getUndeclaredExtensionsByUrl(urnUseAsCode).get(0)
					.getValue();
			retVal = new Code(removeURIPrefix(fhirCode.getSystem()),
					fhirCode.getCode(), fhirCode.getDisplay());
		}
		return retVal;
	}

	/**
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">the comment as string</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	private String getComment(MedicationStatement fhirMedicationStatement) {
		String retVal = "";
		if (!fhirMedicationStatement.getUndeclaredExtensionsByUrl(
				urnUseAsComment).isEmpty()) {
			StringDt comment = (StringDt) fhirMedicationStatement
					.getUndeclaredExtensionsByUrl(urnUseAsComment).get(0)
					.getValue();
			retVal = comment.toString();
		}
		return retVal;
	}

	/**
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC Consumable</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	private org.ehealth_connector.cda.Consumable getConsumable(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.cda.Consumable retVal = null;

		Medication fhirMedi = (Medication) fhirMedicationStatement
				.getMedication().getResource();
		// Create the consumable
		retVal = new org.ehealth_connector.cda.Consumable(fhirMedi.getName());

		// Set id
		if (!fhirMedi.getUndeclaredExtensionsByUrl(urnUseAsIdentifier)
				.isEmpty()) {
			IdentifierDt id = (IdentifierDt) fhirMedi
					.getUndeclaredExtensionsByUrl(urnUseAsIdentifier).get(0)
					.getValue();
			retVal.setManufacturedProductId(new org.ehealth_connector.common.Identificator(
					removeURIPrefix(id.getSystem()), id.getValue()));
		}

		// Set code
		CodingDt fhirCode = fhirMedi.getCode().getCodingFirstRep();
		Code code = new Code(removeURIPrefix(fhirCode.getSystem()),
				fhirCode.getCode(), fhirCode.getDisplay());
		retVal.setWhoAtcCode(code);

		// Set manufacturer
		ResourceReferenceDt refManufacturer = fhirMedi.getManufacturer();
		retVal.setManufacturer(getOrganization((Organization) refManufacturer
				.getResource()));

		// LotNumber
		retVal.setLotNr(getLot(fhirMedicationStatement));

		return retVal;
	}

	/**
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
				doseQuantity = dosage.getQuantity().getValue().doubleValue();
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
				Reason reason = new Reason(new Code(
						removeURIPrefix(fhirCode.getSystem()),
						fhirCode.getCode(), fhirCode.getDisplay()));
				retVal.addReason(reason);
			}

			// comment
			retVal.setCommentText(getComment(fhirMedicationStatement));

		}

		return retVal;

	}

	/**
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

		retVal.setShallNotBeAdministerd(fhirMedicationStatement
				.getWasNotGiven());

		// code
		// TODO Special cases
		Code code = getCode(fhirMedicationStatement);
		System.out.println(code.getCodeSystem() + "/" + code.getCode() + "/"
				+ code.getDisplayName());
		// retVal.setCode();

		// effectiveTime
		// not yet implemented: effectiveTime highValue
		retVal.setPossibleAppliance(fhirMedicationStatement.getDateAsserted(),
				null);

		// doseQuantity
		Double doseQuantity = null;
		for (Dosage dosage : fhirMedicationStatement.getDosage()) {
			doseQuantity = dosage.getQuantity().getValue().doubleValue();
			retVal.setDosage(doseQuantity);
			break; // currently only support for one doseQuantity
		}

		// consumable
		retVal.setConsumable(getConsumable(fhirMedicationStatement));

		// perfomer
		retVal.setPerformer(getPerformer(fhirMedicationStatement));

		// author
		retVal.setAuthor(getAuthor(fhirMedicationStatement));

		// reasons
		ListResource reasons = getReasons(fhirMedicationStatement);
		for (ResourceReferenceDt refReasonObs : reasons
				.getAllPopulatedChildElementsOfType(ResourceReferenceDt.class)) {
			Observation fhirReasonObs = (Observation) refReasonObs
					.getResource();
			CodingDt fhirCode = fhirReasonObs.getCode().getCodingFirstRep();
			Reason reason = new Reason();
			reason.setCode(new Code(removeURIPrefix(fhirCode.getSystem()),
					fhirCode.getCode(), fhirCode.getDisplay()));

			// guidelines
			for (Related fhirRelated : fhirReasonObs.getRelated()) {
				Observation fhirGuidelineObs = (Observation) fhirRelated
						.getTarget().getResource();
				try {
					reason.setReference(new URL(fhirGuidelineObs.getComments()));

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
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
	 * @param fhirObservation
	 *            <div class="en">FHIR Observation resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC LaboratoryObservation</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	private org.ehealth_connector.cda.LaboratoryObservation getLaboratoryObservation(
			Observation fhirObservation) {
		org.ehealth_connector.cda.LaboratoryObservation retVal = null;

		// TODO Tony: to complete
		org.ehealth_connector.common.Organization laboratoryOrg = new org.ehealth_connector.common.Organization(
				"dummyLabor", "12345678");
		org.ehealth_connector.common.Performer laboratory = new org.ehealth_connector.common.Performer(
				laboratoryOrg);
		// boolean immuneProtection = false;
		Date dateTimeOfResult = DateUtil.date("01.02.2015");
		// Code obsCode = new Code("dummy1", "dummy1");
		Value value = new Value(new Code("dummy2", "dummy2"));
		//
		// // Create the LaboratoryObservation
		// retVal = new org.ehealth_connector.cda.LaboratoryObservation(obsCode,
		// laboratory, immuneProtection, dateTimeOfResult, valueCode);
		//
		// // Add Identifiers
		// for (IdentifierDt id : fhirObservation.getIdentifier()) {
		// String codeSystem = removeURIPrefix(id.getSystem());
		// retVal.addId(new Identificator(codeSystem, id.getValue()));
		// }

		CdaChVacd doc = new CdaChVacd();
		retVal = doc
				.createLaboratoryObservation(
						SerologieForVACD.MEASLES_VIRUS_AB_IGG,
						null,
						dateTimeOfResult,
						laboratory,
						value,
						ObservationInterpretationForImmunization.NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECIMEN,
						"Testkommentar");

		return retVal;

	}

	/**
	 * @param fhirMedicationStatement
	 *            <div class="en">FHIR MedicationStatement resource</div> <div
	 *            class="de"></div> <div class="fr"></div>
	 * @return <div class="en">lotnumber text</div> <div class="de"></div> <div
	 *         class="fr"></div>
	 */
	private String getLot(MedicationStatement fhirMedicationStatement) {
		String retVal = "";
		if (!fhirMedicationStatement.getUndeclaredExtensionsByUrl(
				urnUseAsLotNumbertext).isEmpty()) {
			StringDt lot = (StringDt) fhirMedicationStatement
					.getUndeclaredExtensionsByUrl(urnUseAsLotNumbertext).get(0)
					.getValue();
			retVal = lot.toString();
		}
		return retVal;
	}

	/**
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
		org.ehealth_connector.cda.Problem problemEntry = new org.ehealth_connector.cda.Problem();
		CodingDt fhirCode = fhirCondition.getCode().getCodingFirstRep();
		problemEntry.setCode(new Code(removeURIPrefix(fhirCode.getSystem()),
				fhirCode.getCode(), fhirCode.getDisplay()));
		org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode problemStatusCode = ProblemConcernStatusCode.COMPLETED;
		if (fhirCondition.getStatus().equals("confirmed")) {
			problemStatusCode = ProblemConcernStatusCode.COMPLETED;
		} else {
			// TODO Tony: Mapping: active, suspended, aborted,
			// completed=CONFIRMED
			problemStatusCode = ProblemConcernStatusCode.ACTIVE;
		}

		// Create the PastProblemConcern
		retVal = new org.ehealth_connector.cda.PastProblemConcern(concern,
				problemEntry, problemStatusCode);

		// Add Identifiers
		for (IdentifierDt id : fhirCondition.getIdentifier()) {
			String codeSystem = removeURIPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		return retVal;

	}

	/**
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
	 * <div class="en">reads the given XML file into a string</div> <div
	 * class="de"></div> <div class="fr"></div>
	 * 
	 * @param fileName
	 *            <div class="en">file to read</div> <div class="de"></div> <div
	 *            class="fr"></div>
	 * @return <div class="en">string containing the XML file content</div> <div
	 *         class="de"></div> <div class="fr"></div>
	 */
	private String getXmlResource(String fileName) {
		StringBuffer sb = new StringBuffer();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(fileName));
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);
			String line;
			try {
				while ((line = bufferedReader.readLine()) != null) {
					sb.append(line);
				}
				bufferedReader.close();
				inputStreamReader.close();
				inputStream.close();
			} catch (IOException e) {
			} finally {
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * <div class="en">removes urn:oid: prefix of the given string</div> <div
	 * class="de"></div> <div class="fr"></div>
	 * 
	 * @param <div class="en">value string beginning with the urn:oid:
	 *        prefix</div> <div class="de"></div> <div class="fr"></div>
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
