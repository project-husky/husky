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
package org.projecthusky.fhir.emed.ch.common.resource;


import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.hl7.fhir.r4.model.HumanName;

/**
 * The HAPI custom structure for CH-CORE HumanName.
 *
 * @author Quentin Ligier
 **/
public class ChCoreHumanName extends HumanName {
    // TODO add support for extensions

    /*@Child(name = "ech11name")
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-ech-11-name", definedLocally = false)
    protected ? ech11Name;*/

    /*@Child(name = "ech11firstname")
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-ech-11-firstname", definedLocally = false)
    protected ? ech11FirstName;*/

    /*@Child(name = "salutationandtitle")
    @Extension(url = "http://hl7.org/fhir/StructureDefinition/iso21090-EN-qualifier", definedLocally = false)
    protected ? salutationAndTitle;*/

    /**
     * Constructor
     */
    public ChCoreHumanName() {
        super();
    }

}
