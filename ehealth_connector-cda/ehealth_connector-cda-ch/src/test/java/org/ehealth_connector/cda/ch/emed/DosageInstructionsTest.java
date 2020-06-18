package org.ehealth_connector.cda.ch.emed;

import org.apache.commons.lang3.StringUtils;
import org.ehealth_connector.cda.ch.emed.v096.DosageInstructionsEntryDosageChange;
import org.ehealth_connector.cda.ch.emed.v096.DosageInstructionsStartStopFrequency;
import org.ehealth_connector.cda.ch.emed.v096.MedicationTreatmenPlanSectionContentModule;
import org.ehealth_connector.cda.ch.emed.v096.enums.ChEmedTimingEvent;
import org.ehealth_connector.cda.ch.enums.UnitsOfTime;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.hl7cdar2.*;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <div class="en">Test dosage instruction formating</div>
 */
public class DosageInstructionsTest {
    //for create new objects
    ObjectFactory factory = new ObjectFactory();



    /**
     * Test date formating
     */
    @Test
    public void parseTsTest() {
        TS ts = DateUtil.date2Ts(DateUtil.parseDateAndTime("20.6.2020 10:50"));
        String dateFR = EmedChStrucDocTextBuilder096.parseTs(LanguageCode.FRENCH, ts);
        String dateDE = EmedChStrucDocTextBuilder096.parseTs(LanguageCode.GERMAN, ts);
        String dateIT = EmedChStrucDocTextBuilder096.parseTs(LanguageCode.ITALIAN, ts);
        String dateEN = EmedChStrucDocTextBuilder096.parseTs(LanguageCode.ENGLISH, ts);
        assertEquals(dateFR, "20 juin 2020 10:50");
        assertEquals(dateDE, "20 Juni 2020 10:50");
        assertEquals(dateIT, "20 giugno 2020 10:50");
        assertEquals(dateEN, "20 June 2020 10:50");
    }

    /**
     * Test eivlts
     */
    @Test
    public void parseEivltsTest() {
        EIVLTS eivltsWithOffset = createAcmWithOffset();
        String eivltsWithOffsetText = EmedChStrucDocTextBuilder096.parseEivlTs(LanguageCode.ENGLISH, eivltsWithOffset);
        String eivltsWithOffsetTextFrench = EmedChStrucDocTextBuilder096.parseEivlTs(LanguageCode.FRENCH, eivltsWithOffset);
        String eivltsWithOffsetTextGerman = EmedChStrucDocTextBuilder096.parseEivlTs(LanguageCode.GERMAN, eivltsWithOffset);
        String eivltsWithOffsetTextItalian = EmedChStrucDocTextBuilder096.parseEivlTs(LanguageCode.ITALIAN, eivltsWithOffset);
        assertEquals("1 hour(s) - 2 hour(s) Before breakfast during 1 hour(s)", eivltsWithOffsetText);
        assertEquals("1 Stunde(n) - 2 Stunde(n) Vor dem Frühstück während 1 Stunde(n)", eivltsWithOffsetTextGerman);

        assertEquals("1 heure(s) - 2 heure(s) Avant le petit-déjeuner pendant 1 heure(s)", eivltsWithOffsetTextFrench);
        assertEquals("1 ora(e) - 2 ora(e) Prima di colazione durante 1 ora(e)", eivltsWithOffsetTextItalian);
        EIVLTS eivltsAcm = createAcm();
        assertEquals("Before breakfast", EmedChStrucDocTextBuilder096.parseEivlTs(LanguageCode.ENGLISH, eivltsAcm));
        assertEquals("Avant le petit-déjeuner", EmedChStrucDocTextBuilder096.parseEivlTs(LanguageCode.FRENCH, eivltsAcm));
    }

