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
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.ProblemConcernStatusCode;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Util;
import org.ehealth_connector.common.enums.IdentityDomain;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 * <div class="en">(Internal) class for concern entries</div> <div
 * class="de">Klasse ConcernEntry.</div> <div class="fr"></div> <div
 * class="it"></div>
 */
public class Concern {

	/** The m concern entry. */
	private org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry mConcernEntry;

	/**
	 * Instantiates a new concern entry.
	 */
	public Concern() {
		setConcernEntry(IHEFactory.eINSTANCE.createConcernEntry().init());
		getConcernEntry().setCode(Util.createCENullFlavorUNK());
	}

	/**
	 * Instantiates a new concern entry.
	 * 
	 * @param concernEntry
	 * <br>
	 *            <div class="de"> concern entry</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Concern(org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry concernEntry) {
		setConcernEntry(concernEntry);
	}

	/**
	 * Adds the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void addId(Identificator id) {
		final II ii = Util.createUuidVacdIdentificator(id);
		getConcernEntry().getIds().add(ii);
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
	 * <div class="en">Gets the end of the concern</div> <div class="de">Gibt
	 * das Ende des Leidens zurück.</div>
	 * 
	 * @return Ende des Leidens
	 */
	public String getEnd() {
		return Util.createEurDateStrFromTS(copyMdhtConcernEntry().getEffectiveTime().getHigh()
				.getValue());
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
	 * Gets the specified id value based on its code system.
	 * 
	 * @param The
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
	 * Gets the mdht concern.
	 * 
	 * @return the mdht concern
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry getMdhtConcern() {
		return getConcernEntry();
	}

	/**
	 * <div class="en">Gets the begin of the concern</div> <div class="de">Gibt
	 * den Beginn des Leidens zurück.</div>
	 * 
	 * @return <div class="en">start of concern</div><div class="de">Beginn des
	 *         Leidens</div>
	 */
	public String getStart() {
		return Util.createEurDateStrFromTS(copyMdhtConcernEntry().getEffectiveTime().getLow()
				.getValue());
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
				getConcernEntry().setEffectiveTime(
						DateUtil.createIVL_TSFromEuroDateTime(endOfConcern));
			}
			getConcernEntry().getEffectiveTime().setHigh(
					DateUtil.createIVXB_TSFromDate(endOfConcern));
		} catch (final ParseException e) {
			e.printStackTrace();
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
				getConcernEntry().setEffectiveTime(
						DateUtil.createIVL_TSFromEuroDateTime(startOfConcern));
			}
			getConcernEntry().getEffectiveTime().setLow(
					DateUtil.createIVXB_TSFromDate(startOfConcern));
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

	protected void setEffectiveTime(Date begin, Date end) {
		try {
			getConcernEntry().setEffectiveTime(DateUtil.createIVL_TSFromEuroDate(begin, end));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to get
	 * 
	 * @return the mConcernEntry
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry getConcernEntry() {
		return mConcernEntry;
	}

	/**
	 * Method to set
	 * 
	 * @param mConcernEntry
	 *            the mConcernEntry to set
	 */
	public void setConcernEntry(org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry mConcernEntry) {
		this.mConcernEntry = mConcernEntry;
	}

	private org.openhealthtools.mdht.uml.cda.ihe.ConcernEntry copyMdhtConcernEntry() {
		return EcoreUtil.copy(getConcernEntry());
	}
}
