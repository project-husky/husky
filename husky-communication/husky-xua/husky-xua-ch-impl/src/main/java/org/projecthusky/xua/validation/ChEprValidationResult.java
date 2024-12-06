/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.xua.validation;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.communication.ch.enums.stable.PurposeOfUse;
import org.projecthusky.communication.ch.enums.stable.Role;
import org.opensaml.saml.common.assertion.ValidationContext;
import org.opensaml.saml.common.assertion.ValidationResult;

import java.util.ArrayList;
import java.util.List;

import static org.projecthusky.xua.validation.ChEprAssertionValidationParameters.*;

/**
 * The result of a CH:EPR XUA SAML token validation.
 *
 * @author Quentin Ligier
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
        context.getValidationFailureMessages().add(message);
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
     * Returns the CH-EPR home community ID. It's the OID value, not URN-encoded.
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
     * </ul>
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
     * Returns the ID of the subject's organization or group registered in the HPD. It may be empty.  It's the OID
     * values, not URN-encoded.
     */
    @SuppressWarnings("unchecked")
    public List<String> getOrganizationsId() {
        return (List<String>) this.context.getDynamicParameters().getOrDefault(CH_EPR_ORGANIZATIONS_ID,
                new ArrayList<>());
    }
}
