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
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.enums.IdentityDomain;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * Ein Code bestehend aus eigentlichem Code und dem zugehörigen Codesystem
 * (OID).
 */
public class Code {

	private CD mCD;

	/**
	 * <div class="en">Instantiates a new code.</div> <div
	 * class="de">Instantiiert ein neues Code Objekt</div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @param code
	 * <br>
	 *            <div class="de"> code</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Code(CD code) {
		mCD = code;
	}

	/**
	 * <div class="en">Instantiates a new code.</div> <div
	 * class="de">Instantiiert ein neues Code Objekt</div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @param code
	 * <br>
	 *            <div class="de"> code</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Code(Code code) {
		this(code.getCodeSystem(), code.getCode(), code.getDisplayName());
	}

	/**
	 * Erstellt einen neuen Wert.
	 * 
	 * @param codeSystem
	 *            Die OID des zugehörigen Codesystems
	 * @param code
	 *            Der eigentliche Code
	 */
	public Code(IdentityDomain codeSystem, String code) {
		mCD = DatatypesFactory.eINSTANCE.createCD();
		mCD.setCodeSystem(codeSystem.getCodeSystemId());
		mCD.setCodeSystemName(codeSystem.getCodeSystemName());
		mCD.setCode(code);
	}

	public Code(org.ehealth_connector.cda.enums.NullFlavor nullFlavor) {
		mCD = DatatypesFactory.eINSTANCE.createCD();
		mCD.setNullFlavor(NullFlavor.getByName(nullFlavor.name()));
	}

	/**
	 * Erstellt einen neuen Wert.
	 * 
	 * @param oid
	 *            Die OID des zugehörigen Codesystems
	 * @param code
	 *            Der eigentliche Code
	 */
	public Code(String oid, String code) {
		mCD = DatatypesFactory.eINSTANCE.createCD();
		mCD.setCodeSystem(oid);
		mCD.setCode(code);
	}

	/**
	 * <div class="en">Instantiates a new code.</div> <div
	 * class="de">Instantiiert ein neues Code Objekt</div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @param codeSystem
	 * <br>
	 *            <div class="de"> code system</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param code
	 * <br>
	 *            <div class="de"> code</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param displayName
	 * <br>
	 *            <div class="de"> display name</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Code(String codeSystem, String code, String displayName) {
		this(codeSystem, code);
		mCD.setDisplayName(displayName);
	}

	/**
	 * <div class="en">Instantiates a new code.</div> <div
	 * class="de">Instantiiert ein neues Code Objekt</div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @param codeSystem
	 * <br>
	 *            <div class="de"> code system</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param code
	 * <br>
	 *            <div class="de"> code</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param codeSystemName
	 * <br>
	 *            <div class="de"> code system name</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param displayName
	 * <br>
	 *            <div class="de"> display name</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Code(String codeSystem, String code, String codeSystemName, String displayName) {
		this(codeSystem, code, displayName);
		mCD.setCodeSystemName(codeSystemName);
	}

	/**
	 * Adds a translation to the code object
	 * 
	 * @param code
	 *            the code
	 */
	public void addTranslation(Code code) {
		if (code != null) {
			mCD.getTranslations().add(code.getCD());
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Code)) {
			return false; // different class
		}
		Code other = (Code) obj;
		if (this.mCD == other.mCD)
			return true;
		if (!this.mCD.getCode().equals(other.mCD.getCode())
				&& this.mCD.getCodeSystem().equals(other.mCD.getCodeSystem())
				&& this.mCD.getCodeSystemVersion().equals(other.mCD.getCodeSystemVersion())
				&& this.mCD.getNullFlavor().getName().equals(other.mCD.getNullFlavor().getName())
				&& this.mCD.getNullFlavor().getValue() == other.mCD.getNullFlavor().getValue()
				&& this.mCD.getTranslations().equals(other.mCD.getTranslations()))
			return false;

