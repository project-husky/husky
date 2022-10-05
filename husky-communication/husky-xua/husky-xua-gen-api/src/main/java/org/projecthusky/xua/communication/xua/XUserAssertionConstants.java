/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.xua.communication.xua;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class defining XUserAssertionConstants.</div>
 * <div class="de">Klasse welche XUserAssertionConstanten definiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class XUserAssertionConstants {

	/** SAML V2.0 ws profile 1.1 */
	public static final String OASIS_WSS_SAML_PROFILE_11_SAMLV20 = "http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0";

	/** XSPA subject organization */
	public static final String OASIS_XACML_ORGANISATION = "urn:oasis:names:tc:xspa:1.0:subject:organization";

	/** XSPA subject organization-id */
	public static final String OASIS_XACML_ORGANIZATIONID = "urn:oasis:names:tc:xspa:1.0:subject:organization-id";

	/** XSPA subject purposeofuse */
	public static final String OASIS_XACML_PURPOSEOFUSE = "urn:oasis:names:tc:xspa:1.0:subject:purposeofuse";

	/** XACML resource resource-id string */
	public static final String OASIS_XACML_RESOURCEID = "urn:oasis:names:tc:xacml:2.0:resource:resource-id";

	/** XACML subject role string */
	public static final String OASIS_XACML_ROLE = "urn:oasis:names:tc:xacml:2.0:subject:role";

	/** XSPA subject subject-id string */
	public static final String OASIS_XACML_SUBJECTID = "urn:oasis:names:tc:xspa:1.0:subject:subject-id";

	/** IHE ITI XCA home-community-id  */
	public static final String IHE_XCA_HOMECOMMUNITYID = "urn:ihe:iti:xca:2010:homeCommunityId";
	
	private XUserAssertionConstants() {
		 throw new IllegalStateException("Constants class");
	}

}
