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

package org.ehealth_connector.cda;

import java.text.ParseException;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.AllergiesAndIntolerances;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Util;
import org.ehealth_connector.common.Value;
import org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;

/**
 * <div class="de">Ein gesundheitliches Leiden</div> <div class="fr">Une
 * souffrance de la santé</div>
 */
public class AllergyProblem {
	AllergyIntolerance mAllergyProblem; 

	public AllergyProblem () {
		mAllergyProblem = IHEFactory.eINSTANCE.createAllergyIntolerance().init();
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
	 * @param allergy
	 *            Freitextbeschreibung zu dem Problem oder Code zu
	 *            Komplikationsrisiken oder Expositionsrisiken.
	 * @param internalProblemId
	 *            Interne ID des Problems innerhalb der Akte. Steht eine solche nicht zur Verfügung dann kann ein anderer Konstruktor verwendet werden und es wird stattdesssen eine GUID durch die Convenience API generiert.
	 */
	public AllergyProblem(AllergiesAndIntolerances allergy) {
		mAllergyProblem = IHEFactory.eINSTANCE.createAllergyIntolerance().init();
		mAllergyProblem.setEffectiveTime(DateUtil.createUnknownLowHighTimeNullFlavor());
		setProblemNotOccured(false);
		setCode(allergy);
		setId(null);
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setNullFlavor(org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor.UNK);
		mAllergyProblem.getValues().add(cd);
	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. 
	 * Dieser Konstruktor wird verwendet, wenn der Zeitraum in dem das Problem bestand bekannt ist und das Problem als Code angegeben werden soll.
	 * Dieses Objekt kann einem ProblemConcernEntry hinzugefügt werden.
	 * @param problem
	 *            Freitextbeschreibung zu dem Problem oder Code zu
	 *            Komplikationsrisiken oder Expositionsrisiken.
	 * @param startOfProblem
	 *            Beginn des Problems
	 * @param endOfProblem
	 *            Ende des Problems
	 * @param problemNotOccured
	 *            Normalerweise false. Ist ein Problem nicht aufgetreten: true.
	 */
	public AllergyProblem(AllergiesAndIntolerances kindOfAllergy,
			org.ehealth_connector.common.Code problem, Date startOfProblem, Date endOfProblem) {
		this (kindOfAllergy, problem, startOfProblem, endOfProblem, null);

	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. 
	 * Dieser Konstruktor wird verwendet, wenn der Zeitraum in dem das Problem bestand bekannt ist und das Problem als Code angegeben werden soll.
	 * Dieses Objekt kann einem ProblemConcernEntry hinzugefügt werden.
	 * @param problem
	 *            Freitextbeschreibung zu dem Problem oder Code zu
	 *            Komplikationsrisiken oder Expositionsrisiken.
	 * @param startOfProblem
	 *            Beginn des Problems
	 * @param endOfProblem
	 *            Ende des Problems
	 * @param internalProblemId
	 *            Interne ID des Problems innerhalb der Akte. Steht eine solche nicht zur Verfügung dann kann ein anderer Konstruktor verwendet werden und es wird stattdesssen eine GUID durch die Convenience API generiert.
	 * @param problemNotOccured
	 *            Normalerweise false. Ist ein Problem nicht aufgetreten: true.
	 */
	public AllergyProblem(AllergiesAndIntolerances kindOfAllergy,
			org.ehealth_connector.common.Code problem, Date startOfProblem, Date endOfProblem, String internalProblemId) {
		mAllergyProblem = IHEFactory.eINSTANCE.createAllergyIntolerance().init();
		setProblemNotOccured(false);
		try {
			setStart(startOfProblem);
			setEndOfProblem(endOfProblem);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		setId(internalProblemId);
		setCode(kindOfAllergy);
		setValue(problem);
	}

	/**
	 * @param problemEntry
	 */
	public AllergyProblem(org.openhealthtools.mdht.uml.cda.ihe.AllergyIntolerance allergyIntolerance) {
		mAllergyProblem = allergyIntolerance;
	}

	public AllergyIntolerance copyMdAllergyIntolerance() {
		return EcoreUtil.copy(mAllergyProblem);
	}

	/**
	 * @return das codedProblem Objekt
	 */
	public org.ehealth_connector.common.Code getCode() {
		org.ehealth_connector.common.Code code = new org.ehealth_connector.common.Code(mAllergyProblem.getCode());
		return code;
	}

	/**
	 * @return das endOfProblem Objekt
	 */
	public String getEnd() {
		return Util.createEurDateStrFromTS(mAllergyProblem
				.getEffectiveTime().getHigh().getValue());
	}

	public AllergyIntolerance getMdhtAllergyProblem() {
		return mAllergyProblem;
	}

	/**
	 * @return das problemNotOccured Objekt
	 */
	public boolean getProblemNotOccured() {
		return mAllergyProblem.getNegationInd();
	}

	/**
	 * @return das startOfProblem Objekt
	 */
	public String getStart() {
		return Util.createEurDateStrFromTS(mAllergyProblem
				.getEffectiveTime().getLow().getValue());
	}

	/**
	 * The Value may be a coded or uncoded String. 
	 * <p>If the value is coded, the convenience API will return the Code. </p>
	 * <p>If the value is uncoded, the convenience API will return the xml reference to the free text description of the document for further processing. </p>
	 * @return the problem value as string.
	 */
	public Value getValue() { 
		Value value = new Value(mAllergyProblem.getValues().get(0));
		return value;
	}

	public void setCode(AllergiesAndIntolerances kindOfAllergy) {
		mAllergyProblem.setCode(kindOfAllergy.getCD());
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

	public void setId(String id) {
		II ii = Util.createUuidVacd(id);
		mAllergyProblem.getIds().add(ii);
	}

	/**
	 * @param problemNotOccured
	 *            das problemNotOccured Objekt welches gesetzt wird
	 */
	public void setProblemNotOccured(boolean problemNotOccured) {
		mAllergyProblem.setNegationInd(problemNotOccured);
	}

	/**
	 * @param startOfProblem
	 *            das startOfProblem Objekt welches gesetzt wird
	 * @throws ParseException
	 */
	public void setStart(Date startOfProblem) throws ParseException {
		if (mAllergyProblem.getEffectiveTime() == null) {
			IVL_TS interval = DatatypesFactory.eINSTANCE.createIVL_TS();
			mAllergyProblem.setEffectiveTime(interval);
		}
		mAllergyProblem.getEffectiveTime().setLow(
				DateUtil.createIVXB_TSFromDate(startOfProblem));
	}

	public void setValue(Code codedProblem) {
		CD mCodedProblem = EcoreUtil.copy(codedProblem.getCD());
		mAllergyProblem.getValues().add(mCodedProblem);
	}
}

