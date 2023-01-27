package org.projecthusky.communication.xdsmhdconversion.utils;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import ca.uhn.fhir.rest.server.exceptions.InvalidRequestException;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.utils.XdsMetadataUtil;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.communication.ch.enums.stable.SubmissionSetAuthorRole;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Person;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.ZoneId;
import java.util.*;

/**
 * Utilities for the converter between XDS SubmissionSet and the equivalent MHD resource.
 *
 * @author Ronaldo Loureiro
 */
public class ConverterUtils {

    /**
     * Constructor.
     */
    private ConverterUtils() {
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
        return urn.startsWith(Oids.PREFIX_OID) ? urn : Oids.PREFIX_OID + urn;
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
        return urn.startsWith(Uuids.URN_PREFIX) ? urn : Uuids.URN_PREFIX + urn;
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
        return urn.startsWith(Oids.PREFIX_OID) ? urn.substring(Oids.PREFIX_OID.length()) : urn;
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
        return urn.startsWith(Uuids.URN_PREFIX) ? urn.substring(Uuids.URN_PREFIX.length()) : urn;
    }

    public static boolean isOid(@Nullable final String urn) {
        return urn != null && urn.matches("^([0-2])((\\.0)|(\\.[1-9]\\d*))*$");
    }

    /**
     * search a referenced resource from a list of (contained) resources.
     *
     * @param ref       the desired reference
     * @param contained the list of resources
     * @return the resource corresponding to the reference if available
     */
    @Nullable
    public static Resource findResource(final Reference ref,
                                        final List<Resource> contained) {
        return contained.stream()
                .filter(r -> r.getId().equals(ref.getReference()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Wrap string in localized string
     *
     * @param string       string to wrap
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
    public static Identifiable toIdentifiable(final Identifier identifier) {
        final var assigningAuthority = identifier.getSystem() != null ? new AssigningAuthority(identifier.getSystem()) : null;
        return new Identifiable(identifier.getValue(), assigningAuthority);
    }

    /**
     * FHIR CodeableConcept -> XDS Identifiable
     *
     * @param cc FHIR CodeableConcept
     * @return XDS Identifiable
     */
    @Nullable
    public static Identifiable toIdentifiable(@Nullable final CodeableConcept cc,
                                              @Nullable final String languageCode) {
        final Code code = toCode(cc, languageCode);
        return code != null ? new Identifiable(code.getCode(), new AssigningAuthority(code.getSchemeName())) : null;
    }

    /**
     * FHIR Reference -> XDS Identifiable
     * Only for References to Patients or Encounters
     * Identifier is extracted from contained resource or from Reference URL
     *
     * @param reference FHIR Reference
     * @param resources FHIR Resource list
     * @return XDS Identifiable
     */
    @Nullable
    public static Identifiable toIdentifiable(final Reference reference,
                                              final List<Resource> resources) {
        if (reference.hasReference()) {
            final String targetRef = reference.getReference();

            final Resource resource = findResource(reference, resources);

            if (resource instanceof Patient patient) {
                return toIdentifiable(patient.getIdentifierFirstRep());
            } else if (resource instanceof Encounter encounter) {
                return toIdentifiable(encounter.getIdentifierFirstRep());
            }

            final Identifiable result = getPatientReference(targetRef);
            if (result != null) return result;

            final MultiValueMap<String, String> vals = UriComponentsBuilder.fromUriString(targetRef).build().getQueryParams();
            if (vals.containsKey("identifier")) {
                final String ids = vals.getFirst("identifier");
                if (ids == null) return null;

                final String[] identifier = ids.split("\\|");
                if (identifier.length == 2) {
                    return new Identifiable(identifier[1], new AssigningAuthority(removePrefixOid(identifier[0])));
                }
            }

        } else if (reference.hasIdentifier()) {
            return toIdentifiable(reference.getIdentifier());
        }
        return null;
    }

    @Nullable
    private static Identifiable getPatientReference(final String reference) {
        final String basePath = "Patient/";
        if (reference.contains(basePath)) {
            final int start = reference.indexOf(basePath) + basePath.length();
            int end = reference.indexOf("?");
            if (end < 0) end = reference.length();

            return getPatientId(reference.substring(start, end));

        } else if (!reference.contains("/")) return getPatientId(reference);

        return null;
    }

    @Nullable
    private static Identifiable getPatientId(final String fullId) {
        int splitIdx = fullId.indexOf("-");
        if (splitIdx > 0 && fullId.substring(0, splitIdx).contains(".")) {
            final String id = fullId.substring(splitIdx + 1);
            final AssigningAuthority authority = new AssigningAuthority(new SchemeMapper().getScheme(fullId.substring(0, splitIdx)));
            return new Identifiable(id, authority);
        }
        return null;
    }

    /**
     * XDS Identifiable -> FHIR Identifier
     *
     * @param identifiable XDS Identifiable
     * @return FHIR Identifier
     */
    @Nullable
    public static Identifier toIdentifier(@Nullable final Identifiable identifiable) {
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
    public static Reference toPatientReference(final Identifiable patient) {
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
    public static XpnName toName(final HumanName name) {
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
    public static Person toPerson(@Nullable final Practitioner practitioner) {
        return practitioner != null ? toPerson(practitioner.getNameFirstRep(), practitioner.getIdentifierFirstRep()) : null;
    }

    /**
     * FHIR Patient -> XDS Person
     *
     * @param patient FHIR Patient
     * @return XDS Person
     */
    @Nullable
    public static Person toPerson(@Nullable final Patient patient) {
        return patient != null ? toPerson(patient.getNameFirstRep(), patient.getIdentifierFirstRep()) : null;
    }

    /**
     * FHIR RelatedPerson -> XDS Person
     *
     * @param related FHIR RelatedPerson
     * @return XDS Person
     */
    @Nullable
    public static Person toPerson(@Nullable final RelatedPerson related) {
        return related != null ? toPerson(related.getNameFirstRep(), related.getIdentifierFirstRep()) : null;
    }

    /**
     * FHIR -> XDS Person
     *
     * @param name       the person's name
     * @param identifier FHIR Identifier
     * @return XDS Person
     */
    private static Person toPerson(@Nullable final HumanName name,
                                   final Identifier identifier) {
        final var result = new Person();
        if (name != null) result.setName(toName(name));
        result.setId(toIdentifiable(identifier));
        return result;
    }

    /**
     * FHIR ContactPoint -> XDS Telecom
     *
     * @param contactPoint FHIR ContactPoint
     * @return XDS Telecom
     */
    @Nullable
    public static Telecom toTelecom(@Nullable final ContactPoint contactPoint) {
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
    public static ContactPoint toContactPoint(final Telecom telecom) {
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
    public static org.openehealth.ipf.commons.ihe.xds.core.metadata.@Nullable Organization toXDSOrganization(@Nullable final Organization org) {
        if (org == null) return null;
        final var result = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization();
        final Identifier identifier = org.getIdentifierFirstRep();

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
    public static Organization toFHIROrganization(final org.openehealth.ipf.commons.ihe.xds.core.metadata.@Nullable Organization org) {
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
     * @param coding       FHIR Coding
     * @param languageCode the language of the resource content
     * @return XDS Code
     */
    @Nullable
    public static Code toCode(@Nullable final Coding coding,
                              @Nullable final String languageCode) {
        if (coding == null) return null;

        final LocalizedString localizedString = getLocalizedString(coding.getDisplay(), languageCode);
        final String schemeName = new SchemeMapper().getScheme(coding.getSystem());
        return new Code(coding.getCode(), localizedString, schemeName);
    }

    /**
     * FHIR CodeableConcept -> XDS Code
     *
     * @param cc           FHIR CodeableConcept
     * @param languageCode the language of the resource content
     * @return XDS Code
     */
    @Nullable
    public static Code toCode(@Nullable final CodeableConcept cc,
                              @Nullable final String languageCode) {
        return cc != null ? toCode(cc.getCodingFirstRep(), languageCode) : null;
    }

    /**
     * FHIR CodeableConcept list -> XDS code
     *
     * @param ccs FHIR CodeableConcept list
     * @return XDS code
     */
    @Nullable
    public static Code toCode(@Nullable final List<CodeableConcept> ccs,
                              @Nullable final String languageCode) {
        if (ccs == null || ccs.isEmpty()) return null;
        return toCode(ccs.get(0), languageCode);
    }

    @Nullable
    public static List<Code> toCodes(@Nullable final List<CodeableConcept> ccs,
                                     @Nullable final String languageCode) {
        if (ccs == null || ccs.isEmpty()) return null;

        final List<Code> codes = new ArrayList<>();
        for (CodeableConcept cc : ccs) {
            Code code = toCode(cc, languageCode);
            if (code != null) codes.add(code);
        }
        return codes;
    }

    /**
     * XDS code -> FHIR Coding
     *
     * @param code XDS code
     * @return FHIR CodeableConcept
     */
    public static Coding toCoding(final Code code) {
        final String display = code.getDisplayName() == null ? " " : code.getDisplayName().getValue();
        return new Coding().setCode(code.getCode())
                .setSystem(new SchemeMapper().getSystem(code.getSchemeName()))
                .setDisplay(display);
    }

    /**
     * XDS code -> FHIR CodeableConcept
     *
     * @param code XDS code
     * @return FHIR CodeableConcept
     */
    public static CodeableConcept toCodeableConcept(final Code code) {
        return new CodeableConcept().addCoding(toCoding(code));
    }

    /**
     * XDS code list -> FHIR CodeableConcept
     *
     * @param codes XDS code list
     * @return FHIR CodeableConcept
     */
    public static CodeableConcept toCodeableConcept(@Nullable final List<Code> codes) {
        final var cc = new CodeableConcept();
        if (codes == null) return cc;

        for (final Code code : codes) {
            cc.addCoding(toCoding(code));
        }
        return cc;
    }

    /**
     * XDS Identifiable -> FHIR CodeableConcept
     *
     * @param patient XDS Identifiable
     * @return FHIR CodeableConcept
     */
    public static CodeableConcept toCodeableConcept(final Identifiable patient) {
        final var coding = new Coding();
        coding.setCode(patient.getId());

        if (patient.getAssigningAuthority() != null) {
            final String system = addPrefixOid(patient.getAssigningAuthority().getUniversalId());
            coding.setSystem(system);
        }

        return new CodeableConcept().addCoding(coding);
    }

    /**
     * XDS code list -> FHIR CodeableConcept list
     *
     * @param codes XDS code list
     * @return FHIR CodeableConcept list
     */
    public static List<CodeableConcept> toListCodeableConcept(@Nullable final List<Code> codes) {
        final List<CodeableConcept> codeableConcepts = new ArrayList<>();
        if (codes != null) {
            for (final Code code : codes) {
                codeableConcepts.add(toCodeableConcept(code));
            }
        }
        return codeableConcepts;
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
     * @param author       the author's reference
     * @param contained    the list of resources
     * @param authorRole   the id of the author's role
     * @param languageCode language of the resource content
     * @return the author
     */
    @Nullable
    public static Author toAuthor(@Nullable final Reference author,
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
                person.setName(toName(new HumanName().setFamily("---")));
                result.setAuthorPerson(person);
                result.getAuthorRole().add(authorRole);
                return result;
            }
            return null;
        }

        final Resource authorObj = findResource(author, contained);
        if (authorObj instanceof Practitioner practitioner) {
            final var result = new Author();
            result.setAuthorPerson(toPerson(practitioner));

            result.getAuthorTelecom().addAll(practitioner.getTelecom().stream()
                    .map(ConverterUtils::toTelecom)
                    .filter(Objects::nonNull)
                    .toList());

            if (authorRole == null) {
                authorRole = new Identifiable(SubmissionSetAuthorRole.HEALTHCARE_PROFESSIONAL_CODE, new AssigningAuthority(SubmissionSetAuthorRole.CODE_SYSTEM_ID));
            }

            result.getAuthorRole().add(authorRole);
            return result;
        } else if (authorObj instanceof Patient patient) {
            final var result = new Author();
            result.setAuthorPerson(toPerson(patient));

            result.getAuthorTelecom().addAll(patient.getTelecom().stream()
                    .map(ConverterUtils::toTelecom)
                    .filter(Objects::nonNull)
                    .toList());

            if (authorRole == null) {
                authorRole = new Identifiable(SubmissionSetAuthorRole.PATIENT_CODE, new AssigningAuthority(SubmissionSetAuthorRole.CODE_SYSTEM_ID));
            }

            result.getAuthorRole().add(authorRole);
            return result;
        } else if (authorObj instanceof PractitionerRole role) {
            final var result = new Author();

            final var practitioner = (Practitioner) findResource(role.getPractitioner(), contained);
            if (practitioner != null) {
                result.setAuthorPerson(toPerson(practitioner));
            }

            final var org = (Organization) findResource(role.getOrganization(), contained);
            if (org != null)
                result.getAuthorInstitution().add(toXDSOrganization(org));

            result.getAuthorRole().addAll(role.getCode().stream()
                    .map(code -> toIdentifiable(code, languageCode))
                    .filter(Objects::nonNull)
                    .toList());

            result.getAuthorSpecialty().addAll(role.getSpecialty().stream()
                    .map(code -> toIdentifiable(code, languageCode))
                    .filter(Objects::nonNull)
                    .toList());

            result.getAuthorTelecom().addAll(role.getTelecom().stream()
                    .map(ConverterUtils::toTelecom)
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
    public static HumanName toHumanName(@Nullable final Name<?> name) {
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
    public static Patient toPatient(@Nullable final Person person) {
        if (person == null) return null;
        final HumanName humanName = toHumanName(person.getName());
        final Identifier identifier = toIdentifier(person.getId());

        return new Patient().addName(humanName).addIdentifier(identifier);
    }

    /**
     * XDS sourcePatientInfo -> FHIR Patient
     *
     * @param sourcePatientId   XDS Identifiable
     * @param sourcePatientInfo XDS PatientInfo
     * @return FHIR Patient
     */
    @Nullable
    public static Patient toPatient(@Nullable final Identifiable sourcePatientId,
                                    @Nullable final PatientInfo sourcePatientInfo) {

        if (sourcePatientId == null && sourcePatientInfo == null) return null;

        final Patient patient = new Patient();

        if (sourcePatientInfo != null) {
            patient.setBirthDateElement(toDateType(sourcePatientInfo.getDateOfBirth()));

            if (sourcePatientInfo.getGender() != null) {
                final Enumerations.AdministrativeGender gender = switch (sourcePatientInfo.getGender()) {
                    case "F" -> Enumerations.AdministrativeGender.FEMALE;
                    case "M" -> Enumerations.AdministrativeGender.MALE;
                    case "A" -> Enumerations.AdministrativeGender.OTHER;
                    default -> Enumerations.AdministrativeGender.UNKNOWN;
                };
                patient.setGender(gender);
            }

            final var names = sourcePatientInfo.getNames();
            while (names.hasNext()) {
                patient.addName(toHumanName(names.next()));
            }

            final var addresses = sourcePatientInfo.getAddresses();
            while (addresses.hasNext()) {
                patient.addAddress(toAddress(addresses.next()));
            }
        }

        final Identifier patientId = ConverterUtils.toIdentifier(sourcePatientId);
        if (patientId != null) {
            patient.addIdentifier(patientId.setUse(Identifier.IdentifierUse.OFFICIAL));
        }

        return patient;
    }

    /**
     * FHIR Reference to Patient -> XDS PatientInfo
     *
     * @param ref       FHIR Reference to Patient
     * @param resources FHIR Resource list
     * @return XDS PatientInfo
     */
    @Nullable
    public static PatientInfo toPatientInfo(@Nullable final Reference ref,
                                            @Nullable final List<Resource> resources) {
        if (ref == null || !ref.hasReference() || resources == null) return null;

        final Resource resource = resources.stream()
                .filter(r -> r.getId().equals(ref.getReference()))
                .findFirst()
                .orElse(null);

        if (resource == null) return null;

        final var patient = (Patient) resource;

        final var patientInfo = new PatientInfo();
        if (patient.hasBirthDate()) {
            patientInfo.setDateOfBirth(
                    new Timestamp(patient.getBirthDate().toInstant().atZone(ZoneId.systemDefault()), Timestamp.Precision.SECOND)
            );
        }


        if (patient.hasGender()) {
            final String gender = switch (patient.getGender()) {
                case MALE -> "M";
                case FEMALE -> "F";
                case OTHER -> "A";
                default -> "U";
            };
            patientInfo.setGender(gender);
        }

        for (HumanName name : patient.getName()) {
            patientInfo.getNames().add(toName(name));
        }

        for (Address address : patient.getAddress()) {
            patientInfo.getAddresses().add(toAddress(address));
        }

        for (Identifier id : patient.getIdentifier()) {
            patientInfo.getIds().add(toIdentifiable(id));
        }

        return patientInfo;
    }

    /**
     * XDS Person -> FHIR Practitioner
     *
     * @param person XDS Person
     * @return FHIR Practitioner
     */
    @Nullable
    public static Practitioner toPractitioner(@Nullable final Person person) {
        if (person == null) return null;
        final HumanName humanName = toHumanName(person.getName());
        final Identifier identifier = toIdentifier(person.getId());

        return new Practitioner().addName(humanName).addIdentifier(identifier);
    }

    /**
     * XDS Author -> FHIR Reference
     *
     * @param author XDS Author
     * @return FHIR Reference
     */
    public static Reference toReference(final Author author) {
        final Person person = author.getAuthorPerson();

        if (isPatientAuthor(author)) {
            final Patient patient = toPatient(person);
            if (patient != null) {
                for (Telecom telecom : author.getAuthorTelecom()) {
                    patient.addTelecom(toContactPoint(telecom));
                }
            }

            return (Reference) new Reference().setResource(patient);
        }

        final Practitioner containedPerson = toPractitioner(person);
        final List<Telecom> telecoms = author.getAuthorTelecom();

        final List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization> orgs = author.getAuthorInstitution();
        final List<Identifiable> roles = author.getAuthorRole();
        final List<Identifiable> specialities = author.getAuthorSpecialty();

        if (orgs.isEmpty() && roles.isEmpty() && specialities.isEmpty()) {
            if (containedPerson != null) {
                for (Telecom telecom : telecoms) {
                    containedPerson.addTelecom(toContactPoint(telecom));
                }
            }

            return (Reference) new Reference().setResource(containedPerson);
        }

        final var role = new PractitionerRole();
        if (containedPerson != null) {
            role.setPractitioner((Reference) new Reference().setResource(containedPerson));
        }

        for (Telecom telecom : telecoms) {
            role.addTelecom(toContactPoint(telecom));
        }

        for (var org : orgs) {
            role.setOrganization((Reference) new Reference().setResource(toFHIROrganization(org)));
        }

        for (var roleId : roles) {
            role.addCode(toCodeableConcept(roleId));
        }

        for (var specId : specialities) {
            role.addSpecialty(toCodeableConcept(specId));
        }

        return (Reference) new Reference().setResource(role);
    }

    /**
     * XDS ReferenceId -> FHIR Reference
     *
     * @param refId XDS ReferenceId
     * @return FHIR Reference
     */
    public static Reference toReference(final ReferenceId refId) {
        final var id = new Identifier().setValue(refId.getId());
        final CXiAssigningAuthority authority = refId.getAssigningAuthority();

        if (authority != null) {
            id.setSystem(new SchemeMapper().getSystem(authority.getUniversalId()));
        }
        // TODO handle authority not given

        return new Reference().setIdentifier(id);
    }

    /**
     * FHIR Identifiable -> XDS ReferenceId
     *
     * @param id FHIR Identifiable
     * @return XDS ReferenceId
     */
    public static ReferenceId toReferenceId(Identifiable id) {
        final var refId = new ReferenceId();

        refId.setAssigningAuthority(new CXiAssigningAuthority(
                null,
                id.getAssigningAuthority().getUniversalId(),
                id.getAssigningAuthority().getUniversalIdType()));

        refId.setId(id.getId());

        return refId;
    }

    /**
     * XDS Timestamp -> FHIR DateTimeType
     *
     * @param timestamp XDS Timestamp
     * @return FHIR DateTimeType
     */
    @Nullable
    public static DateTimeType toDateTimeType(@Nullable final Timestamp timestamp) {
        if (timestamp == null) return null;
        final Date date = XdsMetadataUtil.convertDtmStringToDate(timestamp.toHL7());
        final Timestamp.Precision precision = timestamp.getPrecision();

        final TemporalPrecisionEnum fhirPrecision = switch (precision) {
            case YEAR -> TemporalPrecisionEnum.YEAR;
            case MONTH -> TemporalPrecisionEnum.MONTH;
            case DAY -> TemporalPrecisionEnum.DAY;
            case HOUR, MINUTE, SECOND -> TemporalPrecisionEnum.SECOND;
        };

        return new DateTimeType(date, fhirPrecision);
    }

    /**
     * XDS Timestamp -> FHIR DateType
     *
     * @param timestamp XDS Timestamp
     * @return FHIR DateType
     */
    @Nullable
    public static DateType toDateType(@Nullable final Timestamp timestamp) {
        if (timestamp == null) return null;
        final Date date = XdsMetadataUtil.convertDtmStringToDate(timestamp.toHL7());
        final Timestamp.Precision precision = timestamp.getPrecision();

        final TemporalPrecisionEnum fhirPrecision = switch (precision) {
            case YEAR -> TemporalPrecisionEnum.YEAR;
            case MONTH -> TemporalPrecisionEnum.MONTH;
            case DAY, HOUR, MINUTE, SECOND -> TemporalPrecisionEnum.DAY;
        };

        return new DateType(date, fhirPrecision);
    }

    /**
     * XDS Address -> FHIR Address
     *
     * @param address XDS Address
     * @return FHIR Address
     */
    @Nullable
    public static Address toAddress(final org.openehealth.ipf.commons.ihe.xds.core.metadata.@Nullable Address address) {
        if (address == null) return null;

        final var result = new org.hl7.fhir.r4.model.Address()
                .setCity(address.getCity())
                .setCountry(address.getCountry())
                .setDistrict(address.getCountyParishCode())
                .setState(address.getStateOrProvince())
                .setPostalCode(address.getZipOrPostalCode());

        final String street = address.getStreetAddress();
        if (street != null) result.addLine(street);

        final String other = address.getOtherDesignation();
        if (other != null) result.addLine(other);

        return result;
    }

    /**
     * FHIR Address -> XDS Address
     *
     * @param address FHIR Address
     * @return XDS Address
     */
    public static org.openehealth.ipf.commons.ihe.xds.core.metadata.Address toAddress(Address address) {
        final var targetAddress = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Address();

        targetAddress.setCity(address.getCity());
        targetAddress.setCountry(address.getCountry());
        targetAddress.setCountyParishCode(address.getDistrict());
        targetAddress.setStateOrProvince(address.getState());
        targetAddress.setZipOrPostalCode(address.getPostalCode());

        final List<String> streetAddressValues = address.getLine().stream()
                .map(StringType::getValue)
                .toList();

        targetAddress.setStreetAddress(String.join("\n", streetAddressValues));

        return targetAddress;
    }

    /**
     * FHIR Reference -> URI String
     *
     * @param ref FHIR Reference
     * @return URI String
     */
    @Nullable
    public static String toUriString(Reference ref) {
        if (ref.hasIdentifier()) {
            return ref.getIdentifier().getValue();
        }

        final String refId = removePrefixOid(ref.getReference());

        return refId != null ? new IdType(refId).getIdPart() : null;
    }
}