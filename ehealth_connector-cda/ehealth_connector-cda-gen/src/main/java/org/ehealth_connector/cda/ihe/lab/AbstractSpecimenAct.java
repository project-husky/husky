package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public abstract class AbstractSpecimenAct
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct> {

	protected AbstractSpecimenAct() {
		super(LABFactory.eINSTANCE.createSpecimenAct().init());
	}

	protected AbstractSpecimenAct(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct mdht) {
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
