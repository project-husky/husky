package org.projecthusky.fhir.emed.ch.epr.service;

import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.enums.SubstanceAdministrationSubstitutionCode;
import org.projecthusky.fhir.emed.ch.epr.model.common.Author;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.*;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.CdTyp9;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.EMediplanAuthor;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.MedicamentIdType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.EMediplanPosology;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;

import java.util.List;

@Slf4j
public class EMediplanConverter {
    private EMediplanConverter() {}

    public static EMediplan toEMediplan(final ChEmedEprDocumentPmlc pmlc) {
        final EMediplan emediplan = new EMediplan();
        emediplan.setPatient(EMediplanPatient.fromEprFhir(pmlc.resolvePatient()));

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

            medicament.setPosology(List.of(toPosology(statement.resolveBaseDosage(), statement.resolveAdditionalDosage())));

            medicament.setReason(statement.getTreatmentReason());
            medicament.setSelfMedication(medicalAuthor.getPatient() != null || medicalAuthor.getRelatedPerson() != null);
            if (!medicament.isSelfMedication()) {
                medicament.setPrescriber(medicalAuthorToPrescriber(medicalAuthor));
            }
            if (statement.hasSubstitution())
                medicament.setForbidSubstitution(statement.resolveSubstitution() == SubstanceAdministrationSubstitutionCode.EQUIVALENT);
        }

        emediplan.setType(EMediplanType.MEDICATION_PLAN);
        emediplan.setId(pmlc.resolveIdentifier().toString());

        emediplan.setTimestamp(pmlc.resolveTimestamp());

        return emediplan;
    }

    protected static @Nullable String medicalAuthorToPrescriber(final Author author) {
        if (author.getPractitionerRole() != null)
            return author.getPractitionerRole().resolvePractitioner().resolveGln();
        return null;
    }

    protected static EMediplanPosology toPosology(final ChEmedEprDosage baseDosage,
                                                  List<@NonNull ChEmedEprDosage> additionalDosages) {
        final var posology = new EMediplanPosology();
        if (baseDosage.hasBoundsPeriod()) {
            if (baseDosage.getBoundsPeriod().hasStart())
                posology.setStart(baseDosage.getBoundsPeriod().getStartElement().getValueAsCalendar().toInstant());
            if (baseDosage.getBoundsPeriod().hasEnd())
                posology.setEnd(baseDosage.getBoundsPeriod().getEndElement().getValueAsCalendar().toInstant());
        }
        posology.setAsNeeded(baseDosage.isAsNeeded());
        //TODO detail
        //TODO relative to meal
        if (baseDosage.hasDoseAndRate()) {
            final var dose = baseDosage.resolveDose();
            if (dose.isQuantity())
                posology.setUnit(CdTyp9.fromRegularUnitCodeAmbu(dose.quantity().unit()));
            else
                posology.setUnit(CdTyp9.fromRegularUnitCodeAmbu(dose.low().unit()));
        }
        //TODO application instructions
        if (baseDosage.hasRoute())
            posology.setRouteOfAdministration(baseDosage.resolveRouteOfAdministration().getCodeValue());
        if (baseDosage.hasMethod())
            log.warn("Route of administration is in principle not supported by CH EMED EPR. Not added to the eMediplan.");

        return posology;
    }

    /*
    protected static boolean identifiersMatcher(final List<@NonNull Identifier> identifiersA,
                                                final List<@NonNull Identifier> identifiersB) {
        for (final var a : identifiersA) {
            for (final var b : identifiersB) {
                if (a.hasSystem() && b.hasSystem() && !a.getSystem().equals(b.getSystem())) continue;
                if (a.hasValue() && b.hasValue() && a.getValue().equals(b.getValue())) return true;
            }
        }
        return false;
    }

     */
}
