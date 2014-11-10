OHT Model-Driven Health Tools (MDHT) 1.2.0 Release Notes
    https://mdht.projects.openhealthtools.org


For license information, please see about.html in this release package.

Release 1.2.0 of the OHT MDHT Project has 3 distribution packages

1. All-in-One

The all-in-one ZIP is our recommended download for both new and existing users. The ZIP archive (approximately 200MB) is for Windows and contains a complete Eclipse 3.6 workbench with MDHT plug-ins and all prerequisites installed. A pre-configured workspace is included with current copies of CDA model projects. Simply unpack the ZIP anywhere on your computer, then double-click the /eclipse/eclipse.exe command. With this all-in-one download, you will not need any of the installation instructions on the remainder of this page. This is pre-configured with our MDHT Subversion location to update models; all you'll need is a general OHT site account to login to Subversion.

2. Runtime

The runtime binaries ZIP contains JAR files with generated Java code from template models, plus all necessary EMF/OCL dependencies. The runtime distribution is for application developers who are using MDHT Java libraries created from models, not for creating or editing model specifications. The runtime distribution is divided into several different packages. There is a base (or core) package that contains CDA, HL7 Datatypes, HL7 Vocabulary, RIM, a common EMF runtime jar and all of the Eclipse runtime dependencies for EMF and OCL. This package is a required download. There are two optional packgaes. The first is the MDHT Runtime APIs for the HISTP C32 stack that includes support for HISTP, IHE PCC and CCD. The second optional package contains MDHT Runtime APIs for the new Consolidated CDA implementation guide.

3. UpdateSite

If you need to download an archive of the update site contents (due to organization firewall restrictions), download the latest update site ZIP. For most users, do not download this ZIP, but add the following URL as an Eclipse update site repository (this is pre-configured in the all-in-one):

    http://oht-modeling.sourceforge.net/updates/releases


User Documentation (User Guide and Runtime API Guide)

    https://www.projects.openhealthtools.org/sf/wiki/do/viewPage/projects.mdht/wiki/User%20Documentation

Developer Environment Setup

    https://www.projects.openhealthtools.org/sf/wiki/do/viewPage/projects.mdht/wiki/Tutorials

Demonstrations and other reference documents

    http://cdatools.org/

Defects and User Stories closed by this Release

    https://www.projects.openhealthtools.org/sf/reporting/do/viewReport/projects.mdht/reporting/report1048


Known Bugs / Limitations (Open defects as of this Release)

    https://www.projects.openhealthtools.org/sf/reporting/do/viewReport/projects.mdht/reporting/report1049


Support

Please submit questions to the MDHT Discussion Forums
    https://www.projects.openhealthtools.org/sf/discussion/do/listForums/projects.mdht/discussion


- MDHT Team