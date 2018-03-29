/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.security.deserialization.impl;

import org.ehealth_connector.security.deserialization.OpenSaml2Deserializer;

/**
 * <!-- @formatter:off -->
 * <div class="en">Abstract implementation class with the common methods and fields.</div>
 * <div class="de">Abstrakte implementations Klasse mit den gemeinsamen Methoden und Feldern.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public abstract class AbstractDeserializerImpl<T> {
	private OpenSaml2Deserializer<T> openSamlDeserializer;

	public AbstractDeserializerImpl() {
		openSamlDeserializer = new OpenSaml2DeserializerImpl<>();
	}

	protected OpenSaml2Deserializer<T> getOpenSamlDeserializer() {
		return openSamlDeserializer;
	}
}
