/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.communication.ch.enums.beta;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DocumentEntry.practiceSettingCode values
 * <p>
 * EN: Medical specialisation of the data captured in the document as per Annex 3; EPRO-FDHA. This attribute assigns the contents of a document to a medical specialisation. It is conceivable that this information will assist the patient with setting or changing the confidentiality level of documents, which is relevant for controlling access.<br>
 * DE: Medizinische Fachrichtung der in dem Dokument erfassten Daten gemäss Anhang 3 EPDV-EDI. Dieses Attribut soll den Inhalt eines Dokumentes einer medizinischen Fachrichtung zuordnen. Es ist denkbar, dass der Patient mit dieser Information eine Hilfestellung erhält zum Setzen oder Verändern der Vertraulichkeitsstufe von Dokumenten, welche relevant ist für die Zugriffssteuerung.<br>
 * FR: Discipline médicale des données saisies dans le document selon l'annexe 3 ODEP-DFI. Cet attribut permet d'indiquer la discipline médicale dont relève le contenu d'un document. Cette information peut guider le patient et l'aider à choisir ou à changer le niveau de confidentialité attribué à ses documents et qui détermine les droits d'accès.<br>
 * IT: Specialità medica dei dati inseriti nel documento secondo l'allegato 3 OCIP-DFI. Questo attributo intende associare il contenuto di un documento a una specialità medica. È ipotizzabile che questa informazione fornisca un aiuto al paziente per impostare o modificare il grado di riservatezza dei documenti, rilevante per il controllo degli accessi.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.1.18<br>
 * Effective date: 2022-06-26 14:45<br>
 * Version: 202304.0-beta<br>
 * Status: DRAFT
 */
@Generated(value = "org.husky.codegenerator.ch.valuesets.UpdateValueSets", date = "2022-09-29")
public enum PracticeSettingCode implements ValueSetEnumInterface {

