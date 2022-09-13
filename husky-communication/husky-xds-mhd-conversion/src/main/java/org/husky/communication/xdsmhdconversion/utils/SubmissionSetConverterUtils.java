package org.husky.communication.xdsmhdconversion.utils;

import ca.uhn.fhir.rest.server.exceptions.InvalidRequestException;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.Organization;
import org.husky.common.enums.LanguageCode;
import org.husky.communication.ch.enums.SubmissionSetAuthorRole;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Person;

import java.util.List;
import java.util.Set;

/**
 * Utilities for the converter between XDS' SubmissionSet and the equivalent MHD resource.
 *
 * @author Ronaldo Loureiro
 */
public class SubmissionSetConverterUtils {

    /**
     * Constructor
     */
    private SubmissionSetConverterUtils() {
    }

    public static String addPrefixOid(String urn) {
        if (urn == null) return null;
        return urn.startsWith("urn:oid:") ? urn : "urn:oid:" + urn;
    }

    public static String addPrefixUuid(String urn) {
        if (urn == null) return null;
        return urn.startsWith("urn:uuid:") ? urn : "urn:uuid:" + urn;
    }

    public static String removePrefixOid(String urn) {
        if (urn == null) return null;
        return urn.startsWith("urn:oid:") ? urn.substring(8) : urn;
    }

    public static String removePrefixUuid(String urn) {
        if (urn == null) return null;
        return urn.startsWith("urn:uuid:") ? urn.substring(9) : urn;
    }

    /**
     * search a referenced resource from a list of (contained) resources.
     *
     * @param ref
     * @param contained
     * @return
     */
    public static Resource findResource(Reference ref, List<Resource> contained) {
        for (Resource res : contained) {
            if (res.getId().equals(ref.getReference())) return res;
        }
        return null;
    }

    /**
     * Wrap string in localized string
     *
     * @param string
     * @return
     */
    public static LocalizedString getLocalizedString(String string) {
        // FIX FOR CARA
        return string != null ? new LocalizedString(string, LanguageCode.ENGLISH_CODE, "UTF-8") : null;
    }

    /**
     * FHIR Identifier -> XDS Identifiable
     *
     * @param identifier
     * @return
     */
    public static Identifiable transformToIdentifiable(Identifier identifier) {
        String system = removePrefixOid(identifier.getSystem());
        return new Identifiable(identifier.getValue(), new AssigningAuthority(system));
    }

    /**
     * FHIR CodeableConcept -> XDS Identifiable
     *
     * @param cc
     * @return
     */
    public static Identifiable transformToIdentifiable(CodeableConcept cc) {
        Code code = transformToCode(cc);
        String system = code.getSchemeName();
        return new Identifiable(code.getCode(), new AssigningAuthority(system));
    }

    /**
     * XDS Identifiable -> FHIR Identifier
     * @param identifiable
     * @return
     */
    public static Identifier transformToIdentifier(Identifiable identifiable) {
        if (identifiable == null) return null;

        Identifier result = new Identifier();
        AssigningAuthority assigningAuthority = identifiable.getAssigningAuthority();
        String value = identifiable.getId();

        if (assigningAuthority != null) {
            String system = assigningAuthority.getUniversalId();
            result.setSystem(addPrefixOid(system));
        }
        result.setValue(value);
        return result;
    }

    /**
     * XDS Identifiable -> FHIR Patient Reference
     *
     * @param patient
     * @return
     */
    public static Reference transformToPatientReference(Identifiable patient) {
        String system = patient.getAssigningAuthority().getUniversalId();
        String value = patient.getId();
        // ¯\_(ツ)_/¯
        return new Reference().setReference(system + "-" + value);
    }

    /**
     * FHIR HumanName -> XDS Name
     *
     * @param name
     * @return
     */
    public static Name transformToName(HumanName name) {
        Name targetName = new XpnName();

        if (name.hasPrefix()) targetName.setPrefix(name.getPrefixAsSingleString());
        if (name.hasSuffix()) targetName.setSuffix(name.getSuffixAsSingleString());

        targetName.setFamilyName(name.getFamily());
        List<StringType> givens = name.getGiven();

        if (!givens.isEmpty()) {
            targetName.setGivenName(givens.get(0).getValue());
            targetName.setSecondAndFurtherGivenNames(String.join(" ", givens.stream()
                    .skip(1)
                    .map(StringType::getValue)
                    .toList()));
        }
        return targetName;
    }

    /**
     * FHIR Practitioner -> XDS Person
     *
     * @param practitioner
     * @return
     */
    public static Person transformToPerson(Practitioner practitioner) {
        return practitioner != null ? transformToPerson(practitioner.hasName(), practitioner.getNameFirstRep(), practitioner.getIdentifierFirstRep()) : null;
    }

    /**
     * FHIR Patient -> XDS Person
     *
     * @param patient
     * @return
     */
    public static Person transformToPerson(Patient patient) {
        return patient != null ? transformToPerson(patient.hasName(), patient.getNameFirstRep(), patient.getIdentifierFirstRep()) : null;
    }

