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
package org.husky.communication.ch.camel;

import org.husky.communication.ch.camel.chpharm5.ChPharm5TransactionConfiguration;
import org.openehealth.ipf.commons.ihe.core.IntegrationProfile;
import org.openehealth.ipf.commons.ihe.core.InteractionId;
import org.openehealth.ipf.commons.ihe.fhir.FhirInteractionId;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;

import java.util.Arrays;
import java.util.List;

/**
 * Definitions for the Swiss extensions of the MHD transactions defined in this module.
 *
 * @author Quentin Ligier
 **/
public class ChMhd implements IntegrationProfile {
    public static final ChMhd Instance = new ChMhd();

    public enum QueryDocumentReferenceInteractions implements FhirInteractionId<FhirQueryAuditDataset> {

        CHPHARM_5(CHPHARM_5_CONFIG);

        final FhirTransactionConfiguration<FhirQueryAuditDataset> fhirTransactionConfiguration;

        QueryDocumentReferenceInteractions(final FhirTransactionConfiguration<FhirQueryAuditDataset> fhirTransactionConfiguration) {
            this.fhirTransactionConfiguration = fhirTransactionConfiguration;
        }

        @Override
        public FhirTransactionConfiguration<FhirQueryAuditDataset> getFhirTransactionConfiguration() {
            return this.fhirTransactionConfiguration;
        }
    }

    @Override
    public List<InteractionId> getInteractionIds() {
        return Arrays.asList(QueryDocumentReferenceInteractions.values());
    }

    private static final ChPharm5TransactionConfiguration CHPHARM_5_CONFIG = new ChPharm5TransactionConfiguration();
}
