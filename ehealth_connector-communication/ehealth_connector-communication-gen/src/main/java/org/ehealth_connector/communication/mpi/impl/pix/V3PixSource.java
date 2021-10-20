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
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.camel.CamelContext;
import org.ehealth_connector.communication.CamelService;
import org.ehealth_connector.communication.mpi.V3Acknowledgement;
import org.ehealth_connector.xua.core.SecurityHeaderElement;
import org.openehealth.ipf.commons.audit.AuditContext;
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

	/**
	 * The URI of the server to issue a query against.
	 */
	private URI serverURI;

	/**
	 * Constructor:
	 * 
	 * @param pdqServerURI the URI for the server to use for query requests
	 *                     (required, cannot be null)
	 */
	public V3PixSource(URI pixServerURI, CamelContext context, AuditContext auditorContext) {
		this.serverURI = pixServerURI;
		setAuditContext(auditorContext);
		setCamelContext(context);
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

		// send the request
		var v3response = new V3Acknowledgement(sendITI44Query(v3query.getRootElement(), assertion,
				getServerURI(), "urn:hl7-org:v3:PRPA_IN201304UV02"));

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

		// send the request
		var v3response = new V3Acknowledgement(sendITI44Query(v3query.getRootElement(), assertion,
				getServerURI(), "urn:hl7-org:v3:PRPA_IN201301UV02"));

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

		// send the request
		var v3response = new V3Acknowledgement(
				sendITI44Query(v3query.getRootElement(), assertion, getServerURI(),
						"urn:hl7-org:v3:PRPA_IN201302UV02"));
				
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
				"pixv3-iti44://%s?inInterceptors=#serverInLogger&inFaultInterceptors=#serverInLogger&outInterceptors=#serverOutLogger&outFaultInterceptors=#serverOutLogger&secure=%s&audit=%s&auditContext=#auditContext",
				pdqDest.toString().replace("https://", ""), true, getAuditContext().isAuditEnabled());
		LOGGER.info("Sending request to '{}' endpoint", endpoint);

		Map<String, String> outgoingHeaders = new HashMap<>();
		outgoingHeaders.put("Accept", "application/soap+xml");
		outgoingHeaders.put("Content-Type",
				String.format("application/soap+xml; charset=UTF-8; action=\"%s\"", action));

		final var exchange = send(endpoint, request, assertion, outgoingHeaders);

		return exchange.getMessage().getBody(String.class);
	}
}
