# Cross-Enterprise Document Sharing (XDS)

This profile should simplify the exchange of information in electronic health records between healthcare organizations. The XDS profile includes several actors. The central actors are the document repository and the document registry. Moreover there are the document consumer, the document source and the patient identity source.
In Husky the XDS profile is implemented in the `communication-gen` module, more precisely in class `ConvenienceCommunication`.

## Query stored metadata from document register

The transaction for querying metadata of registered documents is called ITI-18, which queries metadata associated with documents. ([ITI-18](https://profiles.ihe.net/ITI/TF/Volume2/ITI-18.html))

An example of querying document metadata can be found in the integration tests of husky communication module. The class is called `ConvenienceCommunicationQueryDocumentsTest`. To query the metadata, an instance of ConvenienceCommunication must be generated. Then method `queryDocuments` must be called. Various parameters can be specified in the transaction to filter the metadata. These filtering options are included in the class `FindDocumentsQuery`. The exact possibilities are described in the Javadoc.

```java
Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.1000", "IHERED-1024");

FindDocumentsQuery findDocumentsQuery = new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED);
convenienceCommunication.setAffinityDomain(affinityDomain);

final QueryResponse response = convenienceCommunication.queryDocuments(findDocumentsQuery, null);
```

Further details on the implementation can be found at [IPF ITI-18](<https://oehf.github.io/ipf-docs/docs/ihe/iti18/>)

## Retrieve document set

The transaction for retrieving document set is called ITI-43, which request stored documents. ([ITI-43](https://profiles.ihe.net/ITI/TF/Volume2/ITI-43.html))

An example of retrieving document can be found in the integration tests of husky communication module. The class is called `ConvenienceCommunicationRetrieveDocumentsTest`. To retrieve the document from repository, an instance of ConvenienceCommunication must be generated. Then method `retrieveDocument` must be called. The IDs that uniquely identify the document must be specified in the transaction. These parameters are contained in the class `DocumentRequest`. Further details can be found in Javadoc.

```java
convenienceCommunication.setAffinityDomain(affinityDomain);

var documentRequest = new DocumentRequest("1.1.4567332.1.75", null,"1.2.820.99999.18508463736145106181926975526539403561455330316563", "urn:oid:1.1.4567334.1.6");

final RetrievedDocumentSet response = convenienceCommunication.retrieveDocument(documentRequest, null);
```

Further details on the implementation can be found at [IPF ITI-43](https://oehf.github.io/ipf-docs/docs/ihe/iti43/)

## Provide and register document set

The transaction to provide and register document is called [ITI-41](https://profiles.ihe.net/ITI/TF/Volume2/ITI-41.html). It is a transaction to transmit a document and theirs associated metadata. The document will be stored in the Document Repository, while the metadata are stored in the Document Registry.

An example for submitting a document set to document repository is located in integration tests of husky communication module. The class is called `ConvenienceCommunicationSubmitDocumentTest`. To provide and register a document set you have to create an instance of ConvenienceCommunication and add the document you want to submit to this instance. All metadata that can be extracted from the document is returned in object `DocumentMetadata`. The metadata that is additionally required must be set in this object. When submitting documents, either generated metadata can be used for submission or self-generated metadata can be passed. Further details can be found in the Javadoc.

```java
convenienceCommunication.setAffinityDomain(affinityDomain);
convenienceCommunication.clearDocuments();

DocumentMetadata metdata = convenienceCommunication.addDocument(DocumentDescriptor.PDF, getDocPdf());
SubmissionSetMetadata subSet = new SubmissionSetMetadata();
Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
setMetadataForPdf(metdata, patientId);
setSubmissionMetadata(subSet, patientId);
var response = convenienceCommunication.submit(subSet, null);

```

Further details on the implementation can be found at [IPF ITI-41](https://oehf.github.io/ipf-docs/docs/ihe/iti41/)

## Replace stored document

Replacing an existing document set is implemented using transaction [ITI-41](https://profiles.ihe.net/ITI/TF/Volume2/ITI-41.html) in the XDS profile. It is a transaction to transmit a document and theirs associated metadata. The document will be stored in document repository, while the metadata are stored in the Document registry. The already existing document will be set to deprecated.

An example for replacing a document set can be found in integration tests of husky communication module. The class is called `ConvenienceCommunicationSubmitDocumentTest`. To replace a document set you have to create an instance of ConvenienceCommunication and add the document you want to submit to this instance. All metadata that can be extracted from the document is returned in object `DocumentMetadata`. The metadata that is additionally required must be set in this object. When replacing documents, the self-generated metadata for a  submission set must be passed. Also, the entryUUID of the document to be replaced must be passed. Further details can be found in the Javadoc.

```java
convenienceCommunication.clearDocuments();

metdata = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCdaV2());
subSet = new SubmissionSetMetadata();
patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
setMetadataForCda(metdata, patientId);
setSubmissionMetadata(subSet, patientId);

response = convenienceCommunication.submitReplacement(subSet, entryUuid, securityHeaderElement);
```

Further details on the implementation can be found at [IPF ITI-41](https://oehf.github.io/ipf-docs/docs/ihe/iti41/)
