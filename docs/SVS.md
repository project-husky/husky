# Sharing Value Sets (SVS)

This profile provides a tool to retrieve a centrally managed nomenclature. This feature allows multiple healthcare systems to use the same nomenclature for some data such as administrative or clinical data.
In Husky the XUA profile is implemented in the `husky-valueset-gen` module, more precisely in class `ValueSetManager`.

## Retrieve value set

The transaction to retrieve value set is called [ITI-48](<https://profiles.ihe.net/ITI/TF/Volume2/ITI-48.html>). This transaction is used by the value set consumer to retrieve an value set from a repository.

An example for retrieving value set can be found in integration tests of husky `husky-valueset-gen` module. The class is called `ValueSetManagerTest`. To retrieve a set of values, you need to create an instance of `ValueSetManager`. You also need to create an instance of `ValueSetConfig`. After that, you need to download value set using method `downloadValueSet`.

```java
ValueSetConfig valueSetConfigIheSvs = ValueSetConfig.builder().withClassName(className1)
    .withProjectFolder(projectFolder).withSourceFormatType(SourceFormatType.IHESVS)
    .withSourceSystemType(sourceSystemType)
    .withSourceUrl(authorRoleSourceUrlIheSvsString).build();

URL authorRoleSourceUrlXml;
String authorRoleSourceUrlXmlString = "";
authorRoleSourceUrlXml = ValueSetManager.buildValueSetArtDecorUrl(baseUrlXml, authorRoleId,authorRoleTimeStamp);
authorRoleSourceUrlXmlString = authorRoleSourceUrlXml.toString();

ValueSetManager valueSetManager = new ValueSetManager();
ValueSet valueSetIheSvs = valueSetManager.downloadValueSet(valueSetConfigIheSvs);
```
