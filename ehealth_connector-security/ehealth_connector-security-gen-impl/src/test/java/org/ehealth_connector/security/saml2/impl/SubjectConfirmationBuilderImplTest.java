/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.security.saml2.impl;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.ehealth_connector.security.saml2.SubjectConfirmation;
import org.ehealth_connector.security.saml2.SubjectConfirmationBuilder;
import org.junit.Before;
import org.junit.Test;

public class SubjectConfirmationBuilderImplTest {

	private SubjectConfirmationBuilder builder;
	private String testMethod;
	private String testInResponseTO;
	private Calendar testNotOnOrAfter;
	private Calendar testNotBefore;
	private String testAddress;
	private String testRecepient;
	private org.opensaml.saml.saml2.core.SubjectConfirmation testInternalObject;

	@Before
	public void setUp() throws Exception {
		builder = new SubjectConfirmationBuilderImpl();

		testMethod = "A Shitty method";
		testInResponseTO = "This is the Response to";

		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -120);
		testNotOnOrAfter = (Calendar) cal.clone();

		cal.add(Calendar.DAY_OF_YEAR, 66);
		testNotBefore = (Calendar) cal.clone();

		testAddress = "http://my.address.ch/test/it/now";

		testRecepient = "The Recepient of";

		testInternalObject = new org.opensaml.saml.saml2.core.impl.SubjectConfirmationBuilder()
				.buildObject();
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.saml2.impl.SubjectConfirmationBuilderImpl#address(java.lang.String)}.
	 */
	@Test
	public void testAddress() {
		final SubjectConfirmation ref = builder.address(testAddress).create();
		assertEquals(testAddress, ref.getAddress());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.saml2.impl.SubjectConfirmationBuilderImpl#create(org.opensaml.saml.saml2.core.SubjectConfirmation)}.
	 */
	@Test
	public void testCreateSubjectConfirmation() {
		final SubjectConfirmation ref = ((SubjectConfirmationBuilderImpl) builder)
				.create(testInternalObject);
		assertEquals(testInternalObject, ((SubjectConfirmationImpl) ref).getWrappedObject());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.saml2.impl.SubjectConfirmationBuilderImpl#inResponseTo(java.lang.String)}.
	 */
	@Test
	public void testInResponseTo() {
		final SubjectConfirmation ref = builder.inResponseTo(testInResponseTO).create();
		assertEquals(testInResponseTO, ref.getInResponseTo());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.saml2.impl.SubjectConfirmationBuilderImpl#method(java.lang.String)}.
	 */
	@Test
	public void testMethod() {
		final SubjectConfirmation ref = builder.method(testMethod).create();
		assertEquals(testMethod, ref.getMethod());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.saml2.impl.SubjectConfirmationBuilderImpl#notBefore(java.util.Calendar)}.
	 */
	@Test
	public void testNotBefore() {
		final SubjectConfirmation ref = builder.notBefore(testNotBefore).create();
		assertEquals(testNotBefore, ref.getNotBefore());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.saml2.impl.SubjectConfirmationBuilderImpl#notOnOrAfter(java.util.Calendar)}.
	 */
	@Test
	public void testNotOnOrAfter() {
		final SubjectConfirmation ref = builder.notOnOrAfter(testNotOnOrAfter).create();
		assertEquals(testNotOnOrAfter, ref.getNotOnOrAfter());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.saml2.impl.SubjectConfirmationBuilderImpl#recipient(java.lang.String)}.
	 */
	@Test
	public void testRecipient() {
		final SubjectConfirmation ref = builder.recipient(testRecepient).create();
		assertEquals(testRecepient, ref.getRecipient());
	}

}
