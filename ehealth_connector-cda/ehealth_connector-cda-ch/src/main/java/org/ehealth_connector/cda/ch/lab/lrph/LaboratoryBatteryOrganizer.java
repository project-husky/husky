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
package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.StatusCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;

/**
 * The Class LaboratoryBatteryOrganizer.
 *
 * <div class="en">The Laboratory Battery Organizer provides grouping of
 * results </div> <div class="de">Der Laboratory Battery Organizer erlaubt
 * gemäss IHE XD-LAB die Gruppierung von Resultaten.</div>
 */
public class LaboratoryBatteryOrganizer
		extends org.ehealth_connector.cda.ihe.lab.AbstractLaboratoryBatteryOrganizer {

	/**
	 * Instantiates a new laboratory battery organizer.
	 */
	public LaboratoryBatteryOrganizer() {
		super();
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
	 * Instantiates the class with the required elements.
	 *
	 * @param status
	 *            of the underlying observations (completed, aborted)
	 * @param observation
	 *            the observation
	 */
	public LaboratoryBatteryOrganizer(StatusCode status, LaboratoryObservation observation) {
		this();
		addLaboratoryObservation(observation);
	}

	/**
	 * Adds the id for HIV.
	 *
	 * @param id
	 *            the id root: OID of the used System e.g. Berda Code:
	 *            2.16.756.5.30.1.129.1.2.1. extension: anonyme number for each
	 *            consultation.
	 */
	public void addIdForHiv(Identificator id) {
		getMdht().getIds().add(id.getIi());
	}

	/**
	 * Adds the laboratory observation.
	 *
	 * @param observation
	 *            the observation
	 */
	public void addLaboratoryObservation(LaboratoryObservation observation) {
		getMdht().addObservation(observation.copy());

		final int nb = getMdht().getComponents().size() - 1;
		getMdht().getComponents().get(nb).setTypeCode(ActRelationshipHasComponent.COMP);
	}

	/**
	 * Gets the id for hiv list.
	 *
	 * @return the id for hiv list
	 */
	public List<Identificator> getIdForHivList() {
		return Util.convertIds(getMdht().getIds());
	}

	/**
	 * Gets the laboratory observations.
	 *
	 * @return the laboratory observations
	 */
	public List<LaboratoryObservation> getLaboratoryObservations() {
		final List<LaboratoryObservation> loList = new ArrayList<LaboratoryObservation>();
		for (final Observation o : getMdht().getObservations()) {
			if (o instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation) {
				loList.add(new LaboratoryObservation(
						(org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation) o));
			}
		}
		return loList;
	}
}
