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
package org.ehealth_connector.communication;

import java.net.URI;

/**
 * Represents the connection details for an IHE XDS Repository
 */
public class XdsRepository {
	private String id;
	private URI uri;

	/**
	 * Standard constructor.
	 */
	public XdsRepository() {
	}

	/**
	 * Constructor.
	 *
	 * @param id
	 *            repository ID
	 * @param uri
	 *            repository URI
	 */
	public XdsRepository(String id, URI uri) {
		this.setRepository(id, uri);
	}

	/**
	 * Gets the repository ID
	 *
	 * @return the ID
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Gets the repository URI
	 *
	 * @return the URI
	 */
	public URI getUri() {
		return this.uri;
	}

	/**
	 * Set the necessary connection details for a repository.
	 *
	 * @param id
	 *            repository ID
	 * @param uri
	 *            repository URI
	 */
	public void setRepository(String id, URI uri) {
		this.id = id;
		this.uri = uri;
	}
}
