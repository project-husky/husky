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
* Attribution-ShareAlike 4.0 Switzerland License.
*
 * Year of publication: 2015
*
 *******************************************************************************/
package org.ehealth_connector.cda.ch.textbuilder;

import java.util.ArrayList;

import org.ehealth_connector.cda.LaboratoryObservation;
import org.ehealth_connector.cda.ch.SectionsVACD;
import org.ehealth_connector.common.Util;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ch.LaboratoryBatteryOrganizer;

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
    //Beobachtung
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
    
    //Erregernachweis
    if (laboratoryObservation.getImmuneProtection()) {
      addCell("Positiv");
    }
    else {
      addCell("Negativ");
    }
    
    //Resultat
    addCell("");
    
    //Code & CodeSystem
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
    
    //Kommentar
    String cellStr = "<td>";
    int k = 0;
    boolean minOneComment = false;
	for (EntryRelationship er : laboratoryObservation.getMdhtLaboratoryObservation().getEntryRelationships()) {
		if (Util.isComment(er)) {
			k++;
			minOneComment = true;
			cellStr=cellStr+("<content ID='"+SectionsVACD.SEROLOGY_STUDIES.getContentIdPrefix()+"-comment" + String.valueOf(i)+String.valueOf(1)+String.valueOf(k)+"'>");
			cellStr=cellStr+(laboratoryObservation.getCommentText());
			cellStr=cellStr+("</content>");
		}
	}
	if (minOneComment) {
		cellStr=cellStr+"</td>";
		append(cellStr);
	}	
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
