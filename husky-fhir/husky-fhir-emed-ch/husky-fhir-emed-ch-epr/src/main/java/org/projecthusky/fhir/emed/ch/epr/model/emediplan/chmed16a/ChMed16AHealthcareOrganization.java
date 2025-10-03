package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanHealthcareOrganization;
import org.projecthusky.fhir.emed.ch.epr.resource.ChEmedEprOrganization;

/**
 * The model for a healthcare organization, to which the healthcare person belongs. This CHMED16A version is to be used
 * exclusively in the context of the ePrescription, hence with {@link EPrescription}, since it is not supported by the
 * initial release of the eMediplan specs.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChMed16AHealthcareOrganization extends EMediplanHealthcareOrganization<ChMed16AExtendedPostalAddress> {
    protected static final String NAME_FIELD_NAME = "Name";
    protected static final String NAME_AFFIX_FIELD_NAME = "NameAffix";
    protected static final String ZSR_FIELD_NAME = "Zsr";
    protected static final String PHONE_NUMBER_FIELD_NAME = "Phone";
    protected static final String EMAIL_ADDRESS_FIELD_NAME = "Email";

    /**
     * Name of the organization.
     */
    @JsonProperty(NAME_FIELD_NAME)
    protected String name;
    /**
     * Additional name, e.g. department within the organization. Optional.
     */
    @JsonProperty(NAME_AFFIX_FIELD_NAME)
    protected @Nullable String nameAffix;
    @JsonUnwrapped
    protected ChMed16AExtendedPostalAddress address;
    /**
     * ZSR number. The ZSR number may only be set once, either in object HealthcarePerson or in object
     * HealthcareOrganization (or none at all).
     */
    @JsonProperty(ZSR_FIELD_NAME)
    protected @Nullable String zsr;
    /**
     * Phone number.
     */
    @JsonProperty(PHONE_NUMBER_FIELD_NAME)
    protected @Nullable String phoneNumber;
    /**
     * email address.
     */
    @JsonProperty(EMAIL_ADDRESS_FIELD_NAME)
    protected @Nullable String email;

    @Override
    protected String getNameFieldName() {
        return NAME_FIELD_NAME;
    }

    @Override
    public void trim() {
        super.trim();

        if (nameAffix != null && nameAffix.isBlank()) nameAffix = null;
        if (zsr != null && zsr.isBlank()) zsr = null;
        if (phoneNumber != null && phoneNumber.isBlank()) phoneNumber = null;
        if (email != null && email.isBlank()) email = null;
    }

    /**
     * Gets an eMediplan organization object from a CH EMED EPR organization object.
     * @param organization The CH EMED EPR organization object to be converted.
     * @return The resulting eMediplan object.
     */
    public static ChMed16AHealthcareOrganization fromChEmedEprOrganization(final ChEmedEprOrganization organization) {
        return fromChEmedEprOrganization(
                organization,
                ChMed16AHealthcareOrganization::new,
                ChMed16AExtendedPostalAddress::fromFhirAddress
        );
    }
}
