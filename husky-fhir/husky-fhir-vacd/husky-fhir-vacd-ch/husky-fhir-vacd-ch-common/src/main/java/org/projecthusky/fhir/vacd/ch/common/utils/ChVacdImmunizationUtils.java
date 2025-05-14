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
package org.projecthusky.fhir.vacd.ch.common.utils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.ConceptMap;
import org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent;

import ca.uhn.fhir.context.FhirContext;

/**
 * 
 */
public class ChVacdImmunizationUtils {

	private static String vaccineToTargetDiseaseMappingUrl = "https://fhir.ch/ig/ch-term/ConceptMap-ch-vacd-vaccines-targetdiseases-cm.json";
	private static String vaccineSCTToTargetDiseaseMappingUrl = "https://fhir.ch/ig/ch-term/ConceptMap-ch-vacd-vaccines-sct-targetdiseases-cm.json";

	public static List<CodeableConcept> getTargetDiseaseFromVaccineCode(
			CodeableConcept vaccineCode) {

		List<CodeableConcept> targetDiseases = new ArrayList<>();
		try {
			URL cmUrl = null;
			if ("http://fhir.ch/ig/ch-vacd/CodeSystem/ch-vacd-swissmedic-cs"
					.equals(vaccineCode.getCodingFirstRep().getSystem())
					|| "http://fhir.ch/ig/ch-vacd/CodeSystem/ch-vacd-myvaccines-cs"
							.equals(vaccineCode.getCodingFirstRep().getSystem())) {
				cmUrl = new URL(vaccineToTargetDiseaseMappingUrl);
			} else if ("http://snomed.info/sct"
					.equals(vaccineCode.getCodingFirstRep().getSystem())) {
				cmUrl = new URL(vaccineSCTToTargetDiseaseMappingUrl);
			}

			FhirContext ctx = FhirContext.forR4();
			ConceptMap cm = ctx.newJsonParser().parseResource(ConceptMap.class,
					cmUrl.openConnection().getInputStream());

			Optional<ConceptMapGroupComponent> group = cm.getGroup().stream()
					.filter(filter -> filter.getSource()
							.equals(vaccineCode.getCodingFirstRep().getSystem()))
					.findFirst();
			if (group.isPresent()) {
				List<TargetElementComponent> elements = group.get().getElement().stream()
						.filter(filter -> filter.getCode()
								.equals(vaccineCode.getCodingFirstRep().getCode()))
						.findFirst().get().getTarget();

				String system = group.get().getTarget();
				elements.forEach(element -> targetDiseases.add(new CodeableConcept(
						new Coding(system, element.getCode(), element.getDisplay()))));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return targetDiseases;
	}

}
