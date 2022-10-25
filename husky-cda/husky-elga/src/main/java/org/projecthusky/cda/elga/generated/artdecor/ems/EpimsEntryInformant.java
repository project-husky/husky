/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ems;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.POCDMT000040Informant12;

/**
 * epims_entry_informant
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.3.58<br>
 * Effective date: 2020-02-20 15:33:20<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class EpimsEntryInformant extends POCDMT000040Informant12 {

    public EpimsEntryInformant() {
		super.getTypeCode().add("INF");
        super.setRelatedEntity(createHl7RelatedEntityFixedValue("PAT"));
    }

    /**
     * Creates fixed contents for CDA Element hl7RelatedEntity
     *
     * @param classCode the desired fixed value for this argument.
     */
	private static org.projecthusky.common.hl7cdar2.POCDMT000040RelatedEntity createHl7RelatedEntityFixedValue(
			String classCode) {
		org.projecthusky.common.hl7cdar2.POCDMT000040RelatedEntity retVal = new org.projecthusky.common.hl7cdar2.POCDMT000040RelatedEntity();
		retVal.getClassCode().add(classCode);
        return retVal;
    }

    /**
     * Gets the hl7RelatedEntity
     */
	public org.projecthusky.common.hl7cdar2.POCDMT000040RelatedEntity getHl7RelatedEntity() {
		return this.relatedEntity;
    }

    /**
     * Sets the hl7RelatedEntity
     */
	public void setHl7RelatedEntity(org.projecthusky.common.hl7cdar2.POCDMT000040RelatedEntity value) {
		this.relatedEntity = value;
    }
}
