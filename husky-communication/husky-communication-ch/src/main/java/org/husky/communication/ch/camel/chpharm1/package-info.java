/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */

/**
 * This is the definition of the CH:PHARM-1 transaction, an extension of IHE PHARM-1.
 *
 * <p>The Camel components are not redefined, those from the PHARM-1 transaction shall be used. The response models are
 * not redefined either, only the query models.
 *
 * @see org.openehealth.ipf.commons.ihe.xds.pharm1.Pharm1PortType
 * @see org.openehealth.ipf.platform.camel.ihe.xds.pharm1.Pharm1Service
 * @see org.openehealth.ipf.platform.camel.ihe.xds.pharm1.Pharm1Component
 * @see org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse
 *
 * @author Quentin Ligier
 **/
package org.husky.communication.ch.camel.chpharm1;