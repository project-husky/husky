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
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-07-11")
public class CdarelatedEntity extends POCDMT000040RelatedEntity {

    public CdarelatedEntity() {
    }

    /**
     * Adds a hl7Addr
     */
    public void addHl7Addr(org.husky.common.hl7cdar2.AD value) {
        getAddr().add(value);
    }

    /**
     * Adds a hl7Telecom
     */
    public void addHl7Telecom(org.husky.common.hl7cdar2.TEL value) {
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
    private static org.husky.common.hl7cdar2.CE createHl7CodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Gets the hl7Code
     */
    public org.husky.common.hl7cdar2.CE getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public org.husky.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7RelatedPerson
     */
    public org.husky.common.hl7cdar2.POCDMT000040Person getHl7RelatedPerson() {
        return relatedPerson;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.CE getPredefinedCode() {
        return createHl7CodeFixedValue();
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.husky.common.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.husky.common.hl7cdar2.IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7RelatedPerson
     */
    public void setHl7RelatedPerson(org.husky.common.hl7cdar2.POCDMT000040Person value) {
        this.relatedPerson = value;
    }
}
