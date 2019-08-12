/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.cda.ch.lab;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.ehealth_connector.cda.enums.NullFlavor;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Value;
import org.ehealth_connector.common.mdht.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.ch.ChFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.BL;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * The Class SoasInfoEntry.
 */
public class SoasInfoEntry
		extends MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ch.SoasInfoEntry> {

	/** The Constant CENTER_SPECIFIC_AVOID_CODE. */
	public static final Code CENTER_SPECIFIC_AVOID_CODE = new Code("2.16.756.5.30.1.129.1.1.2",
			"001");

	/** The Constant PREVIOUS_TX. */
	public static final Code PREVIOUS_TX = new Code("2.16.756.5.30.1.129.1.1.2", "002");

	/**
	 * Instantiates a new soas info entry.
	 */
	public SoasInfoEntry() {
		super(ChFactory.eINSTANCE.createSoasInfoEntry().init(), "2.16.756.5.30.1.1.1.1.3.4.1",
				"CDA-CH.LRTP.SOASInfo");
		getMdht().setStatusCode(StatusCode.COMPLETED.getCS());
	}

	/**
	 * Creates the SoasInfoEntry class with the required centerSpecificAvpid
	 * element. If you want to create a SoasInfoEntry with the required
	 * PreviousTx Element, please use the default constructor and the
	 * setPreviousTx method.
	 *
	 * @param centerSpecificAvoid
	 *            <div class="en">Center specific Avoid=true means that a
	 *            transplantation should not be performed, because of the
	 *            HLA-Antibody even if the MFI-value is in the acceptable
	 *            range.</div><div class="de"> Center specific Avoid=true
	 *            bedeutet,dass aufgrund des betreffende HLA-Antikörpers von
	 *            einer Transplantation abgesehen werden soll, auch wenn sein
	 *            MFI-Wert noch im akzeptablen Bereich liegt.</div>
	 */
	public SoasInfoEntry(boolean centerSpecificAvoid) {
		this();
		setCenterSpecificAvoid(centerSpecificAvoid);
	}

	/**
	 * Instantiates a new soas info entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public SoasInfoEntry(org.openhealthtools.mdht.uml.cda.ch.SoasInfoEntry mdht) {
		super(mdht);
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Code getCode() {
		if (getMdht().getCode() != null) {
			return new Code(getMdht().getCode());
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.MdhtObservationFacade#getValue()
	 */
	@Override
	public Value getValue() {
		if ((getMdht().getValues() != null) && !getMdht().getValues().isEmpty()) {
			return new Value(getMdht().getValues().get(0));
		}
		return null;
	}

	/**
	 * Checks if is center specific avoid.
	 *
	 * @return true, if is center specific avoid
	 */
	// Convenience function to determine the kind of Soas Element
	public boolean isCenterSpecificAvoid() {
		return (CENTER_SPECIFIC_AVOID_CODE.equals(this.getCode()));
	}

	/**
	 * Checks if is previous tx.
	 *
	 * @return true, if is previous tx
	 */
	// Convenience function to determine the kind of Soas Element
	public boolean isPreviousTx() {
		return (PREVIOUS_TX.equals(this.getCode()));
	}

	//
	/**
	 * <div class="en">Convenience function to set Code and value for
	 * centerSpecificAvoid</div>.
	 *
	 * @param centerSpecificAvoid
	 *            <div class="en">Center specific Avoid=true means that a
	 *            transplantation should not be performed, because of the
	 *            HLA-Antibody even if the MFI-value is in the acceptable
	 *            range.</div><div class="de"> Center specific Avoid=true
	 *            bedeutet,dass aufgrund des betreffende HLA-Antikörpers von
	 *            einer Transplantation abgesehen werden soll, auch wenn sein
	 *            MFI-Wert noch im akzeptablen Bereich liegt.</div>
	 */
	public void setCenterSpecificAvoid(boolean centerSpecificAvoid) {
		this.setCode(CENTER_SPECIFIC_AVOID_CODE);
		this.setValue(new Value(centerSpecificAvoid));
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(Code code) {
		getMdht().setCode(code.getCD());
	}

	/**
	 * Convenience function to set Code and value for previosTx.
	 *
	 * @param previousTx
	 *            <div class="en">Prev-Tx=true means that the HLA-antibody has
	 *            been build due to a former transplantation.</div>
	 *            <div class="de">Prev-Tx=true bedeutet, dass der betreffende
	 *            HLA-Antikörper aufgrund einer früheren Transplantation
	 *            gebildet wurde.</div>
	 */
	public void setPreviousTx(boolean previousTx) {
		this.setCode(PREVIOUS_TX);
		getMdht().getValues().clear();
		this.setValue(new Value(previousTx));
	}

	/**
	 * Sets the previous tx.
	 *
	 * @param previousTx
	 *            the new previous tx
	 */
	// Convenience function to set Code and value for previosTx
	public void setPreviousTx(NullFlavor previousTx) {
		this.setCode(PREVIOUS_TX);
		final BL v = DatatypesFactory.eINSTANCE.createBL();
		final org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor nf = org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor
				.get(previousTx.getCodeValue());
		v.setNullFlavor(nf);

		getMdht().getValues().clear();
		getMdht().getValues().add(v);
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(Value value) {
		getMdht().getValues().clear();
		getMdht().getValues().add(value.getValue());
	}
}
