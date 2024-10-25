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

import java.util.ArrayList;

import javax.annotation.processing.Generated;
import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.IVXBTS;
import org.projecthusky.common.hl7cdar2.QTY;
import org.projecthusky.common.hl7cdar2.TS;

/**
 * atcdabbr_other_TimeIntervalInformationMinimal
 * <p>
 * <p>
 * Identifier: 1.2.40.0.34.6.0.11.9.15<br>
 * Effective date: 2021-06-28 14:02:29<br>
 * Version: 1.0.1+20210628<br>
 * Status: active
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-02-01")
public class AtcdabbrOtherTimeIntervalInformationMinimal extends IVLTS {

    public AtcdabbrOtherTimeIntervalInformationMinimal() {
    }

    /**
     * Creates fixed contents for CDA Element hl7High
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.TS createHl7HighFixedValue(String nullFlavor) {
        org.projecthusky.common.hl7cdar2.TS retVal = new org.projecthusky.common.hl7cdar2.TS();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Creates fixed contents for CDA Element hl7Low
     *
     * @param nullFlavor the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.TS createHl7LowFixedValue(String nullFlavor) {
        org.projecthusky.common.hl7cdar2.TS retVal = new org.projecthusky.common.hl7cdar2.TS();
        retVal.nullFlavor = new ArrayList<String>();
        retVal.nullFlavor.add(nullFlavor);
        return retVal;
    }

    /**
     * Gets the hl7High
     */
    public org.projecthusky.common.hl7cdar2.TS getHl7HighTs() {
		for (JAXBElement<? extends QTY> ts : getRest()) {
			if (ts != null && ts.getName() != null && "high".equalsIgnoreCase(ts.getName().getLocalPart())
					&& ts.getValue() != null) {
				if (ts.getValue() instanceof IVXBTS) {
					return (IVXBTS) ts.getValue();
				} else if (ts.getValue() instanceof TS) {
					return (TS) ts.getValue();
				}
			}
		}

		return null;
    }

    /**
     * Gets the hl7Low
     */
    public org.projecthusky.common.hl7cdar2.TS getHl7LowTs() {
		for (JAXBElement<? extends QTY> ts : getRest()) {
			if (ts != null && ts.getName() != null && "low".equalsIgnoreCase(ts.getName().getLocalPart())
					&& ts.getValue() != null) {
				if (ts.getValue() instanceof IVXBTS) {
					return (IVXBTS) ts.getValue();
				} else if (ts.getValue() instanceof TS) {
					return (TS) ts.getValue();
				}
			}
		}

		return null;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.TS, filled by: "UNK"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.TS getPredefinedHighUnk() {
        return createHl7HighFixedValue("UNK");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.TS, filled by: "UNK"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.TS getPredefinedLowUnk() {
        return createHl7LowFixedValue("UNK");
    }

    /**
     * Sets the hl7High
     */
    public void setHl7High(org.projecthusky.common.hl7cdar2.TS value) {
		getRest().add(new JAXBElement<>(new QName("urn:hl7-org:v3", "high", ""), TS.class, value));
    }

    /**
     * Sets the hl7Low
     */
    public void setHl7Low(org.projecthusky.common.hl7cdar2.TS value) {
		getRest().add(new JAXBElement<>(new QName("urn:hl7-org:v3", "low", ""), TS.class, value));
    }
}
