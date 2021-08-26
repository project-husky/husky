/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: �����
 *
 */

package org.ehealth_connector.communication.mpi.impl.pix;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.net.URI;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.ehealth_connector.communication.CamelService;
import org.ehealth_connector.communication.mpi.V3Acknowledgement;
import org.ehealth_connector.xua.core.SecurityHeaderElement;
import org.openhealthtools.ihe.atna.auditor.PIXSourceAuditor;
import org.openhealthtools.ihe.atna.auditor.codes.rfc3881.RFC3881EventCodes.RFC3881EventOutcomeCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.ihe.gazelle.hl7v3.mcciin000002UV01.MCCIIN000002UV01Type;
import net.ihe.gazelle.hl7v3.prpain201301UV02.PRPAIN201301UV02Type;
import net.ihe.gazelle.hl7v3.prpain201302UV02.PRPAIN201302UV02Type;
import net.ihe.gazelle.hl7v3.prpain201304UV02.PRPAIN201304UV02Type;

/**
 * @author <a href="mailto:anthony.larocca@sage.com">Anthony Larocca</a>
 *
 */
public class V3PixSource extends CamelService {

	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(V3PixSource.class.getName());

	private static final String ACTOR_NAME = "";

	/**
	 * The URI of the server to issue a query against.
	 */
	private URI serverURI;

	/**
	 * PIX Source Auditor for ATNA Audit Events
	 */
	private PIXSourceAuditor auditor = PIXSourceAuditor.getAuditor();

	/**
	 * Constructor:
	 * 
	 * @param pdqServerURI the URI for the server to use for query requests
	 *                     (required, cannot be null)
	 */
	public V3PixSource(URI pixServerURI) {
		this.serverURI = pixServerURI;
	}

	/**
	 * Gets the ATNA Auditor for this Actor
	 * 
	 * @return The ATNA Auditor
	 */
	public PIXSourceAuditor getAuditor() {
		return auditor;
	}

	/**
	 * @return Returns the server URI
	 */
	public URI getServerURI() {
		return serverURI;
	}

	/**
	 * Send the provided V3PixSourceMergePatients message to the server
	 * 
	 * @param v3query
	 * @return V3PixSourceAcknowledgement - The Server Ack
	 * @throws Exception
	 */
	public V3Acknowledgement sendMergePatients(V3PixSourceMergePatients v3query,
			SecurityHeaderElement assertion)
			throws Exception {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Beginning Send Patient Record Duplicates Resolved (V3)");
		}

		// Audit Actor Start
		auditor.auditActorStartEvent(RFC3881EventOutcomeCodes.SUCCESS, ACTOR_NAME, null);

		// send the request
		var v3response = new V3Acknowledgement(sendITI44Query(v3query.getRootElement(), assertion,
				getServerURI(), "urn:hl7-org:v3:PRPA_IN201304UV02"));

		// default to success
		RFC3881EventOutcomeCodes eventOutcome = RFC3881EventOutcomeCodes.SUCCESS;
		if (v3response.hasError())
			eventOutcome = RFC3881EventOutcomeCodes.MINOR_FAILURE;

		// audit the pdq query
		auditor.auditDeletePatientRecordV3Event(eventOutcome, this.getServerURI().toString(),
				v3query.getReceivingFacility(0), v3query.getReceivingApplication(0), v3query.getSendingFacility(),
				v3query.getSendingApplication(), v3query.getMessageId().getRoot(), v3query.getPatientId());

