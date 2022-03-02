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
import org.husky.common.hl7cdar2.POCDMT000040Component1;

/**
 * HeaderEncompassingEncounter
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.20013<br>
 * Effective date: 2011-12-19 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-21")
public class HeaderEncompassingEncounter extends POCDMT000040Component1 {

    public HeaderEncompassingEncounter() {
        super.setTypeCode(org.husky.common.hl7cdar2.ActRelationshipHasComponent.COMP);
        super.setEncompassingEncounter(createHl7EncompassingEncounterFixedValue("ENC",
                                                                                "EVN"));
    }

    /**
     * Creates fixed contents for CDA Element hl7EncompassingEncounter
     *
     * @param classCode the desired fixed value for this argument.
     * @param moodCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040EncompassingEncounter createHl7EncompassingEncounterFixedValue(String classCode, String moodCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040EncompassingEncounter retVal = factory.createPOCDMT000040EncompassingEncounter();
        retVal.getClassCode().add(classCode);
        retVal.getMoodCode().add(moodCode);
        return retVal;
    }

    /**
     * Gets the hl7EncompassingEncounter
     */
    public org.husky.common.hl7cdar2.POCDMT000040EncompassingEncounter getHl7EncompassingEncounter() {
        return encompassingEncounter;
    }

    /**
     * Sets the hl7EncompassingEncounter
     */
    public void setHl7EncompassingEncounter(org.husky.common.hl7cdar2.POCDMT000040EncompassingEncounter value) {
        this.encompassingEncounter = value;
    }
}
