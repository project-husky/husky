/*
 * 
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 * 
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 * 
 * This code is made available under the terms of the Eclipse Public License v1.0.
 * 
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 * 
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 * 
 */
package org.ehealth_connector.communication.mpi.impl;

import java.net.URI;

/**
 * V3PixAdapterConfig configuration parameters for V3PixAdapter
 *
 */
public class V3PixPdqAdapterConfig {

	/** The ATNA audit repository uri. */
	final private String auditRepositoryUri;

	/** The ATNA audit source id. */
	final private String auditSourceId;

	/** The domain to return namespace (optional). */
	final private String domainToReturnNamespace;

	/**
	 * The oid of the domain to return ids (optional, convenience if not other
	 * id for other domain oids are necessary) .
	 */
	final private String domainToReturnOid;

	/** The home community namespace (optional). */
	final private String homeCommunityNamespace;

	/** The home community oid. */
	final private String homeCommunityOid;

	/** oid of id domains which are not medical ids */
	final private String[] otherOidIds;

	/** The pdq consumer uri endpoint. */
	final private URI pdqConsumerUri;

	/** The pix query uri endpoint. */
	final private URI pixQueryUri;

	/** The pix source uri endpoint. */
	final private URI pixSourceUri;

	/** The receiver application oid. */
	final private String receiverApplicationOid;

	/** The receiver facility oid. */
	final private String receiverFacilityOid;

	/** The sender application oid. */
	final private String senderApplicationOid;

	/** The sender facility oid. */
	final private String senderFacilityOid;

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

	/**
	 * Method to get
	 *
	 * @return the auditRepositoryUri
	 */
	public String getAuditRepositoryUri() {
		return auditRepositoryUri;
	}

	/**
	 * Method to get
	 *
	 * @return the auditSourceId
	 */
	public String getAuditSourceId() {
		return auditSourceId;
	}

	/**
	 * Method to get
	 *
	 * @return the domainToReturnNamespace
	 */
	public String getDomainToReturnNamespace() {
		return domainToReturnNamespace;
	}

	/**
	 * Method to get
	 *
	 * @return the domainToReturnOid
	 */
	public String getDomainToReturnOid() {
		return domainToReturnOid;
	}

	/**
	 * Method to get
	 *
	 * @return the homeCommunityNamespace
	 */
	public String getHomeCommunityNamespace() {
		return homeCommunityNamespace;
	}

	/**
	 * Method to get
	 *
	 * @return the homeCommunityOid
	 */
	public String getHomeCommunityOid() {
		return homeCommunityOid;
	}

	/**
	 * Method to get
	 *
	 * @return the otherOidIds
	 */
	public String[] getOtherOidIds() {
		return otherOidIds;
	}

	/**
	 * Method to get
	 *
	 * @return the pdqConsumerUri
	 */
	public URI getPdqConsumerUri() {
		return pdqConsumerUri;
	}

	/**
	 * Method to get
	 *
	 * @return the pixQueryUri
	 */
	public URI getPixQueryUri() {
		return pixQueryUri;
	}

	/**
	 * Method to get
	 *
	 * @return the pixSourceUri
	 */
	public URI getPixSourceUri() {
		return pixSourceUri;
	}

	/**
	 * Method to get
	 *
	 * @return the receiverApplicationOid
	 */
	public String getReceiverApplicationOid() {
		return receiverApplicationOid;
	}

	/**
	 * Method to get
	 *
	 * @return the receiverFacilityOid
	 */
	public String getReceiverFacilityOid() {
		return receiverFacilityOid;
	}

	/**
	 * Method to get
	 *
	 * @return the senderApplicationOid
	 */
	public String getSenderApplicationOid() {
		return senderApplicationOid;
	}

	/**
	 * Method to get
	 *
	 * @return the senderFacilityOid
	 */
	public String getSenderFacilityOid() {
		return senderFacilityOid;
	}

}
