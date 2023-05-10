/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.ch.enums.r202212;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DocumentEntry.eventCodeList values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.1.8<br>
 * Effective date: 2021-04-01 17:00<br>
 * Version: 202104.0-stable<br>
 * Status: DEPRECATED
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2023-05-10")
public enum EventCodeList implements ValueSetEnumInterface {

    /**
     * EN: Autorefraction.<br>
     * DE: Autorefraktion.<br>
     * FR: Autoréfraction.<br>
     * IT: Autorifrazione.<br>
     */
    AUTOREFRACTION("AR",
                   "1.2.840.10008.2.16.4",
                   "Autorefraction",
                   "Autorefraction",
                   "Autorefraktion",
                   "Autoréfraction",
                   "Autorifrazione"),
    /**
     * EN: Bone Mineral Densitometry.<br>
     * DE: Knochenmineraldensitometrie.<br>
     * FR: Densitométrie minérale osseuse.<br>
     * IT: Mineralometria ossea computerizzata.<br>
     */
    BONE_MINERAL_DENSITOMETRY("BMD",
                              "1.2.840.10008.2.16.4",
                              "Bone Mineral Densitometry",
                              "Bone Mineral Densitometry",
                              "Knochenmineraldensitometrie",
                              "Densitométrie minérale osseuse",
                              "Mineralometria ossea computerizzata"),
    /**
     * EN: Cardiac Electrophysiology.<br>
     * DE: Herz-Elektrophysiologie.<br>
     * FR: Électrophysiologie cardiaque.<br>
     * IT: Elettrofisiologia cardiaca.<br>
     */
    CARDIAC_ELECTROPHYSIOLOGY("EPS",
                              "1.2.840.10008.2.16.4",
                              "Cardiac Electrophysiology",
                              "Cardiac Electrophysiology",
                              "Herz-Elektrophysiologie",
                              "Électrophysiologie cardiaque",
                              "Elettrofisiologia cardiaca"),
    /**
     * EN: Computed Radiography.<br>
     * DE: Computerradiografie.<br>
     * FR: Radiographie numérique.<br>
     * IT: Radiografia computerizzata.<br>
     */
    COMPUTED_RADIOGRAPHY("CR",
                         "1.2.840.10008.2.16.4",
                         "Computed Radiography",
                         "Computed Radiography",
                         "Computerradiografie",
                         "Radiographie numérique",
                         "Radiografia computerizzata"),
    /**
     * EN: Computed Tomography.<br>
     * DE: Computertomografie.<br>
     * FR: Tomographie numérique.<br>
     * IT: Tomografia computerizzata.<br>
     */
    COMPUTED_TOMOGRAPHY("CT",
                        "1.2.840.10008.2.16.4",
                        "Computed Tomography",
                        "Computed Tomography",
                        "Computertomografie",
                        "Tomographie numérique",
                        "Tomografia computerizzata"),
    /**
     * EN: Digital Radiography.<br>
     * DE: Digitales Röntgen.<br>
     * FR: Radiologie numérique.<br>
     * IT: Radiografia digitale.<br>
     */
    DIGITAL_RADIOGRAPHY("DX",
                        "1.2.840.10008.2.16.4",
                        "Digital Radiography",
                        "Digital Radiography",
                        "Digitales Röntgen",
                        "Radiologie numérique",
                        "Radiografia digitale"),
    /**
     * EN: Electrocardiography.<br>
     * DE: Elektrokardiografie.<br>
     * FR: Électrocardiographie.<br>
     * IT: Elettrocardiografia.<br>
     */
    ELECTROCARDIOGRAPHY("ECG",
                        "1.2.840.10008.2.16.4",
                        "Electrocardiography",
                        "Electrocardiography",
                        "Elektrokardiografie",
                        "Électrocardiographie",
                        "Elettrocardiografia"),
    /**
     * EN: Endoscopy.<br>
     * DE: Endoskopie.<br>
     * FR: Endoscopie.<br>
     * IT: Endoscopia.<br>
     */
    ENDOSCOPY("ES",
              "1.2.840.10008.2.16.4",
              "Endoscopy",
              "Endoscopy",
              "Endoskopie",
              "Endoscopie",
              "Endoscopia"),
    /**
     * EN: External-camera Photography.<br>
     * DE: Fotografie mit externer Kamera.<br>
     * FR: Photographie par appareil externe.<br>
     * IT: Fotografia con fotocamera esterna.<br>
     */
    EXTERNAL_CAMERA_PHOTOGRAPHY("XC",
                                "1.2.840.10008.2.16.4",
                                "External-camera Photography",
                                "External-camera Photography",
                                "Fotografie mit externer Kamera",
                                "Photographie par appareil externe",
                                "Fotografia con fotocamera esterna"),
    /**
     * EN: General Microscopy.<br>
     * DE: Allgemeine Mikroskopie.<br>
     * FR: Microscopie générale.<br>
     * IT: Microscopia generale.<br>
     */
    GENERAL_MICROSCOPY("GM",
                       "1.2.840.10008.2.16.4",
                       "General Microscopy",
                       "General Microscopy",
                       "Allgemeine Mikroskopie",
                       "Microscopie générale",
                       "Microscopia generale"),
    /**
     * EN: Hemodynamic Waveform.<br>
     * DE: Hämodynamische Druckkurve.<br>
     * FR: Courbe hémodynamique.<br>
     * IT: Monitoraggio emodinamico.<br>
     */
    HEMODYNAMIC_WAVEFORM("HD",
                         "1.2.840.10008.2.16.4",
                         "Hemodynamic Waveform",
                         "Hemodynamic Waveform",
                         "Hämodynamische Druckkurve",
                         "Courbe hémodynamique",
                         "Monitoraggio emodinamico"),
    /**
     * EN: Intravascular Optical Coherence Tomography.<br>
     * DE: Intravaskuläre optische Kohärenztomografie.<br>
     * FR: Tomographie en cohérence optique intravasculaire.<br>
     * IT: Tomografia intravascolare a coerenza ottica.<br>
     */
    INTRAVASCULAR_OPTICAL_COHERENCE_TOMOGRAPHY("IVOCT",
                                               "1.2.840.10008.2.16.4",
                                               "Intravascular Optical Coherence Tomography",
                                               "Intravascular Optical Coherence Tomography",
                                               "Intravaskuläre optische Kohärenztomografie",
                                               "Tomographie en cohérence optique intravasculaire",
                                               "Tomografia intravascolare a coerenza ottica"),
    /**
     * EN: Intravascular Ultrasound.<br>
     * DE: Intravaskulärer Ultraschall.<br>
     * FR: Ultrason intravasculaire.<br>
     * IT: Ecografia intravascolare.<br>
     */
    INTRAVASCULAR_ULTRASOUND("IVUS",
                             "1.2.840.10008.2.16.4",
                             "Intravascular Ultrasound",
                             "Intravascular Ultrasound",
                             "Intravaskulärer Ultraschall",
                             "Ultrason intravasculaire",
                             "Ecografia intravascolare"),
    /**
     * EN: Intra-oral Radiography.<br>
     * DE: Intraorales Röntgen.<br>
     * FR: Radiographie intra-orale.<br>
     * IT: Radiografia intraorale.<br>
     */
    INTRA_ORAL_RADIOGRAPHY("IO",
                           "1.2.840.10008.2.16.4",
                           "Intra-oral Radiography",
                           "Intra-oral Radiography",
                           "Intraorales Röntgen",
                           "Radiographie intra-orale",
                           "Radiografia intraorale"),
    /**
     * EN: Keratometry.<br>
     * DE: Keratometrie.<br>
     * FR: Kératométrie.<br>
     * IT: Cheratometria.<br>
     */
    KERATOMETRY("KER",
                "1.2.840.10008.2.16.4",
                "Keratometry",
                "Keratometry",
                "Keratometrie",
                "Kératométrie",
                "Cheratometria"),
    /**
     * EN: Lensometry.<br>
     * DE: Linsenmessung.<br>
     * FR: Lensométrie.<br>
     * IT: Focometria.<br>
     */
    LENSOMETRY("LEN",
               "1.2.840.10008.2.16.4",
               "Lensometry",
               "Lensometry",
               "Linsenmessung",
               "Lensométrie",
               "Focometria"),
    /**
     * EN: Magnetic Resonance.<br>
     * DE: Magnetresonanz.<br>
     * FR: Résonance magnétique.<br>
     * IT: Risonanza magnetica.<br>
     */
    MAGNETIC_RESONANCE("MR",
                       "1.2.840.10008.2.16.4",
                       "Magnetic Resonance",
                       "Magnetic Resonance",
                       "Magnetresonanz",
                       "Résonance magnétique",
                       "Risonanza magnetica"),
    /**
     * EN: Mammography.<br>
     * DE: Mammografie.<br>
     * FR: Mammographie.<br>
     * IT: Mammografia.<br>
     */
    MAMMOGRAPHY("MG",
                "1.2.840.10008.2.16.4",
                "Mammography",
                "Mammography",
                "Mammografie",
                "Mammographie",
                "Mammografia"),
    /**
     * EN: Nuclear Medicine.<br>
     * DE: Nuklearmedizin.<br>
     * FR: Médecine nucléaire.<br>
     * IT: Medicina nucleare.<br>
     */
    NUCLEAR_MEDICINE("NM",
                     "1.2.840.10008.2.16.4",
                     "Nuclear Medicine",
                     "Nuclear Medicine",
                     "Nuklearmedizin",
                     "Médecine nucléaire",
                     "Medicina nucleare"),
    /**
     * EN: Ophthalmic Axial Measurements.<br>
     * DE: Augenachsenmessungen.<br>
     * FR: Mesures axiales ophtalmiques.<br>
     * IT: Misurazioni oftalmiche assiali.<br>
     */
    OPHTHALMIC_AXIAL_MEASUREMENTS("OAM",
                                  "1.2.840.10008.2.16.4",
                                  "Ophthalmic Axial Measurements",
                                  "Ophthalmic Axial Measurements",
                                  "Augenachsenmessungen",
                                  "Mesures axiales ophtalmiques",
                                  "Misurazioni oftalmiche assiali"),
    /**
     * EN: Ophthalmic Mapping.<br>
     * DE: Augenkartierung.<br>
     * FR: Cartographie ophtalmique.<br>
     * IT: Mappatura oftalmica.<br>
     */
    OPHTHALMIC_MAPPING("OPM",
                       "1.2.840.10008.2.16.4",
                       "Ophthalmic Mapping",
                       "Ophthalmic Mapping",
                       "Augenkartierung",
                       "Cartographie ophtalmique",
                       "Mappatura oftalmica"),
    /**
     * EN: Ophthalmic Photography.<br>
     * DE: Augenfotografie.<br>
     * FR: Photographie ophtalmique.<br>
     * IT: Fotografia oftalmica.<br>
     */
    OPHTHALMIC_PHOTOGRAPHY("OP",
                           "1.2.840.10008.2.16.4",
                           "Ophthalmic Photography",
                           "Ophthalmic Photography",
                           "Augenfotografie",
                           "Photographie ophtalmique",
                           "Fotografia oftalmica"),
    /**
     * EN: Ophthalmic Refraction.<br>
     * DE: Augenrefraktion.<br>
     * FR: Réfraction ophtalmique.<br>
     * IT: Rifrazione oggettiva.<br>
     */
    OPHTHALMIC_REFRACTION("OPR",
                          "1.2.840.10008.2.16.4",
                          "Ophthalmic Refraction",
                          "Ophthalmic Refraction",
                          "Augenrefraktion",
                          "Réfraction ophtalmique",
                          "Rifrazione oggettiva"),
    /**
     * EN: Ophthalmic Tomography.<br>
     * DE: Augentomografie.<br>
     * FR: Tomographie ophtalmique.<br>
     * IT: Tomografia ottica computerizzata.<br>
     */
    OPHTHALMIC_TOMOGRAPHY("OPT",
                          "1.2.840.10008.2.16.4",
                          "Ophthalmic Tomography",
                          "Ophthalmic Tomography",
                          "Augentomografie",
                          "Tomographie ophtalmique",
                          "Tomografia ottica computerizzata"),
    /**
     * EN: Ophthalmic Tomography B-scan Volume Analysis.<br>
     * DE: Ophthalmologische Tomographie B-Scan Volumenanalyse.<br>
     * FR: Analyse du volume de la tomographie ophtalmique B-scan.<br>
     * IT: Analisi del volume della scansione B della tomografia oftalmica.<br>
     */
    OPHTHALMIC_TOMOGRAPHY_B_SCAN_VOLUME_ANALYSIS("OPTBSV",
                                                 "1.2.840.10008.2.16.4",
                                                 "Ophthalmic Tomography B-scan Volume Analysis",
                                                 "Ophthalmic Tomography B-scan Volume Analysis",
                                                 "Ophthalmologische Tomographie B-Scan Volumenanalyse",
                                                 "Analyse du volume de la tomographie ophtalmique B-scan",
                                                 "Analisi del volume della scansione B della tomografia oftalmica"),
    /**
     * EN: Ophthalmic Tomography En Face.<br>
     * DE: Ophthalmische Tomographie En Face.<br>
     * FR: Tomographie ophtalmique en face.<br>
     * IT: Tomografia oftalmica En Face.<br>
     */
    OPHTHALMIC_TOMOGRAPHY_EN_FACE("OPTENF",
                                  "1.2.840.10008.2.16.4",
                                  "Ophthalmic Tomography En Face",
                                  "Ophthalmic Tomography En Face",
                                  "Ophthalmische Tomographie En Face",
                                  "Tomographie ophtalmique en face",
                                  "Tomografia oftalmica En Face"),
    /**
     * EN: Ophthalmic Visual Field.<br>
     * DE: Gesichtsfeld der Augen.<br>
     * FR: Champ visuel ophtalmique.<br>
     * IT: Perimetria computerizzata.<br>
     */
    OPHTHALMIC_VISUAL_FIELD("OPV",
                            "1.2.840.10008.2.16.4",
                            "Ophthalmic Visual Field",
                            "Ophthalmic Visual Field",
                            "Gesichtsfeld der Augen",
                            "Champ visuel ophtalmique",
                            "Perimetria computerizzata"),
    /**
     * EN: Optical Coherence Tomography.<br>
     * DE: Optische Kohärenztomografie.<br>
     * FR: Tomographie en cohérence optique.<br>
     * IT: Tomografia a coerenza ottica.<br>
     */
    OPTICAL_COHERENCE_TOMOGRAPHY("OCT",
                                 "1.2.840.10008.2.16.4",
                                 "Optical Coherence Tomography",
                                 "Optical Coherence Tomography",
                                 "Optische Kohärenztomografie",
                                 "Tomographie en cohérence optique",
                                 "Tomografia a coerenza ottica"),
    /**
     * EN: Optical Surface Scanner.<br>
     * DE: Optischer Oberflächenscanner.<br>
     * FR: Scanneur optique de surface.<br>
     * IT: Scanner ottico per superfici.<br>
     */
    OPTICAL_SURFACE_SCANNER("OSS",
                            "1.2.840.10008.2.16.4",
                            "Optical Surface Scanner",
                            "Optical Surface Scanner",
                            "Optischer Oberflächenscanner",
                            "Scanneur optique de surface",
                            "Scanner ottico per superfici"),
    /**
     * EN: Panoramic X-Ray.<br>
     * DE: Panoramaröntgen.<br>
     * FR: Radiographie panoramique.<br>
     * IT: Radiografia panoramica.<br>
     */
    PANORAMIC_X_RAY("PX",
                    "1.2.840.10008.2.16.4",
                    "Panoramic X-Ray",
                    "Panoramic X-Ray",
                    "Panoramaröntgen",
                    "Radiographie panoramique",
                    "Radiografia panoramica"),
    /**
     * EN: Positron emission tomography.<br>
     * DE: Positronen-Emissions-Tomografie.<br>
     * FR: Tomographie par émission de positons.<br>
     * IT: Tomografia a emissione di positroni.<br>
     */
    POSITRON_EMISSION_TOMOGRAPHY("PT",
                                 "1.2.840.10008.2.16.4",
                                 "Positron emission tomography",
                                 "Positron emission tomography",
                                 "Positronen-Emissions-Tomografie",
                                 "Tomographie par émission de positons",
                                 "Tomografia a emissione di positroni"),
    /**
     * EN: Radiofluoroscopy.<br>
     * DE: Radio-Fluoroskopie.<br>
     * FR: Radio-fluoroscopie.<br>
     * IT: Radiofluoroscopia.<br>
     */
    RADIOFLUOROSCOPY("RF",
                     "1.2.840.10008.2.16.4",
                     "Radiofluoroscopy",
                     "Radiofluoroscopy",
                     "Radio-Fluoroskopie",
                     "Radio-fluoroscopie",
                     "Radiofluoroscopia"),
    /**
     * EN: Radiographic imaging.<br>
     * DE: Röntgenbildgebung.<br>
     * FR: Imagerie radiographique.<br>
     * IT: Imaging radiografico.<br>
     */
    RADIOGRAPHIC_IMAGING("RG",
                         "1.2.840.10008.2.16.4",
                         "Radiographic imaging",
                         "Radiographic imaging",
                         "Röntgenbildgebung",
                         "Imagerie radiographique",
                         "Imaging radiografico"),
    /**
     * EN: Slide Microscopy.<br>
     * DE: Objektträger Mikroskopie.<br>
     * FR: Microscopie avec lamelles.<br>
     * IT: Microscopia a vetrini.<br>
     */
    SLIDE_MICROSCOPY("SM",
                     "1.2.840.10008.2.16.4",
                     "Slide Microscopy",
                     "Slide Microscopy",
                     "Objektträger Mikroskopie",
                     "Microscopie avec lamelles",
                     "Microscopia a vetrini"),
    /**
     * EN: Subjective Refraction.<br>
     * DE: Subjektive Refraktion.<br>
     * FR: Réfraction subjective.<br>
     * IT: Rifrazione soggettiva.<br>
     */
    SUBJECTIVE_REFRACTION("SRF",
                          "1.2.840.10008.2.16.4",
                          "Subjective Refraction",
                          "Subjective Refraction",
                          "Subjektive Refraktion",
                          "Réfraction subjective",
                          "Rifrazione soggettiva"),
    /**
     * EN: Ultrasound.<br>
     * DE: Ultraschall.<br>
     * FR: Ultrason.<br>
     * IT: Ecografia.<br>
     */
    ULTRASOUND("US",
               "1.2.840.10008.2.16.4",
               "Ultrasound",
               "Ultrasound",
               "Ultraschall",
               "Ultrason",
               "Ecografia"),
    /**
     * EN: Ultrasound Bone Densitometry.<br>
     * DE: Ultraschall-Knochendichtemessung.<br>
     * FR: Densitométrie osseuse par ultrasons.<br>
     * IT: Densitometria ossea a ultrasuoni.<br>
     */
    ULTRASOUND_BONE_DENSITOMETRY("BDUS",
                                 "1.2.840.10008.2.16.4",
                                 "Ultrasound Bone Densitometry",
                                 "Ultrasound Bone Densitometry",
                                 "Ultraschall-Knochendichtemessung",
                                 "Densitométrie osseuse par ultrasons",
                                 "Densitometria ossea a ultrasuoni"),
    /**
     * EN: Visual Acuity.<br>
     * DE: Sehschärfe.<br>
     * FR: Acuité visuelle.<br>
     * IT: Acutezza visiva.<br>
     */
    VISUAL_ACUITY("VA",
                  "1.2.840.10008.2.16.4",
                  "Visual Acuity",
                  "Visual Acuity",
                  "Sehschärfe",
                  "Acuité visuelle",
                  "Acutezza visiva"),
    /**
     * EN: X-Ray Angiography.<br>
     * DE: Röntgen-Angiografie.<br>
     * FR: Angiographie par rayons X.<br>
     * IT: Angiografia a raggi X.<br>
     */
    X_RAY_ANGIOGRAPHY("XA",
                      "1.2.840.10008.2.16.4",
                      "X-Ray Angiography",
                      "X-Ray Angiography",
                      "Röntgen-Angiografie",
                      "Angiographie par rayons X",
                      "Angiografia a raggi X");

