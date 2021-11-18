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
package org.husky.communication.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

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
 * Effective date: 2021-04-01 16:19<br>
 * Version: 202104.0-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-08-26")
public enum PracticeSettingCode implements ValueSetEnumInterface {

    /**
     * EN: Accident & emergency<br>
     * DE: Notfall- und Rettungsmedizin<br>
     * FR: Médecine d'urgence et de sauvetage<br>
     * IT: Medicina d'urgenza e di salvataggio<br>
     */
    ACCIDENT_EMERGENCY("394576009",
                       "2.16.840.1.113883.6.96",
                       "Accident & emergency (qualifier value)",
                       "Accident & emergency",
                       "Notfall- und Rettungsmedizin",
                       "Médecine d'urgence et de sauvetage",
                       "Medicina d'urgenza e di salvataggio"),
    /**
     * EN: Anaesthesiology<br>
     * DE: Anästhesiologie<br>
     * FR: Anesthésiologie<br>
     * IT: Anestesiologia<br>
     */
    ANAESTHESIOLOGY("394577000",
                    "2.16.840.1.113883.6.96",
                    "Anesthetics (qualifier value)",
                    "Anaesthesiology",
                    "Anästhesiologie",
                    "Anesthésiologie",
                    "Anestesiologia"),
    /**
     * EN: Cardiac surgery<br>
     * DE: Herzchirurgie<br>
     * FR: Chirurgie cardiovasculaire<br>
     * IT: Chirurgia cardiovascolare<br>
     */
    CARDIAC_SURGERY("408466002",
                    "2.16.840.1.113883.6.96",
                    "Cardiac surgery (qualifier value)",
                    "Cardiac surgery",
                    "Herzchirurgie",
                    "Chirurgie cardiovasculaire",
                    "Chirurgia cardiovascolare"),
    /**
     * EN: Cardiology<br>
     * DE: Kardiologie<br>
     * FR: Cardiologie<br>
     * IT: Cardiologia<br>
     */
    CARDIOLOGY("394579002",
               "2.16.840.1.113883.6.96",
               "Cardiology (qualifier value)",
               "Cardiology",
               "Kardiologie",
               "Cardiologie",
               "Cardiologia"),
    /**
     * EN: Chiropractic service<br>
     * DE: Chiropraktik<br>
     * FR: Chiropractie<br>
     * IT: Chiropratica<br>
     */
    CHIROPRACTIC_SERVICE("722170006",
                         "2.16.840.1.113883.6.96",
                         "Chiropractic service (qualifier value)",
                         "Chiropractic service",
                         "Chiropraktik",
                         "Chiropractie",
                         "Chiropratica"),
    /**
     * EN: Clinical genetics<br>
     * DE: Medizinische Genetik<br>
     * FR: Génétique médicale<br>
     * IT: Genetica medica<br>
     */
    CLINICAL_GENETICS("394580004",
                      "2.16.840.1.113883.6.96",
                      "Clinical genetics (qualifier value)",
                      "Clinical genetics",
                      "Medizinische Genetik",
                      "Génétique médicale",
                      "Genetica medica"),
    /**
     * EN: Clinical haematology<br>
     * DE: Hämatologie<br>
     * FR: Hématologie<br>
     * IT: Ematologia<br>
     */
    CLINICAL_HAEMATOLOGY("394803006",
                         "2.16.840.1.113883.6.96",
                         "Clinical hematology (qualifier value)",
                         "Clinical haematology",
                         "Hämatologie",
                         "Hématologie",
                         "Ematologia"),
    /**
     * EN: Clinical immunology<br>
     * DE: Immunologie<br>
     * FR: Immunologie<br>
     * IT: Immunologia<br>
     */
    CLINICAL_IMMUNOLOGY("408480009",
                        "2.16.840.1.113883.6.96",
                        "Clinical immunology (qualifier value)",
                        "Clinical immunology",
                        "Immunologie",
                        "Immunologie",
                        "Immunologia"),
    /**
     * EN: Clinical immunology/allergy<br>
     * DE: Immunologie/Allergologie<br>
     * FR: Immunologie/Allergologie<br>
     * IT: Allergologia e immunologia clinica<br>
     */
    CLINICAL_IMMUNOLOGY_ALLERGY("394805004",
                                "2.16.840.1.113883.6.96",
                                "Clinical immunology/allergy (qualifier value)",
                                "Clinical immunology/allergy",
                                "Immunologie/Allergologie",
                                "Immunologie/Allergologie",
                                "Allergologia e immunologia clinica"),
    /**
     * EN: Clinical oncology<br>
     * DE: Onkologie<br>
     * FR: Oncologie<br>
     * IT: Oncologia medica<br>
     */
    CLINICAL_ONCOLOGY("394592004",
                      "2.16.840.1.113883.6.96",
                      "Clinical oncology (qualifier value)",
                      "Clinical oncology",
                      "Onkologie",
                      "Oncologie",
                      "Oncologia medica"),
    /**
     * EN: Clinical pharmacology<br>
     * DE: Klinische Pharmakologie<br>
     * FR: Pharmacologie clinique<br>
     * IT: Farmacologia clinica<br>
     */
    CLINICAL_PHARMACOLOGY("394600006",
                          "2.16.840.1.113883.6.96",
                          "Clinical pharmacology (qualifier value)",
                          "Clinical pharmacology",
                          "Klinische Pharmakologie",
                          "Pharmacologie clinique",
                          "Farmacologia clinica"),
    /**
     * EN: Complementary therapy<br>
     * DE: Komplementärmedizin<br>
     * FR: Médecine alternative et complémentaire<br>
     * IT: Medicina complementare<br>
     */
    COMPLEMENTARY_THERAPY("310025004",
                          "2.16.840.1.113883.6.96",
                          "Complementary therapy service (qualifier value)",
                          "Complementary therapy",
                          "Komplementärmedizin",
                          "Médecine alternative et complémentaire",
                          "Medicina complementare"),
    /**
     * EN: Critical care medicine<br>
     * DE: Intensivmedizin<br>
     * FR: Médecine intensive<br>
     * IT: Medicina intensiva<br>
     */
    CRITICAL_CARE_MEDICINE("408478003",
                           "2.16.840.1.113883.6.96",
                           "Critical care medicine (qualifier value)",
                           "Critical care medicine",
                           "Intensivmedizin",
                           "Médecine intensive",
                           "Medicina intensiva"),
    /**
     * EN: Dental medicine<br>
     * DE: Zahnheilkunde<br>
     * FR: Odontologie<br>
     * IT: Odontoiatria<br>
     */
    DENTAL_MEDICINE("394812008",
                    "2.16.840.1.113883.6.96",
                    "Dental medicine specialties (qualifier value)",
                    "Dental medicine",
                    "Zahnheilkunde",
                    "Odontologie",
                    "Odontoiatria"),
    /**
     * EN: Dermatology<br>
     * DE: Dermatologie und Venerologie<br>
     * FR: Dermatologie et vénérologie<br>
     * IT: Dermatologia e venereologia<br>
     */
    DERMATOLOGY("394582007",
                "2.16.840.1.113883.6.96",
                "Dermatology (qualifier value)",
                "Dermatology",
                "Dermatologie und Venerologie",
                "Dermatologie et vénérologie",
                "Dermatologia e venereologia"),
    /**
     * EN: Dietetics and nutrition<br>
     * DE: Ernährungsberatung<br>
     * FR: Conseil en nutrition et diététique<br>
     * IT: Dietetica<br>
     */
    DIETETICS_AND_NUTRITION("722164000",
                            "2.16.840.1.113883.6.96",
                            "Dietetics and nutrition (qualifier value)",
                            "Dietetics and nutrition",
                            "Ernährungsberatung",
                            "Conseil en nutrition et diététique",
                            "Dietetica"),
    /**
     * EN: Endocrinology<br>
     * DE: Endokrinologie/Diabetologie<br>
     * FR: Endocrinologie/diabétologie<br>
     * IT: Endocrinologia/diabetologia<br>
     */
    ENDOCRINOLOGY("394583002",
                  "2.16.840.1.113883.6.96",
                  "Endocrinology (qualifier value)",
                  "Endocrinology",
                  "Endokrinologie/Diabetologie",
                  "Endocrinologie/diabétologie",
                  "Endocrinologia/diabetologia"),
    /**
     * EN: Gastroenterology<br>
     * DE: Gastroenterologie<br>
     * FR: Gastroentérologie<br>
     * IT: Gastroenterologia<br>
     */
    GASTROENTEROLOGY("394584008",
                     "2.16.840.1.113883.6.96",
                     "Gastroenterology (qualifier value)",
                     "Gastroenterology",
                     "Gastroenterologie",
                     "Gastroentérologie",
                     "Gastroenterologia"),
    /**
     * EN: General medicine<br>
     * DE: Allgemeinmedizin<br>
     * FR: Médecine générale<br>
     * IT: Medicina generale<br>
     */
    GENERAL_MEDICINE("394802001",
                     "2.16.840.1.113883.6.96",
                     "General medicine (qualifier value)",
                     "General medicine",
                     "Allgemeinmedizin",
                     "Médecine générale",
                     "Medicina generale"),
    /**
     * EN: General surgery<br>
     * DE: Chirurgie<br>
     * FR: Chirurgie<br>
     * IT: Chirurgia<br>
     */
    GENERAL_SURGERY("394609007",
                    "2.16.840.1.113883.6.96",
                    "General surgery (qualifier value)",
                    "General surgery",
                    "Chirurgie",
                    "Chirurgie",
                    "Chirurgia"),
    /**
     * EN: Geriatric medicine<br>
     * DE: Geriatrie<br>
     * FR: Gériatrie<br>
     * IT: Geriatria<br>
     */
    GERIATRIC_MEDICINE("394811001",
                       "2.16.840.1.113883.6.96",
                       "Geriatric medicine (qualifier value)",
                       "Geriatric medicine",
                       "Geriatrie",
                       "Gériatrie",
                       "Geriatria"),
    /**
     * EN: Gynecology and Obstretrics<br>
     * DE: Gynäkologie und Geburtshilfe<br>
     * FR: Gynécologie et obstétrique<br>
     * IT: Ginecologia e ostetricia<br>
     */
    GYNECOLOGY_AND_OBSTRETRICS("394586005",
                               "2.16.840.1.113883.6.96",
                               "Gynecology (qualifier value)",
                               "Gynecology and Obstretrics",
                               "Gynäkologie und Geburtshilfe",
                               "Gynécologie et obstétrique",
                               "Ginecologia e ostetricia"),
    /**
     * EN: Infectious diseases<br>
     * DE: Infektionskrankheiten<br>
     * FR: Maladies infectieuses<br>
     * IT: Malattia infettiva<br>
     */
    INFECTIOUS_DISEASES("394807007",
                        "2.16.840.1.113883.6.96",
                        "Infectious diseases (specialty) (qualifier value)",
                        "Infectious diseases",
                        "Infektionskrankheiten",
                        "Maladies infectieuses",
                        "Malattia infettiva"),
    /**
     * EN: Internal medicine<br>
     * DE: Innere Medizin<br>
     * FR: Médecine interne<br>
     * IT: Medicina interna<br>
     */
    INTERNAL_MEDICINE("419192003",
                      "2.16.840.1.113883.6.96",
                      "Internal medicine (qualifier value)",
                      "Internal medicine",
                      "Innere Medizin",
                      "Médecine interne",
                      "Medicina interna"),
    /**
     * EN: Laboratory service<br>
     * DE: Labormedizin<br>
     * FR: Médecin de laboratoire<br>
     * IT: Medicina di laboratorio<br>
     */
    LABORATORY_SERVICE("708184003",
                       "2.16.840.1.113883.6.96",
                       "Clinical pathology service (qualifier value)",
                       "Laboratory service",
                       "Labormedizin",
                       "Médecin de laboratoire",
                       "Medicina di laboratorio"),
    /**
     * EN: Legal medicine<br>
     * DE: Rechtsmedizin<br>
     * FR: Médecine légale<br>
     * IT: Medicina legale<br>
     */
    LEGAL_MEDICINE("722204007",
                   "2.16.840.1.113883.6.96",
                   "Legal medicine (qualifier value)",
                   "Legal medicine",
                   "Rechtsmedizin",
                   "Médecine légale",
                   "Medicina legale"),
    /**
     * EN: Nephrology<br>
     * DE: Nephrologie<br>
     * FR: Néphrologie<br>
     * IT: Nefrologia<br>
     */
    NEPHROLOGY("394589003",
               "2.16.840.1.113883.6.96",
               "Nephrology (qualifier value)",
               "Nephrology",
               "Nephrologie",
               "Néphrologie",
               "Nefrologia"),
    /**
     * EN: Neurology<br>
     * DE: Neurologie<br>
     * FR: Neurologie<br>
     * IT: Neurologia<br>
     */
    NEUROLOGY("394591006",
              "2.16.840.1.113883.6.96",
              "Neurology (qualifier value)",
              "Neurology",
              "Neurologie",
              "Neurologie",
              "Neurologia"),
    /**
     * EN: Neurosurgery<br>
     * DE: Neurochirurgie<br>
     * FR: Neurochirurgie<br>
     * IT: Neurochirurgia<br>
     */
    NEUROSURGERY("394610002",
                 "2.16.840.1.113883.6.96",
                 "Neurosurgery (qualifier value)",
                 "Neurosurgery",
                 "Neurochirurgie",
                 "Neurochirurgie",
                 "Neurochirurgia"),
    /**
     * EN: Nuclear medicine<br>
     * DE: Nuklearmedizin<br>
     * FR: Médecine nucléaire<br>
     * IT: Medicina nucleare<br>
     */
    NUCLEAR_MEDICINE("394649004",
                     "2.16.840.1.113883.6.96",
                     "Nuclear medicine - specialty (qualifier value)",
                     "Nuclear medicine",
                     "Nuklearmedizin",
                     "Médecine nucléaire",
                     "Medicina nucleare"),
    /**
     * EN: Nursing<br>
     * DE: Pflege<br>
     * FR: Soins<br>
     * IT: Cure infermieristiche<br>
     */
    NURSING("722165004",
            "2.16.840.1.113883.6.96",
            "Nursing (qualifier value)",
            "Nursing",
            "Pflege",
            "Soins",
            "Cure infermieristiche"),
    /**
     * EN: Occupational therapy service<br>
     * DE: Ergotherapie<br>
     * FR: Ergothérapie<br>
     * IT: Ergoterapia<br>
     */
    OCCUPATIONAL_THERAPY_SERVICE("310093001",
                                 "2.16.840.1.113883.6.96",
                                 "Occupational therapy service (qualifier value)",
                                 "Occupational therapy service",
                                 "Ergotherapie",
                                 "Ergothérapie",
                                 "Ergoterapia"),
    /**
     * EN: Ophthalmology<br>
     * DE: Ophthalmologie<br>
     * FR: Ophtalmologie<br>
     * IT: Oftalmologia<br>
     */
    OPHTHALMOLOGY("394594003",
                  "2.16.840.1.113883.6.96",
                  "Ophthalmology (qualifier value)",
                  "Ophthalmology",
                  "Ophthalmologie",
                  "Ophtalmologie",
                  "Oftalmologia"),
    /**
     * EN: Oral and maxillofacial surgery<br>
     * DE: Mund-, Kiefer- und Gesichtschirurgie<br>
     * FR: Chirurgie dento-maxillo-faciale<br>
     * IT: Chirurgia oro-maxillo-facciale<br>
     */
    ORAL_AND_MAXILLOFACIAL_SURGERY("408465003",
                                   "2.16.840.1.113883.6.96",
                                   "Oral and maxillofacial surgery (qualifier value)",
                                   "Oral and maxillofacial surgery",
                                   "Mund-, Kiefer- und Gesichtschirurgie",
                                   "Chirurgie dento-maxillo-faciale",
                                   "Chirurgia oro-maxillo-facciale"),
    /**
     * EN: Osteopathic manipulative medicine<br>
     * DE: Osteopathie<br>
     * FR: Ostéopathie<br>
     * IT: Osteopatia<br>
     */
    OSTEOPATHIC_MANIPULATIVE_MEDICINE("416304004",
                                      "2.16.840.1.113883.6.96",
                                      "Osteopathic manipulative medicine (qualifier value)",
                                      "Osteopathic manipulative medicine",
                                      "Osteopathie",
                                      "Ostéopathie",
                                      "Osteopatia"),
    /**
     * EN: Other clinical specialty<br>
     * DE: Andere nicht näher spezifizierte medizinische Fachrichtung<br>
     * FR: Autres spécialisations non spécifiées<br>
     * IT: Altre specialità mediche non meglio precisate<br>
     */
    OTHER_CLINICAL_SPECIALTY("394658006",
                             "2.16.840.1.113883.6.96",
                             "Clinical specialty (qualifier value)",
                             "Other clinical specialty",
                             "Andere nicht näher spezifizierte medizinische Fachrichtung",
                             "Autres spécialisations non spécifiées",
                             "Altre specialità mediche non meglio precisate"),
    /**
     * EN: Otolaryngology<br>
     * DE: Oto-Rhino-Laryngologie<br>
     * FR: Oto-rhino-laryngologie<br>
     * IT: Otorinolaringoiatria<br>
     */
    OTOLARYNGOLOGY("418960008",
                   "2.16.840.1.113883.6.96",
                   "Otolaryngology (qualifier value)",
                   "Otolaryngology",
                   "Oto-Rhino-Laryngologie",
                   "Oto-rhino-laryngologie",
                   "Otorinolaringoiatria"),
    /**
     * EN: Palliative medicine<br>
     * DE: Palliativmedizin<br>
     * FR: Médecine palliative<br>
     * IT: Medicina palliativa<br>
     */
    PALLIATIVE_MEDICINE("394806003",
                        "2.16.840.1.113883.6.96",
                        "Palliative medicine (qualifier value)",
                        "Palliative medicine",
                        "Palliativmedizin",
                        "Médecine palliative",
                        "Medicina palliativa"),
    /**
     * EN: Pathology<br>
     * DE: Pathologie<br>
     * FR: Pathologie<br>
     * IT: Patologia<br>
     */
    PATHOLOGY("394595002",
              "2.16.840.1.113883.6.96",
              "Pathology (qualifier value)",
              "Pathology",
              "Pathologie",
              "Pathologie",
              "Patologia"),
    /**
     * EN: Pediatrics<br>
     * DE: Pädiatrie<br>
     * FR: Pédiatrie<br>
     * IT: Pediatria<br>
     */
    PEDIATRICS("394537008",
               "2.16.840.1.113883.6.96",
               "Pediatric specialty (qualifier value)",
               "Pediatrics",
               "Pädiatrie",
               "Pédiatrie",
               "Pediatria"),
    /**
     * EN: Pharmacy service<br>
     * DE: Pharmazie-Dienstleistung<br>
     * FR: Service pharmaceutique<br>
     * IT: Farmacia<br>
     */
    PHARMACY_SERVICE("310080006",
                     "2.16.840.1.113883.6.96",
                     "Pharmacy service (qualifier value)",
                     "Pharmacy service",
                     "Pharmazie-Dienstleistung",
                     "Service pharmaceutique",
                     "Farmacia"),
    /**
     * EN: Physiotherapy<br>
     * DE: Physiotherapie<br>
     * FR: Physiothérapie<br>
     * IT: Fisioterapia<br>
     */
    PHYSIOTHERAPY("722138006",
                  "2.16.840.1.113883.6.96",
                  "Physiotherapy (qualifier value)",
                  "Physiotherapy",
                  "Physiotherapie",
                  "Physiothérapie",
                  "Fisioterapia"),
    /**
     * EN: Plastic surgery<br>
     * DE: Plastische, Rekonstruktive und Ästhetische Chirurgie<br>
     * FR: Chirurgie plastique, reconstructrice et esthétique<br>
     * IT: Chirurgia plastica, ricostruttiva ed estetica<br>
     */
    PLASTIC_SURGERY("394611003",
                    "2.16.840.1.113883.6.96",
                    "Plastic surgery - specialty (qualifier value)",
                    "Plastic surgery",
                    "Plastische, Rekonstruktive und Ästhetische Chirurgie",
                    "Chirurgie plastique, reconstructrice et esthétique",
                    "Chirurgia plastica, ricostruttiva ed estetica"),
    /**
     * EN: Podiatry service<br>
     * DE: Podologie<br>
     * FR: Podologie<br>
     * IT: Podologia<br>
     */
    PODIATRY_SERVICE("310087009",
                     "2.16.840.1.113883.6.96",
                     "Podiatry service (qualifier value)",
                     "Podiatry service",
                     "Podologie",
                     "Podologie",
                     "Podologia"),
    /**
     * EN: Preventive medicine<br>
     * DE: Präventionsmedizin<br>
     * FR: Médecine préventive <br>
     * IT: Prevenzione<br>
     */
    PREVENTIVE_MEDICINE("409968004",
                        "2.16.840.1.113883.6.96",
                        "Preventive medicine (qualifier value)",
                        "Preventive medicine",
                        "Präventionsmedizin",
                        "Médecine préventive ",
                        "Prevenzione"),
    /**
     * EN: Psychiatry<br>
     * DE: Psychiatrie und Psychotherapie<br>
     * FR: Psychiatrie et psychothérapie<br>
     * IT: Psichiatria e psicoterapia<br>
     */
    PSYCHIATRY("394587001",
               "2.16.840.1.113883.6.96",
               "Psychiatry (qualifier value)",
               "Psychiatry",
               "Psychiatrie und Psychotherapie",
               "Psychiatrie et psychothérapie",
               "Psichiatria e psicoterapia"),
    /**
     * EN: Psychology<br>
     * DE: Psychologie<br>
     * FR: Psychologie<br>
     * IT: Psicologia<br>
     */
    PSYCHOLOGY("722162001",
               "2.16.840.1.113883.6.96",
               "Psychology (qualifier value)",
               "Psychology",
               "Psychologie",
               "Psychologie",
               "Psicologia"),
    /**
     * EN: Psycho-Somatic medicine<br>
     * DE: Psychosomatik<br>
     * FR: Psychosomatique<br>
     * IT: Medicina psicosomatica<br>
     */
    PSYCHO_SOMATIC_MEDICINE("721961006",
                            "2.16.840.1.113883.6.96",
                            "Psychosomatic medicine (qualifier value)",
                            "Psycho-Somatic medicine",
                            "Psychosomatik",
                            "Psychosomatique",
                            "Medicina psicosomatica"),
    /**
     * EN: Pulmonary medicine<br>
     * DE: Pneumologie<br>
     * FR: Pneumologie<br>
     * IT: Pneumologia<br>
     */
    PULMONARY_MEDICINE("418112009",
                       "2.16.840.1.113883.6.96",
                       "Pulmonary medicine (qualifier value)",
                       "Pulmonary medicine",
                       "Pneumologie",
                       "Pneumologie",
                       "Pneumologia"),
    /**
     * EN: Radiation oncology<br>
     * DE: Radio-Onkologie/Strahlentherapie<br>
     * FR: Radio-oncologie / radiothérapie<br>
     * IT: Radio-oncologia / radioterapia<br>
     */
    RADIATION_ONCOLOGY("419815003",
                       "2.16.840.1.113883.6.96",
                       "Radiation oncology (qualifier value)",
                       "Radiation oncology",
                       "Radio-Onkologie/Strahlentherapie",
                       "Radio-oncologie / radiothérapie",
                       "Radio-oncologia / radioterapia"),
    /**
     * EN: Radiology<br>
     * DE: Radiologie<br>
     * FR: Radiologie<br>
     * IT: Radiologia<br>
     */
    RADIOLOGY("394914008",
              "2.16.840.1.113883.6.96",
              "Radiology - specialty (qualifier value)",
              "Radiology",
              "Radiologie",
              "Radiologie",
              "Radiologia"),
    /**
     * EN: Rehabilitation<br>
     * DE: Rehabilitation<br>
     * FR: Réadaptation<br>
     * IT: Riabilitazione<br>
     */
    REHABILITATION("394602003",
                   "2.16.840.1.113883.6.96",
                   "Rehabilitation - specialty (qualifier value)",
                   "Rehabilitation",
                   "Rehabilitation",
                   "Réadaptation",
                   "Riabilitazione"),
    /**
     * EN: Rheumatology<br>
     * DE: Rheumatologie<br>
     * FR: Rhumatologie<br>
     * IT: Reumatologia<br>
     */
    RHEUMATOLOGY("394810000",
                 "2.16.840.1.113883.6.96",
                 "Rheumatology (qualifier value)",
                 "Rheumatology",
                 "Rheumatologie",
                 "Rhumatologie",
                 "Reumatologia"),
    /**
     * EN: Speech and language therapy service<br>
     * DE: Logopädie<br>
     * FR: Logopédie<br>
     * IT: Logopedia<br>
     */
    SPEECH_AND_LANGUAGE_THERAPY_SERVICE("310101009",
                                        "2.16.840.1.113883.6.96",
                                        "Speech and language therapy service (qualifier value)",
                                        "Speech and language therapy service",
                                        "Logopädie",
                                        "Logopédie",
                                        "Logopedia"),
    /**
     * EN: Thoracic surgery<br>
     * DE: Thoraxchirurgie<br>
     * FR: Chirurgie thoracique<br>
     * IT: Chirurgia toracica<br>
     */
    THORACIC_SURGERY("408456005",
                     "2.16.840.1.113883.6.96",
                     "Thoracic surgery (qualifier value)",
                     "Thoracic surgery",
                     "Thoraxchirurgie",
                     "Chirurgie thoracique",
                     "Chirurgia toracica"),
    /**
     * EN: Transfusion medicine<br>
     * DE: Transfusionsmedizin<br>
     * FR: Médecine transfusionnelle<br>
     * IT: Medicina trasfusionale<br>
     */
    TRANSFUSION_MEDICINE("394819004",
                         "2.16.840.1.113883.6.96",
                         "Blood transfusion (specialty) (qualifier value)",
                         "Transfusion medicine",
                         "Transfusionsmedizin",
                         "Médecine transfusionnelle",
                         "Medicina trasfusionale"),
    /**
     * EN: Transplant surgery<br>
     * DE: Transplantationsmedizin<br>
     * FR: Médecine de la transplantation<br>
     * IT: Medicina dei trapianti<br>
     */
    TRANSPLANT_SURGERY("408477008",
                       "2.16.840.1.113883.6.96",
                       "Transplantation surgery (qualifier value)",
                       "Transplant surgery",
                       "Transplantationsmedizin",
                       "Médecine de la transplantation",
                       "Medicina dei trapianti"),
    /**
     * EN: Trauma and orthopedics<br>
     * DE: Orthopädie und Traumatologie<br>
     * FR: Chirurgie orthopédique et traumatologie de l'appareil locomoteur<br>
     * IT: Chirurgia ortopedica e traumatologia dell'apparato locomotore<br>
     */
    TRAUMA_AND_ORTHOPEDICS("394801008",
                           "2.16.840.1.113883.6.96",
                           "Trauma and orthopedics (qualifier value)",
                           "Trauma and orthopedics",
                           "Orthopädie und Traumatologie",
                           "Chirurgie orthopédique et traumatologie de l'appareil locomoteur",
                           "Chirurgia ortopedica e traumatologia dell'apparato locomotore"),
    /**
     * EN: Tropical medicine<br>
     * DE: Tropen- und Reisemedizin<br>
     * FR: Médecine tropicale et des voyages<br>
     * IT: Medicina tropicale e di viaggio<br>
     */
    TROPICAL_MEDICINE("408448007",
                      "2.16.840.1.113883.6.96",
                      "Tropical medicine (qualifier value)",
                      "Tropical medicine",
                      "Tropen- und Reisemedizin",
                      "Médecine tropicale et des voyages",
                      "Medicina tropicale e di viaggio"),
    /**
     * EN: Urology<br>
     * DE: Urologie<br>
     * FR: Urologie<br>
     * IT: Urologia<br>
     */
    UROLOGY("394612005",
            "2.16.840.1.113883.6.96",
            "Urology (qualifier value)",
            "Urology",
            "Urologie",
            "Urologie",
            "Urologia"),
    /**
     * EN: Vascular medicine<br>
     * DE: Angiologie<br>
     * FR: Angiologie<br>
     * IT: Angiologia<br>
     */
    VASCULAR_MEDICINE("722414000",
                      "2.16.840.1.113883.6.96",
                      "Vascular medicine (qualifier value)",
                      "Vascular medicine",
                      "Angiologie",
                      "Angiologie",
                      "Angiologia");

