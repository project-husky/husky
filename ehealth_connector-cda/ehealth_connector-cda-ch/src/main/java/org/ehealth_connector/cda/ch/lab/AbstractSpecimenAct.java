package org.ehealth_connector.cda.ch.lab;

import org.ehealth_connector.common.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.Act;

public abstract class AbstractSpecimenAct
		extends org.ehealth_connector.cda.ihe.lab.AbstractSpecimenAct {

	public AbstractSpecimenAct() {
		super();
	}

	public AbstractSpecimenAct(Act mdht) {
		super(mdht);
		super.setStatusCode(StatusCode.COMPLETED.getCode());
	}
}
