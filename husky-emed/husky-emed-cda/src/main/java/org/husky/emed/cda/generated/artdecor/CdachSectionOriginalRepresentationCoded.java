package org.husky.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.*;

/**
 * cdach_section_OriginalRepresentationCoded
 * <p>
 * Template description: This section MAY be used to provide the original representation of the current CDA document as it has been seen by the legal authenticator while signing.Notes:
 * - This template doesn't require PDF/A but keep in mind that only PDF/A contains all necessary information that allows to identically display the PDF on different machines.
 * - To ensure that digital data remains legible in the long term, PDF/A (but not PDF) is mentioned in the allowed list of archival formats for the Swiss Federal Archives.
 * - The certification requirements according to the Swiss EPR (EPRA) require PDF/A-1 oder PDF/A-2.
 * - Following the recommendations of CDA-CH V2 (2017), embedding the original representation in PDF/A-1a format is therefore strongly recommended.<br>
 * Element description: Contains the original representation of the current CDA document as it has been seen by the legal authenticator while signing.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.3.45<br>
 * Effective date: 2020-07-14 12:28:51<br>
 * Version: 2017<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class CdachSectionOriginalRepresentationCoded extends POCDMT000040Section {

    public CdachSectionOriginalRepresentationCoded() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.3.45"));
        super.setCode(createHl7CodeFixedValue("55108-5",
                                              "2.16.840.1.113883.6.1",
                                              "LOINC",
                                              "Clinical presentation"));
        super.getEntry().add(createHl7EntryFixedValue("DRIV"));
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     */
    private static CE createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        CE retVal = factory.createCE();
        retVal.setCode(code);
        retVal.setCodeSystem(codeSystem);
        retVal.setCodeSystemName(codeSystemName);
        retVal.setDisplayName(displayName);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Entry
     *
     * @param typeCode the desired fixed value for this argument.
     */
    private static POCDMT000040Entry createHl7EntryFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        POCDMT000040Entry retVal = factory.createPOCDMT000040Entry();
        retVal.setTypeCode(XActRelationshipEntry.fromValue(typeCode));
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Code
     */
    public CE getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7Entry
     */
    public List<POCDMT000040Entry> getHl7Entry() {
        return entry;
    }

    /**
     * Gets the hl7Id
     * An ID for this section MAY be filled for traceability.
     */
    public II getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     * MUST contain the reference (renderMultiMedia/@referencedObject) to the corrsponding observationMedia (embedded PDF) that shows the original representation signed by the legal authenticator.
     */
    public StrucDocText getHl7Text() {
        return text;
    }

    /**
     * Gets the hl7Title
     * Fixed human readable title of this section.
     * - [de]: 'Original Darstellung'
     * - [fr]: 'Représentation originale'
     * - [it]: 'Rappresentazione originale'
     * - [en]: 'Original representation'
     */
    public ST getHl7Title() {
        return title;
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7Entry
     */
    public void setHl7Entry(POCDMT000040Entry value) {
        getEntry().clear();
        getEntry().add(value);
    }

    /**
     * Sets the hl7Id
     * An ID for this section MAY be filled for traceability.
     */
    public void setHl7Id(II value) {
        this.id = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     * MUST contain the reference (renderMultiMedia/@referencedObject) to the corrsponding observationMedia (embedded PDF) that shows the original representation signed by the legal authenticator.
     */
    public void setHl7Text(StrucDocText value) {
        this.text = value;
    }

    /**
     * Sets the hl7Title
     * Fixed human readable title of this section.
     * - [de]: 'Original Darstellung'
     * - [fr]: 'Représentation originale'
     * - [it]: 'Rappresentazione originale'
     * - [en]: 'Original representation'
     */
    public void setHl7Title(ST value) {
        this.title = value;
    }
}
