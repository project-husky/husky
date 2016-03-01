package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.AssociatedEntity;
import org.ehealth_connector.cda.MdhtParticipant1Facade;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public class ReferralOrderingPhysician extends
		MdhtParticipant1Facade<org.openhealthtools.mdht.uml.cda.ihe.lab.ReferralOrderingPhysician> {

	public ReferralOrderingPhysician() {
		super(LABFactory.eINSTANCE.createReferralOrderingPhysician().init());
	}

	/**
	 * Creates the ReferralOrderingPhysician with the given AssociatedEntity
	 *
	 * @param entity
	 */
	public ReferralOrderingPhysician(AssociatedEntity entity) {
		this();
		setAssociatedEntity(entity);
	}

	public ReferralOrderingPhysician(
			org.openhealthtools.mdht.uml.cda.ihe.lab.ReferralOrderingPhysician mdht) {
		super(mdht);
	}
}
