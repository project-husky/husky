/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.ems.generated.artdecor;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.EntityDeterminerDetermined;
import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040ManufacturedProduct;
import org.husky.common.hl7cdar2.POCDMT000040Material;
import org.husky.common.hl7cdar2.POCDMT000040Organization;
import org.husky.common.hl7cdar2.RoleClassManufacturedProduct;

/**
 * atcdabbr_other_vaccineProduct
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.32<br>
 * Effective date: 2021-10-01 13:21:55<br>
 * Version: 1.0.1+20220103<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class AtcdabbrOtherVaccineProduct extends POCDMT000040ManufacturedProduct {

    public AtcdabbrOtherVaccineProduct() {
		super.setClassCode(RoleClassManufacturedProduct.MANU);
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.9.32"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.53"));
		super.setManufacturedMaterial(createHl7ManufacturedMaterialFixedValue("MMAT", "KIND",
				createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.1")));

    }

    /**
     * Creates fixed contents for CDA Element hl7ManufacturedMaterial
     *
     * @param classCode the desired fixed value for this argument.
     * @param determinerCode the desired fixed value for this argument.
     */
	private static org.husky.common.hl7cdar2.POCDMT000040Material createHl7ManufacturedMaterialFixedValue(
			String classCode, String determinerCode, II templateId) {
		ObjectFactory factory = new ObjectFactory();
		POCDMT000040Material retVal = factory.createPOCDMT000040Material();
		retVal.setClassCode(classCode);
		retVal.setDeterminerCode(EntityDeterminerDetermined.fromValue(determinerCode));
		retVal.getTemplateId().add(templateId);
		return retVal;

    }

	/**
	 * Creates fixed contents for CDA Element hl7ManufacturerOrganization
	 *
	 * @param classCode      the desired fixed value for this argument.
	 * @param determinerCode the desired fixed value for this argument.
	 */
	private static POCDMT000040Organization createHl7ManufacturerOrganizationFixedValue(String classCode,
			String determinerCode) {
		ObjectFactory factory = new ObjectFactory();
		POCDMT000040Organization retVal = factory.createPOCDMT000040Organization();
		retVal.setClassCode(classCode);
		retVal.setDeterminerCode(determinerCode);
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
     * Gets the hl7Id
     */
	public List<org.husky.common.hl7cdar2.II> getHl7Id() {
		return this.getId();
    }

    /**
     * Gets the hl7ManufacturedMaterial
     */
	public org.husky.common.hl7cdar2.POCDMT000040Material getHl7ManufacturedMaterial() {
		return this.manufacturedMaterial;
    }

    /**
     * Gets the hl7ManufacturerOrganization
     */
	public org.husky.common.hl7cdar2.POCDMT000040Organization getHl7ManufacturerOrganization() {
		return this.manufacturerOrganization;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Entry, filled by: "ORG", "INSTANCE"
     * @return the predefined element.
     */
	public static org.husky.common.hl7cdar2.POCDMT000040Organization getPredefinedManufacturerOrganizationOrgInstance() {
		return createHl7ManufacturerOrganizationFixedValue("ORG", "INSTANCE");
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.husky.common.hl7cdar2.II value) {
		if (this.id == null) {
			this.id = new LinkedList<>();
		}
		this.id.clear();
		this.id.add(value);
    }

    /**
     * Sets the hl7ManufacturedMaterial
     */
	public void setHl7ManufacturedMaterial(org.husky.common.hl7cdar2.POCDMT000040Material value) {
		this.manufacturedMaterial = value;
    }

    /**
     * Sets the hl7ManufacturerOrganization
     */
	public void setHl7ManufacturerOrganization(org.husky.common.hl7cdar2.POCDMT000040Organization value) {
		this.manufacturerOrganization = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
		if (this.templateId == null) {
			this.templateId = new LinkedList<>();
		}
		this.templateId.clear();
		this.templateId.add(value);
    }
}