		return true;
	}

	/**
	 * <div class="en">Gets the CD MDHT Object</div> <div class="de">Liefert das
	 * CD MDHT Objekt</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return <div class="en">the cd</div>
	 */
	public CD getCD() {
		return EcoreUtil.copy(mCD);
	}

	public CE getCE() {
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		final CD mCD2 = EcoreUtil.copy(mCD);
		if (mCD2.getCodeSystem() != null) {
			ce.setCodeSystem(mCD2.getCodeSystem());
		}
		if (mCD2.getCode() != null) {
			ce.setCode(mCD2.getCode());
		}
		if (mCD2.getCodeSystemName() != null) {
			ce.setCodeSystemName(mCD2.getCodeSystemName());
		}
		if (mCD2.getDisplayName() != null) {
			ce.setDisplayName(mCD2.getDisplayName());
		}
		if (mCD2.getCodeSystemVersion() != null) {
			ce.setCodeSystemVersion(mCD2.getCodeSystemVersion());
		}
		if (mCD2.isNullFlavorDefined()) {
			ce.setNullFlavor(mCD2.getNullFlavor());
		}
		return ce;
	}

	/**
	 * <div class="en">Gets the code.</div> <div class="de">Liefert code.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return das code Objekt
	 */
	public String getCode() {
		String codeStr = "";
		if (mCD.getCode() == null) {
			if (mCD.getNullFlavor() != null) {
				mCD.getNullFlavor().getLiteral();
			}
		} else {
			codeStr = mCD.getCode();
		}
		return codeStr;
	}

	/**
	 * <div class="en">Gets the code system.</div> <div class="de">Liefert code
	 * system.</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return das oid Objekt
	 */
	public String getCodeSystem() {
		String codeStr = "";
		if (mCD.getCodeSystem() == null) {
			if (mCD.getNullFlavor() != null) {
				mCD.getNullFlavor().getLiteral();
			}
		} else {
			codeStr = mCD.getCodeSystem();
		}
		return codeStr;
	}

	/**
	 * Gets the name of the code system
	 * 
	 * @return the name of the code system. null, if it wasn´t set.
	 */
	public String getCodeSystemName() {
		if (mCD.getCodeSystemName() != null) {
			return mCD.getCodeSystemName();
		} else {
			return null;
		}
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return String <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return mCD.getDisplayName();
	}

	public NullFlavor getNullFlavor() {
		return mCD.getNullFlavor();
	}

	/**
	 * Gets a list of translations for the code object.
	 * 
	 * @return an List, which contains all translation codes
	 */
	public List<Code> getTranslations() {
		final List<Code> cl = new ArrayList<Code>();
		for (CD cd : mCD.getTranslations()) {
			cl.add(new Code(cd));
		}
		return cl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;

		if (mCD == null)
			return prime;
		int result = 1;
		result = prime * result + mCD.getCode().hashCode();
		result = prime * result + mCD.getCodeSystem().hashCode();
		result = prime * result + mCD.getCodeSystemVersion().hashCode();
		result = prime * result + mCD.getCodeSystemName().hashCode();
		result = prime * result + mCD.getNullFlavor().getName().hashCode();
		result = prime * result + mCD.getNullFlavor().getValue();
		result = prime * result + mCD.getTranslations().hashCode();
		return result;
	}

	public boolean isNullFlavor() {
		return mCD.isNullFlavorDefined();
	}

	/**
	 * <div class="en">Sets the MDHT CD Object</div> <div class="de">Setzt das
	 * MDHT CD Objekt</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * 
	 * @param cd
	 *            <div class="en">the new cd</div> <div class="de">das neue
	 *            cd.</div> <div class="fr"></div> <div class="it"></div>
	 */
	public void setCD(CD cd) {
		mCD = cd;
	}

	/**
	 * <div class="en">Sets the code.</div> <div class="de">Setzt code.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 * 
	 * 
	 * @param code
	 *            das code Objekt welches gesetzt wird
	 */
	public void setCode(String code) {
		mCD.unsetNullFlavor();
		mCD.setCode(code);
	}

	/**
	 * <div class="en">Sets the code system.</div> <div class="de">Setzt code
	 * system.</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * 
	 * @param oid
	 *            das oid Objekt welches gesetzt wird
	 */
	public void setCodeSystem(String oid) {
		mCD.unsetNullFlavor();
		mCD.setCodeSystem(oid);
	}

	/**
	 * Sets the name of the code system
	 * 
	 * @param codeSystemName
	 *            name of the code system.
	 */
	public void setCodeSystemName(String codeSystemName) {
		mCD.unsetNullFlavor();
		mCD.setCodeSystemName(codeSystemName);
	}

	public void setNullFlavor(org.ehealth_connector.cda.enums.NullFlavor nf) {
		mCD.setNullFlavor(NullFlavor.getByName(nf.name()));
	}
}
