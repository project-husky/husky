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

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.ehealth_connector.cda.ExternalDocumentEntry;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.vacd.enums.CdaChVacdImmunizations;
import org.ehealth_connector.cda.ch.vacd.enums.CdaChVacdRecCategories;
import org.ehealth_connector.cda.ch.vacd.enums.SectionsVACD;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * The Class ImmunizationRecommendationSection provides the support for
 * immunization recommendation section for IHE Immunization Content (IC)
 * profiles. E.g. CDA-CH-VACD 7.5.8.2
 */
public class ImmunizationRecommendationSection
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendationSection> {

	// default language is German
	private LanguageCode languageCode = LanguageCode.GERMAN;

	/**
	 * Instantiates a new immunization section.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public ImmunizationRecommendationSection(LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createImmunizationRecommendationSection().init(), null, null);
		this.languageCode = languageCode;
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
	 * Adds the immunization recommendation to the section. If the text is
	 * created in the section based on the immunizationRecommendation object the
	 * level3 obects immunizationRecommendation, medicationTargetEntry,
	 * SectionAnnotationCommentEntry and criterionEntry will be linked with a
	 * text reference (If the SectionAnnotationCommentEntry in
	 * immunizationRecommendation has a text it will be replaced by the
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
			org.ehealth_connector.cda.ch.vacd.ImmunizationRecommendation immunizationRecommendation,
			LanguageCode languageCode, boolean createSectionText) {
		if (immunizationRecommendation != null) {
			getMdht().addSubstanceAdministration(immunizationRecommendation.getMdht());
		}
		if (createSectionText) {
			String text = null;
			if (this.getMdht().getText() != null) {
				text = Util.extractStringFromNonQuotedStrucDocText(getMdht().getText());
			}
			if ((text == null) || "".equals(text)) {
				text = this.getTable();
			}
			final String prefix = "irs" + StringUtils.countMatches(text, "<tr>");
			final int pos = text.lastIndexOf("</tr>") + 5;
			final String row = this.getTableRow(languageCode, immunizationRecommendation, prefix);
			final String newText = text.substring(0, pos) + row + text.substring(pos);
			getMdht().createStrucDocText(newText);
		}
	}

	/**
	 * Gets the default section table.
	 *
	 * @return the table
	 */
	public String getTable() {
		if (languageCode == LanguageCode.GERMAN)
			return "<table><tbody><tr><th>Impfstoff Handelsname</th><th>Hersteller</th><th>Zeitraum</th><th>Impfung gegen</th><th>Impfempfehlung vom</th><th>Impfempfehlung durch</th><th>EKIF Empfehlungskategorie</th><th>Kommentar</th><th>Referenz</th></tr></tbody></table>";
		else
			return "<table><tbody><tr><th>" + languageCode.getCodeValue()
					+ " not yet implemented</th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th></tr></tbody></table>";
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

		final StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("<tr><td>");
		// <th>Impfstoff Handelsname</th>
		int colIndex = 0;

		String contentId = contendIdPrefix + colIndex++;
		stringBuffer.append("<content ID=\"" + contentId + "\">");
		if ((immunizationRecommendation.getConsumable() != null)
				&& (immunizationRecommendation.getConsumable().getTradeName() != null)) {
			stringBuffer.append(immunizationRecommendation.getConsumable().getTradeName());
		}
		immunizationRecommendation.setTextReference("#" + contentId);

		stringBuffer.append("</content>");

		stringBuffer.append("</td><td>");
		// <th>Hersteller</th>
		if ((immunizationRecommendation.getConsumable() != null)
				&& (immunizationRecommendation.getConsumable().getManufacturer() != null)
				&& (immunizationRecommendation.getConsumable().getManufacturer()
						.getName() != null)) {
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
		final List<MedicationTargetEntry> medicationTargetEntries = immunizationRecommendation
				.getMedicationTargetEntries();
		if (medicationTargetEntries != null) {
			int i = 0;
			// Sort List according to
			Collections.sort(medicationTargetEntries);
			for (final MedicationTargetEntry medicationTargetEntry : medicationTargetEntries) {
				final CdaChVacdImmunizations vacdImmun = medicationTargetEntry
						.getImmunizationTarget();
				if (vacdImmun != null) {
					if (i > 0) {
						stringBuffer.append(", ");
					}
					++i;
					contentId = contendIdPrefix + colIndex++;
					stringBuffer.append("<content ID=\"" + contentId + "\">");
					// TODO This is draft implementation only! the text needs to
					// be
					// translated by the real code. Displaynames should never be
					// used!
					stringBuffer.append(
							medicationTargetEntry.getImmunizationTargetCode().getDisplayName());
					stringBuffer.append("</content>");
					medicationTargetEntry.setTextReference("#" + contentId);
				}
			}
		}
		stringBuffer.append("</td><td>");
		// Impfempfehlung vom
		if ((immunizationRecommendation.getAuthor() != null)
				&& (immunizationRecommendation.getAuthor().getTimeAsDate() != null)) {
			stringBuffer.append(
					DateUtil.formatDateCH(immunizationRecommendation.getAuthor().getTimeAsDate()));
		}
		stringBuffer.append("</td><td>");
		// Impfempfehlung dokumentiert durch
		if ((immunizationRecommendation.getAuthor() != null)
				&& (immunizationRecommendation.getAuthor().getName() != null)) {
			stringBuffer.append(immunizationRecommendation.getAuthor().getName().getCompleteName());
		}
		stringBuffer.append("</td><td>");
		// EKIF Empfehlungskategorie
		if ((immunizationRecommendation.getCriterionEntry() != null)
				&& (immunizationRecommendation.getCriterionEntry().getRecCategory() != null)) {
			final CdaChVacdRecCategories recCategory = immunizationRecommendation
					.getCriterionEntry().getRecCategory();
			contentId = contendIdPrefix + colIndex++;
			stringBuffer.append("<content ID=\"" + contentId + "\">");
			// TODO This is draft implementation only! the text needs to be
			// translated by the real code. Displaynames should never be
			// used!
			stringBuffer.append(recCategory.getCode(languageCode).getDisplayName());
			stringBuffer.append("</content>");
			immunizationRecommendation.getCriterionEntry().setTextReference("#" + contentId);
		}
		// <th>Kommentar</th>
		stringBuffer.append("</td><td>");
		if (immunizationRecommendation.getCommentEntry() != null) {
			final SectionAnnotationCommentEntry commentEntry = immunizationRecommendation
					.getCommentEntry();
			contentId = contendIdPrefix + colIndex++;
			stringBuffer.append("<content ID=\"" + contentId + "\">");
			stringBuffer.append(commentEntry.getAnnotationCommentText());
			stringBuffer.append("</content>");
			commentEntry.setContentIdReference("#" + contentId);
		}
		stringBuffer.append("</td><td>");
		// <th>Referenz</th>
		if (immunizationRecommendation.getExternalDocumentEntry() != null) {
			final ExternalDocumentEntry documentEntry = immunizationRecommendation
					.getExternalDocumentEntry();
			stringBuffer.append("<linkHtml href=\"" + documentEntry.getReferenceUrl() + "\">"
					+ documentEntry.getReferenceNarrativeText() + "</linkHtml>");
		}
		stringBuffer.append("</td></tr>");
		return stringBuffer.toString();
	}
}
