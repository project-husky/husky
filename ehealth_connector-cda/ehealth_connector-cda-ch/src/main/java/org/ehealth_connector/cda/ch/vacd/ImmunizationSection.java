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

package org.ehealth_connector.cda.ch.vacd;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.vacd.enums.CdaChVacdImmunizations;
import org.ehealth_connector.cda.ch.vacd.enums.CdaChVacdRecCategories;
import org.ehealth_connector.cda.ch.vacd.enums.SectionsVACD;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

/**
 * The Class ImmunizationSection provides the support for immunization section
 * for IHE Immunization Content (IC) profiles. E.g. CDA-CH-VACD 7.5.8.2
 */
public class ImmunizationSection extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ch.ImmunizationsSection> {

	// default language is German
	private LanguageCode languageCode = LanguageCode.GERMAN;

	/**
	 * Instantiates a new immunization section.
	 * 
	 * @param languageCode
	 *            the language code
	 */
	public ImmunizationSection(LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createImmunizationsSection().init(), null, null);
		this.languageCode = languageCode;
		this.getMdht().setTitle(
				Util.st(SectionsVACD.HISTORY_OF_IMMUNIZATION.getSectionTitle((languageCode != null ? languageCode.getCS() : null))));
	}

	/**
	 * Instantiates a new immunization section.
	 * 
	 * @param immunizationSection
	 *            the immunization section
	 */
	protected ImmunizationSection(org.openhealthtools.mdht.uml.cda.ch.ImmunizationsSection immunizationSection) {
		super(immunizationSection, null, null);
	}

	/**
	 * Adds the immunization to the section. If the text is created in the
	 * section based on the immunization object the level3 obects immunization,
	 * medicationTargetEntry, commentEntry and criterionEntry will be linked
	 * with a text reference (If the CommentEntry in immunization has a text it
	 * will be replaced by the reference)
	 * 
	 * @param immunization
	 *            the immunization
	 * @param createSectionText
	 *            if the section text should be created
	 */
	public void addImmunization(org.ehealth_connector.cda.ch.vacd.Immunization immunization, boolean createSectionText) {
		if (immunization != null) {
			getMdht().addSubstanceAdministration(immunization.getMdht());
		}
		if (createSectionText) {
			String text = null;
			if (this.getMdht().getText() != null) {
				text = Util.extractStringFromNonQuotedStrucDocText(getMdht().getText());
			}
			if ((text == null) || "".equals(text)) {
				text = this.getTable();
			}
			final String prefix = "is" + StringUtils.countMatches(text, "<tr>");
			final int pos = text.lastIndexOf("</tr>") + 5;
			final String row = this.getTableRow(immunization, prefix);
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
			return "<table><tbody><tr><th>Impfstoff Handelsname</th><th>Hersteller</th><th>Lot-Nr</th><th>Datum</th><th>Impfung gegen</th><th>Impfung erfolgt durch</th><th>Impfung dokumentiert durch</th><th>EKIF Empfehlungskategorie</th><th>Bemerkung</th></tr></tbody></table>";
		else
			return "<table><tbody><tr><th>" + languageCode.getCodeValue()
					+ " not yet implemented</th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th></tr></tbody></table>";
	}

	/**
	 * adds a section the table for an immunization.
	 * 
	 * @param immunization
	 *            the immunization
	 * @param contendIdPrefix
	 *            the contend id prefix
	 * @return the table row
	 */
	public String getTableRow(Immunization immunization, String contendIdPrefix) {
		final StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("<tr><td>");
		// Impfstoff Handelsname
		int colIndex = 0;

		String contentId = contendIdPrefix + colIndex++;
		stringBuffer.append("<content ID=\"" + contentId + "\">");
		if ((immunization.getConsumable() != null) && (immunization.getConsumable().getTradeName() != null)) {
			stringBuffer.append(immunization.getConsumable().getTradeName());
		}
		immunization.setTextReference("#" + contentId);

		stringBuffer.append("</content>");

		stringBuffer.append("</td><td>");
		// Hersteller
		if ((immunization.getConsumable() != null) && (immunization.getConsumable().getManufacturer() != null)
				&& (immunization.getConsumable().getManufacturer().getName() != null)) {
			stringBuffer.append(immunization.getConsumable().getManufacturer().getName());
		}
		stringBuffer.append("</td><td>");
		// Lot-Nr
		if ((immunization.getConsumable() != null) && (immunization.getConsumable().getManufacturer() != null)
				&& (immunization.getConsumable().getLotNr() != null)) {
			stringBuffer.append(immunization.getConsumable().getLotNr());
		}
		stringBuffer.append("</td><td>");
		// Datum
		if (immunization.getApplyDate() != null) {
			stringBuffer.append(DateUtil.formatDateCH(immunization.getApplyDate()));
		}
		stringBuffer.append("</td><td>");
		// Impfung gegen
		final List<MedicationTargetEntry> medicationTargetEntries = immunization.getMedicationTargetEntries();
		if (medicationTargetEntries != null) {
			int i = 0;

			// Sort List according to
			Collections.sort(medicationTargetEntries);

			for (final MedicationTargetEntry medicationTargetEntry : medicationTargetEntries) {
				final CdaChVacdImmunizations vacdImmun = medicationTargetEntry.getImmunizationTarget();
				if (vacdImmun != null) {
					if (i > 0) {
						stringBuffer.append(", ");
					}
					++i;
					contentId = contendIdPrefix + colIndex++;
					stringBuffer.append("<content ID=\"" + contentId + "\">");
					stringBuffer.append(medicationTargetEntry.getImmunizationTargetCode().getDisplayName());
					stringBuffer.append("</content>");
					medicationTargetEntry.setTextReference("#" + contentId);
				}
			}
		}
		stringBuffer.append("</td><td>");
		// Impfung erfolgt durch
		if ((immunization.getPerformer() != null) && (immunization.getPerformer().getName() != null)) {
			stringBuffer.append(immunization.getPerformer().getName().getCompleteName());
		}
		stringBuffer.append("</td><td>");
		// Impfung dokumentiert durch
		if ((immunization.getAuthor() != null) && (immunization.getAuthor().getName() != null)) {
			stringBuffer.append(immunization.getAuthor().getName().getCompleteName());
		}
		stringBuffer.append("</td><td>");
		// EKIF Empfehlungskategorie
		if ((immunization.getCriterionEntry() != null) && (immunization.getCriterionEntry().getRecCategory() != null)) {
			final CdaChVacdRecCategories recCategory = immunization.getCriterionEntry().getRecCategory();
			contentId = contendIdPrefix + colIndex++;
			stringBuffer.append("<content ID=\"" + contentId + "\">");
			stringBuffer.append(recCategory.getCode(languageCode).getDisplayName());
			stringBuffer.append("</content>");
			immunization.getCriterionEntry().setTextReference("#" + contentId);
		}
		stringBuffer.append("</td><td>");
		if (immunization.getCommentEntry() != null) {
			final SectionAnnotationCommentEntry commentEntry = immunization.getCommentEntry();
			contentId = contendIdPrefix + colIndex++;
			stringBuffer.append("<content ID=\"" + contentId + "\">");
			stringBuffer.append(commentEntry.getAnnotationCommentText());
			stringBuffer.append("</content>");
			commentEntry.setContentIdReference("#" + contentId);
		}
		// Bemerkung
		stringBuffer.append("</td></tr>");
		return stringBuffer.toString();
	}

}
