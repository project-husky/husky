package org.ehealth_connector.cda;

import org.ehealth_connector.common.enums.NullFlavor;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.VitalSignsOrganizer;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;

public class AbstractVitalSignsOrganizer
		extends MdhtOrganizerFacade<org.openhealthtools.mdht.uml.cda.ihe.VitalSignsOrganizer> {

	protected AbstractVitalSignsOrganizer() {
		super(IHEFactory.eINSTANCE.createVitalSignsOrganizer().init());
	}

	protected AbstractVitalSignsOrganizer(VitalSignsOrganizer mdht) {
		super(mdht);
	}

	public NullFlavor getEffectiveTimeNullFlavor() {
		if (getMdht().getEffectiveTime() != null && getMdht().getEffectiveTime().isSetNullFlavor()) {
			return NullFlavor.getEnum(getMdht().getEffectiveTime().getNullFlavor().getLiteral());
		}
		return null;
	}

	public void setEffectiveTimeNullFlavor(NullFlavor nullFlavor) {
		IVL_TS ivlts = DatatypesFactory.eINSTANCE.createIVL_TS();
		ivlts.setNullFlavor(
				org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor.get(nullFlavor.getCodeValue()));
		getMdht().setEffectiveTime(ivlts);
	}
}
