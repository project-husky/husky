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

package org.husky.communication;

import java.util.Date;

import org.hl7.fhir.r4.model.Identifier;
import org.husky.common.communication.Destination;
import org.husky.common.enums.AdministrativeGender;
import org.husky.common.model.Address;
import org.husky.common.model.Identificator;
import org.husky.common.model.Name;
import org.husky.common.model.Telecom;
import org.husky.communication.mpi.impl.pdq.V3PdqQuery;
import org.husky.fhir.structures.gen.FhirPatient;

/**
 * Convenience class MasterPatientIndexQuery adds the MpiQuery functionality for
 * the Patient Demographics Query (PDQ) ITI-47.
 */
public class MasterPatientIndexQuery {

	/**
	 * If not add exception is thrown when deserializing to a cda model
	 * org.eclipse.emf.ecore.resource.Resource$IOWrappedException: Class
	 * 'ClinicalDocument' is not found or is abstract. (http:///resource0.xml,
	 * -1, -1) at
	 * org.openhealthtools.mdht.emf.runtime.resource.impl.FleXMLLoadImpl.handleErrors(FleXMLLoadImpl.java:171)
	 * at org.eclipse.emf.ecore.xmi.impl.XMLLoadImpl.load(XMLLoadImpl.java:418)
	 * at
	 * org.openhealthtools.mdht.emf.runtime.resource.impl.FleXMLLoadImpl.load(FleXMLLoadImpl.java:92)
	 * at
	 * org.openhealthtools.mdht.emf.runtime.resource.impl.FleXMLLoadImpl.load(FleXMLLoadImpl.java:55)
	 * at
	 * org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl.doLoad(XMLResourceImpl.java:261)
	 * at
	 * org.eclipse.emf.ecore.resource.impl.ResourceImpl.load(ResourceImpl.java:1518)
	 */

	/** The v3 pdq query. */
	private final V3PdqQuery v3PdqQuery;

	/**
	 * Instantiates a new master patient index query.
	 *
	 * @param dest
	 *            the dest
	 */
	public MasterPatientIndexQuery(Destination dest) {
		v3PdqQuery = new V3PdqQuery(dest.getSenderApplicationOid(), dest.getSenderFacilityOid(),
				dest.getReceiverApplicationOid(), dest.getReceiverFacilityOid());
	}

	/**
	 * Returned patient identifiers will include the added domain if available
	 *
	 * @param organizationOID
	 *            the organization oid
	 * @return the query object
	 */
	public MasterPatientIndexQuery addDomainToReturn(String organizationOID) {
		v3PdqQuery.addDomainToReturn(organizationOID);
		return this;
	}

	/**
	 * Adds the mothers maiden name to the query
	 *
	 * @param useFuzzySearch
	 *            if true does not require an exact match, see Table
	 *            3.47.4.1.2-1: Model Attributes (ITI TF-2b)
	 * @param name
	 *            the name
	 * @return the query object
	 */
	public MasterPatientIndexQuery addMothersMaidenName(boolean useFuzzySearch, Name name) {
		v3PdqQuery.addMothersMaidenName(useFuzzySearch, FhirPatient.convertName(name));
		return this;
	}

	/**
	 * Adds a patient address to the query.
	 *
	 * @param address
	 *            the address to be queried for
	 * @return the query object
	 */
	public MasterPatientIndexQuery addPatientAddress(Address address) {
		v3PdqQuery.addPatientAddress(FhirPatient.convertAddress(address));
		return this;
	}

	/**
	 * Adds a patient identifier to be queried for.
	 *
	 * @param identificator
	 *            patient identifier
	 * @return the query object
	 */
	public MasterPatientIndexQuery addPatientIdentificator(Identificator identificator) {
		var id = new Identifier();
		id.setSystem(identificator.getRoot());
		id.setValue(identificator.getExtension());
		v3PdqQuery.addPatientIdentifier(id);
		return this;
	}

	/**
	 * Adds a patient name to the query.
	 *
	 * @param useFuzzySearch
	 *            if true does not require an exact match, see Table
	 *            3.47.4.1.2-1: Model Attributes (ITI TF-2b)
	 * @param name
	 *            the name
	 * @return the master patient index query
	 */
	public MasterPatientIndexQuery addPatientName(boolean useFuzzySearch, Name name) {
		v3PdqQuery.addPatientName(useFuzzySearch, FhirPatient.convertName(name));
		return this;
	}

	/**
	 * Adds a patient telecom to be queried for.
	 *
	 * @param tel
	 *            telecom
	 * @return the query object
	 */
	public MasterPatientIndexQuery addPatientTelecom(Telecom tel) {
		v3PdqQuery.addPatientTelecom(FhirPatient.convertTelecom(tel));
		return this;
	}

	/**
	 * Cancels the next query.
	 *
	 * @return the query object
	 */
	public MasterPatientIndexQuery cancelQuery() {
		v3PdqQuery.cancelQuery();
		return this;
	}

	/**
	 * Continues query for the next pageCount results.
	 *
	 * @return the query object
	 */
	public MasterPatientIndexQuery continueQuery() {
		v3PdqQuery.continueQuery();
		return this;
	}

	/**
	 * gets the pdq query object
	 *
	 * @return query object
	 */
	protected V3PdqQuery getV3PdqQuery() {
		return v3PdqQuery;
	}


	/**
	 * Special test preperation IHE PIX and PDQ Pre-Connectathon Test Tool
	 * ITI-47-Consumer Query Continuation Option.
	 *
	 * @return the query object
	 */
	public MasterPatientIndexQuery setNistContinuationQueryId() {
		v3PdqQuery.getV3PdqConsumerQuery().setQueryId("1.2.3.4", "NIST_CONTINUATION", "");
		return this;
	}

	/**
	 * Sets the page count for partial lists of search results
	 * (QueryByParameter.initialQuantity).
	 *
	 * @param pageCount
	 *            the page count
	 * @return the query object
	 */
	public MasterPatientIndexQuery setPageCount(int pageCount) {
		v3PdqQuery.setPageCount(pageCount);
		return this;
	}

	/**
	 * Sets the patient birth date for the query.
	 *
	 * @param birthDate
	 *            the birth date
	 * @return the query object
	 */
	public MasterPatientIndexQuery setPatientDateOfBirth(Date birthDate) {
		v3PdqQuery.setPatientBirthDate(birthDate);
		return this;
	}

	/**
	 * Sets the patient sex for the query.
	 *
	 * @param adminstrativeGender
	 *            gender
	 * @return the query object
	 */
	public MasterPatientIndexQuery setPatientSex(AdministrativeGender adminstrativeGender) {
		v3PdqQuery.setPatientSex(FhirPatient.convertGender(adminstrativeGender));
		return this;
	}

}
