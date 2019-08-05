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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.BaseObservation;
import org.ehealth_connector.cda.ObservationMediaEntry;
import org.ehealth_connector.common.mdht.Author;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.Name;
import org.ehealth_connector.common.mdht.Performer;
import org.ehealth_connector.common.mdht.enums.StatusCode;
import org.ehealth_connector.common.utils.DateUtilOld;
import org.junit.Test;

/**
 * Unit Tests for Class LaboratoryBatteryOrganizer.
 */
public class LaboratoryBatteryOrganizerTest {
	/** The name of the class under test. */
	private String cutName = "LaboratoryBatteryOrganizer";

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.LaboratoryBatteryOrganizer#addAuthor(org.ehealth_connector.common.mdht.Author)}.
	 */
	@Test
	public void testAddGetAuthor() {
		Name name1 = new Name("John", "Doe");
		Name name2 = new Name("Max", "Muster");
		LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
		lbo.addAuthor(new Author(name1));
		lbo.addAuthor(new Author(name2));

		List<Author> authorList = lbo.getAuthors();

		assertTrue(authorList.get(0).getName().getFamilyName().equals(name1.getFamilyName()));
		assertTrue(authorList.get(1).getName().getAllGivenNames().equals(name2.getAllGivenNames()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.LaboratoryBatteryOrganizer#addLaboratoryObservation(org.ehealth_connector.cda.ch.lab.lrep.LaboratoryObservation)}
	 * and
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.LaboratoryBatteryOrganizer#getLaboratoryObservations()}
	 * and
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.LaboratoryBatteryOrganizer#getLrepLaboratoryObservations()}.
	 */
	@Test
	public void testAddGetLaboratoryObservation() {
		LaboratoryObservation obs1 = new LaboratoryObservation();
		LaboratoryObservation obs2 = new LaboratoryObservation();

		obs1.setText("test1");
		obs2.setText("test2");

		LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
		lbo.addLaboratoryObservation(obs1);
		lbo.addLaboratoryObservation(obs2);

		List<BaseObservation> obsList = lbo.getLaboratoryObservations();

		assertTrue(obsList.get(0).getText().equals(obs1.getText()));
		assertTrue(obsList.get(1).getText().equals(obs2.getText()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.LaboratoryBatteryOrganizer#addObservationMediaEntry(org.ehealth_connector.cda.ObservationMediaEntry)}
	 * and
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.LaboratoryBatteryOrganizer#getObservationMediaEntries()}.
	 */
	@Test
	public void testAddGetObservationMediaEntry() {

		ObservationMediaEntry obsMedia1 = new ObservationMediaEntry();
		ObservationMediaEntry obsMedia2 = new ObservationMediaEntry();

		obsMedia1.setObservationMediaId("id1");
		obsMedia2.setObservationMediaId("id2");

		LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
		lbo.addObservationMediaEntry(obsMedia1);
		lbo.addObservationMediaEntry(obsMedia2);

		List<ObservationMediaEntry> obsMediaList = lbo.getObservationMediaEntries();
		assertTrue(obsMediaList.get(0).getObservationMediaId()
				.equals(obsMedia1.getObservationMediaId()));
		assertTrue(obsMediaList.get(1).getObservationMediaId()
				.equals(obsMedia2.getObservationMediaId()));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.LaboratoryBatteryOrganizer#addPerformer(org.ehealth_connector.common.mdht.Performer)}.
	 */
	@Test
	public void testAddGetPerformer() {
		Name name1 = new Name("John", "Doe");
		Name name2 = new Name("Max", "Muster");
		LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
		lbo.addPerformer(new Performer(name1));
		lbo.addPerformer(new Performer(name2));

		List<Performer> PerformerList = lbo.getPerformers();

		assertTrue(PerformerList.get(0).getName().getFamilyName().equals(name1.getFamilyName()));
		assertTrue(
				PerformerList.get(1).getName().getAllGivenNames().equals(name2.getAllGivenNames()));
	}

	/**
	 * Test method for templateIDs in this CDA element
	 */
	@Test
	public void testCheckTemplateIds() {
		String idIhe = "1.3.6.1.4.1.19376.1.3.1.4";
		boolean idFoundIhe = false;
		String idChPalm = "2.16.756.5.30.1.1.10.4.19";
		boolean idFoundChPalm = false;

		LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();

		for (Identificator id : lbo.getTemplateIds()) {
			assertNull("Extensions not allowd for template ids", id.getExtension());
			if (idIhe.equals(id.getRoot()))
				idFoundIhe = true;
			if (idChPalm.equals(id.getRoot()))
				idFoundChPalm = true;
		}

		assertTrue(cutName + " templateID defined by IHE XD-LAB is missing", idFoundIhe);
		assertTrue(cutName + " templateID defined by ART DECOR CH-PALM is missing", idFoundChPalm);
		assertFalse(cutName + " contains more templateIds than expected",
				(lbo.getTemplateIds().size() > 2));
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.MdhtOrganizerFacade#setEffectiveTime(java.util.Date)}
	 * and
	 * {@link org.ehealth_connector.cda.MdhtOrganizerFacade#getEffectiveTime()}
	 * and
	 * {@link org.ehealth_connector.cda.ch.lab.lrep.LaboratoryBatteryOrganizer#setEffectiveTime(java.util.Date, java.util.Date)}.
	 */
	@Test
	public void testSetGetEffectiveTimeDate() {
		Date date1 = DateUtilOld.parseDateyyyyMMdd("20180721");
		Date date2 = DateUtilOld.parseDateyyyyMMdd("20180722");

		LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();

		lbo.setEffectiveTime(date1);

		assertTrue(lbo.getEffectiveTime().equals(date1));
		assertFalse(lbo.getEffectiveTime().equals(date2));

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.MdhtOrganizerFacade#setStatusCode(org.ehealth_connector.common.mdht.enums.StatusCode)}
	 * and
	 * {@link org.ehealth_connector.cda.MdhtOrganizerFacade#getStatusCode()}.
	 */
	@Test
	public void testSetGetStatusCode() {
		StatusCode code = StatusCode.CANCELLED;
		LaboratoryBatteryOrganizer lbo = new LaboratoryBatteryOrganizer();
		lbo.setStatusCode(code);
		assertTrue(lbo.getStatusCode().getCode().getCode().equals(code.getCode().getCode()));
	}

}
