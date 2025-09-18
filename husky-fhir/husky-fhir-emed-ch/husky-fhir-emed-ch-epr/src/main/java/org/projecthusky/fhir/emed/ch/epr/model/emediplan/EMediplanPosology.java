package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.time.Instant;

/**
 * Base class for an eMediplan posology object.
 */
public abstract class EMediplanPosology implements EMediplanObject {
    protected static final boolean DEFAULT_AS_NEEDED_VALUE = false;

    public abstract @Nullable Instant getStart();
    public abstract @Nullable Instant getEnd();

    /**
     * An alias for {@link #isInReserve()}.
     */
    public final boolean isAsNeeded() {
        return isInReserve();
    }

    /**
     *
     * @return Whether the medication is in reserve or not. That is, whether it is to be taken only when needed (true)
     * or strictly as defined by the posology (false).
     */
    protected abstract boolean isInReserve();

    public abstract void setAsNeeded(final @Nullable Boolean inReserve);

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        final var result = new ValidationResult();

        if (getStart() != null && getEnd() != null && getEnd().isBefore(getStart())) result.add(getValidationIssue(
                OperationOutcome.IssueSeverity.ERROR,
                OperationOutcome.IssueType.INVALID,
                basePath == null? "" : basePath,
                "The end (to) date of the posology object cannot be lesser than the start (from) date."
        ));

        return result;
    }
}
