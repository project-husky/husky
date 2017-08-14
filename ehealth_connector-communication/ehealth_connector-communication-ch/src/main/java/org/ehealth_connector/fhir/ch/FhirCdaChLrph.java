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
import java.util.List;

import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.ParticipantClaimer;
import org.ehealth_connector.cda.ch.lab.AbstractSpecimenAct;
import org.ehealth_connector.cda.ch.lab.SpecimenCollectionEntry;
import org.ehealth_connector.cda.ch.lab.lrph.CdaChLrph;
import org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer;
import org.ehealth_connector.cda.ch.lab.lrph.LaboratoryIsolateOrganizer;
import org.ehealth_connector.cda.ch.lab.lrph.LaboratoryObservation;
import org.ehealth_connector.cda.ch.lab.lrph.LaboratorySpecialtySection;
import org.ehealth_connector.cda.ch.lab.lrph.OutbreakIdentificationObservation;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.IntendedRecipient;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.ehealth_connector.common.enums.StatusCode;
import org.ehealth_connector.common.enums.Ucum;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.fhir.FhirCommon;
import org.hl7.fhir.dstu3.model.Basic;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.DocumentManifest;
import org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent;
import org.hl7.fhir.dstu3.model.Observation;
import org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent;
import org.hl7.fhir.dstu3.model.Organization;
import org.hl7.fhir.dstu3.model.Patient;
import org.hl7.fhir.dstu3.model.Person;
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

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.parser.IParser;

/**
 * Supports the FHIR to eHC conversion for CDA-CH-LRPH documents
 *
 */
public class FhirCdaChLrph extends AbstractFhirCdaCh {
	/**
	 * <div class="en">Type of the FHIR resource to define whether the resulting
	 * CDA document contains full or masked patient demographics</div>
	 * <div class="de"></div><div class="fr"></div>
	 */
	public static enum DocTypeCode {
		/**
		 * <div class="en">the resulting CDA document contains hiv patient
		 * demographics</div><div class="de"></div> <div class="fr"></div>
		 */
		HIV,
		/**
		 * <div class="en">the resulting CDA document contains full patient
		 * demographics</div><div class="de"></div> <div class="fr"></div>
		 */
		PATIENT,
		/**
		 * <div class="en">the resulting CDA document contains masked patient
		 * demographics</div><div class="de"></div> <div class="fr"></div>
		 */
		PSEUDONYMIZED
	}

	/**
	 * The class FhirCdaChLrph is a derived FHIR resource containing all
	 * information of an LRPH document corresponding to the CDA-CH-LRPH
	 * specification
	 */
	@ResourceDef(name = "DocumentManifest")
	public static class LrphDocument extends DocumentManifest {

		private static final long serialVersionUID = 7883384366035439713L;

		/** The comment. */
		@Child(name = "comment")
		@Extension(url = FhirCommon.urnUseAsComment, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "comment")
		private Reference comment;

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

