/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.generated.artdecor;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.husky.common.hl7cdar2.SXCMTS;

/**
 * DosageInstructionsStartStopFrequency
 * <p>
 * Template description: Dosage Instructions are a set of data elements which together represent the dosage instructions to a medication such as duration of treatment, medication frequency, dose quantity, route of administration, etc. Dosage Instructions may be provided structured and/or narrative. This entry describes structured dosage instructions.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.4.35<br>
 * Effective date: 2019-08-27 16:30:05<br>
 * Version: 2021<br>
 * Status: draft
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-04-19")
public class DosageInstructionsStartStopFrequency extends POCDMT000040SubstanceAdministration {

    public DosageInstructionsStartStopFrequency() {
    }

    /**
     * Adds a hl7ApproachSiteCode
     */
    public void addHl7ApproachSiteCode(org.husky.common.hl7cdar2.CD value) {
        getApproachSiteCode().add(value);
    }

    /**
     * Adds a hl7ApproachSiteCode
     */
    public void clearHl7ApproachSiteCode() {
        getApproachSiteCode().clear();
    }

    /**
     * Creates fixed contents for CDA Element hl7DoseQuantity
     */
    private static org.husky.common.hl7cdar2.IVLPQ createHl7DoseQuantityFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.IVLPQ retVal = factory.createIVLPQ();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7EffectiveTime
     *
     * @param operator the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.EIVLTS createHl7EffectiveTimeFixedValue(String operator) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.EIVLTS retVal = factory.createEIVLTS();
        retVal.setOperator(org.husky.common.hl7cdar2.SetOperator.fromValue(operator));
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7RepeatNumber
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.IVLINT createHl7RepeatNumberFixedValue(String nullFlavor) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.IVLINT retVal = factory.createIVLINT();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7RouteCode
     */
    private static org.husky.common.hl7cdar2.CE createHl7RouteCodeFixedValue() {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.CE retVal = factory.createCE();
        return retVal;
    }

    /**
     * Gets the hl7DoseQuantity
     */
    public org.husky.common.hl7cdar2.IVLPQ getHl7DoseQuantity() {
        return doseQuantity;
    }

    /**
     * Gets the hl7EffectiveTime<br/>
     * Dosage Instructions PCC 6.3.4.16.12 - Frequency: Multiple events within a day with the same dosage
     */
    public List<SXCMTS> getHl7EffectiveTime() {
        return effectiveTime;
    }

    /**
     * Gets the hl7EffectiveTime<br/>
     * <div>In case the (structured) dosage instructions include a dose regime this element SHALL be</div><div>present and specify the entire duration of the medication treatment. In case the Duration of Treatment is unknown the &lt;low&gt; and &lt;high&gt; sub-elements of this element SHALL be set to null flavor “UNK”.</div>
     */
    public List<SXCMTS> getHl7EffectiveTimeListSxcmts() {
        return effectiveTime;
    }

    /**
     * Gets the hl7RateQuantity
     */
    public org.husky.common.hl7cdar2.IVLPQ getHl7RateQuantity() {
        return rateQuantity;
    }

    /**
     * Gets the hl7RepeatNumber<br/>
     * Number of repeats/refills. Either the {@literal @}value or {@literal @}nullFlavor attribute shall be set. It's required in MTP, PRE and PADV items ; forbidden in DIS items.
     */
    public org.husky.common.hl7cdar2.IVLINT getHl7RepeatNumber() {
        return repeatNumber;
    }

    /**
     * Gets the hl7RouteCode
     */
    public org.husky.common.hl7cdar2.CE getHl7RouteCode() {
        return routeCode;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.IVLPQ, filled by:
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.IVLPQ getPredefinedDoseQuantity() {
        return createHl7DoseQuantityFixedValue();
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.EIVLTS, filled by: "A"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.EIVLTS getPredefinedEffectiveTimeA() {
        return createHl7EffectiveTimeFixedValue("A");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.IVLINT, filled by: "NI"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.IVLINT getPredefinedRepeatNumberNi() {
        return createHl7RepeatNumberFixedValue("NI");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.CE, filled by:
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.CE getPredefinedRouteCode() {
        return createHl7RouteCodeFixedValue();
    }

    /**
     * Sets the hl7DoseQuantity
     */
    public void setHl7DoseQuantity(org.husky.common.hl7cdar2.IVLPQ value) {
        this.doseQuantity = value;
    }

    /**
     * Sets the hl7EffectiveTime<br/>
     * <div>In case the (structured) dosage instructions include a dose regime this element SHALL be</div><div>present and specify the entire duration of the medication treatment. In case the Duration of Treatment is unknown the &lt;low&gt; and &lt;high&gt; sub-elements of this element SHALL be set to null flavor “UNK”.</div>
     */
    public void setHl7EffectiveTime(org.husky.common.hl7cdar2.IVLTS value) {
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
    }

    /**
     * Sets the hl7EffectiveTime<br/>
     * Dosage Instructions PCC 6.3.4.16.12 - Frequency: Event based time interval, where the event is not a precise time, but is used for timing purposes (e.g., with meals, between meals, before breakfast, before sleep).
     */
    public void setHl7EffectiveTime(org.husky.common.hl7cdar2.EIVLTS value) {
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
    }

    /**
     * Sets the hl7EffectiveTime<br/>
     * Dosage Instructions PCC 6.3.4.16.12 - Frequency: Multiple events within a day with the same dosage
     */
    public void setHl7EffectiveTime(org.husky.common.hl7cdar2.SXPRTS value) {
        getEffectiveTime().clear();
        getEffectiveTime().add(value);
    }

    /**
     * Sets the hl7RateQuantity
     */
    public void setHl7RateQuantity(org.husky.common.hl7cdar2.IVLPQ value) {
        this.rateQuantity = value;
    }

    /**
     * Sets the hl7RepeatNumber<br/>
     * Number of repeats/refills. Either the {@literal @}value or {@literal @}nullFlavor attribute shall be set. It's required in MTP, PRE and PADV items ; forbidden in DIS items.
     */
    public void setHl7RepeatNumber(org.husky.common.hl7cdar2.IVLINT value) {
        this.repeatNumber = value;
    }

    /**
     * Sets the hl7RouteCode
     */
    public void setHl7RouteCode(org.husky.common.hl7cdar2.CE value) {
        this.routeCode = value;
    }
}
