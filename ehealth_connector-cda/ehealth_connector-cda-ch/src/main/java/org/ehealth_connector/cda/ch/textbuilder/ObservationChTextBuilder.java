/*
 *
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

package org.ehealth_connector.cda.ch.textbuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.lang3.NotImplementedException;
import org.ehealth_connector.cda.AbstractObservation;
import org.ehealth_connector.cda.enums.ContentIdPrefix;
import org.ehealth_connector.cda.enums.VitalSignCodes;
import org.ehealth_connector.cda.ihe.lab.AbstractLaboratoryAct;
import org.ehealth_connector.cda.ihe.lab.AbstractLaboratorySpecialtySection;
import org.ehealth_connector.cda.textbuilder.TextBuilder;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Performer;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.cda.Participant2;
import org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection;
import org.openhealthtools.mdht.uml.cda.ihe.impl.VitalSignsOrganizerImpl;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation;
import org.openhealthtools.mdht.uml.cda.ihe.lab.impl.LaboratoryBatteryOrganizerImpl;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;

/**
 * Generates the narrative text of the observations in a section (&lt;text&gt;
 * element).
 *
 */
public class ObservationChTextBuilder extends TextBuilder {

	private final List<String> headerColumns = new ArrayList<String>();
	private final AbstractLaboratoryAct laboratoryAct;
	private final CodedVitalSignsSection codedVitalSignsSection;
	// private final List<AbstractObservation> laboratoryObservations;
	private final String contentIdPrefix;
	private final LanguageCode lang;
	private final ResourceBundle resBundle;
	private final String posCodeSystemOid;

	/**
	 * Constructor. TODO tsc neu dokumentieren
	 *
	 * @param contentIdPrefix
	 *            the content id prefix
	 * @param lang
	 *            the desired language for text generation (default language is
	 *            English)
	 */
	public ObservationChTextBuilder(AbstractLaboratorySpecialtySection section,
			ContentIdPrefix contentIdPrefix, LanguageCode lang) {
		this(section, contentIdPrefix.getContentIdPrefix(), lang, null);
	}

	/**
	 * Constructor. TODO tsc neu dokumentieren
	 *
	 * @param list
	 *            a list of laboratory observations
	 * @param contentIdPrefix
	 *            the content id prefix
	 * @param lang
	 *            the desired language for text generation (default language is
	 *            English)
	 * @param posCodeSystemOid
	 *            the oid of the code system to be used as position (e.g.
	 *            2.16.756.5.30.1.129.1.3 for the Swiss Analysis List)
	 */
	public ObservationChTextBuilder(AbstractLaboratorySpecialtySection section,
			ContentIdPrefix contentIdPrefix, LanguageCode lang, String posCodeSystemOid) {
		this(section, contentIdPrefix.getContentIdPrefix(), lang, posCodeSystemOid);
	}

	/**
	 * Constructor. TODO tsc neu dokumentieren
	 *
	 * @param list
	 *            a list of laboratory observations
	 * @param contentIdPrefix
	 *            the content id prefix
	 * @param lang
	 *            the desired language for text generation (default language is
	 *            English)
	 */
	public ObservationChTextBuilder(AbstractLaboratorySpecialtySection section,
			String contentIdPrefix, LanguageCode lang, String posCodeSystemOid) {
		this.codedVitalSignsSection = null;
		this.laboratoryAct = section.getAct();
		this.contentIdPrefix = contentIdPrefix;
		this.lang = lang;
		this.resBundle = ResourceBundle.getBundle("Messages", new Locale(lang.getCodeValue()));
		if (posCodeSystemOid == null)
			this.posCodeSystemOid = "";
		else
			this.posCodeSystemOid = posCodeSystemOid;
	}

	/**
	 * Constructor. TODO tsc neu dokumentieren
	 *
	 * @param contentIdPrefix
	 *            the content id prefix
	 * @param lang
	 *            the desired language for text generation (default language is
	 *            English)
	 */
	public ObservationChTextBuilder(CodedVitalSignsSection section, ContentIdPrefix contentIdPrefix,
			LanguageCode lang) {
		this(section, contentIdPrefix.getContentIdPrefix(), lang);
	}

