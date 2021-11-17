package org.husky.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.*;
import org.husky.common.hl7cdar2.POCDMT000040RelatedEntity;

/**
 * CDARelatedEntity
 * <p>
 * Template description: Template CDA RelatedEntity (prototype, directly derived from POCD_RM000040 MIF)<br>
 * <p>
 * Identifier: 2.16.840.1.113883.10.12.316<br>
 * Effective date: 2005-09-07 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class CdarelatedEntity extends POCDMT000040RelatedEntity {

    public CdarelatedEntity() {
    }

    /**
     * Adds a hl7Addr
     */
    public void addHl7Addr(AD value) {
        getAddr().add(value);
    }

    /**
     * Adds a hl7Telecom
     */
    public void addHl7Telecom(TEL value) {
        getTelecom().add(value);
    }

    /**
     * Adds a hl7Addr
     */
    public void clearHl7Addr() {
        getAddr().clear();
    }

    /**
     * Adds a hl7Telecom
     */
    public void clearHl7Telecom() {
        getTelecom().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     */
    private static CE createHl7CodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Gets the hl7Code
     */
    public CE getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public IVLTS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7RelatedPerson
     */
    public POCDMT000040Person getHl7RelatedPerson() {
        return relatedPerson;
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static CE getPredefinedCode() {
        return createHl7CodeFixedValue();
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7RelatedPerson
     */
    public void setHl7RelatedPerson(POCDMT000040Person value) {
        this.relatedPerson = value;
    }
}
