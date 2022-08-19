/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.narrative;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.husky.cda.elga.utils.NamespaceUtils;
import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.IVXBTS;
import org.husky.common.hl7cdar2.QTY;
import org.husky.common.hl7cdar2.StrucDocContent;
import org.husky.common.hl7cdar2.StrucDocRenderMultiMedia;
import org.husky.common.hl7cdar2.StrucDocTd;
import org.husky.common.hl7cdar2.StrucDocTh;
import org.husky.common.hl7cdar2.TS;
import org.husky.common.utils.time.DateTimes;
import org.husky.common.utils.time.Hl7Dtm;

public class BaseTextGenerator {

	protected StrucDocTd getCellTd(String text) {
		if (text == null)
			text = "";

		StrucDocTd td = new StrucDocTd();
		td.getContent().add(text);
		return td;

	}

	protected StrucDocTd getCellWithRenderMultiMedia(String referenceObject) {

		StrucDocTd td = new StrucDocTd();

		StrucDocRenderMultiMedia renderMultiMedia = new StrucDocRenderMultiMedia();

		renderMultiMedia.getReferencedObject().add(referenceObject);

		td.getContent().add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "RenderMultiMedia"),
				StrucDocRenderMultiMedia.class, renderMultiMedia));

		return td;

	}

	protected StrucDocTh getTableHeaderCell(String text, String styleCode) {
		StrucDocTh th = new StrucDocTh();

		if (styleCode != null) {
			th.getStyleCode().add(styleCode);
		}

		th.getContent().add(text);

		return th;
	}

	protected StrucDocTd getCellTdWithContent(String text, String contentId) {
		StrucDocTd td = new StrucDocTd();
		td.getContent().add(getStrucDocContent(text, contentId));
		return td;
	}

	protected JAXBElement<StrucDocContent> getStrucDocContent(String text, String contentId) {
		StrucDocContent content = new StrucDocContent();
		content.setID(contentId);
		content.getContent().add(text);

		return new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "content"), StrucDocContent.class, content);
	}

	/**
	 * extracts all {@link TS} elements of passed {@link IVLTS}. Extracted elements
	 * are stored in a map, where key is element name like "high" and value is
	 * element value.
	 *
	 * @param time to be extracted
	 *
	 * @return map of element name and value
	 */
	protected Map<String, String> getTsElement(IVLTS time) {
		Map<String, String> tsElements = new HashMap<>();
		if (time != null) {
			for (JAXBElement<? extends QTY> ts : time.getRest()) {
				String value = "";
				String elementName = "";
				if (ts != null && IVXBTS.class.equals(ts.getDeclaredType()) && ts.getValue() != null) {
					value = ((IVXBTS) ts.getValue()).getValue();
				} else if (ts != null && TS.class.equals(ts.getDeclaredType()) && ts.getValue() != null) {
					value = ((TS) ts.getValue()).getValue();
				}

				if (ts != null && ts.getName() != null) {
					elementName = ts.getName().getLocalPart();
				}

				if (value != null && elementName != null) {
					tsElements.put(elementName, value);
				}
			}
		}

		return tsElements;
	}

	protected StrucDocTd getCellTdTime(IVLTS time) {
		String startDateDisease = null;
		String endDateDisease = null;

		var sb = new StringBuilder();

		var tdTime = new StrucDocTd();

		if (time != null) {
			Map<String, String> timeMap = getTsElement(time);
			startDateDisease = timeMap.get("low");
			endDateDisease = timeMap.get("high");

			var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy").withZone(ZoneId.systemDefault());
			if (startDateDisease != null) {
				sb.append(formatter.format(DateTimes.toInstant(Hl7Dtm.fromHl7(startDateDisease))));
				sb.append(" - ");
			}

			if (endDateDisease != null) {
				sb.append(formatter.format(DateTimes.toInstant(Hl7Dtm.fromHl7(endDateDisease))));
			}
		}

		tdTime.getContent().add(sb.toString());

		return tdTime;
	}

	protected StrucDocTd getCellTdCodes(List<CE> interpretationCodes) {
		StringBuilder sb = new StringBuilder();

		int index = 0;
		for (CE interpret : interpretationCodes) {
			if (interpret != null) {
				sb.append(interpret.getDisplayName());
			}

			index++;
			if (index != interpretationCodes.size()) {
				sb.append(" , ");
			}
		}

		return getCellTd(sb.toString());
	}

	protected StrucDocTd getCellTdCode(CD codeTest) {
		return getCellTd(codeTest.getDisplayName());
	}

	protected StrucDocTd getCellTdId(II codeId) {
		return getCellTd(String.format("%s - %s", codeId.getExtension(), codeId.getRoot()));
	}
}
