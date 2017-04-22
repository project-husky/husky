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

import org.ehealth_connector.cda.AssociatedEntity;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.lab.SpecimenCollectionEntry;
import org.ehealth_connector.cda.ch.lab.lrqc.CdaChLrqc;
import org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryObservation;
import org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryReportDataProcessingEntry;
import org.ehealth_connector.cda.ch.lab.lrqc.LaboratorySpecialtySection;
import org.ehealth_connector.cda.ch.lab.lrqc.Participant;
import org.ehealth_connector.cda.ch.lab.lrqc.SpecimenAct;
import org.ehealth_connector.cda.ihe.lab.NonHumanSubject;
import org.ehealth_connector.cda.ihe.lab.ReferralOrderingPhysician;
import org.ehealth_connector.cda.ihe.lab.SpecimenReceivedEntry;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.IntendedRecipient;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.ehealth_connector.common.enums.StatusCode;
import org.ehealth_connector.common.enums.Ucum;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.fhir.FhirCommon;
import org.openhealthtools.mdht.uml.hl7.datatypes.BL;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.INT;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.api.IResource;
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
import ca.uhn.fhir.model.dstu2.resource.Observation;
import ca.uhn.fhir.model.dstu2.resource.Observation.Related;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Person;
import ca.uhn.fhir.model.primitive.DateTimeDt;
import ca.uhn.fhir.model.primitive.StringDt;
import ca.uhn.fhir.parser.IParser;

public class FhirCdaChLrqc extends AbstractFhirCdaCh {
	/**
	 * <div class="en">Type of the bundle to define whether the resulting CDA
	 * document contains full or masked patient demographics</div>
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
	 * The class FhirCdaChLrqc is a derived FHIR Bundle containing all
	 * information of an LRQC document corresponding to the CDA-CH-LRQC
	 * specification
	 */
	@ResourceDef(name = "Bundle")
	public static class LrqcDocument extends Bundle {

		private static final long serialVersionUID = 7883384366035439713L;

		/** The comment. */
		@Child(name = "comment")
		@Extension(url = FhirCommon.urnUseAsComment, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "comment")
		private ResourceReferenceDt comment;

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

		/** The informationRecipient. */
		@Child(name = "docInformationRecipient")
		@Extension(url = FhirCommon.urnUseAsInformationRecipient, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "informationRecipient")
		private ResourceReferenceDt informationRecipient;

		/** The legal authenticator. */
		@Child(name = "legalAuthenticator")
		@Extension(url = FhirCommon.urnUseAsLegalAuthenticator, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "legalAuthenticator")
		private ResourceReferenceDt legalAuthenticator;

		/** The patient. */
		@Child(name = "patient")
		@Extension(url = FhirCommon.urnUseAsPatient, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "patient")
		private ResourceReferenceDt patient;

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
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
		 * Sets the information recipient.
		 *
		 * @param informationRecipient
		 *            the information recipient
		 */
		public void setInformationRecipient(Basic informationRecipient) {
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
	}

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div>
	 * <div class="de"></div><div class="fr"></div>
	 */
	public static final String OID_LRQC = "urn:oid:" + CdaChLrqc.OID_MAIN;

	private CdaChLrqc doc;

	private final FhirContext fhirCtx = new FhirContext();