	/**
	 * Constructor. TODO tsc neu dokumentieren
	 *
	 * @param list
	 *            a list of laboratory observations
	 * @param contentIdPrefix
	 *            the content id prefix
	 * @param lang
	 *            the desired language for text generation (default language is
	 *            English)
	 */
	public ObservationChTextBuilder(CodedVitalSignsSection section, String contentIdPrefix,
			LanguageCode lang) {
		this.laboratoryAct = null;
		this.codedVitalSignsSection = section;
		this.contentIdPrefix = contentIdPrefix;
		this.lang = lang;
		this.resBundle = ResourceBundle.getBundle("Messages", new Locale(lang.getCodeValue()));
		this.posCodeSystemOid = "";
	}

	/**
	 * Adds the table body (rows).
	 */
	private void addTableBody() {
		boolean empty = true;
		append("<tbody>");
		int i = 0;
		if (laboratoryAct != null) {
			for (Organizer battery : laboratoryAct.getMdht().getOrganizers()) {
				if (battery instanceof LaboratoryBatteryOrganizerImpl) {
					for (LaboratoryObservation obs : ((LaboratoryBatteryOrganizerImpl) battery)
							.getLaboratoryObservations()) {
						empty = false;
						i++;
						addTableRowLaboratorySpecialtySection(i,
								(LaboratoryBatteryOrganizerImpl) battery,
								new AbstractObservation(obs));
					}
				}
			}
			if (empty)
				addTableRowLaboratorySpecialtySection(1, null, null);
		} else if (codedVitalSignsSection != null) {
			for (Organizer battery : codedVitalSignsSection.getOrganizers()) {
				if (battery instanceof VitalSignsOrganizerImpl) {
					for (Observation obs : ((VitalSignsOrganizerImpl) battery).getObservations()) {
						empty = false;
						i++;
						addTableRowCodedVitalSignsSection(i, battery, new AbstractObservation(obs));
					}
				}
			}
			if (empty)
				addTableRowCodedVitalSignsSection(1, null, null);
		}
		append("</tbody>");

	}

	/**
	 * TODO tsc dokumentieren Adds the table header.
	 */
	private void addTableHeaderCodedVitalSignsSection() {

		headerColumns.add(resBundle.getString("observation.header.row_number"));
		headerColumns.add(resBundle.getString("observation.header.observation"));
		headerColumns.add(resBundle.getString("observation.header.result"));
		headerColumns.add(resBundle.getString("observation.header.unit"));
		headerColumns.add(resBundle.getString("observation.header.codesystem"));
		headerColumns.add(resBundle.getString("observation.header.code"));
		headerColumns.add(resBundle.getString("observation.header.original_name"));
		headerColumns.add(resBundle.getString("observation.header.comment"));
		headerColumns.add(resBundle.getString("observation.header.result_obtain_date"));
		headerColumns.add(resBundle.getString("observation.header.performer"));
		headerColumns.add(resBundle.getString("observation.header.author"));
		headerColumns.add(resBundle.getString("vitalsign.header.targetsite"));
		append("<thead>");
		append("<tr>");
		for (String column : headerColumns) {
			append("<th>" + column + "</th>");
		}
		append("</tr>");
		append("</thead>");
	}

	/**
	 * TODO tsc dokumentieren Adds the table header.
	 */
	private void addTableHeaderLaboratorySpecialtySection() {

		if (!"".equals(posCodeSystemOid) && posCodeSystemOid != null)
			headerColumns.add(resBundle.getString("observation.header.row_position"));
		headerColumns.add(resBundle.getString("observation.header.row_number"));
		headerColumns.add(resBundle.getString("observation.header.observation"));
		headerColumns.add(resBundle.getString("observation.header.result"));
		headerColumns.add(resBundle.getString("observation.header.unit"));
		headerColumns.add(resBundle.getString("observation.header.interpretation"));
		headerColumns.add(resBundle.getString("observation.header.referencerange"));
		headerColumns.add(resBundle.getString("observation.header.referencerange_interpretation"));
		headerColumns.add(resBundle.getString("observation.header.codesystem"));
		headerColumns.add(resBundle.getString("observation.header.code"));
		headerColumns.add(resBundle.getString("observation.header.original_name"));
		headerColumns.add(resBundle.getString("observation.header.comment"));
		headerColumns.add(resBundle.getString("observation.header.specimen_collection_date"));
		headerColumns.add(resBundle.getString("observation.header.specimen_received_date"));
		headerColumns.add(resBundle.getString("observation.header.result_obtain_date"));
		headerColumns.add(resBundle.getString("observation.header.performer"));
		headerColumns.add(resBundle.getString("observation.header.author"));
		// Not yet implemented. This will be added by CDA-CH-LREP
		// headerColumns.add(resBundle.getString("observation.header.validator"));
		headerColumns.add(resBundle.getString("observation.header.specimen_material"));
		headerColumns
				.add(resBundle.getString("observation.header.specimen_collection_approchsite"));

		append("<thead>");
		append("<tr>");
		for (String column : headerColumns) {
			append("<th>" + column + "</th>");
		}
		append("</tr>");
		append("</thead>");
	}

