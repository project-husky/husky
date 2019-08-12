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
package org.ehealth_connector.cda.ihe.lab;

import java.util.Comparator;

/**
 * The default LaboratoryObservation Comparator.
 */
public class LaboratoryObservationComparator implements Comparator<LaboratoryObservation> {

	/**
	 *
	 * Compares two observations on their date descending.
	 *
	 * {@inheritDoc}
	 *
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(LaboratoryObservation a, LaboratoryObservation b) {
		if ((a == null) && (b == null))
			return 0;
		else if ((a == null) && (b != null))
			return -1;
		else if ((a != null) && (b == null))
			return 1;
		else {
			if ((a.getDateTimeOfResult() == null) && (b.getDateTimeOfResult() == null))
				return 0;
			else if ((a.getDateTimeOfResult() == null) && (b.getDateTimeOfResult() != null))
				return -1;
			else if ((a.getDateTimeOfResult() != null) && (b.getDateTimeOfResult() == null))
				return 1;
			else
				return b.getDateTimeOfResult().compareTo(a.getDateTimeOfResult());
		}
	}
}
