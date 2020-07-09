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
package org.ehealth_connector.cda.ch.emed;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.commons.lang3.StringUtils;
import org.ehealth_connector.cda.NarrativeTableInfos;
import org.ehealth_connector.cda.ch.emed.enums.EmedTextNarrativeAttributes;
import org.ehealth_connector.cda.ch.emed.v096.DosageIntakeModeEntryContentModule;
import org.ehealth_connector.cda.ch.emed.v096.IhesubstitutionPermissionContentModule;
import org.ehealth_connector.cda.ch.emed.v096.MedicationTreatmentPlanEntryContentModule;
import org.ehealth_connector.cda.ch.emed.v096.PrescribedQuantityEntryContentModule;
import org.ehealth_connector.cda.ch.emed.v096.TreatmentReasonEntryContentModule;
import org.ehealth_connector.cda.ch.emed.v096.enums.ActSubstanceAdminSubstitutionCode;
import org.ehealth_connector.cda.ch.emed.v096.enums.ChEmedTimingEvent;
import org.ehealth_connector.cda.ch.emed.v096.enums.PharmaceuticalDoseFormEdqm;
import org.ehealth_connector.cda.ch.emed.v096.enums.RouteOfAdministrationEdqm;
import org.ehealth_connector.cda.ch.enums.UnitsOfTime;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.cda.ihe.pharm.enums.DosageType;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.hl7cdar2.CD;
import org.ehealth_connector.common.hl7cdar2.CE;
import org.ehealth_connector.common.hl7cdar2.COCTMT230100UVIngredient;
import org.ehealth_connector.common.hl7cdar2.COCTMT230100UVPackagedMedicine;
import org.ehealth_connector.common.hl7cdar2.ED;
import org.ehealth_connector.common.hl7cdar2.EIVLTS;
import org.ehealth_connector.common.hl7cdar2.II;
import org.ehealth_connector.common.hl7cdar2.INT;
import org.ehealth_connector.common.hl7cdar2.IVLINT;
import org.ehealth_connector.common.hl7cdar2.IVLPQ;
import org.ehealth_connector.common.hl7cdar2.IVLTS;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.ehealth_connector.common.hl7cdar2.PIVLTS;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Act;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Entry;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040ManufacturedProduct;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Material;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Observation;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Product;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Section;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040SubstanceAdministration;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Supply;
import org.ehealth_connector.common.hl7cdar2.PQ;
import org.ehealth_connector.common.hl7cdar2.QTY;
import org.ehealth_connector.common.hl7cdar2.SXCMTS;
import org.ehealth_connector.common.hl7cdar2.SXPRTS;
import org.ehealth_connector.common.hl7cdar2.StrucDocBr;
import org.ehealth_connector.common.hl7cdar2.StrucDocParagraph;
import org.ehealth_connector.common.hl7cdar2.StrucDocTable;
import org.ehealth_connector.common.hl7cdar2.StrucDocTbody;
import org.ehealth_connector.common.hl7cdar2.StrucDocTd;
import org.ehealth_connector.common.hl7cdar2.StrucDocText;
import org.ehealth_connector.common.hl7cdar2.StrucDocTh;
import org.ehealth_connector.common.hl7cdar2.StrucDocThead;
import org.ehealth_connector.common.hl7cdar2.StrucDocTr;
import org.ehealth_connector.common.hl7cdar2.TEL;
import org.ehealth_connector.common.hl7cdar2.TS;
import org.ehealth_connector.common.utils.DateUtil;

/**
 * Generates the narrative text for CDA Emed
 * <p>
 * Here are the manadged profiles :
 * <ul>
 * <li>MTP</li>
 * <li>PRE</li>
 * <li>PADV</li>
 * <li>DIS</li>
 * </ul>
 */
public class EmedChStrucDocTextBuilderV096 extends StrucDocText {

	/**
	 * key for retrieve "complementary_info" sentence in "Messages.properties"
	 * file
	 */
	private final static String COMPLEMENTARY_INFO_TAG = "complementary_info";
	/**
	 * patern to format date ex : 20 June 2020 10:50
	 */
	private final static String COMPLET_DATE_PATTERN = "dd MMMMM yyyy HH:mm";
	/**
	 * Template ID used for medication instructions
	 */
	private final static String DOSAGE_INTAKE_REFERENCE_TEMPLATE_ID = new DosageIntakeModeEntryContentModule()
			.getHl7TemplateId().get(0).getRoot(); // "2.16.756.5.30.1.1.10.4.37";
	/**
	 * key for retrieve "important info" sentence in "Messages.properties" file
	 */
	private final static String IMPORTANT_INFO_TAG = "important_info";
	/**
	 * Template ID used for fulfillment instructions
	 */
	private final static String MEDICATION_FULFILLMENT_INSTRUCTIONS_TEMPLATE_ID = "1.3.6.1.4.1.19376.1.5.3.1.4.3.1";
	/**
	 * Template ID used for medication instructions
	 */
	private final static String MEDICATION_INSTRUCTIONS_TEMPLATE_ID = "1.3.6.1.4.1.19376.1.5.3.1.4.3";
	/**
	 * Template ID used for prescribed_quantity permission
	 */
	private final static String PRESCRIBED_QUANTITY_TEMPLATE_ID = new PrescribedQuantityEntryContentModule()
			.getHl7TemplateId().get(0).getRoot();
	/**
	 * Template ID used for substitution permission
	 */
	private final static String SUBSTITUTION_PERMISSION_TEMPLATE_ID = new IhesubstitutionPermissionContentModule()
			.getHl7TemplateId().get(0).getRoot();
	/**
	 * Template ID used for traitment reason
	 */
	private static final String TRAITMENT_REASON_TEMPLATE_ID = new TreatmentReasonEntryContentModule()
			.getHl7TemplateId().get(0).getRoot();

	/**
	 * get the resources from the Message file, we can choose the lang of the
	 * value
	 **/
	private static ResourceBundle resBundle;

