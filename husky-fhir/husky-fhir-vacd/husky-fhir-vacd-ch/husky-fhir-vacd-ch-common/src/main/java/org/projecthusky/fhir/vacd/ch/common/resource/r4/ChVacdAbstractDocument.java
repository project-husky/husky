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
package org.projecthusky.fhir.vacd.ch.common.resource.r4;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Device;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.PractitionerRole;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.RelatedPerson;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.core.ch.exceptions.InvalidContentException;
import org.projecthusky.fhir.core.ch.exceptions.InvalidResourceException;
import org.projecthusky.fhir.core.ch.resource.r4.ChCoreDocumentEpr;
import org.projecthusky.fhir.core.ch.resource.r4.ChCoreOrganizationEpr;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePatient;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePatientEpr;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePractitionerEpr;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePractitionerRoleEpr;
import org.projecthusky.fhir.core.ch.util.IdUtil;

/**
 * The HAPI custom structure for CH-VACD ImmunizationAdministrationDocument.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */

public abstract class ChVacdAbstractDocument extends ChCoreDocumentEpr {

	private static final long serialVersionUID = 8722090116058643360L;

	protected ChVacdAbstractDocument() {
		this.setLanguage("en-US");

		this.getEntry().clear();
		this.setId(UUID.randomUUID().toString());
		this.setIdentifier(new Identifier().setSystem("urn:ietf:rfc:3986").setValue("urn:uuid:"+this.getIdElement().getIdPart()));
		this.setTimestamp(new Date());
		this.setType(BundleType.DOCUMENT);
	}

	/**
	 * Returns the composition or throws.
	 *
	 * @return the composition.
	 * @throws InvalidContentException
	 *             if the composition is missing.
	 */
	@ExpectsValidResource
	public abstract ChVacdAbstractComposition resolveComposition();

	@ExpectsValidResource
	public Patient resolvePatient() {
		if (this.resolveComposition().hasSubject()) {
			var subjectRef = this.resolveComposition().getSubject();
			if (subjectRef.getResource() instanceof ChCorePatientEpr) {
				return (ChCorePatientEpr) subjectRef.getResource();
			} else if (subjectRef.getResource() instanceof ChCorePatient) {
				return (ChCorePatient) subjectRef.getResource();
			} else if (subjectRef.getResource() instanceof Patient) {
				return (Patient) subjectRef.getResource();
			} else {
				throw new InvalidContentException(
						"The subject of the composition is not a Patient or ChCorePatientEpr");
			}
		} else {
			throw new InvalidContentException("The composition does not have a subject");
		}
	}

	/**
	 * Adds an immunization to the document.
	 * 
	 * @param immunization
	 *            the immunization to add.
	 */
	public void addImmunization(ChVacdImmunization immunization) {
		if (this.resolveComposition().hasSubject()) {
			immunization.setPatient(this.resolveComposition().getSubject());
		}
		IdUtil.checkId(immunization);

		this.getEntry().add(new BundleEntryComponent().setResource(immunization)
				.setFullUrl(immunization.getIdElement().getIdPart()));
		this.resolveComposition().resolveAdministrationSection()
				.addEntry(new Reference(immunization));
	}

	/**
	 * Adds an immunization to the document.
	 * 
	 * @return the created immunization resource.
	 */
	public ChVacdImmunization addImmunization() {
		ChVacdImmunization immunization = new ChVacdImmunization();
		immunization.setId(IdUtil.generateUrnUuid());
		addImmunization(immunization);
		return immunization;
	}

	/**
	 * get all immunization resources from the document.
	 * 
	 * @return list of immunization resources.
	 */
	public List<ChVacdImmunization> resolveImmunizations() {
		return this.getEntryResourceByResourceType(ChVacdImmunization.class);
	}

