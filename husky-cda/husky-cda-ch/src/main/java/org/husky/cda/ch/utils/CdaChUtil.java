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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.husky.cda.ch.utils;

import org.husky.cda.ch.emed.EmedChStrucDocTextBuilderV097;
import org.husky.cda.ch.emed.v097.DispenseSectionContentModule;
import org.husky.cda.ch.emed.v097.MedicationTreatmenPlanSectionContentModule;
import org.husky.cda.ch.emed.v097.PharmaceuticalAdviceSectionContentModule;
import org.husky.cda.ch.emed.v097.PrescriptionSectionContentModule;
import org.husky.cda.utils.CdaUtil;
import org.husky.cda.utils.CdaUtilMdht;
import org.husky.common.enums.LanguageCode;
import org.husky.common.hl7cdar2.POCDMT000040Section;
import org.husky.common.hl7cdar2.POCDMT000040StructuredBody;
import org.husky.common.hl7cdar2.StrucDocText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <div class="en">A util class with helper functions.</div>
 * <div class="de">Eine Klasse mit Hilfsfunktionen.</div>
 */
public abstract class CdaChUtil extends CdaUtilMdht {

	/** The SLF4J logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(CdaChUtil.class);

	/** The Constant DIS_SECTION_CODE. */
	public static final String DIS_SECTION_CODE = new DispenseSectionContentModule().getCode()
			.getCode();

	/** The Constant MTP_SECTION_CODE. */
	public static final String MTP_SECTION_CODE = new MedicationTreatmenPlanSectionContentModule()
			.getCode().getCode();

	/** The Constant PADV_SECTION_CODE. */
	public static final String PADV_SECTION_CODE = new PharmaceuticalAdviceSectionContentModule()
			.getCode().getCode();

	/** The Constant PRE_SECTION_CODE. */
	public static final String PRE_SECTION_CODE = new PrescriptionSectionContentModule().getCode()
			.getCode();

	/** The Constant PML_SECTION_CODE. *
	public final static String PML_SECTION_CODE = new MedicationListSectionContentModule().getCode()
			.getCode();*/

	/** The Constant PMLC_SECTION_CODE. */
	public static final String PMLC_SECTION_CODE = "10160-0";
			//new MedicationCardSectionContentModule().getCode().getCode();

	/**
	 * <div class="en">Generate text narrative to the given section.</div>
	 *
	 * <div class="de">Setzt den angegebenen Text im angegebenen
	 * Abschnitt.</div>
	 * <p>
	 * Sets the section text.
	 *
	 * @param structuredBody
	 *            the structured body
	 * @param section
	 *            the section
	 * @param languageCode
	 *            the language code
	 * @param contentIdCounter
	 *            the content id counter
	 */
	public static void setSectionTextGenerated(POCDMT000040StructuredBody structuredBody,
			POCDMT000040Section section, LanguageCode languageCode, int contentIdCounter) {

		String temp = "section"
				+ ("000" + Integer.toString(CdaUtil.getSectionCount(structuredBody) + 1)).substring(
						Integer.toString(CdaUtil.getSectionCount(structuredBody) + 1).length())
				+ contentIdCounter;
		String sectionCode = section.getCode().getCode();
		StrucDocText strucDocText = null;

		// CDA-CH-EMED
		if (sectionCode.contentEquals(MTP_SECTION_CODE)
				|| sectionCode.contentEquals(PRE_SECTION_CODE)
				|| sectionCode.contentEquals(PADV_SECTION_CODE)
				|| sectionCode.contentEquals(DIS_SECTION_CODE)
				|| sectionCode.contentEquals(PMLC_SECTION_CODE)) {
			try {
				strucDocText = new EmedChStrucDocTextBuilderV097(section, languageCode, temp);
			} catch (Exception e) {
				// if an exception is catched it means that the document was
				// malformated -> narrative text is not generated
				LOG.error(e.getMessage(), e);
			}
		}

		if (strucDocText != null) {
			section.setText(strucDocText);
		} else {
			section.setText(CdaUtil.createHl7CdaR2StrucDocText(temp, languageCode,
					"narrative text not available"));
		}

	}

}
