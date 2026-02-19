/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor;

import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component1;

/**
 * atcdabbr_header_ComponentOfEncompassingEncounterWithId
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.1.50<br>
 * Effective date: 2023-02-28 10:37:28<br>
 * Version: 1.0.1+20230717<br>
 * Status: active
 * <p>
 * Generated from the ArtDecor <a href="https://art-decor.org/art-decor/decor-templates--at-cda-bbr-?id=1.2.40.0.34.6.0.11.1.50&amp;effectiveTime=2023-02-28+10%3A37%3A28">atcdabbr_header_ComponentOfEncompassingEncounterWithId</a> page.
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2026-02-19")
public class AtcdabbrHeaderComponentOfEncompassingEncounterWithId extends POCDMT000040Component1 {

    public AtcdabbrHeaderComponentOfEncompassingEncounterWithId() {
        super.setTypeCode(org.projecthusky.common.hl7cdar2.ActRelationshipHasComponent.COMP);
        super.setEncompassingEncounter(createHl7EncompassingEncounterFixedValue("ENC",
                                                                                "EVN"));
    }

    /**
     * Creates fixed contents for CDA Element hl7EncompassingEncounter
     *
     * @param classCode the desired fixed value for this argument.
     * @param moodCode the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040EncompassingEncounter createHl7EncompassingEncounterFixedValue(String classCode, String moodCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040EncompassingEncounter retVal = factory.createPOCDMT000040EncompassingEncounter();
        retVal.getClassCode().add(classCode);
        retVal.getMoodCode().add(moodCode);
        return retVal;
    }

    /**
     * Gets the hl7EncompassingEncounter
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040EncompassingEncounter getHl7EncompassingEncounter() {
        return encompassingEncounter;
    }

    /**
     * Sets the hl7EncompassingEncounter
     */
    public void setHl7EncompassingEncounter(org.projecthusky.common.hl7cdar2.POCDMT000040EncompassingEncounter value) {
        this.encompassingEncounter = value;
    }
}
