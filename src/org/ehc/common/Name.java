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
 * Attribution-ShareAlike 3.0 Switzerland License.
 *
 * Year of publication: 2014
 *
 *******************************************************************************/

package org.ehc.common;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ON;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;

/**
 * Der HL7 Datentyp Name
 *
 */
public class Name {

	private PN mPn;

	public Name(ON on) {
		mPn = (PN) on;
	}

	/**
	 * @param pn
	 */
	public Name(PN pn) {
		mPn = pn;
	}

	/**
	 * Erzeugt einen Personennamen (Dieser Konstruktor wird oft gebraucht für Patienten)
	 * 
	 * @param givenName Vorname
	 * @param familyName Nachname
	 */
	public Name(String givenName, String familyName) {
		// Create and fill Person Name
		mPn = DatatypesFactory.eINSTANCE.createPN();
		if ((givenName != null) && !givenName.equals("")) {
			setGivenName(givenName);
		}
		if ((familyName != null) && !familyName.equals("")) {
			setFamilyName(familyName);
		}
	}

	/**
	 * Erzeugt einen Personennamen (Dieser Konstruktor wird oft gebraucht für Behandelnde)
	 * 
	 * @param givenName Vorname
	 * @param familyName Nachname
	 * @param title Titel (z.B. Dr. med.)
	 */
	public Name(String givenName, String familyName, String title) {
		this(givenName, familyName);
		mPn.addPrefix(title);
	}

	/**
	 * Erzeugt einen Personennamen
	 * 
	 * @param familyName Nachname
	 * @param givenName Vorname
	 * @param prefix Prefix (z.B. "Dipl. Inf.")
	 * @param suffix Suffix (z.b. "der Dritte")
	 */
	public Name(String givenName, String familyName, String prefix, String suffix) {
		this(givenName, familyName, prefix);
		mPn.addSuffix(suffix);
	}

	public PN copyMdhtPn() {
		return EcoreUtil.copy(mPn);
	}

	public String getCompleteName() {
		String name = null;

//		String prefixes = getPrefixes();
//		String givens = getGivenNames();
//		String families = getFamilyNames();
//		String suffixes = getSuffixes();
//		if (prefixes != null && givens != null) {
//			name = String.join(" ", prefixes, givens);
//		}
//		else {
//			name = givens;
//		}
//		name = String.join(" " , name, families);
//		if (suffixes!=null) {
//			name= String.join(" " , name, suffixes);
//		}

		return name;
	}

	/**
	 * @return Nachnamen
	 */
	public String getFamilyName() {
		return mPn.getFamilies().get(0).getText();
	}

	/**
	 * @return das suffix Objekt
	 */
	public String getFamilyNames() {
		return Util.joinEListStr (mPn.getFamilies());
	}

	/**
	 * @return Vornamen
	 */
	public String getGivenNames() {
		return Util.joinEListStr (mPn.getGivens());
	}

	public PN getMdhtPn() {
		return mPn;
	}

	/**
	 * @return das prefix Objekt
	 */
	public String getPrefixes() {
		return Util.joinEListStr (mPn.getPrefixes());
	}

	/**
	 * @return das suffix Objekt
	 */
	public String getSuffixes() {
		return Util.joinEListStr (mPn.getSuffixes());
	}

	/**
	 * @param familyName Nachnamen
	 */
	public void setFamilyName(String familyName) {
		if ((familyName != null) && !familyName.equals("")) {
			mPn.addFamily(familyName);
		}
	}

	/**
	 * @param givenName Vornamen
	 */
	public void setGivenName(String givenName) {
		if ((givenName != null) && !givenName.equals("")) {
			mPn.addGiven(givenName);
		}
	}

	public void setPn(PN pn) {
		mPn = pn;
	}

	/**
	 * @param prefix das prefix Objekt welches gesetzt wird
	 */
	public void setPrefix(String prefix) {
		if ((prefix != null) && !prefix.equals("")) {
			mPn.addPrefix(prefix);
		}
	}

	/**
	 * @param suffix das suffix Objekt welches gesetzt wird
	 */
	public void setSuffix(String suffix) {
		if ((suffix != null) && !suffix.equals("")) {
			mPn.addSuffix(suffix);
		}
	}

	/**
	 * @param title das title Objekt welches gesetzt wird
	 */
	public void setTitle(String title) {
		mPn.addPrefix(title);
	}

}
