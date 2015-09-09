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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.ehealth_connector.common.enums.IdentityDomain;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * <div class="en">Medical problem in a structured form (e.g. symptom, concern,
 * diagnosis)</div><div class="de">Medzinisches Problem in strukturierter Angabe
 * (z.B. Symptom, Beschwerde, Diagnose, etc.)</div>
 */
public class Problem {

	/**
	 * The MDHT Problem Entry Object
	 */
	private final org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry mProblemEntry;

	/**
	 * Instantiates a new problem entry.
	 */
	public Problem() {
		mProblemEntry = IHEFactory.eINSTANCE.createProblemEntry().init();
		mProblemEntry.setCode(Util.createCENullFlavorUNK());
	}

	/**
	 * <div class="en">Creates an object, which represents a medical problem.
	 * This constructor is used, when an empty object should be initialized or
	 * it should be expressed that the patient has no current
	 * problems.</div><div class="de">Erzeugt ein Objekt welches ein Problem
	 * repräsentiert. Dieses Objekt kann einem ProblemConcernEntry hinzugefügt
	 * werden. Dieser Konstruktor wird verwendet, wenn ein leeres Object
	 * initialisiert werden soll oder codiert werden soll, dass der Patient
	 * keine aktuellen Probleme hat.</div>
	 * 
	 * @param currentProblems
	 *            <div class="en">true, if an empty object should be
	 *            initialized. false, if the patient has no current
	 *            problems</div><div class="de">true: Erstellung eines leeren
	 *            Objekts, false: Der Patient hat keine aktuellen
	 *            Probleme.</div>
	 */
	public Problem(boolean currentProblems) {
		this();
		setNotOccured(false);
		if (!currentProblems) {
			setCode(ProblemType.PROBLEM.getCode());
			addValue(ProblemsSpecialConditions.NO_CURRENT_PROBLEMS_OR_DISABILITY.getCode());
			setId(null);
			setStartDate(null);
			setEndDate(null);
		}
	}

	/**
	 * <div class="en">Creates an object, which represents a medical problem.
	 * This constructor is used, if it should be expressed that the patient has
	 * another problem (not a risc of exposure or risc of complication), which
	 * is expressed as free text.</div><div class="de">Erzeugt ein Objekt
	 * welches ein Problem repräsentiert. Dieses Objekt kann einem
	 * ProblemConcernEntry hinzugefügt werden. Dieser Konstruktor wird
	 * verwendet, wenn für den Patienten ein weiteres Problem (kein
	 * Komplikations- oder Expositionsrisiko) besteht und dieses als Freitext
	 * angegeben wird.</div>
	 * 
	 * @param code
	 *            <div class="en">code of the problem (e.g. SNOMED Code for
	 *            diagnosis)</div><div class="de">Code des Problems (z.B. SNOMED
	 *            Code für eine Diagnose)</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param value
	 *            <div class="en">description (e.g. inflammation of the
	 *            lungs)</div><div class="de">Beschreibung des Problems (z.B.
	 *            Lungenentzündung)</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param start
	 *            <div class="en">start</div><div class="de">Beginn des
	 *            Problems</div> <div class="fr"></div> <div class="it"></div>
	 * @param end
	 *            <div class="en">end</div><div class="de">Ende des
	 *            Problems</div> <div class="fr"></div> <div class="it"></div>
	 */
	public Problem(Code code, String value, Date start, Date end) {
		this();
		setNotOccured(false);

		setCode(code);
		addValueText(value);
		setStartDate(start);
		setEndDate(end);
		setId(null);
	}

