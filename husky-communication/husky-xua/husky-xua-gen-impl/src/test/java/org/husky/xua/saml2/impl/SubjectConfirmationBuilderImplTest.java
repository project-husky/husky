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
package org.husky.xua.saml2.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.husky.xua.saml2.SubjectConfirmationBuilder;
import org.husky.xua.saml2.impl.SubjectConfirmationBuilderImpl;
import org.husky.xua.saml2.impl.SubjectConfirmationImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectConfirmationType;

class SubjectConfirmationBuilderImplTest {

	private SubjectConfirmationBuilder builder;
	private String testAddress;
	private String testInResponseTO;
	private org.opensaml.saml.saml2.core.SubjectConfirmation testInternalObject;
	private String testMethod;
	private GregorianCalendar testNotBefore;
	private GregorianCalendar testNotOnOrAfter;
	private String testRecepient;

	@BeforeEach
	public void setUp() throws Exception {
		builder = new SubjectConfirmationBuilderImpl();

		testMethod = "A Shitty method";
		testInResponseTO = "This is the Response to";

		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -120);
		testNotOnOrAfter = (GregorianCalendar) cal.clone();

		cal.add(Calendar.DAY_OF_YEAR, 66);
		testNotBefore = (GregorianCalendar) cal.clone();

		testAddress = "http://my.address.ch/test/it/now";

		testRecepient = "The Recepient of";

		testInternalObject = new org.opensaml.saml.saml2.core.impl.SubjectConfirmationBuilder()
				.buildObject();
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.SubjectConfirmationBuilderImpl#address(java.lang.String)}.
	 */
	@Test
	void testAddress() {
		final SubjectConfirmationType ref = builder.address(testAddress).create();
		assertEquals(testAddress, ref.getSubjectConfirmationData().getAddress());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.SubjectConfirmationBuilderImpl#create(org.opensaml.saml.saml2.core.SubjectConfirmation)}.
	 */
	@Test
	void testCreateSubjectConfirmation() {
		final SubjectConfirmationType ref = ((SubjectConfirmationBuilderImpl) builder)
				.create(testInternalObject);
		assertEquals(testInternalObject, ((SubjectConfirmationImpl) ref).getWrappedObject());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.SubjectConfirmationBuilderImpl#inResponseTo(java.lang.String)}.
	 */
	@Test
	void testInResponseTo() {
		final SubjectConfirmationType ref = builder.inResponseTo(testInResponseTO).create();
		assertEquals(testInResponseTO, ref.getSubjectConfirmationData().getInResponseTo());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.SubjectConfirmationBuilderImpl#method(java.lang.String)}.
	 */
	@Test
	void testMethod() {
		final SubjectConfirmationType ref = builder.method(testMethod).create();
		assertEquals(testMethod, ref.getMethod());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.SubjectConfirmationBuilderImpl#notBefore(java.util.Calendar)}.
	 */
	@Test
	void testNotBefore() {
		final SubjectConfirmationType ref = builder.notBefore(testNotBefore).create();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmssZ");
		assertEquals(sdf.format(testNotBefore.getTime()), sdf.format(ref.getSubjectConfirmationData().getNotBefore().toGregorianCalendar().getTime()));
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.SubjectConfirmationBuilderImpl#notOnOrAfter(java.util.Calendar)}.
	 */
	@Test
	void testNotOnOrAfter() {
		final SubjectConfirmationType ref = builder.notOnOrAfter(testNotOnOrAfter).create();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmssZ");
		assertEquals(sdf.format(testNotOnOrAfter.getTime()), sdf.format(ref.getSubjectConfirmationData().getNotOnOrAfter().toGregorianCalendar().getTime()));
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.saml2.impl.SubjectConfirmationBuilderImpl#recipient(java.lang.String)}.
	 */
	@Test
	void testRecipient() {
		final SubjectConfirmationType ref = builder.recipient(testRecepient).create();
		assertEquals(testRecepient, ref.getSubjectConfirmationData().getRecipient());
	}

}
