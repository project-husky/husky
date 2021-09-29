/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */

package org.ehealth_connector.common.mdht;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.mdht.enums.NameQualifier;
import org.ehealth_connector.common.mdht.enums.NameUse;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ENXP;
import org.openhealthtools.mdht.uml.hl7.datatypes.ON;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityNamePartQualifier;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityNameUse;

public class Name {

	/**
	 * Der HL7 Datentyp Name.
	 */
	private PN mPn;

	/**
	 * <div class="en">Instantiates a new name.</div>
	 * <div class="de">Instantiiert ein neues Name Objekt</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param organizationName
	 *            <br>
	 *            <div class="de"> on</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Name(ON organizationName) {
		mPn = DatatypesFactory.eINSTANCE.createPN();
		mPn.addText(organizationName.getText());
	}

	/**
	 * <div class="en">Instantiates a new name.</div>
	 * <div class="de">Instantiiert ein neues Name Objekt mit einem MDHT PN
	 * Objekt</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param personName
	 *            <br>
	 *            <div class="de"> pn</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Name(PN personName) {
		mPn = personName;
	}

	/**
	 * <div class="en">Instantiates a new name.</div>
	 * <div class="de">Instantiiert ein neues Name Objekt</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param name
	 *            <br>
	 *            <div class="de"> on</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Name(String name) {
		setName(name);
	}

	/**
	 * <div class="en">Instantiates a new name.</div>
	 * <div class="de">Instantiiert ein neues Name Objekt</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param name
	 *            <br>
	 *            <div class="de"> on</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param use
	 *            the use
	 */
	public Name(String name, NameUse use) {
		mPn = DatatypesFactory.eINSTANCE.createPN();
		mPn.addText(name);
		setUse(use);
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
		if ((givenName != null) && !"".equals(givenName)) {
			setGivenName(givenName);
		}
		if ((familyName != null) && !"".equals(familyName)) {
			setFamilyName(familyName);
		}
	}

