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
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda;

import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * Allergy Concern
 * <div class="de">Dieses Element enthält die Allergien und Unverträglichkeiten des Patienten.</div> 
 * <div class="fr"></div>.
 */
public class AllergyConcern extends ConcernEntry {

  /**
   * The MDHT allergy concern.
   */
	protected org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern mAllergyConcern;

	/**
	 * Instantiates a new allergy concern.
	 */
	public AllergyConcern() {
		super(IHEFactory.eINSTANCE.createAllergyIntoleranceConcern().init());
		mAllergyConcern = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) super.getMdhtConcern();
	}

	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 *
	 * @param allergyConcern <br>
	 * 		<div class="de"> allergy concern</div>
	 * 		<div class="fr"> allergy concern</div>
	 * 		<div class="it"> allergy concern</div>
	 */
	public AllergyConcern(
			org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern allergyConcern) {
		super(allergyConcern);
		mAllergyConcern = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) super.getMdhtConcern();
	}

	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 *
	 * @param concern            
	 *     <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *     <div class="fr">Le nom du problème (texte libre)</div>
	 * @param problemEntry <br>
	 * 		<div class="de"> Das medizinische Problem</div>
	 * 		<div class="fr"> problem entry</div>
	 * 		<div class="it"> problem entry</div>
	 * @param completed            
	 *     <div class="de">Der Status Code des Leidens (active/suspended/aborted/completed)</div> 
	 *     <div class="fr">Le statut du problème (active/suspended/aborted/completed)</div>
	 */
	public AllergyConcern(String concern, AllergyProblem problemEntry, org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode completed) {
		super(IHEFactory.eINSTANCE.createAllergyIntoleranceConcern().init());
		mAllergyConcern = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) super.mConcernEntry;
		setConcern(concern);
		addAllergyProblem(problemEntry);
		setStatus(completed);
		setId(null);
		setEffectiveTime(null, null);
	}

	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 *
	 * @param concern            
	 *     <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *     <div class="fr">Le nom du problème (texte libre)</div>
	 * @param begin            
	 *     <div class="de">Beginn des Leidens</div> 
	 *     <div class="fr">Le début du problème</div>
	 * @param end            
	 *     <div class="de">Ende des Leidens</div> 
	 *     <div class="fr">Le fin du problème</div>
	 * @param problemEntry <br>
	 * 		<div class="de">Das medizinische Problem</div>
	 * 		<div class="fr"> problem entry</div>
	 * 		<div class="it"> problem entry</div>
	 * @param concernStatus            
	 *     <div class="de">Der Status Code des Leidens (active/suspended/aborted/completed)</div> 
	 *     <div class="fr">Le statut du problème (active/suspended/aborted/completed)</div>
	 */
	public AllergyConcern(String concern,
			Date begin, Date end, AllergyProblem problemEntry, ProblemConcernStatusCode concernStatus) {
		this(concern, problemEntry, concernStatus);
		setEffectiveTime(begin, end);
	}

	/**
	 * Fügt dem Leiden ein medizinisches Problem hinzu.
	 *
	 * @param problemEntry            Das Problem
	 */
	public void addAllergyProblem(AllergyProblem problemEntry) {
		mAllergyConcern.addObservation(problemEntry.mAllergyProblem);
		mAllergyConcern.getEntryRelationships().get(0)
		.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		mAllergyConcern.getEntryRelationships().get(0).setInversionInd(false);
	}

	/**
	 * <div class="de">Copy mdht allergy concern.</div>
	 * <div class="fr">Copy mdht allergy concern.</div>
	 * <div class="it">Copy mdht allergy concern.</div>
	 *
	 * @return the org.openhealthtools.mdht.uml.cda.ihe. allergy intolerance concern
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern copyMdhtAllergyConcern() {
		return EcoreUtil.copy(mAllergyConcern);
	}

	/**
	 * Gets the allergy problems.
	 *
	 * @return the allergy problems
	 */
	public ArrayList<AllergyProblem> getAllergyProblems() {
		ArrayList<AllergyProblem> apl = new ArrayList<AllergyProblem>();
		for (AllergyIntolerance mAllergy: mAllergyConcern.getAllergyIntolerances()) {
			AllergyProblem allergy = new AllergyProblem(mAllergy);
			apl.add(allergy);
		}
		return apl;
	}

	/**
	 * Gets the mdht allergy concern.
	 *
	 * @return the mdht allergy concern
	 */
	public AllergyIntoleranceConcern getMdhtAllergyConcern() {
		return mAllergyConcern;
	}
}
