package org.projecthusky.common.enums;

public enum DocumentDescriptor {

	CDA_R2("CDA-R2", EnumConstants.TEXT_XML),
	XDS_MS("XDS-MS", "text/x-cda-r2+xml"),
	XDS_LAB("XDS-LAB", EnumConstants.TEXT_XML),
	XDS_SD("XDS-SD", EnumConstants.TEXT_XML),
	CDA_R1("CDA-R1", EnumConstants.TEXT_XML),
	CCR("CCR", EnumConstants.TEXT_XML),
	XML("XML", EnumConstants.TEXT_XML),
	FHIR_JSON("FHIR-JSON", "application/fhir+json"),
	PDF("PDF", "application/pdf"),
	DICOM("DICOM", "application/dicom"),
	HL7_LAB("HL7-lab", "application/x-hl7"),
	UNKNOWN("UNKNOWN", "application/octet-stream");

	private String descriptor;

	private String format;

	private String mimeType;

	/**
	 * Constructor used to form descriptor objects
	 * 
	 * @param format
	 * @param mimeType
	 */
	private DocumentDescriptor(String format, String mimeType) {
		this.format = format;
		this.mimeType = mimeType;

	}

	public String getMimeType() {
		return this.mimeType;
	}

	public String getFormat() {
		return this.format;
	}

	public String getDescriptor() {
		return this.descriptor;
	}



	public static DocumentDescriptor getDocumentDescriptorForMimeType(String mimeType) {
		if (XML.getMimeType().equalsIgnoreCase(mimeType)) {
			return XML;
		} else if (PDF.getMimeType().equalsIgnoreCase(mimeType)) {
			return PDF;
		} else if (HL7_LAB.getMimeType().equalsIgnoreCase(mimeType)) {
			return HL7_LAB;
		} else if (DICOM.getMimeType().equalsIgnoreCase(mimeType)) {
			return DICOM;
		} else if (CDA_R2.getMimeType().equalsIgnoreCase(mimeType)) {
			return CDA_R2;
		} else if (XDS_MS.getMimeType().equalsIgnoreCase(mimeType)) {
			return XDS_MS;
		} else if (XDS_LAB.getMimeType().equalsIgnoreCase(mimeType)) {
			return XDS_LAB;
		} else if (XDS_SD.getMimeType().equalsIgnoreCase(mimeType)) {
			return XDS_SD;
		} else if (CDA_R1.getMimeType().equalsIgnoreCase(mimeType)) {
			return CDA_R1;
		} else if (CCR.getMimeType().equalsIgnoreCase(mimeType)) {
			return CCR;
		} else if (FHIR_JSON.getMimeType().equalsIgnoreCase(mimeType)) {
			return FHIR_JSON;
		}
		
		return UNKNOWN;
	}

}
