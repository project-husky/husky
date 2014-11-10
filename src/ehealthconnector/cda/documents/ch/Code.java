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
		this.cSetOid(ConvenienceUtilsEnums.knownOID(oid));
		this.cSetCode(code);
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
		this.cSetOid(oid);
		this.cSetCode(code);
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
	public String cGetCode() {
		return this.mCD.getCode();
	}

	/**
	 * @param code das code Objekt welches gesetzt wird
	 */
	public void cSetCode(String code) {
		this.mCD.setCode(code);
	}

	/**
	 * @return das oid Objekt
	 */
	public String cGetOid() {
		return this.mCD.getCodeSystem();
	}

	/**
	 * @param oid das oid Objekt welches gesetzt wird
	 */
	public void cSetOid(String oid) {
		 this.mCD.setCodeSystem(oid);
	}

}
