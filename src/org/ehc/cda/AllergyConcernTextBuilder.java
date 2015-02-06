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
public class AllergyConcernTextBuilder extends TextBuilder {

	private ArrayList<org.ehc.cda.AllergyConcern> problemConcerns;
	private String contentIdPrefix;

	/**
	 * Constructor.
	 * 
	 * @param pastProblemConcerns
	 */
	public AllergyConcernTextBuilder(ArrayList<org.ehc.cda.AllergyConcern> problemConcerns, SectionsVACD section) {
		this.problemConcerns = problemConcerns;
		contentIdPrefix = section.getContentIdPrefix();
	}

	private void addBody() {
		append("<tbody>");
		int i = 1;
		for (org.ehc.cda.AllergyConcern problemConcern : problemConcerns) {
			addRow(problemConcern, i++);
		}
		append("</tbody>");
	}

	private void addHeader() {
		append("<thead>");
		append("<tr>");
		append("<th>Risikokategorie</th>");
		append("<th>Risikofaktor</th>");
		append("</tr>");
		append("</thead>");
	}

	private void addRow(AllergyConcern allergyConcern, int i) {
		append("<tr>");
		addCell("Komplikationsrisiko");
		addCellWithContent(allergyConcern.getConcern(), contentIdPrefix , i);
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
