# Introduction to Java Enterprise Edition examples #

## JPA ##

This module covers very basic usage of Java Persistence API. It's divided into two sub modules: [Core](core) and [JPQL](jpql).

## Requirements ##

In addition to project requirements this module uses GlassFish Server Open Source Edition in 4.X version (recommended version is 4.1). Installation and JDBC resouce configuration is not in a scope of this project. Every example assumes that application server has both JDBC connection pool and resource configured (with **jsbc/hsqlapps** data source).

## HSQLDB ##

Each example in this module uses [HyperSQL Database](http://hsqldb.org) (known as HSQLDB) in in-memory mode. Because whole project is Maven-based no addition resources are required. To run it navigate in command line to [jpa](../jpa) directory and run [Exec Maven Plugin](http://mojo.codehaus.org/exec-maven-plugin) with following commands:

`mvn exec:java -Phsqldb-server`

This will run HSQLDB server in in-memory mode with database name as 'workdb'.

`mvn exec:java -Phsqldb-client`

This will run built-in HSQLDB Client application that allows to browse database in easy and convenient way.

## Scripts ##

Because this module (and its sub modules) uses stand-alone application server (GlassFish) instead of Jetty, deployment process is a bit more complicated. To simplify things in module root directory there is a **scripts** directory with Bash file that allows to build and deploy application in one command. Usage:

`./scripts/buildRedeploy.sh <module-name> <example-name>`

where <module-name> is either 'core' or 'jpql' and <example-name> is one of the example names listed in Examples section of module README file. So for example in order to run 'ejb-container' example from core module simply enter following command:

`./scripts/buildRedeploy.sh core ejb-container`

Please remember to make script file runnable.

## Running examples ##

After deploying application to server go to the browser and enter URL with following pattern:

`http://localhost:8080/<example-name>`