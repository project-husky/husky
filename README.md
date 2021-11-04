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

## Former release notes

History (see Wiki for mor details):
- Rnext: next release date not defined, yet
- R202007: was released on July 15, 2020
- R201909: was released on September 17, 2019
- R201807: was released on July 24, 2018
- R201711: was released on November 30, 2017
- R201704: was released on April 30, 2017
- R201604: was released on April 30, 2016
- R201510: was released on October 31, 2015
- R201503: was released on April 1, 2015

**Features**
* Document Source and Consumer actors for IHE XDS.b, XDR and XDM
* Master Patient Index Client (IHE PIXv3 and IHE PDQv3)
* De-/Serialization of IHE PaLM documents (IHE XD-LAB; CDA-CH-LREP)
* De-/Serialization of IHE PCC documents (IHE IC; CDA-CH-VACD)
* De-/Serialization of IHE PCC documents (IHE EDES; CDA-CH-EDES)
* De-/Serialization of IHE PHARM documents (IHE DIS, MTP, PADV, PML, PRE; CDA-CH-EMED)
* Validation of CDA documents
* Embedding original PDF/A representation of a CDA document into the CDA document
* IHE XUA transactions including authentication (to IdP; User authentication provider) and autorisation (to X-Assertion Provider)