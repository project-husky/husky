/*
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
package org.ehealth_connector.cda;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.mdht.Address;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.Name;
import org.ehealth_connector.common.mdht.Organization;
import org.ehealth_connector.common.mdht.Patient;
import org.ehealth_connector.common.mdht.Person;
import org.ehealth_connector.common.mdht.Telecoms;
import org.ehealth_connector.common.utils.DateUtilMdht;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;
import org.openhealthtools.mdht.uml.hl7.datatypes.TS;

/**
 * The Class DataEnterer.
 */
public class DataEnterer {
	private org.openhealthtools.mdht.uml.cda.DataEnterer mDataEnterer;

	public DataEnterer() {
		org.openhealthtools.mdht.uml.cda.AssignedEntity asEntity = CDAFactory.eINSTANCE
				.createAssignedEntity();
		org.openhealthtools.mdht.uml.cda.Person person = CDAFactory.eINSTANCE.createPerson();
		mDataEnterer = CDAFactory.eINSTANCE.createDataEnterer();

		mDataEnterer.setAssignedEntity(asEntity);
		asEntity.setAssignedPerson(person);

		setTime(null);
	}

	/**
	 * Creates a null flavored DataEnterer
	 *
	 * @param nullFlavored
	 *            True
	 */
	public DataEnterer(boolean nullFlavored) {

		org.openhealthtools.mdht.uml.cda.AssignedEntity asEntity = CDAFactory.eINSTANCE
				.createAssignedEntity();
		org.openhealthtools.mdht.uml.cda.Person person = null;

		mDataEnterer = CDAFactory.eINSTANCE.createDataEnterer();
		asEntity.setAssignedPerson(person);
		mDataEnterer.setAssignedEntity(asEntity);

		mDataEnterer.setNullFlavor(org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor.NA);
		mDataEnterer.getAssignedEntity()
				.setNullFlavor(org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor.NA);
		final II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setNullFlavor(org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor.NA);
		mDataEnterer.getAssignedEntity().getIds().add(ii);
		final TS tsTime = DatatypesFactory.eINSTANCE.createTS();
		tsTime.setNullFlavor(org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor.NA);
		mDataEnterer.setTime(tsTime);
	}

	/**
	 * Instantiates a new human DataEnterer.
	 *
	 * @param name
	 *            the name
	 */
	public DataEnterer(Name name) {
		this();
		addName(name);
	}

	/**
	 * Erstellt ein eHealthconnector-DataEnterer Objekt mittels eines
	 * MDHT-DataEnterer Objekts.
	 *
	 * @param mdht
	 *            the MDHT DataEnterer Object
	 */
	public DataEnterer(org.openhealthtools.mdht.uml.cda.DataEnterer mdht) {
		mDataEnterer = mdht;
	}

	/**
	 * <div class="en"> Creates a new DataEnterer based on the given
	 * Organization object</div> <div class="de"> Erstellt einen neuen
	 * DataEnterer der der übergebenen Organisation entspricht.</div>
	 *
	 * @param organization
	 *            <div class="en"> this Organization is used as
	 *            DataEnterer</div> <div class="de"> diese Organisation wird als
	 *            DataEnterer verwendet</div>
	 */
	public DataEnterer(Organization organization) {
		mDataEnterer = CDAFactory.eINSTANCE.createDataEnterer();
		if (organization.getMdhtOrganization() != null) {
			org.openhealthtools.mdht.uml.cda.AssignedEntity asEntity = Util
					.createAssignedEntityFromOrganization(organization);
			mDataEnterer.setAssignedEntity(asEntity);
		}
		setTime(null);
	}

