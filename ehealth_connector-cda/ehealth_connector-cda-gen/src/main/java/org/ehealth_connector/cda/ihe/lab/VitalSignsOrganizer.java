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
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;

/**
 * The Class VitalSignsOrganizer. A vital signs organizer collects vital signs
 * observations.
 */
public class VitalSignsOrganizer
		extends MdhtOrganizerFacade<org.openhealthtools.mdht.uml.cda.ihe.VitalSignsOrganizer> {

	/**
	 * Instantiates a new vital signs organizer.
	 */
	public VitalSignsOrganizer() {
		super(IHEFactory.eINSTANCE.createVitalSignsOrganizer().init());
	}

	/**
	 * Instantiates a new vital signs organizer.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public VitalSignsOrganizer(org.openhealthtools.mdht.uml.cda.ihe.VitalSignsOrganizer mdht) {
		super(mdht);
	}

	/**
	 * Adds the author.
	 *
	 * @param author
	 *            the author
	 */
	public void addAuthor(Author author) {
		getMdht().getAuthors().add(author.copyMdhtAuthor());
	}

	/**
	 * Adds the vital signs observation.
	 *
	 * @param observation
	 *            the observation
	 */
	public void addVitalSignsObservation(VitalSignsObservation observation) {
		getMdht().addObservation(observation.copy());
	}
}
