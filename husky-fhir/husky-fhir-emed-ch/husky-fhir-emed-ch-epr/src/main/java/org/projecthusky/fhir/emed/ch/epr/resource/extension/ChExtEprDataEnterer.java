package org.projecthusky.fhir.emed.ch.epr.resource.extension;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;

import java.util.Date;

/**
 * The HAPI custom structure for CH-EXT-EPR DataEnterer.
 * <p>
 * Extension to define the information about the person and organization that entered data and the time of the data
 * input, equivalent to the dataEnterer from a CDA document.
 * <p>
 * URL : <a href="http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-dataenterer">Extension: EPR Data Enterer</a>
 *
 * @author Ronaldo Loureiro
 */
@Block
public class ChExtEprDataEnterer extends BackboneElement {

    /**
     * Information about the person and organization that entered data
     */
    @Nullable
    @Child(name = "enterer", min = 1)
    @Extension(url = "enterer", definedLocally = false)
    protected Reference enterer;

    /**
     * Timestamp of the authorship/data input
     */
    @Nullable
    @Child(name = "timestamp")
    @Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-time", definedLocally = false)
    protected DateType timestamp;

    /**
     * Empty constructor
     */
    public ChExtEprDataEnterer() {
        super();
    }

    /**
     * Resolves the person and organization that entered data or throws.
     *
     * @return the person and organization that entered data.
     * @throws InvalidEmedContentException if the information is missing or isn't of a ChEmedEprPractitionerRole type.
     */
    @ExpectsValidResource
    public ChEmedEprPractitionerRole resolveEnterer() throws InvalidEmedContentException {
        if (!this.hasEnterer()) throw new InvalidEmedContentException(
                "Information about the person and organization that entered data is missing.");
        final var resource = this.enterer.getResource();
        if (resource instanceof ChEmedEprPractitionerRole chPractitionerRole) {
            return chPractitionerRole;
        }
        throw new InvalidEmedContentException("The resource isn't of a ChEmedEprPractitionerRole type.");
    }

    /**
     * Gets the timestamp of the authorship/data input.
     *
     * @return the timestamp of the authorship/data input or {@code null}.
     */
    @Nullable
    public Date getTimestamp() {
        if (!this.hasTimestamp()) return null;
        return this.timestamp.getValue();
    }

    /**
     * Sets the data entered resource. If the data entered resource already exists, it is replaced.
     *
     * @param practitionerRole the person and organization that entered data.
     * @return this.
     */
    public ChExtEprDataEnterer setEnterer(final ChEmedEprPractitionerRole practitionerRole) {
        if (this.enterer == null) {
            this.enterer = new Reference();
        }
        this.enterer.setResource(practitionerRole);
        return this;
    }

    /**
     * Sets the timestamp of the authorship/data input.
     *
     * @param timestamp the timestamp of the authorship/data input.
     * @return this.
     */
    public ChExtEprDataEnterer setTimestamp(final Date timestamp) {
        if (this.timestamp == null) {
            this.timestamp = new DateType();
        }
        this.timestamp.setValue(timestamp);
        return this;
    }

    /**
     * Returns whether the entered data exists.
     *
     * @return {@code true} if the entered data exists, {@code false} otherwise.
     */
    public boolean hasEnterer() {
        return this.enterer != null && this.enterer.getResource() != null;
    }

    /**
     * Returns whether the timestamp of the authorship/data input.
     *
     * @return {@code true} if the timestamp of the authorship/data input exists, {@code false} otherwise.
     */
    public boolean hasTimestamp() {
        return this.timestamp != null && this.timestamp.hasValue();
    }

    @Override
    public ChExtEprDataEnterer copy() {
        final var copy = new ChExtEprDataEnterer();
        this.copyValues(copy);
        return copy;
    }

    @Override
    public void copyValues(final BackboneElement dst) {
        super.copyValues(dst);
        if (dst instanceof final ChExtEprDataEnterer als) {
            als.enterer = enterer == null ? null : enterer.copy();
            als.timestamp = timestamp == null ? null : timestamp.copy();
        }
    }
}
