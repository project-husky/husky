/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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

package org.ehealth_connector.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.NullFlavor;
import org.ehealth_connector.common.hl7cdar2.AD;
import org.ehealth_connector.common.hl7cdar2.CE;
import org.ehealth_connector.common.hl7cdar2.ED;
import org.ehealth_connector.common.hl7cdar2.II;
import org.ehealth_connector.common.hl7cdar2.IVLTS;
import org.ehealth_connector.common.hl7cdar2.PN;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedAuthor;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Author;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040AuthoringDevice;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Person;
import org.ehealth_connector.common.hl7cdar2.TEL;
import org.ehealth_connector.common.hl7cdar2.TS;
import org.ehealth_connector.common.mdht.enums.Isco08;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;

/**
 * Author
 */
public class Author {

	public static final Code FUNCTION_CODE_AUTHOR_PATIENT = new Code(NullFlavor.NOT_APPLICABLE);
	public static final Code FUNCTION_CODE_AUTHORDEVICE = new Code("TASST", "2.16.756.5.30.2.1.1.1", null);

	private POCDMT000040Author mAuthor;

	/**
	 * Instantiates a new author.
	 */
	public Author() {
		mAuthor = new POCDMT000040Author();
		var asAuthor = new POCDMT000040AssignedAuthor();
		var person = new POCDMT000040Person();

		asAuthor.setAssignedPerson(person);
		mAuthor.setAssignedAuthor(asAuthor);

		// add functionCode and time
		mAuthor.setFunctionCode(Isco08.MEDICAL_DOCTORS.getCE());
		mAuthor.setTime(DateUtil.date2TsTzon(getTimeAsDate()));

		setTime(null);
	}

	/**
	 * Instantiates a new software author (e.g. a laboratory information system)
	 *
	 * @param device the device
	 */
	public Author(POCDMT000040AuthoringDevice device) {
		this();
		setAssignedAuthoringDevice(device);
	}

	/**
	 * Creates a null flavored author according to ELGA spec (necessary for PHARM
	 * DIS)
	 *
	 * @param nullFlavored True
	 */
	public Author(boolean nullFlavored) {

		/*
		 * ELGA spec:
		 *
		 * <author nullFlavor="NA"> <time nullFlavor="NA"/> <assignedAuthor
		 * nullFlavor="NA"> <id nullFlavor="NA"/> </assignedAuthor> </author>
		 */

		mAuthor = new POCDMT000040Author();
		var asAuthor = new POCDMT000040AssignedAuthor();
		var person = new POCDMT000040Person();

		asAuthor.setAssignedPerson(person);
		mAuthor.setAssignedAuthor(asAuthor);

		mAuthor.getNullFlavor().add(org.ehealth_connector.common.enums.NullFlavor.NOT_APPLICABLE_CODE);
		mAuthor.getAssignedAuthor().getNullFlavor()
				.add(org.ehealth_connector.common.enums.NullFlavor.NOT_APPLICABLE_CODE);
		final var ii = new II();
		ii.getNullFlavor().add(org.ehealth_connector.common.enums.NullFlavor.NOT_APPLICABLE_CODE);
		mAuthor.getAssignedAuthor().getId().add(ii);
		final var tsTime = new TS();
		tsTime.getNullFlavor().add(org.ehealth_connector.common.enums.NullFlavor.NOT_APPLICABLE_CODE);
		mAuthor.setTime(tsTime);
	}

	/**
	 * Instantiates a new author.
	 */
	public Author(Code functionCode) {
		mAuthor = new POCDMT000040Author();
		var asAuthor = new POCDMT000040AssignedAuthor();
		var person = new POCDMT000040Person();

		asAuthor.setAssignedPerson(person);
		mAuthor.setAssignedAuthor(asAuthor);

		// add functionCode and time
		if (functionCode != null) {
			mAuthor.setFunctionCode(functionCode.getHl7CdaR2Ce());
		}
		mAuthor.setTime(DateUtil.date2TsTzon(DateUtil.nowAsDate()));

		setTime(null);
	}

	/**
	 * Instantiates a new human author.
	 *
	 * @param name the name
	 */
	public Author(Name name) {
		this();
		addName(name);
	}

