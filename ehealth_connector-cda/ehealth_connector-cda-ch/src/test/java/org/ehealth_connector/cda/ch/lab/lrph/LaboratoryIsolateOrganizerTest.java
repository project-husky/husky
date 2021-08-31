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
package org.ehealth_connector.cda.ch.lab.lrph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.mdht.Organization;
import org.ehealth_connector.common.mdht.Participant;
import org.ehealth_connector.common.mdht.ParticipantRole;
import org.ehealth_connector.common.mdht.PlayingEntity;
import org.ehealth_connector.common.mdht.Specimen;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

public class LaboratoryIsolateOrganizerTest extends TestUtils {
	@Test
	public void testModel() throws XPathExpressionException {
		super.init();
		LaboratoryIsolateOrganizer lio = new LaboratoryIsolateOrganizer();

		Document document = lio.getDocument();
		assertTrue(xExist(document, "//statusCode[@code='completed']"));

		// EffectiveTime
		lio.setEffectiveTime(endDate);
		assertEquals(endDate, lio.getEffectiveTime());

		// Subject
		Specimen s = new Specimen();
		s.addId(id1);
		code1.setOriginalTextReference("testRef5");
		s.setCode(code1);
		lio.setSpecimen(s);
		assertNotNull(lio.getSpecimen());
		assertTrue(code1.equals(lio.getSpecimen().getCode()));
		assertTrue(id1.equals(lio.getSpecimen().getIdList().get(0)));
		assertEquals("#testRef5", lio.getSpecimen().getCode().getOriginalTextReference());

		document = lio.getDocument();
		assertTrue(xExist(document, "//specimen[@typeCode='SPC']"));
		assertTrue(xExist(document, "//specimenRole[@classCode='SPEC']"));
		assertTrue(xExist(document, "//specimenPlayingEntity[@classCode='MIC']"));

		// Participant as ehc Organization
		Organization o = new Organization();
		o.addAddress(address1);
		o.addId(id2);
		o.setTelecoms(telecoms1);
		o.addName("TestName");
		lio.addLaboratory(o, endDate);
		assertNotNull(lio.getLaboratory());
		assertEquals(address1.getCity(), lio.getLaboratory().getAddresses().get(0).getCity());
		assertTrue(id2.equals(lio.getLaboratory().getId()));
		assertTrue(isEqual(telecoms1, lio.getLaboratory().getTelecoms()));
		assertEquals("TestName", lio.getLaboratory().getName());

		// Participant as eHC Participant
		ParticipantRole pr = new ParticipantRole();
		Participant p = new Participant();
		PlayingEntity pe = new PlayingEntity();
		pr.setPlayingEntity(pe);
		p.setParticipantRole(pr);

		p.setTime(startDate);
		p.getParticipantRole().addAddress(address1);
		p.getParticipantRole().addAddress(address1);
		p.getParticipantRole().addId(id1);
		p.getParticipantRole().addId(id2);
		p.getParticipantRole().setTelecoms(telecoms1);
		lio.addParticipant(p);
		assertNotNull(lio.getParticipants());
		assertNotNull(lio.getParticipants().get(0));
		assertEquals(address1.getCity(),
				lio.getParticipants().get(1).getParticipantRole().getAddresses().get(1).getCity());
		assertTrue(
				id1.equals(lio.getParticipants().get(1).getParticipantRole().getIdList().get(0)));
		assertTrue(
				id2.equals(lio.getParticipants().get(1).getParticipantRole().getIdList().get(1)));
		assertTrue(isEqual(telecoms1,
				lio.getParticipants().get(1).getParticipantRole().getTelecoms()));

		document = lio.getDocument();
		assertTrue(xCount(document, "//participant[@typeCode='RESP']", 2));

		// Laboratory Battery Organizer
		LaboratoryBatteryOrganizer labBatteryOrganizer = new LaboratoryBatteryOrganizer();
		lio.addLaboratoryBatteryOrganizer(labBatteryOrganizer);
		assertNotNull(lio.getLaboratoryBatteryOrganizers());
		assertFalse(lio.getLaboratoryBatteryOrganizers().isEmpty());
		document = lio.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.4']"));
	}
}
