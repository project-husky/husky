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
import java.util.ListIterator;

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
import org.openehealth.ipf.commons.ihe.xds.core.metadata.PatientInfo;

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
	 * NOTES: 1. XDS metadata does not accept CX types that have more or fewer
	 * components than CX.1, CX.4.2,CX.4.3. Other corresponding componets will not
	 * be extracted.<br>
	 * 2. Implementation consistent with PCC TF-2 Medical Document Binding to XDS,
	 * XDM and XDR.
	 * 
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
					return extractIds(patient.getId());
				}
			}
		}
	}

	private List<Identifiable> extractIds(List<II> ids) {
		List<Identifiable> list = new ArrayList<>();
		for (II id : ids) {
			if (id != null) {
				list.add(map(id));
			}
		}

		return list;
	}

	/**
	 * Extracts the relevant typeCode. Implementation consistent with PCC TF-2
	 * Medical Document Binding to XDS, XDM and XDR. information from the CDA:
	 * ClinicalDocument/code <br>
	 * Note: typeCode and classCode data sources are the same in the CDA
	 * 
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

	/**
	 * Extracts the relevant sourcePatientInfo information from the CDA:
	 * ClinicalDocument/recordTarget/patientRole <br>
	 * NOTES:
	 * <ul>
	 * <li>1. Only the first ClinicalDocument/recordTarget instance will be
	 * considered for sourcePatientId (for which only the first patientRole/id on
	 * it's list will be taken) and sourcePatientInfo .</li>
	 * <li>2. Extracts all id of the list of ids for PatientRole to PID-3 and the
	 * PatientRole/Patient/id</li>
	 * <li>3. XDS metadata does not accept CX types that have more or fewer
	 * components than CX.1, CX.4.2,CX.4.3. Other corresponding componets will not
	 * be extracted.</li>
	 * <li>4. XDS metadata validation for 2007 Connectathon will not accept
	 * SourcePatientInfo beyond local patient ids, patient name, address, birthdate
	 * and gender. Other patient info in the CDA that corresponds to source patient
	 * info will not be extracted.</li>
	 * <li>5.Only the first address will be considered for extraction, only the
	 * first subelements of the AD type will be considered for extraction.</li>
	 * <li>6. Implementation consistent with PCC TF-2 Medical Document Binding to
	 * XDS, XDM and XDR.</li>
	 * </ul>
	 */
	@Override
	public PatientInfo extractSourcePatientInfo() {
		PatientInfo patientInfo = super.extractSourcePatientInfo();

		LinkedList<Identifiable> list = new LinkedList<>(
				List.of(new Identifiable(), new Identifiable(), new Identifiable()));

		ListIterator<Identifiable> listIterator = patientInfo.getIds();

		while (listIterator.hasNext()) {
			Identifiable next = listIterator.next();

			if (next.getAssigningAuthority() != null
					&& "1.2.40.0.10.2.1.1.149".equalsIgnoreCase(next.getAssigningAuthority().getUniversalId())) {
				list.set(0, next);
			} else if (next.getAssigningAuthority() != null
					&& "1.2.40.0.10.1.4.3.1".equalsIgnoreCase(next.getAssigningAuthority().getUniversalId())) {
				list.set(1, next);
			} else {
				list.set(2, next);
			}
		}

		ListIterator<Identifiable> listIt = patientInfo.getIds();
		while (listIt.hasNext()) {
			listIt.next();
			listIt.remove();
		}

		for (Identifiable id : list) {
			patientInfo.getIds().add(id);
		}

		return patientInfo;
	}


}
