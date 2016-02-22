package org.ehealth_connector.cda.ch.lab;

import org.ehealth_connector.common.enums.StatusCode;

public abstract class AbstractSpecimenAct
		extends org.ehealth_connector.cda.ihe.lab.AbstractSpecimenAct {

	public AbstractSpecimenAct() {
		super();
	}

	public AbstractSpecimenAct(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct mdht) {
		super(mdht);
		super.setStatusCode(StatusCode.COMPLETED.getCode());
	}
}
