package org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.*;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.utils.datatypes.Uuids;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.UnitCode;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedQuantityWithEmedUnits;
import org.projecthusky.fhir.emed.ch.epr.enums.SubstanceAdministrationSubstitutionCode;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.ChMed16AHealthcareOrganization;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.ChMed16AHealthcarePerson;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.EPrescription;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.EPrescriptionMedicament;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.repetition.DurationBoundRepeatable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.repetition.NumberBoundRepeatable;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPatient;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprPractitionerRole;
import org.projecthusky.fhir.emed.ch.epr.resource.extension.ChEmedExtTreatmentPlan;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprCompositionPre;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprMedicationRequestPre;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

/**
 * Specialized version of the CHMED16A converter that deals with the ePrescription format as defined by the latest
 * revision supported by this module (see {@link EPrescription}).
 */
public class EPrescriptionConverter extends ChMed16ABaseConverter<EPrescriptionMedicament, EPrescription> {
    protected final EMediplanMedicationResolver  medicationResolver;

    /**
     * Convenience constructor that uses a {@link EMediplanMedicationResolver.NoOpMedicationResolver}.
     * See {@link EPrescriptionConverter#EPrescriptionConverter(EMediplanMedicationResolver)}
     */
    public EPrescriptionConverter() {
        this(new EMediplanMedicationResolver.NoOpMedicationResolver());
    }

    /**
     * Constructor of an ePrescription converter.
     *
     * @param medicationResolver The resolver that can get a FHIR medication resource from a eMediplan medication id
     *                           and id type.
     */
    public EPrescriptionConverter(final EMediplanMedicationResolver medicationResolver) {
        this.medicationResolver = Objects.requireNonNull(medicationResolver);
    }

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

    /**
     * Converts an ePrescription to a CH EMED EPR PRE document. No pre-validation is performed before conversion.
     * @param ePrescription The ePrescription document to be converted.
     * @param language      The language to which to set the resulting FHIR document. Note that ePrescription does not
     *                      have such a field.
     * @return The resulting CH EMED EPR PRE document object.
     */
    @ExpectsValidResource
    protected ChEmedEprDocumentPre toMedicationRequest(final EPrescription ePrescription, final LanguageCode language) {
        // TODO should the ePrescription id be added as an extension??
        final var id = Uuids.match(ePrescription.getId())? Uuids.parseUrnEncoded(ePrescription.getId()) : UUID.randomUUID();
        final var pre = new ChEmedEprDocumentPre(id, ePrescription.getTimestamp());
        final var patient = ePrescription.getPatient().toFhir();
        pre.addPatient(patient);
        final var composition = new ChEmedEprCompositionPre(id, ePrescription.getTimestamp(), language);
        composition.setSubject(new Reference(patient));
        pre.setComposition(composition);
        //TODO composition!!!!!!

        if (ePrescription.getMedicaments() != null && !ePrescription.getMedicaments().isEmpty()) {
            for (final var medicament : ePrescription.getMedicaments())
                pre.addMedicationRequest(toMedicationRequest(
                        medicament,
                        tp, // TODO either add a treatment plan resolver service or we return a non-valid prescription document
                        patient,
                        requester,
                        ePrescription.getTimestamp(),
                        language
                ));
        } else throw new InvalidEmedContentException("There must be at least one medication in the prescription, but found none.");

        //TODO auth
        //TODO zsr number
        //TODO comments
        //TODO hcperson
        //TODO hcorg
        return pre;
    }

