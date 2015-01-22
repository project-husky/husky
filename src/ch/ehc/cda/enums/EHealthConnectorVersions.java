package ch.ehc.cda.enums;

public enum EHealthConnectorVersions {
  /**
   * OID: 2.16.756.5.31 <div class="de">eHealth Connector V1</div> <div
   * class="fr">eHealth Connector V1</div>
   */
  EHealthConnectorV1 ("2.16.756.5.30.1.139.1.1.1","EHealthConnector V1");
  
  private String id;
  private String systemVersionName;

  EHealthConnectorVersions(String id, String systemVersionName) {
    this.id = id;
    this.systemVersionName = systemVersionName;
  }
  
  public String getId() {
    return this.id;
  }
  
  public String getSystemVersionName() {
    return this.systemVersionName;
  }
}
