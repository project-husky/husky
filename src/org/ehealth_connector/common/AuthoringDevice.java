package org.ehealth_connector.common;

import java.util.Date;

import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.SC;

public class AuthoringDevice {
	private org.openhealthtools.mdht.uml.cda.Author mAuthor;
	private org.openhealthtools.mdht.uml.cda.AssignedAuthor mAssAuthor;
	private org.openhealthtools.mdht.uml.cda.AuthoringDevice mAuthorDevice;

	public AuthoringDevice() {
		mAuthor = CDAFactory.eINSTANCE.createAuthor();
		mAssAuthor = CDAFactory.eINSTANCE.createAssignedAuthor();
		mAuthorDevice = CDAFactory.eINSTANCE.createAuthoringDevice();

		mAuthor.setAssignedAuthor(mAssAuthor);
		mAssAuthor.setAssignedAuthoringDevice(mAuthorDevice);
	}

	public AuthoringDevice(String versionNumber, Date date) {
		SC sc = DatatypesFactory.eINSTANCE.createSC();
		mAuthorDevice.setSoftwareName(sc);
	}
}
