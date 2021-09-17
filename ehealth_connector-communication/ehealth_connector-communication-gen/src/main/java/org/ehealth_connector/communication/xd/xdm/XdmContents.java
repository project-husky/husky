/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.communication.xd.xdm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.ehealth_connector.common.utils.ZipCreator;
import org.ehealth_connector.communication.utils.XdsUtil;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Association;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Folder;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorCode;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorInfo;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Severity;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Status;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.lcm.SubmitObjectsRequest;
import org.openehealth.ipf.platform.camel.ihe.xds.core.converters.EbXML30Converters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class XdmContents represents all content of an XDM volume. This includes
 * human readable informative files like README.TXT or INDEX.HTM and also
 * machine readable files like METADATA.XML
 */
public class XdmContents {

	/** The xdm index. */
	private static final String XDM_INDEX = "INDEX.HTM";

	/** The xdm metadata. */
	private static final String XDM_METADATA = "METADATA.XML";

	/** The xdm payload root. */
	private static final String XDM_PAYLOAD_ROOT = "IHE_XDM";

	/** The xdm readme. */
	private static final String XDM_README = "README.TXT";

	/** The index htm. */
	private IndexHtm indexHtm;

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	/** The readme txt. */
	private ReadmeTxt readmeTxt;

	/** The OHT response object. */
	private final XdmRetrieveResponseTypeImpl resp;

	/** The txn data. */
	private List<ProvideAndRegisterDocumentSet> txnData;

	/** The zip file. */
	private ZipFile zipFile;

	/**
	 * Instantiates a new xdm contents.
	 */
	public XdmContents() {
		this.resp = new XdmRetrieveResponseTypeImpl();
		this.txnData = new LinkedList<>();
	}

	/**
	 * Instantiates a new xdm contents with given INDEX.HTM and README.TXT files as
	 * according objects
	 *
	 * @param indexHtm  the IndexHtm object (contains information about the contents
	 *                  of the volume)
	 * @param readmeTxt the ReadmeTxt object (contains information about the vendor
	 *                  and system that created the volume)
	 */
	public XdmContents(IndexHtm indexHtm, ReadmeTxt readmeTxt) {
		this();
		this.indexHtm = indexHtm;
		this.readmeTxt = readmeTxt;
	}

	/**
	 * Instantiates a new xdm contents with a given filePath, pointing to an
	 * existing zip file.
	 *
	 * @param filePath the file path to an existing zip file, which holds the
	 *                 contents of an xdm volume
	 */
	public XdmContents(String filePath) {
		this();
		try {
			this.zipFile = new ZipFile(filePath);
		} catch (final IOException e) {
			this.resp.setStatus(Status.FAILURE);
			log.error("IO Exception during read of " + filePath, e);
		}
	}

	/**
	 * Instantiates a new xdm contents with given INDEX.HTM and README.TXT files,
	 * which will be read from given files paths.
	 *
	 * @param indexHtm  the IndexHtm object (contains information about the contents
	 *                  of the volume)
	 * @param readmeTxt the ReadmeTxt object (contains information about the vendor
	 *                  and system that created the volume)
	 */
	public XdmContents(String indexHtm, String readmeTxt) {
		this();
		try {
			this.indexHtm = new IndexHtm(new FileInputStream(indexHtm));
			this.readmeTxt = new ReadmeTxt(new FileInputStream(readmeTxt));
		} catch (final FileNotFoundException e) {
			this.resp.setStatus(Status.FAILURE);
			log.error("IO Exception during reading of INDEX.HTM and README.TXT. ", e);
		}
	}

	/**
	 * Instantiates a new xdm contents with a given XDM volume as single zip file.
	 *
	 * @param zipFile the zip file
	 */
	public XdmContents(ZipFile zipFile) {
		this();
		try {
			if (zipFile == null)
				throw new IOException();
			else {
				this.zipFile = zipFile;
			}
		} catch (final IOException e) {
			this.resp.setStatus(Status.FAILURE);
			log.error("IO Exception during read of ZipFile", e);
		}
	}

