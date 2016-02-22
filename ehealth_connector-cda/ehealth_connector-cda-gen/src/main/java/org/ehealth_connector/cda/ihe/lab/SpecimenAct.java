package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public class SpecimenAct extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct> {

	protected SpecimenAct() {
		super(LABFactory.eINSTANCE.createSpecimenAct().init());
	}

	protected SpecimenAct(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct mdht) {
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
