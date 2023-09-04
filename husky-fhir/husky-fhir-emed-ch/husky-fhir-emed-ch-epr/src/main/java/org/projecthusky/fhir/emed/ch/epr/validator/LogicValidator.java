package org.projecthusky.fhir.emed.ch.epr.validator;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.enums.RegularUnitCodeAmbu;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprDocumentDis;
import org.projecthusky.fhir.emed.ch.epr.resource.mtp.ChEmedEprDocumentMtp;
import org.projecthusky.fhir.emed.ch.epr.resource.padv.ChEmedEprDocumentPadv;
import org.projecthusky.fhir.emed.ch.epr.resource.pml.*;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;
import org.projecthusky.fhir.emed.ch.epr.resource.pre.ChEmedEprDocumentPre;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Supplier;

/**
 * A logic validator for CH-EMED-EPR documents. It contains checks that are too difficult to implement in the FHIR IG.
 * <p>
 * It is to be executed by the public class {@link ChEmedEprValidator}.
 *
 * @author Quentin Ligier
 */
class LogicValidator {
    public static final String SOURCE = "LogicValidator";

    /**
     * Validates a CH-EMED-EPR document.
     *
     * @param document The document to validate.
     * @return a list of validation messages.
     */
    public List<@NonNull ValidationIssue> validate(final ChEmedEprDocument document) {
        final var issues = new ArrayList<@NonNull ValidationIssue>(0);

        if (document instanceof final ChEmedEprDocumentMtp mtpDocument) {
            final var mtpEntry = mtpDocument.resolveComposition().resolveMedicationStatement();
            validateDosages(mtpEntry.resolveBaseDosage(), mtpEntry.resolveAdditionalDosage(), issues);
        } else if (document instanceof final ChEmedEprDocumentPre preDocument) {
            final var preEntries = preDocument.resolveComposition().resolveMedicationRequests();
            for (final var preEntry : preEntries)
                validateDosages(preEntry.resolveBaseDosage(), preEntry.resolveAdditionalDosage(), issues);
        } else if (document instanceof final ChEmedEprDocumentDis disDocument) {
            final var disEntry = disDocument.resolveComposition().resolveMedicationDispense();
            validateDosages(disEntry.resolveBaseDosage(), disEntry.resolveAdditionalDosage(), issues);
        } else if (document instanceof final ChEmedEprDocumentPadv padvDocument) {
            final var medReqChangedEntry =
                    padvDocument.resolveComposition().resolveObservation().resolveMedicationRequestChanged();
            if (medReqChangedEntry != null) validateDosages(medReqChangedEntry.resolveBaseDosage(),
                                                            medReqChangedEntry.resolveAdditionalDosage(),
                                                            issues
                                                            );
            final var statementChangedEntry =
                    padvDocument.resolveComposition().resolveObservation().resolveMedicationStatementChanged();
            if (statementChangedEntry != null) validateDosages(statementChangedEntry.resolveBaseDosage(),
                                                               statementChangedEntry.resolveAdditionalDosage(),
                                                               issues
                                                               );
        } else if (document instanceof final ChEmedEprDocumentPml pmlDocument) {
            for(final var entry : pmlDocument.resolveComposition().resolveEntries()) {
                switch (entry.getEmedType()) {
                    case MTP -> {
                        final var mtpEntry = (ChEmedEprMedicationStatementPml) entry;
                        validateDosages(mtpEntry.resolveBaseDosage(), mtpEntry.resolveAdditionalDosage(), issues);
                    }
                    case PRE -> {
                        final var preEntry = (ChEmedEprMedicationRequestPml) entry;
                        validateDosages(preEntry.resolveBaseDosage(), preEntry.resolveAdditionalDosage(), issues);
                    }
                    case DIS -> {
                        final var disEntry = (ChEmedEprMedicationDispensePml) entry;
                        validateDosages(disEntry.resolveBaseDosage(), disEntry.resolveAdditionalDosage(), issues);
                    }
                    case PADV -> {
                        final var padvEntry = (ChEmedEprObservationPml) entry;
                        final var medReqChangedEntry = padvEntry.resolveMedicationRequestChanged();
                        if (medReqChangedEntry != null) validateDosages(medReqChangedEntry.resolveBaseDosage(),
                                medReqChangedEntry.resolveAdditionalDosage(),
                                issues
                        );
                        final var statementChangedEntry = padvEntry.resolveMedicationStatementChanged();
                        if (statementChangedEntry != null) validateDosages(statementChangedEntry.resolveBaseDosage(),
                                statementChangedEntry.resolveAdditionalDosage(),
                                issues
                        );
                    }
                }
            }
        } else if (document instanceof final ChEmedEprDocumentPmlc pmlcDocument) {
            for (final var statement : pmlcDocument.resolveComposition().resolveMedicationStatements())
                validateDosages(statement.resolveBaseDosage(), statement.resolveAdditionalDosage(), issues);
        }

        return issues;
    }


