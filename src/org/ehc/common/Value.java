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

package org.ehc.common;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.common.ConvenienceUtilsEnums.UCUM;
import org.openhealthtools.mdht.uml.hl7.datatypes.ANY;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;

/**
 * Ein Wert bestehend aus eigentlichem Wert und der zugehörigen Einheit
 */
public class Value {
  ANY mValue;

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
    this.setPqValue(value);
    this.setUcumUnit(unit);
  }

  private void setUcumUnit(UCUM unit) {
    PQ pq = (PQ) this.mValue;
    pq.setUnit(unit.toString());
  }

  private void setPqValue(String value) {
    PQ pq = (PQ) this.mValue;
    pq.setValue(Double.valueOf(value));
  }

  public Value(PQ pq) {
    this.mValue = pq;
  }
  
  public Value(CD cd) {
    this.mValue = cd;
  }
  
  public Value(Code code) {
    this.mValue = code.getCD();
  }

  /**
   * Gibt den Wert zurück
   * 
   * @return 
   *  Der eigentlich Wert
   */
  public String getPhysicalQuantityValue() {
    PQ pq = (PQ) this.mValue;
    return String.valueOf(pq.getValue());
  }

  /**
   * Gibt die Einheit zurück
   * 
   * @return Die Einheit
   */
  public String getPhysicalQuantityUnit() {
    PQ pq = (PQ) this.mValue;
    return pq.getUnit();
  }
  
  public PQ copyMdhtPhysicalQuantity() {
    return EcoreUtil.copy((PQ) mValue);
  }
  
  public CD copyMdhtCode() {
   return EcoreUtil.copy((CD) this.mValue);
  }
   
  public Code getCode() {
    Code code = new Code ((CD) this.mValue);
    return code;
  }

  @Override
  public String toString() {
    return "Value [value=" + getPhysicalQuantityValue() + ", unit=" + getPhysicalQuantityUnit() + "]";
  }

  public boolean isPhysicalQuantity () {
    if (this.mValue instanceof PQ) {
      return true;
    }
    else {
      return false;
    }
  }

  public boolean isCode() {
    if (this.mValue instanceof CD) {
      return true;
    }
    else {
      return false;
    }
  }

}