	/**
	 * <div class="en">Creates an object, which represents a medical problem.
	 * This constructor is used, if it should be expressed that the patient has
	 * another problem (not a risc of exposure or risc of complication), which
	 * is expressed as free text.</div><div class="de">Erzeugt ein Objekt
	 * welches ein Problem repräsentiert. Dieses Objekt kann einem
	 * ProblemConcernEntry hinzugefügt werden. Dieser Konstruktor wird
	 * verwendet, wenn für den Patienten ein weiteres Problem (kein
	 * Komplikations- oder Expositionsrisiko) besteht und dieses codiert
	 * angegeben wird.</div>
	 * 
	 * @param code
	 *            <div class="en">code of the kind of problem (e.g. SNOMED Code
	 *            for diagnosis)</div><div class="de">Code der Art des Problems
	 *            (z.B. SNOMED Code für eine Diagnose)</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param value
	 *            <div class="en">code for the problem itself (e.g. inflammation
	 *            of the lungs)</div><div class="de">Code zur Beschreibung des
	 *            eigentlichen Problems (z.B. Lungenentzündung)</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param start
	 *            <div class="en">start</div><div class="de">Beginn des
	 *            Problems</div> <div class="fr"></div> <div class="it"></div>
	 * @param end
	 *            <div class="en">end</div><div class="de">Ende des
	 *            Problems</div> <div class="fr"></div> <div class="it"></div>
	 */
	public Problem(Code code, Value value, Date start, Date end) {
		this();
		setNotOccured(false);

		setCode(code);
		addValue(value);
		setStartDate(start);
		setEndDate(end);
		setId(null);
	}

	/**
	 * Instantiates a new problem entry.
	 * 
	 * @param observation
	 *            <div class="en">observation</div><div
	 *            class="de">Beobachtung</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Problem(Observation observation) {
		mProblemEntry = (org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry) observation;
	}

	/**
	 * <div class="en">Creates an object, which represents a medical problem.
	 * This constructor is used, if a risc of complication or a risc of exposure
	 * exists for this patient</div><div class="de">Erzeugt ein Objekt welches
	 * ein Problem repräsentiert. Dieses Objekt kann einem ProblemConcernEntry
	 * hinzugefügt werden. Dieser Konstruktor wird verwendet, wenn für den
	 * Patienten ein Komplikationsrisiko besteht.</div>
	 * 
	 * @param risc
	 *            <div class="en">risc of complication</div><div
	 *            class="de">Komplikationsrisiko</div>
	 * @param start
	 *            <div class="en">start</div><div class="de">start</div> <div
	 *            class="fr"> start</div> <div class="it"> start</div>
	 * @param end
	 *            <div class="en">end</div><div class="de"> ende</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 */
	public Problem(RiscOfComplications risc, Date start, Date end) {
		this(ProblemType.PROBLEM.getCode(), new Value(risc.getCode()), start, end);
	}

	/**
	 * <div class="en">Creates an object, which represents a medical problem.
	 * This constructor is used, if a risc of complication or a risc of exposure
	 * exists for this patient</div><div class="de">Erzeugt ein Objekt welches
	 * ein Problem repräsentiert. Dieses Objekt kann einem ProblemConcernEntry
	 * hinzugefügt werden. Dieser Konstruktor wird verwendet, wenn für den
	 * Patienten ein Expositionsrisiko besteht.</div>
	 * 
	 * @param risc
	 *            <div class="en">risc of exposure</div><div
	 *            class="de">Expositionsrisiko</div>
	 * @param start
	 *            <div class="en">start</div><div class="de"> start</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 * @param end
	 *            <div class="en">end</div><div class="de">ende</div> <div
	 *            class="fr"></div> <div class="it"></div>
	 */
	public Problem(RiscOfExposure risc, Date start, Date end) {
		this(ProblemType.PROBLEM.getCode(), new Value(risc.getCode()), start, end);
	}

