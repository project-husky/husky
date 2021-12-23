This convenience API for IHE transactions and CDA documents allows easy access and conformity to eHealth affinity domains. The project is based on a country independent architecture, but implements also Swiss extensions. Other country extensions are possible, your contributions are welcome. 

The latest Javadoc is published on <a href="https://project-husky.github.io/husky/">project-husky.github.io/husky</a>.

## Installation

- **[Install Guide](docs/Installation.md)**

## Implemented IHE Profiles

Husky offers support for multiple IHE ITI profiles. For each profile transaction there is a convenience method. Supported profiles are

| Profile             | Transaction          | Description                              |
| ------------------- | -------------------- | ---------------------------------------- |
| [ATNA](docs/ATNA.md)| ITI-20               | Send audit events                        |
| [PDQ](docs/PDQ.md)  | ITI-47               | Query patient demographics               |
| [PIX](docs/PIX.md)  | ITI-44, ITI-45       | Patient identity transactions            |
| [PPQ](docs/PPQ.md)  | PPQ-1, PPQ-2         | Privacy Policy Queries                   |
| [SVS](docs/SVS.md)  | ITI-48               | Retrieve value set                       |
| [XDM](docs/XDM.md)  | ITI-32               | Exchange of documents via standard media |
| [XDS](docs/XDS.md)  | ITI-18,ITI-41,ITI-43 | Exchange of documents                    |
| [XUA](docs/XUA.md)  | ITI-40               | Provide identity assertions              |


## eMed Module
TODO: add documentation

## CDA validation

This project also supports validation of CDA documents using schema, schematron and PDF validation. Details on how to use this feature can be found [here](docs/CDA_Validation.md).
## Modules

* `husky-api`: The main module managing dependencies.
  * `husky-common`: The common parent module.
    * `husky-common-gen`: The common part that are generic.
    * `husky-common-ch`: The common part dedicated to the Swiss environment.
  * `husky-communication`: Implementation of transactions with [IPF](https://github.com/oehf/ipf) and [Apache Camel](https://github.com/apache/camel).
    * `husky-communication-gen`: Generic transactions.
    * `husky-communication-ch`: Swiss-specific transactions.
    * `husky-communication-ppq`: CH:PPQ (Privacy Policy Query) transactions.
    * `husky-communication-valueset-gen`: Models and client to retrieve value sets from ArtDecor (please note that Swiss value sets are usually transformed into enums and put in other modules).
    * `husky-communication-xua`: Models, generator, parser and validator of CH-EPR SAML2 Assertions (per IHE XUA profile).
  * `husky-emed`: The eMedication parent module.
    * `husky-emed-cda`: Models, digesters and aggregators of CDA-CH-EMED documents.
    * `husky-emed-validation`: A validator of CDA-CH-EMED documents with the IHE Pharm XML Schema, the CDA-CH-EMED Schematrons and the PDF/A validator.
    * `husky-emed-narrative`: Generator of narrative text for CDA-CH-EMED documents, in StrucDocText or HTML/PDF with customizable templates.
    * `husky-emed-conversion`: Not implemented yet. A conveniance API to convert documents between CDA-CH-EMED and CH-EMED specifications.
  * `husky-fhir`: The FHIR parent module.
    * `husky-fhir-communication`: Helper for FHIR communication.
    * `husky-fhir-structures`: 
      * `husky-fhir-structures-gen`: Generic FHIR structures.
      * `husky-fhir-structures-ch`: Swiss FHIR structures.
  * `husky-validation`: The validation parent module.
    * `husky-validation-service`: The module implements services to validate XML documents with XML Schemas and Schematron, as well as PDF documents for the A-1 and A-2 conformance levels.

