package org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.posology.detail.sequence;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed23a.enums.DosageSequenceType;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Pause extends SequenceElement {
    public Pause() {
        super(DosageSequenceType.PAUSE);
    }

    @Override
    public boolean hasExtensions(boolean inDepth) {
        return false;
    }
}
