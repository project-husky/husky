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
package org.ehealth_connector.cda.ch.lab.lrtp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.BaseObservation;
import org.ehealth_connector.cda.BaseObservationComparator;
import org.ehealth_connector.cda.ihe.lab.BaseLaboratoryBatteryOrganizer;
import org.ehealth_connector.common.Author;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;

/**
 * The Class LaboratoryBatteryOrganizer.
 *
 * <div class="en">The Laboratory Battery Organizer provides grouping of results
 * </div> <div class="de">Der Laboratory Battery Organizer erlaubt gemäss IHE
 * XD-LAB die Gruppierung von Resultaten.</div>
 */
public class LaboratoryBatteryOrganizer extends BaseLaboratoryBatteryOrganizer {

	/**
	 * This class implements the default comparison algorithm for HL7 CDA
	 * observations.
	 */
	private class LaboratoryObservationComparator implements Comparator<LaboratoryObservation> {

		/**
		 *
		 * Compares two observations on their narrative text.
		 *
		 * {@inheritDoc}
		 *
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(LaboratoryObservation a, LaboratoryObservation b) {
			if ((a == null) && (b == null))
				return 0;
			else if ((a == null) && (b != null))
				return -1;
			else if ((a != null) && (b == null))
				return 1;
			else {
				if ((a.getNarrativeText() == null) && (b.getNarrativeText() == null))
					return 0;
				else if ((a.getNarrativeText() == null) && (b.getNarrativeText() != null))
					return -1;
				else if ((a.getNarrativeText() != null) && (b.getNarrativeText() == null))
					return 1;
				else
					return a.getNarrativeText().compareToIgnoreCase(b.getNarrativeText());
			}
		}
	}

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
	 * Gets the authors.
	 *
	 * @return the authors
	 */
	public List<Author> getAuthors() {
		final List<Author> al = new ArrayList<Author>();
		for (final org.openhealthtools.mdht.uml.cda.Author mdht : getMdht().getAuthors()) {
			final Author ehc = new Author(mdht);
			al.add(ehc);
		}
		return al;
	}

	/**
	 * Gets the laboratory observations.
	 *
	 * @return the laboratory observations
	 */
	@Override
	public List<BaseObservation> getLaboratoryObservations() {
		final List<BaseObservation> loList = new ArrayList<BaseObservation>();
		for (final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation lo : getMdht()
				.getLaboratoryObservations()) {
			loList.add(new BaseObservation(lo));
		}
		loList.sort(new BaseObservationComparator());
		return loList;
	}

	/**
	 * Gets the laboratory observations.
	 *
	 * @return the laboratory observations
	 */
	public List<LaboratoryObservation> getLrtpLaboratoryObservations() {
		final List<LaboratoryObservation> loList = new ArrayList<LaboratoryObservation>();
		for (final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation lo : getMdht()
				.getLaboratoryObservations()) {
			loList.add(new LaboratoryObservation(lo));
		}
		loList.sort(new LaboratoryObservationComparator());
		return loList;
	}
}
