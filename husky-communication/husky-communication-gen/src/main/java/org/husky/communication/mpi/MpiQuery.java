/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.communication.mpi;

import java.util.Date;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;

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
	public abstract MpiQuery addMothersMaidenName(boolean useFuzzySearch, HumanName humanDt);

	/**
	 * Adds a patient address to the query.
	 *
	 * @param Address
	 *            the address to be queried for
	 * @return the query object
	 */
	public abstract MpiQuery addPatientAddress(Address address);

	/**
	 * Adds a patient identifier to be queried for.
	 *
	 * @param Identifier
	 *            patient identifier
	 * @return the query object
	 */
	public abstract MpiQuery addPatientIdentifier(Identifier identifier);

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
	public abstract MpiQuery addPatientName(boolean useFuzzySearch, HumanName humanDt);

	/**
	 * Adds a patient telecom to be queried for.
	 *
	 * @param ContactPoint
	 *            telecom
	 * @return the query object
	 */
	public abstract MpiQuery addPatientTelecom(ContactPoint contactPoint);

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
	public abstract MpiQuery setPatientSex(
			Enumerations.AdministrativeGender adminstrativeGenderEnum);

}
