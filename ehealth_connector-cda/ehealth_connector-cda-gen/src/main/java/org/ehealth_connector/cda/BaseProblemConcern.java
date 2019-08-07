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

package org.ehealth_connector.cda;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.enums.ProblemConcernStatusCode;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.IdentityDomain;
import org.ehealth_connector.common.utils.DateUtilMdht;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * <div class="en">A medical concern</div> <div class="de">Ein gesundheitliches
 * Leiden</div> <div class="fr">Une souffrance de la santé</div>.
 */
public class BaseProblemConcern
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry> {

	/**
	 * Instantiates a new problem concern entry.
	 */
	public BaseProblemConcern() {
		super(IHEFactory.eINSTANCE.createProblemConcernEntry().init());
	}

	/**
	 * <div class="en">Creates a medical concern object</div>
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
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
	public BaseProblemConcern(
			org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry problemConcernEntry) {
		super(problemConcernEntry);
	}

	/**
	 * <div class="en">Creates a medical concern object</div>
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
	 *
	 * <div class="fr">Crée un objet qui représente un problème. L'objet peut
	 * être ajouté dans ActiveProblemsSection.</div>
	 *
	 * @param concern
	 *            <div class="en">the concern as free text</div>
	 *            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *            <div class="de">Die Bezeichnung des Leidens (Freitext)</div>
	 *            <div class="fr">Le nom du problème (texte libre)</div>
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
	public BaseProblemConcern(String concern, BaseProblemEntry problemEntry,
			org.ehealth_connector.cda.enums.ProblemConcernStatusCode concernStatus) {
		super(IHEFactory.eINSTANCE.createProblemConcernEntry().init());

		setConcern(concern);
		addProblemEntry(problemEntry);
		setStatus(concernStatus);
		setEffectiveTime(new Date(), null);
		addId(null);
	}

	/**
	 * <div class="en">Creates a medical concern object</div>
	 * <div class="de">Erzeugt ein Objekt welches ein Leiden repräsentiert.
	 * Dieses Objekt kann einer ActiveProblemsSection hinzugefügt werden.</div>
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
	 *            <div class="de"></div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param concernStatus
	 *            <div class="en">status code of the concern
	 *            (active/suspended/aborted/completed)</div> <div class="de">Der
	 *            Status Code des Leidens
	 *            (active/suspended/aborted/completed)</div> <div class="fr">Le
	 *            statut du problème (active/suspended/aborted/completed)</div>
	 * @param start
	 *            <div class="en">start of concern</div> <div class="de">Beginn
	 *            des Leidens</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param end
	 *            <div class="en">end of concern</div> <div class="de">Ende des
	 *            Leidens</div> <div class="fr">Le fin du problème</div>
	 */
	public BaseProblemConcern(String concern, BaseProblemEntry problemEntry,
			ProblemConcernStatusCode concernStatus, Date start, Date end) {
		this(concern, problemEntry, concernStatus);
		setEffectiveTime(start, end);
	}

	/**
	 * Adds the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void addId(Identificator id) {
		getConcernEntry().getIds().add(id.getIi());
	}

	/**
	 * <div class="en">Adds a medical problem to the medical concern</div>
	 * <div class="de">Fügt dem Leiden ein medizinisches ProblemEntry
	 * hinzu.</div>
	 *
	 * @param problemEntry
	 *            <div class="en">the problem</div>
	 *
	 */
	public void addProblemEntry(BaseProblemEntry problemEntry) {
		this.getMdht().addObservation(problemEntry.copy());
		for (Observation obs : this.getMdht().getObservations()) {
			if (obs.getIds().isEmpty())
				obs.getIds().add(CdaUtil.createUniqueIi());
		}
		final EList<EntryRelationship> entryRel = this.getMdht().getEntryRelationships();
		// Set the Attributes of the last added element
		entryRel.get(entryRel.size() - 1).setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		entryRel.get(entryRel.size() - 1).setInversionInd(false);
	}

	private org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry copyMdhtConcernEntry() {
		return EcoreUtil.copy(getConcernEntry());
	}

	/**
	 * <div class="en">Gets a copy of the mdht problem concern entry</div>
	 * <div class="de"></div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the org.openhealthtools.mdht.uml.cda.ihe. problem concern entry
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry copyMdhtProblemConcernEntry() {
		return EcoreUtil.copy(this.getMdht());
	}

	/**
	 * <div class="en">Gets the Concern</div> <div class="de">Gibt das Leiden
	 * zurück.</div>
	 *
	 * @return the concern
	 */
	public String getConcern() {
		if (getConcernEntry().getText() != null) {
			return getConcernEntry().getText().getText();
		} else {
			return null;
		}
	}

	/**
	 * Method to get
	 *
	 * @return the mConcernEntry
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry getConcernEntry() {
		return this.getMdht();
	}

	/**
	 * <div class="en">Gets the end of the concern</div> <div class="de">Gibt
	 * das Ende des Leidens zurück.</div>
	 *
	 * @return Ende des Leidens
	 */
	public String getEnd() {
		return Util.createEurDateStrFromTS(
				copyMdhtConcernEntry().getEffectiveTime().getHigh().getValue());
	}

	/**
	 * Gets the specified id value based on its code system.
	 *
	 * @param codeSystem
	 *            id's identity domain
	 * @return the id or null if it doesn't exist
	 */
	public Identificator getId(IdentityDomain codeSystem) {
		Identificator ident = null;
		for (final II id : getConcernEntry().getIds()) {
			if (id.getRoot().equalsIgnoreCase(codeSystem.getCodeSystemId())) {
				ident = new Identificator(id);
			}
		}
		return ident;
	}

	/**
	 * <div class="en">Gets the ids.</div>
	 *
	 * @return the id
	 */
	public List<Identificator> getIds() {
		return Util.convertIds(getConcernEntry().getIds());
	}

	/**
	 * Gets the mdht concern.
	 *
	 * @return the mdht concern
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry getMdhtConcern() {
		return getConcernEntry();
	}

	/**
	 * Gets the mdht problem concern entry.
	 *
	 * @return the mdht problem concern entry
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.ProblemConcernEntry getMdhtProblemConcernEntry() {
		return this.getMdht();
	}

	/**
	 * <div class="en">Gets all medical problems related to this problem
	 * conern</div><div class="de">Gibt alle zu dem Leiden zugehörigen
	 * medizinischen Probleme zurück</div>
	 *
	 * @return the problem entries
	 */
	public List<BaseProblemEntry> getProblemEntries() {
		final List<BaseProblemEntry> pel = new ArrayList<BaseProblemEntry>();
		for (final org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry mAllergy : getMdhtProblemConcernEntry()
				.getProblemEntries()) {
			final BaseProblemEntry problem = new BaseProblemEntry(mAllergy);
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
	public BaseProblemEntry getProblemEntry() {
		final BaseProblemEntry problemEntry = new BaseProblemEntry(
				copyMdhtProblemConcernEntry().getProblemEntries().get(0));
		return problemEntry;
	}

	/**
	 * <div class="en">Gets the begin of the concern</div> <div class="de">Gibt
	 * den Beginn des Leidens zurück.</div>
	 *
	 * @return <div class="en">start of concern</div><div class="de">Beginn des
	 *         Leidens</div>
	 */
	public String getStart() {
		return Util.createEurDateStrFromTS(
				copyMdhtConcernEntry().getEffectiveTime().getLow().getValue());
	}

	/**
	 * <div class="en">Gets the status (active/inactive/complete...) of the
	 * concern</div> <div class="de">Gibt den Status (aktiv/inaktiv/...) des
	 * Leidens zurück</div>
	 *
	 * @return <div class="en">status of the concern</div><div class="de">Status
	 *         des Leidens</div>
	 */
	public ProblemConcernStatusCode getStatus() {
		return ProblemConcernStatusCode.getEnum(getConcernEntry().getStatusCode().getCode());
	}

	/**
	 * <div class="en">Sets the Concern</div> <div class="de">Setzt das
	 * Leiden.</div>
	 *
	 * @param concern
	 *            <div class="en">Concern</div><div class="de">Leiden</div>
	 */
	public void setConcern(String concern) {
		// Create and set the concern as freetext
		final ED concernText = DatatypesFactory.eINSTANCE.createED(concern);
		getConcernEntry().setText(concernText);
	}

	protected void setEffectiveTime(Date begin, Date end) {
		try {
			getConcernEntry().setEffectiveTime(DateUtilMdht.createIVL_TSFromEuroDate(begin, end));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <div class="en">Sets the end of the concern</div> <div class="de">Setzt
	 * das Ende des Leidens.</div>
	 *
	 * @param endOfConcern
	 *            <div class="en">End of concern</div><div class="de">Ende des
	 *            Leidens</div>
	 */
	public void setEnd(Date endOfConcern) {
		try {
			if (getConcernEntry().getEffectiveTime() == null) {
				getConcernEntry()
						.setEffectiveTime(DateUtilMdht.createIVL_TSFromEuroDateTime(endOfConcern));
			}
			getConcernEntry().getEffectiveTime()
					.setHigh(DateUtilMdht.createIVXB_TSFromDate(endOfConcern));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * one id can be provided for retraceability
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Identificator id) {
		this.getMdht().getIds().clear();
		if (id != null) {
			this.getMdht().getIds().add(id.getIi());
		}
	}

	/**
	 * <div class="en">Sets the begin of the Concern</div><div class="de">Setzt
	 * den Beginn des Leidens.</div>
	 *
	 * @param startOfConcern
	 *            <div class="en">Start of concern</div><div class="de">Beginn
	 *            des Leidens</div>
	 */
	public void setStart(Date startOfConcern) {
		try {
			if (getConcernEntry().getEffectiveTime() == null) {
				getConcernEntry()
						.setEffectiveTime(DateUtilMdht.createIVL_TSFromEuroDateTime(startOfConcern));
			}
			getConcernEntry().getEffectiveTime()
					.setLow(DateUtilMdht.createIVXB_TSFromDate(startOfConcern));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <div class="en">Sets the status of the concern
	 * (active/inactive/completed). In case of an active concern (@see
	 * org.ehealth_connector.cda.ActiveProblemConcern) you HAVE to set either
	 * completed, aborted, active, suspended and you HAVE to use the setEnd
	 * method. In case of a past problem conern (@see
	 * org.ehealth_connector.cda.PastProblemConcern) you HAVE to set completed
	 * or aborted and you HAVE to use the setEnd Method </div> <div class="de">
	 * Setzt den Status (aktiv/inaktiv/...) des Leidens. <br>
	 * Bei einem Aktiven Leiden (@see
	 * org.ehealth_connector.cda.ActiveProblemConcern) muss entweder completed,
	 * aborted, active, suspended gesetzt werden (bei den letzten beiden MUSS
	 * die setEnd-Methode verwendet werden. <br>
	 * Bei einem vergangenen Leiden (@see
	 * org.ehealth_connector.cda.PastProblemConcern) muss entweder completed,
	 * aborted gesetzt werden. Es MUSS die setEnd-Methode verwendet werden.<br>
	 * </div>
	 *
	 * @param concernStatus
	 *            Status
	 */
	public void setStatus(ProblemConcernStatusCode concernStatus) {
		getConcernEntry().setStatusCode(concernStatus.getCS());
	}

}
