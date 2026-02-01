# Makefile for Python project

# Variables
PYTHON = python3
VENV_DIR = .venv
VENV_ACTIVATE = $(VENV_DIR)/bin/activate
PIP = $(VENV_DIR)/bin/pip
PYTEST = $(VENV_DIR)/bin/pytest

.PHONY: all install test clean run

all: install test

install: $(VENV_DIR)
	@echo "Installing dependencies..."
	@$(PIP) install -r requirements.txt

$(VEND_DIR):
	@echo "Creating virtual environment..."
	@$(PYTHON) -m venv $(VENV_DIR)

test:
	@echo "Running tests..."
	@$(PYTEST)

run: install
	@echo "Running Assignment1.py..."
	@$(PYTHON) Assignment1.py

clean:
	@echo "Cleaning up..."
	@rm -rf $(VENV_DIR)
	@find . -type d -name "__pycache__" -exec rm -rf {} +
