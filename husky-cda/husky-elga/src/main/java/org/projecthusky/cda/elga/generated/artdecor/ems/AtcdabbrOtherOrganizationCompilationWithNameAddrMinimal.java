/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ems;

import java.util.List;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.POCDMT000040Organization;
import org.projecthusky.common.hl7cdar2.TEL;

/**
 * atcdabbr_other_OrganizationCompilationWithNameAddrMinimal
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.20<br>
 * Effective date: 2021-06-28 13:58:02<br>
 * Version: 1.0.1+20210628<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class AtcdabbrOtherOrganizationCompilationWithNameAddrMinimal extends POCDMT000040Organization {

    public AtcdabbrOtherOrganizationCompilationWithNameAddrMinimal() {
    }

    /**
     * Adds a hl7Id
     */
    public void addHl7Id(org.projecthusky.common.hl7cdar2.II value) {
		getId().add(value);
    }

    /**
     * Adds a hl7Telecom
     */
	public void addHl7Telecom(TEL value) {
		getTelecom().add(value);
	}

	/**
	 * Adds a hl7Id
	 */
	public void clearHl7Id() {
		getId().clear();
	}

	/**
	 * Adds a hl7Telecom
	 */
	public void clearHl7Telecom() {
		getTelecom().clear();
    }

    /**
     * Gets the hl7Addr
     */
	public List<org.projecthusky.common.hl7cdar2.AD> getHl7Addr() {
		return addr;
    }

    /**
     * Gets the hl7Name
     */
	public List<org.projecthusky.common.hl7cdar2.ON> getHl7Name() {
		return name;
    }

    /**
     * Sets the hl7Addr
     */
    public void setHl7Addr(org.projecthusky.common.hl7cdar2.AD value) {
		getAddr().clear();
		getAddr().add(value);
    }

    /**
     * Sets the hl7Name
     */
    public void setHl7Name(org.projecthusky.common.hl7cdar2.ON value) {
		getName().clear();
		getName().add(value);
    }

}
