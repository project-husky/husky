package org.projecthusky.fhir.emed.ch.epr.model.emediplan;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Identifier;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.PatientIdType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EMediplanPatientId {
    protected PatientIdType type;
    @JsonProperty("sId")
    protected @Nullable String system;
    @JsonProperty("val")
    protected String value;

    public static EMediplanPatientId fromFhirIdentifier(final Identifier identifier) {
        return new EMediplanPatientId(
            CodeSystems.SWISS_VEKA_NR.getCodeSystemId().equalsIgnoreCase(Oids.normalize(identifier.getSystem()))?
                PatientIdType.INSURANCE_CARD_NUMBER : PatientIdType.LOCAL_PID,
            identifier.getSystem(),
            identifier.getValue()
        );
    }
}