	/**
	 * TODO tsc: Dokumentieren Adds the table row.
	 *
	 * @param rowNumber
	 *            the row number
	 * @param observation
	 *            the observation
	 */
	private void addTableRowCodedVitalSignsSection(int rowNumber, Organizer battery,
			AbstractObservation observation) {
		List<String> rowColumns = new ArrayList<String>();

		if (observation != null) {
			Code obsCode = observation.getCode();

			// Row number
			rowColumns.add(getCell(Integer.toString(rowNumber)));

			// Observation
			String obsName = observation.getText();
			if ("".equals(obsName)) {
				VitalSignCodes vs = VitalSignCodes.getEnum(obsCode.getCode());
				if (vs != null)
					obsName = vs.getDisplayName(lang);
			}
			rowColumns.add(getCell(obsName));

			// Result
			Value value = observation.getValue();
			String tempValue = "";
			String tempUnit = "";
			if (value != null) {
				if (value.isPhysicalQuantity()) {
					tempValue = value.getPhysicalQuantityValue();
					tempUnit = value.getPhysicalQuantityUnit();
				} else
					tempValue = value.toString();
			}
			rowColumns
					.add(getCellWithContent(getCellContent(tempValue), contentIdPrefix, rowNumber));

			// Unit
			rowColumns.add(getCell(tempUnit));

			// Code System
			String tempCodeSystem = observation.getCode().getCodeSystemName();
			if (tempCodeSystem == null)
				tempCodeSystem = observation.getCode().getCodeSystem();
			if (tempCodeSystem == "")
				tempCodeSystem = observation.getCode().getCodeSystem();
			rowColumns.add(getCell(tempCodeSystem));

			// Code
			rowColumns.add(getCell(obsCode.getCode()));

			// Original Name
			rowColumns.add(getCell(obsCode.getDisplayName()));

			// Comments
			rowColumns.add(getCell(observation.getCommentText()));

			// Value obtained
			rowColumns.add(getCell(getObservationResultObtainmentDate()));

			// Performer
			rowColumns.add(getCell(getPerformer(battery, observation)));

			// Author
			rowColumns.add(getCell(getAuthor(battery, observation)));

			// Target site
			rowColumns.add(getCell(getVitalSignTargetSite(observation)));

		} else {
			// create an empty row
			// Row number
			rowColumns.add(getCell(""));

			// Observation
			rowColumns.add(getCell(""));

			// Result
			rowColumns.add(getCell(""));

			// Unit
			rowColumns.add(getCell(""));

			// Code System
			rowColumns.add(getCell(""));

			// Code
			rowColumns.add(getCell(""));

			// Original Name
			rowColumns.add(getCell(""));

			// Comments
			rowColumns.add(getCell(""));

			// Value obtained
			rowColumns.add(getCell(""));

			// Performer
			rowColumns.add(getCell(""));

			// Author
			rowColumns.add(getCell(""));

			// Target site
			rowColumns.add(getCell(""));
		}

		if (rowColumns.size() != headerColumns.size())
			throw new NotImplementedException(
					"Table must contains the same number of header columns as of row columns");

		append("<tr>");
		for (String column : rowColumns) {
			append(column);
		}
		append("</tr>");

	}