    /**
     * EN: Code for Autorefraction.<br>
     * DE: Code für Autorefraktion.<br>
     * FR: Code de Autoréfraction.<br>
     * IT: Code per Autorifrazione.<br>
     */
    public static final String AUTOREFRACTION_CODE = "AR";

    /**
     * EN: Code for Bone Mineral Densitometry.<br>
     * DE: Code für Knochenmineraldensitometrie.<br>
     * FR: Code de Densitométrie minérale osseuse.<br>
     * IT: Code per Mineralometria ossea computerizzata.<br>
     */
    public static final String BONE_MINERAL_DENSITOMETRY_CODE = "BMD";

    /**
     * EN: Code for Cardiac Electrophysiology.<br>
     * DE: Code für Herz-Elektrophysiologie.<br>
     * FR: Code de Électrophysiologie cardiaque.<br>
     * IT: Code per Elettrofisiologia cardiaca.<br>
     */
    public static final String CARDIAC_ELECTROPHYSIOLOGY_CODE = "EPS";

    /**
     * EN: Code for Computed Radiography.<br>
     * DE: Code für Computerradiografie.<br>
     * FR: Code de Radiographie numérique.<br>
     * IT: Code per Radiografia computerizzata.<br>
     */
    public static final String COMPUTED_RADIOGRAPHY_CODE = "CR";

