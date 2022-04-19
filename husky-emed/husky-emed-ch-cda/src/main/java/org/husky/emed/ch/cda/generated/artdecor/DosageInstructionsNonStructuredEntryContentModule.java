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
import org.husky.common.hl7cdar2.POCDMT000040Consumable;
import org.husky.common.hl7cdar2.POCDMT000040ManufacturedProduct;
import org.husky.common.hl7cdar2.POCDMT000040Material;
import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;

/**
 * DosageInstructionsNonStructuredEntryContentModule
 * <p>
 * Template description: Dosage Instructions reference to free text (non structured) in narrative part.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.4.52<br>
 * Effective date: 2016-09-13 15:33:18<br>
 * Version: 2017<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-04-19")
public class DosageInstructionsNonStructuredEntryContentModule extends POCDMT000040SubstanceAdministration {

    public DosageInstructionsNonStructuredEntryContentModule() {
        super.getClassCode().add("SBADM");
        super.setMoodCode(org.husky.common.hl7cdar2.XDocumentSubstanceMood.INT);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.756.5.30.1.1.10.4.52"));
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
    private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Consumable
     */
    public org.husky.common.hl7cdar2.POCDMT000040Consumable getHl7Consumable() {
        return consumable;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text<br/>
     * It shall contain both the narrative text content and a reference to the human readable part of the item. This human readable part may contain a simple text to redirect the reader to the PDF document (e.g. "See PDF version included").<br/>There shall be a single non-blank text node (i.e. the text shall be completely before or after the reference, see examples). The text shall be raw (i.e. no markup shall be used).
     */
    public org.husky.common.hl7cdar2.ED getHl7Text() {
        return text;
    }

    /**
     * Sets the hl7Consumable
     */
    public void setHl7Consumable(org.husky.common.hl7cdar2.POCDMT000040Consumable value) {
        this.consumable = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text<br/>
     * It shall contain both the narrative text content and a reference to the human readable part of the item. This human readable part may contain a simple text to redirect the reader to the PDF document (e.g. "See PDF version included").<br/>There shall be a single non-blank text node (i.e. the text shall be completely before or after the reference, see examples). The text shall be raw (i.e. no markup shall be used).
     */
    public void setHl7Text(org.husky.common.hl7cdar2.ED value) {
        this.text = value;
    }
}