    /**
     * EN: Accident &amp; emergency.<br>
     * DE: Notfall- und Rettungsmedizin.<br>
     * FR: médecine d'urgence et de sauvetage.<br>
     * IT: medicina d'urgenza e di salvataggio.<br>
     */
    ACCIDENT_EMERGENCY("394576009",
                       "2.16.840.1.113883.6.96",
                       "Accident & emergency (qualifier value)",
                       "Accident & emergency",
                       "Notfall- und Rettungsmedizin",
                       "médecine d'urgence et de sauvetage",
                       "medicina d'urgenza e di salvataggio"),
    /**
     * EN: Anaesthesiology.<br>
     * DE: Anästhesiologie.<br>
     * FR: anesthésiologie.<br>
     * IT: anestesiologia.<br>
     */
    ANAESTHESIOLOGY("394577000",
                    "2.16.840.1.113883.6.96",
                    "Anesthetics (qualifier value)",
                    "Anaesthesiology",
                    "Anästhesiologie",
                    "anesthésiologie",
                    "anestesiologia"),
    /**
     * EN: Cardiac surgery.<br>
     * DE: Herzchirurgie.<br>
     * FR: chirurgie cardiovasculaire.<br>
     * IT: chirurgia cardiovascolare.<br>
     */
    CARDIAC_SURGERY("408466002",
                    "2.16.840.1.113883.6.96",
                    "Cardiac surgery (qualifier value)",
                    "Cardiac surgery",
                    "Herzchirurgie",
                    "chirurgie cardiovasculaire",
                    "chirurgia cardiovascolare"),
    /**
     * EN: Cardiology.<br>
     * DE: Kardiologie.<br>
     * FR: cardiologie.<br>
     * IT: cardiologia.<br>
     */
    CARDIOLOGY("394579002",
               "2.16.840.1.113883.6.96",
               "Cardiology (qualifier value)",
               "Cardiology",
               "Kardiologie",
               "cardiologie",
               "cardiologia"),
    /**
     * EN: Chiropractic service.<br>
     * DE: Chiropraktik.<br>
     * FR: chiropractie.<br>
     * IT: chiropratica.<br>
     */
    CHIROPRACTIC_SERVICE("722170006",
                         "2.16.840.1.113883.6.96",
                         "Chiropractic service (qualifier value)",
                         "Chiropractic service",
                         "Chiropraktik",
                         "chiropractie",
                         "chiropratica"),
    /**
     * EN: Clinical genetics.<br>
     * DE: Medizinische Genetik.<br>
     * FR: génétique médicale.<br>
     * IT: genetica medica.<br>
     */
    CLINICAL_GENETICS("394580004",
                      "2.16.840.1.113883.6.96",
                      "Clinical genetics (qualifier value)",
                      "Clinical genetics",
                      "Medizinische Genetik",
                      "génétique médicale",
                      "genetica medica"),
    /**
     * EN: Clinical haematology.<br>
     * DE: Hämatologie.<br>
     * FR: hématologie.<br>
     * IT: ematologia.<br>
     */
    CLINICAL_HAEMATOLOGY("394803006",
                         "2.16.840.1.113883.6.96",
                         "Clinical hematology (qualifier value)",
                         "Clinical haematology",
                         "Hämatologie",
                         "hématologie",
                         "ematologia"),
    /**
     * EN: Clinical immunology.<br>
     * DE: Immunologie.<br>
     * FR: immunologie.<br>
     * IT: immunologia.<br>
     */
    CLINICAL_IMMUNOLOGY("408480009",
                        "2.16.840.1.113883.6.96",
                        "Clinical immunology (qualifier value)",
                        "Clinical immunology",
                        "Immunologie",
                        "immunologie",
                        "immunologia"),
    /**
     * EN: Clinical immunology/allergy.<br>
     * DE: Immunologie/Allergologie.<br>
     * FR: immunologie/allergologie.<br>
     * IT: allergologia e immunologia clinica.<br>
     */
    CLINICAL_IMMUNOLOGY_ALLERGY("394805004",
                                "2.16.840.1.113883.6.96",
                                "Clinical immunology/allergy (qualifier value)",
                                "Clinical immunology/allergy",
                                "Immunologie/Allergologie",
                                "immunologie/allergologie",
                                "allergologia e immunologia clinica"),
    /**
     * EN: Clinical oncology.<br>
     * DE: Onkologie.<br>
     * FR: oncologie.<br>
     * IT: oncologia medica.<br>
     */
    CLINICAL_ONCOLOGY("394592004",
                      "2.16.840.1.113883.6.96",
                      "Clinical oncology (qualifier value)",
                      "Clinical oncology",
                      "Onkologie",
                      "oncologie",
                      "oncologia medica"),
    /**
     * EN: Clinical pharmacology.<br>
     * DE: Klinische Pharmakologie.<br>
     * FR: pharmacologie clinique.<br>
     * IT: farmacologia clinica.<br>
     */
    CLINICAL_PHARMACOLOGY("394600006",
                          "2.16.840.1.113883.6.96",
                          "Clinical pharmacology (qualifier value)",
                          "Clinical pharmacology",
                          "Klinische Pharmakologie",
                          "pharmacologie clinique",
                          "farmacologia clinica"),
    /**
     * EN: Complementary therapy.<br>
     * DE: Komplementärmedizin.<br>
     * FR: médecine alternative et complémentaire.<br>
     * IT: medicina complementare.<br>
     */
    COMPLEMENTARY_THERAPY("310025004",
                          "2.16.840.1.113883.6.96",
                          "Complementary therapy service (qualifier value)",
                          "Complementary therapy",
                          "Komplementärmedizin",
                          "médecine alternative et complémentaire",
                          "medicina complementare"),
    /**
     * EN: Critical care medicine.<br>
     * DE: Intensivmedizin.<br>
     * FR: médecine intensive.<br>
     * IT: medicina intensiva.<br>
     */
    CRITICAL_CARE_MEDICINE("408478003",
                           "2.16.840.1.113883.6.96",
                           "Critical care medicine (qualifier value)",
                           "Critical care medicine",
                           "Intensivmedizin",
                           "médecine intensive",
                           "medicina intensiva"),
    /**
     * EN: Dental medicine.<br>
     * DE: Zahnheilkunde.<br>
     * FR: odontologie.<br>
     * IT: odontoiatria.<br>
     */
    DENTAL_MEDICINE("394812008",
                    "2.16.840.1.113883.6.96",
                    "Dental medicine specialties (qualifier value)",
                    "Dental medicine",
                    "Zahnheilkunde",
                    "odontologie",
                    "odontoiatria"),
    /**
     * EN: Dentistry.<br>
     * DE: Zahnmedizin.<br>
     * FR: dentisterie.<br>
     * IT: odontoiatria.<br>
     */
    DENTISTRY("722163006",
              "2.16.840.1.113883.6.96",
              "Dentistry (qualifier value)",
              "Dentistry",
              "Zahnmedizin",
              "dentisterie",
              "odontoiatria"),
    /**
     * EN: Dermatology.<br>
     * DE: Dermatologie und Venerologie.<br>
     * FR: dermatologie et vénérologie.<br>
     * IT: dermatologia e venereologia.<br>
     */
    DERMATOLOGY("394582007",
                "2.16.840.1.113883.6.96",
                "Dermatology (qualifier value)",
                "Dermatology",
                "Dermatologie und Venerologie",
                "dermatologie et vénérologie",
                "dermatologia e venereologia"),
    /**
     * EN: Dietetics and nutrition.<br>
     * DE: Ernährungsberatung.<br>
     * FR: conseil en nutrition et diététique.<br>
     * IT: dietetica.<br>
     */
    DIETETICS_AND_NUTRITION("722164000",
                            "2.16.840.1.113883.6.96",
                            "Dietetics and nutrition (qualifier value)",
                            "Dietetics and nutrition",
                            "Ernährungsberatung",
                            "conseil en nutrition et diététique",
                            "dietetica"),
    /**
     * EN: Emergency medicine.<br>
     * DE: Notfallmedizin.<br>
     * FR: médecine d'urgence.<br>
     * IT: medicina d'urgenza.<br>
     */
    EMERGENCY_MEDICINE("773568002",
                       "2.16.840.1.113883.6.96",
                       "Emergency medicine (qualifier value)",
                       "Emergency medicine",
                       "Notfallmedizin",
                       "médecine d'urgence",
                       "medicina d'urgenza"),
    /**
     * EN: Endocrinology.<br>
     * DE: Endokrinologie/Diabetologie.<br>
     * FR: endocrinologie/diabétologie.<br>
     * IT: endocrinologia/diabetologia.<br>
     */
    ENDOCRINOLOGY("394583002",
                  "2.16.840.1.113883.6.96",
                  "Endocrinology (qualifier value)",
                  "Endocrinology",
                  "Endokrinologie/Diabetologie",
                  "endocrinologie/diabétologie",
                  "endocrinologia/diabetologia"),
    /**
     * EN: Gastroenterology.<br>
     * DE: Gastroenterologie.<br>
     * FR: gastroentérologie.<br>
     * IT: gastroenterologia.<br>
     */
    GASTROENTEROLOGY("394584008",
                     "2.16.840.1.113883.6.96",
                     "Gastroenterology (qualifier value)",
                     "Gastroenterology",
                     "Gastroenterologie",
                     "gastroentérologie",
                     "gastroenterologia"),
    /**
     * EN: General medicine.<br>
     * DE: Allgemeinmedizin.<br>
     * FR: médecine générale.<br>
     * IT: medicina generale.<br>
     */
    GENERAL_MEDICINE("394802001",
                     "2.16.840.1.113883.6.96",
                     "General medicine (qualifier value)",
                     "General medicine",
                     "Allgemeinmedizin",
                     "médecine générale",
                     "medicina generale"),
    /**
     * EN: General surgery.<br>
     * DE: Chirurgie.<br>
     * FR: chirurgie.<br>
     * IT: chirurgia.<br>
     */
    GENERAL_SURGERY("394609007",
                    "2.16.840.1.113883.6.96",
                    "General surgery (qualifier value)",
                    "General surgery",
                    "Chirurgie",
                    "chirurgie",
                    "chirurgia"),
    /**
     * EN: Geriatric medicine.<br>
     * DE: Geriatrie.<br>
     * FR: gériatrie.<br>
     * IT: geriatria.<br>
     */
    GERIATRIC_MEDICINE("394811001",
                       "2.16.840.1.113883.6.96",
                       "Geriatric medicine (qualifier value)",
                       "Geriatric medicine",
                       "Geriatrie",
                       "gériatrie",
                       "geriatria"),
    /**
     * EN: Gynecology and obstetrics.<br>
     * DE: Gynäkologie.<br>
     * FR: gynécologie.<br>
     * IT: ginecologia.<br>
     */
    GYNECOLOGY_AND_OBSTETRICS("394586005",
                              "2.16.840.1.113883.6.96",
                              "Gynecology (qualifier value)",
                              "Gynecology and obstetrics",
                              "Gynäkologie",
                              "gynécologie",
                              "ginecologia"),
    /**
     * EN: Infectious diseases.<br>
     * DE: Infektionskrankheiten.<br>
     * FR: maladies infectieuses.<br>
     * IT: malattia infettiva.<br>
     */
    INFECTIOUS_DISEASES("394807007",
                        "2.16.840.1.113883.6.96",
                        "Infectious diseases (specialty) (qualifier value)",
                        "Infectious diseases",
                        "Infektionskrankheiten",
                        "maladies infectieuses",
                        "malattia infettiva"),
    /**
     * EN: Internal medicine.<br>
     * DE: Innere Medizin.<br>
     * FR: médecine interne.<br>
     * IT: medicina interna.<br>
     */
    INTERNAL_MEDICINE("419192003",
                      "2.16.840.1.113883.6.96",
                      "Internal medicine (qualifier value)",
                      "Internal medicine",
                      "Innere Medizin",
                      "médecine interne",
                      "medicina interna"),
    /**
     * EN: Laboratory service.<br>
     * DE: Labormedizin.<br>
     * FR: médecin de laboratoire.<br>
     * IT: medicina di laboratorio.<br>
     */
    LABORATORY_SERVICE("708184003",
                       "2.16.840.1.113883.6.96",
                       "Clinical pathology service (qualifier value)",
                       "Laboratory service",
                       "Labormedizin",
                       "médecin de laboratoire",
                       "medicina di laboratorio"),
    /**
     * EN: Legal medicine.<br>
     * DE: Rechtsmedizin.<br>
     * FR: médecine légale.<br>
     * IT: medicina legale.<br>
     */
    LEGAL_MEDICINE("722204007",
                   "2.16.840.1.113883.6.96",
                   "Legal medicine (qualifier value)",
                   "Legal medicine",
                   "Rechtsmedizin",
                   "médecine légale",
                   "medicina legale"),
    /**
     * EN: Nephrology.<br>
     * DE: Nephrologie.<br>
     * FR: néphrologie.<br>
     * IT: nefrologia.<br>
     */
    NEPHROLOGY("394589003",
               "2.16.840.1.113883.6.96",
               "Nephrology (qualifier value)",
               "Nephrology",
               "Nephrologie",
               "néphrologie",
               "nefrologia"),
    /**
     * EN: Neurology.<br>
     * DE: Neurologie.<br>
     * FR: neurologie.<br>
     * IT: neurologia.<br>
     */
    NEUROLOGY("394591006",
              "2.16.840.1.113883.6.96",
              "Neurology (qualifier value)",
              "Neurology",
              "Neurologie",
              "neurologie",
              "neurologia"),
    /**
     * EN: Neurosurgery.<br>
     * DE: Neurochirurgie.<br>
     * FR: neurochirurgie.<br>
     * IT: neurochirurgia.<br>
     */
    NEUROSURGERY("394610002",
                 "2.16.840.1.113883.6.96",
                 "Neurosurgery (qualifier value)",
                 "Neurosurgery",
                 "Neurochirurgie",
                 "neurochirurgie",
                 "neurochirurgia"),
    /**
     * EN: Nuclear medicine.<br>
     * DE: Nuklearmedizin.<br>
     * FR: médecine nucléaire.<br>
     * IT: medicina nucleare.<br>
     */
    NUCLEAR_MEDICINE("394649004",
                     "2.16.840.1.113883.6.96",
                     "Nuclear medicine - specialty (qualifier value)",
                     "Nuclear medicine",
                     "Nuklearmedizin",
                     "médecine nucléaire",
                     "medicina nucleare"),
    /**
     * EN: Nursing.<br>
     * DE: Pflege.<br>
     * FR: soins.<br>
     * IT: cure infermieristiche.<br>
     */
    NURSING("722165004",
            "2.16.840.1.113883.6.96",
            "Nursing (qualifier value)",
            "Nursing",
            "Pflege",
            "soins",
            "cure infermieristiche"),
    /**
     * EN: Obstetrics.<br>
     * DE: Geburtshilfe.<br>
     * FR: obstétrique.<br>
     * IT: ostetricia.<br>
     */
    OBSTETRICS("408470005",
               "2.16.840.1.113883.6.96",
               "Obstetrics (qualifier value)",
               "Obstetrics",
               "Geburtshilfe",
               "obstétrique",
               "ostetricia"),
    /**
     * EN: Occupational therapy service.<br>
     * DE: Ergotherapie.<br>
     * FR: ergothérapie.<br>
     * IT: ergoterapia.<br>
     */
    OCCUPATIONAL_THERAPY_SERVICE("310093001",
                                 "2.16.840.1.113883.6.96",
                                 "Occupational therapy service (qualifier value)",
                                 "Occupational therapy service",
                                 "Ergotherapie",
                                 "ergothérapie",
                                 "ergoterapia"),
    /**
     * EN: Ophthalmology.<br>
     * DE: Ophthalmologie.<br>
     * FR: ophtalmologie.<br>
     * IT: oftalmologia.<br>
     */
    OPHTHALMOLOGY("394594003",
                  "2.16.840.1.113883.6.96",
                  "Ophthalmology (qualifier value)",
                  "Ophthalmology",
                  "Ophthalmologie",
                  "ophtalmologie",
                  "oftalmologia"),
    /**
     * EN: Oral and maxillofacial surgery.<br>
     * DE: Mund-, Kiefer- und Gesichtschirurgie.<br>
     * FR: chirurgie dento-maxillo-faciale.<br>
     * IT: chirurgia oro-maxillo-facciale.<br>
     */
    ORAL_AND_MAXILLOFACIAL_SURGERY("408465003",
                                   "2.16.840.1.113883.6.96",
                                   "Oral and maxillofacial surgery (qualifier value)",
                                   "Oral and maxillofacial surgery",
                                   "Mund-, Kiefer- und Gesichtschirurgie",
                                   "chirurgie dento-maxillo-faciale",
                                   "chirurgia oro-maxillo-facciale"),
    /**
     * EN: Osteopathic manipulative medicine.<br>
     * DE: Osteopathie.<br>
     * FR: ostéopathie.<br>
     * IT: osteopatia.<br>
     */
    OSTEOPATHIC_MANIPULATIVE_MEDICINE("416304004",
                                      "2.16.840.1.113883.6.96",
                                      "Osteopathic manipulative medicine (qualifier value)",
                                      "Osteopathic manipulative medicine",
                                      "Osteopathie",
                                      "ostéopathie",
                                      "osteopatia"),
    /**
     * EN: Other clinical specialty.<br>
     * DE: Andere nicht näher spezifizierte medizinische Fachrichtung.<br>
     * FR: autres spécialisations non spécifiées.<br>
     * IT: altre specialità mediche non meglio precisate.<br>
     */
    OTHER_CLINICAL_SPECIALTY("394658006",
                             "2.16.840.1.113883.6.96",
                             "Clinical specialty (qualifier value)",
                             "Other clinical specialty",
                             "Andere nicht näher spezifizierte medizinische Fachrichtung",
                             "autres spécialisations non spécifiées",
                             "altre specialità mediche non meglio precisate"),
    /**
     * EN: Otolaryngology.<br>
     * DE: Oto-Rhino-Laryngologie.<br>
     * FR: oto-rhino-laryngologie.<br>
     * IT: otorinolaringoiatria.<br>
     */
    OTOLARYNGOLOGY("418960008",
                   "2.16.840.1.113883.6.96",
                   "Otolaryngology (qualifier value)",
                   "Otolaryngology",
                   "Oto-Rhino-Laryngologie",
                   "oto-rhino-laryngologie",
                   "otorinolaringoiatria"),
    /**
     * EN: Palliative medicine.<br>
     * DE: Palliativmedizin.<br>
     * FR: médecine palliative.<br>
     * IT: medicina palliativa.<br>
     */
    PALLIATIVE_MEDICINE("394806003",
                        "2.16.840.1.113883.6.96",
                        "Palliative medicine (qualifier value)",
                        "Palliative medicine",
                        "Palliativmedizin",
                        "médecine palliative",
                        "medicina palliativa"),
    /**
     * EN: Pathology.<br>
     * DE: Pathologie.<br>
     * FR: pathologie.<br>
     * IT: patologia.<br>
     */
    PATHOLOGY("394595002",
              "2.16.840.1.113883.6.96",
              "Pathology (qualifier value)",
              "Pathology",
              "Pathologie",
              "pathologie",
              "patologia"),
    /**
     * EN: Pediatrics.<br>
     * DE: Pädiatrie.<br>
     * FR: pédiatrie.<br>
     * IT: pediatria.<br>
     */
    PEDIATRICS("394537008",
               "2.16.840.1.113883.6.96",
               "Pediatric specialty (qualifier value)",
               "Pediatrics",
               "Pädiatrie",
               "pédiatrie",
               "pediatria"),
    /**
     * EN: Pharmacy service.<br>
     * DE: Pharmazeutische Dienstleistungen.<br>
     * FR: service pharmaceutique.<br>
     * IT: servizio farmaceutico.<br>
     */
    PHARMACY_SERVICE("310080006",
                     "2.16.840.1.113883.6.96",
                     "Pharmacy service (qualifier value)",
                     "Pharmacy service",
                     "Pharmazeutische Dienstleistungen",
                     "service pharmaceutique",
                     "servizio farmaceutico"),
    /**
     * EN: Physiotherapy.<br>
     * DE: Physiotherapie.<br>
     * FR: physiothérapie.<br>
     * IT: fisioterapia.<br>
     */
    PHYSIOTHERAPY("722138006",
                  "2.16.840.1.113883.6.96",
                  "Physiotherapy (qualifier value)",
                  "Physiotherapy",
                  "Physiotherapie",
                  "physiothérapie",
                  "fisioterapia"),
    /**
     * EN: Plastic surgery.<br>
     * DE: Plastische, Rekonstruktive und Ästhetische Chirurgie.<br>
     * FR: chirurgie plastique, reconstructrice et esthétique.<br>
     * IT: chirurgia plastica, ricostruttiva ed estetica.<br>
     */
    PLASTIC_SURGERY("394611003",
                    "2.16.840.1.113883.6.96",
                    "Plastic surgery - specialty (qualifier value)",
                    "Plastic surgery",
                    "Plastische, Rekonstruktive und Ästhetische Chirurgie",
                    "chirurgie plastique, reconstructrice et esthétique",
                    "chirurgia plastica, ricostruttiva ed estetica"),
    /**
     * EN: Podiatry service.<br>
     * DE: Podologie.<br>
     * FR: podologie.<br>
     * IT: podologia.<br>
     */
    PODIATRY_SERVICE("310087009",
                     "2.16.840.1.113883.6.96",
                     "Podiatry service (qualifier value)",
                     "Podiatry service",
                     "Podologie",
                     "podologie",
                     "podologia"),
    /**
     * EN: Preventive medicine.<br>
     * DE: Präventionsmedizin.<br>
     * FR: médecine préventive .<br>
     * IT: prevenzione.<br>
     */
    PREVENTIVE_MEDICINE("409968004",
                        "2.16.840.1.113883.6.96",
                        "Preventive medicine (qualifier value)",
                        "Preventive medicine",
                        "Präventionsmedizin",
                        "médecine préventive ",
                        "prevenzione"),
    /**
     * EN: Psychiatry.<br>
     * DE: Psychiatrie und Psychotherapie.<br>
     * FR: psychiatrie et psychothérapie.<br>
     * IT: psichiatria e psicoterapia.<br>
     */
    PSYCHIATRY("394587001",
               "2.16.840.1.113883.6.96",
               "Psychiatry (qualifier value)",
               "Psychiatry",
               "Psychiatrie und Psychotherapie",
               "psychiatrie et psychothérapie",
               "psichiatria e psicoterapia"),
    /**
     * EN: Psychology.<br>
     * DE: Psychologie.<br>
     * FR: psychologie.<br>
     * IT: psicologia.<br>
     */
    PSYCHOLOGY("722162001",
               "2.16.840.1.113883.6.96",
               "Psychology (qualifier value)",
               "Psychology",
               "Psychologie",
               "psychologie",
               "psicologia"),
    /**
     * EN: Psychosomatic medicine.<br>
     * DE: Psychosomatik.<br>
     * FR: psychosomatique.<br>
     * IT: medicina psicosomatica.<br>
     */
    PSYCHOSOMATIC_MEDICINE("721961006",
                           "2.16.840.1.113883.6.96",
                           "Psychosomatic medicine (qualifier value)",
                           "Psychosomatic medicine",
                           "Psychosomatik",
                           "psychosomatique",
                           "medicina psicosomatica"),
    /**
     * EN: Pulmonary medicine.<br>
     * DE: Pneumologie.<br>
     * FR: pneumologie.<br>
     * IT: pneumologia.<br>
     */
    PULMONARY_MEDICINE("418112009",
                       "2.16.840.1.113883.6.96",
                       "Pulmonary medicine (qualifier value)",
                       "Pulmonary medicine",
                       "Pneumologie",
                       "pneumologie",
                       "pneumologia"),
    /**
     * EN: Radiation oncology.<br>
     * DE: Radio-Onkologie.<br>
     * FR: radio-oncologie.<br>
     * IT: radio-oncologia.<br>
     */
    RADIATION_ONCOLOGY("419815003",
                       "2.16.840.1.113883.6.96",
                       "Radiation oncology (qualifier value)",
                       "Radiation oncology",
                       "Radio-Onkologie",
                       "radio-oncologie",
                       "radio-oncologia"),
    /**
     * EN: Radiology.<br>
     * DE: Radiologie.<br>
     * FR: radiologie.<br>
     * IT: radiologia.<br>
     */
    RADIOLOGY("394914008",
              "2.16.840.1.113883.6.96",
              "Radiology - specialty (qualifier value)",
              "Radiology",
              "Radiologie",
              "radiologie",
              "radiologia"),
    /**
     * EN: Rehabilitation.<br>
     * DE: Rehabilitation.<br>
     * FR: réadaptation.<br>
     * IT: riabilitazione.<br>
     */
    REHABILITATION("394602003",
                   "2.16.840.1.113883.6.96",
                   "Rehabilitation - specialty (qualifier value)",
                   "Rehabilitation",
                   "Rehabilitation",
                   "réadaptation",
                   "riabilitazione"),
    /**
     * EN: Rheumatology.<br>
     * DE: Rheumatologie.<br>
     * FR: rhumatologie.<br>
     * IT: reumatologia.<br>
     */
    RHEUMATOLOGY("394810000",
                 "2.16.840.1.113883.6.96",
                 "Rheumatology (qualifier value)",
                 "Rheumatology",
                 "Rheumatologie",
                 "rhumatologie",
                 "reumatologia"),
    /**
     * EN: Speech and language therapy service.<br>
     * DE: Logopädie.<br>
     * FR: logopédie.<br>
     * IT: logopedia.<br>
     */
    SPEECH_AND_LANGUAGE_THERAPY_SERVICE("310101009",
                                        "2.16.840.1.113883.6.96",
                                        "Speech and language therapy service (qualifier value)",
                                        "Speech and language therapy service",
                                        "Logopädie",
                                        "logopédie",
                                        "logopedia"),
    /**
     * EN: Thoracic surgery.<br>
     * DE: Thoraxchirurgie.<br>
     * FR: chirurgie thoracique.<br>
     * IT: chirurgia toracica.<br>
     */
    THORACIC_SURGERY("408456005",
                     "2.16.840.1.113883.6.96",
                     "Thoracic surgery (qualifier value)",
                     "Thoracic surgery",
                     "Thoraxchirurgie",
                     "chirurgie thoracique",
                     "chirurgia toracica"),
    /**
     * EN: Transfusion medicine.<br>
     * DE: Transfusionsmedizin.<br>
     * FR: médecine transfusionnelle.<br>
     * IT: medicina trasfusionale.<br>
     */
    TRANSFUSION_MEDICINE("394819004",
                         "2.16.840.1.113883.6.96",
                         "Blood transfusion (specialty) (qualifier value)",
                         "Transfusion medicine",
                         "Transfusionsmedizin",
                         "médecine transfusionnelle",
                         "medicina trasfusionale"),
    /**
     * EN: Transplant surgery.<br>
     * DE: Transplatationschirurgie.<br>
     * FR: chirurgie de transplantation.<br>
     * IT: chirurgia dei trapianti.<br>
     */
    TRANSPLANT_SURGERY("408477008",
                       "2.16.840.1.113883.6.96",
                       "Transplantation surgery (qualifier value)",
                       "Transplant surgery",
                       "Transplatationschirurgie",
                       "chirurgie de transplantation",
                       "chirurgia dei trapianti"),
    /**
     * EN: Trauma and orthopedics.<br>
     * DE: Orthopädie und Traumatologie.<br>
     * FR: chirurgie orthopédique et traumatologie de l'appareil locomoteur.<br>
     * IT: chirurgia ortopedica e traumatologia dell'apparato locomotore.<br>
     */
    TRAUMA_AND_ORTHOPEDICS("394801008",
                           "2.16.840.1.113883.6.96",
                           "Trauma and orthopedics (qualifier value)",
                           "Trauma and orthopedics",
                           "Orthopädie und Traumatologie",
                           "chirurgie orthopédique et traumatologie de l'appareil locomoteur",
                           "chirurgia ortopedica e traumatologia dell'apparato locomotore"),
    /**
     * EN: Tropical medicine.<br>
     * DE: Tropen- und Reisemedizin.<br>
     * FR: médecine tropicale et des voyages.<br>
     * IT: medicina tropicale e di viaggio.<br>
     */
    TROPICAL_MEDICINE("408448007",
                      "2.16.840.1.113883.6.96",
                      "Tropical medicine (qualifier value)",
                      "Tropical medicine",
                      "Tropen- und Reisemedizin",
                      "médecine tropicale et des voyages",
                      "medicina tropicale e di viaggio"),
    /**
     * EN: Urology.<br>
     * DE: Urologie.<br>
     * FR: urologie.<br>
     * IT: urologia.<br>
     */
    UROLOGY("394612005",
            "2.16.840.1.113883.6.96",
            "Urology (qualifier value)",
            "Urology",
            "Urologie",
            "urologie",
            "urologia"),
    /**
     * EN: Vascular medicine.<br>
     * DE: Angiologie.<br>
     * FR: angiologie.<br>
     * IT: angiologia.<br>
     */
    VASCULAR_MEDICINE("722414000",
                      "2.16.840.1.113883.6.96",
                      "Vascular medicine (qualifier value)",
                      "Vascular medicine",
                      "Angiologie",
                      "angiologie",
                      "angiologia"),
    /**
     * EN: Vascular surgery.<br>
     * DE: Gefässchirurgie.<br>
     * FR: chirurgie vasculaire.<br>
     * IT: chirurgia vascolare.<br>
     */
    VASCULAR_SURGERY("408463005",
                     "2.16.840.1.113883.6.96",
                     "Vascular surgery (qualifier value)",
                     "Vascular surgery",
                     "Gefässchirurgie",
                     "chirurgie vasculaire",
                     "chirurgia vascolare");

