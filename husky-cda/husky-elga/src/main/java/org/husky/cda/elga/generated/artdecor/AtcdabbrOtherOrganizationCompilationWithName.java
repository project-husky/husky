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

import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.POCDMT000040Organization;
import org.husky.common.hl7cdar2.TEL;

/**
 * atcdabbr_other_OrganizationCompilationWithName
 * <p>
 * Template description: Wiederverwendbare Compilation mit verpflichtender Angabe des name-Elements.<br/>Adressangabe und Kontaktdaten optional.<br>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.9<br>
 * Effective date: 2021-02-19 13:31:25<br>
 * Version: 1.0.0+20210219<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrOtherOrganizationCompilationWithName extends POCDMT000040Organization {

    public AtcdabbrOtherOrganizationCompilationWithName() {
		super.setClassCode("ORG");
		super.setDeterminerCode("INSTANCE");
    }

    /**
     * Adds a hl7Id
     */
    public void addHl7Id(org.husky.common.hl7cdar2.II value) {
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
    public List<org.husky.common.hl7cdar2.AD> getHl7Addr() {
        return addr;
    }

    /**
     * Gets the hl7Name
     */
    public List<org.husky.common.hl7cdar2.ON> getHl7Name() {
        return name;
    }

    /**
     * Sets the hl7Addr
     */
    public void setHl7Addr(org.husky.common.hl7cdar2.AD value) {
        getAddr().clear();
        getAddr().add(value);
    }

    /**
     * Sets the hl7Name
     */
    public void setHl7Name(org.husky.common.hl7cdar2.ON value) {
        getName().clear();
        getName().add(value);
    }
}
