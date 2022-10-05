/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.emed;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.SXCMTS;

/**
 * Dosierung3dq
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.30041<br>
 * Effective date: 2015-09-05 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-22")
public class Dosierung3dq extends SXCMTS {

    public Dosierung3dq() {
    }

    /**
     * Creates fixed contents for CDA Element hl7DoseQuantity
     */
    private static org.projecthusky.common.hl7cdar2.IVLPQ createHl7DoseQuantityFixedValue() {
        org.projecthusky.common.hl7cdar2.IVLPQ retVal = new org.projecthusky.common.hl7cdar2.IVLPQ();
        return retVal;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.IVLPQ, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.IVLPQ getPredefinedDoseQuantity() {
        return createHl7DoseQuantityFixedValue();
    }

}
