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
package org.ehealth_connector.cda.ihe.lab;

import java.util.List;

import org.ehealth_connector.cda.MdhtOrganizerFacade;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.enums.NullFlavor;
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
	protected VitalSignsOrganizer() {
		super(IHEFactory.eINSTANCE.createVitalSignsOrganizer().init());
	}

	/**
	 * Instantiates a new vital signs organizer.
	 *
	 * @param mdht
	 *            the mdht
	 */
	protected VitalSignsOrganizer(org.openhealthtools.mdht.uml.cda.ihe.VitalSignsOrganizer mdht) {
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

	/**
	 * Gets the author list.
	 *
	 * @return the author list
	 */
	public List<Author> getAuthorList() {
		return null;
	}

	/**
	 * Gets the vital signs observations.
	 *
	 * @return the vital signs observations
	 */
	public List<VitalSignsObservation> getVitalSignsObservations() {
		return null;
		// getMdht().getVitalSignObservations().
	}

	/**
	 * Sets the effective time.
	 *
	 * @param date
	 *            the new effective time
	 */
	public void setEffectiveTime(NullFlavor date) {

	}
}
