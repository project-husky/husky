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

package org.ehealth_connector.common;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.ConvenienceUtilsEnums.UCUM;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.RTO;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * Ein Wert bestehend aus eigentlichem Wert und der zugehörigen Einheit.
 */
public class Value {

	/**
	 * The m value.
	 */
	private ANY mValue;

	/**
	 * <div class="en">Instantiates a new value with a given MDHT ANY
	 * Objekt</div> <div class="de">Instantiiert ein neues Value Objekt. Value
	 * repräsentiert den Wert z.B. zu einer Beobachtung oder Diagnose. Mit
	 * diesem Konstruktor wird ein Value Objekt auf Basis eines MDHT ANY
	 * Datenobjekts initialisiert.</div> <div class="fr"></div> <div
	 * class="it"></div>
	 *
	 * @param value
	 * <br>
	 *            <div class="de"> value</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Value(ANY value) {
		mValue = value;
	}

	/**
	 * <div class="en">Instantiates a new value with a give MDHT CD
	 * Objekt.</div> <div class="de">Instantiiert eine neues Value Objekt. Value
	 * repräsentiert den Wert z.B. zu einer Beobachtung oder Diagnose. Mit
	 * diesem Konstruktor wird ein Value Objekt auf Basis eines MDHT CD (Code)
	 * Datenobjekts initialisiert.</div> <div class="fr"></div> <div
	 * class="it"></div>
	 *
	 * @param cd
	 * <br>
	 *            <div class="de"> cd</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Value(CD cd) {
		mValue = cd;
	}

	/**
	 * <div class="en">Instantiates a new value with a give MDHT RTO Objekt (A
	 * quantity constructed as the quotient of a numerator quantity divided by a
	 * denominator quantity.).</div> <div class="de">Instantiiert eine neues
	 * Value RTO Objekt. Dieses wird häufig für die Angabe von Titer verwendet.
	 * Mit diesem Konstruktor wird ein Value Objekt auf Basis eines MDHT RTO
	 * Datenobjekts initialisiert.</div> <div class="fr"></div> <div
	 * class="it"></div>
	 *
	 * @param cd
	 * <br>
	 *            <div class="de"> cd</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Value(RTO rto) {
		mValue = rto;
	}

	/**
	 * <div class="en">Instantiates a new value with a given Code Object.</div>
	 * <div class="de">Instantiiert eine neues Value Objekt. Value repräsentiert
	 * den Wert z.B. zu einer Beobachtung oder Diagnose. Mit diesem Konstruktor
	 * wird ein Value Objekt auf Basis eines Convenience API Code Datenobjekts
	 * initialisiert.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Value(Code code) {
		mValue = code.getCD();
	}

	/**
	 * <div class="en">Instantiates a new value.</div> <div
	 * class="de">Instantiiert eine neues Value Objekt. Value repräsentiert den
	 * Wert z.B. zu einer Beobachtung oder Diagnose. Mit diesem Konstruktor wird
	 * ein Value Objekt auf Basis eines MDHT PQ (Physical Quantity) Datenobjekts
	 * initialisiert.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param pq
	 * <br>
	 *            <div class="de"> pq</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Value(PQ pq) {
		mValue = pq;
	}

	/**
	 * <div class="en">Instantiates a new value.</div> <div
	 * class="de">Instantiiert eine neues Value Objekt. Value repräsentiert den
	 * Wert z.B. zu einer Beobachtung oder Diagnose. Mit diesem Konstruktor wird
	 * ein Value Objekt auf Basis von einem CodeSytem und einem Code
	 * initialisiert.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param codeSystem
	 * <br>
	 *            <div class="de"> code system</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param code
	 * <br>
	 *            <div class="de"> code</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Value(String codeSystem, String code) {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(codeSystem);
		cd.setCode(code);
		mValue = cd;
	}

	/**
	 * Erstellt einen neuen Wert.
	 *
	 * @param value
	 *            Der eigentliche Wert
	 * @param unit
	 *            Die Einheit
	 */
	public Value(String value, UCUM unit) {
		this(DatatypesFactory.eINSTANCE.createPQ());
		setPqValue(value);
		setUcumUnit(unit);
	}

