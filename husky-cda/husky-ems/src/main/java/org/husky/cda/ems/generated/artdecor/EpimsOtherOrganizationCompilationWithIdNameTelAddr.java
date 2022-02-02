/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.ems.generated.artdecor;

import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Organization;
import org.husky.common.hl7cdar2.TEL;

/**
 * epims_other_organizationCompilationWithIdNameTelAddr
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.39<br>
 * Effective date: 2020-02-20 09:48:27<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class EpimsOtherOrganizationCompilationWithIdNameTelAddr extends POCDMT000040Organization {

    public EpimsOtherOrganizationCompilationWithIdNameTelAddr() {
        super.getId().add(createHl7IdFixedValue("1.2.40.0.34.3.1.1"));
        super.getTelecom().add(createHl7TelecomFixedValue("tel:+43.1.71100-0"));
    }

    /**
     * Creates fixed contents for CDA Element hl7Id
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.II createHl7IdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Telecom
     *
     * @param value the desired fixed value for this argument.
     */
	private static TEL createHl7TelecomFixedValue(String value) {
        ObjectFactory factory = new ObjectFactory();
		TEL retVal = factory.createTEL();
		retVal.setValue(value);
        return retVal;
    }

    /**
     * Gets the hl7Addr
     */
    public List<org.husky.common.hl7cdar2.AD> getHl7Addr() {
        return addr;
    }

    /**
     * Gets the hl7Id
     */
    public List<org.husky.common.hl7cdar2.II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7Name
     */
    public List<org.husky.common.hl7cdar2.ON> getHl7Name() {
        return name;
    }

    /**
     * Gets the hl7Telecom
     */
	public List<TEL> getHl7Telecom() {
        return telecom;
    }

    /**
     * Sets the hl7Addr
     */
    public void setHl7Addr(org.husky.common.hl7cdar2.AD value) {
        getAddr().clear();
        getAddr().add(value);
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.husky.common.hl7cdar2.II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7Name
     */
    public void setHl7Name(org.husky.common.hl7cdar2.ON value) {
        getName().clear();
        getName().add(value);
    }

    /**
     * Sets the hl7Telecom
     */
	public void setHl7Telecom(TEL value) {
        getTelecom().clear();
        getTelecom().add(value);
    }
}
