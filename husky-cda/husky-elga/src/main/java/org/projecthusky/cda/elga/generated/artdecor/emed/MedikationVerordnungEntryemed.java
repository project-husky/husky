/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.emed;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.projecthusky.common.basetypes.CodeBaseType;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.PIVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.projecthusky.common.hl7cdar2.SXCMTS;
import org.projecthusky.common.hl7cdar2.XDocumentSubstanceMood;
import org.projecthusky.common.model.Code;

/**
 * MedikationVerordnungEntryemed
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.8.1.3.1<br>
 * Effective date: 2014-09-01 00:00:00<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-22")
public class MedikationVerordnungEntryemed extends POCDMT000040SubstanceAdministration {

    public MedikationVerordnungEntryemed() {
        super.getClassCode().add("SBADM");
		super.setMoodCode(XDocumentSubstanceMood.INT);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.8.1.3.1"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.24"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.2"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.6"));
        super.setStatusCode(createHl7StatusCodeFixedValue("completed",
                                                          null,
                                                          null,
                                                          null));
        vocabRouteCodeCode.add(new Code(CodeBaseType.builder().withCodeSystem("1.2.40.0.10.1.4.3.4.3.4").build()));
    }

    private final List<Code> vocabRouteCodeCode = new ArrayList<>();

    /**
     * Creates fixed contents for CDA Element hl7Author
     *
     * @param typeCode the desired fixed value for this argument.
     * @param contextControlCode the desired fixed value for this argument.
     * @param nullFlavor the desired fixed value for this argument.
     */
	private static org.projecthusky.common.hl7cdar2.POCDMT000040Author createHl7AuthorFixedValue(String typeCode,
                                                                                                 String contextControlCode, String nullFlavor) {
		org.projecthusky.common.hl7cdar2.POCDMT000040Author retVal = new org.projecthusky.common.hl7cdar2.POCDMT000040Author();
		retVal.getTypeCode().add(typeCode);
		retVal.setContextControlCode(contextControlCode);

		if (nullFlavor != null) {
			retVal.getNullFlavor().add(nullFlavor);
		}

        return retVal;
    }

	/**
	 * Creates fixed contents for CDA Element hl7EffectiveTime
	 *
	 * @param nullFlavor the desired fixed value for this argument.
	 */
	private static org.projecthusky.common.hl7cdar2.PIVLTS createHl7EffectiveTimeFixedValue(String nullFlavor) {
		org.projecthusky.common.hl7cdar2.PIVLTS retVal = new PIVLTS();

		if (nullFlavor != null) {
			retVal.getNullFlavor().add(nullFlavor);
		}

		return retVal;
	}

    /**
     * Creates fixed contents for CDA Element hl7DoseQuantity
     */
    private static org.projecthusky.common.hl7cdar2.IVLPQ createHl7DoseQuantityFixedValue() {
        org.projecthusky.common.hl7cdar2.IVLPQ retVal = new org.projecthusky.common.hl7cdar2.IVLPQ();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7EntryRelationship
     *
     * @param typeCode the desired fixed value for this argument.
     * @param inversionInd the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040ServiceEvent createHl7EntryRelationshipFixedValue(String typeCode, String inversionInd) {
        org.projecthusky.common.hl7cdar2.POCDMT000040ServiceEvent retVal = new org.projecthusky.common.hl7cdar2.POCDMT000040ServiceEvent();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Id
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.II createHl7IdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7StatusCode
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CS createHl7StatusCodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        org.projecthusky.common.hl7cdar2.CS retVal = new org.projecthusky.common.hl7cdar2.CS();
        retVal.setCode(code);
        retVal.setCodeSystem(codeSystem);
        retVal.setCodeSystemName(codeSystemName);
        retVal.setDisplayName(displayName);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Author
     */
	public List<org.projecthusky.common.hl7cdar2.POCDMT000040Author> getHl7AuthorPocdmt000040ServiceEvent() {
		return this.author;
    }

    /**
     * Gets the hl7Consumable
     */
	public org.projecthusky.common.hl7cdar2.POCDMT000040Consumable getHl7Consumable() {
		return this.consumable;
    }

    /**
     * Gets the hl7DoseQuantity
     */
    public org.projecthusky.common.hl7cdar2.IVLPQ getHl7DoseQuantityIvlpq() {
		return this.doseQuantity;
    }

    /**
     * Gets the hl7EffectiveTime
     */
	public List<SXCMTS> getHl7EffectiveTimePivlTs() {
        return effectiveTime;
    }

    /**
     * Gets the hl7EntryRelationship
     */
	public List<org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship> getHl7EntryRelationshipPocdmt000040ServiceEvent() {
		return this.entryRelationship;
    }

    /**
     * Gets the hl7Id
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7Reference
     */
	public List<org.projecthusky.common.hl7cdar2.POCDMT000040Reference> getHl7Reference() {
		return this.reference;
    }

    /**
     * Gets the hl7RepeatNumber
     */
	public org.projecthusky.common.hl7cdar2.IVLINT getHl7RepeatNumber() {
		return this.repeatNumber;
    }

    /**
     * Gets the hl7RouteCode
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7RouteCode() {
		return this.routeCode;
    }

    /**
     * Gets the hl7StatusCode
     */
    public org.projecthusky.common.hl7cdar2.CS getHl7StatusCode() {
		return this.statusCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Gets the hl7Text
     */
    public org.projecthusky.common.hl7cdar2.ED getHl7Text() {
		return this.text;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040ServiceEvent, filled by: "AUT", "OP"
     * @return the predefined element.
     */
	public static org.projecthusky.common.hl7cdar2.POCDMT000040Author getPredefinedAuthorAutOp() {
		return createHl7AuthorFixedValue("AUT", "OP", null);
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040ServiceEvent, filled by: "NA", null, null
     * @return the predefined element.
     */
	public static org.projecthusky.common.hl7cdar2.POCDMT000040Author getPredefinedAuthorNaNullNull() {
		return createHl7AuthorFixedValue(null, null, "NA");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.IVLPQ, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.IVLPQ getPredefinedDoseQuantity() {
        return createHl7DoseQuantityFixedValue();
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.PIVL_TS, filled by: "A"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.PIVLTS getPredefinedEffectiveTimeA() {
		return createHl7EffectiveTimeFixedValue("A");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.PIVL_TS, filled by: "NA", null
     * @return the predefined element.
     */
	public static org.projecthusky.common.hl7cdar2.PIVLTS getPredefinedEffectiveTimeNaNull() {
		return createHl7EffectiveTimeFixedValue("NA");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040ServiceEvent, filled by: "SUBJ", "true"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040ServiceEvent getPredefinedEntryRelationshipSubjTrue() {
        return createHl7EntryRelationshipFixedValue("SUBJ",
                                                    "true");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.II, filled by: "1.2.40.0.10.1.4.3.4.2.2"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.II getPredefinedId1240010143422() {
        return createHl7IdFixedValue("1.2.40.0.10.1.4.3.4.2.2");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.II, filled by: "1.3.6.1.4.1.19376.1.5.3.1.4.21"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.II getPredefinedTemplateId136141193761531421() {
        return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.21");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.II, filled by: "1.3.6.1.4.1.19376.1.5.3.1.4.7.1"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.II getPredefinedTemplateId136141193761531471() {
        return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.1");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.II, filled by: "1.3.6.1.4.1.19376.1.5.3.1.4.9"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.II getPredefinedTemplateId13614119376153149() {
        return createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.9");
    }

    /**
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabRouteCodeCode() {
        return vocabRouteCodeCode;
    }

    /**
     * Sets the hl7Author
     */
	public void setHl7Author(org.projecthusky.common.hl7cdar2.POCDMT000040Author value) {
		this.author.clear();
		this.author.add(value);
    }

    /**
     * Sets the hl7Consumable
     */
	public void setHl7Consumable(org.projecthusky.common.hl7cdar2.POCDMT000040Consumable value) {
		this.consumable = value;
    }

    /**
     * Sets the hl7DoseQuantity
     */
    public void setHl7DoseQuantity(org.projecthusky.common.hl7cdar2.IVLPQ value) {
		this.doseQuantity = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
	public void setHl7EffectiveTime(org.projecthusky.common.hl7cdar2.PIVLTS value) {
		this.effectiveTime.clear();
		this.effectiveTime.add(value);
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.projecthusky.common.hl7cdar2.IVLTS value) {
		this.effectiveTime.clear();
		this.effectiveTime.add(value);
    }

    /**
     * Sets the hl7EntryRelationship
     */
	public void setHl7EntryRelationship(org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship value) {
		this.entryRelationship.clear();
		this.entryRelationship.add(value);
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.projecthusky.common.hl7cdar2.II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7Reference
     */
	public void setHl7Reference(org.projecthusky.common.hl7cdar2.POCDMT000040Reference value) {
		this.reference.clear();
		this.reference.add(value);
    }

    /**
     * Sets the hl7RepeatNumber
     */
	public void setHl7RepeatNumber(org.projecthusky.common.hl7cdar2.IVLINT value) {
		this.repeatNumber = value;
    }

    /**
     * Sets the hl7RouteCode
     */
    public void setHl7RouteCode(org.projecthusky.common.hl7cdar2.CE value) {
		this.routeCode = value;
    }

    /**
     * Sets the hl7StatusCode
     */
    public void setHl7StatusCode(org.projecthusky.common.hl7cdar2.CS value) {
		this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.projecthusky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }

    /**
     * Sets the hl7Text
     */
    public void setHl7Text(org.projecthusky.common.hl7cdar2.ED value) {
		this.text = value;
    }
}
