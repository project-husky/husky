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
package org.projecthusky.fhir.structures.utils;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

/**
 * An interface for all FHIR value set enums.
 *
 * @author Quentin Ligier
 **/
public interface FhirValueSetEnumInterface {

    /**
     * Returns the code system, as used in FHIR.
     */
    @NonNull
    String getFhirSystem();

    /**
     * Returns the enum value as a FHIR Coding.
     */
    @NonNull
    Coding getCoding();

    /**
     * Returns the enum value as a FHIR CodeableConcept.
     */
    @NonNull
    CodeableConcept getCodeableConcept();

    /**
     * Compares the enum value to the given FHIR Coding.
     *
     * @param coding The FHIR Coding to be compared.
     * @return {@code true} if they have the same system and value, {@code false} otherwise.
     */
    boolean isEqualTo(final Coding coding);
}
