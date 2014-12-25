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

import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * Ein Code bestehend aus eigentlichem Code und dem zugehörigen Codesystem (OID)
 */
public class Code {

	CD mCD;
	
	/**
	 * Erstellt einen neuen Wert
	 * 
	 * @param code
	 *          Der eigentliche Code
	 * @param oid
	 *          Die OID des zugehörigen Codesystems
	 */
	public Code(ConvenienceUtilsEnums.KnownOID oid, String code)  {
		mCD = DatatypesFactory.eINSTANCE.createCD();
		this.setOid(ConvenienceUtilsEnums.knownOID(oid));
		this.setCode(code);
	}

	/**
	 * Erstellt einen neuen Wert
	 * 
	 * @param code
	 *          Der eigentliche Code
	 * @param oid
	 *          Die OID des zugehörigen Codesystems
	 */
	public Code(String oid, String code)  {
		mCD = DatatypesFactory.eINSTANCE.createCD();
		this.setOid(oid);
		this.setCode(code);
	}

	/**
	 * @param code
	 */
	public Code(CD code) {
		this.mCD = code;
	}

	/**
	 * @return das code Objekt
	 */
	public String getCode() {
		return this.mCD.getCode();
	}

	/**
	 * @param code das code Objekt welches gesetzt wird
	 */
	public void setCode(String code) {
		this.mCD.setCode(code);
	}

	/**
	 * @return das oid Objekt
	 */
	public String getOid() {
		return this.mCD.getCodeSystem();
	}

	/**
	 * @param oid das oid Objekt welches gesetzt wird
	 */
	public void setOid(String oid) {
		 this.mCD.setCodeSystem(oid);
	}

}
