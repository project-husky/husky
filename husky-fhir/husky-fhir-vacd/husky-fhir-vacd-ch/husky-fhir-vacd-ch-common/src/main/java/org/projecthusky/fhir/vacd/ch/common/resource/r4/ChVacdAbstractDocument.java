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
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePatientEpr;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePractitionerEpr;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePractitionerRoleEpr;

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
		this.setIdentifier(new Identifier().setSystem("urn:ietf:rfc:3986")
				.setValue("urn:uuid:" + this.getId()));
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

		this.getEntry().add(new BundleEntryComponent().setResource(immunization)
				.setFullUrl("urn:uuid:" + immunization.getId()));
		this.resolveComposition().resolveAdministrationSection()
				.addEntry(new Reference("urn:uuid:" + immunization.getId()));
	}

	/**
	 * Adds an immunization to the document.
	 * 
	 * @return the created immunization resource.
	 */
	public ChVacdImmunization addImmunization() {
		ChVacdImmunization immunization = new ChVacdImmunization();
		immunization.setId(UUID.randomUUID().toString());
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

		this.getEntry().add(new BundleEntryComponent().setResource(basicImmunization)
				.setFullUrl("urn:uuid:" + basicImmunization.getId()));
		this.resolveComposition().resolveAdministrationSection()
				.addEntry(new Reference("urn:uuid:" + basicImmunization.getId()));
	}

	/**
	 * Adds a basic immunization to the document.
	 * 
	 * @return the created basic immunization resource
	 */
	public ChVacdBasicImmunization addBasicImmunization() {
		ChVacdBasicImmunization basicImmunization = new ChVacdBasicImmunization();
		basicImmunization.setId(UUID.randomUUID().toString());
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
		medicalProblem.setId(UUID.randomUUID().toString());
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

		this.getEntry().add(new BundleEntryComponent().setResource(medicalProblem)
				.setFullUrl("urn:uuid:" + medicalProblem.getId()));
		this.resolveComposition().resolveMedicalProblemSection()
				.addEntry(new Reference("urn:uuid:" + medicalProblem.getId()));
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
		labandser.setId(UUID.randomUUID().toString());
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

		this.getEntry().add(new BundleEntryComponent().setResource(labandser)
				.setFullUrl("urn:uuid:" + labandser.getId()));
		this.resolveComposition().resolveLaboratorySerologySection()
				.addEntry(new Reference("urn:uuid:" + labandser.getId()));
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
		allInt.setId(UUID.randomUUID().toString());
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

		this.getEntry().add(new BundleEntryComponent().setResource(allInt)
				.setFullUrl("urn:uuid:" + allInt.getId()));
		this.resolveComposition().resolveAllergyIntolerancesSection()
				.addEntry(new Reference("urn:uuid:" + allInt.getId()));

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
		pastill.setId(UUID.randomUUID().toString());
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

		this.getEntry().add(new BundleEntryComponent().setResource(pastill)
				.setFullUrl("urn:uuid:" + pastill.getId()));
		this.resolveComposition().resolvePastIllnessSection()
				.addEntry(new Reference("urn:uuid:" + pastill.getId()));

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
		if (subject.getId() == null) {
			subject.setId(UUID.randomUUID().toString());
		}
		this.resolveComposition().setSubject(new Reference("urn:uuid:" + subject.getId()));
		this.getEntry().add(new BundleEntryComponent().setResource(subject)
				.setFullUrl("urn:uuid:" + subject.getId()));
//		this.resolveComposition().setSubject(new Reference("urn:uuid:" + subject.getId()));
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
				author.setId(UUID.randomUUID().toString());
			}
			var ref = new Reference("urn:uuid:" + author.getId());
			ref.addExtension()
					.setUrl("http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-time")
					.setValue(new DateTimeType(timeOfDataInput));
			this.resolveComposition().addAuthor(ref);
			if (!this.hasEntryByResourceTypeAndId(author)) {

				this.addEntry(new BundleEntryComponent().setResource(author)
						.setFullUrl("urn:uuid:" + author.getId()));
				if (author instanceof PractitionerRole) {
					var practRole = ((PractitionerRole) author);
					if (practRole.getOrganization() == null
							|| practRole.getPractitioner() == null) {
						throw new InvalidResourceException(
								"The author must have an organization and a practitioner");
					}
					var org = (Organization) practRole.getOrganization().getResource();
					if (!this.hasEntryByResourceTypeAndId(org)) {
						this.addEntry(new BundleEntryComponent().setResource(org)
								.setFullUrl("urn:uuid:" + (org.getId() != null ? org.getId()
										: UUID.randomUUID().toString())));
					}
					var pract = (Practitioner) practRole.getPractitioner().getResource();
					if (!this.hasEntryByResourceTypeAndId(pract)) {
						this.addEntry(new BundleEntryComponent().setResource(pract)
								.setFullUrl("urn:uuid:" + (pract.getId() != null ? pract.getId()
										: UUID.randomUUID().toString())));
					}
				}

			}

		} else {
			throw new InvalidResourceException(
					"The author must be of type RelatedPerson, Device, ChCorePatientEpr, ChCorePractitionerEpr, ChCorePractitionerRoleEpr or ChCoreOrganizationEpr");
		}

	}

}
