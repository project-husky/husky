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

import java.text.ParseException;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode;
import org.ehealth_connector.cda.ch.enums.StatusCode;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 * <div class="de">Class ConcernEntry.</div>\n
 * <div class="fr">Class ConcernEntry.</div>\n
 * <div class="it">Class ConcernEntry.</div>
 */
class ConcernEntry {
	
	/** The m concern entry. */
	org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry mConcernEntry;

	/**
	 * Instantiates a new concern entry.
	 */
	public ConcernEntry () {
		mConcernEntry = IHEFactory.eINSTANCE.createConcernEntry().init();
	}

	/**
	 * Instantiates a new concern entry.
	 *
	 * @param concernEntry <br>
	 * 		<div class="de"> concern entry</div>
	 * 		<div class="fr"> concern entry</div>
	 * 		<div class="it"> concern entry</div>
	 */
	public ConcernEntry (org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry concernEntry) {
		mConcernEntry = concernEntry;
	}

	private org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry copyMdhtConcernEntry() {
		return EcoreUtil.copy(mConcernEntry);
	}

	/**
	 * Gibt das Leiden zurück.
	 *
	 * @return the concern
	 */
	public String getConcern() {
		if (mConcernEntry.getText() != null) {
			return mConcernEntry.getText().getText();
		}
		else return null;
	}

	/**
	 * Gibt das Ende des Leidens zurück.
	 *
	 * @return Ende des Leidens
	 */
	public String getEnd() {
		return Util.createEurDateStrFromTS(copyMdhtConcernEntry()
				.getEffectiveTime().getHigh().getValue());
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Identificator getId() {
		Identificator id = new Identificator(mConcernEntry.getIds().get(0).getRoot(), mConcernEntry.getIds().get(0).getExtension());
		return id;
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
		return Util.createEurDateStrFromTS(copyMdhtConcernEntry()
				.getEffectiveTime().getLow().getValue());
	}



	/**
	 * Gibt den Status (aktiv/inaktiv/...) des Leidens zurück
	 * 
	 * @return Status des Leidens
	 */
	public StatusCode getStatus() {
		return StatusCode.getEnum(mConcernEntry.getStatusCode().getCode());
	}

	/**
	 * Setzt das Leiden.
	 *
	 * @param concern            Leiden
	 */
	public void setConcern(String concern) {
		// Create and set the concern as freetext
		ED concernText = DatatypesFactory.eINSTANCE.createED(concern);
		mConcernEntry.setText(concernText);
	}

	protected void setEffectiveTime(Date begin, Date end) {
		try {
			mConcernEntry.setEffectiveTime(DateUtil.createIVL_TSFromEuroDate(begin, end));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Setzt das Ende des Leidens.
	 *
	 * @param endOfConcern            Ende des Leidens
	 */
	public void setEnd(Date endOfConcern) {
		try {
			mConcernEntry.getEffectiveTime().setHigh(
					DateUtil.createIVXB_TSFromDate(endOfConcern));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Identificator id) {
		II ii = Util.createUuidVacdIdentificator(id);
		mConcernEntry.getIds().add(ii);
	}

	/**
	 * Setzt den Beginn des Leidens.
	 *
	 * @param startOfConcern            Beginn des Leidens
	 */
	public void setStart(Date startOfConcern) {
		try {
			mConcernEntry.getEffectiveTime().setLow(
					DateUtil.createIVXB_TSFromDate(startOfConcern));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Setzt den Status (aktiv/inaktiv/...) des Leidens
	 * 
	 * @param concernStatus
	 *            Status
	 */
	public void setStatus(ProblemConcernStatusCode concernStatus) {
		// Create and set the status code
		// TODO Prüfen, ob hier immer "completed" angegeben werden muss
		// (Implementierungsleitfaden 7.5.2.4)

		mConcernEntry.setStatusCode(concernStatus.getCS());
	}
}
