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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.Isco08;
import org.husky.common.enums.NullFlavor;
import org.husky.common.hl7cdar2.*;
import org.husky.common.utils.time.DateTimes;
import org.husky.common.utils.time.Hl7Dtm;

import java.time.Instant;
import java.util.*;

/**
 * Author
 */
public class Author {

    public static final Code FUNCTION_CODE_AUTHOR_PATIENT = new Code(NullFlavor.NOT_APPLICABLE_L1);
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
        
        Date dateTime = getTimeAsDate();

		if (dateTime != null) {
			mAuthor.setTime(DateTimes.toDateTs(dateTime.toInstant()));
		}

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
     * Instantiates a new software author (e.g. a laboratory information system)
     *
     * @param device the device
     */
    public Author(AuthoringDevice device) {
        this();
        setAssignedAuthoringDevice(device.getMdht());
    }

    /**
     * Creates a null flavored author according to ELGA spec (necessary for PHARM DIS)
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

        mAuthor.getNullFlavor().add(org.husky.common.enums.NullFlavor.NOT_APPLICABLE_L1_CODE);
        mAuthor.getAssignedAuthor().getNullFlavor()
                .add(org.husky.common.enums.NullFlavor.NOT_APPLICABLE_L1_CODE);
        final var ii = new II();
        ii.getNullFlavor().add(org.husky.common.enums.NullFlavor.NOT_APPLICABLE_L1_CODE);
        mAuthor.getAssignedAuthor().getId().add(ii);
        final var tsTime = new TS();
        tsTime.getNullFlavor().add(org.husky.common.enums.NullFlavor.NOT_APPLICABLE_L1_CODE);
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

		Date dateTime = getTimeAsDate();

		if (dateTime != null) {
			mAuthor.setTime(DateTimes.toDateTs(dateTime.toInstant()));
		}

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
     * Erstellt ein husky-Author Objekt mittels eines MDHT-Author Objekts.
     *
     * @param authorMdht the MDHT Author Object
     */
    public Author(POCDMT000040Author authorMdht) {
        mAuthor = authorMdht;
    }

    /**
     * Creates a new Author based on the given Organization object
     *
     * @param organizationAsAuthor this Organization is used as Author
     */
    public Author(org.husky.common.model.Organization organizationAsAuthor) {
        mAuthor = new POCDMT000040Author();
        if (organizationAsAuthor.getHl7CdaR2Pocdmt000040Organization() != null) {
			mAuthor.setAssignedAuthor(organizationAsAuthor.createHl7CdaR2Pocdmt000040AssignedAuthor());
        }
        setTime(null);
    }

