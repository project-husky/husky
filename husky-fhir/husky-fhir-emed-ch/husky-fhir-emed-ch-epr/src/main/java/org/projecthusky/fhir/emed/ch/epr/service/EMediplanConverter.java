package org.projecthusky.fhir.emed.ch.epr.service;

import lombok.extern.slf4j.Slf4j;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplan;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.EMediplanPatient;
import org.projecthusky.fhir.emed.ch.epr.resource.pmlc.ChEmedEprDocumentPmlc;

@Slf4j
public class EMediplanConverter {

    private EMediplanConverter() {}

    public static EMediplan toEMediplan(final ChEmedEprDocumentPmlc pmlc) {
        final EMediplan emediplan = new EMediplan();
        emediplan.setPatient(EMediplanPatient.fromEprFhir(pmlc.resolvePatient()));
        return emediplan;
    }
}
