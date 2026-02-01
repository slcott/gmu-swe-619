# Makefile for Swift project

.PHONY: all run build clean

# The source file
SRC = Assignment1.swift

# The output executable name
TARGET = assignment1

all: run

run:
	swift $(SRC)

build:
	swiftc $(SRC) -o $(TARGET)

clean:
	rm -f $(TARGET)
