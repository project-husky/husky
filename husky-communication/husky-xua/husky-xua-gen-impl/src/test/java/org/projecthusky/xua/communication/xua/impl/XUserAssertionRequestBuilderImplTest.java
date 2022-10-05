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
package org.projecthusky.xua.communication.xua.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.projecthusky.xua.communication.xua.AppliesTo;
import org.projecthusky.xua.communication.xua.RequestType;
import org.projecthusky.xua.communication.xua.TokenType;
import org.projecthusky.xua.communication.xua.XUserAssertionRequest;
import org.projecthusky.xua.hl7v3.CE;
import org.projecthusky.xua.hl7v3.PurposeOfUse;
import org.projecthusky.xua.hl7v3.Role;
import org.projecthusky.xua.hl7v3.impl.CodedWithEquivalentsBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.soap.wstrust.RequestSecurityToken;
import org.opensaml.soap.wstrust.impl.RequestSecurityTokenBuilder;

class XUserAssertionRequestBuilderImplTest {

	private XUserAssertionRequestBuilderImpl builder;
	private String testAddress;
	private AppliesTo testAppliesTo;
	private String testContext;
	private String testDialect;
	private RequestSecurityToken testInternalFromOutside;
	private String testOrganizationId;
	private String testOrganizationName;
	private String testPoUCode;
	private String testPoUCodeSystem;
	private String testPoUCodeSystemName;
	private String testPoUDisplayName;
	private CE testPurposeOfUse;
	private String testResourceId;
	private CE testRole;
	private String testSubjectId;
	private String testSubjectName;
	private String testRoleCode;
	private String testRoleCodeSystem;
	private String testRoleCodeSystemName;
	private String testRoleDisplayName;

	@BeforeEach
	public void setUp() throws Exception {
		builder = new XUserAssertionRequestBuilderImpl();
		testDialect = "http://bag.admin.ch/epr/2017/annex/5/addendum/2";
		testContext = "This is my Context";
		testSubjectId = UUID.randomUUID().toString();
		testSubjectName = "Harry Hirsch";
		testOrganizationId = UUID.randomUUID().toString();
		testOrganizationName = "My Best organisation";
		testResourceId = UUID.randomUUID().toString();

		testRole = new CodedWithEquivalentsBuilder().buildObject(Role.DEFAULT_NS_URI, Role.DEFAULT_ELEMENT_LOCAL_NAME,
				Role.DEFAULT_PREFIX);

		testRoleCode = "HCP";
		testRoleCodeSystem = "2.16.756.5.30.1.127.3.10.6";
		testRoleCodeSystemName = "eHealth Suisse EPR Akteure";
		testRoleDisplayName = "Behandelnde(r)";
		testRole.setCode(testRoleCode);
		testRole.setCodeSystem(testRoleCodeSystem);
		testRole.setCodeSystemName(testRoleCodeSystemName);
		testRole.setDisplayName(testRoleDisplayName);

		testInternalFromOutside = new RequestSecurityTokenBuilder().buildObject();
		testInternalFromOutside.setContext(testContext);

		testAddress = "https://guguseli.org/test/access/endpoint/address";
		testAppliesTo = new AppliesToBuilderImpl().address(testAddress).create();

		testPurposeOfUse = new CodedWithEquivalentsBuilder().buildObject(PurposeOfUse.DEFAULT_NS_URI,
				PurposeOfUse.DEFAULT_ELEMENT_LOCAL_NAME, PurposeOfUse.DEFAULT_PREFIX);
		testPoUCode = "987654321";
		testPoUCodeSystem = "1.2.3.4.5.6.7.8.9.0";
		testPoUCodeSystemName = "My Code System";
		testPoUDisplayName = "The Ultimative Test Code";

		testPurposeOfUse.setCode(testPoUCode);
		testPurposeOfUse.setCodeSystem(testPoUCodeSystem);
		testPurposeOfUse.setCodeSystemName(testPoUCodeSystemName);
		testPurposeOfUse.setDisplayName(testPoUDisplayName);
	}

	@Test
	void testAppliesTo() {
		final XUserAssertionRequest ref = builder.appliesTo(testAppliesTo).create();
		assertNotNull(ref);
		assertEquals(testAppliesTo.getAddress(), ref.getAppliesTo().getAddress());
	}

	@Test
	void testContext() {
		final XUserAssertionRequest ref = builder.context(testContext).create();
		assertNotNull(ref);
		assertEquals(testContext, ref.getContext());
	}

	@Test
	void testCreateRequestSecurityToken() {
		final XUserAssertionRequest ref = builder.create(testInternalFromOutside);
		assertNotNull(ref);
		assertEquals(testInternalFromOutside, ((XUserAssertionRequestImpl) ref).getWrappedObject());
		assertEquals(testContext, ref.getContext());
	}

	@Test
	void testDialect() {
		final XUserAssertionRequest ref = builder.dialect(testDialect).create();
		assertNotNull(ref);
		assertEquals(testDialect, ref.getDialect());
	}

	@Test
	void testOrganizationId() {
		final XUserAssertionRequest ref = builder.organizationId(testOrganizationId).create();
		assertNotNull(ref);
		assertEquals(testOrganizationId, ref.getOrganizationId());
	}

	@Test
	void testOrganizationName() {
		final XUserAssertionRequest ref = builder.organizationName(testOrganizationName).create();
		assertNotNull(ref);
		assertEquals(testOrganizationName, ref.getOrganizationName());
	}

	@Test
	void testPurposeOfUse() {
		final XUserAssertionRequest ref = builder.purposeOfUse(testPurposeOfUse).create();
		assertNotNull(ref);
		assertEquals(testPurposeOfUse, ref.getPurposeOfUse());
	}

	@Test
	void testRequestType() {
		final XUserAssertionRequest ref = builder.requestType(RequestType.WST_ISSUE).create();
		assertNotNull(ref);
		assertEquals(RequestType.WST_ISSUE, ref.getRequestType());
	}

	@Test
	void testResourceId() {
		final XUserAssertionRequest ref = builder.resourceId(testResourceId).create();
		assertNotNull(ref);
		assertEquals(testResourceId, ref.getResourceId());
	}

	@Test
	void testSubjectId() {
		final XUserAssertionRequest ref = builder.subjectId(testSubjectId).create();
		assertNotNull(ref);
		assertEquals(testSubjectId, ref.getSubjectId());
	}

	@Test
	void testSubjectName() {
		final XUserAssertionRequest ref = builder.subjectName(testSubjectName).create();
		assertNotNull(ref);
		assertEquals(testSubjectName, ref.getSubjectName());
	}

	@Test
	void testSubjectRole() {
		final XUserAssertionRequest ref = builder.subjectRole(testRole).create();
		assertNotNull(ref);
		assertEquals(testRole, ref.getSubjectRole());
	}

	@Test
	void testTokenType() {
		final XUserAssertionRequest ref = builder
				.tokenType(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20).create();
		assertNotNull(ref);
		assertEquals(TokenType.OASIS_WSS_SAML_PROFILE_11_SAMLV20, ref.getTokenType());
	}

}
