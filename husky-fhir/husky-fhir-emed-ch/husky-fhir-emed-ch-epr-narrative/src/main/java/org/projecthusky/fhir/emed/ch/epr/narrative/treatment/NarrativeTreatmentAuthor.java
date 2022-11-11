package org.projecthusky.fhir.emed.ch.epr.narrative.treatment;

import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;

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

    private String organization;

    public NarrativeTreatmentAuthor(final Author author) {
//        final var practitioner = author.resolvePractitioner();
//        final var organization = author.resolveOrganization();
//        final var address = organization.resolveAddress();
//
//        this.name = String.format("%s %s", practitioner.resolveName().getGivenAsSingleString(), practitioner.resolveName().getFamily());
//        this.organization = organization.getName();
//        this.address = String.format("%s %s %s", address.getLine(), address.getPostalCode(), address.getCity());
    }
}
