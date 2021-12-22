/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */

package org.husky.common.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.husky.common.enums.NullFlavor;
import org.husky.common.enums.Ucum;
import org.husky.common.hl7cdar2.ANY;
import org.husky.common.hl7cdar2.BL;
import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.INT;
import org.husky.common.hl7cdar2.IVLINT;
import org.husky.common.hl7cdar2.IVLPQ;
import org.husky.common.hl7cdar2.IVXBINT;
import org.husky.common.hl7cdar2.IVXBPQ;
import org.husky.common.hl7cdar2.PQ;
import org.husky.common.hl7cdar2.QTY;
import org.husky.common.hl7cdar2.RTO;
import org.husky.common.hl7cdar2.ST;
import org.husky.common.hl7cdar2.TEL;

/**
 * Ein Wert bestehend aus eigentlichem Wert und der zugehörigen Einheit.
 */
public class Value {

	private static final String NAMESPACE_HL7_V3 = "urn:hl7-org:v3";

	/**
	 * The m value.
	 */
	private final ANY mValue;

	/**
	 * <div class="en">Instantiates a new value with a given MDHT ANY Objekt</div>
	 * <div class="de">Instantiiert ein neues Value Objekt. Value repräsentiert den
	 * Wert z.B. zu einer Beobachtung oder Diagnose. Mit diesem Konstruktor wird ein
	 * Value Objekt auf Basis eines MDHT ANY Datenobjekts initialisiert.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param value <br>
	 *              <div class="de"> value</div> <div class="fr"></div>
	 *              <div class="it"></div>
	 */
	public Value(ANY value) {
		mValue = value;
	}

	/**
	 * <div class="en">Instantiates a new value with a given MDHT ANY Objekt and an
	 * nullFlavor</div> <div class="de">Instantiiert ein neues Value Objekt. Value
	 * repräsentiert den Wert z.B. zu einer Beobachtung oder Diagnose. Mit diesem
	 * Konstruktor wird ein Value Objekt auf Basis eines MDHT ANY Datenobjekts und
	 * einem NullFlavor initialisiert.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param value <br>
	 *              <div class="de"> value</div> <div class="fr"></div>
	 *              <div class="it"></div>
	 */
	public Value(ANY value, NullFlavor nullFlavor) {
		mValue = value;

		if (nullFlavor != null) {
			mValue.nullFlavor = List.of(nullFlavor.getCodeValue());
		}
	}

	/**
	 * Creates a new BigDecimal value.
	 *
	 * @param value The value
	 */
	public Value(BigDecimal value) {
		this(new PQ());
		final var pq = (PQ) mValue;
		pq.setValue(value.toString());
	}

	/**
	 * <div class="en">Instantiates a new value with the parameters for a MDHT
	 * IVL_PQ Objekt with two PQ Values (A low and high bound of physical
	 * quantities).</div> <div class="de">Instantiiert eine neues Value MDHT IVL_PQ
	 * Objekt mit zwei PQ Werten (entspricht zwei Grenzen von physikalischen
	 * Messgrößen).</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param low  The lower bound
	 *
	 * @param high The upper bound
	 */
	public Value(BigDecimal low, String lowUnit, BigDecimal high, String highUnit) {
		final var ivlPq = new IVLPQ();
		final var mlow = new IVXBPQ();
		final var mhigh = new IVXBPQ();

		if (low != null && high != null) {
			mlow.setValue(low.toString());
			mlow.setUnit(lowUnit);
			ivlPq.getRest().add(new JAXBElement<>(new QName(NAMESPACE_HL7_V3, "low", ""), IVXBPQ.class, mlow));

			mhigh.setValue(high.toString());
			mhigh.setUnit(highUnit);
			ivlPq.getRest().add(new JAXBElement<>(new QName(NAMESPACE_HL7_V3, "high", ""), IVXBPQ.class, mhigh));
		}

		mValue = ivlPq;
	}

	public Value(BigDecimal low, Ucum lowUnit, BigDecimal high, Ucum highUnit) {
		this(low, lowUnit.getCodeValue(), high, highUnit.getCodeValue());
	}

