package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.List;

import org.ehealth_connector.cda.ch.lab.LaboratoryBatteryOrganizer;
import org.ehealth_connector.common.Participant;
import org.ehealth_connector.common.Specimen;
import org.ehealth_connector.common.enums.StatusCode;
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

	public void addLaboratoryBatteryOrganizer(LaboratoryBatteryOrganizer labBatteryOrganizer) {

	}

	public void addParticipant(Participant participant) {

	}

	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizers() {
		return null;

	}

	public List<Participant> getParticipants() {
		return null;

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
