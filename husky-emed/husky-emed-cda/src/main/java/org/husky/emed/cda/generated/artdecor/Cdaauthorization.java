package org.husky.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Authorization;
import org.husky.common.hl7cdar2.POCDMT000040Consent;

/**
 * CDAauthorization
 * <p>
 * Template description: Template CDA Authorization (prototype, directly derived from POCD_RM000040 MIF)<br>
 * <p>
 * Identifier: 2.16.840.1.113883.10.12.114<br>
 * Effective date: 2005-09-07 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
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
    private static POCDMT000040Consent createHl7ConsentFixedValue(String classCode, String moodCode) {
        ObjectFactory factory = new ObjectFactory();
        POCDMT000040Consent retVal = factory.createPOCDMT000040Consent();
        retVal.getClassCode().add(classCode);
        retVal.getMoodCode().add(moodCode);
        return retVal;
    }

    /**
     * Gets the hl7Consent
     */
    public POCDMT000040Consent getHl7Consent() {
        return consent;
    }

    /**
     * Sets the hl7Consent
     */
    public void setHl7Consent(POCDMT000040Consent value) {
        this.consent = value;
    }
}