	/**
	 * <div class="en"> Creates a new DataEnterer based on the given Patient
	 * object</div> <div class="de"> Erstellt einen neuen DataEnterer der dem
	 * übergebenden Patienten entspricht.</div>
	 *
	 * @param patientAsDataEnterer
	 *            <div class="en"> this Patient is used as DataEnterer</div>
	 *            <div class="de"> dieser Patient wird als DataEnterer
	 *            verwendet</div> <div class="fr"></div>
	 */
	public DataEnterer(Patient patientAsDataEnterer) {
		this();
		org.openhealthtools.mdht.uml.cda.Person person = CDAFactory.eINSTANCE.createPerson();

		if (patientAsDataEnterer.getMdhtPerson() != null) {
			person = patientAsDataEnterer.copyMdhtPerson();
			mDataEnterer.getAssignedEntity().setAssignedPerson(person);
		}

		if (patientAsDataEnterer.getMdhtPatient().getNames() != null) {
			for (final Name name : patientAsDataEnterer.getNames()) {
				person.getNames().add(name.copyMdhtPn());
			}
		}

		if ((patientAsDataEnterer.getIds() != null) && (patientAsDataEnterer.getIds().size() > 0)) {
			mDataEnterer.getAssignedEntity().getIds()
					.addAll(patientAsDataEnterer.copyMdhtPatientRole().getIds());
		}
	}

	public DataEnterer(Person person) {
		this();
		setAssignedEntity(person);
	}

	/**
	 * Weist dem DataEnterer eine Postadresse zu.
	 *
	 * @param address
	 *            Die Postadresse des DataEnterers
	 */
	public void addAddress(Address address) {
		mDataEnterer.getAssignedEntity().getAddrs().add(address.copyMdhtAdress());
	}

	public void addAssignedEntityId(Identificator identificator) {
		mDataEnterer.getAssignedEntity().getIds().add(identificator.getIi());
	}

	/**
	 * Weist dem DataEntereren eine ID zu.
	 *
	 * @param identificator
	 *            Kombination von eigentlicher ID und der OID der verwaltenden
	 *            Domäne
	 */
	public void addId(Identificator identificator) {
		mDataEnterer.getAssignedEntity().getIds().add(identificator.getIi());
	}

	/**
	 * <div class="en">Adds the name.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param name
	 *            name
	 */
	public void addName(Name name) {
		mDataEnterer.getAssignedEntity().getAssignedPerson().getNames().add(name.getMdhtPn());
	}

