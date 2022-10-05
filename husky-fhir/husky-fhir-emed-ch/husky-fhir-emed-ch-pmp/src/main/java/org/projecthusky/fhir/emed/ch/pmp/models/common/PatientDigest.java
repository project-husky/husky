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
package org.projecthusky.fhir.emed.ch.pmp.models.common;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.AdministrativeGender;

import javax.annotation.concurrent.Immutable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents the digest of a patient in an Emed document.
 * <p>
 * Creating these digests is typically done from a CDA-CH-EMED document with the digesters.
 *
 * @param ids        The list of patient Ids.
 * @param givenName  The legal given name.
 * @param familyName The legal family name.
 * @param gender     The gender or {@code null}.
 * @param birthdate  The birthdate or {@code null}.
 * @author Quentin Ligier
 */
@Immutable
public record PatientDigest(List<@NonNull QualifiedIdentifier> ids,
                            String givenName,
                            String familyName,
                            @Nullable AdministrativeGender gender,
                            @Nullable LocalDate birthdate) {

    /**
     * Constructor.
     *
     * @param ids        The list of patient Ids.
     * @param givenName  The legal given name.
     * @param familyName The legal family name.
     * @param gender     The gender or {@code null}.
     * @param birthdate  The birthdate or {@code null}.
     */
    public PatientDigest(final List<@NonNull QualifiedIdentifier> ids,
                         final String givenName,
                         final String familyName,
                         @Nullable final AdministrativeGender gender,
                         @Nullable final LocalDate birthdate) {
        this.ids = Collections.unmodifiableList(Objects.requireNonNull(ids));
        this.givenName = Objects.requireNonNull(givenName);
        this.familyName = Objects.requireNonNull(familyName);
        this.gender = gender;
        this.birthdate = birthdate;
    }

    /**
     * Returns the "usual" human name.
     */
    public String getHumanName() {
        return String.join(" ", this.givenName, this.familyName);
    }

    @Override
    public String toString() {
        return "PatientDigest{" +
                "ids=" + ids +
                ", givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", gender=" + gender +
                ", birthdate=" + birthdate +
                '}';
    }
}
