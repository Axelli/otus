#!/bin/bash
echo 'Installing postgres...'
helm upgrade --install pg bitnami/postgresql -f pg/pg-helm-values.yml

echo 'Initializing db...'
kubectl apply -f initdb

echo 'Installing user-service...'
helm upgrade --install app user-service