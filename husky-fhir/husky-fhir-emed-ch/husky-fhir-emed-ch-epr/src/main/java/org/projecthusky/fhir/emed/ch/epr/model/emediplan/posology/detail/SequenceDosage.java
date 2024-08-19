package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.PosologyType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.sequence.SequenceElement;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class SequenceDosage extends PosologyDetail {
    /**
     * The ordered list of {@code SequenceElement} objects.
     */
    @JsonProperty("sos")
    protected List<@NonNull SequenceElement> sequence;

    public SequenceDosage() {
        super(PosologyType.SEQUENCE);
    }
}
