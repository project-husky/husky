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
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.fhir.ch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.AssociatedEntity;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.edes.VitalSignObservation;
import org.ehealth_connector.cda.ch.lab.SpecimenCollectionEntry;
import org.ehealth_connector.cda.ch.lab.lrph.CdaChLrph;
import org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer;
import org.ehealth_connector.cda.ch.lab.lrph.LaboratoryIsolateOrganizer;
import org.ehealth_connector.cda.ch.lab.lrph.LaboratoryObservation;
import org.ehealth_connector.cda.ch.lab.lrph.LaboratorySpecialtySection;
import org.ehealth_connector.cda.ch.lab.lrph.OutbreakIdentificationObservation;
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
import org.ehealth_connector.common.enums.StatusCode;
import org.ehealth_connector.common.enums.Ucum;
import org.ehealth_connector.fhir.FhirCommon;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.api.IDatatype;
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
import ca.uhn.fhir.model.dstu2.resource.Observation.Component;
import ca.uhn.fhir.model.dstu2.resource.Observation.Related;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Person;
import ca.uhn.fhir.model.primitive.DateTimeDt;
import ca.uhn.fhir.parser.IParser;

public class FhirCdaChLrph extends AbstractFhirCdaCh {
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
	 * The class FhirCdaChLrph is a derived FHIR Bundle containing all
	 * information of an LRPH document corresponding to the CDA-CH-LRPH
	 * specification
	 */
	@ResourceDef(name = "Bundle")
	public static class LrphDocument extends Bundle {

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
		 * @param the
		 *            information recipient
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
	public static final String OID_LRPH = "urn:oid:" + CdaChLrph.OID_MAIN;

	private final FhirContext fhirCtx = new FhirContext();

