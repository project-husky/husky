package org.projecthusky.fhir.emed.ch.epr.narrative.html;

public class HuskySoftwareMetadataProvider implements SoftwareProviderMetadataProvider {
    public static final String HUSKY_DEFAULT_SOFTWARE_NAME = "The Husky library";
    public static final String HUSKY_DEFAULT_SOFTWARE_PROVIDER_NAME = "Husky Project";

    private static final SoftwareProviderMetadata metadata =
            new SoftwareProviderMetadata(
                    HUSKY_DEFAULT_SOFTWARE_NAME,
                    null,
                    HUSKY_DEFAULT_SOFTWARE_PROVIDER_NAME
            );

    @Override
    public SoftwareProviderMetadata getSoftwareProviderMetadata() {
        return metadata;
    }
}
