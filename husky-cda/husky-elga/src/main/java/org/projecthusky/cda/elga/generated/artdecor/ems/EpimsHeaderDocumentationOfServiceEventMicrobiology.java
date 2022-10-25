/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ems;

import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040DocumentationOf;

/**
 * epims_header_documentationOfServiceEventMicrobiology
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.1.43<br>
 * Effective date: 2020-04-22 13:03:07<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class EpimsHeaderDocumentationOfServiceEventMicrobiology extends POCDMT000040DocumentationOf {

    public EpimsHeaderDocumentationOfServiceEventMicrobiology() {
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
    private static org.projecthusky.common.hl7cdar2.POCDMT000040ServiceEvent createHl7ServiceEventFixedValue(String classCode, String moodCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040ServiceEvent retVal = factory.createPOCDMT000040ServiceEvent();
        retVal.getClassCode().add(classCode);
        retVal.getMoodCode().add(moodCode);
        return retVal;
    }

    /**
     * Gets the hl7ServiceEvent
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040ServiceEvent getHl7ServiceEvent() {
        return serviceEvent;
    }

    /**
     * Sets the hl7ServiceEvent
     */
    public void setHl7ServiceEvent(org.projecthusky.common.hl7cdar2.POCDMT000040ServiceEvent value) {
        this.serviceEvent = value;
    }
}
