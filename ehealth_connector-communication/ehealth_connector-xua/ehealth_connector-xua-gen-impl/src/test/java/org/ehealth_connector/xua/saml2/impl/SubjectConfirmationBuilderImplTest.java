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
package org.ehealth_connector.xua.saml2.impl;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.ehealth_connector.xua.saml2.SubjectConfirmation;
import org.ehealth_connector.xua.saml2.SubjectConfirmationBuilder;
import org.ehealth_connector.xua.saml2.impl.SubjectConfirmationBuilderImpl;
import org.ehealth_connector.xua.saml2.impl.SubjectConfirmationImpl;
import org.junit.Before;
import org.junit.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectConfirmationType;

public class SubjectConfirmationBuilderImplTest {

	private SubjectConfirmationBuilder builder;
	private String testAddress;
	private String testInResponseTO;
	private org.opensaml.saml.saml2.core.SubjectConfirmation testInternalObject;
	private String testMethod;
	private GregorianCalendar testNotBefore;
	private GregorianCalendar testNotOnOrAfter;
	private String testRecepient;

	@Before
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
	 * {@link org.ehealth_connector.xua.saml2.impl.SubjectConfirmationBuilderImpl#address(java.lang.String)}.
	 */
	@Test
	public void testAddress() {
		final SubjectConfirmationType ref = builder.address(testAddress).create();
		assertEquals(testAddress, ref.getSubjectConfirmationData().getAddress());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.saml2.impl.SubjectConfirmationBuilderImpl#create(org.opensaml.saml.saml2.core.SubjectConfirmation)}.
	 */
	@Test
	public void testCreateSubjectConfirmation() {
		final SubjectConfirmationType ref = ((SubjectConfirmationBuilderImpl) builder)
				.create(testInternalObject);
		assertEquals(testInternalObject, ((SubjectConfirmationImpl) ref).getWrappedObject());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.saml2.impl.SubjectConfirmationBuilderImpl#inResponseTo(java.lang.String)}.
	 */
	@Test
	public void testInResponseTo() {
		final SubjectConfirmationType ref = builder.inResponseTo(testInResponseTO).create();
		assertEquals(testInResponseTO, ref.getSubjectConfirmationData().getInResponseTo());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.saml2.impl.SubjectConfirmationBuilderImpl#method(java.lang.String)}.
	 */
	@Test
	public void testMethod() {
		final SubjectConfirmationType ref = builder.method(testMethod).create();
		assertEquals(testMethod, ref.getMethod());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.saml2.impl.SubjectConfirmationBuilderImpl#notBefore(java.util.Calendar)}.
	 */
	@Test
	public void testNotBefore() {
		final SubjectConfirmationType ref = builder.notBefore(testNotBefore).create();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmssZ");
		assertEquals(sdf.format(testNotBefore.getTime()), sdf.format(ref.getSubjectConfirmationData().getNotBefore().toGregorianCalendar().getTime()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.saml2.impl.SubjectConfirmationBuilderImpl#notOnOrAfter(java.util.Calendar)}.
	 */
	@Test
	public void testNotOnOrAfter() {
		final SubjectConfirmationType ref = builder.notOnOrAfter(testNotOnOrAfter).create();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmssZ");
		assertEquals(sdf.format(testNotOnOrAfter.getTime()), sdf.format(ref.getSubjectConfirmationData().getNotOnOrAfter().toGregorianCalendar().getTime()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.xua.saml2.impl.SubjectConfirmationBuilderImpl#recipient(java.lang.String)}.
	 */
	@Test
	public void testRecipient() {
		final SubjectConfirmationType ref = builder.recipient(testRecepient).create();
		assertEquals(testRecepient, ref.getSubjectConfirmationData().getRecipient());
	}

}