    /**
     * EN: Code for Accident &amp; emergency.<br>
     * DE: Code für Notfall- und Rettungsmedizin.<br>
     * FR: Code de médecine d'urgence et de sauvetage.<br>
     * IT: Code per medicina d'urgenza e di salvataggio.<br>
     */
    public static final String ACCIDENT_EMERGENCY_CODE = "394576009";

    /**
     * EN: Code for Anaesthesiology.<br>
     * DE: Code für Anästhesiologie.<br>
     * FR: Code de anesthésiologie.<br>
     * IT: Code per anestesiologia.<br>
     */
    public static final String ANAESTHESIOLOGY_CODE = "394577000";

    /**
     * EN: Code for Cardiac surgery.<br>
     * DE: Code für Herzchirurgie.<br>
     * FR: Code de chirurgie cardiovasculaire.<br>
     * IT: Code per chirurgia cardiovascolare.<br>
     */
    public static final String CARDIAC_SURGERY_CODE = "408466002";

    /**
     * EN: Code for Cardiology.<br>
     * DE: Code für Kardiologie.<br>
     * FR: Code de cardiologie.<br>
     * IT: Code per cardiologia.<br>
     */
    public static final String CARDIOLOGY_CODE = "394579002";

    /**
     * EN: Code for Chiropractic service.<br>
     * DE: Code für Chiropraktik.<br>
     * FR: Code de chiropractie.<br>
     * IT: Code per chiropratica.<br>
     */
    public static final String CHIROPRACTIC_SERVICE_CODE = "722170006";

