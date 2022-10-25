/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.cda.elga.generated.artdecor.base;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Generated;

import org.projecthusky.common.basetypes.CodeBaseType;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Act;
import org.projecthusky.common.model.Code;

/**
 * LaboratorySpecimenEntry
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.11.4.3.1<br>
 * Effective date: 2013-02-10 00:00:00<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-21")
public class LaboratorySpecimenEntry extends POCDMT000040Act {

    public LaboratorySpecimenEntry() {
        super.setClassCode(org.projecthusky.common.hl7cdar2.XActClassDocumentEntryAct.ACT);
        super.setMoodCode(org.projecthusky.common.hl7cdar2.XDocumentActMood.EVN);
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.4.3.1"));
        super.setCode(createHl7CodeFixedValue("10",
                                              "1.2.40.0.34.5.11",
                                              null,
                                              null));
        vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("completed").build()));
        statusCode = (new Code(CodeBaseType.builder().withCode("completed").build())).getHl7CdaR2Cs();
        super.getEntryRelationship().add(createHl7EntryRelationshipFixedValue("COMP",
                                                                              null));
    }

    private final List<Code> vocabStatusCodeCode = new ArrayList<>();

    /**
     * Adds a hl7EntryRelationship
     */
    public void addHl7EntryRelationship(org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship value) {
        getEntryRelationship().add(value);
    }

    /**
     * Adds a hl7EntryRelationship
     */
    public void clearHl7EntryRelationship() {
        getEntryRelationship().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.CE createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.CE retVal = factory.createCE();
        retVal.setCode(code);
        retVal.setCodeSystem(codeSystem);
        retVal.setCodeSystemName(codeSystemName);
        retVal.setDisplayName(displayName);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7EntryRelationship
     *
     * @param typeCode the desired fixed value for this argument.
     * @param inversionInd the desired fixed value for this argument.
     */
	public static org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship createHl7EntryRelationshipFixedValue(
			String typeCode, String inversionInd) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship retVal = factory.createPOCDMT000040EntryRelationship();
        retVal.setTypeCode(org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship.fromValue(typeCode));
        if (inversionInd != null) {
            retVal.setInversionInd(Boolean.parseBoolean(inversionInd));
        }
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
     * Gets the hl7Code
     */
    public org.projecthusky.common.hl7cdar2.CE getHl7Code() {
        return (org.projecthusky.common.hl7cdar2.CE) code;
    }

    /**
     * Gets the hl7StatusCode
     */
    public org.projecthusky.common.hl7cdar2.CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.projecthusky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Returns a list of vocab codes as defined in the ART-DECOR model
     */
    public List<Code> getVocabStatusCodeCode() {
        return vocabStatusCodeCode;
    }

    /**
     * Sets the hl7Code
     */
    public void setHl7Code(org.projecthusky.common.hl7cdar2.CE value) {
        this.code = value;
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
}
