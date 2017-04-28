/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtOrganizerFacade;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Specimen;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityClassRoot;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;
import org.openhealthtools.mdht.uml.hl7.vocab.RoleClassSpecimen;

/**
 * The Class LaboratoryIsolateOrganizer. The Laboratory Isolate Organizer SHALL
 * be used only if the entry represents a microbiology 975 specimen study with
 * isolates discovered on the specimen. The isolate is represented by the
 * Isolate role played by the Isolate entity. The isolate identification is
 * carried by the code attribute of the Isolate entity.
 */
public class LaboratoryIsolateOrganizer extends
		MdhtOrganizerFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer> {

	/**
	 * Instantiates a new laboratory isolate organizer.
	 */
	public LaboratoryIsolateOrganizer() {
		super(LABFactory.eINSTANCE.createLaboratoryIsolateOrganizer().init());
	}

	/**
	 * Instantiates a new laboratory isolate organizer.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public LaboratoryIsolateOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryIsolateOrganizer mdht) {
		super(mdht);
	}

	/**
	 *
	 * Creates a new Laboratory Isolate Organizer. One specimen element
	 * (specimen, specimenRole, and specimenPlayingEntity) will be created with
	 * the given reference.
	 *
	 * @param reference
	 *            the reference will be set into
	 *            specimen/specimenRole/specimenPlayingEntity/originalText/
	 *            reference
	 */
	public LaboratoryIsolateOrganizer(String reference) {
		this();
		final Code code = new Code();
		code.setOriginalTextReference(reference);
		final Specimen specimen = new Specimen();
		specimen.setCode(code);
		setSpecimen(specimen);
	}

	/**
	 * Adds the author.
	 *
	 * @param author
	 *            the author
	 */
	public void addAuthor(Author author) {
		getMdht().getAuthors().add(author.copyMdhtAuthor());
		final int nb = getMdht().getAuthors().size() - 1;
		getMdht().getAuthors().get(nb).setTypeCode(ParticipationType.AUT);
	}

	/**
	 * Adds the laboratory battery organizer.
	 *
	 * @param labBatteryOrganizer
	 *            the lab battery organizer
	 */
	public void addLaboratoryBatteryOrganizer(LaboratoryBatteryOrganizer labBatteryOrganizer) {
		getMdht().addOrganizer(labBatteryOrganizer.getMdht());
		final int nb = getMdht().getComponents().size() - 1;
		getMdht().getComponents().get(nb).setTypeCode(ActRelationshipHasComponent.COMP);
	}

	/**
	 * Gets the specimen.
	 *
	 * @return the specimen
	 */
	public Specimen getSpecimen() {
		if ((getMdht().getSpecimens() != null) && !getMdht().getSpecimens().isEmpty()) {
			return new Specimen(getMdht().getSpecimens().get(0));
		}
		return null;
	}

	/**
	 * Sets the specimen.
	 *
	 * @param specimen
	 *            the new specimen
	 */
	public void setSpecimen(Specimen specimen) {
		getMdht().getSpecimens().clear();
		specimen.getMdht().setTypeCode(ParticipationType.SPC);
		specimen.getMdht().getSpecimenRole().setClassCode(RoleClassSpecimen.SPEC);
		specimen.getMdht().getSpecimenRole().getSpecimenPlayingEntity()
				.setClassCode(EntityClassRoot.MIC);
		getMdht().getSpecimens().add(specimen.getMdht());
	}
}
