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

	private static PurposeOfUse createPurposeOfUse(org.husky.communication.ch.enums.PurposeOfUse code) {
		return new PurposeOfUseBuilder().code(code.getCodeValue())
				.codeSystem(code.getCodeSystemId()).codeSystemName(code.getValueSetName())
				.displayName(code.getDisplayName()).buildObject();
	}

	/**
	 * Normal access.
	 *
	 * @return the purpose of use
	 */
	public static PurposeOfUse AUTO() {
		return createPurposeOfUse(org.husky.communication.ch.enums.PurposeOfUse.AUTOMATIC_UPLOAD);
	}

	/**
	 * Emergency access.
	 *
	 * @return the purpose of use
	 */
	public static PurposeOfUse EMER() {
		return createPurposeOfUse(org.husky.communication.ch.enums.PurposeOfUse.EMERGENCY_ACCESS);
	}

	/**
	 * Normal access.
	 *
	 * @return the purpose of use
	 */
	public static PurposeOfUse NORM() {
		return createPurposeOfUse(org.husky.communication.ch.enums.PurposeOfUse.NORMAL_ACCESS);
	}

}
