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
package org.ehealth_connector.converters.ch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.ParticipantClaimer;
import org.ehealth_connector.cda.ch.lab.BaseChSpecimenAct;
import org.ehealth_connector.cda.ch.lab.SpecimenCollectionEntry;
import org.ehealth_connector.cda.ch.lab.lrqc.CdaChLrqc;
import org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryBatteryOrganizer;
import org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryObservation;
import org.ehealth_connector.cda.ch.lab.lrqc.LaboratorySpecialtySection;
import org.ehealth_connector.cda.ihe.lab.NonHumanSubject;
import org.ehealth_connector.cda.ihe.lab.SpecimenReceivedEntry;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Author;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.IntendedRecipient;
import org.ehealth_connector.common.mdht.Value;
import org.ehealth_connector.common.mdht.enums.ObservationInterpretation;
import org.ehealth_connector.common.mdht.enums.StatusCode;
import org.ehealth_connector.common.mdht.enums.Ucum;
import org.ehealth_connector.common.utils.DateUtilOld;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.fhir.structures.ch.FhirCdaChLrqc.LrqcDocument;
import org.ehealth_connector.fhir.structures.gen.FhirCommon;
import org.ehealth_connector.fhir.structures.utils.FhirUtilities;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.DocumentManifest;
import org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent;
import org.hl7.fhir.dstu3.model.Organization;
import org.hl7.fhir.dstu3.model.Practitioner;
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
 * @since Dec 30, 2017 10:15:32 PM
 *
 */
@SuppressWarnings("deprecation")
public class LrqcConverter extends AbstractCdaChV12FhirConverter {

