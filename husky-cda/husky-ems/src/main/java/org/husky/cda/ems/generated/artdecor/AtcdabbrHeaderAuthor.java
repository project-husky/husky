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

import java.util.ArrayList;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Author;

/**
 * atcdabbr_header_Author
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.1.2<br>
 * Effective date: 2021-08-24 08:35:56<br>
 * Version: 1.0.2+20211213<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class AtcdabbrHeaderAuthor extends POCDMT000040Author {

    public AtcdabbrHeaderAuthor() {
        super.getTypeCode().add("AUT");
        super.setContextControlCode("OP");
        super.setAssignedAuthor(createHl7AssignedAuthorFixedValue("ASSIGNED"));
    }

    /**
     * Creates fixed contents for CDA Element hl7AssignedAuthor
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040AssignedAuthor createHl7AssignedAuthorFixedValue(String classCode) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040AssignedAuthor retVal = factory.createPOCDMT000040AssignedAuthor();
        retVal.setClassCode(classCode);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Time
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.TS createHl7TimeFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.TS retVal = factory.createTS();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
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
     * Gets the hl7Time
     */
    public org.husky.common.hl7cdar2.TS getHl7Time() {
        return time;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.TS, filled by: "UNK"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.TS getPredefinedTimeUnk() {
        return createHl7TimeFixedValue("UNK");
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
     * Sets the hl7Time
     */
    public void setHl7Time(org.husky.common.hl7cdar2.TS value) {
        this.time = value;
    }
}
