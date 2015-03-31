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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.CdaCh;
import org.ehealth_connector.cda.ch.enums.MedicationsSpecialConditions;
import org.ehealth_connector.cda.enums.StatusCode;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Util;
import org.ehealth_connector.common.Value;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ch.CDACHMSETBodyImmunizationL3Reason;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ihe.Comment;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

/**
 * Dieses Element enthält den empfohlenen Impfplan für den Patienten. Zudem kann
 * zur Begründung ein Verweis auf entsprechende Guidelines angegeben werden.
 * Dieses Kapitel ist KONDITIONAL und nur dann erforderlich, wenn es sich beim
 * Dokument um die Antwort aus einem Expertensystem für Impfempfehlungen handelt
 * (Clinical Decision Support System; CDSS) oder wenn beabsichtigte aber noch
 * nicht erfolgte Impfungen dokumentiert werden.
 */
public class ImmunizationRecommendation {

	private final org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation mImmunizationRecommendation;

	/**
	 * Instantiates a new immunization recommendation.
	 */
	public ImmunizationRecommendation() {
		mImmunizationRecommendation = CHFactory.eINSTANCE
				.createImmunizationRecommendation().init();

		// Fix the TemplateID Extension of the CDA-CH.Body.MediL3 Template
		List<II> templateIds = mImmunizationRecommendation.getTemplateIds();
		for (II templateId : templateIds) {
			if (templateId.getRoot().equals(CdaCh.OID_V1)) {
				templateId.setExtension("CDA-CH.Body.MediL3");
			}
		}

		// Set the null values
		mImmunizationRecommendation.setPriorityCode(Util
				.createCENullFlavorUNK());
		mImmunizationRecommendation.setRouteCode(Util.createCENullFlavorUNK());
		mImmunizationRecommendation.setDoseQuantity(Util
				.createIVL_PQNullFlavorUNK());
		mImmunizationRecommendation.setRateQuantity(Util
				.createIVL_PQNullFlavorUNK());

		mImmunizationRecommendation.setMoodCode(x_DocumentSubstanceMood.PRP);
		mImmunizationRecommendation.setNegationInd(false);
	}

	/**
	 * Sets a special code that explains the absence of immunizations in this
	 * document
	 * 
	 * @param specialCode
	 *            expresses a special condition for this element
	 */
	public void setCode(MedicationsSpecialConditions specialCode) {
		mImmunizationRecommendation.setCode(specialCode.getCD());
		mImmunizationRecommendation.setStatusCode(StatusCode.ACTIVE.getCS());
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(NullFlavor.UNK);
		mImmunizationRecommendation.setPriorityCode(ce);
		mImmunizationRecommendation.setDoseQuantity(Util
				.createIVL_PQNullFlavorUNK());
		mImmunizationRecommendation.getEffectiveTimes().add(
				DateUtil.createSTCM_TS(new Date()));
		mImmunizationRecommendation.getIds().add(Util.createUuidVacd(null));
		Consumable c = new Consumable(false);
		setConsumable(c);
	}

	/**
	 * Erzeugt ein Objekt welches eine Impfempfehlung repräsentiert. Dieses
	 * Objekt kann einer ImmunizationRecommendationsSection hinzugefügt werden.
	 * 
	 * @param consumable
	 *            Impfstoff, der empfohlen wird
	 * @param author
	 *            Arzt, der diese Eintragung veranlasst hat
	 * @param startOfPossibleAppliance
	 *            Beginn des Zeitraumes, in dem die Impfung erfolgen sollte
	 * @param endOfPossibleAppliance
	 *            Ende des Zeitraumes, in dem die Impfung erfolgen sollte
	 * @param intendedOrProposed
	 *            true, bei einer beabsichtigten, aber noch nicht erfolgten
	 *            Impfung (intended). false bei einer vorgeschlagenen Impfung
	 *            (proposed).
	 * @param shallNotBeAdministerd
	 *            true, wenn die Impfung nicht verabreicht werden soll. false,
	 *            wenn die Impfung zu verabreichen ist.
	 */
	public ImmunizationRecommendation(Consumable consumable,
			org.ehealth_connector.common.Author author,
			Date startOfPossibleAppliance, Date endOfPossibleAppliance,
			boolean intendedOrProposed, boolean shallNotBeAdministerd) {

		this();
		if (intendedOrProposed) {
			setIntended();
		} else {
			setProposed();
		}

		// Set the Attributes of this class
		addId(null);
		setShallNotBeAdministerd(shallNotBeAdministerd);
		setPossibleAppliance(startOfPossibleAppliance, endOfPossibleAppliance);
		setAuthor(author);
		setConsumable(consumable);
	}

