/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.ems;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040DocumentationOf;

/**
 * epims_header_documentationOfServiceEventInfDisNote
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.1.36<br>
 * Effective date: 2020-02-20 10:42:57<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class EpimsHeaderDocumentationOfServiceEventInfDisNote extends POCDMT000040DocumentationOf {

    public EpimsHeaderDocumentationOfServiceEventInfDisNote() {
        super.getTypeCode().add("DOC");
        super.setServiceEvent(createHl7ServiceEventFixedValue("ACT",
                                                              "EVN"));
    }

    /**
     * Creates fixed contents for CDA Element hl7ServiceEvent
     *
     * @param classCode the desired fixed value for this argument.
     * @param moodCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040ServiceEvent createHl7ServiceEventFixedValue(String classCode, String moodCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040ServiceEvent retVal = factory.createPOCDMT000040ServiceEvent();
        retVal.getClassCode().add(classCode);
        retVal.getMoodCode().add(moodCode);
        return retVal;
    }

    /**
     * Gets the hl7ServiceEvent
     */
    public org.husky.common.hl7cdar2.POCDMT000040ServiceEvent getHl7ServiceEvent() {
        return serviceEvent;
    }

    /**
     * Sets the hl7ServiceEvent
     */
    public void setHl7ServiceEvent(org.husky.common.hl7cdar2.POCDMT000040ServiceEvent value) {
        this.serviceEvent = value;
    }
}