	/**
	 * <div class="en">Creates an eHC CdaChLrqc instance from a valid FHIR
	 * Bundle resource</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @param bundle
	 *            <div class="en">valid CdaChLrqc FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param xsl
	 *            <div class="en">desired stylesheet for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param css
	 *            <div class="en">desired CSS for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC CdaChLrqc instance containing payload of the
	 *         given FHIR Bundle resource</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChLrqc createCdaChLrqcFromFHIRBundle(Bundle bundle, String xsl, String css) {

		// Header
		doc = new CdaChLrqc(getDocLanguage(bundle), xsl, css);
		doc.setId(getDocumentId(bundle));
		doc.setSetId(getDocumentId(bundle));
		doc.setTimestamp(getDocumentDate(bundle));
		doc.setConfidentialityCode(getConfidentialityCode(bundle));
		// RecordTarget
		doc.setRecordTarget(getPatientLrqc(bundle));
		// ReferralOrderingPhysician
		doc.addReferralOrderingPhysician(getReferralOrderingPhysician(bundle));
		// Authors
		for (final Author author : getAuthors(bundle)) {
			author.setFunctionCode(new Code("2.16.840.1.113883.2.9.6.2.7", "3212", "ISCO-08",
					"Medical and pathology laboratory technicians"));
			doc.addAuthor(author);
		}
		// LegalAuthenticator
		final Author legalAuth = getLegalAuthenticator(bundle);
		if (legalAuth != null) {
			doc.setLegalAuthenticator(legalAuth);
		}
		// Custodian
		doc.setCustodian(getCustodian(bundle));
		// IntendedRecipient
		final IntendedRecipient ir = getIntendedRecipient(bundle);
		doc.addIntendedRecipient(ir);
		// Participant Claims
		final List<Participant> participantsList = getParticipants(bundle);
		for (Participant p : participantsList) {
			doc.addParticipant(p);
		}
		// InFulfillmentOf
		final Identificator ifoId = getInFulfillmentOf(bundle);
		if (ifoId != null) {
			doc.addInFulfillmentOf(ifoId);
		}
		// RelatedDocument
		Identificator relatedDocument = getRelatedDocument(bundle);
		if (relatedDocument != null) {
			doc.setDocumentToReplaceIdentifier(relatedDocument);
		}
		// DocVersion
		final Integer docVersion = getDocVersion(bundle);
		if (docVersion != null) {
			doc.setVersion(null, docVersion);
		}

		// Body
		// Laboratory SpecialtySections
		final List<LaboratorySpecialtySection> lssList = getLaboratorySpecialtySections(bundle);
		for (LaboratorySpecialtySection lss : lssList) {
			doc.setLaboratorySpecialtySection(lss);
		}

		// SpecimenCollection
		final SpecimenCollectionEntry sce = getSpecimenCollectionEntry(bundle);
		doc.getSpecimenAct().addSpecimenCollectionEntry(sce);

		// SpecimenReceived
		final SpecimenReceivedEntry sre = getSpecimenReceivedEntry(bundle);
		if (sre != null) {
			doc.getSpecimenAct().getSpecimenCollectionEntries().get(0)
					.setSpecimenReceivedEntry(sre);
		}

		// NonHumanSubject
		NonHumanSubject nhs = getNonLivingSubject(bundle);
		if (nhs != null) {
			doc.getSpecimenAct().setNonHumanSubject(nhs);
		}

		return doc;
	}

	/**
	 * <div class="en">Gets the eHC Custodian from the given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC Custodian</div> <div class="de"></div> <div class="fr"></div>
	 */
	@Override
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
	 * <div class="en"> Gets the eHC Vacd document type code (full or masked
	 * patient demographics) from the given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC Vacd document type code (full or masked patient
	 *         demographics)</div> <div class="de"></div> <div class="fr"></div>
	 */
	@SuppressWarnings("unused")
	private DocTypeCode getDocType(Bundle bundle) {
		DocTypeCode retVal = DocTypeCode.PATIENT; // default
		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Basic) {
				final Basic fhirBasic = (Basic) entry.getResource();
				final CodingDt langCode = fhirBasic.getCode().getCodingFirstRep();
				if (OID_LRQC.equals(langCode.getSystem())) {
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
		return retVal;
	}

	private Integer getDocVersion(Bundle bundle) {
		// Iterate over all Bundle Entries
		for (final Entry entry : bundle.getEntry()) {
			// Get all InFulfillmentOfs
			final List<ExtensionDt> ifoEntries = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsDocVersion);
			if ((ifoEntries != null) && !ifoEntries.isEmpty()) {
				final Basic ifo = (Basic) entry.getResource();
				return Integer.parseInt(ifo.getCode().getCodingFirstRep().getCode());
			}
		}
		return null;
	}

