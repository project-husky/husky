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

import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.PIVLTS;
import org.projecthusky.common.hl7cdar2.SetOperator;

import javax.annotation.processing.Generated;

/**
 * Dosierung3
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.30009<br>
 * Effective date: 2015-09-05 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-22")
public class Dosierung3 extends PIVLTS {

    public Dosierung3() {
    }

    /**
     * Creates fixed contents for CDA Element hl7EffectiveTime
     *
     * @param operator the desired fixed value for this argument.
     */
	private static org.projecthusky.common.hl7cdar2.PIVLTS createHl7EffectiveTimeFixedValue(String operator) {
        ObjectFactory factory = new ObjectFactory();
		org.projecthusky.common.hl7cdar2.PIVLTS retVal = factory.createPIVLTS();
		retVal.setOperator(SetOperator.fromValue(operator));
        return retVal;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.PIVL_TS, filled by: "A"
     * @return the predefined element.
     */
	public static org.projecthusky.common.hl7cdar2.PIVLTS getPredefinedEffectiveTimeA() {
        return createHl7EffectiveTimeFixedValue("A");
    }

}
