/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/
package org.ehealth_connector.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.vocab.RoleClassRoot;

/**
 * The Class ParticipantRole. This element does not necessarily contain
 * information about a person, but also about an organization.
 */
public class ParticipantRole {

	/** The MDHT participant role object. */
	org.openhealthtools.mdht.uml.cda.ParticipantRole mParticipantRole;

	/**
	 * Instantiates a new participant role.
	 */
	public ParticipantRole() {
		mParticipantRole = CDAFactory.eINSTANCE.createParticipantRole();
	}

	/**
	 * Instantiates a new participant role.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public ParticipantRole(org.openhealthtools.mdht.uml.cda.ParticipantRole mdht) {
		this.mParticipantRole = mdht;
	}

	/**
	 * Adds the address.
	 *
	 * @param address
	 *            the address
	 */
	public void addAddress(Address address) {
		mParticipantRole.getAddrs().add(address.copyMdhtAdress());
	}

	/**
	 * Adds the id.
	 *
	 * @param id
	 *            the id
	 */
	public void addId(Identificator id) {
		mParticipantRole.getIds().add(id.getIi());
	}

	/**
	 * Copy.
	 *
	 * @return the org.openhealthtools.mdht.uml.cda. participant role
	 */
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

	/**
	 * Gets the class code.
	 *
	 * @return the class code
	 */
	public RoleClassRoot getClassCode() {
		return mParticipantRole.getClassCode();
	}

	/**
	 * Gets the id list.
	 *
	 * @return the id list
	 */
	public List<Identificator> getIdList() {
		return Util.convertIds(mParticipantRole.getIds());
	}

	/**
	 * Gets the mdht.
	 *
	 * @return the mdht
	 */
	public org.openhealthtools.mdht.uml.cda.ParticipantRole getMdht() {
		return this.mParticipantRole;
	}

	/**
	 * Gets the playing entity.
	 *
	 * @return the playing entity
	 */
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

	/**
	 * Sets the class code.
	 *
	 * @param classCode
	 *            the new class code
	 */
	public void setClassCode(RoleClassRoot classCode) {
		mParticipantRole.setClassCode(classCode);
	}

	/**
	 * Sets the playing entity.
	 *
	 * @param playingEntity
	 *            the new playing entity
	 */
	public void setPlayingEntity(PlayingEntity playingEntity) {
		mParticipantRole.setPlayingEntity(playingEntity.copyPlayingEntity());
	}

	/**
	 * <div class="en">Sets the telecoms.</div> <div class="de">Setzt
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param telecoms
	 *            <div class="en">the new telecoms</div> <div class="de">das
	 *            neue telecoms.</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void setTelecoms(Telecoms telecoms) {
		mParticipantRole.getTelecoms().addAll(EcoreUtil.copyAll(telecoms.getMdhtTelecoms()));
	}
}
