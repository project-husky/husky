package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public class OutbreakIdentificationObservation
		extends MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.OutbreakIdentification> {

	protected OutbreakIdentificationObservation() {
		super(LABFactory.eINSTANCE.createOutbreakIdentification().init());
	}

	protected OutbreakIdentificationObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.OutbreakIdentification mdht) {
		super(mdht);
	}
}