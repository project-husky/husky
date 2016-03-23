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
 * Year of publication: 2016
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtOrganizerFacade;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

/**
 * The Class LaboratoryIsolateOrganizer. The Laboratory Isolate Organizer SHALL
 * be used only if the entry represents a microbiology 975 specimen study with
 * isolates discovered on the specimen. The isolate is represented by the
 * Isolate role played by the Isolate entity. The isolate identification is
 * carried by the code attribute of the Isolate entity.
 */
public class LaboratoryIsolateOrganizer extends
		MdhtOrganizerFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer> {

	/**
	 * Instantiates a new laboratory isolate organizer.
	 */
	protected LaboratoryIsolateOrganizer() {
		super(LABFactory.eINSTANCE.createLaboratoryIsolateOrganizer().init());
	}

	/**
	 * Instantiates a new laboratory isolate organizer.
	 *
	 * @param mdht
	 *            the mdht
	 */
	protected LaboratoryIsolateOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer mdht) {
		super(mdht);
	}

}
