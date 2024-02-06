package org.projecthusky.communication.enums;

import lombok.Getter;

/**
 * Refer to the following
 * {@linkplain }
 * @see <a href="https://www.ihe.net/uploadedFiles/Documents/ITI/IHE_ITI_Suppl_HPD.pdf">IHE_ITI_Suppl_HPD.pdf</a>
 * @see <a href="https://www.fedlex.admin.ch/filestore/fedlex.data.admin.ch/eli/oce/2022/39/de/pdf-a/fedlex-data-admin-ch-eli-oce-2022-39-de-pdf-a.pdf">fedlex-data-admin-ch-eli-oce-2022-39-de-pdf-a.pdf</a>
 *  for the enum values
 */
@Getter
public enum HpdAttributeName {
  AUDIO("audio"),
  BUSINESS_CATEGORY("businessCategory"),
  CAR_LICENSE("carLicense"),
  COMMON_NAME("cn"),
  COUNTRY_OF_CITIZENSHIP("countryOfCitizenship"),
  COUNTRY_OF_RESIDENCE("countryOfResidence"),
  DATE_OF_BIRTH("dateOfBirth"),
  DEPARTMENT_NUMBER("departmentNumber"),
  DESCRIPTION("description"),
  DISPLAY_NAME("displayName"),
  EMAIL_ADDRESS("emailAddress"),
  EMPLOYEE_NUMBER("employeeNumber"),
  EMPLOYEE_TYPE("employeeType"),
  GENDER("gender"),
  GIVEN_NAME("givenName"), // First name
  HC_ATTRIBUTE_CERTIFICATE("hcAttributeCertificate"),
  HC_IDENTIFICATION_SERVICE("hcIdentificationService"),
  HC_IDENTIFIER("hcIdentifier"),
  HC_ORGANIZATION_CERTIFICATES("HcOrganizationCertificates"),
  HC_PRACTICE_LOCATION("HcPracticeLocation"),
  HC_PRINCIPAL_PRACTICE_LOCATION("hcPrincipalPracticeLocation"),
  HC_PROFESSION("hcProfession"),
  HC_REGISTERED_NAME("HcRegisteredName"),
  HC_REGISTRATION_STATUS("HcRegistrationStatus"),
  HC_ROLE("hcRole"),
  HC_SIGNING_CERTIFICATE("HcSigningCertificate"),
  HC_SPECIALIZATION("HcSpecialization"),
  HOME_PHONE("homePhone"),
  HOME_POSTAL_ADDRESS("homePostalAddress"),
  HPD_CREDENTIAL("hpdCredential"),
  HPD_HAS_A_SERVICE("hpdHasAService"),
  HPD_MEDICAL_RECORDS_DELIVERY_EMAIL_ADDRESS("hpdMedicalRecordsDeliveryEmailAddress"),
  HPD_PROVIDER_BILLING_ADDRESS("hpdProviderBillingAddress"),
  HPD_PROVIDER_LANGUAGE_SUPPORTED("hpdProviderLanguageSupported"),
  HPD_PROVIDER_LEGAL_ADDRESS("hpdProviderLegalAddress"),
  HPD_PROVIDER_MAILING_ADDRESS("hpdProviderMailingAddress"),
  HPD_PROVIDER_PRACTICE_ADDRESS("hpdProviderPracticeAddress"),
  HPD_PROVIDER_STATUS("hpdProviderStatus"),
  INITIALS("initials"),
  JPEG_PHOTO("jpegPhoto"),
  LABELED_URI("labeledURI"),
  MAIL("mail"),
  MANAGER("manager"),
  MEMBER_OF("memberOf"),
  MOBILE("mobile"),
  OBJECT_CLASS("objectClass"),
  ORGANIZATION("o"),
  OWNER("owner"),
  PAGER("pager"),
  PHOTO("photo"),
  PLACE_OF_BIRTH("placeOfBirth"),
  PREFERRED_LANGUAGE("preferredLanguage"),
  PSEUDONYM("pseudonym"),
  ROOM_NUMBER("roomNumber"),
  SECRETARY("secretary"),
  SEE_ALSO("seeAlso"),
  SERIAL_NUMBER("serialNumber"),
  SURNAME("sn"), // Last name
  TELEPHONE_NUMBER("telephoneNumber"),
  TITLE("title"),
  UID("uid"),
  UNSTRUCTURED_ADDRESS("unstructuredAddress"),
  UNSTRUCTURED_NAME("unstructuredName"),
  USER_CERTIFICATE("userCertificate"),
  USER_PASSWORD("userPassword"),
  USER_PKCS_12("userPKCS12"),
  USER_SMIME_CERTIFICATE("userSMIMECertificate"),
  X500_UNIQUE_IDENTIFIER("x500UniqueIdentifier");

  private String name;
  HpdAttributeName(String name) {
    this.name = name;
  }
}