    /**
     * EN: Code for Computed Tomography.<br>
     * DE: Code für Computertomografie.<br>
     * FR: Code de Tomographie numérique.<br>
     * IT: Code per Tomografia computerizzata.<br>
     */
    public static final String COMPUTED_TOMOGRAPHY_CODE = "CT";

    /**
     * EN: Code for Digital Radiography.<br>
     * DE: Code für Digitales Röntgen.<br>
     * FR: Code de Radiologie numérique.<br>
     * IT: Code per Radiografia digitale.<br>
     */
    public static final String DIGITAL_RADIOGRAPHY_CODE = "DX";

    /**
     * EN: Code for Electrocardiography.<br>
     * DE: Code für Elektrokardiografie.<br>
     * FR: Code de Électrocardiographie.<br>
     * IT: Code per Elettrocardiografia.<br>
     */
    public static final String ELECTROCARDIOGRAPHY_CODE = "ECG";

    /**
     * EN: Code for Endoscopy.<br>
     * DE: Code für Endoskopie.<br>
     * FR: Code de Endoscopie.<br>
     * IT: Code per Endoscopia.<br>
     */
    public static final String ENDOSCOPY_CODE = "ES";

    /**
     * EN: Code for External-camera Photography.<br>
     * DE: Code für Fotografie mit externer Kamera.<br>
     * FR: Code de Photographie par appareil externe.<br>
     * IT: Code per Fotografia con fotocamera esterna.<br>
     */
    public static final String EXTERNAL_CAMERA_PHOTOGRAPHY_CODE = "XC";

