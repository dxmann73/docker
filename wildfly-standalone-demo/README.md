# wildfly-standalone-demo
Demo backend with wildfly, kafka streams installed, thin war application

# TODOs
- deploy against running server => map deploy dir to local dir, maybe even target
- map logs into local dir
 
## Build
see ```buildAndRun.sh```
```
mvn clean install

docker build -t dxmann73/wildfly-standalone-demo .

docker rm -f wildfly-standalone-demo || true \
    && docker run -it -p 8080:8080 -p 4848:4848 --name wildfly-standalone-demo dxmann73/wildfly-standalone-demo
```

## Debug
Connect to the docker-machine ip (192.168.99.100) at the default port 8787
