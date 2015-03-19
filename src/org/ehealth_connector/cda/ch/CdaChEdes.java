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

package org.ehealth_connector.cda.ch;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ProblemConcernEntry;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ch.EDES;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;

public class CdaChEdes extends CdaCh {

  public static final String EDES_TITLE= "EDES";

  /**
   * <div class="de">Erstellt ein neues CdaChVacd Convenience Objekt mittels eines MDHT-VACD Objekts. Beide repräsentieren ein Impfdokument.</div>
   * <div class="fr"></div>
   *
   * @param doc 
   * 		<div class="de">CdaChEdes</div>
   *		<div class="fr"></div>
   */
  public CdaChEdes(EDES doc) {
    super(doc);
    setDoc(doc);
  }

  //TODO Der Konstruktor sollte alle minimal benötigten Elemente enthalten (also alle Sections), damit die Anwender wissen, was sie zuvor zusammenbauen müssen.

  /**
   * Erstellt ein neues CdaChEdes CDA Dokument.
   *
   * @param language          Dokument-Sprache (CDA: /ClinicalDocument/languageCode)
   * @param stylesheet          Stylesheet, welches im CDA mittels <?xml-stylesheet> für die
   *          menschlich Lesbare Darstellung referenziert werden soll.
   */
  public CdaChEdes(LanguageCode language, String stylesheet) {
    super(CHFactory.eINSTANCE.createEDES().init());
    setLanguageCode(language);
    setTitle(EDES_TITLE);
    setCss(stylesheet);
  }

  /**
   * Fügt ein Leiden hinzu.
   *
   * @param problemConcern Das Leiden
   */
  public void addProblemConcern(
      org.ehealth_connector.cda.ProblemConcernEntry problemConcern) {

    org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection activeProblemsSection;

    if (getDoc().getActiveProblemsSections() == null) {
      activeProblemsSection = IHEFactory.eINSTANCE.createActiveProblemsSection().init();
      getDoc().addSection(activeProblemsSection);
    }
    else {
      activeProblemsSection = getDoc().getActiveProblemsSections().get(0);
    }

    // set up the narrative (human-readable) text portion of the ProblemConcern Section
    // section
    StringBuffer buffer = new StringBuffer();
    buffer.append("<table border=\"1\" width=\"100%\">");
    buffer.append("<thead>");
    buffer.append("<tr>");
    buffer.append("<th>Risikokategorie</th>");
    buffer.append("<th>Risikofaktor</th>");
    buffer.append("</tr>");
    buffer.append("</thead>");
    buffer.append("<tbody>");
    buffer.append("<tr>");
    buffer.append("<td>Komplikationsrisiko</td>");
    buffer.append("<td><content ID='p1'>Niereninsuffizienz</content></td>");
    buffer.append("</tr>");
    buffer.append("</tbody>");
    buffer.append("</table>");
    activeProblemsSection.createStrucDocText(buffer.toString());

    //create a copy of the given object and its sub-objects
    org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntryMdht = EcoreUtil.copy(problemConcern.copyMdhtProblemConcernEntry());
    activeProblemsSection.addAct(problemConcernEntryMdht);
  }

  public ProblemConcernEntry getActiveProblemConcern (int leidenNr) {
    ProblemConcernEntry problemConcernEntry = new ProblemConcernEntry((org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) getDoc().getActiveProblemsSections().get(0).getActs().get(leidenNr));
    return problemConcernEntry;
  }

  /**
   * Liefert das MDHT-CDAEDESCTNN-Objekt zurück
   *
   * @return the doc
   */
  public EDES getDoc () {
    return (EDES) doc;
  }

  /**
   * Liefert alle Leiden im eVACDOC.
   *
   * @return Liste von Leiden
   */
  public ArrayList<ProblemConcernEntry> getProblemConcernEntries() {
    // Get the ActiveProblemSection from the Document
    org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection activeProblemsSection = (org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection) getDoc().getSections().get(0);

    // Create a List with Problem ConcernEntries
    ArrayList<ProblemConcernEntry> problemConcernEntryList = new ArrayList<ProblemConcernEntry>();

    System.out.println("Assembling ProblemConcernEntryList");
    // Check if an Act is a problemConcernEntry. If so, create an
    // eHealthConnector ProblemConcernObject and add it to the list.
    for (Act act : activeProblemsSection.getActs()) {
      if (act instanceof org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) {
        ProblemConcernEntry problemConcernEntry = new ProblemConcernEntry((org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
        problemConcernEntryList.add(problemConcernEntry);
        System.out.println("List Item Code: "+problemConcernEntry.getConcern());
      }
    }

    return problemConcernEntryList;
  }

  /**
   * Setzt das MDHT-CDAEDESCTNN-Objekt
   *
   * @param doc the new doc
   */
  public void setDoc(EDES doc) {
    this.doc = doc;
  }
}
