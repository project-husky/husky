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
package org.husky.communication.ch.camel.chpharm1.transform.requests.query;

import org.husky.communication.ch.camel.chpharm1.requests.query.ChFindPrescriptionsForValidationQuery;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;

/**
 * Transforms between {@link ChFindPrescriptionsForValidationQuery} and {@link EbXMLAdhocQueryRequest}.
 *
 * @author Quentin Ligier
 **/
public class ChFindPrescriptionsForValidationQueryTransformer extends ChPharmacyStableDocumentsQueryTransformer<ChFindPrescriptionsForValidationQuery> {
}
