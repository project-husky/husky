/*
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
package org.ehealth_connector.cda.ihe.lab;

import java.util.Date;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Value;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public class PreviousLaboratoryObservation extends
		MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation> {

	/**
	 * Instantiates a new laboratory observation.
	 */
	public PreviousLaboratoryObservation() {
		super(LABFactory.eINSTANCE.createLaboratoryObservation().init());
		getMdht().getInterpretationCodes().clear();
	}

	public PreviousLaboratoryObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation currentObservation,
			Date timestamp, Value value, Code interpretationCode) {
		super(currentObservation);
		setEffectiveTime(timestamp);
		getMdht().getValues().clear();
		addValue(value);
		getMdht().getInterpretationCodes().clear();
		addInterpretationCode(interpretationCode);
	}

}
