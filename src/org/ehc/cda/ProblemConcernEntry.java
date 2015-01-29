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

package org.ehc.cda;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.common.DateUtil;
import org.ehc.common.Util;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

import ch.ehc.cda.enums.StatusCode;

/**
 * <div class="de">Ein gesundheitliches Leiden</div> <div class="fr">Une
 * souffrance de la santé</div>
 */
public class ProblemConcernEntry {

	protected org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry mProblemConcernEntry;

	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 * 
	 * @param problemConcernEntry
	 * <div class="de">Vorbestehendes Objekt, das geklont werden soll</div>
	 * 
	 * <div class="fr">Objet préexistante à cloner</div>
	 * 
	 */
	public ProblemConcernEntry(
			org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntry) {
		//this.mProblemConcernEntry = IHEFactory.eINSTANCE.createProblemConcernEntry();
		this.setProblemConcernEntry(problemConcernEntry);
		//ProblemEntry problemEntry = new ProblemEntry(problemConcernEntry.getProblemEntries().get(0));
		//this.cAddProblemEntry(problemEntry);
	}

	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 * 
	 * @param concern
	 *            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *            <div class="fr">Le nom du problème (texte libre)</div>
	 * @param concernStatus
	 *            <div class="de">Der Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 */
	public ProblemConcernEntry(String concern, ProblemEntry problemEntry, ch.ehc.cda.enums.StatusCode concernStatus) {
		setProblemConcernEntry(IHEFactory.eINSTANCE.createProblemConcernEntry());
		mProblemConcernEntry.init();
		this.setProblemConcern(concern);
		this.addProblemEntry(problemEntry);
		this.setCodedStatusOfConcern(concernStatus);
		this.setInternalId(null);
		this.setEffectiveTime(null, null);
	}
	
	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 * 
	 * @param concern
	 *            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *            <div class="fr">Le nom du problème (texte libre)</div>
	 * @param concernStatus
	 *            <div class="de">Der Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 * @param begin
	 *            <div class="de">Beginn des Leidens</div> <div class="fr">Le
	 *            début du problème</div>
	 * @param end
	 *            <div class="de">Ende des Leidens</div> <div class="fr">Le fin
	 *            du problème</div>
	 */
	public ProblemConcernEntry(String concern,
			Date begin, Date end, ProblemEntry problemEntry, StatusCode concernStatus) {
		this(concern,
				DateFormat.getDateInstance().format(begin), DateFormat
						.getDateInstance().format(end), problemEntry, concernStatus);
	}

	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 * 
	 * @param concern
	 *            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *            <div class="fr">Le nom du problème (texte libre)</div>
	 * @param concernStatus
	 *            <div class="de">Der Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 * @param begin
	 *            <div class="de">Beginn des Leidens</div> <div class="fr">Le
	 *            début du problème</div>
	 * @param end
	 *            <div class="de">Ende des Leidens</div> <div class="fr">Le fin
	 *            du problème</div>
	 */
	public ProblemConcernEntry(String concern, 
			String begin, String end, ProblemEntry problemEntry, StatusCode concernStatus) {
		this(concern, problemEntry, concernStatus);
		this.setEffectiveTime(begin, end);
	}

	public void setEffectiveTime(String begin, String end) {
	  // Create and set the concern interval
      try {
          mProblemConcernEntry.setEffectiveTime(DateUtil
                  .createIVL_TSFromEuroDate(begin, end));
      } catch (ParseException e) {
          e.printStackTrace();
      }
  }

	/**
	 * Gibt den Status (aktiv/inaktiv/...) des Leidens zurück
	 * 
	 * @return Status des Leidens
	 */
	public String getCodedStatusOfConcern() {
		//TODO map the String to an enum 
		return mProblemConcernEntry.getStatusCode().getCode();
	}

	/**
	 * Gibt das Ende des Leidens zurück
	 * 
	 * @return Ende des Leidens
	 */
	public String getEndOfConcern() {
		return Util.createEurDateStrFromTS(copyMdhtProblemConcernEntry()
				.getEffectiveTime().getHigh().getValue());
	}

