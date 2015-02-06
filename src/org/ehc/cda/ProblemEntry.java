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

import java.text.ParseException;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.common.Code;
import org.ehc.common.DateUtil;
import org.ehc.common.Util;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;

/**
 * Ein medizinisches Problem
 */
public class ProblemEntry {

	public org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry mProblemEntry;

	public ProblemEntry(Date date, Code code) {
		this(date, null, code);
	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. 
	 * Dieser Konstruktor wird verwendet, wenn der Zeitraum in dem das Problem bestand bekannt ist und das Problem als Code angegeben werden soll.
	 * Dieses Objekt kann einem ProblemConcernEntry hinzugefügt werden.
	 * 
	 * @param startOfProblem
	 *            Beginn des Problems
	 * @param endOfProblem
	 *            Ende des Problems
	 * @param problem
	 *            Freitextbeschreibung zu dem Problem oder Code zu
	 *            Komplikationsrisiken oder Expositionsrisiken.
	 */
	public ProblemEntry(Date startOfProblem,
			Date endOfProblem, org.ehc.common.Code problem) {
		this(startOfProblem, endOfProblem, problem, null);

	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. 
	 * Dieser Konstruktor wird verwendet, wenn der Zeitraum in dem das Problem bestand bekannt ist und das Problem als Code angegeben werden soll.
	 * Dieses Objekt kann einem ProblemConcernEntry hinzugefügt werden.
	 * 
	 * @param startOfProblem
	 *            Beginn des Problems
	 * @param endOfProblem
	 *            Ende des Problems
	 * @param problem
	 *            Freitextbeschreibung zu dem Problem oder Code zu
	 *            Komplikationsrisiken oder Expositionsrisiken.
	 * @param internalProblemId
	 *            Interne ID des Problems innerhalb der Akte. Steht eine solche nicht zur Verfügung dann kann ein anderer Konstruktor verwendet werden und es wird stattdesssen eine GUID durch die Convenience API generiert.
	 */
	public ProblemEntry(Date startOfProblem,
			Date endOfProblem, org.ehc.common.Code problem, String internalProblemId) {
		mProblemEntry = IHEFactory.eINSTANCE.createProblemEntry().init();
		setProblemNotOccured(false);
		try {
			setStartOfProblem(startOfProblem);
			setEndOfProblem(endOfProblem);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		setInternalId(internalProblemId);
		setValue(problem);
	}

	/**
	 * @param observation
	 */
	public ProblemEntry(Observation observation) {
		mProblemEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry) observation;
	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. 
	 * Dieser Konstruktor wird verwendet, wenn der Zeitraum in dem das Problem bestand unbekannt ist, das Problem als Code angegeben werden soll.
	 * Dieses Objekt kann einem ProblemConcernEntry hinzugefügt werden.
	 * 
	 * @param problemNotOccured
	 *            Normalerweise false. Ist ein Problem nicht aufgetreten: true.
	 * @param startOfProblem
	 *            Beginn des Problems
	 * @param endOfProblem
	 *            Ende des Problems
	 * @param problem
	 *            Freitextbeschreibung zu dem Problem oder Code zu
	 *            Komplikationsrisiken oder Expositionsrisiken.
	 * @param internalProblemId
	 *            Interne ID des Problems innerhalb der Akte. Steht eine solche nicht zur Verfügung dann kann ein anderer Konstruktor verwendet werden und es wird stattdesssen eine GUID durch die Convenience API generiert.
	 */
	public ProblemEntry(org.ehc.common.Code problem) {
		mProblemEntry = IHEFactory.eINSTANCE.createProblemEntry().init();
		mProblemEntry.setEffectiveTime(DateUtil.createUnknownLowHighTimeNullFlavor());
		setProblemNotOccured(false);
		setCodedProblem(problem);
		setInternalId(null);
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setNullFlavor(org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor.UNK);
		mProblemEntry.getValues().add(cd);
	}

	/**
	 * @param problemEntry
	 */
	public ProblemEntry(org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry problemEntry) {
		mProblemEntry = problemEntry;
	}

	/**
	 * @return das codedProblem Objekt
	 */
	public org.ehc.common.Code getCodedProblem() {
		org.ehc.common.Code code = new org.ehc.common.Code(mProblemEntry.getCode());
		return code;
	}

	/**
	 * @return das endOfProblem Objekt
	 */
	public String getEndOfProblem() {
		return Util.createEurDateStrFromTS(mProblemEntry
				.getEffectiveTime().getHigh().getValue());
	}

	public org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry getMdhtProblemEntry() {
		return EcoreUtil.copy(mProblemEntry);
	}

	/**
	 * @return das startOfProblem Objekt
	 */
	public String getStartOfProblem() {
		return Util.createEurDateStrFromTS(mProblemEntry
				.getEffectiveTime().getLow().getValue());
	}

	/**
	 * The Value may be a coded or uncoded String. 
	 * <p>If the value is coded, the convenience API will return the Code. </p>
	 * <p>If the value is uncoded, the convenience API will return the xml reference to the free text description of the document for further processing. </p>
	 * @return the problem value as string.
	 */
	public String getValue() { 
		//TODO The best solution is to return the human readable content, if no code is available. 
		//Maybe it´s better to generate a list with values here, but this way is more convenient and should be ok, in most of the cases.
		for (ANY any : mProblemEntry.getValues()) {
			if (any instanceof CD) {
				return ((CD) any).getCode();
			}
			if (any instanceof ED) {
				return ((ED) any).getText();
			}
		}
		return null;
	}

	/**
	 * @return das problemNotOccured Objekt
	 */
	public boolean isProblemNotOccured() {
		return mProblemEntry.getNegationInd();
	}

	/**
	 * @param codedProblem
	 *            das codedProblem Objekt welches gesetzt wird
	 */
	public void setCodedProblem(org.ehc.common.Code codedProblem) {
		mProblemEntry.setCode(codedProblem.getCD());
	}

	/**
	 * @param endOfProblem
	 *            das endOfProblem Objekt welches gesetzt wird
	 * @throws ParseException
	 */
	public void setEndOfProblem(Date endOfProblem) throws ParseException {
		mProblemEntry.getEffectiveTime().setHigh(
				DateUtil.createIVXB_TSFromDate(endOfProblem));
	}

	public void setInternalId(String id) {
		II ii = Util.createUuidVacd(id);
		mProblemEntry.getIds().add(ii);
	}

	/**
	 * @param problemNotOccured
	 *            das problemNotOccured Objekt welches gesetzt wird
	 */
	public void setProblemNotOccured(boolean problemNotOccured) {
		mProblemEntry.setNegationInd(problemNotOccured);
	}

	/**
	 * @param startOfProblem
	 *            das startOfProblem Objekt welches gesetzt wird
	 * @throws ParseException
	 */
	public void setStartOfProblem(Date startOfProblem) throws ParseException {
		if (mProblemEntry.getEffectiveTime() == null) {
			IVL_TS interval = DatatypesFactory.eINSTANCE.createIVL_TS();
			mProblemEntry.setEffectiveTime(interval);
		}
		mProblemEntry.getEffectiveTime().setLow(
				DateUtil.createIVXB_TSFromDate(startOfProblem));
	}

	public void setValue(Code codedProblem) {
		CD mCodedProblem = EcoreUtil.copy(codedProblem.getCD());
		mProblemEntry.getValues().add(mCodedProblem);
	}
}
