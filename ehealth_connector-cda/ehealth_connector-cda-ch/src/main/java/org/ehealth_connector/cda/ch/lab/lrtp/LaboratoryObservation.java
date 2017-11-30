/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.cda.ch.lab.lrtp;

import org.ehealth_connector.cda.ch.lab.lrtp.enums.LabObsList;
import org.ehealth_connector.common.ReferenceRange;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * The Class LaboratoryObservation. <div class="en">Each laboratory result MUST
 * contain a code and the interpretation of the laboratory result. Depending on
 * the kind of result a value MAY be added.</div> <div class="de">Jedes
 * Laborresultat MUSS dabei aus einem Code und der Interpretation des
 * Messresultates bestehen. Je nach Art des Resultates KANN ein Wert angegeben
 * werden.</div>
 */
public class LaboratoryObservation
		extends org.ehealth_connector.cda.ch.lab.AbstractLaboratoryObservation {

	/**
	 * Instantiates a new laboratory observation.
	 */
	public LaboratoryObservation() {
		super();
	}

	/**
	 * Instantiates the class with the required elements.
	 *
	 * @param code
	 *            the code
	 * @param value
	 *            the value (with the value and (if applicable) ucumUnit, type).
	 *            If the value type is PQ or INT, you have to provide the
	 *            reference range for this value (either use setReferenceRange
	 *            or use the according constructor).
	 * @param interpretationCode
	 *            the interpretation code
	 */
	public LaboratoryObservation(LabObsList code, Value value,
			ObservationInterpretation interpretationCode) {
		this();
		setCode(code);
		addValue(value);
		addInterpretationCode(interpretationCode);
	}

	/**
	 * Instantiates the class with the required elements (including a
	 * referenceRange, if required because of value type PQ or INT).
	 *
	 * @param code
	 *            the code
	 * @param value
	 *            the value (with the value and (if applicable) ucumUnit, type).
	 * @param referenceRange
	 *            the reference Range (with Value(low, high) and
	 *            interpretationCode.
	 * @param interpretationCode
	 *            the interpretation code
	 */
	public LaboratoryObservation(LabObsList code, Value value, ReferenceRange referenceRange,
			ObservationInterpretation interpretationCode) {
		this();
		setCode(code);
		addValue(value);
		setReferenceRange(referenceRange);
		addInterpretationCode(interpretationCode);
	}

	/**
	 * Instantiates a new laboratory observation.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public LaboratoryObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation mdht) {
		super(mdht);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.ehealth_connector.cda.ihe.lab.LaboratoryObservation#
	 * addInterpretationCode(org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor)
	 */
	@Override
	public void addInterpretationCode(NullFlavor nullFlavor) {
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(nullFlavor);
		getMdht().getInterpretationCodes().add(ce);
	}

	/**
	 * Gets the code as loinc enum.
	 *
	 * @return the code as loinc enum
	 */
	public org.ehealth_connector.cda.ch.lab.lrtp.enums.LabObsList getCodeAsLoincEnum() {
		if (getMdht().getCode() != null && getMdht().getCode().getCode() != null) {
			return LabObsList.getEnum(getMdht().getCode().getCode());
		}
		return null;
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(org.ehealth_connector.cda.ch.lab.lrtp.enums.LabObsList code) {
		getMdht().setCode(code.getCD());
	}

	// Problem: What should be returned, if a nullflavor is used or if the
	// SoasElement does not exist?
	// // Convenience function: creates a SoasInfoEntry and sets the according
	// code
	// // and value
	// public void setSoasInfoCenterSpecificAvoid(boolean centerSpecificAvoid) {
	// SoasInfoEntry sie = new SoasInfoEntry();
	//
	// sie.setCode(CENTER_SPECIFIC_AVOID_CODE);
	// Value v = new Value(centerSpecificAvoid);
	// sie.setValue(v);
	//
	// byte index = findSoasInfoEntryIndex(CENTER_SPECIFIC_AVOID_CODE);
	//
	// if (index != -1) {
	// this.addSoasInfoEntry(sie);
	// } else {
	// this.getSoasInfoEnties().set(index, sie);
	// }
	// }
	//
	// public void setSoasInfoPreviousTx(boolean previousTx) {
	//
	// }
}