    /**
     * EN: Code for Clinical genetics.<br>
     * DE: Code für Medizinische Genetik.<br>
     * FR: Code de génétique médicale.<br>
     * IT: Code per genetica medica.<br>
     */
    public static final String CLINICAL_GENETICS_CODE = "394580004";

    /**
     * EN: Code for Clinical haematology.<br>
     * DE: Code für Hämatologie.<br>
     * FR: Code de hématologie.<br>
     * IT: Code per ematologia.<br>
     */
    public static final String CLINICAL_HAEMATOLOGY_CODE = "394803006";

    /**
     * EN: Code for Clinical immunology.<br>
     * DE: Code für Immunologie.<br>
     * FR: Code de immunologie.<br>
     * IT: Code per immunologia.<br>
     */
    public static final String CLINICAL_IMMUNOLOGY_CODE = "408480009";

    /**
     * EN: Code for Clinical immunology/allergy.<br>
     * DE: Code für Immunologie/Allergologie.<br>
     * FR: Code de immunologie/allergologie.<br>
     * IT: Code per allergologia e immunologia clinica.<br>
     */
    public static final String CLINICAL_IMMUNOLOGY_ALLERGY_CODE = "394805004";

    /**
     * EN: Code for Clinical oncology.<br>
     * DE: Code für Onkologie.<br>
     * FR: Code de oncologie.<br>
     * IT: Code per oncologia medica.<br>
     */
    public static final String CLINICAL_ONCOLOGY_CODE = "394592004";

