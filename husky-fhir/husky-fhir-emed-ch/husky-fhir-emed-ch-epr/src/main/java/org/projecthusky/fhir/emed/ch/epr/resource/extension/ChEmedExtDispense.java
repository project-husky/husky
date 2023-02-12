package org.projecthusky.fhir.emed.ch.epr.resource.extension;

import ca.uhn.fhir.model.api.annotation.Block;
import org.projecthusky.fhir.emed.ch.common.enums.EmedEntryType;

import java.util.UUID;


/**
 * The HAPI custom structure for CH-EMED-Ext Dispense. Extension to reference the medication dispense. URL : <a
 * href="https://build.fhir.org/ig/hl7ch/ch-emed//StructureDefinition-ch-emed-ext-dispense.html">...</a>
 *
 * @author Ronaldo Loureiro
 */
@Block
public class ChEmedExtDispense extends ChEmedExtensionReference {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedExtDispense() {
        super();
    }

    /**
     * Constructor
     *
     * @param id                 the ID of a medication dispense.
     * @param externalDocumentId the ID of the external document.
     */
    public ChEmedExtDispense(final UUID id,
                             final UUID externalDocumentId) {
        super();
        this.setExtensionId(id);
        this.setExternalDocumentId(externalDocumentId);
    }

    @Override
    public ChEmedExtDispense copy() {
        final var copy = new ChEmedExtDispense();
        this.copyValues(copy);
        return copy;
    }

    @Override
    public EmedEntryType getEntryType() {
        return EmedEntryType.DIS;
    }
}