		/** The informationRecipient. */
		@Child(name = "docInformationRecipient")
		@Extension(url = FhirCommon.urnUseAsInformationRecipient, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "informationRecipient")
		private Reference informationRecipient;

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
		 * Gets the information recipient.
		 *
		 * @return the information recipient
		 */
		public Basic getInformationRecipient() {
			if (this.informationRecipient != null) {
				return (Basic) this.informationRecipient.getResource();
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
		 * Sets the information recipient.
		 *
		 * @param informationRecipient
		 *            the information recipient
		 */
		public void setInformationRecipient(Basic informationRecipient) {
			final Reference resourceRef = new Reference();
			resourceRef.setResource(informationRecipient);
			this.informationRecipient = resourceRef;
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

	private final FhirContext fhirCtx = new FhirContext(FhirVersionEnum.DSTU3);

	/**
	 * <div class="en">Creates an eHC CdaChLrph instance from a valid FHIR
	 * resource</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @param docManifest
	 *            <div class="en">valid CdaChLrph FHIR resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param xsl
	 *            <div class="en">desired stylesheet for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param css
	 *            <div class="en">desired CSS for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC CdaChLrph instance containing payload of the
	 *         given FHIR resource</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChLrph createCdaChLrphFromFhir(LrphDocument docManifest, String xsl, String css) {

		// Header
		final CdaChLrph doc = new CdaChLrph(getDocLanguage(docManifest), xsl, css);
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
		for (ParticipantClaimer p : participantsList) {
			doc.addParticipant(p);
		}
		// Custodian
		doc.setEmtpyCustodian();
		// IntendedRecipient
		final IntendedRecipient ir = getIntendedRecipient(docManifest);
		doc.addIntendedRecipient(ir);
		// InFulfillmentOf
		final Identificator ifoId = getInFulfillmentOf(docManifest);
		if (ifoId != null) {
			doc.addInFulfillmentOf(ifoId);
		}
		// DocVersion
		final Integer docVersion = getDocVersion(docManifest);
		if (docVersion != null) {
			doc.setVersion(null, docVersion);
		}
		// RelatedDocument
		Identificator relatedDocument = getRelatedDocument(docManifest);
		if (relatedDocument != null) {
			doc.setDocumentToReplaceIdentifier(relatedDocument);
		}
		// DocType and Pseudonymization
		if (getLrphDocType(docManifest) == DocTypeCode.HIV)
			doc.applyPrivacyFilterHiv();
		if (getLrphDocType(docManifest) == DocTypeCode.PSEUDONYMIZED)
			doc.applyPrivacyFilterInitials();

		// Body
		// Laboratory SpecialtySections
		final List<LaboratorySpecialtySection> lssList = getLrphLaboratorySpecialtySections(
				docManifest);
		final Code sectionCode = lssList.get(0).getCode();

		// Laboratory Battery Organizers
		final List<LaboratoryBatteryOrganizer> laboratoryBatteryOrganizers = getLrphLaboratoryBatteryOrganizers(
				docManifest);
		if ((laboratoryBatteryOrganizers != null) && !laboratoryBatteryOrganizers.isEmpty()) {
			for (final LaboratoryBatteryOrganizer lbo : laboratoryBatteryOrganizers) {
				doc.addLaboratoryBatteryOrganizer(lbo, sectionCode);
			}
		}

		// LaboratorySpecialtySection
		if (doc.isNarrativeTextGenerationEnabled()) {
			doc.setNarrativeTextSectionLaboratorySpeciality(
					doc.generateNarrativeTextLaboratoryObservations("lss", null));
		} else {
			final String narrative = getNarrative(docManifest,
					FhirCommon.urnUseAsLaboratorySpecialtySection);
			doc.setNarrativeTextSectionLaboratorySpeciality(narrative);
		}

		AbstractSpecimenAct specimenAct = doc.getSpecimenAct();
		if (specimenAct != null) {
			// SpecimenCollection
			doc.getSpecimenAct()
					.setSpecimenCollectionEntry(getSpecimenCollectionEntry(docManifest));

			// SpecimenReceived
			SpecimenCollectionEntry sce = doc.getSpecimenAct().getSpecimenCollectionEntry();
			if (sce != null)
				sce.setSpecimenReceivedEntry(getSpecimenReceivedEntry(docManifest));
		}

		// IsolateOrganizer
		doc.getSpecimenAct()
				.addLaboratoryIsolateOrganizer(getLrphLaboratoryIsolateOrganizer(docManifest));

		// OutbreakIdentification
		doc.getSpecimenAct().setOutbreakIdentification(getLrphOutbreakIdentification(docManifest));

		return doc;
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
	private DocTypeCode getLrphDocType(DocumentManifest docManifest) {
		DocTypeCode retVal = DocTypeCode.PATIENT; // default

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			Reference ref = null;
			try {
				ref = entry.getPReference();
			} catch (FHIRException e) {
			}
			if (ref != null) {
				if (ref.getResource() instanceof Basic) {
					final Basic fhirBasic = (Basic) ref.getResource();
					final Coding langCode = fhirBasic.getCode().getCodingFirstRep();
					if (FhirCommon.addUrnOid(CdaChLrph.OID_MAIN).equals(langCode.getSystem())) {
						if ("patient".equals(langCode.getCode().toLowerCase())) {
							retVal = DocTypeCode.PATIENT;
							break;
						} else if ("hiv".equals(langCode.getCode().toLowerCase())) {
							retVal = DocTypeCode.HIV;
							break;
						} else if ("pseudo".equals(langCode.getCode().toLowerCase())) {
							retVal = DocTypeCode.PSEUDONYMIZED;
							break;
						}
					}
				}
			}
		}
		return retVal;
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
	protected List<LaboratoryBatteryOrganizer> getLrphLaboratoryBatteryOrganizers(
			DocumentManifest docManifest) {
		final List<LaboratoryBatteryOrganizer> retVal = new ArrayList<LaboratoryBatteryOrganizer>();

		// TODO better inheritance: this code is copied from
		// AbstractFhirCdaCh.getLaboratoryBatteryOrganizers

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsLaboratoryBatteryOrganizer)
					.isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
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
						Identificator id = new Identificator(obs.getIdentifierFirstRep());
						id.setRoot(id.getRoot().replace(FhirCommon.oidUrn, ""));
						lbo.getMdht().getIds().add(id.getIi());
					}

					// EffectiveTime
					final DateTimeType fTime = (DateTimeType) obs.getEffective();
					if (fTime != null)
						lbo.setEffectiveTime(fTime.getValue());

					// Authors
					for (Reference perfRef : obs.getPerformer()) {
						Practitioner p = (Practitioner) perfRef.getResource();
						Author author = new Author();
						author.addId(FhirCommon
								.fhirIdentifierToEhcIdentificator(p.getIdentifierFirstRep()));
						final List<org.hl7.fhir.dstu3.model.Extension> extensions = perfRef
								.getExtensionsByUrl(FhirCommon.urnUseAsAuthor);
						if (!extensions.isEmpty()) {
							TimeType t = (TimeType) extensions.get(0).getValue();
							author.setTime(DateUtil.parseDates(t.getValue()));
						}
						lbo.addAuthor(author);
					}

					// Add all LaboratoryObservations
					for (final ObservationRelatedComponent relatedObs : obs.getRelated()) {
						final Observation fhirObs = (org.hl7.fhir.dstu3.model.Observation) relatedObs
								.getTarget().getResource();
						final LaboratoryObservation labObs = getLrphLaboratoryObservation(fhirObs);
						lbo.addLaboratoryObservation(labObs);
					}
					retVal.add(lbo);
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets a list of eHC LRPH LaboratoryBatteryOrganizers from
	 * the given FHIR resource
	 *
	 * @param fhirObs2
	 *            the FHIR resource
	 * @return list of eHC LRPH LaboratoryBatteryOrganizers</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	private LaboratoryBatteryOrganizer getLrphLaboratoryBatteryOrganizers(Observation labObsList) {
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
		for (Reference perfRef : labObsList.getPerformer()) {
			Practitioner p = (Practitioner) perfRef.getResource();
			Author author = new Author();
			author.addId(FhirCommon.fhirIdentifierToEhcIdentificator(p.getIdentifierFirstRep()));
			final List<org.hl7.fhir.dstu3.model.Extension> extensions = labObsList
					.getExtensionsByUrl(FhirCommon.urnUseAsAuthor);
			if (!extensions.isEmpty()) {
				TimeType t = (TimeType) extensions.get(0).getValue();
				author.setTime(DateUtil.parseDates(t.getValue()));
			}
			lbo.addAuthor(author);
		}

		// Add all LaboratoryObservations
		for (final ObservationRelatedComponent relatedObs : labObsList.getRelated()) {
			final Observation fhirObs = (Observation) relatedObs.getTarget().getResource();
			final LaboratoryObservation labObs = getLrphLaboratoryObservation(fhirObs);
			lbo.addLaboratoryObservation(labObs);
		}
		return lbo;
	}

	/**
	 * Gets the LRPH Laboratory Isolate Organizer
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the LRPH Laboratory Isolate Organizer
	 */
	protected LaboratoryIsolateOrganizer getLrphLaboratoryIsolateOrganizer(
			DocumentManifest docManifest) {

		// TODO better inheritance: this code is copied from
		// AbstractFhirCdaCh.getLaboratoryBatteryOrganizers

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsLaboratoryIsolateOrganizer)
					.isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					final Observation obs = (Observation) ref.getResource();

					final Identificator id = FhirCommon
							.fhirIdentifierToEhcIdentificator(obs.getIdentifierFirstRep());
					final String ref2 = getNarrative(docManifest,
							FhirCommon.urnUseAsLaboratoryIsolateOrganizer);
					final Code code = FhirCommon.fhirCodeToEhcCode(obs.getCode());
					code.setOriginalTextReference(ref2);

					final LaboratoryIsolateOrganizer sce = new LaboratoryIsolateOrganizer(ref2);
					sce.getSpecimen().setCode(code);
					sce.getMdht().getIds().add(id.getIi());

					// EffectiveTime
					final DateTimeType fTime = (DateTimeType) obs.getEffective();
					if (fTime != null)
						sce.setEffectiveTime(fTime.getValue());

					// Authors
					for (Reference perfRef : obs.getPerformer()) {
						Practitioner p = (Practitioner) perfRef.getResource();
						Author author = new Author();
						author.addId(FhirCommon
								.fhirIdentifierToEhcIdentificator(p.getIdentifierFirstRep()));
						final List<org.hl7.fhir.dstu3.model.Extension> extensions = perfRef
								.getExtensionsByUrl(FhirCommon.urnUseAsAuthor);
						if (!extensions.isEmpty()) {
							TimeType t = (TimeType) extensions.get(0).getValue();
							author.setTime(DateUtil.parseDates(t.getValue()));
						}
						sce.addAuthor(author);
					}

					// Add all LaboratoryObservations
					final LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
					for (final ObservationRelatedComponent relatedObs : obs.getRelated()) {
						final Observation fhirObs = (org.hl7.fhir.dstu3.model.Observation) relatedObs
								.getTarget().getResource();
						final LaboratoryObservation labObs = getLrphLaboratoryObservation(fhirObs);
						lbo.addLaboratoryObservation(labObs);
					}
					sce.addLaboratoryBatteryOrganizer(lbo);

					// Add the id of the subsequent organizer
					sce.getMdht().getComponents().get(0).getOrganizer().getIds().add(id.getIi());

					return sce;
				}
			}
		}
		return null;
	}

