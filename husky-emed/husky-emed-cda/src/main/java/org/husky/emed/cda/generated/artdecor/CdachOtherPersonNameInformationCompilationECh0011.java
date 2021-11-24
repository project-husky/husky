/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.husky.emed.cda.generated.artdecor;

import java.util.List;
import javax.annotation.processing.Generated;
import org.husky.common.hl7cdar2.ObjectFactory;
import org.husky.common.hl7cdar2.POCDMT000040Patient;

/**
 * cdach_other_PersonNameInformationCompilation-eCH-0011
 * <p>
 * Template description: Person name information (with required family and given name) according to the eCH-0011 V8.1 nameData data type. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.See https://www.ech.ch/vechweb/page?p=dossier&amp;documentNumber=eCH-0011&amp;documentVersion=8.1, section 3.3.2 nameData – Namensangaben for more information.<br>
 * Element description: Other person's name.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.10.9.34<br>
 * Effective date: 2018-04-18 00:00:00<br>
 * Version: 2017<br>
 * Status: active
 */
@Generated(value = "org.husky.codegenerator.cda.ArtDecor2JavaGenerator", date = "2021-11-24")
public class CdachOtherPersonNameInformationCompilationECh0011 extends POCDMT000040Patient {

    public CdachOtherPersonNameInformationCompilationECh0011() {
        super.getName().add(createHl7NameFixedValue("L"));
    }

    /**
     * Creates fixed contents for CDA Element hl7Name
     *
     * @param use the desired fixed value for this argument.
     */
    private static org.husky.common.hl7cdar2.PN createHl7NameFixedValue(String use) {
        ObjectFactory factory = new ObjectFactory();
        org.husky.common.hl7cdar2.PN retVal = factory.createPN();
        retVal.getUse().add(use);
        return retVal;
    }

    /**
     * Gets the hl7Name/The person's legal name (with required family and given name).
     */
    public List<org.husky.common.hl7cdar2.PN> getHl7Name() {
        return name;
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.PN, filled by: "ASGN"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.PN getPredefinedNameAsgn() {
        return createHl7NameFixedValue("ASGN");
    }

    /**
     * Adds a predefined org.husky.common.hl7cdar2.PN, filled by: "P"
     * @return the predefined element.
     */
    public static org.husky.common.hl7cdar2.PN getPredefinedNameP() {
        return createHl7NameFixedValue("P");
    }

    /**
     * Sets the hl7Name/The person's legal name (with required family and given name).
     */
    public void setHl7Name(org.husky.common.hl7cdar2.PN value) {
        getName().clear();
        getName().add(value);
    }
}
