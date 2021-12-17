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
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Organization;

/**
 * CDAOrganization
 * <p>
 * Template description: Template CDA Organization (prototype, directly derived from POCD_RM000040 MIF)<br>
 * <p>
 * Identifier: 2.16.840.1.113883.10.12.151<br>
 * Effective date: 2005-09-07 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class Cdaorganization extends POCDMT000040Organization {

    public Cdaorganization() {
    }

    /**
     * Adds a hl7Addr
     */
    public void addHl7Addr(org.husky.common.hl7cdar2.AD value) {
        getAddr().add(value);
    }

    /**
     * Adds a hl7Id
     */
    public void addHl7Id(org.husky.common.hl7cdar2.II value) {
        getId().add(value);
    }

    /**
     * Adds a hl7Name
     */
    public void addHl7Name(org.husky.common.hl7cdar2.ON value) {
        getName().add(value);
    }

    /**
     * Adds a hl7Telecom
     */
    public void addHl7Telecom(org.husky.common.hl7cdar2.TEL value) {
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
     * Adds a hl7Name
     */
    public void clearHl7Name() {
        getName().clear();
    }

    /**
     * Adds a hl7Telecom
     */
    public void clearHl7Telecom() {
        getTelecom().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7AsOrganizationPartOf
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040OrganizationPartOf createHl7AsOrganizationPartOfFixedValue(String classCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040OrganizationPartOf retVal = factory.createPOCDMT000040OrganizationPartOf();
        retVal.getClassCode().add(classCode);
        return retVal;
    }

    /**
     * Gets the hl7AsOrganizationPartOf
     */
    public org.husky.common.hl7cdar2.POCDMT000040OrganizationPartOf getHl7AsOrganizationPartOf() {
        return asOrganizationPartOf;
    }

    /**
     * Gets the hl7StandardIndustryClassCode/SHALL be chosen from domain OrganizationIndustryClass
     */
    public org.husky.common.hl7cdar2.CE getHl7StandardIndustryClassCode() {
        return standardIndustryClassCode;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040OrganizationPartOf, filled by: "PART"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040OrganizationPartOf getPredefinedAsOrganizationPartOfPart() {
        return createHl7AsOrganizationPartOfFixedValue("PART");
    }

    /**
     * Sets the hl7AsOrganizationPartOf
     */
    public void setHl7AsOrganizationPartOf(org.husky.common.hl7cdar2.POCDMT000040OrganizationPartOf value) {
        this.asOrganizationPartOf = value;
    }

    /**
     * Sets the hl7StandardIndustryClassCode<br/>
     * SHALL be chosen from domain OrganizationIndustryClass
     */
    public void setHl7StandardIndustryClassCode(org.husky.common.hl7cdar2.CE value) {
        this.standardIndustryClassCode = value;
    }
}
