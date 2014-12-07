# Introduction to Java Enterprise Edition examples #

## JPA ##

This module covers very basic usage of Java Persistance API together with JTA, EJB and Bean Validation technologies.

## Requirements ##

In addition to project requirements this module uses GlassFish Server Open Source Edition in 4.X version (recommended version is 4.1). Installation and JDBC resouce configuration is not in a scope of this project. Every example assumes that application server has both JDBC connection pool and resource configured (with **jsbc/hsqlapps** data source).

## HSQLDB ##

Each example in this module uses [HyperSQL Database](http://hsqldb.org) (known as HSQLDB) in in-memory mode. Because whole project is Maven-based no addition resources are required. To run it navigate in command line to [jpa](../jpa) directory and run [Exec Maven Plugin](http://mojo.codehaus.org/exec-maven-plugin) with following commands:

`mvn exec:java -Phsqldb-server`

This will run HSQLDB server in in-memory mode with database name as 'workdb'.

`mvn exec:java -Phsqldb-client`

This will run built-in HSQLDB Client application that allows to browse database in easy and convenient way.

## Scripts ##

Because this module uses stand-alone application server (GlassFish) instead of Jetty, deployment process is a bit more complicated. To simplify things in module root directory there is a **scripts** directory with Bash file that allows to build and deploy application in one command. Usage:

`./scripts/buildRedeploy.sh <example-name>`

where <application-name> is one of the example names listed below. So for example in order to run 'ejb-container' example simply enter following command:

`./scripts/buildRedeploy.sh ejb-container`

Please remember to make script file runnable.

## Running examples ##

After deploying application to server go to the browser and enter URL with following pattern:

`http://localhost:8080/<example-name>`

## Examples ##

* crud - simple message board that shows how to build simple CRUD (Create Read Update Delete) application with basic usage of JPA.
* ejb-container - simple message board app with transactions managed by EJB container. Example uses [crud example](crud) code.
* lifecycle-events - basic showcase of PrePersist and PreUpdate events for simplifying entity storage service logic. Example uses [ejb-container](ejb-container) code.
* sql-load-script - example that shows how to load some initial database content with single one-liner in persistence.xml file. Example uses [lifecycle-events](lifecycle-events) code.
