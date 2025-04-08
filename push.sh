#!/bin/bash

# Colors for fancy output 🎨
GREEN='\033[0;32m'
NC='\033[0m' # No Color

# Ask for commit message
echo -e "${GREEN}Enter your commit message:${NC}"
read commitMsg

# Run Git commands
git add .
git commit -m "$commitMsg"
git push origin main

echo -e "${GREEN}✅ Code pushed successfully to GitHub!${NC}"
