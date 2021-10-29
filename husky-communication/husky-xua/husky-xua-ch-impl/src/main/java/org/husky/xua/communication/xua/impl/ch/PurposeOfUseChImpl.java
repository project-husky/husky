/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
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
package org.husky.xua.communication.xua.impl.ch;

import org.husky.xua.hl7v3.PurposeOfUse;
import org.husky.xua.hl7v3.impl.PurposeOfUseBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class providing method to generate the CH:EPD PurposeOfUse instances NORM and EMER</div>
 * <div class="de">Klasse die die methoden für die Generierung von CH:EPD PurposeOfUse Instanzen NORM und EMER</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public abstract class PurposeOfUseChImpl {

	/**
	 * Normal access.
	 *
	 * @return the purpose of use
	 */
	public static PurposeOfUse AUTO() {
		return createPurposeOfUse(
				org.husky.xua.communication.xua.impl.ch.PurposeOfUse.AUTOMATIC_UPLOAD);
	}

	private static PurposeOfUse createPurposeOfUse(
			org.husky.xua.communication.xua.impl.ch.PurposeOfUse code) {
		return new PurposeOfUseBuilder().code(code.getCodeValue())
				.codeSystem(code.getCodeSystemId()).codeSystemName(code.getValueSetName())
				.displayName(code.getDisplayName()).buildObject();
	}

	/**
	 * Emergency access.
	 *
	 * @return the purpose of use
	 */
	public static PurposeOfUse EMER() {
		return createPurposeOfUse(
				org.husky.xua.communication.xua.impl.ch.PurposeOfUse.EMERGENCY_ACCESS);
	}

	/**
	 * Normal access.
	 *
	 * @return the purpose of use
	 */
	public static PurposeOfUse NORM() {
		return createPurposeOfUse(
				org.husky.xua.communication.xua.impl.ch.PurposeOfUse.NORMAL_ACCESS);
	}

}
