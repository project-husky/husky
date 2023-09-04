package org.projecthusky.fhir.emed.ch.epr.validator.logicvalidator;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.enums.RegularUnitCodeAmbu;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprDocument;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationIssue;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public abstract class ChEmedEprDocValidator<T extends ChEmedEprDocument> {
    protected static final String SOURCE = "ChEmedEprDocValidator";
    /**
     * The list of issues to which newfound issues should be appended.
     */
    protected final List<@NonNull ValidationIssue> issues;
    protected final T document;

    protected ChEmedEprDocValidator(T document) {
        this(document, new ArrayList<>(0));
    }
    protected ChEmedEprDocValidator(T document, final List<@NonNull ValidationIssue> issues) {
        this.document = document;
        this.issues = Objects.requireNonNull(issues);
    }

    public abstract List<@NonNull ValidationIssue> validate();

    public void clearIssues() {
        this.issues.clear();
    }

    public List<@NonNull ValidationIssue> getIssues() {
        return this.issues;
    }

    protected void validateDosages(final ChEmedEprDosage baseDosage,
                                   final List<@NonNull ChEmedEprDosage> additionalDosages
                                   ) {

        validateDosageQuantities(baseDosage);
        for (final var additionalDosage : additionalDosages) validateDosageQuantities(additionalDosage);

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
     */
    protected void validateDosageQuantities(final ChEmedEprDosage dosage) {
        resolveQuantity(dosage::resolveMaxDosePerAdministration, "Error in maxDosePerAdministration: ");
        resolveQuantity(dosage::resolveMaxDosePerLifetime, "Error in maxDosePerLifetime: ");
        resolveQuantity(dosage::resolveMaxDosePerPeriod, "Error in maxDosePerLifetime: ");
        resolveQuantity(dosage::resolveDose, "Error in dosage quantity/rate: ");
    }

    /**
     * Convenience method to test that a received supplier method does not throw an {@link IllegalArgumentException}. If
     * it does, an issue with the specified errorMessage plus the IllegalArgumentException message is added to the list
     * of issues.
     * @param supplier The supplier method to be executed.
     * @param errorMessage The error message to use as prefix if new issues are found.
     */
    protected void resolveQuantity(Supplier supplier, final String errorMessage) {
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

    protected ValidationIssue createError(final String message) {
        return new ValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                null,
                null,
                message,
                null,
                null,
                getSource(),
                null
        );
    }

    protected String getSource() {
        return SOURCE;
    }
}
