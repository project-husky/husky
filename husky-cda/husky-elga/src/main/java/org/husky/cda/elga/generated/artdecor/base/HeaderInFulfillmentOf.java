/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.base;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040InFulfillmentOf;

/**
 * HeaderInFulfillmentOf
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.20009<br>
 * Effective date: 2011-12-19 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-21")
public class HeaderInFulfillmentOf extends POCDMT000040InFulfillmentOf {

    public HeaderInFulfillmentOf() {
        super.setTypeCode(org.husky.common.hl7cdar2.ActRelationshipFulfills.FLFS);
        super.setOrder(createHl7OrderFixedValue("ACT",
                                                "RQO"));
    }

    /**
     * Creates fixed contents for CDA Element hl7Order
     *
     * @param classCode the desired fixed value for this argument.
     * @param moodCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Order createHl7OrderFixedValue(String classCode, String moodCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040Order retVal = factory.createPOCDMT000040Order();
        retVal.getClassCode().add(classCode);
        retVal.getMoodCode().add(moodCode);
        return retVal;
    }

    /**
     * Gets the hl7Order
     */
    public org.husky.common.hl7cdar2.POCDMT000040Order getHl7Order() {
        return order;
    }

    /**
     * Sets the hl7Order
     */
    public void setHl7Order(org.husky.common.hl7cdar2.POCDMT000040Order value) {
        this.order = value;
    }
}
