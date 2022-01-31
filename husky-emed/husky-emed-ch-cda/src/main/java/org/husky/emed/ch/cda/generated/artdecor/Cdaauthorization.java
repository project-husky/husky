/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.generated.artdecor;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Authorization;

/**
 * CDAauthorization
 * <p>
 * Template description: Template CDA Authorization (prototype, directly derived from POCD_RM000040 MIF)<br>
 * <p>
 * Identifier: 2.16.840.1.113883.10.12.114<br>
 * Effective date: 2005-09-07 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class Cdaauthorization extends POCDMT000040Authorization {

    public Cdaauthorization() {
        super.getTypeCode().add("AUTH");
        super.setConsent(createHl7ConsentFixedValue("CONS",
                                                    "EVN"));
    }

    /**
     * Creates fixed contents for CDA Element hl7Consent
     *
     * @param classCode the desired fixed value for this argument.
     * @param moodCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Consent createHl7ConsentFixedValue(String classCode, String moodCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040Consent retVal = factory.createPOCDMT000040Consent();
        retVal.getClassCode().add(classCode);
        retVal.getMoodCode().add(moodCode);
        return retVal;
    }

    /**
     * Gets the hl7Consent
     */
    public org.husky.common.hl7cdar2.POCDMT000040Consent getHl7Consent() {
        return consent;
    }

    /**
     * Sets the hl7Consent
     */
    public void setHl7Consent(org.husky.common.hl7cdar2.POCDMT000040Consent value) {
        this.consent = value;
    }
}
