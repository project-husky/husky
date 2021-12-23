package org.husky.xua.validation;

import static org.opensaml.saml.saml2.assertion.SAML2AssertionValidationParameters.*;

/**
 * Parameter keys used to store and retrieve dynamic parameters within a {@link org.opensaml.saml.common.assertion.ValidationContext}
 * while using the {@link ChEprAssertionValidator}.
 */
public class ChEprAssertionValidationParameters {

    /**
     * Carries a {@link org.husky.communication.ch.enums.Role} specifying the CH-EPR Role. Assistants and technical
     * users are using their own code here while the SAML role is HCP.
     */
    public static final String CH_EPR_ROLE = STD_PREFIX + STMT_INFIX + ".ChEprRole";
    /**
     * Carries a {@link String} specifying the ID of the responsible subject.
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
    public static final String CH_EPR_RESPONSIBLE_SUBJECT_ID = STD_PREFIX + COND_INFIX + ".ChEprResponsibleSubjectId";
    /**
     * Carries a {@link String} specifying the GLN of the assistant.
     */
    public static final String CH_EPR_ASSISTANT_GLN = STD_PREFIX + COND_INFIX + ".ChEprAssistantGln";
    /**
     * Carries a {@link String} specifying the name of the assistant.
     */
    public static final String CH_EPR_ASSISTANT_NAME = STD_PREFIX + SC_INFIX + ".ChEprAssistantName";
    /**
     * Carries a {@link String} specifying the unique ID the technical user is registered within the community.
     */
    public static final String CH_EPR_TCU_ID = STD_PREFIX + COND_INFIX + ".ChEprTcuId";
    /**
     * Carries a {@link org.husky.communication.ch.enums.PurposeOfUse} specifying the purpose of use.
     */
    public static final String CH_EPR_PURPOSE_OF_USE = STD_PREFIX + STMT_INFIX + ".ChEprPurposeOfUse";
    /**
     * Carries a {@link String} specifying the home community ID.
     */
    public static final String CH_EPR_HOME_COMMUNITY_ID = STD_PREFIX + STMT_INFIX + ".ChEprHomeCommunityId";
    /**
     * Carries a {@link String} specifying the EPR-SPID identifier of the patient's record.
     */
    public static final String CH_EPR_PATIENT_EPR_SPID = STD_PREFIX + STMT_INFIX + ".ChEprPatientEprSpid";
    /**
     * Carries a {@link String} specifying the subject's real world name as plain text.
     */
    public static final String CH_EPR_SUBJECT_NAME = STD_PREFIX + STMT_INFIX + ".ChEprSubjectName";
    /**
     * Carries a {@link java.util.List<String>} specifying a plain text the subject's organization name as registered in
     * the HPD or empty, if not known.
     */
    public static final String CH_EPR_ORGANIZATIONS_NAME = STD_PREFIX + STMT_INFIX + ".ChEprOrganizationsName";
    /**
     * Carries a {@link java.util.List<String>} specifying the ID of the subject's organization or group registered in
     * the HPD or empty, if not known.
     */
    public static final String CH_EPR_ORGANIZATIONS_ID = STD_PREFIX + STMT_INFIX + ".ChEprOrganizationsId";
    /**
     * Carries a {@link String} specifying the audience restriction.
     */
    public static final String CH_EPR_AUDIENCE = STD_PREFIX + COND_INFIX + ".ChEprAudience";

    /**
     * This class is not instantiable.
     */
    private ChEprAssertionValidationParameters() {
    }
}