    public void validateDosages(final ChEmedEprDosage baseDosage,
                                final List<@NonNull ChEmedEprDosage> additionalDosages,
                                final List<@NonNull ValidationIssue> issues) {

        validateDosageQuantities(baseDosage, issues);
        for (final var additionalDosage : additionalDosages) validateDosageQuantities(additionalDosage, issues);

        if (additionalDosages.isEmpty()) {
            return;
        }
        // From here, there are additional dosages

        if (!baseDosage.hasDoseAndRate()) {
            issues.add(createError("Additional dosages shall not be present if the main dosage has no dose or rate"));
        }

        final var timingEventSeen = EnumSet.noneOf(TimingEventAmbu.class);
        for (final var timingEvent : baseDosage.resolveWhen()) {
            if (timingEventSeen.contains(timingEvent)) {
                issues.add(createError("The timing event '" + timingEvent.getCodeValue() + "' shall not appear multiple times"));
            }
            timingEventSeen.add(timingEvent);
        }
        for (final var additionDosage : additionalDosages) {
            for (final var timingEvent : additionDosage.resolveWhen()) {
                if (timingEventSeen.contains(timingEvent)) {
                    issues.add(createError("The timing event '" + timingEvent.getCodeValue() + "' shall not appear multiple times"));
                }
                timingEventSeen.add(timingEvent);
            }
        }
    }

    /**
     * Validates that the usage of the {@link RegularUnitCodeAmbu} value set are respected.
     *
     * @param dosage The dosage to be validated.
     * @param issues The list of issues to which newfound issues should be appended.
     */
    private void validateDosageQuantities(final ChEmedEprDosage dosage, final List<@NonNull ValidationIssue> issues) {
        resolveQuantity(dosage::resolveMaxDosePerAdministration, issues, "Error in maxDosePerAdministration: ");
        resolveQuantity(dosage::resolveMaxDosePerLifetime, issues, "Error in maxDosePerLifetime: ");
        resolveQuantity(dosage::resolveMaxDosePerPeriod, issues, "Error in maxDosePerLifetime: ");
        resolveQuantity(dosage::resolveDose, issues, "Error in dosage quantity/rate: ");
    }

    /**
     * Convenience method to test that a received supplier method does not throw an {@link IllegalArgumentException}. If
     * it does, an issue with the specified errorMessage plus the IllegalArgumentException message is added to the list
     * of issues.
     * @param supplier The supplier method to be executed.
     * @param issues The list of validation issues to which to append newfound issues.
     * @param errorMessage The error message to use as prefix if new issues are found.
     */
    private void resolveQuantity(Supplier supplier, final List<@NonNull ValidationIssue> issues, final String errorMessage) {
        try {
            supplier.get();
        } catch (IllegalArgumentException iae) {
            issues.add(
                    new ValidationIssue(
                        OperationOutcome.IssueSeverity.ERROR,
                        OperationOutcome.IssueType.CODEINVALID,
                        null,
                        errorMessage + iae.getMessage(),
                        null,
                        null,
                        SOURCE,
                        null
                    )
            );
        }
    }

    protected static ValidationIssue createError(final String message) {
        return new ValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                null,
                null,
                message,
                null,
                null,
                SOURCE,
                null
        );
    }
}
