package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanHealthcareOrganization;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanType;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprOrganization;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChMed23AHealthcareOrganization extends EMediplanHealthcareOrganization<ChMed23APostalAddress> {
    protected static final String GLN_FIELD_NAME = "gln";
    protected static final String NAME_FIELD_NAME = "name";
    protected static final String ZSR_FIELD_NAME = "zsr";

    /**
     * The GLN. Required if not set in the HealthcarePerson object, otherwise optional.
     */
    @JsonProperty(GLN_FIELD_NAME)
    protected @Nullable String gln;
    /**
     * Name of the organization.
     */
    @JsonProperty(NAME_FIELD_NAME)
    protected String name;
    /**
     * Postal address of the patient.
     */
    @JsonUnwrapped
    protected ChMed23APostalAddress address;
    /**
     * ZSR number. The ZSR number may only be set once, either in the HealthcarePerson object or in the
     * HealthcareOrganization object.
     */
    @JsonProperty(ZSR_FIELD_NAME)
    protected @Nullable String zsr;

    @Override
    @JsonIgnore
    protected String getNameFieldName() {
        return NAME_FIELD_NAME;
    }

    public ValidationResult validate(final @Nullable String basePath, final EMediplanType mediplanType) {
        final var result = validate(basePath);

        if (mediplanType == EMediplanType.PRESCRIPTION) {
            if (gln != null && !gln.isEmpty()) result.add(getIgnoredFieldValidationIssue(
                    getFieldValidationPath(basePath, GLN_FIELD_NAME),
                    "The healthcare organization's GLN is present but should not be included in eMediplan prescription documents. the healthcare professional GLN should be filled instead."
            ));
        }

        return result;
    }

    /**
     * Gets an eMediplan organization object from a CH EMED EPR organization object.
     * @param organization The CH EMED EPR organization object to be converted.
     * @return The resulting eMediplan object.
     */
    public static ChMed23AHealthcareOrganization fromChEmedEprOrganization(final ChEmedEprOrganization organization) {
        return fromChEmedEprOrganization(
                organization,
                ChMed23AHealthcareOrganization::new,
                ChMed23APostalAddress::fromFhirAddress
        );
    }
}
