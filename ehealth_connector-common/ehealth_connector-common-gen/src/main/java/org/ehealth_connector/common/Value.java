/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */

package org.ehealth_connector.common;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.enums.Ucum;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.BL;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.INT;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_INT;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVXB_INT;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVXB_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.QTY;
import org.openhealthtools.mdht.uml.hl7.datatypes.RTO;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * Ein Wert bestehend aus eigentlichem Wert und der zugehörigen Einheit.
 */
public class Value {

	/**
	 * The m value.
	 */
	private final ANY mValue;

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
	 * Creates a new BigDecimal value.
	 *
	 * @param value
	 *            The value
	 */
	public Value(BigDecimal value) {
		this(DatatypesFactory.eINSTANCE.createPQ());
		final PQ pq = (PQ) mValue;
		pq.setValue(value);
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
		mlow.setUnit("");
		ivlPq.setLow(mlow);

		mhigh.setValue(high);
		mhigh.setUnit("");
		ivlPq.setHigh(mhigh);

		mValue = ivlPq;
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
	public Value(BigDecimal low, String lowUnit, BigDecimal high, String highUnit) {
		final IVL_PQ ivlPq = DatatypesFactory.eINSTANCE.createIVL_PQ();
		final IVXB_PQ mlow = DatatypesFactory.eINSTANCE.createIVXB_PQ();
		final IVXB_PQ mhigh = DatatypesFactory.eINSTANCE.createIVXB_PQ();

		mlow.setValue(low);
		mlow.setUnit(lowUnit);
		ivlPq.setLow(mlow);

		mhigh.setValue(high);
		mhigh.setUnit(highUnit);
		ivlPq.setHigh(mhigh);

		mValue = ivlPq;
	}

	public Value(BigDecimal low, Ucum lowUnit, BigDecimal high, Ucum highUnit) {
		this(low, lowUnit.getCodeValue(), high, highUnit.getCodeValue());
	}

	/**
	 * <div class="en">Instantiates a new value with the parameters for a MDHT
	 * IVL_INT Objekt with two INT Values (A low and high bound of the
	 * interval).</div> <div class="de">Instantiiert eine neues Value MDHT
	 * IVL_INT Objekt mit zwei INT Werten (entspricht dem unteren und dem oberen
	 * Ende des Intervalls).</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param low
	 *            The lower bound
	 *
	 * @param high
	 *            The upper bound
	 */
	public Value(BigInteger low, BigInteger high) {
		final IVL_INT ivlInt = DatatypesFactory.eINSTANCE.createIVL_INT();
		final IVXB_INT mlow = DatatypesFactory.eINSTANCE.createIVXB_INT();
		final IVXB_INT mhigh = DatatypesFactory.eINSTANCE.createIVXB_INT();

		mlow.setValue(low);
		ivlInt.setLow(mlow);

		mhigh.setValue(high);
		ivlInt.setHigh(mhigh);

		mValue = ivlInt;
	}

	/**
	 * <div class="en">Instantiates a new value with a given boolean
	 * Object.</div> <div class="de">Instantiiert eine neues Value Objekt. Value
	 * repräsentiert den Wert z.B. zu einer Beobachtung oder Diagnose. Mit
	 * diesem Konstruktor wird ein Value Objekt auf Basis eines Java boolean
	 * initialisiert (CDA Datentyp: BL)</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param bl
	 *            <div class="en">the boolean value</div> <div class="de">der
	 *            boolean Wert</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Value(BL bl) {
		mValue = bl;
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
		final BL bl = DatatypesFactory.eINSTANCE.createBL();
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
	 * Erstellt einen neuen Wert double.
	 *
	 * @param value
	 *            Der eigentliche Wert
	 */
	public Value(double value) {
		this(DatatypesFactory.eINSTANCE.createPQ());
		final PQ pq = (PQ) mValue;
		pq.setValue(Double.valueOf(value));
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
	public Value(Double low, Double high) {
		final IVL_PQ ivlPq = DatatypesFactory.eINSTANCE.createIVL_PQ();
		final IVXB_PQ mlow = DatatypesFactory.eINSTANCE.createIVXB_PQ();
		final IVXB_PQ mhigh = DatatypesFactory.eINSTANCE.createIVXB_PQ();

		mlow.setValue(low);
		mlow.setUnit("");
		ivlPq.setLow(mlow);

		mhigh.setValue(high);
		mhigh.setUnit("");
		ivlPq.setHigh(mhigh);

		mValue = ivlPq;
	}

	public Value(ED ed) {
		mValue = ed;
	}

	/**
	 * Erstellt einen neuen Wert (INT).
	 *
	 * @param value
	 *            Der eigentliche Wert
	 */
	public Value(int value) {
		this(DatatypesFactory.eINSTANCE.createINT());
		setIntValue(value);
	}

	/**
	 * Creates a new INT value.
	 *
	 * @param value
	 *            The value.
	 */
	public Value(Integer value) {
		this(DatatypesFactory.eINSTANCE.createINT());
		setIntValue(value);
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
	 * Erstellt einen neuen Wert (ST).
	 *
	 * @param value
	 *            Der eigentliche Wert
	 */
	public Value(ST value) {
		mValue = value;
	}

	public Value(String text) {
		mValue = Util.createEd(text);
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
	 * Returns the text of the underlying MDHT type BL
	 *
	 * @return the text of the underlying type BL
	 */
	public String getBlText() {
		if (isBl()) {
			final BL bl = (BL) mValue;
			if (bl.getValue() != null)
				return bl.getValue().toString();
		}
		return null;
	}

	/**
	 * Return if this Value of the underlying MDHT type BL (boolean) is true or
	 * false
	 *
	 * @return the value of the underlying type BL
	 */
	public boolean getBoolean() {
		if (isBl()) {
			final BL bl = (BL) mValue;
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
			final ED ed = (ED) mValue;
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
			final ED ed = (ED) mValue;
			return ed.getText();
		}
		return null;
	}

	/**
	 * Returns the text of the underlying MDHT type INT
	 *
	 * @return the text of the underlying type INT
	 */
	public String getIntText() {
		if (isInt()) {
			final INT val = (INT) mValue;
			if (val.getValue() != null)
				return val.getValue().toString();
		}
		return null;
	}

	public String getOriginalTextReference() {
		final Code code = new Code((CD) mValue);
		return code.getOriginalTextReference();
	}

	/**
	 * Get mdht physical quantity.
	 *
	 * @return PQ the PQ object
	 */
	public PQ getPhysicalQuantity() {
		return ((PQ) mValue);
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
			final IVL_PQ ivlPq = (IVL_PQ) mValue;
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
			final IVL_PQ ivlPq = (IVL_PQ) mValue;
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
	 * Returns the unit of the underlying MDHT type RTO (Ratio)
	 *
	 * @return the unit of the underlying type RTO
	 */
	public String getRtoUnitText() {
		if (isRto()) {
			final RTO rto = (RTO) mValue;
			String retVal = "";
			String numeratorUnit = "";
			String denominatorUnit = "";

			if (rto != null) {
				QTY numerator = rto.getNumerator();
				QTY denominator = rto.getDenominator();
				if (numerator != null) {
					if (numerator instanceof PQ) {
						numeratorUnit = ((PQ) numerator).getUnit();
					}
				}
				if (denominator != null) {
					if (denominator instanceof PQ) {
						denominatorUnit = ((PQ) denominator).getUnit();
					}
				}
			}
			if (!"".equals(numeratorUnit))
				numeratorUnit = " " + numeratorUnit;
			if (!"".equals(denominatorUnit))
				denominatorUnit = " " + denominatorUnit;

			if (numeratorUnit.equals(denominatorUnit))
				retVal = numeratorUnit;
			else
				retVal = numeratorUnit + " / " + denominatorUnit;

			return retVal;
		}
		return null;
	}

	/**
	 * Returns the text of the underlying MDHT type RTO (Ratio)
	 *
	 * @return the text of the underlying type RTO
	 */
	public String getRtoValueText() {
		if (isRto()) {
			final RTO rto = (RTO) mValue;
			String retVal = "";
			String numeratorValue = "";
			String denominatorValue = "";

			if (rto != null) {
				QTY numerator = rto.getNumerator();
				QTY denominator = rto.getDenominator();
				if (numerator != null) {
					if (numerator instanceof PQ) {
						numeratorValue = ((PQ) numerator).getValue().toString();
					} else
						numeratorValue = "*** TODO: This is not yet implemented value type...";
				}
				if (denominator != null) {
					if (denominator instanceof PQ) {
						denominatorValue = ((PQ) denominator).getValue().toString();
					} else
						denominatorValue = "*** TODO: This is not yet implemented value type...";
				}
			}
			retVal = numeratorValue + " / " + denominatorValue;
			return retVal;
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
	 * Checks if the Value object is an INT.
	 *
	 * @return boolean true, if it is INT, false otherwise
	 */
	public boolean isInt() {
		return (mValue instanceof INT);
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

	/**
	 * Checks if the Value object has the Datatype ST (String).
	 *
	 * @return boolean true, if it is ST, false otherwise
	 */
	public boolean isSt() {
		return (mValue instanceof ST);
	}

	private void setIntValue(int value) {
		INT i = (INT) mValue;
		i.setValue(value);
	}

	public void setOriginalTextReference(String originalText) {
		if (mValue instanceof CD) {
			final Code code = new Code((CD) mValue);
			code.setOriginalTextReference(originalText);
		}
		if (mValue instanceof ED) {
			final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
			if (!originalText.startsWith("#")) {
				originalText = "#" + originalText;
			}
			tel.setValue(originalText);
			((ED) mValue).setReference(tel);
		}
	}

	private void setPqValue(String value) {
		final PQ pq = (PQ) mValue;
		pq.setValue(Double.valueOf(value));
	}

	public void setUcumUnit(String unit) {
		final PQ pq = (PQ) mValue;
		pq.setUnit(unit);
	}

	private void setUcumUnit(Ucum unit) {
		final PQ pq = (PQ) mValue;
		pq.setUnit(unit.getCodeValue());
	}

	/**
	 * <div class="en">Gets the value as String (e.g. "200 ml" )</div>
	 *
	 * @return <div class="en">the value</div>
	 */
	@Override
	public String toString() {
		// Resultat
		String resultText = "";
		if (isCode()) {
			if (getCode().getOriginalText() != null)
				resultText = getCode().getOriginalText();
			if ("".equals(resultText))
				// TODO This is draft implementation only! the text needs to be
				// translated by the real code. Displaynames should never be
				// used!
				resultText = getCode().getDisplayName();
		} else if (isPhysicalQuantity())
			resultText = getPhysicalQuantityValue() + " " + getPhysicalQuantityUnit();
		else if (isEd())
			resultText = getEdText();
		else if (isBl())
			resultText = getBlText();
		else if (isRto())
			resultText = getRtoValueText() + " " + getRtoUnitText();
		else if (isInt())
			resultText = getIntText();
		else
			resultText = "*** TODO: This is not yet implemented value type...";

		if (resultText == null)
			resultText = "";

		resultText = resultText.replace("&lt;", "<");
		resultText = resultText.replace("&gt;", ">");

		return resultText;
	}
}
