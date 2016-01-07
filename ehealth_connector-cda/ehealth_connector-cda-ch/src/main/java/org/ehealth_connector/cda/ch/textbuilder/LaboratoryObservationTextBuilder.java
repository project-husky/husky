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

import org.ehealth_connector.cda.ch.vacd.LaboratoryObservation;
import org.ehealth_connector.cda.ch.vacd.enums.SectionsVACD;
import org.ehealth_connector.cda.textbuilder.TextBuilder;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;

/**
 * Builds the &lt;text&gt; part of the Immunization recommendations.
 * 
 * Always builds the whole part (not only adds one immunization recommendation).
 * 
 */
public class LaboratoryObservationTextBuilder extends TextBuilder {

	private List<org.ehealth_connector.cda.ch.vacd.LaboratoryObservation> laboratoryObservation;

	/**
	 * Constructor.
	 * 
	 * @param list
	 *            a list of laboratory observations
	 * @param section
	 *            the section
	 */
	public LaboratoryObservationTextBuilder(List<org.ehealth_connector.cda.ch.vacd.LaboratoryObservation> list, SectionsVACD section) {
		laboratoryObservation = list;
		section.getContentIdPrefix();
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
		for (final org.ehealth_connector.cda.ch.vacd.LaboratoryObservation problemConcern : laboratoryObservation) {
			addRow(problemConcern, i++);
		}
		append("</tbody>");
	}

	private void addHeader() {
		append("<thead>");
		append("<tr>");
		append("<th>Beobachtung</th>");
		append("<th>Erregernachweis</th>");
		append("<th>Resultat</th>");
		append("<th>Code</th>");
		append("<th>Codesystem</th>");
		append("<th>Kommentar</th>");
		append("</tr>");
		append("</thead>");
	}

	private void addRow(LaboratoryObservation laboratoryObservation, int i) {
		append("<tr>");
		// Beobachtung
		if (laboratoryObservation.getCode() != null) {
			if (laboratoryObservation.getCode().getDisplayName() != null) {
				addCell(laboratoryObservation.getCode().getDisplayName());
			} else {
				addCell("");
			}
		} else {
			addCell("");
		}

		// Resultat
		addCell("");

		// Code & CodeSystem
		if (laboratoryObservation.getCode() != null) {
			if (laboratoryObservation.getCode().getCode() != null) {
				addCell(laboratoryObservation.getCode().getCode());
			} else {
				addCell("");
			}
			if (laboratoryObservation.getCode().getCodeSystem() != null) {
				addCell(laboratoryObservation.getCode().getCodeSystem());
			} else {
				addCell("");
			}

		} else {
			addCell("");
		}

		// Kommentar
		String cellStr = "<td>";
		int k = 0;
		boolean minOneComment = false;
		for (final EntryRelationship er : laboratoryObservation.getMdhtLaboratoryObservation().getEntryRelationships()) {
			if (Util.isComment(er)) {
				k++;
				minOneComment = true;
				cellStr = cellStr + ("<content ID='" + SectionsVACD.SEROLOGY_STUDIES.getContentIdPrefix() + "-comment" + String.valueOf(i)
						+ String.valueOf(1) + String.valueOf(k) + "'>");
				cellStr = cellStr + (laboratoryObservation.getCommentText());
				cellStr = cellStr + ("</content>");
			}
		}
		if (minOneComment) {
			cellStr = cellStr + "</td>";
			append(cellStr);
		}
		append("</tr>");
	}
}