	/**
	 * TODO tsc: Dokumentieren Adds the table row.
	 *
	 * @param rowNumber
	 *            the row number
	 * @param observation
	 *            the observation
	 */
	private void addTableRowLaboratorySpecialtySection(int rowNumber,
			LaboratoryBatteryOrganizer battery, AbstractObservation observation) {
		List<String> rowColumns = new ArrayList<String>();

		if (observation != null) {
			Code obsCode = observation.getCode();

			if (!"".equals(posCodeSystemOid) && posCodeSystemOid != null) {
				// Position code
				rowColumns.add(getCell(getPos(obsCode)));
			}

			// Row number
			rowColumns.add(getCell(Integer.toString(rowNumber)));

			// Observation
			rowColumns.add(getCell(observation.getText()));

			// Result
			Value value = observation.getValue();
			String tempValue = "";
			String tempUnit = "";
			if (value != null) {
				if (value.isPhysicalQuantity()) {
					tempValue = value.getPhysicalQuantityValue();
					tempUnit = value.getPhysicalQuantityUnit();
				} else
					tempValue = value.toString();
			}
			rowColumns
					.add(getCellWithContent(getCellContent(tempValue), contentIdPrefix, rowNumber));

			// Unit
			rowColumns.add(getCell(tempUnit));

			// Interpretation
			rowColumns
					.add(getCell(translateInterpretationCode(observation.getInterpretationCode())));

			// Reference Range
			if (observation.getReferenceRange() != null)
				rowColumns.add(getCell(observation.getReferenceRange().toNarrativeString()));
			else
				rowColumns.add(getCell(""));

			// Interpretation Reference Range
			if (observation.getReferenceRange() != null)
				rowColumns.add(getCell(translateInterpretationCode(
						observation.getReferenceRange().getInterpretationCode())));
			else
				rowColumns.add(getCell(""));

			// Code System
			String tempCodeSystem = observation.getCode().getCodeSystemName();
			if (tempCodeSystem == null) {
				tempCodeSystem = observation.getCode().getCodeSystem();
				if (tempCodeSystem == "")
					tempCodeSystem = observation.getCode().getCodeSystem();
				if (!"".equals(tempCodeSystem)) {
					String temp = CodeSystems.getEnum(tempCodeSystem).getCodeSystemName();
					if (!"".equals(temp))
						tempCodeSystem = temp;
				}
			}
			rowColumns.add(getCell(tempCodeSystem));

			// Code
			rowColumns.add(getCell(obsCode.getCode()));

			// Original Name
			rowColumns.add(getCell(obsCode.getDisplayName()));

			// Comments
			rowColumns.add(getCell(observation.getCommentText()));

			// Specimen Collection
			rowColumns.add(getCell(getSpecimenCollectionDate()));

			// Specimen Received
			rowColumns.add(getCell(getSpecimenReceivedDate()));

			// Value obtained
			rowColumns.add(getCell(getObservationResultObtainmentDate()));

			// Performer
			rowColumns.add(getCell(getPerformer(battery, observation)));

			// Author
			rowColumns.add(getCell(getAuthor(battery, observation)));

			// Validator
			// Not yet implemented. This will be added by CDA-CH-LREP
			// rowColumns.add(getCell(""));

			// Specimen Material
			rowColumns.add(getCell(getSpecimenMaterial()));

			// Specimen Collection Approach Site
			rowColumns.add(getCell(getSpecimenCollectionApprochSite()));

		} else {
			// create an empty row
			if (!"".equals(posCodeSystemOid) && posCodeSystemOid != null) {
				// Position code
				rowColumns.add(getCell(""));
			}

			// Row number
			rowColumns.add(getCell(""));

			// Observation
			rowColumns.add(getCell(""));

			// Result
			rowColumns.add(getCell(""));

			// Unit
			rowColumns.add(getCell(""));

			// Interpretation
			rowColumns.add(getCell(""));

			// Reference Range
			rowColumns.add(getCell(""));

			// Interpretation Reference Range
			rowColumns.add(getCell(""));

			// Code System
			rowColumns.add(getCell(""));

			// Code
			rowColumns.add(getCell(""));

			// Original Name
			rowColumns.add(getCell(""));

			// Comments
			rowColumns.add(getCell(""));

			// Specimen Collection
			rowColumns.add(getCell(""));

			// Specimen Received
			rowColumns.add(getCell(""));

			// Value obtained
			rowColumns.add(getCell(""));

			// Performer
			rowColumns.add(getCell(""));

			// Author
			rowColumns.add(getCell(""));

			// Validator
			// Not yet implemented. This will be added by CDA-CH-LREP
			// rowColumns.add(getCell(""));

			// Specimen Material
			rowColumns.add(getCell(""));

			// Specimen Collection Approach Site
			rowColumns.add(getCell(""));

		}

		if (rowColumns.size() != headerColumns.size())
			throw new NotImplementedException(
					"Table must contains the same number of header columns as of row columns");

		append("<tr>");
		for (String column : rowColumns) {
			append(column);
		}
		append("</tr>");

	}

