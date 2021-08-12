/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.common.communication;

/**
 * The Class AtnaConfig.
 */
public class AtnaConfig {

	/**
	 * <div class="en">ATNA configuration mode (secure or unsecure)</div>
	 */
	public enum AtnaConfigMode {

		/**
		 * <div class="en">ATNA is enabled for secure applications</div>
		 */
		SECURE,

		/**
		 * <div class="en">ATNA is disabled (no audit trail)</div>
		 */
		UNSECURE
	}

	/** The audit enterprise site id. */
	private String auditEnterpriseSiteID;

	/** The audit repository uri. */
	private String auditRepositoryUri;

	/** The audit source id. */
	private String auditSourceId;

	/**
	 * Gets the audit repository uri.
	 *
	 * @return the audit enterprise site id
	 */
	public String getAuditEnterpriseSiteID() {
		return auditEnterpriseSiteID;
	}

	/**
	 * Gets the audit repository uri.
	 *
	 * @return the audit repository uri
	 */
	public String getAuditRepositoryUri() {
		return auditRepositoryUri;
	}

	/**
	 * Gets the audit source id.
	 *
	 * @return the audit source id
	 */
	public String getAuditSourceId() {
		return auditSourceId;
	}

	/**
	 * Sets the audit audit enterprise site id.
	 *
	 * @param auditEnterpriseSiteID
	 */
	public void setAuditEnterpriseSiteID(String auditEnterpriseSiteID) {
		this.auditEnterpriseSiteID = auditEnterpriseSiteID;
	}

	/**
	 * Sets the audit repository uri.
	 *
	 * @param auditRepositoryUri
	 *            the new audit repository uri
	 */
	public void setAuditRepositoryUri(String auditRepositoryUri) {
		this.auditRepositoryUri = auditRepositoryUri;
	}

	/**
	 * Sets the audit source id.
	 *
	 * @param auditSourceId
	 *            the new audit source id
	 */
	public void setAuditSourceId(String auditSourceId) {
		this.auditSourceId = auditSourceId;
	}

}
