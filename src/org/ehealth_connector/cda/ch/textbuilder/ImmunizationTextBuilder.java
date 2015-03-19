/********************************************************************************
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
********************************************************************************/

package org.ehealth_connector.cda.ch.textbuilder;

import java.util.List;

import org.ehealth_connector.cda.Immunization;
import org.ehealth_connector.cda.ch.SectionsVACD;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Util;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;

/**
 * Builds the <text> part of the History of immunzations.
 * 
 * Always builds the whole part (not only adds one immunization).
 * 
 * @author gsc, Axel Helmer
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
    append("<th>Kommentar</th>");
    append("</tr>");
    append("</thead>");
  }


  private void addRow(Immunization immunization, int i) {
    append("<tr>");
    addCellWithContent(immunization.getConsumable().getTradeName(), SectionsVACD.HISTORY_OF_IMMUNIZATION.getContentIdPrefix(), i);
    addCell("");
    addCell("");
    if (immunization.getApplyDate()!=null) {
      addCell(DateUtil.formatDateCH(immunization.getApplyDate()));
    }
    else {
      addCell("");
    }
    addCell(""); // gegen
    if (immunization.getAuthor() != null) {
      addCell(immunization.getAuthor().getCompleteName());
    }
    else {
      addCell("");
    }
    if (immunization.getCommentText()!=null) {
      addCellWithContent(immunization.getCommentText(), SectionsVACD.HISTORY_OF_IMMUNIZATION.getContentIdPrefix()+"-comment", i);
    }
    addCell("");
    append("</tr>");
  }

  public List<Immunization> getUpdatedImmunizations() {
    int i = 0;
    for (Immunization immunization : immunizations) {
      ED reference = Util.createReference(i, SectionsVACD.HISTORY_OF_IMMUNIZATION.getContentIdPrefix());
      SubstanceAdministration substanceAdminstration = immunization.getMdhtImmunization();
      substanceAdminstration.setText(reference);
      //.getSubstanceAdministrations().get(0);
      i++;
    }
    return immunizations;  
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
