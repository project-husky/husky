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
import java.util.UUID;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Identifier;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-VACD ImmunizationAdministrationComposition.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-composition-immunization-administration")
public class ChVacdImmunizationAdministrationComposition extends ChVacdAbstractComposition {

	private static final long serialVersionUID = -6486580355822938801L;

	public ChVacdImmunizationAdministrationComposition() {
		super();
		setStatus(CompositionStatus.FINAL);
		setDate(new Date());
		setTitle("Immunization Administration");
		setType(new CodeableConcept(new Coding("http://snomed.info/sct", "41000179103", "")));
		getCategory().clear();
		addCategory(new CodeableConcept(new Coding("urn:oid:2.16.756.5.30.1.127.3.10.10",
				"urn:che:epr:ch-vacd:immunization-administration:2022", "CH VACD Immunization Administration")));
		setIdentifier(new Identifier().setSystem("urn:ietf:rfc:3986")
				.setValue("urn:uuid:" + UUID.randomUUID().toString()));
		setConfidentiality(DocumentConfidentiality.N);
		getConfidentialityElement().addExtension().setUrl(
				"http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-confidentialitycode")
				.setValue(new CodeableConcept(new Coding("http://snomed.info/sct", "17621005",
						"Normal (qualifier value)")));
	}
}
