# README
To build use:
`mvn package`

To run use:
`./run`

To run system tests use: `./cs32-test src/test/system/stars/*.test`

To start the server use:
`./run --gui [--port=<port>]`

Onboarding

jdai15, 8 hr

Design: Star class to represent a star, CsvReader class to read csv files and find nearest neighbors, SortByDistance class to sort Stars by distance, which also implements the random aspect of naive_neighbors.

Testing: Junit tests for all methods in all classes; additional system tests for edge cases/more complex required behavior.