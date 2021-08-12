/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
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
package org.ehealth_connector.converters.ch;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.AllergyConcern;
import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.ActiveProblemConcern;
import org.ehealth_connector.cda.ch.CodedResults;
import org.ehealth_connector.cda.ch.PastProblemConcern;
import org.ehealth_connector.cda.ch.PregnancyHistory;
import org.ehealth_connector.cda.ch.vacd.v140.CdaChVacd;
import org.ehealth_connector.cda.ch.vacd.v140.CriterionEntry;
import org.ehealth_connector.cda.ch.vacd.v140.Immunization;
import org.ehealth_connector.cda.ch.vacd.v140.ImmunizationRecommendation;
import org.ehealth_connector.cda.ch.vacd.v140.LaboratoryObservation;
import org.ehealth_connector.cda.ch.vacd.v140.MedicationTargetEntry;
import org.ehealth_connector.cda.enums.MedicationsSpecialConditions;
import org.ehealth_connector.common.mdht.Author;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.Value;
import org.ehealth_connector.common.mdht.enums.ObservationInterpretation;
import org.ehealth_connector.common.mdht.enums.Ucum;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.DateUtilMdht;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.fhir.structures.ch.FhirCdaChVacd.DocTypeCode;
import org.ehealth_connector.fhir.structures.ch.FhirCdaChVacd.VacdDocument;
import org.ehealth_connector.fhir.structures.gen.FhirCommon;
import org.hl7.fhir.dstu3.model.Basic;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.DocumentManifest;
import org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent;
import org.hl7.fhir.dstu3.model.Dosage;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.ListResource;
import org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent;
import org.hl7.fhir.dstu3.model.Medication;
import org.hl7.fhir.dstu3.model.MedicationStatement;
import org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementTaken;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent;
import org.hl7.fhir.dstu3.model.Organization;
import org.hl7.fhir.dstu3.model.Person;
import org.hl7.fhir.dstu3.model.Quantity;
import org.hl7.fhir.dstu3.model.Ratio;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.dstu3.model.TimeType;
import org.hl7.fhir.exceptions.FHIRException;
import org.openhealthtools.mdht.uml.hl7.datatypes.BL;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.INT;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

import ca.uhn.fhir.parser.IParser;

/**
 *
 * @author roeland
 * @version 1.0
 * @since Dec 30, 2017 10:22:34 PM
 *
 */
public class VacdConverter extends AbstractCdaChV12FhirConverter {

