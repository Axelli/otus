#!/bin/bash
helm install prom prometheus-community/kube-prometheus-stack -f prometheus.yml --atomic
helm install ingress-nginx ingress-nginx/ingress-nginx -f ingress-nginx.yml --atomic
