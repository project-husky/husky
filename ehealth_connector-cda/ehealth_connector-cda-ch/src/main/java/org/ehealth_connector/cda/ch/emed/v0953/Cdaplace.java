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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */
package org.ehealth_connector.cda.ch.emed.v0953;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Original ART-DECOR template id: 2.16.840.1.113883.10.12.317
 * Template description: Template CDA Place (prototype, directly derived from POCD_RM000040 MIF)
 */
public class Cdaplace {

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.AD addr;

	/**
	 * No description available in the ART-DECOR model for this field.
	 */
	@XmlTransient()
	private org.ehealth_connector.common.hl7cdar2.EN name;

	/**
	 * Gets the hl7Addr
	 */
	public org.ehealth_connector.common.hl7cdar2.AD getHl7Addr() {
		return addr;
	}

	/**
	 * Gets the hl7Name
	 */
	public org.ehealth_connector.common.hl7cdar2.EN getHl7Name() {
		return name;
	}

	/**
	 * Sets the hl7Addr
	 */
	public void setHl7Addr(org.ehealth_connector.common.hl7cdar2.AD value) {
		this.addr = value;
	}

	/**
	 * Sets the hl7Name
	 */
	public void setHl7Name(org.ehealth_connector.common.hl7cdar2.EN value) {
		this.name = value;
	}
}
