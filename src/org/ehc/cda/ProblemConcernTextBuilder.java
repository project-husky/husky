package org.ehc.cda;

import java.util.ArrayList;
import java.util.List;

import org.ehc.general.DateUtil;

/**
 * Builds the <text> part of the Treatment plan section.
 * 
 * Always builds the whole part (not only adds one recommendation).
 * 
 * @author gsc
 */
public class ProblemConcernTextBuilder extends TextBuilder {
  
  private List<ProblemConcernEntry> problemConcernEntries;

  public ProblemConcernTextBuilder(ArrayList<ProblemConcernEntry> problemConcernEntries) {
    this.problemConcernEntries = problemConcernEntries;
  }

  private void addHeader() {
    append("<thead>");
    append("<tr>");
    append("<th>Risikokategorie</th>");
    append("<th>Risikofaktor</th>");
    append("</tr>");
    append("</thead>");
  }

  private void addBody() {
    append("<tbody>");
    append("<tr>");
    append("<td>Komplikationsrisiko</td>");
    append("<td><content ID='p1'>Niereninsuffizienz</content></td>");
    append("</tr>");
    append("</tbody>");
    append("</table>");
  }

//  private void addRow(ProblemConcernEntry problemConcernEntry, int i) {
//    append("<tr>");
//    addCellWithContent(problemConcernEntry., i);
//    addCell("");
//    addCell("");
//    addCell(DateUtil.formatDateCH(immunization.getEffectiveTime()));
//    addCell(""); // gegen
//    addCell(immunization.getAuthor().getCompleteName());
//    addCell("");
//    append("</tr>");
//}
//
//private void addCell(String text) {
//    append("<td>");
//    append(text);
//    append("</td>");
//}
//
//private void addCellWithContent(String text, int i) {
//    append("<td>");
//    addContent(text, i);
//    append("</td>");
//}
//
//private void addContent(String text, int i) {
//    append("<content ID='i" + i + "'>");
//    append(text);
//    append("</content>");
//}   
  
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