	/**
	 * <div class="en">Creates an eHC CdaChVacd instance from a valid FHIR
	 * resource</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @param docManifest
	 *            <div class="en">valid CdaChVacd FHIR resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param xsl
	 *            <div class="en">desired stylesheet for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param css
	 *            <div class="en">desired CSS for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC CdaChVacd instance containing payload of the
	 *         given FHIR resource</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChVacd createCdaChVacdFromFHIR(DocumentManifest docManifest, String xsl, String css) {
		// Header
		final CdaChVacd doc = new CdaChVacd(getDocLanguage(docManifest), xsl, css);
		final DocTypeCode docType = getVacdDocType(docManifest);
		doc.setId(getDocumentId(docManifest));
		doc.setSetId(getDocumentId(docManifest));
		doc.setTimestamp(getDocumentDate(docManifest));
		doc.setConfidentialityCode(getConfidentialityCode(docManifest));
		doc.setPatient(FhirCommon.getPatient(docManifest));
		if (docType == DocTypeCode.PSEUDONYMIZED)
			doc.pseudonymization();

		for (final Author author : getAuthors(docManifest)) {
			author.setTime(DateUtilMdht.date("15.12.2014"));
			doc.addAuthor(author);
		}
		doc.setCustodian(getCustodian(docManifest));
		doc.setLegalAuthenticator(getLegalAuthenticator(docManifest));

		// Body
		// Immunizations / Impfungen
		for (final Immunization immunization : getVacdImmunizations(docManifest)) {
			doc.addImmunization(immunization);
		}

		// Active Problems / Problemliste
		for (final ActiveProblemConcern activeProblemConcernEntry : getActiveProblemConcernEntries(
				docManifest)) {
			doc.addActiveProblemConcern(activeProblemConcernEntry);
		}

		// History of Past Illness / Bisherige Krankheiten/Anamnese
		for (final PastProblemConcern pastProblemConcern : getPastProblemConcernEntries(
				docManifest)) {
			doc.addPastProblemConcern(pastProblemConcern);
		}

		// Allergies and Basic Adverse Reactions / Allergien und
		// Unverträglichkeiten
		for (final AllergyConcern allergyProblemConcern : getAllergyProblemConcernEntries(
				docManifest)) {
			doc.addAllergyConcern(allergyProblemConcern);
		}

		// Coded Results for gestational age / Codierte Resultate für
		// Gestationsalter
		final CodedResults cr = getGestationalAge(docManifest);
		if (cr != null) {
			doc.addCodedResults(cr);
		}

		// Laboratory Specialty Section / Relevante Laborbefunde
		for (final LaboratoryObservation laboratoryObservation : getVacdLaboratoryObservations(
				docManifest)) {
			doc.addLaboratoryObservation(laboratoryObservation);
		}

		// Schwangerschaftsanamnese
		// Coded Results for gestational age / Codierte Resultate für
		// Gestationsalter
		final PregnancyHistory ph = getPregnancyHistory(docManifest);
		if (ph != null) {
			doc.addPregnancyHistory(ph);
		}

		for (final ImmunizationRecommendation immunizationRecommendation : getImmunizationRecommendations(
				docManifest)) {
			doc.addImmunizationRecommendation(immunizationRecommendation);
		}

		doc.addComment(getComment(docManifest));

		return doc;
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
	public org.ehealth_connector.common.mdht.Author getAuthor(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.common.mdht.Author retVal = null;
		for (final Reference ref : fhirMedicationStatement.getDerivedFrom()) {
			final List<org.hl7.fhir.dstu3.model.Extension> extensions = ref
					.getExtensionsByUrl(FhirCommon.urnUseAsAuthor);
			if (!extensions.isEmpty() && (ref.getResource() instanceof Person)) {
				retVal = FhirCommon.getAuthor((Person) ref.getResource());
				if (extensions.get(0).getValue() instanceof TimeType) {
					final TimeType timeStamp = ((TimeType) extensions.get(0).getValue());
					if (timeStamp.getValue().length() > 8)
						retVal.setTime(DateUtil.parseDateyyyyMMddHHmmssZZZZ(timeStamp.getValue()));

					else
						retVal.setTime(DateUtil.parseDateyyyyMMdd(timeStamp.getValue()));
					break;
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets the code of the given medication
	 *
	 * @param fhirMedicationStatement
	 *            the FHIR resource
	 * @return the code of the given medication
	 */
	private Code getCode(MedicationStatement fhirMedicationStatement) {
		Code retVal = null;
		if (!fhirMedicationStatement.getExtensionsByUrl(FhirCommon.urnUseAsCode).isEmpty()) {
			final Coding fhirCode = (Coding) fhirMedicationStatement
					.getExtensionsByUrl(FhirCommon.urnUseAsCode).get(0).getValue();
			retVal = new Code(FhirCommon.removeUrnOidPrefix(fhirCode.getSystem()),
					fhirCode.getCode(), fhirCode.getDisplay());
		}
		return retVal;
	}

