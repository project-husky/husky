/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.communication.at;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.husky.common.hl7cdar2.CE;
import org.husky.common.hl7cdar2.II;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.common.hl7cdar2.POCDMT000040PatientRole;
import org.husky.common.hl7cdar2.POCDMT000040RecordTarget;
import org.husky.common.hl7cdar2.QTY;
import org.husky.common.hl7cdar2.TS;
import org.husky.common.utils.time.DateTimes;
import org.husky.common.utils.time.Hl7Dtm;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssociationType;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;

public class CDAR2ExtractorAt extends org.husky.common.communication.CDAR2Extractor {

	/**
	 * Loads CDA Document
	 * 
	 * @param cda the CDA R2 document to extract metadata from for the document
	 *            entry metadata. Cannot be null.
	 */
	public CDAR2ExtractorAt(POCDMT000040ClinicalDocument cda) {
		super(cda);
	}

	/**
	 * Extracts the relevant confidentialityCodes information from the CDA:
	 * ClinicalDocument/confidentialityCode. Implementation consistent with PCC TF-2
	 * Medical Document Binding to XDS, XDM and XDR.
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractConfidentialityCode()
	 */
	@Override
	public List<Code> extractConfidentialityCodes() {
		if (cda.getConfidentialityCode() == null) {
			return new LinkedList<>();
		}

		Code code = map(cda.getConfidentialityCode());
		return List.of(code);
	}

	/**
	 * This extraction routine, at this point, does not attempt to extract event
	 * code metadata from a generic CDA R2 document.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractEventCodes()
	 */
	public Code extractEventCode() {
		if (!cda.getDocumentationOf().isEmpty()) {
			CE serviceEvent = cda.getDocumentationOf().get(0).getServiceEvent().getCode();
			return map(serviceEvent);
		}
		return null;
	}

	public Instant extractEventStartTime() {
		if (!cda.getDocumentationOf().isEmpty()) {
			IVLTS serviceEventTime = cda.getDocumentationOf().get(0).getServiceEvent().getEffectiveTime();

			if (serviceEventTime != null) {
				for (JAXBElement<? extends QTY> element : serviceEventTime.getRest()) {
					if (element != null && element.getName() != null && element.getName().getLocalPart() != null
							&& element.getName().getLocalPart().equalsIgnoreCase("low")
							&& element.getValue() instanceof TS) {
						var hl7Dtm = Hl7Dtm.fromHl7(((TS) element.getValue()).getValue());
						return DateTimes.toInstant(hl7Dtm);
					}
				}
			}
		}
		return null;
	}

	/**
	 * This extraction routine, at this point, does not attempt to extract event
	 * code metadata from a generic CDA R2 document.
	 * 
	 * @return null
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractEventCodes()
	 */
	public Instant extractEventStopTime() {
		if (!cda.getDocumentationOf().isEmpty()) {
			IVLTS serviceEventTime = cda.getDocumentationOf().get(0).getServiceEvent().getEffectiveTime();

			if (serviceEventTime != null) {
				for (JAXBElement<? extends QTY> element : serviceEventTime.getRest()) {
					if (element != null && element.getName() != null && element.getName().getLocalPart() != null
							&& element.getName().getLocalPart().equalsIgnoreCase("high")
							&& element.getValue() instanceof TS) {
						var hl7Dtm = Hl7Dtm.fromHl7(((TS) element.getValue()).getValue());
						return DateTimes.toInstant(hl7Dtm);
					}
				}
			}

		}
		return null;
	}

	/**
	 * Extracts all patientId information from the CDA:
	 * ClinicalDocument/recordTarget/patientRole/id <br>
	 * NOTES:
	 * <li>1. XDS metadata does not accept CX types that have more or fewer
	 * components than CX.1, CX.4.2,CX.4.3. Other corresponding componets will not
	 * be extracted.</li>
	 * <li>2. Implementation consistent with PCC TF-2 Medical Document Binding to
	 * XDS, XDM and XDR.</li>
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractSourcePatientId()
	 */
	public List<Identifiable> extractPatientIds() {
		if (!atLeastOne(cda.getRecordTarget())) {
			return new ArrayList<>();
		} else {
			POCDMT000040RecordTarget target = cda.getRecordTarget().get(0);
			if (target.getPatientRole() == null) {
				return new ArrayList<>();
			} else {
				POCDMT000040PatientRole patient = target.getPatientRole();
				if (!atLeastOne(patient.getId())) {
					return new ArrayList<>();
				} else {
					List<Identifiable> list = new ArrayList<>();
					for (II id : patient.getId()) {
						if (id != null) {
							list.add(map(id));
						}
					}

					return list;
				}
			}
		}
	}

	/**
	 * Extracts the relevant typeCode. Implementation consistent with PCC TF-2
	 * Medical Document Binding to XDS, XDM and XDR. information from the CDA:
	 * ClinicalDocument/code <br>
	 * Note: typeCode and classCode data sources are the same in the CDA
	 * 
	 * @see org.openhealthtools.ihe.xds.metadata.extract.DocumentEntryElementExtractor.extractTypeCode()
	 */

	public Code extractTypeCodeOfTranslation() {
		if (cda.getCode() == null) {
			return null;
		}

		if (cda.getCode().getTranslation().isEmpty()) {
			return null;
		}
		if (cda.getCode().getTranslation().get(0) == null || cda.getCode().getTranslation().get(0).getCode() == null) {
			return null;
		}
		if (cda.getCode().getTranslation().get(0) == null || cda.getCode().getTranslation().get(0).getCode() == null) {
			return null;
		}
		return map(cda.getCode().getTranslation().get(0));
	}

	/**
	 * Extracts the relevant typeCode from CDA.
	 * 
	 */
	@Override
	public Code extractTypeCode() {
		if (cda.getCode() == null) {
			return null;
		}

		return map(cda.getCode());
	}

	public Code extractCode() {
		return extractTypeCode();
	}

	/**
	 * DocumentEntry.parentDocument expresses the id and relationship of a parent
	 * document to this CDA document in the XDS Regisry. This is not necessairly the
	 * same parent document that is documented within the CDA. Thus, this
	 * information is not extracted.
	 * 
	 * @return null
	 */
	@Override
	public Identifiable extractParentDocument() {
		if (!cda.getRelatedDocument().isEmpty() && cda.getRelatedDocument().get(0) != null
				&& cda.getRelatedDocument().get(0).getParentDocument() != null
				&& !cda.getRelatedDocument().get(0).getParentDocument().getId().isEmpty()
				&& cda.getRelatedDocument().get(0).getParentDocument().getId().get(0) != null) {
			return map(cda.getRelatedDocument().get(0).getParentDocument().getId().get(0));
		}

		return null;
	}

	/**
	 * DocumentEntry.parentDocument expresses the id and relationship of a parent
	 * document to this CDA document in the XDS Regisry. This is not necessairly the
	 * same parent document that is documented within the CDA. Thus, this
	 * information is not extracted.
	 * 
	 * @return null
	 */
	public AssociationType extractParentDocumentType() {
		if (!cda.getRelatedDocument().isEmpty() && cda.getRelatedDocument().get(0) != null
				&& cda.getRelatedDocument().get(0).getTypeCode() != null) {
			switch (cda.getRelatedDocument().get(0).getTypeCode()) {
			case APND:
				return AssociationType.APPEND;
			case RPLC:
				return AssociationType.REPLACE;
			case XFRM:
				return AssociationType.TRANSFORM;
			default:
				return null;
			}
		}

		return null;
	}

}
