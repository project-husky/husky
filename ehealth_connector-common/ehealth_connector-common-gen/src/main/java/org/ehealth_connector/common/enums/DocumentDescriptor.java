package org.ehealth_connector.common.enums;

public enum DocumentDescriptor {

	CDA_R2("CDA-R2", "text/xml"), XDS_MS("XDS-MS", "text/x-cda-r2+xml"), XDS_LAB("XDS-LAB", "text/xml"),
	XDS_SD("XDS-SD", "text/xml"), CDA_R1("CDA-R1", "text/xml"), CCR("CCR", "text/xml"), XML("XML", "text/xml"),
	PDF("PDF", "application/pdf"), DICOM("DICOM", "application/dicom"), HL7_LAB("HL7-lab", "application/x-hl7"),
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
		}

		return UNKNOWN;
	}

}
