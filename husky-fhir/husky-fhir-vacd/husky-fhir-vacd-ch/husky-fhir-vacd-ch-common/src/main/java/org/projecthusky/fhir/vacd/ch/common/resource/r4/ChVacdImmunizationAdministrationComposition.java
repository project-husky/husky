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
import java.util.Optional;
import java.util.UUID;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Identifier;
import org.projecthusky.fhir.core.ch.resource.r4.ChCoreCompositionEpr;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * 
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-composition-immunization-administration")
public class ChVacdImmunizationAdministrationComposition extends ChCoreCompositionEpr {

	public ChVacdImmunizationAdministrationComposition() {
		super();
		setStatus(CompositionStatus.FINAL);
		setDate(new Date());
		setTitle("Immunization Administration");
		setType(new CodeableConcept(new Coding("http://snomed.info/sct", "41000179103", "")));
		addCategory(new CodeableConcept(new Coding("urn:oid:2.16.756.5.30.1.127.3.10.10",
				"urn:che:epr:ch-vacd:immunization-administration:2022", "")));
		setIdentifier(new Identifier().setSystem("urn:ietf:rfc:3986")
				.setValue("urn:uuid:" + UUID.randomUUID().toString()));
		setConfidentiality(DocumentConfidentiality.N);
		getConfidentialityElement().addExtension().setUrl(
				"http://fhir.ch/ig/ch-core/5.0.0-ballot/StructureDefinition-ch-ext-epr-confidentialitycode.html")
				.setValue(new CodeableConcept(new Coding("http://snomed.info/sct", "17621005",
						"Normal (qualifier value)")));
	}

	public SectionComponent resolveAdministrationSection() {
		// Fixed Value: http://loinc.org
		// Fixed Value: 11369-6

		Optional<SectionComponent> section = this
				.resolveSectionByCode(new Coding("http://loinc.org", "11369-6", ""));
		if (section.isEmpty()) {
			SectionComponent sectionComponent = createSectionComponent("http://loinc.org",
					"11369-6", "List Immunization Administration");
			this.getSection().add(sectionComponent);

			section = Optional.of(sectionComponent);
		}

		return section.get();
	}

	public SectionComponent resolveMedicalProblemSection() {
		// Fixed Value: http://loinc.org
		// Fixed Value: 11450-4

		Optional<SectionComponent> section = this
				.resolveSectionByCode(new Coding("http://loinc.org", "11450-4", ""));
		if (section.isEmpty()) {
			SectionComponent sectionComponent = createSectionComponent("http://loinc.org",
					"11450-4", "List Medical Problems");
			this.getSection().add(sectionComponent);
			section = Optional.of(sectionComponent);
		}

		return section.get();
	}

	public SectionComponent resolvePreviousIllnessSection() {
		// Fixed Value: http://loinc.org
		// Fixed Value: 11348-0

		Optional<SectionComponent> section = this
				.resolveSectionByCode(new Coding("http://loinc.org", "11348-0", ""));
		if (section.isEmpty()) {
			SectionComponent sectionComponent = createSectionComponent("http://loinc.org",
					"11348-0", "Previous illnesses");
			this.getSection().add(sectionComponent);
			section = Optional.of(sectionComponent);
		}

		return section.get();
	}
	
	public SectionComponent resolveAllergyIntolerancesSection() {
		// Fixed Value: http://loinc.org
		// Fixed Value: 48765-2

		Optional<SectionComponent> section = this
				.resolveSectionByCode(new Coding("http://loinc.org", "48765-2", ""));
		if (section.isEmpty()) {
			SectionComponent sectionComponent = createSectionComponent("http://loinc.org",
					"48765-2", "Allergies");
			this.getSection().add(sectionComponent);
			section = Optional.of(sectionComponent);
		}

		return section.get();
	}
	
	public SectionComponent resolveLaboratorySerologySection() {
		// Fixed Value: http://loinc.org
		// Fixed Value: 18727-8

		Optional<SectionComponent> section = this
				.resolveSectionByCode(new Coding("http://loinc.org", "18727-8", ""));
		if (section.isEmpty()) {
			SectionComponent sectionComponent = createSectionComponent("http://loinc.org",
					"18727-8", "Laboratory findings - Serology");
			this.getSection().add(sectionComponent);
			section = Optional.of(sectionComponent);
		}

		return section.get();
	}

	private SectionComponent createSectionComponent(String codeSystem, String codeValue,
			String aTitle) {
		SectionComponent sectionComponent = new SectionComponent();
		sectionComponent.setTitle(aTitle);
		sectionComponent.setCode(
				new CodeableConcept(new Coding().setSystem(codeSystem).setCode(codeValue)));
		return sectionComponent;
	}

}
