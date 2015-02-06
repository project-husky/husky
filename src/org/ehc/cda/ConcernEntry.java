package org.ehc.cda;

import java.text.ParseException;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.ch.enums.ProblemConcernStatusCode;
import org.ehc.common.DateUtil;
import org.ehc.common.Identificator;
import org.ehc.common.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

public class ConcernEntry {
	org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry mConcernEntry;

	public ConcernEntry () {
		mConcernEntry = IHEFactory.eINSTANCE.createConcernEntry().init();
	}
	
	public ConcernEntry (org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry concernEntry) {
		mConcernEntry = concernEntry;
	}

	private org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry copyMdhtConcernEntry() {
		return EcoreUtil.copy(mConcernEntry);
	}

	/**
	 * Gibt das Leiden zurück
	 * 
	 */
	public String getConcern() {
		if (mConcernEntry.getText() != null) {
			return mConcernEntry.getText().getText();
		}
		else return null;
	}

	/**
	 * Gibt das Ende des Leidens zurück
	 * 
	 * @return Ende des Leidens
	 */
	public String getEnd() {
		return Util.createEurDateStrFromTS(copyMdhtConcernEntry()
				.getEffectiveTime().getHigh().getValue());
	}

	public Identificator getId() {
		Identificator id = new Identificator(mConcernEntry.getIds().get(0).getRoot(), mConcernEntry.getIds().get(0).getExtension());
		return id;
	}

	public org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry getMdhtConcern() {
		return this.mConcernEntry;
	}

	/**
	 * Gibt den Beginn des Leidens zurück
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
	public String getStatus() {
		//TODO map the String to an enum 
		return mConcernEntry.getStatusCode().getCode();
	}

	/**
	 * Setzt das Leiden
	 * 
	 * @param concern
	 *            Leiden
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
	 * Setzt das Ende des Leidens
	 * 
	 * @param endOfConcern
	 *            Ende des Leidens
	 */
	public void setEnd(Date endOfConcern) {
		try {
			mConcernEntry.getEffectiveTime().setHigh(
					DateUtil.createIVXB_TSFromDate(endOfConcern));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void setId(Identificator id) {
		II ii = Util.createUuidVacdIdentificator(id);
		mConcernEntry.getIds().add(ii);
	}
	
	/**
	 * Setzt den Beginn des Leidens
	 * 
	 * @param startOfConcern
	 *            Beginn des Leidens
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