	private Identificator getInFulfillmentOf(Bundle bundle) {
		// Iterate over all Bundle Entries
		for (final Entry entry : bundle.getEntry()) {
			// Get all InFulfillmentOfs
			final List<ExtensionDt> ifoEntries = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsInFulfillmentOf);
			if ((ifoEntries != null) && !ifoEntries.isEmpty()) {
				final Basic ifo = (Basic) entry.getResource();
				return FhirCommon.fhirIdentifierToEhcIdentificator(ifo.getIdentifierFirstRep());
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets a list of eHC LRQC LaboratoryBatteryOrganizers from
	 * the given FHIR bundle
	 *
	 * @param fhirObs2
	 *            the FHIR bundle
	 * @return list of eHC LRQC LaboratoryBatteryOrganizers</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	private org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryBatteryOrganizer getLaboratoryBatteryOrganizers(
			Observation labObsList) {
		final org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryBatteryOrganizer lbo = new org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryBatteryOrganizer();
		// Set the Organizer Attributes
		// Status Code
		final String statusCode = getValueFromKeyValueString(labObsList.getText(), "statusCode");
		if (statusCode != null) {
			lbo.setStatusCode(StatusCode.getEnum(statusCode));
		}
		// EffectiveTime
		final DateTimeDt fTime = (DateTimeDt) labObsList.getEffective();
		lbo.setEffectiveTime(fTime.getValue());

		// Add all LaboratoryObservations
		for (final Related relatedObs : labObsList.getRelated()) {
			final Observation fhirObs = (Observation) relatedObs.getTarget().getResource();
			final LaboratoryObservation labObs = getLaboratoryObservation(fhirObs);
			lbo.addLaboratoryObservation(labObs);
		}
		return lbo;
	}

	private org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryObservation getLaboratoryObservation(
			Observation fhirObservation) {
		final org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryObservation retVal = new org.ehealth_connector.cda.ch.lab.lrqc.LaboratoryObservation();

		fhirObservation.getCode().getCodingFirstRep();
		retVal.setCode(FhirCommon.fhirCodeToEhcCode(fhirObservation.getCode()));
		if (fhirObservation.getIssued() != null) {
			retVal.setEffectiveTime(fhirObservation.getIssued());
		}
		if (!fhirObservation.getPerformer().isEmpty()) {
			final ResourceReferenceDt refPerf = fhirObservation.getPerformer().get(0);
			retVal.setLaboratory(FhirCommon.getOrganization((Organization) refPerf.getResource()),
					fhirObservation.getIssued());
		}
		Value v = null;
		// type PQ
		if (fhirObservation.getValue() instanceof QuantityDt) {
			final QuantityDt fhirQuantity = (QuantityDt) fhirObservation.getValue();
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
		if (fhirObservation.getValue() instanceof StringDt) {
			final StringDt fhirString = (StringDt) fhirObservation.getValue();
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
		if (fhirObservation.getValue() instanceof CodeableConceptDt)

		{
			final CodingDt fhirValueCode = ((CodeableConceptDt) fhirObservation.getValue())
					.getCodingFirstRep();
			retVal.addValue(new Code(new Code(FhirCommon.removeURIPrefix(fhirValueCode.getSystem()),
					fhirValueCode.getCode(), fhirValueCode.getDisplay())));
		}
		if (fhirObservation.getValue() instanceof RatioDt) {
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
				v = new Value(fhirObservation.getReferenceRangeFirstRep().getLow().getValue(),
						fhirObservation.getReferenceRangeFirstRep().getHigh().getValue());
			}

			rr.setValue(v);
			// Interpretation;
			ObservationInterpretation obsInt = ObservationInterpretation.getEnum(fhirObservation
					.getReferenceRangeFirstRep().getMeaning().getCodingFirstRep().getCode());
			if (obsInt != null) {
				rr.setInterpretationCode(obsInt);
			}
			retVal.setReferenceRange(rr);
		}

		final CodingDt fhirInterpretationCode = fhirObservation.getInterpretation()
				.getCodingFirstRep();
		if (fhirInterpretationCode != null) {
			if (fhirInterpretationCode.getSystem() != null) {
				retVal.addInterpretationCode(new Code(
						FhirCommon.removeURIPrefix(fhirInterpretationCode.getSystem()),
						fhirInterpretationCode.getCode(), fhirInterpretationCode.getDisplay()));
			} else {
				retVal.addInterpretationCode(
						new Code(org.ehealth_connector.common.enums.NullFlavor.UNKNOWN));
			}
		}
		// Text reference (inside the observation)
		if (fhirObservation.getComments() != null && !fhirObservation.getComments().isEmpty()) {
			retVal.setTextReference(fhirObservation.getComments());
		}
		// Comments
		for (Related commentRef : fhirObservation.getRelated()) {
			if (commentRef.getTarget().getResource() instanceof Observation) {
				Observation comment = (Observation) commentRef.getTarget().getResource();
				if (comment.getComments() != null) {
					retVal.addCommentEntry(
							new SectionAnnotationCommentEntry(comment.getComments()));
				}
			}
		}

		return retVal;
	}

	private List<LaboratorySpecialtySection> getLaboratorySpecialtySections(Bundle bundle) {

		final List<LaboratorySpecialtySection> lssList = new ArrayList<LaboratorySpecialtySection>();

		// Iterate over all Bundle Entries
		for (final Entry entry : bundle.getEntry()) {
			// Get all LaboratorySpecialtySections
			final List<ExtensionDt> specialtySections = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsLaboratorySpecialtySection);
			if ((specialtySections != null) && !specialtySections.isEmpty()) {
				final Observation obs = (Observation) entry.getResource();

				// SectionCode
				final Code code = FhirCommon.fhirCodeToEhcCode(obs.getCode());
				code.setCodeSystemName("LOINC");
				final org.ehealth_connector.cda.ch.lab.lrqc.LaboratorySpecialtySection lss = new org.ehealth_connector.cda.ch.lab.lrqc.LaboratorySpecialtySection(
						code, doc.getLanguageCode());

				// Add all LaboratoryBatteryOrganizers
				SpecimenAct spa = new SpecimenAct();
				spa.setCode(code);
				for (final Related relatedObs : obs.getRelated()) {
					final Observation fhirObs = (Observation) relatedObs.getTarget().getResource();
					spa.addLaboratoryBatteryOrganizer(getLaboratoryBatteryOrganizers(fhirObs));
				}
				lss.setLaboratoryReportDataProcessingEntry(
						new LaboratoryReportDataProcessingEntry(spa));

				// NarrativeText
				lss.setText(FhirCommon.formatDiv(obs.getText().getDiv()));
				lssList.add(lss);
			}
		}
		return lssList;
	}

	private NonHumanSubject getNonLivingSubject(Bundle bundle) {
		// Iterate over all Bundle Entries
		for (final Entry entry : bundle.getEntry()) {
			// Get all LaboratorySpecialtySections
			final List<ExtensionDt> specialtySections = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsNonLivingSubject);
			if ((specialtySections != null) && !specialtySections.isEmpty()) {
				final Person obs = (Person) entry.getResource();
				NonHumanSubject nhs = new NonHumanSubject(
						FhirCommon.fhirAddressToEhcAddress(obs.getAddressFirstRep()));
				return nhs;
			}
		}
		return null;
	}

	private List<Participant> getParticipants(Bundle bundle) {
		List<Participant> pList = new ArrayList<Participant>();
		// Iterate over all Bundle Entries
		for (final Entry entry : bundle.getEntry()) {
			// Get all LaboratorySpecialtySections
			final List<ExtensionDt> specialtySections = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsParticipant);
			if ((specialtySections != null) && !specialtySections.isEmpty()) {
				final Person fPar = (Person) entry.getResource();
				String gln = null;
				String zsr = null;
				for (IdentifierDt id : fPar.getIdentifier()) {
					if (id.getSystem().equals("2.51.1.3"))
						gln = id.getValue();
					if (id.getSystem().equals("2.16.756.5.30.1.123.100.2.1.1"))
						zsr = id.getValue();
				}
				Participant p = new Participant(gln, zsr, true);
				pList.add(p);
			}
		}
		return pList;
	}

