# wildfly-swarm

Wildfly Swarm capable docker image. See the [Swarm demo](https://wildfly-swarm.gitbooks.io/wildfly-swarm-users-guide/content/getting-started/basics.html)
This image exists for two reasons: 
First, I wanted to work with really thin wars and deploy kafka and other dependencies into the application server. This is not possible anymore with JBoss due to classloading changes, you need to define modules and make your app depend on those.
Second, there was an [excellent article on skinny wars](https://developers.redhat.com/blog/2017/08/24/the-skinny-on-fat-thin-hollow-and-uber/) which made me want to try WildFly Swarm finally.
So, here we are.

You need two things to use this demo:
- wildfly-swarm-kafka-fragment (a fragment containing kafka as a wildfly module)
- wildfly-swarm-demo (to produce the skinny war and hollow jar)

TODO: 
- better logging. All the kafka logs are missing from the console
- [add deployment scanner](https://www.phillip-kruger.com/post/hollowjars_deploymentscanner_and_why_wildflyswarm_is_cool/)

## Build
```
docker build -t dxmann73/wildfly-swarm .
```
## Usage
Use the image in conjunction with a skinny war file
