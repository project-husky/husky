/*
 * 
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 * 
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 * 
 * This code is made available under the terms of the Eclipse Public License v1.0.
 * 
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 * 
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 * 
 */

package org.ehealth_connector.cda.ch.vacd;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.ch.vacd.enums.CdaChVacdRecCategories;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Criterion;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

// TODO: Auto-generated Javadoc
/**
 * CriterionEntry implements the structured recommendation category for
 * immunization in switzerland, see chapter 7.5.1.8. CDA-CH-VACD Valueset
 * defined for recommondation see
 * org.ehealth_connector.cda.ch.enums.CdaChVacdRecCategories
 */
public class CriterionEntry extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ch.CriterionEntry> {

	/**
	 * Instantiates a new criterion entry.
	 */
	public CriterionEntry() {
		super(CHFactory.eINSTANCE.createCriterionEntry().init());
		// cannot add it in the model because VACD has the same templateId
		this.getMdht().getTemplateIds().clear();
		this.getMdht().getTemplateIds().add(
				new Identificator("2.16.756.5.30.1.1.1.1.3.5.1", "CDA-CH.VACD.Body.MediL3.Category")
						.getIi());
	}

	/**
	 * Instantiates a new criterion entry.
	 *
	 * @param criterion
	 *            the criterion
	 */
	protected CriterionEntry(Criterion criterion) {
		super((org.openhealthtools.mdht.uml.cda.ch.CriterionEntry) criterion,
				"2.16.756.5.30.1.1.1.1.3.5.1", "CDA-CH.VACD.Body.MediL3.Category");
	}

	public void addId(Identificator id) {
		// not yet suported by MDHT model
	}

	/**
	 * Equals.
	 *
	 * @param obj
	 *            the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CriterionEntry)) {
			return false;
		}
		final CriterionEntry other = (CriterionEntry) obj;

		final Code code = getRecCategoryCode();
		if (((code != null) && !code.equals(other.getRecCategoryCode()))
				|| ((code == null) && (other.getRecCategoryCode() != null))) {
			return false;
		}

		return true;
	}

	/**
	 * Gets the recommendation category for the immunization.
	 *
	 * @return the rec category
	 */
	public CdaChVacdRecCategories getRecCategory() {
		final Code code = this.getRecCategoryCode();
		if ((code != null) && CdaChVacdRecCategories.CODE_SYSTEM_OID.equals(code.getCodeSystem())) {
			return CdaChVacdRecCategories.getEnum(code.getCode());
		}
		return null;
	}

	/**
	 * Gets the rec category code.
	 *
	 * @return the rec category code
	 */
	public Code getRecCategoryCode() {
		if (getMdht().getCode() != null) {
			return new Code(getMdht().getCode());
		}
		return null;
	}

	/**
	 * Gets the text reference pointing to the narrative text in the section.
	 *
	 * @return the text reference
	 */
	@Override
	public String getTextReference() {
		if ((this.getMdht().getText() != null)
				&& (this.getMdht().getText().getReference() != null)) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ (this.getRecCategoryCode() != null ? this.getRecCategoryCode().hashCode() : 0);
		return result;
	}

	/**
	 * Sets the recommendation category.
	 *
	 * @param recCategory
	 *            the recommendation category
	 * @param languageCode
	 *            the language code
	 */
	public void setRecCategory(CdaChVacdRecCategories recCategory, LanguageCode languageCode) {
		if (recCategory != null) {
			this.setRecCategoryCode(recCategory.getCode(languageCode));
		} else {
			this.setRecCategoryCode((Code) null);
		}
	}

	/**
	 * Sets the recommendation code.
	 *
	 * @param code
	 *            the new recommendation category code
	 */
	public void setRecCategoryCode(Code code) {
		getMdht().setCode(code.getCD());
	}

	/**
	 * Sets the text reference.
	 *
	 * @param value
	 *            the new text reference, # for local reference has to be
	 *            included
	 */
	@Override
	public void setTextReference(String value) {
		this.getMdht().setText(Util.createReference(value));
	}

}
