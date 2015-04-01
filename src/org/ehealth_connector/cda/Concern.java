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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 * <div class="de">Klasse ConcernEntry.</div> <div class="fr"></div> <div
 * class="it"></div>
 */
public class Concern {

	/** The m concern entry. */
	org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry mConcernEntry;

	/**
	 * Instantiates a new concern entry.
	 */
	public Concern() {
		mConcernEntry = IHEFactory.eINSTANCE.createConcernEntry().init();
		mConcernEntry.setCode(Util.createCENullFlavorUNK());
	}

	/**
	 * Instantiates a new concern entry.
	 * 
	 * @param concernEntry
	 * <br>
	 *          <div class="de"> concern entry</div> <div class="fr"></div> <div
	 *          class="it"></div>
	 */
	public Concern(org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry concernEntry) {
		mConcernEntry = concernEntry;
	}

	/**
	 * Adds the id.
	 * 
	 * @param id
	 *          the new id
	 */
	public void addId(Identificator id) {
		II ii = Util.createUuidVacdIdentificator(id);
		mConcernEntry.getIds().add(ii);
	}

	/**
	 * Gibt das Leiden zurück.
	 * 
	 * @return the concern
	 */
	public String getConcern() {
		if (mConcernEntry.getText() != null) {
			return mConcernEntry.getText().getText();
		} else
			return null;
	}

	/**
	 * Gibt das Ende des Leidens zurück.
	 * 
	 * @return Ende des Leidens
	 */
	public String getEnd() {
		return Util.createEurDateStrFromTS(copyMdhtConcernEntry().getEffectiveTime().getHigh()
				.getValue());
	}

	/**
	 * Gets the ids.
	 * 
	 * @return the id
	 */
	public ArrayList<Identificator> getIds() {
		return Util.convertIds(mConcernEntry.getIds());
	}

	/**
	 * Gets the mdht concern.
	 * 
	 * @return the mdht concern
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry getMdhtConcern() {
		return mConcernEntry;
	}

	/**
	 * Gibt den Beginn des Leidens zurück.
	 * 
	 * @return Beginn des Leidens
	 */
	public String getStart() {
		return Util.createEurDateStrFromTS(copyMdhtConcernEntry().getEffectiveTime().getLow()
				.getValue());
	}

	/**
	 * Gibt den Status (aktiv/inaktiv/...) des Leidens zurück
	 * 
	 * @return Status des Leidens
	 */
	public ProblemConcernStatusCode getStatus() {
		return ProblemConcernStatusCode.getEnum(mConcernEntry.getStatusCode().getCode());
	}

	/**
	 * Setzt das Leiden.
	 * 
	 * @param concern
	 *          Leiden
	 */
	public void setConcern(String concern) {
		// Create and set the concern as freetext
		ED concernText = DatatypesFactory.eINSTANCE.createED(concern);
		mConcernEntry.setText(concernText);
	}

	/**
	 * Setzt das Ende des Leidens.
	 * 
	 * @param endOfConcern
	 *          Ende des Leidens
	 */
	public void setEnd(Date endOfConcern) {
		try {
			if (mConcernEntry.getEffectiveTime() == null) {
				mConcernEntry.setEffectiveTime(DateUtil.createIVL_TSFromEuroDateTime(endOfConcern));
			}
			mConcernEntry.getEffectiveTime().setHigh(DateUtil.createIVXB_TSFromDate(endOfConcern));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Setzt den Beginn des Leidens.
	 * 
	 * @param startOfConcern
	 *          Beginn des Leidens
	 */
	public void setStart(Date startOfConcern) {
		try {
			if (mConcernEntry.getEffectiveTime() == null) {
				mConcernEntry.setEffectiveTime(DateUtil.createIVL_TSFromEuroDateTime(startOfConcern));
			}
			mConcernEntry.getEffectiveTime().setLow(DateUtil.createIVXB_TSFromDate(startOfConcern));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Setzt den Status (aktiv/inaktiv/...) des Leidens. <br>
	 * Bei einem Aktiven Leiden (@see
	 * org.ehealth_connector.cda.ActiveProblemConcern) muss entweder completed,
	 * aborted, active, suspended gesetzt werden (bei den letzten beiden MUSS die
	 * setEnd-Methode verwendet werden. <br>
	 * Bei einem vergangenen Leiden (@see
	 * org.ehealth_connector.cda.PastProblemConcern) muss entweder completed,
	 * aborted gesetzt werden. Es MUSS die setEnd-Methode verwendet werden.<br>
	 * 
	 * @param concernStatus
	 *          Status
	 */
	public void setStatus(ProblemConcernStatusCode concernStatus) {
		mConcernEntry.setStatusCode(concernStatus.getCS());
	}

	protected void setEffectiveTime(Date begin, Date end) {
		try {
			mConcernEntry.setEffectiveTime(DateUtil.createIVL_TSFromEuroDate(begin, end));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry copyMdhtConcernEntry() {
		return EcoreUtil.copy(mConcernEntry);
	}
}
