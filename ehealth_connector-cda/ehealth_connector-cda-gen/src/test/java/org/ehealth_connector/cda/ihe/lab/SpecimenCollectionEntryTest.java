package org.ehealth_connector.cda.ihe.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.Participant;
import org.ehealth_connector.common.ParticipantRole;
import org.junit.Test;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;
import org.openhealthtools.mdht.uml.hl7.vocab.RoleClassRoot;
import org.w3c.dom.Document;

public class SpecimenCollectionEntryTest extends TestUtils {

	@Test
	public void testModel() throws XPathExpressionException {
		super.init();
		SpecimenCollectionEntry entry = new SpecimenCollectionEntry();

		// SpecimenReceivedEntry
		SpecimenReceivedEntry sre = new SpecimenReceivedEntry();
		entry.setSpecimenReceivedEntry(sre);
		entry.setSpecimenReceivedEntry(new SpecimenReceivedEntry());

		assertNotNull(entry.getSpecimenReceivedEntry());
		Document document = entry.getDocument();
		assertTrue(xExist(document, "//entryRelationship[@typeCode='COMP']"));
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.3']"));

		// Effective Time
		entry.setEffectiveTime(startDate);
		assertEquals(startDate, entry.getEffectiveTime());

		// Participant
		Participant p = new Participant();
		p.setTypeCode(ParticipationType.PRD);
		ParticipantRole pr = new ParticipantRole();
		pr.setClassCode(RoleClassRoot.SPEC);
		pr.addId(id1);
		p.setParticipantRole(pr);
		entry.addParticipant(p);

		assertTrue(entry.getParticipants() != null && !entry.getParticipants().isEmpty()
				&& !(entry.getParticipants().get(0).getParticipantRole() == null));
		document = entry.getDocument();
		assertTrue(xExist(document, "//participant[@typeCode='PRD']"));
		assertTrue(xExist(document, "//participantRole[@classCode='SPEC']"));
	}
}
