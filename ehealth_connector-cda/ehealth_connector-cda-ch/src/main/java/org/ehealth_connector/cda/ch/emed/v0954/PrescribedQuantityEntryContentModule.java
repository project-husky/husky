/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */
package org.ehealth_connector.cda.ch.emed.v0954;

import java.util.List;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.4.38 Template
 * description: Amount of units of the consumable to dispense
 */
public class PrescribedQuantityEntryContentModule
		extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Supply {

	public PrescribedQuantityEntryContentModule() {
		super.setClassCode(org.ehealth_connector.common.hl7cdar2.ActClassSupply.fromValue("SPLY"));
		super.setMoodCode(
				org.ehealth_connector.common.hl7cdar2.XDocumentSubstanceMood.fromValue("RQO"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.8"));
		super.setIndependentInd(createHl7IndependentIndFixedValue("false"));
		super.setQuantity(createHl7QuantityFixedValue("1"));
	}

	/**
	 * Creates fixed contents for CDA Element hl7IndependentInd
	 *
	 * @param value
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.BL createHl7IndependentIndFixedValue(
			String value) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.BL retVal = factory.createBL();
		retVal.setValue(Boolean.parseBoolean(value));
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7Quantity
	 *
	 * @param unit
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.PQ createHl7QuantityFixedValue(
			String unit) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.PQ retVal = factory.createPQ();
		retVal.setUnit(unit);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.II createHl7TemplateIdFixedValue(
			String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Gets the hl7IndependentInd
	 */
	public org.ehealth_connector.common.hl7cdar2.BL getHl7IndependentInd() {
		return independentInd;
	}

	/**
	 * Gets the hl7Quantity
	 */
	public org.ehealth_connector.common.hl7cdar2.PQ getHl7Quantity() {
		return quantity;
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Sets the hl7IndependentInd
	 */
	public void setHl7IndependentInd(org.ehealth_connector.common.hl7cdar2.BL value) {
		this.independentInd = value;
	}

	/**
	 * Sets the hl7Quantity
	 */
	public void setHl7Quantity(org.ehealth_connector.common.hl7cdar2.PQ value) {
		this.quantity = value;
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}
}