    /**
     * EN: Code for Clinical pharmacology.<br>
     * DE: Code für Klinische Pharmakologie.<br>
     * FR: Code de pharmacologie clinique.<br>
     * IT: Code per farmacologia clinica.<br>
     */
    public static final String CLINICAL_PHARMACOLOGY_CODE = "394600006";

    /**
     * EN: Code for Complementary therapy.<br>
     * DE: Code für Komplementärmedizin.<br>
     * FR: Code de médecine alternative et complémentaire.<br>
     * IT: Code per medicina complementare.<br>
     */
    public static final String COMPLEMENTARY_THERAPY_CODE = "310025004";

    /**
     * EN: Code for Critical care medicine.<br>
     * DE: Code für Intensivmedizin.<br>
     * FR: Code de médecine intensive.<br>
     * IT: Code per medicina intensiva.<br>
     */
    public static final String CRITICAL_CARE_MEDICINE_CODE = "408478003";

    /**
     * EN: Code for Dental medicine.<br>
     * DE: Code für Zahnheilkunde.<br>
     * FR: Code de odontologie.<br>
     * IT: Code per odontoiatria.<br>
     */
    public static final String DENTAL_MEDICINE_CODE = "394812008";

    /**
     * EN: Code for Dentistry.<br>
     * DE: Code für Zahnmedizin.<br>
     * FR: Code de dentisterie.<br>
     * IT: Code per odontoiatria.<br>
     */
    public static final String DENTISTRY_CODE = "722163006";

