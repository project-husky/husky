package org.ehealth_connector.cda.ch.lab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Participant;
import org.ehealth_connector.common.Specimen;
import org.ehealth_connector.common.enums.StatusCode;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.cda.Participant2;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityClassRoot;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;
import org.openhealthtools.mdht.uml.hl7.vocab.RoleClassSpecimen;

public class LaboratoryIsolateOrganizer
		extends org.ehealth_connector.cda.ihe.lab.LaboratoryIsolateOrganizer {

	public LaboratoryIsolateOrganizer() {
		super();
		getMdht().setStatusCode(StatusCode.COMPLETED.getCS());
	}

	public LaboratoryIsolateOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer mdht) {
		super(mdht);
	}

	public void addLaboratory(Organization organization, Date time) {
		Participant p = Util.createParticipantFromOrganization(organization);
		p.setTime(time);
		this.addParticipant(p);
	}

	public void addLaboratoryBatteryOrganizer(LaboratoryBatteryOrganizer labBatteryOrganizer) {
		getMdht().addOrganizer(labBatteryOrganizer.getMdht());
	}

	public void addParticipant(Participant participant) {
		participant.setTypeCode(ParticipationType.RESP);
		getMdht().getParticipants().add(participant.copy());
	}

	public Organization getLaboratory() {
		for (final Participant2 p : getMdht().getParticipants()) {
			if (p.getTypeCode().equals(ParticipationType.RESP)) {
				return Util.createOrganizationFromParticipant(new Participant(p));
			}
		}
		return null;
	}

	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizers() {
		final List<LaboratoryBatteryOrganizer> nl = new ArrayList<LaboratoryBatteryOrganizer>();
		for (final Organizer mdht : getMdht().getOrganizers()) {
			final LaboratoryBatteryOrganizer eHC = new LaboratoryBatteryOrganizer(
					(org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) mdht);
			nl.add(eHC);
		}
		return nl;
	}

	public List<Participant> getParticipants() {
		final List<Participant> nl = new ArrayList<Participant>();
		for (final Participant2 mdht : getMdht().getParticipants()) {
			final Participant eHC = new Participant(mdht);
			nl.add(eHC);
		}
		return nl;
	}

	public Specimen getSpecimen() {
		if (getMdht().getSpecimens() != null && !getMdht().getSpecimens().isEmpty()) {
			return new Specimen(getMdht().getSpecimens().get(0));
		}
		return null;
	}

	public void setSpecimen(Specimen specimen) {
		getMdht().getSpecimens().clear();
		specimen.getMdht().setTypeCode(ParticipationType.PRD);
		specimen.getMdht().getSpecimenRole().setClassCode(RoleClassSpecimen.SPEC);
		specimen.getMdht().getSpecimenRole().getSpecimenPlayingEntity()
				.setClassCode(EntityClassRoot.MIC);
		getMdht().getSpecimens().add(specimen.getMdht());
	}
}
