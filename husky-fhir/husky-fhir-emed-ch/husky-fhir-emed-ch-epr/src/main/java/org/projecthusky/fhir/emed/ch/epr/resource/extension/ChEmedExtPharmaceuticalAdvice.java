package org.projecthusky.fhir.emed.ch.epr.resource.extension;

import ca.uhn.fhir.model.api.annotation.Block;
import org.projecthusky.fhir.emed.ch.common.enums.EmedEntryType;

import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-Ext PharmaceuticalAdvice. Extension to represent the reference to the
 * Pharmaceutical Advice document. URL : <a
 * href="http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-pharmaceuticaladvice">...</a>
 *
 * @author Ronaldo Loureiro
 */
@Block
public class ChEmedExtPharmaceuticalAdvice extends ChEmedExtensionReference {
    public static final String URL = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-pharmaceuticaladvice";

    /**
     * Empty constructor
     */
    public ChEmedExtPharmaceuticalAdvice() {
        super();
    }

    /**
     * Constructor
     *
     * @param id                 the ID of the Pharmaceutical Advice document.
     * @param externalDocumentId the ID of the external document.
     */
    public ChEmedExtPharmaceuticalAdvice(final UUID id,
                                         final UUID externalDocumentId) {
        super();
        this.setExtensionId(id);
        this.setExternalDocumentId(externalDocumentId);
    }

    @Override
    public ChEmedExtPharmaceuticalAdvice copy() {
        final var copy = new ChEmedExtPharmaceuticalAdvice();
        this.copyValues(copy);
        return copy;
    }

    @Override
    public EmedEntryType getEntryType() {
        return EmedEntryType.PADV;
    }
}
