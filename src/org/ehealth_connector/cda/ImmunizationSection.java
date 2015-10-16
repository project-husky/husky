package org.ehealth_connector.cda;

import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

public class ImmunizationSection
		extends EFacade<org.openhealthtools.mdht.uml.cda.ch.ImmunizationsSection> {

	public ImmunizationSection() {
		super(CHFactory.eINSTANCE.createImmunizationsSection().init(), null, null);
	}

	public ImmunizationSection(
			org.openhealthtools.mdht.uml.cda.ch.ImmunizationsSection immunizationSection) {
		super(immunizationSection, null, null);
	}

	public void addImmunization(org.ehealth_connector.cda.Immunization immunization) {
		if (immunization != null) {
			getMdht().addSubstanceAdministration(immunization.getMdht());
		}
	}

}
