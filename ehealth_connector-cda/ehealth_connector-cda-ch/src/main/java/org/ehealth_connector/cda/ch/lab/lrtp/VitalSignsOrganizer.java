package org.ehealth_connector.cda.ch.lab.lrtp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.AbstractVitalSignsOrganizer;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.NullFlavor;
import org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;

public class VitalSignsOrganizer extends AbstractVitalSignsOrganizer {
	public VitalSignsOrganizer() {
		super();
		setEffectiveTimeNullFlavor(NullFlavor.NOT_APPLICABLE);
	}

	/**
	 * Instantiates the class with the required elements.
	 *
	 * @param effectiveTime
	 *          point in time of the measurement.
	 * @param author
	 *          the author
	 * @param observation
	 *          the observation
	 * @param id
	 *          the id
	 */
	public VitalSignsOrganizer(Date effectiveTime, Author author, VitalSignsObservation observation,
			Identificator id) {
		this();
		setEffectiveTime(effectiveTime);
		addAuthor(author);
		addVitalSignsObservation(observation);
	}

	/**
	 * Instantiates the class with the required elements. An ID with the CdaChLrtp
	 * root and a generated extension will be added automatically.
	 *
	 * @param effectiveTime
	 *          point in time of the measurement.
	 * @param observation
	 *          the observation
	 */
	public VitalSignsOrganizer(Date effectiveTime, VitalSignsObservation observation) {
		this();
		setEffectiveTime(effectiveTime);
		addVitalSignsObservation(observation);
		addId(null);
	}

	public VitalSignsOrganizer(org.openhealthtools.mdht.uml.cda.ihe.VitalSignsOrganizer mdht) {
		super(mdht);
	}

	public void addAuthor(Author author) {
		getMdht().getAuthors().add(author.copyMdhtAuthor());
		final int nb = getMdht().getAuthors().size() - 1;
		getMdht().getAuthors().get(nb).setTypeCode(ParticipationType.AUT);
	}

	/**
	 * Adds an ID.
	 *
	 * @param id
	 *          the id. If null, an ID with the CdaChLrtp root and a generated
	 *          extension will be created
	 * @see org.ehealth_connector.cda.AbstractVitalSignsOrganizer#addId(org.ehealth_connector.common.Identificator)
	 */
	@Override
	public void addId(Identificator id) {
		if (id == null) {
			id = CdaChLrtp.createUuidLrtp(null);
		}
		getMdht().getIds().add(id.getIi());
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
