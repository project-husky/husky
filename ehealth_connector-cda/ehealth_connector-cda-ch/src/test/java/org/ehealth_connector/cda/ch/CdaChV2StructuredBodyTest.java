/*
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
package org.ehealth_connector.cda.ch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.DataEnterer;
import org.ehealth_connector.cda.Section;
import org.ehealth_connector.cda.ch.lab.lrep.CdaChLrepV1GeneralReport;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.common.ch.enums.ConfidentialityCode;
import org.ehealth_connector.common.mdht.Author;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.Name;
import org.ehealth_connector.common.mdht.Organization;
import org.ehealth_connector.common.mdht.Patient;
import org.ehealth_connector.common.mdht.Person;
import org.ehealth_connector.common.mdht.enums.AdministrativeGender;
import org.ehealth_connector.common.mdht.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ParticipantType;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.ch.ChFactory;

/**
 * Unit Tests for Class CdaChV2StructuredBody.
 */
public class CdaChV2StructuredBodyTest {

	/** The name of the class under test. */
	private String cutName = "CdaChV2StructuredBody";

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.AbstractCda#addAuthenticator(org.openhealthtools.mdht.uml.cda.Authenticator)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getAuthenticators()} and
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#addAuthenticator(org.ehealth_connector.common.mdht.Author)}
	 * and
	 * {@link org.ehealth_connector.cda.AbstractCda#addAuthenticator(org.ehealth_connector.common.mdht.Person, java.util.Date)}
	 * and
	 * {@link org.ehealth_connector.cda.AbstractCda#getAuthenticatorsAsAuthor()}.
	 *
	 */
	@Test
	public void testAddGetAuthenticator() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		Name name1 = new Name("John", "Doe");
		Name name2 = new Name("Max", "Muster");

		Author author1 = new Author(name1);
		Author author2 = new Author(name2);

		cda.addAuthenticator(author1);
		cda.addAuthenticator(author2);

		List<Person> AuthenticatorList = cda.getAuthenticators();

		assertTrue(
				AuthenticatorList.get(0).getName().getFamilyName().equals(name1.getFamilyName()));
		assertTrue(AuthenticatorList.get(1).getName().getAllGivenNames()
				.equals(name2.getAllGivenNames()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#addAuthor(org.ehealth_connector.common.mdht.Author)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getAuthor()} and
	 * {@link org.ehealth_connector.cda.AbstractCda#getAuthors()}.
	 */
	@Test
	public void testAddGetAuthor() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");

		Name name1 = new Name("John", "Doe");
		Name name2 = new Name("Max", "Muster");

		cda.addAuthor(new Author(name1));
		cda.addAuthor(new Author(name2));

		List<Author> authorList = cda.getAuthors();

		assertTrue(authorList.get(0).getName().getFamilyName().equals(name1.getFamilyName()));
		assertTrue(authorList.get(1).getName().getAllGivenNames().equals(name2.getAllGivenNames()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.AbstractCda#addAuthorizationConsent(java.lang.String)}
	 * and
	 * {@link org.ehealth_connector.cda.AbstractCda#getAuthorizationConsents()}.
	 */
	@Test
	public void testAddGetAuthorizationConsent() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		cda.addAuthorizationConsent("consent1");
		cda.addAuthorizationConsent("consent2");

		List<String> consentList = cda.getAuthorizationConsents();
		assertTrue(consentList.get(0).equals("consent1"));
		assertTrue(consentList.get(1).equals("consent2"));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.AbstractCda#addEmployer(org.ehealth_connector.common.mdht.Organization, org.ehealth_connector.common.mdht.Identificator)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getEmployers()}.
	 */
	@Test
	public void testAddGetEmployer() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		Name name1 = new Name("org1");
		Name name2 = new Name("org2");

		Identificator id1 = new Identificator("2.999", "myId1");
		Identificator id2 = new Identificator("2.999", "myId2");

		cda.addEmployer(new Organization(name1), id1);
		cda.addEmployer(new Organization(name2), id2);

		List<Organization> recipientsList = cda.getEmployers();

		assertTrue(recipientsList.get(0).getCompleteName().equals(name1.getCompleteName()));
		assertTrue(recipientsList.get(1).getName().equals(name2.getName()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.AbstractCda#addInFulfillmentOfOrder(org.ehealth_connector.common.mdht.Identificator)}
	 * and
	 * {@link org.ehealth_connector.cda.AbstractCda#getInFulfillmentOfOrders()}.
	 */
	@Test
	public void testAddGetInFulfillmentOfOrder() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");

		Identificator id1 = new Identificator("2.999", "myId1");
		Identificator id2 = new Identificator("2.999", "myId2");

		cda.addInFulfillmentOfOrder(id1);
		cda.addInFulfillmentOfOrder(id2);

		List<Identificator> orderList = cda.getInFulfillmentOfOrders();

		assertTrue(orderList.get(0).equals(id1));
		assertTrue(orderList.get(1).equals(id2));

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.AbstractCda#addInsurance(org.ehealth_connector.common.mdht.Organization, org.ehealth_connector.common.mdht.Identificator)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getInsurances()} and
	 * {@link org.ehealth_connector.cda.AbstractCda#getParticipants()}.
	 */
	@Test
	public void testAddGetInsurance() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		Name name1 = new Name("org1");
		Name name2 = new Name("org2");

		Identificator id1 = new Identificator("2.999", "myId1");
		Identificator id2 = new Identificator("2.999", "myId2");

		cda.addInsurance(new Organization(name1), id1);
		cda.addInsurance(new Organization(name2), id2);

		List<Organization> recipientsList = cda.getInsurances();

		assertTrue(recipientsList.get(0).getCompleteName().equals(name1.getCompleteName()));
		assertTrue(recipientsList.get(1).getName().equals(name2.getName()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.AbstractCda#addOtherRecipient(org.ehealth_connector.common.mdht.Organization)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getOtherRecipients()}.
	 */
	@Test
	public void testAddGetOtherRecipient() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		Name name1 = new Name("org1");
		Name name2 = new Name("org2");
		cda.addOtherRecipient(new Organization(name1));
		cda.addOtherRecipient(new Organization(name2));

		List<Organization> recipientsList = cda.getOtherRecipients();

		assertTrue(recipientsList.get(0).getCompleteName().equals(name1.getCompleteName()));
		assertTrue(recipientsList.get(1).getName().equals(name2.getName()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.AbstractCda#addParticipant(org.ehealth_connector.common.mdht.Organization, org.ehealth_connector.common.mdht.Identificator, org.ehealth_connector.common.mdht.enums.ParticipantType)}
	 * and
	 * {@link org.ehealth_connector.cda.AbstractCda#addParticipant(org.ehealth_connector.common.mdht.Organization, org.ehealth_connector.common.mdht.Identificator, org.ehealth_connector.common.mdht.enums.ParticipantType, org.ehealth_connector.common.mdht.Code)}
	 * end TODO.
	 */
	@Test
	public void testAddGetParticipant() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		Name name1 = new Name("org1");
		Name name2 = new Name("org2");

		Identificator id1 = new Identificator("2.999", "myId1");
		Identificator id2 = new Identificator("2.999", "myId2");

		cda.addParticipant(new Organization(name1), id1, ParticipantType.Insurance);
		cda.addParticipant(new Organization(name2), id2, ParticipantType.Employer);

		List<Organization> recipientsList = cda.getParticipants();

		assertTrue(recipientsList.get(0).getCompleteName().equals(name1.getCompleteName()));
		assertTrue(recipientsList.get(1).getName().equals(name2.getName()));
		assertTrue(cda.getInsurances().get(0).getCompleteName().equals(name1.getCompleteName()));
		assertTrue(cda.getEmployers().get(0).getCompleteName().equals(name2.getCompleteName()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#setOriginalRepresentationSection(byte[])}
	 * and
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#getSections()}
	 * and
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#addNarrativeTextSection(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddGetSection() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		cda.addNarrativeTextSection("section1", "text1");
		cda.addNarrativeTextSection("section2", "text2");

		List<Section> sections = cda.getSections();

		assertTrue(sections.get(0).getTitle().equals("section1"));
		assertTrue(sections.get(1).getTitle().equals("section2"));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.MdhtFacade#addTemplateIdOnce(org.ehealth_connector.common.mdht.Identificator)}
	 * and {@link org.ehealth_connector.cda.MdhtFacade#getTemplateIds()}.
	 */
	@Test
	public void testAddGetTemplateId() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		Identificator id1 = new Identificator("2.999.1");
		Identificator id2 = new Identificator("2.999.2");

		boolean id1Found = false;
		boolean id2Found = false;

		cda.addTemplateId(id1);
		cda.addTemplateId(id2);

		for (Identificator id : cda.getTemplateIds()) {
			assertNull("Extensions not allowd for template ids", id.getExtension());
			if (id1.getRoot().equals(id.getRoot()))
				id1Found = true;
			if (id2.getRoot().equals(id.getRoot()))
				id2Found = true;
		}

		assertTrue(id1Found);
		assertTrue(id2Found);

	}

	/**
	 * Test method for templateIDs in this CDA element
	 */
	@Test
	public void testCheckTemplateIds() {
		String idCdaChV2SbEnhanced = "2.16.756.5.30.1.1.10.1.14";
		boolean idFoundCdaChV2SbEnhanced = false;
		String idCdaChV2Sb = "2.16.756.5.30.1.1.10.1.9";
		boolean idFoundCdaChV2Sb = false;
		String idHl7Cda = "2.16.840.1.113883.10.12.1";
		boolean idFoundHl7Cda = false;
		String idHl7CdaSb = "2.16.840.1.113883.10.12.2";
		boolean idFoundHl7CdaSb = false;

		CdaChLrepV1GeneralReport cda = new CdaChLrepV1GeneralReport(LanguageCode.GERMAN, "dummy",
				"dummy");

		for (Identificator id : cda.getTemplateIds()) {
			assertNull("Extensions not allowd for template ids", id.getExtension());
			if (idCdaChV2SbEnhanced.equals(id.getRoot()))
				idFoundCdaChV2SbEnhanced = true;
			if (idCdaChV2Sb.equals(id.getRoot()))
				idFoundCdaChV2Sb = true;
			if (idHl7Cda.equals(id.getRoot()))
				idFoundHl7Cda = true;
			if (idHl7CdaSb.equals(id.getRoot()))
				idFoundHl7CdaSb = true;
		}

		assertTrue(cutName
				+ " templateID defined by ART DECOR CDA-CH V2 Structured Body enhanced is missing",
				idFoundCdaChV2SbEnhanced);
		assertTrue(
				cutName + " templateID defined by ART DECOR CDA-CH V2 Structured Body is missing",
				idFoundCdaChV2Sb);
		assertTrue(cutName + " templateID defined by ART DECOR HL7 CDA R2 is missing",
				idFoundHl7Cda);
		assertTrue(
				cutName + " templateID defined by ART DECOR HL7 CDA R2 Structured Body is missing",
				idFoundHl7CdaSb);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.AbstractCda#saveToFile(java.lang.String)}.
	 *
	 * @throws Exception
	 */
	@Test
	public void testSerializationFile() throws Exception {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda1 = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		String fn = Util.getTempDirectory() + "/" + cutName + ".tmp";
		cda1.saveToFile(fn);

		CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda2 = CdaChUtil
				.loadCdaChV2FromFile(fn);

		assertTrue(cda1.getId().equals(cda2.getId()));

		// cleanup
		File file = new File(fn);
		if (!file.delete())
			file.deleteOnExit();

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#setConfidentialityCode(org.ehealth_connector.common.ch.enums.ConfidentialityCode)}
	 * and
	 * {@link org.ehealth_connector.cda.AbstractCda#getConfidentialityCode()}
	 * and
	 * {@link org.ehealth_connector.cda.AbstractCda#setConfidentialityCode(org.ehealth_connector.common.mdht.enums.ConfidentialityCode)}.
	 */
	@Test
	public void testSetGetConfidentialityCode() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		cda.setConfidentialityCode(ConfidentialityCode.SECRET);
		assertTrue(cda.getConfidentialityCodeCh().getCode()
				.equals(ConfidentialityCode.SECRET.getCode()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#setCustodian(org.ehealth_connector.common.mdht.Organization)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getCustodian()} and
	 * {@link org.ehealth_connector.cda.AbstractCda#getCustodianAsOrganization()}.
	 */
	@Test
	public void testSetGetCustodian() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		Name name1 = new Name("org1");
		cda.setCustodian(new Organization(name1));

		assertTrue(cda.getCustodian().getAssignedCustodian().getRepresentedCustodianOrganization()
				.getName().getText().equals(name1.getName()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#setDataEnterer(org.ehealth_connector.cda.DataEnterer)}
	 * and
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#setDataEnterer(org.ehealth_connector.common.mdht.Person)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getDataEnterer()} and
	 * {@link org.ehealth_connector.cda.AbstractCda#getDataEntererPerson()}.
	 */
	@Test
	public void testSetGetDataEntererDataEnterer() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");

		Name name = new Name("John", "Doe");
		cda.setDataEnterer(new DataEnterer(name));
		assertTrue(cda.getDataEnterer().getName().getCompleteName().equals(name.getCompleteName()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#setId(org.ehealth_connector.common.mdht.Identificator)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getId()}.
	 */
	@Test
	public void testSetGetId() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");

		Identificator id = new Identificator("2.999", "myId1");
		cda.setId(id);
		assertTrue(cda.getId().equals(id));

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.AbstractCda#setLanguageCode(org.ehealth_connector.common.mdht.enums.LanguageCode)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getLanguageCode()}.
	 */
	@Test
	public void testSetGetLanguageCode() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		cda.setLanguageCode(LanguageCode.ITALIAN);
		assertTrue(cda.getLanguageCode().getCode().getCode()
				.equals(LanguageCode.ITALIAN.getCode().getCode()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#setLegalAuthenticator(org.ehealth_connector.common.mdht.Author)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getLegalAuthenticator()}
	 * and
	 * {@link org.ehealth_connector.cda.AbstractCda#getLegalAuthenticatorAsAuthor()}.
	 */
	@Test
	public void testSetGetLegalAuthenticator() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		Name name = new Name("John", "Doe");
		cda.setLegalAuthenticator(new Author(name));
		assertTrue(cda.getLegalAuthenticator().getCompleteName().equals(name.getCompleteName()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#setPatient(org.ehealth_connector.common.mdht.Patient)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getPatient()}.
	 */
	@Test
	public void testSetGetPatient() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		Name name = new Name("John", "Doe");
		Date date = DateUtil.parseDateyyyyMMdd("20180722");
		cda.setPatient(new Patient(name, AdministrativeGender.MALE, date));
		Patient patient = cda.getPatient();
		assertTrue(patient.getCompleteName().equals(name.getCompleteName()));
		assertTrue(patient.getAdministrativeGenderCode().equals(AdministrativeGender.MALE));
		assertTrue(patient.getBirthday().equals(date));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#setPrimaryRecipient(org.ehealth_connector.common.mdht.Organization)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getPrimaryRecipient()}.
	 */
	@Test
	public void testSetGetPrimaryRecipient() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		Name name1 = new Name("org1");
		cda.setPrimaryRecipient(new Organization(name1));

		Organization recipient = cda.getPrimaryRecipient();

		assertTrue(recipient.getCompleteName().equals(name1.getCompleteName()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.AbstractCda#setSetId(org.ehealth_connector.common.mdht.Identificator)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getSetId()}.
	 */
	@Test
	public void testSetGetSetId() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		Identificator id = new Identificator("2.999", "myId1");
		cda.setSetId(id);
		assertTrue(cda.getSetId().equals(id));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.AbstractCda#setTimestamp(java.util.Date)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getTimestamp()}.
	 */
	@Test
	public void testSetGetTimestamp() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		Date date = DateUtil.parseDateyyyyMMdd("20180722");
		cda.setTimestamp(date);
		assertTrue(cda.getTimestamp().equals(date));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.AbstractCda#setTitle(java.lang.String)}
	 * and {@link org.ehealth_connector.cda.AbstractCda#getTitle()}.
	 */
	@Test
	public void testSetGetTitle() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		cda.setTitle("myTitle1");
		assertTrue(cda.getTitle().equals("myTitle1"));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.AbstractCda#setVersion(int)} and
	 * {@link org.ehealth_connector.cda.AbstractCda#getVersion()}.
	 */
	@Test
	public void testSetGetVersion() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		Identificator id = new Identificator("2.999", "myId1");
		cda.setVersion(id, 999);
		assertTrue(cda.getVersion() == 999);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#initFirstVersion()}
	 * and
	 * {@link org.ehealth_connector.cda.ch.CdaChV2StructuredBody#initNextVersion()}.
	 */
	@Test
	public void testVersionLifeCycle() {
		final CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody> cda = new CdaChV2StructuredBody<org.openhealthtools.mdht.uml.cda.ch.CdaChV2StructuredBody>(
				ChFactory.eINSTANCE.createCdaChV2StructuredBody().init(), LanguageCode.GERMAN,
				"dummy", "dummy");
		Identificator id1 = new Identificator("2.999", "myId1");
		Identificator id2 = new Identificator("2.999", "myId2");
		cda.initFirstVersion(id1);
		assertTrue(cda.getId().equals(id1));
		assertTrue(cda.getId().equals(cda.getSetId()));
		assertTrue(cda.getVersion() == 1);

		cda.initNextVersion(id2);
		assertTrue(cda.getId().equals(id2));
		assertFalse(cda.getId().equals(cda.getSetId()));
		assertTrue(cda.getVersion() == 2);

	}

}
