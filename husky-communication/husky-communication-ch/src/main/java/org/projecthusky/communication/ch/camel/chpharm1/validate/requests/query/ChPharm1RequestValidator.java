/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.communication.ch.camel.chpharm1.validate.requests.query;

import org.openehealth.ipf.commons.core.modules.api.ValidationException;
import org.openehealth.ipf.commons.core.modules.api.Validator;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryReturnType;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter;
import org.openehealth.ipf.commons.ihe.xds.core.validate.*;
import org.openehealth.ipf.commons.ihe.xds.core.validate.query.*;
import org.projecthusky.communication.ch.camel.chpharm1.requests.query.ChPharm1QueryType;
import org.projecthusky.communication.ch.camel.validate.CodeEnumValidation;
import org.projecthusky.communication.ch.enums.beta.FormatCode;

import java.util.*;
import java.util.stream.Collectors;

import static org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter.*;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.*;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidatorAssertions.metaDataAssert;
import static org.projecthusky.communication.ch.camel.chpharm1.requests.query.ChPharm1QueryType.*;

/**
 * Validates a CH:PHARM-1 {@link EbXMLAdhocQueryRequest}.
 *
 * @author Jens Riemschneider
 * @author Quentin Ligier
 **/
public class ChPharm1RequestValidator implements Validator<EbXMLAdhocQueryRequest, ValidationProfile> {
    private static final CXValidator cxValidator = new CXValidator(true);
    private static final NopValidator nopValidator = new NopValidator();
    private static final Map<ChPharm1QueryType, Set<String>> ALLOWED_MULTIPLE_SLOTS;

    static {
        ALLOWED_MULTIPLE_SLOTS = new EnumMap<>(ChPharm1QueryType.class);

        addAllowedMultipleSlots(CH_FIND_MEDICATION_TREATMENT_PLANS,
                                DOC_ENTRY_EVENT_CODE,
                                DOC_ENTRY_CONFIDENTIALITY_CODE);

        addAllowedMultipleSlots(CH_FIND_PRESCRIPTIONS,
                                DOC_ENTRY_EVENT_CODE,
                                DOC_ENTRY_CONFIDENTIALITY_CODE);

        addAllowedMultipleSlots(CH_FIND_DISPENSES,
                                DOC_ENTRY_EVENT_CODE,
                                DOC_ENTRY_CONFIDENTIALITY_CODE);

        addAllowedMultipleSlots(CH_FIND_MEDICATION_ADMINISTRATIONS,
                                DOC_ENTRY_EVENT_CODE,
                                DOC_ENTRY_CONFIDENTIALITY_CODE);

        addAllowedMultipleSlots(CH_FIND_PRESCRIPTIONS_FOR_VALIDATION,
                                DOC_ENTRY_EVENT_CODE,
                                DOC_ENTRY_CONFIDENTIALITY_CODE);

        addAllowedMultipleSlots(CH_FIND_PRESCRIPTIONS_FOR_DISPENSE,
                                DOC_ENTRY_EVENT_CODE,
                                DOC_ENTRY_CONFIDENTIALITY_CODE);
    }


    private static void addAllowedMultipleSlots(final ChPharm1QueryType queryType,
                                                final QueryParameter... parameters) {
        var slotNames = Arrays.stream(parameters)
                .map(QueryParameter::getSlotName)
                .collect(Collectors.toSet());
        ALLOWED_MULTIPLE_SLOTS.put(queryType, slotNames);
    }

