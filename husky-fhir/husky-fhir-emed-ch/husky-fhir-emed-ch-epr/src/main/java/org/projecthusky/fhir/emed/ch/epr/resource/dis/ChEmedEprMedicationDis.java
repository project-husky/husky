package org.projecthusky.fhir.emed.ch.epr.resource.dis;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.common.resource.ChEmedOrganization;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedRatioWithEmedUnits;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;

import java.util.Objects;

/**
 * The HAPI custom structure for CH-EMED-EPR Medication (DIS).
 *
 * @author Ronaldo Loureiro
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-medication-medicationdispense")
public class ChEmedEprMedicationDis extends ChEmedEprMedication {
    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprMedicationDis() {
        super();
    }

    /**
     * Returns the manufacturer or throws.
     *
     * @return the manufacturer.
     * @throws InvalidEmedContentException if the manufacturer is missing.
     */
    @ExpectsValidResource
    public ChEmedOrganization resolveManufacturer() throws InvalidEmedContentException {
        if (!this.hasManufacturer()) throw new InvalidEmedContentException("The manufacturer is not specified");

        final var resource = this.getManufacturer().getResource();
        if (resource instanceof final ChEmedOrganization chManufacturer) {
            return chManufacturer;
        }
        throw new InvalidEmedContentException("The manufacturer is invalid");
    }

    /**
     * Resolves the package size.
     *
     * @return the package size.
     * @throws InvalidEmedContentException if the package size is missing or of the wrong type.
     */
    @ExpectsValidResource
    public ChEmedRatioWithEmedUnits resolveAmount() throws InvalidEmedContentException {
        if (!this.hasAmount()) {
            throw new InvalidEmedContentException("The package size is missing");
        }
        return Objects.requireNonNull(super.resolveAmount());
    }

    /**
     * Sets the package size.
     *
     * @param amount the package size.
     * @return this.
     */
    public ChEmedEprMedicationDis setAmount(final ChEmedRatioWithEmedUnits amount) {
        super.setAmount(amount);
        return this;
    }

    @Override
    public ChEmedEprMedicationDis copy() {
        final var copy = new ChEmedEprMedicationDis();
        this.copyValues(copy);
        return copy;
    }
}
