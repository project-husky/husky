package org.projecthusky.communication.testhelper;

import org.openehealth.ipf.commons.ihe.ws.cxf.payload.InPayloadLoggerInterceptor;
import org.openehealth.ipf.commons.ihe.ws.cxf.payload.OutPayloadLoggerInterceptor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
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
