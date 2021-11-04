# CDA validation

 When developing a CDA document generator, it can be helpful to have the generated CDA documents validated. This project offers three validation mechanisms.
In Husky the CDA validation is implemented in the `husky-cda-validation` module, more precisely in class [CdaValidator](javadoc/org/husky/cda/validation/api/CdaValidator.html). An example for CDA validation can be found in the tests of husky cda validation module. The class is called [ValidationTest](javadoc/org/husky/cda/validation/ValidationTest.html).

## Configuration

The CDA validation to work, it must be configured. The configuration is contained in an XML document. In this document it must be specified which schema and schematron rules are used. This configuration file must be passed when an instance of class [CdaValidator](javadoc/org/husky/cda/validation/api/CdaValidator.html) is created. An example for a configuration can be found [here](../husky-cda/husky-cda-validation/rsc/config.xml)


## Execute all validations

The method [validate](javadoc/org/husky/cda/validation/api/CdaValidator.html#validate()) performs all three validation steps in following order: 

- schema validation
- schematron validation
- PDF validation

The object returned is an instance of the class [ValidationResult](javadoc/org/husky/cda/validation/api/ValidationResult.html)

```java
var cdaVali = new CdaValidator(new File(configFilePath).getAbsoluteFile());
var testFile = cdaFilePath;
var valiRes = cdaVali.validate(new File(testFile).getAbsoluteFile());
```

## Execute Schema validation

The structure and format of CDA document can be validated by defined XML Schema Definition (XSD). This validation can be executed by the method [validateXsd](javadoc/org/husky/cda/validation/api/CdaValidator.html#validateXsd()). The object returned is an instance of the class [XsdValidationResult](javadoc/org/husky/cda/validation/api/XsdValidationResult.html)

```java
var cdaVali = new CdaValidator(new File(configFilePath).getAbsoluteFile());
var testFile = cdaFilePath_Valid;
var xsdValiRes = cdaVali.validateXsd(new File(testFile).getAbsoluteFile());
```

## Execute Schematron validation

The content and structure of CDA documents can be validated using Schematron rules. This validation can be executed by the method [validateXsd](javadoc/org/husky/cda/validation/api/CdaValidator.html#validateSch()). The object returned is an instance of the class [SchematronValidationResult](javadoc/org/husky/validation/service/schematron/result/SchematronValidationResult.html).

```java
var cdaVali = new CdaValidator(new File(configFilePath).getAbsoluteFile());
var testFile = cdaFilePath_Valid;
var schValiRes = cdaVali.validateSch(new File(testFile).getAbsoluteFile());
```

## Execute PDF validation

PDF documents can be embedded in CDA documents. The method [validateVeraPdf](javadoc/org/husky/cda/validation/api/CdaValidator.html#validateVeraPdf()) can be used to validate all embedded PDF documents. They will be validated if they are valid PDF/A documents. In this project the two following PDF validation engines are integrated:

### 3-Heights™ PDF Validator
A license is required to use [3-Heights™ PDF Validator](http://www.pdf-tools.com/pdf/pdf-validator-pdfa-validate-iso.aspx) validation engine. The object returned is an instance of the class [SchematronValidationResult](javadoc/org/husky/validation/service/pdf/PdfValidationResult.html).

- Installation
  - Install exactly the same version of PdfValidatorAPI as the VALA.jar. For the current release it must be version 5.9.4.9.
  - Install the PdfValidatorAPI in the correct platform edition (32- or 64-bit)
  - Add your license key to the license-key element in the configuration file.
  - Bind the husky with PdfValidatorAPI installation:
    - Windows:
      - Provide the VM argument `-Djava.library.path="<path to your PdfValidatorAPI.dll>"` to PdfValidatorAPI bin folder
    - Linux:
      - copy PdfValidatorAPI in /usr/lib/ directory
      - install further packages if necessary `sudo apt-get install libstdc++6 libstdc++6:i386`
      - check if the library will be loaded `ldd /usr/lib/libPdfValidatorAPI.so`
### veraPDF
[veraPDF](http://verapdf.org/) validation engine is an open source project and is thus used as standard validation engine when no lincese for Heights™ PDF Validator is available. The object returned is an instance of the class [VeraPdfValidationResult](javadoc/org/husky/validation/service/pdf/VeraPdfValidationResult.html).

```java
var cdaVali = new CdaValidator(new File(configFilePath).getAbsoluteFile());
var testFile = cdaFilePath_ValidPdf;
var veraPdfValiRes = cdaVali.validateVeraPdf(new File(testFile).getAbsoluteFile());
```