    /**
     * Test pivlts
     */
    @Test
    public void parsePivltsTest() {
        /*
                            <effectiveTime xsi:type="PIVL_TS" institutionSpecified="true" operator="A" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                                <period value="2" unit="h"/>
                            </effectiveTime>
         */
        PIVLTS pivltsFrequency = createPivl(true);
        /*

                            <effectiveTime xsi:type="PIVL_TS" institutionSpecified="false" operator="A" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                                <period value="2" unit="h"/>
                            </effectiveTime>
         */
        PIVLTS pivltsPeriod = createPivl(false);
        String pivltsFrequencyStr = EmedChStrucDocTextBuilder096.parsePivlTs(LanguageCode.ENGLISH, pivltsFrequency);


        PIVLTS pivltsWithPhase = createPivlWithPhase();
        System.out.println(DateUtil.parseHl7Timestamp("198701010800").toString());
        printDoc(pivltsWithPhase);
        assertEquals("12x per day(s)", pivltsFrequencyStr);

        assertEquals("chaque 2 heure(s)", EmedChStrucDocTextBuilder096.parsePivlTs(LanguageCode.FRENCH, pivltsPeriod));

        assertEquals("chaque 1 jour(s) à 10:50 pendant 10 minute(s)", EmedChStrucDocTextBuilder096.parsePivlTs(LanguageCode.FRENCH, pivltsWithPhase));

        createPivl(pivltsFrequency);
        createPivl(pivltsPeriod);
    }

    /**
     * Test sxprts
     */
    @Test
    public void parseSXPRtsTest() {
        ObjectFactory objectFactory = new ObjectFactory();
        SXPRTS sxprts = objectFactory.createSXPRTS();
        sxprts.getComp().add( createHl7CdaR2IvlTs(DateUtil.formatDateTime(DateUtil.parseDateAndTime("20.6.2020 10:50")),null,"10","d"));
        sxprts.getComp().add(createAcm());
        sxprts.getComp().add(createEIVLTS(ChEmedTimingEvent.AFTER_BREAKFAST));
        sxprts.getComp().add(createEIVLTS(ChEmedTimingEvent.BETWEEN_LUNCH_AND_DINNER));
        sxprts.getComp().add(createEIVLTS(ChEmedTimingEvent.AFTER_DINNER));

        assertEquals("du 20 juin 2020 10:50 pendant 10 jour(s): Avant le petit-déjeuner et Après le petit-déjeuner et Entre le repas de midi et du soir et Après le repas du soir", EmedChStrucDocTextBuilder096.parseSxprTs(LanguageCode.FRENCH,sxprts));
    }

    /**
     * Test splited Dosage
     */
    @Test
    public void parseSplitedDosage(){


        DosageInstructionsStartStopFrequency dosageInstructionsSplited = createDosageSplited();
        System.out.println(dosageInstructionsSplited);
        addDosageInstructionToNewDoc(dosageInstructionsSplited);

        List<String> dosageIntakes =  EmedChStrucDocTextBuilder096.parseSplitedDosageIntake(dosageInstructionsSplited,LanguageCode.FRENCH);

        assertEquals("1) 40g Après le repas du soir", dosageIntakes.get(0));
        assertEquals("2) 20g Avant le coucher, Débit : 10/min", dosageIntakes.get(1));
        System.out.println(StringUtils.join(dosageIntakes,"\n"));


    }

    private void printDoc(SXCMTS dosageFrequency) {
        DosageInstructionsStartStopFrequency diStartStopFrequency = new DosageInstructionsStartStopFrequency();
        diStartStopFrequency.getClassCode().add("SBADM");

        diStartStopFrequency.setMoodCode(XDocumentSubstanceMood.EVN);

        diStartStopFrequency.getTemplateId()
                .add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1").getHl7CdaR2Ii());

        diStartStopFrequency.getEffectiveTime()
                .add(DateUtil.date2IvltsTzon(DateUtil.parseDateyyyyMMdd("20111129")));

        diStartStopFrequency.getEffectiveTime().add(dosageFrequency);


        diStartStopFrequency.setDoseQuantity(CdaUtil.createHl7CdaR2Ivlpq("0.5","1" ,"g" ));//CdaUtil.createHl7CdaR2Ivlpq("0.5", "g"));

        System.out.println(EmedChStrucDocTextBuilder096.parseIvlpq(diStartStopFrequency.getDoseQuantity()));
        addDosageInstructionToNewDoc(diStartStopFrequency);

    }

