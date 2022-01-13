/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */

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
import org.husky.common.hl7cdar2.POCDMT000040Place;

/**
 * CDAPlace
 * <p>
 * Template description: Template CDA Place (prototype, directly derived from POCD_RM000040 MIF)<br>
 * <p>
 * Identifier: 2.16.840.1.113883.10.12.317<br>
 * Effective date: 2005-09-07 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class Cdaplace extends POCDMT000040Place {

    public Cdaplace() {
    }

    /**
     * Gets the hl7Addr
     */
    public org.husky.common.hl7cdar2.AD getHl7Addr() {
        return addr;
    }

    /**
     * Gets the hl7Name
     */
    public org.husky.common.hl7cdar2.EN getHl7Name() {
        return name;
    }

    /**
     * Sets the hl7Addr
     */
    public void setHl7Addr(org.husky.common.hl7cdar2.AD value) {
        this.addr = value;
    }

    /**
     * Sets the hl7Name
     */
    public void setHl7Name(org.husky.common.hl7cdar2.EN value) {
        this.name = value;
    }
}
