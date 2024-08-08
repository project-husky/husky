package org.projecthusky.fhir.emed.ch.epr.narrative.html;

public class HuskySoftwareMetadataProvider implements SoftwareProviderMetadataProvider {
    private static final SoftwareProviderMetadata metadata =
            new SoftwareProviderMetadata("Husky", null, "Project Husky");

    @Override
    public SoftwareProviderMetadata getSoftwareProviderMetadata() {
        return metadata;
    }
}
