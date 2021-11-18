/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.fhir.structures.ch;

import org.hl7.fhir.r4.model.*;
import org.husky.fhir.structures.gen.FhirCommon;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * Supports the FHIR to eHC conversion for CDA-CH-LRPH documents
 *
 */
public class FhirCdaChLrph /* extends AbstractFhirCdaCh */ {
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
		@Extension(url = FhirCommon.URN_USE_AS_COMMENT, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "comment")
		private Reference comment;

		/** The custodian. */
		@Child(name = "custodian")
		@Extension(url = FhirCommon.URN_USE_AS_CUSTODIAN, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "custodian")
		private Reference custodian;

		/** The doc author. */
		@Child(name = "docAuthor")
		@Extension(url = FhirCommon.URN_USE_AS_AUTHOR, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "author")
		private Reference docAuthor;

		/** The doc language. */
		@Child(name = "docLanguage")
		@Extension(url = FhirCommon.URN_USE_AS_LANGUAGE, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "docLanguage")
		private Reference docLanguage;

		/** The doc type. */
		@Child(name = "docType")
		@Extension(url = FhirCommon.URN_USE_AS_DOC_TYPE, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "docType")
		private Reference docType;

		/** The informationRecipient. */
		@Child(name = "docInformationRecipient")
		@Extension(url = FhirCommon.URN_USE_AS_INFORMATION_RECIPIENT, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "informationRecipient")
		private Reference informationRecipient;

		/** The legal authenticator. */
		@Child(name = "legalAuthenticator")
		@Extension(url = FhirCommon.URN_USE_AS_LEGAL_AUTHENTICATOR, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "legalAuthenticator")
		private Reference legalAuthenticator;

		/** The patient. */
		@Child(name = "patient")
		@Extension(url = FhirCommon.URN_USE_AS_PATIENT, definedLocally = false, isModifier = false)
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
			final var resourceRef = new Reference();
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
			final var resourceRef = new Reference();
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
			final var resourceRef = new Reference();
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
			final var resourceRef = new Reference();
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
			final var resourceRef = new Reference();
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
			final var resourceRef = new Reference();
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
			final var resourceRef = new Reference();
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
			final var resourceRef = new Reference();
			resourceRef.setResource(patient);
			this.patient = resourceRef;
		}
	}

}
