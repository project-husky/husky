package org.ehealth_connector.cda.ihe.lab;

import java.util.List;

import org.ehealth_connector.cda.MdhtOrganizerFacade;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.enums.NullFlavor;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;

public class VitalSignsOrganizer
		extends MdhtOrganizerFacade<org.openhealthtools.mdht.uml.cda.ihe.VitalSignsOrganizer> {

	protected VitalSignsOrganizer() {
		super(IHEFactory.eINSTANCE.createVitalSignsOrganizer().init());
	}

	protected VitalSignsOrganizer(org.openhealthtools.mdht.uml.cda.ihe.VitalSignsOrganizer mdht) {
		super(mdht);
	}

	public void addAuthor(Author author) {
		getMdht().getAuthors().add(author.copyMdhtAuthor());
	}

	public void addVitalSignsObservation(VitalSignsObservation observation) {
		getMdht().addObservation(observation.copy());
	}

	public List<Author> getAuthorList() {
		return null;
	}

	public List<VitalSignsObservation> getVitalSignsObservations() {
		return null;
		// getMdht().getVitalSignObservations().
	}

	public void setEffectiveTime(NullFlavor date) {

	}
}