    /**
     * EN: Code for General Microscopy.<br>
     * DE: Code für Allgemeine Mikroskopie.<br>
     * FR: Code de Microscopie générale.<br>
     * IT: Code per Microscopia generale.<br>
     */
    public static final String GENERAL_MICROSCOPY_CODE = "GM";

    /**
     * EN: Code for Hemodynamic Waveform.<br>
     * DE: Code für Hämodynamische Druckkurve.<br>
     * FR: Code de Courbe hémodynamique.<br>
     * IT: Code per Monitoraggio emodinamico.<br>
     */
    public static final String HEMODYNAMIC_WAVEFORM_CODE = "HD";

    /**
     * EN: Code for Intravascular Optical Coherence Tomography.<br>
     * DE: Code für Intravaskuläre optische Kohärenztomografie.<br>
     * FR: Code de Tomographie en cohérence optique intravasculaire.<br>
     * IT: Code per Tomografia intravascolare a coerenza ottica.<br>
     */
    public static final String INTRAVASCULAR_OPTICAL_COHERENCE_TOMOGRAPHY_CODE = "IVOCT";

    /**
     * EN: Code for Intravascular Ultrasound.<br>
     * DE: Code für Intravaskulärer Ultraschall.<br>
     * FR: Code de Ultrason intravasculaire.<br>
     * IT: Code per Ecografia intravascolare.<br>
     */
    public static final String INTRAVASCULAR_ULTRASOUND_CODE = "IVUS";

