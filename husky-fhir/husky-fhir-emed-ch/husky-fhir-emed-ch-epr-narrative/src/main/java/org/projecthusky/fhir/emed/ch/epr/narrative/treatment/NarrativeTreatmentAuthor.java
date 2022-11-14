package org.projecthusky.fhir.emed.ch.epr.narrative.treatment;

import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Device;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.StringType;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.common.resource.ChEmedOrganization;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitioner;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;

/**
 * Represents the author of an eMed document, section or item entry
 *
 * @author Ronaldo Loureiro
 */
@Data
public class NarrativeTreatmentAuthor {

    private String name;

    @Nullable
    private String address;

    @Nullable
    private String organization;

    public NarrativeTreatmentAuthor(final Author author) {
        if (author.getPractitioner() != null) {
            setPractitioner(author.getPractitioner());
        } else if (author.getPractitionerRole() != null) {
            setPractitionerRole(author.getPractitionerRole());
        } else if (author.getPatient() != null) {
            setPatient(author.getPatient());
        } else if (author.getOrganization() != null) {
            setOrganization(author.getOrganization());
        } else if (author.getDevice() != null) {
            setDevice(author.getDevice());
        }
    }

    public void setPractitioner(final ChEmedEprPractitioner author) {
        setName(author.resolveName());

        setAddress(author.resolveAddress());
    }

    public void setPractitionerRole(final ChEmedEprPractitionerRole author) {
        final var practitioner = author.resolvePractitioner();
        final var organization = author.resolveOrganization();

        setName(practitioner.resolveName());

        setAddress(organization.resolveAddress());

        this.organization = organization.getName();
    }

    public void setPatient(final ChCorePatientEpr author) {
        setName(author.resolveName());

        final var address = author.resolveAddress();
        if (address != null) {
            setAddress(address);
        }
    }

    public void setOrganization(final ChEmedOrganization author) {
        this.name = author.getName();

        setAddress(author.resolveAddress());
    }

    public void setDevice(final Device author) {
        this.name = author.getDeviceNameFirstRep().getName();

        if (author.hasOwner() && author.getOwner().getResource() instanceof ChEmedOrganization organization) {
            setAddress(organization.getAddressFirstRep());
            this.organization = organization.getName();
        }
    }

    public void setName(final HumanName name) {
        this.name = String.format("%s %s", name.getGivenAsSingleString(), name.getFamily());
    }

    public void setAddress(final Address address) {
        final var line = String.join(" ",
                address.getLine()
                        .stream()
                        .map(StringType::getValue)
                        .toList());
        this.address = String.format("%s, %s %s", line, address.getPostalCode(), address.getCity());
    }
}