    /**
     * EN: Code for Accident & emergency<br>
     * DE: Code für Notfall- und Rettungsmedizin<br>
     * FR: Code de Médecine d'urgence et de sauvetage<br>
     * IT: Code per Medicina d'urgenza e di salvataggio<br>
     */
    public static final String ACCIDENT_EMERGENCY_CODE = "394576009";

    /**
     * EN: Code for Anaesthesiology<br>
     * DE: Code für Anästhesiologie<br>
     * FR: Code de Anesthésiologie<br>
     * IT: Code per Anestesiologia<br>
     */
    public static final String ANAESTHESIOLOGY_CODE = "394577000";

    /**
     * EN: Code for Cardiac surgery<br>
     * DE: Code für Herzchirurgie<br>
     * FR: Code de Chirurgie cardiovasculaire<br>
     * IT: Code per Chirurgia cardiovascolare<br>
     */
    public static final String CARDIAC_SURGERY_CODE = "408466002";

    /**
     * EN: Code for Cardiology<br>
     * DE: Code für Kardiologie<br>
     * FR: Code de Cardiologie<br>
     * IT: Code per Cardiologia<br>
     */
    public static final String CARDIOLOGY_CODE = "394579002";

    /**
     * EN: Code for Chiropractic service<br>
     * DE: Code für Chiropraktik<br>
     * FR: Code de Chiropractie<br>
     * IT: Code per Chiropratica<br>
     */
    public static final String CHIROPRACTIC_SERVICE_CODE = "722170006";

