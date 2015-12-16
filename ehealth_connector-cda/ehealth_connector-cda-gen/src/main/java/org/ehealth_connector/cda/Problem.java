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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.ch.ProblemEntry;
import org.ehealth_connector.cda.ch.enums.ProblemType;
import org.ehealth_connector.cda.ch.enums.ProblemsSpecialConditions;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * <div class="en">Medical problem in a structured form (e.g. symptom, concern,
 * diagnosis)</div><div class="de">Medzinisches Problem in strukturierter Angabe
 * (z.B. Symptom, Beschwerde, Diagnose, etc.)</div>
 * 
 * use org.ehealth_connector.cda.ProblemEntry whenever possible
 */
public class Problem extends ProblemEntry {

	/**
	 * Instantiates a new problem entry.
	 */
	public Problem() {
		super();
	}

	/**
	 * <div class="en">Creates an object, which represents a medical problem.
	 * This constructor is used, when an empty object should be initialized or
	 * it should be expressed that the patient has no current problems.</div>
	 * <div class="de">Erzeugt ein Objekt welches ein Problem repräsentiert.
	 * Dieses Objekt kann einem ProblemConcernEntry hinzugefügt werden. Dieser
	 * Konstruktor wird verwendet, wenn ein leeres Object initialisiert werden
	 * soll oder codiert werden soll, dass der Patient keine aktuellen Probleme
	 * hat.</div>
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
	 *            Code für eine Diagnose)</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param value
	 *            <div class="en">description (e.g. inflammation of the
	 *            lungs)</div><div class="de">Beschreibung des Problems (z.B.
	 *            Lungenentzündung)</div> <div class="fr"></div>
	 *            <div class="it"></div>
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
	 *            (z.B. SNOMED Code für eine Diagnose)</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 * @param value
	 *            <div class="en">code for the problem itself (e.g. inflammation
	 *            of the lungs)</div><div class="de">Code zur Beschreibung des
	 *            eigentlichen Problems (z.B. Lungenentzündung)</div>
	 *            <div class="fr"></div> <div class="it"></div>
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
	}

	/**
	 * Instantiates a new problem entry.
	 * 
	 * @param observation
	 *            <div class="en">observation</div>
	 *            <div class="de">Beobachtung</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Problem(org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry observation) {
		super(observation);
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
	 * CT 2.16.840.1.113883.6.96 </div> <div class="fr"></div>
	 * <div class="it"></div>
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
	 * 2.16.756.5.30.1.127.3.1.20080401.1 SNOMED CT 2.16.840.1.113883.6.96</div>
	 * <div class="de">Für die Angabe weiterer Leiden des Patienten sind in der
	 * Schweiz folgende Codesysteme (oder Unterknoten davon) zugelassen: CHOP
	 * 2.16.756.5.30.1.126.3.1 ICD-10 2.16.756.5.30.1.126.3.2 ICPC-2
	 * 2.16.840.1.113883.6.139 VVK-EDI 2.16.756.5.30.1.127.3.1.20080401.1 SNOMED
	 * CT 2.16.840.1.113883.6.96 </div> <div class="fr"></div>
	 * <div class="it"></div>
	 * 
	 * @param problemValue
	 *            the new value
	 */
	public void addValue(Value problemValue) {
		if (problemValue == null) {
			final CD cd = DatatypesFactory.eINSTANCE.createCD();
			cd.setNullFlavor(NullFlavor.UNK);
			getMdht().getValues().add(cd);
		} else {
			getMdht().getValues().add(problemValue.getValue());
		}
	}

	/**
	 * <div class="en">Adds a text to the value</div> <div class="de">Fügt dem
	 * Wert (Value) einen Text hinzu</div> <div class="fr"></div>
	 * <div class="it"></div>
	 * 
	 * @param text
	 *            <br>
	 *            <div class="de">the text</div><div class="de">der Text</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public void addValueText(String text) {
		final CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setNullFlavor(NullFlavor.UNK);
		cd.setOriginalText(Util.createEd(text));
		getMdht().getValues().add(cd);
	}

	/**
	 * Gets a list of all problem values. Each Value may be a coded or uncoded
	 * String.
	 * 
	 * @return all problem values as ArrayList.
	 */
	public List<Value> getValues() {
		final List<Value> vl = new ArrayList<Value>();
		for (final ANY a : getMdht().getValues()) {
			final Value v = new Value(a);
			vl.add(v);
		}
		return vl;
	}

	/**
	 * Sets the code.
	 * 
	 * @param kindOfProblem
	 *            the new code
	 */
	public void setCode(ProblemType kindOfProblem) {
		getMdht().setCode(kindOfProblem.getCD());
	}

}
