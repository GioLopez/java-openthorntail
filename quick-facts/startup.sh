#!/bin/bash
docker build -t pica/quickfacts:1.0.0 .
docker run -d --rm -p 8080:8080 --name weather pica/quickfacts:1.0.0