	/**
	 * <div class="en">Transforme a date to a readable date of the choosen
	 * language</div>
	 *
	 * @param date
	 *            date to format
	 * @param languageCode
	 *            language of translation
	 * @return formated date
	 */
	private static String dateToCompletDateString(Date date, LanguageCode languageCode) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(COMPLET_DATE_PATTERN,
				new Locale(languageCode.getCode().getCode().split("-")[0], "CH"));
		return simpleDateFormat.format(date);
	}

	/**
	 * <div class="en">Convert a doseQuentity to a String</div>
	 *
	 * @param doseQuantityElement
	 *            a doseQuantityElement
	 * @param unitGlobal
	 *            an unitGlobal
	 * @return dose quantity to string
	 */
	private static String doseQuantityElementToString(JAXBElement<? extends PQ> doseQuantityElement,
			String unitGlobal) {
		String str;
		str = doseQuantityElement.getValue().getValue();
		if (isNotEmptyPqUnit(doseQuantityElement)) {
			str += doseQuantityElement.getValue().getUnit();
		} else {
			str += unitGlobal;
		}
		return str;
	}

	/**
	 * <div class="en"> Retrieve the DispenseAmount EntryRelationship if it
	 * exists</div>
	 *
	 * @param relationships
	 *            the relationships
	 * @return dispenseAmount relationship if exists
	 */
	private static POCDMT000040EntryRelationship filterDispenseAmount(
			List<POCDMT000040EntryRelationship> relationships) {
		return filterEntryRelationshipSupplyByTemplateId(relationships,
				PRESCRIBED_QUANTITY_TEMPLATE_ID);
	}

	/**
	 * <div class="en"> Retrieve entryRelationship in function of an act
	 * templated id </div>
	 *
	 * @param relationships
	 *            list of EntryRelationship
	 * @param templateIdToFind
	 *            template id to find
	 * @return entryRelationship
	 */
	private static POCDMT000040EntryRelationship filterEntryRelationshipAtcByTemplateId(
			List<POCDMT000040EntryRelationship> relationships, String templateIdToFind) {
		return relationships.stream().filter(
				pocdmt000040EntryRelationship -> pocdmt000040EntryRelationship.getAct() != null)
				.filter(pocdmt000040EntryRelationship -> pocdmt000040EntryRelationship.getAct()
						.getTemplateId().stream()
						.anyMatch(templateId -> templateId.getRoot().equals(templateIdToFind)))
				.findFirst().orElse(null);
	}

	/**
	 * <div class="en">Fetch the first relationship that contains the
	 * templateIdToFind in the supply templateId list</div>
	 *
	 * @param relationships
	 *            list of EntryRelationship
	 * @param templateIdToFind
	 *            template id to find
	 * @return an EntryRelationship
	 */
	private static POCDMT000040EntryRelationship filterEntryRelationshipSupplyByTemplateId(
			List<POCDMT000040EntryRelationship> relationships, String templateIdToFind) {
		return relationships.stream().filter(
				pocdmt000040EntryRelationship -> pocdmt000040EntryRelationship.getSupply() != null)
				.filter(pocdmt000040EntryRelationship -> pocdmt000040EntryRelationship.getSupply()

						.getTemplateId().stream()
						.anyMatch(templateId -> templateId.getRoot().equals(templateIdToFind)))
				.findFirst().orElse(null);
	}

	/**
	 * <div class="en">Retrieve the fulFillment if it exists</div>
	 *
	 * @param relationships
	 *            relationships list
	 * @return fulTillment entryrelationship if exists
	 */
	private static POCDMT000040EntryRelationship filterFulfillment(
			List<POCDMT000040EntryRelationship> relationships) {
		return filterEntryRelationshipAtcByTemplateId(relationships,
				MEDICATION_FULFILLMENT_INSTRUCTIONS_TEMPLATE_ID);
	}

	/**
	 * <div class="en">Retrieve the PatientInstruction EntryRelationship if it
	 * exists</div>
	 *
	 * @param relationships
	 *            the relatiobships
	 * @return patient instruction relationship if exists
	 */
	private static POCDMT000040EntryRelationship filterPatientInstruction(
			List<POCDMT000040EntryRelationship> relationships) {
		return filterEntryRelationshipAtcByTemplateId(relationships,
				MEDICATION_INSTRUCTIONS_TEMPLATE_ID);
	}

	/**
	 * <div class="en"> Retrieve the SubstanceAdministration if it exists</div>
	 *
	 * @param relationships
	 *            list of EntryRelationship
	 * @return substanceAdministration if exists
	 */
	private static POCDMT000040SubstanceAdministration filterSubstanceAdministrationDis(
			List<POCDMT000040EntryRelationship> relationships) {
		POCDMT000040EntryRelationship entryRelationship = filterSubstanceAdministrationyTemplateId(
				relationships, "1.3.6.1.4.1.19376.1.9.1.3.6");
		return entryRelationship != null ? entryRelationship.getSubstanceAdministration() : null;
	}

	/**
	 * <div class="en"> Retrieve entryRelationship in function of an
	 * substanceadmnistration templated id </div>
	 *
	 * @param relationships
	 *            list of EntryRelationship
	 * @param templateIdToFind
	 *            template id to find
	 * @return entryRelationship
	 */
	private static POCDMT000040EntryRelationship filterSubstanceAdministrationyTemplateId(
			List<POCDMT000040EntryRelationship> relationships,
			@SuppressWarnings("SameParameterValue") String templateIdToFind) {
		return relationships.stream()
				.filter(pocdmt000040EntryRelationship -> pocdmt000040EntryRelationship
						.getSubstanceAdministration() != null)
				.filter(pocdmt000040EntryRelationship -> pocdmt000040EntryRelationship
						.getSubstanceAdministration().getTemplateId().stream()
						.anyMatch(templateId -> templateId.getRoot().equals(templateIdToFind)))
				.findFirst().orElse(null);
	}

	/**
	 * <div class="en">Retrieve the SubstitutionPermission EntryRelationship if
	 * it exists</div>
	 *
	 * @param relationships
	 *            a realtionship
	 * @return substitutionPermission if exists
	 */
	private static POCDMT000040EntryRelationship filterSubstitutionPermission(
			List<POCDMT000040EntryRelationship> relationships) {
		return filterEntryRelationshipAtcByTemplateId(relationships,
				SUBSTITUTION_PERMISSION_TEMPLATE_ID);
	}

	/**
	 * <div class="en">Retrieve the treatmentReason EntryRelationship if it
	 * exists</div>
	 *
	 * @param relationships
	 *            the relationship
	 * @return traeatment reason if exists
	 */
	private static POCDMT000040EntryRelationship filterTreatmentReason(
			List<POCDMT000040EntryRelationship> relationships) {
		return relationships.stream()
				.filter(pocdmt000040EntryRelationship -> pocdmt000040EntryRelationship
						.getObservation() != null)
				.filter(pocdmt000040EntryRelationship -> pocdmt000040EntryRelationship
						.getObservation().getTemplateId().stream().anyMatch(templateId -> templateId
								.getRoot().equals(TRAITMENT_REASON_TEMPLATE_ID)))
				.findFirst().orElse(null);
	}

	/**
	 * <div class="en">Check if there any templateId in the list of templates
	 * id</div>
	 *
	 * @param templateIdsToFind
	 *            template ids to find
	 * @param templateIds
	 *            template ids
	 * @return true if a template is in the list of themplates ids
	 */
	private static boolean isAnyTemplateIdInList(List<String> templateIdsToFind,
			List<II> templateIds) {
		return templateIds.stream()
				.anyMatch(templateId -> templateIdsToFind.contains(templateId.getRoot()));
	}

	/**
	 * <div class="en">check if pq has an unit</div>
	 *
	 * @param pq
	 *            the pq
	 * @return true if not empty
	 */
	private static boolean isNotEmptyPqUnit(JAXBElement<? extends PQ> pq) {
		return pq != null && pq.getValue() != null
				&& StringUtils.isNotEmpty(pq.getValue().getUnit())
				&& !pq.getValue().getUnit().equals("1");
	}

	/**
	 * <div class="en">check if pq has a value</div>
	 *
	 * @param pq
	 *            the pq
	 * @return true if not empty
	 */
	private static boolean isNotEmptyPqValue(JAXBElement<? extends PQ> pq) {
		return pq != null && pq.getValue() != null
				&& StringUtils.isNotEmpty(pq.getValue().getValue());
	}

	/**
	 * <div class="en">Convert an eivlts to a String of the choosen
	 * language</div>
	 *
	 * @param languageCode
	 *            language of translation
	 * @param eivlts
	 *            format of dosage intake
	 * @return eivlts to string
	 */
	public static String parseEivlTs(LanguageCode languageCode, EIVLTS eivlts) {
		resBundle = ResourceBundle.getBundle("Messages", new Locale(languageCode.getCodeValue()));

		if (eivlts == null) {
			return "";
		}
		String narrativText = "";
		IVLPQ offset = eivlts.getOffset();
		String eventText = "";
		String widthText = "";
		String lowText = "";
		String highText = "";
		if (offset != null) {
			List<JAXBElement<? extends PQ>> offsetElements = offset.getRest();

			for (JAXBElement<? extends PQ> offsetElement : offsetElements) {
				String elementName = offsetElement.getName().getLocalPart();
				if (elementName.equals("low")) {
					try {
						// we used the abs value because it's allways a positive
						// number (ex: <low value='-1' unit='h'/> = 1h before)
						lowText = Math.abs(Integer.parseInt(offsetElement.getValue().getValue()))
								+ " "
								+ Objects
										.requireNonNull(UnitsOfTime
												.getEnum(offsetElement.getValue().getUnit()))
										.getDisplayName(languageCode);
					} catch (Exception e) {
						// an exception can be catched when there is a parsing
						// problem.
						e.printStackTrace();
					}
				}

				if (elementName.equals("high")) {
					try {
						// we used the abs value because it's allways a positive
						// number (ex: <low value='-1' unit='h'/> = 1h before)
						highText = Math.abs(Integer.parseInt(offsetElement.getValue().getValue()))
								+ " "
								+ Objects
										.requireNonNull(UnitsOfTime
												.getEnum(offsetElement.getValue().getUnit()))
										.getDisplayName(languageCode);
					} catch (Exception e) {
						// an exception can be catched when there is a parsing
						// problem.
						e.printStackTrace();
					}
				}
				if (elementName.equals("width")) {
					try {
						widthText = resBundle.getString("emed.during") + " "
								+ offsetElement.getValue().getValue() + " "
								+ Objects
										.requireNonNull(UnitsOfTime
												.getEnum(offsetElement.getValue().getUnit()))
										.getDisplayName(languageCode);
					} catch (Exception e) {
						// an exception can be catched when there is a parsing
						// problem.
						e.printStackTrace();
					}
				}
			}
		}

		if (eivlts.getEvent() != null && eivlts.getEvent().getCode() != null) {
			eventText = Objects
					.requireNonNull(ChEmedTimingEvent.getEnum(eivlts.getEvent().getCode()))
					.getDisplayName(languageCode);
		}

		if (lowText.length() > 0) {
			narrativText += lowText + " ";
		}
		if (highText.length() > 0) {
			if (narrativText.length() > 0) {
				narrativText += "- ";
			}
			narrativText += highText + " ";
		}

		if (eventText.length() > 0) {
			narrativText += eventText;
		}
		if (widthText.length() > 0) {
			narrativText += " " + widthText;
		}
		return narrativText;

	}

	/**
	 * <div class="en">Convert an ivlpq to a String of the choosen
	 * language</div>
	 *
	 * @param ivlpq
	 *            format of dosage intake
	 * @return ivlpq to string formated
	 */
	static String parseIvlPq(IVLPQ ivlpq) {
		String narrativeText = "";
		if (ivlpq != null) {
			String unitGlobal = "";
			String valueText;
			if (StringUtils.isNotEmpty(ivlpq.getUnit()) && !ivlpq.getUnit().equals("1")) {
				unitGlobal = ivlpq.getUnit();
			}
			// if the value is directly in the doseQuantity element the unit can
			// only be in this element (not on low/high child element)
			if (StringUtils.isNotEmpty(ivlpq.getValue())) {
				valueText = ivlpq.getValue() + unitGlobal;
				return valueText;
			} else {
				String lowText = "";
				String highText = "";
				String centerText;
				for (JAXBElement<? extends PQ> doseQuantityElement : ivlpq.getRest()) {
					String elementName = doseQuantityElement.getName().getLocalPart();
					// check if it contain a value
					if (isNotEmptyPqValue(doseQuantityElement)) {
						switch (elementName) {
						case "low":
							lowText = doseQuantityElementToString(doseQuantityElement, unitGlobal);
							break;
						case "high":
							highText = doseQuantityElementToString(doseQuantityElement, unitGlobal);
							break;
						case "center":
							centerText = doseQuantityElementToString(doseQuantityElement,
									unitGlobal);

							// if there is a ceter value its should not have low
							// or high value
							return centerText;
						}
					}

				}

				if (StringUtils.isNotEmpty(lowText) && StringUtils.isNotEmpty(highText)) {
					return lowText + " - " + highText;
				} else if (StringUtils.isNotEmpty(lowText)) {
					return lowText;
				} else {
					return "";
				}
			}
		}
		return narrativeText;
	}

	/**
	 * <div class="en">Convert an ivlts to a String of the choosen
	 * language</div>
	 *
	 * @param ivlts
	 *            format of dosage intake
	 * @param languageCode
	 *            language of translation
	 * @return ivlts to string translated
	 */
	private static String parseIvlTs(IVLTS ivlts, LanguageCode languageCode) {
		resBundle = ResourceBundle.getBundle("Messages", new Locale(languageCode.getCodeValue()));

		String narrativeText = "";
		if (ivlts != null) {
			String lowText = "";
			String highText = "";
			String widthText = "";
			for (JAXBElement<? extends QTY> ivltsElement : ivlts.getRest()) {
				String elementName = ivltsElement.getName().getLocalPart();
				String valueCrt = "";
				if (elementName.equals("low") || elementName.equals("high")) {
					if (ivltsElement.getValue() instanceof PQ) {
						valueCrt = ((PQ) ivltsElement.getValue()).getValue();
					} else if (ivltsElement.getValue() instanceof TS) {
						valueCrt = ((TS) ivltsElement.getValue()).getValue();
					}
				}

				if (StringUtils.isNotEmpty(valueCrt)) {
					valueCrt = dateToCompletDateString(DateUtil.parseHl7Timestamp(valueCrt),
							languageCode);
				}
				if (elementName.equals("low") && StringUtils.isNotEmpty(valueCrt)) {
					lowText = resBundle.getString("emed.from") + " " + valueCrt;
				} else if (elementName.equals("high") && StringUtils.isNotEmpty(valueCrt)) {
					highText = resBundle.getString("emed.to") + " " + valueCrt;
				} else if (elementName.equals("width")) {
					PQ width = (PQ) ivltsElement.getValue();
					if (width.getValue() != null)
						widthText = resBundle.getString("emed.during") + " " + width.getValue()
								+ " " + Objects.requireNonNull(UnitsOfTime.getEnum(width.getUnit()))
										.getDisplayName(languageCode);
				}

			}

			if (StringUtils.isNotEmpty(lowText)) {
				narrativeText = lowText;
			}
			if (StringUtils.isNotEmpty(highText)) {
				if (StringUtils.isNotEmpty(narrativeText))
					narrativeText += " ";
				narrativeText += highText;
			}
			if (StringUtils.isNotEmpty(widthText)) {
				if (StringUtils.isNotEmpty(narrativeText))
					narrativeText += " ";
				narrativeText += widthText;
			}
		}
		return narrativeText;

	}

	/**
	 * <div class="en">Convert an pivlts to a String of the choosen
	 * language</div>
	 *
	 * @param languageCode
	 *            language of translation
	 * @param pivlts
	 *            format of dosage intake
	 * @return pivlts formated in string
	 */
	public static String parsePivlTs(LanguageCode languageCode, PIVLTS pivlts) {
		resBundle = ResourceBundle.getBundle("Messages", new Locale(languageCode.getCodeValue()));

		String narrativText;
		Integer periodValue = Integer.parseInt(pivlts.getPeriod().getValue());
		String periodUnit = pivlts.getPeriod().getUnit();
		UnitsOfTime unitsOfTime = UnitsOfTime.getEnum(periodUnit);
		assert unitsOfTime != null;
		if (pivlts.isInstitutionSpecified()) {
			if (periodValue >= 1) {
				narrativText = (unitsOfTime.getUnitTimed() / periodValue) + "x "
						+ resBundle.getString("emed.per") + " " + Objects
								.requireNonNull(unitsOfTime.getNext()).getDisplayName(languageCode);
			} else {
				narrativText = (1.0 / periodValue) + resBundle.getString("emed.per") + " "
						+ unitsOfTime.getDisplayName(languageCode);
			}
		} else {
			narrativText = resBundle.getString("emed.each") + " " + periodValue + " "
					+ unitsOfTime.getDisplayName(languageCode);
			if (pivlts.getPhase() != null) {
				IVLTS phase = pivlts.getPhase();
				String lowText = "";
				String widthText = "";
				for (JAXBElement<? extends QTY> phaseElement : phase.getRest()) {
					String elementName = phaseElement.getName().getLocalPart();
					if (elementName.equals("low")) {
						try {
							TS lowValue = (TS) phaseElement.getValue();
							final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

							lowText = sdf.format(DateUtil.parseHl7Timestamp(lowValue));
						} catch (Exception e) {
							// an exception can be catched when there is a
							// parsing problem.
							e.printStackTrace();
						}
					}

					// there is no high value (only the lower order components
					// of this value are relevant with respect to the <period>)
					else if (elementName.equals("width")) {
						PQ width = (PQ) phaseElement.getValue();
						widthText = resBundle.getString("emed.during") + " " + width.getValue()
								+ " " + Objects.requireNonNull(UnitsOfTime.getEnum(width.getUnit()))
										.getDisplayName(languageCode);
					}
				}

				if (StringUtils.isNotEmpty(lowText)) {
					narrativText += " " + resBundle.getString("emed.at") + " " + lowText;
				}
				if (StringUtils.isNotEmpty(widthText)) {
					narrativText += " " + widthText;
				}
			}

		}
		return narrativText;
	}

	/**
	 * <div class="en">Convert an ivlpq rateQuantity formated to a String of the
	 * choosen language</div>
	 *
	 * @param ivlpq
	 *            format of dosage intake
	 * @return ivlpq to rate quantity string format
	 */
	private static String parseRateQuantity(IVLPQ ivlpq) {
		String narrativeText = "";
		if (ivlpq != null) {
			String unitGlobal = "";
			if (StringUtils.isNotEmpty(ivlpq.getUnit()) && !ivlpq.getUnit().equals("1")) {
				unitGlobal = ivlpq.getUnit();
			}
			// if the value is directly in the doseQuantity element the unit can
			// only be in this element (not on low/high child element)
			if (StringUtils.isNotEmpty(ivlpq.getValue())) {
				return ivlpq.getValue() + "/" + unitGlobal;
			} else {
				String lowText = "";
				String highText = "";
				String centerText;
				for (JAXBElement<? extends PQ> doseQuantityElement : ivlpq.getRest()) {
					String elementName = doseQuantityElement.getName().getLocalPart();
					// check if it contain a value
					if (isNotEmptyPqValue(doseQuantityElement)) {
						switch (elementName) {
						case "low":
							lowText = rateQuantityElementToString(doseQuantityElement, unitGlobal);
							break;
						case "high":
							highText = rateQuantityElementToString(doseQuantityElement, unitGlobal);
							break;
						case "center":
							centerText = rateQuantityElementToString(doseQuantityElement,
									unitGlobal);

							// if there is a ceter value its should not have low
							// or high value
							return centerText;
						}
					}

				}

				if (StringUtils.isNotEmpty(lowText) && StringUtils.isNotEmpty(highText)) {
					return lowText + " - " + highText;
				} else if (StringUtils.isNotEmpty(lowText)) {
					return lowText;
				} else {
					return "";
				}
			}
		}
		return narrativeText;
	}

	/**
	 * <div class="en">Get splited dosageIntake in an array of string</div>
	 *
	 * @param substanceAdministration
	 *            the substanceAdministration
	 * @param languageCode
	 *            codes are going to be translated to this language
	 * @return the list of string that represent all the dosages intake
	 */
	public static List<String> parseSplitedDosageIntake(
			POCDMT000040SubstanceAdministration substanceAdministration,
			LanguageCode languageCode) {
		resBundle = ResourceBundle.getBundle("Messages", new Locale(languageCode.getCodeValue()));

		List<String> dosageIntakes = new ArrayList<>();
		if (substanceAdministration != null
				&& substanceAdministration.getEntryRelationship() != null) {

			List<POCDMT000040EntryRelationship> relationships = substanceAdministration
					.getEntryRelationship().stream()
					.filter(pocdmt000040EntryRelationship -> pocdmt000040EntryRelationship
							.getTypeCode() != null)
					.filter(pocdmt000040EntryRelationship -> pocdmt000040EntryRelationship
							.getTypeCode().value().equals("COMP"))
					.collect(Collectors.toList());

			for (POCDMT000040EntryRelationship entryRelationship : relationships) {
				POCDMT000040SubstanceAdministration substanceAdministrationCrt = entryRelationship
						.getSubstanceAdministration();

				EIVLTS eivltsCrt = null;
				String eivltsCrtStr;
				if (substanceAdministrationCrt != null
						&& substanceAdministrationCrt.getEffectiveTime() != null) {
					eivltsCrt = (EIVLTS) substanceAdministrationCrt.getEffectiveTime().stream()
							.filter(sxcmts -> sxcmts instanceof EIVLTS).findFirst().orElse(null);
				}
				if (eivltsCrt == null) {
					continue;
				}
				eivltsCrtStr = parseEivlTs(languageCode, eivltsCrt);

				String seqNumber = entryRelationship.getSequenceNumber() != null
						? entryRelationship.getSequenceNumber().getValue().toString()
						: "";
				String doseQuantityStr = parseIvlPq(substanceAdministrationCrt.getDoseQuantity());

				String rateQuantityStr = parseRateQuantity(
						substanceAdministrationCrt.getRateQuantity());
				if (StringUtils.isNotEmpty(rateQuantityStr)) {
					rateQuantityStr = ", "
							+ EmedTextNarrativeAttributes.RATE_QUANTITY.getDisplayName(languageCode)
							+ " : " + rateQuantityStr;
				}
				String dosageIntakeStrCrt = String.format("%s) %s %s%s", seqNumber, doseQuantityStr,
						eivltsCrtStr, rateQuantityStr);
				dosageIntakes.add(dosageIntakeStrCrt);
			}
		}
		return dosageIntakes;

	}

	/**
	 * <div class="en">Convert an sxprts to a String of the choosen
	 * language</div>
	 *
	 * @param languageCode
	 *            language of translation
	 * @param sxprts
	 *            format of dosage intake
	 * @return sxprts to string translated
	 */
	public static String parseSxprTs(LanguageCode languageCode, SXPRTS sxprts) {
		resBundle = ResourceBundle.getBundle("Messages", new Locale(languageCode.getCodeValue()));
		String AND_STRING = " " + resBundle.getString("emed.and") + " ";
		String textNarrativ = "";
		boolean notAddAnd = false;
		for (SXCMTS sxcmts : sxprts.getComp()) {
			if (sxcmts instanceof IVLTS) {
				textNarrativ = parseIvlTs((IVLTS) sxcmts, languageCode) + ": ";
				notAddAnd = true;
			} else if (sxcmts instanceof SXPRTS) {
				if (StringUtils.isNotEmpty(textNarrativ) && !notAddAnd)
					textNarrativ += AND_STRING;
				textNarrativ += parseSxprTs(languageCode, (SXPRTS) sxcmts);
				notAddAnd = false;
			} else if (sxcmts instanceof EIVLTS) {
				if (StringUtils.isNotEmpty(textNarrativ) && !notAddAnd)
					textNarrativ += AND_STRING;
				textNarrativ += parseEivlTs(languageCode, (EIVLTS) sxcmts);
				notAddAnd = false;
				// in case of a TS
			} else if (sxcmts != null) {
				if (StringUtils.isNotEmpty(textNarrativ) && !notAddAnd)
					textNarrativ += AND_STRING;
				textNarrativ += parseTs(languageCode, sxcmts);
				notAddAnd = false;
			}

		}
		return textNarrativ;
	}

	/**
	 * <div class="en">Convert a TS to a string</div>
	 *
	 * @param languageCode
	 *            language for translation
	 * @param ts
	 *            A quantity specifying a point on the axis of natural
	 * @return ts to string translated
	 */
	public static String parseTs(LanguageCode languageCode, TS ts) {

		String date = null;
		try {
			date = dateToCompletDateString(DateUtil.parseHl7Timestamp(ts.getValue()), languageCode);

		} catch (Exception e) {
			// an exception can be catched when there is a parsing problem.
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * <div class="en">Convert a rateQuantity to a string</div>
	 *
	 * @param doseQuantityElement
	 *            a doseQuantityElement
	 * @param unitGlobal
	 *            an unit
	 * @return tranformed rate quantity to string
	 */
	private static String rateQuantityElementToString(JAXBElement<? extends PQ> doseQuantityElement,
			String unitGlobal) {
		String str;
		str = doseQuantityElement.getValue().getValue() + "/";
		if (isNotEmptyPqUnit(doseQuantityElement)) {
			str += doseQuantityElement.getValue().getUnit();
		} else {
			str += unitGlobal;
		}
		return str;
	}

	/** approachSiteList to add to the narrative text table */
	private final List<StrucDocTd> approachSiteList = new ArrayList<>();
	/** commentList to add to the narrative text table */
	private final List<StrucDocTd> commentList = new ArrayList<>();
	/** dateFromToList to add to the narrative text table */
	private final List<StrucDocTd> dateFromToList = new ArrayList<>();
	/** dispenseAmountList to add to the narrative text table */
	private final List<StrucDocTd> dispenseAmountList = new ArrayList<>();
	/** dosageIntakesList to add to the narrative text table */
	private final List<StrucDocTd> dosageIntakesList = new ArrayList<>();
	/** doseQuantityList to add to the narrative text table */
	private final List<StrucDocTd> doseQuantityList = new ArrayList<>();
	/*** the ObjectFactory **/
	private final ObjectFactory factory = new ObjectFactory();
	/** fulfillmentInstructionsList to add to the narrative text table */
	private final List<StrucDocTd> fulfillmentInstructionsList = new ArrayList<>();
	/** gtinList to add to the narrative text table */
	private final List<StrucDocTd> gtinList = new ArrayList<>();
	/** ingredientsList to add to the narrative text table */
	private final List<StrucDocTd> ingredientsList = new ArrayList<>();
	/** languageCode of the document */
	private final LanguageCode languageCode;
	/** lotNumberList to add to the narrative text table */
	private final List<StrucDocTd> lotNumberList = new ArrayList<>();
	/** Title and headers of each table of the narative text */
	private final List<NarrativeTableInfos> narrativeTableInfosList = new ArrayList<>();
	/** packageCapacityList to add to the narrative text table */
	private final List<StrucDocTd> packageCapacityList = new ArrayList<>();
	/** packageFormList to add to the narrative text table */
	private final List<StrucDocTd> packageFormList = new ArrayList<>();
	/** packageNameList to add to the narrative text table */
	private final List<StrucDocTd> packageNameList = new ArrayList<>();
	/** hashmap of original text by the headers */
	private final HashMap<String, List<StrucDocTd>> paramNameToValues = new HashMap<>();
	/** patientInstructionsList to add to the narrative text table */
	private final List<StrucDocTd> patientInstructionsList = new ArrayList<>();
	/** rateQuantityList to add to the narrative text table */
	private final List<StrucDocTd> rateQuantityList = new ArrayList<>();
	/** reasonList to add to the narrative text table */
	private final List<StrucDocTd> reasonList = new ArrayList<>();
	/** repeatNumberList to add to the narrative text table */
	private final List<StrucDocTd> repeatNumberList = new ArrayList<>();
	/** routeCodeList to add to the narrative text table */
	private final List<StrucDocTd> routeCodeList = new ArrayList<>();
	/**
	 * Current section
	 */
	private final POCDMT000040Section section;

	private final List<StrucDocTd> substitutionList = new ArrayList<>();

	/** The variable approachSite for narrativ text */
	private String approachSite = "-";

	/** The variable comment for narrativ text */
	private String comment = "-";

	/** The variable dateFromTo for narrativ text */
	private String dateFromTo = "-";

	/** The variable dispenseAmount for narrativ text */
	private String dispenseAmount = "-";

	/** The variable dosageIntakes for narrativ text */
	private List<String> dosageIntakes = new ArrayList<>();

	/** The variable doseQuantity for narrativ text */
	private String doseQuantity = "-";

	/** current emed class */
	private String emedClass;

	/** Current entry */
	private POCDMT000040Entry entry;

	/** The variable fulfillmentInstructions for narrativ text */
	private String fulfillmentInstructions = "-";

	/** The variable gtin for narrativ text */
	private String gtin = "-";

	/** The list of variable ingredients for narrativ text */
	private List<String> ingredients = new ArrayList<>();

	/** The variable lotNumber for narrativ text */
	private String lotNumber = "-";

	/** The variable packageCapacity for narrativ text */
	private String packageCapacity = "-";

	/** The variable packageForm for narrativ text */
	private String packageForm = "-";

	/** The variable packageName for narrativ text */
	private String packageName = "-";

	/** The variable patientInstructions for narrativ text */
	private String patientInstructions = "-";

	/** The variable rateQuantity for narrativ text */
	private String rateQuantity = "-";

	/** The variable reason for narrativ text */
	private String reason = "-";

	/** The variable repeatNumber for narrativ text */
	private String repeatNumber = "-";

	/** The variable routeCode for narrativ text */
	private String routeCode = "-";

	/**
	 * used for the id to know the current number of rows
	 */
	private int rowCrt = 0;

	/** The variable substitution for narrativ text */
	private String substitution = "-";

	/**
	 * <div class="en"> Principal constructor for
	 * EmedChStrucDocTextBuilder</div>
	 *
	 * @param section
	 *            section to add narative text
	 * @param languageCode
	 *            lang of the document
	 * @param contentIdStr
	 *            set the Id of the document
	 */
	public EmedChStrucDocTextBuilderV096(POCDMT000040Section section, LanguageCode languageCode,
			String contentIdStr) {
		this.languageCode = languageCode;
		// language of the narrative text
		final String languageCodeStr = languageCode.getCodeValue();
		resBundle = ResourceBundle.getBundle("Messages", new Locale(languageCodeStr));
		String sectionCode = section.getCode().getCode();
		AtomicReference<String> padvType = new AtomicReference<>("");
		// In function of the document type it will generate a differente
		// narrativeText
		if (sectionCode.contentEquals(CdaChUtil.MTP_SECTION_CODE)) {
			this.emedClass = "MTP";
			NarrativeTableInfos narrativeTableInfosImportantInfos = new NarrativeTableInfos(
					resBundle.getString("emed.title." + IMPORTANT_INFO_TAG),
					new String[] { EmedTextNarrativeAttributes.PACKAGE_NAME.getCodeValue(),
							EmedTextNarrativeAttributes.DATE_FROM_TO.getCodeValue(),
							EmedTextNarrativeAttributes.FREQUENCY.getCodeValue(),
							EmedTextNarrativeAttributes.DOSE_QUANTITY.getCodeValue(),
							EmedTextNarrativeAttributes.RATE_QUANTITY.getCodeValue(),
							EmedTextNarrativeAttributes.REASON.getCodeValue(),
							EmedTextNarrativeAttributes.PATIENT_INSTRUCTIONS.getCodeValue(),
							EmedTextNarrativeAttributes.DISPENSE_AMOUNT.getCodeValue() });

			NarrativeTableInfos narrativeTableInfosComplementaryInfos = new NarrativeTableInfos(
					resBundle.getString("emed.title." + COMPLEMENTARY_INFO_TAG),
					new String[] { EmedTextNarrativeAttributes.DOSE_FORM.getCodeValue(),
							EmedTextNarrativeAttributes.LOT_NUMBER.getCodeValue(),
							EmedTextNarrativeAttributes.PACKAGE_CAPACITY.getCodeValue(),
							EmedTextNarrativeAttributes.INGREDIENTS.getCodeValue(),
							EmedTextNarrativeAttributes.ROUTE_CODE.getCodeValue(),
							EmedTextNarrativeAttributes.APPROACH_SITE.getCodeValue(),
							EmedTextNarrativeAttributes.FULFILMENT_INSTRUCTIONS.getCodeValue(),
							EmedTextNarrativeAttributes.SUBSTITUTION.getCodeValue(),
							EmedTextNarrativeAttributes.GTIN.getCodeValue() });

			narrativeTableInfosList.add(narrativeTableInfosImportantInfos);
			narrativeTableInfosList.add(narrativeTableInfosComplementaryInfos);
		}
		// PRE
		else if (sectionCode.contentEquals(CdaChUtil.PRE_SECTION_CODE)) {
			this.emedClass = "PRE";

			NarrativeTableInfos narrativeTableInfosImportantInfos = new NarrativeTableInfos("",
					new String[] { EmedTextNarrativeAttributes.DATE_FROM_TO.getCodeValue(),
							EmedTextNarrativeAttributes.PACKAGE_NAME.getCodeValue(),
							EmedTextNarrativeAttributes.GTIN.getCodeValue(),
							EmedTextNarrativeAttributes.DOSE_FORM.getCodeValue(),
							EmedTextNarrativeAttributes.LOT_NUMBER.getCodeValue(),
							EmedTextNarrativeAttributes.FREQUENCY.getCodeValue(),
							EmedTextNarrativeAttributes.ROUTE_CODE.getCodeValue(),
							EmedTextNarrativeAttributes.APPROACH_SITE.getCodeValue(),
							EmedTextNarrativeAttributes.DOSE_QUANTITY.getCodeValue(),
							EmedTextNarrativeAttributes.RATE_QUANTITY.getCodeValue(),
							EmedTextNarrativeAttributes.REASON.getCodeValue(),
							EmedTextNarrativeAttributes.PATIENT_INSTRUCTIONS.getCodeValue(),
							EmedTextNarrativeAttributes.FULFILMENT_INSTRUCTIONS.getCodeValue(),
							EmedTextNarrativeAttributes.DISPENSE_AMOUNT.getCodeValue(),
							EmedTextNarrativeAttributes.SUBSTITUTION.getCodeValue() });

			narrativeTableInfosList.add(narrativeTableInfosImportantInfos);
		}
		// PADV
		else if (sectionCode.contentEquals(CdaChUtil.PADV_SECTION_CODE)) {
			this.emedClass = "PADV";
			List<String> listOfTemplatesIdsPADVRefs = new ArrayList<>();
			listOfTemplatesIdsPADVRefs.add("2.16.756.5.30.1.1.10.4.45");
			listOfTemplatesIdsPADVRefs.add("2.16.756.5.30.1.1.10.4.47");
			listOfTemplatesIdsPADVRefs.add("2.16.756.5.30.1.1.10.4.46");

			Optional.ofNullable(section.getEntry())
					.map(entries -> (entries.size() > 0) ? entries.get(0) : null)
					.map(POCDMT000040Entry::getObservation)
					.filter(observation -> observation.getCode() != null
							&& observation.getCode().getCode() != null)
					.map(POCDMT000040Observation::getEntryRelationship)
					.flatMap(relationships -> relationships.stream().filter(
							relationship -> relationship.getSubstanceAdministration() != null
									&& isAnyTemplateIdInList(listOfTemplatesIdsPADVRefs,
											relationship.getSubstanceAdministration()
													.getTemplateId()))
							.findAny())
					.map(POCDMT000040EntryRelationship::getSubstanceAdministration)
					.map(POCDMT000040SubstanceAdministration::getCode).map(CD::getCode)
					.map(codeRef -> {
						String codeStringLowerCase = section.getEntry().get(0).getObservation()
								.getCode().getCode().toLowerCase();
						if (codeStringLowerCase.contains("ok")
								|| codeStringLowerCase.contains("suspend")
								|| codeStringLowerCase.contains("cancel")
								|| codeStringLowerCase.contains("refuse")) {
							String messageKey = "emed.padv."
									+ codeRef.replace("Item", "").toLowerCase() + "."
									+ codeStringLowerCase;
							return new NarrativeTableInfos(resBundle.getString(messageKey),
									new String[] {});
						} else if (codeStringLowerCase.contains("comment")) {
							padvType.set("comment");
							return new NarrativeTableInfos(resBundle.getString("emed.padv.comment"),
									new String[] {
											EmedTextNarrativeAttributes.COMMENT.getCodeValue() });
						} else if (codeStringLowerCase.contains("change")) {
							padvType.set("change");
							String messageKey = "emed.padv."
									+ codeRef.replace("Item", "").toLowerCase() + "."
									+ codeStringLowerCase;
							return new NarrativeTableInfos(resBundle.getString(messageKey),
									new String[] {
											EmedTextNarrativeAttributes.DATE_FROM_TO.getCodeValue(),
											EmedTextNarrativeAttributes.FREQUENCY.getCodeValue(),
											EmedTextNarrativeAttributes.DOSE_QUANTITY
													.getCodeValue(),
											EmedTextNarrativeAttributes.RATE_QUANTITY
													.getCodeValue(),
											EmedTextNarrativeAttributes.FULFILMENT_INSTRUCTIONS
													.getCodeValue(),
											EmedTextNarrativeAttributes.PATIENT_INSTRUCTIONS
													.getCodeValue(),
											EmedTextNarrativeAttributes.REPEAT.getCodeValue(),
											EmedTextNarrativeAttributes.DISPENSE_AMOUNT
													.getCodeValue() });

						} else {
							return null;
						}
					}).ifPresent(narrativeTableInfosList::add);
		}
		// DIS
		else if (sectionCode.contentEquals(CdaChUtil.DIS_SECTION_CODE)) {
			this.emedClass = "DIS";
			NarrativeTableInfos narrativeTableInfosImportantInfos = new NarrativeTableInfos("",
					new String[] { EmedTextNarrativeAttributes.PACKAGE_NAME.getCodeValue(),
							EmedTextNarrativeAttributes.DOSE_FORM.getCodeValue(),
							EmedTextNarrativeAttributes.LOT_NUMBER.getCodeValue(),
							EmedTextNarrativeAttributes.PACKAGE_CAPACITY.getCodeValue(),
							EmedTextNarrativeAttributes.INGREDIENTS.getCodeValue(),
							EmedTextNarrativeAttributes.DATE_FROM_TO.getCodeValue(),
							EmedTextNarrativeAttributes.FREQUENCY.getCodeValue(),
							EmedTextNarrativeAttributes.DOSE_QUANTITY.getCodeValue(),
							EmedTextNarrativeAttributes.RATE_QUANTITY.getCodeValue(),
							EmedTextNarrativeAttributes.COMMENT.getCodeValue(),
							EmedTextNarrativeAttributes.PATIENT_INSTRUCTIONS.getCodeValue(),
							EmedTextNarrativeAttributes.DISPENSE_AMOUNT.getCodeValue() });
			narrativeTableInfosList.add(narrativeTableInfosImportantInfos);
		}

		this.section = section;
		initParamNameToValues();
		if (padvType.get().contains("comment")) {
			if (section.getEntry() != null && section.getEntry().size() > 0) {
				for (POCDMT000040Entry entry : section.getEntry()) {
					this.entry = entry;
					setPadvNarrativeComment();
				}
			}
		} else if (padvType.get().contains("change")) {
			if (section.getEntry() != null && section.getEntry().size() > 0) {
				for (POCDMT000040Entry entry : section.getEntry()) {
					this.entry = entry;
					this.setPadvChangeNarrativeText();
				}

			}
		} else if (emedClass.equals("DIS")) {
			if (section.getEntry() != null && section.getEntry().size() > 0) {
				for (POCDMT000040Entry entry : section.getEntry()) {
					this.entry = entry;
					setDisNarrativeText();
				}
			}
		} else {
			if (section.getEntry() != null && section.getEntry().size() > 0) {
				for (POCDMT000040Entry entry : section.getEntry()) {
					this.entry = entry;
					setNarrativeParameters();
					rowCrt++;
				}
			}
		}

		addNarrativeTablesInfos(this);

		this.setID(contentIdStr);
		this.setLanguage(languageCodeStr);

	}

	/**
	 * <div class="en"> Add the the reference of the dosageIntake</div>
	 */
	private void addDosageIntakeReference() {

		if (this.entry != null && this.entry.getSubstanceAdministration() != null
				&& this.entry.getSubstanceAdministration().getEntryRelationship() != null) {
			POCDMT000040EntryRelationship pocdmt000040EntryRelationship = new POCDMT000040EntryRelationship();
			DosageIntakeModeEntryContentModule dosageIntakeModeEntryContentModule = new DosageIntakeModeEntryContentModule();
			ED ed = new ED();
			setReferenceAndGetXmlContent(ed, EmedTextNarrativeAttributes.FREQUENCY.getCodeValue());
			dosageIntakeModeEntryContentModule.setHl7Text(ed);
			pocdmt000040EntryRelationship
					.setSubstanceAdministration(dosageIntakeModeEntryContentModule);
			this.entry.getSubstanceAdministration().getEntryRelationship()
					.add(pocdmt000040EntryRelationship);
		}
	}

	/**
	 * <div class="en">create all the attributes for the narrativeTable with all
	 * the values getted before</div>
	 *
	 * @param strucDocContent
	 *            content of the narrativeText
	 */
	private void addNarrativeTablesInfos(StrucDocText strucDocContent) {

		for (NarrativeTableInfos narrativeTableInfos : narrativeTableInfosList) {

			StrucDocParagraph strucDocTitleTable = factory.createStrucDocParagraph();
			strucDocTitleTable.getContent().add(narrativeTableInfos.getTableTitle());
			JAXBElement jaxbTitle = new JAXBElement<>(new QName("urn:hl7-org:v3", "content"),
					StrucDocParagraph.class, strucDocTitleTable);
			strucDocContent.getContent().add(jaxbTitle);
			if (narrativeTableInfos.getTableColParams().size() > 0) {
				StrucDocTable strucDocTable = factory.createStrucDocTable();

				StrucDocThead strucDocThead = factory.createStrucDocThead();
				StrucDocTr strucDocTr = factory.createStrucDocTr();
				strucDocThead.getTr().add(strucDocTr);
				StrucDocTh strucDocTh;

				StrucDocTbody strucDocTbody = factory.createStrucDocTbody();
				strucDocTable.setThead(strucDocThead);
				strucDocTable.getTbody().add(strucDocTbody);

				for (String column : narrativeTableInfos.getTableColParams()) {
					strucDocTh = factory.createStrucDocTh();
					strucDocTh.getContent()
							.add(Objects
									.requireNonNull(EmedTextNarrativeAttributes
											.getEnum(column + "_" + this.emedClass.toLowerCase()))
									.getDisplayName(languageCode));
					strucDocTr.getThOrTd().add(strucDocTh);
				}
				int nbRow = section.getEntry().size();
				StrucDocTr strucDocBodyTr;
				StrucDocTd strucDocTdCrt;
				for (int i = 0; i < nbRow; i++) {
					strucDocBodyTr = factory.createStrucDocTr();
					strucDocTbody.getTr().add(strucDocBodyTr);
					for (String column : narrativeTableInfos.getTableColParams()) {
						strucDocTdCrt = paramNameToValues.get(column).get(i);
						strucDocBodyTr.getThOrTd().add(strucDocTdCrt);
					}
				}

				JAXBElement jaxbStrucDocTable = new JAXBElement<>(
						new QName("urn:hl7-org:v3", "table"), StrucDocTable.class, strucDocTable);
				strucDocContent.getContent().add(jaxbStrucDocTable);
			}

		}

	}

	/**
	 * <div class="en"> Add the values from the current entry</div>
	 */
	private void addParamNameToValues() {
		packageNameList.add(createTd(this.packageName,
				EmedTextNarrativeAttributes.PACKAGE_NAME.getCodeValue()));
		dateFromToList.add(
				createTd(this.dateFromTo, EmedTextNarrativeAttributes.DATE_FROM_TO.getCodeValue()));
		dosageIntakesList.add(
				createTd(this.dosageIntakes, EmedTextNarrativeAttributes.FREQUENCY.getCodeValue()));
		doseQuantityList.add(createTd(this.doseQuantity,
				EmedTextNarrativeAttributes.DOSE_QUANTITY.getCodeValue()));
		rateQuantityList.add(createTd(this.rateQuantity,
				EmedTextNarrativeAttributes.RATE_QUANTITY.getCodeValue()));
		reasonList.add(createTd(this.reason, EmedTextNarrativeAttributes.REASON.getCodeValue()));
		patientInstructionsList.add(createTd(this.patientInstructions,
				EmedTextNarrativeAttributes.PATIENT_INSTRUCTIONS.getCodeValue()));
		dispenseAmountList.add(createTd(this.dispenseAmount,
				EmedTextNarrativeAttributes.DISPENSE_AMOUNT.getCodeValue()));

		packageFormList.add(
				createTd(this.packageForm, EmedTextNarrativeAttributes.DOSE_FORM.getCodeValue()));
		lotNumberList.add(
				createTd(this.lotNumber, EmedTextNarrativeAttributes.LOT_NUMBER.getCodeValue()));
		packageCapacityList.add(createTd(this.packageCapacity,
				EmedTextNarrativeAttributes.PACKAGE_CAPACITY.getCodeValue()));
		ingredientsList.add(
				createTd(this.ingredients, EmedTextNarrativeAttributes.INGREDIENTS.getCodeValue()));
		routeCodeList.add(
				createTd(this.routeCode, EmedTextNarrativeAttributes.ROUTE_CODE.getCodeValue()));
		approachSiteList.add(createTd(this.approachSite,
				EmedTextNarrativeAttributes.APPROACH_SITE.getCodeValue()));
		fulfillmentInstructionsList.add(createTd(this.fulfillmentInstructions,
				EmedTextNarrativeAttributes.FULFILMENT_INSTRUCTIONS.getCodeValue()));
		substitutionList.add(createTd(this.substitution,
				EmedTextNarrativeAttributes.SUBSTITUTION.getCodeValue()));
		gtinList.add(createTd(this.gtin, EmedTextNarrativeAttributes.GTIN.getCodeValue()));
		commentList.add(createTd(this.comment, EmedTextNarrativeAttributes.COMMENT.getCodeValue()));
		repeatNumberList.add(
				createTd(this.repeatNumber, EmedTextNarrativeAttributes.REPEAT.getCodeValue()));

	}

	/**
	 * <div class="en">Generate a strucDocTd with list of String choice and add
	 * an idRef</div>
	 *
	 * @param textList
	 *            list of text
	 * @param idReference
	 *            the idReference
	 * @return the StrucDocTd
	 */
	private StrucDocTd createTd(List<String> textList, String idReference) {
		StrucDocTd strucDocTd = factory.createStrucDocTd();
		strucDocTd.setID(emedClass + "." + idReference + "." + this.rowCrt);
		for (String textCrt : textList) {
			JAXBElement jaxbElementStrucDocBr = new JAXBElement<>(new QName("urn:hl7-org:v3", "br"),
					StrucDocBr.class, factory.createStrucDocBr());
			strucDocTd.getContent().add(textCrt);
			strucDocTd.getContent().add(jaxbElementStrucDocBr);
		}
		return strucDocTd;
	}

	/**
	 * <div class="en">Generate a strucDocTd with the text for choice and add an
	 * idRef</div>
	 *
	 * @param text
	 *            the text
	 * @param idReference
	 *            the idReference
	 * @return the StrucDocTd
	 */
	private StrucDocTd createTd(String text, String idReference) {
		StrucDocTd strucDocTd = factory.createStrucDocTd();
		strucDocTd.getContent().add(text);
		strucDocTd.setID(emedClass + "." + idReference + "." + this.rowCrt);
		return strucDocTd;
	}

	/**
	 * <div class="en">Retrieve the originalText if it exists otherwise it
	 * retrieves the code and save the store the choosen reference</div>
	 *
	 * @param code
	 *            code to get the original text
	 * @param reference
	 *            reference to store in the originalText
	 * @return code or originalText if exist
	 */
	private String getCodeOrOriginalTextAndSetRef(CE code, String reference) {
		String codeValue = "-";
		if (code != null) {
			if (code.getOriginalText() != null
					&& StringUtils.isNotEmpty(code.getOriginalText().xmlContent)) {

				return getOriginalTextAndSetRef(code, reference);
			} else if (code.getCode() != null) {
				getOriginalTextAndSetRef(code, reference);
				ED ed = new ED();
				TEL referenceTel = new TEL();
				referenceTel.setValue("#" + this.emedClass + "." + reference + "." + this.rowCrt);
				ed.setReference(referenceTel);
				code.setOriginalText(ed);
				return code.getCode();
			}
		}
		return codeValue;
	}

	/**
	 * <div class="en"> Fetch the DosageIntakeText relationship if it
	 * exists</div>
	 *
	 * @param entryRelationships
	 *            list of entryRelationship
	 * @return dosage intake formated
	 */
	private String getDosageIntakeTextIfExist(
			List<POCDMT000040EntryRelationship> entryRelationships) {

		String dosageIntakeText = null;
		if (entryRelationships != null) {
			POCDMT000040SubstanceAdministration substanceAdministrationDosageIntakeText = entryRelationships
					.stream()
					.filter(pocdmt000040EntryRelationship -> pocdmt000040EntryRelationship
							.getSubstanceAdministration() != null)
					.filter(pocdmt000040EntryRelationship -> pocdmt000040EntryRelationship
							.getSubstanceAdministration().getTemplateId().stream()
							.anyMatch(templateId -> templateId.getRoot()
									.equals(DOSAGE_INTAKE_REFERENCE_TEMPLATE_ID)))
					.findFirst().map(POCDMT000040EntryRelationship::getSubstanceAdministration)
					.orElse(null);
			if (substanceAdministrationDosageIntakeText != null
					&& substanceAdministrationDosageIntakeText.getText() != null) {
				ED dosageIntakeEd = substanceAdministrationDosageIntakeText.getText();
				dosageIntakeText = setReferenceAndGetXmlContent(dosageIntakeEd,
						EmedTextNarrativeAttributes.FREQUENCY.getCodeValue());
			}
		}
		return dosageIntakeText;
	}

	/**
	 * <div class="en">Get the original text of a cd and set the reference
	 * id</div>
	 *
	 * @param cd
	 *            contains the originalText
	 * @param reference
	 *            id reference
	 * @return originalText
	 */
	private String getOriginalTextAndSetRef(CD cd, String reference) {
		if (cd != null && cd.getOriginalText() != null) {
			return setReferenceAndGetXmlContent(cd.getOriginalText(), reference);
		}
		return null;
	}

	/**
	 * <div class="en"> Init the paramNameToValues</div>
	 */
	private void initParamNameToValues() {
		paramNameToValues.put(EmedTextNarrativeAttributes.PACKAGE_NAME.getCodeValue(),
				packageNameList);
		paramNameToValues.put(EmedTextNarrativeAttributes.DATE_FROM_TO.getCodeValue(),
				dateFromToList);
		paramNameToValues.put(EmedTextNarrativeAttributes.FREQUENCY.getCodeValue(),
				dosageIntakesList);
		paramNameToValues.put(EmedTextNarrativeAttributes.DOSE_QUANTITY.getCodeValue(),
				doseQuantityList);
		paramNameToValues.put(EmedTextNarrativeAttributes.RATE_QUANTITY.getCodeValue(),
				rateQuantityList);
		paramNameToValues.put(EmedTextNarrativeAttributes.REASON.getCodeValue(), reasonList);
		paramNameToValues.put(EmedTextNarrativeAttributes.PATIENT_INSTRUCTIONS.getCodeValue(),
				patientInstructionsList);
		paramNameToValues.put(EmedTextNarrativeAttributes.DISPENSE_AMOUNT.getCodeValue(),
				dispenseAmountList);
		paramNameToValues.put(EmedTextNarrativeAttributes.DOSE_FORM.getCodeValue(),
				packageFormList);
		paramNameToValues.put(EmedTextNarrativeAttributes.LOT_NUMBER.getCodeValue(), lotNumberList);
		paramNameToValues.put(EmedTextNarrativeAttributes.PACKAGE_CAPACITY.getCodeValue(),
				packageCapacityList);
		paramNameToValues.put(EmedTextNarrativeAttributes.INGREDIENTS.getCodeValue(),
				ingredientsList);
		paramNameToValues.put(EmedTextNarrativeAttributes.ROUTE_CODE.getCodeValue(), routeCodeList);
		paramNameToValues.put(EmedTextNarrativeAttributes.APPROACH_SITE.getCodeValue(),
				approachSiteList);
		paramNameToValues.put(EmedTextNarrativeAttributes.FULFILMENT_INSTRUCTIONS.getCodeValue(),
				fulfillmentInstructionsList);
		paramNameToValues.put(EmedTextNarrativeAttributes.SUBSTITUTION.getCodeValue(),
				substitutionList);
		paramNameToValues.put(EmedTextNarrativeAttributes.GTIN.getCodeValue(), gtinList);
		paramNameToValues.put(EmedTextNarrativeAttributes.COMMENT.getCodeValue(), commentList);
		paramNameToValues.put(EmedTextNarrativeAttributes.REPEAT.getCodeValue(), repeatNumberList);
	}

	/**
	 * <div class="en">Parse substanceAdministration Change Dosage</div>
	 *
	 * @param substanceAdministration
	 *            a substanceAdministration
	 */
	private void parseChangeDosageInstruction(
			POCDMT000040SubstanceAdministration substanceAdministration) {
		if (substanceAdministration == null || substanceAdministration.getEffectiveTime() == null)
			return;
		for (SXCMTS sxcmts : substanceAdministration.getEffectiveTime()) {

			if (sxcmts instanceof PIVLTS) {
				this.dosageIntakes.add(parsePivlTs(this.languageCode, (PIVLTS) sxcmts));

			} else if (sxcmts instanceof EIVLTS) {
				this.dosageIntakes.add(parseEivlTs(this.languageCode, (EIVLTS) sxcmts));

			} else if (sxcmts instanceof SXPRTS) {
				this.dosageIntakes.add(parseSxprTs(this.languageCode, (SXPRTS) sxcmts));

			}
		}
		List<String> dosageIntakesCrt = parseSplitedDosageIntake(substanceAdministration,
				this.languageCode);

		if (dosageIntakesCrt.size() > 0) {
			this.dosageIntakes.addAll(dosageIntakesCrt);
		}
	}

	/**
	 * <div class="en">Tranform dosageIntake codes to a string that is going to
	 * be add in the narrative text</div>
	 *
	 * @param substanceAdministration
	 *            a substanceAdmnistration
	 */
	private void parseDosageIntake(POCDMT000040SubstanceAdministration substanceAdministration) {
		DosageType dosageType = null;
		for (II templateId : substanceAdministration.getTemplateId()) {
			if (templateId.getRoot().equals(MedicationTreatmentPlanEntryContentModule
					.getPredefinedTemplateId136141193761531471().getRoot())) {
				dosageType = DosageType.Normal;
				break;
			} else if (templateId.getRoot().equals(MedicationTreatmentPlanEntryContentModule
					.getPredefinedTemplateId13614119376153148().getRoot())) {
				dosageType = DosageType.Tapered;
				break;
			} else if (templateId.getRoot().equals(MedicationTreatmentPlanEntryContentModule
					.getPredefinedTemplateId13614119376153149().getRoot())) {
				dosageType = DosageType.Split;
				break;
			}
		}

		if (dosageType == DosageType.Normal) {
			for (SXCMTS sxcmts : substanceAdministration.getEffectiveTime()) {
				if (sxcmts instanceof PIVLTS) {
					dosageIntakes.add(parsePivlTs(this.languageCode, (PIVLTS) sxcmts));
					return;
				} else if (sxcmts instanceof EIVLTS) {
					dosageIntakes.add(parseEivlTs(this.languageCode, (EIVLTS) sxcmts));
					return;
				}
			}
		} else if (dosageType == DosageType.Tapered) {
			for (SXCMTS sxcmts : substanceAdministration.getEffectiveTime()) {
				if (sxcmts instanceof SXPRTS) {
					dosageIntakes.add(parseSxprTs(languageCode, (SXPRTS) sxcmts));
					return;
				}
			}
		} else if (dosageType == DosageType.Split) {
			List<String> dosageIntakesCrt = parseSplitedDosageIntake(substanceAdministration,
					languageCode);
			if (dosageIntakesCrt.size() == 0) {
				dosageIntakes.add("-");
			} else {
				dosageIntakes.addAll(dosageIntakesCrt);
			}
			return;
		}
		dosageIntakes.add("-");

	}

	/**
	 * <div class="en">Parse and store the different elements of an
	 * substanceAdministration of a dis</div>
	 *
	 * @param entryRelationships
	 *            list of entryRelationships
	 */
	private void parseSubstanceAdministrationDis(
			List<POCDMT000040EntryRelationship> entryRelationships) {
		POCDMT000040SubstanceAdministration substanceAdministration = filterSubstanceAdministrationDis(
				entryRelationships);
		String dosageIntakeText = null;
		if (entryRelationships != null) {
			dosageIntakeText = this.getDosageIntakeTextIfExist(entryRelationships);
		}

		if (StringUtils.isEmpty(dosageIntakeText)) {
			if (substanceAdministration != null && !emedClass.equals("PADV")) {
				this.parseDosageIntake(substanceAdministration);
			} else if (substanceAdministration != null) {
				this.parseChangeDosageInstruction(substanceAdministration);
			}

			if (dosageIntakeText == null) {
				this.addDosageIntakeReference();
			}
		} else {
			this.dosageIntakes.add(dosageIntakeText);
		}

		if (substanceAdministration != null && substanceAdministration.getEffectiveTime() != null
				&& substanceAdministration.getEffectiveTime().size() > 0) {
			IVLTS dateFromTo = (IVLTS) substanceAdministration.getEffectiveTime().get(0);
			this.dateFromTo = parseIvlTs(dateFromTo, this.languageCode);
			if (StringUtils.isEmpty(this.dateFromTo)) {
				this.dateFromTo = "-";
			}

			this.doseQuantity = parseIvlPq(substanceAdministration.getDoseQuantity());
			this.rateQuantity = parseRateQuantity(substanceAdministration.getRateQuantity());
		}

	}

	/**
	 * <div class="en">Transforme a PQ object to string</div>
	 *
	 * @param quantity
	 *            quantity
	 * @return quantity formated in string
	 */
	private String quantityToString(PQ quantity) {

		String quantityStr = "-";

		if (quantity != null) {
			if (StringUtils.isNotEmpty(quantity.getValue()))
				quantityStr = quantity.getValue();
			if (quantity.getUnit() != null && !quantity.getUnit().equals("1")) {
				quantityStr += " " + quantity.getUnit();
			}
		}
		return quantityStr;
	}

	/**
	 * <div class="en">Reset all the attributes of the narrative text</div>
	 */
	private void resetAttributes() {
		packageName = "-";
		dateFromTo = "-";
		dosageIntakes = new ArrayList<>();
		doseQuantity = "-";
		rateQuantity = "-";
		reason = "-";
		patientInstructions = "-";
		dispenseAmount = "-";
		packageForm = "-";
		ingredients = new ArrayList<>();
		routeCode = "-";
		approachSite = "-";
		fulfillmentInstructions = "-";
		substitution = "-";
		packageCapacity = "-";
		lotNumber = "-";
		gtin = "-";
		repeatNumber = "-";
	}

	/**
	 * <div class="en">Fetch values to generate the narrative text from a
	 * material</div>
	 *
	 * @param material
	 *            a material
	 */
	private void setAttributesFromMaterial(POCDMT000040Material material) {

		if (material.getAsContent() != null
				&& material.getAsContent().getContainerPackagedMedicine() != null) {
			COCTMT230100UVPackagedMedicine coctmt230100UVPackagedMedicine = material.getAsContent()
					.getContainerPackagedMedicine();
			if (coctmt230100UVPackagedMedicine.getName() != null && material.getAsContent()
					.getContainerPackagedMedicine().getName().size() > 0) {
				packageName = coctmt230100UVPackagedMedicine.getName().get(0).xmlContent;
			}
			if (coctmt230100UVPackagedMedicine.getFormCode() != null) {
				String packageFormCode;
				if (coctmt230100UVPackagedMedicine.getFormCode().getOriginalText() != null
						&& StringUtils.isNotEmpty(coctmt230100UVPackagedMedicine.getFormCode()
								.getOriginalText().xmlContent))
					packageFormCode = setReferenceAndGetXmlContent(
							coctmt230100UVPackagedMedicine.getFormCode().getOriginalText(),
							EmedTextNarrativeAttributes.DOSE_FORM.getCodeValue());

				else {
					packageFormCode = coctmt230100UVPackagedMedicine.getFormCode().getCode();
					if (StringUtils.isNotEmpty(packageFormCode)) {
						coctmt230100UVPackagedMedicine.getFormCode().setOriginalText(new ED());
						setReferenceAndGetXmlContent(
								coctmt230100UVPackagedMedicine.getFormCode().getOriginalText(),
								EmedTextNarrativeAttributes.DOSE_FORM.getCodeValue());
					}
				}

				PharmaceuticalDoseFormEdqm pharmaceuticalDoseFormEdqm = PharmaceuticalDoseFormEdqm
						.getEnum(packageFormCode);
				if (pharmaceuticalDoseFormEdqm != null)
					packageForm = Objects
							.requireNonNull(PharmaceuticalDoseFormEdqm.getEnum(packageFormCode))
							.getDisplayName(languageCode);
				else {
					packageForm = packageFormCode;
				}
			}
			if (coctmt230100UVPackagedMedicine.getCapacityQuantity() != null) {
				packageCapacity = coctmt230100UVPackagedMedicine.getCapacityQuantity().getValue();
			}
			if (coctmt230100UVPackagedMedicine.getCode() != null
					&& coctmt230100UVPackagedMedicine.getCode().getOriginalText() != null
					&& StringUtils.isNotEmpty(coctmt230100UVPackagedMedicine.getCode()
							.getOriginalText().xmlContent)) {
				gtin = getOriginalTextAndSetRef(coctmt230100UVPackagedMedicine.getCode(),
						EmedTextNarrativeAttributes.GTIN.getCodeValue());
			} else if (coctmt230100UVPackagedMedicine.getCode() != null
					&& StringUtils.isNotEmpty(coctmt230100UVPackagedMedicine.getCode().getCode())) {
				gtin = coctmt230100UVPackagedMedicine.getCode().getCode();
				coctmt230100UVPackagedMedicine.getCode().setOriginalText(new ED());
				getOriginalTextAndSetRef(coctmt230100UVPackagedMedicine.getCode(),
						EmedTextNarrativeAttributes.GTIN.getCodeValue());
			}

			if (material.getLotNumberText() != null
					&& StringUtils.isNotEmpty(material.getLotNumberText().xmlContent)) {
				lotNumber = setReferenceAndGetXmlContent(material.getLotNumberText(),
						EmedTextNarrativeAttributes.LOT_NUMBER.getCodeValue());
			}

		}
		if (material.getIngredient() != null && material.getIngredient().size() > 0) {
			List<COCTMT230100UVIngredient> ingredientsList = material.getIngredient();
			setIngredients(ingredientsList);

		}

		if (ingredients.size() == 0) {
			ingredients.add("-");
		}

	}

	/**
	 * <div class="en"> Set the different elements for a DIS</div>
	 */
	private void setDisNarrativeText() {
		this.resetAttributes();

		if (this.entry != null && this.entry.getSupply() != null) {

			POCDMT000040Supply supply = this.entry.getSupply();
			dispenseAmount = quantityToString(supply.getQuantity());

			POCDMT000040Material manufacturedMaterial = Optional.of(supply)
					.map(POCDMT000040Supply::getProduct)
					.map(POCDMT000040Product::getManufacturedProduct)
					.map(POCDMT000040ManufacturedProduct::getManufacturedMaterial).orElse(null);
			if (manufacturedMaterial != null) {
				setAttributesFromMaterial(manufacturedMaterial);

				this.gtin = getCodeOrOriginalTextAndSetRef(manufacturedMaterial.getCode(),
						EmedTextNarrativeAttributes.GTIN.getCodeValue());

				String originalTextOrFormCode = getCodeOrOriginalTextAndSetRef(
						manufacturedMaterial.getFormCode(),
						EmedTextNarrativeAttributes.DOSE_FORM.getCodeValue());

				PharmaceuticalDoseFormEdqm pharmaceuticalDoseFormEdqm = PharmaceuticalDoseFormEdqm
						.getEnum(originalTextOrFormCode);
				if (pharmaceuticalDoseFormEdqm != null)
					packageForm = Objects
							.requireNonNull(
									PharmaceuticalDoseFormEdqm.getEnum(originalTextOrFormCode))
							.getDisplayName(languageCode);
				else {
					packageForm = originalTextOrFormCode;
				}

				String dosageIntakeText = null;
				if (supply.getEntryRelationship() != null) {
					dosageIntakeText = getDosageIntakeTextIfExist(supply.getEntryRelationship());
				}
				// if it already exist a text for the dosage intake we don't
				// generate the dosageIntake instruction String
				POCDMT000040SubstanceAdministration substanceAdministration = filterSubstanceAdministrationDis(
						supply.getEntryRelationship());

				if (StringUtils.isEmpty(dosageIntakeText)) {

					if (substanceAdministration != null)
						parseDosageIntake(substanceAdministration);
					if (dosageIntakeText == null)
						addDosageIntakeReference();
				} else {
					this.dosageIntakes.add(dosageIntakeText);
				}
				if (substanceAdministration != null
						&& substanceAdministration.getEffectiveTime() != null
						&& substanceAdministration.getEffectiveTime().size() > 0) {
					IVLTS dateFromTo = (IVLTS) substanceAdministration.getEffectiveTime().get(0);
					this.dateFromTo = parseIvlTs(dateFromTo, languageCode);
					if (StringUtils.isEmpty(this.dateFromTo)) {
						this.dateFromTo = "-";
					}
					this.doseQuantity = parseIvlPq(substanceAdministration.getDoseQuantity());
					this.rateQuantity = parseRateQuantity(
							substanceAdministration.getRateQuantity());
				}

				POCDMT000040EntryRelationship entryRelationshipComment = filterEntryRelationshipAtcByTemplateId(
						supply.getEntryRelationship(), "2.16.756.5.30.1.1.10.4.2");
				if (entryRelationshipComment != null) {
					String commentStr = setReferenceAndGetXmlContent(
							entryRelationshipComment.getAct().getText(),
							EmedTextNarrativeAttributes.COMMENT.getCodeValue());
					this.comment = StringUtils.isNotEmpty(commentStr) ? commentStr : "-";
				}
				POCDMT000040EntryRelationship entryRelationshipPatientInstruction = filterPatientInstruction(
						supply.getEntryRelationship());
				if (entryRelationshipPatientInstruction != null) {
					String patientInstructionStr = setReferenceAndGetXmlContent(
							entryRelationshipPatientInstruction.getAct().getText(),
							EmedTextNarrativeAttributes.COMMENT.getCodeValue());
					this.patientInstructions = StringUtils.isNotEmpty(patientInstructionStr)
							? patientInstructionStr
							: "-";
				}
			}
			addParamNameToValues();

		}

	}

	/**
	 * <div class="en">Store the list of ingrediant to display it in the
	 * narrative text</div>
	 *
	 * @param ingredientsList
	 *            an ingredientsList
	 */
	private void setIngredients(List<COCTMT230100UVIngredient> ingredientsList) {
		for (COCTMT230100UVIngredient ingredientCrt : ingredientsList) {
			String ingredientStrCrt;
			ED originalTextIngredient = ingredientCrt.getIngredient().getValue().getCode()
					.getOriginalText();
			// if there isn't original text we
			if (originalTextIngredient == null) {
				originalTextIngredient = new ED();
				ingredientCrt.getIngredient().getValue().getCode()
						.setOriginalText(originalTextIngredient);
			}

			ingredientStrCrt = setReferenceAndGetXmlContent(originalTextIngredient,
					EmedTextNarrativeAttributes.INGREDIENTS.getCodeValue());
			if (StringUtils.isEmpty(ingredientStrCrt)) {
				ingredientStrCrt = ingredientCrt.getIngredient().getValue().getCode()
						.getDisplayName() + " ("
						+ ingredientCrt.getIngredient().getValue().getCode().getCode() + ")";
			}
			ingredients.add(ingredientStrCrt);
		}
	}

	/**
	 * <div class="en">Fetch values to generate the text narratif</div>
	 */
	private void setNarrativeParameters() {
		this.resetAttributes();

		if (entry != null && entry.getSubstanceAdministration() != null) {
			POCDMT000040SubstanceAdministration substanceAdministration = entry
					.getSubstanceAdministration();
			if (substanceAdministration.getEffectiveTime() != null
					&& substanceAdministration.getEffectiveTime().size() > 0) {
				IVLTS dateFromTo = (IVLTS) substanceAdministration.getEffectiveTime().get(0);
				this.dateFromTo = parseIvlTs(dateFromTo, languageCode);
				if (StringUtils.isEmpty(this.dateFromTo)) {
					this.dateFromTo = "-";
				}
			}

			if (substanceAdministration.getConsumable() != null
					&& substanceAdministration.getConsumable().getManufacturedProduct() != null
					&& substanceAdministration.getConsumable().getManufacturedProduct()
							.getManufacturedMaterial() != null) {
				POCDMT000040Material material = substanceAdministration.getConsumable()
						.getManufacturedProduct().getManufacturedMaterial();
				setAttributesFromMaterial(material);
			}
			String dosageIntakeText = null;
			if (substanceAdministration.getEntryRelationship() != null) {
				dosageIntakeText = getDosageIntakeTextIfExist(
						substanceAdministration.getEntryRelationship());
			}
			// if it already exist a text for the dosage intake we don't
			// generate the dosageIntake instruction String
			if (dosageIntakeText == null) {
				parseDosageIntake(substanceAdministration);
				addDosageIntakeReference();
			} else if (StringUtils.isEmpty(dosageIntakeText)) {
				// the reference is already added so we just need to generate
				// the narrative text
				parseDosageIntake(substanceAdministration);
			} else {
				this.dosageIntakes.add(dosageIntakeText);
			}

			if (substanceAdministration.getDoseQuantity() != null) {
				doseQuantity = parseIvlPq(substanceAdministration.getDoseQuantity());
			}
			if (substanceAdministration.getRateQuantity() != null) {
				rateQuantity = substanceAdministration.getRateQuantity().getValue() + "/"
						+ substanceAdministration.getRateQuantity().getUnit();
			}

			// GETTING REASON */
			Optional<POCDMT000040Observation> observationOptional = Optional
					.of(substanceAdministration)
					.map(POCDMT000040SubstanceAdministration::getEntryRelationship)
					.map(EmedChStrucDocTextBuilderV096::filterTreatmentReason)
					.map(POCDMT000040EntryRelationship::getObservation);
			ED reasonText = observationOptional.map(POCDMT000040Observation::getText).orElse(null);

			reason = setReferenceAndGetXmlContent(reasonText,
					EmedTextNarrativeAttributes.REASON.getCodeValue());
			// END GETTING REASON */

			patientInstructions = Optional.of(substanceAdministration)
					.map(POCDMT000040SubstanceAdministration::getEntryRelationship)
					.map(EmedChStrucDocTextBuilderV096::filterPatientInstruction)
					.map(POCDMT000040EntryRelationship::getAct).map(POCDMT000040Act::getText)
					.map(ed -> {
						setReferenceAndGetXmlContent(ed,
								EmedTextNarrativeAttributes.PATIENT_INSTRUCTIONS.getCodeValue());
						return StringUtils.isNotEmpty(ed.xmlContent) ? ed.xmlContent : "-";
					}).orElse("-");

			// GETTING DISPENSE AMOUNT
			dispenseAmount = "-";
			Optional<POCDMT000040Supply> dispenseAmountOptional = Optional
					.of(substanceAdministration)
					.map(POCDMT000040SubstanceAdministration::getEntryRelationship)
					.map(EmedChStrucDocTextBuilderV096::filterDispenseAmount)
					.map(POCDMT000040EntryRelationship::getSupply);
			ED dispenseAmountText = dispenseAmountOptional.map(POCDMT000040Supply::getText)
					.orElse(null);
			PQ dispenseAmountQuantity = dispenseAmountOptional.map(POCDMT000040Supply::getQuantity)
					.orElse(null);
			if (dispenseAmountText == null) {
				setReferenceTextToSupply(dispenseAmountOptional.orElse(null),
						EmedTextNarrativeAttributes.DISPENSE_AMOUNT.getCodeValue());
				dispenseAmount = quantityToString(dispenseAmountQuantity);

			} else {
				String dispenseAmountNarratif = setReferenceAndGetXmlContent(dispenseAmountText,
						EmedTextNarrativeAttributes.DISPENSE_AMOUNT.getCodeValue());
				if (StringUtils.isNotEmpty(dispenseAmountNarratif))
					dispenseAmount = dispenseAmountNarratif;
				else
					dispenseAmount = quantityToString(dispenseAmountQuantity);

			}
			// END GETTING DISPENSE AMOUNT*/
			if (substanceAdministration.getRouteCode() != null
					&& substanceAdministration.getRouteCode().getCode() != null) {
				String originalTextRouteCode = getOriginalTextAndSetRef(
						substanceAdministration.getRouteCode(),
						EmedTextNarrativeAttributes.ROUTE_CODE.getCodeValue());
				if (StringUtils.isNotEmpty(originalTextRouteCode)) {
					routeCode = originalTextRouteCode;
				} else {
					RouteOfAdministrationEdqm routeOfAdministrationEdqm = RouteOfAdministrationEdqm
							.getEnum(substanceAdministration.getRouteCode().getCode());
					routeCode = Objects.requireNonNull(routeOfAdministrationEdqm)
							.getDisplayName(this.languageCode);
					substanceAdministration.getRouteCode().setOriginalText(new ED());
					getOriginalTextAndSetRef(substanceAdministration.getRouteCode(),
							EmedTextNarrativeAttributes.ROUTE_CODE.getCodeValue());
				}

			}
			if (substanceAdministration.getApproachSiteCode() != null
					&& substanceAdministration.getApproachSiteCode().size() > 0) {
				approachSite = "";
				int cmp = 0;
				String approachSiteCodeReferenceId;
				for (CD approachSiteCode : substanceAdministration.getApproachSiteCode()) {
					// we add the reference only for the first element
					if (cmp == 0) {
						approachSiteCodeReferenceId = EmedTextNarrativeAttributes.APPROACH_SITE
								.getCodeValue();
					} else {
						approachSiteCodeReferenceId = "";
					}

					String approachSiteCodeOriginalText = getOriginalTextAndSetRef(approachSiteCode,
							approachSiteCodeReferenceId);
					if (StringUtils.isNotEmpty(approachSite)) {
						approachSite += ", ";
					}
					if (StringUtils.isNotEmpty(approachSiteCodeOriginalText)) {
						approachSite += approachSiteCodeOriginalText;

					} else if (StringUtils.isNotEmpty(approachSiteCode.getCode()))
						approachSite += approachSiteCode.getCode();
					cmp++;
				}
			}

			// Getting fulfillmentinstrucitons

			ED fulfillmentText = Optional.of(substanceAdministration)
					.map(POCDMT000040SubstanceAdministration::getEntryRelationship)
					.map(EmedChStrucDocTextBuilderV096::filterFulfillment)
					.map(POCDMT000040EntryRelationship::getAct).map(POCDMT000040Act::getText)
					.orElse(null);

			fulfillmentInstructions = setReferenceAndGetXmlContent(fulfillmentText,
					EmedTextNarrativeAttributes.FULFILMENT_INSTRUCTIONS.getCodeValue());
			if (StringUtils.isEmpty(fulfillmentInstructions)) {
				fulfillmentInstructions = "-";
			}
			// END Getting fulfillmentinstrucitons

			// GETTING SUBSTITUTION */
			Optional<POCDMT000040Act> substitutionOptional = Optional.of(substanceAdministration)
					.map(POCDMT000040SubstanceAdministration::getEntryRelationship)
					.map(EmedChStrucDocTextBuilderV096::filterSubstitutionPermission)
					.map(POCDMT000040EntryRelationship::getAct);
			ED substitutionText = substitutionOptional.map(POCDMT000040Act::getText).orElse(null);
			String substitutionNarratif = null;
			if (substitutionText != null)
				substitutionNarratif = setReferenceAndGetXmlContent(substitutionText,
						EmedTextNarrativeAttributes.SUBSTITUTION.getCodeValue());
			else {
				POCDMT000040Act substitutionAct = substitutionOptional.orElse(null);
				if (substitutionAct != null) {
					substitutionAct.setText(new ED());
					setReferenceAndGetXmlContent(substitutionAct.getText(),
							EmedTextNarrativeAttributes.SUBSTITUTION.getCodeValue());
				}
			}
			String substitutionCode = substitutionOptional.map(POCDMT000040Act::getCode)
					.map(CD::getCode).orElse("-");
			ActSubstanceAdminSubstitutionCode actSubstanceAdminSubstitutionCode = ActSubstanceAdminSubstitutionCode
					.getEnum(substitutionCode);
			if (StringUtils.isNotEmpty(substitutionNarratif)) {
				substitution = substitutionNarratif;
			} else if (actSubstanceAdminSubstitutionCode != null) {
				substitution = actSubstanceAdminSubstitutionCode.getDisplayName(languageCode);
			} else {
				substitution = substitutionCode;
			}
			// END GETTING SUBSTITUTION */

			// GETTING REPETITION*/
			if (substanceAdministration.getRepeatNumber() != null) {
				IVLINT ivlint = substanceAdministration.getRepeatNumber();
				JAXBElement<? extends INT> jaxbElementLow = Optional.ofNullable(ivlint)
						.map(IVLINT::getRest)
						.map(jaxbElements -> jaxbElements.stream()
								.filter(jaxbElement -> jaxbElement.getName() != null
										&& jaxbElement.getName().getLocalPart().equals("low"))
								.findFirst())
						.get().orElse(null);
				JAXBElement<? extends INT> jaxbElementHigh = Optional.of(ivlint)
						.map(IVLINT::getRest)
						.map(jaxbElements -> jaxbElements.stream()
								.filter(jaxbElement -> jaxbElement.getName() != null
										&& jaxbElement.getName().getLocalPart().equals("high"))
								.findFirst())
						.get().orElse(null);
				if (Objects.requireNonNull(jaxbElementLow).getValue() != null
						&& jaxbElementLow.getValue().getValue() != null) {
					repeatNumber = jaxbElementLow.getValue().getValue().toString();
				}
				if (Objects.requireNonNull(jaxbElementHigh).getValue() != null
						&& jaxbElementHigh.getValue().getValue() != null) {
					if (!repeatNumber.equals("-")) {
						repeatNumber += "-" + jaxbElementHigh.getValue().getValue().toString();
					} else {
						repeatNumber = jaxbElementHigh.getValue().getValue().toString();
					}
				}
			}
			// END GETTING REPETITION*/

		}

		addParamNameToValues();

	}

	/**
	 * <div class="en">Set the different attributes for a PADV change</div>
	 */
	private void setPadvChangeNarrativeText() {
		this.resetAttributes();
		if (this.entry != null && this.entry.getObservation() != null) {
			POCDMT000040Observation observation = this.entry.getObservation();
			if (observation.getEntryRelationship() != null) {
				this.parseSubstanceAdministrationDis(observation.getEntryRelationship());
				POCDMT000040EntryRelationship entryRelationshipPatientInstruction = filterPatientInstruction(
						observation.getEntryRelationship());
				if (entryRelationshipPatientInstruction != null) {
					String patientInstructionStr = this.setReferenceAndGetXmlContent(
							entryRelationshipPatientInstruction.getAct().getText(),
							EmedTextNarrativeAttributes.PATIENT_INSTRUCTIONS.getCodeValue());
					this.patientInstructions = StringUtils.isNotEmpty(patientInstructionStr)
							? patientInstructionStr
							: "-";
				}

				POCDMT000040EntryRelationship entryRelationshipfulFillmentInstruction = filterFulfillment(
						observation.getEntryRelationship());
				if (entryRelationshipfulFillmentInstruction != null) {
					String fulFillmentInstructionsStr = this.setReferenceAndGetXmlContent(
							entryRelationshipfulFillmentInstruction.getAct().getText(),
							EmedTextNarrativeAttributes.FULFILMENT_INSTRUCTIONS.getCodeValue());
					this.fulfillmentInstructions = StringUtils.isNotEmpty(
							fulFillmentInstructionsStr) ? fulFillmentInstructionsStr : "-";
				}

				POCDMT000040EntryRelationship entryRelationshipDispenseAmount = filterDispenseAmount(
						observation.getEntryRelationship());
				if (entryRelationshipDispenseAmount != null
						&& entryRelationshipDispenseAmount.getSupply() != null
						&& entryRelationshipDispenseAmount.getSupply().getQuantity() != null) {
					String dispenseAmountStr = this.quantityToString(
							entryRelationshipDispenseAmount.getSupply().getQuantity());
					this.dispenseAmount = StringUtils.isNotEmpty(dispenseAmountStr)
							? dispenseAmountStr
							: "-";
				}

				/* GETTING REPETITION */
				if (observation.getRepeatNumber() != null) {
					IVLINT ivlint = observation.getRepeatNumber();
					JAXBElement<? extends INT> jaxbElementLow = Optional.ofNullable(ivlint)
							.map(IVLINT::getRest)
							.map(jaxbElements -> jaxbElements.stream()
									.filter(jaxbElement -> jaxbElement.getName() != null
											&& jaxbElement.getName().getLocalPart().equals("low"))
									.findFirst())
							.get().orElse(null);
					JAXBElement<? extends INT> jaxbElementHigh = Optional.of(ivlint)
							.map(IVLINT::getRest)
							.map(jaxbElements -> jaxbElements.stream()
									.filter(jaxbElement -> jaxbElement.getName() != null
											&& jaxbElement.getName().getLocalPart().equals("high"))
									.findFirst())
							.get().orElse(null);
					if (jaxbElementLow != null && jaxbElementLow.getValue() != null
							&& jaxbElementLow.getValue().getValue() != null) {
						repeatNumber = jaxbElementLow.getValue().getValue().toString();
					}
					if (jaxbElementHigh != null && jaxbElementHigh.getValue() != null
							&& jaxbElementHigh.getValue().getValue() != null) {
						if (!repeatNumber.equals("-")) {
							repeatNumber += "-" + jaxbElementHigh.getValue().getValue().toString();
						} else {
							repeatNumber = jaxbElementHigh.getValue().getValue().toString();
						}
					}
				}
				/* END GETTING REPETITION */

			}
		}

		this.addParamNameToValues();
	}

	/**
	 * <div class="en">Fetch values to generate the narrative text for a
	 * PADV_COMMENT</div>
	 */
	private void setPadvNarrativeComment() {
		if (this.entry != null && this.entry.getObservation() != null
				&& this.entry.getObservation().getEntryRelationship() != null) {
			POCDMT000040EntryRelationship entryRelationshipfulfillmentInstruction = filterFulfillment(
					this.entry.getObservation().getEntryRelationship());
			if (entryRelationshipfulfillmentInstruction != null) {
				String fulFillmentInstructionsStr = this.setReferenceAndGetXmlContent(
						entryRelationshipfulfillmentInstruction.getAct().getText(),
						EmedTextNarrativeAttributes.FULFILMENT_INSTRUCTIONS.getCodeValue());
				this.comment = StringUtils.isNotEmpty(fulFillmentInstructionsStr)
						? fulFillmentInstructionsStr
						: "-";
			}
		}
		this.addParamNameToValues();
	}

	/**
	 * <div class="en">Add the reference to the element that contain the text
	 * who is going to be displayed in the narrative text</div>
	 *
	 * @param ed
	 *            text that could contain a reference
	 * @param ref
	 *            ref to add in the ed
	 * @return the xmlcontent
	 */
	private String setReferenceAndGetXmlContent(ED ed, String ref) {
		String xmlContent = "";
		if (ed != null) {
			TEL reference = new TEL();
			if (StringUtils.isNotEmpty(ref)) {
				reference.setValue("#" + this.emedClass + "." + ref + "." + this.rowCrt);
				ed.setReference(reference);
			}
			if (StringUtils.isNotEmpty(ed.xmlContent)) {
				xmlContent = ed.xmlContent;
			}

		}

		return xmlContent;

	}

	/**
	 * <div class="en">set a reference to a Supply object</div>
	 *
	 * @param pocdmt000040Supply
	 *            the supply
	 * @param ref
	 *            id reference
	 */
	private void setReferenceTextToSupply(POCDMT000040Supply pocdmt000040Supply, String ref) {
		if (pocdmt000040Supply != null && pocdmt000040Supply.getText() == null) {
			ED textRef = new ED();
			TEL tel = new TEL();
			tel.setValue("#" + this.emedClass + "." + ref + "." + rowCrt);
			textRef.setReference(tel);
			pocdmt000040Supply.setText(textRef);
		} else if (pocdmt000040Supply != null && pocdmt000040Supply.getText() != null) {
			TEL tel = new TEL();
			tel.setValue("#" + this.emedClass + "." + ref + "." + rowCrt);
			pocdmt000040Supply.getText().setReference(tel);
		}
	}
}