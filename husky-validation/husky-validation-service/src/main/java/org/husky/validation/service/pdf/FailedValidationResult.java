package org.husky.validation.service.pdf;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.pdfa.results.Location;
import org.verapdf.pdfa.results.TestAssertion;
import org.verapdf.pdfa.results.ValidationResult;
import org.verapdf.pdfa.validation.profiles.ProfileDetails;
import org.verapdf.pdfa.validation.profiles.RuleId;
import org.verapdf.pdfa.validation.profiles.ValidationProfile;

import java.util.List;
import java.util.Objects;

/**
 * The PDF validation result for a single failure.
 */
final class FailedValidationResult implements ValidationResult {

    /**
     * The PDF flavour.
     */
    private final PDFAFlavour flavour;

    /**
     * The failure message.
     */
    private final String message;

    /**
     * Constructor.
     *
     * @param flavour The PDF flavour.
     * @param message The failure message.
     */
    public FailedValidationResult(final PDFAFlavour flavour,
                                  final String message) {
        this.flavour = Objects.requireNonNull(flavour);
        this.message = Objects.requireNonNull(message);
    }

    @Override
    public boolean isCompliant() {
        return false;
    }

    @Override
    public PDFAFlavour getPDFAFlavour() {
        return this.flavour;
    }

    @Override
    @Nullable
    public ProfileDetails getProfileDetails() {
        return null;
    }

    @Override
    public int getTotalAssertions() {
        return 1;
    }

    @Override
    public List<TestAssertion> getTestAssertions() {
        return List.of(
                new FailedTestAssertion(this.message)
        );
    }

    @Override
    @Nullable
    public ValidationProfile getValidationProfile() {
        return null;
    }

    public record FailedTestAssertion(String message) implements TestAssertion {

        public FailedTestAssertion(final String message) {
            this.message = Objects.requireNonNull(message);
        }

        @Override
        public int getOrdinal() {
            return 0;
        }

        @Override
        @Nullable
        public RuleId getRuleId() {
            return null;
        }

        @Override
        public Status getStatus() {
            return Status.FAILED;
        }

        @Override
        public String getMessage() {
            return this.message;
        }

        @Override
        @Nullable
        public Location getLocation() {
            return null;
        }
    }
}
