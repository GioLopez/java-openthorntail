#!/bin/bash
docker build -t pica/weather:1.0.0 .
docker run -d --rm -p 8080:8080 --name weather pica/weather:1.0.0