	/**
	 * Adds the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void addId(Identificator id) {
		final II ii = Util.createUuidVacdIdentificator(id);
		mProblemEntry.getIds().add(ii);
	}

	/**
	 * <div class="en">In Switzerland the following code systems are allowed to
	 * express further problem concerns: CHOP 2.16.756.5.30.1.126.3.1 ICD-10
	 * 2.16.756.5.30.1.126.3.2 ICPC-2 2.16.840.1.113883.6.139 VVK-EDI
	 * 2.16.756.5.30.1.127.3.1.20080401.1 SNOMED CT 2.16.840.1.113883.6.96</div>
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
		final Value value = new Value(code);
		this.addValue(value);
	}

	/**
	 * <div class="en">In Switzerland the following code systems are allowed to
	 * express further problem concerns: CHOP 2.16.756.5.30.1.126.3.1 ICD-10
	 * 2.16.756.5.30.1.126.3.2 ICPC-2 2.16.840.1.113883.6.139 VVK-EDI
	 * 2.16.756.5.30.1.127.3.1.20080401.1 SNOMED CT
	 * 2.16.840.1.113883.6.96</div><div class="de">Für die Angabe weiterer
	 * Leiden des Patienten sind in der Schweiz folgende Codesysteme (oder
	 * Unterknoten davon) zugelassen: CHOP 2.16.756.5.30.1.126.3.1 ICD-10
	 * 2.16.756.5.30.1.126.3.2 ICPC-2 2.16.840.1.113883.6.139 VVK-EDI
	 * 2.16.756.5.30.1.127.3.1.20080401.1 SNOMED CT 2.16.840.1.113883.6.96
	 * </div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param problemValue
	 *            the new value
	 */
	public void addValue(Value problemValue) {
		if (problemValue == null) {
			final CD cd = DatatypesFactory.eINSTANCE.createCD();
			cd.setNullFlavor(NullFlavor.UNK);
			mProblemEntry.getValues().add(cd);
		} else {
			mProblemEntry.getValues().add(problemValue.getValue());
		}
	}

	/**
	 * <div class="en">Adds a text to the value</div> <div class="de">Fügt dem
	 * Wert (Value) einen Text hinzu</div> <div class="fr"></div> <div
	 * class="it"></div>
	 * 
	 * @param text
	 * <br>
	 *            <div class="de"> value</div> <div class="fr"> value</div> <div
	 *            class="it"> value</div>
	 */
	public void addValueText(String text) {
		final CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setNullFlavor(NullFlavor.UNK);
		cd.setOriginalText(Util.createEd(text));
		mProblemEntry.getValues().add(cd);
	}

	/**
	 * <div class="en">Copy mdht problem entry.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 * 
	 * @return the org.openhealthtools.mdht.uml.cda.ihe. problem entry
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry copyMdhtProblemEntry() {
		return EcoreUtil.copy(mProblemEntry);
	}

	/**
	 * <div class="en">Gets the code of the problem</div> <div class="de">Gibt
	 * den Code des Problems zurück.</div> <div class="fr"></div> <div
	 * class="it"></div>
	 * 
	 * @return the codedProblem object
	 */
	public org.ehealth_connector.common.Code getCode() {
		final org.ehealth_connector.common.Code code = new org.ehealth_connector.common.Code(
				mProblemEntry.getCode());
		return code;
	}

	/**
	 * <div class="en">Gets the point in time, since the problem is
	 * terminated</div> <div class="de">Gibt das Zeitpunkt zurück, seitdem das
	 * Problems beendet ist</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return the endOfProblem Object
	 */
	public String getEndDate() {
		if (mProblemEntry.getEffectiveTime() != null) {
			if (mProblemEntry.getEffectiveTime().getHigh() != null) {
				return Util.createEurDateStrFromTS(mProblemEntry.getEffectiveTime().getHigh()
						.getValue());
			}
		}
		return null;
	}

