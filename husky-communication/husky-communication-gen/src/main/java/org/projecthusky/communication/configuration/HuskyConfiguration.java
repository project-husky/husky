/**
 * 
 */
package org.projecthusky.communication.configuration;

import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration clas for specific husky beans and other configs.
 */
@Configuration
public class HuskyConfiguration {

	@Value("${husky.communication.timeout:60000}")
	private Long communicationTimeout;

	/**
	 * Configuration for the husky http client policy.
	 * 
	 * @return the HTTPClientPolicy
	 */
	@Bean
	public HTTPClientPolicy huskyHttpClientPolicy() {
		var policy = new HTTPClientPolicy();
		policy.setConnectionRequestTimeout(communicationTimeout);
		policy.setReceiveTimeout(communicationTimeout);
		return policy;
	}

}
