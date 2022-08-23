/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.common.at.enums;

import java.util.HashMap;
import java.util.Map;

public enum MimeType implements ValueSetEnumInterfaceAt {

	DICOM("application/dicom", "2.16.840.1.113883.5.79", "DICOM Service Object"),

	GIF_GRAPHICS_INTERCHANGE_FORMAT("image/gif", "2.16.840.1.113883.5.79", "Mime Type image/gif"),

	JPEG_IMAGE("image/jpeg", "2.16.840.1.113883.5.79", "Mime Type image/jpeg"),

	MPEG_AUDIO_LAYER_3("audio/mpeg", "2.16.840.1.113883.5.79", "Mime Type audio/mpeg"),

	MPEG_VIDEO("video/mpeg", "2.16.840.1.113883.5.79", "Mime Type video/mpeg"),

	PDF("application/pdf", "2.16.840.1.113883.5.79", "Mime Type application/pdf"),

	PNG_PORTABLE_NETWORK_GRAPHICS("image/png", "2.16.840.1.113883.5.79", "Mime Type image/png"),

	XML_TEXT("text/xml", "2.16.840.1.113883.5.79", "Mime Type text/xml");

	public static final String DICOM_CODE = "application/dicom";

	public static final String GIF_GRAPHICS_INTERCHANGE_FORMAT_CODE = "image/gif";

	public static final String JPEG_IMAGE_CODE = "image/jpeg";

	public static final String MPEG_AUDIO_LAYER_3_CODE = "audio/mpeg";

	public static final String MPEG_VIDEO_CODE = "video/mpeg";

	public static final String PDF_CODE = "application/pdf";

	public static final String PNG_PORTABLE_NETWORK_GRAPHICS_CODE = "image/png";

	public static final String XML_TEXT_CODE = "text/xml";

	/**
	 * Identifier of the value set
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.14824";

	/**
	 * Name of the value set
	 */
	public static final String VALUE_SET_NAME = "MediaType";

	/**
	 * Gets the Enum with a given code
	 *
	 * @param code
	 * 
	 * @return the enum
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
	 * Checks if a given enum is part of this value set.
	 *
	 * @param enumName
	 * 
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
	 * Checks if a given code value is in this value set.
	 *
	 * @param codeValue
	 * 
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
	 * Machine interpretable and (inside this class) unique code
	 */
	private String code;

	/**
	 * Identifier of the referencing code system.
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * Instantiates this Enum Object with a given Code and Display Name
	 *
	 * @param code        code
	 * @param codeSystem  codeSystem
	 * @param displayName the default display name
	 */
	MimeType(String code, String codeSystem, String displayName) {
		this.code = code;
		this.codeSystem = codeSystem;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
	}

	/**
	 * Gets the code system identifier.
	 *
	 * @return the code system identifier
	 */
	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * Gets the code system name.
	 *
	 * @return the code system identifier
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
	 * Gets the actual Code as string
	 *
	 * @return the code
	 */
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * Gets the display name defined by the language param. If there is no english
	 * translation, the default display name is returned.
	 *
	 * @param languageCode the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	@Override
	public String getDisplayNameAt(LanguageCode languageCode) {
		String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * Gets the value set identifier.
	 *
	 * @return the value set identifier
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * Gets the value set name.
	 *
	 * @return the value set name
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
