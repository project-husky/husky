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

import org.eclipse.emf.ecore.EPackage;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.enums.AdministrativeGender;
import org.ehealth_connector.communication.mpi.impl.V3PdqQuery;
import org.ehealth_connector.fhir.FhirPatient;
import org.hl7.v3.V3Package;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;

import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;

/**
 * Convenience class MasterPatientIndexQuery adds the MpiQuery functionality for
 * the Patient Demographics Query (PDQ) ITI-47.
 */
public class MasterPatientIndexQuery {

	/** The orginal model package. */
	private EPackage eOrigPackage;
	
	/** The v3 pdq query. */
	private final V3PdqQuery v3PdqQuery;

	/**
	 * Fix v3 package.
	 */
	private void fixV3Package() {
		// OHT SAGE HACK!! Save the loaded EPackage off
		eOrigPackage = EPackage.Registry.INSTANCE.getEPackage(V3Package.eNS_URI);
		if (eOrigPackage != null) {
			String name = eOrigPackage.getClass().getName();
			if (!"org.hl7.v3.impl.V3PackageImpl".equals(name)) {
				EPackage.Registry.INSTANCE.put(V3Package.eNS_URI, V3Package.eINSTANCE);
			}
		}
	}
	
	/**
	 * Post fix v3 package.
	 */
	private void postFixV3Package() {
		if (eOrigPackage != null) {
			EPackage.Registry.INSTANCE.put(V3Package.eNS_URI, eOrigPackage);
			eOrigPackage = null;
		}
	}

	/**
	 * Instantiates a new master patient index query.
	 *
	 * @param dest
	 *            the dest
	 */
	public MasterPatientIndexQuery(Destination dest) {
		fixV3Package();
		v3PdqQuery = new V3PdqQuery(dest.getSenderApplicationOid(), dest.getSenderFacilityOid(),
				dest.getReceiverApplicationOid(), dest.getReceiverFacilityOid());
		postFixV3Package();
	}

	/**
	 * Returned patient identifiers will include the added domain if available
	 *
	 * @param organizationOID
	 *            the organization oid
	 * @return the query object
	 */
	public MasterPatientIndexQuery addDomainToReturn(String organizationOID) {
		fixV3Package();
		v3PdqQuery.addDomainToReturn(organizationOID);
		postFixV3Package();
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
		fixV3Package();
		v3PdqQuery.addMothersMaidenName(useFuzzySearch, FhirPatient.convertName(name));
		postFixV3Package();
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
		fixV3Package();
		v3PdqQuery.addPatientAddress(FhirPatient.convertAddress(address.getMdhtAdress()));
		postFixV3Package();
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
		fixV3Package();
		v3PdqQuery.addPatientIdentifier(new IdentifierDt("urn:oid:" + identificator.getRoot(),
				identificator.getExtension()));
		postFixV3Package();
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
		fixV3Package();
		v3PdqQuery.addPatientName(useFuzzySearch, FhirPatient.convertName(name));
		postFixV3Package();
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
		fixV3Package();
		v3PdqQuery.addPatientTelecom(FhirPatient.convertTelecom(tel));
		postFixV3Package();
		return this;
	}

	/**
	 * Cancels the next query.
	 *
	 * @return the query object
	 */
	public MasterPatientIndexQuery cancelQuery() {
		fixV3Package();
		v3PdqQuery.cancelQuery();
		postFixV3Package();
		return this;
	}

	/**
	 * Continues query for the next pageCount results.
	 *
	 * @return the query object
	 */
	public MasterPatientIndexQuery continueQuery() {
		fixV3Package();
		v3PdqQuery.continueQuery();
		postFixV3Package();
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
		fixV3Package();
		v3PdqQuery.getV3PdqConsumerQuery().setQueryId("1.2.3.4", "NIST_CONTINUATION", "");
		postFixV3Package();
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
		fixV3Package();
		v3PdqQuery.setPageCount(pageCount);
		postFixV3Package();
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
		fixV3Package();
		v3PdqQuery.setPatientBirthDate(birthDate);
		postFixV3Package();
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
		fixV3Package();
		v3PdqQuery.setPatientSex(FhirPatient.convertGender(adminstrativeGender));
		postFixV3Package();
		return this;
	}

}
