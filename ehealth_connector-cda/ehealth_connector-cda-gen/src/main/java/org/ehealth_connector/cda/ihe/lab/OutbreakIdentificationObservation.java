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
package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

/**
 * The Class OutbreakIdentificationObservation. Outbreak Identification, when
 * present, SHALL be recorded as an observation under the Notification Organizer
 * as demonstrated. Outbreak Identification SHALL be present when dictated by
 * local outbreak identification reporting requirements.
 */
public class OutbreakIdentificationObservation extends
		MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.OutbreakIdentification> {

	/**
	 * Instantiates a new outbreak identification observation.
	 */
	public OutbreakIdentificationObservation() {
		super(LABFactory.eINSTANCE.createOutbreakIdentification().init());
	}

	/**
	 * Instantiates a new outbreak identification observation.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public OutbreakIdentificationObservation(
			org.openhealthtools.mdht.uml.cda.ihe.lab.OutbreakIdentification mdht) {
		super(mdht);
	}
}