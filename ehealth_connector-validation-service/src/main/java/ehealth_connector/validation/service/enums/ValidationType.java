package ehealth_connector.validation.service.enums;

public enum ValidationType {
	
	SCHEMA("xsd","SCHEMA"),
	
	SCHEMATRON("svrl","SCHEMATRON"),
	
	PDF("pdf","PDF");
	
	public static final String SCHEMA_CODE = "xsd";
	public static final String SCHEMATRON_CODE = "svrl";
	public static final String PDF_CODE = "pdf";
	
	
	
	
	private String code;

	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and Display
	 * Name</div> <div class="de">Instantiiert dieses Enum Object mittels eines
	 * Codes und einem Display Name</div>
	 *
	 * @param code
	 *          <br>
	 *          <div class="de"> code</div>
	 * @param displayName
	 *          <br>
	 *          <div class="de"> display name</div>
	 */
	private ValidationType(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

}
