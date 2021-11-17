package org.husky.emed.cda.generated.artdecor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.*;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Material;

/**
 * ManufacturedMaterialEntryContentModule
 * <p>
 * Template description: A Medicine entry describes a medicine and is used within Medication Treatment- Prescription- or Dispensation Items. It describes either a medicinal product, a generic/scientific name or a magistral preparation/compound medicine and contains information such as name, medication form, packaging information and active ingredients.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.4.33<br>
 * Effective date: 2019-12-11 11:34:24<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class ManufacturedMaterialEntryContentModule extends POCDMT000040Material {

    public ManufacturedMaterialEntryContentModule() {
        super.setClassCode("MMAT");
        super.setDeterminerCode(EntityDeterminerDetermined.KIND);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.33"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.1"));
        super.setCode(createHl7CodeFixedValue("NA",
                                              "2.51.1.1"));
        super.setName(createHl7NameFixedValue("NA"));
    }

    /**
     * Adds a pharmIngredient
     * One or more active ingredients SHOULD be represented with this structure.
     */
    public void addPharmIngredient(COCTMT230100UVIngredient value) {
        getIngredient().add(value);
    }

    /**
     * Adds a pharmIngredient
     * One or more active ingredients SHOULD be represented with this structure.
     */
    public void clearPharmIngredient() {
        getIngredient().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param nullFlavor the desired fixed value for this argument.
     * @param codeSystem the desired fixed value for this argument.
     */
    private static CE createHl7CodeFixedValue(String nullFlavor, String codeSystem) {
        ObjectFactory factory = new ObjectFactory();
        CE retVal = factory.createCE();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        retVal.setCodeSystem(codeSystem);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Name
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static EN createHl7NameFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        EN retVal = factory.createEN();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
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
     * Creates fixed contents for CDA Element pharmAsContent
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static COCTMT230100UVContent createPharmAsContentFixedValue(String classCode) {
        ObjectFactory factory = new ObjectFactory();
        COCTMT230100UVContent retVal = factory.createCOCTMT230100UVContent();
        retVal.setClassCode(RoleClassContent.fromValue(classCode));
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element pharmFormCode
     */
    private static CE createPharmFormCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element pharmIngredient
     *
     * @param classCode the desired fixed value for this argument.
     */
    private static COCTMT230100UVIngredient createPharmIngredientFixedValue(String classCode) {
        ObjectFactory factory = new ObjectFactory();
        COCTMT230100UVIngredient retVal = factory.createCOCTMT230100UVIngredient();
        retVal.setClassCode(classCode);
        return retVal;
    }

    /**
     * Gets the hl7Code
     * The element SHALL be present and describes the code of the medication package (GTIN). If it is a magistral preparation/compound medicin @nullFlavor SHALL be "NA".
     */
    public CE getHl7Code() {
        return code;
    }

    /**
     * Gets the hl7LotNumberText
     */
    public ST getHl7LotNumberText() {
        return lotNumberText;
    }

    /**
     * Gets the hl7Name
     * The element SHALL contain the name of the medication.
     */
    public EN getHl7Name() {
        return name;
    }

    /**
     * Gets the hl7TemplateId
     * CH-PHARM Manufactured Material Content Module
     */
    public List<II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the pharmAsContent
     */
    public COCTMT230100UVContent getPharmAsContent() {
        return asContent;
    }

    /**
     * Gets the pharmExpirationTime
     */
    public TS getPharmExpirationTime() {
        return expirationTime;
    }

    /**
     * Gets the pharmFormCode
     * This code represents the pharmaceutical dose form (e.g., tablet, capsule, liquid) and SHOULD be present, if not implied by the product.
     */
    public CE getPharmFormCode() {
        return formCode;
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.COCTMT230100UVContent, filled by: "CONT"
     * @return the predefined element.
     */
    public static COCTMT230100UVContent getPredefinedAsContentCont() {
        return createPharmAsContentFixedValue("CONT");
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static CE getPredefinedFormCode() {
        return createPharmFormCodeFixedValue();
    }

    /**
     * Adds a predefined org.ehealth_connector.emed.cda.generated.hl7cdar2.COCTMT230100UVIngredient, filled by: "ACTI"
     * @return the predefined element.
     */
    public static COCTMT230100UVIngredient getPredefinedIngredientActi() {
        return createPharmIngredientFixedValue("ACTI");
    }

    /**
     * Sets the hl7Code
     * The element SHALL be present and describes the code of the medication package (GTIN). If it is a magistral preparation/compound medicin @nullFlavor SHALL be "NA".
     */
    public void setHl7Code(CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7LotNumberText
     */
    public void setHl7LotNumberText(ST value) {
        this.lotNumberText = value;
    }

    /**
     * Sets the hl7Name
     * The element SHALL contain the name of the medication.
     */
    public void setHl7Name(EN value) {
        this.name = value;
    }

    /**
     * Sets the hl7TemplateId
     * CH-PHARM Manufactured Material Content Module
     */
    public void setHl7TemplateId(II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the pharmAsContent
     */
    public void setPharmAsContent(COCTMT230100UVContent value) {
        this.asContent = value;
    }

    /**
     * Sets the pharmExpirationTime
     */
    public void setPharmExpirationTime(TS value) {
        ObjectFactory factory = new ObjectFactory();
        IVLTS ivlts = factory.createIVLTS();
        ivlts.setValue(value.getValue());
        this.expirationTime = ivlts;
    }

    /**
     * Sets the pharmFormCode
     * This code represents the pharmaceutical dose form (e.g., tablet, capsule, liquid) and SHOULD be present, if not implied by the product.
     */
    public void setPharmFormCode(CE value) {
        this.formCode = value;
    }
}