	/**
	 * Creates the metadata xml.
	 *
	 * @param txnData the txn data
	 * @return the XML resource
	 * @throws JAXBException
	 */
	private String createMetadataXml(ProvideAndRegisterDocumentSet txnData) throws JAXBException {
		SubmitObjectsRequest submit = null;

		DocumentEntry docEntry;
		String hash;
		Long size;

		// Calculate Hash and Size for each document and set the information to
		// the DocumentMetadata
		for (final Document xdsDoc : txnData.getDocuments()) {
			try (var is = xdsDoc.getDataHandler().getInputStream()) {
				docEntry = xdsDoc.getDocumentEntry();

				hash = DigestUtils.sha1Hex(xdsDoc.getDataHandler().getInputStream());
				docEntry.setHash(hash);

				size = Long.valueOf(IOUtils.toByteArray(is).length);
				docEntry.setSize(size);
			} catch (final Exception e) {
				log.error("Error calculating hash and size. ", e);
				return null;
			}
		}

		// form the ebXML payload for the message
		submit = EbXML30Converters.convert(txnData).getSubmitObjectsRequest();

		final var marshaller = JAXBContext.newInstance(SubmitObjectsRequest.class).createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF8");
		final var stringWriter = new StringWriter();
		marshaller.marshal(submit, stringWriter);

		return stringWriter.toString();
	}

	/**
	 * Creates the XDM volume contents and writes them to the given outputStream.
	 *
	 * @param outputStream the output stream, in which the contents will be written.
	 * @param txnData      the SubmitTransactionData data (containing Metadata and
	 *                     the payload files themselves)
	 */
	public void createZip(OutputStream outputStream, ProvideAndRegisterDocumentSet txnData) {
		this.txnData.add(txnData);

		// Creating the ZipFileHelper Class
		final var zip = new ZipCreator(outputStream);

		// Add the path structure for documents in the Zip File
		try {
			zip.addZipItem("IHE_XDM/");
			zip.addZipItem("IHE_XDM/SUBSET01/");

			// Add each XdsDocument to the Zip File
			var i = 0;
			final List<Document> docList = txnData.getDocuments();
			for (final Document xdsDoc : docList) {
				i++;
				final String filePath = XdsUtil.createXdmDocPathAndName(xdsDoc, i);
				xdsDoc.getDocumentEntry().setUri(XdsUtil.createXdmDocName(xdsDoc, i));

				// add the document
				zip.addZipItem(xdsDoc.getDataHandler().getInputStream(), filePath);
			}

			// Add the necessary files to the zip container
			zip.addZipItem(indexHtm.getInputStream(), XDM_INDEX);
			zip.addZipItem(readmeTxt.getInputStream(), XDM_README);

			final String metadataXml = createMetadataXml(txnData);

			zip.addZipItem(this.getMetadataXmlInputStream(metadataXml), "IHE_XDM/SUBSET01/METADATA.XML");

			zip.closeZip();
		} catch (final IOException | JAXBException e) {
			this.resp.setStatus(Status.FAILURE);
			log.error("IO Exception during zip creation. ", e);
		}
	}

	/**
	 * Creates the XDM volume contents and writes them to the given File(path)
	 *
	 * @param filePath the path to the file, in which the contents will be written.
	 * @param txnData  the SubmitTransactionData data (containing Metadata and the
	 *                 payload files themselves)
	 */
	public void createZip(String filePath, ProvideAndRegisterDocumentSet txnData) {
		final var targetFile = new File(filePath);
		try {
			final var outputStream = new FileOutputStream(targetFile);
			createZip(outputStream, txnData);
		} catch (final FileNotFoundException e) {
			this.resp.setStatus(Status.FAILURE);
			log.error("FileNotFoundException during target file creation. ", e);
		}
	}

