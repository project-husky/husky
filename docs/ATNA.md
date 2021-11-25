# Audit Trail and Node Authentication (ATNA)

This profile establishes security measures that, along with security policies and procedures, ensure patient data confidentiality, data integrity, and user accountability.
In the Husky project, the ATNA profile is not been implemented directly. It uses the [ATNA Auditing](https://oehf.github.io/ipf-docs/docs/ihe/atna/) implementation of the IPF framework. For this reason, auditing only needs to be configured.

## Configuration

An example for this configuration you can found in the integration tests of husky communication module. One class is called   ConvenienceCommunicationAtnaAuditTest. The corresponding configuration file can be found [here](../husky-communication/husky-communication-gen/src/test/resources/application-atna.properties).
