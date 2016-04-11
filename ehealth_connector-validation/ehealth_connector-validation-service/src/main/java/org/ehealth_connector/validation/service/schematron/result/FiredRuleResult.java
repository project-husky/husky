package org.ehealth_connector.validation.service.schematron.result;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.validation.service.schematron.bind.FailedAssert;
import org.ehealth_connector.validation.service.schematron.bind.FiredRule;
import org.ehealth_connector.validation.service.schematron.bind.SuccessfulReport;

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

	public List<FailedAssert> getFailedAssert() {
		return failedAssert;
	}

	public String getId() {
		return id;
	}

	public List<SuccessfulReport> getSuccessfulReport() {
		return successfulReport;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public void setFailedAssert(List<FailedAssert> failedAssert) {
		this.failedAssert = failedAssert;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSuccessfulReport(List<SuccessfulReport> successfulReport) {
		this.successfulReport = successfulReport;
	}

}
