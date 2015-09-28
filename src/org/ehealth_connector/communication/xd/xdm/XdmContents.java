package org.ehealth_connector.communication.xd.xdm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.common.ebxml._3._0.lcm.DocumentRoot;
import org.openhealthtools.ihe.common.ebxml._3._0.lcm.LCMFactory;
import org.openhealthtools.ihe.common.ebxml._3._0.lcm.LCMPackage;
import org.openhealthtools.ihe.common.ebxml._3._0.lcm.SubmitObjectsRequestType;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.response.XDSRetrieveResponseType;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

public class XdmContents {
	private static Logger logService = Logger.getLogger(XdmContents.class.getName());

	private IndexHtm indexHtm;
	private ReadmeTxt readmeTxt;
	private VendorInformation vendorInformation;

	private ZipOutputStream out = null;
	private OutputStream outputStream = null;

	public XdmContents(IndexHtm indexHtm, ReadmeTxt readmeTxt, VendorInformation vendorInformation) {
		this.indexHtm = indexHtm;
		this.readmeTxt = readmeTxt;
		this.vendorInformation = vendorInformation;
	}

	public XdmContents(ZipFile zipFile) {
		// TODO MetadataXml, ReadmeTxt und IndexHtm im Zip File suchen (ausser
		// VendorInformation) und
		// initialisieren
	}

	public void createZip(OutputStream outputStream, SubmitTransactionData txnData) {
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
			String filePath = XdsUtil.createXdmDocName(xdsDoc, i);

			// add the document
			zip.addZipItem(xdsDoc.getStream(), filePath);
		}

		// create the other files of the volume
		IndexHtm indexHTM = new IndexHtm(txnData);
		ReadmeTxt readmeTXT = new ReadmeTxt(txnData);

		// Add them to the zip container
		zip.addZipItem(indexHTM.getInputStream(), "INDEX.HTM");
		zip.addZipItem(readmeTXT.getInputStream(), "README.TXT");
		zip.addZipItem(this.getMetadataXmlInputStream(txnData), "IHE_XDM/SUBSET01/METADATA.XML");

		zip.closeZip();
	}

	public XDSRetrieveResponseType getDocuments() {
		// TODO
		return null;
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}

	public ZipOutputStream getZipOutputStream() {
		return out;
	}

	/**
	 * Closes the inputstream. It only has to be called when no more entries
	 * will be added.
	 */
	private void closeZip() {
		try {
			out.close();
		} catch (IOException e) {
			logService.error("ZipFile could not be closed");
			e.printStackTrace();
		}
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
		// xml.getDefaultSaveOptions().put(XMLResource.OPTION_ENCODING,
		// "UTF-8");
		xml.setEncoding("UTF-8");

		return xml;
	}

	private InputStream getMetadataXmlInputStream(SubmitTransactionData txnData) {
		XMLResource xml = createMetadataXml(txnData);

		try {
			ByteArrayOutputStream bOS = new ByteArrayOutputStream();
			xml.save(bOS, null);
			return new ByteArrayInputStream(bOS.toByteArray());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