	/**
	 * Instantiates a new author.
	 *
	 * @param name Name
	 * @param gln  Global Location Number (GLN)
	 */
	public Author(Name name, String gln) {
		this(name);

		// Create and fill Person Name and GLN
		final var id = new II();
		id.setRoot(CodeSystems.GLN.getCodeSystemId());
		id.setExtension(gln);

		mAuthor.getAssignedAuthor().getId().add(id);
	}

	/**
	 * Erstellt ein eHealthconnector-Author Objekt mittels eines MDHT-Author
	 * Objekts.
	 *
	 * @param authorMdht the MDHT Author Object
	 */
	public Author(POCDMT000040Author authorMdht) {
		mAuthor = authorMdht;
	}

	/**
	 * <div class="en"> Creates a new Author based on the given Organization
	 * object</div> <div class="de"> Erstellt einen neuen Autor der der übergebenen
	 * Organisation entspricht.</div>
	 *
	 * @param organizationAsAuthor <div class="en"> this Organization is used as
	 *                             Author</div> <div class="de"> diese Organisation
	 *                             wird als Autor verwendet</div>
	 */
	public Author(org.ehealth_connector.common.Organization organizationAsAuthor) {
		mAuthor = new POCDMT000040Author();
		if (organizationAsAuthor.getHl7CdaR2Pocdmt000040Organization() != null) {
			mAuthor.setAssignedAuthor(Util.createAssignedAuthorFromOrganization(organizationAsAuthor));
		}
		setTime(null);
	}

	/**
	 * <div class="en"> Creates a new Author based on the given Patient object</div>
	 * <div class="de"> Erstellt einen neuen Autor der dem übergebenden Patienten
	 * entspricht.</div>
	 *
	 * @param patientAsAuthor <div class="en"> this Patient is used as Author</div>
	 *                        <div class="de"> dieser Patient wird als Autor
	 *                        verwendet</div> <div class="fr"></div>
	 */
	public Author(Patient patientAsAuthor) {
		this();
		if (patientAsAuthor.getHl7CdaPerson() != null) {
			POCDMT000040Person person = patientAsAuthor.getHl7CdaPerson();
			mAuthor.getAssignedAuthor().setAssignedPerson(person);
		}

		if (patientAsAuthor.getHl7CdaPerson().getName() != null) {
			for (final org.ehealth_connector.common.Name name : patientAsAuthor.getNames()) {
				mAuthor.getAssignedAuthor().getAssignedPerson().getName().add(name.getHl7CdaR2Pn());
			}
		}

		if ((patientAsAuthor.getIds() != null) && (!patientAsAuthor.getIds().isEmpty())) {
			mAuthor.getAssignedAuthor().getId().addAll(patientAsAuthor.getMdhtPatientRole().getId());
		}
		this.setFunctionCodePatient();
	}

	/**
	 * Instantiates a new human author.
	 *
	 * @param person the person
	 */
	public Author(Person person) {
		this();
		addName(person.getName());
	}

	/**
	 * Instantiates a new author.
	 *
	 * @param person the person
	 * @param gln    Global Location Number (GLN)
	 */
	public Author(Person person, String gln) {
		this(person);

		// Create and fill Person Name and GLN
		final var id = new II();
		id.setRoot(CodeSystems.GLN.getCodeSystemId());
		id.setExtension(gln);

		mAuthor.getAssignedAuthor().getId().add(id);
	}

	/**
	 * Weist dem Autor eine Postadresse zu.
	 *
	 * @param address Die Postadresse des Autors
	 */
	public void addAddress(Address address) {
		mAuthor.getAssignedAuthor().getAddr().add(address.getHl7CdaR2Ad());
	}

	/**
	 * Weist dem Autoren eine ID zu.
	 *
	 * @param identificator Kombination von eigentlicher ID und der OID der
	 *                      verwaltenden Domäne
	 */
	public void addId(Identificator identificator) {
		mAuthor.getAssignedAuthor().getId().add(identificator.getHl7CdaR2Ii());
	}

	/**
	 * <div class="en">Adds the name.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param name name
	 */
	public void addName(Name name) {
		mAuthor.getAssignedAuthor().getAssignedPerson().getName().add(name.getHl7CdaR2Pn());
	}

