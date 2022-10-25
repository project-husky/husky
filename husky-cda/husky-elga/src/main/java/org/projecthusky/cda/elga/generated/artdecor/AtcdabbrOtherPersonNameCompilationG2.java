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

import org.projecthusky.common.hl7cdar2.POCDMT000040Person;

/**
 * atcdabbr_other_PersonNameCompilationG2
 * <p>
 * Template description: <br/><br>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.6<br>
 * Effective date: 2021-02-19 13:36:49<br>
 * Version: 1.0.0+20210219<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrOtherPersonNameCompilationG2 extends POCDMT000040Person {

    public AtcdabbrOtherPersonNameCompilationG2() {
		super.getClassCode().add("PSN");
		super.setDeterminerCode("INSTANCE");
    }

    /**
     * Creates fixed contents for CDA Element hl7Name
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.PN createHl7NameFixedValue(String nullFlavor) {
        org.projecthusky.common.hl7cdar2.PN retVal = new org.projecthusky.common.hl7cdar2.PN();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Gets the hl7Name
     */
    public org.projecthusky.common.hl7cdar2.PN getHl7Name() {
		if (this.name != null && !this.name.isEmpty()) {
			return this.name.get(0);
		}
		return null;

    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.PN, filled by: "MSK"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.PN getPredefinedNameMsk() {
        return createHl7NameFixedValue("MSK");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.PN, filled by: "UNK"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.PN getPredefinedNameUnk() {
        return createHl7NameFixedValue("UNK");
    }

    /**
     * Sets the hl7Name
     */
    public void setHl7Name(org.projecthusky.common.hl7cdar2.PN value) {
		getName().clear();
		getName().add(value);
    }
}
