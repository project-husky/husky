package org.ehealth_connector.emed.cda.services.narrative;

import org.ehealth_connector.common.enums.LanguageCode;

import java.util.Locale;
import java.util.Objects;

/**
 * Supported languages for the narrative generators.
 *
 * @author Quentin Ligier
 */
public enum NarrativeLanguage {

    ENGLISH("en", "English"),
    FRENCH("fr", "French"),
    GERMAN("de", "German"),
    ITALIAN("it", "Italian");

    /**
     * The language ISO code.
     */
    private final String isoCode;

    /**
     * The language display name in English.
     */
    private final String displayName;

    /**
     * Constructor.
     *
     * @param isoCode The language ISO code.
     * @param displayName The language display name in English.
     */
    NarrativeLanguage(final String isoCode,
                      final String displayName) {
        this.isoCode = Objects.requireNonNull(isoCode);
        this.displayName = Objects.requireNonNull(displayName);
    }

    /**
     * Returns the related {@link Locale}.
     */
    public Locale getLocale() {
        return new Locale(this.isoCode, "ch");
    }

    /**
     * Returns the related {@link LanguageCode}.
     */
    public LanguageCode getLanguageCode() {
        return switch(this) {
            case ENGLISH -> LanguageCode.ENGLISH;
            case FRENCH  -> LanguageCode.FRENCH;
            case GERMAN  -> LanguageCode.GERMAN;
            case ITALIAN -> LanguageCode.ITALIAN;
        };
    }
}
