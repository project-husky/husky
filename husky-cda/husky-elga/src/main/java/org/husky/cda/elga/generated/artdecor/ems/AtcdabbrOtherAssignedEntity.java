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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040AssignedEntity;
import org.husky.common.hl7cdar2.TEL;

/**
 *  atcdabbr_other_AssignedEntity
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.22<br>
 * Effective date: 2021-05-26 13:50:41<br>
 * Version: 1.0.1+20210526<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class AtcdabbrOtherAssignedEntity extends POCDMT000040AssignedEntity {

    public AtcdabbrOtherAssignedEntity() {
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
     * Creates fixed contents for CDA Element hl7Addr
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.AD createHl7AddrFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.AD retVal = factory.createAD();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Id
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.II createHl7IdFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.II retVal = factory.createII();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Gets the hl7Addr
     */
    public List<org.husky.common.hl7cdar2.AD> getHl7Addr() {
        return addr;
    }

    /**
     * Gets the hl7AssignedPerson
     */
    public org.husky.common.hl7cdar2.POCDMT000040Person getHl7AssignedPerson() {
        return assignedPerson;
    }

    /**
     * Gets the hl7RepresentedOrganization
     */
    public org.husky.common.hl7cdar2.POCDMT000040Organization getHl7RepresentedOrganization() {
        return representedOrganization;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.AD, filled by: "UNK"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.AD getPredefinedAddrUnk() {
        return createHl7AddrFixedValue("UNK");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.II, filled by: "NI"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.II getPredefinedIdNi() {
        return createHl7IdFixedValue("NI");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.II, filled by: "UNK"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.II getPredefinedIdUnk() {
        return createHl7IdFixedValue("UNK");
    }

    /**
     * Sets the hl7Addr
     */
    public void setHl7Addr(org.husky.common.hl7cdar2.AD value) {
        getAddr().clear();
        getAddr().add(value);
    }

    /**
     * Sets the hl7AssignedPerson
     */
    public void setHl7AssignedPerson(org.husky.common.hl7cdar2.POCDMT000040Person value) {
        this.assignedPerson = value;
    }

    /**
     * Sets the hl7RepresentedOrganization
     */
    public void setHl7RepresentedOrganization(org.husky.common.hl7cdar2.POCDMT000040Organization value) {
        this.representedOrganization = value;
    }
}
