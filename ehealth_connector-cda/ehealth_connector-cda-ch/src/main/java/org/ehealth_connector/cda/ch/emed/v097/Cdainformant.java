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
package org.ehealth_connector.cda.ch.emed.v097;

import javax.annotation.processing.Generated;

/**
 * CDAinformant
 *
 * Template description: Template CDA Informant (prototype, directly derived from POCD_RM000040 MIF)
 *
 * <!-- @formatter:off -->
 * Identifier: 2.16.840.1.113883.10.12.154
 * Effective date: 2005-09-07 00:00:00
 * Status: active
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-03-05")
public class Cdainformant extends org.ehealth_connector.common.hl7cdar2.POCDMT000040Informant12 {

	public Cdainformant() {
		super.getTypeCode().add("INF");
		super.setContextControlCode("OP");
	}

	/**
	 * Gets the hl7AssignedEntity
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedEntity getHl7AssignedEntity() {
		return assignedEntity;
	}

	/**
	 * Gets the hl7RelatedEntity
	 */
	public org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedEntity getHl7RelatedEntity() {
		return relatedEntity;
	}

	/**
	 * Sets the hl7AssignedEntity
	 */
	public void setHl7AssignedEntity(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedEntity value) {
		this.assignedEntity = value;
	}

	/**
	 * Sets the hl7RelatedEntity
	 */
	public void setHl7RelatedEntity(
			org.ehealth_connector.common.hl7cdar2.POCDMT000040RelatedEntity value) {
		this.relatedEntity = value;
	}
}
