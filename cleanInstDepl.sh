#!/bin/bash

JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64  mvn clean install javadoc:jar source:jar deploy