    @ExpectsValidResource
    protected ChEmedEprMedicationRequestPre toMedicationRequest(final EPrescriptionMedicament medicament,
                                                                final ChEmedExtTreatmentPlan treatmentPlan,
                                                                final ChEmedEprPatient patient,
                                                                final ChEmedEprPractitionerRole requester,
                                                                final Instant timestamp,
                                                                final LanguageCode language
                                                   ) {
        final var medRequest =  new ChEmedEprMedicationRequestPre(UUID.randomUUID());

        medRequest.setTreatmentPlanElement(treatmentPlan);

        if (medicament.getIdType() == null || medicament.getId() == null)
            throw new InvalidEmedContentException("The eMediplan medicament id or id type is missing but it is mandatory.");
        final var medication = medicationResolver.getMedication(medicament.getIdType(), medicament.getId());
        medRequest.addContained(medication);
        medRequest.setMedicationReference(medication);

        medRequest.setSubject(new Reference(patient));
        medRequest.setRequester(new Reference(requester));

        medRequest.setDosageInstruction(getDosage(medicament));

        if (medicament.getRepetitionObject() != null) {
            if (medicament.getRepetitionObject() instanceof NumberBoundRepeatable repeats)
                medRequest.addDispenseRequest().setNumberOfRepeatsAllowed(repeats.getValue());
            if (medicament.getRepetitionObject() instanceof DurationBoundRepeatable duration)
                medRequest.addDispenseRequest().setValidityPeriod(new Period().setEnd(Date.from(duration.getEnd(timestamp))));
        }
        medRequest.addDispenseRequest().setQuantity(new Quantity(
                medicament.getNumberOfPackages() == null? 1 : medicament.getNumberOfPackages()
        ));

        if (medicament.isSubstitutionForbidden())
            medRequest.setSubstitution(new MedicationRequest.MedicationRequestSubstitutionComponent(
                    SubstanceAdministrationSubstitutionCode.NONE.getCodeableConcept(language)
            ));

        return  medRequest;
    }

    @ExpectsValidResource
    protected List<@NonNull Dosage> getDosage(final EPrescriptionMedicament medicament) {
        final var dosage = new ArrayList<@NonNull Dosage>();
        final var baseDosage = new ChEmedEprDosage();
        dosage.add(baseDosage);
        if (medicament.getPosology() != null && !medicament.getPosology().isEmpty()) {
            final var posology = medicament.getPosology().getFirst();
            if (posology.getEnd() != null) baseDosage.setBoundsPeriod(new Period().setEnd(Date.from(posology.getEnd())));
            if (posology.getDailyDoses() != null) {
                addDose(TimingEventAmbu.MORNING, posology.getDailyDoses().getMorningDose(), medicament.getUnit(), dosage);
                addDose(TimingEventAmbu.NOON, posology.getDailyDoses().getNoonDose(), medicament.getUnit(), dosage);
                addDose(TimingEventAmbu.EVENING, posology.getDailyDoses().getEveningDose(), medicament.getUnit(), dosage);
                addDose(TimingEventAmbu.NIGHT, posology.getDailyDoses().getNightDose(), medicament.getUnit(), dosage);
            }
            baseDosage.setPatientInstruction(medicament.getApplicationInstructions());
            //TODO generate text representation of dosage
        } else {
            baseDosage.setText(medicament.getApplicationInstructions());
        }
        return dosage;
    }

    @ExpectsValidResource
    protected void addDose(final TimingEventAmbu timing,
                           final double value,
                           final UnitCode unit,
                           final List<@NonNull Dosage> dosage) {
        if (value != 0f) {
            for (final var dose : dosage) {
                if (dosage instanceof ChEmedEprDosage chEmedEprDosage) {
                    if (chEmedEprDosage.hasDoseAndRate()) {
                        if (chEmedEprDosage.getDoseAndRateFirstRep().getDoseQuantity().getValue().doubleValue() == value) {
                            chEmedEprDosage.addWhen(timing);
                            return;
                        }
                    } else {
                        chEmedEprDosage.addWhen(timing);
                        chEmedEprDosage.setDoseQuantity(new ChEmedQuantityWithEmedUnits(new BigDecimal(value), unit));
                        return;
                    }
                } else throw new InvalidEmedContentException("The medication request contains a non CH EMED EPR dosage.");
            }
            dosage.getFirst().setSequence(1);
            dosage.add(new ChEmedEprDosage().setDoseQuantity(new ChEmedQuantityWithEmedUnits(new BigDecimal(value), unit)).addWhen(timing));
            dosage.getLast().setSequence(dosage.size());
        }
    }

    protected ChEmedEprPractitionerRole toPractitionerRole(final ChMed16AHealthcarePerson pro,
                                                           final ChMed16AHealthcareOrganization org) {
        if (pro == null) throw new InvalidEmedContentException("The hcPerson is mandatory but it is missing.");
        if (org == null) throw new InvalidEmedContentException("The organization is mandatory but it is missing.");
        final var practitionerRole = new ChEmedEprPractitionerRole();
        practitionerRole.setPractitioner(new Reference(pro.toFhir()));
        //TODO org
        return practitionerRole;
        //TODO remember that you have to add the three elements as document entries as well
    }
}
