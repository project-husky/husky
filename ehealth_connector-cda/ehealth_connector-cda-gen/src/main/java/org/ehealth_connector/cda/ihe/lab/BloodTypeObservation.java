package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public class BloodTypeObservation
		extends MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.BloodTypeObservation> {

	protected BloodTypeObservation() {
		super(LABFactory.eINSTANCE.createBloodTypeObservation());
	}

	protected BloodTypeObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.BloodTypeObservation mdht) {
		super(mdht);
	}
}