    /**
     * FHIR RelatedPerson -> XDS Person
     *
     * @param related
     * @return
     */
    public static Person transformToPerson(RelatedPerson related) {
        return related != null ? transformToPerson(related.hasName(), related.getNameFirstRep(), related.getIdentifierFirstRep()) : null;
    }

    /**
     * FHIR -> XDS Person
     *
     * @param hasName
     * @param name
     * @param identifier
     * @return
     */
    private static Person transformToPerson(boolean hasName, HumanName name, Identifier identifier) {
        Person result = new Person();
        if (hasName) result.setName(transformToName(name));
        result.setId(transformToIdentifiable(identifier));
        return result;
    }

    /**
     * FHIR ContactPoint -> XDS Telecom
     *
     * @param contactPoint
     * @return
     */
    public static Telecom transformToTelecom(ContactPoint contactPoint) {
        if (contactPoint == null) return null;
        Telecom result = new Telecom();

        if (contactPoint.getSystem() == ContactPoint.ContactPointSystem.EMAIL || contactPoint.getSystem() == ContactPoint.ContactPointSystem.URL) {
            result.setEmail(contactPoint.getValue());
            result.setUse("NET");
            result.setType("Internet");
        } else {
            result.setUnformattedPhoneNumber(contactPoint.getValue());
            if (contactPoint.hasSystem())
                switch (contactPoint.getSystem()) {
                    case SMS, PHONE -> result.setType("PH");
                    case FAX -> result.setType("FX");
                    case PAGER -> result.setType("BP");
                }

            if (contactPoint.hasUse())
                switch (contactPoint.getUse()) {
                    case HOME -> result.setUse("PRN");
                    case WORK -> result.setUse("WPN");
                    // ¯\_(ツ)_/¯
                    case MOBILE -> result.setType("CP");
                }

        }

        return result;
    }

    /**
     * FHIR Organization -> XDS Organization
     *
     * @param org
     * @return
     */
    public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization transformToOrganization(Organization org) {
        org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization result = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization();
        Identifier identifier = org.getIdentifierFirstRep();

        result.setOrganizationName(org.getName());
        result.setIdNumber(identifier.getValue());
        result.setAssigningAuthority(new AssigningAuthority(removePrefixOid(identifier.getSystem())));

        return result;
    }

    /**
     * FHIR Coding -> XDS Code
     *
     * @param coding
     * @return
     */
    public static Code transformToCode(Coding coding) {
        return coding != null ? new Code(coding.getCode(), getLocalizedString(coding.getDisplay()), new SchemeMapper().getScheme(coding.getSystem())) : null;
    }

    /**
     * FHIR CodeableConcept -> XDS Code
     *
     * @param cc
     * @return
     */
    public static Code transformToCode(CodeableConcept cc) {
        return cc != null ? transformToCode(cc.getCodingFirstRep()) : null;
    }

    /**
     * XDS code -> FHIR CodeableConcept
     *
     * @param code
     * @return
     */
    public static CodeableConcept transformToCodeableConcept(Code code) {
        String display = code.getDisplayName() == null ? "" : code.getDisplayName().getValue();
        return new CodeableConcept().addCoding(new Coding().setCode(code.getCode())
                .setSystem(new SchemeMapper().getSystem(code.getSchemeName()))
                .setDisplay(display));
    }

    private static boolean isPatientAuthor(Author author) {
        if (author != null && author.getAuthorRole() != null) {
            Set<String> patientRoles = Set.of(SubmissionSetAuthorRole.PATIENT_CODE, SubmissionSetAuthorRole.REPRESENTATIVE_CODE);

            return author.getAuthorRole().stream()
                    .filter(role -> patientRoles.contains(role.getId()))
                    .anyMatch(role -> role.getAssigningAuthority().getUniversalId().equals(SubmissionSetAuthorRole.VALUE_SET_ID));
        }
        return false;
    }

