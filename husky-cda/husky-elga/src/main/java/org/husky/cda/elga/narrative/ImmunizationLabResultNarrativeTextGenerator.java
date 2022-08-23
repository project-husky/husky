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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.husky.common.hl7cdar2.ANY;
import org.husky.common.hl7cdar2.BL;
import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.CV;
import org.husky.common.hl7cdar2.INT;
import org.husky.common.hl7cdar2.IVLINT;
import org.husky.common.hl7cdar2.IVLPQ;
import org.husky.common.hl7cdar2.IVXBINT;
import org.husky.common.hl7cdar2.POCDMT000040Component4;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.common.hl7cdar2.POCDMT000040Organizer;
import org.husky.common.hl7cdar2.POCDMT000040ReferenceRange;
import org.husky.common.hl7cdar2.PQ;
import org.husky.common.hl7cdar2.QTY;
import org.husky.common.hl7cdar2.RTO;
import org.husky.common.hl7cdar2.ST;
import org.husky.common.hl7cdar2.StrucDocParagraph;
import org.husky.common.hl7cdar2.StrucDocTable;
import org.husky.common.hl7cdar2.StrucDocTbody;
import org.husky.common.hl7cdar2.StrucDocTd;
import org.husky.common.hl7cdar2.StrucDocText;
import org.husky.common.hl7cdar2.StrucDocThead;
import org.husky.common.hl7cdar2.StrucDocTr;
import org.husky.common.hl7cdar2.TS;

public class ImmunizationLabResultNarrativeTextGenerator extends BaseTextGenerator {

	private List<POCDMT000040Entry> entries;

	/**
	 * Constructor.
	 *
	 * @param entries a list of entries
	 */
	public ImmunizationLabResultNarrativeTextGenerator(List<POCDMT000040Entry> entries) {
		this.entries = entries;
	}

	private StrucDocTbody getBody(List<POCDMT000040Component4> components) {
		StrucDocTbody body = new StrucDocTbody();
		for (POCDMT000040Component4 component : components) {
			if (component != null && component.getObservation() != null) {
				StrucDocTr tr = new StrucDocTr();

				if (component.getObservation().getText() != null
						&& component.getObservation().getText().getReference() != null
						&& component.getObservation().getText().getReference().getValue() != null) {
					tr.setID(component.getObservation().getText().getReference().getValue().replace("#", ""));
				}

				tr.getThOrTd().add(getCellTdCode(component.getObservation().getCode()));
				tr.getThOrTd().add(getCellTdAny(component.getObservation().getValue().get(0)));
				tr.getThOrTd().add(getCellTdAnyUnit(component.getObservation().getValue().get(0)));
				tr.getThOrTd().add(getCellTdReferenceRange(component.getObservation().getReferenceRange()));
				tr.getThOrTd().add(getCellTdCodes(component.getObservation().getInterpretationCode()));

				body.getTr().add(tr);

			}
		}

		return body;
	}

	protected StrucDocTd getCellTdReferenceRange(List<POCDMT000040ReferenceRange> referenceRange) {
		StrucDocTd td = new StrucDocTd();

		for (POCDMT000040ReferenceRange range : referenceRange) {
			if (range != null && range.getObservationRange() != null) {
				if (range.getObservationRange().getText() != null
						&& range.getObservationRange().getText().getReference() != null
						&& range.getObservationRange().getText().getReference().getValue() != null) {
					td.setID(range.getObservationRange().getText().getReference().getValue().replace("#", ""));
				}

				if (range.getObservationRange().getValue() instanceof IVLPQ ivlpq) {
					td.getContent().add(getPqString(ivlpq));
				} else if (range.getObservationRange().getValue() instanceof RTO rto) {
					td.getContent().add(getRatio(rto));
				}
			}
		}

		return td;
	}

