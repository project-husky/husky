package org.ehealth_connector.communication.ch.ppq;

import javax.xml.namespace.QName;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultExchange;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.headers.Header.Direction;
import org.ehealth_connector.xua.core.SecurityHeaderElement;
import org.ehealth_connector.xua.serialization.impl.OpenSaml2SerializerImpl;
import org.opensaml.core.xml.XMLObject;

public class WebServiceClient<T> implements CamelContextAware {

	private CamelContext camelContext;
	
	@Override
	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;
	}

	@Override
	public CamelContext getCamelContext() {
		return camelContext;
	}
	
    protected T send(String endpoint, Object input, Class<T> outType) throws Exception {
		SecurityHeaderElement securityHeaderElement = null;
        var result = send(endpoint, input, securityHeaderElement);
        return result.getMessage().getBody(outType);
    }
    
	protected T send(String endpoint, Object input, SecurityHeaderElement securityHeaderElement, Class<T> outType)
			throws Exception {
        var result = send(endpoint, input, securityHeaderElement);
        return result.getMessage().getBody(outType);
    }
    
	private Exchange send(String endpoint, Object body, SecurityHeaderElement securityHeaderElement) throws Exception {
        Exchange exchange = new DefaultExchange(getCamelContext());
        exchange.getIn().setBody(body);
               
        
        if(securityHeaderElement != null) {
			var serializedSecurityElement = new OpenSaml2SerializerImpl()
					.serializeToXml((XMLObject) securityHeaderElement.getWrappedObject());
            
            var newSoapHeader = new SoapHeader(new QName(
    				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd",
    				"Security"), serializedSecurityElement);
            newSoapHeader.setDirection(Direction.DIRECTION_OUT);       
            exchange.getIn().setHeader("Security", newSoapHeader);
        }
        
        try(var template = camelContext.createProducerTemplate()){
        	var result = template.send(endpoint, exchange);
            if (result.getException() != null) {
                throw result.getException();
            }
            return result;
        } finally {
        	
        }
        
    }

}