    /**
     * FHIR Reference to Author -> XDS Author
     *
     * @param author
     * @param contained
     * @return
     */
    public static Author transformAuthor(Reference author, List<Resource> contained, Identifiable authorRole) {
        if (author == null || author.getReference() == null) {
            if (authorRole != null) {
                Author result = new Author();
                Person person = new Person();
                // CARA PMP
                // At least an authorPerson, authorTelecommunication, or authorInstitution sub-attribute must be present
                // Either authorPerson, authorInstitution or authorTelecom shall be specified in the SubmissionSet [IHE ITI Technical Framework Volume 3 (4.2.3.1.4)].
                person.setName(transformToName(new HumanName().setFamily("---")));
                result.setAuthorPerson(person);
                result.getAuthorRole().add(authorRole);
                return result;
            }
            return null;
        }

        Resource authorObj = findResource(author, contained);
        if (authorObj instanceof Practitioner practitioner) {
            Author result = new Author();
            result.setAuthorPerson(transformToPerson(practitioner));

            result.getAuthorTelecom().addAll(practitioner.getTelecom().stream()
                    .map(SubmissionSetConverterUtils::transformToTelecom)
                    .toList());

            if (authorRole == null) {
                authorRole = new Identifiable(SubmissionSetAuthorRole.HEALTHCARE_PROFESSIONAL_CODE, new AssigningAuthority(SubmissionSetAuthorRole.VALUE_SET_ID));
            }

            result.getAuthorRole().add(authorRole);
            return result;
        } else if (authorObj instanceof Patient patient) {
            Author result = new Author();
            result.setAuthorPerson(transformToPerson(patient));

            result.getAuthorTelecom().addAll(patient.getTelecom().stream()
                    .map(SubmissionSetConverterUtils::transformToTelecom)
                    .toList());

            if (authorRole == null) {
                authorRole = new Identifiable(SubmissionSetAuthorRole.PATIENT_CODE, new AssigningAuthority(SubmissionSetAuthorRole.VALUE_SET_ID));
            }

            result.getAuthorRole().add(authorRole);
            return result;
        } else if (authorObj instanceof PractitionerRole role) {
            Author result = new Author();

            Practitioner practitioner = (Practitioner) findResource(role.getPractitioner(), contained);
            if (practitioner != null)
                result.setAuthorPerson(transformToPerson(practitioner));

            Organization org = (Organization) findResource(role.getOrganization(), contained);
            if (org != null)
                result.getAuthorInstitution().add(transformToOrganization(org));

            result.getAuthorRole().addAll(role.getCode().stream()
                    .map(SubmissionSetConverterUtils::transformToIdentifiable)
                    .toList());

            result.getAuthorSpecialty().addAll(role.getSpecialty().stream()
                    .map(SubmissionSetConverterUtils::transformToIdentifiable)
                    .toList());

            result.getAuthorTelecom().addAll(role.getTelecom().stream()
                    .map(SubmissionSetConverterUtils::transformToTelecom)
                    .toList());

            return result;
        } else throw new InvalidRequestException("Author role not supported.");
    }

    /**
     * XDS Name -> FHIR HumanName
     *
     * @param name
     * @return
     */
    public static HumanName transformToHumanName(Name name) {
        HumanName result = new HumanName();

        if (name.getPrefix() != null) {
            result.addPrefix(name.getPrefix());
        }

        if (name.getSuffix() != null) {
            result.addSuffix(name.getSuffix());
        }

        result.setFamily(name.getFamilyName()).addGiven(name.getGivenName());

        String more = name.getSecondAndFurtherGivenNames();
        if (more != null) {
            for (String extraName : more.split(" ")) {
                result.addGiven(extraName);
            }
        }
        return result;
    }

    /**
     * XDS Person -> FHIR Patient
     *
     * @param person
     * @return
     */
    public static Patient transformPatient(Person person) {
        if (person == null) return null;
        Patient patient = new Patient();
        Name name = person.getName();
        if (name != null) {
            patient.addName(transformToHumanName(name));
        }
        if (person.getId() != null) patient.addIdentifier(transformToIdentifier(person.getId()));

        return patient;
    }

    /**
     * XDS Author -> FHIR Reference
     *
     * @param author
     * @return
     */
//    public static Reference transformAuthor(Author author) {
//        Person person = author.getAuthorPerson();
//
//        if (isPatientAuthor(author)) {
//            Patient patient = transformPatient(person);
//            Reference result = new Reference();
//            List<Telecom> telecoms = author.getAuthorTelecom();
//            for (Telecom telecom : telecoms) patient.addTelecom(transform(telecom));
//            result.setResource(patient);
//            return result;
//        }
//
//        Practitioner containedPerson = transformPractitioner(person);
//        PractitionerRole role = null;
//
//        List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization> orgs = author.getAuthorInstitution();
//        List<Identifiable> roles = author.getAuthorRole();
//        List<Identifiable> specialities = author.getAuthorSpecialty();
//
//        if (!orgs.isEmpty() || !roles.isEmpty() || !specialities.isEmpty()) {
//            role = new PractitionerRole();
//            if (containedPerson != null) role.setPractitioner((Reference) new Reference().setResource(containedPerson));
//        }
//
//        for (org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization org : orgs) {
//            role.setOrganization((Reference) new Reference().setResource(transform(org)));
//        }
//
//        for (Identifiable roleId : roles) {
//            role.addCode(transform(roleId));
//        }
//
//        for (Identifiable specId : specialities) {
//            role.addSpecialty(transform(specId));
//        }
//
//        Reference result = new Reference();
//        List<Telecom> telecoms = author.getAuthorTelecom();
//        if (role == null) {
//            for (Telecom telecom : telecoms) containedPerson.addTelecom(transform(telecom));
//            result.setResource(containedPerson);
//        } else {
//            for (Telecom telecom : telecoms) role.addTelecom(transform(telecom));
//            result.setResource(role);
//        }
//        return result;
//    }

}