	/**
	 * <div class="en">Gets the address.</div> <div class="de">Liefert die (erste)
	 * Adresse.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the address</div>
	 */
	public Address getAddress() {
		return new Address(mAuthor.getAssignedAuthor().getAddr().get(0));
	}

	/**
	 * <div class="en">Gets the addresses.</div> <div class="de">Liefert alle
	 * Adressen.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the addresses</div>
	 */
	public List<Address> getAddresses() {
		final List<Address> al = new ArrayList<>();
		for (final AD mAddress : mAuthor.getAssignedAuthor().getAddr()) {
			final var address = new Address(mAddress);
			al.add(address);
		}
		return al;
	}

	/**
	 * Method to get
	 *
	 * @return the asAuthor
	 */
	public POCDMT000040AssignedAuthor getAsAuthor() {
		return mAuthor.getAssignedAuthor();
	}

	/**
	 * <div class="en">Gets the author mdht.</div> <div class="de">Liefert author
	 * mdht.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return org.openhealthtools.mdht.uml.cda.Author <div class="en">the author
	 *         mdht</div>
	 */
	public POCDMT000040Author getAuthorMdht() {
		return mAuthor;
	}

	/**
	 * <div class="en">Gets the complete name.</div> <div class="de">Liefert den
	 * ganzen Namen (z.B. "Dr. Allzeit Bereit der Dritte")</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the complete name</div>
	 */
	public String getCompleteName() {
		var retVal = "";
		// Search for the author name. If it isn´t there, try to use the
		// organisation name.
		if (mAuthor.getAssignedAuthor() != null && mAuthor.getAssignedAuthor().getAssignedPerson() != null
				&& !mAuthor.getAssignedAuthor().getAssignedPerson().getName().isEmpty()) {
			final var name = new Name(mAuthor.getAssignedAuthor().getAssignedPerson().getName().get(0));
			retVal = name.getFullName();
		}

		// If the Author has no name, try the represented organization
		if (retVal.equals("") && mAuthor.getAssignedAuthor() != null
				&& mAuthor.getAssignedAuthor().getRepresentedOrganization() != null
				&& !mAuthor.getAssignedAuthor().getRepresentedOrganization().getName().isEmpty()) {
			final var name = new Name(mAuthor.getAssignedAuthor().getRepresentedOrganization().getName().get(0));
			retVal = name.getFullName();
		}

		// If the Represented Organization has no Name try the Authoring Device
		if (retVal.equals("") && mAuthor.getAssignedAuthor() != null
				&& mAuthor.getAssignedAuthor().getAssignedAuthoringDevice() != null
				&& mAuthor.getAssignedAuthor().getAssignedAuthoringDevice().getSoftwareName() != null) {
			return mAuthor.getAssignedAuthor().getAssignedAuthoringDevice().getSoftwareName().xmlContent;
		}
		return retVal;

	}

	/**
	 * Gets the functionCode of the author
	 *
	 * @return the functionCode. Null, if not present.
	 */
	public Code getFunctionCode() {
		if (mAuthor.getFunctionCode() != null) {
			return new Code(mAuthor.getFunctionCode());
		}
		return null;
	}

	/**
	 * <div class="en">Gets the gln (identification of the author)</div>
	 * <div class="de">Liefert die GLN (ID des Autors)</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return <div class="en">the gln</div>
	 */
	public String getGln() {
		if (!mAuthor.getAssignedAuthor().getId().isEmpty()) {
			final var gln = Identificator.getIdentificator(mAuthor.getAssignedAuthor().getId(),
					CodeSystems.GLN.getCodeSystemId());
			return gln.getExtension();
		}
		return null;
	}

	/**
	 * <div class="en">Gets the gln as identificator.</div> <div class="de">Liefert
	 * gln (ID des Autoren) als Identificator Objekt.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return <div class="en">the gln as identificator</div>
	 */
	public Identificator getGlnAsIdentificator() {
		if (!mAuthor.getAssignedAuthor().getId().isEmpty()) {
			final var ii = mAuthor.getAssignedAuthor().getId().get(0);
			return new Identificator(ii);
		}
		return null;
	}

	/**
	 * <div class="en">Gets all ids of the author</div> <div class="de">Liefert alle
	 * IDs des Autoren</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the ids</div>
	 */
	public List<Identificator> getIds() {
		return Util.convertIds(mAuthor.getAssignedAuthor().getId());
	}

