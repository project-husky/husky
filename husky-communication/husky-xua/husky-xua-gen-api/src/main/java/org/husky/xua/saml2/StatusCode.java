/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.husky.xua.saml2;

/**
 * <!-- @formatter:off -->
 * <div class="en">Enumeration of the possible StatusCodes</div>
 * <div class="de">Enumerierung der möglichen StatusCodes</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 *
 */
public enum StatusCode {

	/** URI for AuthnFailed status code. */
	AUTHN_FAILED("urn:oasis:names:tc:SAML:2.0:status:AuthnFailed"),

	/** URI for InvalidAttrNameOrValue status code. */
	INVALID_ATTR_NAME_OR_VALUE("urn:oasis:names:tc:SAML:2.0:status:InvalidAttrNameOrValue"),

	/** URI for InvalidNameIDPolicy status code. */
	INVALID_NAMEID_POLICY("urn:oasis:names:tc:SAML:2.0:status:InvalidNameIDPolicy"),

	/** URI for NoAuthnContext status code. */
	NO_AUTHN_CONTEXT("urn:oasis:names:tc:SAML:2.0:status:NoAuthnContext"),

	/** URI for NoAvailableIDP status code. */
	NO_AVAILABLE_IDP("urn:oasis:names:tc:SAML:2.0:status:NoAvailableIDP"),

	/** URI for NoPassive status code. */
	NO_PASSIVE("urn:oasis:names:tc:SAML:2.0:status:NoPassive"),

	/** URI for NoSupportedIDP status code. */
	NO_SUPPORTED_IDP("urn:oasis:names:tc:SAML:2.0:status:NoSupportedIDP"),

	/** URI for PartialLogout status code. */
	PARTIAL_LOGOUT("urn:oasis:names:tc:SAML:2.0:status:PartialLogout"),

	/** URI for ProxyCountExceeded status code. */
	PROXY_COUNT_EXCEEDED("urn:oasis:names:tc:SAML:2.0:status:ProxyCountExceeded"),

	/** URI for RequestDenied status code. */
	REQUEST_DENIED("urn:oasis:names:tc:SAML:2.0:status:RequestDenied"),

	/** URI for RequestUnsupported status code. */
	REQUEST_UNSUPPORTED("urn:oasis:names:tc:SAML:2.0:status:RequestUnsupported"),

	/** URI for RequestVersionDeprecated status code. */
	REQUEST_VERSION_DEPRECATED("urn:oasis:names:tc:SAML:2.0:status:RequestVersionDeprecated"),

	/** URI for RequestVersionTooHigh status code. */
	REQUEST_VERSION_TOO_HIGH("urn:oasis:names:tc:SAML:2.0:status:RequestVersionTooHigh"),

	/** URI for RequestVersionTooLow status code. */
	REQUEST_VERSION_TOO_LOW("urn:oasis:names:tc:SAML:2.0:status:RequestVersionTooLow"),

	/** URI for Requester status code. */
	REQUESTER("urn:oasis:names:tc:SAML:2.0:status:Requester"),

	/** URI for ResourceNotRecognized status code. */
	RESOURCE_NOT_RECOGNIZED("urn:oasis:names:tc:SAML:2.0:status:ResourceNotRecognized"),

	/** URI for Responder status code. */
	RESPONDER("urn:oasis:names:tc:SAML:2.0:status:Responder"),

	/** URI for Success status code. */
	SUCCESS("urn:oasis:names:tc:SAML:2.0:status:Success"),

	/** URI for TooManyResponses status code. */
	TOO_MANY_RESPONSES("urn:oasis:names:tc:SAML:2.0:status:TooManyResponses"),

	/** URI for UnknownAttrProfile status code. */
	UNKNOWN_ATTR_PROFILE("urn:oasis:names:tc:SAML:2.0:status:UnknownAttrProfile"),

	/** URI for UnknownPrincipal status code. */
	UNKNOWN_PRINCIPAL("urn:oasis:names:tc:SAML:2.0:status:UnknownPrincipal"),

	/** URI for UnsupportedBinding status code. */
	UNSUPPORTED_BINDING("urn:oasis:names:tc:SAML:2.0:status:UnsupportedBinding"),

	/** URI for VersionMismatch status code. */
	VERSION_MISMATCH("urn:oasis:names:tc:SAML:2.0:status:VersionMismatch");

	/**
	 * Gets the enum.
	 *
	 * @param code
	 *            the code
	 * @return the enum
	 */
	public static StatusCode getEnum(String code) {
		for (final StatusCode x : values()) {
			if (x.toString().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/** The status code. */
	private String code;

	/**
	 * Instantiates a new status code.
	 *
	 * @param aCode
	 *            the a code
	 */
	StatusCode(String aCode) {
		this.code = aCode;
	}

	@Override
	public String toString() {
		return code;
	}
}
