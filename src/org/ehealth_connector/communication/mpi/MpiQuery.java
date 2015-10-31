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

import java.util.Date;

import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.valueset.AdministrativeGenderEnum;

/**
 * The interface MpiQuery defines a query object which allows to add the query
 * parameters for the patient demographics query and control the subsequent
 * query steps (continue, cancel) when the query is batched.
 */
public interface MpiQuery {

	/**
	 * Returned patient identifiers will include the added domain if available
	 * 
	 * @param organizationOID
	 *            the organization oid
	 * @return the query object
	 */
	public abstract MpiQuery addDomainToReturn(String organizationOID);

	/**
	 * Adds the mothers maiden name to the query
	 * 
	 * @param useFuzzySearch
	 *            if true does not require an exact match, see Table
	 *            3.47.4.1.2-1: Model Attributes (ITI TF-2b)
	 * @param humanDt
	 *            name
	 * @return the query object
	 */
	public abstract MpiQuery addMothersMaidenName(boolean useFuzzySearch, HumanNameDt humanDt);

	/**
	 * Adds a patient address to the query.
	 * 
	 * @param addressDt
	 *            the address to be queried for
	 * @return the query object
	 */
	public abstract MpiQuery addPatientAddress(AddressDt addressDt);

	/**
	 * Adds a patient identifier to be queried for.
	 * 
	 * @param identifierDt
	 *            patient identifier
	 * @return the query object
	 */
	public abstract MpiQuery addPatientIdentifier(IdentifierDt identifierDt);

	/**
	 * Adds a patient name to the query.
	 * 
	 * @param useFuzzySearch
	 *            if true does not require an exact match, see Table
	 *            3.47.4.1.2-1: Model Attributes (ITI TF-2b)
	 * @param humanDt
	 *            name
	 * @return the query object
	 */
	public abstract MpiQuery addPatientName(boolean useFuzzySearch, HumanNameDt humanDt);

	/**
	 * Adds a patient telecom to be queried for.
	 * 
	 * @param contactPointDt
	 *            telecom
	 * @return the query object
	 */
	public abstract MpiQuery addPatientTelecom(ContactPointDt contactPointDt);

	/**
	 * Cancels the next query.
	 * 
	 * @return the query object
	 */
	public abstract MpiQuery cancelQuery();

	/**
	 * Continues query for the next pageCount results.
	 * 
	 * @return the query object
	 */
	public abstract MpiQuery continueQuery();

	/**
	 * Sets the page count for partial lists of search results
	 * (QueryByParameter.initialQuantity).
	 * 
	 * @param pageCount
	 *            the page count
	 * @return the query object
	 */
	public abstract MpiQuery setPageCount(int pageCount);

	/**
	 * Sets the patient birth date for the query.
	 * 
	 * @param date
	 *            the date
	 * @return the query object
	 */
	public abstract MpiQuery setPatientBirthDate(Date date);

	/**
	 * Sets the patient sex for the query.
	 * 
	 * @param adminstrativeGenderEnum
	 *            gender
	 * @return the query object
	 */
	public abstract MpiQuery setPatientSex(AdministrativeGenderEnum adminstrativeGenderEnum);

}
