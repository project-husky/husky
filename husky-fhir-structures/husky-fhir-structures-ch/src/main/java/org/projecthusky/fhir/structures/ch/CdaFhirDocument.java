package org.projecthusky.fhir.structures.ch;

import org.hl7.fhir.r4.model.Basic;
import org.hl7.fhir.r4.model.DocumentManifest;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Person;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.fhir.structures.gen.FhirCommon;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;

/* derived from external library */
@SuppressWarnings("java:S110")
public class CdaFhirDocument extends DocumentManifest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8194409636672533163L;

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

	/** The legal authenticator. */
	@Child(name = "legalAuthenticator")
	@Extension(url = FhirCommon.URN_USE_AS_LEGAL_AUTHENTICATOR, definedLocally = false, isModifier = false)
	@Description(shortDefinition = "legalAuthenticator")
	private Reference legalAuthenticator;

	/** The patient. */
	@Child(name = "patient")
	@Extension(url = FhirCommon.URN_USE_AS_PATIENT, definedLocally = false, isModifier = false)
	@Description(shortDefinition = "patient")
	private Reference patientReference;

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
		if (this.patientReference != null) {
			return (Patient) this.patientReference.getResource();
		}
		return null;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(Observation comment) {
		final var resourceRef = new Reference();
		resourceRef.setResource(comment);
		this.comment = resourceRef;
	}

	/**
	 * Sets the custodian.
	 *
	 * @param custodian the new custodian
	 */
	public void setCustodian(Organization custodian) {
		final var resourceRef = new Reference();
		resourceRef.setResource(custodian);
		this.custodian = resourceRef;
	}

	/**
	 * Sets the doc author.
	 *
	 * @param author the new doc author
	 */
	public void setDocAuthor(Person author) {
		final var resourceRef = new Reference();
		resourceRef.setResource(author);
		this.docAuthor = resourceRef;
	}

	/**
	 * Sets the doc language.
	 *
	 * @param language the new doc language
	 */
	public void setDocLanguage(Basic language) {
		final var resourceRef = new Reference();
		resourceRef.setResource(language);
		this.docLanguage = resourceRef;
	}

	/**
	 * Sets the doc type.
	 *
	 * @param typePseudonymized the new doc type
	 */
	public void setDocType(Basic typePseudonymized) {
		final var resourceRef = new Reference();
		resourceRef.setResource(typePseudonymized);
		this.docType = resourceRef;
	}

	/**
	 * Sets the legal authenticator.
	 *
	 * @param legalAuthenticator the new legal authenticator
	 */
	public void setLegalAuthenticator(Person legalAuthenticator) {
		final var resourceRef = new Reference();
		resourceRef.setResource(legalAuthenticator);
		this.legalAuthenticator = resourceRef;
	}

	/**
	 * Sets the patient.
	 *
	 * @param patient the new patient
	 */
	public void setPatient(Patient patient) {
		final var resourceRef = new Reference();
		resourceRef.setResource(patient);
		this.patientReference = resourceRef;
	}

}
