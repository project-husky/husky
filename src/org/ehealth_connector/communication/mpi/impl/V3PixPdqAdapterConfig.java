/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.communication.mpi.impl;

import java.net.URI;

/**
 * V3PixAdapterConfig configuration parameters for V3PixAdapter
 * 
 */
public class V3PixPdqAdapterConfig {

	/** The ATNA audit repository uri. */
	final public String auditRepositoryUri;

	/** The ATNA audit source id. */
	final public String auditSourceId;

	/** The domain to return namespace (optional). */
	final public String domainToReturnNamespace;

	/**
	 * The oid of the domain to return ids (optional, convenience if not other
	 * id for other domain oids are necessary) .
	 */
	final public String domainToReturnOid;

	/** The home community namespace (optional). */
	final public String homeCommunityNamespace;

	/** The home community oid. */
	final public String homeCommunityOid;

	/** oid of id domains which are not medical ids */
	final public String[] otherOidIds;

	/** The pdq consumer uri endpoint. */
	final public URI pdqConsumerUri;

	/** The pix query uri endpoint. */
	final public URI pixQueryUri;

	/** The pix source uri endpoint. */
	final public URI pixSourceUri;

	/** The receiver application oid. */
	final public String receiverApplicationOid;

	/** The receiver facility oid. */
	final public String receiverFacilityOid;

	/** The sender application oid. */
	final public String senderApplicationOid;

	/** The sender facility oid. */
	final public String senderFacilityOid;

	/**
	 * Instantiates a new v3 pix adapter config.
	 * 
	 * @param pixQueryUri
	 *            the pix query uri endpoint
	 * @param pixSourceUri
	 *            the pix source uri endpoint
	 * @param pdqConsumerUri
	 *            the pdq consumer uri endpoint
	 * @param senderApplicationOid
	 *            the sender application oid
	 * @param senderFacilityOid
	 *            the sender facility oid
	 * @param receiverApplicationOid
	 *            the receiver application oid
	 * @param receiverFacilityOid
	 *            the receiver facility oid
	 * @param homeCommunityOid
	 *            the home community oid
	 * @param homeCommunityNamespace
	 *            home community namespacec
	 * @param domainToReturnOid
	 *            The oid of the domain to return ids (optional, convenience if
	 *            not other id for other domain oids are necessary)
	 * @param domainToReturnNamespace
	 *            the domain to return namespace (optional)
	 * @param auditRepositoryUri
	 *            the ATNA audit repository uri
	 * @param auditSourceId
	 *            the ATNA audit source id
	 * @param otherOidIds
	 *            oid of id domains which are not medical ids
	 */
	public V3PixPdqAdapterConfig(URI pixQueryUri, URI pixSourceUri, URI pdqConsumerUri,
			String senderApplicationOid, String senderFacilityOid, String receiverApplicationOid,
			String receiverFacilityOid, String homeCommunityOid, String homeCommunityNamespace,
			String domainToReturnOid, String domainToReturnNamespace, String auditRepositoryUri,
			String auditSourceId, String[] otherOidIds) {
		super();
		this.pixQueryUri = pixQueryUri;
		this.pixSourceUri = pixSourceUri;
		this.pdqConsumerUri = pdqConsumerUri;
		this.senderApplicationOid = senderApplicationOid;
		this.senderFacilityOid = senderFacilityOid;
		this.receiverApplicationOid = receiverApplicationOid;
		this.receiverFacilityOid = receiverFacilityOid;
		this.homeCommunityOid = homeCommunityOid;
		this.homeCommunityNamespace = homeCommunityNamespace;
		this.domainToReturnOid = domainToReturnOid;
		this.domainToReturnNamespace = domainToReturnNamespace;
		this.auditRepositoryUri = auditRepositoryUri;
		this.auditSourceId = auditSourceId;
		this.otherOidIds = otherOidIds;
	}

}
