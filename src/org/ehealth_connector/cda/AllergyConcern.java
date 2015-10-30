/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode;
import org.ehealth_connector.common.DateUtil;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="en">This element contains the allergies and intolerances of the
 * patient</div> Allergy Concern <div class="de">Dieses Element enthält die
 * Allergien und Unverträglichkeiten des Patienten.</div> <div
 * class="fr"></div>.
 */
public class AllergyConcern extends Concern {

	/**
	 * The MDHT allergy concern.
	 */
	protected org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern mAllergyConcern;

	/**
	 * Instantiates a new allergy concern.
	 */
	public AllergyConcern() {
		super(IHEFactory.eINSTANCE.createAllergyIntoleranceConcern().init());
		mAllergyConcern = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) super
				.getMdhtConcern();
	}

	/**
	 * <div class="en">Creates an object which represents an allergy
	 * concern</div> <div class="de">Erzeugt ein Objekt welches ein Leiden
	 * repräsentiert.</div> <div class="fr">Crée un objet qui représente un
	 * problème.</div>
	 * 
	 * @param allergyConcern
	 *            allergy concern
	 **/
	public AllergyConcern(
			org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern allergyConcern) {
		super(allergyConcern);
		mAllergyConcern = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) super
				.getMdhtConcern();
	}

	/**
	 * <div class="en">Creates an object which represents an allergy
	 * concern</div> <div class="de">Erzeugt ein Objekt welches ein Leiden
	 * repräsentiert.</div> <div class="fr">Crée un objet qui représente un
	 * problème.</div>
	 * 
	 * @param concern
	 *            <div class="en">The concern (free text)</div> <div
	 *            class="de">Die Bezeichnung des Leidens (Freitext)</div> <div
	 *            class="fr">Le nom du problème (texte libre)</div>
	 * @param problemEntry
	 *            <div class="en">the medical problem</div> <div class="de"> Das
	 *            medizinische Problem</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param concernStatus
	 *            <div class="en">status of the concern
	 *            (active/suspended/aborted/completed)</div> <div class="de">Der
	 *            Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 */
	public AllergyConcern(String concern, AllergyProblem problemEntry,
			org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode concernStatus) {
		super(IHEFactory.eINSTANCE.createAllergyIntoleranceConcern().init());
		mAllergyConcern = (org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern) super
				.getConcernEntry();
		setConcern(concern);
		addAllergyProblem(problemEntry);
		setStatus(concernStatus);
		addId(null);
		setEffectiveTime(null, null);
	}

	/**
	 * <div class="en">Creates an object which represents an allergy
	 * concern</div> <div class="de">Erzeugt ein Objekt welches ein Leiden
	 * repräsentiert. Dieses Objekt kann einer ActiveProblemsSection hinzugefügt
	 * werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 * 
	 * @param concern
	 *            <div class="en">The concern (free text)</div> <div
	 *            class="de">Die Bezeichnung des Leidens (Freitext)</div> <div
	 *            class="fr">Le nom du problème (texte libre)</div>
	 * @param begin
	 *            <div class="en">begin of concern</div> <div class="de">Beginn
	 *            des Leidens</div> <div class="fr">Le début du problème</div>
	 * @param end
	 *            <div class="en">end of concern</div> <div class="de">Ende des
	 *            Leidens</div> <div class="fr">Le fin du problème</div>
	 * @param problemEntry
	 *            <div class="en">the medical problem</div> <div class="de"> Das
	 *            medizinische Problem</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param concernStatus
	 *            <div class="en">status of the concern
	 *            (active/suspended/aborted/completed)</div> <div class="de">Der
	 *            Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 */
	public AllergyConcern(String concern, Date begin, Date end, AllergyProblem problemEntry,
			ProblemConcernStatusCode concernStatus) {
		this(concern, problemEntry, concernStatus);
		if (end != null) {
			setEffectiveTime(begin, end);
		} else {
			IVL_TS ivlts = DatatypesFactory.eINSTANCE.createIVL_TS();
			try {
				ivlts.setLow(DateUtil.createIVXB_TSFromDate(begin));
				mAllergyConcern.setEffectiveTime(ivlts);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * <div class="en">Adds a medical problem to the concern</div> <div
	 * class="de">Fügt dem Leiden ein medizinisches Problem hinzu.</div>
	 * 
	 * @param problemEntry
	 *            Das Problem
	 */
	public void addAllergyProblem(AllergyProblem problemEntry) {
		mAllergyConcern.addObservation(EcoreUtil.copy(problemEntry.getAllergyProblem()));
		mAllergyConcern.getEntryRelationships()
				.get(mAllergyConcern.getEntryRelationships().size() - 1)
				.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		mAllergyConcern.getEntryRelationships()
				.get(mAllergyConcern.getEntryRelationships().size() - 1).setInversionInd(false);
	}

	/**
	 * <div class="en">Copy mdht allergy concern.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 * 
	 * @return the org.openhealthtools.mdht.uml.cda.ihe. allergy intolerance
	 *         concern
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.AllergyIntoleranceConcern copyMdhtAllergyConcern() {
		return EcoreUtil.copy(mAllergyConcern);
	}

	/**
	 * Gets the allergy problems.
	 * 
	 * @return the allergy problems
	 */
	public List<AllergyProblem> getAllergyProblems() {
		List<AllergyProblem> apl = new ArrayList<AllergyProblem>();
		for (AllergyIntolerance mAllergy : mAllergyConcern.getAllergyIntolerances()) {
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