	/**
	 * Erzeugt einen Personennamen (Dieser Konstruktor wird oft gebraucht für
	 * Patienten).
	 *
	 * @param givenName
	 *            Vorname
	 * @param familyName
	 *            Nachname
	 * @param use
	 *            the person name usage code
	 */
	public Name(String givenName, String familyName, NameUse use) {
		this(givenName, familyName);
		setUse(use);
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
	 * <div class="en">Copy mdht pn.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return PN the pn
	 */
	public PN copyMdhtPn() {
		return EcoreUtil.copy(mPn);
	}

	/**
	 * <div class="en">Gets the family names.</div> <div class="de">Liefert alle
	 * Familiennamen</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return das suffix Objekt
	 */
	public String getAllFamilyNames() {
		return mPn.getFamilies().toString();
	}

	/**
	 * <div class="en">Gets the given names.</div> <div class="de">Liefert alle
	 * Vornamen</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Vornamen
	 */
	public String getAllGivenNames() {
		return mPn.getGivens().toString();
	}

	/**
	 * <div class="en">Gets the complete name.</div> <div class="de">Liefert den
	 * ganzen Namen (z.B. "Dr. Allzeit Bereit der Dritte")</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return String <div class="en">the complete name</div>
	 */
	public String getCompleteName() {

		final String prefixes = getPrefixes();
		final String givens = getAllGivenNames();
		final String families = getAllFamilyNames();
		final String suffixes = getSuffixes();

		final List<String> nameList = new ArrayList<String>();
		nameList.add(mPn.getText());
		nameList.add(prefixes);
		nameList.add(givens);
		nameList.add(families);
		nameList.add(suffixes);

		return Util.join(nameList, " ").trim();
	}

	/**
	 * <div class="en">Gets the (first) family name.</div>
	 * <div class="de">Liefert den (ersten) Familiennamen</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Nachnamen
	 */
	public String getFamilyName() {
		return mPn.getFamilies().get(0).getText();
	}

	/**
	 * Gets the Family names as list of String.
	 *
	 * @return the Family names
	 */
	public List<String> getFamilyNames() {
		List<String> retVal = new ArrayList<String>();
		for (ENXP item : mPn.getFamilies()) {
			retVal.add(item.getText());
		}
		return retVal;
	}

	/**
	 * Gets the given names as list of String.
	 *
	 * @return the given names
	 */
	public List<String> getGivenNames() {
		List<String> retVal = new ArrayList<String>();
		for (ENXP item : mPn.getGivens()) {
			retVal.add(item.getText());
		}
		return retVal;
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public Object getName() {
		return mPn.getText();
	}

	/**
	 * <div class="en">Gets the prefixes.</div> <div class="de">Liefert alle
	 * Prefixes (z.B. "Dr. med.")</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return das prefix Objekt
	 */
	public String getPrefixes() {
		return mPn.getPrefixes().toString();
	}

	/**
	 * <div class="en">Gets the suffixes.</div> <div class="de">Liefert alle
	 * suffixes (z.B. " der Dritte")</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return das suffix Objekt
	 */
	public String getSuffixes() {
		return mPn.getSuffixes().toString();
	}

	/**
	 * <div class="en">Gets the person name use. Default is LEGAL.</div>
	 * <div class="de">Liefert den Verwendungszweck (default ist LEGAL).</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the use
	 */
	public NameUse getUse() {
		NameUse retVal = null;
		if (mPn.getUses() != null) {
			if (mPn.getUses().size() > 0) {
				switch (mPn.getUses().get(0)) {
				case ASGN:
					retVal = NameUse.ASSIGNED;
					break;
				case L:
					retVal = NameUse.LEGAL;
					break;
				case P:
					retVal = NameUse.PSEUDONYM;
					break;
				default:
					retVal = NameUse.LEGAL;
					break;
				}
			}
		}
		return retVal;
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
		if ((familyName != null) && !"".equals(familyName)) {
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
		if ((givenName != null) && !"".equals(givenName)) {
			mPn.addGiven(givenName);
		}
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	private void setName(String name) {
		mPn = DatatypesFactory.eINSTANCE.createPN();
		mPn.addText(name);
	}

	/**
	 * <div class="en">Sets the pn.</div> <div class="de">Setzt pn.</div>
	 * <div class="fr"></div> <div class="it"></div>
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
		if ((prefix != null) && !"".equals(prefix)) {
			mPn.addPrefix(prefix);
		}
	}

	/**
	 * <div class="en">Sets the prefix.</div> <div class="de">Setzt ein prefix
	 * (z.B. "Dr. med.")</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param prefix
	 *            das prefix Objekt welches gesetzt wird
	 * @param qualifier
	 *            the qualifier
	 */
	public void setPrefix(String prefix, NameQualifier qualifier) {
		if ((prefix != null) && !"".equals(prefix)) {
			final ENXP enxp = DatatypesFactory.eINSTANCE.createENXP();
			enxp.addText(prefix);
			enxp.getQualifiers().clear();
			switch (qualifier) {
			case ACADEMIC:
				enxp.getQualifiers().add(EntityNamePartQualifier.AC);
			}
			mPn.getPrefixes().clear();
			mPn.getPrefixes().add(enxp);
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
		if ((suffix != null) && !"".equals(suffix)) {
			mPn.addSuffix(suffix);
		}
	}

	/**
	 * <div class="en">Sets the use code.</div> <div class="de">Setzt den
	 * Verwendungszweck."</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param use
	 *            the new use code
	 */
	public void setUse(NameUse use) {
		if (use != null) {
			EntityNameUse useCode = EntityNameUse.L;
			mPn.getUses().clear();
			switch (use) {
			case ASSIGNED:
				useCode = EntityNameUse.ASGN;
				break;
			case LEGAL:
				useCode = EntityNameUse.L;
				break;
			case PSEUDONYM:
				useCode = EntityNameUse.P;
				break;
			}
			mPn.getUses().add(useCode);
		}
	}
}
