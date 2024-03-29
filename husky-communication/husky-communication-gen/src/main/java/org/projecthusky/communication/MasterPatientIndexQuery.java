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

package org.projecthusky.communication;

import java.util.Date;

import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.enums.AdministrativeGender;
import org.projecthusky.common.model.Address;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Name;
import org.projecthusky.common.model.Telecom;
import org.projecthusky.communication.mpi.impl.pdq.V3PdqQuery;
import org.projecthusky.fhir.structures.gen.FhirPatient;

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
		if (name != null) {
			v3PdqQuery.addMothersMaidenName(useFuzzySearch, FhirPatient.convertName(name));
		}
		return this;
	}

	/**
	 * Adds the mothers maiden name to the query
	 *
	 * @param useFuzzySearch if true does not require an exact match, see Table
	 *                       3.47.4.1.2-1: Model Attributes (ITI TF-2b)
	 * @param name           the name
	 * @return the query object
	 */
	public MasterPatientIndexQuery addMothersMaidenName(boolean useFuzzySearch, HumanName name) {
		if (name != null) {
			v3PdqQuery.addMothersMaidenName(useFuzzySearch, name);
		}
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
		if (address != null) {
			v3PdqQuery.addPatientAddress(FhirPatient.convertAddress(address));
		}
		return this;
	}

	/**
	 * Adds a patient address to the query.
	 *
	 * @param address the address to be queried for
	 * @return the query object
	 */
	public MasterPatientIndexQuery addPatientAddress(org.hl7.fhir.r4.model.Address address) {
		if (address != null) {
			v3PdqQuery.addPatientAddress(address);
		}
		return this;
	}

	/**
	 * Adds a patient identifier to be queried for.
	 *
	 * @param identificator patient identifier
	 * @return the query object
	 */
	public MasterPatientIndexQuery addPatientIdentificator(Identificator identificator) {
		if (identificator != null) {
			Identifier id = new Identifier();
			id.setSystem(identificator.getRoot());
			id.setValue(identificator.getExtension());
			v3PdqQuery.addPatientIdentifier(id);
		}

		return this;
	}

	/**
	 * Adds a patient identifier to be queried for.
	 *
	 * @param id patient identifier
	 * @return the query object
	 */
	public MasterPatientIndexQuery addPatientIdentificator(Identifier id) {
		if (id != null) {
			v3PdqQuery.addPatientIdentifier(id);
		}

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
		if (name != null) {
			v3PdqQuery.addPatientName(useFuzzySearch, FhirPatient.convertName(name));
		}
		return this;
	}

	/**
	 * Adds a patient name to the query.
	 *
	 * @param useFuzzySearch if true does not require an exact match, see Table
	 *                       3.47.4.1.2-1: Model Attributes (ITI TF-2b)
	 * @param name           the name
	 * @return the master patient index query
	 */
	public MasterPatientIndexQuery addPatientName(boolean useFuzzySearch, HumanName name) {
		if (name != null) {
			v3PdqQuery.addPatientName(useFuzzySearch, name);
		}
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
	 * Adds a patient telecom to be queried for.
	 *
	 * @param tel telecom
	 * @return the query object
	 */
	public MasterPatientIndexQuery addPatientTelecom(ContactPoint tel) {
		v3PdqQuery.addPatientTelecom(tel);
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
