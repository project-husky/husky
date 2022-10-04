# Installation guide

## System requirements for building

Before you can get started, your system must meet the following requirements:

- Java JDK version 17
  You can find this version under <https://jdk.java.net/archive/>
- JAVA_HOME Environment Variable set to Java 17
- Maven (at least 3.8.x) 
  You can download under <https://maven.apache.org/download.cgi>


## Build with Maven (default)

This is the most save and correct method to build the project without having problems with the IDE and its behaviors.

### How To build
1. Open Terminal
2. Navigate to the root directory of the project
3. Start building with *mvn clean install*

If you like to skip the unit tests, you can execute the following command
*mvn clean install -DskipTests*

The build will install automatically the artifacts to your local maven repository (default ~/.m2/repository)




## Requirements for code development using IDE's
- Eclipse (at least 2021-06) or Intellij IDEA (at least 2021.2.1)
  Link to download <https://www.eclipse.org/downloads/packages/release/2021-06/r>, <https://www.jetbrains.com/idea/download/>
- Installed lombok plugin <https://projectlombok.org/>

The IDE's may give you errors or problems in context of duplicated packages in dependencies. This has to be resolved either configuring the IDE correctly or excluding maven dependencies.


## Working with eclipse
### Import project to eclipse

1. Click in eclipse on the File item in the menu bar and then click item Import...
2. Open folder maven and select Existing Maven Projects
3. Select the root directory
4. Select all pom files

### Build project

1. Right click on the project and select maven and Update Project.
2. Next, add a new Maven build configuration. Again, right-click on the project folder and select Run as and Run Configurations
3. Next, please click the button to create new maven build configuration
4. In the next window you should set your Base directory by clicking the Workspace button.
5. In the next window, select the desired directory and click OK.
6. Make sure that the goals field contains the text clean install. Click Apply and afterward Run.
