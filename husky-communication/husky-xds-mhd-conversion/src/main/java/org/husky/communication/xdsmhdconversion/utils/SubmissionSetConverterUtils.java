package org.husky.communication.xdsmhdconversion.utils;

import ca.uhn.fhir.rest.server.exceptions.InvalidRequestException;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.husky.common.enums.LanguageCode;
import org.husky.communication.ch.enums.SubmissionSetAuthorRole;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Person;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Utilities for the converter between XDS' SubmissionSet and the equivalent MHD resource.
 *
 * @author Ronaldo Loureiro
 */
public class SubmissionSetConverterUtils {

    private static final String PREFIX_OID = "urn:oid:";
    private static final String PREFIX_UUID = "urn:uuid:";

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
    public static String addPrefixOid(@Nullable final String urn) {
        if (urn == null) return null;
        return urn.startsWith(PREFIX_OID) ? urn : PREFIX_OID + urn;
    }

    /**
     * Add the prefix "urn:uuid:"
     *
     * @param urn the uuid
     * @return the uuid with the prefix "urn:uuid:"
     */
    @Nullable
    public static String addPrefixUuid(@Nullable final String urn) {
        if (urn == null) return null;
        return urn.startsWith(PREFIX_UUID) ? urn : PREFIX_UUID + urn;
    }

    /**
     * Remove the prefix "urn:oid:"
     *
     * @param urn the oid
     * @return the oid without the prefix "urn:oid:"
     */
    @Nullable
    public static String removePrefixOid(@Nullable final String urn) {
        if (urn == null) return null;
        return urn.startsWith(PREFIX_OID) ? urn.substring(8) : urn;
    }

    /**
     * Remove the prefix "urn:uuid:"
     *
     * @param urn the uuid
     * @return the uuid without the prefix "urn:uuid:"
     */
    @Nullable
    public static String removePrefixUuid(@Nullable final String urn) {
        if (urn == null) return null;
        return urn.startsWith(PREFIX_UUID) ? urn.substring(9) : urn;
    }