	/**
	 * <div class="en">Copy mdht DataEnterer.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return org.openhealthtools.mdht.uml.cda.DataEnterer
	 */
	public org.openhealthtools.mdht.uml.cda.DataEnterer copyMdhtDataEnterer() {
		return EcoreUtil.copy(mDataEnterer);
	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see java.lang.Object#equals(java.lang.Object)
	// */
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// final DataEnterer other = (DataEnterer) obj;
	// if (getMdht().getAssignedEntity() == null) {
	// if (other.getMdht().getAssignedEntity() != null)
	// return false;
	// } else if
	// (!getMdht().getAssignedEntity().equals(other.getMdht().getAssignedEntity()))
	// return false;
	// if (mDataEnterer == null) {
	// if (other.mDataEnterer != null)
	// return false;
	// } else if (!mDataEnterer.equals(other.mDataEnterer))
	// return false;
	// if (person == null) {
	// if (other.person != null)
	// return false;
	// } else if (!person.equals(other.person))
	// return false;
	// return true;
	// }

	/**
	 * <div class="en">Gets the address.</div> <div class="de">Liefert die
	 * (erste) Adresse.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the address</div>
	 */
	public Address getAddress() {
		final Address address = new Address(mDataEnterer.getAssignedEntity().getAddrs().get(0));
		return address;
	}

	/**
	 * <div class="en">Gets the addresses.</div> <div class="de">Liefert alle
	 * Adressen.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the addresses</div>
	 */
	public List<Address> getAddresses() {
		final List<Address> al = new ArrayList<Address>();
		for (final AD mAddress : mDataEnterer.getAssignedEntity().getAddrs()) {
			final Address address = new Address(mAddress);
			al.add(address);
		}
		return al;
	}

	/**
	 * Method to get
	 *
	 * @return the asDataEnterer
	 */
	public org.openhealthtools.mdht.uml.cda.AssignedEntity getAsDataEnterer() {
		return mDataEnterer.getAssignedEntity();
	}

	public List<Identificator> getAssignedEntityIds() {
		org.openhealthtools.mdht.uml.cda.AssignedEntity asEntity = mDataEnterer.getAssignedEntity();
		ArrayList<Identificator> retVal = new ArrayList<Identificator>();
		if (asEntity.getIds() != null) {
			for (II id : asEntity.getIds()) {
				retVal.add(new Identificator(id));
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the complete name.</div> <div class="de">Liefert den
	 * ganzen Namen (z.B. "Dr. Allzeit Bereit der Dritte")</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the complete name</div>
	 */
	public String getCompleteName() {
		String retVal = "";
		// Search for the DataEnterer name. If it isn´t there, try to use the
		// organisation name.
		if (mDataEnterer.getAssignedEntity() != null) {
			if (mDataEnterer.getAssignedEntity().getAssignedPerson() != null) {
				if (!mDataEnterer.getAssignedEntity().getAssignedPerson().getNames().isEmpty()) {
					final Name name = new Name(
							mDataEnterer.getAssignedEntity().getAssignedPerson().getNames().get(0));
					retVal = name.getCompleteName();
				}
			}
		}
		// If the DataEnterer has no name, try the represented organization
		if (retVal.equals("")) {
			if (mDataEnterer.getAssignedEntity() != null) {
				if (mDataEnterer.getAssignedEntity().getRepresentedOrganizations() != null) {
					if (mDataEnterer.getAssignedEntity().getRepresentedOrganizations().size() > 0) {
						if (!mDataEnterer.getAssignedEntity().getRepresentedOrganizations().get(0)
								.getNames().isEmpty()) {
							final Name name = new Name(mDataEnterer.getAssignedEntity()
									.getRepresentedOrganizations().get(0).getNames().get(0));
							retVal = name.getCompleteName();
						}
					}
				}
			}
		}
		return retVal;

	}

	/**
	 * <div class="en">Gets the DataEnterer mdht.</div> <div class="de">Liefert
	 * DataEnterer mdht.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return org.openhealthtools.mdht.uml.cda.DataEnterer <div class="en">the
	 *         DataEnterer mdht</div>
	 */
	public org.openhealthtools.mdht.uml.cda.DataEnterer getDataEntererMdht() {
		return EcoreUtil.copy(mDataEnterer);
	}

	/**
	 * <div class="en">Gets the gln (identification of the DataEnterer)</div>
	 * <div class="de">Liefert die GLN (ID des DataEnterers)</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the gln</div>
	 */
	public String getGln() {
		if (!mDataEnterer.getAssignedEntity().getIds().isEmpty()) {
			final Identificator gln = Identificator.getIdentificator(
					mDataEnterer.getAssignedEntity().getIds(), CodeSystems.GLN.getCodeSystemId());
			return gln.getExtension();
		}
		return null;
	}

	/**
	 * <div class="en">Gets the gln as identificator.</div>
	 * <div class="de">Liefert gln (ID des DataEntereren) als Identificator
	 * Objekt.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the gln as identificator</div>
	 */
	public Identificator getGlnAsIdentificator() {
		if (!mDataEnterer.getAssignedEntity().getIds().isEmpty()) {
			final II ii = mDataEnterer.getAssignedEntity().getIds().get(0);
			final Identificator id = new Identificator(ii);
			return id;
		}
		return null;
	}

	/**
	 * <div class="en">Gets all ids of the DataEnterer</div>
	 * <div class="de">Liefert alle IDs des DataEntereren</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the ids</div>
	 */
	public List<Identificator> getIds() {
		return Util.convertIds(mDataEnterer.getAssignedEntity().getIds());
	}

	public org.openhealthtools.mdht.uml.cda.DataEnterer getMdht() {
		return mDataEnterer;
	}

	/**
	 * <div class="en">Gets the (first) family name.</div>
	 * <div class="de">Liefert den (ersten) Nachnamen</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the name</div>
	 */
	public Name getName() {
		final Name name = new Name(
				mDataEnterer.getAssignedEntity().getAssignedPerson().getNames().get(0));
		return name;
	}

	/**
	 * <div class="en">Gets the names.</div> <div class="de">Liefert alle
	 * Namen</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the names</div>
	 */
	public List<Name> getNames() {
		final List<Name> nl = new ArrayList<Name>();
		for (final PN mName : mDataEnterer.getAssignedEntity().getAssignedPerson().getNames()) {
			final Name name = new Name(mName);
			nl.add(name);
		}
		return nl;
	}

	/**
	 * <div class="en">Gets the organization (RepresentedOrganization). This
	 * element can also be used as DataEnterer represented organization, when a
	 * document is beeing sent (via XDS, XDM, XDR).</div>
	 * <div class="de">Liefert die Organisation (RepresentedOrganization), der
	 * der DataEnterer angehört (z.B. ein Krankenhaus). Dieses Element kann auch
	 * als DataEnterer Represented Organization Attribut verwendet werden, wenn
	 * das Dokument per XDS, XDM oder XDR verschickt wird.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @return organization <div class="en">the organization</div>
	 *         <div class="de">die Organisation</div> <div class="fr"></div>
	 *         <div class="it"></div>
	 */
	public Organization getOrganization() {
		final Organization o = null;
		if (mDataEnterer.getAssignedEntity().getRepresentedOrganizations() != null) {
			if (mDataEnterer.getAssignedEntity().getRepresentedOrganizations().size() > 0) {
				new Organization(
						mDataEnterer.getAssignedEntity().getRepresentedOrganizations().get(0));
			}
		}
		return o;
	}

	/**
	 * Method to get
	 *
	 * @return the person
	 */
	public org.openhealthtools.mdht.uml.cda.Person getPerson() {
		return mDataEnterer.getAssignedEntity().getAssignedPerson();
	}

	/**
	 * Sets the DataEnterer speciality code. This element specifies the
	 * speciality ("Fachrichtung", e.g. "Fachärztin/Facharzt für Allgemeine
	 * Innere Medizin" ) of the DataEnterer. The code can also be used as
	 * DataEnterer speciality, when a document is beeing sent (via XDS, XDM,
	 * XDR).
	 *
	 * @return code the speciality code
	 */
	public Code getSpeciality() {
		return new Code(mDataEnterer.getAssignedEntity().getCode());
	}

	/**
	 * <div class="en">Gets the telecoms.</div> <div class="de">Liefert
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Telecoms <div class="en">the telecoms</div>
	 */
	public Telecoms getTelecoms() {
		return new Telecoms(mDataEnterer.getAssignedEntity().getTelecoms());
	}

	/**
	 * <div class="en">Gets the DataEnterer time. The DataEnterer/time element
	 * represents the start time of the DataEnterer’s participation in the
	 * creation of the clinical document </div> <div class="de">Liefert die Zeit
	 * für den DataEnterer. Diese gibt den Startzeitpunkt an, an dem der
	 * DataEnterer bei der Erstellung des Dokument mitgewirkt hat.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @return date <div class="en">the start time of the participation as
	 *         string</div> <div class="de">den Startzeitpunkt der Partizipation
	 *         als String</div> <div class="fr"></div> <div class="it"></div>
	 */
	public Date getTimeAsDate() {
		if (mDataEnterer.getTime() != null) {
			return DateUtilMdht.parseDates(mDataEnterer.getTime().getValue());
		}
		return null;
	}

	/**
	 * <div class="en">Gets the DataEnterer time. The DataEnterer/time element
	 * represents the start time of the DataEnterer’s participation in the
	 * creation of the clinical document </div> <div class="de">Liefert die Zeit
	 * für den DataEnterer. Diese gibt den Startzeitpunkt an, an dem der
	 * DataEnterer bei der Erstellung des Dokument mitgewirkt hat.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @return date <div class="en">the start time of the participation as
	 *         string</div> <div class="de">den Startzeitpunkt der Partizipation
	 *         als String</div> <div class="fr"></div> <div class="it"></div>
	 */
	public IVL_TS getTimeAsIVL_TS() {
		IVL_TS retVal = null;
		if (mDataEnterer.getTime() != null) {
			try {
				retVal = DateUtilMdht.createIVL_TSFromHL7Date(mDataEnterer.getTime().getValue());
			} catch (final ParseException e) {
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the DataEnterer time. The DataEnterer/time element
	 * represents the start time of the DataEnterer’s participation in the
	 * creation of the clinical document </div> <div class="de">Liefert die Zeit
	 * für den DataEnterer. Diese gibt den Startzeitpunkt an, an dem der
	 * DataEnterer bei der Erstellung des Dokument mitgewirkt hat.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @return date <div class="en">the start time of the participation as
	 *         string</div> <div class="de">den Startzeitpunkt der Partizipation
	 *         als String</div> <div class="fr"></div> <div class="it"></div>
	 */
	public String getTimeAsString() {
		if (mDataEnterer.getTime() != null) {
			return DateUtilMdht.parseDateToStr(mDataEnterer.getTime());
		}
		return null;
	}

	/**
	 * Method to set
	 *
	 * @param asDataEnterer
	 *            the asDataEnterer to set
	 */
	public void setAsDataEnterer(org.openhealthtools.mdht.uml.cda.AssignedEntity asDataEnterer) {
		mDataEnterer.setAssignedEntity(asDataEnterer);
	}

	private void setAssignedEntity(Person person) {
		mDataEnterer.getAssignedEntity().setAssignedPerson(person.copyMdhtPerson());
	}

	public void setAssignedEntityId(Identificator identificator) {
		mDataEnterer.getAssignedEntity().getIds().clear();
		mDataEnterer.getAssignedEntity().getIds().add(identificator.getIi());

	}

	/**
	 * <div class="en">Sets the gln.</div> <div class="de">Setzt die GLN (ID des
	 * DataEntereren).</div> <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @param gln
	 *            <div class="en">the new gln. If null an Id with nullFlavor =
	 *            NA will be added.</div> <div class="de">Die neue gln. Bei null
	 *            wird eine Id mit dem NullFlavor = NA hinzugefügt.</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public void setGln(String gln) {
		if (gln != null) {
			addId(new Identificator(CodeSystems.GLN.getCodeSystemId(), gln));
		} else {
			final II ii = DatatypesFactory.eINSTANCE.createII();
			ii.setNullFlavor(org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor.NA);
			mDataEnterer.getAssignedEntity().getIds().add(ii);
		}
	}

	/**
	 * Method to set
	 *
	 * @param DataEnterer
	 *            the DataEnterer to set
	 */
	public void setMdht(org.openhealthtools.mdht.uml.cda.DataEnterer DataEnterer) {
		mDataEnterer = DataEnterer;
	}

	/**
	 * <div class="en">Sets the organization (RepresentedOrganization). The code
	 * can also be used as DataEnterer role, when a document is beeing sent (via
	 * XDS, XDM, XDR).</div> <div class="de">Setzt eine Organisation
	 * (RepresentedOrganization), der der DataEnterer angehört (z.B. ein
	 * Krankenhaus). Dieses Element kann auch als DataEnterer Represented
	 * Organization Attribut verwendet werden, wenn das Dokument per XDS, XDM
	 * oder XDR verschickt wird.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 *
	 * @param organization
	 *            <div class="en">the new organization</div> <div class="de">die
	 *            neue Organisation</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void setOrganization(Organization organization) {
		if (organization != null) {
			mDataEnterer.getAssignedEntity().getRepresentedOrganizations().clear();
			mDataEnterer.getAssignedEntity().getRepresentedOrganizations()
					.add(organization.copyMdhtOrganization());
		}
	}

	/**
	 * Sets the DataEnterer speciality code. This element specifies the
	 * speciality ("Fachrichtung", e.g. Code "50001" for "Fachärztin/Facharzt
	 * für Allgemeine Innere Medizin") of the DataEnterer. The code can also be
	 * used as DataEnterer speciality, when a document is beeing sent (via XDS,
	 * XDM, XDR).
	 *
	 * @param code
	 *            the speciality code
	 */
	public void setSpeciality(Code code) {
		mDataEnterer.getAssignedEntity().setCode(code.getCE());
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
		mDataEnterer.getAssignedEntity().getTelecoms()
				.addAll(EcoreUtil.copyAll(telecoms.getMdhtTelecoms()));
	}

	/**
	 * <div class="en">Sets the DataEnterer time. The DataEnterer/time element
	 * represents the start time of the DataEnterer’s participation in the
	 * creation of the clinical document </div> <div class="de">Setzt die Zeit
	 * für den DataEnterer. Diese gibt den Startzeitpunkt an, an dem der
	 * DataEnterer bei der Erstellung des Dokument mitgewirkt hat.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @param date
	 *            <div class="en">the start time of the participation as
	 *            date</div> <div class="de">den Startzeitpunkt der
	 *            Partizipation als Date</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void setTime(Date date) {
		if (date != null) {
			mDataEnterer.setTime(DateUtilMdht.convertDateToTsyyyyMMddHHmmssZZZZ(date));
		} else {
			mDataEnterer.setTime(DateUtilMdht.convertDateToTsyyyyMMddHHmmssZZZZ(new Date()));
		}
	}

}
