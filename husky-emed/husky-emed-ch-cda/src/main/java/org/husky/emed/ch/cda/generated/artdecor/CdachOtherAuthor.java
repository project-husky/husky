/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Author;

/**
 * cdach_other_Author
 * <p>
 * Template description: Information about the author of a CDA document, section or entry. An author MAY be a person or a device. All CDA-CH V2 derivatives, i.e. Swiss exchange formats MUST use this template at least in the CDA Header by either reference or specialisation.<br>
 * Element description: Information about the author of a CDA document, section or entry. An author MAY be a person or a device.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.23<br>
 * Effective date: 2019-09-12 13:48:28<br>
 * Version: 2020<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class CdachOtherAuthor extends POCDMT000040Author {

    public CdachOtherAuthor() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.9.23"));
    }

    /**
     * Creates fixed contents for CDA Element hl7FunctionCode
     */
    private static org.husky.common.hl7cdar2.CE createHl7FunctionCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7AssignedAuthor
     */
    public org.husky.common.hl7cdar2.POCDMT000040AssignedAuthor getHl7AssignedAuthor() {
        return assignedAuthor;
    }

    /**
     * Gets the hl7FunctionCode
     */
    public org.husky.common.hl7cdar2.CE getHl7FunctionCode() {
        return functionCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Time<br/>
     * Timestamp of the authorship.
     */
    public org.husky.common.hl7cdar2.TS getHl7Time() {
        return time;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.CE getPredefinedFunctionCode() {
        return createHl7FunctionCodeFixedValue();
    }

    /**
     * Sets the hl7AssignedAuthor
     */
    public void setHl7AssignedAuthor(org.husky.common.hl7cdar2.POCDMT000040AssignedAuthor value) {
        this.assignedAuthor = value;
    }

    /**
     * Sets the hl7FunctionCode
     */
    public void setHl7FunctionCode(org.husky.common.hl7cdar2.CE value) {
        this.functionCode = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Time<br/>
     * Timestamp of the authorship.
     */
    public void setHl7Time(org.husky.common.hl7cdar2.TS value) {
        this.time = value;
    }
}
