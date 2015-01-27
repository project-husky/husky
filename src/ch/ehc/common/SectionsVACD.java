package ch.ehc.common;

/**
 * Defines the LOINC codes used for the different sections in CDA document.
 * 
 * @see document Austauschformat, p. 80. CDA Body Level 2 Section Codes.
 * @author gsc
 */
public enum SectionsVACD {
  HISTORY_OF_IMMUNIZATION("11369-6", "hoi", "Impfungen"),
  ACTIVE_PROBLEMS("11450-4", "ap", "Problemliste"),
  HISTORY_OF_PAST_ILLNESS("11348-0", "hipi", "Bisherige Krankheiten"),
  ALLERGIES_REACTIONS("48765-2", "ar", "Allergien und Unverträglichkeiten"),
  CODED_RESULTS("30954-2","cr","Codierte Resultate"),
  SEROLOGY_STUDIES("18727-8", "sst", "Laborbefund"),
  HISTORY_OF_PREGNANCIES("10162-6","hop","Schwangerschaften"),
  TREATMENT_PLAN("18776-5", "tp", "Impfplan"),
  REMARKS("48767-8","k","Kommentar");

  private String loincCode;
  private String contentIdPrefix;
  private String sectionTitleDe;

  SectionsVACD(String loincCode, String contentIdPrefix, String sectionTitleDe) {
    this.loincCode = loincCode;
    this.contentIdPrefix = contentIdPrefix;
    this.sectionTitleDe = sectionTitleDe;
  }

  public String getLoincCode() {
    return loincCode;
  }

  public String getContentIdPrefix() {
    return contentIdPrefix;
  }

  public String getSectionTitleDe() {
    return sectionTitleDe;
  }

  public static boolean isHistoryOfPastIllness(String code) {
    return HISTORY_OF_PAST_ILLNESS.getLoincCode().equals(code);
  }

  public static boolean isHistoryOfImmunization(String code) {
    return HISTORY_OF_IMMUNIZATION.getLoincCode().equals(code);
  }

  public static boolean isAllergiesReactions(String code) {
    return ALLERGIES_REACTIONS.getLoincCode().equals(code);
  }


  public static boolean isActiveProblems(String code) {
    return ACTIVE_PROBLEMS.getLoincCode().equals(code);
  }

  public static boolean isLaboratorySpeciality(String code) {
    return SEROLOGY_STUDIES.getLoincCode().equals(code);
  }

  public static boolean isTreatmentPlan(String code) {
    return TREATMENT_PLAN.getLoincCode().equals(code);
  }

  public static boolean isRemarks(String code) {
    return REMARKS.getLoincCode().equals(code);
  }
}
