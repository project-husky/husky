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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;

/**
 * A provider of images for medications.
 *
 * @author Quentin Ligier
 **/
@FunctionalInterface
public interface MedicationImageProvider {

    /**
     * Provides an image for the given medication, encoded in a data URL with an 'image' MIME type. If no image can be
     * provided for the medication, {@code null} is returned.
     *
     * @param medication The medication for which to provide an image.
     * @return the data URL containing the medication image or {@code null}.
     * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/Data_URLs">Data URLs</a>
     */
    @Nullable String provide(final ChEmedEprMedication medication);

    /**
     * A no-operation instance.
     */
    MedicationImageProvider NO_OP_INSTANCE = (medication -> null);
}
