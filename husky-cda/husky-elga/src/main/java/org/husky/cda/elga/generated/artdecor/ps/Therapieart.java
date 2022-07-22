/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.ps;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;

/**
 * Therapieart
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.30045<br>
 * Effective date: 2014-09-10 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class Therapieart extends POCDMT000040EntryRelationship {

    public Therapieart() {
        super.setTypeCode(org.husky.common.hl7cdar2.XActRelationshipEntryRelationship.COMP);
        super.setAct(createHl7ActFixedValue("ACT",
                                            "INT"));
    }

    /**
     * Creates fixed contents for CDA Element hl7Act
     *
     * @param classCode the desired fixed value for this argument.
     * @param moodCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Act createHl7ActFixedValue(String classCode, String moodCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040Act retVal = factory.createPOCDMT000040Act();
        retVal.setClassCode(org.husky.common.hl7cdar2.XActClassDocumentEntryAct.fromValue(classCode));
        retVal.setMoodCode(org.husky.common.hl7cdar2.XDocumentActMood.fromValue(moodCode));
        return retVal;
    }

    /**
     * Gets the hl7Act
     */
    public org.husky.common.hl7cdar2.POCDMT000040Act getHl7Act() {
        return act;
    }

    /**
     * Sets the hl7Act
     */
    public void setHl7Act(org.husky.common.hl7cdar2.POCDMT000040Act value) {
        this.act = value;
    }
}
