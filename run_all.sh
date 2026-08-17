#!/usr/bin/env bash
# ==============================================================================
# Single Command Test Runner & Markdown Diagnostic Report Generator
# Usage: ./run_all.sh
# ==============================================================================

set -e

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd "$DIR"

# Run the master python test runner
python3 run_all.py "$@"
