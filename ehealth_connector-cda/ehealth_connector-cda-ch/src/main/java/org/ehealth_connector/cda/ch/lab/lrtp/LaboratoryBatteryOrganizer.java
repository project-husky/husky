package org.ehealth_connector.cda.ch.lab.lrtp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.ihe.lab.AbstractLaboratoryBatteryOrganizer;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;

public class LaboratoryBatteryOrganizer extends AbstractLaboratoryBatteryOrganizer {
	public LaboratoryBatteryOrganizer() {
		super();
	}

	/**
	 * Instantiates the class with the required elements
	 *
	 * @param observation
	 *          the observation
	 * @param effectiveTime
	 *          <div class="en">the point in time of the measurement. If unknown,
	 *          effectiveTime has to be declared with nullFlavor.</div>
	 *          <div class="de">Zeitpunkt der Messung. Ist dieser unbekannt, MUSS
	 *          effectiveTime mit nullFlavor angegeben werden. nullFlavor ist nur
	 *          erlaubt, wenn der Organizer ausschliesslich Körpergrösse oder
	 *          Gewicht enthält. Wenn der Organizer mindestens eine andere
	 *          Beobachtung enthält, muss ein Wert angegeben werden.</div>
	 *
	 */
	public LaboratoryBatteryOrganizer(LaboratoryObservation observation, Date effectiveTime) {
		this();
		addLaboratoryObservation(observation);
		setEffectiveTime(effectiveTime);
	}

	public LaboratoryBatteryOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer mdht) {
		super(mdht);
	}

	public void addLaboratoryObservation(LaboratoryObservation observation) {
		getMdht().addObservation(observation.copy());

		final int nb = getMdht().getComponents().size() - 1;
		getMdht().getComponents().get(nb).setTypeCode(ActRelationshipHasComponent.COMP);

	}

	public List<LaboratoryObservation> getLaboratoryObservations() {
		List<LaboratoryObservation> loList = new ArrayList<LaboratoryObservation>();
		for (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation lo : getMdht()
				.getLaboratoryObservations()) {
			loList.add(new LaboratoryObservation(lo));
		}
		return loList;
	}
}
