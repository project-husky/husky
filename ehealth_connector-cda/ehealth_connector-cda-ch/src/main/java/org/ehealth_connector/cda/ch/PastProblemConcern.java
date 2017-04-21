/*
 * 
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 * 
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 * 
 * This code is made available under the terms of the Eclipse Public License v1.0.
 * 
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 * 
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 * 
 */

package org.ehealth_connector.cda.ch;

import java.util.Date;

import org.ehealth_connector.cda.AbstractProblemEntry;
import org.ehealth_connector.cda.enums.ProblemConcernStatusCode;

/**
 * <div class="en">A past problem concern</div> <div class="de">Ein
 * gesundheitliches Leiden</div> <div class="fr">Une souffrance de la
 * santé</div>.
 */
public class PastProblemConcern extends ProblemConcern {

	/**
	 * <div class="en">Creates an object, which represents a problem
	 * concern.</div> <div class="de">Erzeugt ein Objekt welches ein Leiden
	 * repräsentiert. Dieses Objekt kann einer HistoryOfPastIllnessSection
	 * hinzugefügt werden.</div>
	 *
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 */
	public PastProblemConcern() {
		super();
		addId(null);
	}

	/**
	 * <div class="en">Creates an object, which represents a problem
	 * concern.</div> <div class="de">Erzeugt ein Objekt welches ein Leiden
	 * repräsentiert. Dieses Objekt kann einer HistoryOfPastIllnessSection
	 * hinzugefügt werden.</div>
	 *
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 *
	 * @param problemConcernEntry
	 *            <div class="en">existing object, which should be cloned</div>
	 *            <div class="de">Vorbestehendes Objekt, das geklont werden
	 *            soll</div> <div class="fr">Objet préexistante à cloner</div>
	 *
	 */
	public PastProblemConcern(
			org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntry) {
		super(problemConcernEntry);
	}

	/**
	 * <div class="en">Creates an object, which represents a problem
	 * concern.</div><div class="de">Erzeugt ein Objekt welches ein Leiden
	 * repräsentiert. Dieses Objekt kann einer HistoryOfPastIllnessSection
	 * hinzugefügt werden.</div> <div class="fr">Crée un objet qui représente un
	 * problème. L'objet peut être ajouté dans ActiveProblemsSection.</div>
	 *
	 * @param concern
	 *            <div class="en">the concern as free text</div>
	 *            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *            <div class="fr">Le nom du problème (texte libre)</div>
	 * @param problemEntry
	 *            <div class="en">problem entry object</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param concernStatus
	 *            <div class="en">Status of the concern
	 *            (active/supended/aborted/completed)</div> <div class="de">Der
	 *            Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 */
	public PastProblemConcern(String concern, AbstractProblemEntry problemEntry,
			ProblemConcernStatusCode concernStatus) {
		super(concern, problemEntry, concernStatus);
	}

	/**
	 * <div class="en">Creates an object, which represents a problem
	 * concern.</div> <div class="de">Erzeugt ein Objekt welches ein Leiden
	 * repräsentiert. Dieses Objekt kann einer HistoryOfPastIllnessSection
	 * hinzugefügt werden.</div>
	 *
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 *
	 * @param concern
	 *            <div class="en">the concern as free text</div>
	 *            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *            <div class="fr">Le nom du problème (texte libre)</div>
	 * @param problemEntry
	 *            <div class="en">problem entry object</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param concernStatus
	 *            <div class="en">Status of the concern
	 *            (active/supended/aborted/completed)</div> <div class="de">Der
	 *            Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 * @param begin
	 *            <div class="en">start of concern</div><div class="de">Beginn
	 *            des Leidens</div> <div class="fr">Le début du problème</div>
	 * @param end
	 *            <div class="e ncern</div><div class="de">Ende des
	 *            Leidens</div> <div class="fr">Le fin du problème</div>
	 */
	public PastProblemConcern(String concern, AbstractProblemEntry problemEntry,
			ProblemConcernStatusCode concernStatus, Date begin, Date end) {
		super(concern, problemEntry, concernStatus, begin, end);
	}
}