	/**
	 * Adds a basic immunization to the document.
	 * 
	 * @param basicImmunization
	 *            the basic immunization to add.
	 */
	public void addBasicImmunization(ChVacdBasicImmunization basicImmunization) {
		if (this.resolveComposition().hasSubject()) {
			basicImmunization.setSubject(this.resolveComposition().getSubject());
		}
		IdUtil.checkId(basicImmunization);

		this.getEntry().add(new BundleEntryComponent().setResource(basicImmunization)
				.setFullUrl(basicImmunization.getIdElement().getIdPart()));
		this.resolveComposition().resolveAdministrationSection().addEntry(
				new Reference(basicImmunization));
	}

	/**
	 * Adds a basic immunization to the document.
	 * 
	 * @return the created basic immunization resource
	 */
	public ChVacdBasicImmunization addBasicImmunization() {
		ChVacdBasicImmunization basicImmunization = new ChVacdBasicImmunization();
		basicImmunization.setId(IdUtil.generateUrnUuid());
		addBasicImmunization(basicImmunization);
		return basicImmunization;
	}

	/**
	 * get all basic immunization resources from the document.
	 * 
	 * @return list of basic immunization resources.
	 */
	public List<ChVacdBasicImmunization> resolveBasicImmunizations() {
		return this.getEntryResourceByResourceType(ChVacdBasicImmunization.class);
	}

	/**
	 * Method to create and add a MedicalProblem
	 * 
	 * @return the created medical problem resource
	 */
	public ChVacdMedicalProblem addMedicalProblem() {
		ChVacdMedicalProblem medicalProblem = new ChVacdMedicalProblem();
		medicalProblem.setId(IdUtil.generateUrnUuid());
		addMedicalProblem(medicalProblem);
		return medicalProblem;
	}

	/**
	 * Method to add a MedicalProblem
	 * 
	 * @param medicalProblem
	 *            the MedicalProblem resource to be added
	 */
	public void addMedicalProblem(ChVacdMedicalProblem medicalProblem) {
		if (this.resolveComposition().hasSubject()) {
			medicalProblem.setSubject(this.resolveComposition().getSubject());
		}
		IdUtil.checkId(medicalProblem);

		this.getEntry().add(new BundleEntryComponent().setResource(medicalProblem)
				.setFullUrl(medicalProblem.getIdElement().getIdPart()));
		this.resolveComposition().resolveMedicalProblemSection()
				.addEntry(new Reference(medicalProblem));
	}

	/**
	 * Method get a list of MedicalProblems
	 * 
	 * @return list of MedicalProblems resources
	 */
	public List<ChVacdMedicalProblem> resolveMedicalProblems() {
		return this.getEntryResourceByResourceType(ChVacdMedicalProblem.class);
	}

	/**
	 * Method to create and add LaboratoryAndSerology
	 * 
	 * @return the created and added LaboratoryAndSerology resource
	 */
	public ChVacdLaboratoryAndSerology addLaboratoryAndSerology() {
		ChVacdLaboratoryAndSerology labandser = new ChVacdLaboratoryAndSerology();
		labandser.setId(IdUtil.generateUrnUuid());
		addLaboratoryAndSerology(labandser);
		return labandser;
	}

	/**
	 * Method to add LaboratoryAndSerology
	 * 
	 * @param labandser
	 *            the LaboratoryAndSerology resource to be added
	 */
	public void addLaboratoryAndSerology(ChVacdLaboratoryAndSerology labandser) {
		if (this.resolveComposition().hasSubject()) {
			labandser.setSubject(this.resolveComposition().getSubject());
		}
		IdUtil.checkId(labandser);

		this.getEntry().add(new BundleEntryComponent().setResource(labandser)
				.setFullUrl(labandser.getIdElement().getIdPart()));
		this.resolveComposition().resolveLaboratorySerologySection()
				.addEntry(new Reference(labandser));
	}

	/**
	 * Method get a list of LaboratoryAndSerology
	 * 
	 * @return list of LaboratoryAndSerology resources
	 */
	public List<ChVacdLaboratoryAndSerology> resolveLaboratoryAndSerologies() {
		return this.getEntryResourceByResourceType(ChVacdLaboratoryAndSerology.class);
	}

