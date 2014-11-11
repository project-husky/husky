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

import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;

/**
 * Der HL7 Datentyp Name
 *
 */
public class Name {

	PN mPn;
	
	/**
	 * Erzeugt einen Personennamen (Dieser Konstruktor wird oft gebraucht für
	 * Patienten)
	 * 
	 * @param name Nachname
 	 * @param firstName Vorname
	 */
	public Name(String firstName, String name) {
		// Create and fill Person Name
		mPn = DatatypesFactory.eINSTANCE.createPN();
		if ((firstName != null) && !firstName.equals("")) {
			this.setFirstName(firstName);
		}
		if ((name != null) && !name.equals("")) {
			this.setName(name);
		}
	}
	
	/**
	 * Erzeugt einen Personennamen (Dieser Konstruktor wird oft gebraucht für
	 * Behandelnde)
	 * 
	 * @param name Nachname
 	 * @param firstName Vorname
 	 * @param title Titel (z.B. Dr. med.)
	 */
	public Name(String name, String firstName, String title) {
		this(name, firstName);
		mPn.addPrefix(title);
	}

	/**
	 * Erzeugt einen Personennamen
	 * 
	 * @param name Nachname
 	 * @param firstName Vorname
 	 * @param prefix Prefix (z.B. "Dipl. Inf.")
 	 * @param suffix Suffix (z.b. "der Dritte") 
	 */
	public Name(String name, String firstName, String prefix, String suffix) {
		this(name, firstName, prefix);
		mPn.addSuffix(suffix);
	}

	/**
	 * @param pn
	 */
	public Name(PN pn) {
		this.mPn = pn;
	}

	/**
	 * @return das firstName Objekt
	 */
	public String getFirstName() {
		return mPn.getGivens().get(0).getText();
	}

	/**
	 * @return das name Objekt
	 */
	public String getName() {
		return mPn.getFamilies().get(0).getText();
	}
	
	public String cGetCompleteName() {
		StringBuilder nameBuilder = new StringBuilder();

		if (this.getPrefix() != null) {
			nameBuilder.append(getPrefix()+" ");
		}
		if (this.getFirstName() != null) {
			nameBuilder.append(getFirstName()+" ");
		}
		if (this.getName() != null) {
			nameBuilder.append(getName()+" ");
		}
		// TODO if a part of the name is not present, the system throws a IndexOutOfBounds exception (not null).
//		if (this.cGetSuffix() != null) {
//			nameBuilder.append(cGetSuffix());
//		}
		return nameBuilder.toString();
	}

	/**
	 * @return das prefix Objekt
	 */
	public String getPrefix() {
		return mPn.getPrefixes().get(0).getText();
	}

	/**
	 * @return das suffix Objekt
	 */
	public String getSuffix() {
		return mPn.getSuffixes().get(0).getText();
	}

	/**
	 * @return das title Objekt
	 */
	public String getTitle() {
		return mPn.getPrefixes().get(0).getText();
	}

	/**
	 * @param firstName
	 *          das firstName Objekt welches gesetzt wird
	 */
	public void setFirstName(String firstName) {
		if ((firstName != null) && !firstName.equals("")) {
			mPn.addGiven(firstName);
		}
	}

	/**
	 * @param name
	 *          das name Objekt welches gesetzt wird
	 */
	public void setName(String name) {
		if ((name != null) && !name.equals("")) {
			mPn.addFamily(name);
		}
	}

	/**
	 * @param prefix
	 *          das prefix Objekt welches gesetzt wird
	 */
	public void setPrefix(String prefix) {
		if ((prefix != null) && !prefix.equals("")) {
			mPn.addPrefix(prefix);
		}
	}

	/**
	 * @param title
	 *          das title Objekt welches gesetzt wird
	 */
	public void setTitle(String title) {
		mPn.addPrefix(title);
	}

	/**
	 * @param suffix
	 *          das suffix Objekt welches gesetzt wird
	 */
	public void setSuffix(String suffix) {
		if ((suffix != null) && !suffix.equals("")) {
			mPn.addSuffix(suffix);
		}
	}

}
