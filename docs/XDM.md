# Cross-enterprise Document Media Interchange (XDM)

This profile is intended to enable the exchange of documents via standard media such as e-mail or USB ports. There are two actors the portable media creator and the portable media importer. The method to exchange documents is called "distribute document set on media ITI-32". There are two use cases for this profile. One participant wants to import the documents into his own system. While the other participant wants to export the documents.
In Husky the XDM profile is implemented in the `communication-gen` module, more precisely in class `ConvenienceCommunication`.

## Import XDM content

In this use case, the files are extracted from the export ZIP folder. The ZIP folder contains several files. The contents of the documents are shown in class `XdmContents`. One file is called README.txt and contains information about the organization and the application that created the ZIP folder (`ReadmeTxt`). Another file named INDEX.htm is included. This file contains the identification of the organization from the creator and links to the other files in the folder (`IndexHtm`). The third important part in the class `XdmContents` is the list of the documents and their associated metadata. This information is stored in a list of `ProvideAndRegisterDocumentSet` objects. The exact documentation of the object structure can be found here [ProvideAndRegisterDocumentSet](https://oehf.github.io/ipf-docs/_pages/apidocs/org/openehealth/ipf/commons/ihe/xds/core/requests/ProvideAndRegisterDocumentSet.html)

An example of importing XDM content from a ZIP file can be found in integration tests of husky communication module. The class is called `ConvenienceCommunicationXdmContentsTest`. To extract the XDM content you have to create an instance of `ConvenienceCommunication` and call the method `getXdmContents()`.

```java
conCom.clearDocuments();

ZipFile zipFile = null;

try {
    zipFile = new ZipFile(targetFile);
} catch (final ZipException e) {
    log.error("ZipException.", e);
} catch (final IOException e) {
    log.error("IOException.", e);
}
XdmContents contents = conCom.getXdmContents(zipFile);
```

## Export XDM content

In this use case the ZIP folder is created. The README.txt and INDEX.htm files are generated automatically. The Husky project is mentioned as creator in the README.txt file. The generated INDEX.htm file contains information about the contents of the ZIP folder in English, German and French. It also adds documents with their associated metadata to the ZIP folder.

An example of exporting XDM content to a ZIP file can be found in integration tests of husky communication module. The class is called `ConvenienceCommunicationXdmContentsTest`. To create the XDM content you have to create an instance of `ConvenienceCommunication` and add a document. The metadata, which can be automatically extracted from the document, is stored in class `DocumentMetadata`. Other metadata must be set in the returned object. In addition, the metadata of the submission set must also be set explicitly. When this is done, method `createXdmContents` can be called. Further details can be found in the Javadoc.

```java
DocumentMetadata metaData = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCda(), getDocCda());
Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
setMetadataForCda(metaData, patientId);

metaData = convenienceCommunication.addDocument(DocumentDescriptor.PDF, getDocPdf());
setMetadataForPdf(metaData, patientId);

SubmissionSetMetadata subSet = new SubmissionSetMetadata();
setSubmissionMetadata(subSet, patientId);

// create a FileOutputStream to store the zip file
final File targetFile = new File("src/test/resources/xdmTest_Java.zip");

try (final FileOutputStream outputStream = new FileOutputStream(targetFile)) {
    // create and store zip.
    convenienceCommunication.createXdmContents(subSet, outputStream);
}
```
