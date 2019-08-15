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
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */
package org.ehealth_connector.cda.ch.lrep.v133;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlTransient;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;

/**
 * Original ART-DECOR template id: 2.16.756.5.30.1.1.10.9.34
 * Template description: Person name information (with required family and given name) according to the eCH-0011 V8.1 nameData data type. CDA-CH V2 derivatives, i.e. Swiss exchange formats MAY use this template by either reference or specialisation.See https://www.ech.ch/vechweb/page?p=dossier&amp;documentNumber=eCH-0011&amp;documentVersion=8.1, section 3.3.2 nameData – Namensangaben for more information.
 *
 * Element description: Other person's name.
 */
public class CdachOtherPersonNameInformationCompilationECh0011 {

	public CdachOtherPersonNameInformationCompilationECh0011() {
	// cdach_other_PersonNameInformationCompilation-eCH-0011/hl7:name:set_cs use = "L";
	// cdach_other_PersonNameInformationCompilation-eCH-0011/hl7:name:set_cs use = "P";
	// cdach_other_PersonNameInformationCompilation-eCH-0011/hl7:name:set_cs use = "ASGN";
	}

	/**
	 * The person's legal name (with required family and given name).
	 */
	@XmlTransient()
	private ArrayList<org.ehealth_connector.common.hl7cdar2.PN> name = new ArrayList<org.ehealth_connector.common.hl7cdar2.PN>();

	/**
	 * Creates fixed contents for hl7Name
	 *
	 * @param use the desired fixed value for this argument.
	 */
	public org.ehealth_connector.common.hl7cdar2.PN createHl7NameFixedValue(String use) {
		ObjectFactory factory = new ObjectFactory();
		org.ehealth_connector.common.hl7cdar2.PN retVal = factory.createPN();
		retVal.getUse().add(use);
		return retVal;
	}

	/**
	 * Gets the hl7Name
	 * The person's legal name (with required family and given name).
	 */
	public org.ehealth_connector.common.hl7cdar2.PN getHl7Name() {
		org.ehealth_connector.common.hl7cdar2.PN retVal = null;
		if (name != null)
			if (name.size() > 0)
				retVal = name.get(0);
		return retVal;
	}

	/**
	 * Sets the hl7Name
	 * The person's legal name (with required family and given name).
	 */
	public void setHl7Name(org.ehealth_connector.common.hl7cdar2.PN value) {
		name.clear();
		name.add(value);
	}
}
