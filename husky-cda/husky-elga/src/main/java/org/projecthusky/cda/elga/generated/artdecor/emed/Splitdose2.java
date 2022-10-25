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

import org.projecthusky.common.hl7cdar2.POCDMT000040Consumable;
import org.projecthusky.common.hl7cdar2.POCDMT000040ManufacturedProduct;
import org.projecthusky.common.hl7cdar2.POCDMT000040Material;
import org.projecthusky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.projecthusky.common.hl7cdar2.SXCMTS;
import org.projecthusky.common.hl7cdar2.XDocumentSubstanceMood;

/**
 * Splitdose2
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.30047<br>
 * Effective date: 2015-09-05 00:00:00<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-22")
public class Splitdose2 extends POCDMT000040SubstanceAdministration {

    public Splitdose2() {
        super.getClassCode().add("SBADM");
		super.setMoodCode(XDocumentSubstanceMood.INT);
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
     * Gets the hl7Consumable
     */
	public org.projecthusky.common.hl7cdar2.POCDMT000040Consumable getHl7Consumable() {
		return this.consumable;
    }

    /**
     * Gets the hl7DoseQuantity
     */
    public org.projecthusky.common.hl7cdar2.IVLPQ getHl7DoseQuantity() {
		return this.doseQuantity;
    }

    /**
     * Gets the hl7EffectiveTime
     */
	public SXCMTS getHl7EffectiveTime() {
		if (this.effectiveTime != null && !this.effectiveTime.isEmpty()) {
			return this.effectiveTime.get(0);
		}
		return null;
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
    public void setHl7EffectiveTime(org.projecthusky.common.hl7cdar2.SXPRTS value) {
		this.effectiveTime.clear();
		this.effectiveTime.add(value);
    }
}
