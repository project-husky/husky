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

import org.ehealth_connector.cda.AbstractObservation;
import org.ehealth_connector.cda.MdhtOrganizerFacade;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

/**
 * The Class AbstractLaboratoryBatteryOrganizer.
 */
public class AbstractLaboratoryBatteryOrganizer extends
		MdhtOrganizerFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer> {

	String humanInformation;

	/**
	 * Instantiates a new abstract laboratory battery organizer.
	 */
	public AbstractLaboratoryBatteryOrganizer() {
		super(LABFactory.eINSTANCE.createLaboratoryBatteryOrganizer().init());
		setStatusCode(StatusCode.COMPLETED);
	}

	/**
	 * Instantiates a new abstract laboratory battery organizer.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public AbstractLaboratoryBatteryOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer mdht) {
		super(mdht);
	}

	/**
	 * Adds the id for HIV.
	 *
	 * @param id
	 *            the id root: OID of the used System e.g. Berda Code:
	 *            2.16.756.5.30.1.129.1.2.1. extension: anonyme number for each
	 *            consultation.
	 */
	public void addId(Identificator id) {
		getMdht().getIds().add(id.getIi());
	}

	/**
	 * Gets the laboratory observations.
	 *
	 * @return the laboratory observations
	 */
	public List<AbstractObservation> getLaboratoryObservations() {
		final List<AbstractObservation> loList = new ArrayList<AbstractObservation>();
		for (final Observation o : getMdht().getObservations()) {
			if (o instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation) {
				loList.add(new AbstractObservation(o));
			}
		}
		return loList;
	}
}
