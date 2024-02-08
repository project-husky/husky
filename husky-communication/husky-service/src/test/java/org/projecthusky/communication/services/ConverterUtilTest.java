/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.enums.TelecomAddressUse;
import org.projecthusky.communication.utils.ConverterUtil;

public class ConverterUtilTest {
	
	@Test
	public void whenConvertingAdministrativeGenderToString_andGivingNullObject_thenExceptionIsThrown() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ConverterUtil.convertAdministrativeGenderToSingleCharString(null);
		});
		Assertions.assertEquals("The AdministrativeGender parameter must not be null.", exception.getMessage());
	}
	
	@Test
	public void whenConvertingAdministrativeGenderToString_thenCorrectValuesAreReturned() {
		assertEquals("M", ConverterUtil.convertAdministrativeGenderToSingleCharString(AdministrativeGender.MALE));
		assertEquals("F", ConverterUtil.convertAdministrativeGenderToSingleCharString(AdministrativeGender.FEMALE));
		assertEquals("U", ConverterUtil.convertAdministrativeGenderToSingleCharString(AdministrativeGender.OTHER));
		assertEquals("U", ConverterUtil.convertAdministrativeGenderToSingleCharString(AdministrativeGender.UNKNOWN));
		assertEquals("U", ConverterUtil.convertAdministrativeGenderToSingleCharString(AdministrativeGender.NULL));
		
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			ConverterUtil.convertAdministrativeGenderToSingleCharString(null);
		});
		Assertions.assertEquals("The AdministrativeGender parameter must not be null.", exception.getMessage());
	}
	
	@Test
	public void whenConvertingContactPointTypeToString_andGivingNullObject_thenExceptionIsThrown() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ConverterUtil.convertContactPointToTypeString(null);
		});
		Assertions.assertEquals("The ContactPoint parameter nust not be null.", exception.getMessage());
	}
	
	//TODO: This test is here mostly to show that the implementation before 2.0.1 is missing a lot of detail, for example the contact point conversion.
	@Test
	public void whenConvertingContactPointTypeToString_thenCorrectValuesAreReturned() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			ConverterUtil.convertContactPointToTypeString(null);
		});
		Assertions.assertEquals("The ContactPoint parameter nust not be null.", exception.getMessage());
		
		ContactPoint contactPoint = new ContactPoint();
		contactPoint.setSystem(ContactPointSystem.PHONE);
		contactPoint.setUse(ContactPointUse.HOME);
		assertEquals("HP", ConverterUtil.convertContactPointToTypeString(contactPoint));
		
		contactPoint = new ContactPoint();
		contactPoint.setSystem(ContactPointSystem.PHONE);
		contactPoint.setUse(ContactPointUse.WORK);
		assertEquals("WP", ConverterUtil.convertContactPointToTypeString(contactPoint));
		
		//Rest was not implemented until now.
		contactPoint = new ContactPoint();
		contactPoint.setSystem(ContactPointSystem.PHONE);
		contactPoint.setUse(ContactPointUse.MOBILE);
		assertEquals("", ConverterUtil.convertContactPointToTypeString(contactPoint));
		
		contactPoint = new ContactPoint();
		contactPoint.setSystem(ContactPointSystem.PHONE);
		contactPoint.setUse(ContactPointUse.TEMP);
		assertEquals("", ConverterUtil.convertContactPointToTypeString(contactPoint));

		contactPoint = new ContactPoint();
		contactPoint.setSystem(ContactPointSystem.PHONE);
		contactPoint.setUse(ContactPointUse.OLD);
		assertEquals("", ConverterUtil.convertContactPointToTypeString(contactPoint));
		
		contactPoint = new ContactPoint();
		contactPoint.setSystem(ContactPointSystem.PHONE);
		contactPoint.setUse(ContactPointUse.NULL);
		assertEquals("", ConverterUtil.convertContactPointToTypeString(contactPoint));
		
		//especially non-phone contacts are not converted.
		contactPoint = new ContactPoint();
		contactPoint.setSystem(ContactPointSystem.EMAIL);
		assertEquals("", ConverterUtil.convertContactPointToTypeString(contactPoint));
		
		contactPoint = new ContactPoint();
		contactPoint.setSystem(ContactPointSystem.FAX);
		assertEquals("", ConverterUtil.convertContactPointToTypeString(contactPoint));
		
		contactPoint = new ContactPoint();
		contactPoint.setSystem(ContactPointSystem.PAGER);
		assertEquals("", ConverterUtil.convertContactPointToTypeString(contactPoint));
		
		contactPoint = new ContactPoint();
		contactPoint.setSystem(ContactPointSystem.SMS);
		assertEquals("", ConverterUtil.convertContactPointToTypeString(contactPoint));
		
		contactPoint = new ContactPoint();
		contactPoint.setSystem(ContactPointSystem.URL);
		assertEquals("", ConverterUtil.convertContactPointToTypeString(contactPoint));

		contactPoint = new ContactPoint();
		contactPoint.setSystem(ContactPointSystem.OTHER);
		assertEquals("", ConverterUtil.convertContactPointToTypeString(contactPoint));

		contactPoint = new ContactPoint();
		contactPoint.setSystem(ContactPointSystem.NULL);
		assertEquals("", ConverterUtil.convertContactPointToTypeString(contactPoint));
	}
	
	@Test
	public void whenReadingContactPointValue_andGivingNullObject_thenExceptionIsThrown() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ConverterUtil.getTelecomValue(null);
		});
		Assertions.assertEquals("The ContactPoint parameter must not be null.", exception.getMessage());
	}
	
	@Test
	public void whenReadingContactPointValue_thenCorrectValuesAreRead() {
		assertEquals("NULL", ConverterUtil.getTelecomValue(new ContactPoint()));
		assertEquals("NULL", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(null)));
		
		assertEquals("tel:00436668883355", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.PHONE).setValue("00436668883355")));
		assertEquals("tel:NULL", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.PHONE).setValue(null))); //This is probably a bad implementation.
		
		assertEquals("mailto:droid@hzb.tor", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.EMAIL).setValue("droid@hzb.tor")));
		assertEquals("mailto:NULL", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.EMAIL).setValue(null))); //This is probably a bad implementation.

		assertEquals("NULL", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.FAX).setValue(null)));
		assertEquals("NULL", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.PAGER).setValue(null)));
		assertEquals("NULL", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.SMS).setValue(null)));
		assertEquals("NULL", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.URL).setValue(null)));
		assertEquals("NULL", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.OTHER).setValue(null)));
		assertEquals("NULL", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.NULL).setValue(null)));

		assertEquals("+41 1 27 776 555 11", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.FAX).setValue("+41 1 27 776 555 11")));
		assertEquals("+41 1 77 8888 19 60", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.PAGER).setValue("+41 1 77 8888 19 60")));
		assertEquals("00436668883355", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.SMS).setValue("00436668883355")));
		assertEquals("www.checkme.out", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.URL).setValue("www.checkme.out")));
		assertEquals("OTHER CONTACT", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.OTHER).setValue("OTHER CONTACT")));
		assertEquals("whatever - but not ignored", ConverterUtil.getTelecomValue(new ContactPoint().setSystem(ContactPointSystem.NULL).setValue("whatever - but not ignored")));
	}
	
	@Test
	void whenReadingTelecomAddress_andGivingNullObject_thenExceptionIsThrown() throws Exception {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ConverterUtil.getTelecomAddressUse(null);
		});
		Assertions.assertEquals("The ContactPoint parameter must not be null.", exception.getMessage());
	}
	
	@Test
	void whenReadingTelecomAddress_thenCorrectValueIsRead() throws Exception {
		assertEquals(null, ConverterUtil.getTelecomAddressUse(new ContactPoint()));
		assertEquals(null, ConverterUtil.getTelecomAddressUse(new ContactPoint().setUse(null)));
		
		assertEquals(TelecomAddressUse.PRIVATE.getCodeValue(), ConverterUtil.getTelecomAddressUse(new ContactPoint().setUse(ContactPointUse.HOME)));
		assertEquals(TelecomAddressUse.BUSINESS.getCodeValue(), ConverterUtil.getTelecomAddressUse(new ContactPoint().setUse(ContactPointUse.WORK)));
		
		assertEquals(null, ConverterUtil.getTelecomAddressUse(new ContactPoint().setUse(ContactPointUse.MOBILE)));
		assertEquals(null, ConverterUtil.getTelecomAddressUse(new ContactPoint().setUse(ContactPointUse.TEMP)));
		assertEquals(null, ConverterUtil.getTelecomAddressUse(new ContactPoint().setUse(ContactPointUse.OLD)));
		assertEquals(null, ConverterUtil.getTelecomAddressUse(new ContactPoint().setUse(ContactPointUse.NULL)));
	}
}
