package org.husky.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;

import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Place;

/**
 * CDAPlace
 * <p>
 * Template description: Template CDA Place (prototype, directly derived from POCD_RM000040 MIF)<br>
 * <p>
 * Identifier: 2.16.840.1.113883.10.12.317<br>
 * Effective date: 2005-09-07 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class Cdaplace extends POCDMT000040Place {

    public Cdaplace() {
    }

    /**
     * Gets the hl7Addr
     */
    public org.husky.emed.cda.generated.hl7cdar2.AD getHl7Addr() {
        return addr;
    }

    /**
     * Gets the hl7Name
     */
    public org.husky.emed.cda.generated.hl7cdar2.EN getHl7Name() {
        return name;
    }

    /**
     * Sets the hl7Addr
     */
    public void setHl7Addr(org.husky.emed.cda.generated.hl7cdar2.AD value) {
        this.addr = value;
    }

    /**
     * Sets the hl7Name
     */
    public void setHl7Name(org.husky.emed.cda.generated.hl7cdar2.EN value) {
        this.name = value;
    }
}
