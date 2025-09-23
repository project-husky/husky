package org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan;

import com.google.common.collect.Streams;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.MedicationRequest;
import org.jetbrains.annotations.NotNull;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.enums.RegularUnitCodeAmbu;
import org.projecthusky.fhir.emed.ch.epr.enums.SubstanceAdministrationSubstitutionCode;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;
import org.projecthusky.fhir.emed.ch.epr.model.common.AmountQuantity;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.model.common.Dose;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.CdTyp9;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.MedicamentIdType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.*;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums.CdTyp26;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.posology.ChMed16ADailyDosage;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.posology.ChMed16APosology;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.posology.ChMed16ATakingTime;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprMedication;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprMedicationStatementPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprMedicationRequestPre;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.projecthusky.fhir.emed.ch.epr.enums.RegularUnitCodeAmbu.PACKAGE;
import static org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanMedicament.DEFAULT_NUMBER_OF_PACKAGES;

/**
 * Utility class to convert CH EMED EPR documents to an eMediplan object equivalent according to the
 * <a href="https://github.com/ig-emediplan/specification/tree/main/chmed16a">CHMED16A specifications</a>.
 *
 */
public non-sealed abstract class ChMed16ABaseConverter<M extends ChMed16AMedicament, E extends ChMed16AEMediplan<M>>
        implements EMediplanConverter {
    /**
     * Converts the received PMLC document to an eMediplan object according to the
     * <a href="https://github.com/ig-emediplan/specification/tree/main/chmed16a">CHMED16A specifications</a>.
     *
     * @param pmlc The PMLC document to be converted.
     * @return A best-effort equivalent eMediplan object.
     */
    @Override
    @ExpectsValidResource
    public @NotNull E toEMediplan(final ChEmedEprDocumentPmlc pmlc) {
        final var emediplan = getNewEmediplanInstance();

        emediplan.setPatient(ChMed16APatient.fromEprFhir(
                pmlc.resolvePatient(),
                pmlc.resolveComposition().resolvePatientWeightObservation(),
                pmlc.resolveComposition().getInformationRecipient(),
                EMediplanType.MEDICATION_PLAN
        ));
        // If the patient did not have a preferred language, we still need to fill it in the eMediplan since it is
        // mandatory for medication plans. The PMLC document language will be used in this case.
        if (emediplan.getPatient().getLanguageCode() == null || emediplan.getPatient().getLanguageCode().isBlank())
            emediplan.getPatient().setLanguageCode(
                    ChMed16APatient.fhirLanguageCodeToEMediplanLanguageCode(pmlc.resolveComposition().getLanguage()
                    )
            );

        /* Even though in principle we could do 1 treatment (so potentially several treatment lines / statements
           belonging to 1 treatment) -> 1 Medicament with each statement becoming one eMediplan posology object,
           CH EMED EPR does not enforce that the medication itself contained in the different statements belonging
           to one treatment are the same. This effectively means that to be on the safe side we should not group
           all statements belonging to one treatment into one medicament, and we are "forced" to do 1 PMLC statement
           -> 1 eMediplan medicament object.
         */
        for (final var statement : pmlc.resolveStatements()) emediplan.addMedicament(toMedicament(statement));

        emediplan.setType(EMediplanType.MEDICATION_PLAN);
        emediplan.setId(pmlc.resolveIdentifier().toString());

        final var lastStatement = pmlc.resolveLastStatement();
        if (lastStatement != null) {
            final var lastMedicalAuthor = lastStatement.resolveMedicalAuthor();
            if (lastMedicalAuthor.getPractitionerRole() != null)
                emediplan.setAuthor(lastMedicalAuthor.getPractitionerRole().resolvePractitioner().resolveGln());
            else emediplan.setAuthor(emediplan.getPatient().toAuthorString());
        } else emediplan.setAuthor(emediplan.getPatient().toAuthorString());

        emediplan.setTimestamp(pmlc.resolveTimestamp());

        // #289 add validator professional (gln) and date?
        // it is unclear at this moment where and how this should be stored on the CH EMED EPR side
        // most likely would be conveyed as the/an attester within the PMLC's composition.

        return emediplan;
    }

    @Override
    @ExpectsValidResource
    public @NotNull E toEMediplan(final ChEmedEprDocumentPre pre) {
        final var emediplan = getNewEmediplanInstance();

        final var preComposition = pre.resolveComposition();

        emediplan.setPatient(ChMed16APatient.fromEprFhir(
                pre.resolvePatient(),
                preComposition.resolvePatientWeightObservation(),
                preComposition.getInformationRecipient(),
                EMediplanType.PRESCRIPTION
        ));

        for (final var request : pre.resolveMedicationRequests())
            emediplan.addMedicament(toMedicament(request));

        emediplan.setType(EMediplanType.PRESCRIPTION);
        emediplan.setId(pre.resolveIdentifier().toString());

        final var lastRequest = pre.resolveLastRequest();
        if (lastRequest != null) {
            final var lastMedicalAuthor = lastRequest.resolveMedicalAuthor();
            setPrescriptionAuthor(emediplan, lastMedicalAuthor);
        } else  throw new InvalidEmedContentException("The prescription authorship could not be determined: no medication requests found in the prescription document.");

        emediplan.setTimestamp(pre.resolveTimestamp());

        if (preComposition.hasAnnotationSection()) {
            final var annotation = preComposition.getAnnotationSection();
            if (annotation.hasText()) emediplan.setRemark(annotation.getText().getDivAsString());
        }

        return emediplan;
    }

    @ExpectsValidResource
    protected E setPrescriptionAuthor(final E emediplan, final Author lastMedicalAuthor) {
        if (lastMedicalAuthor.getPractitionerRole() != null) {
            final var practitioner = lastMedicalAuthor.getPractitionerRole().resolvePractitioner();
            emediplan.setAuthor(practitioner.resolveGln());
            final var zsr = practitioner.resolveZsr();
            if (zsr !=  null && !zsr.isEmpty()) {
                // the professional has one OR MORE ZSR codes, CHMED16A supports only 0 or 1, so the first will be used and the rest ignored.
                emediplan.setZsr(zsr.getFirst());
            }
        } else throw new InvalidEmedContentException("The last medical author of a prescription must be a professional.");
        return emediplan;
    }

    /**
     * Converts a CH EMED EPR PMLC medication statement to a CHMED16A medicament object.
     * @param statement    The original CH EMED EPR PMLC medication statement to be converted.
     * @return The converted CHMED16A medicament object.
     */
    public M toMedicament(final ChEmedEprMedicationStatementPmlc statement) {
        return toMedicament(
                statement.resolveMedication(),
                statement.resolveBaseDosage(),
                statement.resolveAdditionalDosage(),
                statement.getTreatmentReason(),
                statement.resolveMedicalAuthor(),
                statement.resolveSubstitution(),
                null,
                EMediplanType.MEDICATION_PLAN
        );
    }

    protected M toMedicament(final ChEmedEprMedicationRequestPre request) {
        return toMedicament(
                request.resolveMedication(),
                request.resolveBaseDosage(),
                request.resolveAdditionalDosage(),
                request.getTreatmentReason(),
                request.resolveMedicalAuthor(),
                request.resolveSubstitution(),
                request.getDispenseRequest(),
                EMediplanType.PRESCRIPTION
        );
    }

    @ExpectsValidResource
    protected M toMedicament(final ChEmedEprMedication medication,
                             final ChEmedEprDosage baseDosage,
                             final List<@NonNull ChEmedEprDosage> additionalDosages,
                             final @Nullable String treatmentReason,
                             final Author medicalAuthor,
                             final SubstanceAdministrationSubstitutionCode substitutionCode,
                             final MedicationRequest.@Nullable MedicationRequestDispenseRequestComponent dispenseRequest,
                             final EMediplanType mediplanType) {
        final var medicament = getNewMedicamentInstance();

        if (medication.hasGtin()) {
            medicament.setId(medication.resolveGtinCode());
            medicament.setIdType(MedicamentIdType.GTIN);
        } else {
            medicament.setId(medication.resolveMedicationName());
            medicament.setIdType(MedicamentIdType.NONE);
        }

        medicament.setPosology(List.of(toPosology(baseDosage, additionalDosages, medicament, mediplanType)));
        if (baseDosage.hasDoseAndRate()) {
            final var baseDose = baseDosage.resolveDose();
            if (baseDose.isQuantity())
                medicament.setUnit(CdTyp9.fromRegularUnitCodeAmbu(baseDose.quantity().unit()));
            else
                medicament.setUnit(CdTyp9.fromRegularUnitCodeAmbu(baseDose.low().unit()));
        } else if (mediplanType == EMediplanType.MEDICATION_PLAN || !medicament.getPosology().isEmpty())
                medicament.setUnit(CdTyp9.UNKNOWN);

        if (mediplanType == EMediplanType.PRESCRIPTION) {
            if (SubstanceAdministrationSubstitutionCode.NONE == substitutionCode)
                medicament.forbidSubstitution(true);

            if (dispenseRequest != null) {
                // repetitions can't be translated, since in the CH EMED EPR format it is conveyed in number of repeats
                // while in CHMED16A it is conveyed in months, so it is not a number of repeats but more like a validityPeriod
                // allowing unlimited repeats...
                // It is however allowed in the 3rd revision of ePrescription.

                if (dispenseRequest.hasQuantity() && dispenseRequest.getQuantity().hasValue()) {
                    final var quantity = dispenseRequest.getQuantity();
                    final var quantityValue = quantity.getValue().doubleValue();
                    if (quantityValue != DEFAULT_NUMBER_OF_PACKAGES
                            && (!dispenseRequest.getQuantity().hasUnit() || PACKAGE == RegularUnitCodeAmbu.getEnum(dispenseRequest.getQuantity().getUnit()))) {
                        medicament.setNumberOfPackages(quantityValue);
                    }
                }
            }
        } else {
            medicament.setReason(treatmentReason);
            medicament.setSelfMedication(medicalAuthor.getPatient() != null || medicalAuthor.getRelatedPerson() != null);
        }

        // The tricky part of adding patient instructions is whether to know if they were already added as part of
        // free dosage text, or if they should be added as patient instructions.
        // Coded additionalInstruction can be ignored, since the IG specifies that they should also be part of
        // patientInstruction
        // If they were already added as free text dosage to the posology object, they should not be added as eMediplan
        // patient instructions, since the specs say that this should not contain the information stated as free text
        // dosage.
        //if (!freeTextDosage) posology.setApplicationInstructions(baseDosage.getPatientInstruction());
        appendToApplicationInstructions(medicament, baseDosage.getPatientInstruction());

        if (mediplanType == EMediplanType.MEDICATION_PLAN) {
            if (!medicament.isSelfMedication()) medicament.setPrescriber(medicalAuthorToPrescriber(medicalAuthor));

            if (baseDosage.hasRoute()) {
                medicament.setRouteOfAdministration(CdTyp26.fromEdqm(baseDosage.resolveRouteOfAdministration()));
                if (medicament.getRouteOfAdministration() == null) {
                    // the route of administration could not be translated, add it as free text to the application instructions
                    appendToApplicationInstructions(medicament, baseDosage.getRoute().getText());
                }
            }
        }

        return medicament;
    }

    /**
     * Converts the list of Dosage objects of a CH EMED EPR resource (either medication statement or medication request)
     * to an {@link ChMed16APosology} object.
     *
     * @param baseDosage        The CH EMED EPR resource base dosage.
     * @param additionalDosages The CH EMED EPR list of additional dosages (if split dose). It can be empty.
     * @param medicament        The medication for which this dosage is being added. The medication object might be
     *                          changed: this method might have to set or alter the application instructions if the
     *                          CH EMED EPR dosage is expressed as free text or if it cannot be converted to the
     *                          CHMED16A structure.
     * @param mediplanType      The type of eMediplan document.
     * @return The equivalent eMediplan posology object.
     */
    public ChMed16APosology toPosology(final ChEmedEprDosage baseDosage,
                                       final List<@NonNull ChEmedEprDosage> additionalDosages,
                                       final ChMed16AMedicament medicament,
                                       final EMediplanType mediplanType
    ) {
        return switch (mediplanType) {
            case MEDICATION_PLAN -> toPlanPosology(baseDosage, additionalDosages, medicament);
            case POLYMEDICATION_CHECK -> throw new UnsupportedOperationException("Polymedication check is not supported.");
            case PRESCRIPTION -> toPrescriptionPosology(baseDosage, additionalDosages, medicament);
        };
    }

    /**
     * Converts the list of Dosage objects of a CH EMED EPR resource (either medication statement or medication request)
     * to a {@link ChMed16APosology} object assumed to belong to a medication plan document.
     *
     * @param baseDosage        The CH EMED EPR resource base dosage.
     * @param additionalDosages The CH EMED EPR list of additional dosages (if split dose). It can be empty.
     * @param medicament        The medication for which this dosage is being added. The medication object might be
     *                          changed: this method might have to set or alter the application instructions if the
     *                          CH EMED EPR dosage is expressed as free text or if it cannot be converted to the
     *                          CHMED16A structure.
     * @return The equivalent eMediplan posology object.
     */
    protected ChMed16APosology toPlanPosology(final ChEmedEprDosage baseDosage,
                                             final List<@NonNull ChEmedEprDosage> additionalDosages,
                                             final ChMed16AMedicament medicament
                                              ) {
        final var posology = new ChMed16APosology();
        if (baseDosage.hasBoundsPeriod()) {
            if (baseDosage.getBoundsPeriod().hasStart())
                posology.setStart(baseDosage.getBoundsPeriod().getStartElement().getValueAsCalendar().toInstant());
            if (baseDosage.getBoundsPeriod().hasEnd())
                posology.setEnd(baseDosage.getBoundsPeriod().getEndElement().getValueAsCalendar().toInstant());
        }
        posology.setAsNeeded(baseDosage.isAsNeeded());
        final var baseDose = baseDosage.resolveDose();
        if (baseDosage.hasTiming() && baseDosage.hasWhen() && baseDosage.hasDoseAndRate()) {
            if (baseDose.isQuantity() &&
                    additionalDosages.stream()
                            .noneMatch(additionalDosage -> additionalDosage.resolveDose().isRange())
            ) {
                // simplest and most common case: quantity (not range) dosages per day segments
                final var dailyDosage = new ChMed16ADailyDosage();
                Streams.concat(additionalDosages.stream(), Stream.of(baseDosage))
                        .forEach(dosage ->
                                dosage.resolveWhen().forEach(when -> {
                                    final var quantity = Double.parseDouble(dosage.resolveDose().quantity().value());
                                    switch (when) {
                                        case MORNING -> dailyDosage.setMorningDose(quantity);
                                        case NOON -> dailyDosage.setNoonDose(quantity);
                                        case EVENING -> dailyDosage.setEveningDose(quantity);
                                        case NIGHT -> dailyDosage.setNightDose(quantity);
                                    }
                                })
                        );
                posology.setDailyDoses(dailyDosage);
            } else {
                /* there is a when and rate/quantity, but either the base dosage does not have range/quantity or some
                    additional dosages have range instead of quantity, a complex posology detail must be used
                 */
                final var takingTimes = new ArrayList<@NonNull ChMed16ATakingTime>();
                Streams.concat(Stream.of(baseDosage), additionalDosages.stream())
                        .forEach(dosage ->
                                dosage.resolveWhen().forEach(when ->
                                        takingTimes.add(getEMediplanTakingTimeFromChEmedEprDose(dosage.resolveDose(),
                                                when,
                                                baseDosage.isAsNeeded(),
                                                baseDosage.resolveMaxDosePerAdministration()
                                        ))
                                )
                        );
                posology.setTakingTimes(takingTimes);
            }
        } else {
            // No when or no dose/rate, hence there cannot be split dosage, we only care about base dosage
            if (baseDosage.hasDoseAndRate()) {
                // if we miss when, but there is doseAndRate, the CH EMED EPR convention is that it is a daily dosage.
                // in CHMED16A there's no way but to express this as a taking time with a 24h cycle duration (default cycle)
                posology.setTakingTimes(List.of(getEMediplanTakingTimeFromChEmedEprDose(
                        baseDosage.resolveDose(),
                        TimingEventAmbu.NIGHT, // we arbitrarily choose midnight (offset 0) because the offset is required
                        baseDosage.isAsNeeded(),
                        baseDosage.resolveMaxDosePerAdministration()
                )));
            } else {
                // if we miss dose/rate, we cannot add anything structured to emediplan, use free text
                // if when is present, in this case, we should try to use text, since we cannot translate the when part
                if (baseDosage.hasWhen()) {
                    medicament.setApplicationInstructions((baseDosage.hasText() || !baseDosage.hasPatientInstruction())?
                            baseDosage.getText() : baseDosage.getPatientInstruction());
                } else {
                    //nothing is structured, use patient instruction
                    medicament.setApplicationInstructions(baseDosage.getPatientInstruction());
                }
            }
        }

        return posology;
    }

    /**
     * Converts the list of Dosage objects of a CH EMED EPR resource (either medication statement or medication request)
     * to a {@link ChMed16APosology} object assumed to belong to a prescription document.
     *
     * @param baseDosage        The CH EMED EPR resource base dosage.
     * @param additionalDosages The CH EMED EPR list of additional dosages (if split dose). It can be empty.
     * @param medicament        The medication for which this dosage is being added. The medication object might be
     *                          changed: this method might have to set or alter the application instructions if the
     *                          CH EMED EPR dosage is expressed as free text or if it cannot be converted to the
     *                          CHMED16A structure.
     * @return The equivalent eMediplan posology object.
     */
    protected ChMed16APosology toPrescriptionPosology(final ChEmedEprDosage baseDosage,
                                                      final List<@NonNull ChEmedEprDosage> additionalDosages,
                                                      final ChMed16AMedicament medicament
    ) {
        final var posology = new ChMed16APosology();
        if (baseDosage.hasBoundsPeriod() && baseDosage.getBoundsPeriod().hasEnd()) {
                posology.setEnd(baseDosage.getBoundsPeriod().getEndElement().getValueAsCalendar().toInstant());
        }
        final var baseDose = baseDosage.resolveDose();
        if (baseDosage.hasTiming() && baseDosage.hasWhen() && baseDosage.hasDoseAndRate()) {
            if (baseDose.isQuantity() &&
                    additionalDosages.stream()
                            .noneMatch(additionalDosage -> additionalDosage.resolveDose().isRange())
            ) {
                // simplest and most common case: quantity (not range) dosages per day segments
                final var dailyDosage = new ChMed16ADailyDosage();
                Streams.concat(additionalDosages.stream(), Stream.of(baseDosage))
                        .forEach(dosage ->
                                dosage.resolveWhen().forEach(when -> {
                                    final var quantity = Double.parseDouble(dosage.resolveDose().quantity().value());
                                    switch (when) {
                                        case MORNING -> dailyDosage.setMorningDose(quantity);
                                        case NOON -> dailyDosage.setNoonDose(quantity);
                                        case EVENING -> dailyDosage.setEveningDose(quantity);
                                        case NIGHT -> dailyDosage.setNightDose(quantity);
                                    }
                                })
                        );
                posology.setDailyDoses(dailyDosage);
            } else {
                /* there is a when and rate/quantity, but either the base dosage does not have range/quantity or some
                    additional dosages have range instead of quantity, a complex posology detail must be used but it is
                    not supported by the CHMED16A prescription. It must be transformed into free text.
                 */
                medicament.setApplicationInstructions((baseDosage.hasText() || !baseDosage.hasPatientInstruction())?
                        baseDosage.getText() : baseDosage.getPatientInstruction());
            }
        } else {
            // No when or no dose/rate, hence there cannot be split dosage, we only care about base dosage
            if (baseDosage.hasDoseAndRate()) {
                // if we miss when, but there is doseAndRate, the CH EMED EPR convention is that it is a daily dosage.
                // in CHMED16A there's no way but to express this as a taking time with a 24h cycle duration (default cycle)
                // but the prescription does not allow for this, so a free text must be used.
                medicament.setApplicationInstructions((baseDosage.hasText() || !baseDosage.hasPatientInstruction())?
                        baseDosage.getText() : baseDosage.getPatientInstruction());
            } else {
                // if we miss dose/rate, we cannot add anything structured to emediplan, use free text
                // if when is present, in this case, we should try to use text, since we cannot translate the when part
                if (baseDosage.hasWhen()) {
                    medicament.setApplicationInstructions((baseDosage.hasText() || !baseDosage.hasPatientInstruction())?
                            baseDosage.getText() : baseDosage.getPatientInstruction());
                } else {
                    //nothing is structured, use patient instruction
                    medicament.setApplicationInstructions(baseDosage.getPatientInstruction());
                }
            }
        }

        return posology;
    }

    /**
     * Converts a CH EMED EPR {@link Dose} to the appropriate {@link ChMed16ATakingTime} object.
     * <p>
     *     Note that the unit of the dose is ignored. The aim of this method is just to convert the quantity part of the
     *     dose object, since the unit is specified at a higher level in the eMediplan model.
     * </p>
     * @param chEmedEprDose The CH EMED EPR dose to be converted.
     * @return The resulting {@link ChMed16ATakingTime} object.
     */
    protected ChMed16ATakingTime getEMediplanTakingTimeFromChEmedEprDose(final Dose chEmedEprDose,
                                                                         final TimingEventAmbu timingEvent,
                                                                         final boolean inReserve,
                                                                         final @Nullable AmountQuantity maxDosePerAdministration
                                                                         ) {
        final var takingTime = new ChMed16ATakingTime();

        takingTime.setOffset(switch(timingEvent) {
            case MORNING -> 21600;
            case NOON -> 43200;
            case EVENING -> 64800;
            case NIGHT -> 0;
        });

        if (chEmedEprDose.isQuantity()) takingTime.setInitialDose(Double.parseDouble(chEmedEprDose.quantity().value()));
        else {
            takingTime.setInitialDose(Double.parseDouble(chEmedEprDose.low().value()));
            takingTime.setFinalDose(Double.parseDouble(chEmedEprDose.high().value()));
        }

        if (maxDosePerAdministration != null) takingTime.setAmount(Double.parseDouble(maxDosePerAdministration.value()));
        else {
            if (inReserve) {
                //The amount is mandatory, but it is missing, we copy the initial dose
                takingTime.setAmount(takingTime.getInitialDose());
            }
        }

        return takingTime;
    }

    protected void appendToApplicationInstructions(final ChMed16AMedicament med, final String extraContent) {
        if (med.getApplicationInstructions() == null || med.getApplicationInstructions().isEmpty())
            med.setApplicationInstructions(extraContent);
        else med.setApplicationInstructions(med.getApplicationInstructions().concat("\n").concat(extraContent));
    }

    protected abstract M getNewMedicamentInstance();
    protected abstract E getNewEmediplanInstance();
}
