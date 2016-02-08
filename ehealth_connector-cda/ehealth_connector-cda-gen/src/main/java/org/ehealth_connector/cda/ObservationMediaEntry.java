package org.ehealth_connector.cda;

import java.io.InputStream;
import java.io.OutputStream;

import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ObservationMedia;

public class ObservationMediaEntry {

	// TODO
	protected void getObservationMedia(OutputStream outputStream) {

	}

	// gif, jpeg, png or bmp
	protected void setObservationMedia(InputStream inputStream) {
		ObservationMedia observationMedia = CDAFactory.eINSTANCE.createObservationMedia();
	}
}
