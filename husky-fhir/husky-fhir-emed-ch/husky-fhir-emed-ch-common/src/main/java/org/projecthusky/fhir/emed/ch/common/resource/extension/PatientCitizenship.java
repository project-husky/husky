package org.projecthusky.fhir.emed.ch.common.resource.extension;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.util.ElementUtil;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Period;

/**
 * Model for the FHIR <a href="http://hl7.org/fhir/StructureDefinition/patient-citizenship">PatCitizenship</a> extension.
 */
@Block
@Getter
@Setter
public class PatientCitizenship extends BackboneElement {
    public static final String URL = "http://hl7.org/fhir/StructureDefinition/patient-citizenship";
    public static final String CODE_URL = "code";
    public static final String PERIOD_URL = "period";

    @Nullable
    @Child(name = "extension:" + CODE_URL)
    @Extension(url = CODE_URL, definedLocally = false)
    protected CodeableConcept code;

    @Nullable
    @Child(name = "extension:" + PERIOD_URL)
    @Extension(url = PERIOD_URL, definedLocally = false)
    protected Period period;

    public boolean hasCode() {
        return code != null && !code.isEmpty();
    }

    public boolean hasPeriod() {
        return period != null && !period.isEmpty();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty() && ElementUtil.isEmpty(code, period);
    }

    @Override
    public PatientCitizenship copy() {
        final var copy = new PatientCitizenship();
        copyValues(copy);
        return copy;
    }

    @Override
    public void copyValues(final BackboneElement dst) {
        super.copyValues(dst);
        if (dst instanceof PatientCitizenship als) {
            als.code = code == null ? null : code.copy();
            als.period = period == null ? null : period.copy();
        }
    }
}
