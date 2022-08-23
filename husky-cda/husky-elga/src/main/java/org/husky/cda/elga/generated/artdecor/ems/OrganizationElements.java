/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.ems;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.POCDMT000040Organization;
import org.husky.common.hl7cdar2.TEL;

/**
 * OrganizationElements
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.90002<br>
 * Effective date: 2011-12-19 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class OrganizationElements extends POCDMT000040Organization {

    public OrganizationElements() {
    }

    /**
     * Adds a hl7Id
     */
    public void addHl7Id(org.husky.common.hl7cdar2.II value) {
		id.add(value);
    }

    /**
     * Adds a hl7Telecom
     */
	public void addHl7Telecom(TEL value) {
		telecom.add(value);
    }

    /**
     * Gets the hl7Addr
     */
    public org.husky.common.hl7cdar2.AD getHl7Addr() {
		if (this.addr != null && !this.addr.isEmpty()) {
			return this.addr.get(0);
		}
		return null;
    }

    /**
     * Gets the hl7Name
     */
    public org.husky.common.hl7cdar2.ON getHl7Name() {
		if (this.name != null && !this.name.isEmpty()) {
			return this.name.get(0);
		}
		return null;
    }

    /**
     * Sets the hl7Addr
     */
    public void setHl7Addr(org.husky.common.hl7cdar2.AD value) {
		this.addr.clear();
		this.addr.add(value);
    }

    /**
     * Sets the hl7Name
     */
    public void setHl7Name(org.husky.common.hl7cdar2.ON value) {
		this.name.clear();
		this.name.add(value);
    }
}
