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

import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.XActRelationshipEntry;

/**
 * Original ART-DECOR template id: 1.2.40.0.34.11.2.2.8
 */
public class EmpfohleneMedikationFull
		extends org.husky.common.hl7cdar2.POCDMT000040Section {

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 *
	 * @param code
	 *            the desired fixed value for this argument.
	 */
	private static CE createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName,
			String displayName) {
		CE retVal = new CE();
		retVal.setCode(code);
		retVal.setCodeSystem(codeSystem);
		retVal.setCodeSystemName(codeSystemName);
		retVal.setDisplayName(displayName);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7Entry
	 *
	 * @param typeCode
	 *            the desired fixed value for this argument.
	 */
	private static XActRelationshipEntry createHl7EntryFixedValue(String typeCode) {
		return XActRelationshipEntry.valueOf(typeCode);
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
	 * Adds a predefined void, filled by: "DRIV"
	 *
	 * @return the predefined element.
	 */
	public static XActRelationshipEntry getPredefinedEntryDriv() {
		return createHl7EntryFixedValue("DRIV");
	}

	public EmpfohleneMedikationFull() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.2.2.8"));
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.3.22"));
		super.setCode(createHl7CodeFixedValue("10183-2", "2.16.840.1.113883.6.1", null,
				"Hospital discharge medications"));
	}

	/**
	 * Gets the hl7Code
	 */
	public org.husky.common.hl7cdar2.CE getHl7Code() {
		return this.code;
	}

	/**
	 * Gets the hl7Entry
	 */
	public org.husky.common.hl7cdar2.POCDMT000040Entry getHl7EntryPocdmt000040Entry() {
		return this.entry.get(0);
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
		return this.text;
	}

	/**
	 * Gets the hl7Title
	 */
	public org.husky.common.hl7cdar2.ST getHl7Title() {
		return this.title;
	}

	/**
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.husky.common.hl7cdar2.CE value) {
		this.code = value;
	}

	/**
	 * Sets the hl7Entry
	 */
	public void setHl7Entry(org.husky.common.hl7cdar2.POCDMT000040Entry value) {
		if(value != null) {
			value.setTypeCode(getPredefinedEntryDriv());
			this.getEntry().add(value);	
		}
	}

	/**
	 * Sets the hl7TemplateId
	 */
	public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
		getTemplateId().clear();
		getTemplateId().add(value);
	}

}
