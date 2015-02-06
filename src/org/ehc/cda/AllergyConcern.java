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

import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.ch.enums.ProblemConcernStatusCode;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="de">Ein gesundheitliches Leiden</div> <div class="fr">Une
 * souffrance de la santé</div>
 */
public class AllergyConcern extends ConcernEntry {

	protected org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern mAllergyConcern;
	
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
	 * @param allergyConcernEntry
	 * <div class="de">Vorbestehendes Objekt, das geklont werden soll</div>
	 * 
	 * <div class="fr">Objet préexistante à cloner</div>
	 * 
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
	 *            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *            <div class="fr">Le nom du problème (texte libre)</div>
	 * @param completed
	 *            <div class="de">Der Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 */
	public AllergyConcern(String concern, AllergyProblem problemEntry, org.ehc.cda.ch.enums.ProblemConcernStatusCode completed) {
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
	public AllergyConcern(String concern,
			Date begin, Date end, AllergyProblem problemEntry, ProblemConcernStatusCode concernStatus) {
		this(concern, problemEntry, concernStatus);
		setEffectiveTime(begin, end);
	}

	/**
	 * Fügt dem Leiden ein medizinisches Problem hinzu
	 * 
	 * @param problemEntry
	 *            Das Problem
	 */
	public void addAllergyProblem(AllergyProblem problemEntry) {
		mAllergyConcern.addObservation(problemEntry.mAllergyProblem);
		mAllergyConcern.getEntryRelationships().get(0)
		.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		mAllergyConcern.getEntryRelationships().get(0).setInversionInd(false);
	}
	
	public ArrayList<AllergyProblem> getAllergyProblems() {
		ArrayList<AllergyProblem> apl = new ArrayList<AllergyProblem>();
		for (AllergyIntolerance mAllergy: mAllergyConcern.getAllergyIntolerances()) {
			AllergyProblem allergy = new AllergyProblem(mAllergy);
			apl.add(allergy);
		}
		return apl;
	}

	public org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern copyMdhtAllergyConcern() {
		return EcoreUtil.copy(mAllergyConcern);
	}

	public AllergyIntoleranceConcern getMdhtAllergyConcern() {
		return mAllergyConcern;
	}
}
