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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.ihe.lab.AbstractLaboratoryBatteryOrganizer;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;

/**
 * The Class LaboratoryBatteryOrganizer.
 *
 * <div class="en">The Laboratory Battery Organizer provides grouping of
 * results </div> <div class="de">Der Laboratory Battery Organizer erlaubt
 * gemäss IHE XD-LAB die Gruppierung von Resultaten.</div>
 */
public class LaboratoryBatteryOrganizer extends AbstractLaboratoryBatteryOrganizer {

	/**
	 * Instantiates a new laboratory battery organizer.
	 */
	public LaboratoryBatteryOrganizer() {
		super();
	}

	/**
	 * Instantiates the class with the required elements.
	 *
	 * @param effectiveTime
	 *            <div class="en">the point in time of the measurement. If
	 *            unknown, effectiveTime has to be declared with
	 *            nullFlavor.</div> <div class="de">Zeitpunkt der Messung. Ist
	 *            dieser unbekannt, MUSS effectiveTime mit nullFlavor angegeben
	 *            werden. nullFlavor ist nur erlaubt, wenn der Organizer
	 *            ausschliesslich Körpergrösse oder Gewicht enthält. Wenn der
	 *            Organizer mindestens eine andere Beobachtung enthält, muss ein
	 *            Wert angegeben werden.</div>
	 * @param observation
	 *            the observation
	 */
	public LaboratoryBatteryOrganizer(Date effectiveTime, LaboratoryObservation observation) {
		this();
		addLaboratoryObservation(observation);
		setEffectiveTime(effectiveTime);
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

		final int nb = getMdht().getComponents().size() - 1;
		getMdht().getComponents().get(nb).setTypeCode(ActRelationshipHasComponent.COMP);

	}

	/**
	 * Gets the laboratory observations.
	 *
	 * @return the laboratory observations
	 */
	public List<LaboratoryObservation> getLaboratoryObservations() {
		List<LaboratoryObservation> loList = new ArrayList<LaboratoryObservation>();
		for (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation lo : getMdht()
				.getLaboratoryObservations()) {
			loList.add(new LaboratoryObservation(lo));
		}
		return loList;
	}
}
