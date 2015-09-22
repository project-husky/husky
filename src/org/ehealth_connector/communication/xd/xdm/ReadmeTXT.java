package org.ehealth_connector.communication.xd.xdm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

public class ReadmeTXT {
	
	private static Logger logService = Logger.getLogger(ReadmeTXT.class.getName());
	
	private StringBuffer str = new StringBuffer();
	
	
	
	/**
	 * Creates a new README.TXT Object
	 * @param patientID
	 * 		Contains the PatientID as a string
	 * @param documentID
	 * 		Contains the DocumentID as a string
	 * @param submissionSetID
	 * 		Contains the submissionSetID as a string
	 */
	public ReadmeTXT(SubmitTransactionData txnData){
		this(txnData, new VendorInformation());
	}
	
	public ReadmeTXT(SubmitTransactionData txnData, VendorInformation vendorInfo) {
		logService.debug("Creating the README.TXT file");
		
		str.append("Vendor: "+vendorInfo.getName()+"\n");
		str.append("Application: "+vendorInfo.getApplicationName()+"\n");
		str.append("Contact info: "+vendorInfo.getContactInformation()+"\n");
		str.append("\n");
//		str.append("XDS SUBSET01\n");
		str.append("Created for Patient with ID: " + txnData.getSubmissionSet().getPatientId().getIdNumber() + "\n");
//		str.append("Document.uniqueID: " + documentID + "\n");
//		str.append("Submission.uniqueID: " + submissionSetID);
	}
	
	/**
	 * Provides the readme.txt as a bytearray
	 * @return The readme.txt as a bytearray
	 */
	public byte[] getReadmeTxt(){
		return str.toString().getBytes();
	}
	
	/**
	 * Provides the readme.txt as a file object
	 * @param pathToFile
	 * 		Contains the path to where the file should be created
	 */
	public void writeToFile(String pathToFile){
		try {
			
			FileWriter fw = new FileWriter(new File(pathToFile));
			fw.write(str.toString());
			fw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logService.error("An error occured. Can't find the given file.");
		} catch (IOException e) {
			e.printStackTrace();
			logService.error("An error occured. Can't write/read that given file.");
		}
	}
	
}
