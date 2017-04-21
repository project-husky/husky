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
package org.ehealth_connector.cda.ch.lab.lrqc;

import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.lab.lrqc.enums.LabObsList;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * The Class LaboratoryObservation. <div class="en">Each Laboratory result MUST
 * contain a code, value and the interpretation of the result.</div>
 * <div class="de">Jedes Laborresultat MUSS aus einem Code, Wert und der
 * Interpretation des Messresultates bestehen.</div>
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
	 *            the value
	 * @param interpretationCode
	 *            the interpretation code
	 * @param textReference
	 *            Reference to the human readable text
	 * @param reference
	 *            <div class="en">reference to the human readable text,
	 *            regarding the lot number of the anylizer kit</div>
	 *            <div class="de">Dieses Element ermöglicht zu jedem Entry einen
	 *            Kommentar anzugeben. Bei Laborbefunden für die
	 *            Qualitätskontrolle MUSS darin deklariert werden, wie die Probe
	 *            analysiert worden ist. Wenn dazu ein Analyzer verwendet worden
	 *            ist, soll dies folgendermassen deklariert werden (Freitext):
	 *            Test-Hersteller [R]: Name des Unternehmens, Test-Gerät [R]:
	 *            Name und Typ des Gerätes, Test-Kit [R2]: Genaue Bezeichnung
	 *            des Kits</div>
	 */
	public LaboratoryObservation(LabObsList code, Value value,
			ObservationInterpretation interpretationCode, String textReference,
			SectionAnnotationCommentEntry reference) {
		this();
		setCode(code);
		addValue(value);
		addInterpretationCode(interpretationCode);
		setTextReference(textReference);
		addCommentEntry(reference);
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

	/**
	 * Adds the interpretation code.
	 *
	 * @param code
	 *            the new interpretation code
	 */
	@Override
	public void addInterpretationCode(ObservationInterpretation code) {
		if (code != null) {
			getMdht().getInterpretationCodes().add(code.getCE());
		} else {
			final CE ce = DatatypesFactory.eINSTANCE.createCE();
			ce.setNullFlavor(NullFlavor.NA);
			getMdht().getInterpretationCodes().add(ce);
		}
	}

	/**
	 * Gets the code as enum.
	 *
	 * @return the code as enum
	 */
	public org.ehealth_connector.cda.ch.lab.lrqc.enums.LabObsList getCodeAsEnum() {
		if ((getMdht().getCode() != null) && (getMdht().getCode().getCode() != null)) {
			return org.ehealth_connector.cda.ch.lab.lrqc.enums.LabObsList
					.getEnum(getMdht().getCode().getCode());
		}
		return null;
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(org.ehealth_connector.cda.ch.lab.lrqc.enums.LabObsList code) {
		getMdht().setCode(code.getCD());
	}
}
