package org.ehealth_connector.cda;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.ObservationInterpretation;
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

	// default language is German
	protected LanguageCode languageCode = LanguageCode.GERMAN;

	public AbstractCodedVitalSigns() {
		super(IHEFactory.eINSTANCE.createCodedVitalSignsSection().init());
	}

	protected AbstractCodedVitalSigns(CodedVitalSignsSection mdht) {
		super(mdht);
	}

	public void add(AbstractVitalSignObservation vitalSign, Author author) {
		if (author == null) {
			// default to author of document
			if (!getMdht().getClinicalDocument().getAuthors().isEmpty()) {
				author = new Author(getMdht().getClinicalDocument().getAuthors().get(0));
			} else {
				org.openhealthtools.mdht.uml.cda.Author mdhtAuthor = CDAFactory.eINSTANCE.createAuthor();
				mdhtAuthor.setNullFlavor(NullFlavor.UNK);
				author = new Author(mdhtAuthor);
			}
		}

		VitalSignsOrganizer organizer = getOrganizer(vitalSign.getEffectiveTime(), author);
		organizer.addObservation(vitalSign.getMdhtCopy());
		// update the component type
		EList<Component4> components = organizer.getComponents();
		components.get(components.size() - 1).setTypeCode(ActRelationshipHasComponent.COMP);

		getMdht().createStrucDocText(getTable());
	}

	protected abstract AbstractVitalSignObservation createVitalSignObservation(
			org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation mdht);

	public List<AbstractVitalSignObservation> getCodedVitalSignObservations() {
		List<AbstractVitalSignObservation> ret = new ArrayList<AbstractVitalSignObservation>();
		EList<Organizer> organizers = getMdht().getOrganizers();
		for (Organizer organizer : organizers) {
			EList<Observation> observations = organizer.getObservations();
			for (Observation observation : observations) {
				if (observation instanceof org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation) {
					ret.add(createVitalSignObservation(
							(org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation) observation));
				}
			}
		}
		ret.sort(new Comparator<AbstractVitalSignObservation>() {
			@Override
			public int compare(AbstractVitalSignObservation left, AbstractVitalSignObservation right) {
				return right.getEffectiveTime().compareTo(left.getEffectiveTime());
			}
		});
		return ret;
	}

	private VitalSignsOrganizer getOrganizer(Date effectiveTime, Author author) {
		VitalSignsSection section = getMdht();
		EList<VitalSignsOrganizer> organizers = section.getVitalSignsOrganizers();
		for (VitalSignsOrganizer organizer : organizers) {
			Date organizerDate = DateUtil.parseIVL_TSVDateTimeValue(organizer.getEffectiveTime());
			if (organizerDate.equals(effectiveTime)) {
				return organizer;
			}
		}
		VitalSignsOrganizer organizer = IHEFactory.eINSTANCE.createVitalSignsOrganizer().init();
		try {
			organizer.setEffectiveTime(DateUtil.createIVL_TSFromEuroDateTime(effectiveTime));
			organizer.getIds().add(getUuid().getIi());
			org.openhealthtools.mdht.uml.cda.Author mdhtAuthor = author.copyMdhtAuthor();
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

	private String getTable() {
		StringBuilder sb = new StringBuilder();
		List<AbstractVitalSignObservation> observations = getCodedVitalSignObservations();

		if (!observations.isEmpty()) {
			sb.append("<table><tbody>");
			if (languageCode == LanguageCode.GERMAN) {
				sb.append("<tr><th>Datum / Uhrzeit</th><th>Beschreibung</th><th>Resultat</th></tr>");
			} else {
				sb.append("<tr><th>Date / Time</th><th>Description</th><th>Result</th></tr>");
			}
			for (AbstractVitalSignObservation vitalSignObservation : observations) {
				String signDateTime = DateUtil.formatDateTimeCh(vitalSignObservation.getEffectiveTime());
				String signDescription = vitalSignObservation.getCode().getDisplayName();
				String signResult = vitalSignObservation.getValue().getPhysicalQuantityValue() + " "
						+ vitalSignObservation.getValue().getPhysicalQuantityUnit();
				Code code = vitalSignObservation.getInterpretationCode();
				if (code != null && !code.isNullFlavor()
						&& !ObservationInterpretation.NORMAL.getCodeValue().equals(code.getCode())) {
					String signInterpretation = "[" + vitalSignObservation.getInterpretationCode().getCode()
							+ "]";
					signResult += " " + signInterpretation;
				}
				Code target = vitalSignObservation.getTargetSiteCode();
				if (target != null && !target.isNullFlavor()) {
					String signTarget = "[" + vitalSignObservation.getTargetSiteCode().getDisplayName() + "]";
					signDescription += " " + signTarget;
				}
				sb.append("<tr><td>" + signDateTime + "</td><td>" + signDescription + "</td><td>"
						+ signResult + "</td></tr>");
			}
			sb.append("</tbody></table>");
		}

		return sb.toString();
	}

	protected abstract Identificator getUuid();
}