    /**
     * EN: Code for Intra-oral Radiography.<br>
     * DE: Code für Intraorales Röntgen.<br>
     * FR: Code de Radiographie intra-orale.<br>
     * IT: Code per Radiografia intraorale.<br>
     */
    public static final String INTRA_ORAL_RADIOGRAPHY_CODE = "IO";

    /**
     * EN: Code for Keratometry.<br>
     * DE: Code für Keratometrie.<br>
     * FR: Code de Kératométrie.<br>
     * IT: Code per Cheratometria.<br>
     */
    public static final String KERATOMETRY_CODE = "KER";

    /**
     * EN: Code for Lensometry.<br>
     * DE: Code für Linsenmessung.<br>
     * FR: Code de Lensométrie.<br>
     * IT: Code per Focometria.<br>
     */
    public static final String LENSOMETRY_CODE = "LEN";

    /**
     * EN: Code for Magnetic Resonance.<br>
     * DE: Code für Magnetresonanz.<br>
     * FR: Code de Résonance magnétique.<br>
     * IT: Code per Risonanza magnetica.<br>
     */
    public static final String MAGNETIC_RESONANCE_CODE = "MR";

    /**
     * EN: Code for Mammography.<br>
     * DE: Code für Mammografie.<br>
     * FR: Code de Mammographie.<br>
     * IT: Code per Mammografia.<br>
     */
    public static final String MAMMOGRAPHY_CODE = "MG";

