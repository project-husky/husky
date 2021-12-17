/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.POCDMT000040Organization;

/**
 * cdach_other_OrganizationCompilationWithNameAddrTelecom
 * <p>
 * Template description: Reusable template wherever an organization with required name, address and communication means is used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.<br>
 * Element description: The organization's address.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.27<br>
 * Effective date: 2018-04-18 00:00:00<br>
 * Version: 2017<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class CdachOtherOrganizationCompilationWithNameAddrTelecom extends POCDMT000040Organization {

    public CdachOtherOrganizationCompilationWithNameAddrTelecom() {
    }

    /**
     * Adds a hl7Addr/The organization's address.
     */
    public void addHl7Addr(org.husky.common.hl7cdar2.AD value) {
        getAddr().add(value);
    }

    /**
     * Adds a hl7Id/The organization's id.
     */
    public void addHl7Id(org.husky.common.hl7cdar2.II value) {
        getId().add(value);
    }

    /**
     * Adds a hl7Name/The organization's name.
     */
    public void addHl7Name(org.husky.common.hl7cdar2.ON value) {
        getName().add(value);
    }

    /**
     * Adds a hl7Telecom/The organization's means of communication (phone, eMail, ...).
     */
    public void addHl7Telecom(org.husky.common.hl7cdar2.TEL value) {
        getTelecom().add(value);
    }

    /**
     * Adds a hl7Addr/The organization's address.
     */
    public void clearHl7Addr() {
        getAddr().clear();
    }

    /**
     * Adds a hl7Id/The organization's id.
     */
    public void clearHl7Id() {
        getId().clear();
    }

    /**
     * Adds a hl7Name/The organization's name.
     */
    public void clearHl7Name() {
        getName().clear();
    }

    /**
     * Adds a hl7Telecom/The organization's means of communication (phone, eMail, ...).
     */
    public void clearHl7Telecom() {
        getTelecom().clear();
    }
}