    /**
     * Add dosage
     * @param dosageInstructionsStartStopFrequency
     * @return
     */
    private POCDMT000040ClinicalDocument addDosageInstructionToNewDoc(DosageInstructionsStartStopFrequency dosageInstructionsStartStopFrequency) {
        POCDMT000040ClinicalDocument doc = factory.createPOCDMT000040ClinicalDocument();
        POCDMT000040Entry entry = factory.createPOCDMT000040Entry();
        MedicationTreatmenPlanSectionContentModule section = new MedicationTreatmenPlanSectionContentModule();
        entry.setSubstanceAdministration(dosageInstructionsStartStopFrequency);
        section.getEntry().add(entry);
        POCDMT000040Component3 comp3 = factory.createPOCDMT000040Component3();
        comp3.setSection(section);
        POCDMT000040StructuredBody structuredBody = CdaUtil.getHl7CdaR2StructuredBody(doc);
        structuredBody.getComponent().add(comp3);

        jaxbObjectToXML(doc);
        return doc;
    }

    /**
     * Creates sample data.
     *
     * @return the dosage instructions start stop frequency
     */
    private DosageInstructionsStartStopFrequency createDosageSingle() {

        DosageInstructionsStartStopFrequency diStartStopFrequency = new DosageInstructionsStartStopFrequency();
        diStartStopFrequency.getClassCode().add("SBADM");

        diStartStopFrequency.setMoodCode(XDocumentSubstanceMood.EVN);

        diStartStopFrequency.getTemplateId()
                .add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1").getHl7CdaR2Ii());

        diStartStopFrequency.getEffectiveTime()
                .add(DateUtil.date2IvltsTzon(DateUtil.parseDateyyyyMMdd("20111129")));

        diStartStopFrequency.getEffectiveTime().add(createAcm());


        diStartStopFrequency.setDoseQuantity(CdaUtil.createHl7CdaR2Ivlpq("0.5", null));


        return diStartStopFrequency;

    }

    /**
     * Creates sample data.
     *
     * @return the dosage instructions start stop frequency
     */
    private DosageInstructionsStartStopFrequency createDosageSplited() {

        DosageInstructionsStartStopFrequency diStartStopFrequency = new DosageInstructionsStartStopFrequency();
        diStartStopFrequency.getClassCode().add("SBADM");

        diStartStopFrequency.setMoodCode(XDocumentSubstanceMood.EVN);

        diStartStopFrequency.getTemplateId()
                .add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.9").getHl7CdaR2Ii());

        diStartStopFrequency.getEffectiveTime()
                .add(DateUtil.date2IvltsTzon(DateUtil.parseDateyyyyMMdd("20111129")));

        diStartStopFrequency.getEntryRelationship().add(createDosageInstructionsEntryDosageChange(1,"40",null, ChEmedTimingEvent.AFTER_DINNER));
        diStartStopFrequency.getEntryRelationship().add(createDosageInstructionsEntryDosageChange(2,"20","10", ChEmedTimingEvent.BEFORE_SLEEP));

        diStartStopFrequency.setDoseQuantity(CdaUtil.createHl7CdaR2Ivlpq("0.5", null));


        return diStartStopFrequency;

    }

