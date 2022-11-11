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
package org.projecthusky.fhir.emed.ch.epr.narrative.pdf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Utility for color profiles.
 *
 * @author Quentin Ligier
 **/
public class ColorProfiles {

    /**
     * This class is not instantiable.
     */
    private ColorProfiles() {
    }

    /**
     * Gets the content of the sRGB ICC profile.
     *
     * @return The content of the sRGB ICC profile.
     * @throws IOException if the color profile is not readable.
     */
    static byte[] getSrgbIccProfile() throws IOException {
        try (final InputStream colorProfile =
                     ColorProfiles.class.getResourceAsStream("/pdf/colorspace/sRGB.icc")) {
            if (colorProfile == null) {
                throw new FileNotFoundException("The sRGB profile file hasn't been found");
            }
            return colorProfile.readAllBytes();
        }
    }
}
