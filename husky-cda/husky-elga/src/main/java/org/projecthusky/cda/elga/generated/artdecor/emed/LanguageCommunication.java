/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.emed;

import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040LanguageCommunication;

/**
 * LanguageCommunication
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.90017<br>
 * Effective date: 2017-03-27 00:00:00<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-22")
public class LanguageCommunication extends POCDMT000040LanguageCommunication {

    public LanguageCommunication() {
    }

    /**
     * Creates fixed contents for CDA Element hl7LanguageCode
     */
    private static org.projecthusky.common.hl7cdar2.CS createHl7LanguageCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CS retVal = factory.createCS();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7ModeCode
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7ModeCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7ProficiencyLevelCode
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7ProficiencyLevelCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Gets the hl7LanguageCode
     */
    public org.projecthusky.common.hl7cdar2.CS getHl7LanguageCode() {
        return languageCode;
    }

    /**
     * Gets the hl7ModeCode
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7ModeCode() {
        return modeCode;
    }

    /**
     * Gets the hl7PreferenceInd
     */
    public org.projecthusky.common.hl7cdar2.BL getHl7PreferenceInd() {
        return preferenceInd;
    }

    /**
     * Gets the hl7ProficiencyLevelCode
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7ProficiencyLevelCode() {
        return proficiencyLevelCode;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.CS, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.CS getPredefinedLanguageCode() {
        return createHl7LanguageCodeFixedValue();
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.CE getPredefinedModeCode() {
        return createHl7ModeCodeFixedValue();
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.CE getPredefinedProficiencyLevelCode() {
        return createHl7ProficiencyLevelCodeFixedValue();
    }

    /**
     * Sets the hl7LanguageCode
     */
    public void setHl7LanguageCode(org.projecthusky.common.hl7cdar2.CS value) {
        this.languageCode = value;
    }

    /**
     * Sets the hl7ModeCode
     */
    public void setHl7ModeCode(org.projecthusky.common.hl7cdar2.CE value) {
        this.modeCode = value;
    }

    /**
     * Sets the hl7PreferenceInd
     */
    public void setHl7PreferenceInd(org.projecthusky.common.hl7cdar2.BL value) {
        this.preferenceInd = value;
    }

    /**
     * Sets the hl7ProficiencyLevelCode
     */
    public void setHl7ProficiencyLevelCode(org.projecthusky.common.hl7cdar2.CE value) {
        this.proficiencyLevelCode = value;
    }
}
