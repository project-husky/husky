package org.ehealth_connector.communication;

import java.net.URI;

public class XdsRepository {
	private String id;
	private URI uri;
	
	public XdsRepository() {
	}
	
	public XdsRepository(String id, URI uri) {
		this.setRepository(id, uri);
	}
	
	public void setRepository(String id, URI uri) {
		this.id = id;
		this.uri = uri;
	}
	
	public String getId() {
		return this.id;
	}
	
	public URI getUri() {
		return this.uri;
	}
}