# demo-backend
Demo backend with wildfly, kafka streams installed, thin war application

# TODOs
- deploy against running server => map deploy dir to local dir, maybe even target
- map logs into local dir
 
## Build
see ```buildAndRun.sh```
```
mvn clean install

docker build -t dxmann73/demo-backend .

docker rm -f demo-backend || true \
    && docker run -it -p 8080:8080 -p 4848:4848 --name demo-backend dxmann73/demo-backend
```

## Debug
Connect to the docker-machine ip (192.168.99.100) at the default port 8787
