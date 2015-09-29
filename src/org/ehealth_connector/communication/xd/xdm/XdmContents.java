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
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.document.XDSDocumentFromStream;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.ProvideAndRegisterDocumentSetType;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

public class XdmContents {
	private static Logger log = Logger.getLogger(XdmContents.class.getName());

	static private String XDM_DIRSPEC_SUBMISSIONROOT = "IHE_XDM";
	static private String XDM_README = "README.TXT";
	static private String XDM_INDEX = "INDEX.HTM";
	static private String XDM_METADATA = "METADATA.XML";

	private IndexHtm indexHtm;
	private ReadmeTxt readmeTxt;
	private XMLResource metadataXml;

	private ZipFile zipFile;
	private SubmitTransactionData[] txnData;

	public XdmContents() {
	}

	public XdmContents(ZipFile zipFile) {
		this.zipFile = zipFile;
	}

	public void createZip(OutputStream outputStream, SubmitTransactionData txnData,
			IndexHtm indexHtm, ReadmeTxt readmeTxt) {
		this.indexHtm = indexHtm;
		this.readmeTxt = readmeTxt;

		// Creating the ZipFileHelper Class
		ZipCreator zip = new ZipCreator(outputStream);

		// Add the path structure for documents in the Zip File
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
		metadataXml = createMetadataXml(txnData);
		zip.addZipItem(this.getMetadataXmlInputStream(), "IHE_XDM/SUBSET01/METADATA.XML");

		zip.closeZip();
	}

	public List<XDSDocument> getDocuments() {
		return getDocuments(0);
	}

	// public List<XDSDocument> getDocuments() {
	// ProvideAndRegisterDocumentSetType prType =
	// transformMetadataXmlToProvideAndRegisterDocumentType(metadataXml);
	//
	// for (int i = 0; i < prType.getDocumentEntry().size(); i++) {
	// DocumentEntryType xdsDocumentEntry = (DocumentEntryType)
	// prType.getDocumentEntry().get(
	// i);
	// String subsetFilespec = xdsDocumentEntry.getUri();
	// xdsDocumentEntry.setUri(null); // is not a valid 'URI' value for a
	// // repository submission
	// ZipEntry docZipEntry = getXDMZipEntry(zipFile, subsetDirspec,
	// subsetFilespec);
	//
	// if (docZipEntry != null) {
	// InputStream docStream = zipFile.getInputStream(docZipEntry);
	// XDSDocument xdsDocument = new XDSDocumentFromStream(
	// DocumentDescriptor.getDocumentDescriptorForMimeType(xdsDocumentEntry
	// .getMimeType()), docStream);
	// xdsDocument.setDocumentEntryUUID(xdsDocumentEntry.getEntryUUID());
	// xdsDocument.setDocumentUniqueId(xdsDocumentEntry.getUniqueId());
	// xdsDocument.setRepositoryUniqueId(xdsDocumentEntry.getRepositoryUniqueId());
	// txnData.getDocList().add(xdsDocument);
	// txnData.getMetadata().getDocumentEntry().add(EcoreUtil.copy(xdsDocumentEntry));
	// } else {
	// log.error(XDM_FILENAME_METADATA + " in XDM submission folder " +
	// subsetDirspec
	// + " has XDSDocumentEntry.URI '" + xdsDocumentEntry.getUri()
	// + "' that cannot be found in ZIP");
	// }
	// }
	//
	// }

	public List<XDSDocument> getDocuments(int submissionSetNumber) {
		return txnData[submissionSetNumber].getDocList();
	}

	public List<DocumentAndMetadata> getDocumentsAndMetadata(int submissionSetNumber) {
		SubmitTransactionData std = txnData[submissionSetNumber];
		List<DocumentAndMetadata> docAndMetaList = new ArrayList<DocumentAndMetadata>();

		for (XDSDocument xdsDoc : std.getDocList()) {
			// DocumentAndMetadata
			//
			// docAndMetaList.add(e)
		}
		return null;
	}

	public IndexHtm getIndexHtm() {
		return indexHtm;
	}

	public ReadmeTxt getReadmeTxt() {
		return readmeTxt;
	}

	public int getSubmissionSetArrayLenght() {
		return txnData.length;
	}

	public SubmitTransactionData[] getXdmContentsAsOhtSubmitTransactionData() {
		return txnData;
	}

