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
package org.ehealth_connector.cda.ihe.lab;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

/**
 * The Class LaboratoryBatteryOrganizer. A Laboratory Battery Organizer is used
 * to group Laboratory Observations for a battery of tests.
 */
public class LaboratoryBatteryOrganizer extends AbstractLaboratoryBatteryOrganizer {

	/**
	 * Instantiates a new laboratory battery organizer.
	 */
	public LaboratoryBatteryOrganizer() {
		super(LABFactory.eINSTANCE.createLaboratoryBatteryOrganizer().init());
		setStatusCode(StatusCode.COMPLETED);
	}

	/**
	 * Instantiates a new laboratory battery organizer.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public LaboratoryBatteryOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer mdht) {
		super(mdht);
	}

	/**
	 * Adds the laboratory observation.
	 *
	 * @param observation
	 *            the observation
	 */
	public void addLaboratoryObservation(LaboratoryObservation observation) {
		getMdht().addObservation(observation.copy());
	}

	/**
	 * Gets the laboratory observations.
	 *
	 * @return the laboratory observations
	 */
	public List<LaboratoryObservation> getLaboratoryObservations() {
		final List<LaboratoryObservation> ol = new ArrayList<LaboratoryObservation>();
		for (final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation o : getMdht()
				.getLaboratoryObservations()) {
			ol.add(new LaboratoryObservation(o));
		}
		return ol;
	}

}
