/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.emed.ch.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;
import org.projecthusky.common.hl7cdar2.ObjectFactory;
import org.projecthusky.common.hl7cdar2.POCDMT000040Patient;

/**
 * cdach_other_PersonNameInformationCompilation-eCH-0011
 * <p>
 * Template description: Person name information (with required family and given name) according to the eCH-0011 V8.1 nameData data type. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.See https://www.ech.ch/vechweb/page?p=dossier&amp;documentNumber=eCH-0011&amp;documentVersion=8.1, section 3.3.2 nameData – Namensangaben for more information.<br>
 * Element description: Other person's name.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.34<br>
 * Effective date: 2022-06-21 14:05:06<br>
 * Version: 2022<br>
 * Status: draft
 */
@Generated(value = "org.projecthusky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2022-07-11")
public class CdachOtherPersonNameInformationCompilationECh0011 extends POCDMT000040Patient {

    public CdachOtherPersonNameInformationCompilationECh0011() {
        super.getName().add(createHl7NameFixedValue("L"));
    }

    /**
     * Creates fixed contents for CDA Element hl7Name
     *
     * @param use the desired fixed value for this argument.
     */
    private static org.projecthusky.common.hl7cdar2.PN createHl7NameFixedValue(String use) {
        ObjectFactory factory = new ObjectFactory();
        org.projecthusky.common.hl7cdar2.PN retVal = factory.createPN();
        retVal.getUse().add(use);
        return retVal;
    }

    /**
     * Gets the hl7Name<br/>
     * The person's legal name (with required family and given name).
     */
    public List<org.projecthusky.common.hl7cdar2.PN> getHl7Name() {
        return name;
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.PN, filled by: "ASGN"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.PN getPredefinedNameAsgn() {
        return createHl7NameFixedValue("ASGN");
    }

    /**
     * Adds a predefined org.projecthusky.common.hl7cdar2.PN, filled by: "P"
     * @return the predefined element.
     */
    public static org.projecthusky.common.hl7cdar2.PN getPredefinedNameP() {
        return createHl7NameFixedValue("P");
    }

    /**
     * Sets the hl7Name<br/>
     * The person's legal name (with required family and given name).
     */
    public void setHl7Name(org.projecthusky.common.hl7cdar2.PN value) {
        getName().clear();
        getName().add(value);
    }
}
