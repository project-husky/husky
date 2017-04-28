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

package org.ehealth_connector.fhir.ch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.ch.ActiveProblemConcern;
import org.ehealth_connector.cda.ch.AllergyConcern;
import org.ehealth_connector.cda.ch.PastProblemConcern;
import org.ehealth_connector.cda.ch.ProblemConcern;
import org.ehealth_connector.cda.ch.edes.CdaChEdesEdpn;
import org.ehealth_connector.cda.ch.edes.VitalSignObservation;
import org.ehealth_connector.cda.ch.edes.VitalSignsOrganizer;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.fhir.FhirCommon;
import org.ehealth_connector.fhir.ch.FhirCdaChEdesCtnn.EdesCtnnDocument;
import org.hl7.fhir.dstu3.model.Basic;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.DocumentManifest;
import org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.ListResource;
import org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent;
import org.hl7.fhir.dstu3.model.Organization;
import org.hl7.fhir.dstu3.model.Patient;
import org.hl7.fhir.dstu3.model.Person;
import org.hl7.fhir.dstu3.model.Quantity;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.dstu3.model.TimeType;
import org.hl7.fhir.dstu3.model.Type;
import org.hl7.fhir.exceptions.FHIRException;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.parser.IParser;

/**
 * Supports the FHIR to eHC conversion for EDES EDPN documents
 *
 */
public class FhirCdaChEdesEdpn extends AbstractFhirCdaCh {

	/**
	 * The class EdesEdpnDocument is a derived FHIR resource containing all
	 * information of an Emergency Department Encounter Summary document based
	 * on a Composite Triage and Nursing Note corresponding to the CDA-CH-EDES
	 * specification
	 */
	@ResourceDef(name = "DocumentManifest")
	public static class EdesEdpnDocument extends DocumentManifest {

		private static final long serialVersionUID = 7883384366035439713L;

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

		/** The legal authenticator. */
		@Child(name = "legalAuthenticator")
		@Extension(url = FhirCommon.urnUseAsLegalAuthenticator, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "legalAuthenticator")
		private Reference legalAuthenticator;

		/** The patient. */
		@Child(name = "patient")
		@Extension(url = FhirCommon.urnUseAsPatient, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "patient")
		private Reference patient;

		/** The comment. */
		@Child(name = "comment")
		@Extension(url = FhirCommon.urnUseAsComment, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "comment")
		private Reference comment;

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
	}

	/**
	 * <div class="en">Creates an eHC CdaChEdesEdpn instance from a valid FHIR
	 * resource</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @param docManifest
	 *            <div class="en">valid CdaChEdesEdpn FHIR resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param xsl
	 *            <div class="en">desired stylesheet for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param css
	 *            <div class="en">desired CSS for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC CdaChEdesEdpn instance containing payload of
	 *         the given FHIR resource</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChEdesEdpn createEdesEdpnFromFhir(EdesCtnnDocument docManifest, String xsl,
			String css) {
		// -------------------
		// Header
		// -------------------
		final CdaChEdesEdpn doc = new CdaChEdesEdpn(getDocLanguage(docManifest), xsl, css);
		Identificator id = getDocumentId(docManifest);
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

		// Active Problems / Problemliste
		for (final ActiveProblemConcern activeProblemConcernEntry : getActiveProblemConcernEntries(
				docManifest)) {
			doc.addActiveProblemConcern(activeProblemConcernEntry);
		}

		// Past Illness / Bisherige Krankheiten/Anamnese
		for (final PastProblemConcern pastillness : getPastProblemConcernEntries(docManifest)) {
			doc.addPastIllness(pastillness);
		}

		// AdvanceDirectives
		narrative = getNarrative(docManifest, FhirCommon.urnUseAsAdvanceDirectives);
		doc.setNarrativeTextSectionAdvanceDirectives(narrative);

		// AllergiesAndOtherAdverseReactions
		for (final AllergyConcern allergyOrOtherAdverseReaction : getAllergyProblemConcernEntries(
				docManifest)) {
			doc.addAllergiesOrOtherAdverseReaction(allergyOrOtherAdverseReaction);
		}

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsChiefComplaint);
		doc.setNarrativeTextSectionChiefComplaint(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsFamilyMedicalHistory);
		doc.setNarrativeTextSectionFamilyMedicalHistory(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsHistoryOfImmunization);
		doc.setNarrativeTextSectionImmunizations(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsListOfSurgeries);
		doc.setNarrativeTextSectionListOfSurgeries(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsSocialHistory);
		doc.setNarrativeTextSectionSocialHistory(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsCodedPhysicalExam);
		doc.setNarrativeTextSectionCodedPhysicalExam(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsEdConsultations);
		doc.setNarrativeTextSectionEdConsultations(narrative);

		// Ed diagnosis / Problemliste
		for (final ProblemConcern edDiagnosis : getEdDiagnoses(docManifest)) {
			doc.addEdDiagnosis(edDiagnosis);
		}

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsProgressNote);
		doc.setNarrativeTextSectionProgressNote(narrative);

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

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsReferralSource);
		doc.setNarrativeTextSectionReferralSource(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsResults);
		doc.setNarrativeTextSectionResults(narrative);

		narrative = getNarrative(docManifest, FhirCommon.urnUseAsAssessmentAndPlan);
		doc.setNarrativeTextSectionAssessmentAndPlan(narrative);

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
			} catch (FHIRException e) {
			}
			if (ref != null) {
				if (ref.getResource() instanceof ListResource) {
					final ListResource list = (ListResource) ref.getResource();
					final List<org.hl7.fhir.dstu3.model.Extension> extensions = list
							.getExtensionsByUrl(FhirCommon.urnUseAsCodedVitalSignList);
					if (!extensions.isEmpty()) {
						final Identifier id = list.getIdentifier().get(0);
						id.setSystem(id.getSystem().replace("urn:oid:", ""));
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

		final List<VitalSignObservation> retVal = new ArrayList<VitalSignObservation>();
		// TODO better inheritance: this code is copied from
		// AbstractFhirCdaCh.getLaboratoryBatteryOrganizers

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			Reference ref = null;
			try {
				ref = entry.getPReference();
			} catch (FHIRException e) {
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
											FhirCommon.removeURIPrefix(fhirCode.getSystem()),
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
	public EdesEdpnDocument readEdesEdpnDocumentFromFile(String fileName) {
		final String resourceString = FhirCommon.getXmlResource(fileName);
		final IParser parser = fhirCtx.newXmlParser();
		return parser.parseResource(EdesEdpnDocument.class, resourceString);
	}
}
