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

package ehealthconnector.cda.documents.ch;

import ehealthconnector.cda.documents.ch.ConvenienceUtilsEnums.UCUM;

/**
 * Ein Wert bestehend aus eigentlichem Wert und der zugehörigen Einheit
 */
public class Value {

	String value;
	UCUM unit;
	
	/**
	 * Erstellt einen neuen Wert
	 * 
	 * @param value
	 *          Der eigentliche Wert
	 * @param unit
	 *          Die Einheit
	 */
	public Value(String value, UCUM unit) {
		this.value = value;
		this.unit = unit;
	}

	/**
	 * Gibt den Wert zurück
	 * 
	 * @return 
	 *  Der eigentlich Wert
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Gibt die Einheit zurück
	 * 
	 * @return Die Einheit
	 */
	public UCUM getUnit() {
		return this.unit;
	}

}
