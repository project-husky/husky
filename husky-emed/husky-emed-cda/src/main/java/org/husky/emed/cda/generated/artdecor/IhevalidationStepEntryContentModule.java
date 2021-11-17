package org.husky.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.*;

/**
 * IHEValidationStepEntryContentModule
 * <p>
 * Template description: Reference to a Medication Treatment Plan Entry<br>
 * Element description: Reference to Medication Treatment Plan Item General Specification<br>
 * <p>
 * Identifier: 1.3.6.1.4.1.19376.1.9.1.3.16<br>
 * Effective date: 2020-02-03 18:26:16<br>
 * Version: 2020<br>
 * Status: pending
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-09-08")
public class IhevalidationStepEntryContentModule extends POCDMT000040SubstanceAdministration {

    public IhevalidationStepEntryContentModule() {
        super.getClassCode().add("SBADM");
        super.setMoodCode(XDocumentSubstanceMood.PRP);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.16"));
        super.setConsumable(createHl7ConsumableNa());
    }

    /**
     * Creates fixed contents for CDA Element hl7Consumable, containing an hl7ManufacturedMaterial with a null flavor NA.
     */
    private static POCDMT000040Consumable createHl7ConsumableNa() {
        final POCDMT000040Material material = new POCDMT000040Material();
        material.getNullFlavor().add("NA");
        final POCDMT000040ManufacturedProduct product = new POCDMT000040ManufacturedProduct();
        product.setManufacturedMaterial(material);
        final POCDMT000040Consumable consumable = new POCDMT000040Consumable();
        consumable.setManufacturedProduct(product);
        return consumable;
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
     * Gets the hl7Consumable
     */
    public POCDMT000040Consumable getHl7Consumable() {
        return consumable;
    }

    /**
     * Gets the hl7TemplateId
     * Reference to Medication Treatment Plan Item General Specification Template ID
     */
    public List<II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Sets the hl7Consumable
     */
    public void setHl7Consumable(POCDMT000040Consumable value) {
        this.consumable = value;
    }

    /**
     * Sets the hl7TemplateId
     * Reference to Medication Treatment Plan Item General Specification Template ID
     */
    public void setHl7TemplateId(II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
