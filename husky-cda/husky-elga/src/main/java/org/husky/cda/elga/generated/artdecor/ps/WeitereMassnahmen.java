/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.generated.artdecor.ps;

import org.husky.common.hl7cdar2.ActRelationshipHasComponent;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Component5;

/**
 * Original ART-DECOR template id: 1.2.40.0.34.11.2.2.9
 */
public class WeitereMassnahmen
		extends org.husky.common.hl7cdar2.POCDMT000040Section {

	public WeitereMassnahmen() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.2.2.9"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.3.31"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.10"));
		super.setCode(createHl7CodeFixedValue("18776-5", "2.16.840.1.113883.6.1", null,
				"Treatment plan"));
	}

	/**
	 * Adds a hl7Component
	 */
	public void addHl7Component(
			org.husky.common.hl7cdar2.POCDMT000040Component5 value) {
		component.add(value);
	}

	/**
	 * Adds a hl7Entry
	 */
	public void addHl7Entry(
			org.husky.common.hl7cdar2.POCDMT000040Entry value) {
		entry.add(value);
	}

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 */
	private static CE createHl7CodeFixedValue(String code, String codeSystem,
			String codeSystemName, String displayName) {
		CE retVal = new CE();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		retVal.setDisplayName(displayName);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7Component
	 *
	 * @param typeCode
	 *            the desired fixed value for this argument.
	 * @param contextConductionInd
	 *            the desired fixed value for this argument.
	 */
	private static POCDMT000040Component5 createHl7ComponentFixedValue(String typeCode, String contextConductionInd) {
		ObjectFactory factory = new ObjectFactory();
		POCDMT000040Component5 retVal = factory.createPOCDMT000040Component5();
		retVal.setTypeCode(ActRelationshipHasComponent.valueOf(typeCode));
		retVal.setContextConductionInd(Boolean.valueOf(contextConductionInd));
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root
	 *            the desired fixed value for this argument.
	 */
	private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(
			String root) {
		ObjectFactory factory = new ObjectFactory();
		org.husky.common.hl7cdar2.II retVal = factory.createII();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Gets the hl7Code
	 */
	public org.husky.common.hl7cdar2.CE getHl7Code() {
		return getCode();
	}

	/**
	 * Gets the hl7TemplateId
	 */
	public java.util.List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
		return templateId;
	}

	/**
	 * Gets the hl7Text
	 */
	public org.husky.common.hl7cdar2.StrucDocText getHl7Text() {
		return getText();
	}

	/**
	 * Gets the hl7Title
	 */
	public org.husky.common.hl7cdar2.ST getHl7Title() {
		return getTitle();
	}

	/**
	 * Adds a predefined void, filled by: "COMP", "true"
	 * 
	 * @return the predefined element.
	 */
	public static POCDMT000040Component5 getPredefinedComponentCompTrue() {
		return createHl7ComponentFixedValue("COMP", "true");
	}

	/**
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.husky.common.hl7cdar2.CE value) {
		setCode(value);
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

	/**
	 * Sets the hl7Text
	 */
	public void setHl7Text(org.husky.common.hl7cdar2.StrucDocText value) {
		setText(value);
	}

	/**
	 * Sets the hl7Title
	 */
	public void setHl7Title(org.husky.common.hl7cdar2.ST value) {
		setTitle(value);
	}
}