	/**
	 * Format single timestamp or interval (dd.MM.yyyy HH:mm).
	 *
	 * @param ivlTS
	 *            the ivl TS value
	 * @return the formatted date as string
	 */
	private String formatSingleTimestampOrInterval(IVL_TS ivlTS) {
		String retVal = "";
		final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

		String value = ivlTS.getValue();
		String low = null;
		String high = null;
		if (ivlTS.getLow() != null)
			low = ivlTS.getLow().getValue();
		if (ivlTS.getHigh() != null)
			high = ivlTS.getHigh().getValue();
		if (value == null)
			value = "";
		if (low == null)
			low = "";
		if (high == null)
			high = "";
		if (!"".equals(value))
			if (value.length() == 17)
				value = sdf.format(DateUtil.parseDateyyyyMMddHHmmZZZZ(value));
			else
				value = sdf.format(DateUtil.parseDateyyyyMMddHHmmssZZZZ(value));
		if (!"".equals(low))
			if (low.length() == 17)
				low = sdf.format(DateUtil.parseDateyyyyMMddHHmmZZZZ(low));
			else
				low = sdf.format(DateUtil.parseDateyyyyMMddHHmmssZZZZ(low));
		if (!"".equals(high))
			if (high.length() == 17)
				high = sdf.format(DateUtil.parseDateyyyyMMddHHmmZZZZ(high));
			else
				high = sdf.format(DateUtil.parseDateyyyyMMddHHmmssZZZZ(high));
		if ("".equals(low) && "".equals(high))
			retVal = value;
		else
			retVal = low + " - " + high;
		return retVal;
	}

	/**
	 * Gets the narrative text of the author and the authoring date.
	 *
	 * @param battery
	 *            the battery
	 * @param observation
	 *            the observation
	 * @return the author the narrative text of the author and the authoring
	 *         date
	 */
	private String getAuthor(Organizer battery, AbstractObservation observation) {
		String retVal = "";

		// Try to find author on the observation
		for (Author author : observation.getAuthors()) {
			if (!"".equals(retVal))
				retVal = retVal + "<br />";
			retVal = retVal + author.getCompleteName();
			if (author.getTimeAsIVL_TS() != null) {
				String dateStr = formatSingleTimestampOrInterval(author.getTimeAsIVL_TS());
				if (!"".equals(dateStr))
					retVal = retVal + " " + resBundle.getString("generic.the_date") + " " + dateStr;
			}
		}

		if ("".equals(retVal)) {
			// Try to find author on the battery
			for (org.openhealthtools.mdht.uml.cda.Author mAuthor : battery.getAuthors()) {
				Author author = new Author(mAuthor);
				if (!"".equals(retVal))
					retVal = retVal + "<br />";
				retVal = retVal + author.getCompleteName();
				if (author.getTimeAsIVL_TS() != null) {
					String dateStr = formatSingleTimestampOrInterval(author.getTimeAsIVL_TS());
					if (!"".equals(dateStr))
						retVal = retVal + " " + resBundle.getString("generic.the_date") + " "
								+ dateStr;
				}
			}

		}
		return retVal;
	}

	/**
	 * Gets the cell content String (it is never null).
	 *
	 * @param value
	 *            the value
	 * @return the cell content
	 */
	private String getCellContent(String value) {
		String cellContent = "";
		if (value != null)
			cellContent = value;
		return cellContent;
	}

