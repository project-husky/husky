/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/
package org.ehealth_connector.cda;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.io.IOUtils;
import org.ehealth_connector.cda.ihe.lab.enums.LabObservationMediaMimeType;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.Comment;
import org.openhealthtools.mdht.uml.hl7.datatypes.BinaryDataEncoding;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.ActMood;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * The Class ObservationMediaEntry.
 */
public class ObservationMediaEntry
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ObservationMedia> {

	/**
	 * Instantiates a new observation media entry.
	 */
	public ObservationMediaEntry() {
		super(CDAFactory.eINSTANCE.createObservationMedia());
		getMdht().setClassCode(ActClassObservation.OBS);
		getMdht().setMoodCode(ActMood.EVN);
	}

	/**
	 * Sets the (not Base64 encoded) inputStream and MimeType.
	 *
	 * @param inputStream
	 *            the (not Base64 encoded) inputStream. It will be wrapped into
	 *            an Base64InputStream
	 * @param mimeType
	 *            the mime type of the object
	 * @param reference
	 *            a reference to the CDA section text
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public ObservationMediaEntry(InputStream inputStream, LabObservationMediaMimeType mimeType,
			String reference) throws IOException {
		this();
		setObject(inputStream, mimeType);
		setObservationMediaId(reference);
	}

	/**
	 * Instantiates a new observation media entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public ObservationMediaEntry(org.openhealthtools.mdht.uml.cda.ObservationMedia mdht) {
		super(mdht);
	}

	/**
	 * Sets the (not Base64 encoded) file and MimeType.
	 *
	 * @param resourceFileName
	 *            the (not Base64 encoded) file object. It will be loaded as a
	 *            resource. It will be wrapped into an Base64InputStream
	 * @param mimeType
	 *            the mime type of the object
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public ObservationMediaEntry(String resourceFileName, LabObservationMediaMimeType mimeType)
			throws IOException {
		this();
		setObject(resourceFileName, mimeType);
	}

	/**
	 * Add a comment entry.
	 *
	 * @param commentEntry
	 *            the new comment entry
	 */
	public void addCommentEntry(SectionAnnotationCommentEntry commentEntry) {
		this.getMdht().addAct(commentEntry.copy());
		// need to add the the Subj and setInversionInd, cannot do this
		// automatically with mdht
		for (final EntryRelationship entryRelationShip : getMdht().getEntryRelationships()) {
			if (entryRelationShip.getAct() instanceof Comment) {
				entryRelationShip.setInversionInd(true);
				entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
			}
		}
	}

	/**
	 * Gets the base64 object.
	 *
	 * @param outputStream
	 *            the output stream
	 * @return the base64 object
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public boolean getBase64Object(OutputStream outputStream) throws IOException {
		if (getMdht().getValue() != null) {
			outputStream.write(getMdht().getValue().getText().getBytes());
			return true;
		}
		return false;
	}

	/**
	 * Gets the comment entries.
	 *
	 * @return the comment entry
	 */
	public List<SectionAnnotationCommentEntry> getCommentEntryList() {
		if ((this.getMdht().getActs() != null) && !this.getMdht().getActs().isEmpty()) {
			final List<SectionAnnotationCommentEntry> comments = new ArrayList<SectionAnnotationCommentEntry>();
			for (final Act act : getMdht().getActs()) {
				if (act instanceof Comment) {
					comments.add(new SectionAnnotationCommentEntry((Comment) act));
				}
			}
			return comments;
		}
		return null;
	}

	/**
	 * Gets the mime type.
	 *
	 * @return the mime type
	 */
	protected String getMimeType() {
		if ((getMdht().getValue() != null) && (getMdht().getValue().getMediaType() != null)) {
			return getMdht().getValue().getMediaType();
		}
		return null;
	}

	/**
	 * Gets the mime type enum.
	 *
	 * @return the mime type enum
	 */
	public LabObservationMediaMimeType getMimeTypeEnum() {
		if (this.getMimeType() != null) {
			return LabObservationMediaMimeType.getEnum(getMimeType());
		}
		return null;
	}

	/**
	 * Gets the object.
	 *
	 * @param outputStream
	 *            the output stream
	 * @return the object
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public boolean getObject(OutputStream outputStream) throws IOException {
		final Base64OutputStream os = new Base64OutputStream(outputStream, false);
		if (getMdht().getValue() != null) {
			os.write(getMdht().getValue().getText().getBytes());
			os.close();
			return true;
		}
		os.close();
		return false;
	}

	/**
	 * Gets the observation media id.
	 *
	 * @return the observation media id
	 */
	public String getObservationMediaId() {
		if (getMdht().getObservationMediaId() != null) {
			return getMdht().getObservationMediaId();
		}
		return null;
	}

	/**
	 * Sets the base64 object.
	 *
	 * @param is
	 *            the is
	 * @param mimeType
	 *            the mime type
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void setBase64Object(InputStream is, LabObservationMediaMimeType mimeType)
			throws IOException {
		final String valueString = new String(IOUtils.toByteArray(is));
		final ED value = Util.createEd(valueString);
		value.setMediaType(mimeType.getCodeValue());
		value.setRepresentation(BinaryDataEncoding.B64);
		getMdht().setValue(value);

	}

	/**
	 * Sets the (not Base64 encoded) inputStream and MimeType.
	 *
	 * @param inputStream
	 *            the (not Base64 encoded) inputStream. It will be wrapped into
	 *            an Base64InputStream
	 * @param mimeType
	 *            the mime type of the object
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void setObject(InputStream inputStream, LabObservationMediaMimeType mimeType)
			throws IOException {
		final Base64InputStream is = new Base64InputStream(inputStream, true);
		this.setBase64Object(is, mimeType);
	}

	/**
	 * Sets the (not Base64 encoded) inputStream and MimeType.
	 *
	 * @param fileName
	 *            the (not Base64 encoded) file object. It will be loaded as a
	 *            resource. It will be wrapped into an Base64InputStream
	 * @param mimeType
	 *            the mime type of the object
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void setObject(String fileName, LabObservationMediaMimeType mimeType)
			throws IOException {
		final InputStream inputStream = new FileInputStream(fileName);
		setObject(inputStream, mimeType);
	}

	/**
	 * Sets the observation media id.
	 *
	 * @param id
	 *            the new observation media id
	 */
	public void setObservationMediaId(String id) {
		getMdht().setObservationMediaId(id);
	}

}