	/**
	 * Checks if the integritiy values (hash and size) for the documents are the
	 * same as in the metadata.
	 *
	 * @return false, if the values don´t match, true otherwise
	 */
	@SuppressWarnings("resource")
	private boolean documentsIntegrityCheck() {
		if (isSubmitTransactionDataNull(0))
			return false;

		DocumentEntry docMetadata = null;
		String docHash = null;
		long docSize = 0;

		for (var i = 0; i < txnData.size(); i++) {
			for (final Document doc : txnData.get(i).getDocuments()) {
				docMetadata = doc.getDocumentEntry();

				try {
					docHash = DigestUtils.sha1Hex(doc.getDataHandler().getInputStream());
					docSize = IOUtils.toByteArray(doc.getDataHandler().getInputStream()).length;
				} catch (final IOException e) {
					log.error("IO Exception during zip document integrity check. ", e);
				}

				if ((docMetadata.getHash() == null) || !docMetadata.getHash().equals(docHash)) {
					log.warn(
							"Integrity check failed for document hash in Submission Set: {} DocumentEntry with UUID: {}",
							i, doc.getDocumentEntry().getEntryUuid());
					this.resp.setStatus(Status.PARTIAL_SUCCESS);

					final var error = new ErrorInfo();
					error.setErrorCode(ErrorCode.NON_IDENTICAL_HASH);
					error.setLocation(
							"Document in submission set: " + i + " with Entry UUID: " + docMetadata.getEntryUuid());
					error.setCustomErrorCode(
							"The hash value of the document does not match the hash value, which is provided in the document metadata.");
					error.setSeverity(Severity.WARNING);
					if (this.resp.getErrorList() == null) {
						this.resp.setErrorList(new LinkedList<>());
					}
					this.resp.getErrorList().add(error);
					return false;
				}
				if (docMetadata.getSize() == null || docMetadata.getSize() != docSize) {
					log.warn(
							"Integrity check failed for document size in Submission Set: {}  DocumentEntry with UUID: {}",
							i, doc.getDocumentEntry().getEntryUuid());
					this.resp.setStatus(Status.PARTIAL_SUCCESS);

					final var error = new ErrorInfo();
					error.setErrorCode(ErrorCode.NON_IDENTICAL_SIZE);
					error.setLocation(
							"Document in submission set: " + i + " with Entry UUID: " + docMetadata.getEntryUuid());
					error.setCustomErrorCode(
							"The size value of the document does not match the size value, which is provided in the document metadata.");
					error.setSeverity(Severity.WARNING);
					if (this.resp.getErrorList() == null) {
						this.resp.setErrorList(new LinkedList<>());
					}
					this.resp.getErrorList().add(error);
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Gets a list containing the documents together with the Document Metadata.
	 *
	 * @return the document and metadata list
	 */
	public List<DocumentContentAndMetadata> getDocumentAndMetadataList() {
		return getDocumentAndMetadataList(0);
	}

	/**
	 * Gets a list containing the documents together with the Document Metadata for
	 * a specific submission set.
	 *
	 * @param submissionSetNumber the submission set number
	 * @return the document and metadata list
	 */
	public List<DocumentContentAndMetadata> getDocumentAndMetadataList(int submissionSetNumber) {
		lazyLoadCheck();
		if (isSubmitTransactionDataNull(submissionSetNumber)) {
			return new LinkedList<>();
		}

		final ProvideAndRegisterDocumentSet std = txnData.get(submissionSetNumber);
		final List<DocumentContentAndMetadata> docAndMetaList = new ArrayList<>();

		for (final Document xdsDoc : std.getDocuments()) {
			final var docAndMetadataEntry = new DocumentContentAndMetadata(xdsDoc, xdsDoc.getDocumentEntry());
			docAndMetaList.add(docAndMetadataEntry);
		}
		return docAndMetaList;
	}

	/**
	 * Gets a list of documents (the actual payload of the XDM volume)
	 *
	 * @return the documents
	 */
	public List<Document> getDocumentList() {
		return getDocumentList(0);
	}

	/**
	 * Gets a list of documents (the actual payload of the XDM volume) for a
	 * specific submission set.
	 *
	 * @param submissionSetNumber the submission set number
	 * @return the document list
	 */
	public List<Document> getDocumentList(int submissionSetNumber) {
		lazyLoadCheck();
		if (isSubmitTransactionDataNull(submissionSetNumber)) {
			return new LinkedList<>();
		}

		return txnData.get(submissionSetNumber).getDocuments();
	}

	/**
	 * Gets the index htm.
	 *
	 * @return the index htm
	 */
	public IndexHtm getIndexHtm() {
		lazyLoadCheck();
		return indexHtm;
	}

	/**
	 * Gets the metadata xml input stream.
	 *
	 * @param metadataXml
	 *
	 * @return the metadata xml input stream
	 */
	private InputStream getMetadataXmlInputStream(String metadataXml) {
		try {
			final var bOS = new ByteArrayOutputStream();
			bOS.write(metadataXml.getBytes());
			return new ByteArrayInputStream(bOS.toByteArray());
		} catch (final IOException e) {
			log.error("IOException during reading the Metadata.xml InputStream ", e);
			this.resp.setStatus(Status.FAILURE);
		}
		return null;
	}

	/**
	 * Gets the readme txt.
	 *
	 * @return the readme txt
	 */
	public ReadmeTxt getReadmeTxt() {
		lazyLoadCheck();
		return readmeTxt;
	}

	/**
	 * Given a full ZipEntry filespec, extracts the name of the folder (if present)
	 * under the IHE_XDM root specified by IHE XDM.
	 *
	 * @param zipEntryName the zip entry name
	 * @return the submission set dirspec
	 */
	private String getSubmissionSetDirspec(String zipEntryName) {
		String result = null;
		if (zipEntryName != null) {
			final String[] components = zipEntryName.split("[\\\\/]");
			if (components[0].equals(XDM_PAYLOAD_ROOT)) {
				result = components[1];
			}
		}
		return result;
	}

	/**
	 * Gets the XDM contents as OHT submit transaction data.
	 *
	 * @return the XDM contents as OHT submit transaction data
	 */
	public List<ProvideAndRegisterDocumentSet> getXdmContentsAsIpfSubmitTransactionData() {
		lazyLoadCheck();
		return txnData;
	}

	/**
	 * Gets the XDM contents as OHT XDSResponseType. This Object contains a flat
	 * list of all documents from all submission sets. It does not contain the full
	 * XDS Metadata for each document. If you want to get this data, please use the
	 * getDocumentAndMetadata method.
	 *
	 * @return The OHT XDSResponseType
	 */
	public XdmRetrieveResponseTypeImpl getXdmContentsAsOhtXdsResponseType() {
		lazyLoadCheck();
		for (var i = 0; i < txnData.size(); i++) {
			resp.setAttachments(txnData.get(i).getDocuments());
		}
		return resp;
	}

	/**
	 * Tries accessing an XDM file inside ZIP using both MS-DOS and UNIX separators.
	 *
	 * @param zipFile        the zip file
	 * @param subsetDirspec  the subset dirspec
	 * @param subsetFilespec the subset filespec
	 * @param isRootFile     the is root file
	 * @return the XDM zip entry
	 */
	private ZipEntry getXDMZipEntry(ZipFile zipFile, String subsetDirspec, String subsetFilespec, boolean isRootFile) {
		ZipEntry result = null;
		String zipFilespec;

		if (!isRootFile) {
			zipFilespec = XDM_PAYLOAD_ROOT + "\\" + subsetDirspec + "\\" + subsetFilespec.replace('/', '\\');
		} else {
			zipFilespec = subsetDirspec + subsetFilespec.replace('/', '\\');
		}
		result = zipFile.getEntry(zipFilespec);
		if (result == null) {
			zipFilespec = zipFilespec.replace('\\', '/');
			result = zipFile.getEntry(zipFilespec);
		}
		return result;
	}

	/**
	 * Checks if Submit Transaction Data contains a valid dataset
	 *
	 * @param submissionSetNumber number of the dataset that should be checked
	 * @return true, if SubmitTransactionData has no valid data. false otherwise.
	 */
	private boolean isSubmitTransactionDataNull(int submissionSetNumber) {
		if ((submissionSetNumber > txnData.size()) || (submissionSetNumber < 0)) {
			return true;
		} else {
			if (txnData.isEmpty()) {
				return true;
			} else {
				if (txnData.get(submissionSetNumber) == null) {
					return true;
				}
			}

		}
		return false;
	}

	/**
	 * Checks, if the zipFile was already loaded
	 */
	private void lazyLoadCheck() {
		if (txnData != null && zipFile != null && !txnData.isEmpty()) {
				loadXdmArchive();
		}
	}

	/**
	 * Reads an XDM ZIP archive, so that the contents will be accessible with the
	 * get members. You have to use this method before you can access the contents.
	 */
	@SuppressWarnings("unchecked")
	private void loadXdmArchive() {
		this.resp.setStatus(Status.SUCCESS);
		final Map<String, ProvideAndRegisterDocumentSet> results = new HashMap<>();

		try {
			final Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
			ZipEntry zipEntry = null;

			// load the descriptive files
			readmeTxt = new ReadmeTxt(zipFile.getInputStream(getXDMZipEntry(zipFile, "", XDM_README, true)));
			indexHtm = new IndexHtm(zipFile.getInputStream(getXDMZipEntry(zipFile, "", XDM_INDEX, true)));

			// load the ZIP archive into memory
			while (zipEntries.hasMoreElements()) {
				zipEntry = zipEntries.nextElement();
				if (!zipEntry.isDirectory() && zipEntry.getName().startsWith(XDM_PAYLOAD_ROOT)) {
					final String subsetDirspec = getSubmissionSetDirspec(zipEntry.getName());

					// we've found a new submission set
					if (!results.containsKey(subsetDirspec)) {

						// extract METADATA.XML
						final var metadataEntry = getXDMZipEntry(zipFile, subsetDirspec, XDM_METADATA, false);
						if (metadataEntry == null) {
							log.warn("XDM submission set folder '{}' has no metadata file: {}", subsetDirspec,
									XDM_METADATA);
						} else {
							/*
							 * final var baos = new ByteArrayOutputStream(); var bytesRead = 0; final var
							 * buffer = new byte[2048]; while ((bytesRead = in.read(buffer)) != -1) {
							 * baos.write(buffer, 0, bytesRead); }
							 */

							SubmitObjectsRequest request = null;
							try (var in = zipFile.getInputStream(metadataEntry)) {
								final var unmarshaller = JAXBContext.newInstance(SubmitObjectsRequest.class)
										.createUnmarshaller();
								unmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
								unmarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
								unmarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF8");

								request = (SubmitObjectsRequest) unmarshaller.unmarshal(in);
							}

							/*
							 * @SuppressWarnings("unused") final LCMPackage pkg =
							 * org.openhealthtools.ihe.common.ebxml._3._0.lcm.LCMPackage.eINSTANCE; final
							 * XMLResource resources = (XMLResource) (new
							 * org.openhealthtools.ihe.common.ebxml._3._0.lcm.util.LCMResourceFactoryImpl()
							 * .createResource(URI.createURI(
							 * org.openhealthtools.ihe.common.ebxml._3._0.lcm.LCMPackage.eNS_URI))); final
							 * var bais = new ByteArrayInputStream( baos.toByteArray());
							 * resources.load(bais, null);
							 */
							/*
							 * @SuppressWarnings("rawtypes") final EList list = resources.getContents();
							 * final Object o = list.get(0);
							 */

							if (request != null) {
								ProvideAndRegisterDocumentSet docSet = importXDMMetadata(request);

								for (Document xdsDocument : docSet.getDocuments()) {
									var xdsDocumentEntry = xdsDocument.getDocumentEntry();
									final String subsetFilespec = xdsDocumentEntry.getUri();
									// xdsDocumentEntry.setUri(null); // is not
									// a valid 'URI' value for a repository
									// submission

									final var docZipEntry = getXDMZipEntry(zipFile, subsetDirspec, subsetFilespec,
											false);
									if (docZipEntry != null) {
										final var docStream = zipFile.getInputStream(docZipEntry);
										var dataSource = new ByteArrayDataSource(docStream,
												xdsDocumentEntry.getMimeType());
										xdsDocument.setDataHandler(new DataHandler(dataSource));
									} else {
										log.error(
												"{} in XDM submission folder {} has XDSDocumentEntry.URI '{}' that cannot be found in ZIP",
												XDM_METADATA, subsetDirspec, xdsDocumentEntry.getUri());
									}
								}

								results.put(subsetDirspec, docSet);
							}

						}
					}
				}
			}
		} catch (final IOException e) {
			log.error("IO Error during loading of ZIP File. ", e);
			this.resp.setStatus(Status.FAILURE);
			return;
		} catch (final Exception e) {
			log.error("Exception during loading of ZIP File. ", e);
			this.resp.setStatus(Status.FAILURE);
			return;
		}

		this.txnData = results.values().stream().toList();
		documentsIntegrityCheck();
	}

	public ProvideAndRegisterDocumentSet importXDMMetadata(SubmitObjectsRequest txnData) {

		var provideAndRegisterDocumentSet = new ProvideAndRegisterDocumentSet();
		var submit = EbXML30Converters.convert(txnData);

		for (DocumentEntry documentEntry : submit.getDocumentEntries()) {
			if (documentEntry != null) {
				provideAndRegisterDocumentSet.getDocuments().add(new Document(documentEntry, null));
			}
		}

		for (Association association : submit.getAssociations()) {
			if (association != null) {
				provideAndRegisterDocumentSet.getAssociations().add(association);
			}
		}

		for (Folder folder : submit.getFolders()) {
			if (folder != null) {
				provideAndRegisterDocumentSet.getFolders().add(folder);
			}
		}

		provideAndRegisterDocumentSet.setSubmissionSet(submit.getSubmissionSet());

		// DO PMI Audit
		/*
		 * String submissionSetUniqueId =
		 * provideAndRegisterMetadata.getSubmissionSet().getUniqueId(); CX patientId =
		 * provideAndRegisterMetadata.getSubmissionSet().getPatientId();
		 * 
		 * getAuditor().auditPortableMediaImport(RFC3881EventOutcomeCodes.SUCCESS,
		 * submissionSetUniqueId, HL7V2MessageFormat.toMessageString(patientId,
		 * MessageDelimiters.COMPONENT, MessageDelimiters.SUBCOMPONENT));
		 */

		return provideAndRegisterDocumentSet;
	}

}
