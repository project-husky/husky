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
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * Ein Code bestehend aus eigentlichem Code und dem zugehörigen Codesystem (OID)
 */
public class Code {

	public static Code getTranslationOrCode(String codeSystem, CD code) {
		Code eHcCode;
		if (code.getCode()==null) {
			return null;
		}
		if (code.getCodeSystem().equals(codeSystem)) {
			eHcCode = new Code(code);
		}
		else {
			for (CD mCd: code.getTranslations()) {
				if (mCd.getCodeSystem().equals(codeSystem)) {
					eHcCode = new Code(mCd);
					return eHcCode;
				}
			}
		}
		return null;
	}

	CD mCD;

	/**
	 * @param code
	 */
	public Code(CD code) {
		mCD = code;
	}

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
		setOid(ConvenienceUtilsEnums.knownOID(oid));
		setCode(code);
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
		setOid(oid);
		setCode(code);
	}

	public Code(String codeSystem, String code, String displayName) {
		this(codeSystem, code);
		mCD.setDisplayName(displayName);
	}

	public Code(String codeSystem, String code, String codeSystemName,
			String displayName) {
		this(codeSystem, code, displayName);
		mCD.setCodeSystemName(codeSystemName);
	}

	public Code(Code code) {
		this(code.getOid(),code.getCode(),code.getDisplayName());
	}

	public CD getCD() {
		return EcoreUtil.copy(mCD);
	}

	/**
	 * @return das code Objekt
	 */
	public String getCode() {
		String codeStr = "";
		if (mCD.getCode() == null) {
			if (mCD.getNullFlavor() != null) {
				//TODO: Später String Ersetzungen für den NullFlavor im Enum nachschlagen
				mCD.getNullFlavor().getLiteral();
			}
		}
		else {
			codeStr = mCD.getCode();
		}
		return codeStr;
	}

	public String getDisplayName() {
		return mCD.getDisplayName();
	}

	/**
	 * @return das oid Objekt
	 */
	public String getOid() {
		String codeStr = "";
		if (mCD.getCodeSystem() == null) {
			if (mCD.getNullFlavor() != null) {
				//TODO: Später String Ersetzungen für den NullFlavor im Enum nachschlagen
				mCD.getNullFlavor().getLiteral();
			}
		}
		else {
			codeStr = mCD.getCodeSystem();
		}
		return codeStr;
	}

	public void setCD(CD cd) {
		mCD = cd;
	}

	/**
	 * @param code das code Objekt welches gesetzt wird
	 */
	public void setCode(String code) {
		mCD.setCode(code);
	}

	/**
	 * @param oid das oid Objekt welches gesetzt wird
	 */
	public void setOid(String oid) {
		mCD.setCodeSystem(oid);
	}
}
