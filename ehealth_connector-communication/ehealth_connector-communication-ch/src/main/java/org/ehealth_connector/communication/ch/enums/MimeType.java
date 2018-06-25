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

import org.ehealth_connector.common.ch.enums.ValueSetEnumInterface;
import org.ehealth_connector.common.enums.LanguageCode;

/**
 *<!-- @formatter:off -->
 * <div class="en">MIME type of the document as per Annex 3&amp;#160; EPRO-FDHA, Chapter 2.8.&lt;br clear="none"/&gt;</div>
 * <div class="de">MIME Typ des Dokumentes gemäss Anhang 3 EPDG, Kapitel 2.8.&lt;br clear="none"/&gt;</div>
 * <div class="fr">MIME Type du document selon l'annexe 3 ODEP-DFI, chapitre 2.8.&lt;br clear="none"/&gt;</div>
 * <div class="it">Tipo MIME del documento secondo l'allegato 3 OCIP-DFI, capitolo 2.8.&lt;br clear="none"/&gt;</div>
 *<!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum MimeType implements ValueSetEnumInterface {

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">CDA Level 1 Multipart</div>
	 * <div class="de">CDA Level 1 Multipart</div>
	 * <div class="fr">CDA Level 1 Multipart</div>
	 * <div class="it">CDA Level 1 Multipart</div>
	 *<!-- @formatter:on -->
	 */
	CDA_LEVEL_1_MULTIPART("multipart/x-hl7-cda-level1", "2.16.840.1.113883.5.79",
			"CDA Level 1 Multipart", "CDA Level 1 Multipart", "CDA Level 1 Multipart",
			"CDA Level 1 Multipart", "CDA Level 1 Multipart"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">DICOM</div>
	 * <div class="de">DICOM</div>
	 * <div class="fr">DICOM</div>
	 * <div class="it">DICOM</div>
	 *<!-- @formatter:on -->
	 */
	DICOM("application/dicom", "2.16.840.1.113883.5.79", "DICOM", "DICOM", "DICOM", "DICOM",
			"DICOM"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">FHIR (JSON)</div>
	 * <div class="de">FHIR (JSON)</div>
	 * <div class="fr">FHIR (JSON)</div>
	 * <div class="it">FHIR (JSON)</div>
	 *<!-- @formatter:on -->
	 */
	FHIR__JSON_("application/fhir+json", "2.16.840.1.113883.5.79", "FHIR (JSON)", "FHIR (JSON)",
			"FHIR (JSON)", "FHIR (JSON)", "FHIR (JSON)"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">FHIR (XML)</div>
	 * <div class="de">FHIR (XML)</div>
	 * <div class="fr">FHIR (XML)</div>
	 * <div class="it">FHIR (XML)</div>
	 *<!-- @formatter:on -->
	 */
	FHIR__XML_("application/fhir+xml", "2.16.840.1.113883.5.79", "FHIR (XML)", "FHIR (XML)",
			"FHIR (XML)", "FHIR (XML)", "FHIR (XML)"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">GIF Graphics Interchange Format</div>
	 * <div class="de">GIF Graphics Interchange Format</div>
	 * <div class="fr">GIF Graphics Interchange Format</div>
	 * <div class="it">GIF Graphics Interchange Format</div>
	 *<!-- @formatter:on -->
	 */
	GIF_GRAPHICS_INTERCHANGE_FORMAT("image/gif", "2.16.840.1.113883.5.79",
			"GIF Graphics Interchange Format", "GIF Graphics Interchange Format",
			"GIF Graphics Interchange Format", "GIF Graphics Interchange Format",
			"GIF Graphics Interchange Format"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">JPEG Image</div>
	 * <div class="de">JPEG Image</div>
	 * <div class="fr">JPEG Image</div>
	 * <div class="it">JPEG Image</div>
	 *<!-- @formatter:on -->
	 */
	JPEG_IMAGE("image/jpeg", "2.16.840.1.113883.5.79", "JPEG Image", "JPEG Image", "JPEG Image",
			"JPEG Image", "JPEG Image"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">MPEG audio layer 3</div>
	 * <div class="de">MPEG audio layer 3</div>
	 * <div class="fr">MPEG audio layer 3</div>
	 * <div class="it">MPEG audio layer 3</div>
	 *<!-- @formatter:on -->
	 */
	MPEG_AUDIO_LAYER_3("audio/mpeg", "2.16.840.1.113883.5.79", "MPEG audio layer 3",
			"MPEG audio layer 3", "MPEG audio layer 3", "MPEG audio layer 3", "MPEG audio layer 3"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">MPEG Video</div>
	 * <div class="de">MPEG Video</div>
	 * <div class="fr">MPEG Video</div>
	 * <div class="it">MPEG Video</div>
	 *<!-- @formatter:on -->
	 */
	MPEG_VIDEO("video/mpeg", "2.16.840.1.113883.5.79", "MPEG Video", "MPEG Video", "MPEG Video",
			"MPEG Video", "MPEG Video"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">PDF</div>
	 * <div class="de">PDF</div>
	 * <div class="fr">PDF</div>
	 * <div class="it">PDF</div>
	 *<!-- @formatter:on -->
	 */
	PDF("application/pdf", "2.16.840.1.113883.5.79", "PDF", "PDF", "PDF", "PDF", "PDF"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Plain Text</div>
	 * <div class="de">Plain Text</div>
	 * <div class="fr">Plain Text</div>
	 * <div class="it">Plain Text</div>
	 *<!-- @formatter:on -->
	 */
	PLAIN_TEXT("text/plain", "2.16.840.1.113883.5.79", "Plain Text", "Plain Text", "Plain Text",
			"Plain Text", "Plain Text"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">PNG Portable Network Graphics</div>
	 * <div class="de">PNG Portable Network Graphics</div>
	 * <div class="fr">PNG Portable Network Graphics</div>
	 * <div class="it">PNG Portable Network Graphics</div>
	 *<!-- @formatter:on -->
	 */
	PNG_PORTABLE_NETWORK_GRAPHICS("image/png", "2.16.840.1.113883.5.79",
			"PNG Portable Network Graphics", "PNG Portable Network Graphics",
			"PNG Portable Network Graphics", "PNG Portable Network Graphics",
			"PNG Portable Network Graphics"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">TIFF Image</div>
	 * <div class="de">TIFF Image</div>
	 * <div class="fr">TIFF Image</div>
	 * <div class="it">TIFF Image</div>
	 *<!-- @formatter:on -->
	 */
	TIFF_IMAGE("image/tiff", "2.16.840.1.113883.5.79", "TIFF Image", "TIFF Image", "TIFF Image",
			"TIFF Image", "TIFF Image"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">XML-Text</div>
	 * <div class="de">XML-Text</div>
	 * <div class="fr">XML-Text</div>
	 * <div class="it">XML-Text</div>
	 *<!-- @formatter:on -->
	 */
	XML_TEXT("text/xml", "2.16.840.1.113883.5.79", "XML-Text", "XML-Text", "XML-Text", "XML-Text",
			"XML-Text");

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for CDA Level 1 Multipart</div>
	 * <div class="de">Code für CDA Level 1 Multipart</div>
	 * <div class="fr">Code de CDA Level 1 Multipart</div>
	 * <div class="it">Code per CDA Level 1 Multipart</div>
	 *<!-- @formatter:on -->
	 */
	public static final String CDA_LEVEL_1_MULTIPART_CODE = "multipart/x-hl7-cda-level1";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for DICOM</div>
	 * <div class="de">Code für DICOM</div>
	 * <div class="fr">Code de DICOM</div>
	 * <div class="it">Code per DICOM</div>
	 *<!-- @formatter:on -->
	 */
	public static final String DICOM_CODE = "application/dicom";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for FHIR (JSON)</div>
	 * <div class="de">Code für FHIR (JSON)</div>
	 * <div class="fr">Code de FHIR (JSON)</div>
	 * <div class="it">Code per FHIR (JSON)</div>
	 *<!-- @formatter:on -->
	 */
	public static final String FHIR__JSON__CODE = "application/fhir+json";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for FHIR (XML)</div>
	 * <div class="de">Code für FHIR (XML)</div>
	 * <div class="fr">Code de FHIR (XML)</div>
	 * <div class="it">Code per FHIR (XML)</div>
	 *<!-- @formatter:on -->
	 */
	public static final String FHIR__XML__CODE = "application/fhir+xml";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for GIF Graphics Interchange Format</div>
	 * <div class="de">Code für GIF Graphics Interchange Format</div>
	 * <div class="fr">Code de GIF Graphics Interchange Format</div>
	 * <div class="it">Code per GIF Graphics Interchange Format</div>
	 *<!-- @formatter:on -->
	 */
	public static final String GIF_GRAPHICS_INTERCHANGE_FORMAT_CODE = "image/gif";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for JPEG Image</div>
	 * <div class="de">Code für JPEG Image</div>
	 * <div class="fr">Code de JPEG Image</div>
	 * <div class="it">Code per JPEG Image</div>
	 *<!-- @formatter:on -->
	 */
	public static final String JPEG_IMAGE_CODE = "image/jpeg";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for MPEG audio layer 3</div>
	 * <div class="de">Code für MPEG audio layer 3</div>
	 * <div class="fr">Code de MPEG audio layer 3</div>
	 * <div class="it">Code per MPEG audio layer 3</div>
	 *<!-- @formatter:on -->
	 */
	public static final String MPEG_AUDIO_LAYER_3_CODE = "audio/mpeg";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for MPEG Video</div>
	 * <div class="de">Code für MPEG Video</div>
	 * <div class="fr">Code de MPEG Video</div>
	 * <div class="it">Code per MPEG Video</div>
	 *<!-- @formatter:on -->
	 */
	public static final String MPEG_VIDEO_CODE = "video/mpeg";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for PDF</div>
	 * <div class="de">Code für PDF</div>
	 * <div class="fr">Code de PDF</div>
	 * <div class="it">Code per PDF</div>
	 *<!-- @formatter:on -->
	 */
	public static final String PDF_CODE = "application/pdf";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Plain Text</div>
	 * <div class="de">Code für Plain Text</div>
	 * <div class="fr">Code de Plain Text</div>
	 * <div class="it">Code per Plain Text</div>
	 *<!-- @formatter:on -->
	 */
	public static final String PLAIN_TEXT_CODE = "text/plain";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for PNG Portable Network Graphics</div>
	 * <div class="de">Code für PNG Portable Network Graphics</div>
	 * <div class="fr">Code de PNG Portable Network Graphics</div>
	 * <div class="it">Code per PNG Portable Network Graphics</div>
	 *<!-- @formatter:on -->
	 */
	public static final String PNG_PORTABLE_NETWORK_GRAPHICS_CODE = "image/png";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for TIFF Image</div>
	 * <div class="de">Code für TIFF Image</div>
	 * <div class="fr">Code de TIFF Image</div>
	 * <div class="it">Code per TIFF Image</div>
	 *<!-- @formatter:on -->
	 */
	public static final String TIFF_IMAGE_CODE = "image/tiff";

	/**
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.16";

	/**
	 * <div class="en">Name of the value set</div> <div class="de">Name des
	 * Value Sets</div>
	 */
	public static final String VALUE_SET_NAME = "EprDocumentMimeType";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for XML-Text</div>
	 * <div class="de">Code für XML-Text</div>
	 * <div class="fr">Code de XML-Text</div>
	 * <div class="it">Code per XML-Text</div>
	 *<!-- @formatter:on -->
	 */
	public static final String XML_TEXT_CODE = "text/xml";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static MimeType getEnum(String code) {
		for (final MimeType x : values()) {
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
			Enum.valueOf(MimeType.class, enumName);
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
		for (final MimeType x : values()) {
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
	MimeType(String code, String codeSystem, String displayName, String displayNameEn,
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
	public String getCodeSystemValue() {
		return this.codeSystem;
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
		String displayName = displayNames.get(languageCode);
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
