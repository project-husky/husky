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
package org.projecthusky.fhir.emed.ch.pmp.model.common;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

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
 * @param givenNames The given name(s).
 * @param familyName The family name or {@code null}.
 * @param gender     The gender or {@code null}.
 * @param birthdate  The birthdate or {@code null}.
 * @author Quentin Ligier
 * @todo use the FHIR gender enum.
 */
@Immutable
public record PatientDigest(List<@NonNull QualifiedIdentifier> ids,
                            List<@NonNull String> givenNames,
                            @Nullable String familyName,
                            @Nullable AdministrativeGender gender,
                            @Nullable LocalDate birthdate) {

    /**
     * Constructor.
     *
     * @param ids        The list of patient Ids.
     * @param givenNames  The legal given name(s).
     * @param familyName The legal family name or {@code null}.
     * @param gender     The gender or {@code null}.
     * @param birthdate  The birthdate or {@code null}.
     */
    public PatientDigest(final List<@NonNull QualifiedIdentifier> ids,
                         final List<@NonNull String> givenNames,
                         @Nullable final String familyName,
                         @Nullable final AdministrativeGender gender,
                         @Nullable final LocalDate birthdate) {
        this.ids = Collections.unmodifiableList(Objects.requireNonNull(ids));
        this.givenNames = Objects.requireNonNull(givenNames);
        this.familyName = Objects.requireNonNull(familyName);
        this.gender = gender;
        this.birthdate = birthdate;
    }

    /**
     * Returns the "usual" human name.
     */
    public String getHumanName() {
        return String.join(" ", String.join(" ", this.givenNames), this.familyName);
    }

    @Override
    public String toString() {
        return "PatientDigest{" +
                "ids=" + ids +
                ", givenNames='" + givenNames + '\'' +
                ", familyName='" + familyName + '\'' +
                ", gender=" + gender +
                ", birthdate=" + birthdate +
                '}';
    }
}
