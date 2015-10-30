/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
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
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.ehealth_connector.util.XdsUtil;
import org.ehealth_connector.util.ZipCreator;
import org.openhealthtools.ihe.common.ebxml._3._0.lcm.DocumentRoot;
import org.openhealthtools.ihe.common.ebxml._3._0.lcm.LCMFactory;
import org.openhealthtools.ihe.common.ebxml._3._0.lcm.LCMPackage;
import org.openhealthtools.ihe.common.ebxml._3._0.lcm.SubmitObjectsRequestType;
import org.openhealthtools.ihe.xdm.importer.PortableMediaImporter;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.document.XDSDocumentFromStream;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.ProvideAndRegisterDocumentSetType;
import org.openhealthtools.ihe.xds.response.XDSErrorCode;
import org.openhealthtools.ihe.xds.response.XDSErrorListType;
import org.openhealthtools.ihe.xds.response.XDSErrorType;
import org.openhealthtools.ihe.xds.response.XDSStatusType;
import org.openhealthtools.ihe.xds.response.impl.XDSErrorListTypeImpl;
import org.openhealthtools.ihe.xds.response.impl.XDSErrorTypeImpl;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

/**
 * The Class XdmContents represents all content of an XDM volume. This includes
 * human readable informative files like README.TXT or INDEX.HTM and also
 * machine readable files like METADATA.XML
 */
public class XdmContents {

	/** The logger. */
	private static Logger log = Logger.getLogger(XdmContents.class.getName());

	/** The xdm index. */
	private static String XDM_INDEX = "INDEX.HTM";

	/** The xdm metadata. */
	private static String XDM_METADATA = "METADATA.XML";

	/** The xdm payload root. */
	private static String XDM_PAYLOAD_ROOT = "IHE_XDM";

	/** The xdm readme. */
	private static String XDM_README = "README.TXT";

	/** The index htm. */
	private IndexHtm indexHtm;

	/** The readme txt. */
	private ReadmeTxt readmeTxt;

	/** The OHT response object. */
	private XdmRetrieveResponseTypeImpl resp;

	/** The txn data. */
	private SubmitTransactionData[] txnData;

	/** The zip file. */
	private ZipFile zipFile;

	/**
	 * Instantiates a new xdm contents.
	 */
	public XdmContents() {
		this.resp = new XdmRetrieveResponseTypeImpl();
		this.txnData = new SubmitTransactionData[] {};
	}

	/**
	 * Instantiates a new xdm contents with given INDEX.HTM and README.TXT files
	 * as according objects
	 *
	 * @param indexHtm
	 *            the IndexHtm object (contains information about the contents
	 *            of the volume)
	 * @param readmeTxt
	 *            the ReadmeTxt object (contains information about the vendor
	 *            and system that created the volume)
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
	 * @param filePath
	 *            the file path to an existing zip file, which holds the
	 *            contents of an xdm volume
	 */
	public XdmContents(String filePath) {
		this();
		try {
			this.zipFile = new ZipFile(filePath);
			if (zipFile == null)
				throw new IOException();
		} catch (IOException e) {
			this.resp.setStatus(XDSStatusType.ERROR_LITERAL);
			log.error("IO Exception during read of " + filePath, e);
		}
	}

	/**
	 * Instantiates a new xdm contents with given INDEX.HTM and README.TXT
	 * files, which will be read from given files paths.
	 *
	 * @param indexHtm
	 *            the IndexHtm object (contains information about the contents
	 *            of the volume)
	 * @param readmeTxt
	 *            the ReadmeTxt object (contains information about the vendor
	 *            and system that created the volume)
	 */
	public XdmContents(String indexHtm, String readmeTxt) {
		this();
		try {
			this.indexHtm = new IndexHtm(new FileInputStream(indexHtm));
			this.readmeTxt = new ReadmeTxt(new FileInputStream(readmeTxt));
		} catch (FileNotFoundException e) {
			this.resp.setStatus(XDSStatusType.ERROR_LITERAL);
			log.error("IO Exception during reading of INDEX.HTM and README.TXT. ", e);
		}
	}

	/**
	 * Instantiates a new xdm contents with a given XDM volume as single zip
	 * file.
	 *
	 * @param zipFile
	 *            the zip file
	 */
	public XdmContents(ZipFile zipFile) {
		this();
		try {
			if (zipFile == null)
				throw new IOException();
			else {
				this.zipFile = zipFile;
			}
		} catch (IOException e) {
			this.resp.setStatus(XDSStatusType.ERROR_LITERAL);
			log.error("IO Exception during read of ZipFile", e);
		}
	}