    private QueryParameterValidation[] getValidators(ChPharm1QueryType queryType, ValidationProfile profile) {
        var homeCommunityIdOptionality = profile.getInteractionProfile().getHomeCommunityIdOptionality(); // TODO

        return switch (queryType) {
            case CH_FIND_MEDICATION_TREATMENT_PLANS,
                    CH_FIND_PRESCRIPTIONS,
                    CH_FIND_DISPENSES,
                    CH_FIND_MEDICATION_ADMINISTRATIONS,
                    CH_FIND_PRESCRIPTIONS_FOR_VALIDATION,
                    CH_FIND_PRESCRIPTIONS_FOR_DISPENSE -> new QueryParameterValidation[]{
                    new StringValidation(DOC_ENTRY_PATIENT_ID, cxValidator, false),
                    new ChoiceValidation(true, DOC_ENTRY_UUID, DOC_ENTRY_UNIQUE_ID),
                    new StringListValidation(FOLDER_UUID, nopValidator),
                    new StringListValidation(FOLDER_UNIQUE_ID, nopValidator),
                    new CodeValidation(DOC_ENTRY_PRACTICE_SETTING_CODE),
                    new TimestampValidation(DOC_ENTRY_CREATION_TIME_FROM),
                    new TimestampValidation(DOC_ENTRY_CREATION_TIME_TO),
                    new TimestampValidation(DOC_ENTRY_SERVICE_START_TIME_FROM),
                    new TimestampValidation(DOC_ENTRY_SERVICE_START_TIME_TO),
                    new TimestampValidation(DOC_ENTRY_SERVICE_STOP_TIME_FROM),
                    new TimestampValidation(DOC_ENTRY_SERVICE_STOP_TIME_TO),
                    new CodeValidation(DOC_ENTRY_HEALTHCARE_FACILITY_TYPE_CODE),
                    new CodeValidation(DOC_ENTRY_EVENT_CODE),
                    new CodeValidation(DOC_ENTRY_CONFIDENTIALITY_CODE),
                    new StringListValidation(DOC_ENTRY_AUTHOR_PERSON, nopValidator),
                    new StatusValidation(DOC_ENTRY_STATUS),
                    new CodeValidation(DOC_ENTRY_FORMAT_CODE),
                    new CodeEnumValidation(DOC_ENTRY_FORMAT_CODE, true, EnumSet.of(
                            FormatCode.CH_EMED_MEDICATION_TREATMENT_PLAN,
                            FormatCode.CH_EMED_MEDICATION_PRESCRIPTION,
                            FormatCode.CH_EMED_MEDICATION_DISPENSE
                    )),
            };
            case CH_FIND_MEDICATION_LIST -> new QueryParameterValidation[]{
                    new StringValidation(DOC_ENTRY_PATIENT_ID, cxValidator, false),
                    new TimestampValidation(DOC_ENTRY_SERVICE_START_FROM),
                    new TimestampValidation(DOC_ENTRY_SERVICE_START_TO),
                    new TimestampValidation(DOC_ENTRY_SERVICE_END_FROM),
                    new TimestampValidation(DOC_ENTRY_SERVICE_END_TO),
                    new CodeEnumValidation(DOC_ENTRY_FORMAT_CODE, true, EnumSet.of(
                            FormatCode.CH_EMED_MEDICATION_TREATMENT_PLAN,
                            FormatCode.CH_EMED_MEDICATION_PRESCRIPTION,
                            FormatCode.CH_EMED_MEDICATION_DISPENSE
                    )),
                    new StatusValidation(DOC_ENTRY_STATUS),
                    new DocumentEntryTypeValidation(),
            };
            case CH_FIND_MEDICATION_CARD -> new QueryParameterValidation[]{
                    new StringValidation(DOC_ENTRY_PATIENT_ID, cxValidator, false),
                    new TimestampValidation(DOC_ENTRY_SERVICE_START_FROM),
                    new TimestampValidation(DOC_ENTRY_SERVICE_START_TO),
                    new TimestampValidation(DOC_ENTRY_SERVICE_END_FROM),
                    new TimestampValidation(DOC_ENTRY_SERVICE_END_TO),
                    new CodeEnumValidation(DOC_ENTRY_FORMAT_CODE, true, EnumSet.of(
                            FormatCode.CH_EMED_MEDICATION_CARD_DOCUMENT,
                            FormatCode.UNSTRUCTURED_EPR_DOCUMENT
                    )),
                    new StatusValidation(DOC_ENTRY_STATUS),
                    new DocumentEntryTypeValidation(),
                    // TODO: language
            };
        };
    }

    /**
     * @param request message to be validated
     * @param profile profile to be validated against
     * @throws ValidationException if the validation has failed due to non-conformance or internal errors.
     */
    @Override
    public void validate(final EbXMLAdhocQueryRequest request, final ValidationProfile profile) {
        Objects.requireNonNull(request, "request shall not be null in validate()");
        Objects.requireNonNull(profile, "profile shall not be null in validate()");

        metaDataAssert(QueryReturnType.LEAF_CLASS.getCode().equals(request.getReturnType())
                               || QueryReturnType.OBJECT_REF.getCode().equals(request.getReturnType()),
                       UNKNOWN_RETURN_TYPE, request.getReturnType());

        var queryType = ChPharm1QueryType.valueOfId(request.getId());
        metaDataAssert(queryType != null, UNKNOWN_QUERY_TYPE, request.getId());

        var allowedQueryTypes = EnumSet.of(
                CH_FIND_MEDICATION_TREATMENT_PLANS,
                CH_FIND_PRESCRIPTIONS,
                CH_FIND_DISPENSES,
                CH_FIND_MEDICATION_ADMINISTRATIONS,
                CH_FIND_PRESCRIPTIONS_FOR_VALIDATION,
                CH_FIND_PRESCRIPTIONS_FOR_DISPENSE,
                CH_FIND_MEDICATION_LIST,
                CH_FIND_MEDICATION_CARD);
        metaDataAssert(allowedQueryTypes.contains(queryType), UNSUPPORTED_QUERY_TYPE, queryType);

        SlotLengthAndNameUniquenessValidator.validateQuerySlots(
                request.getSlots(),
                ALLOWED_MULTIPLE_SLOTS.getOrDefault(queryType, Collections.emptySet()));
        for (var validation : getValidators(queryType, profile)) {
            validation.validate(request);
        }
    }
}
