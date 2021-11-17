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
package org.husky.valueset.enums;

/**
 *
 * <div class="en">This enum allows a ValueSet to be configured according to its
 * format. Based on this case distinction, the de-serialization corresponding to
 * the data format is applied.</div>
 *
 * <div class="de">Dieses Enum dient dazu, dass ein ValueSet gemäss seinem
 * Format konfiguriert werden kann. Anhand dieser Fallunterscheidung wird die,
 * dem Datenformat entsprechende De-/Serialisierung angewendet.</div>
 */
public enum SourceFormatType {

	/**
	 * <div class="en">The ValueSet is available in IHE SVS XML format.</div>
	 *
	 * <div class="de">Das ValueSet ist im IHE SVS Format verfügbar.</div>
	 *
	 * Mime type: application/xml
	 */
	IHESVS,

	/**
	 * <div class="en">The ValueSet is available in JSON format.</div>
	 *
	 * <div class="de">Das ValueSet ist im JSON Format verfügbar.</div>
	 *
	 * Mime type: application/fhir+json
	 */
	JSON,

	/**
	 * <div class="en">The ValueSet is available in XML format.</div>
	 *
	 * <div class="de">Das ValueSet ist im XML Format verfügbar.</div>
	 *
	 * Mime type: application/fhir+xml
	 */
	XML;
}
