# The Husky library

[![GitHub license](https://img.shields.io/github/license/project-husky/husky)](https://github.com/project-husky/husky/blob/master/License.md)
![JDK17](https://img.shields.io/badge/java-JDK17-blue)
![GitHub Workflow Status](https://img.shields.io/github/workflow/status/project-husky/husky/Java%20CI%20with%20Maven%20and%20CodeQL)
![Snyk Vulnerabilities for GitHub Repo](https://img.shields.io/snyk/vulnerabilities/github/project-husky/husky)

This convenience API for IHE transactions and CDA documents allows easy access and conformity to eHealth affinity
domains. The project is based on a country independent architecture, but implements also Swiss extensions. Other country
extensions are possible, your contributions are welcome.

The latest Javadoc is published on <a href="https://project-husky.github.io/husky/">project-husky.github.io/husky</a>
and the documentation is available in the [wiki](https://github.com/project-husky/husky/wiki).

## Installation

- **[Install Guide](docs/Installation.md)**

## Development

- **[Development Guidelines](docs/Development.md)**

## Implemented IHE Profiles

Husky offers support for multiple IHE ITI profiles. For each profile transaction there is a convenience method.
Supported profiles are

| Profile              | Transaction          | Description                              |
|----------------------|----------------------|------------------------------------------|
| [PDQ](docs/PDQV3.md) | ITI-47               | Query patient demographics               |
| [PIX](docs/PIXV3.md) | ITI-44, ITI-45       | Patient identity transactions            |
| [PPQ](docs/PPQ.md)   | PPQ-1, PPQ-2         | Privacy Policy Queries                   |
| [SVS](docs/SVS.md)   | ITI-48               | Retrieve value set                       |
| [XDM](docs/XDM.md)   | ITI-32               | Exchange of documents via standard media |
| [XDS](docs/XDS.md)   | ITI-18,ITI-41,ITI-43 | Exchange of documents                    |
| [XUA](docs/XUA.md)   | ITI-40               | Provide identity assertions              |

## Modules

* `husky-api`: The main module managing dependencies.
    * `husky-cda`: The parent module for HL7 CDAs support.
        * `husly-elga`: CDAs for ELGA.
    * `husky-common`: The common parent module.
        * `husky-common-gen`: The common part that are generic.
        * `husky-common-at`: The common part dedicated to the Austrian environment.
        * `husky-common-ch`: The common part dedicated to the Swiss environment.
    * `husky-communication`: Implementation of transactions with [IPF](https://github.com/oehf/ipf)
      and [Apache Camel](https://github.com/apache/camel).
        * `husky-communication-gen`: Generic transactions.
        * `husky-communication-at`: Austrian-specific transactions.
        * [`husky-communication-ch`](https://github.com/project-husky/husky/wiki/Module:-husky-communication-ch):
          Swiss-specific transactions.
        * `husky-communication-ppq`: CH:PPQ (Privacy Policy Query) transactions.
        * `husky-communication-valueset-gen`: Models and client to retrieve value sets from ArtDecor (please note that
          Swiss value sets are usually transformed into enums and put in other modules).
        * `husky-xds-mhd-conversion`:
        * `husky-communication-xua`: Models, generator, parser and validator of CH-EPR SAML2 Assertions (per IHE XUA
          profile).
            * [`husky-xua-ch-impl`](https://github.com/project-husky/husky/wiki/Module:-husky-xua-ch-impl): XUA
              utilities for the Swiss environment.
            * `husky-xua-gen-api`:
            * `husky-xua-gen-impl`:
    * `husky-fhir`: The FHIR parent module.
        * `husky-fhir-communication`: Helper for FHIR communication.
        * `husky-fhir-emed-ch`: The Swiss eMedication parent module.
            * [`husky-fhir-emed-ch-common`](https://github.com/project-husky/husky/wiki/Module:-husky-fhir-emed-ch-common):
              Common parts of the Swiss eMedication.
            * [`husky-fhir-emed-ch-epr`](https://github.com/project-husky/husky/wiki/Module:-husky-fhir-emed-ch-epr):
              Support module for the Swiss CH-EMED-EPR FHIR profile.
            * [`husky-fhir-emed-ch-epr-narrative`](https://github.com/project-husky/husky/wiki/): Narrative utilities
              for the Swiss CH-EMED-EPR FHIR profile.
        * `husky-fhir-structures`:
            * `husky-fhir-structures-gen`: Generic FHIR structures.
            * `husky-fhir-structures-ch`: Swiss FHIR structures.
    * `husky-validation`: The validation parent module.
        * [`husky-validation-service`](https://github.com/project-husky/husky/wiki/Module:-husky-validation-service):
          The module implements services to validate XML documents with XML Schemas and
          Schematron, as well as PDF documents for the A-1 and A-2 conformance levels.

## Integration in Projects

The generated maven artefacts are located in a maven repository and can easily integrated into your maven project by
adding the corresponding dependency in your dependency management.
i.e.

```
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.projecthusky.communication</groupId>
      <artifactId>husky-communication-gen</artifactId>
      <version>2.0.0</version>
    </dependency>
  </dependencies>
  ...
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>org.projecthusky.communication</groupId>
    <artifactId>husky-communication-gen</artifactId>
    <version>2.0.0</version>
  </dependency>
  ...
</dependencies>
```

You have to add the repository information into your pom too.

```
<repositories>
  <repository>
    <id>husky-releases</id>
    <name>husky-releases</name>
    <url>https://archiva.et-innovations.org/repository/internal/</url>
    <snapshots>
      <enabled>false</enabled>
    </snapshots>
  </repository>
  <repository>
    <id>husky-snapshots</id>
    <name>husky-snapshots</name>
    <url>https://archiva.et-innovations.org/repository/snapshots/</url>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
</repositories>
```

## License

This code is made available under the terms of the Eclipse Public License v1.0 in the
[github project](https://github.com/project-husky/husky). There, you also find a list of the contributors and the
license information. This project has been developed further and modified by the joined working group Husky on the basis
of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main
contributor/author of the eHealth Connector. The final version of the eHealthConnector is available as a release in this
project.

All other accompanying materials are made available under the terms of the Creative Commons license
Attribution-ShareAlike 3.0 Switzerland (CC BY-SA 3.0 CH)
see https://creativecommons.org/licenses/by-sa/3.0/ch/ (Ausschliesslicher Gerichtsstand ist Bern, Schweiz). The
exclusive place of jurisdiction is Bern, Switzerland for the Creative Commons license.
