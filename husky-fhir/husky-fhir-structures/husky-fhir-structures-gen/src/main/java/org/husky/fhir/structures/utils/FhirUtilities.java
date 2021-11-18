/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.fhir.structures.utils;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Identifier;
import org.husky.common.hl7cdar2.II;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;

/**
 *
 * @author roeland
 * @version 1.0
 * @since Sep 18, 2017 8:31:23 AM
 *
 */
public class FhirUtilities {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instantiates a new code from FHIR CodeableConcept.</div>
	 * <div class="de">Instantiiert ein neues Code Objekt von FHIR7 CodeableConcept</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aCodeableConcept <br>
	 * <div class="en">the CodeableConcept to be converted</div>
	 * <div class="de">Das CodeableConcept zum konvertieren</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return <br>
	 * <div class="en">new instance of type Code</div>
	 * <div class="de">Neue Instanz vom Typ Code</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public static Code toCode(CodeableConcept aCodeableConcept) {
		return new Code(aCodeableConcept.getCodingFirstRep().getSystem().replace("urn:oid:", ""),
				aCodeableConcept.getCodingFirstRep().getCode(), aCodeableConcept.getText());
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instantiates a new code from FHIR Coding.</div>
	 * <div class="de">Instantiiert ein neues Code Objekt von FHIR Coding</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aCoding <br>
	 * <div class="en">the Coding to be converted to Code</div>
	 * <div class="de">Die Coding Instanz die in eine Code Instanz konvertiert werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return <br>
	 * <div class="en">new instance of type Code</div>
	 * <div class="de">Neue Instanz vom Typ Code</div>
	 * <div class="it"></div>
	 *<!-- @formatter:off -->
	 */
	public static Code toCode(Coding aCoding) {
		return new Code(aCoding.getSystem().replace("urn:oid:", ""), aCoding.getCode(), aCoding.getDisplay());
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a new Identificator</div>
	 * <div class="de">Erstellt einen neuen Identifikator.</div>
	 *
	 * @param identifier <br>
	 * <div class="en">the identifier to be used</div>
	 * <div class="de">der identifier der zum convertieren ist.</div>
	 *
	 * @return <br>
	 * <div class="en">the Identificator initialized</div>
	 * <div class="de">der initialisierte Identificator</div>
	 * <!-- @formatter:on -->
	 */
	public static Identificator toIdentificator(Identifier identifier) {
		final var retVal = new Identificator(new II());
		retVal.setRoot(identifier.getSystem());
		retVal.setExtension(identifier.getValue());
		return retVal;
	}

}
