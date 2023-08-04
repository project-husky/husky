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
package org.projecthusky.communication.xds_mhd;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.*;
import org.jetbrains.annotations.Contract;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Person;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;
import org.projecthusky.common.utils.datatypes.Oids;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Converter of data types from XDS to MHD.
 *
 * @author Quentin Ligier
 * @author Alexander Kreutz
 **/
public class XdsToMhdTypeConverter {

    /**
     * This class is not instantiable.
     */
    private XdsToMhdTypeConverter() {
    }

    public static CodeableConcept toCodeableConcept(final Code code) {
        return new CodeableConcept().addCoding(new Coding()
                    .setCode(code.getCode())
                    .setSystem(SystemMapper.oidToUri(code.getSchemeName()))
                    .setDisplay(code.getDisplayName() == null ? "" : code.getDisplayName().getValue())
        );
    }

    public static CodeableConcept toCodeableConcept(final List<Code> codes) {
        final var cc = new CodeableConcept();
        if (codes != null) {
            for (final Code code : codes) {
                cc.addCoding(new Coding()
                                     .setCode(code.getCode())
                                     .setSystem(SystemMapper.oidToUri(code.getSchemeName()))
                                     .setDisplay(code.getDisplayName() == null ? "" : code.getDisplayName().getValue())
                );
            }
        }
        return cc;
    }

    public static List<CodeableConcept> toCodeableConcepts(final List<Code> codes) {
        final var ccList = new ArrayList<CodeableConcept>();
        if (codes != null) {
            for (final Code code : codes) {
                ccList.add(toCodeableConcept(code));
            }
        }
        return ccList;
    }

    @Contract("null->null;!null->!null")
    public static @Nullable DateTimeType toDateTime(final @Nullable Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        final Date date = Date.from(timestamp.getDateTime().toInstant());
        final Timestamp.Precision precision = timestamp.getPrecision();
        final TemporalPrecisionEnum fhirPrecision = switch (precision) {
            case YEAR -> TemporalPrecisionEnum.YEAR;
            case DAY -> TemporalPrecisionEnum.DAY;
            case HOUR -> TemporalPrecisionEnum.SECOND;
            case MINUTE -> TemporalPrecisionEnum.SECOND;
            case SECOND -> TemporalPrecisionEnum.SECOND;
            default -> TemporalPrecisionEnum.MILLI;
        };
        return new DateTimeType(date, fhirPrecision);
    }

    @Contract("null->null;!null->!null")
    public static @Nullable DateType toDate(final @Nullable Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        final Date date = Date.from(timestamp.getDateTime().toInstant());
        final Timestamp.Precision precision = timestamp.getPrecision();
        final TemporalPrecisionEnum fhirPrecision = switch (precision) {
            case YEAR -> TemporalPrecisionEnum.YEAR;
            case DAY -> TemporalPrecisionEnum.DAY;
            // There is no mapping for HOUR
            //case HOUR: fhirPrecision = TemporalPrecisionEnum.MINUTE;break;
            //case MINUTE: fhirPrecision = TemporalPrecisionEnum.MINUTE;break;
            //case SECOND: fhirPrecision = TemporalPrecisionEnum.SECOND;break;
            default -> TemporalPrecisionEnum.DAY;
        };
        return new DateType(date, fhirPrecision);
    }

    public static Reference toReference(final ReferenceId ref) {
        final String id = ref.getId();
        final var authority = ref.getAssigningAuthority();
        // TODO handle authority not given
        if (authority != null) {
            return new Reference().setIdentifier(new Identifier().setValue(id).setSystem(SystemMapper.oidToUri(authority.getUniversalId())));
        } else {
            return new Reference().setIdentifier(new Identifier().setValue(id));
        }
    }

    @Contract("null->null;!null->!null")
    public static @Nullable Practitioner toPractitioner(final org.openehealth.ipf.commons.ihe.xds.core.metadata.@Nullable Person person) {
        if (person == null) {
            return null;
        }
        final var practitioner = new Practitioner();
        final Name<?> name = person.getName();
        if (name != null) {
            practitioner.addName(toHumanName(name));
        }
        if (person.getId() != null) {
            practitioner.addIdentifier(toIdentifier(person.getId()));
        }
        return practitioner;
    }

    @Contract("null->null;!null->!null")
    public static @Nullable Patient toPatient(final org.openehealth.ipf.commons.ihe.xds.core.metadata.@Nullable Person person) {
        if (person == null) {
            return null;
        }
        final var patient = new Patient();
        final Name<?> name = person.getName();
        if (name != null) {
            patient.addName(toHumanName(name));
        }
        if (person.getId() != null) {
            patient.addIdentifier(toIdentifier(person.getId()));
        }
        return patient;
    }

    @Contract("null->null;!null->!null")
    public static @Nullable Organization toOrganization(final org.openehealth.ipf.commons.ihe.xds.core.metadata.@Nullable Organization org) {
        if (org == null) {
            return null;
        }
        final var result = new Organization();
        result.setName(org.getOrganizationName());
        final String id = org.getIdNumber();
        // TODO handle system not given

        if (org.getAssigningAuthority() != null) {
            final String system = org.getAssigningAuthority().getUniversalId();
            result.addIdentifier().setSystem(Oids.PREFIX_OID + system).setValue(id);
        } else {
            result.addIdentifier().setValue(id);
        }
        return result;
    }

