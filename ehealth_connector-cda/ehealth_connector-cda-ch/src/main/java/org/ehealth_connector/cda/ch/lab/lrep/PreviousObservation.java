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

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.Value;

/**
 * The derived PreviousObservation.This is just to fix the Swiss templpateIds.
 */
public class PreviousObservation
		extends org.ehealth_connector.cda.ihe.lab.PreviousLaboratoryObservation {

	/**
	 * Instantiates a new previous observation.
	 */
	public PreviousObservation() {
		super();
		CdaUtil.addTemplateIdOnce(getMdht(), new Identificator("2.16.756.5.30.1.1.10.4.22"));
		CdaUtil.removeTemplateId(getMdht(), new Identificator("2.16.756.5.30.1.1.10.4.3"));
	}

	/**
	 * Instantiates a new previous observation.
	 *
	 * @param currentObservation
	 *            the current observation
	 * @param timestamp
	 *            the timestamp
	 * @param value
	 *            the value
	 * @param interpretationCode
	 *            the interpretation code
	 */
	public PreviousObservation(LaboratoryObservation currentObservation, Date timestamp,
			Value value, Code interpretationCode) {
		super(EcoreUtil.copy(currentObservation.getMdht()), timestamp, value, interpretationCode);
		CdaUtil.addTemplateIdOnce(getMdht(), new Identificator("2.16.756.5.30.1.1.10.4.22"));
		CdaUtil.removeTemplateId(getMdht(), new Identificator("2.16.756.5.30.1.1.10.4.3"));
	}
}
