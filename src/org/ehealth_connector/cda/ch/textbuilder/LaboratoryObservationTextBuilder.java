package org.ehealth_connector.cda.ch.textbuilder;

import java.util.ArrayList;

import org.ehealth_connector.cda.LaboratoryObservation;
import org.ehealth_connector.cda.ch.SectionsVACD;

/**
 * Builds the <text> part of the Immunization recommendations.
 * 
 * Always builds the whole part (not only adds one immunization recommendation).
 * 
 * @author Axel Helmer
 */
public class LaboratoryObservationTextBuilder extends TextBuilder {

  private ArrayList<org.ehealth_connector.cda.LaboratoryObservation> laboratoryObservation;
  /**
   * Constructor.
   * 
   * @param pastProblemConcerns
   */
  public LaboratoryObservationTextBuilder(ArrayList<LaboratoryObservation> list, SectionsVACD section) {
    laboratoryObservation = list;
    section.getContentIdPrefix();
  }

  private void addBody() {
    append("<tbody>");
    int i = 1;
    for (org.ehealth_connector.cda.LaboratoryObservation problemConcern : laboratoryObservation) {
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
    if (laboratoryObservation.getCode()!=null) {
      if (laboratoryObservation.getCode().getDisplayName()!=null) {
        addCell(laboratoryObservation.getCode().getDisplayName());
      }
      else {
        addCell("");
      }
    }
    else {
      addCell("");
    }
    
    if (laboratoryObservation.getImmuneProtection()) {
      addCell("Positiv");
    }
    else {
      addCell("Negativ");
    }
    addCell("");
    if (laboratoryObservation.getCode()!=null) {
      if (laboratoryObservation.getCode().getCode() !=null) {
        addCell(laboratoryObservation.getCode().getCode());
      }
      else {
        addCell("");
      }
      if (laboratoryObservation.getCode().getCodeSystem() !=null) {
       addCell(laboratoryObservation.getCode().getCodeSystem());
      }
      else {
        addCell("");
      }
      
    }
    else {
      addCell("");
    }
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
