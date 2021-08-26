package org.ehealth_connector.communication.mpi.impl;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

import org.ehealth_connector.common.communication.AffinityDomain;
import org.ehealth_connector.communication.mpi.V3Acknowledgement;
import org.ehealth_connector.communication.mpi.impl.pix.V3PixSource;
import org.ehealth_connector.communication.mpi.impl.pix.V3PixSourceMessageHelper;
import org.ehealth_connector.communication.utils.PixPdqV3Utils;
import org.ehealth_connector.fhir.structures.gen.FhirCommon;
import org.ehealth_connector.fhir.structures.gen.FhirPatient;
import org.ehealth_connector.xua.core.SecurityHeaderElement;
import org.hl7.fhir.dstu3.model.Identifier;
import org.openehealth.ipf.commons.ihe.hl7v3.core.metadata.Device;
import org.openehealth.ipf.commons.ihe.hl7v3.core.requests.PixV3QueryRequest;
import org.openehealth.ipf.commons.ihe.hl7v3.core.responses.PixV3QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.ihe.gazelle.hl7v3.datatypes.II;

/**
 * PixV3Query
 *
 * PixV3Query implements the Actor Patient Identity Source from ITI-44 Patient
 * Identity Feed HL7 V3 and the Actor Patient Identifier Cross-reference
 * Consumer from ITI-45 PIXV3 Query
 *
 */
public class PixV3Query extends PixPdqV3QueryBase {

	private static final Logger LOGGER = LoggerFactory.getLogger(PixV3Query.class.getName());

	private V3PixSource pixSource;

	public PixV3Query(AffinityDomain affinityDomain, String homeCommunityOid) {
		super(affinityDomain, homeCommunityOid);
		this.pixSource = new V3PixSource(this.pixSourceUri);
	}

	public PixV3Query(AffinityDomain affinityDomain, String homeCommunityOid, String homeCommunityNamespace,
			String domainToReturnOid, String domainToReturnNamespace) {
		super(affinityDomain, homeCommunityOid, homeCommunityNamespace, domainToReturnOid, domainToReturnNamespace);
		this.pixSource = new V3PixSource(this.pixSourceUri);
	}

	/**
	 * query the mpi with patient id and return the ids in the queried domains from
	 * the mpi.
	 *
	 * Implements ITI-45 Patient Identifier Cross-reference Consumer Queries the
	 * Patient Identifier Cross-reference Manager for a list of corresponding
	 * patientidentifiers, if any
	 *
	 * @param patient               the patient
	 * @param queryDomainOids       the query domain oids
	 * @param queryDomainNamespaces the query domain namespaces
	 * @return the list of string
	 */
	public List<String> queryPatientId(org.ehealth_connector.fhir.structures.gen.FhirPatient patient,
			List<String> queryDomainOids, List<String> queryDomainNamespaces, SecurityHeaderElement assertion) {

		if (!configurePixAtna(false)) {
			return new LinkedList<>();
		}
		List<String> domainToReturnOids = new LinkedList<>();

		if (queryDomainOids != null) {
			domainToReturnOids = queryDomainOids;
		} else {
			if (this.domainToReturnOid != null) {
				domainToReturnOids.add(this.domainToReturnOid);
			}
		}

		var v3PixConsumerQueryRequest = new PixV3QueryRequest();

		var senderDev = new Device();
		var id = new II();
		id.setRoot(this.senderApplicationOid);
		senderDev.getIds().add(id);
		v3PixConsumerQueryRequest.setSender(senderDev);

		var receiverDev = new Device();
		var idReceiver = new II();
		idReceiver.setRoot(this.receiverApplicationOid);
		receiverDev.getIds().add(idReceiver);
		v3PixConsumerQueryRequest.setReceiver(receiverDev);

		/*
		 * final var v3PixConsumerQuery = new
		 * V3PixConsumerQuery(adapterCfg.getSenderApplicationOid(),
		 * adapterCfg.getSenderFacilityOid(), adapterCfg.getReceiverApplicationOid(),
		 * adapterCfg.getReceiverFacilityOid());
		 */

		// add the patient identifier
		final String homeCommunityPatientId = this.getHomeCommunityPatientId(patient);
		if (homeCommunityPatientId != null) {
			v3PixConsumerQueryRequest
					.setQueryPatientId(PixPdqV3Utils.createII(this.homeCommunityOid, homeCommunityPatientId,
							this.homeCommunityNamespace));

				for (String domainToReturnOid : domainToReturnOids) {
					v3PixConsumerQueryRequest.getDataSourceOids().add(domainToReturnOid);
				}

			PixV3QueryResponse v3PixConsumerResponse = null;
			try {

				v3PixConsumerResponse = sendQuery(v3PixConsumerQueryRequest, assertion,
						this.pixQueryUri);
					final List<String> returnIds = new LinkedList<>();

					for (String domainToReturnOid : domainToReturnOids) {
						returnIds.add(getPatientDomainId(v3PixConsumerResponse, domainToReturnOid));
					}

					return returnIds;
			} catch (final Exception e) {
				LOGGER.error("exception queryPatient", e);
				return domainToReturnOids;
			}
		} else {
			LOGGER.error("homeCommunityPatientId not provided");
			return domainToReturnOids;
		}
	}

