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
package org.husky.xua.serialization.impl;

import org.husky.xua.serialization.OpenSaml2Serializer;

/**
 * <!-- @formatter:off -->
 * <div class="en">Abstract implementation class with the common methods and fields.</div>
 * <div class="de">Abstrakte implementations Klasse mit den gemeinsamen Methoden und Feldern.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public abstract class AbstractSerializerImpl {

	private OpenSaml2Serializer openSamlSerializer;

	protected AbstractSerializerImpl() {
		openSamlSerializer = new OpenSaml2SerializerImpl();
	}

	public OpenSaml2Serializer getOpenSamlSerializer() {
		return openSamlSerializer;
	}

	public void setOpenSamlSerializer(OpenSaml2Serializer openSamlSerializer) {
		this.openSamlSerializer = openSamlSerializer;
	}

}
