# Development Guidelines

## Building

* This project is set up as a maven project, so use maven to build the project.
* If you are working with IDE's like eclipse or IntelliJ use the corresponding mavenplugins.
* Never check in the IDE specific files

## Maven
### Depenendcies

* Add all dependencies to the dependencyManagement in the main pom.xml
* Use a property for version control of the dependency
* Never add submodules to the dependency management
* Never add dependencies directly to the main pom.xml

### New Modules

* If you have to add a new module choose the correct parent
* If the groupId will not change, do not define it. Maven will set it automatically from the parent. 
* Do not define a version tag. Maven will set it automatically from the parent.

## Testing
### Unit Tests

* Create always jUnit tests if possible.
* Avoid "Integrative" tests with dependency on external services
* Testdriven development will be the correct way

### Integration Test

If you have to make an integration test use the corresponding integration test project!

## Codestyle