	/**
	 * <div class="en">Instantiates a new value with the parameters for a MDHT
	 * IVL_INT Objekt with two INT Values (A low and high bound of the
	 * interval).</div> <div class="de">Instantiiert eine neues Value MDHT IVL_INT
	 * Objekt mit zwei INT Werten (entspricht dem unteren und dem oberen Ende des
	 * Intervalls).</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param low  The lower bound
	 *
	 * @param high The upper bound
	 */
	public Value(BigInteger low, BigInteger high) {
		final var ivlInt = new IVLINT();
		final var mlow = new IVXBINT();
		final var mhigh = new IVXBINT();

		if (low != null && high != null) {
			mlow.setValue(low);
			ivlInt.getRest().add(new JAXBElement<>(new QName(NAMESPACE_HL7_V3, "low", ""), IVXBINT.class, mlow));

			mhigh.setValue(high);
			ivlInt.getRest().add(new JAXBElement<>(new QName(NAMESPACE_HL7_V3, "high", ""), IVXBINT.class, mhigh));
		}

		mValue = ivlInt;
	}

	/**
	 * <div class="en">Instantiates a new value with a given boolean Object.</div>
	 * <div class="de">Instantiiert eine neues Value Objekt. Value repräsentiert den
	 * Wert z.B. zu einer Beobachtung oder Diagnose. Mit diesem Konstruktor wird ein
	 * Value Objekt auf Basis eines Java boolean initialisiert (CDA Datentyp:
	 * BL)</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param bl <div class="en">the boolean value</div> <div class="de">der boolean
	 *           Wert</div> <div class="fr"></div> <div class="it"></div>
	 */
	public Value(BL bl) {
		mValue = bl;
	}

	/**
	 * <div class="en">Instantiates a new value with a given boolean Object.</div>
	 * <div class="de">Instantiiert eine neues Value Objekt. Value repräsentiert den
	 * Wert z.B. zu einer Beobachtung oder Diagnose. Mit diesem Konstruktor wird ein
	 * Value Objekt auf Basis eines Java boolean initialisiert (CDA Datentyp:
	 * BL)</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param code <br>
	 *             <div class="de"> code</div> <div class="fr"></div>
	 *             <div class="it"></div>
	 */
	public Value(boolean code) {
		final var bl = new BL();
		bl.setValue(code);
		mValue = bl;
	}

	/**
	 * <div class="en">Instantiates a new value with a give MDHT CD Objekt.</div>
	 * <div class="de">Instantiiert eine neues Value Objekt. Value repräsentiert den
	 * Wert z.B. zu einer Beobachtung oder Diagnose. Mit diesem Konstruktor wird ein
	 * Value Objekt auf Basis eines MDHT CD (Code) Datenobjekts initialisiert.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param cd <br>
	 *           <div class="de"> cd</div> <div class="fr"></div>
	 *           <div class="it"></div>
	 */
	public Value(CD cd) {
		mValue = cd;
	}

	/**
	 * <div class="en">Instantiates a new value with a given Code Object.</div>
	 * <div class="de">Instantiiert eine neues Value Objekt. Value repräsentiert den
	 * Wert z.B. zu einer Beobachtung oder Diagnose. Mit diesem Konstruktor wird ein
	 * Value Objekt auf Basis eines Convenience API Code Datenobjekts
	 * initialisiert.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param code <br>
	 *             <div class="de"> code</div> <div class="fr"></div>
	 *             <div class="it"></div>
	 */
	public Value(Code code) {
		mValue = code.getHl7CdaR2Cd();
	}

	/**
	 * Erstellt einen neuen Wert double.
	 *
	 * @param value Der eigentliche Wert
	 */
	public Value(Double value) {
		this(new PQ());
		final var pq = (PQ) mValue;
		pq.setValue(value.toString());
	}

