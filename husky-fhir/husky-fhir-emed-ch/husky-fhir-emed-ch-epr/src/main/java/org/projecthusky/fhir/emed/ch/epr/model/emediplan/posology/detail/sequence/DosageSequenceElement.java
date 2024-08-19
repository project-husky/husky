package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.sequence;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DosageSequenceType;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.PosologyDetail;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class DosageSequenceElement extends SequenceElement {
    @JsonProperty("po")
    protected PosologyDetail detail;

    public DosageSequenceElement() {
        super(DosageSequenceType.DOSAGE);
    }

    public DosageSequenceElement(final PosologyDetail detail) {
        this();
        this.detail = detail;
    }
}
