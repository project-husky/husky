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

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.common.Code;
import org.ehc.common.DateUtil;
import org.ehc.common.Util;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
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
	 * @param internalProblemId
     *            Interne ID des Problems innerhalb der Akte. Steht eine solche nicht zur Verfügung dann kann ein anderer Konstruktor verwendet werden und es wird stattdesssen eine GUID durch die Convenience API generiert.
	 */
	public ProblemEntry(boolean problemNotOccured, Date startOfProblem,
			Date endOfProblem, org.ehc.common.Code problem, String internalProblemId) {
		this(problemNotOccured, DateFormat.getDateInstance().format(
				startOfProblem), DateFormat.getDateInstance().format(
				endOfProblem), problem, internalProblemId);
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
     * @param internalProblemId
     *            Interne ID des Problems innerhalb der Akte. Steht eine solche nicht zur Verfügung dann kann ein anderer Konstruktor verwendet werden und es wird stattdesssen eine GUID durch die Convenience API generiert.
     */
    public ProblemEntry(boolean problemNotOccured, Date startOfProblem,
            Date endOfProblem, org.ehc.common.Code problem) {
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
	 * @param internalProblemId
     *            Interne ID des Problems innerhalb der Akte. Steht eine solche nicht zur Verfügung dann kann ein anderer Konstruktor verwendet werden und es wird stattdesssen eine GUID durch die Convenience API generiert.
	 */
	public ProblemEntry(boolean problemNotOccured, String startOfProblem,
			String endOfProblem, org.ehc.common.Code problem, String internalProblemId) {
		mProblemEntry = IHEFactory.eINSTANCE.createProblemEntry().init();
		this.setProblemNotOccured(problemNotOccured);
		try {
			this.setStartOfProblem(startOfProblem);
			this.setEndOfProblem(endOfProblem);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.setInternalId(internalProblemId);
		this.setValue(problem);
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
            String endOfProblem, org.ehc.common.Code problem) {
      this(problemNotOccured, startOfProblem,
          endOfProblem, problem, UUID.generate());
    }
	   
    private void setInternalId(String id) {
      II ii = DatatypesFactory.eINSTANCE.createII();
      ii.setRoot(id);
      mProblemEntry.getIds().add(ii);
    }

	/**
	 * @param observation
	 */
	public ProblemEntry(Observation observation) {
		this.mProblemEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry) observation;
	}
	
	/**
	 * @param problemEntry
	 */
	public ProblemEntry(org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry problemEntry) {
		this.mProblemEntry = problemEntry;
	}

	/**
	 * @return das problemNotOccured Objekt
	 */
	public boolean isProblemNotOccured() {
		return mProblemEntry.getNegationInd();
	}

	/**
	 * @param problemNotOccured
	 *            das problemNotOccured Objekt welches gesetzt wird
	 */
	public void setProblemNotOccured(boolean problemNotOccured) {
		mProblemEntry.setNegationInd(problemNotOccured);
	}

	/**
	 * @return das startOfProblem Objekt
	 */
	public String getStartOfProblem() {
		return Util.createEurDateStrFromTS(mProblemEntry
				.getEffectiveTime().getLow().getValue());
	}

	/**
	 * @param startOfProblem
	 *            das startOfProblem Objekt welches gesetzt wird
	 * @throws ParseException
	 */
	public void setStartOfProblem(String startOfProblem) throws ParseException {
		if (mProblemEntry.getEffectiveTime() == null) {
			IVL_TS interval = DatatypesFactory.eINSTANCE.createIVL_TS();
			mProblemEntry.setEffectiveTime(interval);
		}
		// IVXB_TS startTime = DatatypesFactory.eINSTANCE.createIVXB_TS();
		mProblemEntry.getEffectiveTime().setLow(
		    DateUtil.createIVXB_TSFromEuroDate(startOfProblem));
	}

	/**
	 * @return das endOfProblem Objekt
	 */
	public String getEndOfProblem() {
		return Util.createEurDateStrFromTS(mProblemEntry
				.getEffectiveTime().getHigh().getValue());
	}

	/**
	 * @param endOfProblem
	 *            das endOfProblem Objekt welches gesetzt wird
	 * @throws ParseException
	 */
	public void setEndOfProblem(String endOfProblem) throws ParseException {
		mProblemEntry.getEffectiveTime().setHigh(
		    DateUtil.createIVXB_TSFromEuroDate(endOfProblem));
	}

	/**
	 * @return das codedProblem Objekt
	 */
	public org.ehc.common.Code getCodedProblem() {
	  org.ehc.common.Code code = new org.ehc.common.Code(mProblemEntry.getCode());
		return code;
	}

	/**
	 * @param codedProblem
	 *            das codedProblem Objekt welches gesetzt wird
	 */
	public void setCodedProblem(org.ehc.common.Code codedProblem) {
	  mProblemEntry.setCode(codedProblem.getCD());
	}

  public void setValue(Code codedProblem) {
    CD mCodedProblem = EcoreUtil.copy(codedProblem.getCD());
    mProblemEntry.getValues().add((ANY) mCodedProblem);
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
          CD code = (CD) any;
          return ((CD) any).getCode();
      }
      if (any instanceof ED) {
        ED ed = (ED) any;
        return ((ED) any).getText();
      }
    }
    return null;
  }
}
