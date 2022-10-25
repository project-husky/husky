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
package org.projecthusky.communication.ch.camel.validate;

import org.projecthusky.common.enums.ValueSetEnumInterface;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.QuerySlotHelper;
import org.openehealth.ipf.commons.ihe.xds.core.validate.XDSMetaDataException;
import org.openehealth.ipf.commons.ihe.xds.core.validate.query.CodeValidation;

import java.util.EnumSet;
import java.util.Objects;

import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidationMessage.INVALID_QUERY_PARAMETER_VALUE;
import static org.openehealth.ipf.commons.ihe.xds.core.validate.ValidatorAssertions.metaDataAssert;

/**
 * Query parameter validation for parameters that are Code-based and bound to a value set.
 *
 * @author Quentin Ligier
 **/
public class CodeEnumValidation extends CodeValidation {

    private final QueryParameter queryParam;
    private final EnumSet<? extends ValueSetEnumInterface> authorizedValues;

    /**
     * Constructs a validation object.
     *
     * @param param parameter of the code to validate.
     * @param optional whether the code presence is optional.
     * @param authorizedValues authorized values.
     */
    public CodeEnumValidation(final QueryParameter param,
                              final boolean optional,
                              final EnumSet<? extends ValueSetEnumInterface> authorizedValues) {
        super(param, optional);
        Objects.requireNonNull(authorizedValues, "authorizedValues shall not be null in CodeEnumValidator()");
        this.authorizedValues = authorizedValues;
        this.queryParam = param;
    }

    /**
     * Validates a query parameter.
     *
     * @param request the query request.
     * @throws XDSMetaDataException if the validation failed.
     */
    @Override
    public void validate(final EbXMLAdhocQueryRequest request) throws XDSMetaDataException {
        super.validate(request);
        var slots = new QuerySlotHelper(request);
        var codes = slots.toCodeList(this.queryParam);

        if (codes != null) {
            for (var code : codes) {
                boolean authorized = false;
                for (var authorizedValue : this.authorizedValues) {
                    if (authorizedValue.isEqualTo(code)) {
                        authorized = true;
                        break;
                    }
                }
                metaDataAssert(authorized, INVALID_QUERY_PARAMETER_VALUE, this.queryParam);
            }
        }
    }
}