	/**
	 * Creates the XDM volume contents and writes them to the given
	 * outputStream.
	 *
	 * @param outputStream
	 *            the output stream, in which the contents will be written.
	 * @param txnData
	 *            the SubmitTransactionData data (containing Metadata and the
	 *            payload files themselves)
	 */
	public void createZip(OutputStream outputStream, SubmitTransactionData txnData) {
		this.txnData = new SubmitTransactionData[] { txnData };

		// Creating the ZipFileHelper Class
		ZipCreator zip = new ZipCreator(outputStream);

		// Add the path structure for documents in the Zip File
		try {
			zip.addZipItem("IHE_XDM/");
			zip.addZipItem("IHE_XDM/SUBSET01/");

			// Add each XdsDocument to the Zip File
			int i = 0;
			List<XDSDocument> docList = txnData.getDocList();
			for (XDSDocument xdsDoc : docList) {
				i++;
				String filePath = XdsUtil.createXdmDocPathAndName(xdsDoc, i);
				txnData.getDocumentEntry(xdsDoc.getDocumentEntryUUID()).setUri(
						XdsUtil.createXdmDocName(xdsDoc, i));

				// add the document
				zip.addZipItem(xdsDoc.getStream(), filePath);
			}

			// Add the necessary files to the zip container
			zip.addZipItem(indexHtm.getInputStream(), "INDEX.HTM");
			zip.addZipItem(readmeTxt.getInputStream(), "README.TXT");

			XMLResource metadataXml = createMetadataXml(txnData);
			zip.addZipItem(this.getMetadataXmlInputStream(metadataXml),
					"IHE_XDM/SUBSET01/METADATA.XML");

			zip.closeZip();
		} catch (IOException e) {
			this.resp.setStatus(XDSStatusType.ERROR_LITERAL);
			log.error("IO Exception during zip creation. ", e);
			return;
		}
	}