    /**
     * EN: Code for Nuclear Medicine.<br>
     * DE: Code für Nuklearmedizin.<br>
     * FR: Code de Médecine nucléaire.<br>
     * IT: Code per Medicina nucleare.<br>
     */
    public static final String NUCLEAR_MEDICINE_CODE = "NM";

    /**
     * EN: Code for Ophthalmic Axial Measurements.<br>
     * DE: Code für Augenachsenmessungen.<br>
     * FR: Code de Mesures axiales ophtalmiques.<br>
     * IT: Code per Misurazioni oftalmiche assiali.<br>
     */
    public static final String OPHTHALMIC_AXIAL_MEASUREMENTS_CODE = "OAM";

    /**
     * EN: Code for Ophthalmic Mapping.<br>
     * DE: Code für Augenkartierung.<br>
     * FR: Code de Cartographie ophtalmique.<br>
     * IT: Code per Mappatura oftalmica.<br>
     */
    public static final String OPHTHALMIC_MAPPING_CODE = "OPM";

    /**
     * EN: Code for Ophthalmic Photography.<br>
     * DE: Code für Augenfotografie.<br>
     * FR: Code de Photographie ophtalmique.<br>
     * IT: Code per Fotografia oftalmica.<br>
     */
    public static final String OPHTHALMIC_PHOTOGRAPHY_CODE = "OP";

