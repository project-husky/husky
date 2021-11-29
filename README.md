This convenience API for IHE transactions and CDA documents allows easy access and conformity to eHealth affinity domains. The project is based on a country independent architecture, but implements also Swiss extensions. Other country extensions are possible, your contributions are welcome. 

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

## CDA validation

This project also supports validation of CDA documents using schema, schematron and PDF validation. Details on how to use this feature can be found [here](docs/CDA_Validation.md).
