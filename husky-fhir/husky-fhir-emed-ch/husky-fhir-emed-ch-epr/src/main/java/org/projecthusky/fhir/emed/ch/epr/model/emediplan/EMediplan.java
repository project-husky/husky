package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.EMediplanAuthor;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.EMediplanType;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;

/**
 * This is the main eMediplan object, called {@code Medication} in ChMed23A specification. It contains exactly one
 * patient and a list of medications (named medicament in ChMed23A).
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class EMediplan implements EMediplanExtendable {
    public static final String EMEDIPLAN_VERSION = "ChMed23A";

    /**
     * The patient.
     */
    protected EMediplanPatient patient;
    /**
     * The healthcare person author of the document, required if the document author type is an HCP.
     */
    protected @Nullable EMediplanHealthcarePerson hcPerson;
    /**
     * The healthcare organization in which the HealthcarePerson works. Required if the document author type is an HCP.
     */
    protected @Nullable EMediplanHealthcareOrganization hcOrg;
    /**
     * List of medications.
     */
    @JsonProperty("meds")
    protected List<@NonNull EMediplanMedicament> medicaments;
    /**
     * The list of extensions. Optional if empty.
     */
    @JsonProperty("exts")
    protected @Nullable List<@NonNull EMediplanExtension> extensions;
    /**
     * The type of Medication object, @see MedicationType.
     */
    @JsonProperty("medType")
    protected EMediplanType type;
    /**
     * The id of the Medication object. The eMediplan document creator is responsible for assigning the id.
     */
    protected @Nullable String id;
    /**
     * The type of author of the document.
     */
    @JsonProperty("auth")
    protected EMediplanAuthor author;
    /**
     * The recipient (GLN) of the electronic prescription. To be used if the electronic prescription is to be
     * transmitted electronically to a healthcare professional.
     */
    @JsonProperty("rec")
    protected @Nullable String recipient;
    /**
     * The date of creation. Format: yyyy-mm-ddThh:mm:ss+02:00 (ISO 86012 Combined date and time in UTC)
     * (e.g. 2016-06-16T16:26:15+02:00)
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "Europe/Zurich")
    @JsonProperty("dt")
    protected Instant timestamp;
    /**
     * Remark. Any information or advice the author would like to share independently of a specific medicament.
     */
    @JsonProperty("mk")
    protected @Nullable String remark;

    public List<@NonNull EMediplanMedicament> getMedicaments() {
        if (medicaments == null) medicaments = new ArrayList<>();
        return medicaments;
    }

    public void addMedicament(final @NonNull EMediplanMedicament medicament) {
        getMedicaments().add(Objects.requireNonNull(medicament));
    }

    public List<@NonNull EMediplanExtension> getExtensions() {
        if (extensions == null) extensions = new ArrayList<>();
        return extensions;
    }

    /**
     * Converts the eMediplan format to the ChTransmissionFormat specified by ChMed23A. This is useful for data
     * transmission as well as used for the QR code to be embedded in the eMediplan paper/PDF format.
     *
     * @return The ChTransmissionFormat string with the eMediplan object information.
     * @throws JsonProcessingException The eMediplan object could not be serialized to JSON.
     * @throws IOException The eMediplan object could not be serialized and compressed to ChTransmissionFormat.
     */
    @ExpectsValidResource
    public String toChTransmissionFormat() throws IOException {
        final var objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        final var rawJson = objectMapper.writeValueAsString(this);
        return EMEDIPLAN_VERSION + "." + Base64.getEncoder().encodeToString(compressJson(rawJson));
    }

    /**
     * Compresses the serialized eMediplan (JSON) using GZIP, as specified by CHMED23A.
     * @param rawJson The raw JSON to be compressed.
     * @return The GZIP compressed byte array.
     * @throws IOException In case of error compressing the JSON content.
     */
    private static byte[] compressJson(final String rawJson) throws IOException {
        final var inputstream = new ByteArrayInputStream(rawJson.getBytes());
        final var outputStream = new ByteArrayOutputStream();
        final var gzipOutputStream = new GZIPOutputStream(outputStream);
        byte[] buffer = new byte[512];
        int bytesRead = 0;
        while ((bytesRead = inputstream.read(buffer)) > -1) {
            gzipOutputStream.write(buffer, 0, bytesRead);
        }
        gzipOutputStream.close();
        return outputStream.toByteArray();
    }
}
