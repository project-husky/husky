package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.ch.lab.LaboratoryBatteryOrganizer;
import org.ehealth_connector.common.Participant;
import org.ehealth_connector.common.Specimen;

public class LaboratoryIsolateOrganizer
		extends org.ehealth_connector.cda.ihe.lab.LaboratoryIsolateOrganizer {

	public LaboratoryIsolateOrganizer(
			org.ehealth_connector.cda.ihe.lab.LaboratoryIsolateOrganizer iheLabIsolateOrganizer) {
		super(iheLabIsolateOrganizer.getMdht());
	}

	public void addLaboratoryBatteryOrganizer(LaboratoryBatteryOrganizer labBatteryOrganizer) {

	}

	public void addParticipant(Participant participant) {

	}

	public void addSubject(Specimen specimen) {

	}

	public Date getEffectiveTime() {
		return null;

	}

	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizers() {
		return null;

	}

	public List<Participant> getParticipants() {
		return null;

	}

	public Specimen getSubject() {
		return null;
	}

	public void setEffectiveTime(Date date) {

	}
}
