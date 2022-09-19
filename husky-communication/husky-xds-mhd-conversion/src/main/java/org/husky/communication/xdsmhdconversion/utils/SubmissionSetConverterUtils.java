package org.husky.communication.xdsmhdconversion.utils;

import ca.uhn.fhir.rest.server.exceptions.InvalidRequestException;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.husky.common.enums.LanguageCode;
import org.husky.communication.ch.enums.SubmissionSetAuthorRole;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Person;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Objects;
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

    /**
     * Add the prefix "urn:oid:"
     *
     * @param urn the oid
     * @return the oid with the prefix "urn:oid:"
     */
    @Nullable
    public static String addPrefixOid(@Nullable String urn) {
        if (urn == null) return null;
        return urn.startsWith("urn:oid:") ? urn : "urn:oid:" + urn;
    }

    /**
     * Add the prefix "urn:uuid:"
     *
     * @param urn the uuid
     * @return the uuid with the prefix "urn:uuid:"
     */
    @Nullable
    public static String addPrefixUuid(@Nullable String urn) {
        if (urn == null) return null;
        return urn.startsWith("urn:uuid:") ? urn : "urn:uuid:" + urn;
    }

    /**
     * Remove the prefix "urn:oid:"
     *
     * @param urn the oid
     * @return the oid without the prefix "urn:oid:"
     */
    @Nullable
    public static String removePrefixOid(@Nullable String urn) {
        if (urn == null) return null;
        return urn.startsWith("urn:oid:") ? urn.substring(8) : urn;
    }

    /**
     * Remove the prefix "urn:uuid:"
     *
     * @param urn the uuid
     * @return the uuid without the prefix "urn:uuid:"
     */
    @Nullable
    public static String removePrefixUuid(@Nullable String urn) {
        if (urn == null) return null;
        return urn.startsWith("urn:uuid:") ? urn.substring(9) : urn;
    }

    /**
     * search a referenced resource from a list of (contained) resources.
     *
     * @param ref the desired reference
     * @param contained the list of resources
     * @return the resource corresponding to the reference if available
     */
    @Nullable
    public static Resource findResource(Reference ref,
                                        List<Resource> contained) {

        for (Resource res : contained) {
            if (res.getId().equals(ref.getReference())) {
                return res;
            }
        }
        return null;
    }

    /**
     * Wrap string in localized string
     *
     * @param string string to wrap
     * @param languageCode language of the resource content
     * @return the localized string
     */
    @Nullable
    public static LocalizedString getLocalizedString(@Nullable String string,
                                                     @Nullable String languageCode) {
        // FIX FOR CARA
        languageCode = LanguageCode.isInValueSet(languageCode) ? languageCode : null;
        return string != null ? new LocalizedString(string, languageCode, "UTF-8") : null;
    }

    /**
     * FHIR Identifier -> XDS Identifiable
     *
     * @param identifier FHIR Identifier
     * @return XDS Identifiable
     */
    public static Identifiable transformToIdentifiable(Identifier identifier) {
        String system = removePrefixOid(identifier.getSystem());
        return new Identifiable(identifier.getValue(), new AssigningAuthority(system));
    }

    /**
     * FHIR CodeableConcept -> XDS Identifiable
     *
     * @param cc FHIR CodeableConcept
     * @return XDS Identifiable
     */
    @Nullable
    public static Identifiable transformToIdentifiable(@Nullable CodeableConcept cc,
                                                       @Nullable String languageCode) {
        Code code = transformToCode(cc, languageCode);
        return code != null ? new Identifiable(code.getCode(), new AssigningAuthority(code.getSchemeName())) : null;
    }

    /**
     * XDS Identifiable -> FHIR Identifier
     *
     * @param identifiable XDS Identifiable
     * @return FHIR Identifier
     */
    @Nullable
    public static Identifier transformToIdentifier(@Nullable Identifiable identifiable) {
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
     * @param patient XDS Identifiable
     * @return FHIR Patient Reference
     */
    public static Reference transformToPatientReference(Identifiable patient) {
        String system = patient.getAssigningAuthority().getUniversalId();
        String value = patient.getId();
        return new Reference().setReference(system + "-" + value);
    }

    /**
     * FHIR HumanName -> XDS Name
     *
     * @param name FHIR HumanName
     * @return XDS Name
     */
    public static Name transformToName(HumanName name) {
        Name targetName = new XpnName();

        if (name.hasPrefix()) targetName.setPrefix(name.getPrefixAsSingleString());
        if (name.hasSuffix()) targetName.setSuffix(name.getSuffixAsSingleString());

        targetName.setFamilyName(name.getFamily());
        List<StringType> givens = name.getGiven();

        if (!givens.isEmpty()) {
            targetName.setGivenName(givens.get(0).getValue());
            targetName.setSecondAndFurtherGivenNames(String.join(StringUtils.SPACE, givens.stream()
                    .skip(1)
                    .map(StringType::getValue)
                    .toList()));
        }
        return targetName;
    }

    /**
     * FHIR Practitioner -> XDS Person
     *
     * @param practitioner FHIR Practitioner
     * @return XDS Person
     */
    @Nullable
    public static Person transformToPerson(@Nullable Practitioner practitioner) {
        return practitioner != null ? transformToPerson(practitioner.getNameFirstRep(), practitioner.getIdentifierFirstRep()) : null;
    }

    /**
     * FHIR Patient -> XDS Person
     *
     * @param patient FHIR Patient
     * @return XDS Person
     */
    @Nullable
    public static Person transformToPerson(@Nullable Patient patient) {
        return patient != null ? transformToPerson(patient.getNameFirstRep(), patient.getIdentifierFirstRep()) : null;
    }

    /**
     * FHIR RelatedPerson -> XDS Person
     *
     * @param related FHIR RelatedPerson
     * @return XDS Person
     */
    @Nullable
    public static Person transformToPerson(@Nullable RelatedPerson related) {
        return related != null ? transformToPerson(related.getNameFirstRep(), related.getIdentifierFirstRep()) : null;
    }

    /**
     * FHIR -> XDS Person
     *
     * @param name the person's name
     * @param identifier FHIR Identifier
     * @return XDS Person
     */
    private static Person transformToPerson(@Nullable HumanName name,
                                            Identifier identifier) {
        Person result = new Person();
        if (name != null) result.setName(transformToName(name));
        result.setId(transformToIdentifiable(identifier));
        return result;
    }

    /**
     * FHIR ContactPoint -> XDS Telecom
     *
     * @param contactPoint FHIR ContactPoint
     * @return XDS Telecom
     */
    @Nullable
    public static Telecom transformToTelecom(@Nullable ContactPoint contactPoint) {
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

                if (contactPoint.getUse() == ContactPointUse.MOBILE) result.setType("CP");
            }
        }
        return result;
    }

    /**
     * XDS Telecom -> FHIR ContactPoint
     *
     * @param telecom XDS Telecom
     * @return FHIR ContactPoint
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
     * @param org FHIR Organization
     * @return XDS Organization
     */
    public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization transformToXDSOrganization(@Nullable Organization org) {
        if (org == null) return null;
        var result = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization();
        Identifier identifier = org.getIdentifierFirstRep();

        result.setOrganizationName(org.getName());
        result.setIdNumber(identifier.getValue());
        result.setAssigningAuthority(new AssigningAuthority(removePrefixOid(identifier.getSystem())));

        return result;
    }

    /**
     * XDS Organization -> FHIR Organization
     *
     * @param org XDS Organization
     * @return FHIR Organization
     */
    @Nullable
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
     * @param coding FHIR Coding
     * @param languageCode the language of the resource content
     * @return XDS Code
     */
    @Nullable
    public static Code transformToCode(@Nullable Coding coding,
                                       @Nullable String languageCode) {
        return coding != null ? new Code(coding.getCode(), getLocalizedString(coding.getDisplay(), languageCode), new SchemeMapper().getScheme(coding.getSystem())) : null;
    }

    /**
     * FHIR CodeableConcept -> XDS Code
     *
     * @param cc FHIR CodeableConcept
     * @param languageCode the language of the resource content
     * @return XDS Code
     */
    @Nullable
    public static Code transformToCode(@Nullable CodeableConcept cc,
                                       @Nullable String languageCode) {
        return cc != null ? transformToCode(cc.getCodingFirstRep(), languageCode) : null;
    }

    /**
     * XDS code -> FHIR CodeableConcept
     *
     * @param code XDS code
     * @return FHIR CodeableConcept
     */
    public static CodeableConcept transformToCodeableConcept(Code code) {
        String display = code.getDisplayName() == null ? StringUtils.EMPTY : code.getDisplayName().getValue();
        return new CodeableConcept().addCoding(new Coding().setCode(code.getCode())
                .setSystem(new SchemeMapper().getSystem(code.getSchemeName()))
                .setDisplay(display));
    }

    /**
     * XDS Identifiable -> FHIR CodeableConcept
     *
     * @param patient XDS Identifiable
     * @return FHIR CodeableConcept
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

    /**
     * Check if the author is a patient
     *
     * @param author the author
     * @return true if the author is a patient else false
     */
    private static boolean isPatientAuthor(@Nullable Author author) {
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
     * @param author the author's reference
     * @param contained the list of resources
     * @param authorRole
     * @param languageCode language of the resource content
     * @return the author
     */
    @Nullable
    public static Author transformAuthor(@Nullable Reference author,
                                         List<Resource> contained,
                                         @Nullable Identifiable authorRole,
                                         @Nullable String languageCode) {
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
                    .filter(Objects::nonNull)
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
                    .filter(Objects::nonNull)
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
                    .map(code -> transformToIdentifiable(code, languageCode))
                    .filter(Objects::nonNull)
                    .toList());

            result.getAuthorSpecialty().addAll(role.getSpecialty().stream()
                    .map(code -> transformToIdentifiable(code, languageCode))
                    .filter(Objects::nonNull)
                    .toList());

            result.getAuthorTelecom().addAll(role.getTelecom().stream()
                    .map(SubmissionSetConverterUtils::transformToTelecom)
                    .filter(Objects::nonNull)
                    .toList());

            return result;
        } else throw new InvalidRequestException("Author role not supported.");
    }

    /**
     * XDS Name -> FHIR HumanName
     *
     * @param name XDS Name
     * @return FHIR HumanName
     */
    @Nullable
    public static HumanName transformToHumanName(@Nullable Name<?> name) {
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
            for (String extraName : more.split(StringUtils.SPACE)) {
                result.addGiven(extraName);
            }
        }
        return result;
    }

    /**
     * XDS Person -> FHIR Patient
     *
     * @param person XDS Person
     * @return FHIR Patient
     */
    @Nullable
    public static Patient transformToPatient(@Nullable Person person) {
        if (person == null) return null;
        HumanName humanName = transformToHumanName(person.getName());
        Identifier identifier = transformToIdentifier(person.getId());

        return new Patient().addName(humanName).addIdentifier(identifier);
    }

    /**
     * XDS Person -> FHIR Practitioner
     *
     * @param person XDS Person
     * @return FHIR Practitioner
     */
    @Nullable
    public static Practitioner transformToPractitioner(@Nullable Person person) {
        if (person == null) return null;
        HumanName humanName = transformToHumanName(person.getName());
        Identifier identifier = transformToIdentifier(person.getId());

        return new Practitioner().addName(humanName).addIdentifier(identifier);
    }

    /**
     * XDS Author -> FHIR Reference
     *
     * @param author XDS Author
     * @return FHIR Reference
     */
    public static Reference transformToReference(Author author) {
        Person person = author.getAuthorPerson();

        if (isPatientAuthor(author)) {
            Patient patient = transformToPatient(person);
            if (patient != null) {
                for (Telecom telecom : author.getAuthorTelecom()) {
                    patient.addTelecom(transformToContactPoint(telecom));
                }
            }

            return (Reference) new Reference().setResource(patient);
        }

        Practitioner containedPerson = transformToPractitioner(person);
        List<Telecom> telecoms = author.getAuthorTelecom();

        List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization> orgs = author.getAuthorInstitution();
        List<Identifiable> roles = author.getAuthorRole();
        List<Identifiable> specialities = author.getAuthorSpecialty();

        if (orgs.isEmpty() && roles.isEmpty() && specialities.isEmpty()) {
            if (containedPerson != null) {
                for (Telecom telecom : telecoms) {
                    containedPerson.addTelecom(transformToContactPoint(telecom));
                }
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
