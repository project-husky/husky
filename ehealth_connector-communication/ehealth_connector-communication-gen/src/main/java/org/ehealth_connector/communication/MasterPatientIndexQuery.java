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

package org.ehealth_connector.communication;

import java.util.Date;

import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.enums.AdministrativeGender;
import org.ehealth_connector.communication.mpi.impl.V3PdqQuery;
import org.ehealth_connector.fhir.FhirPatient;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;

import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;

/**
 * Convenience class MasterPatientIndexQuery adds the MpiQuery functionality for
 * the Patient Demographics Query (PDQ) ITI-47.
 */
public class MasterPatientIndexQuery {

	static final private org.openhealthtools.mdht.uml.cda.CDAFactory FACTORY = org.openhealthtools.mdht.uml.cda.CDAFactory.eINSTANCE;

	static {
		// org.openhealthtools.mdht.uml.cda.CDAFactory.eINSTANCE needs to be
		// initialized before org.hl7.v3.impl.V3FactoryImpl, otherwise a
		// classcast Exception occurs
		// java.lang.ClassCastException: org.hl7.v3.impl.V3FactoryImpl cannot be
		// cast to org.openhealthtools.mdht.uml.cda.CDAFactory
		if (FACTORY == null) {
			throw new ExceptionInInitializerError();
		}
	}

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
		v3PdqQuery.addPatientAddress(FhirPatient.convertAddress(address.getMdhtAdress()));
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
		v3PdqQuery.addPatientIdentifier(new IdentifierDt("urn:oid:" + identificator.getRoot(),
				identificator.getExtension()));
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
	public MasterPatientIndexQuery addPatientTelecom(TEL tel) {
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