	/**
	 * Gets the LRPH Laboratory Observation
	 *
	 * @param fhirObservation
	 *            the FHIR resource
	 * @return the Laboratory Observation
	 */
	protected LaboratoryObservation getLrphLaboratoryObservation(Observation fhirObservation) {
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
					BL bl = DatatypesFactory.eINSTANCE.createBL();
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
						BL bl = DatatypesFactory.eINSTANCE.createBL();
						bl.setNullFlavor(NullFlavor.NA);
						v = new Value(bl);
					}
				}
			}
			if (fhirString.getValue().startsWith("INT:")) {
				if (fhirString.getValue().startsWith("INT:NA")) {
					INT intValue = DatatypesFactory.eINSTANCE.createINT();
					intValue.setNullFlavor(NullFlavor.NA);
					v = new Value(intValue);
				} else {
					v = new Value(Integer.parseInt(fhirString.getValue().replace("INT:", "")));
				}
			}
			if (fhirString.getValue().startsWith("ED:")) {
				if (fhirString.getValue().startsWith("ED:#")) {
					ED edValue = Util.createReference(fhirString.getValue().replace("ED:", ""));
					v = new Value(edValue);
				} else {
					v = new Value(Integer.parseInt(fhirString.getValue().replace("INT:", "")));
				}
			}
			if (fhirString.getValue().startsWith("ST:")) {
				if (fhirString.getValue().startsWith("ST:NA")) {
					ST stValue = DatatypesFactory.eINSTANCE.createST();
					stValue.setNullFlavor(NullFlavor.NA);
					v = new Value(stValue);
				} else {
					ST stValue = DatatypesFactory.eINSTANCE
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
			org.ehealth_connector.common.ReferenceRange rr = new org.ehealth_connector.common.ReferenceRange();
			// Value
			if (fhirObservation.getReferenceRangeFirstRep().getLow().getUnit() != null
					&& fhirObservation.getReferenceRangeFirstRep().getHigh().getUnit() != null) {
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
							String code = fhirObservation.getReferenceRangeFirstRep().getAppliesTo()
									.get(0).getCodingFirstRep().getCode();
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
		if (fhirObservation.getComment() != null && !fhirObservation.getComment().isEmpty())

		{
			retVal.setTextReference(fhirObservation.getComment());
		}
		// Comments
		for (ObservationRelatedComponent commentRef : fhirObservation.getRelated()) {
			if (commentRef.getTarget().getResource() instanceof Observation) {
				Observation comment = (Observation) commentRef.getTarget().getResource();
				if (comment.getComment() != null) {
					retVal.addCommentEntry(new SectionAnnotationCommentEntry(comment.getComment()));
				}
			}
		}

		return retVal;
	}

	/**
	 * Gets a list of the LRPH Laboratory Specialty Sections
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the LRPH Laboratory Specialty Sections
	 */
	protected List<LaboratorySpecialtySection> getLrphLaboratorySpecialtySections(
			DocumentManifest docManifest) {

		// TODO better inheritance: this code is copied from
		// AbstractFhirCdaCh.getLaboratorySpecialtySections

		final List<LaboratorySpecialtySection> lssList = new ArrayList<LaboratorySpecialtySection>();

		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			final List<org.hl7.fhir.dstu3.model.Extension> extensions = entry
					.getExtensionsByUrl(FhirCommon.urnUseAsLaboratorySpecialtySection);
			if (!extensions.isEmpty()) {
				Reference ref = null;
				try {
					if (entry.hasPReference())
						ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					final Observation obs = (Observation) ref.getResource();

					// SectionCode
					final Code code = FhirCommon.fhirCodeToEhcCode(obs.getCode());
					code.setCodeSystemName("LOINC");
					final org.ehealth_connector.cda.ch.lab.lrph.LaboratorySpecialtySection lss = new org.ehealth_connector.cda.ch.lab.lrph.LaboratorySpecialtySection(
							code, LanguageCode.getEnum(docManifest.getLanguage()));

					// Add all LaboratoryBatteryOrganizers
					AbstractSpecimenAct spa = new AbstractSpecimenAct();
					spa.setCode(code);
					for (final ObservationRelatedComponent relatedObs : obs.getRelated()) {
						final Observation fhirObs = (Observation) relatedObs.getTarget()
								.getResource();
						spa.addLaboratoryBatteryOrganizer(
								getLrphLaboratoryBatteryOrganizers(fhirObs));
					}
					lss.setLaboratoryReportDataProcessingEntry(
							new org.ehealth_connector.cda.ch.lab.lrph.LaboratoryReportDataProcessingEntry(
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
	 * Gets the LRPH Outbreak Identification
	 *
	 * @param docManifest
	 *            the FHIR resource
	 * @return the LRPH Outbreak Identification
	 */
	protected OutbreakIdentificationObservation getLrphOutbreakIdentification(
			DocumentManifest docManifest) {
		OutbreakIdentificationObservation retVal = null;
		for (final DocumentManifestContentComponent entry : docManifest.getContent()) {
			if (!entry.getExtensionsByUrl(FhirCommon.urnUseAsOutbreakIdentification).isEmpty()) {
				Reference ref = null;
				try {
					ref = entry.getPReference();
				} catch (FHIRException e) {
				}
				if (ref != null) {
					retVal = new OutbreakIdentificationObservation();
					final Observation fhirObservation = (Observation) ref.getResource();

					if (fhirObservation.getComment() != null) {
						retVal.setCommentEntry(
								new SectionAnnotationCommentEntry(fhirObservation.getComment()));
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * Read the LrphDocument object from the FHIR resource file
	 *
	 * @param fileName
	 *            the file name
	 * @return the LRPH document
	 */
	public LrphDocument readLrphDocumentFromFile(String fileName) {
		final String resourceString = FhirCommon.getXmlResource(fileName);
		final IParser parser = fhirCtx.newXmlParser();
		return parser.parseResource(LrphDocument.class, resourceString);
	}

}