	private String getRatio(RTO rto) {
		StringBuilder sb = new StringBuilder();
		String textNumerator = "";
		if (rto.getNumerator() instanceof INT numerator) {
			textNumerator = numerator.getValue().toString();
		}

		if (rto.getDenominator() instanceof IVLINT denominator) {
			sb.append(getDenominator(denominator, textNumerator));
		}

		return sb.toString();
	}

	private String getDenominator(IVLINT denominator, String textNumerator) {
		StringBuilder sb = new StringBuilder();
		Map<String, IVXBINT> ivxbint = getIvxbIntElement(denominator);

		IVXBINT lowElement = ivxbint.get("low");

		if (lowElement != null && lowElement.getValue() != null) {
			sb.append(textNumerator);
			sb.append(":");

			if (lowElement.isInclusive()) {
				sb.append("≥");
			} else {
				sb.append(">");
			}

			sb.append(lowElement.getValue());
		}

		IVXBINT highElement = ivxbint.get("high");

		if (lowElement != null && highElement != null) {
			sb.append(" - ");
		}

		if (highElement != null && highElement.getValue() != null) {
			sb.append(textNumerator);
			sb.append(":");

			if (highElement.isInclusive()) {
				sb.append("≤");
			} else {
				sb.append("<");
			}

			sb.append(highElement.getValue());
		}

		return sb.toString();
	}

	private String getPqString(IVLPQ ivlpq) {
		StringBuilder sb = new StringBuilder();
		Map<String, PQ> pq = getPqElement(ivlpq);

		PQ lowElement = pq.get("low");

		if (lowElement != null && lowElement.getValue() != null) {
			sb.append(lowElement.getValue());

			if (!lowElement.getUnit().isEmpty()) {
				sb.append(" ");
				sb.append(lowElement.getUnit());
			}
			sb.append(" - ");
		}

		PQ highElement = pq.get("high");

		if (highElement != null && highElement.getValue() != null) {
			sb.append(highElement.getValue());

			if (!highElement.getUnit().isEmpty()) {
				sb.append(" ");
				sb.append(highElement.getUnit());
			}
		}

		return sb.toString();
	}

	/**
	 * extracts all {@link PQ} elements of passed {@link IVLPQ}. Extracted elements
	 * are stored in a map, where key is element name like "high" and value is
	 * extracted {@link PQ}.
	 *
	 * @param range to be extracted
	 *
	 * @return map of element name and value
	 */
	protected Map<String, PQ> getPqElement(IVLPQ range) {
		Map<String, PQ> pqElements = new HashMap<>();
		if (range != null) {
			for (JAXBElement<? extends QTY> pq : range.getRest()) {
				PQ value = new PQ();
				String elementName = "";
				if (pq != null && PQ.class.equals(pq.getDeclaredType()) && pq.getValue() != null) {
					value = (PQ) pq.getValue();
				}

				if (pq != null && pq.getName() != null) {
					elementName = pq.getName().getLocalPart();
				}

				if (value != null && elementName != null) {
					pqElements.put(elementName, value);
				}
			}
		}

		return pqElements;
	}

	/**
	 * extracts all {@link IVXBINT} elements of passed {@link IVLINT}. Extracted
	 * elements are stored in a map, where key is element name like "high" and value
	 * is extracted {@link IVXBINT}.
	 *
	 * @param qty to be extracted
	 *
	 * @return map of element name and value
	 */
	protected Map<String, IVXBINT> getIvxbIntElement(IVLINT qty) {
		Map<String, IVXBINT> ivxbintElements = new HashMap<>();
		if (qty != null) {
			for (JAXBElement<? extends QTY> ivxbint : qty.getRest()) {
				IVXBINT value = new IVXBINT();
				String elementName = "";
				if (ivxbint != null && IVXBINT.class.equals(ivxbint.getDeclaredType()) && ivxbint.getValue() != null) {
					value = (IVXBINT) ivxbint.getValue();
				}

				if (ivxbint != null && ivxbint.getName() != null) {
					elementName = ivxbint.getName().getLocalPart();
				}

				if (value != null && elementName != null) {
					ivxbintElements.put(elementName, value);
				}
			}
		}

		return ivxbintElements;
	}

