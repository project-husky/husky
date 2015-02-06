package org.ehc.cda;

import java.util.List;

import org.ehc.common.Util;
import org.ehc.common.ch.SectionsVACD;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;

/**
 * Builds the <text> part of the Immunization recommendations.
 * 
 * Always builds the whole part (not only adds one immunization recommendation).
 * 
 * @author Axel Helmer
 */
public class ImmunizationRecommendationTextBuilder extends TextBuilder {

    private List<ImmunizationRecommendation> immunizations;
    
    /**
     * Constructor.
     * 
     * @param immunizations
     */
    public ImmunizationRecommendationTextBuilder(List<ImmunizationRecommendation> immunizations) {
        this.immunizations = immunizations;
    }
    
    public List<ImmunizationRecommendation> getUpdatedImmunizations() {
      int i = 0;
      for (ImmunizationRecommendation immunization : this.immunizations) {
        ED reference = Util.createReference(i, SectionsVACD.TREATMENT_PLAN.getContentIdPrefix());
        SubstanceAdministration substanceAdminstration = immunization.copyMdhtImmunizationRecommendation();
        substanceAdminstration.setText(reference);
        i++;
      }
    return immunizations;
        
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
        for (ImmunizationRecommendation immunization : immunizations) {
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

    private void addRow(ImmunizationRecommendation immunization, int i) {
        append("<tr>");
        addCellWithContent(immunization.getVaccineName(), SectionsVACD.TREATMENT_PLAN.getContentIdPrefix(), i);
        addCell("");
        addCell("");
        addCell(immunization.getEffectiveTime());
        addCell(""); // gegen
        addCell(immunization.getAuthor().getCompleteName());
        addCell("");
        append("</tr>");
    }
}
