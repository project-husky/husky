/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models.eimpf;

import java.time.ZonedDateTime;
import java.util.List;

import javax.xml.XMLConstants;
import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.generated.artdecor.EimpfEntryAntikoerperBestimmungBatteryOrganizer;
import org.projecthusky.cda.elga.generated.artdecor.EimpfEntryAntikoerperBestimmungDataProcessing;
import org.projecthusky.cda.elga.generated.artdecor.enums.EImpfAntikoerperbestimmungVs;
import org.projecthusky.cda.elga.models.Appendix;
import org.projecthusky.cda.elga.models.PractitionerCdaAt;
import org.projecthusky.cda.elga.models.Translation;
import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.hl7cdar2.ActRelationshipHasComponent;
import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040Act;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component4;
import org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.projecthusky.common.hl7cdar2.POCDMT000040Reference;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntry;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.projecthusky.common.utils.time.DateTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AntibodyDetermination {

	private static final Logger LOGGER = LoggerFactory.getLogger(AntibodyDetermination.class.getName());

	private PractitionerCdaAt author;
	private ZonedDateTime timeAuthor;
	private ZonedDateTime startDate;
	private ZonedDateTime stopDate;
	private EImpfAntikoerperbestimmungVs antibodyDeterminationCode;
	private List<AntibodyLaboratory> antibodyLaboratory;
	private Appendix externalDocument;
	private List<Translation> translations;

	public PractitionerCdaAt getAuthor() {
		return author;
	}

	public void setAuthor(PractitionerCdaAt author) {
		this.author = author;
	}

	public ZonedDateTime getTimeAuthor() {
		return timeAuthor;
	}

	public void setTimeAuthor(ZonedDateTime timeAuthor) {
		this.timeAuthor = timeAuthor;
	}

	public ZonedDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(ZonedDateTime startDate) {
		this.startDate = startDate;
	}

	public ZonedDateTime getStopDate() {
		return stopDate;
	}

	public void setStopDate(ZonedDateTime stopDate) {
		this.stopDate = stopDate;
	}

	public EImpfAntikoerperbestimmungVs getAntibodyDetermination() {
		return antibodyDeterminationCode;
	}

	public void setAntibodyDetermination(EImpfAntikoerperbestimmungVs antibodyDetermination) {
		this.antibodyDeterminationCode = antibodyDetermination;
	}

	public List<AntibodyLaboratory> getAntibodyLaboratory() {
		return antibodyLaboratory;
	}

	public void setAntibodyLaboratory(List<AntibodyLaboratory> antibodyLaboratory) {
		this.antibodyLaboratory = antibodyLaboratory;
	}

	public Appendix getExternalDocument() {
		return externalDocument;
	}

	public void setExternalDocument(Appendix externalDocument) {
		this.externalDocument = externalDocument;
	}

	public List<Translation> getTranslations() {
		return translations;
	}

	public void setTranslations(List<Translation> translations) {
		this.translations = translations;
	}

	public EimpfEntryAntikoerperBestimmungDataProcessing getEimpfEntryAntikoerperBestimmungDataProcessing(int index) {
		EimpfEntryAntikoerperBestimmungDataProcessing processing = new EimpfEntryAntikoerperBestimmungDataProcessing();
		processing.setTypeCode(XActRelationshipEntry.DRIV);
		processing.setContextConductionInd(true);
		POCDMT000040Act act = processing.getAct();

		if (author != null) {
			act.getAuthor().add(author.getAtcdabbrOtherAuthorBodyEImpfpass(timeAuthor));
		}

		POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
		entryRel.setTypeCode(XActRelationshipEntryRelationship.COMP);
		entryRel.setContextConductionInd(true);
		entryRel.setOrganizer(getEimpfEntryAntikoerperBestimmungBatteryOrganizer());
		act.getEntryRelationship().add(entryRel);

		if (externalDocument != null) {
			POCDMT000040Reference reference = new POCDMT000040Reference();
			reference.setExternalDocument(externalDocument.getAtcdabbrEntryExternalDocument(index));
			act.getReference().add(reference);
		}

		processing.setAct(act);
		return processing;
	}

	protected EimpfEntryAntikoerperBestimmungBatteryOrganizer getEimpfEntryAntikoerperBestimmungBatteryOrganizer() {
		EimpfEntryAntikoerperBestimmungBatteryOrganizer organizer = new EimpfEntryAntikoerperBestimmungBatteryOrganizer();

		if (this.antibodyDeterminationCode != null) {
			organizer.setCode(new CE(this.antibodyDeterminationCode.getCode().getCode(),
					this.antibodyDeterminationCode.getCode().getCodeSystem(),
					this.antibodyDeterminationCode.getCode().getCodeSystemName(),
					this.antibodyDeterminationCode.getCode().getDisplayName()));
		}

		TS start = null;
		TS stop = null;

		try {
			start = DateTimes.toDatetimeTs(startDate);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		}

		try {
			stop = DateTimes.toDatetimeTs(stopDate);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
		}

		organizer.setEffectiveTime(createIntervalEffectiveTime(start, stop));

		if (antibodyLaboratory != null) {
			int laboratoryIndex = 0;
			for (AntibodyLaboratory laboratory : antibodyLaboratory) {
				if (laboratory != null) {
					POCDMT000040Component4 comp = new POCDMT000040Component4();
					comp.setTypeCode(ActRelationshipHasComponent.COMP);
					comp.setContextConductionInd(true);
					comp.setObservation(
							laboratory.getEimpfEntryAntikoerperBestimmungLaboratoryObservation(laboratoryIndex++));
					organizer.getComponent().add(comp);
				}
			}
		}

		return organizer;
	}

	protected IVLTS createIntervalEffectiveTime(TS low, TS high) {
		IVLTS ivlts = new IVLTS();

		ivlts.getRest().add(new JAXBElement<>(
				new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX), TS.class, low));
		ivlts.getRest()
				.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX),
						TS.class, high));

		return ivlts;
	}

}
