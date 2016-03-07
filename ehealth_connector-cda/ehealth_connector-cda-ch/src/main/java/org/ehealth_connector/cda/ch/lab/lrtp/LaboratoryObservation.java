package org.ehealth_connector.cda.ch.lab.lrtp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.ch.lab.SoasInfoEntry;
import org.ehealth_connector.cda.ch.lab.lrtp.enums.LabObsList;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

public class LaboratoryObservation
		extends org.ehealth_connector.cda.ch.lab.AbstractLaboratoryObservation {

	public LaboratoryObservation() {
		super();
	}

	/**
	 * Instantiates the class with the required elements
	 *
	 * @param code
	 *          the code
	 * @param interpretationCode
	 *          the interpretation code
	 * @param effectiveTime
	 *          <div class="en">point in time of the result (physiological
	 *          relevant point in time). Precision: Date with hour and
	 *          minute</div> <div class="de">Zeitpunkt des Resultats
	 *          (physiologisch relevanter Zeitpunkt) Genauigkeit des Werts: Datum
	 *          und Tageszeit mit Stunde und Minute </div>
	 */
	public LaboratoryObservation(LabObsList code, ObservationInterpretation interpretationCode,
			Date effectiveTime) {
		this();
		setCode(code);
		setInterpretationCode(interpretationCode);
		setEffectiveTime(effectiveTime);
	}

	public LaboratoryObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation mdht) {
		super(mdht);
	}

	/**
	 * Convenience function to add the two required SoasInfoEntries.
	 *
	 * @param centerSpecificAvoid
	 *          <div class="en">Center specific Avoid=true means that a
	 *          transplantation should not be performed, because of the
	 *          HLA-Antibody even if the MFI-value is in the acceptable
	 *          range.</div><div class="de"> Center specific Avoid=true
	 *          bedeutet,dass aufgrund des betreffende HLA-Antikörpers von einer
	 *          Transplantation abgesehen werden soll, auch wenn sein MFI-Wert
	 *          noch im akzeptablen Bereich liegt.</div>
	 * @param previousTx
	 *          <div class="en">Prev-Tx=true means that the HLA-antibody has been
	 *          build due to a former transplantation.</div>
	 *          <div class="de">Prev-Tx=true bedeutet, dass der betreffende
	 *          HLA-Antikörper aufgrund einer früheren Transplantation gebildet
	 *          wurde.</div>
	 */
	public void addSoasInfoEnties(boolean centerSpecificAvoid, boolean previousTx) {
		SoasInfoEntry csa = new SoasInfoEntry(centerSpecificAvoid);
		SoasInfoEntry ptx = new SoasInfoEntry();
		ptx.setPreviousTx(previousTx);

		getMdht().addObservation(csa.copy());
		getMdht().addObservation(ptx.copy());
	}

	public void addSoasInfoEntry(SoasInfoEntry entry) {
		getMdht().addObservation(entry.copy());
	}

	//
	// private byte findSoasInfoEntryIndex(Code code) {
	// if (this.getSoasInfoEnties() != null &&
	// !this.getSoasInfoEnties().isEmpty()) {
	// // Check if this element is the CenterSpecificAvoid
	// // If so, replace with the new one
	// byte index = 0;
	// for (SoasInfoEntry entry : getSoasInfoEnties()) {
	// if (code.equals(entry.getCode())) {
	// return index;
	// }
	// index++;
	// }
	// }
	// return -1;
	// }

	public org.ehealth_connector.cda.ch.lab.lrtp.enums.LabObsList getCodeAsLoincEnum() {
		if (getMdht().getCode() != null && getMdht().getCode().getCode() != null) {
			return LabObsList.getEnum(getMdht().getCode().getCode());
		}
		return null;
	}

	// public boolean getSoasInfoCenterSpecificAvoid() {
	// // Problem: Was ist, wenn das Element nicht da ist? Bei einem boolean kann
	// // man kein null zurückgeben...
	// }

	public List<SoasInfoEntry> getSoasInfoEnties() {
		List<SoasInfoEntry> sl = new ArrayList<SoasInfoEntry>();
		for (Observation o : getMdht().getObservations()) {
			// We have to check the templateID, because MDHT does not recognize the
			// swiss extension
			for (II id : o.getTemplateIds()) {
				if (id.getRoot().equals("2.16.756.5.30.1.1.1.1.3.4.1")
						&& id.getExtension().equals("CDA-CH.LRTP.SOASInfo")) {
					sl.add(new SoasInfoEntry((org.openhealthtools.mdht.uml.cda.ch.SoasInfoEntry) o));
				}
			}
		}
		return sl;
	}

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
