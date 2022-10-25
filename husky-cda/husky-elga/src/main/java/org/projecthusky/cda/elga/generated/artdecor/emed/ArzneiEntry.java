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

import java.util.List;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.EntityDeterminerDetermined;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040ManufacturedProduct;
import org.projecthusky.common.hl7cdar2.RoleClassManufacturedProduct;

/**
 * ArzneiEntry
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.2.3.4<br>
 * Effective date: 2022-01-21 11:57:02<br>
 * Version: 1.0.2+20220121<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-22")
public class ArzneiEntry extends POCDMT000040ManufacturedProduct {

    public ArzneiEntry() {
		super.setClassCode(RoleClassManufacturedProduct.MANU);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.2"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.53"));
        super.setManufacturedMaterial(createHl7ManufacturedMaterialFixedValue("MMAT",
                                                                              "KIND"));
    }

    /**
     * Creates fixed contents for CDA Element hl7ManufacturedMaterial
     *
     * @param classCode the desired fixed value for this argument.
     * @param determinerCode the desired fixed value for this argument.
     */
	private static org.projecthusky.common.hl7cdar2.POCDMT000040Material createHl7ManufacturedMaterialFixedValue(
			String classCode, String determinerCode) {
		org.projecthusky.common.hl7cdar2.POCDMT000040Material retVal = new org.projecthusky.common.hl7cdar2.POCDMT000040Material();
		retVal.setClassCode(classCode);
		retVal.setDeterminerCode(EntityDeterminerDetermined.fromValue(determinerCode));
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
     * Gets the hl7ManufacturedMaterial
     */
	public org.projecthusky.common.hl7cdar2.POCDMT000040Material getHl7ManufacturedMaterial() {
		return this.manufacturedMaterial;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Sets the hl7ManufacturedMaterial
     */
	public void setHl7ManufacturedMaterial(org.projecthusky.common.hl7cdar2.POCDMT000040Material value) {
		this.manufacturedMaterial = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.projecthusky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
