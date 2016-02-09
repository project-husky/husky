package org.ehealth_connector.cda.ch.lab.lrtp;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

public class SoasInfoEntry
		extends MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ch.SoasInfoEntry> {

	protected SoasInfoEntry() {
		super(CHFactory.eINSTANCE.createSoasInfoEntry().init());
	}

	protected SoasInfoEntry(org.openhealthtools.mdht.uml.cda.ch.SoasInfoEntry mdht) {
		super(mdht);
	}
}
