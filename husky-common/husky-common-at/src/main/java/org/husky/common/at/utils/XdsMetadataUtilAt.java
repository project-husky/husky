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

package org.husky.common.at.utils;

import org.husky.common.at.enums.ClassCode;
import org.husky.common.at.enums.TypeCode;
import org.husky.common.model.Identificator;

/**
 * Class XdsUtil provides helper methods for the austrian specific IHE XDS
 * Context
 */
public class XdsMetadataUtilAt {

	private XdsMetadataUtilAt() {
		throw new IllegalStateException("Utility class");
	}

	public static String createCxi(Identificator id, String identifierTypeCode, String homeCommunityId) {
		StringBuilder sb = new StringBuilder();
		if (id != null && id.getExtension() != null) {
			sb.append(id.getExtension());
		}
		sb.append("^^^");
		if (id != null && id.getRoot() != null) {
			sb.append("&");
			sb.append(id.getRoot());
			sb.append("&ISO");
		}
		sb.append("^");
		sb.append(identifierTypeCode);
		sb.append("^");

		if (homeCommunityId != null) {
			sb.append("&");
			sb.append(homeCommunityId);
			sb.append("&ISO");
		}

		return sb.toString();
	}

	public static String extractIdOfCxi(String cxi) {
		if (cxi != null && !cxi.isEmpty()) {
			return cxi.substring(0, cxi.indexOf('^'));
		}

		return null;
	}

	/**
	 * Converts the parts of an OHC XCN to an eHC Identificator
	 *
	 * @param assigningAuthorityUniversalId the assigningAuthorityUniversalId
	 * @param id                            the ID part
	 * @return the Identificator
	 */
	public static Identificator convertOhtXcnIdToEhc(String assigningAuthorityUniversalId, String id) {
		return new Identificator(assigningAuthorityUniversalId, id);
	}

	public static ClassCode getClassCodeThroughTypeCode(String typeCode) {
		if (typeCode == null) {
			return null;
		}

		if (TypeCode.isDischargeSummary(typeCode)) {
			return ClassCode.DISCHARGE_SUMMARY;
		} else if (TypeCode.isDiagnosticImagingStudy(typeCode)) {
			return ClassCode.DIAGNOSTIC_IMAGE_STUDY;
		} else if (TypeCode.isMedications(typeCode)) {
			return ClassCode.MEDICATIONS;
		} else if (TypeCode.isLabReport(typeCode)) {
			return ClassCode.LABORATORY_REPORT;
		} else if (TypeCode.isPhysicianNote(typeCode)) {
			return ClassCode.PHYSICIAN_NOTE;
		} else if (TypeCode.isImmunizationHistory(typeCode)) {
			return ClassCode.HISTORY_IMMUNIZATION;
		} else if (ClassCode.isInValueSet(typeCode)) {
			return ClassCode.getEnum(typeCode);
		}

		return null;
	}
}
