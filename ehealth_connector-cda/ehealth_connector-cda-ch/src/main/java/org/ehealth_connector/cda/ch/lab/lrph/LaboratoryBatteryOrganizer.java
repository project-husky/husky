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
package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.BaseObservation;
import org.ehealth_connector.common.mdht.Author;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.enums.StatusCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;

/**
 * The Class LaboratoryBatteryOrganizer.
 *
 * <div class="en">The Laboratory Battery Organizer provides grouping of results
 * </div> <div class="de">Der Laboratory Battery Organizer erlaubt gemäss IHE
 * XD-LAB die Gruppierung von Resultaten.</div>
 */
public class LaboratoryBatteryOrganizer
		extends org.ehealth_connector.cda.ihe.lab.BaseLaboratoryBatteryOrganizer {

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
	 * Adds the author.
	 *
	 * @param author
	 *            the author
	 */
	public void addAuthor(Author author) {
		getMdht().getAuthors().add(author.copyMdhtAuthor());
		final int nb = getMdht().getAuthors().size() - 1;
		getMdht().getAuthors().get(nb).setTypeCode(ParticipationType.AUT);
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
	@Override
	public List<BaseObservation> getLaboratoryObservations() {
		final List<BaseObservation> loList = new ArrayList<BaseObservation>();
		for (final Observation o : getMdht().getObservations()) {
			if (o instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation) {
				loList.add(new BaseObservation(o));
			}
		}
		return loList;
	}

	/**
	 * Gets the laboratory observations.
	 *
	 * @return the laboratory observations
	 */
	public List<LaboratoryObservation> getLrphLaboratoryObservations() {
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
