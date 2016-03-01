package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtParticipant1Facade;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public class ReferralOrderingPhysician extends
		MdhtParticipant1Facade<org.openhealthtools.mdht.uml.cda.ihe.lab.ReferralOrderingPhysician> {

	protected ReferralOrderingPhysician() {
		super(LABFactory.eINSTANCE.createReferralOrderingPhysician().init());
	}

	protected ReferralOrderingPhysician(
			org.openhealthtools.mdht.uml.cda.ihe.lab.ReferralOrderingPhysician mdht) {
		super(mdht);
	}

}
