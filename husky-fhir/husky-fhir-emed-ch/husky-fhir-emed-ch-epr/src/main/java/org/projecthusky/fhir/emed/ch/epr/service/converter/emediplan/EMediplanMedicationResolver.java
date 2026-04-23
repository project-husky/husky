package org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.MedicamentIdType;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;

import java.util.Objects;

/**
 * This is an interface for a service that can return a FHIR {@link ChEmedEprMedication} resource from a provided
 * eMediplan medication identifier:
 * <ul>
 *     <li>free text (no identifier)</li>
 *     <li>GTIN</li>
 *     <li>HCI index pharmacode</li>
 *     <li>HCI index product number (not valid for prescriptions)</li>
 * </ul>
 */
@FunctionalInterface
public interface EMediplanMedicationResolver {
    /**
     * Gets a valid FHIR CH EMED EPR Medication resource from the medication
     * @param idType The type of medication id provided with the eMediplan document.
     * @param id     The value of the medication id provided with the eMediplan document.
     * @return       A valid FHIR CH EMED EPR Medication resource with the matching medication.
     * @throws UnsupportedOperationException if the resolver does not support the received medication id type.
     * @throws MedicationNotFoundException if the resolver could not find a match for the received id and id type,
     *                                     despite supporting the received id type.
     */
    ChEmedEprMedication getMedication(final MedicamentIdType idType, final String id)
            throws UnsupportedOperationException, MedicationNotFoundException;

    class MedicationNotFoundException extends RuntimeException {}

    /**
     * Extremely basic medication resolver that only supports free text medication specification. Any other id type than
     * {@link MedicamentIdType#NONE} will result in an {@link UnsupportedOperationException}.
     */
    final class NoOpMedicationResolver implements EMediplanMedicationResolver {
        @Override
        public ChEmedEprMedication getMedication(MedicamentIdType idType, String id) throws UnsupportedOperationException, MedicationNotFoundException {
            if (Objects.requireNonNull(idType) == MedicamentIdType.NONE) {
                final var medication = new ChEmedEprMedication();
                medication.setCode(new CodeableConcept().setText(id));
                return medication;
            }
            throw new UnsupportedOperationException("Medication resolution by identifier is not supported by this service.");
        }
    }
}
