package org.ehealth_connector.cda.ihe.lab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.MdhtProcedureFacade;
import org.ehealth_connector.common.Participant;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection;

public class SpecimenCollectionEntry
		extends MdhtProcedureFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection> {

	Date effectiveTime;

	protected SpecimenCollectionEntry() {
		super(LABFactory.eINSTANCE.createSpecimenCollection().init());
	}

	protected SpecimenCollectionEntry(SpecimenCollection mdht) {
		super(mdht);
	}

	protected void addParticipant(Participant participant) {
		// getMdht().getParticipants().add(participant);
	}

	protected Date getEffectiveTime() {
		return effectiveTime;
	}

	protected List<Participant> getParticipants() {
		if (getMdht().getParticipants() != null) {
			List<Participant> participantsList;
			participantsList = new ArrayList<Participant>();
			return participantsList;
		}
		return null;
	}

	protected void setEffectiveTime(Date date) {

	}

}