    public static ContactPoint toContactPoint(final Telecom telecom) {
        final var result = new ContactPoint();
        final String type = telecom.getType();
        final String use = telecom.getUse();

        if ("NET".equals(use) || "X.400".equals(type)) {
            result.setSystem(ContactPoint.ContactPointSystem.EMAIL);
            result.setValue(telecom.getEmail());
        } else {
            final String phone = telecom.getUnformattedPhoneNumber();
            result.setValue(phone);
            if ("WPN".equals(use)) {
                result.setUse(ContactPoint.ContactPointUse.WORK);
            } else if ("PRN".equals(use)) {
                result.setUse(ContactPoint.ContactPointUse.HOME);
            }

            if ("FX".equals(type)) {
                result.setSystem(ContactPoint.ContactPointSystem.FAX);
            } else if ("BP".equals(type)) {
                result.setSystem(ContactPoint.ContactPointSystem.PAGER);
            } else if ("CP".equals(type)) {
                result.setSystem(ContactPoint.ContactPointSystem.PHONE);
                result.setUse(ContactPoint.ContactPointUse.MOBILE);
            } else {
                result.setSystem(ContactPoint.ContactPointSystem.PHONE);
            }
        }

        return result;
    }

    public static HumanName toHumanName(final Name<?> name) {
        final var result = new HumanName();
        if (name.getPrefix() != null) {
            result.addPrefix(name.getPrefix());
        }
        if (name.getSuffix() != null) {
            result.addSuffix(name.getSuffix());
        }
        result.setFamily(name.getFamilyName()).addGiven(name.getGivenName());
        final String more = name.getSecondAndFurtherGivenNames();
        if (more != null) {
            for (final String extraName : more.split(" ")) {
                result.addGiven(extraName);
            }
        }
        return result;
    }

    public static org.hl7.fhir.r4.model.Address toAddress(final org.openehealth.ipf.commons.ihe.xds.core.metadata.Address address) {
        final var result = new org.hl7.fhir.r4.model.Address();
        result.setCity(address.getCity());
        result.setCountry(address.getCountry());
        result.setDistrict(address.getCountyParishCode());
        result.setState(address.getStateOrProvince());
        result.setPostalCode(address.getZipOrPostalCode());
        final String street = address.getStreetAddress();
        if (street != null) {
            result.addLine(street);
        }
        final String other = address.getOtherDesignation();
        if (other != null) {
            result.addLine(other);
        }

        return result;
    }

    @Contract("null->null;!null->!null")
    public static @Nullable Narrative toNarrative(final @Nullable LocalizedString in) {
        if (in == null) {
            return null;
        }
        final var result = new Narrative();
        result.setStatus(org.hl7.fhir.r4.model.Narrative.NarrativeStatus.GENERATED);
        result.setDivAsString(in.getValue());
        return result;
    }

    public static CodeableConcept toCodeableConcept(final Identifiable patient) {
        final var result = new CodeableConcept();
        final Coding coding = result.addCoding();
        final AssigningAuthority assigningAuthority = patient.getAssigningAuthority();
        final String value = patient.getId();
        if (assigningAuthority != null) {
            final String system = assigningAuthority.getUniversalId();
            coding.setSystem(Oids.PREFIX_OID + system);
        }
        coding.setCode(value);
        return result;
    }

    @Contract("null->null;!null->!null")
    public static @Nullable Identifier toIdentifier(final @Nullable Identifiable identifiable) {
        if (identifiable == null) {
            return null;
        }
        final var result = new Identifier();
        final AssigningAuthority assigningAuthority = identifiable.getAssigningAuthority();
        final String value = identifiable.getId();
        if (assigningAuthority != null) {
            final String system = assigningAuthority.getUniversalId();
            result.setSystem(Oids.PREFIX_OID + system);
        }
        result.setValue(value);
        return result;
    }

    public static Reference transformAuthor(final Author author) {
        final Person person = author.getAuthorPerson();

        if (XdsUtils.isPatientAuthor(author)) {
            final Patient patient = toPatient(person);
            final var result = new Reference();
            final List<Telecom> telecoms = author.getAuthorTelecom();
            for (final Telecom telecom : telecoms) {
                patient.addTelecom(toContactPoint(telecom));
            }
            result.setResource(patient);
            return result;
        }

        final Practitioner containedPerson = toPractitioner(person);
        PractitionerRole role = null;

        final List<org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization> orgs = author.getAuthorInstitution();
        final List<Identifiable> roles = author.getAuthorRole();
        final List<Identifiable> specialities = author.getAuthorSpecialty();

        if (!orgs.isEmpty() || !roles.isEmpty() || !specialities.isEmpty()) {
            role = new PractitionerRole();
            if (containedPerson != null) {
                role.setPractitioner((Reference) new Reference().setResource(containedPerson));
            }
        }

        for (final org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization org : orgs) {
            role.setOrganization((Reference) new Reference().setResource(toOrganization(org)));
        }

        for (final Identifiable roleId : roles) {
            role.addCode(toCodeableConcept(roleId));
        }

        for (final Identifiable specId : specialities) {
            role.addSpecialty(toCodeableConcept(specId));
        }

        final Reference result = new Reference();
        final List<Telecom> telecoms = author.getAuthorTelecom();
        if (role == null) {
            for (final Telecom telecom : telecoms) {
                containedPerson.addTelecom(toContactPoint(telecom));
            }
            result.setResource(containedPerson);
        } else {
            for (final Telecom telecom : telecoms) {
                role.addTelecom(toContactPoint(telecom));
            }
            result.setResource(role);
        }
        return result;
    }
}
