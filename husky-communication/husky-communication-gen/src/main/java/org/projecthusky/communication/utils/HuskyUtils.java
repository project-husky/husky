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
	// &httpClientPolicy=#myHttpClientPolicy
	public static final String HTTP_CLIENT_POLICY = "#huskyHttpClientPolicy";
	public static final String HTTPS_LITERAL = "https://";
	public static final String HTTP_LITERAL = "http://";

	public static final String HPD_ITI_58 = "hpd-iti58";
	public static final String HPD_ITI_59 = "hpd-iti59";
	public static final String PDQV3_ITI47 = "pdqv3-iti47";
	public static final String PIXV3_ITI44 = "pixv3-iti44";
	public static final String PIXV3_ITI45 = "pixv3-iti45";
	public static final String XDS_ITI18 = "xds-iti18";
	public static final String XDS_ITI43 = "xds-iti43";
	public static final String XDS_ITI41 = "xds-iti41";
	public static final String CH_PPQ1 = "ch-ppq1";
	public static final String CH_PPQ2 = "ch-ppq2";

//	"xds-iti18://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s&httpClientPolicy=%s"
//	"xds-iti43://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s&httpClientPolicy=%s"
//	"xds-iti41://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s&httpClientPolicy=%s"
//	"pixv3-iti44://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s&httpClientPolicy=%s"
//	"pixv3-iti45://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s&httpClientPolicy=%s"
//	"pdqv3-iti47://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s&httpClientPolicy=%s"
//	"pdqv3-iti47://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s&httpClientPolicy=%s&defaultContinuationThreshold=50&supportContinuation=%s"
//	"ch-ppq1://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s&httpClientPolicy=%s"
//	"ch-ppq2://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=#auditContext&httpClientPolicy=%s"
//	"hpd-iti58://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s&httpClientPolicy=%s";
//	"hpd-iti59://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s&httpClientPolicy=%s"
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
		final String strippedUri = destination.replace(HTTPS_LITERAL, "").replace(HTTP_LITERAL, "");
		

		final var endpoint = String.format(
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
