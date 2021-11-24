/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.husky.emed.cda.generated.artdecor;

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
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-11-24")
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
