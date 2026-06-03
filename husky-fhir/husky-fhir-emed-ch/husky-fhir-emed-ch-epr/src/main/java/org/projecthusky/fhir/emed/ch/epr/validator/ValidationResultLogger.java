package org.projecthusky.fhir.emed.ch.epr.validator;

import lombok.Getter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.slf4j.Logger;
import org.slf4j.event.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * A logger class for validation results. This class allows for clients to specify issue filters and an issue severity
 * to logging level mapping to further refine logging.
 */
@Getter
public class ValidationResultLogger {
    public static final DefaultSeverityMapper  DEFAULT_SEVERITY_MAPPER = new DefaultSeverityMapper();

    private final Logger log;
    private final Function<OperationOutcome.@Nullable IssueSeverity, Level> severityMapper;

    private List<@NonNull Predicate<@NonNull ValidationIssue>> filters;
    private Predicate<@NonNull ValidationIssue> reducedFilters;

    public static Function<OperationOutcome.@Nullable IssueSeverity, Level> getDefaultSeverityMapper() {
        return DEFAULT_SEVERITY_MAPPER;
    }

    /**
     * Creates a validation result logger that will use the received SLF4J logger to do so.
     * <p>
     *     By default, this logger will use a no-op filtering (i.e. no filtering) and a {@link DefaultSeverityMapper}.
     * </p>
     *
     * @param log The SLF4J logger to be used to log the validation issues messages.
     */
    public ValidationResultLogger(final Logger log) {
        this.log = log;
        filters = new ArrayList<>();
        reducedFilters = issue -> true;
        severityMapper = getDefaultSeverityMapper();
    }

    /**
     * Creates a validation result logger that will use the received SLF4J logger to do so.
     * @param log            The SLF4J logger to be used to log the validation issues messages.
     * @param filters        The list of predicates to be used to filter out issues that should not be logged.
     * @param severityMapper The severity mapper between the validation issues severity and the logging level.
     */
    public ValidationResultLogger(final Logger log,
                                  final List<@NonNull Predicate<@NonNull ValidationIssue>> filters,
                                  final Function<OperationOutcome.@Nullable IssueSeverity, Level> severityMapper) {
        this.log = log;
        setFilters(filters);
        this.severityMapper = severityMapper;
    }

    /**
     * Adds a filter to the list of issue filters.
     * @param filter The filter to be applied. Note that if the result of applying the predicate is true, the issue will
     *               be logged.
     */
    public void addFilter(Predicate<@NonNull ValidationIssue> filter) {
        filters.add(filter);
        if (filters.size() == 1) reducedFilters = filter;
        else  reducedFilters = reducedFilters.and(filter);
    }

    /**
     * Sets the list of filters to be applied to the list of validation issues before being logged.
     * @param filters The list of filters to be applied.
     */
    public void setFilters(List<@NonNull Predicate<@NonNull ValidationIssue>> filters) {
        Objects.requireNonNull(filters);
        this.filters = filters;
        reducedFilters = filters.stream().reduce(Predicate::and).orElse(issue -> true);
    }

    /**
     * Logs the validation result.
     * @param validationResult The validation result to be logged.
     */
    protected void logValidationResult(final ValidationResult validationResult) {
        logAtLevel(
                validationResult.isSuccessful()? Level.INFO : Level.ERROR,
                String.format("Validation result: %s", validationResult.isSuccessful() ? "successful" : "failed")
        );

        for (final var issue : validationResult.getIssues()) {
            if (reducedFilters.test(issue))
                logAtLevel(severityMapper.apply(issue.getSeverity()), issue.toString());
        }
    }

    /**
     * Logs a message at the specified level.
     * @param level   The level at which to log the message.
     * @param message The message to be logged.
     */
    protected void logAtLevel(final Level level, final String message) {
        switch (level) {
            case ERROR:
                log.error(message);
                break;
            case WARN:
                log.warn(message);
                break;
            case INFO:
                log.info(message);
                break;
            case DEBUG:
                log.debug(message);
                break;
            case TRACE:
                log.trace(message);
                break;
            default:
                throw new UnsupportedOperationException("Unsupported level: " + level);
        }
    }

    public static class DefaultSeverityMapper implements Function<OperationOutcome.@Nullable IssueSeverity, Level> {
        @Override
        public Level apply(OperationOutcome.@Nullable IssueSeverity issueSeverity) {
            if (issueSeverity == null) return Level.INFO;
            return switch(issueSeverity) {
                case FATAL, ERROR -> Level.ERROR;
                case WARNING -> Level.WARN;
                case INFORMATION, NULL -> Level.INFO;
            };
        }
    }
}
