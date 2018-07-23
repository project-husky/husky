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

import org.ehealth_connector.cda.AllergyConcern;
import org.ehealth_connector.cda.ch.PastProblemConcern;
import org.ehealth_connector.cda.ch.edes.CdaChEdesCtnn;
import org.ehealth_connector.cda.ch.edes.VitalSignObservation;
import org.ehealth_connector.cda.ch.edes.VitalSignsOrganizer;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.fhir.structures.ch.FhirCdaChEdesCtnn.EdesCtnnDocument;
import org.ehealth_connector.fhir.structures.gen.FhirCommon;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.DocumentManifest;
import org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.ListResource;
import org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent;
import org.hl7.fhir.dstu3.model.Person;
import org.hl7.fhir.dstu3.model.Quantity;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.TimeType;
import org.hl7.fhir.dstu3.model.Type;
import org.hl7.fhir.exceptions.FHIRException;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;

import ca.uhn.fhir.parser.IParser;

/**
 *
 * @author roeland
 * @version 1.0
 * @since Dec 30, 2017 9:56:31 PM
 *
 */
public class EdesCtnnConverter extends AbstractCdaChV12FhirConverter {

	/**
	 * <div class="en">Creates an eHC CdaChEdesCtnn instance from a valid FHIR
	 * resource</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @param docManifest
	 *            <div class="en">valid CdaChEdesCtnn FHIR resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param xsl
	 *            <div class="en">desired stylesheet for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param css
	 *            <div class="en">desired CSS for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC CdaChEdesCtnn instance containing payload of
	 *         the given FHIR resource</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChEdesCtnn createEdesCtnnFromFhir(EdesCtnnDocument docManifest, String xsl,
			String css) {

		// -------------------
		// Header
		// -------------------
		final CdaChEdesCtnn doc = new CdaChEdesCtnn(getDocLanguage(docManifest), xsl, css);
		final Identificator id = getDocumentId(docManifest);
		doc.setId(id);
		doc.setSetId(id);
		doc.setTimestamp(getDocumentDate(docManifest));
		// doc.setConfidentialityCode(getConfidentialityCode(docManifest));
		doc.setPatient(FhirCommon.getPatient(docManifest));
		Author docAuthor = null;
		for (final Author author : getAuthors(docManifest)) {
			doc.addAuthor(author);
			docAuthor = author;
		}
		doc.setCustodian(getCustodian(docManifest));
		doc.setLegalAuthenticator(getLegalAuthenticator(docManifest));

		// -------------------
		// Body
		// -------------------
		String narrative;
		// AllergiesAndOtherAdverseReactions
		for (final AllergyConcern allergyOrOtherAdverseReaction : getAllergyProblemConcernEntries(
				docManifest)) {
			doc.addAllergiesOrOtherAdverseReaction(allergyOrOtherAdverseReaction);
		}
		narrative = getNarrative(docManifest, FhirCommon.urnUseAsAllergyProblemConcern);
		doc.setNarrativeTextSectionAllergiesAndOtherAdverseReactions(narrative);

		// Past Illness / Bisherige Krankheiten/Anamnese
		for (final PastProblemConcern pastillness : getPastProblemConcernEntries(docManifest)) {
			doc.addPastIllness(pastillness);
		}

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsChiefComplaint);
		doc.setNarrativeTextSectionChiefComplaint(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsEdDisposition);
		doc.setNarrativeTextSectionEdDisposition(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsHistoryOfPresentIllness);
		doc.setNarrativeTextSectionHistoryOfPresentIllness(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsCurrentMedications);
		doc.setNarrativeTextSectionMedications(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsProcedures);
		doc.setNarrativeTextSectionProceduresAndInterventions(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsReasonForVisit);
		doc.setNarrativeTextSectionReasonForVisit(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsModeOfArrival);
		doc.setNarrativeTextSectionModeOfArrival(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsAcuityAssessment);
		doc.setNarrativeTextSectionAcuityAssessment(narrative);

		final VitalSignsOrganizer vitalSignOrganizer = getEdesCodedVitalSignOrganizer(docManifest);
		doc.setVitalSignsOrganizer(vitalSignOrganizer);

		final List<VitalSignObservation> vitalSigns = getEdesCodedVitalSigns(docManifest);
		if ((vitalSigns != null) && !vitalSigns.isEmpty()) {
			for (final VitalSignObservation vitalSign : vitalSigns) {
				doc.addCodedVitalSign(vitalSignOrganizer, vitalSign, docAuthor);
			}
		}
		return doc;
	}

	/**
	 * Gets the EDES Coded Vital Sign Organizer
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the EDES Coded Vital Sign Organizer
	 */
	protected VitalSignsOrganizer getEdesCodedVitalSignOrganizer(DocumentManifest docManifest) {

		final VitalSignsOrganizer retVal = new VitalSignsOrganizer();

		// TODO better inheritance: this code is copied from
		// AbstractFhirCdaCh.getLaboratoryBatteryOrganizers

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			Reference ref = null;
			try {
				ref = entry.getPReference();
			} catch (final FHIRException e) {
			}
			if (ref != null) {
				if (ref.getResource() instanceof ListResource) {
					final ListResource list = (ListResource) ref.getResource();
					final List<org.hl7.fhir.dstu3.model.Extension> extensions = list
							.getExtensionsByUrl(FhirCommon.urnUseAsCodedVitalSignList);
					if (!extensions.isEmpty()) {
						final Identifier id = list.getIdentifier().get(0);
						id.setSystem(FhirCommon.removeUrnOidPrefix(id.getSystem()));
						final TimeType timeStamp = ((TimeType) extensions.get(0).getValue());
						retVal.setEffectiveTime(
								DateUtil.parseDateyyyyMMddHHmmssZZZZ(timeStamp.getValue()));
						retVal.addId(new Identificator(id.getSystem(), id.getValue()));
						for (final ListEntryComponent listEntry : list.getEntry()) {
							final List<org.hl7.fhir.dstu3.model.Extension> extensions2 = listEntry
									.getExtensionsByUrl(FhirCommon.urnUseAsAuthor);
							if (!extensions2.isEmpty()
									&& (listEntry.getItem().getResource() instanceof Person)) {
								final org.ehealth_connector.common.Author author = FhirCommon
										.getAuthor((Person) listEntry.getItem().getResource());
								final TimeType timeStamp2 = ((TimeType) extensions2.get(0)
										.getValue());
								author.setTime(DateUtil
										.parseDateyyyyMMddHHmmssZZZZ(timeStamp2.getValue()));
								retVal.addAuthor(author);
							}
						}
					}
				}
			}
		}

		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC EDES VitalSignObservation from the
	 * given FHIR resource
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return list of eHC EDES VitalSignObservation </div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public List<VitalSignObservation> getEdesCodedVitalSigns(DocumentManifest docManifest) {

		final List<VitalSignObservation> retVal = new ArrayList<>();
		// TODO better inheritance: this code is copied from
		// AbstractFhirCdaCh.getLaboratoryBatteryOrganizers

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			Reference ref = null;
			try {
				ref = entry.getPReference();
			} catch (final FHIRException e) {
			}
			if (ref != null) {
				if (ref.getResource() instanceof ListResource) {
					final ListResource list = (ListResource) ref.getResource();
					if (!list.getExtensionsByUrl(FhirCommon.urnUseAsCodedVitalSignList).isEmpty()) {
						for (final ListEntryComponent listEntry : list.getEntry()) {
							if (!listEntry.getExtensionsByUrl(
									FhirCommon.urnUseAsCodedVitalSignObservation).isEmpty()
									&& (listEntry.getItem().getResource() instanceof Observation)) {
								final Observation fhirObservation = (Observation) listEntry
										.getItem().getResource();

								final Type fhirEffectiveTime = fhirObservation.getEffective();
								Date effectiveTime = new Date();
								if (fhirEffectiveTime instanceof DateTimeType) {
									effectiveTime = ((DateTimeType) fhirEffectiveTime).getValue();
								}
								final List<ObservationComponentComponent> components = fhirObservation
										.getComponent();
								for (final ObservationComponentComponent component : components) {
									Value value = null;

									final Coding fhirCode = component.getCode().getCodingFirstRep();
									final Type fhirValue = component.getValue();

									final Code code = new Code(
											FhirCommon.removeUrnOidPrefix(fhirCode.getSystem()),
											fhirCode.getCode(), fhirCode.getDisplay());
									if (fhirValue instanceof Quantity) {
										// type PQ
										final Quantity fhirQuantity = (Quantity) fhirValue;
										final PQ pq = DatatypesFactory.eINSTANCE.createPQ();
										pq.setUnit(fhirQuantity.getUnit());
										pq.setValue(fhirQuantity.getValue());
										value = new Value(pq);
									}
									retVal.add(
											new VitalSignObservation(code, effectiveTime, value));
								}
							}
						}
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * Read the EdesCtnnDocument object from the FHIR resource file
	 *
	 * @param fileName
	 *            the file name
	 * @return the edes ctnn document
	 */
	public EdesCtnnDocument readEdesCtnnDocumentFromFile(String fileName) {
		final String resourceString = FhirCommon.getXmlResource(fileName);
		final IParser parser = getFhirCtx().newXmlParser();
		return parser.parseResource(EdesCtnnDocument.class, resourceString);
	}

}
