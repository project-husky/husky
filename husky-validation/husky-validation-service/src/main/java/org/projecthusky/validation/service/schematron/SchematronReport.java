package org.projecthusky.validation.service.schematron;

import com.helger.schematron.svrl.jaxb.*;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.Objects;

/**
 * An extension of the ph-schematron {@link SchematronOutputType} with some added utility methods.
 *
 * @author Quentin Ligier
 */
public class SchematronReport extends SchematronOutputType {

    /**
     * Returns the list of failed asserts.
     */
    public List<@NonNull FailedAssert> getFailedAsserts() {
        return this.getActivePatternAndFiredRuleAndFailedAssert().stream()
                .filter(Objects::nonNull)
                .filter(FailedAssert.class::isInstance)
                .map(FailedAssert.class::cast)
                .toList();
    }

    /**
     * Returns the list of fired rules.
     */
    public List<@NonNull FiredRule> getFiredRules() {
        return this.getActivePatternAndFiredRuleAndFailedAssert().stream()
                .filter(Objects::nonNull)
                .filter(FiredRule.class::isInstance)
                .map(FiredRule.class::cast)
                .toList();
    }

    /**
     * Returns the list of active patterns.
     */
    public List<@NonNull ActivePattern> getActivePatterns() {
        return this.getActivePatternAndFiredRuleAndFailedAssert().stream()
                .filter(Objects::nonNull)
                .filter(ActivePattern.class::isInstance)
                .map(ActivePattern.class::cast)
                .toList();
    }

    /**
     * Returns the list of successful reports.
     */
    public List<@NonNull SuccessfulReport> getSuccessfulReports() {
        return this.getActivePatternAndFiredRuleAndFailedAssert().stream()
                .filter(Objects::nonNull)
                .filter(SuccessfulReport.class::isInstance)
                .map(SuccessfulReport.class::cast)
                .toList();
    }

    /**
     * Return whether the validation was successful or not. Every failed assert, whatever its role, is considered as
     * a failure. You should also check the number of fired rules, their absence isn't considered a failure.
     */
    public boolean isValid() {
        return this.getFailedAsserts().isEmpty();
    }
}
