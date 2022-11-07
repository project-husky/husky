package org.projecthusky.fhir.emed.ch.epr.resource.extension;

import ca.uhn.fhir.model.api.annotation.Child;
import org.hl7.fhir.r4.model.Identifier;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

import java.util.UUID;

/**
 * An interface for extensions referring to a document.
 *
 * @author Ronaldo Loureiro
 */
public interface ChEmedExtReference {

    UUID resolveIdentifier();

    UUID resolveExternalDocumentId();

    ChEmedExtReference setIdentifier(final UUID identifier);

    ChEmedExtReference setExternalDocumentId(final UUID externalDocumentId);

    boolean hasId();

    boolean hasExternalDocumentId();
}
