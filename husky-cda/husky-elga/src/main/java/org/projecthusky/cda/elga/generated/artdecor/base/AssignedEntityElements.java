/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.base;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.POCDMT000040AssignedEntity;
import org.projecthusky.common.hl7cdar2.TEL;

/**
 * AssignedEntityElements
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.90003<br>
 * Effective date: 2011-12-19 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-21")
public class AssignedEntityElements extends POCDMT000040AssignedEntity {

    public AssignedEntityElements() {
    }

    /**
     * Adds a hl7Id
     */
    public void addHl7Id(org.projecthusky.common.hl7cdar2.II value) {
		this.id.add(value);
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
	public org.projecthusky.common.hl7cdar2.AD getHl7Addr() {
		if (this.addr != null && !this.addr.isEmpty()) {
			return this.addr.get(0);
		}
		return null;
    }

    /**
     * Gets the hl7AssignedPerson
     */
	public org.projecthusky.common.hl7cdar2.POCDMT000040Person getHl7AssignedPerson() {
		return this.getHl7AssignedPerson();
    }

    /**
     * Gets the hl7RepresentedOrganization
     */
	public org.projecthusky.common.hl7cdar2.POCDMT000040Organization getHl7RepresentedOrganization() {
		return this.representedOrganization;
    }

    /**
     * Sets the hl7Addr
     */
    public void setHl7Addr(org.projecthusky.common.hl7cdar2.AD value) {
		this.addr.clear();
		this.addr.add(value);
    }

    /**
     * Sets the hl7AssignedPerson
     */
	public void setHl7AssignedPerson(org.projecthusky.common.hl7cdar2.POCDMT000040Person value) {
		this.assignedPerson = value;
    }

    /**
     * Sets the hl7RepresentedOrganization
     */
	public void setHl7RepresentedOrganization(org.projecthusky.common.hl7cdar2.POCDMT000040Organization value) {
		this.representedOrganization = value;
    }
}
