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
package org.ehealth_connector.cda.ch.lab.lrep;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.Section;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.enums.AdministrativeGender;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit Tests for Class CdaChLrepV1GeneralReport.
 */
public class CdaChLrepV1GeneralReportTest {

	/** The name of the class under test. */
	private String cutName = "CdaChLrepV1GeneralReport";

	@Before
	public void setUp() throws Exception {
		// TODO
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.CdaChLrepV1GeneralReport#addAuthor(org.ehealth_connector.common.Author)}.
	 */
	@Test
	public void testAddGetAuthor() {
		Name name1 = new Name("John", "Doe");
		Name name2 = new Name("Max", "Muster");

		CdaChLrepV1GeneralReport cda = new CdaChLrepV1GeneralReport(LanguageCode.GERMAN, "dummy",
				"dummy");

		cda.addAuthor(new Author(name1));
		cda.addAuthor(new Author(name2));

		List<Author> authorList = cda.getAuthors();

		assertTrue(authorList.get(0).getName().getFamilyName().equals(name1.getFamilyName()));
		assertTrue(authorList.get(1).getName().getAllGivenNames().equals(name2.getAllGivenNames()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.CdaChLrepV1GeneralReport#addLaboratorySpecialtySection(org.ehealth_connector.cda.ch.lab.lrep.LaboratorySpecialtySection)}
	 * and
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.CdaChLrepV1GeneralReport#addLaboratoryBatteryOrganizerInNewSection(org.ehealth_connector.cda.ch.lab.lrep.LaboratoryBatteryOrganizer, org.ehealth_connector.common.Code, org.ehealth_connector.cda.ch.lab.lrep.SpecimenCollectionEntry)}.
	 */
	@Test
	public void testAddGetLaboratorySpecialtySection() {
		CdaChLrepV1GeneralReport cda = new CdaChLrepV1GeneralReport(LanguageCode.GERMAN, "dummy",
				"dummy");

		LaboratorySpecialtySection section1 = new LaboratorySpecialtySection();
		LaboratorySpecialtySection section2 = new LaboratorySpecialtySection();

		section1.setTitle("section1");
		section2.setTitle("section2");

		cda.addLaboratorySpecialtySection(section1);
		cda.addLaboratorySpecialtySection(section2);

		List<Section> sections = cda.getSections();

		assertTrue(sections.get(0).getTitle().equals("section1"));
		assertTrue(sections.get(1).getTitle().equals("section2"));

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.CdaChLrepV1GeneralReport#addOtherRecipient(org.ehealth_connector.common.Organization)}.
	 */
	@Test
	public void testAddGetOtherRecipient() {
		CdaChLrepV1GeneralReport cda = new CdaChLrepV1GeneralReport(LanguageCode.GERMAN, "dummy",
				"dummy");
		Name name1 = new Name("org1");
		Name name2 = new Name("org2");
		cda.addOtherRecipient(new Organization(name1));
		cda.addOtherRecipient(new Organization(name2));

		List<Organization> recipientsList = cda.getOtherRecipients();

		assertTrue(recipientsList.get(0).getCompleteName().equals(name1.getCompleteName()));
		assertTrue(recipientsList.get(1).getName().equals(name2.getName()));
	}

	/**
	 * Test method for templateIDs in this CDA element
	 */
	@Test
	public void testCheckTemplateIds() {
		String idIheXdLab = "1.3.6.1.4.1.19376.1.3.3";
		boolean idFoundIheXdLab = false;
		String idIheMs = "1.3.6.1.4.1.19376.1.5.3.1.1.1";
		boolean idFoundIheMs = false;
		String idChLrepGr = "2.16.756.5.30.1.1.1.1.3.9.1";
		boolean idFoundChLrepGr = false;
		String idChLrep = "2.16.756.5.30.1.1.10.1.10";
		boolean idFoundChLrep = false;
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
			if (idIheXdLab.equals(id.getRoot()))
				idFoundIheXdLab = true;
			if (idIheMs.equals(id.getRoot()))
				idFoundIheMs = true;
			if (idChLrepGr.equals(id.getRoot()))
				idFoundChLrepGr = true;
			if (idChLrep.equals(id.getRoot()))
				idFoundChLrep = true;
			if (idCdaChV2SbEnhanced.equals(id.getRoot()))
				idFoundCdaChV2SbEnhanced = true;
			if (idCdaChV2Sb.equals(id.getRoot()))
				idFoundCdaChV2Sb = true;
			if (idHl7Cda.equals(id.getRoot()))
				idFoundHl7Cda = true;
			if (idHl7CdaSb.equals(id.getRoot()))
				idFoundHl7CdaSb = true;
		}

		assertTrue(cutName + " templateID defined by IHE XD-LAB is missing", idFoundIheXdLab);
		assertTrue(cutName + " templateID defined by IHE MS is missing", idFoundIheMs);
		assertTrue(
				cutName + " templateID defined by ART DECOR CDA-CH-LREP General Report is missing",
				idFoundChLrepGr);
		assertTrue(cutName + " templateID defined by ART DECOR CDA-CH-LREP is missing",
				idFoundChLrep);
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
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.CdaChLrepV1GeneralReport#getLaboratoryBatteries()}.
	 */
	@Test
	public void testGetLaboratoryBatteries() {
		CdaChLrepV1GeneralReport cda = new CdaChLrepV1GeneralReport(LanguageCode.GERMAN, "dummy",
				"dummy");
		Date timeStamp1 = DateUtil.parseDateyyyyMMdd("20180721");
		Date timeStamp2 = DateUtil.parseDateyyyyMMdd("20180722");
		LaboratorySpecialtySection section = new LaboratorySpecialtySection();
		LaboratoryBatteryOrganizer lbo1 = new LaboratoryBatteryOrganizer();
		LaboratoryBatteryOrganizer lbo2 = new LaboratoryBatteryOrganizer();
		lbo1.setEffectiveTime(timeStamp1);
		lbo2.setEffectiveTime(timeStamp2);
		section.addLaboratoryBatteryOrganizer(new Code("2.999", "myTestCode1"), lbo1,
				LanguageCode.FRENCH);
		section.addLaboratoryBatteryOrganizer(new Code("2.999", "myTestCode2"), lbo2,
				LanguageCode.FRENCH);
		cda.addLaboratorySpecialtySection(section);
		List<LaboratoryBatteryOrganizer> list = cda.getLaboratoryBatteries();
		assertTrue(list.get(0).getEffectiveTime().equals(timeStamp1));
		assertTrue(list.get(1).getEffectiveTime().equals(timeStamp2));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.AbstractCda#saveToFile(java.lang.String)}.
	 *
	 * @throws Exception
	 */
	@Test
	public void testSerializationFile() throws Exception {
		CdaChLrepV1GeneralReport cda1 = new CdaChLrepV1GeneralReport(LanguageCode.GERMAN, "dummy",
				"dummy");
		String fn = Util.getTempDirectory() + "/" + cutName + ".tmp";
		cda1.saveToFile(fn);

		CdaChLrepV1GeneralReport cda2 = CdaChUtil.loadCdaChLrepV1GeneralReportFromFile(fn);

		assertTrue(cda1.getId().equals(cda2.getId()));

		// cleanup
		File file = new File(fn);
		if (!file.delete())
			file.deleteOnExit();
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.CdaChLrepV1GeneralReport#setCustodian(org.ehealth_connector.common.Organization)}.
	 */
	@Test
	public void testSetGetCustodian() {
		CdaChLrepV1GeneralReport cda = new CdaChLrepV1GeneralReport(LanguageCode.GERMAN, "dummy",
				"dummy");
		Name name1 = new Name("org1");
		cda.setCustodian(new Organization(name1));

		assertTrue(cda.getCustodian().getAssignedCustodian().getRepresentedCustodianOrganization()
				.getName().getText().equals(name1.getName()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.CdaChLrepV1GeneralReport#setPatient(org.ehealth_connector.common.Patient)}.
	 */
	@Test
	public void testSetGetPatient() {
		CdaChLrepV1GeneralReport cda = new CdaChLrepV1GeneralReport(LanguageCode.GERMAN, "dummy",
				"dummy");
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
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.CdaChLrepV1GeneralReport#setPrimaryRecipient(org.ehealth_connector.common.Organization)}.
	 */
	@Test
	public void testSetGetPrimaryRecipient() {
		CdaChLrepV1GeneralReport cda = new CdaChLrepV1GeneralReport(LanguageCode.GERMAN, "dummy",
				"dummy");
		Name name1 = new Name("org1");
		cda.setPrimaryRecipient(new Organization(name1));

		Organization recipient = cda.getPrimaryRecipient();

		assertTrue(recipient.getCompleteName().equals(name1.getCompleteName()));
	}
}
