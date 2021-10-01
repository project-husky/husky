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
package org.ehealth_connector.common.utils;

import java.math.BigInteger;

import org.ehealth_connector.common.hl7cdar2.INT;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.ehealth_connector.common.hl7cdar2.ST;

/**
 * <div class="en">Toolbox for HL7 CDA R2 handling.</div>
 *
 * <div class="de">Toolbox für das HL7 CDA R2 Handling.</div>
 *
 */
public class Hl7CdaR2Util {

	private Hl7CdaR2Util() {
		throw new IllegalStateException("This is a utility class!");
	}

	/**
	 * <div class="en">Converts the given value to a HL7 CDA R2 INT.</div>
	 *
	 * <div class="de">Konvertiert den angegebenen Wert in einen HL7 CDA R2
	 * INT.</div>
	 *
	 * @param value
	 *            the value
	 * @return the int
	 */
	public static INT createHl7CdaR2Int(BigInteger value) {
		INT retVal = null;
		if (value != null) {
			var factory = new ObjectFactory();
			retVal = factory.createINT();
			retVal.setValue(value);
		}
		return retVal;
	}

	/**
	 * <div class="en">Converts the given value to a HL7 CDA R2 INT.</div>
	 *
	 * <div class="de">Konvertiert den angegebenen Wert in einen HL7 CDA R2
	 * INT.</div>
	 *
	 * @param value
	 *            the value
	 * @return the int
	 */
	public static INT createHl7CdaR2Int(Integer value) {
		return createHl7CdaR2Int(BigInteger.valueOf(value));
	}

	/**
	 * <div class="en">Converts the given value to a HL7 CDA R2 ST.</div>
	 *
	 * <div class="de">Konvertiert den angegebenen Wert in einen HL7 CDA R2
	 * ST.</div>
	 *
	 * @param value
	 *            the value
	 * @return the st
	 */
	public static ST createHl7CdaR2St(String value) {
		var factory = new ObjectFactory();
		var retVal = factory.createST();
		retVal.xmlContent = value;
		return retVal;
	}

}
