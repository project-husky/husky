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

import java.util.Date;

import org.ehc.cda.ch.enums.ProblemConcernStatusCode;
import org.ehc.cda.ch.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;

/**
 * <div class="de">Ein gesundheitliches Leiden</div> <div class="fr">Une
 * souffrance de la santé</div>
 */
public class PastProblemConcernEntry extends ProblemConcernEntry {

	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer HistoryOfPastIllnessSection hinzugefügt werden.</div>
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
	public PastProblemConcernEntry() {
		super();
	}

	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer HistoryOfPastIllnessSection hinzugefügt werden.</div>
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
	public PastProblemConcernEntry(
			org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntry) {
		super(problemConcernEntry);
	}

	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer HistoryOfPastIllnessSection hinzugefügt werden.</div>
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
	public PastProblemConcernEntry(String concern, ProblemEntry problemEntry, ProblemConcernStatusCode concernStatus) {
		super(concern, problemEntry, concernStatus);
	}

	/**
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer HistoryOfPastIllnessSection hinzugefügt werden.</div>
	 * 
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 * 
	 * @param concern
	 *            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *            <div class="fr">Le nom du problème (texte libre)</div>
	 * @param problemConcernStatus
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
	public PastProblemConcernEntry(String concern,
			ProblemEntry problemEntry, ProblemConcernStatusCode problemConcernStatus, Date begin, Date end) {
		super(concern,problemEntry, problemConcernStatus, begin, end);
	}
}
