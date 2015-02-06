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
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.ch.enums.ProblemConcernStatusCode;
import org.ehc.cda.ch.enums.StatusCode;
import org.ehc.common.Util;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="de">Ein gesundheitliches Leiden</div> <div class="fr">Une
 * souffrance de la santé</div>
 */
public class ProblemConcernEntry extends ConcernEntry {

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
	  super(problemConcernEntry);
	  this.mProblemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) super.mConcernEntry;
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
	public ProblemConcernEntry(String concern, Problem problemEntry, ProblemConcernStatusCode concernStatus) {
		super(IHEFactory.eINSTANCE.createProblemConcernEntry().init());
		this.mProblemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) super.mConcernEntry;
		this.setProblemConcern(concern);
		this.addProblemEntry(problemEntry);
		this.setCodedStatusOfConcern(concernStatus);
	    this.setEffectiveTime(null, null);
		this.setInternalId(null);
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
			Date begin, Date end, Problem problemEntry, ProblemConcernStatusCode concernStatus) {
      this(concern, problemEntry, concernStatus);
      this.setEffectiveTime(begin, end);
	}

  /**
	 * Fügt dem Leiden ein medizinisches Problem hinzu
	 * 
	 * @param problemEntry
	 *            Das Problem
	 */
	public void addProblemEntry(Problem problemEntry) {
	  mProblemConcernEntry.addObservation(problemEntry.getMdhtProblemEntry());
	  EList<EntryRelationship> entryRel = mProblemConcernEntry.getEntryRelationships(); 
	  //Set the Attributes of the last added element
	  entryRel.get(entryRel.size()-1).setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
	  entryRel.get(entryRel.size()-1).setInversionInd(false);
	}

	/**
	 * Gibt das (erste) medizinische Problem zu dem Leiden zurück
	 * 
	 * @return das problemConcern Objekt
	 */
	public Problem getProblemEntry() {
		Problem problemEntry = new Problem(copyMdhtProblemConcernEntry()
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
	public Problem getProblemEntry(int problemNr) {
		// TODO Convert the Observation List in a ehealthconnector ProblemEntry
		// list (List<ProblemEntry>) this.getObservations();
		Problem problemEntry = new Problem(copyMdhtProblemConcernEntry()
				.getObservations().get(problemNr));
		return problemEntry;
	}
	
    private void setInternalId(String id) {
      II ii = Util.createUuidVacd(id);
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