	/**
	 * <div class="en">Creates an eHC CdaChLrph instance from a valid FHIR
	 * Bundle resource</div> <div class="de"></div> <div class="fr"></div>
	 *
	 * @param bundle
	 *            <div class="en">valid CdaChLrph FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param xsl
	 *            <div class="en">desired stylesheet for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param css
	 *            <div class="en">desired CSS for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC CdaChLrph instance containing payload of the
	 *         given FHIR Bundle resource</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChLrph createCdaChLrphFromFHIRBundle(Bundle bundle, String xsl, String css) {

		// Header
		final CdaChLrph doc = new CdaChLrph(getDocLanguage(bundle), xsl, css);
		doc.setConfidentialityCode(getConfidentialityCode(bundle));
		// RecordTarget
		doc.setPatient(FhirCommon.getPatient(bundle));
		// ReferralOrderingPhysician
		doc.addReferralOrderingPhysician(getReferralOrderingPhysician(bundle));
		// Authors
		for (final Author author : getAuthors(bundle)) {
			author.setTime(new Date());
			doc.addAuthor(author);
		}
		// LegalAuthenticator
		Author legalAuth = getLegalAuthenticator(bundle);
		if (legalAuth != null) {
			doc.setLegalAuthenticator(legalAuth);
		}
		// Custodian
		doc.setEmtpyCustodian();
		// IntendedRecipient
		IntendedRecipient ir = getIntendedRecipient(bundle);
		doc.addIntendedRecipient(ir);
		// InFulfillmentOf
		Identificator ifoId = getInFulfillmentOf(bundle);
		if (ifoId != null) {
			doc.addInFulfillmentOf(ifoId);
		}
		// DocVersion
		Integer docVersion = getDocVersion(bundle);
		if (docVersion != null) {
			doc.setVersion(null, docVersion);
		}
		// DocType and Pseudonymization
		if (getDocType(bundle) == DocTypeCode.HIV)
			doc.applyPrivacyFilterHiv();
		if (getDocType(bundle) == DocTypeCode.PSEUDONYMIZED)
			doc.applyPrivacyFilterInitials();

		// Body
		// Laboratory SpecialtySections
		List<LaboratorySpecialtySection> lssList = getLaboratorySpecialtySections(bundle);
		Code sectionCode = lssList.get(0).getCode();

		// Laboratory Battery Organizers
		List<LaboratoryBatteryOrganizer> laboratoryBatteryOrganizers = getLaboratoryBatteryOrganizers(
				bundle);
		if (laboratoryBatteryOrganizers != null && !laboratoryBatteryOrganizers.isEmpty()) {
			for (LaboratoryBatteryOrganizer lbo : laboratoryBatteryOrganizers) {
				doc.addLaboratoryBatteryOrganizer(lbo, sectionCode);
			}
		}

		// LaboratorySpecialtySection
		String narrative = getNarrative(bundle, FhirCommon.urnUseAsLaboratorySpecialtySection);
		doc.setNarrativeTextSectionLaboratorySpeciality(narrative);

		// SpecimenCollection
		SpecimenCollectionEntry sce = getSpecimenCollectionEntry(bundle);
		doc.getSpecimenAct().setSpecimenCollectionEntry(sce);

		// SpecimenReceived
		SpecimenReceivedEntry sre = getSpecimenReceivedEntry(bundle);
		if (sre != null) {
			doc.getSpecimenAct().getSpecimenCollectionEntry().setSpecimenReceivedEntry(sre);
		}

		// IsolateOrganizer
		LaboratoryIsolateOrganizer lio = getLaboratoryIsolateOrganizer(bundle);
		if (lio != null) {
			doc.getSpecimenAct().addLaboratoryIsolateOrganizer(lio);
		}

		// OutbreakIdentification
		OutbreakIdentificationObservation oio = getOutbreakIdentification(bundle);
		if (oio != null) {
			doc.getSpecimenAct().setOutbreakIdentification(oio);
		}

		return doc;
	}

	/**
	 * Read the LrphDocument object from the FHIR bundle file
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

	/**
	 * <div class="en">Gets a list of eHC EDES VitalSignObservation from the
	 * given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return list of eHC EDES VitalSignObservation </div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	private List<org.ehealth_connector.cda.ch.edes.VitalSignObservation> getCodedVitalSigns(
			Bundle bundle) {
		final List<org.ehealth_connector.cda.ch.edes.VitalSignObservation> retVal = new ArrayList<org.ehealth_connector.cda.ch.edes.VitalSignObservation>();
		for (final Entry entry : bundle.getEntry()) {
			List<ExtensionDt> observations = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsCodedVitalSignObservation);
			if (observations != null && !observations.isEmpty()
					&& (entry.getResource() instanceof Observation)) {
				Observation observation = (Observation) entry.getResource();
				IDatatype fhirEffectiveTime = observation.getEffective();
				Date effectiveTime = new Date();
				if (fhirEffectiveTime instanceof DateTimeDt) {
					effectiveTime = ((DateTimeDt) fhirEffectiveTime).getValue();
				}
				List<Component> components = observation.getComponent();
				for (Component component : components) {
					CodingDt fhirCode = component.getCode().getCodingFirstRep();
					IDatatype fhirValue = component.getValue();

					Code code = new Code(FhirCommon.removeURIPrefix(fhirCode.getSystem()),
							fhirCode.getCode(), fhirCode.getDisplay());
					Value value = null;
					if (fhirValue instanceof QuantityDt) {
						// type PQ
						final QuantityDt fhirQuantity = (QuantityDt) fhirValue;
						PQ pq = DatatypesFactory.eINSTANCE.createPQ();
						pq.setUnit(fhirQuantity.getUnit());
						pq.setValue(fhirQuantity.getValue());
						value = new Value(pq);
					}
					if (code != null && value != null) {
						retVal.add(new VitalSignObservation(code, effectiveTime, value));
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
	private DocTypeCode getDocType(Bundle bundle) {
		DocTypeCode retVal = DocTypeCode.PATIENT; // default
		for (final Entry entry : bundle.getEntry()) {
			if (entry.getResource() instanceof Basic) {
				final Basic fhirBasic = (Basic) entry.getResource();
				final CodingDt langCode = fhirBasic.getCode().getCodingFirstRep();
				if (OID_LRPH.equals(langCode.getSystem())) {
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
			List<ExtensionDt> ifoEntries = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsDocVersion);
			if (ifoEntries != null && !ifoEntries.isEmpty()) {
				Basic ifo = (Basic) entry.getResource();
				return Integer.parseInt(ifo.getCode().getCodingFirstRep().getCode());
			}
		}
		return null;
	}

	private Identificator getInFulfillmentOf(Bundle bundle) {
		final List<org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer> retVal = new ArrayList<org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer>();

		// Iterate over all Bundle Entries
		for (final Entry entry : bundle.getEntry()) {
			// Get all InFulfillmentOfs
			List<ExtensionDt> ifoEntries = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsInFulfillmentOf);
			if (ifoEntries != null && !ifoEntries.isEmpty()) {
				Basic ifo = (Basic) entry.getResource();
				return FhirCommon.fhirIdentifierToEhcIdentificator(ifo.getIdentifierFirstRep());
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets a list of eHC LRPH LaboratoryBatteryOrganizers from
	 * the given FHIR bundle
	 *
	 * @param bundle
	 *            the FHIR bundle
	 * @return list of eHC LRPH LaboratoryBatteryOrganizers</div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	private List<org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizers(
			Bundle bundle) {
		final List<org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer> retVal = new ArrayList<org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer>();

		// Iterate over all Bundle Entries
		for (final Entry entry : bundle.getEntry()) {
			// Get all LaboratoryBatteryOrganizers
			List<ExtensionDt> laboratoryBatteryOrganizers = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsLaboratoryBatteryOrganizer);
			if (laboratoryBatteryOrganizers != null && !laboratoryBatteryOrganizers.isEmpty()) {
				org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer lbo = new org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer();
				Observation labObsList = (Observation) entry.getResource();

				// Set the Organizer Attributes
				// Status Code
				String statusCode = getValueFromKeyValueString(labObsList.getText(), "statusCode");
				if (statusCode != null) {
					lbo.setStatusCode(StatusCode.getEnum(statusCode));
				}
				if (!labObsList.getIdentifier().isEmpty()) {
					lbo.addIdForHiv(FhirCommon
							.fhirIdentifierToEhcIdentificator(labObsList.getIdentifierFirstRep()));
				}

				// Add all LaboratoryObservations
				for (Related relatedObs : labObsList.getRelated()) {
					Observation fhirObs = (Observation) relatedObs.getTarget().getResource();
					LaboratoryObservation labObs = getLaboratoryObservation(fhirObs);
					lbo.addLaboratoryObservation(labObs);
				}
				retVal.add(lbo);
			}
		}
		return retVal;
	}

	private LaboratoryIsolateOrganizer getLaboratoryIsolateOrganizer(Bundle bundle) {
		for (final Entry entry : bundle.getEntry()) {
			// Get all LaboratorySpecialtySections
			List<ExtensionDt> element = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsLaboratoryIsolateOrganizer);
			if (element != null && !element.isEmpty()) {
				Observation obs = (Observation) entry.getResource();

				Identificator id = FhirCommon
						.fhirIdentifierToEhcIdentificator(obs.getIdentifierFirstRep());
				String ref = getNarrative(bundle, FhirCommon.urnUseAsLaboratoryIsolateOrganizer);
				Code code = FhirCommon.fhirCodeToEhcCode(obs.getCode());
				code.setOriginalTextReference(ref);

				LaboratoryIsolateOrganizer sce = new LaboratoryIsolateOrganizer(ref);
				sce.getSpecimen().setCode(code);
				sce.getMdht().getIds().add(id.getIi());

				// Add all LaboratoryObservations
				for (Related relatedObs : obs.getRelated()) {
					relatedObs.getTarget().getResource();
					LaboratoryBatteryOrganizer labBat = new LaboratoryBatteryOrganizer();
					sce.addLaboratoryBatteryOrganizer(labBat);
				}

				return sce;
			}
		}
		return null;
	}

	private org.ehealth_connector.cda.ch.lab.lrph.LaboratoryObservation getLaboratoryObservation(
			Observation fhirObservation) {
		final org.ehealth_connector.cda.ch.lab.lrph.LaboratoryObservation retVal = new org.ehealth_connector.cda.ch.lab.lrph.LaboratoryObservation();

		fhirObservation.getCode().getCodingFirstRep();
		retVal.setCode(FhirCommon.fhirCodeToEhcCode(fhirObservation.getCode()));
		retVal.setEffectiveTime(fhirObservation.getIssued());
		if (!fhirObservation.getPerformer().isEmpty()) {
			final ResourceReferenceDt refPerf = fhirObservation.getPerformer().get(0);
			retVal.setLaboratory(FhirCommon.getOrganization((Organization) refPerf.getResource()),
					fhirObservation.getIssued());
		}

		if (fhirObservation.getValue() instanceof QuantityDt) {
			// type PQ
			final QuantityDt fhirQuantity = (QuantityDt) fhirObservation.getValue();
			Value v = new Value(fhirQuantity.getValue().toString(),
					Ucum.AHGEquivalentsPerMilliLiter);

			// fix for the bug(?), which ommits the unit when it´s set to "1"
			String unit;
			if (fhirQuantity.getUnit().startsWith("#")) {
				// Seems to be a bug in the MDHT. Ucum Unit can´t be set to "1".
				// unit = fhirQuantity.getUnit().replace("#", "");
				unit = fhirQuantity.getUnit();
			} else {
				unit = fhirQuantity.getUnit();
			}
			v.setUcumUnit(unit);
			retVal.addValue(v);

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
				retVal.addInterpretationCode(new Code(
						FhirCommon.removeURIPrefix(fhirInterpretationCode.getSystem()),
						fhirInterpretationCode.getCode(), fhirInterpretationCode.getDisplay()));
			}
		}

		if (fhirObservation.getComments() != null) {
			retVal.addCommentEntry(
					new SectionAnnotationCommentEntry(fhirObservation.getComments()));
		}
		return retVal;
	}

	private List<LaboratorySpecialtySection> getLaboratorySpecialtySections(Bundle bundle) {

		List<LaboratorySpecialtySection> lssList = new ArrayList<LaboratorySpecialtySection>();

		// Iterate over all Bundle Entries
		for (final Entry entry : bundle.getEntry()) {
			// Get all LaboratorySpecialtySections
			List<ExtensionDt> specialtySections = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsLaboratorySpecialtySection);
			if (specialtySections != null && !specialtySections.isEmpty()) {
				Observation obs = (Observation) entry.getResource();

				org.ehealth_connector.cda.ch.lab.lrph.LaboratorySpecialtySection lss = new org.ehealth_connector.cda.ch.lab.lrph.LaboratorySpecialtySection();
				Code code = FhirCommon.fhirCodeToEhcCode(obs.getCode());
				code.setCodeSystemName("LOINC");
				lss.setCode(code);
				lssList.add(lss);
			}
		}
		return lssList;
	}

	private org.ehealth_connector.cda.ch.lab.lrph.OutbreakIdentificationObservation getOutbreakIdentification(
			Bundle bundle) {
		org.ehealth_connector.cda.ch.lab.lrph.OutbreakIdentificationObservation retVal = null;
		// Iterate over all Bundle Entries
		for (final Entry entry : bundle.getEntry()) {
			List<ExtensionDt> outbreakIdentification = entry
					.getUndeclaredExtensionsByUrl(FhirCommon.urnUseAsOutbreakIdentification);
			if (outbreakIdentification != null && !outbreakIdentification.isEmpty()) {
				retVal = new org.ehealth_connector.cda.ch.lab.lrph.OutbreakIdentificationObservation();
				Observation fhirObservation = (Observation) entry.getResource();

				if (fhirObservation.getComments() != null) {
					retVal.setCommentEntry(
							new SectionAnnotationCommentEntry(fhirObservation.getComments()));
				}
			}
		}
		return retVal;
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
				Person physician = (Person) entry.getResource();

				Name name = null;
				if (physician.getNameFirstRep() != null) {
					name = FhirCommon.fhirNameToEhcName(physician.getNameFirstRep());
				}
				Address address = FhirCommon
						.fhirAddressToEhcAddress(physician.getAddressFirstRep());
				Telecoms telecoms = FhirCommon.getTelecoms(physician.getTelecom());

				AssociatedEntity entity = new AssociatedEntity(name, address, telecoms);
				for (IdentifierDt id : physician.getIdentifier()) {
					entity.addId(FhirCommon.fhirIdentifierToEhcIdentificator(id));
				}

				if (physician.getContained() != null
						&& !physician.getContained().getContainedResources().isEmpty()) {
					for (IResource res : physician.getContained().getContainedResources()) {
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
}
