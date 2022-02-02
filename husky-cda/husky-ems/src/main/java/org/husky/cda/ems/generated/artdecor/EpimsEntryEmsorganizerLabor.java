/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.cda.ems.generated.artdecor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.basetypes.CodeBaseType;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Organizer;
import org.husky.common.model.Code;

/**
 * epims_entry_EMSOrganizerLabor
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.3.61<br>
 * Effective date: 2020-02-20 16:12:29<br>
 * Version: 2020<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class EpimsEntryEmsorganizerLabor extends POCDMT000040Organizer {

    public EpimsEntryEmsorganizerLabor() {
        super.setClassCode(org.husky.common.hl7cdar2.XActClassDocumentEntryOrganizer.BATTERY);
        super.getMoodCode().add("EVN");
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.6.0.11.3.61"));
        super.getTemplateId().add(createHl7TemplateIdFixedValue("1.2.40.0.34.11.6.2.1"));
        super.setCode(createHl7CodeFixedValue("30",
                                              "1.2.40.0.34.5.189",
                                              "EMS_struktur_elemente",
                                              "EMS_Organizer"));
        vocabStatusCodeCode.add(new Code(CodeBaseType.builder().withCode("completed").build()));
        statusCode = (new Code(CodeBaseType.builder().withCode("completed").build())).getHl7CdaR2Cs();
    }

    private final List<Code> vocabStatusCodeCode = new ArrayList<>();

    /**
     * Adds a hl7Component
     */
    public void addHl7Component(org.husky.common.hl7cdar2.POCDMT000040Component4 value) {
        getComponent().add(value);
    }

    /**
     * Adds a hl7Component
     */
    public void clearHl7Component() {
        getComponent().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7Code
     *
     * @param code the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.CE createHl7CodeFixedValue(String code, String codeSystem, String codeSystemName, String displayName) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CE retVal = factory.createCE();
        retVal.setCode(code);
        retVal.setCodeSystem(codeSystem);
        retVal.setCodeSystemName(codeSystemName);
        retVal.setDisplayName(displayName);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Component
     *
     * @param typeCode the desired fixed value for this argument.
     * @param contextConductionInd the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.POCDMT000040Component4 createHl7ComponentFixedValue(String typeCode, String contextConductionInd) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.POCDMT000040Component4 retVal = factory.createPOCDMT000040Component4();
        retVal.setTypeCode(org.husky.common.hl7cdar2.ActRelationshipHasComponent.fromValue(typeCode));
        if (contextConductionInd != null) {
            retVal.setContextConductionInd(Boolean.parseBoolean(contextConductionInd));
        }
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7TemplateId
     *
     * @param root the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.II createHl7TemplateIdFixedValue(String root) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.II retVal = factory.createII();
        retVal.setRoot(root);
        return retVal;
    }

    /**
     * Gets the hl7Code
     */
    public org.husky.common.hl7cdar2.CE getHl7Code() {
        return (org.husky.common.hl7cdar2.CE) code;
    }

    /**
     * Gets the hl7EffectiveTime
     */
    public org.husky.common.hl7cdar2.IVLTS getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7StatusCode
     */
    public org.husky.common.hl7cdar2.CS getHl7StatusCode() {
        return statusCode;
    }

    /**
     * Gets the hl7TemplateId
     */
    public List<org.husky.common.hl7cdar2.II> getHl7TemplateId() {
        return templateId;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.POCDMT000040Component4, filled by: "COMP", "true"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.POCDMT000040Component4 getPredefinedComponentCompTrue() {
        return createHl7ComponentFixedValue("COMP",
                                            "true");
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
    public void setHl7Code(org.husky.common.hl7cdar2.CE value) {
        this.code = value;
    }

    /**
     * Sets the hl7EffectiveTime
     */
    public void setHl7EffectiveTime(org.husky.common.hl7cdar2.IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Sets the hl7StatusCode
     */
    public void setHl7StatusCode(org.husky.common.hl7cdar2.CS value) {
        this.statusCode = value;
    }

    /**
     * Sets the hl7TemplateId
     */
    public void setHl7TemplateId(org.husky.common.hl7cdar2.II value) {
        getTemplateId().clear();
        getTemplateId().add(value);
    }
}
