#!/bin/bash
docker run -it --rm --network host -v $(pwd):/etc/newman postman/newman run homework02.postman_collection.json
