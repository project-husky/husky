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

import org.hl7.fhir.r4.model.DateTimeType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-V ACD MedicalProblem.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-medical-problems")
public class ChVacdMedicalProblem extends ChVacdCondition {

	private static final long serialVersionUID = 4299327185023027123L;

	public ChVacdMedicalProblem() {
		super();
		addCategory().addCoding()
				.setSystem("http://terminology.hl7.org/CodeSystem/condition-category")
				.setCode("problem-list-item");
		setOnset(new DateTimeType().setValue(new Date()));
	}
}
