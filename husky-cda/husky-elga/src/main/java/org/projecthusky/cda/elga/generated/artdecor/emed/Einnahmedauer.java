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

import java.util.ArrayList;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.ObjectFactory;

/**
 * Einnahmedauer
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.30006<br>
 * Effective date: 2013-12-20 00:00:00<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-22")
public class Einnahmedauer extends IVLTS {

    public Einnahmedauer() {
    }

    /**
     * Creates fixed contents for CDA Element hl7EffectiveTime
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.IVLTS createHl7EffectiveTimeFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.IVLTS retVal = factory.createIVLTS();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.IVLTS, filled by: "NA"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.IVLTS getPredefinedEffectiveTimeNa() {
        return createHl7EffectiveTimeFixedValue("NA");
    }

}
