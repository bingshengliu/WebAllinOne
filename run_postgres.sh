#!/bin/bash
docker run \
  -e POSTGRES_USER=xdra \
  -e POSTGRES_PASSWORD=Test!123 \
  -e POSTGRES_DB=xdra \
  -p 5432:5432 \
  -v pgdata:/var/lib/postgresql/data \
  -d postgres:14
