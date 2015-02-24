package org.ehealth_connector.cda.ch.textbuilder;

/**
 * Common code for all text builder classes.
 * 
 * @author gsc
 */
abstract class TextBuilder {

	private StringBuffer buffer = new StringBuffer();

	protected final static String tableFooter = "</tbody></table>";

	TextBuilder() {
	}

	protected void addCell(String text) {
		append("<td>");
		append(text);
		append("</td>");
	}

	protected void addCellWithContent(String text, String prefix, int i) {
		append("<td>");
		addContent(text, prefix, i);
		append("</td>");
	}

	protected void addContent(String text, String prefix, int i) {
		append("<content ID='"+prefix + i + "'>");
		append(text);
		append("</content>");
	}

	// old
	protected void append(String text) {
		buffer.append(text);
	}

	protected String buildCell(String text) {
		return ("<td>" + text + "</td>");
	}

	protected String buildCellWithContent(String text, int i, String prefix) {
		return ("<td><content ID=\"" + prefix + i + "\">" + text + "</content></td>");
	}

	@Override
	public String toString() {
		return buffer.toString();
	}

	// public void build(String[] tableHeader, String[][] tableBody,
	// Boolean referenceBodyCell[]) {
	// this.tableHeader = tableHeader;
	// this.tableBody = tableBody;
	//
	// // Generate Table
	// append("<table border='1' width='100%'>");
	// // Table Header
	// append("<thead>");
	// append("<tr>");
	// for (String headerCell : tableHeader) {
	// append("<th>");
	// append(headerCell);
	// append("</th>");
	// }
	// append("</tr>");
	// append("</thead>");
	// // Table Body
	// int cellCounter = 0;
	// int idCounter = 0;
	// // Algorithm for the generation of body Cells.
	// // If the corresponding element in the referenceBodyCell array is true,
	// // a new (successive) content id for this cell will be generated.
	// for (String[] bodyRow : tableBody) {
	// cellCounter = 0;
	// append("<tr>");
	// for (String bodyCell : bodyRow) {
	// if (referenceBodyCell[cellCounter]) {
	// append("<td><content ID=\"" + String.valueOf(idCounter)
	// + "\">");
	// append(bodyCell);
	// append("</content></td>");
	// idCounter++;
	// } else {
	// append("<td>");
	// append(bodyCell);
	// append("</td>");
	// }
	// cellCounter++;
	// }
	// append("</tr>");
	// }
	// append("</table>");
	// }
}
