# Sharing Value Sets (SVS)

This profile provides a tool to retrieve a centrally managed nomenclature. This feature allows multiple healthcare systems to use the same nomenclature for some data such as administrative or clinical data.
In Husky the XUA profile is implemented in the `husky-valueset-gen` module, more precisely in class ValueSetManager.

## Retrieve value set

The transaction to retrieve value set is called [ITI-48](<https://profiles.ihe.net/ITI/TF/Volume2/ITI-48.html>). This transaction is used by the value set consumer to retrieve an value set from a repository.

An example for retrieving value set can be found in integration tests of husky `husky-valueset-gen` module. The class is called ValueSetManagerIntegrationTest. To retrieve a set of values, you need to create an instance of ValueSetManager. You also need to create an instance of ValueSetConfig. After that, you need to download value set using method downloadValueSet.

```java
String baseUrlIheSvs = "http://art-decor.org/decor/services/RetrieveValueSet?prefix=ch-epr-&format=svs";
String projectFolder = "../../common/husky-common-ch/src/main/java/org/husky/common/ch/enums";
SourceSystemType sourceSystemType = SourceSystemType.ARTDECOR_FHIR;

String className1 = "AuthorRole";
IdentificatorBaseType authorRoleId = IdentificatorBaseType.builder()
				.withRoot("2.16.756.5.30.1.127.3.10.1.1.3").build();
Date authorRoleTimeStamp = new GregorianCalendar(2018, 5, 13, 7, 40, 11).getTime();

URL authorRoleSourceUrlIheSvs;
String authorRoleSourceUrlIheSvsString = "";
authorRoleSourceUrlIheSvs = ValueSetManager.buildValueSetArtDecorUrl(baseUrlIheSvs,
				authorRoleId, authorRoleTimeStamp);
authorRoleSourceUrlIheSvsString = authorRoleSourceUrlIheSvs.toString();

// configuring the download of value sets in IHE SVS XML format
// sets the URL for downloading and specifies the class name and the folder
// where the values should be saved
ValueSetConfig valueSetConfigIheSvs = ValueSetConfig.builder().withClassName(className1)
				.withProjectFolder(projectFolder).withSourceFormatType(SourceFormatType.IHESVS)
				.withSourceSystemType(sourceSystemType)
				.withSourceUrl(authorRoleSourceUrlIheSvsString).build();

ValueSetManager valueSetManager = new ValueSetManager();
ValueSet valueSetIheSvs = valueSetManager.downloadValueSet(valueSetConfigIheSvs);
```
