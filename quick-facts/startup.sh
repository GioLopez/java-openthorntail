#!/bin/bash
docker build -t pica/quickfacts:1.0.0 .
docker run -d -e WEATHER_URL='http://weather_weather_1:8080/api/boundedcontext/v1.0/weather' --network=weather_thortail-net --rm -p 8080:8080 --name quick-facts pica/quickfacts:1.0.0