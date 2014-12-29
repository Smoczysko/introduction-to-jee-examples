# Introduction to Java Enterprise Edition examples #

## JAX-RS ##

This module covers very basic usage of JAX-RS API and it's default implementation - Jersey.

## Requirements ##

In addition to project requirements this module uses GlassFish Server Open Source Edition in 4.X version (recommended version is 4.1). Installation and configuration is not in a scope of this project.

## Scripts ##

Because this module uses stand-alone application server (GlassFish) instead of Jetty, deployment process is a bit more complicated. To simplify things in module root directory there is a **scripts** directory with Bash file that allows to build and deploy application in one command. Usage:

`./scripts/buildRedeploy.sh <example-name>`

where <example-name> is one of the example names listed below. So for example in order to run 'crud' example simply enter following command:

`./scripts/buildRedeploy.sh crud`

Please remember to make script file runnable.

## Examples ##

* crud - simple RESTful service for message board that shows how to build simple CRUD (Create Read Update Delete). Example is similar to [../jpa/core/crud](jpa crud) example.
* media-types - example that shows how to configure media type that REST method produces or consumes. In addition, it shows how to produce text/xml response from POJO class with simple @XmlRootElement annotation. Example uses [crud](crud) code.
* response-code - shows how to return specific response code (and message) accordingly to method and arguments. Example uses [crud](crud) code.
* client - shows how our REST resources can request data from different methods/services. Example uses [response-code](response-code) code.

## Running examples ##

After deploying application to server go to the browser and enter URL with following pattern:

`http://localhost:8080/<example-name>`