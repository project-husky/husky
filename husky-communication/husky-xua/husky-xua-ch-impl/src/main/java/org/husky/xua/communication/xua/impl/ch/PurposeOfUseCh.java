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

import org.husky.xua.hl7v3.CE;
import org.husky.xua.hl7v3.PurposeOfUse;
import org.husky.xua.hl7v3.impl.CodedWithEquivalentsBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class providing method to generate the CH:EPD PurposeOfUse instances NORM and EMER</div>
 * <div class="de">Klasse die die methoden für die Generierung von CH:EPD PurposeOfUse Instanzen NORM und EMER</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface PurposeOfUseCh {

	private static CE createPurposeOfUse(org.husky.communication.ch.enums.PurposeOfUse code) {
		return new CodedWithEquivalentsBuilder().code(code.getCodeValue())
				.codeSystem(code.getCodeSystemId()).codeSystemName(code.getValueSetName())
				.displayName(code.getDisplayName()).buildObject(PurposeOfUse.DEFAULT_NS_URI,
						PurposeOfUse.DEFAULT_ELEMENT_LOCAL_NAME, PurposeOfUse.DEFAULT_PREFIX);
	}

	/**
	 * Normal access.
	 *
	 * @return the purpose of use
	 */
	public static CE auto() {
		return createPurposeOfUse(org.husky.communication.ch.enums.PurposeOfUse.AUTOMATIC_UPLOAD);
	}

	/**
	 * Emergency access.
	 *
	 * @return the purpose of use
	 */
	public static CE emer() {
		return createPurposeOfUse(org.husky.communication.ch.enums.PurposeOfUse.EMERGENCY_ACCESS);
	}

	/**
	 * Normal access.
	 *
	 * @return the purpose of use
	 */
	public static CE norm() {
		return createPurposeOfUse(org.husky.communication.ch.enums.PurposeOfUse.NORMAL_ACCESS);
	}

}
