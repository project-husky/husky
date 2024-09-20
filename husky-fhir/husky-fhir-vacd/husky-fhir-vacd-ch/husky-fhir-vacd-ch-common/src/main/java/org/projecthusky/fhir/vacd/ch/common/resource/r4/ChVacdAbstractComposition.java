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

import java.util.Optional;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.projecthusky.fhir.core.ch.resource.r4.ChCoreCompositionEpr;

/**
 * The HAPI custom structure for CH-VACD ImmunizationAdministrationComposition.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
public abstract class ChVacdAbstractComposition extends ChCoreCompositionEpr {

	private static final long serialVersionUID = 4007332080470755578L;

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

	public SectionComponent resolvePastIllnessSection() {
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
