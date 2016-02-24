package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtActFacade;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public abstract class AbstractSpecimenAct extends MdhtActFacade<Act> {

	protected AbstractSpecimenAct() {
		super(LABFactory.eINSTANCE.createSpecimenAct().init());
	}

	protected AbstractSpecimenAct(Act mdht) {
		super(mdht);
	}

	protected Code getStatusCode() {
		if (getMdht() != null && getMdht().getStatusCode() != null) {
			return new Code(getMdht().getStatusCode());
		}
		return null;
	}

	protected void setStatusCode(Code code) {
		getMdht().setStatusCode(code.getCS());
	}

}
