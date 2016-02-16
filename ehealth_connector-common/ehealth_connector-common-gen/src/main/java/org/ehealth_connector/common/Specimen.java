package org.ehealth_connector.common;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openhealthtools.mdht.uml.cda.CDAFactory;

public class Specimen extends SpecimenRole {
	org.openhealthtools.mdht.uml.cda.Specimen mSpecimen;

	public Specimen() {
		super();
		mSpecimen = CDAFactory.eINSTANCE.createSpecimen();
		mSpecimen.setSpecimenRole(mSpecimenRole);
	}

	public Specimen(org.openhealthtools.mdht.uml.cda.Specimen mdht) {
		super(mdht.getSpecimenRole());
		mSpecimen = mdht;
	}

	public org.openhealthtools.mdht.uml.cda.Specimen copy() {
		return EcoreUtil.copy(mSpecimen);
	}

	public org.openhealthtools.mdht.uml.cda.Specimen getMdht() {
		return mSpecimen;
	}
}
