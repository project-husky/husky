package org.husky.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.emed.cda.generated.hl7cdar2.ObjectFactory;
import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Section;

/**
 * MedicationTreatmenPlanSectionContentModule
 * <p>
 * Template description: The Medication Treatment Plan Section contains a description of the patient. It includes entries for Medication Treatment Plan Items as described in the Medication Treatment Plan Item Entry Content Module.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.3.13<br>
 * Effective date: 2017-05-01 12:51:36<br>
 * Version: 2017<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class MedicationTreatmenPlanSectionContentModule extends POCDMT000040Section {

    public MedicationTreatmenPlanSectionContentModule() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.3.13"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.2.6"));
        super.setCode(createHl7CodeFixedValue("77604-7",
                                              "2.16.840.1.113883.6.1",
                                              "LOINC",
                                              "Medication treatment plan.brief"));
    }

    /**
     * Adds a hl7Author
     * Information about the author of a CDA document, section or entry. An author MAY be a person or a device.
     */
    public void addHl7Author(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Author value) {
        getAuthor().add(value);
    }

    /**
     * Adds a hl7Author
     * Information about the author of a CDA document, section or entry. An author MAY be a person or a device.
     */
    public void clearHl7Author() {
        getAuthor().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.husky.emed.cda.generated.hl7cdar2.CE createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.CE retVal = factory.createCE();
        retVal.setCode(code);
        retVal.setCodeSystem(codeSystem);
        retVal.setCodeSystemName(codeSystemName);
        retVal.setDisplayName(displayName);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.husky.emed.cda.generated.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.emed.cda.generated.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Code
     */
    public org.husky.emed.cda.generated.hl7cdar2.CE getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7Entry
     */
    public List<org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Entry> getHl7Entry() {
        return entry;
    }

    /**
     * Gets the hl7Id
     */
    public org.husky.emed.cda.generated.hl7cdar2.II getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.emed.cda.generated.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     */
    public org.husky.emed.cda.generated.hl7cdar2.StrucDocText getHl7Text() {
        return text;
    }

    /**
     * Gets the hl7Title
     * <div>The German title shall be "Medikamentöser Behandlungsplan".</div><div>The French title shall be "Plan de traitement médicamenteux".</div><div>The Italian title shall be "Piano terapeutico farmacologico".</div><div>The English title shall be "Medication Treatment Plan".</div><div>Titles in other languages are allowed and unrestricted.</div>
     */
    public org.husky.emed.cda.generated.hl7cdar2.ST getHl7Title() {
        return title;
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.husky.emed.cda.generated.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7Entry
     */
    public void setHl7Entry(org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Entry value) {
        getEntry().clear();
        getEntry().add(value);
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.husky.emed.cda.generated.hl7cdar2.II value) {
        this.id = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.emed.cda.generated.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     */
    public void setHl7Text(org.husky.emed.cda.generated.hl7cdar2.StrucDocText value) {
        this.text = value;
    }

    /**
     * Sets the hl7Title
     * <div>The German title shall be "Medikamentöser Behandlungsplan".</div><div>The French title shall be "Plan de traitement médicamenteux".</div><div>The Italian title shall be "Piano terapeutico farmacologico".</div><div>The English title shall be "Medication Treatment Plan".</div><div>Titles in other languages are allowed and unrestricted.</div>
     */
    public void setHl7Title(org.husky.emed.cda.generated.hl7cdar2.ST value) {
        this.title = value;
    }
}
