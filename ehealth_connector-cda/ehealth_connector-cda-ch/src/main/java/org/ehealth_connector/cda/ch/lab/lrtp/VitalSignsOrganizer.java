package org.ehealth_connector.cda.ch.lab.lrtp;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.AbstractVitalSignsOrganizer;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.enums.NullFlavor;
import org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;

public class VitalSignsOrganizer extends AbstractVitalSignsOrganizer {
	public VitalSignsOrganizer() {
		super();
		setEffectiveTimeNullFlavor(NullFlavor.NOT_APPLICABLE);
	}

	public VitalSignsOrganizer(org.openhealthtools.mdht.uml.cda.ihe.VitalSignsOrganizer mdht) {
		super(mdht);
	}

	public void addAuthor(Author author) {
		getMdht().getAuthors().add(author.copyMdhtAuthor());
		final int nb = getMdht().getAuthors().size() - 1;
		getMdht().getAuthors().get(nb).setTypeCode(ParticipationType.AUT);
	}

	public void addVitalSignsObservation(VitalSignsObservation observation) {
		getMdht().addObservation(observation.getMdhtCopy());
		final int nb = getMdht().getComponents().size() - 1;
		getMdht().getComponents().get(nb).setTypeCode(ActRelationshipHasComponent.COMP);
	}

	public List<Author> getAuthors() {
		List<Author> al = new ArrayList<Author>();
		for (org.openhealthtools.mdht.uml.cda.Author mdht : getMdht().getAuthors()) {
			Author ehc = new Author(mdht);
			al.add(ehc);
		}
		return al;
	}

	public List<VitalSignsObservation> getVitalSignsObservations() {
		List<VitalSignsObservation> vsl = new ArrayList<VitalSignsObservation>();
		for (VitalSignObservation mdht : getMdht().getVitalSignObservations()) {
			VitalSignsObservation ehc = new VitalSignsObservation(mdht);
			vsl.add(ehc);
		}
		return vsl;
	}

}
