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
package org.projecthusky.communication.ch.camel.chpharm5;

import ca.uhn.fhir.context.FhirVersionEnum;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionValidator;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;

/**
 * Static configuration for FHIR CH:PHARM-5 transaction components
 *
 * @author Quentin Ligier
 **/
public class ChPharm5TransactionConfiguration extends FhirTransactionConfiguration<FhirQueryAuditDataset> {

        public ChPharm5TransactionConfiguration() {
            super("cmpd-chpharm5",
                    "CH:PHARM-5",
                    true,
                    new ChPharm5AuditStrategy(false),
                    new ChPharm5AuditStrategy(true),
                    FhirVersionEnum.R4,
                    new ChPharm5ResourceProvider(), // Consumer side. accept registrations
                    new ChPharm5ClientRequestFactory(),
                    FhirTransactionValidator.NO_VALIDATION);
            setSupportsLazyLoading(false);
        }
}
