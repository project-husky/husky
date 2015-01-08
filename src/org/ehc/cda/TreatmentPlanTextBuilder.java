package org.ehc.cda;

import java.util.List;

/**
 * Builds the <text> part of the Treatment plan section.
 * 
 * Always builds the whole part (not only adds one recommendation).
 * 
 * @author gsc
 */
public class TreatmentPlanTextBuilder extends TextBuilder {

	public TreatmentPlanTextBuilder(List<Immunization> getImmunizations) {
		super();
	}

	private void addHeader() {
		append("<thead>");
		append("<tr>");
		append("<th>Impfstoff Handelsname</th>");
		append("<th>Hersteller</th>");
		append("<th>Lot-Nr</th>");
		append("<th>Zeitraum</th>");
		append("<th>Impfung gegen</th>");
		append("<th>Impfempfehlung vom</th>");
		append("<th>Impfempfehlung durch</th>");
		append("</tr>");
		append("</thead>");
	}
	private void addBody() {
		append("<tbody>");
		append("<tr><td>");
		// TODO implement this !!
		append("</td></tr>");
		append("</tbody>");
	}
	
	/**
	 * Returns HTML formatted string.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		append("<table border='1' width='100%'>");
		addHeader();
		addBody();
		append("</table>");
		return super.toString();
	}
	
}
