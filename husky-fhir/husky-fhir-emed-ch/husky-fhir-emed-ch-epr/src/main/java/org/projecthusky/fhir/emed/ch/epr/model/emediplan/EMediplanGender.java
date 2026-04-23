package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.hl7.fhir.r4.model.Enumerations;

/**
 * Extension of the eMediplan enumeration interface intended for a patient administrative gender. The purpose of this
 * interface is to provide a common method for getting a FHIR representation of the corresponding version of the
 * eMediplan enum.
 */
public interface EMediplanGender extends EMediplanEnum<Integer> {
    Enumerations.@NonNull AdministrativeGender toFhir();
}
