/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.ps;

import java.util.List;

import javax.annotation.processing.Generated;

import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Supply;

/**
 * MedikationAbgabeEntryemed
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.8.2.3.1<br>
 * Effective date: 2014-09-10 00:00:00<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-03-01")
public class MedikationAbgabeEntryemed extends POCDMT000040Supply {

    public MedikationAbgabeEntryemed() {
        super.setClassCode(org.projecthusky.common.hl7cdar2.ActClassSupply.SPLY);
        super.setMoodCode(org.projecthusky.common.hl7cdar2.XDocumentSubstanceMood.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.8.2.3.1"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("2.16.840.1.113883.10.20.1.34"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.5.3.1.4.7.3"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.3.6.1.4.1.19376.1.9.1.3.4"));
    }

    /**
     * Creates fixed contents for CDA Element hl7Author
     *
     * @param typeCode the desired fixed value for this argument.
     * @param contextControlCode the desired fixed value for this argument.
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040Author createHl7AuthorFixedValue(String typeCode, String contextControlCode, String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040Author retVal = factory.createPOCDMT000040Author();
        retVal.getTypeCode().add(typeCode);
        retVal.setContextControlCode(contextControlCode);

		if (nullFlavor != null) {
			retVal.getNullFlavor().add(nullFlavor);
		}

        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7CodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7EntryRelationship
     *
     * @param typeCode the desired fixed value for this argument.
     * @param inversionInd the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship createHl7EntryRelationshipFixedValue(String typeCode, String inversionInd) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship retVal = factory.createPOCDMT000040EntryRelationship();
        retVal.setTypeCode(org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship.fromValue(typeCode));
        if (inversionInd != null) {
            retVal.setInversionInd(Boolean.parseBoolean(inversionInd));
        }
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
     * Creates fixed contents for CDA Element hl7Performer
     *
     * @param typeCode the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.POCDMT000040Performer2 createHl7PerformerFixedValue(String typeCode) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040Performer2 retVal = factory.createPOCDMT000040Performer2();
        retVal.setTypeCode(org.projecthusky.common.hl7cdar2.ParticipationPhysicalPerformer.fromValue(typeCode));
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
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Author> getHl7Author() {
        return author;
    }

    /**
     * Gets the hl7Code
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7Code() {
        return (org.projecthusky.common.hl7cdar2.CE) code;
    }

    /**
     * Gets the hl7EntryRelationship
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship> getHl7EntryRelationship() {
        return entryRelationship;
    }

    /**
     * Gets the hl7Id
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7Id() {
        return id;
    }

    /**
     * Gets the hl7Performer
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Performer2> getHl7Performer() {
        return performer;
    }

    /**
     * Gets the hl7Product
     */
    public org.projecthusky.common.hl7cdar2.POCDMT000040Product getHl7Product() {
        return product;
    }

    /**
     * Gets the hl7Quantity
     */
    public org.projecthusky.common.hl7cdar2.PQ getHl7Quantity() {
        return quantity;
    }

    /**
     * Gets the hl7Reference
     */
    public List<org.projecthusky.common.hl7cdar2.POCDMT000040Reference> getHl7Reference() {
        return reference;
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
        return text;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040Author, filled by: "AUT", "OP"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040Author getPredefinedAuthorAutOp() {
        return createHl7AuthorFixedValue("AUT",
				"OP", null);
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040Author, filled by: "NA", null, null
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040Author getPredefinedAuthorNaNullNull() {
		return createHl7AuthorFixedValue(null, null, "NA");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.CE getPredefinedCode() {
        return createHl7CodeFixedValue();
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship, filled by: "COMP", null
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipCompNull() {
        return createHl7EntryRelationshipFixedValue("COMP",
                                                    null);
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship, filled by: "REFR", null
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipRefrNull() {
        return createHl7EntryRelationshipFixedValue("REFR",
                                                    null);
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship, filled by: "SUBJ", "true"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship getPredefinedEntryRelationshipSubjTrue() {
        return createHl7EntryRelationshipFixedValue("SUBJ",
                                                    "true");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.II, filled by: "1.2.40.0.10.1.4.3.4.2.3"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.II getPredefinedId1240010143423() {
        return createHl7IdFixedValue("1.2.40.0.10.1.4.3.4.2.3");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.POCDMT000040Performer2, filled by: "PRF"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.POCDMT000040Performer2 getPredefinedPerformerPrf() {
        return createHl7PerformerFixedValue("PRF");
    }

    /**
     * Sets the hl7Author
     */
    public void setHl7Author(org.projecthusky.common.hl7cdar2.POCDMT000040Author value) {
        getAuthor().clear();
        getAuthor().add(value);
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.projecthusky.common.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7EntryRelationship
     */
    public void setHl7EntryRelationship(org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship value) {
        getEntryRelationship().clear();
        getEntryRelationship().add(value);
    }

    /**
     * Sets the hl7Id
     */
    public void setHl7Id(org.projecthusky.common.hl7cdar2.II value) {
        getId().clear();
        getId().add(value);
    }

    /**
     * Sets the hl7Performer
     */
    public void setHl7Performer(org.projecthusky.common.hl7cdar2.POCDMT000040Performer2 value) {
        getPerformer().clear();
        getPerformer().add(value);
    }

    /**
     * Sets the hl7Product
     */
    public void setHl7Product(org.projecthusky.common.hl7cdar2.POCDMT000040Product value) {
        this.product = value;
    }

    /**
     * Sets the hl7Quantity
     */
    public void setHl7Quantity(org.projecthusky.common.hl7cdar2.PQ value) {
        this.quantity = value;
    }

    /**
     * Sets the hl7Reference
     */
    public void setHl7Reference(org.projecthusky.common.hl7cdar2.POCDMT000040Reference value) {
        getReference().clear();
        getReference().add(value);
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