	/**
	 * <div class="en"> Gets an eHC Patient object from the given FHIR bundle.
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC Patient object </div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public Identificator getPatientLrqc(Bundle bundle) {
		Patient fhirPatient = null;

		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Patient)
				fhirPatient = (Patient) entry.getResource();
		}
		// Get Identifier
		for (final IdentifierDt id : fhirPatient.getIdentifier()) {
			final String codeSystem = FhirCommon.removeURIPrefix(id.getSystem());
			return new Identificator(codeSystem, id.getValue());
		}
		return null;
	}

	/**
	 * <div class="en">Gets the eHC ReferralOrderingPhyscian from the given FHIR
	 * bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return eHC Custodian</div> <div class="de"></div> <div class="fr"></div>
	 */
	private org.ehealth_connector.cda.ihe.lab.ReferralOrderingPhysician getReferralOrderingPhysician(
			Bundle bundle) {
		org.ehealth_connector.cda.ihe.lab.ReferralOrderingPhysician retVal = null;
		for (final Entry entry : bundle.getEntry()) {
			if (!entry.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsReferralOrderingPhysician)
					.isEmpty()) {
				final Person physician = (Person) entry.getResource();

				Name name = null;
				if (physician.getNameFirstRep() != null) {
					name = FhirCommon.fhirNameToEhcName(physician.getNameFirstRep());
				}
				final Address address = FhirCommon
						.fhirAddressToEhcAddress(physician.getAddressFirstRep());
				final Telecoms telecoms = FhirCommon.getTelecoms(physician.getTelecom());

				final AssociatedEntity entity = new AssociatedEntity(name, address, telecoms);
				for (final IdentifierDt id : physician.getIdentifier()) {
					entity.addId(FhirCommon.fhirIdentifierToEhcIdentificator(id));
				}

				if ((physician.getContained() != null)
						&& !physician.getContained().getContainedResources().isEmpty()) {
					for (final IResource res : physician.getContained().getContainedResources()) {
						if (res instanceof Organization) {
							entity.setOrganization(FhirCommon.getOrganization(res));
						}
					}
				}
				retVal = new ReferralOrderingPhysician(entity);
			}
		}
		return retVal;
	}

	private Identificator getRelatedDocument(Bundle bundle) {
		// Iterate over all Bundle Entries
		for (final Entry entry : bundle.getEntry()) {
			// Get all relevant elements
			List<ExtensionDt> ifoEntries = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsRelatedDocument);
			if (ifoEntries != null && !ifoEntries.isEmpty()) {
				Basic ifo = (Basic) entry.getResource();
				return FhirCommon.fhirIdentifierToEhcIdentificator(ifo.getIdentifierFirstRep());
			}
		}
		return null;
	}

	/**
	 * Read the LrqcDocument object from the FHIR bundle file
	 *
	 * @param fileName
	 *            the file name
	 * @return the LRQC document
	 */
	public LrqcDocument readLrqcDocumentFromFile(String fileName) {
		final String resourceString = FhirCommon.getXmlResource(fileName);
		final IParser parser = fhirCtx.newXmlParser();
		return parser.parseResource(LrqcDocument.class, resourceString);
	}
}