	/**
	 * Gets the Consumable of the given medication
	 *
	 * @param fhirMedicationStatement
	 *            the FHIR resource
	 * @return the Consumable of the given medication
	 */
	private org.ehealth_connector.cda.Consumable getConsumable(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.cda.Consumable retVal = null;

		if (fhirMedicationStatement.getMedication() instanceof Reference) {
			final Reference ref = (Reference) fhirMedicationStatement.getMedication();
			final Medication fhirMedi = (Medication) ref.getResource();
			// Create the consumable
			retVal = new org.ehealth_connector.cda.Consumable(fhirMedi.getCode().getText());

			// Set id
			if (!fhirMedi.getExtensionsByUrl(FhirCommon.urnUseAsIdentifier).isEmpty()) {
				final Identifier id = (Identifier) fhirMedi
						.getExtensionsByUrl(FhirCommon.urnUseAsIdentifier).get(0).getValue();
				retVal.setManufacturedProductId(new org.ehealth_connector.common.mdht.Identificator(
						FhirCommon.removeUrnOidPrefix(id.getSystem()), id.getValue()));
			}

			// Set code
			final Coding fhirCode = fhirMedi.getCode().getCodingFirstRep();
			final Code code = new Code(FhirCommon.removeUrnOidPrefix(fhirCode.getSystem()),
					fhirCode.getCode(), fhirCode.getDisplay());
			retVal.setWhoAtcCode(code);

			// Set manufacturer
			final Reference refManufacturer = fhirMedi.getManufacturer();
			retVal.setManufacturer(FhirCommon.getOrganization(refManufacturer.getResource()));

			// LotNumber
			retVal.setLotNr(getLot(fhirMedicationStatement));
		} else {
			// Create the consumable
			retVal = new org.ehealth_connector.cda.Consumable(false);
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
		for (final Reference ref : fhirMedicationStatement.getDerivedFrom()) {
			if (!ref.getExtensionsByUrl(FhirCommon.urnUseAsCriterion).isEmpty()) {
				retVal = (ListResource) ref.getResource();
				break;
			}
		}
		return retVal;
	}

	/**
	 * Gets the Immunization Recommendation
	 *
	 * @param fhirMedicationStatement
	 *            the FHIR resource
	 * @return the Immunization Recommendation
	 */
	private org.ehealth_connector.cda.ch.vacd.v140.ImmunizationRecommendation getImmunizationRecommendation(
			MedicationStatement fhirMedicationStatement) {
		org.ehealth_connector.cda.ch.vacd.v140.ImmunizationRecommendation retVal = null;

		// Create the immunization
		retVal = new org.ehealth_connector.cda.ch.vacd.v140.ImmunizationRecommendation();

		// Add Identifiers
		for (final Identifier id : fhirMedicationStatement.getIdentifier()) {
			final String codeSystem = FhirCommon.removeUrnOidPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// Date
		retVal.setPossibleAppliance(fhirMedicationStatement.getDateAsserted(), null);

		// code
		final Code code = getCode(fhirMedicationStatement);
		final MedicationsSpecialConditions specialConditions = MedicationsSpecialConditions
				.getEnum(code.getCode());
		if (specialConditions != null) {
			retVal.setCode(specialConditions);
		} else {
			// code
			if (fhirMedicationStatement.getMedication() instanceof CodeableConcept) {
				final CodeableConcept cc = (CodeableConcept) fhirMedicationStatement
						.getMedication();

				retVal.setCode(
						MedicationsSpecialConditions.getEnum(cc.getCodingFirstRep().getCode()));
			} else {
				if (fhirMedicationStatement.getTaken() == MedicationStatementTaken.N)
					retVal.setShallNotBeAdministerd();

				// doseQuantity
				Double doseQuantity = null;
				for (final Dosage dosage : fhirMedicationStatement.getDosage()) {
					try {
						doseQuantity = ((Quantity) dosage.getDoseSimpleQuantity()).getValue()
								.doubleValue();
						retVal.setDosage(doseQuantity);
					} catch (final FHIRException e) {
					}
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
		for (final ListEntryComponent listEntry : medicationTargets.getEntry()) {
			final Reference ref = listEntry.getItem();
			final Observation fhirObs = (Observation) ref.getResource();
			final Coding fhirCode = fhirObs.getCode().getCodingFirstRep();
			final MedicationTargetEntry entry = new MedicationTargetEntry();
			entry.setId(new Identificator(
					fhirObs.getIdentifierFirstRep().getSystem().replace(FhirCommon.oidUrn, ""),
					fhirObs.getIdentifierFirstRep().getValue()));
			entry.setImmunizationTargetCode(
					new Code(FhirCommon.removeUrnOidPrefix(fhirCode.getSystem()),
							fhirCode.getCode(), fhirCode.getDisplay()));
			retVal.addMedicationTargetEntry(entry);
		}

		// criterion
		final ListResource criterions = getCriterions(fhirMedicationStatement);
		for (final ListEntryComponent listEntry : criterions.getEntry()) {
			final Reference ref = listEntry.getItem();
			final Observation fhirObs = (Observation) ref.getResource();
			final Coding fhirCode = fhirObs.getCode().getCodingFirstRep();
			final CriterionEntry entry = new CriterionEntry();
			entry.setRecCategoryCode(new Code(FhirCommon.removeUrnOidPrefix(fhirCode.getSystem()),
					fhirCode.getCode(), fhirCode.getDisplay()));
			retVal.setCriterionEntry(entry);
		}

		// comment
		retVal.setCommentText(getComment(fhirMedicationStatement));

		return retVal;

	}

	/**
	 * <div class="en">Gets a list of eHC ImmunizationRecommendations from the
	 * given FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return list of eHC ImmunizationRecommendations </div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public List<org.ehealth_connector.cda.ch.vacd.v140.ImmunizationRecommendation> getImmunizationRecommendations(
			DocumentManifest docManifest) {
		final List<org.ehealth_connector.cda.ch.vacd.v140.ImmunizationRecommendation> retVal = new ArrayList<>();
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsImmunizationRecommendation)
					.isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (final FHIRException e) {
				}
				if (ref != null) {
					if (ref.getResource() instanceof MedicationStatement) {
						final MedicationStatement fhirObject = (MedicationStatement) ref
								.getResource();
						final ImmunizationRecommendation recom = getImmunizationRecommendation(
								fhirObject);
						retVal.add(recom);
					}
				}
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
		for (final Reference ref : fhirMedicationStatement.getDerivedFrom()) {
			if (!ref.getExtensionsByUrl(FhirCommon.urnUseAsMedicationTarget).isEmpty()) {
				retVal = (ListResource) ref.getResource();
			}
		}
		return retVal;
	}

	/**
	 * <div class="en"> Gets the eHC Vacd document type code (full or masked
	 * patient demographics) from the given FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return eHC Vacd document type code (full or masked patient
	 *         demographics)</div> <div class="de"></div> <div class="fr"></div>
	 */
	public DocTypeCode getVacdDocType(DocumentManifest docManifest) {

		DocTypeCode retVal = DocTypeCode.PATIENT; // default
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsDocType).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (final FHIRException e) {
				}
				if (ref != null) {
					if (ref.getResource() instanceof Basic) {
						final Basic fhirBasic = (Basic) ref.getResource();
						final Coding langCode = fhirBasic.getCode().getCodingFirstRep();
						if (FhirCommon.addUrnOid(CdaChVacd.OID_MAIN).equals(langCode.getSystem())) {
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
			}
		}
		return retVal;
	}

	/**
	 * Gets the VACD Immunization
	 *
	 * @param fhirMedicationStatement
	 *            the FHIR resource
	 * @return the VACD Immunization
	 */
	private org.ehealth_connector.cda.ch.vacd.v140.Immunization getVacdImmunization(
			MedicationStatement fhirMedicationStatement) {

		final Code code = getCode(fhirMedicationStatement);

		// Create the immunization
		final org.ehealth_connector.cda.ch.vacd.v140.Immunization retVal = new org.ehealth_connector.cda.ch.vacd.v140.Immunization();

		// Add Identifiers
		retVal.getMdht().getIds().clear();
		for (final Identifier id : fhirMedicationStatement.getIdentifier()) {
			final String codeSystem = FhirCommon.removeUrnOidPrefix(id.getSystem());
			retVal.addId(new Identificator(codeSystem, id.getValue()));
		}

		// author
		retVal.setAuthor(getAuthor(fhirMedicationStatement));

		if (!"IMMUNIZ".equals(code.getCode())) {
			// code
			retVal.setCode(MedicationsSpecialConditions.getEnum(code.getCode()));
		} else {
			// code
			if (fhirMedicationStatement.getMedication() instanceof CodeableConcept) {
				final CodeableConcept cc = (CodeableConcept) fhirMedicationStatement
						.getMedication();

				retVal.setCode(
						MedicationsSpecialConditions.getEnum(cc.getCodingFirstRep().getCode()));
			}

			// effectiveTime
			retVal.setApplyDate(fhirMedicationStatement.getDateAsserted());

			// doseQuantity
			Double doseQuantity = null;
			for (final Dosage dosage : fhirMedicationStatement.getDosage()) {
				try {
					doseQuantity = ((Quantity) dosage.getDoseSimpleQuantity()).getValue()
							.doubleValue();
					retVal.setDosage(doseQuantity);
				} catch (final FHIRException e) {
				}
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
			for (final ListEntryComponent listEntry : medicationTargets.getEntry()) {
				final Reference ref = listEntry.getItem();
				final Observation fhirObs = (Observation) ref.getResource();
				final Coding fhirCode = fhirObs.getCode().getCodingFirstRep();
				final MedicationTargetEntry entry = new MedicationTargetEntry();
				entry.setId(new Identificator(
						fhirObs.getIdentifierFirstRep().getSystem().replace(FhirCommon.oidUrn, ""),
						fhirObs.getIdentifierFirstRep().getValue()));
				entry.setImmunizationTargetCode(
						new Code(FhirCommon.removeUrnOidPrefix(fhirCode.getSystem()),
								fhirCode.getCode(), fhirCode.getDisplay()));
				retVal.addMedicationTargetEntry(entry);
			}

			// criterion
			final ListResource criterions = getCriterions(fhirMedicationStatement);
			for (final ListEntryComponent listEntry : criterions.getEntry()) {
				final Reference ref = listEntry.getItem();
				final Observation fhirObs = (Observation) ref.getResource();
				final Coding fhirCode = fhirObs.getCode().getCodingFirstRep();
				final CriterionEntry entry = new CriterionEntry();
				entry.setRecCategoryCode(
						new Code(FhirCommon.removeUrnOidPrefix(fhirCode.getSystem()),
								fhirCode.getCode(), fhirCode.getDisplay()));
				retVal.setCriterionEntry(entry);
			}

			// comment
			retVal.setCommentText(getComment(fhirMedicationStatement));

		}

		return retVal;

	}

	//
	/**
	 * <div class="en">Gets a list of eHC Immunizations from the given FHIR
	 * resource
	 *
	 * @param docManifest
	 *            FHIR resource
	 * @return list of eHC Immunizations </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.cda.ch.vacd.v140.Immunization> getVacdImmunizations(
			DocumentManifest docManifest) {
		final List<org.ehealth_connector.cda.ch.vacd.v140.Immunization> retVal = new ArrayList<>();
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsImmunization).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (final FHIRException e) {
				}
				if (ref != null) {
					retVal.add(getVacdImmunization((MedicationStatement) ref.getResource()));
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets the VACD Laboratory Observation
	 *
	 * @param fhirObservation
	 *            the FHIR resource
	 * @return the VACD Laboratory Observation
	 */
	private org.ehealth_connector.cda.ch.vacd.v140.LaboratoryObservation getVacdLaboratoryObservation(
			Observation fhirObservation) {
		final org.ehealth_connector.cda.ch.vacd.v140.LaboratoryObservation retVal = new LaboratoryObservation();

		// TODO better inheritance: this code is copied from
		// AbstractFhirCdaCh

		fhirObservation.getCode().getCodingFirstRep();
		retVal.setCode(FhirCommon.fhirCodeToEhcCode(fhirObservation.getCode()));
		if (fhirObservation.getIssued() != null) {
			retVal.setEffectiveTime(fhirObservation.getIssued());
		}
		if (!fhirObservation.getPerformer().isEmpty()) {
			final Reference refPerf = fhirObservation.getPerformer().get(0);
			retVal.setLaboratory(FhirCommon.getOrganization((Organization) refPerf.getResource()),
					fhirObservation.getIssued());
		}
		Value v = null;
		// type PQ
		if (fhirObservation.getValue() instanceof Quantity) {
			final Quantity fhirQuantity = (Quantity) fhirObservation.getValue();
			v = new Value(fhirQuantity.getValue().toString(), Ucum.AHGEquivalentsPerMilliLiter);

			// fix for the bug(?), which ommits the unit when it´s set to
			// "1"
			// Seems to be a bug in the MDHT. Ucum Unit can´t be set to "1".
			// unit = fhirQuantity.getUnit().replace("#", "");
			String unit;
			if (fhirQuantity.getUnit().startsWith("#")) {
				unit = fhirQuantity.getUnit();
			} else {
				unit = fhirQuantity.getUnit();
			}
			v.setUcumUnit(unit);
		}
		// type String
		if (fhirObservation.getValue() instanceof StringType) {
			final StringType fhirString = (StringType) fhirObservation.getValue();
			// type BL
			if (fhirString.getValueAsString().equalsIgnoreCase("false")
					|| fhirString.getValueAsString().equalsIgnoreCase("true")
					|| fhirString.getValueAsString().equalsIgnoreCase("NA")) {
				if (!fhirObservation.getDataAbsentReason().isEmpty()) {
					final BL bl = DatatypesFactory.eINSTANCE.createBL();
					bl.setNullFlavor(NullFlavor.NA);
					v = new Value(bl);
				} else {
					if (fhirString.getValueAsString().equalsIgnoreCase("true")) {
						v = new Value(true);
					}
					if (fhirString.getValueAsString().equalsIgnoreCase("false")) {
						v = new Value(false);
					}
					if (fhirString.getValueAsString().equalsIgnoreCase("NA")) {
						final BL bl = DatatypesFactory.eINSTANCE.createBL();
						bl.setNullFlavor(NullFlavor.NA);
						v = new Value(bl);
					}
				}
			}
			if (fhirString.getValue().startsWith("INT:")) {
				if (fhirString.getValue().startsWith("INT:NA")) {
					final INT intValue = DatatypesFactory.eINSTANCE.createINT();
					intValue.setNullFlavor(NullFlavor.NA);
					v = new Value(intValue);
				} else {
					v = new Value(Integer.parseInt(fhirString.getValue().replace("INT:", "")));
				}
			}
			if (fhirString.getValue().startsWith("ED:")) {
				if (fhirString.getValue().startsWith("ED:#")) {
					final ED edValue = Util
							.createReference(fhirString.getValue().replace("ED:", ""));
					v = new Value(edValue);
				} else {
					v = new Value(Integer.parseInt(fhirString.getValue().replace("INT:", "")));
				}
			}
			if (fhirString.getValue().startsWith("ST:")) {
				if (fhirString.getValue().startsWith("ST:NA")) {
					final ST stValue = DatatypesFactory.eINSTANCE.createST();
					stValue.setNullFlavor(NullFlavor.NA);
					v = new Value(stValue);
				} else {
					final ST stValue = DatatypesFactory.eINSTANCE
							.createST(fhirString.getValue().replace("ST:", ""));
					v = new Value(stValue);
				}
			}
		}
		// type CD
		if (fhirObservation.getValue() instanceof CodeableConcept)

		{
			final Coding fhirValueCode = ((CodeableConcept) fhirObservation.getValue())
					.getCodingFirstRep();
			retVal.addValue(
					new Code(new Code(FhirCommon.removeUrnOidPrefix(fhirValueCode.getSystem()),
							fhirValueCode.getCode(), fhirValueCode.getDisplay())));
		}
		if (fhirObservation.getValue() instanceof Ratio) {
			// type RTO not yet implemented
		}
		if (v != null) {
			retVal.addValue(v);
		}

		// ReferenceRange
		if (!fhirObservation.getReferenceRange().isEmpty()) {
			final org.ehealth_connector.common.mdht.ReferenceRange rr = new org.ehealth_connector.common.mdht.ReferenceRange();
			// Value
			if ((fhirObservation.getReferenceRangeFirstRep().getLow().getUnit() != null)
					&& (fhirObservation.getReferenceRangeFirstRep().getHigh().getUnit() != null)) {
				v = new Value(fhirObservation.getReferenceRangeFirstRep().getLow().getValue(),
						fhirObservation.getReferenceRangeFirstRep().getLow().getUnit(),
						fhirObservation.getReferenceRangeFirstRep().getHigh().getValue(),
						fhirObservation.getReferenceRangeFirstRep().getHigh().getUnit());
			} else {
				v = new Value(
						fhirObservation.getReferenceRangeFirstRep().getLow().getValue()
								.toBigInteger(),
						fhirObservation.getReferenceRangeFirstRep().getHigh().getValue()
								.toBigInteger());
			}

			rr.setValue(v);

			// Interpretation of the reference range
			ObservationInterpretation obsInt = null;
			if (fhirObservation.getReferenceRangeFirstRep().getAppliesTo() != null) {
				if (fhirObservation.getReferenceRangeFirstRep().getAppliesTo().size() > 0) {
					if (fhirObservation.getReferenceRangeFirstRep().getAppliesTo().get(0) != null) {
						if (fhirObservation.getReferenceRangeFirstRep().getAppliesTo().get(0)
								.getCodingFirstRep() != null) {
							final String code = fhirObservation.getReferenceRangeFirstRep()
									.getAppliesTo().get(0).getCodingFirstRep().getCode();
							obsInt = ObservationInterpretation.getEnum(code);
						}
					}
				}
			}
			if (obsInt != null) {
				rr.setInterpretation(obsInt);
			}
			retVal.setReferenceRange(rr);
		}

		// Interpretation of the observation
		retVal.getMdhtLaboratoryObservation().getInterpretationCodes().clear();
		final Coding fhirInterpretationCode = fhirObservation.getInterpretation()
				.getCodingFirstRep();
		if (fhirInterpretationCode != null) {
			if (fhirInterpretationCode.getSystem() != null) {
				retVal.addInterpretationCode(new Code(
						FhirCommon.removeUrnOidPrefix(fhirInterpretationCode.getSystem()),
						fhirInterpretationCode.getCode(), fhirInterpretationCode.getDisplay()));
			} else
				retVal.addInterpretationCode(NullFlavor.NA);
		}
		// Text reference (inside the observation)
		if ((fhirObservation.getComment() != null) && !fhirObservation.getComment().isEmpty()) {
			retVal.setTextReference(fhirObservation.getComment());
		}

		// Comments
		for (final ObservationRelatedComponent commentRef : fhirObservation.getRelated()) {
			if (commentRef.getTarget().getResource() instanceof Observation) {
				final Observation comment = (Observation) commentRef.getTarget().getResource();
				if (comment.getComment() != null) {
					retVal.addCommentEntry(new SectionAnnotationCommentEntry(comment.getComment()));
				}
			}
		}

		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC LaboratoryObservations from the given
	 * FHIR resource
	 *
	 * @param docManifest
	 *            FHIR resource
	 * @return list of eHC LaboratoryObservations </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public List<org.ehealth_connector.cda.ch.vacd.v140.LaboratoryObservation> getVacdLaboratoryObservations(
			DocumentManifest docManifest) {
		final List<org.ehealth_connector.cda.ch.vacd.v140.LaboratoryObservation> retVal = new ArrayList<>();

		// TODO better inheritance: this code is copied from
		// AbstractFhirCdaCh

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsLaboratoryObservation).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (final FHIRException e) {
				}
				if (ref != null) {
					if (ref.getResource() instanceof Observation) {
						retVal.add(getVacdLaboratoryObservation((Observation) ref.getResource()));
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * Read the VacdDocument object from the FHIR resource file
	 *
	 * @param fileName
	 *            the file name
	 * @return the vacd document
	 */
	public VacdDocument readVacDocumentFromFile(String fileName) {
		final String resourceString = FhirCommon.getXmlResource(fileName);
		final IParser parser = getFhirCtx().newXmlParser();
		return parser.parseResource(VacdDocument.class, resourceString);
	}
}
