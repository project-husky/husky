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

import org.ehealth_connector.cda.AbstractVitalSignObservation;
import org.ehealth_connector.cda.ch.edes.CdaChEdesEdpn;
import org.ehealth_connector.cda.ch.edes.VitalSignObservation;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.fhir.FhirCommon;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.api.IDatatype;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.QuantityDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Basic;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.Observation;
import ca.uhn.fhir.model.dstu2.resource.Observation.Component;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Person;
import ca.uhn.fhir.model.primitive.DateTimeDt;
import ca.uhn.fhir.parser.IParser;

public class FhirCdaChEdesEdpn extends AbstractFhirCdaCh {

	/**
	 * <div class="en">uniform resource name (urn) of this OID</div> <div
	 * class="de"></div><div class="fr"></div>
	 */
	public static final String OID_EDESEDPN = "urn:oid:" + CdaChEdesEdpn.OID_MAIN;

	private final FhirContext fhirCtx = new FhirContext();

	/**
	 * <div class="en">Creates an eHC CdaChEdesEdpn instance from a valid FHIR
	 * Bundle resource</div> <div class="de"></div> <div class="fr"></div>
	 * 
	 * @param bundle
	 *            <div class="en">valid CdaChEdesCtnn FHIR bundle resource</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param xsl
	 *            <div class="en">desired stylesheet for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @param css
	 *            <div class="en">desired CSS for the CDA document</div>
	 *            <div class="de"></div> <div class="fr"></div>
	 * @return <div class="en">eHC CdaChEdesCtnn instance containing payload of
	 *         the given FHIR Bundle resource</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public CdaChEdesEdpn createEdesEdpnFromFHIRBundle(Bundle bundle, String xsl, String css) {

		// Header
		final CdaChEdesEdpn doc = new CdaChEdesEdpn(getDocLanguage(bundle), xsl, css);
		doc.setConfidentialityCode(getConfidentialityCode(bundle));
		doc.setPatient(FhirCommon.getPatient(bundle));

		Author docAuthor = null;
		for (final Author author : getAuthors(bundle)) {
			author.setTime(new Date());
			doc.addAuthor(author);
			docAuthor = author;
		}
		doc.setCustodian(getCustodian(bundle));
		doc.setLegalAuthenticator(getLegalAuthenticator(bundle));

		// Body
		String narrative = getNarrative(bundle, FhirCommon.urnUseAsActiveProblemConcern);
		if(narrative != null && ! narrative.isEmpty()) {
			doc.setNarrativeTextSectionActiveProblems(narrative);
		}

		narrative = getNarrative(bundle, FhirCommon.urnUseAsAdvanceDirectives);
		if (narrative != null && !narrative.isEmpty()) {
			doc.setNarrativeTextSectionAdvanceDirectives(narrative);
		}

		List<VitalSignObservation> vitalSigns = getCodedVitalSigns(bundle);
		if (vitalSigns != null && !vitalSigns.isEmpty()) {
			for (AbstractVitalSignObservation abstractVitalSignObservation : vitalSigns) {
				doc.addCodedVitalSign((VitalSignObservation) abstractVitalSignObservation,
						docAuthor);
			}
		}

		return doc;
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
	public List<org.ehealth_connector.cda.ch.edes.VitalSignObservation> getCodedVitalSigns(
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
	 * Read the EdesCtnnDocument object from the FHIR bundle file
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

	/**
	 * The class EdesCtnnDocument is a derived FHIR Bundle containing all
	 * information of an Emergency Department Encounter Summary document based
	 * on a Composite Triage and Nursing Note corresponding to the CDA-CH-EDES
	 * specification
	 */
	@ResourceDef(name = "Bundle")
	public static class EdesEdpnDocument extends Bundle {

		private static final long serialVersionUID = 7883384366035439713L;

		/** The confidentiality. */
		@Child(name = "confidentiality")
		@Extension(url = FhirCommon.urnUseAsConfidentiality, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "confidentiality")
		private ResourceReferenceDt confidentiality;

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

		/** The comment. */
		@Child(name = "comment")
		@Extension(url = FhirCommon.urnUseAsComment, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "comment")
		private ResourceReferenceDt comment;

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
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
			final ResourceReferenceDt resourceRef = new ResourceReferenceDt();
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
	};
}