	/**
	 * Gibt den Beginn des Leidens zurück
	 * 
	 * @return Beginn des Leidens
	 */
	public String getStartOfConcern() {
		return Util.createEurDateStrFromTS(copyMdhtProblemConcernEntry()
				.getEffectiveTime().getLow().getValue());
	}

	/**
	 * Setzt den Status (aktiv/inaktiv/...) des Leidens
	 * 
	 * @param concernStatus
	 *            Status
	 */
	public void setCodedStatusOfConcern(ch.ehc.cda.enums.StatusCode concernStatus) {
		// Create and set the status code
		// TODO Prüfen, ob hier immer "completed" angegeben werden muss
		// (Implementierungsleitfaden 7.5.2.4)
		
		mProblemConcernEntry.setStatusCode(concernStatus.getCS());
	}

	/**
	 * Setzt das Ende des Leidens
	 * 
	 * @param endOfConcern
	 *            Ende des Leidens
	 */
	public void setEndOfConcern(String endOfConcern) {
		try {
			mProblemConcernEntry.getEffectiveTime().setHigh(
			    DateUtil.createIVXB_TSFromEuroDate(endOfConcern));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Setzt den Beginn des Leidens
	 * 
	 * @param startOfConcern
	 *            Beginn des Leidens
	 */
	public void setStartOfConcern(String startOfConcern) {
		try {
			mProblemConcernEntry.getEffectiveTime().setLow(
			    DateUtil.createIVXB_TSFromEuroDate(startOfConcern));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Setzt das Leiden
	 * 
	 * @param concern
	 *            Leiden
	 */
	public void setProblemConcern(String concern) {
		// Create and set the concern as freetext
		ED concernText = DatatypesFactory.eINSTANCE.createED(concern);
		mProblemConcernEntry.setText(concernText);
	}

	/**
	 * Gibt das Leiden zurück
	 * 
	 */
	public String getProblemConcern() {
		return mProblemConcernEntry.getText().getText();
	}

	/**
	 * Fügt dem Leiden ein medizinisches Problem hinzu
	 * 
	 * @param problemEntry
	 *            Das Problem
	 */
	public void addProblemEntry(ProblemEntry problemEntry) {
	  mProblemConcernEntry.addObservation(problemEntry.mProblemEntry);
		mProblemConcernEntry.getEntryRelationships().get(0)
	    .setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		mProblemConcernEntry.getEntryRelationships().get(0).setInversionInd(false);
	}

	/**
	 * Gibt das (erste) medizinische Problem zu dem Leiden zurück
	 * 
	 * @return das problemConcern Objekt
	 */
	public ProblemEntry getProblemEntry() {
		// TODO Convert the Observation List in a ehealthconnector ProblemEntry
		// list (List<ProblemEntry>) this.getObservations();
		ProblemEntry problemEntry = new ProblemEntry(copyMdhtProblemConcernEntry()
				.getObservations().get(0));
		return problemEntry;
	}
	
	/**
	 * Gibt ein medizinische Problem zu dem Leiden zurück.
	 * 
	 * @param problemNr 
	 * 		Nummer des Leidens
	 * @return das problemConcern Objekt, sonst null
	 */
	public ProblemEntry getProblemEntry(int problemNr) {
		// TODO Convert the Observation List in a ehealthconnector ProblemEntry
		// list (List<ProblemEntry>) this.getObservations();
		ProblemEntry problemEntry = new ProblemEntry(copyMdhtProblemConcernEntry()
				.getObservations().get(problemNr));
		return problemEntry;
	}
	
    private void setInternalId(String id) {
      II ii = DatatypesFactory.eINSTANCE.createII();
      if (id==null) {
        ii.setRoot(UUID.generate());
      }
      else {
        ii.setRoot(id);
      }
      mProblemConcernEntry.getIds().add(ii);
    }

	public org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry copyMdhtProblemConcernEntry() {
		return EcoreUtil.copy(mProblemConcernEntry);
	}

	public void setProblemConcernEntry(org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry mProblemConcernEntry) {
		this.mProblemConcernEntry = mProblemConcernEntry;
	}
	
	public List<org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry> getMdhtProblemEntryList() {
      return this.mProblemConcernEntry.getProblemEntries();
	}
}
