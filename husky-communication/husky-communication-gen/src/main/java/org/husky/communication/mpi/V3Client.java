/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */

package org.husky.communication.mpi;

import java.net.URI;

import org.husky.communication.CamelService;


public abstract class V3Client extends CamelService {

	/**
	 * The URI of the server to issue a query against.
	 */
	private URI serverURI;

	/**
	 * Constructor
	 * 
	 * @param serverURI:
	 *            the URI for the server to use for query requests
	 */
	protected V3Client(URI serverURI) {
		this.serverURI = serverURI;
	}

	/**
	 * Gets the actor name for each actor implementation.
	 *
	 * @return The implementation's actor name
	 */
	public abstract String getActorName();

	/**
	 * @return Returns the server URI
	 */
	public URI getServerURI() {
		return serverURI;
	}

}
