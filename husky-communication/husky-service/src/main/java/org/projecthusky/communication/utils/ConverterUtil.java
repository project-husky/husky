/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.utils;

import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.projecthusky.common.enums.TelecomAddressUse;
import org.springframework.util.Assert;

/**
 * Util class to make conversions between Husky, Fhir and Gazelle model classes easy.
 * <ul>
 * <li>Convert {@link AdministrativeGender} to 1 char String</li>
 * <li>Convert {@link ContactPoint} to short String</li>
 * </ul>
 * @implNote The conversions lack serious details and need to be extended in the future.
 * @author szalai
 * @see PdqSearchQuery
 * @see ConverterUtilTest for missing conversions in {@link ContactPoint}s.
 */
public class ConverterUtil {
	
	public static String convertAdministrativeGenderToSingleCharString(AdministrativeGender gender) {
		Assert.notNull(gender, "The AdministrativeGender parameter must not be null.");
    return switch (gender) {
      case FEMALE -> "F";
      case MALE -> "M";
      default -> "U"; //Not sure this can happen with the current building pattern.
    };
	}
	
	public static String convertContactPointToTypeString(ContactPoint contactPoint) {
		Assert.notNull(contactPoint, "The ContactPoint parameter nust not be null.");
		var use = "";
		if (ContactPointSystem.PHONE.equals(contactPoint.getSystemElement().getValue())) {
			if (ContactPointUse.HOME.equals(contactPoint.getUseElement().getValue())) {
				use = "HP";
			} else if (ContactPointUse.WORK.equals(contactPoint.getUseElement().getValue())) {
				use = "WP";
			}
		}
		return use;
	}
	
	public static String getTelecomValue(ContactPoint contactPoint) {
		Assert.notNull(contactPoint, "The ContactPoint parameter must not be null.");
		var system = "";
		var value = "NULL";

		if (contactPoint.getSystem() != null)
			system = contactPoint.getSystem().toString().toLowerCase();

		if (contactPoint.getValue() != null)
			value = contactPoint.getValue();

		if ("phone".equals(system)) {
			return "tel:" + value;
		}
		if ("email".equals(system)) {
			return "mailto:" + value;
		}

		return value;
	}
	
	//TODO: inconsistent implementation when comparing to #getTelecomValue(ContactPoint).
	public static String getTelecomAddressUse(ContactPoint contactPoint) {
		Assert.notNull(contactPoint, "The ContactPoint parameter must not be null.");
		var use = "";

		if (contactPoint.getUse() != null)
			use = contactPoint.getUse().toString().toLowerCase();

		if ("home".equals(use)) {
			return TelecomAddressUse.PRIVATE.getCodeValue();
		}
		if ("work".equals(use)) {
			return TelecomAddressUse.BUSINESS.getCodeValue();
		}

		return null;
	}
	
}
