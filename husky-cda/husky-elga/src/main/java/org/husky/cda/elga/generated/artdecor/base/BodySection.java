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

import org.husky.common.hl7cdar2.POCDMT000040Section;

/**
 * BodySection
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.30001<br>
 * Effective date: 2011-12-19 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-21")
public class BodySection extends POCDMT000040Section {

    public BodySection() {
    }

    /**
     * Adds a hl7Entry
     */
	public void addHl7Entry(org.husky.common.hl7cdar2.POCDMT000040Entry value) {
		entry.add(value);
    }

    /**
     * Adds a hl7TemplateId
     */
    public void addHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().add(value);
    }

    /**
     * Adds a hl7TemplateId
     */
    public void clearHl7TemplateId() {
        getTemplateId().clear();
    }

    /**
     * Gets the hl7Code
     */
    public org.husky.common.hl7cdar2.CE getHl7Code() {
		return this.code;
    }

    /**
     * Gets the hl7Id
     */
    public org.husky.common.hl7cdar2.II getHl7Id() {
		return this.id;
    }

    /**
     * Gets the hl7Text
     */
	public org.husky.common.hl7cdar2.StrucDocText getHl7Text() {
		return this.text;
    }

    /**
     * Gets the hl7Title
     */
    public org.husky.common.hl7cdar2.ST getHl7Title() {
		return this.title;
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.husky.common.hl7cdar2.CE value) {
		this.code = value;
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.husky.common.hl7cdar2.II value) {
		this.id = value;
    }

    /**
     * Sets the hl7Text
     */
	public void setHl7Text(org.husky.common.hl7cdar2.StrucDocText value) {
		this.text = value;
    }

    /**
     * Sets the hl7Title
     */
    public void setHl7Title(org.husky.common.hl7cdar2.ST value) {
		this.title = value;
    }
}
