package org.ehealth_connector.communication.xd.xdm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

public class IndexHTM {
	
	private static Logger logService = Logger.getLogger(IndexHTM.class.getName());
	private StringBuffer str = null;
	
	public IndexHTM(SubmitTransactionData txnData){
		this(txnData, new VendorInformation());
	}
	
	/**
	 * Creates a new INDEX.HTM Object
	 * @param patientID
	 * 		Contains the PatientID as a String
	 * @param documentID
	 * 		Contains the DocumentID as a String
	 * @param documentName
	 * 		Contains the DocuementName as a String
	 */
	public IndexHTM(SubmitTransactionData txnData, VendorInformation vendorInfo){
		
		logService.debug("Creating the Index.htm file");
		
		str = new StringBuffer();
		
		str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		str.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
		str.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
		str.append("<head>\n");
		str.append("<title>eHealthConnector XDM Cross-Enterprise Document Media Interchange</title>\n");
		str.append("</head>\n");
		str.append("<body bgcolor=\"#F1FFFE\">\n");
		str.append("<div align=\"center\">\n");
		str.append("<h2>eHealthConnector - XDM Cross-Enterprise Document Media Interchange</h2>\n");
		str.append("</div>\n");
		str.append("<h3>Institution</h3>\n");
		str.append("<p>This XDM was created by: "+vendorInfo.getName()+"</p>\n");
		str.append("<p>\n");
		str.append(vendorInfo.getContactInformation());
		str.append("</p>\n");
		str.append("<h3>Contents</h3>\n");
		str.append("<p>This volume contains "+txnData.getDocList().size()+" Documents in 1 Submission Sets:</p>\n");
		str.append("<p>Patient ID: " + txnData.getSubmissionSet().getPatientId().getIdNumber() + "<br/><br/>\n");
		int i = 0;
		for (XDSDocument xdsDoc : txnData.getDocList()) {
			i++;
			str.append("Document "+i+"<br/>");
			str.append("<a href=\""+XdsUtil.createXdmDocName(xdsDoc, i) + "\">"+XdsUtil.createXdmDocName(xdsDoc, i)+"</a><br/>\n");
			str.append("DocumentEntryId: \n<code>" + xdsDoc.getDocumentEntryUUID() + "</code>\n");
			str.append("<br /></p>\n");
		}
		str.append("<h3>README File</h3>\n");
		str.append("<p>For technical details about this volume and vendor information, see: <a href=\"README.TXT\">README.TXT</a>.</p>\n");
		str.append("</body>\n");
		str.append("</html>");
	}
	
	/**
	 * Provides a index.htm as a bytearray 
	 * @return The index.htm as a bytearray
	 */
	public byte[] getIndexHTM(){
		return str.toString().getBytes();
	}
	
	/**
	 * Provides a index.htm as a file object 
	 * @param pathToFile
	 * 		Contains the path where the file should be created 
	 */
	public void writeToFile(String pathToFile){
		try {
			
			FileWriter fw = new FileWriter(new File(pathToFile));
			fw.write(str.toString());
			fw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logService.error("An Error occured. Can't find the file");
		} catch (IOException e) {
			e.printStackTrace();
			logService.error("An Error occured. Can't write/read that file");
		}
	}
}
