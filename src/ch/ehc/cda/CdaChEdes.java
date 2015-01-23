/**
 * <div class="de">Erzeugt ein CdaChEdes-Objekt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 */
package ch.ehc.cda;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.ProblemConcernEntry;
import org.ehc.common.ConvenienceUtilsEnums.Language;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.ch.EDES;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;

public class CdaChEdes extends CdaCh {

	/**
	 * <div class="de">Erstellt ein neues CdaChVacd Convenience Objekt mittels eines MDHT-VACD Objekts. Beide repräsentieren ein Impfdokument.</div>
	 * <div class="fr"></div>
	 *
	 * @param doc 
	 * 		<div class="de">CdaChEdes</div>
	 *		<div class="fr"></div>
	 */
	public CdaChEdes(EDES doc) {
		super();
		this.setDoc(doc);
	}

	//TODO Der Konstruktor sollte alle minimal benötigten Elemente enthalten (also alle Sections), damit die Anwender wissen, was sie zuvor zusammenbauen müssen.
	
	/**
	 * Erstellt ein neues CdaChEdes CDA Dokument.
	 *
	 * @param language          Dokument-Sprache (CDA: /ClinicalDocument/languageCode)
	 * @param stylesheet          Stylesheet, welches im CDA mittels <?xml-stylesheet> für die
	 *          menschlich Lesbare Darstellung referenziert werden soll.
	 */
	public CdaChEdes(Language language, String stylesheet) {
		super();
		super.doc = CHFactory.eINSTANCE.createEDES().init();
		super.setChMetadata(language, stylesheet, "EDES");
		printXmlToConsole();
	}

	/**
	 * Fügt ein Leiden hinzu.
	 *
	 * @param problemConcern Das Leiden
	 */
	public void addProblemConcern(
			org.ehc.cda.ProblemConcernEntry problemConcern) {

		org.openhealthtools.mdht.uml.cda.ihe.ActiveProblemsSection activeProblemsSection;
		
		if (this.getDoc().getActiveProblemsSections() == null) {
			activeProblemsSection = IHEFactory.eINSTANCE.createActiveProblemsSection().init();
			this.getDoc().addSection(activeProblemsSection);
		}
		else {
			activeProblemsSection = this.getDoc().getActiveProblemsSections().get(0);
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
		org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntryMdht = EcoreUtil.copy(problemConcern.getMdhtProblemConcernEntry());
		activeProblemsSection.addAct(problemConcernEntryMdht);
	}
	
	public ProblemConcernEntry getActiveProblemConcern (int leidenNr) {
		ProblemConcernEntry problemConcernEntry = new ProblemConcernEntry((org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) this.getDoc().getActiveProblemsSections().get(0).getActs().get(leidenNr));
		return problemConcernEntry;
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
				System.out.println("List Item Code: "+problemConcernEntry.getProblemConcern());
			}
		}

		return problemConcernEntryList;
	}

	/**
	 * Liefert das MDHT-CDAEDESCTNN-Objekt zurück
	 *
	 * @return the doc
	 */
	public EDES getDoc () {
		return (EDES) this.doc;
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