    /**
     * Creates sample data.
     *
     * @return the dosage instructions start stop frequency
     */
    private DosageInstructionsStartStopFrequency createPivlDosage() {

        DosageInstructionsStartStopFrequency diStartStopFrequency = new DosageInstructionsStartStopFrequency();
        diStartStopFrequency.getClassCode().add("SBADM");

        diStartStopFrequency.setMoodCode(XDocumentSubstanceMood.EVN);

        diStartStopFrequency.getTemplateId()
                .add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1").getHl7CdaR2Ii());

        diStartStopFrequency.getEffectiveTime()
                .add(DateUtil.date2IvltsTzon(DateUtil.parseDateyyyyMMdd("20111129")));

        diStartStopFrequency.getEffectiveTime().add(createAcm());


        diStartStopFrequency.setDoseQuantity(CdaUtil.createHl7CdaR2Ivlpq("0.5", null));


        return diStartStopFrequency;

    }

    /**
     * Creates sample data.
     *
     * @return the dosage instructions start stop frequency
     */
    private DosageInstructionsStartStopFrequency createDosageSingleWithOffset() {

        DosageInstructionsStartStopFrequency diStartStopFrequency = new DosageInstructionsStartStopFrequency();
        diStartStopFrequency.getClassCode().add("SBADM");

        diStartStopFrequency.setMoodCode(XDocumentSubstanceMood.EVN);

        diStartStopFrequency.getTemplateId()
                .add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1").getHl7CdaR2Ii());

        diStartStopFrequency.getEffectiveTime()
                .add(DateUtil.date2IvltsTzon(DateUtil.parseDateyyyyMMdd("20111129")));

        EIVLTS eivlts = createAcmWithOffset();

        System.out.println(EmedChStrucDocTextBuilder096.parseEivlTs(LanguageCode.ENGLISH, eivlts));
        diStartStopFrequency.getEffectiveTime().add(eivlts);


        diStartStopFrequency.setDoseQuantity(CdaUtil.createHl7CdaR2Ivlpq("0.5", null));


        return diStartStopFrequency;

    }

    /**
     * Creates sample data.
     *
     * @return the dosage instructions for a specific datetime
     */
    private DosageInstructionsStartStopFrequency createTS() {

        DosageInstructionsStartStopFrequency diStartStopFrequency = new DosageInstructionsStartStopFrequency();
        diStartStopFrequency.getClassCode().add("SBADM");

        diStartStopFrequency.setMoodCode(XDocumentSubstanceMood.EVN);

        diStartStopFrequency.getTemplateId()
                .add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1").getHl7CdaR2Ii());

        //todo TS n'est pas considéré comme SXCMTS
        diStartStopFrequency.getEffectiveTime()
                .add((SXCMTS) DateUtil.date2Ts(DateUtil.parseDateAndTime("20.6.2020 10:50")));

        return diStartStopFrequency;

    }

    /**
     * Creates sample data.
     *
     * @return the dosage instructions for a specific datetime
     */
    private DosageInstructionsEntryDosageChange createDosageInstructionsEntryDosageChange(int sN, String doseQuantityInG, String rateQuantityInG, ChEmedTimingEvent chEmedTimingEvent) {
        ObjectFactory objectFactory = new ObjectFactory();
        POCDMT000040SubstanceAdministration substanceAdministration = objectFactory.createPOCDMT000040SubstanceAdministration();
        DosageInstructionsEntryDosageChange dosageInstructionsEntryDosageChange = new DosageInstructionsEntryDosageChange();
        INT anInt = new INT();

        anInt.setValue(BigInteger.valueOf(sN));

        dosageInstructionsEntryDosageChange.setHl7SequenceNumber(anInt);
        dosageInstructionsEntryDosageChange.setSubstanceAdministration(substanceAdministration);
        if(doseQuantityInG !=null){
            IVLPQ doseQuantity = CdaUtil.createHl7CdaR2Ivlpq(doseQuantityInG,"g");
            substanceAdministration.setDoseQuantity(doseQuantity);
        }
        if(rateQuantityInG!=null){
            IVLPQ doseQuantity = CdaUtil.createHl7CdaR2Ivlpq(rateQuantityInG, UnitsOfTime.MINUTE.getCodeValue());

            substanceAdministration.setRateQuantity(doseQuantity);
        }
        substanceAdministration.getEffectiveTime().add(createEIVLTS(chEmedTimingEvent));
        return dosageInstructionsEntryDosageChange;

    }

