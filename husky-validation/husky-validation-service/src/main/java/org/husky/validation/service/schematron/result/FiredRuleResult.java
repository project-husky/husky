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
package org.husky.validation.service.schematron.result;

import java.util.ArrayList;
import java.util.List;

import org.husky.validation.service.schematron.bind.FailedAssert;
import org.husky.validation.service.schematron.bind.FiredRule;
import org.husky.validation.service.schematron.bind.SuccessfulReport;

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
