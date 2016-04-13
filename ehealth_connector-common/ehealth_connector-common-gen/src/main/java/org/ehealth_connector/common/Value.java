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

import java.math.BigDecimal;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.enums.Ucum;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.BL;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVXB_PQ;
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
	 * Datenobjekts initialisiert.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param value
	 *            <br>
	 *            <div class="de"> value</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Value(ANY value) {
		mValue = value;
	}

	/**
	 * <div class="en">Instantiates a new value with a given MDHT ANY Objekt and
	 * an nullFlavor</div> <div class="de">Instantiiert ein neues Value Objekt.
	 * Value repräsentiert den Wert z.B. zu einer Beobachtung oder Diagnose. Mit
	 * diesem Konstruktor wird ein Value Objekt auf Basis eines MDHT ANY
	 * Datenobjekts und einem NullFlavor initialisiert.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param value
	 *            <br>
	 *            <div class="de"> value</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Value(ANY value, NullFlavor nullFlavor) {
		mValue = value;
		value.setNullFlavor(nullFlavor);
	}

	/**
	 * <div class="en">Instantiates a new value with the parameters for a MDHT
	 * IVL_PQ Objekt with two PQ Values (A low and high bound of physical
	 * quantities).</div> <div class="de">Instantiiert eine neues Value MDHT
	 * IVL_PQ Objekt mit zwei PQ Werten (entspricht zwei Grenzen von
	 * physikalischen Messgrößen).</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param low
	 *            The lower bound
	 *
	 * @param high
	 *            The upper bound
	 */
	public Value(BigDecimal low, BigDecimal high) {
		final IVL_PQ ivlPq = DatatypesFactory.eINSTANCE.createIVL_PQ();
		final IVXB_PQ mlow = DatatypesFactory.eINSTANCE.createIVXB_PQ();
		final IVXB_PQ mhigh = DatatypesFactory.eINSTANCE.createIVXB_PQ();

		mlow.setValue(low);
		ivlPq.setLow(mlow);

		mhigh.setValue(high);
		ivlPq.setHigh(mhigh);

		mValue = ivlPq;
	}

	/**
	 * <div class="en">Instantiates a new value with a given boolean
	 * Object.</div> <div class="de">Instantiiert eine neues Value Objekt. Value
	 * repräsentiert den Wert z.B. zu einer Beobachtung oder Diagnose. Mit
	 * diesem Konstruktor wird ein Value Objekt auf Basis eines Java boolean
	 * initialisiert (CDA Datentyp: BL)</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Value(boolean code) {
		BL bl = DatatypesFactory.eINSTANCE.createBL();
		bl.setValue(code);
		mValue = bl;
	}

	/**
	 * <div class="en">Instantiates a new value with a give MDHT CD
	 * Objekt.</div> <div class="de">Instantiiert eine neues Value Objekt. Value
	 * repräsentiert den Wert z.B. zu einer Beobachtung oder Diagnose. Mit
	 * diesem Konstruktor wird ein Value Objekt auf Basis eines MDHT CD (Code)
	 * Datenobjekts initialisiert.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param cd
	 *            <br>
	 *            <div class="de"> cd</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Value(CD cd) {
		mValue = cd;
	}

	/**
	 * <div class="en">Instantiates a new value with a given Code Object.</div>
	 * <div class="de">Instantiiert eine neues Value Objekt. Value repräsentiert
	 * den Wert z.B. zu einer Beobachtung oder Diagnose. Mit diesem Konstruktor
	 * wird ein Value Objekt auf Basis eines Convenience API Code Datenobjekts
	 * initialisiert.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Value(Code code) {
		mValue = code.getCD();
	}

	/**
	 * <div class="en">Instantiates a new value with the parameters for a MDHT
	 * RTO Objekt (A quantity constructed as the quotient of a numerator
	 * quantity divided by a denominator quantity.).</div>
	 * <div class="de">Instantiiert eine neues Value RTO Objekt. Dieses wird
	 * häufig für die Angabe von Titer verwendet. Mit diesem Konstruktor wird
	 * ein Value Objekt auf Basis eines MDHT RTO Datenobjekts
	 * initialisiert.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param numerator
	 *            The nominator value (nominator/denominator)
	 *
	 * @param denominator
	 *            The denominator value (nominator/denominator)
	 * @param ucumUnit
	 *            the UCUM Unit
	 */
	public Value(double numerator, double denominator, Ucum ucumUnit) {
		final RTO rto = DatatypesFactory.eINSTANCE.createRTO();

		final PQ pq1 = DatatypesFactory.eINSTANCE.createPQ();
		pq1.setUnit(ucumUnit.getCodeValue());
		pq1.setValue(numerator);
		final PQ pq2 = DatatypesFactory.eINSTANCE.createPQ();
		pq2.setUnit(ucumUnit.getCodeValue());
		pq2.setValue(denominator);

		rto.setNumerator(pq1);
		rto.setDenominator(pq2);
		mValue = rto;
	}

	public Value(ED ed) {
		mValue = ed;
	}

	/**
	 * <div class="en">Instantiates a new value.</div>
	 * <div class="de">Instantiiert eine neues Value Objekt. Value repräsentiert
	 * den Wert z.B. zu einer Beobachtung oder Diagnose. Mit diesem Konstruktor
	 * wird ein Value Objekt auf Basis eines MDHT PQ (Physical Quantity)
	 * Datenobjekts initialisiert.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param pq
	 *            <br>
	 *            <div class="de"> pq</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Value(PQ pq) {
		mValue = pq;
	}

	/**
	 * <div class="en">Instantiates a new value with a give MDHT RTO Objekt (A
	 * quantity constructed as the quotient of a numerator quantity divided by a
	 * denominator quantity.).</div> <div class="de">Instantiiert eine neues
	 * Value RTO Objekt. Dieses wird häufig für die Angabe von Titer verwendet.
	 * Mit diesem Konstruktor wird ein Value Objekt auf Basis eines MDHT RTO
	 * Datenobjekts initialisiert.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param rto
	 *            The RTO object
	 */
	public Value(RTO rto) {
		mValue = rto;
	}

	/**
	 * <div class="en">Instantiates a new value.</div>
	 * <div class="de">Instantiiert eine neues Value Objekt. Value repräsentiert
	 * den Wert z.B. zu einer Beobachtung oder Diagnose. Mit diesem Konstruktor
	 * wird ein Value Objekt auf Basis eines MDHT ED Objektes mit einem text
	 * oder einer Referenz initalisiert. initialisiert.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param value
	 *            <br>
	 *            <div class="de"> code system</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param isText
	 *            indicates, if the given value is a text (/value will be
	 *            created) or a reference (/value/reference[@value] will be
	 *            created)
	 */
	public Value(String value, boolean isText) {
		final ED ed;
		if (!isText) {
			ed = Util.createReference(value);
		} else {
			ed = Util.createEd(value);
		}
		mValue = ed;
	}

	/**
	 * <div class="en">Instantiates a new value.</div>
	 * <div class="de">Instantiiert eine neues Value Objekt. Value repräsentiert
	 * den Wert z.B. zu einer Beobachtung oder Diagnose. Mit diesem Konstruktor
	 * wird ein Value Objekt auf Basis von einem CodeSytem und einem Code
	 * initialisiert.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param codeSystem
	 *            <br>
	 *            <div class="de"> code system</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Value(String codeSystem, String code) {
		final CD cd = DatatypesFactory.eINSTANCE.createCD();
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
	public Value(String value, Ucum unit) {
		this(DatatypesFactory.eINSTANCE.createPQ());
		setPqValue(value);
		setUcumUnit(unit);
	}

	/**
	 * Method to copy the BL value
	 *
	 * @return BL representing the value
	 */
	public BL copyMdhtBl() {
		return EcoreUtil.copy((BL) mValue);
	}

	/**
	 * <div class="en">Copy mdht code.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
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

	/**
	 * Method to copy the RTO value
	 *
	 * @return RTO represeting the value
	 */
	public RTO copyMdhtRto() {
		return EcoreUtil.copy((RTO) mValue);
	}

	/**
	 * Return if this Value of the underlying MDHT type BL (boolean) is true or
	 * false
	 *
	 * @return the value of the underlying type BL
	 */
	public boolean getBoolean() {
		if (isBl()) {
			BL bl = (BL) mValue;
			return bl.getValue();
		}
		return false;
	}

	/**
	 * <div class="en">Gets the code.</div> <div class="de">Liefert code.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Code <div class="en">the convenience API Code object</div>
	 */
	public Code getCode() {
		final Code code = new Code((CD) mValue);
		return code;
	}

	/**
	 * Returns the reference value of the underlying MDHT type ED (text)
	 *
	 * @return the text of the underlying type ED
	 */
	public String getEdReferenceValue() {
		if (isEd()) {
			ED ed = (ED) mValue;
			return ed.getReference().getValue();
		}
		return null;
	}

	/**
	 * Returns the text of the underlying MDHT type ED (text)
	 *
	 * @return the text of the underlying type ED
	 */
	public String getEdText() {
		if (isEd()) {
			ED ed = (ED) mValue;
			return ed.getText();
		}
		return null;
	}

	public String getOriginalTextReference() {
		final Code code = new Code((CD) mValue);
		return code.getOriginalTextReference();
	}

	/**
	 * <div class="en">Returns the higher bound of an interval of physical
	 * measurements</div> Gibt den oberen Wert eines Intervals physikalischer
	 * Größen zurück.
	 *
	 * @return the measurement
	 */
	public BigDecimal getPhysicalQuantityIntervalHighValue() {
		if (isPhysicalQuantityInterval()) {
			IVL_PQ ivlPq = (IVL_PQ) mValue;
			return ivlPq.getHigh().getValue();
		}
		return null;
	}

	/**
	 * <div class="en">Returns the lower bound of an interval of physical
	 * measurements</div> <div class="de">Gibt den unteren Wert eines Intervals
	 * physikalischer Größen zurück.</div>
	 *
	 * @return the measurement
	 */
	public BigDecimal getPhysicalQuantityIntervalLowValue() {
		if (isPhysicalQuantityInterval()) {
			IVL_PQ ivlPq = (IVL_PQ) mValue;
			return ivlPq.getLow().getValue();
		}
		return null;
	}

	/**
	 * Gibt die Einheit zurück.
	 *
	 * @return Die Einheit
	 */
	public String getPhysicalQuantityUnit() {
		if (isPhysicalQuantity()) {
			final PQ pq = (PQ) mValue;
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
			final PQ pq = (PQ) mValue;
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
	 * Checks if the Value object is a BL (Boolean).
	 *
	 * @return boolean true, if it is Boolean, false otherwise
	 */
	public boolean isBl() {
		return (mValue instanceof BL);
	}

	/**
	 * Checks if the Value Object is a code.
	 *
	 * @return boolean true, if the Value is a code, false otherwise
	 */
	public boolean isCode() {
		// if (mValue instanceof CD) {
		// return true;
		// } else {
		// return false;
		// }
		return (mValue instanceof CD);
	}

	/**
	 * Checks if the Value object has the Datatype ED (Text).
	 *
	 * @return boolean true, if it is ED, false otherwise
	 */
	public boolean isEd() {
		return (mValue instanceof ED);
	}

	/**
	 * Checks if the Value object is a physical quantity.
	 *
	 * @return boolean true, if it is physical quantity, false otherwise
	 */
	public boolean isPhysicalQuantity() {
		return (mValue instanceof PQ);
	}

	private boolean isPhysicalQuantityInterval() {
		return (mValue instanceof IVL_PQ);
	}

	/**
	 * Checks if the Value object is a RTO (A quantity constructed as the
	 * quotient of a numerator quantity divided by a denominator quantity.).
	 *
	 * @return boolean true, if it is physical quantity, false otherwise
	 */
	public boolean isRto() {
		return (mValue instanceof RTO);
	}

	public void setOriginalTextReference(String originalText) {
		final Code code = new Code((CD) mValue);
		code.setOriginalTextReference(originalText);
	}

	private void setPqValue(String value) {
		final PQ pq = (PQ) mValue;
		pq.setValue(Double.valueOf(value));
	}

	private void setUcumUnit(Ucum unit) {
		final PQ pq = (PQ) mValue;
		pq.setUnit(unit.getCodeValue());
	}

	/**
	 * <div class="en">Gets the value as String (e.g.
	 * "Value [value=200, unit=ml]" )</div> <div class="de">Liefert value.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the value</div>
	 */
	@Override
	public String toString() {
		return "Value [value=" + getPhysicalQuantityValue() + ", unit=" + getPhysicalQuantityUnit()
				+ "]";
	}

}