	private XMLResource createMetadataXml(SubmitTransactionData txnData) {
		org.openhealthtools.ihe.xdm.creator.PortableMediaCreator pmc = new org.openhealthtools.ihe.xdm.creator.PortableMediaCreator();
		SubmitObjectsRequestType submit = null;
		try {
			submit = pmc.extractXDMMetadata(txnData);
		} catch (Exception e2) {
			e2.printStackTrace();
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

	private InputStream getMetadataXmlInputStream() {
		try {
			ByteArrayOutputStream bOS = new ByteArrayOutputStream();
			metadataXml.save(bOS, null);
			return new ByteArrayInputStream(bOS.toByteArray());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Given a full ZipEntry filespec, extracts the name of the folder (if
	 * present) under the IHE_XDM root specified by IHE XDM.
	 */
	private String getSubmissionSetDirspec(String zipEntryName) {
		String result = null;
		if (zipEntryName != null) {
			String[] components = zipEntryName.split("[\\\\/]");
			if (components[0].equals(XDM_DIRSPEC_SUBMISSIONROOT)) {
				result = components[1];
			}
		}
		return result;
	}

	/**
	 * Tries accessing an XDM file inside ZIP using both MS-DOS and UNIX
	 * separators
	 */
	private ZipEntry getXDMZipEntry(ZipFile zipFile, String subsetDirspec, String subsetFilespec,
			boolean isRootFile) {
		ZipEntry result = null;
		String zipFilespec;

		if (isRootFile == false) {
			zipFilespec = XDM_DIRSPEC_SUBMISSIONROOT + "\\" + subsetDirspec + "\\"
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
	 * Reads an XDM ZIP archive and returns a set of XDS submissions.
	 */
	@SuppressWarnings("unchecked")
	private void loadXDMArchive() throws Exception {
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
				if (!zipEntry.isDirectory()
						&& zipEntry.getName().startsWith(XDM_DIRSPEC_SUBMISSIONROOT)) {
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
		} finally {
		}

		this.txnData = results.values().toArray(new SubmitTransactionData[] {});
	}

	// private InputStream getFileInputStreamFromZip(ZipFile zipFile, String
	// searchFile) {
	// try {
	// // get an enumeration of the ZIP file entries
	// Enumeration<? extends ZipEntry> e = zipFile.entries();
	//
	// while (e.hasMoreElements()) {
	// ZipEntry entry = e.nextElement();
	//
	// // get the name of the entry
	// String entryName = entry.getName();
	//
	// if (entryName.toUpperCase().contains(searchFile)) {
	// return zipFile.getInputStream(entry);
	// }
	// }
	// } catch (IOException e1) {
	// e1.printStackTrace();
	// }
	// return null;
	// }

	// private ProvideAndRegisterDocumentSetType
	// transformMetadataXmlToProvideAndRegisterDocumentType(
	// XMLResource xmlResource) {
	// PortableMediaImporter pmi = new PortableMediaImporter();
	// SubmitObjectsRequestType metadata = null;
	// ProvideAndRegisterDocumentSetType pards = null;
	//
	// EList list = metadataXml.getContents();
	// DocumentRoot root = (DocumentRoot) list.get(0);
	// if (root.getSubmitObjectsRequest() != null) {
	// log.info("Casting....");
	// metadata = root.getSubmitObjectsRequest();
	// try {
	// pards = pmi.importXDMMetadata(metadata);
	// return pards;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// log.info("done");
	// } else {
	// log.error("Cannot cast input stream");
	// }
	// return null;
	// }

	// private SubmitTransactionData
	// transformProvideAndRegisterDocumentSetToSubmitTransactionData(
	// ProvideAndRegisterDocumentSetType prType) {
	//
	// PortableMediaImporter importer = new PortableMediaImporter();
	// SubmitTransactionData txnData = new SubmitTransactionData();
	// txnData.getMetadata().setSubmissionSet(EcoreUtil.copy(prType.getSubmissionSet()));
	//
	// for (int i = 0; i < prType.getDocumentEntry().size(); i++) {
	// DocumentEntryType xdsDocumentEntry = (DocumentEntryType)
	// prType.getDocumentEntry().get(
	// i);
	// String subsetFilespec = xdsDocumentEntry.getUri();
	// xdsDocumentEntry.setUri(null); // is not a valid 'URI' value for a
	// repository submission
	// ZipEntry docZipEntry = getXDMZipEntry(zipFile, subsetDirspec,
	// subsetFilespec);
	// if (docZipEntry != null) {
	// InputStream docStream = zipFile.getInputStream(docZipEntry);
	// XDSDocument xdsDocument = new XDSDocumentFromStream(
	// DocumentDescriptor.getDocumentDescriptorForMimeType(xdsDocumentEntry
	// .getMimeType()), docStream);
	// xdsDocument.setDocumentEntryUUID(xdsDocumentEntry.getEntryUUID());
	// xdsDocument.setDocumentUniqueId(xdsDocumentEntry.getUniqueId());
	// xdsDocument.setRepositoryUniqueId(xdsDocumentEntry.getRepositoryUniqueId());
	// txnData.getDocList().add(xdsDocument);
	// txnData.getMetadata().getDocumentEntry().add(EcoreUtil.copy(xdsDocumentEntry));
	// } else {
	// log.error(XDM_FILENAME_METADATA + " in XDM submission folder " +
	// subsetDirspec
	// + " has XDSDocumentEntry.URI '" + xdsDocumentEntry.getUri()
	// + "' that cannot be found in ZIP");
	// }
	// }
	//
	// results.put(subsetDirspec, txnData);
	// }
}
