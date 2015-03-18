/*******************************************************************************
*
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
* All rights reserved. http://medshare.net
*
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
 * This code is are made available under the terms of the Eclipse Public License v1.0.
*
 * Accompanying materials are made available under the terms of the Creative Commons
* Attribution-ShareAlike 4.0 Switzerland License.
*
 * Year of publication: 2015
*
 *******************************************************************************/

package org.ehealth_connector.common;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.CodeSystems;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * Ein Code bestehend aus eigentlichem Code und dem zugehörigen Codesystem (OID).
 */
public class Code {

  /**
   * <div class="en">Gets the translation or code.</div>
   * <div class="de">Sucht in einem CD-Objekt nach einem CodeSystem und liefert den dazugehörigen Code zurück.</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param codeSystem <br>
   * 		<div class="de"> code system</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   * @param code <br>
   * 		<div class="de"> code</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   * @return <div class="en">the translation or code</div>
   */
  public static Code getTranslationOrCode(String codeSystem, CD code) {
    Code eHcCode;
    if (code.getCode()==null) {
      return null;
    }
    if (code.getCodeSystem().equals(codeSystem)) {
      eHcCode = new Code(code);
      return eHcCode;
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
   * <div class="en">Instantiates a new code.</div>
   * <div class="de">Instantiiert ein neues Code Objekt</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param code <br>
   * 		<div class="de"> code</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   */
  public Code(CD code) {
    mCD = code;
  }

  /**
   * <div class="en">Instantiates a new code.</div>
   * <div class="de">Instantiiert ein neues Code Objekt</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param code <br>
   * 		<div class="de"> code</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   */
  public Code(Code code) {
    this(code.getCodeSystem(),code.getCode(),code.getDisplayName());
  }

  /**
   * Erstellt einen neuen Wert.
   *
   * @param codeSystem          Die OID des zugehörigen Codesystems
   * @param code          Der eigentliche Code
   */
  public Code(CodeSystems codeSystem, String code)  {
    mCD = DatatypesFactory.eINSTANCE.createCD();
    setCodeSystem(codeSystem.getCodeSystemId());
    setCode(code);
  }

  /**
   * Erstellt einen neuen Wert.
   *
   * @param oid          Die OID des zugehörigen Codesystems
   * @param code          Der eigentliche Code
   */
  public Code(String oid, String code)  {
    mCD = DatatypesFactory.eINSTANCE.createCD();
    setCodeSystem(oid);
    setCode(code);
  }

  /**
   * <div class="en">Instantiates a new code.</div>
   * <div class="de">Instantiiert ein neues Code Objekt</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param codeSystem <br>
   * 		<div class="de"> code system</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   * @param code <br>
   * 		<div class="de"> code</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   * @param displayName <br>
   * 		<div class="de"> display name</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   */
  public Code(String codeSystem, String code, String displayName) {
    this(codeSystem, code);
    mCD.setDisplayName(displayName);
  }

  /**
   * <div class="en">Instantiates a new code.</div>
   * <div class="de">Instantiiert ein neues Code Objekt</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param codeSystem <br>
   * 		<div class="de"> code system</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   * @param code <br>
   * 		<div class="de"> code</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   * @param codeSystemName <br>
   * 		<div class="de"> code system name</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   * @param displayName <br>
   * 		<div class="de"> display name</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   */
  public Code(String codeSystem, String code, String codeSystemName,
      String displayName) {
    this(codeSystem, code, displayName);
    mCD.setCodeSystemName(codeSystemName);
  }

  /**
   * <div class="en">Gets the CD MDHT Object</div>
   * <div class="de">Liefert das CD MDHT Objekt</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return <div class="en">the cd</div>
   */
  public CD getCD() {
    return EcoreUtil.copy(mCD);
  }
  
  public CE getCE() {
	  CE ce = DatatypesFactory.eINSTANCE.createCE();
	  if (mCD.getCodeSystem()!=null) {
		  ce.setCodeSystem(mCD.getCodeSystem());
	  }
	  if (mCD.getCode()!=null) {
		  ce.setCode(mCD.getCode());
	  }
	  if (mCD.getCodeSystemName()!=null) {
		  ce.setCodeSystemName(mCD.getCodeSystemName());
	  }
	  if (mCD.getDisplayName()!=null) {
		  ce.setDisplayName(mCD.getDisplayName());
	  }
	  if (mCD.getCodeSystemVersion()!=null) {
		  ce.setCodeSystemVersion(mCD.getCodeSystemVersion());
	  }
	  if (mCD.getNullFlavor()!=null) {
		  ce.setNullFlavor(mCD.getNullFlavor());
	  }
	  return ce;
  }

  /**
   * <div class="en">Gets the code.</div>
   * <div class="de">Liefert code.</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
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

  /**
   * <div class="en">Gets the code system.</div>
   * <div class="de">Liefert code system.</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return das oid Objekt
   */
  public String getCodeSystem() {
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

  /**
   * <div class="en">Gets the display name.</div>
   * <div class="de">Liefert display name.</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return String <div class="en">the display name</div>
   */
  public String getDisplayName() {
    return mCD.getDisplayName();
  }

  /**
   * <div class="en">Sets the MDHT CD Object</div>
   * <div class="de">Setzt das MDHT CD Objekt</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *  
   *
   * @param cd <div class="en">the new cd</div>
   * <div class="de">das neue cd.</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   */
  public void setCD(CD cd) {
    mCD = cd;
  }

  /**
   * <div class="en">Sets the code.</div>
   * <div class="de">Setzt code.</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *  
   *
   * @param code das code Objekt welches gesetzt wird
   */
  public void setCode(String code) {
    mCD.setCode(code);
  }

  /**
   * <div class="en">Sets the code system.</div>
   * <div class="de">Setzt code system.</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *  
   *
   * @param oid das oid Objekt welches gesetzt wird
   */
  public void setCodeSystem(String oid) {
    mCD.setCodeSystem(oid);
  }
}
