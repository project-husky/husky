/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.models.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.AdministrativeGender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the digest of a patient in an Emed document.
 * <p>
 * Creating these digests is typically done from a CDA-CH-EMED document with the digesters.
 *
 * @author Quentin Ligier
 */
@Data
@EqualsAndHashCode
public class PatientDigest {

    /**
     * The list of patient Ids.
     */
    private final List<@NonNull String> ids = new ArrayList<>();

    /**
     * The legal given name.
     */
    private String givenName;

    /**
     * The legal family name.
     */
    private String familyName;

    /**
     * The gender.
     */
    @Nullable
    private AdministrativeGender gender;

    /**
     * The birth date.
     */
    @Nullable
    private LocalDate birthDate;
}
