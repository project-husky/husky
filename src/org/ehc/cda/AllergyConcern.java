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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.common.Util;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

import ch.ehc.cda.enums.ProblemConcernStatusCode;
import ch.ehc.cda.enums.StatusCode;

/**
 * <div class="de">Ein gesundheitliches Leiden</div> <div class="fr">Une
 * souffrance de la santé</div>
 */
public class AllergyConcern extends ConcernEntry {

	protected org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern mAllergyConcern;

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
	  this.mAllergyConcern = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) super.mConcernEntry;
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
	public AllergyConcern(String concern, AllergyProblem problemEntry, ch.ehc.cda.enums.ProblemConcernStatusCode completed) {
	    super(IHEFactory.eINSTANCE.createAllergyIntoleranceConcern().init());
	    this.mAllergyConcern = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) super.mConcernEntry;
		this.setProblemConcern(concern);
		this.addAllergy(problemEntry);
		this.setCodedStatusOfConcern(completed);
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
	public AllergyConcern(String concern,
			Date begin, Date end, AllergyProblem problemEntry, ProblemConcernStatusCode concernStatus) {
		this(concern, problemEntry, concernStatus);
		this.setEffectiveTime(begin, end);
	}

	/**
	 * Fügt dem Leiden ein medizinisches Problem hinzu
	 * 
	 * @param problemEntry
	 *            Das Problem
	 */
	public void addAllergy(AllergyProblem problemEntry) {
	  mAllergyConcern.addObservation(problemEntry.mAllergyProblem);
		mAllergyConcern.getEntryRelationships().get(0)
	    .setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		mAllergyConcern.getEntryRelationships().get(0).setInversionInd(false);
	}
	
    private void setInternalId(String id) {
      II ii = Util.createUuidVacd(id);
      mAllergyConcern.getIds().add(ii);
    }

	public org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern copyMdhtAllergyConcern() {
		return EcoreUtil.copy(mAllergyConcern);
	}

	public void setAllergyConcern(org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern mAllergyConcern) {
		this.mAllergyConcern = mAllergyConcern;
	}
	
	public List<org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance> getMdhtAllergyList() {
      return this.mAllergyConcern.getAllergyIntolerances();
	}
}
