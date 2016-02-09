package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation;

public class VitalSignsObservation
		extends MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation> {

	public VitalSignsObservation() {
		super(IHEFactory.eINSTANCE.createVitalSignObservation().init());
	}

	protected VitalSignsObservation(VitalSignObservation mdht) {
		super(mdht);
	}

	public Code getMethodCode() {
		return null;

	}

	public void setMethodCode(Code code) {

	}
}
