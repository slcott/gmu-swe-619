#!/bin/bash

# This script recursively converts .ppt, .pptx, and .docx files to .pdf using LibreOffice.

# The path to the LibreOffice soffice executable
SOFFICE_PATH="/Applications/LibreOffice.app/Contents/MacOS/soffice"

# Check if soffice is available at the specified path
if [ ! -f "$SOFFICE_PATH" ]; then
    echo "Error: LibreOffice soffice not found at $SOFFICE_PATH"
    echo "Please install LibreOffice or update the SOFFICE_PATH in this script."
    exit 1
fi

# Find and convert files
find . -type f \( -name "*.ppt" -o -name "*.pptx" -o -name "*.docx" \) -print0 | while IFS= read -r -d $'\0' file; do
    echo "Converting \"$file\" to PDF..."
    "$SOFFICE_PATH" --headless --convert-to pdf "$file" --outdir "$(dirname "$file")"
done

echo "Conversion complete."
