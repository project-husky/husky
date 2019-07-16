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
package org.ehealth_connector.cda.ch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.Section;
import org.ehealth_connector.cda.ch.lab.lrep.LaboratoryBatteryOrganizer;
import org.ehealth_connector.common.mdht.Code;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.lab.impl.LaboratoryBatteryOrganizerImpl;
import org.openhealthtools.mdht.uml.cda.ihe.lab.impl.LaboratorySpecialtySectionImpl;

public class LaboratorySpecialtySection extends Section {

	private class MyComparator implements Comparator<LaboratoryBatteryOrganizer> {
		/**
		 *
		 * Compares two Organizers on their effective date timestamp.
		 *
		 * {@inheritDoc}
		 *
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(LaboratoryBatteryOrganizer a, LaboratoryBatteryOrganizer b) {
			if ((a == null) && (b == null))
				return 0;
			else if ((a == null) && (b != null))
				return -1;
			else if ((a != null) && (b == null))
				return 1;
			else {
				if ((a.getEffectiveTime() == null) && (b.getEffectiveTime() == null))
					return 0;
				else if ((a.getEffectiveTime() == null) && (b.getEffectiveTime() != null))
					return -1;
				else if ((a.getEffectiveTime() != null) && (b.getEffectiveTime() == null))
					return 1;
				else
					return a.getEffectiveTime().compareTo(b.getEffectiveTime());
			}
		}
	}

	private List<LaboratoryBatteryOrganizer> mOrganizers = null;
	private Comparator<LaboratoryBatteryOrganizer> mComparator = new MyComparator();

	public LaboratorySpecialtySection(org.openhealthtools.mdht.uml.cda.Section mdhtSection) {
		super();
		mOrganizers = new ArrayList<LaboratoryBatteryOrganizer>();
		if (mdhtSection instanceof LaboratorySpecialtySectionImpl) {
			setTitle(mdhtSection.getTitle().getText());
			setText(mdhtSection.getText().getText());
			setCode(new Code(mdhtSection.getCode()));
			EList<EntryRelationship> erList = mdhtSection.getEntries().get(0).getAct()
					.getEntryRelationships();
			for (EntryRelationship er : erList) {
				if (er.getOrganizer() instanceof LaboratoryBatteryOrganizerImpl) {
					mOrganizers.add(new LaboratoryBatteryOrganizer(
							(org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) er
									.getOrganizer()));
				}
			}
			mOrganizers.sort(mComparator);
		}
	}

	public LaboratorySpecialtySection(String title, String text) {
		super(title, text);
	}

	public LaboratorySpecialtySection(String title, String text, Code code) {
		super(title, text, code);
	}

	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteries() {
		return mOrganizers;
	}

	public void setComparator(Comparator<LaboratoryBatteryOrganizer> comparator) {
		mComparator = comparator;
	}
}