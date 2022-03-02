/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.narrative;

import java.util.List;

import org.husky.cda.elga.models.lab.LaboratoryReportData;

public class SpecialityTextBuilder {

	private List<LaboratoryReportData> labData;

	/**
	 * Constructor.
	 *
	 * @param labData a list of laboratory data
	 */
	public SpecialityTextBuilder(List<LaboratoryReportData> labData) {
		this.labData = labData;
	}

	/*
	 * private void addHeaderResults() { append("<thead>"); append("<tr>");
	 * addHeaderCell("Analyse", "xELGA_colw:15"); addHeaderCell("Ergebnis",
	 * "xELGA_colw:10"); addHeaderCell("Einheit", "xELGA_colw:14");
	 * addHeaderCell("Referenzbereiche", "xELGA_colw:17");
	 * addHeaderCell("Interpretation", "xELGA_colw:10");
	 * addHeaderCell("Externes Labor", "xELGA_colw:25"); append("</tr>");
	 * append("</thead>"); }
	 * 
	 * private void addHeaderCultureGermDetection() { append("<thead>");
	 * append("<tr>"); addHeaderCell("Erreger", "xELGA_colw:15");
	 * addHeaderCell("Methode", "xELGA_colw:10"); addHeaderCell("Keimzahl",
	 * "xELGA_colw:14"); append("</tr>"); append("</thead>"); }
	 * 
	 * private void addHeaderAntibiogram() { append("<thead>"); append("<tr>");
	 * addHeaderCell("Name des Erregers", "xELGA_colw:15");
	 * addHeaderCell("Wirkstoff", "xELGA_colw:10");
	 * addHeaderCell("Resistenzkennung", "xELGA_colw:14"); append("</tr>");
	 * append("</thead>"); }
	 * 
	 * private void addHeaderMaterial() { append("<thead>"); append("<tr>");
	 * addHeaderCell("Eigenschaft", "xELGA_colw:15"); addHeaderCell("Ergebnis",
	 * "xELGA_colw:10"); addHeaderCell("Einheit", "xELGA_colw:14"); append("</tr>");
	 * append("</thead>"); }
	 * 
	 * private void addHeaderCell(String text, String styleCode) {
	 * append("<th styleCode=\""); append(styleCode); append("\">"); append(text);
	 * append("</th>"); }
	 * 
	 * private void addTableResults(List<LaboratoryObservation> results, int index)
	 * { append("<table>"); addHeaderResults(); addBodyResults(results, index);
	 * 
	 * int count = 1; for (LaboratoryObservation result : results) { if (result !=
	 * null) { addFootnoteResults(result.getNotes(), count); }
	 * 
	 * count++; }
	 * 
	 * append("</table>"); }
	 * 
	 * private void addTableCultureGermDetection(List<CultureGermDetection>
	 * detections, int index) { append("<table>"); addHeaderCultureGermDetection();
	 * addBodyCultureGermDetection(detections, index); append("</table>");
	 * 
	 * for (CultureGermDetection detection : detections) { if (detection != null) {
	 * addTableAntibiogram(detection.getAntibiogram(), index); } }
	 * 
	 * }
	 * 
	 * private void addTableAntibiogram(Antibiogram antibiogram, int index) {
	 * append("<table>"); addHeaderAntibiogram(); addBodyAntibiogram(antibiogram,
	 * index); append("</table>"); }
	 * 
	 * private void addBodyResults(List<LaboratoryObservation> results, int index) {
	 * if (results != null) { append("<tbody>");
	 * 
	 * int count = 0; for (LaboratoryObservation result : results) { if (result !=
	 * null) { append("<tr ID=\"OBS-"); append(String.valueOf(index)); append("-");
	 * append(String.valueOf(count)); append("\">");
	 * 
	 * if (result.getNotes() != null && !result.getNotes().isEmpty()) {
	 * addCell(String.format("%s <sup>%i)</sup>",
	 * result.getAnalysisCode().getDisplayName(), count + 1)); } else {
	 * addCell(result.getAnalysisCode().getDisplayName()); }
	 * 
	 * addCell(result.getValue().getValueAsString());
	 * addCell(result.getValue().getUnit());
	 * 
	 * if (result.getObservationRange() != null) { LaboratoryValue value =
	 * result.getObservationRange().get(ElgaObservationInterpretation.NORMAL);
	 * addCell(value.getValueAsString()); } else { addCell(""); }
	 * 
	 * if (result.getInterpretationCodes() != null &&
	 * !result.getInterpretationCodes().isEmpty() &&
	 * result.getInterpretationCodes().get(0) != null) {
	 * addCell(getCodeForInterpretation(result.getInterpretationCodes().get(0).
	 * getCodeValue())); } else { addCell(""); }
	 * 
	 * if (result.getLaboratories() != null && !result.getLaboratories().isEmpty())
	 * { addCell("E"); } else { addCell(""); } }
	 * 
	 * append("</tr>"); count++; }
	 * 
	 * append("</tbody>"); } }
	 * 
	 * private void addBodyCultureGermDetection(List<CultureGermDetection>
	 * detections, int index) { if (detections != null) { append("<tbody>");
	 * 
	 * int count = 0; for (CultureGermDetection detection : detections) { if
	 * (detection != null) { for (LaboratoryObservation result :
	 * detection.getLaboratoryResults()) { append("<tr ID=\"OBS-");
	 * append(String.valueOf(index)); append("-"); append(String.valueOf(count));
	 * append("\">");
	 * 
	 * // Erreger if
	 * (detection.getSpecimen().getSignificantPathogen().getOriginalText() != null
	 * &&
	 * !detection.getSpecimen().getSignificantPathogen().getOriginalText().isEmpty()
	 * ) {
	 * addCell(detection.getSpecimen().getSignificantPathogen().getOriginalText());
	 * } else { addCell("Erreger nicht nachweisbar"); }
	 * 
	 * // Methode addCell(result.getAnalysisCode().getDisplayName());
	 * 
	 * // Keimzahl if (result != null && result.getValue() != null) {
	 * addCell(result.getValue().getValueAsString()); } else {
	 * addCell("Keime (oder Mikroorganismen) nicht nachweisbar"); }
	 * 
	 * append("</tr>"); count++; } } }
	 * 
	 * append("</tbody>"); } }
	 * 
	 * private void addBodyAntibiogram(Antibiogram antibiogram, int index) { if
	 * (antibiogram != null) { append("<tbody>");
	 * 
	 * int count = 0; for (LaboratoryObservation result :
	 * antibiogram.getLaboratoryBattery().getLaboratoryResults()) { if (result !=
	 * null) { append("<tr ID=\"SPEC-"); append(String.valueOf(index)); append("-");
	 * append(String.valueOf(count)); append("\">");
	 * 
	 * // Name des Erregers
	 * addCell(antibiogram.getSpecimen().getSignificantPathogen().getDisplayName());
	 * 
	 * // Wirkstoff addCell(result.getAnalysisCode().getDisplayName());
	 * 
	 * // Resistenzkennung
	 * addCell(getCodeForInterpretation(result.getInterpretationCodes().get(0).
	 * getCodeValue()));
	 * 
	 * append("</tr>"); count++; } }
	 * 
	 * append("</tbody>"); } }
	 * 
	 * private void addFootnoteResults(List<String> notes, int index) { if (notes !=
	 * null) { append("<tfootnote ID=\"fn"); append(String.valueOf(index));
	 * append("\">");
	 * 
	 * for (int count = 0; count < notes.size(); count++) { append("<sup>");
	 * append(String.valueOf(index)); append(")</sup>"); append(notes.get(count)); }
	 * 
	 * append("</tfootnote>"); } }
	 * 
	 * private void addNotes(List<String> notes, int index) { if (notes != null) {
	 * append("<paragraph>");
	 * 
	 * for (int count = 0; count < notes.size(); count++) {
	 * addContent(notes.get(count), "common-remark-", count); }
	 * 
	 * append("</paragraph>"); } }
	 * 
	 * private void addNotifications(List<Code> notifications) { if (notifications
	 * != null) { append("<paragraph styleCode=\"xELGA_h3\">"); append("<list>");
	 * 
	 * for (Code notification : notifications) { append("<item>");
	 * append(notification.getDisplayName()); append("</item>"); }
	 * 
	 * append("</list>"); append("</paragraph>"); } }
	 * 
	 * private String getCodeForInterpretation(String interpretation) { String
	 * retVal = ""; switch (interpretation) { case
	 * ElgaObservationInterpretation.ABNORMAL_CODE: retVal = "*"; break; case
	 * ElgaObservationInterpretation.HIGH_CODE: retVal = "+"; break; case
	 * ElgaObservationInterpretation.HIGH_OFF_SCALE_CODE: retVal = "++"; break; case
	 * ElgaObservationInterpretation.NORMAL_CODE: retVal = ""; break; case
	 * ElgaObservationInterpretation.LOW_CODE: retVal = "-"; break; case
	 * ElgaObservationInterpretation.LOW_OFF_SCALE_CODE: retVal = "--"; break; case
	 * ElgaObservationInterpretation.OUTSIDE_THRESHOLD_CODE: retVal = "**"; break;
	 * case ElgaObservationInterpretation.RESISTENT_CODE: retVal = "R"; break; case
	 * ElgaObservationInterpretation.INTERMEDIATE_CODE: retVal = "I"; break; case
	 * ElgaObservationInterpretation.SUSCEPTIBLE_CODE: retVal = "S"; break; default:
	 * break; }
	 * 
	 * return retVal; }
	 */

	/**
	 * Returns HTML formatted string.
	 *
	 * @see java.lang.Object#toString()
	 */
	/*
	 * @Override public String toString() { if (labData != null) { int index = 0;
	 * for (LaboratoryReportData data : labData) {
	 * append("<paragraph styleCode=\"xELGA_h3\">");
	 * append(data.getStructure().getDisplayName()); append("</paragraph>");
	 * 
	 * if (data.getResults() != null && !data.getResults().isEmpty()) {
	 * addTableResults(data.getResults(), index); }
	 * 
	 * addNotes(data.getNotes(), index);
	 * 
	 * if (data.getDetections() != null && !data.getDetections().isEmpty()) {
	 * addTableCultureGermDetection(data.getDetections(), index); }
	 * 
	 * if (data.getNotifications() != null && !data.getNotifications().isEmpty()) {
	 * addNotifications(data.getNotifications()); }
	 * 
	 * index++; } }
	 * 
	 * return buffer.toString(); }
	 */

}