    /**
     * EN: Code for Dermatology.<br>
     * DE: Code für Dermatologie und Venerologie.<br>
     * FR: Code de dermatologie et vénérologie.<br>
     * IT: Code per dermatologia e venereologia.<br>
     */
    public static final String DERMATOLOGY_CODE = "394582007";

    /**
     * EN: Code for Dietetics and nutrition.<br>
     * DE: Code für Ernährungsberatung.<br>
     * FR: Code de conseil en nutrition et diététique.<br>
     * IT: Code per dietetica.<br>
     */
    public static final String DIETETICS_AND_NUTRITION_CODE = "722164000";

    /**
     * EN: Code for Emergency medicine.<br>
     * DE: Code für Notfallmedizin.<br>
     * FR: Code de médecine d'urgence.<br>
     * IT: Code per medicina d'urgenza.<br>
     */
    public static final String EMERGENCY_MEDICINE_CODE = "773568002";

    /**
     * EN: Code for Endocrinology.<br>
     * DE: Code für Endokrinologie/Diabetologie.<br>
     * FR: Code de endocrinologie/diabétologie.<br>
     * IT: Code per endocrinologia/diabetologia.<br>
     */
    public static final String ENDOCRINOLOGY_CODE = "394583002";

    /**
     * EN: Code for Gastroenterology.<br>
     * DE: Code für Gastroenterologie.<br>
     * FR: Code de gastroentérologie.<br>
     * IT: Code per gastroenterologia.<br>
     */
    public static final String GASTROENTEROLOGY_CODE = "394584008";

    /**
     * EN: Code for General medicine.<br>
     * DE: Code für Allgemeinmedizin.<br>
     * FR: Code de médecine générale.<br>
     * IT: Code per medicina generale.<br>
     */
    public static final String GENERAL_MEDICINE_CODE = "394802001";

    /**
     * EN: Code for General surgery.<br>
     * DE: Code für Chirurgie.<br>
     * FR: Code de chirurgie.<br>
     * IT: Code per chirurgia.<br>
     */
    public static final String GENERAL_SURGERY_CODE = "394609007";

    /**
     * EN: Code for Geriatric medicine.<br>
     * DE: Code für Geriatrie.<br>
     * FR: Code de gériatrie.<br>
     * IT: Code per geriatria.<br>
     */
    public static final String GERIATRIC_MEDICINE_CODE = "394811001";

    /**
     * EN: Code for Gynecology and obstetrics.<br>
     * DE: Code für Gynäkologie.<br>
     * FR: Code de gynécologie.<br>
     * IT: Code per ginecologia.<br>
     */
    public static final String GYNECOLOGY_AND_OBSTETRICS_CODE = "394586005";

    /**
     * EN: Code for Infectious diseases.<br>
     * DE: Code für Infektionskrankheiten.<br>
     * FR: Code de maladies infectieuses.<br>
     * IT: Code per malattia infettiva.<br>
     */
    public static final String INFECTIOUS_DISEASES_CODE = "394807007";

    /**
     * EN: Code for Internal medicine.<br>
     * DE: Code für Innere Medizin.<br>
     * FR: Code de médecine interne.<br>
     * IT: Code per medicina interna.<br>
     */
    public static final String INTERNAL_MEDICINE_CODE = "419192003";

    /**
     * EN: Code for Laboratory service.<br>
     * DE: Code für Labormedizin.<br>
     * FR: Code de médecin de laboratoire.<br>
     * IT: Code per medicina di laboratorio.<br>
     */
    public static final String LABORATORY_SERVICE_CODE = "708184003";

    /**
     * EN: Code for Legal medicine.<br>
     * DE: Code für Rechtsmedizin.<br>
     * FR: Code de médecine légale.<br>
     * IT: Code per medicina legale.<br>
     */
    public static final String LEGAL_MEDICINE_CODE = "722204007";

    /**
     * EN: Code for Nephrology.<br>
     * DE: Code für Nephrologie.<br>
     * FR: Code de néphrologie.<br>
     * IT: Code per nefrologia.<br>
     */
    public static final String NEPHROLOGY_CODE = "394589003";

    /**
     * EN: Code for Neurology.<br>
     * DE: Code für Neurologie.<br>
     * FR: Code de neurologie.<br>
     * IT: Code per neurologia.<br>
     */
    public static final String NEUROLOGY_CODE = "394591006";

    /**
     * EN: Code for Neurosurgery.<br>
     * DE: Code für Neurochirurgie.<br>
     * FR: Code de neurochirurgie.<br>
     * IT: Code per neurochirurgia.<br>
     */
    public static final String NEUROSURGERY_CODE = "394610002";

    /**
     * EN: Code for Nuclear medicine.<br>
     * DE: Code für Nuklearmedizin.<br>
     * FR: Code de médecine nucléaire.<br>
     * IT: Code per medicina nucleare.<br>
     */
    public static final String NUCLEAR_MEDICINE_CODE = "394649004";

