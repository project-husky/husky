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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Component4;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.cda.ccd.VitalSignsOrganizer;
import org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.VitalSignsSection;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipHasComponent;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;

public abstract class AbstractCodedVitalSigns extends MdhtFacade<VitalSignsSection> {

	protected final List<BaseObservation> myVitalSignObservations = new ArrayList<BaseObservation>();

	// default language is German
	private LanguageCode languageCode = LanguageCode.GERMAN;

	public AbstractCodedVitalSigns() {
		super(IHEFactory.eINSTANCE.createCodedVitalSignsSection().init());
	}

	public AbstractCodedVitalSigns(CodedVitalSignsSection mdht) {
		super(mdht);
	}

	public void add(BaseVitalSignsOrganizer organizer, BaseVitalSignObservation vitalSign,
			Author author, String contendIdPrefix) {

		myVitalSignObservations.add(vitalSign);

		if (author == null) {
			// default to author of document
			if (!getMdht().getClinicalDocument().getAuthors().isEmpty()) {
				author = new Author(getMdht().getClinicalDocument().getAuthors().get(0));
			} else {
				final org.openhealthtools.mdht.uml.cda.Author mdhtAuthor = CDAFactory.eINSTANCE
						.createAuthor();
				mdhtAuthor.setNullFlavor(NullFlavor.UNK);
				author = new Author(mdhtAuthor);
			}
		}

		Identificator id = null;
		if (!organizer.getIds().isEmpty()) {
			id = organizer.getIds().get(0);
		}
		final VitalSignsOrganizer mdhtOrganizer = getOrganizer(id, vitalSign.getEffectiveTime(),
				author);
		mdhtOrganizer.getIds().clear();
		for (Identificator id1 : organizer.getIds()) {
			mdhtOrganizer.getIds().add(id1.getIi());
		}
		mdhtOrganizer.addObservation(vitalSign.getMdhtCopy());
		// update the component type
		final EList<Component4> components = mdhtOrganizer.getComponents();
		components.get(components.size() - 1).setTypeCode(ActRelationshipHasComponent.COMP);

	}

	protected abstract BaseVitalSignObservation createVitalSignObservation(
			org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation mdht);

	public List<BaseVitalSignObservation> getCodedVitalSignObservations() {
		final List<BaseVitalSignObservation> ret = new ArrayList<BaseVitalSignObservation>();
		final EList<Organizer> organizers = getMdht().getOrganizers();
		for (final Organizer organizer : organizers) {
			final EList<Observation> observations = organizer.getObservations();
			for (final Observation observation : observations) {
				if (observation instanceof org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation) {
					ret.add(createVitalSignObservation(
							(org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation) observation));
				}
			}
		}
		ret.sort(new Comparator<BaseVitalSignObservation>() {
			@Override
			public int compare(BaseVitalSignObservation left,
					BaseVitalSignObservation right) {
				return right.getEffectiveTime().compareTo(left.getEffectiveTime());
			}
		});
		return ret;
	}

	/**
	 * Method to get
	 *
	 * @return the languageCode
	 */
	public LanguageCode getLanguageCode() {
		return languageCode;
	}

	private VitalSignsOrganizer getOrganizer(Identificator id, Date effectiveTime, Author author) {
		final VitalSignsSection section = getMdht();
		final EList<VitalSignsOrganizer> organizers = section.getVitalSignsOrganizers();
		for (final VitalSignsOrganizer organizer : organizers) {
			if (!organizer.getIds().isEmpty() && (id != null)) {
				if (organizer.getIds().get(0).getExtension().equals(id.getExtension()))
					return organizer;
			}
		}
		for (final VitalSignsOrganizer organizer : organizers) {
			final Date organizerDate = DateUtil
					.parseIVL_TSVDateTimeValue(organizer.getEffectiveTime());
			if (organizerDate.equals(effectiveTime)) {
				return organizer;
			}
		}
		final VitalSignsOrganizer organizer = IHEFactory.eINSTANCE.createVitalSignsOrganizer()
				.init();
		try {
			organizer.setEffectiveTime(DateUtil.createIVL_TSFromEuroDateTime(effectiveTime));
			organizer.getIds().add(getUuid().getIi());
			final org.openhealthtools.mdht.uml.cda.Author mdhtAuthor = author.copyMdhtAuthor();
			mdhtAuthor.setTypeCode(ParticipationType.AUT);
			organizer.getAuthors().add(mdhtAuthor);
			// fix the code system name for schematron validation
			if (CodeSystems.SNOMEDCT.getCodeSystemId().equals(organizer.getCode().getCodeSystem())
					&& !organizer.getCode().getCodeSystemName().equals("SNOMED CT")) {
				organizer.getCode().setCodeSystemName("SNOMED CT");
			}
		} catch (final ParseException e) {
			e.printStackTrace();
		}
		section.addOrganizer(organizer);
		return organizer;
	}

	protected abstract Identificator getUuid();

	public List<BaseObservation> getVitalSignObservations() {
		return myVitalSignObservations;
	}

	/**
	 * Method to set
	 *
	 * @param languageCode
	 *            the languageCode to set
	 */
	public void setLanguageCode(LanguageCode languageCode) {
		this.languageCode = languageCode;
	}

}
