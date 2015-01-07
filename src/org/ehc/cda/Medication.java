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

package org.ehc.cda;

/**
 * Ein Medikament
 */
public class Medication {
	
	private String atcCode;
	private String name;
	private String gtin;
	
	/**
	 * Erstellt ein neues Medikament
	 * 
	 * @param atcCode
	 *          WHO ATC (z.B. J07BF03)
	 * @param name
	 *          Name des Medikaments (z.B. "POLIORIX Inj Lös Durchstf 0.5 ml")
	 * 
	 * @param gtin
	 *          Strichcode des Artikels (z.B. 7680006690011)
	 */
	public Medication(String atcCode, String name, String gtin) {
		this.atcCode = atcCode;
		this.name = name;
		this.gtin = gtin;
	}

	/**
	 * Gibt den Namen des Medikaments zurück
	 * 
	 * @return Namen
	 */
	public String getName() {
		return this.name;
	}
}
