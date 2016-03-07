package org.ehealth_connector.cda.ch.lab;

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

	public SoasInfoEntry() {
		super(CHFactory.eINSTANCE.createSoasInfoEntry().init(), "2.16.756.5.30.1.1.1.1.3.4.1",
				"CDA-CH.LRTP.SOASInfo");
	}

	/**
	 * Creates the SoasInfoEntry class with the required centerSpecificAvpid
	 * element. If you want to create a SoasInfoEntry with the required PreviousTx
	 * Element, please use the default constructor and the setPreviousTx method.
	 *
	 * @param centerSpecificAvoid
	 *          <div class="en">Center specific Avoid=true means that a
	 *          transplantation should not be performed, because of the
	 *          HLA-Antibody even if the MFI-value is in the acceptable
	 *          range.</div><div class="de"> Center specific Avoid=true
	 *          bedeutet,dass aufgrund des betreffende HLA-Antikörpers von einer
	 *          Transplantation abgesehen werden soll, auch wenn sein MFI-Wert
	 *          noch im akzeptablen Bereich liegt.</div>
	 */
	public SoasInfoEntry(boolean centerSpecificAvoid) {
		this();
		setCenterSpecificAvoid(centerSpecificAvoid);
	}

	public SoasInfoEntry(org.openhealthtools.mdht.uml.cda.ch.SoasInfoEntry mdht) {
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

	//
	/**
	 * <div class="en">Convenience function to set Code and value for
	 * centerSpecificAvoid</div>
	 *
	 * @param centerSpecificAvoid
	 *          <div class="en">Center specific Avoid=true means that a
	 *          transplantation should not be performed, because of the
	 *          HLA-Antibody even if the MFI-value is in the acceptable
	 *          range.</div><div class="de"> Center specific Avoid=true
	 *          bedeutet,dass aufgrund des betreffende HLA-Antikörpers von einer
	 *          Transplantation abgesehen werden soll, auch wenn sein MFI-Wert
	 *          noch im akzeptablen Bereich liegt.</div>
	 */
	public void setCenterSpecificAvoid(boolean centerSpecificAvoid) {
		this.setCode(CENTER_SPECIFIC_AVOID_CODE);
		this.setValue(new Value(centerSpecificAvoid));
	}

	public void setCode(Code code) {
		getMdht().setCode(code.getCD());
	}

	/**
	 * Convenience function to set Code and value for previosTx
	 *
	 * @param previousTx
	 *          <div class="en">Prev-Tx=true means that the HLA-antibody has been
	 *          build due to a former transplantation.</div>
	 *          <div class="de">Prev-Tx=true bedeutet, dass der betreffende
	 *          HLA-Antikörper aufgrund einer früheren Transplantation gebildet
	 *          wurde.</div>
	 */
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
