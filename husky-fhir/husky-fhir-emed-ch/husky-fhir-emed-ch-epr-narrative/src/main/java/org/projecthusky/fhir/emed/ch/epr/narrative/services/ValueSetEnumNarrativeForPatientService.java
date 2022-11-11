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
package org.projecthusky.fhir.emed.ch.epr.narrative.services;


import org.projecthusky.common.enums.ValueSetEnumInterface;
import org.projecthusky.fhir.emed.ch.epr.narrative.enums.NarrativeLanguage;

import java.io.IOException;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;

/**
 * A service that loads display name for some enums that extend the {@link ValueSetEnumInterface} that are
 * understandable by patients.
 * <p>
 * Value sets that are supported as of now are:
 * <ul>
 *     <li></li>
 * </ul>
 *
 * @author Quentin Ligier
 **/
public class ValueSetEnumNarrativeForPatientService {

    /**
     * The properties for all supported languages.
     */
    private final PropertyResourceBundle frResourceBundle;
    private final PropertyResourceBundle enResourceBundle;
    private final PropertyResourceBundle deResourceBundle;
    private final PropertyResourceBundle itResourceBundle;

    /**
     * Constructor.
     *
     * @throws IOException if one of the resource bundle files cannot be read.
     */
    public ValueSetEnumNarrativeForPatientService() throws IOException {
        this.frResourceBundle = new PropertyResourceBundle(this.getClass().getResourceAsStream("/narrative" +
                "/translations/ValueSetEnums.fr.properties"));
        this.enResourceBundle = new PropertyResourceBundle(this.getClass().getResourceAsStream("/narrative" +
                "/translations/ValueSetEnums.en.properties"));
        this.deResourceBundle = new PropertyResourceBundle(this.getClass().getResourceAsStream("/narrative" +
                "/translations/ValueSetEnums.de.properties"));
        this.itResourceBundle = new PropertyResourceBundle(this.getClass().getResourceAsStream("/narrative" +
                "/translations/ValueSetEnums.it.properties"));
    }

    /**
     * Retrieves the patient-understandable message for the given enum element and narrative language. If the element
     * is not found, the default display name of the enum element is returned.
     *
     * @param enumm    The enum element.
     * @param language The narrative language.
     * @return the translated message.
     */
    public String getMessage(final ValueSetEnumInterface enumm,
                             final NarrativeLanguage language) {
        try {
            return this.getProperties(language).getString(enumm.getValueSetName() + "." + enumm.name());
        } catch (final MissingResourceException ignored) {
            return enumm.getDisplayName(language.getLanguageCode());
        }
    }

    /**
     * Returns the right properties for the given language.
     *
     * @param language The narrative language.
     * @return the corresponding properties.
     */
    private PropertyResourceBundle getProperties(final NarrativeLanguage language) {
        return switch(language) {
            case FRENCH  -> this.frResourceBundle;
            case ENGLISH -> this.enResourceBundle;
            case GERMAN  -> this.deResourceBundle;
            case ITALIAN -> this.itResourceBundle;
        };
    }
}
