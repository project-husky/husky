package org.ehealth_connector.common;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.SC;

public class AuthoringDevice {
	org.openhealthtools.mdht.uml.cda.AuthoringDevice mAuthoringDevice;

	public AuthoringDevice() {
		mAuthoringDevice = CDAFactory.eINSTANCE.createAuthoringDevice();
	}

	public AuthoringDevice(org.openhealthtools.mdht.uml.cda.AuthoringDevice mdht) {
		mAuthoringDevice = mdht;
	}

	public AuthoringDevice(String name) {
		this();
		setSoftwareName(name);
	}

	public org.openhealthtools.mdht.uml.cda.AuthoringDevice copy() {
		return EcoreUtil.copy(mAuthoringDevice);
	}

	public org.openhealthtools.mdht.uml.cda.AuthoringDevice getMdht() {
		return mAuthoringDevice;
	}

	public String getSoftwareName() {
		if (mAuthoringDevice.getSoftwareName() != null
				&& mAuthoringDevice.getSoftwareName().getText() != null) {
			return mAuthoringDevice.getSoftwareName().getText();
		}
		return null;
	}

	public void setSoftwareName(String name) {
		SC sc = DatatypesFactory.eINSTANCE.createSC();
		sc.addText(name);
		mAuthoringDevice.setSoftwareName(sc);
	}
}