	/**
	 * Gets the narrative text of the observation result obtention date
	 *
	 * @return the narrative text of the specimen received date
	 */
	private String getObservationResultObtainmentDate() {
		String retVal = "";
		if (laboratoryAct != null) {
			for (EntryRelationship er : laboratoryAct.getMdht().getEntryRelationships()) {
				if (er.getOrganizer() != null) {
					if (er.getOrganizer().getTemplateIds() != null) {
						for (II templateId : er.getOrganizer().getTemplateIds()) {
							if (templateId.getRoot().equals("1.3.6.1.4.1.19376.1.3.1.4")) {
								if (er.getOrganizer().getEffectiveTime() != null) {
									retVal = formatSingleTimestampOrInterval(
											er.getOrganizer().getEffectiveTime());
								}
							}
						}
					}

				}
			}
		} else if (codedVitalSignsSection != null) {
			for (Organizer organizer : codedVitalSignsSection.getOrganizers()) {
				if (organizer.getTemplateIds() != null) {
					for (II templateId : organizer.getTemplateIds()) {
						if (templateId.getRoot().equals("1.3.6.1.4.1.19376.1.5.3.1.4.13.1")) {
							if (organizer.getEffectiveTime() != null) {
								retVal = formatSingleTimestampOrInterval(
										organizer.getEffectiveTime());
							}
						}
					}
				}
			}
		}
		return retVal;

	}

	/**
	 * Gets the narrative text of the author and the authoring date.
	 *
	 * @param battery
	 *            the battery
	 * @param observation
	 *            the observation
	 * @return the author the narrative text of the author and the authoring
	 *         date
	 */
	private String getPerformer(Organizer battery, AbstractObservation observation) {
		String retVal = "";

		// Try to find performer on the observation
		for (Performer performer : observation.getPerformers()) {
			if (!"".equals(retVal))
				retVal = retVal + "<br />";
			retVal = retVal + performer.getCompleteName();
			if (performer.getTimeAsIVL_TS() != null) {
				String dateStr = formatSingleTimestampOrInterval(performer.getTimeAsIVL_TS());
				if (!"".equals(dateStr))
					retVal = retVal + " " + resBundle.getString("generic.the_date") + " " + dateStr;
			}
		}

		if ("".equals(retVal)) {
			// Try to find performer on the battery
			for (org.openhealthtools.mdht.uml.cda.Performer2 mPerformer : battery.getPerformers()) {
				Performer performer = new Performer(mPerformer);
				if (!"".equals(retVal))
					retVal = retVal + "<br />";
				retVal = retVal + performer.getCompleteName();
				if (performer.getTimeAsIVL_TS() != null) {
					String dateStr = formatSingleTimestampOrInterval(performer.getTimeAsIVL_TS());
					if (!"".equals(dateStr))
						retVal = retVal + " " + resBundle.getString("generic.the_date") + " "
								+ dateStr;
				}
			}

		}
		return retVal;
	}

	private String getPos(Code code) {
		if (!"".equals(posCodeSystemOid)) {
			for (Code item : code.getTranslations()) {
				if (posCodeSystemOid.equals(item.getCodeSystem()))
					return item.getCode();
			}
		}
		return "";
	}

	/**
	 * Gets the narrative text of the specimen collection approach site
	 *
	 * @return the narrative text of the specimen collection approach site
	 */
	private String getSpecimenCollectionApprochSite() {
		String retVal = "";
		for (EntryRelationship er : laboratoryAct.getMdht().getEntryRelationships()) {
			if (er.getProcedure() != null) {
				if (er.getProcedure().getTemplateIds() != null) {
					for (II templateId : er.getProcedure().getTemplateIds()) {
						if (templateId.getRoot().equals("1.3.6.1.4.1.19376.1.3.1.2")) {
							if (er.getProcedure().getApproachSiteCodes() != null) {
								for (CD approchSite : er.getProcedure().getApproachSiteCodes()) {
									if (!"".equals(retVal))
										retVal = retVal + "<br />";
									retVal = retVal + approchSite.getOriginalText().getText();
								}
							}
						}
					}
				}

			}
		}
		return retVal;
	}

