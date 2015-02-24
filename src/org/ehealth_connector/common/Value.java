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

package org.ehealth_connector.common;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.ConvenienceUtilsEnums.UCUM;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * Ein Wert bestehend aus eigentlichem Wert und der zugehörigen Einheit
 */
public class Value {
	ANY mValue;

	public Value(ANY value) {
		mValue = value;
	}

	public Value(CD cd) {
		mValue = cd;
	}

	public Value(Code code) {
		mValue = code.getCD();
	}

	public Value(PQ pq) {
		mValue = pq;
	}

	public Value(String codeSystemId, String string) {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(codeSystemId);
		cd.setCode(string);
		mValue = cd;
	}

	/**
	 * Erstellt einen neuen Wert
	 * 
	 * @param value
	 *          Der eigentliche Wert
	 * @param unit
	 *          Die Einheit
	 */
	public Value(String value, UCUM unit) {
		this(DatatypesFactory.eINSTANCE.createPQ());
		setPqValue(value);
		setUcumUnit(unit);
	}

	public CD copyMdhtCode() {
		return EcoreUtil.copy((CD) mValue);
	}

	public PQ copyMdhtPhysicalQuantity() {
		return EcoreUtil.copy((PQ) mValue);
	}

	public Code getCode() {
		Code code = new Code ((CD) mValue);
		return code;
	}

	/**
	 * Gibt die Einheit zurück
	 * 
	 * @return Die Einheit
	 */
	public String getPhysicalQuantityUnit() {
		PQ pq = (PQ) mValue;
		return pq.getUnit();
	}

	/**
	 * Gibt den Wert zurück
	 * 
	 * @return 
	 *  Der eigentlich Wert
	 */
	public String getPhysicalQuantityValue() {
		PQ pq = (PQ) mValue;
		return String.valueOf(pq.getValue());
	}

	public ANY getValue() {
		if (mValue == null) {
			mValue.setNullFlavor(NullFlavor.UNK);
		}
		return mValue;
	}

	public boolean isCode() {
		if (mValue instanceof CD) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isPhysicalQuantity () {
		if (mValue instanceof PQ) {
			return true;
		}
		else {
			return false;
		}
	}

	private void setPqValue(String value) {
		PQ pq = (PQ) mValue;
		pq.setValue(Double.valueOf(value));
	}

	private void setUcumUnit(UCUM unit) {
		PQ pq = (PQ) mValue;
		pq.setUnit(unit.toString());
	}

	@Override
	public String toString() {
		return "Value [value=" + getPhysicalQuantityValue() + ", unit=" + getPhysicalQuantityUnit() + "]";
	}

}
