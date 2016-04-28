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

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.valueset.enums.IdentityDomain;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 *
 * <div class="en">Represents an identifier</div> <div class="de">Repräsentiert
 * einen identifier (besteht typischerweise aus lokaler ID und der OID der
 * Domäne).</div>
 */
public class Identificator {

	/**
	 * <div class="en">Converts a code to an identificator.</div>
	 * <div class="de">Konvertiert einen Code in ein Identificator Objekt</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="en"> code</div>
	 * @return the identificator
	 */
	public static Identificator convertToIdentificator(Code code) {
		if (code != null) {
			final Identificator id = new Identificator(code.getCodeSystem(), code.getCode());
			return id;
		}
		return null;
	}

	/**
	 * <div class="en">Gets the identificator with the given root id from a list
	 * of ids.</div> <div class="de">Liefert identificator mit der gegebenen
	 * root id aus der liste der Ids.</div>
	 *
	 * @param iiList
	 *            <br>
	 *            <div class="de"> ii list</div>
	 * @param root
	 *            <br>
	 *            <div class="de"> root</div>
	 * @return <div class="en">the identificator</div>
	 */
	protected static Identificator getIdentificator(List<II> iiList, String root) {
		for (final II i : iiList) {
			if (i.getRoot().equals(root)) {
				final Identificator id = new Identificator(i);
				return id;
			}
		}
		return null;
	}

	private II mII;

	/**
	 * <div class="de">Creates a new Identificator</div>
	 * <div class="de">Erstellt einen neuen Identifikator.</div>
	 *
	 * @param oid
	 *            <div class="en">OID of the domain, in which the local id is
	 *            uniqu</div><div class="de">OID der Domäne, in welcher die
	 *            lokale ID eindeutig ist</div>
	 * @param id
	 *            lokale ID
	 */
	public Identificator(IdentityDomain oid, String id) {
		mII = DatatypesFactory.eINSTANCE.createII();
		setRoot(oid.getCodeSystemId());
		setExtension(id);
	}

	/**
	 * <div class="en">Instantiates a new identificator.</div>
	 * <div class="de">Instantiiert einen neuen Identificator</div>
	 *
	 * @param ii
	 *            <br>
	 *            <div class="de"> ii</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public Identificator(II ii) {
		mII = ii;
	}

	/**
	 * <div class="en">Instantiates a new identificator.</div>
	 * <div class="de">Instantiiert einen neuen Identificator</div>
	 *
	 * @param oid
	 *            <div class="en">OID of the domain, in which the local id is
	 *            uniqu</div><div class="de">OID der Domäne, in welcher die
	 *            lokale ID eindeutig ist</div>
	 * @param id
	 *            local id
	 */
	public Identificator(String oid, String id) {
		mII = DatatypesFactory.eINSTANCE.createII();
		setRoot(oid);
		setExtension(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Identificator)) {
			return false; // different class
		}
		final Identificator other = (Identificator) obj;
		if (this.mII == other.mII)
			return true;

		if (this.mII.getDisplayable() == null) {
			if (other.mII.getDisplayable() != null)
				return false;
		} else if (!this.mII.getDisplayable().equals(other.mII.getDisplayable()))
			return false;

		if (this.mII.getExtension() == null) {
			if (other.mII.getExtension() != null)
				return false;
		} else if (!this.mII.getExtension().equals(other.mII.getExtension()))
			return false;

		if (this.mII.getRoot() == null) {
			if (other.mII.getRoot() != null)
				return false;
		} else if (!this.mII.getRoot().equals(other.mII.getRoot()))
			return false;

		if (this.mII.getNullFlavor().getName() == null) {
			if (other.mII.getNullFlavor().getName() != null)
				return false;
		} else if (!this.mII.getNullFlavor().getName().equals(other.mII.getNullFlavor().getName()))
			return false;

		if (this.mII.getNullFlavor().getValue() == 0) {
			if (other.mII.getNullFlavor().getValue() != 0)
				return false;
		} else if (!(this.mII.getNullFlavor().getValue() == other.mII.getNullFlavor().getValue()))
			return false;
		return true;
	}

	/**
	 * Gets the extension of the id
	 *
	 * @return ID
	 */
	public String getExtension() {
		return mII.getExtension();
	}

	/**
	 * <div class="en">Gets the MDHT II object.</div> <div class="de">Liefert
	 * das MDHT II Objekt.</div>
	 *
	 * @return II <div class="en">the II object</div>
	 */
	public II getIi() {
		return EcoreUtil.copy(mII);
	}

	/**
	 * Gets the OID (the domain id)
	 *
	 * @return OID
	 */
	public String getRoot() {
		return mII.getRoot();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		if (mII == null)
			return prime;

		int result = 1;
		result = prime * result + (mII.getDisplayable() ? 0 : 1);
		result = prime * result + mII.getExtension().hashCode();
		result = prime * result + mII.getRoot().hashCode();
		result = prime * result + mII.getNullFlavor().getName().hashCode();
		result = prime * result + mII.getNullFlavor().getValue();
		return result;
	}

	/**
	 * Sets the extension
	 *
	 * @param extension
	 *            Extension ID
	 */
	public void setExtension(String extension) {
		if ((extension != null) && !"".equals(extension)) {
			mII.setExtension(extension);
		}
	}

	/**
	 * Sets the OID of the domain
	 *
	 * @param root
	 *            OID of the domain
	 */
	public void setRoot(String root) {
		if ((root != null) && !"".equals(root)) {
			mII.setRoot(root);
		}
	}

	@Override
	public String toString() {
		return "Identificator [extension=" + getExtension() + ", II=" + getIi() + ", root="
				+ getRoot() + "]";
	}
}
