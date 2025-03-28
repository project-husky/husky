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
package org.projecthusky.communication.ch.camel;

import org.openehealth.ipf.commons.ihe.core.InteractionId;
import org.openehealth.ipf.commons.ihe.ws.WsTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.xds.XdsIntegrationProfile;
import org.openehealth.ipf.commons.ihe.xds.XdsInteractionId;
import org.openehealth.ipf.commons.ihe.xds.core.audit.XdsAuditDataset;
import org.openehealth.ipf.commons.ihe.xds.core.audit.XdsQueryAuditDataset;
import org.openehealth.ipf.commons.ihe.xds.pharm1.Pharm1AuditStrategy;
import org.projecthusky.communication.ch.camel.chpharm1.ChPharm1PortType;

import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.List;

/**
 * Definitions for the Swiss extensions of the CMPD transactions defined in this module.
 *
 * @author Quentin Ligier
 **/
public class ChCmpd implements XdsIntegrationProfile {

    private static final ChCmpd Instance = new ChCmpd();

    public enum Interactions implements XdsInteractionId {
        CHPHARM_1(ITI_CHPHARM_1_WS_CONFIG);

        Interactions(final WsTransactionConfiguration<? extends XdsAuditDataset> wsTransactionConfiguration) {
            this.wsTransactionConfiguration = wsTransactionConfiguration;
        }

        private final WsTransactionConfiguration<? extends XdsAuditDataset> wsTransactionConfiguration;

        @Override
        public XdsIntegrationProfile getInteractionProfile() {
            return Instance;
        }

        @Override
        public WsTransactionConfiguration<? extends XdsAuditDataset> getWsTransactionConfiguration() {
            return this.wsTransactionConfiguration;
        }
    }

    public boolean isEbXml30Based() {
        return true;
    }

    @Override
    public HomeCommunityIdOptionality getHomeCommunityIdOptionality() {
        return HomeCommunityIdOptionality.NEVER;
    }

    @Override
    public List<InteractionId> getInteractionIds() {
        return Arrays.asList(ChCmpd.Interactions.values());
    }

    private static final WsTransactionConfiguration<XdsQueryAuditDataset> ITI_CHPHARM_1_WS_CONFIG = new WsTransactionConfiguration<>(
            "cmpd-chpharm1",
            "Query Pharmacy Documents",
            true,
            new Pharm1AuditStrategy(false),
            new Pharm1AuditStrategy(true),
            new QName("urn:ihe:iti:xds-b:2007", "CommunityPharmacyManager_Service", "ihe"),
            ChPharm1PortType.class,
            new QName("urn:ihe:iti:xds-b:2007", "CommunityPharmacyManager_Binding_Soap12", "ihe"),
            false,
            "wsdl/pharm1.wsdl",
            true,
            false,
            true,
            false);
}
