/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.emed;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.PIVLTS;
import org.husky.common.hl7cdar2.SetOperator;

/**
 * Dosierung1
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.30007<br>
 * Effective date: 2014-09-02 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-22")
public class Dosierung1 extends PIVLTS {

    public Dosierung1() {
		super.setOperator(SetOperator.A);
		super.setInstitutionSpecified(true);
        super.setPeriod(createHl7PeriodFixedValue("1"));
    }

    /**
     * Creates fixed contents for CDA Element hl7Period
     *
     * @param value the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.PQ createHl7PeriodFixedValue(String value) {
        org.husky.common.hl7cdar2.PQ retVal = new org.husky.common.hl7cdar2.PQ();
        retVal.setValue(value);
        return retVal;
    }

    /**
     * Gets the hl7Period
     */
    public org.husky.common.hl7cdar2.PQ getHl7Period() {
		return this.period;
    }

    /**
     * Sets the hl7Period
     */
    public void setHl7Period(org.husky.common.hl7cdar2.PQ value) {
		this.period = value;
    }
}