	/**
	 * Instantiates a new immunization recommendation.
	 * 
	 * @param immunizationRecommendation
	 * <br>
	 *            <div class="de">Impfempfehlung</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public ImmunizationRecommendation(
			org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation immunizationRecommendation) {
		mImmunizationRecommendation = immunizationRecommendation;
	}

	/**
	 * Adds the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void addId(Identificator id) {
		II ii = Util.createUuidVacdIdentificator(id);
		mImmunizationRecommendation.getIds().add(ii);
	}

	/**
	 * Adds the reason for the immunization recommendeation (the BAG Guideline)
	 * 
	 * @param reason
	 *            the reason
	 */
	public void addReason(Reason reason) {
		mImmunizationRecommendation.addObservation(reason
				.copyMdhtCDACHMSETBodyImmunizationL3Reason());
		mImmunizationRecommendation
				.getEntryRelationships()
				.get(mImmunizationRecommendation.getEntryRelationships().size() - 1)
				.setTypeCode(x_ActRelationshipEntryRelationship.RSON);
		mImmunizationRecommendation
				.getEntryRelationships()
				.get(mImmunizationRecommendation.getEntryRelationships().size() - 1)
				.setInversionInd(false);
	}

	/**
	 * Gets a list of reasons for the immunizationRecommendation (typically a
	 * reference to an external BAG document)).
	 * 
	 * @return A ArrayList of Resons
	 * 
	 */
	public ArrayList<Reason> getReasons() {
		ArrayList<Reason> cl = new ArrayList<Reason>();
		EList<CDACHMSETBodyImmunizationL3Reason> erl = mImmunizationRecommendation
				.getCDACHMSETBodyImmunizationL3Reasons();
		for (CDACHMSETBodyImmunizationL3Reason er : erl) {
			cl.add(new Reason(er));
		}
		return cl;
	}

	/**
	 * <div class="de">Copy mdht immunization recommendation.</div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @return the org.openhealthtools.mdht.uml.cda.ch. immunization
	 *         recommendation
	 */
	public org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation copyMdhtImmunizationRecommendation() {
		return EcoreUtil.copy(mImmunizationRecommendation);
	}

	/**
	 * Gets the author.
	 * 
	 * @return the author
	 */
	public org.ehealth_connector.common.Author getAuthor() {
		try {
			org.openhealthtools.mdht.uml.cda.Author author = EcoreUtil
					.copy(mImmunizationRecommendation.getAuthors().get(0));
			return new Author(author);
		} catch (IndexOutOfBoundsException e) {
			// no author available
			return null;
		}
	}

	/**
	 * Gets the reference to the comment in the level 2 section text.
	 * 
	 * @return the reference of the level 3 comment entry, which point to the
	 *         level 2 text
	 */
	public String getCommentRef() {
		return Util.getCommentRef(mImmunizationRecommendation
				.getEntryRelationships());
	}

	/**
	 * Gets the text of the comment text element (this is not necessarily the
	 * comment itself)
	 * 
	 * @return the comment text
	 */
	public String getCommentText() {
		return Util.getCommentText(mImmunizationRecommendation
				.getEntryRelationships());
	}

	/**
	 * Gets the consumable.
	 * 
	 * @return the consumable
	 */
	public Consumable getConsumable() {
		if (mImmunizationRecommendation.getConsumable() != null) {
			Consumable consumable = new Consumable(
					mImmunizationRecommendation.getConsumable());
			return consumable;
		} else {
			return null;
		}
	}

