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
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * CriterionEntry.
 */
public class CriterionEntry extends EFacade<org.openhealthtools.mdht.uml.cda.ch.CriterionEntry> {

	/**
	 * Instantiates a new criterion entry.
	 */
	public CriterionEntry() {
		super(CHFactory.eINSTANCE.createCriterionEntry().init(), "2.16.756.5.30.1.1.1.1.3.5.1",
				"CDA-CH.VACD.Body.MediL3.Category");
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

}
