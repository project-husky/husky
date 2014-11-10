/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by
 * medshare GmbH, Switzerland. All rights reserved.
 * http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the
 * Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the
 * Creative Commons Attribution-ShareAlike 3.0 Switzerland License.
 *
 * Year of publication: 2014
 *
 *******************************************************************************/

package ehealthconnector.cda.documents.ch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ch.eVACDOC;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import ehealthconnector.cda.documents.ch.ConvenienceUtilsEnums.Language;

/**
 * <div class="de" Ein CDA Dokument, welches der Spezifikation CDA-CH-VACD entspricht.</div>
 * <div class="fr">Class CdaChVacd.</div>
 * <div class="it">Class CdaChVacd.</div>
 */
public class CdaChVacd extends CdaCh {

	/**
	 * <div class="de">Erstellt ein neues CdaChVacd Convenience Objekt mittels eines MDHT-eVACDOC Objekts. Beide repräsentieren ein Impfdokument.</div>
	 * <div class="fr"></div>
	 *
	 * @param doc 
	 * 		<div class="de">eVACDOC</div>
	 *		<div class="fr"></div>
	 */
	public CdaChVacd(eVACDOC doc) {
		super();
		this.doc = doc;
	}
	
	/**
	 * Erstellt ein neues eVACDOC CDA Dokument.
	 *
	 * @param language          Dokument-Sprache (CDA: /ClinicalDocument/languageCode)
	 * @param stylesheet          Stylesheet, welches im CDA mittels <?xml-stylesheet> für die
	 *          menschlich Lesbare Darstellung referenziert werden soll.
	 */
	public CdaChVacd(Language language, String stylesheet) {
		//super (language, stylesheet);
		super();
		doc = CHFactory.eINSTANCE.createeVACDOC().init();
		docRoot.setClinicalDocument(doc);
		super.setChMetadata(language, stylesheet);
	}

	/**
	 * C add allergy.
	 *
	 * @param allergie <br>
	 * 		<div class="de"> allergie</div>
	 * 		<div class="fr"> allergie</div>
	 * 		<div class="it"> allergie</div>
	 */
	public void cAddAllergy(AllergyIntolerance allergie) {
		// Auto-generated method stub

	}

	/**
	 * Fügt eine Impfung hinzu.
	 *
	 * @param medication            Medikament
	 * @param dosage            Dosis
	 * @param date            Datum der Verabreichung
	 * @param arzt            Verabreichender Arzt
	 */
	public void cAddImmunization(Medication medication, Value dosage,
			Date date, ehealthconnector.cda.documents.ch.Author arzt) {
	}

	/**
	 * Fügt ein Leiden hinzu.
	 *
	 * @param problem            Das Leiden
	 */
	public void cAddProblemConcern(
			ehealthconnector.cda.documents.ch.ProblemConcernEntry problem) {
		org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection activeProblemsSection = IHEFactory.eINSTANCE
				.createActiveProblemsSection().init();
		doc.addSection(activeProblemsSection);

		// set up the narrative (human-readable) text portion of the alerts
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

		org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry leidenMdht = problem.mProblemConcernEntry;
		activeProblemsSection.addAct(leidenMdht);
	}

	/**
	 * Liefert alle Impfempfehlungen im eVACDOC.
	 *
	 * @return Liste von Impfempfehlungen
	 */
	public List<Immunization> cGetImmunizationRecommendations() {
		// Auto-generated method stub
		return null;
	}

	/**
	 * Liefert alle Impfungen im eVACDOC.
	 *
	 * @return Liste von Impfungen
	 */
	public List<Immunization> cGetImmunizations() {
		// Auto-generated method stub
		return null;
	}

	/**
	 * Liefert alle Leiden im eVACDOC.
	 *
	 * @return Liste von Leiden
	 */
	public ArrayList<ProblemConcernEntry> cGetProblemConcernEntries() {
		// Get the ActiveProblemSection from the Document
		org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection activeProblemsSection = (org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection) doc
				.getSections().get(0);

		// Create a List with Problem ConcernEntries
		ArrayList<ProblemConcernEntry> problemConcernEntryList = new ArrayList<ProblemConcernEntry>();

		// Check if an Act is a problemConcernEntry. If so, create an
		// eHealthConnector ProblemConcernObject with it and add it to the list.
		for (Act act : activeProblemsSection.getActs()) {
			if (act instanceof org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) {
				ProblemConcernEntry problemConcernEntry = new ProblemConcernEntry(
						(org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) act);
				problemConcernEntryList.add(problemConcernEntry);
			}
		}

		return problemConcernEntryList;
	}

	/**
	 * Liefert das MDHT-eVACDOC-Objekt zurück
	 *
	 * @return the doc
	 */
	public eVACDOC getDoc () {
		return (eVACDOC) this.doc;
	}
	
	/**
	 * Setzt das MDHT-eVACDOC-Objekt
	 *
	 * @param doc the new doc
	 */
	public void setDoc(eVACDOC doc) {
		this.doc = doc;
	}
}
