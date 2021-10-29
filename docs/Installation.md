# Installation guide

## System requirements

Before you can get started, your system must meet the following requirements:

- Java OpenJDK Version 16
  You can find this version under <https://jdk.java.net/archive/>
- JAVA_HOME Environment Variable set to Java 16
- At least Eclipse Version 2021-06 must be installed
  Link to download <https://www.eclipse.org/downloads/packages/release/2021-06/r>

## Import project to eclipse

1. Click in eclipse on the File item in the menu bar and then click item Import...
2. Open folder maven and select Existing Maven Projects
3. Select the root directory
4. Select all pom files

## Build project

1. Right click on the project and select maven and Update Project.
2. Next, add a new Maven build configuration. Again, right-click on the project folder and select Run as and Run Configurations
3. Next, please click the button to create new maven build configuration
4. In the next window you should set your Base directory by clicking the Workspace button.
5. In the next window, select the desired directory and click OK.
6. Make sure that the goals field contains the text clean install. Click Apply and afterward Run.
