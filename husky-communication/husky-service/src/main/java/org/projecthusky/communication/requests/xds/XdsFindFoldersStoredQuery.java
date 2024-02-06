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
package org.projecthusky.communication.requests.xds;

import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindFoldersQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.StoredQuery;
import org.projecthusky.common.utils.XdsMetadataUtil;

/**
 * Represents a query to find XDS folders
 */
@SuperBuilder
@ToString
public class XdsFindFoldersStoredQuery extends XdsRegistryStoredFindDocumentsQuery {
	
	public static abstract class XdsFindFoldersStoredQueryBuilder<C extends XdsFindFoldersStoredQuery, B extends XdsFindFoldersStoredQuery.XdsFindFoldersStoredQueryBuilder<C, B>> extends XdsRegistryStoredFindDocumentsQuery.XdsRegistryStoredFindDocumentsQueryBuilder<C, B> {}
	
  public StoredQuery getIpfQuery() {
    var findFoldersQuery = new FindFoldersQuery();
    findFoldersQuery.setPatientId(XdsMetadataUtil.convertEhcIdentificator(this.getPatientID()));
    findFoldersQuery.setStatus(this.getAvailabilityStatus());

    return findFoldersQuery;
  }
  
}
