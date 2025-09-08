package org.projecthusky.fhir.emed.ch.epr.service;

import com.google.common.collect.Streams;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.enums.SubstanceAdministrationSubstitutionCode;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.model.common.Dose;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.*;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.*;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.EMediplanPosology;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.CyclicDosage;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.DailyDosage;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.FreeTextDosage;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.SingleDosage;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.application.ApplicationInSegment;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose.EMediplanDose;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose.RangeDose;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.dose.SimpleDose;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed.DaySegmentsDosage;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed.DoseOnlyDosage;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;

import java.util.List;
import java.util.stream.Stream;

/**
 * Utility class to convert CH EMED EPR documents to an eMediplan object equivalent.
 */
@Slf4j
public class EMediplanConverter {
    private EMediplanConverter() {}

    /**
     * Converts the received PMLC document to an eMediplan object.
     * @param pmlc The PMLC document to be converted.
     * @return An equivalent eMediplan object.
     */
    @ExpectsValidResource
    public static EMediplan toEMediplan(final ChEmedEprDocumentPmlc pmlc) {
        final EMediplan emediplan = new EMediplan();

        emediplan.setPatient(EMediplanPatient.fromEprFhir(
                pmlc.resolvePatient(),
                pmlc.resolveComposition().resolvePatientWeightObservation()
        ));
        // If the patient did not have a preferred language, we still need to fill it in the eMediplan since it is
        // mandatory for medication plans. The PMLC document language will be used in this case.
        if (emediplan.getPatient().getLanguageCode() == null || emediplan.getPatient().getLanguageCode().isBlank())
            emediplan.getPatient().setLanguageCode(
                    EMediplanPatient.fhirLanguageCodeToEMediplanLanguageCode(pmlc.resolveComposition().getLanguage()
                    )
            );

        final var lastStatement = pmlc.resolveLastStatement();
        if (lastStatement != null) {
            final var lastMedicalAuthor = lastStatement.resolveMedicalAuthor();
            if (lastMedicalAuthor.getPractitionerRole() != null) {
                emediplan.setHcPerson(EMediplanHealthcarePerson.fromChEmedEprPractitioner(lastMedicalAuthor.getPractitionerRole().resolvePractitioner()));
                emediplan.setHcOrg(EMediplanHealthcareOrganization.fromChEmedEprOrganization(lastMedicalAuthor.getPractitionerRole().resolveOrganization()));
                emediplan.setAuthor(EMediplanAuthor.HEALTHCARE_PERSON);
            } else emediplan.setAuthor(EMediplanAuthor.PATIENT);
        } else emediplan.setAuthor(EMediplanAuthor.PATIENT);

        /* Even though in principle we could do 1 treatment (so potentially several treatment lines / statements
           belonging to 1 treatment) -> 1 Medicament with each statement becoming one eMediplan posology object,
           CH EMED EPR does not enforce that the medication itself contained in the different statements belonging
           to one treatment are the same. This effectively means that to be on the safe side we should not group
           all statements belonging to one treatment into one medicament, and we are "forced" to do 1 PMLC statement
           -> 1 eMediplan medicament object.
         */
        for (final var statement : pmlc.resolveStatements()) {
            final var medicament = new EMediplanMedicament();
            final var medication = statement.resolveMedication();
            final var medicalAuthor = statement.resolveMedicalAuthor();
            if (medication.hasGtin()) {
                medicament.setId(medication.resolveGtinCode());
                medicament.setIdType(MedicamentIdType.GTIN);
            } else {
                medicament.setId(medication.resolveMedicationName());
                medicament.setIdType(MedicamentIdType.NONE);
            }

            medicament.setPosology(List.of(toPosology(statement.resolveBaseDosage(), statement.resolveAdditionalDosage(), true)));

            medicament.setReason(statement.getTreatmentReason());
            medicament.setSelfMedication(medicalAuthor.getPatient() != null || medicalAuthor.getRelatedPerson() != null);
            if (!medicament.isSelfMedication()) {
                medicament.setPrescriber(medicalAuthorToPrescriber(medicalAuthor));
            }
            if (statement.hasSubstitution())
                medicament.setForbidSubstitution(statement.resolveSubstitution() == SubstanceAdministrationSubstitutionCode.EQUIVALENT);

            emediplan.addMedicament(medicament);
        }

        emediplan.setType(EMediplanType.MEDICATION_PLAN);
        emediplan.setId(pmlc.resolveIdentifier().toString());

        emediplan.setTimestamp(pmlc.resolveTimestamp());

        return emediplan;
    }

    /**
     * Translates a {@link Author} to a prescriber string for eMediplan. The prescriber string, according to the
     * eMediplan specifications, consists of the prescriber's GLN number.
     *
     * @param author The CH EMED EPR Author from which to get a prescriber string.
     * @return The GLN of the practitioner author, if a professional author, {@code null} otherwise.
     */
    protected static @Nullable String medicalAuthorToPrescriber(final Author author) {
        if (author.getPractitionerRole() != null)
            return author.getPractitionerRole().resolvePractitioner().resolveGln();
        return null;
    }

