package org.ehealth_connector.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.ObjectFactory;
import org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040Section;

/**
 * MedicationCardSectionContentModule
 * <p>
 * Template description: The Meciation Card Section includes the current and planned medication of a patient. See<a class="" href="http://www.ihe.net/uploadedFiles/Documents/Pharmacy/IHE_Pharmacy_Suppl_PML.pdf" target="" title="">IHE Pharmacy PML Suppl</a>. It includes entries for Medication Treatment Plan Items as described in the Medication Treatment Plan Item Entry Content Module. See also<a class="" href="http://www.ihe.net/uploadedFiles/Documents/Pharmacy/IHE_Pharmacy_Suppl_MTP.pdf" target="" title="">IHE Pharmacy MTP Suppl</a>. Other entries like Prescription, Dispense and Pharmaceutical Advise entries which are allowd in a PML section are not allowed in the eCurrentMedication section.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.3.9<br>
 * Effective date: 2016-05-21 00:00:00<br>
 * Version: 2021<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class MedicationCardSectionContentModule extends POCDMT000040Section {

    public MedicationCardSectionContentModule() {
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.3.9"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.2.5"));
        super.setCode(createHl7CodeFixedValue("10160-0",
                                              "2.16.840.1.113883.6.1",
                                              "LOINC",
                                              "History of medication use"));
    }

    /**
     * Adds a hl7Author
     * Information about the author of a CDA document, section or entry. An author MAY be a person or a device.
     */
    public void addHl7Author(org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040Author value) {
        getAuthor().add(value);
    }

    /**
     * Adds a hl7Entry
     */
    public void addHl7Entry(org.ehealth_connector.emed.cda.generated.hl7cdar2.POCDMT000040Entry value) {
        getEntry().add(value);
    }

    /**
     * Adds a hl7Author
     * Information about the author of a CDA document, section or entry. An author MAY be a person or a device.
     */
    public void clearHl7Author() {
        getAuthor().clear();
    }

    /**
     * Adds a hl7Entry
     */
    public void clearHl7Entry() {
        getEntry().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.ehealth_connector.emed.cda.generated.hl7cdar2.CE createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.ehealth_connector.emed.cda.generated.hl7cdar2.CE retVal = factory.createCE();
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
    private static org.ehealth_connector.emed.cda.generated.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.ehealth_connector.emed.cda.generated.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Code
     * IHE Pharm PML 6.3.3.10.S1.1
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.CE getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7Id
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.II getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7TemplateId
     * CH-PHARM Medication Card Section Content Module
     */
    public List<org.ehealth_connector.emed.cda.generated.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.StrucDocText getHl7Text() {
        return text;
    }

    /**
     * Gets the hl7Title
     * <div>The German title shall be "Medikamentenliste".</div><div>The French title shall be "Liste de médicaments".</div><div>The Italian title shall be "Lista farmaci".</div><div>The English title shall be "Medication List".</div><div>Titles in other languages are allowed and unrestricted.</div>
     */
    public org.ehealth_connector.emed.cda.generated.hl7cdar2.ST getHl7Title() {
        return title;
    }

    /**
     * Sets the hl7Code
     * IHE Pharm PML 6.3.3.10.S1.1
     */
    public void setHl7Code(org.ehealth_connector.emed.cda.generated.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.ehealth_connector.emed.cda.generated.hl7cdar2.II value) {
        this.id = value;
    }

    /**
     * Sets the hl7TemplateId
     * CH-PHARM Medication Card Section Content Module
     */
    public void setHl7TemplateId(org.ehealth_connector.emed.cda.generated.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     */
    public void setHl7Text(org.ehealth_connector.emed.cda.generated.hl7cdar2.StrucDocText value) {
        this.text = value;
    }

    /**
     * Sets the hl7Title
     * <div>The German title shall be "Medikamentenliste".</div><div>The French title shall be "Liste de médicaments".</div><div>The Italian title shall be "Lista farmaci".</div><div>The English title shall be "Medication List".</div><div>Titles in other languages are allowed and unrestricted.</div>
     */
    public void setHl7Title(org.ehealth_connector.emed.cda.generated.hl7cdar2.ST value) {
        this.title = value;
    }
}
