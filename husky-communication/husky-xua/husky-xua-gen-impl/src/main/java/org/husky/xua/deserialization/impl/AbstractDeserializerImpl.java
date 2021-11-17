/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.xua.deserialization.impl;

import org.husky.xua.deserialization.Deserializer;
import org.husky.xua.deserialization.OpenSaml2Deserializer;

/**
 * <!-- @formatter:off -->
 * <div class="en">Abstract implementation class with the common methods and fields.</div>
 * <div class="de">Abstrakte implementations Klasse mit den gemeinsamen Methoden und Feldern.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public abstract class AbstractDeserializerImpl<T, U> implements Deserializer<U> {
	private OpenSaml2Deserializer<T> openSamlDeserializer;

	protected AbstractDeserializerImpl() {
		openSamlDeserializer = new OpenSaml2DeserializerImpl<>();
	}

	protected OpenSaml2Deserializer<T> getOpenSamlDeserializer() {
		return openSamlDeserializer;
	}
}
