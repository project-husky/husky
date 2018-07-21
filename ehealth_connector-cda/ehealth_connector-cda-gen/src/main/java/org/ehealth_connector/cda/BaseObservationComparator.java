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

/**
 * This class implements the default comparison algorithm for HL7 CDA
 * observations.
 */
public class BaseObservationComparator implements Comparator<BaseObservation> {

	/**
	 *
	 * Compares two observations on their narrative text.
	 *
	 * {@inheritDoc}
	 *
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(BaseObservation a, BaseObservation b) {
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
			else {
				int retVal = a.getNarrativeText().compareToIgnoreCase(b.getNarrativeText());
				if (retVal == 0) {
					if ((a.getOriginalText() == null) && (b.getOriginalText() == null))
						return 0;
					else if ((a.getOriginalText() == null) && (b.getOriginalText() != null))
						return -1;
					else if ((a.getOriginalText() != null) && (b.getOriginalText() == null))
						return 1;
					else {
						retVal = a.getOriginalText().compareToIgnoreCase(b.getOriginalText());
						if (retVal == 0) {
							String aDisplayName = "";
							String bDisplayName = "";
							if (a.getCode() != null)
								if (a.getCode().getDisplayName() != null)
									aDisplayName = a.getCode().getDisplayName();

							if (b.getCode() != null)
								if (b.getCode().getDisplayName() != null)
									bDisplayName = b.getCode().getDisplayName();

							return aDisplayName.compareToIgnoreCase(bDisplayName);
						}
						return retVal;
					}
				}
				return retVal;
			}
		}
	}
}
