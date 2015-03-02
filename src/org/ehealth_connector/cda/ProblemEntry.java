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
import org.ehealth_connector.cda.ch.enums.ProblemType;
import org.ehealth_connector.cda.ch.enums.ProblemsSpecialConditions;
import org.ehealth_connector.cda.ch.enums.RiscOfComplications;
import org.ehealth_connector.cda.ch.enums.RiscOfExposure;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Util;
import org.ehealth_connector.common.Value;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

// TODO: Auto-generated Javadoc
/**
 * Ein medizinisches Problem.
 */
public class ProblemEntry {

	/** The m problem entry. */
	public org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry mProblemEntry;

	/**
	 * Instantiates a new problem entry.
	 */
	public ProblemEntry() {

	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. Dieses Objekt kann einem ProblemConcernEntry hinzugefügt werden.
	 * Dieser Konstruktor wird verwendet, wenn ein leeres Object initialisiert werden soll oder codiert werden soll, dass der Patient keine aktuellen Probleme hat. 
	 * 
	 * @param currentProblems true: Erstellung eines leeren Objekts, false: Der Patient hat keine aktuellen Probleme.
	 */
	public ProblemEntry(boolean currentProblems) {
		mProblemEntry = IHEFactory.eINSTANCE.createProblemEntry().init();
		setNotOccured(false);
		if (!currentProblems) {
			setCode(ProblemType.PROBLEM.getCode());
			setValue(ProblemsSpecialConditions.NO_CURRENT_PROBLEMS_OR_DISABILITY.getCode());
			setId(null);
			setStart(null);
			setEnd(null);
		}
	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. Dieses Objekt kann einem ProblemConcernEntry hinzugefügt werden.
	 * Dieser Konstruktor wird verwendet, wenn für den Patienten ein weiteres Problem (kein Komplikations- oder Expositionsrisiko) besteht und dieses im Freitext angegeben wird.
	 *
	 * @param code <br>
	 * 		<div class="de"> code</div>
	 * 		<div class="fr"> code</div>
	 * 		<div class="it"> code</div>
	 * @param value <br>
	 * 		<div class="de"> value</div>
	 * 		<div class="fr"> value</div>
	 * 		<div class="it"> value</div>
	 * @param start <br>
	 * 		<div class="de"> start</div>
	 * 		<div class="fr"> start</div>
	 * 		<div class="it"> start</div>
	 * @param end <br>
	 * 		<div class="de"> end</div>
	 * 		<div class="fr"> end</div>
	 * 		<div class="it"> end</div>
	 */
	public ProblemEntry(Code code, String value, Date start, Date end) {
		mProblemEntry = IHEFactory.eINSTANCE.createProblemEntry().init();
		setNotOccured(false);

		setCode(code);
		addValueText(value);
		setStart(start);
		setEnd(end);
		setId(null);
	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. Dieses Objekt kann einem ProblemConcernEntry hinzugefügt werden.
	 * Dieser Konstruktor wird verwendet, wenn für den Patienten ein weiteres Problem (kein Komplikations- oder Expositionsrisiko) besteht und dieses codiert angegeben wird.
	 *
	 * @param code <br>
	 * 		<div class="de"> code</div>
	 * 		<div class="fr"> code</div>
	 * 		<div class="it"> code</div>
	 * @param value <br>
	 * 		<div class="de"> value</div>
	 * 		<div class="fr"> value</div>
	 * 		<div class="it"> value</div>
	 * @param start <br>
	 * 		<div class="de"> start</div>
	 * 		<div class="fr"> start</div>
	 * 		<div class="it"> start</div>
	 * @param end <br>
	 * 		<div class="de"> end</div>
	 * 		<div class="fr"> end</div>
	 * 		<div class="it"> end</div>
	 */
	public ProblemEntry(Code code, Value value, Date start, Date end) {
		mProblemEntry = IHEFactory.eINSTANCE.createProblemEntry().init();
		setNotOccured(false);

		setCode(code);
		setValue(value);
		setStart(start);
		setEnd(end);
		setId(null);
	}

	/**
	 * Instantiates a new problem entry.
	 *
	 * @param observation <br>
	 * 		<div class="de"> observation</div>
	 * 		<div class="fr"> observation</div>
	 * 		<div class="it"> observation</div>
	 */
	public ProblemEntry(Observation observation) {
		mProblemEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry) observation;
	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. Dieses Objekt kann einem ProblemConcernEntry hinzugefügt werden.
	 * Dieser Konstruktor wird verwendet, wenn für den Patienten ein Komplikationsrisiko besteht.
	 *
	 * @param risc Komplikationsrisiko
	 * @param start <br>
	 * 		<div class="de"> start</div>
	 * 		<div class="fr"> start</div>
	 * 		<div class="it"> start</div>
	 * @param end <br>
	 * 		<div class="de"> end</div>
	 * 		<div class="fr"> end</div>
	 * 		<div class="it"> end</div>
	 */
	public ProblemEntry(RiscOfComplications risc, Date start, Date end) {
		this(ProblemType.PROBLEM.getCode(), new Value(risc.getCode()), start, end);
	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. Dieses Objekt kann einem ProblemConcernEntry hinzugefügt werden.
	 * Dieser Konstruktor wird verwendet, wenn für den Patienten ein Expositionsrisiko besteht.
	 *
	 * @param risc Expositionsrisiko
	 * @param start <br>
	 * 		<div class="de"> start</div>
	 * 		<div class="fr"> start</div>
	 * 		<div class="it"> start</div>
	 * @param end <br>
	 * 		<div class="de"> end</div>
	 * 		<div class="fr"> end</div>
	 * 		<div class="it"> end</div>
	 */
	public ProblemEntry(RiscOfExposure risc, Date start, Date end) {
		this(ProblemType.PROBLEM.getCode(), new Value(risc.getCode()), start, end);
	}

	/**
	 * <div class="de">Adds the value text.</div>
	 * <div class="fr">Adds the value text.</div>
	 * <div class="it">Adds the value text.</div>
	 *
	 * @param value <br>
	 * 		<div class="de"> value</div>
	 * 		<div class="fr"> value</div>
	 * 		<div class="it"> value</div>
	 */
	public void addValueText(String value) {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setNullFlavor(NullFlavor.UNK);
		cd.setOriginalText(Util.createEd(value));
		mProblemEntry.getValues().add(cd);		
	}

	/**
	 * <div class="de">Copy mdht problem entry.</div>
	 * <div class="fr">Copy mdht problem entry.</div>
	 * <div class="it">Copy mdht problem entry.</div>
	 *
	 * @return the org.openhealthtools.mdht.uml.cda.ihe. problem entry
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry copyMdhtProblemEntry() {
		return EcoreUtil.copy(mProblemEntry);
	}

	/**
	 * Gets the code.
	 *
	 * @return das codedProblem Objekt
	 */
	public org.ehealth_connector.common.Code getCode() {
		org.ehealth_connector.common.Code code = new org.ehealth_connector.common.Code(mProblemEntry.getCode());
		return code;
	}

	/**
	 * Gets the end.
	 *
	 * @return das endOfProblem Objekt
	 */
	public String getEnd() {
		return Util.createEurDateStrFromTS(mProblemEntry
				.getEffectiveTime().getHigh().getValue());
	}

	/**
	 * Gets the mdht problem entry.
	 *
	 * @return the mdht problem entry
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry getMdhtProblemEntry() {
		return mProblemEntry;
	}

	/**
	 * Gets the problem not occured.
	 *
	 * @return das problemNotOccured Objekt
	 */
	public boolean getProblemNotOccured() {
		return mProblemEntry.getNegationInd();
	}

	/**
	 * Gets the start.
	 *
	 * @return das startOfProblem Objekt
	 */
	public String getStart() {
		return Util.createEurDateStrFromTS(mProblemEntry
				.getEffectiveTime().getLow().getValue());
	}

	/**
	 * The Value may be a coded or uncoded String. 
	 * @return the problem value as string.
	 */
	public Value getValue() { 
		Value value = new Value(mProblemEntry.getValues().get(0));
		return value;
	}

	/**
	 * Sets the code.
	 *
	 * @param codedProblem            das codedProblem Objekt welches gesetzt wird
	 */
	public void setCode(org.ehealth_connector.common.Code codedProblem) {
		mProblemEntry.setCode(codedProblem.getCD());
	}

	/**
	 * Sets the end.
	 *
	 * @param endOfProblem            das endOfProblem Objekt welches gesetzt wird
	 */
	public void setEnd(Date endOfProblem) {
		try {
			mProblemEntry.getEffectiveTime().setHigh(
					DateUtil.createIVXB_TSFromDate(endOfProblem));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		II ii = Util.createUuidVacd(id);
		mProblemEntry.getIds().add(ii);
	}

	/**
	 * Sets the not occured.
	 *
	 * @param problemNotOccured            das problemNotOccured Objekt welches gesetzt wird
	 */
	public void setNotOccured(boolean problemNotOccured) {
		mProblemEntry.setNegationInd(problemNotOccured);
	}

	/**
	 * Sets the start.
	 *
	 * @param startOfProblem            das startOfProblem Objekt welches gesetzt wird
	 */
	public void setStart(Date startOfProblem) {
		if (mProblemEntry.getEffectiveTime() == null) {
			IVL_TS interval = DatatypesFactory.eINSTANCE.createIVL_TS();
			mProblemEntry.setEffectiveTime(interval);
		}
		try {
			mProblemEntry.getEffectiveTime().setLow(
					DateUtil.createIVXB_TSFromDate(startOfProblem));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Sets the value.
	 *
	 * @param code the new value
	 */
	public void setValue(Code code) {
		Value value = new Value (code);
		this.setValue(value);
	}

	/**
	 * Sets the value.
	 *
	 * @param problemValue the new value
	 */
	public void setValue(Value problemValue) {
		if (problemValue == null) {
			CD cd = DatatypesFactory.eINSTANCE.createCD();
			cd.setNullFlavor(NullFlavor.UNK);
			mProblemEntry.getValues().add(cd);
		}
		else {
			mProblemEntry.getValues().add(problemValue.getValue());
		}
	}
}
