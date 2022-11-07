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
package org.projecthusky.fhir.emed.ch.common.enums;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.projecthusky.fhir.structures.utils.FhirValueSetEnumInterface;

import java.util.Objects;

/**
 * Enumeration of the different kind of CDA-CH-EMED PADV item entries.
 *
 * @author Quentin Ligier
 **/
public enum EmedPadvEntryType implements FhirValueSetEnumInterface {

    OK("OK", "urn:oid:1.3.6.1.4.1.19376.1.9.2.1", "OK", "OK", "OK", "OK", "OK"),
    COMMENT("CHANGE", "urn:oid:1.3.6.1.4.1.19376.1.9.2.1", "CHANGE", "CHANGE", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
    CANCEL("CANCEL", "urn:oid:1.3.6.1.4.1.19376.1.9.2.1", "CANCEL", "CANCEL", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
    SUSPEND("SUSPEND", "urn:oid:1.3.6.1.4.1.19376.1.9.2.1", "SUSPEND", "SUSPEND", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
    REFUSE("REFUSE", "urn:oid:1.3.6.1.4.1.19376.1.9.2.1", "REFUSE", "REFUSE", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
    CHANGE("CHANGE", "urn:oid:1.3.6.1.4.1.19376.1.9.2.1", "CHANGE", "CHANGE", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE");

    /**
     * Machine interpretable and (inside this class) unique code.
     */
    @NonNull
    private final String code;

    /**
     * Identifier of the referencing code system.
     */
    @NonNull
    private final String system;

    /**
     * The display names per language. It's always stored in the given order: default display name (0), in English (1),
     * in German (2), in French (3) and in Italian (4).
     */
    @NonNull
    private final String[] displayNames;

    EmedPadvEntryType(@NonNull final String code, @NonNull final String system, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
        this.code = Objects.requireNonNull(code);
        this.system = Objects.requireNonNull(system);
        this.displayNames = new String[5];
        this.displayNames[0] = Objects.requireNonNull(displayName);
        this.displayNames[1] = Objects.requireNonNull(displayNameEn);
        this.displayNames[2] = Objects.requireNonNull(displayNameDe);
        this.displayNames[3] = Objects.requireNonNull(displayNameFr);
        this.displayNames[4] = Objects.requireNonNull(displayNameIt);
    }

    /**
     * Gets the Coding with current enum.
     *
     * @return the Coding with current enum.
     */
    @Override
    public Coding getCoding() {
        return new Coding()
                .setSystem(this.system)
                .setCode(this.code)
                .setDisplay(this.displayNames[0]);
    }

    /**
     * Gets the CodeableConcept with current enum.
     *
     * @return the CodeableConcept with current enum.
     */
    @Override
    public CodeableConcept getCodeableConcept() {
        return new CodeableConcept()
                .addCoding(this.getCoding())
                .setText(this.displayNames[0]);
    }

    /**
     * Verifies if the current instance and a {@link Coding} are
     * the same value in the same system.
     *
     * @param coding The coding to compare.
     * @return {@code true} if they are equal, {@code false} otherwise.
     */
    @Override
    public boolean isEqualTo(final Coding coding) {
        final var thisCoding = this.getCoding();
        return thisCoding.getCode().equals(coding.getCode()) &&
                thisCoding.getSystem().equals(coding.getSystem());
    }

    /**
     * Gets the Enum with a given coding.
     *
     * @param coding The coding.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static EmedPadvEntryType getEnum(@Nullable final Coding coding) {
        if (coding != null) {
            for (final var e : values()) {
                if (e.isEqualTo(coding)) {
                    return e;
                }
            }
        }
        return null;
    }
}
