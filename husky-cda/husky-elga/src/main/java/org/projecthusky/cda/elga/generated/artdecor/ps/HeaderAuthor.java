/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ps;

import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Author;

/**
 * HeaderAuthor
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.20002<br>
 * Effective date: 2015-05-09 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class HeaderAuthor extends POCDMT000040Author {

    public HeaderAuthor() {
        super.getTypeCode().add("AUT");
        super.setContextControlCode("OP");
        super.setAssignedAuthor(createHl7AssignedAuthorFixedValue("ASSIGNED"));
    }

    /**
     * Creates fixed contents for CDA Element hl7AssignedAuthor
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040AssignedAuthor createHl7AssignedAuthorFixedValue(String classCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040AssignedAuthor retVal = factory.createPOCDMT000040AssignedAuthor();
        retVal.setClassCode(classCode);
        return retVal;
    }

    /**
     * Gets the hl7AssignedAuthor
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040AssignedAuthor getHl7AssignedAuthor() {
        return assignedAuthor;
    }

    /**
     * Gets the hl7FunctionCode
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7FunctionCode() {
        return functionCode;
    }

    /**
     * Gets the hl7Time
     */
    public org.projecthusky.common.hl7cdar2.TS getHl7Time() {
        return time;
    }

    /**
     * Sets the hl7AssignedAuthor
     */
    public void setHl7AssignedAuthor(org.projecthusky.common.hl7cdar2.POCDMT000040AssignedAuthor value) {
        this.assignedAuthor = value;
    }

    /**
     * Sets the hl7FunctionCode
     */
    public void setHl7FunctionCode(org.projecthusky.common.hl7cdar2.CE value) {
        this.functionCode = value;
    }

    /**
     * Sets the hl7Time
     */
    public void setHl7Time(org.projecthusky.common.hl7cdar2.TS value) {
        this.time = value;
    }
}
