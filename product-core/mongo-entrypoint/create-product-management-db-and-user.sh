#!/usr/bin/env bash
echo "Creating product-management db and user account..."
mongo admin --eval "db.getSiblingDB('product-management').createUser({user:'product-management',pwd:'product-management',roles:[{role:'readWrite', db:'product-management'}]});"
echo "product-management db and user account created."