package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.common.Code;

public class SpecimenAct extends AbstractSpecimenAct {

	protected SpecimenAct() {
		super();
	}

	protected SpecimenAct(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct mdht) {
		super(mdht);
	}

	@Override
	protected Code getStatusCode() {
		if (getMdht() != null && getMdht().getStatusCode() != null) {
			return new Code(getMdht().getStatusCode());
		}
		return null;
	}

	@Override
	protected void setStatusCode(Code code) {
		getMdht().setStatusCode(code.getCS());
	}

}