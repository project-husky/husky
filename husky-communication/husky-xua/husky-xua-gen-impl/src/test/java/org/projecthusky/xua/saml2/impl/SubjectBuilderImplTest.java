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
package org.projecthusky.xua.saml2.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.NameIDType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectConfirmationType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectType;

class SubjectBuilderImplTest {

	private SubjectBuilderImpl builder;
	private String testAddress;
	private org.opensaml.saml.saml2.core.Subject testInnerObject;
	private String testNameIdFormat;
	private String testNameIdValue;
	private SubjectConfirmationType testSubjectConfirm;
	private List<SubjectConfirmationType> testSubjectConfirmations;
	private String testNameIDNameQualifier;

	@BeforeEach
	public void setUp() throws Exception {
		builder = new SubjectBuilderImpl();

		testInnerObject = new org.opensaml.saml.saml2.core.impl.SubjectBuilder().buildObject();
		final org.opensaml.saml.saml2.core.NameID nameID = new org.opensaml.saml.saml2.core.impl.NameIDBuilder()
				.buildObject();

		testNameIdValue = UUID.randomUUID().toString();
		nameID.setValue(testNameIdValue);
		testInnerObject.setNameID(nameID);

		testNameIdFormat = "MyFormat for nameId";

		testNameIDNameQualifier = "urn:gs1:gln";

		testAddress = "http://my.address.ch/test/it/now";

		testSubjectConfirmations = new ArrayList<>();
		testSubjectConfirm = new SubjectConfirmationBuilderImpl().address(testAddress).create();
		testSubjectConfirmations.add(testSubjectConfirm);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.saml2.impl.SubjectBuilderImpl#addSubjectConfirmations(org.projecthusky.xua.saml2.SubjectConfirmation)}.
	 */
	@Test
	void testAddSubjectConfirmations() {
		final SubjectType ref = builder.addSubjectConfirmations(testSubjectConfirm).create();
		assertEquals(testSubjectConfirm.getSubjectConfirmationData().getAddress(),
				extractSubjectConfirmationTypeFromJaxbElements(ref).get(0).getSubjectConfirmationData().getAddress());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.saml2.impl.SubjectBuilderImpl#create(org.opensaml.saml.saml2.core.Subject)}.
	 */
	@Test
	void testCreateSubject() {
		final SubjectType ref = builder.create(testInnerObject);
		assertEquals(testInnerObject, ((SubjectImpl) ref).getWrappedObject());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.saml2.impl.SubjectBuilderImpl#nameIDFormat(java.lang.String)}.
	 */
	@Test
	void testNameIDFormat() {
		final SubjectType ref = builder.nameIDFormat(testNameIdFormat).create();
		assertEquals(testNameIdFormat, extractNameIDTypeFromJaxbElements(ref).getFormat());
	}

	@Test
	void testNameIDNameQualifier() {
		final SubjectType ref = builder.nameIDNameQualifier(testNameIDNameQualifier).create();
		assertEquals(testNameIDNameQualifier, extractNameIDTypeFromJaxbElements(ref).getNameQualifier());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.saml2.impl.SubjectBuilderImpl#nameIDValue(java.lang.String)}.
	 */
	@Test
	void testNameIDValue() {
		final SubjectType ref = builder.nameIDValue(testNameIdValue).create();
		assertEquals(testNameIdValue, extractNameIDTypeFromJaxbElements(ref).getValue());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.saml2.impl.SubjectBuilderImpl#subjectConfirmations(java.util.List)}.
	 */
	@Test
	void testSubjectConfirmations() {
		final SubjectType ref = builder.subjectConfirmations(testSubjectConfirmations).create();
		assertArrayEquals(
				testSubjectConfirmations
						.toArray(new SubjectConfirmationType[testSubjectConfirmations.size()]),
				extractSubjectConfirmationTypeFromJaxbElements(ref)
						.toArray(new SubjectConfirmationType[testSubjectConfirmations.size()]));
	}
	
	private NameIDType extractNameIDTypeFromJaxbElements(SubjectType ref) {
		for(JAXBElement<?> element: ref.getContent()) {
			if(element != null && element.getValue() instanceof NameIDType) {
				return (NameIDType) element.getValue();
			}
		}
		
		return null;
	}
	
	private List<SubjectConfirmationType> extractSubjectConfirmationTypeFromJaxbElements(SubjectType ref) {
		List<SubjectConfirmationType> retVal = new LinkedList<>();
		for(JAXBElement<?> element: ref.getContent()) {
			if(element != null && element.getValue() instanceof SubjectConfirmationType) {
				retVal.add((SubjectConfirmationType) element.getValue());
			}
		}
		
		return retVal;
	}

}
