package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.sequence;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.PosologyDetail;

public class DosageSequenceElement extends SequenceElement {
    @JsonProperty("po")
    protected PosologyDetail detail;
}
