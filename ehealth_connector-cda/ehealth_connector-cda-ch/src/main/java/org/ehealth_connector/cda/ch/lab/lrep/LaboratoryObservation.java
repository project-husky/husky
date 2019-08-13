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
package org.ehealth_connector.cda.ch.lab.lrep;

import org.ehealth_connector.cda.utils.CdaUtilMdht;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.enums.ObservationInterpretation;
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
		CdaUtilMdht.addTemplateIdOnce(getMdht(), new Identificator("2.16.756.5.30.1.1.10.4.3"));
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
		CdaUtilMdht.addTemplateIdOnce(getMdht(), new Identificator("2.16.756.5.30.1.1.10.4.3"));
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
	 * Adds the previous observation.
	 *
	 * @param prevObs
	 *            the prev obs
	 */
	public void addPreviousObservation(PreviousObservation prevObs) {
		super.addPreviousObservation(new LaboratoryObservation(prevObs.getMdht()));
	}
}
