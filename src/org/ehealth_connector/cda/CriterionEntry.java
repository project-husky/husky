/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda;

import org.ehealth_connector.cda.ch.enums.CdaChVacdRecCategories;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Util;
import org.openhealthtools.mdht.uml.cda.Criterion;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * CriterionEntry.
 */
public class CriterionEntry extends EFacade<org.openhealthtools.mdht.uml.cda.ch.CriterionEntry> {

	/**
	 * Instantiates a new criterion entry.
	 */
	public CriterionEntry() {
		super(CHFactory.eINSTANCE.createCriterionEntry().init());
		// cannot add it in the model because VACD has the same templateId
		this.getMdht().getTemplateIds().add(
				new Identificator("2.16.756.5.30.1.1.1.1.3.5.1", "CDA-CH.VACD.Body.MediL3.Category")
						.getIi());
	}

	/**
	 * Instantiates a new criterion entry.
	 */
	protected CriterionEntry(Criterion criterion) {
		super((org.openhealthtools.mdht.uml.cda.ch.CriterionEntry) criterion,
				"2.16.756.5.30.1.1.1.1.3.5.1", "CDA-CH.VACD.Body.MediL3.Category");
	}

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
		CriterionEntry other = (CriterionEntry) obj;

		Code code = getRecCategoryCode();
		if ((code != null && !code.equals(other.getRecCategoryCode()))
				|| (code == null && other.getRecCategoryCode() != null)) {
			return false;
		}

		return true;
	}

	/**
	 * Gets the rec category.
	 *
	 * @return the rec category
	 */
	public CdaChVacdRecCategories getRecCategory() {
		Code code = this.getRecCategoryCode();
		if (code != null && CdaChVacdRecCategories.CODE_SYSTEM_OID.equals(code.getCodeSystem())) {
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
	 * Gets the text reference.
	 *
	 * @return the text reference
	 */
	public String getTextReference() {
		if (this.getMdht().getText() != null && this.getMdht().getText().getReference() != null) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (this.getRecCategoryCode() != null ? this.getRecCategoryCode().hashCode() : 0);
		return result;
	}

	/**
	 * Sets the rec category.
	 *
	 * @param recCategory
	 *            the rec category
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
	 * Sets the rec category code.
	 *
	 * @param code
	 *            the new rec category code
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
	public void setTextReference(String value) {
		this.getMdht().setText(Util.createReference(value));
	}

}