    /**
     * EN: Code for Clinical genetics<br>
     * DE: Code für Medizinische Genetik<br>
     * FR: Code de Génétique médicale<br>
     * IT: Code per Genetica medica<br>
     */
    public static final String CLINICAL_GENETICS_CODE = "394580004";

    /**
     * EN: Code for Clinical haematology<br>
     * DE: Code für Hämatologie<br>
     * FR: Code de Hématologie<br>
     * IT: Code per Ematologia<br>
     */
    public static final String CLINICAL_HAEMATOLOGY_CODE = "394803006";

    /**
     * EN: Code for Clinical immunology<br>
     * DE: Code für Immunologie<br>
     * FR: Code de Immunologie<br>
     * IT: Code per Immunologia<br>
     */
    public static final String CLINICAL_IMMUNOLOGY_CODE = "408480009";

    /**
     * EN: Code for Clinical immunology/allergy<br>
     * DE: Code für Immunologie/Allergologie<br>
     * FR: Code de Immunologie/Allergologie<br>
     * IT: Code per Allergologia e immunologia clinica<br>
     */
    public static final String CLINICAL_IMMUNOLOGY_ALLERGY_CODE = "394805004";

    /**
     * EN: Code for Clinical oncology<br>
     * DE: Code für Onkologie<br>
     * FR: Code de Oncologie<br>
     * IT: Code per Oncologia medica<br>
     */
    public static final String CLINICAL_ONCOLOGY_CODE = "394592004";

