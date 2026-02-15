# Makefile for Java Maven project

.PHONY: all run build test package clean

# The main class to run
MAIN_CLASS = com.teamsp26_1.Assignment2

all: build test

build:
	mvn compile

run:
	mvn exec:java -Dexec.mainClass=$(MAIN_CLASS)

test:
	mvn test

package:
	mvn package

clean:
	mvn clean
