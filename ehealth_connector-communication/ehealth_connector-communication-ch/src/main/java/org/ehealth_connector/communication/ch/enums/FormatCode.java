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
package org.ehealth_connector.communication.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.ValueSetEnumInterface;

/**
 *<!-- @formatter:off -->
 * <div class="en">Document format as per Annex 3&amp;#160; EPRO-FDHA, Chapter 2.5. &lt;br clear="none"/&gt;
 *      &lt;br clear="none"/&gt;This unambiguous code defines the format of the XDS document. Together with the mimetype, this should provide the potential consumer with sufficient information as to whether they are in a position to process the document.&lt;br clear="none"/&gt;
 *    </div>
 * <div class="de">Format des Dokumentes gemäss Anhang 3 EPDV-EDI, Kapitel 2.5. &lt;br clear="none"/&gt;
 *      &lt;br clear="none"/&gt;Dieser eindeutige Code definiert das Format des XDS Dokumentes. Zusammen mit dem mimeType, sollte es dem potentiellen Konsumenten genügend Informationen liefern, ob er in der Lage ist, das Dokument zu verarbeiten.</div>
 * <div class="fr">Format du document selon l'annexe 3 ODEP-DFI, chapitre 2.5&lt;br clear="none"/&gt;
 *      &lt;br clear="none"/&gt;Ce code univoque définit le format du document XDS. Combiné au mimeType, il doit fournir à l'utilisateur suffisamment d'informations pour savoir s'il est en mesure de traiter le document.&lt;br clear="none"/&gt;
 *      &lt;br clear="none"/&gt;
 *    </div>
 * <div class="it">Formato del documento secondo l'allegato 3 OCIP-DFI, capitolo 2.5. &lt;br clear="none"/&gt;
 *      &lt;br clear="none"/&gt;Questo codice univoco definisce il formato del documento XDS. Insieme al tipo MIME, intende fornire al potenziale consumatore sufficienti informazioni per capire se è in grado o meno di elaborare il documento.&lt;br clear="none"/&gt;
 *    </div>
 *<!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum FormatCode implements ValueSetEnumInterface {

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">CDA Imaging Report with Structured Headings</div>
	 * <div class="de">CDA Imaging Report with Structured Headings</div>
	 * <div class="fr">CDA Imaging Report with Structured Headings</div>
	 * <div class="it">CDA Imaging Report with Structured Headings</div>
	 *<!-- @formatter:on -->
	 */
	CDA_IMAGING_REPORT_WITH_STRUCTURED_HEADINGS(
			"urn:ihe:rad:CDA:ImagingReportStructuredHeadings:2013", "1.3.6.1.4.1.19376.1.2.3",
			"XDS-I Imaging Report with Structured Headings (XDS-I)",
			"CDA Imaging Report with Structured Headings",
			"CDA Imaging Report with Structured Headings",
			"CDA Imaging Report with Structured Headings",
			"CDA Imaging Report with Structured Headings"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">CDA Laboratory Report</div>
	 * <div class="de">CDA Laboratory Report</div>
	 * <div class="fr">CDA Laboratory Report</div>
	 * <div class="it">CDA Laboratory Report</div>
	 *<!-- @formatter:on -->
	 */
	CDA_LABORATORY_REPORT("urn:ihe:lab:xd-lab:2008", "1.3.6.1.4.1.19376.1.2.3",
			"CDA Laboratory Report", "CDA Laboratory Report", "CDA Laboratory Report",
			"CDA Laboratory Report", "CDA Laboratory Report"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">CDA Wrapped Text Report</div>
	 * <div class="de">CDA Wrapped Text Report</div>
	 * <div class="fr">CDA Wrapped Text Report</div>
	 * <div class="it">CDA Wrapped Text Report</div>
	 *<!-- @formatter:on -->
	 */
	CDA_WRAPPED_TEXT_REPORT("urn:ihe:rad:TEXT", "1.3.6.1.4.1.19376.1.2.3",
			"XDS-I CDA Wrapped Text Report (XDS-I)", "CDA Wrapped Text Report",
			"CDA Wrapped Text Report", "CDA Wrapped Text Report", "CDA Wrapped Text Report"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Community Dispense</div>
	 * <div class="de">Community Dispense</div>
	 * <div class="fr">Community Dispense</div>
	 * <div class="it">Community Dispense</div>
	 *<!-- @formatter:on -->
	 */
	COMMUNITY_DISPENSE("urn:ihe:pharm:dis:2010", "1.3.6.1.4.1.19376.1.2.3", "Community Dispense",
			"Community Dispense", "Community Dispense", "Community Dispense", "Community Dispense"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Community Medication List</div>
	 * <div class="de">Community Medication List</div>
	 * <div class="fr">Community Medication List</div>
	 * <div class="it">Community Medication List</div>
	 *<!-- @formatter:on -->
	 */
	COMMUNITY_MEDICATION_LIST("urn:ihe:pharm:pml:2013", "1.3.6.1.4.1.19376.1.2.3",
			"Community Medication List", "Community Medication List", "Community Medication List",
			"Community Medication List", "Community Medication List"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Community Medication Treatment Plan</div>
	 * <div class="de">Community Medication Treatment Plan</div>
	 * <div class="fr">Community Medication Treatment Plan</div>
	 * <div class="it">Community Medication Treatment Plan</div>
	 *<!-- @formatter:on -->
	 */
	COMMUNITY_MEDICATION_TREATMENT_PLAN("urn:ihe:pharm:mtp:2015", "1.3.6.1.4.1.19376.1.2.3",
			"Community Medication Treatment Plan", "Community Medication Treatment Plan",
			"Community Medication Treatment Plan", "Community Medication Treatment Plan",
			"Community Medication Treatment Plan"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Community Pharmaceutical Advice</div>
	 * <div class="de">Community Pharmaceutical Advice</div>
	 * <div class="fr">Community Pharmaceutical Advice</div>
	 * <div class="it">Community Pharmaceutical Advice</div>
	 *<!-- @formatter:on -->
	 */
	COMMUNITY_PHARMACEUTICAL_ADVICE("urn:ihe:pharm:padv:2010", "1.3.6.1.4.1.19376.1.2.3",
			"Community Pharmaceutical Advice", "Community Pharmaceutical Advice",
			"Community Pharmaceutical Advice", "Community Pharmaceutical Advice",
			"Community Pharmaceutical Advice"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Community Prescription</div>
	 * <div class="de">Community Prescription</div>
	 * <div class="fr">Community Prescription</div>
	 * <div class="it">Community Prescription</div>
	 *<!-- @formatter:on -->
	 */
	COMMUNITY_PRESCRIPTION("urn:ihe:pharm:pre:2010", "1.3.6.1.4.1.19376.1.2.3",
			"Community Prescription", "Community Prescription", "Community Prescription",
			"Community Prescription", "Community Prescription"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">IHE KOS document</div>
	 * <div class="de">KOS Dokument</div>
	 * <div class="fr">Document KOS</div>
	 * <div class="it">Documento KOS </div>
	 *<!-- @formatter:on -->
	 */
	IHE_KOS_DOCUMENT("1.2.840.10008.5.1.4.1.1.88.59", "1.2.840.10008.2.6.1",
			"DICOM Manifest (DICOM KOS SOP Class UID)", "IHE KOS document", "KOS Dokument",
			"Document KOS", "Documento KOS "),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Immunization Content (IC)</div>
	 * <div class="de">Immunization Content (IC)</div>
	 * <div class="fr">Immunization Content (IC)</div>
	 * <div class="it">Immunization Content (IC)</div>
	 *<!-- @formatter:on -->
	 */
	IMMUNIZATION_CONTENT("urn:ihe:pcc:ic:2009", "1.3.6.1.4.1.19376.1.2.3",
			"Immunization Content (IC)", "Immunization Content (IC)", "Immunization Content (IC)",
			"Immunization Content (IC)", "Immunization Content (IC)"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">MimeType sufficient</div>
	 * <div class="de">MimeType sufficient</div>
	 * <div class="fr">MimeType sufficient</div>
	 * <div class="it">MimeType sufficient</div>
	 *<!-- @formatter:on -->
	 */
	MIMETYPE_SUFFICIENT("urn:ihe:iti:xds:2017:mimeTypeSufficient", "2.16.756.5.30.1.127.77.10.5.2",
			"MimeType sufficient", "MimeType sufficient", "MimeType sufficient",
			"MimeType sufficient", "MimeType sufficient"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">PDF embedded in CDA per XDS-SD profile</div>
	 * <div class="de">PDF embedded in CDA per XDS-SD profile</div>
	 * <div class="fr">PDF embedded in CDA per XDS-SD profile</div>
	 * <div class="it">PDF embedded in CDA per XDS-SD profile</div>
	 *<!-- @formatter:on -->
	 */
	PDF_EMBEDDED_IN_CDA_PER_XDS_SD_PROFILE("urn:ihe:iti:xds-sd:pdf:2008", "1.3.6.1.4.1.19376.1.2.3",
			"Scanned Documents (PDF)", "PDF embedded in CDA per XDS-SD profile",
			"PDF embedded in CDA per XDS-SD profile", "PDF embedded in CDA per XDS-SD profile",
			"PDF embedded in CDA per XDS-SD profile"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">PDF Radiology Report</div>
	 * <div class="de">PDF Radiology Report</div>
	 * <div class="fr">PDF Radiology Report</div>
	 * <div class="it">PDF Radiology Report</div>
	 *<!-- @formatter:on -->
	 */
	PDF_RADIOLOGY_REPORT("urn:ihe:rad:PDF", "1.3.6.1.4.1.19376.1.2.3", "XDS-I PDF (XDS-I)",
			"PDF Radiology Report", "PDF Radiology Report", "PDF Radiology Report",
			"PDF Radiology Report"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Text embedded in CDA per XDS-SD profile</div>
	 * <div class="de">Text embedded in CDA per XDS-SD profile</div>
	 * <div class="fr">Text embedded in CDA per XDS-SD profile</div>
	 * <div class="it">Text embedded in CDA per XDS-SD profile</div>
	 *<!-- @formatter:on -->
	 */
	TEXT_EMBEDDED_IN_CDA_PER_XDS_SD_PROFILE("urn:ihe:iti:xds-sd:text:2008",
			"1.3.6.1.4.1.19376.1.2.3", "Scanned Documents (text)",
			"Text embedded in CDA per XDS-SD profile", "Text embedded in CDA per XDS-SD profile",
			"Text embedded in CDA per XDS-SD profile", "Text embedded in CDA per XDS-SD profile"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Unstructured EPR document</div>
	 * <div class="de">Unstrukturiertes EPD Dokument</div>
	 * <div class="fr">Document DEP non structuré</div>
	 * <div class="it">Documento CIP non strutturato</div>
	 *<!-- @formatter:on -->
	 */
	UNSTRUCTURED_EPR_DOCUMENT("urn:che:epr:EPR_Unstructured_Document",
			"2.16.756.5.30.1.127.77.10.5.2", "Unstructured EPD document",
			"Unstructured EPR document", "Unstrukturiertes EPD Dokument",
			"Document DEP non structuré", "Documento CIP non strutturato");

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for CDA Imaging Report with Structured Headings</div>
	 * <div class="de">Code für CDA Imaging Report with Structured Headings</div>
	 * <div class="fr">Code de CDA Imaging Report with Structured Headings</div>
	 * <div class="it">Code per CDA Imaging Report with Structured Headings</div>
	 *<!-- @formatter:on -->
	 */
	public static final String CDA_IMAGING_REPORT_WITH_STRUCTURED_HEADINGS_CODE = "urn:ihe:rad:CDA:ImagingReportStructuredHeadings:2013";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for CDA Laboratory Report</div>
	 * <div class="de">Code für CDA Laboratory Report</div>
	 * <div class="fr">Code de CDA Laboratory Report</div>
	 * <div class="it">Code per CDA Laboratory Report</div>
	 *<!-- @formatter:on -->
	 */
	public static final String CDA_LABORATORY_REPORT_CODE = "urn:ihe:lab:xd-lab:2008";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for CDA Wrapped Text Report</div>
	 * <div class="de">Code für CDA Wrapped Text Report</div>
	 * <div class="fr">Code de CDA Wrapped Text Report</div>
	 * <div class="it">Code per CDA Wrapped Text Report</div>
	 *<!-- @formatter:on -->
	 */
	public static final String CDA_WRAPPED_TEXT_REPORT_CODE = "urn:ihe:rad:TEXT";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Community Dispense</div>
	 * <div class="de">Code für Community Dispense</div>
	 * <div class="fr">Code de Community Dispense</div>
	 * <div class="it">Code per Community Dispense</div>
	 *<!-- @formatter:on -->
	 */
	public static final String COMMUNITY_DISPENSE_CODE = "urn:ihe:pharm:dis:2010";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Community Medication List</div>
	 * <div class="de">Code für Community Medication List</div>
	 * <div class="fr">Code de Community Medication List</div>
	 * <div class="it">Code per Community Medication List</div>
	 *<!-- @formatter:on -->
	 */
	public static final String COMMUNITY_MEDICATION_LIST_CODE = "urn:ihe:pharm:pml:2013";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Community Medication Treatment Plan</div>
	 * <div class="de">Code für Community Medication Treatment Plan</div>
	 * <div class="fr">Code de Community Medication Treatment Plan</div>
	 * <div class="it">Code per Community Medication Treatment Plan</div>
	 *<!-- @formatter:on -->
	 */
	public static final String COMMUNITY_MEDICATION_TREATMENT_PLAN_CODE = "urn:ihe:pharm:mtp:2015";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Community Pharmaceutical Advice</div>
	 * <div class="de">Code für Community Pharmaceutical Advice</div>
	 * <div class="fr">Code de Community Pharmaceutical Advice</div>
	 * <div class="it">Code per Community Pharmaceutical Advice</div>
	 *<!-- @formatter:on -->
	 */
	public static final String COMMUNITY_PHARMACEUTICAL_ADVICE_CODE = "urn:ihe:pharm:padv:2010";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Community Prescription</div>
	 * <div class="de">Code für Community Prescription</div>
	 * <div class="fr">Code de Community Prescription</div>
	 * <div class="it">Code per Community Prescription</div>
	 *<!-- @formatter:on -->
	 */
	public static final String COMMUNITY_PRESCRIPTION_CODE = "urn:ihe:pharm:pre:2010";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for IHE KOS document</div>
	 * <div class="de">Code für KOS Dokument</div>
	 * <div class="fr">Code de Document KOS</div>
	 * <div class="it">Code per Documento KOS </div>
	 *<!-- @formatter:on -->
	 */
	public static final String IHE_KOS_DOCUMENT_CODE = "1.2.840.10008.5.1.4.1.1.88.59";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Immunization Content (IC)</div>
	 * <div class="de">Code für Immunization Content (IC)</div>
	 * <div class="fr">Code de Immunization Content (IC)</div>
	 * <div class="it">Code per Immunization Content (IC)</div>
	 *<!-- @formatter:on -->
	 */
	public static final String IMMUNIZATION_CONTENT_CODE = "urn:ihe:pcc:ic:2009";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for MimeType sufficient</div>
	 * <div class="de">Code für MimeType sufficient</div>
	 * <div class="fr">Code de MimeType sufficient</div>
	 * <div class="it">Code per MimeType sufficient</div>
	 *<!-- @formatter:on -->
	 */
	public static final String MIMETYPE_SUFFICIENT_CODE = "urn:ihe:iti:xds:2017:mimeTypeSufficient";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for PDF embedded in CDA per XDS-SD profile</div>
	 * <div class="de">Code für PDF embedded in CDA per XDS-SD profile</div>
	 * <div class="fr">Code de PDF embedded in CDA per XDS-SD profile</div>
	 * <div class="it">Code per PDF embedded in CDA per XDS-SD profile</div>
	 *<!-- @formatter:on -->
	 */
	public static final String PDF_EMBEDDED_IN_CDA_PER_XDS_SD_PROFILE_CODE = "urn:ihe:iti:xds-sd:pdf:2008";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for PDF Radiology Report</div>
	 * <div class="de">Code für PDF Radiology Report</div>
	 * <div class="fr">Code de PDF Radiology Report</div>
	 * <div class="it">Code per PDF Radiology Report</div>
	 *<!-- @formatter:on -->
	 */
	public static final String PDF_RADIOLOGY_REPORT_CODE = "urn:ihe:rad:PDF";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Text embedded in CDA per XDS-SD profile</div>
	 * <div class="de">Code für Text embedded in CDA per XDS-SD profile</div>
	 * <div class="fr">Code de Text embedded in CDA per XDS-SD profile</div>
	 * <div class="it">Code per Text embedded in CDA per XDS-SD profile</div>
	 *<!-- @formatter:on -->
	 */
	public static final String TEXT_EMBEDDED_IN_CDA_PER_XDS_SD_PROFILE_CODE = "urn:ihe:iti:xds-sd:text:2008";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Unstructured EPR document</div>
	 * <div class="de">Code für Unstrukturiertes EPD Dokument</div>
	 * <div class="fr">Code de Document DEP non structuré</div>
	 * <div class="it">Code per Documento CIP non strutturato</div>
	 *<!-- @formatter:on -->
	 */
	public static final String UNSTRUCTURED_EPR_DOCUMENT_CODE = "urn:che:epr:EPR_Unstructured_Document";

	/**
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator fÃ¼r das Value Set</div>
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.9";

	/**
	 * <div class="en">Name of the value set</div> <div class="de">Name des
	 * Value Sets</div>
	 */
	public static final String VALUE_SET_NAME = "EprDocumentFormatCode";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static FormatCode getEnum(String code) {
		for (final FormatCode x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 * @param enumName
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(FormatCode.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Set vorhanden
	 * ist.</div>
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final FormatCode x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>
	 */
	private String code;

	/**
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instanziiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>.
	 *
	 * @param code
	 *            code
	 * @param codeSystem
	 *            codeSystem
	 * @param displayName
	 *            the default display name
	 * @param displayNameEn
	 *            the display name en
	 * @param displayNameDe
	 *            the display name de
	 * @param displayNameFr
	 *            the display name fr
	 * @param displayNameIt
	 *            the display name it
	 */
	FormatCode(String code, String codeSystem, String displayName, String displayNameEn,
			String displayNameDe, String displayNameFr, String displayNameIt) {
		this.code = code;
		this.codeSystem = codeSystem;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
		displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		displayNames.put(LanguageCode.GERMAN, displayNameDe);
		displayNames.put(LanguageCode.FRENCH, displayNameFr);
		displayNames.put(LanguageCode.ITALIAN, displayNameIt);
	}

	/**
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * den Code System Namen.</div>
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemName() {
		String retVal = "";
		final CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
		if (cs != null)
			retVal = cs.getCodeSystemName();
		return retVal;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is
	 * returned.</div> <div class="de">Liefert display name gemäss Parameter,
	 * falls es keine Englische Übersetzung gibt, wird der default-Name
	 * zurückgegeben.</div>
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	@Override
	public String getDisplayName(LanguageCode languageCode) {
		final String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * <div class="en">Gets the value set identifier.</div>
	 * <div class="de">Liefert den Value Set Identifikator.</div>
	 *
	 * @return <div class="en">the value set identifier</div>
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * <div class="en">Gets the value set name.</div> <div class="de">Liefert
	 * den Value Set Namen.</div>
	 *
	 * @return <div class="en">the value set name</div>
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
