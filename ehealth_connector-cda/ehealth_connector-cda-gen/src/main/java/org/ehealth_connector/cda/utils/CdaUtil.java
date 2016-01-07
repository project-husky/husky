/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.cda.utils;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Component3;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.StructuredBody;

/**
 * @author roeland
 * @version 1.0
 * @since Jun 16, 2015 6:34:53 AM
 */
public abstract class CdaUtil {

	/**
	 * Adds the copy of a given section to a given structured body
	 * 
	 * @param sb
	 *            the StructuredBody
	 * @param s
	 *            the Section
	 */
	public static void addSectionToStructuredBodyAsCopy(StructuredBody sb, Section s) {
		if ((sb != null) && (s != null)) {
			final Component3 c = CDAFactory.eINSTANCE.createComponent3();
			c.setSection(EcoreUtil.copy(s));
			sb.getComponents().add(c);
		}
	}

	// /**
	// * <div class="en">Creates a UUID and a generated extension.</div>
	// *
	// * @param id
	// * <br>
	// * <div class="en"> the id</div>
	// * @return the ii
	// */
	// public static II createUuidIdentificator(Identificator id) {
	// II ii;
	// if (id == null) {
	// ii = createUuid(null);
	// } else {
	// ii = id.getIi();
	// }
	// return ii;
	// }
	//
	// /**
	// * <div class="en">Creates a UUID for VACD documents with the VACD root ID
	// * and a generated extension.</div>
	// *
	// * @param id
	// * <br>
	// * <div class="en"> the id</div>
	// * @return the ii
	// */
	// public static II createUuid(String id) {
	// final II ii = DatatypesFactory.eINSTANCE.createII();
	// // ii.setRoot(CdaChVacd.OID_MAIN);
	// if (id == null) {
	// ii.setExtension(UUID.generate());
	// } else {
	// // TODO should this not be ii.setExtension(id) ?
	// // ii.setRoot(id);
	// ii.setExtension(id);
	// }
	// return ii;
	// }

}