    /**
     * Creates sample data.
     *
     * @return the dosage instructions for a specific datetime
     */
    private DosageInstructionsStartStopFrequency createPivl(PIVLTS pivlts) {

        DosageInstructionsStartStopFrequency diStartStopFrequency = new DosageInstructionsStartStopFrequency();
        diStartStopFrequency.getClassCode().add("SBADM");

        diStartStopFrequency.setMoodCode(XDocumentSubstanceMood.EVN);

        diStartStopFrequency.getTemplateId()
                .add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1").getHl7CdaR2Ii());

        //todo TS n'est pas considéré comme SXCMTS
        diStartStopFrequency.getEffectiveTime()
                .add(pivlts);

        addDosageInstructionToNewDoc(diStartStopFrequency);
        return diStartStopFrequency;

    }

    /**
     * Creates sample data.
     *
     * @return the eivlts
     */
    private EIVLTS createAcm() {

        return createEIVLTS(ChEmedTimingEvent.BEFORE_BREAKFAST);
    }

    /**
     * Creates sample data.
     *
     * @return the eivlts
     */
    private EIVLTS createEIVLTS(ChEmedTimingEvent chEmedTimingEvent) {
        ObjectFactory factory = new ObjectFactory();
        EIVLTS acm = DosageInstructionsStartStopFrequency.getPredefinedEffectiveTimeA();
        EIVLEvent eivlEvent = factory.createEIVLEvent();
        eivlEvent.setCode(chEmedTimingEvent.getCodeValue());

        acm.setEvent(eivlEvent);
        return acm;
    }

    /**
     * Creates sample data.
     *
     * @return the eivlts
     */
    private PIVLTS createPivl(boolean institutionSpecified) {
        ObjectFactory factory = new ObjectFactory();
        PIVLTS pivlts = new PIVLTS();
        pivlts.setInstitutionSpecified(institutionSpecified);
        pivlts.setOperator(SetOperator.A);
        PQ period = factory.createPQ();
        period.setUnit("h");
        period.setValue("2");
        pivlts.setPeriod(period);
        return pivlts;
    }

    /**
     * Creates sample data.
     *
     * @return the eivlts
     */
    private PIVLTS createPivlWithPhase() {
        PIVLTS pivlts = createPivl(false);
        addPhaseToPivlTs(pivlts, DateUtil.parseDateAndTime("20.6.2020 10:50"), "10");
        PQ period = factory.createPQ();
        period.setUnit("d");
        period.setValue("1");
        pivlts.setPeriod(period);
        return pivlts;
    }

