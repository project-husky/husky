package org.ehealth_connector.cda.ch.lab;

import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.enums.epsos.BloodGroup;
import org.ehealth_connector.common.Author;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

public class BloodGroupObservation
		extends MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.BloodTypeObservation> {

	protected BloodGroupObservation() {
		super(CHFactory.eINSTANCE.createBloodgroupObservation());
	}

	protected BloodGroupObservation(org.openhealthtools.mdht.uml.cda.ch.BloodgroupObservation mdht) {
		super(mdht);
	}

	public void addAuthor(Author author) {
		getMdht().getAuthors().add(author.copyMdhtAuthor());
	}

	public List<Author> getAuthorList() {
		if (getMdht().getAuthors() != null && !getMdht().getAuthors().isEmpty()) {
			// TODO Convert List
		}
		return null;
	}

	public SectionAnnotationCommentEntry getComment() {
		// TODO
		return null;
	}

	public Date getEffectiveTime() {
		return null;
	}

	public BloodGroup getValueEnum() {
		return null;
	}

	public void setComment(SectionAnnotationCommentEntry comment) {

	}

	public void setEffectiveTime(Date effectiveTime) {

	}

	public void setValue(BloodGroup value) {
		// getMdht().getValues().add()
	}
}
