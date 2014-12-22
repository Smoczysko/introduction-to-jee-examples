# Introduction to Java Enterprise Edition examples #

## JPA Core ##

This module covers very basic usage of Java Persistence API together with JTA, EJB and Bean Validation technologies.

## Examples ##

* crud - simple message board that shows how to build simple CRUD (Create Read Update Delete) application with basic usage of JPA.
* ejb-container - simple message board app with transactions managed by EJB container. Example uses [crud example](crud) code.
* lifecycle-events - basic showcase of PrePersist and PreUpdate events for simplifying entity storage service logic. Example uses [ejb-container](ejb-container) code.
* sql-load-script - example that shows how to load some initial database content with single one-liner in persistence.xml file. Example uses [lifecycle-events](lifecycle-events) code.
* bean-validation - basic example how to use Bean Validation features to automatically validate entity bean with JPA and give user some basic feedback. Example uses [lifecycle-events](lifecycle-events) partial code.
* one-to-one - example of how to relate one entity to one other entity (in this example, how one message can be related to just one author).
* one-to-many - example of how to relate one entity to multiple entities (in this example, how one message can be related to multiple comments).
* many-to-many - example of how to relate multiple entities to multiple entities (in this example, how one message can be related to multiple tags, and each tag can be related to multiple messages).
* element-collection - alternative relation solution to one-to-many relation with @ElementCollection annotation. Example uses [one-to-many](one-to-many) code.