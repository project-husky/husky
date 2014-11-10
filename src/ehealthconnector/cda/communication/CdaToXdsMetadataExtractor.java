/**
 * 
 */
package ehealthconnector.cda.communication;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.extract.MetadataExtractionException;
import org.openhealthtools.ihe.xds.metadata.extract.cdar2.CDAR2Extractor;

import ehealthconnector.cda.documents.ch.Author;
import ehealthconnector.cda.documents.ch.CdaChVacd;

public class CdaToXdsMetadataExtractor {
	
 org.openhealthtools.mdht.uml.cda.ClinicalDocument iDoc;
	DocumentEntryType docEntry;

@SuppressWarnings("deprecation")
 public CdaToXdsMetadataExtractor (CdaChVacd doc) {
	Logger.shutdown();
	Logger.getRootLogger().setLevel(Level.OFF);	
	
	this.iDoc = doc.getDoc();
	this.docEntry = this.extract();
 }

private DocumentEntryType extract () {
	 CDAR2Extractor extractor = new CDAR2Extractor(iDoc);
		try {
			docEntry = extractor.extract();
		} catch (MetadataExtractionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("success\n"+docEntry.toString());
		return docEntry;
 }
 
 public Author extractAuthor () {
	 DocumentEntryType docEntry = this.extract(); 
	 org.openhealthtools.ihe.xds.metadata.AuthorType iAuthor= (org.openhealthtools.ihe.xds.metadata.AuthorType) docEntry.getAuthors().get(0);
	ehealthconnector.cda.documents.ch.Author author = new Author (iAuthor);
	 return author;
 }
 
 public String cGetLanguageCode () {
	return docEntry.getLanguageCode();
 }
}
