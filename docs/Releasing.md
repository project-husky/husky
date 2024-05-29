# Releasing

The following procedure declares how to make a maven release


## Clean source

Never make a release in your working source directory where you develop code!
Checkout the source in a clean environment.

```
git clone git@github.com:project-husky/husky-integration-tests.git
```

## Maven Build

Run on the command line in the freshly cloned source directory following command

```
mvn clean install javadoc:jar source:jar
```

## Release Prepare

Maven has a built in release functionality which prepares and performs a release including tagging in the source code repository ([see Maven Release Plugin](https://maven.apache.org/maven-release/maven-release-plugin/)).
This does create the correct version number and the new working version as SNAPSHOT.

There are different possibilities to do. The simples way with a lot of prompts for inputs will be:

``` 
mvn release:prepare -Prelease
```

or with the following command you will only be prompted for the release version, the tag name and the new development version and the submodules will be automatically set to the correct version:

``` 
mvn release:prepare -DautoVersionSubmodules=true  -Prelease
```

it's also possible to set the releas version and the next development version:

``` 
mvn release:prepare -DautoVersionSubmodules=true -DdevelopmentVersion=2.0.1-SNAPSHOT -DreleaseVersion=2.0.0  -Prelease
```

If you are not sure you can make a dryRun to check if everything will go well.


## Release Perform

To build the release and deploy the artefacts to the maven repository the following command will make a clean checkout of the tag which was created in the step before and runs a build including the deploy.

therefor the executing user must have upload rights to the maven repository. the username and password have to be set in the local user maven settings (~/.m2/settings.xml) in the following way:

``` 
...
	<server>
	  <id>husky-snapshots</id>
      <username>username</username>
	  <password>password</password>
    </server>
	<server>
	  <id>husky-releases</id>
      <username>username</username>
      <password>password</password>
    </server>
...
```

## Release publish

Finally publish the release on github.com








