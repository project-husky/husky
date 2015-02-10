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

import java.util.List;

import org.ehc.cda.ch.enums.CodeSystems;
import org.ehc.common.ConvenienceUtilsEnums.KnownOID;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 * Representiert eine weltweit eindeutige ID (besteht aus lokaler ID und der OID
 * der Domäne)
 */
public class Identificator {
	
	public static Identificator convertToIdentificator(Code code) {
		Identificator id = new Identificator(code.getOid(), code.getCode());
		return id;
	}

	public static Identificator getIdentificator(List<II> iiList, String root) {
		for (II i : iiList) {
			if (i.getRoot().equals(root)) {
				Identificator id = new Identificator(i);
				return id;
			}
		}
		return null;
	}

	II mII;

	/**
	 * Erstellt einen neuen Identifikator
	 * 
	 * @param oid
	 *          OID der Domäne, in welcher die lokale ID eindeutig ist
	 * @param id
	 *          lokale ID
	 */
	public Identificator(CodeSystems oid, String id) {
		mII = DatatypesFactory.eINSTANCE.createII();
		setRoot(oid.getCodeSystemId());
		setExtension(id);
	}

	public Identificator(II ii) {
		mII = ii;
	}

	/**
	 * Erstellt einen neuen Identifikator
	 * 
	 * @param oid
	 *          OID der Domäne, in welcher die lokale ID eindeutig ist
	 * @param id
	 *          lokale ID
	 */
	public Identificator(KnownOID oid, String id) {
		mII = DatatypesFactory.eINSTANCE.createII();
		setRoot(ConvenienceUtilsEnums.knownOID(oid));
		setExtension(id);
	}

	/**
	 * Erstellt einen neuen Identifikator
	 * 
	 * @param oid
	 *          OID der Domäne, in welcher die lokale ID eindeutig ist
	 * @param id
	 *          lokale ID
	 */
	public Identificator(String oid, String id) {
		mII = DatatypesFactory.eINSTANCE.createII();
		setRoot(oid);
		setExtension(id);
	}

	/**
	 * Liefert die ID
	 * @return ID
	 */
	public String getExtension(){
		return mII.getExtension();
	}

	public II getIi() {
		return mII;
	}

	/**
	 * Liefert die OID (der Domäne)
	 * @return OID
	 */
	public String getRoot(){
		return mII.getRoot();
	}

	/**
	 * Setzt die OID
	 * @param extension
	 * 			Extension ID 
	 */
	public void setExtension(String extension) {
		if (extension != null && !extension.equals("")) {
			mII.setExtension(extension);
		}
	}

	/**
	 * Setzt die OID
	 * @param root
	 * 			OID einer Domäne
	 */
	public void setRoot(String root) {
		if (root != null && !root.equals("")) {
			mII.setRoot(root);
		}
	}
}
