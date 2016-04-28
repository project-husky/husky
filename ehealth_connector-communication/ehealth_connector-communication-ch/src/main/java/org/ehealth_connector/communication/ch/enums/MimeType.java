/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.communication.ch.enums;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.CodedMetadataEnumInterface;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.openhealthtools.ihe.xds.metadata.CodedMetadataType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;

/**
 * <div class="de">MIME Typ des XDS Dokuments in der Dokumentenablage. </div>
 * <div class="fr"></div>
 */
public enum MimeType implements CodedMetadataEnumInterface {

	/**
	 * <div class="de">CDA Level 1 Multipart</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	CDA_LEVEL_1_MULTIPART("multipart/x-hl7-cda-level1  ", "CDA Level 1 Multipart"),
	/**
	 * <div class="de">DICOM</div> <div class="fr"></div> <div class="it"></div>
	 */
	DICOM("application/dicom", "DICOM"),
	/**
	 * <div class="de">JPEG Image</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	JPEG_IMAGE("image/jpeg", "JPEG Image"),
	/**
	 * <div class="de">MPEG audio layer 3</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	MPEG_AUDIO_LAYER_3("audio/mpeg", "MPEG audio layer 3"),
	/**
	 * <div class="de">MPEG Video</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	MPEG_VIDEO("video/mpeg", "MPEG Video"),
	/**
	 * <div class="de">PDF</div> <div class="fr"></div> <div class="it"></div>
	 */
	PDF("application/pdf", "PDF"),
	/**
	 * <div class="de">Plain Text</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	PLAIN_TEXT("text/plain", "Plain Text"),
	/**
	 * <div class="de">TIFF Image</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	TIFF_IMAGE("image/tiff", "TIFF Image"),
	/**
	 * <div class="de">XML-Text</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	XML_TEXT("text/xml", "XML-Text");

	/**
	 * <div class="de">Code für CDA Level 1 Multipart</div>
	 */
	public static final String CDA_LEVEL_1_MULTIPART_CODE = "multipart/x-hl7-cda-level1  ";

	/**
	 * <div class="de">Code für DICOM</div>
	 */
	public static final String DICOM_CODE = "application/dicom";

	/**
	 * <div class="de">Code für JPEG Image</div>
	 */
	public static final String JPEG_IMAGE_CODE = "image/jpeg";

	/**
	 * <div class="de">Code für MPEG audio layer 3</div>
	 */
	public static final String MPEG_AUDIO_LAYER_3_CODE = "audio/mpeg";

	/**
	 * <div class="de">Code für MPEG Video</div>
	 */
	public static final String MPEG_VIDEO_CODE = "video/mpeg";

	/**
	 * <div class="de">Code für PDF</div>
	 */
	public static final String PDF_CODE = "application/pdf";

	/**
	 * <div class="de">Code für Plain Text</div>
	 */
	public static final String PLAIN_TEXT_CODE = "text/plain";

	/**
	 * <div class="de">Code für TIFF Image</div>
	 */
	public static final String TIFF_IMAGE_CODE = "image/tiff";

	/**
	 * <div class="de">Code für XML-Text</div>
	 */
	public static final String XML_TEXT_CODE = "text/xml";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.1.127.3.10.1.16";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "epd_xds_mimeType";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
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
	 *            <br>
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
	 *            <div class="de">code</div>
	 * @return true, if one enum of this valueset contains the given code
	 */
	public static boolean isInValueSet(String codeValue) {
		for (MimeType x : values()) {
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
	 * <div class="en">Human readable name</div>
	 * <div class="de">Menschenlesbarer Name</div>
	 */
	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 *            <br>
	 *            <div class="de"> display name</div>
	 */
	private MimeType(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}

	/**
	 * <div class="en">Gets the OHT CodedMetadataType Object</div>
	 * <div class="de">Liefert das OHT CodedMetadataType Objekt</div>
	 *
	 * @return <div class="en">the codedMetadataType</div>
	 */
	@Override
	public CodedMetadataType getCodedMetadataType() {
		final CodedMetadataType cmt = MetadataFactory.eINSTANCE.createCodedMetadataType();
		cmt.setSchemeName(CODE_SYSTEM_OID);
		cmt.setCode(this.getCodeValue());
		cmt.setDisplayName(
				XdsMetadataUtil.createInternationalString(this.getDisplayName(), "de-ch"));
		return cmt;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return this.displayName;
	}
}
