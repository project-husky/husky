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

package org.projecthusky.common.model;

import org.projecthusky.common.basetypes.IdentificatorBaseType;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.NullFlavor;
import org.projecthusky.common.hl7cdar2.*;
import org.projecthusky.common.utils.time.DateTimes;

import java.util.*;

/**
 * A Person or Organization performing an action
 */
public class Performer {

    private final POCDMT000040Performer2 mPerfomer;
    private final POCDMT000040AssignedEntity mAsEntity;
    private POCDMT000040Person mPerson;

    /**
     * Instantiates a new performer.
     */
    public Performer() {
        mPerfomer = new POCDMT000040Performer2();
        mAsEntity = new POCDMT000040AssignedEntity();
        mPerson = new POCDMT000040Person();

        mAsEntity.setAssignedPerson(mPerson);
        mPerfomer.setAssignedEntity(mAsEntity);

        // add time
        setTimeValue(new Date());
    }

    /**
     * Instantiates a new performer.
     *
     * @param author the author to be used as performer.
     */
    public Performer(Author author) {
        this();
        addName(author.getName());
        for (org.projecthusky.common.model.Identificator id : author.getIds()) {
            mAsEntity.getId().add(id.getHl7CdaR2Ii());
        }

        // add time
        setTimeValue(author.getTimeAsDate());

        if (author.getOrganization() != null)
            setOrganization(author.getOrganization());
    }

    /**
     * Default constructor to instanciate the object
     *
     * @param name the name of the performer
     */
    public Performer(Name name) {
        this();
        addName(name);
    }

    /**
     * Erstellt einen neuen Perfomer (Dieser Konstruktor wird oft gebraucht für Gesundheitsfachpersonen
     *
     * @param name Name
     * @param gln  Global Location Number (GLN)
     */
    public Performer(Name name, String gln) {
        this(name);

        // Create and fill Person Name and GLN
        final var id = new II();
        id.setRoot(CodeSystems.GLN.getCodeSystemId());
        id.setExtension(gln);

        mAsEntity.getId().add(id);
    }

    /**
     * Erstellt ein husky-Performer Objekt mittels eines MDHT-Performer Objekts.
     *
     * @param performerMdht the MDHT Performer Object
     */
    public Performer(POCDMT000040Performer2 performerMdht) {
        mPerfomer = performerMdht;
        mAsEntity = performerMdht.getAssignedEntity();
        mPerson = performerMdht.getAssignedEntity().getAssignedPerson();
    }

    /**
     * Default constructor to instanciate the object
     *
     * @param organization the organization of the performer
     */
    public Performer(org.projecthusky.common.model.Organization organization) {
        mPerfomer = new POCDMT000040Performer2();
        mAsEntity = new POCDMT000040AssignedEntity();
        mPerfomer.setAssignedEntity(mAsEntity);

        // add time
        setTimeValue(new Date());

        setOrganization(organization);

        for (IdentificatorBaseType idBaseType : organization.getIdentificatorList()) {
            if (idBaseType != null) {
                mAsEntity.getId().add(new org.projecthusky.common.model.Identificator(idBaseType).getHl7CdaR2Ii());
            }
        }

    }

    /**
     * Instantiates a new performer.
     *
     * @param person the person to be used as performer.
     */
    public Performer(Person person) {
        this();
        addName(person.getName());
    }

    /**
     * Weist dem Autor eine Postadresse zu.
     *
     * @param address Die Postadresse des Autors
     */
    public void addAddress(Address address) {
        mAsEntity.getAddr().add(address.getHl7CdaR2Ad());
    }

    /**
     * Weist dem Autoren eine ID zu.
     *
     * @param identificator Kombination von eigentlicher ID und der OID der verwaltenden Domäne
     */
    public void addId(org.projecthusky.common.model.Identificator identificator) {
        mAsEntity.getId().add(identificator.getHl7CdaR2Ii());
    }

    /**
     * Adds the name.
     *
     * @param name name
     */
    public void addName(Name name) {
        mAsEntity.getAssignedPerson().getName().add(name.getHl7CdaR2Pn());
    }