	/**
	 * Method to create and add AllergyIntolerance.
	 * 
	 * @return the created and added AllergyIntolerance resource
	 */
	public ChVacdAllergyIntolerance addAllergyIntolerance() {
		ChVacdAllergyIntolerance allInt = new ChVacdAllergyIntolerance();
		allInt.setId(IdUtil.generateUrnUuid());
		addAllergyIntolerance(allInt);
		return allInt;
	}

	/**
	 * Method to add AllergyIntolerance resource.
	 */
	public void addAllergyIntolerance(ChVacdAllergyIntolerance allInt) {
		if (this.resolveComposition().hasSubject()) {
			allInt.setPatient(this.resolveComposition().getSubject());
		}
		IdUtil.checkId(allInt);

		this.getEntry().add(new BundleEntryComponent().setResource(allInt)
				.setFullUrl(allInt.getIdElement().getIdPart()));
		this.resolveComposition().resolveAllergyIntolerancesSection()
				.addEntry(new Reference(allInt));

	}

	/**
	 * Method to get list of ChVacdAllergyIntolerance resources.
	 * 
	 * @return the list of ChVacdAllergyIntolerance resources
	 */
	public List<ChVacdAllergyIntolerance> resolveAllergyIntolerances() {
		return this.getEntryResourceByResourceType(ChVacdAllergyIntolerance.class);
	}

	/**
	 * Method to create and add PastIllness resource.
	 * 
	 * @return the created and added PastIllness resource
	 */
	public ChVacdPastIllness addPastIllness() {
		ChVacdPastIllness pastill = new ChVacdPastIllness();
		pastill.setId(IdUtil.generateUrnUuid());
		addPastIllness(pastill);
		return pastill;

	}

	/**
	 * Method to add PastIllness resource.
	 * 
	 * @param pastill
	 *            the PastIllness resource to be added
	 */
	public void addPastIllness(ChVacdPastIllness pastill) {
		if (this.resolveComposition().hasSubject()) {
			pastill.setSubject(this.resolveComposition().getSubject());
		}
		IdUtil.checkId(pastill);

		this.getEntry().add(new BundleEntryComponent().setResource(pastill)
				.setFullUrl(pastill.getIdElement().getIdPart()));
		this.resolveComposition().resolvePastIllnessSection()
				.addEntry(new Reference(pastill));

	}

	public List<ChVacdPastIllness> resolvePastIllnesses() {
		return this.getEntryResourceByResourceType(ChVacdPastIllness.class);
	}

	/**
	 * Set the patient for the document.
	 * 
	 * @param testPatient
	 *            the patient to set.
	 */
	public void setPatient(Patient subject) {
		IdUtil.checkId(subject);
		this.resolveComposition().setSubject(new Reference(subject.getIdElement().getIdPart()));
		this.getEntry().add(new BundleEntryComponent().setResource(subject)
				.setFullUrl(subject.getIdElement().getIdPart()));
		// this.resolveComposition().setSubject(new Reference("urn:uuid:" +
		// subject.getId()));
	}

	public PractitionerRole addPractitionerRole() {
		ChCorePractitionerRoleEpr practitionerRole = new ChCorePractitionerRoleEpr();
		practitionerRole.setId(IdUtil.generateUrnUuid());
		practitionerRole.setPractitioner(new Reference(addPractitioner()));
		practitionerRole.setOrganization(new Reference(addOrganization()));
		addPractitionerRole(practitionerRole);
		return practitionerRole;
	}

