package org.ehealth_connector.communication.testhelper;

import org.openehealth.ipf.commons.ihe.ws.cxf.payload.InPayloadLoggerInterceptor;
import org.openehealth.ipf.commons.ihe.ws.cxf.payload.OutPayloadLoggerInterceptor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAutoConfiguration
@PropertySource("classpath:atna-audit.properties")
public class IpfApplicationConfig {

	@Bean
	InPayloadLoggerInterceptor serverInLogger() {
		return new InPayloadLoggerInterceptor("log/TestEHC.log");
	}

	@Bean
	OutPayloadLoggerInterceptor serverOutLogger() {
		return new OutPayloadLoggerInterceptor("log/TestEHC.log");
	}

}
