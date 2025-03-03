package org.projecthusky.communication.xdsmhdconversion.utils;

import ca.uhn.fhir.rest.param.DateRangeParam;
import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.param.TokenOrListParam;
import ca.uhn.fhir.rest.param.TokenParam;
import ca.uhn.fhir.rest.server.exceptions.InvalidRequestException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.communication.xdsmhdconversion.model.XdsTimeRange;
import org.projecthusky.fhir.structures.utils.SystemMapper;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

/**
 * Utilities for MHD "Find" transactions (ITI-66 and ITI-67).
 *
 * @author Quentin Ligier
 */
public class FindQueryUtils {

    /**
     * Converts a list of token from a FHIR search parameter to a list of XDS {@link Code}s and maps the FHIR system
     * URIs to XDS system OIDs if the mapping exists. The tokens shall not have a modifier.
     *
     * @param tokenOrListParam The FHIR tokens search parameter.
     * @param codeList         The XDS code list.
     * @param paramName        The name of the FHIR parameter.
     */
    public static void parseCodeList(final @Nullable TokenOrListParam tokenOrListParam,
                                        final List<@NonNull Code> codeList,
                                        final String paramName) throws InvalidRequestException {
        Objects.requireNonNull(codeList);
        Objects.requireNonNull(paramName);
        try {
            codeList.addAll(toXdsCodeList(tokenOrListParam));
        } catch (InvalidRequestException e) {
            throw invalidRequestException(
                    OperationOutcome.IssueType.INVALID,
                    "The search parameter '%s' is invalid: %s",
                    paramName,
                    e.getMessage()
            );
        }
    }

    /**
     * Converts a list of token from a FHIR search parameter to a list of strings. The tokens shall not have a system or
     * a modifier.
     *
     * @param tokens     The FHIR tokens search parameter.
     * @param stringList The string list.
     * @param paramName  The name of the FHIR parameter.
     */
    public static void parseStringList(final @Nullable TokenOrListParam tokens,
                                       final List<@NonNull String> stringList,
                                       final String paramName) throws InvalidRequestException {
        Objects.requireNonNull(stringList);
        Objects.requireNonNull(paramName);
        if (tokens == null) {
            return;
        }
        for (final TokenParam token : tokens.getValuesAsQueryTokens()) {
            if (token.getModifier() != null)
                throw invalidRequestException(
                        OperationOutcome.IssueType.INVALID,
                        "In search parameter '%s', the modifier '%s' is unexpected",
                        paramName,
                        token.getModifier().getValue()
                );
            if (token.getSystem() != null)
                throw invalidRequestException(
                        OperationOutcome.IssueType.INVALID,
                        "In search parameter '%s', the system '%s' is unexpected",
                        paramName,
                        token.getSystem()
                );
            if (token.getValue() != null) {
                stringList.add(token.getValue());
            }
        }
    }

    /**
     * Parses the query parameter 'status' as a set of {@link AvailabilityStatus} and adds it to the corresponding field
     * of the find document query. It is required and limited to 'current' and 'superseded' values.
     *
     * @param statusTokens The FHIR search parameters 'status'.
     * @param statusList   The list of XDS availability status to be filled.
     */
    public static void parseStatusParam(final @Nullable TokenOrListParam statusTokens,
                                        final List<AvailabilityStatus> statusList) throws InvalidRequestException {
        Objects.requireNonNull(statusList);
        if (statusTokens != null) {
            final EnumSet<AvailabilityStatus> statuses = EnumSet.noneOf(AvailabilityStatus.class);
            for (final TokenParam token : statusTokens.getValuesAsQueryTokens()) {
                if (token.getModifier() != null)
                    throw invalidRequestException(
                            OperationOutcome.IssueType.NOTSUPPORTED,
                            "The parameter '%s' contains an unsupported modifier '%s'",
                            DocumentReference.SP_STATUS,
                            token.getModifier().getValue()
                    );
                if (token.getSystem() != null)
                    throw invalidRequestException(
                            OperationOutcome.IssueType.INVALID,
                            "The parameter '%s' shall not contain a token system",
                            DocumentReference.SP_STATUS
                    );
                if (Enumerations.DocumentReferenceStatus.CURRENT.toCode().equals(token.getValue()))
                    statuses.add(AvailabilityStatus.APPROVED);
                else if (Enumerations.DocumentReferenceStatus.SUPERSEDED.toCode().equals(token.getValue()))
                    statuses.add(AvailabilityStatus.DEPRECATED);
                else
                    throw invalidRequestException(
                            OperationOutcome.IssueType.VALUE,
                            "The parameter '%s' contains an invalid value '%s'",
                            DocumentReference.SP_STATUS,
                            token.getValue()
                    );
            }

            statusList.addAll(statuses);
        }
    }

