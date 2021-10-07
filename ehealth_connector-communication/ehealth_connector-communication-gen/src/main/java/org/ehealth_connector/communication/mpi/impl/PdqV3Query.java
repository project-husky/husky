package org.ehealth_connector.communication.mpi.impl;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.camel.CamelContext;
import org.ehealth_connector.common.communication.AffinityDomain;
import org.ehealth_connector.communication.mpi.impl.pdq.V3PdqConsumerQuery;
import org.ehealth_connector.communication.mpi.impl.pdq.V3PdqConsumerResponse;
import org.ehealth_connector.communication.mpi.impl.pdq.V3PdqContinuationBase;
import org.ehealth_connector.communication.mpi.impl.pdq.V3PdqContinuationCancel;
import org.ehealth_connector.communication.mpi.impl.pdq.V3PdqContinuationQuery;
import org.ehealth_connector.communication.mpi.impl.pdq.V3PdqQuery;
import org.ehealth_connector.communication.mpi.impl.pdq.V3PdqQueryResponse;
import org.ehealth_connector.fhir.structures.gen.FhirPatient;
import org.ehealth_connector.xua.core.SecurityHeaderElement;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.ihe.gazelle.hl7v3.datatypes.INT;
import net.ihe.gazelle.hl7v3.prpain201305UV02.PRPAIN201305UV02Type;
import net.ihe.gazelle.hl7v3.prpain201306UV02.PRPAIN201306UV02Type;
import net.ihe.gazelle.hl7v3.prpamt201310UV02.PRPAMT201310UV02Patient;
import net.ihe.gazelle.hl7v3.quqiin000003UV01.QUQIIN000003UV01Type;

/**
 * PdqV3Query
 *
 * PdqV3Query implements the ITI-47 PDQ Consumer
 */
@Component
public class PdqV3Query extends PixPdqV3QueryBase {

	private static final Logger LOGGER = LoggerFactory.getLogger(PdqV3Query.class.getName());

	public PdqV3Query() {
		super();
	}

	public PdqV3Query(AffinityDomain affinityDomain, String homeCommunityOid, CamelContext context,
			AuditContext auditContext) {
		super(affinityDomain, homeCommunityOid, context);
		this.auditContext = auditContext;
	}

	public PdqV3Query(AffinityDomain affinityDomain, String homeCommunityOid, String homeCommunityNameSpace,
			CamelContext context, AuditContext auditContext) {
		super(affinityDomain, homeCommunityOid, homeCommunityNameSpace, null, null, context);
		this.auditContext = auditContext;
	}

	/**
	 * Perfoms a PDQ Query (ITI-47)
	 *
	 * @param mpiQuery the mpi query object
	 * @return the v3 pdq query response
	 */
	public V3PdqQueryResponse queryPatients(V3PdqQuery mpiQuery, SecurityHeaderElement assertion) {
		final var queryResponse = new V3PdqQueryResponse();

		/** The last pdq consumer response. */

		try {
			if (!mpiQuery.doCancelQuery()) {
				PRPAIN201306UV02Type lastPdqConsumerResponse = null;
				if (!mpiQuery.doContinueQuery()) {
					try {
						lastPdqConsumerResponse = sendITI47Query(mpiQuery.getV3PdqConsumerQuery(), assertion,
								this.pdqConsumerUri);
					} catch (final Exception e) {
						LOGGER.error("queryPatient failed", e);
						queryResponse.setSuccess(false);
						return queryResponse;
					}
				} else {
					final var continuationQuery = new V3PdqContinuationQuery(
							mpiQuery.getV3PdqConsumerQuery().getSendingApplication(),
							mpiQuery.getV3PdqConsumerQuery().getSendingFacility(),
							mpiQuery.getV3PdqConsumerQuery().getReceivingApplication(0),
							mpiQuery.getV3PdqConsumerQuery().getReceivingFacility(0),
							mpiQuery.getLastPdqConsumerResponse(), mpiQuery.getPageCount());
					continuationQuery.setProcessingCode("T");
					lastPdqConsumerResponse = sendITI47ContinuationQuery(continuationQuery, assertion,
							this.pdqConsumerUri);
				}

				var response = new V3PdqConsumerResponse(lastPdqConsumerResponse);
				queryResponse.setPatients(getPatientsFromPdqQuery(response));
				queryResponse.setSuccess(!response.hasError());
				queryResponse.setCurrentNumbers(response.getNumRecordsCurrent());
				queryResponse.setRemainingNumbers(response.getNumRecordsRemaining());
				if (response.getAcknowledgementDetailCode() != null) {
					queryResponse.setInfoCodes(List.of(response.getAcknowledgementDetailCode()));
				}

				if (response.getAcknowledgementDetailText() != null) {
					queryResponse.setInfoTexts(List.of(response.getAcknowledgementDetailText()));
				}
				queryResponse.setErrorText(response.getErrorText());
				final INT totalNumbers = response.getPdqResponse().getControlActProcess().getQueryAck()
						.getResultTotalQuantity();
				if (totalNumbers != null) {
					queryResponse.setTotalNumbers(totalNumbers.getValue().intValue());
				}

				mpiQuery.setLastPdqConsumerResponse(response);
			} else {
				V3PdqConsumerResponse lastPdqConsumerResponse = mpiQuery.getLastPdqConsumerResponse();
				final var continuationCancel = new V3PdqContinuationCancel(
						mpiQuery.getV3PdqConsumerQuery().getSendingApplication(),
						mpiQuery.getV3PdqConsumerQuery().getSendingFacility(),
						mpiQuery.getV3PdqConsumerQuery().getReceivingApplication(0),
						mpiQuery.getV3PdqConsumerQuery().getReceivingFacility(0), lastPdqConsumerResponse);
				var response = sendITI47ContinuationQuery(continuationCancel, assertion,
						this.pdqConsumerUri);

				lastPdqConsumerResponse = new V3PdqConsumerResponse(response);
				queryResponse.setSuccess(!lastPdqConsumerResponse.hasError());
			}
		} catch (final Exception e) {
			LOGGER.error("queryPatient failed", e);
			queryResponse.setSuccess(false);
			return queryResponse;
		}
		return queryResponse;
	}

