package org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan;

import com.google.common.collect.Streams;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;
import org.projecthusky.fhir.emed.ch.epr.model.common.AmountQuantity;
import org.projecthusky.fhir.emed.ch.epr.model.common.Dose;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.CdTyp9;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.MedicamentIdType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.ChMed16AEMediplan;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.ChMed16AMedicament;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.ChMed16APatient;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.enums.CdTyp26;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.posology.ChMed16ADailyDosage;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.posology.ChMed16APosology;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.posology.ChMed16ATakingTime;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprMedicationStatementPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Utility class to convert CH EMED EPR documents to an eMediplan object equivalent according to the
 * <a href="https://github.com/ig-emediplan/specification/tree/main/chmed16a">CHMED16A specifications</a>.
 */
public non-sealed class ChMed16AConverter implements EMediplanConverter {
    /**
     * Converts the received PMLC document to an eMediplan object according to the
     * <a href="https://github.com/ig-emediplan/specification/tree/main/chmed16a">CHMED16A specifications</a>.
     *
     * @param pmlc The PMLC document to be converted.
     * @return A best-effort equivalent eMediplan object.
     */
    @Override
    @ExpectsValidResource
    public ChMed16AEMediplan toEMediplan(ChEmedEprDocumentPmlc pmlc) {
        final var emediplan = new ChMed16AEMediplan();

        emediplan.setPatient(ChMed16APatient.fromEprFhir(
                pmlc.resolvePatient(),
                pmlc.resolveComposition().resolvePatientWeightObservation()
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
        for (final var statement : pmlc.resolveStatements())
            emediplan.addMedicament(toMedicament(statement, true));

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

        // TODO add validator (gln) and date?

        return emediplan;
    }

    @Override
    @ExpectsValidResource
    public ChMed16AEMediplan toEMediplan(ChEmedEprDocumentPre pre) {
        //tODO to be implemented
        throw new UnsupportedOperationException("to be implemented");
    }

    /**
     * Converts a CH EMED EPR PMLC medication statement to a CHMED16A medicament object.
     * @param statement       The original CH EMED EPR PMLC medication statement to be converted.
     * @param setUnitIfAbsent Whether to set the unit in the eMediplan object if it is absent from the PMLC medication
     *                        statement.
     * @return The converted CHMED16A medicament object.
     */
    protected ChMed16AMedicament toMedicament(final ChEmedEprMedicationStatementPmlc statement, boolean setUnitIfAbsent) {
        final var medicament = new ChMed16AMedicament();

        final var medication = statement.resolveMedication();
        if (medication.hasGtin()) {
            medicament.setId(medication.resolveGtinCode());
            medicament.setIdType(MedicamentIdType.GTIN);
        } else {
            medicament.setId(medication.resolveMedicationName());
            medicament.setIdType(MedicamentIdType.NONE);
        }

        final var baseDosage = statement.resolveBaseDosage();
        medicament.setPosology(List.of(toPosology(baseDosage, statement.resolveAdditionalDosage(), medicament)));
        if (baseDosage.hasDoseAndRate()) {
            final var baseDose = baseDosage.resolveDose();
            if (baseDose.isQuantity())
                medicament.setUnit(CdTyp9.fromRegularUnitCodeAmbu(baseDose.quantity().unit()));
            else
                medicament.setUnit(CdTyp9.fromRegularUnitCodeAmbu(baseDose.low().unit()));
        } else if (setUnitIfAbsent) medicament.setUnit(CdTyp9.UNKNOWN);

        medicament.setReason(statement.getTreatmentReason());

        // The tricky part of adding patient instructions is whether to know if they were already added as part of
        // free dosage text, or if they should be added as patient instructions.
        // Coded additionalInstruction can be ignored, since the IG specifies that they should also be part of
        // patientInstruction
        // If they were already added as free text dosage to the posology object, they should not be added as eMediplan
        // patient instructions, since the specs say that this should not contain the information stated as free text
        // dosage.
        //if (!freeTextDosage) posology.setApplicationInstructions(baseDosage.getPatientInstruction());
        appendToApplicationInstructions(medicament, baseDosage.getPatientInstruction());

        final var medicalAuthor = statement.resolveMedicalAuthor();
        medicament.setSelfMedication(medicalAuthor.getPatient() != null || medicalAuthor.getRelatedPerson() != null);

        if (!medicament.isSelfMedication()) medicament.setPrescriber(medicalAuthorToPrescriber(medicalAuthor));

        if (baseDosage.hasRoute()) {
            medicament.setRouteOfAdministration(CdTyp26.fromEdqm(baseDosage.resolveRouteOfAdministration()));
            if (medicament.getRouteOfAdministration() == null) {
                // the route of administration could not be translated, add it as free text to the application instructions
                appendToApplicationInstructions(medicament, baseDosage.getRoute().getText());
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
     * @return The equivalent eMediplan posology object.
     */
    protected ChMed16APosology toPosology(final ChEmedEprDosage baseDosage,
                                          final List<@NonNull ChEmedEprDosage> additionalDosages,
                                          final ChMed16AMedicament medicament
                                          ) {
        // TODO remove freeTextDosage flag?
        boolean freeTextDosage = false;
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
                //TODO deal with in reserve with max dosages?
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
                //TODO deal with the max per period ?
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
                freeTextDosage = true;
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

    protected static void appendToApplicationInstructions(final ChMed16AMedicament med, final String extraContent) {
        if (med.getApplicationInstructions() == null || med.getApplicationInstructions().isEmpty())
            med.setApplicationInstructions(extraContent);
        else med.setApplicationInstructions(med.getApplicationInstructions().concat("\n").concat(extraContent));
    }
}
