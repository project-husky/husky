package org.husky.communication.xdsmhdconversion.utils;

import ca.uhn.fhir.rest.server.exceptions.InvalidRequestException;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.Organization;
import org.husky.common.enums.LanguageCode;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
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

        if (contactPoint.getSystem() == ContactPointSystem.EMAIL || contactPoint.getSystem() == ContactPointSystem.URL) {
            result.setEmail(contactPoint.getValue());
            result.setUse("NET");
            result.setType("Internet");
        } else {
            result.setUnformattedPhoneNumber(contactPoint.getValue());
            if (contactPoint.hasSystem()) {
                String system = switch (contactPoint.getSystem()) {
                    case SMS, PHONE -> "PH";
                    case FAX -> "FX";
                    case PAGER -> "BP";
                    default -> null;
                };
                result.setType(system);
            }

            if (contactPoint.hasUse()) {
                String use = switch (contactPoint.getUse()) {
                    // v2.ContactPointUse, v3 is available
                    case HOME -> "PRN";
                    case WORK -> "WPN";
                    case MOBILE -> "PRS";
                    default -> null;
                };
                result.setUse(use);
                // ¯\_(ツ)_/¯
                if (contactPoint.getUse() == ContactPointUse.MOBILE) result.setType("CP");
            }
        }
        return result;
    }

    /**
     * XDS Telecom -> FHIR ContactPoint
     * @param telecom
     * @return
     */
    public static ContactPoint transformToContactPoint(Telecom telecom) {
        ContactPoint result = new ContactPoint();

        String type = telecom.getType();
        String use = telecom.getUse();

        if ("NET".equals(use) || "X.400".equals(type)) {
            result.setSystem(ContactPointSystem.EMAIL);
            result.setValue(telecom.getEmail());
        } else {
            result.setValue(telecom.getUnformattedPhoneNumber());

            ContactPointUse cpu = switch (use) {
                case "WPN" -> ContactPointUse.WORK;
                case "PRN" -> ContactPointUse.HOME;
                case "PRS" -> ContactPointUse.MOBILE;
                default -> null;
            };
            result.setUse(cpu);

            ContactPointSystem cps = switch (type) {
                case "FX" -> ContactPointSystem.FAX;
                case "BP" -> ContactPointSystem.PAGER;
                default -> ContactPointSystem.PHONE;
            };
            result.setSystem(cps);

        }
        return result;
    }

    /**
     * FHIR Organization -> XDS Organization
     *
     * @param org
     * @return
     */
    public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization transformToXDSOrganization(Organization org) {
        org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization result = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization();
        Identifier identifier = org.getIdentifierFirstRep();

        result.setOrganizationName(org.getName());
        result.setIdNumber(identifier.getValue());
        result.setAssigningAuthority(new AssigningAuthority(removePrefixOid(identifier.getSystem())));

        return result;
    }

    /**
     * XDS Organization -> FHIR Organization
     *
     * @param org
     * @return
     */
    public static Organization transformToFHIROrganization(org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization org) {
        if (org == null) return null;

        Organization result = new Organization();
        result.setName(org.getOrganizationName());

        String id = org.getIdNumber();
        // TODO handle system not given
        // Rule: The organization SHALL at least have a name or an identifier, and possibly more than one

        if (org.getAssigningAuthority() != null) {
            String system = org.getAssigningAuthority().getUniversalId();
            result.addIdentifier().setSystem(addPrefixOid(system)).setValue(id);
        } else {
            result.addIdentifier().setValue(id);
        }

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

    /**
     * XDS Identifiable -> FHIR CodeableConcept
     * @param patient
     * @return
     */
    public static CodeableConcept transformToCodeableConcept(Identifiable patient) {
        Coding coding = new Coding();
        coding.setCode(patient.getId());

        if (patient.getAssigningAuthority() != null) {
            String system = addPrefixOid(patient.getAssigningAuthority().getUniversalId());
            coding.setSystem(system);
        }

        return new CodeableConcept().addCoding(coding);
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
                result.getAuthorInstitution().add(transformToXDSOrganization(org));

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
        if (name == null) return null;

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
    public static Patient transformToPatient(Person person) {
        if (person == null) return null;
        HumanName humanName = transformToHumanName(person.getName());
        Identifier identifier = transformToIdentifier(person.getId());

        return new Patient().addName(humanName).addIdentifier(identifier);
    }

    /**
     * XDS Person -> FHIR Practitioner
     * @param person
     * @return
     */
    public static Practitioner transformToPractitioner(Person person) {
        if (person == null) return null;
        HumanName humanName = transformToHumanName(person.getName());
        Identifier identifier = transformToIdentifier(person.getId());

        return new Practitioner().addName(humanName).addIdentifier(identifier);
    }

    /**
     * XDS Author -> FHIR Reference
     *
     * @param author
     * @return
     */
    public static Reference transformToReference(Author author) {
        Person person = author.getAuthorPerson();

        if (isPatientAuthor(author)) {
            Patient patient = transformToPatient(person);

            for (Telecom telecom : author.getAuthorTelecom()) {
                patient.addTelecom(transformToContactPoint(telecom));
            }

            return (Reference) new Reference().setResource(patient);
        }

        Practitioner containedPerson = transformToPractitioner(person);
        List<Telecom> telecoms = author.getAuthorTelecom();

        List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization> orgs = author.getAuthorInstitution();
        List<Identifiable> roles = author.getAuthorRole();
        List<Identifiable> specialities = author.getAuthorSpecialty();

        if (orgs.isEmpty() && roles.isEmpty() && specialities.isEmpty()) {
            for (Telecom telecom : telecoms) {
                containedPerson.addTelecom(transformToContactPoint(telecom));
            }

            return (Reference) new Reference().setResource(containedPerson);
        }

        PractitionerRole role = new PractitionerRole();
        if (containedPerson != null) {
            role.setPractitioner((Reference) new Reference().setResource(containedPerson));
        }

        for (Telecom telecom : telecoms) {
            role.addTelecom(transformToContactPoint(telecom));
        }

        for (var org : orgs) {
            role.setOrganization((Reference) new Reference().setResource(transformToFHIROrganization(org)));
        }

        for (var roleId : roles) {
            role.addCode(transformToCodeableConcept(roleId));
        }

        for (var specId : specialities) {
            role.addSpecialty(transformToCodeableConcept(specId));
        }

        return (Reference) new Reference().setResource(role);
    }
}
