/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models;

import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrOtherDeviceCompilation;
import org.projecthusky.common.hl7cdar2.EntityClassDevice;
import org.projecthusky.common.hl7cdar2.SC;

public class Device {

	private String manufacturerModelName;
	private String softwareName;

	public String getManufacturerModelName() {
		return manufacturerModelName;
	}

	public void setManufacturerModelName(String manufacturerModelName) {
		this.manufacturerModelName = manufacturerModelName;
	}
	public String getSoftwareName() {
		return softwareName;
	}
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public AtcdabbrOtherDeviceCompilation getAtcdabbrOtherDeviceCompilation() {
		AtcdabbrOtherDeviceCompilation device = new AtcdabbrOtherDeviceCompilation();
		device.setClassCode(EntityClassDevice.DEV);
		device.setDeterminerCode("INSTANCE");

		if (softwareName != null) {
			SC scSoftwareName = new SC();
			scSoftwareName.setXmlMixed(softwareName);
			device.setSoftwareName(scSoftwareName);
		}

		if (manufacturerModelName != null) {
			SC scModelName = new SC();
			scModelName.setXmlMixed(manufacturerModelName);
			device.setManufacturerModelName(scModelName);
		}

		return device;
	}


}