	/**
	 * <div class="en">Instantiates a new value.</div> <div
	 * class="de">Instantiiert eine neues Value Objekt. Value repräsentiert den
	 * Wert z.B. zu einer Beobachtung oder Diagnose. Mit diesem Konstruktor wird
	 * ein Value Objekt auf Basis von einem CodeSytem und einem Code
	 * initialisiert.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param codeSystem
	 * <br>
	 *            <div class="de"> code system</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param code
	 * <br>
	 *            <div class="de"> code</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Value(double numerator, double denominator, UCUM ucumUnit) {
		RTO rto = DatatypesFactory.eINSTANCE.createRTO();

		PQ pq1 = DatatypesFactory.eINSTANCE.createPQ();
		pq1.setUnit(ucumUnit.name());
		pq1.setValue(numerator);
		PQ pq2 = DatatypesFactory.eINSTANCE.createPQ();
		pq2.setUnit(ucumUnit.name());
		pq2.setValue(denominator);

		rto.setNumerator(pq1);
		rto.setDenominator(pq2);
		mValue = rto;
	}

	/**
	 * <div class="en">Copy mdht code.</div> <div class="de"></div> <div
	 * class="fr"></div> <div class="it"></div>
	 *
	 * @return CD the MDHT CD object
	 */
	public CD copyMdhtCode() {
		return EcoreUtil.copy((CD) mValue);
	}

	/**
	 * <div class="en">Copy mdht physical quantity.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return PQ the PQ object
	 */
	public PQ copyMdhtPhysicalQuantity() {
		return EcoreUtil.copy((PQ) mValue);
	}

	public RTO copyMdhtRto() {
		return EcoreUtil.copy((RTO) mValue);
	}

	/**
	 * <div class="en">Gets the code.</div> <div class="de">Liefert code.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Code <div class="en">the convenience API Code object</div>
	 */
	public Code getCode() {
		Code code = new Code((CD) mValue);
		return code;
	}

	/**
	 * Gibt die Einheit zurück.
	 *
	 * @return Die Einheit
	 */
	public String getPhysicalQuantityUnit() {
		if (isPhysicalQuantity()) {
			PQ pq = (PQ) mValue;
			return pq.getUnit();
		} else {
			return null;
		}
	}

	/**
	 * Gibt den Wert zurück.
	 *
	 * @return Der eigentlich Wert
	 */
	public String getPhysicalQuantityValue() {
		if (isPhysicalQuantity()) {
			PQ pq = (PQ) mValue;
			return String.valueOf(pq.getValue());
		}
		return null;
	}

	/**
	 * <div class="en">Gets the value.</div> <div class="de">Liefert
	 * value.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return ANY <div class="en">the value as MDHT ANY object</div>
	 */
	public ANY getValue() {
		if (mValue == null) {
			mValue.setNullFlavor(NullFlavor.UNK);
		}
		return mValue;
	}

	/**
	 * Checks if the Value Object is a code.
	 *
	 * @return boolean true, if the Value is a code, false otherwise
	 */
	public boolean isCode() {
		if (mValue instanceof CD) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if the Value object is a physical quantity.
	 *
	 * @return boolean true, if it is physical quantity, false otherwise
	 */
	public boolean isPhysicalQuantity() {
		if (mValue instanceof PQ) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if the Value object is a RTO (A quantity constructed as the
	 * quotient of a numerator quantity divided by a denominator quantity.).
	 *
	 * @return boolean true, if it is physical quantity, false otherwise
	 */
	public boolean isRto() {
		if (mValue instanceof RTO) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * <div class="en">Gets the value as String (e.g.
	 * "Value [value=200, unit=ml]")</div> <div class="de">Liefert value.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the value</div>
	 */
	@Override
	public String toString() {
		return "Value [value=" + getPhysicalQuantityValue() + ", unit="
				+ getPhysicalQuantityUnit() + "]";
	}

	private void setPqValue(String value) {
		PQ pq = (PQ) mValue;
		pq.setValue(Double.valueOf(value));
	}

	private void setUcumUnit(UCUM unit) {
		PQ pq = (PQ) mValue;
		pq.setUnit(unit.toString());
	}

}
