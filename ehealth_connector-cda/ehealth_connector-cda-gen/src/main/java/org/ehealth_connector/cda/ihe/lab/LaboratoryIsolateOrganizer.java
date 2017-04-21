/*
 * 
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 * 
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
	public LaboratoryIsolateOrganizer() {
		super(LABFactory.eINSTANCE.createLaboratoryIsolateOrganizer().init());
	}

	/**
	 * Instantiates a new laboratory isolate organizer.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public LaboratoryIsolateOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer mdht) {
		super(mdht);
	}

}
