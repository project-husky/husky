package org.ehealth_connector.cda.ihe.lab;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Value;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;

public class VitalSignsObservation
		extends MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation> {

	public VitalSignsObservation() {
		super(IHEFactory.eINSTANCE.createVitalSignObservation().init());
	}

	protected VitalSignsObservation(VitalSignObservation mdht) {
		super(mdht);
	}

	public void addMethodCode(Code code) {
		getMdht().getMethodCodes().add(code.getCE());
	}

	// Siehe VitalSignObservation - VitalSignCodes von Thomas
	// Siehe IHE_PCC_TF_2 6.3.4.22.3
	@Override
	public void addValue(Value value) {

	}

	public List<Code> getMethodCodes() {
		List<Code> cl = new ArrayList<Code>();
		for (CE ce : getMdht().getMethodCodes()) {
			cl.add(new Code(ce));
		}
		return cl;
	}
}
