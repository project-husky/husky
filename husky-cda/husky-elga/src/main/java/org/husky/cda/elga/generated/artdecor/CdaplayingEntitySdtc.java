/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040PlayingEntity;

/**
 * CDAPlayingEntitySDTC
 * <p>
 * Template description: Template CDA PlayingEntity (prototype, directly derived from POCD_RM000040 MIF) + SDTC extensions<br>
 * <p>
 * Identifier: 2.16.840.1.113883.10.12.813<br>
 * Effective date: 2005-09-07 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class CdaplayingEntitySdtc extends POCDMT000040PlayingEntity {

    public CdaplayingEntitySdtc() {
    }

    /**
     * Adds a hl7Name
     */
    public void addHl7Name(org.husky.common.hl7cdar2.PN value) {
        getName().add(value);
    }

    /**
     * Adds a hl7Quantity
     */
    public void addHl7Quantity(org.husky.common.hl7cdar2.PQ value) {
        getQuantity().add(value);
    }

    /**
     * Adds a hl7Name
     */
    public void clearHl7Name() {
        getName().clear();
    }

    /**
     * Adds a hl7Quantity
     */
    public void clearHl7Quantity() {
        getQuantity().clear();
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
     * Gets the hl7Desc
     */
    public org.husky.common.hl7cdar2.ED getHl7Desc() {
        return desc;
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
     * Sets the hl7Desc
     */
    public void setHl7Desc(org.husky.common.hl7cdar2.ED value) {
        this.desc = value;
    }

}
