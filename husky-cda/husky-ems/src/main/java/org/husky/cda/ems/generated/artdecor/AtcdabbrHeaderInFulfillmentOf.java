/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.ems.generated.artdecor;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040InFulfillmentOf;

/**
 * atcdabbr_header_InFulfillmentOf
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.1.9<br>
 * Effective date: 2021-06-28 13:42:25<br>
 * Version: 1.0.1+20210628<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class AtcdabbrHeaderInFulfillmentOf extends POCDMT000040InFulfillmentOf {

    public AtcdabbrHeaderInFulfillmentOf() {
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
