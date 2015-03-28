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

import org.ehealth_connector.cda.ImmunizationRecommendation;
import org.ehealth_connector.cda.ch.enums.SectionsVACD;
import org.ehealth_connector.common.Util;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;

/**
 * Builds the <text> part of the Immunization recommendations.
 * 
 * Always builds the whole part (not only adds one immunization recommendation).
 * 
 */
public class ImmunizationRecommendationTextBuilder extends TextBuilder {

	private List<ImmunizationRecommendation> immunizations;

	/**
	 * Constructor.
	 * 
	 * @param immunizations
	 */
	public ImmunizationRecommendationTextBuilder(
			List<ImmunizationRecommendation> immunizations) {
		this.immunizations = immunizations;
	}

	private void addBody() {
		append("<tbody>");
		int i = 1;
		for (ImmunizationRecommendation immunization : immunizations) {
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
		append("</tr>");
		append("</thead>");
	}

	private void addRow(ImmunizationRecommendation immunization, int i) {
		append("<tr>");
		addCellWithContent(immunization.getConsumable().getTradeName(),
				SectionsVACD.TREATMENT_PLAN.getContentIdPrefix(), i);
		addCell("");
		addCell("");
		if (immunization.getPossibleAppliance() != null) {
			addCell(immunization.getPossibleAppliance());
		} else {
			addCell("");
		}
		addCell(""); // gegen
		if (immunization.getAuthor() != null) {
			addCell(immunization.getAuthor().getCompleteName());
		} else {
			addCell("");
		}
		addCell("");
		append("</tr>");
	}

	public List<ImmunizationRecommendation> getUpdatedImmunizations() {
		int i = 0;
		for (ImmunizationRecommendation immunization : immunizations) {
			ED reference = Util.createReference(i,
					SectionsVACD.TREATMENT_PLAN.getContentIdPrefix());
			SubstanceAdministration substanceAdminstration = immunization
					.copyMdhtImmunizationRecommendation();
			substanceAdminstration.setText(reference);
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
}
