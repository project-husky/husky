package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.sequence.SequenceElement;

import java.util.List;

public class SequenceDosage extends PosologyDetail {
    /**
     * The ordered list of {@code SequenceElement} objects.
     */
    @JsonProperty("sos")
    protected List<@NonNull SequenceElement> sequence;
}
