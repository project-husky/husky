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
package org.projecthusky.common.enums;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Interface for translated enums.
 *
 * @author Quentin Ligier
 **/
public interface TranslatedEnumInterface {

    /**
     * Gets the default display name.
     *
     * @return the default display name.
     */
    @NonNull
    default String getDisplayName() {
        return getDisplayName(null);
    }

    /**
     * Gets the display name defined by the language param.
     *
     * @param languageCode The language code to get the display name for, {@code null} to get the default display name.
     * @return the display name in the desired language.
     */
    @NonNull
    String getDisplayName(@Nullable final LanguageCode languageCode);
}
