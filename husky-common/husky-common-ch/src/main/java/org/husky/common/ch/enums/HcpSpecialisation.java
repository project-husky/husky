/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.husky.common.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of HCProfessional.hcSpecialisation values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.8.2<br>
 * Effective date: 2020-05-18 19:54<br>
 * Version: 202004.1-stable<br>
 * Status: FINAL
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-08-26")
public enum HcpSpecialisation implements ValueSetEnumInterface {

    /**
     * EN: Allergology and clinical immunology<br>
     * DE: Allergologie und klinische Immunologie<br>
     * FR: Allergologie et immunologie clinique<br>
     * IT: Allergologia e immunologia clinica<br>
     */
    ALLERGOLOGY_AND_CLINICAL_IMMUNOLOGY("1019",
                                        "2.16.756.5.30.1.127.3.5",
                                        "Allergology and clinical immunology",
                                        "Allergology and clinical immunology",
                                        "Allergologie und klinische Immunologie",
                                        "Allergologie et immunologie clinique",
                                        "Allergologia e immunologia clinica"),
    /**
     * EN: Anaesthesiology<br>
     * DE: Anästhesiologie<br>
     * FR: Anesthésiologie<br>
     * IT: Anestesiologia<br>
     */
    ANAESTHESIOLOGY("1012",
                    "2.16.756.5.30.1.127.3.5",
                    "Anaesthesiology",
                    "Anaesthesiology",
                    "Anästhesiologie",
                    "Anesthésiologie",
                    "Anestesiologia"),
    /**
     * EN: Angiology<br>
     * DE: Angiologie<br>
     * FR: Angiologie<br>
     * IT: Angiologia<br>
     */
    ANGIOLOGY("1041",
              "2.16.756.5.30.1.127.3.5",
              "Angiology",
              "Angiology",
              "Angiologie",
              "Angiologie",
              "Angiologia"),
    /**
     * EN: Cardiac and thoracic vascular surgery<br>
     * DE: Herz- und thorakale Gefässchirurgie<br>
     * FR: Chirurgie cardiaque et vasculaire thoracique<br>
     * IT: Chirurgia del cuore e dei vasi toracici<br>
     */
    CARDIAC_AND_THORACIC_VASCULAR_SURGERY("1004",
                                          "2.16.756.5.30.1.127.3.5",
                                          "Cardiac and thoracic vascular surgery",
                                          "Cardiac and thoracic vascular surgery",
                                          "Herz- und thorakale Gefässchirurgie",
                                          "Chirurgie cardiaque et vasculaire thoracique",
                                          "Chirurgia del cuore e dei vasi toracici"),
    /**
     * EN: Cardiology<br>
     * DE: Kardiologie<br>
     * FR: Cardiologie<br>
     * IT: Cardiologia<br>
     */
    CARDIOLOGY("1025",
               "2.16.756.5.30.1.127.3.5",
               "Cardiology",
               "Cardiology",
               "Kardiologie",
               "Cardiologie",
               "Cardiologia"),
    /**
     * EN: Child and adolescent psychiatry and psychotherapy<br>
     * DE: Kinder- und Jugendpsychiatrie und -psychotherapie<br>
     * FR: Psychiatrie et psychothérapie d’enfants et d’adolescents<br>
     * IT: Psichiatria e psicoterapia infantile e dell’adolescenza<br>
     */
    CHILD_AND_ADOLESCENT_PSYCHIATRY_AND_PSYCHOTHERAPY("1027",
                                                      "2.16.756.5.30.1.127.3.5",
                                                      "Child and adolescent psychiatry and psychotherapy",
                                                      "Child and adolescent psychiatry and psychotherapy",
                                                      "Kinder- und Jugendpsychiatrie und -psychotherapie",
                                                      "Psychiatrie et psychothérapie d’enfants et d’adolescents",
                                                      "Psichiatria e psicoterapia infantile e dell’adolescenza"),
    /**
     * EN: Child and adolescent psychology<br>
     * DE: Kinder- und Jugendpsychologie<br>
     * FR: psychologie des enfants et des adolescents<br>
     * IT: psicologia dell’età evolutiva<br>
     */
    CHILD_AND_ADOLESCENT_PSYCHOLOGY("1055",
                                    "2.16.756.5.30.1.127.3.5",
                                    "Child and adolescent psychology",
                                    "Child and adolescent psychology",
                                    "Kinder- und Jugendpsychologie",
                                    "psychologie des enfants et des adolescents",
                                    "psicologia dell’età evolutiva"),
    /**
     * EN: Chiropractic specialist<br>
     * DE: Fachchiropraktik<br>
     * FR: Chiropratique spécialisée<br>
     * IT: Chiropratica specialistica<br>
     */
    CHIROPRACTIC_SPECIALIST("1011",
                            "2.16.756.5.30.1.127.3.5",
                            "Chiropractic specialist",
                            "Chiropractic specialist",
                            "Fachchiropraktik",
                            "Chiropratique spécialisée",
                            "Chiropratica specialistica"),
    /**
     * EN: Clinical pharmacology and toxicology<br>
     * DE: Klinische Pharmakologie und Toxikologie<br>
     * FR: Pharmacologie et toxicologie cliniques<br>
     * IT: Farmacologia e tossicologia cliniche<br>
     */
    CLINICAL_PHARMACOLOGY_AND_TOXICOLOGY("1029",
                                         "2.16.756.5.30.1.127.3.5",
                                         "Clinical pharmacology and toxicology",
                                         "Clinical pharmacology and toxicology",
                                         "Klinische Pharmakologie und Toxikologie",
                                         "Pharmacologie et toxicologie cliniques",
                                         "Farmacologia e tossicologia cliniche"),
    /**
     * EN: Clinical psychology<br>
     * DE: Klinische Psychologie<br>
     * FR: psychologie clinique<br>
     * IT: psicologia clinica<br>
     */
    CLINICAL_PSYCHOLOGY("1056",
                        "2.16.756.5.30.1.127.3.5",
                        "Clinical psychology",
                        "Clinical psychology",
                        "Klinische Psychologie",
                        "psychologie clinique",
                        "psicologia clinica"),
    /**
     * EN: Community pharmacy<br>
     * DE: Offizinpharmazie<br>
     * FR: Pharmacie d’officine<br>
     * IT: Farmacia d’officina<br>
     */
    COMMUNITY_PHARMACY("1052",
                       "2.16.756.5.30.1.127.3.5",
                       "Community pharmacy",
                       "Community pharmacy",
                       "Offizinpharmazie",
                       "Pharmacie d’officine",
                       "Farmacia d’officina"),
    /**
     * EN: Dermatology and venereology<br>
     * DE: Dermatologie und Venerologie<br>
     * FR: Dermatologie et vénéréologie<br>
     * IT: Dermatologia e venereologia<br>
     */
    DERMATOLOGY_AND_VENEREOLOGY("1021",
                                "2.16.756.5.30.1.127.3.5",
                                "Dermatology and venereology",
                                "Dermatology and venereology",
                                "Dermatologie und Venerologie",
                                "Dermatologie et vénéréologie",
                                "Dermatologia e venereologia"),
    /**
     * EN: Endocrinology – Diabetology<br>
     * DE: Endokrinologie-Diabetologie<br>
     * FR: Endocrinologie-diabétologie<br>
     * IT: Endocrinologia e diabetologia<br>
     */
    ENDOCRINOLOGY_DIABETOLOGY("1022",
                              "2.16.756.5.30.1.127.3.5",
                              "Endocrinology – Diabetology",
                              "Endocrinology – Diabetology",
                              "Endokrinologie-Diabetologie",
                              "Endocrinologie-diabétologie",
                              "Endocrinologia e diabetologia"),
    /**
     * EN: Forensic medicine<br>
     * DE: Rechtsmedizin<br>
     * FR: Médecine légale<br>
     * IT: Medicina legale<br>
     */
    FORENSIC_MEDICINE("1046",
                      "2.16.756.5.30.1.127.3.5",
                      "Forensic medicine",
                      "Forensic medicine",
                      "Rechtsmedizin",
                      "Médecine légale",
                      "Medicina legale"),
    /**
     * EN: Gastroenterology<br>
     * DE: Gastroenterologie<br>
     * FR: Gastroentérologie<br>
     * IT: Gastroenterologia<br>
     */
    GASTROENTEROLOGY("1023",
                     "2.16.756.5.30.1.127.3.5",
                     "Gastroenterology",
                     "Gastroenterology",
                     "Gastroenterologie",
                     "Gastroentérologie",
                     "Gastroenterologia"),
    /**
     * EN: General internal medicine<br>
     * DE: Allgemeine Innere Medizin<br>
     * FR: Médecine interne générale<br>
     * IT: Medicina interna generale<br>
     */
    GENERAL_INTERNAL_MEDICINE("1051",
                              "2.16.756.5.30.1.127.3.5",
                              "General internal medicine",
                              "General internal medicine",
                              "Allgemeine Innere Medizin",
                              "Médecine interne générale",
                              "Medicina interna generale"),
    /**
     * EN: General medical practitioner<br>
     * DE: Praktische Ärztin _ Praktischer Arzt<br>
     * FR: Médecin praticien<br>
     * IT: Medico generico<br>
     */
    GENERAL_MEDICAL_PRACTITIONER("1040",
                                 "2.16.756.5.30.1.127.3.5",
                                 "General medical practitioner",
                                 "General medical practitioner",
                                 "Praktische Ärztin _ Praktischer Arzt",
                                 "Médecin praticien",
                                 "Medico generico"),
    /**
     * EN: Gynaecology and obstetrics<br>
     * DE: Gynäkologie und Geburtshilfe<br>
     * FR: Gynécologie et obstétrique<br>
     * IT: Ginecologia e ostetricia<br>
     */
    GYNAECOLOGY_AND_OBSTETRICS("1003",
                               "2.16.756.5.30.1.127.3.5",
                               "Gynaecology and obstetrics",
                               "Gynaecology and obstetrics",
                               "Gynäkologie und Geburtshilfe",
                               "Gynécologie et obstétrique",
                               "Ginecologia e ostetricia"),
    /**
     * EN: Haematology<br>
     * DE: Hämatologie<br>
     * FR: Hématologie<br>
     * IT: Ematologia<br>
     */
    HAEMATOLOGY("1024",
                "2.16.756.5.30.1.127.3.5",
                "Haematology",
                "Haematology",
                "Hämatologie",
                "Hématologie",
                "Ematologia"),
    /**
     * EN: Hand surgery<br>
     * DE: Handchirurgie<br>
     * FR: Chirurgie de la main<br>
     * IT: Chirurgia della mano<br>
     */
    HAND_SURGERY("1059",
                 "2.16.756.5.30.1.127.3.5",
                 "Hand surgery",
                 "Hand surgery",
                 "Handchirurgie",
                 "Chirurgie de la main",
                 "Chirurgia della mano"),
    /**
     * EN: Health psychology<br>
     * DE: Gesundheitspsychologie<br>
     * FR: psychologie de la santé<br>
     * IT: psicologia della salute<br>
     */
    HEALTH_PSYCHOLOGY("1058",
                      "2.16.756.5.30.1.127.3.5",
                      "Health psychology",
                      "Health psychology",
                      "Gesundheitspsychologie",
                      "psychologie de la santé",
                      "psicologia della salute"),
    /**
     * EN: Hospital pharmacy<br>
     * DE: Spitalpharmazie<br>
     * FR: Pharmacie hospitalière<br>
     * IT: Farmacia d’ospedale<br>
     */
    HOSPITAL_PHARMACY("1053",
                      "2.16.756.5.30.1.127.3.5",
                      "Hospital pharmacy",
                      "Hospital pharmacy",
                      "Spitalpharmazie",
                      "Pharmacie hospitalière",
                      "Farmacia d’ospedale"),
    /**
     * EN: Infectology<br>
     * DE: Infektiologie<br>
     * FR: Infectiologie<br>
     * IT: Malattie infettive<br>
     */
    INFECTOLOGY("1039",
                "2.16.756.5.30.1.127.3.5",
                "Infectology",
                "Infectology",
                "Infektiologie",
                "Infectiologie",
                "Malattie infettive"),
    /**
     * EN: Intensive care medicine<br>
     * DE: Intensivmedizin<br>
     * FR: Médecine intensive<br>
     * IT: Medicina intensiva<br>
     */
    INTENSIVE_CARE_MEDICINE("1042",
                            "2.16.756.5.30.1.127.3.5",
                            "Intensive care medicine",
                            "Intensive care medicine",
                            "Intensivmedizin",
                            "Médecine intensive",
                            "Medicina intensiva"),
    /**
     * EN: Medical genetics<br>
     * DE: Medizinische Genetik<br>
     * FR: Génétique médicale<br>
     * IT: Genetica medica<br>
     */
    MEDICAL_GENETICS("1043",
                     "2.16.756.5.30.1.127.3.5",
                     "Medical genetics",
                     "Medical genetics",
                     "Medizinische Genetik",
                     "Génétique médicale",
                     "Genetica medica"),
    /**
     * EN: Medical oncology<br>
     * DE: Medizinische Onkologie<br>
     * FR: Oncologie médicale<br>
     * IT: Oncologia medica<br>
     */
    MEDICAL_ONCOLOGY("1044",
                     "2.16.756.5.30.1.127.3.5",
                     "Medical oncology",
                     "Medical oncology",
                     "Medizinische Onkologie",
                     "Oncologie médicale",
                     "Oncologia medica"),
    /**
     * EN: Nephrology<br>
     * DE: Nephrologie<br>
     * FR: Néphrologie<br>
     * IT: Nefrologia<br>
     */
    NEPHROLOGY("1033",
               "2.16.756.5.30.1.127.3.5",
               "Nephrology",
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
    NEUROLOGY("1014",
              "2.16.756.5.30.1.127.3.5",
              "Neurology",
              "Neurology",
              "Neurologie",
              "Neurologie",
              "Neurologia"),
    /**
     * EN: Neuropsychology<br>
     * DE: Neuropsychologie<br>
     * FR: neuropsychologie<br>
     * IT: neuropsicologia<br>
     */
    NEUROPSYCHOLOGY("1057",
                    "2.16.756.5.30.1.127.3.5",
                    "Neuropsychology",
                    "Neuropsychology",
                    "Neuropsychologie",
                    "neuropsychologie",
                    "neuropsicologia"),
    /**
     * EN: Neurosurgery<br>
     * DE: Neurochirurgie<br>
     * FR: Neurochirurgie<br>
     * IT: Neurochirurgia<br>
     */
    NEUROSURGERY("1013",
                 "2.16.756.5.30.1.127.3.5",
                 "Neurosurgery",
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
    NUCLEAR_MEDICINE("1031",
                     "2.16.756.5.30.1.127.3.5",
                     "Nuclear medicine",
                     "Nuclear medicine",
                     "Nuklearmedizin",
                     "Médecine nucléaire",
                     "Medicina nucleare"),
    /**
     * EN: Occupational medicine<br>
     * DE: Arbeitsmedizin<br>
     * FR: Médecine du travail<br>
     * IT: Medicina del lavoro<br>
     */
    OCCUPATIONAL_MEDICINE("1020",
                          "2.16.756.5.30.1.127.3.5",
                          "Occupational medicine",
                          "Occupational medicine",
                          "Arbeitsmedizin",
                          "Médecine du travail",
                          "Medicina del lavoro"),
    /**
     * EN: Ophthalmology<br>
     * DE: Ophthalmologie<br>
     * FR: Ophtalmologie<br>
     * IT: Oftalmologia<br>
     */
    OPHTHALMOLOGY("1007",
                  "2.16.756.5.30.1.127.3.5",
                  "Ophthalmology",
                  "Ophthalmology",
                  "Ophthalmologie",
                  "Ophtalmologie",
                  "Oftalmologia"),
    /**
     * EN: Oral and maxillofacial surgery<br>
     * DE: Mund-, Kiefer- und Gesichtschirurgie<br>
     * FR: Chirurgie orale et maxillo-faciale<br>
     * IT: Chirurgia oro-maxillo-facciale<br>
     */
    ORAL_AND_MAXILLOFACIAL_SURGERY("1026",
                                   "2.16.756.5.30.1.127.3.5",
                                   "Oral and maxillofacial surgery",
                                   "Oral and maxillofacial surgery",
                                   "Mund-, Kiefer- und Gesichtschirurgie",
                                   "Chirurgie orale et maxillo-faciale",
                                   "Chirurgia oro-maxillo-facciale"),
    /**
     * EN: Oral surgery<br>
     * DE: Oralchirurgie<br>
     * FR: Chirurgie orale<br>
     * IT: Chirurgia orale<br>
     */
    ORAL_SURGERY("1047",
                 "2.16.756.5.30.1.127.3.5",
                 "Oral surgery",
                 "Oral surgery",
                 "Oralchirurgie",
                 "Chirurgie orale",
                 "Chirurgia orale"),
    /**
     * EN: Orthodontics<br>
     * DE: Kieferorthopädie<br>
     * FR: Orthodontie<br>
     * IT: Ortodonzia<br>
     */
    ORTHODONTICS("1010",
                 "2.16.756.5.30.1.127.3.5",
                 "Orthodontics",
                 "Orthodontics",
                 "Kieferorthopädie",
                 "Orthodontie",
                 "Ortodonzia"),
    /**
     * EN: Orthopaedic surgery and traumatology of the locomotor apparatus<br>
     * DE: Orthopädische Chirurgie und Traumatologie des Bewegungsapparates<br>
     * FR: Chirurgie orthopédique et traumatologie de l’appareil locomoteur<br>
     * IT: Chirurgia ortopedica e traumatologia dell’apparato locomotore<br>
     */
    ORTHOPAEDIC_SURGERY_AND_TRAUMATOLOGY_OF_THE_LOCOMOTOR_APPARATUS("1015",
                                                                    "2.16.756.5.30.1.127.3.5",
                                                                    "Orthopaedic surgery and traumatology of the locomotor apparatus",
                                                                    "Orthopaedic surgery and traumatology of the locomotor apparatus",
                                                                    "Orthopädische Chirurgie und Traumatologie des Bewegungsapparates",
                                                                    "Chirurgie orthopédique et traumatologie de l’appareil locomoteur",
                                                                    "Chirurgia ortopedica e traumatologia dell’apparato locomotore"),
    /**
     * EN: Other<br>
     * DE: Andere<br>
     * FR: Autre<br>
     * IT: Altre<br>
     */
    OTHER("1050",
          "2.16.756.5.30.1.127.3.5",
          "Other",
          "Other",
          "Andere",
          "Autre",
          "Altre"),
    /**
     * EN: Otorhinolaryngology<br>
     * DE: Oto-Rhino-Laryngologie<br>
     * FR: Oto-rhino-laryngologie<br>
     * IT: Otorinolaringoiatria<br>
     */
    OTORHINOLARYNGOLOGY("1008",
                        "2.16.756.5.30.1.127.3.5",
                        "Otorhinolaryngology",
                        "Otorhinolaryngology",
                        "Oto-Rhino-Laryngologie",
                        "Oto-rhino-laryngologie",
                        "Otorinolaringoiatria"),
    /**
     * EN: Paediatrics<br>
     * DE: Kinder- und Jugendmedizin<br>
     * FR: Pédiatrie<br>
     * IT: Pediatria<br>
     */
    PAEDIATRICS("1006",
                "2.16.756.5.30.1.127.3.5",
                "Paediatrics",
                "Paediatrics",
                "Kinder- und Jugendmedizin",
                "Pédiatrie",
                "Pediatria"),
    /**
     * EN: Paediatric surgery<br>
     * DE: Kinderchirurgie<br>
     * FR: Chirurgie pédiatrique<br>
     * IT: Chirurgia pediatrica<br>
     */
    PAEDIATRIC_SURGERY("1028",
                       "2.16.756.5.30.1.127.3.5",
                       "Paediatric surgery",
                       "Paediatric surgery",
                       "Kinderchirurgie",
                       "Chirurgie pédiatrique",
                       "Chirurgia pediatrica"),
    /**
     * EN: Paradontology<br>
     * DE: Parodontologie<br>
     * FR: Parodontologie<br>
     * IT: Parodontologia<br>
     */
    PARADONTOLOGY("1048",
                  "2.16.756.5.30.1.127.3.5",
                  "Paradontology",
                  "Paradontology",
                  "Parodontologie",
                  "Parodontologie",
                  "Parodontologia"),
    /**
     * EN: Pathology<br>
     * DE: Pathologie<br>
     * FR: Pathologie<br>
     * IT: Patologia<br>
     */
    PATHOLOGY("1009",
              "2.16.756.5.30.1.127.3.5",
              "Pathology",
              "Pathology",
              "Pathologie",
              "Pathologie",
              "Patologia"),
    /**
     * EN: Pharmaceutical medicine<br>
     * DE: Pharmazeutische Medizin<br>
     * FR: Médecine pharmaceutique<br>
     * IT: Medicina farmacologica<br>
     */
    PHARMACEUTICAL_MEDICINE("1045",
                            "2.16.756.5.30.1.127.3.5",
                            "Pharmaceutical medicine",
                            "Pharmaceutical medicine",
                            "Pharmazeutische Medizin",
                            "Médecine pharmaceutique",
                            "Medicina farmacologica"),
    /**
     * EN: Physical medicine and rehabilitation<br>
     * DE: Physikalische Medizin und Rehabilitation<br>
     * FR: Médecine physique et réadaptation<br>
     * IT: Medicina fisica e riabilitazione<br>
     */
    PHYSICAL_MEDICINE_AND_REHABILITATION("1034",
                                         "2.16.756.5.30.1.127.3.5",
                                         "Physical medicine and rehabilitation",
                                         "Physical medicine and rehabilitation",
                                         "Physikalische Medizin und Rehabilitation",
                                         "Médecine physique et réadaptation",
                                         "Medicina fisica e riabilitazione"),
    /**
     * EN: Plastic, reconstructive and aesthetic surgery<br>
     * DE: Plastische, Rekonstruktive und Ästhetische Chirurgie<br>
     * FR: Chirurgie plastique, reconstructive et esthétique<br>
     * IT: Chirurgia plastica, ricostruttiva ed estetica<br>
     */
    PLASTIC_RECONSTRUCTIVE_AND_AESTHETIC_SURGERY("1035",
                                                 "2.16.756.5.30.1.127.3.5",
                                                 "Plastic, reconstructive and aesthetic surgery",
                                                 "Plastic, reconstructive and aesthetic surgery",
                                                 "Plastische, Rekonstruktive und Ästhetische Chirurgie",
                                                 "Chirurgie plastique, reconstructive et esthétique",
                                                 "Chirurgia plastica, ricostruttiva ed estetica"),
    /**
     * EN: Pneumology<br>
     * DE: Pneumologie<br>
     * FR: Pneumologie<br>
     * IT: Pneumologia<br>
     */
    PNEUMOLOGY("1016",
               "2.16.756.5.30.1.127.3.5",
               "Pneumology",
               "Pneumology",
               "Pneumologie",
               "Pneumologie",
               "Pneumologia"),
    /**
     * EN: Prevention and public health<br>
     * DE: Prävention und Gesundheitswesen<br>
     * FR: Prévention et santé publique<br>
     * IT: Prevenzione e salute pubblica<br>
     */
    PREVENTION_AND_PUBLIC_HEALTH("1036",
                                 "2.16.756.5.30.1.127.3.5",
                                 "Prevention and public health",
                                 "Prevention and public health",
                                 "Prävention und Gesundheitswesen",
                                 "Prévention et santé publique",
                                 "Prevenzione e salute pubblica"),
    /**
     * EN: Psychiatry and psychotherapy<br>
     * DE: Psychiatrie und Psychotherapie<br>
     * FR: Psychiatrie et psychothérapie<br>
     * IT: Psichiatria e psicoterapia<br>
     */
    PSYCHIATRY_AND_PSYCHOTHERAPY("1017",
                                 "2.16.756.5.30.1.127.3.5",
                                 "Psychiatry and psychotherapy",
                                 "Psychiatry and psychotherapy",
                                 "Psychiatrie und Psychotherapie",
                                 "Psychiatrie et psychothérapie",
                                 "Psichiatria e psicoterapia"),
    /**
     * EN: Psychotherapy<br>
     * DE: Psychotherapie<br>
     * FR: psychothérapie<br>
     * IT: psicoterapia<br>
     */
    PSYCHOTHERAPY("1054",
                  "2.16.756.5.30.1.127.3.5",
                  "Psychotherapy",
                  "Psychotherapy",
                  "Psychotherapie",
                  "psychothérapie",
                  "psicoterapia"),
    /**
     * EN: Radiology<br>
     * DE: Radiologie<br>
     * FR: Radiologie<br>
     * IT: Radiologia<br>
     */
    RADIOLOGY("1030",
              "2.16.756.5.30.1.127.3.5",
              "Radiology",
              "Radiology",
              "Radiologie",
              "Radiologie",
              "Radiologia"),
    /**
     * EN: Radio-oncology / radiotherapy<br>
     * DE: Radio-Onkologie_Strahlentherapie<br>
     * FR: Radio-oncologie_radiothérapie<br>
     * IT: Radio-oncologia_radioterapia<br>
     */
    RADIO_ONCOLOGY_RADIOTHERAPY("1032",
                                "2.16.756.5.30.1.127.3.5",
                                "Radio-oncology / radiotherapy",
                                "Radio-oncology / radiotherapy",
                                "Radio-Onkologie_Strahlentherapie",
                                "Radio-oncologie_radiothérapie",
                                "Radio-oncologia_radioterapia"),
    /**
     * EN: Reconstructive dentistry<br>
     * DE: Rekonstruktive Zahnmedizin<br>
     * FR: Médecine dentaire reconstructive<br>
     * IT: Medicina dentaria riconstruttiva<br>
     */
    RECONSTRUCTIVE_DENTISTRY("1049",
                             "2.16.756.5.30.1.127.3.5",
                             "Reconstructive dentistry",
                             "Reconstructive dentistry",
                             "Rekonstruktive Zahnmedizin",
                             "Médecine dentaire reconstructive",
                             "Medicina dentaria riconstruttiva"),
    /**
     * EN: Rheumatology<br>
     * DE: Rheumatologie<br>
     * FR: Rhumatologie<br>
     * IT: Reumatologia<br>
     */
    RHEUMATOLOGY("1037",
                 "2.16.756.5.30.1.127.3.5",
                 "Rheumatology",
                 "Rheumatology",
                 "Rheumatologie",
                 "Rhumatologie",
                 "Reumatologia"),
    /**
     * EN: Surgery<br>
     * DE: Chirurgie<br>
     * FR: Chirurgie<br>
     * IT: Chirurgia<br>
     */
    SURGERY("1002",
            "2.16.756.5.30.1.127.3.5",
            "Surgery",
            "Surgery",
            "Chirurgie",
            "Chirurgie",
            "Chirurgia"),
    /**
     * EN: Thoracic surgery<br>
     * DE: Thoraxchirurgie<br>
     * FR: Chirurgie thoracique<br>
     * IT: Chirurgia toracica<br>
     */
    THORACIC_SURGERY("1061",
                     "2.16.756.5.30.1.127.3.5",
                     "Thoracic surgery",
                     "Thoracic surgery",
                     "Thoraxchirurgie",
                     "Chirurgie thoracique",
                     "Chirurgia toracica"),
    /**
     * EN: Tropical and travel medicine<br>
     * DE: Tropen- und Reisemedizin<br>
     * FR: Médecine tropicale et médecine des voyages<br>
     * IT: Medicina tropicale e medicina di viaggio<br>
     */
    TROPICAL_AND_TRAVEL_MEDICINE("1038",
                                 "2.16.756.5.30.1.127.3.5",
                                 "Tropical and travel medicine",
                                 "Tropical and travel medicine",
                                 "Tropen- und Reisemedizin",
                                 "Médecine tropicale et médecine des voyages",
                                 "Medicina tropicale e medicina di viaggio"),
    /**
     * EN: Urology<br>
     * DE: Urologie<br>
     * FR: Urologie<br>
     * IT: Urologia<br>
     */
    UROLOGY("1018",
            "2.16.756.5.30.1.127.3.5",
            "Urology",
            "Urology",
            "Urologie",
            "Urologie",
            "Urologia"),
    /**
     * EN: Vascular surgery<br>
     * DE: Gefässchirurgie<br>
     * FR: Chirurgie vasculaire<br>
     * IT: Chirurgia vascolare<br>
     */
    VASCULAR_SURGERY("1060",
                     "2.16.756.5.30.1.127.3.5",
                     "Vascular surgery",
                     "Vascular surgery",
                     "Gefässchirurgie",
                     "Chirurgie vasculaire",
                     "Chirurgia vascolare");

    /**
     * EN: Code for Allergology and clinical immunology<br>
     * DE: Code für Allergologie und klinische Immunologie<br>
     * FR: Code de Allergologie et immunologie clinique<br>
     * IT: Code per Allergologia e immunologia clinica<br>
     */
    public static final String ALLERGOLOGY_AND_CLINICAL_IMMUNOLOGY_CODE = "1019";

    /**
     * EN: Code for Anaesthesiology<br>
     * DE: Code für Anästhesiologie<br>
     * FR: Code de Anesthésiologie<br>
     * IT: Code per Anestesiologia<br>
     */
    public static final String ANAESTHESIOLOGY_CODE = "1012";

    /**
     * EN: Code for Angiology<br>
     * DE: Code für Angiologie<br>
     * FR: Code de Angiologie<br>
     * IT: Code per Angiologia<br>
     */
    public static final String ANGIOLOGY_CODE = "1041";

    /**
     * EN: Code for Cardiac and thoracic vascular surgery<br>
     * DE: Code für Herz- und thorakale Gefässchirurgie<br>
     * FR: Code de Chirurgie cardiaque et vasculaire thoracique<br>
     * IT: Code per Chirurgia del cuore e dei vasi toracici<br>
     */
    public static final String CARDIAC_AND_THORACIC_VASCULAR_SURGERY_CODE = "1004";

    /**
     * EN: Code for Cardiology<br>
     * DE: Code für Kardiologie<br>
     * FR: Code de Cardiologie<br>
     * IT: Code per Cardiologia<br>
     */
    public static final String CARDIOLOGY_CODE = "1025";

    /**
     * EN: Code for Child and adolescent psychiatry and psychotherapy<br>
     * DE: Code für Kinder- und Jugendpsychiatrie und -psychotherapie<br>
     * FR: Code de Psychiatrie et psychothérapie d’enfants et d’adolescents<br>
     * IT: Code per Psichiatria e psicoterapia infantile e dell’adolescenza<br>
     */
    public static final String CHILD_AND_ADOLESCENT_PSYCHIATRY_AND_PSYCHOTHERAPY_CODE = "1027";

    /**
     * EN: Code for Child and adolescent psychology<br>
     * DE: Code für Kinder- und Jugendpsychologie<br>
     * FR: Code de psychologie des enfants et des adolescents<br>
     * IT: Code per psicologia dell’età evolutiva<br>
     */
    public static final String CHILD_AND_ADOLESCENT_PSYCHOLOGY_CODE = "1055";

    /**
     * EN: Code for Chiropractic specialist<br>
     * DE: Code für Fachchiropraktik<br>
     * FR: Code de Chiropratique spécialisée<br>
     * IT: Code per Chiropratica specialistica<br>
     */
    public static final String CHIROPRACTIC_SPECIALIST_CODE = "1011";

    /**
     * EN: Code for Clinical pharmacology and toxicology<br>
     * DE: Code für Klinische Pharmakologie und Toxikologie<br>
     * FR: Code de Pharmacologie et toxicologie cliniques<br>
     * IT: Code per Farmacologia e tossicologia cliniche<br>
     */
    public static final String CLINICAL_PHARMACOLOGY_AND_TOXICOLOGY_CODE = "1029";

    /**
     * EN: Code for Clinical psychology<br>
     * DE: Code für Klinische Psychologie<br>
     * FR: Code de psychologie clinique<br>
     * IT: Code per psicologia clinica<br>
     */
    public static final String CLINICAL_PSYCHOLOGY_CODE = "1056";

    /**
     * EN: Code for Community pharmacy<br>
     * DE: Code für Offizinpharmazie<br>
     * FR: Code de Pharmacie d’officine<br>
     * IT: Code per Farmacia d’officina<br>
     */
    public static final String COMMUNITY_PHARMACY_CODE = "1052";

    /**
     * EN: Code for Dermatology and venereology<br>
     * DE: Code für Dermatologie und Venerologie<br>
     * FR: Code de Dermatologie et vénéréologie<br>
     * IT: Code per Dermatologia e venereologia<br>
     */
    public static final String DERMATOLOGY_AND_VENEREOLOGY_CODE = "1021";

    /**
     * EN: Code for Endocrinology – Diabetology<br>
     * DE: Code für Endokrinologie-Diabetologie<br>
     * FR: Code de Endocrinologie-diabétologie<br>
     * IT: Code per Endocrinologia e diabetologia<br>
     */
    public static final String ENDOCRINOLOGY_DIABETOLOGY_CODE = "1022";

    /**
     * EN: Code for Forensic medicine<br>
     * DE: Code für Rechtsmedizin<br>
     * FR: Code de Médecine légale<br>
     * IT: Code per Medicina legale<br>
     */
    public static final String FORENSIC_MEDICINE_CODE = "1046";

    /**
     * EN: Code for Gastroenterology<br>
     * DE: Code für Gastroenterologie<br>
     * FR: Code de Gastroentérologie<br>
     * IT: Code per Gastroenterologia<br>
     */
    public static final String GASTROENTEROLOGY_CODE = "1023";

    /**
     * EN: Code for General internal medicine<br>
     * DE: Code für Allgemeine Innere Medizin<br>
     * FR: Code de Médecine interne générale<br>
     * IT: Code per Medicina interna generale<br>
     */
    public static final String GENERAL_INTERNAL_MEDICINE_CODE = "1051";

    /**
     * EN: Code for General medical practitioner<br>
     * DE: Code für Praktische Ärztin _ Praktischer Arzt<br>
     * FR: Code de Médecin praticien<br>
     * IT: Code per Medico generico<br>
     */
    public static final String GENERAL_MEDICAL_PRACTITIONER_CODE = "1040";

    /**
     * EN: Code for Gynaecology and obstetrics<br>
     * DE: Code für Gynäkologie und Geburtshilfe<br>
     * FR: Code de Gynécologie et obstétrique<br>
     * IT: Code per Ginecologia e ostetricia<br>
     */
    public static final String GYNAECOLOGY_AND_OBSTETRICS_CODE = "1003";

    /**
     * EN: Code for Haematology<br>
     * DE: Code für Hämatologie<br>
     * FR: Code de Hématologie<br>
     * IT: Code per Ematologia<br>
     */
    public static final String HAEMATOLOGY_CODE = "1024";

    /**
     * EN: Code for Hand surgery<br>
     * DE: Code für Handchirurgie<br>
     * FR: Code de Chirurgie de la main<br>
     * IT: Code per Chirurgia della mano<br>
     */
    public static final String HAND_SURGERY_CODE = "1059";

    /**
     * EN: Code for Health psychology<br>
     * DE: Code für Gesundheitspsychologie<br>
     * FR: Code de psychologie de la santé<br>
     * IT: Code per psicologia della salute<br>
     */
    public static final String HEALTH_PSYCHOLOGY_CODE = "1058";

    /**
     * EN: Code for Hospital pharmacy<br>
     * DE: Code für Spitalpharmazie<br>
     * FR: Code de Pharmacie hospitalière<br>
     * IT: Code per Farmacia d’ospedale<br>
     */
    public static final String HOSPITAL_PHARMACY_CODE = "1053";

    /**
     * EN: Code for Infectology<br>
     * DE: Code für Infektiologie<br>
     * FR: Code de Infectiologie<br>
     * IT: Code per Malattie infettive<br>
     */
    public static final String INFECTOLOGY_CODE = "1039";

    /**
     * EN: Code for Intensive care medicine<br>
     * DE: Code für Intensivmedizin<br>
     * FR: Code de Médecine intensive<br>
     * IT: Code per Medicina intensiva<br>
     */
    public static final String INTENSIVE_CARE_MEDICINE_CODE = "1042";

    /**
     * EN: Code for Medical genetics<br>
     * DE: Code für Medizinische Genetik<br>
     * FR: Code de Génétique médicale<br>
     * IT: Code per Genetica medica<br>
     */
    public static final String MEDICAL_GENETICS_CODE = "1043";

    /**
     * EN: Code for Medical oncology<br>
     * DE: Code für Medizinische Onkologie<br>
     * FR: Code de Oncologie médicale<br>
     * IT: Code per Oncologia medica<br>
     */
    public static final String MEDICAL_ONCOLOGY_CODE = "1044";

    /**
     * EN: Code for Nephrology<br>
     * DE: Code für Nephrologie<br>
     * FR: Code de Néphrologie<br>
     * IT: Code per Nefrologia<br>
     */
    public static final String NEPHROLOGY_CODE = "1033";

    /**
     * EN: Code for Neurology<br>
     * DE: Code für Neurologie<br>
     * FR: Code de Neurologie<br>
     * IT: Code per Neurologia<br>
     */
    public static final String NEUROLOGY_CODE = "1014";

    /**
     * EN: Code for Neuropsychology<br>
     * DE: Code für Neuropsychologie<br>
     * FR: Code de neuropsychologie<br>
     * IT: Code per neuropsicologia<br>
     */
    public static final String NEUROPSYCHOLOGY_CODE = "1057";

    /**
     * EN: Code for Neurosurgery<br>
     * DE: Code für Neurochirurgie<br>
     * FR: Code de Neurochirurgie<br>
     * IT: Code per Neurochirurgia<br>
     */
    public static final String NEUROSURGERY_CODE = "1013";

    /**
     * EN: Code for Nuclear medicine<br>
     * DE: Code für Nuklearmedizin<br>
     * FR: Code de Médecine nucléaire<br>
     * IT: Code per Medicina nucleare<br>
     */
    public static final String NUCLEAR_MEDICINE_CODE = "1031";

    /**
     * EN: Code for Occupational medicine<br>
     * DE: Code für Arbeitsmedizin<br>
     * FR: Code de Médecine du travail<br>
     * IT: Code per Medicina del lavoro<br>
     */
    public static final String OCCUPATIONAL_MEDICINE_CODE = "1020";

    /**
     * EN: Code for Ophthalmology<br>
     * DE: Code für Ophthalmologie<br>
     * FR: Code de Ophtalmologie<br>
     * IT: Code per Oftalmologia<br>
     */
    public static final String OPHTHALMOLOGY_CODE = "1007";

    /**
     * EN: Code for Oral and maxillofacial surgery<br>
     * DE: Code für Mund-, Kiefer- und Gesichtschirurgie<br>
     * FR: Code de Chirurgie orale et maxillo-faciale<br>
     * IT: Code per Chirurgia oro-maxillo-facciale<br>
     */
    public static final String ORAL_AND_MAXILLOFACIAL_SURGERY_CODE = "1026";

    /**
     * EN: Code for Oral surgery<br>
     * DE: Code für Oralchirurgie<br>
     * FR: Code de Chirurgie orale<br>
     * IT: Code per Chirurgia orale<br>
     */
    public static final String ORAL_SURGERY_CODE = "1047";

    /**
     * EN: Code for Orthodontics<br>
     * DE: Code für Kieferorthopädie<br>
     * FR: Code de Orthodontie<br>
     * IT: Code per Ortodonzia<br>
     */
    public static final String ORTHODONTICS_CODE = "1010";

    /**
     * EN: Code for Orthopaedic surgery and traumatology of the locomotor apparatus<br>
     * DE: Code für Orthopädische Chirurgie und Traumatologie des Bewegungsapparates<br>
     * FR: Code de Chirurgie orthopédique et traumatologie de l’appareil locomoteur<br>
     * IT: Code per Chirurgia ortopedica e traumatologia dell’apparato locomotore<br>
     */
    public static final String ORTHOPAEDIC_SURGERY_AND_TRAUMATOLOGY_OF_THE_LOCOMOTOR_APPARATUS_CODE = "1015";

    /**
     * EN: Code for Other<br>
     * DE: Code für Andere<br>
     * FR: Code de Autre<br>
     * IT: Code per Altre<br>
     */
    public static final String OTHER_CODE = "1050";

    /**
     * EN: Code for Otorhinolaryngology<br>
     * DE: Code für Oto-Rhino-Laryngologie<br>
     * FR: Code de Oto-rhino-laryngologie<br>
     * IT: Code per Otorinolaringoiatria<br>
     */
    public static final String OTORHINOLARYNGOLOGY_CODE = "1008";

    /**
     * EN: Code for Paediatrics<br>
     * DE: Code für Kinder- und Jugendmedizin<br>
     * FR: Code de Pédiatrie<br>
     * IT: Code per Pediatria<br>
     */
    public static final String PAEDIATRICS_CODE = "1006";

    /**
     * EN: Code for Paediatric surgery<br>
     * DE: Code für Kinderchirurgie<br>
     * FR: Code de Chirurgie pédiatrique<br>
     * IT: Code per Chirurgia pediatrica<br>
     */
    public static final String PAEDIATRIC_SURGERY_CODE = "1028";

    /**
     * EN: Code for Paradontology<br>
     * DE: Code für Parodontologie<br>
     * FR: Code de Parodontologie<br>
     * IT: Code per Parodontologia<br>
     */
    public static final String PARADONTOLOGY_CODE = "1048";

    /**
     * EN: Code for Pathology<br>
     * DE: Code für Pathologie<br>
     * FR: Code de Pathologie<br>
     * IT: Code per Patologia<br>
     */
    public static final String PATHOLOGY_CODE = "1009";

    /**
     * EN: Code for Pharmaceutical medicine<br>
     * DE: Code für Pharmazeutische Medizin<br>
     * FR: Code de Médecine pharmaceutique<br>
     * IT: Code per Medicina farmacologica<br>
     */
    public static final String PHARMACEUTICAL_MEDICINE_CODE = "1045";

    /**
     * EN: Code for Physical medicine and rehabilitation<br>
     * DE: Code für Physikalische Medizin und Rehabilitation<br>
     * FR: Code de Médecine physique et réadaptation<br>
     * IT: Code per Medicina fisica e riabilitazione<br>
     */
    public static final String PHYSICAL_MEDICINE_AND_REHABILITATION_CODE = "1034";

    /**
     * EN: Code for Plastic, reconstructive and aesthetic surgery<br>
     * DE: Code für Plastische, Rekonstruktive und Ästhetische Chirurgie<br>
     * FR: Code de Chirurgie plastique, reconstructive et esthétique<br>
     * IT: Code per Chirurgia plastica, ricostruttiva ed estetica<br>
     */
    public static final String PLASTIC_RECONSTRUCTIVE_AND_AESTHETIC_SURGERY_CODE = "1035";

    /**
     * EN: Code for Pneumology<br>
     * DE: Code für Pneumologie<br>
     * FR: Code de Pneumologie<br>
     * IT: Code per Pneumologia<br>
     */
    public static final String PNEUMOLOGY_CODE = "1016";

    /**
     * EN: Code for Prevention and public health<br>
     * DE: Code für Prävention und Gesundheitswesen<br>
     * FR: Code de Prévention et santé publique<br>
     * IT: Code per Prevenzione e salute pubblica<br>
     */
    public static final String PREVENTION_AND_PUBLIC_HEALTH_CODE = "1036";

    /**
     * EN: Code for Psychiatry and psychotherapy<br>
     * DE: Code für Psychiatrie und Psychotherapie<br>
     * FR: Code de Psychiatrie et psychothérapie<br>
     * IT: Code per Psichiatria e psicoterapia<br>
     */
    public static final String PSYCHIATRY_AND_PSYCHOTHERAPY_CODE = "1017";

    /**
     * EN: Code for Psychotherapy<br>
     * DE: Code für Psychotherapie<br>
     * FR: Code de psychothérapie<br>
     * IT: Code per psicoterapia<br>
     */
    public static final String PSYCHOTHERAPY_CODE = "1054";

    /**
     * EN: Code for Radiology<br>
     * DE: Code für Radiologie<br>
     * FR: Code de Radiologie<br>
     * IT: Code per Radiologia<br>
     */
    public static final String RADIOLOGY_CODE = "1030";

    /**
     * EN: Code for Radio-oncology / radiotherapy<br>
     * DE: Code für Radio-Onkologie_Strahlentherapie<br>
     * FR: Code de Radio-oncologie_radiothérapie<br>
     * IT: Code per Radio-oncologia_radioterapia<br>
     */
    public static final String RADIO_ONCOLOGY_RADIOTHERAPY_CODE = "1032";

    /**
     * EN: Code for Reconstructive dentistry<br>
     * DE: Code für Rekonstruktive Zahnmedizin<br>
     * FR: Code de Médecine dentaire reconstructive<br>
     * IT: Code per Medicina dentaria riconstruttiva<br>
     */
    public static final String RECONSTRUCTIVE_DENTISTRY_CODE = "1049";

    /**
     * EN: Code for Rheumatology<br>
     * DE: Code für Rheumatologie<br>
     * FR: Code de Rhumatologie<br>
     * IT: Code per Reumatologia<br>
     */
    public static final String RHEUMATOLOGY_CODE = "1037";

    /**
     * EN: Code for Surgery<br>
     * DE: Code für Chirurgie<br>
     * FR: Code de Chirurgie<br>
     * IT: Code per Chirurgia<br>
     */
    public static final String SURGERY_CODE = "1002";

    /**
     * EN: Code for Thoracic surgery<br>
     * DE: Code für Thoraxchirurgie<br>
     * FR: Code de Chirurgie thoracique<br>
     * IT: Code per Chirurgia toracica<br>
     */
    public static final String THORACIC_SURGERY_CODE = "1061";

    /**
     * EN: Code for Tropical and travel medicine<br>
     * DE: Code für Tropen- und Reisemedizin<br>
     * FR: Code de Médecine tropicale et médecine des voyages<br>
     * IT: Code per Medicina tropicale e medicina di viaggio<br>
     */
    public static final String TROPICAL_AND_TRAVEL_MEDICINE_CODE = "1038";

    /**
     * EN: Code for Urology<br>
     * DE: Code für Urologie<br>
     * FR: Code de Urologie<br>
     * IT: Code per Urologia<br>
     */
    public static final String UROLOGY_CODE = "1018";

    /**
     * EN: Code for Vascular surgery<br>
     * DE: Code für Gefässchirurgie<br>
     * FR: Code de Chirurgie vasculaire<br>
     * IT: Code per Chirurgia vascolare<br>
     */
    public static final String VASCULAR_SURGERY_CODE = "1060";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.8.2";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "HCProfessional.hcSpecialisation";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    public static HcpSpecialisation getEnum(final String code) {
        for (final HcpSpecialisation x : values()) {
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
            Enum.valueOf(HcpSpecialisation.class,
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
        for (final HcpSpecialisation x : values()) {
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
    HcpSpecialisation(final String code, final String codeSystem, final String displayName, final String displayNameEn, final String displayNameDe, final String displayNameFr, final String displayNameIt) {
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
