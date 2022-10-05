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
package org.projecthusky.communication.ch.camel.chpharm5.requests;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.Include;
import ca.uhn.fhir.rest.api.SortSpec;
import ca.uhn.fhir.rest.param.DateRangeParam;
import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.param.TokenOrListParam;
import ca.uhn.fhir.rest.param.TokenParam;
import org.projecthusky.communication.ch.camel.chpharm5.ChPharm5Operations;

import java.util.Set;

/**
 * husky
 *
 * @author Quentin Ligier
 **/
public class FindDispensesSearchParameters extends ChPharm5StableSearchParameters {
    public FindDispensesSearchParameters(final TokenParam patientIdentifier, final DateRangeParam date, final StringParam authorFamilyName, final StringParam authorGivenName, final TokenParam identifier, final TokenOrListParam status, final TokenOrListParam setting, final DateRangeParam period, final TokenOrListParam facility, final TokenOrListParam event, final TokenOrListParam securityLabel, final TokenOrListParam format, final ChPharm5Operations operation, final SortSpec sortSpec, final Set<Include> includeSpec, final FhirContext fhirContext) {
        super(patientIdentifier, date, authorFamilyName, authorGivenName, identifier, status, setting, period, facility, event, securityLabel, format, operation, sortSpec, includeSpec, fhirContext);
    }
}
