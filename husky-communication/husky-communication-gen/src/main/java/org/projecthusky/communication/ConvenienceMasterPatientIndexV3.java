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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.projecthusky.common.communication.AffinityDomain;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Patient;
import org.projecthusky.communication.mpi.impl.PdqV3Query;
import org.projecthusky.communication.mpi.impl.PixV3Query;
import org.projecthusky.communication.mpi.impl.pdq.V3PdqQueryResponse;
import org.projecthusky.fhir.structures.gen.FhirPatient;
import org.projecthusky.xua.core.SecurityHeaderElement;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ConvenienceMasterPatientIndexV3
 *
 * ConvenienceMasterPatientIndexV3 implements the Actor Patient Identity Source
 * from ITI-44 Patient Identity Feed HL7 V3, the Actor Patient Identifier
 * Cross-reference Consumer from ITI-45 PIXV3 Query and as well as the ITI-47
 * PDQ Consumer to communicate with an MPI.
 *
 * <div class="de"> Diese Klasse stellt Methoden für die Kommunikation mit einem
 * Master Patient Index bereit (MPI) Die Kommunikation erfolgt in dieser Klasse
 * mit HL7 V3 (PIX V3, PDQV3) </div>
 */
@Component("convenienceMasterPatientIndexV3Client")
public class ConvenienceMasterPatientIndexV3 {

	/** The SLF4J logger instance. */
	private static Logger log = LoggerFactory.getLogger(ConvenienceMasterPatientIndexV3.class);

	private static final String AFFINITY_DOMAIN_NOT_SPECIFIED = "affinityDomain has to be specified";

	@Autowired
	private CamelContext context;

	@Autowired
	private AuditContext auditContext;

	/**
	 * adds a patient to the mpi. implements ITI-44 Patient Identity Source – Add
	 * Patient Record
	 *
	 * <div class="de">
	 * <p>
	 * Registriert einen neuen Patienten mit demografischen Personendaten an einen
	 * Master Patient Index (Patient Identity Cross-Reference Manager Akteur gemäss
	 * IHE PIX).
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE PIX
	 * Patient Identity Source</b>
	 * </p>
	 * </div>
	 *
	 * @param patient          demographic data of the patient
	 * @param homeCommunityOid local patient domain (oid) of the source
	 * @param affinityDomain   affinityDomain configuration with pixDestination,
	 *                         homeCommunityId and Atna configuration
	 * @return true, if successful
	 */
	public boolean addPatientDemographics(Patient patient, String homeCommunityOid, AffinityDomain affinityDomain,
			SecurityHeaderElement security, String messageId) {
		if (affinityDomain == null) {
			log.error(AFFINITY_DOMAIN_NOT_SPECIFIED);
			return false;
		}

		log.debug("addPatientDemographics, creating patient");
		final var fhirPatient = new FhirPatient(patient);
		log.debug("addPatientDemographics, add patient");
		var v3PixQuery = new PixV3Query(affinityDomain, homeCommunityOid, context, auditContext);
		final boolean ret = v3PixQuery.addPatient(fhirPatient, security, messageId);
		log.debug("addPatientDemographics, add patient finished");
		return ret;
	}

	/**
	 * Merge patient. implements ITI-44 Patient Identity Source – Patient Identity
	 * Merge
	 *
	 * Patient Registry Duplicates Resolved message indicates that the Patient
	 * Identity Source has done a merge within a specific Patient Identification
	 * Domain. That is, the surviving identifier (patient ID) has subsumed a
	 * duplicate patient identifier.
	 *
	 * <div class="de">
	 * <p>
	 * Vereinigt zwei Patienten im Master Patient Index (Patient Identity
	 * Cross-Reference Manager Akteur gemäss IHE PIX).
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE PIX
	 * Patient Identity Source</b>
	 * </p>
	 * </div>
	 *
	 * @param finalPatient     the patient with the surviving identifier
	 * @param homeCommunityOid local patient domain (oid) of the source
	 * @param mergeObsoleteId  duplicate patient identifier
	 * @param affinityDomain   affinityDomain configuration with pixDestination,
	 *                         homeCommunityId and Atna configuration
	 * @return true, if successful
	 */
	public boolean mergePatients(Patient finalPatient, String mergeObsoleteId, String homeCommunityOid,
			AffinityDomain affinityDomain, SecurityHeaderElement security, String messageId) {

		if (affinityDomain == null) {
			log.error(AFFINITY_DOMAIN_NOT_SPECIFIED);
			return false;
		}

		if (mergeObsoleteId == null) {
			log.error("no localid specified for oid {}", homeCommunityOid);
			return false;
		}

		var v3PixQuery = new PixV3Query(affinityDomain, homeCommunityOid, context, auditContext);
		return v3PixQuery.mergePatient(new FhirPatient(finalPatient), mergeObsoleteId, security, messageId);
	}