    /**
     * EN: Code for Clinical pharmacology<br>
     * DE: Code für Klinische Pharmakologie<br>
     * FR: Code de Pharmacologie clinique<br>
     * IT: Code per Farmacologia clinica<br>
     */
    public static final String CLINICAL_PHARMACOLOGY_CODE = "394600006";

    /**
     * EN: Code for Complementary therapy<br>
     * DE: Code für Komplementärmedizin<br>
     * FR: Code de Médecine alternative et complémentaire<br>
     * IT: Code per Medicina complementare<br>
     */
    public static final String COMPLEMENTARY_THERAPY_CODE = "310025004";

    /**
     * EN: Code for Critical care medicine<br>
     * DE: Code für Intensivmedizin<br>
     * FR: Code de Médecine intensive<br>
     * IT: Code per Medicina intensiva<br>
     */
    public static final String CRITICAL_CARE_MEDICINE_CODE = "408478003";

    /**
     * EN: Code for Dental medicine<br>
     * DE: Code für Zahnheilkunde<br>
     * FR: Code de Odontologie<br>
     * IT: Code per Odontoiatria<br>
     */
    public static final String DENTAL_MEDICINE_CODE = "394812008";

    /**
     * EN: Code for Dermatology<br>
     * DE: Code für Dermatologie und Venerologie<br>
     * FR: Code de Dermatologie et vénérologie<br>
     * IT: Code per Dermatologia e venereologia<br>
     */
    public static final String DERMATOLOGY_CODE = "394582007";