	/**
	 * <div class="en">Creates an eHC CdaChLrqc instance from a valid FHIR
	 * resource</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @param docManifest
	 *            <div class="en">valid CdaChLrqc FHIR resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param xsl
	 *            <div class="en">desired stylesheet for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param css
	 *            <div class="en">desired CSS for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC CdaChLrqc instance containing payload of the
	 *         given FHIR resource</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChLrqc createCdaChLrqcFromFhir(DocumentManifest docManifest, String xsl, String css) {

		// Header
		final CdaChLrqc doc = new CdaChLrqc(getDocLanguage(docManifest), xsl, css);
		doc.setId(getDocumentId(docManifest));
		doc.setSetId(getDocumentId(docManifest));
		doc.setTimestamp(getDocumentDate(docManifest));
		doc.setConfidentialityCode(getConfidentialityCode(docManifest));
		// RecordTarget
		doc.setPatient(FhirCommon.getPatient(docManifest));
		// ReferralOrderingPhysician
		doc.addReferralOrderingPhysician(getReferralOrderingPhysician(docManifest));
		// Authors
		for (final Author author : getAuthors(docManifest)) {
			doc.addAuthor(author);
		}
		// LegalAuthenticator
		final Author legalAuth = getLegalAuthenticator(docManifest);
		if (legalAuth != null) {
			doc.setLegalAuthenticator(legalAuth);
		}
		// Participant Claims
		final List<ParticipantClaimer> participantsList = getClaimers(docManifest);
		for (final ParticipantClaimer p : participantsList) {
			doc.addParticipant(p);
		}
		// Custodian
		doc.setCustodian(getCustodian(docManifest));
		// IntendedRecipient
		final IntendedRecipient ir = getIntendedRecipient(docManifest);
		doc.addIntendedRecipient(ir);
		// InFulfillmentOf
		final Identificator ifoId = getInFulfillmentOf(docManifest);
		if (ifoId != null) {
			doc.addInFulfillmentOfOrder(ifoId);
		}
		// RelatedDocument
		final Identificator relatedDocument = getRelatedDocument(docManifest);
		if (relatedDocument != null) {
			doc.setDocumentToReplaceIdentifier(relatedDocument);
		}
		// DocVersion
		final Integer docVersion = getDocVersion(docManifest);
		if (docVersion != null) {
			doc.setVersion(null, docVersion);
		}

		// Body
		// Laboratory SpecialtySections
		final List<LaboratorySpecialtySection> lssList = getLrqcLaboratorySpecialtySections(
				docManifest);
		final Code sectionCode = lssList.get(0).getCode();

		// Laboratory Battery Organizers
		final List<LaboratoryBatteryOrganizer> laboratoryBatteryOrganizers = getLrqcLaboratoryBatteryOrganizers(
				docManifest);
		if ((laboratoryBatteryOrganizers != null) && !laboratoryBatteryOrganizers.isEmpty()) {
			for (final LaboratoryBatteryOrganizer lbo : laboratoryBatteryOrganizers) {
				doc.addLaboratoryBatteryOrganizer(lbo, sectionCode);
			}
		}

		final BaseChSpecimenAct specimenAct = doc.getSpecimenAct();
		if (specimenAct != null) {
			// SpecimenCollection
			doc.getSpecimenAct()
					.setSpecimenCollectionEntry(getSpecimenCollectionEntry(docManifest));

			// SpecimenReceived
			final SpecimenCollectionEntry sce = doc.getSpecimenAct().getSpecimenCollectionEntry();
			if (sce != null)
				sce.setSpecimenReceivedEntry(getSpecimenReceivedEntry(docManifest));
		}

		// NonHumanSubject
		final NonHumanSubject nhs = getNonLivingSubject(docManifest);
		if (nhs != null) {
			doc.getSpecimenAct().setNonHumanSubject(nhs);
		}

		// LaboratorySpecialtySection
		if (doc.isNarrativeTextGenerationEnabled()) {
			doc.setNarrativeTextSectionLaboratorySpeciality(
					doc.generateNarrativeTextLaboratoryObservations(1, "lss", null));
		} else {
			final String narrative = getNarrative(docManifest,
					FhirCommon.urnUseAsLaboratorySpecialtySection);
			doc.setNarrativeTextSectionLaboratorySpeciality(narrative);
		}

		return doc;
	}

	/**
	 * <div class="en">Gets a list of eHC LaboratoryBatteryOrganizers from the
	 * given FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return list of eHC LaboratoryBatteryOrganizers</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	protected List<LaboratoryBatteryOrganizer> getLrqcLaboratoryBatteryOrganizers(
			DocumentManifest docManifest) {
		final List<LaboratoryBatteryOrganizer> retVal = new ArrayList<>();

		// TODO better inheritance: this code is copied from
		// AbstractFhirCdaCh.getLaboratoryBatteryOrganizers

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsLaboratoryBatteryOrganizer)
					.isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (final FHIRException e) {
				}
				if (ref != null) {
					final LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
					final Observation obs = (Observation) ref.getResource();

					// Set the Organizer Attributes
					// Status Code
					final String statusCode = getValueFromKeyValueString(obs, "statusCode");
					if (statusCode != null) {
						lbo.setStatusCode(StatusCode.getEnum(statusCode));
					}

					// Organizer Id
					if (!obs.getIdentifier().isEmpty()) {
						final Identificator id = FhirUtilities
								.toIdentificator(obs.getIdentifierFirstRep());
						id.setRoot(id.getRoot().replace(FhirCommon.oidUrn, ""));
						lbo.getMdht().getIds().add(id.getIi());
					}

					// Authors
					for (final Reference perfRef : obs.getPerformer()) {
						final Practitioner p = (Practitioner) perfRef.getResource();
						final Author author = new Author();
						author.addId(FhirCommon
								.fhirIdentifierToEhcIdentificator(p.getIdentifierFirstRep()));
						final List<org.hl7.fhir.dstu3.model.Extension> extensions = perfRef
								.getExtensionsByUrl(FhirCommon.urnUseAsAuthor);
						if (!extensions.isEmpty()) {
							final TimeType t = (TimeType) extensions.get(0).getValue();
							author.setTime(DateUtilOld.parseDates(t.getValue()));
						}
						lbo.addAuthor(author);
					}

					// EffectiveTime
					final DateTimeType fTime = (DateTimeType) obs.getEffective();
					if (fTime != null)
						lbo.setEffectiveTime(fTime.getValue());

					// Add all LaboratoryObservations
					for (final ObservationRelatedComponent relatedObs : obs.getRelated()) {
						final Observation fhirObs = (org.hl7.fhir.dstu3.model.Observation) relatedObs
								.getTarget().getResource();
						final LaboratoryObservation labObs = getLrqcLaboratoryObservation(fhirObs);
						lbo.addLaboratoryObservation(labObs);
					}
					retVal.add(lbo);
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC LRQC LaboratoryBatteryOrganizers from
	 * the given FHIR resource
	 *
	 * @param fhirObs2
	 *            the FHIR resource
	 * @return list of eHC LRQC LaboratoryBatteryOrganizers</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	private org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryBatteryOrganizer getLrqcLaboratoryBatteryOrganizers(
			Observation labObsList) {
		final LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();

		// TODO better inheritance: this code is copied from
		// AbstractFhirCdaCh.getLaboratoryBatteryOrganizers

		// Set the Organizer Attributes
		// Status Code
		final String statusCode = getValueFromKeyValueString(labObsList, "statusCode");
		if (statusCode != null) {
			lbo.setStatusCode(StatusCode.getEnum(statusCode));
		}
		// EffectiveTime
		final DateTimeType fTime = (DateTimeType) labObsList.getEffective();
		if (fTime != null)
			lbo.setEffectiveTime(fTime.getValue());

		// Authors
		for (final Reference perfRef : labObsList.getPerformer()) {
			final Practitioner p = (Practitioner) perfRef.getResource();
			final Author author = new Author();
			author.addId(FhirCommon.fhirIdentifierToEhcIdentificator(p.getIdentifierFirstRep()));
			final List<org.hl7.fhir.dstu3.model.Extension> extensions = labObsList
					.getExtensionsByUrl(FhirCommon.urnUseAsAuthor);
			if (!extensions.isEmpty()) {
				final TimeType t = (TimeType) extensions.get(0).getValue();
				author.setTime(DateUtilOld.parseDates(t.getValue()));
			}
			lbo.addAuthor(author);
		}

		// Add all LaboratoryObservations
		for (final ObservationRelatedComponent relatedObs : labObsList.getRelated()) {
			final Observation fhirObs = (Observation) relatedObs.getTarget().getResource();
			final LaboratoryObservation labObs = getLrqcLaboratoryObservation(fhirObs);
			lbo.addLaboratoryObservation(labObs);
		}
		return lbo;
	}

	/**
	 * Gets the LRQC Laboratory Observation
	 *
	 * @param fhirObservation
	 *            the FHIR resource
	 * @return the LRQC Laboratory Observation
	 */
	protected LaboratoryObservation getLrqcLaboratoryObservation(Observation fhirObservation) {
		final LaboratoryObservation retVal = new LaboratoryObservation();

		// TODO better inheritance: this code is copied from
		// AbstractFhirCdaCh.getLaboratoryBatteryOrganizers

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
		if ((fhirObservation.getComment() != null) && !fhirObservation.getComment().isEmpty())

		{
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
	 * Gets a list of the LRQC Laboratory Specialty Sections
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the LRQC Laboratory Specialty Sections
	 */
	protected List<LaboratorySpecialtySection> getLrqcLaboratorySpecialtySections(
			DocumentManifest docManifest) {

		// TODO better inheritance: this code is copied from
		// AbstractFhirCdaCh.getLaboratorySpecialtySections
		final List<LaboratorySpecialtySection> lssList = new ArrayList<>();

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			final List<org.hl7.fhir.dstu3.model.Extension> extensions = entry
					.getExtensionsByUrl(FhirCommon.urnUseAsLaboratorySpecialtySection);
			if (!extensions.isEmpty()) {
				Reference ref = null;
				try {
					if (entry.hasPReference())
						ref = entry.getPReference();
				} catch (final FHIRException e) {
				}
				if (ref != null) {
					final Observation obs = (Observation) ref.getResource();

					// SectionCode
					final Code code = FhirCommon.fhirCodeToEhcCode(obs.getCode());
					code.setCodeSystemName("LOINC");
					final org.ehealth_connector.cda.ch.lab.lrqc.LaboratorySpecialtySection lss = new org.ehealth_connector.cda.ch.lab.lrqc.LaboratorySpecialtySection(
							code, LanguageCode.getEnum(docManifest.getLanguage()));

					// Add all LaboratoryBatteryOrganizers
					final BaseChSpecimenAct spa = new BaseChSpecimenAct();
					spa.setCode(code);
					for (final ObservationRelatedComponent relatedObs : obs.getRelated()) {
						final Observation fhirObs = (Observation) relatedObs.getTarget()
								.getResource();
						spa.addLaboratoryBatteryOrganizer(
								getLrqcLaboratoryBatteryOrganizers(fhirObs));
					}
					lss.setLaboratoryReportDataProcessingEntry(
							new org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryReportDataProcessingEntry(
									spa));

					// NarrativeText
					lss.setText(obs.getCategoryFirstRep().getCodingFirstRep().getDisplay());
					lssList.add(lss);
				}
			}
		}
		return lssList;
	}

	/**
	 * Gets the specimen received entry.
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the specimen received entry
	 */
	protected SpecimenReceivedEntry getLrqcSpecimenReceivedEntry(DocumentManifest docManifest) {
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsSpecimenReceived).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (final FHIRException e) {
				}
				if (ref != null) {
					final Observation obs = (Observation) ref.getResource();
					final SpecimenReceivedEntry sce = new SpecimenReceivedEntry();

					final Identificator id = FhirCommon
							.fhirIdentifierToEhcIdentificator(obs.getIdentifierFirstRep());
					if (id != null) {
						sce.addId(id);
					} else {
						final org.openhealthtools.mdht.uml.hl7.datatypes.II ii = DatatypesFactory.eINSTANCE
								.createII();
						ii.setNullFlavor(NullFlavor.NA);
						sce.addId(new Identificator(ii));
					}
					final DateTimeType fDate = (DateTimeType) obs.getEffective();
					if (fDate != null) {
						final Date date = fDate.getValue();
						sce.setEffectiveTime(date);
					}

					return sce;
				}
			}
		}

		return null;
	}

	/**
	 * Read the LrqcDocument object from the FHIR resource file
	 *
	 * @param fileName
	 *            the file name
	 * @return the LRQC document
	 */
	public LrqcDocument readLrqcDocumentFromFile(String fileName) {
		final String resourceString = FhirCommon.getXmlResource(fileName);
		final IParser parser = getFhirCtx().newXmlParser();
		return parser.parseResource(LrqcDocument.class, resourceString);
	}
}
