/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor.base;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.POCDMT000040Author;

/**
 * AuthorElements
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.90004<br>
 * Effective date: 2015-02-17 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-21")
public class AuthorElements extends POCDMT000040Author {

	public AuthorElements() {

    }

    /**
     * Creates fixed contents for CDA Element hl7Author
     *
     * @param typeCode the desired fixed value for this argument.
     * @param contextControlCode the desired fixed value for this argument.
     * @param nullFlavor the desired fixed value for this argument.
     */
	private static POCDMT000040Author createHl7AuthorFixedValue(String typeCode,
			String contextControlCode, String nullFlavor) {
		POCDMT000040Author retVal = new POCDMT000040Author();
		retVal.getTypeCode().add(typeCode);
		retVal.setContextControlCode(contextControlCode);

		if (nullFlavor != null) {
			retVal.getNullFlavor().add(nullFlavor);
		}

		return retVal;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Component3, filled by: "AUT", "OP"
     * @return the predefined element.
     */
	public static org.husky.common.hl7cdar2.POCDMT000040Author getPredefinedAuthorAutOp() {
        return createHl7AuthorFixedValue("AUT",
				"OP", null);
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Component3, filled by: "NA", null, null
     * @return the predefined element.
     */
	public static org.husky.common.hl7cdar2.POCDMT000040Author getPredefinedAuthorNaNullNull() {
		return createHl7AuthorFixedValue(null, null, "NA");
    }

}
