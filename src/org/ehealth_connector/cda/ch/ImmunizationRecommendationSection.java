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

package org.ehealth_connector.cda.ch;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.ehealth_connector.cda.ch.enums.CdaChVacdImmunizations;
import org.ehealth_connector.cda.ch.enums.CdaChVacdRecCategories;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.ehealth_connector.cda.ch.enums.SectionsVACD;
import org.ehealth_connector.util.Util;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * The Class ImmunizationRecommendationSection provides the support for
 * immunizaition recommondation section see CDA-CH-VACD 7.5.8.2 Spezifikation
 * CDA Body Level 1.
 */
public class ImmunizationRecommendationSection
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendationSection> {

	/**
	 * Instantiates a new immunization section.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public ImmunizationRecommendationSection(LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createImmunizationRecommendationSection().init(), null, null);
		this.getMdht().setTitle(
				Util.st(SectionsVACD.TREATMENT_PLAN.getSectionTitle(languageCode.getCS())));
	}

	/**
	 * Instantiates a new immunization section.
	 *
	 * @param ImmunizationRecommendation
	 *            the immunization section
	 */
	protected ImmunizationRecommendationSection(
			org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendationSection ImmunizationRecommendation) {
		super(ImmunizationRecommendation, null, null);
	}

	/**
	 * Adds the immunizationRecommendation. If the text is created in the
	 * section based on the immunizationRecommendation object the level3 obects
	 * immunizationRecommendation, medicationTargetEntry, commentEntry and
	 * criterionEntry will be linked with a text reference (If the CommentEntry
	 * in immunizationRecommendation has a text it will be replaced by the
	 * reference)
	 * 
	 * @param immunizationRecommendation
	 *            the immunizationRecommendation
	 * @param languageCode
	 *            the language code
	 * @param createSectionText
	 *            if the section text should be created
	 */
	public void addImmunizationRecommendation(
			org.ehealth_connector.cda.ch.ImmunizationRecommendation immunizationRecommendation,
			LanguageCode languageCode, boolean createSectionText) {
		if (immunizationRecommendation != null) {
			getMdht().addSubstanceAdministration(immunizationRecommendation.getMdht());
		}
		if (createSectionText) {
			String text = null;
			if (this.getMdht().getText() != null) {
				text = Util.extractStringFromNonQuotedStrucDocText(getMdht().getText());
			}
			if (text == null || "".equals(text)) {
				text = this.getTable();
			}
			String prefix = "irs" + StringUtils.countMatches(text, "<tr>");
			int pos = text.lastIndexOf("</tr>") + 5;
			String row = this.getTableRow(languageCode, immunizationRecommendation, prefix);
			String newText = text.substring(0, pos) + row + text.substring(pos);
			getMdht().createStrucDocText(newText);
		}
	}

	/**
	 * Gets the default section table.
	 *
	 * @return the table
	 */
	public String getTable() {
		return "<table><tbody><tr><th>Impfstoff Handelsname</th><th>Hersteller</th><th>Zeitraum</th><th>Impfung gegen</th><th>Impfempfehlung vom</th><th>Impfempfehlung durch</th><th>EKIF Empfehlungskategorie</th><th>Kommentar</th><th>Referenz</th></tr></tbody></table>";
	}

	/**
	 * adds a section the table for an immunizationRecommendation.
	 *
	 * @param languageCode
	 *            the language code
	 * @param immunizationRecommendation
	 *            the immunizationRecommendation
	 * @param contendIdPrefix
	 *            the contend id prefix
	 * @return the table row
	 */
	public String getTableRow(LanguageCode languageCode,
			ImmunizationRecommendation immunizationRecommendation, String contendIdPrefix) {

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("<tr><td>");
		// <th>Impfstoff Handelsname</th>
		int colIndex = 0;

		String contentId = contendIdPrefix + colIndex++;
		stringBuffer.append("<content ID=\"" + contentId + "\">");
		if (immunizationRecommendation.getConsumable() != null
				&& immunizationRecommendation.getConsumable().getTradeName() != null) {
			stringBuffer.append(immunizationRecommendation.getConsumable().getTradeName());
		}
		immunizationRecommendation.setTextReference("#" + contentId);

		stringBuffer.append("</content>");

		stringBuffer.append("</td><td>");
		// <th>Hersteller</th>
		if (immunizationRecommendation.getConsumable() != null
				&& immunizationRecommendation.getConsumable().getManufacturer() != null
				&& immunizationRecommendation.getConsumable().getManufacturer().getName() != null) {
			stringBuffer
					.append(immunizationRecommendation.getConsumable().getManufacturer().getName());
		}
		stringBuffer.append("</td><td>");
		// <th>Zeitraum</th>
		if (immunizationRecommendation.getPossibleApplianceString() != null) {
			stringBuffer.append(immunizationRecommendation.getPossibleApplianceString());
		}
		stringBuffer.append("</td><td>");
		// <th>Impfung gegen</th>
		List<MedicationTargetEntry> medicationTargetEntries = immunizationRecommendation
				.getMedicationTargetEntries();
		if (medicationTargetEntries != null) {
			int i = 0;
			// Sort List according to
			Collections.sort(medicationTargetEntries);
			for (MedicationTargetEntry medicationTargetEntry : medicationTargetEntries) {
				CdaChVacdImmunizations vacdImmun = medicationTargetEntry.getImmunizationTarget();
				if (vacdImmun != null) {
					if (i > 0) {
						stringBuffer.append(",");
					}
					++i;
					contentId = contendIdPrefix + colIndex++;
					stringBuffer.append("<content ID=\"" + contentId + "\">");
					stringBuffer.append(vacdImmun.getDisplayName());
					stringBuffer.append("</content>");
					medicationTargetEntry.setTextReference("#" + contentId);
				}
			}
		}
		stringBuffer.append("</td><td>");
		stringBuffer.append("</td><td>");
		// Impfempfehlung dokumentiert durch
		if (immunizationRecommendation.getAuthor() != null
				&& immunizationRecommendation.getAuthor().getName() != null) {
			stringBuffer.append(immunizationRecommendation.getAuthor().getName().getCompleteName());
		}
		stringBuffer.append("</td><td>");
		// EKIF Empfehlungskategorie
		if (immunizationRecommendation.getCriterionEntry() != null
				&& immunizationRecommendation.getCriterionEntry().getRecCategory() != null) {
			CdaChVacdRecCategories recCategory = immunizationRecommendation.getCriterionEntry()
					.getRecCategory();
			contentId = contendIdPrefix + colIndex++;
			stringBuffer.append("<content ID=\"" + contentId + "\">");
			stringBuffer.append(recCategory.getCode(languageCode).getDisplayName());
			stringBuffer.append("</content>");
			immunizationRecommendation.getCriterionEntry().setTextReference("#" + contentId);
		}
		// <th>Kommentar</th>
		stringBuffer.append("</td><td>");
		if (immunizationRecommendation.getCommentEntry() != null) {
			SectionAnnotationCommentEntry commentEntry = immunizationRecommendation.getCommentEntry();
			contentId = contendIdPrefix + colIndex++;
			stringBuffer.append("<content ID=\"" + contentId + "\">");
			stringBuffer.append(commentEntry.getAnnotationCommentText());
			stringBuffer.append("</content>");
			commentEntry.setContentIdReference("#" + contentId);
		}
		stringBuffer.append("</td><td>");
		// <th>Referenz</th>
		if (immunizationRecommendation.getExternalDocumentEntry() != null) {
			ExternalDocumentEntry documentEntry = immunizationRecommendation
					.getExternalDocumentEntry();
			stringBuffer.append("<linkHtml href=\"" + documentEntry.getTextReference() + "\"/>");
		}
		stringBuffer.append("</td></tr>");
		return stringBuffer.toString();
	}

}