    /**
     * search a referenced resource from a list of (contained) resources.
     *
     * @param ref the desired reference
     * @param contained the list of resources
     * @return the resource corresponding to the reference if available
     */
    @Nullable
    public static Resource findResource(final Reference ref,
                                        final List<Resource> contained) {

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
    public static LocalizedString getLocalizedString(@Nullable final String string,
                                                     @Nullable String languageCode) {
        languageCode = LanguageCode.isInValueSet(languageCode) ? languageCode : null;
        return string != null ? new LocalizedString(string, languageCode, "UTF-8") : null;
    }

    /**
     * FHIR Identifier -> XDS Identifiable
     *
     * @param identifier FHIR Identifier
     * @return XDS Identifiable
     */
    public static Identifiable transformToIdentifiable(final Identifier identifier) {
        final String system = removePrefixOid(identifier.getSystem());
        return new Identifiable(identifier.getValue(), new AssigningAuthority(system));
    }

    /**
     * FHIR CodeableConcept -> XDS Identifiable
     *
     * @param cc FHIR CodeableConcept
     * @return XDS Identifiable
     */
    @Nullable
    public static Identifiable transformToIdentifiable(@Nullable final CodeableConcept cc,
                                                       @Nullable final String languageCode) {
        final Code code = transformToCode(cc, languageCode);
        return code != null ? new Identifiable(code.getCode(), new AssigningAuthority(code.getSchemeName())) : null;
    }

    /**
     * XDS Identifiable -> FHIR Identifier
     *
     * @param identifiable XDS Identifiable
     * @return FHIR Identifier
     */
    @Nullable
    public static Identifier transformToIdentifier(@Nullable final Identifiable identifiable) {
        if (identifiable == null) return null;

        final AssigningAuthority assigningAuthority = identifiable.getAssigningAuthority();
        final String value = identifiable.getId();

        if (assigningAuthority == null && value == null) return null;

        final var result = new Identifier();
        if (assigningAuthority != null) {
            final String system = assigningAuthority.getUniversalId();
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
    public static Reference transformToPatientReference(final Identifiable patient) {
        final String system = patient.getAssigningAuthority().getUniversalId();
        final String value = patient.getId();
        return new Reference().setReference(system + "-" + value);
    }

    /**
     * FHIR HumanName -> XDS Name
     *
     * @param name FHIR HumanName
     * @return XDS Name
     */
    public static XpnName transformToName(final HumanName name) {
        final var targetName = new XpnName();

        if (name.hasPrefix()) targetName.setPrefix(name.getPrefixAsSingleString());
        if (name.hasSuffix()) targetName.setSuffix(name.getSuffixAsSingleString());

        targetName.setFamilyName(name.getFamily());
        final List<StringType> givens = name.getGiven();

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
     * @param practitioner FHIR Practitioner
     * @return XDS Person
     */
    @Nullable
    public static Person transformToPerson(@Nullable final Practitioner practitioner) {
        return practitioner != null ? transformToPerson(practitioner.getNameFirstRep(), practitioner.getIdentifierFirstRep()) : null;
    }

    /**
     * FHIR Patient -> XDS Person
     *
     * @param patient FHIR Patient
     * @return XDS Person
     */
    @Nullable
    public static Person transformToPerson(@Nullable final Patient patient) {
        return patient != null ? transformToPerson(patient.getNameFirstRep(), patient.getIdentifierFirstRep()) : null;
    }

    /**
     * FHIR RelatedPerson -> XDS Person
     *
     * @param related FHIR RelatedPerson
     * @return XDS Person
     */
    @Nullable
    public static Person transformToPerson(@Nullable final RelatedPerson related) {
        return related != null ? transformToPerson(related.getNameFirstRep(), related.getIdentifierFirstRep()) : null;
    }

    /**
     * FHIR -> XDS Person
     *
     * @param name the person's name
     * @param identifier FHIR Identifier
     * @return XDS Person
     */
    private static Person transformToPerson(@Nullable final HumanName name,
                                            final Identifier identifier) {
        final var result = new Person();
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
    public static Telecom transformToTelecom(@Nullable final ContactPoint contactPoint) {
        if (contactPoint == null) return null;
        final var result = new Telecom();

        if (contactPoint.getSystem() == ContactPointSystem.EMAIL || contactPoint.getSystem() == ContactPointSystem.URL) {
            result.setEmail(contactPoint.getValue());
            result.setUse("NET");
            result.setType("Internet");
        } else {
            result.setUnformattedPhoneNumber(contactPoint.getValue());
            if (contactPoint.hasSystem()) {
                final String system = switch (contactPoint.getSystem()) {
                    case SMS, PHONE -> "PH";
                    case FAX -> "FX";
                    case PAGER -> "BP";
                    default -> null;
                };
                result.setType(system);
            }

            if (contactPoint.hasUse()) {
                final String use = switch (contactPoint.getUse()) {
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
    public static ContactPoint transformToContactPoint(final Telecom telecom) {
        final var result = new ContactPoint();

        final String type = telecom.getType();
        final String use = telecom.getUse();

        if ("NET".equals(use) || "X.400".equals(type)) {
            result.setSystem(ContactPointSystem.EMAIL);
            result.setValue(telecom.getEmail());
        } else {
            result.setValue(telecom.getUnformattedPhoneNumber());

            final ContactPointUse cpu = switch (use) {
                case "WPN" -> ContactPointUse.WORK;
                case "PRN" -> ContactPointUse.HOME;
                case "PRS" -> ContactPointUse.MOBILE;
                default -> null;
            };
            result.setUse(cpu);

            final ContactPointSystem cps = switch (type) {
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
    public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization transformToXDSOrganization(@Nullable final Organization org) {
        if (org == null) return null;
        final var result = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization();
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
    public static Organization transformToFHIROrganization(final org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization org) {
        if (org == null) return null;

        final var result = new Organization();
        result.setName(org.getOrganizationName());

        final String id = org.getIdNumber();
        // TODO handle system not given
        // Rule: The organization SHALL at least have a name or an identifier, and possibly more than one

        if (org.getAssigningAuthority() != null) {
            final String system = org.getAssigningAuthority().getUniversalId();
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
    public static Code transformToCode(@Nullable final Coding coding,
                                       @Nullable final String languageCode) {
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
    public static Code transformToCode(@Nullable final CodeableConcept cc,
                                       @Nullable final String languageCode) {
        return cc != null ? transformToCode(cc.getCodingFirstRep(), languageCode) : null;
    }

    /**
     * XDS code -> FHIR CodeableConcept
     *
     * @param code XDS code
     * @return FHIR CodeableConcept
     */
    public static CodeableConcept transformToCodeableConcept(final Code code) {
        final String display = code.getDisplayName() == null ? " ": code.getDisplayName().getValue();
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
     public static CodeableConcept transformToCodeableConcept(final Identifiable patient) {
        final var coding = new Coding();
        coding.setCode(patient.getId());

        if (patient.getAssigningAuthority() != null) {
            final String system = addPrefixOid(patient.getAssigningAuthority().getUniversalId());
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
    private static boolean isPatientAuthor(@Nullable final Author author) {
        if (author != null && author.getAuthorRole() != null) {
            final Set<String> patientRoles = Set.of(SubmissionSetAuthorRole.PATIENT_CODE, SubmissionSetAuthorRole.REPRESENTATIVE_CODE);

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
    public static Author transformAuthor(@Nullable final Reference author,
                                         final List<Resource> contained,
                                         @Nullable Identifiable authorRole,
                                         @Nullable final String languageCode) {
        if (author == null || author.getReference() == null) {
            if (authorRole != null) {
                final var result = new Author();
                final var person = new Person();
                // CARA PMP
                // TODO At least an authorPerson, authorTelecommunication, or authorInstitution sub-attribute must be present
                // Either authorPerson, authorInstitution or authorTelecom shall be specified in the SubmissionSet [IHE ITI Technical Framework Volume 3 (4.2.3.1.4)].
                person.setName(transformToName(new HumanName().setFamily("---")));
                result.setAuthorPerson(person);
                result.getAuthorRole().add(authorRole);
                return result;
            }
            return null;
        }

        final Resource authorObj = findResource(author, contained);
        if (authorObj instanceof Practitioner practitioner) {
            final var result = new Author();
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
            final var result = new Author();
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
            final var result = new Author();

            final var practitioner = (Practitioner) findResource(role.getPractitioner(), contained);
            if (practitioner != null)
                result.setAuthorPerson(transformToPerson(practitioner));

            final var org = (Organization) findResource(role.getOrganization(), contained);
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
    public static HumanName transformToHumanName(@Nullable final Name<?> name) {
        if (name == null) return null;

        final var result = new HumanName();

        if (name.getPrefix() != null) {
            result.addPrefix(name.getPrefix());
        }

        if (name.getSuffix() != null) {
            result.addSuffix(name.getSuffix());
        }

        if (name.getGivenName() != null) {
            result.addGiven(name.getGivenName());
        }

        result.setFamily(name.getFamilyName());

        final String more = name.getSecondAndFurtherGivenNames();
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
     * @param person XDS Person
     * @return FHIR Patient
     */
    @Nullable
    public static Patient transformToPatient(@Nullable final Person person) {
        if (person == null) return null;
        final HumanName humanName = transformToHumanName(person.getName());
        final Identifier identifier = transformToIdentifier(person.getId());

        return new Patient().addName(humanName).addIdentifier(identifier);
    }

    /**
     * XDS Person -> FHIR Practitioner
     *
     * @param person XDS Person
     * @return FHIR Practitioner
     */
    @Nullable
    public static Practitioner transformToPractitioner(@Nullable final Person person) {
        if (person == null) return null;
        final HumanName humanName = transformToHumanName(person.getName());
        final Identifier identifier = transformToIdentifier(person.getId());

        return new Practitioner().addName(humanName).addIdentifier(identifier);
    }

    /**
     * XDS Author -> FHIR Reference
     *
     * @param author XDS Author
     * @return FHIR Reference
     */
    public static Reference transformToReference(final Author author) {
        final Person person = author.getAuthorPerson();

        if (isPatientAuthor(author)) {
            final Patient patient = transformToPatient(person);
            if (patient != null) {
                for (Telecom telecom : author.getAuthorTelecom()) {
                    patient.addTelecom(transformToContactPoint(telecom));
                }
            }

            return (Reference) new Reference().setResource(patient);
        }

        final Practitioner containedPerson = transformToPractitioner(person);
        final List<Telecom> telecoms = author.getAuthorTelecom();

        final List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization> orgs = author.getAuthorInstitution();
        final List<Identifiable> roles = author.getAuthorRole();
        final List<Identifiable> specialities = author.getAuthorSpecialty();

        if (orgs.isEmpty() && roles.isEmpty() && specialities.isEmpty()) {
            if (containedPerson != null) {
                for (Telecom telecom : telecoms) {
                    containedPerson.addTelecom(transformToContactPoint(telecom));
                }
            }

            return (Reference) new Reference().setResource(containedPerson);
        }

        var role = new PractitionerRole();
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
