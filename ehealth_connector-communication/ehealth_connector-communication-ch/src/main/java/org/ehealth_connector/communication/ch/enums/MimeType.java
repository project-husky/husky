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
package org.ehealth_connector.communication.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * Enumeration of DocumentEntry.mimeType values
 *
 * <div class="en">MIME type of the document as per Annex; EPRO-FDHA.</div>
 * <div class="de">MIME Typ des Dokumentes gemäss Anhang 3 EPDG.</div>
 * <div class="fr">MIME Type du document selon l'annexe 3 ODEP-DFI.</div>
 * <div class="it">Tipo MIME del documento secondo l'allegato 3 OCIP-DFI.</div>
 *
 * Identifier: 2.16.756.5.30.1.127.3.10.1.16
 * Effective date: 2019-12-11 14:58
 * Version: 201907.2-stable
 * Status: FINAL
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-03-05")
public enum MimeType implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">CDA Level 1 Multipart</div>
	 * <div class="de">CDA Level 1 Multipart</div>
	 * <div class="fr">CDA Level 1 Multipart</div>
	 * <div class="it">CDA Level 1 Multipart</div>
	 * <!-- @formatter:on -->
	 */
	CDA_LEVEL_1_MULTIPART("multipart/x-hl7-cda-level1", "2.16.840.1.113883.5.79",
			"CDA Level 1 Multipart", "CDA Level 1 Multipart", "CDA Level 1 Multipart",
			"CDA Level 1 Multipart", "CDA Level 1 Multipart"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">CSV Comma-separated Values</div>
	 * <div class="de">CSV Comma-separated Values</div>
	 * <div class="fr">CSV Comma-separated Values</div>
	 * <div class="it">CSV Comma-separated Values</div>
	 * <!-- @formatter:on -->
	 */
	CSV_COMMA_SEPARATED_VALUES("text/csv", "2.16.840.1.113883.5.79", "CSV Comma-separated Values",
			"CSV Comma-separated Values", "CSV Comma-separated Values",
			"CSV Comma-separated Values", "CSV Comma-separated Values"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">DICOM</div>
	 * <div class="de">DICOM</div>
	 * <div class="fr">DICOM</div>
	 * <div class="it">DICOM</div>
	 * <!-- @formatter:on -->
	 */
	DICOM("application/dicom", "2.16.840.1.113883.5.79", "DICOM", "DICOM", "DICOM", "DICOM",
			"DICOM"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Extensible 3D Graphics (VRML)</div>
	 * <div class="de">Extensible 3D Graphics (VRML)</div>
	 * <div class="fr">Extensible 3D Graphics (VRML)</div>
	 * <div class="it">Extensible 3D Graphics (VRML)</div>
	 * <!-- @formatter:on -->
	 */
	EXTENSIBLE_3D_GRAPHICS_VRML("model/x3d-vrml", "2.16.840.1.113883.5.79",
			"Extensible 3D Graphics (VRML)", "Extensible 3D Graphics (VRML)",
			"Extensible 3D Graphics (VRML)", "Extensible 3D Graphics (VRML)",
			"Extensible 3D Graphics (VRML)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Extensible 3D Graphics (XML)</div>
	 * <div class="de">Extensible 3D Graphics (XML)</div>
	 * <div class="fr">Extensible 3D Graphics (XML)</div>
	 * <div class="it">Extensible 3D Graphics (XML)</div>
	 * <!-- @formatter:on -->
	 */
	EXTENSIBLE_3D_GRAPHICS_XML("model/x3d+xml", "2.16.840.1.113883.5.79",
			"Extensible 3D Graphics (XML)", "Extensible 3D Graphics (XML)",
			"Extensible 3D Graphics (XML)", "Extensible 3D Graphics (XML)",
			"Extensible 3D Graphics (XML)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">FHIR (JSON)</div>
	 * <div class="de">FHIR (JSON)</div>
	 * <div class="fr">FHIR (JSON)</div>
	 * <div class="it">FHIR (JSON)</div>
	 * <!-- @formatter:on -->
	 */
	FHIR_JSON("application/fhir+json", "2.16.840.1.113883.5.79", "FHIR (JSON)", "FHIR (JSON)",
			"FHIR (JSON)", "FHIR (JSON)", "FHIR (JSON)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">FHIR (XML)</div>
	 * <div class="de">FHIR (XML)</div>
	 * <div class="fr">FHIR (XML)</div>
	 * <div class="it">FHIR (XML)</div>
	 * <!-- @formatter:on -->
	 */
	FHIR_XML("application/fhir+xml", "2.16.840.1.113883.5.79", "FHIR (XML)", "FHIR (XML)",
			"FHIR (XML)", "FHIR (XML)", "FHIR (XML)"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">GIF Graphics Interchange Format</div>
	 * <div class="de">GIF Graphics Interchange Format</div>
	 * <div class="fr">GIF Graphics Interchange Format</div>
	 * <div class="it">GIF Graphics Interchange Format</div>
	 * <!-- @formatter:on -->
	 */
	GIF_GRAPHICS_INTERCHANGE_FORMAT("image/gif", "2.16.840.1.113883.5.79",
			"GIF Graphics Interchange Format", "GIF Graphics Interchange Format",
			"GIF Graphics Interchange Format", "GIF Graphics Interchange Format",
			"GIF Graphics Interchange Format"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">JPEG 2000 Compound Image File</div>
	 * <div class="de">JPEG 2000 Compound Image File</div>
	 * <div class="fr">JPEG 2000 Compound Image File</div>
	 * <div class="it">JPEG 2000 Compound Image File</div>
	 * <!-- @formatter:on -->
	 */
	JPEG_2000_COMPOUND_IMAGE_FILE("image/jpm", "2.16.840.1.113883.5.79",
			"JPEG 2000 Compound Image File", "JPEG 2000 Compound Image File",
			"JPEG 2000 Compound Image File", "JPEG 2000 Compound Image File",
			"JPEG 2000 Compound Image File"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">JPEG 2000 Core Image File</div>
	 * <div class="de">JPEG 2000 Core Image File</div>
	 * <div class="fr">JPEG 2000 Core Image File</div>
	 * <div class="it">JPEG 2000 Core Image File</div>
	 * <!-- @formatter:on -->
	 */
	JPEG_2000_CORE_IMAGE_FILE("image/jp2", "2.16.840.1.113883.5.79", "JPEG 2000 Core Image File",
			"JPEG 2000 Core Image File", "JPEG 2000 Core Image File", "JPEG 2000 Core Image File",
			"JPEG 2000 Core Image File"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">JPEG 2000 Image File</div>
	 * <div class="de">JPEG 2000 Image File</div>
	 * <div class="fr">JPEG 2000 Image File</div>
	 * <div class="it">JPEG 2000 Image File</div>
	 * <!-- @formatter:on -->
	 */
	JPEG_2000_IMAGE_FILE("image/jpx", "2.16.840.1.113883.5.79", "JPEG 2000 Image File",
			"JPEG 2000 Image File", "JPEG 2000 Image File", "JPEG 2000 Image File",
			"JPEG 2000 Image File"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">JPEG Image</div>
	 * <div class="de">JPEG Image</div>
	 * <div class="fr">JPEG Image</div>
	 * <div class="it">JPEG Image</div>
	 * <!-- @formatter:on -->
	 */
	JPEG_IMAGE("image/jpeg", "2.16.840.1.113883.5.79", "JPEG Image", "JPEG Image", "JPEG Image",
			"JPEG Image", "JPEG Image"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Motion JPEG 2000</div>
	 * <div class="de">Motion JPEG 2000</div>
	 * <div class="fr">Motion JPEG 2000</div>
	 * <div class="it">Motion JPEG 2000</div>
	 * <!-- @formatter:on -->
	 */
	MOTION_JPEG_2000("video/mj2", "2.16.840.1.113883.5.79", "Motion JPEG 2000", "Motion JPEG 2000",
			"Motion JPEG 2000", "Motion JPEG 2000", "Motion JPEG 2000"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MP4 Audio</div>
	 * <div class="de">MP4 Audio</div>
	 * <div class="fr">MP4 Audio</div>
	 * <div class="it">MP4 Audio</div>
	 * <!-- @formatter:on -->
	 */
	MP4_AUDIO("audio/mp4", "2.16.840.1.113883.5.79", "MP4 Audio", "MP4 Audio", "MP4 Audio",
			"MP4 Audio", "MP4 Audio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MPEG-4 Part 14</div>
	 * <div class="de">MPEG-4 Part 14</div>
	 * <div class="fr">MPEG-4 Part 14</div>
	 * <div class="it">MPEG-4 Part 14</div>
	 * <!-- @formatter:on -->
	 */
	MPEG_4_PART_14("video/mp4", "2.16.840.1.113883.5.79", "MPEG-4 Part 14", "MPEG-4 Part 14",
			"MPEG-4 Part 14", "MPEG-4 Part 14", "MPEG-4 Part 14"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MPEG audio layer 3</div>
	 * <div class="de">MPEG audio layer 3</div>
	 * <div class="fr">MPEG audio layer 3</div>
	 * <div class="it">MPEG audio layer 3</div>
	 * <!-- @formatter:on -->
	 */
	MPEG_AUDIO_LAYER_3("audio/mpeg", "2.16.840.1.113883.5.79", "MPEG audio layer 3",
			"MPEG audio layer 3", "MPEG audio layer 3", "MPEG audio layer 3", "MPEG audio layer 3"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">MPEG Video</div>
	 * <div class="de">MPEG Video</div>
	 * <div class="fr">MPEG Video</div>
	 * <div class="it">MPEG Video</div>
	 * <!-- @formatter:on -->
	 */
	MPEG_VIDEO("video/mpeg", "2.16.840.1.113883.5.79", "MPEG Video", "MPEG Video", "MPEG Video",
			"MPEG Video", "MPEG Video"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Multilingual Multipart</div>
	 * <div class="de">Multilingual Multipart</div>
	 * <div class="fr">Multilingual Multipart</div>
	 * <div class="it">Multilingual Multipart</div>
	 * <!-- @formatter:on -->
	 */
	MULTILINGUAL_MULTIPART("multipart/multilingual", "2.16.840.1.113883.5.79",
			"Multilingual Multipart", "Multilingual Multipart", "Multilingual Multipart",
			"Multilingual Multipart", "Multilingual Multipart"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PDF</div>
	 * <div class="de">PDF</div>
	 * <div class="fr">PDF</div>
	 * <div class="it">PDF</div>
	 * <!-- @formatter:on -->
	 */
	PDF("application/pdf", "2.16.840.1.113883.5.79", "PDF", "PDF", "PDF", "PDF", "PDF"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Plain Text</div>
	 * <div class="de">Plain Text</div>
	 * <div class="fr">Plain Text</div>
	 * <div class="it">Plain Text</div>
	 * <!-- @formatter:on -->
	 */
	PLAIN_TEXT("text/plain", "2.16.840.1.113883.5.79", "Plain Text", "Plain Text", "Plain Text",
			"Plain Text", "Plain Text"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">PNG Portable Network Graphics</div>
	 * <div class="de">PNG Portable Network Graphics</div>
	 * <div class="fr">PNG Portable Network Graphics</div>
	 * <div class="it">PNG Portable Network Graphics</div>
	 * <!-- @formatter:on -->
	 */
	PNG_PORTABLE_NETWORK_GRAPHICS("image/png", "2.16.840.1.113883.5.79",
			"PNG Portable Network Graphics", "PNG Portable Network Graphics",
			"PNG Portable Network Graphics", "PNG Portable Network Graphics",
			"PNG Portable Network Graphics"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Signed Multipart</div>
	 * <div class="de">Signed Multipart</div>
	 * <div class="fr">Signed Multipart</div>
	 * <div class="it">Signed Multipart</div>
	 * <!-- @formatter:on -->
	 */
	SIGNED_MULTIPART("multipart/signed", "2.16.840.1.113883.5.79", "Signed Multipart",
			"Signed Multipart", "Signed Multipart", "Signed Multipart", "Signed Multipart"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">TIFF Image</div>
	 * <div class="de">TIFF Image</div>
	 * <div class="fr">TIFF Image</div>
	 * <div class="it">TIFF Image</div>
	 * <!-- @formatter:on -->
	 */
	TIFF_IMAGE("image/tiff", "2.16.840.1.113883.5.79", "TIFF Image", "TIFF Image", "TIFF Image",
			"TIFF Image", "TIFF Image"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Virtual Reality Modeling Language</div>
	 * <div class="de">Virtual Reality Modeling Language</div>
	 * <div class="fr">Virtual Reality Modeling Language</div>
	 * <div class="it">Virtual Reality Modeling Language</div>
	 * <!-- @formatter:on -->
	 */
	VIRTUAL_REALITY_MODELING_LANGUAGE("model/vrml", "2.16.840.1.113883.5.79",
			"Virtual Reality Modeling Language", "Virtual Reality Modeling Language",
			"Virtual Reality Modeling Language", "Virtual Reality Modeling Language",
			"Virtual Reality Modeling Language"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">XML-Text</div>
	 * <div class="de">XML-Text</div>
	 * <div class="fr">XML-Text</div>
	 * <div class="it">XML-Text</div>
	 * <!-- @formatter:on -->
	 */
	XML_TEXT("text/xml", "2.16.840.1.113883.5.79", "XML-Text", "XML-Text", "XML-Text", "XML-Text",
			"XML-Text");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for CDA Level 1 Multipart</div>
	 * <div class="de">Code für CDA Level 1 Multipart</div>
	 * <div class="fr">Code de CDA Level 1 Multipart</div>
	 * <div class="it">Code per CDA Level 1 Multipart</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CDA_LEVEL_1_MULTIPART_CODE = "multipart/x-hl7-cda-level1";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for CSV Comma-separated Values</div>
	 * <div class="de">Code für CSV Comma-separated Values</div>
	 * <div class="fr">Code de CSV Comma-separated Values</div>
	 * <div class="it">Code per CSV Comma-separated Values</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CSV_COMMA_SEPARATED_VALUES_CODE = "text/csv";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for DICOM</div>
	 * <div class="de">Code für DICOM</div>
	 * <div class="fr">Code de DICOM</div>
	 * <div class="it">Code per DICOM</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DICOM_CODE = "application/dicom";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Extensible 3D Graphics (VRML)</div>
	 * <div class="de">Code für Extensible 3D Graphics (VRML)</div>
	 * <div class="fr">Code de Extensible 3D Graphics (VRML)</div>
	 * <div class="it">Code per Extensible 3D Graphics (VRML)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EXTENSIBLE_3D_GRAPHICS_VRML_CODE = "model/x3d-vrml";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Extensible 3D Graphics (XML)</div>
	 * <div class="de">Code für Extensible 3D Graphics (XML)</div>
	 * <div class="fr">Code de Extensible 3D Graphics (XML)</div>
	 * <div class="it">Code per Extensible 3D Graphics (XML)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EXTENSIBLE_3D_GRAPHICS_XML_CODE = "model/x3d+xml";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for FHIR (JSON)</div>
	 * <div class="de">Code für FHIR (JSON)</div>
	 * <div class="fr">Code de FHIR (JSON)</div>
	 * <div class="it">Code per FHIR (JSON)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FHIR_JSON_CODE = "application/fhir+json";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for FHIR (XML)</div>
	 * <div class="de">Code für FHIR (XML)</div>
	 * <div class="fr">Code de FHIR (XML)</div>
	 * <div class="it">Code per FHIR (XML)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FHIR_XML_CODE = "application/fhir+xml";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for GIF Graphics Interchange Format</div>
	 * <div class="de">Code für GIF Graphics Interchange Format</div>
	 * <div class="fr">Code de GIF Graphics Interchange Format</div>
	 * <div class="it">Code per GIF Graphics Interchange Format</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GIF_GRAPHICS_INTERCHANGE_FORMAT_CODE = "image/gif";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for JPEG 2000 Compound Image File</div>
	 * <div class="de">Code für JPEG 2000 Compound Image File</div>
	 * <div class="fr">Code de JPEG 2000 Compound Image File</div>
	 * <div class="it">Code per JPEG 2000 Compound Image File</div>
	 * <!-- @formatter:on -->
	 */
	public static final String JPEG_2000_COMPOUND_IMAGE_FILE_CODE = "image/jpm";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for JPEG 2000 Core Image File</div>
	 * <div class="de">Code für JPEG 2000 Core Image File</div>
	 * <div class="fr">Code de JPEG 2000 Core Image File</div>
	 * <div class="it">Code per JPEG 2000 Core Image File</div>
	 * <!-- @formatter:on -->
	 */
	public static final String JPEG_2000_CORE_IMAGE_FILE_CODE = "image/jp2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for JPEG 2000 Image File</div>
	 * <div class="de">Code für JPEG 2000 Image File</div>
	 * <div class="fr">Code de JPEG 2000 Image File</div>
	 * <div class="it">Code per JPEG 2000 Image File</div>
	 * <!-- @formatter:on -->
	 */
	public static final String JPEG_2000_IMAGE_FILE_CODE = "image/jpx";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for JPEG Image</div>
	 * <div class="de">Code für JPEG Image</div>
	 * <div class="fr">Code de JPEG Image</div>
	 * <div class="it">Code per JPEG Image</div>
	 * <!-- @formatter:on -->
	 */
	public static final String JPEG_IMAGE_CODE = "image/jpeg";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Motion JPEG 2000</div>
	 * <div class="de">Code für Motion JPEG 2000</div>
	 * <div class="fr">Code de Motion JPEG 2000</div>
	 * <div class="it">Code per Motion JPEG 2000</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MOTION_JPEG_2000_CODE = "video/mj2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MP4 Audio</div>
	 * <div class="de">Code für MP4 Audio</div>
	 * <div class="fr">Code de MP4 Audio</div>
	 * <div class="it">Code per MP4 Audio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MP4_AUDIO_CODE = "audio/mp4";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MPEG-4 Part 14</div>
	 * <div class="de">Code für MPEG-4 Part 14</div>
	 * <div class="fr">Code de MPEG-4 Part 14</div>
	 * <div class="it">Code per MPEG-4 Part 14</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MPEG_4_PART_14_CODE = "video/mp4";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MPEG audio layer 3</div>
	 * <div class="de">Code für MPEG audio layer 3</div>
	 * <div class="fr">Code de MPEG audio layer 3</div>
	 * <div class="it">Code per MPEG audio layer 3</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MPEG_AUDIO_LAYER_3_CODE = "audio/mpeg";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for MPEG Video</div>
	 * <div class="de">Code für MPEG Video</div>
	 * <div class="fr">Code de MPEG Video</div>
	 * <div class="it">Code per MPEG Video</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MPEG_VIDEO_CODE = "video/mpeg";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Multilingual Multipart</div>
	 * <div class="de">Code für Multilingual Multipart</div>
	 * <div class="fr">Code de Multilingual Multipart</div>
	 * <div class="it">Code per Multilingual Multipart</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MULTILINGUAL_MULTIPART_CODE = "multipart/multilingual";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PDF</div>
	 * <div class="de">Code für PDF</div>
	 * <div class="fr">Code de PDF</div>
	 * <div class="it">Code per PDF</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PDF_CODE = "application/pdf";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Plain Text</div>
	 * <div class="de">Code für Plain Text</div>
	 * <div class="fr">Code de Plain Text</div>
	 * <div class="it">Code per Plain Text</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PLAIN_TEXT_CODE = "text/plain";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for PNG Portable Network Graphics</div>
	 * <div class="de">Code für PNG Portable Network Graphics</div>
	 * <div class="fr">Code de PNG Portable Network Graphics</div>
	 * <div class="it">Code per PNG Portable Network Graphics</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PNG_PORTABLE_NETWORK_GRAPHICS_CODE = "image/png";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Signed Multipart</div>
	 * <div class="de">Code für Signed Multipart</div>
	 * <div class="fr">Code de Signed Multipart</div>
	 * <div class="it">Code per Signed Multipart</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SIGNED_MULTIPART_CODE = "multipart/signed";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for TIFF Image</div>
	 * <div class="de">Code für TIFF Image</div>
	 * <div class="fr">Code de TIFF Image</div>
	 * <div class="it">Code per TIFF Image</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TIFF_IMAGE_CODE = "image/tiff";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Virtual Reality Modeling Language</div>
	 * <div class="de">Code für Virtual Reality Modeling Language</div>
	 * <div class="fr">Code de Virtual Reality Modeling Language</div>
	 * <div class="it">Code per Virtual Reality Modeling Language</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VIRTUAL_REALITY_MODELING_LANGUAGE_CODE = "model/vrml";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for XML-Text</div>
	 * <div class="de">Code für XML-Text</div>
	 * <div class="fr">Code de XML-Text</div>
	 * <div class="it">Code per XML-Text</div>
	 * <!-- @formatter:on -->
	 */
	public static final String XML_TEXT_CODE = "text/xml";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.16";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "DocumentEntry.mimeType";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static MimeType getEnum(final String code) {
		for (final MimeType x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der angegebene enum Teil dieses Value Sets ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param enumName
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(final String enumName) {
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
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der angegebene code in diesem Value Set vorhanden ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(final String codeValue) {
		for (final MimeType x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Machine interpretable and (inside this class) unique code</div>
	 * <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse) eindeutiger Code</div>
	 * <!-- @formatter:on -->
	 */
	private String code;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 * <!-- @formatter:on -->
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
	 * <div class="de">Instanziiert dieses Enum Object mittels eines Codes und einem Display Name</div>.
	 * <!-- @formatter:on -->
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
	MimeType(final String code, final String codeSystem, final String displayName,
			final String displayNameEn, final String displayNameDe, final String displayNameFr,
			final String displayNameIt) {
		this.code = code;
		this.codeSystem = codeSystem;
		this.displayNames = new HashMap<>();
		this.displayNames.put(null, displayName);
		this.displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		this.displayNames.put(LanguageCode.GERMAN, displayNameDe);
		this.displayNames.put(LanguageCode.FRENCH, displayNameFr);
		this.displayNames.put(LanguageCode.ITALIAN, displayNameIt);
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system name.</div>
	 * <div class="de">Liefert den Code System Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemName() {
		String retVal = "";
		CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
		if (cs != null)
			retVal = cs.getCodeSystemName();
		return retVal;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is returned.</div>
	 * <div class="de">Liefert display name gemäss Parameter, falls es keine
	 * Englische Übersetzung gibt, wird der default-Name zurückgegeben.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	@Override
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = this.displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return this.displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set identifier.</div>
	 * <div class="de">Liefert den Value Set Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set identifier</div>
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set name.</div>
	 * <div class="de">Liefert den Value Set Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set name</div>
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
