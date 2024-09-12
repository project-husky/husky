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

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * 
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-composition-immunization-administration")
public class ChVacdImmunizationAdministrationComposition extends ChCoreCompositionEpr {
	
	public ChVacdImmunizationAdministrationComposition() {
		super();
		setStatus(CompositionStatus.FINAL);
	}

	public SectionComponent resolveAdministrationSection() {
		// Fixed Value: http://loinc.org
		// Fixed Value: 11369-6

		Optional<SectionComponent> section = this
				.resolveSectionByCode(new Coding("http://loinc.org", "11369-6", ""));
		if (section.isEmpty()) {
			SectionComponent sectionComponent = new SectionComponent();
			sectionComponent.setCode(new CodeableConcept(
					new Coding().setSystem("http://loinc.org").setCode("11369-6")));
			this.getSection().add(sectionComponent);

			section = Optional.of(sectionComponent);
		}

		return section.get();
	}

}
