package org.husky.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;

import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040AssignedEntity;

/**
 * cdach_other_AssignedEntityCompilationIdNameAddrTelecomPersonOrganization
 * <p>
 * Template description: Reusable template wherever an assigned entity with required id, name, addr, telecom, person and organization are used in a CDA-CH V2 document. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.<br>
 * Element description: The assigned organization.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.32<br>
 * Effective date: 2019-10-24 16:38:14<br>
 * Version: 2020<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class CdachOtherAssignedEntityCompilationIdNameAddrTelecomPersonOrganization extends POCDMT000040AssignedEntity {

    public CdachOtherAssignedEntityCompilationIdNameAddrTelecomPersonOrganization() {
    }

    /**
     * Adds a hl7Addr
     * The assigned entity's address.
     */
    public void addHl7Addr(org.husky.emed.cda.generated.hl7cdar2.AD value) {
        getAddr().add(value);
    }

    /**
     * Adds a hl7Id
     * The assigned entity's id (including the assigned person's id).
     */
    public void addHl7Id(org.husky.emed.cda.generated.hl7cdar2.II value) {
        getId().add(value);
    }

    /**
     * Adds a hl7Telecom
     * The assigned entity's means of communication (phone, eMail, ...).
     */
    public void addHl7Telecom(org.husky.emed.cda.generated.hl7cdar2.TEL value) {
        getTelecom().add(value);
    }

    /**
     * Adds a hl7Addr
     * The assigned entity's address.
     */
    public void clearHl7Addr() {
        getAddr().clear();
    }

    /**
     * Adds a hl7Id
     * The assigned entity's id (including the assigned person's id).
     */
    public void clearHl7Id() {
        getId().clear();
    }

    /**
     * Adds a hl7Telecom
     * The assigned entity's means of communication (phone, eMail, ...).
     */
    public void clearHl7Telecom() {
        getTelecom().clear();
    }

    /**
     * Gets the hl7AssignedPerson
     * The assigned person.
     */
    public org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Person getHl7AssignedPerson() {
        return assignedPerson;
    }

    /**
     * Gets the hl7Code
     * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
     */
    public org.husky.emed.cda.generated.hl7cdar2.CE getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7RepresentedOrganization
     * The assigned organization.
     */
    public org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Organization getHl7RepresentedOrganization() {
        return representedOrganization;
    }

    /**
     * Sets the hl7AssignedPerson
     * The assigned person.
     */
    public void setHl7AssignedPerson(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Person value) {
        this.assignedPerson = value;
    }

    /**
     * Sets the hl7Code
     * The human-readable text MUST be generated automatically from the structured information of this element. The text element MUST contain the reference to the corresponding text in the human readable part, ONLY.
     */
    public void setHl7Code(org.husky.emed.cda.generated.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7RepresentedOrganization
     * The assigned organization.
     */
    public void setHl7RepresentedOrganization(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Organization value) {
        this.representedOrganization = value;
    }
}
