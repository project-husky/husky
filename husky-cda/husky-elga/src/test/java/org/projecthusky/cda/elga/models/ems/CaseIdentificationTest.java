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
package org.projecthusky.cda.elga.models.ems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.projecthusky.cda.TestUtils;
import org.projecthusky.cda.elga.generated.artdecor.ems.enums.ElgaDiagnosesicherheit;
import org.projecthusky.cda.elga.generated.artdecor.ems.enums.EpimsMeldepflichtigeKrankheiten;
import org.projecthusky.common.hl7cdar2.ActRelationshipHasComponent;
import org.projecthusky.common.hl7cdar2.POCDMT000040Act;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040Observation;
import org.projecthusky.common.hl7cdar2.POCDMT000040Organizer;
import org.projecthusky.common.hl7cdar2.XActClassDocumentEntryAct;
import org.projecthusky.common.hl7cdar2.XActClassDocumentEntryOrganizer;
import org.projecthusky.common.hl7cdar2.XActMoodDocumentObservation;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntry;
import org.projecthusky.common.hl7cdar2.XDocumentActMood;
import org.projecthusky.common.model.Code;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test of {@link CaseIdentification}.
 *
 * @author Anna Jungwirth
 */
class CaseIdentificationTest extends TestUtils {

	private CaseIdentification testCaseIdentification;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		super.init();
		testCaseIdentification = new CaseIdentification();
		testCaseIdentification.setDiagnosisDate(ZonedDateTime.of(2020, 9, 8, 0, 0, 0, 0, ZoneId.systemDefault()));
		Code disease = new Code();
		disease.setCode(EpimsMeldepflichtigeKrankheiten.CAMPYLOBAKTER_SPP_DARMPATHOGEN.getCodeValue());
		disease.setCodeSystem(EpimsMeldepflichtigeKrankheiten.CAMPYLOBAKTER_SPP_DARMPATHOGEN.getCodeSystemId());
		disease.setDisplayName(EpimsMeldepflichtigeKrankheiten.CAMPYLOBAKTER_SPP_DARMPATHOGEN.getDisplayName());
		testCaseIdentification.setDisease(disease);

		Code diagnosisConf = new Code();
		diagnosisConf.setCode(ElgaDiagnosesicherheit.VERDACHT_AUF.getCodeValue());
		diagnosisConf.setCodeSystem(ElgaDiagnosesicherheit.VERDACHT_AUF.getCodeSystemId());
		diagnosisConf.setDisplayName(ElgaDiagnosesicherheit.VERDACHT_AUF.getDisplayName());
		testCaseIdentification.setDiagnosisConfidence(diagnosisConf);
	}

	/**
	 * Test method for
	 * {@link CaseIdentification#getEpimsEntryCaseIdenticationArzt()}.
	 */
	@Test
	void testGetEpimsEntryCaseIdenticationArzt() {
		final POCDMT000040Entry caseIdentificationEntry = testCaseIdentification.getEpimsEntryCaseIdenticationArzt();
		assertNotNull(caseIdentificationEntry);
		assertEquals(XActRelationshipEntry.DRIV, caseIdentificationEntry.getTypeCode());
		assertEquals("1.3.6.1.4.1.19376.1.3.1", caseIdentificationEntry.getTemplateId().get(0).getRoot());

		POCDMT000040Act caseIdentificationEntryAct = caseIdentificationEntry.getAct();
		assertEquals(XDocumentActMood.EVN, caseIdentificationEntryAct.getMoodCode());
		assertEquals(XActClassDocumentEntryAct.ACT, caseIdentificationEntryAct.getClassCode());

		assertNotNull(caseIdentificationEntryAct.getCode());
		assertEquals("34782-3", caseIdentificationEntryAct.getCode().getCode());
		assertEquals("2.16.840.1.113883.6.1", caseIdentificationEntryAct.getCode().getCodeSystem());
		assertEquals("LOINC", caseIdentificationEntryAct.getCode().getCodeSystemName());
		assertEquals("Infectious disease Note", caseIdentificationEntryAct.getCode().getDisplayName());

		assertNotNull(caseIdentificationEntryAct.getStatusCode());
		assertEquals("completed", caseIdentificationEntryAct.getStatusCode().getCode());

		assertNotNull(caseIdentificationEntryAct.getEntryRelationship());
		assertEquals(1, caseIdentificationEntryAct.getEntryRelationship().size());
		assertNotNull(caseIdentificationEntryAct.getEntryRelationship().get(0));

		POCDMT000040Organizer organizer = caseIdentificationEntryAct.getEntryRelationship().get(0).getOrganizer();
		assertNotNull(organizer);
		assertEquals(XActClassDocumentEntryOrganizer.CLUSTER, organizer.getClassCode());
		assertEquals("EVN", organizer.getMoodCode().get(0));
		assertEquals(2, organizer.getTemplateId().size());
		assertEquals("1.2.40.0.34.6.0.11.3.56", organizer.getTemplateId().get(0).getRoot());
		assertEquals("1.3.6.1.4.1.19376.1.3.1.1", organizer.getTemplateId().get(1).getRoot());

		assertEquals("completed", organizer.getStatusCode().getCode());

		assertEquals(1, organizer.getComponent().size());
		assertEquals(ActRelationshipHasComponent.COMP, organizer.getComponent().get(0).getTypeCode());

		POCDMT000040Observation observation = organizer.getComponent().get(0).getObservation();
		assertNotNull(observation);
		assertEquals("CASE", observation.getClassCode().get(0));
		assertEquals(XActMoodDocumentObservation.EVN, observation.getMoodCode());

		assertEquals("1.2.40.0.34.6.0.11.3.57", observation.getTemplateId().get(0).getRoot());
		assertEquals("1.3.6.1.4.1.19376.1.3.1.1.2", observation.getTemplateId().get(1).getRoot());

	}


}
