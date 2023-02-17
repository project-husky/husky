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
package org.projecthusky.fhir.emed.ch.common.util;

/**
 * Constants for the common FHIR systems.
 *
 * @author Quentin Ligier
 **/
public class FhirSystem {

    public static final String LOINC = "http://loinc.org";
    public static final String SNOMEDCT = "http://snomed.info/sct";
    public static final String UCUM = "http://unitsofmeasure.org";
    public static final String URI = "urn:ietf:rfc:3986";
    public static final String GLN = "urn:oid:2.51.1.3";

    /**
     * ZSR-Nummer (de), numero RCC (fr, it)
     */
    public static final String ZSR = "urn:oid:2.16.756.5.30.1.123.100.2.1.1";

    /**
     * BUR-Nummer (de), numero REE (fr), numero RIS (it)
     */
    public static final String BER = "urn:oid:2.16.756.5.45";

    public static final String UIDB = "urn:oid:2.16.756.5.35";

    public static final String GTIN = "urn:oid:2.51.1.1";

    public static final String ATC = "urn:oid:2.16.840.1.113883.6.73";

    /**
     * This class is not instantiable.
     */
    private FhirSystem() {
    }
}
