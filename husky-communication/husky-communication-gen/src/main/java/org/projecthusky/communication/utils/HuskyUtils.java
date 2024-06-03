/**
 * 
 */
package org.projecthusky.communication.utils;

import java.net.URI;

/**
 * Helper class for husky specific functionality.
 */
public abstract class HuskyUtils {

	public static final String SERVER_IN_LOGGER = "#serverInLogger";
	public static final String SERVER_OUT_LOGGER = "#serverOutLogger";
	public static final String AUDIT_CONTEXT = "#auditContext";
	public static final String HTTP_CLIENT_POLICY = "#huskyHttpClientPolicy";
	public static final String HTTPS_LITERAL = "https://";
	public static final String HTTP_LITERAL = "http://";
	/**
	 * Method to create the endpoint string for IPF.
	 * 
	 * @param transactionType the IHE transaction type
	 * @param destination     the destination URI
	 * @param auditEnabled    true if audit is enabled
	 * @return the IPF/Camel endpoint string
	 */
	public static String createEndpoint(String transactionType, //
			URI destination, //
			boolean auditEnabled) //
	{
		return createEndpoint(transactionType, destination.toString(), auditEnabled);
	}

	/**
	 * Method to create the endpoint string for IPF.
	 * 
	 * @param transactionType the IHE transaction type
	 * @param destination     the destination as string
	 * @param auditEnabled    true if audit is enabled
	 * @return the IPF/Camel endpoint string
	 */
	public static String createEndpoint(String transactionType, //
			String destination, //
			boolean auditEnabled) //
	{
		boolean secure = destination.contains(HTTPS_LITERAL);
		return createEndpoint(transactionType, destination.toString(), secure, auditEnabled);
	}

	/**
	 * Method to create the endpoint string for IPF.
	 * 
	 * @param transactionType the IHE transaction type
	 * @param destination     the destination as URI
	 * @param secure          true if it should be secure
	 * @param auditEnabled    true if audit is enabled
	 * @return the IPF/Camel endpoint string
	 */
	public static String createEndpoint(String transactionType, //
			URI destination, //
			boolean secure, //
			boolean auditEnabled) //
	{
		return createEndpoint(transactionType, destination.toString(), secure, auditEnabled);
	}

	/**
	 * Method to create the endpoint string for IPF.
	 * 
	 * @param transactionType the IHE transaction type
	 * @param destination     the destination as String
	 * @param secure          true if it should be secure
	 * @param auditEnabled    true if audit is enabled
	 * @return the IPF/Camel endpoint string
	 */
	public static String createEndpoint(String transactionType, //
			String destination, //
			boolean secure, //
			boolean auditEnabled) //
	{
		String strippedUri = destination.replace(HTTPS_LITERAL, "").replace(HTTP_LITERAL, "");
		

		var endpoint = String.format(
				"%s://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s&httpClientPolicy=%s", //
				transactionType, //
				strippedUri, //
				SERVER_IN_LOGGER, //
				SERVER_IN_LOGGER, //
				SERVER_OUT_LOGGER, //
				SERVER_OUT_LOGGER, //
				secure, //
				auditEnabled, //
				AUDIT_CONTEXT, //
				HTTP_CLIENT_POLICY);
		return endpoint;
	}
}
