package org.ehealth_connector.cda.ch.lab;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.enums.epsos.BloodGroup;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;

public class BloodGroupObservation
		extends MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ch.BloodgroupObservation> {

	protected BloodGroupObservation() {
		super(CHFactory.eINSTANCE.createBloodgroupObservation().init(), "2.16.756.5.30.1.1.1.1.3.4.1",
				"CDA-CH.LRTP.Body.StudiesSummaryL3.Bloodgroup");
	}

	public void addAuthor(Author author) {
		getMdht().getAuthors().add(author.copyMdhtAuthor());
	}

	public List<Author> getAuthorList() {
		List<Author> al = new ArrayList<Author>();
		if (getMdht().getAuthors() != null && !getMdht().getAuthors().isEmpty()) {
			for (org.openhealthtools.mdht.uml.cda.Author a : getMdht().getAuthors()) {
				al.add(new Author(a));
			}
		}
		return al;
	}

	public SectionAnnotationCommentEntry getComment() {
		if (getMdht().getComment() != null) {
			return new SectionAnnotationCommentEntry(getMdht().getComment());
		}
		return null;
	}

	public String getContentIdReference() {
		if (getMdht().getText() != null && getMdht().getText().getReference() != null
				&& getMdht().getText().getReference().getValue() != null) {
			return getMdht().getText().getReference().getValue();
		}
		return null;
	}

	public BloodGroup getValueEnum() {
		if (!getMdht().getValues().isEmpty() && getMdht().getValues().get(0) instanceof CE) {
			CE ce = (CE) getMdht().getValues().get(0);
			return BloodGroup.getEnum(ce.getCode());
		}
		return null;
	}

	public void setComment(SectionAnnotationCommentEntry commentEntry) {
		getMdht().addAct(commentEntry.copy());
		// need to add the the Subj and setInversionInd, cannot do this
		// automatically with mdht
		CdaUtil.setEntryRelationshipCommentInversionIdAndTypeCode(getMdht().getEntryRelationships());
	}

	public void setContentIdReference(String reference) {
		getMdht().setText(Util.createReference(reference));
	}

	public void setValue(BloodGroup value) {
		getMdht().getValues().clear();
		getMdht().getValues().add(value.getCE());
	}
}
