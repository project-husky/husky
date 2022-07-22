/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.elga.generated.artdecor;

import javax.annotation.processing.Generated;

import org.husky.common.hl7cdar2.POCDMT000040AssignedEntity;
import org.husky.common.hl7cdar2.POCDMT000040Informant12;
import org.husky.common.hl7cdar2.POCDMT000040RelatedEntity;

/**
 * atcdabbr_other_InformantBody
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.3<br>
 * Effective date: 2021-10-04 08:03:25<br>
 * Version: 1.0.1+20211213<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-18")
public class AtcdabbrOtherInformantBody extends POCDMT000040Informant12 {

    public AtcdabbrOtherInformantBody() {
		getTypeCode().add("INF");
		setContextControlCode("OP");
    }

    /**
	 * Creates fixed contents for CDA Element hl7AssignedEntity
	 *
	 * @param classCode the desired fixed value for this argument.
	 */
	private static POCDMT000040AssignedEntity createHl7AssignedEntityFixedValue(String classCode) {
		POCDMT000040AssignedEntity retVal = new POCDMT000040AssignedEntity();
		retVal.setClassCode(classCode);
		return retVal;
	}

	/**
	 * Creates fixed contents for CDA Element hl7RelatedEntity
	 *
	 * @param classCode the desired fixed value for this argument.
	 */
	private static POCDMT000040RelatedEntity createHl7RelatedEntityFixedValue(
			String classCode) {
		POCDMT000040RelatedEntity retVal = new POCDMT000040RelatedEntity();
		retVal.getClassCode().add(classCode);
		return retVal;
	}

	/**
	 * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040AssignedEntity,
	 * filled by: "ASSIGNED"
	 * 
	 * @return the predefined element.
	 */
	public static POCDMT000040AssignedEntity getPredefinedAssignedEntityAssigned() {
		return createHl7AssignedEntityFixedValue("ASSIGNED");
	}

	/**
	 * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040RelatedEntity, filled
	 * by: "PRS"
	 * 
	 * @return the predefined element.
	 */
	public static POCDMT000040RelatedEntity getPredefinedRelatedEntityPrs() {
		return createHl7RelatedEntityFixedValue("PRS");
	}

    /**
     * Gets the hl7AssignedEntity
     */
	public org.husky.common.hl7cdar2.POCDMT000040AssignedEntity getHl7AssignedEntity() {
		return this.assignedEntity;
    }

    /**
     * Gets the hl7RelatedEntity
     */
	public org.husky.common.hl7cdar2.POCDMT000040RelatedEntity getHl7RelatedEntity() {
		return this.relatedEntity;
    }

    /**
     * Sets the hl7AssignedEntity
     */
	public void setHl7AssignedEntity(org.husky.common.hl7cdar2.POCDMT000040AssignedEntity value) {
		this.assignedEntity = value;
    }

    /**
     * Sets the hl7RelatedEntity
     */
	public void setHl7RelatedEntity(org.husky.common.hl7cdar2.POCDMT000040RelatedEntity value) {
		this.relatedEntity = value;
    }
}
