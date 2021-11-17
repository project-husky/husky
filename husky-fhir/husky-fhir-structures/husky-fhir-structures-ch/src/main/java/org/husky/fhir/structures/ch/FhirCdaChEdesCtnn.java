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

package org.husky.fhir.structures.ch;

import org.hl7.fhir.r4.model.Basic;
import org.hl7.fhir.r4.model.DocumentManifest;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Person;
import org.hl7.fhir.r4.model.Reference;
import org.husky.fhir.structures.gen.FhirCommon;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * Supports the FHIR to eHC conversion for EDES CTNN documents
 *
 */
public class FhirCdaChEdesCtnn /* extends AbstractFhirCdaCh */ {

	/**
	 * The class EdesCtnnDocument is a derived FHIR resource containing all
	 * information of an Emergency Department Encounter Summary document based
	 * on a Composite Triage and Nursing Note corresponding to the CDA-CH-EDES
	 * specification
	 */
	@ResourceDef(name = "DocumentManifest")
	public static class EdesCtnnDocument extends DocumentManifest {

		private static final long serialVersionUID = 7883384366035439713L;

		/** The confidentiality. */
		@Child(name = "confidentiality")
		@Extension(url = FhirCommon.URN_USE_AS_CONFIDENTIALITY, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "confidentiality")
		private Reference confidentiality;

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

		/** The comment. */
		@Child(name = "comment")
		@Extension(url = FhirCommon.URN_USE_AS_COMMENT, definedLocally = false, isModifier = false)
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
			final var resourceRef = new Reference();
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
			final var resourceRef = new Reference();
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
