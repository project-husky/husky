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

import java.util.ArrayList;
import java.util.List;
import org.ehealth_connector.common.hl7cdar2.IVLTS;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 1.3.6.1.4.1.19376.1.9.1.3.1
 * Template description: IHE PHARM PRE Medicine Entry General Specification
 */
public class IhemedicineEntryContentModule extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Material {

	public IhemedicineEntryContentModule() {
		super.setClassCode("MMAT");
		super.setDeterminerCode(org.ehealth_connector.common.hl7cdar2.EntityDeterminerDetermined.fromValue("KIND"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.1"));
		super.setName(createHl7NameFixedValue("NA"));
	// This is fixed content for an optional element: createPharmAsContentFixedValue("CONT") --> Creating getPredefinedAsContentCont();
	// This is fixed content for an optional element: createPharmAsSpecializedKindFixedValue("GRIC") --> Creating getPredefinedAsSpecializedKindGric();
	// This is fixed content for an optional element: createPharmIngredientFixedValue("ACTI") --> Creating getPredefinedIngredientActi();
	}

	/**
	 * Adds a pharmAsSpecializedKind
	 * Generic Equivalent
	 */
	public void addPharmAsSpecializedKind(org.ehealth_connector.common.hl7cdar2.COCTMT230100UVSpecializedKind value) {
		getAsSpecializedKind().add(value);
	}

	/**
	 * Adds a pharmFormCode
	 * Form Code
	 */
	public void addPharmFormCode(org.ehealth_connector.common.hl7cdar2.CE value) {
		formCode = value;
	}

	/**
	 * Adds a pharmIngredient
	 * Active Ingredient List
	 */
	public void addPharmIngredient(org.ehealth_connector.common.hl7cdar2.COCTMT230100UVIngredient value) {
		getIngredient().add(value);
	}

	/**
	 * Adds a pharmAsSpecializedKind
	 * Generic Equivalent
	 */
	public void clearPharmAsSpecializedKind() {
		getAsSpecializedKind().clear();
	}

	/**
	 * Adds a pharmIngredient
	 * Active Ingredient List
	 */
	public void clearPharmIngredient() {
		getIngredient().clear();
	}

	/**
	 * Creates fixed contents for CDA Element hl7Name
	 *
	 * @param nullFlavor the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.EN createHl7NameFixedValue(String nullFlavor) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.EN retVal = factory.createEN();
		retVal.nullFlavor = new ArrayList<String>();
		retVal.nullFlavor.add(nullFlavor);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element pharmAsContent
	 *
	 * @param classCode the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.COCTMT230100UVContent createPharmAsContentFixedValue(String classCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.COCTMT230100UVContent retVal = factory.createCOCTMT230100UVContent();
		retVal.setClassCode(org.ehealth_connector.common.hl7cdar2.RoleClassContent.fromValue(classCode));
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element pharmAsSpecializedKind
	 *
	 * @param classCode the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.COCTMT230100UVSpecializedKind createPharmAsSpecializedKindFixedValue(String classCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.COCTMT230100UVSpecializedKind retVal = factory.createCOCTMT230100UVSpecializedKind();
		retVal.setClassCode(org.ehealth_connector.common.hl7cdar2.RoleClassIsSpeciesEntity.fromValue(classCode));
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element pharmIngredient
	 *
	 * @param classCode the desired fixed value for this argument.
	 */
	private static org.ehealth_connector.common.hl7cdar2.COCTMT230100UVIngredient createPharmIngredientFixedValue(String classCode) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.COCTMT230100UVIngredient retVal = factory.createCOCTMT230100UVIngredient();
		retVal.setClassCode(classCode);
		return retVal;
	}

	/**
	 * Gets the hl7Code
	 * Code
	 */
	public org.ehealth_connector.common.hl7cdar2.CE getHl7Code() {
		return code;
	}

	/**
	 * Gets the hl7LotNumberText
	 * Lot Number
	 */
	public org.ehealth_connector.common.hl7cdar2.ST getHl7LotNumberText() {
		return lotNumberText;
	}

	/**
	 * Gets the hl7Name
	 * Name
	 */
	public org.ehealth_connector.common.hl7cdar2.EN getHl7Name() {
		return name;
	}

	/**
	 * Gets the hl7TemplateId
	 * Medicine Entry Template ID
	 */
	public java.util.List<org.ehealth_connector.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the pharmAsContent
	 * Packaging
	 */
	public org.ehealth_connector.common.hl7cdar2.COCTMT230100UVContent getPharmAsContent() {
		return asContent;
	}

	/**
	 * Gets the pharmExpirationTime
	 * Expiration Date
	 */
	public org.ehealth_connector.common.hl7cdar2.TS getPharmExpirationTime() {
		return expirationTime;
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.COCTMT230100UVContent, filled by: "CONT"
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.COCTMT230100UVContent getPredefinedAsContentCont() {
		return createPharmAsContentFixedValue("CONT");
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.COCTMT230100UVSpecializedKind, filled by: "GRIC"
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.COCTMT230100UVSpecializedKind getPredefinedAsSpecializedKindGric() {
		return createPharmAsSpecializedKindFixedValue("GRIC");
	}

	/**
	 * Adds a predefined org.ehealth_connector.common.hl7cdar2.COCTMT230100UVIngredient, filled by: "ACTI"
	 * @return the predefined element.
	 */
	public static org.ehealth_connector.common.hl7cdar2.COCTMT230100UVIngredient getPredefinedIngredientActi() {
		return createPharmIngredientFixedValue("ACTI");
	}

	/**
	 * Sets the hl7Code
	 * Code
	 */
	public void setHl7Code(org.ehealth_connector.common.hl7cdar2.CE value) {
		this.code = value;
	}

	/**
	 * Sets the hl7LotNumberText
	 * Lot Number
	 */
	public void setHl7LotNumberText(org.ehealth_connector.common.hl7cdar2.ST value) {
		this.lotNumberText = value;
	}

	/**
	 * Sets the hl7Name
	 * Name
	 */
	public void setHl7Name(org.ehealth_connector.common.hl7cdar2.EN value) {
		this.name = value;
	}

	/**
	 * Sets the hl7TemplateId
	 * Medicine Entry Template ID
	 */
	public void setHl7TemplateId(org.ehealth_connector.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the pharmAsContent
	 * Packaging
	 */
	public void setPharmAsContent(org.ehealth_connector.common.hl7cdar2.COCTMT230100UVContent value) {
		this.asContent = value;
	}

	/**
	 * Sets the pharmExpirationTime
	 * Expiration Date
	 */
	public void setPharmExpirationTime(org.ehealth_connector.common.hl7cdar2.TS value) {
		ObjectFactory factory = new ObjectFactory();
		IVLTS ivlts = factory.createIVLTS();
		ivlts.setValue(value.getValue());
		this.expirationTime = ivlts;
	}
}
