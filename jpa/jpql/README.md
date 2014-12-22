# Introduction to Java Enterprise Edition examples #

## JPA JPQL ##

This module covers very basic usage of Java Persistence Query Language (JPQL) API.

## Examples ##

* pagination - shows how to use Java Persistence Query Language (JPQL) to paginate entity listing (with count, limit and offset). Example uses [core/sql-load-script](../sql-load-script) code.
* string-search - shows how to search by string (varchar) fields in entity. Example uses [pagination](pagination) code.
* dates-search - shows how to search by Date fields in entity (after/before date and between them). Example uses [pagination](pagination) code.
* related-field-search - shows how to search by fields in related entity and to return distinct results (without repetition). Example uses [pagination](pagination) and [core/one-to-many](../one-to-many) codes.
