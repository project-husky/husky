package org.ehc.cda;

import java.util.ArrayList;

import org.ehc.common.ch.SectionsVACD;

/**
 * Builds the <text> part of the Immunization recommendations.
 * 
 * Always builds the whole part (not only adds one immunization recommendation).
 * 
 * @author Axel Helmer
 */
public class LaboratoryObservationTextBuilder extends TextBuilder {

	private ArrayList<org.ehc.cda.LaboratoryObservation> laboratoryObservation;
	private String contentIdPrefix;

	/**
	 * Constructor.
	 * 
	 * @param pastProblemConcerns
	 */
	public LaboratoryObservationTextBuilder(ArrayList<LaboratoryObservation> list, SectionsVACD section) {
		laboratoryObservation = list;
		contentIdPrefix = section.getContentIdPrefix();
	}

	private void addBody() {
		append("<tbody>");
		int i = 1;
		for (org.ehc.cda.LaboratoryObservation problemConcern : laboratoryObservation) {
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
		addCell(laboratoryObservation.getCode().getDisplayName());
		if (laboratoryObservation.getImmuneProtection()) {
			addCell("Positiv");
		}
		else {
			addCell("Negativ");
		}
		addCell("");
		addCell(laboratoryObservation.getCode().getCode());
		addCell(laboratoryObservation.getCode().getOid());
		addCell("");
		append("</tr>");
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