    /**
     * Copy CDA R2 performer.
     *
     * @return the CDA R2 performer
     */
    public POCDMT000040Performer2 getHl7Cdar2Perfomer() {
        return mPerfomer;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public Address getAddress() {
        return new Address(mAsEntity.getAddr().get(0));
    }

    /**
     * Gets the addresses.
     *
     * @return the addresses
     */
    public List<Address> getAddresses() {
        final List<Address> al = new ArrayList<>();
        for (final AD mAddress : mAsEntity.getAddr()) {
            al.add(new Address(mAddress));
        }
        return al;
    }

    /**
     * Gets the complete name.
     *
     * @return the complete name
     */
    public String getCompleteName() {
        // Search for the performer name. If it isn´t there, try to use the
        // organisation name.
        var retVal = "";
        if ((mAsEntity != null) && (mAsEntity.getAssignedPerson() != null)) {
			if (!mAsEntity.getAssignedPerson().getName().isEmpty()) {
                final var name = new Name(mAsEntity.getAssignedPerson().getName().get(0));
                retVal = name.getFullName();
            } else {
                if ((mAsEntity.getRepresentedOrganization() != null)
						&& (!mAsEntity.getRepresentedOrganization().getName().isEmpty())) {
                    final var name = new Name(
                            mAsEntity.getRepresentedOrganization().getName().get(0));
                    retVal = name.getFullName();
                }
            }
        }
        return retVal;
    }

    /**
     * Gets the gln (identification of the performer)
     *
     * @return the gln
     */
    public String getGln() {
        for (II id : mAsEntity.getId()) {
            if (id != null && CodeSystems.GLN.getCodeSystemId().equalsIgnoreCase(id.getRoot())) {
                return id.getExtension();
            }
        }

        return null;
    }

    /**
     * Sets the gln.
     *
     * @param gln the new gln
     */
    public void setGln(String gln) {
        addId(new org.projecthusky.common.model.Identificator(CodeSystems.GLN.getCodeSystemId(), gln));
    }

    /**
     * Gets the gln as identificator.
     *
     * @return the gln as identificator
     */
    public org.projecthusky.common.model.Identificator getGlnAsIdentificator() {
        final var ii = mAsEntity.getId().get(0);
        return new org.projecthusky.common.model.Identificator(ii);
    }

    /**
     * Gets all ids of the performer
     *
     * @return the ids
     */
    public List<org.projecthusky.common.model.Identificator> getIds() {
		return Identificator.getIdentificatorList(mAsEntity.getId());
    }

    /**
     * Gets the (first) family name.
     *
     * @return the name
     */
    public Name getName() {
        return new Name(mAsEntity.getAssignedPerson().getName().get(0));
    }

    /**
     * Gets the names.
     *
     * @return the names
     */
    public List<Name> getNames() {
        final List<Name> nl = new ArrayList<>();
        for (final PN mName : mAsEntity.getAssignedPerson().getName()) {
            nl.add(new Name(mName));
        }
        return nl;
    }

    /**
     * Gets the organization (RepresentedOrganization)
     *
     * @return organization the organization
     */
    public Organization getOrganization() {
        return new Organization(mAsEntity.getRepresentedOrganization());
    }

    /**
     * Sets the organization (RepresentedOrganization)
     *
     * @param organization the new organization
     */
    public void setOrganization(org.projecthusky.common.model.Organization organization) {
        mAsEntity.setRepresentedOrganization(organization.getHl7CdaR2Pocdmt000040Organization());
    }

    /**
     * Gets the telecoms.
     *
     * @return Telecoms the telecoms
     */
    public List<Telecom> getTelecoms() {
        List<Telecom> telecoms = new LinkedList<>();

        for (TEL tel : mAsEntity.getTelecom()) {
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
    public void setTelecoms(List<TEL> telecoms) {
        mAsEntity.getTelecom().addAll(telecoms);
    }

    /**
     * Gets the performance time
     *
     * @return date the performance time
     */
    public IVLTS getTimeAsIVLTS() {
        return new IVLTS(Optional.ofNullable(mPerfomer.getTime()).map(IVLTS::getValue).orElse(null));
    }

    /**
     * Sets the Time Value
     *
     * @param eurDate the date
     */
    public void setTimeValue(Date eurDate) {
		if (eurDate == null) {
			mPerfomer.setTime(new IVLTS(NullFlavor.UNKNOWN_L1));
		} else {
			mPerfomer.setTime(new IVLTS(DateTimes.toHl7Dtm(eurDate.toInstant())));
		}
    }

}