	public void addPractitionerRole(PractitionerRole practitionerRole) {
		if (!this.hasEntryByResourceTypeAndId(practitionerRole)) {
			if (practitionerRole.getOrganization() == null
					|| practitionerRole.getPractitioner() == null) {
				throw new InvalidResourceException(
						"The author must have an organization and a practitioner");
			}
			IdUtil.checkId(practitionerRole);

			var org = (Organization) practitionerRole.getOrganization().getResource();
			addOrganization(org);
			var pract = (Practitioner) practitionerRole.getPractitioner().getResource();
			addPractitioner(pract);

			this.getEntry().add(new BundleEntryComponent().setResource(practitionerRole)
					.setFullUrl(practitionerRole.getIdElement().getIdPart()));
		}
	}

	public ChCoreOrganizationEpr addOrganization() {
		ChCoreOrganizationEpr organization = new ChCoreOrganizationEpr();
		organization.setId(IdUtil.generateUrnUuid());
		addOrganization(organization);
		return organization;
	}

	public void addOrganization(Organization organization) {
		if (organization != null && !this.hasEntryByResourceTypeAndId(organization)) {
			IdUtil.checkId(organization);
			this.addEntry(new BundleEntryComponent().setResource(organization)
					.setFullUrl(organization.getIdElement().getIdPart()));
		}
	}

	public ChCorePractitionerEpr addPractitioner() {
		ChCorePractitionerEpr practitioner = new ChCorePractitionerEpr();
		practitioner.setId(IdUtil.generateUrnUuid());
		addPractitioner(practitioner);
		return practitioner;
	}

	public void addPractitioner(Practitioner practitioner) {
		if (practitioner != null && !this.hasEntryByResourceTypeAndId(practitioner)) {
			IdUtil.checkId(practitioner);
			this.addEntry(new BundleEntryComponent().setResource(practitioner)
					.setFullUrl(practitioner.getIdElement().getIdPart()));
		}
	}

	public void addAuthor(DomainResource author, Date timeOfDataInput) {
		// Device
		// RelatedPerson
		// CH Core Patient EPR
		// CH Core Practitioner EPR
		// CH Core PractitionerRole EPR
		// CH Core Organization EPR
		if (author instanceof RelatedPerson || //
				author instanceof Device || //
				author instanceof ChCorePatientEpr || //
				author instanceof ChCorePractitionerEpr || //
				author instanceof ChCorePractitionerRoleEpr || //
				author instanceof ChCoreOrganizationEpr //
		) {
			if (author.getId() == null) {
				author.setId(IdUtil.generateUrnUuid());
			}
			// var ref = new Reference("urn:uuid:" + author.getId());
			var ref = new Reference(author);
			ref.addExtension()
					.setUrl("http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-time")
					.setValue(new DateTimeType(timeOfDataInput));

			if (!this.hasEntryByResourceTypeAndId(author)) {

				if (author instanceof PractitionerRole) {
					addPractitionerRole((PractitionerRole) author);
				} else {
					this.addEntry(new BundleEntryComponent().setResource(author)
							.setFullUrl(author.getIdElement().getIdPart()));
				}

			}
			this.resolveComposition().addAuthor(ref);

		} else {
			throw new InvalidResourceException(
					"The author must be of type RelatedPerson, Device, ChCorePatientEpr, ChCorePractitionerEpr, ChCorePractitionerRoleEpr or ChCoreOrganizationEpr");
		}

	}

	/**
	 * Method to create and add MedicationForImmunization
	 * 
	 * @return the created and added MedicationForImmunization resource
	 */
	public ChVacdMedicationForImmunization addMedication() {
		ChVacdMedicationForImmunization medication = new ChVacdMedicationForImmunization();
		medication.setId(IdUtil.generateUrnUuid());
		addMedication(medication);
		return medication;
	}

	/**
	 * Method to add MedicationForImmunization
	 * 
	 * @param medication
	 *            the MedicationForImmunization resource to be added
	 */
	public void addMedication(ChVacdMedicationForImmunization medication) {
		IdUtil.checkId(medication);
		this.getEntry().add(new BundleEntryComponent().setResource(medication)
				.setFullUrl(medication.getIdElement().getIdPart()));
	}

}
