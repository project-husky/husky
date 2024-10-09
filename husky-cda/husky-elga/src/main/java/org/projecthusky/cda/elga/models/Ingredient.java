/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models;

import java.util.ArrayList;

import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.hl7cdar2.COCTMT230100UVIngredient;
import org.projecthusky.common.hl7cdar2.COCTMT230100UVSubstance;
import org.projecthusky.common.hl7cdar2.TN;
import org.projecthusky.common.model.Code;

public class Ingredient {

	private Code code;
	private String name;

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public COCTMT230100UVIngredient getCOCTMT230100UVIngredient() {
		COCTMT230100UVIngredient ingredientField = new COCTMT230100UVIngredient();
		ingredientField.setClassCode("ACTI");

		COCTMT230100UVSubstance substance = new COCTMT230100UVSubstance();
		substance.setClassCode("MMAT");
		substance.setDeterminerCode("KIND");

		if (code != null) {
			substance.setCode(code.getHl7CdaR2Ce());
		} else {
			CE substanceCode = new CE();
			substanceCode.nullFlavor = new ArrayList<>();
			substanceCode.nullFlavor.add("UNK");
			substance.setCode(substanceCode);
		}

		if (name != null) {
			TN pharmName = new TN();
			pharmName.setXmlMixed(name);
			substance.getName().add(pharmName);
		}

		ingredientField.setIngredient(new JAXBElement<>(
				new QName("urn:ihe:pharm", "ingredient", "pharm"), COCTMT230100UVSubstance.class, substance));
		return ingredientField;
	}



}
