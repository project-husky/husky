package org.husky.validation.service.pdf;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.verapdf.pdfa.flavours.PDFAFlavour;
import org.verapdf.pdfa.results.Location;
import org.verapdf.pdfa.results.TestAssertion;
import org.verapdf.pdfa.results.ValidationResult;
import org.verapdf.pdfa.validation.profiles.ProfileDetails;
import org.verapdf.pdfa.validation.profiles.RuleId;
import org.verapdf.pdfa.validation.profiles.ValidationProfile;

import java.util.List;
import java.util.Objects;

final class FailedValidationResult implements ValidationResult {

    private final PDFAFlavour flavour;

    private final String message;

    public FailedValidationResult(@NonNull final PDFAFlavour flavour,
                                  @NonNull final String message) {
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
    public ValidationProfile getValidationProfile() {
        return null;
    }

    public static class FailedTestAssertion implements TestAssertion {

        private final String message;

        public FailedTestAssertion(@NonNull final String message) {
            this.message = Objects.requireNonNull(message);
        }

        @Override
        public int getOrdinal() {
            return 0;
        }

        @Override
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
        public Location getLocation() {
            return null;
        }
    }
}
