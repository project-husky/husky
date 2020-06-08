/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.cda.ch.vacd.v140;

import java.util.Comparator;

import org.openhealthtools.mdht.uml.cda.ch.impl.MedicationTargetEntryImpl;

/**
 * Class for sorting the MedicationTargetEntries..
 */
public class MedicationTargetERComparator
		implements Comparator<org.openhealthtools.mdht.uml.cda.EntryRelationship> {

	/**
	 *
	 * Sorts based on the display name for alphabetic sorting
	 *
	 * {@inheritDoc}
	 *
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(org.openhealthtools.mdht.uml.cda.EntryRelationship o1,
			org.openhealthtools.mdht.uml.cda.EntryRelationship o2) {
		if ((o1.getObservation() instanceof MedicationTargetEntryImpl)
				&& (o2.getObservation() instanceof MedicationTargetEntryImpl)) {
			MedicationTargetEntryImpl m1 = (MedicationTargetEntryImpl) o1.getObservation();
			MedicationTargetEntryImpl m2 = (MedicationTargetEntryImpl) o2.getObservation();
			return m1.getCode().getDisplayName().compareTo(m2.getCode().getDisplayName());
		} else
			return 0;
	}

}