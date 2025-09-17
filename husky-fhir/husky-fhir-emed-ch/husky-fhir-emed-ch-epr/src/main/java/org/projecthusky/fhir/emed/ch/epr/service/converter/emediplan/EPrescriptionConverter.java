package org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.MedicationRequest;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.enums.SubstanceAdministrationSubstitutionCode;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.EPrescription;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.EPrescriptionMedicament;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;

import java.util.List;

public class EPrescriptionConverter extends ChMed16ABaseConverter<EPrescriptionMedicament, EPrescription> {
    /**
     * Not supported.
     * @throws UnsupportedOperationException always.
     */
    @Override
    @ExpectsValidResource
    public EPrescription toEMediplan(final ChEmedEprDocumentPmlc pmlc) {
        throw new UnsupportedOperationException("The EPrescriptionConverter supports only prescription conversion.");
    }

    @Override
    protected EPrescriptionMedicament getNewMedicamentInstance() {
        return new EPrescriptionMedicament();
    }

    @Override
    protected EPrescription getNewEmediplanInstance() {
        return new EPrescription();
    }

    /*
    public EPrescription toEPrescription(final ChEmedEprDocumentPre pre) {
        final var ePrescription = toEMediplan(pre, EPrescription::new, EPrescriptionMedicament::new);

        ePrescription.setRevision(EPrescription.LAST_SUPPORTED_REVISION);

        // add hcperson
        // add hcorg

        // enrich medicaments with chmed23a-style repetition objects
        for ()

        return ePrescription;
    }
     */

    @Override
    @ExpectsValidResource
    protected EPrescriptionMedicament toMedicament(final ChEmedEprMedication medication,
                                                   final ChEmedEprDosage baseDosage,
                                                   final List<@NonNull ChEmedEprDosage> additionalDosages,
                                                   final @Nullable String treatmentReason,
                                                   final Author medicalAuthor,
                                                   final SubstanceAdministrationSubstitutionCode substitutionCode,
                                                   final MedicationRequest.@Nullable MedicationRequestDispenseRequestComponent dispenseRequest,
                                                   final EMediplanType mediplanType) {
        final var medicament = super.toMedicament(
                medication,
                baseDosage,
                additionalDosages,
                treatmentReason,
                medicalAuthor,
                substitutionCode,
                dispenseRequest,
                mediplanType
        );

        //TODO add chmed23a-style repetition objects

        return medicament;
    }
}
