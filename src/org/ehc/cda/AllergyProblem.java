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
import org.ehc.cda.ch.enums.AllergiesAndIntolerances;
import org.ehc.common.Code;
import org.ehc.common.DateUtil;
import org.ehc.common.Util;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;

/**
 * <div class="de">Ein gesundheitliches Leiden</div> <div class="fr">Une
 * souffrance de la santé</div>
 */
public class AllergyProblem {
	AllergyIntolerance mAllergyProblem; 
	
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
     * @param allergy
     *            Freitextbeschreibung zu dem Problem oder Code zu
     *            Komplikationsrisiken oder Expositionsrisiken.
     * @param internalProblemId
     *            Interne ID des Problems innerhalb der Akte. Steht eine solche nicht zur Verfügung dann kann ein anderer Konstruktor verwendet werden und es wird stattdesssen eine GUID durch die Convenience API generiert.
     */
    public AllergyProblem(boolean problemNotOccured, AllergiesAndIntolerances allergy) {
        mAllergyProblem = IHEFactory.eINSTANCE.createAllergyIntolerance().init();
        this.mAllergyProblem.setEffectiveTime(DateUtil.createUnknownLowHighTimeNullFlavor());
        this.setProblemNotOccured(problemNotOccured);
        this.setCodedProblem(allergy.getCode());
        this.setInternalId(null);
        CD cd = DatatypesFactory.eINSTANCE.createCD();
        cd.setNullFlavor(org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor.UNK);
        this.mAllergyProblem.getValues().add(cd);
    }
	
	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. 
	 * Dieser Konstruktor wird verwendet, wenn der Zeitraum in dem das Problem bestand bekannt ist und das Problem als Code angegeben werden soll.
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
	public AllergyProblem(boolean problemNotOccured, Date startOfProblem,
			Date endOfProblem, org.ehc.common.Code problem, String internalProblemId) {
      mAllergyProblem = IHEFactory.eINSTANCE.createAllergyIntolerance().init();
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
     * Erzeugt ein Objekt welches ein Problem repräsentiert. 
     * Dieser Konstruktor wird verwendet, wenn der Zeitraum in dem das Problem bestand bekannt ist und das Problem als Code angegeben werden soll.
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
     */
    public AllergyProblem(boolean problemNotOccured, Date startOfProblem,
            Date endOfProblem, org.ehc.common.Code problem) {
      this(problemNotOccured, startOfProblem, endOfProblem, problem, null);
      
    }
	   
    public void setInternalId(String id) {
      II ii = Util.createUuidVacd(id);
      mAllergyProblem.getIds().add(ii);
    }

	/**
	 * @param problemEntry
	 */
	public AllergyProblem(org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance allergyIntolerance) {
		this.mAllergyProblem = allergyIntolerance;
	}

	/**
	 * @return das problemNotOccured Objekt
	 */
	public boolean isProblemNotOccured() {
		return mAllergyProblem.getNegationInd();
	}

	/**
	 * @param problemNotOccured
	 *            das problemNotOccured Objekt welches gesetzt wird
	 */
	public void setProblemNotOccured(boolean problemNotOccured) {
		mAllergyProblem.setNegationInd(problemNotOccured);
	}

	/**
	 * @return das startOfProblem Objekt
	 */
	public String getStartOfProblem() {
		return Util.createEurDateStrFromTS(mAllergyProblem
				.getEffectiveTime().getLow().getValue());
	}

	/**
	 * @param startOfProblem
	 *            das startOfProblem Objekt welches gesetzt wird
	 * @throws ParseException
	 */
	public void setStartOfProblem(Date startOfProblem) throws ParseException {
		if (mAllergyProblem.getEffectiveTime() == null) {
			IVL_TS interval = DatatypesFactory.eINSTANCE.createIVL_TS();
			mAllergyProblem.setEffectiveTime(interval);
		}
		mAllergyProblem.getEffectiveTime().setLow(
		DateUtil.createIVXB_TSFromDate(startOfProblem));
	}

	/**
	 * @return das endOfProblem Objekt
	 */
	public String getEndOfProblem() {
		return Util.createEurDateStrFromTS(mAllergyProblem
				.getEffectiveTime().getHigh().getValue());
	}

	/**
	 * @param endOfProblem
	 *            das endOfProblem Objekt welches gesetzt wird
	 * @throws ParseException
	 */
	public void setEndOfProblem(Date endOfProblem) throws ParseException {
		mAllergyProblem.getEffectiveTime().setHigh(
		    DateUtil.createIVXB_TSFromDate(endOfProblem));
	}

	/**
	 * @return das codedProblem Objekt
	 */
	public org.ehc.common.Code getCodedProblem() {
	  org.ehc.common.Code code = new org.ehc.common.Code(mAllergyProblem.getCode());
		return code;
	}

	/**
	 * @param codedProblem
	 *            das codedProblem Objekt welches gesetzt wird
	 */
	public void setCodedProblem(org.ehc.common.Code codedProblem) {
	  mAllergyProblem.setCode(codedProblem.getCD());
	}

  public void setValue(Code codedProblem) {
    CD mCodedProblem = EcoreUtil.copy(codedProblem.getCD());
    mAllergyProblem.getValues().add((ANY) mCodedProblem);
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
    for (ANY any : mAllergyProblem.getValues()) {
      if (any instanceof CD) {
          return ((CD) any).getCode();
      }
      if (any instanceof ED) {
        return ((ED) any).getText();
      }
    }
    return null;
  }
}

