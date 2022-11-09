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
package org.projecthusky.fhir.emed.ch.epr.enums;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.LanguageCode;

import java.util.Objects;

/**
 * husky
 *
 * @author Quentin Ligier
 **/
public enum CompositionTitle {

    MTP("Medication Treatment Plan", "Therapieentscheid Medikation", "Décision thérapeutique relative à la médication", "Decisione terapeutica di trattamento farmacologico"),
    PRE("Prescription", "Rezept", "Ordonnance", "Ricetta"),
    DIS("Dispense", "Abgabe", "Remise", "Dispensazione"),
    PADV("Pharmaceutical Advice", "Kommentar zur Medikation", "Commentaire relatif à la médication", "Commento sulla terapia farmacologica"),
    PML("Medication List", "Medikationsliste", "Liste de médication", "Elenco delle terapie farmacologiche"),
    PMLC("Medication Card", "Medikationsplan", "Plan de médication", "Piano farmacologico");

    /**
     * The display names per language. It's always stored in the given order: in English (0), in German (1), in French
     * (2) and in Italian (3).
     */
    @NonNull
    private final String[] displayNames;

    /**
     * Constructor.
     *
     * @param displayNameEn The display name in English.
     * @param displayNameDe The display name in German.
     * @param displayNameFr The display name in French.
     * @param displayNameIt The display name in Italian.
     */
    CompositionTitle(final String displayNameEn,
                     final String displayNameDe,
                     final String displayNameFr,
                     final String displayNameIt) {
        this.displayNames = new String[4];
        this.displayNames[0] = Objects.requireNonNull(displayNameEn);
        this.displayNames[1] = Objects.requireNonNull(displayNameDe);
        this.displayNames[2] = Objects.requireNonNull(displayNameFr);
        this.displayNames[3] = Objects.requireNonNull(displayNameIt);
    }

    /**
     * Gets the display name defined by the language param.
     *
     * @param languageCode The language code to get the display name for, {@code null} to get the default display name.
     * @return the display name in the desired language.
     */
    @NonNull
    public String getDisplayName(@Nullable final LanguageCode languageCode) {
        if (languageCode == null) {
            return this.displayNames[0];
        }
        return switch (languageCode) {
            case ENGLISH -> this.displayNames[0];
            case GERMAN -> this.displayNames[1];
            case FRENCH -> this.displayNames[2];
            case ITALIAN -> this.displayNames[3];
            default -> "TOTRANSLATE";
        };
    }
}
