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
package org.projecthusky.valueset.enums;

/**
 * This enum is used to configure the type of source of a ValueSet. This information is used to apply the interface
 * corresponding to the source system. Note: TERMINOLOGIESERVER_SOAP and SWISS_MDI_SOAP are foreseen, but are not going
 * to be implemented in the first release of dynamic value set handling.
 */
public enum SourceSystemType {

    /**
     * Using this source type, the HL7 FHIR interface to ART-DECOR will be used (e.g.
     * http://art-decor.org/fhir/3.0/ch-epr-/valueset).
     */
    ARTDECOR_FHIR,

    /**
     *
     */
    FHIR;

}
