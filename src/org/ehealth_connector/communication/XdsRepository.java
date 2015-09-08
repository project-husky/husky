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
	 * @param id repository ID
	 * @param uri repository URI
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
	 * @param id repository ID
	 * @param uri repository URI
	 */
	public void setRepository(String id, URI uri) {
		this.id = id;
		this.uri = uri;
	}
}