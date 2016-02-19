package org.ehealth_connector.cda.ch.lab.lrtp;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.ehealth_connector.cda.enums.NullFlavor;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Value;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.BL;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

public class SoasInfoEntry
		extends MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ch.SoasInfoEntry> {

	public static final Code CENTER_SPECIFIC_AVOID_CODE = new Code("2.16.756.5.30.1.129.1.1.2",
			"001");
	public static final Code PREVIOUS_TX = new Code("2.16.756.5.30.1.129.1.1.2", "002");

	protected SoasInfoEntry() {
		super(CHFactory.eINSTANCE.createSoasInfoEntry().init(), "2.16.756.5.30.1.1.1.1.3.4.1",
				"CDA-CH.LRTP.SOASInfo");
	}

	protected SoasInfoEntry(org.openhealthtools.mdht.uml.cda.ch.SoasInfoEntry mdht) {
		super(mdht);
	}

	public Code getCode() {
		if (getMdht().getCode() != null) {
			return new Code(getMdht().getCode());
		}
		return null;
	}

	@Override
	public Value getValue() {
		if (getMdht().getValues() != null && !getMdht().getValues().isEmpty()) {
			return new Value(getMdht().getValues().get(0));
		}
		return null;
	}

	// Convenience function to determine the kind of Soas Element
	public boolean isCenterSpecificAvoid() {
		return (CENTER_SPECIFIC_AVOID_CODE.equals(this.getCode()));
	}

	// Convenience function to determine the kind of Soas Element
	public boolean isPreviousTx() {
		return (PREVIOUS_TX.equals(this.getCode()));
	}

	// Convenience function to set Code and value for centerSpecificAvoid
	public void setCenterSpecificAvoid(boolean centerSpecificAvoid) {
		this.setCode(CENTER_SPECIFIC_AVOID_CODE);
		this.setValue(new Value(centerSpecificAvoid));
	}

	public void setCode(Code code) {
		getMdht().setCode(code.getCD());
	}

	// Convenience function to set Code and value for previosTx
	public void setPreviousTx(boolean previousTx) {
		this.setCode(PREVIOUS_TX);
		getMdht().getValues().clear();
		this.setValue(new Value(previousTx));
	}

	// Convenience function to set Code and value for previosTx
	public void setPreviousTx(NullFlavor previousTx) {
		this.setCode(PREVIOUS_TX);
		BL v = DatatypesFactory.eINSTANCE.createBL();
		org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor nf = org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor
				.get(previousTx.getCodeValue());
		v.setNullFlavor(nf);

		getMdht().getValues().clear();
		getMdht().getValues().add(v);
	}

	public void setValue(Value value) {
		getMdht().getValues().clear();
		getMdht().getValues().add(value.getValue());
	}
}
