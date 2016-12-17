# BasketCalculator

##General comments
This program uses static map with prices and iterates over the basket to calculate overall price.
If unknown basket item is found, exception is thrown.

##Pre-requirements

1. Java 8
2. Maven 3.3

##Building application
To build application with tests, execute: 'mvn clean install'.

To generate javadocs use: 'mvn javadoc:javadoc' command

##Running application and tests
There are two wais to run application from command line:
1. By passing filename with basket products: java -jar target/RBC-1.0-SNAPSHOT.jar -f test.txt
2. By passing list of products: java -jar target/RBC-1.0-SNAPSHOT.jar Bananas Oranges 