	/**
	 * <div class="en">Instantiates a new value with the parameters for a IVL_PQ
	 * Objekt with two PQ Values (A low and high bound of physical
	 * quantities).</div> <div class="de">Instantiiert eine neues Value IVL_PQ
	 * Objekt mit zwei PQ Werten (entspricht zwei Grenzen von physikalischen
	 * Messgrößen).</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param low  The lower bound
	 *
	 * @param high The upper bound
	 */
	public Value(Double low, Double high) {
		final var ivlPq = new IVLPQ();
		final var mlow = new IVXBPQ();
		final var mhigh = new IVXBPQ();

		if (low != null && high != null) {
			mlow.setValue(low.toString());
			mlow.setUnit("");
			ivlPq.getRest().add(new JAXBElement<>(new QName(NAMESPACE_HL7_V3, "low", ""), IVXBPQ.class, mlow));

			mhigh.setValue(high.toString());
			mhigh.setUnit("");
			ivlPq.getRest().add(new JAXBElement<>(new QName(NAMESPACE_HL7_V3, "high", ""), IVXBPQ.class, mhigh));
		}

		mValue = ivlPq;
	}

	/**
	 * <div class="en">Instantiates a new value with the parameters for a MDHT
	 * IVL_PQ Objekt with two PQ Values (A low and high bound of physical
	 * quantities).</div> <div class="de">Instantiiert eine neues Value MDHT IVL_PQ
	 * Objekt mit zwei PQ Werten (entspricht zwei Grenzen von physikalischen
	 * Messgrößen).</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param low  The lower bound
	 * @param high The upper bound
	 * @param unit the unit
	 */
	public Value(Double low, Double high, String unit) {
		final var ivlPq = new IVLPQ();
		final var mlow = new IVXBPQ();
		final var mhigh = new IVXBPQ();

		if (low != null && high != null) {
			mlow.setValue(low.toString());
			mlow.setUnit(unit);
			ivlPq.getRest().add(new JAXBElement<>(new QName(NAMESPACE_HL7_V3, "low", ""), IVXBPQ.class, mlow));

			mhigh.setValue(high.toString());
			mhigh.setUnit(unit);
			ivlPq.getRest().add(new JAXBElement<>(new QName(NAMESPACE_HL7_V3, "high", ""), IVXBPQ.class, mhigh));
		}

		mValue = ivlPq;
	}

	/**
	 * <div class="en">Instantiates a new value with the parameters for a MDHT RTO
	 * Objekt (A quantity constructed as the quotient of a numerator quantity
	 * divided by a denominator quantity.).</div> <div class="de">Instantiiert eine
	 * neues Value RTO Objekt. Dieses wird häufig für die Angabe von Titer
	 * verwendet. Mit diesem Konstruktor wird ein Value Objekt auf Basis eines MDHT
	 * RTO Datenobjekts initialisiert.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param numerator   The nominator value (nominator/denominator)
	 *
	 * @param denominator The denominator value (nominator/denominator)
	 * @param ucumUnit    the UCUM Unit
	 */
	public Value(Double numerator, Double denominator, Ucum ucumUnit) {
		final var rto = new RTO();

		final var pq1 = new PQ();
		pq1.setUnit(ucumUnit.getCodeValue());
		pq1.setValue(numerator.toString());
		final var pq2 = new PQ();
		pq2.setUnit(ucumUnit.getCodeValue());
		pq2.setValue(denominator.toString());

		rto.setNumerator(pq1);
		rto.setDenominator(pq2);
		mValue = rto;
	}

	public Value(ED ed) {
		mValue = ed;
	}

	/**
	 * Erstellt einen neuen Wert (INT).
	 *
	 * @param value Der eigentliche Wert
	 */
	public Value(int value) {
		this(new INT());
		setIntValue(value);
	}

	/**
	 * Creates a new INT value.
	 *
	 * @param value The value.
	 */
	public Value(Integer value) {
		this(new INT());
		setIntValue(value);
	}

	/**
	 * <div class="en">Instantiates a new value.</div> <div class="de">Instantiiert
	 * eine neues Value Objekt. Value repräsentiert den Wert z.B. zu einer
	 * Beobachtung oder Diagnose. Mit diesem Konstruktor wird ein Value Objekt auf
	 * Basis eines MDHT PQ (Physical Quantity) Datenobjekts initialisiert.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param pq <br>
	 *           <div class="de"> pq</div> <div class="fr"></div>
	 *           <div class="it"></div>
	 */
	public Value(PQ pq) {
		mValue = pq;
	}