    /**
     * EN: Code for Dietetics and nutrition<br>
     * DE: Code für Ernährungsberatung<br>
     * FR: Code de Conseil en nutrition et diététique<br>
     * IT: Code per Dietetica<br>
     */
    public static final String DIETETICS_AND_NUTRITION_CODE = "722164000";

    /**
     * EN: Code for Endocrinology<br>
     * DE: Code für Endokrinologie/Diabetologie<br>
     * FR: Code de Endocrinologie/diabétologie<br>
     * IT: Code per Endocrinologia/diabetologia<br>
     */
    public static final String ENDOCRINOLOGY_CODE = "394583002";

    /**
     * EN: Code for Gastroenterology<br>
     * DE: Code für Gastroenterologie<br>
     * FR: Code de Gastroentérologie<br>
     * IT: Code per Gastroenterologia<br>
     */
    public static final String GASTROENTEROLOGY_CODE = "394584008";

    /**
     * EN: Code for General medicine<br>
     * DE: Code für Allgemeinmedizin<br>
     * FR: Code de Médecine générale<br>
     * IT: Code per Medicina generale<br>
     */
    public static final String GENERAL_MEDICINE_CODE = "394802001";

    /**
     * EN: Code for General surgery<br>
     * DE: Code für Chirurgie<br>
     * FR: Code de Chirurgie<br>
     * IT: Code per Chirurgia<br>
     */
    public static final String GENERAL_SURGERY_CODE = "394609007";

