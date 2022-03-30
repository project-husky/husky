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
package org.husky.communication.ch.camel.chpharm5;

import ca.uhn.fhir.model.api.IQueryParameterAnd;
import ca.uhn.fhir.model.api.IQueryParameterOr;
import ca.uhn.fhir.model.api.IQueryParameterType;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.gclient.IClientExecutable;
import ca.uhn.fhir.rest.gclient.ICriterion;
import ca.uhn.fhir.rest.gclient.IQuery;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.instance.model.api.IBaseBundle;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.DocumentReference;
import org.husky.communication.ch.camel.chpharm5.requests.ChPharm5SearchParameters;
import org.husky.communication.ch.camel.chpharm5.requests.ChPharm5StableSearchParameters;
import org.openehealth.ipf.commons.ihe.fhir.Constants;
import org.openehealth.ipf.commons.ihe.fhir.QueryClientRequestFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Request factory for CH:PHARM-5 requests.
 *
 * @author Christian Ohr
 * @author Quentin Ligier
 **/
public class ChPharm5ClientRequestFactory extends QueryClientRequestFactory<Bundle> {

    public ChPharm5ClientRequestFactory() {
        super(DocumentReference.class, Bundle.class);
    }

    // TODO: override getClientExecutable() to construct queries
    // https://hapifhir.io/hapi-fhir/docs/client/generic_client.html
    // .where().where().where() is ok

    /**
     * Returns a FHIR request using a FHIR client and a sequence of input data.
     *
     * @param client      FHIR client
     * @param requestData main request data (usually an implementation of {@link org.hl7.fhir.instance.model.api.IBaseResource}
     * @param parameters  parameter map
     * @return FHIR request executable.
     */
    @Override
    public IClientExecutable<IQuery<Bundle>, Bundle> getClientExecutable(final IGenericClient client,
                                                                         final Object requestData,
                                                                         final Map<String, Object> parameters) {
        IQuery<IBaseBundle> query;
        if (requestData instanceof final ICriterion<?> criterion) {
            query = client.search()
                    .forResource(DocumentReference.class)
                    .where(criterion);
        } else if (requestData instanceof final ChPharm5SearchParameters searchParameters) {
            query = client.search()
                    .forResource("DocumentReference/" + searchParameters.getOperation())
                    .where(this.getSearchParametersMap(searchParameters));

            /*var operation = client.operation()
                    .onType(DocumentReference.class)
                    .named(searchParameters.getOperation())
                    .withNoParameters(DocumentReference.class)
                    .useHttpGet()
                    .returnResourceType()*/
        } else {
            query = client.search()
                    .byUrl(requestData.toString());
        }
        if (parameters.containsKey(Constants.FHIR_COUNT)) {
            query.count(Integer.parseInt(parameters.get(Constants.FHIR_COUNT).toString()));
        }
        return query.returnBundle(Bundle.class);
    }

    protected Map<String, List<IQueryParameterType>> getSearchParametersMap(final ChPharm5SearchParameters searchParameters) {
        final Map<String, List<IQueryParameterType>> map = new HashMap<>();

        this.addParamToMap(map, "patient", searchParameters.getPatientIdentifier());
        this.addParamToMap(map, "format", searchParameters.getFormat());
        this.addParamToMap(map, "status", searchParameters.getStatus());


        if (searchParameters instanceof ChPharm5StableSearchParameters params) {
            this.addParamToMap(map, "date", params.getDate());
            this.addParamToMap(map, "period", params.getPeriod());
            this.addParamToMap(map, "identifier", params.getIdentifier());
            this.addParamToMap(map, "facility", params.getFacility());
            this.addParamToMap(map, "setting", params.getSetting());
            this.addParamToMap(map, "event", params.getEvent());
            this.addParamToMap(map, "security-label", params.getSecurityLabel());
            this.addParamToMap(map, "author.family", params.getAuthorFamilyName());
            this.addParamToMap(map, "author.given", params.getAuthorGivenName());
        }
        return map;
    }

    protected void addParamToMap(final Map<String, List<IQueryParameterType>> map,
                                 final String paramName,
                                 @Nullable final IQueryParameterType paramValue) {
        if (paramValue != null) {
            map.put(paramName, Collections.singletonList(paramValue));
        }
    }

    @SuppressWarnings("unchecked")
    protected void addParamToMap(final Map<String, List<IQueryParameterType>> map,
                                 final String paramName,
                                 @Nullable final IQueryParameterOr<? extends IQueryParameterType> paramValue) {
        if (paramValue != null) {
            map.put(paramName, (List<IQueryParameterType>) paramValue.getValuesAsQueryTokens());
        }
    }

    @SuppressWarnings("unchecked")
    protected void addParamToMap(final Map<String, List<IQueryParameterType>> map,
                                 final String paramName,
                                 @Nullable final IQueryParameterAnd<? extends IQueryParameterType> paramValue) {
        if (paramValue != null) {
            map.put(paramName, (List<IQueryParameterType>) paramValue.getValuesAsQueryTokens());
        }
    }
}
