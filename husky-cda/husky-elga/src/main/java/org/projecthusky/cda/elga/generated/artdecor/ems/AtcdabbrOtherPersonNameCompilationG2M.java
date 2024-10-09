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
import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.common.hl7cdar2.EnFamily;
import org.projecthusky.common.hl7cdar2.EnGiven;
import org.projecthusky.common.hl7cdar2.EnPrefix;
import org.projecthusky.common.hl7cdar2.EnSuffix;
import org.projecthusky.common.hl7cdar2.PN;

/**
 * atcdabbr_other_PersonNameCompilationG2M
 * <p>
 * Template description: <br/><br>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.11<br>
 * Effective date: 2021-02-19 13:36:55<br>
 * Version: 1.0.0+20210219<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class AtcdabbrOtherPersonNameCompilationG2M extends PN {

    public AtcdabbrOtherPersonNameCompilationG2M() {
		addHl7Family(createHl7FamilyFixedValue());
		addHl7Given(createHl7GivenFixedValue());
    }

    /**
     * Adds a hl7Family
     */
    public void addHl7Family(org.projecthusky.common.hl7cdar2.ENXP value) {
        EnFamily obj = new EnFamily();
		obj.setXmlMixed(value.getXmlMixed());
		getContent().add(new JAXBElement<EnFamily>(new QName("family"),
                                                   EnFamily.class,
                                                   obj));
    }

    /**
     * Adds a hl7Given
     */
    public void addHl7Given(org.projecthusky.common.hl7cdar2.ENXP value) {
        EnGiven obj = new EnGiven();
		obj.setXmlMixed(value.getXmlMixed());
		getContent().add(new JAXBElement<EnGiven>(new QName("given"),
                                                  EnGiven.class,
                                                  obj));
    }

    /**
     * Adds a hl7Prefix
     */
    public void addHl7Prefix(org.projecthusky.common.hl7cdar2.ENXP value) {
        EnPrefix obj = new EnPrefix();
		obj.setXmlMixed(value.getXmlMixed());
		getContent().add(new JAXBElement<EnPrefix>(new QName("prefix"),
                                                   EnPrefix.class,
                                                   obj));
    }

    /**
     * Adds a hl7Suffix
     */
    public void addHl7Suffix(org.projecthusky.common.hl7cdar2.ENXP value) {
        EnSuffix obj = new EnSuffix();
		obj.setXmlMixed(value.getXmlMixed());
		getContent().add(new JAXBElement<EnSuffix>(new QName("suffix"),
                                                   EnSuffix.class,
                                                   obj));
    }

    /**
     * Creates fixed contents for CDA Element hl7Family
     */
    private static org.projecthusky.common.hl7cdar2.ENXP createHl7FamilyFixedValue() {
        EnFamily retVal = new EnFamily();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Given
     */
    private static org.projecthusky.common.hl7cdar2.ENXP createHl7GivenFixedValue() {
        EnGiven retVal = new EnGiven();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Prefix
     */
    private static org.projecthusky.common.hl7cdar2.ENXP createHl7PrefixFixedValue() {
        EnPrefix retVal = new EnPrefix();
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Suffix
     */
    private static org.projecthusky.common.hl7cdar2.ENXP createHl7SuffixFixedValue() {
        EnSuffix retVal = new EnSuffix();
        return retVal;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.ENXP, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.ENXP getPredefinedPrefix() {
        return createHl7PrefixFixedValue();
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.ENXP, filled by:
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.ENXP getPredefinedSuffix() {
        return createHl7SuffixFixedValue();
    }
}
