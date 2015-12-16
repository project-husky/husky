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

package org.ehealth_connector.cda.ch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.Concern;
import org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="en">A medical concern</div> <div class="de">Ein gesundheitliches
 * Leiden</div> <div class="fr">Une souffrance de la santé</div>.
 */
public class ProblemConcern extends Concern {

	private org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry mProblemConcernEntry;

	/**
	 * Instantiates a new problem concern entry.
	 */
	public ProblemConcern() {
		super(IHEFactory.eINSTANCE.createProblemConcernEntry().init());
		mProblemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) super
				.getMdhtConcern();
	}

	/**
	 * <div class="en">Creates a medical concern object</div> <div
	 * class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert. Dieses
	 * Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 * 
	 * @param problemConcernEntry
	 *            <div class="en">Medical problem concern object, which should
	 *            be cloned</div> <div class="de">Vorbestehendes Objekt, das
	 *            geklont werden soll</div>
	 * 
	 *            <div class="fr">Objet préexistante à cloner</div>
	 * 
	 */
	public ProblemConcern(
			org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntry) {
		super(problemConcernEntry);
		mProblemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) super
				.getConcernEntry();
	}

	/**
	 * <div class="en">Creates a medical concern object</div> <div
	 * class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert. Dieses
	 * Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 * 
	 * @param concern
	 *            <div class="en">the concern as free text</div> <div
	 *            class="de">Die Bezeichnung des Leidens (Freitext)</div> <div
	 *            class="de">Die Bezeichnung des Leidens (Freitext)</div> <div
	 *            class="fr">Le nom du problème (texte libre)</div>
	 * @param problemEntry
	 *            <div class="en">problem entry</div> <div class="fr"> problem
	 *            entry</div> <div class="it"> problem entry</div>
	 * @param concernStatus
	 *            <div class="en">Status of the concern
	 *            (active/supended/aborted/completed)</div> <div class="de">Der
	 *            Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 */
	public ProblemConcern(String concern, ProblemEntry problemEntry,
			org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode concernStatus) {
		super(IHEFactory.eINSTANCE.createProblemConcernEntry().init());
		mProblemConcernEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry) super
				.getConcernEntry();
		setConcern(concern);
		addProblemEntry(problemEntry);
		setStatus(concernStatus);
		setEffectiveTime(new Date(), null);
		addId(null);
	}

	/**
	 * <div class="en">Creates a medical concern object</div> <div
	 * class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert. Dieses
	 * Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 * 
	 * @param concern
	 *            <div class="en">the concern as free text</div> <div
	 *            class="de">Die Bezeichnung des Leidens (Freitext)</div> <div
	 *            class="fr">Le nom du problème (texte libre)</div>
	 * @param problemEntry
	 *            <div class="en">problem entry object</div> <div
	 *            class="de"></div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param concernStatus
	 *            <div class="en">status code of the concern
	 *            (active/suspended/aborted/completed)</div> <div class="de">Der
	 *            Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 * @param start
	 *            <div class="en">start of concern</div> <div class="de">Beginn
	 *            des Leidens</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param end
	 *            <div class="en">end of concern</div> <div class="de">Ende des
	 *            Leidens</div> <div class="fr">Le fin du problème</div>
	 */
	public ProblemConcern(String concern, ProblemEntry problemEntry,
			ProblemConcernStatusCode concernStatus, Date start, Date end) {
		this(concern, problemEntry, concernStatus);
		setEffectiveTime(start, end);
	}

	/**
	 * <div class="en">Adds a medical problem to the medical concern</div> <div
	 * class="de">Fügt dem Leiden ein medizinisches ProblemEntry hinzu.</div>
	 * 
	 * @param problemEntry
	 *            <div class="en">the problem</div>
	 */
	public void addProblemEntry(ProblemEntry problemEntry) {
		mProblemConcernEntry.addObservation(problemEntry.copy());
		final EList<EntryRelationship> entryRel = mProblemConcernEntry.getEntryRelationships();
		// Set the Attributes of the last added element
		entryRel.get(entryRel.size() - 1).setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		entryRel.get(entryRel.size() - 1).setInversionInd(false);
	}

	/**
	 * <div class="en">Gets a copy of the mdht problem concern entry</div> <div
	 * class="de"></div> <div class="fr"></div> <div class="it"></div>
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
	 * <div class="en">Gets all medical problems related to this problem
	 * conern</div><div class="de">Gibt alle zu dem Leiden zugehörigen
	 * medizinischen Probleme zurück</div>
	 * 
	 * @return the problem entries
	 */
	public List<ProblemEntry> getProblemEntries() {
		final List<ProblemEntry> pel = new ArrayList<ProblemEntry>();
		for (org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry mAllergy : mProblemConcernEntry
				.getProblemEntries()) {
			final ProblemEntry problem = new ProblemEntry(mAllergy);
			pel.add(problem);
		}
		return pel;
	}

	/**
	 * <div class="en">Gets the first medical problem related to this medical
	 * concern</div> Gibt das (erste) medizinische ProblemEntry zu dem Leiden
	 * zurück.
	 * 
	 * @return the medical problem
	 */
	public ProblemEntry getProblemEntry() {
		final ProblemEntry problemEntry = new ProblemEntry(copyMdhtProblemConcernEntry()
				.getProblemEntries().get(0));
		return problemEntry;
	}

}
