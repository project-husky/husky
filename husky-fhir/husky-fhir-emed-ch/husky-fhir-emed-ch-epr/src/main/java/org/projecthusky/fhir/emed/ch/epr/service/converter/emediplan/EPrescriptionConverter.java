package org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.MedicationRequest;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.enums.SubstanceAdministrationSubstitutionCode;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.ChMed16AHealthcareOrganization;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.ChMed16AHealthcarePerson;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.EPrescription;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.EPrescriptionMedicament;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;

import java.util.List;

/**
 * Specialized version of the CHMED16A converter that deals with the ePrescription format as defined by the latest
 * revision supported by this module (see {@link EPrescription}).
 */
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
    public EPrescription toEMediplan(final ChEmedEprDocumentPre pre) {
        final var ePrescription = super.toEMediplan(pre);

        ePrescription.setRevision(EPrescription.LAST_SUPPORTED_REVISION);

        return ePrescription;
    }

    @Override
    protected EPrescriptionMedicament getNewMedicamentInstance() {
        return new EPrescriptionMedicament();
    }

    @Override
    protected EPrescription getNewEmediplanInstance() {
        return new EPrescription();
    }

    @ExpectsValidResource
    protected EPrescription setPrescriptionAuthor(final EPrescription ePrescription, final Author lastMedicalAuthor) {
        super.setPrescriptionAuthor(ePrescription, lastMedicalAuthor);
        // at this point we know this is a practitioner role
        ePrescription.setHealthcarePerson(ChMed16AHealthcarePerson.fromChEmedEprPractitioner(lastMedicalAuthor.getPractitionerRole().resolvePractitioner()));
        ePrescription.setHealthcareOrganization(ChMed16AHealthcareOrganization.fromChEmedEprOrganization(lastMedicalAuthor.getPractitionerRole().resolveOrganization()));
        return ePrescription;
    }

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

        if (dispenseRequest != null)
            medicament.setRepetitionObject(ChMed23AConverter.toRepetition(dispenseRequest));

        return medicament;
    }
}