	/**
	 * Gibt die Dosis der Impfung zurück.
	 * 
	 * @return Dosis Dosis der Impfung
	 */
	public Value getDosage() {
		if (mImmunizationRecommendation.getDoseQuantity() != null) {
			Value value = new Value(
					mImmunizationRecommendation.getDoseQuantity());
			return value;
		}
		return null;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Identificator getId() {
		Identificator id = new Identificator(mImmunizationRecommendation
				.getIds().get(0));
		return id;
	}

	/**
	 * <div class="de">Liefert die Information, ob eine Impfung beabsichtigt,
	 * aber noch nicht erfolgt ist (moodCode:INT).</div> <div class="fr"></div>
	 * <div class="it"></div>
	 * 
	 * @return true, wenn eine Impfung beabsichtigt, aber noch nicht erfolgt
	 *         ist. Sonst: false
	 */
	public boolean getIntended() {
		if (mImmunizationRecommendation.getMoodCode().equals(
				x_DocumentSubstanceMood.INT))
			return true;
		else
			return false;
	}

	/**
	 * Gets the mdht immunization recommendation.
	 * 
	 * @return the mdht immunization recommendation
	 */
	public org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation getMdhtImmunizationRecommendation() {
		return mImmunizationRecommendation;
	}

	/**
	 * <div class="de">Liefert, den Zeitraum, in dem die Impfung verabreicht
	 * werden soll als String (z.B. "01.01.2015 - 01.03.1015")</div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @return <div class="de">Zeitraum, in dem die Impfung verabreicht werden
	 *         soll als String</div> <div class="fr"></div> <div
	 *         class="it"></div>
	 */
	public String getPossibleAppliance() {
		List<SXCM_TS> effectiveTimes = mImmunizationRecommendation
				.getEffectiveTimes();
		return DateUtil.convertSXCM_TSToEurString(effectiveTimes);
	}

	/**
	 * <div class="de">Liefert, die Information, ob eine Impfung vorgeschlagen
	 * ist (moodCode:PRP).</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return true, wenn eine Impfung vorgeschlagen ist. Sonst: false
	 */
	public boolean getProposed() {
		if (mImmunizationRecommendation.getMoodCode().equals(
				x_DocumentSubstanceMood.PRP))
			return true;
		else
			return false;
	}

	/**
	 * <div class="de">Gibt an, ob eine Impfung nicht verabreicht werden
	 * soll.</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return true, wenn die Impfung nicht verabreicht werden soll, sonst false
	 */
	public boolean gettShallNotBeAdministerd() {
		return mImmunizationRecommendation.getNegationInd();
	}

	/**
	 * Sets the author.
	 * 
	 * @param author
	 *            the new author
	 */
	public void setAuthor(org.ehealth_connector.common.Author author) {
		mImmunizationRecommendation.getAuthors().clear();
		org.openhealthtools.mdht.uml.cda.Author immmunizationAuthor = author
				.copyMdhtAuthor();
		// Remove author function Code if present
		if (immmunizationAuthor.getFunctionCode() != null) {
			CE ce = null;
			immmunizationAuthor.setFunctionCode(ce);
		}
		mImmunizationRecommendation.getAuthors().add(immmunizationAuthor);
	}

	/**
	 * Sets a comment text
	 * 
	 * @param text
	 *            the text
	 */
	public void setCommentText(String text) {
		Comment mComment = IHEFactory.eINSTANCE.createComment().init();
		ED ed = DatatypesFactory.eINSTANCE.createED();
		ed.addText(text);
		mComment.setText(ed);
		mImmunizationRecommendation.addAct(mComment);

		EntryRelationship er = mImmunizationRecommendation
				.getEntryRelationships().get(
						mImmunizationRecommendation.getEntryRelationships()
								.size() - 1);
		er.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
		er.setInversionInd(true);
	}

	/**
	 * Sets the consumable.
	 * 
	 * @param consumable
	 *            the new consumable
	 */
	public void setConsumable(Consumable consumable) {
		mImmunizationRecommendation.setConsumable(consumable
				.copyMdhtConsumable());
	}

	/**
	 * Sets the dosage.
	 * 
	 * @param doseQuantity
	 *            the new dosage (use null, if not asked)
	 */
	public void setDosage(Double doseQuantity) {
		if (doseQuantity == null) {
			mImmunizationRecommendation.setDoseQuantity(Util
					.createIVL_PQNullFlavorNA());
		} else {
			IVL_PQ ivl_pq = DatatypesFactory.eINSTANCE.createIVL_PQ();
			ivl_pq.setUnit("ml");
			ivl_pq.setValue(doseQuantity);
			mImmunizationRecommendation.setDoseQuantity(ivl_pq);
		}
	}

	/**
	 * <div class="de">Setzt, die Information, dass eine Impfung beabsichtigt,
	 * aber noch nicht erfolgt ist (moodCode:INT).</div> <div class="fr"></div>
	 * <div class="it"></div>
	 * 
	 */
	public void setIntended() {
		mImmunizationRecommendation.setMoodCode(x_DocumentSubstanceMood.INT);
	}

	/**
	 * <div class="de">Setzt, den Zeitraum, in dem die Impfung verabreicht
	 * werden soll.</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param startOfPossibleAppliacne
	 * <br>
	 *            <div class="de">Startpunkt des Zeitraumes, wann die Impfung
	 *            verabreicht werden soll.</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param endOfPossibleAppliance
	 *            <div class="de">Endpunkt des Zeitraumes, wann die Impfung
	 *            verabreicht werden soll.</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public void setPossibleAppliance(Date startOfPossibleAppliacne,
			Date endOfPossibleAppliance) {
		mImmunizationRecommendation.getEffectiveTimes().add(
				0,
				DateUtil.createSTCM_TS(startOfPossibleAppliacne,
						endOfPossibleAppliance));
	}

	/**
	 * <div class="de">Setzt, die Information, dass eine Impfung vorgeschlagen
	 * ist (moodCode:PRP).</div> <div class="fr"></div> <div class="it"></div>
	 */
	public void setProposed() {
		mImmunizationRecommendation.setMoodCode(x_DocumentSubstanceMood.PRP);
	}

	/**
	 * <div class="de">Gibt an, ob eine Impfung nicht verabreicht werden
	 * soll.</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param shallNotBeAdministerd
	 *            <div class="de">true, wenn die Impfung nicht verabreicht
	 *            werden soll, sonst false</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public void setShallNotBeAdministerd(boolean shallNotBeAdministerd) {
		if (shallNotBeAdministerd) {
			mImmunizationRecommendation.setNegationInd(true);
		} else {
			mImmunizationRecommendation.setNegationInd(false);
		}
	}

}
