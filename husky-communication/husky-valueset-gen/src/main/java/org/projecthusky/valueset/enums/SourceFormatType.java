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
 * This enum allows a ValueSet to be configured according to its format. Based on this case distinction, the
 * de-serialization corresponding to the data format is applied.
 */
public enum SourceFormatType {

    /**
     * The ValueSet is available in IHE SVS XML format.
     * <p>
     * Mime type: application/xml
     */
    IHESVS,

    /**
     * The ValueSet is available in JSON format.
     * <p>
     * Mime type: application/fhir+json
     */
    JSON,

    /**
     * The ValueSet is available in XML format.
     * <p>
     * Mime type: application/fhir+xml
     */
    XML;
}
