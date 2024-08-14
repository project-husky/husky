/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.fhir.emed.ch.common.enums;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.fhir.structures.utils.FhirValueSetEnumInterface;

/**
 * Enumeration of ActivePharmaceuticalIngredient values
 * <p>
 * EN: No designation found.<br>
 * DE: No designation found.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.1.11.82<br>
 * Effective date: 2023-10-27 13:24<br>
 * Version: 2023<br>
 * Status: FINAL
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2024-07-18")
public enum ActivePharmaceuticalIngredient implements ValueSetEnumInterface, FhirValueSetEnumInterface {

    /**
     * EN: Abacavir.<br>
     * DE: Abacavir.<br>
     * FR: abacavir.<br>
     * IT: Abacavir.<br>
     */
    ABACAVIR("387005008",
             "http://snomed.info/sct",
             "Abacavir (substance)",
             "Abacavir",
             "Abacavir",
             "abacavir",
             "Abacavir"),
    /**
     * EN: Abatacept.<br>
     * DE: Abatacept.<br>
     * FR: abatacept.<br>
     * IT: Abatacept.<br>
     */
    ABATACEPT("421777009",
              "http://snomed.info/sct",
              "Abatacept (substance)",
              "Abatacept",
              "Abatacept",
              "abatacept",
              "Abatacept"),
    /**
     * EN: Abciximab.<br>
     * DE: Abciximab.<br>
     * FR: abciximab.<br>
     * IT: Abciximab.<br>
     */
    ABCIXIMAB("386951001",
              "http://snomed.info/sct",
              "Abciximab (substance)",
              "Abciximab",
              "Abciximab",
              "abciximab",
              "Abciximab"),
    /**
     * EN: Abemaciclib.<br>
     * DE: Abemaciclib.<br>
     * FR: abémaciclib.<br>
     * IT: Abemaciclib.<br>
     */
    ABEMACICLIB("761851004",
                "http://snomed.info/sct",
                "Abemaciclib (substance)",
                "Abemaciclib",
                "Abemaciclib",
                "abémaciclib",
                "Abemaciclib"),
    /**
     * EN: Abiraterone.<br>
     * DE: Abirateron.<br>
     * FR: abiratérone.<br>
     * IT: Abiraterone.<br>
     */
    ABIRATERONE("699678007",
                "http://snomed.info/sct",
                "Abiraterone (substance)",
                "Abiraterone",
                "Abirateron",
                "abiratérone",
                "Abiraterone"),
    /**
     * EN: Acamprosate.<br>
     * DE: Acamprosat.<br>
     * FR: acamprosate.<br>
     * IT: Acamprosato.<br>
     */
    ACAMPROSATE("391698009",
                "http://snomed.info/sct",
                "Acamprosate (substance)",
                "Acamprosate",
                "Acamprosat",
                "acamprosate",
                "Acamprosato"),
    /**
     * EN: Acarbose.<br>
     * DE: Acarbose.<br>
     * FR: acarbose.<br>
     * IT: Acarbosio.<br>
     */
    ACARBOSE("386965004",
             "http://snomed.info/sct",
             "Acarbose (substance)",
             "Acarbose",
             "Acarbose",
             "acarbose",
             "Acarbosio"),
    /**
     * EN: Acemetacin.<br>
     * DE: Acemetacin.<br>
     * FR: acémétacine.<br>
     * IT: Acemetacina.<br>
     */
    ACEMETACIN("391704009",
               "http://snomed.info/sct",
               "Acemetacin (substance)",
               "Acemetacin",
               "Acemetacin",
               "acémétacine",
               "Acemetacina"),
    /**
     * EN: Acenocoumarol.<br>
     * DE: Acenocoumarol.<br>
     * FR: acénocoumarol.<br>
     * IT: Acenocumarolo.<br>
     */
    ACENOCOUMAROL("387457003",
                  "http://snomed.info/sct",
                  "Acenocoumarol (substance)",
                  "Acenocoumarol",
                  "Acenocoumarol",
                  "acénocoumarol",
                  "Acenocumarolo"),
    /**
     * EN: Acetazolamide.<br>
     * DE: Acetazolamid.<br>
     * FR: acétazolamide.<br>
     * IT: Acetazolamide.<br>
     */
    ACETAZOLAMIDE("372709008",
                  "http://snomed.info/sct",
                  "Acetazolamide (substance)",
                  "Acetazolamide",
                  "Acetazolamid",
                  "acétazolamide",
                  "Acetazolamide"),
    /**
     * EN: Acetylcysteine.<br>
     * DE: Acetylcystein.<br>
     * FR: acétylcystéine.<br>
     * IT: Acetilcisteina.<br>
     */
    ACETYLCYSTEINE("387440002",
                   "http://snomed.info/sct",
                   "Acetylcysteine (substance)",
                   "Acetylcysteine",
                   "Acetylcystein",
                   "acétylcystéine",
                   "Acetilcisteina"),
    /**
     * EN: Aciclovir.<br>
     * DE: Aciclovir.<br>
     * FR: aciclovir.<br>
     * IT: Aciclovir.<br>
     */
    ACICLOVIR("372729009",
              "http://snomed.info/sct",
              "Aciclovir (substance)",
              "Aciclovir",
              "Aciclovir",
              "aciclovir",
              "Aciclovir"),
    /**
     * EN: Acipimox.<br>
     * DE: Acipimox.<br>
     * FR: acipimox.<br>
     * IT: Acipimox.<br>
     */
    ACIPIMOX("391711008",
             "http://snomed.info/sct",
             "Acipimox (substance)",
             "Acipimox",
             "Acipimox",
             "acipimox",
             "Acipimox"),
    /**
     * EN: Acitretin.<br>
     * DE: Acitretin.<br>
     * FR: acitrétine.<br>
     * IT: Acitretina.<br>
     */
    ACITRETIN("386938006",
              "http://snomed.info/sct",
              "Acitretin (substance)",
              "Acitretin",
              "Acitretin",
              "acitrétine",
              "Acitretina"),
    /**
     * EN: Aclidinium.<br>
     * DE: Aclidinium-Kation.<br>
     * FR: aclidinium.<br>
     * IT: Aclidinio.<br>
     */
    ACLIDINIUM("703921008",
               "http://snomed.info/sct",
               "Aclidinium (substance)",
               "Aclidinium",
               "Aclidinium-Kation",
               "aclidinium",
               "Aclidinio"),
    /**
     * EN: Activated charcoal.<br>
     * DE: Kohle, medizinische.<br>
     * FR: charbon activé.<br>
     * IT: Carbone attivo.<br>
     */
    ACTIVATED_CHARCOAL("32519007",
                       "http://snomed.info/sct",
                       "Activated charcoal (substance)",
                       "Activated charcoal",
                       "Kohle, medizinische",
                       "charbon activé",
                       "Carbone attivo"),
    /**
     * EN: Adalimumab.<br>
     * DE: Adalimumab.<br>
     * FR: adalimumab.<br>
     * IT: Adalimumab.<br>
     */
    ADALIMUMAB("407317001",
               "http://snomed.info/sct",
               "Adalimumab (substance)",
               "Adalimumab",
               "Adalimumab",
               "adalimumab",
               "Adalimumab"),
    /**
     * EN: Adapalene.<br>
     * DE: Adapalen.<br>
     * FR: adapalène.<br>
     * IT: Adapalene.<br>
     */
    ADAPALENE("386934008",
              "http://snomed.info/sct",
              "Adapalene (substance)",
              "Adapalene",
              "Adapalen",
              "adapalène",
              "Adapalene"),
    /**
     * EN: Adefovir.<br>
     * DE: Adefovir.<br>
     * FR: adéfovir.<br>
     * IT: Adefovir.<br>
     */
    ADEFOVIR("412072006",
             "http://snomed.info/sct",
             "Adefovir (substance)",
             "Adefovir",
             "Adefovir",
             "adéfovir",
             "Adefovir"),
    /**
     * EN: Adenosine.<br>
     * DE: Adenosin.<br>
     * FR: adénosine.<br>
     * IT: Adenosina.<br>
     */
    ADENOSINE("35431001",
              "http://snomed.info/sct",
              "Adenosine (substance)",
              "Adenosine",
              "Adenosin",
              "adénosine",
              "Adenosina"),
    /**
     * EN: Afatinib.<br>
     * DE: Afatinib.<br>
     * FR: afatinib.<br>
     * IT: Afatinib.<br>
     */
    AFATINIB("703579002",
             "http://snomed.info/sct",
             "Afatinib (substance)",
             "Afatinib",
             "Afatinib",
             "afatinib",
             "Afatinib"),
    /**
     * EN: Aflibercept.<br>
     * DE: Aflibercept.<br>
     * FR: aflibercept.<br>
     * IT: Aflibercept.<br>
     */
    AFLIBERCEPT("703840003",
                "http://snomed.info/sct",
                "Aflibercept (substance)",
                "Aflibercept",
                "Aflibercept",
                "aflibercept",
                "Aflibercept"),
    /**
     * EN: Agalsidase alfa.<br>
     * DE: Agalsidase alfa.<br>
     * FR: agalsidase alfa.<br>
     * IT: Agalsidasi alfa.<br>
     */
    AGALSIDASE_ALFA("424905009",
                    "http://snomed.info/sct",
                    "Agalsidase alfa (substance)",
                    "Agalsidase alfa",
                    "Agalsidase alfa",
                    "agalsidase alfa",
                    "Agalsidasi alfa"),
    /**
     * EN: Agalsidase beta.<br>
     * DE: Agalsidase beta.<br>
     * FR: agalsidase bêta.<br>
     * IT: Agalsidasi beta.<br>
     */
    AGALSIDASE_BETA("424725004",
                    "http://snomed.info/sct",
                    "Agalsidase beta (substance)",
                    "Agalsidase beta",
                    "Agalsidase beta",
                    "agalsidase bêta",
                    "Agalsidasi beta"),
    /**
     * EN: Agomelatine.<br>
     * DE: Agomelatin.<br>
     * FR: agomélatine.<br>
     * IT: Agomelatina.<br>
     */
    AGOMELATINE("698012009",
                "http://snomed.info/sct",
                "Agomelatine (substance)",
                "Agomelatine",
                "Agomelatin",
                "agomélatine",
                "Agomelatina"),
    /**
     * EN: Ajmaline.<br>
     * DE: Ajmalin.<br>
     * FR: ajmaline.<br>
     * IT: ajmaline.<br>
     */
    AJMALINE("1156230005",
             "http://snomed.info/sct",
             "Ajmaline (substance)",
             "Ajmaline",
             "Ajmalin",
             "ajmaline",
             "ajmaline"),
    /**
     * EN: Alanine.<br>
     * DE: Alanin.<br>
     * FR: alanine.<br>
     * IT: Alanina.<br>
     */
    ALANINE("58753009",
            "http://snomed.info/sct",
            "Alanine (substance)",
            "Alanine",
            "Alanin",
            "alanine",
            "Alanina"),
    /**
     * EN: Alanylglutamine.<br>
     * DE: Alanyl glutamin.<br>
     * FR: alanyl glutamine.<br>
     * IT: Alanil glutammina.<br>
     */
    ALANYLGLUTAMINE("703391005",
                    "http://snomed.info/sct",
                    "Alanylglutamine (substance)",
                    "Alanylglutamine",
                    "Alanyl glutamin",
                    "alanyl glutamine",
                    "Alanil glutammina"),
    /**
     * EN: Albendazole.<br>
     * DE: Albendazol.<br>
     * FR: albendazole.<br>
     * IT: Albendazolo.<br>
     */
    ALBENDAZOLE("387558006",
                "http://snomed.info/sct",
                "Albendazole (substance)",
                "Albendazole",
                "Albendazol",
                "albendazole",
                "Albendazolo"),
    /**
     * EN: Albiglutide.<br>
     * DE: Albiglutid.<br>
     * FR: albiglutide.<br>
     * IT: Albiglutide.<br>
     */
    ALBIGLUTIDE("703129009",
                "http://snomed.info/sct",
                "Albiglutide (substance)",
                "Albiglutide",
                "Albiglutid",
                "albiglutide",
                "Albiglutide"),
    /**
     * EN: Albumin.<br>
     * DE: Albumine.<br>
     * FR: albumine.<br>
     * IT: Albumina.<br>
     */
    ALBUMIN("52454007",
            "http://snomed.info/sct",
            "Albumin (substance)",
            "Albumin",
            "Albumine",
            "albumine",
            "Albumina"),
    /**
     * EN: Albutrepenonacog alfa.<br>
     * DE: Albutrepenonacog alfa.<br>
     * FR: albutrépénonacog alfa.<br>
     * IT: Albutrepenonacog alfa.<br>
     */
    ALBUTREPENONACOG_ALFA("718928008",
                          "http://snomed.info/sct",
                          "Albutrepenonacog alfa (substance)",
                          "Albutrepenonacog alfa",
                          "Albutrepenonacog alfa",
                          "albutrépénonacog alfa",
                          "Albutrepenonacog alfa"),
    /**
     * EN: Alcohol.<br>
     * DE: Ethanol.<br>
     * FR: éthanol.<br>
     * IT: Alcol etilico.<br>
     */
    ALCOHOL("53041004",
            "http://snomed.info/sct",
            "Alcohol (substance)",
            "Alcohol",
            "Ethanol",
            "éthanol",
            "Alcol etilico"),
    /**
     * EN: Aldesleukin.<br>
     * DE: Aldesleukin.<br>
     * FR: aldesleukine.<br>
     * IT: Aldesleuchina.<br>
     */
    ALDESLEUKIN("386917000",
                "http://snomed.info/sct",
                "Aldesleukin (substance)",
                "Aldesleukin",
                "Aldesleukin",
                "aldesleukine",
                "Aldesleuchina"),
    /**
     * EN: Alectinib.<br>
     * DE: Alectinib.<br>
     * FR: alectinib.<br>
     * IT: Alectinib.<br>
     */
    ALECTINIB("716039000",
              "http://snomed.info/sct",
              "Alectinib (substance)",
              "Alectinib",
              "Alectinib",
              "alectinib",
              "Alectinib"),
    /**
     * EN: Alemtuzumab.<br>
     * DE: Alemtuzumab.<br>
     * FR: alemtuzumab.<br>
     * IT: Alemtuzumab.<br>
     */
    ALEMTUZUMAB("129472003",
                "http://snomed.info/sct",
                "Alemtuzumab (substance)",
                "Alemtuzumab",
                "Alemtuzumab",
                "alemtuzumab",
                "Alemtuzumab"),
    /**
     * EN: Alendronic acid.<br>
     * DE: Alendronsäure.<br>
     * FR: acide alendronique.<br>
     * IT: Acido Alendronico.<br>
     */
    ALENDRONIC_ACID("391730008",
                    "http://snomed.info/sct",
                    "Alendronic acid (substance)",
                    "Alendronic acid",
                    "Alendronsäure",
                    "acide alendronique",
                    "Acido Alendronico"),
    /**
     * EN: Alfentanil.<br>
     * DE: Alfentanil.<br>
     * FR: alfentanil.<br>
     * IT: Alfentanil.<br>
     */
    ALFENTANIL("387560008",
               "http://snomed.info/sct",
               "Alfentanil (substance)",
               "Alfentanil",
               "Alfentanil",
               "alfentanil",
               "Alfentanil"),
    /**
     * EN: Alfuzosin.<br>
     * DE: Alfuzosin.<br>
     * FR: alfuzosine.<br>
     * IT: Alfuzosina.<br>
     */
    ALFUZOSIN("395954002",
              "http://snomed.info/sct",
              "Alfuzosin (substance)",
              "Alfuzosin",
              "Alfuzosin",
              "alfuzosine",
              "Alfuzosina"),
    /**
     * EN: Alirocumab.<br>
     * DE: Alirocumab.<br>
     * FR: alirocumab.<br>
     * IT: Alirocumab.<br>
     */
    ALIROCUMAB("715186005",
               "http://snomed.info/sct",
               "Alirocumab (substance)",
               "Alirocumab",
               "Alirocumab",
               "alirocumab",
               "Alirocumab"),
    /**
     * EN: Aliskiren.<br>
     * DE: Aliskiren.<br>
     * FR: aliskirène.<br>
     * IT: Aliskiren.<br>
     */
    ALISKIREN("426725002",
              "http://snomed.info/sct",
              "Aliskiren (substance)",
              "Aliskiren",
              "Aliskiren",
              "aliskirène",
              "Aliskiren"),
    /**
     * EN: Allopurinol.<br>
     * DE: Allopurinol.<br>
     * FR: allopurinol.<br>
     * IT: Allopurinolo.<br>
     */
    ALLOPURINOL("387135004",
                "http://snomed.info/sct",
                "Allopurinol (substance)",
                "Allopurinol",
                "Allopurinol",
                "allopurinol",
                "Allopurinolo"),
    /**
     * EN: Almotriptan.<br>
     * DE: Almotriptan.<br>
     * FR: almotriptan.<br>
     * IT: Almotriptan.<br>
     */
    ALMOTRIPTAN("363569003",
                "http://snomed.info/sct",
                "Almotriptan (substance)",
                "Almotriptan",
                "Almotriptan",
                "almotriptan",
                "Almotriptan"),
    /**
     * EN: Alogliptin.<br>
     * DE: Alogliptin.<br>
     * FR: alogliptine.<br>
     * IT: Alogliptin.<br>
     */
    ALOGLIPTIN("702799001",
               "http://snomed.info/sct",
               "Alogliptin (substance)",
               "Alogliptin",
               "Alogliptin",
               "alogliptine",
               "Alogliptin"),
    /**
     * EN: Alprazolam.<br>
     * DE: Alprazolam.<br>
     * FR: alprazolam.<br>
     * IT: Alprazolam.<br>
     */
    ALPRAZOLAM("386983007",
               "http://snomed.info/sct",
               "Alprazolam (substance)",
               "Alprazolam",
               "Alprazolam",
               "alprazolam",
               "Alprazolam"),
    /**
     * EN: Alprostadil.<br>
     * DE: Alprostadil.<br>
     * FR: alprostadil.<br>
     * IT: Alprostadil.<br>
     */
    ALPROSTADIL("48988008",
                "http://snomed.info/sct",
                "Alprostadil (substance)",
                "Alprostadil",
                "Alprostadil",
                "alprostadil",
                "Alprostadil"),
    /**
     * EN: Alteplase.<br>
     * DE: Alteplase.<br>
     * FR: altéplase.<br>
     * IT: Alteplase.<br>
     */
    ALTEPLASE("387152000",
              "http://snomed.info/sct",
              "Alteplase (substance)",
              "Alteplase",
              "Alteplase",
              "altéplase",
              "Alteplase"),
    /**
     * EN: Aluminium hydroxide.<br>
     * DE: Aluminiumoxid, wasserhaltig (Algeldrat).<br>
     * FR: aluminium oxyde hydrate (algeldrate).<br>
     * IT: Idrossido di alluminio.<br>
     */
    ALUMINIUM_HYDROXIDE("273944007",
                        "http://snomed.info/sct",
                        "Aluminium hydroxide (substance)",
                        "Aluminium hydroxide",
                        "Aluminiumoxid, wasserhaltig (Algeldrat)",
                        "aluminium oxyde hydrate (algeldrate)",
                        "Idrossido di alluminio"),
    /**
     * EN: Amantadine.<br>
     * DE: Amantadin.<br>
     * FR: amantadine.<br>
     * IT: Amantadina.<br>
     */
    AMANTADINE("372763006",
               "http://snomed.info/sct",
               "Amantadine (substance)",
               "Amantadine",
               "Amantadin",
               "amantadine",
               "Amantadina"),
    /**
     * EN: Ambrisentan.<br>
     * DE: Ambrisentan.<br>
     * FR: ambrisentan.<br>
     * IT: Ambrisentan.<br>
     */
    AMBRISENTAN("428159003",
                "http://snomed.info/sct",
                "Ambrisentan (substance)",
                "Ambrisentan",
                "Ambrisentan",
                "ambrisentan",
                "Ambrisentan"),
    /**
     * EN: Ambroxol.<br>
     * DE: Ambroxol.<br>
     * FR: ambroxol.<br>
     * IT: Ambroxolo.<br>
     */
    AMBROXOL("698024002",
             "http://snomed.info/sct",
             "Ambroxol (substance)",
             "Ambroxol",
             "Ambroxol",
             "ambroxol",
             "Ambroxolo"),
    /**
     * EN: Amikacin.<br>
     * DE: Amikacin.<br>
     * FR: amikacine.<br>
     * IT: Amikacina.<br>
     */
    AMIKACIN("387266001",
             "http://snomed.info/sct",
             "Amikacin (substance)",
             "Amikacin",
             "Amikacin",
             "amikacine",
             "Amikacina"),
    /**
     * EN: Amiloride.<br>
     * DE: Amilorid.<br>
     * FR: amiloride.<br>
     * IT: Amiloride.<br>
     */
    AMILORIDE("387503008",
              "http://snomed.info/sct",
              "Amiloride (substance)",
              "Amiloride",
              "Amilorid",
              "amiloride",
              "Amiloride"),
    /**
     * EN: Aminophylline.<br>
     * DE: Aminophyllin.<br>
     * FR: aminophylline.<br>
     * IT: Aminofillina.<br>
     */
    AMINOPHYLLINE("373508009",
                  "http://snomed.info/sct",
                  "Aminophylline (substance)",
                  "Aminophylline",
                  "Aminophyllin",
                  "aminophylline",
                  "Aminofillina"),
    /**
     * EN: Amiodarone.<br>
     * DE: Amiodaron.<br>
     * FR: amiodarone.<br>
     * IT: Amiodarone.<br>
     */
    AMIODARONE("372821002",
               "http://snomed.info/sct",
               "Amiodarone (substance)",
               "Amiodarone",
               "Amiodaron",
               "amiodarone",
               "Amiodarone"),
    /**
     * EN: Amisulpride.<br>
     * DE: Amisulprid.<br>
     * FR: amisulpride.<br>
     * IT: Amisulpride.<br>
     */
    AMISULPRIDE("391761004",
                "http://snomed.info/sct",
                "Amisulpride (substance)",
                "Amisulpride",
                "Amisulprid",
                "amisulpride",
                "Amisulpride"),
    /**
     * EN: Amitriptyline.<br>
     * DE: Amitriptylin.<br>
     * FR: amitriptyline.<br>
     * IT: Amitriptilina.<br>
     */
    AMITRIPTYLINE("372726002",
                  "http://snomed.info/sct",
                  "Amitriptyline (substance)",
                  "Amitriptyline",
                  "Amitriptylin",
                  "amitriptyline",
                  "Amitriptilina"),
    /**
     * EN: Amlodipine.<br>
     * DE: Amlodipin.<br>
     * FR: amlodipine.<br>
     * IT: Amlodipina.<br>
     */
    AMLODIPINE("386864001",
               "http://snomed.info/sct",
               "Amlodipine (substance)",
               "Amlodipine",
               "Amlodipin",
               "amlodipine",
               "Amlodipina"),
    /**
     * EN: Amorolfine.<br>
     * DE: Amorolfin.<br>
     * FR: amorolfine.<br>
     * IT: Amorolfina.<br>
     */
    AMOROLFINE("391769002",
               "http://snomed.info/sct",
               "Amorolfine (substance)",
               "Amorolfine",
               "Amorolfin",
               "amorolfine",
               "Amorolfina"),
    /**
     * EN: Amoxicillin.<br>
     * DE: Amoxicillin.<br>
     * FR: amoxicilline.<br>
     * IT: Amoxicillina.<br>
     */
    AMOXICILLIN("372687004",
                "http://snomed.info/sct",
                "Amoxicillin (substance)",
                "Amoxicillin",
                "Amoxicillin",
                "amoxicilline",
                "Amoxicillina"),
    /**
     * EN: Amoxicillin sodium.<br>
     * DE: Amoxicillin-Natrium.<br>
     * FR: amoxicilline sodique.<br>
     * IT: Amoxicillina sodica.<br>
     */
    AMOXICILLIN_SODIUM("427483001",
                       "http://snomed.info/sct",
                       "Amoxicillin sodium (substance)",
                       "Amoxicillin sodium",
                       "Amoxicillin-Natrium",
                       "amoxicilline sodique",
                       "Amoxicillina sodica"),
    /**
     * EN: Amoxicillin trihydrate.<br>
     * DE: Amoxicillin-3-Wasser.<br>
     * FR: amoxicilline trihydrate.<br>
     * IT: Amoxicillina triidrato.<br>
     */
    AMOXICILLIN_TRIHYDRATE("96068000",
                           "http://snomed.info/sct",
                           "Amoxicillin trihydrate (substance)",
                           "Amoxicillin trihydrate",
                           "Amoxicillin-3-Wasser",
                           "amoxicilline trihydrate",
                           "Amoxicillina triidrato"),
    /**
     * EN: Amphotericin B.<br>
     * DE: Amphotericin B.<br>
     * FR: amphotéricine B.<br>
     * IT: Amfotericina B.<br>
     */
    AMPHOTERICIN_B("77703004",
                   "http://snomed.info/sct",
                   "Amphotericin B (substance)",
                   "Amphotericin B",
                   "Amphotericin B",
                   "amphotéricine B",
                   "Amfotericina B"),
    /**
     * EN: Ampicillin.<br>
     * DE: Ampicillin.<br>
     * FR: ampicilline.<br>
     * IT: Ampicillina.<br>
     */
    AMPICILLIN("387170002",
               "http://snomed.info/sct",
               "Ampicillin (substance)",
               "Ampicillin",
               "Ampicillin",
               "ampicilline",
               "Ampicillina"),
    /**
     * EN: Amylase.<br>
     * DE: Amylase.<br>
     * FR: amylase.<br>
     * IT: Amilasi.<br>
     */
    AMYLASE("387031005",
            "http://snomed.info/sct",
            "Amylase (substance)",
            "Amylase",
            "Amylase",
            "amylase",
            "Amilasi"),
    /**
     * EN: Anagrelide.<br>
     * DE: Anagrelid.<br>
     * FR: anagrélide.<br>
     * IT: Anagrelide.<br>
     */
    ANAGRELIDE("372561005",
               "http://snomed.info/sct",
               "Anagrelide (substance)",
               "Anagrelide",
               "Anagrelid",
               "anagrélide",
               "Anagrelide"),
    /**
     * EN: Anakinra.<br>
     * DE: Anakinra.<br>
     * FR: anakinra.<br>
     * IT: Anakinra.<br>
     */
    ANAKINRA("385549000",
             "http://snomed.info/sct",
             "Anakinra (substance)",
             "Anakinra",
             "Anakinra",
             "anakinra",
             "Anakinra"),
    /**
     * EN: Anastrozole.<br>
     * DE: Anastrozol.<br>
     * FR: anastrozole.<br>
     * IT: Anastrozolo.<br>
     */
    ANASTROZOLE("386910003",
                "http://snomed.info/sct",
                "Anastrozole (substance)",
                "Anastrozole",
                "Anastrozol",
                "anastrozole",
                "Anastrozolo"),
    /**
     * EN: Anetholtrithion.<br>
     * DE: Anetholtrithion.<br>
     * FR: anétholtrithione.<br>
     * IT: Anetoltritione.<br>
     */
    ANETHOLTRITHION("703112006",
                    "http://snomed.info/sct",
                    "Anetholtrithion (substance)",
                    "Anetholtrithion",
                    "Anetholtrithion",
                    "anétholtrithione",
                    "Anetoltritione"),
    /**
     * EN: Anidulafungin.<br>
     * DE: Anidulafungin.<br>
     * FR: anidulafungine.<br>
     * IT: Anidulafungina.<br>
     */
    ANIDULAFUNGIN("422157006",
                  "http://snomed.info/sct",
                  "Anidulafungin (substance)",
                  "Anidulafungin",
                  "Anidulafungin",
                  "anidulafungine",
                  "Anidulafungina"),
    /**
     * EN: Antazoline.<br>
     * DE: Antazolin.<br>
     * FR: antazoline.<br>
     * IT: Antazolina.<br>
     */
    ANTAZOLINE("373544004",
               "http://snomed.info/sct",
               "Antazoline (substance)",
               "Antazoline",
               "Antazolin",
               "antazoline",
               "Antazolina"),
    /**
     * EN: Antilymphocyte immunoglobulin.<br>
     * DE: Immunglobuline anti-Lymphozyten human.<br>
     * FR: immunoglobuline anti-lymphocytes humains.<br>
     * IT: Immunoglobulina anti-linfociti T umani.<br>
     */
    ANTILYMPHOCYTE_IMMUNOGLOBULIN("391784006",
                                  "http://snomed.info/sct",
                                  "Antilymphocyte immunoglobulin (substance)",
                                  "Antilymphocyte immunoglobulin",
                                  "Immunglobuline anti-Lymphozyten human",
                                  "immunoglobuline anti-lymphocytes humains",
                                  "Immunoglobulina anti-linfociti T umani"),
    /**
     * EN: Antithymocyte immunoglobulin.<br>
     * DE: Immunglobulin anti-T-Lymphozyten human.<br>
     * FR: immunoglobuline anti lymphocytes T humains.<br>
     * IT: Immunoglobulina antitimociti umani.<br>
     */
    ANTITHYMOCYTE_IMMUNOGLOBULIN("768651008",
                                 "http://snomed.info/sct",
                                 "Antithymocyte immunoglobulin (substance)",
                                 "Antithymocyte immunoglobulin",
                                 "Immunglobulin anti-T-Lymphozyten human",
                                 "immunoglobuline anti lymphocytes T humains",
                                 "Immunoglobulina antitimociti umani"),
    /**
     * EN: Apixaban.<br>
     * DE: Apixaban.<br>
     * FR: apixaban.<br>
     * IT: Apixaban.<br>
     */
    APIXABAN("698090000",
             "http://snomed.info/sct",
             "Apixaban (substance)",
             "Apixaban",
             "Apixaban",
             "apixaban",
             "Apixaban"),
    /**
     * EN: Apomorphine.<br>
     * DE: Apomorphin.<br>
     * FR: apomorphine.<br>
     * IT: Apomorfina.<br>
     */
    APOMORPHINE("387375001",
                "http://snomed.info/sct",
                "Apomorphine (substance)",
                "Apomorphine",
                "Apomorphin",
                "apomorphine",
                "Apomorfina"),
    /**
     * EN: Aprepitant.<br>
     * DE: Aprepitant.<br>
     * FR: aprépitant.<br>
     * IT: Aprepitant.<br>
     */
    APREPITANT("409205009",
               "http://snomed.info/sct",
               "Aprepitant (substance)",
               "Aprepitant",
               "Aprepitant",
               "aprépitant",
               "Aprepitant"),
    /**
     * EN: Aprotinin.<br>
     * DE: Aprotinin.<br>
     * FR: aprotinine.<br>
     * IT: Aprotinina.<br>
     */
    APROTININ("386961008",
              "http://snomed.info/sct",
              "Aprotinin (substance)",
              "Aprotinin",
              "Aprotinin",
              "aprotinine",
              "Aprotinina"),
    /**
     * EN: Argatroban.<br>
     * DE: Argatroban.<br>
     * FR: argatroban.<br>
     * IT: Argatroban.<br>
     */
    ARGATROBAN("116508003",
               "http://snomed.info/sct",
               "Argatroban (substance)",
               "Argatroban",
               "Argatroban",
               "argatroban",
               "Argatroban"),
    /**
     * EN: Arginine.<br>
     * DE: Arginin.<br>
     * FR: arginine.<br>
     * IT: Arginina.<br>
     */
    ARGININE("52625008",
             "http://snomed.info/sct",
             "Arginine (substance)",
             "Arginine",
             "Arginin",
             "arginine",
             "Arginina"),
    /**
     * EN: Argipressin.<br>
     * DE: Argipressin (Vasopressin).<br>
     * FR: argipressine (Vasopressine).<br>
     * IT: Argipressina (Vasopressina).<br>
     */
    ARGIPRESSIN("421078009",
                "http://snomed.info/sct",
                "Argipressin (substance)",
                "Argipressin",
                "Argipressin (Vasopressin)",
                "argipressine (Vasopressine)",
                "Argipressina (Vasopressina)"),
    /**
     * EN: Aripiprazole.<br>
     * DE: Aripiprazol.<br>
     * FR: aripiprazole.<br>
     * IT: Aripirazolo.<br>
     */
    ARIPIPRAZOLE("406784005",
                 "http://snomed.info/sct",
                 "Aripiprazole (substance)",
                 "Aripiprazole",
                 "Aripiprazol",
                 "aripiprazole",
                 "Aripirazolo"),
    /**
     * EN: Arsenic trioxide.<br>
     * DE: Arsentrioxid.<br>
     * FR: trioxyde d'arsenic.<br>
     * IT: Arsenico triossido.<br>
     */
    ARSENIC_TRIOXIDE("72251000",
                     "http://snomed.info/sct",
                     "Arsenic trioxide (substance)",
                     "Arsenic trioxide",
                     "Arsentrioxid",
                     "trioxyde d'arsenic",
                     "Arsenico triossido"),
    /**
     * EN: Artemether.<br>
     * DE: Artemether.<br>
     * FR: artéméther.<br>
     * IT: Artemetere.<br>
     */
    ARTEMETHER("420578008",
               "http://snomed.info/sct",
               "Artemether (substance)",
               "Artemether",
               "Artemether",
               "artéméther",
               "Artemetere"),
    /**
     * EN: Artesunate.<br>
     * DE: Artesunat.<br>
     * FR: artésunate.<br>
     * IT: Artesunato.<br>
     */
    ARTESUNATE("432410005",
               "http://snomed.info/sct",
               "Artesunate (substance)",
               "Artesunate",
               "Artesunat",
               "artésunate",
               "Artesunato"),
    /**
     * EN: Articaine.<br>
     * DE: Articain.<br>
     * FR: articaïne.<br>
     * IT: Articaina.<br>
     */
    ARTICAINE("703107005",
              "http://snomed.info/sct",
              "Articaine (substance)",
              "Articaine",
              "Articain",
              "articaïne",
              "Articaina"),
    /**
     * EN: Ascorbic acid.<br>
     * DE: Ascorbinsäure (Vitamin C, E300).<br>
     * FR: acide ascorbique (Vitamine C, E300).<br>
     * IT: Acido ascorbico (Vitamina C, E300).<br>
     */
    ASCORBIC_ACID("43706004",
                  "http://snomed.info/sct",
                  "Ascorbic acid (substance)",
                  "Ascorbic acid",
                  "Ascorbinsäure (Vitamin C, E300)",
                  "acide ascorbique (Vitamine C, E300)",
                  "Acido ascorbico (Vitamina C, E300)"),
    /**
     * EN: Asparaginase.<br>
     * DE: Asparaginase.<br>
     * FR: asparaginase.<br>
     * IT: Asparaginasi.<br>
     */
    ASPARAGINASE("371014004",
                 "http://snomed.info/sct",
                 "Asparaginase (substance)",
                 "Asparaginase",
                 "Asparaginase",
                 "asparaginase",
                 "Asparaginasi"),
    /**
     * EN: Aspartic acid.<br>
     * DE: Aspartinsäure.<br>
     * FR: acide aspartique.<br>
     * IT: Acido aspartico.<br>
     */
    ASPARTIC_ACID("44970006",
                  "http://snomed.info/sct",
                  "Aspartic acid (substance)",
                  "Aspartic acid",
                  "Aspartinsäure",
                  "acide aspartique",
                  "Acido aspartico"),
    /**
     * EN: Aspirin.<br>
     * DE: Acetylsalicylsäure.<br>
     * FR: acide acétylsalicylique.<br>
     * IT: Acido acetilsalicilico.<br>
     */
    ASPIRIN("387458008",
            "http://snomed.info/sct",
            "Aspirin (substance)",
            "Aspirin",
            "Acetylsalicylsäure",
            "acide acétylsalicylique",
            "Acido acetilsalicilico"),
    /**
     * EN: Atazanavir.<br>
     * DE: Atazanavir.<br>
     * FR: atazanavir.<br>
     * IT: Atazanavir.<br>
     */
    ATAZANAVIR("413592000",
               "http://snomed.info/sct",
               "Atazanavir (substance)",
               "Atazanavir",
               "Atazanavir",
               "atazanavir",
               "Atazanavir"),
    /**
     * EN: Atenolol.<br>
     * DE: Atenolol.<br>
     * FR: aténolol.<br>
     * IT: Atenololo.<br>
     */
    ATENOLOL("387506000",
             "http://snomed.info/sct",
             "Atenolol (substance)",
             "Atenolol",
             "Atenolol",
             "aténolol",
             "Atenololo"),
    /**
     * EN: Atezolizumab.<br>
     * DE: Atezolizumab.<br>
     * FR: atézolizumab.<br>
     * IT: Atezolizumab.<br>
     */
    ATEZOLIZUMAB("719371003",
                 "http://snomed.info/sct",
                 "Atezolizumab (substance)",
                 "Atezolizumab",
                 "Atezolizumab",
                 "atézolizumab",
                 "Atezolizumab"),
    /**
     * EN: Atomoxetine.<br>
     * DE: Atomoxetin.<br>
     * FR: atomoxétine.<br>
     * IT: Atomoxetina.<br>
     */
    ATOMOXETINE("407037005",
                "http://snomed.info/sct",
                "Atomoxetine (substance)",
                "Atomoxetine",
                "Atomoxetin",
                "atomoxétine",
                "Atomoxetina"),
    /**
     * EN: Atorvastatin.<br>
     * DE: Atorvastatin.<br>
     * FR: atorvastatine.<br>
     * IT: Atorvastatina.<br>
     */
    ATORVASTATIN("373444002",
                 "http://snomed.info/sct",
                 "Atorvastatin (substance)",
                 "Atorvastatin",
                 "Atorvastatin",
                 "atorvastatine",
                 "Atorvastatina"),
    /**
     * EN: Atosiban.<br>
     * DE: Atosiban.<br>
     * FR: atosiban.<br>
     * IT: Atosiban.<br>
     */
    ATOSIBAN("391792002",
             "http://snomed.info/sct",
             "Atosiban (substance)",
             "Atosiban",
             "Atosiban",
             "atosiban",
             "Atosiban"),
    /**
     * EN: Atovaquone.<br>
     * DE: Atovaquon.<br>
     * FR: atovaquone.<br>
     * IT: Atovaquone.<br>
     */
    ATOVAQUONE("386899002",
               "http://snomed.info/sct",
               "Atovaquone (substance)",
               "Atovaquone",
               "Atovaquon",
               "atovaquone",
               "Atovaquone"),
    /**
     * EN: Atracurium.<br>
     * DE: Atracurium.<br>
     * FR: atracurium.<br>
     * IT: Atracurio.<br>
     */
    ATRACURIUM("372835000",
               "http://snomed.info/sct",
               "Atracurium (substance)",
               "Atracurium",
               "Atracurium",
               "atracurium",
               "Atracurio"),
    /**
     * EN: Atropine.<br>
     * DE: Atropin.<br>
     * FR: atropine.<br>
     * IT: Atropina.<br>
     */
    ATROPINE("372832002",
             "http://snomed.info/sct",
             "Atropine (substance)",
             "Atropine",
             "Atropin",
             "atropine",
             "Atropina"),
    /**
     * EN: Avanafil.<br>
     * DE: Avanafil.<br>
     * FR: avanafil.<br>
     * IT: Avafanil.<br>
     */
    AVANAFIL("703956007",
             "http://snomed.info/sct",
             "Avanafil (substance)",
             "Avanafil",
             "Avanafil",
             "avanafil",
             "Avafanil"),
    /**
     * EN: Avelumab.<br>
     * DE: Avelumab.<br>
     * FR: avélumab.<br>
     * IT: Avelumab.<br>
     */
    AVELUMAB("733055009",
             "http://snomed.info/sct",
             "Avelumab (substance)",
             "Avelumab",
             "Avelumab",
             "avélumab",
             "Avelumab"),
    /**
     * EN: Azacitidine.<br>
     * DE: Azacitidin.<br>
     * FR: azacitidine.<br>
     * IT: Azacitidina.<br>
     */
    AZACITIDINE("412328000",
                "http://snomed.info/sct",
                "Azacitidine (substance)",
                "Azacitidine",
                "Azacitidin",
                "azacitidine",
                "Azacitidina"),
    /**
     * EN: Azathioprine.<br>
     * DE: Azathioprin.<br>
     * FR: azathioprine.<br>
     * IT: Azatioprina.<br>
     */
    AZATHIOPRINE("372574004",
                 "http://snomed.info/sct",
                 "Azathioprine (substance)",
                 "Azathioprine",
                 "Azathioprin",
                 "azathioprine",
                 "Azatioprina"),
    /**
     * EN: Azelaic acid.<br>
     * DE: Azelainsäure.<br>
     * FR: acide azélaïque.<br>
     * IT: Acido azelaico.<br>
     */
    AZELAIC_ACID("386936005",
                 "http://snomed.info/sct",
                 "Azelaic acid (substance)",
                 "Azelaic acid",
                 "Azelainsäure",
                 "acide azélaïque",
                 "Acido azelaico"),
    /**
     * EN: Azelastine.<br>
     * DE: Azelastin.<br>
     * FR: azélastine.<br>
     * IT: Azelastina.<br>
     */
    AZELASTINE("372520005",
               "http://snomed.info/sct",
               "Azelastine (substance)",
               "Azelastine",
               "Azelastin",
               "azélastine",
               "Azelastina"),
    /**
     * EN: Azithromycin.<br>
     * DE: Azithromycin.<br>
     * FR: azithromycine.<br>
     * IT: Azitromicina.<br>
     */
    AZITHROMYCIN("387531004",
                 "http://snomed.info/sct",
                 "Azithromycin (substance)",
                 "Azithromycin",
                 "Azithromycin",
                 "azithromycine",
                 "Azitromicina"),
    /**
     * EN: Aztreonam.<br>
     * DE: Aztreonam.<br>
     * FR: aztréonam.<br>
     * IT: Aztreonam.<br>
     */
    AZTREONAM("387386004",
              "http://snomed.info/sct",
              "Aztreonam (substance)",
              "Aztreonam",
              "Aztreonam",
              "aztréonam",
              "Aztreonam"),
    /**
     * EN: Bacitracin.<br>
     * DE: Bacitracin.<br>
     * FR: bacitracine.<br>
     * IT: Bacitracina.<br>
     */
    BACITRACIN("5220000",
               "http://snomed.info/sct",
               "Bacitracin (substance)",
               "Bacitracin",
               "Bacitracin",
               "bacitracine",
               "Bacitracina"),
    /**
     * EN: Baclofen.<br>
     * DE: Baclofen.<br>
     * FR: baclofène.<br>
     * IT: Baclofene.<br>
     */
    BACLOFEN("387342009",
             "http://snomed.info/sct",
             "Baclofen (substance)",
             "Baclofen",
             "Baclofen",
             "baclofène",
             "Baclofene"),
    /**
     * EN: Basiliximab.<br>
     * DE: Basiliximab.<br>
     * FR: basiliximab.<br>
     * IT: Basiliximab.<br>
     */
    BASILIXIMAB("386978004",
                "http://snomed.info/sct",
                "Basiliximab (substance)",
                "Basiliximab",
                "Basiliximab",
                "basiliximab",
                "Basiliximab"),
    /**
     * EN: Beclometasone.<br>
     * DE: Beclometason.<br>
     * FR: béclométasone.<br>
     * IT: Beclometasone.<br>
     */
    BECLOMETASONE("116574000",
                  "http://snomed.info/sct",
                  "Beclometasone (substance)",
                  "Beclometasone",
                  "Beclometason",
                  "béclométasone",
                  "Beclometasone"),
    /**
     * EN: Beclometasone dipropionate.<br>
     * DE: Beclometason dipropionat.<br>
     * FR: béclométasone dipropionate.<br>
     * IT: Beclometasone dipropionato.<br>
     */
    BECLOMETASONE_DIPROPIONATE("116575004",
                               "http://snomed.info/sct",
                               "Beclometasone dipropionate (substance)",
                               "Beclometasone dipropionate",
                               "Beclometason dipropionat",
                               "béclométasone dipropionate",
                               "Beclometasone dipropionato"),
    /**
     * EN: Belatacept.<br>
     * DE: Belatacept.<br>
     * FR: bélatacept.<br>
     * IT: Belatacept.<br>
     */
    BELATACEPT("713475001",
               "http://snomed.info/sct",
               "Belatacept (substance)",
               "Belatacept",
               "Belatacept",
               "bélatacept",
               "Belatacept"),
    /**
     * EN: Belimumab.<br>
     * DE: Belimumab.<br>
     * FR: bélimumab.<br>
     * IT: Belimumab.<br>
     */
    BELIMUMAB("449043000",
              "http://snomed.info/sct",
              "Belimumab (substance)",
              "Belimumab",
              "Belimumab",
              "bélimumab",
              "Belimumab"),
    /**
     * EN: Benazepril.<br>
     * DE: Benazepril.<br>
     * FR: bénazépril.<br>
     * IT: Benazepril.<br>
     */
    BENAZEPRIL("372511001",
               "http://snomed.info/sct",
               "Benazepril (substance)",
               "Benazepril",
               "Benazepril",
               "bénazépril",
               "Benazepril"),
    /**
     * EN: Bendamustine.<br>
     * DE: Bendamustin.<br>
     * FR: bendamustine.<br>
     * IT: Bendamustina.<br>
     */
    BENDAMUSTINE("428012008",
                 "http://snomed.info/sct",
                 "Bendamustine (substance)",
                 "Bendamustine",
                 "Bendamustin",
                 "bendamustine",
                 "Bendamustina"),
    /**
     * EN: Benserazide.<br>
     * DE: Benserazid.<br>
     * FR: bensérazide.<br>
     * IT: Benserazide.<br>
     */
    BENSERAZIDE("391821005",
                "http://snomed.info/sct",
                "Benserazide (substance)",
                "Benserazide",
                "Benserazid",
                "bensérazide",
                "Benserazide"),
    /**
     * EN: Benzocaine.<br>
     * DE: Benzocain.<br>
     * FR: benzocaïne.<br>
     * IT: Benzocaina.<br>
     */
    BENZOCAINE("387357002",
               "http://snomed.info/sct",
               "Benzocaine (substance)",
               "Benzocaine",
               "Benzocain",
               "benzocaïne",
               "Benzocaina"),
    /**
     * EN: Benzydamine.<br>
     * DE: Benzydamin.<br>
     * FR: benzydamine.<br>
     * IT: Benzidamina.<br>
     */
    BENZYDAMINE("421319000",
                "http://snomed.info/sct",
                "Benzydamine (substance)",
                "Benzydamine",
                "Benzydamin",
                "benzydamine",
                "Benzidamina"),
    /**
     * EN: Benzylpenicillin.<br>
     * DE: Benzylpenicillin.<br>
     * FR: benzylpénicilline.<br>
     * IT: Benzilpenicillina.<br>
     */
    BENZYLPENICILLIN("323389000",
                     "http://snomed.info/sct",
                     "Benzylpenicillin (substance)",
                     "Benzylpenicillin",
                     "Benzylpenicillin",
                     "benzylpénicilline",
                     "Benzilpenicillina"),
    /**
     * EN: Betahistine.<br>
     * DE: Betahistin.<br>
     * FR: bétahistine.<br>
     * IT: Betaistina.<br>
     */
    BETAHISTINE("418067008",
                "http://snomed.info/sct",
                "Betahistine (substance)",
                "Betahistine",
                "Betahistin",
                "bétahistine",
                "Betaistina"),
    /**
     * EN: Betaine.<br>
     * DE: Betain.<br>
     * FR: bétaine.<br>
     * IT: Betaina.<br>
     */
    BETAINE("43356007",
            "http://snomed.info/sct",
            "Betaine (substance)",
            "Betaine",
            "Betain",
            "bétaine",
            "Betaina"),
    /**
     * EN: Betamethasone.<br>
     * DE: Betamethason.<br>
     * FR: bétaméthasone.<br>
     * IT: Betametasone.<br>
     */
    BETAMETHASONE("116571008",
                  "http://snomed.info/sct",
                  "Betamethasone (substance)",
                  "Betamethasone",
                  "Betamethason",
                  "bétaméthasone",
                  "Betametasone"),
    /**
     * EN: Betaxolol.<br>
     * DE: Betaxolol.<br>
     * FR: bétaxolol.<br>
     * IT: Betaxololo.<br>
     */
    BETAXOLOL("409276006",
              "http://snomed.info/sct",
              "Betaxolol (substance)",
              "Betaxolol",
              "Betaxolol",
              "bétaxolol",
              "Betaxololo"),
    /**
     * EN: Beta-galactosidase.<br>
     * DE: Tilactase.<br>
     * FR: tilactase.<br>
     * IT: Tilattasi.<br>
     */
    BETA_GALACTOSIDASE("28530008",
                       "http://snomed.info/sct",
                       "Beta-galactosidase (substance)",
                       "Beta-galactosidase",
                       "Tilactase",
                       "tilactase",
                       "Tilattasi"),
    /**
     * EN: Bevacizumab.<br>
     * DE: Bevacizumab.<br>
     * FR: bévacizumab.<br>
     * IT: Bevacizumab.<br>
     */
    BEVACIZUMAB("409406007",
                "http://snomed.info/sct",
                "Bevacizumab (substance)",
                "Bevacizumab",
                "Bevacizumab",
                "bévacizumab",
                "Bevacizumab"),
    /**
     * EN: Bezafibrate.<br>
     * DE: Bezafibrat.<br>
     * FR: bézafibrate.<br>
     * IT: Bezafibrato.<br>
     */
    BEZAFIBRATE("396025003",
                "http://snomed.info/sct",
                "Bezafibrate (substance)",
                "Bezafibrate",
                "Bezafibrat",
                "bézafibrate",
                "Bezafibrato"),
    /**
     * EN: Bicalutamide.<br>
     * DE: Bicalutamid.<br>
     * FR: bicalutamide.<br>
     * IT: Bicalutamide.<br>
     */
    BICALUTAMIDE("386908000",
                 "http://snomed.info/sct",
                 "Bicalutamide (substance)",
                 "Bicalutamide",
                 "Bicalutamid",
                 "bicalutamide",
                 "Bicalutamide"),
    /**
     * EN: Bictegravir.<br>
     * DE: Bictegravir.<br>
     * FR: bictégravir.<br>
     * IT: Bictegravir.<br>
     */
    BICTEGRAVIR("772193003",
                "http://snomed.info/sct",
                "Bictegravir (substance)",
                "Bictegravir",
                "Bictegravir",
                "bictégravir",
                "Bictegravir"),
    /**
     * EN: Bilastine.<br>
     * DE: Bilastin.<br>
     * FR: bilastine.<br>
     * IT: Bilastina.<br>
     */
    BILASTINE("697973006",
              "http://snomed.info/sct",
              "Bilastine (substance)",
              "Bilastine",
              "Bilastin",
              "bilastine",
              "Bilastina"),
    /**
     * EN: Bimatoprost.<br>
     * DE: Bimatoprost.<br>
     * FR: bimatoprost.<br>
     * IT: Bimatoprost.<br>
     */
    BIMATOPROST("129492005",
                "http://snomed.info/sct",
                "Bimatoprost (substance)",
                "Bimatoprost",
                "Bimatoprost",
                "bimatoprost",
                "Bimatoprost"),
    /**
     * EN: Binimetinib.<br>
     * DE: Binimetinib.<br>
     * FR: binimétinib.<br>
     * IT: Binimetinib.<br>
     */
    BINIMETINIB("772195005",
                "http://snomed.info/sct",
                "Binimetinib (substance)",
                "Binimetinib",
                "Binimetinib",
                "binimétinib",
                "Binimetinib"),
    /**
     * EN: Biotin.<br>
     * DE: Biotin.<br>
     * FR: biotine.<br>
     * IT: Biotina.<br>
     */
    BIOTIN("8919000",
           "http://snomed.info/sct",
           "Biotin (substance)",
           "Biotin",
           "Biotin",
           "biotine",
           "Biotina"),
    /**
     * EN: Biperiden.<br>
     * DE: Biperiden.<br>
     * FR: bipéridène.<br>
     * IT: Biperidene.<br>
     */
    BIPERIDEN("387359004",
              "http://snomed.info/sct",
              "Biperiden (substance)",
              "Biperiden",
              "Biperiden",
              "bipéridène",
              "Biperidene"),
    /**
     * EN: Bisacodyl.<br>
     * DE: Bisacodyl.<br>
     * FR: bisacodyl.<br>
     * IT: Bisacodile.<br>
     */
    BISACODYL("387075009",
              "http://snomed.info/sct",
              "Bisacodyl (substance)",
              "Bisacodyl",
              "Bisacodyl",
              "bisacodyl",
              "Bisacodile"),
    /**
     * EN: Bisoprolol.<br>
     * DE: Bisoprolol.<br>
     * FR: bisoprolol.<br>
     * IT: Bisoprololo.<br>
     */
    BISOPROLOL("386868003",
               "http://snomed.info/sct",
               "Bisoprolol (substance)",
               "Bisoprolol",
               "Bisoprolol",
               "bisoprolol",
               "Bisoprololo"),
    /**
     * EN: Bivalirudin.<br>
     * DE: Bivalirudin.<br>
     * FR: bivalirudine.<br>
     * IT: Bivalirudina.<br>
     */
    BIVALIRUDIN("129498009",
                "http://snomed.info/sct",
                "Bivalirudin (substance)",
                "Bivalirudin",
                "Bivalirudin",
                "bivalirudine",
                "Bivalirudina"),
    /**
     * EN: Bleomycin.<br>
     * DE: Bleomycin.<br>
     * FR: bléomycine.<br>
     * IT: Bleomicina.<br>
     */
    BLEOMYCIN("372843005",
              "http://snomed.info/sct",
              "Bleomycin (substance)",
              "Bleomycin",
              "Bleomycin",
              "bléomycine",
              "Bleomicina"),
    /**
     * EN: Bortezomib.<br>
     * DE: Bortezomib.<br>
     * FR: bortézomib.<br>
     * IT: Bortezomib.<br>
     */
    BORTEZOMIB("407097007",
               "http://snomed.info/sct",
               "Bortezomib (substance)",
               "Bortezomib",
               "Bortezomib",
               "bortézomib",
               "Bortezomib"),
    /**
     * EN: Bosentan.<br>
     * DE: Bosentan.<br>
     * FR: bosentan.<br>
     * IT: Bosentan.<br>
     */
    BOSENTAN("385559004",
             "http://snomed.info/sct",
             "Bosentan (substance)",
             "Bosentan",
             "Bosentan",
             "bosentan",
             "Bosentan"),
    /**
     * EN: Bosutinib.<br>
     * DE: Bosutinib.<br>
     * FR: bosutinib.<br>
     * IT: Bosutinib.<br>
     */
    BOSUTINIB("703128001",
              "http://snomed.info/sct",
              "Bosutinib (substance)",
              "Bosutinib",
              "Bosutinib",
              "bosutinib",
              "Bosutinib"),
    /**
     * EN: Botulinum toxin type A.<br>
     * DE: Botulinumtoxin Typ A.<br>
     * FR: toxine botulique de type A.<br>
     * IT: Tossina botulinica tipo A.<br>
     */
    BOTULINUM_TOXIN_TYPE_A("108890005",
                           "http://snomed.info/sct",
                           "Botulinum toxin type A (substance)",
                           "Botulinum toxin type A",
                           "Botulinumtoxin Typ A",
                           "toxine botulique de type A",
                           "Tossina botulinica tipo A"),
    /**
     * EN: Brentuximab vedotin.<br>
     * DE: Brentuximab vedotin.<br>
     * FR: brentuximab védotine.<br>
     * IT: Brentuximab.<br>
     */
    BRENTUXIMAB_VEDOTIN("713395006",
                        "http://snomed.info/sct",
                        "Brentuximab vedotin (substance)",
                        "Brentuximab vedotin",
                        "Brentuximab vedotin",
                        "brentuximab védotine",
                        "Brentuximab"),
    /**
     * EN: Brexpiprazole.<br>
     * DE: Brexpiprazol.<br>
     * FR: brexpiprazole.<br>
     * IT: Brexpiprazolo.<br>
     */
    BREXPIPRAZOLE("716069007",
                  "http://snomed.info/sct",
                  "Brexpiprazole (substance)",
                  "Brexpiprazole",
                  "Brexpiprazol",
                  "brexpiprazole",
                  "Brexpiprazolo"),
    /**
     * EN: Brimonidine.<br>
     * DE: Brimonidin.<br>
     * FR: brimonidine.<br>
     * IT: Brimonidina.<br>
     */
    BRIMONIDINE("372547000",
                "http://snomed.info/sct",
                "Brimonidine (substance)",
                "Brimonidine",
                "Brimonidin",
                "brimonidine",
                "Brimonidina"),
    /**
     * EN: Brinzolamide.<br>
     * DE: Brinzolamid.<br>
     * FR: brinzolamide.<br>
     * IT: Brinzolamide.<br>
     */
    BRINZOLAMIDE("386925003",
                 "http://snomed.info/sct",
                 "Brinzolamide (substance)",
                 "Brinzolamide",
                 "Brinzolamid",
                 "brinzolamide",
                 "Brinzolamide"),
    /**
     * EN: Brivaracetam.<br>
     * DE: Brivaracetam.<br>
     * FR: brivaracétam.<br>
     * IT: Brivaracetam.<br>
     */
    BRIVARACETAM("420813001",
                 "http://snomed.info/sct",
                 "Brivaracetam (substance)",
                 "Brivaracetam",
                 "Brivaracetam",
                 "brivaracétam",
                 "Brivaracetam"),
    /**
     * EN: Brivudine.<br>
     * DE: Brivudin.<br>
     * FR: brivudine.<br>
     * IT: Brivudina.<br>
     */
    BRIVUDINE("698049003",
              "http://snomed.info/sct",
              "Brivudine (substance)",
              "Brivudine",
              "Brivudin",
              "brivudine",
              "Brivudina"),
    /**
     * EN: Bromazepam.<br>
     * DE: Bromazepam.<br>
     * FR: bromazépam.<br>
     * IT: Bromazepam.<br>
     */
    BROMAZEPAM("387571009",
               "http://snomed.info/sct",
               "Bromazepam (substance)",
               "Bromazepam",
               "Bromazepam",
               "bromazépam",
               "Bromazepam"),
    /**
     * EN: Bromfenac.<br>
     * DE: Bromfenac.<br>
     * FR: bromfénac.<br>
     * IT: Bromfenac.<br>
     */
    BROMFENAC("108520008",
              "http://snomed.info/sct",
              "Bromfenac (substance)",
              "Bromfenac",
              "Bromfenac",
              "bromfénac",
              "Bromfenac"),
    /**
     * EN: Bromocriptine.<br>
     * DE: Bromocriptin.<br>
     * FR: bromocriptine.<br>
     * IT: Bromocriptina.<br>
     */
    BROMOCRIPTINE("387039007",
                  "http://snomed.info/sct",
                  "Bromocriptine (substance)",
                  "Bromocriptine",
                  "Bromocriptin",
                  "bromocriptine",
                  "Bromocriptina"),
    /**
     * EN: Budesonide.<br>
     * DE: Budesonid.<br>
     * FR: budésonide.<br>
     * IT: Budesonide.<br>
     */
    BUDESONIDE("395726003",
               "http://snomed.info/sct",
               "Budesonide (substance)",
               "Budesonide",
               "Budesonid",
               "budésonide",
               "Budesonide"),
    /**
     * EN: Bufexamac.<br>
     * DE: Bufexamac.<br>
     * FR: bufexamac.<br>
     * IT: Bufexamac.<br>
     */
    BUFEXAMAC("273952005",
              "http://snomed.info/sct",
              "Bufexamac (substance)",
              "Bufexamac",
              "Bufexamac",
              "bufexamac",
              "Bufexamac"),
    /**
     * EN: Bupivacaine.<br>
     * DE: Bupivacain.<br>
     * FR: bupivacaïne.<br>
     * IT: Bupivacaina.<br>
     */
    BUPIVACAINE("387150008",
                "http://snomed.info/sct",
                "Bupivacaine (substance)",
                "Bupivacaine",
                "Bupivacain",
                "bupivacaïne",
                "Bupivacaina"),
    /**
     * EN: Buprenorphine.<br>
     * DE: Buprenorphin.<br>
     * FR: buprénorphine.<br>
     * IT: Buprenorfina.<br>
     */
    BUPRENORPHINE("387173000",
                  "http://snomed.info/sct",
                  "Buprenorphine (substance)",
                  "Buprenorphine",
                  "Buprenorphin",
                  "buprénorphine",
                  "Buprenorfina"),
    /**
     * EN: Bupropion.<br>
     * DE: Bupropion.<br>
     * FR: bupropion.<br>
     * IT: Buproprione.<br>
     */
    BUPROPION("387564004",
              "http://snomed.info/sct",
              "Bupropion (substance)",
              "Bupropion",
              "Bupropion",
              "bupropion",
              "Buproprione"),
    /**
     * EN: Buserelin.<br>
     * DE: Buserelin.<br>
     * FR: buséréline.<br>
     * IT: Buserelina.<br>
     */
    BUSERELIN("395744006",
              "http://snomed.info/sct",
              "Buserelin (substance)",
              "Buserelin",
              "Buserelin",
              "buséréline",
              "Buserelina"),
    /**
     * EN: Butylscopolamine.<br>
     * DE: Butylscopolamin.<br>
     * FR: butylscopolamine.<br>
     * IT: butilscopolamina.<br>
     */
    BUTYLSCOPOLAMINE("1156229000",
                     "http://snomed.info/sct",
                     "Butylscopolamine (substance)",
                     "Butylscopolamine",
                     "Butylscopolamin",
                     "butylscopolamine",
                     "butilscopolamina"),
    /**
     * EN: Cabazitaxel.<br>
     * DE: Cabazitaxel.<br>
     * FR: cabazitaxel.<br>
     * IT: Cabazitaxel.<br>
     */
    CABAZITAXEL("446706007",
                "http://snomed.info/sct",
                "Cabazitaxel (substance)",
                "Cabazitaxel",
                "Cabazitaxel",
                "cabazitaxel",
                "Cabazitaxel"),
    /**
     * EN: Cabergoline.<br>
     * DE: Cabergolin.<br>
     * FR: cabergoline.<br>
     * IT: Cabergolina.<br>
     */
    CABERGOLINE("386979007",
                "http://snomed.info/sct",
                "Cabergoline (substance)",
                "Cabergoline",
                "Cabergolin",
                "cabergoline",
                "Cabergolina"),
    /**
     * EN: Caffeine.<br>
     * DE: Coffein.<br>
     * FR: caféine.<br>
     * IT: Caffeina.<br>
     */
    CAFFEINE("255641001",
             "http://snomed.info/sct",
             "Caffeine (substance)",
             "Caffeine",
             "Coffein",
             "caféine",
             "Caffeina"),
    /**
     * EN: Calcipotriol.<br>
     * DE: Calcipotriol.<br>
     * FR: calcipotriol.<br>
     * IT: Calcipotriolo.<br>
     */
    CALCIPOTRIOL("395766004",
                 "http://snomed.info/sct",
                 "Calcipotriol (substance)",
                 "Calcipotriol",
                 "Calcipotriol",
                 "calcipotriol",
                 "Calcipotriolo"),
    /**
     * EN: Calcitriol.<br>
     * DE: Calcitriol.<br>
     * FR: calcitriol.<br>
     * IT: Calcitriolo.<br>
     */
    CALCITRIOL("259333003",
               "http://snomed.info/sct",
               "Calcitriol (substance)",
               "Calcitriol",
               "Calcitriol",
               "calcitriol",
               "Calcitriolo"),
    /**
     * EN: Calcium acetate.<br>
     * DE: Calcium acetat.<br>
     * FR: calcium acétate.<br>
     * IT: Calcio acetato.<br>
     */
    CALCIUM_ACETATE("387019008",
                    "http://snomed.info/sct",
                    "Calcium acetate (substance)",
                    "Calcium acetate",
                    "Calcium acetat",
                    "calcium acétate",
                    "Calcio acetato"),
    /**
     * EN: Calcium alginate solution.<br>
     * DE: Calcium alginat.<br>
     * FR: alginate calcique.<br>
     * IT: Calcio alginato.<br>
     */
    CALCIUM_ALGINATE_SOLUTION("256620003",
                              "http://snomed.info/sct",
                              "Calcium alginate solution (substance)",
                              "Calcium alginate solution",
                              "Calcium alginat",
                              "alginate calcique",
                              "Calcio alginato"),
    /**
     * EN: Calcium carbaspirin.<br>
     * DE: Carbasalat calcium.<br>
     * FR: carbasalate calcique.<br>
     * IT: Calcio carbasalato.<br>
     */
    CALCIUM_CARBASPIRIN("111122008",
                        "http://snomed.info/sct",
                        "Calcium carbaspirin (substance)",
                        "Calcium carbaspirin",
                        "Carbasalat calcium",
                        "carbasalate calcique",
                        "Calcio carbasalato"),
    /**
     * EN: Calcium carbonate.<br>
     * DE: Calcium carbonat.<br>
     * FR: calcium carbonate.<br>
     * IT: Calcio carbonato.<br>
     */
    CALCIUM_CARBONATE("387307005",
                      "http://snomed.info/sct",
                      "Calcium carbonate (substance)",
                      "Calcium carbonate",
                      "Calcium carbonat",
                      "calcium carbonate",
                      "Calcio carbonato"),
    /**
     * EN: Calcium chloride.<br>
     * DE: Calciumchlorid.<br>
     * FR: calcium chlorure.<br>
     * IT: Calcio cloruro.<br>
     */
    CALCIUM_CHLORIDE("387377009",
                     "http://snomed.info/sct",
                     "Calcium chloride (substance)",
                     "Calcium chloride",
                     "Calciumchlorid",
                     "calcium chlorure",
                     "Calcio cloruro"),
    /**
     * EN: Calcium glubionate.<br>
     * DE: Calcium glubionat.<br>
     * FR: calcium glubionate.<br>
     * IT: Calcio glubionato.<br>
     */
    CALCIUM_GLUBIONATE("32445001",
                       "http://snomed.info/sct",
                       "Calcium glubionate (substance)",
                       "Calcium glubionate",
                       "Calcium glubionat",
                       "calcium glubionate",
                       "Calcio glubionato"),
    /**
     * EN: Calcium gluconate.<br>
     * DE: Calcium gluconat.<br>
     * FR: calcium gluconate.<br>
     * IT: Calcio gluconato.<br>
     */
    CALCIUM_GLUCONATE("387292008",
                      "http://snomed.info/sct",
                      "Calcium gluconate (substance)",
                      "Calcium gluconate",
                      "Calcium gluconat",
                      "calcium gluconate",
                      "Calcio gluconato"),
    /**
     * EN: Calcium leucovorin.<br>
     * DE: Calcium folinat.<br>
     * FR: acide folinique calcique.<br>
     * IT: Calcio folinato.<br>
     */
    CALCIUM_LEUCOVORIN("126223008",
                       "http://snomed.info/sct",
                       "Calcium leucovorin (substance)",
                       "Calcium leucovorin",
                       "Calcium folinat",
                       "acide folinique calcique",
                       "Calcio folinato"),
    /**
     * EN: Canagliflozin.<br>
     * DE: Canagliflozin.<br>
     * FR: canagliflozine.<br>
     * IT: Canaglifozin.<br>
     */
    CANAGLIFLOZIN("703676004",
                  "http://snomed.info/sct",
                  "Canagliflozin (substance)",
                  "Canagliflozin",
                  "Canagliflozin",
                  "canagliflozine",
                  "Canaglifozin"),
    /**
     * EN: Canakinumab.<br>
     * DE: Canakinumab.<br>
     * FR: canakinumab.<br>
     * IT: Canakinumab.<br>
     */
    CANAKINUMAB("698091001",
                "http://snomed.info/sct",
                "Canakinumab (substance)",
                "Canakinumab",
                "Canakinumab",
                "canakinumab",
                "Canakinumab"),
    /**
     * EN: Candesartan.<br>
     * DE: Candesartan.<br>
     * FR: candésartan.<br>
     * IT: Candesartan.<br>
     */
    CANDESARTAN("372512008",
                "http://snomed.info/sct",
                "Candesartan (substance)",
                "Candesartan",
                "Candesartan",
                "candésartan",
                "Candesartan"),
    /**
     * EN: Cangrelor.<br>
     * DE: Cangrelor.<br>
     * FR: cangrélor.<br>
     * IT: Cangrelor.<br>
     */
    CANGRELOR("716118009",
              "http://snomed.info/sct",
              "Cangrelor (substance)",
              "Cangrelor",
              "Cangrelor",
              "cangrélor",
              "Cangrelor"),
    /**
     * EN: Cannabidiol.<br>
     * DE: Cannabidiol (CBD).<br>
     * FR: cannabidiol (CBD).<br>
     * IT: Cannabidiolo.<br>
     */
    CANNABIDIOL("96223000",
                "http://snomed.info/sct",
                "Cannabidiol (substance)",
                "Cannabidiol",
                "Cannabidiol (CBD)",
                "cannabidiol (CBD)",
                "Cannabidiolo"),
    /**
     * EN: Capecitabine.<br>
     * DE: Capecitabin.<br>
     * FR: capécitabine.<br>
     * IT: Capecitabina.<br>
     */
    CAPECITABINE("386906001",
                 "http://snomed.info/sct",
                 "Capecitabine (substance)",
                 "Capecitabine",
                 "Capecitabin",
                 "capécitabine",
                 "Capecitabina"),
    /**
     * EN: Capsaicin.<br>
     * DE: Capsaicin.<br>
     * FR: capsaïcine.<br>
     * IT: Capsaicina.<br>
     */
    CAPSAICIN("95995002",
              "http://snomed.info/sct",
              "Capsaicin (substance)",
              "Capsaicin",
              "Capsaicin",
              "capsaïcine",
              "Capsaicina"),
    /**
     * EN: Captopril.<br>
     * DE: Captopril.<br>
     * FR: captopril.<br>
     * IT: Captopril.<br>
     */
    CAPTOPRIL("387160004",
              "http://snomed.info/sct",
              "Captopril (substance)",
              "Captopril",
              "Captopril",
              "captopril",
              "Captopril"),
    /**
     * EN: Carbachol.<br>
     * DE: Carbachol.<br>
     * FR: carbachol.<br>
     * IT: Carbacolo.<br>
     */
    CARBACHOL("387183001",
              "http://snomed.info/sct",
              "Carbachol (substance)",
              "Carbachol",
              "Carbachol",
              "carbachol",
              "Carbacolo"),
    /**
     * EN: Carbamazepine.<br>
     * DE: Carbamazepin.<br>
     * FR: carbamazépine.<br>
     * IT: Carbamazepina.<br>
     */
    CARBAMAZEPINE("387222003",
                  "http://snomed.info/sct",
                  "Carbamazepine (substance)",
                  "Carbamazepine",
                  "Carbamazepin",
                  "carbamazépine",
                  "Carbamazepina"),
    /**
     * EN: Carbetocin.<br>
     * DE: Carbetocin.<br>
     * FR: carbétocine.<br>
     * IT: Carbetocina.<br>
     */
    CARBETOCIN("425003007",
               "http://snomed.info/sct",
               "Carbetocin (substance)",
               "Carbetocin",
               "Carbetocin",
               "carbétocine",
               "Carbetocina"),
    /**
     * EN: Carbidopa.<br>
     * DE: Carbidopa.<br>
     * FR: carbidopa.<br>
     * IT: Carbidopa.<br>
     */
    CARBIDOPA("73579000",
              "http://snomed.info/sct",
              "Carbidopa (substance)",
              "Carbidopa",
              "Carbidopa",
              "carbidopa",
              "Carbidopa"),
    /**
     * EN: Carbimazole.<br>
     * DE: Carbimazol.<br>
     * FR: carbimazole.<br>
     * IT: Carbimazolo.<br>
     */
    CARBIMAZOLE("395831005",
                "http://snomed.info/sct",
                "Carbimazole (substance)",
                "Carbimazole",
                "Carbimazol",
                "carbimazole",
                "Carbimazolo"),
    /**
     * EN: Carbocisteine.<br>
     * DE: Carbocistein.<br>
     * FR: carbocistéine.<br>
     * IT: Carbocisteina.<br>
     */
    CARBOCISTEINE("395842001",
                  "http://snomed.info/sct",
                  "Carbocisteine (substance)",
                  "Carbocisteine",
                  "Carbocistein",
                  "carbocistéine",
                  "Carbocisteina"),
    /**
     * EN: Carboplatin.<br>
     * DE: Carboplatin.<br>
     * FR: carboplatine.<br>
     * IT: Carboplatino.<br>
     */
    CARBOPLATIN("386905002",
                "http://snomed.info/sct",
                "Carboplatin (substance)",
                "Carboplatin",
                "Carboplatin",
                "carboplatine",
                "Carboplatino"),
    /**
     * EN: Carfilzomib.<br>
     * DE: Carfilzomib.<br>
     * FR: carfilzomib.<br>
     * IT: Carfilzomib.<br>
     */
    CARFILZOMIB("713463006",
                "http://snomed.info/sct",
                "Carfilzomib (substance)",
                "Carfilzomib",
                "Carfilzomib",
                "carfilzomib",
                "Carfilzomib"),
    /**
     * EN: Cariprazine.<br>
     * DE: Cariprazin.<br>
     * FR: cariprazine.<br>
     * IT: Cariprazina.<br>
     */
    CARIPRAZINE("715295006",
                "http://snomed.info/sct",
                "Cariprazine (substance)",
                "Cariprazine",
                "Cariprazin",
                "cariprazine",
                "Cariprazina"),
    /**
     * EN: Carmustine.<br>
     * DE: Carmustin.<br>
     * FR: carmustine.<br>
     * IT: Carmustina.<br>
     */
    CARMUSTINE("387281007",
               "http://snomed.info/sct",
               "Carmustine (substance)",
               "Carmustine",
               "Carmustin",
               "carmustine",
               "Carmustina"),
    /**
     * EN: Carteolol.<br>
     * DE: Carteolol.<br>
     * FR: cartéolol.<br>
     * IT: Carteololo.<br>
     */
    CARTEOLOL("386866004",
              "http://snomed.info/sct",
              "Carteolol (substance)",
              "Carteolol",
              "Carteolol",
              "cartéolol",
              "Carteololo"),
    /**
     * EN: Carvedilol.<br>
     * DE: Carvedilol.<br>
     * FR: carvédilol.<br>
     * IT: Carvedilolo.<br>
     */
    CARVEDILOL("386870007",
               "http://snomed.info/sct",
               "Carvedilol (substance)",
               "Carvedilol",
               "Carvedilol",
               "carvédilol",
               "Carvedilolo"),
    /**
     * EN: Caspofungin.<br>
     * DE: Caspofungin.<br>
     * FR: caspofungine.<br>
     * IT: Caspofungin.<br>
     */
    CASPOFUNGIN("413770001",
                "http://snomed.info/sct",
                "Caspofungin (substance)",
                "Caspofungin",
                "Caspofungin",
                "caspofungine",
                "Caspofungin"),
    /**
     * EN: Cefaclor.<br>
     * DE: Cefaclor.<br>
     * FR: céfaclor.<br>
     * IT: Cefaclor.<br>
     */
    CEFACLOR("387270009",
             "http://snomed.info/sct",
             "Cefaclor (substance)",
             "Cefaclor",
             "Cefaclor",
             "céfaclor",
             "Cefaclor"),
    /**
     * EN: Cefazolin.<br>
     * DE: Cefazolin.<br>
     * FR: céfazoline.<br>
     * IT: Cefazolina.<br>
     */
    CEFAZOLIN("387470007",
              "http://snomed.info/sct",
              "Cefazolin (substance)",
              "Cefazolin",
              "Cefazolin",
              "céfazoline",
              "Cefazolina"),
    /**
     * EN: Cefepime.<br>
     * DE: Cefepim.<br>
     * FR: céfépime.<br>
     * IT: Cefepime.<br>
     */
    CEFEPIME("96048006",
             "http://snomed.info/sct",
             "Cefepime (substance)",
             "Cefepime",
             "Cefepim",
             "céfépime",
             "Cefepime"),
    /**
     * EN: Cefixime anhydrous.<br>
     * DE: Cefixim.<br>
     * FR: céfixime.<br>
     * IT: Cefixima.<br>
     */
    CEFIXIME_ANHYDROUS("785697003",
                       "http://snomed.info/sct",
                       "Cefixime anhydrous (substance)",
                       "Cefixime anhydrous",
                       "Cefixim",
                       "céfixime",
                       "Cefixima"),
    /**
     * EN: Cefpodoxime.<br>
     * DE: Cefpodoxim.<br>
     * FR: cefpodoxime.<br>
     * IT: Cefpodoxima.<br>
     */
    CEFPODOXIME("387534007",
                "http://snomed.info/sct",
                "Cefpodoxime (substance)",
                "Cefpodoxime",
                "Cefpodoxim",
                "cefpodoxime",
                "Cefpodoxima"),
    /**
     * EN: Ceftazidime.<br>
     * DE: Ceftazidim.<br>
     * FR: ceftazidime.<br>
     * IT: Ceftazidime.<br>
     */
    CEFTAZIDIME("387200005",
                "http://snomed.info/sct",
                "Ceftazidime (substance)",
                "Ceftazidime",
                "Ceftazidim",
                "ceftazidime",
                "Ceftazidime"),
    /**
     * EN: Ceftriaxone.<br>
     * DE: Ceftriaxon.<br>
     * FR: ceftriaxone.<br>
     * IT: Ceftriaxone.<br>
     */
    CEFTRIAXONE("372670001",
                "http://snomed.info/sct",
                "Ceftriaxone (substance)",
                "Ceftriaxone",
                "Ceftriaxon",
                "ceftriaxone",
                "Ceftriaxone"),
    /**
     * EN: Cefuroxime.<br>
     * DE: Cefuroxim.<br>
     * FR: céfuroxime.<br>
     * IT: Cefuroxime.<br>
     */
    CEFUROXIME("372833007",
               "http://snomed.info/sct",
               "Cefuroxime (substance)",
               "Cefuroxime",
               "Cefuroxim",
               "céfuroxime",
               "Cefuroxime"),
    /**
     * EN: Celecoxib.<br>
     * DE: Celecoxib.<br>
     * FR: célécoxib.<br>
     * IT: Celecoxib.<br>
     */
    CELECOXIB("116081000",
              "http://snomed.info/sct",
              "Celecoxib (substance)",
              "Celecoxib",
              "Celecoxib",
              "célécoxib",
              "Celecoxib"),
    /**
     * EN: Cetirizine.<br>
     * DE: Cetirizin.<br>
     * FR: cétirizine.<br>
     * IT: Cetirizina.<br>
     */
    CETIRIZINE("372523007",
               "http://snomed.info/sct",
               "Cetirizine (substance)",
               "Cetirizine",
               "Cetirizin",
               "cétirizine",
               "Cetirizina"),
    /**
     * EN: Cetylpyridinium.<br>
     * DE: Cetylpyridinium.<br>
     * FR: cétylpyridinium.<br>
     * IT: Cetilpiridinio.<br>
     */
    CETYLPYRIDINIUM("387043006",
                    "http://snomed.info/sct",
                    "Cetylpyridinium (substance)",
                    "Cetylpyridinium",
                    "Cetylpyridinium",
                    "cétylpyridinium",
                    "Cetilpiridinio"),
    /**
     * EN: Chloramphenicol.<br>
     * DE: Chloramphenicol.<br>
     * FR: chloramphénicol.<br>
     * IT: Cloramfenicolo.<br>
     */
    CHLORAMPHENICOL("372777009",
                    "http://snomed.info/sct",
                    "Chloramphenicol (substance)",
                    "Chloramphenicol",
                    "Chloramphenicol",
                    "chloramphénicol",
                    "Cloramfenicolo"),
    /**
     * EN: Chlordiazepoxide.<br>
     * DE: Chlordiazepoxid.<br>
     * FR: chlordiazépoxide.<br>
     * IT: Clordiazepossido.<br>
     */
    CHLORDIAZEPOXIDE("372866006",
                     "http://snomed.info/sct",
                     "Chlordiazepoxide (substance)",
                     "Chlordiazepoxide",
                     "Chlordiazepoxid",
                     "chlordiazépoxide",
                     "Clordiazepossido"),
    /**
     * EN: Chlorhexidine.<br>
     * DE: Chlorhexidin.<br>
     * FR: chlorhexidine.<br>
     * IT: Clorexidina.<br>
     */
    CHLORHEXIDINE("373568007",
                  "http://snomed.info/sct",
                  "Chlorhexidine (substance)",
                  "Chlorhexidine",
                  "Chlorhexidin",
                  "chlorhexidine",
                  "Clorexidina"),
    /**
     * EN: Chlormadinone.<br>
     * DE: Chlormadinon.<br>
     * FR: chlormadinone.<br>
     * IT: Clormadinone.<br>
     */
    CHLORMADINONE("734645001",
                  "http://snomed.info/sct",
                  "Chlormadinone (substance)",
                  "Chlormadinone",
                  "Chlormadinon",
                  "chlormadinone",
                  "Clormadinone"),
    /**
     * EN: Chloroquine.<br>
     * DE: Chloroquin.<br>
     * FR: chloroquine.<br>
     * IT: Clorochina.<br>
     */
    CHLOROQUINE("373468005",
                "http://snomed.info/sct",
                "Chloroquine (substance)",
                "Chloroquine",
                "Chloroquin",
                "chloroquine",
                "Clorochina"),
    /**
     * EN: Chlorphenamine.<br>
     * DE: Chlorphenamin.<br>
     * FR: chlorphénamine.<br>
     * IT: Clorfenamina.<br>
     */
    CHLORPHENAMINE("372914003",
                   "http://snomed.info/sct",
                   "Chlorphenamine (substance)",
                   "Chlorphenamine",
                   "Chlorphenamin",
                   "chlorphénamine",
                   "Clorfenamina"),
    /**
     * EN: Chlorpromazine.<br>
     * DE: Chlorpromazin.<br>
     * FR: chlorpromazine.<br>
     * IT: Clorpromazina.<br>
     */
    CHLORPROMAZINE("387258005",
                   "http://snomed.info/sct",
                   "Chlorpromazine (substance)",
                   "Chlorpromazine",
                   "Chlorpromazin",
                   "chlorpromazine",
                   "Clorpromazina"),
    /**
     * EN: Chlorprothixene.<br>
     * DE: Chlorprothixen.<br>
     * FR: chlorprothixène.<br>
     * IT: Clorprotixene.<br>
     */
    CHLORPROTHIXENE("387317000",
                    "http://snomed.info/sct",
                    "Chlorprothixene (substance)",
                    "Chlorprothixene",
                    "Chlorprothixen",
                    "chlorprothixène",
                    "Clorprotixene"),
    /**
     * EN: Chlortalidone.<br>
     * DE: Chlortalidon.<br>
     * FR: chlortalidone.<br>
     * IT: Clortalidone.<br>
     */
    CHLORTALIDONE("387324004",
                  "http://snomed.info/sct",
                  "Chlortalidone (substance)",
                  "Chlortalidone",
                  "Chlortalidon",
                  "chlortalidone",
                  "Clortalidone"),
    /**
     * EN: Chondroitin sulfate.<br>
     * DE: Chondroitinsulfate-Gemisch.<br>
     * FR: chondroïtine sulfate.<br>
     * IT: Condroitinsolfato.<br>
     */
    CHONDROITIN_SULFATE("4104007",
                        "http://snomed.info/sct",
                        "Chondroitin sulfate (substance)",
                        "Chondroitin sulfate",
                        "Chondroitinsulfate-Gemisch",
                        "chondroïtine sulfate",
                        "Condroitinsolfato"),
    /**
     * EN: Choriogonadotropin alfa.<br>
     * DE: Choriogonadotropin alfa.<br>
     * FR: choriogonadotropine alfa.<br>
     * IT: Coriogonadotropina alfa.<br>
     */
    CHORIOGONADOTROPIN_ALFA("129494006",
                            "http://snomed.info/sct",
                            "Choriogonadotropin alfa (substance)",
                            "Choriogonadotropin alfa",
                            "Choriogonadotropin alfa",
                            "choriogonadotropine alfa",
                            "Coriogonadotropina alfa"),
    /**
     * EN: Ciclesonide.<br>
     * DE: Ciclesonid.<br>
     * FR: ciclésonide.<br>
     * IT: Ciclesonide.<br>
     */
    CICLESONIDE("417420004",
                "http://snomed.info/sct",
                "Ciclesonide (substance)",
                "Ciclesonide",
                "Ciclesonid",
                "ciclésonide",
                "Ciclesonide"),
    /**
     * EN: Ciclopirox.<br>
     * DE: Ciclopirox.<br>
     * FR: ciclopirox.<br>
     * IT: Ciclopirox.<br>
     */
    CICLOPIROX("372854000",
               "http://snomed.info/sct",
               "Ciclopirox (substance)",
               "Ciclopirox",
               "Ciclopirox",
               "ciclopirox",
               "Ciclopirox"),
    /**
     * EN: Ciclosporin.<br>
     * DE: Ciclosporin.<br>
     * FR: ciclosporine.<br>
     * IT: Ciclosporina.<br>
     */
    CICLOSPORIN("387467008",
                "http://snomed.info/sct",
                "Ciclosporin (substance)",
                "Ciclosporin",
                "Ciclosporin",
                "ciclosporine",
                "Ciclosporina"),
    /**
     * EN: Cilastatin.<br>
     * DE: Cilastatin.<br>
     * FR: cilastatine.<br>
     * IT: Cilastatina.<br>
     */
    CILASTATIN("96058005",
               "http://snomed.info/sct",
               "Cilastatin (substance)",
               "Cilastatin",
               "Cilastatin",
               "cilastatine",
               "Cilastatina"),
    /**
     * EN: Cilazapril.<br>
     * DE: Cilazapril.<br>
     * FR: cilazapril.<br>
     * IT: Cilazapril.<br>
     */
    CILAZAPRIL("395947008",
               "http://snomed.info/sct",
               "Cilazapril (substance)",
               "Cilazapril",
               "Cilazapril",
               "cilazapril",
               "Cilazapril"),
    /**
     * EN: Cimetidine.<br>
     * DE: Cimetidin.<br>
     * FR: cimétidine.<br>
     * IT: Cimetidina.<br>
     */
    CIMETIDINE("373541007",
               "http://snomed.info/sct",
               "Cimetidine (substance)",
               "Cimetidine",
               "Cimetidin",
               "cimétidine",
               "Cimetidina"),
    /**
     * EN: Cinacalcet.<br>
     * DE: Cinacalcet.<br>
     * FR: cinacalcet.<br>
     * IT: Cinacalcet.<br>
     */
    CINACALCET("409392004",
               "http://snomed.info/sct",
               "Cinacalcet (substance)",
               "Cinacalcet",
               "Cinacalcet",
               "cinacalcet",
               "Cinacalcet"),
    /**
     * EN: Cinchocaine.<br>
     * DE: Cinchocain.<br>
     * FR: cinchocaïne.<br>
     * IT: Cincocaina.<br>
     */
    CINCHOCAINE("395953008",
                "http://snomed.info/sct",
                "Cinchocaine (substance)",
                "Cinchocaine",
                "Cinchocain",
                "cinchocaïne",
                "Cincocaina"),
    /**
     * EN: Cinnarizine.<br>
     * DE: Cinnarizin.<br>
     * FR: cinnarizine.<br>
     * IT: Cinnarizina.<br>
     */
    CINNARIZINE("395955001",
                "http://snomed.info/sct",
                "Cinnarizine (substance)",
                "Cinnarizine",
                "Cinnarizin",
                "cinnarizine",
                "Cinnarizina"),
    /**
     * EN: Ciprofloxacin.<br>
     * DE: Ciprofloxacin.<br>
     * FR: ciprofloxacine.<br>
     * IT: Ciprofloxacina.<br>
     */
    CIPROFLOXACIN("372840008",
                  "http://snomed.info/sct",
                  "Ciprofloxacin (substance)",
                  "Ciprofloxacin",
                  "Ciprofloxacin",
                  "ciprofloxacine",
                  "Ciprofloxacina"),
    /**
     * EN: Cisatracurium.<br>
     * DE: Cisatracurium.<br>
     * FR: cisatracurium.<br>
     * IT: Cisatracurio.<br>
     */
    CISATRACURIUM("372495006",
                  "http://snomed.info/sct",
                  "Cisatracurium (substance)",
                  "Cisatracurium",
                  "Cisatracurium",
                  "cisatracurium",
                  "Cisatracurio"),
    /**
     * EN: Cisplatin.<br>
     * DE: Cisplatin.<br>
     * FR: cisplatine.<br>
     * IT: Cisplatino.<br>
     */
    CISPLATIN("387318005",
              "http://snomed.info/sct",
              "Cisplatin (substance)",
              "Cisplatin",
              "Cisplatin",
              "cisplatine",
              "Cisplatino"),
    /**
     * EN: Citalopram.<br>
     * DE: Citalopram.<br>
     * FR: citalopram.<br>
     * IT: Citalopram.<br>
     */
    CITALOPRAM("372596005",
               "http://snomed.info/sct",
               "Citalopram (substance)",
               "Citalopram",
               "Citalopram",
               "citalopram",
               "Citalopram"),
    /**
     * EN: Citric acid monohydrate.<br>
     * DE: Citronensäure-Monohydrat.<br>
     * FR: acide citrique monohydrate.<br>
     * IT: Acido citrico monoidrato.<br>
     */
    CITRIC_ACID_MONOHYDRATE("725962006",
                            "http://snomed.info/sct",
                            "Citric acid monohydrate (substance)",
                            "Citric acid monohydrate",
                            "Citronensäure-Monohydrat",
                            "acide citrique monohydrate",
                            "Acido citrico monoidrato"),
    /**
     * EN: Cladribine.<br>
     * DE: Cladribin.<br>
     * FR: cladribine.<br>
     * IT: Cladribina.<br>
     */
    CLADRIBINE("386916009",
               "http://snomed.info/sct",
               "Cladribine (substance)",
               "Cladribine",
               "Cladribin",
               "cladribine",
               "Cladribina"),
    /**
     * EN: Clarithromycin.<br>
     * DE: Clarithromycin.<br>
     * FR: clarithromycine.<br>
     * IT: Claritromicina.<br>
     */
    CLARITHROMYCIN("387487009",
                   "http://snomed.info/sct",
                   "Clarithromycin (substance)",
                   "Clarithromycin",
                   "Clarithromycin",
                   "clarithromycine",
                   "Claritromicina"),
    /**
     * EN: Clavulanic acid.<br>
     * DE: Clavulansäure.<br>
     * FR: acide clavulanique.<br>
     * IT: Acido clavulanico.<br>
     */
    CLAVULANIC_ACID("395939008",
                    "http://snomed.info/sct",
                    "Clavulanic acid (substance)",
                    "Clavulanic acid",
                    "Clavulansäure",
                    "acide clavulanique",
                    "Acido clavulanico"),
    /**
     * EN: Clemastine.<br>
     * DE: Clemastin.<br>
     * FR: clémastine.<br>
     * IT: Clemastina.<br>
     */
    CLEMASTINE("372744005",
               "http://snomed.info/sct",
               "Clemastine (substance)",
               "Clemastine",
               "Clemastin",
               "clémastine",
               "Clemastina"),
    /**
     * EN: Clevidipine.<br>
     * DE: Clevidipin.<br>
     * FR: clévidipine.<br>
     * IT: Clevidipina.<br>
     */
    CLEVIDIPINE("439471002",
                "http://snomed.info/sct",
                "Clevidipine (substance)",
                "Clevidipine",
                "Clevidipin",
                "clévidipine",
                "Clevidipina"),
    /**
     * EN: Clindamycin.<br>
     * DE: Clindamycin.<br>
     * FR: clindamycine.<br>
     * IT: Clindamicina.<br>
     */
    CLINDAMYCIN("372786004",
                "http://snomed.info/sct",
                "Clindamycin (substance)",
                "Clindamycin",
                "Clindamycin",
                "clindamycine",
                "Clindamicina"),
    /**
     * EN: Clioquinol.<br>
     * DE: Clioquinol.<br>
     * FR: clioquinol.<br>
     * IT: Cliochinolo.<br>
     */
    CLIOQUINOL("387291001",
               "http://snomed.info/sct",
               "Clioquinol (substance)",
               "Clioquinol",
               "Clioquinol",
               "clioquinol",
               "Cliochinolo"),
    /**
     * EN: Clobazam.<br>
     * DE: Clobazam.<br>
     * FR: clobazam.<br>
     * IT: Clobazam.<br>
     */
    CLOBAZAM("387572002",
             "http://snomed.info/sct",
             "Clobazam (substance)",
             "Clobazam",
             "Clobazam",
             "clobazam",
             "Clobazam"),
    /**
     * EN: Clobetasol.<br>
     * DE: Clobetasol.<br>
     * FR: clobétasol.<br>
     * IT: Clobetasolo.<br>
     */
    CLOBETASOL("419129004",
               "http://snomed.info/sct",
               "Clobetasol (substance)",
               "Clobetasol",
               "Clobetasol",
               "clobétasol",
               "Clobetasolo"),
    /**
     * EN: Clobetasone.<br>
     * DE: Clobetason.<br>
     * FR: clobétasone.<br>
     * IT: Clobetasone.<br>
     */
    CLOBETASONE("395963000",
                "http://snomed.info/sct",
                "Clobetasone (substance)",
                "Clobetasone",
                "Clobetason",
                "clobétasone",
                "Clobetasone"),
    /**
     * EN: Clofarabine.<br>
     * DE: Clofarabin.<br>
     * FR: clofarabine.<br>
     * IT: Clofarabina.<br>
     */
    CLOFARABINE("413873006",
                "http://snomed.info/sct",
                "Clofarabine (substance)",
                "Clofarabine",
                "Clofarabin",
                "clofarabine",
                "Clofarabina"),
    /**
     * EN: Clofazimine.<br>
     * DE: Clofazimin.<br>
     * FR: clofazimine.<br>
     * IT: Clofazimina.<br>
     */
    CLOFAZIMINE("387410004",
                "http://snomed.info/sct",
                "Clofazimine (substance)",
                "Clofazimine",
                "Clofazimin",
                "clofazimine",
                "Clofazimina"),
    /**
     * EN: Clomethiazole.<br>
     * DE: Clomethiazol.<br>
     * FR: clométhiazole.<br>
     * IT: Clometiazolo.<br>
     */
    CLOMETHIAZOLE("395978007",
                  "http://snomed.info/sct",
                  "Clomethiazole (substance)",
                  "Clomethiazole",
                  "Clomethiazol",
                  "clométhiazole",
                  "Clometiazolo"),
    /**
     * EN: Clomipramine.<br>
     * DE: Clomipramin.<br>
     * FR: clomipramine.<br>
     * IT: Clomipramina.<br>
     */
    CLOMIPRAMINE("372903001",
                 "http://snomed.info/sct",
                 "Clomipramine (substance)",
                 "Clomipramine",
                 "Clomipramin",
                 "clomipramine",
                 "Clomipramina"),
    /**
     * EN: Clonazepam.<br>
     * DE: Clonazepam.<br>
     * FR: clonazépam.<br>
     * IT: Clonazepam.<br>
     */
    CLONAZEPAM("387383007",
               "http://snomed.info/sct",
               "Clonazepam (substance)",
               "Clonazepam",
               "Clonazepam",
               "clonazépam",
               "Clonazepam"),
    /**
     * EN: Clonidine.<br>
     * DE: Clonidin.<br>
     * FR: clonidine.<br>
     * IT: Clonidina.<br>
     */
    CLONIDINE("372805007",
              "http://snomed.info/sct",
              "Clonidine (substance)",
              "Clonidine",
              "Clonidin",
              "clonidine",
              "Clonidina"),
    /**
     * EN: Clopidogrel.<br>
     * DE: Clopidogrel.<br>
     * FR: clopidogrel.<br>
     * IT: Clopidogrel.<br>
     */
    CLOPIDOGREL("386952008",
                "http://snomed.info/sct",
                "Clopidogrel (substance)",
                "Clopidogrel",
                "Clopidogrel",
                "clopidogrel",
                "Clopidogrel"),
    /**
     * EN: Clotiapine.<br>
     * DE: Clotiapin.<br>
     * FR: clotiapine.<br>
     * IT: Clotiapina.<br>
     */
    CLOTIAPINE("698028004",
               "http://snomed.info/sct",
               "Clotiapine (substance)",
               "Clotiapine",
               "Clotiapin",
               "clotiapine",
               "Clotiapina"),
    /**
     * EN: Clotrimazole.<br>
     * DE: Clotrimazol.<br>
     * FR: clotrimazole.<br>
     * IT: Clotrimazolo.<br>
     */
    CLOTRIMAZOLE("387325003",
                 "http://snomed.info/sct",
                 "Clotrimazole (substance)",
                 "Clotrimazole",
                 "Clotrimazol",
                 "clotrimazole",
                 "Clotrimazolo"),
    /**
     * EN: Clozapine.<br>
     * DE: Clozapin.<br>
     * FR: clozapine.<br>
     * IT: Clozapina.<br>
     */
    CLOZAPINE("387568001",
              "http://snomed.info/sct",
              "Clozapine (substance)",
              "Clozapine",
              "Clozapin",
              "clozapine",
              "Clozapina"),
    /**
     * EN: Coagulation factor II.<br>
     * DE: Blutgerinnungsfaktor II human (Prothrombin).<br>
     * FR: facteur II de coagulation humain (prothrombine).<br>
     * IT: Fattore II di coagulazione umano (protrombina).<br>
     */
    COAGULATION_FACTOR_II("7348004",
                          "http://snomed.info/sct",
                          "Coagulation factor II (substance)",
                          "Coagulation factor II",
                          "Blutgerinnungsfaktor II human (Prothrombin)",
                          "facteur II de coagulation humain (prothrombine)",
                          "Fattore II di coagulazione umano (protrombina)"),
    /**
     * EN: Coagulation factor IX.<br>
     * DE: Blutgerinnungsfaktor IX human.<br>
     * FR: facteur IX de coagulation humain.<br>
     * IT: Fattore IX di coagulazione umano.<br>
     */
    COAGULATION_FACTOR_IX("54378000",
                          "http://snomed.info/sct",
                          "Coagulation factor IX (substance)",
                          "Coagulation factor IX",
                          "Blutgerinnungsfaktor IX human",
                          "facteur IX de coagulation humain",
                          "Fattore IX di coagulazione umano"),
    /**
     * EN: Coagulation factor VII.<br>
     * DE: Blutgerinnungsfaktor VII human.<br>
     * FR: facteur VII de coagulation humain.<br>
     * IT: Fattore VII di coagulazione umano.<br>
     */
    COAGULATION_FACTOR_VII("30804005",
                           "http://snomed.info/sct",
                           "Coagulation factor VII (substance)",
                           "Coagulation factor VII",
                           "Blutgerinnungsfaktor VII human",
                           "facteur VII de coagulation humain",
                           "Fattore VII di coagulazione umano"),
    /**
     * EN: Coagulation factor X.<br>
     * DE: Blutgerinnungsfaktor X human.<br>
     * FR: facteur X de coagulation humain.<br>
     * IT: Fattore X di coagulazione umano.<br>
     */
    COAGULATION_FACTOR_X("81444003",
                         "http://snomed.info/sct",
                         "Coagulation factor X (substance)",
                         "Coagulation factor X",
                         "Blutgerinnungsfaktor X human",
                         "facteur X de coagulation humain",
                         "Fattore X di coagulazione umano"),
    /**
     * EN: Coagulation factor XIII.<br>
     * DE: Blutgerinnungsfaktor XIII human.<br>
     * FR: facteur XIII de coagulation humain.<br>
     * IT: Fattore XIII di coagulazione umano.<br>
     */
    COAGULATION_FACTOR_XIII("51161000",
                            "http://snomed.info/sct",
                            "Coagulation factor XIII (substance)",
                            "Coagulation factor XIII",
                            "Blutgerinnungsfaktor XIII human",
                            "facteur XIII de coagulation humain",
                            "Fattore XIII di coagulazione umano"),
    /**
     * EN: Cobicistat.<br>
     * DE: Cobicistat.<br>
     * FR: cobicistat.<br>
     * IT: Cobicistat.<br>
     */
    COBICISTAT("710109003",
               "http://snomed.info/sct",
               "Cobicistat (substance)",
               "Cobicistat",
               "Cobicistat",
               "cobicistat",
               "Cobicistat"),
    /**
     * EN: Cocaine.<br>
     * DE: Cocain.<br>
     * FR: cocaïne.<br>
     * IT: Cocaina.<br>
     */
    COCAINE("387085005",
            "http://snomed.info/sct",
            "Cocaine (substance)",
            "Cocaine",
            "Cocain",
            "cocaïne",
            "Cocaina"),
    /**
     * EN: Codeine.<br>
     * DE: Codein.<br>
     * FR: codéine.<br>
     * IT: Codeina.<br>
     */
    CODEINE("387494007",
            "http://snomed.info/sct",
            "Codeine (substance)",
            "Codeine",
            "Codein",
            "codéine",
            "Codeina"),
    /**
     * EN: Codeine phosphate hemihydrate.<br>
     * DE: Codein phosphat hemihydrat.<br>
     * FR: codéine phosphate hémihydrate.<br>
     * IT: Codeina fosfato emiidrato.<br>
     */
    CODEINE_PHOSPHATE_HEMIHYDRATE("725666006",
                                  "http://snomed.info/sct",
                                  "Codeine phosphate hemihydrate (substance)",
                                  "Codeine phosphate hemihydrate",
                                  "Codein phosphat hemihydrat",
                                  "codéine phosphate hémihydrate",
                                  "Codeina fosfato emiidrato"),
    /**
     * EN: Colchicine.<br>
     * DE: Colchicin.<br>
     * FR: colchicine.<br>
     * IT: Colchicina.<br>
     */
    COLCHICINE("387413002",
               "http://snomed.info/sct",
               "Colchicine (substance)",
               "Colchicine",
               "Colchicin",
               "colchicine",
               "Colchicina"),
    /**
     * EN: Colecalciferol.<br>
     * DE: Colecalciferol (Vitamin D3).<br>
     * FR: colécalciférol (Vitamine D3).<br>
     * IT: Colecalciferolo.<br>
     */
    COLECALCIFEROL("18414002",
                   "http://snomed.info/sct",
                   "Colecalciferol (substance)",
                   "Colecalciferol",
                   "Colecalciferol (Vitamin D3)",
                   "colécalciférol (Vitamine D3)",
                   "Colecalciferolo"),
    /**
     * EN: Colestyramine.<br>
     * DE: Colestyramin.<br>
     * FR: colestyramine.<br>
     * IT: Colestiramina.<br>
     */
    COLESTYRAMINE("387408001",
                  "http://snomed.info/sct",
                  "Colestyramine (substance)",
                  "Colestyramine",
                  "Colestyramin",
                  "colestyramine",
                  "Colestiramina"),
    /**
     * EN: Colistin.<br>
     * DE: Colistin.<br>
     * FR: colistine.<br>
     * IT: Colistina.<br>
     */
    COLISTIN("387412007",
             "http://snomed.info/sct",
             "Colistin (substance)",
             "Colistin",
             "Colistin",
             "colistine",
             "Colistina"),
    /**
     * EN: Copper sulfate.<br>
     * DE: Kupfer(II)-sulfat, wasserfreies.<br>
     * FR: cuivre sulfate.<br>
     * IT: Rame solfato.<br>
     */
    COPPER_SULFATE("70168001",
                   "http://snomed.info/sct",
                   "Copper sulfate (substance)",
                   "Copper sulfate",
                   "Kupfer(II)-sulfat, wasserfreies",
                   "cuivre sulfate",
                   "Rame solfato"),
    /**
     * EN: Cromoglicate sodium.<br>
     * DE: Cromoglicinsäure, Dinatriumsalz.<br>
     * FR: cromoglicate sodique.<br>
     * IT: Sodio cromoglicato.<br>
     */
    CROMOGLICATE_SODIUM("387221005",
                        "http://snomed.info/sct",
                        "Cromoglicate sodium (substance)",
                        "Cromoglicate sodium",
                        "Cromoglicinsäure, Dinatriumsalz",
                        "cromoglicate sodique",
                        "Sodio cromoglicato"),
    /**
     * EN: Cromoglicic acid.<br>
     * DE: Cromoglicinsäure.<br>
     * FR: acide cromoglicique.<br>
     * IT: Acido cromoglicico.<br>
     */
    CROMOGLICIC_ACID("372672009",
                     "http://snomed.info/sct",
                     "Cromoglicic acid (substance)",
                     "Cromoglicic acid",
                     "Cromoglicinsäure",
                     "acide cromoglicique",
                     "Acido cromoglicico"),
    /**
     * EN: Cyanocobalamin.<br>
     * DE: Cyanocobalamin (Vitamin B12).<br>
     * FR: cyanocobalamine (Vitamine B12).<br>
     * IT: Cianocobalamina.<br>
     */
    CYANOCOBALAMIN("419382002",
                   "http://snomed.info/sct",
                   "Cyanocobalamin (substance)",
                   "Cyanocobalamin",
                   "Cyanocobalamin (Vitamin B12)",
                   "cyanocobalamine (Vitamine B12)",
                   "Cianocobalamina"),
    /**
     * EN: Cyclophosphamide.<br>
     * DE: Cyclophosphamid.<br>
     * FR: cyclophosphamide.<br>
     * IT: Ciclofosfamide.<br>
     */
    CYCLOPHOSPHAMIDE("387420009",
                     "http://snomed.info/sct",
                     "Cyclophosphamide (substance)",
                     "Cyclophosphamide",
                     "Cyclophosphamid",
                     "cyclophosphamide",
                     "Ciclofosfamide"),
    /**
     * EN: Cycloserine.<br>
     * DE: Cycloserin.<br>
     * FR: cycloserine.<br>
     * IT: Cicloserina.<br>
     */
    CYCLOSERINE("387282000",
                "http://snomed.info/sct",
                "Cycloserine (substance)",
                "Cycloserine",
                "Cycloserin",
                "cycloserine",
                "Cicloserina"),
    /**
     * EN: Cyproterone.<br>
     * DE: Cyproteron.<br>
     * FR: cyprotérone.<br>
     * IT: Ciproterone.<br>
     */
    CYPROTERONE("126119006",
                "http://snomed.info/sct",
                "Cyproterone (substance)",
                "Cyproterone",
                "Cyproteron",
                "cyprotérone",
                "Ciproterone"),
    /**
     * EN: Cytarabine.<br>
     * DE: Cytarabin.<br>
     * FR: cytarabine.<br>
     * IT: Citarabina.<br>
     */
    CYTARABINE("387511003",
               "http://snomed.info/sct",
               "Cytarabine (substance)",
               "Cytarabine",
               "Cytarabin",
               "cytarabine",
               "Citarabina"),
    /**
     * EN: Cytomegalovirus antibody.<br>
     * DE: Cytomegalie-Immunglobulin human.<br>
     * FR: immunoglobuline humaine anti cytomégalovirus.<br>
     * IT: Immunoglobulina umana anti-citomegalovirus.<br>
     */
    CYTOMEGALOVIRUS_ANTIBODY("120941004",
                             "http://snomed.info/sct",
                             "Cytomegalovirus antibody (substance)",
                             "Cytomegalovirus antibody",
                             "Cytomegalie-Immunglobulin human",
                             "immunoglobuline humaine anti cytomégalovirus",
                             "Immunoglobulina umana anti-citomegalovirus"),
    /**
     * EN: Dabigatran etexilate.<br>
     * DE: Dabigatran etexilat.<br>
     * FR: dabigatran étexilate.<br>
     * IT: Dabigratan etexilato.<br>
     */
    DABIGATRAN_ETEXILATE("700029008",
                         "http://snomed.info/sct",
                         "Dabigatran etexilate (substance)",
                         "Dabigatran etexilate",
                         "Dabigatran etexilat",
                         "dabigatran étexilate",
                         "Dabigratan etexilato"),
    /**
     * EN: Dabrafenib.<br>
     * DE: Dabrafenib.<br>
     * FR: dabrafénib.<br>
     * IT: Dabrafenib.<br>
     */
    DABRAFENIB("703641001",
               "http://snomed.info/sct",
               "Dabrafenib (substance)",
               "Dabrafenib",
               "Dabrafenib",
               "dabrafénib",
               "Dabrafenib"),
    /**
     * EN: Dacarbazine.<br>
     * DE: Dacarbazin.<br>
     * FR: dacarbazine.<br>
     * IT: Dacarbazina.<br>
     */
    DACARBAZINE("387441003",
                "http://snomed.info/sct",
                "Dacarbazine (substance)",
                "Dacarbazine",
                "Dacarbazin",
                "dacarbazine",
                "Dacarbazina"),
    /**
     * EN: Daclatasvir.<br>
     * DE: Daclatasvir.<br>
     * FR: daclatasvir.<br>
     * IT: Daclatasvir.<br>
     */
    DACLATASVIR("712519008",
                "http://snomed.info/sct",
                "Daclatasvir (substance)",
                "Daclatasvir",
                "Daclatasvir",
                "daclatasvir",
                "Daclatasvir"),
    /**
     * EN: Dactinomycin.<br>
     * DE: Dactinomycin.<br>
     * FR: dactinomycine.<br>
     * IT: Dactinomicina.<br>
     */
    DACTINOMYCIN("387353003",
                 "http://snomed.info/sct",
                 "Dactinomycin (substance)",
                 "Dactinomycin",
                 "Dactinomycin",
                 "dactinomycine",
                 "Dactinomicina"),
    /**
     * EN: Dalteparin sodium.<br>
     * DE: Dalteparin natrium.<br>
     * FR: daltéparine sodique.<br>
     * IT: Dalteparina sodica.<br>
     */
    DALTEPARIN_SODIUM("108987000",
                      "http://snomed.info/sct",
                      "Dalteparin sodium (substance)",
                      "Dalteparin sodium",
                      "Dalteparin natrium",
                      "daltéparine sodique",
                      "Dalteparina sodica"),
    /**
     * EN: Danaparoid.<br>
     * DE: Danaparoid.<br>
     * FR: danaparoïde.<br>
     * IT: Danaparoid.<br>
     */
    DANAPAROID("372564002",
               "http://snomed.info/sct",
               "Danaparoid (substance)",
               "Danaparoid",
               "Danaparoid",
               "danaparoïde",
               "Danaparoid"),
    /**
     * EN: Dantrolene.<br>
     * DE: Dantrolen.<br>
     * FR: dantrolène.<br>
     * IT: Dantrolene.<br>
     */
    DANTROLENE("372819007",
               "http://snomed.info/sct",
               "Dantrolene (substance)",
               "Dantrolene",
               "Dantrolen",
               "dantrolène",
               "Dantrolene"),
    /**
     * EN: Dapagliflozin.<br>
     * DE: Dapagliflozin.<br>
     * FR: dapagliflozine.<br>
     * IT: Dapaglifozin.<br>
     */
    DAPAGLIFLOZIN("703674001",
                  "http://snomed.info/sct",
                  "Dapagliflozin (substance)",
                  "Dapagliflozin",
                  "Dapagliflozin",
                  "dapagliflozine",
                  "Dapaglifozin"),
    /**
     * EN: Dapoxetine.<br>
     * DE: Dapoxetin.<br>
     * FR: dapoxétine.<br>
     * IT: Dapoxetina.<br>
     */
    DAPOXETINE("702794006",
               "http://snomed.info/sct",
               "Dapoxetine (substance)",
               "Dapoxetine",
               "Dapoxetin",
               "dapoxétine",
               "Dapoxetina"),
    /**
     * EN: Daptomycin.<br>
     * DE: Daptomycin.<br>
     * FR: daptomycine.<br>
     * IT: Daptomicina.<br>
     */
    DAPTOMYCIN("406439009",
               "http://snomed.info/sct",
               "Daptomycin (substance)",
               "Daptomycin",
               "Daptomycin",
               "daptomycine",
               "Daptomicina"),
    /**
     * EN: Daratumumab.<br>
     * DE: Daratumumab.<br>
     * FR: daratumumab.<br>
     * IT: Daratumumab.<br>
     */
    DARATUMUMAB("716016006",
                "http://snomed.info/sct",
                "Daratumumab (substance)",
                "Daratumumab",
                "Daratumumab",
                "daratumumab",
                "Daratumumab"),
    /**
     * EN: Darbepoetin alfa.<br>
     * DE: Darbepoetin alfa.<br>
     * FR: darbépoétine alfa.<br>
     * IT: Darbeaoetina alfa.<br>
     */
    DARBEPOETIN_ALFA("385608005",
                     "http://snomed.info/sct",
                     "Darbepoetin alfa (substance)",
                     "Darbepoetin alfa",
                     "Darbepoetin alfa",
                     "darbépoétine alfa",
                     "Darbeaoetina alfa"),
    /**
     * EN: Darifenacin.<br>
     * DE: Darifenacin.<br>
     * FR: darifénacine.<br>
     * IT: Darifenacina.<br>
     */
    DARIFENACIN("416140008",
                "http://snomed.info/sct",
                "Darifenacin (substance)",
                "Darifenacin",
                "Darifenacin",
                "darifénacine",
                "Darifenacina"),
    /**
     * EN: Darunavir.<br>
     * DE: Darunavir.<br>
     * FR: darunavir.<br>
     * IT: Darunavir.<br>
     */
    DARUNAVIR("423888002",
              "http://snomed.info/sct",
              "Darunavir (substance)",
              "Darunavir",
              "Darunavir",
              "darunavir",
              "Darunavir"),
    /**
     * EN: Darvadstrocel.<br>
     * DE: Darvadstrocel.<br>
     * FR: darvadstrocel.<br>
     * IT: darvadstrocel.<br>
     */
    DARVADSTROCEL("1156228008",
                  "http://snomed.info/sct",
                  "Darvadstrocel (substance)",
                  "Darvadstrocel",
                  "Darvadstrocel",
                  "darvadstrocel",
                  "darvadstrocel"),
    /**
     * EN: Dasatinib.<br>
     * DE: Dasatinib.<br>
     * FR: dasatinib.<br>
     * IT: Dasatinib.<br>
     */
    DASATINIB("423658008",
              "http://snomed.info/sct",
              "Dasatinib (substance)",
              "Dasatinib",
              "Dasatinib",
              "dasatinib",
              "Dasatinib"),
    /**
     * EN: Daunorubicin.<br>
     * DE: Daunorubicin.<br>
     * FR: daunorubicine.<br>
     * IT: Daunorubicina.<br>
     */
    DAUNORUBICIN("372715008",
                 "http://snomed.info/sct",
                 "Daunorubicin (substance)",
                 "Daunorubicin",
                 "Daunorubicin",
                 "daunorubicine",
                 "Daunorubicina"),
    /**
     * EN: Decitabine.<br>
     * DE: Decitabin.<br>
     * FR: décitabine.<br>
     * IT: Decitabina.<br>
     */
    DECITABINE("420759005",
               "http://snomed.info/sct",
               "Decitabine (substance)",
               "Decitabine",
               "Decitabin",
               "décitabine",
               "Decitabina"),
    /**
     * EN: Deferasirox.<br>
     * DE: Deferasirox.<br>
     * FR: déférasirox.<br>
     * IT: Deferasirox.<br>
     */
    DEFERASIROX("419985007",
                "http://snomed.info/sct",
                "Deferasirox (substance)",
                "Deferasirox",
                "Deferasirox",
                "déférasirox",
                "Deferasirox"),
    /**
     * EN: Deferiprone.<br>
     * DE: Deferipron.<br>
     * FR: défériprone.<br>
     * IT: Deferiprone.<br>
     */
    DEFERIPRONE("396011004",
                "http://snomed.info/sct",
                "Deferiprone (substance)",
                "Deferiprone",
                "Deferipron",
                "défériprone",
                "Deferiprone"),
    /**
     * EN: Deferoxamine.<br>
     * DE: Deferoxamin.<br>
     * FR: déféroxamine.<br>
     * IT: Deferoxamina.<br>
     */
    DEFEROXAMINE("372825006",
                 "http://snomed.info/sct",
                 "Deferoxamine (substance)",
                 "Deferoxamine",
                 "Deferoxamin",
                 "déféroxamine",
                 "Deferoxamina"),
    /**
     * EN: Defibrotide.<br>
     * DE: Defibrotid.<br>
     * FR: défibrotide.<br>
     * IT: Defibrotide.<br>
     */
    DEFIBROTIDE("442263003",
                "http://snomed.info/sct",
                "Defibrotide (substance)",
                "Defibrotide",
                "Defibrotid",
                "défibrotide",
                "Defibrotide"),
    /**
     * EN: Deflazacort.<br>
     * DE: Deflazacort.<br>
     * FR: déflazacort.<br>
     * IT: Deflazacort.<br>
     */
    DEFLAZACORT("396012006",
                "http://snomed.info/sct",
                "Deflazacort (substance)",
                "Deflazacort",
                "Deflazacort",
                "déflazacort",
                "Deflazacort"),
    /**
     * EN: Degarelix.<br>
     * DE: Degarelix.<br>
     * FR: dégarélix.<br>
     * IT: Degarelix.<br>
     */
    DEGARELIX("441864003",
              "http://snomed.info/sct",
              "Degarelix (substance)",
              "Degarelix",
              "Degarelix",
              "dégarélix",
              "Degarelix"),
    /**
     * EN: Delta-9-tetrahydrocannabinol.<br>
     * DE: Delta-9-Tetrahydrocannabinol (THC).<br>
     * FR: delta-9-tétrahydrocannabinol (THC).<br>
     * IT: Delta-9-tetracannabinolo (THC).<br>
     */
    DELTA_9_TETRAHYDROCANNABINOL("96225007",
                                 "http://snomed.info/sct",
                                 "Delta-9-tetrahydrocannabinol (substance)",
                                 "Delta-9-tetrahydrocannabinol",
                                 "Delta-9-Tetrahydrocannabinol (THC)",
                                 "delta-9-tétrahydrocannabinol (THC)",
                                 "Delta-9-tetracannabinolo (THC)"),
    /**
     * EN: Denosumab.<br>
     * DE: Denosumab.<br>
     * FR: dénosumab.<br>
     * IT: Denosumab.<br>
     */
    DENOSUMAB("446321003",
              "http://snomed.info/sct",
              "Denosumab (substance)",
              "Denosumab",
              "Denosumab",
              "dénosumab",
              "Denosumab"),
    /**
     * EN: Desflurane.<br>
     * DE: Desfluran.<br>
     * FR: desflurane.<br>
     * IT: Desflurano.<br>
     */
    DESFLURANE("386841003",
               "http://snomed.info/sct",
               "Desflurane (substance)",
               "Desflurane",
               "Desfluran",
               "desflurane",
               "Desflurano"),
    /**
     * EN: Desloratadine.<br>
     * DE: Desloratadin.<br>
     * FR: desloratadine.<br>
     * IT: Desloratadina.<br>
     */
    DESLORATADINE("396015008",
                  "http://snomed.info/sct",
                  "Desloratadine (substance)",
                  "Desloratadine",
                  "Desloratadin",
                  "desloratadine",
                  "Desloratadina"),
    /**
     * EN: Desmopressin.<br>
     * DE: Desmopressin.<br>
     * FR: desmopressine.<br>
     * IT: Desmopressina.<br>
     */
    DESMOPRESSIN("126189002",
                 "http://snomed.info/sct",
                 "Desmopressin (substance)",
                 "Desmopressin",
                 "Desmopressin",
                 "desmopressine",
                 "Desmopressina"),
    /**
     * EN: Desogestrel.<br>
     * DE: Desogestrel.<br>
     * FR: désogestrel.<br>
     * IT: Desogestrel.<br>
     */
    DESOGESTREL("126108008",
                "http://snomed.info/sct",
                "Desogestrel (substance)",
                "Desogestrel",
                "Desogestrel",
                "désogestrel",
                "Desogestrel"),
    /**
     * EN: Dexamethasone.<br>
     * DE: Dexamethason.<br>
     * FR: dexaméthasone.<br>
     * IT: Desametasone.<br>
     */
    DEXAMETHASONE("372584003",
                  "http://snomed.info/sct",
                  "Dexamethasone (substance)",
                  "Dexamethasone",
                  "Dexamethason",
                  "dexaméthasone",
                  "Desametasone"),
    /**
     * EN: Dexamfetamine.<br>
     * DE: Dexamfetamin.<br>
     * FR: dexamfétamine.<br>
     * IT: Dexamfetamina.<br>
     */
    DEXAMFETAMINE("387278002",
                  "http://snomed.info/sct",
                  "Dexamfetamine (substance)",
                  "Dexamfetamine",
                  "Dexamfetamin",
                  "dexamfétamine",
                  "Dexamfetamina"),
    /**
     * EN: Dexibuprofen.<br>
     * DE: Dexibuprofen.<br>
     * FR: dexibuprofène.<br>
     * IT: Dexibuprofene.<br>
     */
    DEXIBUPROFEN("418868002",
                 "http://snomed.info/sct",
                 "Dexibuprofen (substance)",
                 "Dexibuprofen",
                 "Dexibuprofen",
                 "dexibuprofène",
                 "Dexibuprofene"),
    /**
     * EN: Dexketoprofen.<br>
     * DE: Dexketoprofen.<br>
     * FR: dexkétoprofène.<br>
     * IT: Desketoprofene.<br>
     */
    DEXKETOPROFEN("396018005",
                  "http://snomed.info/sct",
                  "Dexketoprofen (substance)",
                  "Dexketoprofen",
                  "Dexketoprofen",
                  "dexkétoprofène",
                  "Desketoprofene"),
    /**
     * EN: Dexlansoprazole.<br>
     * DE: Dexlansoprazol.<br>
     * FR: dexlansoprazole.<br>
     * IT: Dexlansoprazolo.<br>
     */
    DEXLANSOPRAZOLE("441863009",
                    "http://snomed.info/sct",
                    "Dexlansoprazole (substance)",
                    "Dexlansoprazole",
                    "Dexlansoprazol",
                    "dexlansoprazole",
                    "Dexlansoprazolo"),
    /**
     * EN: Dexmedetomidine.<br>
     * DE: Dexmedetomidin.<br>
     * FR: dexmédétomidine.<br>
     * IT: Dexmedetomidina.<br>
     */
    DEXMEDETOMIDINE("437750002",
                    "http://snomed.info/sct",
                    "Dexmedetomidine (substance)",
                    "Dexmedetomidine",
                    "Dexmedetomidin",
                    "dexmédétomidine",
                    "Dexmedetomidina"),
    /**
     * EN: Dexmethylphenidate.<br>
     * DE: Dexmethylphenidat.<br>
     * FR: dexméthylphénidate.<br>
     * IT: Dexmetilfenidato.<br>
     */
    DEXMETHYLPHENIDATE("767715008",
                       "http://snomed.info/sct",
                       "Dexmethylphenidate (substance)",
                       "Dexmethylphenidate",
                       "Dexmethylphenidat",
                       "dexméthylphénidate",
                       "Dexmetilfenidato"),
    /**
     * EN: Dexpanthenol.<br>
     * DE: Dexpanthenol.<br>
     * FR: dexpanthénol.<br>
     * IT: Despantenolo.<br>
     */
    DEXPANTHENOL("126226000",
                 "http://snomed.info/sct",
                 "Dexpanthenol (substance)",
                 "Dexpanthenol",
                 "Dexpanthenol",
                 "dexpanthénol",
                 "Despantenolo"),
    /**
     * EN: Dexrazoxane.<br>
     * DE: Dexrazoxan.<br>
     * FR: dexrazoxane.<br>
     * IT: Dexrazoxano.<br>
     */
    DEXRAZOXANE("108825009",
                "http://snomed.info/sct",
                "Dexrazoxane (substance)",
                "Dexrazoxane",
                "Dexrazoxan",
                "dexrazoxane",
                "Dexrazoxano"),
    /**
     * EN: Dextromethorphan.<br>
     * DE: Dextromethorphan.<br>
     * FR: dextrométhorphane.<br>
     * IT: Destrometorfano.<br>
     */
    DEXTROMETHORPHAN("387114001",
                     "http://snomed.info/sct",
                     "Dextromethorphan (substance)",
                     "Dextromethorphan",
                     "Dextromethorphan",
                     "dextrométhorphane",
                     "Destrometorfano"),
    /**
     * EN: Diamorphine.<br>
     * DE: Heroin.<br>
     * FR: héroïne.<br>
     * IT: Eroina.<br>
     */
    DIAMORPHINE("387341002",
                "http://snomed.info/sct",
                "Diamorphine (substance)",
                "Diamorphine",
                "Heroin",
                "héroïne",
                "Eroina"),
    /**
     * EN: Diazepam.<br>
     * DE: Diazepam.<br>
     * FR: diazépam.<br>
     * IT: Diazepam.<br>
     */
    DIAZEPAM("387264003",
             "http://snomed.info/sct",
             "Diazepam (substance)",
             "Diazepam",
             "Diazepam",
             "diazépam",
             "Diazepam"),
    /**
     * EN: Diclofenac.<br>
     * DE: Diclofenac.<br>
     * FR: diclofénac.<br>
     * IT: Diclofenac.<br>
     */
    DICLOFENAC("7034005",
               "http://snomed.info/sct",
               "Diclofenac (substance)",
               "Diclofenac",
               "Diclofenac",
               "diclofénac",
               "Diclofenac"),
    /**
     * EN: Dienogest.<br>
     * DE: Dienogest.<br>
     * FR: diénogest.<br>
     * IT: Dienogest.<br>
     */
    DIENOGEST("703097002",
              "http://snomed.info/sct",
              "Dienogest (substance)",
              "Dienogest",
              "Dienogest",
              "diénogest",
              "Dienogest"),
    /**
     * EN: Diflucortolone.<br>
     * DE: Diflucortolon.<br>
     * FR: diflucortolone.<br>
     * IT: Diflucortolone.<br>
     */
    DIFLUCORTOLONE("395965007",
                   "http://snomed.info/sct",
                   "Diflucortolone (substance)",
                   "Diflucortolone",
                   "Diflucortolon",
                   "diflucortolone",
                   "Diflucortolone"),
    /**
     * EN: Digitoxin.<br>
     * DE: Digitoxin.<br>
     * FR: digitoxine.<br>
     * IT: Digitossina.<br>
     */
    DIGITOXIN("373534001",
              "http://snomed.info/sct",
              "Digitoxin (substance)",
              "Digitoxin",
              "Digitoxin",
              "digitoxine",
              "Digitossina"),
    /**
     * EN: Digoxin.<br>
     * DE: Digoxin.<br>
     * FR: digoxine.<br>
     * IT: Digossina.<br>
     */
    DIGOXIN("387461009",
            "http://snomed.info/sct",
            "Digoxin (substance)",
            "Digoxin",
            "Digoxin",
            "digoxine",
            "Digossina"),
    /**
     * EN: Dihydralazine.<br>
     * DE: Dihydralazin.<br>
     * FR: dihydralazine.<br>
     * IT: Diidralazina.<br>
     */
    DIHYDRALAZINE("703113001",
                  "http://snomed.info/sct",
                  "Dihydralazine (substance)",
                  "Dihydralazine",
                  "Dihydralazin",
                  "dihydralazine",
                  "Diidralazina"),
    /**
     * EN: Dihydrocodeine.<br>
     * DE: Dihydrocodein.<br>
     * FR: dihydrocodéine.<br>
     * IT: Diidrocodeina.<br>
     */
    DIHYDROCODEINE("387322000",
                   "http://snomed.info/sct",
                   "Dihydrocodeine (substance)",
                   "Dihydrocodeine",
                   "Dihydrocodein",
                   "dihydrocodéine",
                   "Diidrocodeina"),
    /**
     * EN: Diltiazem.<br>
     * DE: Diltiazem.<br>
     * FR: diltiazem.<br>
     * IT: Diltiazem.<br>
     */
    DILTIAZEM("372793000",
              "http://snomed.info/sct",
              "Diltiazem (substance)",
              "Diltiazem",
              "Diltiazem",
              "diltiazem",
              "Diltiazem"),
    /**
     * EN: Dimenhydrinate.<br>
     * DE: Dimenhydrinat.<br>
     * FR: diménhydrinate.<br>
     * IT: Dimenidrinato.<br>
     */
    DIMENHYDRINATE("387469006",
                   "http://snomed.info/sct",
                   "Dimenhydrinate (substance)",
                   "Dimenhydrinate",
                   "Dimenhydrinat",
                   "diménhydrinate",
                   "Dimenidrinato"),
    /**
     * EN: Dimethyl sulfoxide.<br>
     * DE: Dimethylsulfoxid.<br>
     * FR: diméthylsulfoxyde.<br>
     * IT: Dimetilsolfossido (DMSO).<br>
     */
    DIMETHYL_SULFOXIDE("115535002",
                       "http://snomed.info/sct",
                       "Dimethyl sulfoxide (substance)",
                       "Dimethyl sulfoxide",
                       "Dimethylsulfoxid",
                       "diméthylsulfoxyde",
                       "Dimetilsolfossido (DMSO)"),
    /**
     * EN: Dimeticone.<br>
     * DE: Dimeticon.<br>
     * FR: diméticone.<br>
     * IT: Dimeticone.<br>
     */
    DIMETICONE("396031000",
               "http://snomed.info/sct",
               "Dimeticone (substance)",
               "Dimeticone",
               "Dimeticon",
               "diméticone",
               "Dimeticone"),
    /**
     * EN: Dimetindene.<br>
     * DE: Dimetinden.<br>
     * FR: dimétindène.<br>
     * IT: Dimetindene.<br>
     */
    DIMETINDENE("387142004",
                "http://snomed.info/sct",
                "Dimetindene (substance)",
                "Dimetindene",
                "Dimetinden",
                "dimétindène",
                "Dimetindene"),
    /**
     * EN: Dinoprostone.<br>
     * DE: Dinoproston.<br>
     * FR: dinoprostone.<br>
     * IT: Dinoprostone.<br>
     */
    DINOPROSTONE("387245009",
                 "http://snomed.info/sct",
                 "Dinoprostone (substance)",
                 "Dinoprostone",
                 "Dinoproston",
                 "dinoprostone",
                 "Dinoprostone"),
    /**
     * EN: Diosmin.<br>
     * DE: Diosmin.<br>
     * FR: diosmine.<br>
     * IT: Diosmina.<br>
     */
    DIOSMIN("8143001",
            "http://snomed.info/sct",
            "Diosmin (substance)",
            "Diosmin",
            "Diosmin",
            "diosmine",
            "Diosmina"),
    /**
     * EN: Diphenhydramine.<br>
     * DE: Diphenhydramin.<br>
     * FR: diphénhydramine.<br>
     * IT: Difenidramina.<br>
     */
    DIPHENHYDRAMINE("372682005",
                    "http://snomed.info/sct",
                    "Diphenhydramine (substance)",
                    "Diphenhydramine",
                    "Diphenhydramin",
                    "diphénhydramine",
                    "Difenidramina"),
    /**
     * EN: Dipotassium clorazepate.<br>
     * DE: Dikalium clorazepat.<br>
     * FR: clorazépate dipotassique.<br>
     * IT: Clorazepato potassico.<br>
     */
    DIPOTASSIUM_CLORAZEPATE("387453004",
                            "http://snomed.info/sct",
                            "Dipotassium clorazepate (substance)",
                            "Dipotassium clorazepate",
                            "Dikalium clorazepat",
                            "clorazépate dipotassique",
                            "Clorazepato potassico"),
    /**
     * EN: Disulfiram.<br>
     * DE: Disulfiram.<br>
     * FR: disulfirame.<br>
     * IT: Disulfiram.<br>
     */
    DISULFIRAM("387212009",
               "http://snomed.info/sct",
               "Disulfiram (substance)",
               "Disulfiram",
               "Disulfiram",
               "disulfirame",
               "Disulfiram"),
    /**
     * EN: Dobesilate calcium.<br>
     * DE: Calcium dobesilat.<br>
     * FR: dobésilate de calcium.<br>
     * IT: Calcio dobesilato.<br>
     */
    DOBESILATE_CALCIUM("83438009",
                       "http://snomed.info/sct",
                       "Dobesilate calcium (substance)",
                       "Dobesilate calcium",
                       "Calcium dobesilat",
                       "dobésilate de calcium",
                       "Calcio dobesilato"),
    /**
     * EN: Dobutamine.<br>
     * DE: Dobutamin.<br>
     * FR: dobutamine.<br>
     * IT: Dobutamina.<br>
     */
    DOBUTAMINE("387145002",
               "http://snomed.info/sct",
               "Dobutamine (substance)",
               "Dobutamine",
               "Dobutamin",
               "dobutamine",
               "Dobutamina"),
    /**
     * EN: Docetaxel.<br>
     * DE: Docetaxel.<br>
     * FR: docétaxel.<br>
     * IT: Docetaxel.<br>
     */
    DOCETAXEL("386918005",
              "http://snomed.info/sct",
              "Docetaxel (substance)",
              "Docetaxel",
              "Docetaxel",
              "docétaxel",
              "Docetaxel"),
    /**
     * EN: Docosahexaenoic acid.<br>
     * DE: Docosahexaensäure DHA.<br>
     * FR: acide docosahexaénoïque DHA.<br>
     * IT: Acido docosaesaenoico (DHA).<br>
     */
    DOCOSAHEXAENOIC_ACID("226368001",
                         "http://snomed.info/sct",
                         "Docosahexaenoic acid (substance)",
                         "Docosahexaenoic acid",
                         "Docosahexaensäure DHA",
                         "acide docosahexaénoïque DHA",
                         "Acido docosaesaenoico (DHA)"),
    /**
     * EN: Dolutegravir.<br>
     * DE: Dolutegravir.<br>
     * FR: dolutégravir.<br>
     * IT: Dolutegravir.<br>
     */
    DOLUTEGRAVIR("713464000",
                 "http://snomed.info/sct",
                 "Dolutegravir (substance)",
                 "Dolutegravir",
                 "Dolutegravir",
                 "dolutégravir",
                 "Dolutegravir"),
    /**
     * EN: Domperidone.<br>
     * DE: Domperidon.<br>
     * FR: dompéridone.<br>
     * IT: Domperidone.<br>
     */
    DOMPERIDONE("387181004",
                "http://snomed.info/sct",
                "Domperidone (substance)",
                "Domperidone",
                "Domperidon",
                "dompéridone",
                "Domperidone"),
    /**
     * EN: Donepezil.<br>
     * DE: Donepezil.<br>
     * FR: donépézil.<br>
     * IT: Donepezil.<br>
     */
    DONEPEZIL("386855006",
              "http://snomed.info/sct",
              "Donepezil (substance)",
              "Donepezil",
              "Donepezil",
              "donépézil",
              "Donepezil"),
    /**
     * EN: Dopamine.<br>
     * DE: Dopamin.<br>
     * FR: dopamine.<br>
     * IT: Dopamina.<br>
     */
    DOPAMINE("412383006",
             "http://snomed.info/sct",
             "Dopamine (substance)",
             "Dopamine",
             "Dopamin",
             "dopamine",
             "Dopamina"),
    /**
     * EN: Dornase alfa.<br>
     * DE: Dornase alfa.<br>
     * FR: dornase alfa.<br>
     * IT: Dornase alfa.<br>
     */
    DORNASE_ALFA("386882003",
                 "http://snomed.info/sct",
                 "Dornase alfa (substance)",
                 "Dornase alfa",
                 "Dornase alfa",
                 "dornase alfa",
                 "Dornase alfa"),
    /**
     * EN: Dorzolamide.<br>
     * DE: Dorzolamid.<br>
     * FR: dorzolamide.<br>
     * IT: Dorzolamide.<br>
     */
    DORZOLAMIDE("373447009",
                "http://snomed.info/sct",
                "Dorzolamide (substance)",
                "Dorzolamide",
                "Dorzolamid",
                "dorzolamide",
                "Dorzolamide"),
    /**
     * EN: Doxapram.<br>
     * DE: Doxapram.<br>
     * FR: doxapram.<br>
     * IT: Doxapram.<br>
     */
    DOXAPRAM("373339005",
             "http://snomed.info/sct",
             "Doxapram (substance)",
             "Doxapram",
             "Doxapram",
             "doxapram",
             "Doxapram"),
    /**
     * EN: Doxazosin.<br>
     * DE: Doxazosin.<br>
     * FR: doxazosine.<br>
     * IT: Doxazosina.<br>
     */
    DOXAZOSIN("372508002",
              "http://snomed.info/sct",
              "Doxazosin (substance)",
              "Doxazosin",
              "Doxazosin",
              "doxazosine",
              "Doxazosina"),
    /**
     * EN: Doxepin.<br>
     * DE: Doxepin.<br>
     * FR: doxépine.<br>
     * IT: Doxepina.<br>
     */
    DOXEPIN("372587005",
            "http://snomed.info/sct",
            "Doxepin (substance)",
            "Doxepin",
            "Doxepin",
            "doxépine",
            "Doxepina"),
    /**
     * EN: Doxorubicin.<br>
     * DE: Doxorubicin.<br>
     * FR: doxorubicine.<br>
     * IT: Doxorubicina.<br>
     */
    DOXORUBICIN("372817009",
                "http://snomed.info/sct",
                "Doxorubicin (substance)",
                "Doxorubicin",
                "Doxorubicin",
                "doxorubicine",
                "Doxorubicina"),
    /**
     * EN: Doxycycline.<br>
     * DE: Doxycyclin.<br>
     * FR: doxycycline.<br>
     * IT: Doxiciclina.<br>
     */
    DOXYCYCLINE("372478003",
                "http://snomed.info/sct",
                "Doxycycline (substance)",
                "Doxycycline",
                "Doxycyclin",
                "doxycycline",
                "Doxiciclina"),
    /**
     * EN: Doxycycline hyclate.<br>
     * DE: Doxycyclin hyclat.<br>
     * FR: doxycycline hyclate.<br>
     * IT: Doxiciclina iclato.<br>
     */
    DOXYCYCLINE_HYCLATE("71417000",
                        "http://snomed.info/sct",
                        "Doxycycline hyclate (substance)",
                        "Doxycycline hyclate",
                        "Doxycyclin hyclat",
                        "doxycycline hyclate",
                        "Doxiciclina iclato"),
    /**
     * EN: Doxylamine.<br>
     * DE: Doxylamin.<br>
     * FR: doxylamine.<br>
     * IT: Doxilamina.<br>
     */
    DOXYLAMINE("44068004",
               "http://snomed.info/sct",
               "Doxylamine (substance)",
               "Doxylamine",
               "Doxylamin",
               "doxylamine",
               "Doxilamina"),
    /**
     * EN: Dronedarone.<br>
     * DE: Dronedaron.<br>
     * FR: dronédarone.<br>
     * IT: Dronedarone.<br>
     */
    DRONEDARONE("443195003",
                "http://snomed.info/sct",
                "Dronedarone (substance)",
                "Dronedarone",
                "Dronedaron",
                "dronédarone",
                "Dronedarone"),
    /**
     * EN: Droperidol.<br>
     * DE: Droperidol.<br>
     * FR: dropéridol.<br>
     * IT: Droperidolo.<br>
     */
    DROPERIDOL("387146001",
               "http://snomed.info/sct",
               "Droperidol (substance)",
               "Droperidol",
               "Droperidol",
               "dropéridol",
               "Droperidolo"),
    /**
     * EN: Drospirenone.<br>
     * DE: Drospirenon.<br>
     * FR: drospirénone.<br>
     * IT: Drospirenone.<br>
     */
    DROSPIRENONE("410919000",
                 "http://snomed.info/sct",
                 "Drospirenone (substance)",
                 "Drospirenone",
                 "Drospirenon",
                 "drospirénone",
                 "Drospirenone"),
    /**
     * EN: Dulaglutide.<br>
     * DE: Dulaglutid.<br>
     * FR: dulaglutide.<br>
     * IT: Dulaglutide.<br>
     */
    DULAGLUTIDE("714080005",
                "http://snomed.info/sct",
                "Dulaglutide (substance)",
                "Dulaglutide",
                "Dulaglutid",
                "dulaglutide",
                "Dulaglutide"),
    /**
     * EN: Duloxetine.<br>
     * DE: Duloxetin.<br>
     * FR: duloxétine.<br>
     * IT: Duloxetina.<br>
     */
    DULOXETINE("407032004",
               "http://snomed.info/sct",
               "Duloxetine (substance)",
               "Duloxetine",
               "Duloxetin",
               "duloxétine",
               "Duloxetina"),
    /**
     * EN: Dupilumab.<br>
     * DE: Dupilumab.<br>
     * FR: dupilumab.<br>
     * IT: Dupilumab.<br>
     */
    DUPILUMAB("733487000",
              "http://snomed.info/sct",
              "Dupilumab (substance)",
              "Dupilumab",
              "Dupilumab",
              "dupilumab",
              "Dupilumab"),
    /**
     * EN: Durvalumab.<br>
     * DE: Durvalumab.<br>
     * FR: durvalumab.<br>
     * IT: Durvalumab.<br>
     */
    DURVALUMAB("735230005",
               "http://snomed.info/sct",
               "Durvalumab (substance)",
               "Durvalumab",
               "Durvalumab",
               "durvalumab",
               "Durvalumab"),
    /**
     * EN: Dutasteride.<br>
     * DE: Dutasterid.<br>
     * FR: dutastéride.<br>
     * IT: Dutasteride.<br>
     */
    DUTASTERIDE("385572003",
                "http://snomed.info/sct",
                "Dutasteride (substance)",
                "Dutasteride",
                "Dutasterid",
                "dutastéride",
                "Dutasteride"),
    /**
     * EN: Dydrogesterone.<br>
     * DE: Dydrogesteron.<br>
     * FR: dydrogestérone.<br>
     * IT: Didrogesterone.<br>
     */
    DYDROGESTERONE("126093005",
                   "http://snomed.info/sct",
                   "Dydrogesterone (substance)",
                   "Dydrogesterone",
                   "Dydrogesteron",
                   "dydrogestérone",
                   "Didrogesterone"),
    /**
     * EN: D-alpha-tocopherol.<br>
     * DE: Tocopherol D-alpha (Vitamin E).<br>
     * FR: tocophérol D-alfa (Vitamine E).<br>
     * IT: D-alfa-tocoferolo (vitamina E).<br>
     */
    D_ALPHA_TOCOPHEROL("116776001",
                       "http://snomed.info/sct",
                       "D-alpha-tocopherol (substance)",
                       "D-alpha-tocopherol",
                       "Tocopherol D-alpha (Vitamin E)",
                       "tocophérol D-alfa (Vitamine E)",
                       "D-alfa-tocoferolo (vitamina E)"),
    /**
     * EN: Econazole.<br>
     * DE: Econazol.<br>
     * FR: éconazole.<br>
     * IT: Econazolo.<br>
     */
    ECONAZOLE("373471002",
              "http://snomed.info/sct",
              "Econazole (substance)",
              "Econazole",
              "Econazol",
              "éconazole",
              "Econazolo"),
    /**
     * EN: Eculizumab.<br>
     * DE: Eculizumab.<br>
     * FR: éculizumab.<br>
     * IT: Eculizumab.<br>
     */
    ECULIZUMAB("427429004",
               "http://snomed.info/sct",
               "Eculizumab (substance)",
               "Eculizumab",
               "Eculizumab",
               "éculizumab",
               "Eculizumab"),
    /**
     * EN: Edoxaban.<br>
     * DE: Edoxaban.<br>
     * FR: édoxaban.<br>
     * IT: Edoxaban.<br>
     */
    EDOXABAN("712778008",
             "http://snomed.info/sct",
             "Edoxaban (substance)",
             "Edoxaban",
             "Edoxaban",
             "édoxaban",
             "Edoxaban"),
    /**
     * EN: Efavirenz.<br>
     * DE: Efavirenz.<br>
     * FR: éfavirenz.<br>
     * IT: Efavirenz.<br>
     */
    EFAVIRENZ("387001004",
              "http://snomed.info/sct",
              "Efavirenz (substance)",
              "Efavirenz",
              "Efavirenz",
              "éfavirenz",
              "Efavirenz"),
    /**
     * EN: Eicosapentaenoic acid.<br>
     * DE: Eicosapentaensäure EPA.<br>
     * FR: acide eicosapentaénoïque EPA.<br>
     * IT: Acido eicosapentaenoico EPA.<br>
     */
    EICOSAPENTAENOIC_ACID("226367006",
                          "http://snomed.info/sct",
                          "Eicosapentaenoic acid (substance)",
                          "Eicosapentaenoic acid",
                          "Eicosapentaensäure EPA",
                          "acide eicosapentaénoïque EPA",
                          "Acido eicosapentaenoico EPA"),
    /**
     * EN: Eletriptan.<br>
     * DE: Eletriptan.<br>
     * FR: élétriptan.<br>
     * IT: Eletriptan.<br>
     */
    ELETRIPTAN("410843003",
               "http://snomed.info/sct",
               "Eletriptan (substance)",
               "Eletriptan",
               "Eletriptan",
               "élétriptan",
               "Eletriptan"),
    /**
     * EN: Elotuzumab.<br>
     * DE: Elotuzumab.<br>
     * FR: élotuzumab.<br>
     * IT: Elotuzumab.<br>
     */
    ELOTUZUMAB("715660001",
               "http://snomed.info/sct",
               "Elotuzumab (substance)",
               "Elotuzumab",
               "Elotuzumab",
               "élotuzumab",
               "Elotuzumab"),
    /**
     * EN: Eltrombopag.<br>
     * DE: Eltrombopag.<br>
     * FR: eltrombopag.<br>
     * IT: Eltrombopag.<br>
     */
    ELTROMBOPAG("432005001",
                "http://snomed.info/sct",
                "Eltrombopag (substance)",
                "Eltrombopag",
                "Eltrombopag",
                "eltrombopag",
                "Eltrombopag"),
    /**
     * EN: Elvitegravir.<br>
     * DE: Elvitegravir.<br>
     * FR: elvitégravir.<br>
     * IT: Elvitegravir.<br>
     */
    ELVITEGRAVIR("708828000",
                 "http://snomed.info/sct",
                 "Elvitegravir (substance)",
                 "Elvitegravir",
                 "Elvitegravir",
                 "elvitégravir",
                 "Elvitegravir"),
    /**
     * EN: Emedastine.<br>
     * DE: Emedastin.<br>
     * FR: émédastine.<br>
     * IT: Emedastina.<br>
     */
    EMEDASTINE("372551003",
               "http://snomed.info/sct",
               "Emedastine (substance)",
               "Emedastine",
               "Emedastin",
               "émédastine",
               "Emedastina"),
    /**
     * EN: Emicizumab.<br>
     * DE: Emicizumab.<br>
     * FR: emicizumab.<br>
     * IT: Emicizumab.<br>
     */
    EMICIZUMAB("763611007",
               "http://snomed.info/sct",
               "Emicizumab (substance)",
               "Emicizumab",
               "Emicizumab",
               "emicizumab",
               "Emicizumab"),
    /**
     * EN: Empagliflozin.<br>
     * DE: Empagliflozin.<br>
     * FR: empagliflozine.<br>
     * IT: Empagliflozin.<br>
     */
    EMPAGLIFLOZIN("703894008",
                  "http://snomed.info/sct",
                  "Empagliflozin (substance)",
                  "Empagliflozin",
                  "Empagliflozin",
                  "empagliflozine",
                  "Empagliflozin"),
    /**
     * EN: Emtricitabine.<br>
     * DE: Emtricitabin.<br>
     * FR: emtricitabine.<br>
     * IT: Emtricitabina.<br>
     */
    EMTRICITABINE("404856006",
                  "http://snomed.info/sct",
                  "Emtricitabine (substance)",
                  "Emtricitabine",
                  "Emtricitabin",
                  "emtricitabine",
                  "Emtricitabina"),
    /**
     * EN: Enalapril.<br>
     * DE: Enalapril.<br>
     * FR: énalapril.<br>
     * IT: Enalapril.<br>
     */
    ENALAPRIL("372658000",
              "http://snomed.info/sct",
              "Enalapril (substance)",
              "Enalapril",
              "Enalapril",
              "énalapril",
              "Enalapril"),
    /**
     * EN: Encorafenib.<br>
     * DE: Encorafenib.<br>
     * FR: encorafénib.<br>
     * IT: Encorafenib.<br>
     */
    ENCORAFENIB("772201002",
                "http://snomed.info/sct",
                "Encorafenib (substance)",
                "Encorafenib",
                "Encorafenib",
                "encorafénib",
                "Encorafenib"),
    /**
     * EN: Enoxaparin sodium.<br>
     * DE: Enoxaparin natrium.<br>
     * FR: énoxaparine sodique.<br>
     * IT: Enoxaparina sodica.<br>
     */
    ENOXAPARIN_SODIUM("108983001",
                      "http://snomed.info/sct",
                      "Enoxaparin sodium (substance)",
                      "Enoxaparin sodium",
                      "Enoxaparin natrium",
                      "énoxaparine sodique",
                      "Enoxaparina sodica"),
    /**
     * EN: Entacapone.<br>
     * DE: Entacapon.<br>
     * FR: entacapone.<br>
     * IT: Entacapone.<br>
     */
    ENTACAPONE("387018000",
               "http://snomed.info/sct",
               "Entacapone (substance)",
               "Entacapone",
               "Entacapon",
               "entacapone",
               "Entacapone"),
    /**
     * EN: Entecavir.<br>
     * DE: Entecavir.<br>
     * FR: entécavir.<br>
     * IT: Entacavir.<br>
     */
    ENTECAVIR("416644000",
              "http://snomed.info/sct",
              "Entecavir (substance)",
              "Entecavir",
              "Entecavir",
              "entécavir",
              "Entacavir"),
    /**
     * EN: Eosine.<br>
     * DE: Eosin.<br>
     * FR: éosine.<br>
     * IT: Eosina.<br>
     */
    EOSINE("256012001",
           "http://snomed.info/sct",
           "Eosine (substance)",
           "Eosine",
           "Eosin",
           "éosine",
           "Eosina"),
    /**
     * EN: Ephedrine.<br>
     * DE: Ephedrin.<br>
     * FR: éphédrine.<br>
     * IT: Efedrina.<br>
     */
    EPHEDRINE("387358007",
              "http://snomed.info/sct",
              "Ephedrine (substance)",
              "Ephedrine",
              "Ephedrin",
              "éphédrine",
              "Efedrina"),
    /**
     * EN: Ephedrine sulfate.<br>
     * DE: Ephedrin sulfat.<br>
     * FR: éphédrine sulfate.<br>
     * IT: Efedrina solfato.<br>
     */
    EPHEDRINE_SULFATE("76525000",
                      "http://snomed.info/sct",
                      "Ephedrine sulfate (substance)",
                      "Ephedrine sulfate",
                      "Ephedrin sulfat",
                      "éphédrine sulfate",
                      "Efedrina solfato"),
    /**
     * EN: Epinastine.<br>
     * DE: Epinastin.<br>
     * FR: épinastine.<br>
     * IT: Epinastine.<br>
     */
    EPINASTINE("407068009",
               "http://snomed.info/sct",
               "Epinastine (substance)",
               "Epinastine",
               "Epinastin",
               "épinastine",
               "Epinastine"),
    /**
     * EN: Epinephrine.<br>
     * DE: Adrenalin (Epinephrin).<br>
     * FR: adrénaline (épinéphrine).<br>
     * IT: Adrenalina (epinefrina).<br>
     */
    EPINEPHRINE("387362001",
                "http://snomed.info/sct",
                "Epinephrine (substance)",
                "Epinephrine",
                "Adrenalin (Epinephrin)",
                "adrénaline (épinéphrine)",
                "Adrenalina (epinefrina)"),
    /**
     * EN: Epirubicin.<br>
     * DE: Epirubicin.<br>
     * FR: épirubicine.<br>
     * IT: Epirubicina.<br>
     */
    EPIRUBICIN("417916005",
               "http://snomed.info/sct",
               "Epirubicin (substance)",
               "Epirubicin",
               "Epirubicin",
               "épirubicine",
               "Epirubicina"),
    /**
     * EN: Eplerenone.<br>
     * DE: Eplerenon.<br>
     * FR: éplérénone.<br>
     * IT: Eplerenone.<br>
     */
    EPLERENONE("407010008",
               "http://snomed.info/sct",
               "Eplerenone (substance)",
               "Eplerenone",
               "Eplerenon",
               "éplérénone",
               "Eplerenone"),
    /**
     * EN: Epoetin alfa.<br>
     * DE: Epoetin alfa rekombiniert.<br>
     * FR: époétine alfa recombinante.<br>
     * IT: Epoetina alfa ricombinante.<br>
     */
    EPOETIN_ALFA("386947003",
                 "http://snomed.info/sct",
                 "Epoetin alfa (substance)",
                 "Epoetin alfa",
                 "Epoetin alfa rekombiniert",
                 "époétine alfa recombinante",
                 "Epoetina alfa ricombinante"),
    /**
     * EN: Epoetin beta.<br>
     * DE: Epoetin beta rekombiniert.<br>
     * FR: époétine bêta recombinante.<br>
     * IT: Epoetina beta ricombinante.<br>
     */
    EPOETIN_BETA("396043004",
                 "http://snomed.info/sct",
                 "Epoetin beta (substance)",
                 "Epoetin beta",
                 "Epoetin beta rekombiniert",
                 "époétine bêta recombinante",
                 "Epoetina beta ricombinante"),
    /**
     * EN: Epoetin theta.<br>
     * DE: Epoetin theta.<br>
     * FR: époétine thêta.<br>
     * IT: Epoetina teta ricombinante.<br>
     */
    EPOETIN_THETA("708829008",
                  "http://snomed.info/sct",
                  "Epoetin theta (substance)",
                  "Epoetin theta",
                  "Epoetin theta",
                  "époétine thêta",
                  "Epoetina teta ricombinante"),
    /**
     * EN: Epoprostenol.<br>
     * DE: Epoprostenol.<br>
     * FR: époprosténol.<br>
     * IT: Epoprostenolo.<br>
     */
    EPOPROSTENOL("372513003",
                 "http://snomed.info/sct",
                 "Epoprostenol (substance)",
                 "Epoprostenol",
                 "Epoprostenol",
                 "époprosténol",
                 "Epoprostenolo"),
    /**
     * EN: Eprosartan.<br>
     * DE: Eprosartan.<br>
     * FR: éprosartan.<br>
     * IT: Eprosartan.<br>
     */
    EPROSARTAN("396044005",
               "http://snomed.info/sct",
               "Eprosartan (substance)",
               "Eprosartan",
               "Eprosartan",
               "éprosartan",
               "Eprosartan"),
    /**
     * EN: Eptacog alfa.<br>
     * DE: Eptacog alfa (aktiviert).<br>
     * FR: eptacogum alfa (activatum).<br>
     * IT: Eptacog alfa (attivato).<br>
     */
    EPTACOG_ALFA("116066006",
                 "http://snomed.info/sct",
                 "Eptacog alfa (substance)",
                 "Eptacog alfa",
                 "Eptacog alfa (aktiviert)",
                 "eptacogum alfa (activatum)",
                 "Eptacog alfa (attivato)"),
    /**
     * EN: Eptifibatide.<br>
     * DE: Eptifibatid.<br>
     * FR: eptifibatide.<br>
     * IT: Eptifibatide.<br>
     */
    EPTIFIBATIDE("386998009",
                 "http://snomed.info/sct",
                 "Eptifibatide (substance)",
                 "Eptifibatide",
                 "Eptifibatid",
                 "eptifibatide",
                 "Eptifibatide"),
    /**
     * EN: Erdosteine.<br>
     * DE: Erdostein.<br>
     * FR: erdostéine.<br>
     * IT: Erdosteina.<br>
     */
    ERDOSTEINE("426292005",
               "http://snomed.info/sct",
               "Erdosteine (substance)",
               "Erdosteine",
               "Erdostein",
               "erdostéine",
               "Erdosteina"),
    /**
     * EN: Erenumab.<br>
     * DE: Erenumab.<br>
     * FR: erénumab.<br>
     * IT: Erenumab.<br>
     */
    ERENUMAB("771590007",
             "http://snomed.info/sct",
             "Erenumab (substance)",
             "Erenumab",
             "Erenumab",
             "erénumab",
             "Erenumab"),
    /**
     * EN: Eribulin.<br>
     * DE: Eribulin.<br>
     * FR: éribuline.<br>
     * IT: Eribulina.<br>
     */
    ERIBULIN("708166000",
             "http://snomed.info/sct",
             "Eribulin (substance)",
             "Eribulin",
             "Eribulin",
             "éribuline",
             "Eribulina"),
    /**
     * EN: Erlotinib.<br>
     * DE: Erlotinib.<br>
     * FR: erlotinib.<br>
     * IT: Erlotinib.<br>
     */
    ERLOTINIB("414123001",
              "http://snomed.info/sct",
              "Erlotinib (substance)",
              "Erlotinib",
              "Erlotinib",
              "erlotinib",
              "Erlotinib"),
    /**
     * EN: Ertapenem.<br>
     * DE: Ertapenem.<br>
     * FR: ertapénem.<br>
     * IT: Ertapenem.<br>
     */
    ERTAPENEM("396346003",
              "http://snomed.info/sct",
              "Ertapenem (substance)",
              "Ertapenem",
              "Ertapenem",
              "ertapénem",
              "Ertapenem"),
    /**
     * EN: Ertugliflozin.<br>
     * DE: Ertugliflozin.<br>
     * FR: ertugliflozine.<br>
     * IT: Ertugliflozin.<br>
     */
    ERTUGLIFLOZIN("764274008",
                  "http://snomed.info/sct",
                  "Ertugliflozin (substance)",
                  "Ertugliflozin",
                  "Ertugliflozin",
                  "ertugliflozine",
                  "Ertugliflozin"),
    /**
     * EN: Erythromycin.<br>
     * DE: Erythromycin.<br>
     * FR: érythromycine.<br>
     * IT: Eritromicina.<br>
     */
    ERYTHROMYCIN("372694001",
                 "http://snomed.info/sct",
                 "Erythromycin (substance)",
                 "Erythromycin",
                 "Erythromycin",
                 "érythromycine",
                 "Eritromicina"),
    /**
     * EN: Escitalopram.<br>
     * DE: Escitalopram.<br>
     * FR: escitalopram.<br>
     * IT: Escitalopram.<br>
     */
    ESCITALOPRAM("400447003",
                 "http://snomed.info/sct",
                 "Escitalopram (substance)",
                 "Escitalopram",
                 "Escitalopram",
                 "escitalopram",
                 "Escitalopram"),
    /**
     * EN: Esmolol.<br>
     * DE: Esmolol.<br>
     * FR: esmolol.<br>
     * IT: Esmololo.<br>
     */
    ESMOLOL("372847006",
            "http://snomed.info/sct",
            "Esmolol (substance)",
            "Esmolol",
            "Esmolol",
            "esmolol",
            "Esmololo"),
    /**
     * EN: Esomeprazole.<br>
     * DE: Esomeprazol.<br>
     * FR: ésoméprazole.<br>
     * IT: Esomeprazolo.<br>
     */
    ESOMEPRAZOLE("396047003",
                 "http://snomed.info/sct",
                 "Esomeprazole (substance)",
                 "Esomeprazole",
                 "Esomeprazol",
                 "ésoméprazole",
                 "Esomeprazolo"),
    /**
     * EN: Estradiol.<br>
     * DE: Estradiol.<br>
     * FR: estradiol.<br>
     * IT: Estradiolo.<br>
     */
    ESTRADIOL("126172005",
              "http://snomed.info/sct",
              "Estradiol (substance)",
              "Estradiol",
              "Estradiol",
              "estradiol",
              "Estradiolo"),
    /**
     * EN: Estradiol hemihydrate.<br>
     * DE: Estradiol hemihydrat.<br>
     * FR: estradiol hémihydrate.<br>
     * IT: Estradiolo emiidrato.<br>
     */
    ESTRADIOL_HEMIHYDRATE("116070003",
                          "http://snomed.info/sct",
                          "Estradiol hemihydrate (substance)",
                          "Estradiol hemihydrate",
                          "Estradiol hemihydrat",
                          "estradiol hémihydrate",
                          "Estradiolo emiidrato"),
    /**
     * EN: Estradiol valerate.<br>
     * DE: Estradiol valerat.<br>
     * FR: estradiol valérate.<br>
     * IT: Estradiolo valerato.<br>
     */
    ESTRADIOL_VALERATE("96350008",
                       "http://snomed.info/sct",
                       "Estradiol valerate (substance)",
                       "Estradiol valerate",
                       "Estradiol valerat",
                       "estradiol valérate",
                       "Estradiolo valerato"),
    /**
     * EN: Estriol.<br>
     * DE: Estriol.<br>
     * FR: estriol.<br>
     * IT: Estriolo.<br>
     */
    ESTRIOL("73723004",
            "http://snomed.info/sct",
            "Estriol (substance)",
            "Estriol",
            "Estriol",
            "estriol",
            "Estriolo"),
    /**
     * EN: Etanercept.<br>
     * DE: Etanercept.<br>
     * FR: étanercept.<br>
     * IT: Etanercept.<br>
     */
    ETANERCEPT("387045004",
               "http://snomed.info/sct",
               "Etanercept (substance)",
               "Etanercept",
               "Etanercept",
               "étanercept",
               "Etanercept"),
    /**
     * EN: Etelcalcetide.<br>
     * DE: Etelcalcetid.<br>
     * FR: ételcalcétide.<br>
     * IT: Etelcalcetide.<br>
     */
    ETELCALCETIDE("723539000",
                  "http://snomed.info/sct",
                  "Etelcalcetide (substance)",
                  "Etelcalcetide",
                  "Etelcalcetid",
                  "ételcalcétide",
                  "Etelcalcetide"),
    /**
     * EN: Ethacridine.<br>
     * DE: Ethacridin.<br>
     * FR: éthacridine.<br>
     * IT: Etacridina.<br>
     */
    ETHACRIDINE("711320003",
                "http://snomed.info/sct",
                "Ethacridine (substance)",
                "Ethacridine",
                "Ethacridin",
                "éthacridine",
                "Etacridina"),
    /**
     * EN: Ethambutol.<br>
     * DE: Ethambutol.<br>
     * FR: éthambutol.<br>
     * IT: Etambutolo.<br>
     */
    ETHAMBUTOL("387129004",
               "http://snomed.info/sct",
               "Ethambutol (substance)",
               "Ethambutol",
               "Ethambutol",
               "éthambutol",
               "Etambutolo"),
    /**
     * EN: Ethinylestradiol.<br>
     * DE: Ethinylestradiol.<br>
     * FR: éthinylestradiol.<br>
     * IT: Etinilestradiolo.<br>
     */
    ETHINYLESTRADIOL("126097006",
                     "http://snomed.info/sct",
                     "Ethinylestradiol (substance)",
                     "Ethinylestradiol",
                     "Ethinylestradiol",
                     "éthinylestradiol",
                     "Etinilestradiolo"),
    /**
     * EN: Ethionamide.<br>
     * DE: Ethionamid.<br>
     * FR: ethionamide.<br>
     * IT: Etionamide.<br>
     */
    ETHIONAMIDE("32800009",
                "http://snomed.info/sct",
                "Ethionamide (substance)",
                "Ethionamide",
                "Ethionamid",
                "ethionamide",
                "Etionamide"),
    /**
     * EN: Ethosuximide.<br>
     * DE: Ethosuximid.<br>
     * FR: éthosuximide.<br>
     * IT: Etosuccimide.<br>
     */
    ETHOSUXIMIDE("387244008",
                 "http://snomed.info/sct",
                 "Ethosuximide (substance)",
                 "Ethosuximide",
                 "Ethosuximid",
                 "éthosuximide",
                 "Etosuccimide"),
    /**
     * EN: Ethyl chloride.<br>
     * DE: Chlorethan.<br>
     * FR: éthyle chlorure.<br>
     * IT: Cloruro di etile.<br>
     */
    ETHYL_CHLORIDE("22005007",
                   "http://snomed.info/sct",
                   "Ethyl chloride (substance)",
                   "Ethyl chloride",
                   "Chlorethan",
                   "éthyle chlorure",
                   "Cloruro di etile"),
    /**
     * EN: Etilefrine.<br>
     * DE: Etilefrin.<br>
     * FR: étiléfrine.<br>
     * IT: Etilefrina.<br>
     */
    ETILEFRINE("96255000",
               "http://snomed.info/sct",
               "Etilefrine (substance)",
               "Etilefrine",
               "Etilefrin",
               "étiléfrine",
               "Etilefrina"),
    /**
     * EN: Etodolac.<br>
     * DE: Etodolac.<br>
     * FR: étodolac.<br>
     * IT: Etodolac.<br>
     */
    ETODOLAC("386860005",
             "http://snomed.info/sct",
             "Etodolac (substance)",
             "Etodolac",
             "Etodolac",
             "étodolac",
             "Etodolac"),
    /**
     * EN: Etomidate.<br>
     * DE: Etomidat.<br>
     * FR: étomidate.<br>
     * IT: Etomidato.<br>
     */
    ETOMIDATE("387218008",
              "http://snomed.info/sct",
              "Etomidate (substance)",
              "Etomidate",
              "Etomidat",
              "étomidate",
              "Etomidato"),
    /**
     * EN: Etonogestrel.<br>
     * DE: Etonogestrel.<br>
     * FR: étonogestrel.<br>
     * IT: Etonogestrel.<br>
     */
    ETONOGESTREL("396050000",
                 "http://snomed.info/sct",
                 "Etonogestrel (substance)",
                 "Etonogestrel",
                 "Etonogestrel",
                 "étonogestrel",
                 "Etonogestrel"),
    /**
     * EN: Etoposide.<br>
     * DE: Etoposid.<br>
     * FR: étoposide.<br>
     * IT: Etoposide.<br>
     */
    ETOPOSIDE("387316009",
              "http://snomed.info/sct",
              "Etoposide (substance)",
              "Etoposide",
              "Etoposid",
              "étoposide",
              "Etoposide"),
    /**
     * EN: Etoricoxib.<br>
     * DE: Etoricoxib.<br>
     * FR: étoricoxib.<br>
     * IT: Etoricoxib.<br>
     */
    ETORICOXIB("409134009",
               "http://snomed.info/sct",
               "Etoricoxib (substance)",
               "Etoricoxib",
               "Etoricoxib",
               "étoricoxib",
               "Etoricoxib"),
    /**
     * EN: Etravirine.<br>
     * DE: Etravirin.<br>
     * FR: étravirine.<br>
     * IT: Etravirina.<br>
     */
    ETRAVIRINE("432121008",
               "http://snomed.info/sct",
               "Etravirine (substance)",
               "Etravirine",
               "Etravirin",
               "étravirine",
               "Etravirina"),
    /**
     * EN: Everolimus.<br>
     * DE: Everolimus.<br>
     * FR: évérolimus.<br>
     * IT: Everolimus.<br>
     */
    EVEROLIMUS("428698007",
               "http://snomed.info/sct",
               "Everolimus (substance)",
               "Everolimus",
               "Everolimus",
               "évérolimus",
               "Everolimus"),
    /**
     * EN: Exemestane.<br>
     * DE: Exemestan.<br>
     * FR: exémestane.<br>
     * IT: Exemestane.<br>
     */
    EXEMESTANE("387017005",
               "http://snomed.info/sct",
               "Exemestane (substance)",
               "Exemestane",
               "Exemestan",
               "exémestane",
               "Exemestane"),
    /**
     * EN: Exenatide.<br>
     * DE: Exenatid.<br>
     * FR: exénatide.<br>
     * IT: Exenatide.<br>
     */
    EXENATIDE("416859008",
              "http://snomed.info/sct",
              "Exenatide (substance)",
              "Exenatide",
              "Exenatid",
              "exénatide",
              "Exenatide"),
    /**
     * EN: Ezetimibe.<br>
     * DE: Ezetimib.<br>
     * FR: ézétimibe.<br>
     * IT: Ezetimibe.<br>
     */
    EZETIMIBE("409149001",
              "http://snomed.info/sct",
              "Ezetimibe (substance)",
              "Ezetimibe",
              "Ezetimib",
              "ézétimibe",
              "Ezetimibe"),
    /**
     * EN: Factor VIII.<br>
     * DE: Blutgerinnungsfaktor VIII human.<br>
     * FR: facteur VIII de coagulation humain.<br>
     * IT: Fattore VIII di coagulazione umano.<br>
     */
    FACTOR_VIII("278910002",
                "http://snomed.info/sct",
                "Factor VIII (substance)",
                "Factor VIII",
                "Blutgerinnungsfaktor VIII human",
                "facteur VIII de coagulation humain",
                "Fattore VIII di coagulazione umano"),
    /**
     * EN: Famciclovir.<br>
     * DE: Famciclovir.<br>
     * FR: famciclovir.<br>
     * IT: Famciclovir.<br>
     */
    FAMCICLOVIR("387557001",
                "http://snomed.info/sct",
                "Famciclovir (substance)",
                "Famciclovir",
                "Famciclovir",
                "famciclovir",
                "Famciclovir"),
    /**
     * EN: Febuxostat.<br>
     * DE: Febuxostat.<br>
     * FR: fébuxostat.<br>
     * IT: Febuxostat.<br>
     */
    FEBUXOSTAT("441743008",
               "http://snomed.info/sct",
               "Febuxostat (substance)",
               "Febuxostat",
               "Febuxostat",
               "fébuxostat",
               "Febuxostat"),
    /**
     * EN: Felbamate.<br>
     * DE: Felbamat.<br>
     * FR: felbamate.<br>
     * IT: Felbamato.<br>
     */
    FELBAMATE("96194006",
              "http://snomed.info/sct",
              "Felbamate (substance)",
              "Felbamate",
              "Felbamat",
              "felbamate",
              "Felbamato"),
    /**
     * EN: Felodipine.<br>
     * DE: Felodipin.<br>
     * FR: félodipine.<br>
     * IT: Felodipina.<br>
     */
    FELODIPINE("386863007",
               "http://snomed.info/sct",
               "Felodipine (substance)",
               "Felodipine",
               "Felodipin",
               "félodipine",
               "Felodipina"),
    /**
     * EN: Fenofibrate.<br>
     * DE: Fenofibrat.<br>
     * FR: fénofibrate.<br>
     * IT: Fenofibrato.<br>
     */
    FENOFIBRATE("386879008",
                "http://snomed.info/sct",
                "Fenofibrate (substance)",
                "Fenofibrate",
                "Fenofibrat",
                "fénofibrate",
                "Fenofibrato"),
    /**
     * EN: Fenoterol.<br>
     * DE: Fenoterol.<br>
     * FR: fénotérol.<br>
     * IT: Fenoterolo.<br>
     */
    FENOTEROL("395976006",
              "http://snomed.info/sct",
              "Fenoterol (substance)",
              "Fenoterol",
              "Fenoterol",
              "fénotérol",
              "Fenoterolo"),
    /**
     * EN: Fentanyl.<br>
     * DE: Fentanyl.<br>
     * FR: fentanyl.<br>
     * IT: Fentanil.<br>
     */
    FENTANYL("373492002",
             "http://snomed.info/sct",
             "Fentanyl (substance)",
             "Fentanyl",
             "Fentanyl",
             "fentanyl",
             "Fentanil"),
    /**
     * EN: Ferric hexacyanoferrate-II.<br>
     * DE: Eisen(III)-hexacyanoferrat(II).<br>
     * FR: hexacyanoferrate II ferrique III.<br>
     * IT: Esacianoferrato (II) di ferro (III).<br>
     */
    FERRIC_HEXACYANOFERRATE_II("406452004",
                               "http://snomed.info/sct",
                               "Ferric hexacyanoferrate-II (substance)",
                               "Ferric hexacyanoferrate-II",
                               "Eisen(III)-hexacyanoferrat(II)",
                               "hexacyanoferrate II ferrique III",
                               "Esacianoferrato (II) di ferro (III)"),
    /**
     * EN: Ferrous fumarate.<br>
     * DE: Eisen(II) fumarat.<br>
     * FR: fer II fumarate.<br>
     * IT: Ferro (II) fumarato.<br>
     */
    FERROUS_FUMARATE("387289009",
                     "http://snomed.info/sct",
                     "Ferrous fumarate (substance)",
                     "Ferrous fumarate",
                     "Eisen(II) fumarat",
                     "fer II fumarate",
                     "Ferro (II) fumarato"),
    /**
     * EN: Ferrous sulfate.<br>
     * DE: Eisen(II)-sulfat.<br>
     * FR: fer sulfate.<br>
     * IT: Solfato ferroso.<br>
     */
    FERROUS_SULFATE("387402000",
                    "http://snomed.info/sct",
                    "Ferrous sulfate (substance)",
                    "Ferrous sulfate",
                    "Eisen(II)-sulfat",
                    "fer sulfate",
                    "Solfato ferroso"),
    /**
     * EN: Fesoterodine fumarate.<br>
     * DE: Fesoterodin fumarat.<br>
     * FR: fésotérodine fumarate.<br>
     * IT: Fesoterodine fumarato.<br>
     */
    FESOTERODINE_FUMARATE("441469003",
                          "http://snomed.info/sct",
                          "Fesoterodine fumarate (substance)",
                          "Fesoterodine fumarate",
                          "Fesoterodin fumarat",
                          "fésotérodine fumarate",
                          "Fesoterodine fumarato"),
    /**
     * EN: Fexofenadine.<br>
     * DE: Fexofenadin.<br>
     * FR: fexofénadine.<br>
     * IT: Fexofenadina.<br>
     */
    FEXOFENADINE("372522002",
                 "http://snomed.info/sct",
                 "Fexofenadine (substance)",
                 "Fexofenadine",
                 "Fexofenadin",
                 "fexofénadine",
                 "Fexofenadina"),
    /**
     * EN: Fidaxomicin.<br>
     * DE: Fidaxomicin.<br>
     * FR: fidaxomicine.<br>
     * IT: Fidaxomicina.<br>
     */
    FIDAXOMICIN("703664004",
                "http://snomed.info/sct",
                "Fidaxomicin (substance)",
                "Fidaxomicin",
                "Fidaxomicin",
                "fidaxomicine",
                "Fidaxomicina"),
    /**
     * EN: Filgrastim.<br>
     * DE: Filgrastim rekombiniert.<br>
     * FR: filgrastim recombinant.<br>
     * IT: Filgrastim.<br>
     */
    FILGRASTIM("386948008",
               "http://snomed.info/sct",
               "Filgrastim (substance)",
               "Filgrastim",
               "Filgrastim rekombiniert",
               "filgrastim recombinant",
               "Filgrastim"),
    /**
     * EN: Finasteride.<br>
     * DE: Finasterid.<br>
     * FR: finastéride.<br>
     * IT: Finasteride.<br>
     */
    FINASTERIDE("386963006",
                "http://snomed.info/sct",
                "Finasteride (substance)",
                "Finasteride",
                "Finasterid",
                "finastéride",
                "Finasteride"),
    /**
     * EN: Fingolimod.<br>
     * DE: Fingolimod.<br>
     * FR: fingolimod.<br>
     * IT: Fingolimod.<br>
     */
    FINGOLIMOD("449000008",
               "http://snomed.info/sct",
               "Fingolimod (substance)",
               "Fingolimod",
               "Fingolimod",
               "fingolimod",
               "Fingolimod"),
    /**
     * EN: Fish oil.<br>
     * DE: Fischkörperöl.<br>
     * FR: poisson huile.<br>
     * IT: Pesce olio.<br>
     */
    FISH_OIL("735341005",
             "http://snomed.info/sct",
             "Fish oil (substance)",
             "Fish oil",
             "Fischkörperöl",
             "poisson huile",
             "Pesce olio"),
    /**
     * EN: 5-aminolevulinic acid.<br>
     * DE: 5-Aminolevulinsäure.<br>
     * FR: acide 5-aminolévulinique.<br>
     * IT: Acido 5-aminolevulinico.<br>
     */
    FIVE_AMINOLEVULINIC_ACID("259496005",
                             "http://snomed.info/sct",
                             "5-aminolevulinic acid (substance)",
                             "5-aminolevulinic acid",
                             "5-Aminolevulinsäure",
                             "acide 5-aminolévulinique",
                             "Acido 5-aminolevulinico"),
    /**
     * EN: Flavoxate.<br>
     * DE: Flavoxat.<br>
     * FR: flavoxate.<br>
     * IT: Flavossato.<br>
     */
    FLAVOXATE("372768002",
              "http://snomed.info/sct",
              "Flavoxate (substance)",
              "Flavoxate",
              "Flavoxat",
              "flavoxate",
              "Flavossato"),
    /**
     * EN: Flecainide.<br>
     * DE: Flecainid.<br>
     * FR: flécaïnide.<br>
     * IT: Flecainide.<br>
     */
    FLECAINIDE("372751001",
               "http://snomed.info/sct",
               "Flecainide (substance)",
               "Flecainide",
               "Flecainid",
               "flécaïnide",
               "Flecainide"),
    /**
     * EN: Flucloxacillin.<br>
     * DE: Flucloxacillin.<br>
     * FR: flucloxacilline.<br>
     * IT: Flucloxacillina.<br>
     */
    FLUCLOXACILLIN("387544009",
                   "http://snomed.info/sct",
                   "Flucloxacillin (substance)",
                   "Flucloxacillin",
                   "Flucloxacillin",
                   "flucloxacilline",
                   "Flucloxacillina"),
    /**
     * EN: Fluconazole.<br>
     * DE: Fluconazol.<br>
     * FR: fluconazole.<br>
     * IT: Fluconazolo.<br>
     */
    FLUCONAZOLE("387174006",
                "http://snomed.info/sct",
                "Fluconazole (substance)",
                "Fluconazole",
                "Fluconazol",
                "fluconazole",
                "Fluconazolo"),
    /**
     * EN: Fludarabine.<br>
     * DE: Fludarabin.<br>
     * FR: fludarabine.<br>
     * IT: Fludarabina.<br>
     */
    FLUDARABINE("386907005",
                "http://snomed.info/sct",
                "Fludarabine (substance)",
                "Fludarabine",
                "Fludarabin",
                "fludarabine",
                "Fludarabina"),
    /**
     * EN: Fludrocortisone.<br>
     * DE: Fludrocortison.<br>
     * FR: fludrocortisone.<br>
     * IT: Fludrocortisone.<br>
     */
    FLUDROCORTISONE("116586002",
                    "http://snomed.info/sct",
                    "Fludrocortisone (substance)",
                    "Fludrocortisone",
                    "Fludrocortison",
                    "fludrocortisone",
                    "Fludrocortisone"),
    /**
     * EN: Flufenamic acid.<br>
     * DE: Flufenaminsäure.<br>
     * FR: acide flufénamique.<br>
     * IT: acido flufenamico.<br>
     */
    FLUFENAMIC_ACID("1156232002",
                    "http://snomed.info/sct",
                    "Flufenamic acid (substance)",
                    "Flufenamic acid",
                    "Flufenaminsäure",
                    "acide flufénamique",
                    "acido flufenamico"),
    /**
     * EN: Flumazenil.<br>
     * DE: Flumazenil.<br>
     * FR: flumazénil.<br>
     * IT: Flumazenil.<br>
     */
    FLUMAZENIL("387575000",
               "http://snomed.info/sct",
               "Flumazenil (substance)",
               "Flumazenil",
               "Flumazenil",
               "flumazénil",
               "Flumazenil"),
    /**
     * EN: Flumetasone.<br>
     * DE: Flumetason.<br>
     * FR: flumétasone.<br>
     * IT: Flumetasone.<br>
     */
    FLUMETASONE("116598007",
                "http://snomed.info/sct",
                "Flumetasone (substance)",
                "Flumetasone",
                "Flumetason",
                "flumétasone",
                "Flumetasone"),
    /**
     * EN: Flunarizine.<br>
     * DE: Flunarizin.<br>
     * FR: flunarizine.<br>
     * IT: Flunarizina.<br>
     */
    FLUNARIZINE("418221001",
                "http://snomed.info/sct",
                "Flunarizine (substance)",
                "Flunarizine",
                "Flunarizin",
                "flunarizine",
                "Flunarizina"),
    /**
     * EN: Flunitrazepam.<br>
     * DE: Flunitrazepam.<br>
     * FR: flunitrazépam.<br>
     * IT: Flunitrazepam.<br>
     */
    FLUNITRAZEPAM("387573007",
                  "http://snomed.info/sct",
                  "Flunitrazepam (substance)",
                  "Flunitrazepam",
                  "Flunitrazepam",
                  "flunitrazépam",
                  "Flunitrazepam"),
    /**
     * EN: Fluocinonide.<br>
     * DE: Fluocinonid.<br>
     * FR: fluocinonide.<br>
     * IT: Fluocinonide.<br>
     */
    FLUOCINONIDE("396060009",
                 "http://snomed.info/sct",
                 "Fluocinonide (substance)",
                 "Fluocinonide",
                 "Fluocinonid",
                 "fluocinonide",
                 "Fluocinonide"),
    /**
     * EN: Fluorometholone.<br>
     * DE: Fluorometholon.<br>
     * FR: fluorométholone.<br>
     * IT: Fluorometolone.<br>
     */
    FLUOROMETHOLONE("2925007",
                    "http://snomed.info/sct",
                    "Fluorometholone (substance)",
                    "Fluorometholone",
                    "Fluorometholon",
                    "fluorométholone",
                    "Fluorometolone"),
    /**
     * EN: Fluorouracil.<br>
     * DE: Fluorouracil.<br>
     * FR: fluorouracil.<br>
     * IT: Fluorouracile.<br>
     */
    FLUOROURACIL("387172005",
                 "http://snomed.info/sct",
                 "Fluorouracil (substance)",
                 "Fluorouracil",
                 "Fluorouracil",
                 "fluorouracil",
                 "Fluorouracile"),
    /**
     * EN: Fluoxetine.<br>
     * DE: Fluoxetin.<br>
     * FR: fluoxétine.<br>
     * IT: Fluoxetina.<br>
     */
    FLUOXETINE("372767007",
               "http://snomed.info/sct",
               "Fluoxetine (substance)",
               "Fluoxetine",
               "Fluoxetin",
               "fluoxétine",
               "Fluoxetina"),
    /**
     * EN: Flupentixol.<br>
     * DE: Flupentixol.<br>
     * FR: flupentixol.<br>
     * IT: Flupentixolo.<br>
     */
    FLUPENTIXOL("387567006",
                "http://snomed.info/sct",
                "Flupentixol (substance)",
                "Flupentixol",
                "Flupentixol",
                "flupentixol",
                "Flupentixolo"),
    /**
     * EN: Flupentixol decanoate.<br>
     * DE: Flupentixol decanoat.<br>
     * FR: flupentixol décanoate.<br>
     * IT: Flupentixolo decanoato.<br>
     */
    FLUPENTIXOL_DECANOATE("396062001",
                          "http://snomed.info/sct",
                          "Flupentixol decanoate (substance)",
                          "Flupentixol decanoate",
                          "Flupentixol decanoat",
                          "flupentixol décanoate",
                          "Flupentixolo decanoato"),
    /**
     * EN: Flurazepam.<br>
     * DE: Flurazepam.<br>
     * FR: flurazépam.<br>
     * IT: Flurazepam.<br>
     */
    FLURAZEPAM("387109000",
               "http://snomed.info/sct",
               "Flurazepam (substance)",
               "Flurazepam",
               "Flurazepam",
               "flurazépam",
               "Flurazepam"),
    /**
     * EN: Flurbiprofen.<br>
     * DE: Flurbiprofen.<br>
     * FR: flurbiprofène.<br>
     * IT: Flurbiprofene.<br>
     */
    FLURBIPROFEN("373506008",
                 "http://snomed.info/sct",
                 "Flurbiprofen (substance)",
                 "Flurbiprofen",
                 "Flurbiprofen",
                 "flurbiprofène",
                 "Flurbiprofene"),
    /**
     * EN: Fluticasone.<br>
     * DE: Fluticason.<br>
     * FR: fluticasone.<br>
     * IT: Fluticasone.<br>
     */
    FLUTICASONE("397192001",
                "http://snomed.info/sct",
                "Fluticasone (substance)",
                "Fluticasone",
                "Fluticason",
                "fluticasone",
                "Fluticasone"),
    /**
     * EN: Fluvastatin.<br>
     * DE: Fluvastatin.<br>
     * FR: fluvastatine.<br>
     * IT: Fluvastatina.<br>
     */
    FLUVASTATIN("387585004",
                "http://snomed.info/sct",
                "Fluvastatin (substance)",
                "Fluvastatin",
                "Fluvastatin",
                "fluvastatine",
                "Fluvastatina"),
    /**
     * EN: Fluvoxamine.<br>
     * DE: Fluvoxamin.<br>
     * FR: fluvoxamine.<br>
     * IT: Fluvoxamina.<br>
     */
    FLUVOXAMINE("372905008",
                "http://snomed.info/sct",
                "Fluvoxamine (substance)",
                "Fluvoxamine",
                "Fluvoxamin",
                "fluvoxamine",
                "Fluvoxamina"),
    /**
     * EN: Folic acid.<br>
     * DE: Folsäure.<br>
     * FR: acide folique.<br>
     * IT: Acido folico.<br>
     */
    FOLIC_ACID("63718003",
               "http://snomed.info/sct",
               "Folic acid (substance)",
               "Folic acid",
               "Folsäure",
               "acide folique",
               "Acido folico"),
    /**
     * EN: Folinic acid.<br>
     * DE: Folinsäure.<br>
     * FR: acide folinique.<br>
     * IT: Acido folinico.<br>
     */
    FOLINIC_ACID("396065004",
                 "http://snomed.info/sct",
                 "Folinic acid (substance)",
                 "Folinic acid",
                 "Folinsäure",
                 "acide folinique",
                 "Acido folinico"),
    /**
     * EN: Follitropin alfa.<br>
     * DE: Follitropin alfa.<br>
     * FR: follitropine alfa.<br>
     * IT: Follitropina alfa.<br>
     */
    FOLLITROPIN_ALFA("395862009",
                     "http://snomed.info/sct",
                     "Follitropin alfa (substance)",
                     "Follitropin alfa",
                     "Follitropin alfa",
                     "follitropine alfa",
                     "Follitropina alfa"),
    /**
     * EN: Follitropin beta.<br>
     * DE: Follitropin beta.<br>
     * FR: follitropine bêta.<br>
     * IT: Follitropina beta.<br>
     */
    FOLLITROPIN_BETA("103028007",
                     "http://snomed.info/sct",
                     "Follitropin beta (substance)",
                     "Follitropin beta",
                     "Follitropin beta",
                     "follitropine bêta",
                     "Follitropina beta"),
    /**
     * EN: Fomepizole.<br>
     * DE: Fomepizol.<br>
     * FR: fomépizole.<br>
     * IT: Fomepizolo.<br>
     */
    FOMEPIZOLE("386970006",
               "http://snomed.info/sct",
               "Fomepizole (substance)",
               "Fomepizole",
               "Fomepizol",
               "fomépizole",
               "Fomepizolo"),
    /**
     * EN: Fondaparinux sodium.<br>
     * DE: Fondaparinux natrium.<br>
     * FR: fondaparinux sodique.<br>
     * IT: Fondaparinux sodico.<br>
     */
    FONDAPARINUX_SODIUM("385517000",
                        "http://snomed.info/sct",
                        "Fondaparinux sodium (substance)",
                        "Fondaparinux sodium",
                        "Fondaparinux natrium",
                        "fondaparinux sodique",
                        "Fondaparinux sodico"),
    /**
     * EN: Formoterol.<br>
     * DE: Formoterol.<br>
     * FR: formotérol.<br>
     * IT: Formoterolo.<br>
     */
    FORMOTEROL("414289007",
               "http://snomed.info/sct",
               "Formoterol (substance)",
               "Formoterol",
               "Formoterol",
               "formotérol",
               "Formoterolo"),
    /**
     * EN: Fosamprenavir.<br>
     * DE: Fosamprenavir.<br>
     * FR: fosamprénavir.<br>
     * IT: Fosamprenavir.<br>
     */
    FOSAMPRENAVIR("407017006",
                  "http://snomed.info/sct",
                  "Fosamprenavir (substance)",
                  "Fosamprenavir",
                  "Fosamprenavir",
                  "fosamprénavir",
                  "Fosamprenavir"),
    /**
     * EN: Foscarnet.<br>
     * DE: Foscarnet.<br>
     * FR: foscarnet.<br>
     * IT: Foscarnet.<br>
     */
    FOSCARNET("372902006",
              "http://snomed.info/sct",
              "Foscarnet (substance)",
              "Foscarnet",
              "Foscarnet",
              "foscarnet",
              "Foscarnet"),
    /**
     * EN: Fosfomycin.<br>
     * DE: Fosfomycin.<br>
     * FR: fosfomycine.<br>
     * IT: Fosfomicina.<br>
     */
    FOSFOMYCIN("372534005",
               "http://snomed.info/sct",
               "Fosfomycin (substance)",
               "Fosfomycin",
               "Fosfomycin",
               "fosfomycine",
               "Fosfomicina"),
    /**
     * EN: Fosinopril.<br>
     * DE: Fosinopril.<br>
     * FR: fosinopril.<br>
     * IT: Fosinopril.<br>
     */
    FOSINOPRIL("372510000",
               "http://snomed.info/sct",
               "Fosinopril (substance)",
               "Fosinopril",
               "Fosinopril",
               "fosinopril",
               "Fosinopril"),
    /**
     * EN: Frovatriptan.<br>
     * DE: Frovatriptan.<br>
     * FR: frovatriptan.<br>
     * IT: Frovatriptan.<br>
     */
    FROVATRIPTAN("411990007",
                 "http://snomed.info/sct",
                 "Frovatriptan (substance)",
                 "Frovatriptan",
                 "Frovatriptan",
                 "frovatriptan",
                 "Frovatriptan"),
    /**
     * EN: Fruit bromelain.<br>
     * DE: Bromelain.<br>
     * FR: bromélaïnes.<br>
     * IT: Bromelina.<br>
     */
    FRUIT_BROMELAIN("130663004",
                    "http://snomed.info/sct",
                    "Fruit bromelain (substance)",
                    "Fruit bromelain",
                    "Bromelain",
                    "bromélaïnes",
                    "Bromelina"),
    /**
     * EN: Fulvestrant.<br>
     * DE: Fulvestrant.<br>
     * FR: fulvestrant.<br>
     * IT: Fulvestrant.<br>
     */
    FULVESTRANT("385519002",
                "http://snomed.info/sct",
                "Fulvestrant (substance)",
                "Fulvestrant",
                "Fulvestrant",
                "fulvestrant",
                "Fulvestrant"),
    /**
     * EN: Furosemide.<br>
     * DE: Furosemid.<br>
     * FR: furosémide.<br>
     * IT: Furosemide.<br>
     */
    FUROSEMIDE("387475002",
               "http://snomed.info/sct",
               "Furosemide (substance)",
               "Furosemide",
               "Furosemid",
               "furosémide",
               "Furosemide"),
    /**
     * EN: Fusidic acid.<br>
     * DE: Fusidinsäure.<br>
     * FR: acide fusidique.<br>
     * IT: Acido fusidico.<br>
     */
    FUSIDIC_ACID("387530003",
                 "http://snomed.info/sct",
                 "Fusidic acid (substance)",
                 "Fusidic acid",
                 "Fusidinsäure",
                 "acide fusidique",
                 "Acido fusidico"),
    /**
     * EN: Gabapentin.<br>
     * DE: Gabapentin.<br>
     * FR: gabapentine.<br>
     * IT: Gabapentin.<br>
     */
    GABAPENTIN("386845007",
               "http://snomed.info/sct",
               "Gabapentin (substance)",
               "Gabapentin",
               "Gabapentin",
               "gabapentine",
               "Gabapentin"),
    /**
     * EN: Gadobutrol.<br>
     * DE: Gadobutrol.<br>
     * FR: gadobutrol.<br>
     * IT: Gadobutrolo.<br>
     */
    GADOBUTROL("418351005",
               "http://snomed.info/sct",
               "Gadobutrol (substance)",
               "Gadobutrol",
               "Gadobutrol",
               "gadobutrol",
               "Gadobutrolo"),
    /**
     * EN: Gadoteric acid.<br>
     * DE: Gadotersäure.<br>
     * FR: acide gadotérique.<br>
     * IT: Acido gadoterico.<br>
     */
    GADOTERIC_ACID("710812003",
                   "http://snomed.info/sct",
                   "Gadoteric acid (substance)",
                   "Gadoteric acid",
                   "Gadotersäure",
                   "acide gadotérique",
                   "Acido gadoterico"),
    /**
     * EN: Galactose.<br>
     * DE: Galactose.<br>
     * FR: galactose.<br>
     * IT: Galattosio.<br>
     */
    GALACTOSE("38182007",
              "http://snomed.info/sct",
              "Galactose (substance)",
              "Galactose",
              "Galactose",
              "galactose",
              "Galattosio"),
    /**
     * EN: Galantamine.<br>
     * DE: Galantamin.<br>
     * FR: galantamine.<br>
     * IT: Galantamina.<br>
     */
    GALANTAMINE("395727007",
                "http://snomed.info/sct",
                "Galantamine (substance)",
                "Galantamine",
                "Galantamin",
                "galantamine",
                "Galantamina"),
    /**
     * EN: Ganciclovir.<br>
     * DE: Ganciclovir.<br>
     * FR: ganciclovir.<br>
     * IT: Ganciclovir.<br>
     */
    GANCICLOVIR("372848001",
                "http://snomed.info/sct",
                "Ganciclovir (substance)",
                "Ganciclovir",
                "Ganciclovir",
                "ganciclovir",
                "Ganciclovir"),
    /**
     * EN: Ganirelix.<br>
     * DE: Ganirelix.<br>
     * FR: ganirélix.<br>
     * IT: Ganirelix.<br>
     */
    GANIRELIX("395728002",
              "http://snomed.info/sct",
              "Ganirelix (substance)",
              "Ganirelix",
              "Ganirelix",
              "ganirélix",
              "Ganirelix"),
    /**
     * EN: Gemcitabine.<br>
     * DE: Gemcitabin.<br>
     * FR: gemcitabine.<br>
     * IT: Gemcitabina.<br>
     */
    GEMCITABINE("386920008",
                "http://snomed.info/sct",
                "Gemcitabine (substance)",
                "Gemcitabine",
                "Gemcitabin",
                "gemcitabine",
                "Gemcitabina"),
    /**
     * EN: Gemfibrozil.<br>
     * DE: Gemfibrozil.<br>
     * FR: gemfibrozil.<br>
     * IT: Gemfibrozil.<br>
     */
    GEMFIBROZIL("387189002",
                "http://snomed.info/sct",
                "Gemfibrozil (substance)",
                "Gemfibrozil",
                "Gemfibrozil",
                "gemfibrozil",
                "Gemfibrozil"),
    /**
     * EN: Gentamicin.<br>
     * DE: Gentamicin.<br>
     * FR: gentamicine.<br>
     * IT: Gentamicina.<br>
     */
    GENTAMICIN("387321007",
               "http://snomed.info/sct",
               "Gentamicin (substance)",
               "Gentamicin",
               "Gentamicin",
               "gentamicine",
               "Gentamicina"),
    /**
     * EN: Gestodene.<br>
     * DE: Gestoden.<br>
     * FR: gestodène.<br>
     * IT: Gestodene.<br>
     */
    GESTODENE("395945000",
              "http://snomed.info/sct",
              "Gestodene (substance)",
              "Gestodene",
              "Gestoden",
              "gestodène",
              "Gestodene"),
    /**
     * EN: Ginkgo biloba.<br>
     * DE: Ginkgo (Ginkgo biloba L.).<br>
     * FR: ginkgo (Ginkgo biloba L.).<br>
     * IT: Ginko (Ginko biloba L.).<br>
     */
    GINKGO_BILOBA("420733007",
                  "http://snomed.info/sct",
                  "Ginkgo biloba (substance)",
                  "Ginkgo biloba",
                  "Ginkgo (Ginkgo biloba L.)",
                  "ginkgo (Ginkgo biloba L.)",
                  "Ginko (Ginko biloba L.)"),
    /**
     * EN: Glatiramer.<br>
     * DE: Glatiramer.<br>
     * FR: glatiramère.<br>
     * IT: Glatiramer.<br>
     */
    GLATIRAMER("372535006",
               "http://snomed.info/sct",
               "Glatiramer (substance)",
               "Glatiramer",
               "Glatiramer",
               "glatiramère",
               "Glatiramer"),
    /**
     * EN: Glibenclamide.<br>
     * DE: Glibenclamid.<br>
     * FR: glibenclamide.<br>
     * IT: Glibenclamide.<br>
     */
    GLIBENCLAMIDE("384978002",
                  "http://snomed.info/sct",
                  "Glibenclamide (substance)",
                  "Glibenclamide",
                  "Glibenclamid",
                  "glibenclamide",
                  "Glibenclamide"),
    /**
     * EN: Gliclazide.<br>
     * DE: Gliclazid.<br>
     * FR: gliclazide.<br>
     * IT: Gliclazide.<br>
     */
    GLICLAZIDE("395731001",
               "http://snomed.info/sct",
               "Gliclazide (substance)",
               "Gliclazide",
               "Gliclazid",
               "gliclazide",
               "Gliclazide"),
    /**
     * EN: Glimepiride.<br>
     * DE: Glimepirid.<br>
     * FR: glimépiride.<br>
     * IT: Glimepiride.<br>
     */
    GLIMEPIRIDE("386966003",
                "http://snomed.info/sct",
                "Glimepiride (substance)",
                "Glimepiride",
                "Glimepirid",
                "glimépiride",
                "Glimepiride"),
    /**
     * EN: Glucagon.<br>
     * DE: Glucagon.<br>
     * FR: glucagon.<br>
     * IT: Glucagone.<br>
     */
    GLUCAGON("66603002",
             "http://snomed.info/sct",
             "Glucagon (substance)",
             "Glucagon",
             "Glucagon",
             "glucagon",
             "Glucagone"),
    /**
     * EN: Glucose.<br>
     * DE: Glucose.<br>
     * FR: glucose.<br>
     * IT: Glucosio.<br>
     */
    GLUCOSE("67079006",
            "http://snomed.info/sct",
            "Glucose (substance)",
            "Glucose",
            "Glucose",
            "glucose",
            "Glucosio"),
    /**
     * EN: Glyceryl trinitrate.<br>
     * DE: Nitroglycerin.<br>
     * FR: nitroglycérine.<br>
     * IT: Nitroglicerina.<br>
     */
    GLYCERYL_TRINITRATE("387404004",
                        "http://snomed.info/sct",
                        "Glyceryl trinitrate (substance)",
                        "Glyceryl trinitrate",
                        "Nitroglycerin",
                        "nitroglycérine",
                        "Nitroglicerina"),
    /**
     * EN: Glycine.<br>
     * DE: Glycin.<br>
     * FR: glycine.<br>
     * IT: Glicina.<br>
     */
    GLYCINE("15331006",
            "http://snomed.info/sct",
            "Glycine (substance)",
            "Glycine",
            "Glycin",
            "glycine",
            "Glicina"),
    /**
     * EN: Glycocholic acid.<br>
     * DE: Glycocholsäure.<br>
     * FR: acide glycocholique.<br>
     * IT: Acido glicocolico.<br>
     */
    GLYCOCHOLIC_ACID("96314001",
                     "http://snomed.info/sct",
                     "Glycocholic acid (substance)",
                     "Glycocholic acid",
                     "Glycocholsäure",
                     "acide glycocholique",
                     "Acido glicocolico"),
    /**
     * EN: Glycopyrronium.<br>
     * DE: Glycopyrronium-Kation.<br>
     * FR: glycopyrronium.<br>
     * IT: Glicopirronio.<br>
     */
    GLYCOPYRRONIUM("769097000",
                   "http://snomed.info/sct",
                   "Glycopyrronium (substance)",
                   "Glycopyrronium",
                   "Glycopyrronium-Kation",
                   "glycopyrronium",
                   "Glicopirronio"),
    /**
     * EN: Golimumab.<br>
     * DE: Golimumab.<br>
     * FR: golimumab.<br>
     * IT: Golimumab.<br>
     */
    GOLIMUMAB("442435002",
              "http://snomed.info/sct",
              "Golimumab (substance)",
              "Golimumab",
              "Golimumab",
              "golimumab",
              "Golimumab"),
    /**
     * EN: Gonadorelin.<br>
     * DE: Gonadorelin.<br>
     * FR: gonadoréline.<br>
     * IT: Gonadorelina.<br>
     */
    GONADORELIN("397197007",
                "http://snomed.info/sct",
                "Gonadorelin (substance)",
                "Gonadorelin",
                "Gonadorelin",
                "gonadoréline",
                "Gonadorelina"),
    /**
     * EN: Goserelin.<br>
     * DE: Goserelin.<br>
     * FR: goséréline.<br>
     * IT: Goserelin.<br>
     */
    GOSERELIN("108771008",
              "http://snomed.info/sct",
              "Goserelin (substance)",
              "Goserelin",
              "Goserelin",
              "goséréline",
              "Goserelin"),
    /**
     * EN: Gramicidin.<br>
     * DE: Gramicidin.<br>
     * FR: gramicidine.<br>
     * IT: Gramicidina.<br>
     */
    GRAMICIDIN("387524003",
               "http://snomed.info/sct",
               "Gramicidin (substance)",
               "Gramicidin",
               "Gramicidin",
               "gramicidine",
               "Gramicidina"),
    /**
     * EN: Granisetron.<br>
     * DE: Granisetron.<br>
     * FR: granisétron.<br>
     * IT: Granisetron.<br>
     */
    GRANISETRON("372489005",
                "http://snomed.info/sct",
                "Granisetron (substance)",
                "Granisetron",
                "Granisetron",
                "granisétron",
                "Granisetron"),
    /**
     * EN: Guaifenesin.<br>
     * DE: Guaifenesin.<br>
     * FR: guaïfénésine.<br>
     * IT: Guaifenesina.<br>
     */
    GUAIFENESIN("87174009",
                "http://snomed.info/sct",
                "Guaifenesin (substance)",
                "Guaifenesin",
                "Guaifenesin",
                "guaïfénésine",
                "Guaifenesina"),
    /**
     * EN: Guanfacine.<br>
     * DE: Guanfacin.<br>
     * FR: guanfacine.<br>
     * IT: Guanfacina.<br>
     */
    GUANFACINE("372507007",
               "http://snomed.info/sct",
               "Guanfacine (substance)",
               "Guanfacine",
               "Guanfacin",
               "guanfacine",
               "Guanfacina"),
    /**
     * EN: Halcinonide.<br>
     * DE: Halcinonid.<br>
     * FR: halcinonide.<br>
     * IT: Alcinonide.<br>
     */
    HALCINONIDE("395735005",
                "http://snomed.info/sct",
                "Halcinonide (substance)",
                "Halcinonide",
                "Halcinonid",
                "halcinonide",
                "Alcinonide"),
    /**
     * EN: Halometasone.<br>
     * DE: Halometason.<br>
     * FR: halométasone.<br>
     * IT: Alometasone.<br>
     */
    HALOMETASONE("704673003",
                 "http://snomed.info/sct",
                 "Halometasone (substance)",
                 "Halometasone",
                 "Halometason",
                 "halométasone",
                 "Alometasone"),
    /**
     * EN: Haloperidol.<br>
     * DE: Haloperidol.<br>
     * FR: halopéridol.<br>
     * IT: Aloperidolo.<br>
     */
    HALOPERIDOL("386837002",
                "http://snomed.info/sct",
                "Haloperidol (substance)",
                "Haloperidol",
                "Haloperidol",
                "halopéridol",
                "Aloperidolo"),
    /**
     * EN: Heparin.<br>
     * DE: Heparin.<br>
     * FR: héparine.<br>
     * IT: Eparina.<br>
     */
    HEPARIN("372877000",
            "http://snomed.info/sct",
            "Heparin (substance)",
            "Heparin",
            "Heparin",
            "héparine",
            "Eparina"),
    /**
     * EN: Hepatitis B antigen.<br>
     * DE: Hepatitis B Antigen.<br>
     * FR: hepatitis B antigène.<br>
     * IT: Epatite B antigene purificato.<br>
     */
    HEPATITIS_B_ANTIGEN("303233001",
                        "http://snomed.info/sct",
                        "Hepatitis B antigen (substance)",
                        "Hepatitis B antigen",
                        "Hepatitis B Antigen",
                        "hepatitis B antigène",
                        "Epatite B antigene purificato"),
    /**
     * EN: Hexamidine.<br>
     * DE: Hexamidin.<br>
     * FR: hexamidine.<br>
     * IT: Esamidina.<br>
     */
    HEXAMIDINE("703831002",
               "http://snomed.info/sct",
               "Hexamidine (substance)",
               "Hexamidine",
               "Hexamidin",
               "hexamidine",
               "Esamidina"),
    /**
     * EN: Hexetidine.<br>
     * DE: Hexetidin.<br>
     * FR: hexétidine.<br>
     * IT: Esetidina.<br>
     */
    HEXETIDINE("387132001",
               "http://snomed.info/sct",
               "Hexetidine (substance)",
               "Hexetidine",
               "Hexetidin",
               "hexétidine",
               "Esetidina"),
    /**
     * EN: Hexoprenaline.<br>
     * DE: Hexoprenalin.<br>
     * FR: hexoprénaline.<br>
     * IT: Esoprenalina.<br>
     */
    HEXOPRENALINE("704987001",
                  "http://snomed.info/sct",
                  "Hexoprenaline (substance)",
                  "Hexoprenaline",
                  "Hexoprenalin",
                  "hexoprénaline",
                  "Esoprenalina"),
    /**
     * EN: Histidine.<br>
     * DE: Histidin.<br>
     * FR: histidine.<br>
     * IT: Istidina.<br>
     */
    HISTIDINE("60260004",
              "http://snomed.info/sct",
              "Histidine (substance)",
              "Histidine",
              "Histidin",
              "histidine",
              "Istidina"),
    /**
     * EN: Human antithrombin III.<br>
     * DE: Antithrombin III human.<br>
     * FR: antithrombine III humaine.<br>
     * IT: Antitrombina III umana.<br>
     */
    HUMAN_ANTITHROMBIN_III("412564003",
                           "http://snomed.info/sct",
                           "Human antithrombin III (substance)",
                           "Human antithrombin III",
                           "Antithrombin III human",
                           "antithrombine III humaine",
                           "Antitrombina III umana"),
    /**
     * EN: Human anti-D immunoglobulin.<br>
     * DE: Anti-D-Immunglobulin vom Menschen.<br>
     * FR: immunoglobuline humaine anti-D.<br>
     * IT: Immunoglobulina umana anti-D.<br>
     */
    HUMAN_ANTI_D_IMMUNOGLOBULIN("769102002",
                                "http://snomed.info/sct",
                                "Human anti-D immunoglobulin (substance)",
                                "Human anti-D immunoglobulin",
                                "Anti-D-Immunglobulin vom Menschen",
                                "immunoglobuline humaine anti-D",
                                "Immunoglobulina umana anti-D"),
    /**
     * EN: Human chorionic gonadotropin.<br>
     * DE: Choriongonadotropin.<br>
     * FR: gonadotrophine chorionique.<br>
     * IT: Gonadotropina corionica umana (HCG).<br>
     */
    HUMAN_CHORIONIC_GONADOTROPIN("59433001",
                                 "http://snomed.info/sct",
                                 "Human chorionic gonadotropin (substance)",
                                 "Human chorionic gonadotropin",
                                 "Choriongonadotropin",
                                 "gonadotrophine chorionique",
                                 "Gonadotropina corionica umana (HCG)"),
    /**
     * EN: Human fibrinogen.<br>
     * DE: Fibrinogen (human).<br>
     * FR: fibrinogène humain.<br>
     * IT: Fibrinogeno umano.<br>
     */
    HUMAN_FIBRINOGEN("418326009",
                     "http://snomed.info/sct",
                     "Human fibrinogen (substance)",
                     "Human fibrinogen",
                     "Fibrinogen (human)",
                     "fibrinogène humain",
                     "Fibrinogeno umano"),
    /**
     * EN: Human immunoglobulin.<br>
     * DE: Immunglobulin vom Menschen.<br>
     * FR: immunoglobuline humaine.<br>
     * IT: Immunoglobulina umana.<br>
     */
    HUMAN_IMMUNOGLOBULIN("420084002",
                         "http://snomed.info/sct",
                         "Human immunoglobulin (substance)",
                         "Human immunoglobulin",
                         "Immunglobulin vom Menschen",
                         "immunoglobuline humaine",
                         "Immunoglobulina umana"),
    /**
     * EN: Human immunoglobulin G.<br>
     * DE: Immunglobulin G human (IgG).<br>
     * FR: iImmunoglobulinum gamma humanum (IgG).<br>
     * IT: Immunoglobulina G umana (IgG).<br>
     */
    HUMAN_IMMUNOGLOBULIN_G("722197004",
                           "http://snomed.info/sct",
                           "Human immunoglobulin G (substance)",
                           "Human immunoglobulin G",
                           "Immunglobulin G human (IgG)",
                           "iImmunoglobulinum gamma humanum (IgG)",
                           "Immunoglobulina G umana (IgG)"),
    /**
     * EN: Human insulin.<br>
     * DE: Insulin human.<br>
     * FR: insulines humaines.<br>
     * IT: Insulina umana.<br>
     */
    HUMAN_INSULIN("96367001",
                  "http://snomed.info/sct",
                  "Human insulin (substance)",
                  "Human insulin",
                  "Insulin human",
                  "insulines humaines",
                  "Insulina umana"),
    /**
     * EN: Human menopausal gonadotropin.<br>
     * DE: Menotropin.<br>
     * FR: ménotropine.<br>
     * IT: Menotropina.<br>
     */
    HUMAN_MENOPAUSAL_GONADOTROPIN("8203003",
                                  "http://snomed.info/sct",
                                  "Human menopausal gonadotropin (substance)",
                                  "Human menopausal gonadotropin",
                                  "Menotropin",
                                  "ménotropine",
                                  "Menotropina"),
    /**
     * EN: Hyaluronic acid.<br>
     * DE: Hyaluronsäure.<br>
     * FR: acide hyaluronique.<br>
     * IT: Acido ialuronico.<br>
     */
    HYALURONIC_ACID("38218009",
                    "http://snomed.info/sct",
                    "Hyaluronic acid (substance)",
                    "Hyaluronic acid",
                    "Hyaluronsäure",
                    "acide hyaluronique",
                    "Acido ialuronico"),
    /**
     * EN: Hydrochlorothiazide.<br>
     * DE: Hydrochlorothiazid.<br>
     * FR: hydrochlorothiazide.<br>
     * IT: Idrocloratiazide.<br>
     */
    HYDROCHLOROTHIAZIDE("387525002",
                        "http://snomed.info/sct",
                        "Hydrochlorothiazide (substance)",
                        "Hydrochlorothiazide",
                        "Hydrochlorothiazid",
                        "hydrochlorothiazide",
                        "Idrocloratiazide"),
    /**
     * EN: Hydrocodone.<br>
     * DE: Hydrocodon.<br>
     * FR: hydrocodone.<br>
     * IT: Idrocodone.<br>
     */
    HYDROCODONE("372671002",
                "http://snomed.info/sct",
                "Hydrocodone (substance)",
                "Hydrocodone",
                "Hydrocodon",
                "hydrocodone",
                "Idrocodone"),
    /**
     * EN: Hydrocortisone.<br>
     * DE: Hydrocortison.<br>
     * FR: hydrocortisone.<br>
     * IT: Idrocortisone.<br>
     */
    HYDROCORTISONE("396458002",
                   "http://snomed.info/sct",
                   "Hydrocortisone (substance)",
                   "Hydrocortisone",
                   "Hydrocortison",
                   "hydrocortisone",
                   "Idrocortisone"),
    /**
     * EN: Hydrocortisone acetate.<br>
     * DE: Hydrocortison acetat.<br>
     * FR: hydrocortisone acétate.<br>
     * IT: Idrocortisone acetato.<br>
     */
    HYDROCORTISONE_ACETATE("79380007",
                           "http://snomed.info/sct",
                           "Hydrocortisone acetate (substance)",
                           "Hydrocortisone acetate",
                           "Hydrocortison acetat",
                           "hydrocortisone acétate",
                           "Idrocortisone acetato"),
    /**
     * EN: Hydrogen peroxide.<br>
     * DE: Wasserstoffperoxid.<br>
     * FR: peroxyde d´hydrogène.<br>
     * IT: Idrogeno perossido.<br>
     */
    HYDROGEN_PEROXIDE("387171003",
                      "http://snomed.info/sct",
                      "Hydrogen peroxide (substance)",
                      "Hydrogen peroxide",
                      "Wasserstoffperoxid",
                      "peroxyde d´hydrogène",
                      "Idrogeno perossido"),
    /**
     * EN: Hydromorphone.<br>
     * DE: Hydromorphon.<br>
     * FR: hydromorphone.<br>
     * IT: Idromorfone.<br>
     */
    HYDROMORPHONE("44508008",
                  "http://snomed.info/sct",
                  "Hydromorphone (substance)",
                  "Hydromorphone",
                  "Hydromorphon",
                  "hydromorphone",
                  "Idromorfone"),
    /**
     * EN: Hydroquinone.<br>
     * DE: Hydrochinon.<br>
     * FR: hydroquinone.<br>
     * IT: Idrochinone.<br>
     */
    HYDROQUINONE("387422001",
                 "http://snomed.info/sct",
                 "Hydroquinone (substance)",
                 "Hydroquinone",
                 "Hydrochinon",
                 "hydroquinone",
                 "Idrochinone"),
    /**
     * EN: Hydrotalcite.<br>
     * DE: Hydrotalcit.<br>
     * FR: hydrotalcite.<br>
     * IT: Idrotalcite.<br>
     */
    HYDROTALCITE("395738007",
                 "http://snomed.info/sct",
                 "Hydrotalcite (substance)",
                 "Hydrotalcite",
                 "Hydrotalcit",
                 "hydrotalcite",
                 "Idrotalcite"),
    /**
     * EN: Hydroxocobalamin.<br>
     * DE: Hydroxocobalamin.<br>
     * FR: hydroxocobalamine.<br>
     * IT: Idrossocobalamina.<br>
     */
    HYDROXOCOBALAMIN("409258004",
                     "http://snomed.info/sct",
                     "Hydroxocobalamin (substance)",
                     "Hydroxocobalamin",
                     "Hydroxocobalamin",
                     "hydroxocobalamine",
                     "Idrossocobalamina"),
    /**
     * EN: Hydroxycarbamide.<br>
     * DE: Hydroxycarbamid.<br>
     * FR: hydroxycarbamide.<br>
     * IT: Idrossicarbamide.<br>
     */
    HYDROXYCARBAMIDE("387314007",
                     "http://snomed.info/sct",
                     "Hydroxycarbamide (substance)",
                     "Hydroxycarbamide",
                     "Hydroxycarbamid",
                     "hydroxycarbamide",
                     "Idrossicarbamide"),
    /**
     * EN: Hydroxychloroquine.<br>
     * DE: Hydroxychloroquin.<br>
     * FR: hydroxychloroquine.<br>
     * IT: Idrossiclorochina.<br>
     */
    HYDROXYCHLOROQUINE("373540008",
                       "http://snomed.info/sct",
                       "Hydroxychloroquine (substance)",
                       "Hydroxychloroquine",
                       "Hydroxychloroquin",
                       "hydroxychloroquine",
                       "Idrossiclorochina"),
    /**
     * EN: Hydroxyzine.<br>
     * DE: Hydroxyzin.<br>
     * FR: hydroxyzine.<br>
     * IT: Idrossizina.<br>
     */
    HYDROXYZINE("372856003",
                "http://snomed.info/sct",
                "Hydroxyzine (substance)",
                "Hydroxyzine",
                "Hydroxyzin",
                "hydroxyzine",
                "Idrossizina"),
    /**
     * EN: Hypericin.<br>
     * DE: Hypericin.<br>
     * FR: hypéricine.<br>
     * IT: Ipericina.<br>
     */
    HYPERICIN("123681008",
              "http://snomed.info/sct",
              "Hypericin (substance)",
              "Hypericin",
              "Hypericin",
              "hypéricine",
              "Ipericina"),
    /**
     * EN: Hypericum perforatum extract.<br>
     * DE: Johanniskraut (Hypericum perforatum L.).<br>
     * FR: millepertuis (Hypericum perforatum L.).<br>
     * IT: Iperico (Hypericum perforatum L.).<br>
     */
    HYPERICUM_PERFORATUM_EXTRACT("412515006",
                                 "http://snomed.info/sct",
                                 "Hypericum perforatum extract (substance)",
                                 "Hypericum perforatum extract",
                                 "Johanniskraut (Hypericum perforatum L.)",
                                 "millepertuis (Hypericum perforatum L.)",
                                 "Iperico (Hypericum perforatum L.)"),
    /**
     * EN: Ibandronic acid.<br>
     * DE: Ibandronsäure.<br>
     * FR: acide ibandronique (ibandronate).<br>
     * IT: Acido ibandronico.<br>
     */
    IBANDRONIC_ACID("420936009",
                    "http://snomed.info/sct",
                    "Ibandronic acid (substance)",
                    "Ibandronic acid",
                    "Ibandronsäure",
                    "acide ibandronique (ibandronate)",
                    "Acido ibandronico"),
    /**
     * EN: Ibuprofen.<br>
     * DE: Ibuprofen.<br>
     * FR: ibuprofène.<br>
     * IT: Ibuprofene.<br>
     */
    IBUPROFEN("387207008",
              "http://snomed.info/sct",
              "Ibuprofen (substance)",
              "Ibuprofen",
              "Ibuprofen",
              "ibuprofène",
              "Ibuprofene"),
    /**
     * EN: Ibuprofen lysine.<br>
     * DE: Ibuprofen lysin.<br>
     * FR: ibuprofène lysine.<br>
     * IT: Ibuprofene lisina.<br>
     */
    IBUPROFEN_LYSINE("425516000",
                     "http://snomed.info/sct",
                     "Ibuprofen lysine (substance)",
                     "Ibuprofen lysine",
                     "Ibuprofen lysin",
                     "ibuprofène lysine",
                     "Ibuprofene lisina"),
    /**
     * EN: Icatibant.<br>
     * DE: Icatibant.<br>
     * FR: icatibant.<br>
     * IT: Icatibant.<br>
     */
    ICATIBANT("703834005",
              "http://snomed.info/sct",
              "Icatibant (substance)",
              "Icatibant",
              "Icatibant",
              "icatibant",
              "Icatibant"),
    /**
     * EN: Idarubicin.<br>
     * DE: Idarubicin.<br>
     * FR: idarubicine.<br>
     * IT: Idarubicina.<br>
     */
    IDARUBICIN("372539000",
               "http://snomed.info/sct",
               "Idarubicin (substance)",
               "Idarubicin",
               "Idarubicin",
               "idarubicine",
               "Idarubicina"),
    /**
     * EN: Idarucizumab.<br>
     * DE: Idarucizumab.<br>
     * FR: idarucizumab.<br>
     * IT: Idarucizumab.<br>
     */
    IDARUCIZUMAB("716017002",
                 "http://snomed.info/sct",
                 "Idarucizumab (substance)",
                 "Idarucizumab",
                 "Idarucizumab",
                 "idarucizumab",
                 "Idarucizumab"),
    /**
     * EN: Idebenone.<br>
     * DE: Idebenon.<br>
     * FR: idébénone.<br>
     * IT: Idebenone.<br>
     */
    IDEBENONE("429666007",
              "http://snomed.info/sct",
              "Idebenone (substance)",
              "Idebenone",
              "Idebenon",
              "idébénone",
              "Idebenone"),
    /**
     * EN: Idelalisib.<br>
     * DE: Idelalisib.<br>
     * FR: idélalisib.<br>
     * IT: Idelalisib.<br>
     */
    IDELALISIB("710278000",
               "http://snomed.info/sct",
               "Idelalisib (substance)",
               "Idelalisib",
               "Idelalisib",
               "idélalisib",
               "Idelalisib"),
    /**
     * EN: Ifosfamide.<br>
     * DE: Ifosfamid.<br>
     * FR: ifosfamide.<br>
     * IT: Ifosfamide.<br>
     */
    IFOSFAMIDE("386904003",
               "http://snomed.info/sct",
               "Ifosfamide (substance)",
               "Ifosfamide",
               "Ifosfamid",
               "ifosfamide",
               "Ifosfamide"),
    /**
     * EN: Iloprost.<br>
     * DE: Iloprost.<br>
     * FR: iloprost.<br>
     * IT: Iloprost.<br>
     */
    ILOPROST("395740002",
             "http://snomed.info/sct",
             "Iloprost (substance)",
             "Iloprost",
             "Iloprost",
             "iloprost",
             "Iloprost"),
    /**
     * EN: Imatinib.<br>
     * DE: Imatinib.<br>
     * FR: imatinib.<br>
     * IT: Imatinib.<br>
     */
    IMATINIB("414460008",
             "http://snomed.info/sct",
             "Imatinib (substance)",
             "Imatinib",
             "Imatinib",
             "imatinib",
             "Imatinib"),
    /**
     * EN: Imiglucerase.<br>
     * DE: Imiglucerase.<br>
     * FR: imiglucérase.<br>
     * IT: Imiglucerasi.<br>
     */
    IMIGLUCERASE("386968002",
                 "http://snomed.info/sct",
                 "Imiglucerase (substance)",
                 "Imiglucerase",
                 "Imiglucerase",
                 "imiglucérase",
                 "Imiglucerasi"),
    /**
     * EN: Imipenem.<br>
     * DE: Imipenem.<br>
     * FR: imipénem.<br>
     * IT: Imipenem.<br>
     */
    IMIPENEM("46558003",
             "http://snomed.info/sct",
             "Imipenem (substance)",
             "Imipenem",
             "Imipenem",
             "imipénem",
             "Imipenem"),
    /**
     * EN: Imipramine.<br>
     * DE: Imipramin.<br>
     * FR: imipramine.<br>
     * IT: Imipramina.<br>
     */
    IMIPRAMINE("372718005",
               "http://snomed.info/sct",
               "Imipramine (substance)",
               "Imipramine",
               "Imipramin",
               "imipramine",
               "Imipramina"),
    /**
     * EN: Imiquimod.<br>
     * DE: Imiquimod.<br>
     * FR: imiquimod.<br>
     * IT: Imiquimod.<br>
     */
    IMIQUIMOD("386941002",
              "http://snomed.info/sct",
              "Imiquimod (substance)",
              "Imiquimod",
              "Imiquimod",
              "imiquimod",
              "Imiquimod"),
    /**
     * EN: Immunoglobulin A.<br>
     * DE: Immunglobulin A human (IgA).<br>
     * FR: immunglobulin A human (IgA).<br>
     * IT: Immunoglobulina A umana (IgA).<br>
     */
    IMMUNOGLOBULIN_A("46046006",
                     "http://snomed.info/sct",
                     "Immunoglobulin A (substance)",
                     "Immunoglobulin A",
                     "Immunglobulin A human (IgA)",
                     "immunglobulin A human (IgA)",
                     "Immunoglobulina A umana (IgA)"),
    /**
     * EN: Immunoglobulin M.<br>
     * DE: Immunglobulin M human (IgM).<br>
     * FR: immunoglobuline M humaine (IgM).<br>
     * IT: Immunoglobulina M umana (IgM).<br>
     */
    IMMUNOGLOBULIN_M("74889000",
                     "http://snomed.info/sct",
                     "Immunoglobulin M (substance)",
                     "Immunoglobulin M",
                     "Immunglobulin M human (IgM)",
                     "immunoglobuline M humaine (IgM)",
                     "Immunoglobulina M umana (IgM)"),
    /**
     * EN: Immunologic substance.<br>
     * DE: Immunologic substance.<br>
     * FR: substance immunologique.<br>
     * IT: Immunologic substance.<br>
     */
    IMMUNOLOGIC_SUBSTANCE("106181007",
                          "http://snomed.info/sct",
                          "Immunologic substance (substance)",
                          "Immunologic substance",
                          "Immunologic substance",
                          "substance immunologique",
                          "Immunologic substance"),
    /**
     * EN: Indacaterol.<br>
     * DE: Indacaterol.<br>
     * FR: indacatérol.<br>
     * IT: Indacaterol.<br>
     */
    INDACATEROL("702801003",
                "http://snomed.info/sct",
                "Indacaterol (substance)",
                "Indacaterol",
                "Indacaterol",
                "indacatérol",
                "Indacaterol"),
    /**
     * EN: Indapamide.<br>
     * DE: Indapamid.<br>
     * FR: indapamide.<br>
     * IT: Indapamide.<br>
     */
    INDAPAMIDE("387419003",
               "http://snomed.info/sct",
               "Indapamide (substance)",
               "Indapamide",
               "Indapamid",
               "indapamide",
               "Indapamide"),
    /**
     * EN: Indometacin.<br>
     * DE: Indometacin.<br>
     * FR: indométacine.<br>
     * IT: Indometacina.<br>
     */
    INDOMETACIN("373513008",
                "http://snomed.info/sct",
                "Indometacin (substance)",
                "Indometacin",
                "Indometacin",
                "indométacine",
                "Indometacina"),
    /**
     * EN: Infliximab.<br>
     * DE: Infliximab.<br>
     * FR: infliximab.<br>
     * IT: Infliximab.<br>
     */
    INFLIXIMAB("386891004",
               "http://snomed.info/sct",
               "Infliximab (substance)",
               "Infliximab",
               "Infliximab",
               "infliximab",
               "Infliximab"),
    /**
     * EN: Inositol.<br>
     * DE: Inositol.<br>
     * FR: inositol.<br>
     * IT: Inositolo.<br>
     */
    INOSITOL("72164009",
             "http://snomed.info/sct",
             "Inositol (substance)",
             "Inositol",
             "Inositol",
             "inositol",
             "Inositolo"),
    /**
     * EN: Insulin aspart.<br>
     * DE: Insulin aspart.<br>
     * FR: insuline asparte.<br>
     * IT: Insulina aspartat.<br>
     */
    INSULIN_ASPART("325072002",
                   "http://snomed.info/sct",
                   "Insulin aspart (substance)",
                   "Insulin aspart",
                   "Insulin aspart",
                   "insuline asparte",
                   "Insulina aspartat"),
    /**
     * EN: Insulin degludec.<br>
     * DE: Insulin degludec.<br>
     * FR: insuline dégludec.<br>
     * IT: Insulina degludec.<br>
     */
    INSULIN_DEGLUDEC("710281005",
                     "http://snomed.info/sct",
                     "Insulin degludec (substance)",
                     "Insulin degludec",
                     "Insulin degludec",
                     "insuline dégludec",
                     "Insulina degludec"),
    /**
     * EN: Insulin detemir.<br>
     * DE: Insulin detemir.<br>
     * FR: insuline détémir.<br>
     * IT: Insulina detemir.<br>
     */
    INSULIN_DETEMIR("414515005",
                    "http://snomed.info/sct",
                    "Insulin detemir (substance)",
                    "Insulin detemir",
                    "Insulin detemir",
                    "insuline détémir",
                    "Insulina detemir"),
    /**
     * EN: Insulin glargine.<br>
     * DE: Insulin glargin.<br>
     * FR: insuline glargine.<br>
     * IT: Insulina glargine.<br>
     */
    INSULIN_GLARGINE("411529005",
                     "http://snomed.info/sct",
                     "Insulin glargine (substance)",
                     "Insulin glargine",
                     "Insulin glargin",
                     "insuline glargine",
                     "Insulina glargine"),
    /**
     * EN: Insulin glulisine.<br>
     * DE: Insulin glulisin.<br>
     * FR: insuline glulisine.<br>
     * IT: Insulina glulisina.<br>
     */
    INSULIN_GLULISINE("411530000",
                      "http://snomed.info/sct",
                      "Insulin glulisine (substance)",
                      "Insulin glulisine",
                      "Insulin glulisin",
                      "insuline glulisine",
                      "Insulina glulisina"),
    /**
     * EN: Insulin lispro.<br>
     * DE: Insulin lispro.<br>
     * FR: insuline lispro.<br>
     * IT: Insulina lispro.<br>
     */
    INSULIN_LISPRO("412210000",
                   "http://snomed.info/sct",
                   "Insulin lispro (substance)",
                   "Insulin lispro",
                   "Insulin lispro",
                   "insuline lispro",
                   "Insulina lispro"),
    /**
     * EN: Interferon alfa-2a.<br>
     * DE: Interferon alfa-2a.<br>
     * FR: interféron alfa 2a.<br>
     * IT: Interferone alfa 2a.<br>
     */
    INTERFERON_ALFA_2A("386914007",
                       "http://snomed.info/sct",
                       "Interferon alfa-2a (substance)",
                       "Interferon alfa-2a",
                       "Interferon alfa-2a",
                       "interféron alfa 2a",
                       "Interferone alfa 2a"),
    /**
     * EN: Interferon alfa-2b.<br>
     * DE: Interferon alfa-2b.<br>
     * FR: interféron alfa 2b.<br>
     * IT: Interferone alfa 2b.<br>
     */
    INTERFERON_ALFA_2B("386915008",
                       "http://snomed.info/sct",
                       "Interferon alfa-2b (substance)",
                       "Interferon alfa-2b",
                       "Interferon alfa-2b",
                       "interféron alfa 2b",
                       "Interferone alfa 2b"),
    /**
     * EN: Interferon beta-1a.<br>
     * DE: Interferon beta-1a.<br>
     * FR: interféron bêta-1a.<br>
     * IT: Interferone beta 1a.<br>
     */
    INTERFERON_BETA_1A("386902004",
                       "http://snomed.info/sct",
                       "Interferon beta-1a (substance)",
                       "Interferon beta-1a",
                       "Interferon beta-1a",
                       "interféron bêta-1a",
                       "Interferone beta 1a"),
    /**
     * EN: Interferon beta-1b.<br>
     * DE: Interferon beta-1b.<br>
     * FR: interféron bêta 1b.<br>
     * IT: Interferone beta 1b.<br>
     */
    INTERFERON_BETA_1B("386903009",
                       "http://snomed.info/sct",
                       "Interferon beta-1b (substance)",
                       "Interferon beta-1b",
                       "Interferon beta-1b",
                       "interféron bêta 1b",
                       "Interferone beta 1b"),
    /**
     * EN: Interferon gamma-1b.<br>
     * DE: Interferon gamma-1b.<br>
     * FR: interféron gamma 1b.<br>
     * IT: Interferone gamma 1b.<br>
     */
    INTERFERON_GAMMA_1B("386901006",
                        "http://snomed.info/sct",
                        "Interferon gamma-1b (substance)",
                        "Interferon gamma-1b",
                        "Interferon gamma-1b",
                        "interféron gamma 1b",
                        "Interferone gamma 1b"),
    /**
     * EN: Inulin.<br>
     * DE: Inulin.<br>
     * FR: inuline.<br>
     * IT: Inulina.<br>
     */
    INULIN("32154009",
           "http://snomed.info/sct",
           "Inulin (substance)",
           "Inulin",
           "Inulin",
           "inuline",
           "Inulina"),
    /**
     * EN: Iodixanol.<br>
     * DE: Iodixanol.<br>
     * FR: iodixanol.<br>
     * IT: Iodixanolo.<br>
     */
    IODIXANOL("395750001",
              "http://snomed.info/sct",
              "Iodixanol (substance)",
              "Iodixanol",
              "Iodixanol",
              "iodixanol",
              "Iodixanolo"),
    /**
     * EN: Iohexol.<br>
     * DE: Iohexol.<br>
     * FR: iohexol.<br>
     * IT: Ioexolo.<br>
     */
    IOHEXOL("395751002",
            "http://snomed.info/sct",
            "Iohexol (substance)",
            "Iohexol",
            "Iohexol",
            "iohexol",
            "Ioexolo"),
    /**
     * EN: Iopamidol.<br>
     * DE: Iopamidol.<br>
     * FR: iopamidol.<br>
     * IT: Iopamidolo.<br>
     */
    IOPAMIDOL("395754005",
              "http://snomed.info/sct",
              "Iopamidol (substance)",
              "Iopamidol",
              "Iopamidol",
              "iopamidol",
              "Iopamidolo"),
    /**
     * EN: Iopromide.<br>
     * DE: Iopromid.<br>
     * FR: iopromide.<br>
     * IT: Iopromide.<br>
     */
    IOPROMIDE("395756007",
              "http://snomed.info/sct",
              "Iopromide (substance)",
              "Iopromide",
              "Iopromid",
              "iopromide",
              "Iopromide"),
    /**
     * EN: Ipilimumab.<br>
     * DE: Ipilimumab.<br>
     * FR: ipilimumab.<br>
     * IT: Ipilimumab.<br>
     */
    IPILIMUMAB("697995005",
               "http://snomed.info/sct",
               "Ipilimumab (substance)",
               "Ipilimumab",
               "Ipilimumab",
               "ipilimumab",
               "Ipilimumab"),
    /**
     * EN: Ipratropium.<br>
     * DE: Ipratropium.<br>
     * FR: ipratropium.<br>
     * IT: Ipratropio.<br>
     */
    IPRATROPIUM("372518007",
                "http://snomed.info/sct",
                "Ipratropium (substance)",
                "Ipratropium",
                "Ipratropium",
                "ipratropium",
                "Ipratropio"),
    /**
     * EN: Irbesartan.<br>
     * DE: Irbesartan.<br>
     * FR: irbésartan.<br>
     * IT: Irbesartan.<br>
     */
    IRBESARTAN("386877005",
               "http://snomed.info/sct",
               "Irbesartan (substance)",
               "Irbesartan",
               "Irbesartan",
               "irbésartan",
               "Irbesartan"),
    /**
     * EN: Irinotecan.<br>
     * DE: Irinotecan.<br>
     * FR: irinotécan.<br>
     * IT: Irinotecan.<br>
     */
    IRINOTECAN("372538008",
               "http://snomed.info/sct",
               "Irinotecan (substance)",
               "Irinotecan",
               "Irinotecan",
               "irinotécan",
               "Irinotecan"),
    /**
     * EN: Iron.<br>
     * DE: Eisen.<br>
     * FR: fer.<br>
     * IT: Ferro.<br>
     */
    IRON("3829006",
         "http://snomed.info/sct",
         "Iron (substance)",
         "Iron",
         "Eisen",
         "fer",
         "Ferro"),
    /**
     * EN: Iron polymaltose.<br>
     * DE: Eisen(III)-hydroxid-Polymaltose-Komplex.<br>
     * FR: fer hydroxyde polymalté.<br>
     * IT: Ferro (III) idrossido polimaltosato.<br>
     */
    IRON_POLYMALTOSE("708805001",
                     "http://snomed.info/sct",
                     "Iron polymaltose (substance)",
                     "Iron polymaltose",
                     "Eisen(III)-hydroxid-Polymaltose-Komplex",
                     "fer hydroxyde polymalté",
                     "Ferro (III) idrossido polimaltosato"),
    /**
     * EN: Isavuconazole.<br>
     * DE: Isavuconazol.<br>
     * FR: isavuconazole.<br>
     * IT: Isavuconazolo.<br>
     */
    ISAVUCONAZOLE("765386003",
                  "http://snomed.info/sct",
                  "Isavuconazole (substance)",
                  "Isavuconazole",
                  "Isavuconazol",
                  "isavuconazole",
                  "Isavuconazolo"),
    /**
     * EN: Isoconazole.<br>
     * DE: Isoconazol.<br>
     * FR: isoconazole.<br>
     * IT: Isoconazolo.<br>
     */
    ISOCONAZOLE("418371001",
                "http://snomed.info/sct",
                "Isoconazole (substance)",
                "Isoconazole",
                "Isoconazol",
                "isoconazole",
                "Isoconazolo"),
    /**
     * EN: Isoleucine.<br>
     * DE: Isoleucin.<br>
     * FR: isoleucine.<br>
     * IT: Isoleucina.<br>
     */
    ISOLEUCINE("14971004",
               "http://snomed.info/sct",
               "Isoleucine (substance)",
               "Isoleucine",
               "Isoleucin",
               "isoleucine",
               "Isoleucina"),
    /**
     * EN: Isoniazid.<br>
     * DE: Isoniazid.<br>
     * FR: isoniazide.<br>
     * IT: Isoniazide.<br>
     */
    ISONIAZID("387472004",
              "http://snomed.info/sct",
              "Isoniazid (substance)",
              "Isoniazid",
              "Isoniazid",
              "isoniazide",
              "Isoniazide"),
    /**
     * EN: Isoprenaline.<br>
     * DE: Isoprenalin.<br>
     * FR: isoprénaline.<br>
     * IT: Isoprenalina.<br>
     */
    ISOPRENALINE("372781009",
                 "http://snomed.info/sct",
                 "Isoprenaline (substance)",
                 "Isoprenaline",
                 "Isoprenalin",
                 "isoprénaline",
                 "Isoprenalina"),
    /**
     * EN: Isopropyl alcohol.<br>
     * DE: Isopropylalkohol.<br>
     * FR: isopropanol.<br>
     * IT: Alcol isopropilico.<br>
     */
    ISOPROPYL_ALCOHOL("259268001",
                      "http://snomed.info/sct",
                      "Isopropyl alcohol (substance)",
                      "Isopropyl alcohol",
                      "Isopropylalkohol",
                      "isopropanol",
                      "Alcol isopropilico"),
    /**
     * EN: Isosorbide dinitrate.<br>
     * DE: Isosorbid dinitrat.<br>
     * FR: isosorbide dinitrate.<br>
     * IT: Isosorbide dinitrato.<br>
     */
    ISOSORBIDE_DINITRATE("387332007",
                         "http://snomed.info/sct",
                         "Isosorbide dinitrate (substance)",
                         "Isosorbide dinitrate",
                         "Isosorbid dinitrat",
                         "isosorbide dinitrate",
                         "Isosorbide dinitrato"),
    /**
     * EN: Isotretinoin.<br>
     * DE: Isotretinoin.<br>
     * FR: isotrétinoïne.<br>
     * IT: Isotretinoina.<br>
     */
    ISOTRETINOIN("387208003",
                 "http://snomed.info/sct",
                 "Isotretinoin (substance)",
                 "Isotretinoin",
                 "Isotretinoin",
                 "isotrétinoïne",
                 "Isotretinoina"),
    /**
     * EN: Itraconazole.<br>
     * DE: Itraconazol.<br>
     * FR: itraconazole.<br>
     * IT: Itraconazolo.<br>
     */
    ITRACONAZOLE("387532006",
                 "http://snomed.info/sct",
                 "Itraconazole (substance)",
                 "Itraconazole",
                 "Itraconazol",
                 "itraconazole",
                 "Itraconazolo"),
    /**
     * EN: Ivabradine.<br>
     * DE: Ivabradin.<br>
     * FR: ivabradine.<br>
     * IT: Ivabradina.<br>
     */
    IVABRADINE("421228002",
               "http://snomed.info/sct",
               "Ivabradine (substance)",
               "Ivabradine",
               "Ivabradin",
               "ivabradine",
               "Ivabradina"),
    /**
     * EN: Ivacaftor.<br>
     * DE: Ivacaftor.<br>
     * FR: ivacaftor.<br>
     * IT: Ivacaftor.<br>
     */
    IVACAFTOR("703823007",
              "http://snomed.info/sct",
              "Ivacaftor (substance)",
              "Ivacaftor",
              "Ivacaftor",
              "ivacaftor",
              "Ivacaftor"),
    /**
     * EN: Ivermectin.<br>
     * DE: Ivermectin.<br>
     * FR: ivermectine.<br>
     * IT: Ivermectina.<br>
     */
    IVERMECTIN("387559003",
               "http://snomed.info/sct",
               "Ivermectin (substance)",
               "Ivermectin",
               "Ivermectin",
               "ivermectine",
               "Ivermectina"),
    /**
     * EN: Ixekizumab.<br>
     * DE: Ixekizumab.<br>
     * FR: ixékizumab.<br>
     * IT: Ixekizumab.<br>
     */
    IXEKIZUMAB("724037000",
               "http://snomed.info/sct",
               "Ixekizumab (substance)",
               "Ixekizumab",
               "Ixekizumab",
               "ixékizumab",
               "Ixekizumab"),
    /**
     * EN: Ketamine.<br>
     * DE: Ketamin.<br>
     * FR: kétamine.<br>
     * IT: Ketamina.<br>
     */
    KETAMINE("373464007",
             "http://snomed.info/sct",
             "Ketamine (substance)",
             "Ketamine",
             "Ketamin",
             "kétamine",
             "Ketamina"),
    /**
     * EN: Ketoconazole.<br>
     * DE: Ketoconazol.<br>
     * FR: kétoconazole.<br>
     * IT: Ketoconazolo.<br>
     */
    KETOCONAZOLE("387216007",
                 "http://snomed.info/sct",
                 "Ketoconazole (substance)",
                 "Ketoconazole",
                 "Ketoconazol",
                 "kétoconazole",
                 "Ketoconazolo"),
    /**
     * EN: Ketoprofen.<br>
     * DE: Ketoprofen.<br>
     * FR: kétoprofène.<br>
     * IT: Ketoprofene.<br>
     */
    KETOPROFEN("386832008",
               "http://snomed.info/sct",
               "Ketoprofen (substance)",
               "Ketoprofen",
               "Ketoprofen",
               "kétoprofène",
               "Ketoprofene"),
    /**
     * EN: Ketorolac.<br>
     * DE: Ketorolac.<br>
     * FR: kétorolac.<br>
     * IT: Ketorolac.<br>
     */
    KETOROLAC("372501008",
              "http://snomed.info/sct",
              "Ketorolac (substance)",
              "Ketorolac",
              "Ketorolac",
              "kétorolac",
              "Ketorolac"),
    /**
     * EN: Ketotifen.<br>
     * DE: Ketotifen.<br>
     * FR: kétotifène.<br>
     * IT: Ketotifene.<br>
     */
    KETOTIFEN("372642003",
              "http://snomed.info/sct",
              "Ketotifen (substance)",
              "Ketotifen",
              "Ketotifen",
              "kétotifène",
              "Ketotifene"),
    /**
     * EN: Labetalol.<br>
     * DE: Labetalol.<br>
     * FR: labétalol.<br>
     * IT: Labetalolo.<br>
     */
    LABETALOL("372750000",
              "http://snomed.info/sct",
              "Labetalol (substance)",
              "Labetalol",
              "Labetalol",
              "labétalol",
              "Labetalolo"),
    /**
     * EN: Lacosamide.<br>
     * DE: Lacosamid.<br>
     * FR: lacosamide.<br>
     * IT: Lacosamide.<br>
     */
    LACOSAMIDE("441647003",
               "http://snomed.info/sct",
               "Lacosamide (substance)",
               "Lacosamide",
               "Lacosamid",
               "lacosamide",
               "Lacosamide"),
    /**
     * EN: Lactitol.<br>
     * DE: Lactitol.<br>
     * FR: lactitol.<br>
     * IT: Lattilolo.<br>
     */
    LACTITOL("418929008",
             "http://snomed.info/sct",
             "Lactitol (substance)",
             "Lactitol",
             "Lactitol",
             "lactitol",
             "Lattilolo"),
    /**
     * EN: Lactose.<br>
     * DE: Lactose.<br>
     * FR: lactose.<br>
     * IT: Lattosio.<br>
     */
    LACTOSE("47703008",
            "http://snomed.info/sct",
            "Lactose (substance)",
            "Lactose",
            "Lactose",
            "lactose",
            "Lattosio"),
    /**
     * EN: Lactulose.<br>
     * DE: Lactulose.<br>
     * FR: lactulose.<br>
     * IT: Lattulosio.<br>
     */
    LACTULOSE("273945008",
              "http://snomed.info/sct",
              "Lactulose (substance)",
              "Lactulose",
              "Lactulose",
              "lactulose",
              "Lattulosio"),
    /**
     * EN: Lamivudine.<br>
     * DE: Lamivudin.<br>
     * FR: lamivudine.<br>
     * IT: Lamivudina.<br>
     */
    LAMIVUDINE("386897000",
               "http://snomed.info/sct",
               "Lamivudine (substance)",
               "Lamivudine",
               "Lamivudin",
               "lamivudine",
               "Lamivudina"),
    /**
     * EN: Lamotrigine.<br>
     * DE: Lamotrigin.<br>
     * FR: lamotrigine.<br>
     * IT: Lamotrigina.<br>
     */
    LAMOTRIGINE("387562000",
                "http://snomed.info/sct",
                "Lamotrigine (substance)",
                "Lamotrigine",
                "Lamotrigin",
                "lamotrigine",
                "Lamotrigina"),
    /**
     * EN: Lanreotide.<br>
     * DE: Lanreotid.<br>
     * FR: lanréotide.<br>
     * IT: Lanreotide.<br>
     */
    LANREOTIDE("395765000",
               "http://snomed.info/sct",
               "Lanreotide (substance)",
               "Lanreotide",
               "Lanreotid",
               "lanréotide",
               "Lanreotide"),
    /**
     * EN: Lansoprazole.<br>
     * DE: Lansoprazol.<br>
     * FR: lansoprazole.<br>
     * IT: Lansoprazolo.<br>
     */
    LANSOPRAZOLE("386888004",
                 "http://snomed.info/sct",
                 "Lansoprazole (substance)",
                 "Lansoprazole",
                 "Lansoprazol",
                 "lansoprazole",
                 "Lansoprazolo"),
    /**
     * EN: Lanthanum carbonate.<br>
     * DE: Lanthan(III) carbonat.<br>
     * FR: lanthane(III) carbonate.<br>
     * IT: Lantanio carbonato.<br>
     */
    LANTHANUM_CARBONATE("414571007",
                        "http://snomed.info/sct",
                        "Lanthanum carbonate (substance)",
                        "Lanthanum carbonate",
                        "Lanthan(III) carbonat",
                        "lanthane(III) carbonate",
                        "Lantanio carbonato"),
    /**
     * EN: Latanoprost.<br>
     * DE: Latanoprost.<br>
     * FR: latanoprost.<br>
     * IT: Latanoprost.<br>
     */
    LATANOPROST("386926002",
                "http://snomed.info/sct",
                "Latanoprost (substance)",
                "Latanoprost",
                "Latanoprost",
                "latanoprost",
                "Latanoprost"),
    /**
     * EN: Lauromacrogol 400.<br>
     * DE: Lauromacrogol 400.<br>
     * FR: lauromacrogol 400.<br>
     * IT: Lauromacrogol.<br>
     */
    LAUROMACROGOL_400("427905004",
                      "http://snomed.info/sct",
                      "Lauromacrogol 400 (substance)",
                      "Lauromacrogol 400",
                      "Lauromacrogol 400",
                      "lauromacrogol 400",
                      "Lauromacrogol"),
    /**
     * EN: Leflunomide.<br>
     * DE: Leflunomid.<br>
     * FR: léflunomide.<br>
     * IT: Leflunomide.<br>
     */
    LEFLUNOMIDE("386981009",
                "http://snomed.info/sct",
                "Leflunomide (substance)",
                "Leflunomide",
                "Leflunomid",
                "léflunomide",
                "Leflunomide"),
    /**
     * EN: Lenalidomide.<br>
     * DE: Lenalidomid.<br>
     * FR: lénalidomide.<br>
     * IT: Lenalidomide.<br>
     */
    LENALIDOMIDE("421471009",
                 "http://snomed.info/sct",
                 "Lenalidomide (substance)",
                 "Lenalidomide",
                 "Lenalidomid",
                 "lénalidomide",
                 "Lenalidomide"),
    /**
     * EN: Lenograstime.<br>
     * DE: Lenograstim.<br>
     * FR: lénograstim.<br>
     * IT: Lenograstim.<br>
     */
    LENOGRASTIME("395767008",
                 "http://snomed.info/sct",
                 "Lenograstime (substance)",
                 "Lenograstime",
                 "Lenograstim",
                 "lénograstim",
                 "Lenograstim"),
    /**
     * EN: Lercanidipine.<br>
     * DE: Lercanidipin.<br>
     * FR: lercanidipine.<br>
     * IT: Lercanidipina.<br>
     */
    LERCANIDIPINE("395986007",
                  "http://snomed.info/sct",
                  "Lercanidipine (substance)",
                  "Lercanidipine",
                  "Lercanidipin",
                  "lercanidipine",
                  "Lercanidipina"),
    /**
     * EN: Letrozole.<br>
     * DE: Letrozol.<br>
     * FR: létrozole.<br>
     * IT: Letrozolo.<br>
     */
    LETROZOLE("386911004",
              "http://snomed.info/sct",
              "Letrozole (substance)",
              "Letrozole",
              "Letrozol",
              "létrozole",
              "Letrozolo"),
    /**
     * EN: Leucine.<br>
     * DE: Leucin.<br>
     * FR: leucine.<br>
     * IT: Leucina.<br>
     */
    LEUCINE("83797003",
            "http://snomed.info/sct",
            "Leucine (substance)",
            "Leucine",
            "Leucin",
            "leucine",
            "Leucina"),
    /**
     * EN: Leuprorelin.<br>
     * DE: Leuprorelin.<br>
     * FR: leuproréline.<br>
     * IT: Leuprorelina.<br>
     */
    LEUPRORELIN("397198002",
                "http://snomed.info/sct",
                "Leuprorelin (substance)",
                "Leuprorelin",
                "Leuprorelin",
                "leuproréline",
                "Leuprorelina"),
    /**
     * EN: Levetiracetam.<br>
     * DE: Levetiracetam.<br>
     * FR: lévétiracétam.<br>
     * IT: Levetiracetam.<br>
     */
    LEVETIRACETAM("387000003",
                  "http://snomed.info/sct",
                  "Levetiracetam (substance)",
                  "Levetiracetam",
                  "Levetiracetam",
                  "lévétiracétam",
                  "Levetiracetam"),
    /**
     * EN: Levobupivacaine.<br>
     * DE: Levobupivacain.<br>
     * FR: lévobupivacaïne.<br>
     * IT: Levobupivacaina.<br>
     */
    LEVOBUPIVACAINE("387011006",
                    "http://snomed.info/sct",
                    "Levobupivacaine (substance)",
                    "Levobupivacaine",
                    "Levobupivacain",
                    "lévobupivacaïne",
                    "Levobupivacaina"),
    /**
     * EN: Levocabastine.<br>
     * DE: Levocabastin.<br>
     * FR: lévocabastine.<br>
     * IT: Levocabastina.<br>
     */
    LEVOCABASTINE("372554006",
                  "http://snomed.info/sct",
                  "Levocabastine (substance)",
                  "Levocabastine",
                  "Levocabastin",
                  "lévocabastine",
                  "Levocabastina"),
    /**
     * EN: Levocarnitine.<br>
     * DE: Levocarnitin.<br>
     * FR: lévocarnitine.<br>
     * IT: Levocarnitina.<br>
     */
    LEVOCARNITINE("372601001",
                  "http://snomed.info/sct",
                  "Levocarnitine (substance)",
                  "Levocarnitine",
                  "Levocarnitin",
                  "lévocarnitine",
                  "Levocarnitina"),
    /**
     * EN: Levocetirizine.<br>
     * DE: Levocetirizin.<br>
     * FR: lévocétirizine.<br>
     * IT: Levocetirizina.<br>
     */
    LEVOCETIRIZINE("421889003",
                   "http://snomed.info/sct",
                   "Levocetirizine (substance)",
                   "Levocetirizine",
                   "Levocetirizin",
                   "lévocétirizine",
                   "Levocetirizina"),
    /**
     * EN: Levodopa.<br>
     * DE: Levodopa.<br>
     * FR: lévodopa.<br>
     * IT: Levodopa.<br>
     */
    LEVODOPA("387086006",
             "http://snomed.info/sct",
             "Levodopa (substance)",
             "Levodopa",
             "Levodopa",
             "lévodopa",
             "Levodopa"),
    /**
     * EN: Levofloxacin.<br>
     * DE: Levofloxacin.<br>
     * FR: lévofloxacine.<br>
     * IT: Levofloxacina.<br>
     */
    LEVOFLOXACIN("387552007",
                 "http://snomed.info/sct",
                 "Levofloxacin (substance)",
                 "Levofloxacin",
                 "Levofloxacin",
                 "lévofloxacine",
                 "Levofloxacina"),
    /**
     * EN: Levomepromazine.<br>
     * DE: Levomepromazin.<br>
     * FR: lévomépromazine.<br>
     * IT: Levomepromazina.<br>
     */
    LEVOMEPROMAZINE("387509007",
                    "http://snomed.info/sct",
                    "Levomepromazine (substance)",
                    "Levomepromazine",
                    "Levomepromazin",
                    "lévomépromazine",
                    "Levomepromazina"),
    /**
     * EN: Levomethadone.<br>
     * DE: Levomethadon.<br>
     * FR: lévométhadone.<br>
     * IT: levomethadone.<br>
     */
    LEVOMETHADONE("1156227003",
                  "http://snomed.info/sct",
                  "Levomethadone (substance)",
                  "Levomethadone",
                  "Levomethadon",
                  "lévométhadone",
                  "levomethadone"),
    /**
     * EN: Levonorgestrel.<br>
     * DE: Levonorgestrel.<br>
     * FR: lévonorgestrel.<br>
     * IT: Levonorgestrel.<br>
     */
    LEVONORGESTREL("126109000",
                   "http://snomed.info/sct",
                   "Levonorgestrel (substance)",
                   "Levonorgestrel",
                   "Levonorgestrel",
                   "lévonorgestrel",
                   "Levonorgestrel"),
    /**
     * EN: Levosimendan.<br>
     * DE: Levosimendan.<br>
     * FR: lévosimendan.<br>
     * IT: Levosimendan.<br>
     */
    LEVOSIMENDAN("442795003",
                 "http://snomed.info/sct",
                 "Levosimendan (substance)",
                 "Levosimendan",
                 "Levosimendan",
                 "lévosimendan",
                 "Levosimendan"),
    /**
     * EN: Levothyroxine.<br>
     * DE: Levothyroxin.<br>
     * FR: lévothyroxine.<br>
     * IT: Levotiroxina.<br>
     */
    LEVOTHYROXINE("710809001",
                  "http://snomed.info/sct",
                  "Levothyroxine (substance)",
                  "Levothyroxine",
                  "Levothyroxin",
                  "lévothyroxine",
                  "Levotiroxina"),
    /**
     * EN: Lidocaine.<br>
     * DE: Lidocain.<br>
     * FR: lidocaïne.<br>
     * IT: Lidocaina.<br>
     */
    LIDOCAINE("387480006",
              "http://snomed.info/sct",
              "Lidocaine (substance)",
              "Lidocaine",
              "Lidocain",
              "lidocaïne",
              "Lidocaina"),
    /**
     * EN: Linagliptin.<br>
     * DE: Linagliptin.<br>
     * FR: linagliptine.<br>
     * IT: Linagliptin.<br>
     */
    LINAGLIPTIN("702798009",
                "http://snomed.info/sct",
                "Linagliptin (substance)",
                "Linagliptin",
                "Linagliptin",
                "linagliptine",
                "Linagliptin"),
    /**
     * EN: Linezolid.<br>
     * DE: Linezolid.<br>
     * FR: linézolide.<br>
     * IT: Linezolid.<br>
     */
    LINEZOLID("387056004",
              "http://snomed.info/sct",
              "Linezolid (substance)",
              "Linezolid",
              "Linezolid",
              "linézolide",
              "Linezolid"),
    /**
     * EN: Liothyronine.<br>
     * DE: Liothyronin.<br>
     * FR: liothyronine.<br>
     * IT: Liotironina.<br>
     */
    LIOTHYRONINE("61275002",
                 "http://snomed.info/sct",
                 "Liothyronine (substance)",
                 "Liothyronine",
                 "Liothyronin",
                 "liothyronine",
                 "Liotironina"),
    /**
     * EN: Liraglutide.<br>
     * DE: Liraglutid.<br>
     * FR: liraglutide.<br>
     * IT: Liraglutide.<br>
     */
    LIRAGLUTIDE("444828003",
                "http://snomed.info/sct",
                "Liraglutide (substance)",
                "Liraglutide",
                "Liraglutid",
                "liraglutide",
                "Liraglutide"),
    /**
     * EN: Lisdexamfetamine.<br>
     * DE: Lisdexamfetamin.<br>
     * FR: lisdexamfétamine.<br>
     * IT: Lisdexamfetamina.<br>
     */
    LISDEXAMFETAMINE("425597005",
                     "http://snomed.info/sct",
                     "Lisdexamfetamine (substance)",
                     "Lisdexamfetamine",
                     "Lisdexamfetamin",
                     "lisdexamfétamine",
                     "Lisdexamfetamina"),
    /**
     * EN: Lisinopril.<br>
     * DE: Lisinopril.<br>
     * FR: lisinopril.<br>
     * IT: Lisinopril.<br>
     */
    LISINOPRIL("386873009",
               "http://snomed.info/sct",
               "Lisinopril (substance)",
               "Lisinopril",
               "Lisinopril",
               "lisinopril",
               "Lisinopril"),
    /**
     * EN: Lithium acetate.<br>
     * DE: Lithium acetat.<br>
     * FR: lithium acétate.<br>
     * IT: Litio acetato.<br>
     */
    LITHIUM_ACETATE("111080000",
                    "http://snomed.info/sct",
                    "Lithium acetate (substance)",
                    "Lithium acetate",
                    "Lithium acetat",
                    "lithium acétate",
                    "Litio acetato"),
    /**
     * EN: Lithium carbonate.<br>
     * DE: Lithium carbonat.<br>
     * FR: lithium carbonate.<br>
     * IT: Litio carbonato.<br>
     */
    LITHIUM_CARBONATE("387095003",
                      "http://snomed.info/sct",
                      "Lithium carbonate (substance)",
                      "Lithium carbonate",
                      "Lithium carbonat",
                      "lithium carbonate",
                      "Litio carbonato"),
    /**
     * EN: Lithium sulfate.<br>
     * DE: Lithiumsulfat.<br>
     * FR: lithium sulfate.<br>
     * IT: Litio solfato.<br>
     */
    LITHIUM_SULFATE("708197001",
                    "http://snomed.info/sct",
                    "Lithium sulfate (substance)",
                    "Lithium sulfate",
                    "Lithiumsulfat",
                    "lithium sulfate",
                    "Litio solfato"),
    /**
     * EN: Lixisenatide.<br>
     * DE: Lixisenatid.<br>
     * FR: lixisénatide.<br>
     * IT: Lixisenatide.<br>
     */
    LIXISENATIDE("708808004",
                 "http://snomed.info/sct",
                 "Lixisenatide (substance)",
                 "Lixisenatide",
                 "Lixisenatid",
                 "lixisénatide",
                 "Lixisenatide"),
    /**
     * EN: Lomustine.<br>
     * DE: Lomustin.<br>
     * FR: lomustine.<br>
     * IT: Lomustina.<br>
     */
    LOMUSTINE("387227009",
              "http://snomed.info/sct",
              "Lomustine (substance)",
              "Lomustine",
              "Lomustin",
              "lomustine",
              "Lomustina"),
    /**
     * EN: Lonoctocog alfa.<br>
     * DE: Lonoctocog alfa.<br>
     * FR: lonoctocog alfa.<br>
     * IT: Lonoctocog alfa.<br>
     */
    LONOCTOCOG_ALFA("1012961000168107",
                    "http://snomed.info/sct",
                    "Lonoctocog alfa (substance)",
                    "Lonoctocog alfa",
                    "Lonoctocog alfa",
                    "lonoctocog alfa",
                    "Lonoctocog alfa"),
    /**
     * EN: Loperamide.<br>
     * DE: Loperamid.<br>
     * FR: lopéramide.<br>
     * IT: Loperamide.<br>
     */
    LOPERAMIDE("387040009",
               "http://snomed.info/sct",
               "Loperamide (substance)",
               "Loperamide",
               "Loperamid",
               "lopéramide",
               "Loperamide"),
    /**
     * EN: Lopinavir.<br>
     * DE: Lopinavir.<br>
     * FR: lopinavir.<br>
     * IT: Lopinavir.<br>
     */
    LOPINAVIR("387067003",
              "http://snomed.info/sct",
              "Lopinavir (substance)",
              "Lopinavir",
              "Lopinavir",
              "lopinavir",
              "Lopinavir"),
    /**
     * EN: Loratadine.<br>
     * DE: Loratadin.<br>
     * FR: loratadine.<br>
     * IT: Loratadina.<br>
     */
    LORATADINE("386884002",
               "http://snomed.info/sct",
               "Loratadine (substance)",
               "Loratadine",
               "Loratadin",
               "loratadine",
               "Loratadina"),
    /**
     * EN: Lorazepam.<br>
     * DE: Lorazepam.<br>
     * FR: lorazépam.<br>
     * IT: Lorazepam.<br>
     */
    LORAZEPAM("387106007",
              "http://snomed.info/sct",
              "Lorazepam (substance)",
              "Lorazepam",
              "Lorazepam",
              "lorazépam",
              "Lorazepam"),
    /**
     * EN: Lormetazepam.<br>
     * DE: Lormetazepam.<br>
     * FR: lormétazépam.<br>
     * IT: Lormetazepam.<br>
     */
    LORMETAZEPAM("387570005",
                 "http://snomed.info/sct",
                 "Lormetazepam (substance)",
                 "Lormetazepam",
                 "Lormetazepam",
                 "lormétazépam",
                 "Lormetazepam"),
    /**
     * EN: Losartan.<br>
     * DE: Losartan.<br>
     * FR: losartan.<br>
     * IT: Losartan.<br>
     */
    LOSARTAN("373567002",
             "http://snomed.info/sct",
             "Losartan (substance)",
             "Losartan",
             "Losartan",
             "losartan",
             "Losartan"),
    /**
     * EN: Lumefantrine.<br>
     * DE: Lumefantrin.<br>
     * FR: luméfantrine.<br>
     * IT: Lumefantrina.<br>
     */
    LUMEFANTRINE("420307001",
                 "http://snomed.info/sct",
                 "Lumefantrine (substance)",
                 "Lumefantrine",
                 "Lumefantrin",
                 "luméfantrine",
                 "Lumefantrina"),
    /**
     * EN: Lurasidone.<br>
     * DE: Lurasidon.<br>
     * FR: lurasidone.<br>
     * IT: Lurasidone.<br>
     */
    LURASIDONE("703115008",
               "http://snomed.info/sct",
               "Lurasidone (substance)",
               "Lurasidone",
               "Lurasidon",
               "lurasidone",
               "Lurasidone"),
    /**
     * EN: Lutropin alfa.<br>
     * DE: Lutropin alfa.<br>
     * FR: lutropine alfa.<br>
     * IT: Lutropina alfa.<br>
     */
    LUTROPIN_ALFA("415248001",
                  "http://snomed.info/sct",
                  "Lutropin alfa (substance)",
                  "Lutropin alfa",
                  "Lutropin alfa",
                  "lutropine alfa",
                  "Lutropina alfa"),
    /**
     * EN: Lysine.<br>
     * DE: Lysin.<br>
     * FR: lysine.<br>
     * IT: Lisina.<br>
     */
    LYSINE("75799006",
           "http://snomed.info/sct",
           "Lysine (substance)",
           "Lysine",
           "Lysin",
           "lysine",
           "Lisina"),
    /**
     * EN: Macitentan.<br>
     * DE: Macitentan.<br>
     * FR: macitentan.<br>
     * IT: Macitentan.<br>
     */
    MACITENTAN("710283008",
               "http://snomed.info/sct",
               "Macitentan (substance)",
               "Macitentan",
               "Macitentan",
               "macitentan",
               "Macitentan"),
    /**
     * EN: Macrogol.<br>
     * DE: Macrogol.<br>
     * FR: macrogol.<br>
     * IT: Macrogol.<br>
     */
    MACROGOL("8030004",
             "http://snomed.info/sct",
             "Macrogol (substance)",
             "Macrogol",
             "Macrogol",
             "macrogol",
             "Macrogol"),
    /**
     * EN: Macrogol 3350.<br>
     * DE: Macrogol 3350.<br>
     * FR: macrogol 3350.<br>
     * IT: Macrogol 3350.<br>
     */
    MACROGOL_3350("712566007",
                  "http://snomed.info/sct",
                  "Macrogol 3350 (substance)",
                  "Macrogol 3350",
                  "Macrogol 3350",
                  "macrogol 3350",
                  "Macrogol 3350"),
    /**
     * EN: Macrogol 4000.<br>
     * DE: Macrogol 4000.<br>
     * FR: macrogol 4000.<br>
     * IT: Macrogol 4000.<br>
     */
    MACROGOL_4000("712567003",
                  "http://snomed.info/sct",
                  "Macrogol 4000 (substance)",
                  "Macrogol 4000",
                  "Macrogol 4000",
                  "macrogol 4000",
                  "Macrogol 4000"),
    /**
     * EN: Magaldrate.<br>
     * DE: Magaldrat.<br>
     * FR: magaldrate.<br>
     * IT: Magaldrato.<br>
     */
    MAGALDRATE("387240004",
               "http://snomed.info/sct",
               "Magaldrate (substance)",
               "Magaldrate",
               "Magaldrat",
               "magaldrate",
               "Magaldrato"),
    /**
     * EN: Magnesium.<br>
     * DE: Magnesium.<br>
     * FR: magnésium.<br>
     * IT: Magnesio.<br>
     */
    MAGNESIUM("72717003",
              "http://snomed.info/sct",
              "Magnesium (substance)",
              "Magnesium",
              "Magnesium",
              "magnésium",
              "Magnesio"),
    /**
     * EN: Magnesium acetate tetrahydrate.<br>
     * DE: Magnesium diacetat-4-Wasser.<br>
     * FR: magnésium acétate tétrahydrique.<br>
     * IT: Magnesio acetato tetraidrato.<br>
     */
    MAGNESIUM_ACETATE_TETRAHYDRATE("723586001",
                                   "http://snomed.info/sct",
                                   "Magnesium acetate tetrahydrate (substance)",
                                   "Magnesium acetate tetrahydrate",
                                   "Magnesium diacetat-4-Wasser",
                                   "magnésium acétate tétrahydrique",
                                   "Magnesio acetato tetraidrato"),
    /**
     * EN: Magnesium carbonate.<br>
     * DE: Magnesium carbonat.<br>
     * FR: magnésium carbonate.<br>
     * IT: Magnesio carbonato.<br>
     */
    MAGNESIUM_CARBONATE("387401007",
                        "http://snomed.info/sct",
                        "Magnesium carbonate (substance)",
                        "Magnesium carbonate",
                        "Magnesium carbonat",
                        "magnésium carbonate",
                        "Magnesio carbonato"),
    /**
     * EN: Magnesium chloride.<br>
     * DE: Magnesiumchlorid.<br>
     * FR: magnésium chlorure.<br>
     * IT: Magnesio cloruro.<br>
     */
    MAGNESIUM_CHLORIDE("45733002",
                       "http://snomed.info/sct",
                       "Magnesium chloride (substance)",
                       "Magnesium chloride",
                       "Magnesiumchlorid",
                       "magnésium chlorure",
                       "Magnesio cloruro"),
    /**
     * EN: Magnesium gluconate.<br>
     * DE: Magnesium digluconat wasserfrei.<br>
     * FR: magnésium digluconate anhydre.<br>
     * IT: Magnesio gluconato.<br>
     */
    MAGNESIUM_GLUCONATE("116126005",
                        "http://snomed.info/sct",
                        "Magnesium gluconate (substance)",
                        "Magnesium gluconate",
                        "Magnesium digluconat wasserfrei",
                        "magnésium digluconate anhydre",
                        "Magnesio gluconato"),
    /**
     * EN: Magnesium hydroxide.<br>
     * DE: Magnesiumhydroxid.<br>
     * FR: magnésium hydroxyde.<br>
     * IT: Magnesio idrossido.<br>
     */
    MAGNESIUM_HYDROXIDE("387337001",
                        "http://snomed.info/sct",
                        "Magnesium hydroxide (substance)",
                        "Magnesium hydroxide",
                        "Magnesiumhydroxid",
                        "magnésium hydroxyde",
                        "Magnesio idrossido"),
    /**
     * EN: Magnesium sulfate.<br>
     * DE: Magnesiumsulfat.<br>
     * FR: magnésium sulfate.<br>
     * IT: Magnesio solfato.<br>
     */
    MAGNESIUM_SULFATE("387202002",
                      "http://snomed.info/sct",
                      "Magnesium sulfate (substance)",
                      "Magnesium sulfate",
                      "Magnesiumsulfat",
                      "magnésium sulfate",
                      "Magnesio solfato"),
    /**
     * EN: Mannitol.<br>
     * DE: Mannitol.<br>
     * FR: mannitol.<br>
     * IT: Mannitolo.<br>
     */
    MANNITOL("387168006",
             "http://snomed.info/sct",
             "Mannitol (substance)",
             "Mannitol",
             "Mannitol",
             "mannitol",
             "Mannitolo"),
    /**
     * EN: Maraviroc.<br>
     * DE: Maraviroc.<br>
     * FR: maraviroc.<br>
     * IT: Maraviroc.<br>
     */
    MARAVIROC("429603001",
              "http://snomed.info/sct",
              "Maraviroc (substance)",
              "Maraviroc",
              "Maraviroc",
              "maraviroc",
              "Maraviroc"),
    /**
     * EN: Mebendazole.<br>
     * DE: Mebendazol.<br>
     * FR: mébendazole.<br>
     * IT: Mebendazolo.<br>
     */
    MEBENDAZOLE("387311004",
                "http://snomed.info/sct",
                "Mebendazole (substance)",
                "Mebendazole",
                "Mebendazol",
                "mébendazole",
                "Mebendazolo"),
    /**
     * EN: Mebeverine.<br>
     * DE: Mebeverin.<br>
     * FR: mébévérine.<br>
     * IT: Mebeverina.<br>
     */
    MEBEVERINE("419830007",
               "http://snomed.info/sct",
               "Mebeverine (substance)",
               "Mebeverine",
               "Mebeverin",
               "mébévérine",
               "Mebeverina"),
    /**
     * EN: Meclozine.<br>
     * DE: Meclozin.<br>
     * FR: méclozine.<br>
     * IT: Meclozina.<br>
     */
    MECLOZINE("372879002",
              "http://snomed.info/sct",
              "Meclozine (substance)",
              "Meclozine",
              "Meclozin",
              "méclozine",
              "Meclozina"),
    /**
     * EN: Medium chain triglyceride.<br>
     * DE: Triglyceride mittelkettige.<br>
     * FR: triglycérides à chaîne moyenne.<br>
     * IT: Trigliceridi a catena media.<br>
     */
    MEDIUM_CHAIN_TRIGLYCERIDE("395781005",
                              "http://snomed.info/sct",
                              "Medium chain triglyceride (substance)",
                              "Medium chain triglyceride",
                              "Triglyceride mittelkettige",
                              "triglycérides à chaîne moyenne",
                              "Trigliceridi a catena media"),
    /**
     * EN: Medroxyprogesterone.<br>
     * DE: Medroxyprogesteron.<br>
     * FR: médroxyprogestérone.<br>
     * IT: Medrossiprogesterone acetato.<br>
     */
    MEDROXYPROGESTERONE("126113007",
                        "http://snomed.info/sct",
                        "Medroxyprogesterone (substance)",
                        "Medroxyprogesterone",
                        "Medroxyprogesteron",
                        "médroxyprogestérone",
                        "Medrossiprogesterone acetato"),
    /**
     * EN: Mefenamic acid.<br>
     * DE: Mefenaminsäure.<br>
     * FR: acide méfénamique.<br>
     * IT: Acido mefenamico.<br>
     */
    MEFENAMIC_ACID("387185008",
                   "http://snomed.info/sct",
                   "Mefenamic acid (substance)",
                   "Mefenamic acid",
                   "Mefenaminsäure",
                   "acide méfénamique",
                   "Acido mefenamico"),
    /**
     * EN: Mefloquine.<br>
     * DE: Mefloquin.<br>
     * FR: méfloquine.<br>
     * IT: Meflochina.<br>
     */
    MEFLOQUINE("387505001",
               "http://snomed.info/sct",
               "Mefloquine (substance)",
               "Mefloquine",
               "Mefloquin",
               "méfloquine",
               "Meflochina"),
    /**
     * EN: Meglumine.<br>
     * DE: Meglumin.<br>
     * FR: méglumine.<br>
     * IT: Meglumina.<br>
     */
    MEGLUMINE("769091004",
              "http://snomed.info/sct",
              "Meglumine (substance)",
              "Meglumine",
              "Meglumin",
              "méglumine",
              "Meglumina"),
    /**
     * EN: Melatonin.<br>
     * DE: Melatonin.<br>
     * FR: mélatonine.<br>
     * IT: Melatonina.<br>
     */
    MELATONIN("41199001",
              "http://snomed.info/sct",
              "Melatonin (substance)",
              "Melatonin",
              "Melatonin",
              "mélatonine",
              "Melatonina"),
    /**
     * EN: Melitracen.<br>
     * DE: Melitracen.<br>
     * FR: mélitracène.<br>
     * IT: Melitracene.<br>
     */
    MELITRACEN("712683007",
               "http://snomed.info/sct",
               "Melitracen (substance)",
               "Melitracen",
               "Melitracen",
               "mélitracène",
               "Melitracene"),
    /**
     * EN: Melperone.<br>
     * DE: Melperon.<br>
     * FR: melpérone.<br>
     * IT: Melperone.<br>
     */
    MELPERONE("442519006",
              "http://snomed.info/sct",
              "Melperone (substance)",
              "Melperone",
              "Melperon",
              "melpérone",
              "Melperone"),
    /**
     * EN: Melphalan.<br>
     * DE: Melphalan.<br>
     * FR: melphalan.<br>
     * IT: Melphalan.<br>
     */
    MELPHALAN("387297002",
              "http://snomed.info/sct",
              "Melphalan (substance)",
              "Melphalan",
              "Melphalan",
              "melphalan",
              "Melphalan"),
    /**
     * EN: Memantine.<br>
     * DE: Memantin.<br>
     * FR: mémantine.<br>
     * IT: Memantina.<br>
     */
    MEMANTINE("406458000",
              "http://snomed.info/sct",
              "Memantine (substance)",
              "Memantine",
              "Memantin",
              "mémantine",
              "Memantina"),
    /**
     * EN: Mepivacaine.<br>
     * DE: Mepivacain.<br>
     * FR: mépivacaïne.<br>
     * IT: Mepicacaina.<br>
     */
    MEPIVACAINE("59560006",
                "http://snomed.info/sct",
                "Mepivacaine (substance)",
                "Mepivacaine",
                "Mepivacain",
                "mépivacaïne",
                "Mepicacaina"),
    /**
     * EN: Mercaptamine.<br>
     * DE: Mercaptamin.<br>
     * FR: mercaptamine.<br>
     * IT: Mercaptamina.<br>
     */
    MERCAPTAMINE("373457005",
                 "http://snomed.info/sct",
                 "Mercaptamine (substance)",
                 "Mercaptamine",
                 "Mercaptamin",
                 "mercaptamine",
                 "Mercaptamina"),
    /**
     * EN: Meropenem.<br>
     * DE: Meropenem.<br>
     * FR: méropénem.<br>
     * IT: Meropenem.<br>
     */
    MEROPENEM("387540000",
              "http://snomed.info/sct",
              "Meropenem (substance)",
              "Meropenem",
              "Meropenem",
              "méropénem",
              "Meropenem"),
    /**
     * EN: Mesalazine.<br>
     * DE: Mesalazin.<br>
     * FR: mésalazine.<br>
     * IT: Mesalazina.<br>
     */
    MESALAZINE("387501005",
               "http://snomed.info/sct",
               "Mesalazine (substance)",
               "Mesalazine",
               "Mesalazin",
               "mésalazine",
               "Mesalazina"),
    /**
     * EN: Mesna.<br>
     * DE: Mesna.<br>
     * FR: mesna.<br>
     * IT: Mesna.<br>
     */
    MESNA("386922000",
          "http://snomed.info/sct",
          "Mesna (substance)",
          "Mesna",
          "Mesna",
          "mesna",
          "Mesna"),
    /**
     * EN: Metamizole.<br>
     * DE: Metamizol.<br>
     * FR: métamizole.<br>
     * IT: Metamizolo.<br>
     */
    METAMIZOLE("780831000",
               "http://snomed.info/sct",
               "Metamizole (substance)",
               "Metamizole",
               "Metamizol",
               "métamizole",
               "Metamizolo"),
    /**
     * EN: Metformin.<br>
     * DE: Metformin.<br>
     * FR: metformine.<br>
     * IT: Metformina.<br>
     */
    METFORMIN("372567009",
              "http://snomed.info/sct",
              "Metformin (substance)",
              "Metformin",
              "Metformin",
              "metformine",
              "Metformina"),
    /**
     * EN: Methadone.<br>
     * DE: Methadon.<br>
     * FR: méthadone.<br>
     * IT: Metadone.<br>
     */
    METHADONE("387286002",
              "http://snomed.info/sct",
              "Methadone (substance)",
              "Methadone",
              "Methadon",
              "méthadone",
              "Metadone"),
    /**
     * EN: Methionine.<br>
     * DE: Methionin.<br>
     * FR: méthionine.<br>
     * IT: Metionina.<br>
     */
    METHIONINE("70288006",
               "http://snomed.info/sct",
               "Methionine (substance)",
               "Methionine",
               "Methionin",
               "méthionine",
               "Metionina"),
    /**
     * EN: Methotrexate.<br>
     * DE: Methotrexat.<br>
     * FR: méthotrexate.<br>
     * IT: Metotrexato.<br>
     */
    METHOTREXATE("387381009",
                 "http://snomed.info/sct",
                 "Methotrexate (substance)",
                 "Methotrexate",
                 "Methotrexat",
                 "méthotrexate",
                 "Metotrexato"),
    /**
     * EN: Methoxsalen.<br>
     * DE: Methoxsalen.<br>
     * FR: méthoxsalène.<br>
     * IT: Metoxsalene.<br>
     */
    METHOXSALEN("41062004",
                "http://snomed.info/sct",
                "Methoxsalen (substance)",
                "Methoxsalen",
                "Methoxsalen",
                "méthoxsalène",
                "Metoxsalene"),
    /**
     * EN: Methoxy polyethylene glycol-epoetin beta.<br>
     * DE: PEG-Epoetin beta.<br>
     * FR: époétine bêta pégylée.<br>
     * IT: Metossipolietilenglicole-epoetina beta.<br>
     */
    METHOXY_POLYETHYLENE_GLYCOL_EPOETIN_BETA("425913002",
                                             "http://snomed.info/sct",
                                             "Methoxy polyethylene glycol-epoetin beta (substance)",
                                             "Methoxy polyethylene glycol-epoetin beta",
                                             "PEG-Epoetin beta",
                                             "époétine bêta pégylée",
                                             "Metossipolietilenglicole-epoetina beta"),
    /**
     * EN: Methyldopa anhydrous.<br>
     * DE: Methyldopa.<br>
     * FR: méthyldopa.<br>
     * IT: Metildopa.<br>
     */
    METHYLDOPA_ANHYDROUS("768043006",
                         "http://snomed.info/sct",
                         "Methyldopa anhydrous (substance)",
                         "Methyldopa anhydrous",
                         "Methyldopa",
                         "méthyldopa",
                         "Metildopa"),
    /**
     * EN: Methylene blue stain.<br>
     * DE: Methylthioninium chlorid.<br>
     * FR: méthylthionine chlorure.<br>
     * IT: Metiltioninio cloruro.<br>
     */
    METHYLENE_BLUE_STAIN("6725000",
                         "http://snomed.info/sct",
                         "Methylene blue stain (substance)",
                         "Methylene blue stain",
                         "Methylthioninium chlorid",
                         "méthylthionine chlorure",
                         "Metiltioninio cloruro"),
    /**
     * EN: Methylergometrine.<br>
     * DE: Methylergometrin.<br>
     * FR: méthylergométrine.<br>
     * IT: Metilergometrina.<br>
     */
    METHYLERGOMETRINE("126074008",
                      "http://snomed.info/sct",
                      "Methylergometrine (substance)",
                      "Methylergometrine",
                      "Methylergometrin",
                      "méthylergométrine",
                      "Metilergometrina"),
    /**
     * EN: Methylphenidate.<br>
     * DE: Methylphenidat.<br>
     * FR: méthylphénidate.<br>
     * IT: Metilfenidato.<br>
     */
    METHYLPHENIDATE("373337007",
                    "http://snomed.info/sct",
                    "Methylphenidate (substance)",
                    "Methylphenidate",
                    "Methylphenidat",
                    "méthylphénidate",
                    "Metilfenidato"),
    /**
     * EN: Methylprednisolone.<br>
     * DE: Methylprednisolon.<br>
     * FR: méthylprednisolone.<br>
     * IT: Metilprednisolone.<br>
     */
    METHYLPREDNISOLONE("116593003",
                       "http://snomed.info/sct",
                       "Methylprednisolone (substance)",
                       "Methylprednisolone",
                       "Methylprednisolon",
                       "méthylprednisolone",
                       "Metilprednisolone"),
    /**
     * EN: Metoclopramide.<br>
     * DE: Metoclopramid.<br>
     * FR: métoclopramide.<br>
     * IT: Metoclopramide.<br>
     */
    METOCLOPRAMIDE("372776000",
                   "http://snomed.info/sct",
                   "Metoclopramide (substance)",
                   "Metoclopramide",
                   "Metoclopramid",
                   "métoclopramide",
                   "Metoclopramide"),
    /**
     * EN: Metolazone.<br>
     * DE: Metolazon.<br>
     * FR: métolazone.<br>
     * IT: Metolazone.<br>
     */
    METOLAZONE("387123003",
               "http://snomed.info/sct",
               "Metolazone (substance)",
               "Metolazone",
               "Metolazon",
               "métolazone",
               "Metolazone"),
    /**
     * EN: Metoprolol.<br>
     * DE: Metoprolol.<br>
     * FR: métoprolol.<br>
     * IT: Metoprololo.<br>
     */
    METOPROLOL("372826007",
               "http://snomed.info/sct",
               "Metoprolol (substance)",
               "Metoprolol",
               "Metoprolol",
               "métoprolol",
               "Metoprololo"),
    /**
     * EN: Metronidazole.<br>
     * DE: Metronidazol.<br>
     * FR: métronidazole.<br>
     * IT: Metronidazolo.<br>
     */
    METRONIDAZOLE("372602008",
                  "http://snomed.info/sct",
                  "Metronidazole (substance)",
                  "Metronidazole",
                  "Metronidazol",
                  "métronidazole",
                  "Metronidazolo"),
    /**
     * EN: Mianserin hydrochloride.<br>
     * DE: Mianserin hydrochlorid.<br>
     * FR: miansérine chlorhydrate.<br>
     * IT: Mianserina HCL.<br>
     */
    MIANSERIN_HYDROCHLORIDE("395795008",
                            "http://snomed.info/sct",
                            "Mianserin hydrochloride (substance)",
                            "Mianserin hydrochloride",
                            "Mianserin hydrochlorid",
                            "miansérine chlorhydrate",
                            "Mianserina HCL"),
    /**
     * EN: Miconazole.<br>
     * DE: Miconazol.<br>
     * FR: miconazole.<br>
     * IT: Miconazolo.<br>
     */
    MICONAZOLE("372738006",
               "http://snomed.info/sct",
               "Miconazole (substance)",
               "Miconazole",
               "Miconazol",
               "miconazole",
               "Miconazolo"),
    /**
     * EN: Midazolam.<br>
     * DE: Midazolam.<br>
     * FR: midazolam.<br>
     * IT: Midazolam.<br>
     */
    MIDAZOLAM("373476007",
              "http://snomed.info/sct",
              "Midazolam (substance)",
              "Midazolam",
              "Midazolam",
              "midazolam",
              "Midazolam"),
    /**
     * EN: Midodrine.<br>
     * DE: Midodrin.<br>
     * FR: midodrine.<br>
     * IT: Midodrina.<br>
     */
    MIDODRINE("372504000",
              "http://snomed.info/sct",
              "Midodrine (substance)",
              "Midodrine",
              "Midodrin",
              "midodrine",
              "Midodrina"),
    /**
     * EN: Mifepristone.<br>
     * DE: Mifepriston.<br>
     * FR: mifépristone.<br>
     * IT: Miferpristone.<br>
     */
    MIFEPRISTONE("395796009",
                 "http://snomed.info/sct",
                 "Mifepristone (substance)",
                 "Mifepristone",
                 "Mifepriston",
                 "mifépristone",
                 "Miferpristone"),
    /**
     * EN: Milrinone.<br>
     * DE: Milrinon.<br>
     * FR: milrinone.<br>
     * IT: Milrinone.<br>
     */
    MILRINONE("373441005",
              "http://snomed.info/sct",
              "Milrinone (substance)",
              "Milrinone",
              "Milrinon",
              "milrinone",
              "Milrinone"),
    /**
     * EN: Minocycline.<br>
     * DE: Minocyclin.<br>
     * FR: minocycline.<br>
     * IT: Minociclina.<br>
     */
    MINOCYCLINE("372653009",
                "http://snomed.info/sct",
                "Minocycline (substance)",
                "Minocycline",
                "Minocyclin",
                "minocycline",
                "Minociclina"),
    /**
     * EN: Minoxidil.<br>
     * DE: Minoxidil.<br>
     * FR: minoxidil.<br>
     * IT: Minoxidil.<br>
     */
    MINOXIDIL("387272001",
              "http://snomed.info/sct",
              "Minoxidil (substance)",
              "Minoxidil",
              "Minoxidil",
              "minoxidil",
              "Minoxidil"),
    /**
     * EN: Mirabegron.<br>
     * DE: Mirabegron.<br>
     * FR: mirabégron.<br>
     * IT: Mirabegron.<br>
     */
    MIRABEGRON("703803006",
               "http://snomed.info/sct",
               "Mirabegron (substance)",
               "Mirabegron",
               "Mirabegron",
               "mirabégron",
               "Mirabegron"),
    /**
     * EN: Mirtazapine.<br>
     * DE: Mirtazapin.<br>
     * FR: mirtazapine.<br>
     * IT: Mirtazapina.<br>
     */
    MIRTAZAPINE("386847004",
                "http://snomed.info/sct",
                "Mirtazapine (substance)",
                "Mirtazapine",
                "Mirtazapin",
                "mirtazapine",
                "Mirtazapina"),
    /**
     * EN: Misoprostol.<br>
     * DE: Misoprostol.<br>
     * FR: misoprostol.<br>
     * IT: Misoprostolo.<br>
     */
    MISOPROSTOL("387242007",
                "http://snomed.info/sct",
                "Misoprostol (substance)",
                "Misoprostol",
                "Misoprostol",
                "misoprostol",
                "Misoprostolo"),
    /**
     * EN: Mitomycin.<br>
     * DE: Mitomycin.<br>
     * FR: mitomycine.<br>
     * IT: Mitomicina.<br>
     */
    MITOMYCIN("387331000",
              "http://snomed.info/sct",
              "Mitomycin (substance)",
              "Mitomycin",
              "Mitomycin",
              "mitomycine",
              "Mitomicina"),
    /**
     * EN: Mitoxantrone.<br>
     * DE: Mitoxantron.<br>
     * FR: mitoxantrone.<br>
     * IT: Mitoxantrone.<br>
     */
    MITOXANTRONE("386913001",
                 "http://snomed.info/sct",
                 "Mitoxantrone (substance)",
                 "Mitoxantrone",
                 "Mitoxantron",
                 "mitoxantrone",
                 "Mitoxantrone"),
    /**
     * EN: Mivacurium chloride.<br>
     * DE: Mivacurium chlorid.<br>
     * FR: mivacurium chlorure.<br>
     * IT: Mivacurio cloruro.<br>
     */
    MIVACURIUM_CHLORIDE("108447000",
                        "http://snomed.info/sct",
                        "Mivacurium chloride (substance)",
                        "Mivacurium chloride",
                        "Mivacurium chlorid",
                        "mivacurium chlorure",
                        "Mivacurio cloruro"),
    /**
     * EN: Moclobemide.<br>
     * DE: Moclobemid.<br>
     * FR: moclobémide.<br>
     * IT: Moclobemide.<br>
     */
    MOCLOBEMIDE("395800003",
                "http://snomed.info/sct",
                "Moclobemide (substance)",
                "Moclobemide",
                "Moclobemid",
                "moclobémide",
                "Moclobemide"),
    /**
     * EN: Modafinil.<br>
     * DE: Modafinil.<br>
     * FR: modafinil.<br>
     * IT: Modafinil.<br>
     */
    MODAFINIL("387004007",
              "http://snomed.info/sct",
              "Modafinil (substance)",
              "Modafinil",
              "Modafinil",
              "modafinil",
              "Modafinil"),
    /**
     * EN: Molsidomine.<br>
     * DE: Molsidomin.<br>
     * FR: molsidomine.<br>
     * IT: Molsidomina.<br>
     */
    MOLSIDOMINE("698196008",
                "http://snomed.info/sct",
                "Molsidomine (substance)",
                "Molsidomine",
                "Molsidomin",
                "molsidomine",
                "Molsidomina"),
    /**
     * EN: Mometasone.<br>
     * DE: Mometason.<br>
     * FR: mométasone.<br>
     * IT: Mometasone.<br>
     */
    MOMETASONE("395990009",
               "http://snomed.info/sct",
               "Mometasone (substance)",
               "Mometasone",
               "Mometason",
               "mométasone",
               "Mometasone"),
    /**
     * EN: Montelukast.<br>
     * DE: Montelukast.<br>
     * FR: montélukast.<br>
     * IT: Montelukast.<br>
     */
    MONTELUKAST("373728005",
                "http://snomed.info/sct",
                "Montelukast (substance)",
                "Montelukast",
                "Montelukast",
                "montélukast",
                "Montelukast"),
    /**
     * EN: Moroctocog alfa.<br>
     * DE: Moroctocog alfa.<br>
     * FR: moroctocog alfa.<br>
     * IT: Moroctocog alfa.<br>
     */
    MOROCTOCOG_ALFA("441764007",
                    "http://snomed.info/sct",
                    "Moroctocog alfa (substance)",
                    "Moroctocog alfa",
                    "Moroctocog alfa",
                    "moroctocog alfa",
                    "Moroctocog alfa"),
    /**
     * EN: Morphine.<br>
     * DE: Morphin.<br>
     * FR: morphine.<br>
     * IT: Morfina.<br>
     */
    MORPHINE("373529000",
             "http://snomed.info/sct",
             "Morphine (substance)",
             "Morphine",
             "Morphin",
             "morphine",
             "Morfina"),
    /**
     * EN: Moxifloxacin.<br>
     * DE: Moxifloxacin.<br>
     * FR: moxifloxacine.<br>
     * IT: Moxifloxacina.<br>
     */
    MOXIFLOXACIN("412439003",
                 "http://snomed.info/sct",
                 "Moxifloxacin (substance)",
                 "Moxifloxacin",
                 "Moxifloxacin",
                 "moxifloxacine",
                 "Moxifloxacina"),
    /**
     * EN: Moxonidine.<br>
     * DE: Moxonidin.<br>
     * FR: moxonidine.<br>
     * IT: Moxonidina.<br>
     */
    MOXONIDINE("395805008",
               "http://snomed.info/sct",
               "Moxonidine (substance)",
               "Moxonidine",
               "Moxonidin",
               "moxonidine",
               "Moxonidina"),
    /**
     * EN: Mupirocin.<br>
     * DE: Mupirocin.<br>
     * FR: mupirocine.<br>
     * IT: Mupirocina.<br>
     */
    MUPIROCIN("387397004",
              "http://snomed.info/sct",
              "Mupirocin (substance)",
              "Mupirocin",
              "Mupirocin",
              "mupirocine",
              "Mupirocina"),
    /**
     * EN: Mycophenolate mofetil.<br>
     * DE: Mycophenolat mofetil.<br>
     * FR: mycophénolate mofétil.<br>
     * IT: Micofenolato mofetile.<br>
     */
    MYCOPHENOLATE_MOFETIL("386976000",
                          "http://snomed.info/sct",
                          "Mycophenolate mofetil (substance)",
                          "Mycophenolate mofetil",
                          "Mycophenolat mofetil",
                          "mycophénolate mofétil",
                          "Micofenolato mofetile"),
    /**
     * EN: Mycophenolic acid.<br>
     * DE: Mycophenolsäure.<br>
     * FR: acide mycophénolique.<br>
     * IT: Acido micofenolico.<br>
     */
    MYCOPHENOLIC_ACID("409330005",
                      "http://snomed.info/sct",
                      "Mycophenolic acid (substance)",
                      "Mycophenolic acid",
                      "Mycophenolsäure",
                      "acide mycophénolique",
                      "Acido micofenolico"),
    /**
     * EN: Nadolol.<br>
     * DE: Nadolol.<br>
     * FR: nadolol.<br>
     * IT: Nadololo.<br>
     */
    NADOLOL("387482003",
            "http://snomed.info/sct",
            "Nadolol (substance)",
            "Nadolol",
            "Nadolol",
            "nadolol",
            "Nadololo"),
    /**
     * EN: Nadroparine.<br>
     * DE: Nadroparin.<br>
     * FR: nadroparine.<br>
     * IT: Nadroparina.<br>
     */
    NADROPARINE("699946002",
                "http://snomed.info/sct",
                "Nadroparine (substance)",
                "Nadroparine",
                "Nadroparin",
                "nadroparine",
                "Nadroparina"),
    /**
     * EN: Nadroparin calcium.<br>
     * DE: Nadroparin calcium.<br>
     * FR: nadroparine calcique.<br>
     * IT: Nadroparina calcica.<br>
     */
    NADROPARIN_CALCIUM("698278006",
                       "http://snomed.info/sct",
                       "Nadroparin calcium (substance)",
                       "Nadroparin calcium",
                       "Nadroparin calcium",
                       "nadroparine calcique",
                       "Nadroparina calcica"),
    /**
     * EN: Naftazone.<br>
     * DE: Naftazon.<br>
     * FR: naftazone.<br>
     * IT: Naftazone.<br>
     */
    NAFTAZONE("713428001",
              "http://snomed.info/sct",
              "Naftazone (substance)",
              "Naftazone",
              "Naftazon",
              "naftazone",
              "Naftazone"),
    /**
     * EN: Naftidrofuryl.<br>
     * DE: Naftidrofuryl.<br>
     * FR: naftidrofuryl.<br>
     * IT: Naftidrofurile.<br>
     */
    NAFTIDROFURYL("395992001",
                  "http://snomed.info/sct",
                  "Naftidrofuryl (substance)",
                  "Naftidrofuryl",
                  "Naftidrofuryl",
                  "naftidrofuryl",
                  "Naftidrofurile"),
    /**
     * EN: Nalmefene.<br>
     * DE: Nalmefen.<br>
     * FR: nalméfène.<br>
     * IT: Nalmefene.<br>
     */
    NALMEFENE("109098006",
              "http://snomed.info/sct",
              "Nalmefene (substance)",
              "Nalmefene",
              "Nalmefen",
              "nalméfène",
              "Nalmefene"),
    /**
     * EN: Naloxone.<br>
     * DE: Naloxon.<br>
     * FR: naloxone.<br>
     * IT: Naloxone.<br>
     */
    NALOXONE("372890007",
             "http://snomed.info/sct",
             "Naloxone (substance)",
             "Naloxone",
             "Naloxon",
             "naloxone",
             "Naloxone"),
    /**
     * EN: Naltrexone.<br>
     * DE: Naltrexon.<br>
     * FR: naltrexone.<br>
     * IT: Naltrexone.<br>
     */
    NALTREXONE("373546002",
               "http://snomed.info/sct",
               "Naltrexone (substance)",
               "Naltrexone",
               "Naltrexon",
               "naltrexone",
               "Naltrexone"),
    /**
     * EN: Naphazoline.<br>
     * DE: Naphazolin.<br>
     * FR: naphazoline.<br>
     * IT: Nafazolina.<br>
     */
    NAPHAZOLINE("372803000",
                "http://snomed.info/sct",
                "Naphazoline (substance)",
                "Naphazoline",
                "Naphazolin",
                "naphazoline",
                "Nafazolina"),
    /**
     * EN: Naproxen.<br>
     * DE: Naproxen.<br>
     * FR: naproxène.<br>
     * IT: Naprossene.<br>
     */
    NAPROXEN("372588000",
             "http://snomed.info/sct",
             "Naproxen (substance)",
             "Naproxen",
             "Naproxen",
             "naproxène",
             "Naprossene"),
    /**
     * EN: Naratriptan.<br>
     * DE: Naratriptan.<br>
     * FR: naratriptan.<br>
     * IT: Naratriptan.<br>
     */
    NARATRIPTAN("363571003",
                "http://snomed.info/sct",
                "Naratriptan (substance)",
                "Naratriptan",
                "Naratriptan",
                "naratriptan",
                "Naratriptan"),
    /**
     * EN: Natalizumab.<br>
     * DE: Natalizumab.<br>
     * FR: natalizumab.<br>
     * IT: Natalizumab.<br>
     */
    NATALIZUMAB("414805007",
                "http://snomed.info/sct",
                "Natalizumab (substance)",
                "Natalizumab",
                "Natalizumab",
                "natalizumab",
                "Natalizumab"),
    /**
     * EN: Nateglinide.<br>
     * DE: Nateglinid.<br>
     * FR: natéglinide.<br>
     * IT: Nateglinide.<br>
     */
    NATEGLINIDE("387070004",
                "http://snomed.info/sct",
                "Nateglinide (substance)",
                "Nateglinide",
                "Nateglinid",
                "natéglinide",
                "Nateglinide"),
    /**
     * EN: Nebivolol.<br>
     * DE: Nebivolol.<br>
     * FR: nébivolol.<br>
     * IT: Nebivololo.<br>
     */
    NEBIVOLOL("395808005",
              "http://snomed.info/sct",
              "Nebivolol (substance)",
              "Nebivolol",
              "Nebivolol",
              "nébivolol",
              "Nebivololo"),
    /**
     * EN: Nelfinavir.<br>
     * DE: Nelfinavir.<br>
     * FR: nelfinavir.<br>
     * IT: Nelfinavir.<br>
     */
    NELFINAVIR("373445001",
               "http://snomed.info/sct",
               "Nelfinavir (substance)",
               "Nelfinavir",
               "Nelfinavir",
               "nelfinavir",
               "Nelfinavir"),
    /**
     * EN: Neomycin.<br>
     * DE: Neomycin.<br>
     * FR: néomycine.<br>
     * IT: Neomicina.<br>
     */
    NEOMYCIN("373528008",
             "http://snomed.info/sct",
             "Neomycin (substance)",
             "Neomycin",
             "Neomycin",
             "néomycine",
             "Neomicina"),
    /**
     * EN: Neostigmine.<br>
     * DE: Neostigmin.<br>
     * FR: néostigmine.<br>
     * IT: Neostigmina.<br>
     */
    NEOSTIGMINE("373346001",
                "http://snomed.info/sct",
                "Neostigmine (substance)",
                "Neostigmine",
                "Neostigmin",
                "néostigmine",
                "Neostigmina"),
    /**
     * EN: Nevirapine.<br>
     * DE: Nevirapin.<br>
     * FR: névirapine.<br>
     * IT: Nevirapina.<br>
     */
    NEVIRAPINE("386898005",
               "http://snomed.info/sct",
               "Nevirapine (substance)",
               "Nevirapine",
               "Nevirapin",
               "névirapine",
               "Nevirapina"),
    /**
     * EN: Nicardipine.<br>
     * DE: Nicardipin.<br>
     * FR: nicardipine.<br>
     * IT: Nicardipina.<br>
     */
    NICARDIPINE("372502001",
                "http://snomed.info/sct",
                "Nicardipine (substance)",
                "Nicardipine",
                "Nicardipin",
                "nicardipine",
                "Nicardipina"),
    /**
     * EN: Nicorandil.<br>
     * DE: Nicorandil.<br>
     * FR: nicorandil.<br>
     * IT: Nicorandil.<br>
     */
    NICORANDIL("395809002",
               "http://snomed.info/sct",
               "Nicorandil (substance)",
               "Nicorandil",
               "Nicorandil",
               "nicorandil",
               "Nicorandil"),
    /**
     * EN: Nicotinamide.<br>
     * DE: Nicotinamid.<br>
     * FR: nicotinamide.<br>
     * IT: Nicotinamide.<br>
     */
    NICOTINAMIDE("173196005",
                 "http://snomed.info/sct",
                 "Nicotinamide (substance)",
                 "Nicotinamide",
                 "Nicotinamid",
                 "nicotinamide",
                 "Nicotinamide"),
    /**
     * EN: Nicotine.<br>
     * DE: Nicotin.<br>
     * FR: nicotine.<br>
     * IT: Nicotina.<br>
     */
    NICOTINE("68540007",
             "http://snomed.info/sct",
             "Nicotine (substance)",
             "Nicotine",
             "Nicotin",
             "nicotine",
             "Nicotina"),
    /**
     * EN: Nifedipine.<br>
     * DE: Nifedipin.<br>
     * FR: nifédipine.<br>
     * IT: Nifedipina.<br>
     */
    NIFEDIPINE("387490003",
               "http://snomed.info/sct",
               "Nifedipine (substance)",
               "Nifedipine",
               "Nifedipin",
               "nifédipine",
               "Nifedipina"),
    /**
     * EN: Nimesulide.<br>
     * DE: Nimesulid.<br>
     * FR: nimésulide.<br>
     * IT: Nimesulide.<br>
     */
    NIMESULIDE("703479000",
               "http://snomed.info/sct",
               "Nimesulide (substance)",
               "Nimesulide",
               "Nimesulid",
               "nimésulide",
               "Nimesulide"),
    /**
     * EN: Nimodipine.<br>
     * DE: Nimodipin.<br>
     * FR: nimodipine.<br>
     * IT: Nimodipina.<br>
     */
    NIMODIPINE("387502003",
               "http://snomed.info/sct",
               "Nimodipine (substance)",
               "Nimodipine",
               "Nimodipin",
               "nimodipine",
               "Nimodipina"),
    /**
     * EN: Nintedanib.<br>
     * DE: Nintedanib.<br>
     * FR: nintédanib.<br>
     * IT: Nintedanib.<br>
     */
    NINTEDANIB("712494002",
               "http://snomed.info/sct",
               "Nintedanib (substance)",
               "Nintedanib",
               "Nintedanib",
               "nintédanib",
               "Nintedanib"),
    /**
     * EN: Nitazoxanide.<br>
     * DE: Nitazoxanid.<br>
     * FR: nitazoxanide.<br>
     * IT: Nitazoxanide.<br>
     */
    NITAZOXANIDE("407148001",
                 "http://snomed.info/sct",
                 "Nitazoxanide (substance)",
                 "Nitazoxanide",
                 "Nitazoxanid",
                 "nitazoxanide",
                 "Nitazoxanide"),
    /**
     * EN: Nitisinone.<br>
     * DE: Nitisinon.<br>
     * FR: nitisinone.<br>
     * IT: Nitisinone.<br>
     */
    NITISINONE("385996000",
               "http://snomed.info/sct",
               "Nitisinone (substance)",
               "Nitisinone",
               "Nitisinon",
               "nitisinone",
               "Nitisinone"),
    /**
     * EN: Nitrazepam.<br>
     * DE: Nitrazepam.<br>
     * FR: nitrazépam.<br>
     * IT: Nitrazepam.<br>
     */
    NITRAZEPAM("387449001",
               "http://snomed.info/sct",
               "Nitrazepam (substance)",
               "Nitrazepam",
               "Nitrazepam",
               "nitrazépam",
               "Nitrazepam"),
    /**
     * EN: Nitrendipine.<br>
     * DE: Nitrendipin.<br>
     * FR: nitrendipine.<br>
     * IT: Nitrendipina.<br>
     */
    NITRENDIPINE("444757009",
                 "http://snomed.info/sct",
                 "Nitrendipine (substance)",
                 "Nitrendipine",
                 "Nitrendipin",
                 "nitrendipine",
                 "Nitrendipina"),
    /**
     * EN: Nitrofurantoin.<br>
     * DE: Nitrofurantoin.<br>
     * FR: nitrofurantoïne.<br>
     * IT: Nitrofurantoina.<br>
     */
    NITROFURANTOIN("373543005",
                   "http://snomed.info/sct",
                   "Nitrofurantoin (substance)",
                   "Nitrofurantoin",
                   "Nitrofurantoin",
                   "nitrofurantoïne",
                   "Nitrofurantoina"),
    /**
     * EN: Nivolumab.<br>
     * DE: Nivolumab.<br>
     * FR: nivolumab.<br>
     * IT: Nivolumab.<br>
     */
    NIVOLUMAB("704191007",
              "http://snomed.info/sct",
              "Nivolumab (substance)",
              "Nivolumab",
              "Nivolumab",
              "nivolumab",
              "Nivolumab"),
    /**
     * EN: Nomegestrol acetate.<br>
     * DE: Nomegestrol acetat.<br>
     * FR: nomégestrol acétate.<br>
     * IT: Nomegestrolo acetato.<br>
     */
    NOMEGESTROL_ACETATE("698277001",
                        "http://snomed.info/sct",
                        "Nomegestrol acetate (substance)",
                        "Nomegestrol acetate",
                        "Nomegestrol acetat",
                        "nomégestrol acétate",
                        "Nomegestrolo acetato"),
    /**
     * EN: Norepinephrine.<br>
     * DE: Noradrenalin (Norepinephrin).<br>
     * FR: noradrénaline (norépinéphrine).<br>
     * IT: Noradrenalina (norepinefrina).<br>
     */
    NOREPINEPHRINE("45555007",
                   "http://snomed.info/sct",
                   "Norepinephrine (substance)",
                   "Norepinephrine",
                   "Noradrenalin (Norepinephrin)",
                   "noradrénaline (norépinéphrine)",
                   "Noradrenalina (norepinefrina)"),
    /**
     * EN: Norethisterone.<br>
     * DE: Norethisteron.<br>
     * FR: noréthistérone.<br>
     * IT: Noretisterone.<br>
     */
    NORETHISTERONE("126102009",
                   "http://snomed.info/sct",
                   "Norethisterone (substance)",
                   "Norethisterone",
                   "Norethisteron",
                   "noréthistérone",
                   "Noretisterone"),
    /**
     * EN: Norfloxacin.<br>
     * DE: Norfloxacin.<br>
     * FR: norfloxacine.<br>
     * IT: Norfloxacina.<br>
     */
    NORFLOXACIN("387271008",
                "http://snomed.info/sct",
                "Norfloxacin (substance)",
                "Norfloxacin",
                "Norfloxacin",
                "norfloxacine",
                "Norfloxacina"),
    /**
     * EN: Norgestimate.<br>
     * DE: Norgestimat.<br>
     * FR: norgestimate.<br>
     * IT: Norgestimato.<br>
     */
    NORGESTIMATE("126115000",
                 "http://snomed.info/sct",
                 "Norgestimate (substance)",
                 "Norgestimate",
                 "Norgestimat",
                 "norgestimate",
                 "Norgestimato"),
    /**
     * EN: Norgestrel.<br>
     * DE: Norgestrel.<br>
     * FR: norgestrel.<br>
     * IT: Norgestrel.<br>
     */
    NORGESTREL("126106007",
               "http://snomed.info/sct",
               "Norgestrel (substance)",
               "Norgestrel",
               "Norgestrel",
               "norgestrel",
               "Norgestrel"),
    /**
     * EN: Normal immunoglobulin human.<br>
     * DE: Immunglobulin vom Menschen.<br>
     * FR: immunoglobuline humaine normale.<br>
     * IT: Immunoglobulina umana normale.<br>
     */
    NORMAL_IMMUNOGLOBULIN_HUMAN("713355009",
                                "http://snomed.info/sct",
                                "Normal immunoglobulin human (substance)",
                                "Normal immunoglobulin human",
                                "Immunglobulin vom Menschen",
                                "immunoglobuline humaine normale",
                                "Immunoglobulina umana normale"),
    /**
     * EN: Nortriptyline.<br>
     * DE: Nortriptylin.<br>
     * FR: nortriptyline.<br>
     * IT: Nortriptilina.<br>
     */
    NORTRIPTYLINE("372652004",
                  "http://snomed.info/sct",
                  "Nortriptyline (substance)",
                  "Nortriptyline",
                  "Nortriptylin",
                  "nortriptyline",
                  "Nortriptilina"),
    /**
     * EN: Noscapine.<br>
     * DE: Noscapin.<br>
     * FR: noscapine.<br>
     * IT: Noscapina.<br>
     */
    NOSCAPINE("387437002",
              "http://snomed.info/sct",
              "Noscapine (substance)",
              "Noscapine",
              "Noscapin",
              "noscapine",
              "Noscapina"),
    /**
     * EN: Nystatin.<br>
     * DE: Nystatin.<br>
     * FR: nystatine.<br>
     * IT: Nistatina.<br>
     */
    NYSTATIN("387048002",
             "http://snomed.info/sct",
             "Nystatin (substance)",
             "Nystatin",
             "Nystatin",
             "nystatine",
             "Nistatina"),
    /**
     * EN: Obeticholic acid.<br>
     * DE: Obeticholsäure.<br>
     * FR: acide obéticholique.<br>
     * IT: Acido obeticolico.<br>
     */
    OBETICHOLIC_ACID("720257002",
                     "http://snomed.info/sct",
                     "Obeticholic acid (substance)",
                     "Obeticholic acid",
                     "Obeticholsäure",
                     "acide obéticholique",
                     "Acido obeticolico"),
    /**
     * EN: Obidoxime chloride.<br>
     * DE: Obidoxim chlorid.<br>
     * FR: obidoxime chlorure.<br>
     * IT: obidoxima cloruro.<br>
     */
    OBIDOXIME_CHLORIDE("1156231009",
                       "http://snomed.info/sct",
                       "Obidoxime chloride (substance)",
                       "Obidoxime chloride",
                       "Obidoxim chlorid",
                       "obidoxime chlorure",
                       "obidoxima cloruro"),
    /**
     * EN: Obinutuzumab.<br>
     * DE: Obinutuzumab.<br>
     * FR: obinutuzumab.<br>
     * IT: Obinutuzumab.<br>
     */
    OBINUTUZUMAB("710287009",
                 "http://snomed.info/sct",
                 "Obinutuzumab (substance)",
                 "Obinutuzumab",
                 "Obinutuzumab",
                 "obinutuzumab",
                 "Obinutuzumab"),
    /**
     * EN: Ocrelizumab.<br>
     * DE: Ocrelizumab.<br>
     * FR: ocrélizumab.<br>
     * IT: Ocrelizumab.<br>
     */
    OCRELIZUMAB("733464008",
                "http://snomed.info/sct",
                "Ocrelizumab (substance)",
                "Ocrelizumab",
                "Ocrelizumab",
                "ocrélizumab",
                "Ocrelizumab"),
    /**
     * EN: Octenidine.<br>
     * DE: Octenidin.<br>
     * FR: octénidine.<br>
     * IT: Octenidina.<br>
     */
    OCTENIDINE("430477008",
               "http://snomed.info/sct",
               "Octenidine (substance)",
               "Octenidine",
               "Octenidin",
               "octénidine",
               "Octenidina"),
    /**
     * EN: Octocog alfa.<br>
     * DE: Octocog alfa.<br>
     * FR: octocog alfa.<br>
     * IT: Octocog alfa.<br>
     */
    OCTOCOG_ALFA("418888003",
                 "http://snomed.info/sct",
                 "Octocog alfa (substance)",
                 "Octocog alfa",
                 "Octocog alfa",
                 "octocog alfa",
                 "Octocog alfa"),
    /**
     * EN: Octreotide.<br>
     * DE: Octreotid.<br>
     * FR: octréotide.<br>
     * IT: Octreotide.<br>
     */
    OCTREOTIDE("109053000",
               "http://snomed.info/sct",
               "Octreotide (substance)",
               "Octreotide",
               "Octreotid",
               "octréotide",
               "Octreotide"),
    /**
     * EN: Ofloxacin.<br>
     * DE: Ofloxacin.<br>
     * FR: ofloxacine.<br>
     * IT: Ofloxacina.<br>
     */
    OFLOXACIN("387551000",
              "http://snomed.info/sct",
              "Ofloxacin (substance)",
              "Ofloxacin",
              "Ofloxacin",
              "ofloxacine",
              "Ofloxacina"),
    /**
     * EN: Olanzapine.<br>
     * DE: Olanzapin.<br>
     * FR: olanzapine.<br>
     * IT: Olanzapina.<br>
     */
    OLANZAPINE("386849001",
               "http://snomed.info/sct",
               "Olanzapine (substance)",
               "Olanzapine",
               "Olanzapin",
               "olanzapine",
               "Olanzapina"),
    /**
     * EN: Olanzapine embonate.<br>
     * DE: Olanzapin embonat-1-Wasser.<br>
     * FR: olanzapine embonate.<br>
     * IT: Olanzapina embonato.<br>
     */
    OLANZAPINE_EMBONATE("725800004",
                        "http://snomed.info/sct",
                        "Olanzapine embonate (substance)",
                        "Olanzapine embonate",
                        "Olanzapin embonat-1-Wasser",
                        "olanzapine embonate",
                        "Olanzapina embonato"),
    /**
     * EN: Olive oil.<br>
     * DE: Olivenöl.<br>
     * FR: olive huile.<br>
     * IT: Oliva olio.<br>
     */
    OLIVE_OIL("41834005",
              "http://snomed.info/sct",
              "Olive oil (substance)",
              "Olive oil",
              "Olivenöl",
              "olive huile",
              "Oliva olio"),
    /**
     * EN: Olmesartan.<br>
     * DE: Olmesartan.<br>
     * FR: olmésartan.<br>
     * IT: Olmesartan.<br>
     */
    OLMESARTAN("412259001",
               "http://snomed.info/sct",
               "Olmesartan (substance)",
               "Olmesartan",
               "Olmesartan",
               "olmésartan",
               "Olmesartan"),
    /**
     * EN: Olodaterol.<br>
     * DE: Olodaterol.<br>
     * FR: olodatérol.<br>
     * IT: Olodaterolo.<br>
     */
    OLODATEROL("704459002",
               "http://snomed.info/sct",
               "Olodaterol (substance)",
               "Olodaterol",
               "Olodaterol",
               "olodatérol",
               "Olodaterolo"),
    /**
     * EN: Omalizumab.<br>
     * DE: Omalizumab.<br>
     * FR: omalizumab.<br>
     * IT: Omalizumab.<br>
     */
    OMALIZUMAB("406443008",
               "http://snomed.info/sct",
               "Omalizumab (substance)",
               "Omalizumab",
               "Omalizumab",
               "omalizumab",
               "Omalizumab"),
    /**
     * EN: Omega 3 fatty acid.<br>
     * DE: Omega-3-Fettsäuren.<br>
     * FR: acides gras oméga-3.<br>
     * IT: Acidi grassi omega 3.<br>
     */
    OMEGA_3_FATTY_ACID("226365003",
                       "http://snomed.info/sct",
                       "Omega 3 fatty acid (substance)",
                       "Omega 3 fatty acid",
                       "Omega-3-Fettsäuren",
                       "acides gras oméga-3",
                       "Acidi grassi omega 3"),
    /**
     * EN: Omeprazole.<br>
     * DE: Omeprazol.<br>
     * FR: oméprazole.<br>
     * IT: Omeprazolo.<br>
     */
    OMEPRAZOLE("387137007",
               "http://snomed.info/sct",
               "Omeprazole (substance)",
               "Omeprazole",
               "Omeprazol",
               "oméprazole",
               "Omeprazolo"),
    /**
     * EN: Ondansetron.<br>
     * DE: Ondansetron.<br>
     * FR: ondansétron.<br>
     * IT: Ondansetron.<br>
     */
    ONDANSETRON("372487007",
                "http://snomed.info/sct",
                "Ondansetron (substance)",
                "Ondansetron",
                "Ondansetron",
                "ondansétron",
                "Ondansetron"),
    /**
     * EN: Opipramol.<br>
     * DE: Opipramol.<br>
     * FR: opipramol.<br>
     * IT: opipramolo.<br>
     */
    OPIPRAMOL("1156223004",
              "http://snomed.info/sct",
              "Opipramol (substance)",
              "Opipramol",
              "Opipramol",
              "opipramol",
              "opipramolo"),
    /**
     * EN: Orlistat.<br>
     * DE: Orlistat.<br>
     * FR: orlistat.<br>
     * IT: Orlistat.<br>
     */
    ORLISTAT("387007000",
             "http://snomed.info/sct",
             "Orlistat (substance)",
             "Orlistat",
             "Orlistat",
             "orlistat",
             "Orlistat"),
    /**
     * EN: Ornidazole.<br>
     * DE: Ornidazol.<br>
     * FR: ornidazole.<br>
     * IT: Ornidazolo.<br>
     */
    ORNIDAZOLE("442924004",
               "http://snomed.info/sct",
               "Ornidazole (substance)",
               "Ornidazole",
               "Ornidazol",
               "ornidazole",
               "Ornidazolo"),
    /**
     * EN: Oseltamivir.<br>
     * DE: Oseltamivir.<br>
     * FR: oseltamivir.<br>
     * IT: Oseltamivir.<br>
     */
    OSELTAMIVIR("412261005",
                "http://snomed.info/sct",
                "Oseltamivir (substance)",
                "Oseltamivir",
                "Oseltamivir",
                "oseltamivir",
                "Oseltamivir"),
    /**
     * EN: Oxaliplatin.<br>
     * DE: Oxaliplatin.<br>
     * FR: oxaliplatine.<br>
     * IT: Oxaliplatino.<br>
     */
    OXALIPLATIN("395814003",
                "http://snomed.info/sct",
                "Oxaliplatin (substance)",
                "Oxaliplatin",
                "Oxaliplatin",
                "oxaliplatine",
                "Oxaliplatino"),
    /**
     * EN: Oxandrolone.<br>
     * DE: Oxandrolon.<br>
     * FR: oxandrolone.<br>
     * IT: Oxandrolone.<br>
     */
    OXANDROLONE("126128007",
                "http://snomed.info/sct",
                "Oxandrolone (substance)",
                "Oxandrolone",
                "Oxandrolon",
                "oxandrolone",
                "Oxandrolone"),
    /**
     * EN: Oxazepam.<br>
     * DE: Oxazepam.<br>
     * FR: oxazépam.<br>
     * IT: Oxazepam.<br>
     */
    OXAZEPAM("387455006",
             "http://snomed.info/sct",
             "Oxazepam (substance)",
             "Oxazepam",
             "Oxazepam",
             "oxazépam",
             "Oxazepam"),
    /**
     * EN: Oxcarbazepine.<br>
     * DE: Oxcarbazepin.<br>
     * FR: oxcarbazépine.<br>
     * IT: Oxcarbazepina.<br>
     */
    OXCARBAZEPINE("387025007",
                  "http://snomed.info/sct",
                  "Oxcarbazepine (substance)",
                  "Oxcarbazepine",
                  "Oxcarbazepin",
                  "oxcarbazépine",
                  "Oxcarbazepina"),
    /**
     * EN: Oxomemazine.<br>
     * DE: Oxomemazin.<br>
     * FR: oxomémazine.<br>
     * IT: Oxomemazina.<br>
     */
    OXOMEMAZINE("772837001",
                "http://snomed.info/sct",
                "Oxomemazine (substance)",
                "Oxomemazine",
                "Oxomemazin",
                "oxomémazine",
                "Oxomemazina"),
    /**
     * EN: Oxybuprocaine.<br>
     * DE: Oxybuprocain.<br>
     * FR: oxybuprocaïne.<br>
     * IT: Oxibuprocaina.<br>
     */
    OXYBUPROCAINE("52140009",
                  "http://snomed.info/sct",
                  "Oxybuprocaine (substance)",
                  "Oxybuprocaine",
                  "Oxybuprocain",
                  "oxybuprocaïne",
                  "Oxibuprocaina"),
    /**
     * EN: Oxybutynin.<br>
     * DE: Oxybutynin.<br>
     * FR: oxybutynine.<br>
     * IT: Ossibutinina.<br>
     */
    OXYBUTYNIN("372717000",
               "http://snomed.info/sct",
               "Oxybutynin (substance)",
               "Oxybutynin",
               "Oxybutynin",
               "oxybutynine",
               "Ossibutinina"),
    /**
     * EN: Oxycodone.<br>
     * DE: Oxycodon.<br>
     * FR: oxycodone.<br>
     * IT: Ossicodone.<br>
     */
    OXYCODONE("55452001",
              "http://snomed.info/sct",
              "Oxycodone (substance)",
              "Oxycodone",
              "Oxycodon",
              "oxycodone",
              "Ossicodone"),
    /**
     * EN: Oxymetazoline.<br>
     * DE: Oxymetazolin.<br>
     * FR: oxymétazoline.<br>
     * IT: Ossimetazolina.<br>
     */
    OXYMETAZOLINE("387158001",
                  "http://snomed.info/sct",
                  "Oxymetazoline (substance)",
                  "Oxymetazoline",
                  "Oxymetazolin",
                  "oxymétazoline",
                  "Ossimetazolina"),
    /**
     * EN: Oxytetracycline.<br>
     * DE: Oxytetracyclin.<br>
     * FR: oxytétracycline.<br>
     * IT: Ossitetraciclina.<br>
     */
    OXYTETRACYCLINE("372675006",
                    "http://snomed.info/sct",
                    "Oxytetracycline (substance)",
                    "Oxytetracycline",
                    "Oxytetracyclin",
                    "oxytétracycline",
                    "Ossitetraciclina"),
    /**
     * EN: Oxytocin.<br>
     * DE: Oxytocin.<br>
     * FR: oxytocine.<br>
     * IT: Ossitocina.<br>
     */
    OXYTOCIN("112115002",
             "http://snomed.info/sct",
             "Oxytocin (substance)",
             "Oxytocin",
             "Oxytocin",
             "oxytocine",
             "Ossitocina"),
    /**
     * EN: Paclitaxel.<br>
     * DE: Paclitaxel.<br>
     * FR: paclitaxel.<br>
     * IT: Paclitaxel.<br>
     */
    PACLITAXEL("387374002",
               "http://snomed.info/sct",
               "Paclitaxel (substance)",
               "Paclitaxel",
               "Paclitaxel",
               "paclitaxel",
               "Paclitaxel"),
    /**
     * EN: Paliperidone.<br>
     * DE: Paliperidon.<br>
     * FR: palipéridone.<br>
     * IT: Paliperidone.<br>
     */
    PALIPERIDONE("426276000",
                 "http://snomed.info/sct",
                 "Paliperidone (substance)",
                 "Paliperidone",
                 "Paliperidon",
                 "palipéridone",
                 "Paliperidone"),
    /**
     * EN: Palivizumab.<br>
     * DE: Palivizumab.<br>
     * FR: palivizumab.<br>
     * IT: Palivizumab.<br>
     */
    PALIVIZUMAB("386900007",
                "http://snomed.info/sct",
                "Palivizumab (substance)",
                "Palivizumab",
                "Palivizumab",
                "palivizumab",
                "Palivizumab"),
    /**
     * EN: Palonosetron.<br>
     * DE: Palonosetron.<br>
     * FR: palonosétron.<br>
     * IT: Palonosetron.<br>
     */
    PALONOSETRON("404852008",
                 "http://snomed.info/sct",
                 "Palonosetron (substance)",
                 "Palonosetron",
                 "Palonosetron",
                 "palonosétron",
                 "Palonosetron"),
    /**
     * EN: Pancuronium.<br>
     * DE: Pancuronium.<br>
     * FR: pancuronium.<br>
     * IT: Pancuronio.<br>
     */
    PANCURONIUM("373738000",
                "http://snomed.info/sct",
                "Pancuronium (substance)",
                "Pancuronium",
                "Pancuronium",
                "pancuronium",
                "Pancuronio"),
    /**
     * EN: Pantoprazole.<br>
     * DE: Pantoprazol.<br>
     * FR: pantoprazole.<br>
     * IT: Pantoprazolo.<br>
     */
    PANTOPRAZOLE("395821003",
                 "http://snomed.info/sct",
                 "Pantoprazole (substance)",
                 "Pantoprazole",
                 "Pantoprazol",
                 "pantoprazole",
                 "Pantoprazolo"),
    /**
     * EN: Pantothenic acid.<br>
     * DE: Pantothensäure.<br>
     * FR: acide pantothénique.<br>
     * IT: Acido pantotenico.<br>
     */
    PANTOTHENIC_ACID("86431009",
                     "http://snomed.info/sct",
                     "Pantothenic acid (substance)",
                     "Pantothenic acid",
                     "Pantothensäure",
                     "acide pantothénique",
                     "Acido pantotenico"),
    /**
     * EN: Papaverine.<br>
     * DE: Papaverin.<br>
     * FR: papavérine.<br>
     * IT: Papaverina.<br>
     */
    PAPAVERINE("372784001",
               "http://snomed.info/sct",
               "Papaverine (substance)",
               "Papaverine",
               "Papaverin",
               "papavérine",
               "Papaverina"),
    /**
     * EN: Paracetamol.<br>
     * DE: Paracetamol.<br>
     * FR: paracétamol.<br>
     * IT: Paracetamolo.<br>
     */
    PARACETAMOL("387517004",
                "http://snomed.info/sct",
                "Paracetamol (substance)",
                "Paracetamol",
                "Paracetamol",
                "paracétamol",
                "Paracetamolo"),
    /**
     * EN: Paraffin.<br>
     * DE: Paraffin.<br>
     * FR: paraffine.<br>
     * IT: Paraffina.<br>
     */
    PARAFFIN("255667006",
             "http://snomed.info/sct",
             "Paraffin (substance)",
             "Paraffin",
             "Paraffin",
             "paraffine",
             "Paraffina"),
    /**
     * EN: Paricalcitol.<br>
     * DE: Paricalcitol.<br>
     * FR: paricalcitol.<br>
     * IT: Paracalcitolo.<br>
     */
    PARICALCITOL("108946001",
                 "http://snomed.info/sct",
                 "Paricalcitol (substance)",
                 "Paricalcitol",
                 "Paricalcitol",
                 "paricalcitol",
                 "Paracalcitolo"),
    /**
     * EN: Paroxetine.<br>
     * DE: Paroxetin.<br>
     * FR: paroxétine.<br>
     * IT: Paroxetina.<br>
     */
    PAROXETINE("372595009",
               "http://snomed.info/sct",
               "Paroxetine (substance)",
               "Paroxetine",
               "Paroxetin",
               "paroxétine",
               "Paroxetina"),
    /**
     * EN: Pegaspargase.<br>
     * DE: Pegaspargase.<br>
     * FR: pégaspargase.<br>
     * IT: Pegaspargase.<br>
     */
    PEGASPARGASE("108814000",
                 "http://snomed.info/sct",
                 "Pegaspargase (substance)",
                 "Pegaspargase",
                 "Pegaspargase",
                 "pégaspargase",
                 "Pegaspargase"),
    /**
     * EN: Pegfilgrastim.<br>
     * DE: Pegfilgrastim.<br>
     * FR: pegfilgrastim.<br>
     * IT: Pegfilgrastim.<br>
     */
    PEGFILGRASTIM("385544005",
                  "http://snomed.info/sct",
                  "Pegfilgrastim (substance)",
                  "Pegfilgrastim",
                  "Pegfilgrastim",
                  "pegfilgrastim",
                  "Pegfilgrastim"),
    /**
     * EN: Peginterferon alfa-2a.<br>
     * DE: Peginterferon alfa-2a.<br>
     * FR: peginterféron alfa-2a.<br>
     * IT: Peginterferone alfa-2a.<br>
     */
    PEGINTERFERON_ALFA_2A("421559001",
                          "http://snomed.info/sct",
                          "Peginterferon alfa-2a (substance)",
                          "Peginterferon alfa-2a",
                          "Peginterferon alfa-2a",
                          "peginterféron alfa-2a",
                          "Peginterferone alfa-2a"),
    /**
     * EN: Pembrolizumab.<br>
     * DE: Pembrolizumab.<br>
     * FR: pembrolizumab.<br>
     * IT: Pembrolizumab.<br>
     */
    PEMBROLIZUMAB("716125002",
                  "http://snomed.info/sct",
                  "Pembrolizumab (substance)",
                  "Pembrolizumab",
                  "Pembrolizumab",
                  "pembrolizumab",
                  "Pembrolizumab"),
    /**
     * EN: Pemetrexed.<br>
     * DE: Pemetrexed.<br>
     * FR: pémétrexed.<br>
     * IT: Pemetrexed.<br>
     */
    PEMETREXED("409159000",
               "http://snomed.info/sct",
               "Pemetrexed (substance)",
               "Pemetrexed",
               "Pemetrexed",
               "pémétrexed",
               "Pemetrexed"),
    /**
     * EN: Penciclovir.<br>
     * DE: Penciclovir.<br>
     * FR: penciclovir.<br>
     * IT: Penciclovir.<br>
     */
    PENCICLOVIR("386939003",
                "http://snomed.info/sct",
                "Penciclovir (substance)",
                "Penciclovir",
                "Penciclovir",
                "penciclovir",
                "Penciclovir"),
    /**
     * EN: Pentamidine isethionate.<br>
     * DE: Pentamidin diisetionat.<br>
     * FR: pentamidine diiséthionate.<br>
     * IT: Pentamidina.<br>
     */
    PENTAMIDINE_ISETHIONATE("16826009",
                            "http://snomed.info/sct",
                            "Pentamidine isethionate (substance)",
                            "Pentamidine isethionate",
                            "Pentamidin diisetionat",
                            "pentamidine diiséthionate",
                            "Pentamidina"),
    /**
     * EN: Pentoxifylline.<br>
     * DE: Pentoxifyllin.<br>
     * FR: pentoxyfylline.<br>
     * IT: Pentossifillina.<br>
     */
    PENTOXIFYLLINE("387522004",
                   "http://snomed.info/sct",
                   "Pentoxifylline (substance)",
                   "Pentoxifylline",
                   "Pentoxifyllin",
                   "pentoxyfylline",
                   "Pentossifillina"),
    /**
     * EN: Perampanel.<br>
     * DE: Perampanel.<br>
     * FR: pérampanel.<br>
     * IT: Perampanel.<br>
     */
    PERAMPANEL("703127006",
               "http://snomed.info/sct",
               "Perampanel (substance)",
               "Perampanel",
               "Perampanel",
               "pérampanel",
               "Perampanel"),
    /**
     * EN: Perindopril.<br>
     * DE: Perindopril.<br>
     * FR: périndopril.<br>
     * IT: Perindopril.<br>
     */
    PERINDOPRIL("372916001",
                "http://snomed.info/sct",
                "Perindopril (substance)",
                "Perindopril",
                "Perindopril",
                "périndopril",
                "Perindopril"),
    /**
     * EN: Permethrin.<br>
     * DE: Permethrin.<br>
     * FR: perméthrine.<br>
     * IT: Permetrina.<br>
     */
    PERMETHRIN("410457007",
               "http://snomed.info/sct",
               "Permethrin (substance)",
               "Permethrin",
               "Permethrin",
               "perméthrine",
               "Permetrina"),
    /**
     * EN: Pertuzumab.<br>
     * DE: Pertuzumab.<br>
     * FR: pertuzumab.<br>
     * IT: Pertuzumab.<br>
     */
    PERTUZUMAB("704226002",
               "http://snomed.info/sct",
               "Pertuzumab (substance)",
               "Pertuzumab",
               "Pertuzumab",
               "pertuzumab",
               "Pertuzumab"),
    /**
     * EN: Pethidine.<br>
     * DE: Pethidin.<br>
     * FR: péthidine.<br>
     * IT: Petidina.<br>
     */
    PETHIDINE("387298007",
              "http://snomed.info/sct",
              "Pethidine (substance)",
              "Pethidine",
              "Pethidin",
              "péthidine",
              "Petidina"),
    /**
     * EN: Phenazone.<br>
     * DE: Phenazon.<br>
     * FR: phénazone.<br>
     * IT: Fenazone.<br>
     */
    PHENAZONE("55486005",
              "http://snomed.info/sct",
              "Phenazone (substance)",
              "Phenazone",
              "Phenazon",
              "phénazone",
              "Fenazone"),
    /**
     * EN: Pheniramine.<br>
     * DE: Pheniramin.<br>
     * FR: phéniramine.<br>
     * IT: Feniramina.<br>
     */
    PHENIRAMINE("373500002",
                "http://snomed.info/sct",
                "Pheniramine (substance)",
                "Pheniramine",
                "Pheniramin",
                "phéniramine",
                "Feniramina"),
    /**
     * EN: Phenobarbital.<br>
     * DE: Phenobarbital.<br>
     * FR: phénobarbital.<br>
     * IT: Fenobarbital.<br>
     */
    PHENOBARBITAL("373505007",
                  "http://snomed.info/sct",
                  "Phenobarbital (substance)",
                  "Phenobarbital",
                  "Phenobarbital",
                  "phénobarbital",
                  "Fenobarbital"),
    /**
     * EN: Phenoxybenzamine.<br>
     * DE: Phenoxybenzamin.<br>
     * FR: phénoxybenzamine.<br>
     * IT: Fenossibenzamina.<br>
     */
    PHENOXYBENZAMINE("372838003",
                     "http://snomed.info/sct",
                     "Phenoxybenzamine (substance)",
                     "Phenoxybenzamine",
                     "Phenoxybenzamin",
                     "phénoxybenzamine",
                     "Fenossibenzamina"),
    /**
     * EN: Phenoxymethylpenicillin potassium.<br>
     * DE: Phenoxymethylpenicillin kalium.<br>
     * FR: phénoxyméthylpénicilline potassique.<br>
     * IT: Fenossimetilpenicillina potassica.<br>
     */
    PHENOXYMETHYLPENICILLIN_POTASSIUM("56723006",
                                      "http://snomed.info/sct",
                                      "Phenoxymethylpenicillin potassium (substance)",
                                      "Phenoxymethylpenicillin potassium",
                                      "Phenoxymethylpenicillin kalium",
                                      "phénoxyméthylpénicilline potassique",
                                      "Fenossimetilpenicillina potassica"),
    /**
     * EN: Phenprocoumon.<br>
     * DE: Phenprocoumon.<br>
     * FR: phenprocoumone.<br>
     * IT: Fenprocumone.<br>
     */
    PHENPROCOUMON("59488002",
                  "http://snomed.info/sct",
                  "Phenprocoumon (substance)",
                  "Phenprocoumon",
                  "Phenprocoumon",
                  "phenprocoumone",
                  "Fenprocumone"),
    /**
     * EN: Phentolamine.<br>
     * DE: Phentolamin.<br>
     * FR: phentolamine.<br>
     * IT: Fentolamina.<br>
     */
    PHENTOLAMINE("372863003",
                 "http://snomed.info/sct",
                 "Phentolamine (substance)",
                 "Phentolamine",
                 "Phentolamin",
                 "phentolamine",
                 "Fentolamina"),
    /**
     * EN: Phenylalanine.<br>
     * DE: Phenylalanin.<br>
     * FR: phénylalanine.<br>
     * IT: Fenilalanina.<br>
     */
    PHENYLALANINE("63004003",
                  "http://snomed.info/sct",
                  "Phenylalanine (substance)",
                  "Phenylalanine",
                  "Phenylalanin",
                  "phénylalanine",
                  "Fenilalanina"),
    /**
     * EN: Phenylephrine.<br>
     * DE: Phenylephrin.<br>
     * FR: phényléphrine.<br>
     * IT: Fenilefrina.<br>
     */
    PHENYLEPHRINE("372771005",
                  "http://snomed.info/sct",
                  "Phenylephrine (substance)",
                  "Phenylephrine",
                  "Phenylephrin",
                  "phényléphrine",
                  "Fenilefrina"),
    /**
     * EN: Phenytoin.<br>
     * DE: Phenytoin.<br>
     * FR: phénytoïne.<br>
     * IT: Fenitoina.<br>
     */
    PHENYTOIN("387220006",
              "http://snomed.info/sct",
              "Phenytoin (substance)",
              "Phenytoin",
              "Phenytoin",
              "phénytoïne",
              "Fenitoina"),
    /**
     * EN: Pholcodine.<br>
     * DE: Pholcodin.<br>
     * FR: pholcodine.<br>
     * IT: Folcodina.<br>
     */
    PHOLCODINE("396486005",
               "http://snomed.info/sct",
               "Pholcodine (substance)",
               "Pholcodine",
               "Pholcodin",
               "pholcodine",
               "Folcodina"),
    /**
     * EN: Phospholipid.<br>
     * DE: Phospholipide.<br>
     * FR: phospholipides.<br>
     * IT: Fosfolipidi.<br>
     */
    PHOSPHOLIPID("78447009",
                 "http://snomed.info/sct",
                 "Phospholipid (substance)",
                 "Phospholipid",
                 "Phospholipide",
                 "phospholipides",
                 "Fosfolipidi"),
    /**
     * EN: Physostigmine.<br>
     * DE: Physostigmin.<br>
     * FR: physostigmine.<br>
     * IT: Fisostigmina.<br>
     */
    PHYSOSTIGMINE("373347005",
                  "http://snomed.info/sct",
                  "Physostigmine (substance)",
                  "Physostigmine",
                  "Physostigmin",
                  "physostigmine",
                  "Fisostigmina"),
    /**
     * EN: Phytomenadione.<br>
     * DE: Phytomenadion (Vitamin K1).<br>
     * FR: phytoménadione (Vitamine K1).<br>
     * IT: Fitomenadione (vitamina K1).<br>
     */
    PHYTOMENADIONE("66656000",
                   "http://snomed.info/sct",
                   "Phytomenadione (substance)",
                   "Phytomenadione",
                   "Phytomenadion (Vitamin K1)",
                   "phytoménadione (Vitamine K1)",
                   "Fitomenadione (vitamina K1)"),
    /**
     * EN: Pilocarpine.<br>
     * DE: Pilocarpin.<br>
     * FR: pilocarpine.<br>
     * IT: Pilocarpina.<br>
     */
    PILOCARPINE("372895002",
                "http://snomed.info/sct",
                "Pilocarpine (substance)",
                "Pilocarpine",
                "Pilocarpin",
                "pilocarpine",
                "Pilocarpina"),
    /**
     * EN: Pimecrolimus.<br>
     * DE: Pimecrolimus.<br>
     * FR: pimécrolimus.<br>
     * IT: Pimecrolimus.<br>
     */
    PIMECROLIMUS("385580005",
                 "http://snomed.info/sct",
                 "Pimecrolimus (substance)",
                 "Pimecrolimus",
                 "Pimecrolimus",
                 "pimécrolimus",
                 "Pimecrolimus"),
    /**
     * EN: Pioglitazone.<br>
     * DE: Pioglitazon.<br>
     * FR: pioglitazone.<br>
     * IT: Pioglitazone.<br>
     */
    PIOGLITAZONE("395828009",
                 "http://snomed.info/sct",
                 "Pioglitazone (substance)",
                 "Pioglitazone",
                 "Pioglitazon",
                 "pioglitazone",
                 "Pioglitazone"),
    /**
     * EN: Pipamperone.<br>
     * DE: Pipamperon.<br>
     * FR: pipampérone.<br>
     * IT: Pipamperone.<br>
     */
    PIPAMPERONE("703362007",
                "http://snomed.info/sct",
                "Pipamperone (substance)",
                "Pipamperone",
                "Pipamperon",
                "pipampérone",
                "Pipamperone"),
    /**
     * EN: Piperacillin.<br>
     * DE: Piperacillin.<br>
     * FR: pipéracilline.<br>
     * IT: Piperacillina.<br>
     */
    PIPERACILLIN("372836004",
                 "http://snomed.info/sct",
                 "Piperacillin (substance)",
                 "Piperacillin",
                 "Piperacillin",
                 "pipéracilline",
                 "Piperacillina"),
    /**
     * EN: Piracetam.<br>
     * DE: Piracetam.<br>
     * FR: piracétam.<br>
     * IT: Piracetam.<br>
     */
    PIRACETAM("395833008",
              "http://snomed.info/sct",
              "Piracetam (substance)",
              "Piracetam",
              "Piracetam",
              "piracétam",
              "Piracetam"),
    /**
     * EN: Piretanide.<br>
     * DE: Piretanid.<br>
     * FR: pirétanide.<br>
     * IT: Piretanide.<br>
     */
    PIRETANIDE("419451002",
               "http://snomed.info/sct",
               "Piretanide (substance)",
               "Piretanide",
               "Piretanid",
               "pirétanide",
               "Piretanide"),
    /**
     * EN: Piroxicam.<br>
     * DE: Piroxicam.<br>
     * FR: piroxicam.<br>
     * IT: Piroxicam.<br>
     */
    PIROXICAM("387153005",
              "http://snomed.info/sct",
              "Piroxicam (substance)",
              "Piroxicam",
              "Piroxicam",
              "piroxicam",
              "Piroxicam"),
    /**
     * EN: Pitavastatin.<br>
     * DE: Pitavastatin.<br>
     * FR: pitavastatine.<br>
     * IT: Pitavastatina.<br>
     */
    PITAVASTATIN("443586000",
                 "http://snomed.info/sct",
                 "Pitavastatin (substance)",
                 "Pitavastatin",
                 "Pitavastatin",
                 "pitavastatine",
                 "Pitavastatina"),
    /**
     * EN: Pituitary luteinizing hormone.<br>
     * DE: Lutropin (hLH).<br>
     * FR: lutropine (hLH).<br>
     * IT: Ormone luteinizzante umano, hLH.<br>
     */
    PITUITARY_LUTEINIZING_HORMONE("64182005",
                                  "http://snomed.info/sct",
                                  "Pituitary luteinizing hormone (substance)",
                                  "Pituitary luteinizing hormone",
                                  "Lutropin (hLH)",
                                  "lutropine (hLH)",
                                  "Ormone luteinizzante umano, hLH"),
    /**
     * EN: Plerixafor.<br>
     * DE: Plerixafor.<br>
     * FR: plérixafor.<br>
     * IT: Plerixafor.<br>
     */
    PLERIXAFOR("442264009",
               "http://snomed.info/sct",
               "Plerixafor (substance)",
               "Plerixafor",
               "Plerixafor",
               "plérixafor",
               "Plerixafor"),
    /**
     * EN: Polihexanide.<br>
     * DE: Polihexanid.<br>
     * FR: polyhexanide.<br>
     * IT: Poliesanide.<br>
     */
    POLIHEXANIDE("421952002",
                 "http://snomed.info/sct",
                 "Polihexanide (substance)",
                 "Polihexanide",
                 "Polihexanid",
                 "polyhexanide",
                 "Poliesanide"),
    /**
     * EN: Polymyxin.<br>
     * DE: Polymyxin B.<br>
     * FR: polymyxine B.<br>
     * IT: Polimixina B.<br>
     */
    POLYMYXIN("373224006",
              "http://snomed.info/sct",
              "Polymyxin (substance)",
              "Polymyxin",
              "Polymyxin B",
              "polymyxine B",
              "Polimixina B"),
    /**
     * EN: Posaconazole.<br>
     * DE: Posaconazol.<br>
     * FR: posaconazole.<br>
     * IT: Posaconazolo.<br>
     */
    POSACONAZOLE("421747003",
                 "http://snomed.info/sct",
                 "Posaconazole (substance)",
                 "Posaconazole",
                 "Posaconazol",
                 "posaconazole",
                 "Posaconazolo"),
    /**
     * EN: Potassium acetate.<br>
     * DE: Kaliumacetat.<br>
     * FR: potassium acétate.<br>
     * IT: Potassio acetato.<br>
     */
    POTASSIUM_ACETATE("52394008",
                      "http://snomed.info/sct",
                      "Potassium acetate (substance)",
                      "Potassium acetate",
                      "Kaliumacetat",
                      "potassium acétate",
                      "Potassio acetato"),
    /**
     * EN: Potassium chloride.<br>
     * DE: Kaliumchlorid.<br>
     * FR: potassium chlorure.<br>
     * IT: Potassio cloruro.<br>
     */
    POTASSIUM_CHLORIDE("8631001",
                       "http://snomed.info/sct",
                       "Potassium chloride (substance)",
                       "Potassium chloride",
                       "Kaliumchlorid",
                       "potassium chlorure",
                       "Potassio cloruro"),
    /**
     * EN: Potassium citrate.<br>
     * DE: Kalium citrat (E332).<br>
     * FR: potassium citrate (E332).<br>
     * IT: Potassio citrato (E332).<br>
     */
    POTASSIUM_CITRATE("387450001",
                      "http://snomed.info/sct",
                      "Potassium citrate (substance)",
                      "Potassium citrate",
                      "Kalium citrat (E332)",
                      "potassium citrate (E332)",
                      "Potassio citrato (E332)"),
    /**
     * EN: Potassium gluconate.<br>
     * DE: Kalium D-gluconat wasserfrei.<br>
     * FR: potassium D-gluconate anhydre.<br>
     * IT: Potassio gluconato.<br>
     */
    POTASSIUM_GLUCONATE("89219006",
                        "http://snomed.info/sct",
                        "Potassium gluconate (substance)",
                        "Potassium gluconate",
                        "Kalium D-gluconat wasserfrei",
                        "potassium D-gluconate anhydre",
                        "Potassio gluconato"),
    /**
     * EN: Potassium permanganate.<br>
     * DE: Kaliumpermanganat.<br>
     * FR: permanganate de potassium.<br>
     * IT: Potassio permanganato.<br>
     */
    POTASSIUM_PERMANGANATE("4681002",
                           "http://snomed.info/sct",
                           "Potassium permanganate (substance)",
                           "Potassium permanganate",
                           "Kaliumpermanganat",
                           "permanganate de potassium",
                           "Potassio permanganato"),
    /**
     * EN: Potassium phosphate.<br>
     * DE: Kalium phosphat.<br>
     * FR: potassium phosphate.<br>
     * IT: Potassio fosfato.<br>
     */
    POTASSIUM_PHOSPHATE("80916004",
                        "http://snomed.info/sct",
                        "Potassium phosphate (substance)",
                        "Potassium phosphate",
                        "Kalium phosphat",
                        "potassium phosphate",
                        "Potassio fosfato"),
    /**
     * EN: Povidone iodine.<br>
     * DE: Povidon iod.<br>
     * FR: povidone iodée.<br>
     * IT: Iodopovidone.<br>
     */
    POVIDONE_IODINE("386989006",
                    "http://snomed.info/sct",
                    "Povidone iodine (substance)",
                    "Povidone iodine",
                    "Povidon iod",
                    "povidone iodée",
                    "Iodopovidone"),
    /**
     * EN: Pramipexole.<br>
     * DE: Pramipexol.<br>
     * FR: pramipexole.<br>
     * IT: Pramipexolo.<br>
     */
    PRAMIPEXOLE("386852009",
                "http://snomed.info/sct",
                "Pramipexole (substance)",
                "Pramipexole",
                "Pramipexol",
                "pramipexole",
                "Pramipexolo"),
    /**
     * EN: Prasugrel.<br>
     * DE: Prasugrel.<br>
     * FR: prasugrel.<br>
     * IT: Prasugrel.<br>
     */
    PRASUGREL("443129001",
              "http://snomed.info/sct",
              "Prasugrel (substance)",
              "Prasugrel",
              "Prasugrel",
              "prasugrel",
              "Prasugrel"),
    /**
     * EN: Pravastatin.<br>
     * DE: Pravastatin.<br>
     * FR: pravastatine.<br>
     * IT: Pravastatina.<br>
     */
    PRAVASTATIN("373566006",
                "http://snomed.info/sct",
                "Pravastatin (substance)",
                "Pravastatin",
                "Pravastatin",
                "pravastatine",
                "Pravastatina"),
    /**
     * EN: Prazepam.<br>
     * DE: Prazepam.<br>
     * FR: prazépam.<br>
     * IT: Prazepam.<br>
     */
    PRAZEPAM("387417001",
             "http://snomed.info/sct",
             "Prazepam (substance)",
             "Prazepam",
             "Prazepam",
             "prazépam",
             "Prazepam"),
    /**
     * EN: Praziquantel.<br>
     * DE: Praziquantel.<br>
     * FR: praziquantel.<br>
     * IT: Praziquantel.<br>
     */
    PRAZIQUANTEL("387310003",
                 "http://snomed.info/sct",
                 "Praziquantel (substance)",
                 "Praziquantel",
                 "Praziquantel",
                 "praziquantel",
                 "Praziquantel"),
    /**
     * EN: Prednicarbate.<br>
     * DE: Prednicarbat.<br>
     * FR: prednicarbate.<br>
     * IT: Prednicarbato.<br>
     */
    PREDNICARBATE("126086006",
                  "http://snomed.info/sct",
                  "Prednicarbate (substance)",
                  "Prednicarbate",
                  "Prednicarbat",
                  "prednicarbate",
                  "Prednicarbato"),
    /**
     * EN: Prednisolone.<br>
     * DE: Prednisolon.<br>
     * FR: prednisolone.<br>
     * IT: Prednisolone.<br>
     */
    PREDNISOLONE("116601002",
                 "http://snomed.info/sct",
                 "Prednisolone (substance)",
                 "Prednisolone",
                 "Prednisolon",
                 "prednisolone",
                 "Prednisolone"),
    /**
     * EN: Prednisone.<br>
     * DE: Prednison.<br>
     * FR: prednisone.<br>
     * IT: Prednisone.<br>
     */
    PREDNISONE("116602009",
               "http://snomed.info/sct",
               "Prednisone (substance)",
               "Prednisone",
               "Prednison",
               "prednisone",
               "Prednisone"),
    /**
     * EN: Pregabalin.<br>
     * DE: Pregabalin.<br>
     * FR: prégabaline.<br>
     * IT: Pregabalin.<br>
     */
    PREGABALIN("415160008",
               "http://snomed.info/sct",
               "Pregabalin (substance)",
               "Pregabalin",
               "Pregabalin",
               "prégabaline",
               "Pregabalin"),
    /**
     * EN: Prilocaine.<br>
     * DE: Prilocain.<br>
     * FR: prilocaïne.<br>
     * IT: Prilocaina.<br>
     */
    PRILOCAINE("387107003",
               "http://snomed.info/sct",
               "Prilocaine (substance)",
               "Prilocaine",
               "Prilocain",
               "prilocaïne",
               "Prilocaina"),
    /**
     * EN: Primaquine.<br>
     * DE: Primaquin.<br>
     * FR: primaquine.<br>
     * IT: Primachina.<br>
     */
    PRIMAQUINE("429663004",
               "http://snomed.info/sct",
               "Primaquine (substance)",
               "Primaquine",
               "Primaquin",
               "primaquine",
               "Primachina"),
    /**
     * EN: Primidone.<br>
     * DE: Primidon.<br>
     * FR: primidone.<br>
     * IT: Primidone.<br>
     */
    PRIMIDONE("387256009",
              "http://snomed.info/sct",
              "Primidone (substance)",
              "Primidone",
              "Primidon",
              "primidone",
              "Primidone"),
    /**
     * EN: Probenecid.<br>
     * DE: Probenecid.<br>
     * FR: probénécide.<br>
     * IT: Probenecid.<br>
     */
    PROBENECID("387365004",
               "http://snomed.info/sct",
               "Probenecid (substance)",
               "Probenecid",
               "Probenecid",
               "probénécide",
               "Probenecid"),
    /**
     * EN: Procainamide.<br>
     * DE: Procainamid.<br>
     * FR: procaïnamide.<br>
     * IT: Procainamide.<br>
     */
    PROCAINAMIDE("372589008",
                 "http://snomed.info/sct",
                 "Procainamide (substance)",
                 "Procainamide",
                 "Procainamid",
                 "procaïnamide",
                 "Procainamide"),
    /**
     * EN: Procaine.<br>
     * DE: Procain.<br>
     * FR: procaïne.<br>
     * IT: Procaina.<br>
     */
    PROCAINE("387238009",
             "http://snomed.info/sct",
             "Procaine (substance)",
             "Procaine",
             "Procain",
             "procaïne",
             "Procaina"),
    /**
     * EN: Procyclidine.<br>
     * DE: Procyclidin.<br>
     * FR: procyclidine.<br>
     * IT: Prociclidina.<br>
     */
    PROCYCLIDINE("387247001",
                 "http://snomed.info/sct",
                 "Procyclidine (substance)",
                 "Procyclidine",
                 "Procyclidin",
                 "procyclidine",
                 "Prociclidina"),
    /**
     * EN: Progesterone.<br>
     * DE: Progesteron.<br>
     * FR: progestérone.<br>
     * IT: Progesterone.<br>
     */
    PROGESTERONE("16683002",
                 "http://snomed.info/sct",
                 "Progesterone (substance)",
                 "Progesterone",
                 "Progesteron",
                 "progestérone",
                 "Progesterone"),
    /**
     * EN: Proguanil.<br>
     * DE: Proguanil.<br>
     * FR: proguanil.<br>
     * IT: Proguanil.<br>
     */
    PROGUANIL("387094004",
              "http://snomed.info/sct",
              "Proguanil (substance)",
              "Proguanil",
              "Proguanil",
              "proguanil",
              "Proguanil"),
    /**
     * EN: Proline.<br>
     * DE: Prolin.<br>
     * FR: proline.<br>
     * IT: Prolina.<br>
     */
    PROLINE("52541003",
            "http://snomed.info/sct",
            "Proline (substance)",
            "Proline",
            "Prolin",
            "proline",
            "Prolina"),
    /**
     * EN: Promazine hydrochloride.<br>
     * DE: Promazin hydrochlorid.<br>
     * FR: promazine chlorhydrate.<br>
     * IT: Promazina.<br>
     */
    PROMAZINE_HYDROCHLORIDE("79135001",
                            "http://snomed.info/sct",
                            "Promazine hydrochloride (substance)",
                            "Promazine hydrochloride",
                            "Promazin hydrochlorid",
                            "promazine chlorhydrate",
                            "Promazina"),
    /**
     * EN: Promethazine.<br>
     * DE: Promethazin.<br>
     * FR: prométhazine.<br>
     * IT: Prometazina.<br>
     */
    PROMETHAZINE("372871004",
                 "http://snomed.info/sct",
                 "Promethazine (substance)",
                 "Promethazine",
                 "Promethazin",
                 "prométhazine",
                 "Prometazina"),
    /**
     * EN: Propafenone.<br>
     * DE: Propafenon.<br>
     * FR: propafénone.<br>
     * IT: Propafenone.<br>
     */
    PROPAFENONE("372910007",
                "http://snomed.info/sct",
                "Propafenone (substance)",
                "Propafenone",
                "Propafenon",
                "propafénone",
                "Propafenone"),
    /**
     * EN: Propofol.<br>
     * DE: Propofol.<br>
     * FR: propofol.<br>
     * IT: Propofol.<br>
     */
    PROPOFOL("387423006",
             "http://snomed.info/sct",
             "Propofol (substance)",
             "Propofol",
             "Propofol",
             "propofol",
             "Propofol"),
    /**
     * EN: Propranolol.<br>
     * DE: Propranolol.<br>
     * FR: propranolol.<br>
     * IT: Propranololo.<br>
     */
    PROPRANOLOL("372772003",
                "http://snomed.info/sct",
                "Propranolol (substance)",
                "Propranolol",
                "Propranolol",
                "propranolol",
                "Propranololo"),
    /**
     * EN: Propyphenazone.<br>
     * DE: Propyphenazon.<br>
     * FR: propyphénazone.<br>
     * IT: Propifenazone.<br>
     */
    PROPYPHENAZONE("699188007",
                   "http://snomed.info/sct",
                   "Propyphenazone (substance)",
                   "Propyphenazone",
                   "Propyphenazon",
                   "propyphénazone",
                   "Propifenazone"),
    /**
     * EN: Protamine.<br>
     * DE: Protamin.<br>
     * FR: protamine.<br>
     * IT: Protamina.<br>
     */
    PROTAMINE("372630008",
              "http://snomed.info/sct",
              "Protamine (substance)",
              "Protamine",
              "Protamin",
              "protamine",
              "Protamina"),
    /**
     * EN: Protein C.<br>
     * DE: Protein C (human).<br>
     * FR: protéine C humaine.<br>
     * IT: Proteina C (umana).<br>
     */
    PROTEIN_C("25525005",
              "http://snomed.info/sct",
              "Protein C (substance)",
              "Protein C",
              "Protein C (human)",
              "protéine C humaine",
              "Proteina C (umana)"),
    /**
     * EN: Protein S.<br>
     * DE: Protein S (human).<br>
     * FR: protéine S humaine.<br>
     * IT: Proteina S (umana).<br>
     */
    PROTEIN_S("56898001",
              "http://snomed.info/sct",
              "Protein S (substance)",
              "Protein S",
              "Protein S (human)",
              "protéine S humaine",
              "Proteina S (umana)"),
    /**
     * EN: Protionamide.<br>
     * DE: Protionamid.<br>
     * FR: protionamide.<br>
     * IT: Protionamide.<br>
     */
    PROTIONAMIDE("703589003",
                 "http://snomed.info/sct",
                 "Protionamide (substance)",
                 "Protionamide",
                 "Protionamid",
                 "protionamide",
                 "Protionamide"),
    /**
     * EN: Protireline.<br>
     * DE: Protirelin.<br>
     * FR: protiréline.<br>
     * IT: Protirelina.<br>
     */
    PROTIRELINE("412495007",
                "http://snomed.info/sct",
                "Protireline (substance)",
                "Protireline",
                "Protirelin",
                "protiréline",
                "Protirelina"),
    /**
     * EN: Prucalopride.<br>
     * DE: Prucaloprid.<br>
     * FR: prucalopride.<br>
     * IT: Prucalopride.<br>
     */
    PRUCALOPRIDE("699273008",
                 "http://snomed.info/sct",
                 "Prucalopride (substance)",
                 "Prucalopride",
                 "Prucaloprid",
                 "prucalopride",
                 "Prucalopride"),
    /**
     * EN: Pseudoephedrine.<br>
     * DE: Pseudoephedrin.<br>
     * FR: pseudoéphédrine.<br>
     * IT: Pseudoefedrina.<br>
     */
    PSEUDOEPHEDRINE("372900003",
                    "http://snomed.info/sct",
                    "Pseudoephedrine (substance)",
                    "Pseudoephedrine",
                    "Pseudoephedrin",
                    "pseudoéphédrine",
                    "Pseudoefedrina"),
    /**
     * EN: Pyrazinamide.<br>
     * DE: Pyrazinamid.<br>
     * FR: pyrazinamide.<br>
     * IT: Pirazinamide.<br>
     */
    PYRAZINAMIDE("387076005",
                 "http://snomed.info/sct",
                 "Pyrazinamide (substance)",
                 "Pyrazinamide",
                 "Pyrazinamid",
                 "pyrazinamide",
                 "Pirazinamide"),
    /**
     * EN: Pyridostigmine bromide.<br>
     * DE: Pyridostigmin bromid.<br>
     * FR: pyridostigmine bromure.<br>
     * IT: Piridostigmina bromuro.<br>
     */
    PYRIDOSTIGMINE_BROMIDE("34915005",
                           "http://snomed.info/sct",
                           "Pyridostigmine bromide (substance)",
                           "Pyridostigmine bromide",
                           "Pyridostigmin bromid",
                           "pyridostigmine bromure",
                           "Piridostigmina bromuro"),
    /**
     * EN: Pyridoxal phosphate.<br>
     * DE: Pyridoxal-5-phosphat.<br>
     * FR: pyridoxal-5-phosphate.<br>
     * IT: Piridossal fosfato.<br>
     */
    PYRIDOXAL_PHOSPHATE("259663004",
                        "http://snomed.info/sct",
                        "Pyridoxal phosphate (substance)",
                        "Pyridoxal phosphate",
                        "Pyridoxal-5-phosphat",
                        "pyridoxal-5-phosphate",
                        "Piridossal fosfato"),
    /**
     * EN: Pyridoxine.<br>
     * DE: Pyridoxin (Vitamin B6).<br>
     * FR: pyridoxine (Vitamine B6).<br>
     * IT: Piridossina (vitamina B6).<br>
     */
    PYRIDOXINE("430469009",
               "http://snomed.info/sct",
               "Pyridoxine (substance)",
               "Pyridoxine",
               "Pyridoxin (Vitamin B6)",
               "pyridoxine (Vitamine B6)",
               "Piridossina (vitamina B6)"),
    /**
     * EN: Pyrimethamine.<br>
     * DE: Pyrimethamin.<br>
     * FR: pyriméthamine.<br>
     * IT: Pirimetamina.<br>
     */
    PYRIMETHAMINE("373769001",
                  "http://snomed.info/sct",
                  "Pyrimethamine (substance)",
                  "Pyrimethamine",
                  "Pyrimethamin",
                  "pyriméthamine",
                  "Pirimetamina"),
    /**
     * EN: Quetiapine.<br>
     * DE: Quetiapin.<br>
     * FR: quétiapine.<br>
     * IT: Quetiapina.<br>
     */
    QUETIAPINE("386850001",
               "http://snomed.info/sct",
               "Quetiapine (substance)",
               "Quetiapine",
               "Quetiapin",
               "quétiapine",
               "Quetiapina"),
    /**
     * EN: Quinapril.<br>
     * DE: Quinapril.<br>
     * FR: quinapril.<br>
     * IT: Quinapril.<br>
     */
    QUINAPRIL("386874003",
              "http://snomed.info/sct",
              "Quinapril (substance)",
              "Quinapril",
              "Quinapril",
              "quinapril",
              "Quinapril"),
    /**
     * EN: Quinine.<br>
     * DE: Chinin.<br>
     * FR: quinine.<br>
     * IT: Chinina.<br>
     */
    QUININE("373497008",
            "http://snomed.info/sct",
            "Quinine (substance)",
            "Quinine",
            "Chinin",
            "quinine",
            "Chinina"),
    /**
     * EN: Rabeprazole.<br>
     * DE: Rabeprazol.<br>
     * FR: rabéprazole.<br>
     * IT: Rabeprazolo.<br>
     */
    RABEPRAZOLE("422225001",
                "http://snomed.info/sct",
                "Rabeprazole (substance)",
                "Rabeprazole",
                "Rabeprazol",
                "rabéprazole",
                "Rabeprazolo"),
    /**
     * EN: Rabies human immune globulin.<br>
     * DE: Tollwut-Immunglobulin vom Menschen.<br>
     * FR: immunoglobuline humaine anti-rabique.<br>
     * IT: Immunoglobulina umana antirabbica.<br>
     */
    RABIES_HUMAN_IMMUNE_GLOBULIN("422303009",
                                 "http://snomed.info/sct",
                                 "Rabies human immune globulin (substance)",
                                 "Rabies human immune globulin",
                                 "Tollwut-Immunglobulin vom Menschen",
                                 "immunoglobuline humaine anti-rabique",
                                 "Immunoglobulina umana antirabbica"),
    /**
     * EN: Raloxifene.<br>
     * DE: Raloxifen.<br>
     * FR: raloxifène.<br>
     * IT: Raloxifene.<br>
     */
    RALOXIFENE("109029006",
               "http://snomed.info/sct",
               "Raloxifene (substance)",
               "Raloxifene",
               "Raloxifen",
               "raloxifène",
               "Raloxifene"),
    /**
     * EN: Raltegravir.<br>
     * DE: Raltegravir.<br>
     * FR: raltégravir.<br>
     * IT: Raltegravir.<br>
     */
    RALTEGRAVIR("429707008",
                "http://snomed.info/sct",
                "Raltegravir (substance)",
                "Raltegravir",
                "Raltegravir",
                "raltégravir",
                "Raltegravir"),
    /**
     * EN: Raltitrexed.<br>
     * DE: Raltitrexed.<br>
     * FR: raltitrexed.<br>
     * IT: Raltitrexed.<br>
     */
    RALTITREXED("395857008",
                "http://snomed.info/sct",
                "Raltitrexed (substance)",
                "Raltitrexed",
                "Raltitrexed",
                "raltitrexed",
                "Raltitrexed"),
    /**
     * EN: Ramipril.<br>
     * DE: Ramipril.<br>
     * FR: ramipril.<br>
     * IT: Ramipril.<br>
     */
    RAMIPRIL("386872004",
             "http://snomed.info/sct",
             "Ramipril (substance)",
             "Ramipril",
             "Ramipril",
             "ramipril",
             "Ramipril"),
    /**
     * EN: Ramucirumab.<br>
     * DE: Ramucirumab.<br>
     * FR: ramucirumab.<br>
     * IT: Ramucirumab.<br>
     */
    RAMUCIRUMAB("704259004",
                "http://snomed.info/sct",
                "Ramucirumab (substance)",
                "Ramucirumab",
                "Ramucirumab",
                "ramucirumab",
                "Ramucirumab"),
    /**
     * EN: Ranitidine.<br>
     * DE: Ranitidin.<br>
     * FR: ranitidine.<br>
     * IT: Ranitidina.<br>
     */
    RANITIDINE("372755005",
               "http://snomed.info/sct",
               "Ranitidine (substance)",
               "Ranitidine",
               "Ranitidin",
               "ranitidine",
               "Ranitidina"),
    /**
     * EN: Ranolazine.<br>
     * DE: Ranolazin.<br>
     * FR: ranolazine.<br>
     * IT: Ranolazina.<br>
     */
    RANOLAZINE("420365007",
               "http://snomed.info/sct",
               "Ranolazine (substance)",
               "Ranolazine",
               "Ranolazin",
               "ranolazine",
               "Ranolazina"),
    /**
     * EN: Rasagiline.<br>
     * DE: Rasagilin.<br>
     * FR: rasagiline.<br>
     * IT: Rasagilina.<br>
     */
    RASAGILINE("418734001",
               "http://snomed.info/sct",
               "Rasagiline (substance)",
               "Rasagiline",
               "Rasagilin",
               "rasagiline",
               "Rasagilina"),
    /**
     * EN: Rasburicase.<br>
     * DE: Rasburicase.<br>
     * FR: rasburicase.<br>
     * IT: Rasburicase.<br>
     */
    RASBURICASE("395858003",
                "http://snomed.info/sct",
                "Rasburicase (substance)",
                "Rasburicase",
                "Rasburicase",
                "rasburicase",
                "Rasburicase"),
    /**
     * EN: Reboxetine.<br>
     * DE: Reboxetin.<br>
     * FR: réboxétine.<br>
     * IT: Reboxetina.<br>
     */
    REBOXETINE("395859006",
               "http://snomed.info/sct",
               "Reboxetine (substance)",
               "Reboxetine",
               "Reboxetin",
               "réboxétine",
               "Reboxetina"),
    /**
     * EN: Remifentanil.<br>
     * DE: Remifentanil.<br>
     * FR: rémifentanil.<br>
     * IT: Remifentanil.<br>
     */
    REMIFENTANIL("386839004",
                 "http://snomed.info/sct",
                 "Remifentanil (substance)",
                 "Remifentanil",
                 "Remifentanil",
                 "rémifentanil",
                 "Remifentanil"),
    /**
     * EN: Repaglinide.<br>
     * DE: Repaglinid.<br>
     * FR: répaglinide.<br>
     * IT: Repaglinide.<br>
     */
    REPAGLINIDE("386964000",
                "http://snomed.info/sct",
                "Repaglinide (substance)",
                "Repaglinide",
                "Repaglinid",
                "répaglinide",
                "Repaglinide"),
    /**
     * EN: Retigabine.<br>
     * DE: Retigabin.<br>
     * FR: rétigabine.<br>
     * IT: Retigabina.<br>
     */
    RETIGABINE("699271005",
               "http://snomed.info/sct",
               "Retigabine (substance)",
               "Retigabine",
               "Retigabin",
               "rétigabine",
               "Retigabina"),
    /**
     * EN: Retinol.<br>
     * DE: Retinol (Vitamin A).<br>
     * FR: rétinol (Vitamine a).<br>
     * IT: Retinolo (vitamina A).<br>
     */
    RETINOL("82622003",
            "http://snomed.info/sct",
            "Retinol (substance)",
            "Retinol",
            "Retinol (Vitamin A)",
            "rétinol (Vitamine a)",
            "Retinolo (vitamina A)"),
    /**
     * EN: Ribavirin.<br>
     * DE: Ribavirin.<br>
     * FR: ribavirine.<br>
     * IT: Ribavirina.<br>
     */
    RIBAVIRIN("387188005",
              "http://snomed.info/sct",
              "Ribavirin (substance)",
              "Ribavirin",
              "Ribavirin",
              "ribavirine",
              "Ribavirina"),
    /**
     * EN: Riboflavin.<br>
     * DE: Riboflavin (Vitamin B2, E101).<br>
     * FR: riboflavine (Vitamine B2, E101).<br>
     * IT: Riboflavina (vitamina B2, E 101).<br>
     */
    RIBOFLAVIN("13235001",
               "http://snomed.info/sct",
               "Riboflavin (substance)",
               "Riboflavin",
               "Riboflavin (Vitamin B2, E101)",
               "riboflavine (Vitamine B2, E101)",
               "Riboflavina (vitamina B2, E 101)"),
    /**
     * EN: Rifabutin.<br>
     * DE: Rifabutin.<br>
     * FR: rifabutine.<br>
     * IT: Rifabutina.<br>
     */
    RIFABUTIN("386893001",
              "http://snomed.info/sct",
              "Rifabutin (substance)",
              "Rifabutin",
              "Rifabutin",
              "rifabutine",
              "Rifabutina"),
    /**
     * EN: Rifampicin.<br>
     * DE: Rifampicin.<br>
     * FR: rifampicine.<br>
     * IT: Rifampicina.<br>
     */
    RIFAMPICIN("387159009",
               "http://snomed.info/sct",
               "Rifampicin (substance)",
               "Rifampicin",
               "Rifampicin",
               "rifampicine",
               "Rifampicina"),
    /**
     * EN: Rifaximin.<br>
     * DE: Rifaximin.<br>
     * FR: rifaximine.<br>
     * IT: Rifaximina.<br>
     */
    RIFAXIMIN("412553001",
              "http://snomed.info/sct",
              "Rifaximin (substance)",
              "Rifaximin",
              "Rifaximin",
              "rifaximine",
              "Rifaximina"),
    /**
     * EN: Rilpivirine.<br>
     * DE: Rilpivirin.<br>
     * FR: rilpivirine.<br>
     * IT: Rilpivirina.<br>
     */
    RILPIVIRINE("703123005",
                "http://snomed.info/sct",
                "Rilpivirine (substance)",
                "Rilpivirine",
                "Rilpivirin",
                "rilpivirine",
                "Rilpivirina"),
    /**
     * EN: Riluzole.<br>
     * DE: Riluzol.<br>
     * FR: riluzole.<br>
     * IT: Riluzolo.<br>
     */
    RILUZOLE("386980005",
             "http://snomed.info/sct",
             "Riluzole (substance)",
             "Riluzole",
             "Riluzol",
             "riluzole",
             "Riluzolo"),
    /**
     * EN: Rimexolone.<br>
     * DE: Rimexolon.<br>
     * FR: rimexolone.<br>
     * IT: Rimexolone.<br>
     */
    RIMEXOLONE("387046003",
               "http://snomed.info/sct",
               "Rimexolone (substance)",
               "Rimexolone",
               "Rimexolon",
               "rimexolone",
               "Rimexolone"),
    /**
     * EN: Riociguat.<br>
     * DE: Riociguat.<br>
     * FR: riociguat.<br>
     * IT: Riociguat.<br>
     */
    RIOCIGUAT("713333001",
              "http://snomed.info/sct",
              "Riociguat (substance)",
              "Riociguat",
              "Riociguat",
              "riociguat",
              "Riociguat"),
    /**
     * EN: Risedronate sodium.<br>
     * DE: Risedronat natrium.<br>
     * FR: risédronate sodique.<br>
     * IT: Sodio risedronato.<br>
     */
    RISEDRONATE_SODIUM("387064005",
                       "http://snomed.info/sct",
                       "Risedronate sodium (substance)",
                       "Risedronate sodium",
                       "Risedronat natrium",
                       "risédronate sodique",
                       "Sodio risedronato"),
    /**
     * EN: Risedronic acid.<br>
     * DE: Risedronsäure.<br>
     * FR: acide risédronique.<br>
     * IT: Acido risedronico.<br>
     */
    RISEDRONIC_ACID("768539002",
                    "http://snomed.info/sct",
                    "Risedronic acid (substance)",
                    "Risedronic acid",
                    "Risedronsäure",
                    "acide risédronique",
                    "Acido risedronico"),
    /**
     * EN: Risperidone.<br>
     * DE: Risperidon.<br>
     * FR: rispéridone.<br>
     * IT: Risperidone.<br>
     */
    RISPERIDONE("386840002",
                "http://snomed.info/sct",
                "Risperidone (substance)",
                "Risperidone",
                "Risperidon",
                "rispéridone",
                "Risperidone"),
    /**
     * EN: Ritonavir.<br>
     * DE: Ritonavir.<br>
     * FR: ritonavir.<br>
     * IT: Ritonavir.<br>
     */
    RITONAVIR("386896009",
              "http://snomed.info/sct",
              "Ritonavir (substance)",
              "Ritonavir",
              "Ritonavir",
              "ritonavir",
              "Ritonavir"),
    /**
     * EN: Rituximab.<br>
     * DE: Rituximab.<br>
     * FR: rituximab.<br>
     * IT: Rituximab.<br>
     */
    RITUXIMAB("386919002",
              "http://snomed.info/sct",
              "Rituximab (substance)",
              "Rituximab",
              "Rituximab",
              "rituximab",
              "Rituximab"),
    /**
     * EN: Rivaroxaban.<br>
     * DE: Rivaroxaban.<br>
     * FR: rivaroxaban.<br>
     * IT: Rivaroxaban.<br>
     */
    RIVAROXABAN("442031002",
                "http://snomed.info/sct",
                "Rivaroxaban (substance)",
                "Rivaroxaban",
                "Rivaroxaban",
                "rivaroxaban",
                "Rivaroxaban"),
    /**
     * EN: Rivastigmine.<br>
     * DE: Rivastigmin.<br>
     * FR: rivastigmine.<br>
     * IT: Rivastigmina.<br>
     */
    RIVASTIGMINE("395868008",
                 "http://snomed.info/sct",
                 "Rivastigmine (substance)",
                 "Rivastigmine",
                 "Rivastigmin",
                 "rivastigmine",
                 "Rivastigmina"),
    /**
     * EN: Rizatriptan.<br>
     * DE: Rizatriptan.<br>
     * FR: rizatriptan.<br>
     * IT: Rizatriptan.<br>
     */
    RIZATRIPTAN("363573000",
                "http://snomed.info/sct",
                "Rizatriptan (substance)",
                "Rizatriptan",
                "Rizatriptan",
                "rizatriptan",
                "Rizatriptan"),
    /**
     * EN: Rocuronium bromide.<br>
     * DE: Rocuronium bromid.<br>
     * FR: rocuronium bromure.<br>
     * IT: Rocuronio bromuro.<br>
     */
    ROCURONIUM_BROMIDE("108450002",
                       "http://snomed.info/sct",
                       "Rocuronium bromide (substance)",
                       "Rocuronium bromide",
                       "Rocuronium bromid",
                       "rocuronium bromure",
                       "Rocuronio bromuro"),
    /**
     * EN: Roflumilast.<br>
     * DE: Roflumilast.<br>
     * FR: roflumilast.<br>
     * IT: Roflumilast.<br>
     */
    ROFLUMILAST("448971002",
                "http://snomed.info/sct",
                "Roflumilast (substance)",
                "Roflumilast",
                "Roflumilast",
                "roflumilast",
                "Roflumilast"),
    /**
     * EN: Romiplostim.<br>
     * DE: Romiplostim.<br>
     * FR: romiplostim.<br>
     * IT: Romiplostim.<br>
     */
    ROMIPLOSTIM("439122000",
                "http://snomed.info/sct",
                "Romiplostim (substance)",
                "Romiplostim",
                "Romiplostim",
                "romiplostim",
                "Romiplostim"),
    /**
     * EN: Ropinirole.<br>
     * DE: Ropinirol.<br>
     * FR: ropinirole.<br>
     * IT: Ropinirolo.<br>
     */
    ROPINIROLE("372499000",
               "http://snomed.info/sct",
               "Ropinirole (substance)",
               "Ropinirole",
               "Ropinirol",
               "ropinirole",
               "Ropinirolo"),
    /**
     * EN: Ropivacaine.<br>
     * DE: Ropivacain.<br>
     * FR: ropivacaïne.<br>
     * IT: Ropivacaina.<br>
     */
    ROPIVACAINE("386969005",
                "http://snomed.info/sct",
                "Ropivacaine (substance)",
                "Ropivacaine",
                "Ropivacain",
                "ropivacaïne",
                "Ropivacaina"),
    /**
     * EN: Rosuvastatin.<br>
     * DE: Rosuvastatin.<br>
     * FR: rosuvastatine.<br>
     * IT: Rosuvastatina.<br>
     */
    ROSUVASTATIN("700067006",
                 "http://snomed.info/sct",
                 "Rosuvastatin (substance)",
                 "Rosuvastatin",
                 "Rosuvastatin",
                 "rosuvastatine",
                 "Rosuvastatina"),
    /**
     * EN: Rotigotine.<br>
     * DE: Rotigotin.<br>
     * FR: rotigotine.<br>
     * IT: Rotigotina.<br>
     */
    ROTIGOTINE("421924006",
               "http://snomed.info/sct",
               "Rotigotine (substance)",
               "Rotigotine",
               "Rotigotin",
               "rotigotine",
               "Rotigotina"),
    /**
     * EN: Rufinamide.<br>
     * DE: Rufinamid.<br>
     * FR: rufinamide.<br>
     * IT: Rufinamide.<br>
     */
    RUFINAMIDE("429835003",
               "http://snomed.info/sct",
               "Rufinamide (substance)",
               "Rufinamide",
               "Rufinamid",
               "rufinamide",
               "Rufinamide"),
    /**
     * EN: Saccharomyces boulardii.<br>
     * DE: Saccharomyces boulardii.<br>
     * FR: saccharomyces boulardii.<br>
     * IT: Saccharomyces boulardii.<br>
     */
    SACCHAROMYCES_BOULARDII("700441006",
                            "http://snomed.info/sct",
                            "Saccharomyces boulardii (substance)",
                            "Saccharomyces boulardii",
                            "Saccharomyces boulardii",
                            "saccharomyces boulardii",
                            "Saccharomyces boulardii"),
    /**
     * EN: Sacubitril.<br>
     * DE: Sacubitril.<br>
     * FR: sacubitril.<br>
     * IT: Sacubitril.<br>
     */
    SACUBITRIL("716072000",
               "http://snomed.info/sct",
               "Sacubitril (substance)",
               "Sacubitril",
               "Sacubitril",
               "sacubitril",
               "Sacubitril"),
    /**
     * EN: Safinamide.<br>
     * DE: Safinamid.<br>
     * FR: safinamide.<br>
     * IT: Safinamide.<br>
     */
    SAFINAMIDE("718852000",
               "http://snomed.info/sct",
               "Safinamide (substance)",
               "Safinamide",
               "Safinamid",
               "safinamide",
               "Safinamide"),
    /**
     * EN: Salbutamol.<br>
     * DE: Salbutamol.<br>
     * FR: salbutamol.<br>
     * IT: Salbutamolo.<br>
     */
    SALBUTAMOL("372897005",
               "http://snomed.info/sct",
               "Salbutamol (substance)",
               "Salbutamol",
               "Salbutamol",
               "salbutamol",
               "Salbutamolo"),
    /**
     * EN: Salicylamide.<br>
     * DE: Salicylamid.<br>
     * FR: salicylamide.<br>
     * IT: Salicilamide.<br>
     */
    SALICYLAMIDE("22192002",
                 "http://snomed.info/sct",
                 "Salicylamide (substance)",
                 "Salicylamide",
                 "Salicylamid",
                 "salicylamide",
                 "Salicilamide"),
    /**
     * EN: Salicylic acid.<br>
     * DE: Salicylsäure.<br>
     * FR: acide salicylique.<br>
     * IT: Acido salicilico.<br>
     */
    SALICYLIC_ACID("387253001",
                   "http://snomed.info/sct",
                   "Salicylic acid (substance)",
                   "Salicylic acid",
                   "Salicylsäure",
                   "acide salicylique",
                   "Acido salicilico"),
    /**
     * EN: Salmeterol.<br>
     * DE: Salmeterol.<br>
     * FR: salmétérol.<br>
     * IT: Salmeterolo.<br>
     */
    SALMETEROL("372515005",
               "http://snomed.info/sct",
               "Salmeterol (substance)",
               "Salmeterol",
               "Salmeterol",
               "salmétérol",
               "Salmeterolo"),
    /**
     * EN: Sapropterin.<br>
     * DE: Sapropterin.<br>
     * FR: saproptérine.<br>
     * IT: Sapropterina.<br>
     */
    SAPROPTERIN("432859002",
                "http://snomed.info/sct",
                "Sapropterin (substance)",
                "Sapropterin",
                "Sapropterin",
                "saproptérine",
                "Sapropterina"),
    /**
     * EN: Saquinavir.<br>
     * DE: Saquinavir.<br>
     * FR: saquinavir.<br>
     * IT: Saquinavir.<br>
     */
    SAQUINAVIR("372530001",
               "http://snomed.info/sct",
               "Saquinavir (substance)",
               "Saquinavir",
               "Saquinavir",
               "saquinavir",
               "Saquinavir"),
    /**
     * EN: Sarilumab.<br>
     * DE: Sarilumab.<br>
     * FR: sarilumab.<br>
     * IT: Sarilumab.<br>
     */
    SARILUMAB("735231009",
              "http://snomed.info/sct",
              "Sarilumab (substance)",
              "Sarilumab",
              "Sarilumab",
              "sarilumab",
              "Sarilumab"),
    /**
     * EN: Saxagliptin.<br>
     * DE: Saxagliptin.<br>
     * FR: saxagliptine.<br>
     * IT: Saxagliptin.<br>
     */
    SAXAGLIPTIN("443087004",
                "http://snomed.info/sct",
                "Saxagliptin (substance)",
                "Saxagliptin",
                "Saxagliptin",
                "saxagliptine",
                "Saxagliptin"),
    /**
     * EN: Scopolamine.<br>
     * DE: Scopolamin.<br>
     * FR: scopolamine.<br>
     * IT: Scopolamina.<br>
     */
    SCOPOLAMINE("387409009",
                "http://snomed.info/sct",
                "Scopolamine (substance)",
                "Scopolamine",
                "Scopolamin",
                "scopolamine",
                "Scopolamina"),
    /**
     * EN: Scopolamine butylbromide.<br>
     * DE: Scopolamin butylbromid.<br>
     * FR: scopolamine butylbromure.<br>
     * IT: Scopolamina butilbromuro.<br>
     */
    SCOPOLAMINE_BUTYLBROMIDE("395739004",
                             "http://snomed.info/sct",
                             "Scopolamine butylbromide (substance)",
                             "Scopolamine butylbromide",
                             "Scopolamin butylbromid",
                             "scopolamine butylbromure",
                             "Scopolamina butilbromuro"),
    /**
     * EN: Secretin.<br>
     * DE: Secretin.<br>
     * FR: sécrétine.<br>
     * IT: Secretina.<br>
     */
    SECRETIN("19205004",
             "http://snomed.info/sct",
             "Secretin (substance)",
             "Secretin",
             "Secretin",
             "sécrétine",
             "Secretina"),
    /**
     * EN: Secukinumab.<br>
     * DE: Secukinumab.<br>
     * FR: sécukinumab.<br>
     * IT: Secukinumab.<br>
     */
    SECUKINUMAB("708822004",
                "http://snomed.info/sct",
                "Secukinumab (substance)",
                "Secukinumab",
                "Secukinumab",
                "sécukinumab",
                "Secukinumab"),
    /**
     * EN: Serine.<br>
     * DE: L-Serin.<br>
     * FR: l-sérine.<br>
     * IT: Serina.<br>
     */
    SERINE("14125007",
           "http://snomed.info/sct",
           "Serine (substance)",
           "Serine",
           "L-Serin",
           "l-sérine",
           "Serina"),
    /**
     * EN: Sertraline.<br>
     * DE: Sertralin.<br>
     * FR: sertraline.<br>
     * IT: Sertralina.<br>
     */
    SERTRALINE("372594008",
               "http://snomed.info/sct",
               "Sertraline (substance)",
               "Sertraline",
               "Sertralin",
               "sertraline",
               "Sertralina"),
    /**
     * EN: Sevelamer.<br>
     * DE: Sevelamer.<br>
     * FR: sévélamer.<br>
     * IT: Sevelamer.<br>
     */
    SEVELAMER("395871000",
              "http://snomed.info/sct",
              "Sevelamer (substance)",
              "Sevelamer",
              "Sevelamer",
              "sévélamer",
              "Sevelamer"),
    /**
     * EN: Sevoflurane.<br>
     * DE: Sevofluran.<br>
     * FR: sévoflurane.<br>
     * IT: Sevoflurano.<br>
     */
    SEVOFLURANE("386842005",
                "http://snomed.info/sct",
                "Sevoflurane (substance)",
                "Sevoflurane",
                "Sevofluran",
                "sévoflurane",
                "Sevoflurano"),
    /**
     * EN: Sildenafil.<br>
     * DE: Sildenafil.<br>
     * FR: sildénafil.<br>
     * IT: Sildenafil.<br>
     */
    SILDENAFIL("372572000",
               "http://snomed.info/sct",
               "Sildenafil (substance)",
               "Sildenafil",
               "Sildenafil",
               "sildénafil",
               "Sildenafil"),
    /**
     * EN: Silibinin.<br>
     * DE: Silibinin.<br>
     * FR: silibinine.<br>
     * IT: Silibina.<br>
     */
    SILIBININ("720527007",
              "http://snomed.info/sct",
              "Silibinin (substance)",
              "Silibinin",
              "Silibinin",
              "silibinine",
              "Silibina"),
    /**
     * EN: Silodosin.<br>
     * DE: Silodosin.<br>
     * FR: silodosine.<br>
     * IT: Silodosina.<br>
     */
    SILODOSIN("442042006",
              "http://snomed.info/sct",
              "Silodosin (substance)",
              "Silodosin",
              "Silodosin",
              "silodosine",
              "Silodosina"),
    /**
     * EN: Simeticone.<br>
     * DE: Simeticon.<br>
     * FR: siméticone.<br>
     * IT: Simeticone.<br>
     */
    SIMETICONE("387442005",
               "http://snomed.info/sct",
               "Simeticone (substance)",
               "Simeticone",
               "Simeticon",
               "siméticone",
               "Simeticone"),
    /**
     * EN: Simoctocog alfa.<br>
     * DE: Simoctocog alfa.<br>
     * FR: simoctocog alfa.<br>
     * IT: Simoctocog alfa.<br>
     */
    SIMOCTOCOG_ALFA("718853005",
                    "http://snomed.info/sct",
                    "Simoctocog alfa (substance)",
                    "Simoctocog alfa",
                    "Simoctocog alfa",
                    "simoctocog alfa",
                    "Simoctocog alfa"),
    /**
     * EN: Simvastatin.<br>
     * DE: Simvastatin.<br>
     * FR: simvastatine.<br>
     * IT: Simvastatina.<br>
     */
    SIMVASTATIN("387584000",
                "http://snomed.info/sct",
                "Simvastatin (substance)",
                "Simvastatin",
                "Simvastatin",
                "simvastatine",
                "Simvastatina"),
    /**
     * EN: Sirolimus.<br>
     * DE: Sirolimus.<br>
     * FR: sirolimus.<br>
     * IT: Sirolimus.<br>
     */
    SIROLIMUS("387014003",
              "http://snomed.info/sct",
              "Sirolimus (substance)",
              "Sirolimus",
              "Sirolimus",
              "sirolimus",
              "Sirolimus"),
    /**
     * EN: Sitagliptin.<br>
     * DE: Sitagliptin.<br>
     * FR: sitagliptine.<br>
     * IT: Sitagliptin.<br>
     */
    SITAGLIPTIN("423307000",
                "http://snomed.info/sct",
                "Sitagliptin (substance)",
                "Sitagliptin",
                "Sitagliptin",
                "sitagliptine",
                "Sitagliptin"),
    /**
     * EN: Sodium acetate trihydrat.<br>
     * DE: Natrium acetat-3-Wasser.<br>
     * FR: sodium acétate trihydrate.<br>
     * IT: Sodio acetato triidrato.<br>
     */
    SODIUM_ACETATE_TRIHYDRAT("726006002",
                             "http://snomed.info/sct",
                             "Sodium acetate trihydrat (substance)",
                             "Sodium acetate trihydrat",
                             "Natrium acetat-3-Wasser",
                             "sodium acétate trihydrate",
                             "Sodio acetato triidrato"),
    /**
     * EN: Sodium bicarbonate.<br>
     * DE: Natriumhydrogencarbonat.<br>
     * FR: sodium bicarbonate.<br>
     * IT: Bicarbonato di sodio.<br>
     */
    SODIUM_BICARBONATE("387319002",
                       "http://snomed.info/sct",
                       "Sodium bicarbonate (substance)",
                       "Sodium bicarbonate",
                       "Natriumhydrogencarbonat",
                       "sodium bicarbonate",
                       "Bicarbonato di sodio"),
    /**
     * EN: Sodium chloride.<br>
     * DE: Natriumchlorid.<br>
     * FR: sodium chlorure.<br>
     * IT: Sodio cloruro.<br>
     */
    SODIUM_CHLORIDE("387390002",
                    "http://snomed.info/sct",
                    "Sodium chloride (substance)",
                    "Sodium chloride",
                    "Natriumchlorid",
                    "sodium chlorure",
                    "Sodio cloruro"),
    /**
     * EN: Sodium citrate.<br>
     * DE: Natriumcitrat.<br>
     * FR: sodium citrate.<br>
     * IT: Sodio citrato.<br>
     */
    SODIUM_CITRATE("412546005",
                   "http://snomed.info/sct",
                   "Sodium citrate (substance)",
                   "Sodium citrate",
                   "Natriumcitrat",
                   "sodium citrate",
                   "Sodio citrato"),
    /**
     * EN: Sodium dihydrogen phosphate dihydrate.<br>
     * DE: Natrium dihydrogenphosphat-2-Wasser.<br>
     * FR: sodium dihydrogénophosphate dihydrate.<br>
     * IT: Sodio fosfato monobasico diidrato.<br>
     */
    SODIUM_DIHYDROGEN_PHOSPHATE_DIHYDRATE("726716000",
                                          "http://snomed.info/sct",
                                          "Sodium dihydrogen phosphate dihydrate (substance)",
                                          "Sodium dihydrogen phosphate dihydrate",
                                          "Natrium dihydrogenphosphat-2-Wasser",
                                          "sodium dihydrogénophosphate dihydrate",
                                          "Sodio fosfato monobasico diidrato"),
    /**
     * EN: Sodium hydroxide.<br>
     * DE: Natriumhydroxid.<br>
     * FR: sodium hydroxyde.<br>
     * IT: Sodio idrossido.<br>
     */
    SODIUM_HYDROXIDE("23423003",
                     "http://snomed.info/sct",
                     "Sodium hydroxide (substance)",
                     "Sodium hydroxide",
                     "Natriumhydroxid",
                     "sodium hydroxyde",
                     "Sodio idrossido"),
    /**
     * EN: Sodium nitroprusside.<br>
     * DE: Nitroprussidnatrium, wasserfrei.<br>
     * FR: nitroprussiate de sodium anhydre.<br>
     * IT: Sodio nitroprussiato.<br>
     */
    SODIUM_NITROPRUSSIDE("387139005",
                         "http://snomed.info/sct",
                         "Sodium nitroprusside (substance)",
                         "Sodium nitroprusside",
                         "Nitroprussidnatrium, wasserfrei",
                         "nitroprussiate de sodium anhydre",
                         "Sodio nitroprussiato"),
    /**
     * EN: Sodium picosulfate.<br>
     * DE: Natrium picosulfat.<br>
     * FR: picosulfate sodique.<br>
     * IT: Sodio picosolfato.<br>
     */
    SODIUM_PICOSULFATE("395881001",
                       "http://snomed.info/sct",
                       "Sodium picosulfate (substance)",
                       "Sodium picosulfate",
                       "Natrium picosulfat",
                       "picosulfate sodique",
                       "Sodio picosolfato"),
    /**
     * EN: Sodium selenite.<br>
     * DE: Dinatrium-selenit.<br>
     * FR: sélénite disodique.<br>
     * IT: Sodio selenito.<br>
     */
    SODIUM_SELENITE("96277001",
                    "http://snomed.info/sct",
                    "Sodium selenite (substance)",
                    "Sodium selenite",
                    "Dinatrium-selenit",
                    "sélénite disodique",
                    "Sodio selenito"),
    /**
     * EN: Sodium thiosulfate.<br>
     * DE: Dinatrium-thiosulfat.<br>
     * FR: sodium thiosulfate.<br>
     * IT: Sodio tiosolfato.<br>
     */
    SODIUM_THIOSULFATE("387209006",
                       "http://snomed.info/sct",
                       "Sodium thiosulfate (substance)",
                       "Sodium thiosulfate",
                       "Dinatrium-thiosulfat",
                       "sodium thiosulfate",
                       "Sodio tiosolfato"),
    /**
     * EN: Sofosbuvir.<br>
     * DE: Sofosbuvir.<br>
     * FR: sofosbuvir.<br>
     * IT: Sofosbuvir.<br>
     */
    SOFOSBUVIR("710806008",
               "http://snomed.info/sct",
               "Sofosbuvir (substance)",
               "Sofosbuvir",
               "Sofosbuvir",
               "sofosbuvir",
               "Sofosbuvir"),
    /**
     * EN: Solifenacin.<br>
     * DE: Solifenacin.<br>
     * FR: solifénacine.<br>
     * IT: Solifenacina.<br>
     */
    SOLIFENACIN("407030007",
                "http://snomed.info/sct",
                "Solifenacin (substance)",
                "Solifenacin",
                "Solifenacin",
                "solifénacine",
                "Solifenacina"),
    /**
     * EN: Somatostatin.<br>
     * DE: Somatostatin.<br>
     * FR: somatostatine.<br>
     * IT: Somatostatina.<br>
     */
    SOMATOSTATIN("49722008",
                 "http://snomed.info/sct",
                 "Somatostatin (substance)",
                 "Somatostatin",
                 "Somatostatin",
                 "somatostatine",
                 "Somatostatina"),
    /**
     * EN: Somatotropin releasing factor.<br>
     * DE: Somatorelin.<br>
     * FR: somatoréline.<br>
     * IT: Somatorelina.<br>
     */
    SOMATOTROPIN_RELEASING_FACTOR("16628008",
                                  "http://snomed.info/sct",
                                  "Somatotropin releasing factor (substance)",
                                  "Somatotropin releasing factor",
                                  "Somatorelin",
                                  "somatoréline",
                                  "Somatorelina"),
    /**
     * EN: Somatropin.<br>
     * DE: Somatropin.<br>
     * FR: somatropine.<br>
     * IT: Somatropina.<br>
     */
    SOMATROPIN("395883003",
               "http://snomed.info/sct",
               "Somatropin (substance)",
               "Somatropin",
               "Somatropin",
               "somatropine",
               "Somatropina"),
    /**
     * EN: Sorafenib.<br>
     * DE: Sorafenib.<br>
     * FR: sorafénib.<br>
     * IT: Sorafenib.<br>
     */
    SORAFENIB("422042001",
              "http://snomed.info/sct",
              "Sorafenib (substance)",
              "Sorafenib",
              "Sorafenib",
              "sorafénib",
              "Sorafenib"),
    /**
     * EN: Sotalol.<br>
     * DE: Sotalol.<br>
     * FR: sotalol.<br>
     * IT: Sotalolo.<br>
     */
    SOTALOL("372911006",
            "http://snomed.info/sct",
            "Sotalol (substance)",
            "Sotalol",
            "Sotalol",
            "sotalol",
            "Sotalolo"),
    /**
     * EN: Soy bean oil.<br>
     * DE: Sojabohnenöl.<br>
     * FR: soja fèves huile.<br>
     * IT: Soia olio.<br>
     */
    SOY_BEAN_OIL("226911007",
                 "http://snomed.info/sct",
                 "Soy bean oil (substance)",
                 "Soy bean oil",
                 "Sojabohnenöl",
                 "soja fèves huile",
                 "Soia olio"),
    /**
     * EN: Spironolactone.<br>
     * DE: Spironolacton.<br>
     * FR: spironolactone.<br>
     * IT: Spironolattone.<br>
     */
    SPIRONOLACTONE("387078006",
                   "http://snomed.info/sct",
                   "Spironolactone (substance)",
                   "Spironolactone",
                   "Spironolacton",
                   "spironolactone",
                   "Spironolattone"),
    /**
     * EN: Stiripentol.<br>
     * DE: Stiripentol.<br>
     * FR: stiripentol.<br>
     * IT: Stiripentolo.<br>
     */
    STIRIPENTOL("428221002",
                "http://snomed.info/sct",
                "Stiripentol (substance)",
                "Stiripentol",
                "Stiripentol",
                "stiripentol",
                "Stiripentolo"),
    /**
     * EN: Substance with protease mechanism of action.<br>
     * DE: Protease.<br>
     * FR: protéase.<br>
     * IT: Proteasi.<br>
     */
    SUBSTANCE_WITH_PROTEASE_MECHANISM_OF_ACTION("387033008",
                                                "http://snomed.info/sct",
                                                "Substance with protease mechanism of action (substance)",
                                                "Substance with protease mechanism of action",
                                                "Protease",
                                                "protéase",
                                                "Proteasi"),
    /**
     * EN: Succinylcholine chloride.<br>
     * DE: Suxamethonium chlorid.<br>
     * FR: suxaméthonium chlorure.<br>
     * IT: Succinilcolina cloruro.<br>
     */
    SUCCINYLCHOLINE_CHLORIDE("58907007",
                             "http://snomed.info/sct",
                             "Succinylcholine chloride (substance)",
                             "Succinylcholine chloride",
                             "Suxamethonium chlorid",
                             "suxaméthonium chlorure",
                             "Succinilcolina cloruro"),
    /**
     * EN: Sufentanil.<br>
     * DE: Sufentanil.<br>
     * FR: sufentanil.<br>
     * IT: Sufentanil.<br>
     */
    SUFENTANIL("49998007",
               "http://snomed.info/sct",
               "Sufentanil (substance)",
               "Sufentanil",
               "Sufentanil",
               "sufentanil",
               "Sufentanil"),
    /**
     * EN: Sugammadex.<br>
     * DE: Sugammadex.<br>
     * FR: sugammadex.<br>
     * IT: Sugammadex.<br>
     */
    SUGAMMADEX("442340006",
               "http://snomed.info/sct",
               "Sugammadex (substance)",
               "Sugammadex",
               "Sugammadex",
               "sugammadex",
               "Sugammadex"),
    /**
     * EN: Sulfadiazine.<br>
     * DE: Sulfadiazin.<br>
     * FR: sulfadiazine.<br>
     * IT: Sulfadiazina.<br>
     */
    SULFADIAZINE("74523009",
                 "http://snomed.info/sct",
                 "Sulfadiazine (substance)",
                 "Sulfadiazine",
                 "Sulfadiazin",
                 "sulfadiazine",
                 "Sulfadiazina"),
    /**
     * EN: Sulfamethoxazole.<br>
     * DE: Sulfamethoxazol.<br>
     * FR: sulfaméthoxazole.<br>
     * IT: Sulfametossazolo.<br>
     */
    SULFAMETHOXAZOLE("363528007",
                     "http://snomed.info/sct",
                     "Sulfamethoxazole (substance)",
                     "Sulfamethoxazole",
                     "Sulfamethoxazol",
                     "sulfaméthoxazole",
                     "Sulfametossazolo"),
    /**
     * EN: Sulfasalazine.<br>
     * DE: Sulfasalazin.<br>
     * FR: sulfasalazine.<br>
     * IT: Sulfasalazina.<br>
     */
    SULFASALAZINE("387248006",
                  "http://snomed.info/sct",
                  "Sulfasalazine (substance)",
                  "Sulfasalazine",
                  "Sulfasalazin",
                  "sulfasalazine",
                  "Sulfasalazina"),
    /**
     * EN: Sulfur hexafluoride.<br>
     * DE: Schwefelhexafluorid.<br>
     * FR: soufre hexafluorure.<br>
     * IT: Zolfo esafluoruro.<br>
     */
    SULFUR_HEXAFLUORIDE("259276004",
                        "http://snomed.info/sct",
                        "Sulfur hexafluoride (substance)",
                        "Sulfur hexafluoride",
                        "Schwefelhexafluorid",
                        "soufre hexafluorure",
                        "Zolfo esafluoruro"),
    /**
     * EN: Sulpiride.<br>
     * DE: Sulpirid.<br>
     * FR: sulpiride.<br>
     * IT: Sulpiride.<br>
     */
    SULPIRIDE("395891007",
              "http://snomed.info/sct",
              "Sulpiride (substance)",
              "Sulpiride",
              "Sulpirid",
              "sulpiride",
              "Sulpiride"),
    /**
     * EN: Sulprostone.<br>
     * DE: Sulproston.<br>
     * FR: sulprostone.<br>
     * IT: Sulprostone.<br>
     */
    SULPROSTONE("713461008",
                "http://snomed.info/sct",
                "Sulprostone (substance)",
                "Sulprostone",
                "Sulproston",
                "sulprostone",
                "Sulprostone"),
    /**
     * EN: Sulthiamine.<br>
     * DE: Sultiam.<br>
     * FR: sultiame.<br>
     * IT: Sultiame.<br>
     */
    SULTHIAMINE("50580004",
                "http://snomed.info/sct",
                "Sulthiamine (substance)",
                "Sulthiamine",
                "Sultiam",
                "sultiame",
                "Sultiame"),
    /**
     * EN: Sumatriptan.<br>
     * DE: Sumatriptan.<br>
     * FR: sumatriptan.<br>
     * IT: Sumatriptan.<br>
     */
    SUMATRIPTAN("395892000",
                "http://snomed.info/sct",
                "Sumatriptan (substance)",
                "Sumatriptan",
                "Sumatriptan",
                "sumatriptan",
                "Sumatriptan"),
    /**
     * EN: Tacrolimus.<br>
     * DE: Tacrolimus.<br>
     * FR: tacrolimus.<br>
     * IT: Tacrolimus.<br>
     */
    TACROLIMUS("386975001",
               "http://snomed.info/sct",
               "Tacrolimus (substance)",
               "Tacrolimus",
               "Tacrolimus",
               "tacrolimus",
               "Tacrolimus"),
    /**
     * EN: Tadalafil.<br>
     * DE: Tadalafil.<br>
     * FR: tadalafil.<br>
     * IT: Tadalafil.<br>
     */
    TADALAFIL("407111005",
              "http://snomed.info/sct",
              "Tadalafil (substance)",
              "Tadalafil",
              "Tadalafil",
              "tadalafil",
              "Tadalafil"),
    /**
     * EN: Tafluprost.<br>
     * DE: Tafluprost.<br>
     * FR: tafluprost.<br>
     * IT: Tafluprost.<br>
     */
    TAFLUPROST("699181001",
               "http://snomed.info/sct",
               "Tafluprost (substance)",
               "Tafluprost",
               "Tafluprost",
               "tafluprost",
               "Tafluprost"),
    /**
     * EN: Tamoxifen.<br>
     * DE: Tamoxifen.<br>
     * FR: tamoxifène.<br>
     * IT: Tamoxifene.<br>
     */
    TAMOXIFEN("373345002",
              "http://snomed.info/sct",
              "Tamoxifen (substance)",
              "Tamoxifen",
              "Tamoxifen",
              "tamoxifène",
              "Tamoxifene"),
    /**
     * EN: Tamsulosin.<br>
     * DE: Tamsulosin.<br>
     * FR: tamsulosine.<br>
     * IT: Tamsulosina.<br>
     */
    TAMSULOSIN("372509005",
               "http://snomed.info/sct",
               "Tamsulosin (substance)",
               "Tamsulosin",
               "Tamsulosin",
               "tamsulosine",
               "Tamsulosina"),
    /**
     * EN: Tapentadol.<br>
     * DE: Tapentadol.<br>
     * FR: tapentadol.<br>
     * IT: Tapentadolo.<br>
     */
    TAPENTADOL("441757005",
               "http://snomed.info/sct",
               "Tapentadol (substance)",
               "Tapentadol",
               "Tapentadol",
               "tapentadol",
               "Tapentadolo"),
    /**
     * EN: Taurine.<br>
     * DE: Taurin.<br>
     * FR: taurine.<br>
     * IT: Taurina.<br>
     */
    TAURINE("10944007",
            "http://snomed.info/sct",
            "Taurine (substance)",
            "Taurine",
            "Taurin",
            "taurine",
            "Taurina"),
    /**
     * EN: Tazobactam.<br>
     * DE: Tazobactam.<br>
     * FR: tazobactam.<br>
     * IT: Tazobactam.<br>
     */
    TAZOBACTAM("96007008",
               "http://snomed.info/sct",
               "Tazobactam (substance)",
               "Tazobactam",
               "Tazobactam",
               "tazobactam",
               "Tazobactam"),
    /**
     * EN: Teicoplanin.<br>
     * DE: Teicoplanin.<br>
     * FR: téicoplanine.<br>
     * IT: Teicoplanina.<br>
     */
    TEICOPLANIN("387529008",
                "http://snomed.info/sct",
                "Teicoplanin (substance)",
                "Teicoplanin",
                "Teicoplanin",
                "téicoplanine",
                "Teicoplanina"),
    /**
     * EN: Telmisartan.<br>
     * DE: Telmisartan.<br>
     * FR: telmisartan.<br>
     * IT: Telmisartan.<br>
     */
    TELMISARTAN("387069000",
                "http://snomed.info/sct",
                "Telmisartan (substance)",
                "Telmisartan",
                "Telmisartan",
                "telmisartan",
                "Telmisartan"),
    /**
     * EN: Temazepam.<br>
     * DE: Temazepam.<br>
     * FR: témazépam.<br>
     * IT: Temazepam.<br>
     */
    TEMAZEPAM("387300007",
              "http://snomed.info/sct",
              "Temazepam (substance)",
              "Temazepam",
              "Temazepam",
              "témazépam",
              "Temazepam"),
    /**
     * EN: Temozolomide.<br>
     * DE: Temozolomid.<br>
     * FR: témozolomide.<br>
     * IT: Temozolomide.<br>
     */
    TEMOZOLOMIDE("387009002",
                 "http://snomed.info/sct",
                 "Temozolomide (substance)",
                 "Temozolomide",
                 "Temozolomid",
                 "témozolomide",
                 "Temozolomide"),
    /**
     * EN: Tenofovir.<br>
     * DE: Tenofovir.<br>
     * FR: ténofovir.<br>
     * IT: Tenofovir.<br>
     */
    TENOFOVIR("422091007",
              "http://snomed.info/sct",
              "Tenofovir (substance)",
              "Tenofovir",
              "Tenofovir",
              "ténofovir",
              "Tenofovir"),
    /**
     * EN: Terbinafine.<br>
     * DE: Terbinafin.<br>
     * FR: terbinafine.<br>
     * IT: Terbinafina.<br>
     */
    TERBINAFINE("373450007",
                "http://snomed.info/sct",
                "Terbinafine (substance)",
                "Terbinafine",
                "Terbinafin",
                "terbinafine",
                "Terbinafina"),
    /**
     * EN: Terbutaline sulfate.<br>
     * DE: Terbutalin sulfat.<br>
     * FR: terbutaline sulfate.<br>
     * IT: Terbutalina.<br>
     */
    TERBUTALINE_SULFATE("24583009",
                        "http://snomed.info/sct",
                        "Terbutaline sulfate (substance)",
                        "Terbutaline sulfate",
                        "Terbutalin sulfat",
                        "terbutaline sulfate",
                        "Terbutalina"),
    /**
     * EN: Teriparatide.<br>
     * DE: Teriparatid.<br>
     * FR: tériparatide.<br>
     * IT: Teriparatide.<br>
     */
    TERIPARATIDE("425438001",
                 "http://snomed.info/sct",
                 "Teriparatide (substance)",
                 "Teriparatide",
                 "Teriparatid",
                 "tériparatide",
                 "Teriparatide"),
    /**
     * EN: Terlipressin.<br>
     * DE: Terlipressin.<br>
     * FR: terlipressine.<br>
     * IT: Terlipressina.<br>
     */
    TERLIPRESSIN("395899009",
                 "http://snomed.info/sct",
                 "Terlipressin (substance)",
                 "Terlipressin",
                 "Terlipressin",
                 "terlipressine",
                 "Terlipressina"),
    /**
     * EN: Testosterone.<br>
     * DE: Testosteron.<br>
     * FR: testostérone.<br>
     * IT: Testosterone.<br>
     */
    TESTOSTERONE("43688007",
                 "http://snomed.info/sct",
                 "Testosterone (substance)",
                 "Testosterone",
                 "Testosteron",
                 "testostérone",
                 "Testosterone"),
    /**
     * EN: Tetanus immunoglobulin of human origin.<br>
     * DE: Tetanus-Immunglobulin vom Menschen.<br>
     * FR: immunoglobuline humaine anti-tétanique.<br>
     * IT: Immunoglobulina umana antitetanica.<br>
     */
    TETANUS_IMMUNOGLOBULIN_OF_HUMAN_ORIGIN("428527002",
                                           "http://snomed.info/sct",
                                           "Tetanus immunoglobulin of human origin (substance)",
                                           "Tetanus immunoglobulin of human origin",
                                           "Tetanus-Immunglobulin vom Menschen",
                                           "immunoglobuline humaine anti-tétanique",
                                           "Immunoglobulina umana antitetanica"),
    /**
     * EN: Tetracaine.<br>
     * DE: Tetracain.<br>
     * FR: tétracaïne.<br>
     * IT: Tetracaina.<br>
     */
    TETRACAINE("387309008",
               "http://snomed.info/sct",
               "Tetracaine (substance)",
               "Tetracaine",
               "Tetracain",
               "tétracaïne",
               "Tetracaina"),
    /**
     * EN: Tetracosactide.<br>
     * DE: Tetracosactid.<br>
     * FR: tétracosactide.<br>
     * IT: Tetracosactide.<br>
     */
    TETRACOSACTIDE("96363002",
                   "http://snomed.info/sct",
                   "Tetracosactide (substance)",
                   "Tetracosactide",
                   "Tetracosactid",
                   "tétracosactide",
                   "Tetracosactide"),
    /**
     * EN: Tetracycline.<br>
     * DE: Tetracyclin.<br>
     * FR: tétracycline.<br>
     * IT: Tetraciclina.<br>
     */
    TETRACYCLINE("372809001",
                 "http://snomed.info/sct",
                 "Tetracycline (substance)",
                 "Tetracycline",
                 "Tetracyclin",
                 "tétracycline",
                 "Tetraciclina"),
    /**
     * EN: Tetryzoline.<br>
     * DE: Tetryzolin.<br>
     * FR: tétryzoline.<br>
     * IT: Tetrizolina.<br>
     */
    TETRYZOLINE("372673004",
                "http://snomed.info/sct",
                "Tetryzoline (substance)",
                "Tetryzoline",
                "Tetryzolin",
                "tétryzoline",
                "Tetrizolina"),
    /**
     * EN: Theophylline.<br>
     * DE: Theophyllin.<br>
     * FR: théophylline.<br>
     * IT: Teofillina.<br>
     */
    THEOPHYLLINE("372810006",
                 "http://snomed.info/sct",
                 "Theophylline (substance)",
                 "Theophylline",
                 "Theophyllin",
                 "théophylline",
                 "Teofillina"),
    /**
     * EN: Thiamine.<br>
     * DE: Thiamin (Vitamin B1).<br>
     * FR: thiamine (Vitamine B1).<br>
     * IT: Tiamina (vitamina B1).<br>
     */
    THIAMINE("259659006",
             "http://snomed.info/sct",
             "Thiamine (substance)",
             "Thiamine",
             "Thiamin (Vitamin B1)",
             "thiamine (Vitamine B1)",
             "Tiamina (vitamina B1)"),
    /**
     * EN: Thiotepa.<br>
     * DE: Thiotepa.<br>
     * FR: thiotépa.<br>
     * IT: Tiotepa.<br>
     */
    THIOTEPA("387508004",
             "http://snomed.info/sct",
             "Thiotepa (substance)",
             "Thiotepa",
             "Thiotepa",
             "thiotépa",
             "Tiotepa"),
    /**
     * EN: Threonine.<br>
     * DE: Threonin.<br>
     * FR: thréonine.<br>
     * IT: Treonina.<br>
     */
    THREONINE("52736009",
              "http://snomed.info/sct",
              "Threonine (substance)",
              "Threonine",
              "Threonin",
              "thréonine",
              "Treonina"),
    /**
     * EN: Tiapride.<br>
     * DE: Tiaprid.<br>
     * FR: tiapride.<br>
     * IT: Tiapride.<br>
     */
    TIAPRIDE("699180000",
             "http://snomed.info/sct",
             "Tiapride (substance)",
             "Tiapride",
             "Tiaprid",
             "tiapride",
             "Tiapride"),
    /**
     * EN: Tibolone.<br>
     * DE: Tibolon.<br>
     * FR: tibolone.<br>
     * IT: Tibolone.<br>
     */
    TIBOLONE("395903002",
             "http://snomed.info/sct",
             "Tibolone (substance)",
             "Tibolone",
             "Tibolon",
             "tibolone",
             "Tibolone"),
    /**
     * EN: Ticagrelor.<br>
     * DE: Ticagrelor.<br>
     * FR: ticagrélor.<br>
     * IT: Ticagrelor.<br>
     */
    TICAGRELOR("698805004",
               "http://snomed.info/sct",
               "Ticagrelor (substance)",
               "Ticagrelor",
               "Ticagrelor",
               "ticagrélor",
               "Ticagrelor"),
    /**
     * EN: Tigecycline.<br>
     * DE: Tigecyclin.<br>
     * FR: tigécycline.<br>
     * IT: Tigeciclina.<br>
     */
    TIGECYCLINE("418313005",
                "http://snomed.info/sct",
                "Tigecycline (substance)",
                "Tigecycline",
                "Tigecyclin",
                "tigécycline",
                "Tigeciclina"),
    /**
     * EN: Tilidine hydrochloride.<br>
     * DE: Tilidin hydrochlorid.<br>
     * FR: tilidine chlorhydrate.<br>
     * IT: Tilidina cloridrato.<br>
     */
    TILIDINE_HYDROCHLORIDE("96186004",
                           "http://snomed.info/sct",
                           "Tilidine hydrochloride (substance)",
                           "Tilidine hydrochloride",
                           "Tilidin hydrochlorid",
                           "tilidine chlorhydrate",
                           "Tilidina cloridrato"),
    /**
     * EN: Timolol.<br>
     * DE: Timolol.<br>
     * FR: timolol.<br>
     * IT: Timololo.<br>
     */
    TIMOLOL("372880004",
            "http://snomed.info/sct",
            "Timolol (substance)",
            "Timolol",
            "Timolol",
            "timolol",
            "Timololo"),
    /**
     * EN: Tioguanine.<br>
     * DE: Tioguanin.<br>
     * FR: tioguanine.<br>
     * IT: Tioguanina.<br>
     */
    TIOGUANINE("387407006",
               "http://snomed.info/sct",
               "Tioguanine (substance)",
               "Tioguanine",
               "Tioguanin",
               "tioguanine",
               "Tioguanina"),
    /**
     * EN: Tiotropium.<br>
     * DE: Tiotropium.<br>
     * FR: tiotropium.<br>
     * IT: Tiotropio.<br>
     */
    TIOTROPIUM("409169006",
               "http://snomed.info/sct",
               "Tiotropium (substance)",
               "Tiotropium",
               "Tiotropium",
               "tiotropium",
               "Tiotropio"),
    /**
     * EN: Tipranavir.<br>
     * DE: Tipranavir.<br>
     * FR: tipranavir.<br>
     * IT: Tipranavir.<br>
     */
    TIPRANAVIR("419409009",
               "http://snomed.info/sct",
               "Tipranavir (substance)",
               "Tipranavir",
               "Tipranavir",
               "tipranavir",
               "Tipranavir"),
    /**
     * EN: Tizanidine.<br>
     * DE: Tizanidin.<br>
     * FR: tizanidine.<br>
     * IT: Tizanidina.<br>
     */
    TIZANIDINE("373440006",
               "http://snomed.info/sct",
               "Tizanidine (substance)",
               "Tizanidine",
               "Tizanidin",
               "tizanidine",
               "Tizanidina"),
    /**
     * EN: Tobramycine.<br>
     * DE: Tobramycin.<br>
     * FR: tobramycine.<br>
     * IT: Tobramicina.<br>
     */
    TOBRAMYCINE("373548001",
                "http://snomed.info/sct",
                "Tobramycine (substance)",
                "Tobramycine",
                "Tobramycin",
                "tobramycine",
                "Tobramicina"),
    /**
     * EN: Tocilizumab.<br>
     * DE: Tocilizumab.<br>
     * FR: tocilizumab.<br>
     * IT: Tocilizumab.<br>
     */
    TOCILIZUMAB("444648007",
                "http://snomed.info/sct",
                "Tocilizumab (substance)",
                "Tocilizumab",
                "Tocilizumab",
                "tocilizumab",
                "Tocilizumab"),
    /**
     * EN: Tolcapone.<br>
     * DE: Tolcapon.<br>
     * FR: tolcapone.<br>
     * IT: Tolcapone.<br>
     */
    TOLCAPONE("386851002",
              "http://snomed.info/sct",
              "Tolcapone (substance)",
              "Tolcapone",
              "Tolcapon",
              "tolcapone",
              "Tolcapone"),
    /**
     * EN: Tolperisone.<br>
     * DE: Tolperison.<br>
     * FR: tolpérisone.<br>
     * IT: Tolperisone.<br>
     */
    TOLPERISONE("703717006",
                "http://snomed.info/sct",
                "Tolperisone (substance)",
                "Tolperisone",
                "Tolperison",
                "tolpérisone",
                "Tolperisone"),
    /**
     * EN: Tolterodine.<br>
     * DE: Tolterodin.<br>
     * FR: toltérodine.<br>
     * IT: Tolterodina.<br>
     */
    TOLTERODINE("372570008",
                "http://snomed.info/sct",
                "Tolterodine (substance)",
                "Tolterodine",
                "Tolterodin",
                "toltérodine",
                "Tolterodina"),
    /**
     * EN: Tolvaptan.<br>
     * DE: Tolvaptan.<br>
     * FR: tolvaptan.<br>
     * IT: Tolvaptan.<br>
     */
    TOLVAPTAN("443058000",
              "http://snomed.info/sct",
              "Tolvaptan (substance)",
              "Tolvaptan",
              "Tolvaptan",
              "tolvaptan",
              "Tolvaptan"),
    /**
     * EN: Topiramate.<br>
     * DE: Topiramat.<br>
     * FR: topiramate.<br>
     * IT: Topiramato.<br>
     */
    TOPIRAMATE("386844006",
               "http://snomed.info/sct",
               "Topiramate (substance)",
               "Topiramate",
               "Topiramat",
               "topiramate",
               "Topiramato"),
    /**
     * EN: Topotecan.<br>
     * DE: Topotecan.<br>
     * FR: topotécan.<br>
     * IT: Topotecan.<br>
     */
    TOPOTECAN("372536007",
              "http://snomed.info/sct",
              "Topotecan (substance)",
              "Topotecan",
              "Topotecan",
              "topotécan",
              "Topotecan"),
    /**
     * EN: Torasemide.<br>
     * DE: Torasemid.<br>
     * FR: torasémide.<br>
     * IT: Torasemide.<br>
     */
    TORASEMIDE("108476002",
               "http://snomed.info/sct",
               "Torasemide (substance)",
               "Torasemide",
               "Torasemid",
               "torasémide",
               "Torasemide"),
    /**
     * EN: Trabectedin.<br>
     * DE: Trabectedin.<br>
     * FR: trabectédine.<br>
     * IT: Trabectedina.<br>
     */
    TRABECTEDIN("433127001",
                "http://snomed.info/sct",
                "Trabectedin (substance)",
                "Trabectedin",
                "Trabectedin",
                "trabectédine",
                "Trabectedina"),
    /**
     * EN: Tramadol.<br>
     * DE: Tramadol.<br>
     * FR: tramadol.<br>
     * IT: Tramadol.<br>
     */
    TRAMADOL("386858008",
             "http://snomed.info/sct",
             "Tramadol (substance)",
             "Tramadol",
             "Tramadol",
             "tramadol",
             "Tramadol"),
    /**
     * EN: Trametinib.<br>
     * DE: Trametinib.<br>
     * FR: tramétinib.<br>
     * IT: Trametinib.<br>
     */
    TRAMETINIB("708711009",
               "http://snomed.info/sct",
               "Trametinib (substance)",
               "Trametinib",
               "Trametinib",
               "tramétinib",
               "Trametinib"),
    /**
     * EN: Trandolapril.<br>
     * DE: Trandolapril.<br>
     * FR: trandolapril.<br>
     * IT: Trandolapril.<br>
     */
    TRANDOLAPRIL("386871006",
                 "http://snomed.info/sct",
                 "Trandolapril (substance)",
                 "Trandolapril",
                 "Trandolapril",
                 "trandolapril",
                 "Trandolapril"),
    /**
     * EN: Tranexamic acid.<br>
     * DE: Tranexamsäure.<br>
     * FR: acide tranexamique.<br>
     * IT: Acido tranexamico.<br>
     */
    TRANEXAMIC_ACID("386960009",
                    "http://snomed.info/sct",
                    "Tranexamic acid (substance)",
                    "Tranexamic acid",
                    "Tranexamsäure",
                    "acide tranexamique",
                    "Acido tranexamico"),
    /**
     * EN: Tranylcypromine.<br>
     * DE: Tranylcypromin.<br>
     * FR: tranylcypromine.<br>
     * IT: Tranilcipromina.<br>
     */
    TRANYLCYPROMINE("372891006",
                    "http://snomed.info/sct",
                    "Tranylcypromine (substance)",
                    "Tranylcypromine",
                    "Tranylcypromin",
                    "tranylcypromine",
                    "Tranilcipromina"),
    /**
     * EN: Trastuzumab.<br>
     * DE: Trastuzumab.<br>
     * FR: trastuzumab.<br>
     * IT: Trastuzumab.<br>
     */
    TRASTUZUMAB("387003001",
                "http://snomed.info/sct",
                "Trastuzumab (substance)",
                "Trastuzumab",
                "Trastuzumab",
                "trastuzumab",
                "Trastuzumab"),
    /**
     * EN: Travoprost.<br>
     * DE: Travoprost.<br>
     * FR: travoprost.<br>
     * IT: Travoprost.<br>
     */
    TRAVOPROST("129493000",
               "http://snomed.info/sct",
               "Travoprost (substance)",
               "Travoprost",
               "Travoprost",
               "travoprost",
               "Travoprost"),
    /**
     * EN: Trazodone.<br>
     * DE: Trazodon.<br>
     * FR: trazodone.<br>
     * IT: Trazodone.<br>
     */
    TRAZODONE("372829000",
              "http://snomed.info/sct",
              "Trazodone (substance)",
              "Trazodone",
              "Trazodon",
              "trazodone",
              "Trazodone"),
    /**
     * EN: Treprostinil.<br>
     * DE: Treprostinil.<br>
     * FR: tréprostinil.<br>
     * IT: Treprostinil.<br>
     */
    TREPROSTINIL("443570007",
                 "http://snomed.info/sct",
                 "Treprostinil (substance)",
                 "Treprostinil",
                 "Treprostinil",
                 "tréprostinil",
                 "Treprostinil"),
    /**
     * EN: Tretinoin.<br>
     * DE: Tretinoin.<br>
     * FR: trétinoïne.<br>
     * IT: Tretinoina.<br>
     */
    TRETINOIN("387305002",
              "http://snomed.info/sct",
              "Tretinoin (substance)",
              "Tretinoin",
              "Tretinoin",
              "trétinoïne",
              "Tretinoina"),
    /**
     * EN: Triacylglycerol lipase.<br>
     * DE: Lipase.<br>
     * FR: lipase.<br>
     * IT: Lipasi.<br>
     */
    TRIACYLGLYCEROL_LIPASE("72993008",
                           "http://snomed.info/sct",
                           "Triacylglycerol lipase (substance)",
                           "Triacylglycerol lipase",
                           "Lipase",
                           "lipase",
                           "Lipasi"),
    /**
     * EN: Triamcinolone.<br>
     * DE: Triamcinolon.<br>
     * FR: triamcinolone.<br>
     * IT: Triamcinolone.<br>
     */
    TRIAMCINOLONE("116594009",
                  "http://snomed.info/sct",
                  "Triamcinolone (substance)",
                  "Triamcinolone",
                  "Triamcinolon",
                  "triamcinolone",
                  "Triamcinolone"),
    /**
     * EN: Triamcinolone acetonide.<br>
     * DE: Triamcinolon acetonid.<br>
     * FR: triamcinolone acétonide.<br>
     * IT: Triamcinolone acetonide.<br>
     */
    TRIAMCINOLONE_ACETONIDE("395913005",
                            "http://snomed.info/sct",
                            "Triamcinolone acetonide (substance)",
                            "Triamcinolone acetonide",
                            "Triamcinolon acetonid",
                            "triamcinolone acétonide",
                            "Triamcinolone acetonide"),
    /**
     * EN: Triazolam.<br>
     * DE: Triazolam.<br>
     * FR: triazolam.<br>
     * IT: Triazolam.<br>
     */
    TRIAZOLAM("386984001",
              "http://snomed.info/sct",
              "Triazolam (substance)",
              "Triazolam",
              "Triazolam",
              "triazolam",
              "Triazolam"),
    /**
     * EN: Triclosan.<br>
     * DE: Triclosan.<br>
     * FR: triclosan.<br>
     * IT: Triclosan.<br>
     */
    TRICLOSAN("387054001",
              "http://snomed.info/sct",
              "Triclosan (substance)",
              "Triclosan",
              "Triclosan",
              "triclosan",
              "Triclosan"),
    /**
     * EN: Trimethoprim.<br>
     * DE: Trimethoprim.<br>
     * FR: triméthoprime.<br>
     * IT: Trimetoprim.<br>
     */
    TRIMETHOPRIM("387179001",
                 "http://snomed.info/sct",
                 "Trimethoprim (substance)",
                 "Trimethoprim",
                 "Trimethoprim",
                 "triméthoprime",
                 "Trimetoprim"),
    /**
     * EN: Trimipramine.<br>
     * DE: Trimipramin.<br>
     * FR: trimipramine.<br>
     * IT: Trimipramina.<br>
     */
    TRIMIPRAMINE("373550009",
                 "http://snomed.info/sct",
                 "Trimipramine (substance)",
                 "Trimipramine",
                 "Trimipramin",
                 "trimipramine",
                 "Trimipramina"),
    /**
     * EN: Triptorelin.<br>
     * DE: Triptorelin.<br>
     * FR: triptoréline.<br>
     * IT: Triptorelina.<br>
     */
    TRIPTORELIN("395915003",
                "http://snomed.info/sct",
                "Triptorelin (substance)",
                "Triptorelin",
                "Triptorelin",
                "triptoréline",
                "Triptorelina"),
    /**
     * EN: Trofosfamide.<br>
     * DE: Trofosfamide.<br>
     * FR: trofosfamide.<br>
     * IT: trofosfamide.<br>
     */
    TROFOSFAMIDE("1156222009",
                 "http://snomed.info/sct",
                 "Trofosfamide (substance)",
                 "Trofosfamide",
                 "Trofosfamide",
                 "trofosfamide",
                 "trofosfamide"),
    /**
     * EN: Tropicamide.<br>
     * DE: Tropicamid.<br>
     * FR: tropicamide.<br>
     * IT: Tropicamide.<br>
     */
    TROPICAMIDE("387526001",
                "http://snomed.info/sct",
                "Tropicamide (substance)",
                "Tropicamide",
                "Tropicamid",
                "tropicamide",
                "Tropicamide"),
    /**
     * EN: Trospium chloride.<br>
     * DE: Trospium chlorid.<br>
     * FR: trospium chlorure.<br>
     * IT: Trospio cloruro.<br>
     */
    TROSPIUM_CHLORIDE("326557004",
                      "http://snomed.info/sct",
                      "Trospium chloride (substance)",
                      "Trospium chloride",
                      "Trospium chlorid",
                      "trospium chlorure",
                      "Trospio cloruro"),
    /**
     * EN: Tryptophan.<br>
     * DE: Tryptophan.<br>
     * FR: tryptophane.<br>
     * IT: Triptofano.<br>
     */
    TRYPTOPHAN("54821000",
               "http://snomed.info/sct",
               "Tryptophan (substance)",
               "Tryptophan",
               "Tryptophan",
               "tryptophane",
               "Triptofano"),
    /**
     * EN: Tuberculin purified protein derivative.<br>
     * DE: Tuberkulin, gereinigtes PPD.<br>
     * FR: tuberculine dérivé protéinique purifié.<br>
     * IT: Tubercolina derivato proteico purificato (PPD).<br>
     */
    TUBERCULIN_PURIFIED_PROTEIN_DERIVATIVE("108731003",
                                           "http://snomed.info/sct",
                                           "Tuberculin purified protein derivative (substance)",
                                           "Tuberculin purified protein derivative",
                                           "Tuberkulin, gereinigtes PPD",
                                           "tuberculine dérivé protéinique purifié",
                                           "Tubercolina derivato proteico purificato (PPD)"),
    /**
     * EN: Turoctocog alfa.<br>
     * DE: Turoctocog alfa.<br>
     * FR: turoctocog alfa.<br>
     * IT: Turoctocog alfa.<br>
     */
    TUROCTOCOG_ALFA("735055007",
                    "http://snomed.info/sct",
                    "Turoctocog alfa (substance)",
                    "Turoctocog alfa",
                    "Turoctocog alfa",
                    "turoctocog alfa",
                    "Turoctocog alfa"),
    /**
     * EN: Tyrosine.<br>
     * DE: Tyrosin.<br>
     * FR: tyrosine.<br>
     * IT: Tirosina.<br>
     */
    TYROSINE("27378009",
             "http://snomed.info/sct",
             "Tyrosine (substance)",
             "Tyrosine",
             "Tyrosin",
             "tyrosine",
             "Tirosina"),
    /**
     * EN: Tyrothricin.<br>
     * DE: Tyrothricin.<br>
     * FR: tyrothricine.<br>
     * IT: Tirotricina.<br>
     */
    TYROTHRICIN("36661005",
                "http://snomed.info/sct",
                "Tyrothricin (substance)",
                "Tyrothricin",
                "Tyrothricin",
                "tyrothricine",
                "Tirotricina"),
    /**
     * EN: Ulipristal.<br>
     * DE: Ulipristal.<br>
     * FR: ulipristal.<br>
     * IT: Ulipristal.<br>
     */
    ULIPRISTAL("703249005",
               "http://snomed.info/sct",
               "Ulipristal (substance)",
               "Ulipristal",
               "Ulipristal",
               "ulipristal",
               "Ulipristal"),
    /**
     * EN: Umeclidinium.<br>
     * DE: Umeclidinium.<br>
     * FR: uméclidinium.<br>
     * IT: Umeclidinio.<br>
     */
    UMECLIDINIUM("706898002",
                 "http://snomed.info/sct",
                 "Umeclidinium (substance)",
                 "Umeclidinium",
                 "Umeclidinium",
                 "uméclidinium",
                 "Umeclidinio"),
    /**
     * EN: Urapidil.<br>
     * DE: Urapidil.<br>
     * FR: urapidil.<br>
     * IT: Urapidil.<br>
     */
    URAPIDIL("698807007",
             "http://snomed.info/sct",
             "Urapidil (substance)",
             "Urapidil",
             "Urapidil",
             "urapidil",
             "Urapidil"),
    /**
     * EN: Urokinase.<br>
     * DE: Urokinase.<br>
     * FR: urokinase.<br>
     * IT: Urochinasi.<br>
     */
    UROKINASE("59082006",
              "http://snomed.info/sct",
              "Urokinase (substance)",
              "Urokinase",
              "Urokinase",
              "urokinase",
              "Urochinasi"),
    /**
     * EN: Ursodeoxycholic acid.<br>
     * DE: Ursodeoxycholsäure.<br>
     * FR: acide ursodésoxycholique.<br>
     * IT: Acido ursodesossicolico.<br>
     */
    URSODEOXYCHOLIC_ACID("41143004",
                         "http://snomed.info/sct",
                         "Ursodeoxycholic acid (substance)",
                         "Ursodeoxycholic acid",
                         "Ursodeoxycholsäure",
                         "acide ursodésoxycholique",
                         "Acido ursodesossicolico"),
    /**
     * EN: Ustekinumab.<br>
     * DE: Ustekinumab.<br>
     * FR: ustékinumab.<br>
     * IT: Ustekinumab.<br>
     */
    USTEKINUMAB("443465002",
                "http://snomed.info/sct",
                "Ustekinumab (substance)",
                "Ustekinumab",
                "Ustekinumab",
                "ustékinumab",
                "Ustekinumab"),
    /**
     * EN: Valaciclovir.<br>
     * DE: Valaciclovir.<br>
     * FR: valaciclovir.<br>
     * IT: Valaciclovir.<br>
     */
    VALACICLOVIR("96098007",
                 "http://snomed.info/sct",
                 "Valaciclovir (substance)",
                 "Valaciclovir",
                 "Valaciclovir",
                 "valaciclovir",
                 "Valaciclovir"),
    /**
     * EN: Valerian extract.<br>
     * DE: Baldrianwurzel-Extrakt.<br>
     * FR: valériane extrait.<br>
     * IT: Valeriana estratto.<br>
     */
    VALERIAN_EXTRACT("412266000",
                     "http://snomed.info/sct",
                     "Valerian extract (substance)",
                     "Valerian extract",
                     "Baldrianwurzel-Extrakt",
                     "valériane extrait",
                     "Valeriana estratto"),
    /**
     * EN: Valganciclovir.<br>
     * DE: Valganciclovir.<br>
     * FR: valganciclovir.<br>
     * IT: Valganciclovit.<br>
     */
    VALGANCICLOVIR("129476000",
                   "http://snomed.info/sct",
                   "Valganciclovir (substance)",
                   "Valganciclovir",
                   "Valganciclovir",
                   "valganciclovir",
                   "Valganciclovit"),
    /**
     * EN: Valine.<br>
     * DE: Valin.<br>
     * FR: valine.<br>
     * IT: Valina.<br>
     */
    VALINE("72840006",
           "http://snomed.info/sct",
           "Valine (substance)",
           "Valine",
           "Valin",
           "valine",
           "Valina"),
    /**
     * EN: Valproate semisodium.<br>
     * DE: Valproat seminatrium.<br>
     * FR: valproate semisodique.<br>
     * IT: Valproato semisodico.<br>
     */
    VALPROATE_SEMISODIUM("5641004",
                         "http://snomed.info/sct",
                         "Valproate semisodium (substance)",
                         "Valproate semisodium",
                         "Valproat seminatrium",
                         "valproate semisodique",
                         "Valproato semisodico"),
    /**
     * EN: Valproate sodium.<br>
     * DE: Valproat natrium.<br>
     * FR: valproate sodique.<br>
     * IT: Valproato sodico.<br>
     */
    VALPROATE_SODIUM("387481005",
                     "http://snomed.info/sct",
                     "Valproate sodium (substance)",
                     "Valproate sodium",
                     "Valproat natrium",
                     "valproate sodique",
                     "Valproato sodico"),
    /**
     * EN: Valproic acid.<br>
     * DE: Valproinsäure.<br>
     * FR: acide valproïque.<br>
     * IT: Acido valproico.<br>
     */
    VALPROIC_ACID("387080000",
                  "http://snomed.info/sct",
                  "Valproic acid (substance)",
                  "Valproic acid",
                  "Valproinsäure",
                  "acide valproïque",
                  "Acido valproico"),
    /**
     * EN: Valsartan.<br>
     * DE: Valsartan.<br>
     * FR: valsartan.<br>
     * IT: Valsartan.<br>
     */
    VALSARTAN("386876001",
              "http://snomed.info/sct",
              "Valsartan (substance)",
              "Valsartan",
              "Valsartan",
              "valsartan",
              "Valsartan"),
    /**
     * EN: Vancomycin.<br>
     * DE: Vancomycin.<br>
     * FR: vancomycine.<br>
     * IT: Vancomicina.<br>
     */
    VANCOMYCIN("372735009",
               "http://snomed.info/sct",
               "Vancomycin (substance)",
               "Vancomycin",
               "Vancomycin",
               "vancomycine",
               "Vancomicina"),
    /**
     * EN: Vardenafil.<br>
     * DE: Vardenafil.<br>
     * FR: vardénafil.<br>
     * IT: Vardenafil.<br>
     */
    VARDENAFIL("404858007",
               "http://snomed.info/sct",
               "Vardenafil (substance)",
               "Vardenafil",
               "Vardenafil",
               "vardénafil",
               "Vardenafil"),
    /**
     * EN: Varenicline.<br>
     * DE: Vareniclin.<br>
     * FR: varénicline.<br>
     * IT: Vareniclina.<br>
     */
    VARENICLINE("421772003",
                "http://snomed.info/sct",
                "Varenicline (substance)",
                "Varenicline",
                "Vareniclin",
                "varénicline",
                "Vareniclina"),
    /**
     * EN: Varicella-zoster virus antibody.<br>
     * DE: Varizellen-Immunglobulin vom Menschen.<br>
     * FR: immunoglobuline humaine antivaricelle.<br>
     * IT: Immunoglobulina umana antivaricella.<br>
     */
    VARICELLA_ZOSTER_VIRUS_ANTIBODY("259858000",
                                    "http://snomed.info/sct",
                                    "Varicella-zoster virus antibody (substance)",
                                    "Varicella-zoster virus antibody",
                                    "Varizellen-Immunglobulin vom Menschen",
                                    "immunoglobuline humaine antivaricelle",
                                    "Immunoglobulina umana antivaricella"),
    /**
     * EN: Vecuronium bromide.<br>
     * DE: Vecuronium bromid.<br>
     * FR: vécuronium bromure.<br>
     * IT: Vecuronio bromuro.<br>
     */
    VECURONIUM_BROMIDE("87472002",
                       "http://snomed.info/sct",
                       "Vecuronium bromide (substance)",
                       "Vecuronium bromide",
                       "Vecuronium bromid",
                       "vécuronium bromure",
                       "Vecuronio bromuro"),
    /**
     * EN: Vedolizumab.<br>
     * DE: Vedolizumab.<br>
     * FR: védolizumab.<br>
     * IT: Vedolizumab.<br>
     */
    VEDOLIZUMAB("704256006",
                "http://snomed.info/sct",
                "Vedolizumab (substance)",
                "Vedolizumab",
                "Vedolizumab",
                "védolizumab",
                "Vedolizumab"),
    /**
     * EN: Venlafaxine.<br>
     * DE: Venlafaxin.<br>
     * FR: venlafaxine.<br>
     * IT: Venlafaxina.<br>
     */
    VENLAFAXINE("372490001",
                "http://snomed.info/sct",
                "Venlafaxine (substance)",
                "Venlafaxine",
                "Venlafaxin",
                "venlafaxine",
                "Venlafaxina"),
    /**
     * EN: Verapamil.<br>
     * DE: Verapamil.<br>
     * FR: vérapamil.<br>
     * IT: Verapamil.<br>
     */
    VERAPAMIL("372754009",
              "http://snomed.info/sct",
              "Verapamil (substance)",
              "Verapamil",
              "Verapamil",
              "vérapamil",
              "Verapamil"),
    /**
     * EN: Vigabatrin.<br>
     * DE: Vigabatrin.<br>
     * FR: vigabatrine.<br>
     * IT: Vigabatrin.<br>
     */
    VIGABATRIN("310283001",
               "http://snomed.info/sct",
               "Vigabatrin (substance)",
               "Vigabatrin",
               "Vigabatrin",
               "vigabatrine",
               "Vigabatrin"),
    /**
     * EN: Vilanterol.<br>
     * DE: Vilanterol.<br>
     * FR: vilantérol.<br>
     * IT: Vilanterolo.<br>
     */
    VILANTEROL("702408004",
               "http://snomed.info/sct",
               "Vilanterol (substance)",
               "Vilanterol",
               "Vilanterol",
               "vilantérol",
               "Vilanterolo"),
    /**
     * EN: Vildagliptin.<br>
     * DE: Vildagliptin.<br>
     * FR: vildagliptine.<br>
     * IT: Vildagliptin.<br>
     */
    VILDAGLIPTIN("428611002",
                 "http://snomed.info/sct",
                 "Vildagliptin (substance)",
                 "Vildagliptin",
                 "Vildagliptin",
                 "vildagliptine",
                 "Vildagliptin"),
    /**
     * EN: Vinblastine.<br>
     * DE: Vinblastin.<br>
     * FR: vinblastine.<br>
     * IT: Vinblastina.<br>
     */
    VINBLASTINE("387051009",
                "http://snomed.info/sct",
                "Vinblastine (substance)",
                "Vinblastine",
                "Vinblastin",
                "vinblastine",
                "Vinblastina"),
    /**
     * EN: Vincristine.<br>
     * DE: Vincristin.<br>
     * FR: vincristine.<br>
     * IT: Vincristina.<br>
     */
    VINCRISTINE("387126006",
                "http://snomed.info/sct",
                "Vincristine (substance)",
                "Vincristine",
                "Vincristin",
                "vincristine",
                "Vincristina"),
    /**
     * EN: Vindesine.<br>
     * DE: Vindesin.<br>
     * FR: vindésine.<br>
     * IT: Vindesina.<br>
     */
    VINDESINE("409198005",
              "http://snomed.info/sct",
              "Vindesine (substance)",
              "Vindesine",
              "Vindesin",
              "vindésine",
              "Vindesina"),
    /**
     * EN: Vinorelbine.<br>
     * DE: Vinorelbin.<br>
     * FR: vinorelbine.<br>
     * IT: Vinorelbina.<br>
     */
    VINORELBINE("372541004",
                "http://snomed.info/sct",
                "Vinorelbine (substance)",
                "Vinorelbine",
                "Vinorelbin",
                "vinorelbine",
                "Vinorelbina"),
    /**
     * EN: Vitamin E.<br>
     * DE: Tocopherol DL-alpha (E307).<br>
     * FR: tocophérol DL-alfa (E307).<br>
     * IT: Alfa-Tocoferolo (vitamina E, E307).<br>
     */
    VITAMIN_E("37237003",
              "http://snomed.info/sct",
              "Vitamin E (substance)",
              "Vitamin E",
              "Tocopherol DL-alpha (E307)",
              "tocophérol DL-alfa (E307)",
              "Alfa-Tocoferolo (vitamina E, E307)"),
    /**
     * EN: Voriconazole.<br>
     * DE: Voriconazol.<br>
     * FR: voriconazole.<br>
     * IT: Voriconazolo.<br>
     */
    VORICONAZOLE("385469007",
                 "http://snomed.info/sct",
                 "Voriconazole (substance)",
                 "Voriconazole",
                 "Voriconazol",
                 "voriconazole",
                 "Voriconazolo"),
    /**
     * EN: Vortioxetine.<br>
     * DE: Vortioxetin.<br>
     * FR: vortioxétine.<br>
     * IT: Vortioxetina.<br>
     */
    VORTIOXETINE("708717008",
                 "http://snomed.info/sct",
                 "Vortioxetine (substance)",
                 "Vortioxetine",
                 "Vortioxetin",
                 "vortioxétine",
                 "Vortioxetina"),
    /**
     * EN: Warfarin.<br>
     * DE: Warfarin.<br>
     * FR: warfarine.<br>
     * IT: Warfarin.<br>
     */
    WARFARIN("372756006",
             "http://snomed.info/sct",
             "Warfarin (substance)",
             "Warfarin",
             "Warfarin",
             "warfarine",
             "Warfarin"),
    /**
     * EN: Xylometazoline.<br>
     * DE: Xylometazolin.<br>
     * FR: xylométazoline.<br>
     * IT: Xilometazolina.<br>
     */
    XYLOMETAZOLINE("372841007",
                   "http://snomed.info/sct",
                   "Xylometazoline (substance)",
                   "Xylometazoline",
                   "Xylometazolin",
                   "xylométazoline",
                   "Xilometazolina"),
    /**
     * EN: Zanamivir.<br>
     * DE: Zanamivir.<br>
     * FR: zanamivir.<br>
     * IT: Zanamivir.<br>
     */
    ZANAMIVIR("387010007",
              "http://snomed.info/sct",
              "Zanamivir (substance)",
              "Zanamivir",
              "Zanamivir",
              "zanamivir",
              "Zanamivir"),
    /**
     * EN: Zidovudine.<br>
     * DE: Zidovudin.<br>
     * FR: zidovudine.<br>
     * IT: Zidovudina.<br>
     */
    ZIDOVUDINE("387151007",
               "http://snomed.info/sct",
               "Zidovudine (substance)",
               "Zidovudine",
               "Zidovudin",
               "zidovudine",
               "Zidovudina"),
    /**
     * EN: Zinc acetate dihydrate.<br>
     * DE: Zinkdiacetat-2-Wasser.<br>
     * FR: zinc acétate dihydrate.<br>
     * IT: Zinco acetato diidrato.<br>
     */
    ZINC_ACETATE_DIHYDRATE("725761005",
                           "http://snomed.info/sct",
                           "Zinc acetate dihydrate (substance)",
                           "Zinc acetate dihydrate",
                           "Zinkdiacetat-2-Wasser",
                           "zinc acétate dihydrate",
                           "Zinco acetato diidrato"),
    /**
     * EN: Zinc pyrithione.<br>
     * DE: Pyrithion zink.<br>
     * FR: pyrithione zinc.<br>
     * IT: Zinco piritione.<br>
     */
    ZINC_PYRITHIONE("255954005",
                    "http://snomed.info/sct",
                    "Zinc pyrithione (substance)",
                    "Zinc pyrithione",
                    "Pyrithion zink",
                    "pyrithione zinc",
                    "Zinco piritione"),
    /**
     * EN: Zoledronic acid.<br>
     * DE: Zoledronsäure.<br>
     * FR: acide zolédronique (zolédronate).<br>
     * IT: Acido zoledronico.<br>
     */
    ZOLEDRONIC_ACID("395926009",
                    "http://snomed.info/sct",
                    "Zoledronic acid (substance)",
                    "Zoledronic acid",
                    "Zoledronsäure",
                    "acide zolédronique (zolédronate)",
                    "Acido zoledronico"),
    /**
     * EN: Zolmitriptan.<br>
     * DE: Zolmitriptan.<br>
     * FR: zolmitriptan.<br>
     * IT: Zolmitriptan.<br>
     */
    ZOLMITRIPTAN("363582006",
                 "http://snomed.info/sct",
                 "Zolmitriptan (substance)",
                 "Zolmitriptan",
                 "Zolmitriptan",
                 "zolmitriptan",
                 "Zolmitriptan"),
    /**
     * EN: Zolpidem.<br>
     * DE: Zolpidem.<br>
     * FR: zolpidem.<br>
     * IT: Zolpidem.<br>
     */
    ZOLPIDEM("387569009",
             "http://snomed.info/sct",
             "Zolpidem (substance)",
             "Zolpidem",
             "Zolpidem",
             "zolpidem",
             "Zolpidem"),
    /**
     * EN: Zonisamide.<br>
     * DE: Zonisamid.<br>
     * FR: zonisamide.<br>
     * IT: Zonisamide.<br>
     */
    ZONISAMIDE("125693002",
               "http://snomed.info/sct",
               "Zonisamide (substance)",
               "Zonisamide",
               "Zonisamid",
               "zonisamide",
               "Zonisamide"),
    /**
     * EN: Zopiclone.<br>
     * DE: Zopiclon.<br>
     * FR: zopiclone.<br>
     * IT: Zopiclone.<br>
     */
    ZOPICLONE("395929002",
              "http://snomed.info/sct",
              "Zopiclone (substance)",
              "Zopiclone",
              "Zopiclon",
              "zopiclone",
              "Zopiclone"),
    /**
     * EN: Zuclopenthixol.<br>
     * DE: Zuclopenthixol.<br>
     * FR: zuclopenthixol.<br>
     * IT: Zuclopentixolo.<br>
     */
    ZUCLOPENTHIXOL("428715002",
                   "http://snomed.info/sct",
                   "Zuclopenthixol (substance)",
                   "Zuclopenthixol",
                   "Zuclopenthixol",
                   "zuclopenthixol",
                   "Zuclopentixolo");

    /**
     * EN: Code for Abacavir.<br>
     * DE: Code für Abacavir.<br>
     * FR: Code de abacavir.<br>
     * IT: Code per Abacavir.<br>
     */
    public static final String ABACAVIR_CODE = "387005008";

    /**
     * EN: Code for Abatacept.<br>
     * DE: Code für Abatacept.<br>
     * FR: Code de abatacept.<br>
     * IT: Code per Abatacept.<br>
     */
    public static final String ABATACEPT_CODE = "421777009";

    /**
     * EN: Code for Abciximab.<br>
     * DE: Code für Abciximab.<br>
     * FR: Code de abciximab.<br>
     * IT: Code per Abciximab.<br>
     */
    public static final String ABCIXIMAB_CODE = "386951001";

    /**
     * EN: Code for Abemaciclib.<br>
     * DE: Code für Abemaciclib.<br>
     * FR: Code de abémaciclib.<br>
     * IT: Code per Abemaciclib.<br>
     */
    public static final String ABEMACICLIB_CODE = "761851004";

    /**
     * EN: Code for Abiraterone.<br>
     * DE: Code für Abirateron.<br>
     * FR: Code de abiratérone.<br>
     * IT: Code per Abiraterone.<br>
     */
    public static final String ABIRATERONE_CODE = "699678007";

    /**
     * EN: Code for Acamprosate.<br>
     * DE: Code für Acamprosat.<br>
     * FR: Code de acamprosate.<br>
     * IT: Code per Acamprosato.<br>
     */
    public static final String ACAMPROSATE_CODE = "391698009";

    /**
     * EN: Code for Acarbose.<br>
     * DE: Code für Acarbose.<br>
     * FR: Code de acarbose.<br>
     * IT: Code per Acarbosio.<br>
     */
    public static final String ACARBOSE_CODE = "386965004";

    /**
     * EN: Code for Acemetacin.<br>
     * DE: Code für Acemetacin.<br>
     * FR: Code de acémétacine.<br>
     * IT: Code per Acemetacina.<br>
     */
    public static final String ACEMETACIN_CODE = "391704009";

    /**
     * EN: Code for Acenocoumarol.<br>
     * DE: Code für Acenocoumarol.<br>
     * FR: Code de acénocoumarol.<br>
     * IT: Code per Acenocumarolo.<br>
     */
    public static final String ACENOCOUMAROL_CODE = "387457003";

    /**
     * EN: Code for Acetazolamide.<br>
     * DE: Code für Acetazolamid.<br>
     * FR: Code de acétazolamide.<br>
     * IT: Code per Acetazolamide.<br>
     */
    public static final String ACETAZOLAMIDE_CODE = "372709008";

    /**
     * EN: Code for Acetylcysteine.<br>
     * DE: Code für Acetylcystein.<br>
     * FR: Code de acétylcystéine.<br>
     * IT: Code per Acetilcisteina.<br>
     */
    public static final String ACETYLCYSTEINE_CODE = "387440002";

    /**
     * EN: Code for Aciclovir.<br>
     * DE: Code für Aciclovir.<br>
     * FR: Code de aciclovir.<br>
     * IT: Code per Aciclovir.<br>
     */
    public static final String ACICLOVIR_CODE = "372729009";

    /**
     * EN: Code for Acipimox.<br>
     * DE: Code für Acipimox.<br>
     * FR: Code de acipimox.<br>
     * IT: Code per Acipimox.<br>
     */
    public static final String ACIPIMOX_CODE = "391711008";

    /**
     * EN: Code for Acitretin.<br>
     * DE: Code für Acitretin.<br>
     * FR: Code de acitrétine.<br>
     * IT: Code per Acitretina.<br>
     */
    public static final String ACITRETIN_CODE = "386938006";

    /**
     * EN: Code for Aclidinium.<br>
     * DE: Code für Aclidinium-Kation.<br>
     * FR: Code de aclidinium.<br>
     * IT: Code per Aclidinio.<br>
     */
    public static final String ACLIDINIUM_CODE = "703921008";

    /**
     * EN: Code for Activated charcoal.<br>
     * DE: Code für Kohle, medizinische.<br>
     * FR: Code de charbon activé.<br>
     * IT: Code per Carbone attivo.<br>
     */
    public static final String ACTIVATED_CHARCOAL_CODE = "32519007";

    /**
     * EN: Code for Adalimumab.<br>
     * DE: Code für Adalimumab.<br>
     * FR: Code de adalimumab.<br>
     * IT: Code per Adalimumab.<br>
     */
    public static final String ADALIMUMAB_CODE = "407317001";

    /**
     * EN: Code for Adapalene.<br>
     * DE: Code für Adapalen.<br>
     * FR: Code de adapalène.<br>
     * IT: Code per Adapalene.<br>
     */
    public static final String ADAPALENE_CODE = "386934008";

    /**
     * EN: Code for Adefovir.<br>
     * DE: Code für Adefovir.<br>
     * FR: Code de adéfovir.<br>
     * IT: Code per Adefovir.<br>
     */
    public static final String ADEFOVIR_CODE = "412072006";

    /**
     * EN: Code for Adenosine.<br>
     * DE: Code für Adenosin.<br>
     * FR: Code de adénosine.<br>
     * IT: Code per Adenosina.<br>
     */
    public static final String ADENOSINE_CODE = "35431001";

    /**
     * EN: Code for Afatinib.<br>
     * DE: Code für Afatinib.<br>
     * FR: Code de afatinib.<br>
     * IT: Code per Afatinib.<br>
     */
    public static final String AFATINIB_CODE = "703579002";

    /**
     * EN: Code for Aflibercept.<br>
     * DE: Code für Aflibercept.<br>
     * FR: Code de aflibercept.<br>
     * IT: Code per Aflibercept.<br>
     */
    public static final String AFLIBERCEPT_CODE = "703840003";

    /**
     * EN: Code for Agalsidase alfa.<br>
     * DE: Code für Agalsidase alfa.<br>
     * FR: Code de agalsidase alfa.<br>
     * IT: Code per Agalsidasi alfa.<br>
     */
    public static final String AGALSIDASE_ALFA_CODE = "424905009";

    /**
     * EN: Code for Agalsidase beta.<br>
     * DE: Code für Agalsidase beta.<br>
     * FR: Code de agalsidase bêta.<br>
     * IT: Code per Agalsidasi beta.<br>
     */
    public static final String AGALSIDASE_BETA_CODE = "424725004";

    /**
     * EN: Code for Agomelatine.<br>
     * DE: Code für Agomelatin.<br>
     * FR: Code de agomélatine.<br>
     * IT: Code per Agomelatina.<br>
     */
    public static final String AGOMELATINE_CODE = "698012009";

    /**
     * EN: Code for Ajmaline.<br>
     * DE: Code für Ajmalin.<br>
     * FR: Code de ajmaline.<br>
     * IT: Code per ajmaline.<br>
     */
    public static final String AJMALINE_CODE = "1156230005";

    /**
     * EN: Code for Alanine.<br>
     * DE: Code für Alanin.<br>
     * FR: Code de alanine.<br>
     * IT: Code per Alanina.<br>
     */
    public static final String ALANINE_CODE = "58753009";

    /**
     * EN: Code for Alanylglutamine.<br>
     * DE: Code für Alanyl glutamin.<br>
     * FR: Code de alanyl glutamine.<br>
     * IT: Code per Alanil glutammina.<br>
     */
    public static final String ALANYLGLUTAMINE_CODE = "703391005";

    /**
     * EN: Code for Albendazole.<br>
     * DE: Code für Albendazol.<br>
     * FR: Code de albendazole.<br>
     * IT: Code per Albendazolo.<br>
     */
    public static final String ALBENDAZOLE_CODE = "387558006";

    /**
     * EN: Code for Albiglutide.<br>
     * DE: Code für Albiglutid.<br>
     * FR: Code de albiglutide.<br>
     * IT: Code per Albiglutide.<br>
     */
    public static final String ALBIGLUTIDE_CODE = "703129009";

    /**
     * EN: Code for Albumin.<br>
     * DE: Code für Albumine.<br>
     * FR: Code de albumine.<br>
     * IT: Code per Albumina.<br>
     */
    public static final String ALBUMIN_CODE = "52454007";

    /**
     * EN: Code for Albutrepenonacog alfa.<br>
     * DE: Code für Albutrepenonacog alfa.<br>
     * FR: Code de albutrépénonacog alfa.<br>
     * IT: Code per Albutrepenonacog alfa.<br>
     */
    public static final String ALBUTREPENONACOG_ALFA_CODE = "718928008";

    /**
     * EN: Code for Alcohol.<br>
     * DE: Code für Ethanol.<br>
     * FR: Code de éthanol.<br>
     * IT: Code per Alcol etilico.<br>
     */
    public static final String ALCOHOL_CODE = "53041004";

    /**
     * EN: Code for Aldesleukin.<br>
     * DE: Code für Aldesleukin.<br>
     * FR: Code de aldesleukine.<br>
     * IT: Code per Aldesleuchina.<br>
     */
    public static final String ALDESLEUKIN_CODE = "386917000";

    /**
     * EN: Code for Alectinib.<br>
     * DE: Code für Alectinib.<br>
     * FR: Code de alectinib.<br>
     * IT: Code per Alectinib.<br>
     */
    public static final String ALECTINIB_CODE = "716039000";

    /**
     * EN: Code for Alemtuzumab.<br>
     * DE: Code für Alemtuzumab.<br>
     * FR: Code de alemtuzumab.<br>
     * IT: Code per Alemtuzumab.<br>
     */
    public static final String ALEMTUZUMAB_CODE = "129472003";

    /**
     * EN: Code for Alendronic acid.<br>
     * DE: Code für Alendronsäure.<br>
     * FR: Code de acide alendronique.<br>
     * IT: Code per Acido Alendronico.<br>
     */
    public static final String ALENDRONIC_ACID_CODE = "391730008";

    /**
     * EN: Code for Alfentanil.<br>
     * DE: Code für Alfentanil.<br>
     * FR: Code de alfentanil.<br>
     * IT: Code per Alfentanil.<br>
     */
    public static final String ALFENTANIL_CODE = "387560008";

    /**
     * EN: Code for Alfuzosin.<br>
     * DE: Code für Alfuzosin.<br>
     * FR: Code de alfuzosine.<br>
     * IT: Code per Alfuzosina.<br>
     */
    public static final String ALFUZOSIN_CODE = "395954002";

    /**
     * EN: Code for Alirocumab.<br>
     * DE: Code für Alirocumab.<br>
     * FR: Code de alirocumab.<br>
     * IT: Code per Alirocumab.<br>
     */
    public static final String ALIROCUMAB_CODE = "715186005";

    /**
     * EN: Code for Aliskiren.<br>
     * DE: Code für Aliskiren.<br>
     * FR: Code de aliskirène.<br>
     * IT: Code per Aliskiren.<br>
     */
    public static final String ALISKIREN_CODE = "426725002";

    /**
     * EN: Code for Allopurinol.<br>
     * DE: Code für Allopurinol.<br>
     * FR: Code de allopurinol.<br>
     * IT: Code per Allopurinolo.<br>
     */
    public static final String ALLOPURINOL_CODE = "387135004";

    /**
     * EN: Code for Almotriptan.<br>
     * DE: Code für Almotriptan.<br>
     * FR: Code de almotriptan.<br>
     * IT: Code per Almotriptan.<br>
     */
    public static final String ALMOTRIPTAN_CODE = "363569003";

    /**
     * EN: Code for Alogliptin.<br>
     * DE: Code für Alogliptin.<br>
     * FR: Code de alogliptine.<br>
     * IT: Code per Alogliptin.<br>
     */
    public static final String ALOGLIPTIN_CODE = "702799001";

    /**
     * EN: Code for Alprazolam.<br>
     * DE: Code für Alprazolam.<br>
     * FR: Code de alprazolam.<br>
     * IT: Code per Alprazolam.<br>
     */
    public static final String ALPRAZOLAM_CODE = "386983007";

    /**
     * EN: Code for Alprostadil.<br>
     * DE: Code für Alprostadil.<br>
     * FR: Code de alprostadil.<br>
     * IT: Code per Alprostadil.<br>
     */
    public static final String ALPROSTADIL_CODE = "48988008";

    /**
     * EN: Code for Alteplase.<br>
     * DE: Code für Alteplase.<br>
     * FR: Code de altéplase.<br>
     * IT: Code per Alteplase.<br>
     */
    public static final String ALTEPLASE_CODE = "387152000";

    /**
     * EN: Code for Aluminium hydroxide.<br>
     * DE: Code für Aluminiumoxid, wasserhaltig (Algeldrat).<br>
     * FR: Code de aluminium oxyde hydrate (algeldrate).<br>
     * IT: Code per Idrossido di alluminio.<br>
     */
    public static final String ALUMINIUM_HYDROXIDE_CODE = "273944007";

    /**
     * EN: Code for Amantadine.<br>
     * DE: Code für Amantadin.<br>
     * FR: Code de amantadine.<br>
     * IT: Code per Amantadina.<br>
     */
    public static final String AMANTADINE_CODE = "372763006";

    /**
     * EN: Code for Ambrisentan.<br>
     * DE: Code für Ambrisentan.<br>
     * FR: Code de ambrisentan.<br>
     * IT: Code per Ambrisentan.<br>
     */
    public static final String AMBRISENTAN_CODE = "428159003";

    /**
     * EN: Code for Ambroxol.<br>
     * DE: Code für Ambroxol.<br>
     * FR: Code de ambroxol.<br>
     * IT: Code per Ambroxolo.<br>
     */
    public static final String AMBROXOL_CODE = "698024002";

    /**
     * EN: Code for Amikacin.<br>
     * DE: Code für Amikacin.<br>
     * FR: Code de amikacine.<br>
     * IT: Code per Amikacina.<br>
     */
    public static final String AMIKACIN_CODE = "387266001";

    /**
     * EN: Code for Amiloride.<br>
     * DE: Code für Amilorid.<br>
     * FR: Code de amiloride.<br>
     * IT: Code per Amiloride.<br>
     */
    public static final String AMILORIDE_CODE = "387503008";

    /**
     * EN: Code for Aminophylline.<br>
     * DE: Code für Aminophyllin.<br>
     * FR: Code de aminophylline.<br>
     * IT: Code per Aminofillina.<br>
     */
    public static final String AMINOPHYLLINE_CODE = "373508009";

    /**
     * EN: Code for Amiodarone.<br>
     * DE: Code für Amiodaron.<br>
     * FR: Code de amiodarone.<br>
     * IT: Code per Amiodarone.<br>
     */
    public static final String AMIODARONE_CODE = "372821002";

    /**
     * EN: Code for Amisulpride.<br>
     * DE: Code für Amisulprid.<br>
     * FR: Code de amisulpride.<br>
     * IT: Code per Amisulpride.<br>
     */
    public static final String AMISULPRIDE_CODE = "391761004";

    /**
     * EN: Code for Amitriptyline.<br>
     * DE: Code für Amitriptylin.<br>
     * FR: Code de amitriptyline.<br>
     * IT: Code per Amitriptilina.<br>
     */
    public static final String AMITRIPTYLINE_CODE = "372726002";

    /**
     * EN: Code for Amlodipine.<br>
     * DE: Code für Amlodipin.<br>
     * FR: Code de amlodipine.<br>
     * IT: Code per Amlodipina.<br>
     */
    public static final String AMLODIPINE_CODE = "386864001";

    /**
     * EN: Code for Amorolfine.<br>
     * DE: Code für Amorolfin.<br>
     * FR: Code de amorolfine.<br>
     * IT: Code per Amorolfina.<br>
     */
    public static final String AMOROLFINE_CODE = "391769002";

    /**
     * EN: Code for Amoxicillin.<br>
     * DE: Code für Amoxicillin.<br>
     * FR: Code de amoxicilline.<br>
     * IT: Code per Amoxicillina.<br>
     */
    public static final String AMOXICILLIN_CODE = "372687004";

    /**
     * EN: Code for Amoxicillin sodium.<br>
     * DE: Code für Amoxicillin-Natrium.<br>
     * FR: Code de amoxicilline sodique.<br>
     * IT: Code per Amoxicillina sodica.<br>
     */
    public static final String AMOXICILLIN_SODIUM_CODE = "427483001";

    /**
     * EN: Code for Amoxicillin trihydrate.<br>
     * DE: Code für Amoxicillin-3-Wasser.<br>
     * FR: Code de amoxicilline trihydrate.<br>
     * IT: Code per Amoxicillina triidrato.<br>
     */
    public static final String AMOXICILLIN_TRIHYDRATE_CODE = "96068000";

    /**
     * EN: Code for Amphotericin B.<br>
     * DE: Code für Amphotericin B.<br>
     * FR: Code de amphotéricine B.<br>
     * IT: Code per Amfotericina B.<br>
     */
    public static final String AMPHOTERICIN_B_CODE = "77703004";

    /**
     * EN: Code for Ampicillin.<br>
     * DE: Code für Ampicillin.<br>
     * FR: Code de ampicilline.<br>
     * IT: Code per Ampicillina.<br>
     */
    public static final String AMPICILLIN_CODE = "387170002";

    /**
     * EN: Code for Amylase.<br>
     * DE: Code für Amylase.<br>
     * FR: Code de amylase.<br>
     * IT: Code per Amilasi.<br>
     */
    public static final String AMYLASE_CODE = "387031005";

    /**
     * EN: Code for Anagrelide.<br>
     * DE: Code für Anagrelid.<br>
     * FR: Code de anagrélide.<br>
     * IT: Code per Anagrelide.<br>
     */
    public static final String ANAGRELIDE_CODE = "372561005";

    /**
     * EN: Code for Anakinra.<br>
     * DE: Code für Anakinra.<br>
     * FR: Code de anakinra.<br>
     * IT: Code per Anakinra.<br>
     */
    public static final String ANAKINRA_CODE = "385549000";

    /**
     * EN: Code for Anastrozole.<br>
     * DE: Code für Anastrozol.<br>
     * FR: Code de anastrozole.<br>
     * IT: Code per Anastrozolo.<br>
     */
    public static final String ANASTROZOLE_CODE = "386910003";

    /**
     * EN: Code for Anetholtrithion.<br>
     * DE: Code für Anetholtrithion.<br>
     * FR: Code de anétholtrithione.<br>
     * IT: Code per Anetoltritione.<br>
     */
    public static final String ANETHOLTRITHION_CODE = "703112006";

    /**
     * EN: Code for Anidulafungin.<br>
     * DE: Code für Anidulafungin.<br>
     * FR: Code de anidulafungine.<br>
     * IT: Code per Anidulafungina.<br>
     */
    public static final String ANIDULAFUNGIN_CODE = "422157006";

    /**
     * EN: Code for Antazoline.<br>
     * DE: Code für Antazolin.<br>
     * FR: Code de antazoline.<br>
     * IT: Code per Antazolina.<br>
     */
    public static final String ANTAZOLINE_CODE = "373544004";

    /**
     * EN: Code for Antilymphocyte immunoglobulin.<br>
     * DE: Code für Immunglobuline anti-Lymphozyten human.<br>
     * FR: Code de immunoglobuline anti-lymphocytes humains.<br>
     * IT: Code per Immunoglobulina anti-linfociti T umani.<br>
     */
    public static final String ANTILYMPHOCYTE_IMMUNOGLOBULIN_CODE = "391784006";

    /**
     * EN: Code for Antithymocyte immunoglobulin.<br>
     * DE: Code für Immunglobulin anti-T-Lymphozyten human.<br>
     * FR: Code de immunoglobuline anti lymphocytes T humains.<br>
     * IT: Code per Immunoglobulina antitimociti umani.<br>
     */
    public static final String ANTITHYMOCYTE_IMMUNOGLOBULIN_CODE = "768651008";

    /**
     * EN: Code for Apixaban.<br>
     * DE: Code für Apixaban.<br>
     * FR: Code de apixaban.<br>
     * IT: Code per Apixaban.<br>
     */
    public static final String APIXABAN_CODE = "698090000";

    /**
     * EN: Code for Apomorphine.<br>
     * DE: Code für Apomorphin.<br>
     * FR: Code de apomorphine.<br>
     * IT: Code per Apomorfina.<br>
     */
    public static final String APOMORPHINE_CODE = "387375001";

    /**
     * EN: Code for Aprepitant.<br>
     * DE: Code für Aprepitant.<br>
     * FR: Code de aprépitant.<br>
     * IT: Code per Aprepitant.<br>
     */
    public static final String APREPITANT_CODE = "409205009";

    /**
     * EN: Code for Aprotinin.<br>
     * DE: Code für Aprotinin.<br>
     * FR: Code de aprotinine.<br>
     * IT: Code per Aprotinina.<br>
     */
    public static final String APROTININ_CODE = "386961008";

    /**
     * EN: Code for Argatroban.<br>
     * DE: Code für Argatroban.<br>
     * FR: Code de argatroban.<br>
     * IT: Code per Argatroban.<br>
     */
    public static final String ARGATROBAN_CODE = "116508003";

    /**
     * EN: Code for Arginine.<br>
     * DE: Code für Arginin.<br>
     * FR: Code de arginine.<br>
     * IT: Code per Arginina.<br>
     */
    public static final String ARGININE_CODE = "52625008";

    /**
     * EN: Code for Argipressin.<br>
     * DE: Code für Argipressin (Vasopressin).<br>
     * FR: Code de argipressine (Vasopressine).<br>
     * IT: Code per Argipressina (Vasopressina).<br>
     */
    public static final String ARGIPRESSIN_CODE = "421078009";

    /**
     * EN: Code for Aripiprazole.<br>
     * DE: Code für Aripiprazol.<br>
     * FR: Code de aripiprazole.<br>
     * IT: Code per Aripirazolo.<br>
     */
    public static final String ARIPIPRAZOLE_CODE = "406784005";

    /**
     * EN: Code for Arsenic trioxide.<br>
     * DE: Code für Arsentrioxid.<br>
     * FR: Code de trioxyde d'arsenic.<br>
     * IT: Code per Arsenico triossido.<br>
     */
    public static final String ARSENIC_TRIOXIDE_CODE = "72251000";

    /**
     * EN: Code for Artemether.<br>
     * DE: Code für Artemether.<br>
     * FR: Code de artéméther.<br>
     * IT: Code per Artemetere.<br>
     */
    public static final String ARTEMETHER_CODE = "420578008";

    /**
     * EN: Code for Artesunate.<br>
     * DE: Code für Artesunat.<br>
     * FR: Code de artésunate.<br>
     * IT: Code per Artesunato.<br>
     */
    public static final String ARTESUNATE_CODE = "432410005";

    /**
     * EN: Code for Articaine.<br>
     * DE: Code für Articain.<br>
     * FR: Code de articaïne.<br>
     * IT: Code per Articaina.<br>
     */
    public static final String ARTICAINE_CODE = "703107005";

    /**
     * EN: Code for Ascorbic acid.<br>
     * DE: Code für Ascorbinsäure (Vitamin C, E300).<br>
     * FR: Code de acide ascorbique (Vitamine C, E300).<br>
     * IT: Code per Acido ascorbico (Vitamina C, E300).<br>
     */
    public static final String ASCORBIC_ACID_CODE = "43706004";

    /**
     * EN: Code for Asparaginase.<br>
     * DE: Code für Asparaginase.<br>
     * FR: Code de asparaginase.<br>
     * IT: Code per Asparaginasi.<br>
     */
    public static final String ASPARAGINASE_CODE = "371014004";

    /**
     * EN: Code for Aspartic acid.<br>
     * DE: Code für Aspartinsäure.<br>
     * FR: Code de acide aspartique.<br>
     * IT: Code per Acido aspartico.<br>
     */
    public static final String ASPARTIC_ACID_CODE = "44970006";

    /**
     * EN: Code for Aspirin.<br>
     * DE: Code für Acetylsalicylsäure.<br>
     * FR: Code de acide acétylsalicylique.<br>
     * IT: Code per Acido acetilsalicilico.<br>
     */
    public static final String ASPIRIN_CODE = "387458008";

    /**
     * EN: Code for Atazanavir.<br>
     * DE: Code für Atazanavir.<br>
     * FR: Code de atazanavir.<br>
     * IT: Code per Atazanavir.<br>
     */
    public static final String ATAZANAVIR_CODE = "413592000";

    /**
     * EN: Code for Atenolol.<br>
     * DE: Code für Atenolol.<br>
     * FR: Code de aténolol.<br>
     * IT: Code per Atenololo.<br>
     */
    public static final String ATENOLOL_CODE = "387506000";

    /**
     * EN: Code for Atezolizumab.<br>
     * DE: Code für Atezolizumab.<br>
     * FR: Code de atézolizumab.<br>
     * IT: Code per Atezolizumab.<br>
     */
    public static final String ATEZOLIZUMAB_CODE = "719371003";

    /**
     * EN: Code for Atomoxetine.<br>
     * DE: Code für Atomoxetin.<br>
     * FR: Code de atomoxétine.<br>
     * IT: Code per Atomoxetina.<br>
     */
    public static final String ATOMOXETINE_CODE = "407037005";

    /**
     * EN: Code for Atorvastatin.<br>
     * DE: Code für Atorvastatin.<br>
     * FR: Code de atorvastatine.<br>
     * IT: Code per Atorvastatina.<br>
     */
    public static final String ATORVASTATIN_CODE = "373444002";

    /**
     * EN: Code for Atosiban.<br>
     * DE: Code für Atosiban.<br>
     * FR: Code de atosiban.<br>
     * IT: Code per Atosiban.<br>
     */
    public static final String ATOSIBAN_CODE = "391792002";

    /**
     * EN: Code for Atovaquone.<br>
     * DE: Code für Atovaquon.<br>
     * FR: Code de atovaquone.<br>
     * IT: Code per Atovaquone.<br>
     */
    public static final String ATOVAQUONE_CODE = "386899002";

    /**
     * EN: Code for Atracurium.<br>
     * DE: Code für Atracurium.<br>
     * FR: Code de atracurium.<br>
     * IT: Code per Atracurio.<br>
     */
    public static final String ATRACURIUM_CODE = "372835000";

    /**
     * EN: Code for Atropine.<br>
     * DE: Code für Atropin.<br>
     * FR: Code de atropine.<br>
     * IT: Code per Atropina.<br>
     */
    public static final String ATROPINE_CODE = "372832002";

    /**
     * EN: Code for Avanafil.<br>
     * DE: Code für Avanafil.<br>
     * FR: Code de avanafil.<br>
     * IT: Code per Avafanil.<br>
     */
    public static final String AVANAFIL_CODE = "703956007";

    /**
     * EN: Code for Avelumab.<br>
     * DE: Code für Avelumab.<br>
     * FR: Code de avélumab.<br>
     * IT: Code per Avelumab.<br>
     */
    public static final String AVELUMAB_CODE = "733055009";

    /**
     * EN: Code for Azacitidine.<br>
     * DE: Code für Azacitidin.<br>
     * FR: Code de azacitidine.<br>
     * IT: Code per Azacitidina.<br>
     */
    public static final String AZACITIDINE_CODE = "412328000";

    /**
     * EN: Code for Azathioprine.<br>
     * DE: Code für Azathioprin.<br>
     * FR: Code de azathioprine.<br>
     * IT: Code per Azatioprina.<br>
     */
    public static final String AZATHIOPRINE_CODE = "372574004";

    /**
     * EN: Code for Azelaic acid.<br>
     * DE: Code für Azelainsäure.<br>
     * FR: Code de acide azélaïque.<br>
     * IT: Code per Acido azelaico.<br>
     */
    public static final String AZELAIC_ACID_CODE = "386936005";

    /**
     * EN: Code for Azelastine.<br>
     * DE: Code für Azelastin.<br>
     * FR: Code de azélastine.<br>
     * IT: Code per Azelastina.<br>
     */
    public static final String AZELASTINE_CODE = "372520005";

    /**
     * EN: Code for Azithromycin.<br>
     * DE: Code für Azithromycin.<br>
     * FR: Code de azithromycine.<br>
     * IT: Code per Azitromicina.<br>
     */
    public static final String AZITHROMYCIN_CODE = "387531004";

    /**
     * EN: Code for Aztreonam.<br>
     * DE: Code für Aztreonam.<br>
     * FR: Code de aztréonam.<br>
     * IT: Code per Aztreonam.<br>
     */
    public static final String AZTREONAM_CODE = "387386004";

    /**
     * EN: Code for Bacitracin.<br>
     * DE: Code für Bacitracin.<br>
     * FR: Code de bacitracine.<br>
     * IT: Code per Bacitracina.<br>
     */
    public static final String BACITRACIN_CODE = "5220000";

    /**
     * EN: Code for Baclofen.<br>
     * DE: Code für Baclofen.<br>
     * FR: Code de baclofène.<br>
     * IT: Code per Baclofene.<br>
     */
    public static final String BACLOFEN_CODE = "387342009";

    /**
     * EN: Code for Basiliximab.<br>
     * DE: Code für Basiliximab.<br>
     * FR: Code de basiliximab.<br>
     * IT: Code per Basiliximab.<br>
     */
    public static final String BASILIXIMAB_CODE = "386978004";

    /**
     * EN: Code for Beclometasone.<br>
     * DE: Code für Beclometason.<br>
     * FR: Code de béclométasone.<br>
     * IT: Code per Beclometasone.<br>
     */
    public static final String BECLOMETASONE_CODE = "116574000";

    /**
     * EN: Code for Beclometasone dipropionate.<br>
     * DE: Code für Beclometason dipropionat.<br>
     * FR: Code de béclométasone dipropionate.<br>
     * IT: Code per Beclometasone dipropionato.<br>
     */
    public static final String BECLOMETASONE_DIPROPIONATE_CODE = "116575004";

    /**
     * EN: Code for Belatacept.<br>
     * DE: Code für Belatacept.<br>
     * FR: Code de bélatacept.<br>
     * IT: Code per Belatacept.<br>
     */
    public static final String BELATACEPT_CODE = "713475001";

    /**
     * EN: Code for Belimumab.<br>
     * DE: Code für Belimumab.<br>
     * FR: Code de bélimumab.<br>
     * IT: Code per Belimumab.<br>
     */
    public static final String BELIMUMAB_CODE = "449043000";

    /**
     * EN: Code for Benazepril.<br>
     * DE: Code für Benazepril.<br>
     * FR: Code de bénazépril.<br>
     * IT: Code per Benazepril.<br>
     */
    public static final String BENAZEPRIL_CODE = "372511001";

    /**
     * EN: Code for Bendamustine.<br>
     * DE: Code für Bendamustin.<br>
     * FR: Code de bendamustine.<br>
     * IT: Code per Bendamustina.<br>
     */
    public static final String BENDAMUSTINE_CODE = "428012008";

    /**
     * EN: Code for Benserazide.<br>
     * DE: Code für Benserazid.<br>
     * FR: Code de bensérazide.<br>
     * IT: Code per Benserazide.<br>
     */
    public static final String BENSERAZIDE_CODE = "391821005";

    /**
     * EN: Code for Benzocaine.<br>
     * DE: Code für Benzocain.<br>
     * FR: Code de benzocaïne.<br>
     * IT: Code per Benzocaina.<br>
     */
    public static final String BENZOCAINE_CODE = "387357002";

    /**
     * EN: Code for Benzydamine.<br>
     * DE: Code für Benzydamin.<br>
     * FR: Code de benzydamine.<br>
     * IT: Code per Benzidamina.<br>
     */
    public static final String BENZYDAMINE_CODE = "421319000";

    /**
     * EN: Code for Benzylpenicillin.<br>
     * DE: Code für Benzylpenicillin.<br>
     * FR: Code de benzylpénicilline.<br>
     * IT: Code per Benzilpenicillina.<br>
     */
    public static final String BENZYLPENICILLIN_CODE = "323389000";

    /**
     * EN: Code for Betahistine.<br>
     * DE: Code für Betahistin.<br>
     * FR: Code de bétahistine.<br>
     * IT: Code per Betaistina.<br>
     */
    public static final String BETAHISTINE_CODE = "418067008";

    /**
     * EN: Code for Betaine.<br>
     * DE: Code für Betain.<br>
     * FR: Code de bétaine.<br>
     * IT: Code per Betaina.<br>
     */
    public static final String BETAINE_CODE = "43356007";

    /**
     * EN: Code for Betamethasone.<br>
     * DE: Code für Betamethason.<br>
     * FR: Code de bétaméthasone.<br>
     * IT: Code per Betametasone.<br>
     */
    public static final String BETAMETHASONE_CODE = "116571008";

    /**
     * EN: Code for Betaxolol.<br>
     * DE: Code für Betaxolol.<br>
     * FR: Code de bétaxolol.<br>
     * IT: Code per Betaxololo.<br>
     */
    public static final String BETAXOLOL_CODE = "409276006";

    /**
     * EN: Code for Beta-galactosidase.<br>
     * DE: Code für Tilactase.<br>
     * FR: Code de tilactase.<br>
     * IT: Code per Tilattasi.<br>
     */
    public static final String BETA_GALACTOSIDASE_CODE = "28530008";

    /**
     * EN: Code for Bevacizumab.<br>
     * DE: Code für Bevacizumab.<br>
     * FR: Code de bévacizumab.<br>
     * IT: Code per Bevacizumab.<br>
     */
    public static final String BEVACIZUMAB_CODE = "409406007";

    /**
     * EN: Code for Bezafibrate.<br>
     * DE: Code für Bezafibrat.<br>
     * FR: Code de bézafibrate.<br>
     * IT: Code per Bezafibrato.<br>
     */
    public static final String BEZAFIBRATE_CODE = "396025003";

    /**
     * EN: Code for Bicalutamide.<br>
     * DE: Code für Bicalutamid.<br>
     * FR: Code de bicalutamide.<br>
     * IT: Code per Bicalutamide.<br>
     */
    public static final String BICALUTAMIDE_CODE = "386908000";

    /**
     * EN: Code for Bictegravir.<br>
     * DE: Code für Bictegravir.<br>
     * FR: Code de bictégravir.<br>
     * IT: Code per Bictegravir.<br>
     */
    public static final String BICTEGRAVIR_CODE = "772193003";

    /**
     * EN: Code for Bilastine.<br>
     * DE: Code für Bilastin.<br>
     * FR: Code de bilastine.<br>
     * IT: Code per Bilastina.<br>
     */
    public static final String BILASTINE_CODE = "697973006";

    /**
     * EN: Code for Bimatoprost.<br>
     * DE: Code für Bimatoprost.<br>
     * FR: Code de bimatoprost.<br>
     * IT: Code per Bimatoprost.<br>
     */
    public static final String BIMATOPROST_CODE = "129492005";

    /**
     * EN: Code for Binimetinib.<br>
     * DE: Code für Binimetinib.<br>
     * FR: Code de binimétinib.<br>
     * IT: Code per Binimetinib.<br>
     */
    public static final String BINIMETINIB_CODE = "772195005";

    /**
     * EN: Code for Biotin.<br>
     * DE: Code für Biotin.<br>
     * FR: Code de biotine.<br>
     * IT: Code per Biotina.<br>
     */
    public static final String BIOTIN_CODE = "8919000";

    /**
     * EN: Code for Biperiden.<br>
     * DE: Code für Biperiden.<br>
     * FR: Code de bipéridène.<br>
     * IT: Code per Biperidene.<br>
     */
    public static final String BIPERIDEN_CODE = "387359004";

    /**
     * EN: Code for Bisacodyl.<br>
     * DE: Code für Bisacodyl.<br>
     * FR: Code de bisacodyl.<br>
     * IT: Code per Bisacodile.<br>
     */
    public static final String BISACODYL_CODE = "387075009";

    /**
     * EN: Code for Bisoprolol.<br>
     * DE: Code für Bisoprolol.<br>
     * FR: Code de bisoprolol.<br>
     * IT: Code per Bisoprololo.<br>
     */
    public static final String BISOPROLOL_CODE = "386868003";

    /**
     * EN: Code for Bivalirudin.<br>
     * DE: Code für Bivalirudin.<br>
     * FR: Code de bivalirudine.<br>
     * IT: Code per Bivalirudina.<br>
     */
    public static final String BIVALIRUDIN_CODE = "129498009";

    /**
     * EN: Code for Bleomycin.<br>
     * DE: Code für Bleomycin.<br>
     * FR: Code de bléomycine.<br>
     * IT: Code per Bleomicina.<br>
     */
    public static final String BLEOMYCIN_CODE = "372843005";

    /**
     * EN: Code for Bortezomib.<br>
     * DE: Code für Bortezomib.<br>
     * FR: Code de bortézomib.<br>
     * IT: Code per Bortezomib.<br>
     */
    public static final String BORTEZOMIB_CODE = "407097007";

    /**
     * EN: Code for Bosentan.<br>
     * DE: Code für Bosentan.<br>
     * FR: Code de bosentan.<br>
     * IT: Code per Bosentan.<br>
     */
    public static final String BOSENTAN_CODE = "385559004";

    /**
     * EN: Code for Bosutinib.<br>
     * DE: Code für Bosutinib.<br>
     * FR: Code de bosutinib.<br>
     * IT: Code per Bosutinib.<br>
     */
    public static final String BOSUTINIB_CODE = "703128001";

    /**
     * EN: Code for Botulinum toxin type A.<br>
     * DE: Code für Botulinumtoxin Typ A.<br>
     * FR: Code de toxine botulique de type A.<br>
     * IT: Code per Tossina botulinica tipo A.<br>
     */
    public static final String BOTULINUM_TOXIN_TYPE_A_CODE = "108890005";

    /**
     * EN: Code for Brentuximab vedotin.<br>
     * DE: Code für Brentuximab vedotin.<br>
     * FR: Code de brentuximab védotine.<br>
     * IT: Code per Brentuximab.<br>
     */
    public static final String BRENTUXIMAB_VEDOTIN_CODE = "713395006";

    /**
     * EN: Code for Brexpiprazole.<br>
     * DE: Code für Brexpiprazol.<br>
     * FR: Code de brexpiprazole.<br>
     * IT: Code per Brexpiprazolo.<br>
     */
    public static final String BREXPIPRAZOLE_CODE = "716069007";

    /**
     * EN: Code for Brimonidine.<br>
     * DE: Code für Brimonidin.<br>
     * FR: Code de brimonidine.<br>
     * IT: Code per Brimonidina.<br>
     */
    public static final String BRIMONIDINE_CODE = "372547000";

    /**
     * EN: Code for Brinzolamide.<br>
     * DE: Code für Brinzolamid.<br>
     * FR: Code de brinzolamide.<br>
     * IT: Code per Brinzolamide.<br>
     */
    public static final String BRINZOLAMIDE_CODE = "386925003";

    /**
     * EN: Code for Brivaracetam.<br>
     * DE: Code für Brivaracetam.<br>
     * FR: Code de brivaracétam.<br>
     * IT: Code per Brivaracetam.<br>
     */
    public static final String BRIVARACETAM_CODE = "420813001";

    /**
     * EN: Code for Brivudine.<br>
     * DE: Code für Brivudin.<br>
     * FR: Code de brivudine.<br>
     * IT: Code per Brivudina.<br>
     */
    public static final String BRIVUDINE_CODE = "698049003";

    /**
     * EN: Code for Bromazepam.<br>
     * DE: Code für Bromazepam.<br>
     * FR: Code de bromazépam.<br>
     * IT: Code per Bromazepam.<br>
     */
    public static final String BROMAZEPAM_CODE = "387571009";

    /**
     * EN: Code for Bromfenac.<br>
     * DE: Code für Bromfenac.<br>
     * FR: Code de bromfénac.<br>
     * IT: Code per Bromfenac.<br>
     */
    public static final String BROMFENAC_CODE = "108520008";

    /**
     * EN: Code for Bromocriptine.<br>
     * DE: Code für Bromocriptin.<br>
     * FR: Code de bromocriptine.<br>
     * IT: Code per Bromocriptina.<br>
     */
    public static final String BROMOCRIPTINE_CODE = "387039007";

    /**
     * EN: Code for Budesonide.<br>
     * DE: Code für Budesonid.<br>
     * FR: Code de budésonide.<br>
     * IT: Code per Budesonide.<br>
     */
    public static final String BUDESONIDE_CODE = "395726003";

    /**
     * EN: Code for Bufexamac.<br>
     * DE: Code für Bufexamac.<br>
     * FR: Code de bufexamac.<br>
     * IT: Code per Bufexamac.<br>
     */
    public static final String BUFEXAMAC_CODE = "273952005";

    /**
     * EN: Code for Bupivacaine.<br>
     * DE: Code für Bupivacain.<br>
     * FR: Code de bupivacaïne.<br>
     * IT: Code per Bupivacaina.<br>
     */
    public static final String BUPIVACAINE_CODE = "387150008";

    /**
     * EN: Code for Buprenorphine.<br>
     * DE: Code für Buprenorphin.<br>
     * FR: Code de buprénorphine.<br>
     * IT: Code per Buprenorfina.<br>
     */
    public static final String BUPRENORPHINE_CODE = "387173000";

    /**
     * EN: Code for Bupropion.<br>
     * DE: Code für Bupropion.<br>
     * FR: Code de bupropion.<br>
     * IT: Code per Buproprione.<br>
     */
    public static final String BUPROPION_CODE = "387564004";

    /**
     * EN: Code for Buserelin.<br>
     * DE: Code für Buserelin.<br>
     * FR: Code de buséréline.<br>
     * IT: Code per Buserelina.<br>
     */
    public static final String BUSERELIN_CODE = "395744006";

    /**
     * EN: Code for Butylscopolamine.<br>
     * DE: Code für Butylscopolamin.<br>
     * FR: Code de butylscopolamine.<br>
     * IT: Code per butilscopolamina.<br>
     */
    public static final String BUTYLSCOPOLAMINE_CODE = "1156229000";

    /**
     * EN: Code for Cabazitaxel.<br>
     * DE: Code für Cabazitaxel.<br>
     * FR: Code de cabazitaxel.<br>
     * IT: Code per Cabazitaxel.<br>
     */
    public static final String CABAZITAXEL_CODE = "446706007";

    /**
     * EN: Code for Cabergoline.<br>
     * DE: Code für Cabergolin.<br>
     * FR: Code de cabergoline.<br>
     * IT: Code per Cabergolina.<br>
     */
    public static final String CABERGOLINE_CODE = "386979007";

    /**
     * EN: Code for Caffeine.<br>
     * DE: Code für Coffein.<br>
     * FR: Code de caféine.<br>
     * IT: Code per Caffeina.<br>
     */
    public static final String CAFFEINE_CODE = "255641001";

    /**
     * EN: Code for Calcipotriol.<br>
     * DE: Code für Calcipotriol.<br>
     * FR: Code de calcipotriol.<br>
     * IT: Code per Calcipotriolo.<br>
     */
    public static final String CALCIPOTRIOL_CODE = "395766004";

    /**
     * EN: Code for Calcitriol.<br>
     * DE: Code für Calcitriol.<br>
     * FR: Code de calcitriol.<br>
     * IT: Code per Calcitriolo.<br>
     */
    public static final String CALCITRIOL_CODE = "259333003";

    /**
     * EN: Code for Calcium acetate.<br>
     * DE: Code für Calcium acetat.<br>
     * FR: Code de calcium acétate.<br>
     * IT: Code per Calcio acetato.<br>
     */
    public static final String CALCIUM_ACETATE_CODE = "387019008";

    /**
     * EN: Code for Calcium alginate solution.<br>
     * DE: Code für Calcium alginat.<br>
     * FR: Code de alginate calcique.<br>
     * IT: Code per Calcio alginato.<br>
     */
    public static final String CALCIUM_ALGINATE_SOLUTION_CODE = "256620003";

    /**
     * EN: Code for Calcium carbaspirin.<br>
     * DE: Code für Carbasalat calcium.<br>
     * FR: Code de carbasalate calcique.<br>
     * IT: Code per Calcio carbasalato.<br>
     */
    public static final String CALCIUM_CARBASPIRIN_CODE = "111122008";

    /**
     * EN: Code for Calcium carbonate.<br>
     * DE: Code für Calcium carbonat.<br>
     * FR: Code de calcium carbonate.<br>
     * IT: Code per Calcio carbonato.<br>
     */
    public static final String CALCIUM_CARBONATE_CODE = "387307005";

    /**
     * EN: Code for Calcium chloride.<br>
     * DE: Code für Calciumchlorid.<br>
     * FR: Code de calcium chlorure.<br>
     * IT: Code per Calcio cloruro.<br>
     */
    public static final String CALCIUM_CHLORIDE_CODE = "387377009";

    /**
     * EN: Code for Calcium glubionate.<br>
     * DE: Code für Calcium glubionat.<br>
     * FR: Code de calcium glubionate.<br>
     * IT: Code per Calcio glubionato.<br>
     */
    public static final String CALCIUM_GLUBIONATE_CODE = "32445001";

    /**
     * EN: Code for Calcium gluconate.<br>
     * DE: Code für Calcium gluconat.<br>
     * FR: Code de calcium gluconate.<br>
     * IT: Code per Calcio gluconato.<br>
     */
    public static final String CALCIUM_GLUCONATE_CODE = "387292008";

    /**
     * EN: Code for Calcium leucovorin.<br>
     * DE: Code für Calcium folinat.<br>
     * FR: Code de acide folinique calcique.<br>
     * IT: Code per Calcio folinato.<br>
     */
    public static final String CALCIUM_LEUCOVORIN_CODE = "126223008";

    /**
     * EN: Code for Canagliflozin.<br>
     * DE: Code für Canagliflozin.<br>
     * FR: Code de canagliflozine.<br>
     * IT: Code per Canaglifozin.<br>
     */
    public static final String CANAGLIFLOZIN_CODE = "703676004";

    /**
     * EN: Code for Canakinumab.<br>
     * DE: Code für Canakinumab.<br>
     * FR: Code de canakinumab.<br>
     * IT: Code per Canakinumab.<br>
     */
    public static final String CANAKINUMAB_CODE = "698091001";

    /**
     * EN: Code for Candesartan.<br>
     * DE: Code für Candesartan.<br>
     * FR: Code de candésartan.<br>
     * IT: Code per Candesartan.<br>
     */
    public static final String CANDESARTAN_CODE = "372512008";

    /**
     * EN: Code for Cangrelor.<br>
     * DE: Code für Cangrelor.<br>
     * FR: Code de cangrélor.<br>
     * IT: Code per Cangrelor.<br>
     */
    public static final String CANGRELOR_CODE = "716118009";

    /**
     * EN: Code for Cannabidiol.<br>
     * DE: Code für Cannabidiol (CBD).<br>
     * FR: Code de cannabidiol (CBD).<br>
     * IT: Code per Cannabidiolo.<br>
     */
    public static final String CANNABIDIOL_CODE = "96223000";

    /**
     * EN: Code for Capecitabine.<br>
     * DE: Code für Capecitabin.<br>
     * FR: Code de capécitabine.<br>
     * IT: Code per Capecitabina.<br>
     */
    public static final String CAPECITABINE_CODE = "386906001";

    /**
     * EN: Code for Capsaicin.<br>
     * DE: Code für Capsaicin.<br>
     * FR: Code de capsaïcine.<br>
     * IT: Code per Capsaicina.<br>
     */
    public static final String CAPSAICIN_CODE = "95995002";

    /**
     * EN: Code for Captopril.<br>
     * DE: Code für Captopril.<br>
     * FR: Code de captopril.<br>
     * IT: Code per Captopril.<br>
     */
    public static final String CAPTOPRIL_CODE = "387160004";

    /**
     * EN: Code for Carbachol.<br>
     * DE: Code für Carbachol.<br>
     * FR: Code de carbachol.<br>
     * IT: Code per Carbacolo.<br>
     */
    public static final String CARBACHOL_CODE = "387183001";

    /**
     * EN: Code for Carbamazepine.<br>
     * DE: Code für Carbamazepin.<br>
     * FR: Code de carbamazépine.<br>
     * IT: Code per Carbamazepina.<br>
     */
    public static final String CARBAMAZEPINE_CODE = "387222003";

    /**
     * EN: Code for Carbetocin.<br>
     * DE: Code für Carbetocin.<br>
     * FR: Code de carbétocine.<br>
     * IT: Code per Carbetocina.<br>
     */
    public static final String CARBETOCIN_CODE = "425003007";

    /**
     * EN: Code for Carbidopa.<br>
     * DE: Code für Carbidopa.<br>
     * FR: Code de carbidopa.<br>
     * IT: Code per Carbidopa.<br>
     */
    public static final String CARBIDOPA_CODE = "73579000";

    /**
     * EN: Code for Carbimazole.<br>
     * DE: Code für Carbimazol.<br>
     * FR: Code de carbimazole.<br>
     * IT: Code per Carbimazolo.<br>
     */
    public static final String CARBIMAZOLE_CODE = "395831005";

    /**
     * EN: Code for Carbocisteine.<br>
     * DE: Code für Carbocistein.<br>
     * FR: Code de carbocistéine.<br>
     * IT: Code per Carbocisteina.<br>
     */
    public static final String CARBOCISTEINE_CODE = "395842001";

    /**
     * EN: Code for Carboplatin.<br>
     * DE: Code für Carboplatin.<br>
     * FR: Code de carboplatine.<br>
     * IT: Code per Carboplatino.<br>
     */
    public static final String CARBOPLATIN_CODE = "386905002";

    /**
     * EN: Code for Carfilzomib.<br>
     * DE: Code für Carfilzomib.<br>
     * FR: Code de carfilzomib.<br>
     * IT: Code per Carfilzomib.<br>
     */
    public static final String CARFILZOMIB_CODE = "713463006";

    /**
     * EN: Code for Cariprazine.<br>
     * DE: Code für Cariprazin.<br>
     * FR: Code de cariprazine.<br>
     * IT: Code per Cariprazina.<br>
     */
    public static final String CARIPRAZINE_CODE = "715295006";

    /**
     * EN: Code for Carmustine.<br>
     * DE: Code für Carmustin.<br>
     * FR: Code de carmustine.<br>
     * IT: Code per Carmustina.<br>
     */
    public static final String CARMUSTINE_CODE = "387281007";

    /**
     * EN: Code for Carteolol.<br>
     * DE: Code für Carteolol.<br>
     * FR: Code de cartéolol.<br>
     * IT: Code per Carteololo.<br>
     */
    public static final String CARTEOLOL_CODE = "386866004";

    /**
     * EN: Code for Carvedilol.<br>
     * DE: Code für Carvedilol.<br>
     * FR: Code de carvédilol.<br>
     * IT: Code per Carvedilolo.<br>
     */
    public static final String CARVEDILOL_CODE = "386870007";

    /**
     * EN: Code for Caspofungin.<br>
     * DE: Code für Caspofungin.<br>
     * FR: Code de caspofungine.<br>
     * IT: Code per Caspofungin.<br>
     */
    public static final String CASPOFUNGIN_CODE = "413770001";

    /**
     * EN: Code for Cefaclor.<br>
     * DE: Code für Cefaclor.<br>
     * FR: Code de céfaclor.<br>
     * IT: Code per Cefaclor.<br>
     */
    public static final String CEFACLOR_CODE = "387270009";

    /**
     * EN: Code for Cefazolin.<br>
     * DE: Code für Cefazolin.<br>
     * FR: Code de céfazoline.<br>
     * IT: Code per Cefazolina.<br>
     */
    public static final String CEFAZOLIN_CODE = "387470007";

    /**
     * EN: Code for Cefepime.<br>
     * DE: Code für Cefepim.<br>
     * FR: Code de céfépime.<br>
     * IT: Code per Cefepime.<br>
     */
    public static final String CEFEPIME_CODE = "96048006";

    /**
     * EN: Code for Cefixime anhydrous.<br>
     * DE: Code für Cefixim.<br>
     * FR: Code de céfixime.<br>
     * IT: Code per Cefixima.<br>
     */
    public static final String CEFIXIME_ANHYDROUS_CODE = "785697003";

    /**
     * EN: Code for Cefpodoxime.<br>
     * DE: Code für Cefpodoxim.<br>
     * FR: Code de cefpodoxime.<br>
     * IT: Code per Cefpodoxima.<br>
     */
    public static final String CEFPODOXIME_CODE = "387534007";

    /**
     * EN: Code for Ceftazidime.<br>
     * DE: Code für Ceftazidim.<br>
     * FR: Code de ceftazidime.<br>
     * IT: Code per Ceftazidime.<br>
     */
    public static final String CEFTAZIDIME_CODE = "387200005";

    /**
     * EN: Code for Ceftriaxone.<br>
     * DE: Code für Ceftriaxon.<br>
     * FR: Code de ceftriaxone.<br>
     * IT: Code per Ceftriaxone.<br>
     */
    public static final String CEFTRIAXONE_CODE = "372670001";

    /**
     * EN: Code for Cefuroxime.<br>
     * DE: Code für Cefuroxim.<br>
     * FR: Code de céfuroxime.<br>
     * IT: Code per Cefuroxime.<br>
     */
    public static final String CEFUROXIME_CODE = "372833007";

    /**
     * EN: Code for Celecoxib.<br>
     * DE: Code für Celecoxib.<br>
     * FR: Code de célécoxib.<br>
     * IT: Code per Celecoxib.<br>
     */
    public static final String CELECOXIB_CODE = "116081000";

    /**
     * EN: Code for Cetirizine.<br>
     * DE: Code für Cetirizin.<br>
     * FR: Code de cétirizine.<br>
     * IT: Code per Cetirizina.<br>
     */
    public static final String CETIRIZINE_CODE = "372523007";

    /**
     * EN: Code for Cetylpyridinium.<br>
     * DE: Code für Cetylpyridinium.<br>
     * FR: Code de cétylpyridinium.<br>
     * IT: Code per Cetilpiridinio.<br>
     */
    public static final String CETYLPYRIDINIUM_CODE = "387043006";

    /**
     * EN: Code for Chloramphenicol.<br>
     * DE: Code für Chloramphenicol.<br>
     * FR: Code de chloramphénicol.<br>
     * IT: Code per Cloramfenicolo.<br>
     */
    public static final String CHLORAMPHENICOL_CODE = "372777009";

    /**
     * EN: Code for Chlordiazepoxide.<br>
     * DE: Code für Chlordiazepoxid.<br>
     * FR: Code de chlordiazépoxide.<br>
     * IT: Code per Clordiazepossido.<br>
     */
    public static final String CHLORDIAZEPOXIDE_CODE = "372866006";

    /**
     * EN: Code for Chlorhexidine.<br>
     * DE: Code für Chlorhexidin.<br>
     * FR: Code de chlorhexidine.<br>
     * IT: Code per Clorexidina.<br>
     */
    public static final String CHLORHEXIDINE_CODE = "373568007";

    /**
     * EN: Code for Chlormadinone.<br>
     * DE: Code für Chlormadinon.<br>
     * FR: Code de chlormadinone.<br>
     * IT: Code per Clormadinone.<br>
     */
    public static final String CHLORMADINONE_CODE = "734645001";

    /**
     * EN: Code for Chloroquine.<br>
     * DE: Code für Chloroquin.<br>
     * FR: Code de chloroquine.<br>
     * IT: Code per Clorochina.<br>
     */
    public static final String CHLOROQUINE_CODE = "373468005";

    /**
     * EN: Code for Chlorphenamine.<br>
     * DE: Code für Chlorphenamin.<br>
     * FR: Code de chlorphénamine.<br>
     * IT: Code per Clorfenamina.<br>
     */
    public static final String CHLORPHENAMINE_CODE = "372914003";

    /**
     * EN: Code for Chlorpromazine.<br>
     * DE: Code für Chlorpromazin.<br>
     * FR: Code de chlorpromazine.<br>
     * IT: Code per Clorpromazina.<br>
     */
    public static final String CHLORPROMAZINE_CODE = "387258005";

    /**
     * EN: Code for Chlorprothixene.<br>
     * DE: Code für Chlorprothixen.<br>
     * FR: Code de chlorprothixène.<br>
     * IT: Code per Clorprotixene.<br>
     */
    public static final String CHLORPROTHIXENE_CODE = "387317000";

    /**
     * EN: Code for Chlortalidone.<br>
     * DE: Code für Chlortalidon.<br>
     * FR: Code de chlortalidone.<br>
     * IT: Code per Clortalidone.<br>
     */
    public static final String CHLORTALIDONE_CODE = "387324004";

    /**
     * EN: Code for Chondroitin sulfate.<br>
     * DE: Code für Chondroitinsulfate-Gemisch.<br>
     * FR: Code de chondroïtine sulfate.<br>
     * IT: Code per Condroitinsolfato.<br>
     */
    public static final String CHONDROITIN_SULFATE_CODE = "4104007";

    /**
     * EN: Code for Choriogonadotropin alfa.<br>
     * DE: Code für Choriogonadotropin alfa.<br>
     * FR: Code de choriogonadotropine alfa.<br>
     * IT: Code per Coriogonadotropina alfa.<br>
     */
    public static final String CHORIOGONADOTROPIN_ALFA_CODE = "129494006";

    /**
     * EN: Code for Ciclesonide.<br>
     * DE: Code für Ciclesonid.<br>
     * FR: Code de ciclésonide.<br>
     * IT: Code per Ciclesonide.<br>
     */
    public static final String CICLESONIDE_CODE = "417420004";

    /**
     * EN: Code for Ciclopirox.<br>
     * DE: Code für Ciclopirox.<br>
     * FR: Code de ciclopirox.<br>
     * IT: Code per Ciclopirox.<br>
     */
    public static final String CICLOPIROX_CODE = "372854000";

    /**
     * EN: Code for Ciclosporin.<br>
     * DE: Code für Ciclosporin.<br>
     * FR: Code de ciclosporine.<br>
     * IT: Code per Ciclosporina.<br>
     */
    public static final String CICLOSPORIN_CODE = "387467008";

    /**
     * EN: Code for Cilastatin.<br>
     * DE: Code für Cilastatin.<br>
     * FR: Code de cilastatine.<br>
     * IT: Code per Cilastatina.<br>
     */
    public static final String CILASTATIN_CODE = "96058005";

    /**
     * EN: Code for Cilazapril.<br>
     * DE: Code für Cilazapril.<br>
     * FR: Code de cilazapril.<br>
     * IT: Code per Cilazapril.<br>
     */
    public static final String CILAZAPRIL_CODE = "395947008";

    /**
     * EN: Code for Cimetidine.<br>
     * DE: Code für Cimetidin.<br>
     * FR: Code de cimétidine.<br>
     * IT: Code per Cimetidina.<br>
     */
    public static final String CIMETIDINE_CODE = "373541007";

    /**
     * EN: Code for Cinacalcet.<br>
     * DE: Code für Cinacalcet.<br>
     * FR: Code de cinacalcet.<br>
     * IT: Code per Cinacalcet.<br>
     */
    public static final String CINACALCET_CODE = "409392004";

    /**
     * EN: Code for Cinchocaine.<br>
     * DE: Code für Cinchocain.<br>
     * FR: Code de cinchocaïne.<br>
     * IT: Code per Cincocaina.<br>
     */
    public static final String CINCHOCAINE_CODE = "395953008";

    /**
     * EN: Code for Cinnarizine.<br>
     * DE: Code für Cinnarizin.<br>
     * FR: Code de cinnarizine.<br>
     * IT: Code per Cinnarizina.<br>
     */
    public static final String CINNARIZINE_CODE = "395955001";

    /**
     * EN: Code for Ciprofloxacin.<br>
     * DE: Code für Ciprofloxacin.<br>
     * FR: Code de ciprofloxacine.<br>
     * IT: Code per Ciprofloxacina.<br>
     */
    public static final String CIPROFLOXACIN_CODE = "372840008";

    /**
     * EN: Code for Cisatracurium.<br>
     * DE: Code für Cisatracurium.<br>
     * FR: Code de cisatracurium.<br>
     * IT: Code per Cisatracurio.<br>
     */
    public static final String CISATRACURIUM_CODE = "372495006";

    /**
     * EN: Code for Cisplatin.<br>
     * DE: Code für Cisplatin.<br>
     * FR: Code de cisplatine.<br>
     * IT: Code per Cisplatino.<br>
     */
    public static final String CISPLATIN_CODE = "387318005";

    /**
     * EN: Code for Citalopram.<br>
     * DE: Code für Citalopram.<br>
     * FR: Code de citalopram.<br>
     * IT: Code per Citalopram.<br>
     */
    public static final String CITALOPRAM_CODE = "372596005";

    /**
     * EN: Code for Citric acid monohydrate.<br>
     * DE: Code für Citronensäure-Monohydrat.<br>
     * FR: Code de acide citrique monohydrate.<br>
     * IT: Code per Acido citrico monoidrato.<br>
     */
    public static final String CITRIC_ACID_MONOHYDRATE_CODE = "725962006";

    /**
     * EN: Code for Cladribine.<br>
     * DE: Code für Cladribin.<br>
     * FR: Code de cladribine.<br>
     * IT: Code per Cladribina.<br>
     */
    public static final String CLADRIBINE_CODE = "386916009";

    /**
     * EN: Code for Clarithromycin.<br>
     * DE: Code für Clarithromycin.<br>
     * FR: Code de clarithromycine.<br>
     * IT: Code per Claritromicina.<br>
     */
    public static final String CLARITHROMYCIN_CODE = "387487009";

    /**
     * EN: Code for Clavulanic acid.<br>
     * DE: Code für Clavulansäure.<br>
     * FR: Code de acide clavulanique.<br>
     * IT: Code per Acido clavulanico.<br>
     */
    public static final String CLAVULANIC_ACID_CODE = "395939008";

    /**
     * EN: Code for Clemastine.<br>
     * DE: Code für Clemastin.<br>
     * FR: Code de clémastine.<br>
     * IT: Code per Clemastina.<br>
     */
    public static final String CLEMASTINE_CODE = "372744005";

    /**
     * EN: Code for Clevidipine.<br>
     * DE: Code für Clevidipin.<br>
     * FR: Code de clévidipine.<br>
     * IT: Code per Clevidipina.<br>
     */
    public static final String CLEVIDIPINE_CODE = "439471002";

    /**
     * EN: Code for Clindamycin.<br>
     * DE: Code für Clindamycin.<br>
     * FR: Code de clindamycine.<br>
     * IT: Code per Clindamicina.<br>
     */
    public static final String CLINDAMYCIN_CODE = "372786004";

    /**
     * EN: Code for Clioquinol.<br>
     * DE: Code für Clioquinol.<br>
     * FR: Code de clioquinol.<br>
     * IT: Code per Cliochinolo.<br>
     */
    public static final String CLIOQUINOL_CODE = "387291001";

    /**
     * EN: Code for Clobazam.<br>
     * DE: Code für Clobazam.<br>
     * FR: Code de clobazam.<br>
     * IT: Code per Clobazam.<br>
     */
    public static final String CLOBAZAM_CODE = "387572002";

    /**
     * EN: Code for Clobetasol.<br>
     * DE: Code für Clobetasol.<br>
     * FR: Code de clobétasol.<br>
     * IT: Code per Clobetasolo.<br>
     */
    public static final String CLOBETASOL_CODE = "419129004";

    /**
     * EN: Code for Clobetasone.<br>
     * DE: Code für Clobetason.<br>
     * FR: Code de clobétasone.<br>
     * IT: Code per Clobetasone.<br>
     */
    public static final String CLOBETASONE_CODE = "395963000";

    /**
     * EN: Code for Clofarabine.<br>
     * DE: Code für Clofarabin.<br>
     * FR: Code de clofarabine.<br>
     * IT: Code per Clofarabina.<br>
     */
    public static final String CLOFARABINE_CODE = "413873006";

    /**
     * EN: Code for Clofazimine.<br>
     * DE: Code für Clofazimin.<br>
     * FR: Code de clofazimine.<br>
     * IT: Code per Clofazimina.<br>
     */
    public static final String CLOFAZIMINE_CODE = "387410004";

    /**
     * EN: Code for Clomethiazole.<br>
     * DE: Code für Clomethiazol.<br>
     * FR: Code de clométhiazole.<br>
     * IT: Code per Clometiazolo.<br>
     */
    public static final String CLOMETHIAZOLE_CODE = "395978007";

    /**
     * EN: Code for Clomipramine.<br>
     * DE: Code für Clomipramin.<br>
     * FR: Code de clomipramine.<br>
     * IT: Code per Clomipramina.<br>
     */
    public static final String CLOMIPRAMINE_CODE = "372903001";

    /**
     * EN: Code for Clonazepam.<br>
     * DE: Code für Clonazepam.<br>
     * FR: Code de clonazépam.<br>
     * IT: Code per Clonazepam.<br>
     */
    public static final String CLONAZEPAM_CODE = "387383007";

    /**
     * EN: Code for Clonidine.<br>
     * DE: Code für Clonidin.<br>
     * FR: Code de clonidine.<br>
     * IT: Code per Clonidina.<br>
     */
    public static final String CLONIDINE_CODE = "372805007";

    /**
     * EN: Code for Clopidogrel.<br>
     * DE: Code für Clopidogrel.<br>
     * FR: Code de clopidogrel.<br>
     * IT: Code per Clopidogrel.<br>
     */
    public static final String CLOPIDOGREL_CODE = "386952008";

    /**
     * EN: Code for Clotiapine.<br>
     * DE: Code für Clotiapin.<br>
     * FR: Code de clotiapine.<br>
     * IT: Code per Clotiapina.<br>
     */
    public static final String CLOTIAPINE_CODE = "698028004";

    /**
     * EN: Code for Clotrimazole.<br>
     * DE: Code für Clotrimazol.<br>
     * FR: Code de clotrimazole.<br>
     * IT: Code per Clotrimazolo.<br>
     */
    public static final String CLOTRIMAZOLE_CODE = "387325003";

    /**
     * EN: Code for Clozapine.<br>
     * DE: Code für Clozapin.<br>
     * FR: Code de clozapine.<br>
     * IT: Code per Clozapina.<br>
     */
    public static final String CLOZAPINE_CODE = "387568001";

    /**
     * EN: Code for Coagulation factor II.<br>
     * DE: Code für Blutgerinnungsfaktor II human (Prothrombin).<br>
     * FR: Code de facteur II de coagulation humain (prothrombine).<br>
     * IT: Code per Fattore II di coagulazione umano (protrombina).<br>
     */
    public static final String COAGULATION_FACTOR_II_CODE = "7348004";

    /**
     * EN: Code for Coagulation factor IX.<br>
     * DE: Code für Blutgerinnungsfaktor IX human.<br>
     * FR: Code de facteur IX de coagulation humain.<br>
     * IT: Code per Fattore IX di coagulazione umano.<br>
     */
    public static final String COAGULATION_FACTOR_IX_CODE = "54378000";

    /**
     * EN: Code for Coagulation factor VII.<br>
     * DE: Code für Blutgerinnungsfaktor VII human.<br>
     * FR: Code de facteur VII de coagulation humain.<br>
     * IT: Code per Fattore VII di coagulazione umano.<br>
     */
    public static final String COAGULATION_FACTOR_VII_CODE = "30804005";

    /**
     * EN: Code for Coagulation factor X.<br>
     * DE: Code für Blutgerinnungsfaktor X human.<br>
     * FR: Code de facteur X de coagulation humain.<br>
     * IT: Code per Fattore X di coagulazione umano.<br>
     */
    public static final String COAGULATION_FACTOR_X_CODE = "81444003";

    /**
     * EN: Code for Coagulation factor XIII.<br>
     * DE: Code für Blutgerinnungsfaktor XIII human.<br>
     * FR: Code de facteur XIII de coagulation humain.<br>
     * IT: Code per Fattore XIII di coagulazione umano.<br>
     */
    public static final String COAGULATION_FACTOR_XIII_CODE = "51161000";

    /**
     * EN: Code for Cobicistat.<br>
     * DE: Code für Cobicistat.<br>
     * FR: Code de cobicistat.<br>
     * IT: Code per Cobicistat.<br>
     */
    public static final String COBICISTAT_CODE = "710109003";

    /**
     * EN: Code for Cocaine.<br>
     * DE: Code für Cocain.<br>
     * FR: Code de cocaïne.<br>
     * IT: Code per Cocaina.<br>
     */
    public static final String COCAINE_CODE = "387085005";

    /**
     * EN: Code for Codeine.<br>
     * DE: Code für Codein.<br>
     * FR: Code de codéine.<br>
     * IT: Code per Codeina.<br>
     */
    public static final String CODEINE_CODE = "387494007";

    /**
     * EN: Code for Codeine phosphate hemihydrate.<br>
     * DE: Code für Codein phosphat hemihydrat.<br>
     * FR: Code de codéine phosphate hémihydrate.<br>
     * IT: Code per Codeina fosfato emiidrato.<br>
     */
    public static final String CODEINE_PHOSPHATE_HEMIHYDRATE_CODE = "725666006";

    /**
     * EN: Code for Colchicine.<br>
     * DE: Code für Colchicin.<br>
     * FR: Code de colchicine.<br>
     * IT: Code per Colchicina.<br>
     */
    public static final String COLCHICINE_CODE = "387413002";

    /**
     * EN: Code for Colecalciferol.<br>
     * DE: Code für Colecalciferol (Vitamin D3).<br>
     * FR: Code de colécalciférol (Vitamine D3).<br>
     * IT: Code per Colecalciferolo.<br>
     */
    public static final String COLECALCIFEROL_CODE = "18414002";

    /**
     * EN: Code for Colestyramine.<br>
     * DE: Code für Colestyramin.<br>
     * FR: Code de colestyramine.<br>
     * IT: Code per Colestiramina.<br>
     */
    public static final String COLESTYRAMINE_CODE = "387408001";

    /**
     * EN: Code for Colistin.<br>
     * DE: Code für Colistin.<br>
     * FR: Code de colistine.<br>
     * IT: Code per Colistina.<br>
     */
    public static final String COLISTIN_CODE = "387412007";

    /**
     * EN: Code for Copper sulfate.<br>
     * DE: Code für Kupfer(II)-sulfat, wasserfreies.<br>
     * FR: Code de cuivre sulfate.<br>
     * IT: Code per Rame solfato.<br>
     */
    public static final String COPPER_SULFATE_CODE = "70168001";

    /**
     * EN: Code for Cromoglicate sodium.<br>
     * DE: Code für Cromoglicinsäure, Dinatriumsalz.<br>
     * FR: Code de cromoglicate sodique.<br>
     * IT: Code per Sodio cromoglicato.<br>
     */
    public static final String CROMOGLICATE_SODIUM_CODE = "387221005";

    /**
     * EN: Code for Cromoglicic acid.<br>
     * DE: Code für Cromoglicinsäure.<br>
     * FR: Code de acide cromoglicique.<br>
     * IT: Code per Acido cromoglicico.<br>
     */
    public static final String CROMOGLICIC_ACID_CODE = "372672009";

    /**
     * EN: Code for Cyanocobalamin.<br>
     * DE: Code für Cyanocobalamin (Vitamin B12).<br>
     * FR: Code de cyanocobalamine (Vitamine B12).<br>
     * IT: Code per Cianocobalamina.<br>
     */
    public static final String CYANOCOBALAMIN_CODE = "419382002";

    /**
     * EN: Code for Cyclophosphamide.<br>
     * DE: Code für Cyclophosphamid.<br>
     * FR: Code de cyclophosphamide.<br>
     * IT: Code per Ciclofosfamide.<br>
     */
    public static final String CYCLOPHOSPHAMIDE_CODE = "387420009";

    /**
     * EN: Code for Cycloserine.<br>
     * DE: Code für Cycloserin.<br>
     * FR: Code de cycloserine.<br>
     * IT: Code per Cicloserina.<br>
     */
    public static final String CYCLOSERINE_CODE = "387282000";

    /**
     * EN: Code for Cyproterone.<br>
     * DE: Code für Cyproteron.<br>
     * FR: Code de cyprotérone.<br>
     * IT: Code per Ciproterone.<br>
     */
    public static final String CYPROTERONE_CODE = "126119006";

    /**
     * EN: Code for Cytarabine.<br>
     * DE: Code für Cytarabin.<br>
     * FR: Code de cytarabine.<br>
     * IT: Code per Citarabina.<br>
     */
    public static final String CYTARABINE_CODE = "387511003";

    /**
     * EN: Code for Cytomegalovirus antibody.<br>
     * DE: Code für Cytomegalie-Immunglobulin human.<br>
     * FR: Code de immunoglobuline humaine anti cytomégalovirus.<br>
     * IT: Code per Immunoglobulina umana anti-citomegalovirus.<br>
     */
    public static final String CYTOMEGALOVIRUS_ANTIBODY_CODE = "120941004";

    /**
     * EN: Code for Dabigatran etexilate.<br>
     * DE: Code für Dabigatran etexilat.<br>
     * FR: Code de dabigatran étexilate.<br>
     * IT: Code per Dabigratan etexilato.<br>
     */
    public static final String DABIGATRAN_ETEXILATE_CODE = "700029008";

    /**
     * EN: Code for Dabrafenib.<br>
     * DE: Code für Dabrafenib.<br>
     * FR: Code de dabrafénib.<br>
     * IT: Code per Dabrafenib.<br>
     */
    public static final String DABRAFENIB_CODE = "703641001";

    /**
     * EN: Code for Dacarbazine.<br>
     * DE: Code für Dacarbazin.<br>
     * FR: Code de dacarbazine.<br>
     * IT: Code per Dacarbazina.<br>
     */
    public static final String DACARBAZINE_CODE = "387441003";

    /**
     * EN: Code for Daclatasvir.<br>
     * DE: Code für Daclatasvir.<br>
     * FR: Code de daclatasvir.<br>
     * IT: Code per Daclatasvir.<br>
     */
    public static final String DACLATASVIR_CODE = "712519008";

    /**
     * EN: Code for Dactinomycin.<br>
     * DE: Code für Dactinomycin.<br>
     * FR: Code de dactinomycine.<br>
     * IT: Code per Dactinomicina.<br>
     */
    public static final String DACTINOMYCIN_CODE = "387353003";

    /**
     * EN: Code for Dalteparin sodium.<br>
     * DE: Code für Dalteparin natrium.<br>
     * FR: Code de daltéparine sodique.<br>
     * IT: Code per Dalteparina sodica.<br>
     */
    public static final String DALTEPARIN_SODIUM_CODE = "108987000";

    /**
     * EN: Code for Danaparoid.<br>
     * DE: Code für Danaparoid.<br>
     * FR: Code de danaparoïde.<br>
     * IT: Code per Danaparoid.<br>
     */
    public static final String DANAPAROID_CODE = "372564002";

    /**
     * EN: Code for Dantrolene.<br>
     * DE: Code für Dantrolen.<br>
     * FR: Code de dantrolène.<br>
     * IT: Code per Dantrolene.<br>
     */
    public static final String DANTROLENE_CODE = "372819007";

    /**
     * EN: Code for Dapagliflozin.<br>
     * DE: Code für Dapagliflozin.<br>
     * FR: Code de dapagliflozine.<br>
     * IT: Code per Dapaglifozin.<br>
     */
    public static final String DAPAGLIFLOZIN_CODE = "703674001";

    /**
     * EN: Code for Dapoxetine.<br>
     * DE: Code für Dapoxetin.<br>
     * FR: Code de dapoxétine.<br>
     * IT: Code per Dapoxetina.<br>
     */
    public static final String DAPOXETINE_CODE = "702794006";

    /**
     * EN: Code for Daptomycin.<br>
     * DE: Code für Daptomycin.<br>
     * FR: Code de daptomycine.<br>
     * IT: Code per Daptomicina.<br>
     */
    public static final String DAPTOMYCIN_CODE = "406439009";

    /**
     * EN: Code for Daratumumab.<br>
     * DE: Code für Daratumumab.<br>
     * FR: Code de daratumumab.<br>
     * IT: Code per Daratumumab.<br>
     */
    public static final String DARATUMUMAB_CODE = "716016006";

    /**
     * EN: Code for Darbepoetin alfa.<br>
     * DE: Code für Darbepoetin alfa.<br>
     * FR: Code de darbépoétine alfa.<br>
     * IT: Code per Darbeaoetina alfa.<br>
     */
    public static final String DARBEPOETIN_ALFA_CODE = "385608005";

    /**
     * EN: Code for Darifenacin.<br>
     * DE: Code für Darifenacin.<br>
     * FR: Code de darifénacine.<br>
     * IT: Code per Darifenacina.<br>
     */
    public static final String DARIFENACIN_CODE = "416140008";

    /**
     * EN: Code for Darunavir.<br>
     * DE: Code für Darunavir.<br>
     * FR: Code de darunavir.<br>
     * IT: Code per Darunavir.<br>
     */
    public static final String DARUNAVIR_CODE = "423888002";

    /**
     * EN: Code for Darvadstrocel.<br>
     * DE: Code für Darvadstrocel.<br>
     * FR: Code de darvadstrocel.<br>
     * IT: Code per darvadstrocel.<br>
     */
    public static final String DARVADSTROCEL_CODE = "1156228008";

    /**
     * EN: Code for Dasatinib.<br>
     * DE: Code für Dasatinib.<br>
     * FR: Code de dasatinib.<br>
     * IT: Code per Dasatinib.<br>
     */
    public static final String DASATINIB_CODE = "423658008";

    /**
     * EN: Code for Daunorubicin.<br>
     * DE: Code für Daunorubicin.<br>
     * FR: Code de daunorubicine.<br>
     * IT: Code per Daunorubicina.<br>
     */
    public static final String DAUNORUBICIN_CODE = "372715008";

    /**
     * EN: Code for Decitabine.<br>
     * DE: Code für Decitabin.<br>
     * FR: Code de décitabine.<br>
     * IT: Code per Decitabina.<br>
     */
    public static final String DECITABINE_CODE = "420759005";

    /**
     * EN: Code for Deferasirox.<br>
     * DE: Code für Deferasirox.<br>
     * FR: Code de déférasirox.<br>
     * IT: Code per Deferasirox.<br>
     */
    public static final String DEFERASIROX_CODE = "419985007";

    /**
     * EN: Code for Deferiprone.<br>
     * DE: Code für Deferipron.<br>
     * FR: Code de défériprone.<br>
     * IT: Code per Deferiprone.<br>
     */
    public static final String DEFERIPRONE_CODE = "396011004";

    /**
     * EN: Code for Deferoxamine.<br>
     * DE: Code für Deferoxamin.<br>
     * FR: Code de déféroxamine.<br>
     * IT: Code per Deferoxamina.<br>
     */
    public static final String DEFEROXAMINE_CODE = "372825006";

    /**
     * EN: Code for Defibrotide.<br>
     * DE: Code für Defibrotid.<br>
     * FR: Code de défibrotide.<br>
     * IT: Code per Defibrotide.<br>
     */
    public static final String DEFIBROTIDE_CODE = "442263003";

    /**
     * EN: Code for Deflazacort.<br>
     * DE: Code für Deflazacort.<br>
     * FR: Code de déflazacort.<br>
     * IT: Code per Deflazacort.<br>
     */
    public static final String DEFLAZACORT_CODE = "396012006";

    /**
     * EN: Code for Degarelix.<br>
     * DE: Code für Degarelix.<br>
     * FR: Code de dégarélix.<br>
     * IT: Code per Degarelix.<br>
     */
    public static final String DEGARELIX_CODE = "441864003";

    /**
     * EN: Code for Delta-9-tetrahydrocannabinol.<br>
     * DE: Code für Delta-9-Tetrahydrocannabinol (THC).<br>
     * FR: Code de delta-9-tétrahydrocannabinol (THC).<br>
     * IT: Code per Delta-9-tetracannabinolo (THC).<br>
     */
    public static final String DELTA_9_TETRAHYDROCANNABINOL_CODE = "96225007";

    /**
     * EN: Code for Denosumab.<br>
     * DE: Code für Denosumab.<br>
     * FR: Code de dénosumab.<br>
     * IT: Code per Denosumab.<br>
     */
    public static final String DENOSUMAB_CODE = "446321003";

    /**
     * EN: Code for Desflurane.<br>
     * DE: Code für Desfluran.<br>
     * FR: Code de desflurane.<br>
     * IT: Code per Desflurano.<br>
     */
    public static final String DESFLURANE_CODE = "386841003";

    /**
     * EN: Code for Desloratadine.<br>
     * DE: Code für Desloratadin.<br>
     * FR: Code de desloratadine.<br>
     * IT: Code per Desloratadina.<br>
     */
    public static final String DESLORATADINE_CODE = "396015008";

    /**
     * EN: Code for Desmopressin.<br>
     * DE: Code für Desmopressin.<br>
     * FR: Code de desmopressine.<br>
     * IT: Code per Desmopressina.<br>
     */
    public static final String DESMOPRESSIN_CODE = "126189002";

    /**
     * EN: Code for Desogestrel.<br>
     * DE: Code für Desogestrel.<br>
     * FR: Code de désogestrel.<br>
     * IT: Code per Desogestrel.<br>
     */
    public static final String DESOGESTREL_CODE = "126108008";

    /**
     * EN: Code for Dexamethasone.<br>
     * DE: Code für Dexamethason.<br>
     * FR: Code de dexaméthasone.<br>
     * IT: Code per Desametasone.<br>
     */
    public static final String DEXAMETHASONE_CODE = "372584003";

    /**
     * EN: Code for Dexamfetamine.<br>
     * DE: Code für Dexamfetamin.<br>
     * FR: Code de dexamfétamine.<br>
     * IT: Code per Dexamfetamina.<br>
     */
    public static final String DEXAMFETAMINE_CODE = "387278002";

    /**
     * EN: Code for Dexibuprofen.<br>
     * DE: Code für Dexibuprofen.<br>
     * FR: Code de dexibuprofène.<br>
     * IT: Code per Dexibuprofene.<br>
     */
    public static final String DEXIBUPROFEN_CODE = "418868002";

    /**
     * EN: Code for Dexketoprofen.<br>
     * DE: Code für Dexketoprofen.<br>
     * FR: Code de dexkétoprofène.<br>
     * IT: Code per Desketoprofene.<br>
     */
    public static final String DEXKETOPROFEN_CODE = "396018005";

    /**
     * EN: Code for Dexlansoprazole.<br>
     * DE: Code für Dexlansoprazol.<br>
     * FR: Code de dexlansoprazole.<br>
     * IT: Code per Dexlansoprazolo.<br>
     */
    public static final String DEXLANSOPRAZOLE_CODE = "441863009";

    /**
     * EN: Code for Dexmedetomidine.<br>
     * DE: Code für Dexmedetomidin.<br>
     * FR: Code de dexmédétomidine.<br>
     * IT: Code per Dexmedetomidina.<br>
     */
    public static final String DEXMEDETOMIDINE_CODE = "437750002";

    /**
     * EN: Code for Dexmethylphenidate.<br>
     * DE: Code für Dexmethylphenidat.<br>
     * FR: Code de dexméthylphénidate.<br>
     * IT: Code per Dexmetilfenidato.<br>
     */
    public static final String DEXMETHYLPHENIDATE_CODE = "767715008";

    /**
     * EN: Code for Dexpanthenol.<br>
     * DE: Code für Dexpanthenol.<br>
     * FR: Code de dexpanthénol.<br>
     * IT: Code per Despantenolo.<br>
     */
    public static final String DEXPANTHENOL_CODE = "126226000";

    /**
     * EN: Code for Dexrazoxane.<br>
     * DE: Code für Dexrazoxan.<br>
     * FR: Code de dexrazoxane.<br>
     * IT: Code per Dexrazoxano.<br>
     */
    public static final String DEXRAZOXANE_CODE = "108825009";

    /**
     * EN: Code for Dextromethorphan.<br>
     * DE: Code für Dextromethorphan.<br>
     * FR: Code de dextrométhorphane.<br>
     * IT: Code per Destrometorfano.<br>
     */
    public static final String DEXTROMETHORPHAN_CODE = "387114001";

    /**
     * EN: Code for Diamorphine.<br>
     * DE: Code für Heroin.<br>
     * FR: Code de héroïne.<br>
     * IT: Code per Eroina.<br>
     */
    public static final String DIAMORPHINE_CODE = "387341002";

    /**
     * EN: Code for Diazepam.<br>
     * DE: Code für Diazepam.<br>
     * FR: Code de diazépam.<br>
     * IT: Code per Diazepam.<br>
     */
    public static final String DIAZEPAM_CODE = "387264003";

    /**
     * EN: Code for Diclofenac.<br>
     * DE: Code für Diclofenac.<br>
     * FR: Code de diclofénac.<br>
     * IT: Code per Diclofenac.<br>
     */
    public static final String DICLOFENAC_CODE = "7034005";

    /**
     * EN: Code for Dienogest.<br>
     * DE: Code für Dienogest.<br>
     * FR: Code de diénogest.<br>
     * IT: Code per Dienogest.<br>
     */
    public static final String DIENOGEST_CODE = "703097002";

    /**
     * EN: Code for Diflucortolone.<br>
     * DE: Code für Diflucortolon.<br>
     * FR: Code de diflucortolone.<br>
     * IT: Code per Diflucortolone.<br>
     */
    public static final String DIFLUCORTOLONE_CODE = "395965007";

    /**
     * EN: Code for Digitoxin.<br>
     * DE: Code für Digitoxin.<br>
     * FR: Code de digitoxine.<br>
     * IT: Code per Digitossina.<br>
     */
    public static final String DIGITOXIN_CODE = "373534001";

    /**
     * EN: Code for Digoxin.<br>
     * DE: Code für Digoxin.<br>
     * FR: Code de digoxine.<br>
     * IT: Code per Digossina.<br>
     */
    public static final String DIGOXIN_CODE = "387461009";

    /**
     * EN: Code for Dihydralazine.<br>
     * DE: Code für Dihydralazin.<br>
     * FR: Code de dihydralazine.<br>
     * IT: Code per Diidralazina.<br>
     */
    public static final String DIHYDRALAZINE_CODE = "703113001";

    /**
     * EN: Code for Dihydrocodeine.<br>
     * DE: Code für Dihydrocodein.<br>
     * FR: Code de dihydrocodéine.<br>
     * IT: Code per Diidrocodeina.<br>
     */
    public static final String DIHYDROCODEINE_CODE = "387322000";

    /**
     * EN: Code for Diltiazem.<br>
     * DE: Code für Diltiazem.<br>
     * FR: Code de diltiazem.<br>
     * IT: Code per Diltiazem.<br>
     */
    public static final String DILTIAZEM_CODE = "372793000";

    /**
     * EN: Code for Dimenhydrinate.<br>
     * DE: Code für Dimenhydrinat.<br>
     * FR: Code de diménhydrinate.<br>
     * IT: Code per Dimenidrinato.<br>
     */
    public static final String DIMENHYDRINATE_CODE = "387469006";

    /**
     * EN: Code for Dimethyl sulfoxide.<br>
     * DE: Code für Dimethylsulfoxid.<br>
     * FR: Code de diméthylsulfoxyde.<br>
     * IT: Code per Dimetilsolfossido (DMSO).<br>
     */
    public static final String DIMETHYL_SULFOXIDE_CODE = "115535002";

    /**
     * EN: Code for Dimeticone.<br>
     * DE: Code für Dimeticon.<br>
     * FR: Code de diméticone.<br>
     * IT: Code per Dimeticone.<br>
     */
    public static final String DIMETICONE_CODE = "396031000";

    /**
     * EN: Code for Dimetindene.<br>
     * DE: Code für Dimetinden.<br>
     * FR: Code de dimétindène.<br>
     * IT: Code per Dimetindene.<br>
     */
    public static final String DIMETINDENE_CODE = "387142004";

    /**
     * EN: Code for Dinoprostone.<br>
     * DE: Code für Dinoproston.<br>
     * FR: Code de dinoprostone.<br>
     * IT: Code per Dinoprostone.<br>
     */
    public static final String DINOPROSTONE_CODE = "387245009";

    /**
     * EN: Code for Diosmin.<br>
     * DE: Code für Diosmin.<br>
     * FR: Code de diosmine.<br>
     * IT: Code per Diosmina.<br>
     */
    public static final String DIOSMIN_CODE = "8143001";

    /**
     * EN: Code for Diphenhydramine.<br>
     * DE: Code für Diphenhydramin.<br>
     * FR: Code de diphénhydramine.<br>
     * IT: Code per Difenidramina.<br>
     */
    public static final String DIPHENHYDRAMINE_CODE = "372682005";

    /**
     * EN: Code for Dipotassium clorazepate.<br>
     * DE: Code für Dikalium clorazepat.<br>
     * FR: Code de clorazépate dipotassique.<br>
     * IT: Code per Clorazepato potassico.<br>
     */
    public static final String DIPOTASSIUM_CLORAZEPATE_CODE = "387453004";

    /**
     * EN: Code for Disulfiram.<br>
     * DE: Code für Disulfiram.<br>
     * FR: Code de disulfirame.<br>
     * IT: Code per Disulfiram.<br>
     */
    public static final String DISULFIRAM_CODE = "387212009";

    /**
     * EN: Code for Dobesilate calcium.<br>
     * DE: Code für Calcium dobesilat.<br>
     * FR: Code de dobésilate de calcium.<br>
     * IT: Code per Calcio dobesilato.<br>
     */
    public static final String DOBESILATE_CALCIUM_CODE = "83438009";

    /**
     * EN: Code for Dobutamine.<br>
     * DE: Code für Dobutamin.<br>
     * FR: Code de dobutamine.<br>
     * IT: Code per Dobutamina.<br>
     */
    public static final String DOBUTAMINE_CODE = "387145002";

    /**
     * EN: Code for Docetaxel.<br>
     * DE: Code für Docetaxel.<br>
     * FR: Code de docétaxel.<br>
     * IT: Code per Docetaxel.<br>
     */
    public static final String DOCETAXEL_CODE = "386918005";

    /**
     * EN: Code for Docosahexaenoic acid.<br>
     * DE: Code für Docosahexaensäure DHA.<br>
     * FR: Code de acide docosahexaénoïque DHA.<br>
     * IT: Code per Acido docosaesaenoico (DHA).<br>
     */
    public static final String DOCOSAHEXAENOIC_ACID_CODE = "226368001";

    /**
     * EN: Code for Dolutegravir.<br>
     * DE: Code für Dolutegravir.<br>
     * FR: Code de dolutégravir.<br>
     * IT: Code per Dolutegravir.<br>
     */
    public static final String DOLUTEGRAVIR_CODE = "713464000";

    /**
     * EN: Code for Domperidone.<br>
     * DE: Code für Domperidon.<br>
     * FR: Code de dompéridone.<br>
     * IT: Code per Domperidone.<br>
     */
    public static final String DOMPERIDONE_CODE = "387181004";

    /**
     * EN: Code for Donepezil.<br>
     * DE: Code für Donepezil.<br>
     * FR: Code de donépézil.<br>
     * IT: Code per Donepezil.<br>
     */
    public static final String DONEPEZIL_CODE = "386855006";

    /**
     * EN: Code for Dopamine.<br>
     * DE: Code für Dopamin.<br>
     * FR: Code de dopamine.<br>
     * IT: Code per Dopamina.<br>
     */
    public static final String DOPAMINE_CODE = "412383006";

    /**
     * EN: Code for Dornase alfa.<br>
     * DE: Code für Dornase alfa.<br>
     * FR: Code de dornase alfa.<br>
     * IT: Code per Dornase alfa.<br>
     */
    public static final String DORNASE_ALFA_CODE = "386882003";

    /**
     * EN: Code for Dorzolamide.<br>
     * DE: Code für Dorzolamid.<br>
     * FR: Code de dorzolamide.<br>
     * IT: Code per Dorzolamide.<br>
     */
    public static final String DORZOLAMIDE_CODE = "373447009";

    /**
     * EN: Code for Doxapram.<br>
     * DE: Code für Doxapram.<br>
     * FR: Code de doxapram.<br>
     * IT: Code per Doxapram.<br>
     */
    public static final String DOXAPRAM_CODE = "373339005";

    /**
     * EN: Code for Doxazosin.<br>
     * DE: Code für Doxazosin.<br>
     * FR: Code de doxazosine.<br>
     * IT: Code per Doxazosina.<br>
     */
    public static final String DOXAZOSIN_CODE = "372508002";

    /**
     * EN: Code for Doxepin.<br>
     * DE: Code für Doxepin.<br>
     * FR: Code de doxépine.<br>
     * IT: Code per Doxepina.<br>
     */
    public static final String DOXEPIN_CODE = "372587005";

    /**
     * EN: Code for Doxorubicin.<br>
     * DE: Code für Doxorubicin.<br>
     * FR: Code de doxorubicine.<br>
     * IT: Code per Doxorubicina.<br>
     */
    public static final String DOXORUBICIN_CODE = "372817009";

    /**
     * EN: Code for Doxycycline.<br>
     * DE: Code für Doxycyclin.<br>
     * FR: Code de doxycycline.<br>
     * IT: Code per Doxiciclina.<br>
     */
    public static final String DOXYCYCLINE_CODE = "372478003";

    /**
     * EN: Code for Doxycycline hyclate.<br>
     * DE: Code für Doxycyclin hyclat.<br>
     * FR: Code de doxycycline hyclate.<br>
     * IT: Code per Doxiciclina iclato.<br>
     */
    public static final String DOXYCYCLINE_HYCLATE_CODE = "71417000";

    /**
     * EN: Code for Doxylamine.<br>
     * DE: Code für Doxylamin.<br>
     * FR: Code de doxylamine.<br>
     * IT: Code per Doxilamina.<br>
     */
    public static final String DOXYLAMINE_CODE = "44068004";

    /**
     * EN: Code for Dronedarone.<br>
     * DE: Code für Dronedaron.<br>
     * FR: Code de dronédarone.<br>
     * IT: Code per Dronedarone.<br>
     */
    public static final String DRONEDARONE_CODE = "443195003";

    /**
     * EN: Code for Droperidol.<br>
     * DE: Code für Droperidol.<br>
     * FR: Code de dropéridol.<br>
     * IT: Code per Droperidolo.<br>
     */
    public static final String DROPERIDOL_CODE = "387146001";

    /**
     * EN: Code for Drospirenone.<br>
     * DE: Code für Drospirenon.<br>
     * FR: Code de drospirénone.<br>
     * IT: Code per Drospirenone.<br>
     */
    public static final String DROSPIRENONE_CODE = "410919000";

    /**
     * EN: Code for Dulaglutide.<br>
     * DE: Code für Dulaglutid.<br>
     * FR: Code de dulaglutide.<br>
     * IT: Code per Dulaglutide.<br>
     */
    public static final String DULAGLUTIDE_CODE = "714080005";

    /**
     * EN: Code for Duloxetine.<br>
     * DE: Code für Duloxetin.<br>
     * FR: Code de duloxétine.<br>
     * IT: Code per Duloxetina.<br>
     */
    public static final String DULOXETINE_CODE = "407032004";

    /**
     * EN: Code for Dupilumab.<br>
     * DE: Code für Dupilumab.<br>
     * FR: Code de dupilumab.<br>
     * IT: Code per Dupilumab.<br>
     */
    public static final String DUPILUMAB_CODE = "733487000";

    /**
     * EN: Code for Durvalumab.<br>
     * DE: Code für Durvalumab.<br>
     * FR: Code de durvalumab.<br>
     * IT: Code per Durvalumab.<br>
     */
    public static final String DURVALUMAB_CODE = "735230005";

    /**
     * EN: Code for Dutasteride.<br>
     * DE: Code für Dutasterid.<br>
     * FR: Code de dutastéride.<br>
     * IT: Code per Dutasteride.<br>
     */
    public static final String DUTASTERIDE_CODE = "385572003";

    /**
     * EN: Code for Dydrogesterone.<br>
     * DE: Code für Dydrogesteron.<br>
     * FR: Code de dydrogestérone.<br>
     * IT: Code per Didrogesterone.<br>
     */
    public static final String DYDROGESTERONE_CODE = "126093005";

    /**
     * EN: Code for D-alpha-tocopherol.<br>
     * DE: Code für Tocopherol D-alpha (Vitamin E).<br>
     * FR: Code de tocophérol D-alfa (Vitamine E).<br>
     * IT: Code per D-alfa-tocoferolo (vitamina E).<br>
     */
    public static final String D_ALPHA_TOCOPHEROL_CODE = "116776001";

    /**
     * EN: Code for Econazole.<br>
     * DE: Code für Econazol.<br>
     * FR: Code de éconazole.<br>
     * IT: Code per Econazolo.<br>
     */
    public static final String ECONAZOLE_CODE = "373471002";

    /**
     * EN: Code for Eculizumab.<br>
     * DE: Code für Eculizumab.<br>
     * FR: Code de éculizumab.<br>
     * IT: Code per Eculizumab.<br>
     */
    public static final String ECULIZUMAB_CODE = "427429004";

    /**
     * EN: Code for Edoxaban.<br>
     * DE: Code für Edoxaban.<br>
     * FR: Code de édoxaban.<br>
     * IT: Code per Edoxaban.<br>
     */
    public static final String EDOXABAN_CODE = "712778008";

    /**
     * EN: Code for Efavirenz.<br>
     * DE: Code für Efavirenz.<br>
     * FR: Code de éfavirenz.<br>
     * IT: Code per Efavirenz.<br>
     */
    public static final String EFAVIRENZ_CODE = "387001004";

    /**
     * EN: Code for Eicosapentaenoic acid.<br>
     * DE: Code für Eicosapentaensäure EPA.<br>
     * FR: Code de acide eicosapentaénoïque EPA.<br>
     * IT: Code per Acido eicosapentaenoico EPA.<br>
     */
    public static final String EICOSAPENTAENOIC_ACID_CODE = "226367006";

    /**
     * EN: Code for Eletriptan.<br>
     * DE: Code für Eletriptan.<br>
     * FR: Code de élétriptan.<br>
     * IT: Code per Eletriptan.<br>
     */
    public static final String ELETRIPTAN_CODE = "410843003";

    /**
     * EN: Code for Elotuzumab.<br>
     * DE: Code für Elotuzumab.<br>
     * FR: Code de élotuzumab.<br>
     * IT: Code per Elotuzumab.<br>
     */
    public static final String ELOTUZUMAB_CODE = "715660001";

    /**
     * EN: Code for Eltrombopag.<br>
     * DE: Code für Eltrombopag.<br>
     * FR: Code de eltrombopag.<br>
     * IT: Code per Eltrombopag.<br>
     */
    public static final String ELTROMBOPAG_CODE = "432005001";

    /**
     * EN: Code for Elvitegravir.<br>
     * DE: Code für Elvitegravir.<br>
     * FR: Code de elvitégravir.<br>
     * IT: Code per Elvitegravir.<br>
     */
    public static final String ELVITEGRAVIR_CODE = "708828000";

    /**
     * EN: Code for Emedastine.<br>
     * DE: Code für Emedastin.<br>
     * FR: Code de émédastine.<br>
     * IT: Code per Emedastina.<br>
     */
    public static final String EMEDASTINE_CODE = "372551003";

    /**
     * EN: Code for Emicizumab.<br>
     * DE: Code für Emicizumab.<br>
     * FR: Code de emicizumab.<br>
     * IT: Code per Emicizumab.<br>
     */
    public static final String EMICIZUMAB_CODE = "763611007";

    /**
     * EN: Code for Empagliflozin.<br>
     * DE: Code für Empagliflozin.<br>
     * FR: Code de empagliflozine.<br>
     * IT: Code per Empagliflozin.<br>
     */
    public static final String EMPAGLIFLOZIN_CODE = "703894008";

    /**
     * EN: Code for Emtricitabine.<br>
     * DE: Code für Emtricitabin.<br>
     * FR: Code de emtricitabine.<br>
     * IT: Code per Emtricitabina.<br>
     */
    public static final String EMTRICITABINE_CODE = "404856006";

    /**
     * EN: Code for Enalapril.<br>
     * DE: Code für Enalapril.<br>
     * FR: Code de énalapril.<br>
     * IT: Code per Enalapril.<br>
     */
    public static final String ENALAPRIL_CODE = "372658000";

    /**
     * EN: Code for Encorafenib.<br>
     * DE: Code für Encorafenib.<br>
     * FR: Code de encorafénib.<br>
     * IT: Code per Encorafenib.<br>
     */
    public static final String ENCORAFENIB_CODE = "772201002";

    /**
     * EN: Code for Enoxaparin sodium.<br>
     * DE: Code für Enoxaparin natrium.<br>
     * FR: Code de énoxaparine sodique.<br>
     * IT: Code per Enoxaparina sodica.<br>
     */
    public static final String ENOXAPARIN_SODIUM_CODE = "108983001";

    /**
     * EN: Code for Entacapone.<br>
     * DE: Code für Entacapon.<br>
     * FR: Code de entacapone.<br>
     * IT: Code per Entacapone.<br>
     */
    public static final String ENTACAPONE_CODE = "387018000";

    /**
     * EN: Code for Entecavir.<br>
     * DE: Code für Entecavir.<br>
     * FR: Code de entécavir.<br>
     * IT: Code per Entacavir.<br>
     */
    public static final String ENTECAVIR_CODE = "416644000";

    /**
     * EN: Code for Eosine.<br>
     * DE: Code für Eosin.<br>
     * FR: Code de éosine.<br>
     * IT: Code per Eosina.<br>
     */
    public static final String EOSINE_CODE = "256012001";

    /**
     * EN: Code for Ephedrine.<br>
     * DE: Code für Ephedrin.<br>
     * FR: Code de éphédrine.<br>
     * IT: Code per Efedrina.<br>
     */
    public static final String EPHEDRINE_CODE = "387358007";

    /**
     * EN: Code for Ephedrine sulfate.<br>
     * DE: Code für Ephedrin sulfat.<br>
     * FR: Code de éphédrine sulfate.<br>
     * IT: Code per Efedrina solfato.<br>
     */
    public static final String EPHEDRINE_SULFATE_CODE = "76525000";

    /**
     * EN: Code for Epinastine.<br>
     * DE: Code für Epinastin.<br>
     * FR: Code de épinastine.<br>
     * IT: Code per Epinastine.<br>
     */
    public static final String EPINASTINE_CODE = "407068009";

    /**
     * EN: Code for Epinephrine.<br>
     * DE: Code für Adrenalin (Epinephrin).<br>
     * FR: Code de adrénaline (épinéphrine).<br>
     * IT: Code per Adrenalina (epinefrina).<br>
     */
    public static final String EPINEPHRINE_CODE = "387362001";

    /**
     * EN: Code for Epirubicin.<br>
     * DE: Code für Epirubicin.<br>
     * FR: Code de épirubicine.<br>
     * IT: Code per Epirubicina.<br>
     */
    public static final String EPIRUBICIN_CODE = "417916005";

    /**
     * EN: Code for Eplerenone.<br>
     * DE: Code für Eplerenon.<br>
     * FR: Code de éplérénone.<br>
     * IT: Code per Eplerenone.<br>
     */
    public static final String EPLERENONE_CODE = "407010008";

    /**
     * EN: Code for Epoetin alfa.<br>
     * DE: Code für Epoetin alfa rekombiniert.<br>
     * FR: Code de époétine alfa recombinante.<br>
     * IT: Code per Epoetina alfa ricombinante.<br>
     */
    public static final String EPOETIN_ALFA_CODE = "386947003";

    /**
     * EN: Code for Epoetin beta.<br>
     * DE: Code für Epoetin beta rekombiniert.<br>
     * FR: Code de époétine bêta recombinante.<br>
     * IT: Code per Epoetina beta ricombinante.<br>
     */
    public static final String EPOETIN_BETA_CODE = "396043004";

    /**
     * EN: Code for Epoetin theta.<br>
     * DE: Code für Epoetin theta.<br>
     * FR: Code de époétine thêta.<br>
     * IT: Code per Epoetina teta ricombinante.<br>
     */
    public static final String EPOETIN_THETA_CODE = "708829008";

    /**
     * EN: Code for Epoprostenol.<br>
     * DE: Code für Epoprostenol.<br>
     * FR: Code de époprosténol.<br>
     * IT: Code per Epoprostenolo.<br>
     */
    public static final String EPOPROSTENOL_CODE = "372513003";

    /**
     * EN: Code for Eprosartan.<br>
     * DE: Code für Eprosartan.<br>
     * FR: Code de éprosartan.<br>
     * IT: Code per Eprosartan.<br>
     */
    public static final String EPROSARTAN_CODE = "396044005";

    /**
     * EN: Code for Eptacog alfa.<br>
     * DE: Code für Eptacog alfa (aktiviert).<br>
     * FR: Code de eptacogum alfa (activatum).<br>
     * IT: Code per Eptacog alfa (attivato).<br>
     */
    public static final String EPTACOG_ALFA_CODE = "116066006";

    /**
     * EN: Code for Eptifibatide.<br>
     * DE: Code für Eptifibatid.<br>
     * FR: Code de eptifibatide.<br>
     * IT: Code per Eptifibatide.<br>
     */
    public static final String EPTIFIBATIDE_CODE = "386998009";

    /**
     * EN: Code for Erdosteine.<br>
     * DE: Code für Erdostein.<br>
     * FR: Code de erdostéine.<br>
     * IT: Code per Erdosteina.<br>
     */
    public static final String ERDOSTEINE_CODE = "426292005";

    /**
     * EN: Code for Erenumab.<br>
     * DE: Code für Erenumab.<br>
     * FR: Code de erénumab.<br>
     * IT: Code per Erenumab.<br>
     */
    public static final String ERENUMAB_CODE = "771590007";

    /**
     * EN: Code for Eribulin.<br>
     * DE: Code für Eribulin.<br>
     * FR: Code de éribuline.<br>
     * IT: Code per Eribulina.<br>
     */
    public static final String ERIBULIN_CODE = "708166000";

    /**
     * EN: Code for Erlotinib.<br>
     * DE: Code für Erlotinib.<br>
     * FR: Code de erlotinib.<br>
     * IT: Code per Erlotinib.<br>
     */
    public static final String ERLOTINIB_CODE = "414123001";

    /**
     * EN: Code for Ertapenem.<br>
     * DE: Code für Ertapenem.<br>
     * FR: Code de ertapénem.<br>
     * IT: Code per Ertapenem.<br>
     */
    public static final String ERTAPENEM_CODE = "396346003";

    /**
     * EN: Code for Ertugliflozin.<br>
     * DE: Code für Ertugliflozin.<br>
     * FR: Code de ertugliflozine.<br>
     * IT: Code per Ertugliflozin.<br>
     */
    public static final String ERTUGLIFLOZIN_CODE = "764274008";

    /**
     * EN: Code for Erythromycin.<br>
     * DE: Code für Erythromycin.<br>
     * FR: Code de érythromycine.<br>
     * IT: Code per Eritromicina.<br>
     */
    public static final String ERYTHROMYCIN_CODE = "372694001";

    /**
     * EN: Code for Escitalopram.<br>
     * DE: Code für Escitalopram.<br>
     * FR: Code de escitalopram.<br>
     * IT: Code per Escitalopram.<br>
     */
    public static final String ESCITALOPRAM_CODE = "400447003";

    /**
     * EN: Code for Esmolol.<br>
     * DE: Code für Esmolol.<br>
     * FR: Code de esmolol.<br>
     * IT: Code per Esmololo.<br>
     */
    public static final String ESMOLOL_CODE = "372847006";

    /**
     * EN: Code for Esomeprazole.<br>
     * DE: Code für Esomeprazol.<br>
     * FR: Code de ésoméprazole.<br>
     * IT: Code per Esomeprazolo.<br>
     */
    public static final String ESOMEPRAZOLE_CODE = "396047003";

    /**
     * EN: Code for Estradiol.<br>
     * DE: Code für Estradiol.<br>
     * FR: Code de estradiol.<br>
     * IT: Code per Estradiolo.<br>
     */
    public static final String ESTRADIOL_CODE = "126172005";

    /**
     * EN: Code for Estradiol hemihydrate.<br>
     * DE: Code für Estradiol hemihydrat.<br>
     * FR: Code de estradiol hémihydrate.<br>
     * IT: Code per Estradiolo emiidrato.<br>
     */
    public static final String ESTRADIOL_HEMIHYDRATE_CODE = "116070003";

    /**
     * EN: Code for Estradiol valerate.<br>
     * DE: Code für Estradiol valerat.<br>
     * FR: Code de estradiol valérate.<br>
     * IT: Code per Estradiolo valerato.<br>
     */
    public static final String ESTRADIOL_VALERATE_CODE = "96350008";

    /**
     * EN: Code for Estriol.<br>
     * DE: Code für Estriol.<br>
     * FR: Code de estriol.<br>
     * IT: Code per Estriolo.<br>
     */
    public static final String ESTRIOL_CODE = "73723004";

    /**
     * EN: Code for Etanercept.<br>
     * DE: Code für Etanercept.<br>
     * FR: Code de étanercept.<br>
     * IT: Code per Etanercept.<br>
     */
    public static final String ETANERCEPT_CODE = "387045004";

    /**
     * EN: Code for Etelcalcetide.<br>
     * DE: Code für Etelcalcetid.<br>
     * FR: Code de ételcalcétide.<br>
     * IT: Code per Etelcalcetide.<br>
     */
    public static final String ETELCALCETIDE_CODE = "723539000";

    /**
     * EN: Code for Ethacridine.<br>
     * DE: Code für Ethacridin.<br>
     * FR: Code de éthacridine.<br>
     * IT: Code per Etacridina.<br>
     */
    public static final String ETHACRIDINE_CODE = "711320003";

    /**
     * EN: Code for Ethambutol.<br>
     * DE: Code für Ethambutol.<br>
     * FR: Code de éthambutol.<br>
     * IT: Code per Etambutolo.<br>
     */
    public static final String ETHAMBUTOL_CODE = "387129004";

    /**
     * EN: Code for Ethinylestradiol.<br>
     * DE: Code für Ethinylestradiol.<br>
     * FR: Code de éthinylestradiol.<br>
     * IT: Code per Etinilestradiolo.<br>
     */
    public static final String ETHINYLESTRADIOL_CODE = "126097006";

    /**
     * EN: Code for Ethionamide.<br>
     * DE: Code für Ethionamid.<br>
     * FR: Code de ethionamide.<br>
     * IT: Code per Etionamide.<br>
     */
    public static final String ETHIONAMIDE_CODE = "32800009";

    /**
     * EN: Code for Ethosuximide.<br>
     * DE: Code für Ethosuximid.<br>
     * FR: Code de éthosuximide.<br>
     * IT: Code per Etosuccimide.<br>
     */
    public static final String ETHOSUXIMIDE_CODE = "387244008";

    /**
     * EN: Code for Ethyl chloride.<br>
     * DE: Code für Chlorethan.<br>
     * FR: Code de éthyle chlorure.<br>
     * IT: Code per Cloruro di etile.<br>
     */
    public static final String ETHYL_CHLORIDE_CODE = "22005007";

    /**
     * EN: Code for Etilefrine.<br>
     * DE: Code für Etilefrin.<br>
     * FR: Code de étiléfrine.<br>
     * IT: Code per Etilefrina.<br>
     */
    public static final String ETILEFRINE_CODE = "96255000";

    /**
     * EN: Code for Etodolac.<br>
     * DE: Code für Etodolac.<br>
     * FR: Code de étodolac.<br>
     * IT: Code per Etodolac.<br>
     */
    public static final String ETODOLAC_CODE = "386860005";

    /**
     * EN: Code for Etomidate.<br>
     * DE: Code für Etomidat.<br>
     * FR: Code de étomidate.<br>
     * IT: Code per Etomidato.<br>
     */
    public static final String ETOMIDATE_CODE = "387218008";

    /**
     * EN: Code for Etonogestrel.<br>
     * DE: Code für Etonogestrel.<br>
     * FR: Code de étonogestrel.<br>
     * IT: Code per Etonogestrel.<br>
     */
    public static final String ETONOGESTREL_CODE = "396050000";

    /**
     * EN: Code for Etoposide.<br>
     * DE: Code für Etoposid.<br>
     * FR: Code de étoposide.<br>
     * IT: Code per Etoposide.<br>
     */
    public static final String ETOPOSIDE_CODE = "387316009";

    /**
     * EN: Code for Etoricoxib.<br>
     * DE: Code für Etoricoxib.<br>
     * FR: Code de étoricoxib.<br>
     * IT: Code per Etoricoxib.<br>
     */
    public static final String ETORICOXIB_CODE = "409134009";

    /**
     * EN: Code for Etravirine.<br>
     * DE: Code für Etravirin.<br>
     * FR: Code de étravirine.<br>
     * IT: Code per Etravirina.<br>
     */
    public static final String ETRAVIRINE_CODE = "432121008";

    /**
     * EN: Code for Everolimus.<br>
     * DE: Code für Everolimus.<br>
     * FR: Code de évérolimus.<br>
     * IT: Code per Everolimus.<br>
     */
    public static final String EVEROLIMUS_CODE = "428698007";

    /**
     * EN: Code for Exemestane.<br>
     * DE: Code für Exemestan.<br>
     * FR: Code de exémestane.<br>
     * IT: Code per Exemestane.<br>
     */
    public static final String EXEMESTANE_CODE = "387017005";

    /**
     * EN: Code for Exenatide.<br>
     * DE: Code für Exenatid.<br>
     * FR: Code de exénatide.<br>
     * IT: Code per Exenatide.<br>
     */
    public static final String EXENATIDE_CODE = "416859008";

    /**
     * EN: Code for Ezetimibe.<br>
     * DE: Code für Ezetimib.<br>
     * FR: Code de ézétimibe.<br>
     * IT: Code per Ezetimibe.<br>
     */
    public static final String EZETIMIBE_CODE = "409149001";

    /**
     * EN: Code for Factor VIII.<br>
     * DE: Code für Blutgerinnungsfaktor VIII human.<br>
     * FR: Code de facteur VIII de coagulation humain.<br>
     * IT: Code per Fattore VIII di coagulazione umano.<br>
     */
    public static final String FACTOR_VIII_CODE = "278910002";

    /**
     * EN: Code for Famciclovir.<br>
     * DE: Code für Famciclovir.<br>
     * FR: Code de famciclovir.<br>
     * IT: Code per Famciclovir.<br>
     */
    public static final String FAMCICLOVIR_CODE = "387557001";

    /**
     * EN: Code for Febuxostat.<br>
     * DE: Code für Febuxostat.<br>
     * FR: Code de fébuxostat.<br>
     * IT: Code per Febuxostat.<br>
     */
    public static final String FEBUXOSTAT_CODE = "441743008";

    /**
     * EN: Code for Felbamate.<br>
     * DE: Code für Felbamat.<br>
     * FR: Code de felbamate.<br>
     * IT: Code per Felbamato.<br>
     */
    public static final String FELBAMATE_CODE = "96194006";

    /**
     * EN: Code for Felodipine.<br>
     * DE: Code für Felodipin.<br>
     * FR: Code de félodipine.<br>
     * IT: Code per Felodipina.<br>
     */
    public static final String FELODIPINE_CODE = "386863007";

    /**
     * EN: Code for Fenofibrate.<br>
     * DE: Code für Fenofibrat.<br>
     * FR: Code de fénofibrate.<br>
     * IT: Code per Fenofibrato.<br>
     */
    public static final String FENOFIBRATE_CODE = "386879008";

    /**
     * EN: Code for Fenoterol.<br>
     * DE: Code für Fenoterol.<br>
     * FR: Code de fénotérol.<br>
     * IT: Code per Fenoterolo.<br>
     */
    public static final String FENOTEROL_CODE = "395976006";

    /**
     * EN: Code for Fentanyl.<br>
     * DE: Code für Fentanyl.<br>
     * FR: Code de fentanyl.<br>
     * IT: Code per Fentanil.<br>
     */
    public static final String FENTANYL_CODE = "373492002";

    /**
     * EN: Code for Ferric hexacyanoferrate-II.<br>
     * DE: Code für Eisen(III)-hexacyanoferrat(II).<br>
     * FR: Code de hexacyanoferrate II ferrique III.<br>
     * IT: Code per Esacianoferrato (II) di ferro (III).<br>
     */
    public static final String FERRIC_HEXACYANOFERRATE_II_CODE = "406452004";

    /**
     * EN: Code for Ferrous fumarate.<br>
     * DE: Code für Eisen(II) fumarat.<br>
     * FR: Code de fer II fumarate.<br>
     * IT: Code per Ferro (II) fumarato.<br>
     */
    public static final String FERROUS_FUMARATE_CODE = "387289009";

    /**
     * EN: Code for Ferrous sulfate.<br>
     * DE: Code für Eisen(II)-sulfat.<br>
     * FR: Code de fer sulfate.<br>
     * IT: Code per Solfato ferroso.<br>
     */
    public static final String FERROUS_SULFATE_CODE = "387402000";

    /**
     * EN: Code for Fesoterodine fumarate.<br>
     * DE: Code für Fesoterodin fumarat.<br>
     * FR: Code de fésotérodine fumarate.<br>
     * IT: Code per Fesoterodine fumarato.<br>
     */
    public static final String FESOTERODINE_FUMARATE_CODE = "441469003";

    /**
     * EN: Code for Fexofenadine.<br>
     * DE: Code für Fexofenadin.<br>
     * FR: Code de fexofénadine.<br>
     * IT: Code per Fexofenadina.<br>
     */
    public static final String FEXOFENADINE_CODE = "372522002";

    /**
     * EN: Code for Fidaxomicin.<br>
     * DE: Code für Fidaxomicin.<br>
     * FR: Code de fidaxomicine.<br>
     * IT: Code per Fidaxomicina.<br>
     */
    public static final String FIDAXOMICIN_CODE = "703664004";

    /**
     * EN: Code for Filgrastim.<br>
     * DE: Code für Filgrastim rekombiniert.<br>
     * FR: Code de filgrastim recombinant.<br>
     * IT: Code per Filgrastim.<br>
     */
    public static final String FILGRASTIM_CODE = "386948008";

    /**
     * EN: Code for Finasteride.<br>
     * DE: Code für Finasterid.<br>
     * FR: Code de finastéride.<br>
     * IT: Code per Finasteride.<br>
     */
    public static final String FINASTERIDE_CODE = "386963006";

    /**
     * EN: Code for Fingolimod.<br>
     * DE: Code für Fingolimod.<br>
     * FR: Code de fingolimod.<br>
     * IT: Code per Fingolimod.<br>
     */
    public static final String FINGOLIMOD_CODE = "449000008";

    /**
     * EN: Code for Fish oil.<br>
     * DE: Code für Fischkörperöl.<br>
     * FR: Code de poisson huile.<br>
     * IT: Code per Pesce olio.<br>
     */
    public static final String FISH_OIL_CODE = "735341005";

    /**
     * EN: Code for 5-aminolevulinic acid.<br>
     * DE: Code für 5-Aminolevulinsäure.<br>
     * FR: Code de acide 5-aminolévulinique.<br>
     * IT: Code per Acido 5-aminolevulinico.<br>
     */
    public static final String FIVE_AMINOLEVULINIC_ACID_CODE = "259496005";

    /**
     * EN: Code for Flavoxate.<br>
     * DE: Code für Flavoxat.<br>
     * FR: Code de flavoxate.<br>
     * IT: Code per Flavossato.<br>
     */
    public static final String FLAVOXATE_CODE = "372768002";

    /**
     * EN: Code for Flecainide.<br>
     * DE: Code für Flecainid.<br>
     * FR: Code de flécaïnide.<br>
     * IT: Code per Flecainide.<br>
     */
    public static final String FLECAINIDE_CODE = "372751001";

    /**
     * EN: Code for Flucloxacillin.<br>
     * DE: Code für Flucloxacillin.<br>
     * FR: Code de flucloxacilline.<br>
     * IT: Code per Flucloxacillina.<br>
     */
    public static final String FLUCLOXACILLIN_CODE = "387544009";

    /**
     * EN: Code for Fluconazole.<br>
     * DE: Code für Fluconazol.<br>
     * FR: Code de fluconazole.<br>
     * IT: Code per Fluconazolo.<br>
     */
    public static final String FLUCONAZOLE_CODE = "387174006";

    /**
     * EN: Code for Fludarabine.<br>
     * DE: Code für Fludarabin.<br>
     * FR: Code de fludarabine.<br>
     * IT: Code per Fludarabina.<br>
     */
    public static final String FLUDARABINE_CODE = "386907005";

    /**
     * EN: Code for Fludrocortisone.<br>
     * DE: Code für Fludrocortison.<br>
     * FR: Code de fludrocortisone.<br>
     * IT: Code per Fludrocortisone.<br>
     */
    public static final String FLUDROCORTISONE_CODE = "116586002";

    /**
     * EN: Code for Flufenamic acid.<br>
     * DE: Code für Flufenaminsäure.<br>
     * FR: Code de acide flufénamique.<br>
     * IT: Code per acido flufenamico.<br>
     */
    public static final String FLUFENAMIC_ACID_CODE = "1156232002";

    /**
     * EN: Code for Flumazenil.<br>
     * DE: Code für Flumazenil.<br>
     * FR: Code de flumazénil.<br>
     * IT: Code per Flumazenil.<br>
     */
    public static final String FLUMAZENIL_CODE = "387575000";

    /**
     * EN: Code for Flumetasone.<br>
     * DE: Code für Flumetason.<br>
     * FR: Code de flumétasone.<br>
     * IT: Code per Flumetasone.<br>
     */
    public static final String FLUMETASONE_CODE = "116598007";

    /**
     * EN: Code for Flunarizine.<br>
     * DE: Code für Flunarizin.<br>
     * FR: Code de flunarizine.<br>
     * IT: Code per Flunarizina.<br>
     */
    public static final String FLUNARIZINE_CODE = "418221001";

    /**
     * EN: Code for Flunitrazepam.<br>
     * DE: Code für Flunitrazepam.<br>
     * FR: Code de flunitrazépam.<br>
     * IT: Code per Flunitrazepam.<br>
     */
    public static final String FLUNITRAZEPAM_CODE = "387573007";

    /**
     * EN: Code for Fluocinonide.<br>
     * DE: Code für Fluocinonid.<br>
     * FR: Code de fluocinonide.<br>
     * IT: Code per Fluocinonide.<br>
     */
    public static final String FLUOCINONIDE_CODE = "396060009";

    /**
     * EN: Code for Fluorometholone.<br>
     * DE: Code für Fluorometholon.<br>
     * FR: Code de fluorométholone.<br>
     * IT: Code per Fluorometolone.<br>
     */
    public static final String FLUOROMETHOLONE_CODE = "2925007";

    /**
     * EN: Code for Fluorouracil.<br>
     * DE: Code für Fluorouracil.<br>
     * FR: Code de fluorouracil.<br>
     * IT: Code per Fluorouracile.<br>
     */
    public static final String FLUOROURACIL_CODE = "387172005";

    /**
     * EN: Code for Fluoxetine.<br>
     * DE: Code für Fluoxetin.<br>
     * FR: Code de fluoxétine.<br>
     * IT: Code per Fluoxetina.<br>
     */
    public static final String FLUOXETINE_CODE = "372767007";

    /**
     * EN: Code for Flupentixol.<br>
     * DE: Code für Flupentixol.<br>
     * FR: Code de flupentixol.<br>
     * IT: Code per Flupentixolo.<br>
     */
    public static final String FLUPENTIXOL_CODE = "387567006";

    /**
     * EN: Code for Flupentixol decanoate.<br>
     * DE: Code für Flupentixol decanoat.<br>
     * FR: Code de flupentixol décanoate.<br>
     * IT: Code per Flupentixolo decanoato.<br>
     */
    public static final String FLUPENTIXOL_DECANOATE_CODE = "396062001";

    /**
     * EN: Code for Flurazepam.<br>
     * DE: Code für Flurazepam.<br>
     * FR: Code de flurazépam.<br>
     * IT: Code per Flurazepam.<br>
     */
    public static final String FLURAZEPAM_CODE = "387109000";

    /**
     * EN: Code for Flurbiprofen.<br>
     * DE: Code für Flurbiprofen.<br>
     * FR: Code de flurbiprofène.<br>
     * IT: Code per Flurbiprofene.<br>
     */
    public static final String FLURBIPROFEN_CODE = "373506008";

    /**
     * EN: Code for Fluticasone.<br>
     * DE: Code für Fluticason.<br>
     * FR: Code de fluticasone.<br>
     * IT: Code per Fluticasone.<br>
     */
    public static final String FLUTICASONE_CODE = "397192001";

    /**
     * EN: Code for Fluvastatin.<br>
     * DE: Code für Fluvastatin.<br>
     * FR: Code de fluvastatine.<br>
     * IT: Code per Fluvastatina.<br>
     */
    public static final String FLUVASTATIN_CODE = "387585004";

    /**
     * EN: Code for Fluvoxamine.<br>
     * DE: Code für Fluvoxamin.<br>
     * FR: Code de fluvoxamine.<br>
     * IT: Code per Fluvoxamina.<br>
     */
    public static final String FLUVOXAMINE_CODE = "372905008";

    /**
     * EN: Code for Folic acid.<br>
     * DE: Code für Folsäure.<br>
     * FR: Code de acide folique.<br>
     * IT: Code per Acido folico.<br>
     */
    public static final String FOLIC_ACID_CODE = "63718003";

    /**
     * EN: Code for Folinic acid.<br>
     * DE: Code für Folinsäure.<br>
     * FR: Code de acide folinique.<br>
     * IT: Code per Acido folinico.<br>
     */
    public static final String FOLINIC_ACID_CODE = "396065004";

    /**
     * EN: Code for Follitropin alfa.<br>
     * DE: Code für Follitropin alfa.<br>
     * FR: Code de follitropine alfa.<br>
     * IT: Code per Follitropina alfa.<br>
     */
    public static final String FOLLITROPIN_ALFA_CODE = "395862009";

    /**
     * EN: Code for Follitropin beta.<br>
     * DE: Code für Follitropin beta.<br>
     * FR: Code de follitropine bêta.<br>
     * IT: Code per Follitropina beta.<br>
     */
    public static final String FOLLITROPIN_BETA_CODE = "103028007";

    /**
     * EN: Code for Fomepizole.<br>
     * DE: Code für Fomepizol.<br>
     * FR: Code de fomépizole.<br>
     * IT: Code per Fomepizolo.<br>
     */
    public static final String FOMEPIZOLE_CODE = "386970006";

    /**
     * EN: Code for Fondaparinux sodium.<br>
     * DE: Code für Fondaparinux natrium.<br>
     * FR: Code de fondaparinux sodique.<br>
     * IT: Code per Fondaparinux sodico.<br>
     */
    public static final String FONDAPARINUX_SODIUM_CODE = "385517000";

    /**
     * EN: Code for Formoterol.<br>
     * DE: Code für Formoterol.<br>
     * FR: Code de formotérol.<br>
     * IT: Code per Formoterolo.<br>
     */
    public static final String FORMOTEROL_CODE = "414289007";

    /**
     * EN: Code for Fosamprenavir.<br>
     * DE: Code für Fosamprenavir.<br>
     * FR: Code de fosamprénavir.<br>
     * IT: Code per Fosamprenavir.<br>
     */
    public static final String FOSAMPRENAVIR_CODE = "407017006";

    /**
     * EN: Code for Foscarnet.<br>
     * DE: Code für Foscarnet.<br>
     * FR: Code de foscarnet.<br>
     * IT: Code per Foscarnet.<br>
     */
    public static final String FOSCARNET_CODE = "372902006";

    /**
     * EN: Code for Fosfomycin.<br>
     * DE: Code für Fosfomycin.<br>
     * FR: Code de fosfomycine.<br>
     * IT: Code per Fosfomicina.<br>
     */
    public static final String FOSFOMYCIN_CODE = "372534005";

    /**
     * EN: Code for Fosinopril.<br>
     * DE: Code für Fosinopril.<br>
     * FR: Code de fosinopril.<br>
     * IT: Code per Fosinopril.<br>
     */
    public static final String FOSINOPRIL_CODE = "372510000";

    /**
     * EN: Code for Frovatriptan.<br>
     * DE: Code für Frovatriptan.<br>
     * FR: Code de frovatriptan.<br>
     * IT: Code per Frovatriptan.<br>
     */
    public static final String FROVATRIPTAN_CODE = "411990007";

    /**
     * EN: Code for Fruit bromelain.<br>
     * DE: Code für Bromelain.<br>
     * FR: Code de bromélaïnes.<br>
     * IT: Code per Bromelina.<br>
     */
    public static final String FRUIT_BROMELAIN_CODE = "130663004";

    /**
     * EN: Code for Fulvestrant.<br>
     * DE: Code für Fulvestrant.<br>
     * FR: Code de fulvestrant.<br>
     * IT: Code per Fulvestrant.<br>
     */
    public static final String FULVESTRANT_CODE = "385519002";

    /**
     * EN: Code for Furosemide.<br>
     * DE: Code für Furosemid.<br>
     * FR: Code de furosémide.<br>
     * IT: Code per Furosemide.<br>
     */
    public static final String FUROSEMIDE_CODE = "387475002";

    /**
     * EN: Code for Fusidic acid.<br>
     * DE: Code für Fusidinsäure.<br>
     * FR: Code de acide fusidique.<br>
     * IT: Code per Acido fusidico.<br>
     */
    public static final String FUSIDIC_ACID_CODE = "387530003";

    /**
     * EN: Code for Gabapentin.<br>
     * DE: Code für Gabapentin.<br>
     * FR: Code de gabapentine.<br>
     * IT: Code per Gabapentin.<br>
     */
    public static final String GABAPENTIN_CODE = "386845007";

    /**
     * EN: Code for Gadobutrol.<br>
     * DE: Code für Gadobutrol.<br>
     * FR: Code de gadobutrol.<br>
     * IT: Code per Gadobutrolo.<br>
     */
    public static final String GADOBUTROL_CODE = "418351005";

    /**
     * EN: Code for Gadoteric acid.<br>
     * DE: Code für Gadotersäure.<br>
     * FR: Code de acide gadotérique.<br>
     * IT: Code per Acido gadoterico.<br>
     */
    public static final String GADOTERIC_ACID_CODE = "710812003";

    /**
     * EN: Code for Galactose.<br>
     * DE: Code für Galactose.<br>
     * FR: Code de galactose.<br>
     * IT: Code per Galattosio.<br>
     */
    public static final String GALACTOSE_CODE = "38182007";

    /**
     * EN: Code for Galantamine.<br>
     * DE: Code für Galantamin.<br>
     * FR: Code de galantamine.<br>
     * IT: Code per Galantamina.<br>
     */
    public static final String GALANTAMINE_CODE = "395727007";

    /**
     * EN: Code for Ganciclovir.<br>
     * DE: Code für Ganciclovir.<br>
     * FR: Code de ganciclovir.<br>
     * IT: Code per Ganciclovir.<br>
     */
    public static final String GANCICLOVIR_CODE = "372848001";

    /**
     * EN: Code for Ganirelix.<br>
     * DE: Code für Ganirelix.<br>
     * FR: Code de ganirélix.<br>
     * IT: Code per Ganirelix.<br>
     */
    public static final String GANIRELIX_CODE = "395728002";

    /**
     * EN: Code for Gemcitabine.<br>
     * DE: Code für Gemcitabin.<br>
     * FR: Code de gemcitabine.<br>
     * IT: Code per Gemcitabina.<br>
     */
    public static final String GEMCITABINE_CODE = "386920008";

    /**
     * EN: Code for Gemfibrozil.<br>
     * DE: Code für Gemfibrozil.<br>
     * FR: Code de gemfibrozil.<br>
     * IT: Code per Gemfibrozil.<br>
     */
    public static final String GEMFIBROZIL_CODE = "387189002";

    /**
     * EN: Code for Gentamicin.<br>
     * DE: Code für Gentamicin.<br>
     * FR: Code de gentamicine.<br>
     * IT: Code per Gentamicina.<br>
     */
    public static final String GENTAMICIN_CODE = "387321007";

    /**
     * EN: Code for Gestodene.<br>
     * DE: Code für Gestoden.<br>
     * FR: Code de gestodène.<br>
     * IT: Code per Gestodene.<br>
     */
    public static final String GESTODENE_CODE = "395945000";

    /**
     * EN: Code for Ginkgo biloba.<br>
     * DE: Code für Ginkgo (Ginkgo biloba L.).<br>
     * FR: Code de ginkgo (Ginkgo biloba L.).<br>
     * IT: Code per Ginko (Ginko biloba L.).<br>
     */
    public static final String GINKGO_BILOBA_CODE = "420733007";

    /**
     * EN: Code for Glatiramer.<br>
     * DE: Code für Glatiramer.<br>
     * FR: Code de glatiramère.<br>
     * IT: Code per Glatiramer.<br>
     */
    public static final String GLATIRAMER_CODE = "372535006";

    /**
     * EN: Code for Glibenclamide.<br>
     * DE: Code für Glibenclamid.<br>
     * FR: Code de glibenclamide.<br>
     * IT: Code per Glibenclamide.<br>
     */
    public static final String GLIBENCLAMIDE_CODE = "384978002";

    /**
     * EN: Code for Gliclazide.<br>
     * DE: Code für Gliclazid.<br>
     * FR: Code de gliclazide.<br>
     * IT: Code per Gliclazide.<br>
     */
    public static final String GLICLAZIDE_CODE = "395731001";

    /**
     * EN: Code for Glimepiride.<br>
     * DE: Code für Glimepirid.<br>
     * FR: Code de glimépiride.<br>
     * IT: Code per Glimepiride.<br>
     */
    public static final String GLIMEPIRIDE_CODE = "386966003";

    /**
     * EN: Code for Glucagon.<br>
     * DE: Code für Glucagon.<br>
     * FR: Code de glucagon.<br>
     * IT: Code per Glucagone.<br>
     */
    public static final String GLUCAGON_CODE = "66603002";

    /**
     * EN: Code for Glucose.<br>
     * DE: Code für Glucose.<br>
     * FR: Code de glucose.<br>
     * IT: Code per Glucosio.<br>
     */
    public static final String GLUCOSE_CODE = "67079006";

    /**
     * EN: Code for Glyceryl trinitrate.<br>
     * DE: Code für Nitroglycerin.<br>
     * FR: Code de nitroglycérine.<br>
     * IT: Code per Nitroglicerina.<br>
     */
    public static final String GLYCERYL_TRINITRATE_CODE = "387404004";

    /**
     * EN: Code for Glycine.<br>
     * DE: Code für Glycin.<br>
     * FR: Code de glycine.<br>
     * IT: Code per Glicina.<br>
     */
    public static final String GLYCINE_CODE = "15331006";

    /**
     * EN: Code for Glycocholic acid.<br>
     * DE: Code für Glycocholsäure.<br>
     * FR: Code de acide glycocholique.<br>
     * IT: Code per Acido glicocolico.<br>
     */
    public static final String GLYCOCHOLIC_ACID_CODE = "96314001";

    /**
     * EN: Code for Glycopyrronium.<br>
     * DE: Code für Glycopyrronium-Kation.<br>
     * FR: Code de glycopyrronium.<br>
     * IT: Code per Glicopirronio.<br>
     */
    public static final String GLYCOPYRRONIUM_CODE = "769097000";

    /**
     * EN: Code for Golimumab.<br>
     * DE: Code für Golimumab.<br>
     * FR: Code de golimumab.<br>
     * IT: Code per Golimumab.<br>
     */
    public static final String GOLIMUMAB_CODE = "442435002";

    /**
     * EN: Code for Gonadorelin.<br>
     * DE: Code für Gonadorelin.<br>
     * FR: Code de gonadoréline.<br>
     * IT: Code per Gonadorelina.<br>
     */
    public static final String GONADORELIN_CODE = "397197007";

    /**
     * EN: Code for Goserelin.<br>
     * DE: Code für Goserelin.<br>
     * FR: Code de goséréline.<br>
     * IT: Code per Goserelin.<br>
     */
    public static final String GOSERELIN_CODE = "108771008";

    /**
     * EN: Code for Gramicidin.<br>
     * DE: Code für Gramicidin.<br>
     * FR: Code de gramicidine.<br>
     * IT: Code per Gramicidina.<br>
     */
    public static final String GRAMICIDIN_CODE = "387524003";

    /**
     * EN: Code for Granisetron.<br>
     * DE: Code für Granisetron.<br>
     * FR: Code de granisétron.<br>
     * IT: Code per Granisetron.<br>
     */
    public static final String GRANISETRON_CODE = "372489005";

    /**
     * EN: Code for Guaifenesin.<br>
     * DE: Code für Guaifenesin.<br>
     * FR: Code de guaïfénésine.<br>
     * IT: Code per Guaifenesina.<br>
     */
    public static final String GUAIFENESIN_CODE = "87174009";

    /**
     * EN: Code for Guanfacine.<br>
     * DE: Code für Guanfacin.<br>
     * FR: Code de guanfacine.<br>
     * IT: Code per Guanfacina.<br>
     */
    public static final String GUANFACINE_CODE = "372507007";

    /**
     * EN: Code for Halcinonide.<br>
     * DE: Code für Halcinonid.<br>
     * FR: Code de halcinonide.<br>
     * IT: Code per Alcinonide.<br>
     */
    public static final String HALCINONIDE_CODE = "395735005";

    /**
     * EN: Code for Halometasone.<br>
     * DE: Code für Halometason.<br>
     * FR: Code de halométasone.<br>
     * IT: Code per Alometasone.<br>
     */
    public static final String HALOMETASONE_CODE = "704673003";

    /**
     * EN: Code for Haloperidol.<br>
     * DE: Code für Haloperidol.<br>
     * FR: Code de halopéridol.<br>
     * IT: Code per Aloperidolo.<br>
     */
    public static final String HALOPERIDOL_CODE = "386837002";

    /**
     * EN: Code for Heparin.<br>
     * DE: Code für Heparin.<br>
     * FR: Code de héparine.<br>
     * IT: Code per Eparina.<br>
     */
    public static final String HEPARIN_CODE = "372877000";

    /**
     * EN: Code for Hepatitis B antigen.<br>
     * DE: Code für Hepatitis B Antigen.<br>
     * FR: Code de hepatitis B antigène.<br>
     * IT: Code per Epatite B antigene purificato.<br>
     */
    public static final String HEPATITIS_B_ANTIGEN_CODE = "303233001";

    /**
     * EN: Code for Hexamidine.<br>
     * DE: Code für Hexamidin.<br>
     * FR: Code de hexamidine.<br>
     * IT: Code per Esamidina.<br>
     */
    public static final String HEXAMIDINE_CODE = "703831002";

    /**
     * EN: Code for Hexetidine.<br>
     * DE: Code für Hexetidin.<br>
     * FR: Code de hexétidine.<br>
     * IT: Code per Esetidina.<br>
     */
    public static final String HEXETIDINE_CODE = "387132001";

    /**
     * EN: Code for Hexoprenaline.<br>
     * DE: Code für Hexoprenalin.<br>
     * FR: Code de hexoprénaline.<br>
     * IT: Code per Esoprenalina.<br>
     */
    public static final String HEXOPRENALINE_CODE = "704987001";

    /**
     * EN: Code for Histidine.<br>
     * DE: Code für Histidin.<br>
     * FR: Code de histidine.<br>
     * IT: Code per Istidina.<br>
     */
    public static final String HISTIDINE_CODE = "60260004";

    /**
     * EN: Code for Human antithrombin III.<br>
     * DE: Code für Antithrombin III human.<br>
     * FR: Code de antithrombine III humaine.<br>
     * IT: Code per Antitrombina III umana.<br>
     */
    public static final String HUMAN_ANTITHROMBIN_III_CODE = "412564003";

    /**
     * EN: Code for Human anti-D immunoglobulin.<br>
     * DE: Code für Anti-D-Immunglobulin vom Menschen.<br>
     * FR: Code de immunoglobuline humaine anti-D.<br>
     * IT: Code per Immunoglobulina umana anti-D.<br>
     */
    public static final String HUMAN_ANTI_D_IMMUNOGLOBULIN_CODE = "769102002";

    /**
     * EN: Code for Human chorionic gonadotropin.<br>
     * DE: Code für Choriongonadotropin.<br>
     * FR: Code de gonadotrophine chorionique.<br>
     * IT: Code per Gonadotropina corionica umana (HCG).<br>
     */
    public static final String HUMAN_CHORIONIC_GONADOTROPIN_CODE = "59433001";

    /**
     * EN: Code for Human fibrinogen.<br>
     * DE: Code für Fibrinogen (human).<br>
     * FR: Code de fibrinogène humain.<br>
     * IT: Code per Fibrinogeno umano.<br>
     */
    public static final String HUMAN_FIBRINOGEN_CODE = "418326009";

    /**
     * EN: Code for Human immunoglobulin.<br>
     * DE: Code für Immunglobulin vom Menschen.<br>
     * FR: Code de immunoglobuline humaine.<br>
     * IT: Code per Immunoglobulina umana.<br>
     */
    public static final String HUMAN_IMMUNOGLOBULIN_CODE = "420084002";

    /**
     * EN: Code for Human immunoglobulin G.<br>
     * DE: Code für Immunglobulin G human (IgG).<br>
     * FR: Code de iImmunoglobulinum gamma humanum (IgG).<br>
     * IT: Code per Immunoglobulina G umana (IgG).<br>
     */
    public static final String HUMAN_IMMUNOGLOBULIN_G_CODE = "722197004";

    /**
     * EN: Code for Human insulin.<br>
     * DE: Code für Insulin human.<br>
     * FR: Code de insulines humaines.<br>
     * IT: Code per Insulina umana.<br>
     */
    public static final String HUMAN_INSULIN_CODE = "96367001";

    /**
     * EN: Code for Human menopausal gonadotropin.<br>
     * DE: Code für Menotropin.<br>
     * FR: Code de ménotropine.<br>
     * IT: Code per Menotropina.<br>
     */
    public static final String HUMAN_MENOPAUSAL_GONADOTROPIN_CODE = "8203003";

    /**
     * EN: Code for Hyaluronic acid.<br>
     * DE: Code für Hyaluronsäure.<br>
     * FR: Code de acide hyaluronique.<br>
     * IT: Code per Acido ialuronico.<br>
     */
    public static final String HYALURONIC_ACID_CODE = "38218009";

    /**
     * EN: Code for Hydrochlorothiazide.<br>
     * DE: Code für Hydrochlorothiazid.<br>
     * FR: Code de hydrochlorothiazide.<br>
     * IT: Code per Idrocloratiazide.<br>
     */
    public static final String HYDROCHLOROTHIAZIDE_CODE = "387525002";

    /**
     * EN: Code for Hydrocodone.<br>
     * DE: Code für Hydrocodon.<br>
     * FR: Code de hydrocodone.<br>
     * IT: Code per Idrocodone.<br>
     */
    public static final String HYDROCODONE_CODE = "372671002";

    /**
     * EN: Code for Hydrocortisone.<br>
     * DE: Code für Hydrocortison.<br>
     * FR: Code de hydrocortisone.<br>
     * IT: Code per Idrocortisone.<br>
     */
    public static final String HYDROCORTISONE_CODE = "396458002";

    /**
     * EN: Code for Hydrocortisone acetate.<br>
     * DE: Code für Hydrocortison acetat.<br>
     * FR: Code de hydrocortisone acétate.<br>
     * IT: Code per Idrocortisone acetato.<br>
     */
    public static final String HYDROCORTISONE_ACETATE_CODE = "79380007";

    /**
     * EN: Code for Hydrogen peroxide.<br>
     * DE: Code für Wasserstoffperoxid.<br>
     * FR: Code de peroxyde d´hydrogène.<br>
     * IT: Code per Idrogeno perossido.<br>
     */
    public static final String HYDROGEN_PEROXIDE_CODE = "387171003";

    /**
     * EN: Code for Hydromorphone.<br>
     * DE: Code für Hydromorphon.<br>
     * FR: Code de hydromorphone.<br>
     * IT: Code per Idromorfone.<br>
     */
    public static final String HYDROMORPHONE_CODE = "44508008";

    /**
     * EN: Code for Hydroquinone.<br>
     * DE: Code für Hydrochinon.<br>
     * FR: Code de hydroquinone.<br>
     * IT: Code per Idrochinone.<br>
     */
    public static final String HYDROQUINONE_CODE = "387422001";

    /**
     * EN: Code for Hydrotalcite.<br>
     * DE: Code für Hydrotalcit.<br>
     * FR: Code de hydrotalcite.<br>
     * IT: Code per Idrotalcite.<br>
     */
    public static final String HYDROTALCITE_CODE = "395738007";

    /**
     * EN: Code for Hydroxocobalamin.<br>
     * DE: Code für Hydroxocobalamin.<br>
     * FR: Code de hydroxocobalamine.<br>
     * IT: Code per Idrossocobalamina.<br>
     */
    public static final String HYDROXOCOBALAMIN_CODE = "409258004";

    /**
     * EN: Code for Hydroxycarbamide.<br>
     * DE: Code für Hydroxycarbamid.<br>
     * FR: Code de hydroxycarbamide.<br>
     * IT: Code per Idrossicarbamide.<br>
     */
    public static final String HYDROXYCARBAMIDE_CODE = "387314007";

    /**
     * EN: Code for Hydroxychloroquine.<br>
     * DE: Code für Hydroxychloroquin.<br>
     * FR: Code de hydroxychloroquine.<br>
     * IT: Code per Idrossiclorochina.<br>
     */
    public static final String HYDROXYCHLOROQUINE_CODE = "373540008";

    /**
     * EN: Code for Hydroxyzine.<br>
     * DE: Code für Hydroxyzin.<br>
     * FR: Code de hydroxyzine.<br>
     * IT: Code per Idrossizina.<br>
     */
    public static final String HYDROXYZINE_CODE = "372856003";

    /**
     * EN: Code for Hypericin.<br>
     * DE: Code für Hypericin.<br>
     * FR: Code de hypéricine.<br>
     * IT: Code per Ipericina.<br>
     */
    public static final String HYPERICIN_CODE = "123681008";

    /**
     * EN: Code for Hypericum perforatum extract.<br>
     * DE: Code für Johanniskraut (Hypericum perforatum L.).<br>
     * FR: Code de millepertuis (Hypericum perforatum L.).<br>
     * IT: Code per Iperico (Hypericum perforatum L.).<br>
     */
    public static final String HYPERICUM_PERFORATUM_EXTRACT_CODE = "412515006";

    /**
     * EN: Code for Ibandronic acid.<br>
     * DE: Code für Ibandronsäure.<br>
     * FR: Code de acide ibandronique (ibandronate).<br>
     * IT: Code per Acido ibandronico.<br>
     */
    public static final String IBANDRONIC_ACID_CODE = "420936009";

    /**
     * EN: Code for Ibuprofen.<br>
     * DE: Code für Ibuprofen.<br>
     * FR: Code de ibuprofène.<br>
     * IT: Code per Ibuprofene.<br>
     */
    public static final String IBUPROFEN_CODE = "387207008";

    /**
     * EN: Code for Ibuprofen lysine.<br>
     * DE: Code für Ibuprofen lysin.<br>
     * FR: Code de ibuprofène lysine.<br>
     * IT: Code per Ibuprofene lisina.<br>
     */
    public static final String IBUPROFEN_LYSINE_CODE = "425516000";

    /**
     * EN: Code for Icatibant.<br>
     * DE: Code für Icatibant.<br>
     * FR: Code de icatibant.<br>
     * IT: Code per Icatibant.<br>
     */
    public static final String ICATIBANT_CODE = "703834005";

    /**
     * EN: Code for Idarubicin.<br>
     * DE: Code für Idarubicin.<br>
     * FR: Code de idarubicine.<br>
     * IT: Code per Idarubicina.<br>
     */
    public static final String IDARUBICIN_CODE = "372539000";

    /**
     * EN: Code for Idarucizumab.<br>
     * DE: Code für Idarucizumab.<br>
     * FR: Code de idarucizumab.<br>
     * IT: Code per Idarucizumab.<br>
     */
    public static final String IDARUCIZUMAB_CODE = "716017002";

    /**
     * EN: Code for Idebenone.<br>
     * DE: Code für Idebenon.<br>
     * FR: Code de idébénone.<br>
     * IT: Code per Idebenone.<br>
     */
    public static final String IDEBENONE_CODE = "429666007";

    /**
     * EN: Code for Idelalisib.<br>
     * DE: Code für Idelalisib.<br>
     * FR: Code de idélalisib.<br>
     * IT: Code per Idelalisib.<br>
     */
    public static final String IDELALISIB_CODE = "710278000";

    /**
     * EN: Code for Ifosfamide.<br>
     * DE: Code für Ifosfamid.<br>
     * FR: Code de ifosfamide.<br>
     * IT: Code per Ifosfamide.<br>
     */
    public static final String IFOSFAMIDE_CODE = "386904003";

    /**
     * EN: Code for Iloprost.<br>
     * DE: Code für Iloprost.<br>
     * FR: Code de iloprost.<br>
     * IT: Code per Iloprost.<br>
     */
    public static final String ILOPROST_CODE = "395740002";

    /**
     * EN: Code for Imatinib.<br>
     * DE: Code für Imatinib.<br>
     * FR: Code de imatinib.<br>
     * IT: Code per Imatinib.<br>
     */
    public static final String IMATINIB_CODE = "414460008";

    /**
     * EN: Code for Imiglucerase.<br>
     * DE: Code für Imiglucerase.<br>
     * FR: Code de imiglucérase.<br>
     * IT: Code per Imiglucerasi.<br>
     */
    public static final String IMIGLUCERASE_CODE = "386968002";

    /**
     * EN: Code for Imipenem.<br>
     * DE: Code für Imipenem.<br>
     * FR: Code de imipénem.<br>
     * IT: Code per Imipenem.<br>
     */
    public static final String IMIPENEM_CODE = "46558003";

    /**
     * EN: Code for Imipramine.<br>
     * DE: Code für Imipramin.<br>
     * FR: Code de imipramine.<br>
     * IT: Code per Imipramina.<br>
     */
    public static final String IMIPRAMINE_CODE = "372718005";

    /**
     * EN: Code for Imiquimod.<br>
     * DE: Code für Imiquimod.<br>
     * FR: Code de imiquimod.<br>
     * IT: Code per Imiquimod.<br>
     */
    public static final String IMIQUIMOD_CODE = "386941002";

    /**
     * EN: Code for Immunoglobulin A.<br>
     * DE: Code für Immunglobulin A human (IgA).<br>
     * FR: Code de immunglobulin A human (IgA).<br>
     * IT: Code per Immunoglobulina A umana (IgA).<br>
     */
    public static final String IMMUNOGLOBULIN_A_CODE = "46046006";

    /**
     * EN: Code for Immunoglobulin M.<br>
     * DE: Code für Immunglobulin M human (IgM).<br>
     * FR: Code de immunoglobuline M humaine (IgM).<br>
     * IT: Code per Immunoglobulina M umana (IgM).<br>
     */
    public static final String IMMUNOGLOBULIN_M_CODE = "74889000";

    /**
     * EN: Code for Immunologic substance.<br>
     * DE: Code für Immunologic substance.<br>
     * FR: Code de substance immunologique.<br>
     * IT: Code per Immunologic substance.<br>
     */
    public static final String IMMUNOLOGIC_SUBSTANCE_CODE = "106181007";

    /**
     * EN: Code for Indacaterol.<br>
     * DE: Code für Indacaterol.<br>
     * FR: Code de indacatérol.<br>
     * IT: Code per Indacaterol.<br>
     */
    public static final String INDACATEROL_CODE = "702801003";

    /**
     * EN: Code for Indapamide.<br>
     * DE: Code für Indapamid.<br>
     * FR: Code de indapamide.<br>
     * IT: Code per Indapamide.<br>
     */
    public static final String INDAPAMIDE_CODE = "387419003";

    /**
     * EN: Code for Indometacin.<br>
     * DE: Code für Indometacin.<br>
     * FR: Code de indométacine.<br>
     * IT: Code per Indometacina.<br>
     */
    public static final String INDOMETACIN_CODE = "373513008";

    /**
     * EN: Code for Infliximab.<br>
     * DE: Code für Infliximab.<br>
     * FR: Code de infliximab.<br>
     * IT: Code per Infliximab.<br>
     */
    public static final String INFLIXIMAB_CODE = "386891004";

    /**
     * EN: Code for Inositol.<br>
     * DE: Code für Inositol.<br>
     * FR: Code de inositol.<br>
     * IT: Code per Inositolo.<br>
     */
    public static final String INOSITOL_CODE = "72164009";

    /**
     * EN: Code for Insulin aspart.<br>
     * DE: Code für Insulin aspart.<br>
     * FR: Code de insuline asparte.<br>
     * IT: Code per Insulina aspartat.<br>
     */
    public static final String INSULIN_ASPART_CODE = "325072002";

    /**
     * EN: Code for Insulin degludec.<br>
     * DE: Code für Insulin degludec.<br>
     * FR: Code de insuline dégludec.<br>
     * IT: Code per Insulina degludec.<br>
     */
    public static final String INSULIN_DEGLUDEC_CODE = "710281005";

    /**
     * EN: Code for Insulin detemir.<br>
     * DE: Code für Insulin detemir.<br>
     * FR: Code de insuline détémir.<br>
     * IT: Code per Insulina detemir.<br>
     */
    public static final String INSULIN_DETEMIR_CODE = "414515005";

    /**
     * EN: Code for Insulin glargine.<br>
     * DE: Code für Insulin glargin.<br>
     * FR: Code de insuline glargine.<br>
     * IT: Code per Insulina glargine.<br>
     */
    public static final String INSULIN_GLARGINE_CODE = "411529005";

    /**
     * EN: Code for Insulin glulisine.<br>
     * DE: Code für Insulin glulisin.<br>
     * FR: Code de insuline glulisine.<br>
     * IT: Code per Insulina glulisina.<br>
     */
    public static final String INSULIN_GLULISINE_CODE = "411530000";

    /**
     * EN: Code for Insulin lispro.<br>
     * DE: Code für Insulin lispro.<br>
     * FR: Code de insuline lispro.<br>
     * IT: Code per Insulina lispro.<br>
     */
    public static final String INSULIN_LISPRO_CODE = "412210000";

    /**
     * EN: Code for Interferon alfa-2a.<br>
     * DE: Code für Interferon alfa-2a.<br>
     * FR: Code de interféron alfa 2a.<br>
     * IT: Code per Interferone alfa 2a.<br>
     */
    public static final String INTERFERON_ALFA_2A_CODE = "386914007";

    /**
     * EN: Code for Interferon alfa-2b.<br>
     * DE: Code für Interferon alfa-2b.<br>
     * FR: Code de interféron alfa 2b.<br>
     * IT: Code per Interferone alfa 2b.<br>
     */
    public static final String INTERFERON_ALFA_2B_CODE = "386915008";

    /**
     * EN: Code for Interferon beta-1a.<br>
     * DE: Code für Interferon beta-1a.<br>
     * FR: Code de interféron bêta-1a.<br>
     * IT: Code per Interferone beta 1a.<br>
     */
    public static final String INTERFERON_BETA_1A_CODE = "386902004";

    /**
     * EN: Code for Interferon beta-1b.<br>
     * DE: Code für Interferon beta-1b.<br>
     * FR: Code de interféron bêta 1b.<br>
     * IT: Code per Interferone beta 1b.<br>
     */
    public static final String INTERFERON_BETA_1B_CODE = "386903009";

    /**
     * EN: Code for Interferon gamma-1b.<br>
     * DE: Code für Interferon gamma-1b.<br>
     * FR: Code de interféron gamma 1b.<br>
     * IT: Code per Interferone gamma 1b.<br>
     */
    public static final String INTERFERON_GAMMA_1B_CODE = "386901006";

    /**
     * EN: Code for Inulin.<br>
     * DE: Code für Inulin.<br>
     * FR: Code de inuline.<br>
     * IT: Code per Inulina.<br>
     */
    public static final String INULIN_CODE = "32154009";

    /**
     * EN: Code for Iodixanol.<br>
     * DE: Code für Iodixanol.<br>
     * FR: Code de iodixanol.<br>
     * IT: Code per Iodixanolo.<br>
     */
    public static final String IODIXANOL_CODE = "395750001";

    /**
     * EN: Code for Iohexol.<br>
     * DE: Code für Iohexol.<br>
     * FR: Code de iohexol.<br>
     * IT: Code per Ioexolo.<br>
     */
    public static final String IOHEXOL_CODE = "395751002";

    /**
     * EN: Code for Iopamidol.<br>
     * DE: Code für Iopamidol.<br>
     * FR: Code de iopamidol.<br>
     * IT: Code per Iopamidolo.<br>
     */
    public static final String IOPAMIDOL_CODE = "395754005";

    /**
     * EN: Code for Iopromide.<br>
     * DE: Code für Iopromid.<br>
     * FR: Code de iopromide.<br>
     * IT: Code per Iopromide.<br>
     */
    public static final String IOPROMIDE_CODE = "395756007";

    /**
     * EN: Code for Ipilimumab.<br>
     * DE: Code für Ipilimumab.<br>
     * FR: Code de ipilimumab.<br>
     * IT: Code per Ipilimumab.<br>
     */
    public static final String IPILIMUMAB_CODE = "697995005";

    /**
     * EN: Code for Ipratropium.<br>
     * DE: Code für Ipratropium.<br>
     * FR: Code de ipratropium.<br>
     * IT: Code per Ipratropio.<br>
     */
    public static final String IPRATROPIUM_CODE = "372518007";

    /**
     * EN: Code for Irbesartan.<br>
     * DE: Code für Irbesartan.<br>
     * FR: Code de irbésartan.<br>
     * IT: Code per Irbesartan.<br>
     */
    public static final String IRBESARTAN_CODE = "386877005";

    /**
     * EN: Code for Irinotecan.<br>
     * DE: Code für Irinotecan.<br>
     * FR: Code de irinotécan.<br>
     * IT: Code per Irinotecan.<br>
     */
    public static final String IRINOTECAN_CODE = "372538008";

    /**
     * EN: Code for Iron.<br>
     * DE: Code für Eisen.<br>
     * FR: Code de fer.<br>
     * IT: Code per Ferro.<br>
     */
    public static final String IRON_CODE = "3829006";

    /**
     * EN: Code for Iron polymaltose.<br>
     * DE: Code für Eisen(III)-hydroxid-Polymaltose-Komplex.<br>
     * FR: Code de fer hydroxyde polymalté.<br>
     * IT: Code per Ferro (III) idrossido polimaltosato.<br>
     */
    public static final String IRON_POLYMALTOSE_CODE = "708805001";

    /**
     * EN: Code for Isavuconazole.<br>
     * DE: Code für Isavuconazol.<br>
     * FR: Code de isavuconazole.<br>
     * IT: Code per Isavuconazolo.<br>
     */
    public static final String ISAVUCONAZOLE_CODE = "765386003";

    /**
     * EN: Code for Isoconazole.<br>
     * DE: Code für Isoconazol.<br>
     * FR: Code de isoconazole.<br>
     * IT: Code per Isoconazolo.<br>
     */
    public static final String ISOCONAZOLE_CODE = "418371001";

    /**
     * EN: Code for Isoleucine.<br>
     * DE: Code für Isoleucin.<br>
     * FR: Code de isoleucine.<br>
     * IT: Code per Isoleucina.<br>
     */
    public static final String ISOLEUCINE_CODE = "14971004";

    /**
     * EN: Code for Isoniazid.<br>
     * DE: Code für Isoniazid.<br>
     * FR: Code de isoniazide.<br>
     * IT: Code per Isoniazide.<br>
     */
    public static final String ISONIAZID_CODE = "387472004";

    /**
     * EN: Code for Isoprenaline.<br>
     * DE: Code für Isoprenalin.<br>
     * FR: Code de isoprénaline.<br>
     * IT: Code per Isoprenalina.<br>
     */
    public static final String ISOPRENALINE_CODE = "372781009";

    /**
     * EN: Code for Isopropyl alcohol.<br>
     * DE: Code für Isopropylalkohol.<br>
     * FR: Code de isopropanol.<br>
     * IT: Code per Alcol isopropilico.<br>
     */
    public static final String ISOPROPYL_ALCOHOL_CODE = "259268001";

    /**
     * EN: Code for Isosorbide dinitrate.<br>
     * DE: Code für Isosorbid dinitrat.<br>
     * FR: Code de isosorbide dinitrate.<br>
     * IT: Code per Isosorbide dinitrato.<br>
     */
    public static final String ISOSORBIDE_DINITRATE_CODE = "387332007";

    /**
     * EN: Code for Isotretinoin.<br>
     * DE: Code für Isotretinoin.<br>
     * FR: Code de isotrétinoïne.<br>
     * IT: Code per Isotretinoina.<br>
     */
    public static final String ISOTRETINOIN_CODE = "387208003";

    /**
     * EN: Code for Itraconazole.<br>
     * DE: Code für Itraconazol.<br>
     * FR: Code de itraconazole.<br>
     * IT: Code per Itraconazolo.<br>
     */
    public static final String ITRACONAZOLE_CODE = "387532006";

    /**
     * EN: Code for Ivabradine.<br>
     * DE: Code für Ivabradin.<br>
     * FR: Code de ivabradine.<br>
     * IT: Code per Ivabradina.<br>
     */
    public static final String IVABRADINE_CODE = "421228002";

    /**
     * EN: Code for Ivacaftor.<br>
     * DE: Code für Ivacaftor.<br>
     * FR: Code de ivacaftor.<br>
     * IT: Code per Ivacaftor.<br>
     */
    public static final String IVACAFTOR_CODE = "703823007";

    /**
     * EN: Code for Ivermectin.<br>
     * DE: Code für Ivermectin.<br>
     * FR: Code de ivermectine.<br>
     * IT: Code per Ivermectina.<br>
     */
    public static final String IVERMECTIN_CODE = "387559003";

    /**
     * EN: Code for Ixekizumab.<br>
     * DE: Code für Ixekizumab.<br>
     * FR: Code de ixékizumab.<br>
     * IT: Code per Ixekizumab.<br>
     */
    public static final String IXEKIZUMAB_CODE = "724037000";

    /**
     * EN: Code for Ketamine.<br>
     * DE: Code für Ketamin.<br>
     * FR: Code de kétamine.<br>
     * IT: Code per Ketamina.<br>
     */
    public static final String KETAMINE_CODE = "373464007";

    /**
     * EN: Code for Ketoconazole.<br>
     * DE: Code für Ketoconazol.<br>
     * FR: Code de kétoconazole.<br>
     * IT: Code per Ketoconazolo.<br>
     */
    public static final String KETOCONAZOLE_CODE = "387216007";

    /**
     * EN: Code for Ketoprofen.<br>
     * DE: Code für Ketoprofen.<br>
     * FR: Code de kétoprofène.<br>
     * IT: Code per Ketoprofene.<br>
     */
    public static final String KETOPROFEN_CODE = "386832008";

    /**
     * EN: Code for Ketorolac.<br>
     * DE: Code für Ketorolac.<br>
     * FR: Code de kétorolac.<br>
     * IT: Code per Ketorolac.<br>
     */
    public static final String KETOROLAC_CODE = "372501008";

    /**
     * EN: Code for Ketotifen.<br>
     * DE: Code für Ketotifen.<br>
     * FR: Code de kétotifène.<br>
     * IT: Code per Ketotifene.<br>
     */
    public static final String KETOTIFEN_CODE = "372642003";

    /**
     * EN: Code for Labetalol.<br>
     * DE: Code für Labetalol.<br>
     * FR: Code de labétalol.<br>
     * IT: Code per Labetalolo.<br>
     */
    public static final String LABETALOL_CODE = "372750000";

    /**
     * EN: Code for Lacosamide.<br>
     * DE: Code für Lacosamid.<br>
     * FR: Code de lacosamide.<br>
     * IT: Code per Lacosamide.<br>
     */
    public static final String LACOSAMIDE_CODE = "441647003";

    /**
     * EN: Code for Lactitol.<br>
     * DE: Code für Lactitol.<br>
     * FR: Code de lactitol.<br>
     * IT: Code per Lattilolo.<br>
     */
    public static final String LACTITOL_CODE = "418929008";

    /**
     * EN: Code for Lactose.<br>
     * DE: Code für Lactose.<br>
     * FR: Code de lactose.<br>
     * IT: Code per Lattosio.<br>
     */
    public static final String LACTOSE_CODE = "47703008";

    /**
     * EN: Code for Lactulose.<br>
     * DE: Code für Lactulose.<br>
     * FR: Code de lactulose.<br>
     * IT: Code per Lattulosio.<br>
     */
    public static final String LACTULOSE_CODE = "273945008";

    /**
     * EN: Code for Lamivudine.<br>
     * DE: Code für Lamivudin.<br>
     * FR: Code de lamivudine.<br>
     * IT: Code per Lamivudina.<br>
     */
    public static final String LAMIVUDINE_CODE = "386897000";

    /**
     * EN: Code for Lamotrigine.<br>
     * DE: Code für Lamotrigin.<br>
     * FR: Code de lamotrigine.<br>
     * IT: Code per Lamotrigina.<br>
     */
    public static final String LAMOTRIGINE_CODE = "387562000";

    /**
     * EN: Code for Lanreotide.<br>
     * DE: Code für Lanreotid.<br>
     * FR: Code de lanréotide.<br>
     * IT: Code per Lanreotide.<br>
     */
    public static final String LANREOTIDE_CODE = "395765000";

    /**
     * EN: Code for Lansoprazole.<br>
     * DE: Code für Lansoprazol.<br>
     * FR: Code de lansoprazole.<br>
     * IT: Code per Lansoprazolo.<br>
     */
    public static final String LANSOPRAZOLE_CODE = "386888004";

    /**
     * EN: Code for Lanthanum carbonate.<br>
     * DE: Code für Lanthan(III) carbonat.<br>
     * FR: Code de lanthane(III) carbonate.<br>
     * IT: Code per Lantanio carbonato.<br>
     */
    public static final String LANTHANUM_CARBONATE_CODE = "414571007";

    /**
     * EN: Code for Latanoprost.<br>
     * DE: Code für Latanoprost.<br>
     * FR: Code de latanoprost.<br>
     * IT: Code per Latanoprost.<br>
     */
    public static final String LATANOPROST_CODE = "386926002";

    /**
     * EN: Code for Lauromacrogol 400.<br>
     * DE: Code für Lauromacrogol 400.<br>
     * FR: Code de lauromacrogol 400.<br>
     * IT: Code per Lauromacrogol.<br>
     */
    public static final String LAUROMACROGOL_400_CODE = "427905004";

    /**
     * EN: Code for Leflunomide.<br>
     * DE: Code für Leflunomid.<br>
     * FR: Code de léflunomide.<br>
     * IT: Code per Leflunomide.<br>
     */
    public static final String LEFLUNOMIDE_CODE = "386981009";

    /**
     * EN: Code for Lenalidomide.<br>
     * DE: Code für Lenalidomid.<br>
     * FR: Code de lénalidomide.<br>
     * IT: Code per Lenalidomide.<br>
     */
    public static final String LENALIDOMIDE_CODE = "421471009";

    /**
     * EN: Code for Lenograstime.<br>
     * DE: Code für Lenograstim.<br>
     * FR: Code de lénograstim.<br>
     * IT: Code per Lenograstim.<br>
     */
    public static final String LENOGRASTIME_CODE = "395767008";

    /**
     * EN: Code for Lercanidipine.<br>
     * DE: Code für Lercanidipin.<br>
     * FR: Code de lercanidipine.<br>
     * IT: Code per Lercanidipina.<br>
     */
    public static final String LERCANIDIPINE_CODE = "395986007";

    /**
     * EN: Code for Letrozole.<br>
     * DE: Code für Letrozol.<br>
     * FR: Code de létrozole.<br>
     * IT: Code per Letrozolo.<br>
     */
    public static final String LETROZOLE_CODE = "386911004";

    /**
     * EN: Code for Leucine.<br>
     * DE: Code für Leucin.<br>
     * FR: Code de leucine.<br>
     * IT: Code per Leucina.<br>
     */
    public static final String LEUCINE_CODE = "83797003";

    /**
     * EN: Code for Leuprorelin.<br>
     * DE: Code für Leuprorelin.<br>
     * FR: Code de leuproréline.<br>
     * IT: Code per Leuprorelina.<br>
     */
    public static final String LEUPRORELIN_CODE = "397198002";

    /**
     * EN: Code for Levetiracetam.<br>
     * DE: Code für Levetiracetam.<br>
     * FR: Code de lévétiracétam.<br>
     * IT: Code per Levetiracetam.<br>
     */
    public static final String LEVETIRACETAM_CODE = "387000003";

    /**
     * EN: Code for Levobupivacaine.<br>
     * DE: Code für Levobupivacain.<br>
     * FR: Code de lévobupivacaïne.<br>
     * IT: Code per Levobupivacaina.<br>
     */
    public static final String LEVOBUPIVACAINE_CODE = "387011006";

    /**
     * EN: Code for Levocabastine.<br>
     * DE: Code für Levocabastin.<br>
     * FR: Code de lévocabastine.<br>
     * IT: Code per Levocabastina.<br>
     */
    public static final String LEVOCABASTINE_CODE = "372554006";

    /**
     * EN: Code for Levocarnitine.<br>
     * DE: Code für Levocarnitin.<br>
     * FR: Code de lévocarnitine.<br>
     * IT: Code per Levocarnitina.<br>
     */
    public static final String LEVOCARNITINE_CODE = "372601001";

    /**
     * EN: Code for Levocetirizine.<br>
     * DE: Code für Levocetirizin.<br>
     * FR: Code de lévocétirizine.<br>
     * IT: Code per Levocetirizina.<br>
     */
    public static final String LEVOCETIRIZINE_CODE = "421889003";

    /**
     * EN: Code for Levodopa.<br>
     * DE: Code für Levodopa.<br>
     * FR: Code de lévodopa.<br>
     * IT: Code per Levodopa.<br>
     */
    public static final String LEVODOPA_CODE = "387086006";

    /**
     * EN: Code for Levofloxacin.<br>
     * DE: Code für Levofloxacin.<br>
     * FR: Code de lévofloxacine.<br>
     * IT: Code per Levofloxacina.<br>
     */
    public static final String LEVOFLOXACIN_CODE = "387552007";

    /**
     * EN: Code for Levomepromazine.<br>
     * DE: Code für Levomepromazin.<br>
     * FR: Code de lévomépromazine.<br>
     * IT: Code per Levomepromazina.<br>
     */
    public static final String LEVOMEPROMAZINE_CODE = "387509007";

    /**
     * EN: Code for Levomethadone.<br>
     * DE: Code für Levomethadon.<br>
     * FR: Code de lévométhadone.<br>
     * IT: Code per levomethadone.<br>
     */
    public static final String LEVOMETHADONE_CODE = "1156227003";

    /**
     * EN: Code for Levonorgestrel.<br>
     * DE: Code für Levonorgestrel.<br>
     * FR: Code de lévonorgestrel.<br>
     * IT: Code per Levonorgestrel.<br>
     */
    public static final String LEVONORGESTREL_CODE = "126109000";

    /**
     * EN: Code for Levosimendan.<br>
     * DE: Code für Levosimendan.<br>
     * FR: Code de lévosimendan.<br>
     * IT: Code per Levosimendan.<br>
     */
    public static final String LEVOSIMENDAN_CODE = "442795003";

    /**
     * EN: Code for Levothyroxine.<br>
     * DE: Code für Levothyroxin.<br>
     * FR: Code de lévothyroxine.<br>
     * IT: Code per Levotiroxina.<br>
     */
    public static final String LEVOTHYROXINE_CODE = "710809001";

    /**
     * EN: Code for Lidocaine.<br>
     * DE: Code für Lidocain.<br>
     * FR: Code de lidocaïne.<br>
     * IT: Code per Lidocaina.<br>
     */
    public static final String LIDOCAINE_CODE = "387480006";

    /**
     * EN: Code for Linagliptin.<br>
     * DE: Code für Linagliptin.<br>
     * FR: Code de linagliptine.<br>
     * IT: Code per Linagliptin.<br>
     */
    public static final String LINAGLIPTIN_CODE = "702798009";

    /**
     * EN: Code for Linezolid.<br>
     * DE: Code für Linezolid.<br>
     * FR: Code de linézolide.<br>
     * IT: Code per Linezolid.<br>
     */
    public static final String LINEZOLID_CODE = "387056004";

    /**
     * EN: Code for Liothyronine.<br>
     * DE: Code für Liothyronin.<br>
     * FR: Code de liothyronine.<br>
     * IT: Code per Liotironina.<br>
     */
    public static final String LIOTHYRONINE_CODE = "61275002";

    /**
     * EN: Code for Liraglutide.<br>
     * DE: Code für Liraglutid.<br>
     * FR: Code de liraglutide.<br>
     * IT: Code per Liraglutide.<br>
     */
    public static final String LIRAGLUTIDE_CODE = "444828003";

    /**
     * EN: Code for Lisdexamfetamine.<br>
     * DE: Code für Lisdexamfetamin.<br>
     * FR: Code de lisdexamfétamine.<br>
     * IT: Code per Lisdexamfetamina.<br>
     */
    public static final String LISDEXAMFETAMINE_CODE = "425597005";

    /**
     * EN: Code for Lisinopril.<br>
     * DE: Code für Lisinopril.<br>
     * FR: Code de lisinopril.<br>
     * IT: Code per Lisinopril.<br>
     */
    public static final String LISINOPRIL_CODE = "386873009";

    /**
     * EN: Code for Lithium acetate.<br>
     * DE: Code für Lithium acetat.<br>
     * FR: Code de lithium acétate.<br>
     * IT: Code per Litio acetato.<br>
     */
    public static final String LITHIUM_ACETATE_CODE = "111080000";

    /**
     * EN: Code for Lithium carbonate.<br>
     * DE: Code für Lithium carbonat.<br>
     * FR: Code de lithium carbonate.<br>
     * IT: Code per Litio carbonato.<br>
     */
    public static final String LITHIUM_CARBONATE_CODE = "387095003";

    /**
     * EN: Code for Lithium sulfate.<br>
     * DE: Code für Lithiumsulfat.<br>
     * FR: Code de lithium sulfate.<br>
     * IT: Code per Litio solfato.<br>
     */
    public static final String LITHIUM_SULFATE_CODE = "708197001";

    /**
     * EN: Code for Lixisenatide.<br>
     * DE: Code für Lixisenatid.<br>
     * FR: Code de lixisénatide.<br>
     * IT: Code per Lixisenatide.<br>
     */
    public static final String LIXISENATIDE_CODE = "708808004";

    /**
     * EN: Code for Lomustine.<br>
     * DE: Code für Lomustin.<br>
     * FR: Code de lomustine.<br>
     * IT: Code per Lomustina.<br>
     */
    public static final String LOMUSTINE_CODE = "387227009";

    /**
     * EN: Code for Lonoctocog alfa.<br>
     * DE: Code für Lonoctocog alfa.<br>
     * FR: Code de lonoctocog alfa.<br>
     * IT: Code per Lonoctocog alfa.<br>
     */
    public static final String LONOCTOCOG_ALFA_CODE = "1012961000168107";

    /**
     * EN: Code for Loperamide.<br>
     * DE: Code für Loperamid.<br>
     * FR: Code de lopéramide.<br>
     * IT: Code per Loperamide.<br>
     */
    public static final String LOPERAMIDE_CODE = "387040009";

    /**
     * EN: Code for Lopinavir.<br>
     * DE: Code für Lopinavir.<br>
     * FR: Code de lopinavir.<br>
     * IT: Code per Lopinavir.<br>
     */
    public static final String LOPINAVIR_CODE = "387067003";

    /**
     * EN: Code for Loratadine.<br>
     * DE: Code für Loratadin.<br>
     * FR: Code de loratadine.<br>
     * IT: Code per Loratadina.<br>
     */
    public static final String LORATADINE_CODE = "386884002";

    /**
     * EN: Code for Lorazepam.<br>
     * DE: Code für Lorazepam.<br>
     * FR: Code de lorazépam.<br>
     * IT: Code per Lorazepam.<br>
     */
    public static final String LORAZEPAM_CODE = "387106007";

    /**
     * EN: Code for Lormetazepam.<br>
     * DE: Code für Lormetazepam.<br>
     * FR: Code de lormétazépam.<br>
     * IT: Code per Lormetazepam.<br>
     */
    public static final String LORMETAZEPAM_CODE = "387570005";

    /**
     * EN: Code for Losartan.<br>
     * DE: Code für Losartan.<br>
     * FR: Code de losartan.<br>
     * IT: Code per Losartan.<br>
     */
    public static final String LOSARTAN_CODE = "373567002";

    /**
     * EN: Code for Lumefantrine.<br>
     * DE: Code für Lumefantrin.<br>
     * FR: Code de luméfantrine.<br>
     * IT: Code per Lumefantrina.<br>
     */
    public static final String LUMEFANTRINE_CODE = "420307001";

    /**
     * EN: Code for Lurasidone.<br>
     * DE: Code für Lurasidon.<br>
     * FR: Code de lurasidone.<br>
     * IT: Code per Lurasidone.<br>
     */
    public static final String LURASIDONE_CODE = "703115008";

    /**
     * EN: Code for Lutropin alfa.<br>
     * DE: Code für Lutropin alfa.<br>
     * FR: Code de lutropine alfa.<br>
     * IT: Code per Lutropina alfa.<br>
     */
    public static final String LUTROPIN_ALFA_CODE = "415248001";

    /**
     * EN: Code for Lysine.<br>
     * DE: Code für Lysin.<br>
     * FR: Code de lysine.<br>
     * IT: Code per Lisina.<br>
     */
    public static final String LYSINE_CODE = "75799006";

    /**
     * EN: Code for Macitentan.<br>
     * DE: Code für Macitentan.<br>
     * FR: Code de macitentan.<br>
     * IT: Code per Macitentan.<br>
     */
    public static final String MACITENTAN_CODE = "710283008";

    /**
     * EN: Code for Macrogol.<br>
     * DE: Code für Macrogol.<br>
     * FR: Code de macrogol.<br>
     * IT: Code per Macrogol.<br>
     */
    public static final String MACROGOL_CODE = "8030004";

    /**
     * EN: Code for Macrogol 3350.<br>
     * DE: Code für Macrogol 3350.<br>
     * FR: Code de macrogol 3350.<br>
     * IT: Code per Macrogol 3350.<br>
     */
    public static final String MACROGOL_3350_CODE = "712566007";

    /**
     * EN: Code for Macrogol 4000.<br>
     * DE: Code für Macrogol 4000.<br>
     * FR: Code de macrogol 4000.<br>
     * IT: Code per Macrogol 4000.<br>
     */
    public static final String MACROGOL_4000_CODE = "712567003";

    /**
     * EN: Code for Magaldrate.<br>
     * DE: Code für Magaldrat.<br>
     * FR: Code de magaldrate.<br>
     * IT: Code per Magaldrato.<br>
     */
    public static final String MAGALDRATE_CODE = "387240004";

    /**
     * EN: Code for Magnesium.<br>
     * DE: Code für Magnesium.<br>
     * FR: Code de magnésium.<br>
     * IT: Code per Magnesio.<br>
     */
    public static final String MAGNESIUM_CODE = "72717003";

    /**
     * EN: Code for Magnesium acetate tetrahydrate.<br>
     * DE: Code für Magnesium diacetat-4-Wasser.<br>
     * FR: Code de magnésium acétate tétrahydrique.<br>
     * IT: Code per Magnesio acetato tetraidrato.<br>
     */
    public static final String MAGNESIUM_ACETATE_TETRAHYDRATE_CODE = "723586001";

    /**
     * EN: Code for Magnesium carbonate.<br>
     * DE: Code für Magnesium carbonat.<br>
     * FR: Code de magnésium carbonate.<br>
     * IT: Code per Magnesio carbonato.<br>
     */
    public static final String MAGNESIUM_CARBONATE_CODE = "387401007";

    /**
     * EN: Code for Magnesium chloride.<br>
     * DE: Code für Magnesiumchlorid.<br>
     * FR: Code de magnésium chlorure.<br>
     * IT: Code per Magnesio cloruro.<br>
     */
    public static final String MAGNESIUM_CHLORIDE_CODE = "45733002";

    /**
     * EN: Code for Magnesium gluconate.<br>
     * DE: Code für Magnesium digluconat wasserfrei.<br>
     * FR: Code de magnésium digluconate anhydre.<br>
     * IT: Code per Magnesio gluconato.<br>
     */
    public static final String MAGNESIUM_GLUCONATE_CODE = "116126005";

    /**
     * EN: Code for Magnesium hydroxide.<br>
     * DE: Code für Magnesiumhydroxid.<br>
     * FR: Code de magnésium hydroxyde.<br>
     * IT: Code per Magnesio idrossido.<br>
     */
    public static final String MAGNESIUM_HYDROXIDE_CODE = "387337001";

    /**
     * EN: Code for Magnesium sulfate.<br>
     * DE: Code für Magnesiumsulfat.<br>
     * FR: Code de magnésium sulfate.<br>
     * IT: Code per Magnesio solfato.<br>
     */
    public static final String MAGNESIUM_SULFATE_CODE = "387202002";

    /**
     * EN: Code for Mannitol.<br>
     * DE: Code für Mannitol.<br>
     * FR: Code de mannitol.<br>
     * IT: Code per Mannitolo.<br>
     */
    public static final String MANNITOL_CODE = "387168006";

    /**
     * EN: Code for Maraviroc.<br>
     * DE: Code für Maraviroc.<br>
     * FR: Code de maraviroc.<br>
     * IT: Code per Maraviroc.<br>
     */
    public static final String MARAVIROC_CODE = "429603001";

    /**
     * EN: Code for Mebendazole.<br>
     * DE: Code für Mebendazol.<br>
     * FR: Code de mébendazole.<br>
     * IT: Code per Mebendazolo.<br>
     */
    public static final String MEBENDAZOLE_CODE = "387311004";

    /**
     * EN: Code for Mebeverine.<br>
     * DE: Code für Mebeverin.<br>
     * FR: Code de mébévérine.<br>
     * IT: Code per Mebeverina.<br>
     */
    public static final String MEBEVERINE_CODE = "419830007";

    /**
     * EN: Code for Meclozine.<br>
     * DE: Code für Meclozin.<br>
     * FR: Code de méclozine.<br>
     * IT: Code per Meclozina.<br>
     */
    public static final String MECLOZINE_CODE = "372879002";

    /**
     * EN: Code for Medium chain triglyceride.<br>
     * DE: Code für Triglyceride mittelkettige.<br>
     * FR: Code de triglycérides à chaîne moyenne.<br>
     * IT: Code per Trigliceridi a catena media.<br>
     */
    public static final String MEDIUM_CHAIN_TRIGLYCERIDE_CODE = "395781005";

    /**
     * EN: Code for Medroxyprogesterone.<br>
     * DE: Code für Medroxyprogesteron.<br>
     * FR: Code de médroxyprogestérone.<br>
     * IT: Code per Medrossiprogesterone acetato.<br>
     */
    public static final String MEDROXYPROGESTERONE_CODE = "126113007";

    /**
     * EN: Code for Mefenamic acid.<br>
     * DE: Code für Mefenaminsäure.<br>
     * FR: Code de acide méfénamique.<br>
     * IT: Code per Acido mefenamico.<br>
     */
    public static final String MEFENAMIC_ACID_CODE = "387185008";

    /**
     * EN: Code for Mefloquine.<br>
     * DE: Code für Mefloquin.<br>
     * FR: Code de méfloquine.<br>
     * IT: Code per Meflochina.<br>
     */
    public static final String MEFLOQUINE_CODE = "387505001";

    /**
     * EN: Code for Meglumine.<br>
     * DE: Code für Meglumin.<br>
     * FR: Code de méglumine.<br>
     * IT: Code per Meglumina.<br>
     */
    public static final String MEGLUMINE_CODE = "769091004";

    /**
     * EN: Code for Melatonin.<br>
     * DE: Code für Melatonin.<br>
     * FR: Code de mélatonine.<br>
     * IT: Code per Melatonina.<br>
     */
    public static final String MELATONIN_CODE = "41199001";

    /**
     * EN: Code for Melitracen.<br>
     * DE: Code für Melitracen.<br>
     * FR: Code de mélitracène.<br>
     * IT: Code per Melitracene.<br>
     */
    public static final String MELITRACEN_CODE = "712683007";

    /**
     * EN: Code for Melperone.<br>
     * DE: Code für Melperon.<br>
     * FR: Code de melpérone.<br>
     * IT: Code per Melperone.<br>
     */
    public static final String MELPERONE_CODE = "442519006";

    /**
     * EN: Code for Melphalan.<br>
     * DE: Code für Melphalan.<br>
     * FR: Code de melphalan.<br>
     * IT: Code per Melphalan.<br>
     */
    public static final String MELPHALAN_CODE = "387297002";

    /**
     * EN: Code for Memantine.<br>
     * DE: Code für Memantin.<br>
     * FR: Code de mémantine.<br>
     * IT: Code per Memantina.<br>
     */
    public static final String MEMANTINE_CODE = "406458000";

    /**
     * EN: Code for Mepivacaine.<br>
     * DE: Code für Mepivacain.<br>
     * FR: Code de mépivacaïne.<br>
     * IT: Code per Mepicacaina.<br>
     */
    public static final String MEPIVACAINE_CODE = "59560006";

    /**
     * EN: Code for Mercaptamine.<br>
     * DE: Code für Mercaptamin.<br>
     * FR: Code de mercaptamine.<br>
     * IT: Code per Mercaptamina.<br>
     */
    public static final String MERCAPTAMINE_CODE = "373457005";

    /**
     * EN: Code for Meropenem.<br>
     * DE: Code für Meropenem.<br>
     * FR: Code de méropénem.<br>
     * IT: Code per Meropenem.<br>
     */
    public static final String MEROPENEM_CODE = "387540000";

    /**
     * EN: Code for Mesalazine.<br>
     * DE: Code für Mesalazin.<br>
     * FR: Code de mésalazine.<br>
     * IT: Code per Mesalazina.<br>
     */
    public static final String MESALAZINE_CODE = "387501005";

    /**
     * EN: Code for Mesna.<br>
     * DE: Code für Mesna.<br>
     * FR: Code de mesna.<br>
     * IT: Code per Mesna.<br>
     */
    public static final String MESNA_CODE = "386922000";

    /**
     * EN: Code for Metamizole.<br>
     * DE: Code für Metamizol.<br>
     * FR: Code de métamizole.<br>
     * IT: Code per Metamizolo.<br>
     */
    public static final String METAMIZOLE_CODE = "780831000";

    /**
     * EN: Code for Metformin.<br>
     * DE: Code für Metformin.<br>
     * FR: Code de metformine.<br>
     * IT: Code per Metformina.<br>
     */
    public static final String METFORMIN_CODE = "372567009";

    /**
     * EN: Code for Methadone.<br>
     * DE: Code für Methadon.<br>
     * FR: Code de méthadone.<br>
     * IT: Code per Metadone.<br>
     */
    public static final String METHADONE_CODE = "387286002";

    /**
     * EN: Code for Methionine.<br>
     * DE: Code für Methionin.<br>
     * FR: Code de méthionine.<br>
     * IT: Code per Metionina.<br>
     */
    public static final String METHIONINE_CODE = "70288006";

    /**
     * EN: Code for Methotrexate.<br>
     * DE: Code für Methotrexat.<br>
     * FR: Code de méthotrexate.<br>
     * IT: Code per Metotrexato.<br>
     */
    public static final String METHOTREXATE_CODE = "387381009";

    /**
     * EN: Code for Methoxsalen.<br>
     * DE: Code für Methoxsalen.<br>
     * FR: Code de méthoxsalène.<br>
     * IT: Code per Metoxsalene.<br>
     */
    public static final String METHOXSALEN_CODE = "41062004";

    /**
     * EN: Code for Methoxy polyethylene glycol-epoetin beta.<br>
     * DE: Code für PEG-Epoetin beta.<br>
     * FR: Code de époétine bêta pégylée.<br>
     * IT: Code per Metossipolietilenglicole-epoetina beta.<br>
     */
    public static final String METHOXY_POLYETHYLENE_GLYCOL_EPOETIN_BETA_CODE = "425913002";

    /**
     * EN: Code for Methyldopa anhydrous.<br>
     * DE: Code für Methyldopa.<br>
     * FR: Code de méthyldopa.<br>
     * IT: Code per Metildopa.<br>
     */
    public static final String METHYLDOPA_ANHYDROUS_CODE = "768043006";

    /**
     * EN: Code for Methylene blue stain.<br>
     * DE: Code für Methylthioninium chlorid.<br>
     * FR: Code de méthylthionine chlorure.<br>
     * IT: Code per Metiltioninio cloruro.<br>
     */
    public static final String METHYLENE_BLUE_STAIN_CODE = "6725000";

    /**
     * EN: Code for Methylergometrine.<br>
     * DE: Code für Methylergometrin.<br>
     * FR: Code de méthylergométrine.<br>
     * IT: Code per Metilergometrina.<br>
     */
    public static final String METHYLERGOMETRINE_CODE = "126074008";

    /**
     * EN: Code for Methylphenidate.<br>
     * DE: Code für Methylphenidat.<br>
     * FR: Code de méthylphénidate.<br>
     * IT: Code per Metilfenidato.<br>
     */
    public static final String METHYLPHENIDATE_CODE = "373337007";

    /**
     * EN: Code for Methylprednisolone.<br>
     * DE: Code für Methylprednisolon.<br>
     * FR: Code de méthylprednisolone.<br>
     * IT: Code per Metilprednisolone.<br>
     */
    public static final String METHYLPREDNISOLONE_CODE = "116593003";

    /**
     * EN: Code for Metoclopramide.<br>
     * DE: Code für Metoclopramid.<br>
     * FR: Code de métoclopramide.<br>
     * IT: Code per Metoclopramide.<br>
     */
    public static final String METOCLOPRAMIDE_CODE = "372776000";

    /**
     * EN: Code for Metolazone.<br>
     * DE: Code für Metolazon.<br>
     * FR: Code de métolazone.<br>
     * IT: Code per Metolazone.<br>
     */
    public static final String METOLAZONE_CODE = "387123003";

    /**
     * EN: Code for Metoprolol.<br>
     * DE: Code für Metoprolol.<br>
     * FR: Code de métoprolol.<br>
     * IT: Code per Metoprololo.<br>
     */
    public static final String METOPROLOL_CODE = "372826007";

    /**
     * EN: Code for Metronidazole.<br>
     * DE: Code für Metronidazol.<br>
     * FR: Code de métronidazole.<br>
     * IT: Code per Metronidazolo.<br>
     */
    public static final String METRONIDAZOLE_CODE = "372602008";

    /**
     * EN: Code for Mianserin hydrochloride.<br>
     * DE: Code für Mianserin hydrochlorid.<br>
     * FR: Code de miansérine chlorhydrate.<br>
     * IT: Code per Mianserina HCL.<br>
     */
    public static final String MIANSERIN_HYDROCHLORIDE_CODE = "395795008";

    /**
     * EN: Code for Miconazole.<br>
     * DE: Code für Miconazol.<br>
     * FR: Code de miconazole.<br>
     * IT: Code per Miconazolo.<br>
     */
    public static final String MICONAZOLE_CODE = "372738006";

    /**
     * EN: Code for Midazolam.<br>
     * DE: Code für Midazolam.<br>
     * FR: Code de midazolam.<br>
     * IT: Code per Midazolam.<br>
     */
    public static final String MIDAZOLAM_CODE = "373476007";

    /**
     * EN: Code for Midodrine.<br>
     * DE: Code für Midodrin.<br>
     * FR: Code de midodrine.<br>
     * IT: Code per Midodrina.<br>
     */
    public static final String MIDODRINE_CODE = "372504000";

    /**
     * EN: Code for Mifepristone.<br>
     * DE: Code für Mifepriston.<br>
     * FR: Code de mifépristone.<br>
     * IT: Code per Miferpristone.<br>
     */
    public static final String MIFEPRISTONE_CODE = "395796009";

    /**
     * EN: Code for Milrinone.<br>
     * DE: Code für Milrinon.<br>
     * FR: Code de milrinone.<br>
     * IT: Code per Milrinone.<br>
     */
    public static final String MILRINONE_CODE = "373441005";

    /**
     * EN: Code for Minocycline.<br>
     * DE: Code für Minocyclin.<br>
     * FR: Code de minocycline.<br>
     * IT: Code per Minociclina.<br>
     */
    public static final String MINOCYCLINE_CODE = "372653009";

    /**
     * EN: Code for Minoxidil.<br>
     * DE: Code für Minoxidil.<br>
     * FR: Code de minoxidil.<br>
     * IT: Code per Minoxidil.<br>
     */
    public static final String MINOXIDIL_CODE = "387272001";

    /**
     * EN: Code for Mirabegron.<br>
     * DE: Code für Mirabegron.<br>
     * FR: Code de mirabégron.<br>
     * IT: Code per Mirabegron.<br>
     */
    public static final String MIRABEGRON_CODE = "703803006";

    /**
     * EN: Code for Mirtazapine.<br>
     * DE: Code für Mirtazapin.<br>
     * FR: Code de mirtazapine.<br>
     * IT: Code per Mirtazapina.<br>
     */
    public static final String MIRTAZAPINE_CODE = "386847004";

    /**
     * EN: Code for Misoprostol.<br>
     * DE: Code für Misoprostol.<br>
     * FR: Code de misoprostol.<br>
     * IT: Code per Misoprostolo.<br>
     */
    public static final String MISOPROSTOL_CODE = "387242007";

    /**
     * EN: Code for Mitomycin.<br>
     * DE: Code für Mitomycin.<br>
     * FR: Code de mitomycine.<br>
     * IT: Code per Mitomicina.<br>
     */
    public static final String MITOMYCIN_CODE = "387331000";

    /**
     * EN: Code for Mitoxantrone.<br>
     * DE: Code für Mitoxantron.<br>
     * FR: Code de mitoxantrone.<br>
     * IT: Code per Mitoxantrone.<br>
     */
    public static final String MITOXANTRONE_CODE = "386913001";

    /**
     * EN: Code for Mivacurium chloride.<br>
     * DE: Code für Mivacurium chlorid.<br>
     * FR: Code de mivacurium chlorure.<br>
     * IT: Code per Mivacurio cloruro.<br>
     */
    public static final String MIVACURIUM_CHLORIDE_CODE = "108447000";

    /**
     * EN: Code for Moclobemide.<br>
     * DE: Code für Moclobemid.<br>
     * FR: Code de moclobémide.<br>
     * IT: Code per Moclobemide.<br>
     */
    public static final String MOCLOBEMIDE_CODE = "395800003";

    /**
     * EN: Code for Modafinil.<br>
     * DE: Code für Modafinil.<br>
     * FR: Code de modafinil.<br>
     * IT: Code per Modafinil.<br>
     */
    public static final String MODAFINIL_CODE = "387004007";

    /**
     * EN: Code for Molsidomine.<br>
     * DE: Code für Molsidomin.<br>
     * FR: Code de molsidomine.<br>
     * IT: Code per Molsidomina.<br>
     */
    public static final String MOLSIDOMINE_CODE = "698196008";

    /**
     * EN: Code for Mometasone.<br>
     * DE: Code für Mometason.<br>
     * FR: Code de mométasone.<br>
     * IT: Code per Mometasone.<br>
     */
    public static final String MOMETASONE_CODE = "395990009";

    /**
     * EN: Code for Montelukast.<br>
     * DE: Code für Montelukast.<br>
     * FR: Code de montélukast.<br>
     * IT: Code per Montelukast.<br>
     */
    public static final String MONTELUKAST_CODE = "373728005";

    /**
     * EN: Code for Moroctocog alfa.<br>
     * DE: Code für Moroctocog alfa.<br>
     * FR: Code de moroctocog alfa.<br>
     * IT: Code per Moroctocog alfa.<br>
     */
    public static final String MOROCTOCOG_ALFA_CODE = "441764007";

    /**
     * EN: Code for Morphine.<br>
     * DE: Code für Morphin.<br>
     * FR: Code de morphine.<br>
     * IT: Code per Morfina.<br>
     */
    public static final String MORPHINE_CODE = "373529000";

    /**
     * EN: Code for Moxifloxacin.<br>
     * DE: Code für Moxifloxacin.<br>
     * FR: Code de moxifloxacine.<br>
     * IT: Code per Moxifloxacina.<br>
     */
    public static final String MOXIFLOXACIN_CODE = "412439003";

    /**
     * EN: Code for Moxonidine.<br>
     * DE: Code für Moxonidin.<br>
     * FR: Code de moxonidine.<br>
     * IT: Code per Moxonidina.<br>
     */
    public static final String MOXONIDINE_CODE = "395805008";

    /**
     * EN: Code for Mupirocin.<br>
     * DE: Code für Mupirocin.<br>
     * FR: Code de mupirocine.<br>
     * IT: Code per Mupirocina.<br>
     */
    public static final String MUPIROCIN_CODE = "387397004";

    /**
     * EN: Code for Mycophenolate mofetil.<br>
     * DE: Code für Mycophenolat mofetil.<br>
     * FR: Code de mycophénolate mofétil.<br>
     * IT: Code per Micofenolato mofetile.<br>
     */
    public static final String MYCOPHENOLATE_MOFETIL_CODE = "386976000";

    /**
     * EN: Code for Mycophenolic acid.<br>
     * DE: Code für Mycophenolsäure.<br>
     * FR: Code de acide mycophénolique.<br>
     * IT: Code per Acido micofenolico.<br>
     */
    public static final String MYCOPHENOLIC_ACID_CODE = "409330005";

    /**
     * EN: Code for Nadolol.<br>
     * DE: Code für Nadolol.<br>
     * FR: Code de nadolol.<br>
     * IT: Code per Nadololo.<br>
     */
    public static final String NADOLOL_CODE = "387482003";

    /**
     * EN: Code for Nadroparine.<br>
     * DE: Code für Nadroparin.<br>
     * FR: Code de nadroparine.<br>
     * IT: Code per Nadroparina.<br>
     */
    public static final String NADROPARINE_CODE = "699946002";

    /**
     * EN: Code for Nadroparin calcium.<br>
     * DE: Code für Nadroparin calcium.<br>
     * FR: Code de nadroparine calcique.<br>
     * IT: Code per Nadroparina calcica.<br>
     */
    public static final String NADROPARIN_CALCIUM_CODE = "698278006";

    /**
     * EN: Code for Naftazone.<br>
     * DE: Code für Naftazon.<br>
     * FR: Code de naftazone.<br>
     * IT: Code per Naftazone.<br>
     */
    public static final String NAFTAZONE_CODE = "713428001";

    /**
     * EN: Code for Naftidrofuryl.<br>
     * DE: Code für Naftidrofuryl.<br>
     * FR: Code de naftidrofuryl.<br>
     * IT: Code per Naftidrofurile.<br>
     */
    public static final String NAFTIDROFURYL_CODE = "395992001";

    /**
     * EN: Code for Nalmefene.<br>
     * DE: Code für Nalmefen.<br>
     * FR: Code de nalméfène.<br>
     * IT: Code per Nalmefene.<br>
     */
    public static final String NALMEFENE_CODE = "109098006";

    /**
     * EN: Code for Naloxone.<br>
     * DE: Code für Naloxon.<br>
     * FR: Code de naloxone.<br>
     * IT: Code per Naloxone.<br>
     */
    public static final String NALOXONE_CODE = "372890007";

    /**
     * EN: Code for Naltrexone.<br>
     * DE: Code für Naltrexon.<br>
     * FR: Code de naltrexone.<br>
     * IT: Code per Naltrexone.<br>
     */
    public static final String NALTREXONE_CODE = "373546002";

    /**
     * EN: Code for Naphazoline.<br>
     * DE: Code für Naphazolin.<br>
     * FR: Code de naphazoline.<br>
     * IT: Code per Nafazolina.<br>
     */
    public static final String NAPHAZOLINE_CODE = "372803000";

    /**
     * EN: Code for Naproxen.<br>
     * DE: Code für Naproxen.<br>
     * FR: Code de naproxène.<br>
     * IT: Code per Naprossene.<br>
     */
    public static final String NAPROXEN_CODE = "372588000";

    /**
     * EN: Code for Naratriptan.<br>
     * DE: Code für Naratriptan.<br>
     * FR: Code de naratriptan.<br>
     * IT: Code per Naratriptan.<br>
     */
    public static final String NARATRIPTAN_CODE = "363571003";

    /**
     * EN: Code for Natalizumab.<br>
     * DE: Code für Natalizumab.<br>
     * FR: Code de natalizumab.<br>
     * IT: Code per Natalizumab.<br>
     */
    public static final String NATALIZUMAB_CODE = "414805007";

    /**
     * EN: Code for Nateglinide.<br>
     * DE: Code für Nateglinid.<br>
     * FR: Code de natéglinide.<br>
     * IT: Code per Nateglinide.<br>
     */
    public static final String NATEGLINIDE_CODE = "387070004";

    /**
     * EN: Code for Nebivolol.<br>
     * DE: Code für Nebivolol.<br>
     * FR: Code de nébivolol.<br>
     * IT: Code per Nebivololo.<br>
     */
    public static final String NEBIVOLOL_CODE = "395808005";

    /**
     * EN: Code for Nelfinavir.<br>
     * DE: Code für Nelfinavir.<br>
     * FR: Code de nelfinavir.<br>
     * IT: Code per Nelfinavir.<br>
     */
    public static final String NELFINAVIR_CODE = "373445001";

    /**
     * EN: Code for Neomycin.<br>
     * DE: Code für Neomycin.<br>
     * FR: Code de néomycine.<br>
     * IT: Code per Neomicina.<br>
     */
    public static final String NEOMYCIN_CODE = "373528008";

    /**
     * EN: Code for Neostigmine.<br>
     * DE: Code für Neostigmin.<br>
     * FR: Code de néostigmine.<br>
     * IT: Code per Neostigmina.<br>
     */
    public static final String NEOSTIGMINE_CODE = "373346001";

    /**
     * EN: Code for Nevirapine.<br>
     * DE: Code für Nevirapin.<br>
     * FR: Code de névirapine.<br>
     * IT: Code per Nevirapina.<br>
     */
    public static final String NEVIRAPINE_CODE = "386898005";

    /**
     * EN: Code for Nicardipine.<br>
     * DE: Code für Nicardipin.<br>
     * FR: Code de nicardipine.<br>
     * IT: Code per Nicardipina.<br>
     */
    public static final String NICARDIPINE_CODE = "372502001";

    /**
     * EN: Code for Nicorandil.<br>
     * DE: Code für Nicorandil.<br>
     * FR: Code de nicorandil.<br>
     * IT: Code per Nicorandil.<br>
     */
    public static final String NICORANDIL_CODE = "395809002";

    /**
     * EN: Code for Nicotinamide.<br>
     * DE: Code für Nicotinamid.<br>
     * FR: Code de nicotinamide.<br>
     * IT: Code per Nicotinamide.<br>
     */
    public static final String NICOTINAMIDE_CODE = "173196005";

    /**
     * EN: Code for Nicotine.<br>
     * DE: Code für Nicotin.<br>
     * FR: Code de nicotine.<br>
     * IT: Code per Nicotina.<br>
     */
    public static final String NICOTINE_CODE = "68540007";

    /**
     * EN: Code for Nifedipine.<br>
     * DE: Code für Nifedipin.<br>
     * FR: Code de nifédipine.<br>
     * IT: Code per Nifedipina.<br>
     */
    public static final String NIFEDIPINE_CODE = "387490003";

    /**
     * EN: Code for Nimesulide.<br>
     * DE: Code für Nimesulid.<br>
     * FR: Code de nimésulide.<br>
     * IT: Code per Nimesulide.<br>
     */
    public static final String NIMESULIDE_CODE = "703479000";

    /**
     * EN: Code for Nimodipine.<br>
     * DE: Code für Nimodipin.<br>
     * FR: Code de nimodipine.<br>
     * IT: Code per Nimodipina.<br>
     */
    public static final String NIMODIPINE_CODE = "387502003";

    /**
     * EN: Code for Nintedanib.<br>
     * DE: Code für Nintedanib.<br>
     * FR: Code de nintédanib.<br>
     * IT: Code per Nintedanib.<br>
     */
    public static final String NINTEDANIB_CODE = "712494002";

    /**
     * EN: Code for Nitazoxanide.<br>
     * DE: Code für Nitazoxanid.<br>
     * FR: Code de nitazoxanide.<br>
     * IT: Code per Nitazoxanide.<br>
     */
    public static final String NITAZOXANIDE_CODE = "407148001";

    /**
     * EN: Code for Nitisinone.<br>
     * DE: Code für Nitisinon.<br>
     * FR: Code de nitisinone.<br>
     * IT: Code per Nitisinone.<br>
     */
    public static final String NITISINONE_CODE = "385996000";

    /**
     * EN: Code for Nitrazepam.<br>
     * DE: Code für Nitrazepam.<br>
     * FR: Code de nitrazépam.<br>
     * IT: Code per Nitrazepam.<br>
     */
    public static final String NITRAZEPAM_CODE = "387449001";

    /**
     * EN: Code for Nitrendipine.<br>
     * DE: Code für Nitrendipin.<br>
     * FR: Code de nitrendipine.<br>
     * IT: Code per Nitrendipina.<br>
     */
    public static final String NITRENDIPINE_CODE = "444757009";

    /**
     * EN: Code for Nitrofurantoin.<br>
     * DE: Code für Nitrofurantoin.<br>
     * FR: Code de nitrofurantoïne.<br>
     * IT: Code per Nitrofurantoina.<br>
     */
    public static final String NITROFURANTOIN_CODE = "373543005";

    /**
     * EN: Code for Nivolumab.<br>
     * DE: Code für Nivolumab.<br>
     * FR: Code de nivolumab.<br>
     * IT: Code per Nivolumab.<br>
     */
    public static final String NIVOLUMAB_CODE = "704191007";

    /**
     * EN: Code for Nomegestrol acetate.<br>
     * DE: Code für Nomegestrol acetat.<br>
     * FR: Code de nomégestrol acétate.<br>
     * IT: Code per Nomegestrolo acetato.<br>
     */
    public static final String NOMEGESTROL_ACETATE_CODE = "698277001";

    /**
     * EN: Code for Norepinephrine.<br>
     * DE: Code für Noradrenalin (Norepinephrin).<br>
     * FR: Code de noradrénaline (norépinéphrine).<br>
     * IT: Code per Noradrenalina (norepinefrina).<br>
     */
    public static final String NOREPINEPHRINE_CODE = "45555007";

    /**
     * EN: Code for Norethisterone.<br>
     * DE: Code für Norethisteron.<br>
     * FR: Code de noréthistérone.<br>
     * IT: Code per Noretisterone.<br>
     */
    public static final String NORETHISTERONE_CODE = "126102009";

    /**
     * EN: Code for Norfloxacin.<br>
     * DE: Code für Norfloxacin.<br>
     * FR: Code de norfloxacine.<br>
     * IT: Code per Norfloxacina.<br>
     */
    public static final String NORFLOXACIN_CODE = "387271008";

    /**
     * EN: Code for Norgestimate.<br>
     * DE: Code für Norgestimat.<br>
     * FR: Code de norgestimate.<br>
     * IT: Code per Norgestimato.<br>
     */
    public static final String NORGESTIMATE_CODE = "126115000";

    /**
     * EN: Code for Norgestrel.<br>
     * DE: Code für Norgestrel.<br>
     * FR: Code de norgestrel.<br>
     * IT: Code per Norgestrel.<br>
     */
    public static final String NORGESTREL_CODE = "126106007";

    /**
     * EN: Code for Normal immunoglobulin human.<br>
     * DE: Code für Immunglobulin vom Menschen.<br>
     * FR: Code de immunoglobuline humaine normale.<br>
     * IT: Code per Immunoglobulina umana normale.<br>
     */
    public static final String NORMAL_IMMUNOGLOBULIN_HUMAN_CODE = "713355009";

    /**
     * EN: Code for Nortriptyline.<br>
     * DE: Code für Nortriptylin.<br>
     * FR: Code de nortriptyline.<br>
     * IT: Code per Nortriptilina.<br>
     */
    public static final String NORTRIPTYLINE_CODE = "372652004";

    /**
     * EN: Code for Noscapine.<br>
     * DE: Code für Noscapin.<br>
     * FR: Code de noscapine.<br>
     * IT: Code per Noscapina.<br>
     */
    public static final String NOSCAPINE_CODE = "387437002";

    /**
     * EN: Code for Nystatin.<br>
     * DE: Code für Nystatin.<br>
     * FR: Code de nystatine.<br>
     * IT: Code per Nistatina.<br>
     */
    public static final String NYSTATIN_CODE = "387048002";

    /**
     * EN: Code for Obeticholic acid.<br>
     * DE: Code für Obeticholsäure.<br>
     * FR: Code de acide obéticholique.<br>
     * IT: Code per Acido obeticolico.<br>
     */
    public static final String OBETICHOLIC_ACID_CODE = "720257002";

    /**
     * EN: Code for Obidoxime chloride.<br>
     * DE: Code für Obidoxim chlorid.<br>
     * FR: Code de obidoxime chlorure.<br>
     * IT: Code per obidoxima cloruro.<br>
     */
    public static final String OBIDOXIME_CHLORIDE_CODE = "1156231009";

    /**
     * EN: Code for Obinutuzumab.<br>
     * DE: Code für Obinutuzumab.<br>
     * FR: Code de obinutuzumab.<br>
     * IT: Code per Obinutuzumab.<br>
     */
    public static final String OBINUTUZUMAB_CODE = "710287009";

    /**
     * EN: Code for Ocrelizumab.<br>
     * DE: Code für Ocrelizumab.<br>
     * FR: Code de ocrélizumab.<br>
     * IT: Code per Ocrelizumab.<br>
     */
    public static final String OCRELIZUMAB_CODE = "733464008";

    /**
     * EN: Code for Octenidine.<br>
     * DE: Code für Octenidin.<br>
     * FR: Code de octénidine.<br>
     * IT: Code per Octenidina.<br>
     */
    public static final String OCTENIDINE_CODE = "430477008";

    /**
     * EN: Code for Octocog alfa.<br>
     * DE: Code für Octocog alfa.<br>
     * FR: Code de octocog alfa.<br>
     * IT: Code per Octocog alfa.<br>
     */
    public static final String OCTOCOG_ALFA_CODE = "418888003";

    /**
     * EN: Code for Octreotide.<br>
     * DE: Code für Octreotid.<br>
     * FR: Code de octréotide.<br>
     * IT: Code per Octreotide.<br>
     */
    public static final String OCTREOTIDE_CODE = "109053000";

    /**
     * EN: Code for Ofloxacin.<br>
     * DE: Code für Ofloxacin.<br>
     * FR: Code de ofloxacine.<br>
     * IT: Code per Ofloxacina.<br>
     */
    public static final String OFLOXACIN_CODE = "387551000";

    /**
     * EN: Code for Olanzapine.<br>
     * DE: Code für Olanzapin.<br>
     * FR: Code de olanzapine.<br>
     * IT: Code per Olanzapina.<br>
     */
    public static final String OLANZAPINE_CODE = "386849001";

    /**
     * EN: Code for Olanzapine embonate.<br>
     * DE: Code für Olanzapin embonat-1-Wasser.<br>
     * FR: Code de olanzapine embonate.<br>
     * IT: Code per Olanzapina embonato.<br>
     */
    public static final String OLANZAPINE_EMBONATE_CODE = "725800004";

    /**
     * EN: Code for Olive oil.<br>
     * DE: Code für Olivenöl.<br>
     * FR: Code de olive huile.<br>
     * IT: Code per Oliva olio.<br>
     */
    public static final String OLIVE_OIL_CODE = "41834005";

    /**
     * EN: Code for Olmesartan.<br>
     * DE: Code für Olmesartan.<br>
     * FR: Code de olmésartan.<br>
     * IT: Code per Olmesartan.<br>
     */
    public static final String OLMESARTAN_CODE = "412259001";

    /**
     * EN: Code for Olodaterol.<br>
     * DE: Code für Olodaterol.<br>
     * FR: Code de olodatérol.<br>
     * IT: Code per Olodaterolo.<br>
     */
    public static final String OLODATEROL_CODE = "704459002";

    /**
     * EN: Code for Omalizumab.<br>
     * DE: Code für Omalizumab.<br>
     * FR: Code de omalizumab.<br>
     * IT: Code per Omalizumab.<br>
     */
    public static final String OMALIZUMAB_CODE = "406443008";

    /**
     * EN: Code for Omega 3 fatty acid.<br>
     * DE: Code für Omega-3-Fettsäuren.<br>
     * FR: Code de acides gras oméga-3.<br>
     * IT: Code per Acidi grassi omega 3.<br>
     */
    public static final String OMEGA_3_FATTY_ACID_CODE = "226365003";

    /**
     * EN: Code for Omeprazole.<br>
     * DE: Code für Omeprazol.<br>
     * FR: Code de oméprazole.<br>
     * IT: Code per Omeprazolo.<br>
     */
    public static final String OMEPRAZOLE_CODE = "387137007";

    /**
     * EN: Code for Ondansetron.<br>
     * DE: Code für Ondansetron.<br>
     * FR: Code de ondansétron.<br>
     * IT: Code per Ondansetron.<br>
     */
    public static final String ONDANSETRON_CODE = "372487007";

    /**
     * EN: Code for Opipramol.<br>
     * DE: Code für Opipramol.<br>
     * FR: Code de opipramol.<br>
     * IT: Code per opipramolo.<br>
     */
    public static final String OPIPRAMOL_CODE = "1156223004";

    /**
     * EN: Code for Orlistat.<br>
     * DE: Code für Orlistat.<br>
     * FR: Code de orlistat.<br>
     * IT: Code per Orlistat.<br>
     */
    public static final String ORLISTAT_CODE = "387007000";

    /**
     * EN: Code for Ornidazole.<br>
     * DE: Code für Ornidazol.<br>
     * FR: Code de ornidazole.<br>
     * IT: Code per Ornidazolo.<br>
     */
    public static final String ORNIDAZOLE_CODE = "442924004";

    /**
     * EN: Code for Oseltamivir.<br>
     * DE: Code für Oseltamivir.<br>
     * FR: Code de oseltamivir.<br>
     * IT: Code per Oseltamivir.<br>
     */
    public static final String OSELTAMIVIR_CODE = "412261005";

    /**
     * EN: Code for Oxaliplatin.<br>
     * DE: Code für Oxaliplatin.<br>
     * FR: Code de oxaliplatine.<br>
     * IT: Code per Oxaliplatino.<br>
     */
    public static final String OXALIPLATIN_CODE = "395814003";

    /**
     * EN: Code for Oxandrolone.<br>
     * DE: Code für Oxandrolon.<br>
     * FR: Code de oxandrolone.<br>
     * IT: Code per Oxandrolone.<br>
     */
    public static final String OXANDROLONE_CODE = "126128007";

    /**
     * EN: Code for Oxazepam.<br>
     * DE: Code für Oxazepam.<br>
     * FR: Code de oxazépam.<br>
     * IT: Code per Oxazepam.<br>
     */
    public static final String OXAZEPAM_CODE = "387455006";

    /**
     * EN: Code for Oxcarbazepine.<br>
     * DE: Code für Oxcarbazepin.<br>
     * FR: Code de oxcarbazépine.<br>
     * IT: Code per Oxcarbazepina.<br>
     */
    public static final String OXCARBAZEPINE_CODE = "387025007";

    /**
     * EN: Code for Oxomemazine.<br>
     * DE: Code für Oxomemazin.<br>
     * FR: Code de oxomémazine.<br>
     * IT: Code per Oxomemazina.<br>
     */
    public static final String OXOMEMAZINE_CODE = "772837001";

    /**
     * EN: Code for Oxybuprocaine.<br>
     * DE: Code für Oxybuprocain.<br>
     * FR: Code de oxybuprocaïne.<br>
     * IT: Code per Oxibuprocaina.<br>
     */
    public static final String OXYBUPROCAINE_CODE = "52140009";

    /**
     * EN: Code for Oxybutynin.<br>
     * DE: Code für Oxybutynin.<br>
     * FR: Code de oxybutynine.<br>
     * IT: Code per Ossibutinina.<br>
     */
    public static final String OXYBUTYNIN_CODE = "372717000";

    /**
     * EN: Code for Oxycodone.<br>
     * DE: Code für Oxycodon.<br>
     * FR: Code de oxycodone.<br>
     * IT: Code per Ossicodone.<br>
     */
    public static final String OXYCODONE_CODE = "55452001";

    /**
     * EN: Code for Oxymetazoline.<br>
     * DE: Code für Oxymetazolin.<br>
     * FR: Code de oxymétazoline.<br>
     * IT: Code per Ossimetazolina.<br>
     */
    public static final String OXYMETAZOLINE_CODE = "387158001";

    /**
     * EN: Code for Oxytetracycline.<br>
     * DE: Code für Oxytetracyclin.<br>
     * FR: Code de oxytétracycline.<br>
     * IT: Code per Ossitetraciclina.<br>
     */
    public static final String OXYTETRACYCLINE_CODE = "372675006";

    /**
     * EN: Code for Oxytocin.<br>
     * DE: Code für Oxytocin.<br>
     * FR: Code de oxytocine.<br>
     * IT: Code per Ossitocina.<br>
     */
    public static final String OXYTOCIN_CODE = "112115002";

    /**
     * EN: Code for Paclitaxel.<br>
     * DE: Code für Paclitaxel.<br>
     * FR: Code de paclitaxel.<br>
     * IT: Code per Paclitaxel.<br>
     */
    public static final String PACLITAXEL_CODE = "387374002";

    /**
     * EN: Code for Paliperidone.<br>
     * DE: Code für Paliperidon.<br>
     * FR: Code de palipéridone.<br>
     * IT: Code per Paliperidone.<br>
     */
    public static final String PALIPERIDONE_CODE = "426276000";

    /**
     * EN: Code for Palivizumab.<br>
     * DE: Code für Palivizumab.<br>
     * FR: Code de palivizumab.<br>
     * IT: Code per Palivizumab.<br>
     */
    public static final String PALIVIZUMAB_CODE = "386900007";

    /**
     * EN: Code for Palonosetron.<br>
     * DE: Code für Palonosetron.<br>
     * FR: Code de palonosétron.<br>
     * IT: Code per Palonosetron.<br>
     */
    public static final String PALONOSETRON_CODE = "404852008";

    /**
     * EN: Code for Pancuronium.<br>
     * DE: Code für Pancuronium.<br>
     * FR: Code de pancuronium.<br>
     * IT: Code per Pancuronio.<br>
     */
    public static final String PANCURONIUM_CODE = "373738000";

    /**
     * EN: Code for Pantoprazole.<br>
     * DE: Code für Pantoprazol.<br>
     * FR: Code de pantoprazole.<br>
     * IT: Code per Pantoprazolo.<br>
     */
    public static final String PANTOPRAZOLE_CODE = "395821003";

    /**
     * EN: Code for Pantothenic acid.<br>
     * DE: Code für Pantothensäure.<br>
     * FR: Code de acide pantothénique.<br>
     * IT: Code per Acido pantotenico.<br>
     */
    public static final String PANTOTHENIC_ACID_CODE = "86431009";

    /**
     * EN: Code for Papaverine.<br>
     * DE: Code für Papaverin.<br>
     * FR: Code de papavérine.<br>
     * IT: Code per Papaverina.<br>
     */
    public static final String PAPAVERINE_CODE = "372784001";

    /**
     * EN: Code for Paracetamol.<br>
     * DE: Code für Paracetamol.<br>
     * FR: Code de paracétamol.<br>
     * IT: Code per Paracetamolo.<br>
     */
    public static final String PARACETAMOL_CODE = "387517004";

    /**
     * EN: Code for Paraffin.<br>
     * DE: Code für Paraffin.<br>
     * FR: Code de paraffine.<br>
     * IT: Code per Paraffina.<br>
     */
    public static final String PARAFFIN_CODE = "255667006";

    /**
     * EN: Code for Paricalcitol.<br>
     * DE: Code für Paricalcitol.<br>
     * FR: Code de paricalcitol.<br>
     * IT: Code per Paracalcitolo.<br>
     */
    public static final String PARICALCITOL_CODE = "108946001";

    /**
     * EN: Code for Paroxetine.<br>
     * DE: Code für Paroxetin.<br>
     * FR: Code de paroxétine.<br>
     * IT: Code per Paroxetina.<br>
     */
    public static final String PAROXETINE_CODE = "372595009";

    /**
     * EN: Code for Pegaspargase.<br>
     * DE: Code für Pegaspargase.<br>
     * FR: Code de pégaspargase.<br>
     * IT: Code per Pegaspargase.<br>
     */
    public static final String PEGASPARGASE_CODE = "108814000";

    /**
     * EN: Code for Pegfilgrastim.<br>
     * DE: Code für Pegfilgrastim.<br>
     * FR: Code de pegfilgrastim.<br>
     * IT: Code per Pegfilgrastim.<br>
     */
    public static final String PEGFILGRASTIM_CODE = "385544005";

    /**
     * EN: Code for Peginterferon alfa-2a.<br>
     * DE: Code für Peginterferon alfa-2a.<br>
     * FR: Code de peginterféron alfa-2a.<br>
     * IT: Code per Peginterferone alfa-2a.<br>
     */
    public static final String PEGINTERFERON_ALFA_2A_CODE = "421559001";

    /**
     * EN: Code for Pembrolizumab.<br>
     * DE: Code für Pembrolizumab.<br>
     * FR: Code de pembrolizumab.<br>
     * IT: Code per Pembrolizumab.<br>
     */
    public static final String PEMBROLIZUMAB_CODE = "716125002";

    /**
     * EN: Code for Pemetrexed.<br>
     * DE: Code für Pemetrexed.<br>
     * FR: Code de pémétrexed.<br>
     * IT: Code per Pemetrexed.<br>
     */
    public static final String PEMETREXED_CODE = "409159000";

    /**
     * EN: Code for Penciclovir.<br>
     * DE: Code für Penciclovir.<br>
     * FR: Code de penciclovir.<br>
     * IT: Code per Penciclovir.<br>
     */
    public static final String PENCICLOVIR_CODE = "386939003";

    /**
     * EN: Code for Pentamidine isethionate.<br>
     * DE: Code für Pentamidin diisetionat.<br>
     * FR: Code de pentamidine diiséthionate.<br>
     * IT: Code per Pentamidina.<br>
     */
    public static final String PENTAMIDINE_ISETHIONATE_CODE = "16826009";

    /**
     * EN: Code for Pentoxifylline.<br>
     * DE: Code für Pentoxifyllin.<br>
     * FR: Code de pentoxyfylline.<br>
     * IT: Code per Pentossifillina.<br>
     */
    public static final String PENTOXIFYLLINE_CODE = "387522004";

    /**
     * EN: Code for Perampanel.<br>
     * DE: Code für Perampanel.<br>
     * FR: Code de pérampanel.<br>
     * IT: Code per Perampanel.<br>
     */
    public static final String PERAMPANEL_CODE = "703127006";

    /**
     * EN: Code for Perindopril.<br>
     * DE: Code für Perindopril.<br>
     * FR: Code de périndopril.<br>
     * IT: Code per Perindopril.<br>
     */
    public static final String PERINDOPRIL_CODE = "372916001";

    /**
     * EN: Code for Permethrin.<br>
     * DE: Code für Permethrin.<br>
     * FR: Code de perméthrine.<br>
     * IT: Code per Permetrina.<br>
     */
    public static final String PERMETHRIN_CODE = "410457007";

    /**
     * EN: Code for Pertuzumab.<br>
     * DE: Code für Pertuzumab.<br>
     * FR: Code de pertuzumab.<br>
     * IT: Code per Pertuzumab.<br>
     */
    public static final String PERTUZUMAB_CODE = "704226002";

    /**
     * EN: Code for Pethidine.<br>
     * DE: Code für Pethidin.<br>
     * FR: Code de péthidine.<br>
     * IT: Code per Petidina.<br>
     */
    public static final String PETHIDINE_CODE = "387298007";

    /**
     * EN: Code for Phenazone.<br>
     * DE: Code für Phenazon.<br>
     * FR: Code de phénazone.<br>
     * IT: Code per Fenazone.<br>
     */
    public static final String PHENAZONE_CODE = "55486005";

    /**
     * EN: Code for Pheniramine.<br>
     * DE: Code für Pheniramin.<br>
     * FR: Code de phéniramine.<br>
     * IT: Code per Feniramina.<br>
     */
    public static final String PHENIRAMINE_CODE = "373500002";

    /**
     * EN: Code for Phenobarbital.<br>
     * DE: Code für Phenobarbital.<br>
     * FR: Code de phénobarbital.<br>
     * IT: Code per Fenobarbital.<br>
     */
    public static final String PHENOBARBITAL_CODE = "373505007";

    /**
     * EN: Code for Phenoxybenzamine.<br>
     * DE: Code für Phenoxybenzamin.<br>
     * FR: Code de phénoxybenzamine.<br>
     * IT: Code per Fenossibenzamina.<br>
     */
    public static final String PHENOXYBENZAMINE_CODE = "372838003";

    /**
     * EN: Code for Phenoxymethylpenicillin potassium.<br>
     * DE: Code für Phenoxymethylpenicillin kalium.<br>
     * FR: Code de phénoxyméthylpénicilline potassique.<br>
     * IT: Code per Fenossimetilpenicillina potassica.<br>
     */
    public static final String PHENOXYMETHYLPENICILLIN_POTASSIUM_CODE = "56723006";

    /**
     * EN: Code for Phenprocoumon.<br>
     * DE: Code für Phenprocoumon.<br>
     * FR: Code de phenprocoumone.<br>
     * IT: Code per Fenprocumone.<br>
     */
    public static final String PHENPROCOUMON_CODE = "59488002";

    /**
     * EN: Code for Phentolamine.<br>
     * DE: Code für Phentolamin.<br>
     * FR: Code de phentolamine.<br>
     * IT: Code per Fentolamina.<br>
     */
    public static final String PHENTOLAMINE_CODE = "372863003";

    /**
     * EN: Code for Phenylalanine.<br>
     * DE: Code für Phenylalanin.<br>
     * FR: Code de phénylalanine.<br>
     * IT: Code per Fenilalanina.<br>
     */
    public static final String PHENYLALANINE_CODE = "63004003";

    /**
     * EN: Code for Phenylephrine.<br>
     * DE: Code für Phenylephrin.<br>
     * FR: Code de phényléphrine.<br>
     * IT: Code per Fenilefrina.<br>
     */
    public static final String PHENYLEPHRINE_CODE = "372771005";

    /**
     * EN: Code for Phenytoin.<br>
     * DE: Code für Phenytoin.<br>
     * FR: Code de phénytoïne.<br>
     * IT: Code per Fenitoina.<br>
     */
    public static final String PHENYTOIN_CODE = "387220006";

    /**
     * EN: Code for Pholcodine.<br>
     * DE: Code für Pholcodin.<br>
     * FR: Code de pholcodine.<br>
     * IT: Code per Folcodina.<br>
     */
    public static final String PHOLCODINE_CODE = "396486005";

    /**
     * EN: Code for Phospholipid.<br>
     * DE: Code für Phospholipide.<br>
     * FR: Code de phospholipides.<br>
     * IT: Code per Fosfolipidi.<br>
     */
    public static final String PHOSPHOLIPID_CODE = "78447009";

    /**
     * EN: Code for Physostigmine.<br>
     * DE: Code für Physostigmin.<br>
     * FR: Code de physostigmine.<br>
     * IT: Code per Fisostigmina.<br>
     */
    public static final String PHYSOSTIGMINE_CODE = "373347005";

    /**
     * EN: Code for Phytomenadione.<br>
     * DE: Code für Phytomenadion (Vitamin K1).<br>
     * FR: Code de phytoménadione (Vitamine K1).<br>
     * IT: Code per Fitomenadione (vitamina K1).<br>
     */
    public static final String PHYTOMENADIONE_CODE = "66656000";

    /**
     * EN: Code for Pilocarpine.<br>
     * DE: Code für Pilocarpin.<br>
     * FR: Code de pilocarpine.<br>
     * IT: Code per Pilocarpina.<br>
     */
    public static final String PILOCARPINE_CODE = "372895002";

    /**
     * EN: Code for Pimecrolimus.<br>
     * DE: Code für Pimecrolimus.<br>
     * FR: Code de pimécrolimus.<br>
     * IT: Code per Pimecrolimus.<br>
     */
    public static final String PIMECROLIMUS_CODE = "385580005";

    /**
     * EN: Code for Pioglitazone.<br>
     * DE: Code für Pioglitazon.<br>
     * FR: Code de pioglitazone.<br>
     * IT: Code per Pioglitazone.<br>
     */
    public static final String PIOGLITAZONE_CODE = "395828009";

    /**
     * EN: Code for Pipamperone.<br>
     * DE: Code für Pipamperon.<br>
     * FR: Code de pipampérone.<br>
     * IT: Code per Pipamperone.<br>
     */
    public static final String PIPAMPERONE_CODE = "703362007";

    /**
     * EN: Code for Piperacillin.<br>
     * DE: Code für Piperacillin.<br>
     * FR: Code de pipéracilline.<br>
     * IT: Code per Piperacillina.<br>
     */
    public static final String PIPERACILLIN_CODE = "372836004";

    /**
     * EN: Code for Piracetam.<br>
     * DE: Code für Piracetam.<br>
     * FR: Code de piracétam.<br>
     * IT: Code per Piracetam.<br>
     */
    public static final String PIRACETAM_CODE = "395833008";

    /**
     * EN: Code for Piretanide.<br>
     * DE: Code für Piretanid.<br>
     * FR: Code de pirétanide.<br>
     * IT: Code per Piretanide.<br>
     */
    public static final String PIRETANIDE_CODE = "419451002";

    /**
     * EN: Code for Piroxicam.<br>
     * DE: Code für Piroxicam.<br>
     * FR: Code de piroxicam.<br>
     * IT: Code per Piroxicam.<br>
     */
    public static final String PIROXICAM_CODE = "387153005";

    /**
     * EN: Code for Pitavastatin.<br>
     * DE: Code für Pitavastatin.<br>
     * FR: Code de pitavastatine.<br>
     * IT: Code per Pitavastatina.<br>
     */
    public static final String PITAVASTATIN_CODE = "443586000";

    /**
     * EN: Code for Pituitary luteinizing hormone.<br>
     * DE: Code für Lutropin (hLH).<br>
     * FR: Code de lutropine (hLH).<br>
     * IT: Code per Ormone luteinizzante umano, hLH.<br>
     */
    public static final String PITUITARY_LUTEINIZING_HORMONE_CODE = "64182005";

    /**
     * EN: Code for Plerixafor.<br>
     * DE: Code für Plerixafor.<br>
     * FR: Code de plérixafor.<br>
     * IT: Code per Plerixafor.<br>
     */
    public static final String PLERIXAFOR_CODE = "442264009";

    /**
     * EN: Code for Polihexanide.<br>
     * DE: Code für Polihexanid.<br>
     * FR: Code de polyhexanide.<br>
     * IT: Code per Poliesanide.<br>
     */
    public static final String POLIHEXANIDE_CODE = "421952002";

    /**
     * EN: Code for Polymyxin.<br>
     * DE: Code für Polymyxin B.<br>
     * FR: Code de polymyxine B.<br>
     * IT: Code per Polimixina B.<br>
     */
    public static final String POLYMYXIN_CODE = "373224006";

    /**
     * EN: Code for Posaconazole.<br>
     * DE: Code für Posaconazol.<br>
     * FR: Code de posaconazole.<br>
     * IT: Code per Posaconazolo.<br>
     */
    public static final String POSACONAZOLE_CODE = "421747003";

    /**
     * EN: Code for Potassium acetate.<br>
     * DE: Code für Kaliumacetat.<br>
     * FR: Code de potassium acétate.<br>
     * IT: Code per Potassio acetato.<br>
     */
    public static final String POTASSIUM_ACETATE_CODE = "52394008";

    /**
     * EN: Code for Potassium chloride.<br>
     * DE: Code für Kaliumchlorid.<br>
     * FR: Code de potassium chlorure.<br>
     * IT: Code per Potassio cloruro.<br>
     */
    public static final String POTASSIUM_CHLORIDE_CODE = "8631001";

    /**
     * EN: Code for Potassium citrate.<br>
     * DE: Code für Kalium citrat (E332).<br>
     * FR: Code de potassium citrate (E332).<br>
     * IT: Code per Potassio citrato (E332).<br>
     */
    public static final String POTASSIUM_CITRATE_CODE = "387450001";

    /**
     * EN: Code for Potassium gluconate.<br>
     * DE: Code für Kalium D-gluconat wasserfrei.<br>
     * FR: Code de potassium D-gluconate anhydre.<br>
     * IT: Code per Potassio gluconato.<br>
     */
    public static final String POTASSIUM_GLUCONATE_CODE = "89219006";

    /**
     * EN: Code for Potassium permanganate.<br>
     * DE: Code für Kaliumpermanganat.<br>
     * FR: Code de permanganate de potassium.<br>
     * IT: Code per Potassio permanganato.<br>
     */
    public static final String POTASSIUM_PERMANGANATE_CODE = "4681002";

    /**
     * EN: Code for Potassium phosphate.<br>
     * DE: Code für Kalium phosphat.<br>
     * FR: Code de potassium phosphate.<br>
     * IT: Code per Potassio fosfato.<br>
     */
    public static final String POTASSIUM_PHOSPHATE_CODE = "80916004";

    /**
     * EN: Code for Povidone iodine.<br>
     * DE: Code für Povidon iod.<br>
     * FR: Code de povidone iodée.<br>
     * IT: Code per Iodopovidone.<br>
     */
    public static final String POVIDONE_IODINE_CODE = "386989006";

    /**
     * EN: Code for Pramipexole.<br>
     * DE: Code für Pramipexol.<br>
     * FR: Code de pramipexole.<br>
     * IT: Code per Pramipexolo.<br>
     */
    public static final String PRAMIPEXOLE_CODE = "386852009";

    /**
     * EN: Code for Prasugrel.<br>
     * DE: Code für Prasugrel.<br>
     * FR: Code de prasugrel.<br>
     * IT: Code per Prasugrel.<br>
     */
    public static final String PRASUGREL_CODE = "443129001";

    /**
     * EN: Code for Pravastatin.<br>
     * DE: Code für Pravastatin.<br>
     * FR: Code de pravastatine.<br>
     * IT: Code per Pravastatina.<br>
     */
    public static final String PRAVASTATIN_CODE = "373566006";

    /**
     * EN: Code for Prazepam.<br>
     * DE: Code für Prazepam.<br>
     * FR: Code de prazépam.<br>
     * IT: Code per Prazepam.<br>
     */
    public static final String PRAZEPAM_CODE = "387417001";

    /**
     * EN: Code for Praziquantel.<br>
     * DE: Code für Praziquantel.<br>
     * FR: Code de praziquantel.<br>
     * IT: Code per Praziquantel.<br>
     */
    public static final String PRAZIQUANTEL_CODE = "387310003";

    /**
     * EN: Code for Prednicarbate.<br>
     * DE: Code für Prednicarbat.<br>
     * FR: Code de prednicarbate.<br>
     * IT: Code per Prednicarbato.<br>
     */
    public static final String PREDNICARBATE_CODE = "126086006";

    /**
     * EN: Code for Prednisolone.<br>
     * DE: Code für Prednisolon.<br>
     * FR: Code de prednisolone.<br>
     * IT: Code per Prednisolone.<br>
     */
    public static final String PREDNISOLONE_CODE = "116601002";

    /**
     * EN: Code for Prednisone.<br>
     * DE: Code für Prednison.<br>
     * FR: Code de prednisone.<br>
     * IT: Code per Prednisone.<br>
     */
    public static final String PREDNISONE_CODE = "116602009";

    /**
     * EN: Code for Pregabalin.<br>
     * DE: Code für Pregabalin.<br>
     * FR: Code de prégabaline.<br>
     * IT: Code per Pregabalin.<br>
     */
    public static final String PREGABALIN_CODE = "415160008";

    /**
     * EN: Code for Prilocaine.<br>
     * DE: Code für Prilocain.<br>
     * FR: Code de prilocaïne.<br>
     * IT: Code per Prilocaina.<br>
     */
    public static final String PRILOCAINE_CODE = "387107003";

    /**
     * EN: Code for Primaquine.<br>
     * DE: Code für Primaquin.<br>
     * FR: Code de primaquine.<br>
     * IT: Code per Primachina.<br>
     */
    public static final String PRIMAQUINE_CODE = "429663004";

    /**
     * EN: Code for Primidone.<br>
     * DE: Code für Primidon.<br>
     * FR: Code de primidone.<br>
     * IT: Code per Primidone.<br>
     */
    public static final String PRIMIDONE_CODE = "387256009";

    /**
     * EN: Code for Probenecid.<br>
     * DE: Code für Probenecid.<br>
     * FR: Code de probénécide.<br>
     * IT: Code per Probenecid.<br>
     */
    public static final String PROBENECID_CODE = "387365004";

    /**
     * EN: Code for Procainamide.<br>
     * DE: Code für Procainamid.<br>
     * FR: Code de procaïnamide.<br>
     * IT: Code per Procainamide.<br>
     */
    public static final String PROCAINAMIDE_CODE = "372589008";

    /**
     * EN: Code for Procaine.<br>
     * DE: Code für Procain.<br>
     * FR: Code de procaïne.<br>
     * IT: Code per Procaina.<br>
     */
    public static final String PROCAINE_CODE = "387238009";

    /**
     * EN: Code for Procyclidine.<br>
     * DE: Code für Procyclidin.<br>
     * FR: Code de procyclidine.<br>
     * IT: Code per Prociclidina.<br>
     */
    public static final String PROCYCLIDINE_CODE = "387247001";

    /**
     * EN: Code for Progesterone.<br>
     * DE: Code für Progesteron.<br>
     * FR: Code de progestérone.<br>
     * IT: Code per Progesterone.<br>
     */
    public static final String PROGESTERONE_CODE = "16683002";

    /**
     * EN: Code for Proguanil.<br>
     * DE: Code für Proguanil.<br>
     * FR: Code de proguanil.<br>
     * IT: Code per Proguanil.<br>
     */
    public static final String PROGUANIL_CODE = "387094004";

    /**
     * EN: Code for Proline.<br>
     * DE: Code für Prolin.<br>
     * FR: Code de proline.<br>
     * IT: Code per Prolina.<br>
     */
    public static final String PROLINE_CODE = "52541003";

    /**
     * EN: Code for Promazine hydrochloride.<br>
     * DE: Code für Promazin hydrochlorid.<br>
     * FR: Code de promazine chlorhydrate.<br>
     * IT: Code per Promazina.<br>
     */
    public static final String PROMAZINE_HYDROCHLORIDE_CODE = "79135001";

    /**
     * EN: Code for Promethazine.<br>
     * DE: Code für Promethazin.<br>
     * FR: Code de prométhazine.<br>
     * IT: Code per Prometazina.<br>
     */
    public static final String PROMETHAZINE_CODE = "372871004";

    /**
     * EN: Code for Propafenone.<br>
     * DE: Code für Propafenon.<br>
     * FR: Code de propafénone.<br>
     * IT: Code per Propafenone.<br>
     */
    public static final String PROPAFENONE_CODE = "372910007";

    /**
     * EN: Code for Propofol.<br>
     * DE: Code für Propofol.<br>
     * FR: Code de propofol.<br>
     * IT: Code per Propofol.<br>
     */
    public static final String PROPOFOL_CODE = "387423006";

    /**
     * EN: Code for Propranolol.<br>
     * DE: Code für Propranolol.<br>
     * FR: Code de propranolol.<br>
     * IT: Code per Propranololo.<br>
     */
    public static final String PROPRANOLOL_CODE = "372772003";

    /**
     * EN: Code for Propyphenazone.<br>
     * DE: Code für Propyphenazon.<br>
     * FR: Code de propyphénazone.<br>
     * IT: Code per Propifenazone.<br>
     */
    public static final String PROPYPHENAZONE_CODE = "699188007";

    /**
     * EN: Code for Protamine.<br>
     * DE: Code für Protamin.<br>
     * FR: Code de protamine.<br>
     * IT: Code per Protamina.<br>
     */
    public static final String PROTAMINE_CODE = "372630008";

    /**
     * EN: Code for Protein C.<br>
     * DE: Code für Protein C (human).<br>
     * FR: Code de protéine C humaine.<br>
     * IT: Code per Proteina C (umana).<br>
     */
    public static final String PROTEIN_C_CODE = "25525005";

    /**
     * EN: Code for Protein S.<br>
     * DE: Code für Protein S (human).<br>
     * FR: Code de protéine S humaine.<br>
     * IT: Code per Proteina S (umana).<br>
     */
    public static final String PROTEIN_S_CODE = "56898001";

    /**
     * EN: Code for Protionamide.<br>
     * DE: Code für Protionamid.<br>
     * FR: Code de protionamide.<br>
     * IT: Code per Protionamide.<br>
     */
    public static final String PROTIONAMIDE_CODE = "703589003";

    /**
     * EN: Code for Protireline.<br>
     * DE: Code für Protirelin.<br>
     * FR: Code de protiréline.<br>
     * IT: Code per Protirelina.<br>
     */
    public static final String PROTIRELINE_CODE = "412495007";

    /**
     * EN: Code for Prucalopride.<br>
     * DE: Code für Prucaloprid.<br>
     * FR: Code de prucalopride.<br>
     * IT: Code per Prucalopride.<br>
     */
    public static final String PRUCALOPRIDE_CODE = "699273008";

    /**
     * EN: Code for Pseudoephedrine.<br>
     * DE: Code für Pseudoephedrin.<br>
     * FR: Code de pseudoéphédrine.<br>
     * IT: Code per Pseudoefedrina.<br>
     */
    public static final String PSEUDOEPHEDRINE_CODE = "372900003";

    /**
     * EN: Code for Pyrazinamide.<br>
     * DE: Code für Pyrazinamid.<br>
     * FR: Code de pyrazinamide.<br>
     * IT: Code per Pirazinamide.<br>
     */
    public static final String PYRAZINAMIDE_CODE = "387076005";

    /**
     * EN: Code for Pyridostigmine bromide.<br>
     * DE: Code für Pyridostigmin bromid.<br>
     * FR: Code de pyridostigmine bromure.<br>
     * IT: Code per Piridostigmina bromuro.<br>
     */
    public static final String PYRIDOSTIGMINE_BROMIDE_CODE = "34915005";

    /**
     * EN: Code for Pyridoxal phosphate.<br>
     * DE: Code für Pyridoxal-5-phosphat.<br>
     * FR: Code de pyridoxal-5-phosphate.<br>
     * IT: Code per Piridossal fosfato.<br>
     */
    public static final String PYRIDOXAL_PHOSPHATE_CODE = "259663004";

    /**
     * EN: Code for Pyridoxine.<br>
     * DE: Code für Pyridoxin (Vitamin B6).<br>
     * FR: Code de pyridoxine (Vitamine B6).<br>
     * IT: Code per Piridossina (vitamina B6).<br>
     */
    public static final String PYRIDOXINE_CODE = "430469009";

    /**
     * EN: Code for Pyrimethamine.<br>
     * DE: Code für Pyrimethamin.<br>
     * FR: Code de pyriméthamine.<br>
     * IT: Code per Pirimetamina.<br>
     */
    public static final String PYRIMETHAMINE_CODE = "373769001";

    /**
     * EN: Code for Quetiapine.<br>
     * DE: Code für Quetiapin.<br>
     * FR: Code de quétiapine.<br>
     * IT: Code per Quetiapina.<br>
     */
    public static final String QUETIAPINE_CODE = "386850001";

    /**
     * EN: Code for Quinapril.<br>
     * DE: Code für Quinapril.<br>
     * FR: Code de quinapril.<br>
     * IT: Code per Quinapril.<br>
     */
    public static final String QUINAPRIL_CODE = "386874003";

    /**
     * EN: Code for Quinine.<br>
     * DE: Code für Chinin.<br>
     * FR: Code de quinine.<br>
     * IT: Code per Chinina.<br>
     */
    public static final String QUININE_CODE = "373497008";

    /**
     * EN: Code for Rabeprazole.<br>
     * DE: Code für Rabeprazol.<br>
     * FR: Code de rabéprazole.<br>
     * IT: Code per Rabeprazolo.<br>
     */
    public static final String RABEPRAZOLE_CODE = "422225001";

    /**
     * EN: Code for Rabies human immune globulin.<br>
     * DE: Code für Tollwut-Immunglobulin vom Menschen.<br>
     * FR: Code de immunoglobuline humaine anti-rabique.<br>
     * IT: Code per Immunoglobulina umana antirabbica.<br>
     */
    public static final String RABIES_HUMAN_IMMUNE_GLOBULIN_CODE = "422303009";

    /**
     * EN: Code for Raloxifene.<br>
     * DE: Code für Raloxifen.<br>
     * FR: Code de raloxifène.<br>
     * IT: Code per Raloxifene.<br>
     */
    public static final String RALOXIFENE_CODE = "109029006";

    /**
     * EN: Code for Raltegravir.<br>
     * DE: Code für Raltegravir.<br>
     * FR: Code de raltégravir.<br>
     * IT: Code per Raltegravir.<br>
     */
    public static final String RALTEGRAVIR_CODE = "429707008";

    /**
     * EN: Code for Raltitrexed.<br>
     * DE: Code für Raltitrexed.<br>
     * FR: Code de raltitrexed.<br>
     * IT: Code per Raltitrexed.<br>
     */
    public static final String RALTITREXED_CODE = "395857008";

    /**
     * EN: Code for Ramipril.<br>
     * DE: Code für Ramipril.<br>
     * FR: Code de ramipril.<br>
     * IT: Code per Ramipril.<br>
     */
    public static final String RAMIPRIL_CODE = "386872004";

    /**
     * EN: Code for Ramucirumab.<br>
     * DE: Code für Ramucirumab.<br>
     * FR: Code de ramucirumab.<br>
     * IT: Code per Ramucirumab.<br>
     */
    public static final String RAMUCIRUMAB_CODE = "704259004";

    /**
     * EN: Code for Ranitidine.<br>
     * DE: Code für Ranitidin.<br>
     * FR: Code de ranitidine.<br>
     * IT: Code per Ranitidina.<br>
     */
    public static final String RANITIDINE_CODE = "372755005";

    /**
     * EN: Code for Ranolazine.<br>
     * DE: Code für Ranolazin.<br>
     * FR: Code de ranolazine.<br>
     * IT: Code per Ranolazina.<br>
     */
    public static final String RANOLAZINE_CODE = "420365007";

    /**
     * EN: Code for Rasagiline.<br>
     * DE: Code für Rasagilin.<br>
     * FR: Code de rasagiline.<br>
     * IT: Code per Rasagilina.<br>
     */
    public static final String RASAGILINE_CODE = "418734001";

    /**
     * EN: Code for Rasburicase.<br>
     * DE: Code für Rasburicase.<br>
     * FR: Code de rasburicase.<br>
     * IT: Code per Rasburicase.<br>
     */
    public static final String RASBURICASE_CODE = "395858003";

    /**
     * EN: Code for Reboxetine.<br>
     * DE: Code für Reboxetin.<br>
     * FR: Code de réboxétine.<br>
     * IT: Code per Reboxetina.<br>
     */
    public static final String REBOXETINE_CODE = "395859006";

    /**
     * EN: Code for Remifentanil.<br>
     * DE: Code für Remifentanil.<br>
     * FR: Code de rémifentanil.<br>
     * IT: Code per Remifentanil.<br>
     */
    public static final String REMIFENTANIL_CODE = "386839004";

    /**
     * EN: Code for Repaglinide.<br>
     * DE: Code für Repaglinid.<br>
     * FR: Code de répaglinide.<br>
     * IT: Code per Repaglinide.<br>
     */
    public static final String REPAGLINIDE_CODE = "386964000";

    /**
     * EN: Code for Retigabine.<br>
     * DE: Code für Retigabin.<br>
     * FR: Code de rétigabine.<br>
     * IT: Code per Retigabina.<br>
     */
    public static final String RETIGABINE_CODE = "699271005";

    /**
     * EN: Code for Retinol.<br>
     * DE: Code für Retinol (Vitamin A).<br>
     * FR: Code de rétinol (Vitamine a).<br>
     * IT: Code per Retinolo (vitamina A).<br>
     */
    public static final String RETINOL_CODE = "82622003";

    /**
     * EN: Code for Ribavirin.<br>
     * DE: Code für Ribavirin.<br>
     * FR: Code de ribavirine.<br>
     * IT: Code per Ribavirina.<br>
     */
    public static final String RIBAVIRIN_CODE = "387188005";

    /**
     * EN: Code for Riboflavin.<br>
     * DE: Code für Riboflavin (Vitamin B2, E101).<br>
     * FR: Code de riboflavine (Vitamine B2, E101).<br>
     * IT: Code per Riboflavina (vitamina B2, E 101).<br>
     */
    public static final String RIBOFLAVIN_CODE = "13235001";

    /**
     * EN: Code for Rifabutin.<br>
     * DE: Code für Rifabutin.<br>
     * FR: Code de rifabutine.<br>
     * IT: Code per Rifabutina.<br>
     */
    public static final String RIFABUTIN_CODE = "386893001";

    /**
     * EN: Code for Rifampicin.<br>
     * DE: Code für Rifampicin.<br>
     * FR: Code de rifampicine.<br>
     * IT: Code per Rifampicina.<br>
     */
    public static final String RIFAMPICIN_CODE = "387159009";

    /**
     * EN: Code for Rifaximin.<br>
     * DE: Code für Rifaximin.<br>
     * FR: Code de rifaximine.<br>
     * IT: Code per Rifaximina.<br>
     */
    public static final String RIFAXIMIN_CODE = "412553001";

    /**
     * EN: Code for Rilpivirine.<br>
     * DE: Code für Rilpivirin.<br>
     * FR: Code de rilpivirine.<br>
     * IT: Code per Rilpivirina.<br>
     */
    public static final String RILPIVIRINE_CODE = "703123005";

    /**
     * EN: Code for Riluzole.<br>
     * DE: Code für Riluzol.<br>
     * FR: Code de riluzole.<br>
     * IT: Code per Riluzolo.<br>
     */
    public static final String RILUZOLE_CODE = "386980005";

    /**
     * EN: Code for Rimexolone.<br>
     * DE: Code für Rimexolon.<br>
     * FR: Code de rimexolone.<br>
     * IT: Code per Rimexolone.<br>
     */
    public static final String RIMEXOLONE_CODE = "387046003";

    /**
     * EN: Code for Riociguat.<br>
     * DE: Code für Riociguat.<br>
     * FR: Code de riociguat.<br>
     * IT: Code per Riociguat.<br>
     */
    public static final String RIOCIGUAT_CODE = "713333001";

    /**
     * EN: Code for Risedronate sodium.<br>
     * DE: Code für Risedronat natrium.<br>
     * FR: Code de risédronate sodique.<br>
     * IT: Code per Sodio risedronato.<br>
     */
    public static final String RISEDRONATE_SODIUM_CODE = "387064005";

    /**
     * EN: Code for Risedronic acid.<br>
     * DE: Code für Risedronsäure.<br>
     * FR: Code de acide risédronique.<br>
     * IT: Code per Acido risedronico.<br>
     */
    public static final String RISEDRONIC_ACID_CODE = "768539002";

    /**
     * EN: Code for Risperidone.<br>
     * DE: Code für Risperidon.<br>
     * FR: Code de rispéridone.<br>
     * IT: Code per Risperidone.<br>
     */
    public static final String RISPERIDONE_CODE = "386840002";

    /**
     * EN: Code for Ritonavir.<br>
     * DE: Code für Ritonavir.<br>
     * FR: Code de ritonavir.<br>
     * IT: Code per Ritonavir.<br>
     */
    public static final String RITONAVIR_CODE = "386896009";

    /**
     * EN: Code for Rituximab.<br>
     * DE: Code für Rituximab.<br>
     * FR: Code de rituximab.<br>
     * IT: Code per Rituximab.<br>
     */
    public static final String RITUXIMAB_CODE = "386919002";

    /**
     * EN: Code for Rivaroxaban.<br>
     * DE: Code für Rivaroxaban.<br>
     * FR: Code de rivaroxaban.<br>
     * IT: Code per Rivaroxaban.<br>
     */
    public static final String RIVAROXABAN_CODE = "442031002";

    /**
     * EN: Code for Rivastigmine.<br>
     * DE: Code für Rivastigmin.<br>
     * FR: Code de rivastigmine.<br>
     * IT: Code per Rivastigmina.<br>
     */
    public static final String RIVASTIGMINE_CODE = "395868008";

    /**
     * EN: Code for Rizatriptan.<br>
     * DE: Code für Rizatriptan.<br>
     * FR: Code de rizatriptan.<br>
     * IT: Code per Rizatriptan.<br>
     */
    public static final String RIZATRIPTAN_CODE = "363573000";

    /**
     * EN: Code for Rocuronium bromide.<br>
     * DE: Code für Rocuronium bromid.<br>
     * FR: Code de rocuronium bromure.<br>
     * IT: Code per Rocuronio bromuro.<br>
     */
    public static final String ROCURONIUM_BROMIDE_CODE = "108450002";

    /**
     * EN: Code for Roflumilast.<br>
     * DE: Code für Roflumilast.<br>
     * FR: Code de roflumilast.<br>
     * IT: Code per Roflumilast.<br>
     */
    public static final String ROFLUMILAST_CODE = "448971002";

    /**
     * EN: Code for Romiplostim.<br>
     * DE: Code für Romiplostim.<br>
     * FR: Code de romiplostim.<br>
     * IT: Code per Romiplostim.<br>
     */
    public static final String ROMIPLOSTIM_CODE = "439122000";

    /**
     * EN: Code for Ropinirole.<br>
     * DE: Code für Ropinirol.<br>
     * FR: Code de ropinirole.<br>
     * IT: Code per Ropinirolo.<br>
     */
    public static final String ROPINIROLE_CODE = "372499000";

    /**
     * EN: Code for Ropivacaine.<br>
     * DE: Code für Ropivacain.<br>
     * FR: Code de ropivacaïne.<br>
     * IT: Code per Ropivacaina.<br>
     */
    public static final String ROPIVACAINE_CODE = "386969005";

    /**
     * EN: Code for Rosuvastatin.<br>
     * DE: Code für Rosuvastatin.<br>
     * FR: Code de rosuvastatine.<br>
     * IT: Code per Rosuvastatina.<br>
     */
    public static final String ROSUVASTATIN_CODE = "700067006";

    /**
     * EN: Code for Rotigotine.<br>
     * DE: Code für Rotigotin.<br>
     * FR: Code de rotigotine.<br>
     * IT: Code per Rotigotina.<br>
     */
    public static final String ROTIGOTINE_CODE = "421924006";

    /**
     * EN: Code for Rufinamide.<br>
     * DE: Code für Rufinamid.<br>
     * FR: Code de rufinamide.<br>
     * IT: Code per Rufinamide.<br>
     */
    public static final String RUFINAMIDE_CODE = "429835003";

    /**
     * EN: Code for Saccharomyces boulardii.<br>
     * DE: Code für Saccharomyces boulardii.<br>
     * FR: Code de saccharomyces boulardii.<br>
     * IT: Code per Saccharomyces boulardii.<br>
     */
    public static final String SACCHAROMYCES_BOULARDII_CODE = "700441006";

    /**
     * EN: Code for Sacubitril.<br>
     * DE: Code für Sacubitril.<br>
     * FR: Code de sacubitril.<br>
     * IT: Code per Sacubitril.<br>
     */
    public static final String SACUBITRIL_CODE = "716072000";

    /**
     * EN: Code for Safinamide.<br>
     * DE: Code für Safinamid.<br>
     * FR: Code de safinamide.<br>
     * IT: Code per Safinamide.<br>
     */
    public static final String SAFINAMIDE_CODE = "718852000";

    /**
     * EN: Code for Salbutamol.<br>
     * DE: Code für Salbutamol.<br>
     * FR: Code de salbutamol.<br>
     * IT: Code per Salbutamolo.<br>
     */
    public static final String SALBUTAMOL_CODE = "372897005";

    /**
     * EN: Code for Salicylamide.<br>
     * DE: Code für Salicylamid.<br>
     * FR: Code de salicylamide.<br>
     * IT: Code per Salicilamide.<br>
     */
    public static final String SALICYLAMIDE_CODE = "22192002";

    /**
     * EN: Code for Salicylic acid.<br>
     * DE: Code für Salicylsäure.<br>
     * FR: Code de acide salicylique.<br>
     * IT: Code per Acido salicilico.<br>
     */
    public static final String SALICYLIC_ACID_CODE = "387253001";

    /**
     * EN: Code for Salmeterol.<br>
     * DE: Code für Salmeterol.<br>
     * FR: Code de salmétérol.<br>
     * IT: Code per Salmeterolo.<br>
     */
    public static final String SALMETEROL_CODE = "372515005";

    /**
     * EN: Code for Sapropterin.<br>
     * DE: Code für Sapropterin.<br>
     * FR: Code de saproptérine.<br>
     * IT: Code per Sapropterina.<br>
     */
    public static final String SAPROPTERIN_CODE = "432859002";

    /**
     * EN: Code for Saquinavir.<br>
     * DE: Code für Saquinavir.<br>
     * FR: Code de saquinavir.<br>
     * IT: Code per Saquinavir.<br>
     */
    public static final String SAQUINAVIR_CODE = "372530001";

    /**
     * EN: Code for Sarilumab.<br>
     * DE: Code für Sarilumab.<br>
     * FR: Code de sarilumab.<br>
     * IT: Code per Sarilumab.<br>
     */
    public static final String SARILUMAB_CODE = "735231009";

    /**
     * EN: Code for Saxagliptin.<br>
     * DE: Code für Saxagliptin.<br>
     * FR: Code de saxagliptine.<br>
     * IT: Code per Saxagliptin.<br>
     */
    public static final String SAXAGLIPTIN_CODE = "443087004";

    /**
     * EN: Code for Scopolamine.<br>
     * DE: Code für Scopolamin.<br>
     * FR: Code de scopolamine.<br>
     * IT: Code per Scopolamina.<br>
     */
    public static final String SCOPOLAMINE_CODE = "387409009";

    /**
     * EN: Code for Scopolamine butylbromide.<br>
     * DE: Code für Scopolamin butylbromid.<br>
     * FR: Code de scopolamine butylbromure.<br>
     * IT: Code per Scopolamina butilbromuro.<br>
     */
    public static final String SCOPOLAMINE_BUTYLBROMIDE_CODE = "395739004";

    /**
     * EN: Code for Secretin.<br>
     * DE: Code für Secretin.<br>
     * FR: Code de sécrétine.<br>
     * IT: Code per Secretina.<br>
     */
    public static final String SECRETIN_CODE = "19205004";

    /**
     * EN: Code for Secukinumab.<br>
     * DE: Code für Secukinumab.<br>
     * FR: Code de sécukinumab.<br>
     * IT: Code per Secukinumab.<br>
     */
    public static final String SECUKINUMAB_CODE = "708822004";

    /**
     * EN: Code for Serine.<br>
     * DE: Code für L-Serin.<br>
     * FR: Code de l-sérine.<br>
     * IT: Code per Serina.<br>
     */
    public static final String SERINE_CODE = "14125007";

    /**
     * EN: Code for Sertraline.<br>
     * DE: Code für Sertralin.<br>
     * FR: Code de sertraline.<br>
     * IT: Code per Sertralina.<br>
     */
    public static final String SERTRALINE_CODE = "372594008";

    /**
     * EN: Code for Sevelamer.<br>
     * DE: Code für Sevelamer.<br>
     * FR: Code de sévélamer.<br>
     * IT: Code per Sevelamer.<br>
     */
    public static final String SEVELAMER_CODE = "395871000";

    /**
     * EN: Code for Sevoflurane.<br>
     * DE: Code für Sevofluran.<br>
     * FR: Code de sévoflurane.<br>
     * IT: Code per Sevoflurano.<br>
     */
    public static final String SEVOFLURANE_CODE = "386842005";

    /**
     * EN: Code for Sildenafil.<br>
     * DE: Code für Sildenafil.<br>
     * FR: Code de sildénafil.<br>
     * IT: Code per Sildenafil.<br>
     */
    public static final String SILDENAFIL_CODE = "372572000";

    /**
     * EN: Code for Silibinin.<br>
     * DE: Code für Silibinin.<br>
     * FR: Code de silibinine.<br>
     * IT: Code per Silibina.<br>
     */
    public static final String SILIBININ_CODE = "720527007";

    /**
     * EN: Code for Silodosin.<br>
     * DE: Code für Silodosin.<br>
     * FR: Code de silodosine.<br>
     * IT: Code per Silodosina.<br>
     */
    public static final String SILODOSIN_CODE = "442042006";

    /**
     * EN: Code for Simeticone.<br>
     * DE: Code für Simeticon.<br>
     * FR: Code de siméticone.<br>
     * IT: Code per Simeticone.<br>
     */
    public static final String SIMETICONE_CODE = "387442005";

    /**
     * EN: Code for Simoctocog alfa.<br>
     * DE: Code für Simoctocog alfa.<br>
     * FR: Code de simoctocog alfa.<br>
     * IT: Code per Simoctocog alfa.<br>
     */
    public static final String SIMOCTOCOG_ALFA_CODE = "718853005";

    /**
     * EN: Code for Simvastatin.<br>
     * DE: Code für Simvastatin.<br>
     * FR: Code de simvastatine.<br>
     * IT: Code per Simvastatina.<br>
     */
    public static final String SIMVASTATIN_CODE = "387584000";

    /**
     * EN: Code for Sirolimus.<br>
     * DE: Code für Sirolimus.<br>
     * FR: Code de sirolimus.<br>
     * IT: Code per Sirolimus.<br>
     */
    public static final String SIROLIMUS_CODE = "387014003";

    /**
     * EN: Code for Sitagliptin.<br>
     * DE: Code für Sitagliptin.<br>
     * FR: Code de sitagliptine.<br>
     * IT: Code per Sitagliptin.<br>
     */
    public static final String SITAGLIPTIN_CODE = "423307000";

    /**
     * EN: Code for Sodium acetate trihydrat.<br>
     * DE: Code für Natrium acetat-3-Wasser.<br>
     * FR: Code de sodium acétate trihydrate.<br>
     * IT: Code per Sodio acetato triidrato.<br>
     */
    public static final String SODIUM_ACETATE_TRIHYDRAT_CODE = "726006002";

    /**
     * EN: Code for Sodium bicarbonate.<br>
     * DE: Code für Natriumhydrogencarbonat.<br>
     * FR: Code de sodium bicarbonate.<br>
     * IT: Code per Bicarbonato di sodio.<br>
     */
    public static final String SODIUM_BICARBONATE_CODE = "387319002";

    /**
     * EN: Code for Sodium chloride.<br>
     * DE: Code für Natriumchlorid.<br>
     * FR: Code de sodium chlorure.<br>
     * IT: Code per Sodio cloruro.<br>
     */
    public static final String SODIUM_CHLORIDE_CODE = "387390002";

    /**
     * EN: Code for Sodium citrate.<br>
     * DE: Code für Natriumcitrat.<br>
     * FR: Code de sodium citrate.<br>
     * IT: Code per Sodio citrato.<br>
     */
    public static final String SODIUM_CITRATE_CODE = "412546005";

    /**
     * EN: Code for Sodium dihydrogen phosphate dihydrate.<br>
     * DE: Code für Natrium dihydrogenphosphat-2-Wasser.<br>
     * FR: Code de sodium dihydrogénophosphate dihydrate.<br>
     * IT: Code per Sodio fosfato monobasico diidrato.<br>
     */
    public static final String SODIUM_DIHYDROGEN_PHOSPHATE_DIHYDRATE_CODE = "726716000";

    /**
     * EN: Code for Sodium hydroxide.<br>
     * DE: Code für Natriumhydroxid.<br>
     * FR: Code de sodium hydroxyde.<br>
     * IT: Code per Sodio idrossido.<br>
     */
    public static final String SODIUM_HYDROXIDE_CODE = "23423003";

    /**
     * EN: Code for Sodium nitroprusside.<br>
     * DE: Code für Nitroprussidnatrium, wasserfrei.<br>
     * FR: Code de nitroprussiate de sodium anhydre.<br>
     * IT: Code per Sodio nitroprussiato.<br>
     */
    public static final String SODIUM_NITROPRUSSIDE_CODE = "387139005";

    /**
     * EN: Code for Sodium picosulfate.<br>
     * DE: Code für Natrium picosulfat.<br>
     * FR: Code de picosulfate sodique.<br>
     * IT: Code per Sodio picosolfato.<br>
     */
    public static final String SODIUM_PICOSULFATE_CODE = "395881001";

    /**
     * EN: Code for Sodium selenite.<br>
     * DE: Code für Dinatrium-selenit.<br>
     * FR: Code de sélénite disodique.<br>
     * IT: Code per Sodio selenito.<br>
     */
    public static final String SODIUM_SELENITE_CODE = "96277001";

    /**
     * EN: Code for Sodium thiosulfate.<br>
     * DE: Code für Dinatrium-thiosulfat.<br>
     * FR: Code de sodium thiosulfate.<br>
     * IT: Code per Sodio tiosolfato.<br>
     */
    public static final String SODIUM_THIOSULFATE_CODE = "387209006";

    /**
     * EN: Code for Sofosbuvir.<br>
     * DE: Code für Sofosbuvir.<br>
     * FR: Code de sofosbuvir.<br>
     * IT: Code per Sofosbuvir.<br>
     */
    public static final String SOFOSBUVIR_CODE = "710806008";

    /**
     * EN: Code for Solifenacin.<br>
     * DE: Code für Solifenacin.<br>
     * FR: Code de solifénacine.<br>
     * IT: Code per Solifenacina.<br>
     */
    public static final String SOLIFENACIN_CODE = "407030007";

    /**
     * EN: Code for Somatostatin.<br>
     * DE: Code für Somatostatin.<br>
     * FR: Code de somatostatine.<br>
     * IT: Code per Somatostatina.<br>
     */
    public static final String SOMATOSTATIN_CODE = "49722008";

    /**
     * EN: Code for Somatotropin releasing factor.<br>
     * DE: Code für Somatorelin.<br>
     * FR: Code de somatoréline.<br>
     * IT: Code per Somatorelina.<br>
     */
    public static final String SOMATOTROPIN_RELEASING_FACTOR_CODE = "16628008";

    /**
     * EN: Code for Somatropin.<br>
     * DE: Code für Somatropin.<br>
     * FR: Code de somatropine.<br>
     * IT: Code per Somatropina.<br>
     */
    public static final String SOMATROPIN_CODE = "395883003";

    /**
     * EN: Code for Sorafenib.<br>
     * DE: Code für Sorafenib.<br>
     * FR: Code de sorafénib.<br>
     * IT: Code per Sorafenib.<br>
     */
    public static final String SORAFENIB_CODE = "422042001";

    /**
     * EN: Code for Sotalol.<br>
     * DE: Code für Sotalol.<br>
     * FR: Code de sotalol.<br>
     * IT: Code per Sotalolo.<br>
     */
    public static final String SOTALOL_CODE = "372911006";

    /**
     * EN: Code for Soy bean oil.<br>
     * DE: Code für Sojabohnenöl.<br>
     * FR: Code de soja fèves huile.<br>
     * IT: Code per Soia olio.<br>
     */
    public static final String SOY_BEAN_OIL_CODE = "226911007";

    /**
     * EN: Code for Spironolactone.<br>
     * DE: Code für Spironolacton.<br>
     * FR: Code de spironolactone.<br>
     * IT: Code per Spironolattone.<br>
     */
    public static final String SPIRONOLACTONE_CODE = "387078006";

    /**
     * EN: Code for Stiripentol.<br>
     * DE: Code für Stiripentol.<br>
     * FR: Code de stiripentol.<br>
     * IT: Code per Stiripentolo.<br>
     */
    public static final String STIRIPENTOL_CODE = "428221002";

    /**
     * EN: Code for Substance with protease mechanism of action.<br>
     * DE: Code für Protease.<br>
     * FR: Code de protéase.<br>
     * IT: Code per Proteasi.<br>
     */
    public static final String SUBSTANCE_WITH_PROTEASE_MECHANISM_OF_ACTION_CODE = "387033008";

    /**
     * EN: Code for Succinylcholine chloride.<br>
     * DE: Code für Suxamethonium chlorid.<br>
     * FR: Code de suxaméthonium chlorure.<br>
     * IT: Code per Succinilcolina cloruro.<br>
     */
    public static final String SUCCINYLCHOLINE_CHLORIDE_CODE = "58907007";

    /**
     * EN: Code for Sufentanil.<br>
     * DE: Code für Sufentanil.<br>
     * FR: Code de sufentanil.<br>
     * IT: Code per Sufentanil.<br>
     */
    public static final String SUFENTANIL_CODE = "49998007";

    /**
     * EN: Code for Sugammadex.<br>
     * DE: Code für Sugammadex.<br>
     * FR: Code de sugammadex.<br>
     * IT: Code per Sugammadex.<br>
     */
    public static final String SUGAMMADEX_CODE = "442340006";

    /**
     * EN: Code for Sulfadiazine.<br>
     * DE: Code für Sulfadiazin.<br>
     * FR: Code de sulfadiazine.<br>
     * IT: Code per Sulfadiazina.<br>
     */
    public static final String SULFADIAZINE_CODE = "74523009";

    /**
     * EN: Code for Sulfamethoxazole.<br>
     * DE: Code für Sulfamethoxazol.<br>
     * FR: Code de sulfaméthoxazole.<br>
     * IT: Code per Sulfametossazolo.<br>
     */
    public static final String SULFAMETHOXAZOLE_CODE = "363528007";

    /**
     * EN: Code for Sulfasalazine.<br>
     * DE: Code für Sulfasalazin.<br>
     * FR: Code de sulfasalazine.<br>
     * IT: Code per Sulfasalazina.<br>
     */
    public static final String SULFASALAZINE_CODE = "387248006";

    /**
     * EN: Code for Sulfur hexafluoride.<br>
     * DE: Code für Schwefelhexafluorid.<br>
     * FR: Code de soufre hexafluorure.<br>
     * IT: Code per Zolfo esafluoruro.<br>
     */
    public static final String SULFUR_HEXAFLUORIDE_CODE = "259276004";

    /**
     * EN: Code for Sulpiride.<br>
     * DE: Code für Sulpirid.<br>
     * FR: Code de sulpiride.<br>
     * IT: Code per Sulpiride.<br>
     */
    public static final String SULPIRIDE_CODE = "395891007";

    /**
     * EN: Code for Sulprostone.<br>
     * DE: Code für Sulproston.<br>
     * FR: Code de sulprostone.<br>
     * IT: Code per Sulprostone.<br>
     */
    public static final String SULPROSTONE_CODE = "713461008";

    /**
     * EN: Code for Sulthiamine.<br>
     * DE: Code für Sultiam.<br>
     * FR: Code de sultiame.<br>
     * IT: Code per Sultiame.<br>
     */
    public static final String SULTHIAMINE_CODE = "50580004";

    /**
     * EN: Code for Sumatriptan.<br>
     * DE: Code für Sumatriptan.<br>
     * FR: Code de sumatriptan.<br>
     * IT: Code per Sumatriptan.<br>
     */
    public static final String SUMATRIPTAN_CODE = "395892000";

    /**
     * EN: Code for Tacrolimus.<br>
     * DE: Code für Tacrolimus.<br>
     * FR: Code de tacrolimus.<br>
     * IT: Code per Tacrolimus.<br>
     */
    public static final String TACROLIMUS_CODE = "386975001";

    /**
     * EN: Code for Tadalafil.<br>
     * DE: Code für Tadalafil.<br>
     * FR: Code de tadalafil.<br>
     * IT: Code per Tadalafil.<br>
     */
    public static final String TADALAFIL_CODE = "407111005";

    /**
     * EN: Code for Tafluprost.<br>
     * DE: Code für Tafluprost.<br>
     * FR: Code de tafluprost.<br>
     * IT: Code per Tafluprost.<br>
     */
    public static final String TAFLUPROST_CODE = "699181001";

    /**
     * EN: Code for Tamoxifen.<br>
     * DE: Code für Tamoxifen.<br>
     * FR: Code de tamoxifène.<br>
     * IT: Code per Tamoxifene.<br>
     */
    public static final String TAMOXIFEN_CODE = "373345002";

    /**
     * EN: Code for Tamsulosin.<br>
     * DE: Code für Tamsulosin.<br>
     * FR: Code de tamsulosine.<br>
     * IT: Code per Tamsulosina.<br>
     */
    public static final String TAMSULOSIN_CODE = "372509005";

    /**
     * EN: Code for Tapentadol.<br>
     * DE: Code für Tapentadol.<br>
     * FR: Code de tapentadol.<br>
     * IT: Code per Tapentadolo.<br>
     */
    public static final String TAPENTADOL_CODE = "441757005";

    /**
     * EN: Code for Taurine.<br>
     * DE: Code für Taurin.<br>
     * FR: Code de taurine.<br>
     * IT: Code per Taurina.<br>
     */
    public static final String TAURINE_CODE = "10944007";

    /**
     * EN: Code for Tazobactam.<br>
     * DE: Code für Tazobactam.<br>
     * FR: Code de tazobactam.<br>
     * IT: Code per Tazobactam.<br>
     */
    public static final String TAZOBACTAM_CODE = "96007008";

    /**
     * EN: Code for Teicoplanin.<br>
     * DE: Code für Teicoplanin.<br>
     * FR: Code de téicoplanine.<br>
     * IT: Code per Teicoplanina.<br>
     */
    public static final String TEICOPLANIN_CODE = "387529008";

    /**
     * EN: Code for Telmisartan.<br>
     * DE: Code für Telmisartan.<br>
     * FR: Code de telmisartan.<br>
     * IT: Code per Telmisartan.<br>
     */
    public static final String TELMISARTAN_CODE = "387069000";

    /**
     * EN: Code for Temazepam.<br>
     * DE: Code für Temazepam.<br>
     * FR: Code de témazépam.<br>
     * IT: Code per Temazepam.<br>
     */
    public static final String TEMAZEPAM_CODE = "387300007";

    /**
     * EN: Code for Temozolomide.<br>
     * DE: Code für Temozolomid.<br>
     * FR: Code de témozolomide.<br>
     * IT: Code per Temozolomide.<br>
     */
    public static final String TEMOZOLOMIDE_CODE = "387009002";

    /**
     * EN: Code for Tenofovir.<br>
     * DE: Code für Tenofovir.<br>
     * FR: Code de ténofovir.<br>
     * IT: Code per Tenofovir.<br>
     */
    public static final String TENOFOVIR_CODE = "422091007";

    /**
     * EN: Code for Terbinafine.<br>
     * DE: Code für Terbinafin.<br>
     * FR: Code de terbinafine.<br>
     * IT: Code per Terbinafina.<br>
     */
    public static final String TERBINAFINE_CODE = "373450007";

    /**
     * EN: Code for Terbutaline sulfate.<br>
     * DE: Code für Terbutalin sulfat.<br>
     * FR: Code de terbutaline sulfate.<br>
     * IT: Code per Terbutalina.<br>
     */
    public static final String TERBUTALINE_SULFATE_CODE = "24583009";

    /**
     * EN: Code for Teriparatide.<br>
     * DE: Code für Teriparatid.<br>
     * FR: Code de tériparatide.<br>
     * IT: Code per Teriparatide.<br>
     */
    public static final String TERIPARATIDE_CODE = "425438001";

    /**
     * EN: Code for Terlipressin.<br>
     * DE: Code für Terlipressin.<br>
     * FR: Code de terlipressine.<br>
     * IT: Code per Terlipressina.<br>
     */
    public static final String TERLIPRESSIN_CODE = "395899009";

    /**
     * EN: Code for Testosterone.<br>
     * DE: Code für Testosteron.<br>
     * FR: Code de testostérone.<br>
     * IT: Code per Testosterone.<br>
     */
    public static final String TESTOSTERONE_CODE = "43688007";

    /**
     * EN: Code for Tetanus immunoglobulin of human origin.<br>
     * DE: Code für Tetanus-Immunglobulin vom Menschen.<br>
     * FR: Code de immunoglobuline humaine anti-tétanique.<br>
     * IT: Code per Immunoglobulina umana antitetanica.<br>
     */
    public static final String TETANUS_IMMUNOGLOBULIN_OF_HUMAN_ORIGIN_CODE = "428527002";

    /**
     * EN: Code for Tetracaine.<br>
     * DE: Code für Tetracain.<br>
     * FR: Code de tétracaïne.<br>
     * IT: Code per Tetracaina.<br>
     */
    public static final String TETRACAINE_CODE = "387309008";

    /**
     * EN: Code for Tetracosactide.<br>
     * DE: Code für Tetracosactid.<br>
     * FR: Code de tétracosactide.<br>
     * IT: Code per Tetracosactide.<br>
     */
    public static final String TETRACOSACTIDE_CODE = "96363002";

    /**
     * EN: Code for Tetracycline.<br>
     * DE: Code für Tetracyclin.<br>
     * FR: Code de tétracycline.<br>
     * IT: Code per Tetraciclina.<br>
     */
    public static final String TETRACYCLINE_CODE = "372809001";

    /**
     * EN: Code for Tetryzoline.<br>
     * DE: Code für Tetryzolin.<br>
     * FR: Code de tétryzoline.<br>
     * IT: Code per Tetrizolina.<br>
     */
    public static final String TETRYZOLINE_CODE = "372673004";

    /**
     * EN: Code for Theophylline.<br>
     * DE: Code für Theophyllin.<br>
     * FR: Code de théophylline.<br>
     * IT: Code per Teofillina.<br>
     */
    public static final String THEOPHYLLINE_CODE = "372810006";

    /**
     * EN: Code for Thiamine.<br>
     * DE: Code für Thiamin (Vitamin B1).<br>
     * FR: Code de thiamine (Vitamine B1).<br>
     * IT: Code per Tiamina (vitamina B1).<br>
     */
    public static final String THIAMINE_CODE = "259659006";

    /**
     * EN: Code for Thiotepa.<br>
     * DE: Code für Thiotepa.<br>
     * FR: Code de thiotépa.<br>
     * IT: Code per Tiotepa.<br>
     */
    public static final String THIOTEPA_CODE = "387508004";

    /**
     * EN: Code for Threonine.<br>
     * DE: Code für Threonin.<br>
     * FR: Code de thréonine.<br>
     * IT: Code per Treonina.<br>
     */
    public static final String THREONINE_CODE = "52736009";

    /**
     * EN: Code for Tiapride.<br>
     * DE: Code für Tiaprid.<br>
     * FR: Code de tiapride.<br>
     * IT: Code per Tiapride.<br>
     */
    public static final String TIAPRIDE_CODE = "699180000";

    /**
     * EN: Code for Tibolone.<br>
     * DE: Code für Tibolon.<br>
     * FR: Code de tibolone.<br>
     * IT: Code per Tibolone.<br>
     */
    public static final String TIBOLONE_CODE = "395903002";

    /**
     * EN: Code for Ticagrelor.<br>
     * DE: Code für Ticagrelor.<br>
     * FR: Code de ticagrélor.<br>
     * IT: Code per Ticagrelor.<br>
     */
    public static final String TICAGRELOR_CODE = "698805004";

    /**
     * EN: Code for Tigecycline.<br>
     * DE: Code für Tigecyclin.<br>
     * FR: Code de tigécycline.<br>
     * IT: Code per Tigeciclina.<br>
     */
    public static final String TIGECYCLINE_CODE = "418313005";

    /**
     * EN: Code for Tilidine hydrochloride.<br>
     * DE: Code für Tilidin hydrochlorid.<br>
     * FR: Code de tilidine chlorhydrate.<br>
     * IT: Code per Tilidina cloridrato.<br>
     */
    public static final String TILIDINE_HYDROCHLORIDE_CODE = "96186004";

    /**
     * EN: Code for Timolol.<br>
     * DE: Code für Timolol.<br>
     * FR: Code de timolol.<br>
     * IT: Code per Timololo.<br>
     */
    public static final String TIMOLOL_CODE = "372880004";

    /**
     * EN: Code for Tioguanine.<br>
     * DE: Code für Tioguanin.<br>
     * FR: Code de tioguanine.<br>
     * IT: Code per Tioguanina.<br>
     */
    public static final String TIOGUANINE_CODE = "387407006";

    /**
     * EN: Code for Tiotropium.<br>
     * DE: Code für Tiotropium.<br>
     * FR: Code de tiotropium.<br>
     * IT: Code per Tiotropio.<br>
     */
    public static final String TIOTROPIUM_CODE = "409169006";

    /**
     * EN: Code for Tipranavir.<br>
     * DE: Code für Tipranavir.<br>
     * FR: Code de tipranavir.<br>
     * IT: Code per Tipranavir.<br>
     */
    public static final String TIPRANAVIR_CODE = "419409009";

    /**
     * EN: Code for Tizanidine.<br>
     * DE: Code für Tizanidin.<br>
     * FR: Code de tizanidine.<br>
     * IT: Code per Tizanidina.<br>
     */
    public static final String TIZANIDINE_CODE = "373440006";

    /**
     * EN: Code for Tobramycine.<br>
     * DE: Code für Tobramycin.<br>
     * FR: Code de tobramycine.<br>
     * IT: Code per Tobramicina.<br>
     */
    public static final String TOBRAMYCINE_CODE = "373548001";

    /**
     * EN: Code for Tocilizumab.<br>
     * DE: Code für Tocilizumab.<br>
     * FR: Code de tocilizumab.<br>
     * IT: Code per Tocilizumab.<br>
     */
    public static final String TOCILIZUMAB_CODE = "444648007";

    /**
     * EN: Code for Tolcapone.<br>
     * DE: Code für Tolcapon.<br>
     * FR: Code de tolcapone.<br>
     * IT: Code per Tolcapone.<br>
     */
    public static final String TOLCAPONE_CODE = "386851002";

    /**
     * EN: Code for Tolperisone.<br>
     * DE: Code für Tolperison.<br>
     * FR: Code de tolpérisone.<br>
     * IT: Code per Tolperisone.<br>
     */
    public static final String TOLPERISONE_CODE = "703717006";

    /**
     * EN: Code for Tolterodine.<br>
     * DE: Code für Tolterodin.<br>
     * FR: Code de toltérodine.<br>
     * IT: Code per Tolterodina.<br>
     */
    public static final String TOLTERODINE_CODE = "372570008";

    /**
     * EN: Code for Tolvaptan.<br>
     * DE: Code für Tolvaptan.<br>
     * FR: Code de tolvaptan.<br>
     * IT: Code per Tolvaptan.<br>
     */
    public static final String TOLVAPTAN_CODE = "443058000";

    /**
     * EN: Code for Topiramate.<br>
     * DE: Code für Topiramat.<br>
     * FR: Code de topiramate.<br>
     * IT: Code per Topiramato.<br>
     */
    public static final String TOPIRAMATE_CODE = "386844006";

    /**
     * EN: Code for Topotecan.<br>
     * DE: Code für Topotecan.<br>
     * FR: Code de topotécan.<br>
     * IT: Code per Topotecan.<br>
     */
    public static final String TOPOTECAN_CODE = "372536007";

    /**
     * EN: Code for Torasemide.<br>
     * DE: Code für Torasemid.<br>
     * FR: Code de torasémide.<br>
     * IT: Code per Torasemide.<br>
     */
    public static final String TORASEMIDE_CODE = "108476002";

    /**
     * EN: Code for Trabectedin.<br>
     * DE: Code für Trabectedin.<br>
     * FR: Code de trabectédine.<br>
     * IT: Code per Trabectedina.<br>
     */
    public static final String TRABECTEDIN_CODE = "433127001";

    /**
     * EN: Code for Tramadol.<br>
     * DE: Code für Tramadol.<br>
     * FR: Code de tramadol.<br>
     * IT: Code per Tramadol.<br>
     */
    public static final String TRAMADOL_CODE = "386858008";

    /**
     * EN: Code for Trametinib.<br>
     * DE: Code für Trametinib.<br>
     * FR: Code de tramétinib.<br>
     * IT: Code per Trametinib.<br>
     */
    public static final String TRAMETINIB_CODE = "708711009";

    /**
     * EN: Code for Trandolapril.<br>
     * DE: Code für Trandolapril.<br>
     * FR: Code de trandolapril.<br>
     * IT: Code per Trandolapril.<br>
     */
    public static final String TRANDOLAPRIL_CODE = "386871006";

    /**
     * EN: Code for Tranexamic acid.<br>
     * DE: Code für Tranexamsäure.<br>
     * FR: Code de acide tranexamique.<br>
     * IT: Code per Acido tranexamico.<br>
     */
    public static final String TRANEXAMIC_ACID_CODE = "386960009";

    /**
     * EN: Code for Tranylcypromine.<br>
     * DE: Code für Tranylcypromin.<br>
     * FR: Code de tranylcypromine.<br>
     * IT: Code per Tranilcipromina.<br>
     */
    public static final String TRANYLCYPROMINE_CODE = "372891006";

    /**
     * EN: Code for Trastuzumab.<br>
     * DE: Code für Trastuzumab.<br>
     * FR: Code de trastuzumab.<br>
     * IT: Code per Trastuzumab.<br>
     */
    public static final String TRASTUZUMAB_CODE = "387003001";

    /**
     * EN: Code for Travoprost.<br>
     * DE: Code für Travoprost.<br>
     * FR: Code de travoprost.<br>
     * IT: Code per Travoprost.<br>
     */
    public static final String TRAVOPROST_CODE = "129493000";

    /**
     * EN: Code for Trazodone.<br>
     * DE: Code für Trazodon.<br>
     * FR: Code de trazodone.<br>
     * IT: Code per Trazodone.<br>
     */
    public static final String TRAZODONE_CODE = "372829000";

    /**
     * EN: Code for Treprostinil.<br>
     * DE: Code für Treprostinil.<br>
     * FR: Code de tréprostinil.<br>
     * IT: Code per Treprostinil.<br>
     */
    public static final String TREPROSTINIL_CODE = "443570007";

    /**
     * EN: Code for Tretinoin.<br>
     * DE: Code für Tretinoin.<br>
     * FR: Code de trétinoïne.<br>
     * IT: Code per Tretinoina.<br>
     */
    public static final String TRETINOIN_CODE = "387305002";

    /**
     * EN: Code for Triacylglycerol lipase.<br>
     * DE: Code für Lipase.<br>
     * FR: Code de lipase.<br>
     * IT: Code per Lipasi.<br>
     */
    public static final String TRIACYLGLYCEROL_LIPASE_CODE = "72993008";

    /**
     * EN: Code for Triamcinolone.<br>
     * DE: Code für Triamcinolon.<br>
     * FR: Code de triamcinolone.<br>
     * IT: Code per Triamcinolone.<br>
     */
    public static final String TRIAMCINOLONE_CODE = "116594009";

    /**
     * EN: Code for Triamcinolone acetonide.<br>
     * DE: Code für Triamcinolon acetonid.<br>
     * FR: Code de triamcinolone acétonide.<br>
     * IT: Code per Triamcinolone acetonide.<br>
     */
    public static final String TRIAMCINOLONE_ACETONIDE_CODE = "395913005";

    /**
     * EN: Code for Triazolam.<br>
     * DE: Code für Triazolam.<br>
     * FR: Code de triazolam.<br>
     * IT: Code per Triazolam.<br>
     */
    public static final String TRIAZOLAM_CODE = "386984001";

    /**
     * EN: Code for Triclosan.<br>
     * DE: Code für Triclosan.<br>
     * FR: Code de triclosan.<br>
     * IT: Code per Triclosan.<br>
     */
    public static final String TRICLOSAN_CODE = "387054001";

    /**
     * EN: Code for Trimethoprim.<br>
     * DE: Code für Trimethoprim.<br>
     * FR: Code de triméthoprime.<br>
     * IT: Code per Trimetoprim.<br>
     */
    public static final String TRIMETHOPRIM_CODE = "387179001";

    /**
     * EN: Code for Trimipramine.<br>
     * DE: Code für Trimipramin.<br>
     * FR: Code de trimipramine.<br>
     * IT: Code per Trimipramina.<br>
     */
    public static final String TRIMIPRAMINE_CODE = "373550009";

    /**
     * EN: Code for Triptorelin.<br>
     * DE: Code für Triptorelin.<br>
     * FR: Code de triptoréline.<br>
     * IT: Code per Triptorelina.<br>
     */
    public static final String TRIPTORELIN_CODE = "395915003";

    /**
     * EN: Code for Trofosfamide.<br>
     * DE: Code für Trofosfamide.<br>
     * FR: Code de trofosfamide.<br>
     * IT: Code per trofosfamide.<br>
     */
    public static final String TROFOSFAMIDE_CODE = "1156222009";

    /**
     * EN: Code for Tropicamide.<br>
     * DE: Code für Tropicamid.<br>
     * FR: Code de tropicamide.<br>
     * IT: Code per Tropicamide.<br>
     */
    public static final String TROPICAMIDE_CODE = "387526001";

    /**
     * EN: Code for Trospium chloride.<br>
     * DE: Code für Trospium chlorid.<br>
     * FR: Code de trospium chlorure.<br>
     * IT: Code per Trospio cloruro.<br>
     */
    public static final String TROSPIUM_CHLORIDE_CODE = "326557004";

    /**
     * EN: Code for Tryptophan.<br>
     * DE: Code für Tryptophan.<br>
     * FR: Code de tryptophane.<br>
     * IT: Code per Triptofano.<br>
     */
    public static final String TRYPTOPHAN_CODE = "54821000";

    /**
     * EN: Code for Tuberculin purified protein derivative.<br>
     * DE: Code für Tuberkulin, gereinigtes PPD.<br>
     * FR: Code de tuberculine dérivé protéinique purifié.<br>
     * IT: Code per Tubercolina derivato proteico purificato (PPD).<br>
     */
    public static final String TUBERCULIN_PURIFIED_PROTEIN_DERIVATIVE_CODE = "108731003";

    /**
     * EN: Code for Turoctocog alfa.<br>
     * DE: Code für Turoctocog alfa.<br>
     * FR: Code de turoctocog alfa.<br>
     * IT: Code per Turoctocog alfa.<br>
     */
    public static final String TUROCTOCOG_ALFA_CODE = "735055007";

    /**
     * EN: Code for Tyrosine.<br>
     * DE: Code für Tyrosin.<br>
     * FR: Code de tyrosine.<br>
     * IT: Code per Tirosina.<br>
     */
    public static final String TYROSINE_CODE = "27378009";

    /**
     * EN: Code for Tyrothricin.<br>
     * DE: Code für Tyrothricin.<br>
     * FR: Code de tyrothricine.<br>
     * IT: Code per Tirotricina.<br>
     */
    public static final String TYROTHRICIN_CODE = "36661005";

    /**
     * EN: Code for Ulipristal.<br>
     * DE: Code für Ulipristal.<br>
     * FR: Code de ulipristal.<br>
     * IT: Code per Ulipristal.<br>
     */
    public static final String ULIPRISTAL_CODE = "703249005";

    /**
     * EN: Code for Umeclidinium.<br>
     * DE: Code für Umeclidinium.<br>
     * FR: Code de uméclidinium.<br>
     * IT: Code per Umeclidinio.<br>
     */
    public static final String UMECLIDINIUM_CODE = "706898002";

    /**
     * EN: Code for Urapidil.<br>
     * DE: Code für Urapidil.<br>
     * FR: Code de urapidil.<br>
     * IT: Code per Urapidil.<br>
     */
    public static final String URAPIDIL_CODE = "698807007";

    /**
     * EN: Code for Urokinase.<br>
     * DE: Code für Urokinase.<br>
     * FR: Code de urokinase.<br>
     * IT: Code per Urochinasi.<br>
     */
    public static final String UROKINASE_CODE = "59082006";

    /**
     * EN: Code for Ursodeoxycholic acid.<br>
     * DE: Code für Ursodeoxycholsäure.<br>
     * FR: Code de acide ursodésoxycholique.<br>
     * IT: Code per Acido ursodesossicolico.<br>
     */
    public static final String URSODEOXYCHOLIC_ACID_CODE = "41143004";

    /**
     * EN: Code for Ustekinumab.<br>
     * DE: Code für Ustekinumab.<br>
     * FR: Code de ustékinumab.<br>
     * IT: Code per Ustekinumab.<br>
     */
    public static final String USTEKINUMAB_CODE = "443465002";

    /**
     * EN: Code for Valaciclovir.<br>
     * DE: Code für Valaciclovir.<br>
     * FR: Code de valaciclovir.<br>
     * IT: Code per Valaciclovir.<br>
     */
    public static final String VALACICLOVIR_CODE = "96098007";

    /**
     * EN: Code for Valerian extract.<br>
     * DE: Code für Baldrianwurzel-Extrakt.<br>
     * FR: Code de valériane extrait.<br>
     * IT: Code per Valeriana estratto.<br>
     */
    public static final String VALERIAN_EXTRACT_CODE = "412266000";

    /**
     * EN: Code for Valganciclovir.<br>
     * DE: Code für Valganciclovir.<br>
     * FR: Code de valganciclovir.<br>
     * IT: Code per Valganciclovit.<br>
     */
    public static final String VALGANCICLOVIR_CODE = "129476000";

    /**
     * EN: Code for Valine.<br>
     * DE: Code für Valin.<br>
     * FR: Code de valine.<br>
     * IT: Code per Valina.<br>
     */
    public static final String VALINE_CODE = "72840006";

    /**
     * EN: Code for Valproate semisodium.<br>
     * DE: Code für Valproat seminatrium.<br>
     * FR: Code de valproate semisodique.<br>
     * IT: Code per Valproato semisodico.<br>
     */
    public static final String VALPROATE_SEMISODIUM_CODE = "5641004";

    /**
     * EN: Code for Valproate sodium.<br>
     * DE: Code für Valproat natrium.<br>
     * FR: Code de valproate sodique.<br>
     * IT: Code per Valproato sodico.<br>
     */
    public static final String VALPROATE_SODIUM_CODE = "387481005";

    /**
     * EN: Code for Valproic acid.<br>
     * DE: Code für Valproinsäure.<br>
     * FR: Code de acide valproïque.<br>
     * IT: Code per Acido valproico.<br>
     */
    public static final String VALPROIC_ACID_CODE = "387080000";

    /**
     * EN: Code for Valsartan.<br>
     * DE: Code für Valsartan.<br>
     * FR: Code de valsartan.<br>
     * IT: Code per Valsartan.<br>
     */
    public static final String VALSARTAN_CODE = "386876001";

    /**
     * EN: Code for Vancomycin.<br>
     * DE: Code für Vancomycin.<br>
     * FR: Code de vancomycine.<br>
     * IT: Code per Vancomicina.<br>
     */
    public static final String VANCOMYCIN_CODE = "372735009";

    /**
     * EN: Code for Vardenafil.<br>
     * DE: Code für Vardenafil.<br>
     * FR: Code de vardénafil.<br>
     * IT: Code per Vardenafil.<br>
     */
    public static final String VARDENAFIL_CODE = "404858007";

    /**
     * EN: Code for Varenicline.<br>
     * DE: Code für Vareniclin.<br>
     * FR: Code de varénicline.<br>
     * IT: Code per Vareniclina.<br>
     */
    public static final String VARENICLINE_CODE = "421772003";

    /**
     * EN: Code for Varicella-zoster virus antibody.<br>
     * DE: Code für Varizellen-Immunglobulin vom Menschen.<br>
     * FR: Code de immunoglobuline humaine antivaricelle.<br>
     * IT: Code per Immunoglobulina umana antivaricella.<br>
     */
    public static final String VARICELLA_ZOSTER_VIRUS_ANTIBODY_CODE = "259858000";

    /**
     * EN: Code for Vecuronium bromide.<br>
     * DE: Code für Vecuronium bromid.<br>
     * FR: Code de vécuronium bromure.<br>
     * IT: Code per Vecuronio bromuro.<br>
     */
    public static final String VECURONIUM_BROMIDE_CODE = "87472002";

    /**
     * EN: Code for Vedolizumab.<br>
     * DE: Code für Vedolizumab.<br>
     * FR: Code de védolizumab.<br>
     * IT: Code per Vedolizumab.<br>
     */
    public static final String VEDOLIZUMAB_CODE = "704256006";

    /**
     * EN: Code for Venlafaxine.<br>
     * DE: Code für Venlafaxin.<br>
     * FR: Code de venlafaxine.<br>
     * IT: Code per Venlafaxina.<br>
     */
    public static final String VENLAFAXINE_CODE = "372490001";

    /**
     * EN: Code for Verapamil.<br>
     * DE: Code für Verapamil.<br>
     * FR: Code de vérapamil.<br>
     * IT: Code per Verapamil.<br>
     */
    public static final String VERAPAMIL_CODE = "372754009";

    /**
     * EN: Code for Vigabatrin.<br>
     * DE: Code für Vigabatrin.<br>
     * FR: Code de vigabatrine.<br>
     * IT: Code per Vigabatrin.<br>
     */
    public static final String VIGABATRIN_CODE = "310283001";

    /**
     * EN: Code for Vilanterol.<br>
     * DE: Code für Vilanterol.<br>
     * FR: Code de vilantérol.<br>
     * IT: Code per Vilanterolo.<br>
     */
    public static final String VILANTEROL_CODE = "702408004";

    /**
     * EN: Code for Vildagliptin.<br>
     * DE: Code für Vildagliptin.<br>
     * FR: Code de vildagliptine.<br>
     * IT: Code per Vildagliptin.<br>
     */
    public static final String VILDAGLIPTIN_CODE = "428611002";

    /**
     * EN: Code for Vinblastine.<br>
     * DE: Code für Vinblastin.<br>
     * FR: Code de vinblastine.<br>
     * IT: Code per Vinblastina.<br>
     */
    public static final String VINBLASTINE_CODE = "387051009";

    /**
     * EN: Code for Vincristine.<br>
     * DE: Code für Vincristin.<br>
     * FR: Code de vincristine.<br>
     * IT: Code per Vincristina.<br>
     */
    public static final String VINCRISTINE_CODE = "387126006";

    /**
     * EN: Code for Vindesine.<br>
     * DE: Code für Vindesin.<br>
     * FR: Code de vindésine.<br>
     * IT: Code per Vindesina.<br>
     */
    public static final String VINDESINE_CODE = "409198005";

    /**
     * EN: Code for Vinorelbine.<br>
     * DE: Code für Vinorelbin.<br>
     * FR: Code de vinorelbine.<br>
     * IT: Code per Vinorelbina.<br>
     */
    public static final String VINORELBINE_CODE = "372541004";

    /**
     * EN: Code for Vitamin E.<br>
     * DE: Code für Tocopherol DL-alpha (E307).<br>
     * FR: Code de tocophérol DL-alfa (E307).<br>
     * IT: Code per Alfa-Tocoferolo (vitamina E, E307).<br>
     */
    public static final String VITAMIN_E_CODE = "37237003";

    /**
     * EN: Code for Voriconazole.<br>
     * DE: Code für Voriconazol.<br>
     * FR: Code de voriconazole.<br>
     * IT: Code per Voriconazolo.<br>
     */
    public static final String VORICONAZOLE_CODE = "385469007";

    /**
     * EN: Code for Vortioxetine.<br>
     * DE: Code für Vortioxetin.<br>
     * FR: Code de vortioxétine.<br>
     * IT: Code per Vortioxetina.<br>
     */
    public static final String VORTIOXETINE_CODE = "708717008";

    /**
     * EN: Code for Warfarin.<br>
     * DE: Code für Warfarin.<br>
     * FR: Code de warfarine.<br>
     * IT: Code per Warfarin.<br>
     */
    public static final String WARFARIN_CODE = "372756006";

    /**
     * EN: Code for Xylometazoline.<br>
     * DE: Code für Xylometazolin.<br>
     * FR: Code de xylométazoline.<br>
     * IT: Code per Xilometazolina.<br>
     */
    public static final String XYLOMETAZOLINE_CODE = "372841007";

    /**
     * EN: Code for Zanamivir.<br>
     * DE: Code für Zanamivir.<br>
     * FR: Code de zanamivir.<br>
     * IT: Code per Zanamivir.<br>
     */
    public static final String ZANAMIVIR_CODE = "387010007";

    /**
     * EN: Code for Zidovudine.<br>
     * DE: Code für Zidovudin.<br>
     * FR: Code de zidovudine.<br>
     * IT: Code per Zidovudina.<br>
     */
    public static final String ZIDOVUDINE_CODE = "387151007";

    /**
     * EN: Code for Zinc acetate dihydrate.<br>
     * DE: Code für Zinkdiacetat-2-Wasser.<br>
     * FR: Code de zinc acétate dihydrate.<br>
     * IT: Code per Zinco acetato diidrato.<br>
     */
    public static final String ZINC_ACETATE_DIHYDRATE_CODE = "725761005";

    /**
     * EN: Code for Zinc pyrithione.<br>
     * DE: Code für Pyrithion zink.<br>
     * FR: Code de pyrithione zinc.<br>
     * IT: Code per Zinco piritione.<br>
     */
    public static final String ZINC_PYRITHIONE_CODE = "255954005";

    /**
     * EN: Code for Zoledronic acid.<br>
     * DE: Code für Zoledronsäure.<br>
     * FR: Code de acide zolédronique (zolédronate).<br>
     * IT: Code per Acido zoledronico.<br>
     */
    public static final String ZOLEDRONIC_ACID_CODE = "395926009";

    /**
     * EN: Code for Zolmitriptan.<br>
     * DE: Code für Zolmitriptan.<br>
     * FR: Code de zolmitriptan.<br>
     * IT: Code per Zolmitriptan.<br>
     */
    public static final String ZOLMITRIPTAN_CODE = "363582006";

    /**
     * EN: Code for Zolpidem.<br>
     * DE: Code für Zolpidem.<br>
     * FR: Code de zolpidem.<br>
     * IT: Code per Zolpidem.<br>
     */
    public static final String ZOLPIDEM_CODE = "387569009";

    /**
     * EN: Code for Zonisamide.<br>
     * DE: Code für Zonisamid.<br>
     * FR: Code de zonisamide.<br>
     * IT: Code per Zonisamide.<br>
     */
    public static final String ZONISAMIDE_CODE = "125693002";

    /**
     * EN: Code for Zopiclone.<br>
     * DE: Code für Zopiclon.<br>
     * FR: Code de zopiclone.<br>
     * IT: Code per Zopiclone.<br>
     */
    public static final String ZOPICLONE_CODE = "395929002";

    /**
     * EN: Code for Zuclopenthixol.<br>
     * DE: Code für Zuclopenthixol.<br>
     * FR: Code de zuclopenthixol.<br>
     * IT: Code per Zuclopentixolo.<br>
     */
    public static final String ZUCLOPENTHIXOL_CODE = "428715002";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.1.11.82";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "ActivePharmaceuticalIngredient";

    /**
     * Identifier of the code system (all values share the same).
     */
    public static final String CODE_SYSTEM_ID = "http://snomed.info/sct";

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
    ActivePharmaceuticalIngredient(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
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

    /**
     * Returns the code system, as used in FHIR.
     */
    @Override
    @NonNull
    public String getFhirSystem() {
        if (this.getCodeSystemId().startsWith("http")) {
            return this.getCodeSystemId();
        }
        return Oids.PREFIX_OID + this.getCodeSystemId();
    }

    /**
     * Returns the enum value as a FHIR Coding.
     */
    @Override
    @NonNull
    public Coding getCoding() {
        return new Coding(this.getFhirSystem(),
                          this.getCodeValue(),
                          this.displayNames[0]);
    }

    /**
     * Returns the enum value as a FHIR CodeableConcept.
     */
    @Override
    @NonNull
    public CodeableConcept getCodeableConcept() {
        return new CodeableConcept().setText(this.displayNames[0]).addCoding(this.getCoding());
    }

    /**
     * Compares the enum value to the given FHIR Coding.
     *
     * @param coding The FHIR Coding to be compared.
     * @return {@code true} if they have the same system and value, {@code false} otherwise.
     */
    @Override
    public boolean isEqualTo(final Coding coding) {
        return this.getFhirSystem().equals(coding.getSystem()) && this.getCodeValue().equals(coding.getCode());
    }

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ActivePharmaceuticalIngredient getEnum(@Nullable final String code) {
        for (final ActivePharmaceuticalIngredient x : values()) {
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
            Enum.valueOf(ActivePharmaceuticalIngredient.class,
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
        for (final ActivePharmaceuticalIngredient x : values()) {
            if (x.getCodeValue().equals(codeValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the Enum with a given FHIR Coding.
     *
     * @param coding The FHIR Coding.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ActivePharmaceuticalIngredient getEnum(@Nullable final Coding coding) {
        for (final var x : values()) {
            if (x.isEqualTo(coding)) {
                return x;
            }
        }
        return null;
    }

    /**
     * Checks if a given FHIR Coding is in this value set.
     *
     * @param coding The FHIR Coding.
     * @return {@code true} if the value is found in this value set, {@code false} otherwise.
     */
    public static boolean isInValueSet(@Nullable final Coding coding) {
        for (final var x : values()) {
            if (x.isEqualTo(coding)) {
                return true;
            }
        }
        return false;
    }
}
