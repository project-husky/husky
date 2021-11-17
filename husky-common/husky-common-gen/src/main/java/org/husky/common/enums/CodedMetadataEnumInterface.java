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
package org.husky.common.enums;

import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;

import java.util.Collection;

/**
 * @since Sep 22, 2015 10:00:45 AM
 */
public interface CodedMetadataEnumInterface {
	/**
	 * <div class="en">Gets the CodeMetadataType</div> <div class="de">Liefert
	 * das OHT CodedMetadataType Objekt</div>
	 *
	 * @return the enum as codedMetadataType
	 */
	Code getIpfCode();

	/**
	 * Verifies if the current instance and a {@link Code} are coding the same value in the same system.
	 *
	 * @param code The code to compare.
	 * @return {@code true} if they are equal, {@code false} otherwise.
	 */
	boolean isEqualTo(final Code code);

	/**
	 * Checks whether a collection of codes contains a particular value set code.
	 *
	 * @param codes The collection of codes.
	 * @return {@code true} if the collection contains the value set code, {@code false} otherwise.
	 */
	boolean isContainedIn(final Collection<Code> codes);

	/**
	 * Encodes an eHC value set code to an IHE Coded String, as defined in ITI TF-3 Table 4.2.3.1.7-2. It is mostly
	 * an HL7 V2.5 CX field. The code is escaped, the code system ID shall be an OID so escaping it shouldn't be needed.
	 *
	 * @return the encoded IHE Coded String.
	 */
	String getCodedString();
}
