package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.epr.validator.ValidationResult;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;

/**
 * Base class to model an eMediplan document object, be it of CHMED16A or CHMED23A specs.
 * @param <E> The type of eMediplan extension used by this document.
 * @param <M> The type of eMediplan medicament object used by this document.
 */
public abstract class EMediplan<E extends EMediplanObject, M extends EMediplanMedicament<E>> implements EMediplanExtendable<E> {
    public static final String EMEDIPLAN_TIMEZONE = "Europe/Zurich";

    @JsonIgnore
    public abstract String getEmediplanVersion();
    @JsonIgnore
    public abstract String getChTransmissionFormatPrefix();

    public abstract EMediplanPatient<E> getPatient();
    public abstract List<@NonNull M> getMedicaments();
    public abstract @Nullable EMediplanType getType();
    public abstract @Nullable String getId();
    public abstract Instant getTimestamp();
    public abstract @Nullable String getRemark();

    /**
     * Resolves the eMediplan type, which can be missing for ChMed23A eMediplan objects authored by a patient, because a
     * Medication Plan is assumed (since they are not allowed to author prescriptions).
     * @return The resolved {@link EMediplanType}.
     */
    @ExpectsValidResource
    public abstract EMediplanType resolveType();

    /**
     * Convenience method to add a medication to the eMediplan document.
     * @param medicament The eMediplan medicament object to be added.
     */
    public void addMedicament(final @NonNull M medicament) {
        getMedicaments().add(Objects.requireNonNull(medicament));
    }

    @Override
    public ValidationResult validate(final @Nullable String basePath) {
        return validateExtensions(basePath);
    }

    @Override
    public void trim() {
        EMediplanExtendable.super.trim();
        if (getPatient() != null) getPatient().trim();
        if (getMedicaments() != null && !getMedicaments().isEmpty())  getMedicaments().forEach(EMediplanMedicament::trim);
    }

    /**
     * Converts the eMediplan format to the ChTransmissionFormat specified by the relevant ChMed specification.
     * This is useful for data transmission as well as used for the QR code to be embedded in the eMediplan paper/PDF
     * format.
     * <p>Although ChMed16A supports non-compressed content within the transmission format, this implementation
     * supports only compressed content.</p>
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
        return getChTransmissionFormatPrefix() + Base64.getEncoder().encodeToString(compressJson(rawJson));
    }

    /**
     * Compresses the serialized eMediplan (JSON) using GZIP, as specified by CHMED23A and, optionally, CHMED16A.
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
