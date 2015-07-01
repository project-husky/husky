/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.communication.mpi;

import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.valueset.AdministrativeGenderEnum;

public interface MpiQuery {

	public abstract MpiQuery addPatientIdentifier(IdentifierDt identifierDt);

	public abstract MpiQuery addPatientName(boolean useFuzzySearch, HumanNameDt humanDt);

	public abstract MpiQuery setPatientSex(AdministrativeGenderEnum adminstrativeGenderEnum);

	public abstract MpiQuery addPatientAddress(AddressDt addressDt);

	public abstract MpiQuery addMothersMaidenName(boolean useFuzzySearch, HumanNameDt humanDt);

	public abstract MpiQuery addPatientTelecom(ContactPointDt contactPointDt);

	abstract MpiQuery cancelQuery();

	abstract MpiQuery setPageCount(int pageCount);

}
