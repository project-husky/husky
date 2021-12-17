/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.common.model;

import org.husky.common.hl7cdar2.AD;
import org.husky.common.hl7cdar2.POCDMT000040ParticipantRole;
import org.husky.common.hl7cdar2.POCDMT000040PlayingEntity;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.utils.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The Class ParticipantRole. This element does not necessarily contain information about a person, but also about an
 * organization.
 */
public class ParticipantRole {

    /**
     * The participant role object.
     */
    private POCDMT000040ParticipantRole mParticipantRole;

    /**
     * Instantiates a new participant role.
     */
    public ParticipantRole() {
        mParticipantRole = new POCDMT000040ParticipantRole();
    }

    /**
     * Instantiates a new participant role.
     *
     * @param mdht the mdht
     */
    public ParticipantRole(POCDMT000040ParticipantRole mdht) {
        this.mParticipantRole = mdht;
    }

    /**
     * Adds the address.
     *
     * @param address the address
     */
    public void addAddress(Address address) {
        mParticipantRole.getAddr().add(address.getHl7CdaR2Ad());
    }

    /**
     * Adds the id.
     *
     * @param id the id
     */
    public void addId(Identificator id) {
        mParticipantRole.getId().add(id.getHl7CdaR2Ii());
    }

    /**
     * Gets the addresses.
     *
     * @return the addresses
     */
    public List<Address> getAddresses() {
        final List<Address> al = new ArrayList<>();
        for (final AD mAddress : mParticipantRole.getAddr()) {
            al.add(new Address(mAddress));
        }
        return al;
    }

    /**
     * Gets the class code.
     *
     * @return the class code
     */
    public List<String> getClassCode() {
        return mParticipantRole.getClassCode();
    }

    /**
     * Sets the class code.
     *
     * @param classCode the new class code
     */
    public void setClassCode(String classCode) {
        mParticipantRole.getClassCode().clear();
        mParticipantRole.getClassCode().add(classCode);
    }

    /**
     * Gets the id list.
     *
     * @return the id list
     */
    public List<Identificator> getIdList() {
        return Util.convertIds(mParticipantRole.getId());
    }

    /**
     * Gets the mdht.
     *
     * @return the mdht
     */
    public POCDMT000040ParticipantRole getMdht() {
        return this.mParticipantRole;
    }

    /**
     * Gets the playing entity.
     *
     * @return the playing entity
     */
    public POCDMT000040PlayingEntity getPlayingEntity() {
        return mParticipantRole.getPlayingEntity();
    }

    /**
     * Sets the playing entity.
     *
     * @param playingEntity the new playing entity
     */
    public void setPlayingEntity(PlayingEntity playingEntity) {
        mParticipantRole.setPlayingEntity(playingEntity.getPlayingEntity());
    }

    /**
     * Gets the telecoms.
     *
     * @return Telecoms the telecoms
     */
    public List<Telecom> getTelecoms() {
        List<Telecom> telecoms = new LinkedList<>();

        for (TEL tel : mParticipantRole.getTelecom()) {
            if (tel != null) {
                telecoms.add(new Telecom(tel));
            }
        }

        return telecoms;
    }

    /**
     * Sets the telecoms.
     *
     * @param telecoms the new telecoms
     */
    public void setTelecoms(List<Telecom> telecoms) {
        for (Telecom telecom : telecoms) {
            if (telecom != null) {
                mParticipantRole.getTelecom().add(telecom.getHl7CdaR2Tel());
            }
        }
    }
}
