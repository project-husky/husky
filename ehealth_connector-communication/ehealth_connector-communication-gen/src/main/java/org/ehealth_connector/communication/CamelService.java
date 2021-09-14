package org.ehealth_connector.communication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.namespace.QName;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.util.CastUtils;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.headers.Header.Direction;
import org.ehealth_connector.xua.core.SecurityHeaderElement;
import org.ehealth_connector.xua.exceptions.SerializeException;
import org.ehealth_connector.xua.serialization.impl.OpenSaml2SerializerImpl;
import org.openehealth.ipf.platform.camel.ihe.ws.AbstractWsEndpoint;
import org.opensaml.core.xml.XMLObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
			throws SerializeException {

		var wssElement = new OpenSaml2SerializerImpl()
				.serializeToXml((XMLObject) securityHeaderElement.getWrappedObject());

		// Element wssElement = StaxUtils.read(new
		// StringReader(wssHeader)).getDocumentElement();


		List<SoapHeader> soapHeaders = CastUtils
				.cast((List<?>) exchange.getIn().getHeader(AbstractWsEndpoint.OUTGOING_SOAP_HEADERS));
		SoapHeader newHeader;
		if (soapHeaders == null) {
			soapHeaders = new ArrayList<>();
		}
		try {
			newHeader = new SoapHeader(
					new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
							"Security", "wsse"),
					wssElement);
			newHeader.setDirection(Direction.DIRECTION_OUT);
			soapHeaders.add(newHeader);
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
