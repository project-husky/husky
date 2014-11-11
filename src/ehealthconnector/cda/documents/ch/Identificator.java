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
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

import ehealthconnector.cda.documents.ch.ConvenienceUtilsEnums.KnownOID;

/**
 * Representiert eine weltweit eindeutige ID (besteht aus lokaler ID und der OID
 * der Domäne)
 */
public class Identificator {

	II mII;
	
	/**
	 * Erstellt einen neuen Identifikator
	 * 
	 * @param id
	 *          lokale ID
	 * @param oid
	 *          OID der Domäne, in welcher die lokale ID eindeutig ist
	 */
	public Identificator(String id, KnownOID oid) {
		this.mII = DatatypesFactory.eINSTANCE.createII();
		this.setRoot(ehealthconnector.cda.documents.ch.ConvenienceUtilsEnums.knownOID(oid));
		this.setExtension(id);
	}

	/**
	 * Erstellt einen neuen Identifikator
	 * 
	 * @param id
	 *          lokale ID
	 * @param oid
	 *          OID der Domäne, in welcher die lokale ID eindeutig ist
	 */
	public Identificator(String id, String oid) {
		this.mII = DatatypesFactory.eINSTANCE.createII();
		this.setRoot(oid);
		this.setExtension(id);
	}
	
	/**
	 * Liefert die OID (der Domäne)
	 * @return OID
	 */
	public String getRoot(){
		return this.mII.getRoot();
	}
	
	/**
	 * Setzt die OID
	 * @param root
	 * 			OID einer Domäne
	 */
	public void setRoot(String root) {
		if (root != null && !root.equals("")) {
			this.mII.setRoot(root);
		}
	}
	
	/**
	 * Liefert die ID
	 * @return ID
	 */
	public String getExtension(){
		return this.mII.getExtension();
	}
	
	/**
	 * Setzt die OID
	 * @param extension
	 * 			Extension ID 
	 */
	public void setExtension(String extension) {
		if (extension != null && !extension.equals("")) {
			this.mII.setExtension(extension);
		}
	}
}
