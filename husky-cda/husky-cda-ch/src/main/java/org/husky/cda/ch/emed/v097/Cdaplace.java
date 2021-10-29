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
package org.husky.cda.ch.emed.v097;

import javax.annotation.processing.Generated;

/**
 * CDAPlace
 *
 * Template description: Template CDA Place (prototype, directly derived from POCD_RM000040 MIF)
 *
 * <!-- @formatter:off -->
 * Identifier: 2.16.840.1.113883.10.12.317
 * Effective date: 2005-09-07 00:00:00
 * Status: active
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-03-05")
public class Cdaplace extends org.husky.common.hl7cdar2.POCDMT000040Place {

	public Cdaplace() {
	}

	/**
	 * Gets the hl7Addr
	 */
	public org.husky.common.hl7cdar2.AD getHl7Addr() {
		return addr;
	}

	/**
	 * Gets the hl7Name
	 */
	public org.husky.common.hl7cdar2.EN getHl7Name() {
		return name;
	}

	/**
	 * Sets the hl7Addr
	 */
	public void setHl7Addr(org.husky.common.hl7cdar2.AD value) {
		this.addr = value;
	}

	/**
	 * Sets the hl7Name
	 */
	public void setHl7Name(org.husky.common.hl7cdar2.EN value) {
		this.name = value;
	}
}
