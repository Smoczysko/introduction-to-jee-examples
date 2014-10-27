# Introduction to Java Enterprise Edition examples #

This workspace consists of Java EE 6 and 7 small examples for "Technologie Java Enterprise" lecture at the University of Gdańsk. They are categorized in different directories, one for each technology/JSR (mostly from Web Profile).

## Structure ##

Each topic (technology, JSR) has it's own directory (Maven module). In that directory there are multiple subdirectories - one for each examples (Maven sub modules). Thanks to Maven modularity each example POM file has only necessary meta information. All dependencies and plugins configurations are in main pom.xml file.

## Requirements ##

This project has very small system requirements:

* Java SE SDK 1.7 or higher
* Apache Maven 3.0 or higher

## How to run? ##

Each example is a independent JEE Maven application. All of them are build based on simple JEE application bootstrap from [introduction-to-jee-ug repository](https://github.com/Smoczysko/introduction-to-jee-ug). In order to run it navigate to its directory in command line and type:

`mvn jetty:run`

Then enter the URL [http://localhost:8080/example-artifact-id](http://localhost:8080/example-artifact-id) in web browser where `example-artifact-id` can be found in its pom.xml file.

## References ##

* "The Java EE 7 Tutorial" Oracle [http://docs.oracle.com/javaee/7/tutorial/doc/home.htm](http://docs.oracle.com/javaee/7/tutorial/doc/home.htm)
* "The Java EE 5 Tutorial" Oracle [http://docs.oracle.com/javaee/5/tutorial/doc/index.html](http://docs.oracle.com/javaee/5/tutorial/doc/index.html)
* "Chapter 6. A Multi-module Project" from "Maven by Example", Sonatype: [http://books.sonatype.com/mvnex-book/reference/multimodule.html](http://books.sonatype.com/mvnex-book/reference/multimodule.html)
* Maven Jetty Plugin: [http://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html](http://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html)

## License

Code in this repository in under Apache License, Version 2.0 ([read more](https://github.com/Smoczysko/introduction-to-jee-ug/blob/master/LICENSE)).