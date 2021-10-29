package org.husky.xua.validation;

import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ASSISTANT_GLN;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ASSISTANT_NAME;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_AUDIENCE;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_HOME_COMMUNITY_ID;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ORGANIZATIONS_ID;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ORGANIZATIONS_NAME;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_PATIENT_EPR_SPID;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_PURPOSE_OF_USE;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_RESPONSIBLE_SUBJECT_ID;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_ROLE;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_SUBJECT_NAME;
import static org.husky.xua.validation.ChEprAssertionValidationParameters.CH_EPR_TCU_ID;

import java.util.ArrayList;
import java.util.List;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.communication.ch.enums.Role;
import org.husky.xua.communication.xua.impl.ch.PurposeOfUse;
import org.opensaml.saml.common.assertion.ValidationContext;
import org.opensaml.saml.common.assertion.ValidationResult;

/**
 *
 */
public class ChEprValidationResult {

    /**
     * The OpenSAML 4 {@link ValidationResult}.
     */
    private final ValidationResult result;

    /**
     * The OpenSAML 4 {@link ValidationContext} used.
     */
    private final ValidationContext context;

    /**
     * Constructor.
     *
     * @param result  The OpenSAML 4 {@link ValidationResult}.
     * @param context The OpenSAML 4 {@link ValidationContext} used.
     */
    public ChEprValidationResult(final ValidationResult result,
                                 final ValidationContext context) {
        this.result = result;
        this.context = context;
    }

    public static ChEprValidationResult valid(final ValidationContext context) {
        return new ChEprValidationResult(ValidationResult.VALID, context);
    }

    public static ChEprValidationResult invalid(final ValidationContext context,
                                                final String message) {
        context.setValidationFailureMessage(message);
        return new ChEprValidationResult(ValidationResult.INVALID, context);
    }

    /**
     * Returns the OpenSAML 4 {@link ValidationResult}.
     */
    public ValidationResult getResult() {
        return this.result;
    }

    /**
     * Returns the OpenSAML 4 {@link ValidationContext} used.
     */
    public ValidationContext getContext() {
        return this.context;
    }

    /**
     * Returns the CH-EPR role. Assistants and technical users are using their own code here while they use HCP in the
     * SAML attribute.
     */
    @Nullable
    public Role getRole() {
        return (Role) this.context.getDynamicParameters().get(CH_EPR_ROLE);
    }

    /**
     * Returns the CH-EPR purpose of use.
     */
    @Nullable
    public PurposeOfUse getPurposeOfUse() {
        return (PurposeOfUse) this.context.getDynamicParameters().get(CH_EPR_PURPOSE_OF_USE);
    }

    /**
     * Returns the CH-EPR home community ID.
     */
    @Nullable
    public String getHomeCommunityId() {
        return (String) this.context.getDynamicParameters().get(CH_EPR_HOME_COMMUNITY_ID);
    }

    /**
     * Returns the CH-EPR responsible subject ID.
     *
     * <p>For the following roles, it specifies:
     * <ul>
     *     <li>HCP: the GLN of the healthcare professional.
     *     <li>ASS: the GLN of the supervising healthcare professional.
     *     <li>TCU: the GLN of the supervising healthcare professional.
     *     <li>DADM: the unique ID the administrator is registered within the community.
     *     <li>PADM: the unique ID the administrator is registered within the community.
     *     <li>PAT: the patient EPR-SPID.
     *     <li>REP: the unique ID the representative is registered within the community.
     */
    @Nullable
    public String getResponsibleSubjectId() {
        return (String) this.context.getDynamicParameters().get(CH_EPR_RESPONSIBLE_SUBJECT_ID);
    }

    /**
     * Returns the CH-EPR assistant GLN or {@code null} if the role is not Assistant.
     */
    @Nullable
    public String getAssistantGln() {
        return (String) this.context.getDynamicParameters().get(CH_EPR_ASSISTANT_GLN);
    }

    /**
     * Returns the CH-EPR assistant name or {@code null} if the role is not Assistant.
     */
    @Nullable
    public String getAssistantName() {
        return (String) this.context.getDynamicParameters().get(CH_EPR_ASSISTANT_NAME);
    }

    /**
     * Returns the CH-EPR technical user unique ID.
     */
    @Nullable
    public String getTechnicalUserId() {
        return (String) this.context.getDynamicParameters().get(CH_EPR_TCU_ID);
    }

    /**
     * Returns the CH-EPR patient EPR-SPID.
     */
    @Nullable
    public String getPatientEprSpid() {
        return (String) this.context.getDynamicParameters().get(CH_EPR_PATIENT_EPR_SPID);
    }

    /**
     * Returns the subject name.
     */
    @Nullable
    public String getSubjectName() {
        return (String) this.context.getDynamicParameters().get(CH_EPR_SUBJECT_NAME);
    }

    /**
     * Returns the CH-EPR audience restriction.
     */
    @Nullable
    public String getAudienceRestriction() {
        return (String) this.context.getDynamicParameters().get(CH_EPR_AUDIENCE);
    }

    /**
     * Returns the subject's organization name as registered in the HPD. It may be empty.
     */
    @SuppressWarnings("unchecked")
    public List<String> getOrganizationsName() {
        return (List<String>) this.context.getDynamicParameters().getOrDefault(CH_EPR_ORGANIZATIONS_NAME,
                new ArrayList<>());
    }

    /**
     * Returns the ID of the subject's organization or group registered in the HPD. It may be empty.
     */
    @SuppressWarnings("unchecked")
    public List<String> getOrganizationsId() {
        return (List<String>) this.context.getDynamicParameters().getOrDefault(CH_EPR_ORGANIZATIONS_ID,
                new ArrayList<>());
    }
}