    /**
     * Converts the list of Dosage objects of a CH EMED EPR resource (either medication statement or medication request)
     * to an {@link EMediplanPosology} object.
     *
     * @param baseDosage        The CH EMED EPR resource base dosage.
     * @param additionalDosages The CH EMED EPR list of additional dosages (if split dose). It can be empty.
     * @param setUnitIfAbsent   The eMediplan posology object unit will be set to N/A if the CH EMED EPR object has no
     *                          specified structured unit.
     * @return The equivalent eMediplan posology object.
     */
    protected static EMediplanPosology toPosology(final ChEmedEprDosage baseDosage,
                                                  List<@NonNull ChEmedEprDosage> additionalDosages,
                                                  boolean setUnitIfAbsent
                                                  ) {
        boolean freeTextDosage = false;
        final var posology = new EMediplanPosology();
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
                final var dailyDosage = new DailyDosage();
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
                posology.setDetail(dailyDosage);
            } else {
                /* there is a when and rate/quantity, but either the base dosage does not have range/quantity or some
                    additional dosages have range instead of quantity, a complex posology detail must be used
                 */
                final var segmentsDosage = new DaySegmentsDosage();
                Streams.concat(Stream.of(baseDosage), additionalDosages.stream())
                        .forEach(dosage ->
                            dosage.resolveWhen().forEach(when ->
                                    segmentsDosage.addApplication(new ApplicationInSegment(
                                            getEMediplanDoseFromChEmedEpr(dosage.resolveDose()),
                                            DaySegment.fromTimingEventAmbu(when)
                                    ))
                            )
                        );
                posology.setDetail(new SingleDosage(segmentsDosage));
            }
        } else {
            // No when or no dose/rate, hence there cannot be split dosage, we only care about base dosage
            if (baseDosage.hasDoseAndRate()) {
                // if we miss when, but there is doseAndRate, the CH EMED EPR convention is that it is a daily dosage.
                posology.setDetail(new CyclicDosage(TimeUnit.DAY, 1, new DoseOnlyDosage(getEMediplanDoseFromChEmedEpr(baseDose))));
            } else {
                // if we miss dose/rate, we cannot add anything structured to emediplan, use free text
                // if when is present, in this case, we should try to use text, since we cannot translate the when part
                if (baseDosage.hasWhen()) {
                    posology.setDetail(new FreeTextDosage(
                            (baseDosage.hasText() || !baseDosage.hasPatientInstruction())?
                                    baseDosage.getText() : baseDosage.getPatientInstruction()
                    ));
                } else {
                    //nothing is structured, use patient instruction
                    posology.setDetail(new FreeTextDosage(baseDosage.getPatientInstruction()));
                }
                freeTextDosage = true;
            }
        }

        // relative to meal is a best effort case, if it is one of the example codes of additionalInstruction, good,
        // no further effort will be done otherwise
        if (baseDosage.hasAdditionalInstruction()) {
            for (final var additionalInstruction : baseDosage.getAdditionalInstruction()) {
                final var relativeToMeal = RelativeToMeal.fromCodeableConcept(additionalInstruction);
                if (relativeToMeal != null) {
                    // only one relative to meal instruction is supported by eMediplan...
                    posology.setRelativeToMeal(relativeToMeal);
                    break;
                }
            }
        }

        if (baseDosage.hasDoseAndRate()) {
            if (baseDose.isQuantity())
                posology.setUnit(CdTyp9.fromRegularUnitCodeAmbu(baseDose.quantity().unit()));
            else
                posology.setUnit(CdTyp9.fromRegularUnitCodeAmbu(baseDose.low().unit()));
        } else if (setUnitIfAbsent) posology.setUnit(CdTyp9.UNKNOWN);

        // The tricky part of adding patient instructions is whether to know if they were already added as part of
        // free dosage text, or if they should be added as patient instructions.
        // Coded additionalInstruction can be ignored, since the IG specifies that they should also be part of
        // patientInstruction
        // If they were already added as free text dosage to the posology object, they should not be added as eMediplan
        // patient instructions, since the specs say that this should not contain the information stated as free text
        // dosage.
        if (!freeTextDosage) posology.setApplicationInstructions(baseDosage.getPatientInstruction());

        if (baseDosage.hasRoute())
            posology.setRouteOfAdministration(baseDosage.resolveRouteOfAdministration().getCodeValue());
        if (baseDosage.hasMethod())
            log.warn("Route of administration is in principle not supported by CH EMED EPR. Not added to the eMediplan.");

        return posology;
    }

    /**
     * Converts a CH EMED EPR {@link Dose} to the appropriate {@link EMediplanDose} object.
     * <p>
     *     Depending on whether the dose is a simple quantity or a range, the returned object will be an instance of
     *     {@link SimpleDose} or {@link RangeDose} respectively.
     * </p>
     * <p>
     *     Note that the unit of the dose is ignored. The aim of this method is just to convert the quantity part of the
     *     dose object, since the unit is specified at a higher level in the eMediplan model.
     * </p>
     * @param chEmedEprDose The CH EMED EPR dose to be converted.
     * @return The resulting {@link EMediplanDose} object.
     */
    protected static EMediplanDose getEMediplanDoseFromChEmedEpr(final Dose chEmedEprDose) {
        if (chEmedEprDose.isQuantity())
            return new SimpleDose(Double.parseDouble(chEmedEprDose.quantity().value()));
        else return new RangeDose(
                Double.parseDouble(chEmedEprDose.low().value()),
                Double.parseDouble(chEmedEprDose.high().value())
                );
    }
}
