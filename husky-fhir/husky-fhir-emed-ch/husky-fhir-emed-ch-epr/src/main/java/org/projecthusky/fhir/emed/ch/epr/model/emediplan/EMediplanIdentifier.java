package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import org.hl7.fhir.r4.model.Identifier;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;

/**
 * Extension of the {@link EMediplanObject} interface that adds a method to convert an eMediplan object translatable
 * to a FHIR {@link Identifier} to such an identifier.
 */
public interface EMediplanIdentifier extends EMediplanObject {
    @ExpectsValidResource
    Identifier toFhir();
}
