package org.ehealth_connector.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.vocab.RoleClassRoot;

public class ParticipantRole {
	org.openhealthtools.mdht.uml.cda.ParticipantRole mParticipantRole;

	public ParticipantRole() {
		mParticipantRole = CDAFactory.eINSTANCE.createParticipantRole();
	}

	public ParticipantRole(org.openhealthtools.mdht.uml.cda.ParticipantRole mdht) {
		this.mParticipantRole = mdht;
	}

	public void addAddress(Address address) {
		mParticipantRole.getAddrs().add(address.copyMdhtAdress());
	}

	public void addId(Identificator id) {
		mParticipantRole.getIds().add(id.getIi());
	}

	public org.openhealthtools.mdht.uml.cda.ParticipantRole copy() {
		return EcoreUtil.copy(mParticipantRole);
	}

	/**
	 * <div class="en">Gets the addresses.</div> <div class="de">Liefert alle
	 * Adressen.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the addresses</div>
	 */
	public List<Address> getAddresses() {
		final List<Address> al = new ArrayList<Address>();
		for (final AD mAddress : mParticipantRole.getAddrs()) {
			final Address address = new Address(mAddress);
			al.add(address);
		}
		return al;
	}

	public RoleClassRoot getClassCode() {
		return mParticipantRole.getClassCode();
	}

	public List<Identificator> getIdList() {
		return Util.convertIds(mParticipantRole.getIds());
	}

	public org.openhealthtools.mdht.uml.cda.ParticipantRole getMdht() {
		return this.mParticipantRole;
	}

	public PlayingEntity getPlayingEntity() {
		return new PlayingEntity(mParticipantRole.getPlayingEntity());
	}

	/**
	 * <div class="en">Gets the telecoms.</div> <div class="de">Liefert
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Telecoms <div class="en">the telecoms</div>
	 */
	public Telecoms getTelecoms() {
		return new Telecoms(mParticipantRole.getTelecoms());
	}

	public void setClassCode(RoleClassRoot classCode) {
		mParticipantRole.setClassCode(classCode);
	}

	public void setPlayingEntity(PlayingEntity playingEntity) {
		mParticipantRole.setPlayingEntity(playingEntity.copyPlayingEntity());
	}

	/**
	 * <div class="en">Sets the telecoms.</div> <div class="de">Setzt
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param telecoms
	 *          <div class="en">the new telecoms</div> <div class="de">das neue
	 *          telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 */
	public void setTelecoms(Telecoms telecoms) {
		mParticipantRole.getTelecoms().addAll(EcoreUtil.copyAll(telecoms.getMdhtTelecoms()));
	}
}
