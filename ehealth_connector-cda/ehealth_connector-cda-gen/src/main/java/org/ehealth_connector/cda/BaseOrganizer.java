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

package org.ehealth_connector.cda;

import java.util.Comparator;

import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.Organizer;

public class BaseOrganizer
		extends MdhtOrganizerFacade<org.openhealthtools.mdht.uml.cda.Organizer>
		implements Comparator<BaseOrganizer> {

	protected LanguageCode myLang = LanguageCode.ENGLISH;
	protected org.openhealthtools.mdht.uml.cda.Organizer mOrganizer;

	public BaseOrganizer(Organizer mdht) {
		super(mdht);
		mOrganizer = mdht;
	}

	public BaseOrganizer(Organizer mdht, LanguageCode lang) {
		super(mdht);
		mOrganizer = mdht;
		myLang = lang;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(BaseOrganizer o1, BaseOrganizer o2) {
		BaseOrganizerComparator comparator = new BaseOrganizerComparator();
		return comparator.compare(o1, o2);
	}

}