    /**
     * EN: Code for Geriatric medicine<br>
     * DE: Code für Geriatrie<br>
     * FR: Code de Gériatrie<br>
     * IT: Code per Geriatria<br>
     */
    public static final String GERIATRIC_MEDICINE_CODE = "394811001";

    /**
     * EN: Code for Gynecology and Obstretrics<br>
     * DE: Code für Gynäkologie und Geburtshilfe<br>
     * FR: Code de Gynécologie et obstétrique<br>
     * IT: Code per Ginecologia e ostetricia<br>
     */
    public static final String GYNECOLOGY_AND_OBSTRETRICS_CODE = "394586005";

    /**
     * EN: Code for Infectious diseases<br>
     * DE: Code für Infektionskrankheiten<br>
     * FR: Code de Maladies infectieuses<br>
     * IT: Code per Malattia infettiva<br>
     */
    public static final String INFECTIOUS_DISEASES_CODE = "394807007";

    /**
     * EN: Code for Internal medicine<br>
     * DE: Code für Innere Medizin<br>
     * FR: Code de Médecine interne<br>
     * IT: Code per Medicina interna<br>
     */
    public static final String INTERNAL_MEDICINE_CODE = "419192003";

    /**
     * EN: Code for Laboratory service<br>
     * DE: Code für Labormedizin<br>
     * FR: Code de Médecin de laboratoire<br>
     * IT: Code per Medicina di laboratorio<br>
     */
    public static final String LABORATORY_SERVICE_CODE = "708184003";

    /**
     * EN: Code for Legal medicine<br>
     * DE: Code für Rechtsmedizin<br>
     * FR: Code de Médecine légale<br>
     * IT: Code per Medicina legale<br>
     */
    public static final String LEGAL_MEDICINE_CODE = "722204007";

    /**
     * EN: Code for Nephrology<br>
     * DE: Code für Nephrologie<br>
     * FR: Code de Néphrologie<br>
     * IT: Code per Nefrologia<br>
     */
    public static final String NEPHROLOGY_CODE = "394589003";