    /**
     * Add phase to pivlts
     * @param pivlts
     * @param low
     * @param widthMinutes
     * @return
     */
    private PIVLTS addPhaseToPivlTs(PIVLTS pivlts, Date low, String widthMinutes) {
        ObjectFactory factory = new ObjectFactory();
        IVLTS retVal = factory.createIVLTS();

        if (low != null) {
            TS tsLow = null;

            tsLow = factory.createTS();
            tsLow.setValue(DateUtil.formatDateTime(low));

            retVal.getRest()
                    .add(new JAXBElement<TS>(new QName("urn:hl7-org:v3", "low"), TS.class, tsLow));


        }
        if(widthMinutes!=null){
            PQ pq = factory.createPQ();
            pq.setValue(widthMinutes);
            pq.setUnit("min");
            retVal.getRest()
                    .add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "width"), PQ.class, pq));
        }

        pivlts.setPhase(retVal);
        return pivlts;
    }

    /**
     * Creates sample data.
     *
     * @return the eivlts
     */
    private EIVLTS createAcmWithOffset() {
        ObjectFactory factory = new ObjectFactory();
        EIVLTS acm = DosageInstructionsStartStopFrequency.getPredefinedEffectiveTimeA();
        EIVLEvent eivlEvent = factory.createEIVLEvent();
        eivlEvent.setCode(ChEmedTimingEvent.BEFORE_BREAKFAST_CODE);
        acm.setEvent(eivlEvent);
        IVLPQ offset = createHl7CdaR2Ivlpq("1", "2", "1", "h");
        acm.setOffset(offset);
        return acm;
    }
    /**
     * Transform an object to xml to print it
     * @param doc
     */
    private void jaxbObjectToXML(POCDMT000040ClinicalDocument doc) {
        try {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(POCDMT000040ClinicalDocument.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Print XML String to Console
            StringWriter sw = new StringWriter();

            //Write XML to StringWriter
            jaxbMarshaller.marshal(doc, sw);

            //Verify XML Content
            String xmlContent = sw.toString();
            System.out.println(xmlContent);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private IVLTS createHl7CdaR2IvlTs(String lowValue, String highValue, String widthValue, String unit) {
        ObjectFactory factory = new ObjectFactory();
        IVLTS retVal = factory.createIVLTS();


        PQ pqLow = null;
        if (lowValue == null) {
            pqLow = CdaUtil.createHl7CdaR2NullFlavorPq(null);
        } else {
            pqLow = factory.createPQ();
            pqLow.setValue(lowValue);
            pqLow.setUnit(unit);
        }

        PQ pqHigh = null;
        if (highValue == null) {
            pqHigh = CdaUtil.createHl7CdaR2NullFlavorPq(null);
        } else {
            pqHigh = factory.createPQ();
            pqHigh.setValue(highValue);
            pqHigh.setUnit(unit);

        }

        PQ pqWidth = null;
        if (widthValue == null) {
            pqWidth = CdaUtil.createHl7CdaR2NullFlavorPq(null);
        } else {
            pqWidth = factory.createPQ();
            pqWidth.setValue(widthValue);
            pqWidth.setUnit(unit);

        }

        retVal.getRest()
                .add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "low"), PQ.class, pqLow));
        retVal.getRest()
                .add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "high"), PQ.class, pqHigh));

        retVal.getRest()
                .add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "width"), PQ.class, pqWidth));
        return retVal;
    }

    private IVLPQ createHl7CdaR2Ivlpq(String lowValue, String highValue, String widthValue, String unit) {
        ObjectFactory factory = new ObjectFactory();
        IVLPQ retVal = factory.createIVLPQ();


        PQ pqLow = null;
        if (lowValue == null) {
            pqLow = CdaUtil.createHl7CdaR2NullFlavorPq(null);
        } else {
            pqLow = factory.createPQ();
            pqLow.setValue(lowValue);
            pqLow.setUnit(unit);
        }

        PQ pqHigh = null;
        if (highValue == null) {
            pqHigh = CdaUtil.createHl7CdaR2NullFlavorPq(null);
        } else {
            pqHigh = factory.createPQ();
            pqHigh.setValue(highValue);
            pqHigh.setUnit(unit);

        }

        PQ pqWidth = null;
        if (highValue == null) {
            pqWidth = CdaUtil.createHl7CdaR2NullFlavorPq(null);
        } else {
            pqWidth = factory.createPQ();
            pqWidth.setValue(widthValue);
            pqWidth.setUnit(unit);

        }

        retVal.getRest()
                .add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "low"), PQ.class, pqLow));
        retVal.getRest()
                .add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "high"), PQ.class, pqHigh));

        retVal.getRest()
                .add(new JAXBElement<PQ>(new QName("urn:hl7-org:v3", "width"), PQ.class, pqWidth));
        return retVal;
    }

}