	/**
	 * Creates the XDM volume contents and writes them to the given File(path)
	 *
	 * @param filePath
	 *            the path to the file, in which the contents will be written.
	 * @param txnData
	 *            the SubmitTransactionData data (containing Metadata and the
	 *            payload files themselves)
	 */
	public void createZip(String filePath, SubmitTransactionData txnData) {
		File targetFile = new File(filePath);
		try {
			FileOutputStream outputStream = new FileOutputStream(targetFile);
			createZip(outputStream, txnData);
		} catch (FileNotFoundException e) {
			this.resp.setStatus(XDSStatusType.ERROR_LITERAL);
			log.error("FileNotFoundException during target file creation. ", e);
		}
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
	 * Gets a list containing the documents together with the Document Metadata
	 * for a specific submission set.
	 *
	 * @param submissionSetNumber
	 *            the submission set number
	 * @return the document and metadata list
	 */
	public List<DocumentContentAndMetadata> getDocumentAndMetadataList(int submissionSetNumber) {
		lazyLoadCheck();
		if (isSubmitTransactionDataNull(submissionSetNumber))
			return null;

		SubmitTransactionData std = txnData[submissionSetNumber];
		List<DocumentContentAndMetadata> docAndMetaList = new ArrayList<DocumentContentAndMetadata>();

		for (XDSDocument xdsDoc : std.getDocList()) {
			DocumentContentAndMetadata docAndMetadataEntry = new DocumentContentAndMetadata(xdsDoc,
					txnData[submissionSetNumber].getDocumentEntry(xdsDoc.getDocumentEntryUUID()));
			docAndMetaList.add(docAndMetadataEntry);
		}
		return docAndMetaList;
	}

	/**
	 * Gets a list of documents (the actual payload of the XDM volume)
	 *
	 * @return the documents
	 */
	public List<XDSDocument> getDocumentList() {
		return getDocumentList(0);
	}

	/**
	 * Gets a list of documents (the actual payload of the XDM volume) for a
	 * specific submission set.
	 *
	 * @param submissionSetNumber
	 *            the submission set number
	 * @return the document list
	 */
	public List<XDSDocument> getDocumentList(int submissionSetNumber) {
		lazyLoadCheck();
		if (isSubmitTransactionDataNull(submissionSetNumber))
			return null;

		return txnData[submissionSetNumber].getDocList();
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
	 * Gets the readme txt.
	 *
	 * @return the readme txt
	 */
	public ReadmeTxt getReadmeTxt() {
		lazyLoadCheck();
		return readmeTxt;
	}

	/**
	 * Gets the XDM contents as OHT submit transaction data.
	 *
	 * @return the XDM contents as OHT submit transaction data
	 */
	public SubmitTransactionData[] getXdmContentsAsOhtSubmitTransactionData() {
		lazyLoadCheck();
		return txnData;
	}

	/**
	 * Gets the XDM contents as OHT XDSResponseType. This Object contains a flat
	 * list of all documents from all submission sets. It does not contain the
	 * full XDS Metadata for each document. If you want to get this data, please
	 * use the getDocumentAndMetadata method.
	 *
	 * @return The OHT XDSResponseType
	 */
	public XdmRetrieveResponseTypeImpl getXdmContentsAsOhtXdsResponseType() {
		lazyLoadCheck();
		for (int i = 0; i < txnData.length; i++) {
			resp.setAttachments(txnData[i].getDocList());
		}
		return resp;
	}

	/**
	 * Creates the metadata xml.
	 *
	 * @param txnData
	 *            the txn data
	 * @return the XML resource
	 */
	private XMLResource createMetadataXml(SubmitTransactionData txnData) {
		org.openhealthtools.ihe.xdm.creator.PortableMediaCreator pmc = new org.openhealthtools.ihe.xdm.creator.PortableMediaCreator();
		SubmitObjectsRequestType submit = null;

		DocumentEntryType docEntry;
		String hash;
		String size;

		// Calculate Hash and Size for each document and set the information to
		// the DocumentMetadata
		for (XDSDocument xdsDoc : txnData.getDocList()) {
			try {
				docEntry = txnData.getDocumentEntry(xdsDoc.getDocumentEntryUUID());

				hash = DigestUtils.sha1Hex(xdsDoc.getStream());
				docEntry.setHash(hash);

				size = Integer.toString(IOUtils.toByteArray(xdsDoc.getStream()).length);
				docEntry.setSize(size);
			} catch (Exception e) {
				log.error("Error calculating hash and size. ", e);
				return null;
			}
		}

		try {
			submit = pmc.extractXDMMetadata(txnData);
		} catch (Exception e2) {
			log.error("Error during Metadata Extraction ", e2);
			this.resp.setStatus(XDSStatusType.ERROR_LITERAL);
			return null;
		}

		DocumentRoot docRoot = LCMFactory.eINSTANCE.createDocumentRoot();
		docRoot.setSubmitObjectsRequest(submit);

		XMLResource xml = (XMLResource) (new org.openhealthtools.ihe.common.ebxml._3._0.lcm.util.LCMResourceFactoryImpl()
		.createResource(org.eclipse.emf.common.util.URI.createURI(LCMPackage.eNS_URI)));

		xml.getContents().add(docRoot);
		xml.getDefaultSaveOptions().put(XMLResource.OPTION_DECLARE_XML, Boolean.valueOf(true));
		xml.setEncoding("UTF-8");

		return xml;
	}

	/**
	 * Checks if the integritiy values (hash and size) for the documents are the
	 * same as in the metadata.
	 *
	 * @return false, if the values don´t match, true otherwise
	 */
	private boolean documentsIntegrityCheck() {
		if (isSubmitTransactionDataNull(0))
			return false;

		DocumentEntryType docMetadata = null;
		String docHash = null;
		long docSize = 0;

		for (int i = 0; i < txnData.length; i++) {
			for (XDSDocument doc : txnData[i].getDocList()) {
				docMetadata = txnData[i].getDocumentEntry(doc.getDocumentEntryUUID());

				try {
					docHash = DigestUtils.sha1Hex(doc.getStream());
					docSize = IOUtils.toByteArray(doc.getStream()).length;
				} catch (IOException e) {
					log.error("IO Exception during zip document integrity check. ", e);
				}

				if (docMetadata.getHash() == null || !docMetadata.getHash().equals(docHash)) {
					log.warn("Integrity check failed for document hash in Submission Set: " + i
							+ " DocumentEntry with UUID: " + doc.getDocumentEntryUUID());
					this.resp.setStatus(XDSStatusType.WARNING_LITERAL);

					XDSErrorType error = new XDSErrorTypeImpl();
					error.setErrorCode(XDSErrorCode.XDS_NON_IDENTICAL_HASH_LITERAL);
					error.setLocation("Document in submission set: " + i + " with Entry UUID: "
							+ docMetadata.getEntryUUID());
					error.setValue("The hash value of the document does not match the hash value, which is provided in the document metadata.");
					error.setSeverity(XDSStatusType.WARNING_LITERAL);
					if (this.resp.getErrorList() == null) {
						XDSErrorListType errorList = new XDSErrorListTypeImpl();
						this.resp.setErrorList(errorList);
					}
					this.resp.getErrorList().getError().add(error);
					return false;
				}
				if (docMetadata.getSize() == null
						|| !docMetadata.getSize().equals(Long.toString(docSize))) {
					log.warn("Integrity check failed for document size in Submission Set: " + i
							+ " DocumentEntry with UUID: " + doc.getDocumentEntryUUID());
					this.resp.setStatus(XDSStatusType.WARNING_LITERAL);

					XDSErrorType error = new XDSErrorTypeImpl();
					error.setErrorCode(XDSErrorCode.XDS_NON_IDENTICAL_SIZE_LITERAL);
					error.setLocation("Document in submission set: " + i + " with Entry UUID: "
							+ docMetadata.getEntryUUID());
					error.setValue("The size value of the document does not match the size value, which is provided in the document metadata.");
					error.setSeverity(XDSStatusType.WARNING_LITERAL);
					if (this.resp.getErrorList() == null) {
						XDSErrorListType errorList = new XDSErrorListTypeImpl();
						this.resp.setErrorList(errorList);
					}
					this.resp.getErrorList().getError().add(error);
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Gets the metadata xml input stream.
	 *
	 * @param metadataXml
	 *
	 * @return the metadata xml input stream
	 */
	private InputStream getMetadataXmlInputStream(XMLResource metadataXml) {
		try {
			ByteArrayOutputStream bOS = new ByteArrayOutputStream();
			metadataXml.save(bOS, null);
			return new ByteArrayInputStream(bOS.toByteArray());
		} catch (IOException e) {
			log.error("IOException during reading the Metadata.xml InputStream ", e);
			this.resp.setStatus(XDSStatusType.ERROR_LITERAL);
		}
		return null;
	}

	/**
	 * Given a full ZipEntry filespec, extracts the name of the folder (if
	 * present) under the IHE_XDM root specified by IHE XDM.
	 *
	 * @param zipEntryName
	 *            the zip entry name
	 * @return the submission set dirspec
	 */
	private String getSubmissionSetDirspec(String zipEntryName) {
		String result = null;
		if (zipEntryName != null) {
			String[] components = zipEntryName.split("[\\\\/]");
			if (components[0].equals(XDM_PAYLOAD_ROOT)) {
				result = components[1];
			}
		}
		return result;
	}

	/**
	 * Tries accessing an XDM file inside ZIP using both MS-DOS and UNIX
	 * separators.
	 *
	 * @param zipFile
	 *            the zip file
	 * @param subsetDirspec
	 *            the subset dirspec
	 * @param subsetFilespec
	 *            the subset filespec
	 * @param isRootFile
	 *            the is root file
	 * @return the XDM zip entry
	 */
	private ZipEntry getXDMZipEntry(ZipFile zipFile, String subsetDirspec, String subsetFilespec,
			boolean isRootFile) {
		ZipEntry result = null;
		String zipFilespec;

		if (isRootFile == false) {
			zipFilespec = XDM_PAYLOAD_ROOT + "\\" + subsetDirspec + "\\"
					+ subsetFilespec.replace('/', '\\');
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
	 * @param submissionSetNumber
	 *            number of the dataset that should be checked
	 * @return true, if SubmitTransactionData has no valid data. false
	 *         otherwise.
	 */
	private boolean isSubmitTransactionDataNull(int submissionSetNumber) {
		if (submissionSetNumber > txnData.length || submissionSetNumber < 0) {
			return true;
		} else {
			if (txnData == null) {
				return true;
			} else {
				if (txnData.length < 0) {
					return true;
				} else {
					if (txnData[submissionSetNumber] == null) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Checks, if the zipFile was already loaded
	 */
	private void lazyLoadCheck() {
		if (txnData != null) {
			if (zipFile != null && txnData.length < 1) {
				loadXdmArchive();
			}
		}
	}

	/**
	 * Reads an XDM ZIP archive, so that the contents will be accessible with
	 * the get members. You have to use this method before you can access the
	 * contents.
	 */
	@SuppressWarnings("unchecked")
	private void loadXdmArchive() {
		this.resp.setStatus(XDSStatusType.SUCCESS_LITERAL);
		Map<String, SubmitTransactionData> results = new HashMap<String, SubmitTransactionData>();

		try {
			Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
			ZipEntry zipEntry = null;

			// load the descriptive files
			readmeTxt = new ReadmeTxt(zipFile.getInputStream(getXDMZipEntry(zipFile, "",
					XDM_README, true)));
			indexHtm = new IndexHtm(zipFile.getInputStream(getXDMZipEntry(zipFile, "", XDM_INDEX,
					true)));

			// load the ZIP archive into memory
			while (zipEntries.hasMoreElements()) {
				zipEntry = zipEntries.nextElement();
				if (!zipEntry.isDirectory() && zipEntry.getName().startsWith(XDM_PAYLOAD_ROOT)) {
					String subsetDirspec = getSubmissionSetDirspec(zipEntry.getName());

					// we've found a new submission set
					if (!results.containsKey(subsetDirspec)) {

						// extract METADATA.XML
						ZipEntry metadataEntry = getXDMZipEntry(zipFile, subsetDirspec,
								XDM_METADATA, false);
						if (metadataEntry == null) {
							log.warn("XDM submission set folder '" + subsetDirspec
									+ "' has no metadata file: " + XDM_METADATA);
						} else {
							InputStream in = zipFile.getInputStream(metadataEntry);
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							int bytesRead = 0;
							byte[] buffer = new byte[2048];
							while ((bytesRead = in.read(buffer)) != -1) {
								baos.write(buffer, 0, bytesRead);
							}
							in.close();

							@SuppressWarnings("unused")
							LCMPackage pkg = org.openhealthtools.ihe.common.ebxml._3._0.lcm.LCMPackage.eINSTANCE;
							XMLResource resources = (XMLResource) (new org.openhealthtools.ihe.common.ebxml._3._0.lcm.util.LCMResourceFactoryImpl()
							.createResource(URI
									.createURI(org.openhealthtools.ihe.common.ebxml._3._0.lcm.LCMPackage.eNS_URI)));
							ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
							resources.load(bais, null);
							@SuppressWarnings("rawtypes")
							EList list = resources.getContents();
							Object o = list.get(0);

							if (o instanceof org.openhealthtools.ihe.common.ebxml._3._0.lcm.DocumentRoot) {
								org.openhealthtools.ihe.common.ebxml._3._0.lcm.DocumentRoot docRoot = (org.openhealthtools.ihe.common.ebxml._3._0.lcm.DocumentRoot) o;
								SubmitObjectsRequestType soRequestType = docRoot
										.getSubmitObjectsRequest();

								PortableMediaImporter importer = new PortableMediaImporter();
								ProvideAndRegisterDocumentSetType prType = importer
										.importXDMMetadata(soRequestType);
								SubmitTransactionData txnData = new SubmitTransactionData();
								txnData.getMetadata().setSubmissionSet(
										EcoreUtil.copy(prType.getSubmissionSet()));

								for (int i = 0; i < prType.getDocumentEntry().size(); i++) {
									DocumentEntryType xdsDocumentEntry = (DocumentEntryType) prType
											.getDocumentEntry().get(i);
									String subsetFilespec = xdsDocumentEntry.getUri();
									// xdsDocumentEntry.setUri(null); // is not
									// a valid 'URI' value for a repository
									// submission

									ZipEntry docZipEntry = getXDMZipEntry(zipFile, subsetDirspec,
											subsetFilespec, false);
									if (docZipEntry != null) {
										InputStream docStream = zipFile.getInputStream(docZipEntry);
										XDSDocument xdsDocument = new XDSDocumentFromStream(
												DocumentDescriptor.getDocumentDescriptorForMimeType(xdsDocumentEntry
														.getMimeType()), docStream);
										xdsDocument.setDocumentEntryUUID(xdsDocumentEntry
												.getEntryUUID());
										xdsDocument.setDocumentUniqueId(xdsDocumentEntry
												.getUniqueId());
										xdsDocument.setRepositoryUniqueId(xdsDocumentEntry
												.getRepositoryUniqueId());
										txnData.getDocList().add(xdsDocument);
										txnData.getMetadata().getDocumentEntry()
										.add(EcoreUtil.copy(xdsDocumentEntry));
									} else {
										log.error(XDM_METADATA + " in XDM submission folder "
												+ subsetDirspec + " has XDSDocumentEntry.URI '"
												+ xdsDocumentEntry.getUri()
												+ "' that cannot be found in ZIP");
									}
								}

								results.put(subsetDirspec, txnData);
							}

						}
					}
				}
			}
		} catch (IOException e) {
			log.error("IO Error during loading of ZIP File. ", e);
			this.resp.setStatus(XDSStatusType.ERROR_LITERAL);
			return;
		} catch (Exception e) {
			log.error("Exception during loading of ZIP File. ", e);
			this.resp.setStatus(XDSStatusType.ERROR_LITERAL);
			return;
		}

		this.txnData = results.values().toArray(new SubmitTransactionData[] {});
		documentsIntegrityCheck();
	}
}
