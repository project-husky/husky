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


package org.ehealth_connector.cda;

import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="de">Ein gesundheitliches Leiden</div> 
 * <div class="fr">Une souffrance de la santé</div>.
 */
public class ProblemConcern extends Concern {

  protected org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry mProblemConcernEntry;

  /**
   * Instantiates a new problem concern entry.
   */
  public ProblemConcern() {
    super(IHEFactory.eINSTANCE.createProblemConcernEntry().init());
    mProblemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) super.getMdhtConcern();
  }

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
  public ProblemConcern(
      org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntry) {
    super(problemConcernEntry);
    mProblemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) super.mConcernEntry;
  }

  /**
   * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
   * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
   * 
   * <div class="fr">Crée un objet qui représente un problème. L'objet peut
   * être ajouté dans ActiveProblemsSection.</div>
   *
   * @param concern            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
   *            <div class="fr">Le nom du problème (texte libre)</div>
   * @param problemEntry <br>
   * 		<div class="de"> problem entry</div>
   * 		<div class="fr"> problem entry</div>
   * 		<div class="it"> problem entry</div>
   * @param concernStatus            <div class="de">Der Status Code des Leidens
   *            (active/suspended/aborted/completed)</div> <div class="fr">Le
   *            statut du problème (active/suspended/aborted/completed)</div>
   */
  public ProblemConcern(String concern, Problem problemEntry, org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode concernStatus) {
    super(IHEFactory.eINSTANCE.createProblemConcernEntry().init());
    mProblemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) super.mConcernEntry;
    setConcern(concern);
    addProblemEntry(problemEntry);
    setStatus(concernStatus);
    setEffectiveTime(new Date(), null);
    addId(null);
  }

  /**
   * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
   * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
   * 
   * <div class="fr">Crée un objet qui représente un problème. L'objet peut
   * être ajouté dans ActiveProblemsSection.</div>
   *
   * @param concern            
   * 		<div class="de">Die Bezeichnung des Leidens (Freitext)</div>
   *      <div class="fr">Le nom du problème (texte libre)</div>
   * @param problemEntry <br>
   * 		<div class="de"></div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   * @param concernStatus            
   * 		<div class="de">Der Status Code des Leidens
   *       (active/suspended/aborted/completed)</div> 
   *       <div class="fr">Le statut du problème (active/suspended/aborted/completed)</div>
   * @param start <br>
   * 		<div class="de">Beginn des Leidens</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   * @param end            
   * 		<div class="de">Ende des Leidens</div> 
   * 		<div class="fr">Le fin du problème</div>
   */
  public ProblemConcern(String concern,
      Problem problemEntry, ProblemConcernStatusCode concernStatus, Date start, Date end) {
    this(concern, problemEntry, concernStatus);
    setEffectiveTime(start, end);
  }

  /**
   * Fügt dem Leiden ein medizinisches Problem hinzu.
   *
   * @param problemEntry            Das Problem
   */
  public void addProblemEntry(Problem problemEntry) {
    mProblemConcernEntry.addObservation(problemEntry.copyMdhtProblemEntry());
    EList<EntryRelationship> entryRel = mProblemConcernEntry.getEntryRelationships(); 
    //Set the Attributes of the last added element
    entryRel.get(entryRel.size()-1).setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
    entryRel.get(entryRel.size()-1).setInversionInd(false);
  }

  /**
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return the org.openhealthtools.mdht.uml.cda.ihe. problem concern entry
   */
  public org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry copyMdhtProblemConcernEntry() {
    return EcoreUtil.copy(mProblemConcernEntry);
  }

  /**
   * Gets the mdht problem concern entry.
   *
   * @return the mdht problem concern entry
   */
  public org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry getMdhtProblemConcernEntry() {
    return mProblemConcernEntry;
  }

  /**
   * Gibt alle zu dem Leiden zugehörigen medizinischen Probleme zurück
   *
   * @return the problem entries
   */
  public ArrayList<Problem> getProblemEntries() {
    ArrayList<Problem> pel = new ArrayList<Problem>();
    for (org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry mAllergy: mProblemConcernEntry.getProblemEntries()) {
      Problem problem = new Problem(mAllergy);
      pel.add(problem);
    }
    return pel;
  }

  /**
   * Gibt das (erste) medizinische Problem zu dem Leiden zurück.
   *
   * @return das problemConcern Objekt
   */
  public Problem getProblemEntry() {
    Problem problemEntry = new Problem(copyMdhtProblemConcernEntry()
        .getObservations().get(0));
    return problemEntry;
  }

}
