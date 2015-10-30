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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.util.Util;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ON;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;

public class Name {

	/**
	 * Der HL7 Datentyp Name.
	 */
	private PN mPn;

	/**
	 * <div class="en">Instantiates a new name.</div> <div
	 * class="de">Instantiiert ein neues Name Objekt</div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @param organizationName
	 * <br>
	 *            <div class="de"> on</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Name(ON organizationName) {
		mPn = (PN) organizationName;
	}

	/**
	 * <div class="en">Instantiates a new name.</div> <div
	 * class="de">Instantiiert ein neues Name Objekt mit einem MDHT PN
	 * Objekt</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param personName
	 * <br>
	 *            <div class="de"> pn</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Name(PN personName) {
		mPn = personName;
	}

	/**
	 * Erzeugt einen Personennamen (Dieser Konstruktor wird oft gebraucht für
	 * Patienten).
	 * 
	 * @param givenName
	 *            Vorname
	 * @param familyName
	 *            Nachname
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
	 * Erzeugt einen Personennamen (Dieser Konstruktor wird oft gebraucht für
	 * Behandelnde).
	 * 
	 * @param givenName
	 *            Vorname
	 * @param familyName
	 *            Nachname
	 * @param title
	 *            Titel (z.B. Dr. med.)
	 */
	public Name(String givenName, String familyName, String title) {
		this(givenName, familyName);
		mPn.addPrefix(title);
	}

	/**
	 * Erzeugt einen Personennamen.
	 * 
	 * @param givenName
	 *            Vorname
	 * @param familyName
	 *            Nachname
	 * @param prefix
	 *            Prefix (z.B. "Dipl. Inf.")
	 * @param suffix
	 *            Suffix (z.b. "der Dritte")
	 */
	public Name(String givenName, String familyName, String prefix, String suffix) {
		this((givenName == null ? "" : givenName), (familyName == null ? "" : familyName),
				(prefix == null ? "" : prefix));
		if (prefix != null)
			mPn.addSuffix(suffix);
	}

	/**
	 * <div class="en">Copy mdht pn.</div> <div class="de"></div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @return PN the pn
	 */
	public PN copyMdhtPn() {
		return EcoreUtil.copy(mPn);
	}

	/**
	 * <div class="en">Gets the complete name.</div> <div class="de">Liefert den
	 * ganzen Namen (z.B. "Dr. Allzeit Bereit der Dritte")</div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @return String <div class="en">the complete name</div>
	 */
	public String getCompleteName() {
		String prefixes = getPrefixes();
		String givens = getGivenNames();
		String families = getFamilyNames();
		String suffixes = getSuffixes();

		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add(prefixes);
		nameList.add(givens);
		nameList.add(families);
		nameList.add(suffixes);

		return Util.join(nameList, " ");
	}

	/**
	 * <div class="en">Gets the (first) family name.</div> <div
	 * class="de">Liefert den (ersten) Familiennamen</div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @return Nachnamen
	 */
	public String getFamilyName() {
		return mPn.getFamilies().get(0).getText();
	}

	/**
	 * <div class="en">Gets the family names.</div> <div class="de">Liefert alle
	 * Familiennamen</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return das suffix Objekt
	 */
	public String getFamilyNames() {
		return Util.joinEListStr(mPn.getFamilies());
	}

	/**
	 * <div class="en">Gets the given names.</div> <div class="de">Liefert alle
	 * Vornamen</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return Vornamen
	 */
	public String getGivenNames() {
		return Util.joinEListStr(mPn.getGivens());
	}

	/**
	 * <div class="en">Gets the mdht pn.</div> <div class="de">Liefert mdht
	 * pn.</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return PN <div class="en">the mdht pn</div>
	 */
	public PN getMdhtPn() {
		return mPn;
	}

	/**
	 * <div class="en">Gets the prefixes.</div> <div class="de">Liefert alle
	 * Prefixes (z.B. "Dr. med.")</div> <div class="fr"></div> <div
	 * class="it"></div>
	 * 
	 * @return das prefix Objekt
	 */
	public String getPrefixes() {
		return Util.joinEListStr(mPn.getPrefixes());
	}

	/**
	 * <div class="en">Gets the suffixes.</div> <div class="de">Liefert alle
	 * suffixes (z.B. " der Dritte")</div> <div class="fr"></div> <div
	 * class="it"></div>
	 * 
	 * @return das suffix Objekt
	 */
	public String getSuffixes() {
		return Util.joinEListStr(mPn.getSuffixes());
	}

	/**
	 * <div class="en">Sets the family name.</div> <div class="de">Setzt family
	 * name.</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * 
	 * @param familyName
	 *            Nachnamen
	 */
	public void setFamilyName(String familyName) {
		if ((familyName != null) && !familyName.equals("")) {
			mPn.addFamily(familyName);
		}
	}

	/**
	 * <div class="en">Sets the given name.</div> <div class="de">Setzt given
	 * name.</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * 
	 * @param givenName
	 *            Vornamen
	 */
	public void setGivenName(String givenName) {
		if ((givenName != null) && !givenName.equals("")) {
			mPn.addGiven(givenName);
		}
	}

	/**
	 * <div class="en">Sets the pn.</div> <div class="de">Setzt pn.</div> <div
	 * class="fr"></div> <div class="it"></div>
	 * 
	 * @param mdhtPn
	 *            <div class="en">the new pn</div> <div class="de">das neue
	 *            pn.</div> <div class="fr"></div> <div class="it"></div>
	 */
	public void setPn(PN mdhtPn) {
		mPn = mdhtPn;
	}

	/**
	 * <div class="en">Sets the prefix.</div> <div class="de">Setzt ein prefix
	 * (z.B. "Dr. med.")</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * 
	 * @param prefix
	 *            das prefix Objekt welches gesetzt wird
	 */
	public void setPrefix(String prefix) {
		if ((prefix != null) && !prefix.equals("")) {
			mPn.addPrefix(prefix);
		}
	}

	/**
	 * <div class="en">Sets the suffix.</div> <div class="de">Setzt ein suffix.
	 * z.B. "der Dritte"</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param suffix
	 *            das suffix Objekt welches gesetzt wird
	 */
	public void setSuffix(String suffix) {
		if ((suffix != null) && !suffix.equals("")) {
			mPn.addSuffix(suffix);
		}
	}
}
