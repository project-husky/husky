package org.ehc.cda;

import java.util.ArrayList;
import java.util.List;

import org.ehc.common.Util;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;

import ch.ehc.common.SectionsVACD;

/**
 * Builds the <text> part of the Immunization recommendations.
 * 
 * Always builds the whole part (not only adds one immunization recommendation).
 * 
 * @author Axel Helmer
 */
public class ProblemConcernEntryTextBuilder extends TextBuilder {

    private ArrayList<org.ehc.cda.ProblemConcernEntry> problemConcerns;
	private String contentIdPrefix = SectionsVACD.HISTORY_OF_PAST_ILLNESS.getContentIdPrefix();
    
    /**
     * Constructor.
     * 
     * @param pastProblemConcerns
     */
    public ProblemConcernEntryTextBuilder(List<PastProblemConcernEntry> problemConcerns) {
      //convert to the more common type ProblemConcern  
      ArrayList<org.ehc.cda.ProblemConcernEntry> problemConcernEntryList = new ArrayList<org.ehc.cda.ProblemConcernEntry>();
      
      for (PastProblemConcernEntry pastProblemConcern : problemConcerns) {
        org.ehc.cda.ProblemConcernEntry problemConcernEntry = new  org.ehc.cda.ProblemConcernEntry(pastProblemConcern.copyMdhtProblemConcernEntry());
        problemConcernEntryList.add(problemConcernEntry);
      }
      this.problemConcerns = problemConcernEntryList;
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
        for (org.ehc.cda.ProblemConcernEntry problemConcern : problemConcerns) {
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

    private void addRow(org.ehc.cda.ProblemConcernEntry problemConcern, int i) {
        append("<tr>");
        addCell("Komplikationsrisiko");
        addCellWithContent(problemConcern.getProblemConcern(), contentIdPrefix , i);
        append("</tr>");
    }
}
