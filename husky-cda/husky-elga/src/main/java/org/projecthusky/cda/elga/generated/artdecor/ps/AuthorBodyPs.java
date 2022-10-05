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
 * AuthorBody_PS
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.13.3.16<br>
 * Effective date: 2017-08-05 19:04:45<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class AuthorBodyPs extends POCDMT000040Author {

    public AuthorBodyPs() {
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
     * Sets the hl7Time
     */
    public void setHl7Time(org.projecthusky.common.hl7cdar2.TS value) {
        this.time = value;
    }
}