    /**
     * EN: Code for Ophthalmic Refraction.<br>
     * DE: Code für Augenrefraktion.<br>
     * FR: Code de Réfraction ophtalmique.<br>
     * IT: Code per Rifrazione oggettiva.<br>
     */
    public static final String OPHTHALMIC_REFRACTION_CODE = "OPR";

    /**
     * EN: Code for Ophthalmic Tomography.<br>
     * DE: Code für Augentomografie.<br>
     * FR: Code de Tomographie ophtalmique.<br>
     * IT: Code per Tomografia ottica computerizzata.<br>
     */
    public static final String OPHTHALMIC_TOMOGRAPHY_CODE = "OPT";

    /**
     * EN: Code for Ophthalmic Tomography B-scan Volume Analysis.<br>
     * DE: Code für Ophthalmologische Tomographie B-Scan Volumenanalyse.<br>
     * FR: Code de Analyse du volume de la tomographie ophtalmique B-scan.<br>
     * IT: Code per Analisi del volume della scansione B della tomografia oftalmica.<br>
     */
    public static final String OPHTHALMIC_TOMOGRAPHY_B_SCAN_VOLUME_ANALYSIS_CODE = "OPTBSV";

    /**
     * EN: Code for Ophthalmic Tomography En Face.<br>
     * DE: Code für Ophthalmische Tomographie En Face.<br>
     * FR: Code de Tomographie ophtalmique en face.<br>
     * IT: Code per Tomografia oftalmica En Face.<br>
     */
    public static final String OPHTHALMIC_TOMOGRAPHY_EN_FACE_CODE = "OPTENF";

    /**
     * EN: Code for Ophthalmic Visual Field.<br>
     * DE: Code für Gesichtsfeld der Augen.<br>
     * FR: Code de Champ visuel ophtalmique.<br>
     * IT: Code per Perimetria computerizzata.<br>
     */
    public static final String OPHTHALMIC_VISUAL_FIELD_CODE = "OPV";

