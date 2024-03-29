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
package org.projecthusky.communication;

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