	public List<TEL> getMdhtTelecoms() {
		return mAuthor.getAssignedAuthor().getTelecom();
	}

	/**
	 * <div class="en">Gets the (first) family name.</div> <div class="de">Liefert
	 * den (ersten) Nachnamen</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the name</div>
	 */
	public Name getName() {
		return new Name(mAuthor.getAssignedAuthor().getAssignedPerson().getName().get(0));
	}

	/**
	 * <div class="en">Gets the names.</div> <div class="de">Liefert alle
	 * Namen</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the names</div>
	 */
	public List<Name> getNames() {
		final List<Name> nl = new ArrayList<>();
		for (final PN mName : mAuthor.getAssignedAuthor().getAssignedPerson().getName()) {
			nl.add(new Name(mName));
		}
		return nl;
	}

	/**
	 * <div class="en">Gets the organization (RepresentedOrganization). This element
	 * can also be used as author represented organization, when a document is
	 * beeing sent (via XDS, XDM, XDR).</div> <div class="de">Liefert die
	 * Organisation (RepresentedOrganization), der der Autor angehört (z.B. ein
	 * Krankenhaus). Dieses Element kann auch als Author Represented Organization
	 * Attribut verwendet werden, wenn das Dokument per XDS, XDM oder XDR verschickt
	 * wird.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @return organization <div class="en">the organization</div>
	 *         <div class="de">die Organisation</div> <div class="fr"></div>
	 *         <div class="it"></div>
	 */
	public Organization getOrganization() {
		return new Organization(mAuthor.getAssignedAuthor().getRepresentedOrganization());
	}

	/**
	 * Method to get
	 *
	 * @return the person
	 */
	public POCDMT000040Person getPerson() {
		return mAuthor.getAssignedAuthor().getAssignedPerson();
	}

	/**
	 * Gets the author function code. This element specifies in which role or
	 * function the author is related to this document (e.g. Code "40001" for
	 * "Apotheker"). The code can also be used as author role, when a document is
	 * beeing sent (via XDS, XDM, XDR).
	 *
	 * @return code the function code
	 */
	public Code getRoleFunction() {
		return new Code(mAuthor.getFunctionCode());
	}

	/**
	 * Sets the author speciality code. This element specifies the speciality
	 * ("Fachrichtung", e.g. "Fachärztin/Facharzt für Allgemeine Innere Medizin" )
	 * of the author. The code can also be used as author speciality, when a
	 * document is beeing sent (via XDS, XDM, XDR).
	 *
	 * @return code the speciality code
	 */
	public Code getSpeciality() {
		return new Code(mAuthor.getAssignedAuthor().getCode());
	}

	/**
	 * <div class="en">Gets the telecoms.</div> <div class="de">Liefert
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Telecoms <div class="en">the telecoms</div>
	 */
	public List<Telecom> getTelecoms() {
		List<Telecom> telecoms = new LinkedList<>();
		for (TEL tel : mAuthor.getAssignedAuthor().getTelecom()) {
			telecoms.add(new Telecom(tel));
		}
		return telecoms;
	}

	/**
	 * <div class="en">Gets the author time. The author/time element represents the
	 * start time of the author’s participation in the creation of the clinical
	 * document </div> <div class="de">Liefert die Zeit für den Autor. Diese gibt
	 * den Startzeitpunkt an, an dem der Autor bei der Erstellung des Dokument
	 * mitgewirkt hat.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @return date <div class="en">the start time of the participation as
	 *         string</div> <div class="de">den Startzeitpunkt der Partizipation als
	 *         String</div> <div class="fr"></div> <div class="it"></div>
	 */
	public Date getTimeAsDate() {
		if (mAuthor.getTime() != null) {
			return DateUtil.parseHl7Timestamp(mAuthor.getTime());
		}
		return null;
	}

