package org.projecthusky.fhir.emed.ch.epr.service.converter.emediplan;

import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.ChMed16AEMediplan;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.chmed16a.ChMed16AMedicament;

public class ChMed16AConverter extends ChMed16ABaseConverter<ChMed16AMedicament, ChMed16AEMediplan<ChMed16AMedicament>> {

    @Override
    protected ChMed16AMedicament getNewMedicamentInstance() {
        return new ChMed16AMedicament();
    }

    @Override
    protected ChMed16AEMediplan<ChMed16AMedicament> getNewEmediplanInstance() {
        return new ChMed16AEMediplan<>();
    }
}
