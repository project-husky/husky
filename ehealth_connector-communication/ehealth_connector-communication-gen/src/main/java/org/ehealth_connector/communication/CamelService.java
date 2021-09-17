package org.ehealth_connector.communication;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.util.CastUtils;
import org.apache.cxf.headers.Header;
import org.apache.cxf.headers.Header.Direction;
import org.ehealth_connector.xua.core.SecurityHeaderElement;
import org.ehealth_connector.xua.exceptions.SerializeException;
import org.ehealth_connector.xua.serialization.impl.OpenSaml2SerializerImpl;
import org.openehealth.ipf.platform.camel.ihe.ws.AbstractWsEndpoint;
import org.opensaml.core.xml.XMLObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;

public abstract class CamelService implements CamelContextAware {

	/** The SLF4J logger instance. */
	private static Logger log = LoggerFactory.getLogger(CamelService.class);

	@Autowired
	private CamelContext camelContext;

	@Override
	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;
	}

	@Override
	public CamelContext getCamelContext() {
		return this.camelContext;
	}

	protected void addWssHeader(SecurityHeaderElement securityHeaderElement, Exchange exchange)
			throws SerializeException, ParserConfigurationException {

		var wssElement = new OpenSaml2SerializerImpl()
				.serializeToXml((XMLObject) securityHeaderElement.getWrappedObject());

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();

		var wsseElement = doc.createElementNS(
				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "wsse:Security");

		var wsseQName = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
				"Security", "wsse");

		var replaceNode = wsseElement.getOwnerDocument().importNode(wssElement, true);
		wsseElement.appendChild(replaceNode);

		Map<QName, org.apache.cxf.headers.Header> soapHeaders = CastUtils
				.cast((Map<QName, org.apache.cxf.headers.Header>) exchange.getIn()
						.getHeader(AbstractWsEndpoint.OUTGOING_SOAP_HEADERS));
		Header newHeader;
		if (soapHeaders == null) {
			soapHeaders = new HashMap<>();
		}
		try {

			newHeader = new Header(wsseQName, wsseElement);
			newHeader.setDirection(Direction.DIRECTION_OUT);
			soapHeaders.put(wsseQName, newHeader);
			exchange.getIn().setHeader(AbstractWsEndpoint.OUTGOING_SOAP_HEADERS, soapHeaders);
		} catch (Exception e) {
			log.error("Exception caught while creating the WSS header", e);
		}

	}

	protected void addHttpHeader(Exchange exchange, Map<String, String> outgoingHttpHeaders) {

		Map<String, String> outgoingHeaders = CastUtils
				.cast((Map<String, String>) exchange.getIn().getHeader(AbstractWsEndpoint.OUTGOING_HTTP_HEADERS));

		if (outgoingHeaders == null) {
			outgoingHeaders = new HashMap<>();
		}

		for (Entry<String, String> entry : outgoingHttpHeaders.entrySet()) {
			if (entry != null && entry.getValue() != null && entry.getKey() != null) {
				outgoingHeaders.put(entry.getKey(), entry.getValue());
			}
		}

		exchange.getIn().setHeader(AbstractWsEndpoint.OUTGOING_HTTP_HEADERS, outgoingHeaders);

	}

	protected Exchange send(String endpoint, Object body, SecurityHeaderElement securityHeaderElement,
			Map<String, String> outgoingHttpHeaders)
			throws Exception {
		var camelContext = getCamelContext();
		Exchange exchange = new DefaultExchange(camelContext);
		exchange.getIn().setBody(body);
		if (securityHeaderElement != null) {
			addWssHeader(securityHeaderElement, exchange);
		}

		if (outgoingHttpHeaders != null && !outgoingHttpHeaders.isEmpty()) {
			addHttpHeader(exchange, outgoingHttpHeaders);
		}

		try (var template = camelContext.createProducerTemplate()) {
			// exchange.getProperties().put("mtom-enabled", false);
			// System.out.println(exchange.getProperties());

			var result = template.send(endpoint, exchange);

			// System.out.println(exchange.getProperties());
			if (result.getException() != null) {
				throw result.getException();
			}

			return result;
		}

	}

}
