package org.projecthusky.communication.utils;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.UUID;
import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;
import org.openehealth.ipf.commons.core.OidGenerator;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Association;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssociationLabel;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssociationType;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Folder;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.SubmissionSet;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp.Precision;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
import org.projecthusky.common.communication.DocumentMetadata;
import org.projecthusky.common.communication.DocumentMetadata.DocumentMetadataExtractionMode;
import org.projecthusky.common.enums.DocumentDescriptor;
import org.projecthusky.common.enums.EhcVersions;
import org.projecthusky.communication.requests.xds.XdsDocumentWithMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class that contains methods copied and refactored from the ConvenienceCommunication class
 * Methods are used to create the ProvideAndRegisterDocumentSet request
 */
public class XDSUtils {

  private static final Logger log = LoggerFactory.getLogger(XDSUtils.class);

  public static void addDocument(XdsDocumentWithMetadata documentWithMetadata, ProvideAndRegisterDocumentSet txnData,
      DocumentMetadataExtractionMode extractionMode) {
    var doc = new Document();

    DocumentMetadata documentMetadata = documentWithMetadata.getDocumentMetadata();
    documentMetadata.setDocumentDescriptor(documentWithMetadata.getDocumentDescriptor());
    InputStream inputStream = documentWithMetadata.getDataStream();

    try {
      var dataSource = new ByteArrayDataSource(inputStream, documentWithMetadata.getDocumentDescriptor().getMimeType());
      doc.setDataHandler(new DataHandler(dataSource));
      addXdsDocument(doc, txnData, documentMetadata, extractionMode);
    } catch (final IOException e) {
      log.error("Error adding document from inputstream.", e);
      log.error(e.getMessage(), e);
    }
  }

  public static void generateDefaultSubmissionSetAttributes(ProvideAndRegisterDocumentSet txnData) {
    if (txnData.getSubmissionSet() == null) {
      txnData.setSubmissionSet(new SubmissionSet());
    }

    // Create SubmissionSet
    final var subSet = txnData.getSubmissionSet();

    if (txnData.getDocuments() != null && !txnData.getDocuments().isEmpty()) {
      setSubSetDetailsFromDocument(subSet, txnData);
    } else if (txnData.getFolders() != null && !txnData.getFolders().isEmpty()) {
      setSubSetDetailsFromFolder(subSet, txnData);
    }
  }

  public static void linkDocumentEntryWithSubmissionSet(ProvideAndRegisterDocumentSet txnData) {
    for (Document document : txnData.getDocuments()) {
      // link document entry to submission set
      var association = new Association();
      association.setAssociationType(AssociationType.HAS_MEMBER);
      association.setSourceUuid(txnData.getSubmissionSet().getEntryUuid());
      association.setTargetUuid(document.getDocumentEntry().getEntryUuid());
      association.setLabel(AssociationLabel.ORIGINAL);
      association.assignEntryUuid();

      txnData.getAssociations().add(association);
    }

    for (Folder folder : txnData.getFolders()) {
      // link folder to submission set
      var association = new Association(AssociationType.HAS_MEMBER,
          txnData.getSubmissionSet().getEntryUuid(), txnData.getSubmissionSet().getEntryUuid(),
          folder.getEntryUuid());
      association.assignEntryUuid();

      txnData.getAssociations().add(association);
    }
  }

  protected static String getSourceId(Identifiable patientId) {
    if (patientId != null) {
      return patientId.getAssigningAuthority().getUniversalId();
    }
    return EhcVersions.getCurrentVersion().getOid();
  }

  protected static void setGeneralSubSetDetails(SubmissionSet subSet, Identifiable patientId) {
    // set submission time
    if (subSet.getSubmissionTime() == null) {
      subSet.setSubmissionTime(new Timestamp(ZonedDateTime.now(), Precision.SECOND));
    }

    if (subSet.getEntryUuid() == null) {
      subSet.setEntryUuid(UUID.randomUUID().toString());
    }

    if ((subSet.getUniqueId() == null) || (subSet.getSourceId() == null)) {

      if (subSet.getUniqueId() == null) {
        subSet.assignUniqueId();
      }

      // set submission set source id
      if (subSet.getSourceId() == null) {
        subSet.setSourceId(getSourceId(patientId));
      }
    }

    // Use the PatientId of the first Document for the Submission set ID
    if (subSet.getPatientId() == null) {
      subSet.setPatientId(patientId);
    }
  }

