package org.husky.emed.cda.generated.artdecor;

import javax.annotation.processing.Generated;

import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040AssignedEntity;

/**
 * CDAAssignedEntity
 * <p>
 * Template description: Template CDA AssignedEntity (prototype, directly derived from POCD_RM000040 MIF)<br>
 * <p>
 * Identifier: 2.16.840.1.113883.10.12.153<br>
 * Effective date: 2005-09-07 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class CdaassignedEntity extends POCDMT000040AssignedEntity {

    public CdaassignedEntity() {
    }

    /**
     * Adds a hl7Addr
     */
    public void addHl7Addr(org.husky.emed.cda.generated.hl7cdar2.AD value) {
        getAddr().add(value);
    }

    /**
     * Adds a hl7Id
     */
    public void addHl7Id(org.husky.emed.cda.generated.hl7cdar2.II value) {
        getId().add(value);
    }

    /**
     * Adds a hl7Telecom
     */
    public void addHl7Telecom(org.husky.emed.cda.generated.hl7cdar2.TEL value) {
        getTelecom().add(value);
    }

    /**
     * Adds a hl7Addr
     */
    public void clearHl7Addr() {
        getAddr().clear();
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
     * Gets the hl7AssignedPerson
     */
    public org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Person getHl7AssignedPerson() {
        return assignedPerson;
    }

    /**
     * Gets the hl7Code
     */
    public org.husky.emed.cda.generated.hl7cdar2.CE getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7RepresentedOrganization
     */
    public org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Organization getHl7RepresentedOrganization() {
        return representedOrganization;
    }

    /**
     * Sets the hl7AssignedPerson
     */
    public void setHl7AssignedPerson(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Person value) {
        this.assignedPerson = value;
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.husky.emed.cda.generated.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7RepresentedOrganization
     */
    public void setHl7RepresentedOrganization(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Organization value) {
        this.representedOrganization = value;
    }
}
