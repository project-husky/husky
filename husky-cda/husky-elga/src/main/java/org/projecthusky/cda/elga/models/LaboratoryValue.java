/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models;

import java.math.BigInteger;
import java.util.Date;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.enums.NullFlavor;
import org.projecthusky.common.hl7cdar2.ANY;
import org.projecthusky.common.hl7cdar2.BL;
import org.projecthusky.common.hl7cdar2.CV;
import org.projecthusky.common.hl7cdar2.ED;
import org.projecthusky.common.hl7cdar2.INT;
import org.projecthusky.common.hl7cdar2.IVLINT;
import org.projecthusky.common.hl7cdar2.IVLPQ;
import org.projecthusky.common.hl7cdar2.PQ;
import org.projecthusky.common.hl7cdar2.RTO;
import org.projecthusky.common.hl7cdar2.RTOPQPQ;
import org.projecthusky.common.hl7cdar2.ST;
import org.projecthusky.common.hl7cdar2.TEL;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.utils.DateUtil;

public class LaboratoryValue {

	private Double lowValue;
	private Double highValue;
	private Double doubleValue;
	private BigInteger intValue;
	private Boolean boolValue;
	private String stringValue;
	private Date dateValue;
	private Code codeValue;
	private String unit;
	private boolean inclusive;
	private Integer numerator;
	private Integer denominator;

	public Double getLowValue() {
		return lowValue;
	}

	public void setLowValue(Double lowValue) {
		this.lowValue = lowValue;
	}

	public Double getHighValue() {
		return highValue;
	}

	public void setHighValue(Double highValue) {
		this.highValue = highValue;
	}

	public Double getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(Double doubleValue) {
		this.doubleValue = doubleValue;
	}

	public BigInteger getIntValue() {
		return intValue;
	}

	public void setIntValue(BigInteger intValue) {
		this.intValue = intValue;
	}

	public Boolean getBoolValue() {
		return boolValue;
	}

	public void setBoolValue(Boolean boolValue) {
		this.boolValue = boolValue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public Date getDateValue() {
		return dateValue;
	}

	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

	public Code getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(Code codeValue) {
		this.codeValue = codeValue;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public boolean isInclusive() {
		return inclusive;
	}

	public void setInclusive(boolean inclusive) {
		this.inclusive = inclusive;
	}

	public Integer getNumerator() {
		return numerator;
	}

	public void setNumerator(Integer numerator) {
		this.numerator = numerator;
	}

	public Integer getDenominator() {
		return denominator;
	}

	public void setDenominator(Integer denominator) {
		this.denominator = denominator;
	}

	public PQ getPQ() {
		PQ pq = new PQ();
		pq.setUnit(unit);
		pq.setValue(String.valueOf(doubleValue));
		return pq;
	}

	public IVLPQ getIVLPQ() {
		IVLPQ ivlpq = new IVLPQ();

		if (lowValue != null) {
			ivlpq.getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX), IVLPQ.class,
							new IVLPQ(String.valueOf(lowValue), unit)));
		}


		ivlpq.getRest()
				.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX),
						IVLPQ.class, new IVLPQ(String.valueOf(highValue), unit)));

		return ivlpq;
	}

	public INT getINT() {
		INT intVal = new INT();

		if (this.intValue != null) {
			intVal.setValue(this.intValue);
		}

		return intVal;
	}

	public IVLINT getIVLINT() {
		IVLINT intVal = new IVLINT();

		if (lowValue != null) {
			intVal.getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX), INT.class,
							new INT(lowValue.intValue())));
		}

		if (highValue != null) {
			intVal.getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX), INT.class,
							new INT(highValue.intValue())));
		}

		return intVal;
	}

	public BL getBL() {
		BL blValue = new BL();
		blValue.setValue(boolValue);
		return blValue;
	}

	public CV getCV() {
		CV cvValue = new CV();

		if (codeValue != null) {
			cvValue.setCode(codeValue.getCode());
			cvValue.setCodeSystem(codeValue.getCodeSystem());
			cvValue.setCodeSystemName(codeValue.getCodeSystemName());
			cvValue.setCodeSystemVersion(codeValue.getCodeSystemVersion());
			cvValue.setDisplayName(codeValue.getDisplayName());
			cvValue.setOriginalText(new ED(null, new TEL(codeValue.getOriginalText())));
		}

		return cvValue;
	}

	public TS getTS() {
		if (dateValue == null) {
			return new TS(NullFlavor.UNKNOWN_L1_CODE);
		} else {
			return new TS(DateUtil.formatDateTimeTzon(dateValue));
		}
	}

	public RTO getRTO() {
		RTO rto = new RTO();

		if (numerator != null) {
			INT intVal = new INT();
			intVal.setValue(BigInteger.valueOf(numerator.intValue()));
			rto.setNumerator(intVal);
		}

		if (denominator != null) {
			INT intVal = new INT();
			intVal.setValue(BigInteger.valueOf(denominator.intValue()));
			rto.setDenominator(intVal);
		}

		return rto;
	}

	public RTOPQPQ getRTOPQPQ() {
		RTOPQPQ rtopqpq = new RTOPQPQ();

		PQ pqVal = new PQ();
		pqVal.setValue(String.valueOf(numerator));
		pqVal.setUnit(unit);
		rtopqpq.setNumerator(pqVal);

		PQ pqValDen = new PQ();
		pqValDen.setValue(String.valueOf(denominator));
		pqValDen.setUnit(unit);
		rtopqpq.setDenominator(pqValDen);

		return rtopqpq;
	}

	public ST getST() {
		ST st = new ST();
		st.setXmlMixed(stringValue);
		return st;
	}

	public ANY getValue() {
		if (numerator != null && denominator != null && unit != null) {
			return getRTOPQPQ();
		}

		if (numerator != null && denominator != null) {
			return getRTO();
		}

		if (intValue != null) {
			return getINT();
		}

		if (codeValue != null) {
			return getCV();
		}

		if (dateValue != null) {
			return getTS();
		}

		if (doubleValue != null && unit != null) {
			return getPQ();
		}

		if (lowValue != null && unit != null && !unit.isEmpty()) {
			return getIVLPQ();
		}

		if (lowValue != null && highValue != null) {
			return getIVLINT();
		}

		if (boolValue != null) {
			return getBL();
		}

		if (stringValue != null) {
			return getST();
		}

		return null;
	}

	public String getValueAsString() {

		if (stringValue != null && !stringValue.isEmpty()) {
			return stringValue;
		}

		if (intValue != null) {
			return intValue.toString();
		}

		if (highValue != null && lowValue != null) {
			return String.format("%s - %s", lowValue.toString(), highValue.toString());
		}

		if (doubleValue != null) {
			return doubleValue.toString();
		}

		if (denominator != null && numerator != null) {
			return String.format("%s:%s", numerator.toString(), denominator.toString());
		}

		if (dateValue != null) {
			return DateUtil.formatDateTimeTzon(dateValue);
		}

		if (codeValue != null && codeValue.getDisplayName() != null) {
			return codeValue.getDisplayName();
		}

		if (boolValue != null) {
			return boolValue.toString();
		}

		return "";
	}


}
