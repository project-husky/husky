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
package org.projecthusky.communication.xd.storedquery;

import org.openehealth.ipf.commons.ihe.xds.core.requests.query.Query;

/**
 * Interface for convenience stored queries
 */
public interface StoredQueryInterface {

	/**
	 * Gets the IPF Query object, which is being wrapped by this class
	 *
	 * @return the IPF Query
	 */
	public Query getIpfQuery();
}
