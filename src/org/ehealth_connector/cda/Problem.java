/********************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 Switzerland License.
 *
 * Year of publication: 2015
 *
 ********************************************************************************/

package org.ehealth_connector.cda;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.ProblemType;
import org.ehealth_connector.cda.ch.enums.ProblemsSpecialConditions;
import org.ehealth_connector.cda.ch.enums.RiscOfComplications;
import org.ehealth_connector.cda.ch.enums.RiscOfExposure;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Util;
import org.ehealth_connector.common.Value;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * Medzinisches Problem in strukturierter Angabe (z.B. Symptom, Beschwerde,
 * Diagnose, etc.)
 */
public class Problem {

	/**
	 * The MDHT Problem Entry Object
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry mProblemEntry;

	/**
	 * Instantiates a new problem entry.
	 */
	public Problem() {
		mProblemEntry = IHEFactory.eINSTANCE.createProblemEntry().init();
	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. Dieses Objekt kann
	 * einem ProblemConcernEntry hinzugefügt werden. Dieser Konstruktor wird
	 * verwendet, wenn ein leeres Object initialisiert werden soll oder codiert
	 * werden soll, dass der Patient keine aktuellen Probleme hat.
	 * 
	 * @param currentProblems
	 *            true: Erstellung eines leeren Objekts, false: Der Patient hat
	 *            keine aktuellen Probleme.
	 */
	public Problem(boolean currentProblems) {
		this();
		setNotOccured(false);
		if (!currentProblems) {
			setCode(ProblemType.PROBLEM.getCode());
			addValue(ProblemsSpecialConditions.NO_CURRENT_PROBLEMS_OR_DISABILITY
					.getCode());
			setId(null);
			setStart(null);
			setEnd(null);
		}
	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. Dieses Objekt kann
	 * einem ProblemConcernEntry hinzugefügt werden. Dieser Konstruktor wird
	 * verwendet, wenn für den Patienten ein weiteres Problem (kein
	 * Komplikations- oder Expositionsrisiko) besteht und dieses als Freitext
	 * angegeben wird.
	 *
	 * @param code
	 * <br>
	 *            <div class="de">Code des Problems (z.B. SNOMED Code für eine
	 *            Diagnose)</div> <div class="fr"></div> <div class="it"></div>
	 * @param value
	 * <br>
	 *            <div class="de">Beschreibung des Problems (z.B.
	 *            Lungenentzündung)</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param start
	 * <br>
	 *            <div class="de">Beginn des Problems</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param end
	 * <br>
	 *            <div class="de">Ende des Problems</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Problem(Code code, String value, Date start, Date end) {
		this();
		setNotOccured(false);

		setCode(code);
		addValueText(value);
		setStart(start);
		setEnd(end);
		setId(null);
	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. Dieses Objekt kann
	 * einem ProblemConcernEntry hinzugefügt werden. Dieser Konstruktor wird
	 * verwendet, wenn für den Patienten ein weiteres Problem (kein
	 * Komplikations- oder Expositionsrisiko) besteht und dieses codiert
	 * angegeben wird.
	 *
	 * @param code
	 * <br>
	 *            <div class="de">Code des Problems (z.B. SNOMED Code für eine
	 *            Diagnose)</div> <div class="fr"></div> <div class="it"></div>
	 * @param value
	 * <br>
	 *            <div class="de">Wert des Problems (z.B. ICD Code für
	 *            Lungenentzündung)</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param start
	 * <br>
	 *            <div class="de">Beginn des Problems</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param end
	 * <br>
	 *            <div class="de">Ende des Problems</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Problem(Code code, Value value, Date start, Date end) {
		this();
		setNotOccured(false);

		setCode(code);
		addValue(value);
		setStart(start);
		setEnd(end);
		setId(null);
	}

	/**
	 * Instantiates a new problem entry.
	 *
	 * @param observation
	 * <br>
	 *            <div class="de"> observation</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Problem(Observation observation) {
		mProblemEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry) observation;
	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. Dieses Objekt kann
	 * einem ProblemConcernEntry hinzugefügt werden. Dieser Konstruktor wird
	 * verwendet, wenn für den Patienten ein Komplikationsrisiko besteht.
	 *
	 * @param risc
	 *            Komplikationsrisiko
	 * @param start
	 * <br>
	 *            <div class="de"> start</div> <div class="fr"> start</div> <div
	 *            class="it"> start</div>
	 * @param end
	 * <br>
	 *            <div class="de"> end</div> <div class="fr"> end</div> <div
	 *            class="it"> end</div>
	 */
	public Problem(RiscOfComplications risc, Date start, Date end) {
		this(ProblemType.PROBLEM.getCode(), new Value(risc.getCode()), start,
				end);
	}

	/**
	 * Erzeugt ein Objekt welches ein Problem repräsentiert. Dieses Objekt kann
	 * einem ProblemConcernEntry hinzugefügt werden. Dieser Konstruktor wird
	 * verwendet, wenn für den Patienten ein Expositionsrisiko besteht.
	 *
	 * @param risc
	 *            Expositionsrisiko
	 * @param start
	 * <br>
	 *            <div class="de"> start</div> <div class="fr"> start</div> <div
	 *            class="it"> start</div>
	 * @param end
	 * <br>
	 *            <div class="de"> end</div> <div class="fr"> end</div> <div
	 *            class="it"> end</div>
	 */
	public Problem(RiscOfExposure risc, Date start, Date end) {
		this(ProblemType.PROBLEM.getCode(), new Value(risc.getCode()), start,
				end);
	}

	/**
	 * <div class="de">Für die Angabe weiterer Leiden des Patienten sind in der
	 * Schweiz folgende Codesysteme (oder Unterknoten davon) zugelassen: CHOP
	 * 2.16.756.5.30.1.126.3.1 ICD-10 2.16.756.5.30.1.126.3.2 ICPC-2
	 * 2.16.840.1.113883.6.139 VVK-EDI 2.16.756.5.30.1.127.3.1.20080401.1 SNOMED
	 * CT 2.16.840.1.113883.6.96 </div> <div class="fr"></div> <div
	 * class="it"></div>
	 *
	 * @param code
	 *            the new value
	 */
	public void addValue(Code code) {
		Value value = new Value(code);
		this.addValue(value);
	}

	/**
	 * <div class="de">Für die Angabe weiterer Leiden des Patienten sind in der
	 * Schweiz folgende Codesysteme (oder Unterknoten davon) zugelassen: CHOP
	 * 2.16.756.5.30.1.126.3.1 ICD-10 2.16.756.5.30.1.126.3.2 ICPC-2
	 * 2.16.840.1.113883.6.139 VVK-EDI 2.16.756.5.30.1.127.3.1.20080401.1 SNOMED
	 * CT 2.16.840.1.113883.6.96 </div> <div class="fr"></div> <div
	 * class="it"></div>
	 * 
	 * @param problemValue
	 *            the new value
	 */
	public void addValue(Value problemValue) {
		if (problemValue == null) {
			CD cd = DatatypesFactory.eINSTANCE.createCD();
			cd.setNullFlavor(NullFlavor.UNK);
			mProblemEntry.getValues().add(cd);
		} else {
			mProblemEntry.getValues().add(problemValue.getValue());
		}
	}

	/**
	 * <div class="de">Fügt dem Wert (Value) einen Text hinzu</div> <div
	 * class="fr"></div> <div class="it"></div>
	 *
	 * @param text
	 * <br>
	 *            <div class="de"> value</div> <div class="fr"> value</div> <div
	 *            class="it"> value</div>
	 */
	public void addValueText(String text) {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setNullFlavor(NullFlavor.UNK);
		cd.setOriginalText(Util.createEd(text));
		mProblemEntry.getValues().add(cd);
	}

	/**
	 * <div class="de">Copy mdht problem entry.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return the org.openhealthtools.mdht.uml.cda.ihe. problem entry
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry copyMdhtProblemEntry() {
		return EcoreUtil.copy(mProblemEntry);
	}

	/**
	 * <div class="de">Gibt den Code des Problems zurück.</div> <div
	 * class="fr"></div> <div class="it"></div>
	 *
	 * @return das codedProblem Objekt
	 */
	public org.ehealth_connector.common.Code getCode() {
		org.ehealth_connector.common.Code code = new org.ehealth_connector.common.Code(
				mProblemEntry.getCode());
		return code;
	}

	/**
	 * <div class="de">Gibt das Zeitpunkt zurück, seitdem das Problems beendet
	 * ist</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return das endOfProblem Objekt
	 */
	public String getEnd() {
		if (mProblemEntry.getEffectiveTime() != null) {
			if (mProblemEntry.getEffectiveTime().getHigh() != null) {
				return Util.createEurDateStrFromTS(mProblemEntry
						.getEffectiveTime().getHigh().getValue());
			}
		}
		return null;
	}

	/**
	 * <div class="de">Liefert die (erste) interne (z.B. aus der Krankenakte
	 * bekannte) ID für das Problem. Ist keine ID vorhanden, wird null
	 * zurückgegeben.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param id
	 *            the new id
	 */
	public Identificator getId() {
		Identificator id = new Identificator(mProblemEntry.getIds().get(0));
		return id;
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
	 * <div class="de">Gibt zurück, ob das Problem nicht aufgetreten ist.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return das problemNotOccured Objekt
	 */
	public boolean getProblemNotOccured() {
		return mProblemEntry.getNegationInd();
	}

	/**
	 * <div class="de">Gibt das Zeitpunkt zurück, seit das Problems angefangen
	 * hat</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return das startOfProblem Objekt
	 */
	public String getStart() {
		if (mProblemEntry.getEffectiveTime() != null) {
			if (mProblemEntry.getEffectiveTime().getLow() != null) {
				return Util.createEurDateStrFromTS(mProblemEntry
						.getEffectiveTime().getLow().getValue());
			}
		}
		return null;
	}

	/**
	 * Get the (first) problem value. The Value may be a coded or uncoded
	 * String.
	 * 
	 * @return the (first) problem value as string.
	 */
	public Value getValue() {
		Value value = new Value(mProblemEntry.getValues().get(0));
		return value;
	}

	/**
	 * Get a list of all problem values. Each Value may be a coded or uncoded
	 * String.
	 * 
	 * @return all problem values as ArrayList.
	 */
	public ArrayList<Value> getValues() {
		ArrayList<Value> vl = new ArrayList<Value>();
		for (ANY a : mProblemEntry.getValues()) {
			Value v = new Value(a);
			vl.add(v);
		}
		return vl;
	}

	/**
	 * Sets the code.
	 *
	 * @param codedProblem
	 *            das codedProblem Objekt welches gesetzt wird
	 */
	public void setCode(org.ehealth_connector.common.Code codedProblem) {
		mProblemEntry.setCode(codedProblem.getCD());
	}

	/**
	 * <div class="de">Setzt den Zeitpunkt, seitdem das Problems beendet
	 * ist</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param endOfProblem
	 *            das endOfProblem Objekt welches gesetzt wird
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
	 * <div class="de">Setzt eine interne (z.B. aus der Krankenakte bekannte) ID
	 * für das Problem. Wird null angegeben, dann wird eine ID generiert.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Identificator id) {
		II ii = Util.createIdentificator(id);
		mProblemEntry.getIds().add(ii);
	}

	/**
	 * <div class="de">true, wenn das Problem nicht aufgetreten ist, false sonst
	 * (negationInd)</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param problemNotOccured
	 *            das problemNotOccured Objekt welches gesetzt wird
	 */
	public void setNotOccured(boolean problemNotOccured) {
		mProblemEntry.setNegationInd(problemNotOccured);
	}

	/**
	 * <div class="de">Setzt den Zeitpunkt, an dem das Problems angefangen
	 * hat</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param startOfProblem
	 *            das startOfProblem Objekt welches gesetzt wird
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
}
