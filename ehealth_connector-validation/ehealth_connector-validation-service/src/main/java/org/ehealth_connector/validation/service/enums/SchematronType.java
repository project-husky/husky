package org.ehealth_connector.validation.service.enums;

public enum SchematronType {
	
	FAILED_ASSERT("svrl_fail","FAILED_ASSERT"),
	
	SUCESSFUL_REPORT("svrl_succ","SUCESSFUL_REPORT");
	
	
	
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
	private SchematronType(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}


}