	/**
	 * <div class="en">Instantiates a new value with a give MDHT RTO Objekt (A
	 * quantity constructed as the quotient of a numerator quantity divided by a
	 * denominator quantity.).</div> <div class="de">Instantiiert eine neues Value
	 * RTO Objekt. Dieses wird häufig für die Angabe von Titer verwendet. Mit diesem
	 * Konstruktor wird ein Value Objekt auf Basis eines MDHT RTO Datenobjekts
	 * initialisiert.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param rto The RTO object
	 */
	public Value(RTO rto) {
		mValue = rto;
	}

	/**
	 * Erstellt einen neuen Wert (ST).
	 *
	 * @param value Der eigentliche Wert
	 */
	public Value(ST value) {
		mValue = value;
	}

	public Value(String text) {
		mValue = new ED(text);
	}

	/**
	 * <div class="en">Instantiates a new value.</div> <div class="de">Instantiiert
	 * eine neues Value Objekt. Value repräsentiert den Wert z.B. zu einer
	 * Beobachtung oder Diagnose. Mit diesem Konstruktor wird ein Value Objekt auf
	 * Basis eines MDHT ED Objektes mit einem text oder einer Referenz initalisiert.
	 * initialisiert.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param value  <br>
	 *               <div class="de"> code system</div> <div class="fr"></div>
	 *               <div class="it"></div>
	 * @param isText indicates, if the given value is a text (/value will be
	 *               created) or a reference (/value/reference[@value] will be
	 *               created)
	 */
	public Value(String value, boolean isText) {
		final ED ed;
		if (!isText) {
			ed = Reference.createReference(value);
		} else {
			ed = new ED(value);
		}
		mValue = ed;
	}

	/**
	 * <div class="en">Instantiates a new value.</div> <div class="de">Instantiiert
	 * eine neues Value Objekt. Value repräsentiert den Wert z.B. zu einer
	 * Beobachtung oder Diagnose. Mit diesem Konstruktor wird ein Value Objekt auf
	 * Basis von einem CodeSytem und einem Code initialisiert.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param codeSystem <br>
	 *                   <div class="de"> code system</div> <div class="fr"></div>
	 *                   <div class="it"></div>
	 * @param code       <br>
	 *                   <div class="de"> code</div> <div class="fr"></div>
	 *                   <div class="it"></div>
	 */
	public Value(String codeSystem, String code) {
		final var cd = new CD();
		cd.setCodeSystem(codeSystem);
		cd.setCode(code);
		mValue = cd;
	}

	/**
	 * Erstellt einen neuen Wert.
	 *
	 * @param value Der eigentliche Wert
	 * @param unit  Die Einheit
	 */
	public Value(String value, Ucum unit) {
		this(new PQ());
		setPqValue(value);
		setUcumUnit(unit);
	}

