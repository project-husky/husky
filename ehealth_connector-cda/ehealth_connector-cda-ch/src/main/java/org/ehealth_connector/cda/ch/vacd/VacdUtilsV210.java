/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.cda.ch.vacd;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.ehealth_connector.cda.ch.vacd.v210.CdachvacdHeaderPatientMasked;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.hl7cdar2.AD;
import org.ehealth_connector.common.hl7cdar2.AdxpCity;
import org.ehealth_connector.common.hl7cdar2.AdxpCountry;
import org.ehealth_connector.common.hl7cdar2.AdxpPostalCode;
import org.ehealth_connector.common.hl7cdar2.AdxpState;
import org.ehealth_connector.common.hl7cdar2.ObjectFactory;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Patient;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040PatientRole;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040RecordTarget;

/**
 * <div class="en">Contains some utilities for the management of CDA-CH-VACD
 * V2.1.0.</div> <div class="de">Enthält einige Tools für die Verwaltung von
 * CDA-CH-VACD V2.1.0.</div>.
 *
 */
public class VacdUtilsV210 {

	/**
	 * <div class="en">Pseudonymization of a clinical document according to the
	 * CDA-CH-VACD specification (Masked Patient)</div>
	 * <div class="de">Pseudonymisierung eines ClinicalDocument nach der
	 * CDA-CH-VACD Spezifikation (Masked Patient)</div>.
	 *
	 * @param doc
	 *            the doc
	 */
	public static void pseudonymization(POCDMT000040ClinicalDocument doc) {

		POCDMT000040RecordTarget srcRecordTarget;
		POCDMT000040RecordTarget destRecordTarget = null;
		ArrayList<POCDMT000040RecordTarget> list = new ArrayList<POCDMT000040RecordTarget>();
		ObjectFactory factory = new ObjectFactory();

		if (doc.getRecordTarget().size() > 0) {
			for (POCDMT000040RecordTarget recordTarget : doc.getRecordTarget()) {
				srcRecordTarget = recordTarget;

				destRecordTarget = new CdachvacdHeaderPatientMasked();

				POCDMT000040PatientRole sourcePatientRole = srcRecordTarget.getPatientRole();
				POCDMT000040PatientRole destPatientRole = factory.createPOCDMT000040PatientRole();

				POCDMT000040Patient sourcePatient = sourcePatientRole.getPatient();
				POCDMT000040Patient destPatient = factory.createPOCDMT000040Patient();

				destPatientRole.setPatient(destPatient);

				// Copy the allow attributes from the sourcePatient
				destPatient.setBirthTime(sourcePatient.getBirthTime());
				destPatient
						.setAdministrativeGenderCode(sourcePatient.getAdministrativeGenderCode());

				// Adress
				for (final AD sourceAd : sourcePatientRole.getAddr()) {
					final AD ad = factory.createAD();
					for (final Serializable element : sourceAd.getContent()) {
						if (element instanceof JAXBElement) {
							JAXBElement<?> elem = (JAXBElement<?>) element;
							if (elem.getValue() instanceof AdxpPostalCode) {
								AdxpPostalCode obj = new AdxpPostalCode();
								obj.xmlContent = ((AdxpPostalCode) elem.getValue()).xmlContent;
								ad.getContent()
										.add(new JAXBElement<AdxpPostalCode>(
												new QName("urn:hl7-org:v3", "postalCode"),
												AdxpPostalCode.class, obj));
							} else if (elem.getValue() instanceof AdxpCity) {
								AdxpCity obj = (AdxpCity) elem.getValue();
								ad.getContent().add(new JAXBElement<AdxpCity>(
										new QName("urn:hl7-org:v3", "city"), AdxpCity.class, obj));
							} else if (elem.getValue() instanceof AdxpState) {
								AdxpState obj = (AdxpState) elem.getValue();
								// retVal.setState(obj.xmlContent);
							} else if (elem.getValue() instanceof AdxpCountry) {
								AdxpCountry obj = (AdxpCountry) elem.getValue();
								ad.getContent()
										.add(new JAXBElement<AdxpCountry>(
												new QName("urn:hl7-org:v3", "country"),
												AdxpCountry.class, obj));
							}
						}
					}
					ad.getUse().addAll(sourceAd.getUse());
					destPatientRole.getAddr().add(ad);
				}

				// IDs (The patient's id. This information is mandatory to
				// assign immunization recommendation responses to the correct
				// patient in the requester's information system, because
				// demographic data is masked.)
				destPatientRole.getId().add(new Identificator(IdentificatorBaseType.builder()
						.withRoot("2.999").withExtension("1234567").build()).getHl7CdaR2Ii());
				destRecordTarget.setPatientRole(destPatientRole);
			}
			list.add(destRecordTarget);
		}
		doc.getRecordTarget().clear();
		for (POCDMT000040RecordTarget item : list) {
			doc.getRecordTarget().add(item);
		}
	}
}