	/**
	 * Gets the patients from pdq query.
	 *
	 * @param response the response
	 * @return the patients from pdq query
	 */
	public List<FhirPatient> getPatientsFromPdqQuery(V3PdqConsumerResponse response) {
		var success = false;
		if (response != null) {
			success = !response.hasError();
			if (success) {
				final List<FhirPatient> listFhirPatients = new ArrayList<>(response.getNumRecordsCurrent());
				for (var i = 0; i < response.getNumRecordsCurrent(); ++i) {
					final var fhirPatient = new FhirPatient();
					addDemographicData(getPatientByIndex(response, i), fhirPatient);
					listFhirPatients.add(fhirPatient);
				}
				return listFhirPatients;
			}
		}
		return new LinkedList<>();
	}

	/**
	 * Get the specified patient object.
	 *
	 * @param v3PdqConsumerResponse the consumer response
	 * @param patientIndex          the patient index
	 * @return PRPAMT201310UV02Patient - the patient object at the specified index.
	 */
	protected PRPAMT201310UV02Patient getPatientByIndex(V3PdqConsumerResponse v3PdqConsumerResponse, int patientIndex) {
		return v3PdqConsumerResponse.getPdqResponse().getControlActProcess().getSubject().get(patientIndex)
				.getRegistrationEvent().getSubject1().getPatient();
	}

	private PRPAIN201306UV02Type sendITI47Query(V3PdqConsumerQuery request, SecurityHeaderElement assertion,
			URI pdqDest) throws Exception {
		final var endpoint = String.format(
				"pdqv3-iti47://%s?inInterceptors=#serverInLogger&inFaultInterceptors=#serverInLogger&outInterceptors=#serverOutLogger&outFaultInterceptors=#serverOutLogger&secure=%s",
				pdqDest.toString().replace("https://", ""), true);
		LOGGER.info("Sending request to '{}' endpoint", endpoint);

		final var marshaller = JAXBContext.newInstance(PRPAIN201305UV02Type.class).createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF8");
		final var stringWriter = new StringWriter();
		marshaller.marshal(request.getRootElement(), stringWriter);

		Map<String, String> outgoingHeaders = new HashMap<>();
		outgoingHeaders.put("Accept", "application/soap+xml");
		outgoingHeaders.put("Content-Type",
				"application/soap+xml; charset=UTF-8; action=\"urn:hl7-org:v3:PRPA_IN201305UV02\"");

		final var exchange = send(endpoint, stringWriter.toString(), assertion, outgoingHeaders);

		var xml = exchange.getMessage().getBody(String.class);

		final var unmarshaller = JAXBContext.newInstance(PRPAIN201306UV02Type.class).createUnmarshaller();
		return (PRPAIN201306UV02Type) unmarshaller
				.unmarshal(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
	}

	private PRPAIN201306UV02Type sendITI47ContinuationQuery(V3PdqContinuationBase request,
			SecurityHeaderElement assertion, URI pdqDest) throws Exception {
		final var endpoint = String.format(
				"pdqv3-iti47://%s?inInterceptors=#serverInLogger&inFaultInterceptors=#serverInLogger&outInterceptors=#serverOutLogger&outFaultInterceptors=#serverOutLogger&secure=%s&supportContinuation=%s&defaultContinuationThreshold=50",
				pdqDest.toString().replace("https://", ""), true, true);
		LOGGER.info("Sending request to '{}' endpoint", endpoint);

		final var marshaller = JAXBContext.newInstance(QUQIIN000003UV01Type.class).createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF8");
		final var stringWriter = new StringWriter();
		marshaller.marshal(request.getRootElement(), stringWriter);

		Map<String, String> outgoingHeaders = new HashMap<>();
		outgoingHeaders.put("Accept", "application/soap+xml");
		outgoingHeaders.put("Content-Type",
				"application/soap+xml; charset=UTF-8; action=\"urn:hl7-org:v3:QUQI_IN000003UV01\"");

		final var exchange = send(endpoint, stringWriter.toString(), assertion, outgoingHeaders);

		var xml = exchange.getMessage().getBody(String.class);

		final var unmarshaller = JAXBContext.newInstance(PRPAIN201306UV02Type.class).createUnmarshaller();
		return (PRPAIN201306UV02Type) unmarshaller
				.unmarshal(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
	}

}
