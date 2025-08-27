package org.projecthusky.fhir.emed.ch.epr.resource.pml;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.MedicationDispense;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocumentAuthorable;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedicationDispense;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprMedicationDis;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtDispense;
import org.projecthusky.fhir.emed.ch.epr.util.References;

import java.time.Instant;
import java.util.UUID;

/**
 * The HAPI custom structure for CH-EMED-EPR MedicationDispense (PML).
 *
 * @author Ronaldo Loureiro
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-medicationdispense-list")
public class ChEmedEprMedicationDispensePml
        extends ChEmedEprMedicationDispense implements ChEmedEprDocumentAuthorable<ChEmedEprMedicationDispensePml> {

    /**
     * Author of the original document if different from the author of the medical decision
     * (MedicationDispense.performer.actor).
     */
    @Nullable
    @Child(name = "authorDocument")
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-author")
    protected Reference authorDocument;

    /**
     * Reference to the original document.
     */
    @Nullable
    @Child(name = "parentDocument")
    @Extension(url = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-ext-dispense")
    protected ChEmedExtDispense parentDocument;

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationDispensePml() {
        super();
    }

    /**
     * Constructor that pre-populates fields.
     *
     * @param entryUuid The medication dispense id.
     */
    public ChEmedEprMedicationDispensePml(final UUID entryUuid,
                                          final Instant whenHandedOver) {
        super(entryUuid, whenHandedOver);
    }


    /**
     * Resolves the author and her/his organization of the medical decision.
     *
     * @return the author and her/his organization of the medical decision.
     * @throws InvalidEmedContentException if the author and her/his organization of the medical decision are missing or
     *                                     aren't of the right type.
     */
    @ExpectsValidResource
    public ChEmedEprPractitionerRole resolvePerformerActor() throws InvalidEmedContentException {
        if (!this.hasPerformer()) {
            throw new InvalidEmedContentException(
                    "The the author and her/his organization of the medical decision is missing.");
        }
        final var resource = this.getPerformerFirstRep().getActor().getResource();
        if (resource instanceof ChEmedEprPractitionerRole chEmedEprPractitionerRole) {
            return chEmedEprPractitionerRole;
        }
        throw new InvalidEmedContentException(
                "The author and her/his organization of the medical decision resource isn't of the right type.");
    }

    /**
     * Resolves the medication or throws.
     * <p>
     * In a PML, the parser has unserialized a ChEmedEprMedication instead of a ChEmedEprMedicationDis, so this
     * method will convert it to the right class.
     *
     * @return the medication.
     * @throws InvalidEmedContentException if the medication is missing or if it isn't of the right type.
     */
    @ExpectsValidResource
    @Override
    public ChEmedEprMedicationDis resolveMedication() throws InvalidEmedContentException {
        if (!this.hasMedicationReference()) {
            throw new InvalidEmedContentException("The medication reference is missing");
        }
        final IBaseResource resource = this.getMedicationReference().getResource();
        if (resource instanceof ChEmedEprMedicationDis chMedication) {
            return chMedication;
        } else if (resource instanceof ChEmedEprMedication chMedication) {
            final var newMedication = new ChEmedEprMedicationDis();
            chMedication.copyValues(newMedication);
            this.getMedicationReference().setResource(newMedication);
            return newMedication;
        }
        throw new InvalidEmedContentException("The medication resource isn't of the right type");
    }

    /**
     * Gets the author document element in the medication dispense.
     *
     * @return the author document element.
     */
    @Override
    public Reference getAuthorDocument() {
        if (this.authorDocument == null) {
            this.authorDocument = new Reference();
        }
        return this.authorDocument;
    }

    @Override
    public ChEmedEprMedicationDispensePml setAuthorDocument(final Reference reference) {
        this.authorDocument = reference;
        return this;
    }

    /**
     * Sets the author and her/his organization of the medical decision.
     *
     * @param actor the author and her/his organization of the medical decision.
     * @return this.
     */
    public ChEmedEprMedicationDispensePml setPerformer(final ChEmedEprPractitionerRole actor) {
        this.getPerformerFirstRep().setActor(new Reference(actor));
        return this;
    }

    /**
     * Sets the author as performer (medical author) of the dispense.
     * @param actor The author to set as performer.
     * @return this.
     */
    public ChEmedEprMedicationDispensePml setPerformer(final Author actor) {
        this.getPerformerFirstRep().setActor(References.createAuthorReference(actor));
        return this;
    }

    /**
     * Gets the parent document element. If it doesn't exist, it is created.
     *
     * @return the parent document element.
     */
    public ChEmedExtDispense getParentDocumentElement() {
        if (this.parentDocument == null) {
            this.parentDocument = new ChEmedExtDispense();
        }
        return this.parentDocument;
    }

    /**
     * Sets the parent document reference.
     *
     * @param parentDocument the parent document reference.
     * @return this.
     */
    public ChEmedEprMedicationDispensePml setParentDocumentElement(final ChEmedExtDispense parentDocument) {
        this.parentDocument = parentDocument;
        return this;
    }

    /**
     * Returns whether the parent document reference exists.
     *
     * @return {@code true} if the parent document reference exists, {@code false} otherwise.
     */
    public boolean hasParentDocument() {
        return this.parentDocument != null && !this.parentDocument.isEmpty();
    }

    @Override
    public ChEmedEprMedicationDispensePml copy() {
        final var copy = new ChEmedEprMedicationDispensePml();
        this.copyValues(copy);
        return copy;
    }

    @Override
    public void copyValues(final MedicationDispense dst) {
        super.copyValues(dst);
        copyAuthorDocumentValues(dst);
        if (dst instanceof final ChEmedEprMedicationDispensePml als) {
            als.parentDocument = parentDocument == null ? null : parentDocument.copy();
        }
    }
}
