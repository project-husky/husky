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
package org.ehealth_connector.cda.utils;

import java.util.Comparator;

import org.ehealth_connector.common.Identificator;

/**
 * This class implements the default comparison algorithm for Identificators.
 */
public class IdentificatorComparator implements Comparator<Identificator> {

	/**
	 *
	 * Compares two Identificator on their root and if exists the extension.
	 *
	 * {@inheritDoc}
	 *
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Identificator a, Identificator b) {
		int retVal = a.getRoot().compareTo(b.getRoot());
		if (retVal == 0)
			a.getExtension().compareTo(b.getExtension());
		return retVal;
	}
}
