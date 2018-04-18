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
package org.ehealth_connector.security.hl7v3.impl;

import org.ehealth_connector.security.hl7v3.PurposeOfUse;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class providing method to generate the CH:EPD PurposeOfUse instances NORM and EMER</div>
 * <div class="de">Klasse die die methoden für die Generierung von CH:EPD PurposeOfUse Instanzen NORM und EMER</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public abstract class PurposeOfUseChImpl {

	/**
	 * <pre>
	 * <PurposeOfUse xs:type="CE" code="NORM" codeSystem="2.16.756.5.30.1.127.3.10.5" codeSystemName="eHealth Suisse Verwendungszweck" displayName="Normalzugriff" xmlns="urn:hl7-org:v3"/>
	 * </pre>
	 */
	public static PurposeOfUse NORM() {
		return new PurposeOfUseBuilder().code("NORM").codeSystem("2.16.756.5.30.1.127.3.10.5")
				.codeSystemName("eHealth Suisse Verwendungszweck").displayName("Normalzugriff").buildObject();
	}

	/**
	 * <pre>
	 * <PurposeOfUse xs:type="CE" code="EMER" codeSystem="2.16.756.5.30.1.127.3.10.5" codeSystemName="eHealth Suisse Verwendungszweck" displayName="Notfallzugriff" xmlns="urn:hl7-org:v3"/>
	 * </pre>
	 */
	public static PurposeOfUse EMER() {
		return new PurposeOfUseBuilder().code("EMER").codeSystem("2.16.756.5.30.1.127.3.10.5")
				.codeSystemName("eHealth Suisse Verwendungszweck").displayName("Notfallzugriff").buildObject();
	}

}
