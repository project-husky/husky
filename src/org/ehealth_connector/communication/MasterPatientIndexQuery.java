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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.cda.enums.AdministrativeGender;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.communication.mpi.FhirPatient;
import org.ehealth_connector.communication.mpi.impl.V3PdqQuery;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;

import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;

public class MasterPatientIndexQuery {

	private final Log log = LogFactory.getLog(MasterPatientIndexQuery.class);

	private final V3PdqQuery v3PdqQuery;

	public MasterPatientIndexQuery(Destination dest) {
		v3PdqQuery = new V3PdqQuery(dest.getSenderApplicationOid(), dest.getSenderFacilityOid(),
				dest.getReceiverApplicationOid(), dest.getReceiverFacilityOid());
	}

	public MasterPatientIndexQuery addDomainToReturn(String organizationOID) {
		v3PdqQuery.addDomainToReturn(organizationOID);
		return this;
	}

	public MasterPatientIndexQuery addMothersMaidenName(boolean useFuzzySearch, Name name) {
		v3PdqQuery.addMothersMaidenName(useFuzzySearch, FhirPatient.convertName(name));
		return this;
	}

	public MasterPatientIndexQuery addPatientAddress(Address address) {
		v3PdqQuery.addPatientAddress(FhirPatient.convertAddress(address.getMdhtAdress()));
		return this;
	}

	public MasterPatientIndexQuery addPatientIdentificator(Identificator identificator) {
		v3PdqQuery.addPatientIdentifier(new IdentifierDt("urn:oid:" + identificator.getRoot(),
				identificator.getExtension()));
		return this;
	}

	public MasterPatientIndexQuery addPatientName(boolean useFuzzySearch, Name name) {
		v3PdqQuery.addPatientName(useFuzzySearch, FhirPatient.convertName(name));
		return this;
	}

	public MasterPatientIndexQuery addPatientTelecom(TEL tel) {
		v3PdqQuery.addPatientTelecom(FhirPatient.convertTelecom(tel));
		return this;
	}

	public MasterPatientIndexQuery cancelQuery() {
		v3PdqQuery.cancelQuery();
		return this;
	}

	public MasterPatientIndexQuery continueQuery() {
		v3PdqQuery.continueQuery();
		return this;
	}

	/**
	 * Special test preperation IHE PIX and PDQ Pre-Connectathon Test Tool
	 * ITI-47-Consumer Query Continuation Option
	 *
	 * @return the master patient index query
	 */
	public MasterPatientIndexQuery setNistContinuationQueryId() {
		v3PdqQuery.getV3PdqConsumerQuery().setQueryId("1.2.3.4", "NIST_CONTINUATION", "");
		return this;
	}

	public MasterPatientIndexQuery setPageCount(int pageCount) {
		v3PdqQuery.setPageCount(pageCount);
		return this;
	}

	public MasterPatientIndexQuery setPatientSex(AdministrativeGender adminstrativeGender) {
		v3PdqQuery.setPatientSex(FhirPatient.convertGender(adminstrativeGender));
		return this;
	}

	protected V3PdqQuery getV3PdqQuery() {
		return v3PdqQuery;
	}

}
