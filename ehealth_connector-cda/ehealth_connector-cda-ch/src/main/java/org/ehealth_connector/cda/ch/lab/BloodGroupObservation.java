package org.ehealth_connector.cda.ch.lab;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.enums.epsos.BloodGroup;
import org.ehealth_connector.common.Author;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

public class BloodGroupObservation
		extends MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.BloodTypeObservation> {

	protected BloodGroupObservation() {
		super(CHFactory.eINSTANCE.createBloodgroupObservation(), "2.16.756.5.30.1.1.1.1.3.4.1",
				"'CDA-CH.LRTP.Body.StudiesSummaryL3.Bloodgroup");
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
		// TODO
		return null;
	}

	public BloodGroup getValueEnum() {
		return null;
	}

	public void setComment(SectionAnnotationCommentEntry comment) {
		// getMdht().getCo
	}

	public void setValue(BloodGroup value) {
		getMdht().getValues().add(value.getCE());
	}
}
