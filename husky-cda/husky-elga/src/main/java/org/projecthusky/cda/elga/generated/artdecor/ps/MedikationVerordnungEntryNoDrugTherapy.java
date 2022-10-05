/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.generated.artdecor.ps;

import java.util.ArrayList;
import java.util.List;

import org.projecthusky.common.hl7cdar2.CD;
import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.hl7cdar2.CS;
import org.projecthusky.common.hl7cdar2.EntityDeterminerDetermined;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.RoleClassManufacturedProduct;
import org.projecthusky.common.hl7cdar2.XDocumentSubstanceMood;

/**
 * Original ART-DECOR template id: 1.2.40.0.34.11.8.1.3.2
 */
public class MedikationVerordnungEntryNoDrugTherapy
		extends org.projecthusky.common.hl7cdar2.POCDMT000040SubstanceAdministration {

	public MedikationVerordnungEntryNoDrugTherapy() {
		super.getClassCode().add("SBADM");
		super.setMoodCode(XDocumentSubstanceMood.valueOf("INT"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.8.1.3.2"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.24"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.1"));
		super.setCode(createHl7CodeFixedValue("182849000", "2.16.840.1.113883.6.96", null,
				"no drug therapy prescribed"));
		
		super.setStatusCode(createHl7StatusCodeFixedValue("completed", null, null, null));
		super.setConsumable(createHl7ConsumableFixedValue());
	}

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 */
	private static CD createHl7CodeFixedValue(String code, String codeSystem,
			String codeSystemName, String displayName) {
		CD retVal = new CD();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		retVal.setDisplayName(displayName);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7StatusCode
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 */
	private static CS createHl7StatusCodeFixedValue(String code, String codeSystem,
			String codeSystemName, String displayName) {
		CS retVal = new CS();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		retVal.setDisplayName(displayName);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	private static org.projecthusky.common.hl7cdar2.II createHl7TemplateIdFixedValue(
			String root) {
		ObjectFactory factory = new ObjectFactory();
		org.projecthusky.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}
	
	/**
	 * Creates fixed contents for CDA Element hl7Consumable
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	private static org.projecthusky.common.hl7cdar2.POCDMT000040Consumable createHl7ConsumableFixedValue() {
		ObjectFactory factory = new ObjectFactory();
		org.projecthusky.common.hl7cdar2.POCDMT000040Consumable retVal = factory.createPOCDMT000040Consumable();
		org.projecthusky.common.hl7cdar2.POCDMT000040ManufacturedProduct prod = factory
				.createPOCDMT000040ManufacturedProduct();
		prod.setClassCode(RoleClassManufacturedProduct.MANU);
		prod.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.2"));
		prod.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.53"));
		org.projecthusky.common.hl7cdar2.POCDMT000040Material material = factory.createPOCDMT000040Material();
		material.setClassCode("MMAT");
		material.setDeterminerCode(EntityDeterminerDetermined.KIND);
		CE code = factory.createCE();
		code.nullFlavor = new ArrayList<>();
		code.nullFlavor.add("NA");
		material.setCode(code);
		prod.setManufacturedMaterial(material);	
		retVal.setManufacturedProduct(prod);
		return retVal;
	}

	/**
	 * Gets the hl7Code
	 */
	public org.projecthusky.common.hl7cdar2.CD getHl7Code() {
		return getCode();
	}

	/**
	 * Gets the hl7Consumable
	 */
	public org.projecthusky.common.hl7cdar2.POCDMT000040Consumable getHl7Consumable() {
		return getConsumable();
	}

	/**
	 * Gets the hl7Id
	 */
	public List<org.projecthusky.common.hl7cdar2.II> getHl7Id() {
		return getId();
	}

	/**
	 * Gets the hl7StatusCode
	 */
	public org.projecthusky.common.hl7cdar2.CS getHl7StatusCode() {
		return getStatusCode();
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Text
	 */
	public org.projecthusky.common.hl7cdar2.ED getHl7Text() {
		return getText();
	}

	/**
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.projecthusky.common.hl7cdar2.CD value) {
		setCode(value);
	}

	/**
	 * Sets the hl7Consumable
	 */
	public void setHl7Consumable(
			org.projecthusky.common.hl7cdar2.POCDMT000040Consumable value) {
		setConsumable(value);
	}

	/**
	 * Sets the hl7Id
	 */
	public void setHl7Id(org.projecthusky.common.hl7cdar2.II value) {
		getId().add(value);
	}

	/**
	 * Sets the hl7StatusCode
	 */
	public void setHl7StatusCode(org.projecthusky.common.hl7cdar2.CS value) {
		setStatusCode(value);
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
		setText(value);
	}
}
