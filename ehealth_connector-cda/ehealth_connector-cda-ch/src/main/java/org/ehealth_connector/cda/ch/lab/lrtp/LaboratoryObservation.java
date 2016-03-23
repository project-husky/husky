/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch.lab.lrtp;

import org.ehealth_connector.cda.ch.lab.lrtp.enums.LabObsList;
import org.ehealth_connector.common.ReferenceRange;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.ObservationInterpretation;

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

	// /**
	// * Convenience function to add the two required SoasInfoEntries.
	// *
	// * @param centerSpecificAvoid
	// * <div class="en">Center specific Avoid=true means that a
	// * transplantation should not be performed, because of the
	// * HLA-Antibody even if the MFI-value is in the acceptable
	// * range.</div><div class="de"> Center specific Avoid=true
	// * bedeutet,dass aufgrund des betreffende HLA-Antikörpers von einer
	// * Transplantation abgesehen werden soll, auch wenn sein MFI-Wert
	// * noch im akzeptablen Bereich liegt.</div>
	// * @param previousTx
	// * <div class="en">Prev-Tx=true means that the HLA-antibody has been
	// * build due to a former transplantation.</div>
	// * <div class="de">Prev-Tx=true bedeutet, dass der betreffende
	// * HLA-Antikörper aufgrund einer früheren Transplantation gebildet
	// * wurde.</div>
	// */
	// public void addSoasInfoEnties(boolean centerSpecificAvoid, boolean
	// previousTx) {
	// SoasInfoEntry csa = new SoasInfoEntry(centerSpecificAvoid);
	// SoasInfoEntry ptx = new SoasInfoEntry();
	// ptx.setPreviousTx(previousTx);
	//
	// addSoasInfoEntry(csa);
	// addSoasInfoEntry(ptx);
	// }

	// public void addSoasInfoEntry(SoasInfoEntry entry) {
	// getMdht().addObservation(entry.copy());
	// CdaUtil.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
	// x_ActRelationshipEntryRelationship.COMP);
	// }

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

	// public List<SoasInfoEntry> getSoasInfoEnties() {
	// List<SoasInfoEntry> sl = new ArrayList<SoasInfoEntry>();
	// for (Observation o : getMdht().getObservations()) {
	// // We have to check the templateID, because MDHT does not recognize the
	// // swiss extension
	// for (II id : o.getTemplateIds()) {
	// if (id.getRoot().equals("2.16.756.5.30.1.1.1.1.3.4.1")
	// && id.getExtension().equals("CDA-CH.LRTP.SOASInfo")) {
	// sl.add(new
	// SoasInfoEntry((org.openhealthtools.mdht.uml.cda.ch.SoasInfoEntry) o));
	// }
	// }
	// }
	// return sl;
	// }

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
