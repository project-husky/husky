/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.fhir.structures.utils;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Identifier;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * 
 * @author roeland
 * @version 1.0
 * @since Sep 18, 2017 8:31:23 AM
 *
 */
public class FhirUtilities {

	/**
	 * <div class="en">Instantiates a new code from FHIR Coding.</div>
	 * <div class="de">Instantiiert ein neues Code Objekt von FHIR Coding</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param aCoding
	 *            <br>
	 *            <div class="de">Coding</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @return <br>
	 *         <div class="de">Instanz von Code</div> <div class="fr"></div>
	 *         <div class="it"></div>
	 */
	public static Code toCode(Coding aCoding) {
		return new Code(aCoding.getSystem().replace("urn:oid:", ""), aCoding.getCode(),
				aCoding.getDisplay());
	}

	/**
	 * <div class="en">Instantiates a new code from FHIR CodeableConcept.</div>
	 * <div class="de">Instantiiert ein neues Code Objekt von FHIR
	 * CodeableConcept</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param aCoding
	 *            <br>
	 *            <div class="de">CodeableConcept</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @return <br>
	 *         <div class="de">Instanz von Code</div> <div class="fr"></div>
	 *         <div class="it"></div>
	 */
	public static Code toCode(CodeableConcept aCodeableConcept) {
		return new Code(aCodeableConcept.getCodingFirstRep().getSystem().replace("urn:oid:", ""),
				aCodeableConcept.getCodingFirstRep().getCode(), aCodeableConcept.getText());
	}

	/**
	 * <div class="en">Creates a new Identificator</div>
	 * <div class="de">Erstellt einen neuen Identifikator.</div>
	 *
	 * @param identifier
	 *            <br>
	 *            <div class="en">the identifier to be used</div>
	 *            <div class="de">der identifier der zum convertieren ist.</div>
	 * @return <br>
	 *         <div class="en">the Identificator initialized</div>
	 *         <div class="de">der initialisierte Identificator</div>
	 */
	public static Identificator toIdentificator(Identifier identifier) {
		final Identificator retVal = new Identificator(DatatypesFactory.eINSTANCE.createII());
		retVal.setRoot(identifier.getSystem());
		retVal.setExtension(identifier.getValue());
		return retVal;
	}

}
