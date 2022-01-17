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

import org.openehealth.ipf.commons.ihe.core.InteractionId;
import org.openehealth.ipf.commons.ihe.ws.WsTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.xds.XdsIntegrationProfile;
import org.openehealth.ipf.commons.ihe.xds.XdsInteractionId;
import org.openehealth.ipf.commons.ihe.xds.core.audit.XdsAuditDataset;

import java.util.Arrays;
import java.util.List;

/**
 * Definitions for the transactions defined in this module.
 *
 * @author Quentin Ligier
 **/
public class HuskyTransactions implements XdsIntegrationProfile {
    private static final HuskyTransactions Instance = new HuskyTransactions();


    public HuskyTransactions() {
    }

    public boolean isEbXml30Based() {
        return true;
    }

    public XdsIntegrationProfile.HomeCommunityIdOptionality getHomeCommunityIdOptionality() {
        return XdsIntegrationProfile.HomeCommunityIdOptionality.NEVER;
    }

    public List<InteractionId> getInteractionIds() {
        return Arrays.asList(HuskyTransactions.Interactions.values());
    }

    public enum Interactions implements XdsInteractionId {
        ;

        private final WsTransactionConfiguration<? extends XdsAuditDataset> wsTransactionConfiguration;

        public XdsIntegrationProfile getInteractionProfile() {
            return HuskyTransactions.Instance;
        }

        Interactions(WsTransactionConfiguration<? extends XdsAuditDataset> wsTransactionConfiguration) {
            this.wsTransactionConfiguration = wsTransactionConfiguration;
        }

        public WsTransactionConfiguration<? extends XdsAuditDataset> getWsTransactionConfiguration() {
            return this.wsTransactionConfiguration;
        }
    }
}