	/**
	 * <div class="en">Gets the author time. The author/time element represents the
	 * start time of the author’s participation in the creation of the clinical
	 * document </div> <div class="de">Liefert die Zeit für den Autor. Diese gibt
	 * den Startzeitpunkt an, an dem der Autor bei der Erstellung des Dokument
	 * mitgewirkt hat.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @return date <div class="en">the start time of the participation as
	 *         string</div> <div class="de">den Startzeitpunkt der Partizipation als
	 *         String</div> <div class="fr"></div> <div class="it"></div>
	 */
	public IVLTS getTimeAsIVLTS() {
		IVLTS retVal = null;
		if (mAuthor.getTime() != null) {
			retVal = DateUtil.date2IvltsTzon(DateUtil.parseHl7Timestamp(mAuthor.getTime().getValue()));
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the author time. The author/time element represents the
	 * start time of the author’s participation in the creation of the clinical
	 * document </div> <div class="de">Liefert die Zeit für den Autor. Diese gibt
	 * den Startzeitpunkt an, an dem der Autor bei der Erstellung des Dokument
	 * mitgewirkt hat.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @return date <div class="en">the start time of the participation as
	 *         string</div> <div class="de">den Startzeitpunkt der Partizipation als
	 *         String</div> <div class="fr"></div> <div class="it"></div>
	 */
	public String getTimeAsString() {
		if (mAuthor.getTime() != null) {
			return DateUtil.formatDateTimeTzon(DateUtil.parseHl7Timestamp(mAuthor.getTime()));
		}
		return null;
	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see java.lang.Object#hashCode()
	// */
	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = (prime * result) + ((asAuthor == null) ? 0 :
	// asAuthor.hashCode());
	// result = (prime * result) + ((mAuthor == null) ? 0 : mAuthor.hashCode());
	// result = (prime * result) + ((person == null) ? 0 : person.hashCode());
	// return result;
	// }
	//
	/**
	 * Checks if is author patient.
	 *
	 * @return true, if is author patient
	 */
	public boolean isAuthorPatient() {
		final CE functionCode = mAuthor.getFunctionCode();
		if (functionCode != null) {
			return FUNCTION_CODE_AUTHOR_PATIENT.equals(new Code(functionCode));
		}
		return false;
	}

	/**
	 * Method to set
	 *
	 * @param asAuthor the asAuthor to set
	 */
	public void setAsAuthor(POCDMT000040AssignedAuthor asAuthor) {
		mAuthor.setAssignedAuthor(asAuthor);
	}

	public void setAssignedAuthoringDevice(POCDMT000040AuthoringDevice device) {
		if (mAuthor.getAssignedAuthor() == null) {
			mAuthor.setAssignedAuthor(new POCDMT000040AssignedAuthor());
		}
		mAuthor.getAssignedAuthor().setAssignedAuthoringDevice(device);
		if (mAuthor.getAssignedAuthor().getAssignedPerson() != null) {
			mAuthor.getAssignedAuthor().setAssignedPerson(null);
		}
	}

	/**
	 * Method to set
	 *
	 * @param author the author to set
	 */
	public void setAuthor(POCDMT000040Author author) {
		mAuthor = author;
	}

	/**
	 * Sets the functionCode of the author
	 *
	 * @param code the functionCode
	 */
	public void setFunctionCode(Code code) {
		if (code != null) {
			mAuthor.setFunctionCode(code.getHl7CdaR2Ce());
		}
	}

	/**
	 * Indicates that the author is the patient itself.
	 *
	 */
	public void setFunctionCodePatient() {
		mAuthor.setFunctionCode(FUNCTION_CODE_AUTHOR_PATIENT.getHl7CdaR2Ce());
	}

	/**
	 * <div class="en">Sets the gln.</div> <div class="de">Setzt die GLN (ID des
	 * Autoren).</div> <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @param gln <div class="en">the new gln. If null an Id with nullFlavor = NA
	 *            will be added.</div> <div class="de">Die neue gln. Bei null wird
	 *            eine Id mit dem NullFlavor = NA hinzugefügt.</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	public void setGln(String gln) {
		if (gln != null) {
			addId(new Identificator(CodeSystems.GLN.getCodeSystemId(), gln));
		} else {
			final var ii = new II();
			ii.getNullFlavor().add(org.ehealth_connector.common.enums.NullFlavor.NOT_APPLICABLE_CODE);
			mAuthor.getAssignedAuthor().getId().add(ii);
		}
	}

	/**
	 * <div class="en">Sets the organization (RepresentedOrganization). The code can
	 * also be used as author role, when a document is beeing sent (via XDS, XDM,
	 * XDR).</div> <div class="de">Setzt eine Organisation
	 * (RepresentedOrganization), der der Autor angehört (z.B. ein Krankenhaus).
	 * Dieses Element kann auch als Author Represented Organization Attribut
	 * verwendet werden, wenn das Dokument per XDS, XDM oder XDR verschickt
	 * wird.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @param organization <div class="en">the new organization</div>
	 *                     <div class="de">die neue Organisation</div>
	 *                     <div class="fr"></div> <div class="it"></div>
	 */
	public void setOrganization(Organization organization) {
		if (organization != null)
			mAuthor.getAssignedAuthor().setRepresentedOrganization(organization.getHl7CdaR2Pocdmt000040Organization());
	}

	/**
	 * Sets the functionCode of the author
	 *
	 * @param codeSystem    the code system
	 * @param codeSystemame the name of the code system
	 * @param originalText  the function code (free text)
	 */
	/**
	 * Sets the other function code.
	 *
	 * @param codeSystem     the code system OID.
	 * @param codeSystemName the name of the code system.
	 * @param originalText   the original text (narrative text of the code).
	 */
	public void setOtherFunctionCode(String codeSystem, String codeSystemName, String originalText) {
		if (originalText != null) {
			final var otherCode = new CE();
			otherCode.getNullFlavor().add(org.ehealth_connector.common.enums.NullFlavor.OTHER_CODE);
			if (codeSystem != null)
				otherCode.setCode(codeSystem);
			if (codeSystemName != null)
				otherCode.setCodeSystemName(codeSystemName);

			var ed = new ED();
			var tel = new TEL();
			tel.setValue(originalText);
			ed.setReference(null);
			otherCode.setOriginalText(ed);
			mAuthor.setFunctionCode(otherCode);
		}
	}

	/**
	 * Method to set
	 *
	 * @param person the person to set
	 */
	public void setPerson(POCDMT000040Person person) {
		mAuthor.getAssignedAuthor().setAssignedPerson(person);
	}

	/**
	 * Sets the author function code. This element specifies in which role or
	 * function the author is related to this document (e.g. Code "40001" for
	 * "Apotheker"). The code can also be used as author role, when a document is
	 * beeing sent (via XDS, XDM, XDR).
	 *
	 * @param code the function code
	 */
	public void setRoleFunction(Code code) {
		mAuthor.setFunctionCode(code.getHl7CdaR2Ce());
	}

	/**
	 * Sets the author speciality code. This element specifies the speciality
	 * ("Fachrichtung", e.g. Code "50001" for "Fachärztin/Facharzt für Allgemeine
	 * Innere Medizin") of the author. The code can also be used as author
	 * speciality, when a document is beeing sent (via XDS, XDM, XDR).
	 *
	 * @param code the speciality code
	 */
	public void setSpeciality(Code code) {
		mAuthor.getAssignedAuthor().setCode(code.getHl7CdaR2Ce());
	}

	/**
	 * <div class="en">Sets the telecoms.</div> <div class="de">Setzt
	 * telecoms.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param telecoms <div class="en">the new telecoms</div> <div class="de">das
	 *                 neue telecoms.</div> <div class="fr"></div>
	 *                 <div class="it"></div>
	 */
	public void setTelecoms(List<Telecom> telecoms) {
		for (Telecom tel : telecoms) {
			if (tel != null) {
				mAuthor.getAssignedAuthor().getTelecom().add(tel.getHl7CdaR2Tel());
			}
		}

	}

	/**
	 * <div class="en">Sets the author time. The author/time element represents the
	 * start time of the author’s participation in the creation of the clinical
	 * document </div> <div class="de">Setzt die Zeit für den Autor. Diese gibt den
	 * Startzeitpunkt an, an dem der Autor bei der Erstellung des Dokument
	 * mitgewirkt hat.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 *
	 * @param date <div class="en">the start time of the participation as date</div>
	 *             <div class="de">den Startzeitpunkt der Partizipation als
	 *             Date</div> <div class="fr"></div> <div class="it"></div>
	 */
	public void setTime(Date date) {
		if (date != null) {
			mAuthor.setTime(DateUtil.date2TsTzon(date));
		} else {
			mAuthor.setTime(DateUtil.date2TsTzon(new Date()));
		}
	}

}
