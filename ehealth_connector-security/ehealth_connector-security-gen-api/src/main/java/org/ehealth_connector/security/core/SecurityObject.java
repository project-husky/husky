/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.core;

/**
 * @since Feb 21, 2018 1:06:07 PM
 *
 */
public interface SecurityObject<T> {

	/**
	 * 
	 * @formatter:off
	 * <div class="en">Method to get the wrapped inner object.</div>
	 * <div class="de">Method um das gewrappte innere object zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return returns the wrapped inner object (depends on implementation)
	 */
	T getWrappedObject();

}