    /**
     * EN: Code for Optical Coherence Tomography.<br>
     * DE: Code für Optische Kohärenztomografie.<br>
     * FR: Code de Tomographie en cohérence optique.<br>
     * IT: Code per Tomografia a coerenza ottica.<br>
     */
    public static final String OPTICAL_COHERENCE_TOMOGRAPHY_CODE = "OCT";

    /**
     * EN: Code for Optical Surface Scanner.<br>
     * DE: Code für Optischer Oberflächenscanner.<br>
     * FR: Code de Scanneur optique de surface.<br>
     * IT: Code per Scanner ottico per superfici.<br>
     */
    public static final String OPTICAL_SURFACE_SCANNER_CODE = "OSS";

    /**
     * EN: Code for Panoramic X-Ray.<br>
     * DE: Code für Panoramaröntgen.<br>
     * FR: Code de Radiographie panoramique.<br>
     * IT: Code per Radiografia panoramica.<br>
     */
    public static final String PANORAMIC_X_RAY_CODE = "PX";

    /**
     * EN: Code for Positron emission tomography.<br>
     * DE: Code für Positronen-Emissions-Tomografie.<br>
     * FR: Code de Tomographie par émission de positons.<br>
     * IT: Code per Tomografia a emissione di positroni.<br>
     */
    public static final String POSITRON_EMISSION_TOMOGRAPHY_CODE = "PT";

    /**
     * EN: Code for Radiofluoroscopy.<br>
     * DE: Code für Radio-Fluoroskopie.<br>
     * FR: Code de Radio-fluoroscopie.<br>
     * IT: Code per Radiofluoroscopia.<br>
     */
    public static final String RADIOFLUOROSCOPY_CODE = "RF";

    /**
     * EN: Code for Radiographic imaging.<br>
     * DE: Code für Röntgenbildgebung.<br>
     * FR: Code de Imagerie radiographique.<br>
     * IT: Code per Imaging radiografico.<br>
     */
    public static final String RADIOGRAPHIC_IMAGING_CODE = "RG";

    /**
     * EN: Code for Slide Microscopy.<br>
     * DE: Code für Objektträger Mikroskopie.<br>
     * FR: Code de Microscopie avec lamelles.<br>
     * IT: Code per Microscopia a vetrini.<br>
     */
    public static final String SLIDE_MICROSCOPY_CODE = "SM";

    /**
     * EN: Code for Subjective Refraction.<br>
     * DE: Code für Subjektive Refraktion.<br>
     * FR: Code de Réfraction subjective.<br>
     * IT: Code per Rifrazione soggettiva.<br>
     */
    public static final String SUBJECTIVE_REFRACTION_CODE = "SRF";

    /**
     * EN: Code for Ultrasound.<br>
     * DE: Code für Ultraschall.<br>
     * FR: Code de Ultrason.<br>
     * IT: Code per Ecografia.<br>
     */
    public static final String ULTRASOUND_CODE = "US";

    /**
     * EN: Code for Ultrasound Bone Densitometry.<br>
     * DE: Code für Ultraschall-Knochendichtemessung.<br>
     * FR: Code de Densitométrie osseuse par ultrasons.<br>
     * IT: Code per Densitometria ossea a ultrasuoni.<br>
     */
    public static final String ULTRASOUND_BONE_DENSITOMETRY_CODE = "BDUS";

    /**
     * EN: Code for Visual Acuity.<br>
     * DE: Code für Sehschärfe.<br>
     * FR: Code de Acuité visuelle.<br>
     * IT: Code per Acutezza visiva.<br>
     */
    public static final String VISUAL_ACUITY_CODE = "VA";

    /**
     * EN: Code for X-Ray Angiography.<br>
     * DE: Code für Röntgen-Angiografie.<br>
     * FR: Code de Angiographie par rayons X.<br>
     * IT: Code per Angiografia a raggi X.<br>
     */
    public static final String X_RAY_ANGIOGRAPHY_CODE = "XA";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.8";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.eventCodeList";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "1.2.840.10008.2.16.4";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static EventCodeList getEnum(@Nullable final String code) {
        for (final EventCodeList x : values()) {
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
            Enum.valueOf(EventCodeList.class,
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
        for (final EventCodeList x : values()) {
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
    EventCodeList(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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
