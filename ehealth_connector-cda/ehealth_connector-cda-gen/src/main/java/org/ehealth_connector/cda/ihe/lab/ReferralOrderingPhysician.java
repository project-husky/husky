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

import org.ehealth_connector.cda.AssociatedEntity;
import org.ehealth_connector.cda.MdhtParticipant1Facade;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

/**
 * The Class ReferralOrderingPhysician.
 */
public class ReferralOrderingPhysician extends
		MdhtParticipant1Facade<org.openhealthtools.mdht.uml.cda.ihe.lab.ReferralOrderingPhysician> {

	/**
	 * Instantiates a new referral ordering physician.
	 * ClinicalDocument/participant(s) MAY be present. When present, this
	 * element SHALL be in accordance with the HL7 CDA R2 standard with a time
	 * element and further constrained by this specification to require the
	 * presence of name, addr and telecom.
	 */
	public ReferralOrderingPhysician() {
		super(LABFactory.eINSTANCE.createReferralOrderingPhysician().init());
	}

	/**
	 * Creates the ReferralOrderingPhysician with the given AssociatedEntity.
	 *
	 * @param entity
	 *            the entity
	 */
	public ReferralOrderingPhysician(AssociatedEntity entity) {
		this();
		setAssociatedEntity(entity);
	}

	/**
	 * Instantiates a new referral ordering physician.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public ReferralOrderingPhysician(
			org.openhealthtools.mdht.uml.cda.ihe.lab.ReferralOrderingPhysician mdht) {
		super(mdht);
	}
}
