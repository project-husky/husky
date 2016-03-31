package ehealth_connector.validation.service.schematron.result;

import ehealth_connector.validation.service.schematron.bind.FailedAssert;
import ehealth_connector.validation.service.schematron.bind.FiredRule;
import ehealth_connector.validation.service.schematron.bind.SuccessfulReport;

public class FiredRuleResult {

	private String context;
	private String id;
	private FailedAssert failedAssert;
	private SuccessfulReport successfulReport;
	
	public FiredRuleResult(FiredRule fr) {
		this.context = fr.getContext();
		this.id = fr.getId();
	}
	
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public FailedAssert getFailedAssert() {
		return failedAssert;
	}
	public void setFailedAssert(FailedAssert failedAssert) {
		this.failedAssert = failedAssert;
	}
	public SuccessfulReport getSuccessfulReport() {
		return successfulReport;
	}
	public void setSuccessfulReport(SuccessfulReport successfulReport) {
		this.successfulReport = successfulReport;
	}

}