		// Audit Actor Start
		auditor.auditActorStopEvent(RFC3881EventOutcomeCodes.SUCCESS, ACTOR_NAME, null);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Ending Send Patient Record Duplicates Resolved (V3)");
		}

		// return the response
		return v3response;
	}

	/**
	 * Send the provided V3PixSourceRecordAdded message to the server.
	 * 
	 * @param v3query
	 * @return V3PixSourceAcknowledgement - The Server Ack
	 * @throws Exception
	 */
	public V3Acknowledgement sendRecordAdded(V3PixSourceRecordAdded v3query, SecurityHeaderElement assertion)
			throws Exception {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Beginning Send Patient Record Added (V3)");
		}

		// Audit Actor Start
		auditor.auditActorStartEvent(RFC3881EventOutcomeCodes.SUCCESS, ACTOR_NAME, null);

		// send the request
		var v3response = new V3Acknowledgement(sendITI44Query(v3query.getRootElement(), assertion,
				getServerURI(), "urn:hl7-org:v3:PRPA_IN201301UV02"));

		// default to success
		RFC3881EventOutcomeCodes eventOutcome = RFC3881EventOutcomeCodes.SUCCESS;
		if (v3response.hasError())
			eventOutcome = RFC3881EventOutcomeCodes.MINOR_FAILURE;

		// audit the pdq query
		auditor.auditCreatePatientRecordV3Event(eventOutcome, this.getServerURI().toString(),
				v3query.getReceivingFacility(0), v3query.getReceivingApplication(0), v3query.getSendingFacility(),
				v3query.getSendingApplication(), v3query.getMessageId().getRoot(), v3query.getPatientId());

		// Audit Actor Start
		auditor.auditActorStopEvent(RFC3881EventOutcomeCodes.SUCCESS, ACTOR_NAME, null);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Ending Send Patient Record Added (V3)");
		}

		// return the response
		return v3response;
	}

	/**
	 * Send the provided V3PixSourceRecordRevised message to the server
	 * 
	 * @param v3query
	 * @return V3PixSourceAcknowledgement - The Server Ack
	 * @throws Exception
	 */
	public V3Acknowledgement sendRecordRevised(V3PixSourceRecordRevised v3query, SecurityHeaderElement assertion)
			throws Exception {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Beginning Send Patient Record Revised (V3)");
		}

		// Audit Actor Start
		auditor.auditActorStartEvent(RFC3881EventOutcomeCodes.SUCCESS, ACTOR_NAME, null);

		// send the request
		var v3response = new V3Acknowledgement(
				sendITI44Query(v3query.getRootElement(), assertion, getServerURI(),
						"urn:hl7-org:v3:PRPA_IN201302UV02"));
				
		// default to success
		RFC3881EventOutcomeCodes eventOutcome = RFC3881EventOutcomeCodes.SUCCESS;
		if (v3response.hasError())
			eventOutcome = RFC3881EventOutcomeCodes.MINOR_FAILURE;

		// audit the pdq query
		auditor.auditUpdatePatientRecordV3Event(eventOutcome, this.getServerURI().toString(),
				v3query.getReceivingFacility(0), v3query.getReceivingApplication(0), v3query.getSendingFacility(),
				v3query.getSendingApplication(), v3query.getMessageId().getRoot(), v3query.getPatientId());

		// Audit Actor Start
		auditor.auditActorStopEvent(RFC3881EventOutcomeCodes.SUCCESS, ACTOR_NAME, null);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Ending Send Patient Record Revised (V3)");
		}

		// return the response
		return v3response;
	}
	
	private MCCIIN000002UV01Type sendITI44Query(PRPAIN201304UV02Type request, SecurityHeaderElement assertion,
			URI pdqDest, String action) throws Exception {

		final var marshaller = JAXBContext.newInstance(PRPAIN201304UV02Type.class).createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF8");
		final var stringWriter = new StringWriter();
		marshaller.marshal(request, stringWriter);

		var xml = sendITI44Query(stringWriter.toString(), assertion, pdqDest, action);

		final var unmarshaller = JAXBContext.newInstance(MCCIIN000002UV01Type.class).createUnmarshaller();
		return (MCCIIN000002UV01Type) unmarshaller
				.unmarshal(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
	}

	private MCCIIN000002UV01Type sendITI44Query(PRPAIN201302UV02Type request, SecurityHeaderElement assertion,
			URI pdqDest, String action) throws Exception {

		final var marshaller = JAXBContext.newInstance(PRPAIN201302UV02Type.class).createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF8");
		final var stringWriter = new StringWriter();
		marshaller.marshal(request, stringWriter);

		var xml = sendITI44Query(stringWriter.toString(), assertion, pdqDest, action);

		final var unmarshaller = JAXBContext.newInstance(MCCIIN000002UV01Type.class).createUnmarshaller();
		return (MCCIIN000002UV01Type) unmarshaller
				.unmarshal(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
	}

	private MCCIIN000002UV01Type sendITI44Query(PRPAIN201301UV02Type request,
			SecurityHeaderElement assertion,
			URI pdqDest, String action) throws Exception {


		final var marshaller = JAXBContext.newInstance(PRPAIN201301UV02Type.class).createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF8");
		final var stringWriter = new StringWriter();
		marshaller.marshal(request, stringWriter);

		var xml = sendITI44Query(stringWriter.toString(), assertion, pdqDest, action);

		final var unmarshaller = JAXBContext.newInstance(MCCIIN000002UV01Type.class).createUnmarshaller();
		return (MCCIIN000002UV01Type) unmarshaller
				.unmarshal(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
	}

	private String sendITI44Query(String request, SecurityHeaderElement assertion, URI pdqDest, String action)
			throws Exception {
		final var endpoint = String.format(
				"pdqv3-iti44://%s?inInterceptors=#serverInLogger&inFaultInterceptors=#serverInLogger&outInterceptors=#serverOutLogger&outFaultInterceptors=#serverOutLogger&secure=%s",
				pdqDest.toString().replace("https://", ""), true);
		LOGGER.info("Sending request to '{}' endpoint", endpoint);

		final var exchange = send(endpoint, request, assertion, action);

		return exchange.getMessage().getBody(String.class);
	}
}
