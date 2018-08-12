# wildfly-swarm-demo
Demo backend with wildfly, kafka streams installed, thin war application

# TODOs
- deploy against running server => map deploy dir to local dir, maybe even target
- map logs into local dir
 
## Build
see ```re.sh``` which does a build as well as run the docker container

After swarm states ```WildFly Swarm is Ready```, you can reach the app (simple ping) under (http://localhost:8080/api/v1/ping)

## Debug
Connect to the docker-machine ip (192.168.99.100) at the default port 8787
