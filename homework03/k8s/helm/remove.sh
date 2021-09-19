#!/bin/bash
echo 'Removing app...'
helm delete app

echo 'Removing postgres...'
helm delete pg
#kubectl delete pvc $(kubectl get pvc --output=jsonpath={.items..metadata.name})

echo 'Removing conf...'
kubectl delete -f initdb/01-init-db-job-conf.yml
