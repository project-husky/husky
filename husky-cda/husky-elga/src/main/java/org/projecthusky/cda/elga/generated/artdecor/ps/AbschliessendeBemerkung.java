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

import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.hl7cdar2.II;
import org.projecthusky.common.hl7cdar2.StrucDocText;

/**
 * Original ART-DECOR template id: 1.2.40.0.34.11.1.2.2
 */
public class AbschliessendeBemerkung extends org.projecthusky.common.hl7cdar2.POCDMT000040Section {

	/**
	 * Creates fixed contents for CDA Element hl7Code
	 *
	 * @param code the desired fixed value for this argument.
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
	 * Creates fixed contents for CDA Element hl7TemplateId
	 *
	 * @param root the desired fixed value for this argument.
	 */
	private static org.projecthusky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
		org.projecthusky.common.hl7cdar2.II retVal = new II();
		retVal.setRoot(root);
		return retVal;
	}

	/**
	 * Default Constructor
	 */
	public AbschliessendeBemerkung() {
		super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.1.2.2"));
		super.setCode(
				createHl7CodeFixedValue("ABBEM", "1.2.40.0.34.5.40", "ELGA_Sections", "Abschließende Bemerkungen"));
	}

	/**
	 * Adds a hl7Entry
	 */
	public void addHl7Entry(org.projecthusky.common.hl7cdar2.POCDMT000040Entry value) {
		if (entry != null) {
			entry.add(value);
		}
	}

	/**
	 * Gets the hl7Code
	 */
	public org.projecthusky.common.hl7cdar2.CE getHl7Code() {
		return this.getCode();
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
	public StrucDocText getHl7Text() {
		return this.getText();
	}

	/**
	 * Gets the hl7Title
	 */
	public org.projecthusky.common.hl7cdar2.ST getHl7Title() {
		return title;
	}

	/**
	 * Sets the hl7Code
	 */
	public void setHl7Code(org.projecthusky.common.hl7cdar2.CE value) {
		setCode(value);
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
	public void setHl7Text(StrucDocText value) {
		setText(value);
	}

	/**
	 * Sets the hl7Title
	 */
	public void setHl7Title(org.projecthusky.common.hl7cdar2.ST value) {
		setTitle(value);
	}
}
