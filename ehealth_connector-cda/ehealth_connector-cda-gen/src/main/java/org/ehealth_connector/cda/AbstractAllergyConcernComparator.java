/*
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
package org.ehealth_connector.cda;

import java.util.Comparator;

public class AbstractAllergyConcernComparator implements Comparator<AbstractAllergyConcern> {

	/**
	 *
	 * Compares two observations on their narrative text.
	 *
	 * {@inheritDoc}
	 *
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(AbstractAllergyConcern a, AbstractAllergyConcern b) {
		if ((a == null) && (b == null))
			return 0;
		else if ((a == null) && (b != null))
			return -1;
		else if ((a != null) && (b == null))
			return 1;
		else {
			if ((a.getNarrativeText() == null) && (b.getNarrativeText() == null))
				return 0;
			else if ((a.getNarrativeText() == null) && (b.getNarrativeText() != null))
				return -1;
			else if ((a.getNarrativeText() != null) && (b.getNarrativeText() == null))
				return 1;
			else
				return a.getNarrativeText().compareToIgnoreCase(b.getNarrativeText());
		}
	}
}