    /**
     * EN: Code for Neurology<br>
     * DE: Code für Neurologie<br>
     * FR: Code de Neurologie<br>
     * IT: Code per Neurologia<br>
     */
    public static final String NEUROLOGY_CODE = "394591006";

    /**
     * EN: Code for Neurosurgery<br>
     * DE: Code für Neurochirurgie<br>
     * FR: Code de Neurochirurgie<br>
     * IT: Code per Neurochirurgia<br>
     */
    public static final String NEUROSURGERY_CODE = "394610002";

    /**
     * EN: Code for Nuclear medicine<br>
     * DE: Code für Nuklearmedizin<br>
     * FR: Code de Médecine nucléaire<br>
     * IT: Code per Medicina nucleare<br>
     */
    public static final String NUCLEAR_MEDICINE_CODE = "394649004";

    /**
     * EN: Code for Nursing<br>
     * DE: Code für Pflege<br>
     * FR: Code de Soins<br>
     * IT: Code per Cure infermieristiche<br>
     */
    public static final String NURSING_CODE = "722165004";

    /**
     * EN: Code for Occupational therapy service<br>
     * DE: Code für Ergotherapie<br>
     * FR: Code de Ergothérapie<br>
     * IT: Code per Ergoterapia<br>
     */
    public static final String OCCUPATIONAL_THERAPY_SERVICE_CODE = "310093001";

    /**
     * EN: Code for Ophthalmology<br>
     * DE: Code für Ophthalmologie<br>
     * FR: Code de Ophtalmologie<br>
     * IT: Code per Oftalmologia<br>
     */
    public static final String OPHTHALMOLOGY_CODE = "394594003";

    /**
     * EN: Code for Oral and maxillofacial surgery<br>
     * DE: Code für Mund-, Kiefer- und Gesichtschirurgie<br>
     * FR: Code de Chirurgie dento-maxillo-faciale<br>
     * IT: Code per Chirurgia oro-maxillo-facciale<br>
     */
    public static final String ORAL_AND_MAXILLOFACIAL_SURGERY_CODE = "408465003";

    /**
     * EN: Code for Osteopathic manipulative medicine<br>
     * DE: Code für Osteopathie<br>
     * FR: Code de Ostéopathie<br>
     * IT: Code per Osteopatia<br>
     */
    public static final String OSTEOPATHIC_MANIPULATIVE_MEDICINE_CODE = "416304004";

    /**
     * EN: Code for Other clinical specialty<br>
     * DE: Code für Andere nicht näher spezifizierte medizinische Fachrichtung<br>
     * FR: Code de Autres spécialisations non spécifiées<br>
     * IT: Code per Altre specialità mediche non meglio precisate<br>
     */
    public static final String OTHER_CLINICAL_SPECIALTY_CODE = "394658006";

    /**
     * EN: Code for Otolaryngology<br>
     * DE: Code für Oto-Rhino-Laryngologie<br>
     * FR: Code de Oto-rhino-laryngologie<br>
     * IT: Code per Otorinolaringoiatria<br>
     */
    public static final String OTOLARYNGOLOGY_CODE = "418960008";

    /**
     * EN: Code for Palliative medicine<br>
     * DE: Code für Palliativmedizin<br>
     * FR: Code de Médecine palliative<br>
     * IT: Code per Medicina palliativa<br>
     */
    public static final String PALLIATIVE_MEDICINE_CODE = "394806003";

    /**
     * EN: Code for Pathology<br>
     * DE: Code für Pathologie<br>
     * FR: Code de Pathologie<br>
     * IT: Code per Patologia<br>
     */
    public static final String PATHOLOGY_CODE = "394595002";

    /**
     * EN: Code for Pediatrics<br>
     * DE: Code für Pädiatrie<br>
     * FR: Code de Pédiatrie<br>
     * IT: Code per Pediatria<br>
     */
    public static final String PEDIATRICS_CODE = "394537008";

    /**
     * EN: Code for Pharmacy service<br>
     * DE: Code für Pharmazie-Dienstleistung<br>
     * FR: Code de Service pharmaceutique<br>
     * IT: Code per Farmacia<br>
     */
    public static final String PHARMACY_SERVICE_CODE = "310080006";

    /**
     * EN: Code for Physiotherapy<br>
     * DE: Code für Physiotherapie<br>
     * FR: Code de Physiothérapie<br>
     * IT: Code per Fisioterapia<br>
     */
    public static final String PHYSIOTHERAPY_CODE = "722138006";

    /**
     * EN: Code for Plastic surgery<br>
     * DE: Code für Plastische, Rekonstruktive und Ästhetische Chirurgie<br>
     * FR: Code de Chirurgie plastique, reconstructrice et esthétique<br>
     * IT: Code per Chirurgia plastica, ricostruttiva ed estetica<br>
     */
    public static final String PLASTIC_SURGERY_CODE = "394611003";

    /**
     * EN: Code for Podiatry service<br>
     * DE: Code für Podologie<br>
     * FR: Code de Podologie<br>
     * IT: Code per Podologia<br>
     */
    public static final String PODIATRY_SERVICE_CODE = "310087009";

    /**
     * EN: Code for Preventive medicine<br>
     * DE: Code für Präventionsmedizin<br>
     * FR: Code de Médecine préventive <br>
     * IT: Code per Prevenzione<br>
     */
    public static final String PREVENTIVE_MEDICINE_CODE = "409968004";

    /**
     * EN: Code for Psychiatry<br>
     * DE: Code für Psychiatrie und Psychotherapie<br>
     * FR: Code de Psychiatrie et psychothérapie<br>
     * IT: Code per Psichiatria e psicoterapia<br>
     */
    public static final String PSYCHIATRY_CODE = "394587001";

    /**
     * EN: Code for Psychology<br>
     * DE: Code für Psychologie<br>
     * FR: Code de Psychologie<br>
     * IT: Code per Psicologia<br>
     */
    public static final String PSYCHOLOGY_CODE = "722162001";

    /**
     * EN: Code for Psycho-Somatic medicine<br>
     * DE: Code für Psychosomatik<br>
     * FR: Code de Psychosomatique<br>
     * IT: Code per Medicina psicosomatica<br>
     */
    public static final String PSYCHO_SOMATIC_MEDICINE_CODE = "721961006";

