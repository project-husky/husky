package org.husky.emed.cda.services.readers;

import org.husky.common.enums.AdministrativeGender;
import org.husky.common.hl7cdar2.*;
import org.husky.common.utils.StreamUtils;
import org.husky.emed.errors.InvalidEmedContentException;
import org.husky.common.utils.time.DateTimes;

import javax.xml.bind.JAXBElement;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

/**
 * A reader for CDA-CH-EMED documents.
 *
 * <p>The reader is quite conservative and will fail early to prevent misreading an Emed document. If the passed
 * CDA-CH-EMED document to read is invalid, exceptions may be thrown anywhere.
 *
 * @author Quentin Ligier
 */
@Deprecated(forRemoval = true)
public class EmedDocumentReader {

    /**
     * The parsed CDA-CH-EMED document.
     */
    private final POCDMT000040ClinicalDocument clinicalDocument;

    /**
     * Constructor of the CDA-CH-EMED reader. It expects a parsed, valid CDA-CH-EMED document.
     *
     * @param clinicalDocument The non-null parsed CDA-CH-EMED document to read. It shall be valid (i.e. passing the XML
     *                         Schema and Schematron validation).
     */
    public EmedDocumentReader(final POCDMT000040ClinicalDocument clinicalDocument) {
        Objects.requireNonNull(clinicalDocument, "The CDA-CH-EMED document shall not be null");
        this.clinicalDocument = clinicalDocument;
    }

    /**
     * Returns the patient gender.
     *
     * @return a value of {@link AdministrativeGender}.
     * @throws InvalidEmedContentException if
     */
    public AdministrativeGender getPatientGender() throws InvalidEmedContentException {
        return Optional.ofNullable(this.clinicalDocument.getRecordTarget())
                .map(StreamUtils::getListFirst)
                .map(POCDMT000040RecordTarget::getPatientRole)
                .map(POCDMT000040PatientRole::getPatient)
                .map(POCDMT000040Patient::getAdministrativeGenderCode)
                .map(CD::getCode)
                .map(AdministrativeGender::getEnum)
                .orElseThrow(() -> new InvalidEmedContentException("Unable to retrieve the patient gender"));
    }

    /**
     * Returns the patient birth date; it may be {@code null} if a null flavor is used.
     *
     * @return an optional that may contain the patient birth date as a {@link LocalDate}.
     */
    public Optional<LocalDate> getPatientBirthDate() {
        return Optional.ofNullable(this.clinicalDocument.getRecordTarget())
                .map(StreamUtils::getListFirst)
                .map(POCDMT000040RecordTarget::getPatientRole)
                .map(POCDMT000040PatientRole::getPatient)
                .map(POCDMT000040Patient::getBirthTime)
                .map(DateTimes::toLocalDate); // TODO
    }

    /**
     * Returns the patient's given name (first name).
     * <p>
     * TODO: how to deal with multiple names?
     *
     * @return the patient given name.
     * @throws InvalidEmedContentException if
     */
    public String getPatientGivenName() throws InvalidEmedContentException {
        return Optional.ofNullable(this.clinicalDocument.getRecordTarget())
                .map(StreamUtils::getListFirst)
                .map(POCDMT000040RecordTarget::getPatientRole)
                .map(POCDMT000040PatientRole::getPatient)
                .map(POCDMT000040Patient::getName)
                .map(StreamUtils::getListFirst)
                .map(EN::getContent)
                .orElse(Collections.emptyList())
                .stream()
                .filter(JAXBElement.class::isInstance)
                .filter(jaxbElement -> ((JAXBElement<?>) jaxbElement).getValue() instanceof EnGiven)
                .map(jaxbElement -> (EnGiven) ((JAXBElement<?>) jaxbElement).getValue())
                .filter(enGiven -> enGiven.getQualifier() == null || enGiven.getQualifier().isEmpty())
                .findFirst()
                .map(enGiven -> enGiven.getXmlMixed().get(0)) // TODO
                .orElseThrow(() -> new InvalidEmedContentException("Unable to retrieve the patient given name"));
    }

    /**
     * Returns the patient's family name (last name).
     * <p>
     * TODO: how to deal with multiple names?
     *
     * @return the patient family name.
     * @throws InvalidEmedContentException if
     */
    public String getPatientFamilyName() throws InvalidEmedContentException {
        return Optional.ofNullable(this.clinicalDocument.getRecordTarget())
                .map(StreamUtils::getListFirst)
                .map(POCDMT000040RecordTarget::getPatientRole)
                .map(POCDMT000040PatientRole::getPatient)
                .map(POCDMT000040Patient::getName)
                .map(StreamUtils::getListFirst)
                .map(EN::getContent)
                .orElse(Collections.emptyList())
                .stream()
                .filter(JAXBElement.class::isInstance)
                .filter(jaxbElement -> ((JAXBElement<?>) jaxbElement).getValue() instanceof EnFamily)
                .map(jaxbElement -> (EnFamily) ((JAXBElement<?>) jaxbElement).getValue())
                .filter(enFamily -> enFamily.getQualifier() == null || enFamily.getQualifier().isEmpty())
                .findFirst()
                .map(enFamily -> enFamily.getXmlMixed().get(0)) // TODO
                .orElseThrow(() -> new InvalidEmedContentException("Unable to retrieve the patient family name"));
    }
}
