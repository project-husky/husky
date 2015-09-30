package org.ehealth_connector.communication.xd.xdm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.common.ebxml._3._0.lcm.DocumentRoot;
import org.openhealthtools.ihe.common.ebxml._3._0.lcm.LCMFactory;
import org.openhealthtools.ihe.common.ebxml._3._0.lcm.LCMPackage;
import org.openhealthtools.ihe.common.ebxml._3._0.lcm.SubmitObjectsRequestType;
import org.openhealthtools.ihe.xdm.importer.PortableMediaImporter;
import org.openhealthtools.ihe.xds.consumer.response.GenericXDSRepositoryRetrieveResponseType;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.document.XDSDocumentFromStream;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.ProvideAndRegisterDocumentSetType;
import org.openhealthtools.ihe.xds.response.XDSStatusType;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

/**
 * The Class XdmContents represents all content of an XDM volume. This includes
 * human readable informative files like README.TXT or INDEX.HTM and also
 * machine readable files like METADATA.XML
 */
/**
 * @author ahel
 *
 */
public class XdmContents {

	/** The log. */
	private static Logger log = Logger.getLogger(XdmContents.class.getName());

	/** The xdm payload root. */
	static private String XDM_PAYLOAD_ROOT = "IHE_XDM";

	/** The xdm readme. */
	static private String XDM_README = "README.TXT";

	/** The xdm index. */
	static private String XDM_INDEX = "INDEX.HTM";

	/** The xdm metadata. */
	static private String XDM_METADATA = "METADATA.XML";

	/** The index htm. */
	private IndexHtm indexHtm;

	/** The readme txt. */
	private ReadmeTxt readmeTxt;

	/** The zip file. */
	private ZipFile zipFile;

	/** The txn data. */
	private SubmitTransactionData[] txnData;

	/** The OHT response object. */
	private GenericXDSRepositoryRetrieveResponseType resp;

	/**
	 * Instantiates a new xdm contents.
	 */
	public XdmContents() {
		this.resp = new GenericXDSRepositoryRetrieveResponseType();
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
		this.zipFile = zipFile;
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
	 * @param indexHtm
	 *            the index htm
	 * @param readmeTxt
	 *            the readme txt
	 */
	public void createZip(OutputStream outputStream, SubmitTransactionData txnData,
			IndexHtm indexHtm, ReadmeTxt readmeTxt) {
		this.indexHtm = indexHtm;
		this.readmeTxt = readmeTxt;
		this.txnData[0] = txnData;

		// Creating the ZipFileHelper Class
		ZipCreator zip = new ZipCreator(outputStream);

		// Add the path structure for documents in the Zip File
		try {
			zip.addZipItem(null, "IHE_XDM/");
			zip.addZipItem(null, "IHE_XDM/SUBSET01/");

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
			log.error("IO Exception during zip creation. " + e.getMessage());
		}
		this.resp.setStatus(XDSStatusType.SUCCESS_LITERAL);
	}

	/**
	 * Gets a list containing the documents together with the Document Metadata.
	 * This will be sufficient for most of the installations.
	 *
	 * @return the document and metadata list
	 */
	public List<DocumentAndMetadata> getDocumentAndMetadataList() {
		return getDocumentAndMetadataList(0);
	}

	/**
	 * Gets a list containing the documents together with the Document Metadata
	 * for a specific submission set. This will be sufficient for most of the
	 * installations.
	 *
	 * @param submissionSetNumber
	 *            the submission set number
	 * @return the document and metadata list
	 */
	public List<DocumentAndMetadata> getDocumentAndMetadataList(int submissionSetNumber) {
		SubmitTransactionData std = txnData[submissionSetNumber];
		List<DocumentAndMetadata> docAndMetaList = new ArrayList<DocumentAndMetadata>();

		for (XDSDocument xdsDoc : std.getDocList()) {
			DocumentAndMetadata docAndMetadataEntry = new DocumentAndMetadata(xdsDoc,
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
		return txnData[submissionSetNumber].getDocList();
	}

	/**
	 * Gets the index htm.
	 *
	 * @return the index htm
	 */
	public IndexHtm getIndexHtm() {
		return indexHtm;
	}

	/**
	 * Gets the readme txt.
	 *
	 * @return the readme txt
	 */
	public ReadmeTxt getReadmeTxt() {
		return readmeTxt;
	}

	/**
	 * Gets the submission set array lenght, starting with 0. If there is one
	 * submission set this method will return 0. If there is no submission set,
	 * this method will return -1
	 *
	 * @return the submission set array lenght
	 */
	public int getSubmissionSetArrayLenght() {
		if (txnData != null) {
			return txnData.length;
		} else
			return -1;
	}

	/**
	 * Gets the XDM contents as OHT submit transaction data.
	 *
	 * @return the XDM contents as OHT submit transaction data
	 */
	public SubmitTransactionData[] getXdmContentsAsOhtSubmitTransactionData() {
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
	public GenericXDSRepositoryRetrieveResponseType getXdmContentsAsOhtXdsResponseType() {
		GenericXDSRepositoryRetrieveResponseType resp = new GenericXDSRepositoryRetrieveResponseType();
		for (int i = 0; i < txnData.length; i++) {
			resp.getAttachments().addAll(txnData[i].getDocList());
		}
		return resp;
	}

	/**
	 * Reads an XDM ZIP archive, so that the contents will be accessible with
	 * the get members. You have to use this method before you can access the
	 * contents.
	 */
	@SuppressWarnings("unchecked")
	public void loadXDMArchive() {
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
			log.error("IO Error during loading of ZIP File" + e.getMessage());
			this.resp.setStatus(XDSStatusType.ERROR_LITERAL);
		} catch (Exception e) {
			log.error("Exception during loading of ZIP File" + e.getMessage());
			this.resp.setStatus(XDSStatusType.ERROR_LITERAL);
		}

		this.txnData = results.values().toArray(new SubmitTransactionData[] {});
		this.resp.setStatus(XDSStatusType.SUCCESS_LITERAL);
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
		try {
			submit = pmc.extractXDMMetadata(txnData);
		} catch (Exception e2) {
			log.error("Error during Metadata Extraction " + e2.getMessage());
			this.resp.setStatus(XDSStatusType.ERROR_LITERAL);
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
			log.error("IOException during reading the Metadata.xml InputStream " + e.getMessage());
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
}
