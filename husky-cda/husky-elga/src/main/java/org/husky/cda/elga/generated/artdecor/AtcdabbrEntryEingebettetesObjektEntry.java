/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor;

import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040ObservationMedia;

/**
 * atcdabbr_entry_EingebettetesObjektEntry
 * Identifier: 1.2.40.0.34.6.0.11.3.19<br>
 * Effective date: 2021-06-28 11:13:27<br>
 * Version: 1.0.1+20210628<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrEntryEingebettetesObjektEntry extends POCDMT000040ObservationMedia {

    public AtcdabbrEntryEingebettetesObjektEntry() {
        super.getClassCode().add("OBS");
        super.getMoodCode().add("EVN");
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.19"));
        super.setValue(createHl7ValueFixedValue("B64"));
    }

    /**
     * Adds a hl7Author
     */
    public void addHl7Author(org.husky.common.hl7cdar2.POCDMT000040Author value) {
        getAuthor().add(value);
    }

    /**
     * Adds a hl7Informant
     */
    public void addHl7Informant(org.husky.common.hl7cdar2.POCDMT000040Informant12 value) {
        getInformant().add(value);
    }

    /**
     * Adds a hl7Participant
     */
    public void addHl7Participant(org.husky.common.hl7cdar2.POCDMT000040Participant2 value) {
        getParticipant().add(value);
    }

    /**
     * Adds a hl7Performer
     */
    public void addHl7Performer(org.husky.common.hl7cdar2.POCDMT000040Performer2 value) {
        getPerformer().add(value);
    }

    /**
     * Adds a hl7Author
     */
    public void clearHl7Author() {
        getAuthor().clear();
    }

    /**
     * Adds a hl7Informant
     */
    public void clearHl7Informant() {
        getInformant().clear();
    }

    /**
     * Adds a hl7Participant
     */
    public void clearHl7Participant() {
        getParticipant().clear();
    }

    /**
     * Adds a hl7Performer
     */
    public void clearHl7Performer() {
        getPerformer().clear();
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
     * Creates fixed contents for CDA Element hl7Value
     *
     * @param representation the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.ED createHl7ValueFixedValue(String representation) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.ED retVal = factory.createED();
        return retVal;
        // TODO: Contents shall be taken from enum: org.husky.cda.elga.generated.artdecor.enums.ElgaMedientyp
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Value
     */
    public org.husky.common.hl7cdar2.ED getHl7Value() {
        return value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Value
     */
    public void setHl7Value(org.husky.common.hl7cdar2.ED value) {
        this.value = value;
    }
}
