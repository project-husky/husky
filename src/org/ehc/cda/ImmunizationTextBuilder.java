package org.ehc.cda;

import java.util.List;
import org.ehc.general.DateUtil;

/**
 * Builds the <text> part of the History of immunzations.
 * 
 * Always builds the whole part (not only adds one immunization).
 * 
 * @author gsc
 */
public class ImmunizationTextBuilder extends TextBuilder {

	private List<Immunization> immunizations;
	
	/**
	 * Constructor.
	 * 
	 * @param immunizations
	 */
	public ImmunizationTextBuilder(List<Immunization> immunizations) {
		this.immunizations = immunizations;
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
		append("</tr>");
		append("</thead>");
	}

	private void addRow(Immunization immunization, int i) {
		append("<tr>");
		addCellWithContent(immunization.getVaccineName(), i);
		addCell("");
		addCell("");
		addCell(DateUtil.formatDateCH(immunization.getEffectiveTime()));
		addCell(""); // gegen
		addCell(immunization.getAuthor().getCompleteName());
		addCell("");
		append("</tr>");
	}
	
	private void addCell(String text) {
		append("<td>");
		append(text);
		append("</td>");
	}
	
	private void addCellWithContent(String text, int i) {
		append("<td>");
		addContent(text, i);
		append("</td>");
	}

	private void addContent(String text, int i) {
		append("<content ID='i" + i + "'>");
		append(text);
		append("</content>");
	}	
}
