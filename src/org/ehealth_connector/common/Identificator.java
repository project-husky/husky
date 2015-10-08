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
import org.ehealth_connector.common.enums.IdentityDomain;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 * Representiert eine weltweit eindeutige ID (besteht aus lokaler ID und der OID
 * der Domäne).
 */
public class Identificator {

	/**
	 * <div class="en">Converts to identificator.</div> <div
	 * class="de">Konvertiert einen Code in ein Identificator Objekt</div> <div
	 * class="fr"></div> <div class="it"></div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div> <div class="fr"></div> <div
	 *            class="it"></div>
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
	 * <div class="en">Gets the identificator.</div> <div class="de">Liefert
	 * identificator.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param iiList
	 * <br>
	 *            <div class="de"> ii list</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @param root
	 * <br>
	 *            <div class="de"> root</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 * @return <div class="en">the identificator</div>
	 */
	public static Identificator getIdentificator(List<II> iiList, String root) {
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
	 * Erstellt einen neuen Identifikator.
	 *
	 * @param oid
	 *            OID der Domäne, in welcher die lokale ID eindeutig ist
	 * @param id
	 *            lokale ID
	 */
	public Identificator(IdentityDomain oid, String id) {
		mII = DatatypesFactory.eINSTANCE.createII();
		setRoot(oid.getCodeSystemId());
		setExtension(id);
	}

	/**
	 * <div class="en">Instantiates a new identificator.</div> <div
	 * class="de">Instantiiert </div> <div class="fr"></div> <div
	 * class="it"></div>
	 *
	 * @param ii
	 * <br>
	 *            <div class="de"> ii</div> <div class="fr"></div> <div
	 *            class="it"></div>
	 */
	public Identificator(II ii) {
		mII = ii;
	}

	/**
	 * Erstellt einen neuen Identifikator.
	 *
	 * @param oid
	 *            OID der Domäne, in welcher die lokale ID eindeutig ist
	 * @param id
	 *            lokale ID
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
		Identificator other = (Identificator) obj;
		if (this.mII == other.mII)
			return true;
		if (!this.mII.getDisplayable().equals(other.mII.getDisplayable())
				&& this.mII.getExtension().equals(other.mII.getExtension())
				&& this.mII.getRoot().equals(other.mII.getRoot())
				&& this.mII.getNullFlavor().getName().equals(other.mII.getNullFlavor().getName())
				&& this.mII.getNullFlavor().getValue() == other.mII.getNullFlavor().getValue())
			return false;
		return true;
	}

	/**
	 * Liefert die ID.
	 *
	 * @return ID
	 */
	public String getExtension() {
		return mII.getExtension();
	}

	/**
	 * <div class="en">Gets the ii.</div> <div class="de">Liefert ii.</div> <div
	 * class="fr"></div> <div class="it"></div>
	 *
	 * @return II <div class="en">the ii</div>
	 */
	public II getIi() {
		return EcoreUtil.copy(mII);
	}

	/**
	 * Liefert die OID (der Domäne).
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
	 * Setzt die OID.
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
	 * Setzt die OID.
	 *
	 * @param root
	 *            OID einer Domäne
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