	/**
	 * <div class="en">gets the (first) internal id (e.g. known from a medical
	 * record) for the problem. If no id is known, then null will be
	 * returned.</div> <div class="de">Liefert die (erste) interne (z.B. aus der
	 * Krankenakte bekannte) ID für das Problem. Ist keine ID vorhanden, wird
	 * null zurückgegeben.</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return the new id
	 */
	public Identificator getId() {
		Identificator id = null;
		if (mProblemEntry.getIds() != null && mProblemEntry.getIds().size() > 0) {
			id = new Identificator(mProblemEntry.getIds().get(0));
		}
		return id;
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
		for (final II id : mProblemEntry.getIds()) {
			if (id.getRoot().equalsIgnoreCase(codeSystem.getCodeSystemId())) {
				ident = new Identificator(id);
			}
		}
		return ident;
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
	 * <div class="en">gets the information, if the problem is not occured</div>
	 * <div class="de">Gibt zurück, ob das Problem nicht aufgetreten ist.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return the problemNotOccured Object
	 */
	public boolean getProblemNotOccured() {
		return mProblemEntry.getNegationInd();
	}

	/**
	 * <div class="en">gets the point in time, when the problem started</div>
	 * <div class="de">Gibt den Zeitpunkt zurück, seit das Problems angefangen
	 * hat</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return the startOfProblem Object
	 */
	public String getStartDate() {
		if (mProblemEntry.getEffectiveTime() != null) {
			if (mProblemEntry.getEffectiveTime().getLow() != null) {
				return Util.createEurDateStrFromTS(mProblemEntry.getEffectiveTime().getLow()
						.getValue());
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
		final Value value = new Value(mProblemEntry.getValues().get(0));
		return value;
	}

	/**
	 * Gets a list of all problem values. Each Value may be a coded or uncoded
	 * String.
	 * 
	 * @return all problem values as ArrayList.
	 */
	public List<Value> getValues() {
		final List<Value> vl = new ArrayList<Value>();
		for (final ANY a : mProblemEntry.getValues()) {
			final Value v = new Value(a);
			vl.add(v);
		}
		return vl;
	}

	/**
	 * Sets the code.
	 * 
	 * @param codedProblem
	 *            the codedProblem Object which will be set
	 */
	public void setCode(org.ehealth_connector.common.Code codedProblem) {
		mProblemEntry.setCode(codedProblem.getCD());
	}

	/**
	 * Sets the code.
	 * 
	 * @param kindOfProblem
	 *            the new code
	 */
	public void setCode(ProblemType kindOfProblem) {
		mProblemEntry.setCode(kindOfProblem.getCD());
	}

	/**
	 * <div class="en">sets the point in time, when the problem had ended</div>
	 * <div class="de">Setzt den Zeitpunkt, seitdem das Problems beendet
	 * ist</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param endOfProblem
	 *            the endOfProblem Object which will be set
	 */
	public void setEndDate(Date endOfProblem) {
		try {
			mProblemEntry.getEffectiveTime().setHigh(DateUtil.createIVXB_TSFromDate(endOfProblem));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <div class="en"><div class="en">gets the (first) internal id (e.g. known
	 * from a medical record) for the problem. If null is provided, a new id
	 * will be generated.</div></div> <div class="de">Setzt eine interne (z.B.
	 * aus der Krankenakte bekannte) ID für das Problem. Wird null angegeben,
	 * dann wird eine ID generiert.</div> <div class="fr"></div> <div
	 * class="it"></div>
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Identificator id) {
		final II ii = Util.createIdentificator(id);
		mProblemEntry.getIds().add(ii);
	}

	/**
	 * <div class="en">true, if the problem is not occured (negationInd), false
	 * otherwise</div> <div class="de">true, wenn das Problem nicht aufgetreten
	 * ist, false sonst (negationInd)</div> <div class="fr"></div> <div
	 * class="it"></div>
	 * 
	 * @param problemNotOccured
	 *            the problemNotOccured Object which will be set
	 */
	public void setNotOccured(boolean problemNotOccured) {
		mProblemEntry.setNegationInd(problemNotOccured);
	}

	/**
	 * <div class="en">point in time, when the problem started</div> <div
	 * class="de">Setzt den Zeitpunkt, an dem das Problems angefangen hat</div>
	 * <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param startOfProblem
	 *            the startOfProblem Object which will be set
	 */
	public void setStartDate(Date startOfProblem) {
		if (mProblemEntry.getEffectiveTime() == null) {
			final IVL_TS interval = DatatypesFactory.eINSTANCE.createIVL_TS();
			mProblemEntry.setEffectiveTime(interval);
		}
		try {
			mProblemEntry.getEffectiveTime().setLow(DateUtil.createIVXB_TSFromDate(startOfProblem));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}
}