    /**
     * EN: Code for Nursing.<br>
     * DE: Code für Pflege.<br>
     * FR: Code de soins.<br>
     * IT: Code per cure infermieristiche.<br>
     */
    public static final String NURSING_CODE = "722165004";

    /**
     * EN: Code for Obstetrics.<br>
     * DE: Code für Geburtshilfe.<br>
     * FR: Code de obstétrique.<br>
     * IT: Code per ostetricia.<br>
     */
    public static final String OBSTETRICS_CODE = "408470005";

    /**
     * EN: Code for Occupational therapy service.<br>
     * DE: Code für Ergotherapie.<br>
     * FR: Code de ergothérapie.<br>
     * IT: Code per ergoterapia.<br>
     */
    public static final String OCCUPATIONAL_THERAPY_SERVICE_CODE = "310093001";

    /**
     * EN: Code for Ophthalmology.<br>
     * DE: Code für Ophthalmologie.<br>
     * FR: Code de ophtalmologie.<br>
     * IT: Code per oftalmologia.<br>
     */
    public static final String OPHTHALMOLOGY_CODE = "394594003";

    /**
     * EN: Code for Oral and maxillofacial surgery.<br>
     * DE: Code für Mund-, Kiefer- und Gesichtschirurgie.<br>
     * FR: Code de chirurgie dento-maxillo-faciale.<br>
     * IT: Code per chirurgia oro-maxillo-facciale.<br>
     */
    public static final String ORAL_AND_MAXILLOFACIAL_SURGERY_CODE = "408465003";

    /**
     * EN: Code for Osteopathic manipulative medicine.<br>
     * DE: Code für Osteopathie.<br>
     * FR: Code de ostéopathie.<br>
     * IT: Code per osteopatia.<br>
     */
    public static final String OSTEOPATHIC_MANIPULATIVE_MEDICINE_CODE = "416304004";

    /**
     * EN: Code for Other clinical specialty.<br>
     * DE: Code für Andere nicht näher spezifizierte medizinische Fachrichtung.<br>
     * FR: Code de autres spécialisations non spécifiées.<br>
     * IT: Code per altre specialità mediche non meglio precisate.<br>
     */
    public static final String OTHER_CLINICAL_SPECIALTY_CODE = "394658006";

    /**
     * EN: Code for Otolaryngology.<br>
     * DE: Code für Oto-Rhino-Laryngologie.<br>
     * FR: Code de oto-rhino-laryngologie.<br>
     * IT: Code per otorinolaringoiatria.<br>
     */
    public static final String OTOLARYNGOLOGY_CODE = "418960008";

    /**
     * EN: Code for Palliative medicine.<br>
     * DE: Code für Palliativmedizin.<br>
     * FR: Code de médecine palliative.<br>
     * IT: Code per medicina palliativa.<br>
     */
    public static final String PALLIATIVE_MEDICINE_CODE = "394806003";

    /**
     * EN: Code for Pathology.<br>
     * DE: Code für Pathologie.<br>
     * FR: Code de pathologie.<br>
     * IT: Code per patologia.<br>
     */
    public static final String PATHOLOGY_CODE = "394595002";

    /**
     * EN: Code for Pediatrics.<br>
     * DE: Code für Pädiatrie.<br>
     * FR: Code de pédiatrie.<br>
     * IT: Code per pediatria.<br>
     */
    public static final String PEDIATRICS_CODE = "394537008";

    /**
     * EN: Code for Pharmacy service.<br>
     * DE: Code für Pharmazeutische Dienstleistungen.<br>
     * FR: Code de service pharmaceutique.<br>
     * IT: Code per servizio farmaceutico.<br>
     */
    public static final String PHARMACY_SERVICE_CODE = "310080006";

    /**
     * EN: Code for Physiotherapy.<br>
     * DE: Code für Physiotherapie.<br>
     * FR: Code de physiothérapie.<br>
     * IT: Code per fisioterapia.<br>
     */
    public static final String PHYSIOTHERAPY_CODE = "722138006";

    /**
     * EN: Code for Plastic surgery.<br>
     * DE: Code für Plastische, Rekonstruktive und Ästhetische Chirurgie.<br>
     * FR: Code de chirurgie plastique, reconstructrice et esthétique.<br>
     * IT: Code per chirurgia plastica, ricostruttiva ed estetica.<br>
     */
    public static final String PLASTIC_SURGERY_CODE = "394611003";

    /**
     * EN: Code for Podiatry service.<br>
     * DE: Code für Podologie.<br>
     * FR: Code de podologie.<br>
     * IT: Code per podologia.<br>
     */
    public static final String PODIATRY_SERVICE_CODE = "310087009";

    /**
     * EN: Code for Preventive medicine.<br>
     * DE: Code für Präventionsmedizin.<br>
     * FR: Code de médecine préventive .<br>
     * IT: Code per prevenzione.<br>
     */
    public static final String PREVENTIVE_MEDICINE_CODE = "409968004";

    /**
     * EN: Code for Psychiatry.<br>
     * DE: Code für Psychiatrie und Psychotherapie.<br>
     * FR: Code de psychiatrie et psychothérapie.<br>
     * IT: Code per psichiatria e psicoterapia.<br>
     */
    public static final String PSYCHIATRY_CODE = "394587001";

    /**
     * EN: Code for Psychology.<br>
     * DE: Code für Psychologie.<br>
     * FR: Code de psychologie.<br>
     * IT: Code per psicologia.<br>
     */
    public static final String PSYCHOLOGY_CODE = "722162001";

    /**
     * EN: Code for Psychosomatic medicine.<br>
     * DE: Code für Psychosomatik.<br>
     * FR: Code de psychosomatique.<br>
     * IT: Code per medicina psicosomatica.<br>
     */
    public static final String PSYCHOSOMATIC_MEDICINE_CODE = "721961006";

    /**
     * EN: Code for Pulmonary medicine.<br>
     * DE: Code für Pneumologie.<br>
     * FR: Code de pneumologie.<br>
     * IT: Code per pneumologia.<br>
     */
    public static final String PULMONARY_MEDICINE_CODE = "418112009";

    /**
     * EN: Code for Radiation oncology.<br>
     * DE: Code für Radio-Onkologie.<br>
     * FR: Code de radio-oncologie.<br>
     * IT: Code per radio-oncologia.<br>
     */
    public static final String RADIATION_ONCOLOGY_CODE = "419815003";

    /**
     * EN: Code for Radiology.<br>
     * DE: Code für Radiologie.<br>
     * FR: Code de radiologie.<br>
     * IT: Code per radiologia.<br>
     */
    public static final String RADIOLOGY_CODE = "394914008";

    /**
     * EN: Code for Rehabilitation.<br>
     * DE: Code für Rehabilitation.<br>
     * FR: Code de réadaptation.<br>
     * IT: Code per riabilitazione.<br>
     */
    public static final String REHABILITATION_CODE = "394602003";

    /**
     * EN: Code for Rheumatology.<br>
     * DE: Code für Rheumatologie.<br>
     * FR: Code de rhumatologie.<br>
     * IT: Code per reumatologia.<br>
     */
    public static final String RHEUMATOLOGY_CODE = "394810000";

