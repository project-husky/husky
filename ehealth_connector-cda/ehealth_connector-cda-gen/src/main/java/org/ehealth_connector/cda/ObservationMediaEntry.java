package org.ehealth_connector.cda;

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

public class ObservationMediaEntry
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ObservationMedia> {

	public ObservationMediaEntry() {
		super(CDAFactory.eINSTANCE.createObservationMedia());
		getMdht().setClassCode(ActClassObservation.OBS);
		getMdht().setMoodCode(ActMood.EVN);
	}

	/**
	 * Sets the (not Base64 encoded) inputStream and MimeType.
	 *
	 * @param inputStream
	 *          the (not Base64 encoded) inputStream. It will be wrapped into an
	 *          Base64InputStream
	 * @param mimeType
	 *          the mime type of the object
	 * @throws IOException
	 */
	public ObservationMediaEntry(InputStream inputStream, LabObservationMediaMimeType mimeType)
			throws IOException {
		this();
		setObject(inputStream, mimeType);
	}

	public ObservationMediaEntry(org.openhealthtools.mdht.uml.cda.ObservationMedia mdht) {
		super(mdht);
	}

	/**
	 * Add a comment entry.
	 *
	 * @param commentEntry
	 *          the new comment entry
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
		if (this.getMdht().getActs() != null && !this.getMdht().getActs().isEmpty()) {
			ArrayList<SectionAnnotationCommentEntry> comments = new ArrayList<SectionAnnotationCommentEntry>();
			for (Act act : getMdht().getActs()) {
				if (act instanceof Comment) {
					comments.add(new SectionAnnotationCommentEntry((Comment) act));
				}
			}
			return comments;
		}
		return null;
	}

	public LabObservationMediaMimeType getMimeTypeEnum() {
		if (this.getMimeType() != null) {
			return LabObservationMediaMimeType.getEnum(getMimeType());
		}
		return null;
	}

	public boolean getObject(OutputStream outputStream) throws IOException {
		Base64OutputStream os = new Base64OutputStream(outputStream, false);
		if (getMdht().getValue() != null) {
			os.write(getMdht().getValue().getText().getBytes());
			os.close();
			return true;
		}
		os.close();
		return false;
	}

	public String getObservationMediaId() {
		if (getMdht().getObservationMediaId() != null) {
			return getMdht().getObservationMediaId();
		}
		return null;
	}

	public void setBase64Object(InputStream is, LabObservationMediaMimeType mimeType)
			throws IOException {
		String valueString = new String(IOUtils.toByteArray(is));
		ED value = Util.createEd(valueString);
		value.setMediaType(mimeType.getCodeValue());
		value.setRepresentation(BinaryDataEncoding.B64);
		getMdht().setValue(value);
	}

	/**
	 * Sets the (not Base64 encoded) inputStream and MimeType.
	 *
	 * @param inputStream
	 *          the (not Base64 encoded) inputStream. It will be wrapped into an
	 *          Base64InputStream
	 * @param mimeType
	 *          the mime type of the object
	 * @throws IOException
	 */
	public void setObject(InputStream inputStream, LabObservationMediaMimeType mimeType)
			throws IOException {
		Base64InputStream is = new Base64InputStream(inputStream, true);
		this.setBase64Object(is, mimeType);
	}

	public void setObservationMediaId(String id) {
		getMdht().setObservationMediaId(id);
	}

	protected String getMimeType() {
		if (getMdht().getValue() != null && getMdht().getValue().getMediaType() != null) {
			return getMdht().getValue().getMediaType();
		}
		return null;
	}

}
