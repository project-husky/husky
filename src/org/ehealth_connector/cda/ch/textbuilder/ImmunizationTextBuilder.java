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

package org.ehealth_connector.cda.ch.textbuilder;

import java.util.List;

import org.ehealth_connector.cda.Immunization;
import org.ehealth_connector.cda.ch.enums.SectionsVACD;
import org.ehealth_connector.common.DateUtil;

/**
 * Builds the &lt;text&gt; part of the History of immunzations.
 * 
 * Always builds the whole part (not only adds one immunization).
 * 
 */
public class ImmunizationTextBuilder extends TextBuilder {

	private List<Immunization> immunizations;

	/**
	 * Constructor.
	 * 
	 * @param immunizations
	 *            the immunizations
	 */
	public ImmunizationTextBuilder(List<Immunization> immunizations) {
		this.immunizations = immunizations;
	}

	public List<Immunization> getUpdatedImmunizations() {
		int i = 0;
		for (Immunization immunization : immunizations) {
			immunization.createReference(i,
					SectionsVACD.HISTORY_OF_IMMUNIZATION.getContentIdPrefix());
			i++;
		}
		return immunizations;
	}

	/**
	 * Returns HTML formatted string.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		append("<table border='1' width='100%'>");
		addHeader();
		addBody();
		append("</table>");
		return super.toString();
	}

	private void addBody() {
		append("<tbody>");
		int i = 1;
		for (Immunization immunization : immunizations) {
			addRow(immunization, i++);
		}
		append("</tbody>");
	}

	private void addHeader() {
		append("<thead>");
		append("<tr>");
		append("<th>Impfstoff Handelsname</th>");
		append("<th>Hersteller</th>");
		append("<th>Lot-Nr</th>");
		append("<th>Datum</th>");
		append("<th>Impfung gegen</th>");
		append("<th>Impfung erfolgt durch</th>");
		append("<th>Impfung dokumentiert durch</th>");
		append("<th>Kommentar</th>");
		append("</tr>");
		append("</thead>");
	}

	private void addRow(Immunization immunization, int i) {
		append("<tr>");
		if (immunization.getConsumable() != null
				&& immunization.getConsumable().getTradeName() != null) {
			addCellWithContent(immunization.getConsumable().getTradeName(),
					SectionsVACD.HISTORY_OF_IMMUNIZATION.getContentIdPrefix(), i);
		} else {
			addCell("");
		}
		addCell("");
		addCell("");
		if (immunization.getApplyDate() != null) {
			addCell(DateUtil.formatDateCH(immunization.getApplyDate()));
		} else {
			addCell("");
		}
		addCell(""); // gegen
		if (immunization.getAuthor() != null) {
			addCell(immunization.getAuthor().getCompleteName());
		} else {
			addCell("");
		}
		if (immunization.getCommentText() != null) {
			addCellWithContent(immunization.getCommentText(),
					SectionsVACD.HISTORY_OF_IMMUNIZATION.getContentIdPrefix() + "-comment", i);
		}
		addCell("");
		append("</tr>");
	}
}
