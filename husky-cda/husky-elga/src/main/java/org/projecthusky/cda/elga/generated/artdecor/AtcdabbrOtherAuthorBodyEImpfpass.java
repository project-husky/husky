/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor;

import java.util.ArrayList;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.POCDMT000040AssignedAuthor;
import org.projecthusky.common.hl7cdar2.POCDMT000040Author;

/**
 * atcdabbr_other_AuthorBody_eImpfpass
 * 
 * Identifier: 1.2.40.0.34.6.0.11.9.8<br>
 * Effective date: 2021-02-19 13:12:25<br>
 * Version: 1.0.0+20210219<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrOtherAuthorBodyEImpfpass extends POCDMT000040Author {

    public AtcdabbrOtherAuthorBodyEImpfpass() {
		super.getTypeCode().add("AUT");
		super.setContextControlCode("OP");
		super.setTime(getPredefinedTimeUnk());
        super.setAssignedAuthor(createHl7AssignedAuthorFixedValue("ASSIGNED"));
    }

    /**
     * Creates fixed contents for CDA Element hl7AssignedAuthor
     *
     * @param classCode the desired fixed value for this argument.
     */
	private static org.projecthusky.common.hl7cdar2.POCDMT000040AssignedAuthor createHl7AssignedAuthorFixedValue(
			String classCode) {
		POCDMT000040AssignedAuthor retVal = new POCDMT000040AssignedAuthor();
		retVal.setClassCode(classCode);
		return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Time
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.TS createHl7TimeFixedValue(String nullFlavor) {
        org.projecthusky.common.hl7cdar2.TS retVal = new org.projecthusky.common.hl7cdar2.TS();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Gets the hl7AssignedAuthor
     */
	public org.projecthusky.common.hl7cdar2.POCDMT000040AssignedAuthor getHl7AssignedAuthor() {
		return this.assignedAuthor;
    }

    /**
     * Gets the hl7Time
     */
    public org.projecthusky.common.hl7cdar2.TS getHl7TimeTs() {
		return this.time;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.TS, filled by: "UNK"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.TS getPredefinedTimeUnk() {
        return createHl7TimeFixedValue("UNK");
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
