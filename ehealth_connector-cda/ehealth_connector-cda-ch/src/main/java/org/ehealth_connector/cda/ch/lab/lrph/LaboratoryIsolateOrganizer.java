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
package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Participant;
import org.ehealth_connector.common.Specimen;
import org.ehealth_connector.common.enums.StatusCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.cda.Participant2;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityClassRoot;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;
import org.openhealthtools.mdht.uml.hl7.vocab.RoleClassSpecimen;

/**
 * The Class LaboratoryIsolateOrganizer.
 *
 * <div class="en">This element contains additional information about isolates
 * and germs.</div> <div class="de">Über dieses Element können zusätzliche
 * Informationen zu Isolaten und Keimen angegeben werden.</div>
 */
public class LaboratoryIsolateOrganizer
		extends org.ehealth_connector.cda.ihe.lab.LaboratoryIsolateOrganizer {

	/**
	 * Instantiates a new laboratory isolate organizer.
	 */
	public LaboratoryIsolateOrganizer() {
		super();
		getMdht().setStatusCode(StatusCode.COMPLETED.getCS());
	}

	/**
	 * Instantiates a new laboratory isolate organizer.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public LaboratoryIsolateOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer mdht) {
		super(mdht);
	}

	/**
	 * Instantiates a new laboratory isolate organizer.
	 *
	 * @param specimen
	 *            the specimen
	 */
	public LaboratoryIsolateOrganizer(Specimen specimen) {
		this();
		setSpecimen(specimen);
	}

	/**
	 *
	 * Creates a new Laboratory Isolate Organizer. One specimen element
	 * (specimen, specimenRole, and specimenPlayingEntity) will be created with
	 * the given reference.
	 *
	 * @param reference
	 *            the reference will be set into
	 *            specimen/specimenRole/specimenPlayingEntity/originalText/
	 *            reference
	 */
	public LaboratoryIsolateOrganizer(String reference) {
		this();
		final Code code = new Code();
		code.setOriginalTextReference(reference);
		final Specimen specimen = new Specimen();
		specimen.setCode(code);
		setSpecimen(specimen);
	}

	/**
	 * Adds the laboratory.
	 *
	 * @param organization
	 *            the organization
	 * @param time
	 *            the time
	 */
	public void addLaboratory(Organization organization, Date time) {
		final Participant p = Util.createParticipantFromOrganization(organization);
		p.setTime(time);
		this.addParticipant(p);
	}

	/**
	 * Adds the laboratory battery organizer.
	 *
	 * @param labBatteryOrganizer
	 *            the lab battery organizer
	 */
	public void addLaboratoryBatteryOrganizer(LaboratoryBatteryOrganizer labBatteryOrganizer) {
		getMdht().addOrganizer(labBatteryOrganizer.getMdht());
		final int nb = getMdht().getComponents().size() - 1;
		getMdht().getComponents().get(nb).setTypeCode(ActRelationshipHasComponent.COMP);
	}

	/**
	 *
	 * <div class="en">Distinction of cases: laboratory result from a primary
	 * laboatory: [O] secundary laboratory: [NP]. time: Point in time of
	 * forwarding to the secundary laboratory. id: GLN of the secundary
	 * laboatory. </div> <div class="de">Fallunterscheidung: Laborbefund aus
	 * Primärlabor: [O] Sekundärlabor: [NP]. time: Zeitpunkt der Weiterleitung
	 * des Isolats/Keimes an das Sekundärlabor. id: GLN des Sekundärlabors resp.
	 * Referenzzentrums (root='2.51.1.3'). addr, telecom, playingEntity/name:
	 * Name, Adresse und Kommunikations-mittel des Sekundärlabors resp.
	 * Referenzzentrums </div>
	 *
	 * @param participant
	 *            the participant with the values mentioned above
	 */
	public void addParticipant(Participant participant) {
		participant.setTypeCode(ParticipationType.RESP);
		getMdht().getParticipants().add(participant.copy());
	}

	/**
	 * Gets the laboratory.
	 *
	 * @return the laboratory
	 */
	public Organization getLaboratory() {
		for (final Participant2 p : getMdht().getParticipants()) {
			if (p.getTypeCode().equals(ParticipationType.RESP)) {
				return Util.createOrganizationFromParticipant(new Participant(p));
			}
		}
		return null;
	}

	/**
	 * Gets the laboratory battery organizers.
	 *
	 * @return the laboratory battery organizers
	 */
	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizers() {
		final List<LaboratoryBatteryOrganizer> nl = new ArrayList<LaboratoryBatteryOrganizer>();
		for (final Organizer mdht : getMdht().getOrganizers()) {
			final LaboratoryBatteryOrganizer eHC = new LaboratoryBatteryOrganizer(
					(org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) mdht);
			nl.add(eHC);
		}
		return nl;
	}

	/**
	 * Gets the participants.
	 *
	 * @return the participants
	 */
	public List<Participant> getParticipants() {
		final List<Participant> nl = new ArrayList<Participant>();
		for (final Participant2 mdht : getMdht().getParticipants()) {
			final Participant eHC = new Participant(mdht);
			nl.add(eHC);
		}
		return nl;
	}

	/**
	 * Gets the specimen.
	 *
	 * @return the specimen
	 */
	public Specimen getSpecimen() {
		if ((getMdht().getSpecimens() != null) && !getMdht().getSpecimens().isEmpty()) {
			return new Specimen(getMdht().getSpecimens().get(0));
		}
		return null;
	}

	/**
	 * Sets the specimen.
	 *
	 * @param specimen
	 *            the new specimen
	 */
	public void setSpecimen(Specimen specimen) {
		getMdht().getSpecimens().clear();
		specimen.getMdht().setTypeCode(ParticipationType.SPC);
		specimen.getMdht().getSpecimenRole().setClassCode(RoleClassSpecimen.SPEC);
		specimen.getMdht().getSpecimenRole().getSpecimenPlayingEntity()
				.setClassCode(EntityClassRoot.MIC);
		getMdht().getSpecimens().add(specimen.getMdht());
	}
}
