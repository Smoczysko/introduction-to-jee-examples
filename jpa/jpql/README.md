# Introduction to Java Enterprise Edition examples #

## JPA JPQL ##

This module covers very basic usage of Java Persistence Query Language (JPQL) API.

## Examples ##

* pagination - shows how to use Java Persistence Query Language (JPQL) to paginate entity listing (with count, limit and offset). Example uses [core/sql-load-script](../core/sql-load-script) code.
* string-search - shows how to search by string (varchar) fields in entity. Example uses [pagination](pagination) code.
* dates-search - shows how to search by Date fields in entity (after/before date and between them). Example uses [pagination](pagination) code.
* related-field-search - shows how to search by fields in related entity and to return distinct results (without repetition). Example uses [pagination](pagination) and [core/one-to-many](../core/one-to-many) codes.
* sql-queries - shows how to display (in server logs) SQL queries that JPA makes to database when using EclipseLink as JPA provider. Example uses [related-field-search](related-field-search) codes.
