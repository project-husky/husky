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
package org.projecthusky.fhir.core.ch.resource.r4;

import org.hl7.fhir.r4.model.AllergyIntolerance;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-Core AllergyIntolerance.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-allergyintolerance")
public class ChCoreAllergyIntolerance extends AllergyIntolerance {

	private static final long serialVersionUID = 7469044937093292404L;

}
