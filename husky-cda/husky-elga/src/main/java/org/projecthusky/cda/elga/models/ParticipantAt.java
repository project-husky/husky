/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrOtherParticipantBodyTranscriber;
import org.projecthusky.common.hl7cdar2.II;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040Participant2;
import org.projecthusky.common.hl7cdar2.POCDMT000040ParticipantRole;
import org.projecthusky.common.hl7cdar2.POCDMT000040PlayingEntity;
import org.projecthusky.common.model.Address;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Name;
import org.projecthusky.common.model.Participant;
import org.projecthusky.common.model.Telecom;
import org.projecthusky.common.utils.time.DateTimes;

public class ParticipantAt extends Participant {

	private List<Identificator> ids;
	private Address addr;
	private List<Telecom> telecoms;
	private Name name;
	private Device device;

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public List<Telecom> getTelecoms() {
		return telecoms;
	}

	public void setTelecoms(List<Telecom> telecoms) {
		this.telecoms = telecoms;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public List<Identificator> getIds() {
		return ids;
	}

	public void setIds(List<Identificator> ids) {
		this.ids = ids;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}


	public AtcdabbrOtherParticipantBodyTranscriber getAtcdabbrOtherParticipantBodyTranscriber(
			ZonedDateTime recordTime) {
		AtcdabbrOtherParticipantBodyTranscriber participant = new AtcdabbrOtherParticipantBodyTranscriber();
		participant.setHl7Time(new IVLTS(DateTimes.toDatetimeTs(recordTime).getValue()));

		POCDMT000040ParticipantRole participantRole = participant.getHl7ParticipantRole();

		if (ids != null && !ids.isEmpty()) {
			participantRole.getId().addAll(getIi());
		}

		if (addr != null) {
			participantRole.getAddr().clear();
			participantRole.getAddr().add(this.addr.getHl7CdaR2Ad());
		}

		if (telecoms != null && !telecoms.isEmpty()) {
			for (Telecom tel : telecoms) {
				if (tel != null) {
					participantRole.getTelecom().add(tel.getHl7CdaR2Tel());
				}
			}
		}

		if (name != null) {
			POCDMT000040PlayingEntity playingEntity = new POCDMT000040PlayingEntity();
			playingEntity.getClassCode().add("ENT");
			playingEntity.setDeterminerCode("INSTANCE");
			playingEntity.getName().clear();
			playingEntity.getName().add(name.getHl7CdaR2Pn());
			participantRole.setPlayingEntity(playingEntity);
		}

		if (device != null) {
			participantRole.setPlayingDevice(device.getAtcdabbrOtherDeviceCompilation());
		}

		return participant;
	}

	public POCDMT000040Participant2 getPOCDMT000040Participant2(ZonedDateTime validatingTime) {
		POCDMT000040Participant2 particpant = new POCDMT000040Participant2();
		particpant.getTypeCode().add("AUTHEN");
		particpant.setContextControlCode("OP");

		particpant.getTemplateId().add(new Identificator("1.3.6.1.4.1.19376.1.3.3.1.5").getHl7CdaR2Ii());
		particpant.setTime(new IVLTS(DateTimes.toDatetimeTs(validatingTime).getValue()));

		particpant.setParticipantRole(getPOCDMT000040ParticipantRole());

		return particpant;
	}

	private POCDMT000040ParticipantRole getPOCDMT000040ParticipantRole() {
		POCDMT000040ParticipantRole participantRole = new POCDMT000040ParticipantRole();
		participantRole.getClassCode().add("ROL");

		if (this.ids != null && !this.ids.isEmpty()) {
			participantRole.getId().clear();
			participantRole.getId().addAll(getIi());
		}

		if (this.addr != null) {
			participantRole.getAddr().add(this.addr.getHl7CdaR2Ad());
		}

		if (this.telecoms != null && !this.telecoms.isEmpty()) {
			for (Telecom tel : this.telecoms) {
				if (tel != null) {
					participantRole.getTelecom().add(tel.getHl7CdaR2Tel());
				}
			}
		}

		participantRole.setPlayingEntity(getPOCDMT000040POCDMT000040PlayingEntity());

		return participantRole;
	}

	private POCDMT000040PlayingEntity getPOCDMT000040POCDMT000040PlayingEntity() {
		POCDMT000040PlayingEntity entity = new POCDMT000040PlayingEntity();
		entity.getClassCode().add("ENT");
		entity.setDeterminerCode("INSTANCE");

		if (this.name != null) {
			entity.getName().add(this.name.getHl7CdaR2Pn());
		}

		return entity;
	}

	private List<II> getIi() {
		List<II> iis = new LinkedList<>();
		for (Identificator id : ids) {
			if (id != null) {
				iis.add(id.getHl7CdaR2Ii());
			} else {
				II unkId = new II();
				unkId.nullFlavor = new ArrayList<>();
				unkId.nullFlavor.add("UNK");
				iis.add(unkId);
			}
		}

		return iis;
	}

}