	/**
	 * Gets the narrative text of the specimen collection date
	 *
	 * @return the narrative text of the specimen collection date
	 */
	private String getSpecimenCollectionDate() {
		String retVal = "";
		for (EntryRelationship er : laboratoryAct.getMdht().getEntryRelationships()) {
			if (er.getProcedure() != null) {
				if (er.getProcedure().getTemplateIds() != null) {
					for (II templateId : er.getProcedure().getTemplateIds()) {
						if (templateId.getRoot().equals("1.3.6.1.4.1.19376.1.3.1.2")) {
							if (er.getProcedure().getEffectiveTime() != null) {
								retVal = formatSingleTimestampOrInterval(
										er.getProcedure().getEffectiveTime());
							}
						}
					}
				}

			}
		}
		return retVal;
	}

	/**
	 * Gets the narrative text of the specimen material
	 *
	 * @return the narrative text of the specimen material
	 */
	private String getSpecimenMaterial() {
		String retVal = "";
		for (EntryRelationship er : laboratoryAct.getMdht().getEntryRelationships()) {
			if (er.getProcedure() != null) {
				if (er.getProcedure().getTemplateIds() != null) {
					for (II templateId : er.getProcedure().getTemplateIds()) {
						if (templateId.getRoot().equals("1.3.6.1.4.1.19376.1.3.1.2")) {
							for (Participant2 participant : er.getProcedure().getParticipants()) {
								if (participant.getParticipantRole() != null) {
									if (participant.getParticipantRole()
											.getPlayingEntity() != null) {
										if (participant.getParticipantRole().getPlayingEntity()
												.getCode() != null) {
											if (participant.getParticipantRole().getPlayingEntity()
													.getCode().getOriginalText() != null) {
												if (!"".equals(retVal))
													retVal = retVal + "<br />";
												retVal = retVal + participant.getParticipantRole()
														.getPlayingEntity().getCode()
														.getOriginalText().getText();
											}
										}
									}
								}
							}
						}
					}
				}

			}
		}
		return retVal;
	}

	/**
	 * Gets the narrative text of the specimen received date
	 *
	 * @return the narrative text of the specimen received date
	 */
	private String getSpecimenReceivedDate() {
		String retVal = "";
		for (EntryRelationship er : laboratoryAct.getMdht().getEntryRelationships()) {
			if (er.getProcedure() != null) {
				if (er.getProcedure().getTemplateIds() != null) {
					for (II templateId : er.getProcedure().getTemplateIds()) {
						if (templateId.getRoot().equals("1.3.6.1.4.1.19376.1.3.1.2")) {
							for (EntryRelationship er2 : er.getProcedure()
									.getEntryRelationships()) {
								if (er2.getAct() != null) {
									for (II templateId2 : er2.getAct().getTemplateIds()) {
										if (templateId2.getRoot()
												.equals("1.3.6.1.4.1.19376.1.3.1.3")) {
											if (er2.getAct().getEffectiveTime() != null) {
												retVal = formatSingleTimestampOrInterval(
														er2.getAct().getEffectiveTime());
											}
										}
									}
								}
							}
						}
					}
				}

			}
		}
		return retVal;
	}

	/**
	 * Gets the narrative text of the vital sign target site
	 *
	 * @return the narrative text of the vital sign target site
	 */
	private String getVitalSignTargetSite(AbstractObservation observation) {
		String retVal = "";
		if (observation.getTargetSite() != null)
			retVal = observation.getTargetSite().getDisplayName(lang);
		return retVal;
	}

	/**
	 * Returns HTML formatted string.
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		append("<table border='1' width='100%'>");
		if (laboratoryAct != null)
			addTableHeaderLaboratorySpecialtySection();
		if (codedVitalSignsSection != null)
			addTableHeaderCodedVitalSignsSection();
		addTableBody();
		append("</table>");
		return super.toString();
	}

	/**
	 * Translates the interpretation code.
	 *
	 * @param code
	 *            the interpretation as code
	 * @return the string the interpretation as narrative string in the current
	 *         language
	 */
	private String translateInterpretationCode(Code code) {
		String retVal = "";
		if (code != null) {
			switch (code.getCodeSystem()) {
			case ObservationInterpretation.CODE_SYSTEM_OID:
				retVal = ObservationInterpretation.getEnum(code.getCode()).getDisplayName(lang);
				break;
			default:
				if (!"".equals(code.getDisplayName()))
					retVal = code.getDisplayName();
				else
					retVal = code.getCode();
			}
		}
		return retVal;
	}
}
