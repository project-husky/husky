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
import org.husky.common.hl7cdar2.POCDMT000040ObservationMedia;

/**
 * cdach_entry_ObservationMedia
 * <p>
 * Template description: Multimedia objects (e.g., PDF representations of the CDA document, pictures, Reiber diagrams, electrophoresis, etc.) MAY be integrated into a CDA document, either by reference to external multimedia objects or by means of XML embedding.This template defines only the embedding of multimedia objects in the CDA document. References to external documents can be created with the ExternalDocument template.For embedding in XML, the multimedia objects Base-64 must be encoded.Due to the amount of data, only light objects should be embedded.Heavy objects should be integrated using links to external documents.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.4.83<br>
 * Effective date: 2018-04-18 00:00:00<br>
 * Version: 2017<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-12-09")
public class CdachEntryObservationMedia extends POCDMT000040ObservationMedia {

    public CdachEntryObservationMedia() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.83"));
        super.setLanguageCode(createHl7LanguageCodeFixedValue());
        super.setValue(createHl7ValueFixedValue("B64"));
    }

    /**
     * Adds a hl7Id<br/>
     * IDs for this item MAY be filled for traceability.
     */
    public void addHl7Id(org.husky.common.hl7cdar2.II value) {
        getId().add(value);
    }

    /**
     * Adds a hl7Id<br/>
     * IDs for this item MAY be filled for traceability.
     */
    public void clearHl7Id() {
        getId().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7LanguageCode
     */
    private static org.husky.common.hl7cdar2.CS createHl7LanguageCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CS retVal = factory.createCS();
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
     * Creates fixed contents for CDA Element hl7Value
     *
     * @param representation the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.ED createHl7ValueFixedValue(String representation) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.ED retVal = factory.createED();
        return retVal;
        // TODO: Contents shall be taken from enum: org.husky.common.hl7cdar2.VideoMediaType
    }

    /**
     * Gets the hl7LanguageCode<br/>
     * The RFC 1766 (ISO-639-1 and ISO 3166) based language in which the multimedia object is written. If it isn't known or not available (e.g. for pictures), use nullFlavor instead.
     */
    public org.husky.common.hl7cdar2.CS getHl7LanguageCode() {
        return languageCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Value<br/>
     * This template defines only the embedding of multimedia objects in the CDA document.
     */
    public org.husky.common.hl7cdar2.ED getHl7Value() {
        return value;
    }

    /**
     * Sets the hl7LanguageCode<br/>
     * The RFC 1766 (ISO-639-1 and ISO 3166) based language in which the multimedia object is written. If it isn't known or not available (e.g. for pictures), use nullFlavor instead.
     */
    public void setHl7LanguageCode(org.husky.common.hl7cdar2.CS value) {
        this.languageCode = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Value<br/>
     * This template defines only the embedding of multimedia objects in the CDA document.
     */
    public void setHl7Value(org.husky.common.hl7cdar2.ED value) {
        this.value = value;
    }
}
