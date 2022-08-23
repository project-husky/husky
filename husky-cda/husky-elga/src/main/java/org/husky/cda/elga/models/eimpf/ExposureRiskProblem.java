/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models.eimpf;

import java.time.ZonedDateTime;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.husky.cda.elga.generated.artdecor.AtcdabbrEntryExpositionsrisikoProblem;
import org.husky.cda.elga.utils.NamespaceUtils;
import org.husky.common.hl7cdar2.CD;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.hl7cdar2.TS;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.utils.time.DateTimes;

public class ExposureRiskProblem {

	private Identificator id;
	private ZonedDateTime exposureRiskStart;
	private Code exposureRisk;

	public Identificator getId() {
		return id;
	}

	public void setId(Identificator id) {
		this.id = id;
	}

	public ZonedDateTime getExposureRiskStart() {
		return exposureRiskStart;
	}

	public void setExposureRiskStart(ZonedDateTime exposureRiskStart) {
		this.exposureRiskStart = exposureRiskStart;
	}

	public Code getExposureRisk() {
		return exposureRisk;
	}

	public void setExposureRisk(Code exposureRisk) {
		this.exposureRisk = exposureRisk;
	}

	public AtcdabbrEntryExpositionsrisikoProblem getExposureRiskProblem(int index) {
		AtcdabbrEntryExpositionsrisikoProblem problem = new AtcdabbrEntryExpositionsrisikoProblem();

		if (this.id != null) {
			problem.getId().add(this.id.getHl7CdaR2Ii());
		}

		if (this.exposureRiskStart != null) {
			IVLTS effectiveTime = new IVLTS();
			effectiveTime.getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX), TS.class,
							DateTimes.toDateTs(exposureRiskStart)));

			problem.setEffectiveTime(effectiveTime);
		}

		if (this.exposureRisk != null) {
			CD cd = new CD();
			cd.setCode(this.exposureRisk.getCode());
			cd.setCodeSystem(this.exposureRisk.getCodeSystem());
			cd.setCodeSystemName(this.exposureRisk.getCodeSystemName());
			cd.setDisplayName(this.exposureRisk.getDisplayName());
			cd.setOriginalText(new ED(null, new TEL("#risk-" + index)));
			problem.getValue().add(cd);
		}

		problem.setText(new ED(null, new TEL("#risk-" + index)));

		return problem;
	}




}
