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
package org.husky.cda.elga.narrative;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.husky.cda.TestUtils;
import org.husky.cda.elga.models.Comment;
import org.husky.cda.elga.models.eimpf.ImmunizationRecommendation;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.StrucDocContent;
import org.husky.common.hl7cdar2.StrucDocTable;
import org.husky.common.hl7cdar2.StrucDocTd;
import org.husky.common.hl7cdar2.StrucDocText;
import org.husky.common.hl7cdar2.StrucDocTr;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test of {@link ImmunizationRecommendationNarrativeTextGenerator}
 *
 */

class ImmunizationRecommendationNarrativeTextGeneratorTest extends TestUtils {

	private ImmunizationRecommendationNarrativeTextGenerator testNarrativeTextGenerator;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		super.init();
		testNarrativeTextGenerator = new ImmunizationRecommendationNarrativeTextGenerator(getEntries());
	}

	private List<POCDMT000040Entry> getEntries() {
		List<POCDMT000040Entry> entries = new LinkedList<>();
		ImmunizationRecommendation recommendation = new ImmunizationRecommendation();
		recommendation
				.setId(new Identificator("1.2.40.0.34.99", "8532fb42-f896-4396-b1a3-e298571687df_20220306023754"));
		recommendation.setStartRecommendation(ZonedDateTime.of(2022, 03, 20, 0, 0, 0, 0, ZoneId.of("UTC")));
		recommendation.setStopRecommendation(ZonedDateTime.of(2022, 03, 26, 0, 0, 0, 0, ZoneId.of("UTC")));
		recommendation.setImmunizationTargets(
				List.of(new Code("840534001", "2.16.840.1.113883.6.96", "SARS-CoV-2 (Corona)")));
		Comment comment = new Comment();
		comment.setText("impfempf-comment-0");
		recommendation.setComments(List.of(comment));
		entries.add(recommendation.getImmunizationRecommendationEntry(0));

		return entries;
	}

	/**
	 * Test method for
	 * {@link ImmunizationRecommendationNarrativeTextGenerator#getNarrativeTextCda(java.util.Map)}.
	 */
	@Test
	void testGetNarrativeTextCda() {
		Map<String, String> commentMap = new HashMap<>();
		commentMap.put("impfempf-comment-0", "ABCDEF");
		final StrucDocText generatedText = testNarrativeTextGenerator.getNarrativeTextCda(commentMap);

		assertNotNull(generatedText);
		assertNotNull(generatedText.getContent());
		assertNotNull(generatedText.getContent().get(0));

		assertTrue(generatedText.getContent().get(0) instanceof JAXBElement);
		StrucDocContent commentContent = (StrucDocContent) ((JAXBElement) generatedText.getContent().get(0)).getValue();

		assertEquals("ABCDEF", (String) commentContent.getContent().get(0));

		assertTrue(generatedText.getContent().get(1) instanceof JAXBElement);
		List<String> tableContent = new LinkedList<>();

		StrucDocTable table = (StrucDocTable) ((JAXBElement) generatedText.getContent().get(1)).getValue();

		for (StrucDocTr tr : table.getTbody().get(0).getTr()) {
			if (tr != null) {
				for (Object obj : tr.getThOrTd()) {
					if (obj != null) {
						StrucDocTd td = (StrucDocTd) obj;

						if (td.getContent().get(0) instanceof String) {
							tableContent.add((String) td.getContent().get(0));
						} else if (td.getContent().get(0) instanceof JAXBElement) {
							JAXBElement jaxb = (JAXBElement) td.getContent().get(0);
							StrucDocContent content = (StrucDocContent) jaxb.getValue();
							tableContent.add((String) content.getContent().get(0));
						}
					}
				}
			}
		}

		assertTrue(tableContent.contains("20.03.2022 - 26.03.2022"));
		assertTrue(tableContent.contains("SARS-CoV-2 (Corona)"));

	}

}