    /**
     * Creates a new Author based on the given Patient object
     *
     * @param patientAsAuthor this Patient is used as Author
     */
    public Author(Patient patientAsAuthor) {
        this();
        if (patientAsAuthor.getHl7CdaPerson() != null) {
            POCDMT000040Person person = patientAsAuthor.getHl7CdaPerson();
            mAuthor.getAssignedAuthor().setAssignedPerson(person);
        }

		if (!patientAsAuthor.getHl7CdaPerson().getName().isEmpty()) {
            for (final org.husky.common.model.Name name : patientAsAuthor.getNames()) {
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
     * @param identificator Kombination von eigentlicher ID und der OID der verwaltenden Domäne
     */
    public void addId(Identificator identificator) {
        mAuthor.getAssignedAuthor().getId().add(identificator.getHl7CdaR2Ii());
    }

    /**
     * Adds the name.
     *
     * @param name name
     */
    public void addName(Name name) {
        mAuthor.getAssignedAuthor().getAssignedPerson().getName().add(name.getHl7CdaR2Pn());
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public Address getAddress() {
        return new Address(mAuthor.getAssignedAuthor().getAddr().get(0));
    }

    /**
     * Gets the addresses.
     *
     * @return the addresses
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
     * Method to set
     *
     * @param asAuthor the asAuthor to set
     */
    public void setAsAuthor(POCDMT000040AssignedAuthor asAuthor) {
        mAuthor.setAssignedAuthor(asAuthor);
    }

    /**
     * Gets the author.
     *
     * @return the author
     */
    public POCDMT000040Author getAuthorMdht() {
        return mAuthor;
    }

    /**
     * Gets the complete name.
     *
     * @return the complete name
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
            return mAuthor.getAssignedAuthor().getAssignedAuthoringDevice().getSoftwareName().getTextContent();
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
     * Gets the gln (identification of the author)
     *
     * @return the gln
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
     * Sets the gln.
     *
     * @param gln the new gln. If null an Id with nullFlavor = NA will be added.
     */
    public void setGln(String gln) {
        if (gln != null) {
            addId(new Identificator(CodeSystems.GLN.getCodeSystemId(), gln));
        } else {
            final var ii = new II();
            ii.getNullFlavor().add(org.husky.common.enums.NullFlavor.NOT_APPLICABLE_L1_CODE);
            mAuthor.getAssignedAuthor().getId().add(ii);
        }
    }

    /**
     * Gets the gln as identificator.
     *
     * @return the gln as identificator
     */
    public Identificator getGlnAsIdentificator() {
        if (!mAuthor.getAssignedAuthor().getId().isEmpty()) {
            final var ii = mAuthor.getAssignedAuthor().getId().get(0);
            return new Identificator(ii);
        }
        return null;
    }

    /**
     * Gets all ids of the author
     *
     * @return the ids
     */
    public List<Identificator> getIds() {
		return Identificator.getIdentificatorList(mAuthor.getAssignedAuthor().getId());
    }

    public List<TEL> getMdhtTelecoms() {
        return mAuthor.getAssignedAuthor().getTelecom();
    }

    /**
     * Gets the (first) family name.
     *
     * @return the name
     */
    public Name getName() {
        return new Name(mAuthor.getAssignedAuthor().getAssignedPerson().getName().get(0));
    }

    /**
     * Gets the names.
     *
     * @return the names
     */
    public List<Name> getNames() {
        final List<Name> nl = new ArrayList<>();
        for (final PN mName : mAuthor.getAssignedAuthor().getAssignedPerson().getName()) {
            nl.add(new Name(mName));
        }
        return nl;
    }

    /**
     * Gets the organization (RepresentedOrganization). This element can also be used as author represented
     * organization, when a document is beeing sent (via XDS, XDM, XDR).
     *
     * @return organization the organization
     */
    public Organization getOrganization() {
        return new Organization(mAuthor.getAssignedAuthor().getRepresentedOrganization());
    }

    /**
     * Sets the organization (RepresentedOrganization). The code can also be used as author role, when a document is
     * being sent (via XDS, XDM, XDR).
     *
     * @param organization the new organization
     */
    public void setOrganization(Organization organization) {
        if (organization != null)
            mAuthor.getAssignedAuthor().setRepresentedOrganization(organization.getHl7CdaR2Pocdmt000040Organization());
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
     * Method to set
     *
     * @param person the person to set
     */
    public void setPerson(POCDMT000040Person person) {
        mAuthor.getAssignedAuthor().setAssignedPerson(person);
    }

    /**
     * Gets the author function code. This element specifies in which role or function the author is related to this
     * document (e.g. Code "40001" for "Apotheker"). The code can also be used as author role, when a document is beeing
     * sent (via XDS, XDM, XDR).
     *
     * @return code the function code
     */
    public Code getRoleFunction() {
        return new Code(mAuthor.getFunctionCode());
    }

    /**
     * Sets the author function code. This element specifies in which role or function the author is related to this
     * document (e.g. Code "40001" for "Apotheker"). The code can also be used as author role, when a document is beeing
     * sent (via XDS, XDM, XDR).
     *
     * @param code the function code
     */
    public void setRoleFunction(Code code) {
        mAuthor.setFunctionCode(code.getHl7CdaR2Ce());
    }

    /**
     * Sets the author speciality code. This element specifies the speciality ("Fachrichtung", e.g. "Fachärztin/Facharzt
     * für Allgemeine Innere Medizin" ) of the author. The code can also be used as author speciality, when a document
     * is beeing sent (via XDS, XDM, XDR).
     *
     * @return code the speciality code
     */
    public Code getSpeciality() {
        CE code = mAuthor.getAssignedAuthor().getCode();
        return code!=null ? new Code(mAuthor.getAssignedAuthor().getCode()): null;
    }

    /**
     * Sets the author speciality code. This element specifies the speciality ("Fachrichtung", e.g. Code "50001" for
     * "Fachärztin/Facharzt für Allgemeine Innere Medizin") of the author. The code can also be used as author
     * speciality, when a document is beeing sent (via XDS, XDM, XDR).
     *
     * @param code the speciality code
     */
    public void setSpeciality(Code code) {
        mAuthor.getAssignedAuthor().setCode(code.getHl7CdaR2Ce());
    }

    /**
     * Gets the telecoms.
     *
     * @return Telecoms the telecoms
     */
    public List<Telecom> getTelecoms() {
        List<Telecom> telecoms = new LinkedList<>();
        for (TEL tel : mAuthor.getAssignedAuthor().getTelecom()) {
            telecoms.add(new Telecom(tel));
        }
        return telecoms;
    }

    /**
     * Sets the telecoms.
     *
     * @param telecoms the new telecoms
     */
    public void setTelecoms(List<Telecom> telecoms) {
        for (Telecom tel : telecoms) {
            if (tel != null) {
                mAuthor.getAssignedAuthor().getTelecom().add(tel.getHl7CdaR2Tel());
            }
        }

    }

    /**
     * Gets the author time. The author/time element represents the start time of the author’s participation in the
     * creation of the clinical document
     *
     * @return date the start time of the participation as string
     */
    public Date getTimeAsDate() {
        return Optional.ofNullable(this.getTimeAsInstant()).map(Date::from).orElse(null);
    }

    /**
     * Returns the participation start time as an {@link Hl7Dtm} or {@code null}.
     */
    @Nullable
    public Hl7Dtm getTimeAsHl7Dtm() {
        if (mAuthor.getTime() != null && mAuthor.getTime().getValue() != null) {
            return Hl7Dtm.fromHl7(mAuthor.getTime().getValue());
        }
        return null;
    }

    /**
     * Returns the participation start time as an {@link Hl7Dtm} or {@code null}.
     */
	@Nullable
    public Instant getTimeAsInstant() {
		return Optional.ofNullable(this.getTimeAsHl7Dtm()).map(Hl7Dtm::toInstant).orElse(Hl7Dtm.now().toInstant());
    }

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
     * Indicates that the author is the patient itself.
     */
    public void setFunctionCodePatient() {
        mAuthor.setFunctionCode(FUNCTION_CODE_AUTHOR_PATIENT.getHl7CdaR2Ce());
    }

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
            otherCode.getNullFlavor().add(NullFlavor.OTHER_L2_CODE);
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
     * Sets the author time. The author/time element represents the start time of the author’s participation in the
     * creation of the clinical document.
     *
     * @param date the start time of the participation as date
     */
	public void setTime(Calendar date) {
		if (date != null) {
			mAuthor.setTime(DateTimes.toDateTs(date.toInstant(), date.getTimeZone().toZoneId()));
        } else {
			mAuthor.setTime(DateTimes.toDateTs(new Date().toInstant()));
        }
    }

}
