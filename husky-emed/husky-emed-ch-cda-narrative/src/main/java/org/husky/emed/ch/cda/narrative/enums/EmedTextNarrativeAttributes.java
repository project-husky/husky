/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */

/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */

package org.husky.emed.ch.cda.narrative.enums;

import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Available values for the header of the narrative text table
 * <p>
 * <strong>Deprecated</strong>: to be moved in translation resources.
 *
 * @author Quentin Ligier
 **/
@Deprecated(forRemoval = true)
public enum EmedTextNarrativeAttributes {
    /**
     * <!-- @formatter:off -->
     * <div class="en">Approach site</div>
     * <div class="de">Ort der Verwaltung</div>
     * <div class="fr">Lieu d'administration</div>
     * <div class="it">Luogo di amministrazione</div>
     * <!-- @formatter:on -->
     */
    APPROACH_SITE("approach_site", "-", "Approach site", "Approach site", "Ort der Verwaltung",
            "Lieu d'administration", "Luogo di amministrazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Approach site</div>
     * <div class="de">Ort der Verwaltung</div>
     * <div class="fr">Lieu d'administration</div>
     * <div class="it">Avvicinamento al sito</div>
     * <!-- @formatter:on -->
     */
    APPROACH_SITE_DIS("approach_site_dis", "-", "Approach site", "Approach site",
            "Ort der Verwaltung", "Lieu d'administration", "Avvicinamento al sito"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Approach site</div>
     * <div class="de">Ort der Verwaltung</div>
     * <div class="fr">Lieu d'administration</div>
     * <div class="it">Luogo di amministrazione</div>
     * <!-- @formatter:on -->
     */
    APPROACH_SITE_MTP("approach_site_mtp", "-", "Approach site", "Approach site",
            "Ort der Verwaltung", "Lieu d'administration", "Luogo di amministrazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Approach site</div>
     * <div class="de">Ort der Verwaltung</div>
     * <div class="fr">Lieu d'administration</div>
     * <div class="it">Avvicinamento al sito</div>
     * <!-- @formatter:on -->
     */
    APPROACH_SITE_PADV("approach_site_padv", "-", "Approach site", "Approach site",
            "Ort der Verwaltung", "Lieu d'administration", "Avvicinamento al sito"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Approach site</div>
     * <div class="de">Ort der Verwaltung</div>
     * <div class="fr">Lieu d'administration</div>
     * <div class="it">Avvicinamento al sito</div>
     * <!-- @formatter:on -->
     */
    APPROACH_SITE_PML("approach_site_pml", "-", "Approach site", "Approach site",
            "Ort der Verwaltung", "Lieu d'administration", "Avvicinamento al sito"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Approach site</div>
     * <div class="de">Ort der Verwaltung</div>
     * <div class="fr">Lieu d'administration</div>
     * <div class="it">Avvicinamento al sito</div>
     * <!-- @formatter:on -->
     */
    APPROACH_SITE_PMLC("approach_site_pmlc", "-", "Approach site", "Approach site",
            "Ort der Verwaltung", "Lieu d'administration", "Avvicinamento al sito"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Approach site</div>
     * <div class="de">Ort der Verwaltung</div>
     * <div class="fr">Lieu d'administration</div>
     * <div class="it">Luogo di amministrazione</div>
     * <!-- @formatter:on -->
     */
    APPROACH_SITE_PRE("approach_site_pre", "-", "Approach site", "Approach site",
            "Ort der Verwaltung", "Lieu d'administration", "Luogo di amministrazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Further information</div>
     * <div class="de">Weitere Informationen</div>
     * <div class="fr">Informations complémentaires</div>
     * <div class="it">Ulteriori informazioni</div>
     * <!-- @formatter:on -->
     */
    COMMENT("comment", "-", "Further information", "Further information", "Weitere Informationen",
            "Informations complémentaires", "Ulteriori informazioni"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Further information</div>
     * <div class="de">Weitere Informationen</div>
     * <div class="fr">Informations complémentaires</div>
     * <div class="it">Commento</div>
     * <!-- @formatter:on -->
     */
    COMMENT_DIS("comment_dis", "-", "Further information", "Further information",
            "Weitere Informationen", "Informations complémentaires", "Commento"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Further information</div>
     * <div class="de">Weitere Informationen</div>
     * <div class="fr">Informations complémentaires</div>
     * <div class="it">Ulteriori informazioni</div>
     * <!-- @formatter:on -->
     */
    COMMENT_MTP("comment_mtp", "-", "Further information", "Further information",
            "Weitere Informationen", "Informations complémentaires", "Ulteriori informazioni"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Further information</div>
     * <div class="de">Weitere Informationen</div>
     * <div class="fr">Informations complémentaires</div>
     * <div class="it">Commento</div>
     * <!-- @formatter:on -->
     */
    COMMENT_PADV("comment_padv", "-", "Further information", "Further information",
            "Weitere Informationen", "Informations complémentaires", "Commento"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Further information</div>
     * <div class="de">Weitere Informationen</div>
     * <div class="fr">Informations complémentaires</div>
     * <div class="it">Commento</div>
     * <!-- @formatter:on -->
     */
    COMMENT_PML("comment_pml", "-", "Further information", "Further information",
            "Weitere Informationen", "Informations complémentaires", "Commento"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Further information</div>
     * <div class="de">Weitere Informationen</div>
     * <div class="fr">Informations complémentaires</div>
     * <div class="it">Commento</div>
     * <!-- @formatter:on -->
     */
    COMMENT_PMLC("comment_pmlc", "-", "Further information", "Further information",
            "Weitere Informationen", "Informations complémentaires", "Commento"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Further information</div>
     * <div class="de">Weitere Informationen</div>
     * <div class="fr">Informations complémentaires</div>
     * <div class="it">Ulteriori informazioni</div>
     * <!-- @formatter:on -->
     */
    COMMENT_PRE("comment_pre", "-", "Further information", "Further information",
            "Weitere Informationen", "Informations complémentaires", "Ulteriori informazioni"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Start</div>
     * <div class="de">Start</div>
     * <div class="fr">Début</div>
     * <div class="it">Data a partire da</div>
     * <!-- @formatter:on -->
     */
    DATE_FROM_DIS("date_from_dis", "-", "Start", "Start", "Start", "Début", "Data a partire da"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Start</div>
     * <div class="de">Start</div>
     * <div class="fr">Début</div>
     * <div class="it">Iniziare</div>
     * <!-- @formatter:on -->
     */
    DATE_FROM_MTP("date_from_mtp", "-", "Start", "Start", "Start", "Début", "Iniziare"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Start</div>
     * <div class="de">Start</div>
     * <div class="fr">Début</div>
     * <div class="it">Data a partire da</div>
     * <!-- @formatter:on -->
     */
    DATE_FROM_PADV("date_from_padv", "-", "Start", "Start", "Start", "Début", "Data a partire da"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Start</div>
     * <div class="de">Start</div>
     * <div class="fr">Début</div>
     * <div class="it">Data a partire da</div>
     * <!-- @formatter:on -->
     */
    DATE_FROM_PML("date_from_pml", "-", "Start", "Start", "Start", "Début", "Data a partire da"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Start</div>
     * <div class="de">Start</div>
     * <div class="fr">Début</div>
     * <div class="it">Data a partire da</div>
     * <!-- @formatter:on -->
     */
    DATE_FROM_PMLC("date_from_pmlc", "-", "Start", "Start", "Start", "Début", "Data a partire da"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Start</div>
     * <div class="de">Start</div>
     * <div class="fr">Début</div>
     * <div class="it">Iniziare</div>
     * <!-- @formatter:on -->
     */
    DATE_FROM_PRE("date_from_pre", "-", "Start", "Start", "Start", "Début", "Iniziare"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Start</div>
     * <div class="de">Start</div>
     * <div class="fr">Début</div>
     * <div class="it">Iniziare</div>
     * <!-- @formatter:on -->
     */
    DATE_FROM_TO("date_from_to", "-", "Start / End", "Start / End", "Start / Ende", "Début / Fin",
            "Iniziare / Fine"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Start</div>
     * <div class="de">Start</div>
     * <div class="fr">Début</div>
     * <div class="it">Iniziare</div>
     * <!-- @formatter:on -->
     */
    DATE_FROM_TO_DIS("date_from_to_dis", "-", "Start / End", "Start / End", "Start / Ende",
            "Début / Fin", "Iniziare / Fine"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Start</div>
     * <div class="de">Start</div>
     * <div class="fr">Début</div>
     * <div class="it">Iniziare</div>
     * <!-- @formatter:on -->
     */
    DATE_FROM_TO_MTP("date_from_to_mtp", "-", "Start / End", "Start / End", "Start / Ende",
            "Début / Fin", "Iniziare / Fine"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Start</div>
     * <div class="de">Start</div>
     * <div class="fr">Début</div>
     * <div class="it">Iniziare</div>
     * <!-- @formatter:on -->
     */
    DATE_FROM_TO_PADV("date_from_to_padv", "-", "Start / End", "Start / End", "Start / Ende",
            "Début / Fin", "Iniziare / Fine"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Start</div>
     * <div class="de">Start</div>
     * <div class="fr">Début</div>
     * <div class="it">Iniziare</div>
     * <!-- @formatter:on -->
     */
    DATE_FROM_TO_PMLC("date_from_to_pmlc", "-", "Start / End", "Start / End", "Start / Ende",
            "Début / Fin", "Iniziare / Fine"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Start</div>
     * <div class="de">Start</div>
     * <div class="fr">Début</div>
     * <div class="it">Iniziare</div>
     * <!-- @formatter:on -->
     */
    DATE_FROM_TO_PRE("date_from_to_pre", "-", "Start / End", "Start / End", "Start / Ende",
            "Début / Fin", "Iniziare / Fine"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">End</div>
     * <div class="de">Ende</div>
     * <div class="fr">Fin</div>
     * <div class="it">Data a</div>
     * <!-- @formatter:on -->
     */
    DATE_TO_DIS("date_to_dis", "-", "End", "End", "Ende", "Fin", "Data a"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">End</div>
     * <div class="de">Ende</div>
     * <div class="fr">Fin</div>
     * <div class="it">Fine</div>
     * <!-- @formatter:on -->
     */
    DATE_TO_MTP("date_to_mtp", "-", "End", "End", "Ende", "Fin", "Fine"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">End</div>
     * <div class="de">Ende</div>
     * <div class="fr">Fin</div>
     * <div class="it">Data a</div>
     * <!-- @formatter:on -->
     */
    DATE_TO_PADV("date_to_padv", "-", "End", "End", "Ende", "Fin", "Data a"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">End</div>
     * <div class="de">Ende</div>
     * <div class="fr">Fin</div>
     * <div class="it">Data a</div>
     * <!-- @formatter:on -->
     */
    DATE_TO_PML("date_to_pml", "-", "End", "End", "Ende", "Fin", "Data a"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">End</div>
     * <div class="de">Ende</div>
     * <div class="fr">Fin</div>
     * <div class="it">Data a</div>
     * <!-- @formatter:on -->
     */
    DATE_TO_PMLC("date_to_pmlc", "-", "End", "End", "Ende", "Fin", "Data a"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">End</div>
     * <div class="de">Ende</div>
     * <div class="fr">Fin</div>
     * <div class="it">Fine</div>
     * <!-- @formatter:on -->
     */
    DATE_TO_PRE("date_to_pre", "-", "End", "End", "Ende", "Fin", "Fine"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Planned dispense amount</div>
     * <div class="de">Geplante Anzahl von Paketen</div>
     * <div class="fr">Nombre d'emballages prévus</div>
     * <div class="it">Numero previsto di pacchetti</div>
     * <!-- @formatter:on -->
     */
    DISPENSE_AMOUNT("dispense_amount", "-", "Planned dispense amount", "Planned dispense amount",
            "Geplante Anzahl von Paketen", "Nombre d'emballages prévus",
            "Numero previsto di pacchetti"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Dispense amount</div>
     * <div class="de">Anzahl der Pakete</div>
     * <div class="fr">Nombre d'emballages remis</div>
     * <div class="it">Importo dell'erogazione</div>
     * <!-- @formatter:on -->
     */
    DISPENSE_AMOUNT_DIS("dispense_amount_dis", "-", "Dispense amount", "Dispense amount",
            "Anzahl der Pakete", "Nombre d'emballages remis", "Importo dell'erogazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Planned dispense amount</div>
     * <div class="de">Geplante Anzahl von Paketen</div>
     * <div class="fr">Nombre d'emballages prévus</div>
     * <div class="it">Numero previsto di pacchetti</div>
     * <!-- @formatter:on -->
     */
    DISPENSE_AMOUNT_MTP("dispense_amount_mtp", "-", "Planned dispense amount",
            "Planned dispense amount", "Geplante Anzahl von Paketen", "Nombre d'emballages prévus",
            "Numero previsto di pacchetti"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Dispense amount</div>
     * <div class="de">Anzahl der Pakete</div>
     * <div class="fr">Nombre d'emballages</div>
     * <div class="it">Importo dell'erogazione</div>
     * <!-- @formatter:on -->
     */
    DISPENSE_AMOUNT_PADV("dispense_amount_padv", "-", "Dispense amount", "Dispense amount",
            "Anzahl der Pakete", "Nombre d'emballages", "Importo dell'erogazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Dispense amount</div>
     * <div class="de">Anzahl der Pakete</div>
     * <div class="fr">Nombre d'emballages</div>
     * <div class="it">Importo dell'erogazione</div>
     * <!-- @formatter:on -->
     */
    DISPENSE_AMOUNT_PML("dispense_amount_pml", "-", "Dispense amount", "Dispense amount",
            "Anzahl der Pakete", "Nombre d'emballages", "Importo dell'erogazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Dispense amount</div>
     * <div class="de">Anzahl der Pakete</div>
     * <div class="fr">Nombre d'emballages</div>
     * <div class="it">Importo dell'erogazione</div>
     * <!-- @formatter:on -->
     */
    DISPENSE_AMOUNT_PMLC("dispense_amount_pmlc", "-", "Dispense amount", "Dispense amount",
            "Anzahl der Pakete", "Nombre d'emballages", "Importo dell'erogazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Dispense amount</div>
     * <div class="de">Anzahl der Pakete</div>
     * <div class="fr">Nombre d'emballages</div>
     * <div class="it">Numero di pacchetti</div>
     * <!-- @formatter:on -->
     */
    DISPENSE_AMOUNT_PRE("dispense_amount_pre", "-", "Dispense amount", "Dispense amount",
            "Anzahl der Pakete", "Nombre d'emballages", "Numero di pacchetti"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Presentation</div>
     * <div class="de">Präsentation</div>
     * <div class="fr">Présentation</div>
     * <div class="it">Presentazione</div>
     * <!-- @formatter:on -->
     */
    DOSE_FORM("dose_form", "-", "Presentation", "Presentation", "Präsentation", "Présentation",
            "Presentazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Presentation</div>
     * <div class="de">Präsentation</div>
     * <div class="fr">Présentation</div>
     * <div class="it">Forma di dosaggio</div>
     * <!-- @formatter:on -->
     */
    DOSE_FORM_DIS("dose_form_dis", "-", "Presentation", "Presentation", "Präsentation",
            "Présentation", "Forma di dosaggio"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Presentation</div>
     * <div class="de">Präsentation</div>
     * <div class="fr">Présentation</div>
     * <div class="it">Presentazione</div>
     * <!-- @formatter:on -->
     */
    DOSE_FORM_MTP("dose_form_mtp", "-", "Presentation", "Presentation", "Präsentation",
            "Présentation", "Presentazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Presentation</div>
     * <div class="de">Präsentation</div>
     * <div class="fr">Présentation</div>
     * <div class="it">Forma di dosaggio</div>
     * <!-- @formatter:on -->
     */
    DOSE_FORM_PADV("dose_form_padv", "-", "Presentation", "Presentation", "Präsentation",
            "Présentation", "Forma di dosaggio"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Presentation</div>
     * <div class="de">Präsentation</div>
     * <div class="fr">Présentation</div>
     * <div class="it">Forma di dosaggio</div>
     * <!-- @formatter:on -->
     */
    DOSE_FORM_PML("dose_form_pml", "-", "Presentation", "Presentation", "Präsentation",
            "Présentation", "Forma di dosaggio"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Presentation</div>
     * <div class="de">Präsentation</div>
     * <div class="fr">Présentation</div>
     * <div class="it">Forma di dosaggio</div>
     * <!-- @formatter:on -->
     */
    DOSE_FORM_PMLC("dose_form_pmlc", "-", "Presentation", "Presentation", "Präsentation",
            "Présentation", "Forma di dosaggio"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Presentation</div>
     * <div class="de">Präsentation</div>
     * <div class="fr">Présentation</div>
     * <div class="it">Presentazione</div>
     * <!-- @formatter:on -->
     */
    DOSE_FORM_PRE("dose_form_pre", "-", "Presentation", "Presentation", "Präsentation",
            "Présentation", "Presentazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Unit Dose</div>
     * <div class="de">Einheit Dosis</div>
     * <div class="fr">Dose unitaire</div>
     * <div class="it">Unità Dose</div>
     * <!-- @formatter:on -->
     */
    DOSE_QUANTITY("dose_quantity", "-", "Unit Dose", "Unit Dose", "Einheit Dosis", "Dose unitaire",
            "Unità Dose"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Unit Dose</div>
     * <div class="de">Einheit Dosis</div>
     * <div class="fr">Dose unitaire</div>
     * <div class="it">Quantità di dose</div>
     * <!-- @formatter:on -->
     */
    DOSE_QUANTITY_DIS("dose_quantity_dis", "-", "Unit Dose", "Unit Dose", "Einheit Dosis",
            "Dose unitaire", "Quantità di dose"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Unit Dose</div>
     * <div class="de">Einheit Dosis</div>
     * <div class="fr">Dose unitaire</div>
     * <div class="it">Unità Dose</div>
     * <!-- @formatter:on -->
     */
    DOSE_QUANTITY_MTP("dose_quantity_mtp", "-", "Unit Dose", "Unit Dose", "Einheit Dosis",
            "Dose unitaire", "Unità Dose"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Unit Dose</div>
     * <div class="de">Einheit Dosis</div>
     * <div class="fr">Dose unitaire</div>
     * <div class="it">Quantità di dose</div>
     * <!-- @formatter:on -->
     */
    DOSE_QUANTITY_PADV("dose_quantity_padv", "-", "Unit Dose", "Unit Dose", "Einheit Dosis",
            "Dose unitaire", "Quantità di dose"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Unit Dose</div>
     * <div class="de">Einheit Dosis</div>
     * <div class="fr">Dose unitaire</div>
     * <div class="it">Quantità di dose</div>
     * <!-- @formatter:on -->
     */
    DOSE_QUANTITY_PML("dose_quantity_pml", "-", "Unit Dose", "Unit Dose", "Einheit Dosis",
            "Dose unitaire", "Quantità di dose"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Unit Dose</div>
     * <div class="de">Einheit Dosis</div>
     * <div class="fr">Dose unitaire</div>
     * <div class="it">Quantità di dose</div>
     * <!-- @formatter:on -->
     */
    DOSE_QUANTITY_PMLC("dose_quantity_pmlc", "-", "Unit Dose", "Unit Dose", "Einheit Dosis",
            "Dose unitaire", "Quantità di dose"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Unit Dose</div>
     * <div class="de">Einheit Dosis</div>
     * <div class="fr">Dose unitaire</div>
     * <div class="it">Unità Dose</div>
     * <!-- @formatter:on -->
     */
    DOSE_QUANTITY_PRE("dose_quantity_pre", "-", "Unit Dose", "Unit Dose", "Einheit Dosis",
            "Dose unitaire", "Unità Dose"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Dosage</div>
     * <div class="de">Dosierung</div>
     * <div class="fr">Posologie</div>
     * <div class="it">Dosaggio</div>
     * <!-- @formatter:on -->
     */
    FREQUENCY("frequency", "-", "Dosage", "Dosage", "Dosierung", "Posologie", "Dosaggio"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Dosage</div>
     * <div class="de">Dosierung</div>
     * <div class="fr">Posologie</div>
     * <div class="it">Frequenza</div>
     * <!-- @formatter:on -->
     */
    FREQUENCY_DIS("frequency_dis", "-", "Dosage", "Dosage", "Dosierung", "Posologie", "Frequenza"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Dosage</div>
     * <div class="de">Dosierung</div>
     * <div class="fr">Posologie</div>
     * <div class="it">Dosaggio</div>
     * <!-- @formatter:on -->
     */
    FREQUENCY_MTP("frequency_mtp", "-", "Dosage", "Dosage", "Dosierung", "Posologie", "Dosaggio"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Dosage</div>
     * <div class="de">Dosierung</div>
     * <div class="fr">Posologie</div>
     * <div class="it">Frequenza</div>
     * <!-- @formatter:on -->
     */
    FREQUENCY_PADV("frequency_padv", "-", "Dosage", "Dosage", "Dosierung", "Posologie",
            "Frequenza"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Dosage</div>
     * <div class="de">Dosierung</div>
     * <div class="fr">Posologie</div>
     * <div class="it">Frequenza</div>
     * <!-- @formatter:on -->
     */
    FREQUENCY_PML("frequency_pml", "-", "Dosage", "Dosage", "Dosierung", "Posologie", "Frequenza"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Dosage</div>
     * <div class="de">Dosierung</div>
     * <div class="fr">Posologie</div>
     * <div class="it">Frequenza</div>
     * <!-- @formatter:on -->
     */
    FREQUENCY_PMLC("frequency_pmlc", "-", "Dosage", "Dosage", "Dosierung", "Posologie", "Frequenza"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Dosage</div>
     * <div class="de">Dosierung</div>
     * <div class="fr">Posologie</div>
     * <div class="it">Dosaggio</div>
     * <!-- @formatter:on -->
     */
    FREQUENCY_PRE("frequency_pre", "-", "Dosage", "Dosage", "Dosierung", "Posologie", "Dosaggio"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Fulfilment instructions</div>
     * <div class="de">Informationen für Fachleute</div>
     * <div class="fr">Informations pour les professionnels</div>
     * <div class="it">Informazioni per i professionisti</div>
     * <!-- @formatter:on -->
     */
    FULFILMENT_INSTRUCTIONS("fulfilment_instructions", "-", "Fulfilment instructions",
            "Fulfilment instructions", "Informationen für Fachleute",
            "Informations pour les professionnels", "Informazioni per i professionisti"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Fulfilment instructions</div>
     * <div class="de">Informationen für Fachleute</div>
     * <div class="fr">Informations pour les professionnels</div>
     * <div class="it">Istruzioni per l'adempimento</div>
     * <!-- @formatter:on -->
     */
    FULFILMENT_INSTRUCTIONS_DIS("fulfilment_instructions_dis", "-", "Fulfilment instructions",
            "Fulfilment instructions", "Informationen für Fachleute",
            "Informations pour les professionnels", "Istruzioni per l'adempimento"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Fulfilment instructions</div>
     * <div class="de">Informationen für Fachleute</div>
     * <div class="fr">Informations pour les professionnels</div>
     * <div class="it">Informazioni per i professionisti</div>
     * <!-- @formatter:on -->
     */
    FULFILMENT_INSTRUCTIONS_MTP("fulfilment_instructions_mtp", "-", "Fulfilment instructions",
            "Fulfilment instructions", "Informationen für Fachleute",
            "Informations pour les professionnels", "Informazioni per i professionisti"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Fulfilment instructions</div>
     * <div class="de">Informationen für Fachleute</div>
     * <div class="fr">Informations pour les professionnels</div>
     * <div class="it">Istruzioni per l'adempimento</div>
     * <!-- @formatter:on -->
     */
    FULFILMENT_INSTRUCTIONS_PADV("fulfilment_instructions_padv", "-", "Fulfilment instructions",
            "Fulfilment instructions", "Informationen für Fachleute",
            "Informations pour les professionnels", "Istruzioni per l'adempimento"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Fulfilment instructions</div>
     * <div class="de">Informationen für Fachleute</div>
     * <div class="fr">Informations pour les professionnels</div>
     * <div class="it">Istruzioni per l'adempimento</div>
     * <!-- @formatter:on -->
     */
    FULFILMENT_INSTRUCTIONS_PML("fulfilment_instructions_pml", "-", "Fulfilment instructions",
            "Fulfilment instructions", "Informationen für Fachleute",
            "Informations pour les professionnels", "Istruzioni per l'adempimento"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Fulfilment instructions</div>
     * <div class="de">Informationen für Fachleute</div>
     * <div class="fr">Informations pour les professionnels</div>
     * <div class="it">Istruzioni per l'adempimento</div>
     * <!-- @formatter:on -->
     */
    FULFILMENT_INSTRUCTIONS_PMLC("fulfilment_instructions_pmlc", "-", "Fulfilment instructions",
            "Fulfilment instructions", "Informationen für Fachleute",
            "Informations pour les professionnels", "Istruzioni per l'adempimento"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Fulfilment instructions</div>
     * <div class="de">Informationen für Fachleute</div>
     * <div class="fr">Informations pour les professionnels</div>
     * <div class="it">Informazioni per i professionisti</div>
     * <!-- @formatter:on -->
     */
    FULFILMENT_INSTRUCTIONS_PRE("fulfilment_instructions_pre", "-", "Fulfilment instructions",
            "Fulfilment instructions", "Informationen für Fachleute",
            "Informations pour les professionnels", "Informazioni per i professionisti"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Code (GTIN)</div>
     * <div class="de">Code (GTIN)</div>
     * <div class="fr">Code (GTIN)</div>
     * <div class="it">Codice (GTIN)</div>
     * <!-- @formatter:on -->
     */
    GTIN("gtin", "-", "Code (GTIN)", "Code (GTIN)", "Code (GTIN)", "Code (GTIN)", "Codice (GTIN)"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Code (GTIN)</div>
     * <div class="de">Code (GTIN)</div>
     * <div class="fr">Code (GTIN)</div>
     * <div class="it">GTIN</div>
     * <!-- @formatter:on -->
     */
    GTIN_DIS("gtin_dis", "-", "Code (GTIN)", "Code (GTIN)", "Code (GTIN)", "Code (GTIN)", "GTIN"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Code (GTIN)</div>
     * <div class="de">Code (GTIN)</div>
     * <div class="fr">Code (GTIN)</div>
     * <div class="it">Codice (GTIN)</div>
     * <!-- @formatter:on -->
     */
    GTIN_MTP("gtin_mtp", "-", "Code (GTIN)", "Code (GTIN)", "Code (GTIN)", "Code (GTIN)",
            "Codice (GTIN)"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Code (GTIN)</div>
     * <div class="de">Code (GTIN)</div>
     * <div class="fr">Code (GTIN)</div>
     * <div class="it">GTIN</div>
     * <!-- @formatter:on -->
     */
    GTIN_PADV("gtin_padv", "-", "Code (GTIN)", "Code (GTIN)", "Code (GTIN)", "Code (GTIN)", "GTIN"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Code (GTIN)</div>
     * <div class="de">Code (GTIN)</div>
     * <div class="fr">Code (GTIN)</div>
     * <div class="it">GTIN</div>
     * <!-- @formatter:on -->
     */
    GTIN_PML("gtin_pml", "-", "Code (GTIN)", "Code (GTIN)", "Code (GTIN)", "Code (GTIN)", "GTIN"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Code (GTIN)</div>
     * <div class="de">Code (GTIN)</div>
     * <div class="fr">Code (GTIN)</div>
     * <div class="it">GTIN</div>
     * <!-- @formatter:on -->
     */
    GTIN_PMLC("gtin_pmlc", "-", "Code (GTIN)", "Code (GTIN)", "Code (GTIN)", "Code (GTIN)", "GTIN"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Code (GTIN)</div>
     * <div class="de">Code (GTIN)</div>
     * <div class="fr">Code (GTIN)</div>
     * <div class="it">Codice (GTIN)</div>
     * <!-- @formatter:on -->
     */
    GTIN_PRE("gtin_pre", "-", "Code (GTIN)", "Code (GTIN)", "Code (GTIN)", "Code (GTIN)",
            "Codice (GTIN)"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Active ingredients</div>
     * <div class="de">Aktive Inhaltsstoffe</div>
     * <div class="fr">Principes actifs</div>
     * <div class="it">Principi attivi</div>
     * <!-- @formatter:on -->
     */
    INGREDIENTS("ingredients", "-", "Active ingredients", "Active ingredients",
            "Aktive Inhaltsstoffe", "Principes actifs", "Principi attivi"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Active ingredients</div>
     * <div class="de">Aktive Inhaltsstoffe</div>
     * <div class="fr">Principes actifs</div>
     * <div class="it">Ingredienti</div>
     * <!-- @formatter:on -->
     */
    INGREDIENTS_DIS("ingredients_dis", "-", "Active ingredients", "Active ingredients",
            "Aktive Inhaltsstoffe", "Principes actifs", "Ingredienti"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Active ingredients</div>
     * <div class="de">Aktive Inhaltsstoffe</div>
     * <div class="fr">Principes actifs</div>
     * <div class="it">Principi attivi</div>
     * <!-- @formatter:on -->
     */
    INGREDIENTS_MTP("ingredients_mtp", "-", "Active ingredients", "Active ingredients",
            "Aktive Inhaltsstoffe", "Principes actifs", "Principi attivi"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Active ingredients</div>
     * <div class="de">Aktive Inhaltsstoffe</div>
     * <div class="fr">Principes actifs</div>
     * <div class="it">Ingredienti</div>
     * <!-- @formatter:on -->
     */
    INGREDIENTS_PADV("ingredients_padv", "-", "Active ingredients", "Active ingredients",
            "Aktive Inhaltsstoffe", "Principes actifs", "Ingredienti"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Active ingredients</div>
     * <div class="de">Aktive Inhaltsstoffe</div>
     * <div class="fr">Principes actifs</div>
     * <div class="it">Ingredienti</div>
     * <!-- @formatter:on -->
     */
    INGREDIENTS_PML("ingredients_pml", "-", "Active ingredients", "Active ingredients",
            "Aktive Inhaltsstoffe", "Principes actifs", "Ingredienti"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Active ingredients</div>
     * <div class="de">Aktive Inhaltsstoffe</div>
     * <div class="fr">Principes actifs</div>
     * <div class="it">Ingredienti</div>
     * <!-- @formatter:on -->
     */
    INGREDIENTS_PMLC("ingredients_pmlc", "-", "Active ingredients", "Active ingredients",
            "Aktive Inhaltsstoffe", "Principes actifs", "Ingredienti"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Active ingredients</div>
     * <div class="de">Aktive Inhaltsstoffe</div>
     * <div class="fr">Principes actifs</div>
     * <div class="it">Principi attivi</div>
     * <!-- @formatter:on -->
     */
    INGREDIENTS_PRE("ingredients_pre", "-", "Active ingredients", "Active ingredients",
            "Aktive Inhaltsstoffe", "Principes actifs", "Principi attivi"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Batch number</div>
     * <div class="de">Los-Nummer</div>
     * <div class="fr">Numéro de lot</div>
     * <div class="it">Numero di lotto</div>
     * <!-- @formatter:on -->
     */
    LOT_NUMBER("lot_number", "-", "Batch number", "Batch number", "Los-Nummer", "Numéro de lot",
            "Numero di lotto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Batch number</div>
     * <div class="de">Los-Nummer</div>
     * <div class="fr">Numéro de lot</div>
     * <div class="it">Numero di lotto</div>
     * <!-- @formatter:on -->
     */
    LOT_NUMBER_DIS("lot_number_dis", "-", "Batch number", "Batch number", "Los-Nummer",
            "Numéro de lot", "Numero di lotto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Batch number</div>
     * <div class="de">Los-Nummer</div>
     * <div class="fr">Numéro de lot</div>
     * <div class="it">Numero di lotto</div>
     * <!-- @formatter:on -->
     */
    LOT_NUMBER_MTP("lot_number_mtp", "-", "Batch number", "Batch number", "Los-Nummer",
            "Numéro de lot", "Numero di lotto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Batch number</div>
     * <div class="de">Los-Nummer</div>
     * <div class="fr">Numéro de lot</div>
     * <div class="it">Numero di lotto</div>
     * <!-- @formatter:on -->
     */
    LOT_NUMBER_PADV("lot_number_padv", "-", "Batch number", "Batch number", "Los-Nummer",
            "Numéro de lot", "Numero di lotto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Batch number</div>
     * <div class="de">Los-Nummer</div>
     * <div class="fr">Numéro de lot</div>
     * <div class="it">Numero di lotto</div>
     * <!-- @formatter:on -->
     */
    LOT_NUMBER_PML("lot_number_pml", "-", "Batch number", "Batch number", "Los-Nummer",
            "Numéro de lot", "Numero di lotto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Batch number</div>
     * <div class="de">Los-Nummer</div>
     * <div class="fr">Numéro de lot</div>
     * <div class="it">Numero di lotto</div>
     * <!-- @formatter:on -->
     */
    LOT_NUMBER_PMLC("lot_number_pmlc", "-", "Batch number", "Batch number", "Los-Nummer",
            "Numéro de lot", "Numero di lotto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Batch number</div>
     * <div class="de">Los-Nummer</div>
     * <div class="fr">Numéro de lot</div>
     * <div class="it">Numero di lotto</div>
     * <!-- @formatter:on -->
     */
    LOT_NUMBER_PRE("lot_number_pre", "-", "Batch number", "Batch number", "Los-Nummer",
            "Numéro de lot", "Numero di lotto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Package size</div>
     * <div class="de">Packungsgröße</div>
     * <div class="fr">Taille de l'emballage</div>
     * <div class="it">Dimensione del pacchetto</div>
     * <!-- @formatter:on -->
     */
    PACKAGE_CAPACITY("package_capacity", "-", "Package size", "Package size", "Packungsgröße",
            "Taille de l'emballage", "Dimensione del pacchetto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Package size</div>
     * <div class="de">Packungsgröße</div>
     * <div class="fr">Taille de l'emballage</div>
     * <div class="it">Capacità del pacchetto</div>
     * <!-- @formatter:on -->
     */
    PACKAGE_CAPACITY_DIS("package_capacity_dis", "-", "Package size", "Package size",
            "Packungsgröße", "Taille de l'emballage", "Capacità del pacchetto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Package size</div>
     * <div class="de">Packungsgröße</div>
     * <div class="fr">Taille de l'emballage</div>
     * <div class="it">Dimensione del pacchetto</div>
     * <!-- @formatter:on -->
     */
    PACKAGE_CAPACITY_MTP("package_capacity_mtp", "-", "Package size", "Package size",
            "Packungsgröße", "Taille de l'emballage", "Dimensione del pacchetto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Package size</div>
     * <div class="de">Packungsgröße</div>
     * <div class="fr">Taille de l'emballage</div>
     * <div class="it">Capacità del pacchetto</div>
     * <!-- @formatter:on -->
     */
    PACKAGE_CAPACITY_PADV("package_capacity_padv", "-", "Package size", "Package size",
            "Packungsgröße", "Taille de l'emballage", "Capacità del pacchetto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Package size</div>
     * <div class="de">Packungsgröße</div>
     * <div class="fr">Taille de l'emballage</div>
     * <div class="it">Capacità del pacchetto</div>
     * <!-- @formatter:on -->
     */
    PACKAGE_CAPACITY_PML("package_capacity_pml", "-", "Package size", "Package size",
            "Packungsgröße", "Taille de l'emballage", "Capacità del pacchetto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Package size</div>
     * <div class="de">Packungsgröße</div>
     * <div class="fr">Taille de l'emballage</div>
     * <div class="it">Capacità del pacchetto</div>
     * <!-- @formatter:on -->
     */
    PACKAGE_CAPACITY_PMLC("package_capacity_pmlc", "-", "Package size", "Package size",
            "Packungsgröße", "Taille de l'emballage", "Capacità del pacchetto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Package size</div>
     * <div class="de">Packungsgröße</div>
     * <div class="fr">Taille de l'emballage</div>
     * <div class="it">Dimensione del pacchetto</div>
     * <!-- @formatter:on -->
     */
    PACKAGE_CAPACITY_PRE("package_capacity_pre", "-", "Package size", "Package size",
            "Packungsgröße", "Taille de l'emballage", "Dimensione del pacchetto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Drug Name</div>
     * <div class="de">Name des Medikaments</div>
     * <div class="fr">Nom du médicament</div>
     * <div class="it">Nome del farmaco</div>
     * <!-- @formatter:on -->
     */
    PACKAGE_NAME("package_name", "-", "Drug Name", "Drug Name", "Name des Medikaments",
            "Nom du médicament", "Nome del farmaco"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Drug Name</div>
     * <div class="de">Name des Medikaments</div>
     * <div class="fr">Nom du médicament</div>
     * <div class="it">Nome del pacchetto</div>
     * <!-- @formatter:on -->
     */
    PACKAGE_NAME_DIS("package_name_dis", "-", "Drug Name", "Drug Name", "Name des Medikaments",
            "Nom du médicament", "Nome del pacchetto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Drug Name</div>
     * <div class="de">Name des Medikaments</div>
     * <div class="fr">Nom du médicament</div>
     * <div class="it">Nome del farmaco</div>
     * <!-- @formatter:on -->
     */
    PACKAGE_NAME_MTP("package_name_mtp", "-", "Drug Name", "Drug Name", "Name des Medikaments",
            "Nom du médicament", "Nome del farmaco"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Drug Name</div>
     * <div class="de">Name des Medikaments</div>
     * <div class="fr">Nom du médicament</div>
     * <div class="it">Nome del pacchetto</div>
     * <!-- @formatter:on -->
     */
    PACKAGE_NAME_PADV("package_name_padv", "-", "Drug Name", "Drug Name", "Name des Medikaments",
            "Nom du médicament", "Nome del pacchetto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Drug Name</div>
     * <div class="de">Name des Medikaments</div>
     * <div class="fr">Nom du médicament</div>
     * <div class="it">Nome del pacchetto</div>
     * <!-- @formatter:on -->
     */
    PACKAGE_NAME_PML("package_name_pml", "-", "Drug Name", "Drug Name", "Name des Medikaments",
            "Nom du médicament", "Nome del pacchetto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Drug Name</div>
     * <div class="de">Name des Medikaments</div>
     * <div class="fr">Nom du médicament</div>
     * <div class="it">Nome del pacchetto</div>
     * <!-- @formatter:on -->
     */
    PACKAGE_NAME_PMLC("package_name_pmlc", "-", "Drug Name", "Drug Name", "Name des Medikaments",
            "Nom du médicament", "Nome del pacchetto"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Drug Name</div>
     * <div class="de">Name des Medikaments</div>
     * <div class="fr">Nom du médicament</div>
     * <div class="it">Nome del farmaco</div>
     * <!-- @formatter:on -->
     */
    PACKAGE_NAME_PRE("package_name_pre", "-", "Drug Name", "Drug Name", "Name des Medikaments",
            "Nom du médicament", "Nome del farmaco"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Patient's instructions</div>
     * <div class="de">Anweisungen für den Patienten</div>
     * <div class="fr">Instructions pour le patient</div>
     * <div class="it">Istruzioni per il paziente</div>
     * <!-- @formatter:on -->
     */
    PATIENT_INSTRUCTIONS("patient_instructions", "-", "Patient's instructions",
            "Patient's instructions", "Anweisungen für den Patienten",
            "Instructions pour le patient", "Istruzioni per il paziente"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Patient's instructions</div>
     * <div class="de">Anweisungen für den Patienten</div>
     * <div class="fr">Instructions pour le patient</div>
     * <div class="it">Istruzioni per il paziente</div>
     * <!-- @formatter:on -->
     */
    PATIENT_INSTRUCTIONS_DIS("patient_instructions_dis", "-", "Patient's instructions",
            "Patient's instructions", "Anweisungen für den Patienten",
            "Instructions pour le patient", "Istruzioni per il paziente"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Patient's instructions</div>
     * <div class="de">Anweisungen für den Patienten</div>
     * <div class="fr">Instructions pour le patient</div>
     * <div class="it">Istruzioni per il paziente</div>
     * <!-- @formatter:on -->
     */
    PATIENT_INSTRUCTIONS_MTP("patient_instructions_mtp", "-", "Patient's instructions",
            "Patient's instructions", "Anweisungen für den Patienten",
            "Instructions pour le patient", "Istruzioni per il paziente"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Patient's instructions</div>
     * <div class="de">Anweisungen für den Patienten</div>
     * <div class="fr">Instructions pour le patient</div>
     * <div class="it">Istruzioni per il paziente</div>
     * <!-- @formatter:on -->
     */
    PATIENT_INSTRUCTIONS_PADV("patient_instructions_padv", "-", "Patient's instructions",
            "Patient's instructions", "Anweisungen für den Patienten",
            "Instructions pour le patient", "Istruzioni per il paziente"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Patient's instructions</div>
     * <div class="de">Anweisungen für den Patienten</div>
     * <div class="fr">Instructions pour le patient</div>
     * <div class="it">Istruzioni per il paziente</div>
     * <!-- @formatter:on -->
     */
    PATIENT_INSTRUCTIONS_PML("patient_instructions_pml", "-", "Patient's instructions",
            "Patient's instructions", "Anweisungen für den Patienten",
            "Instructions pour le patient", "Istruzioni per il paziente"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Patient's instructions</div>
     * <div class="de">Anweisungen für den Patienten</div>
     * <div class="fr">Instructions pour le patient</div>
     * <div class="it">Istruzioni per il paziente</div>
     * <!-- @formatter:on -->
     */
    PATIENT_INSTRUCTIONS_PMLC("patient_instructions_pmlc", "-", "Patient's instructions",
            "Patient's instructions", "Anweisungen für den Patienten",
            "Instructions pour le patient", "Istruzioni per il paziente"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Patient's instructions</div>
     * <div class="de">Anweisungen für den Patienten</div>
     * <div class="fr">Instructions pour le patient</div>
     * <div class="it">Istruzioni per il paziente</div>
     * <!-- @formatter:on -->
     */
    PATIENT_INSTRUCTIONS_PRE("patient_instructions_pre", "-", "Patient's instructions",
            "Patient's instructions", "Anweisungen für den Patienten",
            "Instructions pour le patient", "Istruzioni per il paziente"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Rate</div>
     * <div class="de">Durchflussrate</div>
     * <div class="fr">Débit</div>
     * <div class="it">Addebito</div>
     * <!-- @formatter:on -->
     */
    RATE_QUANTITY("rate_quantity", "-", "Rate", "Rate", "Durchflussrate", "Débit", "Addebito"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Rate</div>
     * <div class="de">Durchflussrate</div>
     * <div class="fr">Débit</div>
     * <div class="it">Tasso di quantità</div>
     * <!-- @formatter:on -->
     */
    RATE_QUANTITY_DIS("rate_quantity_dis", "-", "Rate", "Rate", "Durchflussrate", "Débit",
            "Tasso di quantità"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Rate</div>
     * <div class="de">Durchflussrate</div>
     * <div class="fr">Débit</div>
     * <div class="it">Addebito</div>
     * <!-- @formatter:on -->
     */
    RATE_QUANTITY_MTP("rate_quantity_mtp", "-", "Rate", "Rate", "Durchflussrate", "Débit",
            "Addebito"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Rate</div>
     * <div class="de">Durchflussrate</div>
     * <div class="fr">Débit</div>
     * <div class="it">Tasso di quantità</div>
     * <!-- @formatter:on -->
     */
    RATE_QUANTITY_PADV("rate_quantity_padv", "-", "Rate", "Rate", "Durchflussrate", "Débit",
            "Tasso di quantità"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Rate</div>
     * <div class="de">Durchflussrate</div>
     * <div class="fr">Débit</div>
     * <div class="it">Tasso di quantità</div>
     * <!-- @formatter:on -->
     */
    RATE_QUANTITY_PML("rate_quantity_pml", "-", "Rate", "Rate", "Durchflussrate", "Débit",
            "Tasso di quantità"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Rate</div>
     * <div class="de">Durchflussrate</div>
     * <div class="fr">Débit</div>
     * <div class="it">Tasso di quantità</div>
     * <!-- @formatter:on -->
     */
    RATE_QUANTITY_PMLC("rate_quantity_pmlc", "-", "Rate", "Rate", "Durchflussrate", "Débit",
            "Tasso di quantità"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Rate</div>
     * <div class="de">Durchflussrate</div>
     * <div class="fr">Débit</div>
     * <div class="it">Addebito</div>
     * <!-- @formatter:on -->
     */
    RATE_QUANTITY_PRE("rate_quantity_pre", "-", "Rate", "Rate", "Durchflussrate", "Débit",
            "Addebito"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Reason for treatment</div>
     * <div class="de">Grund für die Behandlung</div>
     * <div class="fr">Raison du traitement</div>
     * <div class="it">Motivo del trattamento</div>
     * <!-- @formatter:on -->
     */
    REASON("reason", "-", "Reason for treatment", "Reason for treatment",
            "Grund für die Behandlung", "Raison du traitement", "Motivo del trattamento"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Reason for treatment</div>
     * <div class="de">Grund für die Behandlung</div>
     * <div class="fr">Raison du traitement</div>
     * <div class="it">Motivo</div>
     * <!-- @formatter:on -->
     */
    REASON_DIS("reason_dis", "-", "Reason for treatment", "Reason for treatment",
            "Grund für die Behandlung", "Raison du traitement", "Motivo"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Reason for treatment</div>
     * <div class="de">Grund für die Behandlung</div>
     * <div class="fr">Raison du traitement</div>
     * <div class="it">Motivo del trattamento</div>
     * <!-- @formatter:on -->
     */
    REASON_MTP("reason_mtp", "-", "Reason for treatment", "Reason for treatment",
            "Grund für die Behandlung", "Raison du traitement", "Motivo del trattamento"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Reason for treatment</div>
     * <div class="de">Grund für die Behandlung</div>
     * <div class="fr">Raison du traitement</div>
     * <div class="it">Motivo</div>
     * <!-- @formatter:on -->
     */
    REASON_PADV("reason_padv", "-", "Reason for treatment", "Reason for treatment",
            "Grund für die Behandlung", "Raison du traitement", "Motivo"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Reason for treatment</div>
     * <div class="de">Grund für die Behandlung</div>
     * <div class="fr">Raison du traitement</div>
     * <div class="it">Motivo</div>
     * <!-- @formatter:on -->
     */
    REASON_PML("reason_pml", "-", "Reason for treatment", "Reason for treatment",
            "Grund für die Behandlung", "Raison du traitement", "Motivo"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Reason for treatment</div>
     * <div class="de">Grund für die Behandlung</div>
     * <div class="fr">Raison du traitement</div>
     * <div class="it">Motivo</div>
     * <!-- @formatter:on -->
     */
    REASON_PMLC("reason_pmlc", "-", "Reason for treatment", "Reason for treatment",
            "Grund für die Behandlung", "Raison du traitement", "Motivo"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Reason for treatment</div>
     * <div class="de">Grund für die Behandlung</div>
     * <div class="fr">Raison du traitement</div>
     * <div class="it">Motivo del trattamento</div>
     * <!-- @formatter:on -->
     */
    REASON_PRE("reason_pre", "-", "Reason for treatment", "Reason for treatment",
            "Grund für die Behandlung", "Raison du traitement", "Motivo del trattamento"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Renewal Term</div>
     * <div class="de">Erneuerungsdauer</div>
     * <div class="fr">Durée de renouvellement</div>
     * <div class="it">Termine di rinnovo</div>
     * <!-- @formatter:on -->
     */
    RENEWAL_PERIOD("renewal_period", "-", "Renewal Term", "Renewal Term", "Erneuerungsdauer",
            "Durée de renouvellement", "Termine di rinnovo"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Renewal Term</div>
     * <div class="de">Erneuerungsdauer</div>
     * <div class="fr">Durée de renouvellement</div>
     * <div class="it">Rinnovo</div>
     * <!-- @formatter:on -->
     */
    RENEWAL_PERIOD_DIS("renewal_period_dis", "-", "Renewal Term", "Renewal Term",
            "Erneuerungsdauer", "Durée de renouvellement", "Rinnovo"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Renewal Term</div>
     * <div class="de">Erneuerungsdauer</div>
     * <div class="fr">Durée de renouvellement</div>
     * <div class="it">Termine di rinnovo</div>
     * <!-- @formatter:on -->
     */
    RENEWAL_PERIOD_MTP("renewal_period_mtp", "-", "Renewal Term", "Renewal Term",
            "Erneuerungsdauer", "Durée de renouvellement", "Termine di rinnovo"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Renewal Term</div>
     * <div class="de">Erneuerungsdauer</div>
     * <div class="fr">Durée de renouvellement</div>
     * <div class="it">Rinnovo</div>
     * <!-- @formatter:on -->
     */
    RENEWAL_PERIOD_PADV("renewal_period_padv", "-", "Renewal Term", "Renewal Term",
            "Erneuerungsdauer", "Durée de renouvellement", "Rinnovo"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Renewal Term</div>
     * <div class="de">Erneuerungsdauer</div>
     * <div class="fr">Durée de renouvellement</div>
     * <div class="it">Rinnovo</div>
     * <!-- @formatter:on -->
     */
    RENEWAL_PERIOD_PML("renewal_period_pml", "-", "Renewal Term", "Renewal Term",
            "Erneuerungsdauer", "Durée de renouvellement", "Rinnovo"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Renewal Term</div>
     * <div class="de">Erneuerungsdauer</div>
     * <div class="fr">Durée de renouvellement</div>
     * <div class="it">Rinnovo</div>
     * <!-- @formatter:on -->
     */
    RENEWAL_PERIOD_PMLC("renewal_period_pmlc", "-", "Renewal Term", "Renewal Term",
            "Erneuerungsdauer", "Durée de renouvellement", "Rinnovo"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Renewal Term</div>
     * <div class="de">Erneuerungsdauer</div>
     * <div class="fr">Durée de renouvellement</div>
     * <div class="it">Termine di rinnovo</div>
     * <!-- @formatter:on -->
     */
    RENEWAL_PERIOD_PRE("renewal_period_pre", "-", "Renewal Term", "Renewal Term",
            "Erneuerungsdauer", "Durée de renouvellement", "Termine di rinnovo"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Number of renewals</div>
     * <div class="de">Anzahl der Erneuerungen</div>
     * <div class="fr">Nombre de renouvellements</div>
     * <div class="it">Numero di rinnovi</div>
     * <!-- @formatter:on -->
     */
    REPEAT("repeat", "-", "Number of renewals", "Number of renewals", "Anzahl der Erneuerungen",
            "Nombre de renouvellements", "Numero di rinnovi"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Number of renewals</div>
     * <div class="de">Anzahl der Erneuerungen</div>
     * <div class="fr">Nombre de renouvellements</div>
     * <div class="it">Numero di ripetizioni / ricariche</div>
     * <!-- @formatter:on -->
     */
    REPEAT_DIS("repeat_dis", "-", "Number of renewals", "Number of renewals",
            "Anzahl der Erneuerungen", "Nombre de renouvellements",
            "Numero di ripetizioni / ricariche"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Number of renewals</div>
     * <div class="de">Anzahl der Erneuerungen</div>
     * <div class="fr">Nombre de renouvellements</div>
     * <div class="it">Numero di rinnovi</div>
     * <!-- @formatter:on -->
     */
    REPEAT_MTP("repeat_mtp", "-", "Number of renewals", "Number of renewals",
            "Anzahl der Erneuerungen", "Nombre de renouvellements", "Numero di rinnovi"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Number of renewals</div>
     * <div class="de">Anzahl der Erneuerungen</div>
     * <div class="fr">Nombre de renouvellements</div>
     * <div class="it">Numero di ripetizioni / ricariche</div>
     * <!-- @formatter:on -->
     */
    REPEAT_PADV("repeat_padv", "-", "Number of renewals", "Number of renewals",
            "Anzahl der Erneuerungen", "Nombre de renouvellements",
            "Numero di ripetizioni / ricariche"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Number of renewals</div>
     * <div class="de">Anzahl der Erneuerungen</div>
     * <div class="fr">Nombre de renouvellements</div>
     * <div class="it">Numero di ripetizioni / ricariche</div>
     * <!-- @formatter:on -->
     */
    REPEAT_PML("repeat_pml", "-", "Number of renewals", "Number of renewals",
            "Anzahl der Erneuerungen", "Nombre de renouvellements",
            "Numero di ripetizioni / ricariche"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Number of renewals</div>
     * <div class="de">Anzahl der Erneuerungen</div>
     * <div class="fr">Nombre de renouvellements</div>
     * <div class="it">Numero di ripetizioni / ricariche</div>
     * <!-- @formatter:on -->
     */
    REPEAT_PMLC("repeat_pmlc", "-", "Number of renewals", "Number of renewals",
            "Anzahl der Erneuerungen", "Nombre de renouvellements",
            "Numero di ripetizioni / ricariche"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Number of renewals</div>
     * <div class="de">Anzahl der Erneuerungen</div>
     * <div class="fr">Nombre de renouvellements</div>
     * <div class="it">Numero di rinnovi</div>
     * <!-- @formatter:on -->
     */
    REPEAT_PRE("repeat_pre", "-", "Number of renewals", "Number of renewals",
            "Anzahl der Erneuerungen", "Nombre de renouvellements", "Numero di rinnovi"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Route of Administration</div>
     * <div class="de">Weg der Verwaltung</div>
     * <div class="fr">Voie d'administration</div>
     * <div class="it">Percorso dell'amministrazione</div>
     * <!-- @formatter:on -->
     */
    ROUTE_CODE("route_code", "-", "Route of Administration", "Route of Administration",
            "Weg der Verwaltung", "Voie d'administration", "Percorso dell'amministrazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Route of Administration</div>
     * <div class="de">Weg der Verwaltung</div>
     * <div class="fr">Voie d'administration</div>
     * <div class="it">Via di somministrazione</div>
     * <!-- @formatter:on -->
     */
    ROUTE_CODE_DIS("route_code_dis", "-", "Route of Administration", "Route of Administration",
            "Weg der Verwaltung", "Voie d'administration", "Via di somministrazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Route of Administration</div>
     * <div class="de">Weg der Verwaltung</div>
     * <div class="fr">Voie d'administration</div>
     * <div class="it">Percorso dell'amministrazione</div>
     * <!-- @formatter:on -->
     */
    ROUTE_CODE_MTP("route_code_mtp", "-", "Route of Administration", "Route of Administration",
            "Weg der Verwaltung", "Voie d'administration", "Percorso dell'amministrazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Route of Administration</div>
     * <div class="de">Weg der Verwaltung</div>
     * <div class="fr">Voie d'administration</div>
     * <div class="it">Via di somministrazione</div>
     * <!-- @formatter:on -->
     */
    ROUTE_CODE_PADV("route_code_padv", "-", "Route of Administration", "Route of Administration",
            "Weg der Verwaltung", "Voie d'administration", "Via di somministrazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Route of Administration</div>
     * <div class="de">Weg der Verwaltung</div>
     * <div class="fr">Voie d'administration</div>
     * <div class="it">Via di somministrazione</div>
     * <!-- @formatter:on -->
     */
    ROUTE_CODE_PML("route_code_pml", "-", "Route of Administration", "Route of Administration",
            "Weg der Verwaltung", "Voie d'administration", "Via di somministrazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Route of Administration</div>
     * <div class="de">Weg der Verwaltung</div>
     * <div class="fr">Voie d'administration</div>
     * <div class="it">Via di somministrazione</div>
     * <!-- @formatter:on -->
     */
    ROUTE_CODE_PMLC("route_code_pmlc", "-", "Route of Administration", "Route of Administration",
            "Weg der Verwaltung", "Voie d'administration", "Via di somministrazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Route of Administration</div>
     * <div class="de">Weg der Verwaltung</div>
     * <div class="fr">Voie d'administration</div>
     * <div class="it">Percorso dell'amministrazione</div>
     * <!-- @formatter:on -->
     */
    ROUTE_CODE_PRE("route_code_pre", "-", "Route of Administration", "Route of Administration",
            "Weg der Verwaltung", "Voie d'administration", "Percorso dell'amministrazione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Possible substitution</div>
     * <div class="de">Mögliche Substitution</div>
     * <div class="fr">Substitution possible</div>
     * <div class="it">Possibile sostituzione</div>
     * <!-- @formatter:on -->
     */
    SUBSTITUTION("substitution", "-", "Possible substitution", "Possible substitution",
            "Mögliche Substitution", "Substitution possible", "Possibile sostituzione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Possible substitution</div>
     * <div class="de">Mögliche Substitution</div>
     * <div class="fr">Substitution possible</div>
     * <div class="it">Sostituzione</div>
     * <!-- @formatter:on -->
     */
    SUBSTITUTION_DIS("substitution_dis", "-", "Possible substitution", "Possible substitution",
            "Mögliche Substitution", "Substitution possible", "Sostituzione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Possible substitution</div>
     * <div class="de">Mögliche Substitution</div>
     * <div class="fr">Substitution possible</div>
     * <div class="it">Possibile sostituzione</div>
     * <!-- @formatter:on -->
     */
    SUBSTITUTION_MTP("substitution_mtp", "-", "Possible substitution", "Possible substitution",
            "Mögliche Substitution", "Substitution possible", "Possibile sostituzione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Possible substitution</div>
     * <div class="de">Mögliche Substitution</div>
     * <div class="fr">Substitution possible</div>
     * <div class="it">Sostituzione</div>
     * <!-- @formatter:on -->
     */
    SUBSTITUTION_PADV("substitution_padv", "-", "Possible substitution", "Possible substitution",
            "Mögliche Substitution", "Substitution possible", "Sostituzione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Possible substitution</div>
     * <div class="de">Mögliche Substitution</div>
     * <div class="fr">Substitution possible</div>
     * <div class="it">Sostituzione</div>
     * <!-- @formatter:on -->
     */
    SUBSTITUTION_PML("substitution_pml", "-", "Possible substitution", "Possible substitution",
            "Mögliche Substitution", "Substitution possible", "Sostituzione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Possible substitution</div>
     * <div class="de">Mögliche Substitution</div>
     * <div class="fr">Substitution possible</div>
     * <div class="it">Sostituzione</div>
     * <!-- @formatter:on -->
     */
    SUBSTITUTION_PMLC("substitution_pmlc", "-", "Possible substitution", "Possible substitution",
            "Mögliche Substitution", "Substitution possible", "Sostituzione"),
    /**
     * <!-- @formatter:off -->
     * <div class="en">Possible substitution</div>
     * <div class="de">Mögliche Substitution</div>
     * <div class="fr">Substitution possible</div>
     * <div class="it">Possibile sostituzione</div>
     * <!-- @formatter:on -->
     */
    SUBSTITUTION_PRE("substitution_pre", "-", "Possible substitution", "Possible substitution",
            "Mögliche Substitution", "Substitution possible", "Possibile sostituzione");

    /**
     * <!-- @formatter:off -->
     * <div class="en">Gets the Enum with a given code</div>
     * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
     * <!-- @formatter:on -->
     *
     * @param code <div class="de"> code</div>
     * @return <div class="en">the enum</div>
     */
    public static EmedTextNarrativeAttributes getEnum(String code) {
        for (final EmedTextNarrativeAttributes x : values()) {
            if (x.getCodeValue().equals(code)) {
                return x;
            }
        }
        return null;
    }

    /**
     * <!-- @formatter:off -->
     * <div class="en">Checks if a given enum is part of this value set.</div>
     * <div class="de">Prüft, ob der angegebene enum Teil dieses Value Sets ist.</div>
     * <!-- @formatter:on -->
     *
     * @param enumName <div class="de"> enumName</div>
     * @return true, if enum is in this value set
     */
    public static boolean isEnumOfValueSet(String enumName) {
        if (enumName == null) {
            return false;
        }
        try {
            Enum.valueOf(EmedTextNarrativeAttributes.class, enumName);
            return true;
        } catch (final IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * <!-- @formatter:off -->
     * <div class="en">Checks if a given code value is in this value set.</div>
     * <div class="de">Prüft, ob der angegebene code in diesem Value Set vorhanden ist.</div>
     * <!-- @formatter:on -->
     *
     * @param codeValue <div class="de"> code</div>
     * @return true, if is in value set
     */
    public static boolean isInValueSet(String codeValue) {
        for (final EmedTextNarrativeAttributes x : values()) {
            if (x.getCodeValue().equals(codeValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <!-- @formatter:off -->
     * <div class="en">Machine interpretable and (inside this class) unique code</div>
     * <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse) eindeutiger Code</div>
     * <!-- @formatter:on -->
     */
    private String code;

    /**
     * <!-- @formatter:off -->
     * <div class="en">Identifier of the referencing code system.</div>
     * <div class="de">Identifikator des referenzierende Codesystems.</div>
     * <!-- @formatter:on -->
     */
    private String codeSystem;

    /**
     * The display names per language
     */
    private Map<LanguageCode, String> displayNames;

    /**
     * <!-- @formatter:off -->
     * <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
     * <div class="de">Instanziiert dieses Enum Object mittels eines Codes und einem Display Name</div>.
     * <!-- @formatter:on -->
     *
     * @param code          code
     * @param codeSystem    codeSystem
     * @param displayName   the default display name
     * @param displayNameEn the display name en
     * @param displayNameDe the display name de
     * @param displayNameFr the display name fr
     * @param displayNameIt the display name it
     */
    EmedTextNarrativeAttributes(String code, String codeSystem, String displayName,
                                String displayNameEn, String displayNameDe, String displayNameFr,
                                String displayNameIt) {
        this.code = code;
        this.codeSystem = codeSystem;
        displayNames = new HashMap<>();
        displayNames.put(null, displayName);
        displayNames.put(LanguageCode.ENGLISH, displayNameEn);
        displayNames.put(LanguageCode.GERMAN, displayNameDe);
        displayNames.put(LanguageCode.FRENCH, displayNameFr);
        displayNames.put(LanguageCode.ITALIAN, displayNameIt);
    }

    /**
     * <!-- @formatter:off -->
     * <div class="en">Gets the code system identifier.</div>
     * <div class="de">Liefert den Code System Identifikator.</div>
     * <!-- @formatter:on -->
     *
     * @return <div class="en">the code system identifier</div>
     */
    public String getCodeSystemId() {
        return this.codeSystem;
    }

    /**
     * <!-- @formatter:off -->
     * <div class="en">Gets the code system name.</div>
     * <div class="de">Liefert den Code System Namen.</div>
     * <!-- @formatter:on -->
     *
     * @return <div class="en">the code system identifier</div>
     */
    public String getCodeSystemName() {
        String retVal = "";
        CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
        if (cs != null)
            retVal = cs.getCodeSystemName();
        return retVal;
    }

    /**
     * <!-- @formatter:off -->
     * <div class="en">Gets the actual Code as string</div>
     * <div class="de">Liefert den eigentlichen Code als String</div>
     * <!-- @formatter:on -->
     *
     * @return <div class="en">the code</div>
     */
    public String getCodeValue() {
        return this.code;
    }

    /**
     * <!-- @formatter:off -->
     * <div class="en">Gets the display name defined by the language param. If
     * there is no english translation, the default display name is returned.</div>
     * <div class="de">Liefert display name gemäss Parameter, falls es keine
     * Englische Übersetzung gibt, wird der default-Name zurückgegeben.</div>
     * <!-- @formatter:on -->
     *
     * @param languageCode the language code to get the display name for
     * @return returns the display name in the desired language. if language not
     * found, display name in german will returned
     */
    public String getDisplayName(LanguageCode languageCode) {
        String displayName = displayNames.get(languageCode);
        if (displayName == null && languageCode == LanguageCode.ENGLISH) {
            return displayNames.get(null);
        }
        return displayName;
    }

    /**
     * <!-- @formatter:off -->
     * <div class="en">Gets the code system name.</div>
     * <div class="de">Liefert den Code System Namen.</div>
     * <!-- @formatter:on -->
     *
     * @return <div class="en">the code system identifier</div>
     */
    @Override
    public String toString() {
        return getCodeValue();
    }
}
