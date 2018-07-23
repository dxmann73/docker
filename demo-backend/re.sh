#!/bin/bash
docker build -t dxmann73/demo-backend .

docker rm -f demo-backend || true \
    && docker run -it -p 8080:8080 -p 4848:4848 -p 8787:8787 --name demo-backend dxmann73/demo-backend