	/**
	 * adds a patient to the mpi. implements ITI-44 Patient Identity Source – Add
	 * Patient Record
	 *
	 * @param patient the patient
	 * @return true, if successful
	 */
	public boolean addPatient(FhirPatient patient, SecurityHeaderElement assertion) {
		if (pixSource == null) {
			pixSource = new V3PixSource(this.pixSourceUri);
		}

		if (!configurePixAtna(true)) {
			return false;
		}

		LOGGER.debug("creating v3RecordAddedMessage");
		var ret = false;
		final var v3RecordAddedMessage = new V3PixSourceMessageHelper(true, false, false,
				this.senderApplicationOid, this.senderFacilityOid, this.receiverApplicationOid,
				this.receiverFacilityOid);
		LOGGER.debug("add demographic data");
		addDemographicData(patient, v3RecordAddedMessage);
		try {
			final V3Acknowledgement v3pixack = pixSource
					.sendRecordAdded(v3RecordAddedMessage.getV3RecordAddedMessage(), assertion);
			ret = checkResponse(v3pixack);
		} catch (final Exception e) {
			LOGGER.error("addPatient failed", e);
		}
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
	 * @param patient    the patient (with the surviving identifier)
	 * @param obsoleteId the obsolete id (duplicate patient identifier)
	 * @return true, if successful
	 */
	public boolean mergePatient(FhirPatient patient, String obsoleteId, SecurityHeaderElement assertion) {
		if (pixSource == null) {
			pixSource = new V3PixSource(this.pixSourceUri);
		}

		if (!configurePixAtna(true)) {
			return false;
		}

		var ret = false;

		final var v3pixSourceMsgMerge = new V3PixSourceMessageHelper(false, false, true,
				this.senderApplicationOid, this.senderFacilityOid, this.receiverApplicationOid,
				this.receiverFacilityOid);
		addDemographicData(patient, v3pixSourceMsgMerge);

		v3pixSourceMsgMerge.getV3MergePatientsMessage().setObsoletePatientID(obsoleteId, this.homeCommunityOid,
				this.homeCommunityNamespace);
		try {
			final V3Acknowledgement v3pixack = pixSource
					.sendMergePatients(v3pixSourceMsgMerge.getV3MergePatientsMessage(), assertion);
			ret = checkResponse(v3pixack);
		} catch (final Exception e) {
			LOGGER.error("mergePatient failed", e);
		}
		return ret;
	}

	/**
	 * updates the demographic information of the patient in the mpi.
	 *
	 * implements ITI-44 Patient Identity Source – Revise Patient Record updates the
	 * demographic information of the patient in the mpi.
	 *
	 * @param patient the patient
	 * @return true, if successful
	 */
	public boolean updatePatient(FhirPatient patient, SecurityHeaderElement assertion) {
		if (pixSource == null) {
			pixSource = new V3PixSource(this.pixSourceUri);
		}
		final var v3RecordRevisedMessage = new V3PixSourceMessageHelper(false, true, false,
				this.senderApplicationOid, this.senderFacilityOid, this.receiverApplicationOid,
				this.receiverFacilityOid);
		addDemographicData(patient, v3RecordRevisedMessage);
		try {
			final V3Acknowledgement v3pixack = pixSource
					.sendRecordRevised(v3RecordRevisedMessage.getV3RecordRevisedMessage(), assertion);
			return checkResponse(v3pixack);
		} catch (final Exception e) {
			LOGGER.error("updatePatient failed", e);
			return false;
		}
	}

	/**
	 * Checks the response, error are logged.
	 *
	 * @param response the response
	 * @return true, if response has no error, false if there are errors
	 */
	protected boolean checkResponse(V3Acknowledgement response) {
		if (response.hasError()) {
			LOGGER.error("AcknowledgementCode: {}", response.getAcknowledgementCode());
			LOGGER.error("Query error text: {}", response.getErrorText());
			return false;
		}
		return true;
	}

	/**
	 * Query patient id.
	 *
	 * @param patient the patient
	 * @return the string
	 */
	public String queryPatientId(FhirPatient patient, SecurityHeaderElement assertion) {
		return queryPatientId(patient, null, null, assertion).get(0);
	}

	/**
	 * Gets the home community patient id.
	 *
	 * @param patient the patient
	 * @return the home community patient id
	 */
	protected String getHomeCommunityPatientId(FhirPatient patient) {
		for (final Identifier Identifier : patient.getIdentifier()) {
			if (Identifier.getSystem().startsWith(FhirCommon.oidUrn)
					&& FhirCommon.removeUrnOidPrefix(Identifier.getSystem()).equals(this.homeCommunityOid)) {
					return Identifier.getValue();
			}
		}
		return null;
	}

	/**
	 * Gets the patient domain id.
	 *
	 * @param v3PixConsumerResponse the v3 pix consumer response
	 * @param rootOid               the root oid
	 * @return the patient domain id
	 */
	public String getPatientDomainId(PixV3QueryResponse v3PixConsumerResponse, String rootOid) {
		String retVal = null;
		if ((rootOid != null) && (v3PixConsumerResponse != null) && ((!v3PixConsumerResponse.getPatientIds().isEmpty())
				|| (!v3PixConsumerResponse.getAsOtherIDs().isEmpty()))) {

			for (var i = 0; i < v3PixConsumerResponse.getPatientIds().size(); i++) {
				final II id = v3PixConsumerResponse.getPatientIds().get(i);
				if (id != null && id.getRoot() != null && id.getRoot().equals(rootOid)) {
					retVal = id.getExtension();
				}
			}
			if (retVal == null) {
				for (var i = 0; i < v3PixConsumerResponse.getAsOtherIDs().size(); i++) {
					final II id = v3PixConsumerResponse.getAsOtherIDs().get(i).getId().get(0);
					if (id != null && id.getRoot() != null && id.getRoot().equals(rootOid)) {
						retVal = id.getExtension();
					}
				}
			}
		}
		return retVal;
	}

	private PixV3QueryResponse sendQuery(PixV3QueryRequest request, SecurityHeaderElement assertion, URI pdqDest)
			throws Exception {
		final var endpoint = String.format(
				"pixv3-iti45://%s?inInterceptors=#serverInLogger&inFaultInterceptors=#serverInLogger&outInterceptors=#serverOutLogger&outFaultInterceptors=#serverOutLogger&secure=%s",
				pdqDest.toString().replace("https://", ""), true);
		LOGGER.info("Sending request to '{}' endpoint", endpoint);

		final var exchange = send(endpoint, request, assertion, "urn:hl7-org:v3:PRPA_IN201309UV02");

		return exchange.getMessage().getBody(PixV3QueryResponse.class);
	}

}