	/**
	 * queries the mpi for patient according to the demographics criteria specified.
	 *
	 * @param mpiQuery       the mpi query criterias
	 * @param affinityDomain affinityDomain configuration with pdqDestination,
	 *                       homeCommunityId and Atna configuration
	 * @return query response with patients
	 */
	public MasterPatientIndexQueryResponse queryPatientDemographics(MasterPatientIndexQuery mpiQuery,
			AffinityDomain affinityDomain, SecurityHeaderElement security, String messageId) {

		if (affinityDomain == null) {
			log.error(AFFINITY_DOMAIN_NOT_SPECIFIED);
			return null;
		}

		var query = new PdqV3Query(affinityDomain, null, context, auditContext);

		final V3PdqQueryResponse pdqQueryRespones = query.queryPatients(mpiQuery.getV3PdqQuery(), security, messageId);
		return new MasterPatientIndexQueryResponse(pdqQueryRespones);
	}

	/**
	 * query the mpi with patient id and return the ids in the queried domains from
	 * the mpi.
	 *
	 * Implements ITI-45 Patient Identifier Cross-reference Consumer Queries the
	 * Patient Identifier Cross-reference Manager for a list of corresponding
	 * patientidentifiers, if any
	 *
	 * <div class="de">
	 * <p>
	 * Fragt eine Patienten-ID beim Master Patient Index ab (Patient Identity
	 * Cross-Reference Manager Akteur gemäss IHE PIX).
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE PIX
	 * Patient Identifier Cross-Reference Concumer</b>
	 * </p>
	 * </div>
	 *
	 * @param patient                demographic data of the patient
	 * @param homeCommunityOid       local patient domain (oid) of the source
	 * @param requestedCommunityOIDs array of oids for domains to query
	 * @param affinityDomain         affinityDomain configuration with
	 *                               pixDestination, homeCommunityId and Atna
	 *                               configuration
	 * @return list of ids
	 */
	public List<Identificator> queryPatientId(Patient patient, String homeCommunityOid,
			List<String> requestedCommunityOIDs, AffinityDomain affinityDomain, SecurityHeaderElement security,
			String messageId) {

		if (affinityDomain == null) {
			log.error(AFFINITY_DOMAIN_NOT_SPECIFIED);
			return new LinkedList<>();
		}

		var query = new PixV3Query(affinityDomain, homeCommunityOid, null, requestedCommunityOIDs.get(0), null,
				this.context, getAuditContext());

		List<String> ids = query.queryPatientId(new FhirPatient(patient), null, null, security, messageId);

		final List<Identificator> list = new ArrayList<>();
		for (var i = 0; i < requestedCommunityOIDs.size(); ++i) {
			var id = "";
			if (i < ids.size()) {
				id = ids.get(i);
			}
			list.add(new Identificator(requestedCommunityOIDs.get(i), id));
		}

		return list;
	}

	/**
	 * updates the demographic information of the patient in the mpi.
	 *
	 * implements ITI-44 Patient Identity Source – Revise Patient Record updates the
	 * demographic information of the patient in the mpi.
	 *
	 * <div class="de">
	 * <p>
	 * Aktualisiert die demographischen Daten eines Patienten im Master Patient
	 * Index (Patient Identity Cross-Reference Manager Akteur gemäss IHE PIX)
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE PIX
	 * Patient Identity Source</b>
	 * </p>
	 * </div>
	 *
	 * @param patient          demographic data of the patient
	 * @param homeCommunityOid local patient domain (oid) of the source
	 * @param affinityDomain   affinityDomain configuration with pixDestination,
	 *                         homeCommunityId and Atna configuration
	 * @return true, if successful
	 */
	public boolean updatePatientDemographics(Patient patient, String homeCommunityOid, AffinityDomain affinityDomain,
			SecurityHeaderElement security, String messageId) {

		if (affinityDomain == null) {
			log.error(AFFINITY_DOMAIN_NOT_SPECIFIED);
			return false;
		}

		var v3PixQuery = new PixV3Query(affinityDomain, homeCommunityOid, context, auditContext);
		return v3PixQuery.updatePatient(new FhirPatient(patient), security, messageId);
	}

	public CamelContext getContext() {
		return context;
	}

	public void setContext(CamelContext context) {
		this.context = context;
	}

	public AuditContext getAuditContext() {
		return auditContext;
	}

	public void setAuditContext(AuditContext context) {
		this.auditContext = context;
	}

}
