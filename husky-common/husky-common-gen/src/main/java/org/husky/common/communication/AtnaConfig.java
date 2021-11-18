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
package org.husky.common.communication;

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