    /**
     * Converts a string token from a FHIR search parameter to a list of XDS authors.
     * <p>
     * IPF does not accept modifiers for these fields.
     *
     * @param stringParam The FHIR search parameters.
     * @param authors     The list of author.
     */
    public static void parseAuthor(final @Nullable StringParam stringParam,
                                   final List<@NonNull String> authors) {
        if (stringParam == null) {
            return;
        }
        Objects.requireNonNull(authors).add(stringParam.getValue());
    }

    /**
     * Converts a string token from a FHIR search parameter to a string of XDS author.
     * <p>
     * IPF does not accept modifiers for these fields.
     *
     * @param stringParam The FHIR search parameters.
     * @param author      The author.
     */
    public static String parseAuthor(final @Nullable StringParam stringParam,
                                     final String author) {
        if (stringParam == null) {
            return author;
        }

        if (author == null) {
            return stringParam.getValue();
        } else {
            return author + "%" + stringParam.getValue();
        }
    }

    /**
     * Constructs an XDS time range from a FHIR date range.
     * <p>
     * XDS time range is compared with an inclusive lower bound and an exclusive upper bound. The instants returned by
     * the {@link DateRangeParam} are both inclusive, so the upper bound is shifted by one second.
     *
     * @param dateRange The FHIR date range search parameter.
     * @return the equivalent XDS time range.
     */
    public static XdsTimeRange toXdsTimeRange(final @Nullable DateRangeParam dateRange) {
        final XdsTimeRange xdsTimeRange = new XdsTimeRange();
        if (dateRange == null) {
            return xdsTimeRange;
        }
        if (dateRange.getLowerBound() != null) {
            xdsTimeRange.setLower(dateRange.getLowerBoundAsInstant().toInstant());
        }
        if (dateRange.getUpperBound() != null) {
            xdsTimeRange.setUpper(
                dateRange.getUpperBoundAsInstant().toInstant().plus(1, ChronoUnit.SECONDS)
            );
        }
        return xdsTimeRange;
    }

    /**
     * Converts a list of token from a FHIR search parameter to a list of XDS {@link Code}s and maps the FHIR system
     * URIs to XDS system OIDs if the mapping exists.
     *
     * @param tokens The list of FHIR tokens.
     * @return a list of equivalent XDS codes.
     * @throws InvalidRequestException if a token is invalid.
     */
    public static List<@NonNull Code> toXdsCodeList(final @Nullable TokenOrListParam tokens) throws InvalidRequestException {
        final List<@NonNull Code> codes = new ArrayList<>(0);
        if (tokens == null) {
            return codes;
        }
        for (final TokenParam token : tokens.getValuesAsQueryTokens()) {
            if (token.getModifier() != null)
                throw invalidRequestException(
                        OperationOutcome.IssueType.NOTSUPPORTED,
                        "The modifier '%s' is unexpected",
                        token.getModifier().getValue()
                );
            SystemMapper.SystemEntry system = null;
            if (token.getSystem() != null) {
                system = (Oids.match(token.getSystem()))?
                        SystemMapper.findByOid(Oids.normalize(token.getSystem())) :
                        SystemMapper.findByUri(token.getSystem());
            }
            codes.add(new Code(
                    token.getValue(),
                    null,
                    (system != null) ? system.systemOid() : Oids.normalize(token.getSystem())
            ));
        }

        return codes;
    }


    public static InvalidRequestException invalidRequestException(final OperationOutcome.IssueType type,
                                                                     final String message,
                                                                     final Object... args) {
        final var msg = String.format(message,  args);
        final var operationOutcome = new OperationOutcome();
        operationOutcome.addIssue()
                .setSeverity(OperationOutcome.IssueSeverity.ERROR)
                .setCode(type)
                .setDiagnostics(msg);

        final var exception = new InvalidRequestException(msg);
        exception.setOperationOutcome(operationOutcome);
        return exception;
    }
}