    /**
     * EN: Code for Speech and language therapy service.<br>
     * DE: Code für Logopädie.<br>
     * FR: Code de logopédie.<br>
     * IT: Code per logopedia.<br>
     */
    public static final String SPEECH_AND_LANGUAGE_THERAPY_SERVICE_CODE = "310101009";

    /**
     * EN: Code for Thoracic surgery.<br>
     * DE: Code für Thoraxchirurgie.<br>
     * FR: Code de chirurgie thoracique.<br>
     * IT: Code per chirurgia toracica.<br>
     */
    public static final String THORACIC_SURGERY_CODE = "408456005";

    /**
     * EN: Code for Transfusion medicine.<br>
     * DE: Code für Transfusionsmedizin.<br>
     * FR: Code de médecine transfusionnelle.<br>
     * IT: Code per medicina trasfusionale.<br>
     */
    public static final String TRANSFUSION_MEDICINE_CODE = "394819004";

    /**
     * EN: Code for Transplant surgery.<br>
     * DE: Code für Transplatationschirurgie.<br>
     * FR: Code de chirurgie de transplantation.<br>
     * IT: Code per chirurgia dei trapianti.<br>
     */
    public static final String TRANSPLANT_SURGERY_CODE = "408477008";

    /**
     * EN: Code for Trauma and orthopedics.<br>
     * DE: Code für Orthopädie und Traumatologie.<br>
     * FR: Code de chirurgie orthopédique et traumatologie de l'appareil locomoteur.<br>
     * IT: Code per chirurgia ortopedica e traumatologia dell'apparato locomotore.<br>
     */
    public static final String TRAUMA_AND_ORTHOPEDICS_CODE = "394801008";

    /**
     * EN: Code for Tropical medicine.<br>
     * DE: Code für Tropen- und Reisemedizin.<br>
     * FR: Code de médecine tropicale et des voyages.<br>
     * IT: Code per medicina tropicale e di viaggio.<br>
     */
    public static final String TROPICAL_MEDICINE_CODE = "408448007";

    /**
     * EN: Code for Urology.<br>
     * DE: Code für Urologie.<br>
     * FR: Code de urologie.<br>
     * IT: Code per urologia.<br>
     */
    public static final String UROLOGY_CODE = "394612005";

    /**
     * EN: Code for Vascular medicine.<br>
     * DE: Code für Angiologie.<br>
     * FR: Code de angiologie.<br>
     * IT: Code per angiologia.<br>
     */
    public static final String VASCULAR_MEDICINE_CODE = "722414000";

    /**
     * EN: Code for Vascular surgery.<br>
     * DE: Code für Gefässchirurgie.<br>
     * FR: Code de chirurgie vasculaire.<br>
     * IT: Code per chirurgia vascolare.<br>
     */
    public static final String VASCULAR_SURGERY_CODE = "408463005";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.18";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.practiceSettingCode";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "2.16.840.1.113883.6.96";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static PracticeSettingCode getEnum(@Nullable final String code) {
        for (final PracticeSettingCode x : values()) {
            if (x.getCodeValue().equals(code)) {
                return x;
            }
        }
        return null;
    }

    /**
     * Checks if a given enum is part of this value set.
     *
     * @param enumName The name of the enum.
     * @return {@code true} if the name is found in this value set, {@code false} otherwise.
     */
    public static boolean isEnumOfValueSet(@Nullable final String enumName) {
        if (enumName == null) {
            return false;
        }
        try {
            Enum.valueOf(PracticeSettingCode.class,
                         enumName);
            return true;
        } catch (final IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * Checks if a given code value is in this value set.
     *
     * @param codeValue The code value.
     * @return {@code true} if the value is found in this value set, {@code false} otherwise.
     */
    public static boolean isInValueSet(@Nullable final String codeValue) {
        for (final PracticeSettingCode x : values()) {
            if (x.getCodeValue().equals(codeValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Machine interpretable and (inside this class) unique code.
     */
    @NonNull
    private final String code;

    /**
     * Identifier of the referencing code system.
     */
    @NonNull
    private final String codeSystem;

    /**
     * The display names per language. It's always stored in the given order: default display name (0), in English (1),
     * in German (2), in French (3) and in Italian (4).
     */
    @NonNull
    private final String[] displayNames;

    /**
     * Instantiates this enum with a given code and display names.
     *
     * @param code          The code value.
     * @param codeSystem    The code system (OID).
     * @param displayName   The default display name.
     * @param displayNameEn The display name in English.
     * @param displayNameDe The display name in German.
     * @param displayNameFr The display name in French.
     * @param displayNameIt The display name in Italian.
     */
    PracticeSettingCode(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
        this.code = Objects.requireNonNull(code);
        this.codeSystem = Objects.requireNonNull(codeSystem);
        this.displayNames = new String[5];
        this.displayNames[0] = Objects.requireNonNull(displayName);
        this.displayNames[1] = Objects.requireNonNull(displayNameEn);
        this.displayNames[2] = Objects.requireNonNull(displayNameDe);
        this.displayNames[3] = Objects.requireNonNull(displayNameFr);
        this.displayNames[4] = Objects.requireNonNull(displayNameIt);
    }

    /**
     * Gets the code system identifier.
     *
     * @return the code system identifier.
     */
    @Override
    @NonNull
    public String getCodeSystemId() {
        return this.codeSystem;
    }

    /**
     * Gets the code system name.
     *
     * @return the code system name.
     */
    @Override
    @NonNull
    public String getCodeSystemName() {
        final var codeSystem = CodeSystems.getEnum(this.codeSystem);
        if (codeSystem != null) {
            return codeSystem.getCodeSystemName();
        }
        return "";
    }

    /**
     * Gets the code value as a string.
     *
     * @return the code value.
     */
    @Override
    @NonNull
    public String getCodeValue() {
        return this.code;
    }

    /**
     * Gets the display name defined by the language param.
     *
     * @param languageCode The language code to get the display name for, {@code null} to get the default display name.
     * @return the display name in the desired language.
     */
    @Override
    @NonNull
    public String getDisplayName(@Nullable final LanguageCode languageCode) {
        if (languageCode == null) {
            return this.displayNames[0];
        }
        return switch(languageCode) {
            case ENGLISH ->
                this.displayNames[1];
            case GERMAN ->
                this.displayNames[2];
            case FRENCH ->
                this.displayNames[3];
            case ITALIAN ->
                this.displayNames[4];
            default ->
                "TOTRANSLATE";
        };
    }

    /**
     * Gets the value set identifier.
     *
     * @return the value set identifier.
     */
    @Override
    @NonNull
    public String getValueSetId() {
        return VALUE_SET_ID;
    }

    /**
     * Gets the value set name.
     *
     * @return the value set name.
     */
    @Override
    @NonNull
    public String getValueSetName() {
        return VALUE_SET_NAME;
    }
}
