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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Consumable;
import org.projecthusky.common.hl7cdar2.POCDMT000040ManufacturedProduct;
import org.projecthusky.common.hl7cdar2.POCDMT000040Material;
import org.projecthusky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.projecthusky.common.hl7cdar2.SXCMTS;
import org.projecthusky.common.hl7cdar2.SetOperator;
import org.projecthusky.common.hl7cdar2.XDocumentSubstanceMood;

/**
 * AlteredSupplyInformation
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.90015<br>
 * Effective date: 2016-07-21 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-22")
public class AlteredSupplyInformation extends POCDMT000040SubstanceAdministration {

    public AlteredSupplyInformation() {
        super.getClassCode().add("SBADM");
		super.setMoodCode(XDocumentSubstanceMood.INT);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.6"));
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
     * Creates fixed contents for CDA Element hl7DoseQuantity
     */
    private static org.projecthusky.common.hl7cdar2.IVLPQ createHl7DoseQuantityFixedValue() {
        org.projecthusky.common.hl7cdar2.IVLPQ retVal = new org.projecthusky.common.hl7cdar2.IVLPQ();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7EffectiveTime
     *
     * @param nullFlavor the desired fixed value for this argument.
     * @param operator the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.IVLTS createHl7EffectiveTimeFixedValue(String nullFlavor, String operator) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.IVLTS retVal = factory.createIVLTS();

		if (nullFlavor != null) {
			retVal.nullFlavor = new ArrayList<String>();
			retVal.nullFlavor.add(nullFlavor);
		}

		if (operator != null) {
			retVal.setOperator(SetOperator.fromValue(operator));
		}

        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Consumable
     */
	public org.projecthusky.common.hl7cdar2.POCDMT000040Consumable getHl7Consumable() {
		return this.consumable;
    }

    /**
     * Gets the hl7DoseQuantity
     */
    public org.projecthusky.common.hl7cdar2.IVLPQ getHl7DoseQuantityIvlpq() {
		return this.doseQuantity;
    }

    /**
     * Gets the hl7EffectiveTime
     */
	public SXCMTS getHl7EffectiveTimePivlTs() {
		if (this.effectiveTime != null && !this.effectiveTime.isEmpty()) {
			return this.effectiveTime.get(0);
		}
		return null;
    }

    /**
     * Gets the hl7RouteCode
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7RouteCode() {
		return this.routeCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     */
    public org.projecthusky.common.hl7cdar2.ED getHl7Text() {
        return text;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.IVLPQ, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.IVLPQ getPredefinedDoseQuantity() {
        return createHl7DoseQuantityFixedValue();
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.IVLTS, filled by: "A", null
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.IVLTS getPredefinedEffectiveTimeANull() {
		return createHl7EffectiveTimeFixedValue(null, "A");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.IVLTS, filled by: "NA"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.IVLTS getPredefinedEffectiveTimeNa() {
		return createHl7EffectiveTimeFixedValue("NA", null);
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.II, filled by: "1.3.6.1.4.1.19376.1.5.3.1.4.21"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.II getPredefinedTemplateId136141193761531421() {
        return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.21");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.II, filled by: "1.3.6.1.4.1.19376.1.5.3.1.4.7.1"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.II getPredefinedTemplateId136141193761531471() {
        return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.1");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.II, filled by: "1.3.6.1.4.1.19376.1.5.3.1.4.9"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.II getPredefinedTemplateId13614119376153149() {
        return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.9");
    }

    /**
     * Sets the hl7Consumable
     */
	public void setHl7Consumable(org.projecthusky.common.hl7cdar2.POCDMT000040Consumable value) {
		this.consumable = value;
    }

    /**
     * Sets the hl7DoseQuantity
     */
    public void setHl7DoseQuantity(org.projecthusky.common.hl7cdar2.IVLPQ value) {
		this.doseQuantity = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
	public void setHl7EffectiveTime(org.projecthusky.common.hl7cdar2.PIVLTS value) {
		this.effectiveTime.clear();
		this.effectiveTime.add(value);
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.projecthusky.common.hl7cdar2.IVLTS value) {
		this.effectiveTime.clear();
		this.effectiveTime.add(value);
    }

    /**
     * Sets the hl7RouteCode
     */
    public void setHl7RouteCode(org.projecthusky.common.hl7cdar2.CE value) {
		this.routeCode = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.projecthusky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     */
    public void setHl7Text(org.projecthusky.common.hl7cdar2.ED value) {
        this.text = value;
    }
}
