/*******************************************************************************
 * 
 * The authorship of this code and the accompanying materials is held by ahdis gmbh, Switzerland.
 * All rights reserved. http://ahdis.ch
 * 
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * 
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 * 
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 3.0 Switzerland License.
 * 
 * Year of publication: 2015
 *******************************************************************************/
package org.ehealth_connector.communication;

/**
 * The Class AtnaConfig.
 * 
 * @author oliveregger
 */
public class AtnaConfig {

	/** The audit repository uri. */
	private String auditRepositoryUri;

	/** The audit source id. */
	private String auditSourceId;

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
	 * Sets the audit repository uri.
	 *
	 * @param auditRepositoryUri the new audit repository uri
	 */
	public void setAuditRepositoryUri(String auditRepositoryUri) {
		this.auditRepositoryUri = auditRepositoryUri;
	}

	/**
	 * Sets the audit source id.
	 *
	 * @param auditSourceId the new audit source id
	 */
	public void setAuditSourceId(String auditSourceId) {
		this.auditSourceId = auditSourceId;
	}

}