  private static void addXdsDocument(Document doc, ProvideAndRegisterDocumentSet txnData,
      DocumentMetadata documentMetadata, DocumentMetadataExtractionMode extractionMode) {
    if (documentMetadata != null) {
      doc.setDocumentEntry(documentMetadata.getDocumentEntry());
    }

    txnData.getDocuments().add(doc);

    if (extractionMode == DocumentMetadataExtractionMode.DEFAULT_EXTRACTION) {
      if (DocumentDescriptor.CDA_R2.equals(documentMetadata.getDocumentDescriptor())) {
        cdaExtractionFixes(documentMetadata);
      }
      generateDefaultDocEntryAttributes(documentMetadata, doc, documentMetadata.getDocumentDescriptor());
    }
  }

  private static void cdaExtractionFixes(DocumentMetadata docMetadata) {
    // Fix the OHT CDAExtraction behavior, that uses the confidentiality
    // code from the cda for the XDS metadata. This leads to an error in the
    // swiss repository, where the value set is different. As precaution we
    // clean the list.

    // We need to see if the clearExtracted() method is still needed
    // Commented it out because it deletes the DocumentMetadata values when we add the document
    // In the old implementation the setting of the DocumentMetadata values was done after the document was added
    // with the new implementation when we add the document we also set the values
    //docMetadata.clearExtracted();

    // Checks if the unique ID is longer than 64 or if no unique ID is set a new unique ID should be generated
    if (docMetadata.getUniqueId() == null
        || (docMetadata.getUniqueId() != null && docMetadata.getUniqueId().length() > 64)) {
      docMetadata.setUniqueId(OidGenerator.uniqueOid().toString());
    }
  }

  private static void generateDefaultDocEntryAttributes(DocumentMetadata docMetadata, Document document,
      DocumentDescriptor documentDescriptor) {

    // Derive MimeType from DocumentDescriptor
    if (docMetadata.getDocumentEntry().getMimeType() == null) {
      docMetadata.setMimeType(documentDescriptor.getMimeType());
      document.getDocumentEntry().setMimeType(documentDescriptor.getMimeType());
    }

    // Generate the unique ID
    if (docMetadata.getDocumentEntry().getUniqueId() == null) {
      document.getDocumentEntry().assignUniqueId();
      docMetadata.setUniqueId(document.getDocumentEntry().getUniqueId());
    }

    // Generate the UUID
    if (docMetadata.getDocumentEntry().getEntryUuid() == null) {
      document.getDocumentEntry().assignEntryUuid();
      docMetadata.setEntryUUID(document.getDocumentEntry().getEntryUuid());
    }

    // Generate Creation Time with the current time
    if (docMetadata.getDocumentEntry().getCreationTime() == null) {
      docMetadata.setCreationTime(ZonedDateTime.now());

      var timestamp = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp(
          docMetadata.getCreationTime(), Precision.SECOND);
      document.getDocumentEntry().setCreationTime(timestamp);
    }
  }

  private static void setSubSetDetailsFromDocument(SubmissionSet subSet, ProvideAndRegisterDocumentSet txnData) {
    log.info("count of documents {}", txnData.getDocuments().size());
    for (Document document : txnData.getDocuments()) {
      final var docEntry = document.getDocumentEntry();

      if (docEntry.getPatientId() == null) {
        log.warn("Missing destination patient ID in DocumentMetadata of document.");
      }

      // set ContentTypeCode
      if (subSet.getContentTypeCode() == null && docEntry.getTypeCode() != null) {
        subSet.setContentTypeCode(docEntry.getTypeCode());
      }

      setGeneralSubSetDetails(subSet, docEntry.getPatientId());
    }
  }

  private static void setSubSetDetailsFromFolder(SubmissionSet subSet, ProvideAndRegisterDocumentSet txnData) {
    for (Folder folder : txnData.getFolders()) {
      if (folder.getPatientId() == null) {
        throw new IllegalStateException(
            "Missing destination patient ID in DocumentMetadata of first document.");
      }

      if (subSet.getContentTypeCode() == null && folder.getCodeList() != null
          && folder.getCodeList().get(0) != null) {
        subSet.setContentTypeCode(folder.getCodeList().get(0));
      }

      setGeneralSubSetDetails(subSet, folder.getPatientId());
    }
  }
}