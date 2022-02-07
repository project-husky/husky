/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.cda.ems.models;

import javax.xml.bind.annotation.XmlElement;

import org.husky.common.hl7cdar2.BL;
import org.husky.common.hl7cdar2.POCDMT000040Patient;
import org.husky.common.hl7cdar2.TS;

public class EpimsPatient extends POCDMT000040Patient {

	@XmlElement(namespace = "urn:hl7-org:sdtc")
	protected TS deceasedTime;
	@XmlElement(namespace = "urn:hl7-org:sdtc")
	protected BL deceasedInd;

	public TS getDeceasedTime() {
		return deceasedTime;
	}

	public void setDeceasedTime(TS deceasedTime) {
		this.deceasedTime = deceasedTime;
	}

	public BL getDeceasedInd() {
		return deceasedInd;
	}

	public void setDeceasedInd(BL deceasedInd) {
		this.deceasedInd = deceasedInd;
	}

}
