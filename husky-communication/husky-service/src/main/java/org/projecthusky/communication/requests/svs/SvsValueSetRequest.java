/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.requests.svs;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.projecthusky.valueset.config.ValueSetConfig;
import org.projecthusky.valueset.enums.SourceFormatType;
import org.projecthusky.valueset.enums.SourceSystemType;

@Getter
@Builder
@ToString
public class SvsValueSetRequest {
  private String className;
  private String projectFolder;
  private SourceFormatType sourceFormatType;
  private SourceSystemType sourceSystemType;
  private String sourceUrl;

  public static class SvsValueSetRequestBuilder {}
  
  /**
   * Builds the ValueSetConfig object.
   *
   * @return {@link ValueSetConfig}
   */
  public ValueSetConfig build() {
    ValueSetConfig valueSetConfig = new ValueSetConfig();
    valueSetConfig.setClassName(className);
    valueSetConfig.setProjectFolder(projectFolder);
    valueSetConfig.setSourceFormatType(sourceFormatType);
    valueSetConfig.setSourceSystemType(sourceSystemType);
    valueSetConfig.setSourceUrl(sourceUrl);

    return valueSetConfig;
  }
}