	/**
	 * Returns the text of the underlying MDHT type BL
	 *
	 * @return the text of the underlying type BL
	 */
	public String getBlText() {
		if (isBl()) {
			final var bl = (BL) mValue;
			if (bl.isValue() != null)
				return bl.isValue().toString();
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
			final var bl = (BL) mValue;
			return bl.isValue();
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
		return new Code((CD) mValue);
	}

	/**
	 * Returns the reference value of the underlying MDHT type ED (text)
	 *
	 * @return the text of the underlying type ED
	 */
	public String getEdReferenceValue() {
		if (isEd()) {
			final var ed = (ED) mValue;
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
			final var ed = (ED) mValue;
			return ed.getTextContent();
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
		final var code = new Code((CD) mValue);
		return code.getOriginalText();
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
	 * measurements</div> Gibt den oberen Wert eines Intervals physikalischer Größen
	 * zurück.
	 *
	 * @return the measurement
	 */
	public BigDecimal getPhysicalQuantityIntervalHighValue() {
		if (isPhysicalQuantityInterval()) {
			final var ivlPq = (IVLPQ) mValue;

			Map<String, PQ> elements = getPqElement(ivlPq);
			return new BigDecimal(elements.get("high").getValue());
		}
		return null;
	}

	/**
	 * extracts all {@link PQ} elements of passed {@link IVLPQ}. Extracted elements
	 * are stored in a map, where key is element name like "high" and value is
	 * extracted {@link PQ}.
	 *
	 * @param range to be extracted
	 *
	 * @return map of element name and value
	 */
	public Map<String, PQ> getPqElement(IVLPQ range) {
		Map<String, PQ> pqElements = new HashMap<>();
		if (range != null) {
			for (JAXBElement<? extends QTY> pq : range.getRest()) {
				var value = new PQ();
				var elementName = "";
				if (pq != null && PQ.class.equals(pq.getDeclaredType()) && pq.getValue() != null) {
					value = (PQ) pq.getValue();
				}

				if (pq != null && IVXBPQ.class.equals(pq.getDeclaredType()) && pq.getValue() != null) {
					value = (IVXBPQ) pq.getValue();
				}

				if (pq != null && pq.getName() != null) {
					elementName = pq.getName().getLocalPart();
				}

				if (value != null && elementName != null) {
					pqElements.put(elementName, value);
				}
			}
		}

		return pqElements;
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
			final var ivlPq = (IVLPQ) mValue;

			Map<String, PQ> elements = getPqElement(ivlPq);
			return new BigDecimal(elements.get("low").getValue());
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
			final var pq = (PQ) mValue;
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
			final var pq = (PQ) mValue;
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
			final var rto = (RTO) mValue;
			var retVal = "";
			var numeratorUnit = "";
			var denominatorUnit = "";

			if (rto != null) {
				QTY numerator = rto.getNumerator();
				QTY denominator = rto.getDenominator();
				if (numerator instanceof PQ) {
					numeratorUnit = ((PQ) numerator).getUnit();
				}

				if (denominator instanceof PQ) {
					denominatorUnit = ((PQ) denominator).getUnit();
				}
			}
			if (!numeratorUnit.isEmpty())
				numeratorUnit = " " + numeratorUnit;
			if (!denominatorUnit.isEmpty())
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
			final var rto = (RTO) mValue;
			var retVal = "";
			var numeratorValue = "";
			var denominatorValue = "";

			if (rto != null) {
				QTY numerator = rto.getNumerator();
				QTY denominator = rto.getDenominator();
					if (numerator instanceof PQ) {
						numeratorValue = ((PQ) numerator).getValue();
					} else
						numeratorValue = "*** TODO: This is not yet implemented value type...";

					if (denominator instanceof PQ) {
						denominatorValue = ((PQ) denominator).getValue();
					} else
						denominatorValue = "*** TODO: This is not yet implemented value type...";

			}
			retVal = numeratorValue + " / " + denominatorValue;
			return retVal;
		}
		return null;
	}

	/**
	 * <div class="en">Gets the value.</div> <div class="de">Liefert value.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return ANY <div class="en">the value as MDHT ANY object</div>
	 */
	public ANY getValue() {
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
		return (mValue instanceof IVLPQ);
	}

	/**
	 * Checks if the Value object is a RTO (A quantity constructed as the quotient
	 * of a numerator quantity divided by a denominator quantity.).
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
		i.setValue(BigInteger.valueOf(value));
	}

	public void setOriginalTextReference(String originalText) {
		if (mValue instanceof CD) {
			final var code = new Code((CD) mValue);
			code.setOriginalText(originalText);
		}
		if (mValue instanceof ED) {
			final var tel = new TEL();
			if (!originalText.startsWith("#")) {
				originalText = "#" + originalText;
			}
			tel.setValue(originalText);
			((ED) mValue).setReference(tel);
		}
	}

	private void setPqValue(String value) {
		if (mValue instanceof PQ) {
			final var pq = (PQ) mValue;
			pq.setValue(value);
		}
	}

	public void setUcumUnit(String unit) {
		if (mValue instanceof PQ) {
			final var pq = (PQ) mValue;
			pq.setUnit(unit);
		}
	}

	private void setUcumUnit(Ucum unit) {
		final var pq = (PQ) mValue;
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
		var resultText = "";
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
