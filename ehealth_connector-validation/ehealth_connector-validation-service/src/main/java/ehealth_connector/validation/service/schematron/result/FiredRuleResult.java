package ehealth_connector.validation.service.schematron.result;

import java.util.ArrayList;
import java.util.List;

import ehealth_connector.validation.service.schematron.bind.FailedAssert;
import ehealth_connector.validation.service.schematron.bind.FiredRule;
import ehealth_connector.validation.service.schematron.bind.SuccessfulReport;

public class FiredRuleResult {

	private String context;
	private String id;
	private List<FailedAssert> failedAssert;
	private List<SuccessfulReport> successfulReport;
	
	public FiredRuleResult(FiredRule fr) {
		this.context = fr.getContext();
		this.id = fr.getId();
		failedAssert = new ArrayList<FailedAssert>();
		successfulReport = new ArrayList<SuccessfulReport>();
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

	public List<FailedAssert> getFailedAssert() {
		return failedAssert;
	}

	public void setFailedAssert(List<FailedAssert> failedAssert) {
		this.failedAssert = failedAssert;
	}

	public List<SuccessfulReport> getSuccessfulReport() {
		return successfulReport;
	}

	public void setSuccessfulReport(List<SuccessfulReport> successfulReport) {
		this.successfulReport = successfulReport;
	}
	

}
