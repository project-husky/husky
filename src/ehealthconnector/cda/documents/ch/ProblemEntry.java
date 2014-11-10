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

package ehealthconnector.cda.documents.ch;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;

/**
 * Ein medizinisches Problem
 */
public class ProblemEntry {

	public org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry mProblemEntry;

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. Dieses Objekt kann
	 * einem ProblemConcernEntry hinzugefügt werden.
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
	 */
	public ProblemEntry(boolean problemNotOccured, Date startOfProblem,
			Date endOfProblem, Code problem) {
		this(problemNotOccured, DateFormat.getDateInstance().format(
				startOfProblem), DateFormat.getDateInstance().format(
				endOfProblem), problem);
	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. Dieses Objekt kann
	 * einem ProblemConcernEntry hinzugefügt werden.
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
	 */
	public ProblemEntry(boolean problemNotOccured, String startOfProblem,
			String endOfProblem, Code problem) {
		mProblemEntry = IHEFactory.eINSTANCE.createProblemEntry().init();
		this.cSetProblemNotOccured(problemNotOccured);
		try {
			this.cSetStartOfProblem(startOfProblem);
			this.cSetEndOfProblem(endOfProblem);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.cSetCodedProblem(problem);
	}

	/**
	 * @param observation
	 */
	public ProblemEntry(Observation observation) {
		this.mProblemEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry) observation;
	}
	
	/**
	 * @param observation
	 */
	public ProblemEntry(org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry problemEntry) {
		this.mProblemEntry = problemEntry;
	}

	/**
	 * @return das problemNotOccured Objekt
	 */
	public boolean cIsProblemNotOccured() {
		return mProblemEntry.getNegationInd();
	}

	/**
	 * @param problemNotOccured
	 *            das problemNotOccured Objekt welches gesetzt wird
	 */
	public void cSetProblemNotOccured(boolean problemNotOccured) {
		mProblemEntry.setNegationInd(problemNotOccured);
	}

	/**
	 * @return das startOfProblem Objekt
	 */
	public String cGetStartOfProblem() {
		return CdaChUtil.createEurDateStrFromTS(mProblemEntry
				.getEffectiveTime().getLow().getValue());
	}

	/**
	 * @param startOfProblem
	 *            das startOfProblem Objekt welches gesetzt wird
	 * @throws ParseException
	 */
	public void cSetStartOfProblem(String startOfProblem) throws ParseException {
		if (mProblemEntry.getEffectiveTime() == null) {
			IVL_TS interval = DatatypesFactory.eINSTANCE.createIVL_TS();
			mProblemEntry.setEffectiveTime(interval);
		}
		// IVXB_TS startTime = DatatypesFactory.eINSTANCE.createIVXB_TS();
		mProblemEntry.getEffectiveTime().setLow(
				CdaChUtil.createIVXB_TSFromEuroDate(startOfProblem));
	}

	/**
	 * @return das endOfProblem Objekt
	 */
	public String cGetEndOfProblem() {
		return CdaChUtil.createEurDateStrFromTS(mProblemEntry
				.getEffectiveTime().getHigh().getValue());
	}

	/**
	 * @param endOfProblem
	 *            das endOfProblem Objekt welches gesetzt wird
	 * @throws ParseException
	 */
	public void cSetEndOfProblem(String endOfProblem) throws ParseException {
		mProblemEntry.getEffectiveTime().setHigh(
				CdaChUtil.createIVXB_TSFromEuroDate(endOfProblem));
	}

	/**
	 * @return das codedProblem Objekt
	 */
	public Code cGetCodedProblem() {
		Code code = new Code(mProblemEntry.getCode());
		return code;
	}

	/**
	 * @param codedProblem
	 *            das codedProblem Objekt welches gesetzt wird
	 */
	public void cSetCodedProblem(Code codedProblem) {
		mProblemEntry.setCode(codedProblem.mCD);
	}
}
