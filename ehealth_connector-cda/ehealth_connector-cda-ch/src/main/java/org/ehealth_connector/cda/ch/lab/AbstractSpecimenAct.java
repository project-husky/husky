package org.ehealth_connector.cda.ch.lab;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.Act;

public abstract class AbstractSpecimenAct
		extends org.ehealth_connector.cda.ihe.lab.AbstractSpecimenAct {

	public AbstractSpecimenAct() {
		super();
		super.setStatusCode(StatusCode.COMPLETED.getCode());
	}

	public AbstractSpecimenAct(Act mdht) {
		super(mdht);
	}

	public Code getCode() {
		return new Code(getMdht().getCode());
	}

	public void setCode(Code code) {
		getMdht().setCode(code.getCD());
	}
}