    /**
     * EN: Code for Pulmonary medicine<br>
     * DE: Code für Pneumologie<br>
     * FR: Code de Pneumologie<br>
     * IT: Code per Pneumologia<br>
     */
    public static final String PULMONARY_MEDICINE_CODE = "418112009";

    /**
     * EN: Code for Radiation oncology<br>
     * DE: Code für Radio-Onkologie/Strahlentherapie<br>
     * FR: Code de Radio-oncologie / radiothérapie<br>
     * IT: Code per Radio-oncologia / radioterapia<br>
     */
    public static final String RADIATION_ONCOLOGY_CODE = "419815003";

    /**
     * EN: Code for Radiology<br>
     * DE: Code für Radiologie<br>
     * FR: Code de Radiologie<br>
     * IT: Code per Radiologia<br>
     */
    public static final String RADIOLOGY_CODE = "394914008";

    /**
     * EN: Code for Rehabilitation<br>
     * DE: Code für Rehabilitation<br>
     * FR: Code de Réadaptation<br>
     * IT: Code per Riabilitazione<br>
     */
    public static final String REHABILITATION_CODE = "394602003";

    /**
     * EN: Code for Rheumatology<br>
     * DE: Code für Rheumatologie<br>
     * FR: Code de Rhumatologie<br>
     * IT: Code per Reumatologia<br>
     */
    public static final String RHEUMATOLOGY_CODE = "394810000";

    /**
     * EN: Code for Speech and language therapy service<br>
     * DE: Code für Logopädie<br>
     * FR: Code de Logopédie<br>
     * IT: Code per Logopedia<br>
     */
    public static final String SPEECH_AND_LANGUAGE_THERAPY_SERVICE_CODE = "310101009";

    /**
     * EN: Code for Thoracic surgery<br>
     * DE: Code für Thoraxchirurgie<br>
     * FR: Code de Chirurgie thoracique<br>
     * IT: Code per Chirurgia toracica<br>
     */
    public static final String THORACIC_SURGERY_CODE = "408456005";

    /**
     * EN: Code for Transfusion medicine<br>
     * DE: Code für Transfusionsmedizin<br>
     * FR: Code de Médecine transfusionnelle<br>
     * IT: Code per Medicina trasfusionale<br>
     */
    public static final String TRANSFUSION_MEDICINE_CODE = "394819004";

    /**
     * EN: Code for Transplant surgery<br>
     * DE: Code für Transplantationsmedizin<br>
     * FR: Code de Médecine de la transplantation<br>
     * IT: Code per Medicina dei trapianti<br>
     */
    public static final String TRANSPLANT_SURGERY_CODE = "408477008";

    /**
     * EN: Code for Trauma and orthopedics<br>
     * DE: Code für Orthopädie und Traumatologie<br>
     * FR: Code de Chirurgie orthopédique et traumatologie de l'appareil locomoteur<br>
     * IT: Code per Chirurgia ortopedica e traumatologia dell'apparato locomotore<br>
     */
    public static final String TRAUMA_AND_ORTHOPEDICS_CODE = "394801008";

    /**
     * EN: Code for Tropical medicine<br>
     * DE: Code für Tropen- und Reisemedizin<br>
     * FR: Code de Médecine tropicale et des voyages<br>
     * IT: Code per Medicina tropicale e di viaggio<br>
     */
    public static final String TROPICAL_MEDICINE_CODE = "408448007";

    /**
     * EN: Code for Urology<br>
     * DE: Code für Urologie<br>
     * FR: Code de Urologie<br>
     * IT: Code per Urologia<br>
     */
    public static final String UROLOGY_CODE = "394612005";

    /**
     * EN: Code for Vascular medicine<br>
     * DE: Code für Angiologie<br>
     * FR: Code de Angiologie<br>
     * IT: Code per Angiologia<br>
     */
    public static final String VASCULAR_MEDICINE_CODE = "722414000";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.18";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.practiceSettingCode";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    public static PracticeSettingCode getEnum(final String code) {
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
    public static boolean isEnumOfValueSet(final String enumName) {
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
    public static boolean isInValueSet(final String codeValue) {
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
    private String code;

    /**
     * Identifier of the referencing code system.
     */
    private String codeSystem;

    /**
     * The display names per language.
     */
    private Map<LanguageCode, String> displayNames;

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
    PracticeSettingCode(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
        this.code = code;
        this.codeSystem = codeSystem;
        this.displayNames = new HashMap<>();
        this.displayNames.put(null,
                              displayName);
        this.displayNames.put(LanguageCode.ENGLISH,
                              displayNameEn);
        this.displayNames.put(LanguageCode.GERMAN,
                              displayNameDe);
        this.displayNames.put(LanguageCode.FRENCH,
                              displayNameFr);
        this.displayNames.put(LanguageCode.ITALIAN,
                              displayNameIt);
    }

    /**
     * Gets the code system identifier.
     *
     * @return the code system identifier.
     */
    @Override
    public String getCodeSystemId() {
        return this.codeSystem;
    }

    /**
     * Gets the code system name.
     *
     * @return the code system identifier.
     */
    @Override
    public String getCodeSystemName() {
        final CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
        if (cs != null) {
            return cs.getCodeSystemName();
        }
        return "";
    }

    /**
     * Gets the code value as a string.
     *
     * @return the code value.
     */
    @Override
    public String getCodeValue() {
        return this.code;
    }

    /**
     * Gets the display name defined by the language param. If there is no english translation, the default display name
     *      is returned.
     *
     * @param languageCode The language code to get the display name for.
     * @return the display name in the desired language. if language not found, display name in german will be returned.
     */
    @Override
    public String getDisplayName(final LanguageCode languageCode) {
        final String displayName = this.displayNames.get(languageCode);
        if (displayName == null && languageCode == LanguageCode.ENGLISH) {
            return this.displayNames.get(null);
        }
        return displayName;
    }

    /**
     * Gets the value set identifier.
     *
     * @return the value set identifier.
     */
    @Override
    public String getValueSetId() {
        return VALUE_SET_ID;
    }

    /**
     * Gets the value set name.
     *
     * @return the value set name.
     */
    @Override
    public String getValueSetName() {
        return VALUE_SET_NAME;
    }
}