	protected StrucDocTd getCellTdAny(ANY resultTest) {
		String text = "";
		if (resultTest instanceof PQ pq) {
			return getCellTd(pq.getValue());
		} else if (resultTest instanceof BL bl) {
			return getCellTd(bl.isValue().toString());
		} else if (resultTest instanceof INT intVal) {
			return getCellTd(intVal.getValue().toString());
		} else if (resultTest instanceof ST stVal) {
			return getCellTd(stVal.getMergedXmlMixed());
		} else if (resultTest instanceof CD cdVal) {
			return getCellTd(cdVal.getDisplayName());
		} else if (resultTest instanceof CV cvVal) {
			return getCellTd(cvVal.getDisplayName());
		} else if (resultTest instanceof TS tsVal) {
			return getCellTd(tsVal.getValue());
		}

		return getCellTd(text);
	}

	protected StrucDocTd getCellTdAnyUnit(ANY resultTest) {
		String text = "";
		if (resultTest instanceof PQ pq) {
			return getCellTd(pq.getUnit());
		}

		return getCellTd(text);
	}

	private StrucDocThead getTableHeader() {
		StrucDocThead thead = new StrucDocThead();

		StrucDocTr tr = new StrucDocTr();
		tr.getThOrTd().add(getTableHeaderCell("Analyse", "xELGA_colw:40"));
		tr.getThOrTd().add(getTableHeaderCell("Ergebnis", null));
		tr.getThOrTd().add(getTableHeaderCell("Einheit", null));
		tr.getThOrTd().add(getTableHeaderCell("Referenzbereiche", null));
		tr.getThOrTd().add(getTableHeaderCell("Interpretation", "xELGA_colw:10"));
		thead.getTr().add(tr);

		return thead;
	}

	/**
	 * Returns {@link StrucDocTable} included in {@link JAXBElement}.
	 *
	 */
	public StrucDocTable getTable(List<POCDMT000040Component4> components) {
		StrucDocTable table = new StrucDocTable();
		table.setThead(getTableHeader());
		table.getTbody().add(getBody(components));
		return table;
	}

	/**
	 * Returns {@link StrucDocTable} included in {@link JAXBElement}.
	 *
	 */
	public StrucDocParagraph getParagraph(POCDMT000040Organizer organizer) {
		StrucDocParagraph paragraph = new StrucDocParagraph();
		paragraph.getStyleCode().add("xELGA_h3");

		if (organizer != null && organizer.getCode() != null) {
			paragraph.getContent().add(organizer.getCode().getDisplayName());
		}

		return paragraph;
	}

	/**
	 * Returns {@link StrucDocTable} included in {@link JAXBElement}.
	 *
	 */
	public StrucDocText getText() {
		StrucDocText text = new StrucDocText();

		for (POCDMT000040Entry entry : entries) {
			if (entry != null && entry.getAct() != null && entry.getAct().getEntryRelationship() != null
					&& !entry.getAct().getEntryRelationship().isEmpty()) {
				for (POCDMT000040EntryRelationship entryRel : entry.getAct().getEntryRelationship()) {
					if (entryRel != null && entryRel.getOrganizer() != null) {
						text.getContent()
								.add(new JAXBElement<StrucDocParagraph>(new QName("urn:hl7-org:v3", "paragraph"),
										StrucDocParagraph.class, getParagraph(entryRel.getOrganizer())));
						text.getContent().add(new JAXBElement<StrucDocTable>(new QName("urn:hl7-org:v3", "table"),
								StrucDocTable.class, getTable(entryRel.getOrganizer().getComponent())));
					}
				}
			}
		}

		return text;
	}

}
