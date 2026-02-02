package org.projecthusky.fhir.core.ch.resource.r4;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.RelatedPerson;
import org.projecthusky.fhir.core.ch.resource.extension.r4.ChCoreCitizenshipExt;

import java.util.ArrayList;
import java.util.List;

/**
 * Base definition of the {@link RelatedPerson} resource for use in Swiss specific use cases.
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-relatedperson")
public class ChCoreRelatedPerson extends RelatedPerson implements ChCoreContactPointCarrier {
    /**
     * Extension for a citizenship.
     */
    @Nullable
    @Child(name = "citizenship", min = 0, max = Child.MAX_UNLIMITED)
    @Extension(url = "http://hl7.org/fhir/StructureDefinition/patient-citizenship", definedLocally = false)
    protected List<ChCoreCitizenshipExt> citizenship;

    @Override
    public ChCoreRelatedPerson copy() {
        ChCoreRelatedPerson dst = new ChCoreRelatedPerson();
        this.copyValues(dst);
        return dst;
    }

    @Override
    public void copyValues(RelatedPerson dst) {
        super.copyValues(dst);
        if (dst instanceof  ChCoreRelatedPerson chCoreRelatedPerson) {
            if (citizenship != null) {
                chCoreRelatedPerson.citizenship = new ArrayList<>();
                for (final var citizenship : citizenship) chCoreRelatedPerson.citizenship.add(citizenship.copy());
            }
        }
    }
}
